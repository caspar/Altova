package com.altova.umodel.regression.testcases;

import static com.altova.util.LoggerUtils.logger;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.robots.ScriptMistakeException;
import com.altova.robots.Pane.PaneSize;
import com.altova.umodel.regression.gui.EclipseUModelRobot;
import com.altova.umodel.regression.gui.UModelRobot;
import com.altova.umodel.regression.gui.VSnetUModelRobot;
import com.altova.util.IOUtils;
import com.altova.util.RegressionAssert;
import com.altova.util.Settings;
import com.altova.util.Settings.AltovaApplication;

/**
 * Abstract class including some standard functionality for a UModel test. The actual test
 * case class would typically extend this class and thus already have access a robot,
 * and optionally have a new project, grids removed and the Model Tree size set.
 * 
 * Furthermore, the abstract method createTests(...) will have to be implemented in the
 * extending class. Here details of the actual test could be implemented. This method is
 * invoked by the diagramTest(...) methods of this class, so all the test class implementation
 * has to provide for the test to kick off is an XML file on the LinkMatrix format describing
 * how UML elements should relate.  
 * 
 * @author Havard Rast Blok
 *
 */
public abstract class AbstractUmodelTest extends AbstractJUnitTest {
	
	protected static UModelRobot robot;
	
	protected int zoom = 75;
	protected final String BASE_OUT_DIR= Settings.getOutputDir().getAbsolutePath()+"\\"+RegressionAssert.getRunName(robot);
	protected final String BASE_EXPECTED_DIR=Settings.getExpectedDir().getAbsolutePath()+"\\"+RegressionAssert.getRunName(robot);
	protected static final File BANK_UMP_FILE = IOUtils.findFile("examples_UModel/Bank_Java.ump");
	protected static final String BANK_UMP = BANK_UMP_FILE.getAbsolutePath();
	protected static final File BANK_CSHARP_UMP_FILE = IOUtils.findFile("examples_UModel/Bank_CSharp.ump" );
	protected static final String BANK_CSHARP_UMP = BANK_CSHARP_UMP_FILE.getAbsolutePath();
	
	protected static final String DEPLOYMENT_DIAGRAM_ARTIFACT = "Deployment View::BankAddresses.ini";
	protected static final String CLASS_DIAGRAM_CLASS = "altova::bankview::Bank";
	//protected static final String HIERARCHY_DIAGRAM="Hierarchy of Account"; //not recognized
	protected static final String HIERARCHY_DIAGRAM="Hierarchy of";
	protected static final String HIERARCHY_DIAGRAM_VS2010="Hierarchy";
	protected static final String CLASS_DIAGRAM_SAVINGSACCOUNT = "SavingsAccount";
	protected static final String CLASS_DIAGRAM = "BankView Main";
	protected static final String COMPONENT_DIAGRAM = "BankView realization";
	protected static final String WORD_TO_FIND="BankView";
	
	//protected static final String MY_UMP = "c:\\temp\\test\\myprj.ump";
	protected static final File MY_UMP_FILE = IOUtils.findFile("examples_UModel/myprj.ump");
	 
	protected static final File VB_TEST_UMP_FILE =IOUtils.findFile("examples_UModel/ATest_VB.ump");;
	protected static final String VB_TEST_UMP =VB_TEST_UMP_FILE.getAbsolutePath();
	
	protected static final File MY_XMI_FILE = IOUtils.findFile("examples_UModel/myprj.xmi");
	protected static final String MY_XMI = MY_XMI_FILE.getAbsolutePath();
	//protected static final String MY_XMI_TO_EXPORT = "c:\\temp\\test\\my_exported_xmi.xmi";
	protected static final File MY_XMI_TO_EXPORT_FILE = IOUtils.findFile("examples_UModel/my_exported_xmi.xmi");
	
	static int counter=0;
	
	protected AbstractUmodelTest() {
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//System.out.println("setUpBeforeClass"+IOUtils.getStackTrace(new NullPointerException()));
		if(robot == null) {
			robot = new UModelRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
		counter=0;
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		//press ESC a few times, just in case...
		robot.keyType(KeyEvent.VK_ESCAPE);
		//System.out.println("counter_begin:"+counter);
		
		robot.openStartProjectAppDependent(BANK_UMP);//depending on the app, I use a different project
		if(counter==0){
		robot.automaticSynchDisablingForEclipse();
		if (!Settings.isVS2010()) { // I will skip these steps for VS2010 as they will never work
				robot.setModelTreeSizeAppDependent();// Application Dependent
				robot.setPaneSize(UModelRobot.MESSAGES, -1, 250);
				robot.setPaneSize(UModelRobot.PROPERTIES, -1, 300);
			}
		}
		
		counter++;
		//System.out.println("counter_end:"+counter);

	}

	@After
	public void tearDown() throws Exception {
		super.tearDown(); 
		try {
			robot.closeAllDiagrams();
		} catch(ScriptMistakeException e) {
			logger.fine("Could not close files - probably none open: "+e);
		}
		robot.deleteProjectsInEclipseAfterTest();
	}
	
	public static void setRobot(UModelRobot robot) {
		AbstractUmodelTest.robot = robot;
	}

}
