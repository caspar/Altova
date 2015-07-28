package com.altova.mapforce;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.altova.common.testcases.ExtractMenusTest;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.TestRobot;



@RunWith(AltovaJUnitRunner.class) 
@Suite.SuiteClasses( {		ExtractMenusTest.class,
							FileMenuTest.class,
							GenerateDocumentationTest.class,
							EditMenuTest.class,
							InsertMenuTest.class,
		                    ProjectMenuTest.class,
		                    ComponentMenuTest.class,
		                    ConnectionMenuTest.class,
		                    FunctionMenuTest.class,
		                    OutputMenuTest.class,
							ViewMenuTest.class,
							WindowMenuTest.class,
							HelpMenuTest.class
						})
	@TestRobot(MapForceRobot.class)
	public class FullMenuRegressionTest extends AbstractMapForceTest {
		//should be empty
	}

