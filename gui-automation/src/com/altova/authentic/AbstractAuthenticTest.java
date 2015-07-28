/**
 * 
 */
package com.altova.authentic;

import static com.altova.util.LoggerUtils.logger;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.robots.ScriptMistakeException;
import com.altova.spy.AbstractXmlSpyTest;
import com.altova.util.IOUtils;


/**
 * @author b.lopez
 *
 */
public class AbstractAuthenticTest extends AbstractJUnitTest{
	
	protected static AuthenticRobot robot;
	
	protected static final File CONDITIONAL_XML_FILE = IOUtils.findFile("examples/Conditional.xml");
	protected static final File EXPREPORT_NOTWELLFORMED_FILE=IOUtils.findFile("examples/ExpReport_notwellformed.xml");	
	protected static final File CONDITIONAL_NOTVALID_FILE=IOUtils.findFile("examples/Conditional_notvalid.xml");
	protected static final File UNICODE_UTF8_HTML_FILE = IOUtils.findFile("examples/Unicode UTF-8.html");
	protected static final File EXPREPORT_XML_FILE=IOUtils.findFile("examples/ExpReport.xml");
	protected static final File EXPREPORT_XSLT_FILE=IOUtils.findFile("examples/ExpReport.xslt");
	protected static final File ORGCHART_PXF_FILE=IOUtils.findFile("examples/OrgChart.pxf");
	protected static final File ORGCHARTSAVEAS_PXF_FILE=IOUtils.findFile("examples/OrgChartSaveAs.pxf");
	protected static final File RICHEDIT_PXF_FILE = IOUtils.findFile("examples/RichEdit.pxf");
	
	protected static final File GREEN_COLOR_PALETTE_ICON = IOUtils.findFile("res/greencolorpalette.png");
	protected static final File RED_COLOR_PALETTE_ICON = IOUtils.findFile("res/redcolorpalette.png");
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new AuthenticRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
	}

	@Before
	public void setUp() throws Exception {

		super.setUp();

		robot.openFile(CONDITIONAL_XML_FILE);
		delay(1000);
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
	
	public static void setRobot(AuthenticRobot robot) {
		AbstractAuthenticTest.robot = robot;
	}
	
}
