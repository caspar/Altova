package com.altova.diffdog;

import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.*;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.*;

import com.altova.nativegui.NativeGUI;
import com.altova.robots.AltovaApplicationRobot;
//import com.altova.robots.ApplicationRobot;
import com.altova.robots.CheckboxOption;
import com.altova.robots.ImageNotFoundException;
import com.altova.robots.RadioOption;
import com.altova.robots.ScriptMistakeException;
//import com.altova.robots.TextFieldOption;
import com.altova.util.IOUtils;
import com.altova.util.Settings.AltovaApplication;
import com.altova.robots.Option;
import com.altova.robots.Options;
//import com.sun.org.apache.regexp.internal.recompile;



/**
 * Robot class specifically for DiffDog.
 * 
 * @author Krzysztof Borowski
 *
 */
public class DiffDogRobot extends AltovaApplicationRobot {

	//private static final String BASEPATH = "diffdog/";
	protected final String WORD_COMPARE_TAG = IOUtils.findFileDiffDog("tags_list/","WordCompare.png").getAbsolutePath();
	
	protected final String FILE_COMPARE_ICON = IOUtils.findFileDiffDog("res/","FILE_COMP_ICO.png").getAbsolutePath();
	protected final String FILE_COMPARE_SMAL_ICON = IOUtils.findFileDiffDog("res/","FILE_COMP_SMALL_ICO.png").getAbsolutePath();
	protected final String APPLY_ICON = IOUtils.findFileDiffDog("res/","APPLY_ICO.png").getAbsolutePath();
	protected final String RELOAD_ICON = IOUtils.findFileDiffDog("res/","RELOAD_ICO.png").getAbsolutePath();
	
	protected final String OPEN_ICON = IOUtils.findFileDiffDog("res/","OPEN_ICO.png").getAbsolutePath();
	protected final String SAVEAS_ICON = IOUtils.findFileDiffDog("res/","SAVEAS_ICO.png").getAbsolutePath();
	protected final String WRAP_ICON = IOUtils.findFileDiffDog("res/","WRAP_ICO.png").getAbsolutePath();
	protected final String WRAPDIS_ICON = IOUtils.findFileDiffDog("res/","WRAPDIS_ICO.png").getAbsolutePath();
	protected final String START_COMPARISON_ICON = IOUtils.findFileDiffDog("res/","START_COMPARISON_ICO.png").getAbsolutePath();
	protected final String NEXTDIFF_ICON = IOUtils.findFileDiffDog("res/","NEXTDIFF_ICO.png").getAbsolutePath();
	protected final String FIRSTDIFF_ICON = IOUtils.findFileDiffDog("res/","FIRSTDIFF_ICO.png").getAbsolutePath();
	protected final String PREVDIFF_ICON = IOUtils.findFileDiffDog("res/","PREVDIFF_ICO.png").getAbsolutePath();
	protected final String LASTDIFF_ICON = IOUtils.findFileDiffDog("res/","LASTDIFF_ICO.png").getAbsolutePath();
	protected final String CUR_DIFF_ICON = IOUtils.findFileDiffDog("res/","CUR_DIFF_ICO.png").getAbsolutePath();
	protected final String MAKE_CUR_DIFF_ICON = IOUtils.findFileDiffDog("res/","MAKE_CURRENT_DIFF.png").getAbsolutePath();
	protected final String COPY_LEFT_ICON = IOUtils.findFileDiffDog("res/","COPY_FROM_LEFT_ICO.png").getAbsolutePath();
	protected final String COPY_RIGHT_ICON = IOUtils.findFileDiffDog("res/","COPY_FROM_RIGHT_ICO.png").getAbsolutePath();
	protected final String FULLY_EXPAND_ICON = IOUtils.findFileDiffDog("res/","FULLY_EXPAND_ICO.png").getAbsolutePath();
	protected final String COLLAPSE_ALL_ICON = IOUtils.findFileDiffDog("res/","COLLAPSE_ALL_ICO.png").getAbsolutePath();
	protected final String TABLE_DISP_ICON = IOUtils.findFileDiffDog("res/","TABLE_DISP_ICO.png").getAbsolutePath();
	protected final String COPY_ICON = IOUtils.findFileDiffDog("res/","COPY_ICO.png").getAbsolutePath();
	protected final String PASTE_ICON = IOUtils.findFileDiffDog("res/","PASTE_ICO.png").getAbsolutePath();
	protected final String FORRMSYM_DIS_ICON = IOUtils.findFileDiffDog("res/","FORRMSYM_DIS_ICO.png").getAbsolutePath();
	protected final String FORRMSYM_ENA_ICON = IOUtils.findFileDiffDog("res/","FORRMSYM_ENA_ICO.png").getAbsolutePath();
	protected final String PRITY_PRINT_ICON = IOUtils.findFileDiffDog("res/","PRITTYPRITN_ICO.png").getAbsolutePath();
	protected final String NEW_DATA_COMPARISON_ICON = IOUtils.findFileDiffDog("res/","NewDataComparison.png").getAbsolutePath();
	
	protected final File EQUAL_OFF = IOUtils.findFileDiffDog("res/","EQUAL_OFF.png");
	protected final File EQUAL_ON = IOUtils.findFileDiffDog("res/","EQUAL_ON.png");
	protected final File LEFT_NEWER_OFF = IOUtils.findFileDiffDog("res/","LEFT_NEWER_OFF.png");
	protected final File LEFT_NEWER_ON = IOUtils.findFileDiffDog("res/","LEFT_NEWER_ON.png");
	protected final File RIGHT_NEWER_OFF = IOUtils.findFileDiffDog("res/","RIGHT_NEWER_OFF.png");
	protected final File RIGHT_NEWER_ON = IOUtils.findFileDiffDog("res/","RIGHT_NEWER_ON.png");
	protected final File LEFT_ONLY_OFF = IOUtils.findFileDiffDog("res/","LEFT_ONLY_OFF.png");
	protected final File LEFT_ONLY_ON = IOUtils.findFileDiffDog("res/","LEFT_ONLY_ON.png");
	protected final File RIGHT_ONLY_OFF = IOUtils.findFileDiffDog("res/","RIGHT_ONLY_OFF.png");
	protected final File RIGHT_ONLY_ON = IOUtils.findFileDiffDog("res/","RIGHT_ONLY_ON.png");
	protected final File NOT_COMPARABLE_OFF = IOUtils.findFileDiffDog("res/","NOT_COMPARABLE_OFF.png");
	protected final File NOT_COMPARABLE_ON = IOUtils.findFileDiffDog("res/","NOT_COMPARABLE_ON.png");
	protected final File SUBDIRECTORIES_OFF = IOUtils.findFileDiffDog("res/","SUBDIRECTORIES_OFF.png");
	protected final File SUBDIRECTORIES_ON = IOUtils.findFileDiffDog("res/","SUBDIRECTORIES_ON.png");
	protected final File EMPTYDIR_OFF = IOUtils.findFileDiffDog("res/","EMPTYDIR_OFF.png");
	protected final File EMPTYDIR_ON = IOUtils.findFileDiffDog("res/","EMPTYDIR_ON.png");
	
	protected final File REMOVE_ALL_BOOKMARKS = IOUtils.findFileDiffDog("res/","REMOVE_ALL_BOOK.png");
	
	protected final File ZIP_OFF = IOUtils.findFileDiffDog("res/","ZIP_OFF.png");
	protected final File ZIP_ON = IOUtils.findFileDiffDog("res/","ZIP_ON.png");
	
	protected final File QUICK_COMP_ON = IOUtils.findFileDiffDog("res/","QUICK_COMP_ON.png");
	protected final File QUICK_COMP_OFF = IOUtils.findFileDiffDog("res/","QUICK_COMP_OFF.png");
	
	protected final File AUTOCOMP_ON = IOUtils.findFileDiffDog("res/","AUTOCOMP_ON.png");
	protected final File AUTOCOMP_OFF = IOUtils.findFileDiffDog("res/","AUTOCOMP_OFF.png");
	
	protected final String OPEN_LEFT_SCHEMA_ICON = IOUtils.findFileDiffDog("res/","OPEN_LEFT_SCHEMA_ICO.png").getAbsolutePath();
	protected final String OPEN_RIGHT_SCHEMA_ICON = IOUtils.findFileDiffDog("res/","OPEN_RIGHT_SCHEMA_ICO.png").getAbsolutePath();
	protected final String CONFIG_WIZARD_ICON = IOUtils.findFileDiffDog("res/","CONFIG_WIZARD_ICO.png").getAbsolutePath();
	protected final String ADD_GROUP_ICON = IOUtils.findFileDiffDog("res/","ADD_GROUP.png").getAbsolutePath();
	protected final String ADD_ATTR_ICON = IOUtils.findFileDiffDog("res/","ADD_GROUP.png").getAbsolutePath();
	
	protected final String CHECK_ICO = IOUtils.findFileDiffDog("res/","CHECK_ICO.png").getAbsolutePath();
	protected final String DELETE_ICO = IOUtils.findFileDiffDog("res/","DELETE_ICO.png").getAbsolutePath();
	protected final File CHECKED_ICO = IOUtils.findFileDiffDog("res/","CHECKED_ICO.png");
	protected final File UNCHECKED_ICO = IOUtils.findFileDiffDog("res/","UNCHECKED_ICO.png");

	protected final String ELE_CHECKED = IOUtils.findFileDiffDog("res/","ELE_CHECKED.png").getAbsolutePath();
	protected final String ELE_UNCHECKED = IOUtils.findFileDiffDog("res/","ELE_UNCHECKED.png").getAbsolutePath();
	protected final String ATT_CHECKED = IOUtils.findFileDiffDog("res/","ATT_CHECKED.png").getAbsolutePath();
	protected final String ATT_UNCHECKED = IOUtils.findFileDiffDog("res/","ATT_UNCHECKED.png").getAbsolutePath();
	
	protected final File TXT_TOGGLE_ON = IOUtils.findFileDiffDog("res/","TXT_TOOGLE_ON.png");
	protected final File TXT_TOGGLE_OFF = IOUtils.findFileDiffDog("res/","TXT_TOOGLE_OFF.png");
	protected final File NAT_TOGGLE_ON = IOUtils.findFileDiffDog("res/","NAT_TOOGLE_ON.png");
	protected final File NAT_TOGGLE_OFF = IOUtils.findFileDiffDog("res/","NAT_TOOGLE_OFF.png");
	protected final File XML_TOGGLE_ON = IOUtils.findFileDiffDog("res/","XML_TOOGLE_ON.png");
	protected final File XML_TOGGLE_OFF = IOUtils.findFileDiffDog("res/","XML_TOOGLE_OFF.png");
	
	protected final File EQAUL_ROW_ON = IOUtils.findFileDiffDog("res/ResultToolbar/","EQAUL_ROW_ON.png");
	protected final File EQAUL_ROW_OFF = IOUtils.findFileDiffDog("res/ResultToolbar/","EQAUL_ROW_OFF.png");
	
	protected final File DIFFERENT_ROWS_ON = IOUtils.findFileDiffDog("res/ResultToolbar/","DIFFERENT_ROWS_ON.png");
	protected final File DIFFERENT_ROWS_OFF = IOUtils.findFileDiffDog("res/ResultToolbar/","DIFFERENT_ROWS_OFF.png");
	
	protected final File ROWS_ONLY_LEFT_ON = IOUtils.findFileDiffDog("res/ResultToolbar/","ROWS_ONLY_LEFT_ON.png");
	protected final File ROWS_ONLY_LEFT_OFF = IOUtils.findFileDiffDog("res/ResultToolbar/","ROWS_ONLY_LEFT_OFF.png");
	
	protected final File ROWS_ONLY_RIGHT_ON = IOUtils.findFileDiffDog("res/ResultToolbar/","ROWS_ONLY_RIGHT_ON.png");
	protected final File ROWS_ONLY_RIGHT_OFF = IOUtils.findFileDiffDog("res/ResultToolbar/","ROWS_ONLY_RIGHT_OFF.png");
	
	protected final File CAN_MERGED_LEFT_RIGHT_ON = IOUtils.findFileDiffDog("res/ResultToolbar/","CAN_MERGED_LEFT_RIGHT_ON.png");
	protected final File CAN_MERGED_LEFT_RIGHT_OFF = IOUtils.findFileDiffDog("res/ResultToolbar/","CAN_MERGED_LEFT_RIGHT_OFF.png");

	protected final File CAN_MERGED_RIGHT_LEFT_ON = IOUtils.findFileDiffDog("res/ResultToolbar/","CAN_MERGED_RIGHT_LEFT_ON.png");
	protected final File CAN_MERGED_RIGHT_LEFT_OFF = IOUtils.findFileDiffDog("res/ResultToolbar/","CAN_MERGED_RIGHT_LEFT_OFF.png");
	
	protected final File COLUMNS_NO_DIFFERENTS_ON = IOUtils.findFileDiffDog("res/ResultToolbar/","COLUMNS_NO_DIFFERENTS_ON.png");
	protected final File COLUMNS_NO_DIFFERENTS_OFF = IOUtils.findFileDiffDog("res/ResultToolbar/","COLUMNS_NO_DIFFERENTS_ON.png");
	
	protected final String EXPANDFILTR = IOUtils.findFileDiffDog("res/","EXPAND_FILR.png").toString();
	
	protected static final File DOTS = IOUtils.findFileDiffDog("tags_list/","dot3.PNG");
	protected static final String DELETE_FILTR = IOUtils.findFileDiffDog("res/","DELETE_FILTR.png").toString();
	
	protected final String DefaultColor = IOUtils.findFileDiffDog("tags_list/","DefaultColors.png").getAbsolutePath();
	
	
	final String CORNER = IOUtils.findFileDiffDog("tags_list/","Corner.png").getAbsolutePath();
	protected final File SOURCE_ICO = IOUtils.findFileDiffDog("res/","Source_ICO.png");
	
	private final static String[] toolbarIds = { };
	
	
	private final static String destFile ="C:\\temp\\debug\\";
	private final static String destFileRight ="C:\\temp\\debug\\";
	
	public final static boolean leftSide = true;
	public final static boolean rightSide = false; 

	
	public DiffDogRobot() {
		super("Altova DiffDog", AltovaApplication.DIFFDOG, "DiffDog", "", toolbarIds);
		logger.fine("Created robot "+getClass().getName());
	}

	public void newCompareWindow(){
		leftClickMenuItem("File","Compare Files");
	}
	
	
	@Override
	public void exitApplication() {
		exitWithuotSave();
	}
	
	public void exitWithuotSave() {
		logger.fine("Exit without save");
		leftClickMenuItem("File", "Exit  ");delay(1000);
		delay(2000);
		boolean a = escapeDialog("Save files", VK_0);
		if(a){
			Rectangle hint = findComponent("Discard changes", "Button", null);
			leftClickMid(hint);
		}
		escapeDialog("Save changes", VK_N);
		delay(1000);

	}

	public void setCompareType(String compartype) {
		leftClickMenuItem("File",compartype);
	}

	public void openCompareFilesWindow(){
		leftClickMenuItem("File",null, "Compare Files");
	}
	public void openCompareDirectoriesWindow(){
		leftClickMenuItem("File",null, "Compare Directories");
	}
	public void openCompareXMLSchemasWindow(){
		leftClickMenuItem("File",null, "Compare XML Schemas");
	}
	public void openCompareMSwordWindow(){
		leftClickMenuItem("File",null, "Compare MS-Word files");
	}
	public void openCompareDatabaseDataWindow(){
		leftClickMenuItem("File",null, "Compare Database Data");
	}
	public void openCompareDatabaseSchemasWindow(){
		leftClickMenuItem("File",null, "Compare Database Schemas");
	}
	public void openComparisonDialog(){
		leftClickMenuItem("File",null, "Open...");
	}
	public void openComparisonDialog(String firstPath, String secondPath, Option... options){
		openComparisonDialog(firstPath,secondPath,null,options);
	}
	public void openComparisonDialog(String firstPath, String secondPath,String filtr, Option... options){
		leftClickMenuItem("File",null, "Open...");
		setDiffDogOptions(options);
		Rectangle rect = findString("Content",MS_SHELL_DLG_FONT);
		leftClick(rect.x + 140, rect.y + 15);
		delay(500);
		typeString(firstPath);
		delay(100);
		keyType(VK_TAB);
		delay(100);
		keyType(VK_TAB);
		typeString(secondPath);
		if (filtr != null){
			delay(100);
			keyType(VK_TAB);
			typeString(filtr);
		}
		okButton();
		//typeStringEnter(secondPath);
		escapeDialog("No differences found!", VK_ESCAPE);
	}
	
	public void openComparisonFile(String file){
		leftClickMenuItem("File",null, "Open Comparison File...");
		Rectangle hint = findComponentClass("Edit");
		leftClickMid(hint);
		delay(2000);
		typeStringEnter(file);
		delay(3000);
		escapeDialog("Save As", VK_Y);
		escapeDialog("No differences found", VK_ESCAPE);
	}
	
	public void openComparisonFileURL(String file, String user, String password){
		leftClickMenuItem("File",null, "Open Comparison File...");
		try{
			//Rectangle rec = findComponent("Switch to &URL", "Button", null);
			leftClickMid(findComponent("Switch to &URL", "Button", null));
		} catch (ImageNotFoundException e){
			leftClickMid(findComponent("Switch to File Dialog", "Button", null));
			leftClickMid(findComponent("Switch to URL", "Button", null));
		}
		
		typeStringEnter(file);
		delay(3000);
		escapeDialog("Save As", VK_Y);
		escapeDialog("No differences found", VK_ESCAPE);
	}
	
	public void openComparisonFile(File file){
		openComparisonFile(file.getAbsolutePath());
	}
	public void saveComparisonFile(String fileName){
		saveAs(fileName);
	}
	
	
	public void compareXMLSchemass(String left,String leftRoot, String right,String rightRoot){
		leftClickMenuItem("File","Compare XML Schemas");
		delay(500);
		openSchema(true, left,leftRoot);
		openSchema(false, right,rightRoot);
	}
	
	public void compareXMLSchemassURL(String left,String leftRoot, String right,String rightRoot){
		leftClickMenuItem("File","Compare XML Schemas");
		delay(500);
		openSchemaURL(true, left,leftRoot);
		openSchemaURL(false, right,rightRoot);
	}
	
	
	
	public void compareXMLSchemass(File left,String leftRoot, File right,String rightRoot){
		leftClickMenuItem("File","Compare XML Schemas");
		delay(500);
		openSchema(true, left,leftRoot);
		openSchema(false, right,rightRoot);
	}
	public void select2Rectangles(Rectangle first, Rectangle second){
		leftClickMid(first);
		delay(500);
		keyPress(VK_CONTROL);
		delay(200);
		leftClickMid(second);
		delay(500);
		keyRelease(VK_CONTROL);
	}
	

		

	public void openSchemaURL(boolean side, String file,String rootElement ){
		if (side){
			leftClickImage(OPEN_LEFT_SCHEMA_ICON);
		}
		else{
			leftClickImage(OPEN_RIGHT_SCHEMA_ICON);
		}
		try{
			leftClickMid(findComponent("Switch to &URL", "Button", null));
		} catch (ImageNotFoundException e){
			leftClickMid(findComponent("Switch to File Dialog", "Button", null));
			leftClickMid(findComponent("Switch to &URL", "Button", null));
		}
		delay(1000);
		typeStringEnter(file);
		delay(500);
		selectRootElement(rootElement);
		delay(1000);
	}
	
	public void openSchema(boolean side, String file,String rootElement ){
		if (side){
			leftClickImage(OPEN_LEFT_SCHEMA_ICON);
		}
		else{
			leftClickImage(OPEN_RIGHT_SCHEMA_ICON);
		}
		delay(10000);
		typeStringEnter(file);
		delay(500);
		selectRootElement(rootElement);
		delay(1000);
	}
	
	public void openSchema(boolean side, File file,String rootElement ){
		openSchema(side, file.getAbsolutePath(), rootElement);
	}
	
	public void selectRootElement(String element){
		leftClickMid(findComponent(element, "Button", null));
		okButton();
		//keyPress(VK_ENTER);
	}
	public void MaximizeFileCompareWindow(){
		try{
			leftClickImage(FILE_COMPARE_ICON);
		} catch(ImageNotFoundException e) {
		
		}
		try {
			leftClickMid(findString("Maximize"));
			logger.info("looking for the maximize string");
		} catch(ImageNotFoundException e) {
			keyType(VK_ESCAPE);
		}
		
	}
	public void compareFiles(String leftFilePath, String rightFilePath){
		typeLeftFilePath(leftFilePath);
		typeRightFilePath(rightFilePath);
		leftClickApplyIcon(false);
		escapeDialog("files are different!", VK_ESCAPE);
		escapeDialog("No differences found!", VK_ESCAPE);
		escapeDialog("Files are non-XML!", VK_Y);
	}
	
	public void compareURLFiles(String leftPath, String leftUser,String leftPass,
			String rightPath, String rightUser, String rightPass){
		
		OpenFromURL(leftPath, leftUser, leftPass, leftSide);
		OpenFromURL(rightPath, rightUser, rightPass, rightSide);
		startComparison();
		escapeDialog("No differences found!", VK_ESCAPE);
	}
	public void compareURLDirecotries(String leftPath, String leftUser,String leftPass,
			String rightPath, String rightUser, String rightPass){
			leftClickMenuItem("File", "Compare Directories");
			openDirecotryFromURL(leftPath,leftUser,leftPass,leftSide);
			delay(2000);
			openDirecotryFromURL(rightPath,rightUser,rightPass, rightSide);
			escapeDialog("No differences found!", VK_ESCAPE);
			
	}
	
	public void openDirecotryFromURL(String path, String user, String pass, boolean side){
		leftClickOpenIcon(side);
		try{
			
			//Rectangle rec = findComponent("Switch to &URL", "Button", null);
			leftClickMid(findComponent("Switch to URL", "Button", null));
		} catch (ImageNotFoundException e){
			leftClickMid(findComponent("Switch to File Dialog", "Button", null));
			leftClickMid(findComponent("Switch to URL", "Button", null));
		}
		
		typeString(user);
		keyPress(VK_TAB);
		delay(200);
		typeString(pass);
		delay(200);
		keyPress(VK_TAB);
		delay(200);
		keyPress(VK_TAB);
		typeString(path);
		delay(2000);
		keyPress(VK_TAB);
		delay(2000);
		keyType(VK_SPACE);
		delay(2000);
		keyType(VK_DOWN);
		delay(2000);
		keyPress(VK_ENTER);
	}
	public void OpenFromURL(String path, String user, String pass, boolean side){
		leftClickOpenIcon(side);
		try{
			
			//Rectangle rec = findComponent("Switch to &URL", "Button", null);
			leftClickMid(findComponent("Switch to &URL", "Button", null));
			
		} catch (ImageNotFoundException e){
			leftClickMid(findComponent("Switch to &File Dialog", "Button", null));
			leftClickMid(findComponent("Switch to &URL", "Button", null));
		}
		typeString(path);
		delay(200);
		keyPress(VK_TAB);
		delay(200);
		keyPress(VK_TAB);
		typeString(user);
		keyPress(VK_TAB);
		delay(200);
		typeString(pass);
		keyPress(VK_ENTER);
	}
	

	public void compareFiles(File leftFile, File rightFile){
		compareFiles(leftFile.getAbsolutePath(), rightFile.getAbsolutePath());
	}
	public void typeLeftFilePath(String leftFilePath){
		Rectangle rec = findComponentName("Toolbar first document");
		leftClick(new Point(rec.x - 15, rec.y));
		delay(2000);
		typeString(leftFilePath);
		delay(2000);
	}
	public void typeRightFilePath(String rightFilePath){
	Rectangle rec = findComponentName("Toolbar second document");
	leftClick(new Point(rec.x - 15, rec.y));
	delay(2000);
	typeString(rightFilePath);
	delay(2000);
}
	
	public void openLeftFile(String leftFilePath){
		Rectangle rec = findComponentName("Toolbar first document");
		leftClick(new Point(rec.x - 15, rec.y));
		delay(1000);
		typeStringEnter(leftFilePath);
	}
	public void openRightFile(String rightFilePath){
	Rectangle rec = findComponentName("Toolbar second document");
	leftClick(new Point(rec.x - 15, rec.y));
	typeStringEnter(rightFilePath);
}
	
	public void typeLeftFilePath(File leftFile){
		typeLeftFilePath(leftFile.getAbsolutePath());
	}
	public void typeRightFile(File rightFile){
		typeRightFilePath(rightFile.getAbsolutePath());
	}
	public void typeFile(boolean side, File file){
		if(side)
			typeLeftFilePath(file);
		else
			typeRightFile(file);
	}
	public void openFile(boolean side, File file){
		openFile(side, file.getAbsolutePath());
	}
	public void openFile(boolean side, String filePath){
		if(side)
			openLeftFile(filePath);
		else
			openRightFile(filePath);
		escapeDialog("Recently Compared Pairs", VK_ESCAPE);
	}
/*	public void openByIcon(boolean side, File file){
		leftClickApplyIcon(side);
	}
	*/
/*	public void openLeftDirectory(String path){
		Rectangle rec = findComponentName("Toolbar first document");
		leftClick(new Point(rec.x - 15, rec.y));
		typeString(path);
	}
	public void openRightDirectory(String path){
		Rectangle rec = findComponentName("Toolbar second document");
		leftClick(new Point(rec.x - 15, rec.y));
		typeString(path);
	}
	*/
	public void compare2Directories(String leftPath, String rightPath){
		openCompareDirectoriesWindow();
		typeLeftFilePath(leftPath);
		typeRightFilePath(rightPath);
		leftClickApplyIcon(false);
		escapeDialog("No differences found!", VK_ESCAPE);
	}
	
	public void setCursorAtEnd(boolean side){
		Rectangle rec = hintSide(side);
		leftClick(new Point(rec.x, rec.y + 40));
		keyTypeCtrl(VK_END);
	}
	public void typeStringBottom(boolean side, String text){
		setCursorAtEnd(side);
		typeString(text);
	}
	public void setCursorAtBeginning(boolean side){
		Rectangle rec = hintSide(side);
		leftClick(new Point(rec.x, rec.y + 100));
		keyTypeCtrl(VK_HOME);
	}
	public void goToLine(boolean side, String lineNumber, String charNumber){
		setCursorAtBeginning(side);
		leftClickMenuItem("View", "Go to line/char");
		typeString(lineNumber);
		keyPress(VK_TAB);
		typeString(charNumber);
		delay(500);
		keyPress(VK_ENTER);
	}
	
	
	public void find(boolean side, String word, String... menuitems){
		setCursorAtBeginning(side);
		leftClickMenuItem("Edit",menuitems);
		deleteEditBox();
		typeStringEnter(word);
		boolean notFound = false;
		notFound |= escapeDialog("Finished searching the document", VK_ENTER );
		notFound |= escapeDialog("Reached the end of file", VK_ENTER);
		notFound |= escapeDialog("Cannot find the string", VK_ENTER);
		
		if(notFound) {
			logger.warning("The string "+word+" was not found.");
		}
		
		//if the Find dialog remains on screen, close it
		escapeDialog("Find", VK_ESCAPE);
	}
	
	public void saveFile(boolean side){
		leftClickMenuItem("File", "Save");
		leftClickMid(findComponent("Save selected", "Button", null));
		escapeDialog("Save file", VK_ENTER);
		escapeDialog("Save As", VK_ENTER);
	}
	
	public File saveAs(boolean side, String pathname){
		Rectangle hint = hintSide(side);
		leftClickMid(findImage(SAVEAS_ICON, hint, false));
		delay(1000);
		typeStringEnter(pathname);
		escapeDialog("Confirm Save As", VK_Y);
		try{
			File tmp = IOUtils.findFile(pathname); 
			return tmp;
		} catch (ScriptMistakeException e){
			return null;
		}
		
	}
	
	public File saveAs(String pathname){
		//First trying to create a file
		try{
		File temp = new File(pathname);
		temp.createNewFile();
		}
		catch(IOException e){
			
		}
		leftClickMenuItem("File", "Save As...");
		typeStringEnter(pathname);
		escapeDialog("Confirm Save As", VK_Y);
		escapeDialog("Save As", VK_Y);
		try{
			File tmp = IOUtils.findFile(pathname); 
			return tmp;
		} catch (ScriptMistakeException e){
			return null;
		}
		
	}
	
	public void find(boolean side, String word){
		find(side, word,"Find");
	}
	public void replace(boolean side, String what, String replaceWord ){
		replace(side, what, replaceWord, false,false,false,false,true);
	}
	public void replace(boolean side, String what, String replaceWord,
			boolean matchWholeWord, boolean matchCase, boolean regularExp,
			boolean replaceInSectionOnly,boolean replaceAllButton ){

		leftClickMenuItem("Edit", "Replace");
		if (what != null)
			typeString(what);
		keyPress(VK_TAB);
		if (replaceWord != null)
			typeString(replaceWord);
		
		Options options = new Options();
		options.add(new CheckboxOption("Match case", matchCase));
		options.add(new CheckboxOption("Regular expression", regularExp));
		options.add(new CheckboxOption("Replace in selection only", replaceInSectionOnly));
		options.applyOption(this);
		
		try {
			Options options1 = new Options();
			options1.add(new CheckboxOption("Match whole word only", matchWholeWord));
			options1.applyOption(this);
		} catch (ImageNotFoundException e) {
			logger.info("Make path relative to checkbox is not enabled");
		}

		if (replaceAllButton){
			leftClickMid(findComponent("Replace &All", "Button", null));
			escapeDialog("Replaced", VK_ESCAPE);
			leftClickMid(findComponent("Close", "Button", null));
		}
		leftClickMid(findComponent("Close", "Button", null));
	}
/**
 *  
 * @param side
 * @param what - Find what
 * @param replaceWord - Replace with
 * @param button - name of the button
 * @param options
 */
	public void replaceDialog(String what, String replaceWord,
			String button,Option... options ){
			if (what != null)
				typeString(what);
			
			if (replaceWord != null){
				keyPress(VK_TAB);
				typeString(replaceWord);
			}
				
			if (options != null)
				setDiffDogOptions(options);

			if (button != null){
				leftClickMid(findComponent(button, "Button", null));
			}
	}
		
	public void cancelButton(){
		leftClickMid(findComponent("Cancel", "Button", null));
	}
	public void okButton(){
		leftClickMid(findComponent("OK", "Button", null));
	}
	public void button(String name){
		leftClickMid(findComponent(name, "Button", null));
	}
	public void typeAfterFoundString(boolean side, String Searchword, String word){
		setCursorAfterFoundString(side,Searchword);
		typeString(word);
	}
	public void setCursorAfterFoundString(boolean side, String Searchword){
		find(side,Searchword);
		keyPress(VK_RIGHT);
	}
	
	public void deleteAllXMLFilters(){
		openComparisionOptions("XML");
		leftClickOnIcon(DOTS.getAbsolutePath(), "Ignore node types");
		delay(2000);

		try{
			
		while(true){
			leftClickOnIcon(DELETE_FILTR, null);	
		}
		}catch (ImageNotFoundException e){}
		finally{
			okButton();
			delay(300);
			okButton();
		}
		
	}
	
	public void leftClickApplyIcon(boolean side){
		if (side){
			leftClickMid(findImage(APPLY_ICON, hintSide(side), false));
		}
		else{
			leftClickMid(findImage(APPLY_ICON, hintSide(side), false));
		}
	}
	
	public void leftClickOpenIcon(boolean side){
		if (side){
			leftClickMid(findImage(OPEN_ICON, hintSide(side), false));
		}
		else{
			leftClickMid(findImage(OPEN_ICON, hintSide(side), false));
		}
	}	
	public void reload(boolean side){
		if (side){
			leftClickMid(findImage(RELOAD_ICON, hintSide(side), false));
		}
		else{
			leftClickMid(findImage(RELOAD_ICON, hintSide(side), false));
		}
	}	
	protected Rectangle hintSide(boolean side){
		if (side)
			return findComponentName("Toolbar first document");
		else
			return findComponentName("Toolbar second document");

	}
	public void scrollDiffDogPane(boolean side,String className, double position){
		Rectangle rect = hintSide(side);
		rect.y = rect.y + 30;
		rect.width = rect.width + 120;
		if(className != null){
			Rectangle hint = findComponent(null, className, rect);
			scrollWindow(hint, position);
		}
		else{
			scrollWindow(rect, position);
		}
		
	}
	
	public void leftClickOnIcon(String iconPath, String ComponentName){
		
		if (ComponentName == null)
			leftClickImage(iconPath);
		else{
			Rectangle hint = findImage(iconPath, findComponentName(ComponentName), true);
			leftClickMid(hint);			
		}

		
	}
	public void rightClickOnIcon(String iconPath){
		
		Rectangle hint = findImage(iconPath);
		rightClickMid(hint);
	}
	public void doubleClickOnIcon(String iconPath){
		Rectangle hint = findImage(iconPath, null, false);
		doubleClickMid(hint);
	}

	public void leftClickOnString(String string){
		leftClickString(string);
	}
	
	public void enableWordWrap(){
		try{
			findImage(WRAP_ICON);
		}catch (ImageNotFoundException e){
			logger.fine("Word Wrap was disabled. Now trying  to enable it");
			leftClickMid(findImage(WRAPDIS_ICON,findComponentName("Text"), false));
		
		}
	}
	
	// There is some many functions regarding to TextView Settings because of performance
	public void setTextViewMarginSettings(boolean lineNumberMargin, boolean bookmarkMargin,
			boolean foldingMargig){
		
		leftClickMenuItem("Text View", "TextView Settings");
		
		Options options = new Options();
		options.add(new CheckboxOption("Line number margin", lineNumberMargin));
		options.add(new CheckboxOption("Bookmark margin", bookmarkMargin));
		options.add(new CheckboxOption("Folding margin",foldingMargig ));
		options.applyOption(this);

		keyPress(VK_ENTER);
	}
	public void setDefaultTextViewMarginSettings(){
		setTextViewMarginSettings(true, true, true);
	}
	public void setTextViewVisualAidSettings(boolean indentationGuides, boolean endOfLineMarkers,
			boolean whitespaceMarkers){
		
		leftClickMenuItem("Text View", "TextView Settings");
		
		Options options = new Options();
		options.add(new CheckboxOption("Indentation guides", indentationGuides));
		options.add(new CheckboxOption("End of line markers", endOfLineMarkers));
		options.add(new CheckboxOption("Whitespace markers",whitespaceMarkers ));
		options.applyOption(this);

		keyPress(VK_ENTER);
	}
	public void setDefaultTextViewVisualAidSettings(){
		setTextViewVisualAidSettings(true, false, false);
	}
	
	public void setTextViewTabSettings(String radioOption, String tabSize){
		
		leftClickMenuItem("Text View", "TextView Settings");
		
		if (tabSize != null){
			leftClickMid(findComponentClass("Edit"));
			
			keyType(VK_HOME);
			for (int i = 0; i < 10; i++){
				keyType(VK_DELETE);
				delay(10);
			}
			
			typeString(tabSize);
		}
		if (radioOption != null){
			RadioOption c = new RadioOption(radioOption, "Tabs");
			applyOptionsEnter("Text View Settings", c);
		}
		keyPress(VK_ENTER);
	}
	public void setDefaultTextViewTabSettings(){
		setTextViewTabSettings("Insert spaces", "4");
	}
	public void showGridView(){
		Rectangle mWdw=getMainWindow();
		Rectangle wholeScreen=NativeGUI.getForegroundWindowInfo().getLocation();
		Rectangle searchArea=new Rectangle(wholeScreen.x,mWdw.y+mWdw.height,wholeScreen.width,wholeScreen.height-mWdw.y-mWdw.height);
		leftClickMid((findImage((IOUtils.findFileDiffDog("tags_list/","GridView_TAG.PNG").getAbsolutePath()),searchArea, true)));
		delay(2000);
	}
	public void contextMenu(String option){
		Point pt = getCornerPoint();
		rightClick(pt);
		if (option != ""){
			leftClickString(option);	
		}
		
	}
	public void contextMenu(String... options){
		Point pt = getCornerPoint();
		rightClick(pt);
		for(int i=0; i< options.length; i++){
			leftClickString(options[i]);
			delay(1000);
		}
	}

	public void tabsContextMenu(String option, int tabNumber){
		
		if (tabNumber == 3)
			rightClickImage(WORD_COMPARE_TAG);
	leftClickString(option);
	}
	public void contextMenu(String option, Point point){
		rightClick(point);
		if (option != "")
			leftClickString(option);
	}
	public Rectangle findTagsImage(File image){
		return findImage(image.getAbsolutePath());
		
	}
	private Point getCornerPoint(){
		Rectangle rect = findImage(CORNER);
		return new Point(rect.x,rect.y);
	}
	
	public void openWordComparison() throws Exception{
		leftClickMenuItem("File", "Compare MS-Word files");
		delay(15000);
		if(escapeDialog("No compatible version of Microsoft Word is installed", VK_ESCAPE))
			throw new Exception("No compatible version of Microsoft Word is installed");
		escapeDialog("Microsoft Office Activation Wizard", VK_C);
	}
	

	
	public void compareWordDocuments(File leftFile, File rightFile){
		
		compareWordDocuments(leftFile.getAbsolutePath(), rightFile.getAbsolutePath());
	}
public void compareWordDocuments(String leftFile, String rightFile){
		
		try {
			openWordComparison();
		if (rightFile != null){
				typeLeftFilePath(leftFile);
				typeRightFilePath(rightFile);
				leftClickApplyIcon(false);
				delay(8000);
				
			}else
			{
				typeLeftFilePath(leftFile);
				leftClickApplyIcon(true);
			}
			escapeDialog("Convert File", VK_ENTER);
			delay(8000);
			escapeDialog("Convert File", VK_ENTER);
			delay(800);
			escapeDialog("files are different!", VK_ESCAPE);
			escapeDialog("No differences found!", VK_ESCAPE);
		}catch (Exception e) {
		
		} 
	}
	public void openWordDocument(boolean side, File file){
		leftClickMenuItem("File", "Compare MS-Word files");
		openFile(side, file);
	}
	public void startComparison(){
		leftClickOnIcon(START_COMPARISON_ICON, "Diff and Merge");
	}
	public void nextDifference(){
		leftClickOnIcon(NEXTDIFF_ICON, "Diff and Merge");
	}
	public void prefDifference(){
		leftClickOnIcon(PREVDIFF_ICON, "Diff and Merge");
	}
	public void firstDifference(){
		leftClickOnIcon(FIRSTDIFF_ICON, "Diff and Merge");
	}
	public void lastDifference(){
		leftClickOnIcon(LASTDIFF_ICON, "Diff and Merge");
	}
	public void makeCurrentDifference(){
		leftClickOnIcon(MAKE_CUR_DIFF_ICON, "Diff and Merge");
	}
	public void displayCurrentDifference(){
		leftClickOnIcon(CUR_DIFF_ICON, "Diff and Merge");
	}
	public void copyFromLeft(){
		leftClickOnIcon(COPY_LEFT_ICON, "Diff and Merge");
	}
	public void copyFromRight(){
		leftClickOnIcon(COPY_RIGHT_ICON, "Diff and Merge");
	}
	public void fullyExpandAllSelected(){
		leftClickOnIcon(FULLY_EXPAND_ICON, "Grid");
	}
	public void colapseAllSelected(){
		leftClickOnIcon(COLLAPSE_ALL_ICON, "Grid");
	}
	public void displayAsTable(){
		leftClickOnIcon(TABLE_DISP_ICON, "Grid");
	}
	public void copy(){
		leftClickOnIcon(COPY_ICON, "Standard");
	}
	public void paste(){
		leftClickOnIcon(PASTE_ICON, "Standard");
	}
	public void showForrmatingSymbols(){
		leftClickOnIcon(FORRMSYM_ENA_ICON, "Word Comparison");
	}
	
	public void hideForrmatingSymbols(){
			leftClickOnIcon(FORRMSYM_DIS_ICON, "Word Comparison");
	}
	public void setCompareAsTXT(){
		leftClickMenuItem("Diff and Merge", "Textual Comparison Only");
	}
	public void setCompareAsBinary(){
		leftClickMenuItem("Diff and Merge", "Compare as Binary");
	}
	public void setCompareAccordingToFileExtensionSettings(){
		leftClickMenuItem("Diff and Merge", "Compare According to File Extension Settings");
	}
	public void setCompareAsXML(){
		leftClickMenuItem("Diff and Merge", "Compare as XML");
	}
	public void setShowFilesInZip(boolean on){
		setToogle(on, ZIP_ON, ZIP_OFF);
	}
	public void setQuickComparison(boolean on){
		setToogle(on, QUICK_COMP_ON, QUICK_COMP_OFF);
	}
	public void setAutostartComparison(boolean on){
		setToogle(on, AUTOCOMP_ON, AUTOCOMP_OFF);
	}
	
	public void setShowFilesInZip(){
		leftClickMenuItem("Diff and Merge", "Show files in ZIP archives");
	}
	public void setPrityPrint(){
		leftClickOnIcon(PRITY_PRINT_ICON, "Word Comparison");
	}
	public void openInNewDataComparison(){
		leftClickOnIcon(NEW_DATA_COMPARISON_ICON,"Standard");
	}
	
	protected void copyFiles(File srFile,String destFile){
		
		try{
		      File f2 = new File(destFile);
		      InputStream in = new FileInputStream(srFile);
		      
		      OutputStream out = new FileOutputStream(f2);

		      byte[] buf = new byte[1024];
		      int len;
		      while ((len = in.read(buf)) > 0){
		        out.write(buf, 0, len);
		      }
		      in.close();
		      out.close();
		    }
		    catch(FileNotFoundException ex){
		    	logger.fine(ex.getMessage());
		    }
		    catch(IOException e){
		        logger.fine(e.getMessage());
	      }
	}
	
	public void compareDatabaseData(File left, File right){
		
		leftClickMenuItem("File", "Compare Database Data");
		delay(500);
		
		keyType(VK_ESCAPE);
		delay(1500);
		keyType(VK_ESCAPE);
		if(left != null)
			openDatabaseData(true, left);
		if (right!= null)
			openDatabaseData(false, right);
		
	}
	public String getCopiedFilePath(File srcFile){
		
		return destFile+ srcFile.getName();
	}
	
	public void openDatabaseData(boolean side, File file){
		delay(500);
		
		if (side){
			copyFiles(file, getCopiedFilePath(file));
			leftClickImage(OPEN_LEFT_SCHEMA_ICON);
		}
		else{
			copyFiles(file, destFileRight);
			leftClickImage(OPEN_RIGHT_SCHEMA_ICON);
			leftClickImage(CONFIG_WIZARD_ICON);
		}
		
		if (findComponent("Next", "Button", null)==null){
			leftClickImage(CONFIG_WIZARD_ICON);
		}
		leftClickMid(findComponent("Next", "Button", null));
		delay(5000);
		
		Rectangle hint = findString("Browse");
		leftClick(hint.x - 50, hint.y);
		deleteEditBox();
		delay(500);
		typeStringEnter(getCopiedFilePath(file));
		okButton();
		delay(2000);
		escapeDialog("Changing DataSource will clear current selection!", VK_Y);
		delay(2000);
		leftClickMid(findImage(SOURCE_ICO.getAbsolutePath()));
		okButton();
		delay(2000);
		escapeDialog("Changing DataSource will clear current selection!", VK_Y);
		delay(500);
		keyPress(VK_ENTER);
		
	}
	
	private void deleteEditBox(){
		delay(2000);
		keyType(VK_HOME);
		for (int i=0; i< 200; i++)
			keyType(VK_DELETE);

	}
	public void selectDataBaseComparasionCheckbox(boolean side){
		if (side){
			leftClickImage(OPEN_LEFT_SCHEMA_ICON);
		}
		else{
			leftClickImage(OPEN_RIGHT_SCHEMA_ICON);
		}
		setToogle(true,CHECKED_ICO,UNCHECKED_ICO);
		delay(500);
		keyType(VK_ENTER);
	}
	
	public void openComparisionOptions(String tabName){
		leftClickMenuItem("Tools", "Comparison Options...");
		Rectangle winHint = findComponentClass("SysTabControl32");
		Rectangle hint = findString(tabName,MS_SHELL_DLG_FONT,winHint,false);
		leftClickMid(hint);
	}
	
	public void openDiffDogOptions(String tabName){
		leftClickMenuItem("Tools", "DiffDog Options...");
		Rectangle winHint = findComponentClass("SysTabControl32");
		Rectangle hint = findString(tabName,MS_SHELL_DLG_FONT,winHint,false);
		leftClickMid(hint);
	}
	
	public void setDiffDogOptions(Option... options){
		
		Options opt = new Options();
		for (int i = 0; i< options.length ; i++)
			opt.add(options[i]);
		opt.applyOption(this);
	}
	
	public void deleteRegistry(){
        try {
            //Runtime.getRuntime().exec("reg delete \"HKEY_CURRENT_USER\\Software\\Altova\\DiffDog\\Settings\" /F");
        	Runtime.getRuntime().exec("reg delete \"HKEY_CURRENT_USER\\Software\\Altova\\DiffDog\" /F");
            logger.fine("Registry settings deleted");
            }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
	public void deleteFullRegistry(){
        try {
            	Runtime.getRuntime().exec("reg delete \"HKEY_CURRENT_USER\\Software\\Altova\\DiffDog\" /F");
            	logger.fine("Registry settings deleted");
            }
        catch (IOException e) {
            e.printStackTrace();
            
        }
    }
	public void addNewAttributeGroup(String name, String attribute){
		
		if (name != null){
			leftClickOnIcon(ADD_GROUP_ICON, "Attribute groups");
			delay(500);
			typeStringEnter(name);
			delay(2000);
		}
		if (attribute != null){
			leftClickOnIcon(ADD_ATTR_ICON, "Add attributes as comparison criteria");
			delay(500);
			typeStringEnter(attribute);
			rightClickOnIcon(DELETE_ICO);
		}
	}
	public void addNewAttributeGroupFilters(String name, String attribute){
		
		if (name != null){
			leftClickOnIcon(ADD_GROUP_ICON, "Attribute groups");
			delay(500);
			typeStringEnter(name);
		}
		if (attribute != null){
			leftClickOnIcon(ADD_ATTR_ICON, "Ignore elements/attributes");
			delay(500);
			typeStringEnter(attribute);
			rightClickOnIcon(DELETE_ICO);
		}
	}
	
	/**
	 * Select Ele in Define filters window
	 */
	public void selectEle(boolean checked){
		leftClickMid(findComponent("Define filters","Button",null)); 
		switchIcon(checked, ELE_CHECKED, ELE_UNCHECKED);
		
	}
	/**
	 * Select Att in Define filters window
	 */
	public void selectAtt(boolean checked){
		leftClickMid(findComponent("Define filters","Button",null)); 
		switchIcon(checked, ATT_CHECKED, ATT_UNCHECKED);
	}
	private void switchIcon(boolean checked,String pathTrue, String pathFalse){
		if(checked){
			try{
				findImage(pathTrue);
			}
			catch (ImageNotFoundException e){
				leftClickMid(findImage(pathFalse));
			}
		}else{
			try{
				findImage(pathFalse);
			}
			catch (ImageNotFoundException e){
				leftClickMid(findImage(pathTrue));
				delay(10000);
				
			}
		}
	}
	public void deleteFilter(String attribute){
		
		Rectangle hint = findComponentClass("Filters");
		leftClickMid(findString(attribute, DEFAULT_CONTENT_FONT, hint, false));
		leftClickOnIcon(DELETE_ICO,"Define filters");
		
	}

	
	
	public void deleteAttribute(String attribute){
		
		Rectangle hint = findComponentClass("Add attributes as comparison criteria");
		leftClickMid(findString(attribute, hint, false));
		leftClickOnIcon(DELETE_ICO,"Add attributes as comparison criteria");
	}

	public void setDirectoryComparPanel(int equal, int leftNewer, 
			int	rightNewer, int leftOnly, int rightOnly, int notComparable,
			int includeSubdirectories){
		setDirectoryComparPanel(equal,leftNewer,rightNewer,leftOnly, rightOnly,
				notComparable,includeSubdirectories,2);
	}
	
	/**
	 * 	0 - set toogle off
	 *  1 - set toogle on
	 *  2 - don't change
	 */
	public void setDirectoryComparPanel(int equal, int leftNewer, 
			int	rightNewer, int leftOnly, int rightOnly, int notComparable,
			int includeSubdirectories, int hideEmptyDirecotries){
		if (equal != 2)
			if (equal == 1)
				setToogle(true, EQUAL_ON, EQUAL_OFF);
			else
				setToogle(false, EQUAL_ON, EQUAL_OFF);
		if (leftNewer != 2)
			if (leftNewer == 1)
				setToogle(true, LEFT_NEWER_ON, LEFT_NEWER_OFF);
			else
				setToogle(false, LEFT_NEWER_ON, LEFT_NEWER_OFF);
		if (rightNewer != 2)
			if (rightNewer == 1)
				setToogle(true, RIGHT_NEWER_ON, RIGHT_NEWER_OFF);
			else
				setToogle(false, RIGHT_NEWER_ON, RIGHT_NEWER_OFF);
		if (leftOnly != 2)
			if (leftOnly == 1)
				setToogle(true, LEFT_ONLY_ON, LEFT_ONLY_OFF);
			else
				setToogle(false, LEFT_ONLY_ON, LEFT_ONLY_OFF);
		if (rightOnly != 2)
			if (rightOnly == 1)
				setToogle(true, RIGHT_ONLY_ON, RIGHT_ONLY_OFF);
			else
				setToogle(false, RIGHT_ONLY_ON, RIGHT_ONLY_OFF);
		if (notComparable != 2)
			if (notComparable == 1)
				setToogle(true, NOT_COMPARABLE_ON, NOT_COMPARABLE_OFF);
			else
				setToogle(false, NOT_COMPARABLE_ON, NOT_COMPARABLE_OFF);
		if (includeSubdirectories != 2)
			if (includeSubdirectories == 1)
				setToogle(true,SUBDIRECTORIES_ON , SUBDIRECTORIES_OFF);
			else
				setToogle(false, SUBDIRECTORIES_ON, SUBDIRECTORIES_OFF);
		if (hideEmptyDirecotries != 2)
			if (hideEmptyDirecotries == 1)
				setToogle(true,EMPTYDIR_ON , EMPTYDIR_OFF);
			else
				setToogle(false, EMPTYDIR_ON, EMPTYDIR_OFF);
	}
	
	public void setToogle(boolean on, File toogleOnIcon, File toogleOffIcon){
		if(on){
			try{
				findImage(toogleOnIcon.getAbsolutePath());
			}
			catch (ImageNotFoundException e){
				leftClickMid(findImage(toogleOffIcon.getAbsolutePath()));
			}
		}else{
			try{
				findImage(toogleOffIcon.getAbsolutePath());
			}
			catch (ImageNotFoundException e){
				leftClickMid(findImage(toogleOnIcon.getAbsolutePath()));
				
			}
		}
	}
	/**
	 * 
	 * @param txt if true, txt toogle is on, if false, nat toogle is on
	 * @param xml if true XML toogle is on
	 * 
	 * XML toogle can be on only if nat toogle is on
	 */
	public void databaseComparisonToogles(boolean txt,boolean nat, boolean xml){
		if (txt && nat)
			logger.fine("Wrong parameters!!");
		else{
			if (txt)
				setToogle(true, TXT_TOGGLE_ON, TXT_TOGGLE_OFF);
			else if(nat){
				setToogle(true, NAT_TOGGLE_ON, NAT_TOGGLE_OFF);
				if (xml)
					setToogle(true, XML_TOGGLE_ON, XML_TOGGLE_OFF);
				else
					setToogle(false, XML_TOGGLE_ON, XML_TOGGLE_OFF);
			}
		}
	}
	
	
	/**
	 * 	0 - set toogle off
	 *  1 - set toogle on
	 *  2 - don't change
	 */
	public void setDBComparisonResultToogles(int equalRow,int differentRows,
			int rownsOnlyLeft, int rowsOnlyRight, int canMergedRightLeft,
			int canMergedLeftRight, int columnsNoDifferents){
		if (equalRow != 2)
			if (equalRow == 1)
				setToogle(true,EQAUL_ROW_ON , EQAUL_ROW_OFF);
			else
				setToogle(false, EQAUL_ROW_ON, EQAUL_ROW_OFF);
		if (differentRows != 2)
			if (differentRows == 1)
				setToogle(true, DIFFERENT_ROWS_ON, DIFFERENT_ROWS_OFF);
			else
				setToogle(false, DIFFERENT_ROWS_ON, DIFFERENT_ROWS_OFF);
		if (rownsOnlyLeft != 2)
			if (rownsOnlyLeft == 1)
				setToogle(true, ROWS_ONLY_LEFT_ON, ROWS_ONLY_LEFT_OFF);
			else
				setToogle(false, ROWS_ONLY_LEFT_ON, ROWS_ONLY_LEFT_OFF);
		if (rowsOnlyRight != 2)
			if (rowsOnlyRight == 1)
				setToogle(true, ROWS_ONLY_RIGHT_ON, ROWS_ONLY_RIGHT_OFF);
			else
				setToogle(false, ROWS_ONLY_RIGHT_ON, ROWS_ONLY_RIGHT_OFF);
		if (canMergedRightLeft != 2)
			if (canMergedRightLeft == 1)
				setToogle(true, CAN_MERGED_LEFT_RIGHT_ON, CAN_MERGED_LEFT_RIGHT_OFF);
			else
				setToogle(false, CAN_MERGED_LEFT_RIGHT_ON, CAN_MERGED_LEFT_RIGHT_OFF);
		if (canMergedLeftRight != 2)
			if (canMergedLeftRight == 1)
				setToogle(true, CAN_MERGED_RIGHT_LEFT_ON, CAN_MERGED_RIGHT_LEFT_OFF);
			else
				setToogle(false, CAN_MERGED_RIGHT_LEFT_ON, CAN_MERGED_RIGHT_LEFT_OFF);
		if (columnsNoDifferents != 2)
			if (columnsNoDifferents == 1)
				setToogle(true,COLUMNS_NO_DIFFERENTS_OFF , COLUMNS_NO_DIFFERENTS_ON);
			else
				setToogle(false, COLUMNS_NO_DIFFERENTS_OFF, COLUMNS_NO_DIFFERENTS_ON);
	}
	
	public void exportDifferences(String fileName){
		leftClickMenuItem("File",null, "Export differences...");
		Rectangle hint = findComponentClass("Edit");
		leftClickMid(hint);
		delay(2000);
		typeStringEnter(fileName);
		delay(3000);
		escapeDialog("Save As", VK_Y);
	}
	
	
	public void dragDrop(String imagePathFrom, String imagePathTo){
		dragDropMid(findImage(imagePathFrom), findImage(imagePathTo));
	}
	/**
	 * This function was created because in XMLChemaComarison because of defect with connection
	 * 
	 * @param imagePathFrom
	 * @param imagePathTo
	 */
	public void dragDropSchema(String imagePathFrom, String imagePathTo){
		Rectangle r1 = findImage(imagePathFrom);
		Rectangle r2 = findImage(imagePathTo);
		dragDrop(new Point(r1.x + r1.width,r1.y + r1.height),findMid(r2));
	}
	
	public void leftClickMenuBar(String menu){
			Rectangle menubar = findMenuBar(Color.BLACK,menu);
			Rectangle rect = findString(menu, WINDOWS_DEFAULT_FONT, TRANSPARENT, Color.BLACK, menubar, false);
			leftClickMid(rect);

	}
	public void expandFiltrList(){
		leftClickImage(EXPANDFILTR);
	}
	protected void defaultColorButton(){
		openDiffDogOptions("File comparison");
		leftClickOnIcon(DefaultColor, "Colors");
		okButton();
		
	}
	protected boolean diffdogRunning(){
		String process = "diffdog.exe";
		boolean found = false;
		try {
			Process p = Runtime.getRuntime().exec("tasklist /NH /FI \"imagename eq diffdog.exe\"");
            BufferedReader input =
                new BufferedReader
                  (new InputStreamReader(p.getInputStream()));
            String line;
            while((line = input.readLine()) != null){
                if (line.indexOf("DiffDog.exe") >= 0  ) {
                  found = true;
                }
            }
            return found;
		}
        catch (IOException e) {
            e.printStackTrace();
        }
		return false;
	}
	protected void checkDiffdogStillRunning(){
		if (diffdogRunning())
			killDiffDog();
	}
	protected void killDiffDog(){
		try {
			Runtime.getRuntime().exec("taskkill /im diffdog.exe /F");
		}
		catch (IOException e) {
            e.printStackTrace();
		}
	}

	
	
	

}
