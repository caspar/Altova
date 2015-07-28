package net.hblok.util;

import java.util.logging.Level;

public class HierarchyLevel extends Level {

	/**
	 * 
	 */
	private static final long serialVersionUID = 815753469826799831L;

	public HierarchyLevel(String name, int value) {
		super(name, value);
	}

	public static final Level SUITE = new HierarchyLevel("SUITE", 3000);
	
	public static final Level TEST = new HierarchyLevel("TEST", 2900);
	
	
}
