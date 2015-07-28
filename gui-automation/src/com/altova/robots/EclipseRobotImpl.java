package com.altova.robots;

import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.*;
import static com.altova.robots.ImageRecognitionRobot.WINDOWS_DEFAULT_FONT;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import com.altova.nativegui.ComponentInfo;
import com.altova.nativegui.NativeGUI;
import com.altova.spy.SpyPane;
import com.altova.util.IOUtils;
import com.altova.util.RegressionAssert;
import com.altova.util.RobotsCenter;
import com.altova.util.Settings;
import com.altova.util.Settings.Application;

public class EclipseRobotImpl implements EclipseRobot {

	protected AltovaApplicationRobot robot;

	private final File workspace = new File("c:\\temp\\automation_workspace");
	

	public EclipseRobotImpl(AltovaApplicationRobot robot) {
		this.robot = robot;

		// increase delay for Eclipse, since it's rather slow...
		robot.delayMultiply = robot.delayMultiply * 1.5;
	}

	public void preStartApplication() {
		IOUtils.deleteAll(workspace);
		robot.addEscapeDialogAction("Problems", VK_ENTER);
	}
		
	public void postStartApplication() {
		robot.delay(5000);
		try {
			robot.closeAll();
		} catch (ScriptMistakeException e) {
			logger.fine("Did not find close all menu item, as no file was open");
		}
		robot.delay(5000);

		robot.maximizeWindow();
		
		/*
		 * In case of Eclipse 4.2, I switch to Classic appearance 
		 * and I restart Eclipse to apply the change.
		 
		logger.finest("?ECLIPSE VALUE: " +  Application.ECLIPSE.getInstallLocation().toString());
		if (Application.ECLIPSE.getInstallLocation().toString().contains("4.2")){
			setClassicAppearanceAndRestart();
			checkEscapeDialogActions();
		}
		*/
		try{
			closeEclipsePane("Welcome", ImageRecognitionRobot.WINDOWS_DEFAULT_FONT, Color.BLACK);
		}catch(Exception e){
			//eclipse 3.3 case
			//closeEclipsePane("Welcome", ImageRecognitionRobot.WINDOWS_DEFAULT_FONT, Color.BLACK);
		}
		
		try{
			closeEclipsePane("Welcome.png");
			//closeEclipsePane("all//Welcome_cross_eclipse.png");
		}catch(Exception e){
		}
	}

	private void setClassicAppearanceAndRestart() {
		
		robot.leftClickMenuItem("Window", "Preferences");
		robot.delay(500);
		robot.typeStringEnter("Appearance");
		
		DropDownOption theme = new DropDownOption("Theme:", false, "Classic", null, null, null, null, WINDOWS_DEFAULT_FONT);
		theme.applyOption(robot);
		
		Rectangle ok = robot.findComponent("OK","Button",NativeGUI.getForegroundWindowInfo().getLocation());
		robot.leftClickMid(ok);
		
		robot.leftClickMenuItem("File", "Restart");
		robot.delay(3000);
		robot.escapeDialog("Problem saving workspace", VK_ENTER);
		robot.delay(10000);
		robot.delay(10000);
		robot.delay(10000);
		robot.delay(10000);
		robot.delay(10000);
		robot.delay(10000);
		
	}

	public void renameInEclipse(String new_name){
		robot.leftClickMenuItem("File","Rename");
		robot.delay(1000);
		robot.typeStringEnter(new_name);
		
	}
	
	public void closeEclipsePane(String name, Font font, Color color) {
	
		Rectangle window = robot.findString(name, font, color);
		robot.rightClickMid(window);
		robot.delay(500);
		Rectangle hint=new Rectangle(window.x,window.y,200,200);
		robot.leftClickString("Close",WINDOWS_DEFAULT_FONT,Color.BLACK,hint);
		robot.delay(2000);
	}
	
	public void closeEclipsePane(String imagePath)
	{
		robot.rightClickImage(imagePath);
		robot.leftClickOnString("Close", WINDOWS_DEFAULT_FONT);
	}

	public void checkEscapeDialogActions() {
		// special case for the "Workspace Launcher" launcher,
		// which cannot be escaped by only one key, since we want to type in a
		// full path.
		ComponentInfo info = NativeGUI.getForegroundWindowInfo();
		logger.finest("Front dialog: " + info);
		List<ComponentInfo> list = NativeGUI.getAllComponents(info.getLocation());

		if (robot.searchList(list, "Workspace Launcher")) {
			logger.fine("Found Workspace Launcher. Typing path");
			robot.typeStringEnter(workspace.getAbsolutePath());
			robot.delay(10000);
		}
	}

	public void escapePluginDialogs(String message) {
		logger.fine(message);
		robot.addEscapeDialogAction("Perspective is associated with this",VK_Y);
		robot.addEscapeDialogAction("Save Resources", VK_TAB, VK_D, VK_ENTER, VK_TAB, VK_ENTER);
		robot.addEscapeDialogAction("Save changes", VK_N);
		robot.addEscapeDialogAction("Exit Eclipse SDK?", VK_ENTER);
		robot.addEscapeDialogAction("Problem Occurred", VK_ENTER);
		
	}

	public void newJavaProject(String name) {
		robot.leftClickMenuItem("File", "New", "Project");
		robot.delay(4000);
		
		try{	
		
			robot.assertWindow("New Project");
			selectEclipseListItem("Java Project");
		}catch(ScriptMistakeException e){
			logger.finest("No need to do choose the type of project. A java project has already been chosen");
		}
		robot.delay(4000);
		robot.assertWindow("New Java Project");
		robot.typeStringEnter(name); 
		robot.delay(2000);
		robot.escapeDialog("Open Associated Perspective", VK_Y);
		
	}
	
	/**
	 * Select an item from a typical list in Eclipse and confirms. There are
	 * many similar list windows in Eclipse for selecting an item; a new
	 * project, perspective, and so on. They all share the nice functionality in
	 * that you can search for the item in a text field at the top. When you hit
	 * enter once, this item is selected. When you hit enter twice, the dialog
	 * selection is confirmed. This method takes care of the typing and two ENTERs.
	 * 
	 * @param item the item from the list to select and confirm.
	 */
	public void selectEclipseListItem(String item) {
		robot.typeString(item); robot.delay(500);
		robot.keyType(VK_ENTER); robot.delay(500);
		robot.keyType(VK_ENTER); robot.delay(1000);
	}
	
	public void importFile(File file,String JavaProjectname) {
		if(!file.exists()) {
			String msg = "File '"+file+"' does not exist.";
			logger.severe(msg);
			throw new ScriptMistakeException(msg);
		}
		
		//import from disk
		robot.leftClickMenuItem("File", "Import");
		robot.assertWindow("Import");
		selectEclipseListItem("File System");
		
		//type in directory
		robot.assertWindow("Import");
		Options option1=new Options();
		TextFieldOption fromDir=new TextFieldOption("From directory:",false,file.getParent(),null,null,null,null,WINDOWS_DEFAULT_FONT);
		option1.add((Option)fromDir);
		option1.applyOption(robot);
		//robot.typeString(file.getParent()); 
		robot.delay(500);
		robot.keyType(VK_TAB);	robot.delay(500);
		robot.keyType(VK_TAB);	robot.delay(500);
		
		//click right next to the file
		Rectangle hint = NativeGUI.getForegroundWindowInfo().getLocation();
		Rectangle r = null;
		//scrolling the Import directory...file might be so far
	   	for (double sc = 0; sc <= 1; sc += 0.25) {
			
		   	robot.scrollWindow(hint, sc);
		   	
			try {
					
				r = robot.findString(file.getName(), hint, false);
				if (r != null) { 
					robot.leftClickMid(r);
					//okNewDocument = true;
					break;
				}else{
					
				}
				
			} catch (ImageNotFoundException e1) {
				logger.finer(">>>String not found. Following to search..temp=" + r);
			
			}// 
				
		   }//for
		
		r.x -= 30;
		r.width = 5;
		robot.leftClickMid(r);
		Options option2=new Options();
		TextFieldOption intoFolder=new TextFieldOption("Into folder:",false,JavaProjectname,null,null,null,null,WINDOWS_DEFAULT_FONT);
		option2.add((Option)intoFolder);
		option2.applyOption(robot);
		//final press ENTER to confirm the dialog and finish
		//robot.keyType(VK_ENTER); 
		robot.leftClickMid(robot.findComponent("Finish", "Button", NativeGUI.getForegroundWindowInfo().getLocation()));
		robot.delay(2000);
	}
	
	public void exportFile(String dirToExport){
		robot.leftClickMenuItem("File", "Export");
		robot.assertWindow("Export");
		selectEclipseListItem("File System");
		robot.assertWindow("Export");
		Rectangle exportwindow = NativeGUI.getForegroundWindowInfo().getLocation();
//		type in directory. First, I have to position myself in the right place. Maybe it is not the best solution, but it works at least		
		robot.keyType(VK_TAB);	robot.delay(500);
		robot.keyType(VK_TAB);	robot.delay(500);
		robot.keyType(VK_TAB);	robot.delay(500);
		robot.keyType(VK_TAB);	robot.delay(500);
		robot.keyType(VK_TAB);	robot.delay(500);
		
		robot.typeString(dirToExport);
		robot.leftClickMid(robot.findString("Overwrite existing files without warning", WINDOWS_DEFAULT_FONT,exportwindow,false));
		robot.delay(500);
		//we type a "+" so that it is always selected
		robot.keyType(VK_PLUS);
		robot.delay(500);
		robot.leftClickMid(robot.findString("Create only selected directories", WINDOWS_DEFAULT_FONT,exportwindow,false));
		robot.keyType(VK_ENTER);
	}
	
//	Overriding getDiagramClass as the biggest component classname is different in eclipse
	public String getDiagramClass(){
		return "SWT_Window0";
	}
	
	public Rectangle enableShowPane(Pane pane) {
		try{
			return enableShowPane(pane.getName());
		}catch(FileNotFoundException r){
			logger.fine("Could not find pane");
			return null;
		}
	}
	
	public Rectangle enableShowPane(String name) throws FileNotFoundException {
		// first make sure the pane is selected
		logger.finest("Enabling '" + name
				+ "' by selecting active View in Eclipse.");
		try {
			robot.leftClickMenuItem("Window", "Show View", name);
		} catch (ScriptMistakeException e) {

			robot.leftClickMenuItem("Window", "Show View", "Other");
			robot.assertWindow("Show View");
			robot.typeString(name);
			robot.delay(1500);
			// use TAB and END to get to the bottom selection
			// this is for the cases for there both UModel and Eclipse have
			// similar views, e.g. Properties and Hierarchy
			robot.keyType(VK_TAB);
			robot.delay(700);
			robot.keyType(VK_END);
			robot.delay(700);
			robot.keyType(VK_ENTER);
		}

		// then search for the blue bar, which indicates a selected pane
		// this is slightly brittle, since this blue shading might change
		// However, if you find a better solution,
		// putting it in here will solve it for everything tested in Eclipse
		logger.finest("Locating '" + name
				+ "' by looking for the little blue bar.");
		Rectangle bar = null;
		// eclipse 3.2
		try {

			bar = robot.findImage("eclipse_selected_33.png");

		} catch (ImageNotFoundException mis) {
			logger
					.fine("Could not find the 3.3 shadowing. Maybe you are using 3.2 or 3.4");

		}

		// eclipse 3.3
		if (bar == null) {
			try {
				bar = robot.findImage("eclipse_selected.png");

			} catch (ImageNotFoundException mis) {
				logger
						.fine("Could not find package explorer. Maybe it is not selected");
			}

		}
		
		// eclipse 4.2 Classic Appearance
		if (bar == null) {
			try {
				bar = robot.findImage("eclipse_selected_42_classic.png");

			} catch (ImageNotFoundException mis) {
				logger
						.fine("Could not find package explorer. Maybe it is not selected");
			}

		}
		
		// eclipse 4.3 Classic Appearance
		if (bar == null) {
			try {
				bar = robot.findImage("eclipse_selected_43_classic.png");

			} catch (ImageNotFoundException mis) {
				logger
						.fine("Could not find package explorer. Maybe it is not selected");
			}

		}

		Rectangle ans = NativeGUI.getWindowInfo(bar.x, bar.y).getLocation();
		logger.finest("Found Eclipse window '" + name + "' at " + ans);

		return ans;
	}


	public void activatePerspective(String name) {
		robot.leftClickMenuItem("Window", "Open Perspective", "Other");
		robot.assertWindow("Open Perspective");
		
		Rectangle hint = NativeGUI.getForegroundWindowInfo().getLocation();
		Rectangle r = robot.findString(name, hint, false);
		robot.leftClickMid(r); robot.delay(500);
		robot.keyType(VK_ENTER); robot.delay(1000);
	}

	public void setOptions(String appName, Option options) {
		//open the Eclipse Preferences dialog
		robot.leftClickMenuItem("Window", "Preferences");
		robot.assertWindow("Preferences");
		
		//find the Altova application name page
		robot.typeString(appName); robot.delay(1000);
		robot.keyType(VK_ENTER); robot.delay(1000);
		
		//click the open button
		robot.leftClickString("Open "+appName, ImageRecognitionRobot.DEFAULT_CONTENT_FONT); robot.delay(500);
		
		//now do the Altova options stuff
		robot.applyOptions(options);
		
		//finally close the Eclipse Preferences dialog
		robot.keyType(VK_ESCAPE);
	}
	
	public void SpecifyCounterID(String newFileName, String radioName, String IDNumber){
	
		
		
		robot.keyType(VK_END);
		robot.delay(500);
		robot.keyType(VK_HOME);
		
		
		//I delete NewDocument and I leave only the extentions name (with the dot, of course)
		for (int i = 0; i < 11; i++) {
			robot.keyType(VK_DELETE);
			robot.delay(100);
		}
		
		robot.delay(500);
		robot.typeStringEnter(newFileName+ IDNumber +radioName.trim());
		robot.delay(1000);

	}
	
	public void deleteProjectInEclipse(){
		
		robot.delete();
		//robot.keyType(VK_DELETE); //delete project
		//robot.assertWindow("Confirm Project Delete"); //eclipse 3.3
		//robot.leftClickMid(robot.findString("Also delete contents under", NativeGUI.getForegroundWindowInfo().getLocation(), false)); 
		robot.delay(1000);
		robot.assertWindow("Delete Resources"); 
		robot.leftClickMid(robot.findString("Delete project contents on disk", NativeGUI.getForegroundWindowInfo().getLocation(), false)); 
		robot.delay(1000);
		
		try {
			Rectangle temp2  = robot.findComponent("OK", "Button", NativeGUI.getForegroundWindowInfo().getLocation());
			if (temp2 != null) {
				robot.leftClickMid(temp2);
			
			}
		} catch (ImageNotFoundException e2) {

			logger.finest("Button OK not found");
		}
		
	}
		
		
}
