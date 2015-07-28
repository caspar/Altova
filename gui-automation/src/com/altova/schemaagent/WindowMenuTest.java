package com.altova.schemaagent;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.util.LoggerUtils.logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.altova.robots.ScriptMistakeException;

public class WindowMenuTest extends AbstractSchemaAgentTest {

	
	@Before 
	public void startUp(){
		
		robot.newDesign();
		robot.openFile(DB_COMPLETEPO_MAPFORCE_FILE);
	}
	
	@After
	public void CleanUp() {
	
		robot.closeWithoutSave();
	}
	
	
	
	@Test
	public void testCascade() {
		
		robot.windowCascade();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testTileHorizontally() {
		
		robot.windowTileHorizontally();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testTileVertically() {
		
		robot.windowTileVertically();
	
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
}
