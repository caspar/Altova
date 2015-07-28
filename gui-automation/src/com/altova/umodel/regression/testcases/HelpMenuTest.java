package com.altova.umodel.regression.testcases;

import static com.altova.umodel.regression.testcases.AbstractUmodelTest.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.common.testcases.AbstractHelpMenuTest;
import com.altova.umodel.regression.gui.EclipseUModelRobot;
import com.altova.umodel.regression.gui.UModelRobot;
import com.altova.util.AltovaJUnitRunner.TestRobot;
//@TestRobot(EclipseUModelRobot.class)
public class HelpMenuTest extends AbstractHelpMenuTest {

	private static UModelRobot robot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new UModelRobot();
		}
		
		AbstractHelpMenuTest.setUpBeforeClass(robot);
		robot.openPrj(BANK_UMP_FILE.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM);
	}
	
	@Test
	public final void testDummyMethod() {

	}

	public static void setRobot(UModelRobot robot) {
		HelpMenuTest.robot = robot;
	}
}
