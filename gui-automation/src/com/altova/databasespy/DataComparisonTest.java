package com.altova.databasespy;

import static com.altova.databasespy.DatabaseSpyRobot.*;
import static com.altova.robots.SnapshotArea.CommonArea.DATACOMPARISON_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.VK_N;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.databasespy.DatabaseSpyRobot.comparison;

public class DataComparisonTest extends AbstractDatabaseSpyTest{

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
	public void testCompareTables() {
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "ALL");

		robot.compareTables();
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);
		
	}
	
	@Ignore
	@Test
	public void testMergLeftToRight() {
		
		robot.openFile(ORGCHART_SQL_DC_DEPARTMENT_CREATE);
		robot.execute();
		
		robot.refreshRootObject(IMG_REFRESH_ROOT_OBJ.getAbsolutePath(), QuickConnectParameter.Access_sourceName_Left);
		robot.refreshRootObject(IMG_REFRESH_ROOT_OBJ.getAbsolutePath(), QuickConnectParameter.Access_sourceName_Right);
		
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Department");

		robot.compareTables();

		robot.mergeLeftToRight();
		robot.checkMerge();
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);
		
		robot.closeAll();
	
		
		robot.openFile(ORGCHART_SQL_DC_DEPARTMENT_DROP);
		robot.modifyProperty("Data Source", QuickConnectParameter.Access_sourceName_Right);
		robot.execute();
		
		robot.refreshRootObject(IMG_REFRESH_ROOT_OBJ.getAbsolutePath(), QuickConnectParameter.Access_sourceName_Left);
		robot.refreshRootObject(IMG_REFRESH_ROOT_OBJ.getAbsolutePath(), QuickConnectParameter.Access_sourceName_Right);
		
	}
	
	@Ignore
	@Test
	public void testMergRightToLeft() {
		
	
		
		robot.openFile(ORGCHART_SQL_DC_DEPARTMENT_CREATE);
		robot.execute();

		robot.refreshRootObject(IMG_REFRESH_ROOT_OBJ.getAbsolutePath(), QuickConnectParameter.Access_sourceName_Left);
		robot.refreshRootObject(IMG_REFRESH_ROOT_OBJ.getAbsolutePath(), QuickConnectParameter.Access_sourceName_Right);

		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Department");

		robot.compareTables();

		robot.mergeRightToLeft();
		robot.checkMerge();
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);
		
		robot.closeAll();

		robot.openFile(ORGCHART_SQL_DC_DEPARTMENT_DROP);
		robot.execute();
		
		robot.refreshRootObject(IMG_REFRESH_ROOT_OBJ.getAbsolutePath(), QuickConnectParameter.Access_sourceName_Left);
		robot.refreshRootObject(IMG_REFRESH_ROOT_OBJ.getAbsolutePath(), QuickConnectParameter.Access_sourceName_Right);

	}
	
	
	@Test
	public void testShowResult() {
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Office");

		robot.compareTables();
		
		robot.showResults();
		
		assertAreas(DATACOMPARISON_OFFICE);
	}
	
	
	@Test
	public void testShowMergeScript_LeftToRight() {
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Office");

		robot.compareTables();
		
		robot.showMergeScriptLeftToRight(comparison.Data_Comparison);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public void testShowMergeScript_RightToLeft() {
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Office");

		robot.compareTables();
		
		robot.showMergeScriptRightToLeft(comparison.Data_Comparison);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public void testShowRestoreScript_Left() {
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Office");

		robot.compareTables();
		
		robot.showRestoreScriptLeft();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testShowRestoreScript_Right() {
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "Office");

		robot.compareTables();
		
		robot.showRestoreScriptRight();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testSortTables_Ascending() {
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "ALL");
		
		robot.SortTablesAscending(comparison.Data_Comparison);
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);
	}
	
	@Test
	public void testSortTables_Descending() {
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "ALL");
		
		robot.SortTablesDescending(comparison.Data_Comparison);
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);
	}
	
	@Test
	public void testSortTables_AscendingMappedFirst() {
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "ALL");
		
		robot.SortTablesAscendingMappedFirst(comparison.Data_Comparison);
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);
	}
	
	@Test
	public void testSortTables_DescendingMappedFirst() {
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "ALL");
		
		robot.SortTablesDescendingMappedFirst(comparison.Data_Comparison);
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);
	}
	
	
	@Test
	public void testMapItems() {
	
		robot.activateOptionDialogDataCompare();
		robot.DCOptionDialog_MapTablesAuto_off();
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "ALL");		
		
		robot.mapItems(comparison.Data_Comparison);
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);
		
	}
	
	@Test
	public void testUnmapItems() {
	
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "ALL");		
		
		robot.unmapItems(comparison.Data_Comparison);
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);
		
		
	}
	
	@Test
	public void testExpandTables() {
	
		robot.activateOptionDialogDataCompare();
		robot.DCOptionDialog_ShowTablesExpanded_off();
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "ALL");		
		
		robot.expandTables();
		robot.autolayout(comparison.Data_Comparison);
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);
		
		  
	}
	
	@Test
	public void testCollapseTables() {
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "ALL");		
		
		robot.collapseTables();
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);  
	}
	
	
	@Test
	public void testAutolayout() {
		

		robot.openFileNoMaximize(DBDIFF_AUTOLAYOUT.getAbsolutePath());		
		
		robot.delay(40000);
		robot.maximizeFileWindow();
		
		robot.autolayout(comparison.Data_Comparison);
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);  
	}
	
	
	//not in the Menu
	@Test
	public void testMapTableManually() {
		
		fail("Due to an incompatibilty on Drag&Drop method, actually the test cannot be exectuted correcty"); // TODO
		//seems that inputEvent.BUTTON1_MASK on com.altova.robots.GenericRobot.dragDropMid(Rectangle, Rectangle),
		//generates problem on compareTables() method: fails on clicking in menu Data Comparison > Compare Tables
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "ALL");
		
		robot.mapManuallyObject("Salary","Salaries", IMG_TRIANGLE_DATACOMPARISON.getAbsolutePath());
		
		robot.compareTables();
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);  
		
	}
	
	
	//not in the Menu
	@Test
	public void testMapTableManually_onError() {
		
		fail("Due to a Due to an incompatibilty on Drag&Drop method, actually the test cannot be exectuted correcty"); // TODO
		//see above testMapTableManually()
		
		robot.newDataComparison(QuickConnectParameter.Access_sourceName_Left, QuickConnectParameter.Access_sourceName_Right, "ALL");
		
		robot.mapManuallyObject("Salary","Processes", IMG_TRIANGLE_DATACOMPARISON.getAbsolutePath());
		
		robot.compareTables();
		
		assertAreas(DATACOMPARISON_MAIN_WINDOW);  
	}
	
	
}
