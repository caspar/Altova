package com.altova.robots;

import java.awt.Color;
import java.awt.Font;

import com.altova.robots.FontOption.FontSettings;
import com.altova.spy.SpyRobot;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;

public class OptionsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpyRobot robot = new SpyRobot();
		//ColorOption c = new ColorOption(null, Color.BLACK, "Styles", "Grid fonts");
		//ColorOption c =new ColorOption("Header unselected",Color.RED,"Table view","Colors");
		//TextFieldOption c = new TextFieldOption("Global scripting project file", true, "test", "Activation", null, null, "Scripting");
		//TextFieldOption c = new TextFieldOption("Font face and script", true, "Bell MT", null, null, null, "Grid fonts");
		Font myfont =new Font("Arial Narrow",Font.PLAIN,10);
		Font deffont =new Font("Arial",Font.BOLD,11);
		FontSettings deffontset =new FontSettings(deffont);
		FontSettings newfont=new FontSettings(myfont, false, Color.RED, null);
		FontOption f= new FontOption("Doc. Schema Header2",deffontset,newfont,false, false,"Grid fonts",MS_SHELL_DLG_FONT);
		//FontTextFieldOption c = new FontTextFieldOption("Bell MT", "Grid fonts");
		f.applyOption(robot);
		
		//TextFieldOption b = new TextFieldOption("Size", true, "16", null, null, null, null);
		//b.applyOption(robot);
		
		/*
		String encoding = "Unicode UTF-8";
		Options options = new Options();
		options.add(new DropDownOption("HTML:", encoding));
		options.add(new DropDownOption("RTF:", encoding, "Select Output Encoding for", "HTML"));
		options.add(new DropDownOption("PDF:", encoding));
		options.add(new RadioOption("Compatibility"));
		options.applyOption(robot);
		 */
		
//		DropDownOption b = new DropDownOption("Standard script language", true, "VBScript", null, null, null, "Scripting");
//		b.applyOption(robot);
	}

}
