package com.altova.stylevision;

import java.awt.Color;

public class Tag {
	public static final Color GREEN_BACK = new Color(198, 255, 181);
	public static final Color PEACH_BACK = new Color(255, 240, 208);
	public static final Color MAGENTA_BACK = new Color(240, 232, 255);
	public static final Color GREEN_TEXT = new Color(16, 48, 8);
	public static final Color PEACH_TEXT = new Color(80, 48, 0);
	public static final Color MAGENTA_TEXT = new Color(64, 0, 64);
	public static final Color GREY_BACK = new Color(200,200, 200);
	public static final Color LGREY_BACK = new Color(240,240, 240);
	public static final Color MGREY_BACK = new Color(239,235, 239);
	public static final Color LBLUE_BACK = new Color(166,202, 240);
	public static final Color MAROON_TEXT = new Color(128,0, 0);
	public static final Color DBLUE_TEXT = new Color(0,0,255);
	public static final Color BLUE_BACK = new Color(192,255, 255);
	
	
	
	public static final TagColor MAGENTA = new TagColor(MAGENTA_BACK, MAGENTA_TEXT);
	public static final TagColor PEACH = new TagColor(PEACH_BACK, PEACH_TEXT);
	public static final TagColor GREEN = new TagColor(GREEN_BACK, GREEN_TEXT);
	public static final TagColor BW = new TagColor(Color.WHITE, Color.BLACK);
	public static final TagColor BG = new TagColor(GREY_BACK,Color.BLACK );
	public static final TagColor BLG = new TagColor(LGREY_BACK,Color.BLACK );
	public static final TagColor BMG = new TagColor(MGREY_BACK,Color.BLACK);
	public static final TagColor BLB = new TagColor(LBLUE_BACK,Color.BLACK );
	public static final TagColor MW = new TagColor(Color.WHITE,MAROON_TEXT);
	public static final TagColor GREENGREEN = new TagColor(GREEN_BACK,GREEN_TEXT );
	public static final TagColor DBLB= new TagColor(BLUE_BACK,DBLUE_TEXT );
	
	

	String name;
	
	TagColor color;
	
	TagType type;


	public Tag(String name, TagColor color, TagType type) {
		this.name = name;
		this.color = color;
		this.type = type;
	}
	
	public String toString() {
		return name +" ("+type+")";
	}
}

class TagColor {
	Color back;
	Color text;
	
	public TagColor(Color back, Color text) {
		this.back = back;
		this.text = text;
	}
	
	public String toString() {
		return "back="+back+", text="+text;
	}
}



