package com.altova.umodel.regression.gui;

/**
 * Enumeration for the type of layout operations for diagram elements.
 * The contained String, type, is the description of the type as seen
 * in the menu items of the Layout menu in UModel.
 * 
 * @author Havard Rast Blok
 *
 */
public enum LayoutType { 
	ALIGN("Align"),
	SPACE("Space Evenly"),
	SIZE("Make Same Size"),
	LINEUP("Line Up"),
	LINE_STYLE("Line Style"),
	AUTO_LAYOUT("Autolayout All");
	
	private String type;
	
	private LayoutType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}