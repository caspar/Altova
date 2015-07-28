package com.altova.spy;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.altova.common.testcases.ExtractMenusTest;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.TestRobot;

@RunWith(AltovaJUnitRunner.class) 
@Suite.SuiteClasses( {	
						ExtractMenusTest.class,
						MultipleFilesPerformanceTest.class,
						NewFileMenuTest.class,
						FileMenuTest.class,
						EditMenuTest.class , 
	                    //ProjectMenuTest.class, 
	                    XMLMenuXMLTest.class,
	                    XMLMenuDTDTest.class,
	                    SchemaMenuTest.class,
	                    SchemaDesignMenuTest.class,
						XSLMenuTest.class,
						AuthenticMenuTest.class,
						ConvertMenuTest.class,
						ViewMenuTest.class,
						BrowserMenuTest.class,
						WSDLMenuTest.class,
						WSDL2MenuTest.class,
						SOAPMenuTest.class,
						HelpMenuTest.class,
						FileHandlingVSTest.class
					})
@TestRobot(VSnetSpyRobot.class)
public class FullMenuRegressionVSnetTest extends AbstractXmlSpyTest {
	//should be empty
}
