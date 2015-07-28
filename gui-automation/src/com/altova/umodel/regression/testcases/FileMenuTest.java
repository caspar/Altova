package com.altova.umodel.regression.testcases;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.umodel.regression.gui.UModelRobot.MODEL_TREE;
import static com.altova.umodel.regression.gui.UModelRobot.MESSAGES;
import static com.altova.util.LoggerUtils.logger;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.RadioOption;
import com.altova.robots.Pane.PaneSize;
import com.altova.umodel.regression.gui.EclipseUModelRobot;
import com.altova.umodel.regression.gui.UModelRobot;
import com.altova.umodel.regression.gui.VSnetUModelRobot;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.IOUtils;
import com.altova.util.RegressionAssert;
import com.altova.util.Settings;

import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;


//@TestRobot(VSnetUModelRobot.class)
//@TestRobot(EclipseUModelRobot.class)
public class FileMenuTest extends AbstractUmodelTest {

	
	protected static final String MY_DIAGRAM__PNG="testSaveDiagramAsImage_PNG.png";
	protected  final File MY_DIAGRAM_FILE_PNG=new File(BASE_OUT_DIR+"\\"+MY_DIAGRAM__PNG);
	protected static final String MY_DIAGRAM_EMF="testSaveDiagramAsImage_EMF.emf";
	protected  final File MY_DIAGRAM_FILE_EMF=new File(BASE_OUT_DIR+"\\"+MY_DIAGRAM_EMF);
	
	protected  final String ALL_DIAGRAMS_PNG = BASE_OUT_DIR+"\\testSaveAllDiagramsAsImages_PNG";
	protected  final File ALL_DIAGRAMS_PNG_FILE = new File(ALL_DIAGRAMS_PNG);
	
	protected  final String ALL_DIAGRAMS_EMF = BASE_OUT_DIR+"\\testSaveAllDiagramsAsImages_EMF";
	protected  final File ALL_DIAGRAMS_EMF_FILE = new File(ALL_DIAGRAMS_EMF);
	
	protected static final File BANK_JAVA_READONLY=IOUtils.findFile("examples_UModel/Bank_Java_readOnly.ump");
	
	//-----------------------------               FILE MENU  -----------------------------
	
	@Test
	public final void testNewPrj() {
		robot.newPrj();
		
		if(!Settings.isVS2010()){ //these steps cannot/should not be done for VS2010
			robot.activatePane(UModelRobot.MODEL_TREE);
			assertNull(robot.getDiagramComponent());
		}
		assertAreas(MODEL_TREE);
	}
	
	@Test
	public final void testLoadPrj() {
		//robot.newPrj();
		robot.openPrj(BANK_UMP);
		if(!Settings.isVS2010()){
		robot.setModelTreeSize(PaneSize.NORMAL);
		}
		robot.openDiagram("BankView Main");
		assertAreas(DIAGRAM_MAIN_WINDOW, MODEL_TREE);
	}

	@Test
	@IgnoreRobots(EclipseUModelRobot.class) //Reload in eclipse is accessed from the dropdown menu
	public final void testReloadProject(){
		robot.openDiagram(CLASS_DIAGRAM);
		robot.selectAll();
		robot.delete();
		robot.reloadProject();
		delay(2000);
		if(!Settings.isVS2010()){
		assertNull(robot.getDiagramComponent());
		}
		robot.openDiagram(CLASS_DIAGRAM);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	@IgnoreRobots(EclipseUModelRobot.class) 
	/**The actions required for this test in eclipse keep 
	being buggy and crash frequently: we leave this test for better times **/
	public final void testSaveReplacePrj() {
		
		removeAndAssert(MY_UMP_FILE);
		
		assertFileNotExists(MY_UMP_FILE);
		robot.saveReplacePrj(MY_UMP_FILE.getAbsolutePath());
		assertFileExists(MY_UMP_FILE);
	}
	
	@Test
	//this test is not relevant for the plugins, as this is controlled by eclipse or VS
	@IgnoreRobots({EclipseUModelRobot.class,VSnetUModelRobot.class}) //saveReplaceProject() is used to execute this test as well
	public final void testSaveAttemptReadOnlyFile(){
		robot.openPrj(BANK_JAVA_READONLY.getAbsolutePath());
		robot.saveReplacePrj(BANK_JAVA_READONLY.getAbsolutePath());
		delay(500);
		robot.escapeDialog("The project file format version has changed.", KeyEvent.VK_Y);
		delay(1000);
		robot.escapeDialog("Access to "+BANK_JAVA_READONLY.getAbsolutePath()+" was denied.", KeyEvent.VK_ESCAPE);
		assertAreas(MESSAGES);
	}

	@Test
	public final void testSaveDiagramAsImage_PNG(){
		if(MY_DIAGRAM_FILE_PNG.exists()) {
			MY_DIAGRAM_FILE_PNG.delete();
		}
		assertFileNotExists(MY_DIAGRAM_FILE_PNG);
		robot.openDiagram(CLASS_DIAGRAM);
		robot.saveDiagramAsImage(MY_DIAGRAM_FILE_PNG.getAbsolutePath());
		assertImage(new File(BASE_EXPECTED_DIR+"\\"+MY_DIAGRAM__PNG), MY_DIAGRAM_FILE_PNG);
		
	}
	
	@Test
	public final void testSaveDiagramAsImage_EMF(){
		if(MY_DIAGRAM_FILE_EMF.exists()) {
			MY_DIAGRAM_FILE_EMF.delete();
		}
		assertFileNotExists(MY_DIAGRAM_FILE_EMF);
		robot.openDiagram(CLASS_DIAGRAM);
		robot.saveDiagramAsImage(MY_DIAGRAM_FILE_EMF.getAbsolutePath());
		assertFileExists(MY_DIAGRAM_FILE_EMF);
		
	}
	
	@Test
	public final void testSaveAllDiagramsAsImages_PNG(){
		IOUtils.deleteAll(ALL_DIAGRAMS_PNG_FILE);
		assertFileNotExists(ALL_DIAGRAMS_PNG_FILE);
		robot.openPrj(VB_TEST_UMP);
		RadioOption format = new RadioOption("PNG","Image Format");
		robot.saveAllDiagramsAsImages(ALL_DIAGRAMS_PNG,format);
		assertImage(new File(BASE_EXPECTED_DIR+"\\testSaveAllDiagramsAsImages_PNG\\Content of HowTo.png"),new File(ALL_DIAGRAMS_PNG+"\\Content of HowTo.png"));
		assertImage(new File(BASE_EXPECTED_DIR+"\\testSaveAllDiagramsAsImages_PNG\\Content of SerializingObjects.png"),new File(ALL_DIAGRAMS_PNG+"\\Content of SerializingObjects.png"));
		assertImage(new File(BASE_EXPECTED_DIR+"\\testSaveAllDiagramsAsImages_PNG\\Content of How-To Serializing Objects.png"),new File(ALL_DIAGRAMS_PNG+"\\Content of How-To Serializing Objects.png"));
		assertImage(new File(BASE_EXPECTED_DIR+"\\testSaveAllDiagramsAsImages_PNG\\Content of How-To Serializing Objects and all subpackages.png"),new File(ALL_DIAGRAMS_PNG+"\\Content of How-To Serializing Objects and all subpackages.png"));
	}
	
	@Test
	public final void testSaveAllDiagramsAsImages_EMF(){
		IOUtils.deleteAll(ALL_DIAGRAMS_EMF_FILE);
		assertFileNotExists(ALL_DIAGRAMS_EMF_FILE);
		robot.openPrj(VB_TEST_UMP);
		RadioOption format = new RadioOption("EMF","Image Format");
		robot.saveAllDiagramsAsImages(ALL_DIAGRAMS_EMF,format);
		assertFileExists(new File(ALL_DIAGRAMS_EMF+"\\Content of HowTo.emf"));
		assertFileExists(new File(ALL_DIAGRAMS_EMF+"\\Content of SerializingObjects.emf"));
		assertFileExists(new File(ALL_DIAGRAMS_EMF+"\\Content of How-To Serializing Objects.emf"));
		assertFileExists(new File(ALL_DIAGRAMS_EMF+"\\Content of How-To Serializing Objects and all subpackages.emf"));
	}
	@Test
	public final void testExportXMI() {
		
		removeAndAssert(MY_XMI_TO_EXPORT_FILE);
		
		robot.exportXMI(MY_XMI_TO_EXPORT_FILE.getAbsolutePath());
		assertFileExists(MY_XMI_TO_EXPORT_FILE);
	}
	
	@Test
	public final void testImportXMI() {
		robot.newPrj();
		robot.importXMI(MY_XMI);
		delay(1000);
		assertAreas(MODEL_TREE);
	}

	@Test
	@Ignore public final void testSendByMailCancel() {
		robot.sendByMailCancel();
		assertTrue("Is application under test the front window?", robot.isApplicationFront());
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

}
