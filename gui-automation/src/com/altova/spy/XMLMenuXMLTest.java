package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.*;
import static java.awt.event.KeyEvent.*;


import java.awt.Rectangle;

import static com.altova.spy.SpyRobot.*;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.util.AltovaJUnitRunner.TestRobot;

//@TestRobot(VSnetSpyRobot.class)
//@TestRobot(EclipseSpyRobot.class)
public class XMLMenuXMLTest extends AbstractXmlSpyTest{

	
	
	private static final String attname = "xsi:type";
	private static final String AttPath = "/OrgChart/@xsi:schemaLocation";
	private static final String attdesc = "http:\\www.altova.com";
	private static final String ElemPath = "/OrgChart/Name";
	private static final String elemname = "Founders";
	private static final String elemdesc = "Thomas Kefer and Alexander Falk";
	private static final String instext = "This test checks how good is Spy in inserting Text";
	private static final String apptext = "test";
	private static final String cdata = "This text will be just displayed but not parsed";
	private static final String comment = " edited with XML Spy v4";
	private static final String newcomment= "This is a comment";
	private static final String xmlpath = "/OrgChart";
	private static final String extId = "Ext.ID";
	private static final String extIddesc = "13";
	private static final String new_procinst = "test";
	private static final String procinst_desc = "This is a processing instruction";
	private static final String elnamedtd = "place";
	private static final String attdtd = null;
	private static final String entnamedtd = "new_entity";
	private static final String notnamedtd = "new_notation";
	private static final String doctypedesc = "Internal_DTD_declaration";
	private static final String Office1Path = "/OrgChart/Office[1]";
	private static final String TablePath = Office1Path+"/Name";
	private static final String TablePathLocation = Office1Path+"/Department[1]/Name";
	private static final String subtext = "The company has been expanding rapidly ever since.";
	private static final String filenameToInclude="SampleFileToInclude.xml";
	
	
	public void selectWithFind(String selection){
		robot.gridView();
		robot.find(selection);
	}
	
	public void selectColumn(String path) {
		robot.textView();
		robot.xpathHighlight(path);
		robot.gridView();
		robot.keyType(VK_UP);
	}
	

	@Test
	public void testXMLInsertAttribute() {
		
		robot.gridView();
		robot.xpathHighlight(AttPath);
		robot.XMLInsertAttribute(attname,attdesc);
		robot.textView();
		robot.delay(2000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		robot.xpathHighlight("/OrgChart/@"+attname);//selection is lost
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLInsertElement() {
		
		robot.gridView();
		robot.xpathHighlight(ElemPath);
		robot.XMLInsertElement(elemname,elemdesc);
		robot.textView();
		robot.delay(4000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		robot.xpathHighlight("/OrgChart/"+elemname);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLInsertText() {
		
		robot.gridView();
		robot.xpathHighlight(ElemPath);
		robot.XMLInsertText(instext);
		robot.textView();
		robot.delay(2000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		robot.xpathHighlight("/OrgChart/text()");
		robot.NextLineXPath();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLInsertCData() {
		
		robot.gridView();
		robot.xpathHighlight(ElemPath);
		robot.XMLInsertCData(cdata);
		robot.textView();
		robot.delay(2000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		robot.xpathHighlight(ElemPath);
		robot.NextLineXPath();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLInsertComment() {
		
		selectWithFind(comment);
		robot.XMLInsertComment(newcomment);
		robot.textView();
		robot.browserView();
		robot.delay(1000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLInsertXml() {
		
		robot.gridView();
		robot.xpathHighlight(xmlpath);
		robot.XMLInsertXml();
		robot.browserView();
		robot.delay(2000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testXMLInsertProcInstr() {
		
		robot.gridView();
		robot.find("Orgchart.sps");
		robot.XMLInsertProcInstruct(new_procinst,procinst_desc);
		robot.textView();
		robot.browserView();
		robot.delay(2000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testXMLInsertXInclude() {
		
		robot.gridView();
		robot.xpathHighlight(xmlpath);
		robot.XMLInsertXInclude(filenameToInclude);
		robot.browserView();//not possible as the file is not valid
		robot.delay(2000);
		robot.authenticView();
		robot.delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	public void testXMLInsertDoctype() {
		
		selectWithFind(comment);
		robot.XMLInsertDoctype(doctypedesc);
		robot.browserView();
		robot.delay(2000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLInsertExternalId() {
	
		selectWithFind(comment);
		robot.XMLInsertDoctype(doctypedesc);
		robot.XMLAddChildText("text");
		robot.XMLInsertExternalId(extId, extIddesc);
		robot.browserView();
		robot.delay(2000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
		
	}
	
	@Test
	public void testXMLAppendAttribute() {
		
		robot.gridView();
		robot.xpathHighlight(AttPath);
		robot.XMLAppendAttribute(attname,attdesc);
		robot.textView();
		robot.delay(2000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		robot.xpathHighlight("/OrgChart/@"+attname);//selection is lost
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLAppendElement() {
		
		robot.gridView();
		robot.xpathHighlight(ElemPath);
		robot.XMLAppendElement(elemname,elemdesc);
		robot.textView();
		robot.delay(3000);
		robot.authenticView();
		delay(2000);	//selection is lost
		robot.gridView();
		robot.xpathHighlight("/OrgChart/"+elemname);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLAppendText() {
		
		robot.gridView();
		robot.xpathHighlight(ElemPath);
		robot.XMLAppendText(apptext);
		robot.textView();
		robot.delay(2000);
		robot.authenticView();
		delay(2000);
		robot.gridView();//selection is lost
		robot.xpathHighlight("/OrgChart/text()");
		robot.NextLineXPath();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLAppendCData() {
		
		robot.gridView();
		robot.xpathHighlight(ElemPath);
		robot.XMLAppendCData(cdata);
		robot.textView();
		robot.delay(2000);
		robot.authenticView();
		delay(2000);
		robot.gridView();//selection is lost
		robot.xpathHighlight(ElemPath);
		robot.NextLineXPath();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLAppendComment() {
		
		selectWithFind(comment);
		robot.XMLAppendComment(newcomment);
		robot.textView();
		robot.browserView();
		robot.delay(2000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLAppendXml() {
		
		robot.gridView();
		robot.xpathHighlight(xmlpath);
		robot.XMLAppendXml();
		robot.browserView();
		robot.delay(2000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLAppendProcInstr() {
		
		robot.gridView();
		robot.find("Orgchart.sps");
		robot.XMLAppendProcInstruct(new_procinst,procinst_desc);
		robot.textView();
		robot.browserView();
		robot.delay(2000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testXMLAppendXInclude() {
		
		robot.gridView();
		robot.xpathHighlight(xmlpath);
		robot.XMLAppendXInclude(filenameToInclude);
		robot.textView();
		robot.browserView();//does not actually change views
		robot.delay(2000);
//		robot.authenticView();//selection and info gets lost
//		delay(2000);
		robot.gridView();//does not actually change views
		delay(4000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testXMLAppendDoctype() {
		
		selectWithFind(comment);
		robot.XMLAppendDoctype(null);
		robot.browserView();
		robot.delay(2000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLAppendExternalId() {
		
		selectWithFind(comment);
		robot.XMLInsertDoctype(doctypedesc);
		robot.XMLAddChildText("here");
		robot.XMLAppendExternalId(extId, extIddesc);
		robot.browserView();
		robot.delay(2000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testXMLAddChildAttribute() {
		
		robot.gridView();
		robot.xpathHighlight(ElemPath);
		robot.XMLAddChildAttribute(attname,attdesc);
		robot.textView();
		robot.delay(2000);
		robot.authenticView();//selection is lost=>failing at the moment
		delay(2000);
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Name/@xsi:type");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testXMLAddChildElement() {
		
		robot.gridView();
		robot.xpathHighlight(ElemPath);
		robot.XMLAddChildElement(elemname,elemdesc);
		robot.textView();
		robot.delay(2000);
		robot.authenticView(); //selection is lost=> failing at the moment
		delay(2000);
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Name/"+elemname);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLAddChildText() {
		
		robot.gridView();
		robot.xpathHighlight(ElemPath);
		robot.XMLAddChildText(apptext);
		robot.textView();
		robot.delay(2000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		robot.xpathHighlight("/OrgChart/"+apptext);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLAddChildCData() {
		
		robot.gridView();
		robot.xpathHighlight(ElemPath);
		robot.XMLAddChildCData(cdata);
		robot.delay(2000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLAddChildComment() {
		
		robot.gridView();
		robot.xpathHighlight(ElemPath);
		robot.XMLAddChildComment(newcomment);
		robot.textView();
		robot.delay(2000);
		robot.authenticView(); //changes to other views than text view loses selection
		delay(2000);
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Name/comment()");
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	public void testXMLAddChildXml() {
		
		robot.gridView();
		robot.selectAll();
		robot.delete();
		robot.XMLAddChildXml();
		robot.browserView();//it is not possible to change to browser view, but we check it does not crash
		delay(1000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLAddChildProcInstr() {
		
		robot.gridView();
		robot.xpathHighlight(xmlpath);
		robot.XMLAddChildProcInstruct(new_procinst,procinst_desc);
		robot.browserView();
		robot.delay(4000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testXMLAddChildXInclude() {
		
		robot.gridView();
		robot.xpathHighlight(xmlpath);
		robot.XMLAddChildXInclude(filenameToInclude);
		robot.textView();
		robot.delay(500);
		robot.authenticView();
		delay(2000);
		robot.browserView();
		robot.delay(2000);
		robot.gridView();
		robot.xpathHighlight("/OrgChart/xi:include");
		robot.expandGrid();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testXMLAddChildDoctype() {
		
		robot.gridView();
		robot.selectAll();
		robot.delete();
		robot.XMLAddChildDoctype(null);
		robot.browserView();//it is not possible to change to browser view, but we check it does not crash
		robot.delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
				
	}

	@Test
	public void testXMLAddChildExternalId() {
		
		selectWithFind(comment);
		robot.XMLInsertDoctype("OrgChart");
		robot.XMLAddChildExternalId("SYSTEM", "\"OrgChart.dtd\"");
		robot.browserView();
		delay(2000);
		robot.authenticView();
		robot.delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testXMLAddChildElementInDTD() {
		
		selectWithFind(comment);
		robot.XMLInsertDoctype(doctypedesc);
		robot.XMLAddChildElementInDTD(elnamedtd);
		robot.browserView();
		robot.delay(2000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testXMLAddChildAttlistInDTD() {
		
		selectWithFind(comment);
		robot.XMLInsertDoctype(doctypedesc);
		robot.XMLAddChildAttListInDTD(attdtd);
		robot.browserView();
		delay(2000);
		robot.authenticView(); //change to authentic view, and then browser view loses the selection
		robot.delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testXMLAddChildEntityInDTD() {
		
		selectWithFind(comment);
		robot.XMLInsertDoctype(doctypedesc);
		robot.XMLAddChildEntityInDTD(entnamedtd,null);
		robot.authenticView();
		robot.delay(2000);
		robot.browserView();
		robot.delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testXMLAddChildNotationInDTD() {
		
		selectWithFind(comment);
		robot.XMLInsertDoctype(doctypedesc);
		robot.XMLAddChildNotationInDTD(notnamedtd,null);
		robot.browserView();
		delay(2000);
		robot.authenticView();
		robot.delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

		
	@Test
	public void testXMLConvertToAttribute() {
		
		robot.gridView();
		robot.xpathHighlight(ElemPath);
		robot.XMLConvertToAttribute();
		robot.textView();
		robot.browserView();
		delay(2000);
		robot.authenticView();
		robot.delay(4000);
		robot.gridView();
		robot.xpathHighlight(xmlpath+"/@Name");
		robot.NextLineXPath();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testXMLConvertToElement() {
		
		robot.gridView();
		robot.xpathHighlight(AttPath);
		robot.XMLConvertToElement();
		robot.browserView();
		delay(2000);
		robot.authenticView();
		robot.delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLConvertToText() {
		
		robot.gridView();
		robot.xpathHighlight(ElemPath);
		robot.XMLConvertToText();
		robot.escapeGeneralDialogs("Waiting while escaping warning convert dialog");
		robot.browserView();
		delay(2000);
		robot.authenticView();
		robot.delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLConvertToCData() {
		
		robot.gridView();
		robot.xpathHighlight(ElemPath);
		robot.XMLConvertToCData();
		robot.escapeGeneralDialogs("Waiting while escaping warning convert dialog");
		robot.browserView();
		delay(2000);
		robot.authenticView();
		robot.delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLConvertToComment() {
		
		robot.gridView();
		robot.xpathHighlight(ElemPath);
		robot.XMLConvertToComment();
		robot.escapeGeneralDialogs("Waiting while escaping warning convert dialog");
		robot.browserView();
		delay(2000);
		robot.authenticView();
		robot.delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	public void testXMLConvertToXml() {
		
		selectWithFind(comment);
		robot.XMLConvertToXml();
		robot.keyType(VK_ENTER);
		robot.escapeGeneralDialogs("Waiting while escaping warning convert dialog");
		robot.browserView();
		delay(4000);
		robot.authenticView();
		robot.delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testXMLConvertToDoctype() {
				
		robot.gridView();
		robot.find("Orgchart.sps");
		robot.XMLConvertToDoctype();
		robot.keyType(VK_ENTER);
		robot.escapeGeneralDialogs("Waiting while escaping warning convert dialog");
		robot.browserView();
		delay(1000);
		robot.authenticView();
		robot.delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
				
	}

	@Test
	public void testXMLConvertToExternalId() {
		
		selectWithFind(comment);
		robot.XMLInsertDoctype(doctypedesc);
		robot.XMLAddChildComment(null);
		robot.XMLConvertToExternalId();
		robot.browserView();
		delay(4000);
		robot.authenticView();
		robot.delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testDisplayAsTable() {
		
		robot.gridView();
		robot.xpathHighlight(ElemPath);
		robot.XMLDisplayAsTable();
		robot.expandGrid();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testTableInsertRow() {
		
		robot.gridView();
		robot.xpathHighlight(TablePath);
		robot.XMLTableInsertRow();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testTableAppendRow() {
		
		robot.gridView();
		robot.xpathHighlight(TablePath);
		robot.XMLTableAppendRow();
		robot.authenticView();
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void testXMLTableAscendingSort() {
		
		selectColumn(TablePathLocation);
		robot.XMLTableAscendingSort();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testXMLTableDescendingSort() {
		
		selectColumn(TablePathLocation);
		robot.XMLTableDescendingSort();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testXMLMoveLeft() {
		
		selectColumn(Office1Path);
		robot.XMLMoveLeft();
		robot.authenticView();
		robot.delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testXMLMoveRight() {
		
		selectColumn(Office1Path);
		robot.XMLMoveRight();
		robot.browserView();
		robot.delay(1000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testXMLEncloseInElement() {
        robot.textView();
		robot.find(subtext);
		robot.gridView();
		robot.XMLEncloseInElement("bold");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	
	@Test
	public void testXMLEvaluateXPath() {
		robot.xpathEvaluation(xmlpath);
		robot.XMLEvaluateXPath();
		assertAreas(XPATH);
	}

	@Test
	public void testXMLCheckWellFormedness() {

		robot.gridView();
		robot.XMLCheckWellFormedness();
	    assertAreas(VALIDATION);
	}
	
	@Test
	public void testXMLValidation() {

		robot.gridView();
		robot.validate();
	    assertAreas(VALIDATION);
	}
	
	@Test
	public void testUpdateEntryHelpers() {

		robot.gridView();
		robot.xpathHighlight(ElemPath);
		robot.XMLInsertElement(elemname,elemdesc);
		robot.updateEntryHelpers();
	    assertAreas(ELEMENTS,ENTITIES,ATTRIBUTES);
	}
	
	@Test
	public void testNamespacePrefix() {

		robot.gridView();
		robot.xpathHighlight(xmlpath);
		robot.namespacePrefix("altova");
	    assertAreas(DIAGRAM_MAIN_WINDOW);
	   
	}
	
	

}
