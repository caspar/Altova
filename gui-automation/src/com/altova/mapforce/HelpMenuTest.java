/**
 * 
 */
package com.altova.mapforce;

import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.common.testcases.AbstractHelpMenuTest;

/**
 * @author b.lopez
 *
 */
public class HelpMenuTest extends AbstractHelpMenuTest {

	private static MapForceRobot robot;
	protected final String BROWSERWebTraining = "Altova Online Training Overview";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new MapForceRobot();
		}
		
		AbstractHelpMenuTest.setUpBeforeClass(robot);
	}
	
	@Test
	public final void testWebTraining() {
		delay(1000);
		robot.webTraining();
		assertAndClose(BROWSERWebTraining);
	}

	public static void setRobot(MapForceRobot robot) {
		HelpMenuTest.robot = robot;
	}
}
