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
 * Filter which returns the opposite value return by the specified
 * filter's accept method. 
 * 
 * @author Havard Rast Blok
 *
 */
public class NegateFileFilter implements FileFilter {

	private FileFilter filter;
	
	public NegateFileFilter(FileFilter filter) {
		if(filter == null) {
			throw new NullPointerException("filter cannot be null");
		}
		
		this.filter = filter;
	}
	
	public boolean accept(File pathname) {
		return !filter.accept(pathname);
	}

	public String toString() {
		return "[NegateFileFilter: "+filter+"]";
	}
}
