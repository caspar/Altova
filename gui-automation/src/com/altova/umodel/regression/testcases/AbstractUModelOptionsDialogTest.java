package com.altova.umodel.regression.testcases;

import static com.altova.util.LoggerUtils.logger;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.robots.ScriptMistakeException;
//import com.altova.spy.AbstractSpyOptionsDialogTest;
import com.altova.umodel.regression.gui.UModelRobot;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.nativegui.ComponentInfo;
import com.altova.nativegui.NativeGUI;
import com.altova.robots.CheckboxOption;
import com.altova.robots.ColorOption;
import com.altova.robots.DropDownOption;
import com.altova.robots.FontOption;

import com.altova.robots.RadioOption;
import com.altova.robots.ScriptMistakeException;
import com.altova.robots.TextFieldOption;
import com.altova.robots.TextFontOption;
import com.altova.robots.FontOption.FontSettings;
import com.altova.spy.SpyRobot;
import com.altova.util.ClipboardUtils;
import com.altova.util.IOUtils;
import com.altova.util.Settings.AltovaApplication;


public class AbstractUModelOptionsDialogTest extends AbstractJUnitTest{

	protected static UModelRobot robot;
	protected static final File BANK_UMP_FILE = IOUtils.findFile("examples_UModel/Bank_Java.ump");
	protected static final String BANK_UMP = BANK_UMP_FILE.getAbsolutePath();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new UModelRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		delay(500);
		//robot.openFile(ORGCHART_XML_FILE);
		//robot.activateOptionsDialog();
		delay(4000);
		
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		try {
			robot.closeAllDiagrams();
		} catch(ScriptMistakeException e) {
			logger.fine("Could not close files - probably none open: "+e);
		}
	}
	
	public static void setRobot(UModelRobot robot) {
		//AbstractSpyOptionsDialogTest.robot = robot;
	}
	
	
	
	
}
