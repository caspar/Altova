package com.altova.util;

import static org.junit.Assert.assertEquals;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;

import org.junit.internal.runners.CompositeRunner;
import org.junit.internal.runners.MethodValidator;
import org.junit.internal.runners.TestClassMethodsRunner;
import org.junit.internal.runners.TestClassRunner;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * This is a temporarily "fix" for getting names of of the {@link Parameterized}
 * class... When the JUnit guys come up with something better, that should be
 * used instead of this class.
 * 
 */
public class NamedParameterizedRunner extends TestClassRunner {

	protected static class TestClassRunnerForParameters extends TestClassMethodsRunner {
		protected final Object[] fParameters;

		protected final int fParameterSetNumber;

		protected final Constructor<?> fConstructor;

		protected TestClassRunnerForParameters(Class<?> klass, Object[] parameters, int i) {
			super(klass);
			fParameters = parameters;
			fParameterSetNumber = i;
			fConstructor = getOnlyConstructor();
		}

		@Override
		protected Object createTest() throws Exception {
			return fConstructor.newInstance(fParameters);
		}

		@Override
		protected String getName() {
			return String.format("[%s]: %s", fParameterSetNumber, (fParameters != null) ? fParameters[0] : "null");
		}

		/**
		 * Returns the test name, and includes the first parameter in the test
		 * name.
		 */
		@Override
		protected String testName(final Method method) {
			return String.format("%s[%s]: %s", method.getName(), fParameterSetNumber, (fParameters != null) ? fParameters[0] : "null");
		}

		protected Constructor<?> getOnlyConstructor() {
			Constructor<?>[] constructors = getTestClass().getConstructors();
			assertEquals(1, constructors.length);
			return constructors[0];
		}
	}

	public static class RunAllParameterMethods extends CompositeRunner {
		protected final Class<?> fKlass;

		public RunAllParameterMethods(Class<?> klass) throws Exception {
			super(klass.getName());
			fKlass = klass;
			int i = 0;
			for (final Object each : getParametersList()) {
				if (each instanceof Object[])
					super.add(createTestClassMethodsRunner(klass, (Object[]) each, i++));
				else
					throw new Exception(String.format("%s.%s() must return a Collection of arrays.", fKlass.getName(), getParametersMethod().getName()));
			}
		}

		/**
		 * Factory method for the {@link TestClassRunnerForParameters}, so that
		 * it can be extended for other test name formats.
		 * 
		 * @param klass
		 * @param objects
		 * @param i
		 * @return
		 */
		protected TestClassMethodsRunner createTestClassMethodsRunner(Class<?> klass, Object[] objects, int i) {
			return new TestClassRunnerForParameters(klass, objects, i);
		}

		protected Collection<?> getParametersList() throws IllegalAccessException, InvocationTargetException, Exception {
			return (Collection<?>) getParametersMethod().invoke(null);
		}

		protected Method getParametersMethod() throws Exception {
			for (Method each : fKlass.getMethods()) {
				if (Modifier.isStatic(each.getModifiers())) {
					Annotation[] annotations = each.getAnnotations();
					for (Annotation annotation : annotations) {
						if (annotation.annotationType() == Parameters.class)
							return each;
					}
				}
			}
			throw new Exception("No public static parameters method on class " + getName());
		}
	}

	public NamedParameterizedRunner(final Class<?> klass) throws Exception {
		this(klass, new RunAllParameterMethods(klass));
	}

	/**
	 * New constructor to facilitate subclasses of this class.
	 * 
	 * @param klass
	 * @param runner
	 * @throws Exception
	 */
	protected NamedParameterizedRunner(final Class<?> klass, CompositeRunner runner) throws Exception {
		super(klass, runner);
	}

	@Override
	protected void validate(MethodValidator methodValidator) {
		methodValidator.validateStaticMethods();
		methodValidator.validateInstanceMethods();
	}

}
