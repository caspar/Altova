package com.altova.databasespy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.databasespy.AbstractDatabaseSpyTest.SQLopType;

public class PaneOnlineBrowserOracleTest extends AbstractDatabaseSpyTest{
	
	
	@BeforeClass
	public static void setUpBeforeAfter(){
		
		robot.newProject();
		
		QuickConnectionOracle10 qca = new QuickConnectionOracle10(QuickConnectParameter.Oracle_DBSource, QuickConnectParameter.Oracle_sourceName + "_" + robot.getRandomInteger(), QuickConnectParameter.Oracle_TNS, QuickConnectParameter.Oracle_userId, QuickConnectParameter.Oracle_password, QuickConnectParameter.Oracle_driverName);
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
	public final void testShowSQLEditor_Oracle_Select(){
		
		robot.clickBrowserFunction("_USR/ables/Address", "Show in new SQL Editor", SQLopType.SELECT.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public final void testShowSQLEditor_Oracle_Name(){
		
		robot.clickBrowserFunction("_USR/ables/Address", "Show in new SQL Editor", "Name");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
		
	@Test
	public final void testShowSQLEditor_Oracle_Path(){
		
		robot.clickBrowserFunction("_USR/ables/Address", "Show in new SQL Editor", "Path");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_Oracle_Create(){
		
		robot.clickBrowserFunction("_USR/ables/Address", "Show in new SQL Editor", SQLopType.CREATE.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_Oracle_Drop(){
		
		robot.clickBrowserFunction("_USR/ables/Address", "Show in new SQL Editor", SQLopType.DROP.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public final void testShowSQLEditor_Oracle_Insert(){
		
		robot.clickBrowserFunction("_USR/ables/Address", "Show in new SQL Editor", SQLopType.INSERT.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_Oracle_Update(){
		
		robot.clickBrowserFunction("_USR/ables/Address", "Show in new SQL Editor", SQLopType.UPDATE.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_Oracle_DeleteData(){
		
		robot.clickBrowserFunction("_USR/ables/Address", "Show in new SQL Editor", "Delete data");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	
	
}
