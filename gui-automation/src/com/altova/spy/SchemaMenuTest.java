package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.util.LoggerUtils.logger;

import static com.altova.spy.SpyRobot.*;

import java.io.File;


import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.CheckboxOption;

import com.altova.robots.RadioOption;


import com.altova.util.IOUtils;
import com.altova.util.Settings;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;

//@TestRobot(VSnetSpyRobot.class)
//@TestRobot(EclipseSpyRobot.class)
public class SchemaMenuTest extends AbstractXmlSpyTest {

	protected static final File COMPANY_DTD = IOUtils.findFile("spy/examples/company.dtd");
	protected static final File ITEMS_XML = IOUtils.findFile("spy/examples/items.xml");
	protected static final String TEMP_DIR="C:\\temp";
	protected static final String MY_FILE = "my";
	protected static final String ADRESS = "address.xsd";
	protected static final File MY_TEST_XSD_FILE = new File(TEMP_DIR+"\\"+MY_FILE+".xsd");
	protected static final File ADDRESS_XSD_FILE = new File(TEMP_DIR+"\\address.xsd");
	protected static final File ORGCHART_TEMP_XSD_FILE = new File(TEMP_DIR+"\\OrgChart.xsd");
	protected static final File MY_TEST_DTD_FILE = new File(TEMP_DIR+"\\"+MY_FILE+".dtd");
	
	protected static final File MY_UMP_FILE = new File(TEMP_DIR+"\\test\\"+MY_FILE+"prj.ump");
	private static final String xpath = "OrgChart/Name";
	
	protected static final String MY_JAVA_TEST ="C:\\temp\\JAVA";
	protected static final File MY_JAVA_TEST_FILE = new File(MY_JAVA_TEST );
	
	protected static final String MY_Cplus_TEST ="C:\\temp\\C++";
	protected static final File MY_Cplus_TEST_FILE = new File(MY_Cplus_TEST );
	
	protected static final String MY_Csharp_TEST = "C:\\temp\\C#";
	protected static final File MY_Csharp_TEST_FILE = new File(MY_Csharp_TEST );
	
	@Test
	public final void testAssignDTD() {
		robot.gridView();
		robot.assignDTD(COMPANY_DTD.getAbsolutePath());
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testAssignXSD() {
		robot.gridView();
		robot.assignXSD(ORGCHART_XSD_FILE.getAbsolutePath());
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testIncludeAnotherDTD() {
		robot.openFile(COMPANY_DTD);
		robot.gridView();
		robot.includeAnotherDTD(ITEMS_DTD_FILE.getAbsolutePath());
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testGotoDTD() {
		robot.openFile(ITEMS_XML);
		robot.gotoDTD();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testGotoXSD() {
		robot.textView();
		robot.gotoXSD();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testGotoDefinitionGridView() {
		robot.textView();
		robot.xpathHighlight(xpath);
		robot.gridView();
		robot.goToDefinition();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public final void testGenerateDTD() {
		generateDTD_XSD("DTD  ", MY_TEST_DTD_FILE);
	}
	
	@Test
	public final void testGenerateXSD() {
		removeAndAssert(new File(TEMP_DIR+"\\"+MY_FILE+"1.xsd"));
		removeAndAssert(new File(TEMP_DIR+"\\"+MY_FILE+"2.xsd"));
		generateDTD_XSD("W3C Schema", MY_TEST_XSD_FILE);
	}
	
	public final void generateDTD_XSD(String formatName, File output) {
		removeAndAssert(output);
		removeAndAssert(new File(output.getParentFile()+"\\"+output.getName()+"1.xsd"));
		RadioOption format = new RadioOption(formatName);
		robot.generateDTD_XSD(format,output.getAbsolutePath());
		assertFileExists(output);
		assertAreas(DIAGRAM_MAIN_WINDOW);
		if(!Settings.isVS2010()){ //this is not working for VS2010 and it is not that important
			assertAreas(VALIDATION);
		}
	}


	@Test
	public final void testConvertDTD() {
		removeAndAssert(MY_TEST_DTD_FILE);
		robot.openFile(ORGCHART_XSD_FILE);
		//convertDTD_XSD("DTD    ", MY_TEST_DTD_FILE);
		robot.convertSchemaToDTD(MY_TEST_DTD_FILE.getAbsolutePath());
		assertAreas(DIAGRAM_MAIN_WINDOW, MESSAGES);
	}


	@Test
	public final void testConvertXSD_Elements() {		
		removeAndAssert(MY_TEST_XSD_FILE);
		robot.openFile(COMPANY_DTD);
		//convertDTD_XSD("W3C Schema", MY_TEST_XSD_FILE);
		RadioOption format = new RadioOption("Elements");
		robot.convertDTDtoSchema(format, MY_TEST_XSD_FILE.getAbsolutePath());
		assertFileExists(MY_TEST_XSD_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW, MESSAGES);
	}
	@Test
	public final void testConvertXSD_ComplexType() {		
		removeAndAssert(MY_TEST_XSD_FILE);
		robot.openFile(COMPANY_DTD);
		//convertDTD_XSD("W3C Schema", MY_TEST_XSD_FILE);
		RadioOption format = new RadioOption("Complex types");
		robot.convertDTDtoSchema(format, MY_TEST_XSD_FILE.getAbsolutePath());
		assertFileExists(MY_TEST_XSD_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW, MESSAGES);
	}

	@Test
	public final void testFlattenDTD() {
		removeAndAssert(MY_TEST_DTD_FILE);
		robot.openFile(COMPANY_DTD);
		robot.flattenDTD(MY_TEST_DTD_FILE);
		assertFileExists(MY_TEST_DTD_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW, MESSAGES);

	}
	
	@Test
	public final void testFlattenSchema() {
		removeAndAssert(ADDRESS_XSD_FILE);
		removeAndAssert(ORGCHART_TEMP_XSD_FILE);
		robot.openFile(ORGCHART_XSD_FILE);
		robot.flattenSchema(TEMP_DIR);		
		assertFileExists(ADDRESS_XSD_FILE);
		assertFileExists(ORGCHART_TEMP_XSD_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW, MESSAGES);
	}
	
	public final void convertDTD_XSD(String formatName, File output) {
		removeAndAssert(output);
		RadioOption format = new RadioOption(formatName);
		robot.convertDTD_XSD(format, output.getAbsolutePath());
		assertFileExists(output);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testConvertUML() {
		removeAndAssert(MY_UMP_FILE);
		robot.openFile(ORGCHART_XSD_FILE);
		CheckboxOption openUModel = new CheckboxOption("Open generated project in UModel", false);
		robot.convertUML(openUModel, MY_UMP_FILE.getAbsolutePath());
		assertFileExists(MY_UMP_FILE);
	}

	@Test
	public final void testGenerateSampleXML() {
		robot.openFile(ORGCHART_XSD_FILE);
		robot.generateSampleXML(null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testGenerateCodeJava(){
		generateCode("Java ",MY_JAVA_TEST_FILE);
	}
	
	@Test
	public final void testGenerateCodeCplus(){
		generateCode("C++ (based ",MY_Cplus_TEST_FILE);
	}
	
	@Test
	public final void testGenerateCodeCsharp(){
		generateCode("C# (project ",MY_Csharp_TEST_FILE);
	}
	
	
	public final void generateCode(String formatName,File output) {
		IOUtils.deleteAll(output);
		assertFileNotExists(output);
		RadioOption format = new RadioOption(formatName);
		robot.openFile(ORGCHART_XSD_FILE);
		robot.generateCode(format,output.getAbsolutePath());
		assertFileExists(output);
	 
	}
	
	@Test
	public final void testFlushMemoryCache() {
		robot.flushMemoryCache();
		 
	}

}
