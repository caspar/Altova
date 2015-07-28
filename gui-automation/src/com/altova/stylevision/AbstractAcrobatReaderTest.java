package com.altova.stylevision;

import static com.altova.util.LoggerUtils.logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import com.altova.robots.AcrobatReaderRobot;
import com.altova.util.RegressionAssert;
import com.altova.util.SuiteLogLevel;


public class AbstractAcrobatReaderTest extends RegressionAssert {

	protected static AcrobatReaderRobot robot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new AcrobatReaderRobot();
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

	
	public static void setRobot(AcrobatReaderRobot robot) {
		AbstractAcrobatReaderTest.robot = robot;
	}
	
	
	
}
