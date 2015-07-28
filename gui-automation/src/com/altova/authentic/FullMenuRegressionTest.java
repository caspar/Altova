package com.altova.authentic;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.altova.common.testcases.ExtractMenusTest;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.TestRobot;

@RunWith(AltovaJUnitRunner.class) 
@Suite.SuiteClasses( {	ExtractMenusTest.class,
						NewFileTemplatesTest.class,
						FileMenuTest.class,
						EditMenuTest.class,
	                    ProjectMenuTest.class,
	                    XMLMenuTest.class,
						XSLMenuTest.class,
						AuthenticMenuTest.class,
						ViewMenuTest.class,
						BrowserMenuTest.class,
						ToolsMenuTest.class,
						WindowMenuTest.class, 
						HelpMenuTest.class

					})
@TestRobot(AuthenticRobot.class)
public class FullMenuRegressionTest extends AbstractAuthenticTest {

}
