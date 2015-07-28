package com.altova.databasespy;

import static com.altova.databasespy.DatabaseSpyRobot.*;
import static java.awt.event.KeyEvent.*;

import java.awt.Color;
import java.awt.Rectangle;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.AltovaApplicationRobot;

public class ProjectMenuTest extends AbstractDatabaseSpyTest{
	
	@Before
	public void setUpBefore() throws Exception {
		
		robot.openProject(ORGCHART_PQRJ_FILE.getAbsolutePath());
		robot.escapeDialog("Do you want to save project", VK_N);
		robot.escapeDialog("Do you want to close DatabaseSpy anyway and lose your", VK_Y);
		robot.escapeDialog("Are you sure you want to disconnect?", VK_Y);
	}
	
	
	@Test
	public final void testNewProject() {
		
		robot.newProject();
		robot.newSQLEditor();
		
		assertAreas(PROJECT);
	}
	
	@Test
	public final void testOpenProject() {
		
		robot.closeAll(); //fixed in v2014r2: I need to close the sql file otherwise I will visualize a wrong PROPERTIES
		robot.focusOnProjectName("OrgChart");
		assertAreas(PROJECT, PROPERTIES);
	}	
	
	
	/*
	@Ignore
	public final void testSaveProject() {
		
		robot.openProject(ORGCHART_PQRJ_FILE_DISCONNECTED.getAbsolutePath());
		robot.saveProject();
		
		delay(1500);
		assertFileExists(ORGCHART_PQRJ_FILE_DISCONNECTED);
	}
	*/
	
	
	/*@Test
	public final void testSaveProjectAs() {
		
		removeAndAssert(ORGCHART_PQRJ_SAVED_FILE);

		robot.saveProjectAs(ORGCHART_PQRJ_SAVED_FILE.getAbsolutePath());
		
		assertFileExists(ORGCHART_PQRJ_SAVED_FILE);
	}*/
	
	/*@Test
	public final void testAddFilesToProject() {
		
		robot.addFileToProject(ALL_FROM_PERSON_SQL.getAbsolutePath());
		
		assertAreas(PROJECT);
		
	}*/

	/*@Test
	public final void testAddActiveFileToProject() {
		
		robot.addNewActiveFileToProject(ALL_FROM_PERSON_SQL.getAbsolutePath());
		
		assertAreas(PROJECT, PROPERTIES);
		
	}*/
	

	
	
	
	
}
