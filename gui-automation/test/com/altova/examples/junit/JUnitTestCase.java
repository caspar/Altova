package com.altova.examples.junit;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Small example of how a single very simple JUnit TestCase can work.
 * 
 * This is in new JUnit 4.0 style.
 * 
 * @author Havard Rast Blok
 *
 */
public class JUnitTestCase {
	
	@Test
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
