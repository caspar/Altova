package com.altova.spy;


import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;

import java.awt.event.KeyEvent;
import java.io.File;

import static com.altova.spy.SpyRobot.*;
import static java.awt.event.KeyEvent.VK_N;
import static java.awt.event.KeyEvent.VK_Y;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_PAGE_DOWN;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.util.IOUtils;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;

//@TestRobot(EclipseSpyRobot.class)
//@TestRobot(VSnetSpyRobot.class)
public class AuthenticMenuTest extends AbstractXmlSpyTest {

	private static final File EXAMPLE_CARS1 = IOUtils.findFile("spy/examples/cars1.xml");
	private static final File ORGCHART_SPS_FILE = IOUtils.findFile("spy/examples/OrgChart.sps");
	//private static final File RICHEDIT_PXF_FILE = IOUtils.findFile("spy/examples/RichEdit.pxf");
	private static final File RICHEDIT_PXF_FILE = IOUtils.findFile("spy/examples/RichEdit_reduced.pxf");
	private static final String xpath= "/OrgChart/Office[1]/Department[1]/Person[2]/First";
	private static final String path_Vernon="/OrgChart/Office[1]/Department[1]/Person[1]/First";
	
	private static final File ORGCHART_HTML_FILE = IOUtils.findFile("spy/examples/OrgChart.html");
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		robot.authenticView();
	}

	@Test
	public void testNewAuthenticDocument() {
		robot.newAuthenticDocument();
		assertForegroundWindow("Create new document");
		robot.keyType(KeyEvent.VK_ESCAPE);  //exit the dialog
	}

	@Test
	public void testEditDatabaseData() {
		robot.editDatabaseData();
		assertForegroundWindow("Edit database data");
		robot.keyType(KeyEvent.VK_ESCAPE);  //exit the dialog
	}

	@Test
	public void testAssignSVStylesheet() {
		robot.openFile(EXAMPLE_CARS1);
		robot.assignSVStylesheet(ORGCHART_SPS_FILE.getAbsolutePath());
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	@Ignore public void testEditSVStylesheet() {
		fail("Not yet implemented");
	}

	@Test
	public void testHideMarkup() {
		robot.showLargeMarkup();
		robot.hideMarkup();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testShowSmallMarkup() {
		robot.showSmallMarkup();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testShowLargeMarkup() {
		robot.showLargeMarkup();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testShowMixedMarkup() {
		robot.showMixedMarkup();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	//Richedit test cases
	@Test
	public void testRichEditToggleBold_On() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("Create Eye-Catching Output");
		robot.toggleBold();
		focusOut();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditToggleBold_Off() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("StyleVision Overview");
		robot.toggleBold();
		focusOut();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditToggleItalic_On() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("Create Eye-Catching Output");
		robot.toggleItalic();
		focusOut();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditToggleItalic_Off() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("StyleVision Overview");
		robot.toggleItalic();
		focusOut();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditToggleUnderline_On() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("Create Eye-Catching Output");
		robot.toggleUnderline();
		focusOut();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditToggleUnderline_Off() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("true single source publishing");
		robot.toggleUnderline();
		focusOut();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testRichEditToggleStrikeThrough_On() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("Create Eye-Catching Output");
		robot.toggleStrikeThrough();
		focusOut();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditToggleStrikeThrough_Off() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("for Web developers");
		robot.toggleStrikeThrough();
		focusOut();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditForegroundColor() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("Visual Stylesheet Design");
		robot.foregroundColor(RED_COLOR_PALETTE_ICON);
		focusOut();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditBackgroundColor() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("Visual Stylesheet Design");
		robot.backgroundColor(GREEN_COLOR_PALETTE_ICON);
		focusOut();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditAlignLeft() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("Visual Stylesheet Design");
		robot.alignLeft();
		focusOut();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditAlignCenter() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("Create Eye-Catching Output");
		robot.alignCenter();
		focusOut();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRichEditAlignRight() {
		
		robot.openFile(RICHEDIT_PXF_FILE);
		robot.find("Create Eye-Catching Output");
		robot.alignRight();
		focusOut();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testAuthenticAppendRow() {
		robot.xpathHighlight(xpath);
		robot.authenticAppendRow();
		//robot.gridView();  selection gets lost, so we'd better not switch
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAuthenticInsertRow() {
		robot.xpathHighlight(xpath);
		robot.authenticInsertRow();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAuthenticDuplicateRow() {
		robot.xpathHighlight(path_Vernon);
		robot.authenticDuplicateRow();
		//robot.xpathHighlight(xpath);
		//robot.gridView(); //robot.gridView();  selection gets lost, so we'd better not switch
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAuthenticMoveRowUp() {
		robot.xpathHighlight(xpath);
		robot.authenticMoveRowUp();
		robot.xpathHighlight(xpath);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAuthenticMoveRowDown() {
		robot.xpathHighlight(xpath);
		robot.authenticMoveRowDown();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAuthenticDeleteRow() {
		robot.xpathHighlight(xpath);
		robot.authenticDeleteRow();
		assertAreas(DIAGRAM_MAIN_WINDOW);
		assertAreas(ELEMENTS);
		assertAreas(ATTRIBUTES);
	}
	
	@Test
	public void testGenerateHTMLDocument() {
	
		removeAndAssert(ORGCHART_HTML_FILE);
		robot.openFile(ORGCHART_PXF_FILE);
		
		robot.generateAnHTMLDocument(ORGCHART_HTML_FILE);
		
		assertAreas(DIAGRAM_MAIN_WINDOW, INFO, MESSAGES);
	}
	
	//Will not generate output: it should necessary an external program 
	@Test
	public void testGenerateRTFDocument() {
		
		robot.openFile(ORGCHART_PXF_FILE);		
		robot.generateAnRTFDocument(null);
	}
	
	//Will not generate output: it should necessary an external program 
	@Test
	public void testGeneratePDFDocument() {
		
		robot.openFile(ORGCHART_PXF_FILE);
		robot.generateAPDFDocument(null);
	}
	
	//Will not generate output: it should necessary an external program 
	@Test
	public void testGenerateDOCXDocument() {
		
		robot.openFile(ORGCHART_PXF_FILE);		
		robot.generateADOCXDocument(ORGCHART_HTML_FILE);
	}
	
	@Test
	public void testTrustedLocation_AlwaysRunAuthenticScript() {
		
		robot.trustedLocation();
		robot.deleteTrustedPath();
		
		robot.setTrustedLocations_Always();
		robot.clickButton("OK");
		robot.openFile(ORGCHART_PXF_FILE);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testTrustedLocation_NeverRunAuthenticScript() {

		robot.trustedLocation();
		robot.deleteTrustedPath();
		
		robot.setTrustedLocations_Never();
		robot.clickButton("OK");
		robot.openFileNoMaxNoPopup(ORGCHART_PXF_FILE);
		delay(2000);
		assertAreas(TOP_WINDOW);
		robot.clickButton("OK");
		delay(2000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testTrustedLocation_OnlyRunFromTrustedLocation_true() {
		
		robot.trustedLocation();
		robot.deleteTrustedPath();
		
		robot.addTrustedPath(TRUSTED_LOCATION_FOLDER);
		robot.clickButton("OK");
		
		robot.openFileNoMaxNoPopup(ORGCHART_PXF_FILE_DBS);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	public void testTrustedLocation_OnlyRunFromTrustedLocation_false() {
		
		robot.trustedLocation();
		robot.deleteTrustedPath();
		
		robot.addTrustedPath(TRUSTED_LOCATION_FOLDER);
		robot.clickButton("OK");
		
		robot.openFileNoMaxNoPopup(ORGCHART_PXF_FILE);
		//yes, allow the new folder in Trusted loc
	
		assertAreas(getTestName()+ "_Authentic_Script_Warning", TOP_WINDOW);
		robot.escapeDialog("Authentic Script Warning", VK_N);
	
		assertAreas(getTestName()+ "_disabled_functionality_alert", TOP_WINDOW);
		robot.escapeDialog("XMLSpy", VK_ENTER);
		delay(3000);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testTrustedLocation_OnlyRunFromTrustedLocation_false_notTrusted() {
		
		robot.trustedLocation();
		robot.deleteTrustedPath();
		
		robot.addTrustedPath(TRUSTED_LOCATION_FOLDER);
		robot.clickButton("OK");
		
		robot.openFileNoMaxNoPopup(ORGCHART_PXF_FILE);
		//no, dont allow the new folder in Trusted loc
		delay(1000);
		assertAreas(getTestName()+ "_Authentic_Script_Warning", TOP_WINDOW);
		robot.escapeDialog("Authentic Script Warning", VK_Y);
		delay(3000);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);

		robot.trustedLocation();
		assertAreas(getTestName()+ "_Added_Trusted_Location", TOP_WINDOW);
		robot.clickButton("OK");
		
	}
	

	public void focusOut() {
		
		robot.textView();
		robot.keyType(VK_PAGE_DOWN);
		robot.delay(200);
		robot.authenticView();
		
	}
	
}
