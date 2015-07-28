package com.altova.examples.junit;

import junit.framework.TestCase;

/**
 * Small example of how a single JUnit TestCase can work.
 * 
 * This is in old JUnit 3.8 style. See the {@link JUnitTestCase} or {@link JUnitFixture} 
 * for new 4.0 style.
 * 
 * @author Havard Rast Blok
 *
 */
public class JUnitTestCaseOldStyle extends TestCase {
	
	public void testAdd() {
		//init with some numbers
		int a = 3; 
		int b = 4;
		
		//pretend some function is adding the numbers
		int c = a + b;
		
		//assert
		assertEquals(a+b, c);
	}
}
