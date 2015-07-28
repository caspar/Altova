package com.altova.examples.junit;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.altova.robots.AltovaApplicationRobot;
import com.altova.spy.EclipseSpyRobot;
import com.altova.spy.VSnetSpyRobot;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;

@RunWith(AltovaJUnitRunner.class)
@TestRobot(VSnetSpyRobot.class)
public class IgnoreRobotTest {

	@Test
	public void testThis() {
		System.out.println("This");
	}
	
	@Test
	public void testThat() {
		int i = 5;
		if(i ==5 ){
			return;
		}
		System.out.println("That");
	}
	
	@Test
	@IgnoreRobots( {EclipseSpyRobot.class, VSnetSpyRobot.class} )
	public void testIgnore() {
		System.out.println("Ignore");
	}
	
	public static void setRobot(AltovaApplicationRobot r){
	
	}
}
