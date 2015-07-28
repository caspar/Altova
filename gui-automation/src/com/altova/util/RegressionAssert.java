package com.altova.util;

//Example in com.altova.common.testcases.UsingRegressionAssert: debugg it to see names 

import static com.altova.robots.SnapshotArea.CommonArea.*;
import static com.altova.umodel.regression.gui.UModelRobot.*;
import static com.altova.util.LoggerUtils.logger;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.mapforce.MapForceRobot;
import com.altova.nativegui.ComponentInfo;
import com.altova.nativegui.NativeGUI;
import com.altova.robots.AltovaApplicationRobot;
import com.altova.robots.ImageFileDiff;
import com.altova.robots.ScriptMistakeException;
import com.altova.robots.SnapshotArea;
import com.altova.umodel.regression.gui.UModelRobot;

/**
 * Convenience methods for asserting screen and application specific files.
 * 
 * This class includes a few standard assert types, with the most involved on
 * being the image or area assert methods. Typically this includes a call to
 * <ol>
 * <li>{@link RegressionAssert#assertAreas(SnapshotArea[])}, which gets the
 * test name and forwards to</li>
 * <li>{@link RegressionAssert#assertAreas(String, SnapshotArea[])}, which
 * gets the default robot for the application under test, and forwards to</li>
 * <li>{@link RegressionAssert#assertAreas(AltovaApplicationRobot, String, SnapshotArea[])},
 * which calls assertScreen for each for the areas to assert</li>
 * <li>{@link RegressionAssert#assertScreen(AltovaApplicationRobot, String, SnapshotArea)}
 * takes a snapshot of the specified areas, and</li>
 * <li> {@link RegressionAssert#assertImage(ImageFileDiff)} compares the output
 * and expected image which will make the test case succeed or fail</li>
 * </ol>
 * 
 * <p>
 * The screen shot is saved in the predefined output directory, and compared to
 * the file in the predefined expected directory. See the {@link Settings} class
 * for details about these directory settings.
 * <p>
 * The actual image file name for each test case is an automatically generated
 * composite based on the application under test, the test suite (class name),
 * the test case (method name), and {@link SnapshotArea}.
 * <p>
 * Most of this is possible to override through other assert method calls in
 * this class, however the most common override, will probably be the method
 * name. Typically, only one image assert is required per test method, so the
 * method name is enough to distinighs the test case. However, if more than one
 * call to assertAreas is require within one test method,
 * {@link RegressionAssert#assertAreas(String, SnapshotArea[])}, should be
 * used. Here you can specify a unique name, which would typically include the
 * test method name, and some other description of that point in the test case.
 * 
 * @author Havard Rast Blok
 * 
 */
public class RegressionAssert extends Assert {

	private static final String thisClassName = RegressionAssert.class.getName();
	
	private static int testNameId = 0;
	
	/**
	 * Asserts that the specified file exists.
	 * @param file the file to be checked
	 */
	public static void assertFileExists(File file) {
		assertNotNull("File/path is null", file);
		assertTrue("Does file exist? '"+file+"'", file.exists());
	}
	
	/**
	 * Asserts that the specified file does NOT exist.
	 * @param file the file name to be checked. 
	 */
	public static void assertFileNotExists(File file) {
		assertNotNull("File/path is null", file);
		assertFalse("Does file not exist? '"+file+"'", file.exists());
	}
	
	
	/**
	 * Asserts that the two specified files are equal. A threshold of 30 pixels
	 * is used, which means that if less than 30 pixels are different, the two
	 * images will be considered equal.
	 * 
	 * Furthermore, if the "dry run" parameter is set, the assert will not be
	 * carried out. This is useful for generating new images for no expected
	 * images exist already.
	 * 
	 * @param expected
	 *            the previously stored expected image
	 * @param actual
	 *            the newly created screen shot
	 */
	public static void assertImage(File expected, File actual) {
		ImageFileDiff diff = new ImageFileDiff(actual, expected);
		assertImage(diff);
	}
	
	/**
	 * Asserts that the two files in the specified {@link ImageFileDiff} are
	 * equal. A threshold of 30 pixels is used, which means that if less than 30
	 * pixels are different, the two images will be considered equal.
	 * 
	 * Furthermore, if the "dry run" parameter is set, the assert will not be
	 * carried out. This is useful for generating new images for no expected
	 * images exist already.
	 * 
	 * @param diff
	 *            reference to the images to compare
	 */
	public static void assertImage(ImageFileDiff diff) {
		if(!Settings.isJUnitDryRun()) {
			ImageFileDiff.pixelDifferenceThreshold = 30;
			boolean difference = diff.diff();
			assertFalse("Expected and actual images differ: "+diff.toStringLinks(), difference);
		} else {
			logger.warning("Not running image compare. JUnitDryRun is set to true");
		}
		
	}
	
	/**
	 * Returns the element from the stack trace which represents the method
	 * which initiated the assert call. This is sometimes used to determine the
	 * test case (method) name and test suite (class) name.
	 * 
	 * @param classOnly
	 *            true if we're only interested in the class name where the
	 *            assert called came from, and not the specific method
	 * @return stack trace element for the current test case
	 */
	private static StackTraceElement getTestMethodOnStack(boolean classOnly) {
		ScriptMistakeException e = new ScriptMistakeException();
		StackTraceElement stack[] = e.getStackTrace();

		// let's search for the first method which is not in this class,
		// and start its name with "test"
		for (StackTraceElement method : stack) {
			String className = method.getClassName();
			if (className.equals(thisClassName)) {
				continue;
			}

			String methodName = method.getMethodName();
			if (methodName.startsWith("test")) {
				return method;
			}
			
			if(classOnly && className.toLowerCase().indexOf("abstract") == -1) {
				return method;
			}
		}
		
		return null;
	}
	
	/**
	 * Returns the name of the test case which (indirectly) called this method
	 * (e.g. through some of the assert methods in this class). The name can be
	 * retrieved in two ways, and if these two failed, a unique name is
	 * constructed:
	 * <ol>
	 * <li>Check the {@link AltovaJUnitRunner} to see which JUnit test case is
	 * running. This will only work if the {@link AltovaJUnitRunner} was
	 * specified as the runner for the test suite.</li>
	 * <li>If AltovaJUnitRunner did not store a test name, investigate the
	 * method call stack, and try to find the name of the test method where the
	 * assert call came from.</li>
	 * <li>If this also failed, make a temporary unique name. No tests should
	 * be based on this, but at least it will not stop the full test run.</li>
	 * </ol>
	 * 
	 * @return a unique name for the test case, based on the method which called
	 *         the assert
	 * @see AltovaJUnitRunner
	 */
	public static String getTestName() {
		//first see if we're using the AltovaJUnitRunner and can get the name from there
		String junitTest = AltovaJUnitRunner.getCurrentTestName();
		if(junitTest != null) {
			return junitTest;
		}
		
		//if not, let's try to look at the call stack, for a test method
		StackTraceElement stackTest = getTestMethodOnStack(false);
		if(stackTest != null) {
			return stackTest.getMethodName();
		}
		
		//if that also fails, let's try to make up a name
		logger.warning("Have to make up name for basename of test."+
						"You might want to use @RunWith(AltovaJUnitRunner.class) or specify the test name explicitly");
		String genericName = "test"+testNameId;
		testNameId++;
		return genericName;
	}
	
	/**
	 * Returns a unique name for the test run (or suite), based on the test
	 * class and the product under test. This is concatenated into a path
	 * fragment, so that each product gets its own directory, and each test
	 * class gets its own sub directory. There are two ways to retrieve the
	 * suite/run name, and if both fail, a temporary unique name is constructed:
	 * <ol>
	 * <li>Check the {@link AltovaJUnitRunner} for the current suite.</li>
	 * <li>If this fails, check the call stack, and get the name a class which
	 * is not abstract.</li>
	 * <li>If this also fails, construct a temporary name. The test should not
	 * rely on this, but at least it will not stop the whole run.</li>
	 * </ol>
	 * 
	 * @return a unique name for the suite/class which called the assert method.
	 */
	public static String getRunName(AltovaApplicationRobot robot) {
		//first see if we're using the AltovaJUnitRunner and can get the name from there
		String junitRun = AltovaJUnitRunner.getCurrentRunName(robot);
		if(junitRun != null) {
			return junitRun;
		}
		
		//if not, let's try to look at the call stack, for a test method
		StackTraceElement stackClass = getTestMethodOnStack(true);
		if(stackClass != null) {
			return AltovaJUnitRunner.getRunName(robot, stackClass.getClassName());
		}
		
		//if that also fails, let's try to make up a name
		logger.warning("Have to make up name for run name of test. "+
						"You might want to use @RunWith(AltovaJUnitRunner.class)");
		String genericName = "product"+File.separator+"run";
		return genericName;
	}
	
	/**
	 * Returns the robot which is used to run the product under test. This can
	 * be achieved in to ways:
	 * <ol>
	 * <li>If the {@link AltovaJUnitRunner} was used, get the assigned robot
	 * from there.</li>
	 * <li>If that contains no robot, look at the package where the test suite
	 * class is, and compare that to the
	 * {@link AltovaApplicationRobot#getKnownProducts()} strings.</li>
	 * </ol>
	 * 
	 * @return the robot object which is used to run the current test.
	 */
	private static AltovaApplicationRobot getTestRobot() {
		AltovaApplicationRobot robot = AbstractJUnitTest.getRobot();
		if(robot != null) {
			return robot;
		}
		
		//seems like AbstractJUnitTest was not used
		//let see if we can find out which robot to use from the package name
		StackTraceElement stackClass = getTestMethodOnStack(true);
		if(stackClass != null) {
			String product = AltovaJUnitRunner.getProductPackage(stackClass.getClassName());
			if(product != null) {
				return AltovaApplicationRobot.getProductRobot(product);
			}
		}
		
		throw new ScriptMistakeException("Could not determine which robot to use for assert and screen snapshot."+
										 "You might consider using of the the subclasses of AbstractJUnitTest for your test.");
	}
	
	/**
	 * Asserts the specified areas by taking a new screen shot of each, and
	 * comparing them to already existing images in the expected directory.
	 * <p>
	 * The output file name and location will be a composite based on the
	 * application under test, the test suite (class name), the test case
	 * (method name), and {@link SnapshotArea}.
	 * 
	 * @param areas
	 *            list of areas to assert against existing images
	 */
	public static void assertAreas(SnapshotArea... areas) {
		String testName = getTestName();
		assertAreas(testName, areas);
	}

	/**
	 * Asserts the specified areas, and using the specified string as a unique
	 * test case name. The robot used to carry out the assert, is retrieved from
	 * the {@link RegressionAssert#getTestRobot()} method.
	 * <p>
	 * The output file name and location will be a composite based on the
	 * application under test, the test suite (class name), the specified
	 * testName, and {@link SnapshotArea}.
	 * 
	 * @param testName
	 *            unique name for the test case(s). A good ideas is to use the
	 *            test method name plus something which describes the point in
	 *            the test case to assert.
	 * @param areas
	 *            list of areas to assert against existing images
	 */
	public static void assertAreas(String testName, SnapshotArea... areas) {
		assertAreas(getTestRobot(), testName, areas);
	}
	
	/**
	 * Asserts the specified areas, and using the specified string as a unique
	 * test case name, and the specified robot to carry out the assert. For each
	 * of the areas, a screen shot is taken, and compared to the already
	 * existing expected image.
	 * <p>
	 * The output file name and location will be a composite based on the
	 * application under test, the test suite (class name), the specified
	 * testName, and {@link SnapshotArea}.
	 * 
	 * @param robot
	 *            the robot which will be used to make the areas active, make
	 *            the screen shot, and so on
	 * @param actualBasename
	 *            unique name for the test case(s).
	 * @param areas
	 *            list of areas to assert against existing images
	 */
	private static void assertAreas(AltovaApplicationRobot robot, String actualBasename, SnapshotArea... areas) {
		for(SnapshotArea area : areas) {
			String areaName = area.toString().toLowerCase().replace(' ', '_');
			String specificBaseName = getRunName(robot)+File.separator+actualBasename+"_"+areaName;
			assertScreen(robot, specificBaseName, area);
		}
	}
	
	/**
	 * Asserts the message window for UModel by 1) taking a screen shot, and 2)
	 * checking that no error messages exist in the window.
	 * 
	 * @param robot the instance of the {@link UModelRobot} which is used to drive the UModel test
	 */
	public static void assertUModelMessageWindow(UModelRobot robot) {
		assertAreas(MESSAGES);
		robot.checkMessageWindow();
	}
	
	/**
	 * Asserts the message window for MapForce by 1) taking a screen shot, and 2)
	 * checking that no error messages exist in the window.
	 * 
	 * @param robot the instance of the {@link MapForceRobot} which is used to drive the MapForce test
	 */
	public static void assertMapForceMessageWindow(MapForceRobot robot) {
		assertAreas(MESSAGES);
		robot.checkMapForceMessageWindow();
	}
	
	/**
	 * Assert one area by tacking a screen shot and comparing against an
	 * expected image. Here, the specificBaseName is the actual name and
	 * relative location of the image. It is relative to the predefined output
	 * and expected directory settings. See the {@link Settings} class for
	 * details about these directory settings.
	 * 
	 * @param robot
	 *            the robot which will be used to make the areas active, make
	 *            the screen shot, and so on
	 * @param specificBaseName
	 *            the actual name and location of the output file, relative to
	 *            the output directory
	 * @param area the single area to get a screen shot of
	 */
	private static void assertScreen(AltovaApplicationRobot robot, String specificBaseName, SnapshotArea area) {
		logger.log(SuiteLogLevel.STEP, "Saving screen");
		String fullscreen = specificBaseName+"_final";
		
		try {
			File output = robot.snapShot(area, specificBaseName);
			robot.snapShot(FULLSCREEN, fullscreen); 		
   			
			
			if(Settings.isJUnitDryRun()) {
				logger.warning("Not running image compare. JUnitDryRun is set to true");
				return;
			}
			
			//if the sizes of the actual and expected images differ, do the snapshot twice
			robot.delay(3000);
			ImageFileDiff diff = ImageFileDiff.expectedDiffFactory(output);
			if(!diff.sameSize()) {
				logger.warning("Actual and expected images not same size. Trying to make snapshot again, using expected size instead");
				File oldOutput = new File( output.getAbsolutePath().replaceFirst("\\.", "_old."));
				if(oldOutput.exists()) {
					oldOutput.delete();
				}
				output.renameTo(oldOutput);
				output = robot.snapShot(area, specificBaseName, diff.file2Dimension());
			}

			logger.log(SuiteLogLevel.OUTPUT, output.toString());
			assertImage(diff);
		}
		catch(IOException e) {
			throw new ScriptMistakeException("Error saving screen snapshots for "+specificBaseName, e);
		}
	}
	
	/**
	 * TODO - not implemented yet.
	 * 
	 * @param expected the location of the expected UMP
	 * @param actual the location of the output UMP for the test case 
	 */
	public static void assertUmpFile(File expected, File actual) {
		throw new ScriptMistakeException("not implemented yet");
		//TODO: need to call UMP diff here 
		//assertTrue(true);
	}

	/**
	 * Asserts that the foreground window title contains the specified string.
	 * @param name string to check for in the title of the top window
	 */
	public static void assertForegroundWindow(String name) {
		assertTrue("Window expected on top: "+name+
					". Found window: "+NativeGUI.getForegroundWindowInfo().getWindowText(), isWindowOnTop(name));
	}
		
	/**
	 * Checks if the top/foreground window title contains the specified string.
	 * 
	 * @param str
	 *            string to check for in the title of the top window
	 * @return if the top window contains the specified string. Compare is case
	 *         sensitive.
	 */
	public static boolean isWindowOnTop(String str) {		
		ComponentInfo info = NativeGUI.getForegroundWindowInfo();
		String window = info.getWindowText();
		return window.indexOf(str) != -1;
	}
}
