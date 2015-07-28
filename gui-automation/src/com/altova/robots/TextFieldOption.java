package com.altova.robots;

import static com.altova.util.LoggerUtils.logger;

import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;
import static com.altova.robots.ImageRecognitionRobot.WINDOWS_DEFAULT_FONT;

public class TextFieldOption extends AbstractOption {
	protected String value;
	
	protected boolean textAbove;
	
	protected java.awt.Font currentFont= MS_SHELL_DLG_FONT;
	protected java.awt.Font altCurrentFont= WINDOWS_DEFAULT_FONT;
	
	private int _x1=10;
	private int _y1=15;
	private int _x2=30;
	private int _y2=2;
	
	public TextFieldOption(String name, String value) {
		super(name);
		this.value = value;
	}

	public TextFieldOption(String name, String value, String section) {
		this(name,value,section,null);
	}

	public TextFieldOption(String name, String value, String section, String subSection) {
		this(name,value,section,subSection,null,null);
	}

	public TextFieldOption(String name, String value, String section, String subSection, String page, String tab) {
		this(name,false,value,section,subSection,page,tab,MS_SHELL_DLG_FONT);
	}
	
	public TextFieldOption(String name, boolean textAbove, String value, String section, String subSection, String page, String tab,Font currentFont) {
		super(name, section, subSection, page, tab);
		this.value = value;
		this.textAbove = textAbove;
		this.currentFont=currentFont;
	}

	public void applyOption(ApplicationRobot robot) {
		Rectangle r = findOptionName(robot,currentFont);
		applyOptions(r, robot);
	}
	
	public void applyOption(ApplicationRobot robot, Font secondFont) {
		
		Rectangle r = findOptionName(robot,currentFont, secondFont);
		applyOptions(r, robot);

	}
	
	public void applyOptions(Rectangle r, ApplicationRobot robot){
		
		Point field = null;
		if(textAbove) {
			field = new Point(r.x+_x1, r.y+r.height+_y1);  //ex new Point(r.x+10, r.y+r.height+15);
		} else {
			//let's assume the text field is to the right of the label
			field = new Point(r.x+r.width+_x2, r.y+r.height/_y2); //ex new Point(r.x+r.width+30, r.y+r.height/2);
		}
		logger.finest("Assume text field of option "+name+" is at "+field);
		robot.leftClick(field); robot.delay(1000);
		
		//remove the text, and type again
		robot.removeTextfieldText();
		robot.typeString(value);
	}
	
	
	public void setX1(int x1){
		this._x1=x1;
	}
	
	public void setX2(int x2){
		this._x2=x2;
	}
	
	public void setY1(int y1){
		this._y1=y1;
	}
	
	public void setY2(int y2){
		this._y2=y2;
	}
	
	

}
