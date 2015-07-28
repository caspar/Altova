package com.altova.diffdog;

import static com.altova.robots.SnapshotArea.CommonArea.*;

import java.io.File;

import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.RadioOption;
import com.altova.util.IOUtils;
import static com.altova.robots.ImageRecognitionRobot.WINDOWS_DEFAULT_FONT;;

public class ComparisonOptionsDatabaseData extends AbstractDiffDogTest{
	private static final File ZOO = IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","Zoo.dbdif");
	private static final File FLOATING_POINT = IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","FloatingPoint.dbdif");
	private static final String DIFF_ICO=IOUtils.findFileDiffDog("res/","DIFF_ICO.png").getAbsolutePath();
	protected final String SAVE_AS_DBIF = FILE_OUTPUT_PATH +"\\ZOO.dbdif";
	
	
	
	@Test	
	public void testPrepare(){
		robot.deleteRegistry();
	}
	
	@Test	
	public void testOptimalizationTrue(){
		robot.openComparisonFile(ZOO);
		robot.openComparisionOptions("Database Data");
		robot.setDiffDogOptions(new CheckboxOption("Keep only different rows in memory",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.startComparison();
		robot.doubleClickOnIcon(DIFF_ICO);
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test	
	public void testOptimalizationFalse(){
		robot.openComparisonFile(ZOO);
		robot.openComparisionOptions("Database Data");
		robot.setDiffDogOptions(new CheckboxOption("Keep only different rows in memory",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.startComparison();
		robot.doubleClickOnIcon(DIFF_ICO);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test	
	public void testComparionOpions(){
		robot.openComparisonFile(ZOO);
		robot.openComparisionOptions("Database Data");
		robot.setDiffDogOptions(new RadioOption("Use string-representation for comparison"));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		File tmp = robot.saveAs(SAVE_AS_DBIF);
		robot.closeAll();
		robot.openComparisonFile(tmp);
		robot.openComparisionOptions("Database Data");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	@Test	
	public void testNumericOpionsTrue(){
		robot.openComparisonFile(FLOATING_POINT);
		robot.openComparisionOptions("Database Data");
		robot.setDiffDogOptions(new CheckboxOption("Append trailing zeros to floating point numbers",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.startComparison();
		robot.doubleClickOnIcon(DIFF_ICO);
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test	
	public void testNumericOpionsFalse(){
		robot.openComparisonFile(FLOATING_POINT);
		robot.openComparisionOptions("Database Data");
		robot.setDiffDogOptions(new CheckboxOption("Append trailing zeros to floating point numbers",false));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.startComparison();
		robot.doubleClickOnIcon(DIFF_ICO);
		delay(500);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test	
	public void testExecutionOptions(){
		robot.compareDatabaseData(null, null);
		robot.openComparisionOptions("Database Data");
		robot.setDiffDogOptions(new RadioOption("Process comparison in parallel"),
				new CheckboxOption("Use transaction when committing", false),
				new CheckboxOption("Rollback on errors", false)
				);
		delay(500);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.openComparisionOptions("Database Data");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	//XML Schema
	
	@Test	
	public void testXMLSchemaToolsOption(){
		robot.leftClickMenuItem("File","Compare XML Schemas");
		robot.leftClickMenuItem("Tools","Comparison Options...");
		robot.setDiffDogOptions(new RadioOption("Map to according parent and transfer", "Transfer global item mapping", null, null, null,WINDOWS_DEFAULT_FONT));
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
		
	}
	
	
}
