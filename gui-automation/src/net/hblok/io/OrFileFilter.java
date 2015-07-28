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

import java.io.FileFilter;

/**
 * FileFilter which combines several filters where one or more must
 * be true for the accept method of this filter to return true.
 * 
 * Example:
 * <code>
 * DirectoryFileFilter foo = new DirectoryFileFilter("foo");
 * RegexFileFilter bar = new RegexFileFilter("bar.*");
 * OrFileFilter or = new OrFileFilter( foo, bar );
 * </code>
 * 
 * 
 * @author Havard Rast Blok
 *
 */
public class OrFileFilter extends CombinedFilter {

	private static final long serialVersionUID = -1526392681006118615L;

	public OrFileFilter() {
		super(true);
	}
	
	public OrFileFilter(FileFilter... filter) {
		super(true, filter);
	}

}
