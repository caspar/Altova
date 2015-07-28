package com.altova.spy;

import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.common.testcases.AbstractHelpMenuTest;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;

//@TestRobot(EclipseSpyRobot.class)
public class HelpMenuTest extends AbstractHelpMenuTest {

	private static SpyRobot robot;
	
	private final String KEYBOARD_MAP = "Help Keyboard";
	
	protected final String BROWSERWebTraining = "Altova Online Training Overview";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new SpyRobot();
		}
		
		AbstractHelpMenuTest.setUpBeforeClass(robot);
		robot.openFile(AbstractXmlSpyTest.ORGCHART_XML_FILE);
	}
	
	@Test
	public final void testKeyboardMap() {
		robot.keyboardMap();
		assertAndClose(KEYBOARD_MAP);
	}
	
	@Test
	public final void testWebTraining() {
		robot.webTraining();
		assertAndClose(BROWSERWebTraining);
	}

	public static void setRobot(SpyRobot robot) {
		HelpMenuTest.robot = robot;
	}
}
