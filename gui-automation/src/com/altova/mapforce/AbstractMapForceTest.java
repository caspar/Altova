package com.altova.mapforce;

import static com.altova.util.LoggerUtils.logger;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.robots.ScriptMistakeException;
import com.altova.umodel.regression.gui.UModelRobot;
import com.altova.util.IOUtils;
import com.altova.util.RegressionAssert;
import com.altova.util.Settings;
import com.altova.mapforce.MapForceRobot;


public class AbstractMapForceTest extends AbstractJUnitTest{

	protected static MapForceRobot robot;
	protected static File CUSTOMERS_DB_MFD=IOUtils.findFile("examples/Customers_DB.mfd");
	protected static File COMPLETE_PO_MFD=IOUtils.findFile("examples/CompletePO.mfd");
	protected static File EDI_ORDER_REVERSE_MFD = IOUtils.findFile("examples/EDI_OrderReverse.mfd");
	protected static File EXCEL_COMPANY_TOXML_FILE=IOUtils.findFile("examples/Excel_Company_to_XML.mfd");
	protected static final File UPSRATES_WSDL_FILE=IOUtils.findFile("examples/UPSRates.wsdl");
	protected static final File FILE_OUTPUT_PATH=new File("C:\\temp\\mapforce");
	protected static final File COMPLETE_POWS_MFD=IOUtils.findFile("examples/CompletePOws.mfd");
	protected static final File PROJECT_SAVED_MFP = new File(FILE_OUTPUT_PATH.getAbsolutePath()+"\\new_test_project.mfp");
	protected static final File WEBSERVICE_PROJECT_MFP = new File(FILE_OUTPUT_PATH.getAbsolutePath()+"\\new_webservice_test_project.mfp");
	protected final String ORDERS_COMPONENT = IOUtils.findFile("tags_list/ORDERS_TAG.PNG").getAbsolutePath();
	protected final String COMPLETEPO_COMPONENT = IOUtils.findFile("tags_list/COMPLETEPO_XSD_TAG.PNG").getAbsolutePath();
	protected final String ALTOVADB_COMPONENT = IOUtils.findFile("tags_list/ALTOVA_DB_TAG.PNG").getAbsolutePath();
	protected final String CUSTOMERS_ADDRESSES = IOUtils.findFile("tags_list/ADDRESSES_DB_ITEM_TAG.png").getAbsolutePath();
	protected final File CONNECTION_TEST3_MFD=IOUtils.findFile("examples/ConnectionTests3.mfd");
	protected final File INSERTINPUTTEST_MFD=IOUtils.findFile("examples/InsertInputTest.mfd");
	protected final String MIXATTSANDELEMSOUT_COMPONENT=IOUtils.findFile("tags_list/MIXATTSANDELEMSOUT_TAG.PNG").getAbsolutePath();
	protected final String MIXATTSANDELEMS3_COMPONENT=IOUtils.findFile("tags_list/MIXATTSANDELEMS3_TAG.PNG").getAbsolutePath();
	protected final File INSPECTIONREPORT_MFT=IOUtils.findFile("examples/InspectionReport.mft");
	protected static final File NEW_EMPTY_MAPPING_MFD=IOUtils.findFile("examples/New_mapping.mfd");
	static int counter_m = 0;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new MapForceRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
		counter_m = 0;
		IOUtils.deleteAll(FILE_OUTPUT_PATH);
		if(!FILE_OUTPUT_PATH.isDirectory()) {
			FILE_OUTPUT_PATH.mkdirs();
		}
	}

	@Before
	public void setUp() throws Exception {

		super.setUp();
		
//		String junitRun = AltovaJUnitRunner.getCurrentRunName(robot);
		delay(500);
		robot.openFile(CUSTOMERS_DB_MFD);
		delay(3000);
		if(counter_m == 0){
		robot.hideOverviewWindow();
		if (!Settings.isVS2010()) { //it does not work for VS2010, so don't lose time trying it ;)
				robot.setPaneSize(MapForceRobot.MESSAGES, -1, 175);
			}
		}
		counter_m ++;
	}


	@After
	public void tearDown() throws Exception {
		super.tearDown();
		try {
			robot.closeAllSaveNoChanges();
		} catch(ScriptMistakeException e) {
			logger.fine("Could not close files - probably none open: "+e);
		}
		try{
			robot.closeProject();
		} catch(ScriptMistakeException e) {
			logger.fine("Could not close files - probably none open: "+e);
			robot.keyType(KeyEvent.VK_ESCAPE); //escaping the File menu
		}
	}
	
	public static void setRobot(MapForceRobot robot) {
		AbstractMapForceTest.robot = robot;
	}
	
}
