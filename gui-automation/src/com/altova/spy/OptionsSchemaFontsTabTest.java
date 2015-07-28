package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.spy.SpyRobot.COMPONENTS;
import static com.altova.spy.SpyRobot.DETAIL;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;

import java.awt.Color;
import java.awt.Font;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.FontOption;
import com.altova.robots.Options;
import com.altova.robots.RadioOption;
import com.altova.robots.FontOption.FontSettings;
import com.altova.util.IOUtils;

public class OptionsSchemaFontsTabTest extends AbstractSpyOptionsDialogTest {
	
	// Schema fonts => review, as with all other fonts, once they fix the ttp
	// 23484

	@Test
	@Ignore
	public void testSchemaFontName() {
		Font myfont = new Font("Courier New", Font.ITALIC, 14);
		Font deffont = new Font("Arial", Font.BOLD, 8);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, true, null, null);
		FontOption f = new FontOption("Name", deffontset, newfont, true, true, "Schema fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(ORGCHART_XSD_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	@Ignore
	public void testSchemaFontSubLineTitle() { // failing till they fix ttp
												// 23484
		Font myfont = new Font("Rockwell", Font.BOLD, 9);
		Font deffont = new Font("Arial", Font.PLAIN, 8);
		FontSettings deffontset = new FontSettings(deffont, false, Color.WHITE, Color.GRAY);
		FontSettings newfont = new FontSettings(myfont, false, null, Color.BLUE);
		FontOption f = new FontOption("Sub-line Title", deffontset, newfont, true, false, "Schema fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(ORGCHART_XSD_FILE);
		assertAreas(COMPONENTS, DETAIL);
	}

	@Test
	@Ignore
	public void testSchemaFontSubLineContent() {
		Font myfont = new Font("Papyrus", Font.ITALIC, 16);
		Font deffont = new Font("Sub-line Content", Font.PLAIN, 8);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, false, null, null);
		FontOption f = new FontOption("Sub-line Content", deffontset, newfont, false, true, "Schema fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(ORGCHART_XSD_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	@Ignore
	public void testSchemaFontMinMax() {
		Font myfont = new Font("Courier New", Font.PLAIN, 11);
		Font deffont = new Font("Arial", Font.PLAIN, 8);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, true, null, null);
		FontOption f = new FontOption("Max", deffontset, newfont, false, false, "Schema fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(ORGCHART_XSD_FILE);
		robot.xpathHighlight("/xsd:schema/xsd:element[@name=\'OrgChart\']");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	@Ignore
	public void testSchemaFontPointlessOcurr() {
		Font myfont = new Font("Times New Roman", Font.BOLD + Font.ITALIC, 10);
		Font deffont = new Font("Arial", Font.ITALIC, 8);
		FontSettings deffontset = new FontSettings(deffont, false, Color.WHITE, Color.GRAY);
		FontSettings newfont = new FontSettings(myfont, true, null, Color.MAGENTA);
		FontOption f = new FontOption("Pointless Occurrence", deffontset, newfont, false, false, "Schema fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(IOUtils.findFile("examples/pointless_ocurrence.xsd"));
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	@Ignore
	public void testSchemaFontAnnotation() { // it is failing at the moment
												// ttp 23484
		Font myfont = new Font("Rockwell", Font.PLAIN, 9);
		Font deffont = new Font("Tahoma", Font.PLAIN, 7);
		FontSettings deffontset = new FontSettings(deffont, false, Color.WHITE, Color.GRAY);
		FontSettings newfont = new FontSettings(myfont, false, null, Color.CYAN);
		FontOption f = new FontOption("Annotation", deffontset, newfont, false, false, "Schema fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(ORGCHART_XSD_FILE);
		robot.xpathHighlight("/xsd:schema/xsd:element[@name=\'Person\']");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	@Ignore
	public void testSchemaFontAttribConstraints() { // it is failing at the
													// moment ttp 23484
		Font myfont = new Font("Courier New", Font.BOLD + Font.ITALIC, 11);
		Font deffont = new Font("Arial", Font.ITALIC, 8);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, false, null, Color.GREEN);
		FontOption f = new FontOption("Attributes", deffontset, newfont, false, false, "Schema fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(IOUtils.findFile("examples/Constraints_example.xsd"));
		robot.xpathHighlight("/xsd:schema/xsd:element[@name=\'Customers\']");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	@Ignore
	public void testSchemaFontDocSchHead() { // it is failing at the moment
												// ttp 23484
		IOUtils.deleteAll(DOCUM_ABSPATH_FILE);
		assertFileNotExists(DOCUM_ABSPATH_FILE);
		Font myfont = new Font("Times New Roman", Font.BOLD, 10);
		Font deffont = new Font("Arial", Font.PLAIN, 11);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, true, null, Color.RED);
		FontOption f = new FontOption("Doc. Schema Header", deffontset, newfont, false, false, "Schema fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(ORGCHART_XSD_FILE);
		Options options=new Options();
		options.add(new RadioOption("HTML"));
		options.add(new CheckboxOption("Split output to multiple files",false));
		options.add(new CheckboxOption("Show result file after generation",true));
		robot.generateXSDDocumentation(DOCUM_ABSPATH_FILE.getParentFile(), DOCUM_ABSPATH_FILE.getName(),options);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	@Ignore
	public void testSchemaFontDocSchHead2() { // it is failing at the moment
												// ttp 23484
		IOUtils.deleteAll(DOCUM_ABSPATH_FILE);
		assertFileNotExists(DOCUM_ABSPATH_FILE);
		Font myfont = new Font("Papyrus", Font.ITALIC, 13);
		Font deffont = new Font("Arial", Font.BOLD, 11);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, true, null, Color.ORANGE);
		FontOption f = new FontOption("Doc. Schema Header2", deffontset, newfont, false, false, "Schema fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(ORGCHART_XSD_FILE);
		Options options=new Options();
		options.add(new RadioOption("HTML"));
		options.add(new CheckboxOption("Split output to multiple files",false));
		options.add(new CheckboxOption("Show result file after generation",true));
		robot.generateXSDDocumentation(DOCUM_ABSPATH_FILE.getParentFile(), DOCUM_ABSPATH_FILE.getName(),options);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	@Ignore
	public void testSchemaFontDocElemHead() { // it is failing at the moment
												// ttp 23484
		IOUtils.deleteAll(DOCUM_ABSPATH_FILE);
		assertFileNotExists(DOCUM_ABSPATH_FILE);
		Font myfont = new Font("Papyrus", Font.BOLD + Font.ITALIC, 12);
		Font deffont = new Font("Arial", Font.PLAIN, 10);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, false, null, Color.PINK);
		FontOption f = new FontOption("Doc. Element Header", deffontset, newfont, false, false, "Schema fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(ORGCHART_XSD_FILE);
		Options options=new Options();
		options.add(new RadioOption("HTML"));
		options.add(new CheckboxOption("Split output to multiple files",false));
		options.add(new CheckboxOption("Show result file after generation",true));
		robot.generateXSDDocumentation(DOCUM_ABSPATH_FILE.getParentFile(), DOCUM_ABSPATH_FILE.getName(),options);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	@Ignore
	public void testSchemaFontDocElemHead2() { // it is failing at the moment
												// ttp 23484
		IOUtils.deleteAll(DOCUM_ABSPATH_FILE);
		assertFileNotExists(DOCUM_ABSPATH_FILE);
		Font myfont = new Font("Consolas", Font.PLAIN, 12);
		Font deffont = new Font("Arial", Font.BOLD, 10);
		FontSettings deffontset = new FontSettings(deffont);
		FontSettings newfont = new FontSettings(myfont, false, null, Color.YELLOW);
		FontOption f = new FontOption("Doc. Element Header2", deffontset, newfont, false, false, "Schema fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", f);
		robot.openFile(ORGCHART_XSD_FILE);
		Options options=new Options();
		options.add(new RadioOption("HTML"));
		options.add(new CheckboxOption("Split output to multiple files",false));
		options.add(new CheckboxOption("Show result file after generation",true));
		robot.generateXSDDocumentation(DOCUM_ABSPATH_FILE.getParentFile(), DOCUM_ABSPATH_FILE.getName(),options);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

}
