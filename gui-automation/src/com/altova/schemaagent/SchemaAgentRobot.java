package com.altova.schemaagent;

import static com.altova.stylevision.Tag.*;
import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;

import com.altova.nativegui.NativeGUI;
import com.altova.robots.AltovaApplicationRobot;
import com.altova.robots.CheckboxOption;
import com.altova.robots.ImageRecognitionRobot;
import com.altova.robots.Pane;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;
import com.altova.schemaagent.AbstractSchemaAgentTest.fileType;
import com.altova.stylevision.StyleVisionPane;
import com.altova.robots.ImageNotFoundException;




import com.altova.util.IOUtils;
import com.altova.util.Settings.AltovaApplication;

/**
 * Robot class specifically for SchemaAgent.
 * 
 * @author Davide Bugnone
 *
 */
public class SchemaAgentRobot extends AltovaApplicationRobot {

	private static final String BASEPATH = "schemaagent/";
	
	private final static String[] toolbarIds = { };

	public static final Color MGREY_BACK = new Color(220,220, 220);

	public final static Pane EXPLORER = new Pane("Explorer");
	public final static Pane OVERVIEW = new Pane("Overview");
	public final static Pane STATUSBAR = new Pane("Status Bar");
	
	/*public final static String HIERARCHICAL = "Hierarchical";
	public final static String FLAT = "Hierarchical";
	public final static String CONFIGURE_PATHS = "Configure Paths";*/
	
	enum TAB {Hierarchical, Flat, Configure_Paths};
	enum SEARCHPATH  {Add, Edit, Delete, Reload, Reset};
	enum extension {Add, Edit, Delete};
		
	
	protected static final File XMLSchemAgentCgfBatTest = IOUtils.findFile("schemaagent/SchemaAgentServerCfg.bat");
	protected static final File KillLocalServerProcess = IOUtils.findFile("schemaagent/KillLocalServerProcess.bat");
	
	protected static final String cmdCopyXMLSchemAgentCgfBatTest = XMLSchemAgentCgfBatTest.getAbsolutePath() + " \"" + System.getProperty("user.home") + "\"";
	protected static final String cmdKillLocalServerProcess = KillLocalServerProcess.getAbsolutePath();
	
	protected static final String [] subfoldersPaths = {"DB_CompletePO", "C:\\Work\\gui-automation\\data", "DB_CompletePO", "correctPathFolder"};
	
	protected static final File SHORTPO_XML_IMG = IOUtils.findFile("schemaagent/pic/shortPo_xml.PNG");
	protected static final File GUI_AUTOMATION_PATH_PICTURE = IOUtils.findFile("schemaagent/pic/guiAutomationPath.png");
	protected static final File GUI_AUTOMATION_COLLAPSE_ICON = IOUtils.findFile("schemaagent/pic/collapseIcon.png");
	
	public SchemaAgentRobot() {
		super("Altova SchemaAgent", AltovaApplication.SCHEMAAGENT, "SchemaAgent", "", toolbarIds);
		logger.fine("Created robot "+getClass().getName());
	}

	
	@Override
	public void startApplication() {
	
		super.startApplication();
		//addEscapeDialogAction("Connect to SchemaAgent Server", VK_ENTER);
		escapeDialog("Connect to SchemaAgent Server", VK_ENTER);
		
		//Added delay time to avoid the problem of Server Busy
		//Please remove all declaration when ttp 37307 is fixed
		//edited by dab 
		delayServerBusyAlert();
		

		//end of chenge for Server Busy warning message
		maximizeFileWindow();
		
		// I delete the A-Folder used for Automation GUI test 
		//that might be still available after last run
		try{
			navigateTo("Documents/A-NewFolder",Color.WHITE,Color.BLACK);
			contextmenu_select("Delete");
			keyType(KeyEvent.VK_Y);
		}catch (Exception e) {
			logger.fine("Folder \"Documents/A-NewFolder\" is not longer available: great! Test can start!!");
		}	
	
		
		
	}
	
	public void delayServerBusyAlert() {
		delay(5000);
		//Added delay time to avoid the problem of Server Busy
		delay(12000);
		logger.finest("Server Busy delay 12\"");
		delay(12000);
		logger.finest("Server Busy delay 24\"");
		delay(12000);
		logger.finest("Server Busy delay 36\"");
		delay(12000);
		logger.finest("Server Busy delay 48\"");
		delay(12000);
		logger.finest("Server Busy delay 60\"");
		escapeDialog("Server Busy", VK_R);
		logger.finest("End of Server Busy");
	}


	
	 public void deleteAndCreateSearchPath(String searchPath, boolean directory, boolean recursive, boolean relativePath, String username, String password, String browser, String URLfolder) {
		
		 
		 try {
			 deleteSearchPath();
		} catch (Exception e) {
			
			logger.fine("Search Path is not longer available. Try to recreate it. Reason:" + e.toString());
		}finally{
			setSearchPath(SEARCHPATH.Add, null, searchPath, directory, recursive, relativePath, username, password, browser, URLfolder);
			reloadSearchPaths();
		}
		
	}
	
	
	 public void deleteSearchPath(String pathToDelete){
		 
		 setSearchPath(SEARCHPATH.Delete, pathToDelete, null, false, false, false, null, null, null, "");
		 
		 
	 }
    

	private void setSearchPath(SEARCHPATH cmd, String oldSearchPath, String setSearchPath, boolean directory, boolean recursive, boolean relativePath, String username, String password, String browser,  String URLfolder ) {
		
		Rectangle explorer = activatePane(EXPLORER);
		
		navigateTo("Search paths", Color.WHITE, Color.BLACK, TAB.Configure_Paths);
		
		// To avoid problem to recongnize gui-auomation string, those command
		// are managed using a picture of gui automation path.
		if (!cmd.equals(SEARCHPATH.Add)){
			
			Rectangle path = null;
			if (oldSearchPath==null){
				path = findImage(GUI_AUTOMATION_PATH_PICTURE.getAbsolutePath(), explorer, false);
			}else{
				path = findString(oldSearchPath, explorer, false);
			}
			
			logger.fine(">>>>>Found picture in:" + path);
			rightClickMid(path);
			delay(500);
			contextmenu_select(cmd.toString() + " search path");
			// it might be: Edit search path,
			//				Delete search path,
			
			escapeDialog("Are you sure you want to delete the selected search path?", VK_Y);
			delay(1000);

			if (!cmd.equals(SEARCHPATH.Edit)) return;
		}else{
		
			contextmenu_select("Add search path");
		}
		
		delay(800);
		assertWindow("Add/Edit search path...");
		
		TextFieldOption path = new TextFieldOption("Path:", setSearchPath, "Search Path:");
		path.applyOption(this);
		
		if (username != null){
			
			CheckboxOption connect = new CheckboxOption("Connect using a different user name", true, "Identification");
			connect.applyOption(this);
			
			TextFieldOption user = new TextFieldOption("Username:", username, "Identification");
			user.applyOption(this);

			TextFieldOption pwd = new TextFieldOption("Password:", password, "Identification");
			pwd.applyOption(this);
			
		}
		
		RadioOption dirURL = null;
		
		if (directory){
			dirURL = new RadioOption("Directory", "Search Path:");
			dirURL.applyOption(this);
			
			CheckboxOption rel_path = new CheckboxOption("Relative Path", relativePath, "Search Path:");
			rel_path.applyOption(this);
			
		}else{
			dirURL = new RadioOption("URL", "Search Path:");
			dirURL.applyOption(this);
			
			if (browser != null){
				TextFieldOption user = new TextFieldOption("Server URL:", browser, "Browse:");
				user.applyOption(this);
				
				//leftClickMid(findString("Browse", MS_SHELL_DLG_FONT));
				//leftClickMid(findComponent("Browse", "Button", null));
				
				
				
				keyTypeAlt(VK_B);
			}
			delay(1000);
			
			//select a folder using a URL address
			//I will scroll the scrollbar if is necessary
			for (double sc = 0; sc <= 1; sc += 0.25) {

				Rectangle temp= null;
				try {
					
					temp = findString(URLfolder, WINDOWS_DEFAULT_FONT, findComponentClass("Browse:"), false);
					if (temp != null) { 
						leftClickMid(temp);
						//okNewDocument = true;
						break;
					}
					
				} catch (ImageNotFoundException e1) {
					logger.finer(">>>String not found. Following to search..temp=" + temp);
					scroll(explorer, sc);
				}// 

				
			}
			
		}// else
		
		CheckboxOption recurs = new CheckboxOption("Recursive", recursive, "Search Path:");
		recurs.applyOption(this);
		
		
		leftClickMid(findString("OK", MS_SHELL_DLG_FONT));
	}


	public void deleteSearchPath() {
		
		setSearchPath(SEARCHPATH.Delete, null, null, false, false, false, null, null, null, "");
		reloadSearchPaths();
	}

	
	public void expandPath() {
	
		Rectangle explorer = activatePane(EXPLORER);
		
		switchView(EXPLORER, TAB.Hierarchical);
		//leftClick(explorer.x+10, explorer.y+explorer.height-80);
		
		explorer = activatePane(EXPLORER);
		collapseSubFolder();
		Rectangle path = findImage(GUI_AUTOMATION_PATH_PICTURE.getAbsolutePath(), explorer, false);
		logger.fine(">>>>>Found picture in:" + path);
		leftClickMid(path);
		delay(1000);
		typeString("+");

	}

	@Override
	public void exitApplication() {
		CheckboxOption shutdown = new CheckboxOption("Shutdown on disconnect of last client", true,
				null, null, null, "Miscellaneous",MS_SHELL_DLG_FONT);
		setOptions(shutdown);
		exitWithoutSave();
	}
	
	public void exitWithoutSave() {
		
		logger.fine("Exit without save");
		leftClickMenuItem("File", "Exit  "); delay(1000);
		addEscapeDialogAction("Save changes to", VK_N);
		waitAndEsacpe("");
	}
	
	public void closeWithoutSave() {
		
		logger.fine("close without save");
		leftClickMenuItem("File", "Close All"); delay(1000);
		addEscapeDialogAction("Save changes to", VK_N);
		waitAndEsacpe("");
	}
	
	public void closeAll(){
		
		leftClickMenuItem("File", "Close All");
		addEscapeDialogAction("Save changes to", VK_N);
		waitAndEsacpe("");
	}
	
	/**
	 * open new empty design
	 */
	public void newDesign() {
		logger.fine("create new Design");
		leftClickMenuItem("File", "New  "); delay(1000);
		maximizeFileWindow();
	}

	
	public void openFile(File filename){
		leftClickMenuItem("File", "Open");
		delay(2000);
		assertWindow("Open");
		logger.fine(">>>>asd" + filename);
		logger.fine(">>>>sdf" + filename.getAbsolutePath());
		typeStringEnter(filename.getAbsolutePath());
		delay(500);
		keyPress(VK_ESCAPE);
		maximizeFileWindow();
	}
	
	/**
	 * navigate to file or folder in explorer pane
	 * @param path
	 * @return
	 */
	public Rectangle navigateTo(String path, Color back, Color text, TAB SaTAB) {
		String elements[] = path.split("/");
		
		Rectangle explorer = activatePane(EXPLORER);
		//make sure explorer pane is active
		switchView(EXPLORER, SaTAB);
		
		if (SaTAB.equals(TAB.Flat)){
			
			leftClickMid(findString("Name", DEFAULT_CONTENT_FONT, explorer, false));
			
			for (double sc = 0; sc <= 1; sc += 0.10) {

				Rectangle temp= null;
				try {
					
					temp = findString(path, DEFAULT_CONTENT_FONT, explorer, false);
					if (temp != null) {
						delay(1000);
						leftClickMid(temp);
						break;
					}
					
				} catch (ImageNotFoundException e1) {
					logger.finer(">>>String not found. Following to search..temp=" + temp);
					scroll(explorer, sc);
					
				}// 

				
			}
			return null;	
			
		}
		
		Rectangle ans = null;
		for (String e : elements) {
			//make sure we get the right element; not one only containing the element word
			ans = findTag(e+" ", back,text);
			leftClickMid( ans );
			mouseMove(ans.x+180,ans.y);   //move mouse to remove tooltip
			delay(100);
			typeString("+");   //press + to expand one level
			//leftClick(ans.x-22, ans.y);   //  click the "+" icon 
		}
		mouseMove(ans.x,ans.y);   //move mouse back to selection 
		return ans;
	}
	
	public Rectangle navigateTo(String path, Color back, Color text){
		
		return navigateTo(path, back, text, TAB.Hierarchical);
	}
	
	public void switchView(Pane pane, TAB tab) {
		
		String _tab = tab.toString();
		_tab = _tab.replace("_", " ");
		
		Rectangle explorer = activatePane(pane);

		//I click with the mouse in bottom of the pane just to change the focus on objedct, hoping that
		//the area where I click, it is empty.
		leftClick(explorer.x+10, explorer.y+explorer.height-80);
		logger.fine("CLICK!!!" + (explorer.x+10) + ","  + (explorer.y+explorer.height-30));
		delay(2000);

		
		if (tab != null){
			try {
			
				leftClickString(_tab, WINDOWS_DEFAULT_FONT, Color.BLACK, explorer);
			} catch (Exception e) {
				//in case the tab is already selected, we ensure to search with another text color
				leftClickString(_tab, WINDOWS_DEFAULT_FONT, new Color(64, 64, 64), explorer);
			}
		}	
		
	}


	/**
	 * 
	 * TODO: should be renamed/re-factored?
	 * 
	 * @param string
	 * @param back
	 * @param text
	 * @return n/a
	 */
	public Rectangle findTag(String string, Color back, Color text) {
		//super.compareState = ImageRecognitionRobot.PixelCompare.FULL_COLOR;
		//try {
			return findString(string, DEFAULT_CONTENT_FONT, back, text);
		//}
		//finally {
			//compareState = DEFAULT_PIXEL_COMPARE;
		//}
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
	 * Sets the active Explorer View
	 * 
	 * @param view
	 */
	public void setView(View view) {
		leftClickImage(view.file);
	}

	public enum View {
		
		HIERARCH_VIEW(BASEPATH+"hierarc_inactive.bmp"), 
		FLAT_VIEW(BASEPATH+"flat_inactive.bmp"), 
		CONFIG_VIEW(BASEPATH+"configu_inactive.bmp");
		
		String file;
		
		View(String file) {
			this.file = file;
		}
	}
	
	/**
	 * drag selection to current design
	 * @param Folder
	 * @param FileName
	 * @param dest
	 */
	public void dragtoDesign(String selection,Point dest){
		Rectangle myselect=navigateTo("Documents/ExpReport",Color.WHITE,Color.BLACK);
		leftClick(myselect.x, myselect.y);   						//select the first item
		delay(500);
		//Point to = new Point(dest.x,dest.y);
		dragDrop(myselect.getLocation(), dest);
		delay(500);
	}
	
	public Point getPoint(int x, int y){
		Point mypoint=null;
		mypoint=new Point(x,y);
		return mypoint;
	}
	
	public void contextmenu_select(String path) {
		String items[] = path.split("/");
		rightClick();
		for (String s : items) {
			leftClickString(s);
			delay(1000);
		}
	}


	public void exportToImage(File newFileName) {
		leftClickMenuItem("File", "Export to image...");
		
		delay(2000);
		assertWindow("Save As");
		typeStringEnter(newFileName.getAbsolutePath());
		delay(500);
		keyPress(VK_ESCAPE);
	
	}


	public void saveFile() {
		leftClickMenuItem("File", "Save");
	}


	public void saveFileAs(File newFileName) {
		leftClickMenuItem("File", "Save As...");
		
		delay(2000);
		assertWindow("Save As");
		typeStringEnter(newFileName.getAbsolutePath());
		delay(500);
		keyPress(VK_ESCAPE);
	}
	
	public void selectAll(){
		
		keyTypeCtrl(VK_A);
		
	}

	public void syncronizeSelection(){
		leftClickMenuItem("Edit", "Synchronize Selection");
		
	}

	public void recreate() {
		leftClickMenuItem("Edit", "Recreate");
	}


	public void reloadSearchPaths() {
		leftClickMenuItem("Extras", "Reload search paths");
		delayServerBusyAlert();
		
	}
	
	public Rectangle findElementOnDiagram(String ...element){
		
		return findElementOnDiagram(subfoldersPaths, element);
	}
	
	public Rectangle findElementOnDiagram(String[] pathToOpen, String ...element){
		
		Rectangle hint = activatePane(EXPLORER);
		switchView(EXPLORER, TAB.Hierarchical);
		delay(1000);
		int ind = 1;
		Rectangle res2 = null;
		Rectangle res = null;
		
		
		for (String string : element) {
			
			
			try {
		
				// I search immediately the element
				res = findString(string, DEFAULT_CONTENT_FONT, hint, false);

				if (res != null){
				
					if (ind>1){
						keyPress(VK_CONTROL);
						leftClickMid(res);
						keyRelease(VK_CONTROL);	
					}else{
						leftClickMid(res);
					}
					ind++;
				
				}	
			}catch (ImageNotFoundException e) {
				
				logger.fine("Folder: " + string + " not founded. Search in Explorer sub-menus");
				//..If dont find it, 1) I will collapse all the subfolder and then I will expand it
				//in Explorer pane 
				// (probably file is hidden inside the paths)
				
				collapseSubFolder();
				switchView(EXPLORER, TAB.Hierarchical);
				
				
				for (int i=0; i < pathToOpen.length ; i++) {
				
					activatePane(EXPLORER);
					scrollSubFolder(hint, pathToOpen[i]);
				
					try {
					
						res2 = findString(string, DEFAULT_CONTENT_FONT, hint, false);
				
						if (res2 != null){
							
							if (ind>1){
								keyPress(VK_CONTROL);
								leftClickMid(res2);
								keyRelease(VK_CONTROL);	
							}else{
								leftClickMid(res2);
							}
							ind++;
							break;
						}
					}catch (ImageNotFoundException ex) {
						logger.fine("in sub folder: " +  pathToOpen[i] + ", " + string + " not founded. Continue to search...");
						
					}catch (Exception exx) {
						logger.fine("General exception searching: " +  pathToOpen[i] + ", " + string + ": >>> " + exx.toString());
					}
						

				}//for
			}	
						
		}		
		delay(1000);	
		syncronizeSelection();

		if (res != null) 
			return res;
		else
			return res2;
		
	}
	
	private void collapseSubFolder() {
			
		Rectangle hint = activatePane(EXPLORER);
		
		try {
			for (int i = 0; i < 25; i++) {
				leftClickMid(findImage(GUI_AUTOMATION_COLLAPSE_ICON.getAbsolutePath(), hint, false));
				logger.finest("A COLLAPSE!!!!");
			}//for	
		} catch (Exception e) {
			logger.finest("No Collapse icons are been recognized: " + e.toString());
		}
		
	}


	private void scrollSubFolder(Rectangle hint, String sub){
		
		try {

			Rectangle foldToOpen = findString(sub, DEFAULT_CONTENT_FONT, hint, false);
			
			if (foldToOpen != null){
				doubleClickMid(foldToOpen);
			}

			
		} catch (ImageNotFoundException e) {
			
			logger.fine("Sub folder: " + sub + " not founded.");
		}
	}


	public void showGrid() {
		
		leftClickMenuItem("Layout", "Show Grid");
		
	}


	public void alignOnGrid() {
		
		leftClickMenuItem("Layout", "Align on Grid");
		
	}
	
	public void zoom (int percentage){
		
			if (percentage == 50 || percentage == 75 || percentage == 100 || percentage == 150 || percentage == 200 )
				leftClickMenuItem("Layout", "Zoom", percentage+"%");
			else
				zoomZoom(percentage);
	}
	
	public void zoomZoom (int percentage){
		
    	leftClickMenuItem("Layout", "Zoom", "Zoom...");
    	delay(500);
    	
    	assertWindow("Zoom");
    	
    	TextFieldOption perc = new TextFieldOption("%", ""+percentage);
    	perc.setX2(-38);
    	
    	perc.applyOption(this);
    	
		leftClickMid(this.findComponent("OK", "Button", null));
		delay(500);
    	
	}


	public void zoomToFit() {
		leftClickMenuItem("Layout", "Zoom", "Zoom to Fit");
		
	}
	
	public void zoomToSelection() {
		leftClickMenuItem("Layout", "Zoom", "Zoom to Selection");
		
	}


	public void forceDirected() {
		leftClickMenuItem("Layout", "Layout", "Force Directed");
		
	}
	
	public void hierarchical() {
		leftClickMenuItem("Layout", "Layout", "Hierarchical");
		
	}


	public void alignEdges(String string) {
		leftClickMenuItem("Layout", "Align Edges", string);
		
	}


	public void lineUp(String string) {
		 leftClickMenuItem("Layout", "Line Up", string);
		
	}


	public void bringToBottom() {
		leftClickMenuItem("Layout", "Order", "Bring to Bottom");
		
	}


	public void makeSameWidth() {
		leftClickMenuItem("Layout", "Resize", "Make same width");
		
	}


	public void makeSameHeight() {
		leftClickMenuItem("Layout", "Resize", "Make same height");
		
	}


	public void makeSameSize() {
		leftClickMenuItem("Layout", "Resize", "Make same size");
		
	}


	public void spaceEvenly(String string) {
		leftClickMenuItem("Layout", "Space Evenly", string);
		
	}


	public void sortAscending(String string) {
		leftClickMenuItem("Layout", "Sort", string, "Ascending");
		
	}


	public void sortDescending(String string) {
		leftClickMenuItem("Layout", "Sort", string, "Descending");
		
	}


	public void connectToServer() {
		leftClickMenuItem("Extras", "Connect to server");
		
	}


	public void correctReferencePath(File name) {
		leftClickMenuItem("Extras", "Correct reference paths");
		
		assertWindow("Correct reference path");
		
		Rectangle hint = findComponentName("Correct reference path");
		
		if (hint != null){		
			//leftClick(name.getAbsolutePath(), hint, false);
			leftClickString(name.getAbsolutePath(), DEFAULT_CONTENT_FONT, Color.BLACK, hint);
		}
		delay(1000);
		
		leftClickMid(this.findComponent("Yes", "Button", null));
		delay(500);
		
	}


	public void insertFileIntoCurrentDesign(Rectangle rectangle) {
		
		rightClickMid(rectangle);
		
		leftClickMid(findString("Insert into current design"));
		
		
	}


	public void correctAllReferencePath() {
		
		leftClickMenuItem("Extras", "Correct all reference paths");
		
		assertWindow("Correct all references to non-existing files");
		
	}


	public void search() {
		
	
		rightClickMid(findImage(SHORTPO_XML_IMG.getAbsolutePath()));

	
		
	}

	
	public void setExtension(extension operation, String ext){
		setExtension(operation, ext, null);
	}

	/*
	 * operation: Add for add a new extension, delete to delete the extension. Use extension enumeration param
	 * ext: is the string that is shown in "File extension" and represent the main group of extensions: XML, WSDL, Schema,.. 
	 * name: the extension to mange: xsl, xbrl, xml, mfd,... 
	 */
	public void setExtension(extension operation, String ext, String name) {
		
		
		Rectangle explorer = activatePane(EXPLORER);
		switchView(EXPLORER, TAB.Configure_Paths);
		delay(1000);
		//
		Rectangle fileExtensionString = findString("File extensions", DEFAULT_CONTENT_FONT, explorer, false);
		
		Rectangle searchExtensionArea = new Rectangle(fileExtensionString.x,
													fileExtensionString.y,
													explorer.width-fileExtensionString.x,
													explorer.height-fileExtensionString.y);
		
		
		rightClickMid(findString(ext, DEFAULT_CONTENT_FONT, searchExtensionArea, false));
		delay(1000);
		contextmenu_select(operation.toString() + " file extension");
		
		if(operation.equals(operation.Delete)){
			escapeDialog("Are you sure you want to delete the selected file extension?", VK_Y);
			
		}else if(operation.equals(operation.Add)){
			if (name==null) throw new NullPointerException("Parameter \"name\" cannot be null in Add operation");
			typeStringEnter(name);
			
		}else{
			// case operation.Edit to implement when is necessary
			
		}
		reloadSearchPaths();
	}

	//Advanced GUI Implementation
	
	public void findObjectInDiagram(File objectIcon) {
		
		Rectangle path = findImage(objectIcon.getAbsolutePath(), null, true);
		logger.fine(">>>>>Found picture in:" + path);
		rightClickMid(path);
		delay(1000);

	}
	
	public void findObjectInDiagramExpandAll(File objectIcon) {
		
		findObjectInDiagram(objectIcon);
		leftClickMid(findString("Expand all", null, true));

	}



}


