
package com.altova.spy;

import java.awt.Rectangle;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.ImageRecognitionRobot;
import com.altova.robots.RadioOption;
import com.altova.robots.ScriptMistakeException;
import com.altova.util.IOUtils;
import com.altova.util.Settings;
import com.altova.util.AltovaJUnitRunner.TestRobot;

import static com.altova.robots.SnapshotArea.CommonArea.*;
import static com.altova.spy.SpyRobot.VALIDATION;
import java.io.File;

//@TestRobot(VSnetSpyRobot.class)
//@TestRobot(EclipseSpyRobot.class)
public class XSLMenuTest extends AbstractXmlSpyTest {

	private static final File ORGCHART_XSL_FO = IOUtils.findFile("spy/examples/OrgChartFO.xsl");

	private static final File STRING_XML = IOUtils.findFile("spy/examples/string.xml");

	private static final File XQfile = IOUtils.findFile("spy/examples/stringQ4.xq");
	
	private final static String TREE = "Tree";
	
	@Test
	public final void testXslTransformation() {
		robot.assignXSL(ORGCHART_XSL_FILE.getAbsolutePath());
		robot.xslTransformation();
		assertAreas(DIAGRAM_MAIN_WINDOW);		

	}

	//FOP path is deleted with the registry settings, so test is not possible
	@Ignore
	@Test
	public final void testXslFOTransformation() {
		robot.assignXSLFO(ORGCHART_XSL_FO.getAbsolutePath());
		robot.xslFOTransformation();
	
	}

	@Test
	public final void testXslParameters() {
		robot.xslParameters();
		assertWindowAndEscape();
	}

	@Test
	
	public final void testXQueryExecution() {
		robot.openFile(STRING_XML);
		robot.xQueryExecution(XQfile.getAbsolutePath());
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}


	
	 public final void XslProfiling(String formatName) {

		RadioOption format = new RadioOption(formatName);
		robot.xslProfiling(format);

	}

	@Test
	public final void testXSLProfilingNoProfiling() {
		XslProfiling("No Profiling");
		Rectangle found=null;
		if (Settings.isVS2010()) {
			try{
			found = robot.findTreeWndInVS2010();
			}catch(ScriptMistakeException e){}
		} else {
			found = robot.findComponentName(TREE);
		}
		
		assertNull("Profiling window found", found);
	}
 
	@Test
	public final void testXSLProfilingHitcountProfiling() {
		XslProfiling("Hitcount Profiling");
		
		try {
			Rectangle found=null;
			if (Settings.isVS2010()) {
				found=robot.findTreeWndInVS2010();
			} else {
				found=robot.findComponentName(TREE);
			}
			assertNotNull("Profiling window not found", found);
		} finally {
			XslProfiling("No Profiling");
		}
	}
	
	@Test
	public final void testXSLProfilingCallgraphProfiling() {
		XslProfiling("Callgraph Profiling");
		try{
			Rectangle found=null;
			if (Settings.isVS2010()) {
				found=robot.findTreeWndInVS2010();
			} else {
				found=robot.findComponentName(TREE);
			}
			assertNotNull("Profiling window not found", found);
		} finally {
			XslProfiling("No Profiling");
		}
	}
	
	@Test
	public final void testAssignXSL() {

		robot.assignXSL(ORGCHART_XSL_FILE.getAbsolutePath());
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testAssignXSLFO() {

		robot.assignXSLFO(ORGCHART_XSL_FO.getAbsolutePath());
		assertAreas(DIAGRAM_MAIN_WINDOW);

	}

	@Test
	public final void testAssignSampleXML() {
		robot.assignSampleXML(STRING_XML.getAbsolutePath());
		delay(1000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testGotoXSL() {
		robot.assignXSL(ORGCHART_XSL_FILE.getAbsolutePath());
		robot.gotoXSL();
		assertAreas(DIAGRAM_MAIN_WINDOW);

	}

	@Test
	public final void testXsltSettings() {
		robot.xsltSettings();

	}

}
