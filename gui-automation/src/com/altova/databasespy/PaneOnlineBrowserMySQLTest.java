package com.altova.databasespy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PaneOnlineBrowserMySQLTest extends AbstractDatabaseSpyTest{

	
	@BeforeClass
	public static void setUpBeforeAfter(){
		
		robot.newProject();
		
		//QuickConnectionMySQL qca = new QuickConnectionMySQL(QuickConnectParameter.MySQL_DBSource, QuickConnectParameter.MySQL_sourceName + "_paneTest_" + robot.getRandomInteger(), QuickConnectParameter.MySQL_serverName, QuickConnectParameter.MySQL_userId, QuickConnectParameter.MySQL_password, QuickConnectParameter.MySQL_databaseName, QuickConnectParameter.MySQL_driverName, QuickConnectParameter.MySQL_port);
		QuickConnectionMySQL qca = new QuickConnectionMySQL(QuickConnectParameter.MySQL_DBSource, QuickConnectParameter.MySQL_sourceName + "_" + robot.getRandomInteger(), QuickConnectParameter.MySQL_serverName, QuickConnectParameter.MySQL_userId, QuickConnectParameter.MySQL_password, QuickConnectParameter.MySQL_databaseName, QuickConnectParameter.MySQL_driverName, QuickConnectParameter.MySQL_port);
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
	public final void testShowSQLEditor_MySQL_Select(){
		
		robot.clickBrowserFunction("ables/categories", "Show in new SQL Editor", SQLopType.SELECT.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public final void testShowSQLEditor_MySQL_Name(){
		
		robot.clickBrowserFunction("ables/categories", "Show in new SQL Editor", "Name");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
		
	@Test
	public final void testShowSQLEditor_MySQL_Path(){
		
		robot.clickBrowserFunction("ables/categories", "Show in new SQL Editor", "Path");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_MySQL_Create(){
		
		robot.clickBrowserFunction("ables/categories", "Show in new SQL Editor", SQLopType.CREATE.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_MySQL_Drop(){
		
		robot.clickBrowserFunction("ables/categories", "Show in new SQL Editor", SQLopType.DROP.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public final void testShowSQLEditor_MySQL_Insert(){
		
		robot.clickBrowserFunction("ables/categories", "Show in new SQL Editor", SQLopType.INSERT.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_MySQL_Update(){
		
		robot.clickBrowserFunction("ables/categories", "Show in new SQL Editor", SQLopType.UPDATE.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_MySQL_DeleteData(){
		
		robot.clickBrowserFunction("ables/categories", "Show in new SQL Editor", "Delete data");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	
	
	
}
