package com.altova.umodel.regression.testcases;

import static com.altova.robots.SnapshotArea.CommonArea.FULLSCREEN;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;
import static com.altova.umodel.regression.gui.UModelRobot.HIERARCHY;
import static com.altova.umodel.regression.gui.UModelRobot.FAVORITES;
import static com.altova.umodel.regression.gui.UModelRobot.PROPERTIES;
import static java.awt.event.KeyEvent.*;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.robots.CheckboxOption;
import com.altova.robots.TextFieldOption;
import com.altova.umodel.regression.gui.UModelRobot;
import com.altova.util.IOUtils;

public class OptionsDiagramEditingTabTest extends AbstractUmodelTest{
	
	protected static final File STYLE_UMP = IOUtils.findFile("examples_UModel/option_tool_style_2_element.ump");	
	protected static final File STYLEEXT_PNT_UMP = IOUtils.findFile("examples_UModel/option_tool_style_use_cases.ump");
	protected static final File TAGGED_VAL_UMP = IOUtils.findFile("examples_UModel/option_tool_style_tagged_values.ump");	
	protected static final File AUTOM_ASSOC_UMP = IOUtils.findFile("examples_UModel/option_tool_style_automat_create_association.ump");	
	protected static final File RESOLVE_COLLECTION_UMP = IOUtils.findFile("examples_UModel/option_tool_resolve_collection.ump");	
	protected static final File RESOLVE_UNQUALIFIED_UMP = IOUtils.findFile("examples_UModel/option_tool_resolve_unqualified.ump");	
	
	static final String CLASS_DIAGRAM_1 = "ClassDiagram1";
	static final String USE_CASE_DIAGRAM_1 = "UseCaseDiagram1";	
	static final String CONTENT_OF_CLASSES_1 = "Content of Classes";

	@BeforeClass
	public static void setUpBeforeOption()throws Exception{
		
		if(robot == null) {
			robot = new UModelRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
		robot.customizeKeyboard("Tools", "Options...", VK_T);
	}
	
	@Test
	public void testDiagramEditing_Style_AlwaysShow_on() {
		
		
		robot.openFile(STYLE_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(2);
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",a);

		findClass1AndShowFeatures("Class1","Full Generalization");

		robot.escapeDialog("Are you sure you want to add 3 new items?", VK_Y);
		robot.delay(2000);
		
//		asserting the "Styles of new items window"
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(KeyEvent.VK_ENTER);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}
	
	
	@Test
	public void testDiagramEditing_Style_AlwaysShow_off() {
		
		
		robot.openFile(STYLE_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(2);
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",a);

		findClass1AndShowFeatures("Class1", "Full Generalization");
		
		robot.escapeDialog("Are you sure you want to add 3 new items?", VK_Y);
		assertTrue(robot.isApplicationFront()); //asserting that the "Styles of new items window" is not there
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}	
	
	@Test
	public void testDiagramEditing_Style_Attributes_on_2_items() {
		
		
		robot.openFile(STYLE_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(2);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Show Attributes compartment", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		c.applyOption(robot);
		CheckboxOption o = new CheckboxOption("Show Operations compartment", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",o);

		findClass1AndShowFeatures("Class1", "Full Generalization");
		
		robot.escapeDialog("Are you sure you want to add 3 new items?",VK_Y);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}
	
	
	
	@Test
	public void testDiagramEditing_Style_Attributes_on_4_items() {
		
		
		robot.openFile(STYLE_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(4);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Show Attributes compartment", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		c.applyOption(robot);
		CheckboxOption o = new CheckboxOption("Show Operations compartment", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",o);

		findClass1AndShowFeatures("Class1", "Full Generalization");
		delay(1000);
		assertTrue(robot.isApplicationFront());
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}		
	
	
	
	@Test
	public void testDiagramEditing_Style_Operations_on_2_items() {
		
		
		robot.openFile(STYLE_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(2);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption o = new CheckboxOption("Show Operations compartment", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		o.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Show Attributes compartment", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);

		findClass1AndShowFeatures("Class1", "Full Generalization");
		delay(1000);
		robot.escapeDialog("Are you sure you want to add 3 new items?",VK_Y);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}
	
	
	
	@Test
	public void testDiagramEditing_Style_Operations_on_4_items() {
		
		
		robot.openFile(STYLE_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(4);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption o = new CheckboxOption("Show Operations compartment", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		o.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Show Attributes compartment", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);

		findClass1AndShowFeatures("Class1", "Full Generalization");
		delay(1000);
		assertTrue(robot.isApplicationFront());
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}
	
	@Test
	public void testDiagramEditing_Style_AttributeAndOperations() {
		
		
		robot.openFile(STYLE_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(2);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption o = new CheckboxOption("Show Operations compartment", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		o.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Show Attributes compartment", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);

		findClass1AndShowFeatures("Class1", "Full Generalization");

		delay(1000);
		robot.escapeDialog("Are you sure you want to add 3 new items?",VK_Y);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}
	

	
	@Test
	public void testDiagramEditing_Style_NestedClassifiers_on() {
		
		
		robot.openFile(STYLE_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(2);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption o = new CheckboxOption("Show Operations compartment", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		o.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Show Attributes compartment", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		c.applyOption(robot);
		CheckboxOption n = new CheckboxOption("Show nested Classifiers compartmen", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",n);

		findClass1AndShowFeatures("Class1", "Full Generalization");
		
		delay(1000);
		robot.escapeDialog("Are you sure you want to add 3 new items?",VK_Y);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}
	
	
	@Test
	public void testDiagramEditing_Style_NestedClassifiers_off() {
		
		
		robot.openFile(STYLE_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(2);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption o = new CheckboxOption("Show Operations compartment", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		o.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Show Attributes compartment", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		c.applyOption(robot);
		CheckboxOption n = new CheckboxOption("Show nested Classifiers compartmen", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",n);

		findClass1AndShowFeatures("Class1", "Full Generalization");
		
		delay(1000);
		robot.escapeDialog("Are you sure you want to add 3 new items?",VK_Y);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}
	
	
	@Test
	public void testDiagramEditing_Style_NestedClassifiers_all_on() {
		
		
		robot.openFile(STYLE_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(2);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption o = new CheckboxOption("Show Operations compartment", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		o.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Show Attributes compartment", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		c.applyOption(robot);
		CheckboxOption n = new CheckboxOption("Show nested Classifiers compartmen", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",n);

		findClass1AndShowFeatures("Class1", "Full Generalization");
		
		delay(1000);
		robot.escapeDialog("Are you sure you want to add 3 new items?",VK_Y);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}
	
	@Test
	public void testDiagramEditing_Style_NestedClassifiers_on_4_items() {
		
		
		robot.openFile(STYLE_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(4);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption o = new CheckboxOption("Show Operations compartment", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		o.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Show Attributes compartment", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		c.applyOption(robot);
		CheckboxOption n = new CheckboxOption("Show nested Classifiers compartmen", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",n);

		findClass1AndShowFeatures("Class1", "Full Generalization");
		delay(1000);
		assertTrue(robot.isApplicationFront());
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}
	
	@Test
	public void testDiagramEditing_Style_NestedClassifiers_all_on_4_items() {
		
		
		robot.openFile(STYLE_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(4);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption o = new CheckboxOption("Show Operations compartment", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		o.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Show Attributes compartment", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		c.applyOption(robot);
		CheckboxOption n = new CheckboxOption("Show nested Classifiers compartmen", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",n);

		findClass1AndShowFeatures("Class1", "Full Generalization");
		delay(1000);
		assertTrue(robot.isApplicationFront());
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}
	

	@Test
	public void testDiagramEditing_Style_EnumerationLiteral_on() {
		
		
		robot.openFile(STYLE_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(2);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Show EnumerationLiterals compartment", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);

		findClass1AndShowFeatures("Class1", "Dependencies (supplier)");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}
	
	
	@Test
	public void testDiagramEditing_Style_EnumerationLiteral_off() {
		
		
		robot.openFile(STYLE_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(2);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Show EnumerationLiterals compartment", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);

		findClass1AndShowFeatures("Class1", "Dependencies (supplier)");
		
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}
	
	
	@Test
	public void testDiagramEditing_Style_ExtensionPoint_off() {
		
		
		robot.openFile(STYLEEXT_PNT_UMP.getAbsolutePath());
		robot.openDiagram(USE_CASE_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(2);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Show ExtensionPoints compartment", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);

		findClass1AndShowFeatures("UseCase2", "Generalizations (specific)");
		
		robot.delay(1000);
		robot.escapeDialog("Are you sure you want to add 3 new items?",VK_Y);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}	
	

	@Test
	public void testDiagramEditing_Style_ExtensionPoint_on() {
		
		
		robot.openFile(STYLEEXT_PNT_UMP.getAbsolutePath());
		robot.openDiagram(USE_CASE_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(2);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Show ExtensionPoints compartment", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);
		findClass1AndShowFeatures("UseCase2", "Generalizations (specific)");
		robot.delay(1000);
		robot.escapeDialog("Are you sure you want to add 3 new items?",VK_Y);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}	
	
	@Test
	public void testDiagramEditing_Style_ExtensionPoint_4items_off() {
		
		
		robot.openFile(STYLEEXT_PNT_UMP.getAbsolutePath());
		robot.openDiagram(USE_CASE_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(4);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Show ExtensionPoints compartment", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);

		findClass1AndShowFeatures("UseCase2", "Generalizations (specific)");
		
		delay(1000);
		assertTrue(robot.isApplicationFront());
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}	
	

	@Test
	public void testDiagramEditing_Style_ExtensionPoint_4items_on() {
		
		
		robot.openFile(STYLEEXT_PNT_UMP.getAbsolutePath());
		robot.openDiagram(USE_CASE_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(4);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Show ExtensionPoints compartment", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);

		findClass1AndShowFeatures("UseCase2", "Generalizations (specific)");
		
		delay(1000);
		assertTrue(robot.isApplicationFront());
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}	
	
	
	
	@Test
	public void testDiagramEditing_Style_TaggedValues_on_4_items() {
		
		
		robot.openFile(TAGGED_VAL_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(4);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Show Tagged Values", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);

		findClass1AndShowFeatures("Class1", "Full Generalization");
		delay(1000);
		assertTrue(robot.isApplicationFront());
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}		
	
	
	
	@Test
	public void testDiagramEditing_Style_TaggedValues_on_2_items() {
		
		
		robot.openFile(TAGGED_VAL_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(2);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption o = new CheckboxOption("Show Tagged Values", true, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",o);

		findClass1AndShowFeatures("Class1", "Full Generalization");
		robot.delay(1000);
		robot.escapeDialog("Are you sure you want to add 4 new items?",VK_Y);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}

	@Test
	public void testDiagramEditing_Style_TaggedValues_off_4_items() {
		
		
		robot.openFile(TAGGED_VAL_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(4);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption c = new CheckboxOption("Show Tagged Values", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);
		findClass1AndShowFeatures("Class1", "Full Generalization");
		delay(1000);
		assertTrue(robot.isApplicationFront());
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}		
	
	
	
	@Test
	public void testDiagramEditing_Style_TaggedValues_off_2_items() {
		
		
		robot.openFile(TAGGED_VAL_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
	
		robot.activateOptionsDialog();
		selectNumberOfItem(2);
		
		CheckboxOption a = new CheckboxOption("Always show dialog before adding", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		CheckboxOption o = new CheckboxOption("Show Tagged Values", false, "When automatically adding items on diagrams", "Style",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",o);
		findClass1AndShowFeatures("Class1", "Full Generalization");
		robot.delay(1000);
		robot.escapeDialog("Are you sure you want to add 4 new items?",VK_Y);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
	}

	
	@Test
	public void testDiagramEditing_AutomaCreateAssoc_off() {

		robot.openFile(AUTOM_ASSOC_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Automatically create Associations", false, "When adding items on diagrams", null,  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",a);

		Point p = new Point(500,200);
	
		robot.dropElementOnDiagram("Class1", p);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	public void testDiagramEditing_AutomaCreateAssoc_on() {
		
		robot.openFile(AUTOM_ASSOC_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Automatically create Associations", true, "When adding items on diagrams", null,  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",a);

		Point p = new Point(500,200);
	
		robot.dropElementOnDiagram("Class1", p);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	
	@Test
	public void testDiagramEditing_ResolveCollection_off() {
		
		robot.openFile(RESOLVE_COLLECTION_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Resolve collections", false, "When adding items on diagrams", "Associations to collections",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",a);

		findClass1AndShowFeatures("Property2:AbstractMap", "\"Property2\" as Association");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public void testDiagramEditing_ResolveCollection_on() {
		
		robot.openFile(RESOLVE_COLLECTION_UMP.getAbsolutePath());
		robot.openDiagram(CLASS_DIAGRAM_1);
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Resolve collections", true, "When adding items on diagrams", "Associations to collections",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",a);

		findClass1AndShowFeatures("Property2:AbstractMap", "\"Property2\" as Association");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testDiagramEditing_ResolveUnqualified_off() {
		
		robot.openFile(RESOLVE_UNQUALIFIED_UMP.getAbsolutePath());
		robot.openDiagram(CONTENT_OF_CLASSES_1);
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Unknown externals:", false, "When adding items on diagrams", "Associations to collections",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		
		robot.keyType(VK_DOWN);
		delay(500);
		robot.keyType(VK_DOWN);
		delay(500);
		robot.keyType(VK_ENTER);
		delay(500);
		
		robot.escapeDialog("This will reset all existing associations of your UModel project according to the current", VK_ENTER);
		
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public void testDiagramEditing_ResolveUnqualified_on() {
		
		robot.openFile(RESOLVE_UNQUALIFIED_UMP.getAbsolutePath());
		robot.openDiagram(CONTENT_OF_CLASSES_1);
		
		robot.activateOptionsDialog();
		CheckboxOption a = new CheckboxOption("Unknown externals:", true, "When adding items on diagrams", "Associations to collections",  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		a.applyOption(robot);
		
		robot.keyType(VK_DOWN);
		delay(500);
		robot.keyType(VK_DOWN);
		delay(500);
		robot.keyType(VK_ENTER);
		delay(500);
		robot.escapeDialog("This will reset all existing associations of your UModel project according to the current", VK_ENTER);
		
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		
		robot.escapeDialogUmodel("All associations are up-to-date.", VK_ENTER);
		
		delay(2000);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	

	
	@Test
	public void testDiagramEditing_Autocompletion_off() {
	
		robot.openDiagram(HIERARCHY_DIAGRAM);
		
		robot.activateOptionsDialog();
		CheckboxOption c = new CheckboxOption("Enable automatic entry helper", false , "Autocompletion", null,  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);	
		
		robot.findDialog("Account");
		delay(2000);
		robot.keyType(VK_F8);
		delay(2000);
		robot.keyType(VK_END);
		delay(2000);
		robot.typeString(":");
		delay(100);
		robot.typeString("v");
		robot.escapeDialog("could not be found - would you like to add it?", KeyEvent.VK_ESCAPE);
		assertAreas(DIAGRAM_MAIN_WINDOW); 

	}

	
	@Test
	public void testDiagramEditing_Autocompletion_on() {
		
		robot.openDiagram(HIERARCHY_DIAGRAM);
				
		robot.activateOptionsDialog();
		CheckboxOption c = new CheckboxOption("Enable automatic entry helper", true , "Autocompletion", null,  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Local Options",c);
		
		robot.findDialog("Account");
		delay(2000);
		robot.keyType(VK_F8);
		delay(2000);
		robot.keyType(VK_END);
		delay(2000);
		robot.typeString(":");
		delay(200);
		robot.typeStringEnter("v");
		
		assertAreas(DIAGRAM_MAIN_WINDOW); 
		
	}
	
	
	///////////////////////////////////
	
	public void selectNumberOfItem(int value){
		
		TextFieldOption t = new TextFieldOption("Ask before adding more than", false ,""+value, "When automatically adding items on diagrams", null,  null, "Diagram Editing",MS_SHELL_DLG_FONT);
		t.applyOption(robot);
		
	}
	
	
	public void findClass1AndShowFeatures(String dialog, String subMenu){
				
		robot.findDialog(dialog);		
		robot.delay(1000);		
		robot.keyTypeShift(VK_F10);		
		robot.findOnMenu("Show", subMenu);
		
	}
	

}
