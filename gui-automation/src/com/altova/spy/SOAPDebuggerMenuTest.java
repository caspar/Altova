package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.spy.SpyRobot.SOAP_DEBUGGER;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.awt.event.KeyEvent.VK_ENTER;

public class SOAPDebuggerMenuTest extends AbstractXmlSpyTest{

	/*
	 * List of test cases is and some information related on
	 * are available on:
	 * S:\QA\Internal\Regressiontest\XMLSpy\SOAP-WSDL\SOAP_GUI_AUTOMATION_IDE_Coverage.xls
	 */
	
	@After
	public void setDown() throws Exception {
		
		robot.turnOffDebuggingMode();
		robot.SOAPDebuggerSessionEnd();
		
	}
	
	@Before
	public void setUp() throws Exception {
		
		robot.SOAPDebuggerSession(TIMESERVICE_WSDL_FILE);
	}
	
	@Test
	public final void testSOAPDebuggerSession_Go() {
		
		robot.SOAPFunctionBreakpoint("getTimeZoneTime", true, true);
		robot.SOAPDebuggerGo();
		
		robot.turnOnDebuggingMode(SOAP_DEBUGGER_CLIENT_FILE);
		robot.delay(5000);
		robot.switchToSOAPRequest();
		
		assertAreas(getTestName()+ "_SOAPrequest",DIAGRAM_MAIN_WINDOW);
		robot.SOAPDebuggerGo();
		robot.delay(100);
		robot.switchToSOAPResponse();
		
		assertAreas(getTestName()+ "_SOAPresponse",DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testSOAPDebuggerSession_SingleStep() {
		
		robot.SOAPFunctionBreakpoint("getTimeZoneTime", true, true);
		robot.SOAPDebuggerSingleStep();
		
		robot.turnOnDebuggingMode(SOAP_DEBUGGER_CLIENT_FILE);
		robot.delay(5000);
		robot.switchToSOAPRequest();
		
		assertAreas(getTestName()+ "_SOAPrequest",DIAGRAM_MAIN_WINDOW);
		robot.SOAPDebuggerSingleStep();
		robot.delay(100);
		robot.switchToSOAPResponse();
		
		assertAreas(getTestName()+ "_SOAPresponse",DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testSOAPDebuggerSession_BreakOntheNextRequest() {
		
		robot.SOAPFunctionBreakpoint("getTimeZoneTime", true, true);
		robot.SOAPDebuggerBreakOnNextRequest();
		
		robot.turnOnDebuggingMode(SOAP_DEBUGGER_CLIENT_FILE);
		robot.delay(5000);
		robot.switchToSOAPRequest();
		
		assertAreas(getTestName()+ "_SOAPrequest",DIAGRAM_MAIN_WINDOW);
		robot.SOAPDebuggerGo();
		robot.delay(100);
		robot.switchToSOAPResponse();
		
		assertAreas(getTestName()+ "_SOAPresponse",DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testSOAPDebuggerSession_BreakOntheNextResponse() {
		
		robot.SOAPFunctionBreakpoint("getTimeZoneTime", true, true);
		robot.SOAPDebuggerGo();
		
		robot.turnOnDebuggingMode(SOAP_DEBUGGER_CLIENT_FILE);
		robot.delay(5000);
		robot.switchToSOAPRequest();
		
		assertAreas(getTestName()+ "_SOAPrequest",DIAGRAM_MAIN_WINDOW);
		robot.SOAPDebuggerBreakOnNextResponse();
		robot.delay(100);
		robot.switchToSOAPResponse();
		
		assertAreas(getTestName()+ "_SOAPresponse",DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testSOAPDebuggerSession_StopProxyServer() {
		
		robot.SOAPFunctionBreakpoint("getTimeZoneTime", true, true);
		robot.SOAPDebuggerGo();
		
		robot.turnOnDebuggingMode(SOAP_DEBUGGER_CLIENT_FILE);
		robot.delay(5000);
		
		robot.SOAPDebuggerStopProxy();
		robot.delay(100);
		robot.escapeDialog("Unknown server error", VK_ENTER);
		
		robot.switchToSOAPResponse();
		assertAreas(getTestName()+ "_SOAPresponse",DIAGRAM_MAIN_WINDOW);
		
		robot.leftClickMenuItem("Window", "DebuggerClient");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testSOAPDebuggerSession_AddBreakpointOnRequest() {
		
		robot.SOAPConditionalBreakpoint_Add("/SOAP-ENV:Envelope/SOAP-ENV:Body", false, null, true, false, true, null, true, false);
		
		robot.SOAPDebuggerGo();
		robot.turnOnDebuggingMode(SOAP_DEBUGGER_CLIENT_FILE);
		robot.delay(5000);
		robot.switchToSOAPRequest();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, SOAP_DEBUGGER);

	}

	@Test
	public final void testSOAPDebuggerSession_AddBreakpointOnResponse() {

		robot.SOAPConditionalBreakpoint_Add("/SOAP-ENV:Envelope/SOAP-ENV:Body", false, null, true, false, true, null, true, false);
		robot.SOAPDebuggerGo();
		robot.turnOnDebuggingMode(SOAP_DEBUGGER_CLIENT_FILE);
		robot.delay(5000);
		robot.switchToSOAPRequest();

		robot.SOAPConditionalBreakpoint_Add("/soap:Envelope/soap:Body", false, null, true, false, true, null, false, true);
		robot.SOAPDebuggerGo();
		robot.turnOnDebuggingMode(SOAP_DEBUGGER_CLIENT_FILE);
		robot.delay(5000);
		robot.switchToSOAPResponse();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, SOAP_DEBUGGER);
	}
	
	@Test
	public final void testSOAPDebuggerSession_AddBreakpointFunction() {
		
		robot.SOAPConditionalBreakpoint_Add("/SOAP-ENV:Envelope/SOAP-ENV:Body", false, null, true, false, false, "getTimeZoneTime", true, false);
		
		robot.SOAPDebuggerGo();
		robot.turnOnDebuggingMode(SOAP_DEBUGGER_CLIENT_FILE);
		robot.delay(5000);
		robot.switchToSOAPRequest();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, SOAP_DEBUGGER);

	}

	@Test
	public final void testSOAPDebuggerSession_ModifyBreakpoint() {
		
		robot.SOAPConditionalBreakpoint_Add("/SOAP-ENVELOPE:Envelope/SOAP-ENVELOPE", true, null, true, false, true, null, true, false);
		
		robot.SOAPDebuggerGo();
		robot.turnOnDebuggingMode(SOAP_DEBUGGER_CLIENT_FILE);
		robot.delay(5000);
		robot.switchToSOAPRequest();
		
		assertAreas(getTestName()+ "_SOAPRequest", DIAGRAM_MAIN_WINDOW);
		
		robot.SOAPConditionalBreakpoint_Change("/SOAP-ENVELOPE", "/SOAP-ENV:Envelope/SOAP-ENV:Body", false, null, true, false, true, null, true, false);
	
		robot.delay(5000);
		robot.switchToSOAPRequest();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, SOAP_DEBUGGER);

	}

	@Test
	public final void testSOAPDebuggerSession_DeleteBreakpoint() {
		
		robot.SOAPConditionalBreakpoint_Add("/SOAP-ENV:Envelope/SOAP-ENV:Body", true, null, true, false, true, null, true, false);
		robot.SOAPConditionalBreakpoint_Delete("/SOAP-ENV:Envelope");
		
		assertAreas(SOAP_DEBUGGER);


		
	}

}
