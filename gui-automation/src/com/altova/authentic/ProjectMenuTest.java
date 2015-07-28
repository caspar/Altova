package com.altova.authentic;

import static com.altova.spy.SpyRobot.PROJECT;
import static com.altova.spy.SpyRobot.VALIDATION;
import static java.awt.event.KeyEvent.VK_ENTER;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.altova.robots.Options;
import com.altova.robots.TextFieldOption;
import com.altova.util.IOUtils;
import com.altova.util.Settings.AltovaApplication;

public class ProjectMenuTest extends AbstractAuthenticTest {

	protected static final File EXAMPLES_PRJ=new File( AltovaApplication.AUTHENTIC.getExamplesLocation().getAbsolutePath()+"\\Examples.spp");
	protected static final String URL_FOLDER="http://qa-w2k3/webdav/examples/";
	protected static final String URL_FILE_FOR_PROJECT=URL_FOLDER+"Big5.xml";
	protected static final File SAVED_PRJ=new File("C:\\temp\\test_SaveProject.spp");
	
	@Before
	public void setUp() {
		robot.newProject();
		robot.openProject(EXAMPLES_PRJ.getAbsolutePath());
	}
	
	@Test
	
	public final void testNewProject() {
		robot.newProject();
		assertAreas(PROJECT);
	}

	@Test
	public final void testOpenProject() {
		robot.newProject();
		robot.openProject(EXAMPLES_PRJ.getAbsolutePath());
		assertAreas(PROJECT);
	}

	@Test
	public final void testReloadProject() {
		robot.addUrlToProject(URL_FILE_FOR_PROJECT);
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
		removeAndAssert(SAVED_PRJ);
		robot.newProject();
		robot.saveProject(SAVED_PRJ.getAbsolutePath());
		assertAreas(PROJECT);
	}

	@Test
	public final void testAddFilesToProject() {
		robot.newProject();
		robot.addFilesToProject(EXPREPORT_NOTWELLFORMED_FILE.getAbsolutePath());
		assertAreas(PROJECT);
	}

	@Test
	public final void testAddUrlToProject() {
		robot.addUrlToProject(URL_FILE_FOR_PROJECT);
		assertAreas(PROJECT);
	}

	@Test
	public final void testAddActiveFileToProject() {
		robot.newProject();
		robot.openFile(CONDITIONAL_XML_FILE);
		robot.addActiveFileToProject();
		assertAreas(PROJECT);
	}

	@Test
	public final void testAddActiveAndRelatedFileToProject() {
		robot.newProject();
		robot.openFileWithoutKnownSPS(EXPREPORT_NOTWELLFORMED_FILE); //In authentic view, just active file is added (see #25017)
		robot.addActiveAndRelatedFileToProject();
		assertAreas(PROJECT);
	}

	@Test
	public final void testAddProjectFolderToProject() {
		robot.addProjectFolderToProject("AUTHENTIC_test");
		assertAreas(PROJECT);
	}


	@Test
	public final void testAddExternalWebFolderToProject() {
		TextFieldOption url= new TextFieldOption("Server URL:",URL_FOLDER);
		robot.addExternalWebFolderToProject(url,null,null);
		assertAreas(PROJECT);
	}

	@Test
	public final void testProjectProperties() {
		robot.projectProperties(null);
		assertWindowAndEscape();		
	}
	
	@Test
	public final void testCheckWellFormednessInProject(){
		robot.newProject();
		delay(1000);
		robot.addFilesToProject(EXPREPORT_NOTWELLFORMED_FILE.getAbsolutePath());
		delay(2000);
		robot.keyType(KeyEvent.VK_HOME);
		robot.wellformednessCheckViaIcon();
		robot.delay(2000);
		robot.escapeDialog("Your license only allows you to edit files in Authentic view.",VK_ENTER);
		assertAreas(VALIDATION);
	}
	
	@Test
	public final void testValidateProject(){
		robot.newProject();
		delay(1000);
		robot.addFilesToProject(CONDITIONAL_NOTVALID_FILE.getAbsolutePath());
		delay(2000);
		robot.keyType(KeyEvent.VK_HOME);
		robot.validateViaIcon();
		assertAreas(VALIDATION);
	}
	
	@Test
	public final void testFindInProject() {
		robot.activatePane(PROJECT);
		robot.find("example");
		
		for (int i = 0; i < 3; i++) {
			robot.findNext();
			delay(500);
		}
		assertAreas(PROJECT);
	}

	
	
}
