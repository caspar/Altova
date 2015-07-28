package com.altova.robots;

import static java.awt.event.KeyEvent.VK_ALT;
import static java.awt.event.KeyEvent.VK_CONTROL;
import static java.awt.event.KeyEvent.VK_F4;
import static java.awt.event.KeyEvent.VK_N;
import static java.awt.event.KeyEvent.VK_ENTER;


import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import com.altova.util.Settings;

/**
 * Simple robot for MS WinWord , which is used to compare RTF and DOCX output files
 * 
 * @author Richard Peer
 *
 */
public class MSWordRobot extends ApplicationRobot {
	
	public MSWordRobot() {
		super( "Microsoft Word", Settings.createProgramFilesPath("Microsoft Office\\OFFICE12"), "WINWORD.EXE" );
	}

	public void openFile(String filename){
		checkFile(filename);delay(1000);
		leftClickMid(findString("File", getApplicationWindow().getLocation(), false)); delay(2000);
		leftClickMid(findString("Open", getApplicationWindow().getLocation(), false)); delay(2000);
		delay(2000);
		assertWindow("Open");delay(500);
//		keyTypeCtrl(KeyEvent.VK_O);   //strg + O to open fileopen dialog
		typeStringEnter(filename);delay(8000);
		addEscapeDialogAction("Because this file was created", VK_ENTER);
		addEscapeDialogAction("The file name", VK_ENTER);
		waitAndEsacpe("");
	}
	
	public void openFileStrgO(String filename){
		checkFile(filename);delay(500);
		CtrlandKey(KeyEvent.VK_O);
		assertWindow("Open");delay(500);
		typeStringEnter(filename);delay(1000);
		waitAndEsacpe("");
	}
	
	public void closeStrgF4(){
		keyTypeCtrl(KeyEvent.VK_F4);   //strg + F4 to close active file
	}
	
	public void closeFile(){
		leftClickMid(findString("File", getApplicationWindow().getLocation(), false)); delay(2000);
		leftClickMid(findString("Close", getApplicationWindow().getLocation(), false)); delay(2000);
	}
	public void exitApplication() {
		exitWithoutSave();
	}
	
	public void exitWithoutSave() {
		leftClickMenuItem("File", "Exit  "); delay(1000);
		leftClickMid(findString("File", getApplicationWindow().getLocation(), false)); delay(2000);
		//leftClickMid(findString("Exit", getApplicationWindow().getLocation(), false)); delay(2000);
		keyType(KeyEvent.VK_X);
		addEscapeDialogAction("Do you want to save", VK_N);
		waitAndEsacpe("");
		delay(5000);
	}
	
	public void CtrlandKey(int key) {
		keyPress(VK_CONTROL);
		keyPress(key);
		keyRelease(key);
		keyRelease(VK_CONTROL);
		
		delay(2000);
	}
}