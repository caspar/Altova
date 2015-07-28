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
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

public class FilterTests extends TestCase {

	private static final String TESTPATH = ".";
	
	private static File testDir = new File(TESTPATH);
	
	@Test
	public void testAnd() {
		System.out.println("testAnd");
		DirectoryFileFilter dirs = new DirectoryFileFilter();
		RegexFilenameFilter cvs = new RegexFilenameFilter("cvs");
		FilterAdapter fd = new FilterAdapter(cvs);
		NegateFileFilter notcvs = new NegateFileFilter(fd);
		AndFileFilter and = new AndFileFilter(dirs, notcvs);
		
		printFilenames(and);
	}
	
	@Test
	public void testOr() {
		System.out.println("testOr");
		RegexFileFilter netPath = new RegexFileFilter(".*net");
		RegexFilenameFilter netName = new RegexFilenameFilter("net");
		NegateFileFilter notNetName = new NegateFileFilter(new FilterAdapter(netName));
		
		OrFileFilter or1 = new OrFileFilter( netPath, notNetName );
		printFilenames(or1);
		System.out.println();
		
		OrFileFilter or2 = new OrFileFilter( notNetName, netPath );
		printFilenames(or2);
	}
	
	@Test
	public void testDirectoryContent() {
		System.out.println("testDirectoryContent");
		ExtensionFileFilter ext = new ExtensionFileFilter("java");
		ext.setIncludeDirectories(false);
		DirectoryContentFileFilter dirs = new DirectoryContentFileFilter(ext);
		dirs.setFileCountRange(1, 10);
		
		printFilenames( FileFilterUtils.listfiles(testDir, dirs, true) );
	}
	
	@Test
	public void testParentDirectoryFileFilter() {
		System.out.println("testDirectoryContent");
		ExtensionFileFilter ext = new ExtensionFileFilter("java");
		ext.setIncludeDirectories(false);
		DirectoryContentFileFilter count = new DirectoryContentFileFilter(ext);
		count.setFileCountRange(1, 10);
		ParentDirectoryFileFilter parent = new ParentDirectoryFileFilter(count);
		
		printFilenames( FileFilterUtils.listfiles(testDir, parent, true) );
	}

	@Test
	public void testListfiles() {
		System.out.println("testListfiles");
		printFilenames( FileFilterUtils.listfiles(testDir, new RegexFileFilter(".*"), true) );
		
		FileFilterUtils.listfiles(new File(testDir, "dummy"), new RegexFileFilter(".*"), true);
	}
	
	@Test(expected=NullPointerException.class)
	public void testListfilesNull() {
		System.out.println("testListfilesNull");
		printFilenames( FileFilterUtils.listfiles(null, new RegexFileFilter(".*"), true) );
	}
	
	@Test
	public void listDirectories() {
		System.out.println("listDirectories");
		printFilenames( FileFilterUtils.listDirectories(testDir, true) );
	}
	
	private void printFilenames(FileFilter filter) {
		FileFilterUtils.printFiles(testDir, filter, false);
	}
	
	private void printFilenames(List<File> files) {
		for(File f : files) {
			System.out.println(f);
		}
	}
}
