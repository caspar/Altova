package com.altova.databasespy;

import static com.altova.databasespy.DatabaseSpyRobot.*;

import org.junit.Test;

public class PaneProjectTest extends AbstractDatabaseSpyTest{

	private final String DATASOURCE = "nnnnnnnnnn";
	
	
	@Test
	public final void testConnect(){
	
		robot.openProject(ORGCHART_NNN_CONNECTED.getAbsolutePath());
		
		robot.connect(DATASOURCE);
		
		assertAreas(PROJECT, PROPERTIES);
	}
	
	@Test
	public final void testDisconnect(){
		
		robot.openProject(ORGCHART_NNN_DISCONNECTED.getAbsolutePath());
		
		robot.disconnect(DATASOURCE);
		
		assertAreas(PROJECT, PROPERTIES);
		
	}
	
	
	
	
}
