package com.altova.diffdog;

import org.junit.Test;

//import java.awt.Rectangle;
//import java.awt.event.KeyEvent;
import java.io.File;
//import java.util.logging.Logger;

//import com.altova.nativegui.NativeGUI;
//import com.altova.robots.ScriptMistakeException;
//import com.altova.util.AltovaJUnitRunner;
import com.altova.util.IOUtils;
//import com.altova.util.Settings;
//import com.altova.util.AltovaJUnitRunner.TestRobot;
//import com.sun.jmx.mbeanserver.OpenConverter;

import static com.altova.robots.SnapshotArea.CommonArea.*;
//import static com.altova.util.LoggerUtils.logger;
//import static java.awt.event.KeyEvent.*;


public class GridViewMenuTest extends AbstractDiffDogTest{

	private static final File GNUMERIC1=IOUtils.findFileDiffDog("examples/LeftSide/","gnumeric1.xml");
	private static final File GNUMERIC2=IOUtils.findFileDiffDog("examples/RightSide/","gnumeric2.xml");	
	
	
	@Test	
	public void testCheckToolbar(){
		robot.compareFiles(GNUMERIC1, GNUMERIC2);
		robot.showGridView();
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test	
	public void testNextDiff(){
		robot.compareFiles(GNUMERIC1, GNUMERIC2);
		robot.showGridView();
		robot.nextDifference();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test	
	public void testLastDiff(){
		robot.compareFiles(GNUMERIC1, GNUMERIC2);
		robot.showGridView();
		robot.lastDifference();
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test	
	public void testPrevDiff(){
		robot.compareFiles(GNUMERIC1, GNUMERIC2);
		robot.showGridView();
		robot.lastDifference();
		robot.prefDifference();
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test	
	public void testFirstDiff(){
		robot.compareFiles(GNUMERIC1, GNUMERIC2);
		robot.showGridView();
		robot.nextDifference();
		robot.firstDifference();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test	
	public void testCopyLeftRight(){
		robot.compareFiles(GNUMERIC1, GNUMERIC2);
		robot.showGridView();
		robot.copyFromLeft();
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test	
	public void testCopyRightLeft(){
		robot.compareFiles(GNUMERIC1, GNUMERIC2);
		robot.showGridView();
		robot.copyFromRight();
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test	
	public void testInsertNewElement(){
		robot.compareFiles(GNUMERIC1, GNUMERIC2);
		robot.showGridView();
		robot.find(LEFT_SIDE,"gmr:Sheets");
		robot.leftClickMenuItem("Grid View", "Insert", "Element");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test	
	public void testMoveLeft(){
		robot.compareFiles(GNUMERIC1, GNUMERIC2);
		robot.showGridView();
		robot.find(RIGHT_SIDE,"gmr:Sheets");
		robot.leftClickMenuItem("Grid View", "Move Left");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test	
	public void testMoveRight(){
		robot.compareFiles(GNUMERIC1, GNUMERIC2);
		robot.showGridView();
		robot.find(LEFT_SIDE,"gmr:Sheets");
		robot.leftClickMenuItem("Grid View", "Move Right");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testNavigationBetweenDifferences1(){
		
		robot.compareFiles(NAMESPACE_PREFIX_1, NAMESPACE_PREFIX_2);
		robot.showGridView();
		robot.startComparison();
		robot.lastDifference();
		robot.prefDifference();
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testNavigationBetweenDifferences2(){
		
		robot.compareFiles(NAMESPACE_PREFIX_1, NAMESPACE_PREFIX_2);
		robot.showGridView();
		robot.startComparison();
		robot.nextDifference();
		robot.firstDifference();
		robot.nextDifference();
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testNavigationBetweenDifferences3(){
		
		robot.compareFiles(NAMESPACE_PREFIX_1, NAMESPACE_PREFIX_2);
		robot.showGridView();
		robot.startComparison();
		robot.lastDifference();
		robot.makeCurrentDifference();
		robot.scrollDiffDogPane(LEFT_SIDE,"Afx:00400000:88", 0.0);
		robot.displayCurrentDifference();
		assertAreas(MF_MAIN_WINDOW);
	}


	
	
	
}
