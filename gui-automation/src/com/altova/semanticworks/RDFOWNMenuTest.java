package com.altova.semanticworks;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.SEMANTICWORKS_MAIN_WINDOW;
import static com.altova.semanticworks.SemanticWorksRobot.DETAILS;
import static com.altova.semanticworks.SemanticWorksRobot.ERRORS;

import org.junit.Test;

import com.altova.semanticworks.SemanticWorksRobot.OverviewTab;

public class RDFOWNMenuTest extends AbstractSemanticWorks{

	
	@Test
	public final void testRDF() {
		
		robot.RDF_Level();
	}
	
	@Test
	public final void testRDFS() {
		
		robot.RDFS_Level();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS);
	}

	@Test
	public final void testOWLLite() {
		
		robot.OWLLite_Level();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS);
	}

	@Test
	public final void testOWLDL() {
		
		robot.OWLDL_Level();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS);
	}
	
	@Test
	public final void testOWLFull() {
		
		robot.OWLFull_Level();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS);
	}
	
	@Test
	public final void testReloadAllImports() {
		
		robot.RDF_Level();
		robot.openDiagram("prod:Home", OverviewTab.Resources);
		robot.reloadAllImports();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS);
	}
	
	
	@Test
	public final void testSyntaxCheck() {
		
		robot.syntaxCheck();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS);
	}
	
	@Test
	public final void testSemanticsCheck() {
		
		robot.OWLLite_Level();
		robot.semanticsCheck();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS);
	}
	
}
