package com.altova.schemaagent;

import static com.altova.schemaagent.SchemaAgentRobot.EXPLORER;
import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.VK_Y;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import java.awt.Color;
import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.robots.ScriptMistakeException;
import com.altova.schemaagent.SchemaAgentRobot.TAB;

public class ExplorerFlatTabTest extends AbstractSchemaAgentTest{

	
	
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
			//robot.navigateTo("Documents/A-NewFolder",Color.WHITE,Color.BLACK);
			//robot.typeStringEnter("Documents/A-NewFolder");
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
		
		
		//create a new A-NewFolder
		robot.navigateTo("Documents",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/Folder");
		robot.typeStringEnter("A-NewFolder");
		
	}
	
	
	
	
	@Before 
	public void startUp(){
		
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
	public void testRenameFile() {
	
		robot.navigateTo("Documents/A-NewFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/XML ");
		robot.typeStringEnter("tmpRename");
		
		robot.navigateTo("tmpRename",Color.WHITE,Color.BLACK, TAB.Flat);
		delay(800);
		robot.contextmenu_select("Rename");
		delay(500);
		robot.typeStringEnter("tmpR.xml");
		robot.switchView(EXPLORER, TAB.Hierarchical);
		
		assertAreas(EXPLORER);
		
	}	
	
	@Test
	public void testDeleteFile() {
	
		robot.navigateTo("Documents/A-NewFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/Schema file ");
		robot.typeStringEnter("tmpDelete");
		
		robot.navigateTo("tmpDelete",Color.WHITE,Color.BLACK, TAB.Flat);
		delay(800);
		robot.contextmenu_select("Delete");
		robot.escapeDialog("Do you really want to delete the selected file(s)?", VK_Y);
		robot.switchView(EXPLORER, TAB.Hierarchical);
		
		assertAreas(EXPLORER);
		
	}
	
	@Test
	public void testReloadFile() {
	
		robot.navigateTo("Documents/A-NewFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/XSL ");
		robot.typeStringEnter("tmpReload");
		
		robot.navigateTo("tmpReload",Color.WHITE,Color.BLACK, TAB.Flat);
		delay(800);
		robot.contextmenu_select("Reload");
		robot.switchView(EXPLORER, TAB.Hierarchical);
		
		assertAreas(EXPLORER);
		
	}
	
	@Test
	public void testInsertIntoClipboard() {
	
		robot.newDesign();
		robot.navigateTo("Documents/A-NewFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/XML ");
		robot.typeStringEnter("Clipboard");
		
		robot.navigateTo("Clipboard",Color.WHITE,Color.BLACK, TAB.Flat);
		delay(800);
		robot.contextmenu_select("Insert into clipboard");
		robot.leftClickMenuItem("Window", "SchemaAgent");
		robot.paste();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testInsertIntoCurrentDesign() {
	
		robot.navigateTo("Documents/A-NewFolder",Color.WHITE,Color.BLACK);
		robot.contextmenu_select("New/XML ");
		robot.typeStringEnter("CurrentDesign");
		
		robot.navigateTo("CurrentDe",Color.WHITE,Color.BLACK, TAB.Flat);
		delay(800);
		robot.contextmenu_select("Insert into current design");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
}
