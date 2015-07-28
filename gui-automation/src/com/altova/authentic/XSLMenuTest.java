package com.altova.authentic;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

public class XSLMenuTest extends AbstractAuthenticTest {

	@Test
	public final void testXslTransformation() {
		robot.openFile(EXPREPORT_XML_FILE);
		robot.xslTransformation(EXPREPORT_XSLT_FILE.getAbsolutePath());
		assertAreas(DIAGRAM_MAIN_WINDOW);		

	}


	@Test
	public final void testXslParameters() {
		robot.xslParameters();
		assertWindowAndEscape();

	}
}
