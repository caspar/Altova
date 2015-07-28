package com.altova.stylevision;

import static com.altova.stylevision.StyleVisionRobot.*;
import static com.altova.robots.SnapshotArea.CommonArea.ALLSTYLES_SV;
import static com.altova.util.LoggerUtils.logger;
import static com.altova.stylevision.Tag.BW;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.util.IOUtils;
import com.altova.util.Settings.AltovaApplication;


public class StylesForContentTest extends AbstractJUnitTest {
	protected static StyleVisionRobot robot;
	protected static final File MY_SPS_FILE=IOUtils.findFile("data/stylevision/tdata/StylesForContentTest/tables.sps");
	protected static final String MY_SampleSPS=MY_SPS_FILE.getAbsolutePath();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new StyleVisionRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
		
		logger.fine("TCASE: TestCases to check StylesFor Pane in Styles Window");
		robot.openFile(MY_SampleSPS);robot.delay(5000);
		robot.activatePane(STYLES);
		robot.activatePane(DESIGNTREE);
		robot.setPaneSize(DESIGNTREE, 200, 700);
		robot.expandElement("tables");
	
	}
	@AfterClass
	public static void setUpAfterClass() throws Exception {
		robot.setPaneSize(DESIGNTREE, 200, 481);
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public static void setRobot(StyleVisionRobot robot) {
		AbstractStyleVisionTest.robot = robot;
	}
	/*
	@Test
	public void  gltemplate(){
		robot.findElement("global template", BW);
		assertAreas(ALLSTYLES_SV);
	}
	*/
	@Test
	public void  para1(){
		robot.findElement("paragraph (h2)", BW);
		assertAreas(ALLSTYLES_SV);
	}
	@Test
	public void  text1(){
		robot.findElement("paragraph (p)", BW);delay(500);
		robot.keyType(KeyEvent.VK_DOWN);delay(500);
		assertAreas(ALLSTYLES_SV);
	}
	@Test
	public void  table1(){
		robot.findElement("table body (columns)", BW);
		robot.keyType(KeyEvent.VK_UP);delay(500);
		assertAreas(ALLSTYLES_SV);
	}
	@Test
	public void  tablebodycol1(){
		robot.findElement("table body (columns)", BW);
		assertAreas(ALLSTYLES_SV);
	}
	@Test
	public void  tablecol1(){
		robot.findElement("table column", BW);
		assertAreas(ALLSTYLES_SV);
	}
	@Test
	public void  tablebodyrow1(){
		robot.findElement("table body (rows)", BW);
		assertAreas(ALLSTYLES_SV);
	}
	@Test
	public void  tablerow1(){
		robot.findElement("table row", BW);
		assertAreas(ALLSTYLES_SV);
	}
	@Test
	public void  tablecell1(){
		robot.findElement("table cell", BW);
		assertAreas(ALLSTYLES_SV);
	}
	@Test
	public void  tablecelltext1(){
		robot.findElement("table cell", BW);delay(500);
		robot.keyType(KeyEvent.VK_DOWN);delay(500);
		assertAreas(ALLSTYLES_SV);
	}
}