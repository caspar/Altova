package com.altova.examples.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import com.altova.util.NamedParameterizedRunner;

/**
 * 
 * Based on JUnit 4.0 example from
 * http://java-x.blogspot.com/2007/01/unit-testing-with-junit-40.html 
 * 
 * "The requirement for parameterized tests is to

    * Have the annotation @RunWith for the Test Class
    * Have a public static method that returns a Collection for data. Each element of the collection must be an Array of the various paramters used for the test.
    * You will also need a public constructor that uses the parameters"
 * 
 * 
 *
 */


//@RunWith(value = Parameterized.class)
@RunWith(value = NamedParameterizedRunner.class)
public class JUnitParameterized {

	 Stack<Integer> stack;
	 private int input1;
	 private int input2;
	 private int expected;

	 public JUnitParameterized(int input1, int input2, int expected) {
	   this.input1 = input1;
	   this.input2 = input2;
       this.expected = expected;
	 }
	 @BeforeClass
	 public static void oneTimeSetUp() {
		 System.out.println("one-time initialization code");
	 }
	 
	 @Parameters
	 public static Collection data() {
		 Object[][] data = new Object[][] { { 1, 1, 2 }, { 3, 1, 4 }, { 3, 5, 5 }, { 10, 0, 10 } };
		 //the third element is wrong on purpose:  ( 3 + 5 != 5 )
		 return Arrays.asList(data);
	 }

	 @Test
	 public void testNumber() {
		 int sum = input1+input2;
		 assertEquals("testNumber(" + input1 + "+" + input2 + ")", expected, sum);
	 }
	
}
