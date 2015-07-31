package com.altova.umodel.regression.testcases;


import static com.altova.umodel.regression.gui.UModelRobot.MODEL_TREE;
import static com.altova.umodel.regression.gui.UModelRobot.MESSAGES;
import static com.altova.umodel.regression.gui.UModelRobot.PROPERTIES;
import static com.altova.util.LoggerUtils.logger;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.DropDownOption;

import com.altova.robots.Options;
import com.altova.robots.PluginRobot;

import com.altova.robots.TextFieldOption;
import com.altova.spy.EclipseSpyRobot;
import com.altova.spy.VSnetSpyRobot;
import com.altova.umodel.regression.gui.EclipseUModelRobot;
import com.altova.umodel.regression.gui.VSnetUModelRobot;
import com.altova.util.IOUtils;
import com.altova.util.SuiteLogLevel;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;
import com.altova.util.Settings.AltovaApplication;



//@TestRobot(VSnetUModelRobot.class)
//@TestRobot(EclipseUModelRobot.class)

public class ProjectMenuTest1 extends AbstractUmodelTest {

	protected final File CSHARP_PROFILE_FILE = new File(AltovaApplication.UMODEL.getInstallLocation(), "UModelInclude\\C# Profile.ump");
	protected final String CSHARP_PROFILE = CSHARP_PROFILE_FILE.getAbsolutePath();
	
	protected final File BANK_PRJ_MULTILANGUAGE_OUTPUT = (IOUtils.findFile("examples_UModel/Import_multilang_Dir"));
	
	protected final String VB9_SOURCE_PROJECT=(IOUtils.findFile("examples_UModel/Import_Project_VB9/LINQ_To_XML_15.vbproj")).getAbsolutePath();
	protected final String CS3_SOURCE_PROJECT=(IOUtils.findFile("examples_UModel/Import_Project_CSharp3/ImplicitelyTypesArrays_2.sln")).getAbsolutePath();
	protected final String JAVA6_SOURCE_PROJECT=(IOUtils.findFile("examples_UModel/Import_Project_Java6/.project")).getAbsolutePath();
	
	protected final String DLL_IMPORT_BINARY=(IOUtils.findFile("examples_UModel/AbstractClass.dll")).getAbsolutePath();
	protected final String JAR_IMPORT_BINARY=(IOUtils.findFile("examples_UModel/XmlSchema.jar")).getAbsolutePath();

	protected final File BANK_PRJ_JAVA_OUTPUT = new File("C:\\UML_Bank_Sample\\JavaCode");
	protected final String INCLUDE_SUBPRJ1_UMP=(IOUtils.findFile("examples_UModel/Example_include_subprj_bycopy.ump")).getAbsolutePath();
	protected final static File INCLUDE_SUBPRJ1_BIS_UMP=new File("S:\\QA\\Internal\\Test-Cases\\UModel\\GUI\\Example_include_subprj_bycopy_bis.ump");
	
	protected final String XSD_SOURCE_DIR=(IOUtils.findFile("examples_UModel/Import_XSD_dir")).getAbsolutePath();
	protected final String XSD_SOURCE_FILE=(IOUtils.findFile("examples_UModel/OrgChart.xsd")).getAbsolutePath();
	
	
	protected final File UMP_SAVE_AS_FILE= new File("C:\\temp\\myump.ump");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.log(SuiteLogLevel.SUITE, "ProjectMenuTest");
		AbstractUmodelTest.setUpBeforeClass();
	}
	
	public void setUp() throws Exception {
		super.setUp();
		robot.clearMessages();
	}
	
	
	
	// ----------------------------- PROJECT MENU -----------------------------

	@Test
	public final void testSyntaxCheck() {
		robot.syntaxCheck();
		assertUModelMessageWindow(robot);

	}

	@Test
	@IgnoreRobots(EclipseUModelRobot.class) //only works in Eclipse if there is a non-Java project imported
	public final void testImportSourceDirectory() {
		IOUtils.deleteAll(BANK_PRJ_JAVA_OUTPUT);
		assertFileNotExists(BANK_PRJ_JAVA_OUTPUT);
		
		robot.modelToCode(null);
		robot.newPrj();
		
		Options options = new Options();
		options.add(new DropDownOption("Language", "Java5.0"));
		options.add(new TextFieldOption("Directory", BANK_PRJ_JAVA_OUTPUT.getAbsolutePath()));
		options.add(new CheckboxOption("Import directories relative to UModel project file",false));
		
		robot.importSourceDirectory(options);
		robot.selectModelTreeRoot();;
		robot.findDialog("bankview",false,true,true,false);
		robot.delay(1000);
		robot.findNext();
		robot.delay(500);
		robot.keyType(KeyEvent.VK_PLUS);
		assertAreas(MODEL_TREE);
		assertUModelMessageWindow(robot);
	}
	
	@Test
	//second test so that the functionality can be tested in eclipse as well
	@IgnoreRobots(VSnetUModelRobot.class)
	public final void testImportSourceDirectoryMulti() {
		
		robot.newPrj();
		
		Options options = new Options();
		options.add(new DropDownOption("Language", "C#2.0"));
		options.add(new TextFieldOption("Directory", BANK_PRJ_MULTILANGUAGE_OUTPUT .getAbsolutePath()));
		options.add(new CheckboxOption("Import directories relative to UModel project file",false));
		
		robot.importSourceDirectory(options);
		robot.selectModelTreeRoot();
		robot.findDialog("Agency",true,true,true,false);
		robot.delay(1000);
		robot.keyType(KeyEvent.VK_PLUS);
		assertAreas(MODEL_TREE);
		assertUModelMessageWindow(robot);
		
	}
	
	@Test
	@IgnoreRobots(VSnetUModelRobot.class)
	public final void testImportSourceProject_VB9() {
		robot.newPrj();
		Options options=new Options();
		options.add(new TextFieldOption("Project file:",VB9_SOURCE_PROJECT));
		options.add(new CheckboxOption("Import project relative to UModel project file",false));
		robot.importSourceProject(options,true);
		assertAreas(MODEL_TREE);
		assertUModelMessageWindow(robot);
	}
	
	@Test
	@IgnoreRobots(EclipseUModelRobot.class)
	public final void testImportSourceProject_Java6() {
		robot.newPrj();
		Options options=new Options();
		options.add(new DropDownOption("Language","(1.6)"));
		options.add(new TextFieldOption("Project file:",JAVA6_SOURCE_PROJECT));
		options.add(new CheckboxOption("Import project relative to UModel project file",false));
		
		robot.importSourceProject(options,false);
		assertAreas(MODEL_TREE);
		assertUModelMessageWindow(robot);
	}
	
	@Test
	@IgnoreRobots(VSnetUModelRobot.class)
	public final void testImportSourceProject_CSharp3() {
		robot.newPrj();
		Options options=new Options();
		options.add(new DropDownOption("Language","C#3.0"));
		options.add(new TextFieldOption("Project file:",CS3_SOURCE_PROJECT));
		options.add(new CheckboxOption("Import project relative to UModel project file",false));
		robot.importSourceProject(options,false);
		assertAreas(MODEL_TREE);
		assertUModelMessageWindow(robot);
	}
	
	@Test
	@IgnoreRobots(VSnetUModelRobot.class)
	public final void testImportBinaryTypes_dll(){
		robot.newPrj();
		Options options=new Options();
		options.add(new DropDownOption("Language:","C#3.0"));
		options.add(new DropDownOption("Runtime:",".NET3.0"));
		robot.importBinaryTypes(options, "Assembly File",DLL_IMPORT_BINARY);
		assertAreas(MODEL_TREE);
		assertUModelMessageWindow(robot);

	}
	
	@Test
	@IgnoreRobots(EclipseUModelRobot.class)
	public final void testImportBinaryTypes_jar(){
		robot.newPrj();
		Options options=new Options();
		options.add(new DropDownOption("Language:","Java6.0"));
		robot.importBinaryTypes(options, "Class File Archive",JAR_IMPORT_BINARY);
		assertAreas(MODEL_TREE);
		assertUModelMessageWindow(robot);
	}
	
	@Test
	@IgnoreRobots({EclipseUModelRobot.class,VSnetUModelRobot.class}) //set to ignore till #26590 gets fixed
	public final void testImportXMLSchemaDirectory_def(){
		robot.newPrj();
		Options options=new Options();
		options.add(new TextFieldOption("Directory:",XSD_SOURCE_DIR));
		
		options.add(new CheckboxOption("Import directories relative to UModel project file",false));
		robot.importSourceXSDDir(options);
		robot.delay(10000);
		robot.selectModelTreeRoot();
		robot.findDialog("base-defs-Schema");
		robot.keyType(KeyEvent.VK_PLUS);robot.delay(1000);
		robot.findDialog("derived-defs-Schema");
		robot.keyType(KeyEvent.VK_PLUS);
		assertAreas(MODEL_TREE);
		assertUModelMessageWindow(robot);
	}

	@Test
	public final void testImportXMLSchemaFile_def(){
		robot.newPrj();
		Options options=new Options();
		options.add(new TextFieldOption("XSD file:",XSD_SOURCE_FILE));
		options.add(new CheckboxOption("Import XSD file relative to UModel project file",false));
		robot.importXSDFile(options,null);
		assertAreas(MODEL_TREE);
		assertUModelMessageWindow(robot);
	}

}
