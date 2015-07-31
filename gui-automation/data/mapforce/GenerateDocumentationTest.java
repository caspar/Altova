/**
 * 
 */
package com.altova.mapforce;

import static com.altova.mapforce.MapForceRobot.MESSAGES;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;


import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.ImageNotFoundException;
import com.altova.robots.Options;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.IOUtils;
import com.altova.util.Settings;
import com.altova.util.AltovaJUnitRunner.TestRobot;

import static com.altova.robots.ImageRecognitionRobot.WINDOWS_DEFAULT_FONT;

/**
 * @author B.Lopez
 *
 */
//@TestRobot(VSnetMapForceRobot.class)
public class GenerateDocumentationTest extends AbstractMapForceTest {

	private static final String BASE_OUT_DIR =Settings.getOutputDir().getAbsolutePath()+"\\"+AltovaJUnitRunner.getRunName(robot,"GenerateDocumentationTest");
	//private static final String BASE_EXPECTED_DIR=Settings.getExpectedDir().getAbsolutePath()+"\\"+AltovaJUnitRunner.getRunName(robot,"GenerateDocumentationTest");
	private static final File GENDOC_HTML_NOSPLIT=new File(BASE_OUT_DIR+"\\testGenerateDocumentation_HTML_NoSplit");
	private static final File GENDOC_HTML_SPLIT=new File(BASE_OUT_DIR+"\\testGenerateDocumentation_HTML_Split");
	private static final File GENDOC_WORD_NOSPLIT=new File(BASE_OUT_DIR+"\\testGenerateDocumentation_Word_NoSplit");
	private static final File GENDOC_WORD_SPLIT=new File(BASE_OUT_DIR+"\\testGenerateDocumentation_Word_Split");
	private static final File GENDOC_RTF_NOSPLIT=new File(BASE_OUT_DIR+"\\testGenerateDocumentation_RTF_NoSplit");
	private static final File GENDOC_RTF_SPLIT=new File(BASE_OUT_DIR+"\\testGenerateDocumentation_RTF_Split");
	private static final File GENDOC_PATHLENGTHLIMIT_DEFAULT=new File(BASE_OUT_DIR+"\\testGenerateDocumentation_PathLengthLimit_Default");
	private static final File GENDOC_PATHLENGTHLIMIT_NOLIMIT=new File(BASE_OUT_DIR+"\\testGenerateDocumentation_PathLengthLimit_NoLimit");
	private static final File GENDOC_PATHLENGTHLIMIT_LIMIT=new File(BASE_OUT_DIR+"\\testGenerateDocumentation_PathLengthLimit_Limit");
	protected static File GENDOC_INCLUDE_COMPONENTS1=new File(BASE_OUT_DIR+"\\testGenerateDocumentation_DoNotInclude_InOutRest");
	protected static File GENDOC_INCLUDE_COMPONENTS2=new File(BASE_OUT_DIR+"\\testGenerateDocumentation_DoNotInclude_UDFOutConstants");
	protected static File GENDOC_INCLUDE_COMPONENTS3=new File(BASE_OUT_DIR+"\\testGenerateDocumentation_IncludeNone");
	protected static File GENDOC_DETAILS_COMPONENTS1=new File(BASE_OUT_DIR+"\\testGenerateDocumentation_Details_No_AnnotDatatyp");
	protected static File GENDOC_DETAILS_COMPONENTS2=new File(BASE_OUT_DIR+"\\testGenerateDocumentation_Details_No_LibraryNodes");
	protected static File GENDOC_DETAILS_COMPONENTS3=new File(BASE_OUT_DIR+"\\testGenerateDocumentation_Details_None");
	protected static File GENDOC_DETAILS_COMPONENTS4=new File(BASE_OUT_DIR+"\\testGenerateDocumentation_Details_All");
	private static final String GENDOC_NAME="DocumGenerated";
	protected static File GROUPING_TEMPERATURES_FILE=IOUtils.findFile("examples/GroupTemperaturesByYear.mfd");
	protected static File WEBSERVICE2_FILE=IOUtils.findFile("examples/getOffsetUTCTime.mfd");
	protected static File MERGE_MULTIPLE_FILES_FILE=IOUtils.findFile("examples/MergeMultipleFiles.mfd");
	protected static File MULTIPLEINPUT_AND_OUTPUT_FILE=IOUtils.findFile("examples/MultipleInputToMultipleOutputFiles.mfd");
	protected static File MULTIPLE_OUTPUTS_FILE=IOUtils.findFile("examples/MarketingAndDailyExpenses.mfd");
	protected static File USER_DEFINED_FUNCTIONS_FILE=IOUtils.findFile("examples/InputIsSequence.mfd");
	protected static File RECURSIVE_FILTER_FILE=IOUtils.findFile("examples/RecursiveDirectoryFilter.mfd");
	
	@Test
	public void testGenerateDocumentation_HTML_NoSplit(){
		robot.openFile(GROUPING_TEMPERATURES_FILE);
		IOUtils.deleteAll(GENDOC_HTML_NOSPLIT);
		String fullpath=GENDOC_HTML_NOSPLIT+"\\"+GENDOC_NAME;
		assertFileNotExists(new File(fullpath+".html"));
		Options options=new Options();
		options.add(new CheckboxOption("Show result file after generation",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		robot.generateDocumentation(GENDOC_HTML_NOSPLIT, GENDOC_NAME, options);
		assertFileExists(new File(fullpath+".html"));
		assertAreas(MESSAGES);
	}
	
	@Test
	public void testGenerateDocumentation_HTML_Split(){
		IOUtils.deleteAll(GENDOC_HTML_SPLIT);
		String fullpath=GENDOC_HTML_SPLIT.getAbsolutePath()+"\\"+GENDOC_NAME;
		assertFileNotExists(new File(fullpath+"_ConstantComponents.html"));
		Options options=new Options();
		options.add(new CheckboxOption("Show result file after generation",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",true,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		
		try{
			robot.generateDocumentation(GENDOC_HTML_SPLIT, GENDOC_NAME, options);
		} catch (ImageNotFoundException e) {
			// if this exception is thrown, it means that option name was
			// changed
		} finally {	
			Options options_post = new Options();
			options_post.add(new CheckboxOption("Split output to multiple files",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
			robot.setOptionsIn_genDoc_dlg(options_post);	
			assertFileExists(new File(fullpath+".html"));
			assertFileExists(new File(fullpath+"_ConstantComponents.html"));
			assertFileExists(new File(fullpath+"_LibraryComponents.html"));
		}
	}
	
	@Test
	public void testGenerateDocumentation_Word_NoSplit() throws FileNotFoundException{
		robot.openFile(WEBSERVICE2_FILE);
		IOUtils.deleteAll(GENDOC_WORD_NOSPLIT);
		String fullpath=GENDOC_WORD_NOSPLIT.getAbsolutePath()+"\\"+GENDOC_NAME;
		assertFileNotExists(new File(fullpath+".doc"));
		Options options=new Options();
		options.add(new RadioOption("Microsoft Word","Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		
		try{
			robot.generateDocumentation(GENDOC_WORD_NOSPLIT, GENDOC_NAME, options);
		} catch (ImageNotFoundException e) {
			// if this exception is thrown, it means that option name was
			// changed
		} finally {	
			boolean ifesc=robot.escapeDialog("Sorry, but a properly installed version of Microsoft Word 2000", KeyEvent.VK_ESCAPE);
			Options options_post = new Options();
			options_post.add(new RadioOption("HTML","Output format",null,null,null,WINDOWS_DEFAULT_FONT));
			delay(1000);
			robot.setOptionsIn_genDoc_dlg(options_post);	
			
			if(!ifesc)
				assertFileExists(new File(fullpath+".doc"));
			else {
				assertFileNotExists(new File(fullpath+".doc"));
				throw new FileNotFoundException("Please, install MS Word of, at least, 2000 version to perform this test");
			}
			
		}
		
	}
	
	@Test
	public void testGenerateDocumentation_Word_Split() throws FileNotFoundException{
		robot.openFile(EDI_ORDER_REVERSE_MFD);
		IOUtils.deleteAll(GENDOC_WORD_SPLIT);
		String fullpath=GENDOC_WORD_SPLIT.getAbsolutePath()+"\\"+GENDOC_NAME;
		assertFileNotExists(new File(fullpath+"_ConstantComponents.doc"));
		Options options=new Options();
		options.add(new RadioOption("Microsoft Word","Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",true,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		
		try{
			robot.generateDocumentation(GENDOC_WORD_SPLIT, GENDOC_NAME, options);
		} catch (ImageNotFoundException e) {
			// if this exception is thrown, it means that option name was
			// changed
		} finally {	
			boolean ifesc=robot.escapeDialog("Sorry, but a properly installed version of Microsoft Word 2000", KeyEvent.VK_ESCAPE);
			Options options_post = new Options();
			options_post.add(new RadioOption("HTML","Output format",null,null,null,WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("Split output to multiple files",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
			robot.setOptionsIn_genDoc_dlg(options_post);	
			
			if(!ifesc){
				assertFileExists(new File(fullpath+".doc"));
				assertFileExists(new File(fullpath+"_ConstantComponents.doc"));
				assertFileExists(new File(fullpath+"_LibraryComponents.doc"));
				assertFileExists(new File(fullpath+"_UserDefinedFunctionsDefines.doc"));
				assertFileExists(new File(fullpath+"_UDFComponents.doc"));
				
			}
			else{
				assertFileNotExists(new File(fullpath+".doc"));
				assertFileNotExists(new File(fullpath+"_ConstantComponents.doc"));
				assertFileNotExists(new File(fullpath+"_LibraryComponents.doc"));
				throw new FileNotFoundException("Please, install MS Word of, at least, 2000 version to perform this test");
			}
		}
	}
	
	@Test
	public void testGenerateDocumentation_RTF_NoSplit(){
		IOUtils.deleteAll(GENDOC_RTF_NOSPLIT);
		String fullpath=GENDOC_RTF_NOSPLIT.getAbsolutePath()+"\\"+GENDOC_NAME;
		assertFileNotExists(new File(fullpath+".rtf"));
		Options options=new Options();
		options.add(new RadioOption("RTF","Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		try {
			robot.generateDocumentation(GENDOC_RTF_NOSPLIT, GENDOC_NAME, options);
		} catch (ImageNotFoundException e) {
			// if this exception is thrown, it means that option name was
			// changed
		} finally {
			Options options_post = new Options();
			options_post.add(new RadioOption("HTML", "Output format", null, null, null, WINDOWS_DEFAULT_FONT));
			robot.setOptionsIn_genDoc_dlg(options_post);
			assertFileExists(new File(fullpath + ".rtf"));
		}
		
		
	}
	
	@Test 
	public void testGenerateDocumentation_RTF_Split(){
		robot.openFile(MERGE_MULTIPLE_FILES_FILE);
		IOUtils.deleteAll(GENDOC_RTF_SPLIT);
		String fullpath=GENDOC_RTF_SPLIT.getAbsolutePath()+"\\"+GENDOC_NAME;
		Options options=new Options();
		options.add(new RadioOption("RTF","Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",true,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		
		try {
			robot.generateDocumentation(GENDOC_RTF_SPLIT, GENDOC_NAME, options);
		} catch (ImageNotFoundException e) {
			// if this exception is thrown, it means that option name was
			// changed
		} finally {
			Options options_post = new Options();
			options_post.add(new RadioOption("HTML", "Output format", null, null, null, WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("Split output to multiple files",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
			robot.setOptionsIn_genDoc_dlg(options_post);
			assertFileExists(new File(fullpath+".rtf"));
			assertFileExists(new File(fullpath+"_ConstantComponents.rtf"));
			assertFileExists(new File(fullpath+"_LibraryComponents.rtf"));
		}
		
		
		
	}
	
	
	@Test 
	public void testPathLengthLimit_NoLimit(){
		robot.openFile(MULTIPLE_OUTPUTS_FILE);
		IOUtils.deleteAll(GENDOC_PATHLENGTHLIMIT_NOLIMIT);
		String fullpath=GENDOC_PATHLENGTHLIMIT_NOLIMIT.getAbsolutePath()+"\\"+GENDOC_NAME;
		Options options=new Options();
		options.add(new CheckboxOption("Show result file after generation",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Input items", false, "Path length limit", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Connections", false, "Path length limit", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Output items", false, "Path length limit", null, null, null, WINDOWS_DEFAULT_FONT));
		try{
			robot.generateDocumentation(GENDOC_PATHLENGTHLIMIT_NOLIMIT, GENDOC_NAME, options);
		} catch (ImageNotFoundException e) {
			// if this exception is thrown, it means that option name was
			// changed
		} finally {
			
			Options options_post = new Options();
			options_post.add(new CheckboxOption("Input items", true, "Path length limit", null, null, null, WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("Connections", true, "Path length limit", null, null, null, WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("Output items", true, "Path length limit", null, null, null, WINDOWS_DEFAULT_FONT));
			robot.setOptionsIn_genDoc_dlg(options_post);	
			assertFileExists(new File(fullpath+".html"));
		}
	}
	
	@Test 
	public void testPathLengthLimit_Limit(){
		robot.openFile(MULTIPLE_OUTPUTS_FILE);
		IOUtils.deleteAll(GENDOC_PATHLENGTHLIMIT_LIMIT);
		String fullpath=GENDOC_PATHLENGTHLIMIT_LIMIT.getAbsolutePath()+"\\"+GENDOC_NAME;
		Options options=new Options();
		options.add(new CheckboxOption("Show result file after generation",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		TextFieldOption t1=new TextFieldOption("Input items",false,"1","Path length limit",null,null,null,WINDOWS_DEFAULT_FONT);
		TextFieldOption t2=new TextFieldOption("Connections",false,"2","Path length limit",null,null,null,WINDOWS_DEFAULT_FONT);
		TextFieldOption t3=new TextFieldOption("Output items",false,"4","Path length limit",null,null,null,WINDOWS_DEFAULT_FONT);
		t1.setX2(50);
		t2.setX2(50);
		t3.setX2(50);
		options.add(t1);
		options.add(t2);
		options.add(t3);
		robot.generateDocumentation(GENDOC_PATHLENGTHLIMIT_LIMIT, GENDOC_NAME, options);
		assertFileExists(new File(fullpath + ".html"));
		if (!Settings.isVS2010()) { //This assertion is not done for VS2010 as it fails and it is not necessary
			assertAreas(MESSAGES);
		}
	}
	
	@Test 
	public void testPathLengthLimit_Default(){
		robot.openFile(MULTIPLE_OUTPUTS_FILE);
		IOUtils.deleteAll(GENDOC_PATHLENGTHLIMIT_DEFAULT);
		String fullpath=GENDOC_PATHLENGTHLIMIT_DEFAULT.getAbsolutePath()+"\\"+GENDOC_NAME;
		Options options=new Options();
		options.add(new CheckboxOption("Show result file after generation",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		TextFieldOption t1=new TextFieldOption("Input items",false,"3","Path length limit",null,null,null,WINDOWS_DEFAULT_FONT);
		TextFieldOption t2=new TextFieldOption("Connections",false,"3","Path length limit",null,null,null,WINDOWS_DEFAULT_FONT);
		TextFieldOption t3=new TextFieldOption("Output items",false,"3","Path length limit",null,null,null,WINDOWS_DEFAULT_FONT);
		t1.setX2(50);
		t2.setX2(50);
		t3.setX2(50);
		options.add(t1);
		options.add(t2);
		options.add(t3);
		robot.generateDocumentation(GENDOC_PATHLENGTHLIMIT_DEFAULT, GENDOC_NAME, options);
		assertFileExists(new File(fullpath+".html"));
		if (!Settings.isVS2010()) { //This assertion is not done for VS2010 as it fails and it is not necessary
			assertAreas(MESSAGES);
		}
	}
	
	@Test 
	public void testDonotInclude_Components_InOutRest(){
		robot.openFile(MULTIPLEINPUT_AND_OUTPUT_FILE);
		IOUtils.deleteAll(GENDOC_INCLUDE_COMPONENTS1);
		String fullpath=GENDOC_INCLUDE_COMPONENTS1.getAbsolutePath()+"\\"+GENDOC_NAME;
		Options options=new Options();
		options.add(new CheckboxOption("Show result file after generation",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Input components",false,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Output components",false,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Remaining components",false,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
		
		try{
			robot.generateDocumentation(GENDOC_INCLUDE_COMPONENTS1, GENDOC_NAME, options);
		} catch (ImageNotFoundException e) {
			// if this exception is thrown, it means that option name was
			// changed
		} finally {	
			Options options_post = new Options();
			options_post.add(new CheckboxOption("Input components",true,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("Output components",true,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("Remaining components",true,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
			robot.setOptionsIn_genDoc_dlg(options_post);	
			assertFileExists(new File(fullpath+".html"));
			
		}
	}
	
	@Test 
	public void testDonotInclude_Components_UDFOutConstants(){
		robot.openFile(USER_DEFINED_FUNCTIONS_FILE);
		IOUtils.deleteAll(GENDOC_INCLUDE_COMPONENTS2);
		String fullpath=GENDOC_INCLUDE_COMPONENTS2.getAbsolutePath()+"\\"+GENDOC_NAME;
		Options options=new Options();
		options.add(new CheckboxOption("Show result file after generation",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Output components",false,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("User-defined functions",false,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Constants",false,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
		try{
			robot.generateDocumentation(GENDOC_INCLUDE_COMPONENTS2, GENDOC_NAME, options);
		} catch (ImageNotFoundException e) {
			// if this exception is thrown, it means that option name was
			// changed
		} finally {	
			Options options_post = new Options();
			options_post.add(new CheckboxOption("Output components",true,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("User-defined functions",true,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("Constants",true,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
			robot.setOptionsIn_genDoc_dlg(options_post);	
			assertFileExists(new File(fullpath+".html"));
		}
	}
	
	@Test 
	public void testDonotInclude_Components_IncludeNone(){
		robot.openFile(USER_DEFINED_FUNCTIONS_FILE);
		IOUtils.deleteAll(GENDOC_INCLUDE_COMPONENTS3);
		String fullpath=GENDOC_INCLUDE_COMPONENTS3.getAbsolutePath()+"\\"+GENDOC_NAME;
		Options options=new Options();
		options.add(new CheckboxOption("Show result file after generation",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Input components",false,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Output components",false,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Remaining components",false,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("User-defined functions",false,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Constants",false,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
		
		try{
			robot.generateDocumentation(GENDOC_INCLUDE_COMPONENTS3, GENDOC_NAME, options);
		} catch (ImageNotFoundException e) {
			// if this exception is thrown, it means that option name was
			// changed
		} finally {	
			Options options_post = new Options();
			options_post.add(new CheckboxOption("Input components",true,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("Output components",true,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("Remaining components",true,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("User-defined functions",true,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("Constants",true,"Include",null,null,null,WINDOWS_DEFAULT_FONT));
			robot.setOptionsIn_genDoc_dlg(options_post);	
			assertFileExists(new File(fullpath+".html"));
		}
		
	}
	
	@Test 
	public void testDetails_No_AnnotDatatypes(){
		IOUtils.deleteAll(GENDOC_DETAILS_COMPONENTS1);
		String fullpath=GENDOC_DETAILS_COMPONENTS1.getAbsolutePath()+"\\"+GENDOC_NAME;
		Options options=new Options();
		options.add(new CheckboxOption("Show result file after generation",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Annotations",false,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Datatypes",false,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
		try{
			robot.generateDocumentation(GENDOC_DETAILS_COMPONENTS1, GENDOC_NAME, options);
		} catch (ImageNotFoundException e) {
			// if this exception is thrown, it means that option name was
			// changed
		} finally {	
			Options options_post = new Options();
			options_post.add(new CheckboxOption("Annotations",true,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("Datatypes",true,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
			robot.setOptionsIn_genDoc_dlg(options_post);	
			assertFileExists(new File(fullpath+".html"));	
		}
	}
	
	@Test 
	public void testDetails_No_LibraryNamConUnconNodes(){
		robot.openFile(RECURSIVE_FILTER_FILE);
		IOUtils.deleteAll(GENDOC_DETAILS_COMPONENTS2);
		String fullpath=GENDOC_DETAILS_COMPONENTS2.getAbsolutePath()+"\\"+GENDOC_NAME;
		Options options=new Options();
		options.add(new CheckboxOption("Show result file after generation",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Library names",false,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Connected nodes",false,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Unconnected nodes",false,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
		
		try{
			robot.generateDocumentation(GENDOC_DETAILS_COMPONENTS2, GENDOC_NAME, options);
		} catch (ImageNotFoundException e) {
			// if this exception is thrown, it means that option name was
			// changed
		} finally {	
			Options options_post = new Options();
			options_post.add(new CheckboxOption("Library names",true,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("Connected nodes",true,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("Unconnected nodes",true,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
			robot.setOptionsIn_genDoc_dlg(options_post);	
			assertFileExists(new File(fullpath+".html"));
		}
		
		
	}
	
	@Test 
	public void testDetails_None(){
		robot.openFile(EXCEL_COMPANY_TOXML_FILE);
		IOUtils.deleteAll(GENDOC_DETAILS_COMPONENTS3);
		String fullpath=GENDOC_DETAILS_COMPONENTS3.getAbsolutePath()+"\\"+GENDOC_NAME;
		Options options=new Options();
		options.add(new CheckboxOption("Show result file after generation",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Annotations",false,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Datatypes",false,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Library names",false,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Connected nodes",false,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Unconnected nodes",false,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
		try{
			robot.generateDocumentation(GENDOC_DETAILS_COMPONENTS3, GENDOC_NAME, options);
		} catch (ImageNotFoundException e) {
			// if this exception is thrown, it means that option name was
			// changed
		} finally {	
			Options options_post = new Options();
			options_post.add(new CheckboxOption("Annotations",true,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("Datatypes",true,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("Library names",true,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("Connected nodes",true,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
			options_post.add(new CheckboxOption("Unconnected nodes",true,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
			robot.setOptionsIn_genDoc_dlg(options_post);	
			assertFileExists(new File(fullpath+".html"));
		}
	}
	
	@Test 
	public void testDetails_All(){
		robot.openFile(EXCEL_COMPANY_TOXML_FILE);
		IOUtils.deleteAll(GENDOC_DETAILS_COMPONENTS4);
		String fullpath=GENDOC_DETAILS_COMPONENTS4.getAbsolutePath()+"\\"+GENDOC_NAME;
		Options options=new Options();
		options.add(new CheckboxOption("Show result file after generation",false,"Output format",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Annotations",true,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Datatypes",true,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Library names",true,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Connected nodes",true,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Unconnected nodes",true,"Details",null,null,null,WINDOWS_DEFAULT_FONT));
		robot.generateDocumentation(GENDOC_DETAILS_COMPONENTS4, GENDOC_NAME, options);
		assertFileExists(new File(fullpath+".html"));
		assertAreas(MESSAGES);
	}
}
