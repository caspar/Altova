package com.altova.spy;

import static com.altova.robots.ImageRecognitionRobot.WINDOWS_DEFAULT_FONT;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.spy.SpyRobot.*;

import java.io.File;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.Options;
import com.altova.robots.RadioOption;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.IOUtils;
import com.altova.util.Settings;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;

//@TestRobot(VSnetSpyRobot.class)
//@TestRobot(EclipseSpyRobot.class)
public class WSDLMenuTest extends AbstractXmlSpyTest {

	protected static final String New_message = "getAreaTime";
	protected static final String Porttype_path = "/definitions/portType[@name=\'TimeServiceHttpGet\']";
	protected static final String New_parameter = "time";
	protected static final String New_porttype = "TimeServiceNewPort";
	private static final String New_operation_request = "NewOperationRequest";
	private static final String New_operation_solicit = "NewOperationSolicit";
	private static final String New_operation_oneway = "NewOperationOneway";
	private static final String New_operation_notification = "NewOperationNotification";
	private static final String New_empty_operation = "NewEmptyOperation";
	private static final String Operation_path_noName = "/definitions/portType[@name=\'TimeServiceHttpGet\']/operation[@name=";
	private static final String OperationgetServerCity_path = Operation_path_noName
			+ "\'getServerCity\']";
	private static final String Input_Element_In_Operation_path = OperationgetServerCity_path
			+ "/input";
	private static final String New_empty_operation_path = Operation_path_noName
			+ "\'" + New_empty_operation + "\']";
	private static final String New_binding = "TimeServiceNewBinding";
	private static final String Binding_path = "/definitions/binding[@name=\'TimeServiceSoap\']";
	private static final String Service_path = "/definitions/service[@name=\'TimeService\']";
	private static final String Port_path = "/definitions/service/port[@name=\'TimeServiceHttpGet\']";
	private static final String InputMessage_InSOAPBinding_path = Binding_path
			+ "/operation[@name=\'getUTCTime\']/input";
	private static final String ChildInSOAPBinding_path = InputMessage_InSOAPBinding_path
			+ "/soap:body";
	private static final String FaultElement_In_operation = "/definitions/portType[@name=\'TimeServiceSoap\']/operation[@name=\'getUTCTime\']";
	private static final String FaultElement_path = Binding_path
			+ "/operation[@name=\'getUTCTime\']/fault";
	private static final String InputMessage_InHTTPBinding_path = "/definitions/binding[@name=\'TimeServiceHttpGet\']/operation[\'getUTCTime\']/input";
	private static final String ChildInHTTPBinding_path = InputMessage_InHTTPBinding_path
			+ "/http:urlEncoded";
	
	//private static final String BASE_OUT_DIR= Settings.getOutputDir().getAbsolutePath()+"\\"+AltovaJUnitRunner.getRunName(robot,"WSDLMenuTest");
	private static final String BASE_OUT_DIR = new File(IOUtils.findFile("/spy/output/GenerateWSDL11Doc").toString()).getAbsolutePath(); 
	//private static final String BASE_EXPECTED_DIR=Settings.getExpectedDir().getAbsolutePath()+"\\"+AltovaJUnitRunner.getRunName(robot,"WSDLMenuTest");
	private static final String BASE_EXPECTED_DIR=new File(IOUtils.findFile("/spy/reference/GenerateWSDL11Doc").toString()).getAbsolutePath();
	private static final String DIAGRAM_FILENAME = "Diagram_wsdl.png";
	private static final String DIAGRAM_ABSPATH =BASE_OUT_DIR+"\\"+DIAGRAM_FILENAME ;
	private static final File  DIAGRAM_ABSPATH_FILE = new File(DIAGRAM_ABSPATH);
	
	protected final File WSDLDOC_HTML_ONEFILE = new File(BASE_OUT_DIR+"\\testGenerateWSDLDocum_HTML_OneFile");

	protected final File WSDLDOC_WORD_EMF_EMBED_ONEFILE = new File(BASE_OUT_DIR+"\\testGenerateWSDLDocum_WORD_EMF_Embed_OneFile");

	protected final File WSDLDOC_RTF_PNG_EMBED_ONEFILE = new File(BASE_OUT_DIR+"\\testGenerateWSDLDocum_RTF_PNG_Embed_OneFile");
	private static final String WSDL_DOCUM_FILENAME = "DocGenWSDL";
	
	protected static final File CONVERTTOWSDL2_WSDL_FILE = new File("C:\\temp\\ConvertToWSDL2.wsdl");

	@Before
	public void setUp() {
		
		robot.openFile(TIMESERVICE_WSDL_FILE.toString());
		robot.maximizeFileWindow();
		
	}
	
	@Test 
	public void testInsertWSDLMessage() {
		robot.insertWSDLMessage();
		assertAreas(OVERVIEW);
	}
	
	@Test
	public void testDeleteWSDLMessage() {

		robot.insertWSDLMessage(New_message);
		robot.deleteWSDLMessage();
		assertAreas(OVERVIEW);
	}

	@Test
	public void testAddWSDLMessageParameter() {
		robot.insertWSDLMessage(New_message);
		robot.addWSDLMessageParameter(New_parameter);
		assertAreas(OVERVIEW);
	}

	@Test
	public void testDeleteWSDLMessageParameter() {
		robot.insertWSDLMessage(New_message);
		robot.addWSDLMessageParameter(New_parameter);
		robot.deleteWSDLMessageParameter();
		assertAreas(OVERVIEW);
	}

	@Test
	public void testAppendOperationRequest() {
		robot.xpathHighlight(Porttype_path);
		robot.appendOperationRequest(New_operation_request);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAppendOperationSolicit() {
		robot.xpathHighlight(Porttype_path);
		robot.appendOperationSolicit(New_operation_solicit);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAppendOperationOneWay() {
		robot.xpathHighlight(Porttype_path);
		robot.appendOperationOneWay(New_operation_oneway);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAppendOperationNotification() {
		robot.xpathHighlight(Porttype_path);
		robot.appendOperationNotification(New_operation_notification);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAppendEmptyOperation() {
		robot.xpathHighlight(Porttype_path);
		robot.appendEmptyOperation(New_empty_operation);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testDeleteOperation() {
		robot.xpathHighlight(OperationgetServerCity_path);
		robot.deleteOperation();
		assertAreas(DIAGRAM_MAIN_WINDOW);

	}

	@Test
	public void testAddInputElementToOperation() {
		robot.xpathHighlight(Porttype_path);
		robot.appendEmptyOperation(New_empty_operation);
		robot.xpathHighlight(New_empty_operation_path);
		robot.addInputElementToOperation("s0:TestAddElementSoapIn");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAddOutputElementToOperation() {
		robot.xpathHighlight(Porttype_path);
		robot.appendEmptyOperation(New_empty_operation);
		robot.xpathHighlight(New_empty_operation_path);
		robot.addOutputElementToOperation("s0:TestAddElementSoapOut");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAddFaultElementToOperation() {
		robot.xpathHighlight(OperationgetServerCity_path);
		robot.addFaultElementToOperation("s0:TestAddElementFault");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testDeleteAnyOperationElement() {
		robot.xpathHighlight(Input_Element_In_Operation_path);
		robot.deleteAnyOperationElement();
		assertAreas(DIAGRAM_MAIN_WINDOW);

	}

	@Test
	public void testAddNewMessageToElementOperation() {
		robot.xpathHighlight(Input_Element_In_Operation_path);
		robot.addNewMessageToElementOperation("s0:MessageChanged");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testInsertPorttype() {
		robot.insertPorttype(New_porttype);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testDeletePorttype() {
		robot.xpathHighlight(Porttype_path);
		robot.deletePorttype();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testInsertBinding() {
		robot.insertBinding(New_binding);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testDeleteBinding() {
		robot.xpathHighlight(Binding_path);
		robot.deleteBinding();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAppendSoapBodyInBinding() {
		robot.xpathHighlight(ChildInSOAPBinding_path);
		robot.deleteExtensibilityElement();
		robot.xpathHighlight(InputMessage_InSOAPBinding_path);
		robot.appendSoapBodyInBinding();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAppendSoapHeaderInBinding() {
		robot.xpathHighlight(InputMessage_InSOAPBinding_path);
		robot.appendSoapHeaderInBinding("Hello world");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAppendSoapHeaderfaultInBinding() {
		robot.xpathHighlight(InputMessage_InSOAPBinding_path);
		robot.appendSoapHeaderInBinding("Hello world");
		robot.appendSoapHeaderfaultInBinding("Hello everybody");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAppendSoapFaultInBinding() {
		robot.xpathHighlight(FaultElement_In_operation);
		robot.addFaultElementToOperation("s0:TestAddElementFault");
		robot.xpathHighlight(FaultElement_path);
		robot.appendSoapFaultInBinding("Pepe and Paco");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAppendMimeContentInBinding() {
		robot.xpathHighlight(ChildInSOAPBinding_path);
		robot.deleteExtensibilityElement();
		robot.xpathHighlight(InputMessage_InSOAPBinding_path);
		robot.appendMimeContentInBinding();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAppendMimeMultipartrelatedInBinding() {
		robot.xpathHighlight(ChildInSOAPBinding_path);
		robot.deleteExtensibilityElement();
		robot.xpathHighlight(InputMessage_InSOAPBinding_path);
		robot.appendMimeMultipartrelatedInBinding();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAppendMimePartInBinding() {
		robot.xpathHighlight(ChildInSOAPBinding_path);
		robot.deleteExtensibilityElement();
		robot.xpathHighlight(InputMessage_InSOAPBinding_path);
		robot.appendMimeMultipartrelatedInBinding();
		robot.appendMimePartInBinding();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAppendMimeMimeXmlInBinding() {
		robot.xpathHighlight(ChildInSOAPBinding_path);
		robot.deleteExtensibilityElement();
		robot.xpathHighlight(InputMessage_InSOAPBinding_path);
		robot.appendMimeMimeXmlInBinding();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAppendHttpUrlreplacementInBinding() {
		robot.xpathHighlight(ChildInHTTPBinding_path);
		robot.deleteExtensibilityElement();
		robot.xpathHighlight(InputMessage_InHTTPBinding_path);
		robot.appendHttpUrlreplacementInBinding();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testAppendHttpUrlencodedInBinding() {
		robot.xpathHighlight(ChildInHTTPBinding_path);
		robot.deleteExtensibilityElement();
		robot.xpathHighlight(InputMessage_InHTTPBinding_path);
		robot.appendHttpUrlencodedInBinding();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testDeleteExtensibilityElement() {
		robot.xpathHighlight(ChildInHTTPBinding_path);
		robot.deleteExtensibilityElement();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testDeleteService() {
		robot.xpathHighlight(Service_path);
		robot.deleteService();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testInsertPortInService() {
		robot.xpathHighlight(Service_path);
		robot.insertPortInService("TimeServieHttpTest");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testDeletePortInService() {
		robot.xpathHighlight(Port_path);
		robot.deletePortInService();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testNewWSDLSchema() {
		robot.gridView();
		robot.xpathHighlight("/definitions/types");
		robot.textView();
		robot.delete();
		robot.wsdlView();
		robot.newWSDLSchema();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testEditWSDLSchema() {
		robot.editWSDLSchema();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testSaveWSDLDiagram() {
		removeAndAssert(DIAGRAM_ABSPATH_FILE);
		robot.saveWSDLDiagram(DIAGRAM_ABSPATH);
		assertFileExists(DIAGRAM_ABSPATH_FILE);
		assertImage(new File(BASE_EXPECTED_DIR+"\\"+DIAGRAM_FILENAME), DIAGRAM_ABSPATH_FILE);
	}
	
	@Test 
	public void testGenerateWSDLDocumentation_HTML_OneFile() {
		robot.openFile(TIMESERVICESMALL_WSDL_FILE);
		IOUtils.deleteAll(WSDLDOC_HTML_ONEFILE);
		String fullpath=WSDLDOC_HTML_ONEFILE.getAbsolutePath()+"\\"+WSDL_DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+".html"));
		Options options=new Options();
		options.add(new RadioOption(" HTML", "Output format", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation",true));
		options.add(new CheckboxOption("Embed CSS in HTML",false,null,null,null,null,WINDOWS_DEFAULT_FONT));;
		robot.generateWSDLDocumentation(WSDLDOC_HTML_ONEFILE,WSDL_DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+".html"));
		assertFileExists(new File(fullpath+".css")); 
		assertAreas(DIAGRAM_MAIN_WINDOW);
		for (int i = 1; i < 9; i++) {
			assertImage(new File(BASE_EXPECTED_DIR+"\\testGenerateWSDLDocum_HTML_OneFile\\"+WSDL_DOCUM_FILENAME+"_p"+i+".png"), new File(fullpath+"_p"+i+".png"));
		}
	}

	
	@Test
	public void testGenerateWSDLDocumentation_WORD_EMF_Embed_OneFile() {
		robot.openFile(TIMESERVICE_WSDL_FILE);
		IOUtils.deleteAll(WSDLDOC_WORD_EMF_EMBED_ONEFILE);
		String fullpath=WSDLDOC_WORD_EMF_EMBED_ONEFILE.getAbsolutePath()+"\\"+WSDL_DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+".doc"));
		Options options=new Options();
		options.add(new RadioOption(" Microsoft Word", "Output format", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new RadioOption("EMF", null, null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Embed diagrams",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation",false));
		robot.generateWSDLDocumentation(WSDLDOC_WORD_EMF_EMBED_ONEFILE,WSDL_DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+".doc"));
		for (int i = 1; i < 23; i++) {
			assertFileNotExists(new File(fullpath+"_p"+i+".emf"));
		}
	}
	
	@Test 
	public void testGenerateWSDLDocumentation_RTF_PNG_Embed_OneFile() {
		robot.openFile(DOCGEN_WSDL_FILE);
		IOUtils.deleteAll(WSDLDOC_RTF_PNG_EMBED_ONEFILE);
		String fullpath=WSDLDOC_RTF_PNG_EMBED_ONEFILE.getAbsolutePath()+"\\"+WSDL_DOCUM_FILENAME;
		assertFileNotExists(new File(fullpath+".rtf"));
		Options options=new Options();
		options.add(new RadioOption(" RTF", "Output format", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new RadioOption("PNG", null, null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Embed diagrams",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Split output to multiple files",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Show result file after generation",false));
		robot.generateWSDLDocumentation(WSDLDOC_RTF_PNG_EMBED_ONEFILE,WSDL_DOCUM_FILENAME,options);
		assertFileExists(new File(fullpath+".rtf"));
		for (int i = 1; i < 43; i++) {
			assertFileNotExists(new File(fullpath+"_p"+i+".png"));
		}
	}
	
	@Test 
	public void testReparseWSDLDocument() {
		robot.openFile(MULTIPLEWSDLINCLUDES_WSDL20_FILE);
		robot.openFile(IOUtils.findFile("spy/examples/Description1.wsdl"));
		robot.addNewInterfaceWSDL20("MyAddedInterface");
		robot.addNewFaultWSDL20("MyAddedFault");
		robot.addNewOperationWSDL20("Robust-in-only", "MyAddedOperation");
		robot.openFile(MULTIPLEWSDLINCLUDES_WSDL20_FILE);
		robot.reparseWSDLDocument();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testConvertToWSDL20(){
		removeAndAssert(CONVERTTOWSDL2_WSDL_FILE);
		robot.convertToWSDL20(CONVERTTOWSDL2_WSDL_FILE);
		delay(500);
		assertFileExists(CONVERTTOWSDL2_WSDL_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
}
