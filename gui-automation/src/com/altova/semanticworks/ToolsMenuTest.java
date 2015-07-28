package com.altova.semanticworks;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;
import static com.altova.semanticworks.SemanticWorksRobot.DETAILS;
import static com.altova.semanticworks.SemanticWorksRobot.ERRORS;

import java.awt.event.KeyEvent;
import java.util.logging.Logger;

import org.junit.Test;

import com.altova.semanticworks.SemanticWorksRobot.OverviewTab;
import com.altova.semanticworks.SemanticWorksRobot.classes;
import com.altova.util.LoggerUtils;

public class ToolsMenuTest extends AbstractSemanticWorks{

	
	@Test
	public final void testNamespaceImportsForRDF_IntegrityWindow(){
		
		robot.leftClickMenuItem("Tools", "Namespace Imports for RDF...");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(KeyEvent.VK_ENTER);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 

	}
	
	
	@Test
	public final void testNamespaceColorAssignements_IntegrityWindow(){
		
		robot.leftClickMenuItem("Tools", "Namespace color assignments...");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(KeyEvent.VK_ENTER);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	

	@Test
	public final void testNamespaceURIRefPrefixesLoadedFile_IntegrityWindow(){
		
		robot.leftClickMenuItem("Tools", "URIref Prefixes...");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(KeyEvent.VK_ENTER);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
	}

	@Test
	public final void testNamespaceURIRefPrefixesNewFile_IntegrityWindow(){
		
		robot.newFile();
		robot.leftClickMenuItem("Tools", "URIref Prefixes...");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(KeyEvent.VK_ENTER);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
	}

	@Test
	public final void testBaseURILoadedFile_IntegrityWindow(){
		
		robot.leftClickMenuItem("Tools", "Base URI...");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(KeyEvent.VK_ENTER);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testNamespaceImportsForRDF(){
		
		robot.openFile(NAMESPACEIMPORTSFOR_RDF_FILE);
		robot.namespaceImportsForRDF("Add", PURLORG_URI_NAMESPACE, DCONTOLOGY_RDF_FILE);
		robot.RDF_Level();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, DETAILS, ERRORS);
		robot.namespaceImportsForRDF("Delete", PURLORG_URI_NAMESPACE, DCONTOLOGY_RDF_FILE);
	}
	
	
	@Test
	public final void testNamespaceColorAssignemnt_on() {
		
		robot.newFile();
		robot.namespaceColorAssignment("Add", ALTOVA_URI_NAMESPACE, ICONCOLOR_255_0_0);
		robot.addNewElement(OverviewTab.Classes, "owl:Class", ALTOVA_URI_NAMESPACE+"MyObject");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	// Test must run after testNamespaceColorAssignemnt_on()
	@Test
	public final void testNamespaceColorAssignemnt_off() {
		
		robot.newFile();
		robot.addNewElement(OverviewTab.Classes, "owl:Class", ALTOVA_URI_NAMESPACE+"MyObject");
		robot.namespaceColorAssignment("Delete", ALTOVA_URI_NAMESPACE, ICONCOLOR_255_0_0);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);	
	}

	@Test
	public final void testURIRefPrefixes_Add() {
		
		robot.newFile();
		robot.URIrefPrefixes("Add", "gui", NANONULL_URI_NAMESPACE);

		//robot.addNewElement(OverviewTab.Classes, "owl:Class", "gui:MyObject");
		robot.addNewElementWitoutDiagram(OverviewTab.Classes, "owl:Class", NANONULL_URI_NAMESPACE+"MyObject");
		//robot.textView();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, DETAILS);
		
	}
	
	@Test
	public final void testURIRefPrefixes_Delete() {
		
		robot.openFile(PREFIXNAMESPACE_RDF_FILE);
		robot.URIrefPrefixes("Delete", "gui", "gui:MyObject");

		//robot.addNewElement(OverviewTab.Classes, "owl:Class", "gui:MyObject");
		//robot.addNewElementWitoutDiagram(OverviewTab.Classes, "owl:Class", NANONULL_URI_NAMESPACE+"MyObject");
		//robot.textView();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public final void testBaseURI() {
		
		robot.newFile();
		
		robot.baseURI(BASEURI_FILE_PATH.getAbsolutePath());
		robot.textView();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	
}
