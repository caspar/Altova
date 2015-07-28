/*
    Blok Utils - Various utility classes in the hblok.net domain.  
    Copyright (C) 2005  Havard Rast Blok
    http://hblok.sourceforge.net
    
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.
    
    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.
    
    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

package net.hblok.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Convenience methods for retrieving list of file from a single directory,
 * or recursively in a directory hierarchy. 
 * 
 * @author Havard Rast Blok
 *
 */
public class FileFilterUtils {
	
	private static final DirectoryFileFilter DIRS = new DirectoryFileFilter();
	
	//Suppresses default constructor, ensuring non-instantiability.
	private FileFilterUtils() {
		
	}

	/**
	 * List all files and sub directories of the specified directory, according
	 * to the specified filter. If the recursive flag is true, these sub
	 * directories are also searched recursively.
	 * 
	 * @param directory
	 *            the base directory to start listing in
	 * @param filter
	 *            the FileFilter which is applied to each file and directory
	 *            during the retrial
	 * @param recursive
	 *            if true, iterate all sub directories as well
	 * @return a list of all the files and directories found, 
	 * 			or and empty list if directory did not exists, or there was an IO error.
	 */
	public static List<File> listfiles(File directory, FileFilter filter, boolean recursive) {
		if(directory == null) {
			throw new NullPointerException("directory argument cannot be null");
		}
		
		List<File> ans = new ArrayList<File>();
		File files[] = directory.listFiles(filter);
		
		//if the directory did not exist, or there was an IO error
		//return an empty list
		if(files == null) {
			return ans;
		}
		
		ans.addAll(Arrays.asList(files));
		
		if(recursive) {
			File subdirs[] = directory.listFiles(DIRS);
			for(File d : subdirs) {
				ans.addAll(listfiles(d, filter, true));
			}
		}
		
		return ans;
	}

	/**
	 * List all files and sub directories of the specified directory, according
	 * to the specified filter. If the recursive flag is true, these sub
	 * directories are also searched recursively.
	 * 
	 * @param directory
	 *            the base directory to start listing in
	 * @param filter
	 *            the FilenameFilter which is applied to each file and directory
	 *            during the retrial
	 * @param recursive
	 *            if true, iterate all sub directories as well
	 * @return a list of all the files and directories found.
	 */
	public static List<File> listfiles(File directory, FilenameFilter filter, boolean recursive) {
		return listfiles(directory, new FilterAdapter(filter), true);
	}

	/**
	 * List all files and sub directories of the specified directory
	 * recursively.
	 * 
	 * @param directory
	 *            the base directory to start listing in
	 * @return a list of all the files and directories found.
	 */
	public static List<File> listfilesRecursive(File directory) {
		//if the filter is null, all files are returned
		return listfiles(directory, (FileFilter)null, true);
	}

	/**
	 * List all sub directories of the specified directory. If the recursive
	 * flag is true, these sub directories are also searched recursively.
	 * 
	 * @param directory
	 *            the base directory to start listing in
	 * @param recursive
	 *            if true, iterate all sub directories as well
	 * @return a list of all directories found.
	 */
	public static List<File> listDirectories(File directory, boolean recursive) {
		return listfiles(directory, DIRS, recursive);
	}
	
	public static void printFiles(File directory, FileFilter filter, boolean recursive) {
		for(File f : listfiles(directory, filter, recursive)) {
			System.out.println(f);
		}
	}

}
