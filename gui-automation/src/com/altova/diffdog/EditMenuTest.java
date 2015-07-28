package com.altova.diffdog;

import org.junit.Test;

import java.awt.Rectangle;
//import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.Toolkit;

//import com.altova.robots.ScriptMistakeException;
//import com.altova.util.AltovaJUnitRunner;
import com.altova.robots.CheckboxOption;
import com.altova.util.IOUtils;
//import com.altova.util.Settings;
//import com.altova.util.AltovaJUnitRunner.TestRobot;
//import com.sun.jmx.mbeanserver.OpenConverter;

import static com.altova.robots.SnapshotArea.CommonArea.*;
//import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.*;

public class EditMenuTest extends AbstractDiffDogTest{
	
	private static final File ATTR1=IOUtils.findFileDiffDog("examples/LeftSide/","attr1.xml");
	private static final File ATTR2=IOUtils.findFileDiffDog("examples/RightSide/","attr2.xml");
	
	private static final File gnumeric1=IOUtils.findFileDiffDog("examples/LeftSide/","gnumeric1.xml");
	private static final File gnumeric2=IOUtils.findFileDiffDog("examples/RightSide/","gnumeric2.xml");
	
	private static final File GNUMERIC1=IOUtils.findFileDiffDog("examples/LeftSide/","gnumeric1.xml");
	private static final File GNUMERIC2=IOUtils.findFileDiffDog("examples/RightSide/","gnumeric2.xml");
	
	private static final File FIND_TXT=IOUtils.findFileDiffDog("examples/LeftSide/","find.txt");
	private static final File FIND_REPLACE_TXT=IOUtils.findFileDiffDog("examples/LeftSide/","Find_Replace.txt");
	
	
	private static final File DATABASE_Schema_ZOO=IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","Zoo.dbsdif");
	
	protected final String THREE = IOUtils.findFileDiffDog("res/","THREE.png").getAbsolutePath();
	protected final String SIX = IOUtils.findFileDiffDog("res/","SIX.png").getAbsolutePath();
	
	@Test
	public void testCheckToolbarOnEmptyComparisonWindow(){
		assertAreas(TOP_WINDOW);	
	}
	
	@Test
	public void testUndoRedoLeft(){
		robot.compareFiles(ATTR1,ATTR2);
		robot.typeAfterFoundString(LEFT_SIDE, "</child>", "<child t=\"Autotest\">embedded text");
		assertAreas(MF_MAIN_WINDOW);
		robot.leftClickMenuItem("Edit", "Undo");
		assertAreas(getTestName() + "1", MF_MAIN_WINDOW);
		robot.leftClickMenuItem("Edit", "Redo");
		assertAreas(getTestName() + "2", MF_MAIN_WINDOW);
		
	}
	
	@Test
	public void testUndoRedoRight(){
		robot.compareFiles(ATTR1,ATTR2);
		robot.typeAfterFoundString(RIGHT_SIDE, "</child>", "<child t=\"Autotest\">embedded text");
		assertAreas(MF_MAIN_WINDOW);
		robot.leftClickMenuItem("Edit", "Undo");
		assertAreas(getTestName() + "1", MF_MAIN_WINDOW);
		robot.leftClickMenuItem("Edit", "Redo");
		assertAreas(getTestName() + "2", MF_MAIN_WINDOW);
	}
	@Test
	public void testCutLeft(){
		robot.compareFiles(ATTR1,ATTR2);
		robot.find(LEFT_SIDE, "This element");
		robot.leftClickMenuItem("Edit", "Cut");
		assertAreas(MF_MAIN_WINDOW);
		
	}
	
	@Test
	public void testCutRight(){
		robot.compareFiles(ATTR1,ATTR2);
		robot.find(RIGHT_SIDE, "This element");
		robot.leftClickMenuItem("Edit", "Cut");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testCopyPasteLeft(){
		robot.compareFiles(ATTR1,ATTR2);
		robot.find(LEFT_SIDE, "This element");
		robot.leftClickMenuItem("Edit", "Copy");
		robot.setCursorAfterFoundString(LEFT_SIDE, "This element has ");
		robot.leftClickMenuItem("Edit", "Paste");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testCopyPasteRight(){
		robot.compareFiles(ATTR1,ATTR2);
		robot.find(RIGHT_SIDE, "This element");
		robot.leftClickMenuItem("Edit", "Copy");
		robot.setCursorAfterFoundString(RIGHT_SIDE, "This element has ");
		robot.leftClickMenuItem("Edit", "Paste");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testDeleteBoth(){
		robot.compareFiles(ATTR1,ATTR2);
		robot.find(LEFT_SIDE, "This element");
		robot.leftClickMenuItem("Edit", "Delete");
		robot.find(RIGHT_SIDE, "This element");
		robot.leftClickMenuItem("Edit", "Delete");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void selectAllBoth(){
		robot.compareFiles(ATTR1,ATTR2);
		robot.find(LEFT_SIDE, "This element");
		robot.leftClickMenuItem("Edit", "Select All");
		robot.find(RIGHT_SIDE, "This element");
		robot.leftClickMenuItem("Edit", "Select All");
		assertAreas(MF_MAIN_WINDOW);
	}
	

	
	public void pressShift()
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		if (tk.getLockingKeyState(VK_SHIFT) == true)
			tk.setLockingKeyState(VK_SHIFT, false);
		else
			tk.setLockingKeyState(VK_SHIFT, true);
		
	}
	
	@Test
	public void testFindDialogLeft(){
		robot.compareFiles(gnumeric1,gnumeric2);
		delay(2000);
		robot.keyType(VK_PAGE_UP);
		robot.keyType(VK_PAGE_UP);
		robot.typeString("Start");
		delay(2000);
		pressShift();
		
		robot.keyType(VK_DOWN);
		robot.keyType(VK_DOWN);
		pressShift();
		
		
		
		//robot.find(LEFT_SIDE, "attr");
		//robot.leftClickMenuItem("Edit", "Find");
		delay(1000);
		/*Rectangle hint = robot.findComponent("Find &Previous", "Button", null);
		assertNotNull(hint);
		robot.leftClickMid(hint);
		delay(1000);
		Rectangle hint2 = robot.findComponent("Cancel", "Button", null);
		assertNotNull(hint2);
		robot.leftClickMid(hint2);
		delay(1000);
		Rectangle hint3 = robot.findComponent("&Mark All", "Button", null);
		assertNotNull(hint3);
		robot.leftClickMid(hint3);
		Rectangle hint4 = robot.findComponent("Close", "Button", null);
		robot.leftClickMid(hint4);
		
		assertAreas(MF_MAIN_WINDOW);
		*/
	}
	@Test
	public void testFindDialogRight(){
		robot.compareFiles(gnumeric1,gnumeric2);
		robot.find(RIGHT_SIDE, "attr");
		robot.leftClickMenuItem("Edit", "Find");
		delay(1000);
		Rectangle hint = robot.findComponent("Find &Previous", "Button", null);
		assertNotNull(hint);
		robot.leftClickMid(hint);
		delay(1000);
		Rectangle hint2 = robot.findComponent("Cancel", "Button", null);
		assertNotNull(hint2);
		robot.leftClickMid(hint2);
		delay(1000);
		Rectangle hint3 = robot.findComponent("&Mark All", "Button", null);
		assertNotNull(hint3);
		robot.leftClickMid(hint3);
		Rectangle hint4 = robot.findComponent("Close", "Button", null);
		robot.leftClickMid(hint4);
		
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testReplace(){
		robot.compareFiles(ATTR1,ATTR2);
		robot.find(LEFT_SIDE,"This element");
		delay(1000);
		//robot.replace(LEFT_SIDE, null, "That element",);
		robot.replace(LEFT_SIDE, null, "That element", false, 
				false, false, true, true);
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.replace(RIGHT_SIDE, "em", "TEST",false,false,false,false,false);
		robot.leftClickMid(robot.findComponent("Replace", "Button", null));
		delay(1000);
		robot.leftClickMid(robot.findComponent("Replace", "Button", null));
		delay(1000);
		robot.leftClickMid(robot.findComponent("Close", "Button", null));
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testCopyAndPaste(){
		robot.compareFiles(GNUMERIC1,GNUMERIC2);
		robot.showGridView();
		robot.setCursorAtBeginning(LEFT_SIDE);
		robot.keyType(VK_DOWN);
		delay(50);
		robot.keyType(VK_DOWN);
		delay(50);
		robot.keyType(VK_DOWN);
		delay(50);
		robot.copy();
		delay(500);
		robot.paste();
		delay(500);
		assertAreas(MF_MAIN_WINDOW);
	}
	//Text View

	@Test
	public void testFindDialog(){
		robot.openFile(LEFT_SIDE,FIND_TXT);
		robot.find(LEFT_SIDE, "diff");
		robot.leftClickMenuItem("Edit", "Find");
		delay(1000);
		robot.leftClickMid(robot.findComponent("&Mark All", "Button", null));
		robot.leftClickMid(robot.findComponent("Close", "Button", null));
		robot.leftClickOnIcon(robot.REMOVE_ALL_BOOKMARKS.getAbsolutePath(),"Text");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testFindDialogNext(){
		robot.openFile(LEFT_SIDE,FIND_TXT);
		robot.setCursorAfterFoundString(LEFT_SIDE, "diff3");
		robot.leftClickMenuItem("Edit", "Find");
		delay(500);
		robot.typeStringEnter("diff");
		delay(1000);
		if(!robot.escapeDialog("Reached the end of the file", VK_ESCAPE))
			fail("'Reached the end of the file' message doesn't show up");
	}
	
	@Test
	public void testFindDialogPrevious(){
		robot.openFile(LEFT_SIDE,FIND_TXT);
		robot.find(LEFT_SIDE, "diff");
		robot.leftClickMenuItem("Edit", "Find");
		delay(1000);
		robot.leftClickMid(robot.findComponent("Find &Previous", "Button", null));
		delay(200);
		if(!robot.escapeDialog("Reached the beginning of the file", VK_ESCAPE))
			fail("'Reached the end of the file' message doesn't show up");
		robot.leftClickMid(robot.findComponent("Close", "Button", null));
		
		
	}
	@Test
	public void testFindAndReplaceDialogP1(){
		robot.openFile(LEFT_SIDE,FIND_REPLACE_TXT);
		robot.find(LEFT_SIDE, "diff");
		robot.leftClickMenuItem("Edit", "Replace");
		robot.replaceDialog("diff", "Autotest", "Replace", new CheckboxOption("Match whole word only", true));
		delay(1000);
		robot.replaceDialog(null, null, "Find Next");
		delay(1000);
		robot.escapeDialog("Reached the end of the file", VK_SPACE);
		delay(1000);
		robot.replaceDialog(null, null, "Replace");
		delay(1000);
		robot.escapeDialog("Reached the end of the file", VK_ESCAPE);
		robot.replaceDialog(null, null, "Close");
		delay(1000);
		assertAreas(MF_MAIN_WINDOW);
	}
	

	@Test
	public void testFindAndReplaceDialogP1S2(){
		robot.openFile(LEFT_SIDE,FIND_REPLACE_TXT);
		robot.find(LEFT_SIDE, "diff");
		robot.leftClickMenuItem("Edit", "Replace");
		robot.replaceDialog("diff", "Autotest", "Replace &All", new CheckboxOption("Match whole word only", true));
		delay(1000);
		robot.escapeDialog("Replaced",VK_ESCAPE);
		delay(1000);
		robot.replaceDialog(null, null, "Close");
		delay(500);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testFindAndReplaceDialogP2S1(){
		robot.openFile(LEFT_SIDE,FIND_REPLACE_TXT);
		robot.setCursorAtBeginning(LEFT_SIDE);
		robot.leftClickMenuItem("Edit", "Replace");
		robot.replaceDialog("diff", null, "Find Next", new CheckboxOption("Match whole word only", false));
		delay(1000);
		robot.replaceDialog(null, null, "Close");
		delay(1000);
		robot.leftClickMenuItem("Edit", "Replace");
		robot.replaceDialog("\\<d", "Autotest", "Find Next", new CheckboxOption("Match case", true),
				new CheckboxOption("Regular expression", true));
		robot.replaceDialog(null, null, "Replace &All");
		delay(1000);
		robot.escapeDialog("Replaced",VK_ESCAPE);
		delay(1000);
		robot.replaceDialog(null, null, "Close");
		delay(1000);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test
	public void testFindAndReplaceDialogP2S2(){
		robot.openFile(LEFT_SIDE,FIND_REPLACE_TXT);
		robot.goToLine(LEFT_SIDE, "3", "1");
		delay(1500);
		robot.dragDrop(THREE, SIX);
		robot.leftClickMenuItem("Edit", "Replace");
		robot.replaceDialog("iff", "ifference", "Replace &All", new CheckboxOption("Replace in selection only", true));
		robot.escapeDialog("Replaced",VK_ESCAPE);
		delay(1000);
		robot.replaceDialog(null, null, "Close");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	
	
	//databae Schema
	@Test
	public void testOpenSchemaCompariosnInNewDataComparion(){
		robot.openComparisonFile(DATABASE_Schema_FILE);
		robot.startComparison();
		robot.openInNewDataComparison();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testCopyFromLeftToRight(){
		robot.openComparisonFile(DATABASE_Schema_ZOO);
		robot.startComparison();
		robot.copyFromLeft();
		assertAreas(TOP_WINDOW);
		robot.escapeDialog("Merge Schema Left to Right", VK_ESCAPE);
	}
	
	@Test
	public void testCopyFromRightToLeft(){
		robot.openComparisonFile(DATABASE_Schema_ZOO);
		robot.startComparison();
		delay(500);
		robot.copyFromRight();
		assertAreas(TOP_WINDOW);
		delay(500);
		robot.escapeDialog("Merge Schema Right to Left", VK_ESCAPE);
	}
	
	@Test
	public void testMergeSchemaDialog(){
		robot.openComparisonFile(DATABASE_Schema_ZOO);
		robot.startComparison();
		robot.copyFromLeft();
		Rectangle rect = robot.findComponent("Save SQL to File", "Button", null);
		robot.leftClickMid(rect);
		if(!robot.escapeDialog("Save SQL Changescript", VK_ESCAPE))
			fail("Save SQL Changescript Window doesn't show up");
		
	}
	
}
