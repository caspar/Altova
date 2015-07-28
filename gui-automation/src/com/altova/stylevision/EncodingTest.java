package com.altova.stylevision;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.util.LoggerUtils.logger;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Test;

import com.altova.stylevision.StyleVisionRobot.View;
import com.altova.util.IOUtils;
import com.altova.util.XMLFileReader;


public class EncodingTest extends AbstractStyleVisionTest {
	private static final XMLFileReader myxml = new XMLFileReader("data\\stylevision\\guiautomation_catalog.xml");
	private static final String xInputfile[]=myxml.getAllValueOfNode("test:test-case","test:input-file");
	private static final String xbasefile[]=myxml.getAllValueOfNode("test:test-case","test:basefile");
	private static final String xdescription[]=myxml.getAllValueOfNode("test:test-case","test:description");
	private static final String keystring="@!&/()=?ביüצה";
	
	
	@Test
	public void test16244(){
		int i=1;
		//String keystring="@!&/()=?ביüצהƒÜײףת÷¿";
		logger.fine("TCASE: "+xdescription[i]);
		robot.newSPS("New (empty)");
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.maximizeFileWindow();
		robot.typeStringEnter(keystring);delay(500);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void test16244_auth(){
		int i=2;
		File MY_TestCase_File=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
		String myInputfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(myInputfile);
		robot.setView(View.AUTHENTIC);delay(4000);
		robot.find_strg_f("Organization");delay(500);
		robot.keyType(KeyEvent.VK_HOME);delay(500);
		robot.typeString(keystring);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void test16244_html(){
		int i=3;
		//String keystring="@!&/()=?ביüצה";
		logger.fine("TCASE: "+xdescription[i]);
		robot.newSPS("New (empty)");
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.typeStringEnter(keystring);delay(500);
		robot.setView(View.HTML);delay(5000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void test16244_pdf(){
		int i=4;
		//String keystring="@!&/()=?ביüצה";
		logger.fine("TCASE: "+xdescription[i]);
		robot.newSPS("New (empty)");
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.maximizeFileWindow();
		robot.typeStringEnter(keystring);delay(500);
		robot.setView(View.PDF);delay(20000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void test16244_rtf(){
		int i=5;
		//String keystring="@!&/()=?ביüצה";
		logger.fine("TCASE: "+xdescription[i]);
		robot.newSPS("New (empty)");
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.typeStringEnter(keystring);delay(500);
		robot.setView(View.RTF);delay(20000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	/*  skip - problems with winword 2007
	@Test
	public void test16244_wml(){
		int i=6;
		//String keystring="@!&/()=?ביüצה";
		logger.fine("TCASE: "+xdescription[i]);
		robot.newSPS("New (empty)");
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		//select first line in main template
//		robot.leftClick(225,158);delay(500);  //select first line in main template  - bug in V2009- first line selection fails
//		robot.leftClick(285,125);delay(500);  //select first line in main template
//		robot.keyType(KeyEvent.VK_HOME);
		robot.setView(View.MAIN_TEMPLATE);   //Bitmap search instead of absolute position
		robot.keyType(KeyEvent.VK_DOWN);
		robot.typeStringEnter(keystring);delay(500);
		robot.setView(View.WML);delay(8000);
		for(i=0;i<3;i++){
			robot.leftClickButton("Ok");delay(500);
		}
		delay(10000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
*/
}