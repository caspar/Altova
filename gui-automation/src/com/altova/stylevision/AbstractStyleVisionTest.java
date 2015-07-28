package com.altova.stylevision;

import static com.altova.util.LoggerUtils.logger;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.robots.ScriptMistakeException;
import com.altova.util.IOUtils;
import com.altova.util.Settings.AltovaApplication;
import java.awt.event.KeyEvent;

public class AbstractStyleVisionTest extends AbstractJUnitTest {

	protected static StyleVisionRobot robot;
	
	protected static final String ALTOVA_COM = "http://www.altova.com/support_center.html";
	public static final String StyleVisionExamplesFolder=AltovaApplication.STYLEVISION.getExamplesLocation().getAbsolutePath()+"\\";
//	protected static final String MY_TEST_XML = "C:\\temp\\my_orgChart.xml";
//	protected static final File MY_TEST_XML_FILE = new File(MY_TEST_XML);
	
	protected static final String ORGCHART_SPS_FILE =AltovaApplication.STYLEVISION.getExamplesLocation().getAbsolutePath()+"\\Orgchart.pxf";
//	protected static final File ORGCHART_XSL_FILE = IOUtils.findFile("examples/OrgChart.xsl");
//	protected static final File ITEMS_DTD_FILE = IOUtils.findFile("examples/items.dtd");
//	protected static final File PURCHASE_ORDER_ZIP =new File( AltovaApplication.XMLSPY.getExamplesLocation().getAbsolutePath()+"\\PurchaseOrder.zip");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new StyleVisionRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
		//robot.RestoreToolbars();
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@After
	public void tearDown() throws Exception {
		try {
			//robot.closebyStrgF4();
			robot.keyType(KeyEvent.VK_ESCAPE);//Press Escape to close any open msg window
			logger.fine("Pressed Escape to close any Msg window");
			delay(1000);
			robot.closeAll();
			logger.fine("All files closed now");
		} catch(ScriptMistakeException e) {
			logger.fine("Could not close files - probably none open: "+e);
		}
		super.tearDown();
	}
	
	public static void setRobot(StyleVisionRobot robot) {
		AbstractStyleVisionTest.robot = robot;
	}
	
}
