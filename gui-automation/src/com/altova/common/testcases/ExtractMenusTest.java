package com.altova.common.testcases;


import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.authentic.AuthenticRobot;
import com.altova.diffdog.DiffDogRobot;
import com.altova.mapforce.EclipseMapForceRobot;
import com.altova.mapforce.MapForceRobot;
import com.altova.mapforce.VSnetMapForceRobot;
import com.altova.nativegui.ComponentInfo;
import com.altova.nativegui.NativeGUI;
import com.altova.robots.AltovaApplicationRobot;
import com.altova.robots.ImageFileDiff;
import com.altova.robots.PluginRobot;
import com.altova.robots.ScreenDiff;
import com.altova.robots.ScriptMistakeException;
import com.altova.robots.VSnetRobot;
import com.altova.spy.EclipseSpyRobot;
import com.altova.spy.SpyRobot;
import com.altova.spy.VSnetSpyRobot;
import com.altova.stylevision.StyleVisionRobot;
import com.altova.umodel.regression.gui.EclipseUModelRobot;
import com.altova.umodel.regression.gui.UModelRobot;
import com.altova.umodel.regression.gui.VSnetUModelRobot;
import com.altova.util.IOUtils;
import com.altova.util.Settings;
import com.altova.util.AltovaJUnitRunner.TestRobot;
import com.altova.util.Settings.AltovaApplication;

import static com.altova.util.LoggerUtils.logger;

import com.altova.schemaagent.SchemaAgentRobot;
import com.altova.semanticworks.SemanticWorksRobot;
import com.altova.databasespy.DatabaseSpyRobot;


//@TestRobot(MapForceRobot.class)
//@TestRobot(EclipseMapForceRobot.class)
//@TestRobot(EclipseSpyRobot.class)
//@TestRobot(VSnetSpyRobot.class)
//@TestRobot(SpyRobot.class)
public class ExtractMenusTest extends AbstractJUnitTest {

	protected static AltovaApplicationRobot robot;

	protected static String compartype = "Compare Files";
	
	private static String preJUDR= "false";
	
	protected static final File DBSPY_DBDIFF_AUTOLAYOUT  = IOUtils.findFile("examplesDBSpy/AutolayoutDataComparison.dbdif");	
	protected static final File DBSPY_DBSDIFF_AUTOLAYOUT  = IOUtils.findFile("examplesDBSpy/AutolayoutSchemaComparison.dbsdif");


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if (robot == null) {
			throw new ScriptMistakeException("Robot was not initialized");
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
		//preJUDR=System.getenv("JUnitDryRun");
		preJUDR=Settings.getProperty("JUnitDryRun","false");
		logger.info("JUNIT_BEFORE= "+preJUDR);
	}
	
	@AfterClass
	public static void changeJUnitDryRunVariable() {
		logger.info("JUNIT_AFTER= "+preJUDR);
			
		System.setProperty("JUnitDryRun", preJUDR);

	}

	@Test
	public void testMenus() {

		// start the application of the specified robot
		robot.activateApplication();
		String currentapp = robot.getAppName();
		// logger.finest(currentapp);
		System.out.println(currentapp);
		if (robot instanceof SpyRobot || robot instanceof AuthenticRobot || robot instanceof EclipseSpyRobot || robot instanceof VSnetSpyRobot) {
			File page = IOUtils.findFile("examples/OrgChart.xml");
			robot.openFile(page.toString());
			robot.delay(2000); // sometime,opening a file takes quite a long
								// time
			if (robot instanceof EclipseSpyRobot) {
				robot.escapeDialog("The XMLSpy perspective is associated with this file type", KeyEvent.VK_Y);

			}
			getMenuScreenshot();
			//this bit has to be evaluated in the future ( whenever I have time)
//		} else if (robot instanceof VSnetUModelRobot) {
//			robot.leftClickMenuItem("File", "Open","Project/Solution");delay(4000);
//			robot.typeStringEnter(AltovaApplication.UMODEL.getExamplesLocation().getAbsolutePath()+"\\Bank_CSharp.ump");
//			robot.escapeDialog("Save changes", KeyEvent.VK_N);
//			robot.delay(4000);
		} else if (robot instanceof MapForceRobot || robot instanceof VSnetMapForceRobot) {
			File page = IOUtils.findFile("examples/CompletePO.mfd");
			robot.openFile(page);
			robot.delay(4000); // sometime,opening a file takes quite a long
								// time
			//this bit has to be evaluated in the future ( whenever I have time)
			getMenuScreenshot();
			
//		} else if (robot instanceof VSnetUModelRobot) {
//			robot.leftClickMenuItem("File", "Open","Project/Solution");delay(4000);
//			robot.typeStringEnter(AltovaApplication.UMODEL.getExamplesLocation().getAbsolutePath()+"\\Bank_CSharp.ump");
//			robot.escapeDialog("Save changes", KeyEvent.VK_N);
//			robot.delay(4000);
		}else if (robot instanceof StyleVisionRobot) {
			StyleVisionRobot svrobot = (StyleVisionRobot) robot;
			svrobot.newSPS("New (empty)");
			svrobot.leftClickButton("OK");delay(500);//press Ok for new empty design
			robot.delay(1000);
			getMenuScreenshot();
			
		}else if ( robot instanceof UModelRobot){
			UModelRobot UMRobot = (UModelRobot) robot;
			UMRobot.newPrj();	
			getMenuScreenshot();	
			
		} else if (robot instanceof DiffDogRobot) {
			DiffDogRobot ddrobot = (DiffDogRobot) robot;
			ddrobot.setCompareType(compartype);
			getMenuScreenshot();
		
		}else if ( robot instanceof SchemaAgentRobot){
			SchemaAgentRobot SARobot = (SchemaAgentRobot) robot;
			SARobot.newDesign();	
			getMenuScreenshot();
	
		}else if ( robot instanceof SemanticWorksRobot){
			SemanticWorksRobot semWorRobot = (SemanticWorksRobot) robot;
			semWorRobot.newFile();
			
		}else if ( robot instanceof DatabaseSpyRobot){
			
			DatabaseSpyRobot DBspyRobot = (DatabaseSpyRobot) robot;
			DBspyRobot.newDesignEditor();
			getMenuScreenshot("design");
			
			DBspyRobot.newSQLEditor();
			getMenuScreenshot("sql");
			
			DBspyRobot.openFile(DBSPY_DBSDIFF_AUTOLAYOUT);
			getMenuScreenshot("xsd_comp");
			
			DBspyRobot.openFile(DBSPY_DBDIFF_AUTOLAYOUT);
			getMenuScreenshot("db_comp");
			
		}	
		
		
		
		robot.exitApplication();
	}
	
	public void getMenuScreenshot(String view){
		
		
		// get the menus
		Rectangle menuBar = robot.findMenuBar("File");
		List<Rectangle> menus = findMenus(menuBar);
		captureMenus(menus, view);
		robot.keyType(KeyEvent.VK_ESCAPE);
		robot.delay(2000);
		
	}
	
	
	public void getMenuScreenshot(){
		
		getMenuScreenshot("");
		
	}

	public List<Rectangle> findMenus(Rectangle menuBar) {
		List<Rectangle> ans = new ArrayList<Rectangle>();

		// press ESC, to make sure nothing is selected
		robot.keyType(KeyEvent.VK_ESCAPE);

		// take the initial diff
		ScreenDiff diff = new ScreenDiff(robot);
		diff.snapBefore(menuBar);

		// start a bit into the menu bar
		int y = menuBar.y + menuBar.height / 2;
		for (int x = menuBar.x + 20; x < menuBar.x + (menuBar.width) - 75; x += 15) {
			robot.mouseMove(x, y);
			robot.delay(100);
			diff.snapAfter();
			Rectangle menu = diff.diffBounds();
			if (menu != null && !ans.contains(menu)) {
				ans.add(menu);
				System.out.println(menu);
			}
		}

		return ans;
	}

	public void captureMenus(List<Rectangle> menus, String view) {
		
		int i = 0;
		String runName = getRunName(robot) + File.separator;

		for (Rectangle r : menus) {
			// press ESC, to make sure nothing is selected
			robot.keyType(KeyEvent.VK_ESCAPE); 
			robot.delay(1000);

			// click the menu name
			robot.leftClickMid(r);
			robot.delay(1500);
//			if((robot instanceof PluginRobot)&&(i!=0)){
//			
//				robot.leftClickMid(r);
//				robot.delay(1500);
//			}

			// get the menu dropdown
			int x = r.x + r.width / 2;
			int y = r.y + r.height + 20;

			ComponentInfo menu = NativeGUI.getWindowInfo(x, y);
			logger.finest("" + menu);
			assertMenu(menu.getLocation(), runName + "menu" + view + i + ".png");

			findSubMenus(menu.getLocation(), i, view);
			//escape submenu : trial
			robot.keyType(KeyEvent.VK_ESCAPE); 
			i++;
		}

	}
	
	public void captureMenus(List<Rectangle> menus) {
		
		captureMenus(menus, "");
		
	}

	public List<Rectangle> findSubMenus(Rectangle menu, int menuId, String view) {
		
		List<Rectangle> ans = new ArrayList<Rectangle>();
		String runName = getRunName(robot) + File.separator;

		// take the initial diff
		ScreenDiff diff = new ScreenDiff(robot);
		Rectangle rightOfMenu = new Rectangle(menu.x + menu.width + 5, menu.y, 30, menu.height);
		diff.snapBefore(rightOfMenu);

		// start a bit into the menu bar
		int x = menu.x + menu.width / 2;
		int i = 0;
		for (int y = menu.y + 5; y < menu.y + menu.height; y += 10) {
			robot.mouseMove(x, y);
			robot.delay(500);
			diff.snapAfter();
			Rectangle submenu = diff.diffBounds();
			if (submenu != null && !ans.contains(submenu)) {
				ans.add(submenu);
				logger.finest("" + submenu);

				int subx = submenu.x + submenu.width / 2;
				int suby = submenu.y + submenu.height / 2;
				ComponentInfo menu2 = NativeGUI.getWindowInfo(subx, suby);
				logger.finest("" + menu2);
				assertMenu(menu2.getLocation(), runName + "menu" + menuId + "_submenu" + view + i + ".png");
				i++;
			}
		}

		return ans;

	}
	
	
	public List<Rectangle> findSubMenus(Rectangle menu, int menuId) {
		
		return findSubMenus(menu, menuId, "");
		
	}

	private void assertMenu(Rectangle location, String imageName) {
		File output;

		try {
			//we want no assertion, so we set JUnitDryRun to true

			System.setProperty("JUnitDryRun", "true");
			output = robot.saveScreen(location, imageName);
			ImageFileDiff diff = ImageFileDiff.expectedDiffFactory(output);
			assertImage(diff);
			robot.delay(1000);
		} catch (IOException e) {
			String msg = "Failed to save image " + imageName + "\n " + IOUtils.getStackTrace(e);
			logger.severe(msg);
			throw new ScriptMistakeException(msg);
		}

	}

	public static void setRobot(AltovaApplicationRobot robot) {
		ExtractMenusTest.robot = robot;
	}

}
