/**
 * 
 */
package com.altova.authentic;

import java.awt.Rectangle;
import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.altova.util.IOUtils;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

/**
 * @author B.Lopez
 *
 */
public class BrowserMenuTest extends AbstractAuthenticTest {

	protected static final File BrowserTest_FILE = IOUtils.findFile("examples/browserMenu1.html");
	
	@Before
	public void setUp() {
		robot.openFile(BrowserTest_FILE);
		Rectangle r = robot.findSelection("Go to link2");
		robot.leftClickMid(r);
	}
	
	@Test
	public void testBrowserBack(){
		robot.browserBack();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testBrowserForward(){
		robot.browserBack();
		robot.browserForward();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public void testBrowserRefresh(){
		robot.browserRefresh();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testBrowserFontsLargest() {
		robot.browserView();
		robot.browserFonts("Largest");
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		} finally {
			robot.browserFonts("Medium");
		}
	}
	
	@Test
	public void testBrowserFontsLarger(){
		robot.browserView();
		robot.browserFonts("Larger");
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		} finally {
			robot.browserFonts("Medium");
		}
	}
	
	@Test
	public void testBrowserFontsMedium(){
		robot.browserView();
		robot.browserFonts("Medium");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testBrowserFontsSmaller(){
		robot.browserView();
		robot.browserFonts("Smaller");
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		} finally {
			robot.browserFonts("Medium");
		}
	}
	
	@Test
	public void testBrowserFontsSmallest(){
		robot.browserView();
		robot.browserFonts("Smallest");
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		} finally {
			robot.browserFonts("Medium");
		}
	}
	
	@Test
	public void testBrowserSeparateWindows(){
		robot.openFile(CONDITIONAL_XML_FILE);
		robot.browserView();
		robot.browserSeparateWindow();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
}
