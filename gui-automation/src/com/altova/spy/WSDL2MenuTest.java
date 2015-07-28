/**
 * 
 */
package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.spy.SpyRobot.*;
//import static com.altova.spy.SpyRobot.DETAILS;
//import static com.altova.spy.SpyRobot.OVERVIEW;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.Options;
import com.altova.robots.RadioOption;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.IOUtils;
import com.altova.util.Settings;
import com.altova.util.AltovaJUnitRunner.TestRobot;

/**
 * @author B.Lopez
 *
 */
//@TestRobot(VSnetSpyRobot.class)
//@TestRobot(EclipseSpyRobot.class)
public class WSDL2MenuTest extends AbstractXmlSpyTest {

	//private static final String BASE_OUT_DIR= Settings.getOutputDir().getAbsolutePath()+"\\"+AltovaJUnitRunner.getRunName(robot,"WSDL2MenuTest");
	private static final String BASE_OUT_DIR = new File(IOUtils.findFile("/spy/output/GenerateWSDL20Doc").toString()).getAbsolutePath();
	//private static final String BASE_EXPECTED_DIR=Settings.getExpectedDir().getAbsolutePath()+"\\"+AltovaJUnitRunner.getRunName(robot,"WSDL2MenuTest");
	private static final String BASE_EXPECTED_DIR=new File(IOUtils.findFile("/spy/reference/GenerateWSDL20Doc").toString()).getAbsolutePath();
	protected final File WSDLDOC_HTML_MULTIFILE = new File(BASE_OUT_DIR+"\\testGenerateWSDLDocum_HTML_MultiFile");
	protected final File WSDLDOC_WORD_PNG_EMBED_MULTIFILE = new File(BASE_OUT_DIR+"\\testGenerateWSDLDocum_WORD_PNG_Embed_MultiFile");
	protected final File WSDLDOC_WORD_PNG_NOTEMBED_MULTIFILE = new File(BASE_OUT_DIR+"\\testGenerateWSDLDocum_WORD_PNG_Notembed_MultiFile");
	protected final File WSDLDOC_WORD_EMF_NOTEMBED_MULTIFILE = new File(BASE_OUT_DIR+"\\testGenerateWSDLDocum_WORD_EMF_Notembed_MultiFile");
	protected final File WSDLDOC_RTF_PNG_NOTEMBED_MULTIFILE = new File(BASE_OUT_DIR+"\\testGenerateWSDLDocum_RTF_PNG_NotEmbed_MultiFile");
	protected final File WSDLDOC_RTF_EMF_NOTEMBED_ONEFILE = new File(BASE_OUT_DIR+"\\testGenerateWSDLDocum_RTF_EMF_Notembed_OneFile");
	protected final File WSDLDOC_RTF_EMF_EMBED_MULTIFILE = new File(BASE_OUT_DIR+"\\testGenerateWSDLDocum_RTF_EMF_Embed_MultiFile");
	private static final String WSDL_DOCUM_FILENAME = "DocGenWSDL";
	
	@Before
	public void setUp() {
		
		robot.openFile(TIMESERVICE_WSDL20_FILE.toString());
		robot.maximizeFileWindow();
	}
	
	@Test
	public void testAddNewInterfaceWSDL20(){
		robot.addNewInterfaceWSDL20("MyTestInterface");
		robot.textView();
		robot.wsdlView();//this view change aims at the selection of the component in the Overview Window
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW,DETAILS);
	}
	
	@Test
	public void testDeleteInterfaceWSDL20(){
		robot.xpathHighlight("/description/interface[@name=\'TimeServiceface\']");
		robot.deleteInterfaceWSDL20();
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW);
	}
	
	@Test
	public void testAddNewFaultWSDL20(){
		robot.xpathHighlight("/description/interface[@name=\'TimeServiceface\']");
		robot.addNewFaultWSDL20("MyTestFault");
		robot.textView();
		robot.wsdlView();//this view change aims at the selection of the component in the Overview Window
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW,DETAILS);	
	}
	
	@Test
	public void testDeleteFaultWSDL20(){
		robot.xpathHighlight("/description/interface/fault[@name=\'FaultTimeZoneNotFound\']");
		robot.deleteFaultWSDL20();
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW);	
	}
	
	@Test
	public void testAddNewOperationInOnlyWSDL20(){
		robot.xpathHighlight("/description/interface[@name=\'TimeServiceface\']");
		robot.addNewOperationWSDL20("In-only","MyInOnlyOpTest");
		robot.xpathHighlight("description/interface/operation[@pattern=\'http://www.w3.org/ns/wsdl/in-only\']");
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW,DETAILS);
	}

	@Test
	public void testAddNewOperationRobustInOnlyWSDL20(){
		robot.xpathHighlight("/description/interface[@name=\'TimeServiceface\']");
		robot.addNewOperationWSDL20("Robust-in-only","MyRobustInOnlyOpTest");
		robot.xpathHighlight("description/interface/operation[@pattern=\'http://www.w3.org/ns/wsdl/robust-in-only\']");
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW,DETAILS);
	}
	
	@Test
	public void testAddNewOperationInOutWSDL20(){
		robot.xpathHighlight("/description/interface[@name=\'TimeServiceface\']");
		robot.addNewOperationWSDL20("In-out","MyInOutOpTest");
		robot.xpathHighlight("description/interface/operation[@pattern=\'http://www.w3.org/ns/wsdl/in-out\']");
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW,DETAILS);
	}
	
	@Test
	public void testAddNewOperationInOptOutWSDL20(){
		robot.xpathHighlight("/description/interface[@name=\'TimeServiceface\']");
		robot.addNewOperationWSDL20("In-opt-out","MyInOptOutOpTest");
		robot.xpathHighlight("description/interface/operation[@pattern=\'http://www.w3.org/ns/wsdl/in-opt-out\']");
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW,DETAILS);
	}
	
	@Test
	public void testAddNewOperationOutInWSDL20(){
		robot.xpathHighlight("/description/interface[@name=\'TimeServiceface\']");
		robot.addNewOperationWSDL20("Out-in","MyOutInOpTest");
		robot.textView();
		robot.wsdlView(); //In this case, we make a view switch,as pattern change might be done and should be caught !!
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW,DETAILS);
	}
	
	@Test
	public void testAddNewOperationOutOptInWSDL20(){
		robot.xpathHighlight("/description/interface[@name=\'TimeServiceface\']");
		robot.addNewOperationWSDL20("Out-opt-in","MyOutOptInOpTest");
		robot.xpathHighlight("description/interface/operation[@pattern=\'http://www.w3.org/ns/wsdl/out-opt-in\']");
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW,DETAILS);
	}
	
	@Test
	public void testAddNewOperationOutOnlyWSDL20(){
		robot.xpathHighlight("/description/interface[@name=\'TimeServiceface\']");
		robot.addNewOperationWSDL20("Out-only","MyOutOnlyOpTest");
		robot.xpathHighlight("description/interface/operation[@pattern=\'http://www.w3.org/ns/wsdl/out-only\']");
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW,DETAILS);
	}
	
	@Test
	public void testAddNewOperationRobustOutOnlyWSDL20(){
		robot.xpathHighlight("/description/interface[@name=\'TimeServiceface\']");
		robot.addNewOperationWSDL20("Robust-out-only","MyRobustOutOnlyOpTest");
		robot.xpathHighlight("description/interface/operation[@pattern=\'http://www.w3.org/ns/wsdl/robust-out-only\']");
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW,DETAILS);
	}
	
	@Test
	public void testAddNewOperationEmptyWSDL20(){
		robot.xpathHighlight("/description/interface[@name=\'TimeServiceface\']");
		robot.addNewOperationWSDL20("Empty Operation","MyEmptyOpTest");
		robot.xpathHighlight("description/interface/operation[@name=\'MyEmptyOpTest\']");
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW,DETAILS);
	}
	
	@Test
	public void testDeleteOperationWSDL20(){
		robot.xpathHighlight("/description/interface/operation[@name=\'getUTCTime\']");
		robot.deleteOperationWSDL20();
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW);
	}
	
	@Test
	public void testAddNewBindingWSDL20(){
		robot.openFile(MULTIPLEWSDLIMPORTS_WSDL20_FILE);
		robot.addNewBindingWSDL20("MyBindingTest");
		robot.textView(); //this view switch selects the component in the overview window
		robot.wsdlView();
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW,DETAILS);
	}
	
	@Test
	public void testDeleteBindingWSDL20(){
		robot.openFile(MULTIPLEWSDLIMPORTS_WSDL20_FILE);
		robot.xpathHighlight("/wsdl:description/wsdl:binding[@name=\'NewBinding\']");
		robot.deleteBindingWSDL20();
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW);
	}
	
	@Test
	public void testAddFaultToBindingWSDL20(){
		robot.openFile(MULTIPLEWSDLIMPORTS_WSDL20_FILE);
		robot.xpathHighlight("/wsdl:description/wsdl:binding[@name=\'NewBinding\']");
		robot.addFaultToBindingWSDL20("tns:MyBindingFaultTest");
		robot.textView();
		robot.wsdlView(); //This view switch will select the fault in the overview window
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW,DETAILS);
	}
	
	@Test
	public void testDeleteFaultFromBindingWSDL20(){
		robot.openFile(MULTIPLEWSDLINCLUDES_WSDL20_FILE);
		robot.xpathHighlight("/wsdl:description/wsdl:binding/wsdl:fault[@ref=\'tns:MyFaultInInterface1\']");
		robot.deleteFaultFromBindingWSDL20();
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW);
	}
	
	@Test
	public void testAddOperationToBindingWSDL20(){
		robot.openFile(MULTIPLEWSDLINCLUDES_WSDL20_FILE);
		robot.xpathHighlight("/wsdl:description/wsdl:binding[@name=\'NewBinding\']");
		robot.addOperationToBindingWSDL20("tns:MyBindingOperationTest");
		robot.textView(); //this helps you to select the operation in the binding
		robot.wsdlView();
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW,DETAILS);
	}
	
	@Test
	public void testDeleteOperationFromBindingWSDL20(){
		robot.openFile(MULTIPLEWSDLIMPORTS_WSDL20_FILE);
		robot.xpathHighlight("/wsdl:description/wsdl:binding/wsdl:operation[@ref=\'tns1:OperationToBeImported1\']");
		robot.deleteOperationFromBindingWSDL20();
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW);
	}
	
	@Test
	public void testAddNewServiceWSDL20(){
		robot.openFile(MULTIPLEWSDLIMPORTS_WSDL20_FILE);
		robot.addServiceWSDL20("MyServiceTest");
		robot.textView();//this view switch will select the added service in the overview
		robot.wsdlView(); 
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW,DETAILS);
	}
	
	@Test
	public void testDeleteServiceWSDL20(){
		robot.xpathHighlight("/description/service");
		robot.deleteServiceWSDL20();
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW);
	}
	
	@Test
	public void testAddNewEndpointWSDL20(){
		robot.openFile(MULTIPLEWSDLINCLUDES_WSDL20_FILE);
		robot.xpathHighlight("/wsdl:description/wsdl:service");
		robot.addEndpointToServiceWSDL20("MyEndpointTest");
		robot.xpathHighlight("/wsdl:description/wsdl:service/wsdl:endpoint[@name=\'MyEndpointTest\']");
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW,DETAILS);
	}
	
	@Test
	public void testDeleteEndpointWSDL20(){
		robot.openFile(MULTIPLEWSDLIMPORTS_WSDL20_FILE);
		robot.xpathHighlight("/wsdl:description/wsdl:service/wsdl:endpoint");
		robot.deleteEndpointFromServiceWSDL20();
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW);
	}
	
	@Test
	public void testGenerateWSDL20Documentation_HTML_MultiFile() {
		robot.openFile(MULTIPLEWSDLINCLUDES_WSDL20_FILE);
		IOUtils.deleteAll(WSDLDOC_HTML_MULTIFILE);
		String fullpath=WSDLDOC_HTML_MULTIFILE.getAbsolutePath()+"\\"+WSDL_DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+"_Interface3.html"));
		Options options=new Options();
		options.add(new RadioOption(" HTML", "Output format", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation",true));
		options.add(new CheckboxOption("Embed CSS in HTML",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.generateWSDLDocumentation(WSDLDOC_HTML_MULTIFILE,WSDL_DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+".html"));
		assertFileNotExists(new File(fullpath+".css"));
		assertFileExists(new File(fullpath+"_elementRequest.html"));
		assertFileExists(new File(fullpath+"_elementResponse.html"));
		assertFileExists(new File(fullpath+"_Interface1.html"));
		assertFileExists(new File(fullpath+"_Interface2.html"));
		assertFileExists(new File(fullpath+"_Interface3.html"));
		assertFileExists(new File(fullpath+"_NewBinding.html"));
		assertFileExists(new File(fullpath+"_NewService.html"));
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		for (int i = 1; i < 8; i++) {
			assertImage(new File(BASE_EXPECTED_DIR+"\\testGenerateWSDL20Docum_HTML_MultiFile\\"+WSDL_DOCUM_FILENAME+"_p"+i+".png"), new File(fullpath+"_p"+i+".png"));
		}
	}
	
	@Test
	public void testGenerateWSDLD20ocumentation_WORD_PNG_Embed_MultiFile() {
		robot.openFile(TIMESERVICE_WSDL20_FILE);
		IOUtils.deleteAll(WSDLDOC_WORD_PNG_EMBED_MULTIFILE);
		String fullpath=WSDLDOC_WORD_PNG_EMBED_MULTIFILE.getAbsolutePath()+"\\"+WSDL_DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+"_getServerCity.doc")); 
		Options options=new Options();
		options.add(new RadioOption(" Microsoft Word", "Output format", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new RadioOption("PNG", null, null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Embed diagrams",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation",false));
		robot.generateWSDLDocumentation(WSDLDOC_WORD_PNG_EMBED_MULTIFILE,WSDL_DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+".doc"));
		assertFileExists(new File(fullpath+"_errorResponse.doc"));
		assertFileExists(new File(fullpath+"_getCityTime.doc"));
		assertFileExists(new File(fullpath+"_getCityTimeResponse.doc"));
		assertFileExists(new File(fullpath+"_getOffsetUTCTime.doc"));
		assertFileExists(new File(fullpath+"_getOffsetUTCTimeResponse.doc"));
		assertFileExists(new File(fullpath+"_getServerCity.doc"));
		assertFileExists(new File(fullpath+"_getServerCityResponse.doc"));
		assertFileExists(new File(fullpath+"_getServerTime.doc"));
		assertFileExists(new File(fullpath+"_getServerTimeResponse.doc"));
		assertFileExists(new File(fullpath+"_getServerTimeZone.doc"));
		assertFileExists(new File(fullpath+"_getServerTimeZoneResponse.doc"));
		assertFileExists(new File(fullpath+"_getTimeZoneTime.doc"));
		assertFileExists(new File(fullpath+"_getTimeZoneTimeResponse.doc"));
		assertFileExists(new File(fullpath+"_getUTCTime.doc"));
		assertFileExists(new File(fullpath+"_getUTCTimeResponse.doc"));
		assertFileExists(new File(fullpath+"_TimeService.doc"));
		assertFileExists(new File(fullpath+"_TimeServiceface.doc"));
		assertFileExists(new File(fullpath+"_TimeServiceSoap.doc"));
		for (int i = 1; i < 20; i++) {
			assertFileNotExists( new File(fullpath+"_p"+i+".png"));
		}
	}
	
	@Test 
	public void testGenerateWSDL20Documentation_WORD_PNG_NotEmbed_MultiFile() {
		robot.openFile(XSDIMPORTSTEST_WSDL20_FILE);
		IOUtils.deleteAll(WSDLDOC_WORD_PNG_NOTEMBED_MULTIFILE);
		String fullpath=WSDLDOC_WORD_PNG_NOTEMBED_MULTIFILE.getAbsolutePath()+"\\"+WSDL_DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+"_getBalanceInf.doc"));
		Options options=new Options();
		options.add(new RadioOption(" Microsoft Word", "Output format", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new RadioOption("PNG", null, null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Embed diagrams",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation",false));
		robot.generateWSDLDocumentation(WSDLDOC_WORD_PNG_NOTEMBED_MULTIFILE,WSDL_DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+".doc"));
		assertFileExists(new File(fullpath+"_getBalanceInf.doc"));
		assertFileExists(new File(fullpath+"_Name.doc"));
		assertFileExists(new File(fullpath+"_SIN.doc"));
		assertFileExists(new File(fullpath+"_InternalElement.doc"));
		assertFileNotExists(new File(fullpath+"_Name1.doc"));
		assertFileNotExists(new File(fullpath+"_SIN1.doc"));
		for (int i = 1; i < 5; i++) {
			assertImage(new File(BASE_EXPECTED_DIR+"\\testGenerateWSDLDocum_WORD_PNG_NotEmbed_MultiFile\\"+WSDL_DOCUM_FILENAME+"_p"+i+".png"), new File(fullpath+"_p"+i+".png"));
		}
		for (int i = 5; i < 7; i++) {
			assertFileNotExists( new File(fullpath+"_p"+i+".png"));
		}
	}
	
	 
	@Test //result is not correct at the moment: #33464 needs to be fixed 
	public void testGenerateWSDL20Documentation_WORD_EMF_NotEmbed_MultiFile() {
		robot.openFile(MULTIPLEWSDLIMPORTS_WSDL20_FILE);
		IOUtils.deleteAll(WSDLDOC_WORD_EMF_NOTEMBED_MULTIFILE);
		String fullpath=WSDLDOC_WORD_EMF_NOTEMBED_MULTIFILE.getAbsolutePath()+"\\"+WSDL_DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+"_InterfaceToBeImported1.doc"));
		Options options=new Options();
		options.add(new RadioOption(" Microsoft Word", "Output format", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new RadioOption("EMF", null, null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Embed diagrams",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation",false));
		robot.generateWSDLDocumentation(WSDLDOC_WORD_EMF_NOTEMBED_MULTIFILE,WSDL_DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+".doc"));
		assertFileExists(new File(fullpath+"_InterfaceToBeImported1.doc"));
		assertFileExists(new File(fullpath+"_NewInterface.doc"));
		assertFileExists(new File(fullpath+"_NewBinding.doc"));
		assertFileExists(new File(fullpath+"_NewService.doc"));
		assertFileExists(new File(fullpath+"_BindingTest.doc"));
		assertFileExists(new File(fullpath+"_InterfaceToBeImported2.doc"));
		assertFileExists(new File(fullpath+"_Interface1.doc"));
		assertFileExists(new File(fullpath+"_Interface2.doc"));
		assertFileExists(new File(fullpath+"_NewMessageRequest.doc"));
		assertFileExists(new File(fullpath+"_NewMessageResponse.doc"));
		assertFileExists(new File(fullpath+"_Name.doc"));
		assertFileExists(new File(fullpath+"_SIN.doc"));
		assertFileNotExists(new File(fullpath+"_Name1.doc"));
		assertFileNotExists(new File(fullpath+"_SIN1.doc"));
		assertFileExists(new File(fullpath+"_elementRequest.doc"));
		assertFileExists(new File(fullpath+"_elementResponse.doc"));
		
		for (int i = 1; i < 15; i++) {
			assertFileExists(new File(fullpath+"_p"+i+".emf"));
		}
		for (int i = 15; i < 17; i++) {
			assertFileNotExists(new File(fullpath+"_p"+i+".emf"));
		}
	}
	
	@Test 
	public void testGenerateWSDL20Documentation_RTF_PNG_NotEmbed_MultiFile() {
		robot.openFile(XSDIMPWITHINLSCHEMA_WSDL20_FILE);
		IOUtils.deleteAll(WSDLDOC_RTF_PNG_NOTEMBED_MULTIFILE);
		String fullpath=WSDLDOC_RTF_PNG_NOTEMBED_MULTIFILE.getAbsolutePath()+"\\"+WSDL_DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+"_Name.rtf"));
		Options options =new Options();
		options.add(new RadioOption(" RTF", "Output format", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new RadioOption("PNG", null, null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Embed diagrams",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation",false));
		robot.generateWSDLDocumentation(WSDLDOC_RTF_PNG_NOTEMBED_MULTIFILE,WSDL_DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+"_Name.rtf"));
		assertFileExists(new File(fullpath+"_ElementInside.rtf"));
		assertFileExists(new File(fullpath+".rtf"));
		assertFileExists(new File(fullpath+"_Name1.rtf"));
		assertFileExists(new File(fullpath+"_SIN.rtf"));
		
		for (int i = 1; i < 5; i++) {
			assertImage(new File(BASE_EXPECTED_DIR+"\\testGenerateWSDLDocum_RTF_PNG_Notembed_MultiFile\\"+WSDL_DOCUM_FILENAME+"_p"+i+".png"), new File(fullpath+"_p"+i+".png"));
		}
		
	}
	
	@Test
	public void testGenerateWSDL20Documentation_RTF_EMF_NotEmbed_OneFile() {
		robot.openFile(TIMESERVICE_WSDL20_FILE);
		IOUtils.deleteAll(WSDLDOC_RTF_EMF_NOTEMBED_ONEFILE);
		String fullpath=WSDLDOC_RTF_EMF_NOTEMBED_ONEFILE.getAbsolutePath()+"\\"+WSDL_DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+".rtf"));
		Options options=new Options();
		options.add(new RadioOption(" RTF", "Output format", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new RadioOption("EMF", null, null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Embed diagrams",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation",false));		
		robot.generateWSDLDocumentation(WSDLDOC_RTF_EMF_NOTEMBED_ONEFILE,WSDL_DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+".rtf"));
		for (int i = 1; i < 20; i++) {
			assertFileExists(new File(fullpath+"_p"+i+".emf"));
		}
	}
	
	@Test
	public void testGenerateWSDL20Documentation_RTF_EMF_Embed_MultiFile() {
		robot.openFile(XSDINCLUDEDANDIMPORTED_WSDL20_FILE);
		IOUtils.deleteAll(WSDLDOC_RTF_EMF_EMBED_MULTIFILE);
		String fullpath=WSDLDOC_RTF_EMF_EMBED_MULTIFILE.getAbsolutePath()+"\\"+WSDL_DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+"_accInfo.rtf"));
		Options options=new Options();
		options.add(new RadioOption(" RTF", "Output format", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new RadioOption("EMF", null, null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Embed diagrams",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation",false));		
		robot.generateWSDLDocumentation(WSDLDOC_RTF_EMF_EMBED_MULTIFILE,WSDL_DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+".rtf"));
		assertFileExists(new File(fullpath+"_accInfo.rtf"));
		assertFileExists(new File(fullpath+"_accinfct.rtf")); //
		assertFileExists(new File(fullpath+"_custInfo.rtf"));
		assertFileExists(new File(fullpath+"_cinfoct.rtf")); //
		assertFileExists(new File(fullpath+"_getBalanceInf.rtf"));
		assertFileExists(new File(fullpath+"_InternalElement.rtf"));
		assertFileExists(new File(fullpath+"_Name.rtf"));
		assertFileExists(new File(fullpath+"_SIN.rtf"));
		for (int i = 1; i < 7; i++) {
			assertFileNotExists(new File(fullpath+"_p"+i+".emf"));
		}
	}
}
