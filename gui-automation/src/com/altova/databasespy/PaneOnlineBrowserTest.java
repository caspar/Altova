package com.altova.databasespy;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//import com.altova.common.testcases.ExtractMenusTest;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.TestRobot;


@RunWith(AltovaJUnitRunner.class) 
@Suite.SuiteClasses( {	
					PaneOnlineBrowserAccessTest.class,
					PaneOnlineBrowserSQLServerTest.class,
					PaneOnlineBrowserMySQLTest.class,
					PaneOnlineBrowserIBMDB2Test.class,
					PaneOnlineBrowserInformix.class,
					PaneOnlineBrowserSybaseTest.class,
					PaneOnlineBrowserOracleTest.class,
					PaneOnlineBrowserSQLiteTest.class
					})
					

public class PaneOnlineBrowserTest extends AbstractDatabaseSpyTest{

	
}
