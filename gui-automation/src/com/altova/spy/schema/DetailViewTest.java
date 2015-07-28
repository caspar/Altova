package com.altova.spy.schema;

import static com.altova.spy.SpyRobot.*;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.SCHEMA_ATTRIBUTES;
import com.altova.spy.AbstractXmlSpyTest;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Schema View Test Cases - Detail View
 * 
 * @author Phelim McConigly
 */
public class DetailViewTest extends AbstractXmlSpyTest {

	

	static String testDir = "S:/QA/Internal/Test-Cases/XMLSpy/SchemaView/GUI/";

	private static File fSimpleElement_Group_1 = new File(testDir + "Detailview/SimpleElement_Group_1.xsd");
	private static File fRestricted_anyType = new File(testDir + "Detailview/restricted_anyType.xsd");
	private static File fST_Simple_invalid = new File(testDir + "Detailview/ST_Simple_invalid.xsd");
	private static File fAttribute_valid = new File(testDir + "Detailview/attribute_valid.xsd");
	private static File f_2Elements = new File(testDir + "Detailview/2Elements.xsd");
	private static File f_All_1 = new File(testDir + "Detailview/Modelgroups/all_1.xsd");
	private static File f_Sequence_1 = new File(testDir + "Detailview/Modelgroups/sequence_1.xsd");
	private static File f_Choice_1 = new File(testDir + "Detailview/Modelgroups/choice_1.xsd");
	private static File TTP34509_XSD_FILE = new File(testDir+"Detailview/TTP34509.xsd");
	
	@Test
	public void testSchemaView_DV01_1() {
		
		robot.openFile(fSimpleElement_Group_1);
		robot.setPaneValue(DETAILS_DETAILS, "substGrp", "MyElement2");
		robot.xpathHighlight("/xs:schema/xs:element[@name=\"MyElement2\"]");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	public void testSchemaView_DV01_2() {
		
		robot.openFile(fSimpleElement_Group_1);
		robot.setPaneValue(DETAILS_DETAILS, "substGrp", "MyElement2");
		robot.xpathHighlight("/xs:schema/xs:element[@name=\"MyElement2\"]");
		robot.delay(2000);
		robot.keyType(KeyEvent.VK_DOWN);
		assertAreas(DETAILS_DETAILS);
		robot.setPaneValue(DETAILS_DETAILS, "substGrp", "MyElement3");
		assertAreas("testSchemaView_DV01_2_element2_diagram",DIAGRAM_MAIN_WINDOW);
		robot.displayAllGlobals();
		robot.xpathHighlight("/xs:schema/xs:element[@name=\"MyElement3\"]");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW, VALIDATION);
	}

	@Test
	public void testSchemaView_DV02_1() {
		
		robot.openFile(fRestricted_anyType);
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.find("hallo");
		robot.setPaneValue(DETAILS_DETAILS, "maxOcc", "0");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW, VALIDATION);
	}
	
	@Test //MANUAL testing required here...- use +- to change values
	public void testSchemaView_DV02_2() {
		
		robot.openFile(fRestricted_anyType);
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.find("hallo");
		robot.setPaneValue(DETAILS_DETAILS, "maxOcc", "99");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW, VALIDATION);
	}
		

	@Test //MANUAL testing required here...- use +- to change values
	public void testSchemaView_DV03() {
		
		robot.openFile(fRestricted_anyType);
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.find("hallo");
		robot.setPaneValue(DETAILS_DETAILS, "type", "xs:anyType");
		robot.setPaneValue(DETAILS_DETAILS, "maxOcc", "0");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW, VALIDATION);
		
		
	}
	
	/*
	 * Steps													Expected behavior
	 * *********************************************************************************
		1	element "hallo": minOcc = 1, maxOcc = 2				both values have a - and a + 
		2	press '+' of minOcc		value changes to 2 			+ of minOcc disappears 		- of maxOcc disappears"
		3	"entry helpers of sequence: maxOcc = unbounded  	minOcc and maxOcc values shown in diagram	1 - and +) and unbounded sign and -"
		4	press '-' of maxOcc in sequence						values disappear below item
	 */
	@Test //do this test manually: automation is not possible
	@Ignore
	public void testSchemaView_DV04() {
		robot.openFile(fRestricted_anyType);
		robot.xpathHighlight("/xs:schema/xs:complexType");
		
		assertAreas(DETAILS);
	}
	
	/*
	 * Steps										Expected behavior
	 * *************************************************************************************
		1	smart restriction OFF					derived in detailview	everything looks fine
		2	smart restriction ON					elem3 and the 2nd elem2 in ""blue box"" elem2 has red frame
		3	drag&drop elem3 below invalid elem2		2nd elem2 has red frame
		4	maxOcc of invalid elem2 = 0				2nd elem2 stroke through validation = VALID"

	 */
	@Test
	public void testSchemaView_DV05_1() {
		
		robot.openFile(fST_Simple_invalid);
		robot.smartRectrictionStateChange();
		robot.find("derived");
		robot.validate();
		try{
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
		}finally{
			robot.smartRectrictionStateChange();
		}
	}

	@Test
	public void testSchemaView_DV05_2() {
		
		robot.openFile(fST_Simple_invalid);
		robot.find("derived");
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
	}
	

	@Test
	public void testSchemaView_DV05_3() {
		
		robot.openFile(fST_Simple_invalid);
		robot.xpathHighlight("/xs:schema/xs:complexType[2]/xs:complexContent/xs:restriction/xs:choice/xs:element[4]");
		robot.setPaneValue(DETAILS, "maxOcc","0");
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
	}
	
	
	/*
	 * Steps										Expected behavior
	 * *********************************************************************************************
	 * If default and use are both present, use must have the �actual value� optional.	
		1	name="test", default="testval", use="optional"		valid
		2	use="prohibited"						"invalid prohibited = colored red"
		3	use="required"							"invalid required = colored red"
		4	use="optional"							"valid optional = colored black"
	 */
	
	@Test
	public void testSchemaView_DV06_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","test",false,null,"optional","testval", null);
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS,SCHEMA_ATTRIBUTES);
	}
	
	@Test
	public void testSchemaView_DV06_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","test",false,null,"prohibited","testval", null);
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS,DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testSchemaView_DV06_3() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","test",false,null,"required","testval", null);
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS,DIAGRAM_MAIN_WINDOW);
	}
	
	
	/*
	 * Steps		If default and use are both present, use must have the �actual value� optional.	Expected behavior
	 * ******************************************************************************
		1	name="test", 					default="testval", use="optional"		valid
		2	use="prohibited"				invalid prohibited = colored red
		3	fixed="testval"					valid prohibited is colored black
		4	default="5"						invalid use = colored red"
		5	delete use value				valid
	 */
	@Test
	public void testSchemaView_DV07_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","test",false,null,"prohibited","testval","testval");
		robot.validate();
		assertAreas(VALIDATION, DETAILS_DETAILS,SCHEMA_ATTRIBUTES);
	}
	
	@Test
	public void testSchemaView_DV07_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","test",false,null,"prohibited","testval", "testval");
		robot.setPaneValue(DETAILS_DETAILS, "default","5");
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS,DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testSchemaView_DV07_3() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","test",false,null,null,"5", null);
		robot.validate();
		assertAreas(VALIDATION, DETAILS_DETAILS);
	}

	
	/*
	 * Steps			Expected behavior
	 * ************************************************************************
		1	"add attribute in global view name=""mainAttr"""		valid
		2	try adding attribute, attributeGrp, any attribute in grid		not possible
		3	"add attribute, assign ""mainAttr_invalid"" isRef=""true"""	open element "root" in detailview	"invalid must refer to an existing attribute"
		4	change name to "mainAttr"	use dropdownlist in EH (Details)	valid
	 */
	@Test
	public void testSchemaView_DV08_1() {
		//in attributes window, it can be seen that the append/insert icons are disabled
		
		robot.openFile(fAttribute_valid);
		robot.appendXMLItemSchemaView("Attribute","mainAttr", null) ;
		robot.validate();
		assertAreas(SCHEMA_ATTRIBUTES);
		
	}	
	
	@Test
	public void testSchemaView_DV08_2() {
		
		robot.openFile(fAttribute_valid);
		robot.appendXMLItemSchemaView("Attribute","mainAttr", null) ;
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","mainAttr_invalid", false, null,null,null,null);
		robot.gridView();
		robot.xpathHighlight("/xs:schema/xs:element/xs:complexType/xs:complexContent/xs:extension/xs:attribute/@name");
		robot.delete();
		robot.xpathHighlight("/xs:schema/xs:element/xs:complexType/xs:complexContent/xs:extension/xs:attribute");
		robot.XMLAddChildAttribute("ref", "mainAttr_invalid");
		robot.schemaView();
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);	
	}
	
	@Test
	public void testSchemaView_DV08_3() {
		
		robot.openFile(fAttribute_valid);
		robot.appendXMLItemSchemaView("Attribute","mainAttr", null) ;
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","mainAttr", true, null,null,null,null);
		robot.displayDiagram();
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);	
	}
	
	/*
	 * Steps													Expected behavior
	 * *****************************************************************************
		1	"add attribute in global view name="mainAttr" valid
		2	try adding attribute, attributeGrp, any attribute in grid		not possible
		3	"add attribute, assign ""mainAttr_invalid"" isRef=""true"""	open element "root" in detailview	"invalid
				must refer to an existing attribute"
		4	change name to "mainAttr"	"use dropdownlist in diagram dblclick attribute name"	valid
	 */
	@Test
	public void testSchemaView_DV09_1() {
		
		robot.openFile(fAttribute_valid);
		robot.appendXMLItemSchemaView("Attribute","mainAttr", null) ;
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","m", true, null,null,null,null);
		robot.validate();
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES);	
	}
	/*
	 * Steps													Expected behavior
	 * **********************************************************************************
		1	add attributegroup to element "root", assign myAttrGrp		valid
		2	add attribute, name ="Size"		"invalid attribute is already defined both ""Size"" are colored red"
		3	delete attribute "Size" under root		valid
		4	add attributegroup to element "root", assign myAttrGrp		invalid
	 */
	@Test
	public void testSchemaView_DV10_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.selectFromItemContxtMenuInSchemaDiagram("Add child","Attribute Group");
		robot.typeStringEnter("myAttrGroup");
		robot.validate();
		robot.displayAllGlobals();
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES);
	}
	
	@Test
	public void testSchemaView_DV10_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.selectFromItemContxtMenuInSchemaDiagram("Add child","Attribute Group");
		robot.typeStringEnter("myAttrGroup");
		robot.selectFromItemContxtMenuInSchemaDiagram("Append","Attribute");
		robot.typeStringEnter("Size");
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
		robot.displayAllGlobals();
		assertAreas(SCHEMA_ATTRIBUTES);
	}

	@Test
	public void testSchemaView_DV10_3() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute Group","myAttrGroup", false, null,null,null,null);
		robot.appendInSchemaAttrWdw("Attribute Group","myAttrGroup", false, null,null,null,null);
		assertAreas(SCHEMA_ATTRIBUTES);
		robot.validate();
		assertAreas(VALIDATION);
	}
	/*
	 * Steps													Expected behavior
	 * ***********************************************************************************
		1	add 2 attributes name both "testAttr"	element root in detailview both colored red invalid
		2	rename 2nd attribute != testAttr					valid both colored black
	 */
	@Test
	public void testSchemaView_DV11_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","testAttr", false, null,null,null,null);
		robot.appendInSchemaAttrWdw("Attribute","testAttr", false, null,null,null,null);
		robot.displayDiagram();
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
		
	}
	
	@Test
	public void testSchemaView_DV11_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","testAttr1", false, null,null,null,null);
		robot.appendInSchemaAttrWdw("Attribute","testAttr2", false, null,null,null,null);
		assertAreas(SCHEMA_ATTRIBUTES);
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
		
	}
	
	
	/*
	 * Steps			Expected behavior
	 * *************************************************************************************
		1	"new IC ""Unique"", selector =""sel"", field=""f1"""	element "root"  invalid name is missing
		2	name="u1"	detailview  	valid
		3	add field 		"invalid xpath is missing"
		4	field = "f2"	detailview 	valid
	 */
	@Test
	public void testSchemaView_DV12_1() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Unique",null,null,"TShirt","@Size");
		robot.validate() ;
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
	}	
	
	@Test
	public void testSchemaView_DV12_2() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Unique","test",null,"TShirt","@Size");
		robot.validate() ;
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES);
	}
	
	@Test
	public void testSchemaView_DV12_3() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Unique","test",null,"TShirt","@Size");
		robot.appendInSchemaIdConstWdw("Field",null,null,null,null);
		robot.setPaneValue(DETAILS_DETAILS, "xpath","null"); //for some reason, a field name is automatically added and we have to delete it now
		robot.validate() ;
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
	}


	@Test
	public void testSchemaView_DV12_4() {
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaIdConstWdw("Unique","test",null,"TShirt","@Size");
		robot.appendInSchemaIdConstWdw("Field","@SizeUK",null,null,null);
		robot.validate() ;
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES);
	}
	/*
	 * Steps			Expected behavior
	 * **************************************************************************************************
		1	add new element "  root"		invalid 
		2	change "  root" to "root    "		invalid
		3	change "root    " to "root"		invalid
		4	change "root" to "root1"		valid
	 */
	@Test
	public void testSchemaView_DV13_1() {
		
		robot.openFile(fAttribute_valid);
		robot.appendXMLItemSchemaView("Element","  root", null) ;
		robot.validate() ;
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testSchemaView_DV13_2() {
		
		robot.openFile(fAttribute_valid);
		robot.appendXMLItemSchemaView("Element","root  ", null) ;
		robot.validate() ;
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testSchemaView_DV13_3() {
		
		robot.openFile(fAttribute_valid);
		robot.appendXMLItemSchemaView("Element","root", null) ;
		robot.validate() ;
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testSchemaView_DV13_4() {
		
		robot.openFile(fAttribute_valid);
		robot.appendXMLItemSchemaView("Element","root1", null) ;
		robot.validate() ;
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);		
	}
	
	/*
	 * Steps			Expected behavior
	 * **************************************************************************************************
		1	add attribute name="test"	valid 
		2	rightmouseclick > make global > attribute 	isref="true" global attribute "test" added in global view
valid
		3	delete global attribute >    attribute "test" colored red >invalid
		4	delete "isRef" in att test > type and form are listed again in EH
	 */
	
	@Test
	public void testSchemaView_DV14_1() { 
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute","test", false, null,null,null,null);
		robot.validate();
		assertAreas(VALIDATION,SCHEMA_ATTRIBUTES);
	}
	
	@Test 
	public void testSchemaView_DV14_2() { 
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.selectFromItemContxtMenuInSchemaDiagram("Add child","Attribute");
		robot.typeStringEnter("test");
		robot.selectFromItemContxtMenuInSchemaDiagram("Make Global","Attribute");
		assertAreas(DETAILS_DETAILS);
		robot.validate();
		robot.displayAllGlobals();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test 
	public void testSchemaView_DV14_3() { 
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.selectFromItemContxtMenuInSchemaDiagram("Add child","Attribute");
		robot.typeStringEnter("test");
		robot.selectFromItemContxtMenuInSchemaDiagram("Make Global","Attribute");
		robot.displayAllGlobals();
		robot.deleteGlobalItemInSchema("/xs:schema/xs:attribute");
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test 
	public void testSchemaView_DV14_4() { 
		
		robot.openFile(fAttribute_valid);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.selectFromItemContxtMenuInSchemaDiagram("Add child","Attribute");
		robot.typeStringEnter("test");
		robot.selectFromItemContxtMenuInSchemaDiagram("Make Global","Attribute");
		robot.displayAllGlobals();
		robot.deleteGlobalItemInSchema("/xs:schema/xs:attribute");
		robot.gridView();
		robot.xpathHighlight("/xs:schema/xs:element/xs:complexType/xs:complexContent/xs:extension/xs:attribute/@ref");
		robot.delete();
		robot.xpathHighlight("/xs:schema/xs:element/xs:complexType/xs:complexContent/xs:extension/xs:attribute");
		robot.XMLAddChildAttribute("name", "test");
		robot.schemaView(); 
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS);
		
	}
	
	@Test
	public void testSchemaView_DV15_1() { 
		
		robot.openFile(fAttribute_valid);
		robot.appendXMLItemSchemaView("Attribute","attr", null) ;
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.displayAllGlobals();
		robot.appendInSchemaAttrWdw("Attribute", "attr", true,null, null,null,null);
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,SCHEMA_ATTRIBUTES,DETAILS_DETAILS,VALIDATION);
	}
	
	@Test
	public void testSchemaView_MG01_1(){
		
		robot.openFile(f_2Elements);
		robot.appendXMLItemSchemaView("ComplexType","test_ct", null) ;
		robot.displayDiagram();
		robot.selectFromItemContxtMenuInSchemaDiagram("Add child","All");
		assertAreas(DIAGRAM_MAIN_WINDOW);		
	}
	
	@Test
	public void testSchemaView_MG01_2(){
		
		robot.openFile(f_2Elements);
		robot.appendXMLItemSchemaView("ComplexType","test_ct", null) ;
		robot.displayDiagram();
		robot.selectFromItemContxtMenuInSchemaDiagram("Add child","All");
		robot.setPaneValue(DETAILS_DETAILS, "minOcc", "0");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,DETAILS_DETAILS,VALIDATION);		
	}
	
	@Test
	public void testSchemaView_MG01_3(){
		
		robot.openFile(f_2Elements);
		robot.appendXMLItemSchemaView("ComplexType","test_ct", null) ;
		robot.displayDiagram();
		robot.selectFromItemContxtMenuInSchemaDiagram("Add child","All");
		robot.setPaneValue(DETAILS_DETAILS, "minOcc", "0");
		robot.setPaneValue(DETAILS_DETAILS, "maxOcc", "2");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION,DETAILS_DETAILS);		
	}
	
	@Test
	public void testSchemaView_MG01_4(){
		
		robot.openFile(f_2Elements);
		robot.appendXMLItemSchemaView("ComplexType","test_ct", null) ;
		robot.gridView();
		robot.xpathHighlight("/xs:schema/xs:complexType/@name");
		robot.XMLAppendElement("xs:all", null);
		robot.schemaView();
		robot.setPaneValue(DETAILS_DETAILS, "minOcc", "2");
		robot.setPaneValue(DETAILS_DETAILS, "maxOcc", "2");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION,DETAILS_DETAILS);		
	}
	
	@Test
	public void testSchemaView_MG02_1(){
		
		robot.openFile(f_All_1);
		robot.xpathHighlight("/xs:schema/xs:complexType/xs:all");
		robot.setPaneValue(DETAILS_DETAILS, "maxOcc", "50");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,DETAILS_DETAILS,VALIDATION);		
	}
	
	@Test
	public void testSchemaView_MG02_2(){
		
		robot.openFile(f_All_1);
		robot.xpathHighlight("/xs:schema/xs:complexType/xs:all");
		robot.setPaneValue(DETAILS_DETAILS, "maxOcc", "50");
		robot.setPaneValue(DETAILS_DETAILS, "model", "choice");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION,DETAILS_DETAILS);		
	}
	
	@Test
	public void testSchemaView_MG02_3(){
		
		robot.openFile(f_All_1);
		robot.xpathHighlight("/xs:schema/xs:complexType/xs:all");
		robot.setPaneValue(DETAILS_DETAILS, "maxOcc", "50");
		robot.setPaneValue(DETAILS_DETAILS, "model", "choice");
		robot.setPaneValue(DETAILS_DETAILS, "minOcc", "-1");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION,DETAILS_DETAILS);		
	}
	
	@Test
	public void testSchemaView_MG02_4(){
		
		robot.openFile(f_All_1);
		robot.xpathHighlight("/xs:schema/xs:complexType/xs:all");
		robot.setPaneValue(DETAILS_DETAILS, "maxOcc", "50");
		robot.selectFromItemContxtMenuInSchemaDiagram("Change Model","Choice");
		robot.setPaneValue(DETAILS_DETAILS, "minOcc", "51");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION,DETAILS_DETAILS);		
	}
	
	@Test
	public void testSchemaView_MG03_1(){
		
		robot.openFile(f_All_1);
		robot.xpathHighlight("/xs:schema/xs:complexType/xs:all");
		robot.setPaneValue(DETAILS_DETAILS, "maxOcc", "50");
		robot.setPaneValue(DETAILS_DETAILS, "model", "sequence");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION,DETAILS_DETAILS);		
	}
	
	@Test
	public void testSchemaView_MG03_2(){
		
		robot.openFile(f_All_1);
		robot.xpathHighlight("/xs:schema/xs:complexType/xs:all");
		robot.setPaneValue(DETAILS_DETAILS, "maxOcc", "50");
		robot.selectFromItemContxtMenuInSchemaDiagram("Change Model","Sequence");
		robot.setPaneValue(DETAILS_DETAILS, "minOcc", "-1");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION,DETAILS_DETAILS);		
	}
	
	@Test
	public void testSchemaView_MG03_3(){
		
		robot.openFile(f_All_1);
		robot.xpathHighlight("/xs:schema/xs:complexType/xs:all");
		robot.setPaneValue(DETAILS_DETAILS, "maxOcc", "50");
		robot.setPaneValue(DETAILS_DETAILS, "model", "sequence");
		robot.setPaneValue(DETAILS_DETAILS, "minOcc", "51");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION,DETAILS_DETAILS);		
	}
	
	
	@Test
	public void testSchemaView_MG03_4(){
		
		robot.openFile(f_All_1);
		robot.xpathHighlight("/xs:schema/xs:complexType/xs:all");
		robot.setPaneValue(DETAILS_DETAILS, "maxOcc", "50");
		robot.setPaneValue(DETAILS_DETAILS, "model", "sequence");
		robot.setPaneValue(DETAILS_DETAILS, "minOcc", "51");
		robot.setPaneValue(DETAILS_DETAILS, "maxOcc", "51");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION,DETAILS_DETAILS);		
	}
	
	@Test
	public void testSchemaView_MG04_1(){
		
		robot.openFile(f_Sequence_1);
		robot.xpathHighlight("/xs:schema/xs:complexType/xs:sequence");
		robot.selectFromItemContxtMenuInSchemaDiagram("Change Model","All");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION,DETAILS_DETAILS);		
	}
	
	@Test
	public void testSchemaView_MG04_2(){
		
		robot.openFile(f_Sequence_1);
		robot.xpathHighlight("/xs:schema/xs:complexType/xs:sequence");
		robot.setPaneValue(DETAILS_DETAILS, "model", "all");
		robot.setPaneValue(DETAILS_DETAILS, "minOcc", "0");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION,DETAILS_DETAILS);		
	}
	
	@Test
	public void testSchemaView_MG04_3(){
		
		robot.openFile(f_Sequence_1);
		robot.xpathHighlight("/xs:schema/xs:complexType/xs:sequence");
		robot.setPaneValue(DETAILS_DETAILS, "model", "all");
		robot.setPaneValue(DETAILS_DETAILS, "minOcc", "0");
		robot.setPaneValue(DETAILS_DETAILS, "maxOcc", "1");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION,DETAILS_DETAILS);		
	}
	
	@Test
	public void testSchemaView_MG05_1(){
		
		robot.openFile(f_Choice_1);
		robot.xpathHighlight("/xs:schema/xs:complexType/xs:choice");
		robot.selectFromItemContxtMenuInSchemaDiagram("Change Model","All");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION,DETAILS_DETAILS);		
	}
	
	@Test
	public void testSchemaView_MG05_2(){
		
		robot.openFile(f_Choice_1);
		robot.xpathHighlight("/xs:schema/xs:complexType/xs:choice");
		robot.setPaneValue(DETAILS_DETAILS, "model", "all");
		robot.setPaneValue(DETAILS_DETAILS, "minOcc", "0");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION,DETAILS_DETAILS);		
	}
	
	@Test
	public void testSchemaView_MG05_3(){
		
		robot.openFile(f_Choice_1);
		robot.xpathHighlight("/xs:schema/xs:complexType/xs:choice");
		robot.setPaneValue(DETAILS_DETAILS, "model", "all");
		robot.setPaneValue(DETAILS_DETAILS, "minOcc", "0");
		robot.setPaneValue(DETAILS_DETAILS, "maxOcc", "1");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION,DETAILS_DETAILS);		
	}
	
	@Test
	public void testSchemaView_DV_TTP34509_1(){
		robot.openFile(TTP34509_XSD_FILE);
		assertAreas(VALIDATION,DETAILS_DETAILS); //it should be valid #34509
	}
	
	@Test
	public void testSchemaView_DV_TTP34509_2(){
		robot.openFile(TTP34509_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:element[@name='elem_qname']");
		robot.setPaneValue(DETAILS_DETAILS, "fixed", "tgt:a");
		robot.setPaneValue(DETAILS_DETAILS,"default","test:b");
		robot.xpathHighlight("/xs:schema/xs:element[@name='elem_notation']");
		robot.setPaneValue(DETAILS_DETAILS, "fixed", "tgt:a");
		robot.setPaneValue(DETAILS_DETAILS,"default","test:b");
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_DV_TTP34509_3(){
		robot.openFile(TTP34509_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:element[@name='elem_qname']");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "test:b");
		robot.xpathHighlight("/xs:schema/xs:element[@name='elem_notation']");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "test:c");
		robot.validate();
		assertAreas(VALIDATION,FACETS_SAMPLES); //it should be valid #34509
	}
}
