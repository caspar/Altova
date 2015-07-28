package com.altova.authentic;

import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.VK_CANCEL;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_F3;
import static java.awt.event.KeyEvent.VK_N;
import static java.awt.event.KeyEvent.VK_TAB;
import static java.awt.event.KeyEvent.VK_Y;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import com.altova.nativegui.NativeGUI;
import com.altova.robots.AltovaApplicationRobot;
import com.altova.robots.ApplicationErrorException;
import com.altova.robots.CheckboxOption;
import com.altova.robots.ImageUtils;
import com.altova.robots.Options;
import com.altova.robots.PluginRobot;
import com.altova.robots.ScreenDiff;
import com.altova.robots.ScriptMistakeException;
import com.altova.robots.TextFieldOption;
import com.altova.util.Settings.AltovaApplication;
import com.altova.util.Settings.ApplicationSettings;

/**
 * Robot class specifically for Authentic.
 * 
 * @author Havard Rast Blok
 *
 */
public class AuthenticRobot extends AltovaApplicationRobot {

	private static final String BASEPATH = "authentic/";
	
	private final static String[] toolbarIds = {
		"IDR_MAINFRAME",
		"IDT_SOURCE_CONTROL",
		"IDT_MENU_ICONS2",
		"IDT_MENU_ICONS",
		"IDT_BROWSER",
		"IDT_CONTENT",
		"IDT_TEXTSTATE",
		"IDT_PROJECT",
		"IDT_TEXT_VIEW",
		"IDT_XML_TABLE",
	};

	
	public AuthenticRobot() {
		this("Altova Authentic",AltovaApplication.AUTHENTIC,"Authentic Desktop");
	}
	
	 protected AuthenticRobot(String appname,ApplicationSettings app,String appRegKey){
		 super(appname, app, appRegKey,BASEPATH+"XMLSpy_Commands_RC_Authentic.rc", toolbarIds);
			logger.fine("Created robot "+getClass().getName());
			addSettingsRegistryKey(	"LastStates", "Recent File List", "URL","Recent Project List", "Settings","UI_D2008r2sp1_English","UI_D2009_English","UI_D2009sp1_English");
	 }

	@Override
	public void exitApplication() {
		exitWithuotSave();
	}
	
	public void exitWithuotSave() {
		int ignoreOld = ignorePixels;
		ignorePixels = 0;
		leftClickMenuItem("File", "Exit  "); delay(1000);
		ignorePixels = ignoreOld;

		escapeGeneralDialogs("Waiting while escaping exit dialogs");
		delay(5000);
	}
	
	protected void escapeGeneralDialogs(String message) {
		boolean fail;
		fail = escapeDialog("An error occurred loading", VK_ESCAPE);
		fail |= escapeDialog("File not found", VK_ESCAPE);
		fail |= escapeDialog("was unable to open", VK_ESCAPE);
		if(fail) {
			String msg = "Failed to open or save the specified file. Please see log for more details.";
			logger.severe(msg);
			throw new ApplicationErrorException(msg);
		}
		
		addEscapeDialogAction("Save changes to", VK_N);
		addEscapeDialogAction("already exists", VK_Y);
		addEscapeDialogAction("Confirm Save As", VK_Y);
		addEscapeDialogAction("Do you want to save Project modifications", VK_N );
		addEscapeDialogAction("you want to convert this item?",VK_ENTER);
		waitAndEsacpe(message);
	}
	
//	---------------------------------------------------------------------------------------
	//-----------------------------               FILE MENU     -----------------------------
	//---------------------------------------------------------------------------------------
	
	// For common File menu functions, see AltovaApplicationRobot

	public void newAuthenticFile(String filename){
		leftClick("ID_FILE_NEW");delay(1000);
		assertWindow("Create new document");
		Rectangle newdocwindow=NativeGUI.getForegroundWindowInfo().getLocation();
		leftClickMid(findComponent("Browse", "Button", newdocwindow));
		delay(1000);
		assertWindow("Open");
		typeStringEnter(filename);
		delay(2000);
	}
	
	public void openFile(File file) {
		checkFile(file.getAbsolutePath());
		leftClick("ID_FILE_OPEN");delay(1000);
		typeStringEnter(file.getAbsolutePath()); delay(3000);
		maximizeFileWindow();
	}
	
	public void openFileWithoutKnownSPS(File file){
		checkFile(file.getAbsolutePath());
		leftClick("ID_FILE_OPEN");delay(1000);
		typeStringEnter(file.getAbsolutePath()); delay(3000);
		escapeDialog("Your license only allows you to edit files in Authentic view.",VK_ENTER);
		maximizeFileWindow();
	}
	
	/** Reloads the active file; escapes any dialogs.
	 *
	 */
	public void reloadFile() {
		leftClickMenuItem("File", "Reload");
		escapeDialog("reload this file", VK_Y);
	}
	
	public void setEncoding(String encoding) {
		leftClickMenuItem("File", "Encoding");
		assertWindow("Encoding");
	}
	
	/**
	 * Closes the active file; escapes any dialogs.
	 *
	 */
	public void closeFile() {
		leftClickMenuItem("File", "Close");
		escapeGeneralDialogs("Waiting while closing file");
	}
	/**
	 * Closes all open files; escapes any dialogs.
	 *
	 */
	public void closeAll() {
		leftClickMenuItem("File", "Close All");
		escapeGeneralDialogs("Waiting while closing all files");
	}
	
	public void closeAllSaveNoChanges(int numfiles){
		leftClickMenuItem("File", "Close All");	
		delay(500);
		for (int i = 0; i < numfiles; i++) {
			escapeDialog("Save changes",KeyEvent.VK_N);
			delay(500);
		}
		
	}
	
	/**
	 * Simplest "save as";does not control dialog escaping 
	 * to make it faster
	 * @param name the path/filename to save to
	 */
	public void saveFileAsNoControl(String name) {
		leftClickMenuItem("File", "Save As");
		delay(500);
		typeStringEnter(name);
		delay(5000);		
	}
	
	/**
	 * Simplest "save as";does not control dialog escaping 
	 * to make it faster
	 * @param name the path/filename to save to
	 */
	public void saveFileAs(String name) {
		leftClickMenuItem("File", "Save As");
		delay(500);
		typeStringEnter(name);
		delay(5000);
		escapeDialog("Confirm Save As", VK_Y);
	}
	
//	---------------------------------------------------------------------------------------
	//-----------------------------               EDIT MENU     -----------------------------
	//---------------------------------------------------------------------------------------
	
	// For common EDIT menu functions, see AltovaApplicationRobot
	
	public void findNext() {
		logger.fine("Find next - by pressing F3");
		leftClickMenuItem("Edit", "Find Next"); delay(300);
	}
	
	/**
	 * Uses the Find dialog to search for the specified word in the active document;
	 * escapes various dialogs, also the Find dialog.
	 * @param word the string to search for in the active file.
	 */
	public void find(String word){
		leftClickMenuItem("Edit","Find");
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
	
	public void findDialog(String word, boolean wholewrdonly, boolean casesens, boolean ifnegtest) {
		leftClick("ID_EDIT_FIND");
		delay(500);
		assertWindow("Find");

		// set the Find options
		Options options = new Options();
		options.add(new TextFieldOption("Find what", word));
		options.add(new CheckboxOption("Match whole", wholewrdonly));
		options.add(new CheckboxOption("Match case", casesens));
		options.applyOption(this);

		leftClickMid(findComponent("next", "Button", NativeGUI.getForegroundWindowInfo().getLocation()));
		delay(1000);

		boolean ifescaped = escapeDialog("Finished searching the document.", VK_ESCAPE);
		if (!ifnegtest && ifescaped) {
			throw new ScriptMistakeException("The string '" + word + "' could not be found");
		}

		if (NativeGUI.getForegroundWindowInfo().getWindowText().equalsIgnoreCase("Find")) {
			leftClickMid(findComponent("Cancel", "Button", NativeGUI.getForegroundWindowInfo().getLocation()));
		}

	}
	
	public void replaceOnce(String toFind, String toReplace) {
		leftClickMenuItem("Edit","Replace");
		removeTextfieldText();
		typeString(toFind);
		keyType(VK_TAB);
		removeTextfieldText();
		typeStringEnter(toReplace);
		Rectangle replaceAllButton = findComponent("Replace", "Button", null);
		leftClickMid(replaceAllButton);
		escapeDialog("Finished searching the document",VK_ENTER);
		escapeDialog("Replaced",VK_ENTER);
		escapeDialog("The search item was not found",VK_ENTER);
		escapeDialog("Replace", VK_ESCAPE);
	}
	
	public void replaceAll(String toFind, String toReplace) {
		leftClickMenuItem("Edit","Replace");
		removeTextfieldText();
		typeString(toFind);
		keyType(VK_TAB);
		removeTextfieldText();
		typeString(toReplace);
		Rectangle replaceAllButton = findComponent("All", "Button", null);
		leftClickMid(replaceAllButton);
		escapeDialog("Finished searching the document",VK_ENTER);
		escapeDialog("replacements have been made",VK_ENTER);
		escapeDialog("The search item was not found",VK_ENTER);
		escapeDialog("Replace", VK_ESCAPE);
	}
	
	//---------------------------------------------------------------------------------------
	//-----------------------------               PROJECT MENU  -----------------------------
	//---------------------------------------------------------------------------------------

	
	protected void escapeProjectDialogs() {
		escapeDialog("Do you want to save Project modifications", VK_N );
		escapeDialog("Do you wish to automatically close all open documents that belong to this project", VK_N);
	}
	
	
	/**
	 * Opens the specified Spy project; escapes dialogs.
	 * @param name the path/name of the project file.
	 */
	public void openProject(String name) {
		leftClickMenuItem("Project", "Open Project");
		typeStringEnter(name);
		escapeProjectDialogs();
	}
	
	/**
	 * Reloads the active Spy project, discarding any changes.
	 *
	 */
	public void reloadProjectDiscard() {
		leftClickMenuItem("Project", "Reload Project");
		escapeProjectDialogs();
	}
	
	/**
	 * Closes the active project, but not the open files.
	 *
	 */
	public void closeProjectOnly() {
		leftClickMenuItem("Project", "Close Project");
		escapeProjectDialogs();
	}
	
	/**
	 * Adds the specified URL to the active project.
	 * @param url URL to add.
	 */
	public void addUrlToProject(String url) {
		leftClickMenuItem("Project", "Add URL to Project");
		assertWindow("Add URL to project");
		typeStringEnter(url);
	}
	
	/**
	 * Adds a new folder to the active project.
	 * @param name virtual name of folder 
	 */
	public void addProjectFolderToProject(String name) {
		leftClickMenuItem("Project", "Add Project Folder to Project");
		assertWindow("Properties");
		typeStringEnter(name);
	}
	
	/**
	 * Adds the specified URL to the active project.
	 * @param url the URL to add
	 */
	public void addExternalWebFolderToProject(TextFieldOption serv,TextFieldOption usr,TextFieldOption pwd) {
		leftClickMenuItem("Project", "Add External Web Folder to Project");
		assertWindow("Add Web Folder to Project");
		if (usr != null) {
			usr.applyOption(this);
		}
		if (pwd != null) {
			pwd.applyOption(this);
		}
		serv.applyOption(this);
		keyType(VK_TAB);delay(500);
		keyType(VK_ENTER);delay(1000); //pressing the browse button
		keyType(VK_DOWN); //selecting the folder
		Rectangle URLWind = NativeGUI.getForegroundWindowInfo().getLocation();
		leftClickMid(findComponent("Open", "Button", new Rectangle(URLWind.x,URLWind.y+URLWind.height/2,URLWind.width,URLWind.height/2)));
		
	}	
	
	
	//-------------------------------------------------------------------------------------
	//-----------------------------    XML MENU  -----------------------------------------
	//-------------------------------------------------------------------------------------

	public void XMLCheckWellFormedness(){
		leftClickMenuItem("XML","Check Well-Formedness");
		
	}

	public void validate(){
		leftClickMenuItem("XML","Validate");
		
	}
	
	public void wellformednessCheckViaIcon(){
		leftClick("IDC_CHECK_WELL_FORM");
	}
	
	public void validateViaIcon(){
		leftClick("IDC_VALIDATE");
	}
	
    //-------------------------------------------------------------------------------------
	//-----------------------------    XSL MENU  -----------------------------------------
	//-------------------------------------------------------------------------------------

	public void xslTransformation(String xslfile) {
		
		leftClickMenuItem("XSL/XQuery", "XSL Transformation");
		delay(1000);
		assertWindow("Please choose an XSL file");
		Rectangle forwind=NativeGUI.getForegroundWindowInfo().getLocation();
		Rectangle choosefile=findComponent("Choose a file", "Button",forwind);
		leftClick(choosefile.x+30,choosefile.y+20);
		typeStringEnter(" "+xslfile);
	}
	
	public void xslParameters() {
		leftClickMenuItem("XSL/XQuery", "XSL Parameters");
		assertWindow("XSLT Input Parameters/XQuery External Variables");
		
	}
	
	//---------------------------------------------------------------------------------------
	//-----------------------------  AUTHENTIC MENU  ----------------------------------------
	//---------------------------------------------------------------------------------------

	   public void newAuthenticDocument() {
			leftClickMenuItem("Authentic", "New Document");
		}

		public void editDatabaseData() {
			leftClickMenuItem("Authentic", "Edit Database Data");
		}

		public void assignSVStylesheet(String SPSAssigned) {
			leftClickMenuItem("Authentic", "Assign a StyleVision Stylesheet");
			escapeDialog("will have to parse your XML text", VK_ENTER);
			chooseFileDialog(SPSAssigned);
		}
		
		public void chooseFileDialog(String filename){
		Rectangle forwind=NativeGUI.getForegroundWindowInfo().getLocation();
		Rectangle choosefile=findComponent("Choose a file", "Button",forwind);
		leftClick(choosefile.x+30,choosefile.y+20);
		typeStringEnter(" "+filename);
		}

		public void editSVStylesheet() {
			leftClickMenuItem("Authentic", "Edit StyleVision Stylesheet");
		}

		public void hideMarkup() {
			leftClickMenuShortcut("Authentic","View Markup","Hide markup");
		}

		public void showSmallMarkup() {
			leftClickMenuShortcut("Authentic","View Markup","Show Small markup");
		}

		public void showLargeMarkup() {

			leftClickMenuShortcut("Authentic","View	 Markup", "Show Large markup");

			leftClickMenuItem("Authentic","View Markup", "Show Large markup");

		}
		public void showMixedMarkup() {
			leftClickMenuShortcut("Authentic","View Markup","Show Mixed markup");
		}
		
		public void authenticAppendRow() {
			leftClickMenuItem("Authentic", "Append Row");
			delay(1000);
		}
		
		public void authenticInsertRow() {
			leftClickMenuItem("Authentic", "Insert Row");
			delay(1000);
		}
		
		public void authenticDuplicateRow() {
			leftClickMenuItem("Authentic", "Duplicate Row");
			delay(1000);
		}
		
		public void authenticMoveRowUp() {
			leftClickMenuItem("Authentic", "Move Row Up");
			delay(1000);
		}
		
		public void authenticMoveRowDown() {
			leftClickMenuItem("Authentic", "Move Row Down");
			delay(1000);
		}
		
		public void authenticDeleteRow() {
			leftClickMenuItem("Authentic", "Delete Row");
			delay(1000);
		}
	
		//---------------------------------------------------------------------------------------
		//-----------------------------               VIEW MENU  --------------------------------
		//---------------------------------------------------------------------------------------
		
		public void authenticView() {
			leftClickMenuItem("View", "Authentic view");
		}
		
		public void authenticViewKey(){
			keyTypeAlt(KeyEvent.VK_V); //access to view menu
			keyType(KeyEvent.VK_A);//switch to authentic view
		}
		
		public void browserView() {
			leftClickMenuItem("View","Browser view");
		}
		
		public void browserViewKey(){
			keyTypeAlt(KeyEvent.VK_V); //access to view menu
			keyType(KeyEvent.VK_B);//switch to browser view
		}
		
		public void textViewSettings(Options options){
			leftClickMenuItem("View", "Text View Settings");
			delay(500);
			applyOptionsEnter("Text View Settings", options);
		}
		
		//---------------------------------------------------------------------------------------
		//-----------------------------    BROWSER MENU  ----------------------------------------
		//---------------------------------------------------------------------------------------
		
		public void browserBack() {
			leftClickMenuItem("Browser", "Back");
		}	
		public void browserForward() {
			leftClickMenuItem("Browser", "Forward");
		}
		public void browserRefresh() {
			leftClickMenuItem("Browser", "Refresh");
		}
		
		public void browserFonts(String size) {
			leftClickMenuItem("Browser", "Fonts",size);
		}
		
		public void browserSeparateWindow() {
			leftClickMenuItem("Browser", "Separate Window");
		}
		
		/**
		 * 
		 * @param word
		 * @return Rectangle selected currently on the screen
		 */
		public Rectangle findSelection(String word){
			ScreenDiff diff = new ScreenDiff(this);
			diff.snapBefore(getMainWindow());
			find(word); delay(1000);
			diff.snapAfter();
			
			//check if we have a hit
			Rectangle location = diff.diffBoundsSelection();
			try {
				ImageUtils.saveImage(diff.diffMarks(), "debug_findSelection", true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.finest("Location of selection:"+location);
			return location;
		}
//		---------------------------------------------------------------------------------------
		//-----------------------------    TOOLS MENU  ----------------------------------------
		//---------------------------------------------------------------------------------------
		
		public void spelling() {
			leftClick("IDC_SPELL_CHECK");
			delay(500);
			assertWindow("Spelling");
		}
		public void spellingOptions() {
			leftClickMenuItem("Tools", "Spelling Options");
			delay(500);
			assertWindow("Spelling Options");
		}
		
		public void customize() {
			leftClickMenuItem("Tools", "Customize");
			assertWindow("Customize");
		}
		
		//---------------------------------------------------------------------------------------
		//-----------------------------  HELP MENU  ---------------------------------------------
		//---------------------------------------------------------------------------------------
		
		public void keyboardMap() {
			leftClickMenuItem("Help","Keyboard Map");
		}

		public void webTraining() {
			leftClickMenuItem("Help","Authentic Training");
		}
		
		public void webAuthentic() {
			super.applicationOnWeb();
		}
		
		public void aboutAuthentic() {
			super.aboutApplication();
		}
		
		//RichEdit methods
		
		private void setColorsWindow(File paletteIcon){

			assertWindow("Colors");
			
			leftClickMid(findImage(paletteIcon.getAbsolutePath(), findComponentName("Colors"), false));
			delay(500);
			keyType(VK_ENTER);
			delay(500);
		}
		
		public void toggleBold() {
			leftClickMenuItem("Authentic", "RichEdit", "Toogle Bold");
			
		}

		public void toggleItalic() {
			leftClickMenuItem("Authentic", "RichEdit", "Toogle Italic");
			
		}

		public void toggleUnderline() {
			leftClickMenuItem("Authentic", "RichEdit", "Toogle Underline");
			
		}

		public void toggleStrikeThrough() {
			leftClickMenuItem("Authentic", "RichEdit", "Toogle Strikethrough");
			
		}

		public void foregroundColor(File paletteIcon) {
			
			leftClickMenuItem("Authentic", "RichEdit", "Foreground Color");
			setColorsWindow(paletteIcon);
			
		}

		public void backgroundColor(File paletteIcon) {
			leftClickMenuItem("Authentic", "RichEdit", "Background Color");
			setColorsWindow(paletteIcon);
			
		}

		public void alignLeft() {
			leftClickMenuItem("Authentic", "RichEdit", "Align Left");
			
		}

		public void alignCenter() {
			leftClickMenuItem("Authentic", "RichEdit", "Center");
			
		}

		public void alignRight() {
			leftClickMenuItem("Authentic", "RichEdit", "Align Right");
			
		}

}
