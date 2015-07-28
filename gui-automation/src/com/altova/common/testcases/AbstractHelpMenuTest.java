package com.altova.common.testcases;

import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import java.awt.event.KeyEvent;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.mapforce.VSnetMapForceRobot;
import com.altova.robots.AltovaApplicationRobot;
import com.altova.robots.PluginRobot;
import com.altova.spy.VSnetSpyRobot;
import com.altova.umodel.regression.gui.VSnetUModelRobot;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;

public abstract class AbstractHelpMenuTest extends AbstractJUnitTest {

	protected static AltovaApplicationRobot robot;
	
	//protected final String HELP_SCREEN = "User & Reference Manual";
	protected final String HELP_SCREEN = "User Manual";
	
	protected final String ACTIVATION = "Software Activation";
	
	//protected final String BROWSER = "Mozilla";
	protected final String BROWSEROrderForm = "The ALTOVA Online Shop";
	protected final String BROWSERSoftwareRegistration = "Mozilla";
	protected final String BROWSERWebSupportCenter = "Altova Support Center";
	protected final String BROWSERWebFaq = "Altova Support FAQ";
	protected final String BROWSERWebDownloadComponents = "Download Components and Free Tools";
	protected final String BROWSERApplicationOnWeb = "Altova XML Editor";
	
	public static void setUpBeforeClass(AltovaApplicationRobot appRobot) throws Exception {
		if(robot == null) {
			robot = appRobot;
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
	}
	
	protected void assertAndClose(String window) {
		delay(15000);
		try {
			if (!(robot instanceof PluginRobot)) {
				assertForegroundWindow(window);
			}
		} finally {
			robot.closeAltF4();
			delay(500);
			robot.escapeDialog("Do you want Firefox to save your tabs",KeyEvent.VK_Q); //this is needed for Mozilla
			robot.keyType(VK_ESCAPE);
			
		}
		assertTrue(robot.isApplicationFront());
	}
	
	@Test
	
	public final void testHelpToc() {
		robot.helpToc();
		assertAndClose(HELP_SCREEN);
	}

	@Test
	
	public final void testHelpIndex() {
		robot.helpIndex();
		assertAndClose(HELP_SCREEN);
	}

	@Test
	
	public final void testHelpSearch() {
		robot.helpSearch();
		assertAndClose(HELP_SCREEN);
	}

	@Test
	public final void testSoftwareActivation() {
		robot.softwareActivation();
		assertAndClose(ACTIVATION);
	}

	@Test
	public void testOrderForm() {
		robot.orderForm();
		assertAndClose(BROWSEROrderForm);
	}

	@Test
	@Ignore
	public final void testSoftwareRegistration() {
		robot.softwareRegistration();
		delay(15000);
		try {
			assertForegroundWindow(BROWSERSoftwareRegistration);
		} finally {
			if (robot.isApplicationFront()== false) {

				robot.closeAltF4();

			}
		}

	}

	@Test
	public final void testCheckForUpdates() {
		robot.checkForUpdates();
		try {
			assertAreas(TOP_WINDOW);
		} finally {

			assertAndClose(robot.getAppName());
		}
	}

	@Test
	public final void testWebSupportCenter() {
		robot.webSupportCenter();
		assertAndClose(BROWSERWebSupportCenter);
	}

	@Test
	public final void testWebFaq() {
		robot.webFaq();
		assertAndClose(BROWSERWebFaq);
	}

	@Test
	public final void testWebDownloadComponents() {
		robot.webDownloadComponents();
		assertAndClose(BROWSERWebDownloadComponents);
	}

	@Test
	public final void testApplicationOnWeb() {
		robot.applicationOnWeb();
		assertAndClose(BROWSERApplicationOnWeb);
	}

	@Test
	public final void testAbout() {
		robot.aboutApplication();
		try {
			assertAreas(TOP_WINDOW);
		}
		finally {
			robot.keyType(KeyEvent.VK_ESCAPE);
		}
	}
}
