package com.altova.databasespy;

import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.common.testcases.AbstractHelpMenuTest;


public class HelpMenuTest extends AbstractHelpMenuTest{

	private static DatabaseSpyRobot robot;
	protected final String BROWSEROrderForm = "The ALTOVA Online Shop";
	
	//protected final String HELP_SCREEN = "User & Reference Manual";
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		if(robot == null) {
			robot = new DatabaseSpyRobot();
		}
		
		AbstractHelpMenuTest.setUpBeforeClass(robot);
		setRobot(new DatabaseSpyRobot());
		
	}
	
	public static void setRobot(DatabaseSpyRobot robo){
		
		robot = robo;
	}
	
	
	/*
	 * I must override the method orderForm because the menu
	 * the the function: menu Help - Order Form but in DatabaseSpy 
	 * is menu Help - Order form
	 * 
	 * (non-Javadoc)
	 * @see com.altova.common.testcases.AbstractHelpMenuTest#testOrderForm()
	 */
	@Test
	public final void testOrderForm() {

		robot.leftClickMenuItem("Help", "Order form");
		
		assertAndClose(BROWSEROrderForm);
	}
	

	
	
}
