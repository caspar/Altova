package com.altova.schemaagent;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.schemaagent.SchemaAgentRobot.*;
import static com.altova.schemaagent.SchemaAgentRobot.View.*;
import static com.altova.spy.SpyRobot.FACETS_SAMPLES;
import static com.altova.util.LoggerUtils.logger;


import java.awt.event.KeyEvent;
import java.awt.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.robots.ScriptMistakeException;
import com.altova.schemaagent.SchemaAgentRobot.TAB;
import com.altova.spy.SpyRobot;
import com.altova.util.XMLFileReader;


public class ExplorerHierarchicalTabTest extends AbstractSchemaAgentTest {
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		if(robot == null) {
			robot = new SchemaAgentRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
		/*
		 * I delete the test folder A-NewFolder
		 * It will be used for testing part of Hierarchical pane context menu 
		 * From the moment that I need to create this folder again, I will not test testCreateNewFolder(),
		 * that means is indirectly tested.
		 */
		try {
			//delete the A-NewFolder
			robot.navigateTo("Documents/A-NewFolder",Color.WHITE,Color.BLACK);
			robot.contextmenu_select("Delete");
			robot.keyType(KeyEvent.VK_Y);			//Press yes to delete

			//create a new A-NewFolder
			robot.navigateTo("Documents",Color.WHITE,Color.BLACK);
			robot.contextmenu_select("New/Folder");
			robot.typeStringEnter("A-NewFolder");

			
		} catch (Exception e) {
			logger.fine("Exception during creation-delete A-NewFolder. Maybe the A-New folder was not existing. OK, I will create it:"+ e.toString());
		}
		
		
		
		robot.navigateTo("Documents",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/Folder");
		robot.typeStringEnter("A-NewFolder");
		
	}
		
		
		
	
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
	
	@Test
	public void testCheckTabs() {
		
		robot.switchView(EXPLORER, TAB.Hierarchical);
		assertAreas(getTestName()+"_HierarchicalTab", EXPLORER);
		
		robot.switchView(EXPLORER, TAB.Flat);
		assertAreas(getTestName()+"_FlatTab", EXPLORER);
		
		robot.switchView(EXPLORER, TAB.Configure_Paths);
		assertAreas(getTestName()+"_ConfigurePathTab", EXPLORER);
		
	}
	
	@Test
	public void testOpenCloseTree() {
		
		robot.navigateTo("Documents/EDI_Order",Color.WHITE,Color.BLACK);
		assertAreas(getTestName()+"_AfterPlus", EXPLORER);
		robot.navigateTo("Documents/EDI_Order",Color.WHITE,Color.BLACK);
		robot.typeString("-");
		assertAreas(getTestName()+"_AfterMinus", EXPLORER);
	}

	
	/*
	 * Test is not longer necessary: folder is already created in
	 * BeforeClass and for this reason is implicitly tested
	 * 
	@Test
	public void testCreateNewFolder() {

		robot.navigateTo("Documents",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/Folder");
		robot.typeStringEnter("A-NewFolder");
		assertAreas(EXPLORER);
	}
	*/
	
	@Test
	public void testCreateNewSchema() {
		robot.navigateTo("Documents/A-NewFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/Schema");
		robot.typeStringEnter("NewSchema");
		assertAreas(EXPLORER);
	}
	
	@Test
	public void testCreateNewXML() {
		robot.navigateTo("Documents/A-NewFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/XML ");
		robot.typeStringEnter("NewXML");
		assertAreas(EXPLORER);
	}
	
	@Test
	public void testCreateNewXSL() {
		robot.navigateTo("Documents/A-NewFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/XSL ");
		robot.typeStringEnter("NewXSL");
		assertAreas(EXPLORER);
	}
	
	@Test
	public void testCreateNewWSDL() {
		robot.navigateTo("Documents/A-NewFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/WSDL ");
		robot.typeStringEnter("NewWSDL");
		assertAreas(EXPLORER);
	}
	
	@Test
	public void testCreateNewMFD() {
		robot.navigateTo("Documents/A-NewFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/MapForce ");
		robot.typeStringEnter("NewMapForce");
		assertAreas(EXPLORER);
	}
	
	@Test
	public void testRenameFolder() {
		robot.navigateTo("Documents/A-NewFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/Folder ");
		robot.typeStringEnter("secondary");
		robot.navigateTo("Documents/A-NewFolder/secondary",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("Rename");
		robot.typeStringEnter("renamedFolder");
		assertAreas(EXPLORER);
	}
	
	@Test
	public void testRenameFile() {
		robot.navigateTo("Documents/A-NewFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/Schema ");
		robot.typeStringEnter("aSecondary");
		robot.navigateTo("Documents/A-NewFolder/aSecondary",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("Rename");
		robot.typeStringEnter("renamedSchema");
		assertAreas(EXPLORER);
	}
	
	@Test
	public void testReload() {
		robot.navigateTo("Documents/A-NewFolder/renamedFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("Reload");
		assertAreas(EXPLORER);
	}
	
	@Test
	public void testDeleteFile() {
		robot.navigateTo("Documents/A-NewFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/XML ");
		robot.typeStringEnter("filetodelete");
		robot.navigateTo("Documents/A-NewFolder/filetodelete",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("Delete");
		robot.keyType(KeyEvent.VK_Y);			//Press yes to delete
		assertAreas(EXPLORER);
	}

	@Test
	public void testDeleteFolder() {
		robot.navigateTo("Documents/A-NewFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/Folder");
		robot.typeStringEnter("foldertodelete");
		robot.navigateTo("Documents/A-NewFolder/foldertodelete",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("Delete");
		robot.keyType(KeyEvent.VK_Y);			//Press yes to delete
		assertAreas(EXPLORER);
	}
	
	@Test
	public void testSynchronizeSelection() {
		robot.navigateTo("Documents/A-NewFolder/NewXML.xml",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("Insert into current design");
		robot.navigateTo("Documents/A-NewFolder/NewXSL.xslt",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("Insert into current design");
		robot.navigateTo("Documents/A-NewFolder/NewWSDL.wsdl",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("Insert into current design");
		
		robot.navigateTo("Documents/A-NewFolder/NewXSL.xslt",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("Synchronize Selection");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertIntoCurrentDesign() {
		robot.navigateTo("Documents/A-NewFolder/NewXML.xml",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("Insert into current design");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}	

	@Test
	public void testInsertClipboard() {
		
		robot.newDesign();
		robot.navigateTo("Documents/A-NewFolder/NewMapForce.mfd",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("Insert into clipboard");
		robot.leftClickMenuItem("Window", "SchemaAgent");
		robot.paste();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
			
		
	@Test
	public void testrecreate() {
		fail("Not yet implemented. TODO"); // TODO
	}
	
	@Test
	public void tesCorrectReferencePath() {
		fail("Not yet implemented. TODO"); // TODO
	}
	
	
}