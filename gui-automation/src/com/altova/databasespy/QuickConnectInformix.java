package com.altova.databasespy;

import java.awt.Rectangle;

import com.altova.robots.DropDownOption;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;

public class QuickConnectInformix extends DatabaseSpyRobot{

	private String DBsource = "";
	private String sourceName = "";
	private String serverName = "";
	private String hostname = "";
	private String service = "";
	private String protocol = "";
	private String user = "";
	private String password = "";
	private String database = "";
	private String driver = "";
	//private String jdbcDriver = "";
	//private String jdbcURL = "";
	
	
	public QuickConnectInformix( String DBsource, String sourceName, String serverName, String hostname, String service, String protocol, String user, String password, String database, String driver   ) {
		
		this.DBsource = DBsource;
		this.sourceName = sourceName;
		this.serverName = serverName;
		this.hostname = hostname;
		this.service = service;
		this.protocol = protocol;
		this.user = user;
		this.password = password;
		this.database = database;
		this.driver = driver;
		
	}

	
	
	public void executeWizard(){
		
		selectConnectionWizard(DBsource);
		
		selectODBConnection();

		RadioOption c = new RadioOption("Create a new Data Source Name", null, null, null, null,WINDOWS_DEFAULT_FONT);
		applyOption("Add a Data Source", c);

		DropDownOption d1 = new DropDownOption ("Create a new Data Source Name (DSN) with the driver", true, driver, null, null, null, null,WINDOWS_DEFAULT_FONT);		
		d1.applyOption(this);
		
		leftClickMid(this.findComponent("Connect", "Button", null));
		delay(6000);

		//Data Source options
		assertWindow("IBM Informix ODBC Driver Setup");
		
		TextFieldOption dsn = new TextFieldOption ("Data Source Name", sourceName, null, null, null, "General"); 
		dsn.setX2(100);
		dsn.applyOption(this);
		
		//optional(should be retrieved by Informix driver configuration)
		TextFieldOption srv = new TextFieldOption ("Server Name", serverName, null, null, null, "Connection");
		srv.setX2(150);
		srv.applyOption(this);
		
		TextFieldOption host = new TextFieldOption ("Host Name", hostname, null, null, null, "Connection");
		host.setX2(150);
		host.applyOption(this);
		
		TextFieldOption ser = new TextFieldOption ("Service", service, null, null, null, "Connection");
		ser.setX2(150);
		ser.applyOption(this);
		
		DropDownOption prot = new DropDownOption ("Protocol",false, protocol, null, null, 	null, "Connection");
		prot.setX1(100);
		prot.applyOption(this);

		//mandatory
		TextFieldOption usr = new TextFieldOption ("User Id", user, null, null, null, "Connection");
		usr.setX2(150);
		usr.applyOption(this);
		
		TextFieldOption pwd = new TextFieldOption ("Password", password, null, null, null, "Connection");
		pwd.setX2(150);
		pwd.applyOption(this);

		TextFieldOption dbn = new TextFieldOption ("Database Name", database, null, null, null, "Connection");
		dbn.setX2(150);
		dbn.applyOption(this);

		leftClickMid(this.findComponent("OK", "Button", null));
		
		setADataSourceName(sourceName);	
	}
	
	public void executeODBConnection() {
		
		selectODBConnections();
		
		Rectangle res = findString(sourceName, DEFAULT_CONTENT_FONT);
		
		if (res != null)
			leftClickMid(res);
		
		delay(500);
		
		
		
		leftClickMid(this.findComponent("Connect", "Button", null));

		setADataSourceName(sourceName);
		delay(5000);
		
	}
	
	
	
	
}
