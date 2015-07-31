package com.altova.umodel.regression.testcases;

import static com.altova.util.LoggerUtils.logger;

import java.io.IOException;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.altova.umodel.regression.gui.LinkMatrixReader;
import com.altova.umodel.regression.gui.UMLElement;
import com.altova.umodel.regression.gui.UMLLink;
import com.altova.util.IOUtils;

/**
 * Test suite to create all possible links in one single UModel project file.
 * 
 * @author Havard Rast Blok
 *
 */
@RunWith(value = Parameterized.class)
public class CombinedTest extends AbstractDiagramTest {

	protected String testFile;
	
	public CombinedTest(String file) throws IOException {
		this.testFile = file;
	}
	
	@Parameters
	public static Collection data() {
		return linkMatrixFiles();
	}
	
	@Test
	public void testDiagrams() throws IOException {
		diagramTest(testFile);
	}
	
	protected void createTests(Collection<String> elements, Collection<String> links, LinkMatrixReader matrix) throws IOException {
		for(String e1 : elements) {

			robot.newDiagram(matrix.getDiagram());
			robot.zoom(zoom);
			
			drawRow(elements, 140);
			drawRow(elements, 450);
			
			for(String l : links) {
				UMLElement start = matrix.getStartElement(e1);
				UMLLink link = start.getLinkType(l);

				if(link == null) {
					logger.fine("Skipping invalid starts: "+e1+" -> "+l);
					continue;
				}
				
				for (String e2 : elements) {
					//ignore Pins for now
					if(e2.indexOf("Pin") > -1 ) {
						continue;
					}

					if(link != null) {
						UMLElement end = link.destinations.get(e2);
						if(end == null) {
							logger.fine("Skipping invalid end: "+e1+" -> "+l+" ->"+e2);
							continue;
						}
					}

					try {
						robot.linkElements(l, e1+"1", e2+"2");
						robot.rightClick();
					} catch(Exception ex) {
						logger.warning("Problems drawing element: "+l+"\n"+IOUtils.getStackTrace(ex));
					}

					robot.waitForIdle();
					robot.delay(800);
				}
			}
			
			robot.closeDiagram();
			
		}
		
	}
	
	protected void drawRow(Collection<String> elements, int y) {
		int x = 200;
		int lineShift = 100;
		int i=0;

		for (String e : elements) {
			logger.info(e);
			i = i%3;
			int y2 = y + i*lineShift;
			try {
				robot.putElement(e, x, y2);
			} catch(Exception ex) {
				logger.warning("Problems drawing element: "+ex+"\n"+IOUtils.getStackTrace(ex));
			}
			x += 40;
			i++;
		}
		robot.delay(2000);
	}

}
