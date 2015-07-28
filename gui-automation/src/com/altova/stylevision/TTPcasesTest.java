package com.altova.stylevision;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;
import static com.altova.stylevision.StyleVisionRobot.*;
import static com.altova.stylevision.Tag.BMG;
import static com.altova.stylevision.TagType.START;
import static com.altova.util.LoggerUtils.logger;


import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.altova.robots.CheckboxOption;
import com.altova.stylevision.StyleVisionRobot.View;
import com.altova.util.IOUtils;
import com.altova.util.XMLFileReader;


public class TTPcasesTest extends AbstractStyleVisionTest {
	private static final XMLFileReader myxml = new XMLFileReader("data\\stylevision\\guiautomation_catalog.xml");
	private static final String xInputfile[]=myxml.getAllValueOfNode("test:test-case","test:input-file");
	private static final String xdescription[]=myxml.getAllValueOfNode("test:test-case","test:description");
	private static final String xTestdir[]=myxml.getAllValueOfNode("test:test-case","test:basefile");
	private static final String xfurtherfiles[]=myxml.getAllValueOfNode("test:test-case","test:furtherfiles");
	
	/**
	 * TTPcases
	 * Catalog: guiautomation_catalog.xml
	 * 
	 * cases from testtrackpro for regressiontesting 
	 * catalog file index i=60 to ??
	 * 
	 */
	
	// TTP 29370
	@Test
	public void test_60_addlink1(){
		int i=60;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(filename);delay(4000);
		robot.setView(View.AUTHENTIC);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	// TTP 29370
	@Test
	public void test_61_expandTemplate(){
		int i=61;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(filename);delay(4000);
		robot.doubleClickMid(robot.findTag("Department",BMG)); delay(1000);  // expand global Template in Design
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	// TTP 19094
	@Test
	public void  test_62_cbxaddvalue(){
		int i=62;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(filename);delay(1000);
		robot.keyType(KeyEvent.VK_ESCAPE); delay(5000);  //ignore instance validation
		robot.setView(View.AUTHENTIC);delay(2000);
		robot.leftClickIcon(BASEPATH+"/tdata/19094/addStatus.bmp");delay(500);
		//robot.leftClick(645,robot.getMainWindow().y+186); //addStatus link absolute position
		robot.keyType(KeyEvent.VK_DOWN);delay(1000);    // select first value from cbx
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}	
	//addlink1
	@Test
	public void  test_63_addlink1(){
		int i=63;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(filename);delay(1000);
		robot.keyType(KeyEvent.VK_ESCAPE);delay(5000);   //ignore instance validation
		robot.setView(View.AUTHENTIC);delay(2000);
		//robot.scrollWindow(robot.getMainWindow(), 1.0);delay(1000);
		robot.leftClickIcon(BASEPATH+"/tdata/addlink1/add_subfig.bmp");delay(500);   //V2009 crashes here
		//robot.find_strg_f("note");
		//robot.leftClick(245,robot.getMainWindow().y+robot.getMainWindow().height-201); //add subfig  link absolute position
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}	
	// test_64_printpreview
	@Test
	public void   test_64_printpreview(){
		int i=64;
		logger.fine("TCASE: "+xdescription[i]);
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		robot.openFile(filename);delay(1000);
		robot.setView(View.AUTHENTIC);delay(2000);
		robot.leftClickMenuItem("File", "Print Preview");delay(4000);
		robot.keyTypeAlt(KeyEvent.VK_RIGHT);delay(1000);
		robot.keyTypeAlt(KeyEvent.VK_RIGHT);delay(1000);
		robot.keyTypeAlt(KeyEvent.VK_RIGHT);delay(1000);
		robot.keyTypeAlt(KeyEvent.VK_LEFT);delay(1000);
		assertAreas(TOP_WINDOW);
	}	
	// test_65_printpreview_smallmarkups
	@Test
	public void   test_65_printpreview_smallmarkups(){
		int i=64;
		logger.fine("TCASE: "+xdescription[i]);
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		robot.openFile(filename);delay(1000);
		robot.setView(View.AUTHENTIC);delay(2000);
		robot.showSmallMarkup();delay(2000);
		robot.leftClickMenuItem("File", "Print Preview");delay(4000);
		robot.keyTypeAlt(KeyEvent.VK_RIGHT);delay(1000);
		robot.keyTypeAlt(KeyEvent.VK_RIGHT);delay(1000);
		robot.keyTypeAlt(KeyEvent.VK_RIGHT);delay(1000);
		robot.keyTypeAlt(KeyEvent.VK_LEFT);delay(1000);
		assertAreas(TOP_WINDOW);
	}	
	// test_66_printpreview_largemarkups
	@Test
	public void   test_66_printpreview_largemarkups(){
		int i=64;
		logger.fine("TCASE: "+xdescription[i]);
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		robot.openFile(filename);delay(1000);
		robot.setView(View.AUTHENTIC);delay(2000);
		robot.showLargeMarkup();delay(2000);
		robot.leftClickMenuItem("File", "Print Preview");delay(4000);
		robot.keyTypeAlt(KeyEvent.VK_RIGHT);delay(1000);
		robot.keyTypeAlt(KeyEvent.VK_RIGHT);delay(1000);
		robot.keyTypeAlt(KeyEvent.VK_RIGHT);delay(1000);
		robot.keyTypeAlt(KeyEvent.VK_LEFT);delay(1000);
		assertAreas(TOP_WINDOW);
	}
	// test_67_ttp33294_addlink
	@Test
	public void   test_67_ttp33294_addlink(){
		int i=67;
		logger.fine("TCASE: "+xdescription[i]);
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		robot.openFile(filename);delay(1000);
		robot.setView(View.AUTHENTIC);delay(2000);
		robot.showLargeMarkup();delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
}