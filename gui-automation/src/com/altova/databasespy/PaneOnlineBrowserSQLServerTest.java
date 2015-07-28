package com.altova.databasespy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;

public class PaneOnlineBrowserSQLServerTest extends AbstractDatabaseSpyTest{

	
	@BeforeClass
	public static void setUpBeforeAfter(){
		
		robot.newProject();
		
		QuickConnectSQLServer qca = new QuickConnectSQLServer(QuickConnectParameter.SQLServer_DBSource, QuickConnectParameter.SQLServer_sourceName + "_paneTest", QuickConnectParameter.SQLServer_serverName, QuickConnectParameter.SQLServer_userId, QuickConnectParameter.SQLServer_password, QuickConnectParameter.SQLServer_driverName, QuickConnectParameter.SQLServer_databaseName);
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
	public final void testShowSQLEditor_SQLServer_Select(){
		
		robot.clickBrowserFunction("Categories2", "Show in new SQL Editor", SQLopType.SELECT.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public final void testShowSQLEditor_SQLServer_Name(){
		
		robot.clickBrowserFunction("Categories2", "Show in new SQL Editor", "Name");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
		
	@Test
	public final void testShowSQLEditor_SQLServer_Path(){
		
		robot.clickBrowserFunction("Categories2", "Show in new SQL Editor", "Path");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_SQLServer_Create(){
		
		robot.clickBrowserFunction("Categories2", "Show in new SQL Editor", SQLopType.CREATE.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_SQLServer_Drop(){
		
		robot.clickBrowserFunction("Categories2", "Show in new SQL Editor", SQLopType.DROP.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public final void testShowSQLEditor_SQLServer_Insert(){
		
		robot.clickBrowserFunction("Categories2", "Show in new SQL Editor", SQLopType.INSERT.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_SQLServer_Update(){
		
		robot.clickBrowserFunction("Categories2", "Show in new SQL Editor", SQLopType.UPDATE.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_SQLServer_DeleteData(){
		
		robot.clickBrowserFunction("Categories2", "Show in new SQL Editor", "Delete data");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	
	
}
