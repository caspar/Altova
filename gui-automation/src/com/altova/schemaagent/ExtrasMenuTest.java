package com.altova.schemaagent;

import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.util.LoggerUtils.logger;
import static com.altova.schemaagent.SchemaAgentRobot.EXPLORER;

import java.awt.event.KeyEvent;
import java.io.File;


//import java.awt.event.KeyEvent;

import org.junit.Test;

import com.altova.util.IOUtils;

public class ExtrasMenuTest extends AbstractSchemaAgentTest {

	protected static final File CORRECT_REFERENCE_PATH_XML = IOUtils.findFile("schemaagent/example/correctPath.xml");	
	protected static final File CORRECT_REFERENCE_PATH_XSD = IOUtils.findFile("schemaagent/example/correctPath.xsd");
	protected static final File CORRECT_REFERENCE_PATHFOLDER_XSD = IOUtils.findFile("schemaagent/example/correctPathFolder/correctPath.xsd");
	
	protected static final File CORRECT_REFERENCE_PATH_SAD = IOUtils.findFile("schemaagent/example/CorrectReferencePathExample.sad");
	protected static final String [] subfoldersPaths_1 = {"correctPathFolder","C:\\Work\\gui-automation\\data", "correctPathFolder"};

	
	@Test
	public void testConnectToServer() {
	
		robot.connectToServer();
		
	
//		asserting the "Styles of new items window"
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
	}
	
	
	@Test
	public void testReloadSearchPaths() {
		
		robot.newDesign();
		robot.reloadSearchPaths();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, EXPLORER);
		
	}
	
	
	@Test
	public void testCorrectReferencePaths() {
		
		removeAndAssert(CORRECT_REFERENCE_PATH_XSD);
		robot.openFile(CORRECT_REFERENCE_PATH_SAD);
		
		robot.reloadSearchPaths();
		
		robot.findElementOnDiagram(CORRECT_REFERENCE_PATH_XML.getName());
		
		robot.correctReferencePath(CORRECT_REFERENCE_PATHFOLDER_XSD);
		
		robot.insertFileIntoCurrentDesign(robot.findElementOnDiagram(subfoldersPaths_1, CORRECT_REFERENCE_PATHFOLDER_XSD.getName()));
		
		
		assertAreas(DIAGRAM_MAIN_WINDOW, EXPLORER);
		removeAndAssert(CORRECT_REFERENCE_PATH_XML);
	}
	
	@Test
	public void testCorrectAllReferencePaths() {
		
		//will tested only the window 
		robot.correctAllReferencePath();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(KeyEvent.VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 

		
	}
}
