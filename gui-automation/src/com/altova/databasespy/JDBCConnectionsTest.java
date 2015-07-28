package com.altova.databasespy;

import static com.altova.databasespy.DatabaseSpyRobot.PROPERTIES;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JDBCConnectionsTest extends AbstractDatabaseSpyTest{
	
	
	@BeforeClass
	public static void beforeQuickConnect(){		
		
		robot.resizePaneforQuickConnect();
		
	}

	@Before
	public void ODBCTest(){
		
		robot.newProject();
		
	}
	
	//ttp 38101 - update reference picture when bug is fixed
	@Test
	public final void testJDBConnection_MySQL() {
		
		QuickConnectionMySQL qca = new QuickConnectionMySQL(QuickConnectParameter.MySQL_sourceName, QuickConnectParameter.MySQL_jdbcDriver, QuickConnectParameter.MySQL_userId, QuickConnectParameter.MySQL_password, QuickConnectParameter.MySQL_jdbcURL);
		qca.executeJDBConnection();
		assertAreas(PROPERTIES);
		
	}
	
	@Test
	public final void testODBConnection_DB2_jcc() {
		

		QuickConnectionDB2 qca = new QuickConnectionDB2(QuickConnectParameter.DB2_sourceName, QuickConnectParameter.DB2_jdbcDriver_jcc, QuickConnectParameter.DB2_userId, QuickConnectParameter.DB2_password, QuickConnectParameter.DB2_jdbcURL);
		qca.executeJDBConnection();
		assertAreas(PROPERTIES);
		
	}
	//ttp 38101 - update reference picture when bug is fixed
	@Test
	public final void testODBConnection_DB2_jdbc() {
		

		QuickConnectionDB2 qca = new QuickConnectionDB2(QuickConnectParameter.DB2_sourceName, QuickConnectParameter.DB2_jdbcDriver_jdbc, QuickConnectParameter.DB2_userId, QuickConnectParameter.DB2_password, QuickConnectParameter.DB2_jdbcURL);
		qca.executeJDBConnection();
		assertAreas(PROPERTIES);
		
	}
	//ttp 38101 - update reference picture when bug is fixed
	@Test
	public final void testJDBConnection_Sybase() {
		

		QuickConnectionSybase qca = new QuickConnectionSybase(QuickConnectParameter.Sybase_sourceName, QuickConnectParameter.Sybase_jdbcDriver, QuickConnectParameter.Sybase_userId, QuickConnectParameter.Sybase_password, QuickConnectParameter.Sybase_jdbcURL);		
		qca.executeJDBConnection();
		assertAreas(PROPERTIES);
		
	}
	//ttp 38101 - update reference picture when bug is fixed
	@Test
	public final void testJDBConnection_Oracle_oracleDriver() {
		
		QuickConnectionOracle10 qca = new QuickConnectionOracle10(QuickConnectParameter.Oracle_sourceName, QuickConnectParameter.Oracle_jdbcDriver_OracleDriver, QuickConnectParameter.Oracle_userId, QuickConnectParameter.Oracle_password, QuickConnectParameter.Oracle_jdbcURL);
		qca.executeJDBConnection();
		assertAreas(PROPERTIES);
	}
	//ttp 38101 - update reference picture when bug is fixed
	@Test
	public final void testJDBConnection_Oracle_sunDriver() {
		
		QuickConnectionOracle10 qca = new QuickConnectionOracle10(QuickConnectParameter.Oracle_sourceName, QuickConnectParameter.Oracle_jdbcDriver_SunDriver, QuickConnectParameter.Oracle_userId, QuickConnectParameter.Oracle_password, QuickConnectParameter.Oracle_jdbcURL);
		qca.executeJDBConnection();
		assertAreas(PROPERTIES);
	}

	//ttp 38101 - update reference picture when bug is fixed
	@Test
	public final void testJDBConnection_PostgreSQL() {
		
		QuickConnectPostgreSQL qca = new QuickConnectPostgreSQL(QuickConnectParameter.PostgreSQL_sourceName, QuickConnectParameter.PostgreSQL_jdbcDriver, QuickConnectParameter.PostgreSQL_userId, QuickConnectParameter.PostgreSQL_password, QuickConnectParameter.PostgreSQL_jdbcURL);
		qca.executeJDBConnection();
		assertAreas(PROPERTIES);
	}
	
}
