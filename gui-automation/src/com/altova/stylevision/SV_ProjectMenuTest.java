package com.altova.stylevision;

import static com.altova.stylevision.StyleVisionRobot.*;
import static com.altova.util.LoggerUtils.logger;


import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import org.junit.Ignore;


import com.altova.robots.ScriptMistakeException;
import com.altova.util.IOUtils;


public class SV_ProjectMenuTest extends AbstractStyleVisionTest {

//	protected static final String EXAMPLES_PRJ = new File(AltovaApplication.STYLEVISION.getExamplesLocation(), "Examples.spp").getAbsolutePath();
	protected static final String MY_PRJ = "C:\\temp\\my_sv_prj.svp";
	
	protected static final String MY_WEBDAV_FOLDER = "http://qa-w2k3/webdav/";
	
//	protected static final File EXAMPLES_PRJ_FILE = IOUtils.findFile("examples/Examples.spp");
	protected static final File MY_PRJ_FILE = new File(MY_PRJ);
	protected static final String MY_EXT_PROJ_FOLDER="C:\\temp";
	
	protected static final String My_TestDir="data/stylevision/tdata/orgchart/";
	protected static final File MY_TestCase_File=IOUtils.findFile(My_TestDir+"orgchart.sps");
	protected static final String ORGCHART_SPS_FILE=MY_TestCase_File.getAbsolutePath();
	
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
	public final void testNewProject() {
		robot.newProject();
		assertAreas(PROJECT);
	}

	@Test
	//@Ignore
	public final void testSaveProject() {
		robot.saveProject(MY_PRJ);
		assertAreas(PROJECT);
	}

	@Test
	//@Ignore
	public final void testOpenProject() {
		robot.openProject(MY_PRJ);
		assertAreas(PROJECT);
	}

	@Test
	//@Ignore
	public final void testAddUrlToProject() {
		robot.addUrlToProject(ALTOVA_COM);
		assertAreas(PROJECT);
	}

	@Test
	//@Ignore
	public final void testReloadProject() {
		robot.openProject(MY_PRJ);
		robot.addUrlToProject(ALTOVA_COM);
		robot.reloadProject(KeyEvent.VK_Y);
		assertAreas(PROJECT);
	}
	
	@Test
	//@Ignore
	public final void testCloseProject() {
		robot.closeProjectOnly();
		assertAreas(PROJECT);
	}
	
	
	@Test
	//@Ignore
//	@IgnoreRobots(EclipseSpyRobot.class)
	public final void testAddFilesToProject() {
		robot.addFilesToProject(ORGCHART_SPS_FILE);
		assertAreas(PROJECT);
	}


	@Test
	//@Ignore
//	@IgnoreRobots({EclipseSpyRobot.class,VSnetSpyRobot.class})
	public final void testAddActiveFileToProject() {
//		robot.newProject();
		robot.openFile(ORGCHART_SPS_FILE);
		robot.addActiveFileToProject();
		assertAreas(PROJECT);
		
	}

	@Test
	//@Ignore
	//@IgnoreRobots({EclipseSpyRobot.class,VSnetSpyRobot.class})
	public final void testAddActiveAndRelatedFileToProject() {
		robot.newProject();
		robot.openFile(ORGCHART_SPS_FILE);
		robot.addActiveAndRelatedFileToProject();
		assertAreas(PROJECT);
	}
	
	@Test
	//@Ignore
//	@IgnoreRobots(EclipseSpyRobot.class)
	public final void testAddProjectFolderToProject() {
		robot.addProjectFolderToProject("test");
		assertAreas(PROJECT);
	}
	
	@Test
	//@Ignore
	public final void testAddExternalFolderToProject() {
		robot.addExternalFolderToProject(MY_EXT_PROJ_FOLDER);
/*		robot.keyType(KeyEvent.VK_HOME); delay(500); //this is the only possible solution to this horrible browse dialog
		robot.keyType(KeyEvent.VK_L);delay(500);//select Local Disc 
		robot.keyType(KeyEvent.VK_ADD);delay(500); //expand 
		robot.typeString("temp");delay(500); //and type "temp" to select c:\temp
	*/	robot.keyType(KeyEvent.VK_ENTER);
		assertAreas(PROJECT);
	}
	
	@Test
	//@Ignore
//	@IgnoreRobots({EclipseSpyRobot.class,VSnetSpyRobot.class})
	public final void testAddExternalWebFolderToProject() {
		robot.addExternalWebFolderToProject(MY_WEBDAV_FOLDER);
		assertAreas(PROJECT);
	}

/*	N/A in SV Properties
	@Test
//	@IgnoreRobots({EclipseSpyRobot.class,VSnetSpyRobot.class})
	public final void testProjectProperties() {
		robot.projectProperties(null);
		
	}
*/
}
