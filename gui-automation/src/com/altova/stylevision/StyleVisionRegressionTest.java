package com.altova.stylevision;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.altova.common.testcases.ExtractMenusTest;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.TestRobot;

@RunWith(AltovaJUnitRunner.class) 
@Suite.SuiteClasses( {	ExtractMenusTest.class,
						SV_FileMenuTest.class,
						AuthenticViewTest.class,
						AuthenticViewDBTest.class,
						AuthenticViewFeaturesTest.class,
						SV_SortOptionsTest.class,
						//SchemaTreeTest.class,
						TTPcasesTest.class,
						//StylesForContentTest.class,
						FileHandlingTest.class,
						JScriptTest.class,
						BasicExamplesTest.class,
						ConditionsTest.class,
						EncodingTest.class,
						//Template_cases.class,
						SV_ProjectMenuTest.class,
						SV_ProjectOptionsTest.class,
						SV_ProjectContextMenuTest.class,
						SV_ProjectDragnDropTest.class,
						SV_XBRLTest.class,
						SV_XMLTablesTest.class
					})
@TestRobot(StyleVisionRobot.class)
public class StyleVisionRegressionTest extends AbstractStyleVisionTest {

}
