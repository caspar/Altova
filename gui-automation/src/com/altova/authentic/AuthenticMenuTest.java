package com.altova.authentic;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.spy.SpyRobot.ATTRIBUTES;
import static com.altova.spy.SpyRobot.ELEMENTS;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.util.IOUtils;



public class AuthenticMenuTest extends AbstractAuthenticTest {
	
	@Test
	public void testEditDatabaseData() {
		robot.editDatabaseData();
		assertForegroundWindow("Edit database data");
		robot.keyType(KeyEvent.VK_ESCAPE);  //exit the dialog
	}

	@Test	
	public void testHideMarkup() {
		robot.showLargeMarkup();
		robot.hideMarkup();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test	
	public void testShowSmallMarkup() {
		robot.showSmallMarkup();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test	
	public void testShowLargeMarkup() {
		robot.showLargeMarkup();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testShowMixedMarkup() {
		robot.showMixedMarkup();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	//Richedit test cases
	@Test
	public void testRichEditToggleBold_On() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("Create Eye-Catching Output");
		robot.toggleBold();
		robot.find("2008"); //switch focus
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditToggleBold_Off() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("StyleVision Overview");
		robot.toggleBold();
		robot.find("2008"); //switch focus
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditToggleItalic_On() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("Create Eye-Catching Output");
		robot.toggleItalic();
		robot.find("2008"); //switch focus
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditToggleItalic_Off() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("StyleVision Overview");
		robot.toggleItalic();
		robot.find("2008"); //switch focus
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditToggleUnderline_On() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("Altova StyleVision");
		robot.toggleUnderline();
		robot.find("2008"); //switch focus
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditToggleUnderline_Off() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("true single source publishing");
		robot.toggleUnderline();
		robot.find("Word/RTF"); //switch focus
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testRichEditToggleStrikeThrough_On() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("unique graphical");
		robot.toggleStrikeThrough();
		robot.find("2008"); //switch focus
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditToggleStrikeThrough_Off() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("for Web developers");
		robot.toggleStrikeThrough();
		robot.find("Further Highlights"); //switch focus
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditForegroundColor() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("Visual Stylesheet Design");
		robot.foregroundColor(RED_COLOR_PALETTE_ICON);
		robot.find("2008"); //switch focus
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditBackgroundColor() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("Visual Stylesheet Design");
		robot.backgroundColor(GREEN_COLOR_PALETTE_ICON);
		robot.find("2008"); //switch focus
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditAlignLeft() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("StyleVision Overview");
		robot.alignLeft();
		robot.find("2008"); //switch focus
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditAlignCenter() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("Create Eye-Catching Output");
		robot.alignCenter();
		robot.find("2008"); //switch focus
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditAlignRight() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("Create Eye-Catching Output");
		robot.alignRight();
		robot.find("2008"); //switch focus
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}


	@Test
	public void testAuthenticAppendRow() {
		robot.find("Joe");
		robot.authenticAppendRow();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAuthenticInsertRow() {
		robot.find("Joe");
		robot.authenticInsertRow();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAuthenticDuplicateRow() {
		robot.find("Joe");
		robot.authenticDuplicateRow();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAuthenticMoveRowUp() {
		robot.find("Max");
		robot.authenticMoveRowUp();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAuthenticMoveRowDown() {
		robot.find("Joe");
		robot.authenticMoveRowDown();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAuthenticDeleteRow() {
		robot.find("Joe");
		robot.authenticDeleteRow();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	

}
