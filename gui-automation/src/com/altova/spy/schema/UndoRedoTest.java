package com.altova.spy.schema;


import java.io.File;
import static com.altova.spy.SpyRobot.*;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.SCHEMA_ATTRIBUTES;

import org.junit.Test;

import com.altova.spy.AbstractXmlSpyTest;

public class UndoRedoTest extends AbstractXmlSpyTest {
	static String testDir = "S:/QA/Internal/Test-Cases/XMLSpy/SchemaView/GUI/";
	
	private static File f_Address = new File(testDir + "UndoRedo/address.xsd");
	private static File f_Report = new File(testDir + "IC/report.xsd");
	private static File fAttribute_valid = new File(testDir + "IC/attribute_valid.xsd");
	
	@Test
	public void testSchemaView_Undo01_1() {
		
		robot.openFile(f_Address);
		robot.xpathHighlight("/schema/element/complexType/sequence");
		robot.selectFromItemContxtMenuInSchemaDiagram("Add child","Element");
		robot.typeStringEnter("test");
		robot.setPaneValue(DETAILS_DETAILS, "type", "string");
		robot.setPaneValue(DETAILS_DETAILS, "content", "complex");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,DETAILS_DETAILS,VALIDATION);
	}
	
	@Test
	public void testSchemaView_Undo01_2() {
		
		robot.openFile(f_Address);
		robot.xpathHighlight("/schema/element/complexType/sequence");
		robot.selectFromItemContxtMenuInSchemaDiagram("Add child","Element");
		robot.typeStringEnter("test");
		robot.setPaneValue(DETAILS_DETAILS, "type", "string");
		robot.setPaneValue(DETAILS_DETAILS, "type", "complex");
		robot.undo();
		assertAreas(DIAGRAM_MAIN_WINDOW,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_Undo02_1() {
		
		robot.openFile(f_Address);
		robot.xpathHighlight("/schema/element/complexType/sequence");
		robot.selectFromItemContxtMenuInSchemaDiagram("Add child","Element");
		robot.typeStringEnter("test");
		robot.setPaneValue(DETAILS_DETAILS, "type", "string");
		robot.undo();
		assertAreas(DIAGRAM_MAIN_WINDOW,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_Undo02_2() {
		
		robot.openFile(f_Address);
		robot.xpathHighlight("/schema/element/complexType/sequence");
		robot.selectFromItemContxtMenuInSchemaDiagram("Add child","Element");
		robot.typeStringEnter("ipo:test");
		robot.setPaneValue(DETAILS_DETAILS, "type", "string");
		robot.undo();
		robot.redo();
		assertAreas(DIAGRAM_MAIN_WINDOW,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_Undo03_1() {
		
		robot.openFile(f_Address);
		robot.xpathHighlight("/schema/element/complexType/sequence");
		robot.selectFromItemContxtMenuInSchemaDiagram("Add child","Element");
		robot.typeStringEnter("test");
		robot.setPaneValue(DETAILS_DETAILS, "type", "string");
		robot.setPaneValue(DETAILS_DETAILS, "derivedBy", "restriction");
		robot.undo();
		assertAreas(DIAGRAM_MAIN_WINDOW,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_Undo03_2() {
		
		robot.openFile(f_Address);
		robot.xpathHighlight("/schema/element/complexType/sequence");
		robot.selectFromItemContxtMenuInSchemaDiagram("Add child","Element");
		robot.typeStringEnter("ipo:test");
		robot.setPaneValue(DETAILS_DETAILS, "type", "string");
		robot.setPaneValue(DETAILS_DETAILS, "derivedBy", "restriction");
		robot.undo();
		robot.redo();
		assertAreas(DIAGRAM_MAIN_WINDOW,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_Undo04_1() {
		
		robot.openFile(f_Report);
		robot.xpathHighlight("/schema/complexType[@name=\'RegionsType\']");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute",null,false,null,null,null,null);
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testSchemaView_Undo04_2() {
		
		robot.openFile(f_Report);
		robot.xpathHighlight("/schema/complexType[@name=\'RegionsType\']");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","test",false,null,null,null,null);
		robot.undo();
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testSchemaView_Undo04_3() {
		
		robot.openFile(f_Report);
		robot.xpathHighlight("/schema/complexType[@name=\'RegionsType\']");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","test",false,null,null,null,null);
		robot.undo();
		robot.redo();
		robot.validate();
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES);
	}
	
	@Test
	public void testSchemaView_Undo05_1() {
		
		robot.openFile(f_Report);
		robot.appendXMLItemSchemaView("Attribute Group","testAttr", null);
		robot.appendInSchemaAttrWdw("Attribute","test",false,null,null,null,null);
		robot.xpathHighlight("/schema/complexType[@name=\'RegionsType\']");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute Group","r:testAttr",false,null,null,null,null);
		robot.undo();
		assertAreas(SCHEMA_ATTRIBUTES);
	}
	
	@Test
	public void testSchemaView_Undo05_2() {
		
		robot.openFile(f_Report);
		robot.appendXMLItemSchemaView("Attribute Group","testAttr", null);
		robot.appendInSchemaAttrWdw("Attribute","test",false,null,null,null,null);
		robot.xpathHighlight("/schema/complexType[@name=\'RegionsType\']");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute Group","r:testAttr",false,null,null,null,null);
		robot.undo();
		robot.redo();
		assertAreas(SCHEMA_ATTRIBUTES);
	}
	
	@Test
	public void testSchemaView_Undo06_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","test",false,null,null,null,null);
		robot.xpathHighlight("/xs:schema/xs:element/xs:complexType/xs:complexContent/xs:extension/xs:attribute");
		robot.selectFromItemContxtMenuInSchemaDiagram("Make Global","Attribute");
		robot.validate();
		assertAreas(DETAILS_DETAILS);
		robot.displayAllGlobals();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
		
	}
	
	@Test
	public void testSchemaView_Undo06_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","test",false,null,null,null,null);
		robot.xpathHighlight("/xs:schema/xs:element/xs:complexType/xs:complexContent/xs:extension/xs:attribute");
		robot.selectFromItemContxtMenuInSchemaDiagram("Make Global","Attribute");
		robot.undo();
		robot.xpathHighlight("/xs:schema/xs:element/xs:complexType/xs:complexContent/xs:extension/xs:attribute");
		robot.validate();
		assertAreas(DETAILS_DETAILS,VALIDATION,DIAGRAM_MAIN_WINDOW);
		
	}
	

	@Test
	public void testSchemaView_Undo06_3() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","test",false,null,null,null,null);
		robot.xpathHighlight("/xs:schema/xs:element/xs:complexType/xs:complexContent/xs:extension/xs:attribute");
		robot.selectFromItemContxtMenuInSchemaDiagram("Make Global","Attribute");
		robot.undo();
		robot.redo();
		robot.xpathHighlight("/xs:schema/xs:element/xs:complexType/xs:complexContent/xs:extension/xs:attribute");
		assertAreas(DIAGRAM_MAIN_WINDOW,DETAILS_DETAILS);
		
	}
	
	@Test
	public void testSchemaView_Undo07_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.selectFromItemContxtMenuInSchemaDiagram("New Global","Element");
		robot.typeStringEnter("elem1");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
		robot.displayAllGlobals();
		assertAreas("testSchemaView_Undo07_1_diagram_global",DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public void testSchemaView_Undo07_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.selectFromItemContxtMenuInSchemaDiagram("New Global","Element");
		robot.typeStringEnter("elem1");
		robot.undo();
		assertAreas(DIAGRAM_MAIN_WINDOW,DETAILS_DETAILS);	
		robot.validate();
		assertAreas(VALIDATION);
		robot.displayAllGlobals();
		assertAreas("testSchemaView_Undo07_2_diagram_global",DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testSchemaView_Undo07_3() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.selectFromItemContxtMenuInSchemaDiagram("New Global","Element");
		robot.typeStringEnter("elem1");
		robot.displayAllGlobals();
		robot.undo();
		robot.undo();
		robot.displayAllGlobals();
		assertAreas(DIAGRAM_MAIN_WINDOW);	
	}
	
	@Test
	public void testSchemaView_Undo08_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.selectFromItemContxtMenuInSchemaDiagram("New Global","Attribute");
		robot.typeStringEnter("attr1");
		assertAreas(DIAGRAM_MAIN_WINDOW);	
		
	}
	
	
	@Test
	public void testSchemaView_Undo08_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.selectFromItemContxtMenuInSchemaDiagram("New Global","Attribute");
		robot.typeStringEnter("attr1");
		robot.undo();
		assertAreas(DIAGRAM_MAIN_WINDOW);	
		robot.validate();
		assertAreas(VALIDATION);
	}
	
	@Test
	public void testSchemaView_Undo08_3() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.selectFromItemContxtMenuInSchemaDiagram("New Global","Attribute");
		robot.typeStringEnter("attr1");
		robot.undo();
		robot.undo();
		assertAreas(DIAGRAM_MAIN_WINDOW);	
		robot.validate();
		assertAreas(VALIDATION);
	}

}
