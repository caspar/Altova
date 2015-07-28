package com.altova.databasespy;

import static com.altova.databasespy.DatabaseSpyRobot.*;
import static java.awt.event.KeyEvent.*;


import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import org.junit.*;

import com.altova.util.IOUtils;

public class DesignEditorTest extends AbstractDatabaseSpyTest{

	
	@After
	public void setUpAfter() throws Exception {
		
		robot.closeAll();
		robot.escapeDialog("Save modified files", VK_D);
	}
	
	
	@Before
	public void setUpBefore() throws Exception {
		
		robot.openProject(ORGCHART_PQRJ_FILE.getAbsolutePath());
		robot.escapeDialog("DatabaseSpy", VK_Y);
		robot.escapeDialog("Do you want to close DatabaseSpy anyway and lose your", VK_Y);
		robot.escapeDialog("Are you sure you want to disconnect?", VK_Y);
		delay(3000);
		
	}
	
	
	@Test
	public void testCreateNewTable(){
		
		robot.newDesignEditor();
		
		robot.createNewTable();
		
		assertAreas(DATABASE_STRUCTUE, PROPERTIES, DIAGRAM_MAIN_WINDOW);
	}
	
	@Test	
	public void testCreateNewColumn(){
		
		robot.newDesignEditor();
		
		robot.createNewTable();
		robot.createNewColumn();
		
		assertAreas(DATABASE_STRUCTUE, PROPERTIES, DIAGRAM_MAIN_WINDOW);
	}
	
	@Test	
	public void testAddStickyNote(){
		
		robot.newDesignEditor();
		
		robot.addStickyNote();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testAddRelatedTables_ReferencedTables(){
		
		robot.openFile(ORGCHART_QDES_TABLE_PROCESSES.getAbsolutePath());
		
		robot.selectAllTables();
		
		robot.AddRelatedTables_ReferencedTables();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testAddRelatedTables_ReferencingTables(){
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAllTables();
		
		robot.AddRelatedTables_ReferencingTables();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testAddRelatedTables_AllRelations(){
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAllTables();
		
		robot.AddRelatedTables_AllRelations();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testShowInNewSQLEditor_Select(){
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAllTables();
		
		robot.showInNewSQLEditor(SQLopType.SELECT);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testShowInNewSQLEditor_Create(){
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAllTables();
		
		robot.showInNewSQLEditor(SQLopType.CREATE);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testShowInNewSQLEditor_Drop(){
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAllTables();
		
		robot.showInNewSQLEditor(SQLopType.DROP);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testShowInNewSQLEditor_Insert(){
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAllTables();
		
		robot.showInNewSQLEditor(SQLopType.INSERT);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public void testShowInNewSQLEditor_Update(){
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAllTables();
		
		robot.showInNewSQLEditor(SQLopType.UPDATE);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testShowInNewSQLEditor_Delete(){
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAllTables();
		
		robot.showInNewSQLEditor(SQLopType.DELETE);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	
	@Test
	public void testRetriveData_allrows(){
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAll();
		robot.retriveData_allrows();
		
		robot.scrollEndResultPane("PrimaryKey");
		
		assertAreas(RESULT);	
	}
	
	
	@Test
	public void testRetriveData_first200rows(){
	
		robot.openFile(ORGCHART_QDES_TABLE_PROCESSES.getAbsolutePath());
		
		robot.selectAll();
		robot.retriveData_first200rows();
		
		robot.scrollEndResultPane("ID");
		
		assertAreas(RESULT);
		
	}
	
	@Test
	public void testRetriveData_editData(){
		
		fail("Test omissis waiting the ttp 40296 fix"); // TODO
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAll();
		robot.editData();
		
		robot.editDataWithString("v.callaby@nanonull.com", "vc@nanonull.com");
		
		assertAreas(RESULT);
		
		robot.escapeDialog("DatabaseSpy", VK_Y);
		
	}

	
	
	@Test
	public void testZoomIn(){
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.zoomIn();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testZoomOut(){
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.zoomOut();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testZoomToFit(){
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.zoomToFit();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public void testAutoLayoutWholeDiagram(){
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.autoLayoutWholeDiagram();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testAutoLayoutSelectedTables(){
		
		robot.openFile(ORGCHART_QDES_TMP_FILE.getAbsolutePath());
		
		robot.selectAllTables();
		robot.autoLayoutSelectedTables();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testRemoveFromDesign(){
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAllTables();
		robot.removeFromDesign();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testDeleteSelectedObject(){
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAllTables();
		robot.deleteSelectedObject();
		
		robot.escapeDialog("DatabaseSpy", VK_ENTER);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	

	@Test
	public void testExportDatabaseData_XML(){
		
		
		removeAndAssert(EXPORT_XML_FILE);
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAllTables();
		robot.exportDatabaseData("XML", EXPORT_XML_FILE);
		
		assertFileExists(EXPORT_XML_FILE);	
	}
	
	
	
	@Test
	public void testExportDatabaseData_XMLStructure(){
		
		
		removeAndAssert(EXPORT_XMLSTRUCTURE_FILE);
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAllTables();
		robot.exportDatabaseData("XML Structure", EXPORT_XMLSTRUCTURE_FILE);
		
		assertFileExists(EXPORT_XMLSTRUCTURE_FILE);	
	}
	

	
	@Test
	public void testExportDatabaseData_CSV(){
		
		
		removeAndAssert(EXPORT_CSV_FILE);
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAllTables();
		robot.exportDatabaseData("CSV", EXPORT_CSV_FILE);
		
		assertFileExists(EXPORT_CSV_FILE);	
	}
	
	@Test
	public void testExportDatabaseData_CSV_delimiter(){
		
		
		removeAndAssert(EXPORT_CSV_FILE);
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAllTables();
		
		robot.setDelimiter("!");
		robot.exportDatabaseData("CSV", EXPORT_CSV_FILE);
		
		assertFileExists(EXPORT_CSV_FILE);	
	}
	
	
	
	@Test
	public void testExportDatabaseData_HTML(){
		
		
		removeAndAssert(EXPORT_HTML_FILE);
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAllTables();
		robot.exportDatabaseData("HTML", EXPORT_HTML_FILE);
		
		assertFileExists(EXPORT_HTML_FILE);	
	}
	
	@Test
	public void testExportDatabaseData_HTML_comments(){
		
		
		removeAndAssert(EXPORT_HTML_FILE);
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAllTables();
		
		robot.setIncludeComments(false);
		robot.exportDatabaseData("HTML", EXPORT_HTML_FILE);
		
		assertFileExists(EXPORT_HTML_FILE);	
	}

	@Test
	public void testExportDatabaseData_Excel(){
		
		
		removeAndAssert(EXPORT_Excel_FILE);
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAllTables();
		robot.exportDatabaseData("Excel", EXPORT_Excel_FILE);
		
		assertFileExists(EXPORT_Excel_FILE);	
	}
	
	@Test
	public void testExportDatabaseData_Excel_comments(){
		
		
		removeAndAssert(EXPORT_Excel_FILE);
		
		robot.openFile(ORGCHART_QDES_TABLE_PERSON.getAbsolutePath());
		
		robot.selectAllTables();
		
		robot.setIncludeComments(false);
		robot.exportDatabaseData("Excel", EXPORT_Excel_FILE);
		
		assertFileExists(EXPORT_Excel_FILE);	
	}
}
