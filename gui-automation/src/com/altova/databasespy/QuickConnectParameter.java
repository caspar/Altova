package com.altova.databasespy;


import com.altova.util.IOUtils;

public abstract class QuickConnectParameter {

	/*
	 * DRIVER Parameter
	 * 
	 * Please check in pc test the driver names.
	 */
	
	public final static String DB2_driverName = "IBM DB2 ODBC DRIVER - DB2COPY1";	
	public final static String MySQL_driverName = "MySQL ODBC 5.1 Driver";	
	public final static String Oracle_driverName = "Oracle in OraClient11g_home1";
	public final static String Sybase_driverName  = "Sybase ASE ODBC Driver";
	public final static String SQLServer_driverName = "Microsoft OLE DB Provider for SQL Server";
	public final static String PostgreSQL_driverName = "PostgreSQL Unicode";
	public final static String Informix_driverName = "IBM INFORMIX ODBC DRIVER";
	
	
	// Quick connect Access 2003 and Access 2007 parameter
	public final static String Access_DBSource = "Microsoft Access ( ADO )";
	public final static String Access_sourceFile = IOUtils.findFile("OrgChartDB.mdb").getAbsolutePath();
	public final static String Access_sourceName = "Wizard_Access_conn";
	
	public final static String Access07_sourceFile = IOUtils.findFile("OrgChartDB.accdb").getAbsolutePath();
	public final static String Access07_sourceName = "Wizard_Access07_conn";
	
	//Quick Connect data for Data Comparison test
	public final static String Access_sourceFile_Left = IOUtils.findFile("OrgChartDBCompLeft.mdb").getAbsolutePath();
	public final static String Access_sourceName_Left = "OrgChartDBCompLeft";
	
	public final static String Access_sourceFile_Right = IOUtils.findFile("OrgChartDBCompRight.mdb").getAbsolutePath();
	public final static String Access_sourceName_Right = "OrgChartDBCompRight";
		
	
//	 Quick connect IBM DB2 parameter
	
	public final static String DB2_DBSource = "IBM DB2 ( ODBC / JDBC )";
	public final static String DB2_sourceName = "Wizard_DB2_conn";
	public final static String DB2_databaseName = "DBSPYAUT";
	public final static String DB2_userId = "altova_user"; 
	public final static String DB2_password = "user"; 
	public final static String DB2_jdbcDriver_jcc = "com.ibm.db2.jcc.DB2Driver";
	public final static String DB2_jdbcDriver_jdbc = "COM.ibm.db2.jdbc.app.DB2Driver";
	public final static String DB2_jdbcURL = "jdbc:db2://vietdb2:50000/" + DB2_databaseName; //jdbc:db2://vietdb2:50000/DBSPYAUT
	
//	 Quick connect MySQL parameter	
	
	public final static String MySQL_DBSource = "MySQL ( ODBC )";
	public final static String MySQL_sourceName = "Wizard_MySQL_conn";
	public final static String MySQL_serverName = "vietmys051";
	public final static String MySQL_userId = "altova_user";
	public final static String MySQL_password = "user";
	public final static String MySQL_databaseName = "dbspyaut";
	public final static String MySQL_port = "3306";
	public final static String MySQL_jdbcDriver = "com.mysql.jdbc.Driver";
	public final static String MySQL_jdbcURL = "jdbc:mysql://" + MySQL_serverName + ":" + MySQL_port + "/" + MySQL_databaseName; //jdbc:mysql://ts-sql:3307/dbspyaut
	
//	 Quick connect Oracle parameter	

	public final static String Oracle_DBSource = "Oracle ( ODBC / JDBC )";
	public final static String Oracle_sourceName = "Wizard_Oracle_conn";
	public final static String Oracle_TNS = "ORCL";
	public final static String Oracle_userId = "qa_usr";
	public final static String Oracle_password = "qa_usr";
	public final static String Oracle_jdbcDriver_OracleDriver = "oracle.jdbc.OracleDriver";
	public final static String Oracle_jdbcDriver_SunDriver    = "sun.jdbc.odbc.JdbcOdbcDriver";
	public final static String Oracle_jdbcURL = "jdbc:oracle:thin:@//vietora10/" + Oracle_TNS; //jdbc:oracle:thin:@//vietora10/ORCL
	
	
//	 Quick connect Sybase parameter	

	public final static String Sybase_DBSource = "Sybase ( ODBC )";
	public final static String Sybase_sourceName = "Wizard_Sybase_conn";	
	public final static String Sybase_networkAddress = "vietsybase12,2048";
	public final static String Sybase_databaseName = "DBSPYAUT";
	public final static String Sybase_userId = "altova_admin";
	public final static String Sybase_password = "admin";
	public final static String Sybase_jdbcDriver = "com.sybase.jdbc4.jdbc.SybDriver";
	public final static String Sybase_jdbcURL = "jdbc:sybase:Tds:" + Sybase_networkAddress.replace(',', ':') + "/" + Sybase_databaseName; //jdbc:sybase:Tds:vietsybase12:2048/DBSPYAUT
	
	
//  Quick connect SQLServer parameter
	
	public final static String SQLServer_DBSource = "Microsoft SQL Server";
	public final static String SQLServer_sourceName = "Wizard_SQLServer_conn";
	public final static String SQLServer_serverName = "VIETSQL05";
	public final static String SQLServer_userId = "altova_user";
	public final static String SQLServer_password = "user";
	public final static String SQLServer_databaseName = "DBSPYAUT";
	public final static String SQLServer_jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public final static String SQLServer_jdbcURL = "jdbc:sqlserver://" + SQLServer_serverName + ";databasename=" +  SQLServer_databaseName; //jdbc:sqlserver://vietsql05;databasename=DBSPYAUT
	
	
//  Quick connect PostgreSQL parameter
	
	public final static String PostgreSQL_DBSource = "PostgreSQL (ODBC)";
	public final static String PostgreSQL_sourceName = "Wizard_PostgreSQL_conn";
	public final static String PostgreSQL_serverName = "vietpos01";
	public final static String PostgreSQL_userId = "altova_user";
	public final static String PostgreSQL_password = "user";
	public final static String PostgreSQL_databaseName = "qa_dbspyaut";	
	public final static String PostgreSQL_port = "5433";
	public final static String PostgreSQL_jdbcDriver = "org.postgresql.Driver";
	public final static String PostgreSQL_jdbcURL = "jdbc:postgresql://" + PostgreSQL_serverName + ":" + PostgreSQL_port + "/" + PostgreSQL_databaseName; //jdbc:postgresql://vietpos01:5433/qa_dbspyaut

//  Quick connect Informix parameter
	
	public final static String Informix_DBSource = "IBM Informix";
	public final static String Informix_sourceName = "Wizard_Informix_conn";
	public final static String Informix_serverName = "ol_informix1170";
	public final static String Informix_hostname = "vietinf1170";
	public final static String Informix_service = "ol_informix1170";
	public final static String Informix_protocol = "olsoctcp";
	public final static String Informix_userId = "altova_user";
	public final static String Informix_password = "user";
	public final static String Informix_databaseName = "dbspyaut";	
	public final static String Informix_jdbcDriver = "COM.ibm.db2.jdbc.app.DB2Driver";;
	public final static String Informix_jdbcURL = "jdbc:db2://vietdb2:50000/" + DB2_databaseName; //jdbc:db2://vietdb2:50000/DBSPYAUT
	
//  Quick connect for SQLite
	
	public final static String SQLite_DBSource = "SQLite";
	public final static String SQLite_sourceFile = IOUtils.findFile("SQLiteDB.sqlite").getAbsolutePath();
	public final static String SQLite_sourceName = "Wizard_SQLite_conn";
	
	
}


