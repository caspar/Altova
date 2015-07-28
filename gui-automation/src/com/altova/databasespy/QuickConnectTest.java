package com.altova.databasespy;

import static com.altova.databasespy.DatabaseSpyRobot.PROJECT;
import static com.altova.databasespy.DatabaseSpyRobot.PROPERTIES;
import static java.awt.event.KeyEvent.VK_N;

import org.junit.*;

import com.altova.robots.AltovaApplicationRobot;

public class QuickConnectTest extends AbstractDatabaseSpyTest{	
	
	
	
	@BeforeClass
	public static void beforeQuickConnect(){		
		
		robot.resizePaneforQuickConnect();
		
		//Erase the ODBC registry key 
		AltovaApplicationRobot altovaRobot = getRobot();			
		altovaRobot.deleteApplicationRegistryKeys(ODBCCollectionList);


	}

	@Before
	public void beforeEachConnection(){
		
		robot.newProject();
	}
	
	
	@Test
	public final void testNewQuickConnection_Access_2003() {
		
		QuickConnectAccess qca = new QuickConnectAccess(QuickConnectParameter.Access_DBSource, QuickConnectParameter.Access_sourceFile, QuickConnectParameter.Access_sourceName);
		qca.executeWizard();
		assertAreas(PROPERTIES); //"System Table Structure" must be missing (ttp 38926)
		
	}
	
	@Test
	public final void testNewQuickConnection_Access_2007() {
		
		QuickConnectAccess qca = new QuickConnectAccess(QuickConnectParameter.Access_DBSource, QuickConnectParameter.Access07_sourceFile, QuickConnectParameter.Access07_sourceName);
		qca.executeWizard();
		assertAreas(PROPERTIES); //"System Table Structure" must be missing (ttp 38926)
		
	}
	
	
	
	@Test
	public final void testNewQuickConnection_SQLServer() {
		
		QuickConnectSQLServer qca = new QuickConnectSQLServer(QuickConnectParameter.SQLServer_DBSource, QuickConnectParameter.SQLServer_sourceName, QuickConnectParameter.SQLServer_serverName, QuickConnectParameter.SQLServer_userId, QuickConnectParameter.SQLServer_password, QuickConnectParameter.SQLServer_driverName, QuickConnectParameter.SQLServer_databaseName);
		qca.executeWizard();
		assertAreas(PROPERTIES); //"System Table Structure" must be missing (ttp 38926)
		
	}
	
	@Test
	public final void testNewQuickConnection_Oracle10() {
		
		QuickConnectionOracle10 qca = new QuickConnectionOracle10(QuickConnectParameter.Oracle_DBSource, QuickConnectParameter.Oracle_sourceName, QuickConnectParameter.Oracle_TNS, QuickConnectParameter.Oracle_userId, QuickConnectParameter.Oracle_password, QuickConnectParameter.Oracle_driverName);
		qca.executeWizard();
		assertAreas(PROPERTIES);  //"System Table Structure" must be missing (ttp 38926)
		
	}
	
	@Test
	public final void testNewQuickConnection_MySQL5() {
		
		QuickConnectionMySQL qca = new QuickConnectionMySQL(QuickConnectParameter.MySQL_DBSource, QuickConnectParameter.MySQL_sourceName, QuickConnectParameter.MySQL_serverName, QuickConnectParameter.MySQL_userId, QuickConnectParameter.MySQL_password, QuickConnectParameter.MySQL_databaseName, QuickConnectParameter.MySQL_driverName, QuickConnectParameter.MySQL_port);
		qca.executeWizard();
		assertAreas(PROPERTIES); //"System Table Structure" must be missing (ttp 38926)
		
	}
	
	@Test
	public final void testNewQuickConnection_DB2_9() {
		
		QuickConnectionDB2 qca = new QuickConnectionDB2(QuickConnectParameter.DB2_DBSource, QuickConnectParameter.DB2_sourceName, QuickConnectParameter.DB2_databaseName, QuickConnectParameter.DB2_userId, QuickConnectParameter.DB2_password, QuickConnectParameter.DB2_driverName);
		qca.executeWizard();
		assertAreas(PROPERTIES); //"System Table Structure" must be missing (ttp 38926)
		
	}
	
	
	@Test
	public final void testNewQuickConnection_Informix() {
		
		QuickConnectInformix qca = new QuickConnectInformix(QuickConnectParameter.Informix_DBSource, QuickConnectParameter.Informix_sourceName, QuickConnectParameter.Informix_serverName, QuickConnectParameter.Informix_hostname, QuickConnectParameter.Informix_service, QuickConnectParameter.Informix_protocol, QuickConnectParameter.Informix_userId, QuickConnectParameter.Informix_password, QuickConnectParameter.Informix_databaseName, QuickConnectParameter.Informix_driverName);
		qca.executeWizard();
		assertAreas(PROPERTIES); //"System Table Structure" must be missing (ttp 38926)
		
	}
	
	@Test
	public final void testNewQuickConnection_Sybase() {
		
		QuickConnectionSybase qca = new QuickConnectionSybase(QuickConnectParameter.Sybase_DBSource, QuickConnectParameter.Sybase_sourceName, QuickConnectParameter.Sybase_networkAddress, QuickConnectParameter.Sybase_databaseName, QuickConnectParameter.Sybase_userId, QuickConnectParameter.Sybase_password, QuickConnectParameter.Sybase_driverName);
		qca.executeWizard();
		assertAreas(PROPERTIES); //"System Table Structure" must be missing (ttp 38926)
		
	}
	
	@Test
	public final void testNewQuickConnection_PostgreSQL() {
		
		QuickConnectPostgreSQL qca = new QuickConnectPostgreSQL(QuickConnectParameter.PostgreSQL_DBSource, QuickConnectParameter.PostgreSQL_sourceName, QuickConnectParameter.PostgreSQL_serverName, QuickConnectParameter.PostgreSQL_databaseName, QuickConnectParameter.PostgreSQL_userId, QuickConnectParameter.PostgreSQL_password, QuickConnectParameter.PostgreSQL_driverName, QuickConnectParameter.PostgreSQL_port);
		qca.executeWizard();
		assertAreas(PROPERTIES); //"System Table Structure" must be missing (ttp 38926)
		
	}
	
	@Test
	public final void testNewQuickConnection_SQLite() {
		
		QuickConnectSQLite qca = new QuickConnectSQLite(QuickConnectParameter.SQLite_DBSource, QuickConnectParameter.SQLite_sourceFile, QuickConnectParameter.SQLite_sourceName);
		qca.executeWizard();
		assertAreas(PROPERTIES); //"System Table Structure" must be missing (ttp 38926)
		
	}
	
}
