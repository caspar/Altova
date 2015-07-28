package net.hblok.io;

import java.io.File;
import java.util.List;

/**
 * A FileFilter which will reject files in the list provided
 * the list can also be taken from a filter
 * 
 * @author Phelim McConigly
 *
 */
public class ExcludeListFileFilter  
	implements java.io.FileFilter {
	
	private static final long serialVersionUID = 1L;
	private List<File> list;
	
	public ExcludeListFileFilter(List<File> list) {
		if(list == null) {
			throw new NullPointerException("list cannot be null");
		}		
		this.list = list;
	}
	
	public boolean accept(File pathname) {
		
		for(File fl : list) {			
			if ( pathname.getPath().contains(fl.getParentFile().getPath()) ) { 
				return false ;			
			}
		}
		return true ;
	}

	public String toString() {
		return "[ExcludeListFileFilter:" + list + " ]";
	}


}