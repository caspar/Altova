package com.altova.util;

import java.lang.reflect.Method;

import org.junit.internal.runners.TestClassMethodsRunner;
import org.junit.internal.runners.TestMethodRunner;
import org.junit.runner.notification.RunNotifier;

/**
 * The class overrides the {@link TestClassMethodsRunner} only to override the
 * {@link AltovaTestClassMethodsRunner#createMethodRunner(Object, Method, RunNotifier)}
 * method, so that we can supply over own {@link AltovaTestMethodRunner}.
 * 
 * @author b.lopez
 * 
 */
public class AltovaTestClassMethodsRunner extends TestClassMethodsRunner {

	public AltovaTestClassMethodsRunner(Class<?> klass) {
		super(klass);

	}

	@Override
	protected TestMethodRunner createMethodRunner(Object test, Method method, RunNotifier notifier) {
		return new AltovaTestMethodRunner(test, method, notifier, methodDescription(method));
	}

}
