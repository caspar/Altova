package com.altova.robots;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import static com.altova.util.LoggerUtils.logger;

import com.altova.robots.ImageRecognitionRobot.PixelCompare;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;

import static java.awt.event.KeyEvent.VK_ENTER;

public class ColorOption extends AbstractOption {
	protected Color value;
	protected boolean back; 
	protected java.awt.Font currentFont= MS_SHELL_DLG_FONT;

	public ColorOption(String name,boolean back, Color value) {
		this(name,back, value, null);
	}

	public ColorOption(String name,boolean back, Color value,String section) {
		this(name,back, value, section,null);
	}
	
	public ColorOption(String name, boolean back,Color value, String section, String tab) {
		this(name, back,value, section, null, null, tab,MS_SHELL_DLG_FONT);

	}

	public ColorOption(String name, boolean back,Color value, String section, String subSection, String page, String tab,Font currentFont) {
		super(name, section, subSection, page, tab);
		this.value = value;
		this.back=back;
		this.currentFont=currentFont;
	}

	public void applyOption(ApplicationRobot robot) {
		if (robot instanceof AltovaApplicationRobot) {
			applyOption((AltovaApplicationRobot) robot);
		} else {
			throw new ScriptMistakeException("Class ColorOption can just be used for Altova applications");
		}
	}

	public void applyOption(AltovaApplicationRobot robot) {

		Rectangle proptype = findOptionName(robot,currentFont);
		Rectangle colorswin = optionBoundary;
		Rectangle ic = colorswin;
		if (name != null) {
			int icxstart = proptype.x + proptype.width;
			int icystart = proptype.y - 8;
			int icwidth = colorswin.width - icxstart + colorswin.x;
			int icheight = proptype.height + 16;
			ic = new Rectangle(icxstart, icystart, icwidth, icheight);
		}

		/**
		 * Windows XP styling does some shadowing that avoids this icon
		 * recognition through the default way. Black-white pixel comparison
		 * ignores this effect, so we use it for this specific case.
		 */
		try {
			robot.compareState = PixelCompare.BLACK_WHITE;
			String iconname = null;
			if (back == true) {
				iconname = "IDC_BACK_COLOR";
				logger.fine("Changing background color in ColorOption");

			} else {
				iconname = "IDC_COLOR";
			}

			robot.leftClick(iconname, ic,false);
			robot.delay(1000);
			robot.assertWindow("Color");

		} finally {
			robot.compareState = ImageRecognitionRobot.DEFAULT_PIXEL_COMPARE;
		}
		Rectangle butt = robot.findComponentName("Define Custom Colors");
		robot.leftClickMid(butt);
		Options options = new Options();
		options.add(new TextFieldOption("Red", "" + value.getRed()));
		options.add(new TextFieldOption("Green", "" + value.getGreen()));
		options.add(new TextFieldOption("Blue", "" + value.getBlue()));
		options.applyOption(robot);

		robot.keyType(VK_ENTER);
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = super.hashCode();
		result = PRIME * result + (back ? 1231 : 1237);
		result = PRIME * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ColorOption other = (ColorOption) obj;
		if (back != other.back)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
}
