package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import java.awt.event.KeyEvent;

import org.junit.Test;

import com.altova.robots.DropDownOption;
import com.altova.util.IOUtils;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;;

public class OptionsEncodingTabTest extends AbstractSpyOptionsDialogTest{
	@Test
	public void testSetDefaultXMLEncoding() {
		DropDownOption c = new DropDownOption("Default encoding for new XML files", true, "GB2312 (Chinese)", null, null, null, "Encoding",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.newFile("Extensible Markup Language");
		robot.keyType(KeyEvent.VK_ESCAPE);
		delay(500);
		robot.activateOptionsDialog();
		DropDownOption d = new DropDownOption("Default encoding for new XML files", true, "Unicode UTF-8", null, null, null, "Encoding",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", d);
		assertAreas(DIAGRAM_MAIN_WINDOW);

	}

	@Test
	public void testOpenXMLWithUnknowEncoding() {
		DropDownOption c = new DropDownOption("Open XML files with unknown encoding as", true, "Unicode UTF-8", null, null, null, "Encoding",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.leftClickMenuItem("File", "Open");
		delay(1000);
		robot.typeFileName(IOUtils.findFile("examples/Russian_unknown_encoding.xml").getAbsolutePath());
		delay(3000);
		robot.keyType(KeyEvent.VK_ESCAPE);
		delay(500);
		assertWindowAndEscape();
	}

	@Test
	public void testOpenNonXMLWith() {
		DropDownOption c = new DropDownOption("Open non-XML files in", true, "EUC-JP (Japanese)", null, null, null, "Encoding",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.leftClickMenuItem("File", "Open");
		delay(1000);
		robot.typeFileName(IOUtils.findFile("examples/Russian_unknown_encoding.txt").getAbsolutePath());
		delay(3000);
		robot.keyType(KeyEvent.VK_ESCAPE);
		delay(500);
		assertWindowAndEscape();
	}

}
