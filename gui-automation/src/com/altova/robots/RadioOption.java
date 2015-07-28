package com.altova.robots;

import java.awt.Font;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;

/**
 * Class to identify a Radio button option, where the name of the option is also
 * its value.
 * 
 * @author Havard Rast Blok
 * 
 */
public class RadioOption extends AbstractOption {
	protected java.awt.Font currentFont;
	
	/**
	 * Creates an option identified only by its name. Please make sure that this
	 * is a unique name, and that the string does not match any other options in
	 * the same dialog or tab.
	 * 
	 * @param name
	 *            the text to the right of the radio button.
	 */
	public RadioOption(String name) {
		this(name, null);
	}
	
	public RadioOption(String name, boolean bold) {
		this(name, null);
		//this is a special case for the option dialogs under the Convert menu in XMLSpy
		boldOption = bold;
	}

	/**
	 * Creates an option identified by its name and section it is contained in.
	 * An example of this would be the option <i>Landscape</i> which is
	 * contained in the section <i>Orientation</i> in the dialog <i>Print Setup</i>
	 * from the File menu in XMLSpy.
	 * 
	 * @param name the text to the right of the radio button.
	 * @param section the name of container of the option
	 */
	public RadioOption(String name, String section) {
		this(name,section,null,null,null,MS_SHELL_DLG_FONT);
	}
	
	public RadioOption(String name, String section, String subSection, String page, String tab,Font currentFont) {
		super(name, section, subSection, page, tab);
		this.currentFont=currentFont;
	}

	public void applyOption(ApplicationRobot robot) {
		robot.leftClickMid(findOptionName(robot,currentFont));
	}
	
	public String getRadioName(){
		
		if (name != null)		
			return name;
		else
			return "";
	}
}
