package com.altova.umodel.regression.functional;

import static com.altova.umodel.regression.functional.SingleOutputDocument.*;
import static com.altova.umodel.regression.functional.UModelTestTypes.*;
import static com.altova.Depend.*;
import static com.altova.util.Settings.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.w3c.dom.Node;

import com.altova.Depend.DependancyApplication;
import com.altova.robots.ScriptMistakeException;

public class TestSyntaxChecker extends TestBase {

	private int synLogInstanceType;

	String stepExtension = null;
	File testReferenceFile = null;
	File testOutputFile = null;
	
	public TestSyntaxChecker(String key, int log, Node root) {

		setTestKey(key);
		setSourceDir();
		synLogInstanceType = log;
		sod = Common.getSingleOutputDocument(synLogInstanceType);
		
		projectNode = sod.logE(root, PROJECT_TYPE_EL) ;
		sod.logA(projectNode, PROJECT_TYPE_ATT, testKey) ;
	}

	public void setupTest(File f, File txtFile) {
		
		testDir = f;		
		testReferenceFile = txtFile ;
		testLogDir = getLogDir() ; 
		testLogDir.mkdirs() ;

		System.out.println("source :" + testDir.getName());
		System.out.println("log :	" + testLogDir.getAbsolutePath());
		
		testNode = sod.logE(projectNode, TEST_FILE_EL) ;
		sod.logA(testNode, NAME_ATT, testDir.getName()) ;
	}
	
	public void checkSyntax() throws DoNotContinueException {
		
		if(getFlag(DEBUG_MODE)) System.out.println("checkSyntax") ;
		
		String result = "";		
		Node n = sod.logE(testNode, STEP_EL) ;
		sod.logA(n, STEP_ATT, SYNTAX_CHECK_ATT) ;
		
		String cmd = "\"" + getUModelBatchExe() + "\" \"" + testDir.getAbsolutePath() + "\" /chk" ; 

		//status returns 1 for errors, 0 for warnings or nothing.
		Common.executeCommand( cmd , false , DependancyApplication.UMODEL);
		result += Common.getLastOutputMessage();		
		if(result.equals("")) result = Common.getLastErrorMessage();	
		saveResultToFile(result) ;
		
		sod.logE(n, CMD_INPUT_EL, cmd) ;
		sod.logE(n, CMD_OUTPUT_EL, result) ;
		sod.logA(n, STATUS_ATT, ((result.equals("")) ? STATUS_PASS : STATUS_FAIL ));
	}
	
	public void compareSyntaxOutput() throws DoNotContinueException {
		
		if(getFlag(DEBUG_MODE)) System.out.println("compareSyntaxOutput") ;
		
		int status = -1 ;
		String result = "";
		
		Node n = sod.logE(testNode, STEP_EL) ;
		sod.logA(n, STEP_ATT, SYNTAX_OUTPUT_COMPARE) ;
		File temp_crlf_out = new File(TEMP_DIR , "temp_crlf_out.txt" ) ;
		
		temp_crlf_out.getParentFile().mkdirs() ;
		
		String removeCrLf = SED_REMOVE_CRLF.getAbsolutePath() + " " + testReferenceFile.getAbsolutePath().replaceAll("\\\\", "/") + " " + temp_crlf_out.getAbsolutePath().replaceAll("\\\\", "/") ;
		status = Common.executeCommand( removeCrLf, false, DependancyApplication.SED_REMOVE_CRLF) ;
		
//		String f1 = "\"" + testOutputFile.getAbsolutePath() + "\"" ;
		String f1 = "\"" + temp_crlf_out.getAbsolutePath() + "\"" ;
		
		String f2 = "\"" + testOutputFile.getAbsolutePath() + "\"" ;			

		String cmd = "\"" + getDiffDogBatchExe() + "\" /cF " + f1 + " " + f2 + " /dL /mT /wS" ;

		status = Common.executeCommand( cmd , false , DependancyApplication.DIFFDOG);
		result += Common.getLastOutputMessage();
		try {
			//			output to file if different
			if(result.endsWith("different")) { // files are different, lets put the diff to file
				// set the output log file location from diffdog
				File failedFile = moveToOutputFolder(temp_crlf_out) ;
				// set file name for diffdog result
				String umpdiff = testOutputFile.getParent() + "\\" + failedFile.getName() + ".xml";
				
				f1 = "\"" + failedFile.getAbsolutePath() + "\"" ;
				cmd = "\"" + getDiffDogBatchExe() + "\" /cF " + f1 + " " + f2 + " /dL /mT /wS /rX "+ umpdiff  ;

				status = Common.executeCommand( cmd , false , DependancyApplication.DIFFDOG); 
				
				//DiffDog does not set the status to other than 0!
				status = -1; //failure in ump diff
				//set the file name showing the output of DiffDog ump diff
				sod.logE(n, FILE_COMPARE_EL, "file://" + umpdiff);		
			
			}
			else if(result.endsWith("equal")){
				if(getFlag(DEBUG_MODE) == true)
					System.out.println("equal") ;				
			}
		} catch(Exception e) {
			throw new ScriptMistakeException(cmd) ;
		}
		cleanup(temp_crlf_out) ;		
		
		sod.logE(n, DIFFDOG_COMMAND_ATT, cmd) ;
		
		sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));		
	}
	
	public void cleanup(File f) {
		if(testKey.equals(SYNTAX_TEST)) {
			if (f.exists()) {
				if (f.getAbsolutePath().contains(TEMP_DIR.getAbsolutePath())) {
					File parent = f.getParentFile() ;
					f.delete() ;
					parent.delete();
				}					
			}
		}		
	}
	
	private File moveToOutputFolder(File temp_crlf_out) throws FileNotFoundException, IOException {
		File out = new File (testLogDir, "fail_" + testOutputFile.getName()); 
		FileInputStream fis  = new FileInputStream(temp_crlf_out);
		FileOutputStream fos = new FileOutputStream(out);
		byte[] buf = new byte[1024];
		int i = 0;
		while((i=fis.read(buf))!=-1) {
			fos.write(buf, 0, i);
		}
		fis.close();
		fos.close();		
		return out ;
	}
	
	private void saveResultToFile(String result) throws ScriptMistakeException {
		
		try {
			testOutputFile = new File(testLogDir, testReferenceFile.getParentFile().getName() );
			testOutputFile = new File(testOutputFile , testReferenceFile.getName());
			testOutputFile.getParentFile().mkdirs() ;
			testOutputFile.createNewFile() ;
			
			FileWriter fw = new FileWriter(testOutputFile);
			fw.write(result) ;
			fw.close() ;
		}catch (IOException e) {
			throw new ScriptMistakeException("cannot write result to file:" + testOutputFile) ;
		}
	}
		
}