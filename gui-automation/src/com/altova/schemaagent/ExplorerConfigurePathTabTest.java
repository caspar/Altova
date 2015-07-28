package com.altova.schemaagent;

import static com.altova.schemaagent.SchemaAgentRobot.*;
import static com.altova.schemaagent.SchemaAgentRobot.View.*;
import static com.altova.spy.SpyRobot.FACETS_SAMPLES;
import static com.altova.util.LoggerUtils.logger;


import java.awt.event.KeyEvent;
import java.awt.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;


public class ExplorerConfigurePathTabTest extends AbstractSchemaAgentTest {
	
	

	
	@Test
	public void testAddSearchPathNotRecursive() {

		robot.deleteAndCreateSearchPath("C:\\Work\\gui-automation\\data\\schemaagent\\example", true, false, false, null, null, null, "");
		robot.expandPath();
		
		assertAreas(EXPLORER);

	}

	@Test
	public void testAddSearchPathRecursive() {

		robot.deleteAndCreateSearchPath("C:\\Work\\gui-automation\\data\\schemaagent\\example", true, true, false, null, null, null, "");
		robot.expandPath();
		
		assertAreas(EXPLORER);
	}
	
	@Test
	public void testAddSearchPathRelative() {

		robot.deleteAndCreateSearchPath("C:\\Work\\gui-automation\\data\\schemaagent\\example", true, false, true, null, null, null, "");
		robot.expandPath();
		
		assertAreas(EXPLORER);

	}
	
	@Test
	public void testAddSearchPathRelativeRecursive() {

		robot.deleteAndCreateSearchPath("C:\\Work\\gui-automation\\data\\schemaagent\\example", true, true, true, null, null, null, "");
		robot.expandPath();
		
		assertAreas(EXPLORER);

	}
	
	@Test
	public void testAddSearchPathURL() {
		
		robot.deleteAndCreateSearchPath("", false, false, false, null, null, "http://qa-w2k3/webdav","agui-automation");
		robot.expandPath();
		
		assertAreas(EXPLORER);
	}
	
	
	@Test
	public void testAddSearchPathURLRecursive() {
		
		robot.deleteAndCreateSearchPath("", false, true, false, null, null, "http://qa-w2k3/webdav","agui-automation");
		robot.expandPath();
		
		assertAreas(EXPLORER);
	}
	
	@Test
	public void testAddSearchPathURLAuthentication() {
		
		robot.deleteAndCreateSearchPath("", false, false, false, "test", "test", "http://qa-w2k3/test_auth","agui-automation");
		robot.expandPath();
		
		assertAreas(EXPLORER);
		
	}

	@Test
	public void testAddSearchPathURLAuthenticationRecursive() {
		
		robot.deleteAndCreateSearchPath("", false, true, false, "test", "test", "http://qa-w2k3/test_auth","agui-automation");
		robot.expandPath();
		
		assertAreas(EXPLORER);
		
		
	}
	
	@Test
	public void testAddDeleteXSDExtension() {
		
		robot.deleteAndCreateSearchPath("C:\\Work\\gui-automation\\data\\schemaagent\\TestCases", true, false, false, null, null, null, "");
		
		robot.setExtension(extension.Delete, "xsd");
		robot.navigateTo("estCases",Color.WHITE,Color.BLACK);

		assertAreas(getTestName()+"_Delete", EXPLORER);
		delay(500);
		robot.setExtension(extension.Add, "Schema", "xsd");
		robot.navigateTo("estCases",Color.WHITE,Color.BLACK);

		assertAreas(getTestName()+"_Add", EXPLORER);
		
		
	}
	
	@Test
	public void testAddDeleteMFDExtension() {

		robot.deleteAndCreateSearchPath("C:\\Work\\gui-automation\\data\\schemaagent\\TestCases", true, false, false, null, null, null, "");
		
		robot.setExtension(extension.Delete, "mfd");
		robot.navigateTo("estCases",Color.WHITE,Color.BLACK);

		assertAreas(getTestName()+"_Delete", EXPLORER);
		delay(500);
		robot.setExtension(extension.Add, "MapForce", "mfd");
		robot.navigateTo("estCases",Color.WHITE,Color.BLACK);

		assertAreas(getTestName()+"_Add", EXPLORER);
		
		
	}
	
	@Test
	public void testAddDeleteXBRLExtension() {
		
		robot.deleteAndCreateSearchPath("C:\\Work\\gui-automation\\data\\schemaagent\\TestCases", true, false, false, null, null, null, "");
		
		robot.setExtension(extension.Delete, "xbrl");
		robot.navigateTo("estCases",Color.WHITE,Color.BLACK);

		assertAreas(getTestName()+"_Delete", EXPLORER);
		delay(500);
		robot.setExtension(extension.Add, "XML", "xbrl");
		robot.navigateTo("estCases",Color.WHITE,Color.BLACK);

		assertAreas(getTestName()+"_Add", EXPLORER);
		
	}
	
	@Test
	public void testAddDeleteXMLExtension() {
		
		robot.deleteAndCreateSearchPath("C:\\Work\\gui-automation\\data\\schemaagent\\TestCases", true, false, false, null, null, null, "");
		
		robot.setExtension(extension.Delete, "xml");
		robot.navigateTo("estCases",Color.WHITE,Color.BLACK);

		assertAreas(getTestName()+"_Delete", EXPLORER);
		delay(500);
		robot.setExtension(extension.Add, "XML", "xml");
		robot.navigateTo("estCases",Color.WHITE,Color.BLACK);

		assertAreas(getTestName()+"_Add", EXPLORER);
		
	}

	@Test
	public void testAddDeleteXSLTExtension() {
		
		robot.deleteAndCreateSearchPath("C:\\Work\\gui-automation\\data\\schemaagent\\TestCases", true, false, false, null, null, null, "");
		
		robot.setExtension(extension.Delete, "xslt");
		robot.navigateTo("estCases",Color.WHITE,Color.BLACK);

		assertAreas(getTestName()+"_Delete", EXPLORER);
		delay(500);
		robot.setExtension(extension.Add, "XSL", "xslt");
		robot.navigateTo("estCases",Color.WHITE,Color.BLACK);

		assertAreas(getTestName()+"_Add", EXPLORER);
		
	}
	
	@Test
	public void testAddDeleteWSDLExtension() {
		
		robot.deleteAndCreateSearchPath("C:\\Work\\gui-automation\\data\\schemaagent\\TestCases", true, false, false, null, null, null, "");
		
		robot.setExtension(extension.Delete, "wsdl");
		robot.navigateTo("estCases",Color.WHITE,Color.BLACK);

		assertAreas(getTestName()+"_Delete", EXPLORER);
		delay(500);
		robot.setExtension(extension.Add, "WSDL", "wsdl");
		robot.navigateTo("estCases",Color.WHITE,Color.BLACK);

		assertAreas(getTestName()+"_Add", EXPLORER);
		
	}
	
}
