package com.altova.umodel.regression.functional;

import com.altova.util.Settings;

public class UModelTestTypes {

	/***************************************************************/
	
	public static final String TEST_CASES_DIR 	= "TEST_CASES_DIR" ;
	public static final String ALTOVA 			= "ALTOVA" ;
	public static final String PROCESS_TIMEOUT 	= "PROCESS_TIMEOUT" ;
	public static final int DEFAULT_PROCESS_TIMEOUT = 60 ; //seconds
	public static final String DEBUG_MODE 	 	= "DEBUG_MODE" ;
	public static final String TEST_MODE		= "TEST_MODE" ;
	public static final String COPY_TO_REF		= "COPY_TO_REF" ;
	public static final String CREATE_DLL		= "CREATE_DLL" ;
	public static final String CREATE_EXE		= "CREATE_EXE" ;
	public static final String UPDATE_REF_UMP	= "UPDATE_REF_UMP" ;

	
	/***************************************************************/
	public static final String CG_ALL = 			"CG_ALL" ;	
	public static final String CG_JAVA_ALL = 		"CG_JAVA_ALL" ;
	public static final String CG_CS_ALL = 			"CG_CS_ALL" ;
	public static final String CG_VB_ALL = 			"CG_VB_ALL" ;
	public static final String CG_ANY = 			"CG_ANY" ;
	public static final String CG_JAVA_ANY = 		"CG_JAVA_ANY" ;
	public static final String CG_CS_ANY = 			"CG_CS_ANY" ;
	public static final String CG_VB_ANY = 			"CG_VB_ANY" ;
	
	public static final String CG_JAVA_1_4 = 		"CG_JAVA_1_4" ;
	public static final String CG_JAVA_5 = 			"CG_JAVA_5" ;
	public static final String CG_JAVA_7 =			"CG_JAVA_7" ;
	public static final String CG_JAVA_8 =			"CG_JAVA_8" ;
	public static final String CG_JAVA_ECLIPSE = 	"CG_JAVA_ECLIPSE" ;
	public static final String CG_JAVA_NETBEANS = 	"CG_JAVA_NETBEANS" ;
	public static final String CG_JAVA_JBUILDER = 	"CG_JAVA_JBUILDER" ;
	
	public static final String CG_CS_4_0 = 			"CG_CS_4_0" ;
	public static final String CG_CS_3_0 = 			"CG_CS_3_0" ;
	public static final String CG_CS_2_0 = 			"CG_CS_2_0" ;
	public static final String CG_CS_PROJ = 		"CG_CS_PROJ" ;   			//cgCsprojTest
	public static final String CG_CS_BDS_PROJ = 	"CG_CS_BDS_PROJ" ; 			//cgBdsprojTest - borland
	public static final String CG_CS_D_PROJ = 		"CG_CS_D_PROJ" ; 			//cgCsdprojTest
	public static final String CG_CS_SLN = 			"CG_CS_SLN" ; 	 			//cgCsSlnTest

	public static final String CG_VB_9 = 			"CG_VB_9" ; 				//cgVBDirTest
	public static final String CG_VB_8 = 			"CG_VB_8" ; 				//cgVBDirTest
	public static final String CG_VB_71 = 			"CG_VB_71" ; 				//cgVBDirTest	
	public static final String CG_VB_8_KEYWORDS = 	"CG_VB_8_KEYWORDS" ; 
	public static final String CG_VB_8_LANG_SPEC = 	"CG_VB_8_LANG_SPEC" ;
	public static final String CG_VB_VBPROJ = 		"CG_VB_VBPROJ" ;
	
//	public static final String CG_NEG_ANY = "CG_NEG_ANY" ; 
	
	/***************************************************************/
	public static final String BINARY_ALL = 		"BINARY_ALL" ; 				//binTest
	public static final String BINARY_ANY = 		"BINARY_ANY" ;
	public static final String BINARY_JAVA_ALL = 	"BINARY_JAVA_ALL" ;	
	public static final String BINARY_CS_ALL = 		"BINARY_CS_ALL" ;
	public static final String BINARY_VB_ALL = 		"BINARY_VB_ALL" ;
	public static final String BIN_JAVA_ANY = 		"BIN_JAVA_ANY" ; 
	public static final String BIN_CS_ANY = 		"BIN_CS_ANY" ;
	public static final String BIN_VB_ANY = 		"BIN_VB_ANY" ;
	
	public static final String BINARY_JAVA_5 = 		"BINARY_JAVA_5" ; 					//binJava5DirTest
	public static final String BINARY_JAVA_5_JAR = 	"BINARY_JAVA_5_JAR" ; 				//binJava5JarTest
	public static final String BINARY_JAVA_5_CLASSPATH = "BINARY_JAVA_5_CLASSPATH" ; 	//binJava5ClasspathArchivesTest
	public static final String BINARY_JAVA_5_RUNTIME = "BINARY_JAVA_5_RUNTIME" ;		 //binJava5RuntimeArchivesTest
	
	public static final String BINARY_JAVA_8 = 		"BINARY_JAVA_8" ; 					//binJava8DirTest
	public static final String BINARY_JAVA_8_JAR = 	"BINARY_JAVA_8_JAR" ; 				//binJava8JarTest
	public static final String BINARY_JAVA_8_CLASSPATH = "BINARY_JAVA_8_CLASSPATH" ; 	//binJava8ClasspathArchivesTest
	public static final String BINARY_JAVA_8_RUNTIME = "BINARY_JAVA_8_RUNTIME" ; 		//binJava8RuntimeArchivesTest

	public static final String BINARY_JAVA_7 = 		"BINARY_JAVA_7" ; 					//binJava7DirTest
	public static final String BINARY_JAVA_7_JAR = 	"BINARY_JAVA_7_JAR" ; 				//binJava7JarTest
	public static final String BINARY_JAVA_7_CLASSPATH = "BINARY_JAVA_7_CLASSPATH" ; 	//binJava7ClasspathArchivesTest
	public static final String BINARY_JAVA_7_RUNTIME = "BINARY_JAVA_7_RUNTIME" ; 		//binJava7RuntimeArchivesTest

	public static final String BINARY_CS_2_0 = 		"BINARY_CS_2_0" ; 			//binCsharpDirTest
	public static final String BINARY_CS_3_0 = 		"BINARY_CS_3_0" ; 			//binCsharpDirTest
	public static final String BINARY_CS_4_0 = 		"BINARY_CS_4_0" ; 			//binCsharpDirTest
	public static final String BINARY_CS_GAC = 		"BINARY_CS_GAC" ; 			//binCsharpGACTest
	public static final String BINARY_CS_MSVS = 	"BINARY_CS_MSVS" ; 			//binCsharpMSVSTest
	
	public static final String BINARY_VB_71 = 		"BINARY_VB_71" ;
	public static final String BINARY_VB_8 = 		"BINARY_VB_8" ;
	public static final String BINARY_VB_9 = 		"BINARY_VB_9" ;
	public static final String BINARY_VB_8_KEYWORDS = 	"BINARY_VB_8_KEYWORDS" ; 
	public static final String BINARY_VB_8_LANG_SPEC = 	"BINARY_VB_8_LANG_SPEC" ;
	public static final String BINARY_VB_GAC = 		"BINARY_VB_GAC" ;
	public static final String BINARY_VB_MSVS = 	"BINARY_VB_MSVS" ;

	/***************************************************************/

	public static final String XMI_ALL = 			"XMI_ALL" ;
	public static final String XMI_ANY = 			"XMI_ANY" ;
	public static final String UML_20 = 			"UML_20";
	public static final String UML_21 = 			"UML_21";
	public static final String UML_22 = 			"UML_22";
	public static final String UML_23 = 			"UML_23";
	
	public static final String RTE_TEST = 			"RTE_TEST" ;
	public static final String MERGE_TEST = 		"MERGE_TEST" ;
	
	public static final String XSD_ALL=				"XSD_ALL" ;
	public static final String XSD_ANY=				"XSD_ANY" ;		
	public static final String XSD_TEST = 			"XSD_TEST" ;
	public static final String XSD_TEST_INVALID = 	"XSD_TEST_INVALID" ; 
	public static final String XSD_DIR_TEST = 		"XSD_DIR_TEST" ;
	public static final String SYNTAX_TEST = 		"SYNTAX_CHECK";
	public static final String SYNTAX_CHECK_SYNC = 	"SYNTAX_CHECK_SYNCHRONIZATION";	
	
	public static final String MOD_TEST = 			"MOD_TEST" ;
	public static final String RME_TEST = 			"RME_TEST" ;
	public static final String NCG_TEST = 			"NCG_TEST" ;
	public static final String NCG_JAVA = 			"NCG_JAVA" ;
	public static final String NCG_CS = 			"NCG_CS" ;

	public static final String SYNTAX_ERRORS = 		"SYNTAX_ERRORS" ;
	public static final String NOT_SYNTAX_ERRORS =	"NOT_SYNTAX_ERRORS" ; 
	public static final String UNCERTAIN_SYNTAX_ERRORS = "UNCERTAIN_SYNTAX_ERRORS" ;  

	/***************************************************************/
	
	private UModelTestTypes() {}
	
	public static boolean getFlagsOr(String... keys) {
	
		for(String key : keys) {
			
			if(Settings.getFlag(key)) return true ;

			if(key.equals(CG_ANY)) 		 return getFlagsOr(CG_ALL, 			  CG_VB_8, 			 	CG_VB_9,		CG_JAVA_8,		
														   CG_JAVA_1_4, 	  CG_JAVA_5, 		 	CG_CS_2_0,  	CG_CS_3_0,			
														   CG_CS_D_PROJ,	  CG_CS_PROJ, 		 	CG_CS_SLN, 		CG_CS_BDS_PROJ,	
														   CG_JAVA_ECLIPSE,   CG_JAVA_NETBEANS,  	CG_JAVA_7,		CG_JAVA_JBUILDER);
			
			if(key.equals(CG_JAVA_ANY))  return getFlagsOr(CG_ALL, 			  CG_JAVA_1_4,		 	CG_JAVA_5, 		CG_JAVA_8, 		
														   CG_JAVA_ECLIPSE,   CG_JAVA_NETBEANS,	 	CG_JAVA_7,		CG_JAVA_JBUILDER);
			
			if(key.equals(CG_CS_ANY)) 	 return getFlagsOr(CG_ALL, 			  CG_CS_2_0,		 	CG_CS_3_0, 		CG_CS_4_0,		
														   CG_CS_PROJ, 		  CG_CS_BDS_PROJ, 	 	CG_CS_D_PROJ, 	CG_CS_SLN) ;
			
			if(key.equals(CG_VB_ANY)) 	 return getFlagsOr(CG_ALL, 			  CG_VB_71, 		 	CG_VB_8, 		CG_VB_9,		
														   CG_VB_8_KEYWORDS,  CG_VB_8_LANG_SPEC, 	CG_VB_VBPROJ);
			
			
			if(key.equals(BINARY_ANY))   return getFlagsOr(BINARY_ALL,				
														   BINARY_JAVA_5, 		BINARY_JAVA_5_JAR,		BINARY_JAVA_5_CLASSPATH, 	BINARY_JAVA_5_RUNTIME,
														   BINARY_JAVA_7,		BINARY_JAVA_7_JAR,		BINARY_JAVA_7_CLASSPATH,	BINARY_JAVA_7_RUNTIME,	
														   BINARY_JAVA_8,		BINARY_JAVA_8_JAR,		BINARY_JAVA_8_CLASSPATH,	BINARY_JAVA_8_RUNTIME,
														   BINARY_CS_2_0, 		BINARY_CS_3_0, 		  	BINARY_CS_GAC, 				BINARY_CS_MSVS, 	
														   BINARY_VB_8,			BINARY_VB_9, 	  		BINARY_VB_GAC,				BINARY_VB_MSVS);
			
			if(key.equals(BIN_JAVA_ANY)) return getFlagsOr(BINARY_ALL, 				
														   BINARY_JAVA_5, 		BINARY_JAVA_5_JAR,		BINARY_JAVA_5_CLASSPATH, 	BINARY_JAVA_5_RUNTIME,
														   BINARY_JAVA_7,		BINARY_JAVA_7_JAR,		BINARY_JAVA_7_CLASSPATH,	BINARY_JAVA_7_RUNTIME,	
														   BINARY_JAVA_8,		BINARY_JAVA_8_JAR,		BINARY_JAVA_8_CLASSPATH,	BINARY_JAVA_8_RUNTIME);		
												
			if(key.equals(BIN_CS_ANY))	 return getFlagsOr(BINARY_ALL, 				BINARY_CS_2_0,				BINARY_CS_3_0, 	
														   BINARY_CS_4_0, 	   		BINARY_CS_GAC, 				BINARY_CS_MSVS);
			
			if(key.equals(BIN_VB_ANY))	 return getFlagsOr(BINARY_ALL,				BINARY_VB_8, 				BINARY_VB_8_KEYWORDS, 
														   BINARY_VB_9, 			BINARY_VB_GAC, 				BINARY_VB_MSVS, 
														   BINARY_VB_8_LANG_SPEC);
			
			if(key.equals(XSD_ANY)) 	 return getFlagsOr(XSD_ALL, 	XSD_TEST, 	XSD_DIR_TEST, 	XSD_TEST_INVALID) ;
			if(key.equals(XMI_ANY)) 	 return getFlagsOr(XMI_ALL, 	UML_20, 	UML_21, 	UML_22,	UML_23) ;			

//			if(key.equals(CG_VB_ANY)) return getFlagsOr(CG_VB_8) ;
//			if(key.equals(CG_NEG_ANY)) return false ;			
		}
		return false ;
	}
}
