package com.altova.spy;

import static com.altova.util.LoggerUtils.logger;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.robots.ScriptMistakeException;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.IOUtils;
import com.altova.util.Settings.AltovaApplication;


public class AbstractXmlSpyTest extends AbstractJUnitTest {

	protected static SpyRobot robot;
	
	protected static final String ALTOVA_COM = "http://www.altova.com/support_center.html";
	
	protected static final String MY_TEST_XML = "C:\\temp\\my_orgChart.xml";
	protected static final File MY_TEST_XML_FILE = new File(MY_TEST_XML);
	
	protected static final File ORGCHART_XML_FILE = IOUtils.findFile("spy/examples/OrgChart.xml");
	protected static final File ORGCHART_XSD_FILE = IOUtils.findFile("spy/examples/OrgChart.xsd");
	protected static final File ORGCHART_XSL_FILE = IOUtils.findFile("spy/examples/OrgChart.xsl");
	protected static final File ITEMS_DTD_FILE = IOUtils.findFile("spy/examples/items.dtd");
	protected static final File PURCHASE_ORDER_ZIP =new File( AltovaApplication.XMLSPY.getExamplesLocation().getAbsolutePath()+"\\PurchaseOrder.zip");
	protected static final File TIMESERVICE_WSDL_FILE = IOUtils.findFile("spy/examples/TimeService.wsdl");
	protected static final File TIMESERVICE_WSDL20_FILE=IOUtils.findFile("spy/examples/TimeService20.wsdl");
	protected static final File MULTIPLEWSDLIMPORTS_WSDL20_FILE=IOUtils.findFile("spy/examples/MultipleWSDLImports1.wsdl");
	protected static final File MULTIPLEWSDLINCLUDES_WSDL20_FILE=IOUtils.findFile("spy/examples/use_Description3.wsdl");
	protected static final File TIMESERVICESMALL_WSDL_FILE=IOUtils.findFile("spy/examples/TimeService_small.wsdl");
	protected static final File XSDIMPWITHINLSCHEMA_WSDL20_FILE=IOUtils.findFile("spy/examples/XSDImport_withInlinedSchema.wsdl");
	protected static final File TEXTSTATE_XSD_FILE=IOUtils.findFile("spy/examples/TextState.xsd");
	protected static final File DOCGEN_WSDL_FILE=IOUtils.findFile("spy/examples/DocumGenExample.wsdl");
	protected static final File XSDINCLUDEDANDIMPORTED_WSDL20_FILE=IOUtils.findFile("spy/examples/getBalance.wsdl");
	protected static final File XSDIMPORTSTEST_WSDL20_FILE=IOUtils.findFile("spy/examples/getBalanceDoubleImport.wsdl");
	protected static final File MINMAXTEMPERATURE2009_XML_FILE = IOUtils.findFile("spy/examples/MinMax_Temperatures2009.xml");
	protected static final File MINMAXTEMPERATURE2009CS_XML_FILE = IOUtils.findFile("spy/examples/MinMax_Temperatures2009_CS.xml");
	protected static final File INOUTVARIUSDEPTHS_XML_FILE = IOUtils.findFile("spy/examples/InOut_variousDepths.xml");
	protected static final File ITEMS_XML_FILE = IOUtils.findFile("spy/examples/items.xml");
	protected static final File SETTINGTOLOAD_XML_FILE = IOUtils.findFile("spy/examples/SettingsToLoad.xml");
	protected static final File SETTINGTOSAVE_XML_FILE = IOUtils.findFile("spy/examples/SettingsToSave.xml");
	protected static final File SINCOSATAN_XML_FILE = IOUtils.findFile("spy/examples/Sincosatan.xml");
	protected static final File BIKEANDCARSMPH_XML_FILE = IOUtils.findFile("spy/examples/BikesAndCars_mph.xml");
	protected static final File MICROSOFTSTOCKQUOTE_XML_FILE = IOUtils.findFile("spy/examples/msft2010.xml");
	protected static final File MINMAXTEMPERATURE2010_XML_FILE = IOUtils.findFile("spy/examples/MinMax_Temperatures2010.xml");
	protected static final File MINMAXTEMPERATURE2008_XML_FILE = IOUtils.findFile("spy/examples/MinMax_Temperatures2008.xml");
	protected static final File MINMAXTEMPERATURE2007_XML_FILE = IOUtils.findFile("spy/examples/MinMax_Temperatures2007.xml");
	protected static final File ORGCHART_PXF_FILE = IOUtils.findFile("spy/examples/OrgChart.pxf");
	protected static final File ORGCHART_PXF_FILE_SAVED = IOUtils.findFile("spy/examples/OrgChartSaved.pxf");
	protected static final File ESCAPE_XML_FILE = IOUtils.findFile("spy/examples/EscapeUnescape.xml");
	protected static final File SOAP_DEBUGGER_CLIENT_FILE = IOUtils.findFile("spy/examples/DebuggerClient.htm");
	
	protected static final File RED_COLOR_PALETTE_ICON   = IOUtils.findFile("spy/res/redcolorpalette.png");
	protected static final File GREEN_COLOR_PALETTE_ICON = IOUtils.findFile("spy/res/greencolorpalette.png");
	protected static final File BLUE_COLOR_PALETTE_ICON = IOUtils.findFile("spy/res/bluecolorpalette.png");
	protected static final File YELLOW_COLOR_PALETTE_ICON = IOUtils.findFile("spy/res/yellowcolorpalette.png");
	protected static final File LIGHTGREY_COLOR_PALETTE_ICON = IOUtils.findFile("spy/res/lightgreycolorpalette.png");
	protected static final File LIGHTBLUE_COLOR_PALETTE_ICON = IOUtils.findFile("spy/res/lightbluecolorpalette.png");
	protected static final File MINMAXTEMPERATUREEXPORT = new File(AltovaApplication.XMLSPY.getExamplesLocation().getAbsolutePath()+"\\MinMaxTemperatureExport.png");
	protected static final File NANONULL_GIF_LOGO = IOUtils.findFile("spy/examples/Nanonull.gif");
	
	protected static final File CONDITIONAL_XML_FILE = IOUtils.findFile("spy/examples/XMLDigitalSignatures/Conditional.xml");
	protected static final File Base64_IMG_XML_FILE = IOUtils.findFile("spy/examples/XMLDigitalSignatures/Base64_IMG.xml");
	protected static final File ADDRESS_XSD_FILE = IOUtils.findFile("spy/examples/XMLDigitalSignatures/address.xsd");
	protected static final File TIMESERVICE2_WSDL_FILE = IOUtils.findFile("spy/examples/XMLDigitalSignatures/TimeService.wsdl");
	protected static final File TIMESERVICE20_WSDL_FILE = IOUtils.findFile("spy/examples/XMLDigitalSignatures/TimeService20.wsdl");
	protected static final File JAPANESE_XML_FILE = IOUtils.findFile("spy/examples/XMLDigitalSignatures/Japanese UTF-16.xml");
	protected static final File NANONUL_XML_FILE = IOUtils.findFile("spy/examples/XMLDigitalSignatures/nanonull.xsd");
	protected static final File TC_1_12_XSIG_FILE = IOUtils.findFile("spy/examples/XMLDigitalSignatures/TC_1_12.xsig");
	protected static final File TC_1_10_HELLO_FILE = IOUtils.findFile("spy/examples/XMLDigitalSignatures/TC_1_10.hello");
	protected static final File NANONULLORG_SIGNEDWITHCERT_XML = IOUtils.findFile("spy/examples/XMLDigitalSignatures/NanonullOrg_SignedWithCert.xml");
	protected static final File NANONULLORG_SIGNEDWITHPW_XML = IOUtils.findFile("spy/examples/XMLDigitalSignatures/NanonullOrg_SignedWithPW.xml");
	protected static final File NANONULLORG_SIGNEDWITHPW_PXF = IOUtils.findFile("spy/examples/XMLDigitalSignatures/NanonullOrg_SignedWithPW.pxf");
	
	//protected static final String TRUSTED_LOCATION_FOLDER = "(C:)/work/gui-automation/data/dabasespy/examples";
	protected static final String TRUSTED_LOCATION_FOLDER = " vie.altova.com) (S:)/QA/Internal/Test-Cases/Automated_GUI_Tests/test";
	//protected static final File ORGCHART_PXF_FILE_DBS = IOUtils.findFile("databasespy/examples/OrgChart.pxf");
	protected static final File ORGCHART_PXF_FILE_DBS = IOUtils.findFile("S:/QA/Internal/Test-Cases/Automated_GUI_Tests/test/OrgChart.pxf");
	
	protected static final File NANONUL_XSD_XBRL_FILE = IOUtils.findFile("spy/examples/XBRL/Nanonull/nanonull.xsd");
	protected static final File NANONUL_XSD_XBRL_DIR = IOUtils.findFile("spy/examples/XBRL/Nanonull");

	
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
//		String junitRun = AltovaJUnitRunner.getCurrentRunName(robot);

		//robot.openFile(ITEMS_DTD_FILE);//temporary: just for eclipse 3.3/3.4/3.5 test
		robot.openFile(ORGCHART_XML_FILE.getAbsolutePath(), false, null);

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
		AbstractXmlSpyTest.robot = robot;
	}
	

	
	
}
