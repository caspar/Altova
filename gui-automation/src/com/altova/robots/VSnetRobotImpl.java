package com.altova.robots;

import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.*;


public class VSnetRobotImpl implements VSnetRobot {

	protected AltovaApplicationRobot robot;

	public VSnetRobotImpl(AltovaApplicationRobot robot) {
		this.robot = robot;
	}

	public void escapePluginDialogs(String message) {
		logger.fine(message);
		robot.addEscapeDialogAction("Save changes to the following items?",VK_N);
		
		
	}
	
	
	
	public String getExtraHelpMenus(){
		return "Registration and Web Links";
	}
}
