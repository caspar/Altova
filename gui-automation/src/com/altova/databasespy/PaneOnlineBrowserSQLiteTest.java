package com.altova.databasespy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//import com.altova.databasespy.AbstractDatabaseSpyTest.SQLopType;

public class PaneOnlineBrowserSQLiteTest extends AbstractDatabaseSpyTest{
	
	@BeforeClass
	public static void setUpBeforeAfter(){
		
		robot.newProject();
		
		QuickConnectSQLite qca = new QuickConnectSQLite(QuickConnectParameter.SQLite_DBSource, QuickConnectParameter.SQLite_sourceFile, QuickConnectParameter.SQLite_sourceName);
		qca.executeWizard();
		
	}
	
	@Before
	public void setUp(){
		
			// just to avoid to run the @Before implemented in AbstractDatabaseSpyTest
	}
	
	@After
	public void setUpAfter(){	
		
		robot.closeAll();
		
	}
	

	
	@Test
	public final void testShowSQLEditor_SQLite_Select(){
		
		robot.clickBrowserFunction("main/ables/Categories", "Show in new SQL Editor", SQLopType.SELECT.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	public final void testShowSQLEditor_SQLite_Name(){
		
		robot.clickBrowserFunction("main/ables/Categories", "Show in new SQL Editor", "Name");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
		
	@Test
	public final void testShowSQLEditor_SQLite_Path(){
		
		robot.clickBrowserFunction("main/ables/Categories", "Show in new SQL Editor", "Path");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_SQLite_Create(){
		
		robot.clickBrowserFunction("main/ables/Categories", "Show in new SQL Editor", SQLopType.CREATE.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_SQLite_Drop(){
		
		robot.clickBrowserFunction("main/ables/Categories", "Show in new SQL Editor", SQLopType.DROP.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public final void testShowSQLEditor_SQLite_Insert(){
		
		robot.clickBrowserFunction("main/ables/Categories", "Show in new SQL Editor", SQLopType.INSERT.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_SQLite_Update(){
		
		robot.clickBrowserFunction("main/ables/Categories", "Show in new SQL Editor", SQLopType.UPDATE.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_SQLite_DeleteData(){
		
		robot.clickBrowserFunction("main/ables/Categories", "Show in new SQL Editor", "Delete data");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	

}
