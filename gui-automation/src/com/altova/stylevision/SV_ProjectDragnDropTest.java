package com.altova.stylevision;

import static com.altova.stylevision.StyleVisionRobot.*;
import static com.altova.stylevision.Tag.*;
import static com.altova.stylevision.TagType.START;
import static com.altova.util.LoggerUtils.logger;



import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.ScriptMistakeException;
import com.altova.util.IOUtils;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.Settings.AltovaApplication;
import static com.altova.stylevision.Position.AFTER;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

public class SV_ProjectDragnDropTest extends AbstractStyleVisionTest {

	private static final String My_TestDir="data/stylevision/tdata";
	private static final File MY_TestCase_File=IOUtils.findFile("data/stylevision/tdata/orgchart/orgchart.sps");
	private static final String ORGCHART_SPS_FILE=MY_TestCase_File.getAbsolutePath();
	
	@Before
	public void setUp() {
		robot.newProject();
//		robot.openProject(EXAMPLES_PRJ_FILE.getAbsolutePath());
	}
	
	@After
	public void CleanUp() {
		try {
			robot.closeProjectOnly();
		} catch(ScriptMistakeException e) {
			logger.fine("Could not close project - probably already closed: "+e);
		}
	}

	@Test
	//@Ignore
	public final void testDragCSSfromProject() {
		File filename =IOUtils.findFile(My_TestDir+"/orgchart/QuickStart.css");
		String MY_CSS_FILE=filename.getAbsolutePath();
		String MY_CSS_FILENAME ="QuickStart.css";

		robot.addFilesToProject(MY_CSS_FILE);
		robot.openFile(ORGCHART_SPS_FILE);delay(1000);
		robot.activatePane(STYLEREPOSITORY);
		robot.dragTagfromProject("CSS Files",MY_CSS_FILENAME,robot.findTag("External",BLB));
		assertAreas(STYLEREPOSITORY);
	}

	@Test
	//@Ignore
	public final void testDragXMLfromProject() {
		File filename =IOUtils.findFile(My_TestDir+"/orgchart/NanonullOrg.xml");
		String MY_NANONULL_XML_FILE=filename.getAbsolutePath();
		String MY_NANONULL_XML_FILENAME ="NanonullOrg.xml";
		
		robot.addFilesToProject(MY_NANONULL_XML_FILE);
		robot.openFile(ORGCHART_SPS_FILE);
		robot.dragTagfromProject("XML Files",MY_NANONULL_XML_FILENAME,robot.findTagwithFont("Working XML",BLG,WINDOWS_DEFAULT_FONT));
		robot.activatePane(PROJECT);
		robot.dragTagfromProject("XML Files",MY_NANONULL_XML_FILENAME,robot.findTagwithFont("Template XML",BLG,WINDOWS_DEFAULT_FONT));
		assertAreas(DESIGNOVERVIEW);
	}
	
	@Test
	//@Ignore
	public final void testDragXSDfromProject() {
		File filename =IOUtils.findFile(My_TestDir+"/orgchart/NanonullOrg.xsd");
		String MY_NANONULL_XSD_FILE=filename.getAbsolutePath();
		String MY_NANONULL_XSD_FILENAME ="NanonullOrg.xsd";
				
		robot.addFilesToProject(MY_NANONULL_XSD_FILE);
		robot.openFile(ORGCHART_SPS_FILE);
		robot.dragTagfromProject("XML Schema/DTD Files",MY_NANONULL_XSD_FILENAME,robot.findTagwithFont("Schema",BLG,WINDOWS_DEFAULT_FONT));
		assertAreas(DESIGNOVERVIEW);
	}
}
