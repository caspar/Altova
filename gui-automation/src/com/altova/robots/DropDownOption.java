package com.altova.robots;

import static com.altova.util.LoggerUtils.logger;
import static com.altova.robots.ImageRecognitionRobot.*;
import static java.awt.Color.BLACK;
//import java.awt.Font.*;

import java.awt.Font;
import java.awt.Rectangle;

/**
 * Option for a drop-down, where a separate field identifies the option, and the
 * value is an already existing item selected from the drop-down list. For
 * free-form value, or a combo-box type of option, please see the
 * {@link TextFieldOption} instead.

 * @see TextFieldOption
 * 
 * @author Havard Rast Blok
 * 
 */
public class DropDownOption extends AbstractOption {
	protected String value;

	protected boolean textAbove;
	
	private int X1=0;
	private int Y1=15;
	private int correct = 0;
	
	protected java.awt.Font currentFont = MS_SHELL_DLG_FONT;
	protected java.awt.Font name_font   = MS_SHELL_DLG_FONT;
	protected java.awt.Font new_font    = MS_SHELL_DLG_FONT;
	
	protected boolean flagUseTwice = false; 
	
	/**
	 * Creates an option identified only by its name. Please make sure that this
	 * is a unique name, and that the string does not match any other options in
	 * the same dialog or tab.
	 * 
	 * @param name
	 *            the text to the right of the radio button.
	 * @param value the value to select from the drop-down list. 
	 */

	public DropDownOption(String name, String value) {
		this(name,false,value,null);
	}

	public DropDownOption(String name,boolean textAbove,String value, String section) {
		this(name,textAbove,value,section,null,null,null,MS_SHELL_DLG_FONT);
		
	}

	public DropDownOption(String name, String value, String section, String subSection) {
		this(name,false,value,section, subSection,null,null,MS_SHELL_DLG_FONT);
	}

	public DropDownOption(String name, boolean textAbove, String value, String section, String subSection, String page, String tab) {
		this(name,false,value,section, subSection, page, tab, MS_SHELL_DLG_FONT);
	}


	public DropDownOption(String name, boolean textAbove, String value, String section, String subSection, String page, String tab, Font currentFont) {
		super(name, section, subSection, page, tab);
		this.value = value;
		this.textAbove = textAbove;
		this.currentFont=currentFont;
	}
	
	
	public void applyOption(ApplicationRobot robot) {
		

		/**
		 * Dab 5/11/2009
		 * 
		 * Method modified to handle two different font (one for name and one for value)
		 * 
		 *  1) when the font is one, call DropDownOption constructor and then applyOption(Application robot);
		 *  2) When two different font are present, call DropDownOption constructor, 
		 *  then setTwiceFontDropDownOption (Font name, font value) method and then 
		 *   applyOption(Application robot);
		 *   
		 *   That´s all!!
		 */
		
		Rectangle r = null;
		
		logger.fine("!!!start of DROPDOWN OPTION");
		
		if (flagUseTwice)
			r = findOptionName(robot,name_font,getCurrentFont());
		else
			r = findOptionName(robot,currentFont);
		

		//Calculate the boundaries of the drop-down 
		int ddStartX = (textAbove)?r.x:r.x+r.width+X1;
		int ddStartY = (textAbove)?r.y+r.height+Y1:r.y-7;
		int ddWidth = optionBoundary.x + optionBoundary.width - ddStartX + correct;
		logger.fine("optionBoundary.x" + optionBoundary.x);
		logger.fine("optionBoundary.width" + optionBoundary.width);
		logger.fine("ddStartX" + ddStartX);
		Rectangle dd = new Rectangle(ddStartX, ddStartY, ddWidth, 21);
		logger.finest("Searching for dropdown value "+value+" at "+dd);
		
		//ok, first see if the option is already in the dropdown text field
		try {
			Rectangle v = robot.findString(value, currentFont, TRANSPARENT, BLACK, dd, false);
			logger.fine("Found value "+value+" at "+v+". Returning without setting already set option");
			return;
		} catch(ImageNotFoundException e) {
			logger.finest("Value was not already set, let's set it");
		}
		
		//now, click the dropdown, and search for the specified value in the appearing list
		robot.leftClick(ddStartX+30, ddStartY+5); robot.delay(2000);
		int screenHeight = ImageUtils.getDefaultScreenDimension().height;
		Rectangle list = new Rectangle(ddStartX, ddStartY-10, ddWidth, screenHeight-ddStartY-10);
		logger.finest("Searching for list value "+value+" at "+list);
		try {
			Rectangle entry = robot.findString(value, currentFont, TRANSPARENT, BLACK, list, false);
			logger.finest("Found option "+value+" in list at "+entry);
			robot.leftClickMid(entry);
		} catch(ImageNotFoundException e) {
			throw new ScriptMistakeException("Could not find dropdown option "+value, e);
		}
	}
	
	private Font getCurrentFont() {
		
		return new_font;
	}

	public void setX1(int x1){
		this.X1=x1;
	}
	
	public void setY1(int y1){
		this.Y1=y1;
	}
	
	public void setCorrect(int c){
		this.correct = c;
	}
	
	public void setFont(java.awt.Font newFont){
		
		new_font = newFont;
		
	}
	
	public void setTwiceFontDropDownOption(java.awt.Font name){
		
		name_font = name;
		flagUseTwice = true;
			
	}
}
