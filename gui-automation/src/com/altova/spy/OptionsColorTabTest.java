package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import java.awt.Color;
import java.awt.event.KeyEvent;

import org.junit.Test;

import com.altova.robots.ColorOption;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;;


public class OptionsColorTabTest extends AbstractSpyOptionsDialogTest{
	@Test
	public void testTableViewHeaderUnselected(){
		ColorOption c=new ColorOption("Header unselected",true,Color.GREEN,"Table view",null,null,"Colors",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Office[1]");
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testTableViewHeaderSelected(){
		ColorOption c=new ColorOption("Header selected",true,Color.RED,"Table view",null,null,"Colors",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Name");
		robot.textView();
		robot.gridView();//these switches change the focus to the diagram window 
		robot.delay(3000);
		robot.keyType(KeyEvent.VK_ENTER);robot.delay(500);
		robot.keyType(KeyEvent.VK_DOWN);robot.delay(500);
		robot.keyType(KeyEvent.VK_RIGHT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testNonExistingElemUnselected(){
		ColorOption c=new ColorOption("Non-existing elements unselected",true,Color.ORANGE,"Table view",null,null,"Colors",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Office");
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testNonExistingElemSelected(){
		ColorOption c=new ColorOption("Non-existing elements selected",true,Color.CYAN,"Table view",null,null,"Colors",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options", c);
		robot.gridView();
		robot.xpathHighlight("/OrgChart/Office");
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
}
