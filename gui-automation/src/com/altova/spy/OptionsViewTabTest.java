package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.spy.SpyRobot.XSL_OUTLINE;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.nativegui.ComponentInfo;
import com.altova.nativegui.NativeGUI;
import com.altova.robots.CheckboxOption;
import com.altova.robots.RadioOption;
import com.altova.util.IOUtils;

public class OptionsViewTabTest extends AbstractSpyOptionsDialogTest {

	@Test
	public void testShowAttributePreviewsOff() {
		CheckboxOption c = new CheckboxOption("Show attribute previews", false, "Enhanced Grid view", null, null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testShowAttributePreviewsOn() {

		CheckboxOption c = new CheckboxOption("Show attribute previews", true, "Enhanced Grid view", null, null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAutomProvideOptWidthsOn() {
		CheckboxOption c = new CheckboxOption("Automatically provide optimal widths", true, "Enhanced Grid view", null, null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAutomProvideOptWidthsOff() {
		CheckboxOption c = new CheckboxOption("Automatically provide optimal widths", false, "Enhanced Grid view", null, null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testLimitOptimalWidth() {
		CheckboxOption c = new CheckboxOption("Automatically provide optimal widths", true, "Enhanced Grid view", null, null, "View",MS_SHELL_DLG_FONT);
		CheckboxOption w = new CheckboxOption("Limit optimal width to", true);
		c.applyOption(robot);
		w.applyOption(robot);
		delay(500);
		robot.keyType(KeyEvent.VK_ENTER);
		delay(500);
		robot.typeString("5");
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}


	@Test
	public void testLimitOptimalHeight() {
		CheckboxOption c = new CheckboxOption("Automatically provide optimal widths", false, "Enhanced Grid view", null, null, "View",MS_SHELL_DLG_FONT);
		CheckboxOption w = new CheckboxOption("Limit cell height to", true);
		c.applyOption(robot);
		w.applyOption(robot);
		delay(500);
		robot.keyType(KeyEvent.VK_ENTER);
		delay(500);
		robot.typeString("1");
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testLimitOptimalHeightOff() {
		CheckboxOption c = new CheckboxOption("Limit cell height to", false, "Enhanced Grid view", null, null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testUseIndentationOff() {
		CheckboxOption c = new CheckboxOption("Use Indentation",false);
		robot.applyOptionsEnter("Options", c);
		robot.textView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testUseIndentationOn() {
		CheckboxOption c = new CheckboxOption("Use Indentation",true);
		robot.applyOptionsEnter("Options", c);
		robot.textView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Ignore //This option has been removed from the options dialog
	@Test
	public void testWordWrappingOff() {
		
		CheckboxOption c = new CheckboxOption("Word wrapping", false, "Text view", null, null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.gridView();
		robot.textView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Ignore //This option has been removed from the options dialog
	@Test
	public void testWordWrappingOn() {
		CheckboxOption c = new CheckboxOption("Word wrapping", true, "Text view", null, null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.gridView();
		robot.textView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Ignore //	This option has been removed from the options dialog
	@Test
	public void testPrettyPrintOn() {
		RadioOption c = new RadioOption("No", "Pretty-print");
		robot.applyOptionsEnter("Options", c);
		robot.textView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Ignore //	This option has been removed from the options dialog
	@Test
	public void testPrettyPrintWithSpaces() {
		RadioOption c = new RadioOption("With", "Pretty-print", null, null, "View",MS_SHELL_DLG_FONT);
		c.applyOption(robot);
		delay(500);
		robot.keyType(KeyEvent.VK_RIGHT);
		delay(500);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.textView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Ignore //	This option has been removed from the options dialog
	@Test
	public void testPrettyPrintWithTabs() {
		RadioOption c = new RadioOption("With Tabs", "Pretty-print", null, null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.textView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testWindowTitleFullPath() {
		RadioOption c = new RadioOption("Full path name", "Window title", null, null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		ComponentInfo ci = NativeGUI.getForegroundWindowInfo();
		assertEquals("Altova XMLSpy - [" + ORGCHART_XML_FILE.getAbsolutePath() + "]",ci.getWindowText());
	}

	@Test
	public void testWindowTitleFilename() {
		RadioOption c = new RadioOption("File name only", "Window title", null, null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		ComponentInfo ci = NativeGUI.getForegroundWindowInfo();
		assertEquals("Altova XMLSpy - [" + ORGCHART_XML_FILE.getName() + "]",ci.getWindowText());
	}

	@Test
	public void testWindowAuthenticSaveLinkOff() {
		CheckboxOption c = new CheckboxOption("Always open files in Authentic view", false, "Authentic view", null, null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.closeFile();
		robot.openFile(ORGCHART_XML_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testWindowAuthenticSaveLinkOn() {
		CheckboxOption c = new CheckboxOption("Always open files in Authentic view", true, "Authentic view", null, null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.closeFile();
		robot.openFile(ORGCHART_XML_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testShowInASeparateWindowOn() {
		CheckboxOption c = new CheckboxOption("Show in a separate window by default", true, "Browser view", null, null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.browserView();
		robot.textView();
		robot.showAllWindows();
		assertWindowAndEscape();
	}

	@Test
	public void testShowInASeparateWindowOff() {
		CheckboxOption c = new CheckboxOption("Show in a separate window by default", false, "Browser view", null, null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.browserView();
		robot.windowTileVertically();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
}
