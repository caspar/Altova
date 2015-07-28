package com.altova.robots;

import static java.awt.event.KeyEvent.VK_N;
import static java.awt.event.KeyEvent.VK_O;
import static java.awt.event.KeyEvent.VK_ENTER;


import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import com.altova.util.Settings;

/**
 * Simple robot for MS WinWord 2007 , which is used to compare RTF and DOCX output files
 * 
 * @author Richard Peer
 *
 */
public class MSWord2007Robot extends ApplicationRobot {
	
	public MSWord2007Robot() {
		super( "Microsoft Word", Settings.createProgramFilesPath("Microsoft Office\\OFFICE12"), "WINWORD.EXE" );
	}

	public void openFile(String filename){
		checkFile(filename);delay(500);
		keyTypeCtrl(KeyEvent.VK_O);delay(500);   //strg + O to open fileopen dialog
		assertWindow("Open");delay(500);
		typeStringEnter(filename);delay(8000);
		addEscapeDialogAction("Because this file was created", VK_ENTER);
		addEscapeDialogAction("The file name", VK_ENTER);
		waitAndEsacpe("");
	}
	
	public void closeStrgF4(){
		keyTypeCtrl(KeyEvent.VK_F4);   //strg + F4 to close active file
	}
	
	public void closeFile(){
		keyTypeCtrl(KeyEvent.VK_F4);
//		leftClickMid(findString("File", getApplicationWindow().getLocation(), false)); delay(2000);
//		leftClickMid(findString("Close", getApplicationWindow().getLocation(), false)); delay(2000);
	}
	public void exitApplication() {
		exitWithoutSave();
	}
	
	public void exitWithoutSave() {
		keyTypeAlt(KeyEvent.VK_F4);
//		leftClickMenuItem("File", "Exit  "); delay(1000);
//		leftClickMid(findString("File", getApplicationWindow().getLocation(), false)); delay(2000);
		//leftClickMid(findString("Exit", getApplicationWindow().getLocation(), false)); delay(2000);
//		keyType(KeyEvent.VK_X);
		addEscapeDialogAction("Do you want to save", VK_N);
		waitAndEsacpe("");
		delay(5000);
	}
}