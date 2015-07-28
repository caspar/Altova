package com.altova.stylevision;

import static com.altova.stylevision.StyleVisionRobot.*;
import static com.altova.util.LoggerUtils.logger;


import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.AfterClass;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.ScriptMistakeException;
import com.altova.util.IOUtils;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;

public class SV_ProjectOptionsTest extends AbstractStyleVisionTest {

//	protected static final String EXAMPLES_PRJ = new File(AltovaApplication.STYLEVISION.getExamplesLocation(), "Examples.spp").getAbsolutePath();
	protected static final String MY_PRJ = "C:\\temp\\my_sv_prj.svp";
	protected static final String My_TestDir="data/stylevision/tdata/orgchart/";
	protected static final File MY_TestCase_File1=IOUtils.findFile(My_TestDir+"NanonullOrg.xsd");
	protected static final File MY_TestCase_File2=IOUtils.findFile(My_TestDir+"NanonullOrg.xml");
	
	protected static final String MY_NANONULL_XML_FILE=MY_TestCase_File2.getAbsolutePath();
	protected static final String MY_NANONULL_XML_FILENAME ="NanonullOrg.xml";
	protected static final String MY_NANONULL_XSD_FILE=MY_TestCase_File1.getAbsolutePath();
	protected static final String MY_NANONULL_XSD_FILENAME ="NanonullOrg.xsd";
	protected static final File MY_PRJ_FILE = new File(MY_PRJ);
	protected static final String MY_EXT_PROJ_FOLDER="C:\\temp";
	
	@BeforeClass
	public static void setUpProject() {
		robot.newProject();
		robot.addFilesToProject(MY_NANONULL_XSD_FILE);
		robot.addFilesToProject(MY_NANONULL_XML_FILE);
//		robot.openProject(EXAMPLES_PRJ_FILE.getAbsolutePath());
	}
	
	@AfterClass
	public static void CleanUpProject() {
		try {
			//robot.escapeDialog("Do you want to create a new StyleVision Design based on", KeyEvent.VK_ESCAPE);
			robot.closeProjectOnly();
		} catch(ScriptMistakeException e) {
			logger.fine("Could not close project - probably already closed: "+e);
		}
	}

	@After
	public void CleanUpWindow() {
		try {
			robot.escapeDialog("Do you want to create a new StyleVision Design based on", KeyEvent.VK_ESCAPE);
			//robot.closeProjectOnly();
		} catch(ScriptMistakeException e) {
			logger.fine("Could not close project - probably already closed: "+e);
		}
	}

	@Test
	public final void testProjectOptionsSchemaAlawysask() {
		CheckboxOption option = new CheckboxOption("Always ask", true,
				"Default Action for XML Schema", null, null, "Project",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		//robot.addFilesToProject(MY_NANONULL_XSD_FILE);
		robot.SelectFilefromProject("XML Schema",MY_NANONULL_XSD_FILENAME);
		robot.keyType(KeyEvent.VK_ENTER);
		assertAreas(TOP_WINDOW);
		//assertForegroundWindow("StyleVision");
		//robot.escapeDialog("Do you want to create a new StyleVision Design based on", KeyEvent.VK_ESCAPE);
	}
	
	@Test
	public final void testProjectOptionsSchemaCreateNewDesign() {
		CheckboxOption option = new CheckboxOption("Create new Design", true,
				"Default Action for XML Schema", null, null, "Project",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		//robot.addFilesToProject(MY_NANONULL_XSD_FILE);
		robot.SelectFilefromProject("XML Schema",MY_NANONULL_XSD_FILENAME);
		robot.keyType(KeyEvent.VK_ENTER);
		assertForegroundWindow("StyleVision");
		robot.escapeDialog("Do you want to assign a Working XML File", KeyEvent.VK_S);//do no assign working XML here
		robot.delay(500);robot.keyType(KeyEvent.VK_ENTER);// escape inital layout selection window with Enter for empty layout
		robot.delay(4000);
		assertAreas(DESIGNOVERVIEW);
	}

	@Test
	@Ignore
	public final void testProjectOptionsSchemaEditinXMLSpy() {
		CheckboxOption option = new CheckboxOption("Edit selected file in XMLSpy", true,
				"Default Action for XML Schema", null, null, "Project",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		//robot.addFilesToProject(MY_NANONULL_XSD_FILE);
		robot.SelectFilefromProject("XML Schema",MY_NANONULL_XSD_FILENAME);
		robot.keyType(KeyEvent.VK_ENTER);delay(30000);
		if (isWindowOnTop("Altova XMLSpy - [NanonullOrg.xsd]")){
			logger.finest("XMLSpy is TOP WINDOW ");
			//robot.keyTypeAlt(0x73);delay(3000);
			robot.activateApplication();delay(3000);
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
	}
		
	@Test
	public final void testProjectOptionsXMLFileAlawysask() {
		CheckboxOption option = new CheckboxOption("Always ask", true,
				"Default Action for XML file", null, null, "Project",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		//robot.addFilesToProject(MY_NANONULL_XML_FILE);
		robot.SelectFilefromProject("XML Schema",MY_NANONULL_XML_FILENAME);
		robot.keyType(KeyEvent.VK_ENTER);
		assertAreas(TOP_WINDOW);
	}
	
	@Test
	public final void testProjectOptionsXMLFileCreateNewDesign() {
		CheckboxOption option = new CheckboxOption("Create new Design", true,
				"Default Action for XML files", null, null, "Project",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		//robot.addFilesToProject(MY_NANONULL_XML_FILE);
		robot.SelectFilefromProject("XML Schema",MY_NANONULL_XML_FILENAME);
		robot.keyType(KeyEvent.VK_ENTER);
		robot.delay(500);robot.keyType(KeyEvent.VK_ENTER);// escape inital layout selection window with Enter for empty layout
		robot.delay(4000);
		assertAreas(DESIGNOVERVIEW);
	}
	
	@Test
	@Ignore
	public final void testProjectOptionsXMLFileEditinXMLSpy() {
		CheckboxOption option = new CheckboxOption("Edit selected file in XMLSpy", true,
				"Default Action for XML files", null, null, "Project",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		//robot.addFilesToProject(MY_NANONULL_XML_FILE);
		robot.SelectFilefromProject("XML File",MY_NANONULL_XML_FILENAME);
		robot.keyType(KeyEvent.VK_ENTER);delay(30000);
		if (isWindowOnTop("Altova XMLSpy - [NanonullOrg.xml]")){
			logger.finest("XMLSpy loaded Nanonull.xml and is TOP WINDOW ");
			//robot.keyTypeAlt(0x73);delay(3000);
			robot.activateApplication();delay(3000);
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
		//assertForegroundWindow("Altova XMLSpy");
		//robot.keyTypeAlt(0x73);delay(3000);
		//robot.activateApplication();
		//assertAreas(TOP_WINDOW);
	}
}
