package com.altova.databasespy;

import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.*;


import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.RectangularShape;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Random;


import com.altova.databasespy.AbstractDatabaseSpyTest.SQLopType;
import com.altova.databasespy.AbstractDatabaseSpyTest;
import com.altova.nativegui.NativeGUI;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;

import com.altova.robots.AltovaApplicationRobot;
import com.altova.robots.CheckboxOption;
import com.altova.robots.DropDownOption;
import com.altova.robots.ImageNotFoundException;
import com.altova.robots.Pane;
import com.altova.robots.PluginRobot;
import com.altova.robots.ScreenDiff;
import com.altova.robots.ScriptMistakeException;
import com.altova.util.IOUtils;
import com.altova.util.Settings.AltovaApplication;
import com.altova.util.Settings.ApplicationSettings;

/**
 * Robot class specifically for DatabaseSpy.
 * 
 * @author Havard Rast Blok
 *
 */  
public class DatabaseSpyRobot extends AltovaApplicationRobot{

	private static final String BASEPATH = "databasespy/";
	
	public final static Pane PROJECT = new Pane("Project", "View", "Project Window");
	public final static Pane ONLINE_BROWSER = new Pane("Online Browser", "View", "Online Browser");
	public final static Pane PROPERTIES = new Pane("Properties", "View", "Property Window");
	public final static Pane OVERVIEW = new Pane("Overview", "View", "Overview Window");
	public final static Pane OUTPUT = new Pane("Output", "View", "Output Window");
	public final static Pane DATABASE_STRUCTUE = new Pane("Database Structure Change Script", "View", "Database Structure Change Script");
	public final static Pane RESULT = new Pane("Result", "SQL Editor", "Result view");
	public final static Pane DESIGN = new Pane("Design");
	public final static Pane MESSAGE = new Pane("Message", "SQL Editor", "Message view");
	
	//public final static Pane DB_SCRIPT = new Pane("Database Structure Change Script", "Window", "Output Window");
	
	//test for Menu - SQL Editor - Insert Target when the Pane name is free
	public final static Pane TARGET = new Pane("MYTARGET"); 
	
	public final static Pane DATACOMPARISON_OFFICE = new Pane("OrgChartDBCompLeft.OrgChartDBCompLeft.Office - OrgChartDBCompRight.OrgChartDBCompRight.Office");
	public final static Pane DATACOMPARISON_DEPARTMENT = new Pane("OrgChartDBCompLeft.OrgChartDBCompLeft.Department - OrgChartDBCompRight.OrgChartDBCompRight.Department");	
	
	public File IMPORT_LOG_FILE  = IOUtils.findFile("logImportEuropa.log");

	private boolean importLogFile = false;
	private String importdelimiter = null;
	private boolean importPrimaryKeys = true;

	private boolean exportComments;
	
	private final static String[] toolbarIds = { 
		"IDR_TOOLBAR_MAIN",
		"IDR_TOOLBAR_DOCUMENT_ICONS",
		"IDR_SQLTOOLS",
		"IDR_SQLEDITOR",
		"IDR_DATABASESPY_SQL_PREVIEW",
		"IDT_HELP",
		"IDR_IMAGECOLLECTION",
		"IDR_DATABASESPY_PYTHON_TOOLBAR",
		"IDR_DATABASESPYTYPE_DATADIFF",
		"IDR_ICDBWND_PROJECT_TOOLBAR",
		"IDB_DIFFRESULT_SHOWEQUAL",
		"IDB_DIFFRESULT_SHOWDIFFERENT",
		"IDB_DIFFRESULT_SHOWLEFTONLY",
		"IDB_DIFFRESULT_SHOWRIGHTONLY",
		"IDB_DIFFRESULT_GOTONEXT",
		"IDB_DIFFRESULT_GOTOPREV",
		"IDB_DIFFRESULT_GOTOLAST",
		"IDB_DIFFRESULT_GOTOFIRST",
		"IDB_DIFFRESULT_LINKMAPPING",
		"IDB_RESULTBAR_INSPECTOR_LARGE",
		"IDB_RESULTBAR_MAXIMIZE_LARGE",
		"IDB_RESULTBAR_FIND_LARGE",
		"IDB_RESULTBAR_MAXIMIZEVIEW_LARGE",
	};
	
	enum side{
		Right_Side, Left_Side
	}
	
	enum comparison {
		
		Data_Comparison, Schema_Comparison
	}

	
	public DatabaseSpyRobot() {
		this("Altova DatabaseSpy", AltovaApplication.DATABASESPY, "DatabaseSpy");
		logger.fine("Created robot "+getClass().getName());
	}
	
	private DatabaseSpyRobot(String appName,ApplicationSettings product,String appRegKey){
		super(appName,product,appRegKey,BASEPATH+"DatabaseSpy.rc",toolbarIds);
		
		addSettingsRegistryKey("Recent File List","Recent Project List","Search", "Settings",
				"Recent Export File List", "UI_Z2009_English","LastStates","Recent Defined Project Directories");
	}

	@Override
	public void startApplication() {
		addEscapeDialogAction("Quick Connect", VK_ESCAPE);
		addEscapeDialogAction("Active file has not been saved yet", VK_Y);
		super.startApplication();
		delay(5000);
	}
	
	
	@Override
	public void exitApplication() {
		exitWithuotSave();
	}
	
	
	
	public void exitWithuotSave() {
		logger.fine("Exit without save");
		leftClickMenuItem("File", "Exit  ");
		delay(1000);

		escapeDialog("Do you want to save project modifications?", VK_N);
		delay(5000);
	}
	
	
	
	public void closeAll(){
		
		leftClickMenuItem("File", "Close All");
		
		escapeDialog("Save modified files", VK_D);
		escapeDialog("Are you sure you want to disconnect?", VK_Y);
	}
	
	public void newProject(){
		
		leftClickMenuItem("File", "New", "Project");
		delay(500);
		escapeDialog("Are you sure you want to disconnect?", VK_Y);
		escapeDialog("DatabaseSpy", VK_N);
	}
	
	
	public void openProject (String projectName){
		
		leftClickMenuItem("File", "Open", "Open Project");
		delay(1000);
		escapeDialog("DatabaseSpy", VK_N);
		
		delay(2000);
		assertWindow("Open");
		typeStringEnter(projectName);
		
		escapeDialog("Do you want to save project modifications?", VK_N);
		escapeDialog("Are you sure you want to disconnect?", VK_Y);
		
		
	}
	
	public void saveFile(){

		leftClickMenuItem("File", "Save");
		
	}
	
	public void saveProject(){

		leftClickMenuItem("File", "Save", "Save Project");
		delay(2000);
		
	}
	
	
	public void addFileToProject(String projectName){

		leftClickMenuItem("Project", "Add Files to Project ...");
		delay(2000);
		assertWindow("Open");
		typeStringEnter(projectName);
		
	}
	
	public void addNewActiveFileToProject(String SQLFileToAdd){

		openFile(SQLFileToAdd);
		delay(2000);
		leftClickMenuItem("Project", "Add Active File to Project");
		delay(2000);
				
	}
	
	
	
	public void saveFileAs(String fileName){

		leftClickMenuItem("File", "Save As...");
		delay(2000);
		assertWindow("Save As");
		typeStringEnter(fileName);
		delay(1500);
		escapeDialog("Add to Project", VK_S);
		
	}
	
	public void saveProjectAs(String projectName){

		leftClickMenuItem("File", "Save Project As...");
		delay(2000);
		assertWindow("Save As");
		typeStringEnter(projectName);
		
	}
	
	public void applyOptionsEnter(String optionWindow, RadioOption options){
		
		applyOption(optionWindow, options);
		
		try{
			leftClickMid(findComponent("Next", "Button", null));
		
		}catch(ScriptMistakeException e){
			keyType(VK_ENTER);
		}
		delay(1000);
		
	}
	
	
	public void applyOption(String optionWindow, RadioOption options){
		
		assertWindow(optionWindow);
		
		if(options != null) {
			options.applyOption(this);
		}
		
		
	}

	public void execute() {
		
		leftClickMenuItem("SQL Editor", "Execute");
		delay(250);
		
	}
	
	public void saveFileAll() {
		
		leftClickMenuItem("File", "Save", "Save All");		
		
	}
	
	
	public void editText(int... a){
		
		for (int i : a) {
			keyType(i);
			delay(500);
		}
		
		
		
	}

	public void findSelection(String toFind) {
		
		leftClickMenuItem("Edit", "Find...");	
		delay(1000);
		assertWindow("Find");
		typeStringEnter(toFind);
		
		addEscapeDialogAction("Reached the end of the file", VK_ENTER);
		checkEscapeDialogActions();
		
	}

	public void FindNextText() {
		
		leftClickMenuItem("Edit", "Find next");	
		
	}
	
	public void replace(String oldText, String newText){
		
		leftClickMenuItem("Edit", "Replace");
		assertWindow("Find & Replace");
		
		typeString(oldText);
		delay(1000);
		keyType(VK_TAB);
		typeString(newText);
		
		try{
			leftClickMid(findComponent("Replace", "Button", null));
			delay(2000);
			leftClickMid(findComponent("Replace", "Button", null));
			
		}catch(ScriptMistakeException e){
			keyType(VK_ENTER);
			delay(2000);
			keyType(VK_ENTER);
		}
		
		escapeDialog("Reached the end of the file.", VK_ENTER);		
		escapeDialog("Cannot find the string", VK_ENTER);
				
		keyType(VK_ESCAPE);
		keyType(VK_ESCAPE);
		
	}
	
	public void selectConnectionWizard(String DBsource){
		
		selectQuickConnectMenu("Connection Wizard", DBsource);
		
	}
	
	
	public void selectODBConnections(){
		
		selectQuickConnectMenu("ODBC Connections", null);
		
	}
	
	public void selectJDBConnections(){
		
		selectQuickConnectMenu("JDBC", null);
		
	}
	
	public void selectADOConnection(String DBsource){
		
		selectQuickConnectMenu("ADO Connections", DBsource);
		
	}
	
	
	public void selectODBCDataSource(String ODBCDataSource){
		
		Rectangle winODBC = findComponentClass("Add a Data Source");
		
		try {

			Rectangle res = findString(ODBCDataSource, DEFAULT_CONTENT_FONT, winODBC, false);

			if (res != null)
				leftClickMid(res);			
		} catch (ImageNotFoundException e) {
			
			logger.fine(ODBCDataSource + " picture was not found: try again moving the focus to the first listed element, sorting differently the list");
			
			leftClickMid(findString("Data Source Name", DEFAULT_CONTENT_FONT, winODBC, false));
			
			// If I dont find the ODBC Data Source, I throw the exception: 
			// probably there´s not Source (maybe Quick Connection test failed). 
			Rectangle res2 = findString(ODBCDataSource, DEFAULT_CONTENT_FONT, winODBC, false);
			
			if (res2 != null)
				leftClickMid(res2);
		}
		

		
		
		delay(500);
		leftClickMid(this.findComponent("Connect", "Button", null));
		
		delay(8000);
		
		/*
		 * functionality is not allowed anymore since v2012
		 * remove it when we are sure that it will not be implemented in future 
		 * 
		logger.fine("DB2 Source Name?" + ODBCDataSource.equals(QuickConnectParameter.DB2_sourceName));
		logger.fine("Ora Source Name?" + ODBCDataSource.equals(QuickConnectParameter.Oracle_sourceName));
		logger.fine("Syb Source Name?" + ODBCDataSource.equals(QuickConnectParameter.Sybase_sourceName));
		
		if (ODBCDataSource.equals(QuickConnectParameter.DB2_sourceName) || 
			ODBCDataSource.equals(QuickConnectParameter.Oracle_sourceName) ||
			ODBCDataSource.equals(QuickConnectParameter.Sybase_sourceName)){

			logger.fine("No datascource Communication server window: it will appear late");
			
		}else{
			assertWindow("How Do You Want the Datasource to Communicate with the Server?");
			
			RadioOption h = new RadioOption("Natively", null, null, null, null, WINDOWS_DEFAULT_FONT);
			applyOption("How Do You Want the Datasource to Communicate with the Server?", h);

			leftClickMid(findComponent("OK", "Button", null));
			
		}
		*/
	}
	
	public void selectJDBCDataSource(String JDBCDriver, String username, String password, String databaseURL){
				
		TextFieldOption driver = new TextFieldOption("Driver", JDBCDriver);
		driver.setX2(150);
		driver.applyOption(this);
		
		TextFieldOption user = new TextFieldOption("Username", username);
		user.setX2(150);
		user.applyOption(this);
		
		TextFieldOption pwd = new TextFieldOption("Password", password);
		pwd.setX2(150);
		pwd.applyOption(this);
		
		TextFieldOption dbURL = new TextFieldOption("Database URL", databaseURL);
		dbURL.setX2(150);
		dbURL.applyOption(this);
		
		delay(500);
		leftClickMid(this.findComponent("Connect", "Button", null));
		
		delay(8000);
		
	}
	
	
	public void selectJDBConnection() {
	
		selectJDBC_ODBC("JDBC");
	}
	
	public void selectODBConnection() {
	
		selectJDBC_ODBC("ODBC");
	}
	
	private void selectJDBC_ODBC(String connection) {
	
		delay(200);
		assertWindow("Add a Data Source");
		
		RadioOption dbc = new RadioOption(connection, null, null, null, null,MS_SHELL_DLG_FONT);
		applyOptionsEnter("Add a Data Source", dbc);
	}

	
	
	
	public void selectQuickConnectMenu(String element, String DBsource){
		
		leftClickMenuItem("File", "Create a Database Connection...");
		delay(1000);
		assertWindow("Add a Data Source");
		
		
		Rectangle temp = findString(element, WINDOWS_DEFAULT_FONT);
		
		if (temp != null) {
			leftClickMid(temp);
			logger.finest(">>>" + element + " founded on " + temp); 
		}
		
		if (element.equals("ODBC Connections")){
			
			RadioOption c = new RadioOption("User DSN", null, null, null, null,MS_SHELL_DLG_FONT);
			applyOption("Add a Data Source", c);

		}else if(element.equals("JDBC")){
				
			assertWindow("Add a Data Source");
			
		}else if(element.equals("ADO Connections")){
		
			//TextFieldOption ado = new  TextFieldOption("Generate a valid connection string by clicking on the build button.", true, DBsource, null, null, null, null);
			//ado.setY1(150);
			//ado.applyOption(this);
			
			Rectangle hint = findComponentClass("Add a Data Source");
			
			Rectangle generateStr = findString("Generate a", MS_SHELL_DLG_FONT, hint, false);
			
			leftClick(generateStr.x+50, generateStr.y+150);
			
			typeString(" ");
			
			rightClick(generateStr.x+50, generateStr.y+150);
			
			leftClickMid(findString("Select All", WINDOWS_DEFAULT_FONT, hint, true));
			
			keyRelease(VK_CANCEL);
			
			typeString(DBsource);
			
			leftClickMid(this.findComponent("Connect", "Button", null));
			
		}else{
		
			RadioOption cc = new RadioOption(DBsource, null, null, null, null,MS_SHELL_DLG_FONT);
			applyOptionsEnter("Add a Data Source", cc);
		}
	}
	
	public void setADataSourceName(String dataSourceName){
				
		delay(4000);
		
		assertWindow("Set A Data Source Name");
		
		TextFieldOption tx = new TextFieldOption("Data Sources must be named.", true ,dataSourceName, null, null,  null, null,MS_SHELL_DLG_FONT);
		tx.applyOption(this);
		
		leftClickMid(findComponent("OK", "Button", null));
		
		delay(2000);
		
		//focus on DataSource to be sure to have a snapshot on Properties.
		// For some reason, is better to use a short part of the name and not the complete one.
		//added long dalay to manage the actual poor performance in Oracle and MySQL connnection 
		delay(10000);
		delay(10000);
		delay(10000);
		delay(10000);
		delay(10000);
		
		focusOnProjectName(dataSourceName);
		
		
	}

	public void focusOnProjectName(String project){
		
		Rectangle p = findComponentName("Project");
		leftClickMid(p);
		String sub_dataSourceName = null;
		sub_dataSourceName = (project.length() >= 6) ? project.substring(0, 6) : project;
		
		//I cut the first 70 px of Project (from top) pane because normally, in this range, there is the .qprj file name that can be the same of project name.
		//so, I just avoid to click in the "wrong" name. 
		Rectangle new_p = new Rectangle(p.x, p.y+70, p.width, p.height );
		delay(800);
		leftClickString(sub_dataSourceName, DEFAULT_CONTENT_FONT, Color.BLACK, new_p);
		
	}
	
	
	public void wordWrap() {
		leftClickMenuItem("SQL Editor", "Word Wrap");
		
	}

	public void toogleAllFolds() {
		leftClickMenuItem("SQL View", "All Folds"); 
		//Robot doesn´t find "Toggle All Folds" but it has no problem with "All Folds".
		
	}

	public void executeForDataEditing() {
		leftClickMenuItem("SQL Editor", "Execute for Data Editing");
		delay(500);
		
		escapeDialog("Editing of data is limited for this statement.", VK_ENTER);
		
	}
	
	public void insertBlockComment(){
		selectAll();
		leftClickMenuItem("SQL Editor", "Insert", "Insert/Remove Block Comment");
		
	}
	
	public void removeBlockComment(){
		
		leftClickMenuItem("SQL Editor", "Insert", "Insert/Remove Block Comment");
	}
	

	public void insertLineComment(){
		
		leftClickMenuItem("SQL Editor", "Insert","Insert/Remove Line Comment");
		
	}

	public void removeLineComment(){
		selectAll();
		leftClickMenuItem("SQL Editor", "Insert", "Insert/Remove Line Comment");
	}
	
	public void selectAll(){
		
		//keyTypeCtrl(VK_A);
		leftClickMenuItem("Edit","Select All");
	}

	public void insertRegion() {
		leftClickMenuItem("SQL Editor", "Insert", "Insert Region");
		delay(500);
	}

	public void insertTarget(String targetName) {
		
		leftClickMenuItem("SQL Editor", "Insert", "Insert Target");
		delay(500);
		
		keyType(VK_UP);
		delay(500);
		keyType(VK_END);
		delay(500);
		keyType(VK_BACK_SPACE);
		delay(800);
		
		typeString(targetName);
		delay(500);
	}

	public void messageView() {
		
		leftClickMenuItem("SQL Editor", "Message View"); //deselected item
		delay(1000);
		leftClickMenuItem("SQL Editor", "Message View"); //selected item
	}

	public void resultView() {
		
		leftClickMenuItem("SQL Editor", "Result View"); //deselected item
		delay(1000);
		leftClickMenuItem("SQL Editor", "Result View"); //selected item
	}

	public void formatSQL() {
		
		leftClickMenuItem("SQL Refactoring", "Format SQL"); 
		
	}

	public void newSQLEditor() {
		leftClickMenuItem("File", "New", "SQL Editor");
		delay(350);
		
		maximizeFileWindow();
		
	}

	public void newDesignEditor() {
		leftClickMenuItem("File", "New", "Design Editor");
		delay(350);
		
		maximizeFileWindow();
	}

	public void addSemicolons() {
		leftClickMenuItem("SQL Refactoring", "Add Semicolons");
		
	}
	
	public void removeSemicolons() {
		leftClickMenuItem("SQL Refactoring", "Remove Semicolons");
		
	}

	public void addQuotations() {
		leftClickMenuItem("SQL Refactoring", "Add quotation to identifiers");
		
	}

	public void removeQuotations() {
		leftClickMenuItem("SQL Refactoring", "Remove quotation from identifiers");
		
	}

	public String getViewName() {
		
		/*GregorianCalendar gc = new GregorianCalendar();
		
		return "view_"+ gc.get(Calendar.YEAR) + 
				  (gc.get(Calendar.MONTH)+1) + 
				   gc.get(Calendar.DATE) + 
				   gc.get(Calendar.HOUR) +
				   gc.get(Calendar.MINUTE) +
				   gc.get(Calendar.SECOND) ;
		*/
		
		return "View_test";

		
	}

	public void createViewAs(String viewName) {
		
		leftClickMenuItem("SQL Refactoring", "CREATE VIEW AS");
		delay(500);
		typeString(viewName);
		delay(500);
		
	}

	public void writeSelectOnView(String viewName) {
		
		newSQLEditor();
		String runViewStmt  = "Select * from ";
		
		typeString(runViewStmt + viewName + " ;");
		execute();
	}

	public void writedDropView(String viewName) {
		
		newSQLEditor();
		String runViewStmt  = "drop view ";
		
		typeString(runViewStmt + viewName + " ;");
		execute();
		
	}

	public void uppercaseKeywords() {
		
		leftClickMenuItem("SQL Refactoring", "Uppercase Keywords");
		delay(200);
	}

	public void resizePaneforQuickConnect() {
		
		setPaneSize(DatabaseSpyRobot.PROPERTIES, 580, 710);
		
	}

	public void expandColumnsForStarExp() {
		leftClickMenuItem("SQL Refactoring", "Expand columns for star");
		delay(500);

	}

	public void removeComments() {
		leftClickMenuItem("SQL Refactoring", "Remove Comments");
		delay(200);
		
	}

	public void removeCommentsAndFormatting() {
		leftClickMenuItem("SQL Refactoring", "Remove Comments and Formatting");
		delay(200);
		
	}

	public void createNewTable() {
		leftClickMenuItem("Design Editor", "Create New Table");
		delay(14000);
		//escapeDialog("DatabaseSpy", VK_ENTER);
		
		addEscapeDialogAction("DatabaseSpy has created the change scripr for the current action", VK_ENTER);

		waitAndEsacpe("I try to exit from Changing Script dialog.....");
		keyPress(VK_ENTER);
		
	
	}

	public void createNewColumn() {
		leftClickMenuItem("Design Editor", "Create New Column");
		delay(8000);
		keyPress(VK_ENTER);
		
	}

	public void addStickyNote() {
		leftClickMenuItem("Design Editor", "Add Sticky Note");
		
	}
	
	
	public void selectAllTables(){
		//leftClickMenuItem("Design Editor", "Select All"); function is not implemented 
		selectAll();
	}

	public void AddRelatedTables_ReferencedTables() {
		leftClickMenuItem("Design Editor", "Add related tables", "Referenced Tables");
		
	}

	public void AddRelatedTables_ReferencingTables() {
		leftClickMenuItem("Design Editor", "Add related tables", "Referencing Tables");
		
	}

	public void AddRelatedTables_AllRelations() {
		leftClickMenuItem("Design Editor", "Add related tables", "All Relations");
		
	}

	public void showInNewSQLEditor(SQLopType selectType) {
		leftClickMenuItem("Design Editor", "SQL and Data", "Show in new SQL Editor", selectType.toString());
		
		
	}

	public void selectUserTables() {
		leftClickMenuItem("Edit", "Select User Tables");
		
	}

	public void selectSystemTables() {
		leftClickMenuItem("Edit", "Select System Tables");
		
	}

	public void zoomIn() {
		leftClickMenuItem("Design Editor", "Zoom In");
		
	}
	
	public void zoomOut() {
		leftClickMenuItem("Design Editor", "Zoom Out");
		
	}
	
	public void zoomToFit() {
		leftClickMenuItem("Design Editor", "Zoom to fit");
		
	}

	public void autoLayoutWholeDiagram() {
		leftClickMenuItem("Design Editor", "Auto Layout whole Diagram");
		
	}

	public void autoLayoutSelectedTables() {
		leftClickMenuItem("Design Editor", "Auto Layout selected Tables");
		
	}

	public void removeFromDesign() {
		leftClickMenuItem("Design Editor", "Remove from Design");
		
	}

	public void deleteSelectedObject() {
		leftClickMenuItem("Design Editor", "Delete selected Object");
		
	}

	public void exportDatabaseData(String format, File exportFileName) {
		
		final String filePrefix = "export";
		
		leftClickMenuItem("Design Editor", "Export database data");
		delay(1500);
		
		assertWindow("Export database data");
		
		Rectangle exportWindow = findComponentClass("Export database data");
		Rectangle temp = findString(format+ "  ", WINDOWS_DEFAULT_FONT, exportWindow, false);
		
		if (temp != null) {
			leftClickMid(temp);
			logger.finest(">>>" + format + "   Found!"); 
		}	
		
		for (int i = 0; i < 2; i++) {

			Rectangle SQL = findString("SQL" , MS_SHELL_DLG_FONT, exportWindow, false);
			
			if (SQL != null) {
				//leftClickMid(SQL);
				doubleClickMid(SQL);
				logger.finest(">>> SQL radio button Found!"); 
			}
			
			delay(3000);

		}
		
		delay(1000);
		keyTypeAlt(VK_LEFT);
		delay(1000);
		keyType(VK_TAB);
		delay(250);
		keyType(VK_TAB);
		delay(250);
		keyType(VK_TAB);
		delay(250);
		keyType(VK_TAB);
		delay(250);
		
		typeString(filePrefix + format.replace(' ','_'));
		keyType(VK_TAB);
		delay(250);
		keyType(VK_TAB);
		delay(250);
		typeString(exportFileName.getParent());
		delay(500);

		
		leftClickString("Options", MS_SHELL_DLG_FONT);
		delay(1000);

		//new impl	
		
		if (format.equals("CSV")){
			
			if (getDelimiter() != null){
				
				leftClickString("Remove newlines", MS_SHELL_DLG_FONT);
				delay(500);
				keyPress(VK_MINUS);	
				delay(500);
				keyType(VK_TAB);
				delay(250);
				keyType(VK_TAB);
				delay(250);
				
				
				typeString(getDelimiter());				
			}
			
			
		}
		
		
		if (format.equals("CSV") || format.equals("HTML") || format.equals("Excel")){
			
			leftClickString("Include comments", MS_SHELL_DLG_FONT);
			
			if (!getIncludeComments()){
				keyType(VK_MINUS);	
			}else{
				keyType(VK_PLUS);
			}
			
		}
			
		
		leftClickMid(this.findComponent("Export", "Button", null));
		delay(3000);	
		
		escapeDialog("DatabaseSpy", VK_ENTER);
		
		//addEscapeDialogAction("The result of export:", VK_ENTER);

		//waitAndEsacpe("I try to import window.....");
		
		
		leftClickMid(this.findComponent("Close", "Button", null));
		delay(3000);	

		
		//set up of variables
		
		setLogFile(false);
		setDelimiter(null);
		setCreatePrimaryKeys(true);
		setIncludeComments(true);
		
	}

	private boolean getIncludeComments() {
		return exportComments;
	}
	
	public void setIncludeComments(boolean crateComments) {
		exportComments  = crateComments;
	}
	

	public void importDataToTheDatabase(String filename, String format, SQLopType type, String startPointOfImport){
		
		importDataToTheDatabase(filename, format, type, true, startPointOfImport);
	}
	
	
	
	public void importDataToTheDatabase(String filename, String format, SQLopType type, boolean generateSQLFile, String startPointOfImport) {
		
		leftClickMenuItem("Tools", "Import data to the database");
		
		delay(1500);
		assertWindow("Import data to the database");

		
		Rectangle ImportWindow = findComponentName("Import data to the database");
		
		Rectangle temp = findString(format+ "  ", WINDOWS_DEFAULT_FONT, ImportWindow, false);
		
		if (temp != null) {
			leftClickMid(temp);
			logger.finest(">>>" + format + "   Founded!"); 
		}
		
		TextFieldOption tx = new TextFieldOption(":", false ,filename, "Source", null,  null, "Selection",MS_SHELL_DLG_FONT);
		tx.setX2(150);
		tx.setY2(1);
		tx.applyOption(this);
		
	
	
		if (type.toString().equals("CREATE"))
			leftClickString("Create new table(s)", MS_SHELL_DLG_FONT, Color.BLACK, ImportWindow);
		
		else if (type.toString().equals("UPDATE"))
			leftClickString("Update existing tables", MS_SHELL_DLG_FONT , Color.BLACK, ImportWindow);
		
		else
			leftClickString("Update/Create if not existing", MS_SHELL_DLG_FONT, Color.BLACK, ImportWindow);

		delay(1000);
		
		
		if (generateSQLFile){
			leftClickString("Generate SQL in SQL Editor", MS_SHELL_DLG_FONT, Color.BLACK, ImportWindow);
		}else{
			
			leftClickString("Execute", MS_SHELL_DLG_FONT, Color.BLACK, ImportWindow);
			delay(500);
			
			if(getLogFile()){
				
				keyPress(VK_TAB);
				delay(1000);
				keyPress(VK_PLUS);
				delay(500);
				keyPress(VK_TAB);
				delay(1000);
				typeString(IMPORT_LOG_FILE.getAbsolutePath());
				
			}else{
				keyPress(VK_TAB);
				delay(1000);
				keyPress(VK_MINUS);
				
			}
			
			
		}
			
		delay(1000);
		
		/*
		 * Handling the Options tab
		 */
		
		leftClickString("Options", MS_SHELL_DLG_FONT, Color.BLACK, ImportWindow);
		delay(1000);
		
		if (format.equals("CSV")){
		
			leftClickString("First row contains column name", MS_SHELL_DLG_FONT, Color.BLACK, ImportWindow);
			delay(500);
			keyPress(VK_MINUS);
			delay(2000);
			

			keyType(VK_TAB);
			delay(500);
			keyType(VK_TAB);
			delay(500);

			
			if (getDelimiter() != null){
				
				typeString(getDelimiter());				
			}
				
		}else{
			
			//XML
			
			if (startPointOfImport != null || startPointOfImport.length() >0){
					
				keyTypeAlt(VK_F);  //Starting from (ALT + F)
				delay(1000);
				keyType(VK_TAB);
				typeString("europa");
				delay(2000);	
			}

			leftClickString("Create primary/foreign keys", MS_SHELL_DLG_FONT, Color.BLACK, ImportWindow);
			
			if (getCreatePrimaryKeys()){

				keyPress(VK_PLUS);
			}else{
				keyPress(VK_MINUS);
				
			}
			
		}	
			
		logger.finest(">>> generateSQLFile:" + generateSQLFile);
		
		if (generateSQLFile){
			
			//keyTypeAlt(VK_G);  //Generate SQL (ALT + G)
			//logger.finest(">>> VK_G");
			
			leftClickMid(this.findComponent("Generate SQL", "Button", ImportWindow));
			
			escapeDialog("DatabaseSpy", VK_ENTER);
			
			execute();
			
		}else{ 
			
			delay(1000);
			//keyTypeAlt(VK_I);  //Import (ALT + I)
			
			leftClickMid(this.findComponent("Import", "Button", ImportWindow));
			
			escapeDialog("DatabaseSpy", VK_ENTER);
		}
		
		delay(500);
		
		setLogFile(false);
		setDelimiter(null);
		setCreatePrimaryKeys(true);
		
	}
	
	/*
	 * Tool Import to the database methods 
	 * 
	 */
	
	public void setLogFile(boolean crateLogFile){
		
		logger.finest(">>>IMPORT setted LogFile:" + importLogFile);
		importLogFile  = crateLogFile;
		
	}
	
	private boolean getLogFile(){
		
		return importLogFile;
		
	}
	
	public void setDelimiter(String delim){
		
		importdelimiter=delim;
			
	}
	
	private String getDelimiter(){
		
		return importdelimiter;
		
	}
	
	public void setCreatePrimaryKeys(boolean primaryKeys){
		
		importPrimaryKeys  = primaryKeys;
		
	}
	
	public boolean getCreatePrimaryKeys(){
		
		return importPrimaryKeys;
		
	}
	
	/*
	 * 
	 * 
	 */
	

	public void cascade() {
		
		leftClickMenuItem("Window", "Cascade");
		
	}

	public void tileHorizontally() {
		
		leftClickMenuItem("Window", "Tile horizontally");
		
	}

	public void tileVertically() {

		leftClickMenuItem("Window", "Tile vertically");
		
	}

	public void onLineBrowser() {
		
		leftClickMenuItem("View", "Online Browser");
		
	}

	public void projectWindow() {
		
		leftClickMenuItem("View", "Project Window");
		
	}

	public void propertyWindow() {

		leftClickMenuItem("View", "Property Window");
		
	}

	public void outputWindow() {
		
		leftClickMenuItem("View", "Output Window");
		
	}

	public void databaseStructureChangeScript() {
		
		leftClickMenuItem("View", "Database Structure Change Script");
		
	}

	public void overviewWindow() {
		
		leftClickMenuItem("View", "Overview Window");
		
	}	
	public void maximizeFileWindow() {
		
		Rectangle r = getMainWindow();

		for (int i = 10; i <= 55; i += 15) {
			
			Point p = new Point(r.x, r.y - i);
						
			Rectangle window = NativeGUI.getWindowInfo(p.x, p.y).getLocation();
			if (window.contains(r)) {
				
				logger.finest("Found outer bounds of file window and try to maximize: "
								+ window);
				clickMaximize(p, window);
			} else {
				
				logger.finest("Did not find outer bounds of file window. Inner window: "
								+ r + ", left top corner: " + window);
			}
		}
	}
	
	public void openFile(String filename){
		
		leftClick("ID_FILE_OPEN");
		delay(2000);
		assertWindow("Open");
		typeStringEnter(filename);
		delay(3000);
		keyPress(VK_ESCAPE);
		
		maximizeFileWindow();
	}
	
	public void openFileNoMaximize(String filename){
		
		leftClick("ID_FILE_OPEN");
		delay(2000);
		assertWindow("Open");
		typeStringEnter(filename);
		delay(500);
		keyPress(VK_ESCAPE);

	}
	

	public void connect(String dataSource) {
		
		rightClickDataSource(dataSource);
		keyType(VK_C);
		
	}
	
	public void disconnect(String dataSource) {
		
		rightClickDataSource(dataSource);
		keyType(VK_D);
	}
	
	private void rightClickDataSource(String dataSource){
		
		Rectangle r = findString(dataSource , findPane(PROJECT), false);
		delay(500);
		
		rightClickMid(r);
		
		delay(1000);		
	}
	
	
	private Rectangle findPane(Pane p){
		
		Rectangle pan = activatePane(p);
		return pan;
	}
	
	private void expandStructure (Rectangle r, String... element){
		
		for (String string : element) {
			leftClickMid(findString(string, DEFAULT_CONTENT_FONT, r, false));
			delay(1000);
			keyType(VK_PLUS);
			delay(1000);
			keyType(VK_UP);
			delay(300);
		}
		
	}
	
	public void dragAndDropTable(String table, int newx, int newy){
		
		Rectangle r1 = null;
		
		try {

			r1 = findString(table ,DEFAULT_CONTENT_FONT, findPane(ONLINE_BROWSER), false);
			delay(1500);
			
			leftClickMid(r1);
			
			delay(1500);
			dragDrop(r1.x, r1.y, newx, newy);
			
			delay(1000);	

		} catch (Exception e) {
			// handle exception in case the "Online Browser" has the component no expanded. I will expand all and try angain
			expandStructure(r1, "OrgChart", "OrgChartDB", "ables", "User T");
			// as expandStructure(r1, "OrgChart", "OrgChartDB", "Tables", "User Tables"); , robot doesn´t work
			
			r1 = findString(table ,DEFAULT_CONTENT_FONT, findPane(ONLINE_BROWSER), false);
			delay(1500);
			
			leftClickMid(r1);
			
			delay(1500);
			dragDrop(r1.x, r1.y, newx, newy);
			
			delay(1000);	
			
		}
		
		
		
		
		
	}
	
	public void clickBrowserFunction(String obj, String... label){
		
		Rectangle hint = findPane(ONLINE_BROWSER);
		delay(500);
		
		
		Rectangle res = null;
		
		//I split the Database path in several array element: for eache path element, I will try to expand the DB structure
		String [] DBStringpath = obj.split("/");
		
		try {

			expandStructure(hint, DBStringpath);
			
			//then I select (right click) the last element of the array, that is the table name...my goal!!!
			res = findString(DBStringpath[DBStringpath.length-1], DEFAULT_CONTENT_FONT, hint, false);
			
			if (res != null)
				rightClickMid(res);
			
			for (String string : label) {
			
				leftClickMid(findString(string));
				delay(2000);
					
			}

		} catch (Exception e) {
			logger.finest(">>>>>>>>>>>>>>>>><<Exception on clickBrowserFunction:" + e.toString() ); 
			
		}
		
		escapeDialog("You do not have semicolons appended to the statement by default.", VK_Y);
		
	}
	

	public void newDataComparison(String LeftSide, String RightSide, String ... tables) {
				
		
		leftClickMenuItem("File", "New", "Data Comparison");
		delay(350);
		
		
		selectItemToCompare(LeftSide, side.Left_Side, tables);
		selectItemToCompare(RightSide, side.Right_Side, tables);
		
		leftClickMid(this.findComponent("OK", "Button", null));
		
		delay(30000);
		
		maximizeFileWindow();
		
		SortTablesAscending(comparison.Data_Comparison);
		autolayout(comparison.Data_Comparison);
		
	}
		
	
	/*
	 * Use this method only to disabled a pane that is already visible
	 * but is not disable by Menu. The Pane must be visible. 
	 */
	
	public void hidePane(Pane hidingPane){
		
		Rectangle hint = findPane(hidingPane);
		logger.finest("hint:" + hint);
		
		if (hint != null){ 
			 
			rightClick(hint.x+10, hint.y+10);
			delay(1000);
			leftClickMid(findString("Hide", WINDOWS_DEFAULT_FONT, hint, false));

		}	

	}

	private void selectItemToCompare(String dataSource, side selectedSide, String... items) {
		// TODO Auto-generated method stub
	
		assertWindow("Select Database Objects for Comparison");
		delay(1000);
		
		Rectangle compWin = findComponentName("Select Database Objects for Comparison");
		
//		Select left or right size
		Rectangle temp = findString(selectedSide.toString().replace('_', ' '), MS_SHELL_DLG_FONT, compWin, false);
		if (temp != null) {
			leftClickMid(temp);
			//logger.finest("Trovato 1");
		}

		delay(1000);
		
		//Select the data source from combo box
		DropDownOption d1 = new DropDownOption ("Data Source:", false, dataSource, null, null, null, null, DEFAULT_CONTENT_FONT);		
		d1.setTwiceFontDropDownOption(MS_SHELL_DLG_FONT);
		d1.setFont(MS_SHELL_DLG_FONT);
		d1.applyOption(this);

		//
		// I will use a smaller portion of the window "Select tables for Data Comparison" otherwise I will 
		// no chance to select the Source (Combo box value can be selected wrongly)
		//
		Rectangle newCompWin = new Rectangle(compWin.x, compWin.y+100, compWin.width, compWin.height-100);
		logger.finest("Cerco su" + newCompWin);
		//	Select source form window
		if (items[0].equals("ALL")){

			
			Rectangle temp0 = findString(dataSource, DEFAULT_CONTENT_FONT, newCompWin, false);
			
			if (temp0 != null) {
				
				leftClick((temp0.x-30), temp0.y);//(new Rectangle(temp0.x-70,temp0.y, temp0.width, temp0.height));	
			}
	
		}else{
			
			Rectangle temp00 = findString(dataSource, DEFAULT_CONTENT_FONT, newCompWin, false);

			rightClick((temp00.x-30), temp00.y);
			
			leftClickMid(findString("Expand", WINDOWS_DEFAULT_FONT, newCompWin, false));
			delay(1000);
			leftClickMid(findString("Children", WINDOWS_DEFAULT_FONT, newCompWin, false));
			delay(1000);
			
			for (String string : items) {
				
				Rectangle item = findString(string, DEFAULT_CONTENT_FONT, newCompWin, false);
				
				leftClick((item.x-30), item.y);
				delay(1000);
				
				
			}
		}
		
		
	}

	public void compareTables() {
		
		leftClickMenuItem("Data Comparison", "Compare tables");
		
		hidePane(MESSAGE);
		
	}

	public void mergeLeftToRight() {
		
		leftClickMenuItem("Data Comparison", "Merge Left to Right");
		
	}
	
	public void checkMerge(){
		
		escapeDialog("DatabaseSpy", VK_Y);
		delay(1000);
		escapeDialog("DatabaseSpy", VK_ENTER);
		
		
		compareTables();
		escapeDialog("DatabaseSpy", VK_Y);
		
	}

	
	public void mergeRightToLeft() {
		
		leftClickMenuItem("Data Comparison", "Merge Right to Left");
		
	}

	public void showResults() {
			
		leftClickMenuItem("Data Comparison", "Show results");	
	}

	public void showMergeScriptLeftToRight(comparison mode) {
		
		if (mode.equals(comparison.Data_Comparison))
		   leftClickMenuItem("Data Comparison", "SQL and Data", "Show merge script: Left to Right");
		else
			leftClickMenuItem("Schema Comparison", "Show merge script: Left to Right");
	}

	public void showMergeScriptRightToLeft(comparison mode) {
		
		if (mode.equals(comparison.Data_Comparison))
		   leftClickMenuItem("Data Comparison", "SQL and Data", "Show merge script: Right to Left");
		else
		   leftClickMenuItem("Schema Comparison", "Show merge script: Right to Left");
	}

	public void showRestoreScriptLeft() {

		leftClickMenuItem("Data Comparison", "SQL and Data", "Show restore script: Left");
				
	}

	public void showRestoreScriptRight() {

		leftClickMenuItem("Data Comparison", "SQL and Data", "Show restore script: Right");
		
	}

	public void SortTablesAscending(comparison mode) {
		
		if (mode.equals(comparison.Data_Comparison))
		   leftClickMenuItem("Data Comparison", "Sort tables", "Ascending");
		else
		   leftClickMenuItem("Schema Comparison", "Sort items", "Ascending");
	}

	public void SortTablesDescending(comparison mode) {
		
		if (mode.equals(comparison.Data_Comparison))
			leftClickMenuItem("Data Comparison", "Sort tables", "Descending");
		else
			leftClickMenuItem("Schema Comparison", "Sort items", "Descending");
	}

	public void SortTablesAscendingMappedFirst(comparison mode) {

		if (mode.equals(comparison.Data_Comparison))	
			leftClickMenuItem("Data Comparison", "Sort tables", "Ascending mapped first");
		else
			leftClickMenuItem("Schema Comparison", "Sort items", "Ascending mapped first");
	}

	public void SortTablesDescendingMappedFirst(comparison mode) {
		
		if (mode.equals(comparison.Data_Comparison))
			leftClickMenuItem("Data Comparison", "Sort tables", "Descending mapped first");
		else
			leftClickMenuItem("Schema Comparison", "Sort items", "Descending mapped first");
	}
	
	
	public void activateOptionDialogDataCompare(){
		
		leftClickMenuItem("Tools", "Options");
		
		assertWindow("Options");
			
		Rectangle options = findComponentName("Options");
		leftClickMid(findString("Date Compare", options, false));
		
		resetToPageDefault(options);
	
	}
	
	public void  DCOptionDialog_MapTablesAuto_off(){
		

		//RadioOption c = new RadioOption("Always", "Open Message Window", null, null, "Code Engineering");
		CheckboxOption c = new CheckboxOption ("Map tables automatically", false, "Automatic table and column mapping", null,  null, null,MS_SHELL_DLG_FONT);		
		this.applyOptionsEnter("Options", c);
		
		delay(1000);
		
	}

	public void resetToPageDefault(Rectangle options) {
		
		leftClickMid(this.findComponent("Reset to Page Default", "Button", options));
		
		escapeDialog("Do you really want to reset all settings on this page to their default values?", VK_ENTER);
		delay(1000);
		
	}

	public void resetOptionAndClose(){
		
		activateOptionDialogDataCompare();
		
		leftClickMid(this.findComponent("OK", "Button", null));
	}
	
	
	public void mapItems(comparison mode) {

		// Data_Comparison value is replaced into "Data Comparison"
		// Schema_Comparison value is replaced into "Schema Comparison"
		leftClickMenuItem(mode.toString().replace('_', ' '), "Map items");
	}

	public void unmapItems(comparison mode) {

		// Data_Comparison value is replaced into "Data Comparison"
		// Schema_Comparison value is replaced into "Schema Comparison"	
		leftClickMenuItem(mode.toString().replace('_', ' '), "Unmap items");
	}

	public void DCOptionDialog_ShowTablesExpanded_off() {
		
		CheckboxOption c = new CheckboxOption ("Show tables initially expanded", false, "Display Options", null,  null, null,MS_SHELL_DLG_FONT);		
		this.applyOptionsEnter("Options", c);
		
		delay(1000);

		
	}

	public void expandTables() {
		// Data_Comparison value is replaced into "Data Comparison"
		// Schema_Comparison value is replaced into "Schema Comparison"	
		leftClickMenuItem("Data Comparison", "Expand tables");
	}

	public void collapseTables() {
		
		leftClickMenuItem("Data Comparison", "Collapse tables");
	}
	
	public void expandItems() {

		// Data_Comparison value is replaced into "Data Comparison"
		// Schema_Comparison value is replaced into "Schema Comparison"	
		leftClickMenuItem("Schema Comparison", "Expand items");
	}

	public void collapseItems() {

		// Data_Comparison value is replaced into "Data Comparison"
		// Schema_Comparison value is replaced into "Schema Comparison"	
		leftClickMenuItem("Schema Comparison", "Collapse items");
	}

	

	public void autolayout(comparison mode) {
		
		leftClickMenuItem(mode.toString().replace('_', ' '), "Autolayout");
		
	}

	public void mapManuallyObject(String from, String to, String icon) {

		// I search the first string and the icon that must be on the right.
		
		Rectangle fromRect = findString(from, DEFAULT_CONTENT_FONT);
		logger.finest(">>>>>>>>>>>>>>>fromRect" + fromRect);
		
		Rectangle fromSearchingArea = new Rectangle(fromRect.x, fromRect.y-10, fromRect.width+300, fromRect.height+30);
		logger.finest(">>>>>>>>>>>>>>>newFromRect" + fromSearchingArea);
		
		/*try {
			//final File prova  = IOUtils.findFile("tag_list/PROVA.PNG");
			saveScreen(newFromRect, "prova.png");
			
			
		} catch (Exception e) {
			logger.finest(">>>>>>>>>>>>>>>Exception" + e.toString());
		}*/
		
		Rectangle iconRect=findImage(icon, fromSearchingArea, false);
		//logger.finest(">>>>>>>>>>>>>>>iconRect" + iconRect);
		
		//Now I search the destination
		
		Rectangle toSearchingArea = new Rectangle(iconRect.x, 0, 600, 800);
		logger.finest(">>>>>>>>>>>>>>>toSearchingArea" + toSearchingArea);
		
		Rectangle toRect = findString(to, DEFAULT_CONTENT_FONT, toSearchingArea, false);
		logger.finest(">>>>>>>>>>>>>>>toRect" + toRect);
		
		dragDropMid(iconRect, toRect);
		
		
	}
	
	public void refreshRootObject(String icon, String icon2){
		
		refreshRootObject(icon, icon2, null);
	}

	public void refreshRootObject(String icon, String icon2, String objectToRefresh) {

		Rectangle hint = findPane(ONLINE_BROWSER);
		Rectangle refreshIconRect = null;
		
		try {
			refreshIconRect = findImage(icon, hint, false);
			
		} catch (Exception e) {
			// In case the refresh icon is not active, I try to click 
			// to the connected DB icon...sometimes happened that icon is disabled
			// because focus is somewhere away. 
			
			Rectangle conncetedIconRec = findImage(icon2, hint, false);
			leftClickMid(conncetedIconRec);
			delay(500);
		}
		
		
	
		if (objectToRefresh != null) 
			leftClickMid(findString(objectToRefresh, DEFAULT_CONTENT_FONT ,hint, false));
		
		
		if (refreshIconRect != null){
		
			//when I found, I repeat the refresh 3 times...
			//Sometimes 1 or 2 times in not enought!!
			
			for (int i = 0; i < 3; i++) {
				
				leftClickMid(refreshIconRect);
				delay(3000);
			}
			
		
		}
		
	}

	public void modifyProperty(String propertyName, String value) {
		
		Rectangle hint = findPane(PROPERTIES);
		
		logger.fine("DS: >"+findString(propertyName, WINDOWS_DEFAULT_FONT, new Color(112, 112, 112, 0)));
		
		leftClickMid(findString(propertyName, WINDOWS_DEFAULT_FONT, new Color(112, 112, 112, 0)));		
		delay(1000);
		typeString(value);

	}

	public void testShowGroupingForExecution() {
		
		leftClickMenuItem("SQL Editor", "Show Groupings For Execution");
		
	}

	
	public void newSchemaComparison(String LeftSide, String RightSide, String ... tables) {
				
		
		leftClickMenuItem("File", "New", "Schema Comparison");
		delay(350);
		
		
		selectItemToCompare(LeftSide, side.Left_Side, tables);
		selectItemToCompare(RightSide, side.Right_Side, tables);
		
		leftClickMid(this.findComponent("OK", "Button", null));
		
		delay(12000);
		
		maximizeFileWindow();
		
		SortTablesDescending(comparison.Schema_Comparison);
		autolayout(comparison.Schema_Comparison);
		
	}

	public void compareItems() {
		
		leftClickMenuItem("Schema Comparison", "Compare items");
		
		hidePane(MESSAGE);
		
	}

	public void retriveData_allrows() {
		
		leftClickMenuItem("Design Editor", "SQL and Data", "Retrieve data", "All rows");
		delay(3000);
	}
	
	public void retriveData_first200rows() {
		
		leftClickMenuItem("Design Editor", "SQL and Data", "Retrieve data", "First 200 Rows");
		delay(3000);
	}
	
	public void editData() {
		
		leftClickMenuItem("Design Editor", "SQL and Data", "Edit Data");
		delay(3000);
	}
	
	public void scrollEndResultPane(String obj){
		
		Rectangle hint = findPane(RESULT);
		delay(1000);
		
		leftClickMid(findString(obj, DEFAULT_CONTENT_FONT, hint, false));
		delay(1000);
		
		keyType(VK_END);
		
				
	}
	
	public void editDataWithString(String _old, String _new){
		
		Rectangle hint = findPane(RESULT);
		delay(1000);
		
		Rectangle hint2 = findString(_old, DEFAULT_CONTENT_FONT, hint, false);
		
		doubleClickMid(hint2);
		delay(1000);
		doubleClickMid(hint2);
		
		//editText(51,52,53,54,55);
		typeString(_new);
		
		
	}
		

	public void navigationFirstStatement(){
		
		leftClickMenuItem("SQL Editor", "Navigation", "First Statement");
	}

	public void navigationLastStatement() {
		
		leftClickMenuItem("SQL Editor", "Navigation", "Last Statement");
	}

	public void navigationPreviousStatement() {
		
		leftClickMenuItem("SQL Editor", "Navigation", "Previous Statement");		
	}

	public void navigationNextStatement() {
		
		leftClickMenuItem("SQL Editor", "Navigation", "Next Statement");	
	}

	public void navigationSelectEntireStatement() {
		
		leftClickMenuItem("SQL Editor", "Navigation", "Select entire Statement");
	}

	public void insertRemoveBookmark() {
		
		leftClickMenuItem("SQL Editor", "Bookmarks", "Insert/Remove Bookmark");
	}

	public void goToNextBookmark() {
		
		leftClickMenuItem("SQL Editor", "Bookmarks", "Go to Next Bookmark");
	}
	
	public void addBookmarksTest(String ...bookmarks){
		
		for (String add_bm : bookmarks) {
			
			findSelection(add_bm);
			keyType(VK_LEFT);
			insertRemoveBookmark();
		}
		
	}

	public void goToPreviousBookmark() {
		
		leftClickMenuItem("SQL Editor", "Bookmarks", "Go to Previous Bookmark");
	}

	public void removeAllBookmarks() {
		
		leftClickMenuItem("SQL Editor", "Bookmarks", "Remove All Bookmarks");
	}
	
	public int getRandomInteger(){
		
		Random generator = new Random(new Date().getTime());
		return generator.nextInt();
		
	}

	
}
