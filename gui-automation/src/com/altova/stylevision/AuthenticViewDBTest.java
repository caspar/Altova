package com.altova.stylevision;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.util.LoggerUtils.logger;
import static com.altova.stylevision.StyleVisionRobot.*;
import static com.altova.stylevision.Tag.*;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.common.testcases.ExtractMenusTest;
import com.altova.robots.AltovaApplicationRobot;
import com.altova.util.IOUtils;
import com.altova.util.Settings.AltovaApplication;


public class AuthenticViewDBTest extends AbstractJUnitTest {
	protected static StyleVisionRobot robot;
	//protected static final String MY_SPS_FILE = AltovaApplication.STYLEVISION.getExamplesLocation().getAbsolutePath()+"\\DBSample.sps";
	//protected static final String MY_SPS_FILENAME ="DBSample.sps";
	protected static final File MY_SPS=IOUtils.findFile("data/stylevision/tdata/AuthenticViewDBTest/DBSample.sps");
	protected static final String MY_SPS_FILE=MY_SPS.getAbsolutePath();
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new StyleVisionRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
		logger.fine("TCASE: TestCases for AuthenticView Database functionality");
		//robot.openFile(MY_SPS_FILE);robot.delay(10000);
		//robot.closeAll();
	}
	@AfterClass
	public static void setUpAfterClass() throws Exception {
	
	}
	@Before
	public void setUp() throws Exception {
		super.setUp();
		robot.openFile(MY_SPS_FILE);robot.delay(4000);
		robot.setView(View.AUTHENTIC);robot.delay(2000);
		robot.showLargeMarkup();robot.delay(2000);
	}
	@After
	public void tearDown() throws Exception {
		logger.fine("TCASE: close all open files");
		robot.closeAll();
		//super.tearDown();
	}

	
	@Test
	public void  Edit_DB(){
		robot.find_strg_f("Vernon");
		robot.typeString("Jenny");robot.delay(500);  //overwrite existing text
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void  Edit_DBDeleteRow(){
		robot.find_strg_f("Callaby");delay(500);
		robot.keyType(KeyEvent.VK_RIGHT);delay(500);
		String[] deleteitem=new String[]{"Remove","Row of Person"};
		robot.auth_insertElementAtActualPosition(deleteitem);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void  Edit_DBDeleteRow_AuthenticMenu(){
		robot.find_strg_f("Callaby");delay(500);
		robot.keyType(KeyEvent.VK_RIGHT);delay(500);
		robot.DeleteRow();robot.delay(500);  //overwrite existing text
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void  Edit_insertDBRow(){
		robot.find_strg_f("Frank");
		robot.keyType(KeyEvent.VK_RIGHT);delay(500);
		robot.AppendRow();robot.delay(500);  //overwrite existing text
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void  Edit_duplicateDBRow(){
		robot.find_strg_f("Joe");
		robot.keyType(KeyEvent.VK_RIGHT);delay(500);
		robot.DuplicateRow();robot.delay(500);  //overwrite existing text
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void add_DBFilter(){
		robot.setView(View.DESIGN);robot.delay(1000);
		robot.activatePane(SCHEMATREE);
		robot.findElement("Department",PEACH);
		robot.addFilter("Name","Administration","Append &AND");
		robot.setView(View.HTML);robot.delay(3000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void add_Parameter(){
		robot.setView(View.DESIGN);robot.delay(1000);
		robot.addStylesheetParameter("myParam","Nanonull");
		robot.find_strg_f("City");robot.keyType(KeyEvent.VK_UP);   //set cursor position
		robot.addAutoCalc("$myParam");robot.keyType(KeyEvent.VK_RIGHT);robot.typeString(" headquarter at: ");
		robot.setView(View.HTML);robot.delay(3000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void add_DBFilterWithParameter(){
		robot.setView(View.DESIGN);robot.delay(1000);
		robot.addStylesheetParameter("myParam","Administration");
		robot.findElement("Department",PEACH);
		robot.addFilter("Name","$myParam", "Append &AND");robot.delay(1000);
		robot.find_strg_f("City");robot.keyType(KeyEvent.VK_UP);   //set cursor position
		robot.typeString("FilterParameter = ");robot.addAutoCalc("$myParam");
		robot.setView(View.HTML);robot.delay(3000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void combine_DBFilter(){
		robot.setView(View.DESIGN);robot.delay(1000);
		robot.findElement("Department",PEACH);
		robot.addFilter("Name","Administration", "Append &AND");robot.delay(1000);
		robot.addFilter("Name","Marketing", "Append &OR");robot.delay(1000);
		robot.setView(View.HTML);robot.delay(3000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void clear_DBFilter(){
		robot.setView(View.DESIGN);robot.delay(1000);
		robot.findElement("Department",PEACH);
		robot.addFilter("Name","Administration", "Append &AND");robot.delay(1000);
		robot.setView(View.HTML);robot.delay(3000);
		robot.setView(View.DESIGN);robot.delay(3000);
		robot.findElement("Department",PEACH);
		robot.clearDBFilter();
		robot.setView(View.HTML);robot.delay(3000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	public static void setRobot(StyleVisionRobot robot) {
		AuthenticViewDBTest.robot = robot;
	}
	
}