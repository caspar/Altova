package com.altova.robots;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import com.altova.nativegui.NativeGUI;
import com.altova.util.Settings;
import static com.altova.util.LoggerUtils.logger;

/**
 * Simple robot for Acrobat Reader, which is used to compare PDF output files
 * 
 * @author Richard Peer
 *
 */
public class AcrobatReaderRobot extends ApplicationRobot {
	
	public AcrobatReaderRobot() {
		super( "Adobe Reader", Settings.createProgramFilesPath("\\Adobe\\Acrobat 7.0\\Reader\\"),"AcroRd32.exe");
	}

	public void openFile(String filename){
		checkFile(filename);delay(1000);
		leftClickMid(findString("File", getApplicationWindow().getLocation(), false)); delay(2000);
		keyType(KeyEvent.VK_O);delay(2000);
		assertWindow("Open");
//		keyTypeCtrl(KeyEvent.VK_O);   //strg + O to open fileopen dialog
		typeStringEnter(filename);
	}
	
	public void closeStrgF4(){
		keyTypeCtrl(KeyEvent.VK_F4);   //strg + F4 to close active file
		
	}
/*	
	public void exitApplication() {
		throw new ScriptMistakeException("Not implemented yet");
	}

	public static void startapi() throws IOException {
		AcrobatReaderRobot robot = new AcrobatReaderRobot();
		robot.activateApplication();
	}
	
	public static void main(String[] args) {
		try {
			AcrobatReaderRobot.startapi();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
}