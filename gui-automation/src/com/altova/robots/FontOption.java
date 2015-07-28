package com.altova.robots;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import static com.altova.util.LoggerUtils.logger;

import com.altova.nativegui.NativeGUI;

import static com.altova.robots.ImageRecognitionRobot.*;
import static java.awt.Color.BLACK;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;

public class FontOption extends AbstractOption {
	protected java.awt.Font dlgFont=MS_SHELL_DLG_FONT;
	public static class FontSettings{
		protected Font font;
		protected boolean underlinedOption;
		protected Color backcolor;
		protected Color fontcolor;
		
		
		public FontSettings(Font font, boolean underlinedOption, Color backcolor, Color fontcolor) {
			this.font = font;
			this.underlinedOption = underlinedOption;
			this.backcolor = backcolor;
			this.fontcolor = fontcolor;
		}

		public FontSettings(Font font) {
			this(font,false,TRANSPARENT,Color.BLACK);
			
		}
	
		
	}
	
	protected FontSettings fontDefault;
	protected FontSettings fontNew;
	protected String component;	
	protected boolean sizeUseSameAll;
	protected boolean fontUseSameAll;
	
	public FontOption(String component,FontSettings fontDefault,Font font,String tab) {
		this(component,fontDefault,new FontSettings(font),tab);
	}	
	
	public FontOption(String component,FontSettings fontDefault,FontSettings fontNew,String tab){
		this(component,fontDefault,fontNew,false,false,tab,MS_SHELL_DLG_FONT);
		
				
	}
		
	public FontOption(String component,FontSettings fontDefault,FontSettings fontNew,boolean fontUseSameAll, boolean sizeUseSameAll,String tab,Font dlgFont){
		super(component,null,null,null,tab);
		
		this.fontUseSameAll= fontUseSameAll;
		this.sizeUseSameAll=sizeUseSameAll;
		this.fontDefault=fontDefault;
		//java sizes are bigger than the windows ones ( proportionality factor:0.75)
		this.fontDefault.font=fontDefault.font.deriveFont((float)(fontDefault.font.getSize()/0.75));
		this.fontNew=fontNew;
		this.dlgFont=dlgFont;
		
	}
	
	public void applyOption(ApplicationRobot robot) {
		if (robot instanceof AltovaApplicationRobot) {
			applyOption((AltovaApplicationRobot) robot);
		} else {
			throw new ScriptMistakeException("Class FontOption can just be used for Altova applications");
		}
	}
	
	protected Rectangle searchForgroundWinow(String string, Rectangle hint, ApplicationRobot robot) {
		if ((name != null) && name.equals(string)) {			
			Rectangle tmpHint = (hint == null) ? NativeGUI.getForegroundWindowInfo().getLocation() : hint;
			//Bold components are searched through pictures, since present aliasing and are different in java and windows.  
			if(fontDefault.font.isBold()&&!fontDefault.font.isItalic()){
				String temp =tab+"_"+string;
				String boldcomponent= temp.replaceAll(" ", "_").toLowerCase().replaceAll("\\.","");
				String boldcomponentfile=boldcomponent+".png";
				logger.finest("Searching for a bold styled component with "+boldcomponentfile);
				return robot.findImage(boldcomponentfile);	
			}
			return robot.findString(string, fontDefault.font, fontDefault.backcolor, fontDefault.fontcolor, tmpHint, false);
		}
		else{
			return super.searchForgroundWinow(string, hint, robot,dlgFont);
		}
	}
	
	public void applyOption(AltovaApplicationRobot robot) {
		robot.leftClickMid(findOptionName(robot,dlgFont));
		robot.delay(500);
		Rectangle stylessection = robot.findComponentName("Styles");
		Options options = new Options();
		if(tab!="Text fonts"){
			options.add(new CheckboxOption("Use the same for all", fontUseSameAll, "Font face"));
			options.add(new CheckboxOption("Use the same for all", sizeUseSameAll, "Size"));
		}
		if (fontNew.font != null) {
			options.add(new FontTextFieldOption(fontNew.font.getFamily(),"Font face", tab,dlgFont));
			options.add(new FontTextFieldOption(""+fontNew.font.getSize(),"Size",tab,dlgFont));

			if(fontDefault.font.isBold()){
				//disable it first
				robot.leftClick("IDC_BOLD", stylessection,true);
			}
			
			if(fontDefault.font.isItalic()){
				//disable it first
				robot.leftClick("IDC_ITALIC", stylessection,true);
			}
			
			if (fontDefault.underlinedOption) {
				//disable it first
				robot.leftClick("IDC_UNDERLINE", stylessection,true);
			}
			
			if (fontNew.font.isBold()) {
				robot.leftClick("IDC_BOLD", stylessection,true);
			}
			
			
			if (fontNew.font.isItalic()) {
				robot.leftClick("IDC_ITALIC", stylessection,true);
			}

		}
		if (fontNew.underlinedOption) {
			robot.leftClick("IDC_UNDERLINE", stylessection,true);
		}
		if (fontNew.fontcolor != null) {
			options.add(new ColorOption(null,false,fontNew.fontcolor,"Styles"));
		}
		
		if (fontNew.backcolor != null) {
			options.add(new ColorOption(null,true,fontNew.backcolor,"Styles"));
			logger.fine("I am changing the backcolor");
		}
		
		options.applyOption(robot);
	
	}

}
