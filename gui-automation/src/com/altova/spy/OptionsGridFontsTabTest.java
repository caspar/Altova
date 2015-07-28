package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.FontOption;
import com.altova.robots.FontOption.FontSettings;

public class OptionsGridFontsTabTest extends AbstractSpyOptionsDialogTest {
	/**
	 * As reported in #21303, use the same for all checkbox is not working, so
	 * we should take this into account for generating the images and for
	 * changing the default fonts accordingly
	 */

	@Test
	public void testGridFontElemNam() {

		Font myfont = new Font("Batang", Font.ITALIC, 11);
		Font deffont = new Font("Arial", Font.BOLD, 8);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, true, null, Color.RED);
		FontOption f = new FontOption("Element names", deffontset, newfont, true, true, "Grid fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testGridFontElemNamespaces() {

		Font myfont = new Font("Calibri", Font.BOLD, 10);
		Font deffont = new Font("Arial", Font.BOLD + Font.ITALIC, 8);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, false, null, Color.BLUE);
		FontOption f = new FontOption("Element namespaces", deffontset, newfont, true, false, "Grid fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testGridFontAttNames() {

		Font myfont = new Font("Times New Roman", Font.ITALIC, 12);
		Font deffont = new Font("Arial", Font.BOLD, 8);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, false, null, Color.GREEN);
		FontOption f = new FontOption("Attribute names", deffontset, newfont, false, true, "Grid fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.gridView();
		robot.xpathHighlight("/OrgChart");
		robot.expandGridFully();
		robot.textView();
		robot.gridView();
		robot.keyType(KeyEvent.VK_UP);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testGridFontAttNamespaces() {

		Font myfont = new Font("Courier New", Font.PLAIN, 9);
		Font deffont = new Font("Arial", Font.BOLD + Font.ITALIC, 8);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, true, null, Color.CYAN);
		FontOption f = new FontOption("Attribute namespaces", deffontset, newfont, false, false, "Grid fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.gridView();
		robot.xpathHighlight("/OrgChart");
		robot.expandGridFully();
		robot.textView();
		robot.gridView();
		robot.keyType(KeyEvent.VK_UP);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testGridFontAttPreviews() {

		Font myfont = new Font("Constantia", Font.BOLD + Font.ITALIC, 14);
		Font deffont = new Font("Arial", Font.PLAIN, 8);
		FontSettings deffontset = new FontSettings(deffont, false, Color.WHITE, Color.GRAY);
		FontSettings newfont = new FontSettings(myfont, true, null, Color.YELLOW);
		FontOption f = new FontOption("Attribute previews", deffontset, newfont, true, true, "Grid fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.gridView();
		robot.xpathHighlight("/OrgChart");
		robot.expandGridFully();
		robot.textView();
		robot.gridView();
		robot.keyType(KeyEvent.VK_UP);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testGridFontReservWords() {

		Font myfont = new Font("Cambria", Font.PLAIN, 15);
		Font deffont = new Font("Arial", Font.ITALIC, 8);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, false, null, Color.ORANGE);
		FontOption f = new FontOption("Reserved words", deffontset, newfont, true, true, "Grid fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testGridFontContents() {

		Font myfont = new Font("Tahoma", Font.BOLD + Font.ITALIC, 9);
		Font deffont = new Font("Arial", Font.PLAIN, 8);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, false, null, Color.PINK);
		FontOption f = new FontOption("Contents", deffontset, newfont, true, true, "Grid fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testGridFontTableRowNr() {

		Font myfont = new Font("Tahoma", Font.PLAIN, 17);
		Font deffont = new Font("Arial", Font.BOLD, 8);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, true, null, Color.RED);
		FontOption f = new FontOption("Table row number", deffontset, newfont, true, true, "Grid fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.gridView();
		robot.xpathHighlight("/OrgChart");
		robot.expandGridFully();
		robot.textView();
		robot.gridView();
		robot.keyType(KeyEvent.VK_UP);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

}
