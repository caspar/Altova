package com.altova.umodel.regression.functional;
import java.io.*;
/**
 * Eats unneccessary streams and retrieves output
 * 
 * @author Phelim McConigly
 *
 */

public class StreamGobbler extends Thread {
	InputStream is;
	String type;
	String output = "";
	boolean diff = false; 
	
	StreamGobbler(InputStream is, String type, boolean diff)
	{
		this.is = is;
		this.type = type;
		this.diff = diff;
	}
	
	public void run()
	{
		try
		{
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line=null;
			while ( (line = br.readLine()) != null) {
				if(diff == true) output += line + "\n";
				else output += line ;
			}
			
//			System.out.println("RESULT: " + output);
			if (!output.equals(null)) { 
					if(type.equals("OUTPUT")) Common.setLastOutputMessage(output);
					else if (type.equals("ERROR")) Common.setLastErrorMessage(output);
			}
		} catch (IOException ioe)
		{
			ioe.printStackTrace();  
		}
	}
}
