package com.altova.diffdog;

import org.junit.Test;
//import java.awt.Rectangle;
//import java.awt.event.KeyEvent;
import java.io.File;
//import java.util.logging.Logger;

//import com.altova.robots.ScriptMistakeException;
//import com.altova.util.AltovaJUnitRunner;
import com.altova.util.IOUtils;
//import com.altova.util.Settings;
//import com.altova.util.AltovaJUnitRunner.TestRobot;
//import com.sun.jmx.mbeanserver.OpenConverter;
//import com.sun.net.ssl.internal.ssl.Debug;

import static com.altova.robots.SnapshotArea.CommonArea.*;
//import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.*;

public class DiffAndMergeMenuTest extends AbstractDiffDogTest{

	private static final File GNUMERIC1=IOUtils.findFileDiffDog("examples/LeftSide/","gnumeric1.xml");
	private static final File GNUMERIC2=IOUtils.findFileDiffDog("examples/RightSide/","gnumeric2.xml");
	
	private static final File XSDL1=IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","DB2schema.xsd");
	private static final File XSDL2=IOUtils.findFileDiffDog("examples/RightSide/ComparisonFiles/","DB2schema.xsd");
	
	private static final File RESULT_GENERATION_FILE_LEFT = new File(FILE_OUTPUT_PATH.getAbsolutePath()+"\\genResultLeftRight.xslt");
	private static final File RESULT_GENERATION_FILE_RIGHT = new File(FILE_OUTPUT_PATH.getAbsolutePath()+"\\genResultRightLeft.xslt");
	
	private static final File XSLT_GENERATION_LEFT_RIGHT = new File(FILE_OUTPUT_PATH.getAbsolutePath()+"\\genResultLeftRight.xslt");
	private static final File XSLT_GENERATION_RIGHT_LEFT= new File(FILE_OUTPUT_PATH.getAbsolutePath()+"\\genResultLeftRight.xslt");
	
//	private static final File DOCX1=IOUtils.findFile("examples/LeftSide/WordComparison/Chart.docx");
//	private static final File DOCX2=IOUtils.findFile("examples/RightSide/WordComparison/Chart.docx");
	
	private static final File DOC_NATIONAL_TEAM=IOUtils.findFileDiffDog("examples/RightSide/WordComparison/","Bewerbung_Nationalteam_2010.doc");
	
	private static final File BULLETS_DOC1=IOUtils.findFileDiffDog("examples/LeftSide/WordComparison/","Bullets_1.doc");
	private static final File BULLETS_DOC2=IOUtils.findFileDiffDog("examples/RightSide/WordComparison/","Bullets_1.doc");
	
	private static final File NAVIGATE_DOC1=IOUtils.findFileDiffDog("examples/LeftSide/WordComparison/","Navigate.doc");
	private static final File NAVIGATE_DOC2=IOUtils.findFileDiffDog("examples/RightSide/WordComparison/","Navigate.doc");


	@Test
	public void testCompareAsBinaryTextView(){
		robot.compareFiles(GNUMERIC1,GNUMERIC2);
		robot.leftClickMenuItem("Diff and Merge", "Compare as Binary");
		delay(1500);
		if (!robot.escapeDialog("Binary comparison: files are different!", VK_ESCAPE))
			fail("Files are different window doesn't show up");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testCompareTextualXMLTextView(){
		robot.compareFiles(GNUMERIC1,GNUMERIC2);
		robot.leftClickMenuItem("Diff and Merge", "Textual Comparison Only");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testCompareAccordingToFileExtensionTextView(){
		robot.compareFiles(GNUMERIC1,GNUMERIC2);
		robot.leftClickMenuItem("Diff and Merge", "Compare According to File Extension Settings");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testCompareAsXMLTextView(){
		robot.compareFiles(GNUMERIC1,GNUMERIC2);
		robot.setCompareAsTXT();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	
	@Test
	public void testCompareAsBinary(){
		robot.compareFiles(GNUMERIC1,GNUMERIC2);
		robot.showGridView();
		robot.setCompareAsBinary();
		delay(1500);
		if (!robot.escapeDialog("Binary comparison: files are different!", VK_ESCAPE))
			fail("Files are different window doesn't show up");
	}
	@Test
	public void testCompareAccordingToFileExtension(){
		robot.compareFiles(GNUMERIC1,GNUMERIC2);
		robot.showGridView();
		robot.leftClickMenuItem("Diff and Merge", "Compare According to File Extension Settings");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testCompareAsXML(){
		robot.compareFiles(GNUMERIC1,GNUMERIC2);
		robot.showGridView();
		robot.leftClickMenuItem("Diff and Merge", "Compare as XML");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testDisplayCurrentDiff(){
		robot.compareFiles(GNUMERIC1,GNUMERIC2);
		robot.showGridView();
		robot.find(LEFT_SIDE, "gmr:Workbook");
		robot.fullyExpandAllSelected();
		robot.leftClickMenuItem("Diff and Merge", "Display Current Difference");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testMakeCurrentDiff(){
		robot.compareFiles(GNUMERIC1,GNUMERIC2);
		robot.showGridView();
		robot.find(LEFT_SIDE,"endCol");
		robot.leftClickMenuItem("Diff and Merge", "Make Current Difference");
		robot.find(LEFT_SIDE,"gmr:Workbook");
		robot.fullyExpandAllSelected();
		robot.leftClickMenuItem("Diff and Merge", "Display Current Difference");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testCollapseUnselected(){
		robot.compareFiles(GNUMERIC1,GNUMERIC2);
		robot.showGridView();
		robot.find(LEFT_SIDE,"gmr:Workbook");
		robot.colapseAllSelected();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testDisplayAsTable(){
		robot.compareFiles(GNUMERIC1,GNUMERIC2);
		robot.showGridView();
		robot.find(LEFT_SIDE,"gmr:Workbook");
		robot.displayAsTable();
		robot.find(LEFT_SIDE,"gmr:UIData");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testFullExpand(){
		robot.compareFiles(GNUMERIC1,GNUMERIC2);
		robot.showGridView();
		robot.find(LEFT_SIDE,"gmr:Workbook");
		robot.fullyExpandAllSelected();
		assertAreas(MF_MAIN_WINDOW);
	}
//XML Schema
	
	@Test
	public void testAutomapOnLoadXMLSchemaOFF(){
		robot.leftClickMenuItem("File","Compare XML Schemas");
		robot.leftClickMenuItem("Diff and Merge", "Automap on Load XML Schema");
		robot.openSchema(LEFT_SIDE,XSDL1,"Altova");
		robot.openSchema(RIGHT_SIDE,XSDL1,"Altova");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testAutomapOnLoadXMLSchemaON(){
		robot.leftClickMenuItem("File","Compare XML Schemas");
		robot.leftClickMenuItem("Diff and Merge", "Automap on Load XML Schema");
		robot.openSchema(LEFT_SIDE,XSDL1,"Altova");
		robot.openSchema(RIGHT_SIDE,XSDL1,"Altova");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testXSLTGenerationLeftRight(){
		robot.compareXMLSchemass(XSDL1,"Altova", XSDL2,"Altova");
		robot.leftClickMenuItem("Diff and Merge", "Generate XSLT Left to Right");
		delay(500);
		robot.typeStringEnter(XSLT_GENERATION_LEFT_RIGHT.getAbsolutePath());
		delay(500);
		assertFileExists(XSLT_GENERATION_LEFT_RIGHT);
	}
	
	@Test
	public void testXSLTGenerationRightLeft(){
		robot.compareXMLSchemass(XSDL1,"Altova", XSDL2,"Altova");
		robot.leftClickMenuItem("Diff and Merge", "Generate XSLT Left to Right");
		delay(500);
		robot.typeStringEnter(XSLT_GENERATION_RIGHT_LEFT.getAbsolutePath());
		robot.escapeDialog("Do you want to replace it?", VK_Y);
		delay(500);
		assertFileExists(XSLT_GENERATION_RIGHT_LEFT);
	}
	
	@Test
	public void testResultGenerationLeftRight(){
		robot.compareXMLSchemass(XSDL1,"Altova", XSDL2,"Altova");
		robot.copyFromLeft();
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		delay(1000);
		robot.typeStringEnter(RESULT_GENERATION_FILE_LEFT.getAbsolutePath());
		delay(500);
		robot.escapeDialog("Do you want to replace it?", VK_Y);
		delay(500);
		assertFileExists(RESULT_GENERATION_FILE_LEFT);
	}
	@Test
	public void testResultGenerationRightLeft(){
		robot.compareXMLSchemass(XSDL1,"Altova", XSDL2,"Altova");
		robot.copyFromLeft();
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		delay(1000);
		robot.typeStringEnter(RESULT_GENERATION_FILE_RIGHT.getAbsolutePath());
		delay(500);
		robot.escapeDialog("Do you want to replace it?", VK_Y);
		delay(500);
		assertFileExists(RESULT_GENERATION_FILE_RIGHT);
	}
	
	//Word Documents
	@Test
	public void testMergeDifferenceToEmtyRightSide(){
		robot.openWordDocument(LEFT_SIDE,DOC_NATIONAL_TEAM );
		delay(5000);
		robot.startComparison();
		delay(5000);
		robot.copyFromLeft();
		robot.setCursorAtBeginning(RIGHT_SIDE);
		delay(500);
		robot.copyFromLeft();
		delay(5000);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testMergeToLeftReload(){
		robot.compareWordDocuments(BULLETS_DOC1, BULLETS_DOC2);
		delay(10000);
		robot.copyFromRight();
		robot.reload(LEFT_SIDE);
		if (robot.escapeDialog("Do you want to reload this file and lose changes",VK_Y)){
			
		}else
			fail("Expected dialog didn't appeared");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testNavigationBetweenDifferences1(){
		
		robot.compareWordDocuments(NAVIGATE_DOC1, NAVIGATE_DOC2);
		delay(10000);
		robot.startComparison();
		robot.lastDifference();
		robot.prefDifference();
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testNavigationBetweenDifferences2(){
		
		robot.compareWordDocuments(NAVIGATE_DOC1, NAVIGATE_DOC2);
		delay(10000);
		robot.startComparison();
		robot.nextDifference();
		robot.firstDifference();
		robot.nextDifference();
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testUndoRedoModification(){
		robot.leftClickMenuItem("File", "Compare MS-Word files");
		robot.setCursorAtBeginning(LEFT_SIDE);
		robot.typeString("Hello!");
		robot.copyFromLeft();
		robot.undo();
		delay(100);
		robot.redo();
		delay(100);
		robot.undo();
		delay(100);
		assertAreas(MF_MAIN_WINDOW);
	}

}
