package com.altova.stylevision;


import java.awt.event.KeyEvent;

import com.altova.util.XMLFileReader;
import static com.altova.stylevision.Tag.*;
import static com.altova.stylevision.TagType.*;

public class BuildSPS_from_HTML {
	
	protected static StyleVisionRobot robot;
	private static final XMLFileReader myxml = new XMLFileReader("test\\com\\altova\\stylevision\\html_filelist.xml");
	private static final String xID[]=myxml.getAllValueOfNode("tcase","id");
	private static final String xName[]=myxml.getAllValueOfNode("tcase","name");
	private static final String datadir="C:\\temp\\tdata\\css21-test-suite\\";
	
	public BuildSPS_from_HTML() {
		robot = new StyleVisionRobot();
		//for (int j = 0; j < xID.length; j++) {
		for (int j = 9; j < 10; j++) {    //debug
			String myFilename[]=xName[j].split(".htm");
			creatingNewSPS("HTML",j);
			createHTMLSchema();
			robot.saveReplaceDesign(datadir+myFilename[0]+".sps");
			robot.saveGeneratedFiles(datadir+myFilename[0]+".xsd","User-Defined Schema");
			robot.saveGeneratedFiles(datadir+myFilename[0]+".xml","User-Defined XML Data");
		}
		//insertingDynamicContent();
	}
	
	/**
	 * drag all content to UserRoot and insert as Element
	 */
	protected void createHTMLSchema(){
		Tag myTag = new Tag("$USER1", GREEN, START);
		robot.createSchemafromHTML(myTag, "UserRoot","to Elements");
	}
	
	/**
	 * From the tutorial page: Creating a New SPS
	 * 
	 */
	protected void creatingNewSPS(String type,int index) {
		robot.newSPS(type);
		if (type.contains("HTML")){
			robot.typeFileName(datadir+xName[index]);
			robot.keyType(KeyEvent.VK_ESCAPE);   //close any raised warning 
		}
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new BuildSPS_from_HTML();
	}

}
