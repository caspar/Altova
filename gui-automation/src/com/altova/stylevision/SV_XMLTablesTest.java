package com.altova.stylevision;

import static com.altova.robots.SnapshotArea.CommonArea.*;
import static com.altova.util.LoggerUtils.logger;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import com.altova.stylevision.StyleVisionRobot.View;
import com.altova.util.IOUtils;
import com.altova.util.XMLFileReader;

public class SV_XMLTablesTest extends AbstractStyleVisionTest {

	private static final String My_TestDir="data/stylevision/tdata/XMLTables/";

	private static final XMLFileReader myxml = new XMLFileReader("data\\stylevision\\sv_xmltabletest_catalog.xml");
	private static final String xInputfile[]=myxml.getAllValueOfNode("test:test-case","test:input-file");
	private static final String xbasefile[]=myxml.getAllValueOfNode("test:test-case","test:basefile");
	private static final String xdescription[]=myxml.getAllValueOfNode("test:test-case","test:description");
	private static final String xfurtherfiles[]=myxml.getAllValueOfNode("test:test-case","test:furtherfiles");

	private static final File My_TCase_BaseFile = IOUtils.findFile(My_TestDir+"CALS/cals-table-maindesign.sps");
	private static final String MY_BASE_SPS_FILE=My_TCase_BaseFile.getAbsolutePath();
	@BeforeClass
	//hide all panes
	public static void doBeforeClass(){
		//robot.leftClickMenuItem("View","Project");
		//robot.leftClickMenuItem("View","Design Overview");
		//robot.leftClickMenuItem("View","Schema Tree");
		//robot.leftClickMenuItem("View","Design Tree");
		
		//robot.leftClickMenuItem("View","Context Styles");
		//robot.leftClickMenuItem("View","Context Properties");
		//robot.leftClickMenuItem("View","Style Repository");
		
	
		}
	
	@AfterClass
	//show all panes again
	public static void doAfterClass(){
		//robot.leftClickMenuItem("View","Project");
		//robot.leftClickMenuItem("View","Design Overview");
		//robot.leftClickMenuItem("View","Schema Tree");
		//robot.leftClickMenuItem("View","Design Tree");
		//robot.leftClickMenuItem("View","Context Styles");
		//robot.leftClickMenuItem("View","Context Properties");
		//robot.leftClickMenuItem("View","Style Repository");
		
		//close file again
		robot.closeAll();
	}
	@Before
	public void loadbasefile(){
		//load basefile
		//robot.loadDesign(MY_BASE_SPS_FILE);
		
	}
	
	@After
	public void CleanUp() {
	  	robot.escapeDialog("Generating a Word 2007 document", KeyEvent.VK_N); //XSLT 1 examples can't be viewed in Word2007
	  	robot.escapeDialog("The schema source", KeyEvent.VK_N); //no preview without working XML
	}
	
	@Test
	public void testTC_cals_1() {
	int i=0;
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	robot.loadDesign(MY_BASE_SPS_FILE);delay(2000);
	robot.leftClick(400, 300);    //just to activate the design
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.escapeDialog("Warning:",KeyEvent.VK_ENTER);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_2() {
	int i=1;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_3() {
	int i=2;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_4() {
	int i=3;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_5() {
	int i=4;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_6() {
	int i=5;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_7() {
	int i=6;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_8() {
	int i=7;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_9() {
	int i=8;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_10() {
	int i=9;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_11() {
	int i=10;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_12() {
	int i=11;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_13() {
	int i=12;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_14() {
	int i=13;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_15() {
	int i=14;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_16() {
	int i=15;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_17() {
	int i=16;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_18() {
	int i=17;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_19() {
	int i=18;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_20() {
	int i=19;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_21() {
	int i=20;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_22() {
	int i=21;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_23() {
	int i=22;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_24() {
	int i=23;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_cals_25() {
	int i=24;
	robot.loadDesign(MY_BASE_SPS_FILE);
	File MY_TestCase_File1=IOUtils.findFile(xbasefile[i]+xInputfile[i]);
	String testfile=MY_TestCase_File1.getAbsolutePath();
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }

	//HTML Tables TestCases
	@Test
	public void testTC_html_1() {
	int i=25;
	File MY_TestDir=IOUtils.findFile(xbasefile[i]);
	String mypath=MY_TestDir.getAbsolutePath()+"\\";
	String testfile=mypath+xInputfile[i];
	robot.loadDesign(mypath+xfurtherfiles[i]);
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_html_2() {
	int i=26;
	File MY_TestDir=IOUtils.findFile(xbasefile[i]);
	String mypath=MY_TestDir.getAbsolutePath()+"\\";
	String testfile=mypath+xInputfile[i];
	robot.loadDesign(mypath+xfurtherfiles[i]);
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_html_3() {
	int i=27;
	File MY_TestDir=IOUtils.findFile(xbasefile[i]);
	String mypath=MY_TestDir.getAbsolutePath()+"\\";
	String testfile=mypath+xInputfile[i];
	robot.loadDesign(mypath+xfurtherfiles[i]);
   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_html_4() {
	int i=28;
	File MY_TestDir=IOUtils.findFile(xbasefile[i]);
	String mypath=MY_TestDir.getAbsolutePath()+"\\";
	String testfile=mypath+xInputfile[i];
	robot.loadDesign(mypath+xfurtherfiles[i]);
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_html_5() {
	int i=29;
	File MY_TestDir=IOUtils.findFile(xbasefile[i]);
	String mypath=MY_TestDir.getAbsolutePath()+"\\";
	String testfile=mypath+xInputfile[i];
	robot.loadDesign(mypath+xfurtherfiles[i]);
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_html_6() {
	int i=30;
	File MY_TestDir=IOUtils.findFile(xbasefile[i]);
	String mypath=MY_TestDir.getAbsolutePath()+"\\";
	String testfile=mypath+xInputfile[i];
	robot.loadDesign(mypath+xfurtherfiles[i]);
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_html_7() {
	int i=31;
	File MY_TestDir=IOUtils.findFile(xbasefile[i]);
	String mypath=MY_TestDir.getAbsolutePath()+"\\";
	String testfile=mypath+xInputfile[i];
	robot.loadDesign(mypath+xfurtherfiles[i]);
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_html_8() {
	int i=32;
	File MY_TestDir=IOUtils.findFile(xbasefile[i]);
	String mypath=MY_TestDir.getAbsolutePath()+"\\";
	String testfile=mypath+xInputfile[i];
	robot.loadDesign(mypath+xfurtherfiles[i]);
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_mix_1() {
	int i=33;
	File MY_TestDir=IOUtils.findFile(xbasefile[i]);
	String mypath=MY_TestDir.getAbsolutePath()+"\\";
	String testfile=mypath+xInputfile[i];
	robot.loadDesign(mypath+xfurtherfiles[i]);
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }
	@Test
	public void testTC_mix_2() {
	int i=34;
	File MY_TestDir=IOUtils.findFile(xbasefile[i]);
	String mypath=MY_TestDir.getAbsolutePath()+"\\";
	String testfile=mypath+xInputfile[i];
	robot.loadDesign(mypath+xfurtherfiles[i]);
	   logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
	   robot.assigningWorkingXML(testfile);
	   robot.setView(View.AUTHENTIC);delay(4000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	  }

}