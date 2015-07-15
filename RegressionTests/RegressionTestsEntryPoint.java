package com.altova.umodel.regression.functional;

import static com.altova.util.LoggerUtils.logger;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import com.altova.util.Settings;

/**
 * UModel Regression Tests Entry Point 
 * 
 * @author Phelim McConigly
 *
 */
public class RegressionTestsEntryPoint {
	public static void main (String[] args)
	{	
		int active = 0;
		
		logger.fine("starting umodel regression tests") ;
		
		
		UModelRegressionTest u = new UModelRegressionTest(args);
			
			if(u.checkEnvironment()) {
					
				Common.setTestMode(false); // one test case per suite set to true below...
				Common.setTestSuiteMode(false);
				if ((Common.getTestMode()) || (Common.getTestSuiteMode())) {}
		
				try {
					
					active += u.setupBinaryImport();
					
					active += u.setupCodeGeneration();
			
					active += u.setupXMI();				
					
					active += u.setupMerge();	
					
					active += u.robotModelEdit();	
			
					active += u.xsd();
					
					active += u.setupSyntaxCheck() ;
					
					// u.rte();
					
				} catch (Exception e) {
					e.printStackTrace();
				}		
				
				if(active == 0) {
					System.out.println( "no tests keys active, or incorrect properties filename : " ) ; 
					System.out.println( Settings.getProperty(Settings.AUTOMATION_CONFIG_FILE[0])) ;
				}
			}
		
		System.exit(0) ;
	}



private static void displayUsage(String[] args) {
		if(args.length > 0) {
			if(args[0].equals("/?") || args[0].equals("--help") || args[0].equals("-?")) {

				System.out.println("//? or //help 	... display this help information");
				System.out.println("usage: Runtests [properties-file] (see documentation)") ;
				
				System.exit(0);		
			}
		}		
	}	

		
	public static Date getCurrentTime() {
		Calendar cal = Calendar.getInstance();
		if (cal == null) return null;  
		return cal.getTime();
	}
}
