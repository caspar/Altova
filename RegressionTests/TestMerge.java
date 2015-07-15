package com.altova.umodel.regression.functional;
import static com.altova.umodel.regression.functional.SingleOutputDocument.*;
import static com.altova.umodel.regression.functional.UModelTestTypes.*;
import static com.altova.util.Settings.*;
import static com.altova.Depend.*;

import java.io.*;

import org.w3c.dom.Node;

import com.altova.Depend.DependancyApplication;
import com.altova.engines.*;

class TestMerge extends TestBase
{
	public String type;
	static IAltovaXMLFactory objXmlApp ;

	

	static final String NO_ERRORS_STRING = "0 error";
	static final String NO_WARNING_STRING = "0 warning";
	
	String stepExtension = null;	//this changes according to step & version
	File testFile = null;
	String tfName = null;
//	File testLogDir = null;
	
	// constructor
	public TestMerge(String key) {
		setTestKey(key);
		setSourceDir();
		setRefDir();
		sod = Common.getSingleOutputDocument(SingleOutputDocument.MERGE_LOG);
		
		projectNode = sod.logE(null, SUITE_EL);
		sod.logA(projectNode, PROJECT_TYPE_ATT, testKey);  //testKey or version?
		
		if (objXmlApp == null) {		
			try { 
				objXmlApp = Common.getAltovaInstance() ;
			}
			catch (IllegalAccessException e) { e.printStackTrace();	}
		}
	}
	// constructor
	public TestMerge(String importType, File rootDir, String key) {
		type = importType;
//		setSuite(testSuite);
		setTestKey(key);
		sod = Common.getSingleOutputDocument(SingleOutputDocument.MERGE_LOG);
		if (objXmlApp == null) {
			try { 
				objXmlApp = Common.getAltovaInstance() ;
			}
			catch (IllegalAccessException e) { e.printStackTrace();	}
		}
	}
		
	public void setupTest(File tf ) {
		testFile = tf;
		tfName = testFile.getName();
		tfName = tfName.substring(0, tfName.lastIndexOf("."));	//remove the extension and save as String		
		testDir = tf.getParentFile();
		testLogDir = getLogDir(testDir) ; 
		
		try {
			if(!getFlag(COPY_TO_REF)) testLogDir .mkdirs() ;
//			copyFileToTestDir();
		} catch (Exception e) {
			e.printStackTrace();
		}

		set_ui_settings();		
		
		System.out.println("source :" + testDir.getName());
		System.out.println("log :	" + testLogDir.getAbsolutePath());

		testNode = sod.logE(projectNode, TEST_FILE_EL);
		sod.logA(testNode, NAME_ATT, testDir.getName());		
	}

	private void copyFileToTestDir() throws Exception {
		File in = testFile;
		File out = new File (testLogDir + "\\"+ testFile.getName()); 
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
	public void updateXmiUmp() throws DoNotContinueException	{
		
		if(getFlag(DEBUG_MODE) == true) System.out.println("updateXmiUmp") ;
		
		int status = -1;
		String result = null;
		
		Node n = sod.logE(testNode, STEP_EL);
		sod.logA(n, SingleOutputDocument.STEP_ATT, XMI_STEP_ATT);
		

		String cmd= "\"" + getUModelBatchExe() + "\" \"" + testFile.getAbsolutePath() + "\" /new";
		
		status = Common.executeCommand( cmd , false , DependancyApplication.UMODEL );
		result += Common.getLastOutputMessage();
		if(result.equals("")) result = Common.getLastErrorMessage();

		sod.logE(n, CMD_INPUT_EL, cmd);
		sod.logE(n, CMD_OUTPUT_EL, result);
		sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));
	}
	
	public void mergeProjects(File s) throws DoNotContinueException	{
		
		if(getFlag(DEBUG_MODE) == true) System.out.println("mergeProjects") ;
		
		int status = -1;
		String result = null;
		
		Node n = sod.logE(testNode, STEP_EL);
		sod.logA(n, SingleOutputDocument.STEP_ATT, MERGE_STEP_ATT);
		
//		String outputFileName = testLogDir + "\\" + testFile.getName();
		String outputFileName = testLogDir + "\\" + testDir.getName() + ".ump";
		sod.logE(n, OUTPUT_EL, outputFileName);

		String cmd= "\"" + getUModelBatchExe() + "\" \"" + testFile.getAbsolutePath() + "\" /new=\"" + outputFileName + "\"" + " /mrg=\"" + s.getAbsolutePath() + "\"";
					
		status = Common.executeCommand( cmd , false , DependancyApplication.UMODEL );
		result += Common.getLastOutputMessage();
		if(result.equals("")) result = Common.getLastErrorMessage();

		sod.logE(n, CMD_INPUT_EL, cmd);
		sod.logE(n, CMD_OUTPUT_EL, result);
		sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));
	}
	
	public boolean umpDiff() throws DoNotContinueException {
		
		if(getFlag(DEBUG_MODE)) System.out.println("umpDiff") ;
		
		boolean status;
		
		status = false;
		Node n = sod.logE(testNode, STEP_EL) ;
		File logFile = new File(testLogDir + "\\" + testDir.getName()+ ".ump");
//		File refUmpFile = new File(refDirectory.getAbsolutePath() + "\\" + testDir.getName()+ "\\" + tfName + ".ump");
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
			status = compareUMP(logFile, refUmpLogFile, n);
		}
		return status;
	}

	public void xmlDiff() throws DoNotContinueException {
		
		if(getFlag(DEBUG_MODE) == true) System.out.println("xmlDiff") ;
		
		int status = -1;
		String result = "";
		Node n = sod.logE(testNode, STEP_EL);
		sod.logA(n, STEP_ATT, DIF_STEP_ATT);
		
		stepExtension = ".ump.sort.xml";
		File diffFile1 = new File(testLogDir.getAbsolutePath() + "\\" + tfName + stepExtension);
			
		sod.logE(n, INPUT_EL, diffFile1.getName());

		stepExtension = ".ump." + getTestKey() + ".xmi.ump.sort.xml";
		File diffFile2 = new File(testLogDir + "\\" + tfName + stepExtension);

		sod.logE(n, INPUT_EL, diffFile2.getName());

		if(diffFile1.exists() && diffFile2.exists()) {
			String strCmd = getDiffDogBatchExe() + " /cF \"" + diffFile1 + "\" \"" +  diffFile2 + "\" /q /mT /dD /dL";	
//			String strCmd = "diff.exe -i -w \"" + diffFile1 + "\" \"" +  diffFile2 + "\"";
			status = Common.executeCommand( strCmd , true , DependancyApplication.DIFFDOG);
			result += Common.getLastOutputMessage();
			if(result.equals("")) result = Common.getLastErrorMessage();
		}
		else
			result = "Missing one or more diff files";
		sod.logE(n, ERROR_EL, result);
		sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));
	}	

}	
