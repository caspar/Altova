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
 * A FileFilter which accepts files based on their parent directory being
 * accepted. The parent directory is accepted if the filter supplied to this
 * ParentDirectoryFileFilter accepts it.
 * 
 * @author Havard Rast Blok
 * 
 */
public class ParentDirectoryFileFilter implements FileFilter {

	protected FileFilter filter;

	public ParentDirectoryFileFilter(FileFilter filter) {
		if (filter == null) {
			throw new NullPointerException("filter cannot be null");
		}

		this.filter = filter;
	}

	public boolean accept(File pathname) {
		File parent = pathname.getParentFile();

		if (parent == null) {
			return false;
		}

		return filter.accept(parent);
	}

}
