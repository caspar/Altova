package com.altova.examples.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Example of a Fixture
 * 
 * The idea here is to have some code run once before and after the class,
 * and some before and after each test. The annotations marks which methods
 * are used for this. 
 * 
 * --- THIS ONLY WORKS WHEN TEST does not EXTENDS TestCase ---
 * 
 * See also:
 * http://junit.sourceforge.net/doc/faq/faq.htm#organize_3
 * 
 * http://www.nabble.com/RE:-@BeforeClass-not-working-p3439725.html
 * 
 * @author Havard Rast Blok
 *
 */
public class JUnitFixture {
	
	static int a; 
	static int b;
	int c;

    @BeforeClass
    public static void oneTimeSetUp() {
        System.out.println("one-time initialization code");
    	
    	//init with some numbers
		a = 3; 
		b = 4;
    }

    @AfterClass
    public static void oneTimeTearDown() {
        System.out.println("one-time cleanup code");
    }

    @Before
    public void setUp() {
    	System.out.println("setUp");
        c = 0;
    }

    @After
    public void tearDown() {
    	System.out.println("tearDown");
    }
	
	@Test
	public void testAdd() {
		System.out.println("testAdd");
		//pretend some function is adding the numbers
		c = a + b;
		
		//assert
		assertEquals(a+b, c);
	}
	
	
	@Test
	public void testSomething() {
		System.out.println("testSomething");
		
		assertTrue(true);
	}
	
	@Test
	public void somethingElese() {
		//test method which is marked by annotation
		//rather than "test" in the beginning of the method name
		
		//THIS ONLY WORKS WHEN TEST does not EXTENDS TestCase
		System.out.println("somethingElese");
		
		assertTrue(true);
	}
	
	/**
	 * Testing that an expected Exception is thrown 
	 *
	 */
	
	@Test(expected=NullPointerException.class)
	public void testAddNull() {
		String test = null;
		test.toString();
	}
	
	
}
