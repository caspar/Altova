package com.altova.databasespy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PaneOnlineBrowserInformix extends AbstractDatabaseSpyTest{

	
	@BeforeClass
	public static void setUpBeforeAfter(){
		
		robot.newProject();
		
		QuickConnectInformix qca = new QuickConnectInformix(QuickConnectParameter.Informix_DBSource, QuickConnectParameter.Informix_sourceName + "_" + robot.getRandomInteger(), QuickConnectParameter.Informix_serverName, QuickConnectParameter.Informix_hostname, QuickConnectParameter.Informix_service, QuickConnectParameter.Informix_protocol, QuickConnectParameter.Informix_userId, QuickConnectParameter.Informix_password, QuickConnectParameter.Informix_databaseName, QuickConnectParameter.Informix_driverName);
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
	public final void testShowSQLEditor_Informix_Select(){
		
		robot.clickBrowserFunction("_user/ables/categories", "Show in new SQL Editor", SQLopType.SELECT.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public final void testShowSQLEditor_Informix_Name(){
		
		robot.clickBrowserFunction("_user/ables/categories", "Show in new SQL Editor", "Name");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
		
	@Test
	public final void testShowSQLEditor_Informix_Path(){
		
		robot.clickBrowserFunction("_user/ables/categories", "Show in new SQL Editor", "Path");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_Informix_Create(){
		
		robot.clickBrowserFunction("_user/ables/categories", "Show in new SQL Editor", SQLopType.CREATE.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_Informix_Drop(){
		
		robot.clickBrowserFunction("_user/ables/categories", "Show in new SQL Editor", SQLopType.DROP.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public final void testShowSQLEditor_Informix_Insert(){
		
		robot.clickBrowserFunction("_user/ables/categories", "Show in new SQL Editor", SQLopType.INSERT.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_Informix_Update(){
		
		robot.clickBrowserFunction("_user/ables/categories", "Show in new SQL Editor", SQLopType.UPDATE.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_Informix_DeleteData(){
		
		robot.clickBrowserFunction("_user/ables/categories", "Show in new SQL Editor", "Delete data");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	
}
