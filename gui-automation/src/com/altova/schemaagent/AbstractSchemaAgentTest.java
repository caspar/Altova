package com.altova.schemaagent;

import static com.altova.util.LoggerUtils.logger;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.robots.Pane;
import com.altova.robots.ScriptMistakeException;
import com.altova.schemaagent.SchemaAgentRobot.TAB;
import com.altova.util.IOUtils;
import com.altova.util.Settings.AltovaApplication;

public class AbstractSchemaAgentTest extends AbstractJUnitTest {

	protected static SchemaAgentRobot robot;
	
	protected static final File ORGCHART_SAD_FILE = IOUtils.findFile("schemaagent/example/OrgChart.sad");
	protected static final File ORGCHART_SAD_FILE_SAVED = IOUtils.findFile("schemaagent/example/OrgChartSaved.sad");
	protected static final File DB_COMPLETEPO_FILE = IOUtils.findFile("schemaagent/example/DB_CompletePO/DB_CompletePO.sad");
	protected static final File DB_COMPLETEPO_MAPFORCE_FILE = IOUtils.findFile("schemaagent/example/DB_CompletePO/DB_CompletePO_mapforce.sad");
	protected static final File EXPORT_IMAGE_ORGCHART_FILE = IOUtils.findFile("schemaagent/example/OrgChart.png");
	protected static final File RECREATE_XSD_FILE = IOUtils.findFile("schemaagent/example/recreate.xsd");
	protected static final File RECREATE_SAD_FILE = IOUtils.findFile("schemaagent/example/Recreate.sad");
	protected static final File DB_COMPLETEPO_ALIGNED_FILE = IOUtils.findFile("schemaagent/example/DB_CompletePO/DB_CompletePO_aligned.sad");
	protected static final File DB_COMPLETEPO_MIX_FILE = IOUtils.findFile("schemaagent/example/DB_CompletePO/DB_CompletePO_mix.sad");
	//protected static final File RECREATE_NEWFILE_SAD_FILE = IOUtils.findFile("schemaagent/example/Recreate_newFile.sad");
	protected static final File XSD11SAMPLES = IOUtils.findFile("schemaagent/testfiles/XSD11/XSD11Samples.sad");
	public final static Pane EXPLORER = new Pane("Explorer");
	
	//public enum fileType {All, Schema_files, XML_files, XSL_files, WSDL_files, MapForce_designs, Files } 
	public enum fileType {E, A, S, X, L, W, M, F , D, I , R}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new SchemaAgentRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
		robot.setPaneSize(SchemaAgentRobot.EXPLORER, 310, 500);
		logger.fine("**************** START NEW IMPLEMENTATION******************");
		robot.deleteAndCreateSearchPath("C:\\Work\\gui-automation\\data\\schemaagent\\example", true, true, false, null, null, null, "");
		robot.switchView(EXPLORER, TAB.Hierarchical);
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public static void setRobot(SchemaAgentRobot robot) {
		AbstractSchemaAgentTest.robot = robot;
	}
	
}
