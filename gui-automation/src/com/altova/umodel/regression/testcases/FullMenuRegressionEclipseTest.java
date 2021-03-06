package com.altova.umodel.regression.testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.altova.umodel.regression.gui.EclipseUModelRobot;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.TestRobot;

@RunWith(AltovaJUnitRunner.class) 
@Suite.SuiteClasses( {	
						FileMenuTest.class,
						EditMenuTest.class,
						ProjectMenuTest1.class,
						ProjectMenuTest2.class,
    					LayoutMenuTest.class,  
						LayoutMenu2Test.class,
						ToolsMenuTest.class,
						HelpMenuTest.class
					})

@TestRobot(EclipseUModelRobot.class)
public class FullMenuRegressionEclipseTest extends AbstractUmodelTest{
	//should be empty
}
