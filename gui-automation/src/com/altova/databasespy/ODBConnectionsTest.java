package com.altova.databasespy;

import static com.altova.databasespy.DatabaseSpyRobot.PROJECT;
import static com.altova.databasespy.DatabaseSpyRobot.PROPERTIES;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.robots.AltovaApplicationRobot;

public class ODBConnectionsTest extends AbstractDatabaseSpyTest{
	
	
	@BeforeClass
	public static void beforeQuickConnect(){		
		
		robot.resizePaneforQuickConnect();
		
	}
	
	@Before
	public void ODBCTest(){
		
		robot.newProject();
		
	}

	@Test
	public final void testODBConnection_MySQL() {
		
		QuickConnectionMySQL qca = new QuickConnectionMySQL(QuickConnectParameter.MySQL_DBSource, QuickConnectParameter.MySQL_sourceName, QuickConnectParameter.MySQL_serverName, QuickConnectParameter.MySQL_userId, QuickConnectParameter.MySQL_password, QuickConnectParameter.MySQL_databaseName, QuickConnectParameter.MySQL_driverName, QuickConnectParameter.MySQL_port);
		qca.executeODBConnection();
		assertAreas(PROPERTIES);
		
	}
	
	
	@Test
	public final void testODBConnection_DB2() {
		

		QuickConnectionDB2 qca = new QuickConnectionDB2(QuickConnectParameter.DB2_DBSource, QuickConnectParameter.DB2_sourceName, QuickConnectParameter.DB2_databaseName, QuickConnectParameter.DB2_userId, QuickConnectParameter.DB2_password, QuickConnectParameter.DB2_driverName);
		qca.executeODBConnection();
		assertAreas(PROPERTIES);
		
	}

	@Test
	public final void testODBConnection_Informix() {
		
		QuickConnectInformix qca = new QuickConnectInformix(QuickConnectParameter.Informix_DBSource, QuickConnectParameter.Informix_sourceName, QuickConnectParameter.Informix_serverName, QuickConnectParameter.Informix_hostname, QuickConnectParameter.Informix_service, QuickConnectParameter.Informix_protocol, QuickConnectParameter.Informix_userId, QuickConnectParameter.Informix_password, QuickConnectParameter.Informix_databaseName, QuickConnectParameter.Informix_driverName);
		qca.executeODBConnection();
		assertAreas(PROPERTIES);
		
	}
	
	@Test
	public final void testODBConnection_Sybase() {
		

		QuickConnectionSybase qca = new QuickConnectionSybase(QuickConnectParameter.Sybase_DBSource, QuickConnectParameter.Sybase_sourceName, QuickConnectParameter.Sybase_networkAddress, QuickConnectParameter.Sybase_databaseName, QuickConnectParameter.Sybase_userId, QuickConnectParameter.Sybase_password, QuickConnectParameter.Sybase_driverName);		
		qca.executeODBConnection();
		assertAreas(PROPERTIES);
		
	}
	
	@Test
	public final void testODBConnection_Oracle() {
		//fail("aborted Oracle test due to Oracle connection crash");
		QuickConnectionOracle10 qca = new QuickConnectionOracle10(QuickConnectParameter.Oracle_DBSource, QuickConnectParameter.Oracle_sourceName, QuickConnectParameter.Oracle_TNS, QuickConnectParameter.Oracle_userId, QuickConnectParameter.Oracle_password, QuickConnectParameter.Oracle_driverName);
		qca.executeODBConnection();
		assertAreas(PROPERTIES);
	}


	@Test
	public final void testODBConnection_PostgreSQL() {
		
		QuickConnectPostgreSQL qca = new QuickConnectPostgreSQL(QuickConnectParameter.PostgreSQL_DBSource, QuickConnectParameter.PostgreSQL_sourceName, QuickConnectParameter.PostgreSQL_serverName, QuickConnectParameter.PostgreSQL_databaseName, QuickConnectParameter.PostgreSQL_userId, QuickConnectParameter.PostgreSQL_password, QuickConnectParameter.PostgreSQL_driverName, QuickConnectParameter.PostgreSQL_port);
		qca.executeODBConnection();
		assertAreas(PROPERTIES);
	}
	
	
	
}
