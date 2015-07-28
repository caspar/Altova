package com.altova.robots;

import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;
import static java.awt.event.KeyEvent.VK_DOWN;

import java.awt.Font;

public class FontTextFieldOption extends TextFieldOption {

	protected java.awt.Font currentFont= MS_SHELL_DLG_FONT;

	public FontTextFieldOption(String value, String section, String tab,Font currentFont) {
		super(section, true, value, null, null, null, tab,currentFont);
	}

	public void applyOption(ApplicationRobot robot) {
		super.applyOption(robot);
		robot.keyType(VK_DOWN);
	}
}
