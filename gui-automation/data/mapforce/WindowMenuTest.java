/**
 * 
 */
package com.altova.mapforce;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import java.awt.event.KeyEvent;

import org.junit.Before;
import org.junit.Test;

import com.altova.nativegui.NativeGUI;

/**
 * @author b.lopez
 *
 */
public class WindowMenuTest extends AbstractMapForceTest {

	@Before
	public void setUp() throws Exception {
		super.setUp();
		robot.openFile(COMPLETE_PO_MFD);
	}
	
	@Test
	public void testWindowCascade() {
		robot.windowCascade();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testWindowTileHorizontally() {
		robot.windowTileHorizontally();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testWindowTileVertically() {
		robot.windowTileVertically();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testShowAllWindowsAndCloseOne() {
		robot.showAllWindows();
		robot.leftClickMid(robot.findComponent("Close Window(s)", "Button", NativeGUI.getForegroundWindowInfo().getLocation()));
		assertWindowAndEscape();
		assertAreas(DIAGRAM_MAIN_WINDOW);	
	}
}
