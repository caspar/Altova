package com.altova.stylevision;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.TestRobot;

@RunWith(AltovaJUnitRunner.class) 
@Suite.SuiteClasses( {	SV_ProjectContextMenuTest.class,
						SV_ProjectDragnDropTest.class,
						SV_ProjectMenuTest.class,
						SV_ProjectOptionsTest.class

					})
@TestRobot(StyleVisionRobot.class)
public class StyleVisionProjectTest extends AbstractStyleVisionTest {

}
