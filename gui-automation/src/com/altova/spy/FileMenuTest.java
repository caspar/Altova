package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.*;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import java.io.File;

import static com.altova.util.LoggerUtils.logger;

import org.junit.Ignore;
import org.junit.Test;

import static com.altova.spy.SpyRobot.*;

import com.altova.nativegui.NativeGUI;
import com.altova.robots.Pane;
import com.altova.robots.RadioOption;
import com.altova.robots.ScriptMistakeException;
import com.altova.robots.TextFieldOption;
import com.altova.util.IOUtils;
import com.altova.util.Settings;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;


//@TestRobot(VSnetSpyRobot.class)
//@TestRobot(EclipseSpyRobot.class)
public class FileMenuTest extends AbstractXmlSpyTest {
	
	
	
	private static final String serv_URL="http://qa-w2k3/test_auth/";
	private static final String XML_file_URL=serv_URL+"test/Automation/ipo.whatever";
	private static final String DTD_file_URL=serv_URL+"test/Automation/news.whatever";
	private static final String Auto_file_URL=serv_URL+"test/Automation/Conditional.sps";
	private static final String ZIP_file_URL=PURCHASE_ORDER_ZIP.getAbsolutePath()+"|zip\\ipo.xml";

	@Test
	public final void testOpen() {
		robot.openFile(ORGCHART_XSL_FILE);
		delay(1000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
//	in .net, you need to specify the zip must be opened with spy
//	in eclipse,the area ZIP_VIEW cannot be found as component names are not named and determined like in spy	
	@IgnoreRobots({EclipseSpyRobot.class,VSnetSpyRobot.class}) 
	public final void testOpenZip() {
		robot.openFile(PURCHASE_ORDER_ZIP);
		delay(1000);
		assertAreas(ZIP_VIEW);
	}

	/**serverURL= http://qa-w2k3/test_auth/
	 * user:test
	 * password:test
	 */
	@Test
	@Ignore //ttp 26160 was closed with "Will not be fixed/implement, so this test will not be performed
	//@IgnoreRobots({EclipseSpyRobot.class,VSnetSpyRobot.class}) //commented as a general ignore is currently set
	public final void testOpenZipFileURL(){
		
		TextFieldOption fileURL =new TextFieldOption("File URL:",ZIP_file_URL,null);
		fileURL.setX2(100);
		RadioOption fileLoad=new RadioOption("Use cache/proxy","File load");
		RadioOption openAs =new RadioOption("XML","Open as:");
		robot.openURL(null,null,null,fileURL,fileLoad,openAs);
		delay(6000);
		robot.keyType(KeyEvent.VK_F8); //validation check
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	@IgnoreRobots({EclipseSpyRobot.class,VSnetSpyRobot.class})
	public final void testOpenXMLFileURL(){
		
		TextFieldOption fileURL =new TextFieldOption("File URL:",XML_file_URL,null);
		fileURL.setX2(100);
		RadioOption fileLoad=new RadioOption("Use cache/proxy","File load");
		RadioOption openAs =new RadioOption("XML","Open as:");
		robot.accessURL(null,null,null,fileURL,fileLoad,openAs);
		delay(6000);
		robot.keyType(KeyEvent.VK_ENTER);
		robot.typeString("test");
		robot.keyType(KeyEvent.VK_TAB);
		robot.typeStringEnter("test");
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	@IgnoreRobots({EclipseSpyRobot.class,VSnetSpyRobot.class})
	public final void testOpenDTDFileURL(){
		TextFieldOption usr =new TextFieldOption("User","test","Identification");
		TextFieldOption pwd =new TextFieldOption("Password","test","Identification");
		TextFieldOption fileURL =new TextFieldOption("File URL:",DTD_file_URL,null);
		fileURL.setX2(100);
		RadioOption fileLoad=new RadioOption("Use cache/proxy","File load");
		RadioOption openAs =new RadioOption("DTD","Open as:");
		robot.openURL(usr,pwd,null,fileURL,fileLoad,openAs);
		delay(10000);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	@IgnoreRobots({EclipseSpyRobot.class,VSnetSpyRobot.class})
	public final void testOpenAutoFileURL(){
		TextFieldOption usr =new TextFieldOption("User","test","Identification");
		TextFieldOption pwd =new TextFieldOption("Password","test","Identification");
		TextFieldOption fileURL =new TextFieldOption("File URL:",Auto_file_URL,null);
		fileURL.setX2(100);
		RadioOption fileLoad=new RadioOption("Use cache/proxy","File load");
		RadioOption openAs =new RadioOption("Auto","Open as:");
		robot.openURL(usr,pwd,null,fileURL,fileLoad,openAs);
		delay(10000);
		robot.keyType(KeyEvent.VK_F8); //validation check
		
		//this following bit is done to test #26600 
		robot.typeString("hi");delay(500);
		robot.keyType(KeyEvent.VK_BACK_SPACE);
		delay(500);	robot.keyType(KeyEvent.VK_BACK_SPACE);
		robot.saveFile();
		
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	@IgnoreRobots({EclipseSpyRobot.class,VSnetSpyRobot.class})
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
		//we make a couple or view changes as it may crash afterwards
		delay(1000);
		robot.textView();
		robot.authenticView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testReloadFileInTextView() {
		robot.textView();
		robot.keyTypeCtrl(KeyEvent.VK_A); //like robot.selectAll() but from the keyboard
		robot.delete();
		delay(1000);
		robot.reloadFile();
		//we make a couple or view changes as it may crash afterwards
		delay(1000);
		robot.browserView();
		delay(1000);
		robot.textView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testReloadFileInGridView() {
		robot.gridView();
		robot.selectAll(); 
		robot.keyType(KeyEvent.VK_DELETE);
		delay(1000);
		robot.reloadFile();
		//we make a couple or view changes as it may crash afterwards
		delay(1000);
		robot.authenticView();
		delay(2000);
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testReloadFileInSchemaView() {
		robot.openFile(ORGCHART_XSD_FILE);
		robot.keyTypeCtrl(KeyEvent.VK_A); //like robot.selectAll() but from the keyboard
		robot.delay(1000);
		robot.keyType(KeyEvent.VK_DELETE);
		delay(1000);
		robot.reloadFile();
		//we make a couple or view changes as it may crash afterwards
		delay(1000);
		robot.textView();
		robot.schemaView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public final void testSetEncoding() {
		
		robot.setEncoding(null);
		robot.keyType(KeyEvent.VK_END);delay(2000);
		robot.keyType(KeyEvent.VK_ENTER);delay(2000);
		robot.textView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testCloseFile() {
		robot.closeFile();
		if (Settings.isVS2010()) {
			try {
				robot.leftClickMenuItem("View", "XMLSpy Tool Windows");//This item should not be available if all spy windows are closed
				throw new AssertionError("'Close File' test failed. It seems there is still an opened document");
			} catch (ScriptMistakeException e) {
				assertEquals(e.getMessage(),
						("Could not find menu item View - XMLSpy Tool Windows"));
			}
		} else {
			assertNull(robot.getDiagramComponent());
		}
	}

	@Test
	public final void testCloseAll() {
		robot.closeAll();
		if (Settings.isVS2010()) {
			try {
				robot.leftClickMenuItem("View", "XMLSpy Tool Windows");//This item should not be available if all spy windows are closed
				throw new AssertionError("'Close All' test failed. It seems there is still an opened document");
			} catch (ScriptMistakeException e) {
				assertEquals(e.getMessage(),
						("Could not find menu item View - XMLSpy Tool Windows"));
			}
		} else {
			assertNull(robot.getDiagramComponent());
		}
	}

	
	@Test
	@IgnoreRobots({EclipseSpyRobot.class, VSnetSpyRobot.class})
	public final void testCloseAllButActive() {
		
		robot.openFile(ORGCHART_PXF_FILE);
		robot.closeAllButActive();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	@Ignore public final void testSaveFile() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	@IgnoreRobots(EclipseSpyRobot.class)
	public final void testSaveFileAs() {
	        removeAndAssert(MY_TEST_XML_FILE);
	        robot.saveFileAs(MY_TEST_XML);
	        assertFileExists(MY_TEST_XML_FILE);
	}
	
	@Test
	@IgnoreRobots(EclipseSpyRobot.class)
	public final void testSaveFilePXFAs() {
	        removeAndAssert(ORGCHART_PXF_FILE_SAVED);
	        robot.openFile(ORGCHART_PXF_FILE);
	        robot.saveFileAs(ORGCHART_PXF_FILE_SAVED.getAbsolutePath());
	        assertFileExists(ORGCHART_PXF_FILE_SAVED);
	}

	@Test
	@Ignore public final void testSaveToURL() {
	        fail("Not yet implemented"); // TODO
	}

	@Test
	@Ignore public final void testSaveAll() {
	        fail("Not yet implemented"); // TODO
	}

	@Test
	@Ignore public final void testSendByMail() {
	        fail("Not yet implemented"); // TODO
	}
	
}
