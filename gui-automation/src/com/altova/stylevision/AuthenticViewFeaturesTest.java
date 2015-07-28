package com.altova.stylevision;

import static com.altova.robots.SnapshotArea.CommonArea.*;
import static com.altova.util.LoggerUtils.logger;
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


public class AuthenticViewFeaturesTest extends AbstractJUnitTest {
	protected static StyleVisionRobot robot;
	protected static final File MY_RichEditSPS=IOUtils.findFile("data/stylevision/tdata/RichEdit/RichEdit.sps");
	protected static final String MY_RichEditSPS_FILE=MY_RichEditSPS.getAbsolutePath();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new StyleVisionRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
		logger.fine("TCASE: TestCases for AuthenticViewFeatures functionality");
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		//robot.openFile(MY_OrgchartSPS_FILE);robot.delay(4000);
		//robot.setView(View.AUTHENTIC);robot.delay(2000);
	
	}
	
	@After
	public void tearDown() throws Exception {
		logger.fine("TCASE: close all open files");
		robot.closeAll();
		//super.tearDown();
	}
	@Test
	public void  CompositeStyle_SetStrikethrough(){
		robot.openFile(MY_RichEditSPS_FILE);robot.delay(4000);
		robot.setView(View.AUTHENTIC);robot.delay(2000);
		robot.find_strg_f("StyleVision");
		robot.SetRichEdit("Toggle Strikethrough");
		robot.keyType(KeyEvent.VK_DOWN);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void  CompositeStyle_SetAlignRight(){
		robot.openFile(MY_RichEditSPS_FILE);robot.delay(4000);
		robot.setView(View.AUTHENTIC);robot.delay(2000);
		robot.find_strg_f("Create");
		robot.SetRichEdit("Align Right");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void  RichEdit_UnderlineCombineSameNeighbour(){
		robot.openFile(MY_RichEditSPS_FILE);robot.delay(4000);
		robot.setView(View.AUTHENTIC);robot.delay(2000);
		robot.showLargeMarkup();
		robot.find_strg_f("Altova Style");
		robot.SetRichEdit("Toggle Underline");
		robot.find_strg_f("vision");
		robot.SetRichEdit("Toggle Underline");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	public static void setRobot(StyleVisionRobot robot) {
		AuthenticViewFeaturesTest.robot = robot;
	}
}