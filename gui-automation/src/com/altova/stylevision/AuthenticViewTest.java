package com.altova.stylevision;

import static com.altova.robots.SnapshotArea.CommonArea.*;
import static com.altova.util.LoggerUtils.logger;
import static com.altova.stylevision.Tag.*;
import static com.altova.stylevision.TagType.*;
import static com.altova.stylevision.Position.*;
import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.stylevision.StyleVisionRobot.View;
import com.altova.util.IOUtils;


public class AuthenticViewTest extends AbstractJUnitTest {
	protected static StyleVisionRobot robot;
	protected static final File MY_ORrgchartSPS=IOUtils.findFile("data/stylevision/tdata/AuthenticViewTest/orgchart.sps");
	protected static final String MY_OrgchartSPS_FILE=MY_ORrgchartSPS.getAbsolutePath();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new StyleVisionRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
		logger.fine("TCASE: TestCases for AuthentiView functionality");
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
		
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		robot.openFile(MY_OrgchartSPS_FILE);robot.delay(4000);
		robot.setView(View.AUTHENTIC);robot.delay(2000);
	
	}
	@After
	public void tearDown() throws Exception {
		logger.fine("TCASE: close all open files");
		robot.closeAll();
		//super.tearDown();
	}
	
	@Test
	public void  Edit_Undo(){
		robot.find_strg_f("The company was");
		robot.typeStringEnter("Lorem ipsum dolor sit amet");robot.delay(500);  //overwrite existing text
		robot.keyTypeCtrl(KeyEvent.VK_Z);delay(500);   //undo
		robot.find_strg_f("Administration");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void  Edit_Redo(){
		robot.find_strg_f("Since 1996");
		robot.typeStringEnter("Lorem ipsum dolor sit amet");robot.delay(500);  //overwrite existing text
		robot.keyTypeCtrl(KeyEvent.VK_Z);delay(500);   //undo 
		robot.keyTypeCtrl(KeyEvent.VK_Y);delay(500);   //redo
		robot.find_strg_f("Administration");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void  Edit_CutnPaste(){
		robot.find_strg_f("It released the first ");
		robot.keyTypeCtrl(KeyEvent.VK_X);delay(500);   //cut 
		robot.find_strg_f("Due to the fact");
		robot.keyType(KeyEvent.VK_LEFT);
		robot.keyTypeCtrl(KeyEvent.VK_V);delay(500);   //Paste
		robot.find_strg_f("Administration");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void  Edit_CopyPaste(){
		robot.find_strg_f("Callaby");
		robot.keyTypeCtrl(KeyEvent.VK_C);delay(500);   //copy
		robot.find_strg_f("Further");
		robot.keyType(KeyEvent.VK_LEFT);
		robot.keyTypeCtrl(KeyEvent.VK_V);delay(500);   //Paste
		robot.find_strg_f("Administration");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void  Edit_AddValidation(){
		robot.find_strg_f("471");
		robot.keyType(KeyEvent.VK_LEFT);
		robot.typeString("5");delay(500); 
		robot.find_strg_f("Administration");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void Edit_MoveElement_XML(){
		robot.showLargeMarkup();
		robot.find_strg_f("Callaby");delay(500); 
		Tag myTargetTag = new Tag("ts:italic", PEACH, END);
		Tag mySourceTag = new Tag("ts:bold", PEACH, START);
		robot.moveTag(mySourceTag, myTargetTag, AFTER);delay(2000);
		robot.pasteAs("Paste as XML");
		robot.find_strg_f("Administration");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void Edit_MoveElement_Text(){
		robot.showLargeMarkup();
		robot.find_strg_f("Callaby");delay(500);
		Tag myTargetTag = new Tag("ts:italic", PEACH, END);
		Tag mySourceTag = new Tag("ts:bold", PEACH, START);
		robot.moveTag(mySourceTag, myTargetTag, AFTER);delay(2000);
		robot.pasteAs("Paste as Text");
		robot.find_strg_f("Administration");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}	
	@Test
	public void Edit_TableAppendRow(){
		robot.scrollWindow(robot.getMainWindow(), 0.3);
		robot.find_strg_f("Matise");delay(500);
		robot.keyType(KeyEvent.VK_LEFT);    //go left to unselect text
		robot.AppendRow();
		robot.find_strg_f("Administration");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void Edit_TableInsertRow(){
		robot.scrollWindow(robot.getMainWindow(), 0.3);
		robot.find_strg_f("Matise");delay(500);
		robot.keyType(KeyEvent.VK_LEFT);    //go left to unselect text
		robot.InsertRow();
		robot.find_strg_f("Administration");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void Edit_TableDuplicateRow(){
		robot.scrollWindow(robot.getMainWindow(), 0.3);
		robot.find_strg_f("Matise");delay(500);
		robot.keyType(KeyEvent.VK_LEFT);    //go left to unselect text
		robot.DuplicateRow();	
		robot.find_strg_f("Administration");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void Edit_TableMoveRowUp(){
		robot.scrollWindow(robot.getMainWindow(), 0.3);
		robot.find_strg_f("Matise");delay(500);
		robot.keyType(KeyEvent.VK_LEFT);    //go left to unselect text
		robot.MoveRowUp();
		robot.find_strg_f("Administration");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void Edit_TableMoveRowDown(){
		robot.scrollWindow(robot.getMainWindow(), 0.3);
		robot.find_strg_f("Further");delay(500);
		robot.keyType(KeyEvent.VK_LEFT);    //go left to unselect text
		robot.MoveRowDown();
		robot.find_strg_f("Administration");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void  Edit_ParaEnter(){
		robot.showLargeMarkup();
		robot.find_strg_f("privately held software company.");
		robot.keyType(KeyEvent.VK_RIGHT);delay(500);   //unselect text and go right
		robot.keyType(KeyEvent.VK_ENTER);delay(500);   //adds a new para element
		robot.find_strg_f("Administration");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void Edit_TableDeleteRow(){
		robot.find_strg_f("Matise");delay(500);
		robot.DeleteRow();
		robot.find_strg_f("Administration");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	public static void setRobot(StyleVisionRobot robot) {
		AuthenticViewTest.robot = robot;
	}

}