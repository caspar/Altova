package com.altova.spy.schema;

import java.awt.event.KeyEvent;
import java.io.File;
import static com.altova.spy.SpyRobot.*;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.SCHEMA_ATTRIBUTES;

import org.junit.Test;

import com.altova.robots.ImageNotFoundException;
import com.altova.spy.AbstractXmlSpyTest;

public class IdConsAndAttrsGridTest extends AbstractXmlSpyTest {
	static String testDir = "S:/QA/Internal/Test-Cases/XMLSpy/SchemaView/GUI/";
	private static File f_Report = new File(testDir + "IC/report.xsd");
	private static File fAttribute_valid = new File(testDir + "Attributes/attribute_valid.xsd");
	private static File fAttribute_invalid = new File(testDir + "Attributes/attribute_invalid.xsd");
	private static File fAny_attribute=new File(testDir + "Attributes/anyAttribute.xsd");
	
	@Test
	public void testSchemaView_IC01_1() {
		
		robot.openFile(f_Report);
		robot.xpathHighlight("/schema/element/key");
		robot.selectFromItemContxtMenuInSchemaDiagram("Add child","Field");
		robot.typeStringEnter("@number");
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testSchemaView_IC01_2() {
		
		robot.openFile(f_Report);
		robot.xpathHighlight("/schema/element/key");
		robot.selectFromItemContxtMenuInSchemaDiagram("Add child","Field");
		robot.typeStringEnter("@number");
		robot.xpathHighlight("/schema/element/keyref");
		robot.selectFromItemContxtMenuInSchemaDiagram("Add child","Field");
		robot.typeStringEnter("@number");
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testSchemaView_IC02_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Unique",null,null,"TShirt", "@Size");
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testSchemaView_IC02_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Unique","test",null,"TShirt", "@Size");
		robot.validate();
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES);
	}
	
	@Test
	public void testSchemaView_IC02_3() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Unique","test",null,"TShirt", "@Size");
		robot.appendInSchemaIdConstWdw("Field",null,null,null,null);
		robot.setPaneValue(DETAILS_DETAILS, "xpath","null"); //for some reason, a field name is automatically added and we have to delete it now
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_IC02_4() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Unique","test",null,"TShirt", "@Size");
		robot.appendInSchemaIdConstWdw("Field","@SizeUK",null,null,null);
		robot.validate();
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES);
	}
	
	@Test
	public void testSchemaView_IC03_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Key","key1",null,null,null);
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public void testSchemaView_IC03_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Key","key1",null,null,null);
		robot.xpathHighlight("/xs:schema/xs:element/xs:key/xs:selector");
		robot.selectFromItemContxtMenuInSchemaDiagram("Edit","xpath");
		robot.typeStringEnter("TShirt");
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testSchemaView_IC03_3() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Key","key1",null,"TShirt","@test");
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS,SCHEMA_ATTRIBUTES);
	}
	
	@Test
	public void testSchemaView_IC04_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Keyref","keyref1",null,null,null);
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_IC04_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Keyref","keyref1",null,null,null);
		robot.xpathHighlight("/xs:schema/xs:element/xs:keyref/xs:selector");
		robot.selectFromItemContxtMenuInSchemaDiagram("Edit","xpath");
		robot.typeStringEnter("TShirt");
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testSchemaView_IC04_3() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Keyref","keyref1",null,"TShirt",null);
		robot.xpathHighlight("/xs:schema/xs:element/xs:keyref/xs:field");
		robot.selectFromItemContxtMenuInSchemaDiagram("Edit","xpath");
		robot.typeStringEnter("@Size");
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_IC04_4() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Keyref","keyref1",null,"TShirt","@Size");
		robot.xpathHighlight("/xs:schema/xs:element/xs:keyref");
		robot.selectFromItemContxtMenuInSchemaDiagram("Edit","refer");
		robot.typeStringEnter("test1");
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testSchemaView_IC04_5() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Keyref","keyref1","test1","TShirt","@Size");
		robot.appendInSchemaIdConstWdw("Key","test1",null,"TShirt","@test");
		robot.validate();
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES);
	}
	
	@Test
	public void testSchemaView_IC05_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Unique","test",null,"TShirt","@test");
		robot.validate();
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES);
	}
	
	@Test
	public void testSchemaView_IC05_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Unique","test",null,"TShirt","@test");
		robot.insertInSchemaIdConstWdw("Field","@Size",null,null,null);
		robot.validate();
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES);
	}
	
	@Test
	public void testSchemaView_IC05_3() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Unique","test",null,"TShirt","@test");
		robot.insertInSchemaIdConstWdw("Field","@Size",null,null,null);
		robot.delay(1000);
		robot.keyType(KeyEvent.VK_DOWN);
		robot.appendInSchemaIdConstWdw("Field","@SizeUK",null,null,null);
		robot.validate();
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES);
	}
	
	@Test
	public void testSchemaView_IC06_1(){
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Unique", "test", null, "test", "test");
		robot.visualizeIdentityConstraintsStateChange();
		robot.validate();
		try{
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES);
		}finally{
			robot.visualizeIdentityConstraintsStateChange();
		}
	}
	
	@Test
	public void testSchemaView_IC06_2(){
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Unique", "test", null, "test", "test");
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public void testSchemaView_IC06_3(){
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Unique", "test", null, "TShirt", "@test");
		robot.validate();
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES);
	}
	
	
	@Test
	public void testSchemaView_AT01_1() {
		
		robot.openFile(fAttribute_invalid);
		robot.xpathHighlight("/xs:schema/xs:attributeGroup/xs:attribute[3]");
		robot.setPaneValue(DETAILS_DETAILS, "name", "test");
		robot.validate();
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES);
	}
	
	@Test
	public void testSchemaView_AT01_2() {
		
		robot.openFile(fAttribute_invalid);
		robot.xpathHighlight("/xs:schema/xs:attributeGroup/xs:attribute[3]");
		robot.setPaneValue(DETAILS_DETAILS, "name", "test");
		robot.undo();
		robot.validate();
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES);
	}
	
	@Test
	public void testSchemaView_AT01_3() {
		
		robot.openFile(fAttribute_invalid);
		robot.xpathHighlight("/xs:schema/xs:attributeGroup/xs:attribute[3]");
		robot.setPaneValue(DETAILS_DETAILS, "name", "test");
		robot.undo();
		robot.redo();
		robot.validate();
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES);
	}
	
	@Test
	public void testSchemaView_AT01_4() {
		
		robot.openFile(fAttribute_invalid);
		robot.xpathHighlight("/xs:schema/xs:attributeGroup/xs:attribute[3]");
		robot.setPaneValue(DETAILS_DETAILS, "name", "test");
		robot.setPaneValue(DETAILS_DETAILS,"use","prohibited");
		robot.validate();
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_AT02_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:attributeGroup/xs:attribute[3]");
		robot.setPaneValue(DETAILS_DETAILS, "fixed", "ExtraLarge");
		robot.validate();
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_AT02_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:attributeGroup/xs:attribute[3]");
		robot.setPaneValue(DETAILS_DETAILS, "fixed", "Small");
		assertAreas(SCHEMA_ATTRIBUTES,DETAILS_DETAILS);
		robot.validate();
		assertAreas(VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT02_3() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:attributeGroup/xs:attribute[3]");
		robot.setPaneValue(DETAILS_DETAILS, "fixed", "Small");
		robot.setPaneValue(DETAILS_DETAILS, "default", "test");
		robot.validate();
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_AT03_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute", "test", false, "xs:boolean",null, null, null);
		robot.validate();
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_AT03_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute", "test", false, "xs:boolean",null, null, null);
		robot.setPaneValue(DETAILS_DETAILS, "default", "1");
		robot.validate();
		assertAreas(SCHEMA_ATTRIBUTES,DETAILS_DETAILS,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT03_3() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute", "test", false, "xs:boolean",null, null, null);
		robot.setPaneValue(DETAILS_DETAILS, "default", "1");
		robot.setPaneValue(DETAILS_DETAILS, "fixed", "false");
		robot.validate();
		assertAreas(SCHEMA_ATTRIBUTES,DETAILS_DETAILS,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT03_4() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute", "test", false, "xs:boolean",null, null, null);
		robot.setPaneValue(DETAILS_DETAILS, "default", "1");
		robot.setPaneValue(DETAILS_DETAILS, "fixed", " 1");
		robot.validate();
		assertAreas(SCHEMA_ATTRIBUTES,DETAILS_DETAILS,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT04_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute", "test",false, null, "optional","testval",null);
		robot.validate();
		assertAreas(SCHEMA_ATTRIBUTES,DETAILS_DETAILS,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT04_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute", "test",false, null, "prohibited","testval",null);
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,DETAILS_DETAILS,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT04_3() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute", "test",false, null, "required","testval",null);
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,DETAILS_DETAILS,VALIDATION);
	}
	
	
	@Test
	public void testSchemaView_AT05_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute", "test",false, null, "prohibited","testval","testval");
		robot.validate();
		assertAreas(SCHEMA_ATTRIBUTES,DETAILS_DETAILS,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT05_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute", "test",false, null, "prohibited","5","testval");
		robot.setPaneValue(DETAILS_DETAILS, "default", "5");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,DETAILS_DETAILS,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT05_3() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute", "test",false, null, null,"5","testval");
		robot.validate();
		assertAreas(SCHEMA_ATTRIBUTES,DETAILS_DETAILS,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT06_1() {
		
		robot.openFile(fAttribute_valid);
		robot.appendXMLItemSchemaView("Attribute","mainAttr", null);
		robot.validate();
		assertAreas(SCHEMA_ATTRIBUTES,DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT06_2() {
		
		robot.openFile(fAttribute_valid);
		robot.appendXMLItemSchemaView("Attribute","mainAttr", null);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute", "mainAttr_invalid", true,null, null, null, null);
		robot.xpathHighlight("/xs:schema/xs:element/xs:complexType/xs:complexContent/xs:extension/xs:attribute");
		robot.selectFromItemContxtMenuInSchemaDiagram("Reference");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,DETAILS_DETAILS,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT06_3() {
		
		robot.openFile(fAttribute_valid);
		robot.appendXMLItemSchemaView("Attribute","mainAttr", null);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute", "mainAttr", true,null, null, null, null);
		robot.validate();
		assertAreas(SCHEMA_ATTRIBUTES,DETAILS_DETAILS,VALIDATION);
	}
	
	
	@Test
	public void testSchemaView_AT07_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Any Attribute", "##any",false, null,null, null,null);
		try{
			robot.appendInSchemaAttrWdw("Any Attribute","try",false,null,null,null,null);
		}catch(ImageNotFoundException e){
			//do nothing
		}
		robot.validate();
		assertAreas(SCHEMA_ATTRIBUTES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT08_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute", "test",false, null,null, null,null);
		robot.validate();
		assertAreas(SCHEMA_ATTRIBUTES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT08_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute", "test",false, null,null, null,null);
		robot.appendInSchemaAttrWdw("Attribute", "test  ",false, null,null, null,null);
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_AT08_3() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute", "test",false, null,null, null,null);
		robot.appendInSchemaAttrWdw("Attribute", "  test",false, null,null, null,null);
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_AT08_4() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute", "test",false, null,null, null,null);
		robot.appendInSchemaAttrWdw("Attribute", "test1",false, null,null, null,null);
		robot.validate();
		assertAreas(SCHEMA_ATTRIBUTES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT09_1() {
		
		robot.openFile(fAny_attribute);
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute Group","myAttrGroup",false, null,null, null,null);
		robot.validate();
		assertAreas(SCHEMA_ATTRIBUTES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT09_2() {
		
		robot.openFile(fAny_attribute);
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute Group","myAttrGroup",false, null,null, null,null);
		robot.xpathHighlight("/xs:schema/xs:complexType/xs:anyAttribute");
		robot.delete();
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT09_3() {
		
		robot.openFile(fAny_attribute);
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute Group","myAttrGroup",false, null,null, null,null);
		robot.xpathHighlight("/xs:schema/xs:complexType/xs:anyAttribute");
		robot.delete();
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.selectFromItemContxtMenuInSchemaDiagram("Add child","Any Attribute");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT10_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","test",false, null,null, null,null);
		robot.validate();
		assertAreas(SCHEMA_ATTRIBUTES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT10_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","test",false, null,null, null,null);
		robot.insertInSchemaAttrWdw("Attribute","test1",false, null,null, null,null);
		robot.validate();
		assertAreas(SCHEMA_ATTRIBUTES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT10_3() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","test",false, null,null, null,null);
		robot.insertInSchemaAttrWdw("Attribute Group","myAttrGroup",false, null,null, null,null);
		robot.insertInSchemaAttrWdw("Attribute","test1",false, null,null, null,null);
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT10_4() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","test2",false, null,null, null,null);
		robot.insertInSchemaAttrWdw("Attribute Group","myAttrGroup",false, null,null, null,null);
		robot.insertInSchemaAttrWdw("Attribute","test1",false, null,null, null,null);
		robot.validate();
		assertAreas(SCHEMA_ATTRIBUTES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT11_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.selectFromItemContxtMenuInSchemaDiagram("New Global","Attribute");
		robot.typeStringEnter("attr1");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	public void testSchemaView_AT11_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.selectFromItemContxtMenuInSchemaDiagram("New Global","Attribute");
		robot.typeStringEnter("attr1");
		robot.xpathHighlight("/xs:schema/xs:attributeGroup");
		robot.appendInSchemaAttrWdw("Attribute", "attr1",true,null,null,null,null);
		robot.validate();
		assertAreas(SCHEMA_ATTRIBUTES,VALIDATION);
	}
}
