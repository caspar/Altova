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

/**
 * A FileFilter which accepts directories based on the file count they contain.
 * The files to be counted can be qualified by an optional FileFilter.
 * 
 * @author Havard Rast Blok
 * 
 */
public class DirectoryContentFileFilter extends DirectoryFileFilter {

	protected FileFilter filter;

	protected int maxFileCount = Integer.MAX_VALUE;

	protected int minFileCount = 0;

	public DirectoryContentFileFilter() {
		this(null);
	}

	public DirectoryContentFileFilter(FileFilter filter) {
		this.filter = filter;
	}

    public DirectoryContentFileFilter(FileFilter filter, int minFileCount, int maxFileCount) {
	    this(filter);
	    setMinFileCount(minFileCount);
	    setMaxFileCount(maxFileCount);	    
	}

    public DirectoryContentFileFilter(FileFilter filter, int fileCount) {
	this(filter, fileCount, fileCount);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.hblok.io.DirectoryFileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File f) {
		if (!super.accept(f)) {
			return false;
		}

		int noFiles = f.listFiles(filter).length;
		return noFiles >= minFileCount && noFiles <= maxFileCount;
	}

	/**
	 * @return the maxFileCount
	 */
	public int getMaxFileCount() {
		return maxFileCount;
	}

	/**
	 * @param maxFileCount
	 *            the maxFileCount to set
	 */
	public void setMaxFileCount(int maxFileCount) {
		this.maxFileCount = maxFileCount;
	}

	/**
	 * @return the minFileCount
	 */
	public int getMinFileCount() {
		return minFileCount;
	}

	/**
	 * @param minFileCount
	 *            the minFileCount to set
	 */
	public void setMinFileCount(int minFileCount) {
		this.minFileCount = minFileCount;
	}

	/**
	 * @param minFileCount
	 *            the minFileCount to set
	 * @param maxFileCount
	 *            the maxFileCount to set
	 */
	public void setFileCountRange(int minFileCount, int maxFileCount) {
		setMinFileCount(minFileCount);
		setMaxFileCount(maxFileCount);
	}

	/**
	 * 
	 * @param fileCount
	 *            the exact file count to set
	 */
	public void setExactFileCount(int fileCount) {
		setMinFileCount(fileCount);
		setMaxFileCount(fileCount);
	}
}
