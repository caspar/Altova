package com.altova.umodel.regression.functional;

import static com.altova.Depend.*;
import static com.altova.umodel.regression.functional.SingleOutputDocument.COMPARE_UMP_STEP_ATT;
import static com.altova.umodel.regression.functional.SingleOutputDocument.DIFFDOG_COMMAND_ATT;
import static com.altova.umodel.regression.functional.SingleOutputDocument.FILE_ATT;
import static com.altova.umodel.regression.functional.SingleOutputDocument.FILE_COMPARE_EL;
import static com.altova.umodel.regression.functional.SingleOutputDocument.INPUT_EL;
import static com.altova.umodel.regression.functional.SingleOutputDocument.STATUS_ATT;
import static com.altova.umodel.regression.functional.SingleOutputDocument.STATUS_FAIL;
import static com.altova.umodel.regression.functional.SingleOutputDocument.STATUS_PASS;
import static com.altova.umodel.regression.functional.SingleOutputDocument.STEP_ATT;
import static com.altova.umodel.regression.functional.UModelTestTypes.*;
import static com.altova.util.LoggerUtils.logger;
import static com.altova.util.Settings.getFlag;
import static com.altova.util.Settings.getUModelBatchExe;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import net.hblok.io.AndFileFilter;
import net.hblok.io.DirectoryContentFileFilter;
import net.hblok.io.ExtensionFileFilter;
import net.hblok.io.FileFilterUtils;
import net.hblok.io.FilterAdapter;
import net.hblok.io.NegateFileFilter;
import net.hblok.io.ParentDirectoryFileFilter;
import net.hblok.io.RegexFileFilter;
import net.hblok.io.RegexFilenameFilter;

import org.w3c.dom.Node;

import com.altova.Depend.DependancyApplication;
import com.altova.robots.ScriptMistakeException;
import com.altova.util.Settings.AltovaApplication;

/**
 * UModel Regression Base Class
 * 
 * @author Phelim McConigly
 *
 */
public class TestBase {

	File testDir = null;	
	File testLogDir = null;
	File umpSedReplace = null; 
	File umpFile = null ;
	File refUmpFile = null;
	
	SingleOutputDocument sod;
	
	Node projectNode ;
	Node testNode ;

	public String testKey ;
	File srcDirectory ;
	File refDirectory;

	void setTestKey(String key) {
		testKey = key ;
	}
	public String getTestKey() { 
		return testKey ; 
	}	
	void setSourceDir() {

		if(testKey.equals(BINARY_CS_2_0)) srcDirectory = new File(BIN_CS_DIR , SRC ) ;  		
		else if(testKey.equals(BINARY_CS_3_0)) srcDirectory = new File(BIN_CS30_DIR , SRC ) ;
		else if(testKey.equals(BINARY_CS_4_0)) srcDirectory = new File(BIN_CS40_DIR , SRC ) ;
		else if(testKey.equals(BINARY_CS_GAC)) srcDirectory =  new File(BIN_CS_GAC_DIR , SRC ) ;
		else if(testKey.equals(BINARY_CS_MSVS)) srcDirectory = new File(BIN_CS_MSVS_DIR , SRC ) ;
		else if(testKey.equals(BINARY_JAVA_5)) srcDirectory = new File(BIN_JAVA5_DIR, SRC ) ; 
		else if(testKey.equals(BINARY_JAVA_5_JAR)) srcDirectory = new File(BIN_JAR_DIR , SRC ) ;
		else if(testKey.equals(BINARY_JAVA_5_CLASSPATH)) srcDirectory = new File( BIN_JAVA_CLASSPATH , SRC ) ;
		else if(testKey.equals(BINARY_JAVA_5_RUNTIME)) srcDirectory = new File( BIN_JAVA_RUNTIME , SRC ) ;
		else if(testKey.equals(BINARY_JAVA_8)) srcDirectory = new File(BIN_JAVA8_DIR, SRC ) ; 
		else if(testKey.equals(BINARY_JAVA_8_JAR)) srcDirectory = new File(BIN_JAR_DIR , SRC ) ;
		else if(testKey.equals(BINARY_JAVA_8_CLASSPATH)) srcDirectory = new File( BIN_JAVA_CLASSPATH , SRC ) ;
		else if(testKey.equals(BINARY_JAVA_8_RUNTIME)) srcDirectory = new File( BIN_JAVA_RUNTIME , SRC ) ;
		else if(testKey.equals(BINARY_VB_8_KEYWORDS)) srcDirectory =  new File (BIN_VB_LANG_KYWRDS_DIR , SRC) ;
		else if(testKey.equals(BINARY_VB_8_LANG_SPEC)) srcDirectory =  new File (BIN_VB_LANG_SPEC_DIR , SRC) ;
		else if(testKey.equals(BINARY_VB_9)) srcDirectory =  new File (BIN_VB9_DIR , SRC) ;

		else if(testKey.equals(CG_CS_2_0)) srcDirectory =  new File(CG_CS_DIR , SRC ) ;
		else if(testKey.equals(CG_CS_3_0)) srcDirectory =  new File(CG_CS30_DIR , SRC ) ;
		else if(testKey.equals(CG_CS_4_0)) srcDirectory =  new File(CG_CS40_DIR , SRC ) ;
		else if(testKey.equals(CG_CS_PROJ)) srcDirectory =  new File(CG_CS_PROJ_DIR , SRC ) ;
		else if(testKey.equals(CG_CS_BDS_PROJ)) srcDirectory =  new File(CG_CS_BDSPROJ_DIR, SRC ) ;
		else if(testKey.equals(CG_CS_D_PROJ)) srcDirectory =  new File(CG_CS_D_PROJ_DIR, SRC ) ;
		else if(testKey.equals(CG_CS_SLN)) srcDirectory =  new File(CG_CS_SLN_DIR , SRC ) ;

		else if(testKey.equals(CG_JAVA_5)) srcDirectory =  new File(CG_JAVA5_DIR , SRC ) ;
		else if(testKey.equals(CG_JAVA_8)) srcDirectory =  new File(CG_JAVA8_DIR , SRC ) ;
		else if(testKey.equals(CG_JAVA_1_4)) srcDirectory =  new File(CG_JAVA14_DIR , SRC ) ;
		else if(testKey.equals(CG_JAVA_ECLIPSE)) srcDirectory =  new File(CG_ECLIPSE_DIR , SRC ) ;
		else if(testKey.equals(CG_JAVA_NETBEANS)) srcDirectory =  new File(CG_NETBEANS_DIR , SRC ) ;
		else if(testKey.equals(CG_JAVA_JBUILDER)) srcDirectory =  new File(CG_JBUILDER_DIR , SRC ) ;

		else if(testKey.equals(CG_VB_8_KEYWORDS)) srcDirectory =  new File (CG_VB_LANG_KYWRDS_DIR , SRC) ;
		else if(testKey.equals(CG_VB_8_LANG_SPEC)) srcDirectory =  new File (CG_VB_LANG_SPEC_DIR , SRC) ;
		else if(testKey.equals(CG_VB_9)) srcDirectory =  new File (CG_VB9_DIR , SRC) ;
		else if(testKey.equals(CG_VB_VBPROJ)) srcDirectory =  new File (CG_VB_VBPROJ_DIR , SRC) ;
		
		else if(testKey.equals(XSD_TEST)) srcDirectory =  new File(XSD_DIR, SRC ) ;
		else if(testKey.equals(XSD_DIR_TEST)) srcDirectory =  new File(XSD_DIR_DIR, SRC ) ;
		else if(testKey.equals(XSD_TEST_INVALID)) srcDirectory =  new File(XSD_INVALID_DIR, SRC ) ;
		
		else if(testKey.equals(SYNTAX_TEST)) srcDirectory =  SYNTAX_CHECK_DIR ;

		else if(testKey.equals(MERGE_TEST)) srcDirectory =  new File(MERGE_DIR, SRC ) ;

		else srcDirectory = null ;
	}
	void setRefDir() {

		if(testKey.equals(BINARY_CS_2_0)) refDirectory = new File(BIN_CS_DIR , REF ) ;  		
		else if(testKey.equals(BINARY_CS_3_0)) refDirectory = new File(BIN_CS30_DIR , REF ) ;
		else if(testKey.equals(BINARY_CS_4_0)) refDirectory = new File(BIN_CS40_DIR , REF ) ;
		else if(testKey.equals(BINARY_CS_GAC)) refDirectory =  new File(BIN_CS_GAC_DIR , REF ) ;
		else if(testKey.equals(BINARY_CS_MSVS)) refDirectory = new File(BIN_CS_MSVS_DIR , REF ) ;
		else if(testKey.equals(BINARY_JAVA_5)) refDirectory = new File(BIN_JAVA5_DIR, REF ) ; 
		else if(testKey.equals(BINARY_JAVA_5_JAR)) refDirectory = new File(BIN_JAR_DIR , REF ) ;
		else if(testKey.equals(BINARY_JAVA_5_CLASSPATH)) refDirectory = new File( BIN_JAVA_CLASSPATH , REF ) ;
		else if(testKey.equals(BINARY_JAVA_5_RUNTIME)) refDirectory = new File( BIN_JAVA_RUNTIME , REF ) ;
		else if(testKey.equals(BINARY_JAVA_8)) refDirectory = new File(BIN_JAVA8_DIR, REF ) ; 
		else if(testKey.equals(BINARY_JAVA_8_JAR)) refDirectory = new File(BIN_JAR_DIR , REF ) ;
		else if(testKey.equals(BINARY_JAVA_8_CLASSPATH)) refDirectory = new File( BIN_JAVA_CLASSPATH , REF ) ;
		else if(testKey.equals(BINARY_JAVA_8_RUNTIME)) refDirectory = new File( BIN_JAVA_RUNTIME , REF ) ;
		else if(testKey.equals(BINARY_VB_8_KEYWORDS)) refDirectory =  new File(BIN_VB_LANG_KYWRDS_DIR, REF) ;
		else if(testKey.equals(BINARY_VB_8_LANG_SPEC)) refDirectory =  new File(BIN_VB_LANG_SPEC_DIR, REF) ;
		else if(testKey.equals(BINARY_VB_9)) refDirectory =  new File(BIN_VB9_DIR, REF) ;
	
		else if(testKey.equals(CG_CS_2_0)) refDirectory =  new File(CG_CS_DIR , REF ) ;
		else if(testKey.equals(CG_CS_3_0)) refDirectory =  new File(CG_CS30_DIR , REF ) ;
		else if(testKey.equals(CG_CS_4_0)) refDirectory =  new File(CG_CS40_DIR , REF ) ;
		else if(testKey.equals(CG_CS_PROJ)) refDirectory =  new File(CG_CS_PROJ_DIR , REF ) ;
		else if(testKey.equals(CG_CS_BDS_PROJ)) refDirectory =  new File(CG_CS_BDSPROJ_DIR, REF ) ;
		else if(testKey.equals(CG_CS_D_PROJ)) refDirectory =  new File(CG_CS_D_PROJ_DIR, REF ) ;
		else if(testKey.equals(CG_CS_SLN)) refDirectory =  new File(CG_CS_SLN_DIR , REF ) ;

		else if(testKey.equals(CG_JAVA_8)) refDirectory =  new File(CG_JAVA8_DIR , REF ) ;
		else if(testKey.equals(CG_JAVA_5)) refDirectory =  new File(CG_JAVA5_DIR , REF ) ;
		else if(testKey.equals(CG_JAVA_1_4)) refDirectory =  new File(CG_JAVA14_DIR , REF ) ;
		else if(testKey.equals(CG_JAVA_ECLIPSE)) refDirectory =  new File(CG_ECLIPSE_DIR , REF ) ;
		else if(testKey.equals(CG_JAVA_NETBEANS)) refDirectory =  new File(CG_NETBEANS_DIR , REF ) ;
		else if(testKey.equals(CG_JAVA_JBUILDER)) refDirectory =  new File(CG_JBUILDER_DIR , REF ) ;

		else if(testKey.equals(CG_VB_8_KEYWORDS)) refDirectory =  new File(CG_VB_LANG_KYWRDS_DIR, REF) ;
		else if(testKey.equals(CG_VB_8_LANG_SPEC)) refDirectory =  new File(CG_VB_LANG_SPEC_DIR, REF) ;
		else if(testKey.equals(CG_VB_9)) refDirectory =  new File(CG_VB9_DIR, REF) ;
		else if(testKey.equals(CG_VB_VBPROJ)) refDirectory =  new File(CG_VB_VBPROJ_DIR, REF) ;
		
		else if(testKey.equals(XSD_TEST)) refDirectory =  new File(XSD_DIR, REF ) ;
		else if(testKey.equals(XSD_DIR_TEST)) refDirectory =  new File(XSD_DIR_DIR, REF ) ;
		else if(testKey.equals(XSD_TEST_INVALID)) refDirectory =  new File(XSD_INVALID_DIR, REF ) ;

		else if(testKey.equals(MERGE_TEST)) refDirectory =  new File(MERGE_DIR, REF ) ;
		
		else refDirectory = null ;
	}
	public File getSourceDir() { 
		return srcDirectory; 
	}

	public File getRefDir() { 
		return refDirectory; 
	}

	public File getLogDir() {
		return getLogDir(null) ;
	}
	public File getLogDir(File f) {
		File key; 
		if(
				(testKey.equals(BINARY_CS_2_0)) ||
				(testKey.equals(BINARY_CS_3_0)) ||
				(testKey.equals(BINARY_CS_4_0)) ||
				(testKey.equals(BINARY_CS_GAC)) ||
				(testKey.equals(BINARY_CS_MSVS)) ||
				(testKey.equals(BINARY_JAVA_5)) ||
				(testKey.equals(BINARY_JAVA_5_JAR)) ||
				(testKey.equals(BINARY_JAVA_5_CLASSPATH)) ||
				(testKey.equals(BINARY_JAVA_5_RUNTIME)) || 
				(testKey.equals(BINARY_JAVA_8)) ||
				(testKey.equals(BINARY_JAVA_8_JAR)) ||
				(testKey.equals(BINARY_JAVA_8_CLASSPATH)) ||
				(testKey.equals(BINARY_JAVA_8_RUNTIME)) || 
				(testKey.equals(BINARY_VB_9)) ||
				(testKey.equals(BINARY_VB_8_KEYWORDS)) ||
				(testKey.equals(BINARY_VB_8_LANG_SPEC))) {
			key= new File(LOGS_BIN_DIR, testKey ) ;
		}
		else if (		
				(testKey.equals(CG_CS_2_0)) || 
				(testKey.equals(CG_CS_3_0)) || 
				(testKey.equals(CG_CS_4_0)) ||
				(testKey.equals(CG_CS_PROJ)) ||
				(testKey.equals(CG_CS_BDS_PROJ)) || 
				(testKey.equals(CG_CS_D_PROJ)) || 
				(testKey.equals(CG_CS_SLN)) ||
				(testKey.equals(CG_JAVA_8)) ||
				(testKey.equals(CG_JAVA_5)) ||
				(testKey.equals(CG_JAVA_1_4)) ||
				(testKey.equals(CG_JAVA_ECLIPSE)) ||
				(testKey.equals(CG_JAVA_NETBEANS)) ||
				(testKey.equals(CG_JAVA_JBUILDER)) ||
				(testKey.equals(CG_VB_VBPROJ)) ||
				(testKey.equals(CG_VB_9)) ||
				(testKey.equals(CG_VB_8_KEYWORDS)) ||
				(testKey.equals(CG_VB_8_LANG_SPEC))) {
			key= new File(LOGS_CG_DIR, testKey ) ;			
		} 
		else if(testKey.equals(XSD_TEST)) 
			key =  new File(LOGS_XSD_DIR, testKey) ;
		else if(testKey.equals(XSD_DIR_TEST)) 
			key =  new File(LOGS_XSD_DIR, testKey) ;
		else if(testKey.equals(XSD_TEST_INVALID)) 
			key =  new File(LOGS_XSD_DIR, testKey) ;		
		else if(testKey.equals(SYNTAX_TEST)) 
			key =  new File(LOGS_SYN_DIR, testKey) ;		
		else if(
				(testKey.equals(UML_20)) ||				
				(testKey.equals(UML_21)) ||
				(testKey.equals(UML_22)) ||
				(testKey.equals(UML_23))) {
			key =  new File(LOGS_XMI_DIR, testKey) ;
		}
		else if(testKey.equals(MERGE_TEST)) 
			key =  new File(LOGS_MERGE_DIR, testKey) ;
		else key = null ;
		
		if(f != null) {
			String name = f.getName();
			if 	((testKey.equals(UML_20)) ||
			(testKey.equals(UML_21)) ||
			(testKey.equals(UML_22)) ||
			(testKey.equals(UML_23))) {
				// Remove any extension, if present, in the filename 
				if (name.lastIndexOf(".") > 0)
					name = name.substring(0, name.lastIndexOf("."));
			}
			return new File(key, name) ;
		}
		else return key ;		

	}

	public String getProjectDependencies(boolean source) throws ScriptMistakeException{
		File location ;
		
		if(source) location = testDir ;
		else location = testLogDir ; 
		
		String name = location.getAbsolutePath() + "\\" + location.getName() ;
		
		if( testKey.equals(CG_JAVA_1_4) 
				|| testKey.equals(CG_JAVA_8) 
				|| testKey.equals(CG_JAVA_5) 
				|| testKey.equals(CG_CS_2_0) 
				|| testKey.equals(CG_CS_3_0) 
				|| testKey.equals(CG_CS_4_0)
				|| testKey.equals(CG_VB_8_KEYWORDS) 
				|| testKey.equals(CG_VB_8_LANG_SPEC) 		
				|| testKey.equals(CG_VB_9)) 
			return location.getAbsolutePath() ;	
		
		else if (testKey.equals(CG_JAVA_ECLIPSE)) 	return location.getAbsolutePath() + "\\.project";			
		
		else if (testKey.equals(CG_JAVA_JBUILDER)) 	return name + ".jpx";
		
		else if(testKey.equals(CG_CS_PROJ)) 		return name + ".csproj";
		
		else if(testKey.equals(CG_CS_D_PROJ)) 		return name + ".csdproj";
		
		else if(testKey.equals(CG_CS_SLN)) 			return name + ".sln";
		
		else if (testKey.equals(CG_CS_BDS_PROJ)) 	return name + ".bdsproj";
		
		else if (testKey.equals(CG_VB_VBPROJ)) 		return findProjFile(location, VBPROJ_EXT, false).getAbsolutePath() ;

		else if (testKey.equals(CG_JAVA_NETBEANS)) 	return findNetbeansProjFile(location, NETBEANS_EXT, false).getAbsolutePath() ;
		
		throw new ScriptMistakeException("testKey not defined") ;		
	}
	
	private File findProjFile(File location, String ext, boolean recurse) throws ScriptMistakeException {
		
		boolean copyAssemblyInfoFile = false ; //only relevant for bdsproj files
		
		List<File> extFileList = new ArrayList<File>() ;

		FilterAdapter fd2 = new FilterAdapter(new RegexFilenameFilter("CVS"));		
		NegateFileFilter notcvs = new NegateFileFilter(fd2);
		
		FileFilter ff ;
		 
		if(ext.equals("project") || ext.equals("classpath")) 
			ff = new RegexFileFilter(".*." + ext);		

		else {
			ff = new ExtensionFileFilter(ext);
			((ExtensionFileFilter)ff).setIncludeDirectories(recurse);
		}
		AndFileFilter filter = new AndFileFilter(ff, notcvs);
		extFileList = FileFilterUtils.listfiles(location, filter, true);
		
		if(ext.equals(VB_EXT) || ext.equals(CS_EXT) ) { //special case 
			copyAssemblyInfoFile = true ;
		}
		
		if(extFileList.size() == 0) throw new ScriptMistakeException("no project files found...") ;
		if(extFileList.size() != 1) {
			if(!copyAssemblyInfoFile == true)
					System.out.println("multiple project files found, taking the first occurance") ;
			ListIterator<File> li = extFileList.listIterator() ;
			
			while (li.hasNext() ) {
					File f = li.next() ;
				if((copyAssemblyInfoFile == true) && 
						(f.getName().equals(ASSEMBLY_INFO_FILE + "." + VB_EXT )) ||
						(f.getName().equals(ASSEMBLY_INFO_FILE + "." + CS_EXT )) 		
				)
					return f ;
				else if(f.getParent().equals(location.getAbsolutePath())) {
					return f ;
				}
				else throw new ScriptMistakeException("could not find vbproj in parent dir for this test case") ;
			}
		}		
		return extFileList.get(0) ;	
	}

private File findNetbeansProjFile(File location, String ext, boolean recurse) throws ScriptMistakeException {
/*
 * 		This function searches a root directory and all 
 * 		its sub-directories for a NetBeans project file. 
 * 		
 */		
		
		List<File> extFileList = new ArrayList<File>() ;

		FilterAdapter fd2 = new FilterAdapter(new RegexFilenameFilter("CVS"));		
		NegateFileFilter notcvs = new NegateFileFilter(fd2);
		
		FileFilter ff ;
		 

		ff = new ExtensionFileFilter(ext);
		((ExtensionFileFilter)ff).setIncludeDirectories(recurse);
		
		AndFileFilter filter = new AndFileFilter(ff, notcvs);
		extFileList = FileFilterUtils.listfiles(location, filter, true);
		
		
		if(extFileList.size() == 0) throw new ScriptMistakeException("no project files found...") ;
		ListIterator<File> li = extFileList.listIterator() ;
		File f = extFileList.get(0);
		if (!(f.getName().equals("project." + NETBEANS_EXT))) {
			while (li.hasNext() ) {
					f = li.next() ;
				if (f.getName().equals("project." + NETBEANS_EXT)) {
					return f ;
				}
			}
			throw new ScriptMistakeException("could not find project.xml for this test case") ;
		}		
		return extFileList.get(0) ;	
	}
/*
 * 		This function calls a DOS batch program named RESET_UI_SETTINGS 
 * 		which sets the UI Settings in the registry to a known state. 
 * 		
 */		

	public void set_ui_settings () {
		int status = -1;
		String cmd = "";
		String result = "";		
		cmd = "\"" + DELETE_UI_SETTINGS + "\"";
		try {
			status = Common.executeCommand( cmd , false , DependancyApplication.UMODEL);
			result += Common.getLastOutputMessage();
			if(result.equals("")) result = Common.getLastErrorMessage();
		} catch (DoNotContinueException e) {
			System.err.println(e.getMessage()); 
		}
	}

	public void copyDependsToSource(File f)  throws FileNotFoundException, IOException, DoNotContinueException {
		if (!(testKey.equals(CG_JAVA_NETBEANS))) {
			copyProjectFileToDir(f, testLogDir) ;			
		}
		copyDependsToSource();
	}
	
	public void copyDependsToSource() throws FileNotFoundException, IOException, DoNotContinueException {

		// The condition must be satistied that the dir name is the same as the sln, csdproj, jpx or bdsproj file.
		if (testKey.equals(CG_JAVA_ECLIPSE)) 	{			
			copyToSrc(false, PROJECT_EXT, CLASSPATH_EXT);							
		}
		else if (testKey.equals(CG_JAVA_JBUILDER)) 	{
			//	html file not necessary, but supresses import-generated-code step errors 
			copyToSrc(true, HTML, JPX_EXT );
		}
		else if (testKey.equals(CG_CS_PROJ)) { 							
			copyToSrc(true, CSPROJ_EXT );							
		}
		else if (testKey.equals(CG_CS_D_PROJ)) {
			copyToSrc(true, CSDPROJ_EXT, CS_EXT);							
		}
		else if (testKey.equals(CG_CS_SLN)) {
			// copy everything from the source to the log directory
			copySrcToLog("") ;
			//copyToSrc(true, SLN_EXT , CSDPROJ_EXT, CS_EXT) ;													
			//BUG: recursive search and copy of csdproj files (and their directories) needed to generate code.
		}			
		else if (testKey.equals(CG_CS_BDS_PROJ)) {
			copyToSrc(true, BDSPROJ_EXT , CS_EXT) ;
		}
		else if (testKey.equals(CG_VB_VBPROJ)) {
			copyToSrc(true, SLN_EXT, VBPROJ_EXT , VB_EXT) ;
		}		
		else if (testKey.equals(CG_JAVA_NETBEANS)) {
			copySrcToLog(EXCLUDE_JAVA.getAbsolutePath()) ;
		}			
		else if (testKey.equals(XSD_TEST) || testKey.equals(XSD_DIR_TEST)) {
			// copy everything from the source to the log directory
			copySrcToLog(EXCLUDE_CVS.getAbsolutePath()) ;
		}				
	}

	public void copyToSrc(boolean recurse, String... ext) throws IOException, DoNotContinueException {
		try {
			for(String e : ext) {
				copyProjectFileToDir(findProjFile(testDir, e, recurse), testLogDir) ;
//				copyProjectFileToDir(new File(testDir, testDir.getName() + e) , testLogDir) ;
		}} catch (FileNotFoundException fe) {
			logger.warning("this may not have to exist for test to succeed : " + fe.getStackTrace()) ; //?
		}			
		catch (ScriptMistakeException e) {
//			e.printStackTrace() ; //cannot handle .project extension file filter
			throw new DoNotContinueException(DoNotContinueException.FILE_NOT_FOUND, e) ;
		}
	}
	
	private void copySrcToLog (String exclude_file) throws IOException, DoNotContinueException {
	/*
	 * 	This procedure uses the DOS XCOPY command to copy all files and sub-directories
	 * 	from a source root directoray to a target directory. The parameter exclude file,
	 * 	if defined, should point to a file containing a list of files that are to be
	 *  excluded from the copy operation.
	 */	
		int status = -1;
		String cmd = "";
		String result = "";
		
		try {
			if (exclude_file.length()> 0)
				cmd = "XCOPY /S /Y /R" +  " \"" + testDir + "\" \"" + testLogDir + "\"" + " /EXCLUDE:" + exclude_file ;
			else
			    cmd = "XCOPY /S /Y /R \"" + testDir + "\" \"" + testLogDir + "\"";
				
			status = Common.executeCommand( cmd , false , DependancyApplication.UMODEL);
			result += Common.getLastOutputMessage();
			if(result.equals("")) result = Common.getLastErrorMessage();
		} catch (Exception e) {
			status = -1 ;
			e.printStackTrace() ;
			throw new DoNotContinueException("Exception" , e);			
		}	
		
	}

	public boolean createDll () throws DoNotContinueException {
		
		int status = -1;
		String cmd = "";
		String result = "";

		if  (testKey.equals(BINARY_VB_8_KEYWORDS) || testKey.equals(BINARY_VB_8_LANG_SPEC) || testKey.equals(BINARY_VB_9)) {  		
			cmd = "vbc /target:library /reference:Microsoft.VisualBasic.dll /imports:Microsoft.VisualBasic,System ";
			cmd += "/out:" + "\"" + testDir + "\\" + testDir.getName() + ".dll" + "\"";
			cmd +=  " " + testDir + "\\*.vb";
		}
		else if  (testKey.equals(BINARY_CS_3_0) || (testKey.equals(BINARY_CS_4_0))) {  		
			cmd = "csc /target:library /out:" + "\"" + testDir + "\\" + testDir.getName() + ".dll" + "\"";
			cmd +=  " /recurse:*.cs " + testDir + "\\*.cs";
		}	
		if (cmd.length() > 0) {
			try {							
				status = Common.executeCommand( cmd , false , DependancyApplication.UMODEL);
				result += Common.getLastOutputMessage();
				if(result.equals("")) result = Common.getLastErrorMessage();
				status = 0;
			} catch (Exception e) {
				status = -1 ;
				e.printStackTrace() ;
				throw new DoNotContinueException("Exception" , e);	
			}
		}	
		return (status == 0) ? true : false ;
	}
	public boolean createExe () throws DoNotContinueException {
		
		int status = -1;
		String cmd = "";
		String result = "";

		if (testKey.equals(BINARY_CS_3_0) || testKey.equals(BINARY_CS_4_0)) {
			cmd = "csc /target:exe /out:" + "\"" + testDir + "\\" + testDir.getName() + ".exe" + "\"";
			cmd +=  " /recurse:*.cs " + testDir + "\\*.cs";
		}
		else if (testKey.equals(BINARY_VB_9)) {
			cmd = "vbc /reference:Microsoft.VisualBasic.dll /imports:Microsoft.VisualBasic,System ";
			cmd += "/out:" + "\"" + testDir + "\\" + testDir.getName() + ".exe" + "\"";
			cmd +=  " " + testDir + "\\*.vb";
		}
		if (cmd.length() > 0) {
			try {
				status = Common.executeCommand( cmd , false , DependancyApplication.UMODEL);
				result += Common.getLastOutputMessage();
				if(result.equals("")) result = Common.getLastErrorMessage();
				status = 0;
			} catch (Exception e) {
				status = -1 ;
				e.printStackTrace() ;
				throw new DoNotContinueException("Exception" , e);			

			}
		}
		return (status == 0) ? true : false ;
	}

	public boolean updateRefUmp() throws DoNotContinueException
	{
		if(getFlag(DEBUG_MODE)) System.out.println("updateRefUmp") ;
		
		int status = -1;
		String cmd = "";
		String result = "";
		//Node n = sod.logE(testNode, STEP_EL);
		//sod.logA( n , STEP_ATT, IMPORT_STEP_ATT);		
			
		File refUmpFile = new File(refDirectory.getAbsolutePath(), (testDir.getName() + "\\" + testDir.getName() + ".ump"));
		cmd = "\"" + getUModelBatchExe() + "\" \"" + refUmpFile + "\" /new";
			
		if ( refUmpFile.isFile() && refUmpFile.exists() ) {	
			try {
				status = Common.executeCommand( cmd , false , DependancyApplication.UMODEL);
				result += Common.getLastOutputMessage();
				if(result.equals("")) result = Common.getLastErrorMessage();
			}catch (Exception e) {
				throw new DoNotContinueException("Error updating reference ump file", e) ;
			}
			status = 0;
		}
		else {
			result = "file not found: " + testDir.getAbsolutePath();	
		}			
		// sod.logE(n, CMD_INPUT_EL, cmd) ;
		// sod.logE(n, CMD_OUTPUT_EL, result) ;
		// sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));
		
		return (status == 0) ? true : false ;
	}

	public boolean updateSrcUmp(File srcUmpFile) throws DoNotContinueException
	{
		if(getFlag(DEBUG_MODE)) System.out.println("updateRefUmp") ;
		
		int status = -1;
		String cmd = "";
		String result = "";
		//Node n = sod.logE(testNode, STEP_EL);
		//sod.logA( n , STEP_ATT, IMPORT_STEP_ATT);		
			
		cmd = "\"" + getUModelBatchExe() + "\" \"" + srcUmpFile + "\" /new";
			
		if ( srcUmpFile.isFile() && srcUmpFile.exists() ) {	
			try {
				status = Common.executeCommand( cmd , false , DependancyApplication.UMODEL);
				result += Common.getLastOutputMessage();
				if(result.equals("")) result = Common.getLastErrorMessage();
			}catch (Exception e) {
				throw new DoNotContinueException("Error updating source ump file", e) ;
			}
			status = 0;
		}
		else {
			result = "file not found: " + testDir.getAbsolutePath();	
		}			
		// sod.logE(n, CMD_INPUT_EL, cmd) ;
		// sod.logE(n, CMD_OUTPUT_EL, result) ;
		// sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));
		
		return (status == 0) ? true : false ;
	}	
	public void copyProjectFileToDir(File in, File outDirName) throws FileNotFoundException, IOException {
		File out = new File (outDirName , in.getName()); 
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
	
	public void copyRenameProjectFileToDir(File in, File out) throws FileNotFoundException, IOException {

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
	
	public boolean copyUmpToRefDir() throws DoNotContinueException
	{
		if(getFlag(DEBUG_MODE)) System.out.println("CopyUmpToRefDir") ;
		
		int status = -1;
		String cmd = "";
		String result = "";
		//we should be in the source directory already at this stage.
		//Node n = sod.logE(testNode, STEP_EL);
		//sod.logA( n , STEP_ATT, IMPORT_STEP_ATT);		

		
			if ( testLogDir.isDirectory() && testLogDir.exists() ) {
			
				File logUmpFile = new File(testLogDir.getAbsolutePath(), (testDir.getName() + ".ump"));
				File refDir = new File(refDirectory.getAbsolutePath() + "\\" + testDir.getName());
					
				if ( logUmpFile.isFile() && logUmpFile.exists() ) {	
					try {
						copyProjectFileToDir(logUmpFile,refDir);
					}catch (Exception e) {
						throw new DoNotContinueException("Error copying reference ump file", e) ;
					}
					status = 0;
				}
				else {
				}			
			} else result = "file not found: " + testDir.getAbsolutePath();		
	

		//sod.logE(n, CMD_INPUT_EL, cmd) ;
		//sod.logE(n, CMD_OUTPUT_EL, result) ;
		//sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));
		
		return (status == 0) ? true : false ;
	}

	public boolean copyXmiToRefDir(File testFile) throws DoNotContinueException
	{
		if(getFlag(DEBUG_MODE)) System.out.println("CopyXmiToRefDir") ;
		
		int status = -1;
		String cmd = "";
		String result = "";
		//we should be in the source directory already at this stage.
		//Node n = sod.logE(testNode, STEP_EL);
		//sod.logA( n , STEP_ATT, IMPORT_STEP_ATT);		

		
			if ( testLogDir.isDirectory() && testLogDir.exists() ) {
			
				File logXmiFile = new File(testLogDir.getAbsolutePath(), (testFile.getName() + "." + getTestKey() + ".xmi"));
				File refDir = new File(testFile.getParent());
					
				if ( logXmiFile.isFile() && logXmiFile.exists() ) {	
					try {
						copyProjectFileToDir(logXmiFile,refDir);
					}catch (Exception e) {
						throw new DoNotContinueException("Error copying reference xmi file", e) ;
					}
					status = 0;
				}
				else {
				}			
			} else result = "file not found: " + testDir.getAbsolutePath();		
	

		//sod.logE(n, CMD_INPUT_EL, cmd) ;
		//sod.logE(n, CMD_OUTPUT_EL, result) ;
		//sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));
		
		return (status == 0) ? true : false ;
	}
	public boolean containsOr(String s, String... ss) {
		for(String c : ss) {
			if(s.contains(c)) return true ;
		}
		return false ;
	}
	
	protected boolean containsSpaceChar(File f) {
		return containsSpaceChar(f.getAbsolutePath()) ;
	}
	protected boolean containsSpaceChar(String s) {
		
		if(s.contains(" ")) return true ;
		else return false ;
		
	}
	
	/**
	 * @param f1
	 * @param f2
	 * @param stepNode
	 * @return
	 * @throws DoNotContinueException
	 */
//	protected boolean compareUMP(File f1, File f2, Node n)  throws DoNotContinueException {	//compare-ump step
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
	
	
	protected boolean compareUMP(File f1, File f2, Node n) throws DoNotContinueException {		
		sod.logA(n, STEP_ATT, COMPARE_UMP_STEP_ATT);
		Node fileNode = sod.logE(n, INPUT_EL);
		sod.logA(fileNode, FILE_ATT, f1.getName());
		fileNode = sod.logE(n, INPUT_EL);
		sod.logA(fileNode, FILE_ATT, f2.getName());

		String result = "";
		int status = -1;
		String[] strCmd = new String[3];	
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
			if(strCmd[0].equals("error")) result += strCmd[2];
			else {
				status = Common.executeCommand( strCmd[1] , false , DependancyApplication.DIFFDOG); //output to xml file
				result += Common.getLastOutputMessage();
				if(result.equals("")) 
					result = Common.getLastErrorMessage();				
				if(result.endsWith("different")) { // files are different, lets put the diff to file
					// set the output log file location from diffdog
					String umpdiff = f1.getParent() + "\\" + f1.getName() + "_v_" + f2.getName() + ".xml";
					strCmd[2] += umpdiff ;					
					status = Common.executeCommand( strCmd[2] , false , DependancyApplication.DIFFDOG); //output to file if different
					//DiffDog does not set the status to other than 0!
					status = -1; //failure in ump diff
					//set the file name showing the output of DiffDog ump diff

					sod.logE(n, FILE_COMPARE_EL, umpdiff);									
				}
			}
		}
		sod.logE(n, DIFFDOG_COMMAND_ATT, strCmd[2]);		
		sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));

		return ((status == 0) ? true : false );
	}
	
	
	/**
	 * Verifies that the specified filename exists and is a file,
	 * then create a File object and returns it. 
	 * 
	 * @param filename path and name of file to check
	 * @return a File object of the specified filename
	 * @throws IOException if the file could not be found 
	 */
	protected File verifyFile(String filename) throws IOException {
		if(!checkFile(filename)) {
			throw new FileNotFoundException("Could not find or open file '"+filename+"'.");
		}
		
		return new File(filename);
	}
	protected File verifyFile(File file) throws IOException {
		if(!checkFile(file.getAbsolutePath())) {
			throw new FileNotFoundException("Could not find or open file '"+file+"'.");
		}
		
		return file;			
	}
	
	/**
	 * Checks that the specified filename exists and is a file.  
	 * 
	 * @param filename path and name of file to check
	 * @return true if the file exists and is a file, false otherwise
	 */
	protected boolean checkFile(String filename) {
		File file = new File(filename);
		return file.isFile();
	}
}
