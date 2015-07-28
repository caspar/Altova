package com.altova.spy;

import java.io.File;
import java.io.IOException;

import com.altova.util.IOUtils;
import static com.altova.util.LoggerUtils.logger;

public class Xsd2UmlTest {

	SpyRobot robot;
	
	public Xsd2UmlTest() {
		robot = new SpyRobot();
	}
	
	public void convert() throws IOException {
		robot.activateApplication();
		
		for(String file : IOUtils.readFileLists("xsdcases.txt") ) {
			convert(file);
		}
	}
	
	public void convert(String inputFile) {
		File path = new File(inputFile);
		String basename = path.getName().replace("xsd", "ump");
		File dir = new File(path.getParentFile() + File.separator + "spyoutput");
		String out = dir.getAbsolutePath() + File.separator + basename;
		
		logger.fine("Input: "+inputFile+"\n Output: "+out);
		robot.openFile(inputFile);
		robot.convertUML(null, out); 
		robot.delay(2000);
		robot.closeFile(); 
		robot.delay(5000);
	}
	
	public static void main(String[] args) {
		Xsd2UmlTest t = new Xsd2UmlTest();
		try {
			t.convert();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
