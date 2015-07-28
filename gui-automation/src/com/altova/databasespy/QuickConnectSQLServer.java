package com.altova.databasespy;

import static com.altova.util.LoggerUtils.logger;

import java.awt.Rectangle;

import com.altova.robots.RadioOption;
import com.altova.robots.DropDownOption;
import com.altova.robots.ScriptMistakeException;
import com.altova.robots.TextFieldOption;
import com.altova.robots.CheckboxOption;

public class QuickConnectSQLServer extends DatabaseSpyRobot {

	private String DBsource = "";
	private String sourceName = "";
	private String serverName = "";
	private String userId = "";
	private String password = "";
	private String driverName = "";
	private String databaseName = "";
	
	public QuickConnectSQLServer( String DBsource, String sourceName, String serverName, String userId, String password, String driverName, String databaseName  ) {
	
		this.DBsource = DBsource;
		this.sourceName = sourceName;
		this.serverName = serverName;
		this.userId = userId;
		this.password = password;
		this.driverName = driverName;
		this.databaseName = databaseName;
		
	}

	public void executeWizard(){
		
		selectConnectionWizard(DBsource);
		
		DropDownOption d1 = new DropDownOption ("Select a provider for the database", true, driverName, null, null, null, null,WINDOWS_DEFAULT_FONT);		
		d1.applyOption(this);
		
		leftClickMid(this.findComponent("Next", "Button", null));
		
		delay(2000);
		assertWindow("Data Link Properties");
				
		TextFieldOption d2 = new TextFieldOption("Select or enter a server name:", true ,serverName, null, null,  null, null,MS_SHELL_DLG_FONT);
		d2.applyOption(this);
		
		
		RadioOption u = new RadioOption("Use a specific user name and password:", null, null, null, null,MS_SHELL_DLG_FONT);
		applyOption("Data Link Properties", u);
		
		TextFieldOption name = new TextFieldOption("User name", false ,userId, null, null,  null, null,MS_SHELL_DLG_FONT);
		name.applyOption(this);
		
		TextFieldOption pwd = new TextFieldOption("Password", false ,password , null, null,  null, null,MS_SHELL_DLG_FONT);
		pwd.applyOption(this);
		
		CheckboxOption ca = new CheckboxOption("Allow saving password", true, null, null,  null, null,MS_SHELL_DLG_FONT);
		ca.applyOption(this);
		
		RadioOption u2 = new RadioOption("Select the database on the server:", null, null, null, null,MS_SHELL_DLG_FONT);
		applyOption("Data Link Properties", u2);
		
		TextFieldOption server = new TextFieldOption("Select the database on the server:", true ,databaseName, null, null,  null, null,MS_SHELL_DLG_FONT);
		server.applyOption(this);

		leftClickMid(this.findComponent("OK", "Button", null));
		
		delay(1500);
		
		setADataSourceName(sourceName);		

	}
	
	
}
