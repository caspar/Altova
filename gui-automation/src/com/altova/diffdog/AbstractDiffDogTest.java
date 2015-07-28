package com.altova.diffdog;

import static com.altova.util.LoggerUtils.logger;

import java.awt.event.KeyEvent;
//import java.io.BufferedReader;
import java.io.File;
//import java.io.IOException;
//import java.io.InputStreamReader;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.robots.ApplicationCrashedException;
import com.altova.robots.ScriptMistakeException;
//import com.altova.umodel.regression.gui.UModelRobot;
import com.altova.util.IOUtils;
//import com.altova.util.RegressionAssert;
//import com.altova.util.Settings;



public class AbstractDiffDogTest extends AbstractJUnitTest{
	
	public static final boolean LEFT_SIDE      = true;
	public static final boolean RIGHT_SIDE     = false;
	
	public static final int TAB_WORD	= 3;
	
	protected static DiffDogRobot robot;
	static int counter_m = 0;
	public static final File FILE_OUTPUT_PATH=new File("C:\\temp\\diffdog");
	protected static final File PROJECT_SAVED_MFP = new File(FILE_OUTPUT_PATH.getAbsolutePath()+"\\new_test_project.mfp");
	protected static final File WEBSERVICE_PROJECT_MFP = new File(FILE_OUTPUT_PATH.getAbsolutePath()+"\\new_webservice_test_project.mfp");

	protected static final File SETALL = IOUtils.findFileDiffDog("tags_list/","setAll.PNG");
	protected static final File CLEARALL = IOUtils.findFileDiffDog("tags_list/","clearAll.PNG");
	protected static final File DOTS = IOUtils.findFileDiffDog("tags_list/","dot3.PNG");
	protected static final File EDGAR_ALLAN_POE1 = IOUtils.findFileDiffDog("examples/LeftSide/","EdgarAllanPoe.txt");
	protected static final File EDGAR_ALLAN_POE2 = IOUtils.findFileDiffDog("examples/RightSide/","EdgarAllanPoe.txt");

	protected static final File EDGAR_ALLAN_POE_WHITESPACES = IOUtils.findFileDiffDog("examples/LeftSide/","EdgarAllanPoe_whitespaces.txt");
	protected static final File DETAILED_DIFF1 = IOUtils.findFileDiffDog("examples/LeftSide/","DetailedDiff.xml");
	protected static final File DETAILED_DIFF2 = IOUtils.findFileDiffDog("examples/RightSide/","DetailedDiff.xml");
	
	protected static final File IGNORE_IRDER_OF_ATTRIBUTES1 = IOUtils.findFileDiffDog("examples/LeftSide/","IgnoreOrderOfAttributes.xml");
	protected static final File IGNORE_IRDER_OF_ATTRIBUTES2 = IOUtils.findFileDiffDog("examples/RightSide/","IgnoreOrderOfAttributes.xml");
	
	protected static final File IGNORE_IRDER_OF_CHILD_NODES1 = IOUtils.findFileDiffDog("examples/LeftSide/","IgnoreOrderOfChildNodes.xml");
	protected static final File IGNORE_IRDER_OF_CHILD_NODES2 = IOUtils.findFileDiffDog("examples/RightSide/","IgnoreOrderOfChildNodes.xml");
	
	protected static final File IGNORE_IRDER_OF_CHILD_NODES_A1 = IOUtils.findFileDiffDog("examples/LeftSide/","IgnoreOrderOfChildNodes_1.xml");
	protected static final File IGNORE_IRDER_OF_CHILD_NODES_A2 = IOUtils.findFileDiffDog("examples/RightSide/","IgnoreOrderOfChildNodes_1.xml");
	
	protected static final File IGNORE_IRDER_OF_CHILD_NODES_B1 = IOUtils.findFileDiffDog("examples/LeftSide/","IgnoreOrderOfChildNodes_2.xml");
	
	protected static final File NAMESPACE_PREFIX_1 = IOUtils.findFileDiffDog("examples/LeftSide/","Namespace_Prefix.xml");
	protected static final File NAMESPACE_PREFIX_2 = IOUtils.findFileDiffDog("examples/RightSide/","Namespace_Prefix.xml");
	
	protected static final File ENTITY1 = IOUtils.findFileDiffDog("examples/LeftSide/","Entity.xml");
	protected static final File ENTITY2 = IOUtils.findFileDiffDog("examples/RightSide/","Entity.xml");
	
	protected static final File IGNORE_TEXT1 = IOUtils.findFileDiffDog("examples/LeftSide/","IgnoreText.xml");
	protected static final File IGNORE_TEXT2 = IOUtils.findFileDiffDog("examples/RightSide/","IgnoreText.xml");
	protected static final File IGNORE_DEPTH2 = IOUtils.findFileDiffDog("examples/RightSide/","IgnoreDepth.xml");
	
	protected static final File CASE_SENSITIVITY1 = IOUtils.findFileDiffDog("examples/LeftSide/","CaseSensitivity.xml");
	protected static final File CASE_SENSITIVITY2 = IOUtils.findFileDiffDog("examples/RightSide/","CaseSensitivity.xml");
	
	protected static final File IGNORE_NODE_TYPES1 = IOUtils.findFileDiffDog("examples/LeftSide/","IgnoreNodeTypes.xml");
	protected static final File IGNORE_NODE_TYPES2 = IOUtils.findFileDiffDog("examples/RightSide/","IgnoreNodeTypes.xml");
		
	protected static final File WHITE_SPACES1 = IOUtils.findFileDiffDog("examples/LeftSide/","Whitespaces.xml");
	protected static final File WHITE_SPACES2 = IOUtils.findFileDiffDog("examples/RightSide/","Whitespaces.xml");
	
	protected static final File FILTER1 = IOUtils.findFileDiffDog("examples/LeftSide/","Filter.xml");
	protected static final File FILTER2 = IOUtils.findFileDiffDog("examples/RightSide/","Filter.xml");
	
	protected static final File DATABASE_Schema_FILE=IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","DatabaseSchemaComparison_DBSchema_1.dbsdif");
	
	protected static final File CLOSE_X = IOUtils.findFileDiffDog("tags_list/","close_x.png");
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new DiffDogRobot();
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
		robot.newCompareWindow();
		robot.MaximizeFileCompareWindow();
		counter_m ++;
		
	}


	@After
	public void tearDown() throws Exception {
		super.tearDown();
		try {
			robot.exitWithuotSave();
		} catch(ScriptMistakeException e) {
			robot.killDiffDog();
			delay(1000);
			logger.fine("Could not close files - probably none open: "+e);
			throw new Exception("Can't close diffDog");
		}
		
	}
	
	public static void setRobot(DiffDogRobot robot) {
		AbstractDiffDogTest.robot = robot;
	}
	
	

	
	
}
