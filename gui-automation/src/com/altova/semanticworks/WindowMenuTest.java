package com.altova.semanticworks;

import static com.altova.robots.SnapshotArea.CommonArea.*;

import org.junit.Test;
import org.junit.internal.runners.MethodValidator;

public class WindowMenuTest extends AbstractSemanticWorks{

	@Test
	public final void testCascade() {
		
		robot.openFile(ALTOVADOCUMENTS_RDF_FILE);
		
		robot.cascade();
		
		assertAreas(MF_MAIN_WINDOW);		
	}
	
	
	@Test
	public final void testTile() {
		
		robot.openFile(ALTOVADOCUMENTS_RDF_FILE);
		
		robot.tile();
		
		assertAreas(MF_MAIN_WINDOW);
	}
	
	
	
	
}
