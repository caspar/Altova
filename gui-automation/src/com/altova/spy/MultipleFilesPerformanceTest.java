package com.altova.spy;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.FULLSCREEN;
import static com.altova.spy.SpyRobot.VALIDATION;
import static com.altova.spy.SpyRobot.MESSAGES;
import static com.altova.util.LoggerUtils.logger;

import com.altova.robots.Options;
import com.altova.robots.RadioOption;
import com.altova.robots.ScriptMistakeException;
import com.altova.util.Settings;
import com.altova.util.XMLFileReader;
import com.altova.util.AltovaJUnitRunner.TestRobot;
import com.altova.util.Settings.AltovaApplication;

import static java.awt.event.KeyEvent.VK_ENTER;



//@TestRobot(VSnetSpyRobot.class)
//@TestRobot(EclipseSpyRobot.class)

public class MultipleFilesPerformanceTest extends AbstractXmlSpyTest{
	private static final XMLFileReader TEST_DATA_XML = new XMLFileReader("data/spy/multiple_files_handling.xml");

	private static final String dirfiles[] = TEST_DATA_XML.getAllValueOfNode("fileset", "directory");

	private static final String filenames[] = TEST_DATA_XML.getAllValueOfNode("fileset", "filename");

	private static final String ifplugins[] = TEST_DATA_XML.getAllValueOfNode("fileset", "plugins");

	private static final String testnames[]=TEST_DATA_XML.getAllValueOfNode("fileset", "testname");
	
	private static final String SPSfileOptions[]=TEST_DATA_XML.getAllValueOfNode("fileset", "SPSfileOptions");
	
	private static final String wellformed[]=TEST_DATA_XML.getAllValueOfNode("fileset", "wellformed");
	
	private static final String validation[]=TEST_DATA_XML.getAllValueOfNode("fileset", "validation");

		
	@Before
	public void setUp() throws Exception {

		super.setUp();
	}
	
	
	@After
	public void tearDown() throws Exception {
		robot.closeAll();
		
		if (Settings.isVS2010()) {
			try {
				robot.leftClickMenuItem("View", "XMLSpy Tool Windows");// This item should not be available
																		// if all spy windows are closed
				throw new AssertionError(
						"'Close File' test failed. It seems there is still an opened document");
			} catch (ScriptMistakeException e) {
				assertEquals(e.getMessage(),
						("Could not find menu item View - XMLSpy Tool Windows"));
			}
		} else {
			assertNull(robot.getDiagramComponent());
		}
		super.tearDown();
	}
	
		
	@Test
	public void openCloseMultipleFiles() {
		String preJUDR = System.getenv("JUnitDryRun");
		//logger.warning("JUNIT_BEFORE= " + preJUDR);
		System.setProperty("JUnitDryRun", "true");

		for (int j = 0; j < dirfiles.length ; j++) {
			delay(1000);
			
			String addDirectoryToPath = ""; 
			if (dirfiles[j] != "") 	addDirectoryToPath = "\\" + dirfiles[j];
			
			if (ifplugins[j].equals("no")) {
				
				if (!SPSfileOptions[j].equals("")) {
					
					Options SPSopt = new Options(); 
					SPSopt.add(new RadioOption(SPSfileOptions[j]));
					
					robot.openFile_notInPlugins(AltovaApplication.XMLSPY.getExamplesLocation().getAbsolutePath() + addDirectoryToPath + "\\" + filenames[j], SPSopt);
				}else{
					robot.openFile_notInPlugins(AltovaApplication.XMLSPY.getExamplesLocation().getAbsolutePath() + addDirectoryToPath + "\\" + filenames[j]);
				}
				
				
				delay(2000);
			} else {
				
				logger.fine("SPSfileOptions value:" + SPSfileOptions[j]);
				if (!SPSfileOptions[j].equals("")) {
					
					Options SPSopt = new Options(); 
					SPSopt.add(new RadioOption(SPSfileOptions[j]));
					
					robot.openFile(AltovaApplication.XMLSPY.getExamplesLocation().getAbsolutePath() + addDirectoryToPath + "\\" + filenames[j], true, SPSopt);
				}else{
					
					robot.openFile(AltovaApplication.XMLSPY.getExamplesLocation().getAbsolutePath() + addDirectoryToPath + "\\" + filenames[j]);
				}
				
			}
			delay(6000);
			
			/*
			 * dab 16/06/2015
			 * I´ve commented because actually has no sense: 
			 * please, uncomment if you understedend why should I get the "FULLSCREEN" screenshot
			 * please, uncomment if you know why  !ifplugins[j].equals("yes") get no screenshot!!
			 */
			//if (ifplugins[j].equals("yes"))
				assertAreas("test_multiplefiles_" + testnames[j], DIAGRAM_MAIN_WINDOW);
			//else
			//	assertAreas("test_multiplefiles_" + testnames[j], FULLSCREEN);
				
				
			logger.fine("wellformed[j]:" + wellformed[j]+ ".");
			
			if (wellformed[j].equals("yes") /*&& ifplugins[j].equals("yes")*/){
				robot.XMLCheckWellFormedness();
				assertAreas("test_multiplefiles_wellformed" + testnames[j], MESSAGES);	
			}

			logger.fine("validation[j]:" + validation[j]+ ".");
			if (validation[j].equals("yes") /*&& ifplugins[j].equals("yes")*/){
				robot.validate();
				robot.escapeDialog("XMLSpy",VK_ENTER);
				assertAreas("test_multiplefiles_validation" + testnames[j], MESSAGES);	
			}

				
			

		}
		if (preJUDR != null) {

			System.setProperty("JUnitDryRun", preJUDR);

		} else {
			System.setProperty("JUnitDryRun", "false");
		}
	}
}
