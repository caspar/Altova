package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.*;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Ignore;
import org.junit.Test;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;

import static java.awt.event.KeyEvent.VK_END;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_SPACE;
import static java.awt.event.KeyEvent.VK_HOME;
import static java.awt.event.KeyEvent.VK_Y;
import static java.awt.event.KeyEvent.VK_ENTER;

import com.altova.robots.ScriptMistakeException;
import com.altova.util.ClipboardUtils;
import com.altova.util.IOUtils;

import com.altova.util.AltovaJUnitRunner.TestRobot;
import com.altova.util.Settings.AltovaApplication;



import static com.altova.spy.SpyRobot.*;

//@TestRobot(VSnetSpyRobot.class)
//@TestRobot(EclipseSpyRobot.class)
public class EditMenuTest extends AbstractXmlSpyTest{

	private static final String xpath = "/OrgChart";
	private static final String ToFind = "OrgChart";
	//private static File XML_JAPAN_FILE=IOUtils.findFile("examples/Japanese Shift_JIS.xml");;
	//private static final String JapToFind ="æ›¸"; //0x66F8;//can just be displayed correctly with utf8 encoding
	private static final String SpecCharToFind ="@";
	private static final String CommentPath = "/comment()";
	private static final String ToReplace = "MyDearOrgChart";
	private static final String anothxpath = "/OrgChart/Name";
	private static final String pathOrgchartName= "/OrgChart/Name";
	private static final String pathGomezRDEurope="/OrgChart/Office[2]/Department[3]/Person[3]/Last";
	private static final String procinst="<?altova_sps OrgChart.sps?>";
	private static final String poscursor= "The cursor is here";
	private static final String filepath = AltovaApplication.XMLSPY.getExamplesLocation().getAbsolutePath();
	private static final String AddressEUpath = "/OrgChart/Office[2]/Address_EU";
	private static String filenameToInclude="SampleFileToInclude.xml";
	
	private static final String escapeString = "<CompanyLogo href=\"http://www.altova.com/nanonull.gif\">&Altova'Logo'</CompanyLogo>";
	private static final String unescapeString = "&lt;CompanyLogo href=&quot;http://www.altova.com/nanonull.gif&quot;&gt;&amp;Altova&apos;Logo&apos;&lt;/CompanyLogo&gt;";
	protected static final File ESCAPE_TEXT_ICON   = IOUtils.findFile("spy/res/escapeText.png");
	protected static final File UNESCAPE_TEXT_ICON   = IOUtils.findFile("spy/res/unescapeText.png");
	
	/**Every time a new workspace is created, default setting are taken, 
	*so the encoding used won't be able to decode this character in eclipse.
	*Also, since we are testing spy's encoding, we don't need this test for the plugin
	**/
	@Test
	@IgnoreRobots({EclipseSpyRobot.class, VSnetSpyRobot.class}) 
	public void testFindSpecialChar() {
		//robot.openFile(XML_JAPAN_FILE);
		//ClipboardUtils.setClipboardContents(JapToFind); //this char can just be shown with utf-8
		//robot.find();delay(500);
		//robot.pasteKey();delay(100);
		//robot.keyType(KeyEvent.VK_ENTER);
		//robot.escapeDialog("Find", VK_ESCAPE);//in case window is still there, we escape it
		robot.textView();
		robot.find(SpecCharToFind);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	
	public void testUndo() {
		robot.authenticView();
		robot.xpathHighlight(xpath);
		robot.delete();
		robot.undo();
		assertAreas(DIAGRAM_MAIN_WINDOW);	
	}
	
	@Test
	
	public void testRedo() {
		robot.authenticView();
		robot.xpathHighlight(xpath);
		robot.delete();
		robot.undo();
		robot.redo();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	
	public void testCut() {
		robot.authenticView();
		robot.xpathHighlight(xpath);
		robot.cut();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testCopy() {
		robot.textView();
		robot.findSelection(ToFind);
		robot.copy();
		String clipboard = ClipboardUtils.getClipboardContents();
		assertEquals(ToFind, clipboard);
	}

	@Test
	
	public void testPaste() {
		robot.textView();
		robot.findSelection(procinst);
		robot.copy();
		delay(1000);
		robot.keyType(VK_END);
		robot.paste();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	
	public void testDelete() {
		robot.authenticView();
		robot.xpathHighlight(xpath);
		robot.delete();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testFind() {
		robot.textView();
		robot.find(ToFind);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	@IgnoreRobots(VSnetSpyRobot.class) //ignored till they fix 27995
	public void testMenuFindNext() {
		robot.textView();
		robot.find(ToFind);
		robot.menufindNext();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void testMarkAll(){
		robot.textView();
		robot.markAll("Name");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testCopyAsXMLText() {
		robot.gridView();
		robot.xpathHighlight(pathOrgchartName);
		robot.copyAsXMLText();
		String clipboard = ClipboardUtils.getClipboardContents();
		assertEquals( "<Name>Organization Chart</Name>", clipboard);
	}

	@Test
	public void testCopyXPointerTextView() {
		robot.gridView();
		robot.xpathHighlight(pathGomezRDEurope);
		robot.textView();
		robot.copyXPointer();
		String xpointer = ClipboardUtils.getClipboardContents();
		assertEquals("element(/1/4/10/4/2)",xpointer);
		
	}
	
	@Test
	public void testCopyXPointerGridView() {
		robot.gridView();
		robot.xpathHighlight(pathGomezRDEurope);
		robot.copyXPointer();
		String xpointer = ClipboardUtils.getClipboardContents();
		assertEquals("element(/1/4/10/4/2)",xpointer);
		
	}
	
	@Test
	public void testCopyAsStructuredText() {
		robot.gridView();
		robot.xpathHighlight(pathOrgchartName);
		robot.copyAsStructuredText();
		String clipboard = ClipboardUtils.getClipboardContents();
		assertEquals("Name\tOrganization Chart\n",clipboard);
		
	}

	@Test
	public void testInsertFilePath() {
		robot.textView();
		robot.xpathHighlight(xpath);
		robot.insertFilePath(filepath);
		assertAreas(DIAGRAM_MAIN_WINDOW);	
		
	}
	
	@Test
	//testing with default options
	public void testInsertXIncludeTextView(){
		robot.textView();
		robot.findSelection(ToFind);
		robot.findNext();
		robot.keyType(VK_END);
		robot.insertXInclude(filenameToInclude);
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	//testing with default options
	public void testInsertXIncludeGridView(){
		robot.gridView();
		robot.xpathHighlight(xpath+ "/CompanyLogo");
		robot.insertXInclude(filenameToInclude);
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testCopyXPath() {
		robot.xpathHighlight(pathOrgchartName);
		robot.copyXPath();
		String clipboard = ClipboardUtils.getClipboardContents();
		assertEquals("/OrgChart/Name/text()",clipboard);
	}
		
	
	@Test
	public void testPrettyPrintXML() {
		robot.prettyPrintXML();
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	public void testReplaceFirst() {
		robot.textView();
		robot.replaceFirst(ToFind, ToReplace);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	
	@Test
	@IgnoreRobots({EclipseSpyRobot.class, VSnetSpyRobot.class}) //VS and eclipse have its own find in files 
	public void testFindInFiles() {
		robot.findInFiles("OrgChart");
		assertAreas(FIND_IN_FILES);
	}

	@Test
	public void testInsertBookmark() {
		robot.textView();
		robot.xpathHighlight(xpath);
		robot.insertBookmark();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testRemoveBookmark() {
		robot.textView();
		robot.xpathHighlight(xpath);
		robot.insertBookmark();
		robot.removeBookmark();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testRemoveAllBookmarks() {
		robot.textView();
		robot.xpathHighlight(xpath);
		robot.insertBookmark();
		robot.xpathHighlight(anothxpath);
		robot.insertBookmark();
		robot.removeAllBookmarks();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testGoToNextBookmark() {
		
		robot.textView();
		robot.xpathHighlight(xpath);
		robot.insertBookmark();
		robot.xpathHighlight(anothxpath);
		robot.insertBookmark();
		robot.xpathHighlight("/comment()");
		robot.insertBookmark();
		robot.leftClick(robot.getMainWindow().x+20,robot.getMainWindow().y+20);
		robot.findTextViewSpecific("Organization Chart");
		robot.goToNextBookmark();delay(1000);
		robot.typeString(poscursor);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testGoToPreviousBookmark() {
		
		robot.textView();
		robot.xpathHighlight(xpath);
		robot.insertBookmark();
		robot.xpathHighlight(anothxpath);
		robot.insertBookmark();
		robot.xpathHighlight("/comment()");
		robot.insertBookmark();
		robot.leftClick(robot.getMainWindow().x+20,robot.getMainWindow().y+20);
		robot.findTextViewSpecific("Organization Chart");
		robot.goToPreviousBookmark();delay(1000);
		robot.typeString(poscursor);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testSetCommentInOut(){
		robot.gridView();
		robot.xpathHighlight(AddressEUpath);
		robot.commentInOut();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRemoveCommentInOut(){
		robot.gridView();
		robot.xpathHighlight(CommentPath);
		robot.commentInOut();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testEscapeXMLChararcters(){
		robot.openFile(ESCAPE_XML_FILE);
		robot.keyType(VK_HOME);
		robot.find(escapeString);
		//--added because sometimes, VK_HOME doesn´t work (in single instance, test case work correctly but not when the entire suite is running)
		robot.escapeDialog("Reached the end", VK_ENTER);
		robot.keyType(VK_ESCAPE);
		robot.keyType(VK_ESCAPE);
		//--end
		robot.escapeXMLCharacter(ESCAPE_TEXT_ICON);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testUnescapeXMLChararcters(){
		robot.openFile(ESCAPE_XML_FILE);
		robot.keyType(VK_HOME);
		robot.find(unescapeString);
		//--added because sometimes, VK_HOME doesn´t work (in single instance, test case work correctly but not when the entire suite is running)
		robot.escapeDialog("Reached the end", VK_ENTER);
		robot.keyType(VK_ESCAPE);
		robot.keyType(VK_ESCAPE);
		//--end

		robot.unescapeXMLCharacter(UNESCAPE_TEXT_ICON);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

}
