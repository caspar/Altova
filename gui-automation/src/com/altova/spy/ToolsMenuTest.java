package com.altova.spy;


import java.awt.event.KeyEvent;
import java.io.File;

import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;

import org.junit.Test;

import com.altova.util.IOUtils;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static java.awt.event.KeyEvent.VK_ESCAPE;

public class ToolsMenuTest extends AbstractXmlSpyTest{

	private static final File FILE_TO_COMPARE = IOUtils.findFile("spy/examples/NanonullOrg.xml");

	@Test
	public void testSpelling() {
		robot.spelling();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testSpellingOptions() {
		robot.spellingOptions();
	}

	@Test
	public void testCompareOpenFileWith() {
		robot.compareOpenFileWith(FILE_TO_COMPARE.getAbsolutePath());
		assertAreas(DIAGRAM_MAIN_WINDOW);
		//robot.keyType(KeyEvent.VK_ENTER);
		//assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testCompareDirectories() {
		robot.compareDirectories();
	}

	@Test
	public void testCompareOptions() {
		robot.compareOptions();
	}
	
	@Test
	public void testManageRaptorServer() {
		
		robot.manageRaptorServers();
		assertAreas(TOP_WINDOW);
		
		robot.addRaptorXMLServer(null, null, null);
		assertAreas(getTestName()+ "_ServerDialog", TOP_WINDOW);
		
		robot.keyType(VK_ESCAPE);
		delay(500);
		robot.keyType(VK_ESCAPE);
		
	}


	@Test
	public void testCustomize() {
		robot.customize();
	}


}
