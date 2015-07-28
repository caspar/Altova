package com.altova.authentic;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.spy.SpyRobot.VALIDATION;
import static java.awt.event.KeyEvent.VK_ENTER;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Test;

import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;
import com.altova.spy.EclipseSpyRobot;

import com.altova.util.IOUtils;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;



public class FileMenuTest extends AbstractAuthenticTest {

	
	private static final String serv_URL="http://qa-w2k3/test_auth/";
	protected static final String XML_URL_FILE=serv_URL+"test/Automation/ExpReport.whatever";
	protected static final String AUTO_URL_FILE=serv_URL+"test/Automation/ExpReport_notwellformed.whatever"; 
	protected static final File EXPREPORT_SPS_FILE=IOUtils.findFile("examples/ExpReport.sps");
	protected static final File SAVEAS_TEST_FILE=new File("C:\\temp\\debug\\SaveAsTest.xml");
	
	
	@Test
	public final void testOpen() {
		robot.openFile(UNICODE_UTF8_HTML_FILE);
		delay(1000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	
	public final void testOpenXMLFileURL(){
		
		TextFieldOption fileURL =new TextFieldOption("File URL:",XML_URL_FILE);
		fileURL.setX2(100);
		RadioOption fileLoad=new RadioOption("Use cache/proxy","File load");
		RadioOption openAs =new RadioOption("XML","Open as:");
		robot.accessURL(null,null,null,fileURL,fileLoad,openAs);
		delay(6000);
		robot.keyType(KeyEvent.VK_ENTER);
		robot.typeString("test");
		robot.keyType(KeyEvent.VK_TAB);
		robot.typeStringEnter("test");
		delay(1000);
		robot.escapeDialog("Authentic view requires this stylesheet to provide a visual editing experience for your XML content.", VK_ENTER);
		delay(500);
		robot.chooseFileDialog(EXPREPORT_SPS_FILE.getAbsolutePath());
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	
	public final void testOpenAutoFileURL(){
		TextFieldOption usr =new TextFieldOption("User","test","Identification");
		TextFieldOption pwd =new TextFieldOption("Password","test","Identification");
		TextFieldOption fileURL =new TextFieldOption("File URL:",AUTO_URL_FILE,null);
		fileURL.setX2(100);
		RadioOption fileLoad=new RadioOption("Use cache/proxy","File load");
		RadioOption openAs =new RadioOption("Auto","Open as:");
		robot.openURL(usr,pwd,null,fileURL,fileLoad,openAs);
		delay(10000);
		robot.escapeDialog("Your license only allows you to edit files in Authentic view.",VK_ENTER);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	public final void testAccessServerURL(){
		TextFieldOption usr =new TextFieldOption("User","test","Identification");
		TextFieldOption pwd =new TextFieldOption("Password","test","Identification");
		TextFieldOption serv =new TextFieldOption("Server URL:",serv_URL,"Available files");
		RadioOption fileLoad=new RadioOption("Use cache/proxy","File load");
		RadioOption openAs =new RadioOption("Auto","Open as:");
		
		robot.accessURL(usr,pwd,serv,null,fileLoad,openAs);
		robot.keyType(KeyEvent.VK_TAB);delay(500);
		robot.keyType(KeyEvent.VK_ENTER);
		delay(10000);
		assertWindowAndEscape();
	}
	
	@Test
	public final void testReloadFileInAuthentic() {
		robot.selectAll();
		robot.delete();
		delay(1000);
		robot.reloadFile();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testReloadFileInTextView() {
		robot.openFileWithoutKnownSPS(EXPREPORT_NOTWELLFORMED_FILE);
		robot.selectAll();
		robot.delete();
		delay(1000);
		robot.reloadFile();
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	public final void testReloadBrowserView(){
		robot.selectAll();
		robot.delete();
		delay(1000);
		robot.browserView();
		delay(2000);
		robot.reloadFile();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testSetEncoding() {
		robot.openFileWithoutKnownSPS(EXPREPORT_NOTWELLFORMED_FILE);
		robot.setEncoding(null);
		robot.keyType(KeyEvent.VK_END);delay(2000);
		robot.keyType(KeyEvent.VK_ENTER);delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testCloseFile() {
		robot.closeFile();
		assertNull(robot.getDiagramComponent());
	}

	@Test
	public final void testCloseAll() {
		robot.closeAll();
		assertNull(robot.getDiagramComponent());
	}
	
	@Test
	public final void testCloseAllButActive() {
		
		robot.openFile(ORGCHART_PXF_FILE);
		robot.closeAllButActive();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public final void testSaveFileAs() {
	        removeAndAssert(SAVEAS_TEST_FILE);
	        robot.saveFileAsNoControl(SAVEAS_TEST_FILE.getAbsolutePath());
	        assertFileExists(SAVEAS_TEST_FILE);
	}

	@Test
	public final void testSaveFileAsPXF() {
	        removeAndAssert(ORGCHARTSAVEAS_PXF_FILE);
	        robot.openFile(ORGCHART_PXF_FILE);
	        delay(1000);
	        robot.saveFileAsNoControl(ORGCHARTSAVEAS_PXF_FILE.getAbsolutePath());
	        assertFileExists(ORGCHARTSAVEAS_PXF_FILE);
	}

	
}
