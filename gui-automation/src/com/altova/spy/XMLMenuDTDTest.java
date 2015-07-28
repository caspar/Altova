package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;


import java.awt.Rectangle;
import java.io.File;

import org.junit.Test;
import org.junit.Before;

import com.altova.util.IOUtils;
import com.altova.util.AltovaJUnitRunner.TestRobot;

//@TestRobot(EclipseSpyRobot.class)

public class XMLMenuDTDTest extends AbstractXmlSpyTest{

	private static final String elnamedtd = "place";
	private static final String elemdate = "<!ELEMENT date (#PCDATA)>";
	private static final String attdtd = null;
	private static final String entnamedtd = "new_entity";
	private static final String notnamedtd = "new_notation";
	
	
	public void selectWithFind(String selection){
		robot.textView();
		robot.find(selection);
		robot.gridView();
	}
	
	@Before
	public void setUp() {
		
		File page = IOUtils.findFile("examples/news.dtd");
		assertFileExists(page);
		robot.openFile(page);
						
	}

	@Test
	public void testXMLInsertElementInDTD() {
		
		selectWithFind(elemdate);
		robot.XMLInsertElementInDTD(elnamedtd);
		robot.textView();
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	public void testXMLInsertAttListInDTD() {
		
		selectWithFind(elemdate);
		robot.XMLInsertAttListInDTD(attdtd);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLInsertEntityInDTD() {
		
		selectWithFind(elemdate);
		robot.XMLInsertEntityInDTD(entnamedtd,null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLInsertNotationInDTD() {
		
		selectWithFind(elemdate);
		robot.XMLInsertNotationInDTD(notnamedtd,null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	

	@Test
	public void testXMLAppendElementInDTD() {
		
		selectWithFind(elemdate);
		robot.XMLAppendElementInDTD(elnamedtd);
		robot.textView();
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLAppendAttListInDTD() {
		
		selectWithFind(elemdate);
		robot.XMLAppendAttListInDTD(attdtd);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLAppendEntityInDTD() {
		
		selectWithFind(elemdate);
		robot.XMLAppendEntityInDTD(entnamedtd,null);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLAppendNotationInDTD() {
		
		selectWithFind(elemdate);
		robot.XMLAppendNotationInDTD(notnamedtd,null);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
//	@Test
//	public void testXMLConvertToElementInDTD() {
//		
//		
//	}
//	
//	@Test
//	public void testXMLConvertToAttlistInDTD() {
//		
//		
//	}
	
	@Test
	public void testXMLConvertToEntityInDTD() {
		
		selectWithFind(elemdate);
		robot.XMLConvertToEntityInDTD();
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testXMLConvertToNotationInDTD() {
		
		selectWithFind(elemdate);
		robot.XMLConvertToNotationInDTD();
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

}
