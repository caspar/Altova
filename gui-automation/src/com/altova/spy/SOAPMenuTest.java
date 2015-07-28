package com.altova.spy;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import java.io.File;

import com.altova.robots.ScriptMistakeException;
import com.altova.util.IOUtils;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;
import static com.altova.spy.SpyRobot.MESSAGES;
import static com.altova.util.LoggerUtils.logger;

import static java.awt.event.KeyEvent.VK_N;
import static java.awt.event.KeyEvent.VK_ENTER;

//@TestRobot(VSnetSpyRobot.class)
//@TestRobot(EclipseSpyRobot.class)
public class SOAPMenuTest extends AbstractXmlSpyTest {

	private static final File TIMESERVICE_WSDL_FILE = IOUtils.findFile("spy/examples/TimeService.wsdl");
	private static final File TIMESERVICE20_WSDL_FILE = IOUtils.findFile("spy/examples/TimeService20.wsdl");
	private static final File SERVERCITY_SOAP_RESPONSE = IOUtils.findFile("spy/examples/serverCitySOAPResponse.xml");
	private static final String timeoperation = "getServerTime";
	private static final String operation = "getServerCity";
	private static final String cityTime = "getCityTime";
	private static final String getTime = "GetTime";
	private static final String soapaction = "http://www.Nanonull.com/TimeService/"+operation;
	private static final String wrongEndpoint = "http://www.Nanonull.com/TimeService/TimeService_error.asmx";
	
	//WS Security/HTTP Authentication settings
	private static final String timeServiceAuth     = "http://vietwss01.vie.altova.com:8080/timeserviceauth/TimeService?wsdl";
	private static final String timeServiceAuthPree = "http://vietwss01.vie.altova.com:8080/timeservicepreemptive/TimeService?wsdl";
	private static final String timeServiceWSSDigest= "http://vietwss01.vie.altova.com:8080/timeservicedigest/TimeService?wsdl";
	private static final String HTTP_authentication_user = "tomcat";
	private static final String HTTP_authentication_pwd = "tomcat";
	private static final String WSS_user = "code";
	private static final String WSS_pwd = "pass"+ WSS_user;
	
	
	private static final String TTPFilePath = "S:\\QA\\internal\\Regressiontest\\XMLSpy\\SOAP-WSDL\\TTP";
	
	
	@Before
	public void setUp() throws Exception {

		//overriding the setUp methd in AbstractXmlSpyTest,
		//the SOAPMenuTest will avoid the loading of OrgChart.xml
		//that only wastes times.
	}

	@BeforeClass
	public static void init() throws Exception {

		robot.openFile(ORGCHART_XML_FILE.getAbsolutePath(), false, null);
	}
	
	@Test
	@IgnoreRobots(EclipseSpyRobot.class)
	public final void testCreateSOAPRequest() {
		robot.createSOAPRequest(TIMESERVICE_WSDL_FILE.getAbsolutePath(),timeoperation);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	@IgnoreRobots(EclipseSpyRobot.class)
	public final void testSendRequestToServer() {
		robot.createSOAPRequest(TIMESERVICE_WSDL_FILE.getAbsolutePath(), operation);
		robot.sendSOAPrequest();
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	@IgnoreRobots(EclipseSpyRobot.class)
	public final void testSendRequestToServer_parameter() {
		robot.createSOAPRequest(TIMESERVICE_WSDL_FILE.getAbsolutePath(), cityTime);
		robot.replaceFirst("String", "Vienna");
		robot.sendSOAPrequest();
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	@IgnoreRobots(EclipseSpyRobot.class)
	public final void testSendRequestToServer_HTTPAuthentication() {
		
		robot.createSOAPRequest(timeServiceAuth, getTime);
		robot.sendSOAPRequest_HTTPSecuritySettings(HTTP_authentication_user, HTTP_authentication_pwd, null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	@IgnoreRobots(EclipseSpyRobot.class)
	public final void testSendRequestToServer_HTTPAuthenticationPreemptive() {
		
		robot.createSOAPRequest(timeServiceAuthPree, getTime);
		robot.sendSOAPRequest_HTTPSecuritySettings(HTTP_authentication_user, HTTP_authentication_pwd, true);
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	@IgnoreRobots(EclipseSpyRobot.class)
	public final void testSendRequestToServer_WSSecurityDigest(){
		
		robot.createSOAPRequest(timeServiceWSSDigest, getTime);
		robot.sendSOAPRequest_WSSecuritySettings(WSS_user, WSS_pwd, true, true, true, null);
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	@IgnoreRobots(EclipseSpyRobot.class)
	public final void testChangeSOAPParameters_SOAPAction() {
		robot.createSOAPRequest(TIMESERVICE_WSDL_FILE.getAbsolutePath(), timeoperation);
		robot.SOAPRequestSettings_SOAPSettings(soapaction, null);
		robot.sendSOAPrequest();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	@IgnoreRobots(EclipseSpyRobot.class)
	public final void testChangeSOAPParameters_SOAPActionError() {
		robot.createSOAPRequest(TIMESERVICE_WSDL_FILE.getAbsolutePath(), timeoperation);
		robot.SOAPRequestSettings_SOAPSettings(soapaction+"_error", null);
		robot.sendSOAPrequest();
		
		delay(1000);
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
	}
	@Test
	@IgnoreRobots(EclipseSpyRobot.class)
	public final void testChangeSOAPParameters_EndpointError() {
		robot.createSOAPRequest(TIMESERVICE_WSDL_FILE.getAbsolutePath(), timeoperation);
		robot.SOAPRequestSettings_ConnectionSettings(wrongEndpoint, null);
		
		robot.escapeDialog("You´ve changed or removed the path to the webservice", VK_N);
		robot.clickButton("No");
		robot.sendSOAPrequest();
		
		delay(1000);
		assertAreas(TOP_WINDOW);
		
		delay(2500);
		robot.escapeDialog("XMLSpy", VK_ENTER);

	}
	
	
	
	//windows will just match if the whole SOAP Menu Test is run but will not if done independently
	@Test
	public final void testSOAPDebuggerSession() {
		robot.SOAPDebuggerSession();
		
	}

	@Test
	public final void testSOAPDebuggerOptions() {
		robot.SOAPDebuggerOptions();
	}
	
	//Test the customer and general TTP
	
	@Test
	public final void testTTP_355() {
		fail("Test case will fail until TTP 39124 is not fixed");
		robot.createSOAPRequest(TTPFilePath + "\\355\\TweakedHelloWorld.wsdl", "HelloWorld");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_854() {
		robot.createSOAPRequest(TTPFilePath + "\\854\\wsdlexplained.wsdl");
		assertAreas(getTestName()+ "_SOAPOperation", TOP_WINDOW);
		
		robot.selectSOAPRequest(false,"foo( int arg )");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_1359() {
		robot.createSOAPRequest(TTPFilePath + "\\1359\\GoogleSearch.wsdl", "doGoogleSearch");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_1911() {
		robot.createSOAPRequest(TTPFilePath + "\\1911\\min.wsdl", "ThisShouldNotBe");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	/*
	 * This test case could fail because is connecting
	 * with a 3rd part web service that could change or delete  
	 * the use of the web service in any moment.
	 */
	@Test
	public final void testTTP_2343() {
		robot.createSOAPRequest(" http://www.webservicex.net/usweather.asmx?WSDL", "USWeatherSoap", "GetWeatherReport");
		robot.replaceFirst("String", "asdfg");
		robot.sendSOAPrequest();
		
		robot.escapeDialog("HTTP error", VK_ENTER);
		robot.escapeDialog("Error sending the soap data", VK_ENTER);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_2418() {
		robot.createSOAPRequest(TTPFilePath + "\\2418\\creationOrdreBF.wsdl", "CreationOrdre1", "getPrestation");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_2571() {
		robot.createSOAPRequest(TTPFilePath + "\\2571\\user.wsdl", "getUser");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	} 
	
	@Test
	public final void testTTP_3522() {
		robot.createSOAPRequest(TTPFilePath + "\\3522\\VehicleInventory.wsdl", "Inventory");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	} 
	
	@Test
	public final void testTTP_3626() {
		robot.createSOAPRequest(TTPFilePath + "\\3626\\NORA.wsdl", "login");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	} 
	
	@Ignore //now the web service requires user and password that customer doesn't provide 
	@Test
	public final void testTTP_3972() {
		robot.createSOAPRequest(TTPFilePath + "\\3972\\soapauthtest.wsdl", "echoString");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	} 
	
	@Test
	public final void testTTP_6293() {
		robot.createSOAPRequest(TTPFilePath + "\\6293\\PayoffQuote\\PayoffQuote20040601v1.0.wsdl", "PayoffQuoteUpdate");
		robot.find("</PrepaymentPenaltyDesc>");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	} 
	
	@Test
	public final void testTTP_6376() {
		robot.createSOAPRequest(TTPFilePath + "\\6376\\Miaftr2_Claims_Service_V1_0.wsdl", "Logon", "RequestLogon");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_8186() {
		robot.createSOAPRequest(TTPFilePath + "\\8186\\parlayx_audio_call_service_2_0.wsdl", "extMessage");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_9392() {
		robot.createSOAPRequest(TTPFilePath + "\\9392\\test.wsdl", "getDeviceList");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_9421() {
		robot.createSOAPRequest(TTPFilePath + "\\9421\\binding.wsdl", "o1");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_9766() {
		robot.createSOAPRequest(TTPFilePath + "\\9766\\Greeting.wsdl", "process");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_11640() {
		robot.createSOAPRequest(TTPFilePath + "\\11640\\test.wsdl", "UPDTS");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_12799() {
		robot.createSOAPRequest(TTPFilePath + "\\12799\\AUSKN.wsdl", "AUSKN");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_13441() {
		robot.createSOAPRequest(TTPFilePath + "\\13441\\MmspOrdering.wsdl", "NewMMA","NewMMA");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_13760() {
		robot.createSOAPRequest(TTPFilePath + "\\13760\\GetLeadInfo.wsdl", "getLead");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_14140() {	
		robot.createSOAPRequest("http://www.pocketsoap.com/services/ilab.wsdl", "echoString");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_24307() {
		robot.createSOAPRequest(TTPFilePath + "\\24307\\test.wsdl", "request_tal_n");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_27028() {
		robot.createSOAPRequest(TTPFilePath + "\\27028\\service.wsdl", "DeterminePricingStrategy");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	//setEncoding(String) method is still not correctly implemented
	@Ignore
	@Test
	public final void testTTP_28298() { //no customer sample available: using TimeService
		robot.createSOAPRequest(TIMESERVICE_WSDL_FILE.getAbsolutePath(), operation);
		robot.setEncoding("Unicode UTF-16");
		robot.sendSOAPrequest();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_31302() { 
		robot.openFile(TTPFilePath + "\\31302\\globalweather.wsdl");
		robot.XMLCheckWellFormedness();
		assertAreas(getTestName()+ "_WellFormedness", MESSAGES);
		
		robot.validate();
		assertAreas(getTestName()+ "_Validate", MESSAGES);
		
		robot.createSOAPRequest20(TTPFilePath + "\\31302\\globalweather.wsdl", "Global", "GetWeather");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_31737() { 
		
		robot.createSOAPRequest(TTPFilePath + "\\31737\\07-porttype-notification-operation11.wsdl");
		assertAreas(TOP_WINDOW);
		
		robot.escapeDialog("Please select a SOAP Operation", VK_ENTER);
	}
	
	@Test
	public final void testTTP_32439() { 
		
		robot.openFile(TIMESERVICE20_WSDL_FILE);
		robot.textView();
		robot.replaceFirst("http://www.Nanonull.com/TimeService/TimeService.asmx", "http://www.Nanonull.com/TimeService/TimeService_Error.asmx");
		robot.createSOAPRequest20(TIMESERVICE20_WSDL_FILE.getAbsolutePath(), timeoperation);
		robot.sendSOAPrequest();
		delay(4000);
		
		assertAreas(TOP_WINDOW);
	}

	@Test
	public final void testTTP_32472() {
		robot.createSOAPRequest20(TTPFilePath + "\\32472\\Test.wsdl", "StockQuote", "LastTrade");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public final void testTTP_32804() {
		robot.createSOAPRequest(TTPFilePath + "\\32804\\VehicleInventory.wsdl", "Inventory");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_33706() {
		robot.createSOAPRequest(TTPFilePath + "\\33706\\WSDL_wM6.1.wsdl", "remove");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_34290_1() {
		robot.createSOAPRequest(TTPFilePath + "\\34290\\deadoralive.wsdl", "Birthdays");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testTTP_34290_2() {
		robot.createSOAPRequest(TTPFilePath + "\\34290\\TimeServiceErr.wsdl");
		assertAreas(TOP_WINDOW);
		
		robot.escapeDialog("XMLSpy", VK_ENTER);

	}
	
	@Test
	public final void testTTP_34293() {
		
		removeAndAssert(SERVERCITY_SOAP_RESPONSE);
		robot.createSOAPRequest(TIMESERVICE_WSDL_FILE.getAbsolutePath(), operation);
		robot.saveFileAs(SERVERCITY_SOAP_RESPONSE.getAbsolutePath());
		robot.closeAll();
		
		robot.openFile(SERVERCITY_SOAP_RESPONSE);
		robot.sendSOAPrequest();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public final void testTTP_34338() {
		robot.openFile(TIMESERVICE_WSDL_FILE);
		robot.textView();
		robot.replaceFirst("http://www.nanonull.com/TimeService/TimeService.asmx", "http://www.nanonull.com/TimeService/TimeService.asmx#&amp;");
		robot.createSOAPRequest(TIMESERVICE_WSDL_FILE.getAbsolutePath(), operation);
		robot.sendSOAPrequest();
		
		robot.escapeDialog("HTTP error", VK_ENTER);
		robot.escapeDialog("Error sending the soap data", VK_ENTER);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_34411() {
		
		robot.openFile(TTPFilePath + "\\34411\\RequestResponeSOAPValidation.wsdl");
		robot.textView();
		robot.gotoLine(1, 1);
		robot.find("<wsdl:input message=\"tns:inDateTime\"/>");
		robot.wsdlView();
		robot.appendOperationRequest(null);
		robot.textView();
		robot.replaceFirst("tns:NewMessage2", "tns:inTest");
		robot.replaceFirst("tns:NewMessage3", "tns:outTest");
		robot.wsdlView();
		robot.XMLCheckWellFormedness();
		assertAreas(getTestName()+ "_WellFormedness", MESSAGES);
		
		robot.validate();
		assertAreas(getTestName()+ "_Validate", MESSAGES);
	
		robot.createSOAPRequest(TTPFilePath + "\\34411\\RequestResponeSOAPValidation.wsdl");
		
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
			
	}
	
	@Test
	public final void testTTP_34518() {
		
		robot.createSOAPRequest(TTPFilePath + "\\34518\\RequestResponeSOAPValidation.wsdl", "ExternalService", "Extra");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testTTP_34521() {
		robot.createSOAPRequest(TTPFilePath + "\\34521\\RequestResponeSOAPValidation20.wsdl");
		assertAreas(TOP_WINDOW);
		
		robot.escapeDialog("XMLSpy", VK_ENTER);

	}
	
	@Test
	public final void testTTP_34537() {
		
		File SOAPRequestFile = new File(TTPFilePath + "\\34537\\ComplexBoolean_SOAPRequest.xml");
		
		removeAndAssert(SOAPRequestFile);
		robot.createSOAPRequest(TTPFilePath + "\\34537\\RequestResponeSOAPValidation.wsdl", "NewService", "ComplexBoolean");
		robot.textView();
		robot.replaceFirst("true", "false");
		robot.validate();
		robot.delay(500);
		robot.validate();
		robot.delay(500);
		robot.validate();
		
		robot.saveFileAs(SOAPRequestFile.getAbsolutePath());
		assertFileExists(SOAPRequestFile);
		
		robot.validate();
		assertAreas(MESSAGES);
		
		
	}
	
	@Test
	@Ignore
	public final void testTTP_35549() {
		
		//fail("run only when TTP 35549 is fixed"); // TODO
		//due to TTP 35549 is "not a bug", this test is now ignored
		robot.createSOAPRequest(TTPFilePath + "\\34537\\RequestResponeSOAPValidation.wsdl", "NewService", "ComplexnonNegativeInteger");
		robot.validate();
		assertAreas(DIAGRAM_MAIN_WINDOW, MESSAGES);
		 	
	}
	
	
	@Test
	public final void testTTP_35371() {
		
		robot.createSOAPRequest(TTPFilePath + "\\35371\\EasyWMSModuleService.wsdl", "RemoveUserAccount");
		assertAreas(DIAGRAM_MAIN_WINDOW);
		 	
	}
	
	@Test
	public final void testTTP_35394_1() {
		
		robot.createSOAPRequest("http://www.nanonull.com/TimeService/TimeService.asmx?WSDL", "TimeServiceSoap", operation);
		robot.sendSOAPrequest();
		assertAreas(DIAGRAM_MAIN_WINDOW);
		 	
	}
	
	@Test
	public final void testTTP_35394_2() {
		
		robot.createSOAPRequest("http://www.nanonull.com/TimeService/TimeService.asmx?WSDL", "TimeServiceSoap12", operation);
		robot.sendSOAPrequest();
		assertAreas(DIAGRAM_MAIN_WINDOW);
		 	
	}
	
	@Test
	public final void testTTP_37069_1() {
		
		robot.openFile(TTPFilePath + "\\37069\\Response_token.xml");
		robot.XMLCheckWellFormedness();
		assertAreas(MESSAGES);
		 	
	}
	
	@Test
	public final void testTTP_37069_2() {
		
		robot.openFile(TTPFilePath + "\\37069\\Response_String.xml");
		robot.XMLCheckWellFormedness();
		assertAreas(MESSAGES);
		 	
	}
	
	

}
