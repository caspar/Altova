package com.altova.umodel.regression.testcases;

import static com.altova.robots.SnapshotArea.CommonArea.FULLSCREEN;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.umodel.regression.gui.UModelRobot.HIERARCHY;
import static com.altova.umodel.regression.gui.UModelRobot.FAVORITES;
import static com.altova.umodel.regression.gui.UModelRobot.PROPERTIES;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.robots.ImageRecognitionRobot;
import java.awt.Rectangle;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_PAGE_DOWN;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_T;
import static java.awt.event.KeyEvent.VK_Y;
import static java.awt.event.KeyEvent.VK_F7;
import static java.awt.event.KeyEvent.VK_F8;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;

import java.awt.Rectangle;
import java.awt.Robot;
import java.io.File;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.DropDownOption;
import com.altova.robots.CheckboxOption;
import com.altova.robots.RadioOption;
import com.altova.umodel.regression.gui.UModelRobot;
import com.altova.util.IOUtils;

public class OptionsEditingTabTest extends AbstractUmodelTest{

	protected static final File ASK_BEFORE_DELETE_UMP = IOUtils.findFile("examples_UModel/option_tool_ask_before_delete.ump");
	protected static final File SET_DEFAULT_VISIBILITY_UMP = IOUtils.findFile("examples_UModel/option_tool_set_default_visibility.ump");	

	static final String CLASS_DIAGRAM_1 = "ClassDiagram1";
	
	@BeforeClass
	public static void setUpBeforeOption()throws Exception{
		
		if(robot == null) {
			robot = new UModelRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
		robot.customizeKeyboard("Tools", "Options...", VK_T);
	}
	
	
	@Test
	public void testEditingOpenNewDiagram_off() {
		
		robot.newPrj();
				
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Open new diagrams", false, "When adding new items", null,  null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",a);		
		robot.newDiagram("Class Diagram");		
		assertNull(robot.getDiagramComponent());
	}
	
	@Test
	public void testEditingOpenNewDiagram_on() {
		
		robot.newPrj();
				
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Open new diagrams", true, "When adding new items", null,  null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",a);
		robot.newDiagram("Class Diagram");			
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public void testEditingInFavouritesTree_on() {
		
		robot.newPrj();
				
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("in Favorites Tree", true, "Ask before deleting from project", null,  null, "Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption b = new CheckboxOption("in diagrams", false, "Ask before deleting from project", null,  null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options", b);
		
		robot.newDiagram("Class Diagram");		
		
		robot.selectDiagramMenuItem("ClassDiagram1", "Add to Favorites");
	
		robot.activatePane(FAVORITES);delay(1500);
		robot.keyType(VK_PAGE_DOWN);
		robot.delete();
		delay(1000);
		robot.escapeDialog("This action deletes the selected element from the project", VK_ENTER);
		
		assertAreas(FAVORITES);
		
		//robot.keyType(VK_Y);


	}
	
	
	@Test
	public void testEditingInFavouritesTree_off() {
		
		robot.newPrj();
				
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("in Favorites Tree", false, "Ask before deleting from project", null,  null, "Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption b = new CheckboxOption("in diagrams", false, "Ask before deleting from project", null,  null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",b);
		
		robot.newDiagram("Class Diagram");		
		
		robot.selectDiagramMenuItem("ClassDiagram1", "Add to Favorites");
	
		robot.activatePane(FAVORITES);delay(1500);
		robot.keyType(VK_PAGE_DOWN);
		robot.delete();
		delay(1000);
		assertTrue(robot.isApplicationFront());
		
		assertAreas(FAVORITES);
	}
	
	@Test
	public void testEditingInDiagrams_on() {
		
		robot.openFile(ASK_BEFORE_DELETE_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("in Favorites Tree", false, "Ask before deleting from project", null,  null, "Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption b = new CheckboxOption("in diagrams", true, "Ask before deleting from project", null,  null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",b);
		
		robot.findDialog("Interface1");
		
		robot.copy();
		robot.paste();
		robot.delete(); //delete the copy of the object
		robot.escapeDialog("This action deletes the selected element completely", VK_Y);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);


	}
	
	@Test
	public void testEditingInDiagrams_off() {
		
		robot.openFile(ASK_BEFORE_DELETE_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("in Favorites Tree", false, "Ask before deleting from project", null,  null, "Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption b = new CheckboxOption("in diagrams", false, "Ask before deleting from project", null,  null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",b);
		
		robot.findDialog("Interface1");
		
		robot.copy();
		robot.paste();
		robot.delete(); //delete the copy of the object
		delay(1000);
		assertTrue(robot.isApplicationFront());
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public void testEditingInDiagrams_Allon() {
		
		robot.openFile(ASK_BEFORE_DELETE_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("in Favorites Tree", true, "Ask before deleting from project", null,  null, "Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption b = new CheckboxOption("in diagrams", true, "Ask before deleting from project", null,  null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",b);
		
		robot.findDialog("Interface1");
		
		robot.copy();
		robot.paste();
		robot.delete(); //delete the copy of the object
		robot.escapeDialog("This action deletes the selected element completely", VK_Y);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);

	}
	
	@Test
	public void testEditingProperties_private() {
		
		robot.openFile(SET_DEFAULT_VISIBILITY_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
		
		robot.activateOptionsDialog();
		DropDownOption d = new DropDownOption ("Properties", false, "private", "When adding new items", "Set default visibility", null, "Editing",MS_SHELL_DLG_FONT);		
		robot.applyOptionsEnter("Local Options",d);
		
		robot.findDialog("Class1");
		robot.keyType(VK_F7);
		
		assertAreas(PROPERTIES);

		
	}
	
	@Test
	public void testEditingProperties_package() {
		
		robot.openFile(SET_DEFAULT_VISIBILITY_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
		
		robot.activateOptionsDialog();
		DropDownOption d = new DropDownOption ("Properties", false, "package", "When adding new items", "Set default visibility", null, "Editing",MS_SHELL_DLG_FONT);		
		robot.applyOptionsEnter("Local Options",d);
		
		robot.findDialog("Class1");
		robot.keyType(VK_F7);
		
		assertAreas(PROPERTIES);

		
	}
	
	@Test
	public void testEditingProperties_protected() {
		
		robot.openFile(SET_DEFAULT_VISIBILITY_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
		
		robot.activateOptionsDialog();
		DropDownOption d = new DropDownOption ("Properties", false, "protected", "When adding new items", "Set default visibility", null, "Editing",MS_SHELL_DLG_FONT);		
		robot.applyOptionsEnter("Local Options",d);
		robot.findDialog("Class1");
		robot.keyType(VK_F7);
		
		assertAreas(PROPERTIES);
		
	}
	
	@Test
	public void testEditingOperation_protected() {
		
		robot.openFile(SET_DEFAULT_VISIBILITY_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
		
		robot.activateOptionsDialog();
		DropDownOption d = new DropDownOption ("Operations", false, "protected", "When adding new items", "Set default visibility", null, "Editing",MS_SHELL_DLG_FONT);		
		robot.applyOptionsEnter("Local Options",d);
		
		robot.findDialog("Class1");
		robot.keyType(VK_F8);
		
		assertAreas(PROPERTIES);
		
	}
	
	@Test
	public void testEditingOperation_package() {
		
		robot.openFile(SET_DEFAULT_VISIBILITY_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
		
		robot.activateOptionsDialog();
		DropDownOption d = new DropDownOption ("Operations", false, "package", "When adding new items", "Set default visibility", null, "Editing",MS_SHELL_DLG_FONT);		
		robot.applyOptionsEnter("Local Options",d);
		
		robot.findDialog("Class1");
		robot.keyType(VK_F8);
		
		assertAreas(PROPERTIES);
		
	}
	
	@Test
	public void testEditingOperation_public() {
		
		robot.openFile(SET_DEFAULT_VISIBILITY_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
		
		robot.activateOptionsDialog();
		DropDownOption d = new DropDownOption ("Operations", false, "public", "When adding new items", "Set default visibility", null, "Editing",MS_SHELL_DLG_FONT);		
		robot.applyOptionsEnter("Local Options",d);
		
		robot.findDialog("Class1");
		robot.keyType(VK_F8);
		
		assertAreas(PROPERTIES);
				
	}
	
	@Test
	public void testEditingComponents_VB71() {
		
		robot.newPrj();
		robot.activateOptionsDialog();
		DropDownOption d = new DropDownOption ("Components", false, "VB7.1", "When adding new items", "Set default code language", null, "Editing",MS_SHELL_DLG_FONT);		
		
		robot.applyOptionsEnter("Local Options",d);
		
		robot.newRootElement("Component", "component_vb71");
		
		assertAreas(PROPERTIES);
		
		
	}

	
	@Test
	public void testEditingComponents_CS3() {

		robot.newPrj();
		robot.activateOptionsDialog();
		DropDownOption d = new DropDownOption ("Components", false, "C#3.0", "When adding new items", "Set default code language", null, "Editing",MS_SHELL_DLG_FONT);		
		robot.applyOptionsEnter("Local Options",d);
		
		robot.newRootElement("Component", "component_cs3");
		
		assertAreas(PROPERTIES);

	}


	@Test
	public void testEditingComponents_Java14() {
		
		robot.newPrj();
		robot.activateOptionsDialog();
		DropDownOption d = new DropDownOption ("Components", false, "Java1.4", "When adding new items", "Set default code language", null, "Editing",MS_SHELL_DLG_FONT);		
		robot.applyOptionsEnter("Local Options",d);
		
		robot.newRootElement("Component", "component_Java14");
		
		assertAreas(PROPERTIES);

		
	}

	@Test
	public void testEditingComponents_CS12() {

		robot.newPrj();
		robot.activateOptionsDialog();
		DropDownOption d = new DropDownOption ("Components", false, "C#1.2", "When adding new items", "Set default code language", null, "Editing",MS_SHELL_DLG_FONT);		
		robot.applyOptionsEnter("Local Options",d);
		
		robot.newRootElement("Component", "component_cs12");
		
		assertAreas(PROPERTIES);

	}
	
	@Test
	public void testEditingComponents_XSD10() {

		robot.newPrj();
		robot.activateOptionsDialog();
		DropDownOption d = new DropDownOption ("Components", false, "XSD1.0", "When adding new items", "Set default code language", null, "Editing",MS_SHELL_DLG_FONT);		
		robot.applyOptionsEnter("Local Options",d);
		
		robot.newRootElement("Component", "component_xsd10");
		
		assertAreas(PROPERTIES);

	}
	
	@Test
	public void testEditingComponents_Java6() {
		
		robot.newPrj();
		robot.activateOptionsDialog();
		DropDownOption d = new DropDownOption ("Components", false, "Java6.0", "When adding new items", "Set default code language", null, "Editing",MS_SHELL_DLG_FONT);		
		robot.applyOptionsEnter("Local Options",d);
		
		robot.newRootElement("Component", "component_Java6");
		
		assertAreas(PROPERTIES);

		
	}
	
	@Test
	public void testEditingConstraint_Constraint_off() {
		
		robot.newPrj();
		robot.activateOptionsDialog();				
		CheckboxOption c = new CheckboxOption("Constrain owner", false, "When adding new items", "Constraints",  null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);

		robot.newRootElements("New element", "new_constraint_1", "Constraints", "New element>Constraints>Constraint");
		
		assertAreas(PROPERTIES);
	}
	
	
	@Test
	public void testEditingConstraint_Constraint_on() {
		
		
		robot.newPrj();
		robot.activateOptionsDialog();				
		CheckboxOption c = new CheckboxOption("Constrain owner", true, "When adding new items", "Constraints",  null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);

		robot.newRootElements("New element", "new_constraint_1", "Constraints", "New element>Constraints>Constraint");
		
		assertAreas(PROPERTIES);
	}

	@Ignore
	@Test
	public void testEditingConstraint_Comment_off() {
		
		robot.newPrj();
		robot.activateOptionsDialog();				
		CheckboxOption c = new CheckboxOption("New constraints constrain owner", false, "When adding new items", "Constraints and Comments",  null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);

		
		robot.newRootElements("New element", "new_comment_1", "Comment");
		
		assertAreas(PROPERTIES);
	}
	
	@Ignore
	@Test
	public void testEditingConstraint_Comment_on() {
		
		
		robot.newPrj();
		robot.activateOptionsDialog();				
		CheckboxOption c = new CheckboxOption("New constraints constrain owner", true, "When adding new items", "Constraints and Comments",  null, "Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);

		robot.newRootElements("New element", "new_comment_1", "Comment");
		
		assertAreas(PROPERTIES);
	}
	
}
