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

/**
 * Adapter which converts a {@link FilenameFilter} to a {@link FileFilter}.
 * The path name forwarded to the {@code FilenameFilter} is the abstract path,
 * as return by the method {@link File#getParentFile()}. 
 * 
 * @author Havard Rast Blok
 *
 */
public class FilterAdapter implements FileFilter {

	private FilenameFilter filter;
	
	public FilterAdapter(FilenameFilter filter) {
		this.filter = filter;
	}
	
	public boolean accept(File pathname) {
		return filter.accept(pathname.getParentFile(), pathname.getName());
	}

	public String toString() {
		return "[FilterAdapter: "+filter+"]";
	}
}
