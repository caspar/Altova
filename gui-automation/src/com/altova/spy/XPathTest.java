package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;

import org.junit.Test;

public class XPathTest extends AbstractXmlSpyTest {

	protected final String OFFICE = "//Office";
	

	public void setUp() throws Exception {
		
	}

	
	@Test
	public final void testXpathEvaluation() {
		String msg = robot.xpathEvaluation(OFFICE);
		assertTrue("Does result window contain element string ("+OFFICE+")", msg.indexOf("Office") > -1);
	}

	@Test
	public final void testXpathHighlight() {
		robot.textView();
		robot.xpathHighlight(OFFICE, 2);
		assertAreas(TOP_WINDOW);
	}

}
