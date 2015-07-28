package com.altova.databasespy;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static com.altova.databasespy.DatabaseSpyRobot.*;

public class ToolMenuTest extends AbstractDatabaseSpyTest{



	@After
	public final void setUpAfterTool() {	
		
		robot.closeAll();
		robot.openFile(ORGCHART_SQL_TMP_EUROPA_DROP.getAbsolutePath());
		robot.execute();
		robot.closeAll();
		
	}
	
	@Before
	public final void setUpBeforeImport() {	
		
		robot.openProject(ORGCHART_PQRJ_FILE.getAbsolutePath());
		robot.refreshRootObject(IMG_REFRESH_ROOT_OBJ.getAbsolutePath(),
								IMG_CONNECT_DB.getAbsolutePath());
		
	}
	
	
	
	@Ignore	
	@Test
	public final void testExportDatabaseData() {
		
		robot.openFile(ORGCHART_SQL_TMP_EUROPA_DROP.getAbsolutePath());
		fail("Test already implemented in Design Editor test"); 
		
	}
	

	@Test
	public final void testImportDataToTheDatabase_XML_Create() {
		 
		
		robot.importDataToTheDatabase(IMPORT_XML_FILE_INSERT.getAbsolutePath(), "XML", SQLopType.CREATE, "europa");
		
		robot.openFile(ORGCHART_SQL_TMP_EUROPA_SELECT.getAbsolutePath());
		robot.execute();
		
		assertAreas(RESULT);
		
		
	}
	

	@Test
	public final void testImportDataToTheDatabase_XML_Update() {

		robot.importDataToTheDatabase(IMPORT_XML_FILE_INSERT.getAbsolutePath(), "XML", SQLopType.CREATE, "europa");
		
		robot.importDataToTheDatabase(IMPORT_XML_FILE_UPDATE.getAbsolutePath(), "XML", SQLopType.UPDATE, "europa");
		
		robot.openFile(ORGCHART_SQL_TMP_EUROPA_SELECT.getAbsolutePath());
		robot.execute();
		
		assertAreas(RESULT);
		
		
	}
	

	@Test
	public final void testImportDataToTheDatabase_XML_UpdateCreate() {
		 		
		robot.importDataToTheDatabase(IMPORT_XML_FILE_UPDATE.getAbsolutePath(), "XML", SQLopType.SELECT, "europa");
		
		robot.importDataToTheDatabase(IMPORT_XML_FILE_UPDATE_2.getAbsolutePath(), "XML", SQLopType.SELECT, "europa");
		
		robot.openFile(ORGCHART_SQL_TMP_EUROPA_SELECT.getAbsolutePath());
		robot.execute();
		
		assertAreas(RESULT);
		
	}

	
	@Test
	public final void testImportDataToTheDatabase_XML_Create_exec() {
		
		robot.importDataToTheDatabase(IMPORT_XML_FILE_INSERT.getAbsolutePath(), "XML", SQLopType.CREATE, false, "europa");
		
		robot.openFile(ORGCHART_SQL_TMP_EUROPA_SELECT.getAbsolutePath());
		robot.execute();
		
		assertAreas(RESULT);
		
	}
	
	@Test
	public final void testImportDataToTheDatabase_CSV_Create() {
		 		
		robot.importDataToTheDatabase(IMPORT_CSV_FILE_INSERT.getAbsolutePath(), "CSV", SQLopType.CREATE, "europa");
		
		robot.openFile(ORGCHART_SQL_TMP_EUROPA_SELECT_CSV1.getAbsolutePath());
		robot.execute();
		
		assertAreas(RESULT);
		
		
	}
	
	@Test
	public final void testImportDataToTheDatabase_CSV_UpdateCreate_exec() {
		 		
		robot.importDataToTheDatabase(IMPORT_CSV_FILE_UPDATE.getAbsolutePath(), "CSV", SQLopType.SELECT, false, "europa");
		
		robot.openFile(ORGCHART_SQL_TMP_EUROPA_SELECT_CSV2.getAbsolutePath());
		robot.execute();
		
		assertAreas(RESULT);
		
		
	}
	
	
	@Test
	public final void testImportDataToTheDatabase_XML_Create_exec_log() {
		
		removeAndAssert(IMPORT_LOG_FILE);
		
		robot.setLogFile(true);
		robot.importDataToTheDatabase(IMPORT_XML_FILE_INSERT.getAbsolutePath(), "XML", SQLopType.CREATE, false, "europa");
		
		//robot.openFile(ORGCHART_SQL_TMP_EUROPA_SELECT.getAbsolutePath());
		//robot.execute();
		
		assertFileExists(IMPORT_LOG_FILE);
		
	}
	
	@Test
	public final void testImportDataToTheDatabase_CSV_Create_log() {
		
		removeAndAssert(IMPORT_LOG_FILE);
		
		robot.setLogFile(true);
		robot.importDataToTheDatabase(IMPORT_CSV_FILE_INSERT.getAbsolutePath(), "CSV", SQLopType.CREATE, false, "europa");
		
		//robot.openFile(ORGCHART_SQL_TMP_EUROPA_SELECT_CSV1.getAbsolutePath());
		//robot.execute();
		
		assertFileExists(IMPORT_LOG_FILE);
		
		
	}
	
	@Test
	public final void testImportDataToTheDatabase_XML_Create_primaryoff() {
		
		robot.setCreatePrimaryKeys(false);
		robot.importDataToTheDatabase(IMPORT_XML_FILE_INSERT.getAbsolutePath(), "XML", SQLopType.CREATE, "europa");
		
		robot.openFile(ORGCHART_SQL_TMP_EUROPA_SELECT.getAbsolutePath());
		robot.execute();
		
		assertAreas(RESULT);
		
		
	}
	
	@Test
	public final void testImportDataToTheDatabase_CSV_CreateUpdate_delimiter() {
		
		robot.setDelimiter("--");
		robot.importDataToTheDatabase(IMPORT_CSV_FILE_INSERT_DEL.getAbsolutePath(), "CSV", SQLopType.SELECT, "europa");
		
		robot.openFile(ORGCHART_SQL_TMP_EUROPA_SELECT_CSV3.getAbsolutePath());
		robot.execute();
		
		assertAreas(RESULT);
		
		
	}
	
	
}
