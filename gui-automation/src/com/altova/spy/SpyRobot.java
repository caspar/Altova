package com.altova.spy
y
import static com.altova.robots.ImageRecognitionRobot.DEFAULT_CONTENT_FONT;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;
import static com.altova.robots.ImageRecognitionRobot.TRANSPARENT;
import static com.altova.robots.ImageRecognitionRobot.WINDOWS_DEFAULT_FONT;
import static com.altova.util.LoggerUtils.logger;
import static java.awt.Color.BLACK;
import static java.awt.event.KeyEvent.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.altova.nativegui.ComponentInfo;
import com.altova.nativegui.NativeGUI;
import com.altova.robots.AbstractOption;
import com.altova.robots.AltovaApplicationRobot;
import com.altova.robots.ApplicationErrorException;
import com.altova.robots.ApplicationRobot;
import com.altova.robots.CheckboxOption;
import com.altova.robots.DropDownOption;
import com.altova.robots.FontOption;
import com.altova.robots.ImageNotFoundException;
import com.altova.robots.ImageRecognitionRobot;
import com.altova.robots.ImageUtils;
import com.altova.robots.Option;
import com.altova.robots.Options;
import com.altova.robots.Pane;
import com.altova.robots.PluginRobot;
import com.altova.robots.RadioOption;
import com.altova.robots.ScreenDiff;
import com.altova.robots.ScriptMistakeException;
import com.altova.robots.SnapshotArea;
import com.altova.robots.TabPane;
import com.altova.robots.TextFieldOption;
import com.altova.robots.FontOption.FontSettings;
import com.altova.util.IOUtils;
import com.altova.util.Settings;
import com.altova.util.Settings.AltovaApplication;
import com.altova.util.Settings.ApplicationSettings;
import com.altova.robots.TextFieldOption;
import com.altova.spy.ChartsTest.Sizes;
import com.altova.util.RegressionAssert;



/**
 * Robot class specifically for XMLSpy.
 * 
 * @author Havard Rast Blok
 * @author Beatriz Lopez Garcia
 * @author Davide Bugnone
 *
 */
public class SpyRobot extends AltovaApplicationRobot {
	

	/**
	 * Base path in data folder, where various robot and test related files can be found.
	 */
	
	/**
	 * change for private static String BASEPATH =
	 * "CVSROOT/gui-automation/data/spy/"; when running ProjectTestcasesSuite*
	 */
	 
	private final static String BASEPATH = "spy/";
	//private final static String BASEPATH ="C:/work/gui-automation/data/spy/";
	
	
	private final static String[] toolbarIds = { "IDT_SOAP_DEBUGGER_TOOLBAR",
		"IDT_TAMINO_TOOLBAR",
		"IDT_XSLT_DEBUGGER_TOOLBAR",
		"IDT_ORACLE_XML_DB_TOOLBAR",
		"IDT_XMLDIFF_TOOLBAR",
		"IDR_MAINFRAME",
		"IDT_FONT_SETTINGS",
		"IDT_COLOR_BUTTON",
		"IDT_GRID_TABLE",
		"IDT_GRID_EDIT",
		"IDT_BROWSER",
		"IDT_GRID_COMMON",
		"IDT_PROJECT",
		"IDT_DTD_SCHEMA",
		"IDT_WINDOW",
		"IDT_EDIT",
		"IDT_XSL",
		"IDT_GRID_SETTINGS",
		"IDT_HELP",
		"IDT_CONTENT",
		"IDT_CONVERT",
		"IDT_TEXT",
		"IDT_SOAP_DEBUGGER_TOOLBAR",
		"IDT_XML_TABLE",
		"IDT_TAMINO_TOOLBAR",
		"IDT_XSLT_DEBUGGER_TOOLBAR",
		"IDT_ABOUT",
		"IDT_ORACLE_XML_DB_TOOLBAR",
		"IDT_XMLDIFF_TOOLBAR",
		"IDT_SCHEMA_VIEW", };
	
	public static Pane PROJECT = new SpyPane("Project", "Project window");
	public static SpyPane INFO = new SpyPane("Info", "Info window");
	public static SpyPane ELEMENTS = new SpyPane("Elements", "Entry Helpers");
	
	public static SpyPane CSS_OUTLINE = new SpyPane("CSS Outline", "Entry Helpers");
	public static SpyPane CSS_PROPERTIES = new SpyPane("CSS Properties", "Entry Helpers");
	public static SpyPane CSS_ELEMENTS = new SpyPane("HTML Elements", "Entry Helpers");
	
	public static SpyPane XQUERY_KEYBOARDS = new SpyPane("XQuery Keywords", "Entry Helpers");
	public static SpyPane XQUERY_VARIABLES = new SpyPane("XQuery Variables", "Entry Helpers");
	public static SpyPane XQUERY_FUNCTIONS = new SpyPane("XQuery Functions", "Entry Helpers");
	
	public final static SpyPane DETAIL = new SpyPane("Detail", "Entry Helpers");
	
		
	//	TODO treat as exceptional case
	public final static SpyPane SCHEMA_OVERVIEW = new SpyPane("SchemaOverview", "Schema/WSDL Design View" ) ; 
	
	public final static SpyPane COMPONENTS = new SpyPane("Components", "Entry Helpers");
	public final static TabPane COMPONENTS_BY_TYPE = new TabPane(COMPONENTS, "by Type");
	public final static TabPane COMPONENTS_BY_NAMESPACE = new TabPane(COMPONENTS, "by Namespace");
	
	public final static SpyPane ATTRIBUTES = new SpyPane("Attributes", "Entry Helpers");
	public final static TabPane ATTRIBUTES_APPEND = new TabPane(ATTRIBUTES, "Append");
	public final static TabPane ATTRIBUTES_INSERT = new TabPane(ATTRIBUTES, "Insert");
	public final static TabPane ATTRIBUTES_ADD_CHILD = new TabPane(ATTRIBUTES, "Add child");
	
	public final static SpyPane ENTITIES = new SpyPane("Entities", "Entry Helpers");
	public final static TabPane ENTITIES_APPEND = new TabPane(ENTITIES, "Append");
	public final static TabPane ENTITIES_INSERT = new TabPane(ENTITIES, "Insert");
	public final static TabPane ENTITIES_ADD_CHILD = new TabPane(ENTITIES, "Add child");
	
	public final static SpyPane DETAILS = new SpyPane("Details", "Entry Helpers");
	public final static TabPane DETAILS_DETAILS = new TabPane(DETAILS, "Details");
	public final static TabPane DETAILS_SIMPLE_TYPE = new TabPane(DETAILS, "SimpleType");
	public final static TabPane DETAILS_ORACLE = new TabPane(DETAILS, "Oracle");
	public final static TabPane DETAILS_SQL_SERVER = new TabPane(DETAILS, "SQL Server");
	
	public final static SpyPane FACETS = new SpyPane("Facets", "Entry Helpers");
	public final static TabPane FACETS_FACETS = new TabPane(FACETS, "Facets");
	public final static TabPane FACETS_PATTERNS = new TabPane(FACETS, "Patterns");
	public final static TabPane FACETS_ENUMERATIONS = new TabPane(FACETS, "Enum");
	public final static TabPane FACETS_SAMPLES = new TabPane(FACETS, "Samples");
	
	public final static SpyPane OVERVIEW = new SpyPane("Overview", "Entry Helpers");
	public final static SpyPane GLOBAL_ELEMENTS=new SpyPane("Global Elements","Entry Helpers");
	public final static SpyPane VALIDATION = new SpyPane("Messages", "Output windows");
	public final static SpyPane XPATH = new SpyPane("XPath", "Output windows");
	public final static SpyPane XSL_OUTLINE=new SpyPane("Stylesheet Outline","Output windows");
	
	public final static SpyPane MESSAGES=new SpyPane("Messages","Entry Helpers");
	
	//public final static SpyPane CHARTS = new SpyPane("Charts","Output windows");
	public final static Pane CHARTS = new Pane("Charts");
	public final static Font MS_SHELL_DLG_FONT_BOLD    = new Font("Microsoft Sans Serif", Font.BOLD, 11);
	public final static Font DEFAULT_CONTENT_FONT_BOLD = new Font("Arial", Font.BOLD, 11);
	public final static Font WINDOWS_DEFAULT_FONT_BOLD = new Font("Tahoma", Font.BOLD, 11);


	
	enum CHART {Pie, Bar, Line, Area, Candlestick, Gauge}
	enum PIE { Pie_Chart_2d, Pie_Chart_3d}
	enum BAR {Bar_Chart, Stacked_Bar_Chart, Bar_Chart_3d, Bar_Chart_3d_Grouped}
	enum LINE {Line_Chart, Value_Line_Chart}
	enum AREA {Area_Chart, Stacked_Area_Chart}
	enum CANDLESTICK {Candlestick_Chart}
	enum GAUGE {Round_Gauge, Bar_Gauge}
	
	public final static Pane SOAP_DEBUGGER = new Pane("Soap Debugger");
	public final static Pane FUNCTION_BREAKPOINTS = new Pane("Function-Breakpoints");
	public final static Pane CONDITIONAL_BREAKPOINTS = new Pane("Conditional-Breakpoint");
	protected static final File GUI_AUTOMATION_EXPAND_ICON = IOUtils.findFile("spy/res/expand.png");
	protected static final File SOAP_FUNCTION_BREAKPOINT_ICON = IOUtils.findFile("spy/res/SOAP_function_breakpoint.png");
	protected static final File SOAP_DEBUGGER_TURNON_BUTTON_ICON = IOUtils.findFile("spy/res/turnOnSOAPDebuggerClient.png");
	protected static final File SOAP_DEBUGGER_TURNOFF_BUTTON_ICON = IOUtils.findFile("spy/res/turnOffSOAPDebuggerClient.png");
	
	protected static final File X_AXIS_SIZES_ICON =IOUtils.findFile("spy/res/Charts/X-Axis_Sizes.png");
	protected static final File Y_AXIS_SIZES_ICON =IOUtils.findFile("spy/res/Charts/Y-Axis_Sizes.png");
	
   	protected static final File XPATH_AUTOCOMPLETION_DISABLED =IOUtils.findFile("spy/res/Xpath_autocompletion_disabled.png");
   	
   	protected static final File DOWN_ARROW        =IOUtils.findFile("spy/res/down_arrow.png");
   	protected static final File ADD_RAPTOR_SERVER =IOUtils.findFile("spy/res/add_green_cross.png");
	
	enum breakpointFunction {Add, Delete, Change}
	
	/**
	 * Construct a robot for XMLSpy stand-alone application.
	 *
	 */
	public SpyRobot() {
		this("Altova XMLSpy", AltovaApplication.XMLSPY, "XML Spy");
	}
	
	/**
	 * Construct a robot for XMLSpy plugins.
	 *
	 */
	protected SpyRobot(String appName, ApplicationSettings app) {
		this(appName, app, "XML SpyControl");
	}
	
	private SpyRobot(String appName, ApplicationSettings app, String appRegKey) {
		super(appName, app, appRegKey, BASEPATH+"XMLSpy.rc", toolbarIds);
		
		addSettingsRegistryKey(	"LastStates", "Recent File List", "Recent Project List", "Settings","URL","SchemaFonts","TextFonts","DesignFonts","GridFonts","NoDefaultTable","NoOutFormat",
				"UI_E2007sp2_English", "UI_E2007r3_English", "UI_E2007r3sp1_English", "UI_E2008_English","UI_E2008r2_English","UI_E2009_English","UI_E2008r2sp1_English" );
	}

	//---------------------------------------------------------------------------------------
	//-----------------------------               FILE MENU  -----------------------------
	//---------------------------------------------------------------------------------------
	
	//public void 
	
	
	public void newFile(String filetype) {
		
		leftClick("ID_FILE_NEW");
		Rectangle new_doc_wind = findComponentName("Create new document");
	
		File fileType = IOUtils.findFile("spy/fileNew/" + filetype + ".png");
         
		try {
		  
		  logger.finest(">>>String: <" + filetype + ">"); 	
		  //new: before, I search in the window.
		  if(this instanceof VSnetSpyRobot){
			  Rectangle temp = findString(filetype, DEFAULT_CONTENT_FONT, new_doc_wind, false);
			  if (temp != null) { 
				  leftClickMid(temp);
				  //keyType(VK_ENTER);

			  }
		  }else{
			  //the file is searched by matching the picture that is stored in 
			  //spy/FileNew folder
			  Rectangle temp = findImage(fileType.getAbsolutePath(), new_doc_wind, false);
			  if (temp != null) { 
				  leftClickMid(temp);
				
			  }
		  }	  
		  
		} catch (ImageNotFoundException e1) {
			logger.finest(">>>String not found. I scroll down the bar");
//			othwerwise I sroll the window
			
			scrollNewFile(fileType.getAbsolutePath(), new_doc_wind);
				
		}
		  
		delay(250);
		leftClickString("OK", MS_SHELL_DLG_FONT, Color.BLACK, new_doc_wind);
		delay(900);
	}	
	
	public void newFile(String filetype, String par) {
		
		//implementation to allow eclipse to get different file name in Eclipse 
		newFile(filetype);
	}
	
	public boolean findNewFileInWindows( String filetype, Rectangle new_doc_wind){
		
		Rectangle temp = null;
		try {
			if(this instanceof VSnetSpyRobot){
				temp = findString(filetype, DEFAULT_CONTENT_FONT, new_doc_wind, false);
					if (temp != null) { 
						leftClickMid(temp);				
					}else{
					
					}	
			}else{
				temp = findImage(filetype, new_doc_wind, false);
					if (temp != null) { 				 	
						leftClickMid(temp);
					}
			
			}
			
		
		} catch (ImageNotFoundException e1) {
			logger.finer(">>>String not found. Esc from method with false=" + temp);
		
		}// 	
			
			if (temp == null) return false;
			else return true;
		
	}
	
	
	public void scrollNewFile(String filetype, Rectangle new_doc_wind){	

		boolean secondAtt= false;
		
		keyType(VK_DOWN);
		delay(500);
		secondAtt = findNewFileInWindows(filetype, new_doc_wind);
		
		if (!secondAtt) {
			keyType(VK_UP);
			delay(500);
			keyType(VK_UP);
			delay(500);			
			secondAtt = findNewFileInWindows(filetype, new_doc_wind);
		}	
		
		if (secondAtt) {
			return;
		}
		
		Rectangle temp = null;		
		
	   	for (double sc = 0; sc <= 1; sc += 0.20) {
		
	   	scrollWindow(new_doc_wind, sc);	   	
	   	
		try {
			if(this instanceof VSnetSpyRobot){
				 temp = findString(filetype, DEFAULT_CONTENT_FONT, new_doc_wind, false);
					if (temp != null) { 
						leftClickMid(temp);
						//okNewDocument = true;
						break;
					}else{
						
					}	
			}else{
				 temp = findImage(filetype, new_doc_wind, false);
				 if (temp != null) { 				 	
					leftClickMid(temp);
					break;
				 }
				
			}	
							
		} catch (ImageNotFoundException e1) {
			logger.finer(">>>String not found. Following to search..temp=" + temp);
		
		}// 
			
	   }//for
	   	
	   if (temp==null){
		   keyType(VK_ESCAPE);
		   keyType(VK_ESCAPE);
		   throw new ImageNotFoundException("Image:" + filetype + " doesn´t match with any string on FileNew window");	   		   	
	   }
	}
	
	public void newFile(String filetype,RadioOption options,String dialogtype,String filename, String element){
		newFile(filetype);
		delay(2000);
		
		if(options!=null||dialogtype!=null){
		
	    /* Move the focus from the option area: the risk is that the focus could dirt *
	     * the image recognition.                                                     *
	     *                                                                            *                                                                    */
			
		delay(500);
		keyType((KeyEvent.VK_DOWN));
		delay(500);
		keyType((KeyEvent.VK_DOWN));
		delay(1000);
		applyOptionsEnter(dialogtype, options);
		
		}
		if(filename!=null){
		delay(1000);
		Rectangle forwind=NativeGUI.getForegroundWindowInfo().getLocation();
		try{
			Rectangle choosefile=findComponent("Choose a file", "Button",forwind);
			leftClick(choosefile.x+30,choosefile.y+20);	
		}catch(NullPointerException e){
			//do nothing as the two lines above are just necessary for a certain type of dialog
		}
		
		typeFileName(" "+filename);
		}
		
		//handle the root element to choice:
		//new function since v2014
		//if no "Select root element is necessary (for a Plain file or with dtd choice),
		//no further action is necessary
		if (element!=null){
			
			assertWindow("Select a root element:");
			Rectangle rootWindow = findComponentName("Select a root element:");
			
			try {
								
				Rectangle XSDelement = findString(element, DEFAULT_CONTENT_FONT, rootWindow, false);
				leftClickMid(XSDelement) ;
				clickButton("OK");
			
			} catch (Exception e) {
				scrollNewFile(element, rootWindow);
				System.out.println("Element <" + element + "> not found. Scroll the bar.");
			}
						
		}//element != null
		
	}
	
	/**This method just makes sense in Eclipse and is just needed before the NewFileMenuTest, so it will be 
	 * empty for the standard app and for VS
	 */
	
	public void createSpyProjectInEclipse(){
		//do nothing
		
	}
	
	
	/**
	 * This method creates a new file extension in the options dialog. 
	 * @param newfileext
	 */
	public final void addNewFileExtension(String newfileext) {
		
		boolean found= false;
		Rectangle options= findComponent("Options",null,null);
		leftClickMid(findString("File types", MS_SHELL_DLG_FONT, options, false));
		delay(1000);
		leftClick();//this is to focus in the tab
		delay(1000);
		keyType(VK_TAB);//focus on the file extensions list	
		Rectangle file_typ_section = findComponent("File types", "Button", options);
		
		for (double sc = 0; sc <= 1; sc += 0.5) {

			if (found == true) {
				break;
			}

			for (int trial = 0; trial < 2; trial++) {
				try {
					scrollWindow(file_typ_section, sc);
					Rectangle fileext = findString(newfileext, DEFAULT_CONTENT_FONT, options, false);
					leftClickMid(fileext);
					leftClickMid(findComponent("Delete selected file extension", "Button", options));
					found = true;
					break;
				} catch (ImageNotFoundException e) {
					// maybe it is selected
					if (trial == 0) {
						logger.finest("Trying unselecting the file extension");
						keyType(VK_UP);
						delay(500);
					} else {
						logger.finest("Could not find file extension " + newfileext);
					}
				}
			}
		}	
		leftClickMid(findComponent("Add new file extension", "Button",options));
		typeStringEnter(newfileext);
	}
	
	/**
	 * Opens the specified file. This method should only be called by subclasses
	 * of the SpyRobot which wishes to override the
	 * {@link SpyRobot#openFile(String)} method to provide a different way to
	 * access the Spy specific open dialog.
	 * 
	 * After the file is opened, the new internal window will be maximised.
	 * 
	 * @param name
	 *            path and filename.
	 * @param menuitems
	 *            text on menu and menu items to get to the open dialog
	 */
	protected void openFile(String name, String... menuitems) {
		checkFile(name);
		leftClickMenuItem("File", menuitems); delay(1000);
		typeFileName(name); delay(3000);
		if(!(this instanceof PluginRobot)){
			maximizeFileWindow();
		}
		
	}

	
	/**
	 * Opens the specified file.
	 * After the file is opened, if is a sps file is managed the window dialog wher
	 * you can select how to open the file: then the new internal window will be maximised.
	 * @param name path and filename.
	 */
	public void openFile(String name, boolean isSpsFile, Options opt) {
		
		checkFile(name);
		//leftClick("ID_FILE_OPEN");delay(1000);
		//openFile(name);
		if(this instanceof VSnetSpyRobot){
			leftClickMenuItem("File", "Open", "File");
		}else if (this instanceof EclipseSpyRobot){
			leftClickMenuItem("File", "Open File");
		}else{
			leftClickMenuItem("File", "Open");
		}	
		delay(2000);
		assertWindow("Open");
		typeStringEnter(name);
		
		delay(500);
		
		//For .pxf/.sps script warning window
		escapeDialog("Authentic Script Warning", VK_Y);
		
		if (isSpsFile){
			spsFileHandling(opt);
		}
		
		keyPress(VK_ESCAPE);  
		delay(4000);
		
		if(!(this instanceof PluginRobot)){
			maximizeFileWindow();
		}
		
	}
	
	/**
	 * Opens the specified file just in the case where the test is run for the std application
	 * After the file is opened, the new internal window will be maximised.
	 * @param name path and filename.
	 */
	public void openFile_notInPlugins(String name) {
		if (!(this instanceof PluginRobot)) {
			checkFile(name);
			leftClick("ID_FILE_OPEN");
			delay(1000);
			typeFileName(name);
			delay(3000);
		}
	}
	
	
	public void openFile_notInPlugins(String name, Options opt) {
			checkFile(name);
			//From menu File > Open is not possible to open sps file in Eclipse
			//in XMLSpy perspective
			//User should first import and them open from Explorer
			if ((this instanceof EclipseSpyRobot))
				openFile(name, false, opt);
			else 
				openFile(name, true, opt);
			//delay(1000);
			//typeFileName(name);
			delay(3000);
	}
	public void copyDirectory(File srcDir, File destDir){
		if(!srcDir.exists()){
			 
				logger.fine("Directory doesn't exist");
	        }else{
	 
	           try{
	        	   copyFolder(srcDir,destDir);
	           	}
	           catch(IOException e){
	           }
	        }
	}
    public static void copyFolder(File src, File dest) throws IOException{

	if(src.isDirectory()){

		//if directory not exists, create it
		if(!dest.exists()){
		   dest.mkdir();
		}

		//list all the directory contents
		String files[] = src.list();

		for (String file : files) {
		   //construct the src and dest file structure
		   File srcFile = new File(src, file);
		   File destFile = new File(dest, file);
		   //recursive copy
		   copyFolder(srcFile,destFile);
		}

	}else{
		//if file, then copy it
		//Use bytes stream to support all file types
		InputStream in = new FileInputStream(src);
	        OutputStream out = new FileOutputStream(dest); 

	        byte[] buffer = new byte[1024];

	        int length;
	        //copy the file content in bytes 
	        while ((length = in.read(buffer)) > 0){
	    	   out.write(buffer, 0, length);
	        }

	        in.close();
	        out.close();
	}
}
	/*
	 public void copyFolder(File src, File dest)	throws IOException{

 	

 		//if directory not exists, create it
 		if(!dest.exists()){
 		   dest.mkdir();
 		}

 		//list all the directory contents
 		String files[] = src.list();

 		for (String file : files) {
 		   //construct the src and dest file structure
 		   File srcFile = new File(src, file);
 		   File destFile = new File(dest, file);
 		   //recursive copy
 		  copyFile(srcFile.getAbsolutePath(),destFile.getAbsolutePath());
 		}

 	 }
 


	public void copyFile(String srFile, String destFile){
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
	*/
	/**
	 * Opens the specified file.
	 * After the file is opened, the new internal window will be maximised.
	 * @param file file to open
	 */
	public void openFile(File file) {
		
		openFile(file, false, null);
		
	}
	
	public void openFile(File file, boolean isSpsFile, Options opt) {
		
		openFile(file.getAbsolutePath(), isSpsFile, opt);
			
	}
	
	
	
	public void openFileWithXMLSpyEditorInVS(String name){
		openFile(name);//there is not such an option in the spy app
	}
	
	public void openFileNoMaxNoPopup(File file){
		
		logger.fine("FILE TO CHECK:"+ file.getAbsolutePath());
		checkFile(file.getAbsolutePath());
		leftClickMenuItem("File", "Open");
		
		//delay(2000);
		assertWindow("Open");
		typeStringEnter(file.getAbsolutePath());
				
		delay(4000);
	}
	
	/** Reloads the active file; escapes any dialogs.
	 *
	 */
	public void reloadFile() {
		leftClickMenuItem("File", getReloadMenuItem());
		escapeDialog("reload this file", VK_Y);
	}
	
	public String getReloadMenuItem(){
		return "Reload"; //it is called reload for spy and VS
	}
	/**
	 * not implemented yet
	 * @param encoding
	 */
	
	//E.G.: DOESNT WORK CORRECTLY FINDING "Unicode UTF-16"
	public void setEncoding(String encoding) {
		leftClickMenuItem("File", "Encoding");
		assertWindow("Encoding");
		if (encoding != null){
			
			//DropDownOption enc = new DropDownOption(name, textAbove, value, section)
			
			Rectangle encodingWin = findComponentName("Encoding");
			leftClick(encodingWin.x+100, encodingWin.y+40);
			delay(200);
			//Rectangle str = findString(encoding, MS_SHELL_DLG_FONT);
			Rectangle str =	findString(encoding, MS_SHELL_DLG_FONT, TRANSPARENT, BLACK, null, true);
			logger.fine("Encoding value at:" + str);
			leftClickMid(str);
			clickButton("OK");
			
		}
		//not implemented yet for a more accurate test with a specific encoding
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
	
	/**
	 * This method closes the solution in VS, but makes no sense for the spy app,
	 * so we will leave it empty
	 */
	public void closeSolution_InVS(){
		
	}
	
	/**
	 * Save the active file.
	 *
	 */
	public void saveFile() {
		leftClickMenuItem("File", "Save");
	}
	
	/**
	 * Simplest "save as";does not control dialog escaping 
	 * to make it faster
	 * @param name the path/filename to save to
	 */
	public void saveFileAsNoControl(String name) {
		leftClickMenuItem("File", "Save As");
		typeFileName(name);
		delay(5000);
		
		
	}
	
	/**
	 * Saves the active file to a new name; escapes any dialogs.
	 * @param name the path/filename to save to
	 */
	public void saveFileAs(String name) {
		leftClickMenuItem("File", "Save As");
		escapeGeneralDialogs("Waiting while escaping file dialogs");
		typeFileName(name);
		delay(5000);
		
		
	}
	

	/**
	 * Clicks the "Save to URL" menu item; nothing else
	 *
	 */
	public void saveToURL() {
		leftClickMenuItem("File", "Save to URL");
	}
	
	/**
	 * Saves all active files.
	 *
	 */
	public void saveAll() {
		leftClickMenuItem("File", "Save All");
	}
	
	/**
	 * not implemented yet
	 * @param email
	 * @param message
	 */
	public void sendByMail(String email, String message) {
		throw new ScriptMistakeException("not implemented yet");
	}

	/**
	 * Exits the application without saving any files.
	 */
	@Override
	public void exitApplication() {
		exitWithuotSave();
	}
	
	/**
	 * Exits the application without saving any files.
	 */
	public void exitWithuotSave() {
		int ignoreOld = ignorePixels;
		ignorePixels = 0;
		leftClickMenuItem("File", "Exit  "); delay(1000);
		ignorePixels = ignoreOld;

		escapeGeneralDialogs("Waiting while escaping exit dialogs");
		delay(5000);
	}
	
	//---------------------------------------------------------------------------------------
	//-----------------------------               EDIT MENU     -----------------------------
	//---------------------------------------------------------------------------------------
	
	// For common EDIT menu functions, see AltovaApplicationRobot
	
	
	/**
	 * Uses the Find dialog to search for the specified word in the active document;
	 * escapes various dialogs, also the Find dialog.
	 * @param word the string to search for in the active file.
	 */
	public void find(String word, String... menuitems){
		leftClickMenuItem("Edit",menuitems);
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
	
	
	public void find(String word){
		find(word,"Find");
	}
	

	public void findXbrlAdvanced(String word, String option)
	{
		leftClickMenuItem("Edit","Find");
		typeString(word);
		try{
		clickButton("Advanced >>");
		}catch (ImageNotFoundException e)
		{
			
		}
		clickButton("Clear all");
		
		Options opt = new Options();
		//MS_SHELL_DLG_FONT
		opt.add(new CheckboxOption(option, true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		opt.applyOption(this);
		clickButton("Find");
		keyPress(VK_ENTER);
	}
	
	public void findTextViewSpecific(String word, String... menuitems) {
		find(word,menuitems);
		try {
			leftClickMid(findComponent("Close", "Button", NativeGUI.getForegroundWindowInfo().getLocation()));
		} catch (ScriptMistakeException e) {
			//do nothing

		}
	}
	
	public void findTextViewSpecific(String word) {
		findTextViewSpecific(word,"Find"); 
	}
	
	/**
	 * Uses the Find dialog to mark all words in the active document;
	 * escapes various dialogs, also the Find dialog.
	 * @param word the string to search for in the active file.
	 */
	public void markAll(String word,String... menuitems){
		leftClickMenuItem("Edit",menuitems);
		typeString(word);
		Rectangle findDlg=NativeGUI.getForegroundWindowInfo().getLocation();
		leftClickMid(findComponent("Mark All", "Button", findDlg));
		
		boolean notFound = false;
		notFound |= escapeDialog("Finished searching the document", VK_ENTER );
		notFound |= escapeDialog("Reached the end of file", VK_ENTER);
		notFound |= escapeDialog("Cannot find the string", VK_ENTER);
		
		if(notFound) {
			logger.warning("The string "+word+" was not found.");
		}
		
		//if the Find dialog remains on screen, close it
		escapeDialog("Find", VK_ESCAPE);
		
		//another just in case check:
		try {
			leftClickMid(findComponent("Close", "Button", NativeGUI.getForegroundWindowInfo().getLocation()));
		} catch (ScriptMistakeException e) {
			//do nothing

		}
	}
	
	public void markAll(String word){
		markAll(word,"Find");
	}
	
	/**
	 * ????
	 * @param word
	 * @return ??
	 */
	public Rectangle findHighlight(String word){
		ScreenDiff diff = new ScreenDiff(this);
		diff.snapBefore(getMainWindow());
		find(word); delay(1000);
		diff.snapAfter();
		
		//check if we have a hit
		Rectangle location = diff.diffBounds();
		try {
			ImageUtils.saveImage(diff.diffMarks(), "debug_findHighlight", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.finest("Location:"+location);
		return location;
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
	
	public void menufindNext(){
		leftClickMenuItem("Edit","Find Next");
	}
	
	/**
	 * Clicks "Copy as XML-Text"; nothing else.
	 *
	 */
	public void copyAsXMLText() {

		leftClickMenuItem("Edit", "Copy as XML Text");

	}

	/**
	 * Clicks "Copy as Structured text"; nothing else.
	 *
	 */
	public void copyAsStructuredText() {

		leftClickMenuItem("Edit", "Copy as Structured Text");
	}
	
	/**
	 * Clicks "Copy XPointer" both in integrations and default application; nothing else.
	 *
	 */
	
	public void copyXPointer(){
		leftClickMenuItem("Edit","Copy XPointer");
	}
	
	
	/**
	 * Clicks "Insert file path" both in integrations and default application; nothing else.
	 *
	 */
	public void insertFilePath(String filepath){
		leftClickMenuItem("Edit","Insert", "File Path...");
		delay(1000);
		Rectangle forwind=NativeGUI.getForegroundWindowInfo().getLocation();
		Rectangle choosefile=findComponent("Choose a file", "Button",forwind);
		leftClick(choosefile.x+30,choosefile.y+20);
		typeFileName(filepath);
	}
	
	public void insertXMLElementTextView(String elemname, String content) {
	
		keyType(VK_LESS);
		delay(500);
		typeString(elemname + ">");
		delay(500);
		if (content != null) {
			typeString(content);
		}
	
	}

	/**
	 * Clicks "Insert XInclude"; nothing else.
	 *
	 */
	public void insertXInclude(String filenameToInclude){
		leftClickMenuItem("Edit", "Insert", "XInclude...");
		typeFileName(filenameToInclude);
		
	}
	/**
	 * Switches to Grid view and clicks the menu item "Copy XPath".
	 *
	 */
	public void copyXPath() {
		leftClickMenuItem("Edit", "Copy XPath");
	}
	
	/**
	 * Switches to Text view and clicks "Pretty-Print XML Text".
	 *
	 */
	public void prettyPrintXML() {
		textView();
		leftClickMenuItem("Edit", "Pretty-Print");
	}
	
	/**
	 * Quick pretty-print via icon.
	 *
	 */
	public void prettyPrint_icon() {
		leftClick("IDC_PRETTY_PRINT");
	
	}
	
	/**
	 * Clicks the menu item "Find next"; nothing else.
	 */
	
	
	/**
	 * TODO: might need some escapes here?
	 * @param toFind
	 * @param toReplace
	 */
	public void replaceFirst(String toFind, String toReplace,String...menuitems) {
		leftClickMenuItem("Edit",menuitems);
		removeTextfieldText();
		typeString(toFind);
		keyType(VK_TAB);
		removeTextfieldText();
		typeString(toReplace);
		Rectangle replaceAllButton = findComponent("All", "Button", null);
		leftClickMid(replaceAllButton);
		escapeDialog("Replaced",VK_ENTER);
		escapeDialog("The search item was not found",VK_ENTER);
		escapeDialog("Reached the end of file", VK_CANCEL );
		escapeDialog("Replace", VK_ESCAPE);
	}
	
	public void replaceFirst(String toFind, String toReplace){
		replaceFirst(toFind,toReplace,"Replace...");
	}
	
	public void findInFiles(String expression,String...menuitems){
		leftClickMenuItem("Edit", menuitems);
		typeString(expression);
		keyType(VK_ENTER);
	}
	
	public void findInFiles(String expression){
		findInFiles(expression,"Find in Files...");
	}
	
	/**
	 * Clicks "Insert/Remove Bookmark"
	 *
	 */
	public void insertBookmark(){
		leftClickMenuItem("Edit", "Insert/Remove Bookmark");
		
	}

	/**
	 * Clicks "Insert/Remove Bookmark"
	 *
	 */
	public void removeBookmark(){
		
		leftClickMenuItem("Edit", "Insert/Remove Bookmark");
		
	}
	
	/**
	 * Clicks "Remove All Bookmarks"
	 *
	 */
	public void removeAllBookmarks(){
		leftClickMenuItem("Edit", "Remove All Bookmarks");
		
	}
	
	/**
	 * Clicks "Go to Next Bookmark"
	 *
	 */
	public void goToNextBookmark(){
		leftClickMenuItem("Edit", "Go to Next Bookmark");
		
	}
	
	/**
	 *Clicks "Go to Previous Bookmark"
	 *
	 */
	public void goToPreviousBookmark(){
		leftClickMenuItem("Edit", "Go to Previous Bookmark");
		
	}
	
	/**
	 * Switches to Text view and clicks "Comment In/Out"
	 *
	 */
	
	public void commentInOut(){
		textView();
		leftClickMenuItem("Edit", "Comment In/Out");
	}
	
	//---------------------------------------------------------------------------------------
	//-----------------------------               PROJECT MENU  -----------------------------
	//---------------------------------------------------------------------------------------
	
	/**
	 * Opens the specified Spy; escapes dialogs.
	 * @param name the path/name of the project file.
	 */
	public void openProject(String name) {
		checkFile(name);
		leftClickMenuItem("Project", "Open Project");
		typeStringEnter(name);
		escapeProjectDialogs();
	}
	
	protected void openProject(String name, String... menuitems) {
		checkFile(name);
		leftClickMenuItem("File", menuitems); delay(1000);
		typeStringEnter(name); 
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
		typeFileName(url);
	}
	
	/**
	 * Adds a new folder to the active project.
	 * @param name virtual name of folder 
	 */
	public void addProjectFolderToProject(String name) {
		leftClickMenuItem("Project", "Add Project Folder to Project");
		assertWindow("Properties");
		typeFileName(name);
	}

	/**
	 * not implemented yet
	 * @param name
	 */
	public void addExternalFolderToProject(String name) {
		leftClickMenuItem("Project","Add External Folder to Project");
		assertWindow("Browse For Folder"); //horrible window where no typing is possible :(
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
		delay(1000);
		leftClickMid(findComponent("Open", "Button", new Rectangle(URLWind.x,URLWind.y+URLWind.height/2,URLWind.width,URLWind.height/2)));
		
		escapeDialog("You have entered a username and password.", VK_Y);
		
	}	
	

	//---------------------------------------------------------------------------------------
	//-----------------------------               XML MENU  -----------------------------
	//---------------------------------------------------------------------------------------
	
	public void XMLInsertAttribute(String attname,String attdescription) {
		leftClickMenuItem("XML", "Insert","Attribute");
		if(attname != null) {
			typeString(attname);
		}
		keyType(VK_TAB);
		
		if(attdescription != null) {
			typeString(attdescription);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLInsertElement(String elementname,String elemdescription) {
		leftClickMenuItem("XML", "Insert","Element");
		
		if(elementname != null) {
			typeString(elementname);
		}
		keyType(VK_TAB);
		
		if(elemdescription != null) {
			typeString(elemdescription);
		}
		keyType(VK_ENTER);
	}
	
		
	public void XMLInsertText(String text) {
		leftClickMenuItem("XML", "Insert","Text");
		
		if(text != null) {
			typeString(text);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLInsertCData(String cdata) {
		leftClickMenuItem("XML", "Insert","CDATA");
		
		if(cdata != null) {
			typeString(cdata);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLInsertComment(String comment) {
		leftClickMenuItem("XML", "Insert","Comment");
		
		if(comment != null) {
			typeString(comment);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLInsertXml() {
		leftClickMenuItem("XML","Insert","XML");
		
	}
	
	public void XMLInsertProcInstruct(String procinst, String procinstdesc) {
		leftClickMenuItem("XML", "Insert","Processing Instruction");
		if(procinst != null) {
			typeString(procinst);
		}
		keyType(VK_TAB);
		
		if(procinstdesc != null) {
			typeString(procinstdesc);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLInsertXInclude(String filename){
		leftClickMenuItem("XML","Insert","XInclude");
		delay(1000);
		assertWindow("XInclude");
		if(filename!=null){
			typeString(filename);
		}
		delay(500);
		keyType(VK_ENTER);
		
	}
	
	public void XMLInsertDoctype(String doctype) {
		leftClickMenuItem("XML", "Insert","DOCTYPE");
		
		if(doctype != null) {
			typeString(doctype);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLInsertExternalId(String extId,String extIddesc) {
		leftClickMenuItem("XML", "Insert","ExternalID");
		
		if(extId != null) {
			typeString(extId);
		}
		keyType(VK_TAB);
		
		if(extIddesc != null) {
			typeString(extIddesc);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLInsertElementInDTD(String element) {
		leftClickMenuItem("XML", "Insert","ELEMENT");
		
		if(element != null) {
			typeString(element);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLInsertAttListInDTD(String attlist) {
		leftClickMenuItem("XML", "Insert","ATTLIST");
		
		if(attlist != null) {
			typeString(attlist);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLInsertEntityInDTD(String entity,String entdescrip) {
		leftClickMenuItem("XML", "Insert","ENTITY");
		
		if(entity != null) {
			typeString(entity);
		}
		keyType(VK_TAB);
		
		if(entdescrip != null) {
			typeString(entdescrip);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLInsertNotationInDTD(String notation, String notdescript) {
		leftClickMenuItem("XML", "Insert","NOTATION");
		
		if(notation != null) {
			typeString(notation);
		}
		keyType(VK_TAB);
		
		if(notdescript != null) {
			typeString(notdescript);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAppendAttribute(String attname,String attdescription) {
		leftClickMenuItem("XML", "Append","Attribute");
		if(attname != null) {
			typeString(attname);
		}
		keyType(VK_TAB);
		
		if(attdescription != null) {
			typeString(attdescription);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAppendElement(String elementname,String elemdescription) {
		leftClickMenuItem("XML", "Append","Element");
		
		if(elementname != null) {
			typeString(elementname);
		}
		keyType(VK_TAB);
		
		if(elemdescription != null) {
			typeString(elemdescription);
		}
		keyType(VK_ENTER);
	}
	
		
	public void XMLAppendText(String text) {
		leftClickMenuItem("XML", "Append","Text");
		
		if(text != null) {
			typeString(text);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAppendCData(String cdata) {
		leftClickMenuItem("XML", "Append","CDATA");
		
		if(cdata != null) {
			typeString(cdata);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAppendComment(String comment) {
		leftClickMenuItem("XML", "Append","Comment");
		
		if(comment != null) {
			typeString(comment);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAppendXml() {
		leftClickMenuItem("XML", "Append","XML");
			
	}
	
	public void XMLAppendProcInstruct(String procinst, String procinstdesc) {
		leftClickMenuItem("XML", "Append","Processing Instruction");
		if(procinst != null) {
			typeString(procinst);
		}
		keyType(VK_TAB);
		
		if(procinstdesc != null) {
			typeString(procinstdesc);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAppendXInclude(String filename){
		leftClickMenuItem("XML", "Append","XInclude");
		delay(1000);
		assertWindow("XInclude");
		if(filename != null) {
			typeString(filename);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAppendDoctype(String doctype) {
		leftClickMenuItem("XML", "Append","DOCTYPE");
		
		if(doctype != null) {
			typeString(doctype);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAppendExternalId(String extId,String extIddesc) {
		leftClickMenuItem("XML", "Append","ExternalID");
		
		if(extId != null) {
			typeString(extId);
		}
		keyType(VK_TAB);
		
		if(extIddesc != null) {
			typeString(extIddesc);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAppendElementInDTD(String element) {
		leftClickMenuItem("XML", "Append","ELEMENT");
		
		if(element != null) {
			typeString(element);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAppendAttListInDTD(String attlist) {
		leftClickMenuItem("XML", "Append","ATTLIST");
		
		if(attlist != null) {
			typeString(attlist);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAppendEntityInDTD(String entity,String entdescrip) {
		leftClickMenuItem("XML", "Append","ENTITY");
		
		if(entity != null) {
			typeString(entity);
		}
		keyType(VK_TAB);
		
		if(entdescrip != null) {
			typeString(entdescrip);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAppendNotationInDTD(String notation, String notdescript) {
		leftClickMenuItem("XML", "Append","NOTATION");
		
		if(notation != null) {
			typeString(notation);
		}
		keyType(VK_TAB);
		
		if(notdescript != null) {
			typeString(notdescript);
		}
		keyType(VK_ENTER);
	}	
	
	public void XMLAddChildAttribute(String attname,String attdescription) {
		leftClickMenuItem("XML", "Add child","Attribute");
		if(attname != null) {
			typeString(attname);
		}
		keyType(VK_TAB);
		
		if(attdescription != null) {
			typeString(attdescription);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAddChildElement(String elementname,String elemdescription) {
		leftClickMenuItem("XML", "Add child","Element");
		
		if(elementname != null) {
			typeString(elementname);
		}
		keyType(VK_TAB);
		
		if(elemdescription != null) {
			typeString(elemdescription);
		}
		keyType(VK_ENTER);
	}
	
		
	public void XMLAddChildText(String text) {
		leftClickMenuItem("XML", "Add child","Text");
		
		if(text != null) {
			typeString(text);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAddChildCData(String cdata) {
		leftClickMenuItem("XML", "Add child","CDATA");
		
		if(cdata != null) {
			typeString(cdata);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAddChildComment(String comment) {
		leftClickMenuItem("XML", "Add child","Comment");
		
		if(comment != null) {
			typeString(comment);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAddChildXml() {
		leftClickMenuItem("XML", "Add child","XML");
			
	}
	
	public void XMLAddChildProcInstruct(String procinst, String procinstdesc) {
		leftClickMenuItem("XML", "Add child","Processing Instruction");
		if(procinst != null) {
			typeString(procinst);
		}
		keyType(VK_TAB);
		
		if(procinstdesc != null) {
			typeString(procinstdesc);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAddChildXInclude(String filename){
		leftClickMenuItem("XML","Add child","XInclude");
		delay(1000);
		assertWindow("XInclude");
		if(filename != null) {
			typeString(filename);
		}
		keyType(VK_ENTER);
		
	}
	
	public void XMLAddChildDoctype(String doctype) {
		leftClickMenuItem("XML", "Add child","DOCTYPE");
		
		if(doctype != null) {
			typeString(doctype);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAddChildExternalId(String extId,String extIddesc) {
		leftClickMenuItem("XML", "Add child","ExternalID");
		
		if(extId != null) {
			typeString(extId);
		}
		keyType(VK_TAB);
		
		if(extIddesc != null) {
			typeString(extIddesc);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAddChildElementInDTD(String element) {
		leftClickMenuItem("XML", "Add child","ELEMENT");
		
		if(element != null) {
			typeString(element);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAddChildAttListInDTD(String attlist) {
		leftClickMenuItem("XML", "Add child","ATTLIST");
		
		if(attlist != null) {
			typeString(attlist);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAddChildEntityInDTD(String entity,String entdescrip) {
		leftClickMenuItem("XML", "Add child","ENTITY");
		
		if(entity != null) {
			typeString(entity);
		}
		keyType(VK_TAB);
		
		if(entdescrip != null) {
			typeString(entdescrip);
		}
		keyType(VK_ENTER);
	}
	
	public void XMLAddChildNotationInDTD(String notation, String notdescript) {
		leftClickMenuItem("XML", "Add child","NOTATION");
		if(notation != null) {
			typeString(notation);
		}
		keyType(VK_TAB);
		
		if(notdescript != null) {
			typeString(notdescript);
		}
		keyType(VK_ENTER);	
	 }
	public void XMLConvertToAttribute() {
		leftClickMenuItem("XML", "Convert to","Attribute");
		
	}
	
	public void XMLConvertToElement() {
		leftClickMenuItem("XML", "Convert to","Element");
		
	}
	
		
	public void XMLConvertToText() {
		leftClickMenuItem("XML", "Convert to","Text");
		
	}
	
	public void XMLConvertToCData() {
		leftClickMenuItem("XML", "Convert to","CDATA");
		
	}
	
	public void XMLConvertToComment() {
		leftClickMenuItem("XML", "Convert to","Comment");
		
	}
	
	public void XMLConvertToXml() {
		leftClickMenuItem("XML", "Convert to","XML");
			
	}
	
	public void XMLConvertToProcInstruct() {
		leftClickMenuItem("XML", "Convert to","Processing Instruction");
		
	}
	
	public void XMLConvertToDoctype() {
		leftClickMenuItem("XML", "Convert to","DOCTYPE");
		
	}
	
	public void XMLConvertToExternalId() {
		leftClickMenuItem("XML", "Convert to","ExternalID");
		
	}
	
//	public void XMLConvertToElementInDTD() {
//		leftClickMenuItem("XML", "Convert to","ELEMENT");
//		
//	}
//	
//	public void XMLConvertToAttListInDTD() {
//		leftClickMenuItem("XML", "Convert to","ATTLIST");
//		
//	}
	
	public void XMLConvertToEntityInDTD() {
		leftClickMenuItem("XML", "Convert to","ENTITY");
		
	}
	
	public void XMLConvertToNotationInDTD() {
		leftClickMenuItem("XML", "Convert to","NOTATION");
		
	}
	
	public void XMLDisplayAsTable() {
		leftClickMenuItem("XML", "Table","Display as Table");
		
	}
	
	public void XMLTableInsertRow(){
		leftClickMenuItem("XML", "Table","Insert Row");
	}
	
	public void XMLTableAppendRow(){
		leftClickMenuItem("XML", "Table","Append Row");
	}
	
	public void XMLTableAscendingSort(){
		leftClickMenuItem("XML", "Table","Ascending Sort");
		
	}
	
	public void XMLTableDescendingSort(){
		leftClickMenuItem("XML", "Table","Descending Sort");
		
	}
	
	public void XMLMoveLeft(){
		leftClickMenuItem("XML", "Move Left");
		
	}
	
	public void XMLMoveRight(){
		leftClickMenuItem("XML", "Move Right");
		
	}
	
	public void XMLEncloseInElement(String element){
		leftClickMenuItem("XML","Enclose in Element");
		if(element != null) {
			typeString(element);
		}
		keyType(VK_ENTER);
		
	}
	
	public void XMLEvaluateXPath(){
		leftClickMenuItem("XML","Evaluate XPath...");
		
	}
	
	public void XMLCheckWellFormedness(){
		leftClickMenuItem("XML","Check Well-Formedness");
		
	}

	public void validate(){
		leftClickMenuItem("XML","Validate");
		
	}
	
	public void updateEntryHelpers(){
		leftClickMenuItem("XML","Update Entry Helpers");
	}
	
	public void namespacePrefix(String namespace){
		leftClickMenuItem("XML","Namespace prefix...");
		typeStringConditional(namespace);
	}
	
		
	
	
	//---------------------------------------------------------------------------------------
	//-----------------------------               DTD/SCHEMA MENU  -----------------------------
	//---------------------------------------------------------------------------------------

	protected void escapeSchemaDialogs() {
		escapeDialog("parse your XML text and write it back", VK_ENTER);
		escapeDialog("Do you want to assign generated DTD/Schema to your XML document", VK_N);
		escapeDialog("Do you want to remove this assignment", VK_Y);
		escapeDialog("assigned to a Schema. Do you want to proceed?",VK_ENTER);
	}
	
	public void assignDTD(String name) {
		leftClickMenuItem("DTD/Schema", "Assign DTD");
		Rectangle forwind=NativeGUI.getForegroundWindowInfo().getLocation();
		Rectangle choosefile=findComponent("Choose a file", "Button",forwind);
		leftClick(choosefile.x+30,choosefile.y+20);
		escapeSchemaDialogs();
		typeFileName(" "+name);
		escapeSchemaDialogs();
	}
	
	public void assignXSD(String name) {
		leftClickMenuItem("DTD/Schema", "Assign Schema");
		escapeSchemaDialogs();
		delay(1000);
		Rectangle forwind=NativeGUI.getForegroundWindowInfo().getLocation();
		Rectangle choosefile=findComponent("Choose a file", "Button",forwind);
		leftClick(choosefile.x+30,choosefile.y+20);
		typeFileName(" "+name);
		escapeSchemaDialogs();
	}
	
	public void includeAnotherDTD(String name) {
		leftClickMenuItem("DTD/Schema", "Include Another DTD");
		escapeSchemaDialogs();
		delay(1000);
		Rectangle forwind=NativeGUI.getForegroundWindowInfo().getLocation();
		Rectangle choosefile=findComponent("Choose a file", "Button",forwind);
		leftClick(choosefile.x+30,choosefile.y+20);
		typeFileName(" "+name);
	}
	
	public void gotoDTD() {
		leftClickMenuItem("DTD/Schema", "Go to DTD");
	}
	
	public void gotoXSD() {
		leftClickMenuItem("DTD/Schema", "Go to Schema");
	}
	
	public void goToDefinition(){
		leftClickMenuItem("DTD/Schema","Go to Definition");
		
	}
	public void generateDTD_XSD(Option options, String name) {
		textView();
		leftClickMenuItem("DTD/Schema", "Generate DTD/Schema");
		applyOptionsEnter("Generate DTD/Schema", options);
		assertWindow("Save As");
		typeFileName(name);
		escapeSchemaDialogs();
	}
	
	@Deprecated
	public void convertDTD_XSD(Option options, String name) {
		leftClickMenuItem("DTD/Schema", "Convert DTD/Schema");
		applyOptionsEnter("Convert DTD/Schema", options);
		assertWindow("Save As");
		typeFileName(name);
	}
	
	public void convertSchemaToDTD(String schema) {
		leftClickMenuItem("DTD/Schema", "Convert Schema To DTD");
		assertWindow("Save As");
		typeFileName(schema);
	}
	
	public void convertDTDtoSchema(Option options, String dtd) {
		leftClickMenuItem("DTD/Schema", "Convert DTD To Schema");
		applyOptionsEnter("Convert DTD To W3C Schema", options);
		assertWindow("Save As");
		typeFileName(dtd);
	}
	
	public void flattenDTD(File DtdFile) {
		leftClickMenuItem("DTD/Schema", "Flatten DTD");	
		typeFileName(DtdFile.getAbsolutePath());
	}
	
	public void flattenSchema(String path) {
		leftClickMenuItem("DTD/Schema", "Flatten Schema");
		assertWindow("Flatten Schema");
		TextFieldOption folder = new TextFieldOption("Please select a folder", true, path, null, null, null, null, MS_SHELL_DLG_FONT);
		folder.applyOption(this);
		clickButton("OK");
		delay(2000);
	}
	
	
	public void convertUML(Option options, String umpOutput) {
		checkDir(umpOutput);
		
		leftClickMenuItem("DTD/Schema", "Convert to UML"); delay(1000);
		applyOptionsEnter("Convert to UML", options );
		typeFileName(umpOutput);

		//check if UModel exists? Escape from error if it doesn't?
		
		escapeDialog("XMLSpy could not find any element declaration for a root element", VK_ENTER); delay(1000);
	}
	
	public void mapToOtherDTD_XSD_DBinMapForce() {
		leftClickMenuItem("DTD/Schema", "Map to other DTD/Schema or DB in MapForce");
	}
	public void designHTML_PDFinStyleVision() {
		leftClickMenuItem("DTD/Schema", "Design HTML/PDF Output in StyleVision");
	}

	
	public void generateSampleXML(Option options) {
		leftClickMenuItem("DTD/Schema", "Generate Sample XML File");
		applyOptionsEnter("Generate sample XML file", options);
		delay(300);
	}
	
	public void generateSampleXML(Option options,String componentName) {
		leftClickMenuItem("DTD/Schema", "Generate Sample XML File");
		delay(1000);
		Rectangle r=NativeGUI.getForegroundWindowInfo().getLocation();
		leftClickString(componentName, DEFAULT_CONTENT_FONT, Color.BLACK, r);
		if(options != null) {
			options.applyOption(this);
		}
		try{
			leftClickMid(findComponent("OK", "Button", null));
		}catch(ScriptMistakeException e){
			keyType(VK_ENTER);
		}
	}

	public void generateCode(Option options, String path) {
		//check that the directory exist, or create it if it doesn't
		//has to add dummy directory here, since only the parent is created
		checkDir(path+File.separator+"dummy");
		
		leftClickMenuItem("DTD/Schema", "Generate Program Code");
		if( escapeDialog("XMLSpy can only generate program code from a valid Schema or DTD", VK_ESCAPE) ) {
			throw new ScriptMistakeException("Tried to generate code from invalid xsd/dtd");
		}
		
		applyOptionsEnter("Altova XMLSpy", options);
		
		//click TAB three times to get to the path/folder field
		keyType(VK_TAB); delay(500);
		keyType(VK_TAB); delay(500);
		keyType(VK_TAB); delay(500);
		
		typeStringEnter(path);
		keyType(VK_ESCAPE);
		delay(5000);		
		escapeDialog("Do you want to open the newly created project", VK_N );
		escapeDialog("Open corresponding output directory", VK_N );
		delay(2000);
	}
	
	public void flushMemoryCache(){
		leftClickMenuItem("DTD/Schema", "Flush Memory Cache");
	}
	
	//---------------------------------------------------------------------------------------
	//-----------------------------               SCHEMA DESIGN MENU  -----------------------------
	//---------------------------------------------------------------------------------------

	public void schemaSettings() {
		leftClickMenuItem("Schema design", "Schema Settings");
		assertWindow("Schema settings");
		keyType(VK_ESCAPE);
		
	}
	
	public void schemaSaveDiagram(String xpathlocation,String pathToSave,String filename) {
		checkDir(pathToSave+File.separator+"dummy");
		xpathHighlight(xpathlocation);
		leftClickMenuItem("Schema design", "Save Diagram...");
		assertWindow("Save As");
		typeFileName(pathToSave+"\\"+filename);
		delay(3000);
		
	}
	
	public void generateXSDDocumentation(File pathToSave,String filename,Options options) {
		checkDir(pathToSave+File.separator+"dummy");
		leftClickMenuItem("Schema design", "Generate Documentation");
		delay(2000);
		keyType(KeyEvent.VK_UP);
		applyOptionsEnter("Schema documentation",options);
		delay(4000);
		assertWindow("Save As");
		typeFileName(pathToSave.getAbsolutePath()+"\\"+filename);
		delay(12000);
		logger.finest("Server Busy delay 12\"");
		delay(12000);
		logger.finest("Server Busy delay 24\"");
		delay(12000);
		logger.finest("Server Busy delay 36\"");
		escapeDialog("Server Busy", VK_R);
		
	}
	
	public void configureView() {
		leftClickMenuItem("Schema design", "Configure View");
		assertWindow("Schema display configuration");
		keyType(VK_ESCAPE);
	}
	
	public void zoomXSD(String sizeToZoom) {
		leftClickMenuItem("Schema design", "Zoom");
		keyType(VK_TAB); delay(500);
		keyType(VK_TAB); delay(500);
		keyType(VK_TAB); delay(500);
		
		typeString(sizeToZoom);
		keyType(VK_ENTER);
		
	}
	
	public void displayAllGlobals() {
		leftClickMenuItem("Schema design", "Display All Globals");
	}
	
	public void displayDiagram() {
		leftClickMenuItem("Schema design", "Display Diagram");
	}
	
	public void enableOracleSchemaExtensions(){
		leftClickMenuItem("Schema design","Schema Extensions for Databases", "Enable Oracle Schema Extensions");
	}
	
	public void enableMSSQLServerSchemaExtensions(){
		leftClickMenuItem("Schema design", "Schema Extensions for Databases","Enable Microsoft SQL Server Schema Extensions");
	}
	
	public void taminoXSDProperties() {
		leftClickMenuItem("Schema design", "Tamino Schema Properties");
		assertWindow("Tamino Properties");
		keyType(VK_ESCAPE);
	}

	
	//---------------------------------------------------------------------------------------
	//-----------------------------               XSL/XQUERY MENU  -----------------------------
	//---------------------------------------------------------------------------------------

	public void xslTransformation() {
		
		leftClickMenuItem("XSL/XQuery", "XSL Transformation");
	}
	
	public void xslFOTransformation() {
		leftClickMenuItem("XSL/XQuery", "XSL-FO Transformation");
		assertWindow("Choose XSL:FO output");
		keyType(VK_ENTER);
		if( escapeDialog("XMLSpy requires FOP to be installed", VK_ESCAPE ) ) {
			throw new ApplicationErrorException("FOP was not installed or path not specified");
		}
		delay(10000);
		assertWindow("FOP: AWT-Preview");
		closeAltF4();
		leftClickString("File");
		keyType(VK_ESCAPE); delay(500);
		escapeDialog("Output of external XSL converter", VK_ESCAPE);
	}
	
	public void xslParameters() {
		leftClickMenuItem("XSL/XQuery", "XQuery Variables");
		assertWindow("XSLT Input Parameters/XQuery External Variables");
	}
	
    public void xQueryExecution(String filename) {
		leftClickMenuItem("XSL/XQuery", "XQuery/Update Execution");
		assertWindow("Please choose an XQuery/Update file");
		Rectangle forwind=NativeGUI.getForegroundWindowInfo().getLocation();
		Rectangle choosefile=findComponent("Choose a file", "Button",forwind);
		leftClick(choosefile.x+30,choosefile.y+20);
		typeFileName(" "+filename);
		delay(1000);
	}

	public void xslProfiling(Option options) {
		leftClickMenuItem("XSL/XQuery", "XQuery Profiling");
		assertWindow("Enable XSLT");
		applyOptionsEnter("Enable XSLT", options);
		
		
	}

	public void assignXSL(String name) {
		gridView();
		leftClickMenuItem("XSL/XQuery", "Assign XSL");
		assertWindow("XML Spy");
		Rectangle forwind=NativeGUI.getForegroundWindowInfo().getLocation();
		Rectangle choosefile=findComponent("Choose a file", "Button",forwind);
		leftClick(choosefile.x+30,choosefile.y+20);
		typeFileName(" "+name);
		
		
	}

	public void assignXSLFO(String name) {
		gridView();
		leftClickMenuItem("XSL/XQuery", "Assign XSL-FO");
		assertWindow("XML Spy");
		Rectangle forwind=NativeGUI.getForegroundWindowInfo().getLocation();
		Rectangle choosefile=findComponent("Choose a file", "Button",forwind);
		leftClick(choosefile.x+30,choosefile.y+20);
		delay(1000);
		typeFileName(" "+name);
	}
	
	public void assignSampleXML(String name) {
		gridView();
		leftClickMenuItem("XSL/XQuery", "Assign Sample XML file");
		assertWindow("XML Spy");
		Rectangle forwind=NativeGUI.getForegroundWindowInfo().getLocation();
		Rectangle choosefile=findComponent("Choose a file", "Button",forwind);
		leftClick(choosefile.x+30,choosefile.y+20);
		delay(1000);
		typeFileName(" "+name);
	}
	
	public void gotoXSL() {
		leftClickMenuItem("XSL/XQuery", "Go to XSL");
	}
	
	public void xsltSettings() {
		leftClickMenuItem("XSL/XQuery", "Debug Settings");
		assertWindow("Debug Settings");
		keyType(VK_ESCAPE);
	}
	
	// ---------------------------------------------------------------------------------------
	//-----------------------------               AUTHENTIC MENU  -----------------------------
	//---------------------------------------------------------------------------------------

	public String getAuthenticMenuHolder(){
		return null; 
		/**This method was created because the Authentic menu in the .net integration 
		*can just be accessed via the XMLSpy  menu , so for the standard app and eclipse,
		*it should return "null"
		*/ 
	}
	
    public void newAuthenticDocument() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "New Document");
	}

	public void editDatabaseData() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "Edit Database Data");
	}

	public void assignSVStylesheet(String SPSAssigned) {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "Assign a StyleVision Stylesheet");
		escapeDialog("will have to parse your XML text", VK_ENTER);
		Rectangle forwind=NativeGUI.getForegroundWindowInfo().getLocation();
		Rectangle choosefile=findComponent("Choose a file", "Button",forwind);
		leftClick(choosefile.x+30,choosefile.y+20);
		typeFileName(" "+SPSAssigned);
	}

	public void editSVStylesheet() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "Edit StyleVision Stylesheet");
	}

	public void hideMarkup() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "View Markup", "Hide Markup");
	}

	public void showSmallMarkup() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "View Markup", "Show Small Markup");
	}

	public void showLargeMarkup() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "View Markup", "Show Large Markup");
	}

	public void showMixedMarkup() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "View Markup", "Show Mixed Markup");
	}
	
	public void authenticAppendRow() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "Append Row");
		delay(1000);
	}
	
	public void authenticInsertRow() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "Insert Row");
		delay(1000);
	}
	
	public void authenticDuplicateRow() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "Duplicate Row");
		delay(1000);
	}
	
	public void authenticMoveRowUp() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "Move Row Up");
		delay(1000);
	}
	
	public void authenticMoveRowDown() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "Move Row Down");
		delay(1000);
	}
	
	public void authenticDeleteRow() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "Delete Row");
		delay(1000);
	}
	
	// ---------------------------------------------------------------------------------------
	//-----------------------------               CONVERT MENU  -----------------------------
	//---------------------------------------------------------------------------------------

	public void importTextFile(Option options, String path) {
		leftClickMenuItem("Convert", "Import Text File");
		applyOptionsEnter("Import Text file", options);
		typeFileName(path);
		keyType(VK_ENTER);
		
		
	}
	
	public void importDBData() {
		leftClickMenuItem("Convert", "Import Database Data");
		assertWindow("Import Database data");
	}

	public void importWordDocument(String filename) {
		leftClickMenuItem("Convert", "Import Microsoft Word Document");
		delay(500);
		assertWindow("Open");
		typeFileName(filename);
		delay(6000);
		delay(6000);
		escapeDialog("Server Busy", VK_R);
	}

	public void createXSDfromDB() {
		leftClickMenuItem("Convert", "Create XML Schema from DB Structure");
		assertWindow("Connect to a Data Source");
	}

	public void DBImportBasedOnXSD() {
		leftClickMenuItem("Convert", "DB Import Based on XML Schema");
		assertWindow("Connect to a Data Source");
	}

	public void createDBStructureFromXSD() {
		leftClickMenuItem("Convert", "Create DB Structure from XML Schema");
		assertWindow("Connect to a Data Source");
	}

	public void exportToTextFiles(Option firstop,boolean ifSaveFiles,File pathToSaveFiles) {
		
		gridView();
		leftClickMenuItem("Convert", "Export to Text Files");delay(1000);
		applyOptionsEnter("Export to Text files",firstop);delay(1000);
		delay(1000);
		assertWindow("Export XML to Text");
		Options showInSpy =new Options();
		showInSpy.add(new RadioOption("Export to XMLSpy"));
		RadioOption saveInFolder=new RadioOption("Save in folder");
		
		
		if(ifSaveFiles==true){
			TextFieldOption path=new TextFieldOption("Save in folder",pathToSaveFiles.getAbsolutePath());
			path.setX2(50);
			saveInFolder.applyOption(this);
			path.applyOption(this);
			delay(1000);
			leftClickMid(findComponent("&Export", "Button", null));
			escapeDialog("Successful export to "+pathToSaveFiles, VK_ESCAPE);
		}else{
			showInSpy.applyOption(this);
			delay(1000);
			leftClickMid(findComponent("&Export", "Button", null));
			escapeDialog("Successful export to XMLSpy", VK_ESCAPE);
		}
		
		delay(3000);
		
	}

	
	public void exportToDB(String dbPath,Option conXml,Option dbType,Option ifcreated) {
		gridView();
		leftClickMenuItem("Convert", "Export to a Database");
		assertWindow("Export to Database");
		applyOptionsEnter("Export to Database",conXml);
		assertWindow("Connect to a Data Source");
		applyOptionsEnter("Connect to a Data Source",dbType);
		delay(4000);
		keyType(VK_TAB);delay(1000);
		keyType(VK_TAB);delay(1000);
		keyType(VK_TAB);delay(1000);
		typeFileName(dbPath);
		applyOptionsEnter("Connect to a Data Source",ifcreated);
		keyType(VK_ENTER);
		delay(5000);
		escapeDialog("Data was exported.", VK_ESCAPE);
		
		String msg = "Data was exported with errors";
		if( escapeDialog(msg,VK_ESCAPE) ) {
			throw new ApplicationErrorException(msg);
		}
	}

	public void queryDB() {
		leftClickMenuItem("Convert", "Query Database");
	}

	
	//---------------------------------------------------------------------------------------
	//-----------------------------               VIEW MENU  -----------------------------
	//---------------------------------------------------------------------------------------

	//This method was added to be able to add a new menu entry step for VS view tests
	
	public String getExtraViewMenu(){
		return null;
	}
	public String getExtraAuthenticMenu(){
		return null;
	}
	
	
	public void textView() {
		leftClickMenuItem("View", getExtraViewMenu(),"Text View");
	}
	public void authenticMenu(String menu) {
		leftClickMenuItem(getExtraAuthenticMenu(),"Authentic", menu);
	}
	
	public void textViewKey(){
		keyType(VK_ESCAPE);
		keyTypeAlt(KeyEvent.VK_V); //access to view menu
		keyType(KeyEvent.VK_T);//switch to text view
	}
	public void gridView() {
		leftClickMenuItem("View",getExtraViewMenu(), "Enhanced Grid View");
	}
	
	public void gridViewKey(){
		keyType(VK_ESCAPE);
		keyTypeAlt(VK_V); //access to view menu
		keyType(VK_G);//switch to grid view
	}
	
	public void schemaView() {
		leftClickMenuItem("View",getExtraViewMenu(), "Schema Design View");
	}
	
	public void wsdlView(){
		leftClickMenuItem("View",getExtraViewMenu(), "WSDL Design View");
	}
	
	public void xbrlView(){
		leftClickMenuItem("View",getExtraViewMenu(),"XBRL Taxonomy View");
		delay(2000);
	}
	
	public void designViewKey(){
		keyType(VK_ESCAPE);
		keyTypeAlt(KeyEvent.VK_V); //access to view menu
		keyType(KeyEvent.VK_S);//switch to schema view
	}
	
	public void authenticView() {
		leftClickMenuItem("View",getExtraViewMenu(), "Authentic View");
	}
	
	public void authenticViewKey(){
		keyType(VK_ESCAPE);
		keyTypeAlt(KeyEvent.VK_V); //access to view menu
		keyType(KeyEvent.VK_A);//switch to authentic view
	}
	
	public void browserView() {
		keyType(VK_ESCAPE);
		leftClickMenuItem("View",getExtraViewMenu(), "Browser View");
	}
	
	public void browserViewKey(){
		keyTypeAlt(KeyEvent.VK_V); //access to view menu
		keyType(KeyEvent.VK_B);//switch to browser view
	}
	
	public void expandGrid() {
		leftClickMenuItem("View",getExtraViewMenu(), "Expand +");
	}
	public void collapseGrid() {
		leftClickMenuItem("View",getExtraViewMenu(), "Collapse -");
	}
	public void expandGridFully() {
		leftClickMenuItem("View",getExtraViewMenu(), "Expand Fully");
	}
	public void collapseGridUnselected() {
		leftClickMenuItem("View",getExtraViewMenu(), "Collapse Unselected");
	}
	public void optimalGridWidths() {
		leftClickMenuItem("View",getExtraViewMenu(), "Optimal Widths");
	}
	public void wordWrap() {
		leftClickMenuItem("View",getExtraViewMenu(),"Word Wrap");
	}
	public void gotoLine(int line, int character) {
		leftClickMenuItem("View",getExtraViewMenu(), "Go to Line/Character");
		assertWindow("Go to text line/character");
		typeString(""+line);
		keyType(VK_TAB);
		typeString(""+character);
		keyType(VK_ENTER);
		escapeDialog("Please enter an integer between 1 and 2147483647.", VK_ESCAPE);
	}
	
	
	public void gotoFile() {

		gotoFile(false, null);
	
	}
	
	public void gotoFile(boolean isSpsFile, Options opt){
		
		leftClickMenuItem("View",getExtraViewMenu(),"Go to File");
		escapeDialog( "Unable to detect a valid file path at this position", VK_ESCAPE );
		
		if (isSpsFile){
			
			openSpsFileDesignWindow(opt);
		}
		
	}
	
	public void textViewSettings(Options options){
		leftClickMenuItem("View",getExtraViewMenu(), "Text View Settings");
		delay(500);
		applyOptionsEnter("Text View Settings", options);
	}
	
	
	public void openSpsFileDesignWindow(Option opt){
		
		assertWindow("Open SPS design");
		opt.applyOption(this);
		
		leftClickMid(findComponent("OK", "Button", null));
		delay(500);
	}
	
	//---------------------------------------------------------------------------------------
	//-----------------------------               BROWSER MENU  -----------------------------
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
	//---------------------------------------------------------------------------------------
	//-----------------------------               WSDL MENU  -----------------------------
	//---------------------------------------------------------------------------------------
	
	public void insertWSDLMessage() {
		insertWSDLMessage(null);
	}
		
	public void insertWSDLMessage(String name) {
		leftClickMenuItem("WSDL","WSDL 1.1 Components", "Messages","Insert Message");
		
		if(name != null) {
			typeString(name);
		}
		keyType(VK_ENTER);
	}
	public void deleteWSDLMessage() {
		
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Messages","Delete Message");
	}
	public void addWSDLMessageParameter(String message) {
		leftClickMenuItem("WSDL", "WSDL 1.1 Components","Messages","Add Message Part");
		if(message != null) {
			typeString(message);
		}
		keyType(VK_ENTER);
	}
	public void deleteWSDLMessageParameter() {
		leftClickMenuItem("WSDL","WSDL 1.1 Components", "Messages","Delete Message Part");
	}
	public void appendOperationRequest(String operation) {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Operations","Append Operation","request-response");
		if(operation != null) {
			typeString(operation);
		}
		keyType(VK_ENTER);
	}
	public void appendOperationSolicit(String operation) {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Operations","Append Operation","solicit-response");
		if(operation != null) {
			typeString(operation);
		}
		keyType(VK_ENTER);
	}
	public void appendOperationOneWay(String operation) {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Operations","Append Operation","one-way");
		if(operation != null) {
			typeString(operation);
		}
		keyType(VK_ENTER);
	}
	public void appendOperationNotification(String operation) {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Operations","Append Operation","notification");
		if(operation != null) {
			typeString(operation);
		}
		keyType(VK_ENTER);
	}
	public void appendEmptyOperation(String operation) {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Operations","Append Operation","Empty Operation");
		if(operation != null) {
			typeString(operation);
		}
		keyType(VK_ENTER);
	}
	public void deleteOperation() {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Operations","Delete Operation");
		escapeDialog("Do you want to delete them?", VK_Y);
	}
	
	public void addInputElementToOperation(String inputElement) {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Operations","Add Input Element");
		if(inputElement != null) {
			typeString(inputElement);
		}
		keyType(VK_ENTER);
	}
	
	public void addOutputElementToOperation(String outputElement) {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Operations","Add Output Element");
		if(outputElement != null) {
			typeString(outputElement);
		}
		keyType(VK_ENTER);
	}
	
	public void addFaultElementToOperation(String faultElement) {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Operations","Add Fault Element");
		if(faultElement != null) {
			typeString(faultElement);
		}
		keyType(VK_ENTER);
	}
	
	public void deleteAnyOperationElement() {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Operations","Delete Input/Output/Fault Element");
		escapeDialog("The following messages are not referenced within this WSDL", VK_Y);
	}
	
	public void addNewMessageToElementOperation(String messageInElement) {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Operations","Add New Message to Input/Output/Fault Element");
		if(messageInElement != null) {
			typeString(messageInElement);
		}
		keyType(VK_ENTER);
	}
	
	public void insertPorttype(String porttype) {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Port Type","Insert Port Type");
		if(porttype != null) {
			typeString(porttype);
		}
		keyType(VK_ENTER);
	}
	public void deletePorttype() {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Port Type","Delete Port Type");
		escapeDialog("The following messages are not referenced within this WSDL", VK_Y);
	}
	
	public void insertBinding(String binding) {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Binding","Insert Binding");
		if(binding != null) {
			typeString(binding);
		}
		keyType(VK_ENTER);
	}
	
	public void deleteBinding() {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Binding","Delete Binding");
		
	}
	
	public void appendSoapBodyInBinding() {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Binding","Append Child","soap:body");
		
	}
	
	public void appendSoapHeaderInBinding(String message) {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Binding","Append Child","soap:header");
		if(message != null) {
			typeString(message);
		}
		keyType(VK_ENTER);
	}
	
	public void appendSoapHeaderfaultInBinding(String message) {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Binding","Append Child","soap:headerfault");
		if(message != null) {
			typeString(message);
		}
		keyType(VK_ENTER);
	}
	
	public void appendSoapFaultInBinding(String message) {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Binding","Append Child","soap:fault");
		if(message != null) {
			typeString(message);
		}
		keyType(VK_ENTER);
	}
	
	public void appendMimeContentInBinding() {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Binding","Append Child","mime:content");
		
	}
	
	public void appendMimeMultipartrelatedInBinding() {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Binding","Append Child","mime:multipartrelated");
		
	}
	
	public void appendMimePartInBinding() {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Binding","Append Child","mime:part");
		
	}
	
	public void appendMimeMimeXmlInBinding() {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Binding","Append Child","mime:mimeXml");
		
	}
	
	public void appendHttpUrlencodedInBinding() {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Binding","Append Child","http:urlencoded");
		
	}
	
	public void appendHttpUrlreplacementInBinding() {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Binding","Append Child","http:urlreplacement");
		
	}
	
	public void deleteExtensibilityElement() {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Binding","Delete Extensibility Element");
		
	}
	
	public void insertService(String service) {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Service","Insert Service");
		if(service != null) {
			typeString(service);
		}
		keyType(VK_ENTER);
	}
	
	public void deleteService() {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Service","Delete Service");
		
	}
	
	public void insertPortInService(String port) {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Service","Insert Port");
		if(port != null) {
			typeString(port);
		}
		keyType(VK_ENTER);
	}
	
	public void deletePortInService() {
		leftClickMenuItem("WSDL","WSDL 1.1 Components","Service","Delete Port");
		
	}
	
	public void addNewInterfaceWSDL20(String interfaceName){
		leftClickMenuItem("WSDL","WSDL 2.0 Components","Interface","Add New Interface");
		if(interfaceName !=null){
			typeString(interfaceName);
		}
		keyType(VK_ENTER);
	}
	
	public void deleteInterfaceWSDL20(){
		leftClickMenuItem("WSDL","WSDL 2.0 Components","Interface","Delete Interface");
	}
	
	public void addNewFaultWSDL20(String faultName){
		leftClickMenuItem("WSDL","WSDL 2.0 Components","Interface","Add New Fault");
		if(faultName !=null){
			typeString(faultName);
		}
		keyType(VK_ENTER);
	}
	
	public void deleteFaultWSDL20(){
		leftClickMenuItem("WSDL","WSDL 2.0 Components","Interface","Delete Fault");
	}
	
	public void addNewOperationWSDL20(String operationtype,String operationName){
		leftClickMenuItem("WSDL","WSDL 2.0 Components","Interface","Add New Operation",operationtype);
		if(operationName !=null){
			typeString(operationName);
		}
		keyType(VK_ENTER);
	}
	
	public void deleteOperationWSDL20(){
		leftClickMenuItem("WSDL","WSDL 2.0 Components","Interface","Delete Operation");
	}
	
	public void addNewBindingWSDL20(String bindingName){
		leftClickMenuItem("WSDL","WSDL 2.0 Components","Binding","Add New Binding");
		if(bindingName !=null){
			typeString(bindingName);
		}
		keyType(VK_ENTER);
	}
	
	public void deleteBindingWSDL20(){
		leftClickMenuItem("WSDL","WSDL 2.0 Components","Binding","Delete Binding");
	}
	
	public void addFaultToBindingWSDL20(String faultName){
		leftClickMenuItem("WSDL","WSDL 2.0 Components","Binding","Add New Fault");
		if(faultName !=null){
			typeString(faultName);
		}
		keyType(VK_ENTER);
	}
	
	public void deleteFaultFromBindingWSDL20(){
		leftClickMenuItem("WSDL","WSDL 2.0 Components","Binding","Delete Fault");
	}
	
	public void addOperationToBindingWSDL20(String operationName){
		leftClickMenuItem("WSDL","WSDL 2.0 Components","Binding","Add New Operation");
		if(operationName !=null){
			typeString(operationName);
		}
		keyType(VK_ENTER);
	}
	
	public void deleteOperationFromBindingWSDL20(){
		leftClickMenuItem("WSDL","WSDL 2.0 Components","Binding","Delete Operation");
	}
	
	public void addServiceWSDL20(String serviceName){
		leftClickMenuItem("WSDL","WSDL 2.0 Components","Service","Add New Service");
		if(serviceName !=null){
			typeString(serviceName);
		}
		keyType(VK_ENTER);
	}
	
	public void deleteServiceWSDL20(){
		leftClickMenuItem("WSDL","WSDL 2.0 Components","Service","Delete Service");
	}
	
	public void addEndpointToServiceWSDL20(String endpointName){
		leftClickMenuItem("WSDL","WSDL 2.0 Components","Service","Add New Endpoint");
		if(endpointName !=null){
			typeString(endpointName);
		}
		keyType(VK_ENTER);
	}
	
	public void deleteEndpointFromServiceWSDL20(){
		leftClickMenuItem("WSDL","WSDL 2.0 Components","Service","Delete Endpoint");
	}
	public void newWSDLSchema(){
		leftClickMenuItem("WSDL","Types","New Schema");
		delay(2000);
	    escapeDialog("will now be opened in separate documents for editing",VK_ENTER);
	}
	
	public void editWSDLSchema(){
		leftClickMenuItem("WSDL","Types","Edit Schema(s) in Schema View");
	    delay(2000);
	    escapeDialog("will now be opened in separate documents for editing",VK_ENTER);
	}
	
	public void saveWSDLDiagram(String filename) {
		leftClickMenuItem("WSDL", "Save Diagram");
		typeFileName(filename);
		delay(3000);
	}
	
	public void generateWSDLDocumentation(File filepath,String filename,Options options) {
//		check that the directory exist, or create it if it doesn't
		//has to add dummy directory here, since only the parent is created
		checkDir(filepath+File.separator+"dummy");
		leftClickMenuItem("WSDL", "Generate Documentation");
		delay(2000);
		keyType(KeyEvent.VK_UP);
		applyOptionsEnter("WSDL documentation",options);
		delay(3000);
		typeFileName(filepath.getAbsolutePath()+"\\"+filename);
		escapeDialog("already exists", VK_Y);
		escapeDialog("Confirm Save As", VK_Y);
		delay(12000);
		logger.finest("Server Busy delay 12\"");
		delay(12000);
		logger.finest("Server Busy delay 24\"");
		delay(12000);
		logger.finest("Server Busy delay 36\"");
		escapeDialog("Server Busy", VK_R);	
	}
	
	 public void reparseWSDLDocument(){
		leftClickMenuItem("WSDL", "Reparse WSDL Document"); 

    }
	 
	 public void convertToWSDL20(File wsdl2filename){
		 leftClickMenuItem("WSDL", "Convert to WSDL 2.0"); 
		 delay(1000);
		 assertWindow("Save As");
		 typeFileName(wsdl2filename.getAbsolutePath());
	 }

	//---------------------------------------------------------------------------------------
	//-----------------------------               SOAP MENU  -----------------------------
	//---------------------------------------------------------------------------------------

	public void createSOAPRequest(String filename, String... operation) {
		
		createSOAPRequest(filename);
		selectSOAPRequest(false, operation);
				
	}
	
	public void createSOAPRequest20(String filename, String... operation) {
		
		createSOAPRequest(filename);
		selectSOAPRequest(true, operation);
				
	}
	
	public void createSOAPRequest(String filename){
		
		leftClickMenuItem("SOAP", "Create New SOAP Request");
		delay(500);
		assertWindow("Please enter the WSDL file location (local path or url)");
		
		Rectangle forwind = findComponentName("Please enter the WSDL file location (local path or url)");
		TextFieldOption wsdl  = new TextFieldOption("Choose a file", true, filename, "Choose a file", null, null, null, MS_SHELL_DLG_FONT);
		wsdl.applyOption(this);
		leftClickMid(findComponent("OK", "Button", forwind));
		delay(9000);
	}
	
	public void selectSOAPRequest(boolean isWSDL20, String... operation){
		
		delay(550);
		
		Rectangle forwind2 = null;
		String winTitle = "Please select a SOAP Operation";
		
		if (operation.length>1){ //when there are more Service, win title is different
			
			if (isWSDL20)
				winTitle ="Please select a Service and Endpoint";
			else
				winTitle ="Please select a Service and Port";	
		}
	 
		
		for (String string : operation) {
			
			assertWindow(winTitle);
			forwind2=findComponentName(winTitle);	
			
			try {
				leftClickString(string, DEFAULT_CONTENT_FONT, Color.BLACK, forwind2);
			
			
			} catch (Exception e) {
				// in case that the robot doesnt match it, I scroll the bar
				
				Rectangle temp = null;
			   	for (double sc = 0; sc <= 1; sc += 0.25) {
					
				   	scrollWindow(forwind2, sc);
				   	temp = null;
				   	
					try {
						
						temp = findString(string, DEFAULT_CONTENT_FONT, forwind2, false);
						if (temp != null) { 
							leftClickMid(temp);
							break;
						}else{
							
						}
						
					} catch (ImageNotFoundException e1) {
						logger.finer(">>>String not found. Following to search..temp=" + temp);
					
					}// 
			   	}   	
				if (temp == null) throw new ImageNotFoundException();
				
			}
			
			
			
			leftClickMid(findComponent("OK", "Button", forwind2));
			delay(9000);
			winTitle = "Please select a SOAP Operation";
			
		}
		


	}
	
	//Just click OK after I select Send SOAP Request (no further setting)
	public void sendSOAPrequest() {
		leftClickMenuItem("SOAP", "Send Request to Server");
		clickButton("OK");
	}
	
	//call "Send" SOAP Request function: then you should set the the necessary setting 
	private void sendSOAPRequestSettings(){
		
		leftClickMenuItem("SOAP", "Send Request to Server");
		assertWindow("SOAP Request Settings");
	}
	
	// call SOAP Request "setting": then you should set the 
	private void SOAPRequestSettings(){
		
		leftClickMenuItem("SOAP", "SOAP Request Settings");
		assertWindow("SOAP Request Settings");
	}
	
	//set SOAP Request settings for "Connection Settings" section
	private void setSOAP_ConnectionSettings (String endpoint, Integer timeout) {
		
		Options options=new Options();
		
		if (endpoint != null){
			options.add( new TextFieldOption("Address",false, endpoint, "Connection Settings", null, null,null,MS_SHELL_DLG_FONT));
		}
		
		if (timeout != null){
			options.add( new CheckboxOption("Infinite", false, "Connection Settings", null, null, null, MS_SHELL_DLG_FONT));
			options.add( new TextFieldOption("Timeout",false, timeout.toString(), "Connection Settings", null, null,null,MS_SHELL_DLG_FONT));
			
		}else{
		
			options.add(new CheckboxOption("Infinite", true, null, null, null, null, MS_SHELL_DLG_FONT));
		}
		
		applyOptionsEnter("SOAP Request Settings",options);
	}
	
	
	public void sendSOAPRequest_ConnectionSettings (String endpoint, Integer timeout) {
		
		sendSOAPRequestSettings();
		setSOAP_ConnectionSettings(endpoint, timeout);
	}
	

	public void SOAPRequestSettings_ConnectionSettings (String endpoint, Integer timeout) {
		
		SOAPRequestSettings();
		setSOAP_ConnectionSettings(endpoint, timeout);			
	}
	
	
	//set SOAP Request settings for "SOAP" section
	private void setSOAP_SOAPSettings (String action, Boolean soap12) {
		
		Options options=new Options();

		if (action != null){
			options.add( new TextFieldOption("Action",false, action, "SOAP Settings", null, null,null,MS_SHELL_DLG_FONT));
		}
		
		if (soap12 != null){
			options.add(new CheckboxOption("Send as SOAP+XML", soap12?true:false, "SOAP Settings", null, null, null, MS_SHELL_DLG_FONT));
		}	
		
		applyOptionsEnter("SOAP Request Settings",options);
	}
	
	
	public void sendSOAPRequest_SOAPSettings (String action, Boolean soap12) {
		
		sendSOAPRequestSettings();
		setSOAP_SOAPSettings(action, soap12);
	}
	
	public void SOAPRequestSettings_SOAPSettings (String action, Boolean soap12) {

		SOAPRequestSettings();	
		setSOAP_SOAPSettings(action, soap12);
	}
	
	
	//set SOAP Request settings for "HTTP security" section
	private void setSOAP_HTTPSecuritySettings (String username, String password, Boolean preemptive) {
		
		
		leftClickMid(findString("Edit", MS_SHELL_DLG_FONT, findComponentName("HTTP Security Settings"), false));

		delay(1000);
		assertWindow("HTTP Security Settings");
		
		Options options=new Options();
		
		if (username != null){
			
			TextFieldOption usr = new TextFieldOption("Username",false, username, "HTTP Authentication", null, null,null,WINDOWS_DEFAULT_FONT);
			usr.setX2(100);
			options.add(usr);
		}
		
		if (password != null){
			
			TextFieldOption pwd = new TextFieldOption("Password",false, username, "HTTP Authentication", null, null,null,WINDOWS_DEFAULT_FONT);
			pwd.setX2(100);
			options.add(pwd);
		}	
		
		if (preemptive != null){
			options.add( new CheckboxOption("Preemptive authentication", preemptive, "HTTP Authentication", null, null, null, WINDOWS_DEFAULT_FONT));
		}	
		
		applyOptionsEnter("HTTP Security Settings",options);
		
		leftClickButton("OK");	
	}
	
	
	public void sendSOAPRequest_HTTPSecuritySettings (String username, String password, Boolean preemptive) {
		
		sendSOAPRequestSettings();
		setSOAP_HTTPSecuritySettings(username, password, preemptive);
	}
	
	public void SOAPRequestSettings_HTTPSecuritySettings (String username, String password, Boolean preemptive) {

		SOAPRequestSettings();
		setSOAP_HTTPSecuritySettings(username, password, preemptive);
		
	}

	private void setSOAP_WSSecuritySettings (String username, String password, boolean isDigest, Boolean nonce, Boolean createdTimestamp, Integer timestamp) {
		
		String passwordType= "Text";
		
		Options options=new Options();
		
		leftClickMid(findString("Edit", MS_SHELL_DLG_FONT, findComponentName("WS-Security Settings"), false));

		delay(1000);
		assertWindow("WS-Security Settings");
		
		if (username != null || password != null){
			
			//options.add(new CheckboxOption("Add UsernameToken", true, null, null, null, null, WINDOWS_DEFAULT_FONT));
			leftClickMid(findString("Add UsernameToken", WINDOWS_DEFAULT_FONT, findComponentName("WS-Security Settings"), false));
		
			if (username != null){
				
				TextFieldOption usr = new TextFieldOption("Username:",false, username, null, null, null,null,WINDOWS_DEFAULT_FONT);
				usr.setX2(100);
				options.add(usr);
			}
		
			if (password != null){
				
				TextFieldOption pwd = new TextFieldOption("Password",false, password, null, null, null,null,WINDOWS_DEFAULT_FONT);
				pwd.setX2(100);
				options.add(pwd);
			}
			
			if (isDigest) passwordType = "Digest";
			options.add( new RadioOption(passwordType, null, null, null, null, WINDOWS_DEFAULT_FONT));
			
			if (nonce != null){
				options.add(new CheckboxOption("Add nonce", nonce, null, null, null, null, WINDOWS_DEFAULT_FONT));
			}
			
			if (createdTimestamp != null){
				options.add(new CheckboxOption("Add \"Created\" timestamp", createdTimestamp, null, null, null, null, WINDOWS_DEFAULT_FONT));
			}
			
			
		}//Add UsernameTokeb section
		
		if (timestamp != null){
			//options.add(new CheckboxOption("Add Timestamp", true, null, null, null, null, WINDOWS_DEFAULT_FONT));
			leftClickMid(findString("Add Timestamp", WINDOWS_DEFAULT_FONT, findComponentName("WS-Security Settings"), false));
			
			TextFieldOption ttl = new TextFieldOption("Time to live",false, timestamp.toString(), null, null, null,null,WINDOWS_DEFAULT_FONT);
			ttl.setX2(80);
			
			options.add(ttl);
			
		}
		
		applyOptionsEnter("WS-Security Settings",options);
		
		leftClickButton("OK");

		
	}
		
		
	
	public void sendSOAPRequest_WSSecuritySettings (String username, String password, boolean isDigest, Boolean nonce, Boolean createdTimestamp, Integer timestamp) {
		
		sendSOAPRequestSettings();
		setSOAP_WSSecuritySettings(username, password, isDigest, nonce, createdTimestamp, timestamp);
	}
	
	public void SOAPRequestSettings_WSSecuritySettings (String username, String password, boolean isDigest, Boolean nonce, Boolean createdTimestamp, Integer timestamp) {

		SOAPRequestSettings();
		setSOAP_WSSecuritySettings(username, password, isDigest, nonce, createdTimestamp, timestamp);		
	}
	
	
	public void SOAPDebuggerSession() {
		leftClickMenuItem("SOAP", "Soap Debugger Session");
		assertWindow("Please enter the WSDL file location (local path or url)");
		keyType(VK_ESCAPE);
	}
	public void SOAPDebuggerGo() {
		leftClickMenuItem("SOAP", "Go");
	}
	public void SOAPDebuggerSingleStep() {
		leftClickMenuItem("SOAP", "Single Step");
	}
	public void SOAPDebuggerBreakOnNextRequest() {
		leftClickMenuItem("SOAP", "Break on Next Request");
	}
	public void SOAPDebuggerBreakOnNextResponse() {
		leftClickMenuItem("SOAP", "Break on Next Response");
	}
	public void SOAPDebuggerStopProxy() {
		leftClickMenuItem("SOAP", "Stop the Proxy Server");
	}
	public void SOAPDebuggerOptions() {
		leftClickMenuItem("SOAP", "Soap Debugger Options");
		assertWindow("SOAP Debugger Options");
		keyType(VK_ESCAPE);
	}
	
	
	// SOAP DEBUGGER 
	
	public void SOAPDebuggerSession(File filename) {
		
		SOAPDebugger(filename);
		SOAPDebuggerOptions(null, null, null, null, null, null);
	}
	
	public void SOAPDebuggerSessionEnd() {
		leftClickMenuItem("SOAP", "Soap Debugger Session");
		escapeDialog("Service unavailable", VK_ENTER);
		escapeDialog("Unknown server error", VK_ENTER);
	}
	
	@Deprecated
	public void SOAPDebuggerSession(File filename, String sourcePort, String targetPort, String address, Boolean secureConn) {
		
		SOAPDebugger(filename);
		//SOAPDebuggerOptions(sourcePort, targetPort, address, secureConn);
	}
	
	public void SOAPDebuggerSession(File filename, String sourceport, Integer timeout, String address, String username, String password, Boolean preemptive) {
		
		SOAPDebugger(filename);
		SOAPDebuggerOptions(sourceport,  address, timeout, username, password, preemptive);
	}

	
	public void SOAPDebugger(File filename) {
		
		leftClickMenuItem("SOAP", "Soap Debugger Session");
		delay(500);
		assertWindow("Please enter the WSDL file location (local path or url)");
		
		Rectangle forwind = findComponentName("Please enter the WSDL file location (local path or url)");
		TextFieldOption wsdl  = new TextFieldOption("Choose a file", true, filename.getAbsolutePath(), "Choose a file", null, null, null, MS_SHELL_DLG_FONT);		
		wsdl.applyOption(this);
		leftClickMid(findComponent("OK", "Button", forwind));
		delay(400);
		
		
	}
	
	
	public void SOAPDebuggerOptions(String sourcePort, String address, Integer timeout,  String username, String password, Boolean preemptive) {
		
		
		delay(800);
		Rectangle forwind = findComponentName("Please choose the source and target ports");
		assertWindow("Connection Settings for Source and Target");
		
		if (sourcePort != null){
			TextFieldOption sp = new TextFieldOption("Port", sourcePort, "Source");
			sp.applyOption(this);
		}
		
		
		Options options=new Options();
		
		if (address != null){
			options.add( new TextFieldOption("Address",false, address, "Connection Settings", null, null,null,MS_SHELL_DLG_FONT));
		}
		
		if (timeout != null){
			options.add( new CheckboxOption("Infinite", false, "Connection Settings", null, null, null, MS_SHELL_DLG_FONT));
			options.add( new TextFieldOption("Timeout",false, timeout.toString(), "Connection Settings", null, null,null,MS_SHELL_DLG_FONT));
			
		}else{
		
			options.add(new CheckboxOption("Infinite", true, null, null, null, null, MS_SHELL_DLG_FONT));
		}
		
		applyOptionsNoConfirm(options);
		
				
		setSOAP_HTTPSecuritySettings(username, password, preemptive);
		
		//leftClickMid(findComponent("OK", "Button", forwind));
		delay(5000);
		
	}
	
	
	public void SOAPFunctionBreakpoint(String soapFunction, boolean onRequest, boolean onResponse){
		
		setSOAPDebuggerTab(SpyRobot.FUNCTION_BREAKPOINTS);
		
		//get the "Soap Debugger" pane area
		Rectangle soapDebugPane = findComponentName("Soap Debugger");
		
		//In the "Soap Debugger" pane, click on the chosen soap function (must be selected)
		Rectangle soapFuncName = findString(soapFunction, DEFAULT_CONTENT_FONT, soapDebugPane, false);
		if (soapFuncName!=null) 
			leftClickMid(soapFuncName);
		
		//It is getting the wide area of soap function (a little bit bigger), including the "onRequest" square  
		Rectangle fullsoapFuncName = new Rectangle(soapFuncName.x, soapFuncName.y-10, (soapDebugPane.width+soapDebugPane.x-soapFuncName.x), soapFuncName.height+20);

		//search and click on "onRequest" square 
		Rectangle requestClickArea = findImage(SOAP_FUNCTION_BREAKPOINT_ICON.getAbsolutePath(), fullsoapFuncName, false);
		if (onRequest)
			leftClickMid(requestClickArea);
		
		delay(2000);
		if (onResponse)
			leftClickMid(new Rectangle(requestClickArea.x+80, requestClickArea.y, requestClickArea.width, requestClickArea.height ));
		
	}

	private void setConditionalBreakpointsParameter(String xPath,
			boolean version20, String breakOnValue,
			boolean breakWhenXPathFound, boolean breakWhenXPathMissing,
			boolean anyFunction, String selectFunction, boolean requests,
			boolean responses) {
		
		assertWindow("Please select the conditional breakpoints parameters");
		
		//
		TextFieldOption xp = new TextFieldOption("XPath", xPath, "Condition");
		xp.applyOption(this);
		//
		RadioOption ver = null;
		if (version20)
			ver = new RadioOption("2.0", "Condition");
		else
			ver = new RadioOption("1.0", "Condition");
		ver.applyOption(this);
		//
		if (breakOnValue != null){
			RadioOption bov = new RadioOption("Break on value", "Condition");
			bov.applyOption(this);
			TextFieldOption bovtxt = new TextFieldOption("Break on value", breakOnValue, "Condition");
			bovtxt.applyOption(this);
		}
		//
		RadioOption breakNode    = null;
		if (breakWhenXPathFound){
			breakNode     = new RadioOption("Break when XPath nodes found", "Condition");
		}else if(breakWhenXPathMissing){
			breakNode     = new RadioOption("Break when XPath nodes missing", "Condition");
		}	
		if (breakNode != null ) breakNode.applyOption(this);
		//
		RadioOption af    = null;
		if (anyFunction){
			af     = new RadioOption("Any function", "Function");
			af.applyOption(this);
		}	
		if (selectFunction != null){
			/////////// digit on Any function text filed handling//////////////////////////////
			Rectangle anyFunctionStr = findString("Any function", MS_SHELL_DLG_FONT, findComponentName("Please select the conditional breakpoints parameters"), false); 
			leftClickMid(anyFunctionStr);
			delay(1500);
			keyType(VK_DOWN);
			delay(500);
		 
			try {
				leftClickMid(findString(selectFunction, MS_SHELL_DLG_FONT, findComponentName("Please select the conditional breakpoints parameters"), false));
		
			} catch (Exception e) {
			//in case the element is not found as 1st element of DropDown oprion, 
			//I just scroll the DropDown
			
			leftClickMid(new Rectangle(anyFunctionStr.x, anyFunctionStr.y+20, anyFunctionStr.width, anyFunctionStr.height));
			leftClickMid(findString(selectFunction, MS_SHELL_DLG_FONT));
			}
		}	
	
		// ---<
		boolean reqValue = false;
		if (requests){
			reqValue = true;
		}
		CheckboxOption req = new CheckboxOption("Requests", reqValue, "During");
		req.applyOption(this);
			
		boolean respValue = false;
		if (responses){
			respValue = true;
		}
		CheckboxOption resp = new CheckboxOption("Responses", respValue, "During");
		resp.applyOption(this);
		
		clickButton("OK");
	}

	public void SOAPConditionalBreakpoint_Add(String xPath, boolean version20, String breakOnValue, boolean breakWhenXPathFound, boolean breakWhenXPathMissing, boolean anyFunction, String selectFunction,  boolean request, boolean response ){
		
		setSOAPDebuggerTab(SpyRobot.CONDITIONAL_BREAKPOINTS);
		
		leftClickMid(findString("Add", MS_SHELL_DLG_FONT, findComponentName("Soap Debugger"), false));
		delay(200);
		
		setConditionalBreakpointsParameter(xPath, version20, breakOnValue, breakWhenXPathFound, breakWhenXPathMissing, anyFunction, selectFunction, request, response);	
	}
	
	public void SOAPConditionalBreakpoint_Delete(String xpathName){
			
		setSOAPDebuggerTab(SpyRobot.CONDITIONAL_BREAKPOINTS);
		Rectangle soapDebuggerFrame = findComponentName("Soap Debugger");
		
		leftClickMid(findString(xpathName, DEFAULT_CONTENT_FONT, soapDebuggerFrame, false));
		leftClickMid(findString("Delete", MS_SHELL_DLG_FONT, soapDebuggerFrame, false));
	}	
	
	public void SOAPConditionalBreakpoint_Change(String breakpointToChange, String xPath, boolean version20, String breakOnValue, boolean breakWhenXPathFound, boolean breakWhenXPathMissing, boolean anyFunction, String selectFunction,  boolean request, boolean response ){
		
		setSOAPDebuggerTab(SpyRobot.CONDITIONAL_BREAKPOINTS);
		
		leftClickMid(findString(breakpointToChange, DEFAULT_CONTENT_FONT, findComponentName("Soap Debugger"), false));
		
		leftClickMid(findString("Change", MS_SHELL_DLG_FONT, findComponentName("Soap Debugger"), false));
		delay(200);

		setConditionalBreakpointsParameter(xPath, version20, breakOnValue, breakWhenXPathFound, breakWhenXPathMissing, anyFunction, selectFunction, request, response);
	}
	
	private void setSOAPDebuggerTab(Pane breakpointsPane) {
		
		leftClickMid(findString(breakpointsPane.getName(), MS_SHELL_DLG_FONT, findComponentName("Soap Debugger"), false));
	}
	
	public void turnOnDebuggingMode(File debuggerClientName) {

		openFile(debuggerClientName);
		leftClickMid(findImage(SOAP_DEBUGGER_TURNON_BUTTON_ICON.getAbsolutePath()));
		delay(8000); //
	}
	
	public void turnOffDebuggingMode() {

		try {
			leftClickMenuItem("Window", "DebuggerClient.htm");
			leftClickMid(findImage(SOAP_DEBUGGER_TURNOFF_BUTTON_ICON.getAbsolutePath()));
			
		} catch (Exception e) {
			logger.fine("DebuggerClient.htm not found. Probably is not even opened");
		}
		
		
	}
	
	
	public void switchToSOAPRequest(){
		
		leftClickMenuItem("Window", "SOAP Request");
		prettyPrint_icon();
	}
	
	public void switchToSOAPResponse(){
		
		leftClickMenuItem("Window", "SOAP Response");
		prettyPrint_icon();
	}
	
	
	//---------------------------------------------------------------------------------------
	//-----------------------------               TOOLS MENU  -----------------------------
	//---------------------------------------------------------------------------------------

	public void spelling() {
		//leftClickMenuItem("Tools", "Spelling... ");
		keyTypeShift(VK_F7);
		delay(800);
		assertWindow("Spelling: English (US)");
		keyType(VK_ESCAPE);
	}
	public void spellingOptions() {
		leftClickMenuItem("Tools", "Spelling Options...");
		assertWindow("Spelling Options");
		keyType(VK_ESCAPE);
	}
	
	public void scriptingEnvironment() {
		leftClickMenuItem("Tools", "Switch to Scripting Environment");
	}
	
	public void showMacros() {
		
		leftClickMenuItem("Tools", "Show Macros");
		assertWindow("Show Macros...");
		keyType(VK_ESCAPE);
	}
	public void compareOpenFileWith(String fileToCompare) {
		leftClickMenuItem("Tools", "Compare Open File With");
		assertWindow("XML Spy");
		Rectangle forwind=NativeGUI.getForegroundWindowInfo().getLocation();
		Rectangle choosefile=findComponent("Choose a file", "Button",forwind);
		leftClick(choosefile.x+30,choosefile.y+20);	
		typeFileName(fileToCompare);
		delay(2000);
		assertWindow("Settings");
		//keyType(VK_ENTER);
		leftClickMid(findComponent("OK", "Button", null));
		delay(5000);
				
	}
	public void compareDirectories() {
		leftClickMenuItem("Tools", "Compare Directories");
		assertWindow("Select directories");
		keyType(VK_ESCAPE);
	}
	public void compareOptions() {
		leftClickMenuItem("Tools", "Compare Options");
		assertWindow("Settings");
		keyType(VK_ESCAPE);
	}
	public void customize() {
		leftClickMenuItem("Tools", "Customize");
		assertWindow("Customize");
		keyType(VK_ESCAPE);
	}
	
	public void activateOptionsDialog(){
		
		leftClickMenuShortcut("Tools","O");
		
	}
	
	public void manageRaptorServers(){
		
		leftClickMenuItem("Tools", "Manage Raptor Servers");
		assertWindow("RaptorXML Server Options");
		
	}


	
	
	//---------------------------------------------------------------------------------------
	//-----------------------------               WINDOW MENU  -----------------------------
	//---------------------------------------------------------------------------------------
	
	
	public void windowXSLOutline(){
		leftClickMenuItem("Window","XSL Outline");
	}
	
	public void window(String fileName){
		leftClickMenuItem("Window",fileName);
	}
	
	
	
	//---------------------------------------------------------------------------------------
	//-----------------------------               HELP MENU  -----------------------------
	//---------------------------------------------------------------------------------------

	//other help methods in AltovaApplicationRobot class
	
	public void keyboardMap() {
		leftClickMenuItem("Help",getExtraHelpMenus(),"Keyboard Map");
	}

	public void webTraining() {
		leftClickMenuItem("Help",getExtraHelpMenus(),"XMLSpy Training");
	}
	
	public void webXmlSpy() {
		super.applicationOnWeb();
	}
	
	public void aboutXmlSpy() {
		super.aboutApplication();
	}

	//---------------------------------------------------------------------------------------
	//----------------------------    Schema View Operations   ------------------------------
	//---------------------------------------------------------------------------------------
	
	private void usePane(String key, Pane pane, String action) {
		Rectangle r = activatePane(pane);
		findIcon(action, r,true) ;
		if(!action.equals("IDC_ROW_DELETE")) typeStringConditional(key) ;
	}
	
	public void insertInSchemaViewPane(Pane panename,String enumname) {
		Rectangle pane=activatePane(panename);
		leftClick("IDC_ROW_INSERT", pane,false);
		
		if(enumname!=null){
		typeString(enumname);
		}
		
		keyType(VK_ENTER);
		
	}
	
	public void appendInSchemaViewPane(Pane panename,String enumname) {
		Rectangle pane=activatePane(panename);
		leftClick("IDC_ROW_APPEND", pane,false);
		
		if(enumname!=null){
		typeString(enumname);
		}
		
		keyType(VK_ENTER);
		
	}
	
	public void deleteEnumeration(String key,boolean ifInvalidValue){
		Rectangle r = activatePane(FACETS_ENUMERATIONS);
		Color useColor =Color.BLUE;
		if(ifInvalidValue){
			useColor =Color.RED;
		}
		leftClickString(key, DEFAULT_CONTENT_FONT, useColor, r) ;
		delay(500);
		leftClickMid(findIcon("ID_EDIT_CLEAR", r,true)) ;	
	}
	
	public void deleteSampleValue(String value,boolean ifInvalidValue){
		Rectangle r = activatePane(FACETS_SAMPLES);
		Color useColor =Color.BLUE;
		if(ifInvalidValue){
			useColor =new Color(255,127,0);
		}
		leftClickString(value, DEFAULT_CONTENT_FONT, useColor, r) ;
		delay(500);
		leftClickMid(findIcon("ID_EDIT_CLEAR", r,true)) ;
	}
	
	public void editSampleValue(String old,boolean ifInvalidValue, String neww) {
		Rectangle r = activatePane(FACETS_SAMPLES);
		Color useColor =Color.BLUE;
		if(ifInvalidValue){
			useColor =new Color(255,127,0);
		}
		leftClickString(old, DEFAULT_CONTENT_FONT, useColor, r) ;
		typeStringConditional(neww) ;
	}
	
	public void editEnumeration(String old, String neww) {
		Rectangle r = activatePane(FACETS_ENUMERATIONS);
		leftClickString(old, DEFAULT_CONTENT_FONT, Color.BLUE, r) ;
		typeStringConditional(neww) ;
	}
	
	public void insertPattern(String key){
		usePane(key, FACETS_PATTERNS, "IDC_ROW_INSERT") ;
	}
	public void appendPattern(String key, String appendTo){
		activatePane(FACETS_PATTERNS);
		leftClickString(appendTo) ;
		usePane(key, FACETS_PATTERNS, "IDC_ROW_APPEND") ;
	}
	public void deletePattern(String key){
		usePane(key, FACETS_PATTERNS, "IDC_ROW_DELETE") ;		
	}	
	public void editPattern(String old, String neww) {
		Rectangle r = activatePane(FACETS_PATTERNS);
		leftClickString(old, DEFAULT_CONTENT_FONT, Color.BLUE, r) ;
		typeStringConditional(neww) ;
	}
	
	public void insertSimpleType(String key){
		usePane(key, DETAILS_SIMPLE_TYPE, "IDC_ROW_INSERT") ;
	}
	public void appendSimpleType(String key, String appendTo){
		activatePane(DETAILS_SIMPLE_TYPE);
		leftClickString(appendTo) ;
		usePane(key, DETAILS_SIMPLE_TYPE, "IDC_ROW_APPEND") ;
	}
	public void deleteSimpleType(String key){
		usePane(key, DETAILS_SIMPLE_TYPE, "IDC_ROW_DELETE") ;		
	}
	public void appendSubSimpleType(String key){
		usePane(key, DETAILS_SIMPLE_TYPE, "IDC_ROW_???") ;
	}
	public Rectangle findSchemaElement(String xpath) {
		Rectangle found = null;
		Rectangle mw = getMainWindow();
		String[] elements = xpath.split("/");
		Rectangle searchColumn = new Rectangle(mw.x, mw.y, 200, mw.height);
		for(String e : elements) {
//			(int x, int y, int width, int height)			
			try {
				found = findString(e, ImageRecognitionRobot.DEFAULT_CONTENT_FONT, searchColumn, false);
			} catch (ImageNotFoundException ex) {
				logger.warning("schema element image not found, trying expand all elements");
				keyType(KeyEvent.VK_MULTIPLY);
				searchColumn.x += 50 ; 
				//TODO scrollbar may need to be used to search further
				found = findString(e, ImageRecognitionRobot.DEFAULT_CONTENT_FONT, searchColumn, false);
			}			
			leftClickMid(found);
			keyType(KeyEvent.VK_PLUS);
			keyType(KeyEvent.VK_RIGHT);
			keyType(KeyEvent.VK_PLUS);
			searchColumn= new Rectangle(found.x+found.width, mw.y, searchColumn.width, mw.height );
		}
		return found;
	}
	
	public void deleteGlobalItemInSchema(String xpath){
		xpathHighlight(xpath);
		leftClick("ID_EDIT_CLEAR");
	}
	
	//this method can be used only once the item has been selected in the window 
	public void selectFromItemContxtMenuInSchemaDiagram(String... menuItems){
		Rectangle mW=getMainWindow();
		mouseMove(mW.x+10, mW.y+20);
		rightClick();
		for(String s : menuItems) {
			Rectangle r=new Rectangle(mW.x+10,mW.y+20,mW.x+410,mW.height);
			leftClickString(s,WINDOWS_DEFAULT_FONT,Color.BLACK,r);
			delay(300) ;
		}
	}
	
	public void insertXMLItemSchemaView(String item,String itemname, String itemdescript) {

		leftClick("IDC_ROW_INSERT", getMainWindow(),false);
		leftClickMid(findString(item,getMainWindow(), false));
		if(itemname!=null){
		typeString(itemname);
		}
		keyType(VK_TAB);delay(500);
		if(itemdescript!=null){
			typeString(itemdescript);
		}
		keyType(VK_ENTER);
		
	}

	public void appendXMLItemSchemaView(String itemToInsert,String itemname, String itemdescript) {

		leftClick("IDC_ROW_APPEND", getMainWindow(),false);
		leftClickMid(findString(itemToInsert,getMainWindow(), false));
		if(itemname!=null){
		typeString(itemname);
		}
		keyType(VK_TAB);delay(500);
		if(itemdescript!=null){
			typeString(itemdescript);
		}
		keyType(VK_ENTER);
		
	}

	public void insertInSchemaAttrWdw(String AttTypeToInsert, String name, boolean isRef, String type, String use, String def, String fixed) {
		
		Rectangle Attrib_window = findComponentClass("SysTabControl32");
		Rectangle ContextWindArea = new Rectangle(Attrib_window.x,Attrib_window.y,(Attrib_window.width)/2,Attrib_window.height);
		leftClick(Attrib_window.x + 10, Attrib_window.y + 10);
		leftClick("IDC_ROW_INSERT", Attrib_window, false);
		leftClickMid(findString(AttTypeToInsert, ContextWindArea, false));
		if (AttTypeToInsert == "Attribute") {
			if (name != null) {
				typeString(name);
				keyType(VK_TAB);
				delay(1000);
				if (isRef) {
					escapeDialog("Do you want to reference to it?", VK_Y);
				} else {
					escapeDialog("Do you want to reference to it?", VK_N);
				}

			}else{
				keyType(VK_TAB);delay(1000);
			}
			if (type != null) {
				typeString(type);
			}
			keyType(VK_TAB);
			delay(500);
			if (use != null) {
				typeString(use);
			}
			keyType(VK_TAB);
			delay(500);
			if (def != null) {
				typeString(def);
			}
			keyType(VK_TAB);
			delay(500);
			if (fixed != null) {
				typeString(fixed);
			}
		} else {
			if (name != null) {
				typeString(name);
			}
		}
		keyType(VK_ENTER);

	}
	public void appendInSchemaAttrWdw(String AttTypeToInsert, String name, boolean isRef, String type, String use, String def, String fixed) {
		
		Rectangle Attrib_window = findComponentClass("SysTabControl32");
		Rectangle ContextWindArea = new Rectangle(Attrib_window.x,Attrib_window.y,(Attrib_window.width)/2,Attrib_window.height);
		leftClick(Attrib_window.x + 10, Attrib_window.y + 10);
		leftClick("IDC_ROW_APPEND", Attrib_window, false);
		leftClickMid(findString(AttTypeToInsert, ContextWindArea, false));
		if (AttTypeToInsert == "Attribute") {
			if (name != null) {
				typeString(name);
				keyType(VK_TAB);
				delay(1000);
				if (isRef) {
					escapeDialog("Do you want to reference to it?", VK_Y);
				} else {
					escapeDialog("Do you want to reference to it?", VK_N);
				}

			}else{
				keyType(VK_TAB);delay(1000);
			}
			if (type != null) {
				typeString(type);
			}
			keyType(VK_TAB);
			delay(500);
			if (use != null) {
				typeString(use);
			}
			keyType(VK_TAB);
			delay(500);
			if (def != null) {
				typeString(def);
			}
			keyType(VK_TAB);
			delay(500);
			if (fixed != null) {
				typeString(fixed);
			}
		} else {
			if (name != null) {
				typeString(name);
			}
		}
		keyType(VK_ENTER);

	}
	
	public void insertInSchemaIdConstWdw(String TypeToInsert, String name, String ref, String selector, String field) {
		
		Rectangle Attrib_window = findComponentClass("SysTabControl32");
		Rectangle ContextWindArea = new Rectangle(Attrib_window.x,Attrib_window.y,(Attrib_window.width)/2,Attrib_window.height);
		leftClick(Attrib_window.x + 100, Attrib_window.y + 10);
		leftClick("IDC_ROW_INSERT", Attrib_window, false);
		leftClickMid(findString(TypeToInsert, ContextWindArea, false));

		if (name != null) {
			typeString(name);
		}

		if (TypeToInsert != "Field") {
			keyType(VK_TAB);
			delay(1000);
			if (TypeToInsert == "Keyref") {
				if (ref != null) {
					typeString(ref);

				}
				keyType(VK_TAB);
				delay(500);
			}

			if (selector != null) {
				typeString(selector);
			}
			keyType(VK_TAB);
			delay(500);
			if (field != null) {
				typeString(field);
			}
		}
		keyType(VK_ENTER);

	}
	
	public void appendInSchemaIdConstWdw(String TypeToInsert, String name, String ref, String selector, String field) {
		
		Rectangle Attrib_window = findComponentClass("SysTabControl32");
		Rectangle ContextWindArea = new Rectangle(Attrib_window.x,Attrib_window.y,(Attrib_window.width)/2,Attrib_window.height);
		leftClick(Attrib_window.x + 100, Attrib_window.y + 10);
		leftClick("IDC_ROW_APPEND", Attrib_window, false);
		leftClickMid(findString(TypeToInsert, ContextWindArea, false));

		if (name != null) {
			typeString(name);
		}

		if (TypeToInsert != "Field") {
			keyType(VK_TAB);
			delay(1000);
			if (TypeToInsert == "Keyref") {
				if (ref != null) {
					typeString(ref);

				}
				keyType(VK_TAB);
				delay(500);
			}

			if (selector != null) {
				typeString(selector);
			}
			keyType(VK_TAB);
			delay(500);
			if (field != null) {
				typeString(field);
			}
		}
		keyType(VK_ENTER);

	}
	
	public void visualizeIdentityConstraintsStateChange(){
		leftClickMid(findImage("spy\\res\\visualize_identconst_icon.PNG"));
	}
	
	public void smartRectrictionStateChange(){
		leftClickMid(findImage("spy\\res\\enableSmartRectriction_icon.PNG"));
	}
	
	//---------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------
	//-----------------------------     Other functionality in Spy       --------------------
	//---------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------

	public void checkDisableXPathAutoCompletion(){
		
		Rectangle new_doc_wind = findComponentName("XPath/XQuery");

		Rectangle temp = null;

		try{
			
			temp = findImage(XPATH_AUTOCOMPLETION_DISABLED.getAbsolutePath(), new_doc_wind, false);
			if (temp != null) { 				 	
				leftClickMid(temp);
			}
	
		}catch(Exception e){
			
			logger.finest("No further action: probably auto-completion icon is already disabled");
		}
		
		
	}
	
	
	public String xpathEvaluation(String xpath) {
		logger.fine("xpathEvaluation: "+xpath);
		Rectangle pane = activatePane(XPATH);
		keyRelease(VK_ESCAPE);
		
		checkDisableXPathAutoCompletion();
		
		String msg = null;
		int trys = 3;
		boolean found = false;
		for (int i = 0; i < trys && !found; i++) {
			
			Rectangle input = null;
			
			if (this instanceof VSnetSpyRobot){
				input = findComponentClass("XMLSpy_scintilla");
			}else{
				input = findComponent(null, "XMLSpy_scintilla", pane);
			}	
			//first find the input field, and put in the text
			
			if(input==null){
				throw new ScriptMistakeException("Xpath text field could not be found.");
			}
			logger.finest("Found input field at " + input);
			leftClickMid(input);
			delay(500);
			//removeTextfieldText();
			removeTextfieldTextEsc();
			delay(100);
			typeString(xpath);

			// ok, so we've typed in the xpath, now let's check the message
			// window, but also try again if one of the two messages below appears
			msg = getMessageWindowText(XPATH);
			if(msg != null && msg.indexOf("Unexpected end of statement") == -1 &&
					msg.indexOf("No results") == -1 ) {
				found = true;
			} else {
				logger.fine("XPath gave no results. Try "+(i+1)+" of "+trys);
			}
		}
		
		logger.finer("XPath Result: "+msg);
		return msg;
	}
	
	public void xpathHighlight(String xpath) {
		xpathHighlight(xpath, 1);
		
	}
	
	public void xpathHighlight(String xpath, int node) {
		
		String msg = xpathEvaluation(xpath);
		
		//do some error checking
		if(msg.indexOf("Unexpected token") > -1) {
			throw new ScriptMistakeException("The xpath was invalid: "+msg+". Xpath used: "+xpath);
		}
		else if(msg.indexOf("Unexpected end of statement") > -1 ||
				msg.indexOf("No results") > -1 ) {
			throw new ScriptMistakeException("The specified xpath did not return any elements: "+xpath+
											 ".\n The output message was "+msg);
		}
		else if(msg.indexOf("No XML present to evaluate XPath") > -1) {
			throw new ScriptMistakeException(msg +": "+xpath+".\n The output message was "+msg);
		}
		
		//so, let's assume we have a valid result in the output window now
		//let's first find the output window
		Rectangle pane = activatePane(XPATH);
		Point p = new Point(pane.x+pane.width/2, pane.y+pane.height-50);
		ComponentInfo ci = NativeGUI.getWindowInfo(p.x, p.y);
		Rectangle res = ci.getLocation();
		logger.finest("Probing for Result window at "+p+". Found "+ci);
		
		//where do we need to click
		int resultLineHeight = 18;
		Point resLine = new Point(res.x+30, res.y+resultLineHeight*(node-1)+resultLineHeight/2);
		if(!res.contains(resLine)) {
			throw new ScriptMistakeException("You've tried to select a line outside the result window."+
											 "Found result window at "+ci+", calculated point: "+resLine);
		}
		
		logger.finest("Clicking line at "+resLine);
		leftClick(resLine);
		delay(1000);
	}
	
	//---------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------
	//-----------------------------      special or combined operations  --------------------
	//---------------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------------

	protected void escapeGeneralDialogs(String message) {
		boolean fail;
		fail = escapeDialog("An error occured loading", VK_ESCAPE); //for spelling issues, see #18877 (it's fixed, but this line stay for backwards compatability) 
		fail |= escapeDialog("An error occurred loading", VK_ESCAPE);
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
		
		//escaping eclipse dialogs
		if(this instanceof PluginRobot) {
			PluginRobot plugin = (PluginRobot)this;
			plugin.escapePluginDialogs("Waiting while closing plugin dialogs");
		}
		
		waitAndEsacpe(message);
	}
	
	public void escapeByWindowComponent(String windowName, String typeToClick){
		
		
		assertWindow(windowName);
		
		Rectangle win = findComponentName(windowName);
		leftClickMid(findString(typeToClick, win, false));
		
	}
	
	protected void typeFileName(String name) {
		typeStringEnter(name); delay(2000);
		escapeGeneralDialogs("Waiting while escaping file dialogs");
	}
	
	
	public void expandText(String text) {
		expandCollapseText(text, "Expand.png");
	}
	
	public void collapseText(String text) {
		expandCollapseText(text, "Collapse.png");
	}
	
	private void expandCollapseText(String text,String image) {
		
		Rectangle r=findSelection(text);
		Rectangle w=getMainWindow();
		Rectangle hint =new Rectangle(w.x,r.y,r.x+r.width-w.x,r.height);
		logger.finest("Trying to search for the expand-collapse button at"+hint);
		Rectangle rect=find(ImageUtils.readIcon(image),hint,false);
		leftClickMid(rect);
				
	}
	
	/*
	 * 
	 */
	
	public Rectangle newFileXBRLWinStep1(String filetype, String ext_window, String taxonomy){
		
			delay(2000);
			delay(10000);
			assertWindow(ext_window);
			Rectangle new_doc_wind = findComponentName(ext_window);
		
			
			TextFieldOption t = new TextFieldOption("Ticker (or company) name:", false ,"Altova" + "-" + taxonomy.toLowerCase(), null, null,  null, null ,WINDOWS_DEFAULT_FONT);
			t.setX2(100);
			t.applyOption(this);

			DropDownOption d = new DropDownOption ("Taxonomy base:", false, taxonomy, null, null, null, null, WINDOWS_DEFAULT_FONT);
			d.setX1(90);
			d.applyOption(this);

			// Insert the date: will be inserted 2nd november 2009
			
			TextFieldOption t21 = new TextFieldOption("Date:", false ,"11", null, null,  null, null ,WINDOWS_DEFAULT_FONT);
			t21.setX2(152);
			t21.applyOption(this);

			//month and year will be inserted just shifting the cursor
			
			keyType(VK_RIGHT);
			delay(500);
			keyType(VK_2);
			delay(500);
			keyType(VK_RIGHT);
			keyType(VK_2);
			keyType(VK_0);
			keyType(VK_0);
			keyType(VK_9);
			File FolderXBRL = new File(IOUtils.findFile("spy/examples").toString());
			TextFieldOption t3 = new TextFieldOption("Destination Folder:", false , FolderXBRL.toString(), null, null, null ,null, WINDOWS_DEFAULT_FONT);
			t3.setX2(100);
			t3.applyOption(this);

			if (taxonomy.equals("None"))
				leftClickMid(findString("Finish", new_doc_wind, false));
			else
			leftClickMid(findString("Next", new_doc_wind, false));
			delay(1000);
			
			return new_doc_wind;
			
	}
	
	public void newFileXBRLWinStep2(Rectangle new_doc_wind){
		
		newFileXBRLWinStep2(new_doc_wind, "", "");
	}
	
	public void newFileXBRLWinStep2(Rectangle new_doc_wind, String taxonomy, String entryPointSchema){
		
		assertWindow("Create New Taxonomy - Step 2");
		
		if (taxonomy.equals("IFRS")){
			
			RadioOption entPnt = new RadioOption(entryPointSchema, null, null, null, null, WINDOWS_DEFAULT_FONT);
			entPnt.applyOption(this);
		}
		delay(300);
		leftClickMid(findString("Finish", new_doc_wind, false));
		
		delay(12000);
		delay(12000);
		delay(12000);
		delay(12000);
		delay(8000);
		maximizeFileWindow();
	
}
	enum XBRLTabSchema{Elements, Definitions, Presentation, Calculation, Formula, Table}
		
	private void switchTabXBRLSchema(XBRLTabSchema tab) {

		//Rectangle hint = getMainWindow();
		leftClickMid(findString(tab.toString(), MS_SHELL_DLG_FONT, null, true));
		
	}
	
	public void switchXBRLTab_Definitions(){
		
		switchTabXBRLSchema(XBRLTabSchema.Definitions);
	}
	
	public void switchXBRLTab_Presentation(){
		
		switchTabXBRLSchema(XBRLTabSchema.Presentation);
	}
	
	public void switchXBRLTab_Calculation(){
		
		switchTabXBRLSchema(XBRLTabSchema.Calculation);
	}
	
	public void switchXBRLTab_Formula(){
		
		switchTabXBRLSchema(XBRLTabSchema.Formula);
	}
	
	public void switchXBRLTab_Table(){
		
		switchTabXBRLSchema(XBRLTabSchema.Table);
	}
	
	
	public void switchXBRLTab_Taxonomies(){
		leftClickMid(findString("Taxonomies", MS_SHELL_DLG_FONT, null, true));	
	}
	
	public void switchXBRLTab_LinkBases(){
		
		leftClickMid(findString("Linkbases", MS_SHELL_DLG_FONT, null, true));
	}
	
		
	
	
	
	
	
	public void ConvertXMLtoFromXML() {
		leftClickMenuItem("Convert", "Convert XML to/from JSON");
	}

	public Rectangle findTreeWndInVS2010() {
		//This method was added only to solve some limitations encountered in VS2010 
		return null;
	}

	/******************************
	 *							  * 
	 *      C H A R T S           * 
	 * 							  *
	 ******************************/
	
	public Rectangle chartsPane() {
		
		Rectangle chart = findComponentName("Charts");
		
		if (chart == null){
			
			chart = activatePane(CHARTS);	
		}
		return chart;
	}
	
	//-------------------------------------------
	// ------------- Window ---------------------
	
	public Rectangle getSelectColumnsWindow() {
		
		return findComponentName("Select columns");	
	}
	
	public Rectangle getChangeTypeWindow() {
		
		return findComponentName("Change Type");	
	}
	
	public Rectangle getChangeAppearanceWindow() {
		
		return findComponentName("Change Appearance");	
	}
	
	public Rectangle getSelectDataWindow() {
		
		return findComponentName("Select Data");	
	}
	
	
	//--------------------------------------------------
	// --------- layout elementof window ----------------
	
	public Rectangle getChangeTypeChartType(){
		
		Rectangle ct = getChangeTypeWindow();
		
		// This rectangle contains the chart type (Pie, Bar, ...)
		return new Rectangle(ct.x, ct.y, 110, 240);

	}
	
	public Rectangle getChangeTypeChartSubType(){
		
		Rectangle ct = getChangeTypeWindow();
		
		// This rectangle contains the chart type (Pie Chart 2d, Bar Chart 3d, ...)
		return new Rectangle(ct.x+110, ct.y, 220, 240);
	}
	
	public Rectangle getChangeAppearance(){
		
		Rectangle ca = getChangeAppearanceWindow();
		return new Rectangle(ca.x, ca.y+25, 215, 500);
	}
	
	public Rectangle getSizesFrame(){
		
		Rectangle s = getChangeAppearanceWindow();
		return new Rectangle(s.x+110, s.y+25, 400, 330);
	}
	
	//---------------------------------
	//---------------------------------
	
	public void chartMenu(String windowName, String menu) {
		
		try {
			delay(600);
			assertWindow(windowName);
			
		} catch (ScriptMistakeException e) {
			 logger.finest("Window \"" + windowName +"\" not open yet...I try to open it");
			 
			 leftClickMid(findString(menu, chartsPane(), false));
		}
	
		delay(600);
		assertWindow(windowName);
		
	}

	public void newChart_setSourceXPath(String source) {
		
		chartMenu("Select columns", "New Chart");
		
		TextFieldOption t = new TextFieldOption("Source XPath", true, source, null, null, null, null, WINDOWS_DEFAULT_FONT);
		t.setY1(50);
		t.applyOption(this);

	}
		
		
	public void clickButton(String name){
		
		//leftClickString(name, WINDOWS_DEFAULT_FONT, Color.BLACK, getSelectColumnsWindow());
		try {
			//leftClickString(name, WINDOWS_DEFAULT_FONT);
			leftClickMid(findComponent(name, "Button", null));
		} catch (Exception e) {
			leftClickString(name, MS_SHELL_DLG_FONT);
		}
		
	}	
	public void doubleClickOnIcon(String iconPath){
		Rectangle hint = findImage(iconPath, null, false);
		doubleClickMid(hint);
	}
	
	public void leftClickButton(String name){
		leftClickMid(findComponent(name, "Button", null));
	}

	public void markAll(){
		
		clickButton("Mark All");
	}
	
	public void updateColumns(){
		
		clickButton("Update Columns");
		markAll();
	}

	public void newChart_setColumnSearchDepth(int depth) {
		
		chartMenu("Select columns", "New Chart");
		
		//Cannot use the DropDownOption class because doesnt manage correcly number as "1", "2",...
		//
		//DropDownOption d = new DropDownOption("Column search depth", false, ""+depth, null, null, null, null, WINDOWS_DEFAULT_FONT);
		//d.setCorrect(-250);
		//d.applyOption(this);
		
		Rectangle r = findString("Column search depth", getSelectColumnsWindow(), false);
		Point p = new Point(r.x+r.width+15, r.y);
		//logger.fine(">>>>>>>>>>Point: " + p);
		leftClick(p);
		
		delay(500);
		typeString(""+depth);
		delay(500);
		keyType(VK_ENTER);
		delay(1500);
	}

	public void newChart_firstColumn(String dropDownValue) {
		
		chartMenu("Select columns", "New Chart");
		
		DropDownOption d = new DropDownOption("First Column ( Category/X-Axis ):", true, dropDownValue, null, null, null, null, WINDOWS_DEFAULT_FONT);
		d.setCorrect(-250);
		d.applyOption(this);
	}
	
	public void newChart_insertXPath(String xpath){
		
		chartMenu("Select columns", "New Chart");
		
		clickButton("Insert XPath");
		delay(500);
		typeString(xpath);
		keyType(VK_ENTER);
		
		
		
	}

	public void newChart_findSeriesColumn(String... column) {

		chartMenu("Select columns", "New Chart");
		
		Rectangle c = findString("Series Columns", getSelectColumnsWindow(), false);
		
		//This is the "Series Columns" area
		Rectangle new_c = new Rectangle(c.x, c.y+40, c.width+300, 250);
		
		
		for (String string : column) {
				
			try {
				Rectangle obj = findString(string, DEFAULT_CONTENT_FONT, new_c, false);
				leftClick(obj.x-10, obj.y+5);
				//leftClickString(string, MS_SHELL_DLG_FONT, Color.BLACK, new_c);
				
			} catch (ImageNotFoundException e) {
				/*
				 * Note thar robot has problem to search and find long names in bold.
				 * Please use short words (max 4-5) and check in advance if can find it
				 */
				
				logger.fine("Maybe is an user XPath....I need to find with BOLD style");
				Rectangle obj = findString(string, DEFAULT_CONTENT_FONT_BOLD, new_c, false);
				leftClick(obj.x-10, obj.y+5);
				//leftClickString(string, MS_SHELL_DLG_FONT_BOLD, Color.BLACK, new_c);
				
			}
			delay(200);
		}		
		
		
	}

	public void changeTypeChart(CHART name, Object subname) {
		
		chartMenu("Change Type", "Change Type");
		
		leftClickString(name.toString().replace('_', ' '), DEFAULT_CONTENT_FONT, Color.BLACK, getChangeTypeChartType());
		delay(500);
		/**
		 * Fix for "value line chart" and "stacked area chart": it seems that the ImgageRecognize 
		 * creates a string a little bit different that the GUI (only for 1-2 px):
		 * the two exceptional cases will be handled with a GUI screenshot image 
		 */
		 if ((subname.toString().equals("Value_Line_Chart") || subname.toString().equals("Stacked_Area_Chart")) && !Settings.isWinXP()){
			 logger.finest("IS WINXP??????"+Settings.isWinXP());
			 leftClickImage(IOUtils.findFile("spy/res/Charts/chartsTypeString_" + subname.toString() + ".png").getAbsolutePath(), getChangeTypeChartSubType(), false);			 
		 }else{
			 
			 leftClickString(subname.toString().replace('_', ' '), DEFAULT_CONTENT_FONT, Color.BLACK, getChangeTypeChartSubType());
		 }
		delay(300);
		
	}

	public void changeAppearance(String type) {
		
		chartMenu("Change Appearance", "Change Appearance");
		delay(500);
		leftClickString(type, WINDOWS_DEFAULT_FONT, Color.BLACK, getChangeAppearance());
		delay(700);
		
	}
	
	
	

	private void setColorComboBox(File paletteIcon,  String name){	
		setColorComboBox(paletteIcon, name, "no_section", false, 60, MS_SHELL_DLG_FONT);
	}
	
	private void setColorComboBox(File paletteIcon,  String name, boolean textAbove){	
		setColorComboBox(paletteIcon, name, "no_section", textAbove, 60, MS_SHELL_DLG_FONT);
	}

	private void setColorComboBox(File paletteIcon,  String name, String section){
		setColorComboBox(paletteIcon, name, section, false, 60, MS_SHELL_DLG_FONT);
	}

	private void setColorComboBox(File paletteIcon,  String name, String section, Font secondFont){
		setColorComboBox(paletteIcon, name, section, false, 60, secondFont);
	}
	
	private void setColorComboBox(File paletteIcon,  String name, String section, int shift){	
		setColorComboBox(paletteIcon, name, section, false, shift, MS_SHELL_DLG_FONT);
	}
	
	private void setColorComboBox(File paletteIcon,  String name, String section, int shift, Font secondFont){
		setColorComboBox(paletteIcon, name, section, false, shift, secondFont);
	}
	
	private void setColorComboBox(File paletteIcon, String name, String section, boolean above, int shift, Font secondFontItem){
		TextFieldOption b = null;
		
		if (section.equalsIgnoreCase("no_section")) section=null;
		
		 b = new TextFieldOption(name, above, "", section, null, null, null, MS_SHELL_DLG_FONT);
		
		b.setX2(shift);
		b.applyOption(this, secondFontItem);//, MS_SHELL_DLG_FONT>>MS San Serif ; WINDOWS_DEFAULT_FONT>>Tahoma
		delay(500);
		
		leftClickString("Other color...", WINDOWS_DEFAULT_FONT, Color.BLACK, getChangeAppearanceWindow());
		delay(700);
		
		setColorsWindow(paletteIcon);

	}
	
	public void setColorsWindow(File paletteIcon){

		assertWindow("Colors");
		
		leftClickMid(findImage(paletteIcon.getAbsolutePath(), findComponentName("Colors"), false));
		delay(500);
		keyType(VK_ENTER);
		delay(500);
	}

	public void changeAppearance_General_Chart(String title, File backgroundColor, Boolean drawLegend, String backgroundGradient, File backgroundGradientColor, File ImageFilePath, String ImageFileType){
		
		changeAppearance("General");
		
		if (title!=null){
			
			TextFieldOption t = new TextFieldOption("Chart Title:", title, "Chart");
			t.applyOption(this);
			
		}
		if (backgroundColor!=null){
			
			setColorComboBox(backgroundColor, "Background color:", "Chart", 170, WINDOWS_DEFAULT_FONT);
			
		}
		if (drawLegend!=null){
			
			CheckboxOption l = new CheckboxOption("Draw Legend", drawLegend, "Chart");
			l.applyOption(this);
		}
		
		if (backgroundGradient!=null){
			
			DropDownOption bg = new DropDownOption("Background color:", false, backgroundGradient, "Chart", null, null, null, WINDOWS_DEFAULT_FONT);
			bg.setTwiceFontDropDownOption(MS_SHELL_DLG_FONT);
			bg.setFont(WINDOWS_DEFAULT_FONT);
			bg.applyOption(this);
		}
		
		if (backgroundGradientColor!= null){
			
			setColorComboBox(backgroundGradientColor, "Background color:", "Chart", 230, WINDOWS_DEFAULT_FONT);
		}
		
		if (ImageFilePath!=null){
			
			//TextFieldOption ifp = new TextFieldOption("Image File:", ImageFilePath.getAbsolutePath(), "Chart");
			//ifp.applyOption(this);
			
			TextFieldOption path = new TextFieldOption("Image File:", ImageFilePath.getAbsolutePath(), "Chart");
			path.setX2(100);
			path.applyOption(this, WINDOWS_DEFAULT_FONT);
		}
		
		if (ImageFileType!=null){
			
			DropDownOption ift = new DropDownOption("Image File:", false, ImageFileType, "Chart", null, null, null, WINDOWS_DEFAULT_FONT);
			ift.setTwiceFontDropDownOption(MS_SHELL_DLG_FONT);
			ift.setFont(WINDOWS_DEFAULT_FONT);
			ift.setX1(240);
			ift.applyOption(this);
			
		}
		
		delay(500);
		
		
	}

	public void changeAppearance_General_Plot(Boolean border, File borderColor, File backgroundColor, String backgroundGradient, File backgroundGradientColor, File ImageFilePath, String ImageFileType){
		
		changeAppearance("General");
		
		if (border!=null){
			
			//Unfortunally doesnt work in the classic way (using CheckboxOption class)
			//CheckboxOption b = new CheckboxOption("Border", border, "Plot");
			//b.applyOption(this);
			
			Rectangle bc = findString("Border color", MS_SHELL_DLG_FONT, getChangeAppearanceWindow(), false);
			leftClick(bc.x - 50, bc.y); 
			//I search "Border color" (that is very close to Border checkbox) and I just shift of 60 pixel left side click on Border checkbox element
			
			if (border){
				keyType(VK_PLUS);
				
			}else{
				keyType(VK_MINUS);
			}

		}
		if (borderColor!=null && border){
			
			setColorComboBox(borderColor, "Border color:", "Plot");
		}
		if (backgroundColor!=null){
			
			setColorComboBox(backgroundColor, "Background color:", "Plot", 170, WINDOWS_DEFAULT_FONT);
		}
		
		if (backgroundGradient!=null){
			
			DropDownOption bg = new DropDownOption("Background color:", false, backgroundGradient, "Plot", null, null, null, WINDOWS_DEFAULT_FONT);
			bg.setTwiceFontDropDownOption(MS_SHELL_DLG_FONT);
			bg.setFont(WINDOWS_DEFAULT_FONT);
			bg.applyOption(this);
		}
		
		if (backgroundGradientColor!= null){
			
			setColorComboBox(backgroundGradientColor, "Background color:", "Plot", 230, WINDOWS_DEFAULT_FONT);
		}
		
		if (ImageFilePath!=null){
				
			TextFieldOption path = new TextFieldOption("Image File:", ImageFilePath.getAbsolutePath(), "Plot");
			path.setX2(100);
			path.applyOption(this, WINDOWS_DEFAULT_FONT);
		}
		
		if (ImageFileType!=null){
			
			DropDownOption ift = new DropDownOption("Image File:", false, ImageFileType, "Plot", null, null, null, WINDOWS_DEFAULT_FONT);
			ift.setTwiceFontDropDownOption(MS_SHELL_DLG_FONT);
			ift.setFont(WINDOWS_DEFAULT_FONT);
			ift.setX1(240);
			ift.applyOption(this);
			
		}

		
		
		delay(500);
		
	}
	
	public void changeAppearance_General_Orientation(Boolean drawXY){
		
		changeAppearance("General");
		
		if (drawXY!=null){
			
			CheckboxOption dxy = new CheckboxOption("Draw X and Y exchanged", drawXY, "Orientation");
			dxy.applyOption(this);
			
		}
		
	}

	private void clickLoadSave(String menu, File inOutFile){
		
		chartMenu("Change Appearance", "Change Appearance");
		
		leftClickString("Load", MS_SHELL_DLG_FONT, Color.BLACK, getChangeAppearance());
		delay(1000);
		leftClickString(menu, WINDOWS_DEFAULT_FONT, Color.BLACK, getChangeAppearance());
		
		if(menu.equals("Set to dafault")){
			
			//escapeGeneralDialogs("Are you sure to set the appearance to the default values?");
			escapeDialog("Are you sure to set the appearance to the default values?", VK_Y);
			delay(500);
			clickButton("Apply");
			delay(500);
			
		}else if (menu.equals("Load from file...")){
			
			delay(1000);
			assertWindow("Open");
	
			typeStringEnter((inOutFile.getAbsolutePath()));
			delay(4000);

			
		}else if (menu.equals("Save to file...")){
			
			delay(1000);
			assertWindow("Save As");
			
			//escapeGeneralDialogs("Waiting while escaping file dialogs");
			typeStringEnter((inOutFile.getAbsolutePath()));
			delay(5000);
			
		}
		
		
	}
	
	public void setToDefault() {
		
		clickLoadSave("Set to dafault",null);
	}
	
	public void loadFromFile(File inputFileName) {
		
		clickLoadSave("Load from file...",inputFileName);
		delay(3000);
	}
	
	public void saveToFile(File outputFileName) {
		
		clickLoadSave("Save to file...",outputFileName);
	}
	
	

	public void changeAppearance_Pie(String startAngle, Boolean drawOutline, 
				File drawOutlineFile, Boolean clockwise, Boolean drawHighlight,
				Boolean drawDropshadow, File drawDropshadowFile, String transparency, String tilt) {
		
		changeAppearance("Pie");
		
		if (startAngle!=null){
			
			TextFieldOption sa = new TextFieldOption("Start Angle:", startAngle);
			sa.applyOption(this);	
		}
		if (drawOutline!=null){
			
			CheckboxOption da = new CheckboxOption("Draw Outline", drawOutline);
			da.applyOption(this);	
		}
		if (drawOutlineFile!=null){
			
			setColorComboBox(drawOutlineFile, "Draw Outline:", "no_section");	//throws Exception -->??? 
		}
		if (clockwise!=null){

			CheckboxOption c = new CheckboxOption("Clockwise", clockwise);
			c.applyOption(this);
		}
		if (drawHighlight!=null){
			
			CheckboxOption c = new CheckboxOption("Draw Highlight", drawHighlight);
			c.applyOption(this);
		}
		// for 3D Pie 
		if (drawDropshadow!=null){
			
			CheckboxOption dd = new CheckboxOption("Draw Dropshadow", drawDropshadow);
			dd.applyOption(this);
		}
		if (drawDropshadowFile!=null){
			
			setColorComboBox(drawDropshadowFile, "Draw Dropshadow");	//throws Exception -->??? 
		}
		if (transparency!=null){
			
			TextFieldOption t = new TextFieldOption("Transparency:", transparency);
			t.applyOption(this);	

		}
		if (tilt!=null){
			
			/*
			 * Use of TextFieldOption is not recomended because method removeTextfieldText()
			 * (reiteration of 200 Delete key button) create a freezing of GUI on this field 
			 */
			//TextFieldOption ti = new TextFieldOption("3d Tilt:", tilt);
			//ti.setX2(70);
			//ti.applyOption(this);
			
			Rectangle r = findString("3d Tilt:", MS_SHELL_DLG_FONT);
			leftClick(r.x + r.width + 60, r.y + 5);
			delay(500);
			keyTypeCtrl(VK_A);
			delay(800);
			keyType(VK_DELETE);
			delay(1000);
			typeString(tilt);
		}
		
		
		
		
		
	}

	public void changeAppearance_Pie_Label(Boolean showLabel, Boolean AddValue, Boolean AddPercentage,
			Integer decimalDigit) {
		
		changeAppearance("Pie");
		
		if (showLabel!=null){

			CheckboxOption sl = new CheckboxOption("Show Labels", showLabel, "Labels");
			sl.applyOption(this);
		}
		if (AddValue!=null){

			CheckboxOption av = new CheckboxOption("Add Value to Labels", AddValue, "Labels");
			av.applyOption(this);
		}
		if (AddPercentage!=null){
			
			CheckboxOption ap = new CheckboxOption("Add Percent to Labels", AddPercentage, "Labels");
			ap.applyOption(this);
		}
		if (decimalDigit!=null){
			
			/*
			 * Could not work propertly when decimalDigit=1
			 */
			
			DropDownOption dd = new DropDownOption("Decimal Digits", false, decimalDigit.toString(), "Labels");
			//dd.setCorrect(-250);
			dd.applyOption(this);

		}
				
		
	}
	
	public void changeAppearance_Bar(Boolean drawOutline, File drawOutlineFile, Boolean drawDropshadow, File drawDropshadowFile, String fillStyle){
		
		changeAppearance("Bar");
		
		if(drawOutline!=null){
			
			CheckboxOption dO = new CheckboxOption("Draw Outline", drawOutline);
			dO.applyOption(this);

		}
		if(drawOutlineFile!=null){
			
			setColorComboBox(drawOutlineFile, "Draw Outline", "no_section");
		}
		if(drawDropshadow!=null){

			CheckboxOption dd = new CheckboxOption("Draw Dropshadow", drawDropshadow);
			dd.applyOption(this);

		}
		if(drawDropshadowFile!=null){
		
			setColorComboBox(drawDropshadowFile, "Draw Dropshadow", "no_section");
		}
		
		if (fillStyle != null){
			
			DropDownOption fs = new DropDownOption("Fill style", fillStyle);
			fs.applyOption(this);
		}
	}

	public void changeAppearance_Line(Boolean filled, Boolean outlined, Boolean slashed, Boolean backslashed) {

		changeAppearance("Line");
		
		if(filled!=null){
			
			CheckboxOption f = new CheckboxOption("Filled", filled, "Draw Connection Shapes");
			f.applyOption(this);
		}
		if(outlined!=null){

			CheckboxOption o = new CheckboxOption("Outlined", outlined, "Draw Connection Shapes");
			o.applyOption(this);
		}
		if(slashed!=null){
			
			CheckboxOption s = new CheckboxOption("Slashed", slashed, "Draw Connection Shapes");
			s.applyOption(this);			
		}
		if(backslashed!=null){
			
			CheckboxOption s = new CheckboxOption("Backslashed", backslashed, "Draw Connection Shapes");
			s.applyOption(this);			
			
		}
		
	}

	public void changeAppearance_Area(String transparency, Boolean drawOutline, File drawOutlineFile) {
		
		changeAppearance("Area");
		
		if(transparency!=null){
			
			TextFieldOption t = new TextFieldOption("Transparency:", transparency);
			t.setX2(70);
			t.applyOption(this);
		}
		if(drawOutline!=null){

			CheckboxOption d = new CheckboxOption("Draw Outline", drawOutline);
			d.applyOption(this);			
		}
		if(drawOutlineFile!=null){
			
			setColorComboBox(drawOutlineFile, "Draw Outline", "no_section");
		}
	}
	
	public void changeAppearance_Candlestick(Boolean unfilled, File filledColor, Boolean useSeries, File useSeriesColor){
		
		changeAppearance("Candlestick");
		
		if (unfilled!=null){
			
			RadioOption u = new RadioOption("Unfilled", "Fill Color when Close > Open");
			u.applyOption(this);
		}
		
		if (filledColor!=null){
			
			RadioOption u2 = new RadioOption("Unfilled", "Fill Color when Close > Open");
			u2.applyOption(this);
			delay(250);
			keyType(VK_DOWN);
			
			setColorComboBox(filledColor, "Unfilled", true);
			
		}
		
		if (useSeries!=null){
			
			RadioOption s = new RadioOption("Use Series color", "Fill Color when Open > Close");
			s.applyOption(this);
		}
		
		if (useSeriesColor!=null){
			
			RadioOption s2 = new RadioOption("Use Series color", "Fill Color when Open > Close");
			s2.applyOption(this);
			delay(250);
			keyType(VK_DOWN);
			
			setColorComboBox(useSeriesColor, "Use Series color", true);
			
		}
		
	}

	public void changeAppearance_Gauge(String startAngles, String sweepAngles,
			String startValueRange, String endValueRange, String intervalMajorTicks,
			File colorMajorTicksFile, String intervalMinorTicks,
			File colorMinorTicksFile, File dialFillColors,
			File borderColors, File needleColors,
			File needleBaseColors) {
		
		changeAppearance("Gauge");
		
		if(startAngles!=null){
			
			TextFieldOption sa = new TextFieldOption("Start:", startAngles, "Angles");
			sa.setX2(70);
			sa.applyOption(this);
		}
		if(sweepAngles!=null){

			TextFieldOption sw = new TextFieldOption("Sweep:", sweepAngles, "Angles");
			sw.setX2(70);
			sw.applyOption(this);
		}
		if(startValueRange!=null){
			
			TextFieldOption svr = new TextFieldOption("Start:", startValueRange, "Value Range");
			svr.setX2(70);
			svr.applyOption(this);
		}
		if(endValueRange!=null){
			
			TextFieldOption evr = new TextFieldOption("End:", endValueRange, "Value Range");
			evr.setX2(70);
			evr.applyOption(this);
		}
		if(intervalMajorTicks!=null){
			
			TextFieldOption imt = new TextFieldOption("Interval:", intervalMajorTicks, "Major Ticks");
			imt.setX2(70);
			imt.applyOption(this);			
		}
		if(colorMajorTicksFile!=null){
			
			setColorComboBox(colorMajorTicksFile, "Color:", "Major Ticks");
		}
		if(intervalMinorTicks!=null){
			
			TextFieldOption imin = new TextFieldOption("Interval:", intervalMinorTicks, "Minor Ticks");
			imin.setX2(70);
			imin.applyOption(this);			
		}
		if(colorMinorTicksFile!=null){
		
			setColorComboBox(colorMinorTicksFile, "Color:", "Minor Ticks");
		}
		if(dialFillColors!=null){
			
			setColorComboBox(dialFillColors, "Dial fill:", "Colors");
		}
		if(borderColors!=null){
		
			setColorComboBox(borderColors, "Border:", "Colors");
		}
		if(needleColors!=null){
			
			setColorComboBox(needleColors, "Needle:", "Colors");
		}
		if(needleBaseColors!=null){
			
			setColorComboBox(needleBaseColors, "Needle Base:", "Colors", MS_SHELL_DLG_FONT);
		}
		
		
		
	}

	
	public void colorSchema(String subsequent, String schema, String op, File color) {
		
		changeAppearance("Color Schema");
		
		if (subsequent != null){
			
			RadioOption sub = new RadioOption(subsequent);
			sub.applyOption(this);
			
		}
		
		DropDownOption s = new DropDownOption("Schema", schema);
		//dd.setCorrect(-250);
		s.setX1(70);
		s.applyOption(this);
		
		if(op != null && op.equals("Add")){
			
			clickButton(op);
			delay(300);
			setColorsWindow(color);
			
		}else if (color != null && op.equals("Delete")){
		
			leftClickMid(findImage(color.getAbsolutePath(), getChangeAppearanceWindow(), false));
			clickButton(op);
			
		}
		delay(500);	

	}
	
	public void colorSchema(String schemaName, String op, File color) {
		
		colorSchema(null, schemaName, op, color);
	}

	public void changeAppearance_Sizes(Sizes[] elements) {
		
		changeAppearance("Sizes");
		
		for (int i = 0; i < elements.length; i++) {

			if (!Settings.isWinXP()){
				if (elements[i].name.startsWith("X-"))			
					leftClickImage(X_AXIS_SIZES_ICON.getAbsolutePath(), getSizesFrame(), false);
				else if (elements[i].name.startsWith("Y-"))
					leftClickImage(Y_AXIS_SIZES_ICON.getAbsolutePath(), getSizesFrame(), false);
				delay(500);
				//shift to down
			
				if (elements[i].name.contains("-Axis to Axis Label")){
					keyType(VK_DOWN);
				}else if (elements[i].name.contains("-Axis to Plot")){
					keyType(VK_DOWN);
					delay(100);
					keyType(VK_DOWN);
				}else if (elements[i].name.contains("-Axis Tick Size")){
					keyType(VK_DOWN);
					delay(100);
					keyType(VK_DOWN);
					delay(100);
					keyType(VK_DOWN);
				}else{
					leftClickMid(findString(elements[i].name, DEFAULT_CONTENT_FONT, Color.white, new Color (128, 128, 128), getSizesFrame(), false));
				}
				
			
			}else{
				//only for WinXp
				leftClickMid(findString(elements[i].name, DEFAULT_CONTENT_FONT, Color.white, new Color (128, 128, 128), getSizesFrame(), false));
			}
			//shift to right and type the value
			keyType(VK_RIGHT);
			typeString(elements[i].value);
			keyType(VK_ENTER);
			delay(500);
			//shift to right and type the dimensions
			keyType(VK_RIGHT);
			typeString(elements[i].dim);
			keyType(VK_ENTER);
			delay(500);
			
		}
		
		
	}

	public void changeAppearance_Xaxis(String label,
			File lineColorFile, Boolean showGridlines, File showGridlinesFile,
			Boolean showTicks, Boolean showValues, String axisPosition, String category,
			String range, Boolean includeZero, String min, String max, String interval, String manual) {
		
			changeAppearance("X ( Category");
			/*
			* "X ( Category" should be changed to an uniformed "X-Axis"
			*/
		
			changeAppearance_XYZaxis(label, lineColorFile, showGridlines, showGridlinesFile, showTicks, showValues, axisPosition, category, range, includeZero, min, max, interval, manual);

	}

	
	public void changeAppearance_Yaxis(String label,
			File lineColorFile, Boolean showGridlines, File showGridlinesFile,
			Boolean showTicks, Boolean showValues, String axisPosition, String category,
			String range, Boolean includeZero, String min, String max, String interval, String manual) {
		
			changeAppearance("Y ( Value )");
			/*
			 * "Y ( Value )" should be changed to an uniformed "Y-Axis"
			 */

			changeAppearance_XYZaxis(label, lineColorFile, showGridlines, showGridlinesFile, showTicks, showValues, axisPosition, category, range, includeZero, min, max, interval, manual);
	}
	
	public void changeAppearance_Zaxis(String label,
			File lineColorFile, Boolean showTicks, Boolean showValues) {
		
			changeAppearance("Z ( Series )");
			/*
			* "Z ( Series )" should be changed to an uniformed "Z-Axis"
			*/
		
			changeAppearance_XYZaxis(label, lineColorFile, null, null, showTicks, showValues, null, null, null, null, null, null, null, null);

	}

	
	
	public void changeAppearance_XYZaxis(String label,
			File lineColorFile, Boolean showGridlines, File showGridlinesFile,
			Boolean showTicks, Boolean showValues, String axisPosition, String category,
			String range, Boolean includeZero, String min, String max, String interval, String manual) {

		
		if(label!=null){
			
			TextFieldOption l = new TextFieldOption("Label", true, label, "Label", null, null, null, MS_SHELL_DLG_FONT);
			l.applyOption(this);
		}
		if(lineColorFile!=null){
			
			setColorComboBox(lineColorFile, "Line", "Line", true, 60, MS_SHELL_DLG_FONT);
		}
		if(showGridlines!=null){
		
			CheckboxOption g = new CheckboxOption("Show Gridlines", showGridlines, "Gridlines");
			g.applyOption(this);			

		}
		if(showGridlinesFile!=null){
			
			setColorComboBox(showGridlinesFile, "Show Gridlines", "Gridlines");
		}
		if(showTicks!=null){
			
			CheckboxOption t = new CheckboxOption("Show Ticks", showTicks, "Tick Drawing");
			t.applyOption(this);			
			
		}
		if(showValues!=null){

			CheckboxOption v = new CheckboxOption("Show Values", showValues, "Tick Drawing");
			v.applyOption(this);			

		}
		if(axisPosition!=null){
				
			DropDownOption x = new DropDownOption("Axis Position", true, axisPosition, "Axis Position", null, null, null, MS_SHELL_DLG_FONT);
			//x.setCorrect(-250);
			x.applyOption(this);
		}
		if(category!=null){
			
			TextFieldOption l = new TextFieldOption("At Value / On Category Number::", category, "Axis Position");
			//l.setX2(70);
			l.applyOption(this);
		}
		
		//Implementation for Line chart
		//----------------------------
		if(range!=null){
			
			RadioOption r = new RadioOption(range, "Range", null, null, null, MS_SHELL_DLG_FONT);
			r.applyOption(this);
		}
		if(includeZero!=null){
			
			CheckboxOption iz = new CheckboxOption("Include Zero", includeZero, "Range");
			iz.applyOption(this);
		}
		if(min!=null){
		
			TextFieldOption m = new TextFieldOption("Min:", min, "Range");
			m.applyOption(this);
		}
		if(max!=null){
			
			TextFieldOption M = new TextFieldOption("Max:", max, "Range");
			M.applyOption(this);
		}
		if(interval!=null){
			
			RadioOption i = new RadioOption(interval, "Tick Interval", null, null, null, MS_SHELL_DLG_FONT);
			i.applyOption(this);
		}
		if (manual!=null){
			
			TextFieldOption m = new TextFieldOption("Manual", manual, "Tick Interval");
			m.applyOption(this);
		}
		
	
	}

	public void changeAppearance_3DAngles(String fieldofView, String tilt,
			String rotation, Boolean automatic) {
			
			changeAppearance("3d Angles");
			
			if(fieldofView!=null){
				
				
				/*
				 * Use of TextFieldOption is not recomended because method removeTextfieldText()
				 * (reiteration of 200 Delete key button) create a freezing of GUI on this field 
				 */
				//TextFieldOption ti = new TextFieldOption("3d Tilt:", tilt);
				//ti.setX2(70);
				//ti.applyOption(this);
				
				Rectangle r = findString("Field of View:", MS_SHELL_DLG_FONT);
				leftClick(r.x + r.width + 60, r.y + 5);
				delay(500);
				deleteAllCharacter(3);
				//keyTypeCtrl(VK_A);
				//delay(800);
				//keyType(VK_DELETE);
				//delay(1000);
				typeString(fieldofView);
				
				//TextFieldOption fow = new TextFieldOption("Field of View:", fieldofView, "Camera");
				//fow.applyOption(this);
			}
			if(tilt!=null){

				
				Rectangle r = findString("Tilt:", MS_SHELL_DLG_FONT);
				leftClick(r.x + r.width + 60, r.y + 5);
				delay(500);
				deleteAllCharacter(3);
				//keyTypeCtrl(VK_A);
				//delay(800);
				//keyType(VK_DELETE);
				//delay(1000);
				typeString(tilt);
				
				//TextFieldOption t = new TextFieldOption("Tilt:", tilt, "Camera");
				//t.setX2(75);
				//t.applyOption(this);

			}
			if(rotation!=null){
				
				Rectangle r = findString("Rotation:", MS_SHELL_DLG_FONT);
				leftClick(r.x + r.width + 60, r.y + 5);
				delay(500);
				deleteAllCharacter(3);
				//keyTypeCtrl(VK_A);
				//delay(800);
				//keyType(VK_DELETE);
				//delay(1000);
				typeString(rotation);
				
				//TextFieldOption r = new TextFieldOption("Rotation:", rotation, "Camera");
				//r.setX2(45);
				//r.applyOption(this);	
			}
			if(automatic!=null){
				
				CheckboxOption a = new CheckboxOption("Automatic Chart Axis Size", automatic);
				a.applyOption(this);
			}
			
	}

	private void deleteAllCharacter(int iteration) {
		
		keyType(VK_END);
		for (int j = 0; j < 3; j++) {
			
			delay(500);
			keyType(VK_BACK_SPACE);
		}
		
	}

	public void selectDataPie(String labels, String values) {
		
		chartMenu("Select Data", "Select Data");
			
		TextFieldOption l = new TextFieldOption("Labels:", true, labels, "Axis Values", null, null, null, WINDOWS_DEFAULT_FONT);
		l.applyOption(this);
		
		/*
		 * Cannot manage to find the field "Values:" because the robot goes in  
		 * conflict with the section name , "Axis Values". 
		 */
			
		//TextFieldOption l = new TextFieldOption("Values:", true, values, "Axis Values", null, null, null, WINDOWS_DEFAULT_FONT);
		//r.setX2(45);
		//.applyOption(this);
			
		delay(500);
		keyType(VK_TAB);
		delay(200);
		typeString(values);
			
	}
	
	public void selectData(String name, String newSeries, String deleteSeries, String xdef, String y) {
		
		selectData(name, newSeries, deleteSeries, xdef, "two_field_case", null);
	}
	
	public void selectData(String currentValue) {
		
		chartMenu("Select Data", "Select Data");
		
		if(currentValue!=null){
			
			TextFieldOption l = new TextFieldOption("Current Value", true, currentValue, "Current Value", null, null, null, WINDOWS_DEFAULT_FONT);
			l.applyOption(this);

		}
		
	}
	
	
	public void selectData(String seriesName, String newSeries, String deleteSeries, String xdef, String y, String xsel ) {
		
		chartMenu("Select Data", "Select Data");
		
		if(seriesName!=null || deleteSeries!=null){
			
			//TextFieldOption m = new TextFieldOption(name, false, "", "Series", null, null, null, WINDOWS_DEFAULT_FONT );
			//m.applyOption(this);
			
			leftClickMid(findString(seriesName, DEFAULT_CONTENT_FONT, getSelectDataWindow(), false));

		}
		if(newSeries!=null){
			
			leftClickMid(findString("Add", MS_SHELL_DLG_FONT, getSelectDataWindow(), false));
			delay(600);
			typeString(newSeries);
			keyType(VK_ENTER);
			delay(600);
		}
		if(deleteSeries!=null){
			
			leftClickMid(findString("Delete", MS_SHELL_DLG_FONT, getSelectDataWindow(), false));
			delay(600);
			
		}
		if(xdef!=null){
			
			String fieldName = "";
			if (y.equals("two_field_case")) fieldName="X ( all Series ):";
			else fieldName = "X ( default Series ):";
			
			TextFieldOption X = new TextFieldOption(fieldName, true, xdef, "Axis Values", null, null, null, WINDOWS_DEFAULT_FONT);
			//X.setX2(45);
			X.applyOption(this);

		}
		if(y!=null){
			
			if (y.equals("two_field_case")){
				TextFieldOption Y = new TextFieldOption("Y ( selected series ):", true, y, "Axis Values", null, null, null, WINDOWS_DEFAULT_FONT);
				//Y.setX2(45);
				Y.applyOption(this);
			}else{
				
				leftClickMid(findString(seriesName, MS_SHELL_DLG_FONT, getSelectDataWindow(), false));
				
				for (int i = 0; i < 5; i++) {
					keyType(VK_TAB);
					delay(500);
				}
				typeString(y);
			}
						
		}
		if(xsel!=null){
			
			TextFieldOption X2 = new TextFieldOption("X ( selected series ):", true, xsel, "Axis Values", null, null, null, WINDOWS_DEFAULT_FONT);
			//X2.setX2(45);
			X2.applyOption(this);
			
			
		}
		
	}

	public void renameSeries(String oldname, String newname) {
		
		chartMenu("Select Data", "Select Data");
		
		leftClickMid(findString(oldname, DEFAULT_CONTENT_FONT, getSelectDataWindow(), false));
		delay(300);
		keyType(VK_ENTER);
		delay(800);
		keyType(VK_DELETE);
		delay(300);
		typeString(newname);
		delay(300);
	}

	
	private void exportChart(String export) {
		
		leftClickMid(findString("Export", chartsPane(), false));
		leftClickMid(findString(export, chartsPane(), true));
		
	}
	
	public void overlaysChart(String command) {
		
		leftClickMid(findString("Overlays", chartsPane(), false));
		leftClickMid(findString(command, chartsPane(), true));
		
	}
	
	public void saveChartInFile(String horizontal, String vertical, File filename) {
		
		exportChart("Save chart in file...");
		delay(800);
		assertWindow("Image Size");
		
		if (horizontal!= null && horizontal!= null){
			
			TextFieldOption h = new TextFieldOption("Horizontal pixels", false, horizontal, null, null, null, null, WINDOWS_DEFAULT_FONT);
			h.applyOption(this);

			TextFieldOption v = new TextFieldOption("Vertical pixels", false, vertical, null, null, null, null, WINDOWS_DEFAULT_FONT);
			v.applyOption(this);
			
			clickButton("OK");
			
			delay(800);
			assertWindow("Save As");
			
			typeFileName(filename.getAbsolutePath());
			delay(5000);
		}	
		
	}
	
	public void setChartSize(int widht, int height){
		activatePane(SpyRobot.CHARTS);
		delay(200);
		setPaneSize(SpyRobot.CHARTS, widht, height);
	}

	// END OF CHARTS
	//**********************
	
	public void generateAnHTMLDocument(File outputFile) {
		
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "Generate an HTML document");
		
		assertWindow("Generate a document from the PXF file");
		typeStringEnter(outputFile.getAbsolutePath());
		
		delay(4000);
	}

	public void generateAnRTFDocument(File outputFile) {
	
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "Generate an RTF document");
		assertWindow("Generate a document from the PXF file");
		keyType(VK_ESCAPE);
	}

	public void generateAPDFDocument(File outputFile) {
		
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "Generate a PDF document");
		assertWindow("Generate a document from the PXF file");
		keyType(VK_ESCAPE);
	}

	public void generateADOCXDocument(File outputFile) {
		
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "Generate a Word 2007+ document");
		assertWindow("Generate a document from the PXF file");
		keyType(VK_ESCAPE);
	}

	public void trustedLocation(){
		
		leftClickMenuItem("Authentic", "Trusted Locations...");
		delay(400);
		assertWindow("Trusted Locations");
	}
	
	public void deleteTrustedPath() {
		
		setTrustedLocations_Only();
		
		Rectangle trustedRec = findComponentClass("Trusted Locations");
		Rectangle remove = null;
		
		try {
			
			remove=this.findComponent("Remove", "Button", trustedRec);
			
			while (remove!=null) {
				logger.fine("WHILE>>>>>"+ remove);
				remove=this.findComponent("Remove", "Button", trustedRec);
				
				leftClickMid(remove);
				delay(1000);
			}
			
			
			
			
		} catch (Exception e) {
			logger.fine("Did not find any button labeled with Remove. No trusted path are available. Reason:" + e.toString());
			
		}
		
	}
	
	public void addTrustedPath(String path) {
		
		setTrustedLocations_Only();
		
		Rectangle trustedRec = findComponentClass("Trusted Locations");
		
		leftClickMid(findComponent("Add", "Button", trustedRec));
		delay(500);
		assertWindow("Browse for Folder");
		
		Rectangle browseFolder = findComponentName("Browse for Folder");
		
		String[] folders = path.split("/");
		
		logger.fine("Path to search>>>>>>=" + folders);
	    //searchAndScroll(folders, browseFolder, VK_PLUS);
		scrollPath(folders, browseFolder);
		
		delay(800);
		
		leftClickMid(findComponent("OK", "Button", browseFolder));
	}

	private void searchAndScroll(String[] name, Rectangle area, int action) {
		
		double sc =0;
		int i     =0;
		Rectangle temp = null;	
		
		while(sc<1){
			
			scrollWindow(area, sc);
		
		   	try {
		   		while(i < name.length){
		   			
		   			temp = findString(name[i], WINDOWS_DEFAULT_FONT, area, false);
		   			
		   			if (temp != null) { 
						leftClickMid(temp);
						delay(1000);
						//keyType(KeyEvent.VK_PLUS);
						//logger.fine("HINT PRIMA>>>>>" + temp);
						Rectangle hint = new Rectangle(temp.x-250, temp.y-5, temp.width+250, temp.height+15);
						//logger.fine("HINT DOPO>>>>>" + hint);
						leftClickMid(findImage(GUI_AUTOMATION_EXPAND_ICON.getAbsolutePath(), hint, false));
						//logger.fine("element " + i + " found with name " + name[i] + " in scroll" + sc + "name lungh=" + name.length);
						i++;
						sc-= 0.10;
						delay(3000);
					}//if
					
				}//while i
		   		
			} catch (Exception e) {
				logger.finer(">>>String not found. Following to search..temp=" + temp);
				sc += 0.10;
				logger.fine("scroll incremented to " + sc);
			}
			
			if (i==name.length) sc=1; //just to exit
	
		}//while sc
		
		
	}
	
	private void scrollPath(String[] name, Rectangle area) {
		
		int i     =0;
		Rectangle temp = null;	
		int trial = 0; 
		
		try {
		    while(i < name.length && trial < 20){
	   			
		   		try {
		   			temp = findString(name[i], WINDOWS_DEFAULT_FONT, area, false);
				
		   		} catch (Exception e) {
					logger.finer(">>>String not found. Following to search..temp=" + temp);
					temp=null;
				}
		    	
		   			
		   		if (temp != null) { 
					leftClickMid(temp);
					delay(1000);
					//keyType(KeyEvent.VK_PLUS);
					//logger.fine("HINT PRIMA>>>>>" + temp);
					Rectangle hint = new Rectangle(temp.x-250, temp.y-5, temp.width+250, temp.height+15);
					//logger.fine("HINT DOPO>>>>>" + hint);
					leftClickMid(findImage(GUI_AUTOMATION_EXPAND_ICON.getAbsolutePath(), hint, false));
					//logger.fine("element " + i + " found with name " + name[i] + " in scroll" + sc + "name lungh=" + name.length);
					i++;
					trial=0;
					delay(3000);
				}else{
					
					keyType(VK_PAGE_DOWN);
					trial++;
					if (trial > 20) throw new ScriptMistakeException("Element of path \"" + name[i] + "\" not found on Browse for Folder window. The full path cannot be added to the Trusted Location");				}
					
			}//while i

		} catch (Exception e) {
			logger.finer("Full path should be found (last expand Icon cannot be found): OK, I exit...");
		}	
		
	
		
		
	}
	
	

	public void setTrustedLocations_Always(){
		
		RadioOption t = new RadioOption("Always run Authentic scripts", null, null, null, null, WINDOWS_DEFAULT_FONT);
		t.applyOption(this);
	}

	public void setTrustedLocations_Never(){
		
		RadioOption t = new RadioOption("Never run Authentic scripts", null, null, null, null, WINDOWS_DEFAULT_FONT);
		t.applyOption(this);
	}
	
	public void setTrustedLocations_Only(){
		
		RadioOption t = new RadioOption("Only run Authentic scripts from trusted locations", null, null, null, null, WINDOWS_DEFAULT_FONT);
		t.applyOption(this);
	}

	public void openEpubPreview() {
		leftClickMid(findString("Preview", WINDOWS_DEFAULT_FONT_BOLD, Color.BLACK));
		delay(3500);
	}

	//RichEdit methods
	public void toggleBold() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "RichEdit", "Toogle Bold");
		
	}

	public void toggleItalic() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "RichEdit", "Toogle Italic");
		
	}

	public void toggleUnderline() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "RichEdit", "Toogle Underline");
		
	}

	public void toggleStrikeThrough() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "RichEdit", "Toogle Strikethrough");
		
	}

	public void foregroundColor(File paletteIcon) {
		
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "RichEdit", "Foreground Color");
		setColorsWindow(paletteIcon);
		
	}

	public void backgroundColor(File paletteIcon) {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "RichEdit", "Background Color");
		setColorsWindow(paletteIcon);
		
	}

	public void alignLeft() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "RichEdit", "Align Left");
		
	}

	public void alignCenter() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "RichEdit", "Center");
		
	}

	public void alignRight() {
		leftClickMenuItem(getAuthenticMenuHolder(),"Authentic", "RichEdit", "Align Right");
		
	}

	public void escapeUnescapeXMLCharacter(File textToEscapeIcon, String escapeUnescape ) {
		rightClickImage(textToEscapeIcon.getAbsolutePath());
		
		Rectangle res = findString("Character Escaping", WINDOWS_DEFAULT_FONT, null, false);
		
		if (res != null)
			leftClickMid(res);
			
			leftClickMid(findString(escapeUnescape));
			delay(2000);
				
	}

	public void escapeXMLCharacter(File textToEscapeIcon){
		escapeUnescapeXMLCharacter(textToEscapeIcon, "Escape XML Character");
		
	}
	
	public void unescapeXMLCharacter(File textToEscapeIcon){
		escapeUnescapeXMLCharacter(textToEscapeIcon, "Unescape XML Character");
		
	}




	
	/**
	 * Works only for default setting
	 * @param limit
	 * @param sort
	 */
	public void xbrlFiltr(String limit, String sort) {
		leftClickOnString("Show All Files", DEFAULT_CONTENT_FONT);
		delay(1000);
		mouseMove(10, 10);
		leftClickOnString(limit, DEFAULT_CONTENT_FONT);
		delay(2000);
		leftClickOnString("Unsorted", DEFAULT_CONTENT_FONT);
		delay(2000);
		leftClickOnString(sort, DEFAULT_CONTENT_FONT);
		delay(2000);
	}
	
	public void XbrlAddFormulaElement(String xbrlNewElementIco, String...element){
		leftClickImage(xbrlNewElementIco);
		for (int i = 0; i<element.length; i++)
			leftClickOnString(element[i], WINDOWS_DEFAULT_FONT);
	}

	public void findFormulaComponentById(String formula) {
		leftClickMenuItem("XBRL", "Find Formula Component By Id");
		
		assertWindow("Find Formula Component By Id");
		typeStringEnter(formula);
		delay(300);
	}

	//NEXT Line focus
	//Will search the arrow down to focus to the next Message/XPath/FindInFile string
	public void NextLineXPath() {
		
		NextLine(XPATH, 1);
		
	}
	
	public void NextLineXPath(int iter) {
		
		NextLine(XPATH, iter);
		
	}

	private void NextLine(Pane p, int i) {
		
		Rectangle r = activatePane(p);
		
		Rectangle focusOn = findImage(DOWN_ARROW.getAbsolutePath(), r, false);
		//logger.finest("focusOn:"+focusOn);
		if (focusOn != null) { 				 	
			for (int j = 1; j <= i; j++) {
				leftClickMid(focusOn);
				//logger.finest("focusOn:"+focusOn+ ":click");
				delay(300);
			}
				
			
			
		}
	}
	
	
	public void  addRaptorXMLServer(String name, String hostname, String port){
		
		
		Rectangle r = findComponentName("RaptorXML Server Options");

		Rectangle plusIcon = findImage(ADD_RAPTOR_SERVER.getAbsolutePath(), r, false);
		logger.finest(">>>>>>>>>>>>>>>>>>>>>>><<<plusIcon:"+plusIcon);
		if (plusIcon != null)  
			leftClickMid(plusIcon);
		
		delay(1000);
		assertWindow("Server Dialog");
		
		
		//no further action are available. Just done for the window dialog screenshot. 
		//Also OK button not implemented for this reason.
	}
	
}
