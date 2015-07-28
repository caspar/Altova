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
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Common class for the {@link AndFileFilter} and {@link OrFileFilter}. 
 * 
 * @author Havard Rast Blok
 *
 */
abstract class CombinedFilter extends ArrayList<FileFilter> implements FileFilter  {

	private final boolean or;
	
	protected CombinedFilter(boolean orFilter) {
		this.or = orFilter;
	}
	
	protected CombinedFilter(boolean orFilter, FileFilter... filters) {
		this(orFilter);
		
		if(filters == null) {
			throw new NullPointerException("filters cannot be null");
		}
		
		addAll(Arrays.asList(filters));
	}
	
	public boolean accept(File pathname) {
		for(FileFilter f : this) {
			if(f.accept(pathname) == or) {
				return or;
			}
		}
		
		return !or;
	}
	
	public String toString() {
		return "["+getClass().getName()+": "+super.toString()+"]";
	}
}
