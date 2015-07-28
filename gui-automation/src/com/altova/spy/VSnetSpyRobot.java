package com.altova.spy;


import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;

import com.altova.robots.ImageRecognitionRobot.*;
import com.altova.nativegui.NativeGUI;
import com.altova.robots.ImageNotFoundException;
import com.altova.robots.Option;
import com.altova.robots.RadioOption;
import com.altova.robots.Pane;
import com.altova.robots.ScriptMistakeException;
import com.altova.robots.VSnetRobot;
import com.altova.robots.VSnetRobotImpl;
import com.altova.util.Settings;
import com.altova.util.Settings.Application;

public class VSnetSpyRobot extends SpyRobot implements VSnetRobot {

	

	static {

		PROJECT = new Pane("Solution explorer");
	}

	protected VSnetRobotImpl vsRobotImpl;
	
	public int totalShift = 0;
	//public boolean useLeftChoice = false;
	public final String USE_FILE_ON_LEFT_SIDE = "Active Server Page";
	public final String USE_FILE_ON_RIGHT_SIDE = "BizTalk Schema";

	public VSnetSpyRobot() {
		super(Application.VSNET.getName(), Application.VSNET);
		vsRobotImpl = new VSnetRobotImpl(this);
	}

	public void startApplication() {
		super.startApplication();
		delay(3000);
//		We should close the VS Start Page to avoid misunderstandings in VS 
		Rectangle solexp =findComponentName("Solution Explorer");
		if(solexp!=null){
			leftClickMenuItem("View","Solution Explorer");
			delay(500);
			leftClickMenuItem("Window", "Auto Hide");	
		}
		closeAll();
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
	
	// File Menu overridden methods

	public void openFile(String name) {
		openFile(name, "Open", "File...");

	}
	public void openFileWithXMLSpyEditorInVS(String name){
		checkFile(name);
		leftClickMenuItem("File", "Open","File..."); delay(1000);
		delay(1000);
		assertWindow("Open File");
		typeString(name); delay(200);
		keyType(VK_TAB);
		delay(2000);		
		openWithXMLSpyEditorInVS();
	}
	public void openWithXMLSpyEditorInVS() {
		// Dont select the Open but Open With
		keyType(VK_TAB);
		delay(2000);
		keyType(VK_DOWN);
		delay(2000);
		Rectangle temp2 = findString("Open With...", WINDOWS_DEFAULT_FONT);
		leftClickMid(temp2);

		delay(500);
		Rectangle openWithRect = findComponent("Open With", "#32770", null);
		delay(5000);
		assertWindow("Open With");
		delay(3000);

		int[] tarray = new int[] { VK_PAGE_DOWN, VK_PAGE_UP };
		// I search the string XMLSpy Editor in the window "Open With"
		for (int i = 0; i < tarray.length; i++) {

			try {
				Rectangle temp3 = findString("XMLSpy Editor", WINDOWS_DEFAULT_FONT, openWithRect, false);
				if (temp3 != null) {
					leftClickMid(temp3);
					break;
				}
			} catch (Exception e) {
				logger.finer("XMLSpy Editor not found. I move with the arrow " + tarray[i] + ".");
				keyType(tarray[i]);
			}

		}
		keyType(VK_ENTER);
	}
	
	public void saveFileAs(String name) {
		leftClickMenuItem("File", "As...");
		typeFileName(name);
		delay(5000);
	}

	public void closeAll() {
		leftClickMenuItem("Window", "Close All Documents");
		escapeGeneralDialogs("Waiting while closing all files");
	}
	
	public void closeSolution_InVS(){
		leftClickMenuItem("File", "Close Solution");
	}

	// Edit Menu overridden Methods

	public void find(String ToFind) {
		find(ToFind, "Find and Replace", "Quick Find");

	}
	
	public void findGridTextViewSpecific(String ToFind){
		findTextViewSpecific(ToFind, "Find and Replace", "Quick Find");

	}

	public void find(){
		leftClickMenuItem("Edit","Find and Replace","Quick Find");
	}

	public void replaceFirst(String toFind, String toReplace) {
		replaceFirst(toFind, toReplace, "Find and Replace", "Quick Replace");

	}
	
	//XSL Menu overridden methods only for VS2010
	public Rectangle findTreeWndInVS2010() {
		final Pane TREE_VIEW = new Pane("Tree View");
		final Pane LIST_VIEW = new Pane("List View");
		enableShowPane(TREE_VIEW);
		Rectangle tree_View=findString(TREE_VIEW.getName());
		enableShowPane(LIST_VIEW);
		Rectangle list_View=findString(LIST_VIEW.getName());
		if((list_View!=null)&&(tree_View!=null)){
			return tree_View;
		}else{
			return null;
		}
	}

	public void markAll(String word){
		markAll(word,"Find and Replace","Quick Find");
	}
	
	// Help Menu overridden methods


	public void applicationOnWeb() { // so that it works for XMLSpy
		leftClickMenuItem("Help", getExtraHelpMenus(), "XMLSpy on the Internet");
	}
	
	public void aboutApplication() {
		leftClickMenuItem("Help",getExtraHelpMenus(),"About XMLSpy");
	}

	// Overriding enableShowPane for activating window
	public Rectangle enableShowPane(Pane pane) {
		leftClickMenuItem("View", "XMLSpy Tool Windows", pane.getName());
		
		//in the stand-alone applications, and VS.Net, we don't need location feedback here
		//however in the Eclipse plugin, we do. Please see the methods which overrides this
		//in the Eclipse robots.
		return null;
	}

	// Overriding getExtraViewMenu to adapt View menu access in VS.net

	public String getExtraViewMenu() {
		return "XMLSpy View";
	}
	public String getExtraAuthenticMenu() {
		return "XMLSpy";
	}

	// Overriding getExtraHelpMenu to adapt Help menu access in VS

	public String getExtraHelpMenus() {
		return "XMLSpy Registration and Web Links";
	}
	
	//Authentic menu is now a submenu of XMLSpy menu
	public String getAuthenticMenuHolder() {
		return "XMLSpy";
	}
	

	// Escaping vs specific dialog boxes
	public void escapePluginDialogs(String message) {
		vsRobotImpl.escapePluginDialogs(message);
	}
	
	public void activateOptionsDialog(){
		leftClickMenuItem("Tools", "XMLSpy Options"); delay(1000);
	}
	
	
	
	public void newFile(String filetype) {
		
		if (filetype.equals("htm")) filetype= "(.htm)" ;
		else if (filetype.equals("Scalable Vector Graphics")) filetype= "SVG Document" ;
		
		
		else if (filetype.equals("Servlet 2.3 Deployment Descriptor ")) filetype= "XML Document" ; //XML document
		else if (filetype.equals("XML Query Language for DB2")) filetype= "XQuery file for DB2"; //XQuery for DB2
		else if (filetype.equals("XML Query Language")) filetype= "XQuery file (.xq)";
		else if (filetype.equals("XML Query Language ")) filetype= "XQuery file (.xql)" ;
		else if (filetype.equals("J2EE 1.3 Application  ")) filetype = findSecondaryWay(9, USE_FILE_ON_RIGHT_SIDE, filetype) ;
		else if (filetype.equals("XSL Stylesheet v2.0")) filetype = findSecondaryWay(26, USE_FILE_ON_LEFT_SIDE, filetype) ;
		else if (filetype.equals("XSLT Stylesheet v2.0")) filetype = findSecondaryWay(27, USE_FILE_ON_LEFT_SIDE, filetype) ;
		else if (filetype.equals("archive")) filetype = "Archive" ;
		else if (filetype.equals("XBRL Instance")) filetype= "XBRL file (.xbrl)" ;
		else if (filetype.equals("Web Service Description v1.1")) filetype= "WSDL version 1.1" ;
		else if (filetype.equals("Web Service Description v2.0")) filetype= "WSDL version 2.0" ;
		else if (filetype.equals("Scalable Vector Graphics")) filetype= "SVG Document" ;		
		else if (filetype.equals("Text file")) filetype= "Text Document" ;		
		else if (filetype.equals("XBRL Taxonomy Schema")) filetype= "XBRL Taxonomy Schema file" ;
		
	 	/* Microsoft office extentions
	 	 * till that the developers dont modify with the new names of the MS Offices files 
	 	 * Delete them when bug 33460 is fixed*/
	 	
		else if (filetype.equals("Word OpenXML"))filetype= "Microsoft Office Word OpenXML" ;
		else if (filetype.equals("MS Office Excel OpenXML"))filetype= "Microsoft Office PowerPoint" ;
		else if (filetype.equals("MS Office PowerPoint OpenXML"))filetype= "Microsoft Office Excel OpenXML" ;

		
		logger.fine("Start New File..EndFilter.<"+ filetype + ">");
		
		delay(2000);
		
		leftClickMenuItem("File", "New", "File...");
		delay(4000);
		assertWindow("New File");
		//Rectangle newproj = findComponent("New File","#32770",null);
		Rectangle newproj = findComponentName("New File");
		
		//logger.fine("newproj tatone:" + newproj);
		
		delay(1000);
		
		typeString("X");
	    delay(1000);
	    
	    if (Settings.isVS2010())
	    	selectNewFileList("XMLSpy Files", new Font("Tahoma", Font.PLAIN, 11), filetype, newproj );
	    else
	    	selectNewFileList("installed templates", new Font("Tahoma", Font.BOLD, 11), filetype, newproj );

				
	}	
	
	public String findSecondaryWay(int shift, String useOtherFile, String originalFileType){
				
		if (Settings.isVS2010()){
			
			return originalFileType;
		}else{
			totalShift = shift;		
			//useLeftChoice = leftName;
			return useOtherFile;
		}
		
				
	}
	
	public void scrollMousePointer(){
					
		for (int i = 0; i < totalShift; i++) {
				
			delay(1000);
			keyType(VK_DOWN);
			
		}
		totalShift = 0;	
			
	}
	
	
	
	public void scrollNewFile(String filetype, Rectangle new_doc_wind){	
				
		scrollNewFile(filetype, new_doc_wind, DEFAULT_CONTENT_FONT);

	}
	
	
	public void scrollNewFile(String filetype, Rectangle new_doc_wind, Font font){	
		
	   	for (double sc = 0.50; sc <= 1; sc += 0.50) {
			
	   		scrollWindow(new_doc_wind, sc);
	   	
	   		try {
				
	   			Rectangle temp = findString(filetype, font);
	   			if (temp != null) {
	   				leftClickMid(temp);
	   				break;
	   			}else{
				
	   			}
			
	   		} catch (ImageNotFoundException e1) {
	   			//
	   		}
	   	}
		
	}
	
	public void newFile(String filetype, RadioOption options, String dialogtype, String filename){
		newFile(filetype);
		delay(2000);
		
		/* Dont exist the window dialog as in XMLSpy 
		 * In this case, I dont manage this window and I continue (dont applay applyOptionsEnter(dialogtype, options); )
		 */
		if (dialogtype != null){ // I manage the microsoft X-files
		   if (dialogtype.equals("Create new XQuery file") || dialogtype.equals("Create new XSL/XSLT file")){ 
			 dialogtype = null;
			 options    = null;
		   }
		}
			
		if(options!=null||dialogtype!=null){
		
	    /* Move the focus from the option area: the risk is that the focus could dirt *
	     * the image recognition.                                                     *
	     *                                                                            *  
	     * Davide                                                                     */
		delay(500);
		keyType((KeyEvent.VK_DOWN));
		delay(500);
		keyType((KeyEvent.VK_DOWN));
		
		applyOptionsEnter(dialogtype, options);
		
		}
		
		if(filename!=null && options == null && (filetype.indexOf("XBRL Instance") == -1)){
		  // docX, xlsX e ppsX 
		  logger.fine("Saving the file:" + filename);
		  leftClickMenuItem("File","Save");
		  delay(3000);
		  typeStringEnter(filename);
		  delay(3000);
		  
		}else if ((filename!=null && options != null) || (filetype.indexOf("XBRL Instance") > -1) ){
			//for DTD/Schema
			// new behavior: when the window dialog is open, there´s not focus in the text area.
			// Robot will find the text area to have a focus to type the path.
			
			delay(3000);
			Rectangle forwind=NativeGUI.getForegroundWindowInfo().getLocation();
			logger.fine("forwind:"+forwind);
			try{
				Rectangle choosefile=findComponent("Choose a file", "Button",forwind);
				leftClick(choosefile.x+30,choosefile.y+20);	
			}catch(NullPointerException e){
				logger.finest("Exception in DTD/Schema window detection:" + e.toString());
				//do nothing as the two lines above are just necessary for a certain type of dialog
			}
			
			delay(500);
			typeFileName(filename);
			delay(1000);
		}
	}
	
	public void selectNewFileList(String text, Font useThisFont, String filetype, Rectangle newproj){
		//new Font("Tahoma", Font.BOLD, 11
		logger.fine("Enter in select features :" + text);
		Rectangle tmp = null;
		try{
		
			tmp =  findString(text, useThisFont);
		    logger.fine("Looking for:" + text);
		
		}catch(ImageNotFoundException e1){
			logger.fine("Could not find string" + text);
			
		}
		
		delay(2000);
		if (tmp != null){
		  leftClickMid(tmp);
		  delay(500);
		  
		}
		delay(500);
		
		
		try {
			//To 
			if (Settings.isVS2010()){
				
				searchInstalledTemplates(filetype, newproj, WINDOWS_DEFAULT_FONT);
			}else{
			
				Rectangle temp = findString(filetype, WINDOWS_DEFAULT_FONT);
				if (temp != null) {
					leftClickMid(temp);
				}
			}
			
		} catch (ImageNotFoundException e1) {
			logger.finer("VS First try not positive. I scroll down the bar");
				//for VS2008 and 2005
				scrollNewFile(filetype, newproj, WINDOWS_DEFAULT_FONT);
		}
		
	//}	//end for	
		
	scrollMousePointer();
	openWithXMLSpyEditorInVS();

	}

	private void searchInstalledTemplates(String filetype, Rectangle area, Font font) {
		
		final Color GREY_TEXT_COLOR = new Color(128, 128, 128, 0); 
		
		//leftClickMid(findString(filetype, font, Color.white, GREY_TEXT_COLOR, area, false));
		leftClickMid(findString("Search Installed Templates", font, Color.white, GREY_TEXT_COLOR, area, false));
		delay(500);
		
		typeString(filetype);
		
   		//try {
			// I need to generate a smaller rectangle because the filetype can be
			// found in filter text and in list file 
			
			Rectangle newarea = new Rectangle(area.x,
											  area.y+60,
											  area.width-250,
											  area.height);
			
			delay(1500);
   			Rectangle temp = findString(filetype, font, newarea, false);
   			
   			
   			if (temp != null) {
   				logger.fine(">>click to :" + temp );
   				leftClickMid(temp);
   			}else{
   				logger.fine(">>file type:" + filetype + " not found");
   			}
		
   		//} catch (ImageNotFoundException e1) {
   			//
   		//}
		
	}

	

}
