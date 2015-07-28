/**
 * 
 */
package com.altova.mapforce;

import java.io.File;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import com.altova.util.IOUtils;
import com.altova.util.AltovaJUnitRunner.TestRobot;

/**
 * @author b.lopez
 *
 */

//@TestRobot(EclipseMapForceRobot.class)
public class InsertMenuTest extends AbstractMapForceTest {

	private static File APPLICATIONS_PAGE_XML=IOUtils.findFile("examples/ApplicationsPage.xml");
	private static File ARTICLES_XML=IOUtils.findFile("examples/Articles.xml");
	private static File ARTICLES_XSD=IOUtils.findFile("examples/Articles.xsd");
	private static File ORDERS_EDI=IOUtils.findFile("examples/ORDERS.EDI");
	private static File COLLECTION920_x12=IOUtils.findFile("examples/920.x12");
	private static File ORDERS_CSV=IOUtils.findFile("examples/Orders.csv");
	private static File HEAD_DET_TXT=IOUtils.findFile("examples/head-det-txt.txt");
	private static File SALES_PRESENTATION_XLSX=IOUtils.findFile("examples/Sales-presentation.xlsx");
	private static File NEWS_DTD_FILE=IOUtils.findFile("examples/news.dtd");
	private static File STRING_XML_FILE=IOUtils.findFile("examples/string.xml");
	//Caspar
	private static File QUOTATIONS_XML=IOUtils.findFile("examples/Quotations.xml"); //probably won't need this
	private static File IATA_EDI=IOUtils.findFile("examples/IATA.edi");
	private static File INVFIL_EDI=IOUtils.findFile("examples/INVFIL.edi");
	private static File ADT_A28_HL7=IOUtils.findFile("examples/ADT_A28.1.hl7");
	private static File Q2_837_XSD=IOUtils.findFile("examples/837-Q2.xsd");
	@Before
	public void setUp() throws Exception {

		super.setUp();
		
//		String junitRun = AltovaJUnitRunner.getCurrentRunName(robot);
		robot.startFromNewMapping();
		delay(1000);
	}

	@Test
	public void testInsertXMLFile(){
		robot.insertXMLFile(APPLICATIONS_PAGE_XML);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertXSD_SkipXMLFile(){
		robot.insertXSDFile(ARTICLES_XSD, false, null,"Articles");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertXSD_withXMLFile(){
		robot.insertXSDFile(ARTICLES_XSD, true, ARTICLES_XML,null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertDTD_SkipXMLFile(){
		robot.insertXSDFile(NEWS_DTD_FILE, false,null,"news");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertDTD_withXMLFile(){
		robot.insertXSDFile(NEWS_DTD_FILE, true, STRING_XML_FILE,null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Ignore //ignored due to the peculiar Altova DB's horrible dialog 
	@Test
	public void testInsertDB(){
		
	}
	
	@Test
	public void testInsertEdi_X12_skip(){
		robot.insertEDI(false,"107",null); 
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertEdi_X12_withFile(){
		robot.insertEDI("X12","920",COLLECTION920_x12); 
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertEdi_EDIFACT_skip(){
		robot.insertEDI(true,"BUSCRD",null); 
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertEdi_EDIFACT_withFile(){
		robot.insertEDI("EDIFACT","ORDERS",ORDERS_EDI); 
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertEdi_IATA_skip(){
		robot.insertEDI("IATA", "CLTRES", null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testIndertEdi_IATA_withFile(){
		robot.insertEDI("IATA", "FLIRES", IATA_EDI);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testIndertEdi_HIPAA_skip(){
		robot.insertEDI("HIPAA.X12", "277-A1", null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testIndertEdi_HIPAA_withFile(){
		robot.insertEDI("HIPAA.X12", "837-Q2", Q2_837_XSD);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testIndertEdi_TRADACOMS_skip(){
		robot.insertEDI("TRADACOMS", "DELHDR", null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testIndertEdi_TRADACOMS_withFile(){
		robot.insertEDI("TRADACOMS", "INVFIL", INVFIL_EDI);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testIndertEdi_HL7_skip(){
		robot.insertEDI("HL7", "ADT_A06", null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testIndertEdi_HL7_withFile(){
		robot.insertEDI("HL7", "ADT_A28", ADT_A28_HL7);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertText_CSV(){
		robot.insertText(ORDERS_CSV);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertText_TXT(){
		robot.insertText(HEAD_DET_TXT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertText_MFT(){
		robot.insertText(INSPECTIONREPORT_MFT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertWebServiceFunction(){
		robot.insertWebServiceFunction(UPSRATES_WSDL_FILE,"UPSRatesHttpGet","GetShippingRate",null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertExcel_withFile(){
		robot.insertExcel2007File(SALES_PRESENTATION_XLSX);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertExcel_skip(){
		robot.insertExcel2007File(null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Ignore // will generate the test cases once the functionality is completely finished 
	@Test
	public void testInsertXBRL(){
		//TODO
	}
	
	@Test
	public void testInsertJSON(){
		
	}
	
	@Test
	public void testInsertInput(){

	}
	
	@Test
	public void testInsertOutput(){
	
	}
	
	@Test
	public void testInsertNodes(){
		
	}
	
	
	@Test
	public void testInsertConstant_String(){
		robot.insertConstant("Hola Paquito","String");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertConstant_Number(){
		robot.insertConstant("1234567890","Number");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertConstant_AllOther(){
		robot.insertConstant("23-05-1981","All other");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertFilter(){
		robot.insertFilter();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertSQLWHERECondition(){
		robot.insertSqlWhereCondition();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertValueMap(){
		robot.insertValueMap();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertIfElseCondition(){
		robot.insertIfElseCondition();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public void testInsertException(){
		robot.insertException();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	
}
