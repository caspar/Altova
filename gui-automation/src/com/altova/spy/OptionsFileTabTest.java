package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.spy.SpyRobot.VALIDATION;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.TextFieldOption;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.IOUtils;
import com.altova.util.Settings;


public class OptionsFileTabTest extends AbstractSpyOptionsDialogTest{

	private static final String BASE_OUT_DIR=Settings.getOutputDir().getAbsolutePath()+"\\"+AltovaJUnitRunner.getRunName(robot,"OptionsFileTabTest");
	private static final String BASE_EXPECTED_DIR=Settings.getExpectedDir().getAbsolutePath()+"\\"+AltovaJUnitRunner.getRunName(robot,"OptionsFileTabTest");
	private static final String base_name="Option_diagram";
	protected static final File LOGO_DIAGRAM_WITH=new File(BASE_OUT_DIR+"\\"+base_name+"_withlogo.png");
	protected static final File LOGO_DIAGRAM_WITHOUT=new File(BASE_OUT_DIR+"\\"+base_name+"_withoutlogo.png");
	
	@Test
	public final void testExpandAllLinesOnAtOpenGridView() {
		CheckboxOption c = new CheckboxOption("Expand all lines",true,"file in Grid view",null,null,"File   ",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testExpandAllLinesOffAtOpenGridView() {
		CheckboxOption c = new CheckboxOption("Expand all lines",false,"file in Grid view",null,null,"File   ",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		delay(500);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testValidateUponOpeningOff() {
		CheckboxOption c = new CheckboxOption("On Open",false,"Validation",null,null,"File   ",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		delay(500);
		robot.openFile(CONDITIONAL_NOT_VALID);
		assertAreas(VALIDATION);
	}
	
	
	@Test
	public final void testValidateUponOpeningOn() {
		CheckboxOption c = new CheckboxOption("On Open",true,"Validation",null,null,"File   ",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		delay(500);
		robot.openFile(CONDITIONAL_NOT_VALID);
		assertAreas(VALIDATION);
	}
	
	@Test
	public final void testValidateUponSavingOff() {
		removeAndAssert(TEMPORARY_XML);	
		CheckboxOption c = new CheckboxOption("On Save",false,"Validation",null,null,"File   ",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		delay(500);
		robot.openFile(CONDITIONAL_NOT_VALID);
		robot.textView();
		robot.XMLCheckWellFormedness(); //this is to remove former validation checks :)
		robot.saveFileAsNoControl(TEMPORARY_XML.getAbsolutePath());
		assertAreas(VALIDATION);
	}
	
	@Test
	public final void testValidateUponSavingOn() {
		removeAndAssert(TEMPORARY_XML);
		
		CheckboxOption c = new CheckboxOption("On Save",true,"Validation",null,null,"File   ",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		delay(500);
		robot.openFile(CONDITIONAL_NOT_VALID);
		robot.textView();
		robot.leftClickMenuItem("File", "Save As");
		robot.escapeDialog("This file is not valid",KeyEvent.VK_ENTER);
		robot.typeFileName(TEMPORARY_XML.getAbsolutePath());
		assertAreas(VALIDATION);
	}
	
	@Test
	@Ignore //this option cannot be selected anymore
	public final void testSaveFileIncludeCommentOff() {
		removeAndAssert(TEMPORARY_XML);
		CheckboxOption c = new CheckboxOption("Include comment",false,"Save File",null,null,"File   ",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		delay(500);
		robot.gridView();
		robot.saveFileAsNoControl(TEMPORARY_XML.getAbsolutePath());
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	@Ignore //this option cannot be selected anymore
	public final void testSaveFileIncludeCommentOn() {
		removeAndAssert(TEMPORARY_XML);
		CheckboxOption c = new CheckboxOption("Include comment",true,"Save File",null,null,"File   ",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		delay(500);
		robot.gridView();
		robot.saveFileAsNoControl(TEMPORARY_XML.getAbsolutePath());
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	@Ignore //this option cannot be selected anymore
	public final void testSaveFileIncludeLogoOff() {
		if(LOGO_DIAGRAM_WITHOUT.exists()) {
			LOGO_DIAGRAM_WITHOUT.delete();
		}
		assertFileNotExists(LOGO_DIAGRAM_WITHOUT);
		CheckboxOption c = new CheckboxOption("Include in diagrams:",false,"Save File",null,null,"File   ",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		delay(500);
		robot.openFile(IOUtils.findFile("examples/TextState.xsd"));
		robot.schemaSaveDiagram("/xs:schema/xs:element[1]",LOGO_DIAGRAM_WITHOUT.getParent(),LOGO_DIAGRAM_WITHOUT.getName());
		assertImage(new File(BASE_EXPECTED_DIR+"\\"+base_name+"_withoutlogo.png"), LOGO_DIAGRAM_WITHOUT);
	}
	
	@Test 
	@Ignore //this option cannot be selected anymore
	public final void testSaveFileIncludeLogoOn() {
		if(LOGO_DIAGRAM_WITH.exists()) {
			LOGO_DIAGRAM_WITH.delete();
		}
		assertFileNotExists(LOGO_DIAGRAM_WITH);
		CheckboxOption c = new CheckboxOption("Include in diagrams:",true,"Save File",null,null,"File   ",MS_SHELL_DLG_FONT);	
		robot.applyOptionsEnter("Options", c);
		delay(500);
		robot.openFile(IOUtils.findFile("examples/TextState.xsd"));
		robot.schemaSaveDiagram("/xs:schema/xs:element[1]",LOGO_DIAGRAM_WITH.getParent(),LOGO_DIAGRAM_WITH.getName());
		assertImage(new File(BASE_EXPECTED_DIR+"\\"+base_name+"_withlogo.png"), LOGO_DIAGRAM_WITH);
	}
	
	
	@Test
	public final void testSaveFileAuthenticSaveLinkOff() {
		removeAndAssert(TEMPORARY_XML);
		CheckboxOption c = new CheckboxOption("Authentic",false,"Save File",null,null,"File   ",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.openFile(ITEMS_XML_FILE);
		robot.assignSVStylesheet(IOUtils.findFile("examples/OrgChart.sps").getAbsolutePath());
		robot.saveFileAsNoControl(TEMPORARY_XML.getAbsolutePath());
		robot.closeAll();
		robot.openFile(TEMPORARY_XML);
		delay(500);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testSaveFileAuthenticSaveLinkOn() {
		removeAndAssert(TEMPORARY_XML);
		CheckboxOption c = new CheckboxOption("Authentic",true,"Save File",null,null,"File   ",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.openFile(ITEMS_XML_FILE);
		robot.assignSVStylesheet(IOUtils.findFile("examples/OrgChart.sps").getAbsolutePath());
		robot.saveFileAsNoControl(TEMPORARY_XML.getAbsolutePath());
		robot.closeAll();
		robot.openFile(TEMPORARY_XML);
		delay(500);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testNoOutputFormattingForList(){
		TextFieldOption t=new TextFieldOption("No output formatting for:",true,"xs:choice","Save File",null,null,"File",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", t);
		robot.leftClickMid(robot.findComponent("OK", "Button",null));
		robot.openFile(IOUtils.findFile("examples/TextState.xsd"));
		robot.textView();	
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
}
