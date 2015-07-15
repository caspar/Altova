package com.altova.umodel.regression.functional;

import static com.altova.umodel.regression.functional.SingleOutputDocument.*;

import static com.altova.util.Settings.*;
import static com.altova.Depend.*;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;

import com.altova.Depend.DependancyApplication;
import com.altova.umodel.regression.gui.*;
/**
 * UModel Regression Tests Robot Handler & Round Trip Engineering 
 * 
 * @author Phelim McConigly
 *
 */

public class TestGUIModelEdit extends TestBase {

	public static final int DIR = 0;
	public static final int ECLIPSE = 1;
	public static final int JBUILDER = 2;
	
	private final String INSTRUCTIONS = "instructions.txt";		
	private static File dir_temp = new File("C:\\UModelRegressionTests\\temp");		//C:\UModelRegressionTests\temp
	
	private File dir_root;									//C:\UModelRegressionTests\test-cases\rte\public-method
	private File dir_ref;									//C:\UModelRegressionTests\test-cases\rte\public-method\ref
	private File dir_src;									//C:\UModelRegressionTests\test-cases\rte\public-method\src
	private File dir_ref_test_case;							//C:\UModelRegressionTests\test-cases\rte\public-method\ref\change-method
	private File dir_log_src;								//C:\UModelRegressionTests\logs\15_12_06\rte\public-method
	private File dir_log_test_case;							//C:\UModelRegressionTests\logs\15_12_06\rte\public-method\change-method
	private String str_test_case;							//change-method			  
	private String str_ump;									//public-method (.ump)	(dir_log_src)
	private String str_updated_ump;							//public-method.ump		(dir_log_test_case)
	private String str_final_ump;							//public-method_change-method.ump (dir_log_test_case)
	private File file_instructions;
	private Node srcFileNode;
	
	public File getRootDir() { return dir_root; }
	public File getSrcDir() { return dir_src; }
	public File getRefDir() { return dir_ref; }
	public Node getStepsNode() { return srcFileNode; }
	
	private String codeLanguage;
	private SingleOutputDocument sod;
	
	public TestGUIModelEdit( File root , String codelang, Node rootNode) throws IllegalStateException, IOException {
		
		sod = Common.getSingleOutputDocument(ROBOT_MODEL_EDIT_LOG);
		
		if(root == null) throw new IllegalStateException();
		dir_root = root;
		if(!dir_root.exists()) throw new IllegalStateException("can not find: " + dir_root.getAbsolutePath());
		
		dir_src = new File(dir_root.getAbsolutePath() , "src" ) ;
		if(!dir_src.exists()) throw new IllegalStateException("can not find: " + dir_src.getAbsolutePath());
		
		dir_ref = new File(dir_root.getAbsolutePath() , "ref" ) ;
		if(!dir_ref.exists()) throw new IllegalStateException("can not find: " + dir_ref.getAbsolutePath());
		
		// replaced LOGS_RME_FILE with LOGS_RME_DIR 
		// dir_log_src = new File(LOGS_RME_FILE, root.getName());
		dir_log_src = new File(LOGS_RME_DIR, root.getName());
		dir_log_src.mkdir();
		
		sod = SingleOutputDocument.getInstance(SingleOutputDocument.ROBOT_MODEL_EDIT_LOG);
		projectNode = sod.logE(rootNode, SingleOutputDocument.TEST_EL);
		sod.logA(projectNode, SingleOutputDocument.PATH_ATT, strRTERootDir);
		
		codeLanguage = codelang;
		str_ump = dir_log_src.getAbsolutePath() + "\\" + dir_root.getName() + ".ump";
		srcFileNode = sod.logE(testNode, INPUT_EL);
		sod.logA(srcFileNode, SOURCE_FILE_ATT, dir_src.getAbsolutePath());
		
		//copies code file to dir_temp before import
		deleteTempDir();
		copyFileToTempDir(dir_src);	
		
	}
	
	//need the following method to set variables for individual test cases...
	public void setupTest(File testCase) throws FileNotFoundException, IllegalStateException {
		
		if(testCase == null) throw new IllegalStateException("no test supplied: " + testCase.getAbsolutePath());
		str_test_case = testCase.getName();
		dir_ref_test_case = testCase;
		if(!dir_ref_test_case.exists()) throw new IllegalStateException("can not find: " + dir_ref_test_case.getAbsolutePath());
		dir_log_test_case = new File ( dir_log_src.getAbsolutePath() + "\\" + testCase.getName());
		
		if(!(dir_log_test_case.exists() || dir_log_test_case.isDirectory())) dir_log_test_case.mkdirs();

		str_final_ump = dir_log_test_case.getAbsolutePath() + "\\" + dir_root.getName() + "_" + str_test_case + ".ump";
		file_instructions = new File(dir_ref_test_case.getAbsolutePath() + "\\" + INSTRUCTIONS);
		
		testNode = sod.logE(projectNode, SingleOutputDocument.TEST_EL);
		sod.logA(testNode, SingleOutputDocument.PATH_ATT, strRTERootDir);
		

		testNode = sod.logE(projectNode, TEST_FILE_EL) ;
		// parameter testDir in following line is a null pointer ! replaced it with dir_root
		// sod.logA(testNode, NAME_ATT, testDir.getName()) ;
		sod.logA(testNode, NAME_ATT, dir_root.getName()) ;		

	}
	

	public int importSourceCode() throws DoNotContinueException {
		return importSourceCode(str_ump, true);
	}
	public int importUpdatedSourceCode() throws DoNotContinueException {
		return importSourceCode(str_final_ump, false);
	}
	public int importSourceCode(String ump, boolean gui) throws DoNotContinueException
	{
		int status = -1;
		String strCmd = "", result = "";
		Node n = sod.logE(getStepsNode(), STEP_EL);
		sod.logA(n, STEP_ATT, IMPORT_STEP_ATT);

		strCmd = "\"" + getUModelBatchExe() + "\"" + ((gui)?" /gui":"") + " /new=\"" + ump 
			+ "\" /isd=\"" + dir_temp.getAbsolutePath()		//imports from dir_temp
			+ "\" /iclg=\"" + codeLanguage + "\" /ipsd=1 /chk"
			+ " /dgen /dopn /dsac /dsoc /dscc /dstv";			//	options for diagram generation: 
		
		status = Common.executeCommand( strCmd , false , DependancyApplication.UMODEL);
		result += Common.getLastOutputMessage();
		if(result.equals("")) result = Common.getLastErrorMessage();

		sod.logE(n, CMD_OUTPUT_EL, result);		
		sod.logA(n, STATUS_ATT, ((status == 0) ?  STATUS_PASS : STATUS_FAIL ) );
		
		return status;
	}
	
	public int useGUIHandler() throws IllegalStateException {
		int status = -1;
		String result = "";		
		Node n = sod.logE(getStepsNode(), STEP_EL);
		sod.logA(n , STEP_ATT, ROBOT_GUI_HANDLER_STEP_ATT);

		UModelGUIHandler ugh = new UModelGUIHandler();
		ugh.setOutputPath(dir_log_test_case);
		File file_ump = new File(str_ump);
		if(!(file_ump.exists() && file_ump.isFile())) throw new IllegalStateException();
		
		result = ugh.changeModelAndCode(file_ump, file_instructions);
		if(result == null) { 
			str_updated_ump = dir_log_test_case + "//" + str_ump + ".ump";
			status = 0;
		} 
		System.out.println(result);

		sod.logE(n, CMD_OUTPUT_EL, result);		
		sod.logA(n, STATUS_ATT, ((status == 0) ?  STATUS_PASS : STATUS_FAIL ) );
		
		return status;
	}
	
	public int updateSourceCode() throws DoNotContinueException {
		int status = -1;
		String strCmd = "", result = "";
		Node n = sod.logE(getStepsNode(), STEP_EL);
		sod.logA(n, STEP_ATT, UPDATE_STEP_ATT);

		strCmd = "\"" + getUModelBatchExe() + "\" \"" + str_final_ump + "\" /m2c /ejdc=1 /egfn=1 /eusc=1";
		status = Common.executeCommand( strCmd , false , DependancyApplication.UMODEL);
		result += Common.getLastOutputMessage();
		if(result.equals("")) result = Common.getLastErrorMessage();

		sod.logE(n, CMD_OUTPUT_EL, result);
		sod.logA(n, STATUS_ATT, ((status == 0) ?  STATUS_PASS : STATUS_FAIL ) );
		
		return status;		
	}
	
	public int importUpdatedCode() throws DoNotContinueException {
		int status = -1;
		String strCmd = "", result = "";
		Node n = sod.logE(getStepsNode(), SingleOutputDocument.STEP_EL);
		sod.logA(n , STEP_ATT, IMPORT_STEP_ATT);

		strCmd = "\"" + getUModelBatchExe() + "\" /new=\""	+ str_final_ump 
			+ "\" /isd=\"" + dir_temp.getAbsolutePath()		//imports from dir_temp
			+ "\" /iclg=\"" + codeLanguage + "\" /ipsd=1 /dgen=1 /dopn=1 /chk";
		status = Common.executeCommand( strCmd , false , DependancyApplication.UMODEL);
		result += Common.getLastOutputMessage();
		if(result.equals("")) result = Common.getLastErrorMessage();

		sod.logE(n, CMD_OUTPUT_EL, result);
		sod.logA(n, STATUS_ATT, ((status == 0) ?  STATUS_PASS : STATUS_FAIL ) );

		return status;
	}	
	
	public int umpDiffTest() throws DoNotContinueException {
		int status = -1;
		String[] strCmd = new String[3];
		String result = "";	
		Node n = sod.logE(getStepsNode(), STEP_EL);
		sod.logA(n , STEP_ATT, COMPARE_UMP_STEP_ATT);		
		
		Node fileNode = sod.logE(n, INPUT_EL);
		sod.logA(fileNode, FILE_ATT, str_ump);
		fileNode = sod.logE(n , INPUT_EL);
		sod.logA(fileNode, FILE_ATT, str_final_ump);
		
		UmpDiffTest udt = new UmpDiffTest();
		udt.setTestLogDir(dir_log_test_case);
		result = udt.setupUmpDiffTest(new File(str_ump), new File(str_final_ump));
		if(result.equals("")) {
			try {
				strCmd = udt.parseDocuments();
			} catch (Exception e) {	result += e.getStackTrace(); }
			
			if(strCmd[0].equals("error")) result += strCmd[1];
			else { status = Common.executeCommand( strCmd[1] , false , DependancyApplication.DIFFDOG);  }			
			
			result += Common.getLastOutputMessage();
			if(result.equals("")) result = Common.getLastErrorMessage();
			
			sod.logA(n, DIFFDOG_COMMAND_ATT, strCmd[2]);			
		}
		
		sod.logE(n, CMD_OUTPUT_EL, result);
		sod.logA(n, STATUS_ATT, ((status == 0) ?  STATUS_PASS : STATUS_FAIL ) );
		
		return status;
	}
	
	private void copyFileToTempDir(File f) throws FileNotFoundException, IOException {
		if(!f.isDirectory()) {
			File out = new File (dir_temp + "\\"+ f.getName()); 
			FileInputStream fis  = new FileInputStream(f);
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
			// Replaced next line of code with explicit filter creation
			// File list[] = f.listFiles( new DirectoryExcludeFilter("CVS") );
			File list[] = f.listFiles( new FileFilter() {
				public boolean accept(File file) { 
				return !(file.isDirectory() && file.getName().equals("CVS")); 
				} 
				}
			);
			for(File file : list) {
				if(file.exists()) {
					copyFileToTempDir(file);
				}
			}
			/*
			List l = Arrays.asList(f.listFiles());
			Iterator i = l.iterator();
			while (i.hasNext()) {				
				Object o = i.next();
				if( o != null && ((File)o).exists() && (!((File)o).getName().equals("CVS")) ) {
					copyFileToTempDir((File)o);
				}
			}*/
		}
	}
	class DirectoryExcludeFilter implements FileFilter 
	{
		DirectoryExcludeFilter(String arg) {
			this.accept(new File(arg));
		}
		public boolean accept(File arg) {			
			return false;
		}		
	}
	
	public void deleteTempDir() {
		List l = Arrays.asList(dir_temp.listFiles());
		Iterator i = l.iterator();
		while (i.hasNext()) {			
			Object o = i.next();
			if( o != null && ((File)o).exists() ) {
				((File)o).delete();
			}
		}
	}
}