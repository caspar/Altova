package com.altova.umodel.regression.functional;

import static com.altova.umodel.regression.functional.UModelTestTypes.*;
import static com.altova.umodel.regression.functional.SingleOutputDocument.*;
import static com.altova.util.Settings.*;
import static com.altova.Depend.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.w3c.dom.Node;

import com.altova.Depend.DependancyApplication;
import com.altova.robots.ScriptMistakeException;

public class TestXSDImport extends TestBase {
	
	File testFile = null ;
	File ump = null ;
	File umpReImported = null ;	
	File testReferenceFile = null;
	File testOutputFile = null;
	
	File tempDir = TEMP_DIR ;
	
	public TestXSDImport (String key, int log, Node root) {
		setTestKey(key);
		setSourceDir();
		setRefDir();

		sod = Common.getSingleOutputDocument(log);
		projectNode = sod.logE(root, PROJECT_TYPE_EL) ;
		sod.logA(projectNode, PROJECT_TYPE_ATT, testKey) ;		
	}

	public void setupTest(File f) throws DoNotContinueException {
		if(getFlag(DEBUG_MODE) == true) System.out.println("setupTest") ;
		testFile = f ;
		if (testKey.equals(XSD_TEST))
			testDir = f.getParentFile();
		else 
			testDir = f;
		testLogDir = getLogDir(testDir) ; 
		if(!getFlag(COPY_TO_REF)) testLogDir .mkdirs() ;
		set_ui_settings();		
		try {
//			copy all the files from the test case directory to the log directory
			copyDependsToSource() ;
		}
		catch 
			(Exception e) {
			e.printStackTrace() ;
			throw new DoNotContinueException("Exception" , e);			
		}	
		if (testKey.equals(XSD_TEST)|| testKey.equals(XSD_DIR_TEST)) 
//			for XSD_TEST and XSD_DIR_TEST we copy all the test-case-files to the log directory			
//			hence, testFile must point to the file in the log directory
			testFile = new File (testLogDir + "\\" + testFile.getName());

		System.out.println("source :" + testDir.getName());
		System.out.println("log :	" + testLogDir.getAbsolutePath());
		testNode = sod.logE(projectNode, TEST_FILE_EL);
		sod.logA(testNode, NAME_ATT, testDir.getName());		
	}
	
	private File copyToTempDir(File in) throws IOException {
		
		File out = new File ( tempDir, in.getParentFile().getName() + "\\" + in.getName() );
		out.getParentFile().mkdirs() ;
		out.createNewFile() ;
		
		FileInputStream fis  = new FileInputStream(in);
		FileOutputStream fos = new FileOutputStream(out);
		byte[] buf = new byte[1024];
		int i = 0;
		while((i=fis.read(buf))!=-1) {
			fos.write(buf, 0, i);
		}
		fis.close();
		fos.close();
		
		return verifyFile(out);
	}

	public void cleanup() {
		if(testKey.equals(XSD_TEST_INVALID)) {
			if (testFile.exists()) {
				if (testFile.getAbsolutePath().contains(tempDir.getAbsolutePath())) {
					File parent = testFile.getParentFile() ;
					testFile.delete() ;
					parent.delete();
				}					
			}
		}		
	}
	
	private File getTxtFile(File tstFile) throws IOException {
		
		return verifyFile(new File (tstFile.getParent() , tstFile.getName().replaceFirst(".xsd", ".txt"))) ;		
	}
	
	public void setupNegativeTest(File f, File tstFile) throws IOException {
		
		if(getFlag(DEBUG_MODE) == true) System.out.println("setupNegativeTest") ;
		
		testDir = f;
		testReferenceFile = getTxtFile(tstFile);
		testFile = copyToTempDir(tstFile) ;
		testLogDir = getLogDir(f) ; 
		testLogDir.mkdirs() ;

		System.out.println("source :" + testDir.getName());
		System.out.println("log :	" + testLogDir.getAbsolutePath());
		
		testNode = sod.logE(projectNode, TEST_FILE_EL) ;
		sod.logA(testNode, NAME_ATT, testDir.getName()) ;
	}
	
	public void importXSD() throws DoNotContinueException  {
		
		if(getFlag(DEBUG_MODE) == true) System.out.println("importXSD") ;
		
		//		the xsd should first be copied to a temp folder,
		//		it will be overwritten on m2c
		int status = -1;
		String cmd = "";
		String result = "";

		Node n = sod.logE(testNode, STEP_EL);
		sod.logA(n, STEP_ATT, IMPORT_XSD_STEP_ATT);		
		
		ump = new File(testLogDir, testDir.getName() + ".ump") ;
		
		sod.logA(n, SingleOutputDocument.FILE_ATT, ump.getAbsolutePath());
		
		cmd = "\"" + getUModelBatchExe() + "\" /new=\""	+ ump.getAbsolutePath() + "\"";
		if (testKey.equals(XSD_DIR_TEST))
			// import schemas from a directory and turn off both diagram generation and import relative to project file
			cmd += " /ixd=\"" + testLogDir + "\"" + " /dgen=0 /irpf=0";
		else if(testKey.equals(XSD_TEST_INVALID))
			// import schema and turn off both diagram generation and import relative to project file
			cmd += " /ixs=\"" + testFile + "\"" + " /dgen=0 /irpf=0";
		else
			// import a schema and turn off diagram generation 
			cmd += " /ixs=\"" + testFile + "\"" + " /dgen=0";
		status = Common.executeCommand( cmd, false , DependancyApplication.UMODEL);
		result += Common.getLastOutputMessage();
		if(result.equals("")) result = Common.getLastErrorMessage();
		
		if(testKey.equals(XSD_TEST_INVALID)) saveResultToFile(result) ;
				
		sod.logE(n, CMD_INPUT_EL, cmd);
		sod.logE(n, CMD_OUTPUT_EL, result);
		sod.logA(n , STATUS_ATT , ((status == 0) ? STATUS_PASS : STATUS_FAIL ) ) ;
		
		if((!testKey.equals(XSD_TEST_INVALID)) & (status != 0)) throw new DoNotContinueException(DoNotContinueException.BUG, result) ;
	}	

	public void exportXSD() throws DoNotContinueException {
		
		if(getFlag(DEBUG_MODE) == true) System.out.println("exportXSD") ;
		
		int status = -1;
		String cmd = "";
		String result = "";
		
		Node n = sod.logE(testNode, STEP_EL);
		sod.logA(n, STEP_ATT, EXPORT_UMP_TO_XSD_STEP_ATT);		
		
		Common.resetOutputMessage();
		
//		to replace DOSSR: use sed command >bat %1input %2text %3replace %4output 
//		String textReplace = 		 
//			testDir.getAbsolutePath() + " " +								/*arg2 - text to find*/
//			outputCGDirName ; 												/*arg3 - text replace*/					
//						
//		textReplace = SED_TEXT_REPLACE.getAbsolutePath() + " " + 			/*arg1 - input file*/
//			umpFile.getAbsolutePath() + " " +   
//			textReplace.replaceAll("\\\\", "\\\\\\\\\\\\\\\\") + " " +		/*!*/
//			umpFileCopy.getAbsolutePath() ; 								/*arg4 - output file */
//		
		
		
		
		cmd = "\"" + getUModelBatchExe() + "\" \"" + ump.getAbsolutePath() + "\" /m2c /ejdc=1 /egfn=1 /eusc=1";
		
		status = Common.executeCommand( cmd , false , DependancyApplication.UMODEL);
		
		result += Common.getLastOutputMessage();
		
		if(result.equals("")) result = Common.getLastErrorMessage();

		result += Common.getLastOutputMessage();
		
		sod.logE(n, CMD_INPUT_EL, cmd);
		sod.logE(n, CMD_OUTPUT_EL, result);
		sod.logA(n , STATUS_ATT , ((status == 0) ? STATUS_PASS : STATUS_FAIL ) ) ;		
	}

	public void importExportedXSD() throws DoNotContinueException {
		
		if(getFlag(DEBUG_MODE) == true) System.out.println("importExportedXSD") ;
		
		int status = -1;
		String cmd = "";
		String result = "";

		Node n = sod.logE(testNode, STEP_EL);
		sod.logA(n, STEP_ATT, IMPORT_XSD_GENERATED_STEP_ATT);		
		
		umpReImported = new File(testLogDir, testDir.getName() + "-re-import.ump") ;
		
		sod.logA(n, SingleOutputDocument.FILE_ATT, ump.getAbsolutePath());
		
		cmd = "\"" + getUModelBatchExe() + "\" /new=\""	+ umpReImported.getAbsolutePath() + "\"";
	
		if 	(testKey.equals(XSD_TEST)) 
			// set cmd to import a schema without diagram generation
			cmd += " /ixs=\"" + testLogDir + "\\" + testFile.getName() + "\"" + " /dgen=0";
		else 
			// set cmd to import schemas from a directory without diagram generation and relative import
			if 	(testKey.equals(XSD_DIR_TEST)) cmd += " /ixd=\"" + testLogDir + "\"" + " /dgen=0 /irpf=0";
		else
			result = "Invalid type specified: " + testKey;
	
		status = Common.executeCommand( cmd, false , DependancyApplication.UMODEL);
		result += Common.getLastOutputMessage();
		if(result.equals("")) result = Common.getLastErrorMessage();
				
		sod.logE(n, CMD_INPUT_EL, cmd);
		sod.logE(n, CMD_OUTPUT_EL, result);
		sod.logA(n , STATUS_ATT , ((status == 0) ? STATUS_PASS : STATUS_FAIL ) ) ;		
	}

	public boolean compareUMPs() throws DoNotContinueException {
		
		if(getFlag(DEBUG_MODE) == true) System.out.println("compareUMPs") ;
		
		boolean status = false;				

		File refUmpFile = new File(refDirectory.getAbsolutePath() + "\\" + testDir.getName()+ "\\" + testDir.getName() + ".ump");
		File refUmpLogFile = new File(testLogDir.getAbsolutePath() + "\\" + testDir.getName() + "-ref.ump");
		
		Node n = sod.logE(testNode, STEP_EL) ;
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
			status = compareUMP(refUmpLogFile, umpReImported, n);
		}
		else {
			status = compareUMP(ump, umpReImported, n);
		}
		
		sod.logA(n , STATUS_ATT , (status) ? STATUS_PASS : STATUS_FAIL ) ;
		
		return status ;
	}
	
	
	public void compareOutput() throws DoNotContinueException {
		
		if(getFlag(DEBUG_MODE) == true) System.out.println("compareOutput") ;
		
		int status = -1 ;
		String result = "";
		
		Node n = sod.logE(testNode, STEP_EL) ;
		sod.logA(n, STEP_ATT, SYNTAX_OUTPUT_COMPARE) ;

		String f1 = "\"" + testOutputFile.getAbsolutePath() + "\"" ;
		String f2 = "\"" + testReferenceFile.getAbsolutePath() + "\"" ;			

		String cmd = "\"" + getDiffDogBatchExe() + "\" /cF " + f1 + " " + f2 + " /dL /mT /wS" ;

		status = Common.executeCommand( cmd , false , DependancyApplication.DIFFDOG);
		result += Common.getLastOutputMessage();		

		sod.logE(n, DIFFDOG_COMMAND_ATT) ;
		sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));		
	}
	
	private void saveResultToFile(String result) throws ScriptMistakeException {
		
		try {
			testOutputFile = new File(testLogDir, testReferenceFile.getName());
			testOutputFile.createNewFile() ;
			
			FileWriter fw = new FileWriter(testOutputFile);
			
			fw.write(result) ;
			fw.close() ;
		}catch (IOException e) {
			throw new ScriptMistakeException("cannot write result to file:" + testOutputFile) ;
		}
	}

//	private StringBuffer findXSDForImport() throws DoNotContinueException, FileNotFoundException{
//		BufferedReader input = null;
//		StringBuffer contents = new StringBuffer();
//		boolean filefound = false;
//		for(File f : testDir.listFiles()) {
//			if ( f.getName().equals(INSTRUCTIONS_FILE)) {
//				try {
//					filefound = true;
//					input = new BufferedReader( new FileReader(f) );
//					String line = null;
//					while (( line = input.readLine()) != null){
//						int end = f.getAbsolutePath().lastIndexOf("\\");
//						String path = f.getAbsolutePath().substring(0, end );
//						boolean star = false;						
//						if(line.startsWith("*")) { 
//							star = true; 
//							line = line.substring(1, line.length()); 
//						}																		
//						File check = new File(path + "\\" + line);
//						if ( ! check.exists() ) continue;						
//						if (star) contents.append("*");						
//						contents.append(path);
//						contents.append("\\");
//						contents.append(line);
//						contents.append(";");						
//					}
//					return contents;
//				} 
//				catch (FileNotFoundException e) { throw new DoNotContinueException(e.getMessage()); }
//				catch (IOException e) { throw new DoNotContinueException(e.getMessage()); }
//			}
//
//		}	
//		if ( !filefound ) throw new FileNotFoundException("No file found: " + INSTRUCTIONS_FILE);
//		else return contents;
//	}
		
}
