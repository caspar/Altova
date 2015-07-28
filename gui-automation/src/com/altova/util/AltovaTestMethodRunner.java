package com.altova.util;

import java.lang.reflect.Method;

import org.junit.internal.runners.TestMethodRunner;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;

import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;

/**
 * Class created to add the {@link IgnoreRobots} functionality to the JUnit
 * {@link TestMethodRunner} class. It overrides the
 * {@link AltovaTestMethodRunner#run()} method to stop the run of an ignore
 * method, and also fire an ignored event ({@link RunNotifier#fireTestIgnored(Description)}).
 * 
 * @author b.lopez
 * @see IgnoreRobots
 */
public class AltovaTestMethodRunner extends TestMethodRunner {

	private final Method aMethod;

	private final RunNotifier aNotifier;

	private final Description aDescription;

	public AltovaTestMethodRunner(Object test, Method method, RunNotifier notifier, Description description) {

		super(test, method, notifier, description);
		aMethod = method;
		aNotifier = notifier;
		aDescription = description;
	}

	@Override
	public void run() {
		if (isIgnored()) {
			aNotifier.fireTestIgnored(aDescription);
			return;
		} else {
			super.run();
		}

	}

	/**
	 * Returns true if the test method of this runner should be ignored.
	 * Currently, this test is based on the {@link IgnoreRobots} annotation for
	 * the given method.
	 * 
	 * @return true if this method is annotated with IgnoredRobots, and the list
	 *         in this annotation contains the same robot as specified in the
	 *         {@link TestRobot} annotation
	 * @see IgnoreRobots
	 */
	private boolean isIgnored() {
		IgnoreRobots annotation = aMethod.getAnnotation(IgnoreRobots.class);
		if (annotation == null) {
			return false;
		}
		Class<?> values[] = annotation.value();
		for (Class<?> v : values) {
			if (v.equals(AltovaJUnitRunner.getTestRobot())) {
				return true;
			}
		}
		return false;

	}
}
