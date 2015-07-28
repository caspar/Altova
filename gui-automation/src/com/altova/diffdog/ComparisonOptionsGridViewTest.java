package com.altova.diffdog;

import static com.altova.robots.SnapshotArea.CommonArea.MF_MAIN_WINDOW;
import static java.awt.event.KeyEvent.*;

//import java.io.File;

import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.RadioOption;
//import com.altova.util.IOUtils;

public class ComparisonOptionsGridViewTest extends AbstractDiffDogTest{
	
	@Test	
	public void testPrepare(){
		robot.deleteRegistry();
	}
	
	@Test	
	public void testCheckDetailedDifferencingFalse(){
		robot.compareFiles(DETAILED_DIFF1, DETAILED_DIFF2);
		robot.showGridView();
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption("Detailed differencing",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.deleteRegistry();
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test	
	public void testCheckDetailedDifferencingTrue(){
		robot.compareFiles(DETAILED_DIFF1, DETAILED_DIFF2);
		robot.showGridView();
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption("Detailed differencing",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.deleteRegistry();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test	
	public void testIgnoreOrderOfAtrributes_step1(){
		robot.compareFiles(IGNORE_IRDER_OF_ATTRIBUTES1,IGNORE_IRDER_OF_ATTRIBUTES2);
		robot.showGridView();
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption(" Ignore order of child nodes",false),
				new CheckboxOption("Ignore order of attributes",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found!",VK_ESCAPE);
		robot.deleteRegistry();
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test	
	public void testIgnoreOrderOfAtrributes_step2(){
		robot.compareFiles(IGNORE_IRDER_OF_ATTRIBUTES1,IGNORE_IRDER_OF_ATTRIBUTES2);
		robot.showGridView();
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption(" Ignore order of child nodes",false),
				new CheckboxOption("Ignore order of attributes",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.deleteRegistry();
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test	
	public void testIgnoreOrderAllAttributes(){
		robot.compareFiles(IGNORE_IRDER_OF_CHILD_NODES1,IGNORE_IRDER_OF_CHILD_NODES2);
		robot.showGridView();
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption(" Ignore order of child nodes",true),
				new CheckboxOption("All attributes",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.deleteRegistry();
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test	
	public void testIgnoreOrderNone(){
		robot.compareFiles(IGNORE_IRDER_OF_CHILD_NODES1,IGNORE_IRDER_OF_CHILD_NODES2);
		robot.showGridView();
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption(" Ignore order of child nodes",true),
				new CheckboxOption("None",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.deleteRegistry();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test	
	public void testIgnoreOrderSpecificAttributes(){
		robot.compareFiles(IGNORE_IRDER_OF_CHILD_NODES1,IGNORE_IRDER_OF_CHILD_NODES2);
		robot.showGridView();
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption(" Ignore order of child nodes",true),
				new CheckboxOption("Specific attributes",true));
		robot.leftClickOnIcon(DOTS.getAbsolutePath(), "Ignore node types");
		robot.addNewAttributeGroup("group1","c");
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		delay(1500);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}


@Test	
public void testIgnoreOrderAddElemTxtAsCompDataAndNone(){
	/**
	 *  Comparison Options -XML | Order > Ignore Order of child nodes - Add element text as comparison data && None
	 */
	robot.compareFiles(IGNORE_IRDER_OF_CHILD_NODES1,IGNORE_IRDER_OF_CHILD_NODES2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.setDiffDogOptions(new CheckboxOption(" Ignore order of child nodes",true),
			new RadioOption("None"),
			new CheckboxOption("Add element text as comparison criteria",true));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	robot.deleteRegistry();
	assertAreas(MF_MAIN_WINDOW);
	}



@Test	
public void testIgnoreOrderAddElemTxtAsCompDataAndAll(){
	/**
	 *  Comparison Options -XML | Order > Ignore Order of child nodes - Add element text as comparison data && None
	 */
	robot.compareFiles(IGNORE_IRDER_OF_CHILD_NODES1,IGNORE_IRDER_OF_CHILD_NODES2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.setDiffDogOptions(new CheckboxOption(" Ignore order of child nodes",true),
			new CheckboxOption("All",true));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	if(!robot.escapeDialog("No differences found", VK_ESCAPE))
		fail("'No differences found dialog' should appear");
	robot.openComparisionOptions("XML");
	robot.setDiffDogOptions(new CheckboxOption("Add element text as comparison criteria",true));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}

@Test	
public void testNamespacesIgnoreNamaspacesIgnroePrefixes1(){
	/**
	 *  Comparison Options - XML | Namespace/Prefix > Ignore namespace, Ignore prefixes
		1: Namespace/Prefix | Ignore namespace=false
		2: Namespace/Prefix | Ignore namespace=true
		3: Namespace/Prefix | Ignore namespace=true and Ignore prefixes = false
	 */
	robot.compareFiles(NAMESPACE_PREFIX_1,NAMESPACE_PREFIX_2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.setDiffDogOptions(new CheckboxOption("Ignore namespace",false));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}

@Test	
public void testNamespacesIgnoreNamaspacesIgnroePrefixes2(){
	/**
	 *  Comparison Options - XML | Namespace/Prefix > Ignore namespace, Ignore prefixes
		1: Namespace/Prefix | Ignore namespace=false
		2: Namespace/Prefix | Ignore namespace=true
		3: Namespace/Prefix | Ignore namespace=true and Ignore prefixes = false
	 */
	robot.compareFiles(NAMESPACE_PREFIX_1,NAMESPACE_PREFIX_2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.setDiffDogOptions(new CheckboxOption("Ignore namespace",true));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}

@Test	
public void testNamespacesIgnoreNamaspacesIgnroePrefixes3(){
	/**
	 *  Comparison Options - XML | Namespace/Prefix > Ignore namespace, Ignore prefixes
		1: Namespace/Prefix | Ignore namespace=false
		2: Namespace/Prefix | Ignore namespace=true
		3: Namespace/Prefix | Ignore namespace=true and Ignore prefixes = false
	 */
	robot.compareFiles(NAMESPACE_PREFIX_1,NAMESPACE_PREFIX_2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.setDiffDogOptions(new CheckboxOption("Ignore namespace",true),
			new CheckboxOption("Ignore prefixes",false));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}

@Test	
public void testEntitiesResolveEntities(){
	/**
	 *  Comparison Options - XML | Entities > Resolve Entities
		step1: Entities | Resolve entities = true
		step2: Entities | Resolve entities = false
	 */
	robot.compareFiles(ENTITY1,ENTITY2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.setDiffDogOptions(new CheckboxOption("Resolve entities",true));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}
@Test	
public void testEntitiesResolveEntities2(){
	/**
	 *  Comparison Options - XML | Entities > Resolve Entities
		step1: Entities | Resolve entities = true
		step2: Entities | Resolve entities = false
	 */
	robot.compareFiles(ENTITY1,ENTITY2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.setDiffDogOptions(new CheckboxOption("Resolve entities",false));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}

@Test	
public void testTextIgnoreTextFalse(){
	/**
	 * Comparison Options - XML | Text > Ignore text
	 * step1: Ignore text = false
	 * step2: Ignore text = true
	 */
	
	robot.compareFiles(IGNORE_TEXT1,IGNORE_TEXT2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.setDiffDogOptions(new CheckboxOption("Ignore text",false));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}

@Test	
public void testTextIgnoreTextTrue(){
	/**
	 * Comparison Options - XML | Text > Ignore text
	 * step1: Ignore text = false
	 * step2: Ignore text = true
	 */
	
	robot.compareFiles(IGNORE_TEXT1,IGNORE_TEXT2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.setDiffDogOptions(new CheckboxOption("Ignore text",true));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}

@Test	
public void testTextIgnoreDepthFalse(){
	/**
	 * Comparison Options - XML | Text > Ignore depth
	 * step1: Ignore depth = false
	 * step2: Ignore depth = true
	 */
	
	robot.compareFiles(IGNORE_TEXT1,IGNORE_DEPTH2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.setDiffDogOptions(new CheckboxOption("Ignore node depth",false));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}

@Test	
public void testTextIgnoreDepthTrue(){
	/**
	 * Comparison Options - XML | Text > Ignore depth
	 * step1: Ignore depth = false
	 * step2: Ignore depth = true
	 */
	
	robot.compareFiles(IGNORE_TEXT1,IGNORE_DEPTH2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.setDiffDogOptions(new CheckboxOption("Ignore node depth",true));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}

@Test	
public void testCaseSensitivity1(){
	/**
	 * Comparison Options - XML | Case sensitivity > Ignore case and 'do not ignore case in node names'
	 * step1: Ignore case = false 
	 * do not ignore ... = true and disabled 
	 * 
	 * step2:  Ignore case = true 
	 * do not ignore ... = true and enabled 
	 * 
	 * step3:  Ignore case = true 
	 * do not ignore ... = false and enabled 
	 * 
	 */
	
	robot.compareFiles(CASE_SENSITIVITY1,CASE_SENSITIVITY2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.setDiffDogOptions(new CheckboxOption(" Ignore case",false));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}

@Test	
public void testCaseSensitivity2(){
	/**
	 * Comparison Options - XML | Case sensitivity > Ignore case and 'do not ignore case in node names'
	 * step1: Ignore case = false 
	 * do not ignore ... = true and disabled 
	 * 
	 * step2:  Ignore case = true 
	 * do not ignore ... = true and enabled 
	 * 
	 * step3:  Ignore case = true 
	 * do not ignore ... = false and enabled 
	 * 
	 */
	
	robot.compareFiles(CASE_SENSITIVITY1,CASE_SENSITIVITY2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.setDiffDogOptions(new CheckboxOption(" Ignore case",true));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}

@Test	
public void testCaseSensitivity3(){
	/**
	 * Comparison Options - XML | Case sensitivity > Ignore case and 'do not ignore case in node names'
	 * step1: Ignore case = false 
	 * do not ignore ... = true and disabled 
	 * 
	 * step2:  Ignore case = true 
	 * do not ignore ... = true and enabled 
	 * 
	 * step3:  Ignore case = true 
	 * do not ignore ... = false and enabled 
	 * 
	 */
	
	robot.compareFiles(CASE_SENSITIVITY1,CASE_SENSITIVITY2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.setDiffDogOptions(new CheckboxOption(" Ignore case",true),
			new CheckboxOption("Do not ignore case in node names",false));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}

@Test	
public void testIgnoreNodeTypes1(){
	/**
	 * Comparison Options | XML > Ignore all types
	 * step1: all checkboxes unselected 
	 * 
	 * step2:  all checkboxes checked
	 *  
	 * step2: XML Declaration unchecked  
	 * 
	 * step4: additionally unchecked DOCTYPE and CDATA 
	 * 
	 */
	robot.compareFiles(IGNORE_NODE_TYPES1,IGNORE_NODE_TYPES2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.leftClickOnIcon(CLEARALL.getAbsolutePath(), "Ignore node types");
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}

@Test	
public void testIgnoreNodeTypes2(){
	/**
	 * Comparison Options | XML > Ignore all types
	 * step1: all checkboxes unselected 
	 * 
	 * step2:  all checkboxes checked
	 *  
	 * step2: XML Declaration unchecked  
	 * 
	 * step4: additionally unchecked DOCTYPE and CDATA 
	 * 
	 */
	robot.compareFiles(IGNORE_NODE_TYPES1,IGNORE_NODE_TYPES2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.leftClickOnIcon(SETALL.getAbsolutePath(), "Ignore node types");
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}
@Test	
public void testIgnoreNodeTypes3(){
	/**
	 * Comparison Options | XML > Ignore all types
	 * step1: all checkboxes unselected 
	 * 
	 * step2:  all checkboxes checked
	 *  
	 * step3: XML Declaration unchecked  
	 * 
	 * step4: additionally unchecked DOCTYPE and CDATA 
	 * 
	 */
	robot.compareFiles(IGNORE_NODE_TYPES1,IGNORE_NODE_TYPES2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.leftClickOnIcon(SETALL.getAbsolutePath(), "Ignore node types");
	robot.setDiffDogOptions(new CheckboxOption("XML declaration",false));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}

@Test	
public void testIgnoreNodeTypes4(){
	/**
	 * Comparison Options | XML > Ignore all types
	 * step1: all checkboxes unselected 
	 * 
	 * step2:  all checkboxes checked
	 *  
	 * step3: XML Declaration unchecked  
	 * 
	 * step4: additionally unchecked DOCTYPE and CDATA 
	 * 
	 */
	robot.compareFiles(IGNORE_NODE_TYPES1,IGNORE_NODE_TYPES2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.leftClickOnIcon(SETALL.getAbsolutePath(), "Ignore node types");
	robot.setDiffDogOptions(new CheckboxOption("XML declaration",false),
			new CheckboxOption("DOCTYPE",false),
			new CheckboxOption("CData",false));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}

@Test	
public void testWhitespace1(){
	/**
	 * Comparison Options - XML | Whitespace
	 * step1: "Strip all" 
	 * 
	 * step2: "Compare as is"
	 *  
	 * step3: "Normalize"  
	 * 
	 */
	
	robot.compareFiles(WHITE_SPACES1,WHITE_SPACES2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.setDiffDogOptions(new CheckboxOption("Strip all",true));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}
@Test	
public void testWhitespace2(){
	/**
	 * Comparison Options - XML | Whitespace
	 * step1: "Strip all" 
	 * 
	 * step2: "Compare as is"
	 *  
	 * step3: "Normalize"  
	 * 
	 */
	
	robot.compareFiles(WHITE_SPACES1,WHITE_SPACES2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.setDiffDogOptions(new CheckboxOption("Compare as is",true));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}
@Test	
public void testWhitespace3(){
	/**
	 * Comparison Options - XML | Whitespace
	 * step1: "Strip all" 
	 * 
	 * step2: "Compare as is"
	 *  
	 * step3: "Normalize"  
	 * 
	 */
	
	robot.compareFiles(WHITE_SPACES1,WHITE_SPACES2);
	robot.showGridView();
	robot.openComparisionOptions("XML");
	robot.setDiffDogOptions(new CheckboxOption("Normalize",true));
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}

@Test	
public void testFilterOutSpecificElements(){
	/**
	 * Comparison Options | XML > Filter out specific elements/attributes
	 * step1: build filter "filter1" 
	 * 		insert new element/attribute,
	 * 		select    Attr, value =  "attr1",
	 * 		de-select "Ele"
	 * step2: select "filter1"
	 * 	
	 */
	robot.compareFiles(FILTER1,FILTER2);
	robot.showGridView();
	delay(1000);
	robot.openComparisionOptions("XML");
	robot.leftClickOnIcon(DOTS.getAbsolutePath(), "Ignore node types");
	robot.addNewAttributeGroupFilters("filter1", "attr1");
	delay(2000);
	robot.selectEle(false);
	robot.selectAtt(true);
	robot.okButton();
	robot.keyType(VK_LEFT);
	robot.typeString("filter1");
	robot.leftClickMid(robot.findComponent("OK", "Button", null));
	robot.escapeDialog("No differences found", VK_ESCAPE);
	assertAreas(MF_MAIN_WINDOW);
	robot.deleteRegistry();
}





}
