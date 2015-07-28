package com.altova.umodel.regression.gui;

import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.*;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.util.List;

import com.altova.nativegui.ComponentInfo;
import com.altova.nativegui.NativeGUI;
import com.altova.robots.ImageNotFoundException;
import com.altova.robots.Pane;
import com.altova.robots.VSnetRobot;
import com.altova.robots.VSnetRobotImpl;
import com.altova.util.IOUtils;
import com.altova.util.Settings;
import com.altova.util.Settings.Application;

public class VSnetUModelRobot extends UModelRobot implements VSnetRobot {

	
	public final static Color LINENUMBER_COLOR = new Color(43, 145, 175);
	protected static final File PROPERTIES_VS2010 = IOUtils.findFile("expected_images/VS2010_Properties_window.png");

	protected VSnetRobotImpl vsRobotImpl;
	
	public VSnetUModelRobot() {
		super(Application.VSNET.getName(), Application.VSNET);
		
		vsRobotImpl = new VSnetRobotImpl(this);
	}
	
	public void startApplication() {
		super.startApplication();
		delay(3000);
		Rectangle solexp =findComponentName("Solution Explorer");
		if(solexp!=null){
			leftClickMenuItem("View","Solution Explorer");
			delay(500);
			leftClickMenuItem("Window", "Auto Hide");	
		}
		//We should close the VS Start Page to avoid misunderstandings in VS 
		leftClickMenuItem("File","Close");
		
		//logger.fine("--------->DEACTIVATE");
		//Deactivate VS 2010 window Properties if is active
		//leftClickMenuItem("View", "Properties Window");
		//disableVS2010Properties();
		
	}

	public void maximizeWindow(){
		try{
			super.maximizeWindow();
		}catch(ImageNotFoundException e){
			
			maximizeWindow(GRAY_IN_VS2010_MENU);
		}
	}
	
public void leftClickMenuItem(String menu, String... items){
		
		if (Settings.isVS2010()){
			logger.fine("We are in VS2010");
			leftClickMenuItem(GRAY_IN_VS2010_MENU,menu,items);  
		}else{
			super.leftClickMenuItem(menu,items);
		}
		
	}

	protected Color getLineNumberColor() {
		return LINENUMBER_COLOR;
	}


	public void escapePluginDialogs(String message) {
		vsRobotImpl.escapePluginDialogs(message);
	}
	
	//File Menu overridden methods

	public void newPrj() {
		leftClickMenuItem("File","New","Project");
		delay(5000);
		assertWindow("New Project");
		keyType(VK_HOME);
		delay(500);
		Rectangle newproj =findComponent("New Project","#32770",null);
		leftClickMid(findString("UModel Projects", newproj, false));
		delay(500);
		keyType(VK_ENTER);
		delay(5000);
		//escapePluginDialogs("Escaping save changes to solution dialog"); does not work
		escapeDialog("Save changes", VK_N);
	}
	
	public void openPrj(String name) {
		checkFile(name);
		if (Settings.isVS2010()) { // This is needed for VS2010 . Otherwise,
			// the menu component is sometimes not found
			leftClick(30, 3);
		}
		leftClickMenuItem("File","Open","Project/Solution");
		delay(500);
		typeString(name);
		keyType(VK_ENTER);
		//escapePluginDialogs("Escaping save changes to solution dialog"); does not work
		delay(500);
		escapeDialog("Save changes", VK_N);
		//delay to prevent crash. see TTP #16055
		delay(1500);
		if(Settings.isVS2010()){
			escapeDialog("You should only open projects from a trustworthy source", VK_ENTER);
		}
		escapeLanguageNotSupportedDialogInPlugins();
	}

	public void closeAllDiagrams() {
		try{
		leftClickMenuItem("Window", "Close All Documents");
		}catch(IllegalArgumentException e){
			//This is thrown in VS2010
		}
	}
	
//	Overriding closeDiagram() for VS
	public void closeDiagram() {
		leftClickMenuItem("File", "Close");
	}
	
	
	public void saveReplacePrj(String name){
		//we need to activate the solution explorer window to enable this item
		leftClickMenuItem("View", "Solution Explorer");
		delay(500);
		super.saveReplacePrj(name);
		//escapePluginDialogs("Escaping plugin dialogs for saving"); does not work
		escapeDialog("Save changes", VK_Y);
	}
	
	//Overriding method so that exitWithoutSave() works as expected for VS 
	public String getStringToLookForInDialog(){
		return "Microsoft Visual Studio"; 
	}
	
	
	//Overriding importXMI method so that plugin dialog is escaped when necessary
	public void importXMI(String name){
		super.importXMI(name);
		logger.finest("Escaping dialog warning about content removal");
		escapeDialog("This command will remove the content",VK_Y);
	}
	
	//Overriding reloadProject for VS, as an escape of eclipse dialogs is for certain projects needed
	public void reloadProject(){
		super.reloadProject();
		escapeLanguageNotSupportedDialogInPlugins();
	}
	
	//Edit Menu overwritten methods
	
	//Overriding find/replace related methods for VS
	public void findNext() {
		logger.fine("Find next");
		leftClickMenuItem("Edit","Find and Replace", "Find Next");
	}
	
	
	public void findPrevious() {
		logger.fine("Find Previous");
		leftClickMenuItem("Edit","Find and Replace", "Find Previous"); 
	}
	
	public void replace(String toFind, String toReplace, boolean replaceAll, boolean wholewrdonly, boolean casesens,boolean justselec){
		replace(toFind,toReplace,replaceAll,wholewrdonly, casesens,justselec,"Find and Replace","Quick Replace");
	}
	
	//Overriding zoomFromMenu() for VS
	public void zoom(int z) {
		super.zoomFromMenu(z,"UModel","Zoom");

	}
	//The documentation window should be hidden afterwards in VS
	 public void viewOnOffDocumentation(){
		 enableShowPane(DOCUMENTATION);
	 }
	
	
	//VS needs an extra menuitem to access to the project menu
	
	public String getExtraProjectMenu(){
		return "UModel Project";
	}
	
//	this method has to be empty for the plugins, as the checck is just done in the app
	public void checkIncludeSubProject_byRef(File newproj){
		
	}
	
	//	 Overriding enableShowPane for activating windows
	public Rectangle enableShowPane(Pane pane) {
		leftClickMenuItem("View", "UModel", pane.getName());
		
		//in the stand-alone applications, and VS.Net, we don't need location feedback here
		//however in the Eclipse plugin, we do. Please see the methods which overrides this
		//in the Eclipse robots.
		return null;
	}
	
	//Overriding escapeJavaNotSupportedDialogInVs method to be able to escape the special dialog for java projects
	protected void escapeLanguageNotSupportedDialogInPlugins(){
		
		delay(1000);
		escapeDialog("This UModel project contains the language profile for ", VK_ESCAPE);
	}
	
	//View menu test: this item is not available in VS
	
	public void viewAllOnOffUModelWindows(){
		//do nothing
	}
	
	//Help menu overridden methods
	
	//VS needs an extra menuitem to access to the help menu
		
		public String getExtraHelpMenus(){
			return "UModel Registration and Web Links";
		}
	
	// This item is specific for Umodel
		public void applicationOnWeb() { 
			leftClickMenuItem("Help", getExtraHelpMenus(), "UModel on the Internet");
		}
		
		public void aboutApplication() {
			leftClickMenuItem("Help",getExtraHelpMenus(),"About UModel");
		}
		
		//UModelLink overridden methods
		
		public String getTestBasename(){
			return "VSnetUModel"+File.separator+"UModelLinkTest"+File.separator;
		}
		
		public void disableVS2010Properties(){
			
			rightClickImage(PROPERTIES_VS2010.getAbsolutePath());
			findString("Hide");
		}
}
