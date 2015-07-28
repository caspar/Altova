package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.spy.SpyRobot.OVERVIEW;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;

import java.awt.Color;
import java.awt.Font;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.FontOption;
import com.altova.robots.FontOption.FontSettings;

public class OptionsWSDLFontsTabTest extends AbstractSpyOptionsDialogTest {
	/**
	 * As reported in #21303, use the same for all checkbox is not working, so
	 * we should take this into account for generating the images and for the
	 * default font that is being taken
	 */

	@Test
	public void testWSDLFontName() {
		Font myfont = new Font("Arial", Font.ITALIC, 8);
		Font deffont = new Font("Tahoma", Font.BOLD, 10); // please change
															// when ttp 23656
															// gets fixed
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, true, null, Color.RED);
		FontOption f = new FontOption("Name", deffontset, newfont, false, false, "WSDL fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(TIMESERVICE_WSDL);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testWSDLFontTitle() {
		Font myfont = new Font("Verdana", Font.BOLD, 11);
		Font deffont = new Font("Tahoma", Font.PLAIN, 8);
		FontSettings deffontset = new FontSettings(deffont, false, Color.WHITE, Color.GRAY);
		FontSettings newfont = new FontSettings(myfont, false, null, Color.BLUE);
		FontOption f = new FontOption("Title", deffontset, newfont, false, true, "WSDL fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(TIMESERVICE_WSDL);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testWSDLFontContent() {
		Font myfont = new Font("Times New Roman", Font.ITALIC, 12);
		Font deffont = new Font("Tahoma", Font.PLAIN, 8);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, false, null, Color.BLUE);
		FontOption f = new FontOption("Content", deffontset, newfont, true, false, "WSDL fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(TIMESERVICE_WSDL);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testWSDLFontDocumentation() {
		Font myfont = new Font("Papyrus", Font.PLAIN, 9);
		Font deffont = new Font("Tahoma", Font.ITALIC, 8);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, true, null, Color.PINK);
		FontOption f = new FontOption("Documentation", deffontset, newfont, true, true, "WSDL fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(TIMESERVICE_WSDL);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testWSDLFontSubLineTitle() {
		Font myfont = new Font("Lucida Console", Font.BOLD + Font.ITALIC, 10);
		Font deffont = new Font("Tahoma", Font.PLAIN, 8);
		FontSettings deffontset = new FontSettings(deffont, false, Color.WHITE, Color.GRAY);
		FontSettings newfont = new FontSettings(myfont, true, null, Color.ORANGE);
		FontOption f = new FontOption("Sub-line Title", deffontset, newfont, false, false, "WSDL fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(TIMESERVICE_WSDL);
		robot.xpathHighlight("/definitions/portType[@name=\'TimeServiceHttpGet\']/operation[@name=\'getServerTime\']");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testWSDLFontSubLineContent() {
		Font myfont = new Font("Courier New", Font.PLAIN, 12);
		Font deffont = new Font("Tahoma", Font.PLAIN, 8);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, false, null, Color.YELLOW);
		FontOption f = new FontOption("Sub-line Content", deffontset, newfont, false, false, "WSDL fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(TIMESERVICE_WSDL);
		robot.xpathHighlight("/definitions/portType[@name=\'TimeServiceSoap\']/operation[@name=\'getServerCity\']");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testWSDLFontSubLineError() {
		Font myfont = new Font("Arial", Font.BOLD + Font.ITALIC, 10);
		Font deffont = new Font("Tahoma", Font.ITALIC, 8);
		FontSettings deffontset = new FontSettings(deffont, false, Color.WHITE, Color.RED);
		FontSettings newfont = new FontSettings(myfont, false, null, Color.BLACK);
		FontOption f = new FontOption("Sub-line Error", deffontset, newfont, false, false, "WSDL fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(TIMESERVICE_WSDL);
		robot.appendSoapHeaderfaultInBinding(null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testWSDLFontOverviewTree() {
		Font myfont = new Font("Rockwell", Font.BOLD + Font.ITALIC, 14);
		Font deffont = new Font("Tahoma", Font.PLAIN, 8);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, false, null, Color.GREEN);
		FontOption f = new FontOption("Overview Tree", deffontset, newfont, false, false, "WSDL fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(TIMESERVICE_WSDL);
		assertAreas(OVERVIEW);
	}

}
