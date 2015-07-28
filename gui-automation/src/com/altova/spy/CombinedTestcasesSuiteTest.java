package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.spy.SpyRobot.MESSAGES;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Test;

import com.altova.util.IOUtils;
import com.altova.util.AltovaJUnitRunner.TestRobot;

//@TestRobot(EclipseSpyRobot.class)
public class CombinedTestcasesSuiteTest extends AbstractXmlSpyTest{

	private File DATE_XML_FILE      =IOUtils.findFile("spy/examples/Date.xml");
	private File DATE_XSD_FILE      =IOUtils.findFile("spy/examples/Date.xsd");
	private File ATTRIBUTE_VALID_XSD=IOUtils.findFile("spy/examples/attribute_valid.xsd");

	@Test
	public final void testUndoInsertElementTextView() {
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Name");
		robot.textView();
		robot.keyType(KeyEvent.VK_END);delay(500);
		robot.insertXMLElementTextView("New_element", "whatever");
		robot.undoKey();delay(500);
		robot.undoKey();delay(500);
		robot.undoKey();delay(500);
		robot.browserView();
		robot.delay(2000);
		robot.authenticView();
		robot.delay(2000);
		robot.textView();
		robot.gotoLine(1,1);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testUndoInsertElementGridView() {
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Name");
		robot.XMLInsertElement("elem_name", "elem_description");
		robot.undoKey();delay(500);
		robot.undoKey();delay(500);
		robot.undoKey();delay(500);
		robot.undoKey();delay(500);
		robot.authenticView();
		robot.textView();
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Name");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testUndoInsertElementSchemaView() {
		
		robot.openFile(ORGCHART_XSD_FILE);
		robot.insertXMLItemSchemaView("Element","elem_new","elem_description");
		robot.undoKey();delay(500);
		robot.undoKey();delay(500);
		robot.undoKey();delay(500);
		robot.textView();
		robot.browserView();
		robot.delay(5000);
		robot.schemaView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testTTP1263() {
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Office[1]");
		Rectangle origPos=new Rectangle((robot.getMainWindow().x)+256,(robot.getMainWindow().y)+207,4,4);
		Rectangle finalPos=new Rectangle(robot.getMainWindow().x,(robot.getMainWindow().y)+5,robot.getMainWindow().width,5);
		robot.dragDropMid(origPos, finalPos);
		robot.undoKey();
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testTTP1413() {//still not fixed
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Office[1]");
		robot.delay(2000);
		robot.textView();
		delay(1000);
		robot.gridView();
		//now, we select all offices
		robot.keyType(KeyEvent.VK_UP);
		robot.leftClickMenuItem("XML", "Add child","Element");
		robot.keyType(KeyEvent.VK_ESCAPE);
		robot.undoKey();
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testTTP4140() {
		robot.textView();
		robot.gotoLine(1, 200);
		robot.keyType(KeyEvent.VK_ENTER);
		robot.keyType(KeyEvent.VK_TAB);
		robot.keyType(KeyEvent.VK_TAB);
		robot.keyType(KeyEvent.VK_TAB);
		robot.prettyPrint_icon();
		robot.undo();
		robot.gridView();
		robot.textView();
		robot.gotoLine(1, 200);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP4590() {
		robot.openFile(DATE_XML_FILE);
		robot.assignXSD(DATE_XSD_FILE.getAbsolutePath());
		robot.undoKey();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP18374_MoveLeft() {
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Name");
		robot.XMLMoveLeft();
		robot.delay(500);
		robot.undo(); 
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testTTP18374_MoveRight() {
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Name");
		robot.XMLMoveRight();
		robot.undo(); 
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP18515_AppendDoctype() {
		robot.gridView();
		robot.xpathHighlight("/comment()");
		robot.XMLAppendDoctype("testing");
		robot.undo();robot.delay(500);
		robot.undoKey();
		robot.textView();
		robot.delay(500);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public final void testTTP18515_AppendXML() {
		robot.gridView();
		robot.xpathHighlight("/comment()");
		robot.XMLAppendXml();
		robot.undo();
		robot.authenticView();
		robot.delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testTTP18515_Convert1() {
		robot.gridView();
		robot.xpathHighlight("/processing-instruction()[1]");
		robot.XMLConvertToElement();
		robot.undo();
		robot.textView();
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP18515_Convert2() {
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Name");
		robot.XMLConvertToText();
		robot.escapeGeneralDialogs("Escaping warning about losing info");
		robot.undoKey();
		robot.browserView();
		robot.delay(5000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public final void testTTP48323() {
		robot.openFile(ATTRIBUTE_VALID_XSD);
		robot.validate();
		assertAreas(MESSAGES);
		
	}
	
	@Test
	public final void testTTP48324() {
		robot.openFile(MICROSOFTSTOCKQUOTE_XML_FILE);
		robot.validate();
		assertAreas(MESSAGES);
	}
	
}
