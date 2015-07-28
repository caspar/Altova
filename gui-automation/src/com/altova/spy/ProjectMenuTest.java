package com.altova.spy;

import static com.altova.spy.SpyRobot.*;


import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.TextFieldOption;
import com.altova.util.IOUtils;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.Settings.AltovaApplication;


public class ProjectMenuTest extends AbstractXmlSpyTest {

	
	protected static final String MY_PRJ = "C:\\temp\\my_spy_prj.spp";
	
	//protected static final String SSH_ORG_PUB = "ftp://ftp.ssh.org/pub/ssh";
	protected static final String SSH_ORG_PUB = "ftp://qa-w2k3/GUI_Automation_test";
	
	
	protected static final File EXAMPLES_PRJ_FILE = new File("S:\\QA\\Internal\\Test-Cases\\Automated_GUI_Tests\\src-code\\java-api-tests\\data\\project_Examples\\Examples.spp");
	protected static final File MY_PRJ_FILE = new File(MY_PRJ);
	protected static final String MY_EXT_PROJ_FOLDER="C:\\temp";
	
	@Before
	public void setUp() {
		robot.newProject();
		robot.openProject(EXAMPLES_PRJ_FILE.getAbsolutePath());
	}
	
	@Test
	
	public final void testNewProject() {
		robot.newProject();
		assertAreas(PROJECT);
	}

	@Test
	public final void testOpenProject() {
		robot.newProject();
		robot.openProject(EXAMPLES_PRJ_FILE.getAbsolutePath());
		assertAreas(PROJECT);
	}

	@Test
	public final void testReloadProject() {
		robot.addUrlToProject(ALTOVA_COM);
		robot.reloadProjectDiscard();
		assertAreas(PROJECT);
	}

	@Test
	public final void testCloseProject() {
		robot.closeProjectOnly();
		assertAreas(PROJECT);
	}

	@Test
	public final void testSaveProject() {
		robot.newProject();
		robot.saveProject(MY_PRJ);
		assertAreas(PROJECT);
	}

	@Test
	public final void testAddFilesToProject() {
		robot.newProject();
		robot.addFilesToProject(ORGCHART_XML_FILE.getAbsolutePath());
		assertAreas(PROJECT);
	}

	@Test
	public final void testAddUrlToProject() {
		robot.addUrlToProject(ALTOVA_COM);
		assertAreas(PROJECT);
	}

	@Test
	public final void testAddActiveFileToProject() {
		robot.newProject();
		robot.openFile(ORGCHART_XML_FILE);
		robot.addActiveFileToProject();
		assertAreas(PROJECT);
	}

	@Test
	public final void testAddActiveAndRelatedFileToProject() {
		robot.newProject();
		robot.openFile(ORGCHART_XML_FILE);
		robot.textView();//In authentic, just active file is added (see #25017)
		robot.addActiveAndRelatedFileToProject();
		assertAreas(PROJECT);
	}

	@Test
	public final void testAddProjectFolderToProject() {
		robot.addProjectFolderToProject("test");
		assertAreas(PROJECT);
	}

	@Test
	public final void testAddExternalFolderToProject() {
		robot.addExternalFolderToProject(MY_EXT_PROJ_FOLDER);
		robot.keyType(KeyEvent.VK_HOME); delay(500); //this is the only possible solution to this horrible browse dialog
		robot.keyType(KeyEvent.VK_ENTER);
		assertAreas(PROJECT);
	}

	@Test
	public final void testAddExternalWebFolderToProject() {
		TextFieldOption url= new TextFieldOption("Server URL:",SSH_ORG_PUB);
		robot.addExternalWebFolderToProject(url,new TextFieldOption("User", "test"), new TextFieldOption("Password", "test"));
		assertAreas(PROJECT);
	}

	@Test
	public final void testProjectProperties() {
		robot.projectProperties(null);
		assertWindowAndEscape();
	}
	
	@Test
	public final void testFindInProject() {
		robot.activatePane(PROJECT);
		robot.find("example");
		
		for (int i = 0; i < 5; i++) {
			robot.findNext();
			delay(500);
		}
		assertAreas(PROJECT);
	}
	

}
