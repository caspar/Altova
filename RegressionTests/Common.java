package com.altova.umodel.regression.functional;


import java.io.*;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import net.hblok.io.AndFileFilter;
import net.hblok.io.DirectoryFileFilter;
import net.hblok.io.FileFilterUtils;
import net.hblok.io.FilterAdapter;
import net.hblok.io.NegateFileFilter;
import net.hblok.io.RegexFileFilter;
import net.hblok.io.RegexFilenameFilter;

import com.altova.engines.AltovaXMLFactory;
import com.altova.engines.IAltovaXMLFactory;
import static com.altova.util.Settings.*;

import static com.altova.umodel.regression.functional.UModelTestTypes.*;
import static com.altova.util.LoggerUtils.logger;
import com.altova.Depend.DependancyApplication;

/**
 * Contains common components for all regression tests. 
 * 
 * @author Phelim McConigly
 *
 */

public class Common{
	
	public static String result = "";
	public static String error = "";
		
	public static boolean TEST_MODE = false;
	public static boolean TEST_SUITE_MODE = false;
	
	public static void setTestMode(boolean b) {
		TEST_MODE = b;
	}
	public static boolean getTestMode() {
		return TEST_MODE;
	}
	public static void setTestSuiteMode(boolean b) {
		TEST_SUITE_MODE = b ;
	}
	public static boolean getTestSuiteMode() {
		return TEST_SUITE_MODE;
	}	

	
	public static int executeCommand(String command, boolean diff, DependancyApplication product) throws DoNotContinueException
	{
		logger.fine("executeCommand: " + command);
		
		if(getFlag(DEBUG_MODE)==true) {
			System.out.println("") ;
			System.out.println("cmd : " + command) ;
			System.out.println("") ;
		}
		
		setLastOutputMessage("");
		int exitVal = 1;
		try {            
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(command);	
			
			// if the user sets the PROCESS_TIMEOUT to 0, do not destroy the thread, let it run indefinitly.
			// otherwise start the destroyer with the specified (or default) timeout
			
			int timeout = getProperty(PROCESS_TIMEOUT, DEFAULT_PROCESS_TIMEOUT) ;
			if(timeout != 0) {
				Destroyer d = new Destroyer(proc, timeout , product) ;
				new Thread(d).run() ;
			}

			// now start reading the output and error
			StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERROR", diff);            
			StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT", diff);
			
			errorGobbler.start();
			outputGobbler.start();

			// wait for the program execution to finish / or timeout
			exitVal = proc.waitFor();
			
			// wait for the output and error reader (runing in own thread) to complete
			errorGobbler.join();
			outputGobbler.join();
			
			if(getFlag(DEBUG_MODE) == true ) System.out.println( "exit value:" + exitVal ) ;

		} catch (RuntimeException e) {
			exitVal = -1 ;
			if(getFlag(DEBUG_MODE)) System.out.println("ERROR : " + e.getMessage());
		} catch (Exception e) {
			exitVal = -1 ;			
			throw new DoNotContinueException("ERROR : " + " dependancy not found... ", e);
		}
		return exitVal;
	}	
	
	private static class Destroyer implements Runnable {
		
		Process p ;
		DependancyApplication pro ;
		long s ;
		long start ;
		long now ;
		long total ;
		
		Destroyer(Process process, long seconds, DependancyApplication product) {
			p = process ;
			s = seconds ;
			start = (new Date()).getTime() ;
			total = start + (s * 1000 ) ;
			pro = product ;
		}
		
		public void run(){
			now = (new Date()).getTime() ;
			
			while( now < total ) {
				
//				System.out.println("now: " + now + " start: " + start + " total:" + total ) ;
				now = (new Date()).getTime() ;
			
				try {					
					if( p.exitValue() >= 0 ) {
						return;				
					}
				} catch (IllegalThreadStateException e) {}
				try {
					Thread.sleep(50) ;
					now = (new Date()).getTime() ;
				} catch (InterruptedException e) {}
			}
			try {
				if(p.exitValue() >= 0) return;

			} catch (IllegalThreadStateException e) {}
			
			p.destroy() ;
			Common.setLastErrorMessage("Unexpected fatal error in process: " + pro.getDefaultExe() + " Process destroyed after " + s + " seconds") ;
//			return ;
			
			throw new RuntimeException("process did not return gracefully after " + s + " seconds") ;
			
		}		
	}
	
	public static String getLastOutputMessage() {
		return result;
	}
	public static void setLastOutputMessage(String op) {
		result = op;
	}
	public static void setLastErrorMessage(String e) {
		error = e;
	}
	public static String getLastErrorMessage() {
		return error;
	}
	public static void resetOutputMessage() {
		result = "";
		error = "";
	}	
	
	public static SingleOutputDocument getSingleOutputDocument(int i) {
		SingleOutputDocument doc = SingleOutputDocument.getInstance(i);
		return doc;		
	}
	public static int findAndReplace(File f, String find, String replace) {
		int status = 1;
		StringBuffer strOutput = new StringBuffer(32768);		
		try
		{
			byte[] pInput = ReadFile(f.getAbsolutePath());

			String strInput = new String(pInput);			
			if( find.equals("") || replace.equals("")) return status;
			
			int nPos = 0;
			while(true)
			{
				int nIndex = strInput.indexOf( find, nPos );
				// if args[1] can no longer be found, then copy the rest of the input
				if( nIndex < 0 )
				{
					strOutput.append( strInput.substring( nPos ) );
					status = 0;
					break;
				}
				// otherwise, replace it with args[2] and continue
				else
				{
					strOutput.append( strInput.substring( nPos, nIndex ) ) ;
					strOutput.append( replace );
					nPos = nIndex + find.length();
				}
			}
			strInput = strOutput.toString(); 
			WriteFile( f.getAbsolutePath(), strInput.getBytes() );
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return status;
	}
	
//	helper function to read a file into a byte array
	static public final byte[] ReadFile(String strFile) throws IOException
	{
		int nSize = 32768;
		BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(strFile),nSize);
		byte[] pBuffer = new byte[nSize];
		int nPos = 0;
		nPos += inStream.read(pBuffer,nPos,nSize-nPos);
		while(nPos==nSize)
		{
			byte[] pTemp = pBuffer;
			nSize *= 2;
			pBuffer = new byte[nSize];
			System.arraycopy(pTemp,0,pBuffer,0,nPos);
			nPos += inStream.read(pBuffer,nPos,nSize-nPos);
		}
		inStream.close();
		if(nPos==0)
		{
			return "".getBytes();
		}
		// return data read into the buffer as a byte array
		byte[] pData = new byte[nPos];
		System.arraycopy(pBuffer,0,pData,0,nPos);
		return pData;
	}
	
//	helper function to write a byte array into a file
	static public final void WriteFile(String strFile, byte[] pData) throws IOException
	{
		BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(strFile),32768);		
		if(pData.length>0) outStream.write(pData,0,pData.length);
		outStream.close();
	}

	public static IAltovaXMLFactory getAltovaInstance() throws IllegalAccessException {
		//request a COM server object - fails if AltovaXML is not registered
		//or if the java.library.path does not contain the AltovaXMLLib library
		IAltovaXMLFactory objXmlApp = null;
		try {			
//			Reset the "sys_paths" field of the ClassLoader to null.
//			so that whenever "System.loadLibrary" is called, it will be reconstructed with the changed value.
			Class clazz = ClassLoader.class;
			Field field = clazz.getDeclaredField("sys_paths");
			boolean accessible = field.isAccessible();
			if (!accessible) field.setAccessible(true);
			Object original = field.get(clazz);
			field.set(clazz, null);
			try {
				System.setProperty("java.library.path", "C:\\WINDOWS\\system32");					
				System.loadLibrary("AltovaXMLLib");	
			}
			finally {
				//	Revert back the changes.
				field.set(clazz, original);
				field.setAccessible(accessible);
			}						
			objXmlApp = AltovaXMLFactory.getInstance();
			
		} catch (UnsatisfiedLinkError e) {	e.printStackTrace();
		} catch (NoSuchFieldException e) {	e.printStackTrace(); }
		
		return objXmlApp ;
		
	}

	/**
	 * filters CVS dirs from files and returns List<File>
	 * 
	 * @param src
	 * @return
	 */
	public static List<File> filterCVS(File src) {
		DirectoryFileFilter dirs = new DirectoryFileFilter();		
		//FilterAdapter fd = new FilterAdapter(new RegexFilenameFilter("CVS"));
		FilterAdapter fd = new FilterAdapter(new RegexFilenameFilter("svn"));
		NegateFileFilter notcvs = new NegateFileFilter(fd);		
		AndFileFilter and = new AndFileFilter(dirs, notcvs);
		
		System.out.println(">>>>src:" + src);
		System.out.println(">>>>and:" + and);
				
		return FileFilterUtils.listfiles(src, and, false);		
	}
	
	public static List<File> filterFilesCVS(File src, boolean recurse) {
		return filterFilesCVS(src, recurse, "") ;
	}

	public static List<File> filterFilesCVS(File src, boolean recurse, String extension) {
		RegexFileFilter extPath = new RegexFileFilter(".*" + extension);
		//FilterAdapter fd = new FilterAdapter(new RegexFilenameFilter("CVS"));		
		FilterAdapter fd = new FilterAdapter(new RegexFilenameFilter("svn"));
		NegateFileFilter notcvs = new NegateFileFilter(fd);
		AndFileFilter and = new AndFileFilter(extPath, notcvs);		
		return FileFilterUtils.listfiles(src, and, recurse);		
	}	
}

	