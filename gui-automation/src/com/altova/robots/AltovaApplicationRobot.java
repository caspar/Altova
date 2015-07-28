package com.altova.robots;


import static com.altova.robots.SnapshotArea.CommonArea.*;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.FULLSCREEN;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.ZIP_VIEW;
import static com.altova.robots.SnapshotArea.CommonArea.SCHEMA_ATTRIBUTES;
import static com.altova.robots.SnapshotArea.CommonArea.PRJ_WINDOW_MAPFORCE;
import static com.altova.robots.SnapshotArea.CommonArea.MF_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.ALLSTYLES_SV;


import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.altova.authentic.AuthenticRobot;
import com.altova.databasespy.DatabaseSpyRobot;
import com.altova.diffdog.DiffDogRobot;
import com.altova.mapforce.EclipseMapForceRobot;
import com.altova.mapforce.MapForceRobot;
import com.altova.nativegui.ComponentInfo;
import com.altova.nativegui.NativeGUI;
import com.altova.schemaagent.SchemaAgentRobot;
import com.altova.semanticworks.SemanticWorksRobot;
import com.altova.spy.SpyRobot;
import com.altova.stylevision.StyleVisionRobot;
import com.altova.umodel.regression.gui.EclipseUModelRobot;
import com.altova.umodel.regression.gui.UModelRobot;
import com.altova.umodel.regression.gui.VSnetUModelRobot;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.ClipboardUtils;
import com.altova.util.IOUtils;
import com.altova.util.Settings;
import com.altova.util.Settings.AltovaApplication;
import com.altova.util.Settings.ApplicationSettings;

/**
 * Robot specialised for the Altova applications (but also some general Windows applications).
 * It contains auxiliary and GUI methods common to all the specific application robots.
 * 
 * @author Havard Rast Blok
 *
 */
public abstract class AltovaApplicationRobot extends ApplicationRobot {

	protected AltovaApplication product;
	
	protected String appRegKey;
	
	protected List<String> settingsRegKeys = new ArrayList<String>();
	
	/** If true, only find reflected methods, don't run them. {@link AltovaApplicationRobot#runCommands(String, String[])} */
	private static boolean dryRun = false;
	
	/** Map of the product names and their associated robot classes **/ 
	private static Map<String, Class<? extends AltovaApplicationRobot>> products = new HashMap<String, Class<? extends AltovaApplicationRobot>>();
	
	static {
		products.put("umodel", UModelRobot.class);
		products.put("stylevision", StyleVisionRobot.class);
		products.put("xmlspy", SpyRobot.class);
		products.put("spy", SpyRobot.class);
		products.put("diffdog", DiffDogRobot.class);
		products.put("mapforce", MapForceRobot.class);
		products.put("databasespy", DatabaseSpyRobot.class);
		products.put("authentic", AuthenticRobot.class);
		products.put("schemaagent", SchemaAgentRobot.class);
		products.put("semanticworks", SemanticWorksRobot.class);
	}
	
	private static final String ALTOVA_BASE_REGISTRY_KEY = "HKEY_CURRENT_USER\\Software\\Altova\\";
	
	/**
	 * change for private final String COMMON_PATH =
	 * "CVSROOT/gui-automation/data/all/"; when running ProjectTestcasesSuite*
	 */
	
	private final String COMMON_PATH = "all"; 
	//private final String COMMON_PATH = "C:/work/gui-automation/data/all";
	
	private final static String[] MESSAGE_WINDOW_ICONS = {
		"IDB_OUTPUT_COPYLINE",
		"IDB_OUTPUT_COPYALL",
		"IDB_OUTPUT_COPYCHILD",
		"IDB_OUTPUT_CLEAR",
		"IDB_OUTPUT_NEXT",
		"IDB_OUTPUT_FILTER",
		"IDB_OUTPUT_PREV",
		"IDB_OUTPUT_FINDNEXT",
		"IDB_OUTPUT_FIND",
		"IDB_OUTPUT_FINDPREV",
		"IDB_OUTPUT_COPYSUBLINE",
		"IDT_GUI_FONT_SETTINGS",
	};
	
	private List<ResourceFileReader> readers = new ArrayList<ResourceFileReader>();
	
	Map<String, Rectangle> previousHits = new HashMap<String, Rectangle>();
	
	protected static final File HIDE_SMART_FIX_ICON = IOUtils.findFile("common/hideSmartFix.png");
	
	/**
	 * Constructs an {@code AltovaApplicationRobot} for a specific application.
	 * 
	 * @param appName the name of the application, as shown in the taskbar 
	 * 				 (for Altova applications, do not include 'Altova' in this string).  
	 * @param appPath the installation path of the application, where the {@code appExe} is found.
	 * @param appExe the name of the EXE file to start the application (not the full path)
	 * @param appRegKey the last part of the registry key name used for the application
	 */
	protected AltovaApplicationRobot( String appName, ApplicationSettings product, String appRegKey, String resourceFile, String toolbarIds[]) {
		super(appName, product.getInstallLocation(), product.getDefaultExe());
		this.appRegKey = appRegKey;
		addReader(resourceFile, toolbarIds);
		addReader(COMMON_PATH+"/libs/icgui/ICGUI.rc", MESSAGE_WINDOW_ICONS, true);

	}

	protected void addSettingsRegistryKey(String... key) {
		for(String k : key) {
			settingsRegKeys.add(k);
		}
	}
	
	public void openFile(File filename){
		openFile(filename.getAbsolutePath());
	}
	
	public void openFile(String filename){
		leftClickMenuItem("File", "Open");
		delay(2000);
		assertWindow("Open");
		typeStringEnter(filename);
		delay(500);
		keyPress(VK_ESCAPE);
		//maximizeFileWindow(); was necessary in some cases (? Spy?) but doesn´t  work in UModel
	}
	
	public void maximizeFileWindow() {
		Rectangle r = getMainWindow();

		for (int i = 10; i <= 25; i += 15) {
			Point p = new Point(r.x, r.y - i);
			Rectangle window = NativeGUI.getWindowInfo(p.x, p.y).getLocation();
			
			if (window.contains(r)) {
				logger
						.finest("Found outer bounds of file window and try to maximize: "
								+ window);
				clickMaximize(p, window);
			} else {
				logger
						.finest("Did not find outer bounds of file window. Inner window: "
								+ r + ", left top corner: " + window);
			}
		}
	}
	
	/**
	 * Opens the specified URL.
	 * @param url full URL
	 */
	public void openURL(TextFieldOption usr,TextFieldOption pwd,TextFieldOption serv,TextFieldOption URLfile,RadioOption fileLoad,RadioOption openAs) {
		accessURL(usr,pwd,serv,URLfile,fileLoad,openAs);
		Rectangle URLWind = NativeGUI.getForegroundWindowInfo().getLocation();
		leftClickMid(findComponent("Open", "Button", new Rectangle(URLWind.x,URLWind.y+URLWind.height/2,URLWind.width,URLWind.height/2)));
		
		if (null!=findComponentName("Open SPS design")){			
			Options op = new Options();
			op.add(new RadioOption("Edit SPS file directly in XMLSpy"));
			spsFileHandling(op);
		}
		
		delay(7000);
		//escape dialogs
		addEscapeDialogAction("A Runtime Error has occurred", VK_N);
		addEscapeDialogAction("Internet Explorer Script Error", VK_N);
		waitAndEsacpe("");
	}
	
	/**	
	 * Opens the specified URL server or URL file. Also the ones in which password and/or
	 * user name is required
	 */
	
	public void accessURL(TextFieldOption usr,TextFieldOption pwd,TextFieldOption serv,TextFieldOption URLfile,RadioOption fileLoad,RadioOption openAs){
		leftClick("ID_FILE_OPEN");delay(1000);
		assertWindow("Open");
		leftClickMid(findComponent("Switch to &URL","Button", NativeGUI.getForegroundWindowInfo().getLocation()));
		assertWindow("Open");
		openAs.applyOption(this);
		fileLoad.applyOption(this);
		if (usr != null) {
			usr.applyOption(this);
		}
		if (pwd != null) {
			pwd.applyOption(this);
		}
		if (serv != null) {
			serv.applyOption(this);
			
		}
		if(URLfile!=null){
			URLfile.applyOption(this);
		}	
	
	}
	
	public void closeAll() {
		//throw new ScriptMistakeException("Not implemented in this robot yet");
		leftClickMenuItem("File", "Close all");
	}
	
	public void closeAllButActive() {
		leftClickMenuItem("File", "Close All But Active");	
	}
	
	//---------------------------------------------------------------------------------------
	//-----------------------------   COMMON EDIT MENU ITMES    -----------------------------
	//---------------------------------------------------------------------------------------
	
	/** Action from Edit menu. Will throw exception if not available. */
	public void undo() {
		leftClickMenuItem("Edit", "Undo"); delay(300);
	}
	
	/** Do undo by pressing CTRL + Z */
	public void undoKey() {
		keyTypeCtrl(VK_Z);
	}


	/** Action from Edit menu. Will throw exception if not available. */
	public void redo() {
		leftClickMenuItem("Edit", "Redo"); delay(300);
	}

	/** Action from Edit menu. Will throw exception if not available. */
	public void cut() {
		leftClickMenuItem("Edit", "Cut"); delay(300);
	}
	
	/** Action from Edit menu. Will throw exception if not available. */
	public void copy() {
		leftClickMenuItem("Edit", "Copy"); delay(300);
	}
	
	/** Action from Edit menu. Will throw exception if not available. */
	public void paste() {
		leftClickMenuItem("Edit", "Paste"); delay(300);
	}
	
	/** Shortcut from Edit menu. Will throw exception if not available. */
	public void pasteKey() {
		keyPress(VK_CONTROL);
		keyType(VK_V);
		keyRelease(VK_CONTROL);
	}
	
	/**
	 * Clicks the menu item "Select All"; nothing else.
	 */
	public void selectAll() {
		leftClickMenuItem("Edit", "Select All");
	}
	
	/** Press F3 */
	public void findNext() {
		logger.fine("Find next - by pressing F3");
		//leftClickMenuItem("Edit", "Find Next"); delay(300);
		keyType(VK_F3);
	}
	
	/** Press SHIFT+F3 */
	public void findPrevious() {
		logger.fine("Find Previous - by pressing SHIFT+F3");
		keyTypeShift(VK_F3);
	}

	
	/** Action from Edit menu. Will throw exception if not available. */
	public void delete() {
		leftClickMenuItem("Edit", "Delete"); delay(300);
	}
	
	/** Action from Edit menu. Will throw exception if not available. */
	public void find() {
		leftClickMenuItem("Edit", "Find"); delay(300);
	}
	
	//---------------------------------------------------------------------------------------
	//-----------------------------   COMMON PROJECT MENU ITMES    -----------------------------
	//---------------------------------------------------------------------------------------
	
	protected void escapeProjectDialogs() {
		escapeDialog("Do you want to save Project modifications", VK_N );
		escapeDialog("Do you wish to automatically close all open documents that belong to this project", VK_N);
	}
	
	/**
	 * Creates a new Project in Spy, Authentic, StyleVision; escapes dialogs.
	 *
	 */
	public void newProject() {
		leftClickMenuItem("Project", "New Project");
		escapeProjectDialogs();
	}
	
	
	/**
	 * Clicks "Save Project"; nothing else.
	 *
	 */
	public void saveProject() {
		leftClickMenuItem("Project", "Save Project");
	}
	
	/**
	 * Saves the a new Spy project to the specified name; escapes dialogs.
	 * @param name path/name of new project file.
	 */
	public void saveProject(String name) {
		saveProject();
		typeStringEnter(name);
		escapeDialog("already exists", VK_Y);
		escapeDialog("Confirm Save As", VK_Y);
	}
	
	/**
	 * Ads the specified file to the active project. 
	 * @param name path/name of file to add to project.
	 */
	public void addFilesToProject(String name) {
		leftClickMenuItem("Project", "Add Files to Project");
		assertWindow("Open");
		typeStringEnter(name);
	}
	
	/**
	 * Clicks "Add Active File to Project"; nothing else.
	 */
	public void addActiveFileToProject() {
		leftClickMenuItem("Project", "Add Active File to Project");
	}
	
	/**
	 * Clicks "Add Active and Related Files to Project"; nothing else.
	 */
	public void addActiveAndRelatedFileToProject() {
		leftClickMenuItem("Project", "Add Active and Related Files to Project");
	}
	
	/**
	 * Clicks on "Reload Project"; nothing else
	 */
	public void reloadProject(){
		leftClickMenuItem("Project", "Reload Project");
	}
	
	/**
	 * Reloads the active project, discarding any changes.
	 *
	 */
	public void reloadProjectDiscard() {
		reloadProject();
		escapeProjectDialogs();
	}
	
	/**
	 * Applies the specified options to the Project Properties, and closes the dialog.
	 * @param options {@link Option} or {@link Options} to apply, or null for nothing.
	 */
	public void projectProperties(Option options) {
		leftClickMenuItem("Project", "Properties");
		delay(2000);
		assertWindow("Properties");
		if(options!=null){
		options.applyOption(this);
		}
	}
	
	//---------------------------------------------------------------------------------------
	//-----------------------------   COMMON OPTIONS MENU ITMES    --------------------------
	//---------------------------------------------------------------------------------------

	/**
	 * Sets the application options to the values specified in the Option
	 * objects passes to this method. The option dialog is opened by clicking
	 * the Tools menu, followed by the Options menu item on this menu. Each
	 * option value is then set according to their order as determined by
	 * {@link AbstractOption#compareTo(AbstractOption)}, and then closes the
	 * option dialog by hitting ENTER on the keyboard.
	 */
	
	public void setOptions(Option options) {
		activateOptionsDialog();
		applyOptions(options);
	}
	
	protected void applyOptions(Option options) {
		if (options != null) {
			options.applyOption(this);
		}
		delay(1000);
		
		//click OK/FINISH...
		keyType(VK_ENTER);
		delay(1000);
	}
	
	protected void applyOptionsNoConfirm(Option options) {
		if (options != null) {
			options.applyOption(this);
		}
		delay(1000);
		
		//NO click OK/FINISH..
	}
	
	public void activateOptionsDialog(){
		leftClickMenuItem("Tools", "Options"); //overwritten in Umodel: robot confused with Tools>Spelling Options 
		delay(1000);
	}
	
//	---------------------------------------------------------------------------------------
	//-----------------------------   COMMON WINDOW MENU ITEMS    -----------------------------
	//---------------------------------------------------------------------------------------
	public void windowCascade() {
		leftClickMenuItem("Window", "Cascade");
		delay(2000);
	}
	
	public void windowTileHorizontally() {
		leftClickMenuItem("Window", "Tile horizontally");
	}
	
	public void windowTileVertically() {
		leftClickMenuItem("Window", "Tile vertically");
	}
	
	public void showAllWindows(){
		leftClickMenuItem("Window", "Windows...");
		assertWindow("Windows");
	}
	
	//---------------------------------------------------------------------------------------
	//-----------------------------   COMMON HELP MENU ITEMS    -----------------------------
	//---------------------------------------------------------------------------------------

	/**Method used to introduce Extra menu items for the eclipse and .net 
	 integrations*/
	public String getExtraHelpMenus(){
		return null;
	}
	
	/** Action from Help menu. Will throw exception if not available. */
	public void helpToc() {
		leftClickMenuItem("Help", getExtraHelpMenus(),"Table of Contents");
	}
	
	
	
	/** Action from Help menu. Will throw exception if not available. */
	public void helpIndex() {
		leftClickMenuItem("Help",getExtraHelpMenus(), "Index");
	}
	
	/** Action from Help menu. Will throw exception if not available. */
	public void helpSearch() {
		leftClickMenuItem("Help",getExtraHelpMenus(), "Search...");
	}
	
	/** Action from Help menu. Will throw exception if not available. */
	public void softwareActivation() {
		leftClickMenuItem("Help",getExtraHelpMenus(), "Software Activation");
	}
	
	/** Action from Help menu. Will throw exception if not available. */
	public void orderForm() {
		leftClickMenuItem("Help",getExtraHelpMenus(), "Order Form");
	}
	
	/** Action from Help menu. Will throw exception if not available. */
	public void softwareRegistration() {
		leftClickMenuItem("Help",getExtraHelpMenus(), "Registration");
	}
	
	/** Action from Help menu. Will throw exception if not available. */
	public void checkForUpdates() {
		leftClickMenuItem("Help",getExtraHelpMenus(), "Check for Updates...");
	}
	
	/** Action from Help menu. Will throw exception if not available. */
	public void webSupportCenter() {
		leftClickMenuItem("Help",getExtraHelpMenus(), "Support Center");
	}
	
	/** Action from Help menu. Will throw exception if not available. */
	public void webFaq() {
		leftClickMenuItem("Help",getExtraHelpMenus(), "FAQ on the Web");
	}
	
	/** Action from Help menu. Will throw exception if not available. */
	public void webDownloadComponents() {
		leftClickMenuItem("Help",getExtraHelpMenus(), "Download Components and Free Tools");
	}
	
	public void applicationOnWeb() {
		leftClickMenuItem("Help",getExtraHelpMenus(), getAppNameWithoutAltova()+" on the Internet");
	}
	
	public void aboutApplication() {
		leftClickMenuItem("Help",getExtraHelpMenus(),"About "+getAppNameWithoutAltova());
	}

	
	//---------------------------------------------------------------------------------------
	//-----------------------------   Resource file specific methods        -----------------
	//---------------------------------------------------------------------------------------

	/**
	 * Adds a Visual Studio resource file to this ResourceRobot.
	 * It will attempt to search for a the file, if it is not found on the
	 * resource path (classpath). 
	 * 
	 * @param path path+filename of the resource
	 * @param toolbarIds variable IDs for the toolbars to load from the specified file
	 */
	protected void addReader(String path, String toolbarIds[]) {
		addReader(path, toolbarIds, false);
	}
		
	/**
	 * Adds a Visual Studio resource file to this ResourceRobot. It will attempt
	 * to search for a the file, if it is not found on the resource path
	 * (classpath). This version of the addReader method enables loading of
	 * toolbars which contains only a single image. The ID/name of this icon
	 * will then be the same as the toolbar name. An example of this is the
	 * icons of the message window, as seen in
	 * {@link AltovaApplicationRobot#MESSAGE_WINDOW_ICONS}.
	 * 
	 * @param path
	 *            path+filename of the resource
	 * @param toolbarIds
	 *            variable IDs for the toolbars to load from the specified file
	 * @param singleImages true if the images for the "toolbar" are contained in single images.
	 */
	protected void addReader(String path, String toolbarIds[], boolean singleImages) {
		URL resource = IOUtils.findResource(path);
		if(resource == null) {
			String msg = "Could not find file "+path;
			logger.severe(msg);
			throw new ScriptMistakeException(msg);
		}
		
		readers.add( new ResourceFileReader( resource, toolbarIds, singleImages ) );
	}
	
	/**
	 * Click with left mouse button on specified toolbar button
	 * 
	 * @param id the variable ID or user string for the icon resource.
	 */
	public void leftClick(String id) {
		logger.fine("leftClick("+id+")");
		leftClickMid( findIcon(id) );
	}
	
	/**
	 * Click with left mouse button on specified toolbar button
	 * 
	 * @param id the variable ID or user string for the icon resource.
	 * @param hint 
	 * @param usePrevHits will take into account previous hits in searching if any
	 */
	public void leftClick(String id, Rectangle hint,boolean usePrevHits) {
		logger.fine("leftClick("+id+")");
		leftClickMid( findIcon(id, hint,usePrevHits));
	}

	
	/**
	 * Returns a {@link BufferedImage} for the specified icon resource id,
	 * or null if this ResourceRobot did not contain the id.
	 * 
	 * @param id the variable ID or user string for the icon resource.
	 * @return a BufferedImage containing the decoded contents of the input, or null.
	 */
	public BufferedImage getIconResource(String id) {
		for(ResourceFileReader reader : readers) {
			BufferedImage img = reader.getIcon(id);
			if(img != null) {
				return img;
			}
		}
		
		return null;
	}
	/**
	 * Returns the position on screen of the specified image resource id.
	 * 
	 * @param id
	 *            the variable ID or user string for the image resource.
	 * @return a {@link Rectangle} the size of the specified image, and X,Y in
	 *         the upper left corner of the area on screen where the icon was
	 *         found.
	 * @throws ImageNotFoundException
	 *             if the image was not found.
	 * @throws IllegalArgumentException
	 *             if the image id was not found.
	 */
	public Rectangle findImage(String id) {
		return findImage(id, null, true);
	}
	
	/**
	 * Returns the position on screen of the specified icon resource id.
	 * 
	 * @param id
	 *            the variable ID or user string for the icon resource.
	 * @return a {@link Rectangle} the size of the specified icon, and X,Y in
	 *         the upper left corner of the area on screen where the icon was
	 *         found.
	 * @throws ImageNotFoundException
	 *             if the image was not found.
	 * @throws IllegalArgumentException
	 *             if the icon id was not found.
	 */
	public Rectangle findIcon(String id) {
		return findIcon(id, null,true);
	}
		
	/**
	 * Returns the position on screen of the specified icon resource id,
	 * searching within the specified area of hint.
	 * 
	 * @param id
	 *            the variable ID or user string for the icon resource.
	 * @param hint
	 *            constrain the search within this area.
	 * @param usePrevHits will take into account previous hits in searching if any
	 * 
	 * @return a {@link Rectangle} the size of the specified icon, and X,Y in
	 *         the upper left corner of the area on screen where the icon was
	 *         found.
	 * @throws ImageNotFoundException
	 *             if the image was not found.
	 * @throws IllegalArgumentException
	 *             if the icon id was not found.
	 */
	protected Rectangle findIcon(String id, Rectangle hint,boolean usePrevHits) {
		Rectangle prev = previousHits.get(id);
		BufferedImage img = getIconResource(id);
		
		if(img == null) {
			throw new IllegalArgumentException("The icon resource '"+id+"' was not found.");
		}
		
		if(prev == null||(usePrevHits==false)) {
			prev = hint;
		}
		Rectangle cur = find(img, prev);
		previousHits.put(id, cur);
		return cur;
	}
	
	/**
	 * Returns a List of the ToolbarIcons object holding the toolbars of this ResourceRobot.
	 * 
	 * @return the ToolbarIcons for read by the ResourceFileReaders of this class.
	 */
	protected List<ToolbarIcons> getToolbarsIcons() {
		List<ToolbarIcons> icons = new ArrayList<ToolbarIcons>();
		
		for(ResourceFileReader reader : readers) {
			icons.addAll(reader.getToolbarIcons());
		}
		
		return icons;
	}
	
	
	/**
	 * Returns the text in the message window as a String
	 * 
	 * @param messages the Pane which constitutes the message window in the application
	 * @return a String containing text copied to the clipboard from the message window 
	 */
	protected String getMessageWindowText(Pane messages) {
		Rectangle pane = activatePane(messages); delay(500);
		logger.finer("Found message pane "+messages+" at "+pane);
		try {
			leftClick("IDB_OUTPUT_COPYALL", pane,true);
		} catch(ImageNotFoundException e) {
			//if we didn't find the copyall icon, check if it was disabled
			//if this was not found either, an exception will be thrown
			findImage("copyall_disabled.png");
			
			//however, if it was found, return an empty string
			return "";
		}
		
		return ClipboardUtils.getClipboardContents();
	}

	
	
	
	
	//---------------------------------------------------------------------------------------
	//-----------------------------   COMMON ALTOVA APP SPECIFIC ACTIONS    -----------------
	//---------------------------------------------------------------------------------------
	
	/**
	 * Set the specified styles attribute to the specified value.
	 * The Styles pane has to be active in order for this to work.
	 * If the attribute line cannot be found in the currently visible
	 * portion of the window, it will attempt to scroll and search.
	 * 
	 * If the style name cannot be found...
	 * 
	 * @param name string name of the style as it is shown in the Styles pane
	 * @param value value to set
	 */
	public void setPaneValue(Pane pane, String name, String value, int typeValue) {
		logger.fine( "Setting value "+name+"='"+value+"'");
		
		Rectangle key = findCheckKeyName(pane, name);
		Rectangle row = getPaneKeyValue(pane, key) ;
		logger.finest("Found key at "+key);
		logger.finest("Found row at "+row);
		
		if(super.outputDebugImages) {
			try {
				saveScreen( getPaneKeyValue(pane, key), pane+"_"+name+"_before", true);
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		leftClickMid(row);
		delay(800);
		leftClick();
		this.waitForIdle();

		//Treat space and null as special case
		if(value.equals("null")){
			typeString("dummy"); //with this workaround,we are trying to remove a predefined value
			removeTextfieldText();
		}
		else if(value.length() == 1 && value.charAt(0) == ' ') {
			keyType(VK_SPACE);	
		
		} else {
			typeString(value);
		}
		
		delay(500);
		keyType(VK_ENTER);
		delay(500);
		
		escapeDialog("Base Type Modification", typeValue);
		
		if(super.outputDebugImages) {
			try {
				saveScreen( getPaneKeyValue(pane, key), pane+"_"+name+"_after", true);
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	
	
	
	
	public void setPaneValue(Pane pane, String name, String value) {
		
		setPaneValue(pane, name, value, VK_Y);
	}
	
	
	/**
	 * Returns an image of the specified field in the specified pane. 
	 * 
	 * @param paneName Pane that contains the field
	 * @param name left hand description of the field
	 * @return an image which covers at least the value of the field, 
	 * 			and possibly a bit of the empty area of the name column.
	 */
	public BufferedImage getPaneValueImage(Pane paneName, String name) {
		//i set it to save in an image what it found
		debugSuccess=true;
		Rectangle value = getPaneKeyValue(paneName, name);
		return createScreenCapture(value);
	}
	
	/**
	 * Returns the value area of the specified field in the specified pane. 
	 * 
	 * @param paneName Pane that contains the field
	 * @param name left hand description of the field
	 * @return a Rectangle covers at least the value of the field, 
	 * 			and possibly a bit of the empty area of the name column.
	 */
	protected Rectangle getPaneKeyValue(Pane paneName, String name) {
		Rectangle row = findCheckKeyName(paneName, name);
		logger.finest("paneName="+paneName+", row="+row);
		return getPaneKeyValue(paneName, row);
	}
	
	private Rectangle getPaneKeyValue(Pane paneName, Rectangle keyRow) {
		Rectangle row = keyRow;
		Rectangle pane = NativeGUI.getWindowInfo(row.x, row.y).getLocation();
		
		Rectangle value = new Rectangle( row.x+row.width, row.y, (pane.x+pane.width) - (row.x+row.width), row.height );
		logger.finest("getPaneKeyValue - value: "+value);
		return value;
	}
	
	/**
	 * Returns the position of the specified field in the specified pane;
	 * if the field is not found, and exception is thrown.
	 * 
	 * @param pane Pane that contains the field
	 * @param keyName left hand description of the field
	 * @return a Rectangle which covers just the space the name string of the filed
	 * @throws ScriptMistakeException if the field was not found
	 */
	protected Rectangle findCheckKeyName(Pane pane, String keyName) {
		Rectangle row = findKeyName(pane, keyName);
		if(row == null) {
			logger.severe("Did not find key name: "+keyName);
			throw new ScriptMistakeException("Did not find key name: "+keyName);
		}
		
		return row;
	}
	
	/**
	 * Returns the position of the specified field in the specified pane.
	 * 
	 * @param paneName Pane that contains the field
	 * @param keyName left hand description of the field
	 * @return a Rectangle which covers just the space the name string of the filed
	 */
	protected Rectangle findKeyName(Pane paneName, String keyName) {
		Rectangle pane = activatePane(paneName);
		Color color = null;
		if(paneName.equals(SpyRobot.DETAILS_SIMPLE_TYPE))
			color = Color.BLACK ;
		else color = Color.GRAY ;
		
		//first try at the current position of the pane...
		try {			
			return findString(keyName, DEFAULT_CONTENT_FONT, TRANSPARENT, color, pane, false);
		}
		catch(ImageNotFoundException e) {} //do nothing
		
		//...then try to scroll from top to bottom
		for(double i = 0; i <= 1.1; i += 0.5) {
			logger.finest("Scroll "+paneName+" i="+i);
			scrollPane(paneName, i);
			
			try {
				//Modified on 01/03/2012 to fix the problem in a test case in Entry 
				// Now it just just search in the same rectangle after scroll
				//instead of the full screen
				return findString(keyName, DEFAULT_CONTENT_FONT, TRANSPARENT,color, pane, false);
				//return findString(keyName, DEFAULT_CONTENT_FONT, color);
			}
			catch(ImageNotFoundException e) {} //do nothing
		}
			
		return null;
	}

	/**
	 * Activate the specified pane
	 * @param pane name of the pane, as seen on screen
	 */
	public Rectangle activatePane(Pane pane) {
		if (pane instanceof TabPane) {
			TabPane tab = (TabPane) pane;
			return activateTabPane(tab);
		}
		
		return activateMainPane(pane);
	}
	
	//This method just works for altova applications, but differs in eclipse and VS
	
	public Rectangle enableShowPane(Pane pane){
		leftClickMenuItem(pane.getViewMenu(), pane.getMenuItem());
		
		//in the stand-alone applications, we don't need location feedback here
		//however in the Eclipse plugin, we do. Please see the methods which overrides this
		//in the Eclipse robots.
		return null;
	}
	
	private Rectangle getMainPane(Pane pane) {
		String paneName = pane.getName();

		// first try to find the component
		//This will never work in eclipse so I will skip this step for eclipse
		if (!(this instanceof EclipseUModelRobot)) {
			Rectangle comp = findComponentName(paneName);
			if (comp != null) {
				logger.finest("Pane " + paneName + " at " + comp);
				return comp;
			}
		}
		// if that fails, search the screen
		try {
			
			Rectangle tab = findString(paneName);
			ComponentInfo mycomp = NativeGUI.getWindowInfo(tab.x, tab.y);
			Rectangle foundStr = mycomp.getLocation();

			if (foundStr != null) {
				logger.finest("Pane " + paneName + " at " + foundStr);
				return foundStr;				
			}
		} catch (ImageNotFoundException e) {
		 // do nothing
		}
		// if that fails, search the screen with another color
		try {
			
			Rectangle tab = findString(paneName,WINDOWS_DEFAULT_FONT,Color.darkGray);
			leftClickMid(tab);
			ComponentInfo mycomp = NativeGUI.getWindowInfo(tab.x, tab.y);
			Rectangle foundStr = mycomp.getLocation();

			if (foundStr != null) {
				logger.finest("Pane " + paneName + " at " + foundStr);
				return foundStr;
			}
		} catch (ImageNotFoundException e) {
		 // do nothing
		}
		// A different window activation is needed for eclipse, spy and VS
		Rectangle ans = enableShowPane(pane);
		if(ans == null) {
			ans = findComponentName(paneName);
			if (ans == null) {
				throw new ScriptMistakeException("Failed to activate pane " + pane);
			}
		}

		// make sure the pane is selected
		Point top = new Point(ans.x + 2, ans.y + 2);
		
		
		
		if(this instanceof PluginRobot) {
			//click a bit inside the MT, since VS .Net and Eclipse require this to active the Find dialog
			//but for the UModel Styles window, we don't want to click inside, since it will hit the dropdown,
			//which you don't want. 
			int shift = 6;
			if(pane.equals(UModelRobot.STYLES)) {
				shift = 0;
			}
			
			top = new Point(ans.x+ans.width-30, ans.y+24+shift);
		}
		
		leftClick(top);

		logger.finest("Pane " + paneName + " at " + ans);
		delay(1000);
		
		return ans;

	}
	
	private Rectangle activateMainPane(Pane pane) {
		String paneName = pane.getName();

		// first try to find the component
		//This will never work in eclipse so I will skip this step for eclipse
		if ((!(this instanceof EclipseUModelRobot))&& (!(this instanceof EclipseMapForceRobot)))  {
			Rectangle comp = findComponentName(paneName);
			if (comp != null) {
				// make sure the pane is selected
				Point top = new Point(comp.x + 2, comp.y + 2);
				leftClick(top);
				logger.finest("Pane " + paneName + " at " + comp);
				delay(1000);
				logger.info("Encontrado al intento 1 la pane "+paneName);
				return comp;
			}
		}

		// if that fails, search the screen looking for a pane tabbed to other
		try {
			
			Rectangle tab =null;
			Rectangle foundStr=null;
			if (Settings.isVS2010() && paneName.equalsIgnoreCase("Messages")&&!(this instanceof VSnetUModelRobot)) {
				//This is needed for UModel, in the cases where no diagram is opened
				Rectangle main=getMainWindow();
				if(main==null){
					main.x=900;
					main.y=200;
				}				
				Rectangle region_ToSearch=new Rectangle(main.x,main.y+main.height,ImageUtils.getDefaultScreenDimension().width,100);
				tab = findString(paneName,region_ToSearch,false);
				leftClickMid(tab);
//				ComponentInfo info=NativeGUI.getWindowInfo(tab.x, tab.y);
//				logger.info("Component info: "+info);
				foundStr = new Rectangle(
						tab.x,
						tab.y,
						main.width,
						(ImageUtils.getDefaultScreenDimension().height
								- main.height - main.y));
			} else if (Settings.isVS2010() && paneName.equalsIgnoreCase("Libraries")){


				Rectangle menu = findString("Help",WINDOWS_DEFAULT_FONT,GRAY_IN_VS2010_MENU);
				moveMid(menu);
				keyPress(VK_ESCAPE);
				tab = findString(paneName);
				leftClickMid(tab);
				logger.info("Should click on Libraries");
				delay(20000);
				if(this instanceof VSnetUModelRobot){
				foundStr=new Rectangle(tab.x, tab.y, ImageUtils
						.getDefaultScreenDimension().width
						- tab.x, 200);	
				}else{
				ComponentInfo mycomp = NativeGUI.getWindowInfo(tab.x, tab.y);
				foundStr = mycomp.getLocation();
				}
			}
			
			else {
				tab = findString(paneName);
				leftClickMid(tab);
				if(this instanceof VSnetUModelRobot){
				foundStr=new Rectangle(tab.x, tab.y, ImageUtils
						.getDefaultScreenDimension().width
						- tab.x, 200);	
				}else{
				ComponentInfo mycomp = NativeGUI.getWindowInfo(tab.x, tab.y);
				foundStr = mycomp.getLocation();
				}
			}
			// Rectangle ans = findComponentName(paneName);
			if (foundStr != null) {
				
				logger.finest("Pane " + paneName + " at " + foundStr);
				delay(1000);
				logger.info("Encontrado al intento 2 la pane "+paneName);
				return foundStr;
				
			}

		} catch (ImageNotFoundException e) {
		} // do nothing
		
		// if that fails, search the screen with another color. We skip this for VS2010 because it will never work
			try {
				Rectangle tab=null;
				Rectangle foundStr=null;
				Color backgInVS2010 = new Color(71, 91, 126);
				if (!(Settings.isVS2010())) {
				tab = findString(paneName, WINDOWS_DEFAULT_FONT, Color.darkGray);
				leftClickMid(tab);
				ComponentInfo mycomp = NativeGUI.getWindowInfo(tab.x, tab.y);
				foundStr = mycomp.getLocation();
				
				} else if (!paneName.equalsIgnoreCase("Messages")||(this instanceof VSnetUModelRobot)) {
				
				tab = findString(paneName, WINDOWS_DEFAULT_FONT,
								backgInVS2010, Color.WHITE, null, true);
				leftClickMid(tab);
				foundStr = new Rectangle(tab.x, tab.y, ImageUtils
						.getDefaultScreenDimension().width
						- tab.x, 200);
				}
				

				// Rectangle ans = findComponentName(paneName);
				if (foundStr != null) {

					logger.finest("Pane " + paneName + " at " + foundStr);
					delay(1000);
					logger.info("Encontrado al intento 3 la pane " + paneName);
					return foundStr;

				}

			} catch (ImageNotFoundException e) {
			} // do nothing
		

		
		
		// A different window activation is needed for eclipse, spy and VS
		Rectangle ans = enableShowPane(pane);
		if (ans == null) {

			if (Settings.isVS2010()) {
				if (paneName.equalsIgnoreCase("Messages")) {
					Rectangle main=getMainWindow();
					if(main==null){
						main.x=900;
						main.y=200;
					}
					Rectangle region_ToSearch = new Rectangle(
							main.x, main.y
									+ main.height, ImageUtils
									.getDefaultScreenDimension().width, 250);
					Rectangle tab = findString(paneName, region_ToSearch, false);
					// ComponentInfo info=NativeGUI.getWindowInfo(tab.x+5,
					// tab.y+5);
					// logger.info("Component info: "+info);
					leftClickMid(tab);
					ans = new Rectangle(
							tab.x,
							tab.y,
							getMainWindow().width,
							(ImageUtils.getDefaultScreenDimension().height
									- main.height - main.y));
				} else if((!paneName.equalsIgnoreCase("XPath"))) {
					Rectangle region_ToSearch = new Rectangle(getMainWindow().x
							+ getMainWindow().width, 0, ImageUtils
							.getDefaultScreenDimension().width
							- getMainWindow().width - getMainWindow().x,
							ImageUtils.getDefaultScreenDimension().height);
					Rectangle tab=null;
					//Umodel has tests where no diagram gets opened
					if (this instanceof VSnetUModelRobot) {
						tab = findString(paneName, region_ToSearch, true);
					} else {
						tab = findString(paneName, region_ToSearch, false);
					}
					leftClickMid(tab);
					ans = new Rectangle(tab.x, tab.y, ImageUtils
							.getDefaultScreenDimension().width
							- tab.x, 200);
				}

			}
		}
		
		if (ans == null) {
			ans = findComponentName(paneName);
			if (ans == null) {
			throw new ScriptMistakeException("Failed to activate pane "	+ pane);
			}
		}

		// make sure the pane is selected
		Point top = new Point(ans.x + 2, ans.y + 2);
		
		
		
		if(this instanceof PluginRobot) {
			//click a bit inside the MT, since VS .Net and Eclipse require this to active the Find dialog
			//but for the UModel Styles window, we don't want to click inside, since it will hit the dropdown,
			//which you don't want. 
			int shift = 6;
			if(pane.equals(UModelRobot.STYLES)) {
				shift = 0;
			}
			
			top = new Point(ans.x+ans.width-30, ans.y+24+shift);
		}
		
		leftClick(top);

		logger.finest("Pane " + paneName + " at " + ans);
		delay(1000);
		logger.info("Encontrado al intento 4 la pane "+paneName);
		return ans;

	}

	private Rectangle activateTabPane(TabPane pane) {
		Rectangle mainPane=null;
		
		/**This is needed for testing the SchemaView suite as Facets EH get now updated automatically after changing 
		//anything in the Details EH or diagram */
		
		if (pane.getName().equalsIgnoreCase("Facets")) {
			 mainPane = getMainPane(pane);
		} else {
			 mainPane = activateMainPane(pane);
		}
		boolean found = true;
		// now that we got the main pane, search for the tab towards the bottom
		Rectangle hint = new Rectangle(mainPane.x, mainPane.y + mainPane.height - 50, mainPane.width, 50);
		try {
			Rectangle tab = findString(pane.getTab(), WINDOWS_DEFAULT_FONT, TRANSPARENT,Color.darkGray,hint,false);
			if (tab != null) {
				logger.finest("Found " + pane.getTab() + " tab at " + tab);
				leftClickMid(tab);
			}
		} catch (ImageNotFoundException e) {
			found = false;
		}

		if (found == false) {
			try {
				Rectangle tab = findString(pane.getTab(), hint, false);
				if (tab != null) {
					leftClickMid(tab);
					found=true;
					logger.finest("Found " + pane.getTab() + " tab 2 at " + tab);
				}
			} catch (ImageNotFoundException e) {
				found = false;
			}
		}

		if (found == false) {
			throw new ScriptMistakeException("Tab " + pane.getTab() + " could not be found");
		} else {
			return mainPane;
		}
	}

	public void scrollWindow(Rectangle rect, double position) {	
		scroll(rect, position);
		
	}
	
	/**
	 * Move the scrollbar of the specified pane to the specified position,
	 * where 0.0 is top and 1.0 is bottom.
	 * 
	 * @param pane name of the pane
	 * @param position new position of the scrollbar
	 */
	public void scrollPane(Pane pane, double position) {
		Rectangle p = activatePane(pane);
		
		//assume scroll bar is about 24 pixels width, and at the very right of the pane
		Rectangle tmp = new Rectangle(p.x+p.width-24,p.y, 24, p.height);
		scrollWindow(tmp,position);
	}
	
	/**
	 * Set the size of the specified pane/window. A negative size in either
	 * width or height means that that axis will be ignored.
	 * 
	 * @param paneName the Pane (window) to resize
	 * @param width the new Pane width in pixels
	 * @param height the new Pane height in pixels
	 */
	public void setPaneSize(Pane paneName, int width, int height) {
		Rectangle pane = activatePane(paneName);

		//click the menu on and off, to deselect any pane 
		//Commented the patch done for VS2010 as this part won't be run for that edition
		/*if(Settings.isVS2010()){
			findString("File", WINDOWS_DEFAULT_FONT, TRANSPARENT, GRAY_IN_VS2010_MENU);
		}else{*/
			findString("File");
		//}
		delay(1000);
		leftClick(); delay(1000);
		
		//set width
		if(width > 0) {
			//find the slider to the right
			ComponentInfo info = NativeGUI.getWindowInfo(pane.x+pane.width+2, pane.y+2);
			logger.finest("Right slider of "+paneName.getName()+": "+info);
			if(info != null && info.getLocation().getWidth() < 8) {
				Rectangle slider = info.getLocation();
				Point from = new Point(slider.x+1, slider.y+2);
				Point to = new Point(pane.x+width, slider.y+2);
				dragDrop(from, to);
			} else {
				//find left slider
				info = null;
				info = NativeGUI.getWindowInfo(pane.x-2, pane.y+2);
				logger.finest("Left slider of "+paneName.getName()+": "+info);
				if(info != null && info.getLocation().getWidth() < 8) {
					Rectangle slider = info.getLocation();
					Point from = new Point(slider.x+1, slider.y+2);
					Point to = new Point(pane.x+pane.width-width, slider.y+2);
					dragDrop(from, to);
				}
			}
			delay(1000);
		}
		
		//set height
		if(height > 0) {
			//TODO: make this more general
			
			//find bottom slider 
			ComponentInfo info = NativeGUI.getWindowInfo(pane.x+2, pane.y+pane.height+2);
			logger.finest("Bottom slider of "+paneName.getName()+": "+info);
			if(info != null && info.getLocation().getHeight() < 8) {
				Rectangle slider = info.getLocation();
				Point from = new Point(slider.x+2, slider.y+1);
				Point to = new Point(slider.x+2, pane.y+height);
				dragDrop(from, to);
			} else {
				//find top slider
				info = null;
				info = NativeGUI.getWindowInfo(pane.x+2, pane.y-2);
				logger.finest("Top slider of "+paneName.getName()+": "+info);
				if(info != null && info.getLocation().getHeight() < 8) {
					Rectangle slider = info.getLocation();
					Point from = new Point(slider.x+2, slider.y+1);
					Point to = new Point(slider.x+2, pane.y+pane.height-height);
					dragDrop(from, to);
				}
			}
			
			delay(1000);
		}
	}
	
	protected Rectangle findPaneRowSplitter(Rectangle paneArea) {

		try {
			Rectangle ans = find( readIcon("pane_row_splitter.bmp"), paneArea, false);
			logger.finest("Row spitter found at "+ans);
			return ans;
		} catch(ImageNotFoundException e) {
			logger.warning("Pane row splitter was not found in pane.");
			return null;
		}
	}
	

	/**
	 * Deletes the registry key settings as specified by the instance the robot.
	 * If application is not an Altova product, nothing happens.
	 *
	 */
	public void deleteApplicationRegistryKeys() {
		deleteRegistryKey(ALTOVA_BASE_REGISTRY_KEY+appRegKey);
	}
	
	/**
	 * Delete registry key Setting not specified of Altova Product
	 * Insert the FULL name or FULL PATH of the registry to delete
	 * 
	 *  example:
	 *  
	 *   HKCU\Software\ODBC\ODBC.INI\Driver
	 *  
	 *   HKCU\Software\ODBC\ODBC.INI
	 * 
	 * @param notALTOVARegistryToDelete
	 */
	
	public void deleteApplicationRegistryKeys(String notALTOVARegistryKeyToDelete) {
		
		deleteRegistryKey(notALTOVARegistryKeyToDelete);
	}
	
	
	public void deleteSettingsRegistryKeys() {
		for(String key : settingsRegKeys) {
			deleteRegistryKey(ALTOVA_BASE_REGISTRY_KEY+appRegKey+"\\"+key);
		}
	}
	
	private void deleteRegistryKey(String key) {
		String name = System.getProperty("os.name");
		String ver = System.getProperty("os.version");
		
		if(name.indexOf("2000") > -1 || ver.indexOf("5.0") > -1) {
			logger.warning("Windows 2000 detected. Cannot delete registry settings. This might cause some GUI tests to fail.");
			return;
		}
		
		logger.info("Deleting registry key "+key);
		String cmd = "reg delete "+'"'+key+'"'+" /f"; 
		runCommand(cmd);
	}
	
	/**
	 * Exit/quit the application under test, usually discarding all unsaved data files,
	 * and terminating any other ongoing activities or dialogs.   
	 *
	 * This should be implemented in each specific application robot, as there well be
	 * different measures to take to avoid warning dialogs, running servers, etc.  
	 */
	public abstract void exitApplication();
	
	/**
	 * Returns the name of application under test, but stripping out the Altova
	 * part, if present. Spaces in the returned string is also removed.
	 * 
	 * @return the name of the application under test, without the Altova string.
	 */
	public String getAppNameWithoutAltova() {
		return getAppName().replace("Altova", "").replace(" ", "");
	}

	//---------------------------------------------------------------------------------------
	//-----------------------------   REFLECTION METHODS FOR ROBOTS         -----------------
	//---------------------------------------------------------------------------------------	
	
	
	/**
	 * Reads the specified text file and invokes the listed methods on the robots classes.
	 * 
	 * Each line in the file maps to one method invocation. The format of each line is as follows:
	 * PRODUCT|METHOD|METHOD-ARG|[METHOD-ARG]...
	 * 
	 * A pipe (|) is used as deliminator. The first token is the name of the product, the second
	 * the exact name of the method and any further tokens will be arguments to that method.
	 * 
	 * @param instructions the text file containing the instructions to execute.
	 * @throws IOException if there was an error reading the specified file
	 * @throws ScriptMistakeException if there was a problem parsing or executing one of the instructions.
	 * 									this exception will usually (but not always) wrap one or more
	 * 									causes, explaining what went wrong.
	 */
	public static void runCommands(File instructions) throws IOException {
		runCommands(instructions, false);
	}
		
	public static void runCommands(File instructions, boolean dryRun) throws IOException {
		AltovaApplicationRobot.dryRun = dryRun;
		String deliminator = "\\|";
		
		BufferedReader buf = new BufferedReader(new FileReader(instructions));
		String line;
		while ((line = buf.readLine()) != null) {
			String parts[] = line.split(deliminator);

			if(line.length() == 0) {
				logger.warning("Ignoring empty line in file "+instructions);
				continue;
			}
			
			// need at least product and method name
			if (parts.length < 2) {
				throw new ScriptMistakeException(
						"Instruction file"
								+ instructions
								+ " contains an invalid line. Needs at least product and method name."
								+ "Token deliminator is " + deliminator + "\n'"
								+ line + "'");
			}

			// split up parts of line
			String product = parts[0];
			String method = parts[1];
			String args[] = new String[parts.length - 2];
			for (int i = 2; i < parts.length; i++) {
				args[i - 2] = parts[i];
			}

			// find robot and run line
			logger.finer("Running: "+line);
			AltovaApplicationRobot robot = getProductRobot(product);
			try {
				robot.runCommands(method, args);
			} catch (ScriptMistakeException e) {
				throw new ScriptMistakeException("In file " + instructions, e);

			}
		}
	}
	
	/**
	 * Returns a new instance of the application specific robot identified by
	 * the specified product key.
	 * 
	 * @param product
	 *            the product key string, as seen in
	 *            {@link AltovaApplicationRobot#getKnownProducts()} and
	 *            {@link AltovaApplicationRobot#products}.
	 * @return a new instance of the application specific robot
	 * @throws ScriptMistakeException
	 *             if the product key was invalid, or the robot class
	 *             construction failed for some reason
	 */
	public static AltovaApplicationRobot getProductRobot(String product) {
		String key = product.toLowerCase();
		if(products.containsKey(key)) {
			try {
				Class<? extends AltovaApplicationRobot> clazz = products.get(key);
				return clazz.newInstance();
			} catch (Exception e) {
				throw new ScriptMistakeException("Something went wrong while constructing the new robot class.", e);
			}
		}
		
		throw new ScriptMistakeException("Product robot '"+product+"' was not found.");
	}
	
	/**
	 * Returns a set of Strings which includes all the unique Strings keys for
	 * the product specific robots. These keys can be used with
	 * {@link AltovaApplicationRobot#getProductRobot(String)} to construct a new
	 * application robot object.
	 * 
	 * @return the strings keys for the application robots
	 */
	public static Set<String> getKnownProducts() {
		return products.keySet();
	}
	 

	/**
	 * 
	 * @param method
	 * @param arguments
	 */
	public void runCommands(String method, String... arguments) {
		Class<? extends AltovaApplicationRobot> clazz = this.getClass();
		
		//get a list of class types for the arguments 
		Class[] argTypes = new Class[arguments.length];
		Object args[] = new Object[arguments.length];
		for (int i = 0; i < argTypes.length; i++) {
			argTypes[i] = arguments[i].getClass();
			args[i] = arguments[i];
		}
		
		//TODO: do we need special case where arguments.length = 0 here?
		
		try {
			Method m = clazz.getMethod(method, argTypes);
			if(!dryRun) {
				m.invoke(this, args);
			}
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			throw new ScriptMistakeException("Method "+method+" does not exist in this robot.", e);
		} catch (IllegalArgumentException e) {
			throw new ScriptMistakeException("Wrong arguments passed to method "+method, e);
		} catch (IllegalAccessException e) {
			throw new ScriptMistakeException("Could not access "+method+
					". You might have to change the call or wrap the method.", e);
		} catch (InvocationTargetException e) {
			throw new ScriptMistakeException("Something failed while running the reflected method "+method, e);
		}
	}

	public File snapShot(SnapshotArea area, String file) throws IOException {
		return snapShot(area, file, null);
	}
		
	public File snapShot(SnapshotArea area, String file, Dimension dim) throws IOException {
		if(area != FULLSCREEN && area != DIFF_DOG_UP_WINDOW &&!(area instanceof Pane)) {
			// move mouse out of the way
			
			// click the menu on and off, to deselect any pane
			try {			
				Rectangle menu=null;
				//Commented during changes to VS2010
				if(Settings.isVS2010()){
					
				 menu = findString("Help",WINDOWS_DEFAULT_FONT,GRAY_IN_VS2010_MENU);
				}else{
				 menu = findString("Help");
				}
				moveMid(menu);
				
				
				//Added new code for VS2010
				//leftClickMenuItem("Help", "");
				//leftClick();
				
				if(area != TOP_WINDOW) {
					moveMouseAway();
					// Both Plugins do not escape help menu without clicking
					if(this instanceof PluginRobot){
					leftClick();
					}
				}
			} catch(ImageNotFoundException e) {
				logger.warning("Could not find Help menu: "+e);
			}
			
		}
		
		Rectangle r = null;
		Rectangle rtop=null;
		if(area == DIAGRAM_MAIN_WINDOW) {
			r = getMainWindow();
		}
		else if(area == FULLSCREEN) {
			//capture the full screen of the primary monitor
			r = ImageUtils.getDefaultScreenDimension();
		}
		else if(area == TOP_WINDOW) {
			r = NativeGUI.getForegroundWindowInfo().getLocation();
		}
		else if(area== ZIP_VIEW){
			//r=findComponentClass("MDIClient");
			//r=findComponentClass("AfxMDIFrame100su");
			//r=findComponentClass("AfxFrameOrView100u");
			r=findComponentClass("AfxFrameOrView120u");
		}

		else if(area== SCHEMA_ATTRIBUTES){
			r=findComponentClass("SysTabControl32");
		}
		else if(area== PRJ_WINDOW_MAPFORCE){
			rtop = NativeGUI.getForegroundWindowInfo().getLocation();
			Rectangle hint=new Rectangle(rtop.x,getMainWindow().y,rtop.width,rtop.height-getMainWindow().y);
			r=findComponent("Project",null, hint);
		}
		else if(area== MF_MAIN_WINDOW){
			if(this instanceof PluginRobot){
				r=ImageUtils.getDefaultScreenDimension(); //capture whole screen, as we have no other chance for plugins
			}
			else{
			r=findComponentClass("Afx:TabWnd");
			}
		}

		else if (area== DATACOMPARISON_MAIN_WINDOW){	
			//Rectangle hint=new Rectangle(findComponentClass("AfxWnd42su")); before v2010
			//Rectangle hint=new Rectangle(findComponentClass("Afx:TabWnd:400000:8:10013:10"));
			//r=findComponent(null,"Afx:400000:88", hint); before v2010
			//r=findComponent(null,"Afx:00400000:88", hint);
			r = new Rectangle(306, 98, 970, 649); //no other solution to get a screenshot
		}

		else if(area== ALLSTYLES_SV){
			Rectangle hint=new Rectangle(1525,144,89,453);
			r=findComponent("","Afx:00380000:88",hint);
		}

		else if(area==FIND_IN_FILES){
			Rectangle main=getMainWindow();
			Rectangle hint=new Rectangle(main.x-10,(main.y+main.height),main.width+20,(ImageUtils.getDefaultScreenDimension().height-main.height-main.y));
			r=findComponent("Find in Files","#32770",hint);
		
		}else if (area==FIND_IN_XBRL){
			Rectangle main=getMainWindow();
			Rectangle hint=new Rectangle(main.x-10,(main.y+main.height),main.width+20,(ImageUtils.getDefaultScreenDimension().height-main.height-main.y));
			r=findComponent("Find in XBRL","#32770",hint);
		} else if (area==SEMANTICWORKS_MAIN_WINDOW){
			r=findComponentClass("SysTabControl32");
		
		} else if (area==DIFF_DOG_UP_WINDOW){
			r = ImageUtils.getDefaultScreenDimension();
			r.height = r.height -100;
		
		}
		
		else if(area instanceof Pane ) {
			Pane pane = (Pane)area;
			if ((pane.getName() == "Libraries") && (Settings.isVS2010() )) {
				Rectangle buttonLib = findComponent("Add/Remove Libraries",
						"Button", null);
				Rectangle main = getMainWindow();
				r = new Rectangle(buttonLib.x, main.y-6, buttonLib.width,
						buttonLib.y - main.y+6);
			} else {
				r = activatePane(pane);
				//get the inner component of the pane
				Point mid = ImageUtils.findMid(r);
				
				//Solve the issue of UModel when mid of the rectangle is outside the Messages pane
				//It only happens in VS2010
				if ((pane.getName() == "Messages") && (Settings.isVS2010())&& (this instanceof UModelRobot) ) {
					mid = new Point(r.x, r.y-30);
					logger.finest("DAB>>>>>>MODIFIED MID= " + mid);					
				}
				
				//disabled the SmartFix window for Spy...can affect the the screenshot size and content 
				if ((pane.getName() == "Messages") && this instanceof SpyRobot){
					hideXMLSpySmartFixPane(pane);
					
				}else{
					//logger.finest(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>DAB<<>>>>>>");		
					//logger.finest(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>DAB<<>>>>>>");
					//logger.finest(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>DAB<<>>>>>>");
					//logger.finest(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>DAB<<>>>>>>");
				}
				
				r = NativeGUI.getWindowInfo(mid.x, mid.y).getLocation();

			}
			
			moveMouseAway();
		}
		else {
			throw new ScriptMistakeException("Snapshot of area type "+area+" not implemented yet");
		}

		//let's avoid borders of the diagram (and empty area)
		//this is a workaround for the border which appears
		//after diagram has been opened and then closed again
		r = new Rectangle(r.x+3, r.y+3, r.width-6, r.height-6);
		//force size
		if(dim != null) {
			r.setSize(dim);
		}
		return saveScreen(r, file);
	}

	private void hideXMLSpySmartFixPane(Pane pane) {
		
		String paneName = pane.getName();
		
		Rectangle comp = findComponentName(paneName);
		try {
			Rectangle temp = findImage(HIDE_SMART_FIX_ICON.getAbsolutePath(), comp, false);
			  if (temp != null)  
				  leftClickMid(temp);
			  	  delay(500);
			
		} catch (Exception e) {
			logger.finest(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Hide Smart fix button not found>>>>>");
		}
		
	}

	private void moveMouseAway() {
		//move mouse out of the way
		//click the menu on and off, to deselect any pane
		Rectangle menu=null;
		if(Settings.isVS2010()){
		menu = findString("Help",WINDOWS_DEFAULT_FONT,GRAY_IN_VS2010_MENU);
		}else{
		menu = findString("Help");
		}
		leftClickMid(menu); delay(1500);
		menu.translate(menu.width + 15, menu.height / 2);
		mouseMove(menu.x, menu.y); delay(1000);
		keyType(VK_ESCAPE); delay(500);
	}
	
	public void spsFileHandling(Options op){
		
		assertWindow("Open SPS design");
		delay(1000);
		op.applyOption(this);
		
		leftClickMid(findComponent("OK", "Button", null));
		delay(500);
		
	}
	
	public void setCheckOptions(Option... options){
		
		Options opt = new Options();
		for (int i = 0; i< options.length ; i++)
			opt.add(options[i]);
		opt.applyOption(this);
	}
	
	public Rectangle getStringRectangle(String word, Font font){
		return(findString(word, font));
	}
	
	public void leftClickOnString(String word, Font font){
		Rectangle rec = findString(word, font);
		leftClickMid(rec);
	}
	public void moveMouseToString(String word, Font font){
		Rectangle rec = findString(word, font);
		moveMid(rec);
		
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
	/**
	 * If you want to search for string only is Main window just cold componentName parameter as MAIN
	 * @param word
	 * @param font
	 * @param componentName
	 */
	public void leftDoubleClickOnString(String word, Font font,String componentName){
		Rectangle rec = null;
		if (componentName == "MAIN" )
			rec = getMainWindow();
		else
			rec = findComponentName(componentName);
		
		Rectangle rec2 = findString(word, font, rec, false);
		doubleClickMid(rec2);
	}
	
	public void leftClickOnString(String word, Font font, String componentName){
		Rectangle rec = findComponentClass(componentName);
		leftClickMid(rec);
	}
	
	public void leftClickOnString(String word, Font font,Color text ){
		Rectangle rec = findString(word, font,text);
		leftClickMid(rec);
	}
	
	public void rightClickOnString(String word, Font font){
		Rectangle rec = findString(word, font);
		rightClickMid(rec);
	}
	
	public void rightClickOnString(String word, Font font,Color text ){
		Rectangle rec = findString(word, font,text);
		rightClickMid(rec);
		delay(10000);
		delay(10000);
		
	}
	
	public void rightClickOnString(String word, Font font, String componentName){
		Rectangle rec = findComponentName(componentName);
		Rectangle rec2 = findString(word, font, rec, false);
		rightClickMid(rec2);
	}
	public void expandCombobox(){
		keyRelease(VK_ALT); // We need to be sure that alt key is released.
		keyPress(VK_F4);
	}
}
