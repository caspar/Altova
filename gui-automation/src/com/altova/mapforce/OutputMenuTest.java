/**
 * 
 */
package com.altova.mapforce;

import static com.altova.mapforce.MapForceRobot.MESSAGES;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.ImageRecognitionRobot.WINDOWS_DEFAULT_FONT;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.Options;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;
import com.altova.util.IOUtils;
import com.altova.util.AltovaJUnitRunner.TestRobot;

/**
 * @author b.lopez
 *
 */
//@TestRobot(VSnetMapForceRobot.class)
public class OutputMenuTest extends AbstractMapForceTest {

	private static final File LOOKUP_STANDARD_MFD=IOUtils.findFile("examples/lookup-standard.mfd"); 
	private static final File EDI_ORDER_DB_MFD=IOUtils.findFile("examples/EDI_ORDER_DB.mfd");
	
	@Test
	public void testOutputXSLT1(){
		robot.openFile( LOOKUP_STANDARD_MFD);
		robot.outputXsltMenu();
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"XSLT1_output");
		robot.generateCodeInSelectedLanguage(ROOT_PATH);
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\DoTransform.bat"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\MappingMapToCompletePO.xslt"));
		assertAreas(MESSAGES);		
	}
	
	@Test
	public void testOutputXSLT2(){
		robot.openFile( LOOKUP_STANDARD_MFD);
		robot.outputXslt2Menu();
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"XSLT2_output");
		robot.generateCodeInSelectedLanguage(ROOT_PATH);
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\DoTransform.bat"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\MappingMapToCompletePO.xslt"));
		assertAreas(MESSAGES);		
	}
	
	@Test
	public void testOutputXQuery(){
		robot.openFile(LOOKUP_STANDARD_MFD);
		robot.outputXqMenu();
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"Xquery_output");
		robot.generateCodeInSelectedLanguage(ROOT_PATH);
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\DoTransform.bat"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\MappingMapToCompletePO.xq"));
		assertAreas(MESSAGES);		
	}
	
	@Test
	public void testOutputJava(){
		robot.openFile(LOOKUP_STANDARD_MFD);
		robot.outputJavaMenu();
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"Java_output");
		robot.generateCodeInSelectedLanguage(ROOT_PATH);
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\build.xml"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\.project"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Mapping.jpx"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\META-INF\\MANIFEST.MF"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\com\\altova\\mapforce\\MFElement.java"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\com\\altova\\mapforce\\MFAttribute.java"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\com\\mapforce\\MappingMapToCompletePO.java"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\com\\mapforce\\MappingApplication.java"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\com\\mapforce\\MappingFrame.java"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\com\\mapforce\\user\\LookUpArticle.java"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\com\\mapforce\\MappingConsole.java"));
		assertAreas(MESSAGES);		
	}
	
	@Test
	public void testOutputCSharp(){
		robot.openFile(LOOKUP_STANDARD_MFD);
		robot.outputCSharpMenu();
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"CSharp_output");
		robot.generateCodeInSelectedLanguage(ROOT_PATH);
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Mapping\\Mapping.sln"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Mapping\\Mapping.csproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Altova\\Altova.csproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\AltovaFunctions\\AltovaFunctions.csproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\AltovaXML\\AltovaXML.csproj"));
		assertAreas(MESSAGES);		
	}
	
	
	@Test
	public void testOutputCpp(){
		robot.openFile(LOOKUP_STANDARD_MFD);
		robot.outputCppMenu();
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"C++_output");
		robot.generateCodeInSelectedLanguage(ROOT_PATH);
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Mapping\\Mapping.sln"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Mapping\\Mapping.vcproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Mapping\\MappingMapToCompletePO.cpp"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Mapping\\Mapping.dsw"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Mapping\\Mapping.rc"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\Altova\\Altova.vcproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\AltovaFunctions\\AltovaFunctions.vcproj"));
		assertFileExists(new File(ROOT_PATH.getAbsolutePath()+"\\AltovaXML\\AltovaXML.vcproj"));
		assertAreas(MESSAGES);		
	}
	
	@Test
	public void tesValidateOutputFile(){
		robot.openFile(COMPLETE_PO_MFD);
		robot.showOutput();
		robot.validateOutputFile();
		assertMapForceMessageWindow(robot);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void tesSaveOutputFile(){
		robot.openFile(COMPLETE_PO_MFD);
		File ROOT_PATH=new File(FILE_OUTPUT_PATH,"MapForceOutputXML.xml");
		if(ROOT_PATH.exists()){
			ROOT_PATH.delete();
		}
		robot.showOutput();
		robot.saveOutputFile(ROOT_PATH);
		delay(3000);
		assertFileExists(ROOT_PATH);
	}
	
	@Test
	public void testRunSQLScript(){
	robot.openFile(EDI_ORDER_DB_MFD);
	delay(5000);
	robot.escapeDialog("MapForce" ,VK_ESCAPE );
	delay(1000);
	robot.showOutput();
	robot.runSQLScript();
	assertAreas(DIAGRAM_MAIN_WINDOW,MESSAGES);
	}
	
	@Test
	public void testInsertBookmark(){
		robot.openFile(EDI_ORDER_DB_MFD);
		delay(5000);
		robot.escapeDialog("MapForce" ,VK_ESCAPE );
		robot.showOutput();
		robot.find("UPDATE");
		robot.insertBookmark();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Ignore //this cannot be tested with the robot, as cursor position is not properly shown in the snapshot
	@Test
	public void testNextBookmark(){
		robot.openFile(EDI_ORDER_DB_MFD);
		robot.showOutput();
		robot.find("UPDATE");
		robot.insertBookmark();
		robot.find("INSERT");
		robot.insertBookmark();
		robot.nextBookmark();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Ignore //this cannot be tested with the robot, as cursor position is not properly shown in the snapshot
	@Test
	public void testPreviousBookmark(){
		robot.openFile(EDI_ORDER_DB_MFD);
		robot.showOutput();
		robot.find("UPDATE");
		robot.insertBookmark();
		robot.find("INSERT");
		robot.insertBookmark();
		robot.nextBookmark();
		robot.previousBookmark();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRemoveAllBookmarks(){
		robot.openFile(EDI_ORDER_DB_MFD);
		delay(1000);
		robot.escapeDialog("Important:", VK_ESCAPE);
		robot.showOutput();
		delay(500);
		robot.escapeDialog("Important: Your mapping has one or more", VK_ESCAPE);
		robot.find("UPDATE");
		robot.insertBookmark();
		robot.find("INSERT");
		robot.insertBookmark();
		robot.removeAllBookmarks();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testPrettyPrintXML(){
		robot.openFile(COMPLETE_PO_MFD);
		robot.selectComponentFromImage(COMPLETEPO_COMPONENT);
		Options options=new Options();	
		options.add(new CheckboxOption("Pretty print output",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.componentProperties(options);
		robot.showOutput();
		robot.prettyPrintXML();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testLineNumbersMarginOff() {
		robot.openFile(COMPLETE_PO_MFD);
		robot.showOutput();
		Options optionsf=new Options();
		Options optionst=new Options();
		optionsf.add(new CheckboxOption("Line number margin",false));
		optionst.add(new CheckboxOption("Line number margin",true));
		robot.textViewSettings(optionsf);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
		finally {
			robot.textViewSettings(optionst);
		}
	}
	
	@Test
	public final void testLineNumbersMarginOn() {
		robot.openFile(COMPLETE_PO_MFD);
		robot.showOutput();
		Options optionst=new Options();
		optionst.add(new CheckboxOption("Line number margin",true));
		robot.textViewSettings(optionst);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	
	@Test 
	public final void testBookmarksMarginOff() {
		robot.openFile(COMPLETE_PO_MFD);
		robot.showOutput();
		Options optionsf=new Options();
		Options optionst=new Options();
		optionsf.add(new CheckboxOption("Bookmark margin",false));
		optionst.add(new CheckboxOption("Bookmark margin",true));
		robot.textViewSettings(optionsf);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
		finally {
			robot.textViewSettings(optionst);
		}
	}

	@Test 
	public final void testBookmarksMarginOn() {
		robot.openFile(COMPLETE_PO_MFD);
		robot.showOutput();
		Options optionst=new Options();
		optionst.add(new CheckboxOption("Bookmark margin",true));
		robot.textViewSettings(optionst);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testSourceFoldingMarginOff() {
		robot.openFile(COMPLETE_PO_MFD);
		robot.showOutput();
		Options optionsf=new Options();
		Options optionst=new Options();
		optionsf.add(new CheckboxOption("Folding margin",false));
		optionst.add(new CheckboxOption("Folding margin",true));
		robot.textViewSettings(optionsf);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
		finally {
			robot.textViewSettings(optionst);
		}
		
	}
	
	@Test
	public final void testSourceFoldingMarginOn() {
		robot.openFile(COMPLETE_PO_MFD);
		robot.showOutput();
		Options optionst=new Options();
		optionst.add(new CheckboxOption("Folding margin",true));
		robot.textViewSettings(optionst);
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testTabSize() {
		robot.openFile(COMPLETE_PO_MFD);
		robot.showOutput();
		Options options_a=new Options();
		Options options_b=new Options();
		options_a.add(new TextFieldOption("Tab size:","9"));
		options_b.add(new TextFieldOption("Tab size:","4"));
		robot.textViewSettings(options_a);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		} finally {
			robot.textViewSettings(options_b);
		}
	}
	
	@Test
	public final void testInsertTabs(){
		robot.openFile(COMPLETE_PO_MFD);
		robot.showOutput();
		Options options_a=new Options();
		Options options_b=new Options();
		options_a.add(new CheckboxOption("Whitespace markers",true));
		options_a.add(new RadioOption("Insert tabs"));
		options_b.add(new CheckboxOption("Whitespace markers",false));
		robot.textViewSettings(options_a);
		robot.prettyPrintXML();
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		} finally {
			robot.textViewSettings(options_b);
		}
	}
	
	@Test
	public final void testInsertSpaces(){
		robot.openFile(COMPLETE_PO_MFD);
		robot.showOutput();
		Options options_a=new Options();
		Options options_b=new Options();
		options_a.add(new CheckboxOption("Whitespace markers",true));
		options_a.add(new RadioOption("Insert spaces"));
		options_b.add(new CheckboxOption("Whitespace markers",false));
		options_b.add(new RadioOption("Insert tabs"));
		robot.textViewSettings(options_a);
		robot.prettyPrintXML();
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		} finally {
			robot.textViewSettings(options_b);
		}
	}
	
	@Test
	public final void testIndentationGuidesOff() {
		robot.openFile(COMPLETE_PO_MFD);
		robot.showOutput();
		Options optionsf=new Options();
		Options optionst=new Options();
		optionsf.add(new CheckboxOption("Indentation guides",false));
		optionst.add(new CheckboxOption("Indentation guides",true));
		robot.textViewSettings(optionsf);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
		finally {
			robot.textViewSettings(optionst);
		}
		
	}

	@Test
	public final void testIndentationGuidesOn() {
		robot.openFile(COMPLETE_PO_MFD);
		robot.showOutput();
		Options optionst=new Options();
		optionst.add(new CheckboxOption("Indentation guides",true));
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testEndOfLineMarkersOn() {
		robot.openFile(COMPLETE_PO_MFD);
		robot.showOutput();
		Options optionsf=new Options();
		Options optionst=new Options();
		optionsf.add(new CheckboxOption("End of line markers",false));
		optionst.add(new CheckboxOption("End of line markers",true));
		robot.textViewSettings(optionst);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
		finally {
			robot.textViewSettings(optionsf);
		}
		
	}

	@Test
	public final void testEndOfLineMarkersOff() {
		robot.openFile(COMPLETE_PO_MFD);
		robot.showOutput();
		Options optionst=new Options();
		optionst.add(new CheckboxOption("End of line markers",false));
		robot.textViewSettings(optionst);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testWhitespaceMarkersOn() {
		robot.openFile(COMPLETE_PO_MFD);
		robot.showOutput();
		Options optionsf=new Options();
		Options optionst=new Options();
		optionsf.add(new CheckboxOption("Whitespace markers",false));
		optionst.add(new CheckboxOption("Whitespace markers",true));
		robot.textViewSettings(optionst);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
		finally {
			robot.textViewSettings(optionsf);
		}
		
	}

	@Test
	public final void testWhitespaceMarkersOff() {
		robot.openFile(COMPLETE_PO_MFD);
		robot.showOutput();
		Options optionst=new Options();
		optionst.add(new CheckboxOption("Whitespace markers",false));
		robot.textViewSettings(optionst);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
}
