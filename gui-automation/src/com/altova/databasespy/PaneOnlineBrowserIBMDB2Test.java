package com.altova.databasespy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PaneOnlineBrowserIBMDB2Test extends AbstractDatabaseSpyTest{

	@BeforeClass
	public static void setUpBeforeAfter(){
		
		robot.newProject();
		
		QuickConnectionDB2 qca = new QuickConnectionDB2(QuickConnectParameter.DB2_DBSource, QuickConnectParameter.DB2_sourceName + "_paneTest_" + robot.getRandomInteger(), QuickConnectParameter.DB2_databaseName, QuickConnectParameter.DB2_userId, QuickConnectParameter.DB2_password, QuickConnectParameter.DB2_driverName);
		qca.executeWizard();

	}
	
	
	@After
	public void setUpAfter(){	
		
		robot.closeAll();
		
	}
	
	@Before
	public void setUp(){
		
			// just to avoid to run the @Before implemented in AbstractDatabaseSpyTest
	}
	
	@Test
	public final void testShowSQLEditor_IBMDB2_Select(){
		
		robot.clickBrowserFunction("_USER/ables/TEGORIES", "Show in new SQL Editor", SQLopType.SELECT.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public final void testShowSQLEditor_IBMDB2_Name(){
		
		robot.clickBrowserFunction("_USER/ables/TEGORIES", "Show in new SQL Editor", "Name");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
		
	@Test
	public final void testShowSQLEditor_IBMDB2_Path(){
		
		robot.clickBrowserFunction("_USER/ables/TEGORIES", "Show in new SQL Editor", "Path");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_IBMDB2_Create(){
		
		robot.clickBrowserFunction("_USER/ables/TEGORIES", "Show in new SQL Editor", SQLopType.CREATE.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_IBMDB2_Drop(){
		
		robot.clickBrowserFunction("_USER/ables/TEGORIES", "Show in new SQL Editor", SQLopType.DROP.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public final void testShowSQLEditor_IBMDB2_Insert(){
		
		robot.clickBrowserFunction("_USER/ables/TEGORIES", "Show in new SQL Editor", SQLopType.INSERT.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_IBMDB2_Update(){
		
		robot.clickBrowserFunction("_USER/ables/TEGORIES", "Show in new SQL Editor", SQLopType.UPDATE.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_IBMDB2_DeleteData(){
		
		robot.clickBrowserFunction("_USER/ables/TEGORIES", "Show in new SQL Editor", "Delete data");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	
	
}
