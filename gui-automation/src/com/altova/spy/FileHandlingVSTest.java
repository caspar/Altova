package com.altova.spy;

import java.io.File;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.spy.SpyRobot.VALIDATION;
import org.junit.Test;

import com.altova.util.IOUtils;
import com.altova.util.AltovaJUnitRunner.TestRobot;

//@TestRobot(VSnetSpyRobot.class)
public class FileHandlingVSTest extends AbstractXmlSpyTest{
	
	private static final File TTP_4614_ASP_FILE = IOUtils.findFile("spy/examples/tests.asp");
	private static final File CARS1_BLOPEZ_FILE=IOUtils.findFile("spy/examples/cars1.blopez");
	
	@Test
	public void test_ttp4614(){
		delay(3000);
		robot.openFile(TTP_4614_ASP_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void test_ttp3660(){
		delay(2000);
		robot.activateOptionsDialog();
		robot.addNewFileExtension(".blopez");
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		delay(2000);
		robot.openFileWithXMLSpyEditorInVS(CARS1_BLOPEZ_FILE.getAbsolutePath());
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	public void test_ttp6074(){
		delay(2000);
		robot.openFile(TTP_4614_ASP_FILE);
		robot.openFile(ORGCHART_XSD_FILE);
		robot.closeSolution_InVS();
		delay(2000);
		robot.openFile(ORGCHART_XSL_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
}
