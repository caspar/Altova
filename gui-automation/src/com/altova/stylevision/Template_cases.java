package com.altova.stylevision;

import static com.altova.robots.SnapshotArea.CommonArea.*;
import static com.altova.stylevision.Position.AFTER;
import static com.altova.stylevision.StyleVisionRobot.*;
import static com.altova.stylevision.Tag.PEACH;
import static com.altova.stylevision.TagType.*;
import static com.altova.util.LoggerUtils.logger;


import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.After;
import org.junit.Test;

import com.altova.robots.ScriptMistakeException;
import com.altova.util.IOUtils;
import com.altova.util.XMLFileReader;


public class Template_cases extends AbstractStyleVisionTest {
	private static final XMLFileReader myxml = new XMLFileReader("data\\stylevision\\guiautomation_catalog.xml");
	private static final String xInputfile[]=myxml.getAllValueOfNode("test:test-case","test:input-file");
	private static final String xdescription[]=myxml.getAllValueOfNode("test:test-case","test:description");
	private static final String xTestdir[]=myxml.getAllValueOfNode("test:test-case","test:basefile");
	
	/**
	 * Template_cases
	 * Catalog: guiautomation_catalog.xml
	 * 
	 * special cases using templates in authentic
	 * catalog file index i=46 to 50
	 * 
	 */
	/*
	@After
	public void CleanUp() {
		try {
			robot.keyType(KeyEvent.VK_ESCAPE);    //Press Escape to close any open msg window
		} catch(ScriptMistakeException e) {
			logger.fine("Could close window - probably already closed: "+e);
		}
	}
	*/

	@Test
	public void test26607(){
		int i=46;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(filename);delay(2000);
		robot.setView(View.AUTHENTIC);delay(5000);
		robot.find_strg_f("Long Title");
		robot.keyType(KeyEvent.VK_ESCAPE);delay(500);
		robot.keyType(KeyEvent.VK_RIGHT);delay(500);
		String[] insertitem=new String[]{"insert after","title","heading"};
		robot.auth_insertElementAtActualPosition(insertitem);delay(1000);
		robot.typeString("text of heading");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void test26607crash(){
		int i=46;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(filename);delay(2000);
		robot.setView(View.AUTHENTIC);delay(5000);
		robot.showLargeMarkup();delay(500);  //Markups are not shown due to bug - workaround in viewswitch
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void test26648(){
		int i=47;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(filename);delay(2000);
		robot.setView(View.HTML);delay(5000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void test17261(){
		int i=48;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(filename);delay(2000);
		robot.setView(View.AUTHENTIC);delay(2000);
		assertAreas(TOP_WINDOW);   //Schematree if this example is tested in SchematreeTest -test17261_schematree
	}
	
	@Test
	public void test11836(){
		int i=49;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(filename);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void test_chainedlist(){
		int i=50;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(filename);delay(2000);
		robot.setView(View.AUTHENTIC);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
}