package com.altova.databasespy;

import static com.altova.databasespy.DatabaseSpyRobot.*;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WindowMenuTest extends AbstractDatabaseSpyTest{

	@Before
	public final void setUpWindowTestBefore() {	
			
		robot.newSQLEditor();
		robot.newSQLEditor();
		
	}
	
	@After
	public final void setUpWindowTestAfter() {	
		
		robot.closeAll();
	}
	
	
	
	@Test
	public final void testCascade() {
		
		robot.cascade();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
		
	}
	
	
	@Test
	public final void testTileHorizontally() {
		
		robot.tileHorizontally();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
		
	}
	
	@Test
	public final void testTileVertically() {
		
		robot.tileVertically();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
		
	}
	
	@Test
	public final void testOnlineBrowser() {
		
		
		robot.onLineBrowser();
		
		robot.setPaneSize(DatabaseSpyRobot.ONLINE_BROWSER, -1, 500);
		
		assertAreas(ONLINE_BROWSER);
		
	}
	
	
	@Test
	public final void testPropertyWindow() {
			
		robot.propertyWindow();
		
		robot.setPaneSize(DatabaseSpyRobot.PROPERTIES, -1, 500);
		
		assertAreas(PROPERTIES);
		
	}
	
	@Test
	public final void testOutputWindow() {
			
		robot.outputWindow();
		
		robot.setPaneSize(DatabaseSpyRobot.OUTPUT, -1, 200);
		
		assertAreas(OUTPUT);
		
	}
	
	
	@Test
	public final void testDatabaseStructureChangeScript() {
			
		robot.databaseStructureChangeScript();
		
		robot.setPaneSize(DatabaseSpyRobot.DATABASE_STRUCTUE, -1, 200);
		
		assertAreas(DATABASE_STRUCTUE);
		
	}
	
}
