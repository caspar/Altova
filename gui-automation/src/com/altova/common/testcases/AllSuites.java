package com.altova.common.testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.altova.util.AltovaJUnitRunner;

@RunWith(AltovaJUnitRunner.class) 
@Suite.SuiteClasses( {	LaunchAllTest.class,
						com.altova.spy.FullMenuRegressionTest.class,
						com.altova.umodel.regression.testcases.FullMenuRegressionTest.class
					})
public class AllSuites {

}
