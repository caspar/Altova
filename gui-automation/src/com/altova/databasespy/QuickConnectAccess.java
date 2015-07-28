package com.altova.databasespy;

import static java.awt.event.KeyEvent.VK_ENTER;

import com.altova.robots.ScriptMistakeException;
import com.altova.robots.TextFieldOption;


public class QuickConnectAccess extends DatabaseSpyRobot{

	private String DBsource = "";
	private String filename = "";
	private String sourceName = "";
	
	public QuickConnectAccess(String DBsource, String filename, String sourceName ){
		
		this.DBsource = DBsource;
		this.filename = filename;
		this.sourceName = sourceName;
		
	}
	
	
	public void executeWizard(){
		
		selectConnectionWizard(DBsource);
		
		TextFieldOption t = new TextFieldOption("Click on browse and select", true ,filename, null, null,  null, null,WINDOWS_DEFAULT_FONT);
		t.setY1(90);
		t.applyOption(this);
		
		try{
			leftClickMid(findComponent("Connect", "Button", null));
		
		}catch(ScriptMistakeException e){
			keyType(VK_ENTER);
		}
		delay(1000);
		
		setADataSourceName(sourceName);
		
	}
	
	
	
	
}
