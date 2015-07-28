package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.ZIP_VIEW;
import static com.altova.spy.SpyRobot.VALIDATION;
import static com.altova.spy.SpyRobot.XQUERY_FUNCTIONS;
import static com.altova.spy.SpyRobot.XQUERY_KEYBOARDS;
import static com.altova.spy.SpyRobot.XQUERY_VARIABLES;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;

import java.awt.event.KeyEvent;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.RadioOption;
import com.altova.util.IOUtils;

public class OptionsFileTypesTabTest extends AbstractSpyOptionsDialogTest {

	@Test
	public final void testAddNewFileExtension() {
		robot.addNewFileExtension(".blopez");
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.leftClickMenuItem("File", "New");
		delay(2000);
		robot.keyType(KeyEvent.VK_HOME);
		assertWindowAndEscape();
	}

	@Test
	public final void testSetXMLXMLConformance() {
		setOptionsAndXMLConformToNewExt(".blopez", "XML      ", "Grid view", null, false, null);
		robot.openFile(NEW_EXT_XML_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}

	@Test
	public final void testSetDTDXMLConformance() {
		setOptionsAndXMLConformToNewExt(".blopez", "DTD", "Text view", null, false, null);
		robot.openFile(IOUtils.findFile("examples/news.blopez"));
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}

	@Test
	public final void testSetXMLEntityXMLConformance() {
		setOptionsAndXMLConformToNewExt(".blopez", "XML Entity", "Text view", null, false, null);
		robot.openFile(NEW_EXT_XML_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}

	@Test
	public final void testSetXQueryConformance() {
		robot.addNewFileExtension(".blopez");
		robot.delay(3000);
		RadioOption c = new RadioOption("XQuery conformant", "Conformance", null, null, null,MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.openFile(IOUtils.findFile("examples/stringQ4.blopez"));
		assertAreas(XQUERY_KEYBOARDS, XQUERY_FUNCTIONS, XQUERY_VARIABLES, DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testSetZipConformance() {
		robot.addNewFileExtension(".blopez");
		robot.delay(3000);
		RadioOption c = new RadioOption("ZIP conformant", "Conformance", null, null, null,MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.openFile(IOUtils.findFile("examples/AltovaProductLineZIP.blopez"));
		robot.delay(1000);
		assertAreas(ZIP_VIEW);
	}

	@Test
	public final void testSetOtherConformance() {
		robot.addNewFileExtension(".blopez");
		robot.delay(3000);
		RadioOption c = new RadioOption("Other format", "Conformance", null, null, null,MS_SHELL_DLG_FONT);
		RadioOption defview = new RadioOption("Browser view", "Default view", null, null, null,MS_SHELL_DLG_FONT);
		c.applyOption(robot);
		delay(500);
		defview.applyOption(robot);
		delay(500);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.openFile(IOUtils.findFile("examples/Company.blopez"));
		robot.delay(1000);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}

	@Test
	public final void testGridViewAutomatBuildTablesOff() {
		setOptionsAndXMLConformToNewExt(".blopez", "XML      ", "Text view", "Build tables automatically", false, null);
		delay(500);
		robot.openFile(IOUtils.findFile("examples/items.blopez"));
		robot.gridView();
		robot.xpathHighlight("/items/item_tuple[1]");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testGridViewAutomatBuildTablesOn() {
		setOptionsAndXMLConformToNewExt(".blopez", "XML      ", "Text view", "Build tables automatically", true, null);
		delay(500);
		robot.openFile(IOUtils.findFile("examples/items.blopez"));
		robot.gridView();
		robot.xpathHighlight("/items/item_tuple[1]");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testTextViewUseSyntaxColoringOff() {
		setOptionsAndXMLConformToNewExt(".blopez", "XML      ", "Text view", "Use syntax coloring", false, null);
		delay(500);
		robot.openFile(NEW_EXT_XML_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testTextViewUseSyntaxColoringOn() {
		setOptionsAndXMLConformToNewExt(".blopez", "XML     ", "Text view", "Use syntax coloring", true, null);
		delay(500);
		robot.openFile(NEW_EXT_XML_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testDisableAutomaticValidationCheckOpenOn() {
		setOptionsAndXMLConformToNewExt(".blopez", "XML     ", "Text view", "Disable automatic validation", true, null);
		delay(500);
		robot.openFile(IOUtils.findFile("examples/Conditional_notvalid.blopez"));
		assertAreas(VALIDATION);
	}

	@Test
	public final void testDisableAutomaticValidationCheckSaveOn() {
		removeAndAssert(TEMPORARY_NEW_EXT);
		setOptionsAndXMLConformToNewExt(".blopez", "XML     ", "Text view", "Disable automatic validation", true, null);
		delay(500);
		robot.openFile(IOUtils.findFile("examples/Conditional_notvalid.blopez"));
		CheckboxOption c = new CheckboxOption("Disable automatic validation", false, null);
		robot.activateOptionsDialog();
		delay(4000);
		c.applyOption(robot);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.leftClickMenuItem("File","Save As");
		robot.escapeDialog("This file is not valid!", KeyEvent.VK_N);
		assertAreas(VALIDATION);
	}

	@Test
	public final void testDisableAutomaticValidationOff() {
		setOptionsAndXMLConformToNewExt(".blopez", "XML      ", "Text view", "Disable automatic validation", false, null);
		delay(500);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		delay(500);
		robot.openFile(IOUtils.findFile("examples/Conditional_notvalid.blopez"));
		assertAreas(VALIDATION);
	}

	@Test
	public final void testSaveEmptyElemInShortFormOff() {
		removeAndAssert(TEMPORARY_NEW_EXT);
		setOptionsAndXMLConformToNewExt(".blopez", "XML      ", "Text view", "Save empty elements in short", false, null);
		delay(500);
		robot.openFile(NEW_EXT_XML_FILE);
		robot.xpathHighlight("/Limousine/Type");
		robot.gridView();
		robot.keyType(KeyEvent.VK_DELETE);
		delay(500);
		robot.XMLInsertElement("Type", null);
		robot.saveFileAsNoControl(TEMPORARY_NEW_EXT.getAbsolutePath());
		robot.textView();
		assertAreas(DIAGRAM_MAIN_WINDOW);

	}

	@Test
	public final void testSaveEmptyElemInShortFormOn() {
		removeAndAssert(TEMPORARY_NEW_EXT);
		setOptionsAndXMLConformToNewExt(".blopez", "XML      ", "Text view", "Save empty elements in short", true, null);
		delay(500);
		robot.openFile(NEW_EXT_XML_FILE);
		robot.xpathHighlight("/Limousine/Type");
		robot.gridView();
		robot.keyType(KeyEvent.VK_DELETE);
		delay(500);
		robot.XMLInsertElement("Type", null);
		robot.saveFileAsNoControl(TEMPORARY_NEW_EXT.getAbsolutePath());
		robot.textView();
		assertAreas(DIAGRAM_MAIN_WINDOW);

	}

	private void setOptionsAndXMLConformToNewExt(String fileext, String conformance, String defView, String extraCheckOp, boolean valuecheckop, String sectionCheckop) {
		robot.addNewFileExtension(fileext);
		RadioOption gral = new RadioOption("XML conformant", "Conformance", null, null, null,MS_SHELL_DLG_FONT);
		RadioOption esp = new RadioOption(conformance, "Conformance", null, null, null,MS_SHELL_DLG_FONT);
		RadioOption defview = new RadioOption(defView, "Default view", null, null, null,MS_SHELL_DLG_FONT);
		gral.applyOption(robot);
		delay(500);
		esp.applyOption(robot);
		delay(500);
		defview.applyOption(robot);
		delay(500);
		if (extraCheckOp != null) {
			CheckboxOption checkboxop = new CheckboxOption(extraCheckOp, valuecheckop, sectionCheckop);
			checkboxop.applyOption(robot);
			delay(500);
		}
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		delay(500);

	}
}
