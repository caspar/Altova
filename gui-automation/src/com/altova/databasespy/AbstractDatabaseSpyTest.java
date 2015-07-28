package com.altova.databasespy;

import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.*;

import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Hashtable;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.robots.AltovaApplicationRobot;
import com.altova.robots.ScriptMistakeException;
import com.altova.util.IOUtils;
import com.altova.util.Settings.AltovaApplication;


public class AbstractDatabaseSpyTest extends AbstractJUnitTest{

	protected static DatabaseSpyRobot robot;
	
	protected static final File ORGCHART_PQRJ_FILE = IOUtils.findFile("examplesDBSpy/OrgChart.qprj");	
	protected static final File ORGCHART_PQRJ_FILE_DISCONNECTED = IOUtils.findFile("examplesDBSpy/OrgChart_disc.qprj");
	protected static final File ORGCHART_NNN_CONNECTED = IOUtils.findFile("examplesDBSpy/ConnectionTest.qprj");
	protected static final File ORGCHART_NNN_DISCONNECTED = IOUtils.findFile("examplesDBSpy/DisconnectionTest.qprj");
	protected static final File ORGCHART_PQRJ_DATACOMPARISON = IOUtils.findFile("examplesDBSpy/OrgChartDataComparison.qprj");	
	
	//protected static final File QC_MICROSOFT_ACCESS_03 = IOUtils.findFile("OrgChartDB.mdb");
	//protected static final File QC_MICROSOFT_ACCESS_07 = IOUtils.findFile("OrgChartDB.mdb");
	
	protected static final File ORGCHART_PQRJ_SAVED_FILE = IOUtils.findFile("examplesDBSpy/OrgChartSavedAs.mdb");
	
	protected static final File ORGCHART_PQRJ_SAVED_FILE_TMP  = IOUtils.findFile("examplesDBSpy/OrgChartTMP.sql");
	protected static final File ORGCHART_PQRJ_SAVED_FILE_TMP_2  = IOUtils.findFile("examplesDBSpy/OrgChart_query2.sql");
	protected static final File ORGCHART_PQRJ_SAVED_FILE_TMP_SAVEDAS  = IOUtils.findFile("examplesDBSpy/OrgChartTMP_2.sql");
	
	protected static final File ORGCHART_SQL_WRAP_FILE  = IOUtils.findFile("examplesDBSpy/OrgChartWrapTest.sql");
	protected static final File ORGCHART_SQL_DEMO_INSERT_FILE  = IOUtils.findFile("examplesDBSpy/Demo_Insert.sql");	
	protected static final File ORGCHART_SQL_TMP_BLOCK_COMMENT  = IOUtils.findFile("examplesDBSpy/OrgChartTMP_block_comment.sql");
	protected static final File ORGCHART_SQL_TMP_LINE_COMMENT  = IOUtils.findFile("examplesDBSpy/OrgChartTMP_line_comment.sql");
	protected static final File ORGCHART_SQL_TMP_COMMENTED  = IOUtils.findFile("examplesDBSpy/OrgChartTMP_commented.sql");	
	protected static final File ORGCHART_SQL_TMP_EUROPA_SELECT  = IOUtils.findFile("examplesDBSpy/OrgChartTMP_Europa_select.sql");
	protected static final File ORGCHART_SQL_TMP_EUROPA_SELECT_CSV1  = IOUtils.findFile("examplesDBSpy/OrgChartTMP_Europa_select_csv1.sql");
	protected static final File ORGCHART_SQL_TMP_EUROPA_SELECT_CSV2  = IOUtils.findFile("examplesDBSpy/OrgChartTMP_Europa_select_csv2.sql");
	protected static final File ORGCHART_SQL_TMP_EUROPA_SELECT_CSV3 = IOUtils.findFile("examplesDBSpy/OrgChartTMP_Europa_select_csv3.sql");
	protected static final File ORGCHART_SQL_TMP_EUROPA_DROP  = IOUtils.findFile("examplesDBSpy/OrgChartTMP_Europa_drop.sql");
	protected static final File ORGCHART_SQL_DC_DEPARTMENT_CREATE = IOUtils.findFile("examplesDBSpy/OrgChartDBComparison_Department.sql");	
	protected static final File ORGCHART_SQL_DC_DEPARTMENT_DROP   = IOUtils.findFile("examplesDBSpy/OrgChartDBComparison_Department_drop.sql");
	//protected static final File SQL_SAVED_FILE_TEST = IOUtils.findFile("SQL_generic_tmp_file.sql") ;
	
	protected static final File ORGCHART_QDES_TABLE_PROCESSES  = IOUtils.findFile("examplesDBSpy/DesignEditor_Processes.qdes");
	protected static final File ORGCHART_QDES_TABLE_PERSON  = IOUtils.findFile("examplesDBSpy/DesignEditor_Person.qdes");	
	protected static final File ORGCHART_QDES_TMP_FILE  = IOUtils.findFile("examplesDBSpy/DesignEditor_constraint.qdes");
	protected static final File ORGCHART_QDES_MIX_TABLES  = IOUtils.findFile("examplesDBSpy/DesignEditor_mixTables.qdes");
	
	protected static final File EXPORT_XML_FILE  = IOUtils.findFile("examplesDBSpy/exportXMLResult1.xml");
	protected static final File EXPORT_XMLSTRUCTURE_FILE  = IOUtils.findFile("examplesDBSpy/exportXML_StructurePerson.xml");
	protected static final File EXPORT_CSV_FILE  = IOUtils.findFile("examplesDBSpy/exportCSVResult1.csv");
	protected static final File EXPORT_HTML_FILE  = IOUtils.findFile("examplesDBSpy/exportHTMLResult1.html");
	protected static final File EXPORT_Excel_FILE  = IOUtils.findFile("examplesDBSpy/exportExcelResult1.xls");
	
	protected static final File IMPORT_XML_FILE_INSERT  = IOUtils.findFile("examplesDBSpy/importXMLEuropa_insert.xml");
	protected static final File IMPORT_XML_FILE_UPDATE  = IOUtils.findFile("examplesDBSpy/importXMLEuropa_update.xml");
	protected static final File IMPORT_XML_FILE_UPDATE_2  = IOUtils.findFile("examplesDBSpy/importXMLEuropa_update_2.xml");

	protected static final File IMG_TRIANGLE_DATACOMPARISON  = IOUtils.findFile("tag_list/ICON_ALTOVA_TRIANGLE_DATACOMPARISON.PNG");
	protected static final File IMG_REFRESH_ROOT_OBJ  = IOUtils.findFile("tag_list/ICON_ALTOVA_REFRESH.PNG");
	protected static final File IMG_CONNECT_DB = IOUtils.findFile("tag_list/ICON_ALTOVA_CONNECTED_DB.PNG");
	
	protected static final File IMPORT_CSV_FILE_INSERT  = IOUtils.findFile("examplesDBSpy/importCSVEuropa_insert.txt");
	protected static final File IMPORT_CSV_FILE_INSERT_DEL  = IOUtils.findFile("examplesDBSpy/importCSVEuropa_insert_delimiter.txt");	
	protected static final File IMPORT_CSV_FILE_UPDATE  = IOUtils.findFile("examplesDBSpy/importCSVEuropa_update.txt");

	protected static final File DBDIFF_AUTOLAYOUT  = IOUtils.findFile("examplesDBSpy/AutolayoutDataComparison.dbdif");	
	protected static final File DBSDIFF_AUTOLAYOUT  = IOUtils.findFile("examplesDBSpy/AutolayoutSchemaComparison.dbsdif");
	
	protected final static String QC_MICROSOFT_ACCESS    = "Microsoft Access ( ADO )";
	protected final static String QC_MICROSOFT_SQLSERVER = "Microsoft SQL Server";
	protected final static String QC_ORACLE = "Oracle ( ODBC )";
	protected final static String QC_MYSQL = "MySQL ( ODBC )";
	protected final static String QC_DB2 = "IBM DB2 ( ODBC )";
	protected final static String QC_SYBASE = "Sybase ( ODBC )";
	
	protected File IMPORT_LOG_FILE         = IOUtils.findFile("logImportEuropa.log");
	
	protected static final File PRJ_SQLITE_FILE  = IOUtils.findFile("examplesDBSpy/SQLiteTest.qprj");
	
	
	/*
	 * Contain ALL the list of ODBC created from the Window user
	 * All the list will be erased. 
	 * 
	 */
	protected final static String ODBCCollectionList = "HKCU\\Software\\ODBC\\ODBC.INI";
	
	protected final static File ALL_FROM_PERSON_SQL = IOUtils.findFile("ALL_FROM_PERSON.sql");
	
	public enum SQLopType {SELECT, CREATE, DROP, INSERT, UPDATE, DELETE, Alter};
	
	
	@BeforeClass
	public static void setUpBeforeClassDatabaseSpy() throws Exception {
		if(robot == null) {
			robot = new DatabaseSpyRobot();
		}
		
		AbstractJUnitTest.setUpBeforeClass(robot);
		
		
		robot.openProject(ORGCHART_PQRJ_FILE.getAbsolutePath());
		
		robot.setPaneSize(DatabaseSpyRobot.OUTPUT, -1, 200);
		robot.setPaneSize(DatabaseSpyRobot.PROPERTIES, -1, 450);
		robot.setPaneSize(DatabaseSpyRobot.PROJECT, 300, -1);	
		
	}

	@Before
	public void setUp() throws Exception {

		//super.setUp();
		robot.openProject(ORGCHART_PQRJ_FILE.getAbsolutePath());
		robot.openFile(ORGCHART_PQRJ_SAVED_FILE_TMP);

		
	}



	@After
	public void tearDown() throws Exception {
		super.tearDown();
		try {
			
			//null
			
		} catch(ScriptMistakeException e) {
			logger.fine("Could not close files - probably none open: "+e);
		}
	}
	
	public static void setRobot(DatabaseSpyRobot robot) {
		AbstractDatabaseSpyTest.robot = robot;
	}
	
	
	@AfterClass
	public static void tearDownAfter() throws Exception {
		//if(runBeforeAfterClass) {
			//try three times
			for (int i = 0; i < 3 && robot.isApplicationRunning(); i++) {
				logger.fine("Trying to exit application after test was finished");
				try {
					robot.exitApplication();
					robot.escapeDialog("Do you want to close DatabaseSpy anyway and lose your", VK_Y);
					
				} catch(ScriptMistakeException e) {
					logger.warning("Failed to click exit for some reason: "+e);
				}
				robot.delay(15000);
				robot.keyType(KeyEvent.VK_ESCAPE); robot.delay(500);
			}
		//}
	}
	
	
}
