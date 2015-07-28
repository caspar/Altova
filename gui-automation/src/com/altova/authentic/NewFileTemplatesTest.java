package com.altova.authentic;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.util.LoggerUtils.logger;
import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.altova.util.XMLFileReader;
import com.altova.util.Settings.AltovaApplication;

public class NewFileTemplatesTest extends AbstractAuthenticTest {

	private static final XMLFileReader DATA_SPS = new XMLFileReader("data/authentic/NewFileTemplatesTestData.xml");

	private static final String dirfiles[] = DATA_SPS.getAllValueOfNode("fileset", "directory");

	private static final String filenames[] = DATA_SPS.getAllValueOfNode("fileset", "filename");

	private static final String selRootElem_dialog[]=DATA_SPS.getAllValueOfNode("fileset", "ifdialog");
	
	private static final String testnames[]=DATA_SPS.getAllValueOfNode("fileset", "testname");
	
	
	@Before
	public void setUp() throws Exception {

		super.setUp();
	}
	
	
	@After
	public void tearDown() throws Exception {
		robot.closeAllSaveNoChanges(dirfiles.length);
		super.tearDown();
		assertNull(robot.getDiagramComponent());
	}
	
	@Test
	public void test_newAuthenticFile() {
		String preJUDR = System.getenv("JUnitDryRun");
		//logger.warning("JUNIT_BEFORE= " + preJUDR);
		System.setProperty("JUnitDryRun", "true");

		for (int j = 0; j < dirfiles.length; j++) {
			delay(1000);
			robot.newAuthenticFile(AltovaApplication.AUTHENTIC.getInstallLocation().getAbsolutePath() + "\\sps\\Template\\" + dirfiles[j] + "\\" + filenames[j]);
			delay(3000);
			if (selRootElem_dialog[j].equals("yes")) {
				robot.escapeDialog("Select a root element", KeyEvent.VK_ENTER);
			}
			robot.validateViaIcon();
			assertWindowAndEscape("test_newFileTemp_" + testnames[j]+"_validation");
			delay(1000);
			assertAreas("test_newFileTemp_" + testnames[j], DIAGRAM_MAIN_WINDOW);
			

		}
		if (preJUDR != null) {

			System.setProperty("JUnitDryRun", preJUDR);

		} else {
			System.setProperty("JUnitDryRun", "false");
		}
	}
}
