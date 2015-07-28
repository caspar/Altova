/**
 * 
 */
package com.altova.robots;

import com.altova.spy.SpyPane;


public abstract class SnapshotArea {
	
	public static class CommonArea extends SnapshotArea {
		public CommonArea(String name) {
			super(name);
		}
		public static final CommonArea DIAGRAM_MAIN_WINDOW = new CommonArea("diagram");
		public static final CommonArea FULLSCREEN = new CommonArea("fullscreen");
		public static final CommonArea TOP_WINDOW = new CommonArea("top_window");
		public static final CommonArea ZIP_VIEW =new CommonArea("archive_window");
		public static final CommonArea SCHEMA_ATTRIBUTES =new CommonArea("schema_attributes");
		public static final CommonArea PRJ_WINDOW_MAPFORCE=new CommonArea("project");
		public static final CommonArea MF_MAIN_WINDOW =new CommonArea("main_window");
		public static final CommonArea DATACOMPARISON_MAIN_WINDOW =new CommonArea("dbspy_main_comparison_window");
		public static final CommonArea ALLSTYLES_SV=new CommonArea("allstyles");
		public final static CommonArea FIND_IN_FILES=new CommonArea("find_in_files");
		public final static CommonArea FIND_IN_XBRL=new CommonArea("Find in XBRL");
		public final static CommonArea SEMANTICWORKS_MAIN_WINDOW=new CommonArea("semanticworks_main_window");
		public final static CommonArea DIFF_DOG_UP_WINDOW=new CommonArea("diffdog_up_window");
		
	}
	
	private String name;

	public SnapshotArea(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SnapshotArea other = (SnapshotArea) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}