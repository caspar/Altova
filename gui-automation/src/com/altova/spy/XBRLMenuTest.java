package com.altova.spy;

import static com.altova.robots.ImageRecognitionRobot.WINDOWS_DEFAULT_FONT;
import static com.altova.robots.SnapshotArea.CommonArea.*;
import static com.altova.spy.SpyRobot.OVERVIEW;
import static com.altova.spy.SpyRobot.*;
import static java.awt.event.KeyEvent.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.File;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.ImageNotFoundException;
import com.altova.robots.Options;
import com.altova.robots.RadioOption;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.IOUtils;
import com.altova.util.Settings;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;

import org.junit.Before;
import org.junit.Test;

public class XBRLMenuTest extends AbstractXmlSpyTest{

	private static final String ExpandItem = IOUtils.findFile("spy/res/XBRL/ExpandItem.png").getAbsolutePath();
	private static final String cube = IOUtils.findFile("spy/res/XBRL/CUBE.png").getAbsolutePath();
	private static final String extended = IOUtils.findFile("spy/res/XBRL/extended.png").getAbsolutePath();
	private static final String downCube = IOUtils.findFile("spy/res/XBRL/downCube.png").getAbsolutePath();
	
	
	private static final String xbrli_item = IOUtils.findFile("spy/res/XBRL/xbrli_item.png").getAbsolutePath();
	private static final String label = IOUtils.findFile("spy/res/XBRL/labels.png").getAbsolutePath();
	private static final String languageLabel = IOUtils.findFile("spy/res/XBRL/languageLabel.png").getAbsolutePath();
	private static final String reference = IOUtils.findFile("spy/res/XBRL/references.png").getAbsolutePath();
	private static final String checkboxes = IOUtils.findFile("spy/res/XBRL/checkboxes.png").getAbsolutePath();
	private static final String checkboxesLinkRole = IOUtils.findFile("spy/res/XBRL/checkboxesLinkrole.png").getAbsolutePath();
	private static final String checkboxes_short = IOUtils.findFile("spy/res/XBRL/checkboxes_short.png").getAbsolutePath();
	private static final String checkbox_short = IOUtils.findFile("spy/res/XBRL/checkbox_short.png").getAbsolutePath();
	
	private static final String arcrolePlus = IOUtils.findFile("spy/res/XBRL/arcolePlus.png").getAbsolutePath();
	private static final String minusIcon = IOUtils.findFile("spy/res/XBRL/minusIcon.png").getAbsolutePath();
	private static final String expandButton = IOUtils.findFile("spy/res/XBRL/expandButton.png").getAbsolutePath();
	private static final String red = IOUtils.findFile("spy/res/XBRL/red.png").getAbsolutePath();
	
	private static final String dimesion = IOUtils.findFile("spy/res/XBRL/GlobalElements/dimesion.png").getAbsolutePath();
	private static final String HyperCubes = IOUtils.findFile("spy/res/XBRL/GlobalElements/HyperCubes.png").getAbsolutePath();
	private static final String items = IOUtils.findFile("spy/res/XBRL/GlobalElements/items.png").getAbsolutePath();
	private static final String tuples = IOUtils.findFile("spy/res/XBRL/GlobalElements/tuples.png").getAbsolutePath();
	private static final String showAllElements = IOUtils.findFile("spy/res/XBRL/GlobalElements/showAllElements.png").getAbsolutePath();
	private static final String sources = IOUtils.findFile("spy/res/XBRL/GlobalElements/sources.png").getAbsolutePath();
	private static final String format = IOUtils.findFile("spy/res/XBRL/GlobalElements/format.png").getAbsolutePath();
	private static final String expandedFormat = IOUtils.findFile("spy/res/XBRL/GlobalElements/expandedFormat.png").getAbsolutePath();
	private static final String labelFormat = IOUtils.findFile("spy/res/XBRL/GlobalElements/labelFormat.png").getAbsolutePath();
	
	public final static Font XBRL_CONTENT_FONT = new Font("Arial", Font.BOLD, 11);
	public final static Font WINDOWS_DEFAULT_FONT_Gray = new Font("Tahoma", Font.PLAIN, 11);
	
	private static final String xbrlNewElementIco=IOUtils.findFile("spy/res/XBRL/newElement.png").getAbsolutePath();

	private static final String newElementIco=IOUtils.findFile("spy/res/XBRL/newElement.png").getAbsolutePath();
	private static File baseExamplePath = new File("C:\\work\\gui-automation\\data\\spy\\examples\\XBRL");
	private static final File tmpDir = new File("C:\\temp\\debug\\destDirectory");
	private static final File FORMULA_FILE = IOUtils.findFile("spy/examples/XBRL/Formula/Formula-20131108.xsd");
		
	@Before
	 public void setUp() throws Exception {
		robot.copyDirectory(baseExamplePath,tmpDir);
		//robot.openFile(ORGCHART_XML_FILE.toString(), false, null);
		robot.keyPress(VK_ESCAPE);
		delay(3000);
	}


	@Test 
	public void testEditStandardTaxonomiy() {
		robot.copyDirectory(NANONUL_XSD_XBRL_DIR,tmpDir);
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.leftClickOnString("Show All Files", DEFAULT_CONTENT_FONT);
		robot.keyType(VK_DOWN);
		robot.keyType(VK_ENTER);
		robot.find("CostOfOnboard");
		Rectangle rec = robot.getStringRectangle("CostOfOnboard", DEFAULT_CONTENT_FONT_BOLD);
		
		robot.leftClickMid(rec);
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
	}
	
	@Test 
	public void testAddNewElement() {
		robot.newFile("Taxonomy");
		robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "None");
		robot.leftClickImage(newElementIco);
		delay(300);
		robot.typeStringEnter("e1:newElement");
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
	}
	@Test 
	public void testAddNewElementUsingContextMenu() {
		robot.newFile("Taxonomy");
		robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "None");
		Rectangle rec = robot.getStringRectangle("Unsorted", DEFAULT_CONTENT_FONT);
		rec.y = rec.y + 100;
		delay(300);
		robot.rightClickMidVar(rec,0);
		robot.leftClickOnString("Add New Element", WINDOWS_DEFAULT_FONT);
		robot.typeStringEnter("e1:newElement");
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
	}
	
	//TC2_3
	
	@Test 
	public void testEditElement() {
		robot.openFile(tmpDir + "\\TC2_3\\TC2_3.xsd");
		delay(3000);
		robot.leftClickMidVar(robot.findImage(ExpandItem), -10);
		delay(200);
		robot.leftClickMidVar(robot.findImage(xbrli_item), +20);
		delay(200);
		robot.keyType(VK_DOWN);
		robot.keyType(VK_ENTER);
		robot.saveFile();
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
	}
	
	@Test 
	public void testAddLabelLinkRole() {
		robot.openFile(tmpDir + "\\TC2_6\\TC2_6.xsd");
		delay(3000);
		robot.rightClickMidVar(robot.findImage(ExpandItem), +10);
		robot.keyType(VK_DOWN);
		robot.keyType(VK_ENTER);
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
	}
	
	@Test 
	public void testAddLabel() {
		robot.openFile(tmpDir + "\\TC2_5\\TC2_5.xsd");
		delay(3000);
		robot.leftClickMidVar(robot.findImage(ExpandItem), -10);
		delay(300);
		robot.rightClickMidVar(robot.findImage(label), +10);
		robot.keyType(VK_UP);
		delay(200);
		robot.keyType(VK_UP);
		delay(200);
		robot.keyType(VK_ENTER);
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
	}
	@Test 
	public void testDeleteLabel() {
		robot.openFile(tmpDir + "\\TC2_6\\TC2_6.xsd");
		delay(3000);
		robot.leftClickMidVar(robot.findImage(ExpandItem), -10);
		delay(300);
		robot.rightClickMidVar(robot.findImage(languageLabel), 0);
		robot.keyType(VK_UP);
		delay(200);
		robot.keyType(VK_ENTER);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testDeleteLabelLinkrole() {
		robot.openFile(tmpDir + "\\TC2_6\\TC2_6.xsd");
		robot.leftClickMidVar(robot.findImage(ExpandItem), -10);
		delay(300);
		robot.rightClickMidVar(robot.findImage(label), +10);
		robot.keyType(VK_DOWN);
		delay(200);
		robot.keyType(VK_DOWN);
		delay(200);
		robot.keyType(VK_ENTER);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testAddReferenceLinkRole() {
		robot.openFile(tmpDir + "\\TC2_6\\TC2_6.xsd");
		delay(300);
		robot.rightClickMidVar(robot.findImage(ExpandItem), +10);
		robot.keyType(VK_DOWN);
		delay(300);
		robot.keyType(VK_DOWN);
		delay(300);
		robot.keyType(VK_ENTER);
		assertAreas(DIAGRAM_MAIN_WINDOW, DETAILS);
	}
	@Test 
	public void testAddReference() {
		robot.openFile(tmpDir + "\\TC2_9\\TC2_9.xsd");
		delay(3000);
		robot.leftClickMidVar(robot.findImage(ExpandItem), -10);
		delay(300);
		robot.rightClickMidVar(robot.findImage(reference), +0);
		robot.keyType(VK_DOWN);
		delay(300);
		robot.keyType(VK_DOWN);
		delay(300);
		robot.keyType(VK_DOWN);
		delay(300);
		robot.keyType(VK_DOWN);
		delay(300);
		robot.keyType(VK_DOWN);
		delay(300);
		robot.keyType(VK_ENTER);
		delay(300);
		robot.keyType(VK_DOWN);
		delay(300);
		robot.keyType(VK_ENTER);
		assertAreas(DIAGRAM_MAIN_WINDOW, DETAILS);
	}
	
	@Test 
	public void testAddReferencePart() {
		robot.openFile(tmpDir + "\\TC2_10\\TC2_10.xsd");
		delay(3000);
		robot.leftClickMidVar(robot.findImage(ExpandItem), -10);
		delay(300);
		Rectangle rec = robot.findImage(reference);
		rec.y = rec.y + 20;
		robot.rightClickMidVar(rec, +0);
		delay(300);
		robot.leftClickOnString("Add Reference Part", WINDOWS_DEFAULT_FONT);
		robot.typeString("Created new Part");
		assertAreas(DIAGRAM_MAIN_WINDOW, DETAILS);
	}
	
	@Test 
	public void testDeleteReference() {
		robot.openFile(tmpDir + "\\TC2_10\\TC2_10.xsd");
		delay(3000);
		robot.leftClickMidVar(robot.findImage(ExpandItem), -10);
		delay(300);
		Rectangle rec = robot.findImage(reference);
		rec.y = rec.y + 20;
		robot.rightClickMidVar(rec, +0);
		robot.leftClickOnString("Delete Reference  ", WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW, DETAILS);
	}
	
	@Test 
	public void testDeleteReferenceLinkrole() {
		
		robot.openFile(tmpDir + "\\TC2_9\\TC2_9.xsd");
		delay(3000);
		robot.leftClickMidVar(robot.findImage(ExpandItem), -10);
		delay(300);
		robot.rightClickMidVar(robot.findImage(reference), +0);
		delay(300);
		robot.leftClickOnString("Delete Reference Linkrole", WINDOWS_DEFAULT_FONT);
		
		assertAreas(DIAGRAM_MAIN_WINDOW, DETAILS);
	}
	
	@Test 
	public void testShowInSchemaView() {
		
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.leftClickOnString("Show All Files", DEFAULT_CONTENT_FONT);
		delay(1000);
		robot.mouseMove(10, 10);
		robot.leftClickOnString("Limit to nanonull", DEFAULT_CONTENT_FONT);
		delay(2000);
		robot.leftClickOnString("Unsorted", DEFAULT_CONTENT_FONT);
		delay(2000);
		robot.leftClickOnString("Sort by Name", DEFAULT_CONTENT_FONT);
		delay(2000);
		robot.find("CostOfOnboard");
		Rectangle rec = robot.getStringRectangle("CostOfOnboard", XBRL_CONTENT_FONT);
		robot.rightClickMidVar(rec,0);
		robot.leftClickOnString("Show in Schema View", WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testShowInGlobalElements() {
		
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.leftClickOnString("Show All Files", DEFAULT_CONTENT_FONT);
		delay(1000);
		robot.mouseMove(10, 10);
		robot.leftClickOnString("Limit to nanonull", DEFAULT_CONTENT_FONT);
		delay(2000);
		robot.leftClickOnString("Unsorted", DEFAULT_CONTENT_FONT);
		delay(2000);
		robot.leftClickOnString("Sort by Name", DEFAULT_CONTENT_FONT);
		delay(2000);
		robot.find("CostOfOnboard");
		Rectangle rec = robot.getStringRectangle("CostOfOnboard", XBRL_CONTENT_FONT);
		robot.rightClickMidVar(rec,0);
		robot.leftClickOnString("Show in Global Elements", WINDOWS_DEFAULT_FONT);
		assertAreas(GLOBAL_ELEMENTS);
	}
	
	@Test 
	public void testXBRLSortByName() {
		
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.leftClickOnString("Show All Files", DEFAULT_CONTENT_FONT);
		delay(1000);
		robot.mouseMove(10, 10);
		robot.leftClickOnString("Limit to nanonull", DEFAULT_CONTENT_FONT);
		delay(2000);
		robot.leftClickOnString("Unsorted", DEFAULT_CONTENT_FONT);
		delay(2000);
		robot.leftClickOnString("Sort by Name", DEFAULT_CONTENT_FONT);
		delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test 
	public void testXBRLSortBySubstitutionGroup() {
		
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.leftClickOnString("Show All Files", DEFAULT_CONTENT_FONT);
		delay(1000);
		robot.mouseMove(10, 10);
		robot.leftClickOnString("Limit to nanonull", DEFAULT_CONTENT_FONT);
		delay(2000);
		robot.leftClickOnString("Unsorted", DEFAULT_CONTENT_FONT);
		delay(2000);
		robot.leftClickOnString("Sort by Substitution", DEFAULT_CONTENT_FONT);
		delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testXBRLSortByType() {
		
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.leftClickOnString("Show All Files", DEFAULT_CONTENT_FONT);
		delay(1000);
		robot.mouseMove(10, 10);
		robot.leftClickOnString("Limit to nanonull", DEFAULT_CONTENT_FONT);
		delay(2000);
		robot.leftClickOnString("Unsorted", DEFAULT_CONTENT_FONT);
		delay(2000);
		robot.leftClickOnString("Sort by Type", DEFAULT_CONTENT_FONT);
		delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	
	
	
	
	
	@Test 
	public void testRelationshipsTabAddNewLinkRole() {
		robot.newFile("Taxonomy");
		robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "None");
		robot.switchXBRLTab_Definitions();
		robot.leftClickImage(newElementIco);
		robot.leftClickOnString("Add Extended Link Role", WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
	}
	
	@Test 
	public void testRelationshipsInsertElementReference() {
		
		robot.openFile(tmpDir+"\\TC3_2\\TC3_2.xsd");
		delay(5000);
		robot.switchXBRLTab_Definitions();
		robot.rightClickOnString("xbrl.org", WINDOWS_DEFAULT_FONT);
		delay(500);
		robot.leftClickOnString("Insert Element", WINDOWS_DEFAULT_FONT);
		delay(500);
		robot.clickButton("Insert");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testRelationshipsDeleteExtendedLinkRole() {
		
		robot.openFile(tmpDir+"\\TC3_2\\TC3_2.xsd");
		delay(5000);
		robot.switchXBRLTab_Definitions();
		robot.rightClickOnString("xbrl.org", WINDOWS_DEFAULT_FONT);
		delay(500);
		robot.leftClickOnString("Delete Extended", WINDOWS_DEFAULT_FONT);
		delay(500);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testRelationshipsInsertArcItemElement() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Definitions();
		delay(500);
		robot.leftClickOnString("Segment", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		robot.rightClickImage(ExpandItem);
		delay(500);
		robot.leftClickOnString("Insert Arc", WINDOWS_DEFAULT_FONT);
		robot.leftClickImage(items,robot.findComponentName("Insert Arc"),true);
		robot.clickButton("Insert");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test 
	public void testRelationshipsInsertArcHyperCube() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Definitions();
		delay(500);
		robot.leftClickOnString("Segment", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		robot.rightClickImage(ExpandItem);
		robot.leftClickOnString("Insert Arc", WINDOWS_DEFAULT_FONT);
		robot.leftClickImage(HyperCubes,robot.findComponentName("Insert Arc"),true);
		robot.clickButton("Insert");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testRelationshipsInsertArcDimension() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Definitions();
		delay(1500);
		robot.leftClickOnString("Segment", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		robot.rightClickImage(ExpandItem);
		robot.leftClickOnString("Insert Arc", WINDOWS_DEFAULT_FONT);
		robot.leftClickImage(dimesion,robot.findComponentName("Insert Arc"),true);
		robot.clickButton("Insert");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test 
	public void testRelationshipsOverrideRemoveArc() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Definitions();
		delay(1500);
		robot.leftClickOnString("Segment", WINDOWS_DEFAULT_FONT);
		robot.keyTypeShift(VK_PLUS);
		robot.rightClickImage(cube);
		robot.leftClickOnString("Override Arc", WINDOWS_DEFAULT_FONT);
		//robot.rightClickImage(cube);
		//robot.leftClickOnString("Remove Arc", WINDOWS_DEFAULT_FONT);
		//robot.leftClickImage(dimesion,robot.findComponentName("Insert Arc"),true);
		//robot.clickButton("Insert");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	
	@Test 
	public void testRelationshipsAddLabelLinkrole() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Definitions();
		delay(1500);
		robot.leftClickOnString("Segment", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		robot.rightClickImage(ExpandItem);
		robot.leftClickOnString("Add Label Linkrole", WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test 
	public void testRelationshipsDeleteElementReference() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Definitions();
		delay(500);
		robot.leftClickOnString("Segment", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		robot.rightClickImage(ExpandItem);
		robot.leftClickOnString("Delete Element Reference", WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	// Presentation tab
	
	
	@Test 
	public void testPresentationAddNewLinkRole() {
		robot.newFile("Taxonomy");
		robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "None");
		robot.switchXBRLTab_Presentation();
		robot.leftClickImage(newElementIco);
		robot.leftClickOnString("Add Extended Link Role", WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
	}
	
	@Test 
	public void testPresentationInsertElementReference() {
		
		robot.openFile(tmpDir+"\\TC3_2\\TC3_2.xsd");
		delay(5000);
		robot.switchXBRLTab_Presentation();
		robot.rightClickOnString("xbrl.org", WINDOWS_DEFAULT_FONT);
		delay(500);
		robot.leftClickOnString("Insert Element", WINDOWS_DEFAULT_FONT);
		delay(500);
		robot.clickButton("Insert");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testPresentationDeleteExtendedLinkRole() {
		
		robot.openFile(tmpDir+"\\TC3_2\\TC3_2.xsd");
		delay(5000);
		robot.switchXBRLTab_Presentation();
		robot.rightClickOnString("xbrl.org", WINDOWS_DEFAULT_FONT);
		delay(500);
		robot.leftClickOnString("Delete Extended", WINDOWS_DEFAULT_FONT);
		delay(500);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testPresentationInsertArcItemElement() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Presentation();
		delay(500);
		robot.leftClickOnString("Segment", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		robot.rightClickImage(ExpandItem);
		robot.leftClickOnString("Insert Arc", WINDOWS_DEFAULT_FONT);
		robot.leftClickImage(items,robot.findComponentName("Insert Arc"),true);
		robot.clickButton("Insert");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test 
	public void testPresentationInsertArcHyperCube() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Presentation();
		delay(500);
		robot.leftClickOnString("Segment", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		robot.rightClickImage(ExpandItem);
		robot.leftClickOnString("Insert Arc", WINDOWS_DEFAULT_FONT);
		robot.leftClickImage(HyperCubes,robot.findComponentName("Insert Arc"),true);
		robot.clickButton("Insert");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testPresentationInsertArcDimension() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Presentation();
		delay(1500);
		robot.leftClickOnString("Segment", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		robot.rightClickImage(ExpandItem);
		robot.leftClickOnString("Insert Arc", WINDOWS_DEFAULT_FONT);
		robot.leftClickImage(dimesion,robot.findComponentName("Insert Arc"),true);
		robot.clickButton("Insert");
		delay(500);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	
	@Test 
	public void testPresentationAddLabelLinkrole() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Presentation();
		delay(1500);
		robot.leftClickOnString("Segment", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		robot.rightClickImage(ExpandItem);
		robot.leftClickOnString("Add Label Linkrole", WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	
	@Test 
	public void testPresentationDeleteElementReference() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Presentation();
		delay(500);
		robot.leftClickOnString("Segment", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		robot.rightClickImage(ExpandItem);
		robot.leftClickOnString("Delete Element Reference", WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	//Calculation tab
	
	@Test 
	public void testCalculationAddNewLinkRole() {
		robot.newFile("Taxonomy");
		robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "None");
		robot.switchXBRLTab_Calculation();
		robot.leftClickImage(newElementIco);
		robot.leftClickOnString("Add Extended Link Role", WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
	}
	
	@Test 
	public void testCalculationInsertElementReference() {
		
		robot.openFile(tmpDir+"\\TC3_2\\TC3_2.xsd");
		delay(5000);
		robot.switchXBRLTab_Calculation();
		robot.rightClickOnString("xbrl.org", WINDOWS_DEFAULT_FONT);
		delay(500);
		robot.leftClickOnString("Insert Element", WINDOWS_DEFAULT_FONT);
		delay(500);
		robot.clickButton("Insert");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testCalculationDeleteExtendedLinkRole() {
		
		robot.openFile(tmpDir+"\\TC3_2\\TC3_2.xsd");
		delay(5000);
		robot.switchXBRLTab_Calculation();
		robot.rightClickOnString("xbrl.org", WINDOWS_DEFAULT_FONT);
		delay(500);
		robot.leftClickOnString("Delete Extended", WINDOWS_DEFAULT_FONT);
		delay(500);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testCalculationInsertArcItemElement() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Calculation();
		delay(500);
		robot.leftClickOnString("Indirect", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		robot.rightClickImage(ExpandItem);
		robot.leftClickOnString("Insert Arc", WINDOWS_DEFAULT_FONT);
		robot.leftClickImage(items,robot.findComponentName("Insert Arc"),true);
		robot.clickButton("Insert");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test 
	public void testCalculationInsertArcHyperCube() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Calculation();
		delay(500);
		robot.leftClickOnString("Indirect", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		robot.rightClickImage(ExpandItem);
		robot.leftClickOnString("Insert Arc", WINDOWS_DEFAULT_FONT);
		robot.leftClickImage(HyperCubes,robot.findComponentName("Insert Arc"),true);
		robot.clickButton("Insert");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testCalculationInsertArcDimension() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Calculation();
		delay(500);
		robot.leftClickOnString("Indirect", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		robot.rightClickImage(ExpandItem);
		robot.leftClickOnString("Insert Arc", WINDOWS_DEFAULT_FONT);
		robot.leftClickImage(dimesion,robot.findComponentName("Insert Arc"),true);
		robot.clickButton("Insert");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test 
	public void testCalculationOverrideRemoveArc() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Calculation();
		delay(500);
		robot.leftClickOnString("Indirect", WINDOWS_DEFAULT_FONT);
		robot.keyTypeShift(VK_PLUS);
		robot.rightClickImage(extended);
		robot.leftClickOnString("Override Arc", WINDOWS_DEFAULT_FONT);
	//	robot.rightClickOnString("NetIncomeLoss", XBRL_CONTENT_FONT,Color.GRAY);
	//	robot.leftClickOnString("Remove Arc", WINDOWS_DEFAULT_FONT);
	//	robot.leftClickImage(dimesion,robot.findComponentName("Insert Arc"),true);
	//	robot.clickButton("Insert");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	
	@Test 
	public void testCalculationAddLabelLinkrole() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Calculation();
		delay(500);
		robot.leftClickOnString("FlowsIndirect", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		robot.rightClickImage(ExpandItem);
		robot.leftClickOnString("Add Label Linkrole", WINDOWS_DEFAULT_FONT);
//		robot.keyType(VK_ENTER);
//		robot.rightClickOnString("Label", DEFAULT_CONTENT_FONT,Color.GRAY);
//		robot.keyType(VK_UP);
//		robot.keyType(VK_UP);
//		robot.keyType(VK_ENTER);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	
	@Test 
	public void testCalculationDeleteElementReference() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Calculation();
		delay(500);
		robot.leftClickOnString("FlowsIndirect", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		robot.rightClickImage(ExpandItem);
		robot.leftClickOnString("Delete Element Reference", WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testCalculationWeightAttributes() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Calculation();
		delay(500);
		robot.leftClickOnString("FlowsIndirect", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		delay(500);
		robot.leftClickImage(ExpandItem);
		robot.keyType(VK_PLUS);
		robot.delay(500);
		robot.leftDoubleClickOnString("1.0", WINDOWS_DEFAULT_FONT,"MAIN");
		robot.leftDoubleClickOnString("-1.0", WINDOWS_DEFAULT_FONT,"MAIN");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testFormulaTab() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Formula();
		delay(500);
		robot.XbrlAddFormulaElement(xbrlNewElementIco, "Add New Assertion");
		robot.XbrlAddFormulaElement(xbrlNewElementIco, "Add New Formula");
		robot.clickButton("OK");
		robot.XbrlAddFormulaElement(xbrlNewElementIco, "Add New Precondition");
		robot.clickButton("OK");
		robot.XbrlAddFormulaElement(xbrlNewElementIco, "Add New Parameter");
		robot.XbrlAddFormulaElement(xbrlNewElementIco, "Add New General Variable");
		robot.clickButton("OK");
		robot.XbrlAddFormulaElement(xbrlNewElementIco, "Add New Fact Variable");
		robot.XbrlAddFormulaElement(xbrlNewElementIco, "Add New Function");
		robot.XbrlAddFormulaElement(xbrlNewElementIco, "Filter","Aspect Cover Filter");
		robot.XbrlAddFormulaElement(xbrlNewElementIco, "Filter","Boolean Filter","And Filter");
		robot.XbrlAddFormulaElement(xbrlNewElementIco, "Filter","Boolean Filter","Or Filter");
		robot.XbrlAddFormulaElement(xbrlNewElementIco, "Filter","Concept Filter","Concept Name Filter");
		robot.XbrlAddFormulaElement(xbrlNewElementIco, "Filter","Concept Filter","Concept Period-Type Filter");
		robot.XbrlAddFormulaElement(xbrlNewElementIco, "Filter","Concept Filter","Concept Balance Filter");
		robot.XbrlAddFormulaElement(xbrlNewElementIco, "Filter","Concept Filter","Concept Custom-Attribute Filter");
		robot.XbrlAddFormulaElement(xbrlNewElementIco, "Filter","Concept Filter","Concept Data-Type Filter");
		robot.XbrlAddFormulaElement(xbrlNewElementIco, "Filter","General Filter");
		robot.clickButton("OK");
		robot.rightClickOnString("Assertion", DEFAULT_CONTENT_FONT_BOLD);
		robot.leftClickOnString("Delete", WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	
	//OVERVIEW Entry Helper				
	@Test 
	public void testAddNewLinkbaseFiles() {
		
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		String[] files ={"Calculation","Definition","Label","Presentation"}; //Reference need to be added seperatly
		
		for(int i =0; i< files.length; i++){
			robot.rightClickOnString("nanonull", DEFAULT_CONTENT_FONT,"Overview");
			delay(300);
			robot.leftClickOnString("Add new Linkbase", WINDOWS_DEFAULT_FONT);
			delay(200);
			robot.leftClickOnString(files[i], WINDOWS_DEFAULT_FONT);
			delay(200);
		}
		
		robot.rightClickOnString("nanonull", DEFAULT_CONTENT_FONT,"Overview");
		robot.leftClickOnString("Add new Linkbase", WINDOWS_DEFAULT_FONT);
		delay(200);
		robot.keyType(VK_RIGHT);
		delay(200);
		robot.keyType(VK_UP);
		delay(200);
		robot.keyType(VK_ENTER);
		delay(200);
		assertAreas(OVERVIEW);
	}
	
	@Test 
	public void testRenameLinkbaseFiles() {
		
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.rightClickOnString("nanonull", DEFAULT_CONTENT_FONT,"Overview");
		delay(300);
		robot.leftClickOnString("Add new Linkbase", WINDOWS_DEFAULT_FONT);
		delay(200);
		robot.leftClickOnString("Calculation", WINDOWS_DEFAULT_FONT);
		delay(200);
		robot.rightClickOnString("_cal_1", DEFAULT_CONTENT_FONT_BOLD,"Overview");
		delay(1000);
		robot.leftClickOnString("Rename", WINDOWS_DEFAULT_FONT);
		delay(200);
		robot.typeString("NewName.xml");
		assertAreas(OVERVIEW);
	}
	
	@Test 
	public void testRemoveLinkbaseFiles() {
		
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.rightClickOnString("nanonull_cal", DEFAULT_CONTENT_FONT_BOLD,"Overview");
		delay(300);
		robot.leftClickOnString("Remove", WINDOWS_DEFAULT_FONT);
		delay(300);
		robot.escapeDialog("Are you sure you want to remove", VK_Y);
		delay(200);
		assertAreas(OVERVIEW);
	}
	

	@Test 
	public void testFiltrIcons() {
		
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.leftClickImage(items);
		assertAreas("testFiltrIcons1",GLOBAL_ELEMENTS);
		robot.leftClickImage(tuples);
		assertAreas("testFiltrIcons2",GLOBAL_ELEMENTS);
		robot.leftClickImage(HyperCubes);
		assertAreas("testFiltrIcons3",GLOBAL_ELEMENTS);
		robot.leftClickImage(dimesion);
		assertAreas("testFiltrIcons4",GLOBAL_ELEMENTS);
		robot.leftClickImage(showAllElements);
		assertAreas("testFiltrIcons5",GLOBAL_ELEMENTS);
		robot.leftClickImage(sources);
		assertAreas(TOP_WINDOW);
		robot.closeAltF4();
	}
	
	
	@Test 
	public void testFormatInGlobalElementsWindow() {
		
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.leftClickImage(format);
		robot.leftClickOnString("Expanded", WINDOWS_DEFAULT_FONT);
		assertAreas("testFormatInGlobalElementsWindow1",GLOBAL_ELEMENTS);
		robot.leftClickImage(expandedFormat);
		robot.leftClickOnString("Label", WINDOWS_DEFAULT_FONT);
		assertAreas("testFormatInGlobalElementsWindow2",GLOBAL_ELEMENTS);
		robot.leftClickImage(labelFormat);
		robot.leftClickOnString("Short", WINDOWS_DEFAULT_FONT);
		assertAreas("testFormatInGlobalElementsWindow3",GLOBAL_ELEMENTS);
		
	}
	

	// Details Window

	@Test 
	public void testElementProperties() {
		
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.xbrlFiltr("Limit to nanonull", "Sort by Name");
		Rectangle rec = robot.getStringRectangle("CostOfOnboard", XBRL_CONTENT_FONT);
		robot.leftClickMidVar(rec,10);
		robot.leftDoubleClickOnString("debit", WINDOWS_DEFAULT_FONT,"Details");
		delay(500);
		robot.leftClickOnString("credit", WINDOWS_DEFAULT_FONT);
		delay(500);
		robot.leftDoubleClickOnString("duration", WINDOWS_DEFAULT_FONT,"Details");
		delay(500);
		robot.keyType(VK_DOWN);
		delay(200);
		robot.keyType(VK_ENTER);
		robot.leftDoubleClickOnString("xbrli:item", WINDOWS_DEFAULT_FONT,"Details");
		delay(500);
	robot.keyType(VK_UP);
		delay(200);
		robot.keyType(VK_ENTER);
		delay(500);
		assertAreas(DIAGRAM_MAIN_WINDOW,DETAILS);
	}
	
	@Test 
	public void testNameSpaceDetails() {
		
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.rightClickOnString("nanonull", DEFAULT_CONTENT_FONT,"Overview");
		delay(300);
		robot.leftClickOnString("Set Target Namespace", WINDOWS_DEFAULT_FONT);
		delay(300);
		robot.typeString("nanonull2");
		robot.keyType(VK_TAB);
		robot.typeString("http://changed.com/nanonull");
		robot.clickButton("OK");
		robot.xbrlFiltr("Limit to nanonull", "Sort by Name");
		robot.find("CostOfOnboard");
		Rectangle rec = robot.getStringRectangle("CostOfOnboard", XBRL_CONTENT_FONT);
		robot.leftClickMidVar(rec,10);
		assertAreas(DETAILS);
	}

	
	
	@Test 
	public void testLabelChildrenProperty() {
		
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.xbrlFiltr("Limit to nanonull", "Sort by Name");
		robot.find("CostOfOnboard");
		Rectangle rec = robot.getStringRectangle("CostOfOnboard", XBRL_CONTENT_FONT);
		robot.leftClickMidVar(rec,10);
		robot.scrollPane(DETAIL, 1.0);
		assertAreas(DETAILS);
	}
	
	@Test 
	public void testLabelProperties() {
		
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.xbrlFiltr("Limit to nanonull", "Sort by Name");
		robot.find("CostOfOnboard");
		Rectangle rec = robot.getStringRectangle("CostOfOnboard", XBRL_CONTENT_FONT);
		robot.leftClickMidVar(rec,-150);
		robot.mouseMove(100, 100);
		delay(500);
		robot.leftClickOnString("en-US", WINDOWS_DEFAULT_FONT);

		robot.leftDoubleClickOnString("en-US", WINDOWS_DEFAULT_FONT,"Details");
		
		robot.keyType(VK_DOWN);
		robot.keyType(VK_ENTER);
		assertAreas(DIAGRAM_MAIN_WINDOW,DETAILS);
	}
	
	@Test 
	public void testArcProperties() {
		
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.xbrlFiltr("Limit to nanonull", "Sort by Name");
		robot.find("CostOfOnboard");
		Rectangle rec = robot.getStringRectangle("CostOfOnboard", XBRL_CONTENT_FONT);
		robot.leftClickMidVar(rec,-150);
		robot.mouseMove(100, 100);
		delay(500);
		robot.rightClickOnString("en-US", WINDOWS_DEFAULT_FONT);
		delay(500);
		robot.leftClickOnString("Override Label Arc", WINDOWS_DEFAULT_FONT);
		robot.leftClickOnString("Order", WINDOWS_DEFAULT_FONT,Color.gray);
		assertAreas(DIAGRAM_MAIN_WINDOW,DETAILS);
	}
	// XBRL Arcroles menu
	
	@Test 
	public void testCreateNewArcroleTaxonomy() {
		robot.newFile("Taxonomy");
		robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "None");
		robot.leftClickMenuItem("XBRL", "Arcroles");
		robot.leftClickButton("Add");
		robot.typeString("http://NewRobotURL.com");
		Rectangle rec = robot.findImage(checkboxes);
		
		robot.leftClickMidVar(rec, -102);
		delay(200);
		robot.leftClickMidVar(rec, +41);
		delay(200);
		robot.leftClickMidVar(rec, +41);
		delay(200);
		robot.leftClickMidVar(rec, +41);
		delay(200);
		robot.leftClickMidVar(rec, +41);
		delay(200);
		robot.leftClickMidVar(rec, +41);
		delay(200);
		robot.leftClickMidVar(robot.findImage(arcrolePlus), -4);
		delay(1000);
		robot.keyType(VK_DOWN);
		delay(200);
		robot.keyType(VK_DOWN);
		delay(200);
		robot.keyType(VK_DOWN);
		delay(200);
		
		robot.clickButton("OK");
		delay(200);
		robot.clickButton("OK");
		delay(200);
		robot.leftClickMenuItem("XBRL", "Arcroles");
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
		
		
	}
	
	
	@Test 
	public void testEditArcroleTaxonomy() {
		robot.openFile(tmpDir+ "\\TC7_2\\TC7_2.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "Arcroles");
		delay(200);
		Rectangle rec = robot.findImage(checkboxes_short);
		robot.leftClickMidVar(rec, -20);
		delay(200);
		robot.leftClickMidVar(rec, +40);
		delay(200);
		robot.clickButton("OK");
		delay(200);
		robot.leftClickMenuItem("XBRL", "Arcroles");
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	
	@Test 
	public void testDeleteReferencingLinkbaseFileArcrole() {
		robot.openFile(tmpDir+ "\\TC7_2\\TC7_2.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "Arcroles");
		delay(200);
		robot.leftClickImage(minusIcon);
		robot.escapeDialog("Do you really want to delete this Reference?", VK_Y);
		robot.clickButton("OK");
		robot.leftClickMenuItem("XBRL", "Arcroles");
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	

	@Test 
	public void testdeleteArcroleTaxonomy() {
		robot.openFile(tmpDir+ "\\TC7_2\\TC7_2.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "Arcroles");
		delay(200);
		robot.rightClickImage(checkboxes_short);
		robot.clickButton("Delete");
		robot.clickButton("OK");
		robot.escapeDialog("Do you also want to delete the corresponding references?", VK_Y);
		robot.clickButton("OK");
		robot.leftClickMenuItem("XBRL", "Arcroles");
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	
	@Test 
	public void testAddNewArcroleLinkbaseFile() {
		robot.openFile(tmpDir+ "\\TC7_2\\TC7_2.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "Arcroles");
		robot.switchXBRLTab_LinkBases();
		robot.clickButton("Add");
		robot.keyType(VK_TAB);
		delay(100);
		robot.keyType(VK_TAB);
		delay(100);
		robot.keyType(VK_DOWN);
		delay(100);
		robot.keyType(VK_TAB);
		delay(100);
		robot.keyType(VK_DOWN);
		delay(100);
		robot.keyType(VK_TAB);
		delay(100);
		robot.keyType(VK_DOWN);
		delay(100);
		robot.clickButton("OK");
		delay(100);
		robot.clickButton("OK");
		robot.leftClickMenuItem("XBRL", "Arcroles");
		robot.switchXBRLTab_LinkBases();
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	
	@Test 
	public void testDeleteArcroleLinkbaseFile() {
		robot.openFile(tmpDir+ "\\TC7_7\\TC7_7.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "Arcroles");
		robot.switchXBRLTab_LinkBases();
		delay(100);
		robot.expandCombobox();
		delay(1000);
		robot.leftClickOnString("def.xml", MS_SHELL_DLG_FONT);
		robot.leftClickOnString("domain-member", WINDOWS_DEFAULT_FONT);
		robot.clickButton("Delete");
		delay(100);
		robot.clickButton("OK");
		robot.leftClickMenuItem("XBRL", "Arcroles");
		robot.switchXBRLTab_LinkBases();
		delay(100);
		robot.keyTypeAlt(VK_DOWN);
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	//  XBRL Arcroles menu
	
	@Test 
	public void testCreateNewLinkroleTaxonomy() {
		robot.newFile("Taxonomy");
		robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "None");
		robot.leftClickMenuItem("XBRL", "Linkroles");
		robot.leftClickButton("Add");
		robot.typeString("http://NewRobotURL.com");
		Rectangle rec = robot.findImage(checkboxesLinkRole);
		
		robot.leftClickMidVar(rec, -120);
		delay(2000);
		robot.leftClickMidVar(rec, +49);
		delay(2000);
		robot.leftClickMidVar(rec, +49);
		delay(2000);
		robot.leftClickMidVar(rec, +49);
		delay(2000);
		robot.leftClickMidVar(rec, +49);
		delay(2000);
		robot.leftClickMidVar(rec, +49);
		delay(2000);
		robot.leftClickMidVar(robot.findImage(arcrolePlus), -4);
		delay(1000);
		robot.keyType(VK_DOWN);
		delay(200);
		robot.keyType(VK_DOWN);
		delay(200);
		robot.keyType(VK_DOWN);
		delay(200);
		robot.clickButton("OK");
		delay(200);
		robot.clickButton("OK");
		delay(200);
		robot.leftClickMenuItem("XBRL", "Linkroles");
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}

	@Test 
	public void testEditLinkroleTaxonomy() {
		robot.openFile(tmpDir+ "\\TC7_2\\TC7_2.xsd");
		delay(5000);
		robot.leftClickMenuItem("XBRL", "Linkroles");
		delay(200);
		Rectangle rec = robot.findImage(checkbox_short);
		robot.leftClickMidVar(rec, 0);
		delay(1000);
		robot.leftClickMidVar(rec, +45);
		delay(1000);
		robot.clickButton("OK");
		delay(200);
		robot.leftClickMenuItem("XBRL", "Linkroles");
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	
	@Test 
	public void testDeleteReferencingLinkbaseFileLinkrole() {
		robot.openFile(tmpDir+ "\\TC7_2\\TC7_2.xsd");
		delay(5000);
		robot.leftClickMenuItem("XBRL", "Linkroles");
		delay(200);
		robot.leftClickImage(minusIcon);
		robot.escapeDialog("Do you really want to delete this Reference?", VK_Y);
		robot.clickButton("OK");
		robot.leftClickMenuItem("XBRL", "Linkroles");
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	

	@Test 
	public void testdeleteLinkroleTaxonomy() {
		robot.openFile(tmpDir+ "\\TC7_2\\TC7_2.xsd");
		delay(5000);
		robot.leftClickMenuItem("XBRL", "Linkroles");
		delay(200);
		robot.rightClickImage(checkbox_short);
		robot.clickButton("Delete");
		robot.clickButton("OK");
		robot.escapeDialog("Do you also want to delete the corresponding references?", VK_Y);
		robot.clickButton("OK");
		robot.leftClickMenuItem("XBRL", "Linkroles");
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	
	@Test 
	public void testAddNewLinkroleLinkbaseFile() {
		robot.openFile(tmpDir+ "\\TC7_2\\TC7_2.xsd");
		delay(5000);
		robot.leftClickMenuItem("XBRL", "Linkroles");
		robot.switchXBRLTab_LinkBases();
		robot.clickButton("Add");
		robot.keyType(VK_TAB);
		delay(100);
		robot.keyType(VK_TAB);
		delay(100);
		robot.keyType(VK_DOWN);
		delay(100);
		robot.keyType(VK_TAB);
		delay(100);
		robot.keyType(VK_DOWN);
		delay(100);
		robot.keyType(VK_TAB);
		delay(100);
		robot.keyType(VK_DOWN);
		delay(100);
		robot.clickButton("OK");
		delay(100);
		robot.clickButton("OK");
		robot.leftClickMenuItem("XBRL", "Linkroles");
		robot.switchXBRLTab_LinkBases();
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	
	@Test 
	public void testDeleteLinkroleLinkbaseFile() {
		robot.openFile(tmpDir+ "\\TC7_2\\TC7_2.xsd");
		delay(5000);
		robot.leftClickMenuItem("XBRL", "Linkroles");
		robot.switchXBRLTab_LinkBases();
		delay(100);
		robot.expandCombobox();
		delay(1000);
		robot.leftClickOnString("cal.xml", MS_SHELL_DLG_FONT);
		delay(10000);
		robot.leftClickOnString("NewUR", DEFAULT_CONTENT_FONT);
		delay(10000);
				
		robot.clickButton("Delete");
		delay(100);
		robot.clickButton("OK");
		robot.leftClickMenuItem("XBRL", "Linkroles");
		robot.switchXBRLTab_LinkBases();
		delay(100);
		robot.keyTypeAlt(VK_DOWN);
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}


	 // XBRL Namespace prefixes menu

	
	@Test 
	public void testAddNewTaxonomyNamespace() {
		robot.newFile("Taxonomy");
		robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "None");
		robot.leftClickMenuItem("XBRL", "Namespace");
		robot.leftClickButton("Add");
		robot.typeString("n2");
		delay(200);
		robot.keyType(VK_TAB);
		delay(200);
		robot.typeString("http://www.altova.com/nanonull");
		delay(200);
		robot.clickButton("OK");
		robot.leftClickMenuItem("XBRL", "Namespace");
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	@Test 
	public void testEditExistingTaxonomyNamespace() {
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "Namespace");
		delay(200);
		robot.leftClickOnString("altova.com", DEFAULT_CONTENT_FONT);
		delay(200);
		robot.keyType(VK_F2);
		delay(200);
		robot.typeString("nanonull2");
		delay(200);
		robot.clickButton("OK");
		robot.leftClickMenuItem("XBRL", "Namespace");
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	
	@Test 
	public void testDeleteExistingTaxonomyNamespace() {
		robot.openFile(tmpDir+"\\nanonull_7_2\\nanonull.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "Namespace");
		delay(200);
		robot.leftClickOnString("altova.com", DEFAULT_CONTENT_FONT);
		delay(200);
		robot.clickButton("Delete");
		delay(200);
		robot.clickButton("OK");
		robot.leftClickMenuItem("XBRL", "Namespace");
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	
	
	@Test 
	public void testSetTargetNamespace() {
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "Set Target Namespace");
		delay(200);
		robot.typeString("nanonull2");
		robot.keyType(VK_TAB);
		delay(200);
		robot.typeString("http://www.altova.com/nanonull2");
		robot.clickButton("OK");
		robot.leftClickOnString("Show All Files", DEFAULT_CONTENT_FONT);
		delay(200);
		robot.leftClickOnString("Limit to nanonull", DEFAULT_CONTENT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test 
	public void testImportUsGapp2011Taxonomy() {
		robot.newFile("Taxonomy");
		robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "None");
		robot.leftClickMenuItem("XBRL", "Import/Reference");
		robot.clickButton("Next");
		Rectangle rec = robot.getStringRectangle("Insurance", XBRL_CONTENT_FONT);
		rec.x = rec.x -33;
		robot.leftClickMid(rec);
		delay(200);
		robot.clickButton("Finish");
		for (int i =0; i<8; i++)
			delay(10000); //need really long time to load all taxonomies
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testImportIFRSTaxonomy() {
		robot.newFile("Taxonomy");
		robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "None");
		robot.leftClickMenuItem("XBRL", "Import/Reference");
		robot.keyType(VK_TAB);
		delay(200);
		robot.keyType(VK_PAGE_DOWN);
		robot.clickButton("Next");
		robot.typeString(tmpDir+ "\\ifrs_20110325\\combined_entry_point_2011-03-25.xsd");
		robot.clickButton("Finish");
		delay(10000); //need really long time to load all taxonomies
		delay(10000);
		delay(10000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testImportReferenceSchema() {
		robot.newFile("Taxonomy");
		robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "None");
		robot.leftClickMenuItem("XBRL", "Import/Reference");
		robot.leftClickOnString("Reference Schema", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_TAB);
		robot.typeString(tmpDir+"\\nanonull.xsd");
		robot.clickButton("Finish");
		delay(10000);
		robot.leftClickOnString("Show All Files", DEFAULT_CONTENT_FONT);
		delay(200);
		robot.leftClickOnString("Limit to file", DEFAULT_CONTENT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test 
	public void testImportReferenceLinkbase() {
		robot.newFile("Taxonomy");
		robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "None");
		robot.leftClickMenuItem("XBRL", "Import/Reference");
		robot.leftClickOnString("Reference Linkbase", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_TAB);
		robot.typeString(tmpDir+"\\nanonull_pre.xml");
		robot.clickButton("Finish");
		delay(10000);
		robot.leftClickOnString("Show All Files", DEFAULT_CONTENT_FONT);
		delay(200);
		robot.leftClickOnString("Limit to file", DEFAULT_CONTENT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW);
	}

	@Test 
	public void testGenerateDocumentation() {
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "Generate");
		delay(200);
		robot.clickButton("OK");
		delay(2000);
		robot.typeString("c:\\temp\\debug\\out.html");
		robot.clickButton("Save");
		delay(10000);
		robot.escapeDialog("Confirm Save As", VK_Y);
		delay(10000);
		delay(10000);
		delay(10000);
		delay(10000);
		delay(10000);
		delay(10000);
		assertFileExists(new File("c:\\temp\\debug\\out.html"));
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	

	// Find Window
	
	
	@Test 
	public void testFindLabelText() {
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.findXbrlAdvanced("Legal Entity [Axis]","Label Texts");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test 
	public void testFindLabelLanguages() {
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.findXbrlAdvanced("en-Us","Label Languages");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testFindLabelRoles() {
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.findXbrlAdvanced("http://www.xbrl.org/2003/role/verboseLabel","Label Roles");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testFindLabelLinkRoles() {
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.findXbrlAdvanced("http://www.xbrl.org/2003/role/linkel","Label Link Roles");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testFindReferenceLinkRoles() {
		robot.openFile(tmpDir+"\\Nanonull_find\\nanonull.xsd");
		delay(10000);
		robot.findXbrlAdvanced("http://www.xbrl.org/2003/role/lin","Reference Link Roles");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testFindReference() {
		robot.openFile(tmpDir+"\\Nanonull_find\\nanonull.xsd");
		delay(10000);
		robot.findXbrlAdvanced("http://www.xbrl.org/2003/role/disclosureRef","References");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testFindReferencePart() {
		robot.newFile("Taxonomy");
		robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "US-GAAP 2011");
		robot.clickButton("Next");
		Rectangle rec = robot.getStringRectangle("Real Estate", XBRL_CONTENT_FONT);
		rec.x = rec.x -38;
		robot.leftClickMid(rec);
		robot.clickButton("Finish");
		robot.switchXBRLTab_Presentation();
		delay(5000);
		robot.findXbrlAdvanced("Regulation S-X (SX)","Reference Part");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	
	@Test 
	public void testFindLinkbaseLinkRole() {
		robot.openFile(tmpDir+"\\Nanonull_find\\nanonull.xsd");
		delay(10000);
		robot.switchXBRLTab_Definitions();
		robot.findXbrlAdvanced("nanonull","Linkbase Link Roles");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testFindRegularExpresion() {
		robot.openFile(tmpDir+"\\Nanonull_find\\nanonull.xsd");
		delay(10000);
		robot.leftClickMenuItem("Edit","Find");
		robot.typeString("nano..l");
		try{
			robot.clickButton("Advanced >>");
		}catch (ImageNotFoundException e){}
		robot.clickButton("Select all");
		
		Options opt = new Options();
		opt.add(new CheckboxOption("Regular", true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		opt.applyOption(robot);
		robot.clickButton("Find &All");
		assertAreas(DIAGRAM_MAIN_WINDOW,FIND_IN_XBRL);
	}
	
	
	
	// XBRL View Setting run as last

	@Test 
	public void testExpandedQualifiedName() {
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "View Settings");
		delay(200);
		robot.setOptions(new RadioOption("Expanded"));
		robot.clickButton("OK");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testLabelQualifiedName() {
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "View Settings");
		delay(200);
		robot.setOptions(new RadioOption("Label"));
		robot.clickButton("OK");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test 
	public void testShortQualifiedName() {
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "View Settings");
		delay(200);
		robot.setOptions(new RadioOption("Short"));
		robot.clickButton("OK");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testExpandElement1() {
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "View Settings");
		delay(200);
		//robot.setOptions(new RadioOption("Component"));
		//robot.setOptions(new RadioOption("Labels "));
		//robot.setOptions(new RadioOption("References"));
		
		Options opt = new Options();
		opt.add(new CheckboxOption("Component", true));
		opt.add(new CheckboxOption("Labels", false));
		opt.add(new CheckboxOption("References", false));
		opt.applyOption(robot);
		robot.clickButton("OK");
		robot.reloadFile();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	

	
	@Test 
	public void testExpandElement2() {
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "View Settings");
		delay(200);
		Options opt = new Options();
		opt.add(new CheckboxOption("Component", true));
		opt.add(new CheckboxOption("Labels", true));
		opt.add(new CheckboxOption("References", true));
		opt.applyOption(robot);
		robot.clickButton("OK");
		robot.reloadFile();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test 
	public void testLabelDefaults() {
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "View Settings");
		delay(200);
		Options opt = new Options();
		opt.add(new CheckboxOption("Component", true));
		opt.add(new CheckboxOption("Labels", true));
		opt.applyOption(robot);
		
		Rectangle rec = robot.getStringRectangle("link", MS_SHELL_DLG_FONT);
		robot.leftClickMidVar(rec, +70);
		robot.typeString("http://www.xbrl.org/2004/role/lin2");
		delay(5000);
		rec = robot.getStringRectangle("language", MS_SHELL_DLG_FONT);
		robot.leftClickMidVar(rec, +70);
		delay(5000);
		robot.typeString("fr");
		robot.keyType(VK_TAB);
		delay(5000);
		robot.typeString("http://www.xbrl2.org/2006/role/label3");
		delay(5000);
		robot.clickButton("OK");
		robot.reloadFile();
		robot.rightClickMidVar(robot.findImage(label), +10);
		robot.leftClickOnString("Add Label", WINDOWS_DEFAULT_FONT);

		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	//Added to end because of changing setting
	@Test 
	public void testRelationshipsDeleteLabelLinkrole() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "View Settings");
		delay(200);
		Options opt = new Options();
		opt.add(new CheckboxOption("Component", true));
		opt.add(new CheckboxOption("Labels", true));
		opt.add(new CheckboxOption("References", true));
		opt.applyOption(robot);
		robot.clickButton("OK");
		robot.reloadFile();
		
		robot.switchXBRLTab_Definitions();
		delay(500);
		robot.leftClickOnString("Segment", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		robot.rightClickOnString("en-US", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_UP);
		robot.keyType(VK_ENTER);
		robot.rightClickOnString("www.xbrl.org", WINDOWS_DEFAULT_FONT);
		robot.leftClickOnString("Delete Label Linkrole", WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test 
	public void testPresentationDeleteLabelLinkrole() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "View Settings");
		delay(200);
		Options opt = new Options();
		opt.add(new CheckboxOption("Component", true));
		opt.add(new CheckboxOption("Labels", true));
		opt.add(new CheckboxOption("References", true));
		opt.applyOption(robot);
		robot.clickButton("OK");
		robot.reloadFile();
		
		robot.switchXBRLTab_Presentation();
		delay(500);
		robot.leftClickOnString("Segment", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		robot.rightClickOnString("en-US", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_UP);
		robot.keyType(VK_ENTER);
		robot.rightClickOnString("www.xbrl.org", WINDOWS_DEFAULT_FONT);
		robot.leftClickOnString("Delete Label Linkrole", WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test 
	public void testCalculationDeleteLabelLinkrole() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "View Settings");
		delay(200);
		Options opt = new Options();
		opt.add(new CheckboxOption("Component", true));
		opt.add(new CheckboxOption("Labels", true));
		opt.add(new CheckboxOption("References", true));
		opt.applyOption(robot);
		robot.clickButton("OK");
		robot.reloadFile();
		
		robot.switchXBRLTab_Calculation();
		delay(500);
		robot.leftClickOnString("FlowsIndirect", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_PLUS);
		robot.rightClickOnString("en-US", WINDOWS_DEFAULT_FONT);
		robot.keyType(VK_UP);
		robot.keyType(VK_ENTER);
		robot.rightClickOnString("www.xbrl.org", WINDOWS_DEFAULT_FONT);
		robot.leftClickOnString("Delete Label Linkrole", WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test 
	public void testPresentationOverrideRemoveArc() {
		
		robot.openFile(tmpDir+"\\Nanonull\\nanonull.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "View Settings");
		delay(200);
		Options opt = new Options();
		opt.add(new CheckboxOption("Component", true));
		opt.add(new CheckboxOption("Labels", true));
		opt.add(new CheckboxOption("References", true));
		opt.applyOption(robot);
		robot.clickButton("OK");
		robot.reloadFile();
		robot.switchXBRLTab_Presentation();
		delay(500);
		robot.leftClickOnString("Segment", WINDOWS_DEFAULT_FONT);
		robot.keyTypeShift(VK_PLUS);
		robot.rightClickImage(downCube);
		robot.leftClickOnString("Override Arc", WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test 
	public void testImportReference() {
		
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.rightClickOnString("nanonull_cal", DEFAULT_CONTENT_FONT_BOLD,"Overview");
		delay(300);
		robot.leftClickOnString("Import", WINDOWS_DEFAULT_FONT);
		delay(300);
		robot.clickButton("Next");
		Rectangle rec = robot.getStringRectangle("Insurance", XBRL_CONTENT_FONT);
		rec.x = rec.x -33;
		robot.leftClickMid(rec);
		delay(200);
		robot.clickButton("Finish");
		for (int i =0; i<8; i++)
			delay(10000); //need really long time to load all taxonomies
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW);
	}
	
	@Test 
	public void testSetTargetNamespaceOverviewMenu() {
		
		robot.openFile(tmpDir+"\\nanonull.xsd");
		delay(10000);
		robot.rightClickOnString("nanonull", DEFAULT_CONTENT_FONT,"Overview");
		delay(300);
		robot.leftClickOnString("Set Target Namespace", WINDOWS_DEFAULT_FONT);
		delay(300);
		robot.typeString("nanonull2");
		robot.keyType(VK_TAB);
		robot.typeString("http://www.altova.com/nanonull");
		robot.clickButton("OK");
		
		robot.leftClickOnString("Show All Files", DEFAULT_CONTENT_FONT);
		delay(200);
		robot.leftClickOnString("Limit to nanonull", DEFAULT_CONTENT_FONT);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test 
	public void testSettingDefaultLinkbaseFiles() {
		
		robot.openFile(tmpDir+"\\TC4_3\\TC4_3.xsd");
		delay(10000);
		String[] files ={"TC4_3_cal","TC4_3_def","TC4_3_lab","TC4_3_pre"};
		String[] fileTypes ={"Calculation","Definition","Label","Presentation"};
		for(int i =0; i< files.length; i++){
			robot.rightClickOnString(files[i], WINDOWS_DEFAULT_FONT,"Overview");
			delay(000);
			robot.leftClickOnString("Set Default Linkbase", WINDOWS_DEFAULT_FONT);
			delay(200);
			robot.leftClickOnString(fileTypes[i], WINDOWS_DEFAULT_FONT);
			delay(200);
		}
		
		robot.rightClickOnString("TC4_3_ref", WINDOWS_DEFAULT_FONT,"Overview");
		delay(3000);
		robot.leftClickOnString("Set Default Linkbase", WINDOWS_DEFAULT_FONT);
		delay(200);
		robot.keyType(VK_RIGHT);
		delay(200);
		robot.keyType(VK_UP);
		delay(200);
		robot.keyType(VK_ENTER);
		delay(200);
		assertAreas(OVERVIEW);
	}
	
	@Test 
	public void testSettingLinkbaseKindFiles() {
		
		robot.openFile(tmpDir+"\\TC4_3\\TC4_3.xsd");
		delay(10000);
		String[] files ={"TC4_3_cal","TC4_3_def","TC4_3_lab","TC4_3_ref"};
		String[] fileTypes ={"Presentation","Calculation","Definition","Label"};
		for(int i =0; i< files.length; i++){
			robot.rightClickOnString(files[i], WINDOWS_DEFAULT_FONT,"Overview");
			delay(000);
			robot.leftClickOnString("Set Linkbase Kind", WINDOWS_DEFAULT_FONT);
			delay(200);
			robot.leftClickOnString(fileTypes[i], WINDOWS_DEFAULT_FONT);
			delay(200);
		}
		
		robot.rightClickOnString("TC4_3_pre", WINDOWS_DEFAULT_FONT,"Overview");
		delay(300);
		robot.leftClickOnString("Set Linkbase Kind", WINDOWS_DEFAULT_FONT);
		delay(200);
		robot.keyType(VK_RIGHT);
		delay(200);
		robot.keyType(VK_UP);
		delay(200);
		robot.keyType(VK_ENTER);
		delay(200);
		assertAreas(OVERVIEW);
	}
	
	
	//Add this test as a last test because of changing color.
	@Test 
	public void testAssignColorTaxonomyNamespace() {
		robot.openFile(tmpDir+"\\nanonull_7_2\\nanonull.xsd");
		delay(10000);
		robot.leftClickMenuItem("XBRL", "Namespace");
		delay(200);
		robot.leftClickOnString("us-gaap", DEFAULT_CONTENT_FONT);
		Rectangle rec = robot.getStringRectangle("us-gaap", DEFAULT_CONTENT_FONT);
		rec.x = rec.x +400;
		robot.leftClickMid(rec);
		delay(1000);
		robot.leftClick();
		delay(1000);
		robot.leftClickImage(red);
		robot.clickButton("OK");
		delay(200);
		robot.clickButton("OK");
		robot.leftClickOnString("Show All Files", DEFAULT_CONTENT_FONT);
		delay(200);
		robot.leftClickOnString("us-gaap", DEFAULT_CONTENT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW);

	}
	
	@Test 
	public void testFormulaTabAddNewAssertionSet() {
		robot.newFile("Taxonomy");
		robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "None");
		robot.switchXBRLTab_Formula();
		robot.leftClickImage(newElementIco);
		robot.leftClickOnString("Add New Assertion Set", WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
	}
	
	@Test 
	public void testFormulaTabAddNewAssertion() {
		robot.newFile("Taxonomy");
		robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "None");
		robot.switchXBRLTab_Formula();
		robot.leftClickImage(newElementIco);
		robot.moveMouseToString("Add New Assertion Set", WINDOWS_DEFAULT_FONT);
		delay(2000);
		robot.keyPress(VK_DOWN);
		robot.keyPress(VK_DOWN);
		robot.keyPress(VK_RIGHT);
		robot.keyPress(VK_ENTER);
		robot.cancelButton();
		
		robot.leftClickImage(newElementIco);
		robot.moveMouseToString("Add New Assertion Set", WINDOWS_DEFAULT_FONT);
		delay(2000);
		robot.keyPress(VK_DOWN);
		robot.keyPress(VK_DOWN);
		robot.keyPress(VK_RIGHT);
		robot.keyPress(VK_DOWN);
		robot.keyPress(VK_ENTER);
		robot.cancelButton();
		
		
		robot.leftClickImage(newElementIco);
		robot.moveMouseToString("Add New Assertion Set", WINDOWS_DEFAULT_FONT);
		delay(2000);
		robot.keyPress(VK_DOWN);
		robot.keyPress(VK_DOWN);
		robot.keyPress(VK_RIGHT);
		robot.keyPress(VK_DOWN);
		robot.keyPress(VK_DOWN);
		robot.keyPress(VK_ENTER);
		robot.cancelButton();
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
		
	}
	
	
	@Test 
	public void testFormulaTabAddFPG() {
		robot.newFile("Taxonomy");
		robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "None");
		robot.switchXBRLTab_Formula();
		robot.leftClickImage(newElementIco);
		robot.leftClickOnString("Add New Formula", WINDOWS_DEFAULT_FONT);
		robot.cancelButton();
		robot.leftClickImage(newElementIco);
		robot.leftClickOnString("Add New Parameter", WINDOWS_DEFAULT_FONT);
		robot.leftClickImage(newElementIco);
		robot.leftClickOnString("Add New General Variable", WINDOWS_DEFAULT_FONT);
		robot.cancelButton();
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
	}
	
	@Test 
	public void testFormulaTabAddPFE() {
		robot.newFile("Taxonomy");
		robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "None");
		robot.switchXBRLTab_Formula();
		robot.leftClickImage(newElementIco);
		robot.leftClickOnString("Add New Precondition", WINDOWS_DEFAULT_FONT);
		robot.cancelButton();
		robot.leftClickImage(newElementIco);
		robot.leftClickOnString("Add New Function", WINDOWS_DEFAULT_FONT);
		robot.leftClickImage(newElementIco);
		robot.leftClickOnString("Add New Equality Definition", WINDOWS_DEFAULT_FONT);
		robot.cancelButton();
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
	}
	

}

