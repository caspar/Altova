package com.altova.authentic;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import java.awt.event.KeyEvent;

import org.junit.Before;
import org.junit.Test;


/**
 * 
 */

/**
 * @author B.Lopez
 *
 */
public class WindowMenuTest extends AbstractAuthenticTest {

	@Before
	public void setUp() throws Exception{
	super.setUp();
	robot.openFileWithoutKnownSPS(EXPREPORT_NOTWELLFORMED_FILE);
	delay(1000);
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
	public void testShowAllWindows() {
		robot.showAllWindows();
		assertWindowAndEscape();	
	}
}
