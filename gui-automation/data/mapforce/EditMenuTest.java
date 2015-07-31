package com.altova.mapforce;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Test;

import com.altova.robots.ImageRecognitionRobot;
import com.altova.robots.ScriptMistakeException;
import com.altova.util.IOUtils;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;
import com.altova.robots.ImageRecognitionRobot.*;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.mapforce.MapForceRobot.MESSAGES;
import static java.awt.event.KeyEvent.VK_ESCAPE;

/**
 * @author b.lopez
 *
 */

//@TestRobot(EclipseMapForceRobot.class)
public class EditMenuTest extends AbstractMapForceTest{
	

	@Test
	public void testUndo(){
		delay(2000);
		robot.selectAll();
		robot.delete();
		robot.undo();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRedo(){
		delay(2000);
		robot.selectAll();
		robot.delete();
		robot.undo();
		delay(500);
		robot.redo();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testQuickFind(){
		robot.openFile(EDI_ORDER_REVERSE_MFD);
		delay(500);
		robot.selectComponentFromImage(ORDERS_COMPONENT);
		robot.find("f00");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testFindInOutput(){
		robot.openFile(EDI_ORDER_REVERSE_MFD);
		delay(2000);
		robot.showOutput();
		delay(1000);
		robot.findDialog("lasagne",true,false,false,false,ImageRecognitionRobot.MS_SHELL_DLG_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testFindInMapping(){
		robot.openFile(EDI_ORDER_REVERSE_MFD);
		robot.selectComponentFromImage(ORDERS_COMPONENT);
		robot.findDialog("f512", false, false, false,false,ImageRecognitionRobot.WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testFind_MWW(){
		robot.openFile(EDI_ORDER_REVERSE_MFD);
		robot.selectComponentFromImage(ORDERS_COMPONENT);
		robot.findDialog("f512", true, false, true,false,ImageRecognitionRobot.WINDOWS_DEFAULT_FONT);
		boolean ifescaped=robot.escapeDialog("Cannot find the string", VK_ESCAPE);delay(500);
		robot.escapeDialog("Find", KeyEvent.VK_ESCAPE);
		if (!ifescaped){
			throw new ScriptMistakeException("Expected 'String was not found' dialog did not appear");
		}
	}
	
	@Test
	public void testFind_MC(){
		robot.openFile(EDI_ORDER_REVERSE_MFD);
		robot.selectComponentFromImage(ORDERS_COMPONENT);
		robot.findDialog("F512",false,true,false,false,ImageRecognitionRobot.WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testFind_MWW_MC_negative(){
		robot.openFile(EDI_ORDER_REVERSE_MFD);
		robot.selectComponentFromImage(ORDERS_COMPONENT);
		robot.findDialog("s010",true,true,true,false,ImageRecognitionRobot.WINDOWS_DEFAULT_FONT);
		boolean ifescaped=robot.escapeDialog("Cannot find the string", VK_ESCAPE);delay(500);
		robot.escapeDialog("Find", KeyEvent.VK_ESCAPE);
		if (!ifescaped){
			throw new ScriptMistakeException("Expected 'String was not found' dialog did not appear");
		}
	}
	
	@Test
	public void testFind_MWW_MC(){
		robot.openFile(EDI_ORDER_REVERSE_MFD);
		robot.selectComponentFromImage(ORDERS_COMPONENT);
		robot.findDialog("F5125",true,true,false,false,ImageRecognitionRobot.WINDOWS_DEFAULT_FONT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testFindAll(){
		robot.openFile(EDI_ORDER_REVERSE_MFD);
		robot.selectComponentFromImage(ORDERS_COMPONENT);
		robot.findDialog("S01",false,true,true,true,ImageRecognitionRobot.WINDOWS_DEFAULT_FONT);
		robot.leftClickMid(robot.findComponentName("Messages"));
		robot.keyType(KeyEvent.VK_HOME);
		assertAreas(MESSAGES);
	}
	
	@Test
	@IgnoreRobots(VSnetMapForceRobot.class) //find next is not supported for VS
	public void testFindNext(){
		robot.openFile(EDI_ORDER_REVERSE_MFD);
		robot.selectComponentFromImage(ORDERS_COMPONENT);
		robot.findDialog("SG1", false, true, false, false,ImageRecognitionRobot.WINDOWS_DEFAULT_FONT);
		robot.findNext();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	@IgnoreRobots(VSnetMapForceRobot.class) //find previous is not supported for VS
	public void testFindPrevious(){
		robot.openFile(EDI_ORDER_REVERSE_MFD);
		robot.selectComponentFromImage(ORDERS_COMPONENT);
		robot.findDialog("SG1", false, true, false, false,ImageRecognitionRobot.WINDOWS_DEFAULT_FONT);
		robot.findNext();
		robot.findPrevious();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testCut(){
		robot.openFile(EDI_ORDER_REVERSE_MFD);
		robot.selectComponentFromImage(ORDERS_COMPONENT);
		delay(2000);
		robot.cut();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testCopyPaste(){
		robot.openFile(EDI_ORDER_REVERSE_MFD);
		robot.selectComponentFromImage(ORDERS_COMPONENT);
		delay(2000);
		robot.copy();
		robot.paste();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testDelete(){
		robot.openFile(EDI_ORDER_REVERSE_MFD);
		robot.selectComponentFromImage(ORDERS_COMPONENT);
		delay(2000);
		robot.delete();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testSelectAll(){
		delay(2000);
		robot.selectAll();
		robot.delete();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
}
