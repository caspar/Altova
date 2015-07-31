package com.altova.umodel.regression.testcases;

import static com.altova.robots.SnapshotArea.CommonArea.*;
import static com.altova.util.LoggerUtils.logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.umodel.regression.gui.EclipseUModelRobot;
import com.altova.umodel.regression.gui.VSnetUModelRobot;
import com.altova.util.Settings;
import com.altova.util.SuiteLogLevel;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;

//@TestRobot(VSnetUModelRobot.class)
public class WindowMenuTest extends AbstractUmodelTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.log(SuiteLogLevel.SUITE, "WindowMenuTest");
		AbstractUmodelTest.setUpBeforeClass();
		if(robot.isApplicationRunning()) {
			robot.exitWithuotSave();
			AbstractJUnitTest.setUpBeforeClass(robot);
		}
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		robot.openDiagram(CLASS_DIAGRAM);
		robot.openDiagram(COMPONENT_DIAGRAM);
	}
	
	@IgnoreRobots({VSnetUModelRobot.class})
	@Test
	public final void testCascadeDiagrams() {
		robot.windowCascade();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@IgnoreRobots({VSnetUModelRobot.class})
	@Test
	public final void testTileHorizontally() {
		robot.windowTileHorizontally();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@IgnoreRobots({VSnetUModelRobot.class})
	@Test
	public final void testTileVertically() {
		robot.windowTileVertically();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Ignore
	@Test
	public final void testArangeIcons() {
		robot.arangeIcons();
		assertAreas(TOP_WINDOW);
	}

	@Test
	public final void testCloseDiagram() {
		robot.closeDiagram();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testCloseAllDiagrams() {
		robot.closeAllDiagrams();
		if(!Settings.isVS2010()){//these steps cannot/should not be done for VS2010
		assertNull(robot.getDiagramComponent());
		}
	}

	@IgnoreRobots({VSnetUModelRobot.class})
	@Test
	public final void testCloseAllButActiveDiagrams() {
		robot.closeAllButActiveDiagrams();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@IgnoreRobots({VSnetUModelRobot.class})
	@Test
	public final void testForwardToNextDiagram() {
		robot.backToPreviousDiagram(); delay(500);
		robot.forwardToNextDiagram();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@IgnoreRobots({VSnetUModelRobot.class})
	@Test
	public final void testBackToPreviousDiagram() {
		robot.backToPreviousDiagram();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

}
