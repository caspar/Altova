package com.altova.util;

import java.util.logging.Level;

/**
 * 
 * @author Havard Rast Blok
 *
 */
public class SuiteLogLevel extends Level {

	private static final long serialVersionUID = -810003295179137946L;

	public SuiteLogLevel(String name, int value) {
		super(name, value);
	}

	public static final Level SUITE = new SuiteLogLevel("SUITE", 3000);

	public static final Level TESTS = new SuiteLogLevel("TESTS", 2950);
	
	public static final Level TEST = new SuiteLogLevel("TEST", 2900);
	
	public static final Level STEP = new SuiteLogLevel("STEP", 2800);
	
	public static final Level INPUT = new SuiteLogLevel("INPUT", 2000);
	
	public static final Level OUTPUT = new SuiteLogLevel("OUTPUT", 2000);
	
	public static final Level EXPECTED = new SuiteLogLevel("EXPECTED", 2000);
	
	public static final Level STATUS = new SuiteLogLevel("STATUS", 2000);
}
