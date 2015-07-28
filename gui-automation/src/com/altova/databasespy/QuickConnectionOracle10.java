package com.altova.databasespy;

import static com.altova.util.LoggerUtils.logger;

import java.awt.Rectangle;

import com.altova.robots.DropDownOption;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;

public class QuickConnectionOracle10 extends DatabaseSpyRobot{

	private String DBsource = "";
	private String sourceName = "";
	private String TNS = "";
	private String userId = "";
	private String password = "";
	private String driverName = "";
	private String jdbcDriver = "";
	private String jdbcURL = "";
	
	public QuickConnectionOracle10( String DBsource, String sourceName, String TNS, String userId, String password, String driverName  ) {
		
		this.DBsource = DBsource;
		this.sourceName = sourceName;
		this.TNS = TNS;
		this.userId = userId;
		this.password = password;
		this.driverName = driverName;
		
	}
	//Constructor for JDBC test cases
	public QuickConnectionOracle10(String sourceName, String jdbcDriver, String userId, String password, String jdbcURL){
		
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
		
		//Data Source options
		
		TextFieldOption dsn = new TextFieldOption("Data Source Name", false , sourceName, null, null,  null, null,MS_SHELL_DLG_FONT);
		dsn.setX2(50);
		dsn.applyOption(this);
		
		TextFieldOption tns = new TextFieldOption("TNS Service Name", false ,TNS, null, null,  null, null,MS_SHELL_DLG_FONT);
		tns.setX2(50);
		tns.applyOption(this);
		
		TextFieldOption userID = new TextFieldOption("User ID", false ,userId, null, null,  null, null,MS_SHELL_DLG_FONT);
		userID.setX2(150);
		userID.applyOption(this);
		
		leftClickMid(this.findComponent("OK", "Button", null));
		delay(3000);
		
		//connection window
		
		assertWindow("Oracle ODBC Driver Connect");
		
		TextFieldOption pwd = new TextFieldOption("Password", true ,password, null, null,  null, null,MS_SHELL_DLG_FONT);
		pwd.applyOption(this);
		
		leftClickMid(this.findComponent("OK", "Button", null));
		delay(1500);
		
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
		//confirmation data source name 
		setADataSourceName(sourceName);	
	}

	public void executeODBConnection() {
		
		selectODBConnections();
		
		selectODBCDataSource(sourceName);		
		
		assertWindow("Oracle ODBC Driver Connect");
		
		TextFieldOption pwd = new TextFieldOption("Password", true ,password, null, null,  null, null,MS_SHELL_DLG_FONT);
		pwd.applyOption(this);
		
		leftClickMid(this.findComponent("OK", "Button", null));
		delay(1500);
		/*
		assertWindow("How Do You Want the Datasource to Communicate with the Server?");
		
		RadioOption h = new RadioOption("Natively", null, null, null, null, WINDOWS_DEFAULT_FONT);
		applyOption("How Do You Want the Datasource to Communicate with the Server?", h);

		leftClickMid(findComponent("OK", "Button", null));
		*/
		
		setADataSourceName(sourceName);
		delay(8000);
		
	}
	
	public void executeJDBConnection() {
		
		selectJDBConnections();
		
		selectJDBCDataSource(jdbcDriver, userId, password, jdbcURL);
		
		setADataSourceName(sourceName + "_jdbc");
		delay(10000);
		
		
	}
	
}
