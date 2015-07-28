package com.altova.semanticworks;

import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.common.testcases.AbstractHelpMenuTest;
import com.altova.semanticworks.SemanticWorksRobot;

public class HelpMenuTest extends AbstractHelpMenuTest{

	
	private static SemanticWorksRobot robot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		if(robot == null) {
			robot = new SemanticWorksRobot();
		}
		
		AbstractHelpMenuTest.setUpBeforeClass(robot);
		setRobot(new SemanticWorksRobot());
		
	}
	
	public static void setRobot(SemanticWorksRobot robo){
		
		robot = robo;
	}

	
	@Test
	public final void testDummyMethod() {

	}
}
