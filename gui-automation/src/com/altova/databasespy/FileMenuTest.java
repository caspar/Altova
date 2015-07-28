package com.altova.databasespy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.databasespy.DatabaseSpyRobot.*;
import static com.altova.robots.SnapshotArea.CommonArea.ZIP_VIEW;


import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class FileMenuTest extends AbstractDatabaseSpyTest{


	private final String SQL_SELECT_ALL_FROM_OFFICE = "SELECT * FROM OFFICE;" ;
	
	/*@Before
	public void setUpBeforeFileTest() throws Exception {
		
		robot.openProject(ORGCHART_PQRJ_FILE.getAbsolutePath());
		
		robot.escapeDialog("Do you want to save project modifications?", VK_N);
	}*/
	
	@After
	public void setUpAfterFileTest() throws Exception {
		
		robot.closeAll();
	}
	
	

	@Test
	public final void testOpen() {
		
		robot.openFile(ORGCHART_SQL_DEMO_INSERT_FILE.getAbsolutePath());
		
		assertAreas(DIAGRAM_MAIN_WINDOW, PROPERTIES,OUTPUT);
	}
	
	@Test
	public final void testOpenProject() {
		
		robot.openProject(ORGCHART_PQRJ_FILE.getAbsolutePath());
		
		assertAreas(PROJECT, PROPERTIES,OUTPUT);
		robot.openFile(ORGCHART_SQL_DEMO_INSERT_FILE.getAbsolutePath());
	}
	
	@Test
	public final void testNewProject() {
		
		robot.closeAll(); //fixed in v2014r2: I need to close the sql file otherwise I will visualize a wrong PROPERTIES  
		robot.newProject();
		
		assertAreas(PROJECT,PROPERTIES,OUTPUT);
		robot.openFile(ORGCHART_SQL_DEMO_INSERT_FILE.getAbsolutePath());
	}

	

	@Test
	public final void testNewSQLEditor() {

		robot.newSQLEditor();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, PROPERTIES);
	}


	@Test
	public final void testNewDesignEditor() {
	
		robot.newDesignEditor();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, PROPERTIES);
				
		
	}
	

	@Test
	public final void testNewDataComparison_All() {
	
		
		QuickConnectAccess left = new QuickConnectAccess(QuickConnectParameter.Access_DBSource, QuickConnectParameter.Access_sourceFile_Left, QuickConnectParameter.Access_sourceName_Left);
		left.executeWizard();

		QuickConnectAccess right = new QuickConnectAccess(QuickConnectParameter.Access_DBSource, QuickConnectParameter.Access_sourceFile_Right, QuickConnectParameter.Access_sourceName_Right);
		right.executeWizard();
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "ALL");
		
	
		assertAreas(ZIP_VIEW, PROPERTIES);
				
		
	}
	
	
	@Test
	public final void testNewDataComparison_someTables() {
	
		
		QuickConnectAccess left = new QuickConnectAccess(QuickConnectParameter.Access_DBSource, QuickConnectParameter.Access_sourceFile_Left, QuickConnectParameter.Access_sourceName_Left);
		left.executeWizard();

		QuickConnectAccess right = new QuickConnectAccess(QuickConnectParameter.Access_DBSource, QuickConnectParameter.Access_sourceFile_Right, QuickConnectParameter.Access_sourceName_Right);
		right.executeWizard();
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Office", "Person");
		
	
		assertAreas(ZIP_VIEW, PROPERTIES);
				
		
	}	
	
	@Test
	public final void testNewDataComparison_aTable() {
	
		
		QuickConnectAccess left = new QuickConnectAccess(QuickConnectParameter.Access_DBSource, QuickConnectParameter.Access_sourceFile_Left, QuickConnectParameter.Access_sourceName_Left);
		left.executeWizard();

		QuickConnectAccess right = new QuickConnectAccess(QuickConnectParameter.Access_DBSource, QuickConnectParameter.Access_sourceFile_Right, QuickConnectParameter.Access_sourceName_Right);
		right.executeWizard();
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Office");
		robot.expandTables();
		
		assertAreas(ZIP_VIEW, PROPERTIES);			
		
	}

	

	@Test
	public final void testClose() {
		
		robot.closeAll(); //fixed in v2014r2: I need to close the sql file otherwise I will visualize the wron MAIN DIAGRAM
		robot.newDesignEditor();	
		
		robot.leftClickMenuItem("File", "Close");
		
		assertNull(robot.getDiagramComponent());
		
		robot.newDesignEditor();
	}
	

	@Test
	public final void testCloseAll() {
		
		robot.newDesignEditor();
		robot.newSQLEditor();
		
		robot.closeAll();
		
		assertNull(robot.getDiagramComponent());
		
		robot.newDesignEditor();
	}	
	

	@Test
	public final void testSave() {
		
		robot.openFile(ORGCHART_PQRJ_SAVED_FILE_TMP.getAbsolutePath());
		robot.saveFile();
		
		assertFileExists(ORGCHART_PQRJ_SAVED_FILE_TMP);
		
	}
	

	@Test
	public final void testSaveAs() {
		
		removeAndAssert(ORGCHART_PQRJ_SAVED_FILE_TMP_SAVEDAS);
		robot.openFile(ORGCHART_PQRJ_SAVED_FILE_TMP.getAbsolutePath());
		
		robot.saveFileAs(ORGCHART_PQRJ_SAVED_FILE_TMP_SAVEDAS.getAbsolutePath());
		robot.delay(2000);
		
		assertFileExists(ORGCHART_PQRJ_SAVED_FILE_TMP_SAVEDAS);
		
	}

	/*
	@Test
	public final void testSaveAll() {
		
		robot.openFile(ORGCHART_PQRJ_SAVED_FILE_TMP.getAbsolutePath());
		delay(500);
		robot.keyType(VK_SPACE);
		delay(500);
		robot.keyType(VK_BACK_SPACE);
		robot.saveFileAll();
		
		assertFileExists(ORGCHART_PQRJ_SAVED_FILE_TMP);
		
	}
	*/
	
	
	
	
	
}
