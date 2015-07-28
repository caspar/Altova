package com.altova.stylevision;

import static com.altova.robots.SnapshotArea.CommonArea.*;
import static com.altova.stylevision.StyleVisionRobot.*;
import static com.altova.util.LoggerUtils.logger;


import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.After;
import org.junit.Test;

import com.altova.robots.ScriptMistakeException;
import com.altova.robots.TextFieldOption;
import com.altova.stylevision.StyleVisionRobot.View;
import com.altova.util.IOUtils;
import com.altova.util.XMLFileReader;
import com.altova.util.Settings.AltovaApplication;




public class BasicExamplesTest extends AbstractStyleVisionTest {
	private static final XMLFileReader myxml = new XMLFileReader("data\\stylevision\\guiautomation_catalog.xml");
	private static final String xInputfile[]=myxml.getAllValueOfNode("test:test-case","test:input-file");
	private static final String xTestdir[]=myxml.getAllValueOfNode("test:test-case","test:basefile");
	private static final String xdescription[]=myxml.getAllValueOfNode("test:test-case","test:description");
	private static final String xfurtherfiles[]=myxml.getAllValueOfNode("test:test-case","test:furtherfiles");
	private static final String xTestdir_Data="data/stylevision/tdata/";
	/**
	 * BasicExamplesTest
	 * Catalog: guiautomation_catalog.xml
	 * 
	 * load Stylevision Example files from Examples\Basic project folder and checks main functionality
	 * catalog file index i=21 to 45
	 * 
	 */
	
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
	public void  AutoCalc(){
		int i=22;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.AUTHENTIC);delay(2000);
		robot.find_strg_f("12");
		robot.typeString("1000");delay(1000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void  comboboxes(){
		int i=23;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.AUTHENTIC);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void  conditions(){
		int i=24;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.AUTHENTIC);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void  db(){
		int i=25;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.AUTHENTIC);delay(2000);
		robot.setView(View.DB_ICON_FW);delay(500);  //press DB forward ICON once
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void  formelements(){
		int i=26;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.AUTHENTIC);delay(2000);
		robot.find_strg_f("One");delay(500);
		robot.typeString("invalid value in red");delay(500);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void  imagesembedded(){
		int i=27;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.AUTHENTIC);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void  imageslinked(){
		int i=28;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.AUTHENTIC);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void  inputformatting_auth(){
		int i=29;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.AUTHENTIC);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void  inputformatting_html(){
		int i=30;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.HTML);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void setFOP(){
		int i=31;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		//String fopbat=AltovaApplication.STYLEVISION.getInstallLocation().getParent()+xfurtherfiles[i];
		//String fopbat=AltovaApplication.STYLEVISION.getProgramFiles_x86().toString()+xfurtherfiles[i];
		//String fopbat="C:\\Program Files (x86)\\"+xfurtherfiles[i];
		String fopbat="C:\\ProgramData\\Altova\\SharedBetweenVersions\\"+xfurtherfiles[i];
		
		logger.fine("TCASE: "+xdescription[i]);
		TextFieldOption option = new TextFieldOption("FO Processor", true,fopbat,null, null, null, "XSL Options",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.PDF);delay(20000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void  lists(){
		int i=32;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.AUTHENTIC);delay(2000);
		robot.find_strg_f("Four");
		robot.keyType(KeyEvent.VK_RIGHT);robot.keyType(KeyEvent.VK_ENTER);  //add new list item
		robot.typeString("Five");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	//@Ignore
	public void  modules_auth(){
		int i=33;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.AUTHENTIC);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void  modules_html(){
		int i=34;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.HTML);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void  multipleschemas_auth(){
		int i=35;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.AUTHENTIC);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void  multipleschemas_html(){
		int i=36;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.HTML);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	/*
	@Test
	//@Ignore
	public void  pagebreak_xslt(){
		int i=37;
		String testfile=xbasefile[i]+xInputfile[i];
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.HTML);delay(2000);
		robot.setView(View.HTMLBOLD);delay(500);
		robot.selectXSLTHTML();delay(500);
		robot.find_strg_f("page-break-after: always");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	*/
	@Test
	//@Ignore
	public void  pagelayout_pdf(){
		int i=38;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.PDF);delay(10000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void  paramteres_auth(){
		int i=39;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.AUTHENTIC);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void  parameters_html(){
		int i=40;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.HTML);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	//@Ignore
	public void  tables_auth(){
		int i=41;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.AUTHENTIC);delay(2000);
		robot.find_strg_f("232");
		robot.leftClickMenuItem("Authentic","Append Row");delay(1000);
		robot.keyType(KeyEvent.VK_RIGHT);robot.keyType(KeyEvent.VK_ENTER);   //select "add value" and add with Enter
		robot.typeStringEnter("100");delay(500);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void  grouping_html(){
		int i=42;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.HTML);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void  sorting_html(){
		int i=43;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.HTML);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void  toc_auth(){
		int i=44;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.AUTHENTIC);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public void  toc_html(){
		int i=45;
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String testfile=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);delay(1000);
		robot.setView(View.HTML);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	//@Ignore
	public void  schema11(){
		logger.fine("TCASE: Schema11");
		File MY_TestCase_Schema=IOUtils.findFile(xTestdir_Data+"basic/book-store/BookStore_v1.xsd");
		String testfile_xsd=MY_TestCase_Schema.getAbsolutePath();
		File MY_TestCase_XML=IOUtils.findFile(xTestdir_Data+"basic/book-store/BookStore_v1.xml");
		String testfile_xml=MY_TestCase_XML.getAbsolutePath();
		robot.newSPS("New from XML Schema");
		robot.typeStringEnter(testfile_xsd);delay(500);
		robot.keyType(KeyEvent.VK_ENTER);delay(500);   //Enter - assign a Working XML
		robot.typeStringEnter(testfile_xml);delay(500);
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.maximizeFileWindow();
		assertAreas(DESIGNOVERVIEW);
	}
	@Test
	//@Ignore
	public void  xslt3(){
		logger.fine("TCASE: XSLT3");
		File MY_TestCase_sps=IOUtils.findFile(xTestdir_Data+"basic/map-get.sps");
		String testfile_sps=MY_TestCase_sps.getAbsolutePath();
		robot.openFile(testfile_sps);delay(1000);
		robot.maximizeFileWindow();
		robot.setView(View.HTML);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
}