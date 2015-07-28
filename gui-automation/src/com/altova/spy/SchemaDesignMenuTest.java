package com.altova.spy;


import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import java.awt.Font;
import java.awt.Rectangle;
import java.io.File;

import static com.altova.spy.SpyRobot.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.AltovaApplicationRobot;
import com.altova.robots.CheckboxOption;
import com.altova.robots.Options;
import com.altova.robots.Pane;
import com.altova.robots.RadioOption;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.IOUtils;
import com.altova.util.RegressionAssert;
import com.altova.util.Settings;
import com.altova.util.AltovaJUnitRunner.TestRobot;

//@TestRobot(VSnetSpyRobot.class)
//@TestRobot(EclipseSpyRobot.class)
public class SchemaDesignMenuTest extends AbstractXmlSpyTest {

	
	private static final String xpath = "/xsd:schema/xsd:element[@name='OrgChart']";
	
	private static final String BASE_OUT_DIR= Settings.getOutputDir().getAbsolutePath()+"\\"+AltovaJUnitRunner.getRunName(robot,"SchemaDesignMenuTest");
	private static final String BASE_EXPECTED_DIR=Settings.getExpectedDir().getAbsolutePath()+"\\"+AltovaJUnitRunner.getRunName(robot,"SchemaDesignMenuTest");
	private static final String DIAGRAM_FILENAME = "Diagram_Schema.png";
	private static final String DIAGRAM_ABSPATH =BASE_OUT_DIR+"\\"+DIAGRAM_FILENAME ;
	private static final File  DIAGRAM_ABSPATH_FILE = new File(DIAGRAM_ABSPATH);
	
	protected final File DOCUMENT_HTML_ONEFILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_HTML_Onefile");
	protected final File DOCUMENT_HTML_MULTIFILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_HTML_Multifile");

	protected final File DOCUMENT_WORD_EMF_EMBED_ONEFILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_WORD_EMF_Embed_Onefile");
	protected final File DOCUMENT_WORD_EMF_NOTEMBED_MULTIFILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_WORD_EMF_Notembed_Multifile");
	
	protected final File DOCUMENT_WORD_PNG_EMBED_MULTIFILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_WORD_PNG_Embed_Multifile");
	protected final File DOCUMENT_WORD_PNG_NOTEMBED_ONEFILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_WORD_PNG_Notembed_Onefile");
	
	protected final File DOCUMENT_RTF_EMF_EMBED_MULTIFILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_RTF_EMF_Embed_Multifile");
	protected final File DOCUMENT_RTF_EMF_NOTEMBED_ONEFILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_RTF_EMF_Notembed_Onefile");

	protected final File DOCUMENT_RTF_PNG_EMBED_ONEFILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_RTF_PNG_Embed_Onefile");
	protected final File DOCUMENT_RTF_PNG_NOTEMBED_MULTIFILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_RTF_PNG_Notembed_Multifile");
	private static final String DOCUM_FILENAME = "DocGenXSD";
	
	private static final String size = "150";
	private static final File EXAMPLES_TAMINO = IOUtils.findFile("spy/examples/BMW.tsd");

	


	@Before
	public void setUp() throws Exception {
		super.setUp();
		robot.openFile(ORGCHART_XSD_FILE);
	}

	@Test
	
	public void testSchemaSettings() {
		robot.schemaSettings();

	}

	@Test
	
	public void testSchemaSaveDiagram() {
		IOUtils.deleteAll(DIAGRAM_ABSPATH_FILE);
		assertFileNotExists(DIAGRAM_ABSPATH_FILE);
		robot.schemaSaveDiagram(xpath,BASE_OUT_DIR,DIAGRAM_FILENAME);
		assertFileExists(DIAGRAM_ABSPATH_FILE);
		assertImage(new File(BASE_EXPECTED_DIR+"\\"+DIAGRAM_FILENAME), DIAGRAM_ABSPATH_FILE);

	}

	@Test
	public void testGenerateXSDDocumentation_HTML_OneFile() {
		robot.openFile(TEXTSTATE_XSD_FILE);
		IOUtils.deleteAll(DOCUMENT_HTML_ONEFILE);
		String fullpath= DOCUMENT_HTML_ONEFILE.getAbsolutePath() + "\\"+DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+ ".html"));
		Options options=new Options();
		options.add(new RadioOption("HTML", "Output format", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation",true));
		robot.generateXSDDocumentation(DOCUMENT_HTML_ONEFILE,DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+ ".html"));
		assertAreas(DIAGRAM_MAIN_WINDOW);
		for (int i = 1; i < 4; i++) {
			assertImage(new File(BASE_EXPECTED_DIR+"\\testGenerateXSDDocumentation_HTML_Onefile\\"+DOCUM_FILENAME+"_p"+i+".png"), new File(fullpath+"_p"+i+".png"));
		}
	}

	@Test
	public void testGenerateXSDDocumentation_HTML_Multifile() {
		robot.openFile(TEXTSTATE_XSD_FILE);
		IOUtils.deleteAll(DOCUMENT_HTML_MULTIFILE);
		String fullpath=DOCUMENT_HTML_MULTIFILE.getAbsolutePath()+"\\"+DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+ "_italic.html"));
		Options options =new Options();
		options.add(new RadioOption("HTML", "Output format", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation",true));
		robot.generateXSDDocumentation(DOCUMENT_HTML_MULTIFILE,DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+ ".html"));
		assertFileExists(new File(fullpath+ "_bold.html"));
		assertFileExists(new File(fullpath+ "_italic.html"));
		assertFileExists(new File(fullpath+ "_TextType.html"));
		assertFileExists(new File(fullpath+ "_underline.html"));
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		for (int i = 1; i < 4; i++) {
			assertImage(new File(BASE_EXPECTED_DIR+"\\testGenerateXSDDocumentation_HTML_Multifile\\"+DOCUM_FILENAME+"_p"+i+".png"), new File(fullpath+"_p"+i+".png"));
		}
	}
	
	@Test
	public void testGenerateXSDDocumentation_WORD_PNG_Embed_Multifile() {
		robot.openFile(TEXTSTATE_XSD_FILE);
		IOUtils.deleteAll(DOCUMENT_WORD_PNG_EMBED_MULTIFILE);
		String fullpath=DOCUMENT_WORD_PNG_EMBED_MULTIFILE.getAbsolutePath()+"\\"+DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+"_bold.doc")); 
		Options options=new Options();
		options.add(new RadioOption(" Microsoft Word", null, null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new RadioOption("PNG", null, null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Embed diagrams",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation", false));
		robot.generateXSDDocumentation(DOCUMENT_WORD_PNG_EMBED_MULTIFILE,DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+".doc")); 
		assertFileExists(new File(fullpath+"_bold.doc"));
		assertFileExists(new File(fullpath+"_italic.doc"));
		assertFileExists(new File(fullpath+"_TextType.doc"));
		assertFileExists(new File(fullpath+"_underline.doc")); 
		for (int i = 1; i < 4; i++) {
			assertFileNotExists( new File(fullpath+"_p"+i+".png"));
		}
	}

	@Test
	public void testGenerateXSDDocumentation_WORD_PNG_NotEmbed_OneFile() {
		robot.openFile(TEXTSTATE_XSD_FILE);
		IOUtils.deleteAll(DOCUMENT_WORD_PNG_NOTEMBED_ONEFILE);
		String fullpath=DOCUMENT_WORD_PNG_NOTEMBED_ONEFILE.getAbsolutePath()+"\\"+DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+".doc"));
		Options options=new Options();
		
		options.add(new RadioOption(" Microsoft Word", null, null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new RadioOption("PNG", null, null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Embed diagrams",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation", false));
		robot.generateXSDDocumentation(DOCUMENT_WORD_PNG_NOTEMBED_ONEFILE,DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+".doc"));
		for (int i = 1; i < 4; i++) {
			assertImage(new File(BASE_EXPECTED_DIR+"\\testGenerateDocumentation_WORD_PNG_Notembed_Onefile\\"+DOCUM_FILENAME+"_p"+i+".png"), new File(fullpath+"_p"+i+".png"));
		}
	}
	
	@Test
	public void testGenerateXSDDocumentation_WORD_EMF_NotEmbed_Multifile() {
		robot.openFile(TEXTSTATE_XSD_FILE);
		IOUtils.deleteAll(DOCUMENT_WORD_EMF_NOTEMBED_MULTIFILE);
		String fullpath=DOCUMENT_WORD_EMF_NOTEMBED_MULTIFILE.getAbsolutePath()+"\\"+DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+"_italic.doc"));
		Options options=new Options();
		options.add(new RadioOption(" Microsoft Word", null, null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new RadioOption("EMF", null, null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Embed diagrams",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation", false));
		robot.generateXSDDocumentation(DOCUMENT_WORD_EMF_NOTEMBED_MULTIFILE,DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+".doc")); 
		assertFileExists(new File(fullpath+"_bold.doc"));
		assertFileExists(new File(fullpath+"_italic.doc"));
		assertFileExists(new File(fullpath+"_TextType.doc"));
		assertFileExists(new File(fullpath+"_underline.doc")); 
		for (int i = 1; i < 4; i++) {
			assertFileExists(new File(fullpath+"_p"+i+".emf"));
		}
	}

	@Test
	public void testGenerateXSDDocumentation_WORD_EMF_Embed_OneFile() {
		robot.openFile(TEXTSTATE_XSD_FILE);
		IOUtils.deleteAll(DOCUMENT_WORD_EMF_EMBED_ONEFILE);
		String fullpath=DOCUMENT_WORD_EMF_EMBED_ONEFILE.getAbsolutePath()+"\\"+DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+".doc"));
		Options options=new Options();
		options.add(new RadioOption(" Microsoft Word", null, null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new RadioOption("EMF", null, null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Embed diagrams",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation", false));
		robot.generateXSDDocumentation(DOCUMENT_WORD_EMF_EMBED_ONEFILE,DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+".doc"));
		for (int i = 1; i < 4; i++) {
			assertFileNotExists(new File(fullpath+"_p"+i+".emf"));
		}
	}

	@Test
	public void testGenerateXSDDocumentation_RTF_PNG_NotEmbed_Multifile() {
		robot.openFile(TEXTSTATE_XSD_FILE);
		IOUtils.deleteAll(DOCUMENT_RTF_PNG_NOTEMBED_MULTIFILE);
		String fullpath=DOCUMENT_RTF_PNG_NOTEMBED_MULTIFILE.getAbsolutePath()+"\\"+DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+"_TextType.rtf"));
		Options options =new Options();
		options.add(new RadioOption(" RTF", "Output format", null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new RadioOption("PNG", "Output format", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Embed diagrams",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation", false));
		robot.generateXSDDocumentation(DOCUMENT_RTF_PNG_NOTEMBED_MULTIFILE,DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+".rtf")); 
		assertFileExists(new File(fullpath+"_bold.rtf"));
		assertFileExists(new File(fullpath+"_italic.rtf"));
		assertFileExists(new File(fullpath+"_TextType.rtf"));
		assertFileExists(new File(fullpath+"_underline.rtf")); 
		for (int i = 1; i < 4; i++) {
			assertImage(new File(BASE_EXPECTED_DIR+"\\testGenerateDocumentation_RTF_PNG_Notembed_Multifile\\"+DOCUM_FILENAME+"_p"+i+".png"), new File(fullpath+"_p"+i+".png"));
		}
	}
	@Test
	public void testGenerateXSDDocumentation_RTF_PNG_Embed_OneFile() {
		robot.openFile(TEXTSTATE_XSD_FILE);
		IOUtils.deleteAll(DOCUMENT_RTF_PNG_EMBED_ONEFILE);
		String fullpath=DOCUMENT_RTF_PNG_EMBED_ONEFILE.getAbsolutePath()+"\\"+DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+".rtf"));
		Options options=new Options();
		options.add(new RadioOption(" RTF", "Output format", null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new RadioOption("PNG", "Output format", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Embed diagrams",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation", false));
		robot.generateXSDDocumentation(DOCUMENT_RTF_PNG_EMBED_ONEFILE,DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+".rtf"));
		for (int i = 1; i < 4; i++) {
			assertFileNotExists(new File(fullpath+"_p"+i+".png"));
		}
	}

	@Test
	public void testGenerateXSDDocumentation_RTF_EMF_NotEmbed_OneFile() {
		robot.openFile(TEXTSTATE_XSD_FILE);
		IOUtils.deleteAll(DOCUMENT_RTF_EMF_NOTEMBED_ONEFILE);
		String fullpath=DOCUMENT_RTF_EMF_NOTEMBED_ONEFILE.getAbsolutePath()+"\\"+DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+".rtf"));
		Options options=new Options();
		options.add(new RadioOption(" RTF", "Output format", null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new RadioOption("EMF", "Output format", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Embed diagrams",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation", false));
		robot.generateXSDDocumentation(DOCUMENT_RTF_EMF_NOTEMBED_ONEFILE,DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+".rtf"));
		for (int i = 1; i < 4; i++) {
			assertFileExists(new File(fullpath+"_p"+i+".emf"));
		}
	}
	//doing	
	@Test
	public void testGenerateXSDDocumentation_RTF_EMF_Embed_Multifile() {
		robot.openFile(TEXTSTATE_XSD_FILE);
		IOUtils.deleteAll(DOCUMENT_RTF_EMF_EMBED_MULTIFILE);
		String fullpath=DOCUMENT_RTF_EMF_EMBED_MULTIFILE.getAbsolutePath()+"\\"+DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+"_underline.rtf"));
		Options options=new Options();
		options.add(new RadioOption(" RTF", "Output format", null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new RadioOption("EMF", "Output format", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Embed diagrams",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation", false));
		robot.generateXSDDocumentation(DOCUMENT_RTF_EMF_EMBED_MULTIFILE,DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+".rtf")); 
		assertFileExists(new File(fullpath+"_bold.rtf"));
		assertFileExists(new File(fullpath+"_italic.rtf"));
		assertFileExists(new File(fullpath+"_TextType.rtf"));
		assertFileExists(new File(fullpath+"_underline.rtf")); 
		for (int i = 1; i < 4; i++) {
			assertFileNotExists(new File(fullpath+"_p"+i+".emf"));
		}
	}
	
	@Test
	
	public void testConfigureView() {
		robot.xpathHighlight(xpath);
		robot.configureView();

	}

	@Test

	public void testZoomXSD() {
		robot.xpathHighlight(xpath);
		robot.zoomXSD(size);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	
	public void testDisplayAllGlobals() {
		robot.xpathHighlight(xpath);
		robot.displayAllGlobals();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	
	public void testDisplayDiagram() {
		robot.textView();
		robot.xpathHighlight(xpath);
		robot.schemaView();
		robot.displayDiagram();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testEnableOracleSchemaExtensions() {
		
		robot.xpathHighlight(xpath);
		robot.enableOracleSchemaExtensions();
		//This step is not needed for VS2010 and it confuses the robot at searching the component
		if (Settings.isVS2010()) {
			robot.activatePane(SpyRobot.DETAILS_ORACLE);
		} else {
			assertAreas(DETAILS_ORACLE);
			

		}
	}
	
	@Test
	public void testEnableMSSQLSchemaExtensions() {
		
		robot.xpathHighlight(xpath);
		robot.enableMSSQLServerSchemaExtensions();
		//This step is not needed for VS2010 and it confuses the robot at searching the component
		if (Settings.isVS2010()) {
		robot.activatePane(SpyRobot.DETAILS_SQL_SERVER);
		} else {
		assertAreas(DETAILS_SQL_SERVER);
		}
	}
	
	@Test
	@Ignore //tamino is not supported anymore
	public void testTaminoXSDProperties() {
		robot.openFile(EXAMPLES_TAMINO);
		robot.taminoXSDProperties();

	}

}
