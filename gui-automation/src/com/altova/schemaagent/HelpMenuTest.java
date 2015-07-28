package com.altova.schemaagent;

import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.common.testcases.AbstractHelpMenuTest;
import static com.altova.schemaagent.SchemaAgentRobot.*;

public class HelpMenuTest extends AbstractHelpMenuTest{

	private static SchemaAgentRobot robot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		if(robot == null) {
			robot = new SchemaAgentRobot();
		}
		
		AbstractHelpMenuTest.setUpBeforeClass(robot);
		setRobot(new SchemaAgentRobot());
		
	}
	
	public static void setRobot(SchemaAgentRobot robo){
		
		robot = robo;
	}

	
	@Test
	public final void testDummyMethod() {

	}
}
