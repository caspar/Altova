package com.altova.stylevision;

import static com.altova.stylevision.StyleVisionRobot.*;
import static com.altova.util.LoggerUtils.logger;


import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Test;

import com.altova.util.IOUtils;
import com.altova.util.XMLFileReader;


public class FileHandlingTest extends AbstractStyleVisionTest {
	private static final XMLFileReader myxml = new XMLFileReader("data\\stylevision\\guiautomation_catalog.xml");
	private static final String xInputfile[]=myxml.getAllValueOfNode("test:test-case","test:input-file");
	private static final String xdescription[]=myxml.getAllValueOfNode("test:test-case","test:description");
	private static final String xTestdir[]=myxml.getAllValueOfNode("test:test-case","test:basefile");

	
	@Test
	public void test17568(){
		int i=0;
		//String filename=xTestdir[i]+xInputfile[i];
		File MY_TCaseSPS=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TCaseSPS.getAbsolutePath();

		logger.fine("TCASE: "+xdescription[i]);
		robot.newSPS("New from XML Schema");
		robot.typeStringEnter(filename);delay(500);
		robot.keyType(KeyEvent.VK_S);delay(500);   //Skip - don't assign a Working XML
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.keyType(KeyEvent.VK_ESCAPE);delay(2000);   //don't select root element
		robot.maximizeFileWindow();
		assertAreas(DESIGNOVERVIEW);
	}
}