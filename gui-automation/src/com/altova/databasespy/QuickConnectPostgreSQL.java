package com.altova.databasespy;

import com.altova.robots.DropDownOption;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;

public class QuickConnectPostgreSQL extends DatabaseSpyRobot{

	private String DBsource = "";
	private String sourceName = "";
	private String serverName = "";
	private String databaseName = "";
	private String userId = "";
	private String password = "";
	private String driverName = "";
	private String portName = "";
	private String jdbcDriver = "";
	private String jdbcURL = "";
	
	public QuickConnectPostgreSQL( String DBsource, String sourceName, String serverName, String databaseName, String userId, String password, String driverName, String portName  ) {
		
		this.DBsource = DBsource;
		this.sourceName = sourceName;
		this.serverName = serverName;
		this.databaseName = databaseName;
		this.userId = userId;
		this.password = password;
		this.driverName = driverName;
		this.portName = portName;
	}
	//Constructor for JDBC test cases
	public QuickConnectPostgreSQL(String sourceName, String jdbcDriver, String userId, String password, String jdbcURL){
		
		this.sourceName = sourceName;
		this.jdbcDriver = jdbcDriver;
		this.userId = userId;
		this.password = password;
		this.jdbcURL = jdbcURL;
	}

	
	
	public void executeWizard(){
		
		selectConnectionWizard(DBsource);
		
		RadioOption c = new RadioOption("Create a new Data Source Name", null, null, null, null,WINDOWS_DEFAULT_FONT);
		applyOption("Add a Data Source", c);
		
		DropDownOption d1 = new DropDownOption ("Create a new Data Source Name (DSN) with the driver", true, driverName, null, null, null, null,WINDOWS_DEFAULT_FONT);		
		d1.applyOption(this);
		
		leftClickMid(this.findComponent("Connect", "Button", null));

		//Data Source options
		
		delay(2000);
		assertWindow("PostgreSQL Unicode ODBC Driver (psqlODBC) Setup");
		
		TextFieldOption datasource = new TextFieldOption("Data Source", false , sourceName, null, null,  null, null,MS_SHELL_DLG_FONT);
		datasource.applyOption(this);
		
		TextFieldOption database = new TextFieldOption("Database", false , databaseName, null, null,  null, null,MS_SHELL_DLG_FONT);
		database.applyOption(this);
		
		TextFieldOption server = new TextFieldOption("Server", false , serverName, null, null,  null, null,MS_SHELL_DLG_FONT);
		server.applyOption(this);
		
		TextFieldOption port = new TextFieldOption("Port", false , portName, null, null,  null, null,MS_SHELL_DLG_FONT);
		port.applyOption(this);
		
		TextFieldOption user = new TextFieldOption("User Name", false , userId, null, null,  null, null,MS_SHELL_DLG_FONT);
		user.applyOption(this);
		
		TextFieldOption pwd = new TextFieldOption("Password", false , password, null, null,  null, null,MS_SHELL_DLG_FONT);
		pwd.applyOption(this);
		
		leftClickMid(this.findComponent("Save", "Button", null));
		
		
        //How Do You Want the Datasource to Communicate with the Server?
		delay(2000);
		/*
		 * not allowed since v2012
		 * 
		 * assertWindow("How Do You Want the Datasource to Communicate with the Server?");
		
		RadioOption h = new RadioOption("Natively", null, null, null, null, WINDOWS_DEFAULT_FONT);
		applyOption("How Do You Want the Datasource to Communicate with the Server?", h);
		
		leftClickMid(this.findComponent("OK", "Button", null));
		delay(500);		
		*/
		
		setADataSourceName(sourceName);	
		delay(2000);
	}


	public void executeODBConnection() {
		
		selectODBConnections();
		
		selectODBCDataSource(sourceName);		
		
		setADataSourceName(sourceName);
		delay(3000);
	}
	
	public void executeJDBConnection() {
		
		selectJDBConnections();
		
		selectJDBCDataSource(jdbcDriver, userId, password, jdbcURL);
		
		setADataSourceName(sourceName + "_jdbc");
		delay(10000);
		
		
	}
	
}
