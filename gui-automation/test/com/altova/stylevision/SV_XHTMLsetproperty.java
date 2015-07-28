package com.altova.stylevision;

import static com.altova.util.LoggerUtils.logger;

import java.awt.event.KeyEvent;


import com.altova.robots.RadioOption;
import com.altova.util.XMLFileReader;

public class SV_XHTMLsetproperty extends AbstractStyleVisionTest {
	private static final XMLFileReader myxml = new XMLFileReader("data\\stylevision\\sv_xhtml_catalog.xml");
	private static final String xInputfile[]=myxml.getAllValueOfNode("test:test-case","test:input-file");
	private static final String xbasefile[]=myxml.getAllValueOfNode("test:test-case","test:basefile");
	private static final String xdescription[]=myxml.getAllValueOfNode("test:test-case","test:description");
	//private static final String xfurtherfiles[]=myxml.getAllValueOfNode("test:test-case","test:furtherfiles");
	
	public SV_XHTMLsetproperty() {
		robot = new StyleVisionRobot();
		//for (int j = 0; j < xID.length; j++) {
		for (int i = 2; i < 183; i++) {    //debug
			//int myIndex=xbasefile[i].substring(0,xbasefile[i].lastIndexOf("\\")).lastIndexOf("\\");
			//String testfile=xbasefile[i].substring(0,myIndex+1)+xdescription[i];
			  String testfile=xbasefile[i]+xInputfile[i];
			  logger.fine("TCASE: "+xdescription[i]+" filename="+testfile);
			  robot.openFile(testfile); robot.delay(3000);
			  robot.keyType(KeyEvent.VK_ESCAPE);robot.delay(3000);
			  RadioOption option = new RadioOption("XHTML 1.0 Transitional");
			  robot.setProperty(option);
			  robot.closebyStrgF4(KeyEvent.VK_Y);  //save design
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SV_XHTMLsetproperty();
	}

}