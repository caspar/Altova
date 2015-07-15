package com.altova.umodel.regression.functional;

import static com.altova.umodel.regression.functional.SingleOutputDocument.*;
import static com.altova.umodel.regression.functional.UModelTestTypes.*;
import static com.altova.Depend.*;
import static com.altova.util.Settings.*;

import java.io.*;

import org.w3c.dom.Node;

import com.altova.robots.ScriptMistakeException;
import com.altova.util.Settings;
import com.altova.util.Settings.AltovaApplication;

/**
 * UModel Regression Tests Binary Import
 * 
 * @author Phelim McConigly
 *
 */

public class TestBinaryImport extends TestBase{
	
//	contains a list of jars and dependencies to be imported and the order they should maintain
	private static final String INSTRUCTIONS_FILE = "instructions-BinList.txt"; 
	
	// iclg[=clg] ... code language ( Java5.0 | C#2.0 )
	private static String codeLanguage;
	
	public TestBinaryImport(String key, String codeLang, int log, Node root) {
	
		setTestKey(key);
		setSourceDir();
		setRefDir();


//		if (!Common.TEST_MODE) srcDirectory = new File(rootDirectory.getAbsoluteFile() + "//src" ) ;
//		else srcDirectory = new File(rootDirectory.getAbsoluteFile() + "//src-1-test-case-only" ) ;
			
		codeLanguage = codeLang;		
		sod = Common.getSingleOutputDocument(log);		
		projectNode = sod.logE(root, PROJECT_TYPE_EL) ;
		sod.logA(projectNode, PROJECT_TYPE_ATT, testKey) ;		
	}
	
	public void setupTest(File f) {
		
		testDir = f;		
		testLogDir = getLogDir(f) ; 
		if(!getFlag(COPY_TO_REF)) testLogDir .mkdirs() ;


		System.out.println("source :" + testDir.getName());
		System.out.println("log :	" + testLogDir.getAbsolutePath());
		
		testNode = sod.logE(projectNode, TEST_FILE_EL) ;
		sod.logA(testNode, NAME_ATT, testDir.getName()) ;		
		set_ui_settings();		
	}
	
	public void copyToSrc(String outputCGDirName, String filename) {
		try {
			String in = srcDirectory.getAbsolutePath() + "\\" + testDir.getName() + filename;
			copyProjectFileToDir( new File(in), outputCGDirName );
			}
		catch ( FileNotFoundException fnfe ) { fnfe.printStackTrace(); }
		catch ( IOException ioe ) { ioe.printStackTrace(); }		
	}
	
	public void importSource() throws DoNotContinueException
	{
		if(getFlag(DEBUG_MODE)) System.out.println("importSource") ;
		
		int status = -1;
		String cmd = "";
		String result = "";		
		
		Node n = sod.logE(testNode, STEP_EL) ;
		sod.logA(n, STEP_ATT, IMPORT_STEP_ATT);
		
		String outputCGDirName = testLogDir.getAbsolutePath() ;	
		cmd = "\"" +  getUModelBatchExe() + "\" /new=\""	+ outputCGDirName + "\\source_"	+ testDir.getName() + ".ump\""; 

		if (testKey.equals(BIN_JAVA5_DIR))	
			cmd += " /isd=\"" + testDir.getAbsolutePath() + "\" /iclg=\"" + codeLanguage + "\" /ipsd=1 /chk";			
		else if (testKey.equals(BIN_CS_DIR)) 	
			cmd += " /isd=\"" + testDir.getAbsolutePath() + "\" /iclg=" + codeLanguage + " /ipsd=1 /chk";
		else result = "Invalid type specified: " + testKey;
		
		status = Common.executeCommand( cmd , false , DependancyApplication.UMODEL);
		result += Common.getLastOutputMessage();
		if(result.equals("")) result = Common.getLastErrorMessage();
		
		sod.logE(n, CMD_INPUT_EL, cmd) ;
		sod.logE(n, CMD_OUTPUT_EL, result) ;
		sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));
	}

	public int importBinary() throws DoNotContinueException
	{
		if(getFlag(DEBUG_MODE)) System.out.println("importBinary") ;
		
		int status = -1;
		String result = "";
		
		Node n = sod.logE(testNode, STEP_EL) ;
		sod.logA(n, STEP_ATT, IMPORT_BINARY_STEP_ATT);
		
		// "/new=C:\UModelRegressionTests\test-cases\binaries\test\char\TEST.ump" 
		// /testDir"/ibt=*C:\WINDOWS\Microsoft.NET\Framework\v2.0.50727\mscorlib.dll"
		
		String cmd = "\"" + getUModelBatchExe() + "\" /new=\""	+ testLogDir.getAbsolutePath() + "\\" + testDir.getName() + ".ump\""; 
		//The condition must be satistied that the dir name is the same as the sln, csdproj, jpx or bdsproj file.

		String jre = convertToIBRT(getProperty(JAVA_HOME)) ;
		if (testKey.equals(BINARY_JAVA_5))	{ 
			
			cmd += " \"/ibt=" ; 

			try {
				// eg: annotations need tools.jar for class type resolution
				cmd += getBinariesForImport();	//instructions.txt

				
			} catch (FileNotFoundException e) {
				/*Do nothing here, it does not have to be present if no jar files are needed*/
			}			

			cmd += "*" + testDir.getAbsolutePath() + "\" /iclg=\"" + codeLanguage + "\" /ibrt=" + jre + " /ipsd=1 /dgen=1 /chk";
		}
		
		else if (testKey.equals(BINARY_CS_2_0)) {
			//find correct method of import: dll, exe,
			String s = "";
			try {
				// get list of binaries to import from text file, if it exists
				s = getBinariesAndOptionsForImport();	//instructions.txt		
			} catch (FileNotFoundException e) {
				/*Do nothing here, it does not have to be present*/
			}			
			if(s.equals("")) {
				// No text file with list of binaries to import. Search for binaries.
				s = findExeOrDllForImport();
				s = "\"" + s + "\"";
			}
			if(s.equals("")) result = "No c# import binary type found for selection";
			else {
				cmd +=  " /iclg=\"" + codeLanguage + "\"  /ibt=";
				cmd += s + " /ibrt=.NET2.0 /ipsd=1 /dgen=1 /chk";
			}
		}

		else if (testKey.equals(BINARY_JAVA_5_JAR)) {
			String s = "";
			try {
				s = getBinariesAndOptionsForImport();	//instructions.txt
				cmd += " /iclg=\"" + codeLanguage + "\" /ibt=" + s + " /ibrt=" + jre + " /ipsd=1 /dgen=1 /chk";
			}catch (FileNotFoundException e) { throw new DoNotContinueException(e.getMessage()); }
		}
		
		else if ((testKey.equals(BINARY_VB_8_KEYWORDS)) || (testKey.equals(BINARY_VB_8_LANG_SPEC))) {
			//find correct method of import: dll, exe,
			String s = "";
			try {
				// get list of binaries to import from text file, if it exists
				s += getBinariesAndOptionsForImport();	//instructions.txt
				
			} catch (FileNotFoundException e) {
				/*Do nothing here, it does not have to be present*/
			}			
			if(s.equals("")) {
				// No text file with list of binaries to import. Search for binaries.
				s = findExeOrDllForImport();
				s = "\"" + s + "\"";
			}
			
			if(s.equals("")) result = "No VB import binary type found for selection";
			else {
				cmd +=  " /iclg=\"" + codeLanguage + "\" /ibt=";
				cmd += s + " /ibrt=.NET2.0 /ipsd=1 /dgen=1 /chk";
			}
		}
		else if ((testKey.equals(BINARY_VB_9))|| (testKey.equals(BINARY_CS_3_0)) || (testKey.equals(BINARY_CS_4_0))) {
			//find correct method of import: dll, exe,
			String s = "";
			try {
				// get list of binaries to import from text file, if it exists
				s += getBinariesAndOptionsForImport();	//instructions.txt
				
			} catch (FileNotFoundException e) {
				/*Do nothing here, it does not have to be present*/
			}			
			if(s.equals("")) {
				// No text file with list of binaries to import. Search for binaries.
				s = findExeOrDllForImport();
				s = "\"" + s + "\"";
			}
			
			if(s.equals("")) result = "No VB0 or CS 3.0-4.0 import binary type found for selection";
			else {
				cmd +=  " /iclg=\"" + codeLanguage + "\"  /ibt=";
				cmd += s + " /ibrt=.NET3.5 /ipsd=1 /dgen=1 /chk";
			}
		}
		else result = "Invalid type specified: " + testKey ;


		if(getFlag(DEBUG_MODE) == true) System.out.println(cmd) ;
		
		if(result.equals("")) {
			status = Common.executeCommand( cmd , false, DependancyApplication.UMODEL );
			result += Common.getLastOutputMessage();
		}
		if(result.equals("")) result = Common.getLastErrorMessage();
		sod.logE(n, CMD_INPUT_EL, cmd) ;
		sod.logE(n, CMD_OUTPUT_EL, result) ;
		sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));
		
		return status ;
	}
	
	public String convertToIBRT(String JAVA_HOME) throws ScriptMistakeException {
		if(JAVA_HOME.equals("")) throw new ScriptMistakeException("JAVA_HOME not found...") ;
		return JAVA_HOME.substring(JAVA_HOME.lastIndexOf("\\") +1, JAVA_HOME.length()).toUpperCase();
	}
	//need to find list of executables or dlls from directory to add to command string...
	public String findExeOrDllForImport() {
		String s = "";
		
		for(File f : testDir.listFiles()) {
			if((f.getName().endsWith(".exe")) || (f.getName().endsWith(".dll"))) {
				s +="*" + f.getAbsolutePath() + ";";
			}
		}
		return s ;
	}	
	
	private String getBinaryFileName(String b) throws NullPointerException { 
		return b + testDir.getName() + ".ump";
	}
	private String getBinariesAndOptionsForImport() throws DoNotContinueException, FileNotFoundException{
	
		try {
			String temp = "", s = ""; 
			temp += getBinariesForImport();	//instructions.txt
			int i = temp.indexOf("/");
			if ( i > -1) 
				s += "\"" + temp.substring(0, i) + "\" " + temp.substring(i);  
			else
				s += "\"" + temp + "\"" ;
			return s;
		}
		catch (DoNotContinueException e) { throw new DoNotContinueException(e.getMessage()); }

	}
	private StringBuffer getBinariesForImport() throws DoNotContinueException, FileNotFoundException{
		BufferedReader input = null;
		StringBuffer contents = new StringBuffer();
		boolean filefound = false;
		for(File f : testDir.listFiles()) {
			if ( f.getName().equals(INSTRUCTIONS_FILE)) {
				try {
					filefound = true;
					input = new BufferedReader( new FileReader(f) );
					String line = null;
					while (( line = input.readLine()) != null){
						int end = f.getAbsolutePath().lastIndexOf("\\");
						String path = f.getAbsolutePath().substring(0, end );
						boolean star = false;						
						if(line.startsWith("*")) { 
							star = true; 
							line = line.substring(1, line.length()); 
						}																		
						// File check = new File(path + "\\" + line);
						
						// if ( ! check.exists() ) continue;						
						
						if (star) contents.append("*");				
						
						if (line.startsWith("#"))
							// this is a binary in an assembly
							contents.append(line + ";");
						if (line.startsWith("/"))
							// this line contains the options for binary import
							contents.append(line);
						else
							// prefix pathname for binary not in an assembly
							contents.append(path + "\\" + line + ";");
					}
					return contents;
				} 
				catch (FileNotFoundException e) { throw new DoNotContinueException(e.getMessage()); }
				catch (IOException e) { throw new DoNotContinueException(e.getMessage()); }
			}			 
		}	
		if ( !filefound ) throw new FileNotFoundException("No file found: " + INSTRUCTIONS_FILE);
		else return contents;
	}
	
	public void umpDiffTests() throws DoNotContinueException {
		
		if(getFlag(DEBUG_MODE)) System.out.println("umpDiffTests") ;
		
		String outputDirName = testLogDir.getAbsolutePath() ;
		
		File fBinaryImportUmp = new File(outputDirName + "\\" + testDir.getName() + ".ump");
		if(!fBinaryImportUmp.exists()) throw new DoNotContinueException("created ump test case file -> " + testDir.getName());

		//************************************************************************************************
		//change: reference ump file binary_*test-case-name*.ump used for comparison, not source-import-ump
		//this is due to the great number of differences between source and binary imports, due to compiler options,
		//always-generated constructors, no-values for properties unless statically initialised etc
		//************************************************************************************************
		Node n = sod.logE(testNode, SingleOutputDocument.STEP_EL) ;
		
		File refUmpFile = new File(refDirectory.getAbsolutePath() + "\\" + testDir.getName()+ "\\" + testDir.getName() + ".ump");
		System.out.println("1)File refUmpFile to comp:" + refUmpFile.getAbsolutePath());
		
		File fBinaryReferenceUmp = new File(testLogDir.getAbsolutePath() + "\\" + testDir.getName() + "-ref.ump");
		System.out.println("2)File fBinaryReferenceUmp to comp:" + fBinaryReferenceUmp.getAbsolutePath());
		if ( refUmpFile.isFile() && refUmpFile.exists() ) {	
			try {
				System.out.println("3)Start coping...");
				copyRenameProjectFileToDir(refUmpFile,fBinaryReferenceUmp);
				System.out.println("4)File copied");
			}catch (Exception e) {
				throw new DoNotContinueException("Error copying reference ump file", e) ;
			}
		}
		else {
			System.out.println("!!!!)refUmpFile.isFile()?" + refUmpFile.isFile());
			System.out.println("!!!!!)refUmpFile.exists()?" + refUmpFile.exists());
			sod.logA(n, STEP_ATT, COMPARE_UMP_STEP_ATT );
			sod.logA(n, STATUS_ATT, STATUS_FAIL );			
			sod.logA(n, FILE_ATT, "file not found:" + fBinaryReferenceUmp.getAbsolutePath());
			
			throw new DoNotContinueException("binary reference file -> " + testDir.getName());
		}
		compareUMP(fBinaryImportUmp, fBinaryReferenceUmp, n);
	}
	
	private void copyProjectFileToDir(File in, String outDirName) throws FileNotFoundException, IOException{
			File out = new File (outDirName + "\\" + in.getName()); 
			FileInputStream fis  = new FileInputStream(in);
			FileOutputStream fos = new FileOutputStream(out);
			byte[] buf = new byte[1024];
			int i = 0;
			while((i=fis.read(buf))!=-1) {
				fos.write(buf, 0, i);
			}
			fis.close();
			fos.close();
	}
}
