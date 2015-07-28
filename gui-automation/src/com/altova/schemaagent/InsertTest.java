package com.altova.schemaagent;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import java.awt.Rectangle;
import java.io.File;

import org.junit.Test;

import com.altova.util.IOUtils;

public class InsertTest extends AbstractSchemaAgentTest {

	
	
	
	@Test
	public void testInsert() {
		
		robot.search();
		//robot.openFile(DB_COMPLETEPO_MAPFORCE_FILE);
		
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	
}
