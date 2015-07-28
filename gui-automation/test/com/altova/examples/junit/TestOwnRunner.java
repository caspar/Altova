package com.altova.examples.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitMyRunner.class)
public class TestOwnRunner {
	
	public TestOwnRunner() {
		
	}
	
	@Before
	public void before() {
		System.out.println("Before "+JUnitMyRunner.nextTest.getDisplayName());
	}
	
	@Test
	public void testThis() {
		System.out.println("testThis");
		assertTrue(true);
	}
	
	@Test
	public void testThat() {
		System.out.println("testThat");
		assertTrue(true);
	}
}
