package com.altova.util;

import static com.altova.util.LoggerUtils.logger;

import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Ignore;
import org.junit.internal.runners.InitializationError;
import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.altova.robots.AltovaApplicationRobot;
import com.altova.robots.ScriptMistakeException;

/**
 * JUnit 4.0 test runner class specifically designed for Altova GUI automation
 * test cases.
 * <p>
 * This runner caters for a few special needs of our test cases:
 * <ol>
 * <li>Get the description of test case (class) and test (method) without
 * having to specify it explicitly in each test.</li>
 * <li>Set the {@link TestRobot} annotation, to select which robot to use;
 * stand-alone application, Eclipse plugin, or VS .Net plugin</li>
 * <li>Set the {@link IgnoreRobots} annotation, to ignore specific test methods
 * for given robots (plugins or stand-alone).</li>
 * <li>Incorporate the functionality of {@link Suite} to make the above
 * functions work in "JUnit Suite mode" as well. (This means that where you
 * would usually use RunWith(Suite), you should use RunWith(AltovaJUnitRunner) ).</li>
 * </ol>
 * <p>
 * For some information about the run/test description functionality, see also:
 * http://tech.groups.yahoo.com/group/junit/message/18728
 * 
 * @author Havard Rast Blok
 * @see Suite
 * @see RunWith
 * @see Ignore
 * @see TestRobot
 * @see IgnoreRobots
 * 
 */
public class AltovaJUnitRunner extends org.junit.internal.runners.TestClassRunner {
	
	private MyRunListener listener = new MyRunListener();
	
	private static Description nextTest;
	
	private static Description nextTestRun;
	
	private static Class<? extends AltovaApplicationRobot> testRobot;
	
	/**
	 * Annotation for JUnit test class which indicate which Robot to use for the test.
	 * The Robot has to be of type {@link AltovaApplicationRobot}
	 * <p>
	 * Examples of usage: </br>
	 * {@code @TestRobot(SpyRobot.class)} </br>
	 * {@code @TestRobot(VSnetSpyRobot.class)} </br>
	 * 
	 * @author Havard Rast Blok
	 *
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public @interface TestRobot {
		public Class<? extends AltovaApplicationRobot> value();
	}
	
	/**
	 * Annotation for JUnit test method to indicate that the the test method
	 * should be skipped. In the JUnit run and report, it will behave similar to
	 * the {@link Ignore} annotation, however is a conditional ignore, which
	 * will be triggered when the on of the listed robot classes matches the one
	 * specified in {@link TestRobot}
	 * <p>
	 * Examples of usage: </br>
	 * {@code IgnoreRobots(EclipseSpyRobot.class)} </br>
	 * {@code IgnoreRobots({EclipseSpyRobot.class, VSnetSpyRobot.class})} </br>
	 * 
	 * @author b.lopez
	 * 
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public @interface IgnoreRobots {
		/**
		 * Here, we obtain the list of robots we want to ignore for this test
		 */
		public Class<? extends AltovaApplicationRobot>[] value();
	}
	
	public AltovaJUnitRunner(Class<?> klass) throws InitializationError {
		super(klass, createRunner(klass));
	}

	/**
	 * Return a JUnit test Runner based on the type of test we have. If the test
	 * class contains the annotation SuiteClasses, it will mimic the
	 * functionality of Suite. If not, it will behave like a standard JUnit test
	 * (as in TestClassRunner)
	 * 
	 * @param klass test class
	 * @return JUnit Runner
	 * @throws InitializationError
	 */
	private static Runner createRunner(Class<?> klass) throws InitializationError {
		if (klass.getAnnotation(SuiteClasses.class) == null) {
			logger.info("We are testing a single class");
			setAnnotatedRobot(klass, klass);
			return new AltovaTestClassMethodsRunner(klass);
		} else{
			logger.info("A suite of class are being tested. Make sure the suite is using @RunWith(AltovaJUnitRunner.class).");
			return Request.classes(klass.getName(), getAnnotatedClasses(klass)).getRunner();
		}
	}
	
	/**
	 * Returns the list of test case classes within the annotation SuiteClasses,
	 * and also calls the setRobot method on each of the individual test classes,
	 * to inject them with the robot specified in the TestRobot annotation (if
	 * present).
	 * 
	 * @param klass
	 *            the suite test
	 * @return list of classes in suite
	 * @throws InitializationError
	 */
	private static Class<?>[] getAnnotatedClasses(Class<?> klass) throws InitializationError {
		// copied from Suite.class
		SuiteClasses annotation = klass.getAnnotation(SuiteClasses.class);
		if (annotation == null)
			throw new InitializationError(String.format("class '%s' must have a SuiteClasses annotation", klass.getName()));
		Class<?> values[] = annotation.value();
		for (Class<?> v : values) {
			setAnnotatedRobot(klass, v);
		}
		return values;
	}
	
	/**
	 * Injects the robot in the TestRobot annotation into the specified class.
	 * If the test class does not contain a method setRobot(AltovaApplicationRobot),
	 * an exception will occur.
	 * 
	 * @param klass class to inject the robot into
	 */
	private static void setAnnotatedRobot(Class<?> annotatedClass,Class<?> testClass) {
		if(testClass == null) {
			throw new NullPointerException("Class to inject robot into cannot be null (parameter testClass)");
		}
		
		TestRobot annotation = annotatedClass.getAnnotation(TestRobot.class);
		if(annotation == null) {
			return;
		}
		
		Class<? extends AltovaApplicationRobot> robot = annotation.value();
		testRobot = robot;
		logger.finest("Found annotated TestRobot: " + robot.getName());
		try {
			// find set method in test class
			Method m = findSetMethod(testClass, robot);
			logger.finest("Found setRobot() method: " + m);

			// create Robot
			AltovaApplicationRobot r = robot.newInstance();
			logger.finest("Created new instace of robot: " + r);

			m.invoke(null, new Object[] { r });
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			throw new ScriptMistakeException("The class "+testClass.getName()+" did contain a method setRobot( robot ), but it was not static. (At least, that is a good guess to why this failed, but you should investigate the AltovaJUnitRunner.setAnnotatedRobot method)", e);
		} catch (NoSuchMethodException e) {
			throw new ScriptMistakeException("The class "+testClass.getName()+" did not contain a method setRobot( robot )", e);
		} catch (InstantiationException e) {
			throw new ScriptMistakeException("Could not create new robot of type "+robot.getName(), e);
		} catch (IllegalAccessException e) {
			throw new ScriptMistakeException("Method setRobot(robot) in "+testClass.getName()+" has to be public.", e); 
		} catch (IllegalArgumentException e) {
			throw new ScriptMistakeException("Error calling method setRobot(robot) in "+testClass.getName(), e);
		} catch (InvocationTargetException e) {
			throw new ScriptMistakeException("Something went wrong while setting the robot for the test: ", e);
		}
	}

	/**
	 * Finds the method "public static void setRobot(AltovaApplicationRobot)" (or equivalent),
	 * in the specified class klass, which can take the specified robot as an argument. 
	 * 
	 * @param klass the class to look for the setRobot() metho in 
	 * @param robot to type of robot class to match
	 * @return the reflected Method object which matches
	 * @throws NoSuchMethodException if no match was found
	 */
	private static Method findSetMethod(Class<?> klass, Class<? extends AltovaApplicationRobot> robot) throws NoSuchMethodException {
		//look through all methods of the junit test class
		Method methods[] = klass.getMethods();
		for(Method m : methods) {
			//check if the method has the correct name, else skip this
			if(!m.getName().equals("setRobot")) {
				continue;
			}
			
			//check if it takes only one parameter, else skip
			Class<?>[] param = m.getParameterTypes();
			if(param.length != 1) {
				continue;
			}
			
			//check that the method parameter is of the given type, or one of its super classes
			if(!param[0].isAssignableFrom(robot)){
				continue;
			}
			
			return m;
		}
		
		throw new NoSuchMethodException("\n Did not find a public method setRobot(robot) in "+klass.getName()+
									"\n or its super classes which could take the class "+robot.getName()+
									"\n as a parameter, when through a 'widening reference conversion'");
	}

	@Override
	public Description getDescription() {
		return super.getDescription();
	}

	@Override
	public void run(RunNotifier notifier) {
		//add our own listener here
		notifier.addListener(listener);
		super.run(notifier);
	}

	private static String getTestName(Description description) {
		if(description == null) {
			return null;
		}
		
		String fullName = description.getDisplayName();
		String name = fullName.replaceAll("\\(.*\\)", "");
		return name;
	}
	
	private static String getRunName(AltovaApplicationRobot robot, Description description) {
		if(description == null) {
			return null;
		}
		
		String fullName = description.getDisplayName();
		String className = fullName.replaceAll(".*\\(", "").replace(")", "");
		return getRunName(robot, className);
	}
		
	/**
	 * Gets the unique name of the currently running test class.
	 * 
	 * Be aware that the name this method might be delayed, that is
	 * it might have the name of the previous test class, if called from
	 * the static BeforeClass method in the the test classes.
	 * 
	 * The name is a composite of the (Altova) product name and the test class,
	 * separated by the File.separator.
	 * 
	 * @return the product and class name as a part of a file path 
	 */
	public static String getRunName(AltovaApplicationRobot robot, String className) {
		String testName = getLastPartClassname(className);
		String robotName = getLastPartClassname(robot.getClass().getName());
		String productName = robotName.replaceAll("Robot", "");
		
		return productName+File.separator+testName;
	}
	
	private static String getLastPartClassname(String className) {
		int idx = className.lastIndexOf('.');
		return className.substring(idx+1);
	}
	
	/**
	 * Gets the product package name, as listed in {@link AltovaApplicationRobot#getKnownProducts()},
	 * based on the specified fully qualified class name.
	 * 
	 * @param className a fully qualified class name in a product specific package,
	 * 					e.g. "com.altova.spy.BrowserMenuTest"
	 * @return the product part of the in the package name, i.e. "spy" in the example above.
	 */
	public static String getProductPackage(String className) {
		String productName = null;
		for( String product : AltovaApplicationRobot.getKnownProducts()) {
			if(className.indexOf(product) != -1 ) {
				productName = product;
			}
		}
		
		if(productName == null) {
			logger.warning("Could not find product name from test package name. Will have to make up a name");
			productName = "product";
		}
		
		return productName;
	}
	
	/**
	 * Gets the name of the currently running test (method name).
	 * 
	 * @return the name of the test method
	 */
	public static String getCurrentTestName() {
		return getTestName(nextTest);
	}

	/**
	 * Gets the unique name of the currently running test class.
	 * 
	 * Be aware that the name this method might be delayed, that is
	 * it might have the name of the previous test class, if called from
	 * the static BeforeClass method in the the test classes.
	 * 
	 * The name is a composite of the (Altova) product name and the test class,
	 * separated by the File.separator.
	 * 
	 * @return the product and class name as a part of a file path 
	 */
	public static String getCurrentRunName(AltovaApplicationRobot robot) {
		if(nextTestRun != null) {
			return getRunName(robot, nextTestRun);
		}
		
		return getRunName(robot, nextTest);
	}
	
	private class MyRunListener extends RunListener {

		@Override
		public void testRunStarted(Description description) throws Exception {
			nextTestRun = description;
			logger.severe("Very interesting. This did not happen before. Why did it appear now??"+
					"AltovaJUnitRunner.MyRunListener.testRunStarted nextTestRun: "+description);
		}

		@Override
		public void testStarted(Description description) throws Exception {
			nextTest = description;
		}
	}

	/**
	 * Returns the robot specified in the last {@link TestRobot} annotation
	 * seen. This might sound ambiguous, and that because it currently is. You
	 * might want to drill into the code of
	 * {@link AltovaJUnitRunner#setAnnotatedRobot(Class, Class)} to look at
	 * this.
	 * 
	 * @return the robot to be used for the test, specified a TestRobot
	 *         annotation
	 */
	public static Class<? extends AltovaApplicationRobot> getTestRobot() {
		
		return testRobot;
	}
}
