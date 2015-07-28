package com.altova.stylevision;

import static com.altova.stylevision.StyleVisionRobot.*;
import static com.altova.stylevision.Tag.PEACH;
import static com.altova.stylevision.TagType.START;
import static com.altova.util.LoggerUtils.logger;


import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.altova.robots.ScriptMistakeException;
import com.altova.util.IOUtils;
import com.altova.util.Settings.AltovaApplication;
import static com.altova.stylevision.Position.AFTER;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

public class SV_ProjectContextMenuTest extends AbstractStyleVisionTest {

	protected static final String My_TestDir="data/stylevision/tdata/orgchart/";
	protected static final String My_TestDirExpRep="data/stylevision/tdata/expreport/";
	

	@Before
	public void setUp() {
		robot.newProject();
	}

	@After
	public void CleanUp() {
		try {
			robot.closeProjectOnly();
			robot.closebyStrgF4();
		} catch(ScriptMistakeException e) {
			logger.fine("Could not close project - probably already closed: "+e);
		}
	}

	@Test
	//@Ignore
	public final void testInsertImagefromProjectContextMenu() {
		
		File MY_TestCase_File1=IOUtils.findFile(My_TestDir+"orgchart.sps");
		String SPS_FILE=MY_TestCase_File1.getAbsolutePath();
		File MY_TestCase_File2=IOUtils.findFile(My_TestDir+"altova.gif");
		String MY_IMAGE_FILE=MY_TestCase_File2.getAbsolutePath();			
		robot.addFilesToProject(MY_IMAGE_FILE);
		robot.openFile(SPS_FILE);
		Tag myTag = new Tag("n1:CompanyLogo", PEACH, START);
		robot.insertImagefromProjectContextMenu("altova.gif",myTag , AFTER);
		delay(500);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testContextCSSFilefromProjectAction(){
		File MY_TestCase_File1=IOUtils.findFile(My_TestDir+"orgchart.sps");
		String SPS_FILE=MY_TestCase_File1.getAbsolutePath();
		File MY_TestCase_File2=IOUtils.findFile(My_TestDir+"QuickStart.css");
		String MY_CSS_FILE=MY_TestCase_File2.getAbsolutePath();			
		robot.addFilesToProject(MY_CSS_FILE);
		robot.openFile(SPS_FILE);
		robot.ContextCSSFilefromProjectAction("QuickStart.css", 1);
		robot.activatePane(STYLEREPOSITORY);
		robot.expand_Folder("External");delay(500);
		assertAreas(STYLEREPOSITORY);
	}
	
	@Test
	//@Ignore
	public final void testContextSPSFilefromProjectAction_OpenDesign(){
		File MY_TestCase_File1=IOUtils.findFile(My_TestDir+"orgchart.sps");
		String SPS_FILE=MY_TestCase_File1.getAbsolutePath();
		File MY_TestCase_File2=IOUtils.findFile(My_TestDir+"NanonullOrg.sps");
		String SPS_FILE2=MY_TestCase_File2.getAbsolutePath();
		robot.addFilesToProject(SPS_FILE2);
		robot.openFile(SPS_FILE);
		robot.ContextSPSFilefromProjectAction("NanonullOrg.sps", 1);delay(500);	
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	//@Ignore
	public final void testContextSPSFilefromProjectAction_ImportAsModule(){
		File MY_TestCase_File1=IOUtils.findFile(My_TestDir+"orgchart.sps");
		String SPS_FILE=MY_TestCase_File1.getAbsolutePath();
		File MY_TestCase_File2=IOUtils.findFile(My_TestDir+"NanonullOrg.sps");
		String SPS_FILE2=MY_TestCase_File2.getAbsolutePath();
		robot.addFilesToProject(SPS_FILE2);
		robot.openFile(SPS_FILE);
		robot.ContextSPSFilefromProjectAction("NanonullOrg.sps", 2);
		//robot.scrollPane(DESIGNOVERVIEW, 0.8);	//scroll down in Design Overview
		assertAreas(DESIGNOVERVIEW);
	}
	
	@Test
	//@Ignore
	public final void testContextXMLFilefromProjectAction_CreateNewDesign(){
		File MY_TestCase_File1=IOUtils.findFile(My_TestDirExpRep+"ExpReport.xml");
		String XML_FILE=MY_TestCase_File1.getAbsolutePath();
		robot.addFilesToProject(XML_FILE);
		robot.ContextXMLFilefromProjectAction("ExpReport.xml", 1);delay(500);	
		robot.leftClickButton("OK");delay(1000);//press Ok for new empty design
		assertAreas(DESIGNOVERVIEW);
	}
	
	@Test
	//@Ignore
	public final void testContextXMLFilefromProjectAction_AddAsNewSource(){
		File MY_TestCase_File1=IOUtils.findFile(My_TestDir+"orgchart.sps");
		String SPS_FILE=MY_TestCase_File1.getAbsolutePath();
		File MY_TestCase_File2=IOUtils.findFile(My_TestDirExpRep+"ExpReport.xml");
		String XML_FILE=MY_TestCase_File2.getAbsolutePath();

		robot.openFile(SPS_FILE);
		robot.addFilesToProject(XML_FILE);
		robot.ContextXMLFilefromProjectAction("ExpReport.xml", 2);	delay(500);	
		assertAreas(DESIGNOVERVIEW);
	}
	
	@Test
	//@Ignore
	public final void testContextXMLFilefromProjectAction_AddAsWorkingXML(){
		File MY_TestCase_File1=IOUtils.findFile(My_TestDir+"orgchart.sps");
		String SPS_FILE=MY_TestCase_File1.getAbsolutePath();
		File MY_TestCase_File2=IOUtils.findFile(My_TestDir+"NanonullOrg.xml");
		String XML_FILE=MY_TestCase_File2.getAbsolutePath();
		robot.openFile(SPS_FILE);
		robot.addFilesToProject(XML_FILE);
		robot.ContextXMLFilefromProjectAction("NanonullOrg.xml", 3);	delay(500);	
		assertAreas(DESIGNOVERVIEW);
	}
	
	@Test
	//@Ignore
	public final void testContextXMLFilefromProjectAction_AddAsTemplateXML(){
		File MY_TestCase_File1=IOUtils.findFile(My_TestDir+"orgchart.sps");
		String SPS_FILE=MY_TestCase_File1.getAbsolutePath();
		File MY_TestCase_File2=IOUtils.findFile(My_TestDir+"NanonullOrg.xml");
		String XML_FILE=MY_TestCase_File2.getAbsolutePath();
		robot.openFile(SPS_FILE);
		robot.addFilesToProject(XML_FILE);
		robot.ContextXMLFilefromProjectAction("NanonullOrg.xml", 4);	delay(500);	
		assertAreas(DESIGNOVERVIEW);
	}

	@Test
	//@Ignore
	public final void testContextSCHEMAFilefromProjectAction_CreateNewDesign(){
		File MY_TestCase_File1=IOUtils.findFile(My_TestDir+"NanonullOrg.xsd");
		String XSD_FILE=MY_TestCase_File1.getAbsolutePath();
		robot.addFilesToProject(XSD_FILE);
		robot.ContextSCHEMAFilefromProjectAction("NanonullOrg.xsd", 1);	
		robot.keyType(KeyEvent.VK_S);delay(500);	 //do no assign working XML here
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		assertAreas(DESIGNOVERVIEW);
	}
	
	@Test
	//@Ignore
	public final void testContextSCHEMAFilefromProjectAction_AddAsNewSource(){
		File MY_TestCase_File1=IOUtils.findFile(My_TestDir+"orgchart.sps");
		String SPS_FILE=MY_TestCase_File1.getAbsolutePath();
		File MY_TestCase_File2=IOUtils.findFile(My_TestDir+"address.xsd");
		String XSD_FILE=MY_TestCase_File2.getAbsolutePath();
		robot.openFile(SPS_FILE);
		robot.addFilesToProject(XSD_FILE);
		robot.ContextSCHEMAFilefromProjectAction("address.xsd", 2);	
		robot.keyType(KeyEvent.VK_S);delay(500); //do no assign working XML here
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		assertAreas(DESIGNOVERVIEW);
	}
	
	@Test
	//@Ignore
	public final void testContextSCHEMAFilefromProjectAction_AssignAsNewSource(){
		File MY_TestCase_File1=IOUtils.findFile(My_TestDir+"orgchart.sps");
		String SPS_FILE=MY_TestCase_File1.getAbsolutePath();
		File MY_TestCase_File2=IOUtils.findFile(My_TestDir+"NanonullOrg.xsd");
		String XSD_FILE=MY_TestCase_File2.getAbsolutePath();
		robot.openFile(SPS_FILE);
		robot.addFilesToProject(XSD_FILE);
		robot.ContextSCHEMAFilefromProjectAction("NanonullOrg.xsd", 3);	
		robot.keyType(KeyEvent.VK_S); robot.delay(500);	//do no assign working XML here
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		assertAreas(DESIGNOVERVIEW);
	}
	
	@Test
	//@Ignore
	public final void testContextHTMLFilefromProjectAction(){
		File MY_TestCase_File1=IOUtils.findFile(My_TestDir+"article.html");
		String HTML_FILE=MY_TestCase_File1.getAbsolutePath();
		robot.addFilesToProject(HTML_FILE);
		robot.ContextHTMLFilefromProjectAction("article.html", 1);delay(2000);		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
}