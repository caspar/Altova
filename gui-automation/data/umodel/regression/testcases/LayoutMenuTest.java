package com.altova.umodel.regression.testcases;

import static com.altova.util.LoggerUtils.logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import com.altova.robots.ScreenDiff;
import com.altova.umodel.regression.gui.EclipseUModelRobot;
import com.altova.umodel.regression.gui.LayoutOperation;
import com.altova.umodel.regression.gui.UModelRobot;
import com.altova.umodel.regression.gui.VSnetUModelRobot;
import com.altova.util.NamedParameterizedRunner;
import com.altova.util.SuiteLogLevel;

/**
 * 
 * @author Havard Rast Blok
 *
 */
//@RunWith(value = Parameterized.class)
@RunWith(value = NamedParameterizedRunner.class)

public class LayoutMenuTest extends AbstractUmodelTest {
	
	// Alternative way to force robot used,
	// since the @TestRobot annotation does not work with Parameterized or NamedParameterizedRunner 
	
//	static {
//		AbstractUmodelTest.robot = new EclipseUModelRobot();
//	}
	

	protected LayoutOperation operation;
	
	static final String CLASS_DIAGRAM = "BankView Main";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.log(SuiteLogLevel.SUITE, "LayoutMenuTest");
		AbstractUmodelTest.setUpBeforeClass();
	}

	
	public LayoutMenuTest(LayoutOperation operation) {
		this.operation = operation;
		logger.log(SuiteLogLevel.TEST, operation.toString());
	}

	@Parameters
	public static Collection data() {
		Collection<Object> ans = new ArrayList<Object>();
		for(LayoutOperation op : EnumSet.allOf(LayoutOperation.class)) {
			ans.add(new Object[]{op});
		}
		return ans;
	}


	@Test
	public final void testLayout() {
		robot.openDiagram(CLASS_DIAGRAM);
		robot.zoom(80);
		robot.selectAll();
		//in these two special cases, no differences will be detected,
		//because the diagram is already in these states. Therefore, we'll first make it different
		if(operation == LayoutOperation.LINE_ORTHOGONAL) {
			robot.layout(LayoutOperation.LINE_DIRECT);
		} else if(operation == LayoutOperation.SPACE_DOWN) {
			robot.layout(LayoutOperation.LINEUP_VERTICALLY);
			robot.layout(LayoutOperation.SAME_SIZE_HEIGHT);
		} else if(operation == LayoutOperation.SPACE_ACROSS) {
			robot.layoutSameSize();
		}
		ScreenDiff diff = new ScreenDiff(robot);
		diff.snapBefore(robot.getMainWindow());
		if(operation != LayoutOperation.SAME_SIZE_WIDTH_HEIGHT){
		robot.layout(operation);
		}else{
			robot.layoutSameSize();
		}
		diff.snapAfter();
		assertNotNull("Asserting that something changed after the layout operation: "+operation, diff.diffBounds() );
		//assertAreas("testLayout_"+operation, DIAGRAM_MAIN_WINDOW);
	}

}
