package com.altova.databasespy;

import static com.altova.robots.SnapshotArea.CommonArea.DATACOMPARISON_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static java.awt.event.KeyEvent.VK_N;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.databasespy.DatabaseSpyRobot.comparison;

public class SchemaComparisonTest extends AbstractDatabaseSpyTest{

	
	
	@Before
	public void setUpBeforeFileTest() throws Exception {
		
		robot.openProject(ORGCHART_PQRJ_DATACOMPARISON.getAbsolutePath());
		robot.escapeDialog("Do you want to save project modifications?", VK_N);
		
		robot.resetOptionAndClose(); // default option restore

	}
	
	@After
	public void setUpAfterFileTest() throws Exception {
		

		robot.closeAll();
		
	}
	
	
	@Test
	public void testCompareItems() {
		
		robot.newSchemaComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Person");

		robot.compareItems();
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);
		
	}
	
	@Ignore
	@Test
	public void testShowMergeScript_LeftToRight() {
		
		robot.newSchemaComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Person");

		robot.compareItems();
		
		robot.showMergeScriptLeftToRight(comparison.Schema_Comparison);
		robot.delay(3000);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Ignore
	@Test
	public void testShowMergeScript_RightToLeft() {
		
		robot.newSchemaComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Person");

		robot.compareItems();
		
		robot.showMergeScriptRightToLeft(comparison.Schema_Comparison);
		robot.delay(3000);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
		
	@Test
	public void testSortTables_Ascending() {
		
		robot.newSchemaComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Person", "Processes");
		
		robot.SortTablesAscending(comparison.Schema_Comparison);
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);
	}
	
	@Test
	public void testSortTables_Descending() {
		
		robot.newSchemaComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Person", "Processes");
		
		robot.SortTablesDescending(comparison.Schema_Comparison);
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);
	}
	
	@Test
	public void testSortTables_AscendingMappedFirst() {
		
		robot.newSchemaComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Person", "Processes");
		
		robot.SortTablesAscendingMappedFirst(comparison.Schema_Comparison);
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);
	}
	
	@Test
	public void testSortTables_DescendingMappedFirst() {
		
		robot.newSchemaComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Person", "Processes");
		
		robot.SortTablesDescendingMappedFirst(comparison.Schema_Comparison);
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);
	}
	
	
	@Test
	public void testMapItems() {
	
		robot.activateOptionDialogDataCompare();
		robot.DCOptionDialog_MapTablesAuto_off();
		
		robot.newSchemaComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Person");		
		
		robot.mapItems(comparison.Schema_Comparison);
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);
		
	}
	
	@Test
	public void testUnmapItems() {
	
		
		robot.newSchemaComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Person");		
		
		robot.unmapItems(comparison.Schema_Comparison);
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);
		
		
	}
	
	@Test
	public void testExpandTables() {
	
		robot.activateOptionDialogDataCompare();
		robot.DCOptionDialog_ShowTablesExpanded_off();
		
		robot.newSchemaComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Person", "Processes");		
		
		robot.expandItems();
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);
		
		  
	}
	
	@Test
	public void testCollapseTables() {
		
		robot.newSchemaComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Person", "Processes");		
		
		robot.collapseItems();
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);  
	}
	
	
	@Test
	public void testAutolayout() {
		

		robot.openFileNoMaximize(DBSDIFF_AUTOLAYOUT.getAbsolutePath());		
		
		robot.delay(40000);
		robot.maximizeFileWindow();
		
		robot.autolayout(comparison.Schema_Comparison);
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);  
	}
	
	
	//not in the Menu
	@Test
	public void testMapTableManually() {
		
		robot.newSchemaComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "ALL");
		
		robot.mapManuallyObject("Salary","Salaries", IMG_TRIANGLE_DATACOMPARISON.getAbsolutePath());
		
		robot.compareItems();
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);  
		
	}
	
	
	//not in the Menu
	@Test
	public void testMapTableManually_onError() {
		
		
		robot.newSchemaComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "ALL");
		
		robot.mapManuallyObject("Salary","Processes", IMG_TRIANGLE_DATACOMPARISON.getAbsolutePath());
		
		robot.compareItems();
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);  
	}

	
	
}
