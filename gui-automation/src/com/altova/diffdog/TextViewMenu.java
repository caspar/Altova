package com.altova.diffdog;

import org.junit.Test;
//import java.awt.Rectangle;
//import java.awt.event.KeyEvent;
import java.io.File;
//import java.util.logging.Logger;

//import com.altova.nativegui.NativeGUI;
import com.altova.robots.ScriptMistakeException;
//import com.altova.util.AltovaJUnitRunner;
import com.altova.util.IOUtils;
//import com.altova.util.Settings;
//import com.altova.util.AltovaJUnitRunner.TestRobot;
//import com.sun.jmx.mbeanserver.OpenConverter;
//import com.sun.net.ssl.internal.ssl.Debug;

import static com.altova.robots.SnapshotArea.CommonArea.*;
//import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.*;




public class TextViewMenu extends AbstractDiffDogTest{
	
	
	private static final File WORDWRAP1=IOUtils.findFileDiffDog("examples/LeftSide/","wordwrap1.xml");
	private static final File WORDWRAP2=IOUtils.findFileDiffDog("examples/RightSide/","wordwrap2.xml");
	
	private static final File GNUMERIC1=IOUtils.findFileDiffDog("examples/LeftSide/","gnumeric1.xml");
	private static final File GNUMERIC2=IOUtils.findFileDiffDog("examples/RightSide/","gnumeric2.xml");
	
	protected final String WRAP_ICON = IOUtils.findFileDiffDog("res/","WRAP_ICO.png").getAbsolutePath();
	protected final String PRITTYPRITN_ICON = IOUtils.findFileDiffDog("res/","PRITTYPRITN_ICO.png").getAbsolutePath();
	
//	private static final File ATTR1=IOUtils.findFileDiffDog("examples/LeftSide/attr1.xml");
	private static final File ATTR2=IOUtils.findFileDiffDog("examples/RightSide/","attr2.xml");
	
	protected final String SAVEDISABLED_ICON = IOUtils.findFileDiffDog("res/","SAVEDIS_ICO.png").getAbsolutePath();
	protected final String SAVEAS_ICON = IOUtils.findFileDiffDog("res/","SAVEAS_ICO.png").getAbsolutePath();
	protected final String RELOAD_ICON = IOUtils.findFileDiffDog("res/","RELOAD_ICO.png").getAbsolutePath();
	
	protected static final File SAVEAS_TEST_FILE=new File("C:\\temp\\debug\\SaveAsTest.xml");
	
	@Test
	public void testWordWrap(){
			robot.compareFiles(WORDWRAP1,WORDWRAP2);
			robot.enableWordWrap();
			robot.setCursorAtBeginning(LEFT_SIDE);
			robot.leftClickOnIcon(WRAP_ICON, "Text");
			assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testWordWrap1(){
			robot.compareFiles(WORDWRAP1,WORDWRAP2);
			robot.enableWordWrap();
			robot.setCursorAtBeginning(LEFT_SIDE);
			robot.leftClickMenuItem("Text View", "Word Wrap");
			assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testPrittyPrint(){
			robot.compareFiles(WORDWRAP1,WORDWRAP2);
			robot.setCursorAtBeginning(LEFT_SIDE);
			robot.leftClickOnIcon(PRITTYPRITN_ICON, "Text");
			robot.setCursorAtBeginning(RIGHT_SIDE);
			robot.leftClickOnIcon(PRITTYPRITN_ICON, "Text");
			delay(1000);
			assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testBreakPointFunction(){
			robot.compareFiles(WORDWRAP1,WORDWRAP2);
			robot.goToLine(LEFT_SIDE, "7", "1");
			robot.leftClickMenuItem("Text View", "Insert/Remove Bookmark");
			robot.goToLine(LEFT_SIDE, "50", "1");
			robot.leftClickMenuItem("Text View", "Insert/Remove Bookmark");
			delay(500);
			robot.leftClickMenuItem("Text View", "Go to Next Bookmark");
			delay(500);
			assertAreas(getTestName() + "1", MF_MAIN_WINDOW);
			robot.leftClickMenuItem("Text View", "Go to Previous Bookmark");
			assertAreas(getTestName() + "2", MF_MAIN_WINDOW);
			robot.leftClickMenuItem("Text View", "Remove All Bookmarks");
			robot.setCursorAtBeginning(LEFT_SIDE);
			assertAreas(getTestName() + "3", MF_MAIN_WINDOW);
			
	}
	
	@Test
	public void testToogleAllFolds(){
			robot.compareFiles(WORDWRAP1,WORDWRAP2);
			robot.setCursorAtBeginning(LEFT_SIDE);
			robot.leftClickMenuItem("Text View","Toogle All Folds");
			assertAreas(MF_MAIN_WINDOW);
	}

	@Test
	public void testViewMarginsSetting() throws ScriptMistakeException{
			
		try{
			robot.compareFiles(GNUMERIC1,GNUMERIC2);
			robot.setTextViewMarginSettings(false,false,false);
			robot.goToLine(RIGHT_SIDE, "1", "1");
			robot.leftClickMenuItem("Text View", "Insert/Remove Bookmark");
			assertAreas(MF_MAIN_WINDOW);
		}catch (ScriptMistakeException e){
			fail(e.getMessage());
		}finally{
			robot.setDefaultTextViewMarginSettings();
		}
	}
	
	@Test
	public void testViewVisualAidSetting() throws ScriptMistakeException{
			
		try{
			robot.compareFiles(GNUMERIC1,GNUMERIC2);
			robot.setTextViewVisualAidSettings(false, true, true);
			robot.goToLine(RIGHT_SIDE, "1", "1");
			assertAreas(MF_MAIN_WINDOW);
		}catch (ScriptMistakeException e){
			fail(e.getMessage());
		}finally{
			robot.setDefaultTextViewVisualAidSettings();
		}
	}
	
	@Test
	public void testViewTabsSetting() throws ScriptMistakeException{
			
		try{
			robot.compareFiles(GNUMERIC1,GNUMERIC2);
			robot.setCursorAtBeginning(LEFT_SIDE);
			robot.setCursorAfterFoundString(LEFT_SIDE, "<gmr:name>");
			robot.keyType(VK_TAB);
			robot.leftClickMenuItem("Edit", "Undo");
			robot.setTextViewTabSettings(null, "64");
			robot.setCursorAfterFoundString(LEFT_SIDE, "<gmr:name>");
			robot.typeString("New text");
			robot.keyType(VK_TAB);
			assertAreas(MF_MAIN_WINDOW);
		}catch (ScriptMistakeException e){
			fail(e.getMessage());
		}finally{
			robot.setDefaultTextViewTabSettings();
		}
	}
	@Test
	public void testViewSettingInvalidTabSize() throws ScriptMistakeException{
			
		try{
			robot.compareFiles(GNUMERIC1,GNUMERIC2);
			robot.setCursorAtBeginning(LEFT_SIDE);
			robot.setTextViewTabSettings(null, "-1");
			robot.findComponentName("Enter an integer between 1 and 64");
			if(!robot.escapeDialog("Enter an integer between 1 and 64", VK_ENTER))
				fail();
			robot.typeStringEnter("65");
			if(!robot.escapeDialog("Enter an integer between 1 and 64", VK_ENTER))
				fail();
			robot.typeStringEnter("0");
			if(!robot.escapeDialog("Enter an integer between 1 and 64", VK_ENTER))
				fail();
			robot.typeStringEnter("Hello");
			if(!robot.escapeDialog("Enter an integer.", VK_ENTER))
				fail();
			delay(1000);
			robot.keyType(VK_ESCAPE);


		}catch (ScriptMistakeException e){
			fail(e.getMessage());
		}finally{
			robot.setDefaultTextViewTabSettings();
		}
	}
	
	@Test
	public void testOpenAndApplyIcons(){

		robot.leftClickOpenIcon(LEFT_SIDE);
		delay(2000);
		robot.typeStringEnter(GNUMERIC1.getAbsolutePath());
		delay(2000);
		robot.leftClickOpenIcon(RIGHT_SIDE);
		delay(2000);
		robot.typeStringEnter(GNUMERIC2.getAbsolutePath());
		delay(2000);
		robot.setCursorAtBeginning(RIGHT_SIDE);
		delay(2000);
		robot.leftClickOpenIcon(RIGHT_SIDE);
		delay(500);
		robot.typeStringEnter(ATTR2.getAbsolutePath());
		delay(2000);
		robot.escapeDialog("Recently Compared Pairs", VK_ESCAPE);		
	}
	
	@Test
	public void testSaveIcons(){

		robot.compareFiles(GNUMERIC1,GNUMERIC2);
		robot.leftClickOnIcon(SAVEDISABLED_ICON, "Toolbar first document");
		delay(2000);
		robot.leftClickOnIcon(SAVEAS_ICON, "Toolbar second document");
		delay(2000);
		robot.typeStringEnter(SAVEAS_TEST_FILE.getAbsolutePath());
		delay(2000);
		robot.escapeDialog("Confirm Save As", VK_Y);
		robot.escapeDialog("Do you want to replace it?", VK_Y);
		delay(2000);
		assertFileExists(SAVEAS_TEST_FILE);
		robot.leftClickOnIcon(RELOAD_ICON, "Toolbar second document");
		assertAreas(MF_MAIN_WINDOW);
	}


}
