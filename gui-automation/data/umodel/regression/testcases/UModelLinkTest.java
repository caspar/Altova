package com.altova.umodel.regression.testcases;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.util.LoggerUtils.logger;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import com.altova.robots.PluginRobot;
import com.altova.robots.ScriptMistakeException;
import com.altova.robots.Pane.PaneSize;
import com.altova.umodel.regression.gui.EclipseUModelRobot;
import com.altova.umodel.regression.gui.LinkMatrixReader;
import com.altova.umodel.regression.gui.UMLElement;
import com.altova.umodel.regression.gui.UMLLink;
import com.altova.umodel.regression.gui.VSnetUModelRobot;
import com.altova.util.NamedParameterizedRunner;
import com.altova.util.Settings;
import com.altova.util.SuiteLogLevel;

/**
 * Test suite for Test Complete to verify link constraints between all possible elements. 
 * 
 * @author Havard Rast Blok
 *
 */

//@RunWith(value = Parameterized.class)
@RunWith(value = NamedParameterizedRunner.class)
public class UModelLinkTest extends AbstractDiagramTest {

	private String linkMatrixFile;
	
	protected int zoom = 60;

	
	
	/**
	 * 
	 * @param file
	 * @throws IOException
	 */
	public UModelLinkTest(String file) throws IOException {
		this.linkMatrixFile = file;
	}
//	static {
//		AbstractUmodelTest.robot = new EclipseUModelRobot();
//	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AbstractUmodelTest.setUpBeforeClass();
		robot.viewAllOnOffUModelWindows();
		
	}
	
	 @Parameters
	 public static Collection data() {
		 return linkMatrixFiles();
	 }
	
	@Test
	public void testLinks() throws IOException {
		logger.log(SuiteLogLevel.TESTS, linkMatrixFile.toString()+ " ");
		diagramTest(linkMatrixFile);
	}

	private void drawRow(Collection<String> elements, int y) {
		int x = robot.getMainWindow().x + 40;
		int lineShift = 80;
		int i=0;

		for (String e : elements) {
			logger.info(e);
			i = i%3;
			int y2 = y + i*lineShift;
			robot.putElement(e, x, y2);
			robot.deselectAll();
			x += 35;
			i++;
		}
		robot.delay(2000);
	}
	
	

	public void createTests(Collection<String> elements, Collection<String> links, LinkMatrixReader matrix) throws IOException {
		String linktestDiagram = Settings.getProperty("linktestDiagram");
		final String diagram = matrix.getDiagram();
		//logger.info("Testing diagram... "+diagram);
		if(linktestDiagram != null && !diagram.equals(linktestDiagram)) {
			logger.info("Filtering out all tests for diagrams which are not "+linktestDiagram+" ("+diagram+")");
			return;
		}
		
		robot.newPrj();
		robot.newDiagram(diagram);
		robot.escapeDialog("This command will include the ",KeyEvent.VK_ENTER);
		robot.zoom(zoom);
		robot.turnOffDiagramJunk();
		robot.setAppropiateModelTreeSizeAppDependent(); //eclipse needs a wider one
		
		robot.makeMessageWindowTinyInEclipse();
		robot.deselectAll();
		drawRow(elements, 140);
		drawRow(elements, 400);

		String prjName = Settings.getOutputDir()+"\\ump_start_files"+File.separator+robot.getTestBasename()+diagram+".ump";
		robot.saveReplacePrj(prjName); //this must be changed for eclipse
		
		String img = robot.getTestBasename()+matrix.getDiagram()+"_start";
		robot.snapShot(DIAGRAM_MAIN_WINDOW, img);
		
		String failure = null;
		String error = null;
		
		for(String e1 : elements) {
			//ignore Pins for now
			if(e1.indexOf("Pin") > -1 ) {
				continue;
			}
			
			String linktestElement = Settings.getProperty("linktestElement");
			if(linktestElement != null && !e1.equals(linktestElement)) {
				logger.info("Filtering out all test for elements which are not "+linktestElement+" ("+e1+")");
				continue;
			}
			
			for (String l : links) {
				logger.log(SuiteLogLevel.TEST, e1 + " -> " + l);

				UMLElement start = matrix.getStartElement(e1);
				UMLLink link = start.getLinkType(l);
				if (link == null) {
					logger.info("Testing invalid starts: " + e1 + " -> " + l + " - LETS IGNORE THIS FOR NOW.");
					continue;
				}

				String linktestLink = Settings.getProperty("linktestLink");
				if (linktestLink != null && !l.equals(linktestLink)) {
					logger.info("Filtering out all test for links which are not " + linktestLink + " (" + l + ")");
					continue;
				}

				robot.setModelTreeSize("Help");
				
				robot.openPrj(prjName);
				robot.setActiveDiagram(diagram);
				robot.zoom(zoom);
				robot.setAppropiateModelTreeSizeAppDependent();
				delay(500);
				robot.deselectAll();

				for (String e2 : elements) {
					logger.log(SuiteLogLevel.STEP, e1 + " -> " + l + " ->" + e2);

					// ignore Pins for now
					if (e2.indexOf("Pin") > -1) {
						continue;
					}

					if (link != null) {
						UMLElement end = link.destinations.get(e2);
						if (end == null) {
							logger.info("Testing invalid end: " + e1 + " -> " + l + " ->" + e2);
						}
					}

					// robot.setAutoDelay(1000);
					
					robot.linkElements(l, e1 + "1", e2 + "2");
					robot.rightClick();
					robot.waitForIdle();
					robot.keyType(KeyEvent.VK_ESCAPE);
					robot.delay(500);
				}

				// save this project
				String testName = diagram + "_" + e1 + "_" + l;
				String prjTestName = Settings.getOutputDir() + File.separator + robot.getTestBasename() + testName + ".ump";
				robot.deselectAll();
				robot.saveReplacePrj(prjTestName);
				// collect all failures or errors in one string, and pass or
				// fail at the end
				try {
					assertAreas(testName, DIAGRAM_MAIN_WINDOW);
				} catch (AssertionError e) {
					failure = (failure == null) ? "" : failure;
					failure += e.getMessage() + "\n";
				} catch (ScriptMistakeException e) {
					error = (error == null) ? "" : error;
					error += e.getMessage() + "\n";
				}
			}

		}
		
		if(failure != null) {
			throw new AssertionError(failure);
		}
		
		if(error != null) {
			throw new ScriptMistakeException(error);
		}
	}
}
