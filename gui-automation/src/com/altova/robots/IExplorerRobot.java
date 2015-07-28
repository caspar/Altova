package com.altova.robots;

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
public class IExplorerRobot extends ApplicationRobot {
	
	public IExplorerRobot() {
		super( "Internet Explorer", Settings.createProgramFilesPath("Internet Explorer\\"), "iexplore.exe" );
	}

	public void openFile(String filename){
		checkFile(filename);delay(1000);
		leftClickMid(findString("File", getApplicationWindow().getLocation(), false)); delay(2000);
		keyType(KeyEvent.VK_O);delay(2000);
		assertWindow("Open");
//		keyTypeCtrl(KeyEvent.VK_O);   //strg + O to open fileopen dialog
		typeStringEnter(filename);delay(5000);
		
	}
	
	public void closeStrgF4(){
		keyTypeCtrl(KeyEvent.VK_F4);   //strg + F4 to close active file
	}

}