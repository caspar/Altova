package com.altova.util;

import static com.altova.util.LoggerUtils.logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.hblok.io.FileFilterUtils;

import com.altova.robots.ScriptMistakeException;

/**
 * A collection of basic File and URL utility methods. Including methods to find resources,
 * delete files, read basic text files, and convert a stack trace to a single String.
 * 
 * @author Havard Rast Blok
 *
 */
public class IOUtils {
	
	//avoid construction
	private IOUtils() {
	}

	/**
	 * Reads a basic text file and return a contents as a String for each line.
	 * 
	 * @param file the location of the text file
	 * @return a List of Strings where each element corresponds to a single line in the file
	 * @throws IOException if opening, reading or closing the file failed 
	 */
	public static List<String> readFileLists(String file) throws IOException {
		return readFileLists(findResource(file));
	}
	
	/**
	 * Reads a basic text file and return a contents as a String for each line.
	 * 
	 * @param url the location of the text file
	 * @return a List of Strings where each element corresponds to a single line in the file
	 * @throws IOException if opening, reading or closing the file failed 
	 */
	public static List<String> readFileLists(URL url) throws IOException {
		BufferedReader in = new BufferedReader( new InputStreamReader( url.openStream() ) );
		List<String> list = new ArrayList<String>();
		String line;
		while( (line = in.readLine()) != null ) {
			list.add(line);
		}
		in.close();
		
		return list;
	}

	/**
	 * Attempts to find the resource with the given name, and return its URL,
	 * or null if the resource was not found.
	 * 
	 * 
	 * 
	 * @param name the basic name of the resource
	 * @return the location of the specified resource, or null if it was not found.
	 */
	public static URL findResource(String name) {
		if(name == null) {
			throw new NullPointerException("Attribute name cannot be null.");
		}
		
		//first check if this is a regular file
		File file = new File(name);
		if(file.exists()) {
			try {
				return new URL("file:/"+file.getAbsolutePath());
			} catch (MalformedURLException e) {
				logger.warning("Error creating URL from file (continuing with classloader). \n"+IOUtils.getStackTrace(e));
			}
		}
		
		ClassLoader loader = IOUtils.class.getClassLoader();
		URL ans = loader.getResource(name);
		
		//if the resource is found at once, return it
		if( ans != null ) {
			logger.fine("Found resource: "+ans);
			return ans;
		}
		
		File localFile = findFile(name);
		if (localFile != null) {
			// return the first we find
			try {
				URL url = new URL("file:/" + localFile.getAbsolutePath());
				logger.fine("Found resource: " + url);
				return url;
			} catch (MalformedURLException e) {
				String msg = "Wrong file path based on: "+localFile;
				logger.severe(msg);
				throw new ScriptMistakeException(msg, e);
			}
		}
		
		logger.warning("Resource not found: "+name);
		return null;
	}
	
	/**
	 * Attempts to find the specified file in the current directory.
	 * If the string is a fully qualified path, and such a file exists, a File object
	 * of this will be returned. If not, a recursive search is performed in the user.dir
	 * directory, and the first occurrence which match is returned. If no file is found
	 * with a match name, null is returned.  
	 * 
	 * @param filename a full path, or just a simple find name  
	 * @return a File object to an existing file which matches the specified name/path,
	 * 			or null if nothing is found
	 */
	public static File findFile(String filename) {
		//search for sub dirs in the current user directory and down into sub dirs
		File userDir = new File( System.getProperty("user.dir") );
		return findFile(userDir, filename);
	}
	
	public static File findFileDiffDog(String directory,String filename) {
		//search for sub dirs in the current user directory and down into sub dirs
		File userDir = new File( "C:/work/gui-automation/data/diffdog/" + directory );
		return findFile(userDir, filename);
	}
	
	public static File findFile(File dir, String filename) {
		//first check if this is a regular file
		File file = new File(filename);
		if(file.exists()) {
			return file;
		}
		
		//search for sub dirs in the specified directory and down into sub dirs
		List<File> subdirs = IOUtils.getSubDirs(dir);
		subdirs.add(dir);
		
		//for each of the sub dirs, try to append the resource path
		for(File d : subdirs) {
			File testPath = new File(d.getAbsolutePath()+File.separator+filename);
			
			if(testPath.exists()) {
				//return the first we find
				logger.fine("Found local file: "+testPath);
				return testPath;
			}
		}
		
		logger.warning("File not found: "+filename);
		return null;
	}

	/**
	 * List all sub directories of the specified directory.
	 * 
	 * @param dir the base directory to start listing in
	 * @return a list of all directories and sub-directories found.
	 */
	public static List<File> getSubDirs(File dir) {
		return FileFilterUtils.listDirectories(dir, true);
	}
	
	/**
	 * Delete all files and directories, including the one specified - NO QUESTIONS ASKED - BE CAREFUL!! 
	 * If the directory to be deleted, does not exist, nothing is done, and true is returned.
	 * 
	 * @param dir The directory to remove 
	 * @return true if all files and directories where removed (or already gone), false otherwise 
	 */
	public static boolean deleteAll(File dir) {
		if(!dir.exists()) {
			//if the directory we want to delete, is already gone, do nothing.
			return true;
		}
		
		List<File> files = FileFilterUtils.listfilesRecursive(dir);
		files.add(dir);
		//reverse sort by length of filename, ensuring that files and sub-directories are
		//delete before their super directories
		Collections.sort(files, new Comparator<File>() {
			public int compare(File o1, File o2) {
				if(o1 == null && o2 == null) {
					return 0;
				}
				
				if(o1 == null) {
					return 1;
				}
				
				if(o2 == null) {
					return -1;
				}
				
				int l1 = o1.getAbsolutePath().length();
				int l2 = o2.getAbsolutePath().length();
				return (int) Math.signum(l2-l1);
			}
		});
		
		//then delete the files
		boolean ans = true;
		for(File f : files) {
			boolean sucess = f.delete();
			ans &= sucess;
			if(!sucess) {
				logger.warning("Failed to delete "+f);
			}
		}
		
		return ans;
	}
	
	/**
	 * Returns the stacktrace of the specified {@link Throwable} as a String. 
	 * 
	 * @param t the Throwable from a try/catch, etc.
	 * @return the stacktrace list formatted as a String
	 */
	public static String getStackTrace(Throwable t) {
		StringWriter stringWritter = new StringWriter();
        PrintWriter printWritter = new PrintWriter(stringWritter, true);
	    t.printStackTrace(printWritter);
	    printWritter.flush();
	    stringWritter.flush(); 

	    return stringWritter.toString();
	}

	public static String getFileId() {
		int id = (int)(Math.random()*1000.0);
		return ""+id;
	}




}
