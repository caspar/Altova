package com.altova.databasespy;

import java.awt.Rectangle;

import com.altova.robots.DropDownOption;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;

public class QuickConnectionSybase extends DatabaseSpyRobot{

	private String DBsource = "";
	private String sourceName = "";
	private String networkAddress = "";
	private String databaseName = "";
	private String userId = "";
	private String password = "";
	private String driverName = "";
	private String jdbcDriver = "";
	private String jdbcURL = "";
	
	
	public QuickConnectionSybase( String DBsource, String sourceName, String networkAddress, String databaseName, String userId, String password, String driverName  ) {
		
		this.DBsource = DBsource;
		this.sourceName = sourceName;
		this.networkAddress = networkAddress;
		this.databaseName = databaseName;
		this.userId = userId;
		this.password = password;
		this.driverName = driverName;
		
	}
	//Constructor for JDBC test cases
	public QuickConnectionSybase(String sourceName, String jdbcDriver, String userId, String password, String jdbcURL){
		
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
		//d1.setFont(WINDOWS_DEFAULT_FONT);
		d1.applyOption(this);
		
		leftClickMid(this.findComponent("Connect", "Button", null));
		
		//Data Source options
		delay(2000);
		assertWindow("ODBC Sybase Wire Protocol Driver Setup");
		
		TextFieldOption dsn = new TextFieldOption("Data Source Name", false ,sourceName, null, null,  null, null,MS_SHELL_DLG_FONT);
		//dsn.setX2(50);
		dsn.applyOption(this);

		
		TextFieldOption netAdd = new TextFieldOption("Network Address", false ,networkAddress, null, null,  null, null,MS_SHELL_DLG_FONT);
		netAdd.setX2(80);
		netAdd.applyOption(this);
		
		TextFieldOption dbname = new TextFieldOption("Database Name", false ,databaseName, null, null,  null, null,MS_SHELL_DLG_FONT);
		dbname.setX2(80);
		dbname.applyOption(this);
		
		leftClickMid(this.findComponent("OK", "Button", null));		
		
		// Logon 
		delay(3000);
		assertWindow("Logon to Sybase");
		
		TextFieldOption loginID = new TextFieldOption("Login ID", false ,userId, null, null,  null, null,MS_SHELL_DLG_FONT);
		loginID.setX2(150);
		loginID.applyOption(this);
		
		TextFieldOption pwd = new TextFieldOption("Password", false , password, null, null,  null, null,MS_SHELL_DLG_FONT);
		pwd.setX2(150);
		pwd.applyOption(this);
		
		leftClickMid(this.findComponent("OK", "Button", null));		
		delay(3000);
		
        //How Do You Want the Datasource to Communicate with the Server?
		/*
		 * Not allowed from v2012 
		 * 
		 * delay(2000);
		assertWindow("How Do You Want the Datasource to Communicate with the Server?");
		
		RadioOption h = new RadioOption("Natively", null, null, null, null, WINDOWS_DEFAULT_FONT);
		applyOption("How Do You Want the Datasource to Communicate with the Server?", h);
		
		leftClickMid(this.findComponent("OK", "Button", null));
		delay(1000);
		*/
		
		//set a DataSource name
		setADataSourceName(sourceName);	
		delay(2000);
	}

	public void executeODBConnection() {
		
		selectODBConnections();
		
		Rectangle res = findString(sourceName, DEFAULT_CONTENT_FONT);
		
		if (res != null)
			leftClickMid(res);
		
		delay(500);
		leftClickMid(this.findComponent("Connect", "Button", null));

		delay(3000);
		assertWindow("Logon to Sybase");
		
		TextFieldOption pwd = new TextFieldOption("Password", false , password, null, null,  null, null,MS_SHELL_DLG_FONT);
		pwd.setX2(150);
		pwd.applyOption(this);
		
		leftClickMid(this.findComponent("OK", "Button", null));		
		delay(3000);
		
		/*
		assertWindow("How Do You Want the Datasource to Communicate with the Server?");
		
		RadioOption h = new RadioOption("Natively", null, null, null, null, WINDOWS_DEFAULT_FONT);
		applyOption("How Do You Want the Datasource to Communicate with the Server?", h);

		leftClickMid(findComponent("OK", "Button", null));
		*/
		setADataSourceName(sourceName);
		delay(7000);
		
	}

	public void executeJDBConnection() {
		
		selectJDBConnections();
		
		selectJDBCDataSource(jdbcDriver, userId, password, jdbcURL);
		
		setADataSourceName(sourceName + "_jdbc");
		delay(10000);
		
		
	}
	
	
}
