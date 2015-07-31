package com.altova.umodel.regression.testcases;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.umodel.regression.gui.UModelRobot.STYLES;
import static com.altova.util.LoggerUtils.logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.PluginRobot;
import com.altova.robots.Pane.PaneSize;
import com.altova.umodel.regression.gui.EclipseUModelRobot;
import com.altova.umodel.regression.gui.VSnetUModelRobot;
import com.altova.util.IOUtils;
import com.altova.util.SuiteLogLevel;
import com.altova.util.AltovaJUnitRunner.TestRobot;

/**
 * Tests the Styles window/pane (next to Properties).
 * The screen and project is compared against reference images and files.
 * 
 * @author Havard Rast Blok
 *
 */

//this set of tests are not necessary for the plugins
public class StylesTest extends AbstractUmodelTest {
	
	String classStyles[][] = {
			{ "Diag. Show Grid", "true" },

			{ "Fill Color", "black" },
			{ "Pen Color", "white" },
			{ "Font Color", "white" },
			{ "Font", "Times New Roman" },
			{ "Font-Size", "13" },
			{ "Font-Weight", "bold" },
			{ "Header Gradient Begin Color", "white" },
			{ "Header Gradient End Color", "#A7A6BF" },
			{ "Header Color", "white" },
			{ "Header Font", "Times New Roman" },
			{ "Header Font-Size", "13" },
			{ "Header Font-Weight", "normal" },
			{ "Use Syntax Coloring", "false" },
			{ "Attribute Color", "white" },
			{ "Attribute Font", "Times New Roman" },
			{ "Attribute Font-Size", "13" },
			{ "Attribute Font-Weight", "bold" },
			{ "Attribute Sort-Mode", "by name" },
			{ "Operation Color", "white" },
			{ "Operation Font", "Times New Roman" },
			{ "Operation Font-Size", "13" },
			{ "Operation Font-Weight", "bold" },
			{ "Operation Sort-Mode", "by name" },
			{ "Stereotype Color", "white" },
			{ "Stereotype Font", "Times New Roman" },
			{ "Stereotype Font-Size", "13" },
			{ "Stereotype Font-Weight", "bold" },
			{ "Nested Classifier Color", "white" },
			{ "Nested Classifier Font", "Times New Roman" },
			{ "Nested Classifier Font-Size", "13" },
			{ "Nested Classifier Font-Wei", "bold" },
			{ "Line Style", "direct" },
			{ "Diag. Background Color", "black" },
			{ "Diag. Grid Color", "white" },
			{ "Diag. Show Grid", "false" },
			{ "Diag. Background Color", "gradient" },
			{ "Diag. Grid Color", "black" },
			{ "Diag. Show Grid", "true" },
			{ "Diag. Snap to Grid", "true" },
			{ "Diag. Grid Size", "20" },
			{ "Diag. UML Heading", "diagram name" },

	};
	
	String scStyles[][] = {
			{ "Use Syntax Coloring", "true" },
			{ "SC Stereotypes", "white" },
			{ "SC Name", "white" },
			{ "SC Type", "white" },
			{ "SC Multiplicity", "white" },
			{ "SC Default Value", "white" },
			{ "SC Constraint", "white" },
			{ "SC Parameter", "white" },
			{ "SC Par.direction", "white" },
	};
	
	String showHideStyles[][] = {
			{ "Show Attributes Compartment", "false" },
			{ "Show EnumerationLiterals Compartment", "false" },
			{ "Show Operations Compartment", "false" },
			{ "Show Nested Classifier Compartment", "false" },
			{ "Show Visibility", "false" },
			{ "Show Stereotypes", "false" },
			{ "Show Constraints", "false" },
			{ "Show Default Value", "false" },
			{ "Show Parameter", "false" },
			{ "Show Par.direction", "false" },
			{ "Show ExtensionPoints", "false" },
			{ "Show Tagged Values", "none" },
			{ "Show Execution Specifications", "false" },
			{ "Show Message Number", "simple" },
			{ "Show Assoc. Ownership Dot", "false" },
			{ "Namespace Display Mode", "none" },
			{ "Draw Mirrored", "false" },
	};
	
	String showHideVisibility[][] = {
			{ "Show Attributes: public", "false" },
			{ "Show Attributes: protected", "false" },
			{ "Show Attributes: private", "false" },
			{ "Show Attributes: package", "false" },
			{ "Show Operations: public", "false" },
			{ "Show Operations: protected", "false" },
			{ "Show Operations: private", "false" },
			{ "Show Operations: package", "false" },
			{ "Show Nested Classifier: public", "false" },
			{ "Show Nested Classifier: protected", "false" },
			{ "Show Nested Classifier: private", "false" },
			{ "Show Nested Classifier: package", "false" },
	};
	
	static int testNo = 0;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		URL url = IOUtils.findResource("all_diagrams.ump");
		File file = new File(url.toURI());
		robot.openPrj(file.toString()); //do it manually for eclipse
	}
	
	@Test
	public void testMainStyles() throws IOException {
		testStyleValues("Class", classStyles);
	}
	
	@Test
	public void testSyntaxColorStyles() throws IOException {
		testStyleValues("Class", scStyles);
	}
	
	@Test
	public void testShowStyles() throws IOException {
		testStyleValues("Class", showHideStyles);
	}
	
	@Test
	public void testShowVisibility() throws IOException {
		testStyleValues("Class", showHideVisibility);
	}
	
	private void testStyleValues(String diagram, String valuePairs[][]) throws IOException {
		robot.setModelTreeSize(PaneSize.WIDE);
		robot.openDiagram(diagram+"Diagram1"); 
		 
		robot.viewAllOnOffUModelWindows();
		robot.activateWindow("Styles");
		robot.delay(500);
		
		robot.setPaneSize(STYLES, PaneSize.WIDE.getWidth(), -1);
		robot.scrollPaneRowSplitter(STYLES, 0.75);
		
		for(String pair[] : valuePairs) {
			logger.log(SuiteLogLevel.STEP, "Setting "+pair[0] +" = "+ pair[1]);
			robot.setPaneValue(STYLES, pair[0], pair[1]);
		}
		
		testNo++;
		assertAreas("UModel_styles_test_"+testNo, DIAGRAM_MAIN_WINDOW);
	}
}
