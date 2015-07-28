package com.altova.diffdog;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.altova.common.testcases.ExtractMenusTest;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.TestRobot;

@RunWith(AltovaJUnitRunner.class) 
@Suite.SuiteClasses( {	
						//ExtractMenusTest.class,
						//FileMenuTest.class,
						//EditMenuTest.class,
						//TextViewMenu.class,
						//GridViewMenuTest.class,
						//XMLMenuTest.class,
						//ContextMenuTest.class,
						DiffAndMergeMenuTest.class,
						DirectoryComparisonTest.class,
						ComparisonOptionsGridViewTest.class,
						ComparisonOptionsWordTest.class,
						ComparisonOptionsTextViewTest.class,
						ComparisonOptionsDatabaseData.class,
						CompareDatabaseDataTest.class,
						DiffDogOptionsTest.class
											})
											
@TestRobot(DiffDogRobot.class)
public class FullMenuRegressionTest extends AbstractDiffDogTest {
	//should be empty
}

