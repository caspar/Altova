package com.altova.spy;

import static com.altova.spy.SpyRobot.DETAILS_SIMPLE_TYPE;
import static com.altova.robots.SnapshotArea.CommonArea.*;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.nativegui.ComponentInfo;
import com.altova.robots.ColorOption;
import com.altova.robots.RadioOption;
import com.altova.robots.ScriptMistakeException;
import com.altova.util.AltovaJUnitRunner.TestRobot;
import com.altova.util.Settings.AltovaApplication;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;

//@TestRobot(EclipseSpyRobot.class)
public class SpyRobotTest extends AbstractXmlSpyTest{

	protected static final String EXAMPLES_wsdl = new File(AltovaApplication.XMLSPY.getExamplesLocation(), "TimeService.wsdl").getAbsolutePath();
	
	private final String Binding_path = "/definitions/binding[@name=\'TimeServiceSoap\']";
	private final String PATH1 = Binding_path+"/operation[@name=\'getUTCTime\']/input";
	private final String PATH2 = "/definitions/portType[@name='TimeServiceHttpGet']";
	private final String Operation_path_noName = "/definitions/portType[@name=\'TimeServiceHttpGet\']/operation[@name=";
	private final String PATH3 = Operation_path_noName+"\'getServerCity\']";

	private final String ATTRIBUTE = "/xs:schema/xs:complexType[@name='public']/xs:complexContent/xs:restriction/xs:attribute[@name='publicId']";
	
	@Test
	public void testXpathHighlightString1T() {
		robot.openFile(EXAMPLES_wsdl);
		robot.xpathHighlight(PATH1);
		robot.xpathHighlight(PATH2);
		robot.xpathHighlight(PATH3);
	}

	@Test
	public void testActivatePanePane() {
		robot.gridView();
		robot.activatePane(SpyRobot.PROJECT);
		robot.activatePane(SpyRobot.INFO);
	}

	@Test
	public void testActivatePaneTabPane() {
		robot.openFile(ORGCHART_XSD_FILE);
		robot.gridView();
		robot.activatePane(SpyRobot.ATTRIBUTES_ADD_CHILD);
	}

	@Test
	public void testSetPaneValue() {
		robot.openFile("C:\\Program Files\\Altova\\XMLSpy2007\\Catalog.xsd");
		robot.schemaView();
		robot.xpathHighlight(ATTRIBUTE);
		robot.activatePane(SpyRobot.FACETS_PATTERNS);
		robot.setPaneValue(SpyRobot.FACETS_FACETS, "minLen", "5");
	}
	
	@Test
	public void testEditEnumeration() {
		robot.openFile("C:\\Program Files\\Altova\\XMLSpy2007\\Catalog.xsd");
		robot.setPaneValue(DETAILS_SIMPLE_TYPE, "restr", "xs:positiveInteger");
		robot.activatePane(robot.FACETS_ENUMERATIONS) ;
	}
	
	@Test
	public void testLineBreaks() {
		RadioOption crlf = new RadioOption("CR & LF", "Save File", "Line breaks", null, "File",MS_SHELL_DLG_FONT);
		robot.setOptions(crlf);
	}
	
	@Test
	public void testGetBiggestComponentEclipse(){
		ComponentInfo info = robot.getDiagramComponent();
		System.out.println(info);
		
	}
	
	@Test
	public void testColorOptionsSet(){
		ColorOption c =new ColorOption("Header unselected",true,Color.RED,"Table view","Colors");
		robot.setOptions(c);
		
	}
	
	@Test
	public void testThrowException() {
		
			try {
				
				assertAreas(TOP_WINDOW);

		} catch (ScriptMistakeException e) {
			try {
				assertAreas(ZIP_VIEW);
			} catch (ScriptMistakeException a) {

			}
		}
		

	}	
	
	@Test
	public void testSystemProperty() {
		
			System.out.println("getEnv: "+System.getenv("thisIsATest"));
			System.out.println("getProperty: "+System.getProperty("thisIsATest"));

	}	
}
