package com.altova.umodel.regression.functional;

import static com.altova.umodel.regression.functional.SingleOutputDocument.*;
import static com.altova.util.Settings.*;
import static com.altova.Depend.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.w3c.dom.Node;

import com.altova.Depend.DependancyApplication;
import com.altova.robots.ScriptMistakeException;
import com.altova.util.Settings.AltovaApplication;

import static com.altova.umodel.regression.functional.UModelTestTypes.*;

/**
 * UModel Regression Tests Code Generation
 * 
 * @author Phelim McConigly
 *
 */

public class TestCodeGen extends TestBase{


	static final String NO_ERRORS_STRING = "0 error";
	static final String NO_WARNING_STRING = "0 warning";

	private static File referenceDirectory = null;
	
	// iclg[=clg] ... code language (Java1.4 | Java5.0 | Java8.0 | Java7.0 | C#2.0)
	private String codeLanguage;
	private File generatedCodeUMP;
	boolean sed = false;
	
	/**
	 * @param key
	 * @param codeLang
	 * @param log
	 */
	public TestCodeGen (String key, String codeLang, int log, Node root) {
		
		setTestKey(key);
		setSourceDir();
		setRefDir();
		codeLanguage = codeLang;
		sod = Common.getSingleOutputDocument(log);		
		projectNode = sod.logE(root, PROJECT_TYPE_EL) ;
		sod.logA(projectNode, PROJECT_TYPE_ATT, testKey) ;		
	}
	
	/**
	 * @param f
	 * @return
	 */
	public void setupTest(File f) {
		
		if(getFlag(DEBUG_MODE)) System.out.println("setupTest") ;
		
		testDir = f;		
		testLogDir = getLogDir(f);
		// If we are to copy ump files to the reference directory then
		// no need to create the log directories. They should already be there.
		if(!getFlag(COPY_TO_REF)) testLogDir .mkdirs() ;

		System.out.println("source	: " + testDir.getName());
		System.out.println("log 	: " + testLogDir.getAbsolutePath());

		String path = testDir.getAbsolutePath();
		path = path.substring( 0, path.lastIndexOf( "\\" ) );
		path = path.substring( path.lastIndexOf( "\\" ), path.length() );
		path = path + "\\" + testDir.getName();

		testNode = sod.logE(projectNode, TEST_FILE_EL) ;
		sod.logA(testNode, NAME_ATT, testDir.getName()) ;
		set_ui_settings();		

		// do we need steps node? has it been removed in some locations?
		// everything seems to get added to testNode now, removing the need for STEPS/STEP 
		// Node stepsNode = resultDoc.setDOMElement(testFileNode, STEPS_EL);
		sed = false ;
		
	}
	
	public boolean importSourceCode() throws DoNotContinueException
	{
		if(getFlag(DEBUG_MODE)) System.out.println("importSourceCode") ;
		
		int status = -1;
		String cmd = "";
		String result = "";
		//we should be in the source directory already at this stage.
		Node n = sod.logE(testNode, STEP_EL);
		sod.logA( n , STEP_ATT, IMPORT_STEP_ATT);		

		try {
			if ( testLogDir.isDirectory() && testLogDir.exists() ) {
			
				File newUmpFile = new File(testLogDir.getAbsolutePath(), (testDir.getName() + ".ump"));
				
				sod.logA(n, SingleOutputDocument.FILE_ATT, newUmpFile.getPath() );
					
				File projDepend = new File ( getProjectDependencies(true) ) ;
				
				cmd = "\"" + getUModelBatchExe() + "\" /new=\"" + newUmpFile + "\"";				
				if(projDepend.isDirectory()) cmd += " /isd=\"" + projDepend.getAbsolutePath() + "\"" ; // getProjectDependencies(true) ;
				else if(projDepend.isFile()) cmd += " /isp=\"" + projDepend.getAbsolutePath() + "\"" ; // getProjectDependencies(true) ;
				cmd += " /iclg=" + codeLanguage + " /ipsd=1 /dgen=1 /dopn=0 /irpf=0 /chk";				 
				
				if(projDepend.isFile()) copyDependsToSource(projDepend) ;
				
				status = Common.executeCommand( cmd , false , DependancyApplication.UMODEL);
				
				result += Common.getLastOutputMessage();
				if(result.equals("")) result = Common.getLastErrorMessage();				
			} else result = "file not found: " + testDir.getAbsolutePath();		
		} 
		catch ( ScriptMistakeException e ) {
			e.printStackTrace() ; //TODO handle error - Invalid test case?
			status = -1 ;
			result = "invalid test case : " + e.getMessage() ;
		}
		catch ( FileNotFoundException fnfe ) { 
			fnfe.printStackTrace(); //TODO handle error
			status = -1 ;
			result = "invalid test case : file not found exception : " + fnfe.getMessage() ;
		}
		catch ( IOException ioe ) { 
			ioe.printStackTrace(); //TODO handle error
			status = -1 ;
			result = "io exception : " + ioe.getMessage() ;
		}
		catch ( DoNotContinueException e ) { 
			e.printStackTrace(); //TODO handle error
			status = -1 ;
			result = "exception : " + e.getMessage() ;
		}		
		sod.logE(n, CMD_INPUT_EL, cmd) ;
		sod.logE(n, CMD_OUTPUT_EL, result) ;
		sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));
		
		return (status == 0) ? true : false ;
	}
	
	/**
	 * @param stepsNode
	 * @throws DoNotContinueException
	 */
	public boolean generateCode() throws DoNotContinueException
	{
		if(getFlag(DEBUG_MODE)) System.out.println("generateCode") ;
		int status = -1;
		String cmd = "";
		String result = "";
		
		sed = false ;
		
		Node n = sod.logE(testNode, STEP_EL);
		sod.logA( n , STEP_ATT, GENERATE_STEP_ATT);		
		
		String outputCGDirName = testLogDir.getAbsolutePath() ;

		umpFile = new File(testLogDir.getAbsolutePath() + "\\" + testDir.getName() + ".ump");
		
		try {
			
			if ( umpFile.isFile() && umpFile.exists() ) {	
				Common.resetOutputMessage();
				
				umpSedReplace = new File (umpFile.getParentFile().getAbsolutePath() , "copy_".concat(umpFile.getName())) ;
//				Modify the destination directory for code generation in the ump file
//				so that the code is generated to the test log directory				
				if(!(containsSpaceChar(testDir)) && containsSpaceChar(outputCGDirName)){ 
					sed = true ;
					cmd = 	"\'" + testDir.getAbsolutePath() + "\' " +			/*arg2 - text to find*/
							"\'" + outputCGDirName + "\'" ; 					/*arg3 - text replace*/					
	
					cmd = SED_TEXT_REPLACE.getAbsolutePath() + " " + 			/*arg1 - input file*/
						"\"" + umpFile.getAbsolutePath() + "\" " +   
						cmd.replaceAll("\\\\", "\\\\\\\\\\\\\\\\") + " " +		/*!*/
						"\"" + umpSedReplace.getAbsolutePath() + "\""; 			/*arg4 - output file */
				} else {
					cmd = "\"" + DOSSR + "\" \"" + umpFile.getAbsolutePath() + "\" \"" + testDir.getAbsolutePath() + "\" \"" + outputCGDirName + "\"" ;
				}
				
				status = Common.executeCommand( cmd , false , ((sed)? DependancyApplication.SED_TEXT_REPLACE : DependancyApplication.DOSSR));
				result += Common.getLastOutputMessage();
				Common.resetOutputMessage();
				cmd = "\"" + getUModelBatchExe() + "\" \"" + 
				((sed) ? umpSedReplace.getAbsolutePath() : umpFile.getAbsolutePath()) +   
					"\" /m2c /ejdc=1 /egfn=1 /eusc=1";
				status = Common.executeCommand( cmd , false , ((sed)? DependancyApplication.SED_TEXT_REPLACE : DependancyApplication.DOSSR));
				result += Common.getLastOutputMessage();
				if(result.equals("")) result = Common.getLastErrorMessage();
			} else result += "file not found: " + umpFile.getAbsolutePath();
		} catch (Exception e) {
			status = -1 ;
			e.printStackTrace() ;
			throw new DoNotContinueException("Exception" , e);			
		}
		
		sod.logE(n, CMD_INPUT_EL, cmd) ;
		sod.logE(n, CMD_OUTPUT_EL, result) ;
		sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));
		
		return (status == 0) ? true : false ;
	}
	
	/**
	 * @param stepsNode
	 * @throws DoNotContinueException
	 */
	public boolean compareCode()  throws DoNotContinueException
	{
		if(getFlag(DEBUG_MODE)) System.out.println("compareCode") ;
		
		for(File f : testLogDir.listFiles())
		if(!containsOr(f.getName(), ".ump", ".project", ".classpath", ".bdsproj", ".csdproj", ".csproj", ".sln", ".jpx")) {
			return compareFiles(f);
		}
		return true ; //nothing to compare, continue anyway
	}

	/**
	 * @param stepsNode
	 * @throws DoNotContinueException
	 */
	public boolean importGeneratedCode() throws DoNotContinueException
	{
		if(getFlag(DEBUG_MODE)) System.out.println("importGeneratedCode") ;
		
		int status = -1;
		String result = "";
		
		Node n = sod.logE(testNode, STEP_EL);
		sod.logA(n, STEP_ATT, IMPORT_GENERATED_STEP_ATT);
		
		//dir to import from == dir to output to == testLogDir
		setGeneratedCodeUMP(testLogDir);
			
		String cmd = "\"" + getUModelBatchExe() + "\" /new=\"" + getGeneratedCodeUMP().getAbsolutePath() + "\"";
		
		sod.logA(n, SingleOutputDocument.FILE_ATT, getGeneratedCodeUMP().getName() );
		try {
		
			File projDepend = new File ( getProjectDependencies(false) ) ;
			
			if(projDepend.isDirectory()) cmd += " /isd=\"" + projDepend.getAbsolutePath() + "\"" ; 
			else if(projDepend.isFile()) cmd += " /isp=\"" + projDepend.getAbsolutePath() + "\"" ; 

//			cmd += " /isp=\"" + projDepend.getAbsolutePath() + "\"" ; 

		} catch (ScriptMistakeException e) {
			e.printStackTrace();
			throw new DoNotContinueException(DoNotContinueException.BUG) ;
		}
		cmd += " /iclg=\"" + codeLanguage + "\" /ipsd=1 /dgen=1 /dopn=0 /irpf=0 /chk";

		//+ " /dgen /dopn /dsac /dsoc /dscc /dstv";			//	options for diagram generation:
		
		status = Common.executeCommand( cmd , false , DependancyApplication.UMODEL);
		result += Common.getLastOutputMessage();
		if(result.equals("")) result = Common.getLastErrorMessage();
		
		
		sod.logE(n, CMD_INPUT_EL, cmd) ;
		sod.logE(n, CMD_OUTPUT_EL, result) ;
		sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));
		
		return (status == 0) ? true : false ;
	}
	
	/**
	 * @param f
	 */
	private void setGeneratedCodeUMP(File f) {
		generatedCodeUMP = new File (f.getAbsolutePath() + "\\" +  f.getName() + "-generated-code-import.ump");
	}	 
	/**
	 * @return
	 */
	private File getGeneratedCodeUMP() throws DoNotContinueException {
		
//		if(getFlag(DEBUG_MODE)) System.out.println("getGeneratedCodeUMP") ;		
//		if(!checkFile(generatedCodeUMP.getAbsolutePath()))
//			throw new DoNotContinueException( DoNotContinueException.FILE_NOT_FOUND, generatedCodeUMP.getAbsolutePath()) ;
		return generatedCodeUMP;
	}	 
	
	/**
	 * @param stepsNode
	 * @return
	 * @throws DoNotContinueException
	 */
	public boolean umpDiffTests()  throws DoNotContinueException {
		
		if(getFlag(DEBUG_MODE)) System.out.println("umpDiffTests") ;
		
		boolean status ;
		
		Node n = sod.logE(testNode, STEP_EL) ;
//		sod.logAttribute(n, STEP_ATT, COMPARE_UMP_STEP_ATT);
//		
//		File sourceCodeUMP = new File(testLogDir.getAbsolutePath() , testDir.getName() + ".ump");
//		Node fileNode = sod.logElement(n, INPUT_EL);
//		sod.logAttribute(fileNode, FILE_ATT, sourceCodeUMP.getName());
//		
//		fileNode = sod.logElement(n, INPUT_EL);
//		sod.logAttribute(fileNode, FILE_ATT, getGeneratedCodeUMP().getName() );
//		
		File refUmpFile = new File(refDirectory.getAbsolutePath() + "\\" + testDir.getName()+ "\\" + testDir.getName() + ".ump");
		File refUmpLogFile = new File(testLogDir.getAbsolutePath() + "\\" + testDir.getName() + "-ref.ump");

		//	Check to see if a reference ump file exists. 
		//	If it does exist, then copy the reference file to the test log directory
		//	and pass the reference ump file as one of the files for comparison
		//	If no reference file exists then use the ump file created from the 
		//	initial import of the code for comparison
		if ( refUmpFile.isFile() && refUmpFile.exists() ) {	
			try {
				copyRenameProjectFileToDir(refUmpFile,refUmpLogFile);
			}catch (Exception e) {
				throw new DoNotContinueException("Error copying reference ump file", e) ;
			}
			status = compareUMP(getGeneratedCodeUMP(), ((sed) ? umpSedReplace : refUmpLogFile), n);
		}
		else {
			status = compareUMP(getGeneratedCodeUMP(), ((sed) ? umpSedReplace : umpFile), n);
		}
		return status;
	}
	
	/**
	 * @param n
	 * @param f
	 * @throws DoNotContinueException
	 */
	private boolean compareFiles(File f)  throws DoNotContinueException {
		return compareFiles(f, "") ;
	}
	/**
	 * @param stepsNode
	 * @param file
	 * @param subdir
	 * @throws DoNotContinueException
	 */
	private boolean compareFiles(File file, String subdir)  throws DoNotContinueException {
		
		if(getFlag(DEBUG_MODE)) System.out.println("compareFiles") ;
		
		int status = 0;
		String strCmd = "";
		String result = "";
		if ( file.isFile() && file.exists() ) {			
			//			strCmd = Common.diffdogBatchEXELocation + " /cF \"" + file.getAbsolutePath() + "\" \"" + refDirectory + "\\" + tdName ;
			//			if(!(subdir.equals(""))) strCmd += subdir ;
			//			strCmd += "\\" + file.getName() + "\" /q /mT /dD /dL";
			
			Node n = sod.logE(testNode, STEP_EL);
			
			sod.logA(n, STEP_ATT, COMPARE_CODE_STEP_ATT );
			sod.logA(n, FILE_ATT, file.getName() );

			//TODO change diff to diffdog
			strCmd = "diff.exe -i -w -b -B \"" + file.getAbsolutePath() + "\" \"" + referenceDirectory + "\\" + testDir.getName() ;
			if(!(subdir.equals(""))) strCmd += subdir ;
			strCmd += "\\" + file.getName() + "\"";
			
			status = Common.executeCommand( strCmd , true , DependancyApplication.DIFFDOG);
			result += Common.getLastOutputMessage();
			if(result.equals("")) {
				result = Common.getLastErrorMessage();
				if ( !result.equals("") ) status = -1;
			}
			sod.logE(n, FILE_COMPARE_EL, result);
			
			if(status == 0) {
				sod.logA(n, STATUS_ATT, "pass");
			}
			else {
				sod.logA(n, STATUS_ATT, "fail");
			}
		}
		//recursion to compare files in sub directories
		else if (file.isDirectory() && file.exists()) {
			for(File subFile : file.listFiles() ) {
				String sd = subFile.getAbsolutePath();
				sd = sd.substring(0, sd.lastIndexOf("\\"));
				sd = sd.substring(sd.lastIndexOf("\\"), sd.length());
				if(!subdir.equals(sd)) subdir += sd; 
				compareFiles(subFile, subdir);
			}
		}
		else {			
			Node stepNode = sod.logE(testNode, STEP_EL);			
			result = "file not found: " + file.getAbsolutePath();
			sod.logA(stepNode, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));
		}
		return (status == 0) ? true : false ;
	}
//	/**
//	 * @param f1
//	 * @param f2
//	 * @param stepNode
//	 * @return
//	 * @throws DoNotContinueException
//	 */
//	private boolean compareUMP(File f1, File f2, Node n)  throws DoNotContinueException {	//compare-ump step
//		String result = "";
//		int status = -1;
//		
//		String[] strCmd = new String[3];
//		UmpDiffTest udt = new UmpDiffTest();
//		
//		udt.setTestLogDir(testLogDir);
//		result = udt.setupUmpDiffTest(f1, f2);
//		if(result.equals("")) { 
//			try {
//				strCmd = udt.parseDocuments();
//			} catch (ClassCastException e) {
//				result += e.getStackTrace();
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				result += e.getStackTrace();
//			} catch (IllegalAccessException e) {
//				result += e.getStackTrace();
//			}			
//			if(strCmd[0].equals("error")) result += strCmd[1];
//			else status = Common.executeCommand( strCmd[1] , false );			
//			result += Common.getLastOutputMessage();
//			if(result.equals("")) result = Common.getLastErrorMessage();			
//			
//			sod.logElement(n, DIFFDOG_COMMAND_ATT, strCmd[2]);
//			
//		}
//		sod.logElement(n, FILE_COMPARE_EL, result);
//		sod.logAttribute(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));
//		
//		return ((status == 0) ? true : false );
//	}
}