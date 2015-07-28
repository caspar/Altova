package com.altova.umodel.regression.gui;

import static com.altova.robots.ImageRecognitionRobot.WINDOWS_DEFAULT_FONT;
import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.*;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

import com.altova.nativegui.ComponentInfo;
import com.altova.nativegui.NativeGUI;
import com.altova.robots.EclipseRobot;
import com.altova.robots.EclipseRobotImpl;
import com.altova.robots.ImageNotFoundException;
import com.altova.robots.ImageUtils;
import com.altova.robots.Option;
import com.altova.robots.Pane;
import com.altova.robots.RadioOption;
import com.altova.robots.ScriptMistakeException;

import com.altova.robots.Pane.PaneSize;
import com.altova.util.Settings.Application;

public class EclipseUModelRobot extends UModelRobot implements EclipseRobot {

	public final static Color LINENUMBER_COLOR = new Color(120, 120, 120);
	
	protected static int projectId = 0;
	
	
	protected EclipseRobotImpl eRobotImpl;
	
	public EclipseUModelRobot() {
		super(Application.ECLIPSE.getName(), Application.ECLIPSE);
		eRobotImpl = new EclipseRobotImpl(this);
	}
	
	public void startApplication() {
		eRobotImpl.preStartApplication();
		super.startApplication();
		eRobotImpl.postStartApplication();
	}
	
	protected int getProjectId() {
		
		return projectId;	
		
	}
	
	@Override
	public void newPrj() {
		//first, we'll have to create an Eclipse Java project to hold the UModel project
		//we first increment the test name variable
		projectId++;
		String javaProjectName="test"+(projectId+1)+"_"+(projectId-1)+"_"+projectId;
		eRobotImpl.newJavaProject(javaProjectName);
		
		// esacpeDiagramDialog(); too slow
		escapeDialog("Save changes", VK_N);
		delay(1000);
		escapeDialog("Automatically create diagrams", VK_N);
		delay(1000);
		escapeDialog("This kind of project is associated", VK_Y);
		try{
		eRobotImpl.enableShowPane("Package Explorer");
		}catch(FileNotFoundException e){
			logger.info("Package Explorer pane was not found");
			
		}
		//then we'll create the UModel project
		leftClickMenuItem("File", "New", "Other");
		assertWindow("New");
		eRobotImpl.selectEclipseListItem("UModel Project");
		
		//should we somehow specify the filename?
		//at least internally in this EclipeUModelRobot class?
		escapeDialog("Save changes", VK_N);
		escapeDialog("Automatically create diagrams for following new project", VK_N);
		//assertWindow("Create new UModel project file");
		delay(1500);

		keyPress(VK_ENTER);
		delay(3000);
		//esacpeDiagramDialog(); too slow
		//escapeDialog("Save changes", VK_N);
		delay(1000);
		//escapeDialog("Automatically create diagrams for following new project", VK_N);
	}

	@Override
	public void openPrj(String name) {
		try{
			eRobotImpl.enableShowPane("Package Explorer");
			}catch(FileNotFoundException e){
				logger.info("Pane was not found");
				
			}
		
		//first, we'll have to create an Eclipse Java project to hold the UModel project
		//we increment fist of all the test name id 
		projectId++;
		String projectName = "test"+(projectId+1)+"_"+(projectId-1)+"_"+projectId;
		eRobotImpl.newJavaProject(projectName);
		//esacpeDiagramDialog(); //too slow
		escapeDialog("Save changes", VK_N);
		delay(1000);
		escapeDialog("Automatically create diagrams", VK_N);
		delay(1000);
		escapeDialog("This kind of project is associated", VK_Y);
		
		//then we'll need to import (that is copy) the UMP file into this Eclipse project
		File file = new File(name);
		eRobotImpl.importFile(file,projectName);

		//now we need to "load" it.
		//TODO: This is maybe not the best solution, and should probably use some kind of
		//      Package Explorer navigation, similar to how the Model Tree navigation works,
		//      however, it will have to do for now...
		
		//Click on package explorer window,expand project, and move down (to make sure the project name is not high-lighted with white on blue background)
		Rectangle wholescreen=NativeGUI.getForegroundWindowInfo().getLocation(); //added new
		leftClick(wholescreen.x+20,wholescreen.height-50); //added new
		delay(500);
		keyType(VK_RIGHT); delay(500);
		keyType(VK_RIGHT); delay(500);
		
		//click the project name
		Rectangle r1 = findString(projectName);
		leftClickMid(r1);   delay(500);
		
		//right-click file name below project (which we just imported)
		Rectangle r2 = leftClickStringBelow(file.getName(), r1.y);delay(500);
		rightClick();  delay(500);
		
		// UModel -> Load
		// look a bit up here (50px), just in case the menu pops up above the file (if the file is far down on the screen)
		Rectangle r3 = leftClickStringBelow("UModel", r2.y - 50); 
		try{
			leftClickStringBelow("Load", r3.y - 20);
		}catch( ImageNotFoundException e){
			leftClickStringBelow("Load",r3.y-150);
		}
		delay(3000);
		//escapeLanguageNotSupportedDialogInPlugins(); //too slow
		escapeDialog("This UModel project contains the language profile for ", VK_ENTER);
		delay(1000);
		escapeDialog("Save changes to", VK_N);
		delay(1000);
		escapeDialog("This UModel project contains the language profile for ", VK_ENTER);
		delay(1000);
		escapeDialog("Automatically create diagrams", VK_N);
		//esacpeDiagramDialog(); //too slow
		delay(500);
		eRobotImpl.activatePerspective("UModel");
	}
	
//	Depending on whether we are working with the app, eclipse or VS, we'd like to open different files or not
	public void openStartProjectAppDependent(String projectname){
		
		//setGridSize(1); //we comment this bit, as it is not working for Eclipse and it is not that important
		openPrj(projectname);
	}
	
	//This method is needed in eclipse to clean our workspace before starting a new test 
	public void deleteProjectsInEclipseAfterTest(){
		try{
			eRobotImpl.enableShowPane("Package Explorer");
			}catch(FileNotFoundException e){
				logger.info("Pane was not found");
				
			}

		
		//looking for the Umodel's project dropdown to unload the project 
		Rectangle area=new Rectangle(0,20,(int)NativeGUI.getForegroundWindowInfo().getLocation().getWidth(),80);
		Rectangle r1 = findImage("eclipse_HelpIcon.gif",area,false);
		delay(500);
		Rectangle dropdownArea=new Rectangle(r1.x+r1.width,r1.y,200,r1.height);
		try {
			leftClickMid(findImage("eclipse_dropdown.PNG",dropdownArea,false));
		} catch (Exception e) {
			logger.info("Drop down button not found old style: search in Win 7 appearance");
			
			leftClickMid(findImage("eclipse_dropdown_windows7_appearance.png",dropdownArea,false));
		}

		logger.info(">>>>>LEFT CLICK BELOW: "+leftClickStringBelow("Unload Project", r1.y));
		delay(1000);
		
		escapeDialog("Save changes to", VK_N);
		
		//now, we delete all the existing projects
		try{
			eRobotImpl.enableShowPane("Package Explorer");
			}catch(FileNotFoundException e){
				logger.info("Pane was not found");
				
			}
		int temp=projectId;//change
		
		for(int i=1;i<4;i++){
			Rectangle r2=null;
			String projectName = "test"+(temp+1)+"_"+(temp-1)+"_"+temp;	
			try{
				r2=findString(projectName);
			}catch(ImageNotFoundException e){
				//do nothing
			}
			if(r2!=null){
				leftClickMid(r2);
				delay(1000);
				eRobotImpl.deleteProjectInEclipse();
				delay(3000);
				temp--;
			}else{
				break;
			}
				
		}
		
		
	}
	
	//This method has to be overidden for eclipse, as menu is located somewhere else
	public void closeAllDiagrams(){
		leftClickMenuItem("File", "Close All");
	}
	
	/**
	 * This method is needed in eclipse to disable the automatic synchronization, so that test images
	 *are kept clean. It does not affect,however,the standard application nor VS
	 */
	public void automaticSynchDisablingForEclipse(){
		delay(500);
		leftClickMenuItem("UModel", "Automatic synchronize Program Code from UModel Project");
		delay(500);
		leftClickMenuItem("UModel", "Automatic synchronize UModel Project from Program Code");
	}

	
	public void saveReplacePrj(String pathname){
		//first of all, we need to extract the parent folder and the filename
		File myproj =new File(pathname);
		String name=myproj.getName();
		String dirToSaveFileAt=myproj.getParent();
		checkDir(pathname);
		String currentprojectName = "test"+(projectId+1)+"_"+(projectId-1)+"_"+(projectId);
		try {
			eRobotImpl.activatePerspective("Java");
			eRobotImpl.enableShowPane("Package Explorer");
		} catch (FileNotFoundException e) {
			logger.info("Pane was not found");

		}
//		expand project, and move down (to make sure the project name is not high-lighted with white on blue background)
		keyType(VK_RIGHT); delay(500);
		keyType(VK_RIGHT); delay(500);
		Rectangle r2=null;
		Rectangle currproj=findString(currentprojectName);
		try{
			r2= findString(currentprojectName+".ump");
			if (r2 != null) {
				leftClickMid(r2);
			}
		}catch(ImageNotFoundException e){
			
			leftClickMid(currproj);
			delay(500);
//			now, I position myself in the UModelProject		
			keyType(VK_RIGHT); delay(500);
		}	
		
		if (r2 == null) {
			try {
				r2 = findString(currentprojectName + ".ump");
				if (r2 != null) {
					leftClickMid(r2);
				}
			} catch (ImageNotFoundException i) {
				logger.finest("Could not find "+currentprojectName + ".ump.Maybe the project is called differently");	
				leftClick(currproj.x+currproj.width,currproj.y+50);//click on the current ump project	
			}

		}
		
		delay(500);
		
		//first of all, we need to save the project
		rightClick();  delay(500);
		
		
		Rectangle packexp=findComponentClass("SysTreeView32");
		Rectangle fullwindow=NativeGUI.getForegroundWindowInfo().getLocation();
		Rectangle tosearch= new Rectangle(packexp.x,packexp.y,fullwindow.width,packexp.height);
		
		if (r2 != null) {
			leftClickStringBelow("UModel", r2.y - 50);

		} else {

			leftClickMid(findString("UModel", tosearch, false));
		}
//		 UModel -> Save
		
		leftClickMid(findString("Save",tosearch,true));
//		delay(3000);
//		//this should not be necessary, but we will wait till they fix the reload issue
//		leftClickMenuItem("File","Refresh");
		
		eRobotImpl.renameInEclipse(name);
//		
		//find Component reload
		delay(5000);
		Rectangle reloadDlg = NativeGUI.getForegroundWindowInfo().getLocation();
		leftClickMid(findComponent("Reload","Button",reloadDlg));
		delay(1000);
		escapeDialog("was not found", VK_ENTER);
		delay(2000);
		eRobotImpl.exportFile(dirToSaveFileAt);
		
		//Now, we change to the umodel perspective as, after all, we wanted to save a .ump file
		eRobotImpl.activatePerspective("UModel");
		
	}
	
	
	
	private Rectangle leftClickStringBelow(String string, int belowY) {
		Rectangle hint = NativeGUI.getForegroundWindowInfo().getLocation();
		hint.height -= belowY - hint.y;
		hint.y = belowY;
		Rectangle ans = findString(string, hint, false);
		logger.finest("Found '"+string+"' at "+ans);
		leftClickMid(ans); delay(500);
		return ans;
	}
	
	private void esacpeDiagramDialog() {
		//finally we need to escape dialog boxes
		escapePluginDialogs("Escape perspective dialog");
		escapePluginDialogs("Escaping warning about removing current project dialog");
		escapePluginDialogs("Escaping save changes dialog");
		escapePluginDialogs("Escaping language not supported dialog");
		addEscapeDialogAction("Automatically create diagrams", VK_N);
		waitAndEsacpe("Waiting for open diagram / project dialogs");
		escapePluginDialogs("Escaping reload dialogs");
		escapePluginDialogs("Escaping file not found dialog");
		activateApplication();
	}
	
	public void escapeLanguageNotSupportedDialogInPlugins(){
		esacpeDiagramDialog();
	}
	
	
	public void saveAllDiagramsAsImages(String dirpath,Option option){
		saveAllDiagramsAsImages(getProjectMenu(),dirpath,option);
	}
	
	public void importXMI(String name) {
		importXMIFromSpecificMenu(getProjectMenu(),name);
		delay(4000);
		esacpeDiagramDialog();
		delay(1000);
		esacpeDiagramDialog();
		delay(1000);
	}
	
	public void exportXMI(String name){
		exportXMIFromSpecificMenu(getProjectMenu(),name);
		
	}
	
//	this method is used in AbstractUmodelRobot to change the width of the panes depending of the app ( eclipse needs a wider one) 
	public void setModelTreeSizeAppDependent(){
		
		setModelTreeSize(PaneSize.EXTRAWIDE);
	}
	
//	this method is used in UModelLinkTest to change the width of the panes depending of the app ( eclipse needs a wider one) 
	public void setAppropiateModelTreeSizeAppDependent(){
		setModelTreeSize(PaneSize.LARGE);
	}
	
	//This method is just used in UModelLinkTest for eclipse, as the messages window is always present
	public void makeMessageWindowTinyInEclipse(){
		setPaneSize(UModelRobot.MESSAGES, -1, 50);
	}
	
	public void syntaxCheck(){
		super.syntaxCheck(getProjectMenu(), "Check Project Syntax");
	}

	public void zoom(int z) {
		super.zoomFromMenu(z, "Zoom");
	}
	
	 public void viewOnOffDocumentation(){
		//in eclipse, the documentation window is tabbed, so it does not disturb the tests
	 }
	
	public void layoutSameSize() {
		leftClickMenuItem("Layout","Make Same Size","Make Same Size");
		delay(2000);
	}
	
	protected String getProjectMenu() {
		return "UModel";
	}
	
	public String getExtraHelpMenus(){
		return "UModel Help";
	}
	
	public void setOptions(Option options) {
		eRobotImpl.setOptions("UModel", options);
	}
	
	@Override
	protected void leftClickElementIcon(String element) {
		activateEclipseDiagramDropdown();
		try{
			leftClickString(element);
		}catch(ImageNotFoundException e){
			logger.fine("String"+element+"could not be found");
			leftClick(element);
		}
	}
	
	public void linkElements(String linkType, String element1, String element2) {
		//make sure we know where the elements are.
		//these calls are re-done in the method linkElements(String, String)
		getElementLocation(element1); 
		getElementLocation(element2);
		
		//use B&W compare here, since some of link arrows are very small, 
		//and similar to other icons (e.g. Dependency and Print; Dependency and Association)
		super.compareState = PixelCompare.BLACK_WHITE;
		super.debugSuccess = true;
		try { 
			activateEclipseDiagramDropdown();
			delay(500);
			leftClick(linkType);
		} finally {
			super.debugSuccess = false;
			super.compareState = DEFAULT_PIXEL_COMPARE;
		}
		linkElements(element1, element2);
	}
	
	public void activateEclipseDiagramDropdown(){
//		first find the zoom button,
		//and then search for the little black dropdown icon next to it
		Rectangle zoom = findIcon("ID_VIEW_ZOOM_FIT_TO_WINDOW");
		Rectangle hint = new Rectangle(zoom.x+zoom.width, zoom.y, 200, 20);
		Rectangle dropdown = findImage("eclipse_dropdown.png", hint, false);
		
		//click the dropdown, and then the element on the list
		leftClickMid(dropdown); delay(500);
		
	}
	
	protected boolean checkEscapeDialogActions() {
		eRobotImpl.checkEscapeDialogActions();
		return super.checkEscapeDialogActions();
	}
	
	public Rectangle enableShowPane(Pane pane) {
		return eRobotImpl.enableShowPane(pane);
	}
	
	public String getDiagramClass(){
		return eRobotImpl.getDiagramClass();
	}
	
	//this method has to be empty for the plugins, as the checck is just done in the app
	public void checkIncludeSubProject_byRef(File newproj){
		
	}
	
	/**this method has to be empty for eclipse,as realization has to be done manually and test 
	* will therefore always fail when calling assertUModelMessageWindow **/
	
	public void checkMessageWindow(){
	}
	
	protected Color getLineNumberColor() {
		return LINENUMBER_COLOR;
	}

	public void escapePluginDialogs(String message) {
		eRobotImpl.escapePluginDialogs(message);
		addEscapeDialogAction("This kind of project is associated", VK_Y);
		addEscapeDialogAction("This command will remove the content of your current UModel", VK_Y);
		addEscapeDialogAction("Do you want to reload your UModel projectfile", VK_Y);
		addEscapeDialogAction("was not found", VK_ENTER);
		addEscapeDialogAction("This UModel project contains the language profile for ", VK_ENTER);
	}
	
	//for UmodelLinkTest()
	
	public void clickNewDiagram(String diagram){
		super.clickNewDiagram(diagram);
		esacpeDiagramDialog();
		
	}
	
	//View menu test: this item is not available in eclipse
	
	public void viewAllOnOffUModelWindows(){
		//do nothing
	}

//	 This items are specific for Umodel
	public void applicationOnWeb() { 
		leftClickMenuItem("Help", getExtraHelpMenus(), "UModel on the Internet");
	}
	
	public void aboutApplication() {
		leftClickMenuItem("Help",getExtraHelpMenus(),"About UModel");
	}
	
//	UModelLink overridden methods
	
	public String getTestBasename(){
		return "EclipseUModel"+File.separator+"UModelLinkTest"+File.separator;
	}
}

