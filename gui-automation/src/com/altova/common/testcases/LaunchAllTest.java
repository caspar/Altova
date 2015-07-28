package com.altova.common.testcases;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.altova.robots.AltovaApplicationRobot;
import com.altova.util.NamedParameterizedRunner;

/**
 * Tests which attempts to launch all the applications returned from
 * {@link AltovaApplicationRobot#getKnownProducts()}, using the
 * {@link LaunchTest}.
 * 
 * It is using the JUnit {@link Parameterized} runner, so only one test method
 * is required.
 * 
 * @author Havard Rast Blok
 * 
 */
//@RunWith(value = Parameterized.class)
@RunWith(value = NamedParameterizedRunner.class)
public class LaunchAllTest {

	String product;

	/**
	 * Construct the test for the specified product.
	 * 
	 * @param product
	 *            the product key for the Altova application.
	 */
	public LaunchAllTest(String product) {
		this.product = product;
	}

	/**
	 * Collects the product keys to be passed along to the constructor.
	 * 
	 * @return Collection of product key String wrapped in an Object array
	 */
	@Parameters
	public static Collection data() {
		Set<String> products = AltovaApplicationRobot.getKnownProducts();
		Collection<Object> data = new ArrayList<Object>();
		for (String p : products) {
			data.add(new Object[] { p });
		}

		return data;
	}

	/**
	 * Test the launch and shutdown of the application specified in this class.
	 * 
	 */
	@Test
	public void testLaunch() {
		LaunchTest launch = new LaunchTest(product);
		launch.start();
		String msg = launch.getErrorMsg();
		assertTrue("Launch test for " + product + ". Error message: " + msg,
				launch.isOk());
	}
}
