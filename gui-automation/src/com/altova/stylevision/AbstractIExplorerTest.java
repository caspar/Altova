package com.altova.stylevision;

import static com.altova.util.LoggerUtils.logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import com.altova.robots.IExplorerRobot;
import com.altova.util.RegressionAssert;
import com.altova.util.SuiteLogLevel;


public class AbstractIExplorerTest extends RegressionAssert {

	protected static IExplorerRobot robot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new IExplorerRobot();
		}
		robot.startApplication();
		robot.maximizeWindow();
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
		robot.closeAltF4();
	}
	
	@Before
	public void setUp() throws Exception {
		logger.log(SuiteLogLevel.TEST, RegressionAssert.getTestName());
		//super.setUp();
	}

	
	public static void setRobot(IExplorerRobot robot) {
		AbstractIExplorerTest.robot = robot;
	}
	
	
	
}
