package com.altova.umodel.regression.gui;

/**
 * Enumeration of all the types of element layout operations.
 * The contained LayoutType, holds the description of the main menu item,
 * as seen on the Layout menu in UModel. The String, operation, holds the
 * submenu item.
 * 
 * This enumeration also contains a Robot method, to click on an operation
 * of this type.
 * 
 * @author Havard Rast Blok
 *
 */
public enum LayoutOperation {
	ALIGN_LEFT(LayoutType.ALIGN, "Left"),
	ALIGN_CENTER_HORIZONTALLY(LayoutType.ALIGN, "Center Horiz."),
	ALIGN_RIGHT(LayoutType.ALIGN, "Right"),
	ALIGN_TOP(LayoutType.ALIGN, "Top"),
	ALIGN_CENTER_VERTICALLY(LayoutType.ALIGN, "Center Vert."),
	ALIGN_BOTTOM(LayoutType.ALIGN, "Bottom"),
	
	SPACE_ACROSS(LayoutType.SPACE, "Across"),
	SPACE_DOWN(LayoutType.SPACE, "Down"),
	
	SAME_SIZE_WIDTH(LayoutType.SIZE, "Width"),
	SAME_SIZE_HEIGHT(LayoutType.SIZE, "Height"),
	SAME_SIZE_WIDTH_HEIGHT(LayoutType.SIZE, "Width & Height"),
	
	LINEUP_HORIZONTALLY(LayoutType.LINEUP, "Horizontally"),
	LINEUP_VERTICALLY(LayoutType.LINEUP, "Vertically"),
	
	LINE_ORTHOGONAL(LayoutType.LINE_STYLE, "Orthogonal"),
	LINE_DIRECT(LayoutType.LINE_STYLE, "Direct"),
	LINE_CUSTOM(LayoutType.LINE_STYLE, "Custom"),
	
	AUTOLAYOUT_FORCE(LayoutType.AUTO_LAYOUT, "Force Directed"),
	AUTOLAYOUT_HIERARCHIC(LayoutType.AUTO_LAYOUT, "Hierarchic"),
	;
	
	private final LayoutType type;
	private final String operation;
	
	private LayoutOperation(LayoutType type, String operation) {
		this.type = type;
		this.operation = operation;
	}

	public String getOperation() {
		return operation;
	}

	public LayoutType getType() {
		return type;
	}
	
	public void leftClickMenuItem(UModelRobot robot) {
		robot.leftClickMenuItem("Layout", type.getType(), operation);
	}
	
	public String toString() {
		return type+"_"+operation;
	}
}