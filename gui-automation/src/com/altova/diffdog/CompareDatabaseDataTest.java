package com.altova.diffdog;
//import java.awt.Rectangle;
//import java.awt.event.KeyEvent;
import java.io.File;
import static java.awt.event.KeyEvent.*;
//import java.util.logging.Logger;

import org.junit.Test;

//import static java.awt.event.KeyEvent.*;
//import com.altova.robots.ScriptMistakeException;
import com.altova.util.IOUtils;
//import com.altova.util.Settings;
//import com.altova.util.AltovaJUnitRunner.TestRobot;
//import com.sun.jmx.mbeanserver.OpenConverter;

import static com.altova.robots.SnapshotArea.CommonArea.*;
//import static com.altova.util.LoggerUtils.logger;

public class CompareDatabaseDataTest extends AbstractDiffDogTest{

	private static final File COMPANY1=IOUtils.findFileDiffDog("examples/LeftSide/Databases/","company.mdb");
	private static final File COMPANY2=IOUtils.findFileDiffDog("examples/RightSide/Databases/","company.mdb");
	
	private static final File DB_COMPARISON_SCHEMA1=IOUtils.findFileDiffDog("LeftSide/ComparisonFiles/", "DatabaseDataComparison1.dbdif");
	private static final File DB2_SCHEMA=IOUtils.findFileDiffDog("examples/RightSide/databases/","db2schema.mdb");
	private static final File DB_COMPARISON2=IOUtils.findFileDiffDog("LeftSide/ComparisonFiles/", "DatabaseDataComparison2.dbdif");
	private static final String DIFF_ICO=IOUtils.findFile("res/DIFF_ICO.png").getAbsolutePath();
	private static final File ZOO = IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","Zoo.dbdif");

	
	@Test
	public void testConnectionDialogs(){
		robot.compareDatabaseData(COMPANY1, COMPANY1);
		robot.selectDataBaseComparasionCheckbox(LEFT_SIDE);
		robot.selectDataBaseComparasionCheckbox(RIGHT_SIDE);
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testUndoChangingDatabaseSource(){
		
		robot.openComparisonFile(DB_COMPARISON_SCHEMA1);
		delay(2000);
		robot.openDatabaseData(LEFT_SIDE, DB2_SCHEMA);
		robot.undo();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testNativeAndXMLComaprison(){
		
		robot.openComparisonFile(DB_COMPARISON2);
		robot.databaseComparisonToogles(false,true, true);
		robot.startComparison();
		robot.doubleClickOnIcon(DIFF_ICO);
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testResultWindowShowHideP1S1(){
		
		robot.openComparisonFile(ZOO);
		robot.databaseComparisonToogles(false,true, false);
		robot.startComparison();
		robot.doubleClickOnIcon(DIFF_ICO);
		robot.setDBComparisonResultToogles(0,2,2,2,2,2,2);
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testResultWindowShowHideP1S2(){
		
		robot.openComparisonFile(ZOO);
		robot.databaseComparisonToogles(false,true, false);
		robot.startComparison();
		robot.doubleClickOnIcon(DIFF_ICO);
		robot.setDBComparisonResultToogles(1,0,2,2,2,2,2);
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testResultWindowShowHideP1S3(){
		
		robot.openComparisonFile(ZOO);
		robot.databaseComparisonToogles(false,true, false);
		robot.startComparison();
		robot.doubleClickOnIcon(DIFF_ICO);
		robot.setDBComparisonResultToogles(1,1,2,0,2,2,2);
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testResultWindowNavigateThroughtDifferences1(){
		
		robot.openComparisonFile(ZOO);
		robot.databaseComparisonToogles(false,true, false);
		robot.startComparison();
		robot.doubleClickOnIcon(DIFF_ICO);
		robot.setDBComparisonResultToogles(1,1,1,1,2,2,2);
		robot.lastDifference();
		robot.prefDifference();
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testResultWindowNavigateThroughtDifferences2(){
		
		robot.openComparisonFile(ZOO);
		robot.databaseComparisonToogles(false,true, false);
		robot.startComparison();
		robot.doubleClickOnIcon(DIFF_ICO);
		robot.setDBComparisonResultToogles(1,1,1,1,2,2,2);
		robot.firstDifference();
		robot.nextDifference();
		robot.nextDifference();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testDataComparisonInSchemaComparison(){
		
		robot.openComparisonFile(ZOO);
		robot.leftClickOnIcon(robot.NEW_DATA_COMPARISON_ICON, "Standard");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	
	
}
