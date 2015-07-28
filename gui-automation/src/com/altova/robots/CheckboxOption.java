package com.altova.robots;

import java.awt.Font;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;
import static com.altova.robots.ImageRecognitionRobot.WINDOWS_DEFAULT_FONT;
/**
 * Sets the value of a check box option to ticked or un-ticked.
 * 
 * @author Havard Rast Blok
 *
 */
public class CheckboxOption extends AbstractOption {
	protected boolean value;
	protected java.awt.Font currentFont= MS_SHELL_DLG_FONT;

	/**
	 * Constructs a CheckboxOption which sets the check box with the specified
	 * name, to the specified value.
	 * 
	 * @param name
	 *            name of option
	 *            
	 * @see AbstractOption#name
	 */
	public CheckboxOption(String name, boolean value) {
		super(name);
		this.value = value;
	}

	/**
	 * Constructs a CheckboxOption with the specified name and location 
	 *  section, which sets the check box with the specified
	 * name, to the specified value., which is located within the
	 * specified section.
	 * 
	 * @param name
	 *            name of option
	 * @param section
	 *            name of section
	 * @see AbstractOption#name
	 * @see AbstractOption#section
	 */
	public CheckboxOption(String name, boolean value, String section) {
		this(name,value,section,null,null,null,MS_SHELL_DLG_FONT);
	}
	
	public CheckboxOption(String name, boolean value, String section, String subSection) {
		this(name,value,section,subSection,null,null,MS_SHELL_DLG_FONT);
	}

	public CheckboxOption(String name, boolean value, String section, String subSection, String page, String tab,Font currentFont) {
		super(name, section, subSection, page, tab);
		this.value = value;
		this.currentFont=currentFont;
	}


	public void applyOption(ApplicationRobot robot) {
		robot.leftClickMid( findOptionName(robot,currentFont) ); robot.delay(500);
		
		if(value) {
			robot.typeString("+");
		}
		else {
			robot.typeString("-");
		}
		
		robot.delay(500);
	}
}
