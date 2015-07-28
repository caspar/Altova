package com.altova.examples.junit;

import junit.framework.TestCase;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * 
 * Example of JUnit 4 style test suite. Nothing needs to go in this class,
 * the interesting bit is the list inside Suite.SuiteClasses.
 * 
 * New JUnit 4.0 info:
 * http://java-x.blogspot.com/2007/01/unit-testing-with-junit-40.html
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({JUnitFixture.class, JUnitParameterized.class})
public class JUnitTestSuite extends TestCase {
	
}
