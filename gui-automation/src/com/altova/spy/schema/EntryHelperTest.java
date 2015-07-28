package com.altova.spy.schema;

import static com.altova.spy.SpyRobot.*;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import java.awt.event.KeyEvent;
import java.io.File;


import org.junit.Test;

import com.altova.spy.AbstractXmlSpyTest;
import com.altova.spy.SpyRobot;


/**
 * Schema View Test Cases - Entry Helpers
 * 
 * @author Phelim McConigly
 */
public class EntryHelperTest extends AbstractXmlSpyTest {

//	private static File fSimpleElement = IOUtils.findFile("Details/SimpleElement.xsd");
	static String testDir = "S:/QA/Internal/Test-Cases/XMLSpy/SchemaView/GUI/Entry Helpers/" ;
	private static File fSimpleElement = new File(testDir + "Details/SimpleElement.xsd");
	private static File fSimpleElement_decimal = new File(testDir + "Details/SimpleElement_decimal.xsd");
	private static File fSimpleElement_decimal_1 = new File(testDir + "Details/SimpleElement_decimal_1.xsd");
	private static File fSimpleElement_decimal_3 = new File(testDir + "Details/SimpleElement_decimal_3.xsd");
	private static File fSimpleElement_Group = new File(testDir + "Details/SimpleElement_Group.xsd");
	private static File fSimpleElement_NormalizedString = new File(testDir + "Details/SimpleElement_NormalizedString.xsd");
	private static File ttp16885=new File(testDir+"Facets/TTP16885_InvalidFacet.xsd");
	private static String myElementPath= "/xs:schema/xs:element[@name=\'MyElement\']";
	private static String myElement2Path="/xs:schema/xs:element[@name=\'MyElement2\']";
		
	/*
	 * Steps
	 * **********************************************************************************************			
		1	derivedBy = "restriction"	validate											VALID
		2	content = "complex"	validate; derivedBy changes to extension					VALID
		3	switch to textview 	change xs:extension to xs:restriction						INVALID
		4	switch to schemaview		"derivedBy = ""restriction"" colored red validate = INVALID"
	 */
	@Test
	public void testSchemaView_EH1_1() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS, "derivedBy", "restriction");
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS);
		
	}
	
	@Test
	public void testSchemaView_EH1_2() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS, "derivedBy", "restriction");
		
		robot.setPaneValue(DETAILS, "content", "complex");
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_EH1_3() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS, "derivedBy", "restriction");
		
		robot.setPaneValue(DETAILS, "content", "complex");
		
		robot.textView();
		robot.findHighlight("xs:extension");
		robot.typeString("xs:restriction");
		robot.validate();
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
	}
	
		@Test
		public void testSchemaView_EH1_4() {
		
		robot.openFile(fSimpleElement);	
		robot.setPaneValue(DETAILS, "content", "complex");
			
		robot.textView();
		robot.findHighlight("xs:extension");
		robot.typeString("xs:restriction");
		robot.schemaView();
		robot.validate();
		assertAreas(DETAILS,VALIDATION);
	}
	/*
	 * Steps			
	 * **********************************************************************************************
		1	derivedBy = "list"	validate						VALID entry helpers: Patterns and Enumerations are gone; Facets is empty"
		2	derivedBy = "union"	validate						VALID 
																	Patterns & Enumerations & Facets behave as changing to list
																	type value is emptied"
		3	click Tab SimpleType	union > restr > xs:string	VALID facets, Patterns and Enumerations are shown again"
		4	change restr to "xs:NOTATION"	validate			INVALID xs:NOTATION = red"
	 */
	@Test
	public void testSchemaView_EH2_1() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS, "derivedBy", "list");
		robot.validate();
		assertAreas(SpyRobot.VALIDATION,FACETS);
		
	}

	@Test
	public void testSchemaView_EH2_2() {
		
		robot.openFile(fSimpleElement);
		
		robot.setPaneValue(DETAILS, "derivedBy", "union");
		robot.validate();
		assertAreas(SpyRobot.VALIDATION,FACETS,DETAILS);
		
	}
	
	@Test
	public void testSchemaView_EH2_3() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS, "derivedBy", "union");
		robot.setPaneValue(DETAILS_SIMPLE_TYPE, "restr", "xs:string");
		assertAreas("testSchemaView_EH2_3_facets_facets",FACETS_FACETS);
		assertAreas("testSchemaView_EH2_3_facets_patterns",FACETS_PATTERNS);
		assertAreas("testSchemaView_EH2_3_facets_enumerations",FACETS_ENUMERATIONS);
		robot.validate();
		assertAreas(SpyRobot.VALIDATION);
		
	}
	
	@Test
	public void testSchemaView_EH2_4() {	
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS, "derivedBy", "union");
		robot.setPaneValue(DETAILS_SIMPLE_TYPE, "restr", "xs:NOTATION");
		robot.validate();
		assertAreas(DETAILS_SIMPLE_TYPE,VALIDATION);
		
	}
	/*
	 * Steps												Expected behavior
	 * ******************************************************************************************
		1	derivedBy = "union"		"type = emptied	tab ""SimpleType"" union > restr > xs:string"
		2	change restr to xs:NOTATION	validate			INVALID (Err204)
		3	"click restr xs:NOTATION 
			Facets > Enumeration 
			add enumeration > do not type any value"
			validate										INVALID (Err049)
		4	type any value eg "test" as enumeration value	validate	INVALID (Err049)
	 */
	@Test
	public void testSchemaView_EH3_1() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS_DETAILS, "derivedBy", "union");
		robot.setPaneValue(DETAILS_SIMPLE_TYPE, "restr", "xs:NOTATION");
		robot.xpathHighlight("/xs:schema/xs:element/xs:simpleType/xs:union");
		delay(500);
		robot.keyType(KeyEvent.VK_DOWN);
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS,null) ;
		assertAreas(FACETS_ENUMERATIONS);
		robot.validate();
		assertAreas(VALIDATION);
	}
	
	@Test
	public void testSchemaView_EH3_2() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS_DETAILS, "derivedBy", "union");
		robot.setPaneValue(DETAILS_SIMPLE_TYPE, "restr", "xs:NOTATION");
		robot.xpathHighlight("/xs:schema/xs:element/xs:simpleType/xs:union");
		delay(500);
		robot.keyType(KeyEvent.VK_DOWN);
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS,"test") ; ;
		assertAreas(FACETS_ENUMERATIONS);
		robot.validate();
		assertAreas(VALIDATION);
	}
	
	/*
	 * Steps															Expected behavior
	 * ******************************************************************************************
		1	"change derivedBy to union	
			change restr-type to xs:positiveInteger
			add enumeration > let value empty"	
			validate													INVALID (Err049)
		2	change enumeration to -5	validate						-5 is colored red INVALID (Err049)"
		3	change enumeration to 'test'	validate					test is colored red INVALID (Err049)"
		4	"change restr-type to xs:string	add enumeration ""test"""	validate	"VALID	test is colored blue"
	 */
	@Test
	public void testSchemaView_EH4_1() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS_DETAILS, "derivedBy", "union");
		robot.setPaneValue(DETAILS_SIMPLE_TYPE, "restr", "xs:positiveInteger");
		robot.xpathHighlight("/xs:schema/xs:element/xs:simpleType/xs:union");
		delay(500);
		robot.keyType(KeyEvent.VK_DOWN);
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS,null);
		assertAreas(FACETS_ENUMERATIONS);
		robot.validate();
		assertAreas(VALIDATION);
	}	
		
		@Test
		public void testSchemaView_EH4_2() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS_DETAILS, "derivedBy", "union");
		robot.setPaneValue(DETAILS_SIMPLE_TYPE, "restr", "xs:positiveInteger");
		robot.xpathHighlight("/xs:schema/xs:element/xs:simpleType/xs:union");
		delay(500);
		robot.keyType(KeyEvent.VK_DOWN);
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS,"-5") ;
		assertAreas(FACETS_ENUMERATIONS);
		robot.validate();
		assertAreas(VALIDATION);
	 }
		
		@Test
		public void testSchemaView_EH4_3() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS_DETAILS, "derivedBy", "union");
		robot.setPaneValue(DETAILS_SIMPLE_TYPE, "restr", "xs:positiveInteger");
		robot.xpathHighlight("/xs:schema/xs:element/xs:simpleType/xs:union");
		delay(500);
		robot.keyType(KeyEvent.VK_DOWN);
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS,"test") ;
		assertAreas(FACETS_ENUMERATIONS);
		robot.validate();
		assertAreas(VALIDATION);
	 }
		

		@Test
		public void testSchemaView_EH4_4() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS_DETAILS, "derivedBy", "union");
		robot.setPaneValue(DETAILS_SIMPLE_TYPE, "restr", "xs:string");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS,"test") ;
		assertAreas(FACETS_ENUMERATIONS);
		robot.validate();
		assertAreas(VALIDATION);
	 }
		
	
	/*
	 * Steps								Expected behavior
	 * ******************************************************************************
		1	"change type > xs:long Facets: minIncl = -55555"	validate	"> value is colored blue VALID"
		2	maxIncl=55555	validate	"VALID value is colored blue"
		3	maxExcl = -55556		minIncl and maxExcl colored red
		4	delete minIncl-value	validate	VALID
	 */
	@Test
	public void testSchemaView_EH5_1() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS_DETAILS, "type", "xs:long");
		robot.setPaneValue(FACETS_FACETS, "minIncl", "-55555");
		robot.validate();	
		assertAreas(VALIDATION,FACETS_FACETS);
	}
	
	@Test
	public void testSchemaView_EH5_2() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS_DETAILS, "type", "xs:long");
		robot.setPaneValue(FACETS_FACETS, "minIncl", "-55555");
		robot.setPaneValue(FACETS_FACETS, "maxIncl", "55555");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS);
	}
	
	@Test
	public void testSchemaView_EH5_3() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS_DETAILS, "type", "xs:long");
		robot.setPaneValue(FACETS_FACETS, "minIncl", "-55555");
		robot.setPaneValue(FACETS_FACETS, "maxIncl", "55555");
		robot.setPaneValue(FACETS_FACETS, "maxExcl", "-55556");	
		
		robot.validate();		
		
		assertAreas(VALIDATION,FACETS_FACETS);
	}
	@Test
	public void testSchemaView_EH5_4() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS_DETAILS, "type", "xs:long");
		robot.setPaneValue(FACETS_FACETS, "maxIncl", "55555");
		robot.setPaneValue(FACETS_FACETS, "maxExcl", "-55556");	
		
		robot.validate();		
		
		assertAreas(VALIDATION,FACETS_FACETS);
	}
	
	/*
	 * Steps			Expected behavior
	 * ******************************************************************************* 
		1	"change type > xs:long 	maxIncl=55555"	validate	"> value is colored blue VALID"
		2	minExcl = -55556	validate	VALID
		3	maxExcl=55555	validate	INVALID > maxInxl and MaxExcl colored red
		4	delete maxIncl 	validate 	VALID
	 */
	@Test
	public void testSchemaView_EH6_1() {
		
		robot.openFile(fSimpleElement);
		
		robot.setPaneValue(DETAILS_DETAILS, "type", "xs:long");
		robot.setPaneValue(FACETS_FACETS, "maxIncl", "55555");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS);
	}
	
	@Test
	public void testSchemaView_EH6_2() {
		
		robot.openFile(fSimpleElement);
		
		robot.setPaneValue(DETAILS_DETAILS, "type", "xs:long");
		robot.setPaneValue(FACETS_FACETS, "maxIncl", "55555");
		robot.setPaneValue(FACETS_FACETS, "minExcl", "-55556");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS);
	}
	
	@Test
	public void testSchemaView_EH6_3() {
		
		robot.openFile(fSimpleElement);
		
		robot.setPaneValue(DETAILS_DETAILS, "type", "xs:long");
		robot.setPaneValue(FACETS_FACETS, "maxIncl", "55555");
		robot.setPaneValue(FACETS_FACETS, "minExcl", "-55556");
		robot.setPaneValue(FACETS_FACETS, "maxExcl", "55555");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS);
	}
		
		
	@Test
	public void testSchemaView_EH6_4() {
		
		robot.openFile(fSimpleElement);
		
		robot.setPaneValue(DETAILS_DETAILS, "type", "xs:long");
		robot.setPaneValue(FACETS_FACETS, "minExcl", "-55556");
		robot.setPaneValue(FACETS_FACETS, "maxExcl", "55555");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS);
	}
		
	/*
	 * Steps			Expected behavior
	 * 	*******************************************************************
		1	"change type > xs:long 	minIncl= -55555 maxExcl = 55556"	validate	"> values is colored blue VALID"
		2	default = 55556		"colored red INVALID"
		3	fixed = 55556		"default value deleted	fixed value colored red INVALID"
		4	fixed = +55555		VALID, blue
		5	fixed = 00000000000055555		VALID, blue
	 */
	@Test
	public void testSchemaView_EH7_1() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS_DETAILS, "type", "xs:long");
		robot.setPaneValue(FACETS_FACETS, "minIncl", "-55555");
		robot.setPaneValue(FACETS_FACETS, "maxExcl", "55556");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS);
	}
	
	@Test
	public void testSchemaView_EH7_2() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS_DETAILS, "type", "xs:long");
		robot.setPaneValue(FACETS_FACETS, "minIncl", "-55555");
		robot.setPaneValue(FACETS_FACETS, "maxExcl", "55556");
		robot.setPaneValue(DETAILS_DETAILS, "default", "55556");
		robot.validate();
		assertAreas(VALIDATION,DETAILS);
	}	
	
	@Test
	public void testSchemaView_EH7_3() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS_DETAILS, "type", "xs:long");
		robot.setPaneValue(FACETS_FACETS, "minIncl", "-55555");
		robot.setPaneValue(FACETS_FACETS, "maxExcl", "55556");
		robot.setPaneValue(DETAILS_DETAILS, "default", "55556");
		robot.setPaneValue(DETAILS_DETAILS, "fixed", "55556");
		robot.validate();
		assertAreas(VALIDATION,DETAILS);
	}	
		
	@Test
	public void testSchemaView_EH7_4() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS_DETAILS, "type", "xs:long");
		robot.setPaneValue(FACETS_FACETS, "minIncl", "-55555");
		robot.setPaneValue(FACETS_FACETS, "maxExcl", "55556");
		robot.setPaneValue(DETAILS_DETAILS, "default", "55556");
		robot.setPaneValue(DETAILS_DETAILS, "fixed", "+55555");
		robot.validate();
		assertAreas(VALIDATION,DETAILS);
	}
	
	@Test
	public void testSchemaView_EH7_5() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(DETAILS_DETAILS, "type", "xs:long");
		robot.setPaneValue(FACETS_FACETS, "minIncl", "-55555");
		robot.setPaneValue(FACETS_FACETS, "maxExcl", "55556");
		robot.setPaneValue(DETAILS_DETAILS, "default", "55556");
		robot.setPaneValue(DETAILS_DETAILS, "fixed", "00000000000055555");
		robot.validate();
		assertAreas(VALIDATION,DETAILS);
	}
		
	
	/*
	 * Steps								Expected behavior
	 * *******************************************************************
		1	length=10						"Details / type = colored blue Facets / length =colored  blue derivedBy=restriction"
		2	default="test1234567"			default > facets length=10	default colored red
		3	fixed="test1234567"				fixed > facets length=10	fixed colored red
		4	length=11						"type,  length colored blue	fixed colored black"
		5	minLen=11						"lnegth && minLen colored red INVALID (Err93)"
	 */
	@Test
	public void testSchemaView_EH8_1() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(FACETS_FACETS, "length", "10");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS,DETAILS);
	}
	@Test
	public void testSchemaView_EH8_2() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(FACETS_FACETS, "length", "10");
		robot.setPaneValue(DETAILS_DETAILS, "default", "test1234567");
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_EH8_3() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(FACETS_FACETS, "length", "10");
		robot.setPaneValue(DETAILS_DETAILS, "default", "test1234567");
		robot.setPaneValue(DETAILS_DETAILS, "fixed", "test1234567");
		robot.validate();
		assertAreas(DETAILS_DETAILS,VALIDATION);
	}
		
	@Test
	public void testSchemaView_EH8_4() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(FACETS_FACETS, "length", "10");
		robot.setPaneValue(DETAILS_DETAILS, "default", "test1234567");
		robot.setPaneValue(DETAILS_DETAILS, "fixed", "test1234567");
		robot.setPaneValue(FACETS_FACETS, "length", "11");
		robot.validate();
		assertAreas(FACETS_FACETS,DETAILS_DETAILS,VALIDATION);
	}	

	@Test
	public void testSchemaView_EH8_5() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(FACETS_FACETS, "length", "10");
		robot.setPaneValue(DETAILS_DETAILS, "default", "test1234567");
		robot.setPaneValue(DETAILS_DETAILS, "fixed", "test1234567");
		robot.setPaneValue(FACETS_FACETS, "length", "11");
		robot.setPaneValue(FACETS_FACETS, "minLen", "11");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS,DETAILS_DETAILS);
	}	
		
	
	/*
	 * Steps									Expected behavior
	 * *******************************************************************************
		1	minLen=5 default=""test"""			default colored red (Err50)	minLen colored blue"
		2	default="test1"						default  colored black > VALID
		3	maxLen="4"							minLen && maxLen &&default  colored red (Err50)
		4	minLen="3"							minLen && maxLen colored blue default colored red"
		5	default="test"						VALID, default colored black
	 */
	@Test
	public void testSchemaView_EH9_1() {
		
		robot.openFile(fSimpleElement);		
		robot.setPaneValue(FACETS_FACETS, "minLen", "5");
		robot.setPaneValue(DETAILS_DETAILS, "default", "test");
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS,FACETS_FACETS);
	}	
		
	@Test
	public void testSchemaView_EH9_2() {
		
		robot.openFile(fSimpleElement);		
		robot.setPaneValue(FACETS_FACETS, "minLen", "5");
		robot.setPaneValue(DETAILS_DETAILS, "default", "test1");
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS,FACETS_FACETS);
	}
		
	@Test
	public void testSchemaView_EH9_3() {
		
		robot.openFile(fSimpleElement);		
		robot.setPaneValue(FACETS_FACETS, "minLen", "5");
		robot.setPaneValue(DETAILS_DETAILS, "default", "test1");
		robot.setPaneValue(FACETS_FACETS, "maxLen", "4");
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS,FACETS_FACETS);
	}
		
	@Test
	public void testSchemaView_EH9_4() {
		
		robot.openFile(fSimpleElement);		
		robot.setPaneValue(FACETS_FACETS, "minLen", "6");
		robot.setPaneValue(DETAILS_DETAILS, "default", "test1");
		robot.setPaneValue(FACETS_FACETS, "maxLen", "5");
		robot.setPaneValue(FACETS_FACETS, "minLen", "3");
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS,FACETS_FACETS);
	}
		
	@Test
	public void testSchemaView_EH9_5() {
		
		robot.openFile(fSimpleElement);		
		robot.setPaneValue(FACETS_FACETS, "minLen", "5");
		robot.setPaneValue(DETAILS_DETAILS, "default", "test");
		robot.setPaneValue(FACETS_FACETS, "maxLen", "4");
		robot.setPaneValue(FACETS_FACETS, "minLen", "3");
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS,FACETS_FACETS);
	}
		
	
	/*
	 * Steps				Expected behavior
	 * **************************************************************
		1	length="5"		type && length colored blue
		2	minLen="6"		length && minLen colored red
		3	"minLen=""""	maxLen=""6"""		length && maxLen colored red
		4	"length=""""	minLength=""3"""		minLen && maxLen colored blue	
	 */
	@Test
	public void testSchemaView_EH10_1() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(FACETS_FACETS, "length", "5");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_EH10_2() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(FACETS_FACETS, "length", "5");
		robot.setPaneValue(FACETS_FACETS, "minLen", "6");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS);
	}	
		
	@Test
	public void testSchemaView_EH10_3() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(FACETS_FACETS, "length", "5");
		robot.setPaneValue(FACETS_FACETS, "maxLen", "6");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS);
	}	
		
	@Test
	public void testSchemaView_EH10_4() {
		
		robot.openFile(fSimpleElement);
		robot.setPaneValue(FACETS_FACETS, "minLen", "3");
		robot.setPaneValue(FACETS_FACETS, "maxLen", "6");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS);
	}	

	
	/*
	 * Steps									Expected behavior
	 * *******************************************************************
		1	totalDig = "3", fracDig="2"			default = colored red
		2	totalDig = "4"						default colored black
		3	default="05.126"					VALID
		4	default="15.126"					default colored red
		5	default="5.1"						default = black VALID
	 */
	@Test
	public void testSchemaView_EH11_1() {
		
		robot.openFile(fSimpleElement_decimal);
		robot.setPaneValue(FACETS_FACETS, "totalDig", "3");
		robot.setPaneValue(FACETS_FACETS, "fracDig", "2");
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS,FACETS_FACETS);
	}
	
	@Test
	public void testSchemaView_EH11_2() {
		
		robot.openFile(fSimpleElement_decimal);
		robot.setPaneValue(FACETS_FACETS, "totalDig", "4");
		robot.setPaneValue(FACETS_FACETS, "fracDig", "3");
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS,FACETS_FACETS);
	}
		
	@Test
	public void testSchemaView_EH11_3() {
		 
		robot.openFile(fSimpleElement_decimal);
		robot.setPaneValue(FACETS_FACETS, "totalDig", "4");
		robot.setPaneValue(FACETS_FACETS, "fracDig", "3");
		robot.setPaneValue(DETAILS_DETAILS, "default", "05.126");
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS);
	}	

	@Test
	public void testSchemaView_EH11_4() {
		
		robot.openFile(fSimpleElement_decimal);
		robot.setPaneValue(FACETS_FACETS, "totalDig", "4");
		robot.setPaneValue(FACETS_FACETS, "fracDig", "3");
		robot.setPaneValue(DETAILS_DETAILS, "default", "15.126");
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS);
	}	
		
	@Test
	public void testSchemaView_EH11_5() {
		
		robot.openFile(fSimpleElement_decimal);
		robot.setPaneValue(FACETS_FACETS, "totalDig", "4");
		robot.setPaneValue(FACETS_FACETS, "fracDig", "2");
		robot.setPaneValue(DETAILS_DETAILS, "default", "5.1");
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS);
	}	
	
	
	
	/*
	 * Steps									Expected behavior
	 * *************************************************************************
		1	minExcl = 5							minExcl colored blue
		2	minExcl=5.111, macExcl=5.113		both colored blue
		3	fracDig = -1						fracDig colored red
		4	fracDig=0, maxIncl=7.5				all blue 
	 */
	@Test
	public void testSchemaView_EH12_1() {
		
		robot.openFile(fSimpleElement_decimal_1);
		
		robot.setPaneValue(FACETS_FACETS, "minExcl", "5");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS);
	}
	
	@Test
	public void testSchemaView_EH12_2() {
		
		robot.openFile(fSimpleElement_decimal_1);
		
		robot.setPaneValue(FACETS_FACETS, "minExcl", "5");
		robot.setPaneValue(FACETS_FACETS, "minExcl", "5.111");
		robot.setPaneValue(FACETS_FACETS, "maxExcl", "5.113");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS);
	}
	
	@Test
	public void testSchemaView_EH12_3() {
		
		robot.openFile(fSimpleElement_decimal_1);
		
		robot.setPaneValue(FACETS_FACETS, "minExcl", "5");
		robot.setPaneValue(FACETS_FACETS, "minExcl", "5.111");
		robot.setPaneValue(FACETS_FACETS, "maxExcl", "5.113");
		robot.setPaneValue(FACETS_FACETS, "fracDig", "-1");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS);
	}	
		
	@Test
	public void testSchemaView_EH12_4() {
		
		robot.openFile(fSimpleElement_decimal_1);
		
		robot.setPaneValue(FACETS_FACETS, "minExcl", "5");
		robot.setPaneValue(FACETS_FACETS, "minExcl", "5.111");
		robot.setPaneValue(FACETS_FACETS, "fracDig", "0");
		robot.setPaneValue(FACETS_FACETS, "maxIncl", "7.5");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS);
	}		
	
	/*
	 * Steps																Expected behavior
	 * ****************************************************************************************************
		1	substGrp="MyElement"		element MyElement in detailview		substGrp colored red
		2	substGrp="MyElement2"											substGrp colored black
		3	substGrp="MyElement"		element MyElement2 in detailview	substGrp in elements MyElement and MyElement2 are colored red
		4	substGrp="MyElement2"		element MyElement2 in detailview	substGrp in elements MyElement and MyElement2 are colored red
	 */
	@Test	
	public void testSchemaView_EH13_1() { 
		
		robot.openFile(fSimpleElement_Group);
		robot.xpathHighlight(myElementPath);
		robot.setPaneValue(DETAILS_DETAILS, "substGrp","MyElement");
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS);
		
	}	
	
	@Test	
	public void testSchemaView_EH13_2() { 
		
		robot.openFile(fSimpleElement_Group);
		robot.xpathHighlight(myElementPath);
		robot.setPaneValue(DETAILS_DETAILS, "substGrp","MyElement2");
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS);
		
	}
	
	@Test	
	public void testSchemaView_EH13_3() { 
		
		robot.openFile(fSimpleElement_Group);
		robot.xpathHighlight(myElementPath);
		robot.setPaneValue(DETAILS_DETAILS, "substGrp","MyElement2");
		robot.xpathHighlight(myElement2Path);
		robot.setPaneValue(DETAILS_DETAILS, "substGrp","MyElement");
		assertAreas(DETAILS_DETAILS);
		robot.validate();
		assertAreas(VALIDATION);
		robot.xpathHighlight(myElementPath);
		assertAreas(getTestName() + "_2",DETAILS_DETAILS);
		
	}
	
	@Test	
	public void testSchemaView_EH13_4() { 
		
		robot.openFile(fSimpleElement_Group);
		robot.xpathHighlight(myElementPath);
		robot.setPaneValue(DETAILS_DETAILS, "substGrp","MyElement2");
		robot.xpathHighlight(myElement2Path);
		robot.setPaneValue(DETAILS_DETAILS, "substGrp","MyElement2");
		assertAreas(DETAILS_DETAILS);
		robot.validate();
		assertAreas(VALIDATION);
		robot.xpathHighlight(myElementPath);
		assertAreas(getTestName() + "_2",DETAILS_DETAILS);
	}
	
	/*
	 * Steps				Expected behavior
	 * ******************************************
		1	id=1			id colored red
		2	id="id1"		id colored black
	 */
	@Test
	public void testSchemaView_EH14_1() {
		
		robot.openFile(fSimpleElement);	
		//workaround for this test....
		robot.activatePane(DETAILS_DETAILS);
		robot.keyType(KeyEvent.VK_END);
		robot.setPaneValue(DETAILS_DETAILS, "id", "1");
		
		robot.validate();
		assertAreas(VALIDATION,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_EH14_2() {
		
		robot.openFile(fSimpleElement);	
//		workaround for this test....
		robot.activatePane(DETAILS_DETAILS);
		robot.keyType(KeyEvent.VK_END);
		
		robot.setPaneValue(DETAILS_DETAILS, "id", "id1");
		assertAreas(DETAILS_DETAILS);
	}
		

	/*
	 * Steps									Expected behavior
	 * ********************************************************************************************
		1	"add enums:  1 500 99.99 hallo"		"1,500,99.99 colored blue hallo colored red"
		2	delete enumeration "hallo"			enums listed: 1, 500, 99.99
		3	"change to facets					fracDig=1"	
	 */
	@Test
	public void testSchemaView_EH15_1() {
		
		robot.openFile(fSimpleElement_decimal_3);
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS,"1");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS,"500");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS,"99.99");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS,"hallo");
		robot.validate();
		assertAreas(VALIDATION,FACETS_ENUMERATIONS);
	}
	
	@Test
	public void testSchemaView_EH15_2() {
		
		robot.openFile(fSimpleElement_decimal_3);
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS,"1");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS,"500");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS,"99.99");
		robot.validate();
		assertAreas(VALIDATION,FACETS_ENUMERATIONS);
	}
		
	@Test
	public void testSchemaView_EH15_3() {
		
		robot.openFile(fSimpleElement_decimal_3);
		robot.setPaneValue(FACETS_FACETS, "fracDig", "1");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS,"1");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS,"500");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS,"99.99");
		robot.validate();
		assertAreas(VALIDATION,FACETS_ENUMERATIONS);
	}	
	
	
	/*
	 * Steps																	Expected behavior
	 * ***********************************************************************************
		1							default namespace="replace"					VALID
		2	whiteSp="collapse"													whiteSp && type=colored blue
		3	whiteSp="preserve"													whiteSp colored red INVALID
	 */
	@Test
	public void testSchemaView_EH16_1() {
		
		robot.openFile(fSimpleElement_NormalizedString);		
		robot.setPaneValue(FACETS_FACETS, "whiteSp", "collapse");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS,DETAILS_DETAILS);
	}	
	
	@Test
	public void testSchemaView_EH16_2() {
		
		robot.openFile(fSimpleElement_NormalizedString);		
		robot.setPaneValue(FACETS_FACETS, "whiteSp", "preserve");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS);
	}	
	
	/*
	 * Steps																	Expected behavior
	 * ***********************************************************************************
		1	simpleType "s1" | type = "xs:string"					INVALID
		2	element "root" > facets 								values are red	and cannot be edited				
		3	ct1\element test										values are red and cannot be edited			
	 */
	@Test
	
	public void testSchemaView_EH17_1() {
		
		robot.openFile(ttp16885);
		robot.xpathHighlight("/xs:schema/xs:simpleType");
		robot.setPaneValue(DETAILS_SIMPLE_TYPE, "restr", "xs:string");
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.find("test");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS);
	}	
	
@Test
	
	public void testSchemaView_EH17_2() {
		
		robot.openFile(ttp16885);
		robot.xpathHighlight("/xs:schema/xs:simpleType");
		robot.setPaneValue(DETAILS_SIMPLE_TYPE, "restr", "xs:string");
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.find("number");
		robot.validate();
		assertAreas(VALIDATION,FACETS_FACETS);
	}	
}
