package com.altova.examples.junit;

import org.junit.internal.runners.InitializationError;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

/**
 * See also:
 * http://tech.groups.yahoo.com/group/junit/message/18728
 * 
 * @author Havard Rast Blok
 *
 */
public class JUnitMyRunner extends org.junit.internal.runners.TestClassRunner {
	
	public static Description nextTest;
	
	private static Description nextTestRun;
	
	public JUnitMyRunner(Class<?> klass) throws InitializationError {
		super(klass);
		System.out.println("JUnitMyRunner test:"+klass);
	}
	
	@Override
	public Description getDescription() {
		return super.getDescription();
	}

	@Override
	public void run(RunNotifier notifier) {
		System.out.println("Adding own RunListener");
		notifier.addListener(new MyRunListener());
		
		super.run(notifier);
	}

	class MyRunListener extends RunListener {

		@Override
		public void testRunStarted(Description description) throws Exception {
			//this method does not seem to be called... A bug in the JUnit stuff??
			System.out.println("Starting run: "+description);
			nextTestRun = description;
		}
		
		@Override
		public void testStarted(Description description) throws Exception {
			System.out.println("Starting test "+description);
			nextTest = description;
		}
		
	}
}
