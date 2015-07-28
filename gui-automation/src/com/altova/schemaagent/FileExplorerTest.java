package com.altova.schemaagent;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.schemaagent.SchemaAgentRobot.*;
import static com.altova.schemaagent.SchemaAgentRobot.View.*;
import static com.altova.util.LoggerUtils.logger;


import java.awt.event.KeyEvent;
import java.awt.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.altova.robots.ScriptMistakeException;
import com.altova.util.XMLFileReader;


public class FileExplorerTest extends AbstractSchemaAgentTest {

	private static final XMLFileReader myxml = new XMLFileReader("data\\schemaagent\\FileExplorerTest_catalog.xml");
	private static final String xInputfile[]=myxml.getAllValueOfNode("test:test-case","test:input-file");
	private static final String xdescription[]=myxml.getAllValueOfNode("test:test-case","test:description");
	private static final String xTestdir[]=myxml.getAllValueOfNode("test:test-case","test:basefile");
	
	
	@Before
	public void setUp() {
		robot.newDesign();
	}
	
	@After
	public void CleanUp() {
		try {
			robot.closeWithoutSave();
		} catch(ScriptMistakeException e) {
			logger.fine("Could not Design window - probably already closed: "+e);
		}
	}
	/*
	@Test
	public void dragFoldertoDesign(){
		int i=0;
		String testfile=xbasefile[i]+xInputfile[i];
		logger.fine("TCASE: "+xdescription[i]);
		robot.dragtoDesign("Documents/ExpReport",robot.getPoint(320,275));
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void dragFiletoDesign(){
		robot.dragtoDesign("Documents/ExpReport/ExpReport",robot.getPoint(320,275));
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void test1(){
		robot.setView(FLAT_VIEW);
	}
	*/
	
	@Test
	public void createnewFolder_0() {
		int i=0;
		logger.fine("TCASE: "+xdescription[i]);
		robot.navigateTo("Documents",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/Folder");
		robot.typeStringEnter("aTestFolder");
		assertAreas(EXPLORER);
	}
	
	@Test
	public void createnewSchema_1() {
		int i=1;
		logger.fine("TCASE: "+xdescription[i]);
		robot.navigateTo("Documents/aTestFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/Schema");
		robot.typeStringEnter("myschema1");
		assertAreas(EXPLORER);
	}
	
	@Test
	public void createnewXML_2() {
		int i=2;
		logger.fine("TCASE: "+xdescription[i]);
		robot.navigateTo("Documents/aTestFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/XML ");
		robot.typeStringEnter("myxmlfile1");
		assertAreas(EXPLORER);
	}
	
	@Test
	public void createnewXSL_3() {
		int i=3;
		logger.fine("TCASE: "+xdescription[i]);
		robot.navigateTo("Documents/aTestFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/XSL ");
		robot.typeStringEnter("myxslfile1");
		assertAreas(EXPLORER);
	}
	
	@Test
	public void createnewWSDL_4() {
		int i=4;
		logger.fine("TCASE: "+xdescription[i]);
		robot.navigateTo("Documents/aTestFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/WSDL ");
		robot.typeStringEnter("mywsdlfile1");
		assertAreas(EXPLORER);
	}
	
	@Test
	public void createnewMFD_5() {
		int i=5;
		logger.fine("TCASE: "+xdescription[i]);
		robot.navigateTo("Documents/aTestFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/MapForce ");
		robot.typeStringEnter("mymapforcefile1");
		assertAreas(EXPLORER);
	}
	
	@Test
	public void ren_dir_6() {
		int i=6;
		logger.fine("TCASE: "+xdescription[i]);
		robot.navigateTo("Documents/aTestFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/Folder ");
		robot.typeStringEnter("anotherTestFolder");
		robot.navigateTo("Documents/aTestFolder/anotherTestFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("Rename");
		robot.typeStringEnter("renamedFolder");
		assertAreas(EXPLORER);
	}
	
	@Test
	public void ren_file_7() {
		int i=7;
		logger.fine("TCASE: "+xdescription[i]);
		robot.navigateTo("Documents/aTestFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/Schema ");
		robot.typeStringEnter("anotherSchema");
		robot.navigateTo("Documents/aTestFolder/anotherSchema",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("Rename");
		robot.typeStringEnter("renamedSchema");
		assertAreas(EXPLORER);
	}
	
	@Test
	public void reload_8() {
		int i=8;
		logger.fine("TCASE: "+xdescription[i]);
		robot.navigateTo("Documents/aTestFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("Reload");
		assertAreas(EXPLORER);
	}
	
	@Test
	public void deletefile_9() {
		int i=9;
		logger.fine("TCASE: "+xdescription[i]);
		robot.navigateTo("Documents/aTestFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/Schema ");
		robot.typeStringEnter("myschema2");
		robot.navigateTo("Documents/aTestFolder/myschema2",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("Delete");
		robot.keyType(KeyEvent.VK_Y);			//Press yes to delete
		assertAreas(EXPLORER);
	}
	
}