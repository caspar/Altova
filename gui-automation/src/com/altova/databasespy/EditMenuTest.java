package com.altova.databasespy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.spy.SpyRobot.PROJECT;
import static com.altova.databasespy.DatabaseSpyRobot.*;
import static java.awt.event.KeyEvent.*;


import org.junit.AfterClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import com.altova.util.ClipboardUtils;

public class EditMenuTest extends AbstractDatabaseSpyTest{

	
	private static final String ToFind = "select * from [Person]";
	private static final String ToFind2 = "E";
	private static final String oldText = "Person";
	private static final String newText = "Address";
	
	
	@Before
	public void setUpBefore() throws Exception {
		super.setUp();
		robot.openFile(ORGCHART_PQRJ_SAVED_FILE_TMP.getAbsolutePath());
	}
	
	@After
	public void setUpAfter() throws Exception {
		
		robot.closeAll();
		robot.escapeDialog("Save modified files", VK_D);
	}
	
	
	
	@Test
	public final void testUndo() {
		
		robot.editText(VK_END, VK_A, VK_B, VK_S);
		robot.undo();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public final void testRedo() {

		robot.editText(VK_END, VK_A, VK_B, VK_S);
		robot.undo();
		
		robot.redo();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testCopy() {
	
		robot.findSelection(ToFind);
		robot.copy();
		
		String clipboard = ClipboardUtils.getClipboardContents();
		assertEquals(ToFind, clipboard);

	}
	
	@Test
	public final void testPaste() {
	
		robot.findSelection(ToFind);
		robot.copy();
		
		robot.editText(VK_END);
		robot.paste();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testFind() {

		robot.findSelection(ToFind);
		delay(500);
		assertAreas(DIAGRAM_MAIN_WINDOW);

	}
	
	@Test
	public final void testFindInProject() {
		robot.activatePane(PROJECT);
		robot.findSelection("Chart");
		
		for (int i = 0; i < 1; i++) {
			robot.findNext();
			delay(500);
		}
		assertAreas(PROJECT);
	}
	
	@Test
	public final void testFindNext() {

		robot.findSelection(ToFind2);
		delay(500);
		robot.FindNextText();
		delay(500);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);

	}
	
	@Test
	public final void testCut() {

		robot.findSelection(oldText);
		delay(500);
		robot.cut();
		assertAreas(DIAGRAM_MAIN_WINDOW);

	}
	
	
	@Test
	public final void testReplace() {

		robot.replace(oldText, newText);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testSelectUserTables(){
		
		robot.openFile(ORGCHART_QDES_MIX_TABLES.getAbsolutePath());
		delay(2000);
		
		robot.selectUserTables();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testSelectSystemTables(){
		
		robot.openFile(ORGCHART_QDES_MIX_TABLES.getAbsolutePath());
		delay(2000);
		
		robot.selectSystemTables();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testSelectAllTables(){
		
		robot.openFile(ORGCHART_QDES_MIX_TABLES.getAbsolutePath());
		delay(2000);
		
		robot.selectAllTables();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
}
