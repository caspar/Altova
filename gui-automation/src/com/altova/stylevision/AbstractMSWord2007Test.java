package com.altova.stylevision;

import static com.altova.util.LoggerUtils.logger;

import java.awt.event.KeyEvent;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import com.altova.robots.MSWord2007Robot;
import com.altova.robots.ScriptMistakeException;
import com.altova.util.RegressionAssert;
import com.altova.util.SuiteLogLevel;


public class AbstractMSWord2007Test extends RegressionAssert {

	protected static MSWord2007Robot robot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new MSWord2007Robot();
		}
		robot.startApplication();
		robot.maximizeWindow();
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
		robot.closeAltF4();
		//try three times
		for (int i = 0; i < 3 && robot.isApplicationRunning(); i++) {
			logger.fine("Trying to exit application after test was finished");
			try {
				robot.exitApplication();
			} catch(ScriptMistakeException e) {
				logger.warning("Failed to click exit for some reason: "+e);
			}
			robot.delay(5000);
			robot.keyType(KeyEvent.VK_ESCAPE); robot.delay(500);
		}
	}
	
	@Before
	public void setUp() throws Exception {
		logger.log(SuiteLogLevel.TEST, RegressionAssert.getTestName());
		//super.setUp();
	}

	
	public static void setRobot(MSWord2007Robot robot) {
		AbstractMSWord2007Test.robot = robot;
	}
	
	
	
}
