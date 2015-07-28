package com.altova.robots;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import static com.altova.util.LoggerUtils.logger;
import com.altova.util.Settings;

/**
 * Simple robot for Excel, which is used to get the scroll bar icons.
 * 
 * @author Havard Rast Blok
 *
 */
public class ExcelRobot extends ApplicationRobot {

	public ExcelRobot() {
		super( "Microsoft Excel", Settings.createProgramFilesPath("Microsoft Office\\OFFICE14"), "EXCEL.EXE" );
	}
	
	public static void checkAndFixScrollBar() throws IOException {
		ExcelRobot robot = new ExcelRobot();
		logger.warning("Warning! This application will only work if a version not newer than MS Office 2003 is installed in your PC");
		robot.activateApplication();
		robot.saveScrollBarImages();
	}
	
	public Rectangle findScrollBar() {
		return findComponentClass("ScrollBar");
	}
	
	private void saveScrollBarImages() throws IOException {
		Rectangle bar = findScrollBar();
		if(bar == null) {
			throw new ScriptMistakeException("Did not find scroll bar");
		}
		Rectangle up = new Rectangle(bar.x+1, bar.y+1, 13, 13);
		Rectangle down = new Rectangle(bar.x+1, bar.y+bar.height-15, 13, 13);

		findScrollSlider(bar);
		
		System.setProperty("out", System.getProperty("user.dir"));
		File outUp = saveScreen(up, BAR_ENABLED_UP);
		File outDown = saveScreen(down, BAR_ENABLED_DOWN);
		
		System.out.println("Files written to:");
		System.out.println(outUp);
		System.out.println(outDown);
			
	}
	
	public void exitApplication() {
		throw new ScriptMistakeException("Not implemented yet");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ExcelRobot.checkAndFixScrollBar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
