package com.altova.spy;


import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import java.awt.Rectangle;
import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.altova.util.IOUtils;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;

//@TestRobot(EclipseSpyRobot.class)

public class BrowserMenuTest extends AbstractXmlSpyTest{

	protected static final String EXAMPLES_browser = "browserMenu1.html";
	protected static final String EXAMPLES_link1 = "Go to link2";

	
	@Before
	public void setUp() {
		File page1 = IOUtils.findFile(EXAMPLES_browser);
		assertFileExists(page1);
		robot.openFile(page1.toString());
		robot.browserFonts("Medium");
		Rectangle r = robot.findSelection(EXAMPLES_link1);
		robot.leftClickMid(r);
	}
		
	@IgnoreRobots({VSnetSpyRobot.class}) //not available in the integrations
	@Test
	public void testBrowserBack() {
		
		robot.browserBack();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@IgnoreRobots({VSnetSpyRobot.class}) //not available in the integrations
	@Test
	public void testBrowserForward() {
		robot.browserBack();
		robot.browserForward();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testBrowserRefresh() {
		robot.browserRefresh();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testBrowserFonts() {
		robot.browserFonts("Smaller");
		assertAreas(DIAGRAM_MAIN_WINDOW);
		robot.browserFonts("Medium");
	}

	@Test
	@IgnoreRobots({EclipseSpyRobot.class,VSnetSpyRobot.class}) //there is not such an option available in the integrations
	
	public void testBrowserSeparateWindow() {
		robot.browserSeparateWindow();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

}
