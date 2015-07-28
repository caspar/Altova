package com.altova.spy;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.TestRobot;

@RunWith(AltovaJUnitRunner.class) 
@Suite.SuiteClasses( {	OptionsFileTabTest.class,
						OptionsFileTypesTabTest.class,
						OptionsEditingTabTest.class,
						OptionsViewTabTest.class,
//	                    OptionsGridFontsTabTest.class,
//	                    OptionsSchemaFontsTabTest.class,
//	                    OptionsWSDLFontsTabTest.class,
//	                    OptionsTextFontsTabTest.class, //#23812 shows how behaviour is not correct but they won't fix it.
	                    OptionsColorTabTest.class,
						OptionsEncodingTabTest.class
					})
@TestRobot(SpyRobot.class)
public class OptionsDialogTest extends AbstractSpyOptionsDialogTest {

}
