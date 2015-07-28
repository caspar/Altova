package com.altova.spy.schema;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


import com.altova.spy.AbstractXmlSpyTest;
import com.altova.spy.SpyRobot;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.TestRobot;

@RunWith(AltovaJUnitRunner.class) 
@Suite.SuiteClasses( {	EntryHelperTest.class,
						DetailViewTest.class,
						UndoRedoTest.class,
						IdConsAndAttrsGridTest.class,
						SampleValuesTest.class
					})
@TestRobot(SpyRobot.class)
public class FullSchemaGUIRegressionTest extends AbstractXmlSpyTest{

}
