package com.altova.spy;

import java.awt.event.KeyEvent;

import org.junit.Before;
import org.junit.Test;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

public class WindowMenuTest extends AbstractXmlSpyTest{

	@Before
	public void setUp() throws Exception {
		super.setUp();
		robot.openFile(ORGCHART_XSD_FILE);
	}
	
	@Test
	public void testWindowCascade() {
		robot.windowCascade();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test //sometimes it fails, because it clicks on the OrgChart.xml logo and activate a browser
	public void testWindowTileHorizontally() {
		robot.windowTileHorizontally();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test //sometimes it fails, because it clicks on the OrgChart.xml logo and activate a browser
	public void testWindowTileVertically() {
		robot.windowTileVertically();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	
	@Test //sometimes it fails, because it clicks on the OrgChart.xml logo and activate a browser
	public void testShowAllWindows() {
		robot.showAllWindows();
		robot.keyType(KeyEvent.VK_UP);
		robot.keyType(KeyEvent.VK_ENTER);
		assertAreas(DIAGRAM_MAIN_WINDOW);	
	}

}
