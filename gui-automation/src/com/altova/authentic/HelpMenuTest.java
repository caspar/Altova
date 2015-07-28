package com.altova.authentic;

import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.common.testcases.AbstractHelpMenuTest;
import com.altova.spy.SpyRobot;

public class HelpMenuTest extends AbstractHelpMenuTest {


		private static AuthenticRobot robot;
		
		private final String KEYBOARD_MAP = "Help Keyboard";
		protected final String BROWSERWebTraining = "Altova Online Training Overview";
		
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			if(robot == null) {
				robot = new AuthenticRobot();
			}
			
			AbstractHelpMenuTest.setUpBeforeClass(robot);
		}
		
		@Test
		public final void testKeyboardMap() {
			robot.keyboardMap();
			assertAndClose(KEYBOARD_MAP);
		}
		
		@Test
		public final void testWebTraining() {
			robot.webTraining();
			assertAndClose(BROWSERWebTraining);
		}

		public static void setRobot(AuthenticRobot robot) {
			HelpMenuTest.robot = robot;
		}
	
}
