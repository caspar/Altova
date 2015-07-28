package com.altova.mapforce;

import static java.awt.event.KeyEvent.VK_D;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_HOME;
import static java.awt.event.KeyEvent.VK_TAB;
import static java.awt.event.KeyEvent.VK_Y;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;

import com.altova.nativegui.NativeGUI;
import com.altova.robots.EclipseRobot;
import com.altova.robots.EclipseRobotImpl;
import com.altova.robots.ImageNotFoundException;
import com.altova.robots.ImageRecognitionRobot;
import com.altova.robots.Pane;
import com.altova.robots.ScriptMistakeException;
import com.altova.util.RegressionAssert;
import com.altova.util.Settings.Application;

import static com.altova.mapforce.MapForceRobot.LIBRARIES;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.util.LoggerUtils.logger;

public class EclipseMapForceRobot extends MapForceRobot implements EclipseRobot{

	protected EclipseRobotImpl eRobotImpl;
	
	
	public EclipseMapForceRobot() {
		super(Application.ECLIPSE.getName(), Application.ECLIPSE);
		eRobotImpl = new EclipseRobotImpl(this);
	}
	
	public void startApplication() {
		eRobotImpl.preStartApplication();
		super.startApplication();
		eRobotImpl.postStartApplication();
	}
	
	protected boolean checkEscapeDialogActions() {
		eRobotImpl.checkEscapeDialogActions();
		return super.checkEscapeDialogActions();
	}
	
	public void escapePluginDialogs(String message) {
		eRobotImpl.escapePluginDialogs(message);
	}
	
	public void openFile(File file) {
		openFile(file, "Open File...");
		escapeDialog("Perspective is associated with this file type", VK_Y);
	}
	
	public void find(String word){
		super.find(word);
		escapeDialog("Find",KeyEvent.VK_ESCAPE);
	}
	
	public void closeAllSaveNoChanges(){
		super.closeAllSaveNoChanges();
		escapeDialog("Save Resources", VK_TAB, VK_D, VK_ENTER, VK_TAB, VK_ENTER);
	}
	
	public void startFromNewMapping(){
		openFile(AbstractMapForceTest.NEW_EMPTY_MAPPING_MFD);
	}
	
	public void saveFileAs(String newFilePath){
		saveFileAs(newFilePath,"As External...");
	}
	
	public void hideOverviewWindow(){
		//enableShowPane(MapForceRobot.OVERVIEW);
		try{
		eRobotImpl.closeEclipsePane("Overview",ImageRecognitionRobot.WINDOWS_DEFAULT_FONT,Color.BLACK);
		}catch(ImageNotFoundException e){
			logger.info("Overview window is already closed");
		}
	}
	
//	 Altova applications help has a menu entry in between
	public String getExtraHelpMenus() {
		return "MapForce Help";
	}
	
//	Overriding method applicationOnWeb to refer to XMLSpy
	public void applicationOnWeb() {
		leftClickMenuItem("Help", getExtraHelpMenus(), "MapForce on the Internet");
	}

	// Overriding method aboutApplication so that it fits for the Altova one
	public void aboutApplication() {
		leftClickMenuItem("Help", getExtraHelpMenus(), "About MapForce");
	}
	
//	 Overriding enableShowPane for activating output windows
	public Rectangle enableShowPane(Pane pane) {
		return eRobotImpl.enableShowPane(pane);
	}
	
	
//	Reload in eclipse is called revert
	public String getReloadMenuItem() {
		return "Revert";
	}
	
	public void exitWithuotSave() {
		super.exitWithuotSave();
		escapeDialog("Exit Eclipse SDK?", VK_ENTER);
	}
	
	//In Eclipse, we just assert the diagram,since, while asserting the libraries,
	//the robot clicks for some reason on the "Add/Remove Libraries" button
	public void assertLibrariesAndDiagram(){
		RegressionAssert.assertAreas(DIAGRAM_MAIN_WINDOW);
	}
}
