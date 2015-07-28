package com.altova.spy;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.altova.common.testcases.ExtractMenusTest;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.TestRobot;


@RunWith(AltovaJUnitRunner.class) 
@Suite.SuiteClasses( {	//ExtractMenusTest.class,
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
						ToolsMenuTest.class,
						//WindowMenuTest.class, //crashes in w2003
						HelpMenuTest.class,
						CombinedTestcasesSuiteTest.class,
						OptionsDialogTest.class
						

					})
@TestRobot(SpyRobot.class)
public class FullMenuRegressionProfTest extends AbstractXmlSpyTest {
	//should be empty
}

