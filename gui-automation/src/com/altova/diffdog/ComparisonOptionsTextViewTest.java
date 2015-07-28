package com.altova.diffdog;

import static com.altova.robots.SnapshotArea.CommonArea.*;
import static java.awt.event.KeyEvent.*;

//import java.io.File;

import org.junit.Test;

import com.altova.robots.CheckboxOption;
//import com.altova.util.IOUtils;

public class ComparisonOptionsTextViewTest extends AbstractDiffDogTest{


	
	@Test	
	public void testTextShowDifferencesBetweenLinesTrue(){
		/**
		 * Comparison Options - Text | View Results > Show differences between lines
		 * step1: Show differences between lines = true
		 * step2: Show differences between lines = false
		 */
		
		robot.compareFiles(EDGAR_ALLAN_POE1,EDGAR_ALLAN_POE2);
		robot.openComparisionOptions("Text");
		robot.setDiffDogOptions(new CheckboxOption("Show differences within lines",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testTextShowDifferencesBetweenLinesFalse(){
		/**
		 * Comparison Options - Text | View Results > Show differences between lines
		 * step1: Show differences between lines = true
		 * step2: Show differences between lines = false
		 */
		
		robot.compareFiles(EDGAR_ALLAN_POE1,EDGAR_ALLAN_POE2);
		robot.openComparisionOptions("Text");
		robot.setDiffDogOptions(new CheckboxOption("Show differences within lines",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testTextWhitespace1(){
		/**
		 * Comparison Options - Text | Whitespace
		 * step1: Whitespace | Compare as is = true
		 * step2: Whitespace | Strip all = true
		 * step3: Whitespace | Normalize = true
		 * 
		 */
		
		robot.compareFiles(EDGAR_ALLAN_POE_WHITESPACES,EDGAR_ALLAN_POE2);
		robot.openComparisionOptions("Text");
		robot.setDiffDogOptions(new CheckboxOption("Compare as is",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testTextWhitespace2(){
		/**
		 * Comparison Options - Text | Whitespace
		 * step1: Whitespace | Compare as is = true
		 * step2: Whitespace | Strip all = true
		 * step3: Whitespace | Normalize = true
		 * 
		 */
		
		robot.compareFiles(EDGAR_ALLAN_POE_WHITESPACES,EDGAR_ALLAN_POE2);
		robot.openComparisionOptions("Text");
		robot.setDiffDogOptions(new CheckboxOption("Strip all",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testTextWhitespace3(){
		/**
		 * Comparison Options - Text | Whitespace
		 * step1: Whitespace | Compare as is = true
		 * step2: Whitespace | Strip all = true
		 * step3: Whitespace | Normalize = true
		 * 
		 */
		
		robot.compareFiles(EDGAR_ALLAN_POE_WHITESPACES,EDGAR_ALLAN_POE2);
		robot.openComparisionOptions("Text");
		robot.setDiffDogOptions(new CheckboxOption("Normalize",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test	
	public void testCaseSensitivityAndLines1(){
		/**
		 * Comparison Options - Text | Case sensitivity and Lines
		 * step1:
		 *    Case sensitivity | Ignore case = true
		 *    Lines | Ignore blank lines = true
		 * step2:
		 *    Case sensitivity | Ignore case = false
		 *    Lines | Ignore blank lines = false "
		 * 
		 */
		robot.compareFiles(EDGAR_ALLAN_POE_WHITESPACES,EDGAR_ALLAN_POE2);
		robot.openComparisionOptions("Text");
		robot.setDiffDogOptions(new CheckboxOption("Ignore case",true),
				new CheckboxOption("Ignore blank lines",true)
		);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test	
	public void testCaseSensitivityAndLines2(){
		/**
		 * Comparison Options - Text | Case sensitivity and Lines
		 * step1:
		 *    Case sensitivity | Ignore case = true
		 *    Lines | Ignore blank lines = true
		 * step2:
		 *    Case sensitivity | Ignore case = false
		 *    Lines | Ignore blank lines = false
		 * 
		 */
		robot.compareFiles(EDGAR_ALLAN_POE_WHITESPACES,EDGAR_ALLAN_POE2);
		robot.openComparisionOptions("Text");
		robot.setDiffDogOptions(new CheckboxOption("Ignore case",false),
				new CheckboxOption("Ignore blank lines",false)
		);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test	
	public void testCheckDialog(){
		robot.compareFiles(DETAILED_DIFF1,DETAILED_DIFF2);
		robot.openComparisionOptions("XML");
		assertAreas(TOP_WINDOW);
		robot.leftClickMid(robot.findComponent("Cancel", "Button", null));
	}
	
	@Test	
	public void testDetailedDifferencingFalse(){
		robot.compareFiles(DETAILED_DIFF1,DETAILED_DIFF2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption("Detailed differencing",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test	
	public void testDetailedDifferencingTrue(){
		robot.compareFiles(DETAILED_DIFF1,DETAILED_DIFF2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption("Detailed differencing",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test	
	public void testIgnoreOrderOfAttributesTrue(){
		robot.compareFiles(IGNORE_IRDER_OF_ATTRIBUTES1,IGNORE_IRDER_OF_ATTRIBUTES2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption(" Ignore order of child nodes",false),
				new CheckboxOption("Ignore order of attributes",true)
		);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test	
	public void testIgnoreOrderOfAttributesFalse(){
		robot.compareFiles(IGNORE_IRDER_OF_ATTRIBUTES1,IGNORE_IRDER_OF_ATTRIBUTES2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption(" Ignore order of child nodes",false),
				new CheckboxOption("Ignore order of attributes",false)
		);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test	
	public void testIgnoreOrderOfChildNodesAll(){
		robot.compareFiles(IGNORE_IRDER_OF_CHILD_NODES1,IGNORE_IRDER_OF_CHILD_NODES2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption(" Ignore order of child nodes",true),
				new CheckboxOption("All attributes",true)
		);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test	
	public void testIgnoreOrderOfChildNodesNone(){
		robot.compareFiles(IGNORE_IRDER_OF_CHILD_NODES1,IGNORE_IRDER_OF_CHILD_NODES2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption(" Ignore order of child nodes",true),
				new CheckboxOption("None",true)
		);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test	
	public void testSpecificAttributesDialog(){
		robot.compareFiles(IGNORE_IRDER_OF_CHILD_NODES1,IGNORE_IRDER_OF_CHILD_NODES2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption(" Ignore order of child nodes",true),
				new CheckboxOption("Specific attributes",true)
		);
		robot.leftClickOnIcon(DOTS.getAbsolutePath(),"Order");
		robot.addNewAttributeGroup("group1", null);
		delay(500);
		robot.leftClickOnIcon(robot.ADD_GROUP_ICON, "Add attributes as comparison criteria");
		delay(500);
		robot.leftClickOnIcon(robot.ADD_GROUP_ICON, "Attribute groups");
		delay(500);
		robot.escapeDialog("The selected attribute group", VK_Y);
		delay(500);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		delay(500);
		robot.leftClickOnIcon(DOTS.getAbsolutePath(),"Order");
		
		robot.addNewAttributeGroup(null, "c");
		delay(500);
		robot.leftClickOnIcon(robot.ADD_GROUP_ICON, "Attribute groups");
		delay(500);
		robot.addNewAttributeGroup(null, "b");
		delay(500);
		robot.deleteAttribute("b");
		delay(500);
		assertAreas(TOP_WINDOW);
		robot.leftClickMid(robot.findComponent("Cancel", "Button", null));
		delay(500);
		robot.leftClickMid(robot.findComponent("Cancel", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		robot.deleteRegistry();
	}
	
	@Test	
	public void testIgnoreOrderOfChildNodesSpecificAttributes(){
		robot.compareFiles(IGNORE_IRDER_OF_CHILD_NODES1,IGNORE_IRDER_OF_CHILD_NODES2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption(" Ignore order of child nodes",true),
				new CheckboxOption("Specific attributes",true)
		);
		robot.leftClickOnIcon(DOTS.getAbsolutePath(),"Order");
		robot.addNewAttributeGroup("group1", "c");
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		delay(500);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test	
	public void testIgnoreOrderOfChildNodesAddElementAndNone(){
		robot.compareFiles(IGNORE_IRDER_OF_CHILD_NODES1,IGNORE_IRDER_OF_CHILD_NODES2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption(" Ignore order of child nodes",true),
				new CheckboxOption("Add element text as comparison criteria",true),
				new CheckboxOption("None",true)
		);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test	
	public void testIgnoreOrderOfChildNodesAddElementAndAll1(){
		/**
		 * Comparison Options -XML | Order > Ignore Order of child nodes - Add element text as comparison data && All Attributes
		 * 
		 * step1: Order | Ignore Order of child nodes = true
		 * All Attributes = true
		 * Add element text as comparison data = false
		 * step2: Add element text as comparison data = true
		 */
		robot.compareFiles(IGNORE_IRDER_OF_CHILD_NODES_A1,IGNORE_IRDER_OF_CHILD_NODES_A2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption(" Ignore order of child nodes",true),
				new CheckboxOption("Add element text as comparison criteria",false),
				new CheckboxOption("All attributes",true)
		);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test	
	public void testIgnoreOrderOfChildNodesAddElementAndAll2(){
		/**
		 * Comparison Options -XML | Order > Ignore Order of child nodes - Add element text as comparison data && All Attributes
		 * 
		 * step1: Order | Ignore Order of child nodes = true
		 * All Attributes = true
		 * Add element text as comparison data = false
		 * step2: Add element text as comparison data = true
		 */
		robot.compareFiles(IGNORE_IRDER_OF_CHILD_NODES_A1,IGNORE_IRDER_OF_CHILD_NODES_A2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption(" Ignore order of child nodes",true),
				new CheckboxOption("Add element text as comparison criteria",true),
				new CheckboxOption("All attributes",true)
		);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test	
	public void testIgnoreOrderOfChildNodesAndChangeLayout(){
		/**
		 * Comparison Options -XML | Order > Ignore Order of child nodes - Add element text as comparison data && All Attributes
		 * 
		 * step1: Order | Ignore Order of child nodes = true
		 * All Attributes = true
		 * Add element text as comparison data = false
		 * step2: Add element text as comparison data = true
		 */
		robot.compareFiles(IGNORE_IRDER_OF_CHILD_NODES_B1,IGNORE_IRDER_OF_CHILD_NODES_A2);
		robot.setCompareAsXML();
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption(" Ignore order of child nodes",true),
				new CheckboxOption("Add element text as comparison criteria",true),
				new CheckboxOption("All attributes",true)
		);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		delay(500);
		robot.escapeDialog("No differences found", VK_ESCAPE);
		delay(500);
		robot.startComparison();
		delay(500);
		robot.escapeDialog("No differences found", VK_ESCAPE);
		delay(500);
		robot.setPrityPrint();
		delay(500);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test	
	public void testIgnoreOrderNameSpacePrefixFalse1(){
		/**
		 * Comparison Options -XML | Namespace/Prefix > Ignore namespace, Ignore prefixes
		 * 
		 * step1: Namespace/Prefix | Ignore namespace=false
		 * step2: Namespace/Prefix | Ignore namespace=true
		 * step2: Namespace/Prefix | Ignore namespace=true and Ignore prefixes = false
		 */
		
		robot.compareFiles(NAMESPACE_PREFIX_1,NAMESPACE_PREFIX_2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption("Ignore namespace",false),
				new CheckboxOption("Ignore prefixes",true)
		);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test	
	public void testIgnoreOrderNameSpacePrefixFalse2(){
		/**
		 * Comparison Options -XML | Namespace/Prefix > Ignore namespace, Ignore prefixes
		 * 
		 * step1: Namespace/Prefix | Ignore namespace=false
		 * step2: Namespace/Prefix | Ignore namespace=true
		 * step2: Namespace/Prefix | Ignore namespace=true and Ignore prefixes = false
		 */
		
		robot.compareFiles(NAMESPACE_PREFIX_1,NAMESPACE_PREFIX_2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption("Ignore namespace",true),
				new CheckboxOption("Ignore prefixes",true)
		);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test	
	public void testIgnoreOrderNameSpacePrefixFalse3(){
		/**
		 * Comparison Options -XML | Namespace/Prefix > Ignore namespace, Ignore prefixes
		 * 
		 * step1: Namespace/Prefix | Ignore namespace=false
		 * step2: Namespace/Prefix | Ignore namespace=true
		 * step2: Namespace/Prefix | Ignore namespace=true and Ignore prefixes = false
		 */
		
		robot.compareFiles(NAMESPACE_PREFIX_1,NAMESPACE_PREFIX_2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption("Ignore namespace",true),
				new CheckboxOption("Ignore prefixes",false)
		);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test	
	public void testEntitiesTrue(){
	
		robot.compareFiles(ENTITY1,ENTITY2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption("Resolve entities",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test	
	public void testEntitiesFalse(){
	
		robot.compareFiles(ENTITY1,ENTITY2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption("Resolve entities",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test	
	public void testIgnoreTextFalse(){
	
		robot.compareFiles(IGNORE_TEXT1,IGNORE_TEXT2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption("Ignore text",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test	
	public void testIgnoreTextTrue(){
	
		robot.compareFiles(IGNORE_TEXT1,IGNORE_TEXT2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption("Ignore text",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test	
	public void testIgnoreDepthFalse(){
	
		robot.compareFiles(IGNORE_TEXT1,IGNORE_DEPTH2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption("Ignore node depth",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test	
	public void testIgnoreDepthTrue(){
	
		robot.compareFiles(IGNORE_TEXT1,IGNORE_DEPTH2);
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
	 * Comparison Options -XML | Case sensitivity > Ignore case and 'do not ignore case in node names'
	 * step1: Ignore case = false
	 * do not ignore ... = true and disabled
	 * 
	 * step2:  Ignore case = true	
	 * do not ignore ... = true and enabled
	 * step3:  Ignore case = true
	 * do not ignore ... = false and enabled
	 */
		robot.compareFiles(CASE_SENSITIVITY1,CASE_SENSITIVITY2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption("Ignore case",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test	
	public void testCaseSensitivity2(){
	/**
	 * Comparison Options -XML | Case sensitivity > Ignore case and 'do not ignore case in node names'
	 * step1: Ignore case = false
	 * do not ignore ... = true and disabled
	 * 
	 * step2:  Ignore case = true	
	 * do not ignore ... = true and enabled
	 * step3:  Ignore case = true
	 * do not ignore ... = false and enabled
	 */
		robot.compareFiles(CASE_SENSITIVITY1,CASE_SENSITIVITY2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption("Ignore case",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test	
	public void testCaseSensitivity3(){
	/**
	 * Comparison Options -XML | Case sensitivity > Ignore case and 'do not ignore case in node names'
	 * step1: Ignore case = false
	 * do not ignore ... = true and disabled
	 * 
	 * step2:  Ignore case = true	
	 * do not ignore ... = true and enabled
	 * step3:  Ignore case = true
	 * do not ignore ... = false and enabled
	 */
		robot.compareFiles(CASE_SENSITIVITY1,CASE_SENSITIVITY2);
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
		 * step2: "Compare as is"
		 * step3: "Normalize"  
		 */
		robot.compareFiles(WHITE_SPACES1,WHITE_SPACES2);
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
		 * step2: "Compare as is"
		 * step3: "Normalize"  
		 */
		
		robot.compareFiles(WHITE_SPACES1,WHITE_SPACES2);
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
		 * step2: "Compare as is"
		 * step3: "Normalize"  
		 */
		
		robot.compareFiles(WHITE_SPACES1,WHITE_SPACES2);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(new CheckboxOption("Normalize",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test	
	public void testDefineFiltersDialogAppendNewFilterAndElement(){
		robot.compareFiles(FILTER1,FILTER2);
		robot.openComparisionOptions("XML");
		robot.leftClickOnIcon(DOTS.getAbsolutePath(), "Ignore node types");
		robot.addNewAttributeGroupFilters("filter1", "a");
		robot.selectEle(true);
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
		delay(500);
		robot.cancelButton();
		robot.deleteFullRegistry();
	}
	
	@Test	
	public void testDefineFiltersDialogInsetNewFilterAndAtt(){
		robot.compareFiles(FILTER1,FILTER2);
		robot.openComparisionOptions("XML");
		robot.leftClickOnIcon(DOTS.getAbsolutePath(), "Ignore node types");
		robot.addNewAttributeGroupFilters("filter2", "attr2");
		delay(500);
		robot.selectAtt(true);
		delay(500);
		robot.selectEle(false);
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
		delay(500);
		robot.cancelButton();
		robot.deleteFullRegistry();
	}
	@Test	
	public void testDefineFiltersDialogInsetNewFilterAttAndElem1(){
		robot.compareFiles(FILTER1,FILTER2);
		robot.openComparisionOptions("XML");
		robot.leftClickOnIcon(DOTS.getAbsolutePath(), "Ignore node types");
		robot.addNewAttributeGroupFilters("filter3", "attr1");
		delay(500);
		robot.selectAtt(true);
		delay(500);
		robot.selectEle(false);
		delay(500);
		robot.okButton();
		robot.leftClickOnIcon(DOTS.getAbsolutePath(), "Ignore node types");
		robot.addNewAttributeGroupFilters(null, "attr2");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
		delay(200);
		robot.cancelButton();
		robot.deleteFullRegistry();
	}
	@Test	
	public void testDefineFiltersDialogInsetNewFilterAttAndElem2(){
		robot.compareFiles(FILTER1,FILTER2);
		robot.openComparisionOptions("XML");
		robot.leftClickOnIcon(DOTS.getAbsolutePath(), "Ignore node types");
		robot.addNewAttributeGroupFilters("Filter3", "attr1");
		robot.okButton();
		robot.leftClickOnIcon(DOTS.getAbsolutePath(), "Ignore node types");
		robot.deleteFilter("Filter3");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
		delay(200);
		robot.cancelButton();
	}
	
	@Test	
	public void testFilterOutSpecificElements(){
		robot.compareFiles(FILTER1,FILTER2);
		robot.openComparisionOptions("XML");
		robot.leftClickOnIcon(DOTS.getAbsolutePath(), "Ignore node types");
		robot.addNewAttributeGroupFilters("filter1", "a");
		robot.selectEle(true);
		robot.okButton();
		delay(200);
		robot.keyType(VK_LEFT);
		delay(200);
		robot.typeString("filter1");
		robot.okButton();
		delay(200);
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test	
	public void testFilterOutSpecificElements2(){
		robot.compareFiles(FILTER1,FILTER2);
		robot.openComparisionOptions("XML");
		robot.leftClickOnIcon(DOTS.getAbsolutePath(), "Ignore node types");
		robot.addNewAttributeGroupFilters("filter2", "attr2");
		robot.selectEle(false);
		robot.selectAtt(true);
		robot.okButton();
		delay(200);
		robot.keyType(VK_LEFT);
		delay(200);
		robot.typeString("filter2");
		robot.okButton();
		delay(200);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	
}
