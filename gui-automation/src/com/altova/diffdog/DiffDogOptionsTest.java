package com.altova.diffdog;

import static com.altova.robots.SnapshotArea.CommonArea.*;
import static java.awt.event.KeyEvent.*;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;

//import java.awt.Rectangle;
//import java.io.File;

import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.ImageUtils;
import com.altova.robots.Options;
import com.altova.robots.RadioOption;
import com.altova.util.IOUtils;
//import com.altova.robots.Pane;
//import com.altova.robots.ScreenDiff;
//import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm.WordListener;

public class DiffDogOptionsTest extends AbstractDiffDogTest{
	protected final String POE = FILE_OUTPUT_PATH +"\\POE_TMP.txt";
	protected final String POE_BAK = FILE_OUTPUT_PATH +"\\POE_TMP.bak";
	
	private static final File WORDWRAP1=IOUtils.findFileDiffDog("examples/LeftSide/","wordwrap1.xml");
	private static final File WORDWRAP2=IOUtils.findFileDiffDog("examples/RightSide/","wordwrap2.xml");
	private static final File ZOO_DBSDIF = IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","Zoo.dbsdif");
	private static final File ZOO_DBDIF = IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","Zoo.dbdif");
	private static final File ZOO_CASESENSE = IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","Zoo_CaseSense.dbdif");
	private static final File ZOO_CASESENSE_TABLES = IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","Zoo_CaseSense_tables.dbdif");
	
	private static final String DIFF_ICO=IOUtils.findFileDiffDog("res/","DIFF_ICO.png").getAbsolutePath();
	private static final File ANIMALS_ID=IOUtils.findFileDiffDog("tags_list/","AnimalsID.png");
	private static final File ZOO1 = IOUtils.findFileDiffDog("examples/LeftSide/Databases/","Zoo.mdb");
	private static final File ZOO2 = IOUtils.findFileDiffDog("examples/LeftSide/Databases/","Zoo.mdb");
	private static final String ANIMALS_LEFT = IOUtils.findFileDiffDog("tags_list/","Animals_Left.png").getAbsolutePath();
	private static final String ANIMALS_RIGHT = IOUtils.findFileDiffDog("tags_list/","Animals_Right.png").getAbsolutePath();
	private static final String SOURCE_GRAY=IOUtils.findFileDiffDog("res/","SOURCE_GRAY.png").getAbsolutePath();
	
	private static final String WORDDIRDIFF1 = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\LeftSide\\WordComparison";
	private static final String WORDDIRDIFF2 = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\RightSide\\WordComparison";
	private static final String DOT_DOC = IOUtils.findFileDiffDog("tags_list/","dotdoc.png").getAbsolutePath();
	private static final String DOT_DOCX = IOUtils.findFileDiffDog("tags_list/","dotdocx.png").getAbsolutePath();
	private static final String DOT_XML = IOUtils.findFileDiffDog("tags_list/","dotXML.png").getAbsolutePath();
	private static final String DOT_ASP = IOUtils.findFileDiffDog("tags_list/","dotasp.png").getAbsolutePath();
	
	private static final String TEXT_WHITESPACE = IOUtils.findFileDiffDog("tags_list/","Text_Whitespace.png").getAbsolutePath();
	private static final String CHART = IOUtils.findFileDiffDog("tags_list/","Chart.png").getAbsolutePath();
	
	private static final String DIFFERENCE = IOUtils.findFileDiffDog("tags_list/","DifferenceColor.png").getAbsolutePath();
	private static final String OTHER = IOUtils.findFileDiffDog("tags_list/","Other.png").getAbsolutePath();
	private static final String YELLOW = IOUtils.findFileDiffDog("tags_list/","Yellow.png").getAbsolutePath();
	private static final String CurrentDiff= IOUtils.findFileDiffDog("tags_list/","CurrentDiff.png").getAbsolutePath();
	private static final String Green = IOUtils.findFileDiffDog("tags_list/","Green.png").getAbsolutePath();
	private static final String MergedDiff = IOUtils.findFileDiffDog("tags_list/","MergedDiff.png").getAbsolutePath();
	private static final String CurrentDiffMerged = IOUtils.findFileDiffDog("tags_list/","CurrentDiffMerged.png").getAbsolutePath();
	
	private static final File COMPARE_WHILE_EDITING_ON = IOUtils.findFileDiffDog("res/","COMPARE_WHILE_EDITING_ON.png");
	private static final File COMPARE_WHILE_EDITING_OFF = IOUtils.findFileDiffDog("res/","COMPARE_WHILE_EDITING_OFF.png");
	
	private static final String COPY_FILTER = IOUtils.findFileDiffDog("res/DirectoryFilters/","Copy.png").getAbsolutePath();;
	private static final String PASTE_FILTER = IOUtils.findFileDiffDog("res/DirectoryFilters/","Paste.png").getAbsolutePath();;
	private static final String DELETE_FILTER = IOUtils.findFileDiffDog("res/DirectoryFilters/","Delete.png").getAbsolutePath();;
	private static final String NEW_FILTER = IOUtils.findFileDiffDog("res/DirectoryFilters/","New.png").getAbsolutePath();;
	private static final String EDIT_FILTER = IOUtils.findFileDiffDog("res/DirectoryFilters/","Edit.png").getAbsolutePath();;
	private static final String MOVE_DOWN_FILTER = IOUtils.findFileDiffDog("res/DirectoryFilters/","MoveDown.png").getAbsolutePath();;
	private static final String MOVE_UP_FILTER = IOUtils.findFileDiffDog("res/DirectoryFilters/","MoveUp.png").getAbsolutePath();;
	
	private static final String TEXT_FILES = IOUtils.findFileDiffDog("tags_list/DirectoryFilters/","TextFiles.png").getAbsolutePath();
	private static final String NO_FILE_DIRECOTRY_FILTER = IOUtils.findFileDiffDog("tags_list/DirectoryFilters/","NO_FILE_DIRECOTRY_FILTER.png").getAbsolutePath();
	
	@Test
	public void testBackupFilesAppend(){
		robot.copyFiles(EDGAR_ALLAN_POE1, POE);//Copy is needed because, in next steps we need to save this file
		robot.compareFiles(POE,EDGAR_ALLAN_POE2.getAbsolutePath());
		robot.openDiffDogOptions("File comparison");
		robot.setDiffDogOptions(new CheckboxOption("Append .BAK to extension",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.setCursorAfterFoundString(LEFT_SIDE, "life of forty years");
		robot.typeString(" ");
		robot.saveFile(LEFT_SIDE);
		robot.leftClickMenuItem("File", "Compare Files");
		robot.openFile(LEFT_SIDE,POE+".bak");
		//robot.openLeftFile(POE+".bak");
		//robot.leftClickApplyIcon(LEFT_SIDE);
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testBackupFilesReplace(){
		robot.copyFiles(EDGAR_ALLAN_POE1, POE);//Copy is needed because, in next steps we need to save this file
		robot.compareFiles(POE,EDGAR_ALLAN_POE2.getAbsolutePath());
		robot.openDiffDogOptions("File comparison");
		robot.setDiffDogOptions(new CheckboxOption("Replace extension with .BAK",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.setCursorAfterFoundString(LEFT_SIDE, "life of forty years");
		robot.typeString(" ");
		robot.saveFile(LEFT_SIDE);
		robot.leftClickMenuItem("File", "Compare Files");
		robot.openFile(LEFT_SIDE,POE_BAK);
		//robot.openLeftFile(POE_BAK);
		//robot.leftClickApplyIcon(LEFT_SIDE);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testEditing(){
		robot.compareFiles(EDGAR_ALLAN_POE1,EDGAR_ALLAN_POE2);
		
		robot.openDiffDogOptions("File comparison");
		robot.setDiffDogOptions(new CheckboxOption("Clicking a difference makes it the current difference",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.startComparison();
		robot.find(LEFT_SIDE,"The Raven");
		robot.findNext();
		robot.scrollDiffDogPane(LEFT_SIDE,"Scintilla", 0.0);
		robot.displayCurrentDifference();
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testEditingFont(){
		robot.compareFiles(EDGAR_ALLAN_POE1,EDGAR_ALLAN_POE2);
		robot.openDiffDogOptions("File comparison");
		robot.setDiffDogOptions(new CheckboxOption("Clicking a difference makes it the current difference",false));
		delay(200);
		robot.keyType(VK_TAB);
		delay(200);
		robot.keyType(VK_ENTER);
		delay(200);
		robot.keyType(VK_TAB);
		delay(100);
		robot.typeString("Bold");
		delay(100);
		robot.keyType(VK_TAB);
		delay(100);
		robot.typeString("12");
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		delay(100);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.startComparison();
		robot.lastDifference();
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test
	public void testColorsDifference(){
		robot.compareFiles(EDGAR_ALLAN_POE1,EDGAR_ALLAN_POE2);
		robot.openDiffDogOptions("File comparison");
		robot.leftClickOnIcon(DIFFERENCE,"Colors" );
		delay(200);
		robot.leftClickOnIcon(OTHER,null);
		delay(200);
		robot.leftClickOnIcon(YELLOW,"Static" );
		delay(200);
		robot.okButton();
		delay(200);
		robot.okButton();
		delay(200);
		assertAreas(MF_MAIN_WINDOW);
		robot.defaultColorButton();
	}
	@Test
	public void testColorsCurrentDiff(){
		robot.compareFiles(EDGAR_ALLAN_POE1,EDGAR_ALLAN_POE2);
		robot.openDiffDogOptions("File comparison");
		robot.leftClickOnIcon(CurrentDiff,"Colors" );
		delay(200);
		robot.leftClickOnIcon(OTHER,null);
		delay(200);
		robot.leftClickOnIcon(Green,"Static" );
		robot.okButton();
		delay(200);
		robot.okButton();
		robot.goToLine(LEFT_SIDE, "15", "1");
		robot.makeCurrentDifference();
		assertAreas(MF_MAIN_WINDOW);
		robot.defaultColorButton();
	}
	@Test
	public void testColorsMergedDiff(){
		
		robot.leftClickOnString("Diff and Merge");
		robot.setToogle(false, COMPARE_WHILE_EDITING_ON, COMPARE_WHILE_EDITING_OFF);
		robot.compareFiles(EDGAR_ALLAN_POE1,EDGAR_ALLAN_POE2);
		robot.openDiffDogOptions("File comparison");
		robot.leftClickOnIcon(MergedDiff,"Colors" );
		delay(200);
		robot.leftClickOnIcon(OTHER,null);
		delay(200);
		robot.leftClickOnIcon(YELLOW,"Static" );
		robot.okButton();
		delay(200);
		robot.okButton();
		robot.copyFromLeft();
		robot.nextDifference();
		robot.scrollDiffDogPane(LEFT_SIDE, "Scintilla", 0.0);
		assertAreas(MF_MAIN_WINDOW);
		robot.defaultColorButton();
	}
	@Test
	public void testCurrentDiffMerged(){
		
		robot.leftClickOnString("Diff and Merge");
		robot.setToogle(false, COMPARE_WHILE_EDITING_ON, COMPARE_WHILE_EDITING_OFF);
		robot.compareFiles(EDGAR_ALLAN_POE1,EDGAR_ALLAN_POE2);
		robot.openDiffDogOptions("File comparison");
		robot.leftClickOnIcon(CurrentDiffMerged,"Colors" );
		delay(200);
		robot.leftClickOnIcon(OTHER,null);
		delay(200);
		robot.leftClickOnIcon(Green,"Static" );
		robot.okButton();
		delay(200);
		robot.okButton();
		robot.copyFromLeft();
		assertAreas(MF_MAIN_WINDOW);
		robot.defaultColorButton();
		
	}
	
	@Test
	public void testPrityPrintXML(){
		robot.openFile(LEFT_SIDE, DETAILED_DIFF1);
		robot.openDiffDogOptions("File comparison");
		robot.setDiffDogOptions(new CheckboxOption("Pretty-Print XML-files when loading",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.openFile(RIGHT_SIDE, DETAILED_DIFF2);
		robot.reload(LEFT_SIDE);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	//TextViewTests
	
	@Test
	public void testComparisonTab(){
		robot.openDiffDogOptions("File comparison");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	@Test
	public void testPrityPrintWhenLoading(){
		
		robot.openDiffDogOptions("File comparison");
		robot.setDiffDogOptions(new CheckboxOption("Pretty-Print XML-files when loading",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.compareFiles(WORDWRAP1, WORDWRAP2);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test
	public void testEditingTextView(){
		robot.compareFiles(WORDWRAP1,WORDWRAP2);
		robot.openDiffDogOptions("File comparison");
		robot.setDiffDogOptions(new CheckboxOption("Clicking a difference makes it the current difference",true));
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		robot.startComparison();
		robot.goToLine(LEFT_SIDE, "64", "1");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testSchemaComparisonMapUnconnectedTrue(){
		robot.openComparisonFile(ZOO_DBSDIF);
		robot.startComparison();
		Rectangle rect = robot.findTagsImage(ANIMALS_ID);
		robot.contextMenu("Unmap selected", ImageUtils.findMid(rect));
		robot.openDiffDogOptions("Database comparison");
		robot.setDiffDogOptions(new CheckboxOption("" +
				"Try to map unconnected items during comparison",true));
		robot.okButton();
		robot.startComparison();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testSchemaComparisonMapUnconnectedFalse(){
		robot.openComparisonFile(ZOO_DBSDIF);
		Rectangle rect = robot.findTagsImage(ANIMALS_ID);
		robot.startComparison();
		robot.contextMenu("Unmap selected", ImageUtils.findMid(rect));
		delay(2000);
		robot.openDiffDogOptions("Database comparison");
		robot.setDiffDogOptions(new CheckboxOption("" +
				"Try to map unconnected items during comparison",false));
		robot.okButton();
		robot.startComparison();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testDataBaseDataResultView(){
		robot.openComparisonFile(ZOO_DBDIF);
		robot.openDiffDogOptions("Database Data Result View");
		robot.setDiffDogOptions(
				new CheckboxOption(" Show horizontal lines", false),
				new CheckboxOption("Show vertical lines", false),//this need to be last
				new CheckboxOption(" Show line numbers", false));
		robot.keyType(VK_TAB);
		robot.typeString("10");
		robot.okButton();
		delay(100);
		robot.startComparison();
		robot.doubleClickOnIcon(DIFF_ICO);
		assertAreas(MF_MAIN_WINDOW);


	}
	@Test
	public void testDataBaseDataResultViewTrue(){
		robot.openComparisonFile(ZOO_DBDIF);
		robot.openDiffDogOptions("Database Data Result View");
		robot.setDiffDogOptions(
				new CheckboxOption(" Show horizontal lines", true),
				new CheckboxOption("Show vertical lines", true),//this need to be last
				new CheckboxOption(" Show line numbers", true));
		robot.keyType(VK_TAB);
		robot.typeString("2");
		robot.okButton();
		delay(100);
		robot.startComparison();
		robot.doubleClickOnIcon(DIFF_ICO);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testDataBaseDataMapTablesAutomatically1(){
		robot.compareDatabaseData(null,null);
		robot.openDiffDogOptions("Database comparison");
		robot.setDiffDogOptions(new CheckboxOption("Map tables automatically", false));
		robot.okButton();
		robot.openDatabaseData(LEFT_SIDE,ZOO1);
		robot.openDatabaseData(RIGHT_SIDE,ZOO2);
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testDataBaseDataMapTablesAutomatically2(){
		robot.compareDatabaseData(null,null);
		robot.openDiffDogOptions("Database comparison");
		robot.setDiffDogOptions(new CheckboxOption("Map tables automatically", true));
		robot.okButton();
		robot.openDatabaseData(LEFT_SIDE,ZOO1);
		robot.openDatabaseData(RIGHT_SIDE,ZOO2);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testMapColumnsAutomatically(){
		robot.compareDatabaseData(null,null);
		robot.openDiffDogOptions("Database comparison");
		robot.setDiffDogOptions(new CheckboxOption("Map columns automatically", false));
		robot.okButton();
		robot.openComparisonFile(ZOO_DBDIF);
		robot.contextMenu("Unmap items");
		robot.dragDropSchema(ANIMALS_LEFT, ANIMALS_RIGHT);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testMapColumnsAutomaticallyTrue(){
		robot.compareDatabaseData(null,null);
		robot.openDiffDogOptions("Database comparison");
		robot.setDiffDogOptions(new CheckboxOption(" Map columns automatically", true),
				new RadioOption("Find mapping by name and type"),
				new CheckboxOption("Ignore identity columns", true));
		robot.okButton();
		robot.openComparisonFile(ZOO_DBDIF);
		robot.contextMenu("Unmap items");
		robot.dragDropSchema(ANIMALS_LEFT, ANIMALS_RIGHT);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	
	/**
	 * TC Database comparison - Automatic table and column mapping |Map columns automatically - find mapping && Ignore
	 * step1: open comparison file
	 * step2: open options
	 * check "Ignore case when mapping by name"
     * step3: press OK 
       delete connection between ""Animals"" and re-connect

	 */
	@Test
	public void testMapColumnsAutomaticallyIgnoreCaseWhenMappingTrue(){
		
		robot.openComparisonFile(ZOO_CASESENSE);
		robot.openDiffDogOptions("Database comparison");
		robot.setDiffDogOptions(new CheckboxOption("Ignore case when mapping by names", true));
		robot.okButton();
		robot.contextMenu("Unmap items");
		robot.dragDropSchema(ANIMALS_LEFT, ANIMALS_RIGHT);
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testMapColumnsAutomaticallyFindMappingBasedOnColumnPositionTrue(){
		
		robot.openComparisonFile(ZOO_CASESENSE);
		robot.openDiffDogOptions("Database comparison");
		robot.setDiffDogOptions(new RadioOption("Find mapping based on column position"));
		robot.okButton();
		robot.contextMenu("Unmap items");
		robot.dragDropSchema(ANIMALS_LEFT, ANIMALS_RIGHT);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	/**
	 * Find mapping by name and type = true
     * Ignore case when mapping by name = false
     * Exact match when mapping by name = false
	 */
	@Test
	public void testMapColumnsAutomaticallyFindMappingByNameAndTypeTrue(){
		
		robot.openComparisonFile(ZOO_CASESENSE);
		robot.openDiffDogOptions("Database comparison");
		robot.setDiffDogOptions(new RadioOption(" Find mapping by name and type"),
				new CheckboxOption("Ignore case when mapping by name", false),
				new CheckboxOption("Exact match when mapping by name", false)
		);
		robot.okButton();
		robot.contextMenu("Unmap items");
		robot.dragDropSchema(ANIMALS_LEFT, ANIMALS_RIGHT);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	
	@Test
	public void testMapColumnsAutomaticallyMappingTables(){
		
		robot.openComparisonFile(ZOO_CASESENSE_TABLES);
		robot.openDiffDogOptions("Database comparison");
		robot.setDiffDogOptions(
				new CheckboxOption("Ignore case when mapping by name", false),
				new CheckboxOption("Exact match when mapping by name", false)
		);
		robot.okButton();
		robot.leftClickOnIcon(robot.OPEN_LEFT_SCHEMA_ICON,null);
		delay(200);
		robot.leftClickOnIcon(SOURCE_GRAY, "SysTabControl32");
		delay(200);
		robot.keyType(VK_RIGHT);
		delay(200);
		robot.keyType(VK_RIGHT);
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	@Test
	public void testFileTypesBinaryAndWordComparison(){
		robot.compare2Directories(WORDDIRDIFF1, WORDDIRDIFF2);
		robot.openDiffDogOptions("File types");
		robot.leftClickOnIcon(DOT_DOC, "File types");
		robot.setDiffDogOptions(
				new RadioOption("Binary comparison"));
		robot.okButton();
		//robot.scrollDiffDogPane(RIGHT_SIDE, "Afx:00400000:88", 1.0);
		robot.setCursorAtEnd(RIGHT_SIDE);
		robot.keyType(VK_UP);
		robot.keyType(VK_UP);
		robot.doubleClickOnIcon(TEXT_WHITESPACE);
		robot.escapeDialog("Binary comparison:", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testFileTypesBinaryAndWordComparison2(){
		robot.compare2Directories(WORDDIRDIFF1, WORDDIRDIFF2);
		robot.openDiffDogOptions("File types");
		robot.leftClickOnIcon(DOT_DOC, "File types");
		robot.setDiffDogOptions(
				new RadioOption("Microsoft Word comparison"));
		robot.okButton();
		//robot.scrollDiffDogPane(RIGHT_SIDE, "Afx:00400000:88", 1.0);
		robot.setCursorAtEnd(RIGHT_SIDE);
		robot.keyType(VK_UP);
		robot.keyType(VK_UP);
		robot.doubleClickOnIcon(TEXT_WHITESPACE);
		robot.escapeDialog("Do you want to open Word comparison?", VK_Y);
		delay(10000);
		robot.escapeDialog("Convert File", VK_ENTER);
		delay(10000);
		robot.escapeDialog("Convert File", VK_ENTER);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testFileTypesBinaryZIPWordComparison(){
		robot.compare2Directories(WORDDIRDIFF1, WORDDIRDIFF2);
		robot.openDiffDogOptions("File types");
		robot.leftClickOnIcon(DOT_DOCX, "File types");
		robot.setDiffDogOptions(
				new RadioOption("ZIP conformant file"));
		robot.okButton();
		//robot.scrollDiffDogPane(RIGHT_SIDE, "Afx:00400000:88", 1.0);
		robot.setCursorAtEnd(RIGHT_SIDE);
		robot.keyType(VK_UP);
		robot.keyType(VK_UP);
		
		robot.doubleClickOnIcon(CHART);
		robot.escapeDialog("Do you want to open directory comparison", VK_N);
		delay(2000);
		robot.escapeDialog("Binary comparison:", VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testFileTypesBinaryZIPWordComparison2(){
		robot.compare2Directories(WORDDIRDIFF1, WORDDIRDIFF2);
		robot.openDiffDogOptions("File types");
		robot.leftClickOnIcon(DOT_DOCX, "File types");
		robot.setDiffDogOptions(
				new RadioOption("Microsoft Word comparison"));
		robot.okButton();
		//robot.scrollDiffDogPane(RIGHT_SIDE, "Afx:00400000:88", 1.0);
		robot.setCursorAtEnd(RIGHT_SIDE);
		robot.keyType(VK_UP);
		robot.keyType(VK_UP);
		robot.doubleClickOnIcon(CHART);
		delay(1000);
		robot.escapeDialog("Do you want to open Word comparison?", VK_Y);
		delay(10000);
		robot.escapeDialog("Convert File", VK_ENTER);
		delay(10000);
		robot.escapeDialog("Convert File", VK_ENTER);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testFileTypesBinaryXMLConformantFile(){
		robot.openDiffDogOptions("File types");
		Rectangle rect = robot.findComponent("File types", "Button", null);
		robot.scrollWindow(rect, 1.0);
		robot.leftClickOnIcon(DOT_XML, "File types");
		robot.setDiffDogOptions(
				new RadioOption("Textual comparison only"));
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	@Test
	public void testUseSyntaxColoring(){
		robot.openDiffDogOptions("File types");
		//robot.leftClickOnIcon(DOT_ASP, "File types");
		Rectangle rect = robot.findComponent("Use syntax coloring", "Button", null);
		robot.leftClickMid(rect);
		delay(1000);
		assertAreas(DIFF_DOG_UP_WINDOW);
		robot.keyType(VK_ESCAPE);
		delay(200);
		robot.cancelButton();
	}
	
	@Test
	public void testEditFileTypeList(){
		robot.openDiffDogOptions("File types");
		//robot.leftClickOnIcon(DOT_ASP, "File types");
		Rectangle rect = robot.findComponent("Edit file type list", "Button", null);
		robot.leftClick(rect.x +20,rect.y+20);
		delay(10000);
		robot.typeStringEnter(".test");
		robot.leftClick(rect.x -20 + rect.width,rect.y-20+ rect.height);
		delay(10000);
		assertAreas(DIFF_DOG_UP_WINDOW);
		robot.cancelButton();
	}
	
	//DirectoryComparison
	
	@Test
	public void testDirectoryFiltersCopyPasteDelete(){
		robot.openDiffDogOptions("Directory comparison");
		robot.leftClickOnIcon(COPY_FILTER, "File/Directory filters");
		robot.leftClickOnIcon(PASTE_FILTER, "File/Directory filters");
		robot.leftClickOnIcon(COPY_FILTER, "File/Directory filters");
		robot.leftClickOnIcon(PASTE_FILTER, "File/Directory filters");
		robot.leftClickOnIcon(DELETE_FILTER, "File/Directory filters");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
		
	}
	
	@Test
	public void testDirectoryFiltersMoveUpMoveDown(){
		robot.openDiffDogOptions("Directory comparison");
		robot.leftClickOnIcon(MOVE_DOWN_FILTER, "File/Directory filters");
		robot.leftClickOnIcon(MOVE_DOWN_FILTER, "File/Directory filters");
		robot.leftClickOnIcon(MOVE_UP_FILTER, "File/Directory filters");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
		
	}
	
	@Test
	public void testDirectoryFiltersTextFiles(){
		robot.openDiffDogOptions("Directory comparison");
		robot.leftClickOnIcon(TEXT_FILES, "File/Directory filters");
		robot.leftClickOnIcon(NEW_FILTER, "File/Directory filters");
		robot.typeString("Only BAKs");
		robot.keyType(VK_TAB);
		robot.typeString(".bak");
		robot.setDiffDogOptions(new CheckboxOption("System",true),
				new CheckboxOption("Hidden",true));
		robot.setDiffDogOptions(new CheckboxOption("From",true));
		delay(300);
		robot.okButton();
		delay(300);
		robot.okButton();
		delay(300);
		robot.leftClickMenuItem("File", "Compare Directories");
		delay(3000);
		robot.leftClickOnIcon(NO_FILE_DIRECOTRY_FILTER, "Directory content");
		robot.typeString("O");
		assertAreas(DIFF_DOG_UP_WINDOW);
		robot.keyType(VK_ESCAPE);
		robot.leftClickMenuBar("Help");
	}
	
	
	
}
