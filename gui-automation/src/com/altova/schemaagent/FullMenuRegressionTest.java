package com.altova.schemaagent;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.altova.common.testcases.ExtractMenusTest;
import com.altova.schemaagent.SchemaAgentRobot;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.TestRobot;

@RunWith(AltovaJUnitRunner.class) 
@Suite.SuiteClasses( {  ExtractMenusTest.class,
						FileMenuTest.class,
						EditMenuTest.class,
						LayoutMenuTest.class,
						ExtrasMenuTest.class,
						WindowMenuTest.class,
						HelpMenuTest.class,
						ExplorerHierarchicalTabTest.class,
						ExplorerConfigurePathTabTest.class,
						ExplorerFlatTabTest.class,
						AdvancedGUITest.class
})



@TestRobot(SchemaAgentRobot.class)
public class FullMenuRegressionTest extends AbstractSchemaAgentTest {

}
