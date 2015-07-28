package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.spy.SpyRobot.ATTRIBUTES;
import static com.altova.spy.SpyRobot.ELEMENTS;
import static com.altova.spy.SpyRobot.ENTITIES;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;
import java.awt.event.KeyEvent;

import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;
import com.altova.util.ClipboardUtils;
import com.altova.util.IOUtils;

public class OptionsEditingTabTest extends AbstractSpyOptionsDialogTest {

	@Test //it does not work well, but #24410 reflected the problem and it won't be fixed
	public void testShowEntryHelpersOff() {
		CheckboxOption c = new CheckboxOption("Show entry helpers", false, "Intelligent editing", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.textView();
		assertNull(robot.findComponent("Elements", null, null));
		assertNull(robot.findComponent("Attributes", null, null));
		assertNull(robot.findComponent("Entities", null, null));
	}

	@Test //it does not work well, but #24410 reflected the problem and it won't be fixed
	public void testShowEntryHelpersOn() {
		CheckboxOption c = new CheckboxOption("Show entry helpers", true, "Intelligent editing", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.textView();
		assertAreas(ELEMENTS,ATTRIBUTES,ENTITIES);
	}

	@Test
	public void testLoadEntryHelperUponOpeningOff() {
		CheckboxOption c = new CheckboxOption("Load entry helpers upon opening file", false, "Intelligent editing", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.openFile(ORGCHART_XML_FILE);
		robot.gridView();
		robot.xpathEvaluation("OrgChart/Name");
		assertAreas(ELEMENTS, ENTITIES);
	}

	@Test
	public void testLoadEntryHelperUponOpeningOn() {
		CheckboxOption c = new CheckboxOption("Load entry helpers upon opening file", true, "Intelligent editing", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.openFile(ITEMS_XML_FILE);
		assertAreas(ELEMENTS, ENTITIES);
	}

	@Test
	public void testSortAttributesOff() {
		CheckboxOption c = new CheckboxOption("Attributes", false, "Intelligent editing", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.openFile(SCHEMA_NILLABLE_XSD_FILE);
		robot.generateSampleXML(null);
		robot.gridView();
		robot.xpathHighlight("/test/e1/@e11");
		robot.textView();
		robot.delay(500);
		robot.keyType(KeyEvent.VK_LEFT);robot.delay(500);
		robot.keyType(KeyEvent.VK_SPACE);
		assertAreas(ATTRIBUTES);
	}

	@Test
	public void testSortAttributesOn() {
		CheckboxOption c = new CheckboxOption("Attributes", true, "Intelligent editing", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.openFile(SCHEMA_NILLABLE_XSD_FILE);
		robot.generateSampleXML(null);
		robot.gridView();
		robot.xpathHighlight("/test/e1/@e11");
		robot.textView();
		robot.delay(500);
		robot.keyType(KeyEvent.VK_LEFT);robot.delay(500);
		robot.keyType(KeyEvent.VK_SPACE);
		assertAreas(ATTRIBUTES);
	}

	@Test
	public void testSortElementsOn() {
		CheckboxOption c = new CheckboxOption("Elements", true, "Intelligent editing", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.openFile(SCHEMA_NILLABLE_XSD_FILE);
		robot.generateSampleXML(null);
		robot.gridView();
		robot.xpathHighlight("/test/e4");
		robot.textView();
		robot.delay(500);
		robot.keyType(KeyEvent.VK_LEFT);
		assertAreas(ELEMENTS);
	}

	@Test
	public void testSortElementsOff() {
		CheckboxOption c = new CheckboxOption("Elements", false, "Intelligent editing", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.openFile(SCHEMA_NILLABLE_XSD_FILE);
		robot.generateSampleXML(null);
		robot.gridView();
		robot.xpathHighlight("/test/e4");
		robot.textView();
		robot.delay(500);
		robot.keyType(KeyEvent.VK_LEFT);
		assertAreas(ELEMENTS);
	}

	@Test
	public void testAutomAppendMandChildOff() {
		CheckboxOption c = new CheckboxOption("Auto-append mandatory children", false, "Intelligent editing", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		RadioOption format = new RadioOption("Schema   ");
		robot.newFile("Extensible Markup Language", format, "New file", SCHEMA_NILLABLE_XSD_FILE.getAbsolutePath(), null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	/*
	 * ex test "Minimize number of Elements" option in Editing: now is testing "Branch of choice
	 * with the smallest number of elements
	 */
	@Test
	public void testMinimizeNrOfElem() {
		CheckboxOption c = new CheckboxOption("Auto-append mandatory children", true, "Intelligent editing", null, null, "Editing",MS_SHELL_DLG_FONT);
		c.applyOption(robot);
		//since v2014 "Minimize number of elements" is not longer available
		//RadioOption b = new RadioOption("Minimize number of elements", "Intelligent editing");
		//and is replaced by "Branch of choice with.." 
		RadioOption b = new RadioOption("Branch of choice with the smallest number", "Intelligent editing");
		b.applyOption(robot);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		RadioOption format = new RadioOption("Schema   ");
		robot.newFile("Extensible Markup Language", format, "New file", SCHEMA_NILLABLE_XSD_FILE.getAbsolutePath(), null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	
	/*
	 * old test testGenerMandElemOnly() -option is not available anymore- 
	 * is replaced by testFirstBrachOfChoice()
	 */
	@Test
	public void testFirstBrachOfChoice() {
		CheckboxOption c = new CheckboxOption("Auto-append mandatory children", true, "Intelligent editing", null, null, "Editing",MS_SHELL_DLG_FONT);
		c.applyOption(robot);
		//since v2014 "Generate mandatory elements only" is not longer available
		//RadioOption b = new RadioOption("Generate mandatory elements only", "Intelligent editing");
		//and is replaced by "First branch of choice"
		RadioOption b = new RadioOption("First branch of choice", "Intelligent editing");
		b.applyOption(robot);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		RadioOption format = new RadioOption("Schema   ");
		robot.newFile("Extensible Markup Language", format, "New file", SCHEMA_NILLABLE_XSD_FILE.getAbsolutePath(), null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	/*
	 * old test testGenerAllElem() -option is not available anymore- 
	 * is replaced by testAllBrachesOfChoices()
	 */
	@Test
	public void testAllBrachesOfChoices() {
		CheckboxOption c = new CheckboxOption("Auto-append mandatory children", true, "Intelligent editing", null, null, "Editing",MS_SHELL_DLG_FONT);
		c.applyOption(robot);
		//since v2014 "Generate all elements" is not longer available
		//RadioOption b = new RadioOption("Generate all elements", "Intelligent editing");
		//and is replaced by "All branches of choice"
		RadioOption b = new RadioOption("All branches of choice", "Intelligent editing");
		b.applyOption(robot);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		RadioOption format = new RadioOption("Schema   ");
		robot.newFile("Extensible Markup Language", format, "New file", SCHEMA_NILLABLE_XSD_FILE.getAbsolutePath(), null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testGenerNonMandAttOn() {
		CheckboxOption a = new CheckboxOption("Auto-append mandatory children", true, "Intelligent editing", null, null, "Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		//RadioOption b = new RadioOption("Generate all elements", "Intelligent editing");
		RadioOption b = new RadioOption("All branches of choice", "Intelligent editing");
		b.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Generate non-mandatory Attributes", true, "Intelligent editing");
		c.applyOption(robot);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		RadioOption format = new RadioOption("Schema   ");
		robot.newFile("Extensible Markup Language", format, "New file", SCHEMA_NILLABLE_XSD_FILE.getAbsolutePath(), null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testGenerNonMandAttOff() {
		CheckboxOption a = new CheckboxOption("Auto-append mandatory children", true, "Intelligent editing", null, null, "Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		//RadioOption b = new RadioOption("Generate all elements", "Intelligent editing");
		RadioOption b = new RadioOption("All branches of choice", "Intelligent editing");
		b.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Generate non-mandatory Attributes", false, "Intelligent editing");
		c.applyOption(robot);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		RadioOption format = new RadioOption("Schema   ");
		robot.newFile("Extensible Markup Language", format, "New file", SCHEMA_NILLABLE_XSD_FILE.getAbsolutePath(), null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testTreatContNillabEleAsNonMandOn() {
		CheckboxOption a = new CheckboxOption("Auto-append mandatory children", true, "Intelligent editing", null, null, "Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		//RadioOption b = new RadioOption("Generate mandatory elements only", "Intelligent editing");
		RadioOption b = new RadioOption("First branch of choice", "Intelligent editing");
		b.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Treat element content of nillable", true, "Intelligent editing");
		c.applyOption(robot);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		RadioOption format = new RadioOption("Schema   ");
		robot.newFile("Extensible Markup Language", format, "New file", SCHEMA_NILLABLE_XSD_FILE.getAbsolutePath(), null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testTreatContNillabEleAsNonMandOff() {
		CheckboxOption a = new CheckboxOption("Auto-append mandatory children", true, "Intelligent editing", null, null, "Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		//RadioOption b = new RadioOption("Generate mandatory elements only", "Intelligent editing");
		RadioOption b = new RadioOption("First branch of choice", "Intelligent editing");
		b.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Treat element content of nillable", false, "Intelligent editing");
		c.applyOption(robot);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		RadioOption format = new RadioOption("Schema   ");
		robot.newFile("Extensible Markup Language", format, "New file", SCHEMA_NILLABLE_XSD_FILE.getAbsolutePath(), null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testTryNonAbstractTypeForXSITypeOff() {
		CheckboxOption c = new CheckboxOption("For elements with an abstract type", false, "Intelligent editing", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.openFile(IOUtils.findFile("examples/samplegen_option.xsd"));
		robot.generateSampleXML(null);
		robot.gridView();
		robot.xpathHighlight("/e/a");
		robot.textView();
		robot.typeString("<a>");
		robot.delay(2000);
		robot.typeString("<e>");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testTryNonAbstractTypeForXSITypeOn() {
		CheckboxOption c = new CheckboxOption("For elements with an abstract type", true, "Intelligent editing", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.openFile(IOUtils.findFile("examples/samplegen_option.xsd"));
		robot.generateSampleXML(null);
		robot.gridView();
		robot.xpathHighlight("/e/a");
		robot.textView();
		robot.typeString("<a>");
		robot.delay(2000);
		robot.typeString("<e>");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAutoCompleteOff() {
		CheckboxOption a = new CheckboxOption("Auto-complete in Text View", false, "Text View", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", a);
		robot.gridView();
		robot.xpathHighlight("OrgChart/Name");
		robot.textView();
		robot.keyType(KeyEvent.VK_END);
		robot.delay(500);
		robot.keyType(KeyEvent.VK_ENTER);
		robot.insertXMLElementTextView("eooo", null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAutoCompleteOn() {
		CheckboxOption a = new CheckboxOption("Auto-complete in Text View", true, "Text View", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", a);
		robot.gridView();
		robot.xpathHighlight("OrgChart/Name");
		robot.textView();
		robot.keyType(KeyEvent.VK_END);
		robot.delay(500);
		robot.keyType(KeyEvent.VK_ENTER);
		robot.insertXMLElementTextView("eooo", null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testSmartTableDetectionForRepElem() {
		RadioOption r = new RadioOption("Smart table detection for rep. elements", "Table view", null, null, "Editing",MS_SHELL_DLG_FONT
				);
		robot.applyOptionsEnter("Options", r);
		robot.openFile(IOUtils.findFile("examples/tablesInGridView.xml"));
		robot.gridView();
		robot.xpathHighlight("/root");
		robot.expandGrid();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testBuildTableForAnyRepElem() {
		RadioOption r = new RadioOption("Build table for any repeated elements", "Table view", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", r);
		robot.openFile(IOUtils.findFile("examples/tablesInGridView.xml"));
		robot.gridView();
		robot.xpathHighlight("/root");
		robot.expandGrid();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testShowSingleSubelemAsTableOn() {
		CheckboxOption c = new CheckboxOption("Show single table subelements as table", true, "Table view", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Office");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testShowSingleSubelemAsTableOff() {
		CheckboxOption c = new CheckboxOption("Show single table subelements as table", false, "Table view", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Office");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testNoAutomaticTableForElemList() {
		TextFieldOption t = new TextFieldOption("No automatic tables for elements:", true, "Office", "Table view", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", t);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Office[1]");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testDefaultCopyToClipboardGridView() {
		RadioOption r = new RadioOption("XML-Text", "Default copy to clipboard in Grid View as", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", r);
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Name");
		robot.copy();
		String clipboard = ClipboardUtils.getClipboardContents();
		assertEquals("<Name>Organization Chart</Name>", clipboard);
	}

	@Test
	public void testDefaultCopyAsStructuredTextGridView() {
		RadioOption r = new RadioOption("Structured text", "Default copy to clipboard in Grid View as", null, null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", r);
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Name");
		robot.copy();
		String clipboard = ClipboardUtils.getClipboardContents();
		assertEquals("Name\tOrganization Chart\n", clipboard);
	}
}
