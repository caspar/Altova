package com.altova.databasespy;

import static com.altova.databasespy.DatabaseSpyRobot.PROPERTIES;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.robots.AltovaApplicationRobot;


public class ADOConnections extends AbstractDatabaseSpyTest{


	protected final String access2003ADOString = "Data Source=C:\\Work\\gui-automation\\data\\databasespy\\examplesDBSpy\\OrgChartDB.mdb;Provider=Microsoft.Jet.OLEDB.4.0;Persist Security Info=false";
	protected final String access2007ADOString = "Data Source=C:\\Work\\gui-automation\\data\\databasespy\\examplesDBSpy\\OrgChartDB.accdb;Provider=Microsoft.ACE.OLEDB.12.0;Persist Security Info=false";	
	
	
	@BeforeClass
	public static void beforeQuickConnect(){		
		
		robot.resizePaneforQuickConnect(); 

	}
	
	@Before
	public void beforeADOConnection(){
		
		robot.newProject();
	}
	
	@Test
	public void testAccess2003() {
		
		robot.selectADOConnection(access2003ADOString);
		delay(1000);
		robot.setADataSourceName(QuickConnectParameter.Access_sourceName);
		
		assertAreas(PROPERTIES);
		
	}
	
	
	@Test
	public void testAccess2007() {
		
		robot.selectADOConnection(access2007ADOString);
		delay(1000);
		robot.setADataSourceName(QuickConnectParameter.Access07_sourceName);
		
		assertAreas(PROPERTIES);
		
	}
	
}
