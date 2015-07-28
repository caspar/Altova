package com.altova.robots;

import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;
import static com.altova.util.LoggerUtils.logger;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.altova.robots.FontOption.FontSettings;

public class TextFontOption extends FontOption {


	private String filetypetab;
	private Color textViewBack;
	private boolean useSameAll;
	protected java.awt.Font dlgFont= MS_SHELL_DLG_FONT;

	public TextFontOption(String component,String filetypetab, FontSettings fontDefault, FontSettings fontNew,Color textViewBack,boolean useSameAll,String tab,Font dlgFont) {
		super(component, fontDefault, fontNew, false, false, tab,dlgFont);
		this.filetypetab=filetypetab;
		this.textViewBack=textViewBack;
		this.useSameAll=useSameAll;
		this.dlgFont=dlgFont;
	}

	
	public void applyOption(ApplicationRobot robot) {
		if (robot instanceof AltovaApplicationRobot) {
			applyOption((AltovaApplicationRobot) robot);
		} else {
			throw new ScriptMistakeException("Class TextFontOption can just be used for Altova applications");
		}
	}

	public void applyOption(AltovaApplicationRobot robot) {
		
		robot.delay(500);
		Options options = new Options();
		if (filetypetab != null) {
			if (filetypetab.equalsIgnoreCase("XML generic")) {
				robot.keyType(KeyEvent.VK_C);
				robot.delay(500);
				robot.keyType(KeyEvent.VK_UP);
				robot.delay(500);
				robot.keyType(KeyEvent.VK_UP);
				robot.delay(500);
			} else if (filetypetab.equalsIgnoreCase("CSS")) {
				robot.keyType(KeyEvent.VK_C);
				robot.delay(500);
			} else if (filetypetab.equalsIgnoreCase("XQuery")) {
				robot.keyType(KeyEvent.VK_C);
				robot.delay(500);
				robot.keyType(KeyEvent.VK_UP);
				robot.delay(500);
			} else {
				throw new ScriptMistakeException("Filetype label is not valid.Select 'CSS','XML generic' or 'XQuery'");

			}
		}
		super.applyOption(robot);
		
		if(useSameAll!=false){
			options.add(new CheckboxOption("Use the same for all", useSameAll, "Text view background"));
		}
		
		if (textViewBack != null) {
			options.add(new ColorOption(null,true,textViewBack,"Text view background"));
			
		}
		
		options.applyOption(robot);
	
	}
}
