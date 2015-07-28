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
import java.io.FilenameFilter;

/**
 * FilenameFilter where the only the filename name is matched against
 * the regular expression string given as a constructor to this filter. 
 * 
 * @author Havard Rast Blok
 *
 */
public class RegexFilenameFilter implements FilenameFilter {

	private String regex;
	
	public RegexFilenameFilter(String regex) {
		this.regex = regex;
	}
	
	public boolean accept(File dir, String name) {
			return name.matches(regex);
	}
	
	public String toString() {
		return "[RegexFilenameFilter: "+regex+"]";
	}


}
