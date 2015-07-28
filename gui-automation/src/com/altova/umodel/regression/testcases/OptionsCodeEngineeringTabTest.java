package com.altova.umodel.regression.testcases;
import static com.altova.util.LoggerUtils.logger;


import java.io.File;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.umodel.regression.gui.UModelRobot.HIERARCHY;
import static com.altova.umodel.regression.gui.UModelRobot.FAVORITES;
import static com.altova.umodel.regression.gui.UModelRobot.PROPERTIES;
import static com.altova.umodel.regression.gui.UModelRobot.MESSAGES;
import static com.altova.umodel.regression.gui.UModelRobot.MODEL_TREE;
import static java.awt.event.KeyEvent.*;

import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.robots.CheckboxOption;
import com.altova.robots.Option;
import com.altova.robots.Options;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;
import com.altova.robots.DropDownOption;
import com.altova.umodel.regression.gui.UModelRobot;
import com.altova.util.IOUtils;

public class OptionsCodeEngineeringTabTest extends AbstractUmodelTest{

	
	protected static final File RESOLVE_COLLECTION_UMP = IOUtils.findFile("examples_UModel/option_tool_resolve_collection.ump");	
	protected static final File SYNTAX_CHECK_UMP = IOUtils.findFile("examples_UModel/option_tool_syntax_check.ump");
	protected static final File UPDATE_PROGRAM_CODE_UMP = IOUtils.findFile("examples_UModel/option_tool_update_program_code.ump");	
	protected static final File UPDATE_PROGRAM_CODE_UMP_NOERR = IOUtils.findFile("examples_UModel/option_tool_update_program_code_noerror.ump");	
	protected static final File UPDATE_PROGRAM_MISSING_FILENAME = IOUtils.findFile("examples_UModel/option_tool_missing_file_name.ump");	
	protected static final File UPDATE_PROGRAM_MISSING_FILENAME_2 = IOUtils.findFile("examples_UModel/option_tool_missing_file_name_2.ump");
	protected static final File NAMESPACE_FORCODEFILEPATH_JAVA = IOUtils.findFile("examples_UModel/option_tool_namespace_java.ump");
	protected static final File IMPORT_SOURCE_DIR = IOUtils.findFile("examples_UModel/JavaNamespaceTest");	
	protected static final File TMP_SAVED_UMP = IOUtils.findFile("examples_UModel/tmp_prj.ump");
	protected static final File NAMESPACE_FORCODEFILEPATH_VB = IOUtils.findFile("examples_UModel/option_tool_namespace_vb.ump");	
	protected static final File NAMESPACE_FORCODEFILEPATH_CS = IOUtils.findFile("examples_UModel/option_tool_namespace_cs.ump");	
	
	
	@BeforeClass
	public static void setUpBeforeOption()throws Exception{
		
		if(robot == null) {
			robot = new UModelRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
		robot.customizeKeyboard("Tools", "Options...", VK_T);
	}
	
	@Test
	public void testCodeEngineering_Always_on_info() {
		
		robot.clearMessages();
		robot.hideWindow("Messages");
		
		robot.activateOptionsDialog();
		RadioOption c = new RadioOption("Always", "Open Message Window", null, null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", c);

		checkSyntax();
		
		assertNotNull(robot.findComponentName("Messages"));
		assertAreas(MESSAGES);
	}
	
	@Test
	public void testCodeEngineering_Always_on_error() {
		
		robot.openFile(UPDATE_PROGRAM_CODE_UMP.getAbsolutePath());
		
		robot.clearMessages();
		robot.hideWindow("Messages");
		
		robot.activateOptionsDialog();
		RadioOption c = new RadioOption("Always", "Open Message Window", null, null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", c);

		MergeProgramCode();
		
		assertNotNull(robot.findComponentName("Messages"));
		assertAreas(MESSAGES);
		
	}
	
	@Test
	public void testCodeEngineering_Always_on_warning() {
		
		robot.openFile(RESOLVE_COLLECTION_UMP.getAbsolutePath());
		
		robot.clearMessages();
		robot.hideWindow("Messages");
		
		robot.activateOptionsDialog();
		RadioOption c = new RadioOption("Always", "Open Message Window", null, null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", c);

		MergeProgramCode();
		
		assertNotNull(robot.findComponentName("Messages"));
		assertAreas(MESSAGES);
		
	}
	
	@Test
	public void testCodeEngineering_Errors_on_info() {
		
		robot.clearMessages();
		robot.hideWindow("Messages");	
		
		robot.activateOptionsDialog();
		RadioOption c = new RadioOption("For errors   ", "Open Message Window", null, null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", c);

		MergeProgramCode();
		
		assertNull(robot.findComponentName("Messages"));
	}
	
	@Test
	public void testCodeEngineering_Errors_on_error() {
		
		robot.openFile(UPDATE_PROGRAM_CODE_UMP.getAbsolutePath());
		
		robot.clearMessages();
		robot.hideWindow("Messages");
		
		robot.activateOptionsDialog();
		RadioOption c = new RadioOption("For errors   ", "Open Message Window", null, null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", c);

		MergeProgramCode();
		
		assertNotNull(robot.findComponentName("Messages"));
		assertAreas(MESSAGES);
		
	}
	
	@Test
	public void testCodeEngineering_Errors_on_warning() {
		
		robot.openFile(RESOLVE_COLLECTION_UMP.getAbsolutePath());
		
		robot.clearMessages();
		robot.hideWindow("Messages");
		
		robot.activateOptionsDialog();
		RadioOption c = new RadioOption("For errors   ", "Open Message Window", null, null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", c);

		MergeProgramCode();
		
		assertNotNull(robot.findComponentName("Messages"));
		assertAreas(MESSAGES);
		
	}
	
	@Test
	public void testCodeEngineering_Warning_on_info() {
		
		robot.clearMessages();
		robot.hideWindow("Messages");
		
		robot.activateOptionsDialog();
		RadioOption c = new RadioOption("For errors and warning", "Open Message Window", null, null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", c);

		MergeProgramCode();
		
		assertNull(robot.findComponentName("Messages"));
	}
	

	@Test
	public void testCodeEngineering_Warning_on_error() {
		
		robot.openFile(UPDATE_PROGRAM_CODE_UMP.getAbsolutePath());
		
		robot.clearMessages();
		robot.hideWindow("Messages");
		
		robot.activateOptionsDialog();
		RadioOption c = new RadioOption("For errors and warning", "Open Message Window", null, null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", c);

		MergeProgramCode();
		
		assertNotNull(robot.findComponentName("Messages"));
		assertAreas(MESSAGES);
		
	}
	
	@Test
	public void testCodeEngineering_Warning_on_warning() {
		
		robot.openFile(RESOLVE_COLLECTION_UMP.getAbsolutePath());
		
		robot.clearMessages();
		robot.hideWindow("Messages");
		
		robot.activateOptionsDialog();
		RadioOption c = new RadioOption("For errors and warning", "Open Message Window", null, null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", c);

		MergeProgramCode();
		
		assertNotNull(robot.findComponentName("Messages"));
		assertAreas(MESSAGES);
		
	}
	
	
	@Test
	public void testCodeEngineering_SyntaxCheck_allCodingElements() {
		
		robot.openFile(SYNTAX_CHECK_UMP.getAbsolutePath());
		
		robot.activateOptionsDialog();
		
		RadioOption a = new RadioOption("all coding elements", null, null, null, "Code Engineering",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption c = new CheckboxOption ("Use Syntax Check", false, "Update Program Code from UModel Project", null,  null, "Code Engineering",MS_SHELL_DLG_FONT);		
		robot.applyOptionsEnter("Local Options", c);
		
		checkSyntax();
		
		assertAreas(MESSAGES);
		
	}
	
	@Test
	public void testCodeEngineering_SyntaxCheck_all_elementsUsedFor() {
		
		robot.openFile(SYNTAX_CHECK_UMP.getAbsolutePath());
		
		robot.activateOptionsDialog();
		
		RadioOption a = new RadioOption("elements used for code engineering", null, null, null, "Code Engineering",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption c = new CheckboxOption ("Use Syntax Check", false, "Update Program Code from UModel Project", null,  null, "Code Engineering",MS_SHELL_DLG_FONT);		
		robot.applyOptionsEnter("Local Options", c);
		
		checkSyntax();
		
		assertAreas(MESSAGES);
		
	}
	
	
	@Test
	public void testCodeEngineering_UseSyntaxCheck_off() {
		
		robot.openFile(UPDATE_PROGRAM_CODE_UMP.getAbsolutePath());

		robot.activateOptionsDialog();		
		CheckboxOption a = new CheckboxOption("Use Syntax Check", false, "Update Program Code from UModel Project", null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", a);
		MergeProgramCode();
		
		assertAreas(MESSAGES);
		
	}
	
	@Test
	public void testCodeEngineering_UseSyntaxCheck_on() {
			
		robot.openFile(UPDATE_PROGRAM_CODE_UMP.getAbsolutePath());

		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Use Syntax Check", true, "Update Program Code from UModel Project", null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", a);

		MergeProgramCode();		
		assertAreas(MESSAGES);
		
	}
	
	@Test
	public void testCodeEngineering_generateMissingComponentRealizations_off() {
			
		robot.openFile(UPDATE_PROGRAM_CODE_UMP_NOERR.getAbsolutePath());
		//robot.openDiagram("Content of AbstractClass"); not found anymore: some extra pixel in file generation
		robot.openDiagram("Content of");

		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Generate missing ComponentRealizations", false, "Update Program Code from UModel Project", null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",a);

		MergeProgramCode();
		delay(1000);
		robot.findDialog("ComponentRealization:  (Point)");

		assertAreas(MESSAGES, MODEL_TREE);
		
	}

	
	@Test
	public void testCodeEngineering_generateMissingComponentRealizations_on() {
			
		robot.openFile(UPDATE_PROGRAM_CODE_UMP_NOERR.getAbsolutePath());
		//robot.openDiagram("Content of AbstractClass"); not found anymore: some extra pixel in file generation
		robot.openDiagram("Content of");
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Generate missing ComponentRealizations", true, "Update Program Code from UModel Project", null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", a);

		MergeProgramCode();		
		robot.findDialog("ComponentRealization:  (Point)");
		
		assertAreas(MESSAGES, MODEL_TREE);
		
	}
	/*
	 * generateMissingCodeFileNames: off
	 * generateMissingComponentrealization: off
	 * componetRealization: 1 less

	 */
	
	@Test
	public void testCodeEngineering_generateMissingCodeFileNames_off_test1() {
			
		
		robot.openFile(UPDATE_PROGRAM_MISSING_FILENAME_2.getAbsolutePath());
		robot.openDiagram("ClassDiagram1");
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Generate missing code file names", false, "Update Program Code from UModel Project", null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		a.applyOption(robot);

		CheckboxOption b = new CheckboxOption("Generate missing ComponentRealizations", false, "Update Program Code from UModel Project", null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", b);
		
		MergeProgramCode();		
		
		openComponentRelations();		
		assertAreas(MESSAGES, PROPERTIES);
		
	}
	
	
	/*
	 * generateMissingCodeFileNames: off
	 * generateMissingComponentrealization: on
	 * componetRealization: 1 less
	 */

	@Test
	public void testCodeEngineering_generateMissingCodeFileNames_off_test2() {
			
		robot.openFile(UPDATE_PROGRAM_MISSING_FILENAME_2.getAbsolutePath());
		robot.openDiagram("ClassDiagram1");
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Generate missing code file names", false, "Update Program Code from UModel Project", null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		a.applyOption(robot);

		CheckboxOption b = new CheckboxOption("Generate missing ComponentRealizations", true, "Update Program Code from UModel Project", null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", b);
		delay(1000);
		
		MergeProgramCode();		
		
		openComponentRelations();	
		assertAreas(MESSAGES, PROPERTIES);
		
	}
	
	
	@Test
	public void testCodeEngineering_generateMissingCodeFileNames_off() {
			
		robot.openFile(UPDATE_PROGRAM_MISSING_FILENAME.getAbsolutePath());
		robot.openDiagram("ClassDiagram1");
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Generate missing code file names", false, "Update Program Code from UModel Project", null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", a);
		delay(1000);
		
		MergeProgramCode();		
		
		robot.findDialog("Class1");		
		assertAreas(MESSAGES, PROPERTIES);
		
	}
	
	@Test
	public void testCodeEngineering_generateMissingCodeFileNames_on() {
			
		robot.openFile(UPDATE_PROGRAM_MISSING_FILENAME.getAbsolutePath());
		robot.openDiagram("ClassDiagram1");
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Generate missing code file names", true, "Update Program Code from UModel Project", null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", a);
		delay(1000);
		
		MergeProgramCode();		
		
		robot.findDialog("Class1");		
		assertAreas(MESSAGES, PROPERTIES);
		
	}

	
	@Test
	public void testCodeEngineering_generateMissingCodeFileNames_on_Java_on() {
			
		robot.openFile(NAMESPACE_FORCODEFILEPATH_JAVA.getAbsolutePath());
		robot.openDiagram("Content of folder10");
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Generate missing code file names", true, "Update Program Code from UModel Project", null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		
		CheckboxOption b = new CheckboxOption("Java", true, "Update Program Code from UModel Project", "Use namespace for code file path",  null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", b);
		delay(1000);
		
		MergeProgramCode();		
		
		robot.findDialog("NamespaceTest");
		delay(1000);
		assertAreas(MESSAGES, PROPERTIES);
		
	}

	@Test
	public void testCodeEngineering_generateMissingCodeFileNames_on_CS_on() {
		
		robot.openFile(NAMESPACE_FORCODEFILEPATH_CS.getAbsolutePath());
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Generate missing code file names", true, "Update Program Code from UModel Project", null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		
		CheckboxOption b = new CheckboxOption("C#", true, "Update Program Code from UModel Project", "Use namespace for code file path",  null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", b);
		delay(1000);
		
		MergeProgramCode();		
		
		robot.findDialog("Class1");
		delay(1000);
		assertAreas(MESSAGES, PROPERTIES);
	}

	@Test
	public void testCodeEngineering_generateMissingCodeFileNames_on_VB_on() {
		
		robot.openFile(NAMESPACE_FORCODEFILEPATH_VB.getAbsolutePath());
		
		robot.activateDiagramTreePane();
		robot.findDialog("OnCreateMainForm");
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Generate missing code file names", true, "Update Program Code from UModel Project", null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		
		CheckboxOption b = new CheckboxOption("VB", true, "Update Program Code from UModel Project", "Use namespace for code file path",  null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", b);
		delay(1000);
		
		MergeProgramCode();	
		
		robot.activateDiagramTreePane();
		robot.findDialog("MySettingsProperty");
		delay(1000);
		assertAreas(MESSAGES, PROPERTIES);

	}
	
	@Test
	public void testCodeEngineering_IgnoreDirectories_off() {
		
		robot.newPrj();
		
		robot.activateOptionsDialog();

		CheckboxOption x = new CheckboxOption("Ignore directories:", true, null, null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		x.applyOption(robot);
		
		TextFieldOption t = new TextFieldOption("Ignore directories", true ,"folder2;folder4;", "Update UModel Project from Program Code", null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		t.applyOption(robot);
		
		CheckboxOption a = new CheckboxOption("Ignore directories:", false, null, null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", a);
		
		ImportSourceDirAndSave();
		robot.activatePane(MODEL_TREE);
		robot.findDialog("folder1");	
		delay(1000);
		robot.keyType(VK_PLUS); //expand folder1 to look the correct filter
		delay(1000);
		
		assertAreas(MODEL_TREE, MESSAGES);
		
		
	}
	
	@Test
	public void testCodeEngineering_IgnoreDirectories_on() {
		
		
		robot.newPrj();
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Ignore directories:", true, null, null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		a.applyOption(robot);

		TextFieldOption t = new TextFieldOption("Ignore directories", true ,"folder2;folder4;",null, null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", t);
		
		ImportSourceDirAndSave();
		robot.activatePane(MODEL_TREE);
		robot.findDialog("folder1");	
		delay(1000);
		robot.keyType(VK_PLUS); //expand folder1 to look the correct filter
		delay(1000);
		
		assertAreas(MODEL_TREE, MESSAGES);
	}
	
	
	@Test
	public void testCodeEngineering_IgnoreDirectories_on_CVS() {
		
		robot.newPrj();
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Ignore directories:", true, null, null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		a.applyOption(robot);

		TextFieldOption t = new TextFieldOption("Ignore directories", true ,"CVS;", null, null,  null, "Code Engineering",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", t);
		
		ImportSourceDirAndSave();
		robot.activatePane(MODEL_TREE);
		robot.findDialog("folder1");	
		delay(1000);
		robot.keyType(VK_PLUS); //expand folder1 to look the correct filter
		delay(1000);
		
		assertAreas(MODEL_TREE, MESSAGES);
	}
	
	//

	private void checkSyntax(){
	
		//robot.clearMessages();
		robot.syntaxCheck();
	}
	
	private void MergeProgramCode(){
		
		if(robot.isWindowOn("Messages"))
			robot.clearMessages();
		
		robot.modelToCodeDoNotCheckIfErrors(null); 
		
		robot.activatePane(MODEL_TREE);
		delay(500);
	}
	
	
	private void ImportSourceDirAndSave(){
		Options options = new Options();
		options.add(new DropDownOption("Language", "Java6.0"));
		options.add(new TextFieldOption("Directory", IMPORT_SOURCE_DIR.getAbsolutePath()));
		options.add(new CheckboxOption("Import directories relative to UModel project file",false));
		robot.importSourceDirectory(options);
		deleteTmpFile(TMP_SAVED_UMP.getAbsolutePath());
		robot.saveReplacePrj(TMP_SAVED_UMP.getAbsolutePath());
		
		
	}
	
	private void deleteTmpFile(String tmps){
		
		File tmpFile = new File(tmps); 		
		if(tmpFile.exists()){
			tmpFile.delete();
		}
		
	}
	
	
	private void openComponentRelations(){
		
		robot.findDialog("Component View");
		delay(500);
		
	    for (int i = 0; i < 3; i++) {

	    	robot.keyType(VK_PLUS);
			delay(500);
			robot.keyType(VK_DOWN);
			delay(500);		
		}
		
		
	}
	
	
	
}
