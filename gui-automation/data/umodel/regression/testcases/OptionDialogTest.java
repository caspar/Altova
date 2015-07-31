package com.altova.umodel.regression.testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


import com.altova.spy.OptionsViewTabTest;

/*
import com.altova.spy.OptionsEditingTabTest;
import com.altova.spy.OptionsDiagramEditingTabTest;
import com.altova.spy.OptionsFileTabTest;
import com.altova.spy.OptionsCodeEngineeringTabTest;
*/
import com.altova.umodel.regression.testcases.AbstractUModelOptionsDialogTest;
import com.altova.umodel.regression.gui.UModelRobot;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.TestRobot;


@RunWith(AltovaJUnitRunner.class) 
@Suite.SuiteClasses( {	OptionViewTabTest.class,
						OptionsEditingTabTest.class,
						OptionsDiagramEditingTabTest.class,
						OptionsCodeEngineeringTabTest.class
					})
@TestRobot(UModelRobot.class)


public class OptionDialogTest extends AbstractUmodelTest {

}

