package com.altova.mapforce;

import static com.altova.util.LoggerUtils.logger;

import static java.awt.event.KeyEvent.*;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;

import java.awt.Color;
import java.awt.Font;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;

import com.altova.nativegui.ComponentInfo;
import com.altova.nativegui.NativeGUI;
import com.altova.robots.AltovaApplicationRobot;
import com.altova.robots.ApplicationErrorException;
import com.altova.robots.CheckboxOption;

import com.altova.robots.ImageNotFoundException;
import com.altova.robots.Option;
import com.altova.robots.Options;
import com.altova.robots.Pane;
import com.altova.robots.PluginRobot;
import com.altova.robots.RadioOption;
import com.altova.robots.ScriptMistakeException;
import com.altova.robots.TextFieldOption;

import com.altova.util.IOUtils;
import com.altova.util.RegressionAssert;
import com.altova.util.Settings;
import com.altova.util.Settings.AltovaApplication;
import com.altova.util.Settings.ApplicationSettings;

/**
 * Robot class specifically for MapForce.
 * 
 * @author Havard Rast Blok
 *
 */
/**
 * @author B.Lopez
 *
 */

public class MapForceRobot extends AltovaApplicationRobot {

	private static final String BASEPATH = "mapforce/";
	public static Pane MESSAGES=new Pane("Messages");
	//public static Pane OVERVIEW=new Pane("Overview");
	public static Pane LIBRARIES=new Pane("Libraries ","View","Library Window");
	
	public final static Font MAPPING_ELEMENT_FONT = new Font("Arial", Font.BOLD, 11);
	
	private final static String[] toolbarIds = { 
		"IDR_CREATEBAR",
		"IDR_PROJECTBAR",
		"IDR_LANGUAGEBAR",
		"IDR_MAINFRAME",
		"IDR_OUTPUTBAR",
		"IDR_TEXTBAR",
		"IDR_VALIDATEANDGENERATEBAR",
		"IDT_DUMMYBAR",
		"IDT_HELP"
	};

	
	public MapForceRobot() {
		this("Altova MapForce", AltovaApplication.MAPFORCE, "MapForce");
		logger.fine("Created robot "+getClass().getName());
	}
	
	protected MapForceRobot(String appName, ApplicationSettings product) {
		this(appName, product, "MapForceControl");
	}
	
	private MapForceRobot(String appName, ApplicationSettings app, String appRegKey) {
		super(appName, app, appRegKey, BASEPATH+"MapForce_updated.rc", toolbarIds);
		
		addSettingsRegistryKey(	"LastStates", "Recent File List", "Recent Project List", "Settings",
				 "Find Items Settings","UI_E2008r2_English","UI_E2008r2sp1_English","UI_E2009_English","VsToolWindows" );
	}
	
	@Override
	public void exitApplication() {
		exitWithuotSave();
	}
	
	public void exitWithuotSave() {
		logger.fine("Exit without save");
//		compareState = PixelCompare.BLACK_WHITE;
		int ignoreOld = ignorePixels;
		ignorePixels = 0;
		leftClickMenuItem("File", "Exit  ");delay(1000);
		ignorePixels = ignoreOld;
		escapeGeneralDialogs("Waiting while escaping exit dialogs");
		
		delay(5000);
	}

	public void escapeGeneralDialogs(String msg){
		logger.fine(msg);
		addEscapeDialogAction("Save changes", VK_N);
//		escaping eclipse dialogs
		if(this instanceof PluginRobot) {
			PluginRobot plugin = (PluginRobot)this;
			plugin.escapePluginDialogs("Waiting while closing plugin dialogs");
		}
	}
	
	public void hideOverviewWindow(){
		Rectangle overviewWdw=findComponentName("Overview");
		if (overviewWdw!=null){
			leftClickMenuItem("View",getBridgeMenuItem(),"Overview");
		}
	}
	
	//File Menu related methods
	
	/**
	 * Creates a new Mapping, Project file or Web Service Project
	 * @param: fileType -> valid parameters are "Mapping","Project File" or "Web Service" 
	 */
	public void newMFFile(String fileType){
		if((fileType.equalsIgnoreCase("Mapping"))||(fileType.equalsIgnoreCase("Project File"))||(fileType.equalsIgnoreCase("Web Service"))){
			
		leftClick("ID_FILE_NEW");
		delay(2000);
		assertWindow("New File");
		Rectangle newFileWdw =NativeGUI.getForegroundWindowInfo().getLocation();
		//we first of all, deselect any possible preselection
		leftClick((int)(newFileWdw.x+0.25*newFileWdw.width),(int)(newFileWdw.y+0.6*newFileWdw.height));
		delay(500);
		leftClickString(fileType, MS_SHELL_DLG_FONT, Color.BLACK, newFileWdw);
		delay(1000);
		leftClickMid(findComponent("OK","Button",newFileWdw));
		}else{
			throw new ScriptMistakeException("Please, specify a valid type as parameter: Mapping, Project File or Web Service");		
			}
	}
	
	public void startFromNewMapping(){
		newMFFile("Mapping");
	}
	/**This method clicks on the 'open' icon, once the appropiate resource id
	 * is given as parameter
	 * 
	 * @param file
	 */
	
	public void openFile(File file){
		leftClick("ID_FILE_OPEN");
		delay(2000);
		typeStringEnter(file.getAbsolutePath());
		
		
		
	}
	
	public void openFile(File file,String...menuitems){
		leftClickMenuItem("File", menuitems);
		delay(1000);
		typeStringEnter(file.getAbsolutePath());
	}
	
	public void saveFileAs(String newFilePath,String...menuitems){
		leftClickMenuItem("File",menuitems);
		delay(1000);
		assertWindow("Save");
		typeStringEnter(newFilePath);
		delay(1000);
		escapeDialog("The mapping file format version has changed.",KeyEvent.VK_Y);
	}
	
	public void saveFileAs(String newFilePath){
		saveFileAs(newFilePath,"As...");
	}
	
	public void reload(){
		leftClickMenuItem("File",getReloadMenuItem());
		delay(1000);
		assertWindow("MapForce");
		escapeDialog("Do you want to reload this file and lose your changes?", KeyEvent.VK_Y);
	}
	
	//This command is used in VS and application
	public String getReloadMenuItem(){
		return "Reload";
	}

	public void closeSaveNoChanges(){
		leftClickMenuItem("File", "Close");	
		delay(1000);
		escapeGeneralDialogs("Waiting while escaping plugin and save dialogs");
	}
	
	/**This method closes all files currently open in the editor . Additionally, 
	 * it is able to escape the save changes dialog for of up to 3 unsaved files
	 */
	
	public void closeAllSaveNoChanges(){
		leftClickMenuItem("File", "Close All");	
		delay(500);
		for (int i = 0; i < 3; i++) {
			escapeDialog("Save changes",KeyEvent.VK_N);
			delay(500);
		}
		
	}
	
	public void saveProject(){
		leftClickMenuItem("Project", "Save Project");
	}
	
	public void closeProject(){
		leftClickMenuItem("Project", "Close Project");
		escapeDialog("The current project has been modified. Would you like to save it",VK_N);
	}
	
	public void validateMapping(){
	leftClickMenuItem("File", "Validate Mapping");	
	}
	
	public void mappingSettings(){
		leftClickMenuItem("File","Mapping Settings");
		delay(500);
		assertWindow("Mapping Settings");
	}
	
	
	public void generateCodeInSelectedLanguage(File filepath){
		IOUtils.deleteAll(filepath);
		if(!filepath.isDirectory()) {
			filepath.mkdirs();
		}
		leftClickMenuItem("File", "Generate Code in Selected Language");
		delay(3000);
		enterFilePathLangGen(filepath);
	}
	
	public void generateCodeIn(String language,File filepath){
		IOUtils.deleteAll(filepath);
		if(!filepath.isDirectory()) {
			filepath.mkdirs();
		}
		leftClickMenuItem("File", "Generate Code in              .",language);
		delay(2000);
		enterFilePathLangGen(filepath);
	}
	
	
	public void enterFilePathLangGen(File filepath){
		
		assertWindow("Browse For Folder");
		Rectangle okbut=findComponent("OK","Button",NativeGUI.getForegroundWindowInfo().getLocation() );
		leftClick(okbut.x,okbut.y-20);
		delay(500);
		removeTextfieldText();
		typeStringEnter(filepath.getAbsolutePath());
		delay(5000);
	}
	
	public void setOptionsIn_genDoc_dlg(Options options){
		
		leftClickMenuItem("File", "Generate Documentation");
		delay(2000);
		applyOptionsEnter("Generate Documentation", options);
		delay(1000);
		assertWindow("Save As"); 
		escapeDialog("Save As", VK_ESCAPE);
	}
	
	public void generateDocumentation(File ROOT_PATH,String filename,Options options){
		IOUtils.deleteAll(ROOT_PATH);
		if(!ROOT_PATH.isDirectory()) {
			ROOT_PATH.mkdirs();
		}
		leftClickMenuItem("File", "Generate Documentation");
		delay(2000);
		applyOptionsEnter("Generate Documentation", options);
		delay(1000);
		assertWindow("Save As");
		typeStringEnter(ROOT_PATH.getAbsolutePath()+"\\"+filename);
		delay(3000);
	}
	
	
	public void recentFilesList(String filename){
		leftClickMenuItem("File", "Recent Files",filename);
		
	}
	
	public void recentProjectsList(String projectname){
		leftClickMenuItem("Project", "Recent Projects",projectname);
	}
	
//	Edit Menu related methods
	
	/**This method does a quick find via cntrl+f and does not allow the user to set extra options
	 * match whole word or match case . If quickness is required, this method is highly recommended
	 *@param word : string to be found
	 */
	
	public void find(String word){
		ComponentInfo info = NativeGUI.getForegroundWindowInfo();
		for (int i = 0; i < 5 && !info.getWindowText().equalsIgnoreCase("Find") ; i++) {
			logger.info("Pressing Cntrl+F to find string");
			keyTypeCtrl(VK_F);
			delay(1000);
			info = NativeGUI.getForegroundWindowInfo();
		}
		
		assertWindow("Find");
		typeStringEnter(word);
		if (escapeDialog("Cannot find the string", VK_ESCAPE)) {
			keyType(VK_ESCAPE); // escape the find dialog as well
			throw new ScriptMistakeException("The string '" + word + "' could not be found");
		}
	}
	
	/**This is a more accurate alternative.All possible options in the Mapforce find dialog can be set/reset
	 * 
	 * @param word : String to be found
	 * @param cleanField: boolean that indicates if a cleaning of the field is required after the find
	 * @param wholewrdonly: boolean to specify if just whole words are to be matched
	 * @param casesens: boolean to specify is find should be done case sensitive
	 * @param ifnegtest:set to true this parameter if a negative case is being performed
	 * @param menuitems: this parameter is needed to adapt the menu names to the plugins ones
	 */
	
	public void findDialog(String word, boolean wholewrdonly, boolean casesens,
			boolean ifnegtest, boolean findAll, Font dlgfont,
			String... menuitems) {
		leftClickMenuItem("Edit", menuitems);

		assertWindow("Find");

		// set the Find options
		if (dlgfont.equals(MS_SHELL_DLG_FONT)) {
			Options options = new Options();
			options.add(new TextFieldOption("Find what", word));
			options.add(new CheckboxOption("Match whole", wholewrdonly));
			options.add(new CheckboxOption("Match case", casesens));
			options.applyOption(this);

		} else {
			typeString(word);
			leftClickString("Match whole", dlgfont, Color.BLACK,
					NativeGUI.getForegroundWindowInfo().getLocation());
			if (wholewrdonly) {
				typeString("+");
			} else {
				typeString("-");
			}
			leftClickString("Match case", dlgfont, Color.BLACK, NativeGUI
					.getForegroundWindowInfo().getLocation());
			if (casesens) {
				typeString("+");
			} else {
				typeString("-");
			}
		}

		// carry out the search
		if (!findAll) {
			leftClickMid(findComponent("Next", "Button", NativeGUI
					.getForegroundWindowInfo().getLocation()));
		} else {
			leftClickMid(findComponent("All", "Button", NativeGUI
					.getForegroundWindowInfo().getLocation()));
		}

		delay(1000);
		if (!ifnegtest) {
			if (escapeDialog("Cannot find the string", VK_ESCAPE)) {
				throw new ScriptMistakeException("The string '" + word
						+ "' could not be found");
			}
		}

		if (NativeGUI.getForegroundWindowInfo().getWindowText()
				.equalsIgnoreCase("Find")) {
			leftClickMid(findComponent("Close", "Button", NativeGUI
					.getForegroundWindowInfo().getLocation()));
		}

	}
	
	public void findDialog(String word, boolean wholewrdonly,boolean casesens,boolean ifnegtest,boolean findAll,Font dlgfont) {
		findDialog(word, wholewrdonly, casesens, ifnegtest, findAll,dlgfont,"Find");
	}
	
	public void findNext() {
		leftClickMenuItem("Edit", "Find Next"); 
	}
	
	public void findPrevious() {
		leftClickMenuItem("Edit", "Find Previous");
	}
	
	public void delete(){
		super.delete();
		assertWindow("MapForce");
		escapeDialog("Do you really want to delete this Component/Structure?", KeyEvent.VK_Y);
	}
		
	//Insert Menu related methods
	
	 public void insertXMLFile(File filepath){
		 leftClickMenuItem("Insert", "XML Schema/File");
		 delay(500);
		 assertWindow("Open");
		 typeStringEnter(filepath.getAbsolutePath());	 
	 }
	 
	 public void insertXSDFile(File xsdfilepath,boolean selectXML,File xmlfilepath,String rootelement){
		 if(selectXML&&(xmlfilepath==null)){
			throw new ScriptMistakeException("No xml file path specified");
		 }
		 leftClickMenuItem("Insert", "XML Schema/File");
		 delay(500);
		 assertWindow("Open");
		 typeStringEnter(xsdfilepath.getAbsolutePath());
		 delay(500);
		 assertWindow("MapForce");
		 RegressionAssert.assertAreas(TOP_WINDOW);
		 leftClick(NativeGUI.getForegroundWindowInfo().getLocation().x+30,NativeGUI.getForegroundWindowInfo().getLocation().y+5);
		 if(selectXML){
			 escapeDialog("Do you want to supply a sample XML file, a global resource, or not supply any at all?", KeyEvent.VK_B);
			 delay(500);
			 assertWindow("Open");
			 typeStringEnter(xmlfilepath.getAbsolutePath());
		 }else{
			 escapeDialog("Do you want to supply a sample XML file, a global resource, or not supply any at all?", KeyEvent.VK_S);
			 delay(1000);
			 assertWindow("Select root element");
			 try{
					leftClickMid(findString(rootelement, DEFAULT_CONTENT_FONT, NativeGUI.getForegroundWindowInfo().getLocation(), false));
				}catch(ImageNotFoundException e){
					leftClickMid(findString(rootelement, DEFAULT_CONTENT_FONT,TRANSPARENT,Color.WHITE, NativeGUI.getForegroundWindowInfo().getLocation(), false));
				}
			leftClickMid(findComponent("OK", "Button", NativeGUI.getForegroundWindowInfo().getLocation()));	
		 }
	
	 }
	
	@Deprecated
	public void insertEDI(boolean ifedifact, String edicollection, File filename) {
			 //TODO: change bool to String
			 //TODO: put in switch block
		leftClickMenuItem("Insert", "EDI");
		delay(2000);
		assertWindow("Browse EDI collections");
		keyType(KeyEvent.VK_HOME);
		if (ifedifact) {
			Rectangle edif=findString(" EDIFACT", WINDOWS_DEFAULT_FONT, NativeGUI.getForegroundWindowInfo().getLocation(),false);
			leftClickMid(edif);delay(100);
			
		} else {
			Rectangle x12=findString("ASC X12", WINDOWS_DEFAULT_FONT, NativeGUI.getForegroundWindowInfo().getLocation(),false);
			leftClickMid(x12);delay(100);
			keyType(KeyEvent.VK_DOWN);delay(100);
			keyType(KeyEvent.VK_DOWN);
		}
			keyType(KeyEvent.VK_TAB); //we position the cursor in the EDI/X12/HL7 list
		
		// typing the first letter of the string to search and then pressing up to deselect accelerates the search
		// considerably
		delay(500);
		typeString(edicollection.substring(0, 1));
		delay(500);
		keyType(KeyEvent.VK_DOWN);
		keyType(KeyEvent.VK_DOWN);
		
		leftClickString(edicollection, DEFAULT_CONTENT_FONT, Color.BLACK, NativeGUI.getForegroundWindowInfo().getLocation());
		delay(1500);
		keyType(VK_ENTER);
		//leftClickMid(findComponent("OK", "Button", NativeGUI.getForegroundWindowInfo().getLocation()));
		delay(1500);

		assertWindow("MapForce");

		if (filename!= null) {
			escapeDialog("Do you want to supply a sample EDI file, a global resource, or not supply any at all?", KeyEvent.VK_B);
			delay(500);
			assertWindow("Choose Input EDI Instance File");
			typeStringEnter(filename.getAbsolutePath());
			delay(500);
			assertWindow("Component Settings");
			leftClickMid(findComponent("OK", "Button", NativeGUI.getForegroundWindowInfo().getLocation()));
		} else {
			escapeDialog("Do you want to supply a sample EDI file, a global resource, or not supply any at all?", KeyEvent.VK_S);
		}
	}
		 
	public void insertEDI(String ediType, String edicollection, File filename) {
		int positionInList = 2; //comes in when down-keypresses are req'd
		//TODO: put in switch block
		leftClickMenuItem("Insert", "EDI");
		delay(2000);
		assertWindow("Browse EDI collections");
		keyType(KeyEvent.VK_HOME);
	
		if (ediType == "EDIFACT"){
			Rectangle edif = findString(" EDIFACT", WINDOWS_DEFAULT_FONT, NativeGUI.getForegroundWindowInfo().getLocation(),false);
			leftClickMid(edif);delay(100);
		} 
		else if (ediType == "ASC X12"){
			Rectangle x12 = findString("ASC X12", WINDOWS_DEFAULT_FONT, NativeGUI.getForegroundWindowInfo().getLocation(),false);
			leftClickMid(x12);delay(100);
			keyType(KeyEvent.VK_DOWN);delay(100);
			keyType(KeyEvent.VK_DOWN);
		}
		else if (ediType == "IATA"){
			Rectangle iata = findString(" IATA", WINDOWS_DEFAULT_FONT, NativeGUI.getForegroundWindowInfo().getLocation(),false);
			leftClickMid(iata);delay(100);
			keyType(KeyEvent.VK_DOWN);
			positionInList = 3;
		}
		else if (ediType == "HIPAA.X12"){
			Rectangle hipaa = findString("ASC X12", WINDOWS_DEFAULT_FONT, NativeGUI.getForegroundWindowInfo().getLocation(),false);
			leftClickMid(hipaa);delay(100);
			keyType(KeyEvent.VK_DOWN);
		}
		else if (ediType == "TRADACOMS"){
			Rectangle tradacoms = findString(ediType, WINDOWS_DEFAULT_FONT, NativeGUI.getForegroundWindowInfo().getLocation(),false);
			leftClickMid(tradacoms);delay(100);
			keyType(KeyEvent.VK_DOWN);
		}
		else if (ediType == "HL7"){
			Rectangle hL7 = findString(ediType, WINDOWS_DEFAULT_FONT, NativeGUI.getForegroundWindowInfo().getLocation(),false);
			leftClickMid(hL7);delay(100);
			keyType(KeyEvent.VK_DOWN);
			positionInList = 40; //ADT_A28 is pretty far down on the list...
		}	

		keyType(KeyEvent.VK_TAB); //we position the cursor in the EDI/X12/HL7 list
		
		// typing the first letter of the string to search and then pressing down to deselect accelerates the search considerably
		delay(500);
		typeString(edicollection.substring(0, 1));
		delay(500);
		for (int i = 0; i < positionInList; i++){
			keyType(KeyEvent.VK_DOWN);
		}
		if (ediType == "HL7") //workaround for image-comparison problem
			leftClickString("Add person", DEFAULT_CONTENT_FONT, Color.BLACK, NativeGUI.getForegroundWindowInfo().getLocation());
		else
			leftClickString(edicollection, DEFAULT_CONTENT_FONT, Color.BLACK, NativeGUI.getForegroundWindowInfo().getLocation());
		delay(1500);
		keyType(VK_ENTER);
		//leftClickMid(findComponent("OK", "Button", NativeGUI.getForegroundWindowInfo().getLocation()));
		delay(1500);

		assertWindow("MapForce");

		if (filename!= null) {
			escapeDialog("Do you want to supply a sample EDI file, a global resource, or not supply any at all?", KeyEvent.VK_B);
			delay(500);
			assertWindow("Choose Input EDI Instance File");
			typeStringEnter(filename.getAbsolutePath());
			delay(500);
			assertWindow("Component Settings");
			leftClickMid(findComponent("OK", "Button", NativeGUI.getForegroundWindowInfo().getLocation()));
		} else {
			escapeDialog("Do you want to supply a sample EDI file, a global resource, or not supply any at all?", KeyEvent.VK_S);
		}
	}
	
	public void insertJSON(){
		//switch to output first
		leftClickMenuItem("Output", "Built-In");
		leftClickMenuItem("Insert", "JSON");
		delay(2000);
	}
	
	public void insertInput(){
		leftClickMenuItem("Insert", "Input");
		delay(2000);

	}
	
	public void insertOutput(){
		leftClickMenuItem("Insert", "Output");
		delay(2000);

	}
	
	public void insertNodes(){
		
	}
	
		 /**This method can just be used to test the insertion of text through a txt,csv  or mft file,but
		  * never to call flex text to create a new mft
		  * 
		  * @param textfile
		  */
		 public void insertText(File textfile){
			 leftClickMenuItem("Insert","Text File");
			 delay(500);
			 assertWindow("Insert Text Component");
			 RegressionAssert.assertAreas(TOP_WINDOW);
			 if(textfile.getName().contains(".mft")){
				 leftClickMid(findComponent("Use &FlexText module", "Button", NativeGUI.getForegroundWindowInfo().getLocation()));
				 delay(500);
				 leftClickMid(findComponent("Open existing FlexText configuration file to map it with other sources/targets", "Button", NativeGUI.getForegroundWindowInfo().getLocation()));
				 delay(500);
				 assertWindow("Open");
				 typeStringEnter(textfile.getAbsolutePath());
			 }else{
				 leftClickMid(findComponent("Use &simple processing for standard CSV", "Button", NativeGUI.getForegroundWindowInfo().getLocation()));
				 delay(500);
				 leftClickMid(findComponent("Continue", "Button", NativeGUI.getForegroundWindowInfo().getLocation()));
				 delay(500);
				 assertWindow("Component Settings");
				 keyPress(VK_TAB);
				 typeStringEnter(textfile.getAbsolutePath());
				 escapeDialog("MapForce", VK_ENTER);
			 }
			 
		 } 
		 
	 public void insertWebServiceFunction(File wsdlfile, String webserviceport,
			String webserviceop, Options options) {
		leftClickMenuItem("Insert", "Web Service Function");
		delay(500);
		assertWindow("WSDL Call Settings");
		RegressionAssert.assertAreas(TOP_WINDOW);
		typeString(wsdlfile.getAbsolutePath());
		leftClickMid(findComponent("Choose", "Button", NativeGUI
				.getForegroundWindowInfo().getLocation()));
		delay(500);
		assertWindow("Choose a Web service endpoint");
		for (int i = 1; i <= 2; i++) {
			try {
				leftClickMid(findString(webserviceport, WINDOWS_DEFAULT_FONT,
						Color.WHITE, Color.BLACK, NativeGUI
								.getForegroundWindowInfo().getLocation(), false));
				break;
			} catch (ImageNotFoundException a) {
				logger.info("Maybe it is selected.Let's try unselecting it...");
				keyType(KeyEvent.VK_END);
			}
		}

		leftClickMid(findComponent("OK", "Button", NativeGUI
				.getForegroundWindowInfo().getLocation()));
		delay(500);
		assertWindow("Choose a Web service operation");

		for (int i = 1; i <= 2; i++) {
			try {
				leftClickMid(findString(webserviceop, WINDOWS_DEFAULT_FONT,
						Color.WHITE, Color.BLACK, NativeGUI
								.getForegroundWindowInfo().getLocation(), false));
				break;
			} catch (ImageNotFoundException a) {
				logger.info("Maybe it is selected.Let's try unselecting it...");
				keyType(KeyEvent.VK_END);
			}
		}
		// We ok the dialog anyways
		leftClickMid(findComponent("OK", "Button", NativeGUI
				.getForegroundWindowInfo().getLocation()));
		delay(1000);
		if (options != null) {
			applyOptionsEnter("WSDL Call Settings", options); // here,
			// username and
			// password are
			// entered if
			// necessary
		} else {
			leftClickMid(findComponent("OK", "Button", NativeGUI
					.getForegroundWindowInfo().getLocation()));
		}
	}
		 
		public void insertExcel2007File(File xlsxfile) {
		leftClickMenuItem("Insert", "Excel 2007+ File");
		assertWindow("MapForce");
		RegressionAssert.assertAreas(TOP_WINDOW);
		if (xlsxfile!=null) {
			escapeDialog("Do you want to supply a sample XLSX file, a global resource, or not supply any at all?", KeyEvent.VK_B);
			delay(500);
			assertWindow("Open");
			typeStringEnter(xlsxfile.getAbsolutePath());
		} else {
			escapeDialog("Do you want to supply a sample XLSX file, a global resource, or not supply any at all?", KeyEvent.VK_S);
		}

	}
		
		
		public void insertConstant(String data,String datatype){
			leftClickMenuItem("Insert", "Constant");
			assertWindow("Insert Constant");
			RegressionAssert.assertAreas(TOP_WINDOW);
			typeString(data);delay(100);
			RadioOption a=new RadioOption(datatype,null,null,null,null,WINDOWS_DEFAULT_FONT);
			applyOptionsEnter("Insert Constant", a);
			
		}
		
		
		public void insertFilter(){
			leftClickMenuItem("Insert","Filter: Nodes/Rows");
		}
		
		public void insertSqlWhereCondition(){
			leftClickMenuItem("Insert","SQL-WHERE/ORDER");
		}
		
		public void insertValueMap(){
			leftClickMenuItem("Insert","Value-Map");
		}
		
		public void insertIfElseCondition(){
			leftClickMenuItem("Insert","IF-Else Condition");
		}
		
		
		public void insertException(){
			leftClickMenuItem("Insert","Exception");
		}
		
	// Project Menu related methods
	
	
	public void createFolderInProject(String foldername,Option options){
		leftClickMenuItem("Project", "Create Folder");
		delay(2000);
		assertWindow("Properties");
		typeString(foldername);
		applyOptionsEnter("Properties", options);
	}
	
	public void openMapping(){
		leftClickMenuItem("Project","Open Mapping");
	}
	
	public void createMappingForOperation(File WEBSERVICE_MFD){
		leftClickMenuItem("Project","Create Mapping for Operation");
		delay(500);
		assertWindow("Save As");
		typeStringEnter(WEBSERVICE_MFD.getAbsolutePath());
		delay(1000);
	}
	
	public void addMappingFileForOperation(File Mapping_MFD){
		leftClickMenuItem("Project","Add Mapping File for Operation");
		delay(1000);
		assertWindow("Open");
		typeStringEnter(Mapping_MFD.getAbsolutePath());
	}
	
	public void removeProjectItem(){
		leftClickMenuItem("Project", "Remove Item");
	}
	
	public void insertWebService(File wsdl_file,Option options){
		leftClickMenuItem("Project","Insert Web Service");
		 insertWebServiceDialog(wsdl_file,options);
	}
	public void insertWebServiceDialog(File wsdl_file,Option options){
		delay(2000);
		assertWindow("Insert Web Service");
		typeString(wsdl_file.getAbsolutePath());
		delay(1000);
		leftClickMid(findString("Choose",WINDOWS_DEFAULT_FONT,NativeGUI.getForegroundWindowInfo().getLocation(),false));
		delay(2000);
		applyOptionsEnter("Insert Web Service", options);
		
	}
	
	public void generateCodeForEntireProject(){
		leftClickMenuItem("Project", "Generate Code for Entire Project");
		delay(2000);
	}
	
	public void generateCodeForProjectIn(String lang) {
		if ((lang.equalsIgnoreCase("XSLT 1.0")) || (lang.equalsIgnoreCase("XSLT 2.0")) || (lang.equalsIgnoreCase("XQuery")) || (lang.equalsIgnoreCase("Java")) || (lang.equalsIgnoreCase("C#"))
				|| (lang.equalsIgnoreCase("C++"))) {
			leftClickMenuItem("Project", "Generate Code in", lang);
			delay(2000);
		} else {
			throw new ScriptMistakeException("Please, select one of this languages as parameter :XSLT 1.0,XSLT 2.0,XQuery,Java,C#,C++");
		}

	}
	
	
	public void projectProperties(Option options){
		leftClickMenuItem("Project","Properties");
		delay(2000);
		assertWindow("Project Settings");
		applyOptionsEnter("Project Settings", options);
	}
	
	//Component Menu related methods
	public void alignTreeLeft(){
		leftClickMenuItem("Component","Align Tree Left");
	}
	
	public void alignTreeRight(){
		leftClickMenuItem("Component","Align Tree Right");
	}
	
	public void changeRootElement(String new_root_elm){
		leftClickMenuItem("Component", "Change Root Element");
		delay(1500);
		assertWindow("Select root element");
		Rectangle sel_root=NativeGUI.getForegroundWindowInfo().getLocation();
		leftClickMid(findString(new_root_elm,DEFAULT_CONTENT_FONT,Color.WHITE,Color.BLACK,sel_root,false));
		leftClickMid(findComponent("OK", "Button", sel_root));
	}
	
	public void addRemoveTables(){
		leftClickMenuItem("Component", "Add/Remove/Edit");
		//horrible dialog comes up, so we I not implement any further for the moment
	}
	
	public void refreshDB(){
		leftClickMenuItem("Component", "Refresh");
	}
	
	public void duplicateInput(){
		leftClickMenuItem("Component", "Duplicate Input");
	}
	
	public void removeDuplicate(){
		leftClickMenuItem("Component", "Remove Duplicate");
	}
	
	public void dBTableActions(){
		leftClickMenuItem("Component","Database Table Actions");
		delay(1500);
		assertWindow("Database Table Actions - ");
	}
	
	public void DBTableActions_insertAction(String element){
		dBTableActions();
		DBTableActions("Insert Action", element, 170, "equal");
		
		
	}
	
	public void DBTableActions_appendAction(String element){
		dBTableActions();
		DBTableActions("Append Action", element, 170, "equal");
	}
	
	public void DBTableActions_deleteAction(String element){
		dBTableActions();
		DBTableActions("Delete Action", null, 0, "equal");
	}
	
	public void DBTableActions(String action, String ElementName, int shiftToClick, String dropDownElement){
		
		Rectangle DBwindow = NativeGUI.getForegroundWindowInfo().getLocation();
						
		if (action.equals("Append Action")){
			//Select from dropDown list, the new Appended element: I will select chang from "Insert All" to "Ignore if"
			leftClickMid(findString("Insert ", DEFAULT_CONTENT_FONT, DBwindow, false));
			//and I select "Ignore if" from dropdown list
			leftClickMid(findString("Ignore if...", DEFAULT_CONTENT_FONT,DBwindow, false));
		}
		
		//I select the action: Insert, Append or Delete Action
		leftClickMid(findString(action, DBwindow, false));
		
		delay(1500);
		
		if (!action.equals("Delete Action")){
			
			Rectangle action_temp = findElementInMapping(ElementName, DBwindow);
			//From the left side of the string, I click Action field   
			leftClick(action_temp.x+shiftToClick, action_temp.y);
		
			//Select from dropDown list, the element to Update
			leftClickMid(findString(dropDownElement, MS_SHELL_DLG_FONT,DBwindow, false));	
		}
		
	}
	
	public void DBKeySettings(Option options){
		
		dBTableActions();
		options.applyOption(this);
		//applyOptionsEnter("Database Table Actions",options);
		
		
	}
	
	public void queryDB(){
		leftClickMenuItem("Component", "Query Database");
	}
	
	public void componentProperties(Options options){
		leftClickMenuItem("Component", "Properties");
		delay(1000);
		assertWindow("Component Settings");
		applyOptionsEnter("Component Settings", options);
	}
	//Connection Menu related methods
	
	public void autoconnectMatchingChildren(){
		leftClickMenuItem("Connection", "Auto Connect Matching Children");
		
	}
	
	public void autoConnectSettings(Options options){
		leftClickMenuItem("Connection", "Settings for Connect Matching Children");
		delay(1000);
		applyOptionsEnter("Settings for Connect Matching Children", options);
	}
	
	//Function Menu related methods
	
	//this is needed for eclipse 
	public void assertLibrariesAndDiagram(){
		activatePane(LIBRARIES);
		RegressionAssert.assertAreas(LIBRARIES,DIAGRAM_MAIN_WINDOW);
	}
	
	public void createUserDefinedFcn(Options options){
		leftClickMenuItem("Function", "Create User-Defined Function");
		delay(1000);
		applyOptionsEnter("Create User-defined Function",options);
	}
	
	public void createUserDefinedFcnFromSelection(Options options){
		leftClickMenuItem("Function", "Create User-Defined Function from Selection");
		delay(1000);
		applyOptionsEnter("Create User-defined Function",options);
	}
	
	public void functionSettings(Options options){
		leftClickMenuItem("Function", "Function Settings");
		delay(1000);
		applyOptionsEnter("Edit User-defined Function", options);		
	}
	
	public void removeFunction(){
		leftClickMenuItem("Function", "Remove Function");
		escapeDialog("Do you really want to remove user-defined function", KeyEvent.VK_Y);
	}
	
	public void insertInputInMapping(String name,Options options){
		leftClickMenuItem("Function", "Insert Input");
		delay(500);
		RegressionAssert.assertAreas(TOP_WINDOW);
		options.add(new TextFieldOption("Name",false,name,null,null,null,null,WINDOWS_DEFAULT_FONT));
		applyOptionsEnter("Create Input",options);
	}
	
	private void createInputOrOutputDialog(boolean ifcomplex, String struct, String filename, String rootelement) {
		if (ifcomplex) 
		{
			leftClickMid(findString("Choose", WINDOWS_DEFAULT_FONT, NativeGUI.getForegroundWindowInfo().getLocation(), false));
			delay(1000);
			RegressionAssert.assertAreas(RegressionAssert.getTestName()+"_2",TOP_WINDOW);
			try{
				leftClickMid(findString(struct, DEFAULT_CONTENT_FONT, NativeGUI.getForegroundWindowInfo().getLocation(), false));
			}catch(ImageNotFoundException e){
				leftClickMid(findString(struct, DEFAULT_CONTENT_FONT,TRANSPARENT,Color.WHITE, NativeGUI.getForegroundWindowInfo().getLocation(), false));
			}
			leftClickMid(findComponent("OK", "Button", NativeGUI.getForegroundWindowInfo().getLocation()));
			delay(1000);
			if ((struct.equalsIgnoreCase("Database Structure")) || (struct.equalsIgnoreCase("EDI Structure"))) {
				throw new ScriptMistakeException("This option is not supported in the robot");
			}
			else if (struct.equalsIgnoreCase("XBRL Structure")) {
				throw new ScriptMistakeException("This option is currently not finished and may be supported in the future");
			} 
			else if ((struct.equalsIgnoreCase("XML Schema Structure")) || (struct.equalsIgnoreCase("Flex"))) {
				assertWindow("Open");
				typeStringEnter(filename);
				delay(1000);
				assertWindow("Choose Root Item");
				RegressionAssert.assertAreas(RegressionAssert.getTestName()+"_3",TOP_WINDOW);
				typeString(rootelement.substring(0, 1));
				leftClickMid(findComponent("OK", "Button", NativeGUI.getForegroundWindowInfo().getLocation()));
			} else 
			{
				assertWindow("Choose Root Item");
				RegressionAssert.assertAreas(RegressionAssert.getTestName()+"_3",TOP_WINDOW);
				typeString(rootelement.substring(0, 1));
				leftClickMid(findComponent("OK", "Button", NativeGUI.getForegroundWindowInfo().getLocation()));
			}
		}

	}
	
	public void insertInputInUserDefFcn(Options options, boolean ifcomplex, String struct, String filename, String rootelement) {
		leftClickMenuItem("Function", "Insert Input");
		delay(500);
		 RegressionAssert.assertAreas(RegressionAssert.getTestName()+"_1",TOP_WINDOW);
		createInputOrOutputDialog(ifcomplex, struct, filename, rootelement);
		if (!ifcomplex) {
			options.add(new RadioOption("Simple type",null,null,null,null,WINDOWS_DEFAULT_FONT));
		}
		delay(2000);
		applyOptionsEnter("Create Input", options);
	}

	public void insertOutputInUserDefFcn(Options options, boolean ifcomplex, String struct, String filename, String rootelement) {
		leftClickMenuItem("Function", "Insert Output");
		delay(500);
		RegressionAssert.assertAreas(RegressionAssert.getTestName()+"_1",TOP_WINDOW);
		createInputOrOutputDialog(ifcomplex, struct, filename, rootelement);
		if (!ifcomplex) {
			options.add(new RadioOption("Simple type",null,null,null,null,WINDOWS_DEFAULT_FONT));
		}
		delay(2000);
		applyOptionsEnter("Create Output", options);
	}
	
	//Output Menu related methods
	
	public void outputXslt(){
		leftClick("ID_SELECT_LANGUAGE_XSLT");
	}
	
	public void outputXsltMenu(){
		leftClickMenuItem("Output", "1.0");
	}
	
	public void outputXslt2(){
		leftClick("ID_SELECT_LANGUAGE_XSLT2");
	}
	
	public void outputXslt2Menu(){
		leftClickMenuItem("Output", "XSLT 2.0");
	}
	
	public void outputXq(){
		leftClick("ID_SELECT_LANGUAGE_XQUERY");
	}
	
	public void outputXqMenu(){
		leftClickMenuItem("Output", "XQuery");
	}
	
	public void outputJava(){
		leftClick("ID_SELECT_LANGUAGE_JAVA");
	}
	
	public void outputJavaMenu(){
		leftClickMenuItem("Output", "Java");
	}
	
	public void outputCSharp(){
		leftClick("ID_SELECT_LANGUAGE_CSHARP");
	}
	
	public void outputCSharpMenu(){
		leftClickMenuItem("Output", "C#");
	}
	
	public void outputCpp(){
		leftClick("ID_SELECT_LANGUAGE_CPP");
	}
	
	public void outputCppMenu(){
		leftClickMenuItem("Output", "C++");
	}
	
	public void validateOutputFile(){
		leftClickMenuItem("Output", "Validate Output File");
	}
	
	public void saveOutputFile(File filename){
		leftClickMenuItem("Output", "Save Output File");
		delay(1000);
		assertWindow("Save As");
		typeStringEnter(filename.getAbsolutePath());
	}
	
	public void runSQLScript() {
		leftClickMenuItem("Output", "Run SQL-Script");
	}
	
	public void insertBookmark(){
		leftClickMenuItem("Output", "Insert/Remove Bookmark");
	}
	
	public void nextBookmark(){
		leftClickMenuItem("Output", "Next Bookmark");
	}
	
	public void previousBookmark(){
		leftClickMenuItem("Output", "Previous Bookmark");
	}
	
	public void removeAllBookmarks(){
		leftClickMenuItem("Output", "Remove All Bookmarks");
	}
	
	public void prettyPrintXML(){
		leftClickMenuItem("Output", "Pretty-Print XML Text");
	}
	
	public void textViewSettings(Options options){
		leftClickMenuItem("Output", "Text View Settings");
		delay(500);
		applyOptionsEnter("Text View Settings", options);
	}
	
	//View menu related methods
	
	/** This method is needed to be able to find all below items in the VS plugin,
	 * since an extra item acts as bridge between them
	 */
	
	public String getBridgeMenuItem(){
		return null;
	}
	public void enableDisableAnnotations(){
		leftClickMenuItem("View",getBridgeMenuItem(), "Show Annotations");
	}
	
	public void enableDisableShowTypes(){
		leftClickMenuItem("View", getBridgeMenuItem(),"Show Types");
	}
	
	public void showHideLibraryInFunctionHeader(){
		leftClickMenuItem("View", getBridgeMenuItem(),"Show Library in Function Header");
	}
	
	public void XBRLDisplayOptions(){
		leftClickMenuItem("View",getBridgeMenuItem(),"XBRL Display Options");
	}
	
	public void showSelectedComponentConnectors(){
		leftClickMenuItem("View",getBridgeMenuItem(),"Show Selected Component Connectors");
	}
	
	public void showConnectorsFromSourceToTarget(){
		leftClickMenuItem("View",getBridgeMenuItem(), "Show Connectors from Source to Target");
	}
	
	public void zoom(String percent){
		leftClickMenuItem("View", getBridgeMenuItem(),"Zoom");
		Rectangle zoomWdw=NativeGUI.getForegroundWindowInfo().getLocation();
		leftClickMid(findComponent("", "Edit", zoomWdw));
		removeTextfieldText();
		typeStringEnter(percent);
		
	}
	
	//Window menu related methods
	
	public void windowTileHorizontally() {
		leftClickMenuItem("Window", "Tile Horizontal");
	}
	
	public void windowTileVertically() {
		leftClickMenuItem("Window", "Tile Vertical");
	}
	
	//Help menu related methods
	
	public void webTraining() {
		leftClickMenuItem("Help",getExtraHelpMenus(),"MapForce Training");
	}
	
	public void webMapForce() {
		super.applicationOnWeb();
	}
	
	public void aboutMapForce() {
		super.aboutApplication();
	}

	
	/**Method to select a component within the mapping
	 * 
	 * @param iconFile: png image of the component's head we are searching for
	 */
	public Rectangle selectComponentFromImage(String iconFile){
		//First of all, we try to try in the diagram to unselect all components
		Rectangle mainWdw=getMainWindow();
		delay(500);
		leftClick(mainWdw.x+5, mainWdw.y+5);
		delay(500);
		leftClick(mainWdw.x+5, mainWdw.y+5);
		delay(500);
		Rectangle comp_found=findImage(iconFile, mainWdw, true);
		leftClickMid(comp_found);
		logger.fine("ACHTUNG>>>>>>>>"+ comp_found);
		return comp_found;
	}
	
	public void showOutput(){
		
		if (this instanceof VSnetMapForceRobot)
			delay(1500);
		Rectangle mWdw=getMainWindow();
		Rectangle wholeScreen=NativeGUI.getForegroundWindowInfo().getLocation();
		Rectangle searchArea=new Rectangle(wholeScreen.x,mWdw.y+mWdw.height,wholeScreen.width,wholeScreen.height-mWdw.y-mWdw.height);
		leftClickMid((findImage((IOUtils.findFile("tags_list/OUTPUT_TAG.PNG").getAbsolutePath()),searchArea, true)));
		delay(2000);
	}
	public void checkMapForceMessageWindow() {
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
				throw new ApplicationErrorException("Errors where detected in the MapForce message window: \n\n"+msg+"\n\n");
			}
		}
	
		logger.finest("No errors detected in message window");
	}
	
	/*Searches for a string within the project window
	 * @param:string to be searched
	 * */
	public Rectangle findInProjectWindow(String word){
		Rectangle rtop = NativeGUI.getForegroundWindowInfo().getLocation();
		Rectangle hint=new Rectangle(rtop.x,getMainWindow().y,rtop.width,rtop.height-getMainWindow().y);
		Rectangle projectWindow=findComponent("Project",null, hint);
		Rectangle found=findString(word, DEFAULT_CONTENT_FONT,TRANSPARENT,Color.BLACK,projectWindow,false);
		return found;
		
	}

	/* Searches for a string within the element name
	 *  @param:string to be searched
	 *  
	 *  */
	
	public Rectangle findElementInMapping(String elementName, Rectangle hint) {
	
		// TODO Auto-generated method stub
		Rectangle temp = findString(elementName, MAPPING_ELEMENT_FONT, hint, false);
		logger.fine("FIND IN ELEMEN" + temp);
		leftClickMid(temp);
		return temp;
	}
	public void deleteString(){
		keyPress(VK_END);
		for (int i = 0; i<100; i++){
			keyPress(VK_BACK_SPACE);
		}
	}
	
}
