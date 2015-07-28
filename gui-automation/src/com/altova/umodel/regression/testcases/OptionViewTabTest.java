package com.altova.umodel.regression.testcases;

import static com.altova.util.LoggerUtils.logger;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.FULLSCREEN;
import static com.altova.robots.AltovaApplicationRobot.*;
/*import static com.altova.spy.SpyRobot.ATTRIBUTES;
import static com.altova.spy.SpyRobot.ELEMENTS;
import static com.altova.spy.SpyRobot.ENTITIES;
*/
import static com.altova.umodel.regression.gui.UModelRobot.MESSAGES;
import static com.altova.umodel.regression.gui.UModelRobot.MODEL_TREE;
import static com.altova.umodel.regression.gui.UModelRobot.HIERARCHY;

import java.awt.Rectangle;
import java.io.File;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.nativegui.ComponentInfo;
import com.altova.nativegui.NativeGUI;
import com.altova.robots.CheckboxOption;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;
import com.altova.umodel.regression.gui.UModelRobot;
import com.altova.umodel.regression.testcases.AbstractUmodelTest;
import com.altova.util.IOUtils;
import static java.awt.event.KeyEvent.VK_T;

public class OptionViewTabTest extends AbstractUmodelTest{

	protected static final File ALL_ELEM_NOT_USED_UMP = IOUtils.findFile("examples_UModel/option_tool_all_elem_not_used.ump");
	protected static final File HIERARCHY_DEPTH_UMP = IOUtils.findFile("examples_UModel/option_tool_hierarchy.ump");
	
	static final String HIERARCHY_DEPTH_DIAGRAM = "Hier_depth_test";
	
	
	@BeforeClass
	public static void setUpBeforeOption()throws Exception{
		
		if(robot == null) {
			robot = new UModelRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
		robot.customizeKeyboard("Tools", "Options...", VK_T);
	}
	
	
	@Test
	public void testViewFrameTitle_NameOnly() {
		
		robot.activateOptionsDialog();
		RadioOption c = new RadioOption("File name only", "Frame title", null, null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", c);
		ComponentInfo ci = NativeGUI.getForegroundWindowInfo();
		assertEquals("Altova UModel - Bank_Java.ump",ci.getWindowText());
	}
	
	
	@Test
	public void testViewFrameTitle_FullPath() {
		
		robot.activateOptionsDialog();		
		RadioOption c = new RadioOption("Full path name", "Frame title", null, null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", c);
		ComponentInfo ci = NativeGUI.getForegroundWindowInfo();
		assertEquals("Altova UModel - "+BANK_UMP,ci.getWindowText());
	}	
	
	
	@Test
	public void testViewAutolayoutHierarchic_righToLeft() {
		
		robot.openDiagram(HIERARCHY_DIAGRAM);
		
		robot.activateOptionsDialog();		
		RadioOption c = new RadioOption("right to left", "Autolayout Hierarchic", "Grow direction",  null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", c);
		
		robot.leftClickMenuItem("Layout", "Autolayout All", "Hierarchic");
		assertAreas(DIAGRAM_MAIN_WINDOW);		
	}	
	
	@Test
	public void testViewAutolayoutHierarchic_leftToRight() {
		
		robot.openDiagram(HIERARCHY_DIAGRAM);
		
		robot.activateOptionsDialog();		
		RadioOption c = new RadioOption("left to right", "Autolayout Hierarchic", "Grow direction",  null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", c);
		
		robot.leftClickMenuItem("Layout", "Autolayout All", "Hierarchic");
		assertAreas(DIAGRAM_MAIN_WINDOW);		
	}	
	
	@Test
	public void testViewAutolayoutHierarchic_bottomUp() {
		
		robot.openDiagram(HIERARCHY_DIAGRAM);
		
		robot.activateOptionsDialog();		
		RadioOption c = new RadioOption("bottom - up", "Autolayout Hierarchic", "Grow direction",  null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", c);
		
		robot.leftClickMenuItem("Layout", "Autolayout All", "Hierarchic");
		assertAreas(DIAGRAM_MAIN_WINDOW);		
	}	
	
	@Test
	public void testViewAutolayoutHierarchic_topDown() {
		
		robot.openDiagram(HIERARCHY_DIAGRAM);
		
		robot.activateOptionsDialog();		
		RadioOption c = new RadioOption("top - down", "Autolayout Hierarchic", "Grow direction",  null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", c);
		
		robot.leftClickMenuItem("Layout", "Autolayout All", "Hierarchic");
		assertAreas(DIAGRAM_MAIN_WINDOW);		
	}	
	
	
	@Test
	public void testViewListAllElementNotUsed_All() {
		
		
		robot.openFile(ALL_ELEM_NOT_USED_UMP.getAbsolutePath());
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Classifier", true, "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption b = new CheckboxOption("Relations", true, "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		b.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Package", true, "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		c.applyOption(robot);
		CheckboxOption d = new CheckboxOption("InstanceSpecification", true, "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",d);
		
		robot.clearMessages();
		robot.listElementsNotUsed();
		assertAreas(MESSAGES);		
	}	
	
	@Test
	public void testViewListAllElementNotUsed_Classifier_off() {
		
		
		robot.openFile(ALL_ELEM_NOT_USED_UMP.getAbsolutePath());
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Classifier", false , "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption b = new CheckboxOption("Relations", true, "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		b.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Package", true, "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		c.applyOption(robot);
		CheckboxOption d = new CheckboxOption("InstanceSpecification", true, "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",d);
		
		robot.clearMessages();
		robot.listElementsNotUsed();
		assertAreas(MESSAGES);		
	}	
	

	@Test
	public void testViewListAllElementNotUsed_Relations_off() {
		
		
		robot.openFile(ALL_ELEM_NOT_USED_UMP.getAbsolutePath());
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Classifier", true , "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption b = new CheckboxOption("Relations", false, "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		b.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Package", true, "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		c.applyOption(robot);
		CheckboxOption d = new CheckboxOption("InstanceSpecification", true, "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",d);
		
		robot.clearMessages();
		robot.listElementsNotUsed();
		assertAreas(MESSAGES);		
	}		
	
	
	@Test
	public void testViewListAllElementNotUsed_Package_off() {
		
		
		robot.openFile(ALL_ELEM_NOT_USED_UMP.getAbsolutePath());
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Classifier", true , "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption b = new CheckboxOption("Relations", true, "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		b.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Package", false, "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		c.applyOption(robot);
		CheckboxOption d = new CheckboxOption("InstanceSpecification", true, "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",d);
		
		robot.clearMessages();
		robot.listElementsNotUsed();
		assertAreas(MESSAGES);		
	}	
	
	@Test
	public void testViewListAllElementNotUsed_InstanceSpecification_off() {
		
		robot.openFile(ALL_ELEM_NOT_USED_UMP.getAbsolutePath());
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Classifier", true , "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption b = new CheckboxOption("Relations", true, "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		b.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Package", true, "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		c.applyOption(robot);
		CheckboxOption d = new CheckboxOption("InstanceSpecification", false, "List all elements not used in any diagram", null,  null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",d);
		
		robot.clearMessages();
		robot.listElementsNotUsed();
		assertAreas(MESSAGES);		
	}

	@Test
	public void testViewModeltree_off() {
		
		robot.openDiagram(HIERARCHY_DIAGRAM);
		
		robot.activateOptionsDialog();
		CheckboxOption c = new CheckboxOption("Automatically select focused diagram item", false , "Model Tree", null,  null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);
		
		robot.findDialog("CreditCardAccount");
		assertAreas(MODEL_TREE);
		
	}
	
	@Test
	public void testViewModeltree_on() {
		
		robot.openDiagram(HIERARCHY_DIAGRAM);
		
		robot.activateOptionsDialog();
		CheckboxOption c = new CheckboxOption("Automatically select focused diagram item", true , "Model Tree", null,  null, "View",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);
		
		robot.findDialog("CreditCardAccount");
		assertAreas(MODEL_TREE);		
		
	}

	@Test
	public void testViewHierarchyDepth_4() {
		
		robot.openFile(HIERARCHY_DEPTH_UMP.getAbsolutePath());
		robot.openDiagram(HIERARCHY_DEPTH_DIAGRAM);		

		robot.activatePane(HIERARCHY);delay(1500);
		
		robot.activateOptionsDialog();
		TextFieldOption t = new TextFieldOption("Default expanded nesting depth:", false ,"4", "Hierarchy", null,  null, "View",MS_SHELL_DLG_FONT);
		t.setX2(50);
		robot.applyOptionsEnter("Local Options",t);
		
		robot.findDialog("Class1");
		assertAreas(HIERARCHY);		
		
	}
	
	
	@Test
	public void testViewHierarchyDepth_3() {
		
		robot.openFile(HIERARCHY_DEPTH_UMP.getAbsolutePath());
		robot.openDiagram(HIERARCHY_DEPTH_DIAGRAM);		

		robot.activatePane(HIERARCHY);delay(1500);
		
		robot.activateOptionsDialog();
		TextFieldOption t = new TextFieldOption("Default expanded nesting depth:", false ,"3", "Hierarchy", null,  null, "View",MS_SHELL_DLG_FONT);
		t.setX2(50);
		robot.applyOptionsEnter("Local Options",t);
		
		robot.findDialog("Class1");
		assertAreas(HIERARCHY);		
		
	}
	
	@Test
	public void testViewHierarchyDepth_1() {

		robot.openFile(HIERARCHY_DEPTH_UMP.getAbsolutePath());
		robot.openDiagram(HIERARCHY_DEPTH_DIAGRAM);		

		robot.activatePane(HIERARCHY);delay(1500);
		
		robot.activateOptionsDialog();
		TextFieldOption t = new TextFieldOption("Default expanded nesting depth:", false ,"1", "Hierarchy", null,  null, "View",MS_SHELL_DLG_FONT);
		t.setX2(50);
		robot.applyOptionsEnter("Local Options",t);
		
		robot.findDialog("Class1");
		assertAreas(HIERARCHY);	
				
	}
	
	@Test
	public void testViewHierarchyDepth_2() {

		robot.openFile(HIERARCHY_DEPTH_UMP.getAbsolutePath());
		robot.openDiagram(HIERARCHY_DEPTH_DIAGRAM);		

		robot.activatePane(HIERARCHY);delay(1500);
		
		robot.activateOptionsDialog();
		TextFieldOption t = new TextFieldOption("Default expanded nesting depth:", false ,"2", "Hierarchy", null,  null, "View",MS_SHELL_DLG_FONT);
		t.setX2(50);
		robot.applyOptionsEnter("Local Options",t);
		
		robot.findDialog("Class1");
		assertAreas(HIERARCHY);	
		
	}
	
	
}
