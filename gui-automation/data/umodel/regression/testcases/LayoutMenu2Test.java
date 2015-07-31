package com.altova.umodel.regression.testcases;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import org.junit.Test;

import com.altova.umodel.regression.gui.EclipseUModelRobot;
import com.altova.util.AltovaJUnitRunner.TestRobot;

//@TestRobot(EclipseUModelRobot.class)
public class LayoutMenu2Test extends AbstractUmodelTest {
	
	//-----------------------------               LAYOUT MENU  -----------------------------
	
	//other menu items tested in the class LayoutMenuTest instead
	//public final void testLayoutLayoutOperation() {	}

	@Test
	public final void testAutosize() {
		robot.openDiagram(CLASS_DIAGRAM);
		robot.zoom(80);
		robot.selectAll();
		robot.autosize();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testRepositionTextLabels() {
		robot.openDiagram(CLASS_DIAGRAM);
		robot.zoom(80);
		robot.selectAll();
		robot.repositionTextLabels();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}


}
