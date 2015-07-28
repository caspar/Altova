package com.altova.diffdog;

import static com.altova.robots.SnapshotArea.CommonArea.MF_MAIN_WINDOW;
import static java.awt.event.KeyEvent.VK_ESCAPE;

import java.io.File;

import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.util.IOUtils;

public class ComparisonOptionsWordTest extends AbstractDiffDogTest{

	private static final File TEXTMODE = IOUtils.findFileDiffDog("examples/LeftSide/WordComparison/","Text_Mode.doc");
	
	private static final File TEXT_WHITESPACE1 = IOUtils.findFileDiffDog("examples/LeftSide/WordComparison/","Text_Whitespace.doc");
	private static final File TEXT_WHITESPACE2 = IOUtils.findFileDiffDog("examples/RightSide/WordComparison/","ext_Whitespace.doc");
	
	private static final File TEXT_SHOW_DIFF_INLINE1 = IOUtils.findFileDiffDog("examples/LeftSide/WordComparison/","Text_ShowDiffInLine.doc");
	
	private static final File TEXT_CS_LINES1 = IOUtils.findFileDiffDog("examples/LeftSide/WordComparison/","Text_CS_Lines.doc");
	private static final File TEXT_CS_LINES2 = IOUtils.findFileDiffDog("examples/RightSide/WordComparison/","Text_CS_Lines.doc");
	
	private static final File FORMAT_DOC1 = IOUtils.findFileDiffDog("examples/LeftSide/WordComparison/","Format.doc");
	private static final File FORMAT_DOC2 = IOUtils.findFileDiffDog("examples/RightSide/WordComparison/","Format.doc");
	//private static final File FORMAT_AND_TEXT_DOC1 = IOUtils.findFile("examples/LeftSide/WordComparison/Format_and_text.doc");
	
	@Test	
	public void testtextMode1(){
		/**
		 * Comparison Options | Text - Mode
		 * step1: load doc file in left side and let right side empty
		 * Comparison Options | Text - Mode: paragraph = true 
		 * 
		 * step2: Comparison Options | Text - Mode: Sentence = true"
		 *  
		 */

		robot.compareWordDocuments(TEXTMODE, TEXTMODE);
		
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(new CheckboxOption("Paragraph",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testtextMode2(){
		/**
		 * Comparison Options | Text - Mode
		 * step1: load doc file in left side and let right side empty
		 * Comparison Options | Text - Mode: paragraph = true 
		 * 
		 * step2: Comparison Options | Text - Mode: Sentence = true"
		 *  
		 */

		robot.compareWordDocuments(TEXTMODE, TEXTMODE);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(new CheckboxOption("Sentence",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordTextWhitespace1(){
		/**
		 * Comparison Options | Text - Whitespace
		 * step1: Normalize = true
		 * step2: Strip all = true
		 * step3: Compare as is = true
		 * step4: copy from left to right and start comparison
		 *  
		 */
		robot.compareWordDocuments(TEXT_WHITESPACE1, TEXT_WHITESPACE2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(new CheckboxOption("Normalize",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordTextWhitespace2(){
		/**
		 * Comparison Options | Text - Whitespace
		 * step1: Normalize = true
		 * step2: Strip all = true
		 * step3: Compare as is = true
		 * step4: copy from left to right and start comparison
		 *  
		 */
		robot.compareWordDocuments(TEXT_WHITESPACE1, TEXT_WHITESPACE2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(new CheckboxOption("Strip all",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordTextWhitespace3(){
		/**
		 * Comparison Options | Text - Whitespace
		 * step1: Normalize = true
		 * step2: Strip all = true
		 * step3: Compare as is = true
		 * step4: copy from left to right and start comparison
		 *  
		 */
		robot.compareWordDocuments(TEXT_WHITESPACE1, TEXT_WHITESPACE2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(new CheckboxOption("Compare as is",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test	
	public void testWordTextWhitespace4(){
		/**
		 * Comparison Options | Text - Whitespace
		 * step1: Normalize = true
		 * step2: Strip all = true
		 * step3: Compare as is = true
		 * step4: copy from left to right and start comparison
		 *  
		 */
		robot.compareWordDocuments(TEXT_WHITESPACE1, TEXT_WHITESPACE2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(new CheckboxOption("Compare as is",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		//robot.copyFromLeft();
		robot.startComparison();
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordShowDiff_InnlineFalse(){
		robot.compareWordDocuments(TEXT_SHOW_DIFF_INLINE1, TEXT_WHITESPACE2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(new CheckboxOption("Compare as is",true),
				new CheckboxOption("Sentence",true),
				new CheckboxOption("Show differences within lines",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordShowDiff_InnlineTrue(){
		robot.compareWordDocuments(TEXT_SHOW_DIFF_INLINE1, TEXT_WHITESPACE2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(new CheckboxOption("Compare as is",true),
				new CheckboxOption("Sentence",true),
				new CheckboxOption("Show differences within lines",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordCaseSensivityLines1(){
		/**
		 * 	Comparison Options | Text - Case sensitivity, Lines
		 *
		 * step1: Ignore case = false
		 *        Ignore blank lines = false
		 * step2: Ignore case = true
		 *        Ignore blank lines = false
		 * step3: Ignore case = false
		 *        Ignore blank lines = true
		 * step4: Ignore case = true
		 *        Ignore blank lines = true
		 *        Normalize = true
		 * 
		 */
		robot.compareWordDocuments(TEXT_CS_LINES1, TEXT_CS_LINES2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(
				new CheckboxOption("Compare as is",true),
				new CheckboxOption("Sentence",true),
				new CheckboxOption("Show differences within lines",true),
				new CheckboxOption("Ignore case",false),
				new CheckboxOption("Ignore blank lines",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test	
	public void testWordCaseSensivityLines2(){
		/**
		 * 	Comparison Options | Text - Case sensitivity, Lines
		 *
		 * step1: Ignore case = false
		 *        Ignore blank lines = false
		 * step2: Ignore case = true
		 *        Ignore blank lines = false
		 * step3: Ignore case = false
		 *        Ignore blank lines = true
		 * step4: Ignore case = true
		 *        Ignore blank lines = true
		 *        Normalize = true
		 * 
		 */
		robot.compareWordDocuments(TEXT_CS_LINES1, TEXT_CS_LINES2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(
				new CheckboxOption("Compare as is",true),
				new CheckboxOption("Sentence",true),
				new CheckboxOption("Show differences within lines",true),
				new CheckboxOption("Ignore case",true),
				new CheckboxOption("Ignore blank lines",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordCaseSensivityLines3(){
		/**
		 * 	Comparison Options | Text - Case sensitivity, Lines
		 *
		 * step1: Ignore case = false
		 *        Ignore blank lines = false
		 * step2: Ignore case = true
		 *        Ignore blank lines = false
		 * step3: Ignore case = false
		 *        Ignore blank lines = true
		 * step4: Ignore case = true
		 *        Ignore blank lines = true
		 *        Normalize = true
		 * 
		 */
		robot.compareWordDocuments(TEXT_CS_LINES1, TEXT_CS_LINES2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(
				new CheckboxOption("Compare as is",true),
				new CheckboxOption("Sentence",true),
				new CheckboxOption("Show differences within lines",true),
				new CheckboxOption("Ignore case",false),
				new CheckboxOption("Ignore blank lines",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordCaseSensivityLines4(){
		/**
		 * 	Comparison Options | Text - Case sensitivity, Lines
		 *
		 * step1: Ignore case = false
		 *        Ignore blank lines = false
		 * step2: Ignore case = true
		 *        Ignore blank lines = false
		 * step3: Ignore case = false
		 *        Ignore blank lines = true
		 * step4: Ignore case = true
		 *        Ignore blank lines = true
		 *        Normalize = true
		 * 
		 */
		robot.compareWordDocuments(TEXT_CS_LINES1, TEXT_CS_LINES2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(
				new CheckboxOption("Sentence",true),
				new CheckboxOption("Show differences within lines",true),
				new CheckboxOption("Ignore case",true),
				new CheckboxOption("Ignore blank lines",true),
			new CheckboxOption("Normalize",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordFormatAllUnchecked(){
		robot.compareWordDocuments(FORMAT_DOC1, FORMAT_DOC2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(
				new CheckboxOption("Bold",false),
				new CheckboxOption("Italic",false),
				new CheckboxOption("Underline",false),
				new CheckboxOption("Font Name",false),
				new CheckboxOption("Font Size",false),
			new CheckboxOption("Color",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordFormatBold(){
		robot.compareWordDocuments(FORMAT_DOC1, FORMAT_DOC2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(
				new CheckboxOption("Bold",true),
				new CheckboxOption("Italic",false),
				new CheckboxOption("Underline",false),
				new CheckboxOption("Font Name",false),
				new CheckboxOption("Font Size",false),
			new CheckboxOption("Color",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordFormatItalic(){
		robot.compareWordDocuments(FORMAT_DOC1, FORMAT_DOC2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(
				new CheckboxOption("Bold",false),
				new CheckboxOption("Italic",true),
				new CheckboxOption("Underline",false),
				new CheckboxOption("Font Name",false),
				new CheckboxOption("Font Size",false),
			new CheckboxOption("Color",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordFormatBoldItalic(){
		robot.compareWordDocuments(FORMAT_DOC1, FORMAT_DOC2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(
				new CheckboxOption("Bold",true),
				new CheckboxOption("Italic",true),
				new CheckboxOption("Underline",false),
				new CheckboxOption("Font Name",false),
				new CheckboxOption("Font Size",false),
			new CheckboxOption("Color",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordFormatUnderline(){
		robot.compareWordDocuments(FORMAT_DOC1, FORMAT_DOC2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(
				new CheckboxOption("Bold",false),
				new CheckboxOption("Italic",false),
				new CheckboxOption("Underline",true),
				new CheckboxOption("Font Name",false),
				new CheckboxOption("Font Size",false),
			new CheckboxOption("Color",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordFormatUnderlineFontName(){
		robot.compareWordDocuments(FORMAT_DOC1, FORMAT_DOC2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(
				new CheckboxOption("Bold",false),
				new CheckboxOption("Italic",false),
				new CheckboxOption("Underline",true),
				new CheckboxOption("Font Name",true),
				new CheckboxOption("Font Size",false),
			new CheckboxOption("Color",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordFormatFontSize(){
		robot.compareWordDocuments(FORMAT_DOC1, FORMAT_DOC2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(
				new CheckboxOption("Bold",false),
				new CheckboxOption("Italic",false),
				new CheckboxOption("Underline",false),
				new CheckboxOption("Font Name",false),
				new CheckboxOption("Font Size",true),
			new CheckboxOption("Color",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test	
	public void testWordFormatFontSizeFontName(){
		robot.compareWordDocuments(FORMAT_DOC1, FORMAT_DOC2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(
				new CheckboxOption("Bold",false),
				new CheckboxOption("Italic",false),
				new CheckboxOption("Underline",false),
				new CheckboxOption("Font Name",true),
				new CheckboxOption("Font Size",true),
			new CheckboxOption("Color",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordFormatColor(){
		robot.compareWordDocuments(FORMAT_DOC1, FORMAT_DOC2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(
				new CheckboxOption("Bold",false),
				new CheckboxOption("Italic",false),
				new CheckboxOption("Underline",false),
				new CheckboxOption("Font Name",false),
				new CheckboxOption("Font Size",false),
			new CheckboxOption("Color",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordFormatAllChecked(){
		robot.compareWordDocuments(FORMAT_DOC1, FORMAT_DOC2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(
				new CheckboxOption("Bold",true),
				new CheckboxOption("Italic",true),
				new CheckboxOption("Underline",true),
				new CheckboxOption("Font Name",true),
				new CheckboxOption("Font Size",true),
			new CheckboxOption("Color",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordFormatAndTextOptions(){
		robot.compareWordDocuments(FORMAT_DOC1, FORMAT_DOC2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(
				new CheckboxOption("Bold",true),
				new CheckboxOption("Italic",true),
				new CheckboxOption("Underline",true),
				new CheckboxOption("Font Name",true),
				new CheckboxOption("Font Size",true),
		    	new CheckboxOption("Color",true),
		    	new CheckboxOption("Ignore blank lines",false)
		);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}

	@Test	
	public void testWordFormatAndTextOptionsShowDifferentLines(){
		robot.compareWordDocuments(FORMAT_DOC1, FORMAT_DOC2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(
				new CheckboxOption("Bold",true),
				new CheckboxOption("Italic",true),
				new CheckboxOption("Underline",true),
				new CheckboxOption("Font Name",true),
				new CheckboxOption("Font Size",true),
		    	new CheckboxOption("Color",true),
		    	new CheckboxOption("Show differences within lines",true),
		    	new CheckboxOption("Ignore blank lines",false)
		);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.escapeDialog("No differences found", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	

}
