package com.altova.databasespy;

import java.awt.Rectangle;

import com.altova.robots.DropDownOption;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;
import static java.awt.event.KeyEvent.*;


public class QuickConnectionMySQL extends DatabaseSpyRobot{

	private String DBsource = "";
	private String sourceName = "";
	private String serverName = "";
	private String userId = "";
	private String password = "";
	private String databaseName = "";
	private String driverName = "";	
	private String port = "";
	private String jdbcDriver = "";
	private String jdbcURL = "";
	
	//Constructor for ODBC test cases
	public QuickConnectionMySQL(String DBsource, String sourceName, String serverName, String userId, String password, String databaseName ,String driverName, String port) {
		
		this.DBsource = DBsource;
		this.sourceName = sourceName;
		this.serverName = serverName;
		this.userId = userId;
		this.password = password;
		this.databaseName = databaseName;
		this.driverName = driverName;
		this.port = port;
	}
	//Constructor for JDBC test cases
	public QuickConnectionMySQL(String sourceName, String jdbcDriver, String userId, String password, String jdbcURL){
		
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
		delay(5000);

		//Data Source options
		//assertWindow("Connector/ODBC 3.51.26");		
		assertWindow("MySQL Connector/ODBC Data Source Configuration");
		delay(2000);
		
		TextFieldOption dsn = new TextFieldOption("Data Source Name", false , sourceName, null, null, null, null, WINDOWS_DEFAULT_FONT);
		dsn.applyOption(this);
		
		TextFieldOption server = new TextFieldOption("Server", false , serverName, null, null, null, null, WINDOWS_DEFAULT_FONT);
		server.applyOption(this);
		
		TextFieldOption _port = new TextFieldOption("Port", false , port, null, null, null, null, WINDOWS_DEFAULT_FONT);
		_port.applyOption(this);
		
		
		TextFieldOption user = new TextFieldOption("User", false , userId, null, null, null, null, WINDOWS_DEFAULT_FONT);
		user.applyOption(this);	
		
		TextFieldOption pwd = new TextFieldOption("Password", false , password, null, null, null, null, WINDOWS_DEFAULT_FONT);
		pwd.applyOption(this);
		
		TextFieldOption database = new TextFieldOption("Database", false , databaseName, null, null, null, null, WINDOWS_DEFAULT_FONT);
		database.applyOption(this);
		
		leftClickMid(this.findComponent("OK", "Button", null));
		
        //How Do You Want the Datasource to Communicate with the Server?
		/*
		 * not allowed from v2012 
		 * 
		 * delay(2000);
		assertWindow("How Do You Want the Datasource to Communicate with the Server?");
		
		RadioOption h = new RadioOption("Natively", null, null, null, null, WINDOWS_DEFAULT_FONT);
		applyOption("How Do You Want the Datasource to Communicate with the Server?", h);
		
		leftClickMid(this.findComponent("OK", "Button", null));
		delay(500);
		*/
		
		delay(10000);
		setADataSourceName(sourceName);	
		
	}
	
	public void insertTabTest(String text, int numberOfTabs){
		
		for (int i = 0; i < numberOfTabs; i++) {
			keyPress(VK_TAB);
			delay(1000);
		}
		
		if (text != "")
			typeString(text);
		else
			keyPress(VK_ENTER);
		delay(500);
		
	}

	public void executeODBConnection() {
		
		selectODBConnections();
		
		selectODBCDataSource(sourceName);
		
		setADataSourceName(sourceName);
		delay(10000);
		
		
	}
	
	public void executeJDBConnection() {
		
		selectJDBConnections();
		
		selectJDBCDataSource(jdbcDriver, userId, password, jdbcURL);
		
		setADataSourceName(sourceName + "_jdbc");
		delay(10000);
		
		
	}
	

}
