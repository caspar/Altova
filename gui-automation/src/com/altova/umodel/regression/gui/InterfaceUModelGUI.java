package com.altova.umodel.regression.gui;

import java.io.File;

import com.altova.robots.AltovaApplicationRobot;

/**
 * 
 * This interface enables execution of UModel robot methods against a specified
 * UMP project file. The instructions passed to this interface has to match the signatures
 * of the {@link UModelRobot} class. Implementations of this class may including other
 * actions before or after the specified instructions, depending on the test to run.
 * 
 * Example of a single instruction, which will save the UMP file to a different name.
 * <code>
 * changeModelAndCode( "myprj.ump", "saveReplacePrj", "c:\\temp\\prj2.ump" );
 * </code>
 * 
 * In this second example, a text file containing instructions is loaded.
 * <code>
 * changeModelAndCode( "myprj.ump", "instructions.txt" );
 * </code>
 * For the format of the instructions file, see {@link AltovaApplicationRobot#runCommands(File)}.
 * 
 * @author Havard Rast Blok
 *
 */
public interface InterfaceUModelGUI {
	
	/**
	 * Loads the specified UMP file, executes the instructions specified in
	 * the second file and generates code. If any error are detected, a String
	 * object containing StackTrace output is returned. If everything seemed to work fine,
	 * null is returned.
	 * 
	 * @param umpFile the UModel project file to load
	 * @param instructions the set file containing the set of instruction to carry out
	 * @return null if no errors were detected, or a String containing details about any failures
	 */
	public String changeModelAndCode( File umpFile, File instructions );

	/**
	 * Loads the specified UMP file, and executes the specified instruction.
	 * If any error are detected, a String object containing StackTrace output is returned.
	 * If everything seemed to work fine, null is returned.
	 * 
	 * @param umpFile the UModel project file to load
	 * @param method the method in the robot to invoke
	 * @param arguments list of argument the method takes.
	 * @return null if no errors were detected, or a String containing details about any failures
	 */
	public String changeModelAndCode( File umpFile, String method, String... arguments );
	
	public File getOutputPath();

	public void setOutputPath(File outputPath);

}
	

