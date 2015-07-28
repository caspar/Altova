/**
 * 
 */
package com.altova.authentic;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import java.awt.event.KeyEvent;

import org.junit.Test;

import com.altova.util.ClipboardUtils;

/**
 * @author b.lopez
 *
 */
public class EditMenuTest extends AbstractAuthenticTest {

@Test
	
	public void testUndo() {
	
		robot.find("Firstbread");
		robot.delete();
		robot.undo();
		assertAreas(DIAGRAM_MAIN_WINDOW);	
	}
	
	@Test
	
	public void testRedo() {
	
		robot.find("Nanonull, Inc.");
		robot.delete();
		robot.undo();
		robot.redo();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	
	public void testCut() {
		
		robot.find("Oakstreet");
		robot.cut();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testCopy() {
		
		robot.find("Nanonull");
		robot.copy();
		String clipboard = ClipboardUtils.getClipboardContents();
		assertEquals("Nanonull", clipboard);
	}

	@Test
	
	public void testPaste() {
		
		robot.find("Nanonull, Europe");
		robot.copy();delay(500);
		robot.keyType(KeyEvent.VK_END);delay(500);
		robot.paste();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testDelete() {
		robot.find("Sir");
		robot.delete();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testSelectAll() {	
		robot.selectAll();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public void testFind_MWW_negativeCase() {
		robot.findDialog("Marke", true, false, true);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testFind_MWW() {
		robot.findDialog("MarkETING",true, false, false);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testFind_MC_negativeCase() {
		robot.findDialog("MarkETING", false,true,true);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testMenuFindNext() {
		robot.findDialog("Nanonull",false,false,false);
		robot.findNext();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testReplacenOnly(){
		robot.replaceOnce("Organization", "StringChanged");
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testReplaceAll(){
		robot.replaceAll("Nanonull", "StringChanged");
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
}
