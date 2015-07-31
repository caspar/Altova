package com.altova.umodel.regression.testcases;

import static com.altova.robots.SnapshotArea.CommonArea.*;
import static com.altova.util.LoggerUtils.logger;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.RadioOption;
import com.altova.umodel.regression.gui.EclipseUModelRobot;
import com.altova.umodel.regression.gui.VSnetUModelRobot;
import com.altova.util.SuiteLogLevel;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;

//@TestRobot(EclipseUModelRobot.class)
public class ToolsMenuTest extends AbstractUmodelTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.log(SuiteLogLevel.SUITE, "ToolsMenuTest");
		AbstractUmodelTest.setUpBeforeClass();
	}
	
	//-----------------------------               TOOLS MENU  -----------------------------
	
	@After
	public void tearDown() {
		//special case to escape the "half-modal" dialog Customize
		Rectangle r = robot.findComponentName("Customize");
		if(r != null) {
			robot.leftClickMid(r);
			
		}
		
		robot.keyType(KeyEvent.VK_ESCAPE);  //exit the dialog
	}
	
	@Test
	@IgnoreRobots({EclipseUModelRobot.class, VSnetUModelRobot.class})
	public final void testCustomize() {
		robot.customize();
		assertForegroundWindow("Customize");
		//Note: "Tools" and "Toolbars" are getting the same screenshot...unfortunately robot doesn´t find any diff 
		robot.switchTabsAndGetScreenshot(getTestName(), "Customize", "Commands", "Toolbar", "Tools", "Keyboard", "Menu", "Macros", "Plug-Ins", "Options");
		robot.keyType(KeyEvent.VK_ESCAPE);
	}
	
	@Ignore
	@Test
	public final void testOptions() {
		CheckboxOption title = new CheckboxOption("Show on print",true, "Program logo", null, null, "View",MS_SHELL_DLG_FONT);
		robot.setOptions(title);
	}
}
