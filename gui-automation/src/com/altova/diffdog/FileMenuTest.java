package com.altova.diffdog;

import net.hblok.io.DirectoryFileFilter;

import org.junit.Test;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.logging.Logger;
import static java.awt.event.KeyEvent.*;

//import com.altova.robots.ImageNotFoundException;
//import com.altova.robots.ScriptMistakeException;
//import com.altova.util.AltovaJUnitRunner;
import com.altova.robots.CheckboxOption;
import com.altova.robots.RadioOption;
import com.altova.util.IOUtils;
//import com.altova.util.Settings;
//import com.altova.util.AltovaJUnitRunner.TestRobot;
//import com.sun.jmx.mbeanserver.OpenConverter;

import static com.altova.robots.SnapshotArea.CommonArea.*;
//import static com.altova.util.LoggerUtils.logger;



public class FileMenuTest extends AbstractDiffDogTest{
	
	
	private static final File ATTR1=IOUtils.findFileDiffDog("examples/LeftSide/","attr1.xml");
	private static final File ATTR2=IOUtils.findFileDiffDog("examples/RightSide/","attr2.xml");
	private static final File XSDL1=IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","DB2schema.xsd");
	private static final File XSDL2=IOUtils.findFileDiffDog("examples/RightSide/ComparisonFiles/","DB2schema.xsd");
	
	private static final File DOCX1=IOUtils.findFileDiffDog( "examples/LeftSide/WordComparison/", "Chart.docx");
	private static final File DOCX2=IOUtils.findFileDiffDog("examples/RightSide/WordComparison/", "Chart.docx");
	
	private static final File XMLSHEMA_VALID=IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","XMLSchemaComparison_valid_1.xsdif");
	private static final File DATABASE_DATA_FILE=IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","DatabaseDataComparison_DBSchema_1.dbdif");
	private static final File DATABASE_Schema_FILE=IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","DatabaseSchemaComparison_DBSchema_1.dbsdif");
//	private static final File DATABASE_Schema_ZOO=IOUtils.findFile("examples/LeftSide/ComparisonFiles/Zoo.dbsdif");
	
	private static final String DIRDIFF1 = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\LeftSide\\DirDiff";
	private static final String DIRDIFF2 = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\RightSide\\DirDiff";
	
	private static final File XML_SCHEMA_COMPARISON = new File(FILE_OUTPUT_PATH.getAbsolutePath()+"\\XMLSchemaComparison.xsdif");
	private static final File XML_SCHEMA_COMPARISON_SA = new File(FILE_OUTPUT_PATH.getAbsolutePath()+"\\XMLSchemaComparisonSA.xsdif");
	
	private static final File ZOOMFIT = IOUtils.findFileDiffDog("res/","ZoomToFitPage.png");
	private static final File ZOOM100 = IOUtils.findFileDiffDog("res/", "ZOOM100.png");
//	private static final String COMPARE_FILES_ICO = IOUtils.findFile("res/COMPARE_FILES_ICO.png").getAbsolutePath();
	
	
	
	@Test
	public void testCompare2XMLFiles(){
		robot.compareFiles(ATTR1,ATTR2);	
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testCompare2FilesAlreadyBeenCompared(){
		//This test depends from the previous one
		//robot.typeLeftFilePath(ATTR1);
		//robot.leftClickApplyIcon(LEFT_SIDE);
		robot.openFile(LEFT_SIDE,ATTR1);
		assertAreas(TOP_WINDOW);
		delay(500);
		robot.escapeDialog("Recently Compared Pairs", KeyEvent.VK_ESCAPE);
		
	}
	@Test
	public void testCompareDirectoriesCorrectWindowOpened(){
		robot.openCompareDirectoriesWindow();
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testCompareDirectoriesUsingDefaultSettings(){
		
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testCompareXMLSchemasCorrectWindowOpened(){
		
		robot.openCompareXMLSchemasWindow();
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testCompareMSWordFilesCorrectWindow(){
		
		robot.openCompareMSwordWindow();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testCompareDatabaseDataWindowsOpened(){
		
		robot.openCompareDatabaseDataWindow();
		delay(500);
		Rectangle hint = robot.findComponent("C&lose", "Button", null);
		robot.leftClickMid(hint);
		delay(500);
		Rectangle hint2 = robot.findComponent("Cancel", "Button", null);
		robot.leftClickMid(hint2);
		delay(500);
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testCompareDatabaseSchemasWindowsOpened(){
		
		robot.openCompareDatabaseSchemasWindow();
		delay(500);
		Rectangle hint = robot.findComponent("C&lose", "Button", null);
		robot.leftClickMid(hint);
		delay(500);
		Rectangle hint2 = robot.findComponent("Cancel", "Button", null);
		robot.leftClickMid(hint2);
		delay(500);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testOpenValidSchemaComparisonFile(){
		robot.openComparisonFile(XMLSHEMA_VALID);
		assertAreas(MF_MAIN_WINDOW);
	
	}

	@Test
	public void testOpenValidDatabaseDataFile(){
		robot.openComparisonFile(DATABASE_DATA_FILE);
		assertAreas(MF_MAIN_WINDOW);
	
	}
	@Test
	public void testOpenValidDatabaseSchemaFile(){
		robot.openComparisonFile(DATABASE_Schema_FILE);
		assertAreas(MF_MAIN_WINDOW);
	
	}
	
	@Test
	public void testOpenXMLSchemas(){
		robot.compareXMLSchemass(XSDL1,"Altova", XSDL2,"Altova");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testSaveNewXMLSchemaComparison(){
		robot.compareXMLSchemass(XSDL1,"Altova", XSDL2,"Altova");
		robot.leftClickMenuItem("File", "Save");
		delay(1000);
		robot.typeStringEnter(XML_SCHEMA_COMPARISON.getAbsolutePath());
		delay(200);
		assertFileExists(XML_SCHEMA_COMPARISON);
	}
	
	@Test
	public void testSaveAsOfNewXMLSchemaComparison(){
		robot.compareXMLSchemass(XSDL1,"Altova", XSDL2,"Altova");
		robot.leftClickMenuItem("File", "Save As...");
		delay(1000);
		robot.typeStringEnter(XML_SCHEMA_COMPARISON_SA.getAbsolutePath());
		delay(200);
		assertFileExists(XML_SCHEMA_COMPARISON_SA);
	}
//Word	
	@Test
	public void testCompare2DocxFiles(){
		robot.compareWordDocuments(DOCX1, DOCX2);
		delay(10000);
		robot.copyFromLeft();
		delay(10000);
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.escapeDialog("Do you want to continue", VK_N);
		delay(10000);
		robot.leftClickMenuItem("Edit", "Undo");
		assertAreas(MF_MAIN_WINDOW);
		
	}
	@Test
	public void testShowHideFormattingSymbols(){
		
		try{
		robot.compareWordDocuments(DOCX1, DOCX2);
		robot.showForrmatingSymbols();
		assertAreas(MF_MAIN_WINDOW);
		}catch (Exception e) {
			fail(e.getMessage());
		}finally{
			robot.setCursorAtBeginning(LEFT_SIDE);
			robot.escapeDialog("Do you want to continue", VK_N);
			delay(10000);	
			robot.hideForrmatingSymbols();
		}
	}
	@Test
	public void testFitPage(){
		

		robot.compareWordDocuments(DOCX1, DOCX2);
		robot.leftClickOnIcon(ZOOMFIT.getAbsolutePath(),"Word Comparison");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testZOOM100(){
		robot.compareWordDocuments(DOCX1, DOCX2);
		robot.leftClickOnIcon(ZOOM100.getAbsolutePath(),"Word Comparison");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testOpenComaprisonDialog(){
		robot.openComparisonDialog(ATTR1.getAbsolutePath(),ATTR2.getAbsolutePath(), new RadioOption("Compare files"));
		robot.openComparisonDialog();
		robot.keyType(VK_TAB);
		delay(200);
		robot.keyType(VK_DOWN);
		delay(200);
		robot.keyType(VK_TAB);
		delay(200);
		robot.keyType(VK_TAB);
		delay(200);
		robot.keyType(VK_DOWN);
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}	
	
	@Test
	public void testOpenComaprisonDialogDirectories(){
		robot.openComparisonDialog(DIRDIFF1,DIRDIFF2, new RadioOption("Compare directories"));
		robot.openComparisonDialog();
		robot.setDiffDogOptions(new RadioOption("Compare directories"));
		robot.keyType(VK_TAB);
		delay(200);
		robot.keyType(VK_DOWN);
		delay(200);
		robot.keyType(VK_TAB);
		delay(200);
		robot.keyType(VK_TAB);
		delay(200);
		robot.keyType(VK_DOWN);
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	@Test
	public void testOpenComaprisonDialogIncludeSubdirectories(){
		robot.openComparisonDialog(DIRDIFF1,DIRDIFF2, new RadioOption("Compare directories"),new CheckboxOption("Include subdirectories", false));
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testOpenComaprisonDialogFiltr(){
		robot.openComparisonDialog(DIRDIFF1,DIRDIFF2, "Text files",new RadioOption("Compare directories"),new CheckboxOption("Include subdirectories", true));
		assertAreas(MF_MAIN_WINDOW);
	}

	
	@Test
	public void testOpenSimpleDatabaseSchemaFile(){
		robot.openComparisonFile(DATABASE_Schema_FILE);
		assertAreas(MF_MAIN_WINDOW);
	}	
	
	
	
//Word
	
	@Test
	public void testCloseModifiedComparisonCloseButtonWordDocuments(){
		robot.leftClickMenuItem("File", "Compare MS-Word files");
		robot.delay(10000);
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.delay(500);
		robot.typeString("World");
		robot.delay(5000);
		robot.setCursorAtBeginning(LEFT_SIDE);
		robot.delay(5000);
		robot.typeString("World");
		delay(1500);
		robot.closeAll();
		assertAreas(TOP_WINDOW);
		robot.escapeDialog("Save files",VK_ESCAPE);
	}
	
	@Test
	public void testCloseModifiedComparisonFileMenuWordDocuments(){
		robot.leftClickMenuItem("File", "Compare MS-Word files");
		robot.delay(10000);
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.delay(500);
		robot.typeString("World");
		robot.setCursorAtBeginning(LEFT_SIDE);
		robot.delay(500);
		robot.typeString("World");
		delay(1500);
		robot.leftClickMenuItem("File", "Close");
		assertAreas(TOP_WINDOW);
		robot.escapeDialog("Save files",VK_ESCAPE);
	}
	
	//FileMenu
	@Test
	public void testClose(){
		robot.leftClickMenuItem("File", "Close");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		delay(1000);
		robot.leftClickMenuBar("File");
		delay(1000);
		assertAreas(DIFF_DOG_UP_WINDOW);
		delay(300);
		robot.keyType(VK_ESCAPE);
		delay(300);
		robot.leftClickMenuItem("File", "Compare Directories");
	}
	
	@Test
	public void testCloseAll(){
		robot.leftClickMenuItem("File", "Compare Directories");
		delay(1000);
		robot.leftClickMenuItem("File", "Close all");
		delay(1000);
		robot.leftClickMenuBar("File");
		delay(1000);
		assertAreas(DIFF_DOG_UP_WINDOW);
		delay(300);
		robot.keyType(VK_ESCAPE);
		delay(300);
		robot.leftClickMenuItem("File", "Compare Directories");
	}
	
	
	
	
	

	
	
}

