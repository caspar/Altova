/**
 * 
 */
package com.altova.umodel.regression.testcases;

import static com.altova.robots.ImageRecognitionRobot.WINDOWS_DEFAULT_FONT;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;
import static com.altova.umodel.regression.gui.UModelRobot.MODEL_TREE;
import static com.altova.umodel.regression.gui.UModelRobot.PROPERTIES;
import static com.altova.util.LoggerUtils.logger;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.Options;
import com.altova.robots.RadioOption;
import com.altova.robots.ScriptMistakeException;
import com.altova.robots.TextFieldOption;
import com.altova.umodel.regression.gui.EclipseUModelRobot;
import com.altova.umodel.regression.gui.VSnetUModelRobot;
import com.altova.util.IOUtils;
import com.altova.util.RegressionAssert;
import com.altova.util.Settings;
import com.altova.util.SuiteLogLevel;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;
import com.altova.util.Settings.AltovaApplication;

/**
 * @author B.Lopez
 * 
 */
//@TestRobot(VSnetUModelRobot.class)
//@TestRobot(EclipseUModelRobot.class)

public class ProjectMenuTest2 extends AbstractUmodelTest {

	

	protected final String INCLUDE_SUBPRJ2_UMP = (IOUtils.findFile("examples_UModel/Example_include_subprj_byref.ump")).getAbsolutePath();
	
	protected final File INCLUDE_SUBPRJ2_BIS_UMP = new File("C:\\temp\\Example_include_subprj_byref_bis.ump");
	
	protected final String docfilename = "CSharpDoc";

	protected final File DOCUMENT_CSHARP_PROJECT = IOUtils.findFile("examples_UModel/" + docfilename + ".ump");

	protected final File DOCUMENT_HTML_ONE_FILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_HTML_onefile");
	protected final File DOCUMENT_HTML_MULTI_FILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_HTML_Multfile");

	protected final File DOCUMENT_WORD_EMF_EMBED_MULTI_FILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_WORD_EMF_Embed_Multifile");
	protected final File DOCUMENT_WORD_EMF_NOTEMBED_ONE_FILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_WORD_EMF_Notembed_Onefile");
	
	protected final File DOCUMENT_WORD_PNG_EMBED_ONE_FILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_WORD_PNG_Embed_Onefile");
	protected final File DOCUMENT_WORD_PNG_NOTEMBED_MULTI_FILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_WORD_PNG_Notembed_Multfile");
	
	protected final File DOCUMENT_RTF_EMF_EMBED_ONE_FILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_RTF_EMF_Embed_Onefile");
	protected final File DOCUMENT_RTF_EMF_NOTEMBED_MULTI_FILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_RTF_EMF_Notembed_Multifile");
	
	protected final File DOCUMENT_RTF_PNG_EMBED_MULTI_FILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_RTF_PNG_Embed_Multifile");
	protected final File DOCUMENT_RTF_PNG_NOTEMBED_ONE_FILE = new File(BASE_OUT_DIR+"\\testGenerateDocumentation_RTF_PNG_Notembed_Onefile");
	
	protected final File UMP_SAVE_AS_FILE= new File("C:\\temp\\myump.ump");
	protected final String XSD_SOURCE_DIR=(IOUtils.findFile("examples_UModel/Import_XSD_dir")).getAbsolutePath();
	protected final String XSD_SOURCE_FILE=(IOUtils.findFile("examples_UModel/OrgChart.xsd")).getAbsolutePath();
	protected final File BANK_PRJ_JAVA_OUTPUT = new File("C:\\UML_Bank_Sample\\JavaCode");
	protected final String BANK_JAVA_SOURCE=(IOUtils.findFile("examples_UModel/Bank_Java_Source.ump")).getAbsolutePath();
	protected final String BANK_JAVA_TARGET=(IOUtils.findFile("examples_UModel/Bank_Java_Target.ump")).getAbsolutePath();
	protected final File CSHARP_PROFILE_FILE = new File(AltovaApplication.UMODEL.getInstallLocation(), "UModelInclude\\C# Profile.ump");
	protected final String CSHARP_PROFILE = CSHARP_PROFILE_FILE.getAbsolutePath();
	protected final String INCLUDE_SUBPRJ1_UMP=(IOUtils.findFile("examples_UModel/Example_include_subprj_bycopy.ump")).getAbsolutePath();
	protected final static File INCLUDE_SUBPRJ1_BIS_UMP=new File("S:\\QA\\Internal\\Test-Cases\\UModel\\GUI\\Example_include_subprj_bycopy_bis.ump");
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.log(SuiteLogLevel.SUITE, "ProjectMenuTest");
		AbstractUmodelTest.setUpBeforeClass();
	}

	public void setUp() throws Exception {
		super.setUp();
		robot.clearMessages();
	}

	@AfterClass
	public static void cleanUpFiles(){
		if(INCLUDE_SUBPRJ1_BIS_UMP.exists()) {
			INCLUDE_SUBPRJ1_BIS_UMP.delete();
		}
		assertFileNotExists(INCLUDE_SUBPRJ1_BIS_UMP);
	}
	
	@Test
	public final void testImportXMLSchemaFile_relative_def(){
		if(UMP_SAVE_AS_FILE.exists()) {
			UMP_SAVE_AS_FILE.delete();
		}
		assertFileNotExists(UMP_SAVE_AS_FILE);
		robot.newPrj();
		Options options=new Options();
		options.add(new TextFieldOption("XSD file:",XSD_SOURCE_FILE));
		options.add(new CheckboxOption("Import XSD file relative to UModel project file",true));
		robot.importXSDFile(options,UMP_SAVE_AS_FILE);
		assertAreas(MODEL_TREE);
		assertUModelMessageWindow(robot);
	}
	
	
	
	@Test
	public final void testCodeToModel() {
		IOUtils.deleteAll(BANK_PRJ_JAVA_OUTPUT);
		assertFileNotExists(BANK_PRJ_JAVA_OUTPUT);
		robot.modelToCode(null);
		robot.clearMessages();
		robot.codeToModel(null);
		assertUModelMessageWindow(robot);
	}

	
	@Test
	public final void testModelToCode() {
		IOUtils.deleteAll(BANK_PRJ_JAVA_OUTPUT);
		assertFileNotExists(BANK_PRJ_JAVA_OUTPUT);
		robot.modelToCode(null);
		assertUModelMessageWindow(robot);

		assertFileExists(BANK_PRJ_JAVA_OUTPUT);
	}

	@Test
	public final void testProjectSettings() {
		robot.projectSettings();
		robot.switchTabsAndGetScreenshot(getTestName(), "Project Settings", "Java", "C#", "VB", "SPL Templates", "Scripting");
		robot.keyType(KeyEvent.VK_ESCAPE); //exit the dialog
	}

	@Test
	public final void testSynchronizationSettings() {
		robot.synchronizationSettings();
		assertAreas(TOP_WINDOW);
		robot.keyType(KeyEvent.VK_ESCAPE);  //exit the dialog
	}

	
	@Test
	public final void testMergeProject() {
		robot.openPrj(BANK_JAVA_TARGET);
		robot.mergeProject(BANK_JAVA_SOURCE);	
//		assertUModelMessageWindow(robot);
		robot.selectModelTreeRoot();

		robot.findDialog("bankview");
		robot.findDialog("collectData");
		robot.keyType(KeyEvent.VK_RIGHT);robot.delay(500);
		robot.keyType(KeyEvent.VK_DOWN);
		assertAreas(MODEL_TREE);//with this assertion, we check first,third and last messages
		assertAreas(PROPERTIES);
	}
	
	@Test
	public final void testIncludeSubProject_CSharpProfile_ByRef() {
		robot.newPrj();
		robot.includeSubProject(CSHARP_PROFILE, null);
		assertUModelMessageWindow(robot);
		assertAreas(MODEL_TREE);
	}
	
	
	@Test
	@IgnoreRobots(EclipseUModelRobot.class) //saveReplacePrj always make eclipse hang or crash 
	public final void testIncludeSubProject_AsCopy() {
		if (INCLUDE_SUBPRJ1_BIS_UMP.exists()) {
			INCLUDE_SUBPRJ1_BIS_UMP.delete();
		}
		assertFileNotExists(INCLUDE_SUBPRJ1_BIS_UMP);
		robot.newPrj();
		
		robot.includeSubProject(INCLUDE_SUBPRJ1_UMP, "Include as a copy");
		robot.findDialog("RelationshipsToInclude");
		robot.typeStringEnter("Name_changed");
		robot.saveReplacePrj(INCLUDE_SUBPRJ1_BIS_UMP.getAbsolutePath());
		robot.openPrj(INCLUDE_SUBPRJ1_BIS_UMP.getAbsolutePath());
		assertAreas(MODEL_TREE);
		assertUModelMessageWindow(robot);
		
	}
	
	
	
	@Test
	public final void testIncludeSubProject_ByRef() {
		if (INCLUDE_SUBPRJ2_BIS_UMP.exists()) {
			INCLUDE_SUBPRJ2_BIS_UMP.delete();
		}
		assertFileNotExists(INCLUDE_SUBPRJ2_BIS_UMP);
		robot.newPrj();
		delay(1000);
		robot.includeSubProject(INCLUDE_SUBPRJ2_UMP, "Include by reference");

		assertUModelMessageWindow(robot);

		// this bit just checks that the result is alright and does not need to
		// be done for the integrations
		robot.checkIncludeSubProject_byRef(INCLUDE_SUBPRJ2_BIS_UMP);
		assertAreas(MODEL_TREE);
		

	}

	@Test
	@Ignore
	public final void testOpenSubProjectAsProject() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testClearMessages() {
		robot.listElementsNotUsed();
		robot.listIncludedPackages();
		robot.clearMessages();
		assertUModelMessageWindow(robot);
	}

	@Test
	public final void testGenerateDocumentation_HTML_onefile() {
		IOUtils.deleteAll(DOCUMENT_HTML_ONE_FILE);
		String fullpath = DOCUMENT_HTML_ONE_FILE.getAbsolutePath() + "\\" + docfilename;
		String fullpathWithDiagrams = DOCUMENT_HTML_ONE_FILE.getAbsolutePath() + "\\" + "CSharpDoc_diagrams" + "\\" + docfilename; //this path is needed because "Create folder for diagrams" is true
		
		assertFileNotExists(new File(fullpath + ".html"));
		robot.openPrj(DOCUMENT_CSHARP_PROJECT.getAbsolutePath());
		Options options = new Options();
		options.add(new RadioOption(" HTML","Output format", null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new CheckboxOption("Split output to multiple files",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation", false));
		options.add(new CheckboxOption("Embed CSS in HTML",true, null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Create folder for diagrams",true, null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new RadioOption("relative to result file"));
		
		
		robot.generateDocumentation(DOCUMENT_HTML_ONE_FILE, docfilename, options);
		
		assertFileExists(new File(fullpath + ".html"));
		for (int i = 1; i < 8; i++) {
			assertImage(new File(BASE_EXPECTED_DIR+"\\testGenerateDocumentation_HTML_onefile\\"+docfilename+"_diagrams\\" + docfilename + "_p" + i + ".png"), new File(fullpathWithDiagrams + "_p" + i + ".png"));
		}
	}

	@Test
	public final void testGenerateDocumentation_HTML_Multfile() {
		IOUtils.deleteAll(DOCUMENT_HTML_MULTI_FILE);
		String fullpath = DOCUMENT_HTML_MULTI_FILE.getAbsolutePath() + "\\" + docfilename;
		assertFileNotExists(new File(fullpath + "_Point.html")); //we check just
																//one of the files
		robot.openPrj(DOCUMENT_CSHARP_PROJECT.getAbsolutePath());
		Options options = new Options();
		options.add(new RadioOption(" HTML","Output format", null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new CheckboxOption("Split output to multiple files",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation", false));
		options.add(new CheckboxOption("Embed CSS in HTML",false, null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Create folder for diagrams",false, null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new RadioOption("absolute"));
		robot.generateDocumentation(DOCUMENT_HTML_MULTI_FILE, docfilename, options);
		
		assertFileExists(new File(fullpath + "_ColoredPoint.html"));
		assertFileExists(new File(fullpath + "_Component View.html"));
		assertFileExists(new File(fullpath + "_Diagram_Content of DocComments and all subpackages.html"));
		assertFileExists(new File(fullpath + "_DocComments.html"));
		assertFileExists(new File(fullpath + "_DocComments1.html"));
		assertFileExists(new File(fullpath + "_Point.html"));
		assertFileExists(new File(fullpath + "_Root.html"));
		assertFileExists(new File(fullpath + "_SimplePoint.html"));
		assertFileExists(new File(fullpath + ".css"));
		for (int i = 1; i < 8; i++) {
			assertImage(new File(BASE_EXPECTED_DIR+"\\testGenerateDocumentation_HTML_Multfile\\" + docfilename + "_p" + i + ".png"), new File(fullpath + "_p" + i + ".png"));
		}
	}
	
	@Test
	public final void testGenerateDocumentation_WORD_PNG_Embed_Onefile() throws FileNotFoundException {
		IOUtils.deleteAll(DOCUMENT_WORD_PNG_EMBED_ONE_FILE);
		String fullpath = DOCUMENT_WORD_PNG_EMBED_ONE_FILE.getAbsolutePath() + "\\" + docfilename;
		assertFileNotExists(new File(fullpath + ".doc"));
		robot.openPrj(DOCUMENT_CSHARP_PROJECT.getAbsolutePath());
		Options options = new Options();
		options.add(new RadioOption(" Microsoft Word",null, null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new RadioOption("PNG",null, null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new CheckboxOption("Embed diagrams",true, null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation", false));
	
		robot.generateDocumentation(DOCUMENT_WORD_PNG_EMBED_ONE_FILE, docfilename + ".doc", options);
		boolean ifesc = robot.escapeDialog("Sorry, but a properly installed version of Microsoft Word 2000", KeyEvent.VK_ENTER);

		if (!ifesc) {
			assertFileExists(new File(fullpath + ".doc"));
			for (int i = 1; i < 8; i++) {
				assertFileNotExists(new File(fullpath + "_p" + i + ".png"));
			}
		} else {
			assertFileNotExists(new File(fullpath + ".doc"));
			throw new FileNotFoundException("Please, install MS Word of, at least, 2000 version to perform this test");
		}
	}
	
	@Test
	public final void testGenerateDocumentation_WORD_PNG_Notembed_Multfile() throws FileNotFoundException {
		IOUtils.deleteAll(DOCUMENT_WORD_PNG_NOTEMBED_MULTI_FILE);
		String fullpath = DOCUMENT_WORD_PNG_NOTEMBED_MULTI_FILE.getAbsolutePath() + "\\" + docfilename;
		assertFileNotExists(new File(fullpath + "_SimplePoint.doc")); // we
																		// just
																		// check
		// one of the files
		robot.openPrj(DOCUMENT_CSHARP_PROJECT.getAbsolutePath());
		Options options = new Options();
		options.add(new RadioOption(" Microsoft Word",null, null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new RadioOption("PNG",null, null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Embed diagrams",false, null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation", false));
		robot.generateDocumentation(DOCUMENT_WORD_PNG_NOTEMBED_MULTI_FILE, docfilename + ".doc", options);
		boolean ifesc = robot.escapeDialog("Sorry, but a properly installed version of Microsoft Word 2000", KeyEvent.VK_ENTER);

		if (!ifesc) {
			assertFileExists(new File(fullpath + "_ColoredPoint.doc"));
			assertFileExists(new File(fullpath + "_Component View.doc"));
			assertFileExists(new File(fullpath + "_Diagram_Content of DocComments and all subpackages.doc"));
			assertFileExists(new File(fullpath + "_DocComments.doc"));
			assertFileExists(new File(fullpath + "_DocComments1.doc"));
			assertFileExists(new File(fullpath + "_Point.doc"));
			assertFileExists(new File(fullpath + "_Root.doc"));
			assertFileExists(new File(fullpath + "_SimplePoint.doc"));
			for (int i = 1; i < 8; i++) {
				assertImage(new File(BASE_EXPECTED_DIR + "\\testGenerateDocumentation_WORD_PNG_Notembed_Multfile\\" + docfilename + "_p" + i + ".png"), new File(fullpath + "_p" + i + ".png"));
			}
		} else {
			assertFileNotExists(new File(fullpath + "_ColoredPoint.doc"));
			throw new FileNotFoundException("Please, install MS Word of, at least, 2000 version to perform this test");
		}
	}

	@Test
	public final void testGenerateDocumentation_WORD_EMF_Embed_Multfile() throws FileNotFoundException {
		IOUtils.deleteAll(DOCUMENT_WORD_EMF_EMBED_MULTI_FILE);
		String fullpath = DOCUMENT_WORD_EMF_EMBED_MULTI_FILE.getAbsolutePath() + "\\" + docfilename;
		assertFileNotExists(new File(fullpath + "_DocComments1.doc")); // we
																		// just
																		// check
		// one of the files
		robot.openPrj(DOCUMENT_CSHARP_PROJECT.getAbsolutePath());
		Options options = new Options();
		options.add(new RadioOption(" Microsoft Word",null, null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new RadioOption("EMF",null, null, null, null, WINDOWS_DEFAULT_FONT)); 
		options.add(new CheckboxOption("Embed diagrams",true, null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation", false));
		robot.generateDocumentation(DOCUMENT_WORD_EMF_EMBED_MULTI_FILE, docfilename + ".doc", options);
		boolean ifesc = robot.escapeDialog("Sorry, but a properly installed version of Microsoft Word 2000", KeyEvent.VK_ENTER);

		if (!ifesc) {
			assertFileExists(new File(fullpath + "_ColoredPoint.doc"));
			assertFileExists(new File(fullpath + "_Component View.doc"));
			assertFileExists(new File(fullpath + "_Diagram_Content of DocComments and all subpackages.doc"));
			assertFileExists(new File(fullpath + "_DocComments.doc"));
			assertFileExists(new File(fullpath + "_DocComments1.doc"));
			assertFileExists(new File(fullpath + "_Point.doc"));
			assertFileExists(new File(fullpath + "_Root.doc"));
			assertFileExists(new File(fullpath + "_SimplePoint.doc"));
			for (int i = 1; i < 8; i++) {
				assertFileNotExists(new File(fullpath + "_p" + i + ".emf"));
			}
		} else {
			assertFileNotExists(new File(fullpath + "_ColoredPoint.doc"));
			throw new FileNotFoundException("Please, install MS Word of, at least, 2000 version to perform this test");
		}

	}

	@Test
	public final void testGenerateDocumentation_WORD_EMF_Notembed_Onefile() throws FileNotFoundException {
		IOUtils.deleteAll(DOCUMENT_WORD_EMF_NOTEMBED_ONE_FILE);
		String fullpath = DOCUMENT_WORD_EMF_NOTEMBED_ONE_FILE.getAbsolutePath() + "\\" + docfilename;
		assertFileNotExists(new File(fullpath + ".doc"));
		robot.openPrj(DOCUMENT_CSHARP_PROJECT.getAbsolutePath());
		Options options = new Options();
		options.add(new RadioOption(" Microsoft Word",null, null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new RadioOption("EMF",null, null, null, null, WINDOWS_DEFAULT_FONT)); 
		options.add(new CheckboxOption("Embed diagrams",false, null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation", false));
		
		robot.generateDocumentation(DOCUMENT_WORD_EMF_NOTEMBED_ONE_FILE, docfilename + ".doc", options);
		boolean ifesc = robot.escapeDialog("Sorry, but a properly installed version of Microsoft Word 2000", KeyEvent.VK_ENTER);

		if (!ifesc) {
			assertFileExists(new File(fullpath + ".doc"));
			for (int i = 1; i < 8; i++) {
				assertFileExists(new File(fullpath + "_p" + i + ".emf"));
			}
		} else {
			assertFileNotExists(new File(fullpath + ".doc"));
			throw new FileNotFoundException("Please, install MS Word of, at least, 2000 version to perform this test");
		}
	}

	@Test
	public final void testGenerateDocumentation_RTF_PNG_Embed_Multfile() {
		IOUtils.deleteAll(DOCUMENT_RTF_PNG_EMBED_MULTI_FILE);
		String fullpath = DOCUMENT_RTF_PNG_EMBED_MULTI_FILE.getAbsolutePath() + "\\" + docfilename;
		assertFileNotExists(new File(fullpath + "_DocComments1.rtf")); // we just check
																		// one of the files
		robot.openPrj(DOCUMENT_CSHARP_PROJECT.getAbsolutePath());
		Options options = new Options();
		options.add(new RadioOption(" RTF","Output format", null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new RadioOption("PNG",null, null, null, null, WINDOWS_DEFAULT_FONT)); 
		options.add(new CheckboxOption("Embed diagrams",true, null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation", false));
		robot.generateDocumentation(DOCUMENT_RTF_PNG_EMBED_MULTI_FILE, docfilename + ".rtf", options);

		assertFileExists(new File(fullpath + "_ColoredPoint.rtf"));
		assertFileExists(new File(fullpath + "_Component View.rtf"));
		assertFileExists(new File(fullpath + "_Diagram_Content of DocComments and all subpackages.rtf"));
		assertFileExists(new File(fullpath + "_DocComments.rtf"));
		assertFileExists(new File(fullpath + "_DocComments1.rtf"));
		assertFileExists(new File(fullpath + "_Point.rtf"));
		assertFileExists(new File(fullpath + "_Root.rtf"));
		assertFileExists(new File(fullpath + "_SimplePoint.rtf"));
		for (int i = 1; i < 8; i++) {
			assertFileNotExists(new File(fullpath + "_p" + i + ".png"));
		}
	}

	@Test
	public final void testGenerateDocumentation_RTF_PNG_Notembed_Onefile() {
		IOUtils.deleteAll(DOCUMENT_RTF_PNG_NOTEMBED_ONE_FILE);
		String fullpath = DOCUMENT_RTF_PNG_NOTEMBED_ONE_FILE.getAbsolutePath() + "\\" + docfilename;
		assertFileNotExists(new File(fullpath + ".rtf"));
		robot.openPrj(DOCUMENT_CSHARP_PROJECT.getAbsolutePath());
		Options options = new Options();
		options.add(new RadioOption(" RTF","Output format", null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new RadioOption("PNG",null, null, null, null, WINDOWS_DEFAULT_FONT)); 
		options.add(new CheckboxOption("Embed diagrams",false, null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation", false));
		robot.generateDocumentation(DOCUMENT_RTF_PNG_NOTEMBED_ONE_FILE, docfilename + ".rtf", options);

		assertFileExists(new File(fullpath + ".rtf"));

		for (int i = 1; i < 8; i++) {
			assertImage(new File(BASE_EXPECTED_DIR+"\\testGenerateDocumentation_RTF_PNG_Notembed_Onefile\\" + docfilename + "_p" + i + ".png"), new File(fullpath + "_p" + i + ".png"));
		}
	}

	@Test
	public final void testGenerateDocumentation_RTF_EMF_Embed_Onefile() {
		IOUtils.deleteAll(DOCUMENT_RTF_EMF_EMBED_ONE_FILE);
		String fullpath = DOCUMENT_RTF_EMF_EMBED_ONE_FILE.getAbsolutePath() + "\\" + docfilename;
		assertFileNotExists(new File(fullpath + ".rtf"));
		robot.openPrj(DOCUMENT_CSHARP_PROJECT.getAbsolutePath());
		Options options = new Options();
		options.add(new RadioOption(" RTF","Output format", null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new RadioOption("EMF",null, null, null, null, WINDOWS_DEFAULT_FONT)); 
		options.add(new CheckboxOption("Embed diagrams",true, null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation", false));
		robot.generateDocumentation(DOCUMENT_RTF_EMF_EMBED_ONE_FILE, docfilename + ".rtf", options);

		assertFileExists(new File(fullpath + ".rtf"));
		for (int i = 1; i < 8; i++) {
			assertFileNotExists(new File(fullpath + "_p" + i + ".emf"));
		}
	}

	@Test
	public final void testGenerateDocumentation_RTF_EMF_Notembed_Multifile() {
		IOUtils.deleteAll(DOCUMENT_RTF_EMF_NOTEMBED_MULTI_FILE);
		String fullpath = DOCUMENT_RTF_EMF_NOTEMBED_MULTI_FILE.getAbsolutePath() + "\\" + docfilename;
		assertFileNotExists(new File(fullpath + "_DocComments1.rtf"));
		robot.openPrj(DOCUMENT_CSHARP_PROJECT.getAbsolutePath());
		Options options = new Options();
		options.add(new RadioOption(" RTF","Output format", null, null, null, WINDOWS_DEFAULT_FONT)); //the space before the name is a trick as options are checked in alphabetical order
		options.add(new RadioOption("EMF",null, null, null, null, WINDOWS_DEFAULT_FONT)); 
		options.add(new CheckboxOption("Embed diagrams",false, null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation", false));
		robot.generateDocumentation(DOCUMENT_RTF_EMF_NOTEMBED_MULTI_FILE, docfilename + ".rtf", options);

		assertFileExists(new File(fullpath + "_ColoredPoint.rtf"));
		assertFileExists(new File(fullpath + "_Component View.rtf"));
		assertFileExists(new File(fullpath + "_Diagram_Content of DocComments and all subpackages.rtf"));
		assertFileExists(new File(fullpath + "_DocComments.rtf"));
		assertFileExists(new File(fullpath + "_DocComments1.rtf"));
		assertFileExists(new File(fullpath + "_Point.rtf"));
		assertFileExists(new File(fullpath + "_Root.rtf"));
		assertFileExists(new File(fullpath + "_SimplePoint.rtf"));
		for (int i = 1; i < 8; i++) {
			assertFileExists(new File(fullpath + "_p" + i + ".emf"));
		}
	}

	@Test
	public final void testListElementsNotUsed() {
		robot.listElementsNotUsed();
		assertUModelMessageWindow(robot);

	}

	@Test
	public final void testListSharedPackages() {
		robot.listSharedPackages();
		assertUModelMessageWindow(robot);

	}

	@Test
	@Ignore
	// it's listing included packages/projects in random order (changes for each
	// run)
	public final void testListIncludedPackages() {
		robot.listIncludedPackages();
		assertUModelMessageWindow(robot);
	}

}
