package com.altova.diffdog;


import org.junit.Test;
import java.awt.Rectangle;
import java.io.File;
import static java.awt.event.KeyEvent.*;

import com.altova.robots.CheckboxOption;
import com.altova.robots.ImageUtils;
import com.altova.robots.RadioOption;
import com.altova.util.IOUtils;
import static com.altova.robots.SnapshotArea.CommonArea.*;



public class SaveLoadComparisonFilesTest extends AbstractDiffDogTest{

	private static final File ATTR1=IOUtils.findFile("examples/LeftSide/attr1.xml");
	private static final File ATTR2=IOUtils.findFile("examples/RightSide/attr2.xml");
	
	private static final File TEXT_WHITESPACE1 = IOUtils.findFile("examples/LeftSide/WordComparison/Text_Whitespace.doc");
	private static final File TEXT_WHITESPACE2 = IOUtils.findFile("examples/RightSide/WordComparison/Text_Whitespace.doc");
	
	private static final String DIRDIFF1 = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\LeftSide\\DirDiff";
	private static final String DIRDIFF2 = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\RightSide\\DirDiff";
	
	private static final String DIRDIFF_few_1 = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\LeftSide\\DirDiff_2";
	private static final String DIRDIFF_few_2 = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\RightSide\\DirDiff_2";
	
	private static final String DIRDIFF_WORD = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\LeftSide\\WordComparison";
	private static final String DIRDIFF2_WORD = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\RightSide\\WordComparison";
	
	private static final String tempCompFile = "c:\\temp\\debug\\file.filedif";
	private static final String tempDirCompFile = "c:\\temp\\debug\\file.dirdif";
	private static final File NOEXITSTINGDIR =IOUtils.findFile("examples/LeftSide/ComparisonFiles/NotExistingDirectories.dirdif");
	private static final File NOEXITSTINFile =IOUtils.findFile("examples/LeftSide/ComparisonFiles/NotExistingFile.filedif");
	private static final File SchemaWithFileDifExt =IOUtils.findFile("examples/LeftSide/ComparisonFiles/SchemaWithFileDifExt.filedif");
	
	private static final String attr1IP = "http://10.100.63.143/webdav/krb/diffdog/LeftSide/attr1.xml"; 
	private static final String attr1DNS = "http://qa-w2k3/webdav/krb/diffdog/LeftSide/attr1.xml";
	
	private static final String attr2IP = "http://10.100.63.143/webdav/krb/diffdog/RightSide/attr2.xml"; 
	private static final String attr2DNS = "http://qa-w2k3/webdav/krb/diffdog/RightSide/attr2.xml";
	
	private static final String leftDirIP = "http://10.100.63.143/webdav/krb/diffdog/LeftSide/DirDiff_2"; 
	private static final String leftDirDNS = "http://qa-w2k3/webdav/krb/diffdog/LeftSide/DirDiff_2";
	
	private static final String rightDirIP = "http://10.100.63.143/webdav/krb/diffdog/RightSide/DirDiff_2"; 
	private static final String rightDirDNS = "http://qa-w2k3/webdav/krb/diffdog/RightSide/DirDiff_2";
	
	String http_auth ="http://qa-w2k3/test_auth/krb/diffdog/";
	String	ftp = "ftp://qa-w2k3/krb/diffdog/";
	String	ftp_auth = "ftp://qa-w2k3/krb/";
	
	@Test
	public void testSaveCurrentComparisonFile(){
		robot.compareFiles(ATTR1, ATTR2);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testSaveCurrentDirecotryComparison(){
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testSaveCurrentWordComparison(){
		robot.compareWordDocuments(TEXT_WHITESPACE1, TEXT_WHITESPACE2);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		
		//2 lines after, because there are some problems with office activation
		delay(15000); 
		robot.escapeDialog("Microsoft Office Activation Wizard", VK_C);
		
		assertAreas(MF_MAIN_WINDOW);
	}

	
	@Test
	public void testOpenFilediffWithNoExistingFile(){
		robot.openComparisonFile(NOEXITSTINFile);
		assertAreas(TOP_WINDOW);
		robot.escapeDialog("Cannot open file", VK_ESCAPE);
		delay(250);
		robot.escapeDialog("Cannot open file", VK_ESCAPE);
	}
	
	@Test
	public void testOpenDirdiffWithNoExistingDir(){
		robot.openComparisonFile(NOEXITSTINGDIR);
		assertAreas(TOP_WINDOW);
		robot.escapeDialog("Cannot open directory", VK_ESCAPE);
		delay(250);
		robot.escapeDialog("Cannot open directory", VK_ESCAPE);
	}
	
	@Test
	public void testOpenSchemaFileAsFiledif(){
		robot.openComparisonFile(SchemaWithFileDifExt);
		assertAreas(TOP_WINDOW);
		robot.escapeDialog("Failed to load comparison file", VK_ESCAPE);
	}
	
	/*
	 * Checking: 
	 * 		Show/Hide equal
	 * 		Show/Hide left newer
	 * 		Show/Hide right newer
	 * 		Show/Hide left only
	 * 		Show/Hide right only
	 * 		Show/Hide not comparable
	 * 		Include subdirectories
	 * 		show/Hide Empty directories
	 */
	@Test
	public void testDirdiffCompariosOptionsAllOff(){
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		robot.setDirectoryComparPanel(0, 0, 0, 0,0,0,0,0);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		assertAreas(DIFF_DOG_UP_WINDOW);
	}
	
	@Test
	public void testDirdiffCompariosOptionsAllOn(){
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		robot.setDirectoryComparPanel(1, 1, 1, 1,1,1,1,1);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		assertAreas(DIFF_DOG_UP_WINDOW);
	}
	
	/************************************************************************
	 *						TEXT OPTIONS									*
	 *	Default is:															*
	 * 	Show differencess - on												*
	 * 	Whitespace - Normalize												*
	 * 	Case sensitivity - off												*
	 * 	Ignore blank lines on												*
	 *																		*
	 ************************************************************************/
	
	/*
	 * Test below
	 * show differencess - off
	 * whitespace Compare as is
	 * CaseSensitivity - on
	 * Ignore blank lines - off
	 */
	
	@Test
	public void testTextComparisonOptions1(){
		robot.compareFiles(ATTR1, ATTR2);
		robot.setCompareAsTXT();
		
		robot.openComparisionOptions("Text");
		robot.setDiffDogOptions(new CheckboxOption("Show differences within lines",false),
				new CheckboxOption("Ignore case",true),
				new CheckboxOption("Ignore blank lines",false),
				new RadioOption("Compare as is")
		);
		robot.okButton();
		robot.escapeDialog("No differences found", VK_ESCAPE);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		robot.openComparisionOptions("Text");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	
	/*
	 * Test below
	 * show differencess - on
	 * whitespace Strip all
	 * CaseSensitivity - off
	 * Ignore blank lines - on
	 */
	
	@Test
	public void testTextComparisonOptions2(){
		robot.compareFiles(ATTR1, ATTR2);
		robot.setCompareAsTXT();
		
		robot.openComparisionOptions("Text");
		robot.setDiffDogOptions(new CheckboxOption("Show differences within lines",true),
				new CheckboxOption("Ignore case",false),
				new CheckboxOption("Ignore blank lines",true),
				new RadioOption("Strip all")
		);
		robot.okButton();
		robot.escapeDialog("No differences found", VK_ESCAPE);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		robot.openComparisionOptions("Text");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	/*
	 * Test below
	 * show differencess - on
	 * whitespace Normalize
	 * CaseSensitivity - off
	 * Ignore blank lines - on
	 */
	
	@Test
	public void testTextComparisonOptions3(){
		robot.compareFiles(ATTR1, ATTR2);
		robot.setCompareAsTXT();
		
		robot.openComparisionOptions("Text");
		robot.setDiffDogOptions(new CheckboxOption("Show differences within lines",true),
				new CheckboxOption("Ignore case",false),
				new CheckboxOption("Ignore blank lines",true),
				new RadioOption("Normalize")
		);
		robot.okButton();
		robot.escapeDialog("No differences found", VK_ESCAPE);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		robot.openComparisionOptions("Text");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	
	
	/************************************************************************
	 *						XML OPTIONS										*
	 *	Default is:															*
	 * 	Detailed differening - on
	 * Whitespace - Normalize
	 *  Ignore namaspaces - off
	 *  Ignore prefixes - on
	 *  Resolve entities - on												*
	 * 	Ignore text - off													*
	 * 	Ignore node depth - off												*
	 * 	Ignore blank lines on
	 * Ignore case - off
	 * 			Do not ignore case - disabled								*
	 * Ignore order of child - off
	 * Ignore orfer of attributes - on
	 * Ignore node types:													*
	 *  Attr - off
	 *  CData - off
	 *  Comments - on
	 *  Processing - on
	 *  DOCTYPE - off
	 *  XML declaration - off
	 *  Filtering  - No filtering (diff test case
	 ************************************************************************/
	
	
	/*
	 * Test below
	 * Detailed differencing - off
	 * Whitespace - Compare as is
	 * Ignore namespace - on
	 * Ignore prefixes - off
	 * Resolve entities - off
	 * Ignore text - on
	 * Ignore node depth - on
	 * Ignore case - on
	 * 		Do not ignore case in node names - on
	 * Ignore order of child nodes - off
	 * Ignore order of attributes - off
	 * Attributes - on
	 * CD data - on
	 * Comments - off
	 * Processing instruction - off
	 * DOCTYPE - on
	 * XML declaration - off
	 * 
	 */
	
	@Test
	public void testXMLComparisonOptions1(){
		robot.compareFiles(ATTR1, ATTR2);
		robot.setCompareAsXML();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(
				new CheckboxOption("Detailed differencing",false),
				new RadioOption("Compare as is"),
				new CheckboxOption("Ignore namespace",true),
				new CheckboxOption("Ignore prefixes",false),
				new CheckboxOption("Resolve entities",false),
				new CheckboxOption("Ignore text",true),
				new CheckboxOption("Ignore node depth",true),
				new CheckboxOption("Ignore case",true),
				new CheckboxOption("Ignore order of attributes",false),
				new CheckboxOption("Attributes",true),
				new CheckboxOption("CData",true),
				new CheckboxOption("Comments",false),
				new CheckboxOption("Processing instruction",false),
				new CheckboxOption("DOCTYPE",true),
				new CheckboxOption("XML declaration",false)
				
		);
		robot.okButton();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		robot.openComparisionOptions("XML");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	
	/*
	 * Test below
	 * Detailed differencing - on
	 * Whitespace - Strip all
	 * Ignore namespace - off
	 * Ignore prefixes - on
	 * Resolve entities - on
	 * Ignore text - off
	 * Ignore node depth - off
	 * Ignore case - on
	 * 		Do not ignore case in node names - off
	 * Ignore order of child nodes - on
	 * Ignore order of attributes - on
	 * Attributes - off
	 * CD data - off
	 * Comments - on
	 * Processing instruction - on
	 * DOCTYPE - of
	 * XML declaration - on
	 * 
	 */
	
	@Test
	public void testXMLComparisonOptions2(){
		robot.compareFiles(ATTR1, ATTR2);
		robot.setCompareAsXML();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(
				new CheckboxOption("Detailed differencing",true),
				new RadioOption("Strip all"),
				new CheckboxOption("Ignore namespace",false),
				new CheckboxOption("Ignore prefixes",true),
				new CheckboxOption("Resolve entities",true),
				new CheckboxOption("Ignore text",false),
				new CheckboxOption("Ignore node depth",false),
				new CheckboxOption("Ignore case",true),
				new CheckboxOption("Do not ignore case in node names",false),
				new CheckboxOption("Ignore order of child nodes",true),
				new CheckboxOption("Ignore order of attributes",false),
				new CheckboxOption("Attributes",false),
				new CheckboxOption("CData",false),
				new CheckboxOption("Comments",true),
				new CheckboxOption("Processing instruction",true),
				new CheckboxOption("DOCTYPE",false),
				new CheckboxOption("XML declaration",true)
				
		);
		robot.okButton();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		robot.openComparisionOptions("XML");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}	
	
	
	
	/*
	 * Test below
	 * Default exept:
	 * 
	 * Ignore order of child node - on
	 * All attributes - on
	 * Add element text as comparison criteria - on
	 * 
	 */
	
	@Test
	public void testXMLComparisonOptions3(){
		robot.compareFiles(ATTR1, ATTR2);
		robot.setCompareAsXML();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(
				new CheckboxOption("Ignore order of child nodes",true),
				new CheckboxOption("Add element text as comparison criteria",true),
				new RadioOption("All attributes")
		);
		robot.okButton();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		robot.openComparisionOptions("XML");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}	
	
	/*
	 * Test below
	 * Default exept:
	 * 
	 * Ignore order of child node - on
	 * Specific attributes
	 * Add element text as comparison criteria - off
	 * 
	 */
	
	@Test
	public void testXMLComparisonOptions4(){
		robot.compareFiles(ATTR1, ATTR2);
		robot.setCompareAsXML();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(
				new CheckboxOption(" Ignore order of child nodes",true),
				new CheckboxOption(" Add element text as comparison criteria",false),
				new RadioOption("Specific attributes")
		);
		//Add new group will apear only if no group exists, so if exists we just select current one
		try{
		robot.addNewAttributeGroup("group1","c");
		}catch (Exception e) {}
		robot.okButton();
		delay(500);
		robot.okButton();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		robot.openComparisionOptions("XML");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}	
	
	/*
	 * Test below
	 * Default options
	 * 
	 */
	
	@Test
	public void testXMLComparisonOptions5(){
		robot.compareFiles(ATTR1, ATTR2);
		robot.setCompareAsXML();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(
				new CheckboxOption("Ignore order of child nodes",false),
				new RadioOption(" None")
		);
		robot.setDiffDogOptions(
		new CheckboxOption("Ignore order of attributes",true));
		robot.okButton();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		robot.openComparisionOptions("XML");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}	
	
	/************************************************************************
	 *						WORD OPTIONS - File 							*
	 *	Default is:															*
	 * 	Text - Sentence														*
	 * 	Whitespace - Compare as is											*	
	 * Show differences within lines - on									*
	 * 	Ignore case - off   												*
	 * 	Ignore blank lines off												*
	 *	Format - all off													*																	*
	 ************************************************************************/
	
	/*
	 * 	Whitespace - Normalize	
	 * Show differences within lines - off								
	 * 	Ignore case - on   												
	 * 	Ignore blank lines - on											
	 *	Format - all on	
	 */
	@Test
	public void testfileDifWordComparisonOptions1(){
		robot.compareWordDocuments(TEXT_WHITESPACE1, TEXT_WHITESPACE2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(new CheckboxOption("Show differences within lines",false),
				new CheckboxOption("Ignore case",true),
				new CheckboxOption("Ignore blank lines",true),
				new RadioOption("Normalize"),
				new RadioOption("Paragraph"),
				new CheckboxOption("Bold",true),
				new CheckboxOption("Italic",true),
				new CheckboxOption("Underline",true),
				new CheckboxOption("Font Name",true),
				new CheckboxOption("Font Size",true),
				new CheckboxOption("Color",true)
		);
		robot.okButton();
		robot.escapeDialog("No differences found", VK_ESCAPE);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		//2 lines after, because there are some problems with office activation
		delay(15000); 
		robot.escapeDialog("Microsoft Office Activation Wizard", VK_C);
		delay(1000);
		robot.openComparisionOptions("Word");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	@Test
	public void testfileDifWordComparisonOptions2(){
		robot.compareWordDocuments(TEXT_WHITESPACE1, TEXT_WHITESPACE2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(new CheckboxOption("Show differences within lines",true),
				new CheckboxOption("Ignore case",false),
				new CheckboxOption("Ignore blank lines",false),
				new RadioOption("Strip all"),
				new RadioOption("Sentence"),
				new CheckboxOption("Bold",false),
				new CheckboxOption("Italic",false),
				new CheckboxOption("Underline",false),
				new CheckboxOption("Font Name",false),
				new CheckboxOption("Font Size",false),
				new CheckboxOption("Color",false)
		);
		robot.okButton();
		robot.escapeDialog("No differences found", VK_ESCAPE);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		//2 lines after, because there are some problems with office activation
		delay(15000); 
		robot.escapeDialog("Microsoft Office Activation Wizard", VK_C);
		delay(5000);
		robot.openComparisionOptions("Word");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	
	@Test
	public void testfileDifWordComparisonOptions3(){
		robot.compareWordDocuments(TEXT_WHITESPACE1, TEXT_WHITESPACE2);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(
				new RadioOption("Compare as is")
		);
		robot.okButton();
		robot.escapeDialog("No differences found", VK_ESCAPE);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		//2 lines after, because there are some problems with office activation
		delay(15000); 
		robot.escapeDialog("Microsoft Office Activation Wizard", VK_C);
		delay(5000);
		robot.openComparisionOptions("Word");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	
	/************************************************************************
	 *						TEXT OPTIONS - Direcotry									*
	 *	Default is:															*
	 * 	Show differencess - on												*
	 * 	Whitespace - Normalize												*
	 * 	Case sensitivity - off												*
	 * 	Ignore blank lines on												*
	 *																		*
	 ************************************************************************/
	
	/*
	 * Test below
	 * show differencess - off
	 * whitespace Compare as is
	 * CaseSensitivity - on
	 * Ignore blank lines - off
	 */
	
	@Test
	public void testTextDirComparisonOptions1(){
		robot.compare2Directories(DIRDIFF_few_1, DIRDIFF_few_2);
		robot.setShowFilesInZip(false);
		robot.setQuickComparison(false);
		delay(500);
		robot.setCompareAsTXT();
		
		robot.openComparisionOptions("Text");
		robot.setDiffDogOptions(new CheckboxOption("Show differences within lines",false),
				new CheckboxOption("Ignore case",true),
				new CheckboxOption("Ignore blank lines",false),
				new RadioOption("Compare as is")
		);
		robot.okButton();
		robot.escapeDialog("No differences found", VK_ESCAPE);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		robot.openComparisionOptions("Text");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	
	/*
	 * Test below
	 * show differencess - on
	 * whitespace Strip all
	 * CaseSensitivity - off
	 * Ignore blank lines - on
	 */
	
	@Test
	public void testTextDirComparisonOptions2(){
		robot.compare2Directories(DIRDIFF_few_1, DIRDIFF_few_2);
		robot.setShowFilesInZip(false);
		robot.setQuickComparison(false);
		robot.setCompareAsTXT();
		robot.openComparisionOptions("Text");
		robot.setDiffDogOptions(new CheckboxOption("Show differences within lines",true),
				new CheckboxOption("Ignore case",false),
				new CheckboxOption("Ignore blank lines",true),
				new RadioOption("Strip all")
		);
		robot.okButton();
		robot.escapeDialog("No differences found", VK_ESCAPE);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		robot.openComparisionOptions("Text");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	/*
	 * Test below
	 * show differencess - on
	 * whitespace Normalize
	 * CaseSensitivity - off
	 * Ignore blank lines - on
	 */
	
	@Test
	public void testTextDirComparisonOptions3(){
		robot.compare2Directories(DIRDIFF_few_1, DIRDIFF_few_2);
		robot.setShowFilesInZip(false);
		robot.setQuickComparison(false);
		robot.setCompareAsTXT();
		
		robot.openComparisionOptions("Text");
		robot.setDiffDogOptions(new CheckboxOption("Show differences within lines",true),
				new CheckboxOption("Ignore case",false),
				new CheckboxOption("Ignore blank lines",true),
				new RadioOption("Normalize")
		);
		robot.okButton();
		robot.escapeDialog("No differences found", VK_ESCAPE);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		robot.openComparisionOptions("Text");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	
	

	
	/************************************************************************
	 *						XML OPTIONS		Directory						*
	 *	Default is:															*
	 * 	Detailed differening - on
	 * Whitespace - Normalize
	 *  Ignore namaspaces - off
	 *  Ignore prefixes - on
	 *  Resolve entities - on												*
	 * 	Ignore text - off													*
	 * 	Ignore node depth - off												*
	 * 	Ignore blank lines on
	 * Ignore case - off
	 * 			Do not ignore case - disabled								*
	 * Ignore order of child - off
	 * Ignore orfer of attributes - on
	 * Ignore node types:													*
	 *  Attr - off
	 *  CData - off
	 *  Comments - on
	 *  Processing - on
	 *  DOCTYPE - off
	 *  XML declaration - off
	 *  Filtering  - No filtering (diff test case
	 ************************************************************************/
	
	
	/*
	 * Test below
	 * Detailed differencing - off
	 * Whitespace - Compare as is
	 * Ignore namespace - on
	 * Ignore prefixes - off
	 * Resolve entities - off
	 * Ignore text - on
	 * Ignore node depth - on
	 * Ignore case - on
	 * 		Do not ignore case in node names - on
	 * Ignore order of child nodes - off
	 * Ignore order of attributes - off
	 * Attributes - on
	 * CD data - on
	 * Comments - off
	 * Processing instruction - off
	 * DOCTYPE - on
	 * XML declaration - off
	 * 
	 */
	
	@Test
	public void testXMLDirComparisonOptions1(){
		robot.compare2Directories(DIRDIFF_few_1, DIRDIFF_few_2);
		robot.setShowFilesInZip(false);
		robot.setQuickComparison(false);
		robot.setCompareAsXML();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(
				new CheckboxOption("Detailed differencing",false),
				new RadioOption("Compare as is"),
				new CheckboxOption("Ignore namespace",true),
				new CheckboxOption("Ignore prefixes",false),
				new CheckboxOption("Resolve entities",false),
				new CheckboxOption("Ignore text",true),
				new CheckboxOption("Ignore node depth",true),
				new CheckboxOption("Ignore case",true),
				new CheckboxOption("Ignore order of attributes",false),
				new CheckboxOption("Attributes",true),
				new CheckboxOption("CData",true),
				new CheckboxOption("Comments",false),
				new CheckboxOption("Processing instruction",false),
				new CheckboxOption("DOCTYPE",true),
				new CheckboxOption("XML declaration",false)
				
		);
		robot.okButton();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		robot.openComparisionOptions("XML");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	
	/*
	 * Test below
	 * Detailed differencing - on
	 * Whitespace - Strip all
	 * Ignore namespace - off
	 * Ignore prefixes - on
	 * Resolve entities - on
	 * Ignore text - off
	 * Ignore node depth - off
	 * Ignore case - on
	 * 		Do not ignore case in node names - off
	 * Ignore order of child nodes - on
	 * Ignore order of attributes - on
	 * Attributes - off
	 * CD data - off
	 * Comments - on
	 * Processing instruction - on
	 * DOCTYPE - of
	 * XML declaration - on
	 * 
	 */
	
	@Test
	public void testXMLDirComparisonOptions2(){
		robot.compare2Directories(DIRDIFF_few_1, DIRDIFF_few_2);
		robot.setShowFilesInZip(false);
		robot.setQuickComparison(false);
		robot.setCompareAsXML();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(
				new CheckboxOption("Detailed differencing",true),
				new RadioOption("Strip all"),
				new CheckboxOption("Ignore namespace",false),
				new CheckboxOption("Ignore prefixes",true),
				new CheckboxOption("Resolve entities",true),
				new CheckboxOption("Ignore text",false),
				new CheckboxOption("Ignore node depth",false),
				new CheckboxOption("Ignore case",true),
				new CheckboxOption("Do not ignore case in node names",false),
				new CheckboxOption("Ignore order of child nodes",true),
				new CheckboxOption("Ignore order of attributes",false),
				new CheckboxOption("Attributes",false),
				new CheckboxOption("CData",false),
				new CheckboxOption("Comments",true),
				new CheckboxOption("Processing instruction",true),
				new CheckboxOption("DOCTYPE",false),
				new CheckboxOption("XML declaration",true)
				
		);
		robot.okButton();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		robot.openComparisionOptions("XML");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}	
	
	
	
	/*
	 * Test below
	 * Default exept:
	 * 
	 * Ignore order of child node - on
	 * All attributes - on
	 * Add element text as comparison criteria - on
	 * 
	 */
	
	@Test
	public void testXMLDirComparisonOptions3(){
		robot.compare2Directories(DIRDIFF_few_1, DIRDIFF_few_2);
		robot.setShowFilesInZip(false);
		robot.setQuickComparison(false);
		robot.setCompareAsXML();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(
				new CheckboxOption("Ignore order of child nodes",true),
				new CheckboxOption("Add element text as comparison criteria",true),
				new RadioOption("All attributes")
		);
		robot.okButton();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		robot.openComparisionOptions("XML");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}	
	
	/*
	 * Test below
	 * Default exept:
	 * 
	 * Ignore order of child node - on
	 * Specific attributes
	 * Add element text as comparison criteria - off
	 * 
	 */
	
	@Test
	public void testXMLDirComparisonOptions4(){
		robot.compare2Directories(DIRDIFF_few_1, DIRDIFF_few_2);
		robot.setShowFilesInZip(false);
		robot.setQuickComparison(false);
		robot.setCompareAsXML();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(
				new CheckboxOption(" Ignore order of child nodes",true),
				new CheckboxOption(" Add element text as comparison criteria",false),
				new RadioOption("Specific attributes")
		);
		
		//Add new group will apear only if no group exists, so if exists we just select current one
		try{
		robot.addNewAttributeGroup("group1","c");
		}catch (Exception e) {}
		robot.okButton();
		delay(500);
		robot.okButton();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		robot.openComparisionOptions("XML");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}	
	
	/*
	 * Test below
	 * Default options
	 * 
	 */
	
	@Test
	public void testXMLDirComparisonOptions5(){
		robot.compare2Directories(DIRDIFF_few_1, DIRDIFF_few_2);
		robot.setShowFilesInZip(false);
		robot.setQuickComparison(false);
		robot.setCompareAsXML();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.openComparisionOptions("XML");
		robot.setDiffDogOptions(
				new CheckboxOption("Ignore order of child nodes",false),
				new RadioOption(" None")
		);
		robot.setDiffDogOptions(
		new CheckboxOption("Ignore order of attributes",true));
		robot.okButton();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		robot.openComparisionOptions("XML");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}	
	
	/************************************************************************
	 *						WORD OPTIONS - Direcotry 						*
	 *	Default is:															*
	 * 	Text - Sentence														*
	 * 	Whitespace - Compare as is											*	
	 * Show differences within lines - on									*
	 * 	Ignore case - off   												*
	 * 	Ignore blank lines off												*
	 *	Format - all off													*																	*
	 ************************************************************************/
	
	/*
	 * 	Whitespace - Normalize	
	 * Show differences within lines - off								
	 * 	Ignore case - on   												
	 * 	Ignore blank lines - on											
	 *	Format - all on	
	 */
	@Test
	public void testDirdifWordComparisonOptions1(){
		robot.compare2Directories(DIRDIFF_WORD, DIRDIFF2_WORD);
		robot.openComparisionOptions("Word");
		
		robot.setDiffDogOptions(new CheckboxOption("Show differences within lines",false),
				new CheckboxOption("Ignore case",true),
				new CheckboxOption("Ignore blank lines",true),
				new RadioOption("Normalize"),
				new RadioOption("Paragraph"),
				new CheckboxOption("Bold",true),
				new CheckboxOption("Italic",true),
				new CheckboxOption("Underline",true),
				new CheckboxOption("Font Name",true),
				new CheckboxOption("Font Size",true),
				new CheckboxOption("Color",true)
		);
		robot.okButton();
		robot.escapeDialog("No differences found", VK_ESCAPE);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		robot.openComparisionOptions("Word");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	@Test
	public void testDirdifWordComparisonOptions2(){
		robot.compare2Directories(DIRDIFF_WORD, DIRDIFF2_WORD);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(new CheckboxOption("Show differences within lines",true),
				new CheckboxOption("Ignore case",false),
				new CheckboxOption("Ignore blank lines",false),
				new RadioOption("Strip all"),
				new RadioOption("Sentence"),
				new CheckboxOption("Bold",false),
				new CheckboxOption("Italic",false),
				new CheckboxOption("Underline",false),
				new CheckboxOption("Font Name",false),
				new CheckboxOption("Font Size",false),
				new CheckboxOption("Color",false)
		);
		robot.okButton();
		robot.escapeDialog("No differences found", VK_ESCAPE);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		robot.openComparisionOptions("Word");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	
	@Test
	public void testDirdifWordComparisonOptions3(){
		robot.compare2Directories(DIRDIFF_WORD, DIRDIFF2_WORD);
		robot.openComparisionOptions("Word");
		robot.setDiffDogOptions(
				new RadioOption("Compare as is")
		);
		robot.okButton();
		robot.escapeDialog("No differences found", VK_ESCAPE);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		robot.openComparisionOptions("Word");
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	/************************************************************************
	 *																		*
	 *								URL Support								*
	 *																		*
	 ************************************************************************/
	
	@Test
	public void testFiledifWithIPAddress(){
		robot.compareFiles(attr1IP, attr2IP);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testFiledifWithDNSAddress(){
		robot.compareFiles(attr1DNS, attr2DNS);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	
	@Test
	public void testFirdifWithIPAddress(){
		robot.compare2Directories(leftDirIP, rightDirIP);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testDiredifWithDNSAddress(){
		robot.compare2Directories(leftDirDNS, rightDirDNS);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	
	@Test
	public void testFilediffWithHttpAuth(){
		robot.compareURLFiles(http_auth + "LeftSide/attr1.xml","test", "test",http_auth + "RightSide/attr2.xml","test","test" );
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testDirdiffWithHttpAuth(){
		robot.compareURLDirecotries(http_auth + "LeftSide/DirDiff","test","test",http_auth + "RightSide/DirDiff","test","test");
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testFilediffWithFTP(){
		robot.compareFiles(ftp + "LeftSide/attr1.xml",ftp + "RightSide/attr2.xml" );
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testDirdiffWithFTP(){
		robot.compare2Directories(ftp + "LeftSide/DirDiff",ftp + "RightSide/DirDiff");
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testFilediffWithFTPAuth(){
		robot.compareURLFiles(ftp_auth + "LeftSide/attr1.xml","test", "test",ftp_auth + "RightSide/attr2.xml","test","test" );
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testDirdiffWithFTPAuth(){
		robot.compareURLDirecotries(ftp_auth + "LeftSide/DirDiff_2","test","test",ftp_auth + "RightSide/DirDiff_2","test","test");
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	/************************************************************************
	 *																		*
	 *				Autostart comparison options							*
	 *																		*
	 ************************************************************************/
	//TTP:38618
	@Test
	public void testfileDifAutostartComparisonTextOff(){
		robot.compareFiles(ATTR1, ATTR2);
		robot.setCompareAsTXT();
		robot.setAutostartComparison(false);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		assertAreas(DIFF_DOG_UP_WINDOW);
	}
	//TTP:38618	
	@Test
	public void testfileDifAutostartComparisonTextOn(){
		robot.compareFiles(ATTR1, ATTR2);
		robot.setCompareAsTXT();
		robot.setAutostartComparison(true);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		assertAreas(DIFF_DOG_UP_WINDOW);
	}
	//TTP:38618
	@Test
	public void testfileDifAutostartComparisonXMLOff(){
		robot.compareFiles(ATTR1, ATTR2);
		robot.setCompareAsXML();
		robot.setAutostartComparison(false);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		assertAreas(DIFF_DOG_UP_WINDOW);
	}
	//TTP:38618
	@Test
	public void testfileDifAutostartComparisonXMLOn(){
		robot.compareFiles(ATTR1, ATTR2);
		robot.setCompareAsXML();
		robot.setAutostartComparison(true);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		assertAreas(DIFF_DOG_UP_WINDOW);
	}
	
	@Test
	public void testWordDifAutostartComparisonOff(){
		robot.compareWordDocuments(TEXT_WHITESPACE1, TEXT_WHITESPACE2);
		robot.setAutostartComparison(false);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		assertAreas(DIFF_DOG_UP_WINDOW);
	}
	//TTP:38618
	@Test
	public void testWordDifAutostartComparisonOn(){
		robot.compareWordDocuments(TEXT_WHITESPACE1, TEXT_WHITESPACE2);
		robot.setAutostartComparison(true);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		assertAreas(DIFF_DOG_UP_WINDOW);
	}
	
	//TODO AutostartComparison for Word and directory, now doesn't work
	
	//TTP:38618
	@Test
	public void testDirDifAutostartComparisonOff(){
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		robot.setAutostartComparison(false);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		assertAreas(DIFF_DOG_UP_WINDOW);
	}
	
	@Test
	public void testDirDifAutostartComparisonOn(){
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		robot.setAutostartComparison(true);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		assertAreas(DIFF_DOG_UP_WINDOW);
	}

	
	/************************************************************************
	 *																		*
	 *						Filters											*
	 *																		*
	 ************************************************************************/
	@Test
	public void testDirectoryFilter(){
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		robot.expandFiltrList();
		delay(2000);
		robot.keyType(VK_END);
		delay(200);
		robot.keyType(VK_ENTER);
		robot.saveComparisonFile(tempDirCompFile);
		assertFileExists(new File(tempDirCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempDirCompFile);
		assertAreas(DIFF_DOG_UP_WINDOW);
		robot.expandFiltrList();
		robot.keyType(VK_HOME);
		delay(200);
		robot.keyType(VK_ENTER);
		
	}
	
	@Test
	public void testXMLFilter(){

		robot.compareFiles(ATTR1, ATTR2);
		robot.setCompareAsXML();
		robot.openComparisionOptions("XML");
		robot.leftClickOnIcon(DOTS.getAbsolutePath(), "Ignore node types");
		robot.addNewAttributeGroupFilters("XMLFilter", "t");
		delay(500);
		robot.selectAtt(true);
		delay(500);
		robot.selectEle(true);
		robot.okButton();
		robot.keyTypeShift(VK_TAB);
		robot.typeString("XML");
		robot.okButton();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
		assertAreas(TOP_WINDOW);
		robot.saveComparisonFile(tempCompFile);
		assertFileExists(new File(tempCompFile));
		robot.closeAll();
		robot.openComparisonFile(tempCompFile);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteAllXMLFilters();
		robot.escapeDialog("No differences found!", VK_ESCAPE);
	}
	
	
	
}
