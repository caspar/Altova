package com.altova.databasespy;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//import com.altova.common.testcases.ExtractMenusTest;
import com.altova.common.testcases.ExtractMenusTest;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.TestRobot;


@RunWith(AltovaJUnitRunner.class) 
@Suite.SuiteClasses( {	
						ExtractMenusTest.class, //25 sections
						FileMenuTest.class,
						EditMenuTest.class,
						ProjectMenuTest.class,
						SQLViewMenuTest.class,
						SQLEditorMenuTest.class,
						SQLRefactoringMenuTest.class,
						DesignEditorTest.class,
						DataComparisonTest.class,
						SchemaComparisonTest.class,
						ToolMenuTest.class,
						WindowMenuTest.class,
						HelpMenuTest.class,
						PaneProjectTest.class,
						PaneOnlineBrowserTest.class,
						QuickConnectTest.class,
						ODBConnectionsTest.class,
						JDBCConnectionsTest.class,
						ADOConnections.class
					})
					
					
@TestRobot(DatabaseSpyRobot.class)
public class FullMenuRegressionTest extends AbstractDatabaseSpyTest {
	//should be empty
}