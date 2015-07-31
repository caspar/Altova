package com.altova.umodel.regression.gui;

import static com.altova.util.LoggerUtils.logger;

import java.io.File;
import java.util.List;

import net.hblok.io.FileFilterUtils;
import net.hblok.io.RegexFilenameFilter;

import com.altova.robots.AltovaApplicationRobot;
import com.altova.util.IOUtils;

/**
 * Implementation for the interface between the functional test
 * for UModel and the GUI framework. The main is to enable some
 * GUI action in between a series of steps in the functional test.
 * 
 * 
 * @author Havard Rast Blok
 *
 */
public class UModelGUIHandler implements InterfaceUModelGUI {

	UModelRobot robot;
	
	File outputPath;
	
	public UModelGUIHandler() {
		robot = new UModelRobot();
	}

	/*
	 * (non-Javadoc)
	 * @see com.altova.umodel.regression.gui.InterfaceUModelGUI#changeModelAndCode(java.io.File, java.io.File)
	 */
	public String changeModelAndCode(File umpFile, File instructions) {
		return changeModelAndCode(umpFile, instructions, null);
	}

	/*
	 * (non-Javadoc)
	 * @see com.altova.umodel.regression.gui.InterfaceUModelGUI#changeModelAndCode(java.io.File, java.lang.String, java.lang.String[])
	 */
	public String changeModelAndCode(File umpFile, String method, String... arguments) {
		return changeModelAndCode(umpFile, null, method, arguments);
		
	}
	
	private String changeModelAndCode(File umpFile, File instructions, String method, String... arguments) {
		if(outputPath == null) {
			throw new IllegalStateException("OutputPath not set");
		}
		
		logger.fine("changeModelAndCode. umpFile="+umpFile+", instructions file"+instructions+" (method="+method+", arguments="+arguments+")");
		
		try {
			robot.deleteSettingsRegistryKeys();
			robot.activateApplication();
			robot.maximizeWindow();
			
			robot.newPrj();
			//load the project
			robot.openPrj(umpFile.getAbsolutePath());
			//TODO: verify that the correct file is open
			//open the "Content of" diagram (let's assume it's there...)
			robot.openDiagram("Content of temp");
			
			//do the change
			if(instructions != null) {
				AltovaApplicationRobot.runCommands(instructions);
			}
			else if(method != null) {
				robot.runCommands(method, arguments);
			}
			
			//save as new project
			robot.saveReplacePrj(outputPath+File.separator+umpFile.getName());
			
			//generate code twice
			robot.modelToCode(null);
			robot.modelToCode(null); 
		} catch(Exception e) {
			    return IOUtils.getStackTrace(e);
		} finally {
			//close UModel again
			if(robot.isApplicationFront()) {
				robot.exitWithuotSave();
			}
		}
		
		return null;
	}

	public File getOutputPath() {
		return outputPath;
	}

	public void setOutputPath(File outputPath) {
		this.outputPath = outputPath;
	}

	public static void testInstructionFiles(String testCaseDir) {
		File dir = new File(testCaseDir);
		if(!dir.isDirectory()) {
			throw new IllegalArgumentException("Argument does not exist or not a directory: "+testCaseDir);
		}
		
		List<File> files = findInstructionsFiles(dir); 
		for(File f : files) {
			try {
				logger.fine("Checking file: "+f);
				AltovaApplicationRobot.runCommands(f, true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static List<File> findInstructionsFiles(File testCaseDir) {
		return FileFilterUtils.listfiles(testCaseDir, new RegexFilenameFilter("instructions.txt"), true);
	}
	
	/**
	 * For testing
	 * 
	 * @param args N/A
	 */
	public static void main(String args[]) {
		UModelGUIHandler.testInstructionFiles(args[0]);
	}

	/*
	private static void test1() {
		UModelGUIHandler h = new UModelGUIHandler();
		h.outputPath = new File("C:\\t");
		
		File ump = new File("C:\\Program Files\\Altova\\UModel2007\\UModelExamples\\BankView-start.ump");
		String method = "changeMemberField";
		String element = "Design-phase::Banking access::IBankAPI";
		String current = "isCreditCardAccount(in nAccountNr:int):boolean";
		String changed = "getMinimimBalance(in nAccountNr222:int):float";
		
		String ret = h.changeModelAndCode(ump, method, element, current, changed);
		
		if(ret != null) {
			System.out.println("Something failed: \n"+ret);
		}
	}
	*/

}
