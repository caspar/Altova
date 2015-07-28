package com.altova.mapforce;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Ignore;
import org.junit.Test;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;

import com.altova.nativegui.NativeGUI;
import com.altova.robots.CheckboxOption;
import com.altova.robots.Options;
import com.altova.robots.RadioOption;
import com.altova.robots.ScriptMistakeException;

import com.altova.util.AltovaJUnitRunner;
import com.altova.util.IOUtils;
import com.altova.util.RegressionAssert;
import com.altova.util.Settings;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.PRJ_WINDOW_MAPFORCE;
import static com.altova.mapforce.MapForceRobot.MESSAGES;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;

/**
 * @author b.lopez
 *
 */

//@TestRobot(VSnetMapForceRobot.class)
public class FileMenuTest extends AbstractMapForceTest {

	
	private static final File PROJECT_SAVEPROJECT_MFP = new File(FILE_OUTPUT_PATH.getAbsolutePath()+"\\new_saveprojecttest.mfp");
	private static final File COMPLETE_PO_MFD_SAVED_AS=new File(FILE_OUTPUT_PATH.getAbsolutePath()+"\\savedAsTest.mfd");
	private static final File INSPECTION_REPORT_MFD=IOUtils.findFile("examples/InspectionReport.mfd");
	private static final File SHORT_APPLICATION_INFO_MFD=IOUtils.findFile("examples/ShortApplicationInfo.mfd");
	private static final String foldername="Test_folder";
	private static final File RECENTPROJECTS_1_MFP = new File(FILE_OUTPUT_PATH.getAbsolutePath()+"\\First_Project.mfp");
	private static final File RECENTPROJECTS_2_MFP = new File(FILE_OUTPUT_PATH.getAbsolutePath()+"\\Second_Project.mfp");
	private static final File TTP_34418_MFD = IOUtils.findFile("examples/TTP34418/SupportTest.mfd");
	
	
	
	@Test
	@IgnoreRobots({EclipseMapForceRobot.class})
	public void testNewMapping(){
		robot.newMFFile("Mapping");
		delay(1000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	@IgnoreRobots({VSnetMapForceRobot.class,EclipseMapForceRobot.class}) 
	public void testNewProjectFile(){
		if(PROJECT_SAVED_MFP.exists()){
			PROJECT_SAVED_MFP.delete();
		}
		robot.newMFFile("Project File");
		delay(1000);
		assertEquals("Save Project As",NativeGUI.getForegroundWindowInfo().getWindowText());
		robot.typeStringEnter(PROJECT_SAVED_MFP.getAbsolutePath());
		assertAreas(PRJ_WINDOW_MAPFORCE);
	}
	
	@Test
	@IgnoreRobots({VSnetMapForceRobot.class,EclipseMapForceRobot.class}) 
	public void testNewWebServiceProject(){
		if(WEBSERVICE_PROJECT_MFP.exists()){
			WEBSERVICE_PROJECT_MFP.delete();
		}
		robot.newMFFile("Web Service");
		delay(1000);
		robot.insertWebServiceDialog(UPSRATES_WSDL_FILE,null);
		assertEquals("Save Project As",NativeGUI.getForegroundWindowInfo().getWindowText());
		robot.typeStringEnter(WEBSERVICE_PROJECT_MFP.getAbsolutePath());
		
		assertAreas(PRJ_WINDOW_MAPFORCE);
	}
	
	
	@Test
	public void testOpenFile(){
		robot.openFile(COMPLETE_PO_MFD);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testOpenXBRLFile(){
		robot.openFile(TTP_34418_MFD);
		delay(20000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testSaveFileAs(){
		if(COMPLETE_PO_MFD_SAVED_AS.exists()){
			COMPLETE_PO_MFD_SAVED_AS.delete();
		}
		robot.openFile(COMPLETE_PO_MFD);
		robot.saveFileAs(COMPLETE_PO_MFD_SAVED_AS.getAbsolutePath());
		delay(1000);
		
		assertFileExists(COMPLETE_PO_MFD_SAVED_AS);
		robot.openFile(COMPLETE_PO_MFD_SAVED_AS);
		assertAreas(DIAGRAM_MAIN_WINDOW,MESSAGES);
	}
	
	@Test
	public void testReloadFile(){
		delay(2000);
		robot.selectAll();
		robot.delete();
		robot.leftClickMid(NativeGUI.getForegroundWindowInfo().getLocation());//till the fix 29638
		robot.reload();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testCloseFile(){
		robot.closeSaveNoChanges();
		if (Settings.isVS2010()) {
			try {
				robot.leftClickMenuItem("View", "MapForce","Zoom");//This item should not be available if all mapforce windows are closed
				throw new AssertionError("'Close File' test failed. It seems there is still an opened document");
			} catch (ScriptMistakeException e) {
				assertEquals(e.getMessage(),
						("Could not find menu item View - MapForce - Zoom"));
			}
		} else {
			assertNull(robot.getDiagramComponent());
		}
	}
	
	@Test
	public void testCloseAll(){
		robot.openFile(COMPLETE_PO_MFD);
		robot.closeAllSaveNoChanges();
		if (Settings.isVS2010()) {
			try {
				robot.leftClickMenuItem("View", "MapForce","Zoom");//This item should not be available if all mapforce windows are closed
				throw new AssertionError("'Close All' test failed. It seems there is still an opened document");
			} catch (ScriptMistakeException e) {
				assertEquals(e.getMessage(),
						("Could not find menu item View - MapForce - Zoom"));
			}
		} else {
			assertNull(robot.getDiagramComponent());
		}
	}
	
	@Test
	@IgnoreRobots({VSnetMapForceRobot.class,EclipseMapForceRobot.class}) 
	public void testSaveProjectAndReopen(){
		if(PROJECT_SAVEPROJECT_MFP.exists()){
			PROJECT_SAVEPROJECT_MFP.delete();
		}
		robot.newMFFile("Project File");
		delay(1000);
		assertEquals("Save Project As",NativeGUI.getForegroundWindowInfo().getWindowText());
		robot.typeStringEnter(PROJECT_SAVEPROJECT_MFP.getAbsolutePath());
		robot.delay(500);
		robot.createFolderInProject(foldername,null);
		delay(500);
		robot.keyType(KeyEvent.VK_PLUS);
		robot.saveProject();
		robot.closeProject();
		assertFileExists(PROJECT_SAVEPROJECT_MFP);
		robot.openFile(PROJECT_SAVEPROJECT_MFP);
		assertAreas(PRJ_WINDOW_MAPFORCE);
	}
	
	@Test
	@IgnoreRobots({VSnetMapForceRobot.class,EclipseMapForceRobot.class}) 
	public void testCloseProject(){
		if(PROJECT_SAVEPROJECT_MFP.exists()){
			PROJECT_SAVEPROJECT_MFP.delete();
		}
		robot.newMFFile("Project File");
		delay(1000);
		assertEquals("Save Project As",NativeGUI.getForegroundWindowInfo().getWindowText());
		robot.typeStringEnter(PROJECT_SAVEPROJECT_MFP.getAbsolutePath());
		robot.delay(500);
		robot.closeProject();
		assertAreas(PRJ_WINDOW_MAPFORCE);
	}
	
	@Test
	public void testValidateMapping(){
		robot.validateMapping();
		assertAreas(MESSAGES);
	}
	
	@Test
	public void testMappingSettings(){
		robot.mappingSettings();
		assertWindowAndEscape();
	}
	
	@Test
	public void testGenerateCodeInSelectedLanguageJava(){
		robot.openFile(INSPECTION_REPORT_MFD);
		robot.outputJava();
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"Java_preSel");
		robot.generateCodeInSelectedLanguage(ROOT_PATH);
		delay(2000);
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\com\\mapforce\\InspectionReport\\InspectionReportDocument.java"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\com\\altova\\xml\\XmlFormatter.java"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\.project"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\build.xml"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\.classpath"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Mapping.jpx"));
		assertAreas(MESSAGES);
	}
	
	@Test
	public void testGenerateCodeInSelectedLanguageCsharp(){
		robot.openFile(INSPECTION_REPORT_MFD);
		robot.outputCSharp();
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"CSharp_preSel");
		robot.generateCodeInSelectedLanguage(ROOT_PATH);
		delay(2000);
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Altova\\Altova.csproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\AltovaFunctions\\AltovaFunctions.csproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\AltovaText\\AltovaText.csproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\AltovaXML\\AltovaXML.csproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\InspectionReport\\InspectionReport.csproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Mapping\\Mapping.sln"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Mapping\\Mapping.csproj"));
		assertAreas(MESSAGES);
	}
	
	@Test
	public void testGenerateCodeInSelectedLanguageCpp(){
		robot.openFile(INSPECTION_REPORT_MFD);
		robot.outputCpp();
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"CPP_preSel");
		robot.generateCodeInSelectedLanguage(new File(FILE_OUTPUT_PATH,"CPP_preSel"));
		delay(2000);
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Altova\\Altova.vcproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\AltovaFunctions\\AltovaFunctions.vcproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\AltovaText\\AltovaText.vcproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\AltovaXML\\AltovaXML.vcproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\InspectionReport\\InspectionReport.vcproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Mapping\\Mapping.sln"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Mapping\\Mapping.vcproj"));
		assertAreas(MESSAGES);
	}
	
	@Test
	public void testGenerateCodeXSLT(){
		robot.openFile(SHORT_APPLICATION_INFO_MFD);
		robot.outputXslt();
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"XSLT1_preSel");
		robot.generateCodeInSelectedLanguage(ROOT_PATH);
		delay(2000);
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\DoTransform.bat"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\MappingMapToShortInfo.xslt"));
		assertAreas(MESSAGES);
	}
	
	@Test
	public void testGenerateCodeXSLT2(){
		robot.openFile(SHORT_APPLICATION_INFO_MFD);
		robot.outputXslt2();
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"XSLT2_preSel");
		robot.generateCodeInSelectedLanguage(ROOT_PATH);
		delay(2000);
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\DoTransform.bat"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\MappingMapToShortInfo.xslt"));
		assertAreas(MESSAGES);
	}
	
	@Test
	public void testGenerateCodeXquery(){
		robot.openFile(COMPLETE_PO_MFD);
		robot.outputXq();
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"XQUERY_preSel");
		robot.generateCodeInSelectedLanguage(ROOT_PATH);
		delay(2000);
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\DoTransform.bat"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\MappingMapToCompletePO.xq"));
		assertAreas(MESSAGES);
	}
	/* Generate Code In menu has changed, and it is not possible to run without fail.
	@Test
	public void testGenerateCodeInXSLT1(){
		robot.openFile(SHORT_APPLICATION_INFO_MFD);
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"XSLT1_postSel");
		robot.generateCodeIn("XSLT 1.0",ROOT_PATH);
		delay(2000);
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\DoTransform.bat"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\MappingMapToShortInfo.xslt"));
		assertAreas(MESSAGES);
	}
	
	@Test
	public void testGenerateCodeInXSLT2(){
		robot.openFile(SHORT_APPLICATION_INFO_MFD);
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"XSLT2_postSel");
		robot.generateCodeIn("XSLT 2.0",ROOT_PATH);
		delay(2000);
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\DoTransform.bat"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\MappingMapToShortInfo.xslt"));
		assertAreas(MESSAGES);
	}
	
	@Test
	public void testGenerateCodeInXquery(){
		robot.openFile(COMPLETE_PO_MFD);
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"XQUERY_postSel");
		robot.generateCodeIn("XQuery",ROOT_PATH);
		delay(2000);
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\DoTransform.bat"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\MappingMapToCompletePO.xq"));
		assertAreas(MESSAGES);
	}
	
	@Test
	public void testGenerateCodeInJava(){
		robot.openFile(INSPECTION_REPORT_MFD);
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"Java_postSel");
		robot.generateCodeIn("Java",ROOT_PATH);
		delay(2000);
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\com\\mapforce\\InspectionReport\\InspectionReportDocument.java"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\com\\altova\\xml\\XmlFormatter.java"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\.project"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\build.xml"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\.classpath"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Mapping.jpx"));
		assertAreas(MESSAGES);
	}
	
	@Test
	public void testGenerateCodeInCsharp(){
		robot.openFile(INSPECTION_REPORT_MFD);
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"CSharp_postSel");
		robot.generateCodeIn("C#",ROOT_PATH);
		delay(2000);
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Altova\\Altova.csproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\AltovaFunctions\\AltovaFunctions.csproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\AltovaText\\AltovaText.csproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\AltovaXML\\AltovaXML.csproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\InspectionReport\\InspectionReport.csproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Mapping\\Mapping.sln"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Mapping\\Mapping.csproj"));
//		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\PollutantsReport\\PollutantsReport.sln"));
//		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\PollutantsReport\\PollutantsReport.csproj"));
		assertAreas(MESSAGES);
	}
	
	@Test 
	public void testGenerateCodeInCpp(){
		robot.openFile(INSPECTION_REPORT_MFD);
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"CPP_postSel");
		robot.generateCodeIn("C++",ROOT_PATH);
		delay(2000);
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Altova\\Altova.vcproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\AltovaFunctions\\AltovaFunctions.vcproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\AltovaText\\AltovaText.vcproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\AltovaXML\\AltovaXML.vcproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\InspectionReport\\InspectionReport.vcproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Mapping\\Mapping.sln"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Mapping\\Mapping.vcproj"));
		assertAreas(MESSAGES);
	}
	*/
	
	@Test
	@IgnoreRobots({EclipseMapForceRobot.class})
	public void testRecentFiles(){
		robot.openFile(COMPLETE_PO_MFD);
		robot.recentFilesList(CUSTOMERS_DB_MFD.getName().replace(".mfd", ""));
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	@IgnoreRobots({VSnetMapForceRobot.class,EclipseMapForceRobot.class}) 
	public void testRecentProjects(){
		if(RECENTPROJECTS_1_MFP.exists()){
			RECENTPROJECTS_1_MFP.delete();
		}
		if(RECENTPROJECTS_2_MFP.exists()){
			RECENTPROJECTS_2_MFP.delete();
		}
		robot.newMFFile("Project File");
		delay(1000);
		assertEquals("Save Project As",NativeGUI.getForegroundWindowInfo().getWindowText());
		robot.typeStringEnter(RECENTPROJECTS_1_MFP.getAbsolutePath());
		robot.delay(500);
		robot.newMFFile("Project File");
		delay(1000);
		assertEquals("Save Project As",NativeGUI.getForegroundWindowInfo().getWindowText());
		robot.typeStringEnter(RECENTPROJECTS_2_MFP.getAbsolutePath());
		robot.delay(500);
		robot.recentProjectsList(RECENTPROJECTS_1_MFP.getName().replace(".mfd", ""));
		assertAreas(PRJ_WINDOW_MAPFORCE);
	}
	
}

