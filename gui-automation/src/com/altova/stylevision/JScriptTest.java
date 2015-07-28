package com.altova.stylevision;

import static com.altova.robots.SnapshotArea.CommonArea.*;
import static com.altova.stylevision.StyleVisionRobot.*;
import static com.altova.util.LoggerUtils.logger;


import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.After;
import org.junit.Test;
import org.junit.Ignore;

import com.altova.robots.ScriptMistakeException;
import com.altova.stylevision.StyleVisionRobot.View;
import com.altova.util.IOUtils;
import com.altova.util.XMLFileReader;


public class JScriptTest extends AbstractStyleVisionTest {
	private static final XMLFileReader myxml = new XMLFileReader("data\\stylevision\\guiautomation_catalog.xml");
	private static final String xInputfile[]=myxml.getAllValueOfNode("test:test-case","test:input-file");
	private static final String xTestdir[]=myxml.getAllValueOfNode("test:test-case","test:basefile");
	private static final String xdescription[]=myxml.getAllValueOfNode("test:test-case","test:description");

	@After
	public void CleanUp() {
		try {
			robot.escapeDialog("date", KeyEvent.VK_ESCAPE);
			robot.keyType(KeyEvent.VK_ESCAPE);    //Press Escape to close any open msg window
		} catch(ScriptMistakeException e) {
			logger.fine("Could close window - probably already closed: "+e);
		}
	}

	@Test
	//@Ignore
	public void  jscript_edit(){
		int i=8;
		String myfunction="function mytest(){}";
		logger.fine("TCASE: "+xdescription[i]);
		robot.newSPS("New (empty)");
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.typeStringEnter("Jscript Test: generate alert window");delay(500);
		robot.setView(View.DESIGNBOLD);
		robot.selectJavascript();
		robot.leftClick(300,250);delay(500);  // click somewhere on main design to start edit
		robot.typeStringEnter(myfunction);
		robot.activatePane(DESIGNTREE);
		robot.expandElement("Scripts");
		assertAreas(DESIGNTREE);
	}
	
	@Test
	//@Ignore
	public void js_innerhtml_onload_html(){
		int i=9;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.HTML);delay(2000);
		robot.leftClickIcon(BASEPATH+"/tdata/jscript/radio.bmp");delay(1000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void js_innerhtmlwithvar_onload_html(){
		int i=11;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.HTML);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	//@Ignore
	public void js_alert_onclick_html(){
		int i=13;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.HTML);delay(2000);
//		robot.leftClick(316,162);delay(1000);//Click Option box
		robot.leftClickIcon(BASEPATH+"/tdata/jscript/optionbox.bmp");delay(1000);
		assertAreas(TOP_WINDOW);
	}
	
	@Test
	//@Ignore
	public void js_alert_onclickonEditField_html(){
		int i=15;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.HTML);delay(2000);
		//robot.leftClick(240,200);//Click Edit Field
		robot.leftClickIcon(BASEPATH+"/tdata/jscript/EdField_right.bmp");delay(1000);
		assertAreas(TOP_WINDOW);
	}
	
	@Test
	//@Ignore
	public void js_alertonclick_importmoduls_html(){
		int i=17;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.HTML);delay(3000);
//		robot.leftClick(619,230); delay(1000);  // click EUROS option box to show msg
		//robot.leftClickIcon(BASEPATH+"/tdata/jscript/radio_euro.bmp");delay(1000);
		robot.leftClick(620,robot.getMainWindow().y+134);delay(1000);
		assertAreas(TOP_WINDOW);
	}

	@Test
	//@Ignore
	public void js_alertonclick_importmoduls_html_2(){
		int i=17;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.HTML);delay(3000);
		//robot.leftClick(555,330);robot.leftClick(555,330);delay(1000);   // double click detailed report box to get alert window
		robot.leftClickIcon(BASEPATH+"/tdata/jscript/optionbox.bmp");delay(1000);
		assertAreas(TOP_WINDOW);
	}

	@Test
	//@Ignore
	public void js__importmoduls_html(){
		int i=18;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.HTML);delay(3000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	//@Ignore
	public void js_importmoduls(){
		int i=19;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.activatePane(DESIGNTREE);
		robot.expandElement("Scripts"); 
		assertAreas(DESIGNTREE);
	}
}