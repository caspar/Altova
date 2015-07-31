package com.altova.mapforce;

import static com.altova.util.LoggerUtils.logger;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;

import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_HOME;
import static java.awt.event.KeyEvent.VK_N;
import static java.awt.event.KeyEvent.VK_TAB;
import static java.awt.event.KeyEvent.VK_Y;

import com.altova.nativegui.NativeGUI;
import com.altova.robots.ImageNotFoundException;
import com.altova.robots.Pane;
import com.altova.robots.ScriptMistakeException;
import com.altova.robots.VSnetRobot;
import com.altova.robots.VSnetRobotImpl;
import com.altova.util.Settings;
import com.altova.util.Settings.Application;

public class VSnetMapForceRobot extends MapForceRobot implements VSnetRobot {
	protected VSnetRobotImpl vsRobotImpl;
	
	public VSnetMapForceRobot() {
		super(Application.VSNET.getName(), Application.VSNET);
		
		vsRobotImpl = new VSnetRobotImpl(this);
	}
	
	public void leftClickMenuItem(String menu, String... items){
		
		if (Settings.isVS2010()){
			logger.fine("We are in VS2010");
			leftClickMenuItem(GRAY_IN_VS2010_MENU,menu,items);  
		}else{
			super.leftClickMenuItem(menu,items);
		}
		
	}
	
	public void maximizeWindow(){
		try{
			super.maximizeWindow();
		}catch(ImageNotFoundException e){
			
			maximizeWindow(GRAY_IN_VS2010_MENU);
		}
	}
	
	public void escapePluginDialogs(String message) {
		vsRobotImpl.escapePluginDialogs(message);
	}
	
	public void openFile(File file){
		leftClickMenuItem("File","Open","File...");
		delay(3000);
		assertWindow("Open File");
		typeStringEnter(file.getAbsolutePath());
	}
	
	/**
	 * Creates a new Mapping, Project file or Web Service Project
	 * @param: fileType -> valid parameters are "Mapping","Project File" or "Web Service" 
	 */
	public void newMFFile(String fileType){
		if(fileType.equalsIgnoreCase("Mapping")){
			leftClickMenuItem("File","New", "File");
			delay(3000);
			assertWindow("New File");
			keyType(VK_HOME);
			Rectangle newFileWdw =NativeGUI.getForegroundWindowInfo().getLocation();
			delay(500);
			leftClickMid(findString("MapForce Files", newFileWdw, false));
			delay(500);
			if(Settings.isVS2010()){
				leftClickMid(findString("Open",newFileWdw,false));
			}else{
				leftClickMid(findComponent("&Open", "Button", newFileWdw));
			}
			delay(1000);
		}else if((fileType.equalsIgnoreCase("Project File"))||(fileType.equalsIgnoreCase("Web Service"))){
			throw new ScriptMistakeException("Creation of new project file and web service project file are not supported in the plugins");		
		}else{
			throw new ScriptMistakeException("Please, specify a valid type as parameter: Mapping");		
		}
		
	}
	
	public void closeAllSaveNoChanges(){
		try {

			leftClickMenuItem("Window", "Close All Documents");
			delay(500);
			for (int i = 0; i < 3; i++) {
				escapeDialog("Save changes to", KeyEvent.VK_N);
				delay(500);
			}

		} catch (ScriptMistakeException e) {
			logger.fine("Could not close files - probably none open: " + e);
		}
	}
	
	public void startApplication() {
		super.startApplication();
		delay(3000);
		//We should close the VS Start Page to avoid misunderstandings when searching strings in VS 
		closeAllSaveNoChanges();
	}
	
	public void outputXslt(){
		outputXsltMenu();
	}
	
	public void outputXslt2(){
		outputXslt2Menu();
	}
	
	public void outputXq(){
		outputXqMenu();
	}
	
	public void outputJava(){
		outputJavaMenu();
	}
	
	public void outputCSharp(){
		leftClickMenuItem("Output", "C-Sharp");
	}
	
	public void outputCSharpMenu(){
		outputCSharp();
	}
	
	public void outputCpp(){
		outputCppMenu();
	}
	
	public void generateCodeIn(String language,File filepath){
		String lang_renamed=language;
		if(language.equalsIgnoreCase("C#")){
			lang_renamed="C-Sharp";
		}
		super.generateCodeIn(lang_renamed,filepath);
		
	}
	
	public void findDialog(String word, boolean wholewrdonly,boolean casesens,boolean ifnegtest,boolean findAll,Font dlgfont) {
		findDialog(word, wholewrdonly, casesens, ifnegtest, findAll,dlgfont,"Find and Replace","Quick Find");
	}
	
	/** This method is needed to be able to find all below items in the VS plugin,
	 * since an extra item acts as bridge between them
	 */
	public String getBridgeMenuItem(){
		return "MapForce";
	}
	
//	 Overriding enableShowPane for pane windows
	public Rectangle enableShowPane(Pane pane) {
		leftClickMenuItem("View", getBridgeMenuItem(), pane.getMenuItem());
		
		//in the stand-alone applications, and VS.Net, we don't need location feedback here
		//however in the Eclipse plugin, we do. Please see the methods which overrides this
		//in the Eclipse robots.
		return null;
	}
	
	public String getExtraHelpMenus(){
		return "MapForce Registration and Web Links";
	}
	
//	 This item is specific for MapForce
	public void applicationOnWeb() { 
		leftClickMenuItem("Help", getExtraHelpMenus(), "MapForce on the Internet");
	}
	
	public void aboutApplication() {
		leftClickMenuItem("Help",getExtraHelpMenus(),"About MapForce");
	}
}
