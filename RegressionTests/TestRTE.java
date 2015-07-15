package com.altova.umodel.regression.functional;

import static com.altova.umodel.regression.functional.SingleOutputDocument.*;
import static com.altova.util.Settings.*;
import static com.altova.Depend.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;

import com.altova.Depend.DependancyApplication;

public class TestRTE extends TestBase {	
	public static final int DIR = 0;
	public static final int ECLIPSE = 1;
	public static final int JBUILDER = 2;

	File testDir = null;
	String tdName = null;
	File testLogDir = null;
	static final String NO_ERRORS_STRING = "0 error";
	static final String NO_WARNING_STRING = "0 warning";
	private static File rootDirectory = null;
	private static File srcDirectory = null;
	private static File refDirectory = null;
	private static File tempDir = new File("C:\\UModelRegressionTests\\temp"); 
	private static File testRefDir = null; 
	private String codeLanguage;
	private SingleOutputDocument sod;
	
	public TestRTE( File rootDir , String codelang) {		
		setRootDir(rootDir);
		srcDirectory = new File(rootDirectory.getAbsoluteFile() + "//src" ) ;
		refDirectory = new File(rootDirectory.getAbsoluteFile() + "//ref" ) ;
		codeLanguage = codelang;
		sod = Common.getSingleOutputDocument(SingleOutputDocument.RTE_LOG);
	}

	private static void setRootDir(File rootDir) { rootDirectory = rootDir; }
	
	public File getRootDir() { return rootDirectory; }
	public File getSrcDir() { return srcDirectory; }
	public File getRefDir() { return refDirectory; }

	public void setCurrentRefCodeDir(File fRefCodeDir) throws NullPointerException {

		if( fRefCodeDir == null )throw new NullPointerException();
		
		testRefDir = fRefCodeDir;
	} 
	
	public String setupTest(File tDir, File currentlogDir) {
		testDir = tDir;
		tdName = tDir.getName();
//		tdName = tdName.substring(0, tdName.lastIndexOf("."));	//remove the extension and save as String		
		testLogDir = new File( currentlogDir  + "//" + tdName);
		try {
			testLogDir.mkdirs();
//			copyFileToTestDir(); this is not a good idea for file comparison...
		} catch (Exception e) {
			e.printStackTrace();
		}
		String path = testDir.getAbsolutePath();
		path = path.substring( 0, path.lastIndexOf( "\\" ) );
		path = path.substring( path.lastIndexOf( "\\" ), path.length() );
		path = path + "\\" + testDir.getName();
		
		tempDir.mkdirs();
		
		return path;
	}
	
	private void copyFileToTempDir(File file) throws Exception {
		if(!file.isDirectory()) {
			File out = new File (tempDir + "\\"+ file.getName()); 
			FileInputStream fis  = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(out);
			byte[] buf = new byte[1024];
			int i = 0;
			while((i=fis.read(buf))!=-1) {
				fos.write(buf, 0, i);
			}
			fis.close();
			fos.close();
		}
		else {
			List l = Arrays.asList(file.listFiles());
			Iterator i = l.iterator();
			while (i.hasNext()) {
				
				Object o = i.next();
				if( o != null && ((File)o).exists() && (!((File)o).getName().equals("CVS")) ) {
					copyFileToTempDir((File)o);
				}
			}
		}
	}
	
	private void deleteTempDir() {
		List l = Arrays.asList(tempDir.listFiles());
		Iterator i = l.iterator();
		while (i.hasNext()) {			
			Object o = i.next();
			if( o != null && ((File)o).exists() ) {
				((File)o).delete();
			}
		}
	}
	
	// create a new UMP file from source code
	//	<step status="pass/fail" name="import">
	//		<input-file file="filename"> 
	//		<output-file file=importfilelocation />
	//		<error/>
	//	</step>
	public int importOriginalCode()
	{
		int status = -1;
		String cmd = "";
		String result = "";
		
		Node n = sod.logE(testNode, STEP_EL);
		sod.logA(n , STEP_ATT, IMPORT_STEP_ATT);
		
		String outputRTEDirName = testLogDir.getAbsolutePath() ;	
		
		File dirToImport = new File ( srcDirectory.getAbsolutePath() );
		if ( dirToImport.isDirectory() && dirToImport.exists() ) {
			try {
				copyFileToTempDir(dirToImport);
				cmd = "\"" + getUModelBatchExe() + "\" /new=\""	+ outputRTEDirName + "\\" 
				+ testDir.getName() + ".ump\" /isd=\"" + tempDir.getAbsolutePath()
				+ "\" /iclg=\"" + codeLanguage
				+ "\" /ipsd=1 /dgen=1 /dopn=1 /chk";
		
				status = Common.executeCommand( cmd , false , DependancyApplication.UMODEL);
				result += Common.getLastOutputMessage();
				if(result.equals("")) result = Common.getLastErrorMessage();
				deleteTempDir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else result = "file not found: " + dirToImport.getAbsolutePath();		
		
		sod.logE(n, CMD_INPUT_EL, cmd);
		sod.logE(n, CMD_OUTPUT_EL, result);
		sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));
		
		return status;
	}
     
	public int umpDiffTest() throws DoNotContinueException {
		int status = -1;
		String[] strCmd = new String[3];
		String result = "";
		Node n = sod.logE(testNode, STEP_EL);
		sod.logA(n , STEP_ATT, COMPARE_UMP_STEP_ATT);

		String outputRTEDirName = testLogDir.getAbsolutePath() ;
		//first file is ump output from importoriginalcode
		File f1 = new File (outputRTEDirName + "\\"+ tdName + ".ump");
		
		Node fileNode = sod.logE(n , INPUT_EL);
		sod.logA(fileNode, FILE_ATT, tdName + ".ump");

		//second file is the ump from the importmodifiedcode
		File f2 = new File ( outputRTEDirName + "\\" + testDir.getName() + testRefDir.getName() + ".ump" ) ;
		fileNode = sod.logE(n, INPUT_EL);
		sod.logA(fileNode, FILE_ATT, testDir.getName() + testRefDir.getName() + ".ump");
		
		UmpDiffTest udt = new UmpDiffTest();
		udt.setTestLogDir(testLogDir);
		result = udt.setupUmpDiffTest(f1, f2);
		if(result.equals("")) { 
			try {
				strCmd = udt.parseDocuments();
			} catch (ClassCastException e) {
				result += e.getStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				result += e.getStackTrace();
			} catch (IllegalAccessException e) {
				result += e.getStackTrace();
			}
			
			if(strCmd[0].equals("error")) result += strCmd[1];
			else { status = Common.executeCommand( strCmd[1] , false , DependancyApplication.DIFFDOG);}			
			
			result += Common.getLastOutputMessage();
			if(result.equals("")) result = Common.getLastErrorMessage();
			
			sod.logA(n, DIFFDOG_COMMAND_ATT, strCmd[2]);
			
		}
		
		sod.logE(n, FILE_COMPARE_EL, result);
		sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));

		return status;
	}
	     
	public int importModifiedCode()
	{
		int status = -1;
		String strCmd = "";
		String result = "";
		Node n = sod.logE(testNode, STEP_EL);
		sod.logA(n, STEP_ATT, IMPORT_MODIFIED_STEP_ATT);

		Node fileNode = sod.logE(n, INPUT_EL);
		sod.logA(fileNode, FILE_ATT, testDir.getName() + testRefDir.getName() + ".ump");

		String outputRTEDirName = testLogDir.getAbsolutePath() ;	
		
		if ( testRefDir.isDirectory() && testRefDir.exists() ) {
			try {
				copyFileToTempDir(testRefDir);
				strCmd = "\"" + getUModelBatchExe()+ "\" /new=\"" + outputRTEDirName + "\\" + 
				testDir.getName() + testRefDir.getName() + ".ump\" /isd=\"" + tempDir.getAbsolutePath()
				+ "\" /iclg=\"" + codeLanguage
				+ "\" /ipsd=1 /dgen=1 /dopn=1 /chk";
				status = Common.executeCommand( strCmd , false , DependancyApplication.UMODEL);
				result += Common.getLastOutputMessage();
				if(result.equals("")) result = Common.getLastErrorMessage();
				deleteTempDir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else result = "file not found: " + testRefDir.getAbsolutePath();

		sod.logE(n, SingleOutputDocument.CMD_OUTPUT_EL, result);		
		sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));		
		
		return status;
	}
}
