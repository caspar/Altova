package com.altova.spy;

import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_Y;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_UP;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.logging.Logger;
import static com.altova.util.LoggerUtils.logger;

import org.junit.BeforeClass;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.nativegui.NativeGUI;
import com.altova.robots.EclipseRobot;
import com.altova.robots.EclipseRobotImpl;
import com.altova.robots.ImageNotFoundException;
import com.altova.robots.ImageRecognitionRobot;
import com.altova.robots.Option;
import com.altova.robots.Pane;
import com.altova.robots.RadioOption;
import com.altova.util.Settings.Application;

public class EclipseSpyRobot extends SpyRobot implements EclipseRobot {

	protected static SpyRobot robot;

	protected EclipseRobotImpl eRobotImpl;

	final String xmlspy = "XMLSpy";
	
	protected int  IDNumber = 0;
	protected boolean changeNewFileName = false;

	public EclipseSpyRobot() {
		super(Application.ECLIPSE.getName(), Application.ECLIPSE);
		eRobotImpl = new EclipseRobotImpl(this);
		
		//workaround because in Eclipse the CCS and XQuery entry helper are not named correctly 
		CSS_OUTLINE = new SpyPane("Elements", "Entry Helpers");
		CSS_PROPERTIES = new SpyPane("Attributes", "Entry Helpers");
		CSS_ELEMENTS = new SpyPane("Entities", "Entry Helpers");
		
		XQUERY_KEYBOARDS = new SpyPane("Elements", "Entry Helpers");
		XQUERY_VARIABLES = new SpyPane("Attributes", "Entry Helpers");
		XQUERY_FUNCTIONS = new SpyPane("Entities", "Entry Helpers");

	}

	public void startApplication() {
		eRobotImpl.preStartApplication();
		super.startApplication();
		eRobotImpl.postStartApplication();
		activateSpyPerspective();
	}

	public void activateSpyPerspective() {
		
		leftClickMenuItem("Window", "Open Perspective", "Other");
		delay(1000);
		
		assertWindow("Open Perspective");
		
		leftClickMid(findString("XMLSpy", findComponentClass("Open Perspective"), false));
		delay(500);
		keyType(VK_ENTER);
			
	}

	protected boolean checkEscapeDialogActions() {
		eRobotImpl.checkEscapeDialogActions();
		return super.checkEscapeDialogActions();
	}

	public void openFile(String name) {
		openFile(name, "Open File...");
		escapePluginDialogs("Escaping activate perspective dialog");
	}

	//Reload in eclipse is called revert
	public String getReloadMenuItem() {
		return "Revert";
	}

	// Altova applications help has a menu entry in between
	public String getExtraHelpMenus() {
		return "XMLSpy Help";
	}

	//	Overriding method applicationOnWeb to refer to XMLSpy
	public void applicationOnWeb() {
		leftClickMenuItem("Help", getExtraHelpMenus(), "XMLSpy on the Internet");
	}

	// Overriding method aboutApplication so that it fits for the Altova one
	public void aboutApplication() {
		leftClickMenuItem("Help", getExtraHelpMenus(), "About XMLSpy");
	}

	// Overriding enableShowPane for activating output windows
	public Rectangle enableShowPane(Pane pane) {
		return eRobotImpl.enableShowPane(pane);
	}

	public void escapePluginDialogs(String message) {
		eRobotImpl.escapePluginDialogs(message);
	}

	public void setOptions(Option options) {
		eRobotImpl.setOptions(getAppNameWithoutAltova(), options);
	}

	public String getDiagramClass() {
		return eRobotImpl.getDiagramClass();
	}
	
	public void createSpyProjectInEclipse(){	
		
		Rectangle guiTestRect = projectAlreadyExist("gui-test-project");
		
		if (guiTestRect != null){			
			eRobotImpl.deleteProjectInEclipse();							
		}

	
		eRobotImpl.newJavaProject("gui-test-project");
		delay(5000);
		//escapeDialog("This kind of project is associated with the Java perspective.", VK_ESCAPE);
        eRobotImpl.activatePerspective("XMLSpy"); 
		

	}

public void newFile (String filetype){
	newFile(filetype, "");
	
}
	
public void newFile(String filetype, String radioName) {
		
		//if (filetype.equals("Active Server Page")) filetype= "Active Server Document" ;
		//if (filetype.equals("Scalable Vector Graphics")) filetype= "SVG Document" ;
	 	if (filetype.equals("XML Query Language")) filetype= "XML Query Language .(xq" ;
		else if (filetype.equals("XML Query Language ")) filetype= "XML Query Language .(xql)" ;
		else if (filetype.equals("XSL Stylesheet v2.0")) filetype= "XSL Stylesheet v1.0 " ;
		else if (filetype.equals("XSLT Stylesheet v2.0")) filetype= "XSLT Stylesheet v1.0 " ;
		else if (filetype.equals("Text file")) filetype= "Text Document" ;
		else if (filetype.equals("archive")) filetype= "Archive" ;		
		else if (filetype.equals("XBRL Instance")) filetype= "Extensible Business Reporting Language" ;
		else if (filetype.equals("Extensible Hypertext Markup")) filetype= "XHTML 1.1" ;
	 	
	 	/* Microsoft office extentions
	 	 * till that the developers dont modify with the new names of the MS Offices files 
	 	 * Delete them when bug 33460 is fixed*/
	 	
		else if (filetype.equals("Word OpenXML"))filetype= "Microsoft Office Word OpenXML Document" ;
		else if (filetype.equals("MS Office Excel OpenXML"))filetype= "Microsoft Office Excel OpenXML Workbook" ;
		else if (filetype.equals("MS Office PowerPoint OpenXML"))filetype= "Microsoft Office PowerPoint OpenXML Presentation" ;
	 	
		
		leftClickMenuItem("File", "New", "Other");
		delay(100);
		typeStringEnter("xmlspy file");
		delay(1000);
		keyType(VK_DOWN);
		delay(1000);
		keyType(VK_ENTER);
		clickButton("Next");
		
		Rectangle new_doc_wind = findComponentName("New XMLSpy file");
		
		try {
			Rectangle temp = findString(filetype, WINDOWS_DEFAULT_FONT, new_doc_wind, false);
			if (temp != null) {
				leftClickMid(temp);
			}
		} catch (ImageNotFoundException e1) {
			logger.finer("String not found. Maybe it is selected or I need to scroll the sidebar. We will try unselecting it");
			delay(500);
			
			scrollNewFile(filetype, new_doc_wind);
			
		}
				
		if (filetype.equals("Servlet 2.3 Deployment Descriptor ")){ //XML Document

			keyPress(VK_UP);
			delay(500);
			keyPress(VK_UP);
			delay(500);
			keyPress(VK_UP);
			delay(500);
			keyPress(VK_UP);
			delay(500);

			

		} else if (filetype.equals("XSL Stylesheet v1.0 ") || filetype.equals("XSLT Stylesheet v1.0 ") ) {
			keyPress(VK_DOWN);
			delay(500);
			
		}
		
		specifyLocationAndName(filetype, radioName);						
		delay(1000);
		escapePluginDialogs("Perspective is associated with this");
		
	}


public void scrollNewFile(String filetype, Rectangle new_doc_wind){	

	//boolean okNewDocument = false;		
	
   	for (double sc = 0; sc <= 1; sc += 0.25) {
	
   	scrollWindow(new_doc_wind, sc);
	try {
			
		Rectangle temp = findString(filetype, WINDOWS_DEFAULT_FONT, new_doc_wind, false);
		if (temp != null) {
			leftClickMid(temp);
			//okNewDocument = true;
			break;
		}else{
			
		}
		
	} catch (ImageNotFoundException e1) {
		logger.finer(">>>String not found. I try with the BLUE_SELECTED background and white font color...probably is a selected item...");
	
	}// 
		
   }//for
   	
   	
   	for (double sc = 0; sc <= 1; sc += 0.25) {
	
	
		/* Selected attempt: I restart again. Probably the field of new file was 
	 * selected (with blue color: RGB=). I will scroll all the menu new document
	 * with blue background 
	 */

	try {
		 Rectangle temp = findString(filetype, WINDOWS_DEFAULT_FONT, BLUE_SELECTED, TRANSPARENT);
    	 if (temp != null) {
			leftClickMid(temp);
			//okNewDocument = true;
			break;
		}else{
			
		}
    	 
    	 
    } catch (ImageNotFoundException e2) {
    }

    
   	}//for  
	
}


public void newFile(String filetype, RadioOption options, String dialogtype, String filename){
	
	String radioName = "";
	
	try {
		radioName = options.getRadioName();
	} catch (Exception e) {
		radioName = "";
	}
	
	
	newFile(filetype, radioName);
	delay(2000); 				
	
	/* 
	 * Doesnt exist the window dialog as in XMLSpy 
	 * In this case, I dont manage this window and I continue (dont applay applyOptionsEnter(dialogtype, options); )
	 */
	if (dialogtype != null){ // I manage the microsoft X-files
	   if (dialogtype.equals("Create new XQuery file") || dialogtype.equals("Create new XSL/XSLT file")){ 
		 //dialogtype = null;
		 //options    = null;  
		 return;
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
	delay(2000);
	applyOptionsEnter(dialogtype, options);
	
	}
	
		
	//filename = change the path: the c:\temp is forbidden;
		
		
	if(filename!=null && options == null){
	  // only for docX, xlsX e ppsX *** NOT NECESSARY ANYMORE ***  
	  //leftClickMenuItem("File", "Save As...");
	  //delay(3000);
		  
	  File tmp_filename = new File (filename);
		 
	  typeStringEnter(tmp_filename.getName());
	  delay(3000);
		  
	  try {
		  FileWriter copyOfFile = new FileWriter(tmp_filename);
		  
		  copyOfFile.write("");
		  copyOfFile.close();
			  
	} catch (Exception e) {
		// TODO: handle exception
		logger.finest("Exception in new FileWriter:" + e.toString());
	}
		  
		  
		  
	
		  
	}else if (filename!=null && options != null ){
		//for DTD/Schema		
		// new behavior: when the window dialog is open, there´s not focus in the text area.
		// Robot will find the text area to have a focus to type the path.
		
		delay(1000);
		Rectangle forwind=NativeGUI.getForegroundWindowInfo().getLocation();
		try{
			Rectangle choosefile=findComponent("Choose a file", "Button",forwind);
			leftClick(choosefile.x+30,choosefile.y+20);	
		}catch(NullPointerException e){
			//do nothing as the two lines above are just necessary for a certain type of dialog
			logger.finest("Exception in DTD/Schema window detection:" + e.toString());
		}
		
		
		typeFileName(" "+filename);
		

	
		
	}

	}



public void specifyLocationAndName( String ID, String radioName){
		
		// Searching Finish button		
		try {
			Rectangle temp = findString("Next", WINDOWS_DEFAULT_FONT);
			if (temp != null) 
				leftClickMid(temp);
				delay(2500);
				eRobotImpl.SpecifyCounterID(ID, radioName, IDNumber());
				
				Rectangle hintNewXMLSpyWindow = NativeGUI.getForegroundWindowInfo().getLocation();
								
				try {
					//Rectangle tempProject = findString("gui-test-project", WINDOWS_DEFAULT_FONT);
					Rectangle tempProject = findString("gui-test-project", hintNewXMLSpyWindow, false);
					if (tempProject != null) 
						leftClickMid(tempProject);
						delay(1500);

						
						
						try {
							Rectangle tempFinish = findString("Finish", WINDOWS_DEFAULT_FONT);
							if (tempFinish != null) 
								leftClickMid(tempFinish);
								delay(1500);
								
						
						} catch (ImageNotFoundException e1) {
							keyType(KeyEvent.VK_ENTER);
						}	

						
				
				} catch (ImageNotFoundException e1) {
					keyType(KeyEvent.VK_ENTER);
					logger.fine("gui-test-project NOT found");
				}
				
				
				

				
		
		} catch (ImageNotFoundException e1) {
			//NO button Next founded
		}	
		
		

	}
	
	public String IDNumber(){
		
		//return ""+(int)(Math.random() * 99999999);
		return ""+IDNumber++;
		
	}

	public Rectangle projectAlreadyExist(String project){
		
		try {
			Rectangle tempFinish = findString(project, WINDOWS_DEFAULT_FONT);
			if (tempFinish != null) 
				leftClickMid(tempFinish);
				delay(1500);
				return tempFinish;
				
		
		} catch (ImageNotFoundException e1) {			
			return null;
		}	

		
	}
	public String getExtraAuthenticMenu(){
		return null;
	}

	
}
