package com.altova.umodel.regression.testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.altova.common.testcases.ExtractMenusTest;
import com.altova.umodel.regression.gui.VSnetUModelRobot;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.TestRobot;

@RunWith(AltovaJUnitRunner.class) 
@Suite.SuiteClasses( {	
						ExtractMenusTest.class,
						FileMenuTest.class,
						EditMenuTest.class,
						ProjectMenuTest1.class,
						ProjectMenuTest2.class,
						LayoutMenuTest.class,
						LayoutMenu2Test.class,
						//ViewMenuTest.class,//not implemented for standalone as well
						//ToolsMenuTest.class, different set of tests: to do
						WindowMenuTest.class, 
						HelpMenuTest.class
					})

@TestRobot(VSnetUModelRobot.class)
public class FullMenuRegressionVSnetTest extends AbstractUmodelTest{
	//should be empty
}
