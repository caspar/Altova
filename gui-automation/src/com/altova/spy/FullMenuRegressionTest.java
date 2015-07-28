package com.altova.spy;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.altova.common.testcases.ExtractMenusTest;
import com.altova.spy.schema.FullSchemaGUIRegressionTest;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.TestRobot;

@RunWith(AltovaJUnitRunner.class) //37 test suite 
@Suite.SuiteClasses( {	ExtractMenusTest.class,
						FileHandlingTest.class,
						MultipleFilesPerformanceTest.class,
						NewFileMenuTest.class,
						FileMenuTest.class,
						EditMenuTest.class,
	                    ProjectMenuTest.class,
	                    XMLMenuXMLTest.class,
	                    XMLMenuDTDTest.class,
	                    SchemaMenuTest.class,
	                    SchemaDesignMenuTest.class,
	                    XSLMenuTest.class,
						AuthenticMenuTest.class,
						ConvertMenuTest.class,
						ViewMenuTest.class,
						BrowserMenuTest.class,
						WSDLMenuTest.class,
						WSDL2MenuTest.class,
						XBRLMenuTest.class,
						ToolsMenuTest.class,
						SOAPMenuTest.class,
						SOAPDebuggerMenuTest.class,
						WindowMenuTest.class, //crashes in old w2003
						HelpMenuTest.class,
						CombinedTestcasesSuiteTest.class,
						OptionsDialogTest.class,
						FullSchemaGUIRegressionTest.class,
						ChartsTest.class
					})
@TestRobot(SpyRobot.class)
public class FullMenuRegressionTest extends AbstractXmlSpyTest {
	//should be empty
}
