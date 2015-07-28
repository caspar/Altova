package com.altova.common.testcases;

import com.altova.robots.AltovaApplicationRobot;

/**
 * Basic test for launching an Altova application and verifying startup and shutdown.
 * It will report status to standard out (stdout or System.out). 
 * 
 * @author Havard Rast Blok
 *
 */
public class LaunchTest {

	protected String appName;
	
	protected AltovaApplicationRobot robot;
	
	protected String errorMsg;
	
	protected Integer counter;
	
	protected boolean ok = false;
	
	public LaunchTest(String appName) {
		this.appName = appName;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public boolean isOk() {
		return ok;
	}

	public void start() {
		try {
			counter=0;
			robot = AltovaApplicationRobot.getProductRobot(appName);
			robot.startApplication();
			robot.delay(1000);
			errorMsg = "Did not detect the running application";
			while ((!robot.isApplicationFront())&&(counter<10)) {
				counter++;
			}
			ok = robot.isApplicationFront();
			robot.exitApplication();
			robot.delay(1000);
			//TODO: check that application is no longer resident in memory here
		}
		catch(Exception e) {
			errorMsg = e.getMessage();
			e.printStackTrace();
		}
	}
	
	private void writeOutput() {
		String msg = (ok)?"OK":"FAILED: "+errorMsg;
		System.out.println(msg);
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args == null || args.length != 1) {
			System.err.println("Usage: LaunchTest [application name] [ALTOVA_DIR=Altova_v2007] [XMLSPY_DIR=XMLSpy2007]");
			System.err.println("");
			System.err.println("Valid product names include:");
			
			//the list of known products is a static generated list on the top of the AltovaApplicationRobot class
			for(String s : AltovaApplicationRobot.getKnownProducts()) {
				System.err.print(s+", ");
			}
			System.exit(1);
		}
		
		LaunchTest test = new LaunchTest(args[0]);
		test.start();
		test.writeOutput();
	}


}
