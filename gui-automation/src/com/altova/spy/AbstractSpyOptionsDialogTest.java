package com.altova.spy;

import static com.altova.util.LoggerUtils.logger;
import static com.altova.spy.SpyRobot.*;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.ZIP_VIEW;


import java.awt.Color;
import java.awt.Font;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.common.testcases.AbstractJUnitTest;
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
import com.altova.util.ClipboardUtils;
import com.altova.util.IOUtils;
import com.altova.util.Settings.AltovaApplication;

public class AbstractSpyOptionsDialogTest extends AbstractJUnitTest{
	
	protected static SpyRobot robot;
	protected static final File ORGCHART_XML_FILE = IOUtils.findFile("examples/OrgChart.xml");
	protected static final File ORGCHART_XSD_FILE = IOUtils.findFile("examples/OrgChart.xsd");
	protected static final File CONDITIONAL_NOT_VALID=IOUtils.findFile("spy/examples/Conditional_notvalid.xml");
	protected static final File TEMPORARY_XML=new File(AltovaApplication.XMLSPY.getExamplesLocation().getAbsolutePath()+"\\delete_me.xml");
	
	protected static final File TEMPORARY_NEW_EXT=new File(AltovaApplication.XMLSPY.getExamplesLocation().getAbsolutePath()+"\\delete_me.blopez");
	protected static final File ITEMS_XML_FILE =IOUtils.findFile("examples/items.xml");
	protected static final File NEW_EXT_XML_FILE = IOUtils.findFile("examples/cars1.blopez");
	protected static final File TIMESERVICE_WSDL=IOUtils.findFile("examples/TimeService.wsdl");
	protected static final File DOCUM_ABSPATH_FILE = new File("C:\\temp\\Docum\\docum.html");
	protected static final File SCHEMA_NILLABLE_XSD_FILE = IOUtils.findFile("examples/schema_nillable.xsd");
	protected static final File STRINGQ4_XQ_FILE=IOUtils.findFile("examples/stringQ4.xq");
	protected static final File CSS_FILE=IOUtils.findFile("examples/Css-fonts.css");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new SpyRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		delay(500);
		robot.openFile(ORGCHART_XML_FILE);
		robot.activateOptionsDialog();
		delay(4000);
		
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		try {
			robot.closeAll();
		} catch(ScriptMistakeException e) {
			logger.fine("Could not close files - probably none open: "+e);
		}
	}
	
	public static void setRobot(SpyRobot robot) {
		AbstractSpyOptionsDialogTest.robot = robot;
	}		
		
}


