package com.altova.umodel.regression.gui;


import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;
import static com.altova.umodel.regression.gui.UModelRobot.PROPERTIES;
import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.VK_CONTROL;
import static java.awt.event.KeyEvent.VK_D;
import static java.awt.event.KeyEvent.VK_DELETE;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_F;
import static java.awt.event.KeyEvent.VK_F12;
import static java.awt.event.KeyEvent.VK_F2;
import static java.awt.event.KeyEvent.VK_F4;
import static java.awt.event.KeyEvent.VK_F7;
import static java.awt.event.KeyEvent.VK_F8;
import static java.awt.event.KeyEvent.VK_HOME;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_N;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_SPACE;
import static java.awt.event.KeyEvent.VK_T;
import static java.awt.event.KeyEvent.VK_TAB;
import static java.awt.event.KeyEvent.VK_Y;
import static java.lang.Math.max;
import static java.lang.Math.min;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.altova.nativegui.ComponentInfo;
import com.altova.nativegui.NativeGUI;
import com.altova.robots.AltovaApplicationRobot;
import com.altova.robots.ApplicationErrorException;
import com.altova.robots.CheckboxOption;
import com.altova.robots.DropDownOption;
import com.altova.robots.EclipseRobot;
import com.altova.robots.ImageNotFoundException;
import com.altova.robots.ImageUtils;
import com.altova.robots.Option;
import com.altova.robots.Options;
import com.altova.robots.Pane;
import com.altova.robots.PluginRobot;
import com.altova.robots.RadioOption;
import com.altova.robots.ScreenDiff;
import com.altova.robots.ScriptMistakeException;
import com.altova.robots.TextFieldOption;
import com.altova.robots.VSnetRobot;
import com.altova.robots.Pane.PaneSize;
import com.altova.util.IOUtils;
import com.altova.util.RegressionAssert;
import com.altova.util.Settings;
import com.altova.util.Settings.AltovaApplication;
import com.altova.util.Settings.ApplicationSettings;


/**
 * Robot class specifically for UModel. It extends the other Robot classes, and
 * is adding functionality to remember the location of UML elements and draw
 * links between them.
 * <p>
 * Please refer to the section <a
 * href="file:///S:/QA/Internal/Test-Cases/Automated_GUI_Tests/documentation/robots_classes.xhtml">Robots
 * class hierarchy</a> for overview documentation.
 * 
 * @author Havard Rast Blok
 * @author B.Lopez
 *
 */
public class UModelRobot extends AltovaApplicationRobot {
	
	Map<String, Integer> elementCount = new HashMap<String, Integer>();
	
	Map<String, Rectangle> elements = new HashMap<String, Rectangle>();
	
	private static final String BASEPATH = "umodel/";
	

//	private final static String[] toolbarIds = { "IDR_MAINFRAME",
//			"IDR_TLB_ADD_ELEMENTS", "IDR_TLB_LAYOUT", "IDR_TLB_ZOOM", "IDR_TLB_ADD_XSD_ELEMENTS" };


	private final static String[] toolbarIds = { 
		"IDR_MAINFRAME",
		"IDR_TLB_ICONS_HELP",
		"IDR_TLB_LAYOUT",
		"IDR_TLB_ICONS_WINDOWS",
		"IDR_TLB_ZOOM",
		"IDR_TLB_ICONS_MISC",
		"IDR_TLB_ADD_ELEMENT_CLASS_DIAGRAM",
		"IDR_TLB_ADD_ELEMENT_OBJECT_DIAGRAM",
		"IDR_TLB_ADD_ELEMENT_USECASE_DIAGRAM",
		"IDR_TLB_ADD_ELEMENT_COMPONENT_DIAGRAM",
		"IDR_TLB_ADD_ELEMENT_DEPLOYMENT_DIAGRAM",
		"IDR_TLB_ADD_ELEMENT_SEQUENCE_DIAGRAM",
		"IDR_TLB_ADD_ELEMENT_PROTOCOL_STATEMACHINE_DIAGRAM",
		"IDR_TLB_ADD_ELEMENT_ACTIVITY_DIAGRAM",
		"IDR_TLB_ADD_ELEMENT_STATEMACHINE_DIAGRAM",
		"IDR_TLB_ADD_ELEMENT_COMPOSITESTRUCTURE_DIAGRAM",
		"IDR_TLB_ADD_ELEMENT_PACKAGE_DIAGRAM",
		"IDR_TLB_ADD_ELEMENT_COMMUNICATION_DIAGRAM",
		"IDR_TLB_ADD_ELEMENT_TIMING_DIAGRAM",
		"IDR_TLB_ADD_ELEMENT_INTERACTIONOVERVIEW_DIAGRAM",
		"IDR_TLB_ADD_ELEMENT_XMLSCHEMA_DIAGRAM",
		"IDR_TLB_UMODELCONTROL_PSEUDOCOMMANDS",
		"IDR_TLB_ADD_ELEMENT_BPMN_DIAGRAM",
		"IDR_TLB_MENU_BPMN_EVENTS",
	 };


	
	public final static Pane MODEL_TREE = new Pane("Model Tree");
	public final static Pane DIAGRAM_TREE = new Pane("Diagram Tree");
	public final static Pane FAVORITES = new Pane("Favorites");
	public final static Pane PROPERTIES = new Pane("Properties");
	public final static Pane STYLES = new Pane("Styles");
	public final static Pane OVERVIEW = new Pane("Overview");
	public final static Pane DOCUMENTATION = new Pane("Documentation");
	public final static Pane MESSAGES = new Pane("Messages");
	public final static Pane HIERARCHY = new Pane("Hierarchy");

	private static final Font SOURCE_CODE_FONT = new Font("Courier New", Font.PLAIN, 14);
	private static final Font SOURCE_CODE_LINENUMBER_FONT = new Font("Courier New", Font.PLAIN, 13);
	
	public UModelRobot() {
		this("Altova UModel", AltovaApplication.UMODEL, "UModel");
	}
	
	protected UModelRobot(String appName, ApplicationSettings product) {
		this(appName, product, "UModelControl");
	}
	
	private UModelRobot(String appName, ApplicationSettings product, String appRegKey) {
		super(appName, product, appRegKey, BASEPATH+"UModel_updated.rc", toolbarIds);

		
		addSettingsRegistryKey(	"MessageWindow", "Recent File List", "Search", "Settings",
				"UI_Z2007_English", "UI_Z2007r3_English", "UI_Z2007r3sp1_English","UI_Z2007r3sp1_English","UI_E2008_English","UI_E2008r2sp1_English","UI_E2009_English","UI_ME2010r3_English");
	}

	
	//---------------------------------------------------------------------------------------
	//-----------------------------               FILE MENU  -----------------------------
	//---------------------------------------------------------------------------------------
	
	/**
	 * Activate Option window from Tools menu
	 * method overwrites the generic one because the robot is confusing 
	 * Tools>Options with Tools>Spelling Options
	 * Call accordingly with:
	 *  public void customizeKeyboard(String category, String commands, int vkT)
	 */
	public void activateOptionsDialog(){ 
		keyTypeCtrl(VK_T);
		delay(1000);
	}
	
	/**
	 * Creates a new project. If currently open project is not saved,
	 * changes are discarded.
	 *
	 */
	public void newPrj() {


		leftClick("ID_FILE_NEW"); 
		//leftClickMenuItem("File", "New");	delay(1000);
		escapeDialog("Save changes", VK_N);
	}
	
	/**
	 * Saves the currently open project to the specified filename.
	 * If the file already exists, it is overwritten.
	 * 
	 * @param name path and file name to save to. 
	 */
	public void saveReplacePrj(String name) {
		checkDir(name);
		
		leftClickMenuItem("File", "As...  ");	
		delay(3000);
		if(Settings.isVS2010()){ //it needs longer in VS2010
			delay(10000);
		}
		typeString(name);
		logger.fine("Saved project as "+name);
		keyType(VK_ENTER);
		delay(4000);
		
		//there can pop up a few dialogs now
		//lets try to move on in the best way possible
		escapeDialog( "already exists", VK_Y);
		escapeDialog( "Confirm Save As", VK_Y);
		escapeDialog( "contains relative", VK_N);

		if( !isApplicationFront() ) {
			ComponentInfo info = NativeGUI.getForegroundWindowInfo();
			List<ComponentInfo> list = NativeGUI.getAllComponents(info.getLocation());
			
			logger.warning("Saved project. There might be a dialog in the way, but we don't know what to do with it. Info: "+info);
			logger.fine("List of components found in dialog: ");

			for (ComponentInfo i : list) {
				logger.fine(i.toString());
			}
		}
		
		delay(1000);
	}
	
	/**
	 * Loads the specified project.
	 * If the currently open project is not saved, changes are discarded.
	 * 
	 * @param name path and file name to load from.
	 */
	public void openPrj(String name) {
		checkFile(name);
		

		leftClick("ID_FILE_OPEN");
		//leftClickMenuItem("File", "Open...");

		//leftClick();
		delay(2000);
		typeString(name);
		keyType(VK_ENTER);
		
		escapeDialog( "Save changes", VK_N);
		
		//delay to prevent crash. see TTP #16055
		delay(1500);
		
	}
	
	
	/**
	 * Reload the current project, discard any changes.
	 */
	public void reloadProject() {
		leftClickMenuItem("File", "Reload"); delay(500);
		escapeDialog( "Do you want to reload", VK_Y);
	}
	
	public void saveDiagramAsImage(String file) {
		leftClickMenuItem("File", "Save Diagram As Image"); delay(500);
		typeString(file); keyType(VK_ENTER); delay(500);
		escapeDialog( "already exists", VK_Y); delay(500);
	}
	
	public void saveAllDiagramsAsImages(String menu_item,String dirpath,Option option){
		checkDir(dirpath+File.separator+"dummy");
		leftClickMenuItem(menu_item, "Save All Diagrams As Images");
		typeString(dirpath);
		applyOptionsEnter("Save all Diagrams as Images", option);
		delay(10000);
	}
	
	public void saveAllDiagramsAsImages(String dirpath,Option option){
		saveAllDiagramsAsImages("File",dirpath,option);
	}
	
	public void importXMIFromSpecificMenu(String menu_item, String name){
		checkFile(name);
		leftClickMenuItem(menu_item, "Import from XMI File"); delay(500);
		typeString(name); keyType(VK_ENTER); delay(500);
	}
	
	public void importXMI(String name) {
		importXMIFromSpecificMenu("File",name);
		
	}
	
	/**
	 * Export the current model to XMI. Any already existing file is overwritten.
	 */
	public void exportXMIFromSpecificMenu(String menu_item, String name) {
		leftClickMenuItem(menu_item, "Export to XMI File"); delay(500);
		typeString(name); keyType(VK_ENTER); delay(500);
		escapeDialog( "already exists", VK_Y); delay(1000);
	}
	
	public void exportXMI(String name){
		exportXMIFromSpecificMenu("File",name);
	}
	
	public void sendByMailCancel() {
		leftClickMenuItem("File", "Send by Mail"); delay(3000);
		if(isApplicationFront()) {
			logger.warning("Did not detect any e-mail program on top");
		}
		
		//assuming we get Outlook up here
		if( !escapeDialog("No profiles have been created", VK_ESCAPE) ) {
			leftClickMenuItem("File", "Close"); delay(500);
			escapeDialog("save changes", VK_N);
		}
		
		delay(1000);
	}

	//---------------------------------------------------------------------------------------
	//-----------------------------               EDIT MENU  -----------------------------
	//---------------------------------------------------------------------------------------

	//for other edit menu items, see AltovaApplicationRobot
	
	@Override
	public void delete() {
		super.delete();
		escapeDialog("This action deletes the selected element", VK_Y);
	}
	
	public void delete(boolean diagonly) {
		super.delete();
		Rectangle deletewind = NativeGUI.getForegroundWindowInfo().getLocation();
		if (diagonly) {

			leftClickMid(findComponent("diagram only", "Button", deletewind));
		} else {
			leftClickMid(findComponent("Yes", "Button", deletewind));
		}
	}
	
	/**This is necessary for the plugins as focus is not correctly changed 
	 *in deleteOnlyInDiagram() testcase
	 */
	public void clickOnElement(Rectangle elem){
		if(this instanceof PluginRobot){
			leftClickMid(elem);
			}
	}
	
	/** Action from Edit menu. Fill throw exception if not available. */
	public void pasteInDiagramOnly() {
		leftClickMenuItem("Edit", "Paste in Diagram only");
	}
	
	/** Action from Edit menu. Fill throw exception if not available. */
	public void deleteFromDiagramOnly() {
		leftClickMenuItem("Edit", "Delete from Diagram only");
	}
	
	/**
	 * Use the Find Dialog to search for the specified string.
	 * 
	 * @param string string to search for
	 */
	public void findDialog(String string) {
		findDialog(string, true,true,true,false);
	}
		
	public void findDialog(String string, boolean cleanField,boolean wholewrdonly,boolean casesens,boolean ifnegtest) {
		//open find
		ComponentInfo info = NativeGUI.getForegroundWindowInfo();
		for (int i = 0; i < 5 && !info.getWindowText().equalsIgnoreCase("Find") ; i++) {
			logger.info("Pressing Cntrl+F to find string");
			keyTypeCtrl(VK_F);
			delay(1000);
			info = NativeGUI.getForegroundWindowInfo();
			
			//The find dialog is only active from the Model Tree
			//switch to Model Tree pane if we need to
			if( !info.getWindowText().equalsIgnoreCase("Find") ) {
				logger.info("I search to activate MODEL TREE");
				activatePane(MODEL_TREE);
			}
		}
		
		assertWindow("Find");
		
		//set the Find options
		Options options = new Options();
		options.add(new TextFieldOption("Find what", string));
		options.add(new CheckboxOption("Match whole word only", wholewrdonly)); 
		options.add(new CheckboxOption("Match case", casesens));
		options.applyOption(this);

		//carry out the search
		keyType(VK_ENTER);
		delay(1000);
		if (!ifnegtest) {
			if (escapeDialog("Cannot find the string", VK_ESCAPE)) {
				keyType(VK_ESCAPE); // escape the find dialog as well
				throw new ScriptMistakeException("The string '" + string + "' could not be found");
			}
		}
		
		//remove string from the tab when we're done
		if(cleanField) {
			removeFindString();
		}
	}
	
	public void removeFindString() {
		logger.fine("Move up to Find toolbar");
		keyTypeCtrl(VK_D);
		delay(1000);
		keyType(VK_SPACE);
		delay(500);
		keyType(VK_ESCAPE);
	}

	
	/** Action from Edit menu. Fill throw exception if not available. */
	public void findPrevious() {
		try {
			leftClickMenuItem("Edit", "Find Previous");
		} catch (ScriptMistakeException e) {
			logger.finest("Find previous was not found. We try with strg+F3");
			super.findPrevious();
		}
	}
	
	/** Action from Edit menu. Fill throw exception if not available. */
	public void replace(String toFind, String toReplace, boolean replaceAll, boolean wholewrdonly, boolean casesens,boolean justselec,String...menuitems) {
		Rectangle repwdw = NativeGUI.getForegroundWindowInfo().getLocation();
		leftClickMenuItem("Edit",menuitems);
		delay(1000);
		assertWindow("Find & Replace");
		typeString(toFind);
		keyType(VK_TAB);
		delay(500);
		typeString(toReplace);
		Options options = new Options();
		options.add(new CheckboxOption("Match whole word only", wholewrdonly));
		options.add(new CheckboxOption("Match case", casesens));
		options.add(new CheckboxOption("Replace in selection only",justselec));
		options.applyOption(this);
		if (!replaceAll) {
			leftClickMid(findComponent("Find","Button",repwdw));
			delay(1000);
			leftClickMid(findComponent("Replace", "Button", repwdw));
		} else {
			leftClickMid(findComponent("All", "Button", repwdw));
		}
	}
	
	//This method is needed for the execution of some testcases in the plugins
	public void replace(String toFind, String toReplace, boolean replaceAll, boolean wholewrdonly, boolean casesens,boolean justselec){
		replace(toFind,toReplace,replaceAll,wholewrdonly, casesens,justselec,"Replace");
	}
	
	/** Action from Edit menu. Fill throw exception if not available. */
	public void copyAsBitmap() {
		leftClickMenuItem("Edit", "Copy as Bitmap");
	}
	
	/** Action from Edit menu. Fill throw exception if not available. */
	public void copySelectionAsBitmap() {
		leftClickMenuItem("Edit", "Copy Selection as Bitmap");
	}
	
	public void exitApplication() {
		exitWithuotSave();
	}
	
	public void exitWithuotSave() {
		//compareState = PixelCompare.BLACK_WHITE;
		int ignoreOld = ignorePixels;
		ignorePixels = 0;
		leftClickMenuItem("File", "Exit  "); delay(1000);
		ignorePixels = ignoreOld;
		//compareState = DEFAULT_PIXEL_COMPARE;
		
		//press No, for the Save modified file dialog
		ComponentInfo info = NativeGUI.getForegroundWindowInfo();
		if(info.getWindowText().indexOf(getStringToLookForInDialog()) > -1) {
			typeString("n");
		}
//		ComponentInfo info2 = NativeGUI.getForegroundWindowInfo();
//		if(info2.getWindowText().indexOf(getStringToLookForInDialog()) > -1) {
//			typeString("n");
//		}
//		delay(5000);
	}
	
	public String getStringToLookForInDialog(){
		return "UModel"; 
	}
	
	
	
	//---------------------------------------------------------------------------------------
	//-----------------------------               PROJECT MENU  -----------------------------
	//---------------------------------------------------------------------------------------

	protected String getProjectMenu() {
		return "Project";
	}

	protected String getExtraProjectMenu() {
		return null;
	}
	
	protected void escapeLanguageNotSupportedDialogInPlugins(){
		//should be empty here, as this affects just both plugins
	}
	
	public void syntaxCheck() {
		syntaxCheck(getProjectMenu(), getExtraProjectMenu(),"Check Project Syntax");
	}

	protected void syntaxCheck(String menu, String...menuitems) {
		leftClickMenuItem(menu, menuitems);
	}
	
	public void importSourceDirectory(Option options) {
		
		leftClickMenuItem(getProjectMenu(), getExtraProjectMenu(),"Import Source Directory");
		assertWindow("Import Source Directory");
		Rectangle impWdw = NativeGUI.getForegroundWindowInfo().getLocation();
		
		if (options != null) {
			options.applyOption(this);
		}
		
		//import
		Rectangle finishButton = findComponent("Finish", "Button", impWdw);
		if(finishButton == null) {
			throw new ScriptMistakeException("Could not find the Finish button in the Import Source Directory dialog");
		}
		
		leftClickMid(finishButton);
		delay(15000);
		//special method for VS and eclipse to escape the java is not supported dialog
		escapeLanguageNotSupportedDialogInPlugins();
	}
	
	public void importSourceProject(Options options, boolean ifvb9) {
		leftClickMenuItem(getProjectMenu(), getExtraProjectMenu(), "Import Source Project");
		delay(1000);
		assertWindow("Import Source Project");
		Rectangle impWdw = NativeGUI.getForegroundWindowInfo().getLocation();
		if (ifvb9) {//this is a work-around since vb8 is found instead of vb9
			
			Rectangle lang=findComponent("Language:", "Static", impWdw);
			leftClick(lang.x+80,lang.y+5);
			keyType(KeyEvent.VK_END);delay(500);
			keyType(KeyEvent.VK_ENTER);
		}

		if (options != null) {
			options.applyOption(this);
		}

		// import
		Rectangle finishButton = findComponent("Finish", "Button", impWdw);
		if (finishButton == null) {
			logger.warning("Could not find the Finish button in the Import Source Project dialog");
		}
		leftClickMid(finishButton);
		delay(10000);
		// special method for VS to escape the java is not supported dialog
		escapeLanguageNotSupportedDialogInPlugins();
		
	}
	
	public void importBinaryTypes(Options options,String importType,String fileToImport){
		leftClickMenuItem(getProjectMenu(), getExtraProjectMenu(), "Import Binary Types");
		delay(1000);
		assertWindow("Import Binary Types");
		Rectangle impWdw = NativeGUI.getForegroundWindowInfo().getLocation();
		if (options != null) {
			options.applyOption(this);
		}
//		 import
		Rectangle nextButton = findComponent("Next", "Button", impWdw);
		if (nextButton == null) {
			logger.warning("Could not find the Next button in the Import Binary Types dialog");
		}
		leftClickMid(nextButton);
		delay(4000);
		assertWindow("Import Binary Selection");
		keyType(KeyEvent.VK_DOWN);
		Rectangle hint=new Rectangle((int)(impWdw.x+0.75*(impWdw.width)),impWdw.y,impWdw.width,(int)(0.75*(impWdw.height)));
		leftClickMid(findString(importType, hint, false));
		delay(500);
		typeStringEnter(fileToImport);
		delay(2000);
		leftClick(impWdw.x+45, impWdw.y+70);
		delay(1000);
		Rectangle finishButton = findComponent("Finish", "Button", impWdw);
		if (finishButton == null) {
			logger.warning("Could not find the Finish button in the Import Source Project dialog");
		}
		leftClickMid(finishButton);
		delay(12000);
//		 special method for VS to escape the java is not supported dialog
		escapeLanguageNotSupportedDialogInPlugins();
		
		
	}
	public void codeToModel(Option options) {
		if (this instanceof PluginRobot) {
			leftClickMenuItem(getProjectMenu(), getExtraProjectMenu(), "Merge UModel Project from Program Code");
		} else {
		keyTypeCtrl(VK_F12);
		}
		delay(1000);
		syncCode(options);
	}
	
	public void modelToCode(Option options) {
		if (this instanceof PluginRobot) {
			leftClickMenuItem(getProjectMenu(), getExtraProjectMenu(), "Merge Program Code from UModel Project");
		} else {
			keyType(VK_F12);
		}
		delay(3000);
		syncCode(options);
		escapeLanguageNotSupportedDialogInPlugins();
	}
	
	public void modelToCodeDoNotCheckIfErrors(Option options) {
		if (this instanceof PluginRobot) {
			leftClickMenuItem(getProjectMenu(), getExtraProjectMenu(), "Merge Program Code from UModel Project");
		} else {
			keyType(VK_F12);
		}
		delay(3000);
		syncCodeDoNotCheckIfErrors(options);
		escapeLanguageNotSupportedDialogInPlugins();
	}
	
	public void importSourceXSDDir(Option options) {
		
		leftClickMenuItem(getProjectMenu(), getExtraProjectMenu(),"Import XML Schema Directory");
		assertWindow("Import XML Schema Directory");
		Rectangle impWdw = NativeGUI.getForegroundWindowInfo().getLocation();
		
		if (options != null) {
			options.applyOption(this);
		}
		
		//import
		Rectangle finishButton = findComponent("Finish", "Button", impWdw);
		if(finishButton == null) {
			throw new ScriptMistakeException("Could not find the Finish button in the Import XML Schema Directory dialog");
		}
		
		leftClickMid(finishButton);
		delay(15000);
//		 special method for VS to escape the java is not supported dialog
		escapeLanguageNotSupportedDialogInPlugins();
		
		
	}

	public void importXSDFile(Options options,File output) {
		leftClickMenuItem(getProjectMenu(), getExtraProjectMenu(), "Import XML Schema File");
		delay(1000);
		assertWindow("Import XML Schema File");
		Rectangle impWdw = NativeGUI.getForegroundWindowInfo().getLocation();
		
		if (options != null) {
			options.applyOption(this);
		}

		// import
		Rectangle finishButton = findComponent("Finish", "Button", impWdw);
		if (finishButton == null) {
			logger.warning("Could not find the Finish button in the Import XSD File dialog");
		}

		leftClickMid(finishButton);
		delay(8000);
//		 special method for VS to escape the java is not supported dialog
		escapeLanguageNotSupportedDialogInPlugins();
		
		/**The 'Save As' dialog pops up when the "Import XSD relative to UModel
		 * project file" is checked and project is not saved yet (in the integrations, 
		  no save as pops up as project is saved beforehand) **/ 
		if((!(this instanceof PluginRobot))&&(output!=null)){
			assertWindow("Save As");
			typeStringEnter(output.getAbsolutePath());
			delay(8000);
			RegressionAssert.assertFileExists(output);
			}
	}
	private void syncCode(Option options) {
		syncCodeDoNotCheckIfErrors(options);
		//checkCrash(); //a crash check is done after every test already
		if(!(this instanceof EclipseUModelRobot)){
		checkMessageWindow();		
		}
	}
	
	private void syncCodeDoNotCheckIfErrors(Option options) {
		//we're expecting the sync dialog here
		assertWindow("Synchronization Settings");
		
		if(options != null) {
			options.applyOption(this);
		}
		
		Rectangle ok = findComponentName("OK");
		leftClickMid(ok);
		
		//special method for VS to escape the java is not supported dialog
		escapeLanguageNotSupportedDialogInPlugins();
		
		delay(5000);
	}
	
	public void projectSettings() {
		leftClickMenuItem(getProjectMenu(),getExtraProjectMenu(), "Project Settings");
		assertWindow("Project Settings");
	}
	
	public void synchronizationSettings() {
		leftClickMenuItem(getProjectMenu(),getExtraProjectMenu(), "Synchronization Settings");
		assertWindow("Synchronization Settings");	
	}
	
	public void mergeProject(String projectToMerge){
		leftClickMenuItem(getProjectMenu(),getExtraProjectMenu(), "Merge Project");
		delay(1000);
		assertWindow("Open");
		typeStringEnter(projectToMerge);
		delay(1000);
	}
	
	public void switchTabsAndGetScreenshot(String testName, String assertWindow, String ...tabs){
		
		Rectangle area = null;
		
		assertWindow(assertWindow);
		area = findComponentName(assertWindow);
		
		
		for (String string : tabs) {
			
			leftClickMid(findString(string, MS_SHELL_DLG_FONT, area, false));
			delay(500);
			com.altova.util.RegressionAssert.assertAreas(testName+ "_" + string ,TOP_WINDOW);
		}
	
	}

	
	public void includeSubProject(String name, String includeopt) {
		checkFile(name);
		
		leftClickMenuItem(getProjectMenu(),getExtraProjectMenu(), "Include Subproject");
		delay(500);
		assertWindow("Include Subproject");
		
		//always go for browse
		Rectangle browse = findComponentName("Browse");
		leftClickMid(browse);
		delay(1000);
		
		assertWindow("Open");
		typeString(name); keyType(VK_ENTER);
		delay(1000);
		
		if(escapeDialog("is already included", VK_ESCAPE)) {
			throw new ScriptMistakeException("The project '"+name+"' was already included");
		}
		
		//see if we get the Include dialog or not, and only for the tescases where it comes up..
		if(includeopt!=null){
		delay(1000);
		
		assertWindow("Include Subproject");
		Options options=new Options();
		
		options.add(new RadioOption(includeopt, "Kind of include"));
		options.applyOption(this);
		if (this instanceof PluginRobot) { // this is just necessary for the
				// plugins, as projects are already
				// saved at creating them
				Options options1=new Options();
				options1.add(new CheckboxOption("Make path relative to ", false));
				try {

					options1.applyOption(this);
				} catch (ImageNotFoundException e) {
					logger.info("Make path relative to checkbox is not enabled");
				}
			}
		
		
		Rectangle ok = findComponent("OK","Button",NativeGUI.getForegroundWindowInfo().getLocation());
		leftClickMid(ok);
		delay(5000);
		}
	}
	
	public void checkIncludeSubProject_byRef(File newproj){
		
		saveReplacePrj(newproj.getAbsolutePath());
		newPrj();
		openPrj(newproj.getAbsolutePath());
		activatePane(MODEL_TREE);
		findDialog("ISomeAPI");
		typeStringEnter("We try to change it");
		RegressionAssert.assertAreas(PROPERTIES);
	}
	
	public void openSubProjectAsProject(String subPrj) {
		leftClickMenuItem(getProjectMenu(), getExtraProjectMenu(), "Open Subproject As Project", subPrj);
	}

	public void clearMessages() {
		leftClickMenuItem(getProjectMenu(), getExtraProjectMenu(), "Clear Messages");
	}

	public void generateDocumentation(File outputdir,String filename,Option options){
		checkDir(outputdir+File.separator+"dummy");
		leftClickMenuItem(getProjectMenu(), getExtraProjectMenu(), "Generate Documentation");
		delay(2000);
		keyType(KeyEvent.VK_UP);
		applyOptionsEnter("Generate Documentation",options);
		assertWindow("Save As");
		typeStringEnter(outputdir.getAbsolutePath()+"\\"+filename);
		delay(10000);
	}
	
	public void listElementsNotUsed() {
		leftClickMenuItem(getProjectMenu(), getExtraProjectMenu(), "List Elements not used in any Diagram");
	}

	public void listSharedPackages() {
		leftClickMenuItem(getProjectMenu(), getExtraProjectMenu(), "List shared Packages");
	}

	public void listIncludedPackages() {
		leftClickMenuItem(getProjectMenu(), getExtraProjectMenu(), "List included Packages");
	}

	//---------------------------------------------------------------------------------------
	//-----------------------------               LAYOUT MENU  -----------------------------
	//---------------------------------------------------------------------------------------
	
	public void layout(LayoutOperation operation) {
		operation.leftClickMenuItem(this);
		delay(2000);
	}
	
	//this method was created to solve the menu name given in eclipse
	public void layoutSameSize() {
		LayoutOperation.SAME_SIZE_WIDTH_HEIGHT.leftClickMenuItem(this);
		delay(2000);
	}
	
	public void layout(LayoutOperation operation, String... elements) {
		if(elements != null && elements.length > 0) {
			select(elements);
		}
		
		operation.leftClickMenuItem(this);
	}
	
	public void autosize() {
		leftClickMenuItem("Layout", "Autosize");
	}
	
	public void repositionTextLabels() {
		leftClickMenuItem("Layout", "Reposition Text Labels");
	}
	
	//---------------------------------------------------------------------------------------
	//-----------------------------               VIEW MENU  -----------------------------
	//---------------------------------------------------------------------------------------

	public void viewOnOffDocumentation(){
		leftClickMenuItem("View","Documentation");
	}
	
	public void viewAllOnOffUModelWindows(){
		leftClickMenuItem("View", "All on / off");
	}
	
	public void hideWindow(String Wdwname){
		
		if (isWindowOn(Wdwname)){
			leftClickMenuItem("View",Wdwname);
		}
	}
	
	public void activateWindow(String Wdwname){
		if(!isWindowOn(Wdwname)){
			leftClickMenuItem("View",Wdwname);
		}
	}
	
	public boolean isWindowOn(String Wdwname){
		
		
		Rectangle r = findComponentName(Wdwname);
		
		if (r!= null)return true;
		else return false;
	}
	
	//---------------------------------------------------------------------------------------
	//-----------------------------               TOOLS MENU  -----------------------------
	//---------------------------------------------------------------------------------------
	
	public void customize() {
		leftClickMenuItem("Tools", "Customize");
		delay(1500);
		assertWindow("Customize");
	}
	
	//---------------------------------------------------------------------------------------
	//-----------------------------               WINDOW MENU  -----------------------------
	//---------------------------------------------------------------------------------------

	
	public void arangeIcons() {
		leftClickMenuItem("Window", "Arrange Icons");
	}
	
	/**
	 * Closes the currently open diagram.
	 * 
	 */
	public void closeDiagram() {
		leftClickMenuItem("Window", "Close");
	}
	
	public void closeAllDiagrams() {
		leftClickMenuItem("Window", "Close All");
	}
	
	public void closeAllButActiveDiagrams() {
		leftClickMenuItem("Window", "Close All But Active");
	}
	
	public void forwardToNextDiagram() {
		leftClickMenuItem("Window", "Forward");
	}
	
	public void backToPreviousDiagram() {
		leftClickMenuItem("Window", "Back");
	}

	
	//---------------------------------------------------------------------------------------
	//-----------------------------               HELP MENU  -----------------------------
	//---------------------------------------------------------------------------------------
	
	//other help methods in AltovaApplicationRobot class
	
	public void webUModel() {
		super.applicationOnWeb();
	}
	
	public void aboutUModel() {
		super.aboutApplication();
	}
	
	//---------------------------------------------------------------------------------------
	//----------------------     Model Tree and related methods -----------------------------
	//---------------------------------------------------------------------------------------

	public void selectModelTreeRoot() {
		//make the Model Tree pane active
		
		activatePane(MODEL_TREE); delay(1000);
		
		//make the Root element top and expanded
		logger.finest("Pressing HOME, LEFT, RIGHT to highlight and expand the Root element");
		keyType(VK_HOME); delay(500);
		keyType(VK_LEFT); delay(500);
		keyType(VK_RIGHT); delay(1000);
		
		clickModelTreeItem("Root"); delay(1000);
	}
	
	private void openModelTreeMenu() {
		selectModelTreeRoot();
		rightClick();
	}
	
	/*
	 * @mainElement: is the element that to select when mouse right-click  
	 * @name: is the name of the new element added
	 * @subelement: all subelement  
	 * 
	 */
	
	public void newRootElements(String mainElement, String name,  String... subelements) {
		
		if(mainElement == null || subelements == null) {
			throw new NullPointerException("Null not allowed as elements name");
		}
		
		openModelTreeMenu();
		
		leftClickString(mainElement);
		delay(500);
		
		for (String newelement : subelements) {
		
			// Special case for Constraint element that is not recognizable from the robot	
			if (newelement.contains("New element>Constraints>Constraint")){
				keyType(VK_LEFT);
				delay(800);
				keyType(VK_RIGHT);
				delay(800);
				keyType(VK_ENTER);
				
			}else{
				
				leftClickString(newelement);
				delay(1000);
				
			}
		}
		
		
		
		typeString(name);
		keyType(VK_ENTER);	
		
	}
	
	
	public void newRootElement(String element, String name) {
		if(element == null) {
			throw new NullPointerException("Null not allowed as element name");
		}
		
		logger.fine("newElement("+element+")");
		
		openModelTreeMenu();
		
		leftClickString("New element");
		delay(500);
		leftClickString(element);
		//leftClick();
		delay(1000);
		
		//name the element
		if(name != null) {
			typeString(name);
			keyType(VK_ENTER);
		}
	}
	
	
	/**
	 * Creates a new Constraint element
	 *  
	 * @param name of the element
	 */
	public void newRootElementConstraint(String name) {
				
		openModelTreeMenu();
		
		leftClickString("New element");
		delay(500);
		
		leftClickString("Constraints");
		delay(500);
		
		keyPress(VK_LEFT);
		delay(500);
		
		keyPress(VK_RIGHT);
		delay(500);
		
		keyType(VK_ENTER);

		typeString(name);
		keyType(VK_ENTER);		
		
	}
	
	

	
	public void findOnMenu(String ...items){
		
		for (String item : items) {
			
			leftClickString(item);
			delay(500);
		}
		
		
	}
	
	public void newElement(String element, String parent, String name) {
		throw new ScriptMistakeException("not implemented yet");
	}
	
	/**
	 * Creates a new diagram of the specified name in the Root package.
	 *  
	 * @param diagram name of diagram as shown on context menu
	 * @throws NullPointerException if diagram is null.
	 */
	public void newDiagram(String diagram) {
		if(diagram == null) {
			throw new NullPointerException("Null not allowed as diagram name");
		}
		
		logger.fine("newDiagram("+diagram+")");
		
		openModelTreeMenu();
		clickNewDiagram(diagram);
	}

	public void newDiagram(String diagram, String parent, String name) {
		if(diagram == null || parent == null) {
			throw new NullPointerException("Null not allowed as diagram or parent name.");
		}
		rightClickModelTreeElement(parent,false);
		
		//create new diagram
		clickNewDiagram(diagram);
		
		//change its name
		setPaneValue(PROPERTIES, "name", name);
	}
	
	protected void clickNewDiagram(String diagram) {
		leftClickString("New diagram");
		delay(500);
		leftClickString(diagram);
		delay(2000);
	}
	
	/**
	 * Finds the specified diagram in the Model Tree, and then opens it.
	 * @param diagram the fully qualified name of the diagram
	 */
	public void openDiagram(String diagram) {
		rightClickModelTreeElement(diagram,false); delay(1000);
		leftClickString("Open diagram"); delay(3000);
	}
	
	
	/**
	 * Finds the specified diagram in the Model Tree, and then select the item from drop down menu.
	 * @param diagram the fully qualified name of the diagram
	 */
	public void selectDiagramMenuItem(String diagram, String property) {
		rightClickModelTreeElement(diagram,false); delay(1000);
		leftClickString(property); delay(3000);
	}
	
	/**
	 * Sets the specified diagram active, assuming the name is the default from UModel.
	 * 
	 * @param diagramType the default diagram type name
	 */
	public void setActiveDiagram(String diagramType) {
		String fullName = diagramType.replace(" ", "") + "Diagram1";
		openDiagram(fullName);
	}
	
	/**
	 * Clicks an item in the model tree, ten pixels to the left
	 * of the specified text. This is so that a double click will not 
	 * make the item go into rename-mode, but instead expand its tree. 
	 * 
	 * @param str string of icon to click in the Model Tree. 
	 */
	public void clickModelTreeItem(String str) {
		Rectangle rect = findString(str, DEFAULT_CONTENT_FONT);
		Point p = ImageUtils.findMid(rect);
		p.x = rect.x - 10;

		leftClick(p);
	}

	/**
	 * Expands the specified item in the Model Tree. This is done by clicking it
	 * once, and then pressing the + sign on the keyboard.
	 * 
	 * @param qname string name of item to expand in the Model Tree.
	 */
	public void expandModelTreeNode(String qname) {
		logger.fine("Expanding Model Tree node: "+qname);
		findModelTreeElement(qname,true);
		clickModelTreeItem(qname);
		typeString("+");
	}
	
	/**
	 * Selects the element in the Model Tree as specified by the QName, and return the location.
	 * The QName is built up by the packages which contains the element, 
	 * and separated by double colons (::). Example: <i>com::altova::umodel::UModelRobot</i>  
	 * 
	 * @param qname
	 * @return the area which is taken up by the simple element name in the Model Tree
	 * @throws ImageNotFoundException if the element was not found
	 * 		
	 */
	public Rectangle findModelTreeElement(String qname,boolean check) {
		String names[] = qname.split("::");

		selectModelTreeRoot();

		// TODO: we might need to extend the Model Tree to the right
		// in order to see the full names in the Model Tree
		for (String name : names) {
			logger.finest("Searching for " + name);
			boolean found = false;
			findDialog(name, false, true, true, false);
			if (check) {
				for (int i = 0; i < 20 && !found; i++) {
					// check if we found the right element by looking
					// at the name in the properties field
					Rectangle hint = getPaneKeyValue(PROPERTIES, "name");
					logger.finest("hint: " + hint);

					try {
						Rectangle res = findString(name + "  ",
								DEFAULT_CONTENT_FONT, Color.WHITE, Color.BLACK,
								hint, false);
						found = true;
						logger.finest("found key name: " + name + ", res: "
								+ res);
					} catch (ImageNotFoundException e) {
					} // ignore (and continue search)

					if (!found) {
						activatePane(MODEL_TREE);
						findNext();
					}
				}
			}
		}

		removeFindString();
		activatePane(PROPERTIES);

		// try to find it in the Model Tree window
		Rectangle ans = null;
		String mtName = names[names.length - 1] + " ";
		Color selectedElementBg = new Color(220, 220, 220); // very light gray
		Color selectedElementBg_purple = new Color(220, 220, 255); // purple (for eclipse 4.3)
		//Color selectedElementBg = new Color(0, 0, 0); // very dark black
		// search in normal font
		try {
			ans = findString(mtName, DEFAULT_CONTENT_FONT, selectedElementBg, Color.BLACK, null, false);
		} catch (ImageNotFoundException e) {
			logger.fine("Element " + mtName + " not found in Model Tree. Will search in italic font as well");
		}

		
		// search with normal font but purple background 
		if (ans == null) {
			ans = findString(mtName, DEFAULT_CONTENT_FONT, selectedElementBg_purple, Color.BLACK, null, false);
		}
		
		// search in italic fonts (for abstract classes)
		if (ans == null) {
			Font italic = DEFAULT_CONTENT_FONT.deriveFont(Font.ITALIC);
			ans = findString(mtName, italic, selectedElementBg, Color.BLACK, null, false);
		}

		logger.finest("findModelTreeElement - return: " + ans);
		return ans;
	}
	
	/**
	 * Clicks with the left mouse button on the specified element in the Model Tree.
	 * @param qname the fully qualified element name
	 * @return the location where the element String was found
	 */
	public Rectangle leftClickModelTreeElement(String qname,boolean check) {
		Rectangle ans = findModelTreeElement(qname,check);
		leftClickMid(ans); delay(500);
		return ans;
	}
	
	/**
	 * Clicks with the right mouse button on the specified element in the Model Tree.
	 * @param qname the fully qualified element name
	 * @return the location where the element String was found
	 */
	public Rectangle rightClickModelTreeElement(String qname,boolean check) {
		Rectangle ans = findModelTreeElement(qname,check);
		rightClickMid(ans);
		return ans;
	}

	
	//---------------------------------------------------------------------------------------
	//-----------------------------     Special diagram methods -----------------------------
	//---------------------------------------------------------------------------------------
	
	/**
	 * Create a new UML element of the specified type at the specified position.
	 * 
	 * @param element type of UML element
	 * @param x position on the screen
	 * @param y position on the screen
	 */
	public void putElement(String element, int x, int y) {
		putElement(element, null, x, y);
	}
	
	/**
	 * Create a new UML element of the specified type at the specified position,
	 * and gives it a name.
	 * 
	 * @param element type of UML element
	 * @param name the name the new element is given
	 * @param x position on the screen
	 * @param y position on the screen
	 */
	public void putElement(String element, String name, int x, int y) {
		deselectAll();
		//click the element icon on the toolbar
		leftClickElementIcon(element);
		
		// position the element. See where it actually ended up
		Rectangle diagram = getMainWindow();
		ScreenDiff diff = new ScreenDiff(this);
		int hintX = max(diagram.x, x - 50);
		int hintY = max(diagram.y, y - 50);
		int hintW = min(x + 300, diagram.x + diagram.width) - x;
		int hintH = min(y + 300, diagram.y + diagram.height) - y;
		Rectangle hint = new Rectangle(hintX, hintY, hintW, hintH);
		logger.finest("Looking for new element in diagram at: "+hint);
		diff.snapBefore(hint);
		
		leftClick(x, y);
		
		//type the name, and/or deselect the new element 
		if(name != null) {
			typeString(name);
		}
		waitForIdle(); 	delay(3000);
		keyType(VK_ENTER); delay(500);
		deselectAll();  delay(500);
		
		diff.snapAfter();
		Rectangle location = diff.diffBounds();
		int count = inc(element);
		if(location != null) {
			leftClickMid(location);
			//keep track of the name of the element
			String key = element+count;
			
			//store the position of the element
			elements.put(key, location);
			logger.finest(key+"="+elements.get(key));
			if(name != null) {
				//store by name as well
				elements.put(name, location);
				logger.finest(name+"="+elements.get(key));
			}
		} else {
			logger.severe("The element "+element+" with name "+name+" at ("+x+", "+y+") was not detected on the diagram, for some reason.");
		}
	}

	protected void leftClickElementIcon(String element) {
		leftClick(element);
	}
	
	//this method just makes change in eclipse
	public void activateEclipseDiagramDropdown(){
		
	}

	public void removeElementKey(String element) {
		int count = dec(element);
		String name = element+count;
		elements.remove(name);
	}
	
	public void removeAllElementKeys() {
		elements.clear();
	}

	
	/**
	 * Get the position of a UML element with the specified name.
	 * 
	 * 
	 * @param name the actual model name, e.g. Class2, or the qname
	 * @return a Rectangle surrounding the specified element
	 */
	public Rectangle getElementLocation(String name) {
		//first check if any diagrams are open
		ComponentInfo diagram = getDiagramComponent();
		if(diagram!=null) {
			if(elements.containsKey(name)) {
				return elements.get(name);
			}
			
		}	
//			search for the element
			Rectangle location = findDiagramElement(name,true);
			if(location != null) {
				elements.put(name, location);
			}
			
			return location;

	}
	
	
	/**
	 * Clicks with the left mouse button on the specified element.
	 * @param element the fully qualified element name
	 */
	public void leftClickElement(String element) {
		leftClickMid( getElementLocation(element) );
	}
	
	private int inc(String element) {
		int count = 1;
		if(elementCount.containsKey(element)) {
			count = elementCount.get(element);
			count++;
		}
		
		elementCount.put(element, count);
		return count;
	}

	private int dec(String element) {
		int ans = 1;
		if(elementCount.containsKey(element)) {
			int count = elementCount.get(element);
			ans = count;
			count--;
			elementCount.put(element, count);
		}
		
		return ans;
	}

	
	/**
	 * Link the to specified elements by a D&D action, assuming a link button was
	 * already pressed.
	 * 
	 * @param element1
	 * @param element2
	 */
	public void linkElements(String element1, String element2) {
		Rectangle l1 = (Rectangle) getElementLocation(element1); 
		Rectangle l2 = (Rectangle) getElementLocation(element2);
		
		//get the middle of the element
		Point p1 = ImageUtils.findMid(l1);
		Point p2 = ImageUtils.findMid(l2);
		logger.fine("Link: "+element1+" - "+element2+" ("+p1+" - "+p2+")");
		
		dragDrop(p1, p2);
	}
	
	/**
	 * Link the to specified elements by the specified link kind.
	 * 
	 * @param linkType
	 * @param element1
	 * @param element2
	 */
	public void linkElements(String linkType, String element1, String element2) {
		//make sure we know where the elements are.
		//these calls are re-done in the method linkElements(String, String)
		getElementLocation(element1); 
		getElementLocation(element2);
		
		//TODO: hack. search for the "Add Elements" toolbar component
		Rectangle elementToolbar = findComponentName("Add Elements");
		logger.finest("Found 'Add Elements': "+elementToolbar);
		
		//use B&W compare here, since some of link arrows are very small, 
		//and similar to other icons (e.g. Dependency and Print; Dependency and Association)
		super.compareState = PixelCompare.BLACK_WHITE;
		super.debugSuccess = true;
		try { 
			
			leftClick(linkType, elementToolbar,true);
		} finally {
			super.debugSuccess = false;
			super.compareState = DEFAULT_PIXEL_COMPARE;
		}
		linkElements(element1, element2);
	}
	
	
	/**
	 * Set the zoom factor to the given percent. This will only be
	 * set for the currently open diagram, and only while it remains open.
	 * 
	 * @param z zoom factor
	 */
	public void zoom(int z) {
		logger.fine("zoom("+z+")");
		
		//find the fit to window button, and move a bit to the left
		try {
			Rectangle r = findIcon("ID_VIEW_ZOOM_FIT_TO_WINDOW");
			r.x -= 70;
			
			//double click and type
			leftClickMid(r);
			leftClick();
			delay(1000);
			typeStringEnter(""+z);
			return;
		} catch(ImageNotFoundException e) {
			logger.info("Could not find ZOOM button. Trying by menu instead. \n"+e);
		}
		
		zoomFromMenu(z,"Zoom");
	}
	
	//Overriding zoomFromMenu for VS
	protected void zoomFromMenu(int z,String...menuitems){
		leftClickMenuItem("View",menuitems );
		assertWindow("Zoom");
		keyType(VK_TAB); delay(500);
		typeStringEnter(""+z);
	}
	
	/**	
	 * This method is different for eclipse, VS and the standard app. 
		It is used in UModelLinkTest to save the project and images generated 
		*/
	
	public String getTestBasename(){
		return "UModel"+File.separator+"UModelLinkTest"+File.separator;
	}
	
	/**
	 * Set the grid size parameter in the Styles pane.
	 * 
	 * @param i grid size in pixels
	 */
	public void setGridSize(int i) {
		setModelTreeSize(PaneSize.WIDE);
		//leftClickString(STYLES);
		scrollPane(STYLES, 1);
		setPaneValue(STYLES, "Diag. Grid Size", ""+i);
	}
	
	@Deprecated
	public void setModelTreeSize(String menuAlignment) {
		setPaneSize(MODEL_TREE, menuAlignment);
	}
	
	/**
	 * Use {@link UModelRobot#setModelTreeSize(PaneSize)} instead.
	 * @Deprecated 
	 * @param paneName
	 * @param menuAlignment
	 */
	@Deprecated 
	private void setPaneSize(Pane paneName, String menuAlignment) {
		Rectangle menu = findString(menuAlignment);
		setPaneSize(paneName, menu.x + menu.width / 2, -1);
	}
	
	public void setModelTreeSize(PaneSize size) {
		setPaneSize(MODEL_TREE, size.getWidth(), 318);
	}
	
	//this method is used in AbstractUmodelRobot to change the width of the panes depending of the app ( eclipse needs a wider one) 
	public void setModelTreeSizeAppDependent(){
		
		setModelTreeSize(PaneSize.WIDE);
	}
	
//	this method is used in UModelLinkTest to change the width of the panes depending of the app ( eclipse needs a wider one) 
	public void setAppropiateModelTreeSizeAppDependent(){
		
		final String smallModelTree = "Project";
		setModelTreeSize(smallModelTree);
	}
	
	//this method is just used in UModelLinkTest by eclipse..so we keep it empty here
	public void makeMessageWindowTinyInEclipse(){
		
	}
	
	//Depending on whether we are working with the app, eclipse or VS, we'd like to open different files or not
	public void openStartProjectAppDependent(String projectname){
		newPrj();
		openPrj(projectname);
		//setGridSize(4);//project loaded has already with this diag grid size
	}
	
	/**
	 * This method is needed in eclipse to disable the automatic synchronization, so that test images
	 *are kept clean. It does not affect,however,the standard application nor VS
	 */
	public void automaticSynchDisablingForEclipse(){
		//this is kept empty for the app and VS
	}
	
	/**
	 * Add a property with the specified signature to the specified element.
	 * @param element name of element as know to this Robot (see ({@link #putElement(String, int, int)}).
	 * @param property signature of new property.
	 */
	public void addProperty(String element, String property) {
		addMemberField(element, property, VK_F7);
	}
	
	/**
	 * Add a operation with the specified signature to the specified element.
	 * @param element name of element as know to this
	 *        UModelRobot (see ({@link #putElement(String,int,int)}).
	 * @param operation signature of new operation (or method, if you like).
	 */
	public void addOperation(String element, String operation) {
		addMemberField(element, operation, VK_F8);
	}
	
	public void addClass(String element, String className) {
		addInternalElement(element, "Class", className);
	}
	
	public void addInternalElement(String element, String type, String className) {
		leftClickElement(element); delay(400);
		rightClick(); delay(500);
		leftClickString("New"); delay(500);
		leftClickString(type); delay(500);
		typeSignature(className);
	}
	
	/**
	 * Adds an operation or property with the specified signature to the specified element. 
	 * 
	 * @param element name
	 * @param signature signature of new field to add
	 * @param keyboardShortcut KeyEvent.VK_F7 for a property or KeyEvent.VK_F8 for an operation 
	 */
	private void addMemberField(String element, String signature, int keyboardShortcut) {
		leftClickElement(element); delay(500);
		keyType(keyboardShortcut); delay(500);
		typeSignature(signature);
	}
	
	public void addOperationReturnValue(String element, String signature, String returnValue) {
		String newSignature = signature + ":" + returnValue;
		changeMemberField(element, signature, newSignature);
	}
	
	/**
	 * Changes the specified field in the specified element.
	 * 
	 * @param element QName of element. See {@link #findModelTreeElement(String)}
	 * @param originalSignature current signature of operation or attribute
	 * @param newSignature new signature
	 */
	public void changeMemberField(String element, String originalSignature, String newSignature) {
		selectMemberField(element, originalSignature);
		keyType(VK_F2);
		typeSignature(newSignature);
	}
	
	public void deleteMemberField( String element, String signature ) {
		selectMemberField(element, signature);
		keyType(VK_DELETE);
	}
	public void deleteElement( String element ) {
		findDiagramElement(element,true);
		keyType(VK_DELETE);
	}
	private void selectMemberField( String element, String signature ) {
		String fixSig = fixMethodSignature(signature);

		findDiagramElement(element,true);
		findDialog(fixSig); delay(800);
	}

	public void renameClass( String className, String newName ) {
		throw new ScriptMistakeException("not implemented yet");
	}
	
	public void renameElement( String qname, String newName ) {
		findModelTreeElement(qname,true);
		setPaneValue(PROPERTIES, "name", newName);
		escapeDialog("Also rename all operations with this name", VK_Y);
	}
	
	
	/**
	 * Work around for TTP # 17864
	 * 
	 * @param signature
	 * @return
	 */
	private String fixMethodSignature(String signature) {
		//is it a method signature? - search for brackets
		int open = signature.indexOf("(");
		int close = signature.indexOf(")", open);
		if(open == -1 || close == -1) {
			return signature;
		}
		
		//get out the argument list and split it
		String argList = signature.substring(open+1, close);
		String args[] = argList.split(",");
		
		//insert the "in" modifier in front of each argument
		String newList = "";
		for (int i = 0; i < args.length; i++) {
			//only add a comma if there are more arguments left
			newList += ((args[i].indexOf("in ") != 0)?"in ":"")
					+ args[i] 
					+ ((i<args.length-1)?", ":"");
		}
		
		//now replace the arguments bit
		return signature.replaceAll(argList, newList);
	}
	
	/**
	 * Types in a new signature, taking the necessary delays into account.
	 * 
	 * @param signature signature to type
	 */
	private void typeSignature(String signature) {
		typeString(signature); delay(2000);
		delay(signature.length()*100);
		waitForIdle();
		keyType(VK_ENTER); delay(1500);
		keyType(VK_ENTER); delay(500);
	}
	
	/**
	 * Sets the value of specified modifier in the specified element. 
	 * 
	 * @param element QName of element. See {@link #findModelTreeElement(String)}
	 * @param modifier field value of modifier, as it appears in the Properties window
	 * @param value new value of modifier or property
	 */
	public void setModifier(String element, String modifier, String value) {
		findModelTreeElement(element,true);
		
		setPaneValue(PROPERTIES, modifier, value);
		if(value.compareToIgnoreCase("true") == 0 ||
		   value.compareToIgnoreCase("false") == 0) {
			keyType(VK_SPACE);
		}
	}

	/**
	 * Select the specified elements in the current diagram.
	 * 
	 * @param elements arg list of elements to select, by names as known
	 *        to this UModelRobot (see ({@link #putElement(String,int,int)}). 
	 */
	public void select(String... elements) {
		List<Rectangle> locations = new ArrayList<Rectangle>();
		for(String e : elements) {
			locations.add(getElementLocation(e));
		}
		
		keyPress(VK_CONTROL);
		for(Rectangle location : locations) {
			leftClickMid(location); delay(100);
		}
		keyRelease(VK_CONTROL);
	}
	
	/**
	 * Deselect all elements in the current diagram.
	 *
	 */
	public void deselectAll() {
		//Deselect all elements in the current diagram by putting out
		//a note and then deleting it. We don't use the putElement()
		//method for this, since it is slightly expensive for a 2-seconds
		//element
		
		//select the diagram (we can't hit the Note icon, unless
		//the diagram is selected)
		activateDiagram();
		
		//click the element icon on the toolbar
		/*
		try {
			leftClick("Note");
			//put in the middle of the diagram
			leftClick(600, 400);
			
			keyType(VK_ENTER); delay(500);
			keyType(VK_DELETE); delay(1000);
		} catch(ImageNotFoundException e) {
			//ignore the deselect if no diagrams where open anyway
			logger.fine("Note icon note found - probably, no diagrams where open");
		}
		*/
	}
	
	public void activateDiagram() {
		ComponentInfo diagram = getDiagramComponent();
		if(diagram==null) {
			logger.warning("No diagrams seems to be open.");
		}
		else{
			Rectangle d = diagram.getLocation();
			Point p = new Point(d.x+5, d.y+5);
			leftClick(p);
			return;
		}
	}
	

	/**
	 * Tries to find the specified element in any diagram, and if it does not
	 * exist on any, but in the Model Tree, it is pulled out onto the diagram. 
	 * 
	 * @param qname
	 * @return the location of the element in the now currently open diagram. 
	 */
	public Rectangle findDiagramElement(String qname,boolean check) {
		
		deselectAll();
		Rectangle element = leftClickModelTreeElement(qname,check);
		
		ComponentInfo diag = getDiagramComponent();
		Rectangle location = null;
		if (diag != null) {
			ScreenDiff diff = new ScreenDiff(this);
			activatePane(MODEL_TREE);
			delay(1000);
			diff.snapBefore(diag.getLocation());
			logger.fine("Pressing F4 to select component");
			keyType(VK_F4);
			delay(1000);
			diff.snapAfter();
			// check if we have a hit
			location = diff.diffBounds();
		}

		if (location == null) {
			// probably the diagram was not open, so let's open it
			leftClickMid(element);
			delay(500);
			rightClick();
			delay(1000);
			leftClickString("Show element in all diagrams");
			delay(5000);
			escapeDialog("No diagram shows this element", VK_ENTER);
			if(this instanceof EclipseRobot) {
				((EclipseRobot)this).escapePluginDialogs("Escape perspective dialog");
				waitAndEsacpe("Escape perspective dialog");
			}
			
			deselectAll();
			leftClickModelTreeElement(qname,check);
			ScreenDiff diff = new ScreenDiff(this);
			diff.snapBefore(getMainWindow());
			logger.info("Pressing F4 to select component");
			keyType(VK_F4);
			diff.snapAfter();

			location = diff.diffBounds();

			if (location == null) {
				logger.info("The element " + qname + " was not found on any diagram. Let's try to pull it out");
				location = dropElementOnDiagram(qname, null);

				if (location == null) {
					throw new ScriptMistakeException("Could not move element " + qname + " on to the diagram.");
				}
			}

		}

		// save the location
		if (location != null) {
			elements.put(qname, location);
		}
		logger.finer("The element was found in the diagram at: " + location);

		return location;
	}
	
	public Rectangle dropElementOnDiagram(String qname, int x, int y) {
		return dropElementOnDiagram(qname, new Point(x, y));
	}
	
	public Rectangle dropElementOnDiagram(String qname, Point p) {
		deselectAll();
		Rectangle element = findModelTreeElement(qname,true);
		
		Rectangle area = getMainWindow(); 
		ScreenDiff diff = new ScreenDiff(this);
		diff.snapBefore(area);

		if(p == null) {
			p = ImageUtils.findMid(area);
		}
		
		dragDrop( ImageUtils.findMid(element), p);
		delay(500);
		diff.snapAfter();
		
		Rectangle location = diff.diffBounds();
		logger.finest("Location of new element in diagram: "+location);
		if(location != null) {
			elements.put(qname, location);
		}
		return location;
	}
	
	public void moveElement(String qname, int x, int y) {
		moveElement(qname, new Point(x, y));
	}
	
	public void moveElement(String qname, Point to) {
		Rectangle element = findDiagramElement(qname,true);
		Point from = findMid(element);
		logger.finest("Move element from/to: \n"+from+"\n"+to);
		dragDrop(from, to);
		elements.remove(qname);
	}
	
	
	public void scrollPaneRowSplitter(Pane pane, double position) {
		Rectangle r = activatePane(pane);
		Rectangle splitter = findPaneRowSplitter(r);
		
		Point from = new Point(splitter.x, splitter.y);
		Point to = new Point( (int)(r.x+((double)r.width)*position), splitter.y);
		dragDrop(from, to);
	}
	
	public void checkMessageWindow() {
		String msg = getMessageWindowText(MESSAGES);
		
		if(msg == null) {
			logger.warning("Could not get text from the message window");
			return;
		}
		
		//split the message line by line
		String split[] = msg.split("\n");
		for(String line : split) {
			//see if there were any errors
			if( line.matches(".*[1-9] error.*") ) {
				throw new ApplicationErrorException("Errors where detected in the UModel message window: \n\n"+msg+"\n\n");
			}
		}
	
		logger.finest("No errors detected in message window");
	}

	public void turnOffDiagramJunk() {
		clickDiagramContext("Show Grid");
		clickDiagramContext("Snap to Grid");
		clickDiagramContext("Show UML Diagram Heading");
	}
	
	private void clickDiagramContext(String item) {
		Rectangle d = getMainWindow();
		Point p = new Point(d.x+5, d.y+5);
		logger.finest("Click in the top left hand corner of the diagram: "+p);
		rightClick(p); delay(500);
		try {
			leftClickString(item);
		} catch (ImageNotFoundException e) {
			logger.warning("Could not find diagram context menu item: "+item+"\n "+e);
		}
	}
	
	/**
	 * Unzips the OrgChart.zip file. Should probably make this more general...
	 * but for now it's only used in the tutorial
	 * @return The path to the unzipped stuff
	 *
	 */
	public File unzipOrgChart() {
		File exampleDir = AltovaApplication.UMODEL.getExamplesLocation();
		File orgChart = IOUtils.findFile(exampleDir, "OrgChart.zip");
		RegressionAssert.assertFileExists(orgChart);
		File ans = new File(exampleDir, "OrgChart");
		IOUtils.deleteAll(ans);
		runCommand("unzip \""+orgChart+"\" -d \""+exampleDir+"\"");
		RegressionAssert.assertFileExists(new File(ans, "com\\OrgChart\\ipo\\Address.java"));
		
		return ans;
	}
	
	public void escapeDialogUmodel(String text, Integer... key){
		escapeDialog(text, key);
	}
	
	public void assertWindowUModel(String text){
		assertWindow(text);
	}
	
	public void activateDiagramTreePane(){
		
		activatePane(MODEL_TREE);
	}
	
	
	//-------------------------------------------------------------------
	//--------------------------  CUSTOMIZE Methods ---------------------
	//-------------------------------------------------------------------	
	
	public void customizeKeyboard(String category, String commands, int vkT) throws Exception{
		
		customize();
		try {
			
			DropDownOption cat = new DropDownOption("Category", true, category, null, null, null, "Keyboard", MS_SHELL_DLG_FONT);
			cat.applyOption(this);
		
			Rectangle reset = findComponent("Re&set All","Button",NativeGUI.getForegroundWindowInfo().getLocation());
			leftClickMid(reset);
			escapeDialog("All your changes will be lost!", VK_Y);
		
			Rectangle keyboardFrame = findComponentName("Keyboard");
		
			for (double sc = 0; sc <= 1; sc += 0.25) {
	   		
				Rectangle comm = findString(commands, MS_SHELL_DLG_FONT, keyboardFrame, false);
				if (comm!=null){
					leftClickMid(comm);
					break;
				}
				scrollWindow(keyboardFrame, sc);	
			}//for

			TextFieldOption shortcut = new TextFieldOption("Press New Shortcut Key", true, "", null, null, null, "Keyboard", MS_SHELL_DLG_FONT);
			shortcut.applyOption(this);
	   	
			keyTypeCtrl(vkT);
			delay(2000);
			
			Rectangle assign = findComponent("&Assign","Button",NativeGUI.getForegroundWindowInfo().getLocation());
			leftClickMid(assign);
			delay(2000);
	   	
			Rectangle close = findComponent("Close","Button",NativeGUI.getForegroundWindowInfo().getLocation());
			leftClickMid(close);
			delay(10000);
		
		} catch (Exception e) {
			keyType(VK_ESCAPE);
			delay(2000);
			throw new Exception("Error during GUI customization:" + e.toString());
		}

	}

	
	//---------------------------------------------------------------------------------------
	//-----------------------------     Plugin related  methods -----------------------------
	//---------------------------------------------------------------------------------------
	

	public Rectangle findSourceCode(String string) {
		return findString(string, SOURCE_CODE_FONT);
	}
	
	public Rectangle findSourceCodeLineNumber(int line) {
		return findString(""+line, SOURCE_CODE_LINENUMBER_FONT, Color.WHITE, getLineNumberColor());
	}

	protected Color getLineNumberColor() {
		return Color.BLACK;
	}
	
	
	public void deleteProjectsInEclipseAfterTest(){
		//do nothing, as this method is just relevant for the eclipse plugin
	}

}
