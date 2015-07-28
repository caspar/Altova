package com.altova.semanticworks;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.altova.common.testcases.ExtractMenusTest;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.TestRobot;




@RunWith(AltovaJUnitRunner.class) 
@Suite.SuiteClasses( {	ExtractMenusTest.class,
						FileMenuTest.class,
						EditMenuTest.class,
						RDFOWNMenuTest.class,
						WindowMenuTest.class,
						RDFOWLFunctionality.class,
						ToolsMenuTest.class,
						HelpMenuTest.class})
						
						
						

@TestRobot(SemanticWorksRobot.class)
public class FullMenuRegressionTest extends AbstractSemanticWorks{
}
