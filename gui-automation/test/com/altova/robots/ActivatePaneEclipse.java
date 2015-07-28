package com.altova.robots;

import org.junit.Test;

import com.altova.spy.SpyRobot;
import com.altova.umodel.regression.testcases.AbstractUmodelTest;

public class ActivatePaneEclipse  {

	@Test
	public void testActivateTab() {
		SpyRobot robot=new SpyRobot();
		robot.activatePane(SpyRobot.DETAILS_ORACLE);
		//System.exit(0);
	}
}
