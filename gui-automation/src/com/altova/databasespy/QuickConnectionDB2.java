package com.altova.databasespy;

import static java.awt.event.KeyEvent.VK_Y;

import java.awt.Rectangle;


import com.altova.robots.DropDownOption;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;

public class QuickConnectionDB2 extends DatabaseSpyRobot{

	
	private String DBsource = "";
	private String sourceName = "";
	private String databaseName = "";
	private String userId = "";
	private String password = "";
	private String driverName = "";
	private String jdbcDriver = "";
	private String jdbcURL = "";
	
	
	public QuickConnectionDB2( String DBsource, String sourceName, String databaseName, String userId, String password, String driverName   ) {
		
		this.DBsource = DBsource;
		this.sourceName = sourceName;
		this.databaseName = databaseName;
		this.userId = userId;
		this.password = password;
		this.driverName = driverName;
		
	}
	
	public QuickConnectionDB2(String sourceName, String jdbcDriver, String userId, String password, String jdbcURL){
		
		this.sourceName = sourceName;
		this.jdbcDriver = jdbcDriver;
		this.userId = userId;
		this.password = password;
		this.jdbcURL = jdbcURL;
	}
	
	
	public void executeWizard(){
		
		selectConnectionWizard(DBsource);
		
		selectODBConnection();
		
		RadioOption c = new RadioOption("Create a new Data Source Name", null, null, null, null,WINDOWS_DEFAULT_FONT);
		applyOption("Add a Data Source", c);

		DropDownOption d1 = new DropDownOption ("Create a new Data Source Name (DSN) with the driver", true, driverName, null, null, null, null,WINDOWS_DEFAULT_FONT);		
		d1.applyOption(this);
		
		leftClickMid(this.findComponent("Connect", "Button", null));
		delay(6000);
		
		//Data Source options
		assertWindow("ODBC IBM DB2 Driver - Add");
		
		TextFieldOption dsn = new TextFieldOption("Data source name", false , sourceName, null, null,  null, null,MS_SHELL_DLG_FONT);
		//dsn.setX2(50);
		dsn.applyOption(this);
		
		DropDownOption d2 = new DropDownOption ("Database alias", false, databaseName , null, null, null, null,MS_SHELL_DLG_FONT);		
		d2.applyOption(this);
		
		leftClickMid(this.findComponent("OK", "Button", null));
		
		escapeDialog("IBM DB2 ODBC Driver", VK_Y);
		
		dataSourceOptions();
	
	}



	public void executeODBConnection() {
		
		selectODBConnections();
		
		selectODBCDataSource(sourceName);
		
		dataSourceOptions();
			
		
	}
	
	public void dataSourceOptions(){
		

		
		//Data Source options
		delay(3000);
		assertWindow("Connect To DB2 Database");
		
		
		TextFieldOption userID = new TextFieldOption("User ID", false , userId, null, null,  null, null,MS_SHELL_DLG_FONT);
		userID.setX2(150);
		userID.applyOption(this);
		
		delay(1000);
		
		TextFieldOption Password = new TextFieldOption("Password", false , password, null, null,  null, null,MS_SHELL_DLG_FONT);
		Password.setX2(150);		
		Password.applyOption(this);
		
		delay(1000);
		
		leftClickMid(this.findComponent("OK", "Button", null));
		delay(59000);
		
		
        //How Do You Want the Datasource to Communicate with the Server?
		/*
		 * not allowed since v2012
		 * 
		 * delay(2000);
		assertWindow("How Do You Want the Datasource to Communicate with the Server?");
		
		RadioOption h = new RadioOption("Natively", null, null, null, null, WINDOWS_DEFAULT_FONT);
		applyOption("How Do You Want the Datasource to Communicate with the Server?", h);
		
		leftClickMid(this.findComponent("OK", "Button", null));
		delay(500);
		*/
		
		delay(2000);
		//confirmation data sorce name 
		setADataSourceName(sourceName);	
		
	}
	
	public void executeJDBConnection() {
		
		selectJDBConnections();
		
		selectJDBCDataSource(jdbcDriver, userId, password, jdbcURL);
		
		setADataSourceName(sourceName + "_jdbc");
		delay(10000);
		
		
	}

	
	
}
