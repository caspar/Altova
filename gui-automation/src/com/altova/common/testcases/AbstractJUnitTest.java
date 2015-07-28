package com.altova.common.testcases;

import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;
import static com.altova.util.LoggerUtils.logger;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.runner.RunWith;

import com.altova.robots.AltovaApplicationRobot;
import com.altova.robots.ApplicationCrashedException;
import com.altova.robots.ScriptMistakeException;
import com.altova.umodel.regression.gui.EclipseUModelRobot;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.IOUtils;
import com.altova.util.RegressionAssert;
import com.altova.util.Settings;
import com.altova.util.SuiteLogLevel;

@RunWith(AltovaJUnitRunner.class)
public abstract class AbstractJUnitTest extends RegressionAssert {

	private static AltovaApplicationRobot robot;
	
	public static boolean runBeforeAfterClass = Boolean.parseBoolean(Settings.getProperty("runBeforeAfterClass", "true"));
	
	protected AbstractJUnitTest() {
		
	}
	
	public static void setUpBeforeClass(AltovaApplicationRobot robot) throws Exception {
		logger.log(SuiteLogLevel.SUITE, getRunName(robot));
		AbstractJUnitTest.robot = robot;
		startApp();
	}

	private static void startApp() {
		//robot.deleteApplicationRegistryKeys();
		if(runBeforeAfterClass) {
			robot.deleteSettingsRegistryKeys();
			robot.activateApplication();
			robot.maximizeWindow();
		}
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		if(runBeforeAfterClass) {
			//try three times
			for (int i = 0; i < 3 && robot.isApplicationRunning(); i++) {
				logger.fine("Trying to exit application after test was finished");
				try {
					robot.exitApplication();
				} catch(ScriptMistakeException e) {
					logger.warning("Failed to click exit for some reason: "+e);
				}
				robot.delay(15000);
				robot.keyType(KeyEvent.VK_ESCAPE); robot.delay(500);
			}
		}
	}

	@Before
	public void setUp() throws Exception {
		logger.log(SuiteLogLevel.TEST, RegressionAssert.getTestName());
		
		if(!robot.isApplicationRunning()) {
			startApp();
		}
		
		//it seems this is only required for UModel,
		//however if other Eclipse plugins also lose focus after a test,
		//robot instanceof EclipseRobot could be used instead. 
		if(robot instanceof EclipseUModelRobot) {
			robot.activateApplication();
		}
	}
	
	@After
	public void tearDown() throws Exception {
		logger.finer("Checking if the application crashed or not - just in case...");
		
		boolean crashed = false;
		String msg = "";

		//try to escape crash dialog 5 times
		for (int i = 0; i < 2; i++) {
			try {
				delay(6000);
				robot.checkCrash();
				break;
			} catch(ApplicationCrashedException e) {
				crashed = true;
				e.printStackTrace();
				logger.severe("Crash detected in tearDown(): "+e);
				msg += IOUtils.getStackTrace(e);
				msg += "\n";
			}
		}
		
		if(crashed) {
			throw new ApplicationCrashedException(msg);
		}
	}

	protected void delay(int ms) {
		robot.delay(ms);
	}
	
	protected void assertWindowAndEscape() {
		delay(15000);
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(KeyEvent.VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
	}

	protected void assertWindowAndEscape(String testname) {
		delay(4000);
		try {
			assertAreas(testname,TOP_WINDOW);
		} finally {
			robot.keyType(KeyEvent.VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
	}

	
	protected void removeAndAssert(File file) {
		if (file != null){
			if(file.exists()) {
				file.delete();
			}
			assertFileNotExists(file);
		}
	}
	
	public static AltovaApplicationRobot getRobot() {
		return robot;
	}
	

}
