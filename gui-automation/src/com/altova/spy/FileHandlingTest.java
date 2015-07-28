/**
 * 
 */
package com.altova.spy;

import java.awt.event.KeyEvent;
import java.io.File;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;
import static com.altova.spy.SpyRobot.VALIDATION;
import static com.altova.util.LoggerUtils.logger;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.nativegui.ComponentInfo;
import com.altova.nativegui.NativeGUI;
import com.altova.robots.PluginRobot;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;
import com.altova.util.IOUtils;


/**
 * @author b.lopez
 *This set of testcases was written for XMLSpy and covers file handling customer bugs received in the past
 */

public class FileHandlingTest extends AbstractXmlSpyTest {

	private static final File TTP_10572_XSD_FILE = IOUtils.findFile("spy/examples/ttp10572.xsd");
	private static final File TTP_43695_1_XML_FILE = IOUtils.findFile("spy/examples/ttp43695_1.xml");
	private static final File TTP_43695_2_XML_FILE = IOUtils.findFile("spy/examples/ttp43695_2.xml");
	private static final File ANY_XSD_FILE=new File("C:\\temp\\test_xsd.xsd");

	// due to a GUI change, is it not possible to click ESC to close the window error message 
	@Ignore
	@Test
	public void test_ttp9276(){
		RadioOption format = new RadioOption("Generic",true);
		robot.newFile("XSLT Stylesheet v1.0",format,"Create new XSL/XSLT file", null, null);
		robot.gotoLine(3,100);
		delay(2000); 
		robot.keyType(KeyEvent.VK_ENTER); //intro jumps to next line 
		robot.typeStringEnter("<xsl:output/>");
		robot.saveFile();delay(2000);
		robot.escapeDialog("Save As", KeyEvent.VK_ESCAPE);
		delay(200);
		ComponentInfo ci = NativeGUI.getForegroundWindowInfo();
		assertEquals("Altova XMLSpy - [Untitled1.xslt *]", ci.getWindowText());
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void test_ttp10572(){
		robot.leftClick("ID_FILE_OPEN");delay(1000);
		robot.typeStringEnter(TTP_10572_XSD_FILE.getAbsolutePath());
		robot.delay(1000);
		robot.escapeDialog("SchemaView is unable to load following schema",KeyEvent.VK_ESCAPE);
		if(!(this instanceof PluginRobot)){
			robot.maximizeFileWindow();
		}
		robot.leftClickMenuItem("Schema design","Schema Settings");
		robot.delay(2000);
		robot.keyType(KeyEvent.VK_ESCAPE);
		robot.delay(500);
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);

	}
	
	@Test
	public void test_ttp15900(){
		if(ANY_XSD_FILE.exists()) {
			ANY_XSD_FILE.delete();
		}
		assertFileNotExists(ANY_XSD_FILE);
		robot.openFile(ITEMS_DTD_FILE);
		robot.newFile("XML Schema 1.0");
		delay(5000);
		robot.textView();
		robot.replaceFirst("ENTER_NAME_OF_ROOT_ELEMENT_HERE", "test");
		robot.leftClickMenuItem("File", "Close All");
		delay(200); 
		robot.escapeDialog("Save changes to", KeyEvent.VK_ESCAPE); //escaping the dialog
		robot.saveFile();delay(500);
		robot.typeStringEnter(ANY_XSD_FILE.getAbsolutePath());
		delay(300);
		assertFileExists(ANY_XSD_FILE);
		robot.showAllWindows();
		assertWindowAndEscape();
	}
	
	@Ignore //dtd is not available anymore and this functionality is already tested in the open URL set of testcases
	@Test
	public void test_ttp7529(){
		RadioOption fileLoad=new RadioOption("Use cache/proxy","File load");
		RadioOption openAs =new RadioOption("DTD","Open as:");
		TextFieldOption fileURL =new TextFieldOption("File URL:","http://gcmd.nasa.gov/Aboutus/xml/dif/dif_v9.dtd",null);
		robot.openURL(null, null, null,fileURL,fileLoad, openAs);
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void test_ttp3998_with_DigestAuthentication(){
		TextFieldOption usr =new TextFieldOption("User","test","Identification");
		TextFieldOption pwd =new TextFieldOption("Password","test","Identification");
		RadioOption fileLoad=new RadioOption("Use cache/proxy","File load");
		RadioOption openAs =new RadioOption("XML","Open as:");
		TextFieldOption fileURL =new TextFieldOption("File URL:","http://qa-w2k3/digest/ExpReport.xml",null);
		fileURL.setX2(100);
		robot.openURL(usr, pwd, null,fileURL,fileLoad, openAs);
		delay(1000);
//		let's modify the file slightly
		robot.keyType(KeyEvent.VK_SPACE);delay(200);
		robot.keyType(KeyEvent.VK_BACK_SPACE);delay(100);
		
		robot.saveFile();
		delay(2000);
		ComponentInfo ci = NativeGUI.getForegroundWindowInfo();
		if(ci.getWindowText().contains("Altova XMLSpy")) {
			assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
		}else{
			throw new AssertionError("Foreground window differs to the expected one");			
		}
	}
	
	@Test
	public void test_ttp3998_withoutAuthentication(){
		RadioOption fileLoad=new RadioOption("Use cache/proxy","File load");
		RadioOption openAs =new RadioOption("Auto","Open as:");
		TextFieldOption fileURL =new TextFieldOption("File URL:","http://qa-w2k3/webdav/examples/ExpReport.xslt",null);
		fileURL.setX2(100);
		robot.openURL(null,null, null,fileURL,fileLoad, openAs);
		delay(1000);
		//let's modify the file slightly
		robot.keyType(KeyEvent.VK_SPACE);delay(200);
		robot.keyType(KeyEvent.VK_BACK_SPACE);delay(100);
		
		robot.saveFile();
		delay(2000);
		ComponentInfo ci = NativeGUI.getForegroundWindowInfo();
		if(ci.getWindowText().contains("Altova XMLSpy")) {
			assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
		}else{
			throw new AssertionError("Foreground window differs to the expected one");			
		}
	}
	
	@Test
	public void test_ttp4708(){
		RadioOption fileLoad=new RadioOption("Use cache/proxy","File load");
		RadioOption openAs =new RadioOption("Auto","Open as:");
		TextFieldOption usr =new TextFieldOption("User","test","Identification");
		TextFieldOption pwd =new TextFieldOption("Password","test","Identification");
		TextFieldOption fileURL =new TextFieldOption("File URL:","http://qa-w2k3/test_auth/blopez/includes.xsd",null);
		fileURL.setX2(100);
		robot.openURL(usr,pwd, null,fileURL,fileLoad, openAs);delay(500);
		ComponentInfo ci = NativeGUI.getForegroundWindowInfo();
		assertEquals("Altova XMLSpy - [http://qa-w2k3/test_auth/blopez/includes.xsd]",ci.getWindowText());
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	public void test_ttp43695_1(){
		robot.openFile_notInPlugins(TTP_43695_1_XML_FILE.toString());
		delay(500);
	
		assertAreas(TOP_WINDOW);
		delay(500);
		
		robot.leftClickMid(robot.findComponent("OK", "Button", robot.findComponentName("ttp43695_1.xml")));
		delay(500);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void test_ttp43695_2(){
		robot.openFile_notInPlugins(TTP_43695_2_XML_FILE.toString());
		delay(1000);
		
		/*
		 * Encoding GBK (GB2312) is supported from v2015
		 * Test case left just for regression
		 * 
		assertAreas("test_ttp43695_2_Support", TOP_WINDOW);

		robot.leftClickMid(robot.findComponent("OK", "Button", robot.findComponentName("ttp43695_2.xml")));
		delay(1000);
		
		assertAreas(TOP_WINDOW);
		
		robot.leftClickMid(robot.findComponent("OK", "Button", robot.findComponentName("ttp43695_2.xml")));
		delay(1000);
		*/
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
}
