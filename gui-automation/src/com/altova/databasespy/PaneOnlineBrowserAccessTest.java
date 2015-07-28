package com.altova.databasespy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static java.awt.event.KeyEvent.VK_D;
import static java.awt.event.KeyEvent.VK_N;
import static java.awt.event.KeyEvent.VK_Y;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.databasespy.AbstractDatabaseSpyTest.SQLopType;

public class PaneOnlineBrowserAccessTest extends AbstractDatabaseSpyTest{

	private final String TableToDropReferenced = "Processes";
	private final String TableToDropReferencing = "Person";
	
	
	@BeforeClass
	public static void setUpBeforeClassOLB(){
		
		robot.openProject(ORGCHART_PQRJ_FILE.getAbsolutePath());
		
	}
	
	
	
	@After
	public void setUpAfter(){	
		
		robot.closeAll();
		
	}
	
	
	@Test
	public final void testDragAndDropTableReferenced(){
		
		robot.newDesignEditor();
		
		robot.dragAndDropTable(TableToDropReferenced, 500, 150);
		
		robot.selectAllTables();
		robot.AddRelatedTables_ReferencedTables();

		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public final void testDragAndDropTableReferencing(){
		
		robot.newDesignEditor();
		
		robot.dragAndDropTable(TableToDropReferencing, 500, 150);
		
		robot.selectAllTables();
		robot.AddRelatedTables_ReferencingTables();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testShowSQLEditor_Access03_Select(){
		
		robot.clickBrowserFunction("OrgChart/OrgChartDB/ables/User T/Address", "Show in new SQL Editor", SQLopType.SELECT.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	public final void testShowSQLEditor_Access03_Name(){
		
		robot.clickBrowserFunction("OrgChart/OrgChartDB/ables/User T/Address", "Show in new SQL Editor", "Name");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
		
	@Test
	public final void testShowSQLEditor_Access03_Path(){
		
		robot.clickBrowserFunction("OrgChart/OrgChartDB/ables/User T/Address", "Show in new SQL Editor", "Path");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_Access03_Create(){
		
		robot.clickBrowserFunction("OrgChart/OrgChartDB/ables/User T/Address", "Show in new SQL Editor", SQLopType.CREATE.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_Access03_Drop(){
		
		robot.clickBrowserFunction("OrgChart/OrgChartDB/ables/User T/Address", "Show in new SQL Editor", SQLopType.DROP.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_Access03_Insert(){
		
		robot.clickBrowserFunction("OrgChart/OrgChartDB/ables/User T/Address", "Show in new SQL Editor", SQLopType.INSERT.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_Access03_Update(){
		
		robot.clickBrowserFunction("OrgChart/OrgChartDB/ables/User T/Address", "Show in new SQL Editor", SQLopType.UPDATE.toString());

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testShowSQLEditor_Access03_DeleteData(){
		
		robot.clickBrowserFunction("OrgChart/OrgChartDB/ables/User T/Address", "Show in new SQL Editor", "Delete data");

		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	

	
	
}
