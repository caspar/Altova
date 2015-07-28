package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.ZIP_VIEW;
import static com.altova.spy.SpyRobot.ATTRIBUTES;
import static com.altova.spy.SpyRobot.COMPONENTS;
import static com.altova.spy.SpyRobot.CSS_ELEMENTS;
import static com.altova.spy.SpyRobot.CSS_OUTLINE;
import static com.altova.spy.SpyRobot.CSS_PROPERTIES;
import static com.altova.spy.SpyRobot.DETAIL;
import static com.altova.spy.SpyRobot.DETAILS;
import static com.altova.spy.SpyRobot.ELEMENTS;
import static com.altova.spy.SpyRobot.ENTITIES;
import static com.altova.spy.SpyRobot.FACETS;
import static com.altova.spy.SpyRobot.INFO;
import static com.altova.spy.SpyRobot.OVERVIEW;
import static com.altova.spy.SpyRobot.XQUERY_FUNCTIONS;
import static com.altova.spy.SpyRobot.XQUERY_KEYBOARDS;
import static com.altova.spy.SpyRobot.XQUERY_VARIABLES;
import static com.altova.spy.SpyRobot.GLOBAL_ELEMENTS;
import static com.altova.util.LoggerUtils.logger;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.PluginRobot;
import com.altova.robots.RadioOption;
import com.altova.spy.SpyRobot.XBRLTabSchema;
import com.altova.util.IOUtils;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;



//@TestRobot(EclipseSpyRobot.class)
//@TestRobot(VSnetSpyRobot.class)
public class NewFileMenuTest extends AbstractXmlSpyTest {

	private static final File DOCX_FILE = new File(IOUtils.findFile("spy/examples/TestNewFile_docx.docx").toString());

	private static final File PPTX_FILE = new File(IOUtils.findFile("spy/examples/TestNewFile_pptx.pptx").toString());

	private static final File XSLX_FILE = new File(IOUtils.findFile("spy/examples/TestNewFile_xlsx.xlsx").toString());
	
	public static final File taxonomy_example_file = new File(IOUtils.findFile("spy/examples/XBRL_Taxonomy.xsd").toString());
	
	public static final File EPUB_FILE = new File(IOUtils.findFile("spy/examples/TestNewFile_epub.epub").toString());
		
	@BeforeClass
	public static void beforeNewFile(){		
		
		robot.createSpyProjectInEclipse(); //will just create a project in eclipse
		robot.openFile(ORGCHART_XML_FILE.getAbsolutePath(), false, null);
	}

	@Before
	public void setUp() throws Exception {
		
		//just avoid to load every time OrgChart.xml
	}

	
	@Test
	public final void testNewAspFile() {
		robot.newFile("Active Server Page");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}
			
	@Test
	public final void testNewBizFilePlain() {
		robot.newFile("BizTalk Schema");
		robot.keyType((KeyEvent.VK_ESCAPE));
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);

	}

	@Test
	public final void testNewBizFileWithDTD() {
		setOption_DTD_XSD_NewFile("BizTalk Schema", "DTD   ", ITEMS_DTD_FILE.getAbsolutePath(), null);
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}
	
	
	@Test
	public final void testNewBizFileWithSchema() {
		setOption_DTD_XSD_NewFile("BizTalk Schema", "Schema   ", ORGCHART_XSD_FILE.getAbsolutePath(),"OrgChart");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}


	@Test
	public final void testNewCmlFile() {
		robot.newFile("Chemical Markup Language");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewCssFile() {
		robot.newFile("Cascading Style Sheet");
		assertAreas(DIAGRAM_MAIN_WINDOW, CSS_OUTLINE, CSS_PROPERTIES, CSS_ELEMENTS, INFO);
	}

	@Test
	public final void testNewDcdFilePlain() {
		robot.newFile("Document Content Description");
		robot.keyType((KeyEvent.VK_ESCAPE));
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewDcdFileWithDTD() {
		setOption_DTD_XSD_NewFile("Document Content Description", "DTD   ", ITEMS_DTD_FILE.getAbsolutePath(), null);
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);

	}

	@Test
	public final void testNewDcdFileWithSchema() {
		setOption_DTD_XSD_NewFile("Document Content Description", "Schema   ", ORGCHART_XSD_FILE.getAbsolutePath(), "OrgChart");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);

	}

	@Test
	public final void testNewDocxFile() {
		removeAndAssert(DOCX_FILE);
		robot.newFile("Word OpenXML", null, null, DOCX_FILE.getAbsolutePath(), null);
		assertFileExists(DOCX_FILE);
		try{
			assertAreas(ZIP_VIEW);
		}catch(NullPointerException e){
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
	}
	
//testNewDocxFileVS 

//testNewDocxFileVS 

	@Test
	public final void testNewDtdFile() {
		robot.newFile("Document Type Definition");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ENTITIES);
	}

	@Test
	public final void testNewEntFilePlain() {
		robot.newFile("External Entity");
		robot.keyType((KeyEvent.VK_ESCAPE));
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);

	}

	@Ignore //this was a bug, so the option was disabled for this release
	@Test
	public final void testNewEntFileWithDTD() {
		// robot.newFile("External Entity");
		setOption_DTD_XSD_NewFile("External Entity", "DTD   ", ITEMS_DTD_FILE.getAbsolutePath(), null);
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);

	}

	@Test
	public final void testNewEntFileWithSchema() {
		setOption_DTD_XSD_NewFile("External Entity", "Schema   ", ORGCHART_XSD_FILE.getAbsolutePath(), "OrgChart");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);

	}
	

	@Test
	public final void testNewEpubFile() {
		
		removeAndAssert(EPUB_FILE);
		robot.newFile("Electronic Publication", null, null, EPUB_FILE.getAbsolutePath(), null); // ZIP File or WINRAR Archive
		assertFileExists(EPUB_FILE);
		delay(2000);
		try{
			assertAreas(ZIP_VIEW);
		}catch(NullPointerException e){
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}		
		
		
	}

	@Test
	public final void testNewEpubFilePreview() {
		
		removeAndAssert(EPUB_FILE);
		robot.newFile("Electronic Publication", null, null, EPUB_FILE.getAbsolutePath(), null); // ZIP File or WINRAR Archive
		assertFileExists(EPUB_FILE);
		delay(2000);
		
		robot.openEpubPreview();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, INFO);
		
		
		
	}

	@Test
	public final void testNewFoFile() {
		robot.newFile("Formatting Objects");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}



//testNewHtmFileVS 

	
	@Ignore
	@Test
	public final void testNewHtmFile() {
		robot.newFile("htm");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}
	
	@Test
	public final void testNewHTML4File() {
		robot.newFile("HTML 4");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES, INFO);
	}
	
	@Test
	public final void testNewHTML5File() {
		robot.newFile("HTML 5");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES, INFO);
	}
	
	@Test
	public final void testNewXHTML10StrictFile() {
		robot.newFile("XHTML 1.0 Strict");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES, INFO);
	}
	
	@Test
	public final void testNewXHTML10TransitionalFile() {
		robot.newFile("XHTML 1.0 Transitional");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES, INFO);
	}	
	
	@Test
	public final void testNewXHTML11File() {
		robot.newFile("XHTML 1.1");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}	
	
	@Ignore
	@Test
	public final void testNewHtmlFile() {
		robot.newFile("html");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewJSON() {
		robot.newFile("JavaScript Object Notation");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES, INFO);
	}
	
	@Test
	public final void testNewJspFile() {
		robot.newFile("JavaServer Page");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);

	}
	

	@Test
	public final void testNewKMLFile() {
		robot.newFile("KML-Document");
		robot.delay(4000);
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);

	}

	@Test
	public final void testNewKMZFile() {
		robot.newFile("KMZ-Document");
		delay(2000);
		try{
			assertAreas(ZIP_VIEW);
		}catch(NullPointerException e){
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}

	}
	

	@Test
	public final void testNewMathFile() {
		robot.newFile("Mathematical Markup Language");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewMediaCatalogFile() {
		robot.newFile("Media Catalog File");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	// @IgnoreRobots({VSnetSpyRobot.class,EclipseSpyRobot.class})
	public final void testNewMSOfficePowerPoint2007() {
		removeAndAssert(PPTX_FILE);
		robot.newFile("MS Office PowerPoint OpenXML", null, null, PPTX_FILE.getAbsolutePath(), null);
		assertFileExists(PPTX_FILE);
		try{
			assertAreas(ZIP_VIEW);
		}catch(NullPointerException e){
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
	}


//testNewMSOfficePowerPoint2007

	
	
	// --------------------------


	@Test
	public final void testNewResourceDescriptionFramework() {
		robot.newFile("Resource Description Framework");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewSyncMultiIntegLan() {
		robot.newFile("Sync. Multimedia Integ. Language");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewTagLibraryDescriptor() {
		robot.newFile("JSP 1.2 Tag Library Descriptor");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}


	@Test
	// @IgnoreRobots({VSnetSpyRobot.class,EclipseSpyRobot.class})
	public final void testNewScalableVectorGraphics() {
		robot.newFile("Scalable Vector Graphics");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}


//testNewScalableVectorGraphicsVS

	// --------------
	@Test
	@Ignore //tamino is not supported anymore
	public final void testNewTaminoSchemaDefinition() {
		robot.newFile("Tamino Schema Definition");
		delay(500);
		robot.keyType((KeyEvent.VK_ESCAPE));
		assertAreas(DIAGRAM_MAIN_WINDOW, COMPONENTS, DETAILS, FACETS);
	}

	@Test
	@IgnoreRobots(EclipseSpyRobot.class)
	public final void testNewTextDocument() {
		robot.newFile("Text file");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}


	
	@Test
	public final void testNewVoiceXML() {
		robot.newFile("VoiceXML"); // VoiceXML 2.0
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}
	
	@Test
	public final void testNewVoiceXML2() {
		robot.newFile("vxml"); // VoiceXML 2.0
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}


	@Test
	public final void testNewWirelessMarkupLanguage() {
		robot.newFile("Wireless");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewWebServices() {
		robot.newFile("Web Service Description v1.1");
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW, DETAIL);
	}

	@Test
	public final void testNewWebServices2() {
		robot.newFile("Web Service Description v2.0");
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW, DETAIL);
	}

	@Test
	public final void testNewXMLDataReducedSchemaPlain() {
		robot.newFile("Data Reduced Schema");
		robot.keyType((KeyEvent.VK_ESCAPE));
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewXMLDataReducedSchemaWithDTD() {
		setOption_DTD_XSD_NewFile("Data Reduced Schema", "DTD   ", ITEMS_DTD_FILE.getAbsolutePath(), null);
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewXMLDataReducedSchemaWithSchema() {
		setOption_DTD_XSD_NewFile("Data Reduced Schema", "Schema   ", ORGCHART_XSD_FILE.getAbsolutePath(), "OrgChart");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	//testcase is deprecated
	@Ignore
	@Test
	public final void testNewXHTML() {
		robot.newFile("Extensible Hypertext Markup"); //new XHTML Strict dtd
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	// ----------------- Excel X

	@Test
	public final void testNewMSOfficeExcel2007() {
		removeAndAssert(XSLX_FILE);
		robot.newFile("MS Office Excel OpenXML", null, null, XSLX_FILE.getAbsolutePath(), null);
		assertFileExists(XSLX_FILE);
		try{
			assertAreas(ZIP_VIEW);
		}catch(NullPointerException e){
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
	}


// testNewMSOfficeExcel2007

	@Test
	public final void testNewDocBookArticle() {
		robot.newFile("DocBook 4.5 Article");
		delay(10000);
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewDocBookBook() {
		robot.newFile("DocBook 4.5 Book");
		delay(10000);
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewEJBDescriptor() {
		robot.newFile("EJB 2.0 Deployment Descriptor");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@IgnoreRobots({VSnetSpyRobot.class})
	@Test
	public final void testNewJ2EEApplication() {
		robot.newFile("J2EE 1.3 Application");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewJ2EEApplicationClient() {
		robot.newFile("J2EE 1.3 Application Client");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewJ2EEConnector() {
		robot.newFile("J2EE Connector 1.0 Resource");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewServlet() {
		robot.newFile("Servlet 2.3 Deployment Descriptor");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	// ---------------------- XML Document -------------
	// -------------------------------------------------
	@Test
	public final void testNewXMLDocumentPlain() {
		robot.newFile("Extensible Markup Language");
		robot.keyType((KeyEvent.VK_ESCAPE));
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewXMLDocumentWithDTD() {
		setOption_DTD_XSD_NewFile("Extensible Markup Language", "DTD   ", ITEMS_DTD_FILE.getAbsolutePath(),  null);
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewXMLDocumentWithSchema() {
		setOption_DTD_XSD_NewFile("Extensible Markup Language", "Schema   ", ORGCHART_XSD_FILE.getAbsolutePath(), "OrgChart");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}


//testNewXMLDocumentPlainVS
//testNewXMLDocumentWithDTDVS
//testNewXMLDocumentWithSchemaVS	

//testNewXQVS

	
	// ---------------- XQ
	@Test
	public final void testNewXQ10() {
		setOptionNew_XSL_XQ_File("XQ Query Language 1.0", "Generic", "Create new XQuery file", null);
		assertAreas(DIAGRAM_MAIN_WINDOW, XQUERY_KEYBOARDS, XQUERY_VARIABLES, XQUERY_FUNCTIONS, INFO);
	}
	
	@Test
	public final void testNewXQ30() {
		setOptionNew_XSL_XQ_File("XQ Query Language 3.1", "Generic", "Create new XQuery file", null);
		assertAreas(DIAGRAM_MAIN_WINDOW, XQUERY_KEYBOARDS, XQUERY_VARIABLES, XQUERY_FUNCTIONS, INFO);
	}
	

	// ---------------- XQL
	@Test
	public final void testNewXQL10() {
		setOptionNew_XSL_XQ_File("XQL Query Language 1.0", "Generic", "Create new XQuery file", null);
		assertAreas(DIAGRAM_MAIN_WINDOW, XQUERY_KEYBOARDS, XQUERY_VARIABLES, XQUERY_FUNCTIONS, INFO);
	}
	
	@Test
	public final void testNewXQL30() {
		setOptionNew_XSL_XQ_File("XQL Query Language 3.1", "Generic", "Create new XQuery file", null);
		assertAreas(DIAGRAM_MAIN_WINDOW, XQUERY_KEYBOARDS, XQUERY_VARIABLES, XQUERY_FUNCTIONS, INFO);
	}

//testNewXQLVS


	// ------------------
	// -------------------- ?????????? Some Robot must ignore some functions
	// --------------------

	
	@Test
	public final void testNewXMLQueryDB2() {
		robot.newFile("XML Query Language for DB2");
		assertAreas(DIAGRAM_MAIN_WINDOW, XQUERY_KEYBOARDS, XQUERY_VARIABLES, XQUERY_FUNCTIONS, INFO);
	}

	// ------------------------------------

	@Test
	@IgnoreRobots({VSnetSpyRobot.class,EclipseSpyRobot.class})
	public final void testNewXQuery10() {
		setOptionNew_XSL_XQ_File("xquery 1.0", "Generic", "Create new XQuery file", null);
		assertAreas(DIAGRAM_MAIN_WINDOW, XQUERY_KEYBOARDS, XQUERY_VARIABLES, XQUERY_FUNCTIONS, INFO);
	}

	@Test
	@IgnoreRobots({VSnetSpyRobot.class,EclipseSpyRobot.class})
	public final void testNewXQuery30() {
		setOptionNew_XSL_XQ_File("xquery 3.1", "Generic", "Create new XQuery file", null);
		assertAreas(DIAGRAM_MAIN_WINDOW, XQUERY_KEYBOARDS, XQUERY_VARIABLES, XQUERY_FUNCTIONS, INFO);
	}

	
	@Test
	//@IgnoreRobots({VSnetSpyRobot.class,EclipseSpyRobot.class})
	public final void testNewXQueryUpdateFacility10() {
		robot.newFile("xqu Update Facility 1.0");
		assertAreas(DIAGRAM_MAIN_WINDOW, XQUERY_KEYBOARDS, XQUERY_VARIABLES, XQUERY_FUNCTIONS, INFO);
	}

	@Test
	//@IgnoreRobots({VSnetSpyRobot.class,EclipseSpyRobot.class})
	public final void testNewXQueryUpdateFacility30() {
		robot.newFile("xqu Update Facility 3.0");
		assertAreas(DIAGRAM_MAIN_WINDOW, XQUERY_KEYBOARDS, XQUERY_VARIABLES, XQUERY_FUNCTIONS, INFO);
	}	
	
	
	@Test
	public final void testNewXBRL() {
		//robot.newFile("Extensible Business Reporting Language");
		robot.newFile("XBRL Instance", null, null, taxonomy_example_file.getAbsolutePath(), null);
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	
	@Test
	public final void testNewXBRLTaxonomySchema_USGAAP2015() {
		robot.newFile("XBRL Taxonomy Schema", "USGAAP2015");
		Rectangle xbrl = robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "US-GAAP 2015");
		assertAreas(TOP_WINDOW);
		robot.newFileXBRLWinStep2(xbrl);
		
		assertAreas(getTestName()+ "_Elements", DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
		
		robot.switchXBRLTab_Definitions();
		assertAreas(getTestName()+ "_Definitions",DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Presentation();
		assertAreas(getTestName()+ "_Presentation", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Calculation();
		assertAreas(getTestName()+ "_Calculation", DIAGRAM_MAIN_WINDOW);

		robot.switchXBRLTab_Formula();
		assertAreas(getTestName()+ "_Formula", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Table();
		assertAreas(getTestName()+ "_Table", DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public final void testNewXBRLTaxonomySchema_USGAAP2014() {
		robot.newFile("XBRL Taxonomy Schema", "USGAAP2014");
		Rectangle xbrl = robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "US-GAAP 2014");
		assertAreas(TOP_WINDOW);
		robot.newFileXBRLWinStep2(xbrl);
		
		assertAreas(getTestName()+ "_Elements", DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
		
		robot.switchXBRLTab_Definitions();
		assertAreas(getTestName()+ "_Definitions",DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Presentation();
		assertAreas(getTestName()+ "_Presentation", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Calculation();
		assertAreas(getTestName()+ "_Calculation", DIAGRAM_MAIN_WINDOW);

		robot.switchXBRLTab_Formula();
		assertAreas(getTestName()+ "_Formula", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Table();
		assertAreas(getTestName()+ "_Table", DIAGRAM_MAIN_WINDOW);
	}

	
	@Test
	public final void testNewXBRLTaxonomySchema_USGAAP2013() {
		robot.newFile("XBRL Taxonomy Schema", "USGAAP2013");
		Rectangle xbrl = robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "US-GAAP 2013");
		assertAreas(TOP_WINDOW);
		robot.newFileXBRLWinStep2(xbrl);
		
		assertAreas(getTestName()+ "_Elements", DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
		
		robot.switchXBRLTab_Definitions();
		assertAreas(getTestName()+ "_Definitions",DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Presentation();
		assertAreas(getTestName()+ "_Presentation", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Calculation();
		assertAreas(getTestName()+ "_Calculation", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Formula();
		assertAreas(getTestName()+ "_Formula", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Table();
		assertAreas(getTestName()+ "_Table", DIAGRAM_MAIN_WINDOW);

		
	}
	
	@Test
	public final void testNewXBRLTaxonomySchema_USGAAP2012() {
		robot.newFile("XBRL Taxonomy Schema", "USGAAP2012");
		Rectangle xbrl = robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "US-GAAP 2012");
		assertAreas(TOP_WINDOW);
		robot.newFileXBRLWinStep2(xbrl);
		
		assertAreas(getTestName()+ "_Elements", DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
		
		robot.switchXBRLTab_Definitions();
		assertAreas(getTestName()+ "_Definitions",DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Presentation();
		assertAreas(getTestName()+ "_Presentation", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Calculation();
		assertAreas(getTestName()+ "_Calculation", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Formula();
		assertAreas(getTestName()+ "_Formula", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Table();
		assertAreas(getTestName()+ "_Table", DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	public final void testNewXBRLTaxonomySchema_USGAAP2011() {
		robot.newFile("XBRL Taxonomy Schema", "USGAAP2011");
		Rectangle xbrl = robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "US-GAAP 2011");
		assertAreas(TOP_WINDOW);
		robot.newFileXBRLWinStep2(xbrl);
		
		assertAreas(getTestName()+ "_Elements", DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
		
		robot.switchXBRLTab_Definitions();
		assertAreas(getTestName()+ "_Definitions",DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Presentation();
		assertAreas(getTestName()+ "_Presentation", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Calculation();
		assertAreas(getTestName()+ "_Calculation", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Formula();
		assertAreas(getTestName()+ "_Formula", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Table();
		assertAreas(getTestName()+ "_Table", DIAGRAM_MAIN_WINDOW);
		
	}
	

	@Test
	public final void testNewXBRLTaxonomySchema_USGAAP2009() {
		robot.newFile("XBRL Taxonomy Schema", "USGAAP2009");
		Rectangle xbrl = robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "US-GAAP 2009");
		assertAreas(TOP_WINDOW);
		robot.newFileXBRLWinStep2(xbrl);
		
		assertAreas(getTestName()+ "_Elements", DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
		
		robot.switchXBRLTab_Definitions();
		assertAreas(getTestName()+ "_Definitions",DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Presentation();
		assertAreas(getTestName()+ "_Presentation", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Calculation();
		assertAreas(getTestName()+ "_Calculation", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Formula();
		assertAreas(getTestName()+ "_Formula", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Table();
		assertAreas(getTestName()+ "_Table", DIAGRAM_MAIN_WINDOW);
		
	}


	@Test
	public final void testNewXBRLTaxonomySchema_USGAAP10() {
		robot.newFile("XBRL Taxonomy Schema", "USGAAP10");
		Rectangle xbrl = robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "US-GAAP 1.0");
		assertAreas(TOP_WINDOW);
		robot.newFileXBRLWinStep2(xbrl);
		
		assertAreas(getTestName()+ "_Elements", DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
		
		robot.switchXBRLTab_Definitions();
		assertAreas(getTestName()+ "_Definitions",DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Presentation();
		assertAreas(getTestName()+ "_Presentation", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Calculation();
		assertAreas(getTestName()+ "_Calculation", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Formula();
		assertAreas(getTestName()+ "_Formula", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Table();
		assertAreas(getTestName()+ "_Table", DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testNewXBRLTaxonomySchema_IFRS_ConceptsOnly() {
		
		//fail("test cases does fail until TTP 37372 will be fixed");
		robot.newFile("XBRL Taxonomy Schema", "IFRS");
		Rectangle xbrl = robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "IFRS");
		assertAreas(TOP_WINDOW);
		robot.newFileXBRLWinStep2(xbrl, "IFRS", "Concepts only");
		
		assertAreas(getTestName()+ "_Elements", DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
		
		robot.switchXBRLTab_Definitions();
		assertAreas(getTestName()+ "_Definitions",DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Presentation();
		assertAreas(getTestName()+ "_Presentation", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Calculation();
		assertAreas(getTestName()+ "_Calculation", DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testNewXBRLTaxonomySchema_IFRS_FullEntryPoint() {
		
		//fail("test cases does fail until TTP 37372 will be fixed");
		robot.newFile("XBRL Taxonomy Schema", "IFRS");
		Rectangle xbrl = robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "IFRS");
		assertAreas(TOP_WINDOW);
		robot.newFileXBRLWinStep2(xbrl, "IFRS", "Full entry point");
		
		assertAreas(getTestName()+ "_Elements", DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
		
		robot.switchXBRLTab_Definitions();
		assertAreas(getTestName()+ "_Definitions",DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Presentation();
		assertAreas(getTestName()+ "_Presentation", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Calculation();
		assertAreas(getTestName()+ "_Calculation", DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testNewXBRLTaxonomySchema_IFRS_SMEs_entry_point() {
		
		//fail("test cases does fail until TTP 37372 will be fixed");
		robot.newFile("XBRL Taxonomy Schema", "IFRS");
		Rectangle xbrl = robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "IFRS");
		assertAreas(TOP_WINDOW);
		robot.newFileXBRLWinStep2(xbrl, "IFRS", "SMEs entry point");
		
		assertAreas(getTestName()+ "_Elements", DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
		
		robot.switchXBRLTab_Definitions();
		assertAreas(getTestName()+ "_Definitions",DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Presentation();
		assertAreas(getTestName()+ "_Presentation", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Calculation();
		assertAreas(getTestName()+ "_Calculation", DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testNewXBRLTaxonomySchema_IFRS_Combined_entry_point() {
		
		//fail("test cases does fail until TTP 37372 will be fixed");
		robot.newFile("XBRL Taxonomy Schema", "IFRS");
		Rectangle xbrl = robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "IFRS");
		assertAreas(TOP_WINDOW);
		robot.newFileXBRLWinStep2(xbrl, "IFRS", "Combined entry point");
		
		assertAreas(getTestName()+ "_Elements", DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
		
		robot.switchXBRLTab_Definitions();
		assertAreas(getTestName()+ "_Definitions",DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Presentation();
		assertAreas(getTestName()+ "_Presentation", DIAGRAM_MAIN_WINDOW);
		
		robot.switchXBRLTab_Calculation();
		assertAreas(getTestName()+ "_Calculation", DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testNewXBRLTaxonomySchema_None() {
		robot.newFile("XBRL Taxonomy Schema");
		robot.newFileXBRLWinStep1("XBRL Taxonomy Schema", "Create New Taxonomy - Step 1", "None");
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
	}

	
	/// XML Signature
	@Test
	public final void testNewXMLSignaturePlain() {
		robot.newFile("XML Signature");
		robot.keyType((KeyEvent.VK_ESCAPE));
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewXMLSignatureWithDTD() {
		setOption_DTD_XSD_NewFile("XML Signature", "DTD   ", ITEMS_DTD_FILE.getAbsolutePath(), null);
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewXMLSignatureWithSchema() {
		setOption_DTD_XSD_NewFile("XML Signature", "Schema   ", ORGCHART_XSD_FILE.getAbsolutePath(), "OrgChart");
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}
	
	
	@Test
	public final void testNewW3CSchema10() {
		robot.newFile("XML Schema 1.0"); // ex W3C Schema File
		delay(5000);
		assertAreas(DIAGRAM_MAIN_WINDOW, COMPONENTS, DETAILS, FACETS);
	}

	@Test
	public final void testNewW3CSchema11() {
		robot.newFile("XML Schema 1.1"); // ex W3C Schema File
		delay(5000);
		assertAreas(DIAGRAM_MAIN_WINDOW, COMPONENTS, DETAILS, FACETS);
	}

	// Xslt: No test function "Map XML..." and "Produce HTML..." because need
	// MapForce and StyleVison
	// Plan test not necessary

	@Test
	public final void testNewXSL10() {
		setOptionNew_XSL_XQ_File("XSL Stylesheet v1.0", "Generic", "Create new XSL/XSLT file", null);
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewXSL20() {
		setOptionNew_XSL_XQ_File("XSL Stylesheet v2.0", "Generic", "Create new XSL/XSLT file", null);
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}
	
	@Test
	public final void testNewXSL30() {
		setOptionNew_XSL_XQ_File("XSL Stylesheet v3.0", "Generic", "Create new XSL/XSLT file", null);
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewXSLT10() {
		setOptionNew_XSL_XQ_File("XSLT Stylesheet v1.0", "Generic", "Create new XSL/XSLT file", null);
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewXSLT20() {
		setOptionNew_XSL_XQ_File("XSLT Stylesheet v2.0", "Generic", "Create new XSL/XSLT file", null);
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test
	public final void testNewXSLT30() {
		setOptionNew_XSL_XQ_File("XSLT Stylesheet v3.0", "Generic", "Create new XSL/XSLT file", null);
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}
	
	@Test
	public final void testNewZIPArchive() {

	
		robot.newFile("Archive"); // ZIP File or WINRAR Archive
		delay(2000);
		try{
			assertAreas(ZIP_VIEW);
		}catch(NullPointerException e){
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}

		
	}

	

	public final void setOption_DTD_XSD_NewFile(String filetype, String formatName, String fileinputpath, String schemaElement) {
		RadioOption format = new RadioOption(formatName);
		robot.newFile(filetype, format, "New file", fileinputpath, schemaElement);
		robot.delay(1000);
	}

	public final void setOptionNew_XSL_XQ_File(String filetype, String formatName, String dialogtype, String fileinputpath) {
		RadioOption format = new RadioOption(formatName, true);
		robot.newFile(filetype, format, dialogtype, fileinputpath, null);
		robot.delay(1000);

	}
	


	
}
