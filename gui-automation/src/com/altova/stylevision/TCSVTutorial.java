package com.altova.stylevision;

import java.awt.Point;
import java.io.File;

import com.altova.stylevision.StyleVisionRobot.View;
import com.altova.util.Settings.AltovaApplication;

import static com.altova.stylevision.Tag.*;
import static com.altova.stylevision.TagType.*;
import static com.altova.stylevision.Position.*;

public class TCSVTutorial {
	
	protected StyleVisionRobot robot;
	
	protected final String TUTORIALS_PATH = new File(AltovaApplication.STYLEVISION.getExamplesLocation(), "Tutorials\\QuickStart").getAbsolutePath();
	
	protected final String NEW_DESIGN = "C:\\temp\\MyQuickStart2.sps";

	public TCSVTutorial() {
		robot = new StyleVisionRobot();
		
		creatingNewSPS();
		insertingDynamicContent();
	}
	
	/**
	 * From the tutorial page: Creating a New SPS
	 * 
	 */
	protected void creatingNewSPS() {
		robot.newSPS("empty");
		robot.addSchema(TUTORIALS_PATH+"QuickStart.xsd");
		robot.assigningWorkingXML(TUTORIALS_PATH+"QuickStart.xml");
		robot.setEncoding("Unicode UTF-8");
		robot.saveReplaceDesign(NEW_DESIGN);
	}
	
	/**
	 * From the tutorial page: Inserting Dynamic Content (from XML Source)
	 * 
	 */
	protected void insertingDynamicContent() {

		robot.loadDesign(NEW_DESIGN);
		
		//Inserting element contents
		Point to = new Point(300, 400);
		robot.insertElement("Root elements/presswatch/newsitems/newsitem/headline", to);
		
		//some line breaks
		tagLineBreak("$XML1", GREEN);
		tagLineBreak("newsitem", PEACH);
		
		//preview
		robot.setView(View.HTML);
		robot.delay(3000);
		robot.setView(View.DESIGN);
		
		//Inserting attribute contents
		Tag headLineEnd = new Tag("headline", PEACH, END);
		robot.insertLineBreak(headLineEnd, AFTER);
		robot.insertElement("headline/dateline", headLineEnd, AFTER);
		
		Tag dateLineStart = new Tag("dateline", PEACH, START);
		robot.insertElement("newsitem/dateline/date", dateLineStart, AFTER);

		Tag dateEnd = new Tag("date", PEACH, END);
		robot.insertElement("dateline/place/@city", dateEnd, AFTER);
		
		Tag cityEnd = new Tag("@city", PEACH, END);
		robot.insertElement("@country", cityEnd, AFTER);
		
		//Adding more dynamic content
		Tag dateLineEnd = new Tag("dateline", PEACH, END);
		robot.insertElement("newsitem/synopsis", dateLineEnd, AFTER);
		
		Tag synopsisEnd = new Tag("synopsis", PEACH, END);
		robot.insertElement("newsitem/source  ", synopsisEnd, AFTER);
		
		tagLineBreak("synopsis", PEACH);
		tagLineBreak("source", PEACH);
		
		robot.leftClick("ID_FILE_SAVE");
	}
	
	protected void tagLineBreak(String name, TagColor color) {
		Tag start = new Tag(name, color, START); 
		Tag end = new Tag(name, color, END);
		robot.insertLineBreak(start, AFTER);
		robot.insertLineBreak(end, BEFORE);

	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TCSVTutorial();
	}

}
