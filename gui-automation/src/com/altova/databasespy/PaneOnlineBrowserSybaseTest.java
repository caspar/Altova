package com.altova.databasespy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PaneOnlineBrowserSybaseTest extends AbstractDatabaseSpyTest{

	@BeforeClass
	public static void setUpBeforeAfter(){
		
		robot.newProject();
		
		QuickConnectionSybase qca = new QuickConnectionSybase(QuickConnectParameter.Sybase_DBSource, QuickConnectParameter.Sybase_sourceName + "_paneTest_" + robot.getRandomInteger(), QuickConnectParameter.Sybase_networkAddress, QuickConnectParameter.Sybase_databaseName, QuickConnectParameter.Sybase_userId, QuickConnectParameter.Sybase_password, QuickConnectParameter.Sybase_driverName);
		qca.executeWizard();
		
		robot.clickBrowserFunction("dbo", "Expand", "Children");
		
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
	public final void testShowSQLEditor_Sybase_Select(){
		
		robot.clickBrowserFunction("categories", "Show in new SQL Editor", SQLopType.SELECT.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public final void testShowSQLEditor_Sybase_Name(){
		
		robot.clickBrowserFunction("categories", "Show in new SQL Editor", "Name");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
		
	@Test
	public final void testShowSQLEditor_Sybase_Path(){
		
		robot.clickBrowserFunction("categories", "Show in new SQL Editor", "Path");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_Sybase_Create(){
		
		robot.clickBrowserFunction("categories", "Show in new SQL Editor", SQLopType.CREATE.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_Sybase_Drop(){
		
		robot.clickBrowserFunction("categories", "Show in new SQL Editor", SQLopType.DROP.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public final void testShowSQLEditor_Sybase_Insert(){
		
		robot.clickBrowserFunction("categories", "Show in new SQL Editor", SQLopType.INSERT.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_Sybase_Update(){
		
		robot.clickBrowserFunction("categories", "Show in new SQL Editor", SQLopType.UPDATE.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_Sybase_DeleteData(){
		
		robot.clickBrowserFunction("categories", "Show in new SQL Editor", "Delete data");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
}
