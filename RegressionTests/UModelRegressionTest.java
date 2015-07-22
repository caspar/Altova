package com.altova.umodel.regression.functional;

import static com.altova.umodel.regression.functional.SingleOutputDocument.*;

import static com.altova.Depend.*;

import static com.altova.util.LoggerUtils.logger;
import static com.altova.umodel.regression.functional.UModelTestTypes.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import net.hblok.io.AndFileFilter;
import net.hblok.io.DirectoryContentFileFilter;
import net.hblok.io.DirectoryFileFilter;
import net.hblok.io.ExcludeListFileFilter;
import net.hblok.io.ExtensionFileFilter;
import net.hblok.io.FileFilterUtils;
import net.hblok.io.FilterAdapter;
import net.hblok.io.NegateFileFilter;
import net.hblok.io.ParentDirectoryFileFilter;
import net.hblok.io.RegexFileFilter;
import net.hblok.io.RegexFilenameFilter;
import org.w3c.dom.Node;
import com.altova.robots.ScriptMistakeException;
import com.altova.util.Settings;

import java.util.Date;

//Class with main method
public class UModelRegressionTest {

	public long total = 0;

	// private TestXMI regXMITest;
	// private TestRTE regRTETest;
	private File rteRootDirectory = null; 	

	private File xmiRootDirectory = null;
	private File mergeTargetDirectory = null;
	private File mergeSrcDirectory = null;

	// private File syntaxRootDirectory = null ;

	public UModelRegressionTest(String[] args) {

		// if(!args[0].equals("")) Settings.setPropertiesFile(args[0]) ;
		logger.config("output log directory set to: " + log_root_dir.getAbsolutePath());
		log_root_dir.mkdirs();
		LOGS_XML_DIR.mkdirs();
		LOGS_HTML_DIR.mkdirs();

	}

	/**
	 * @param log
	 * @param c
	 */
	private void transform(File log, Object c) {
		ResultsXSLT x = new ResultsXSLT();
		try {
			x.transform(log, c);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	// /***********************************************/
	// /******* Round Trip Engineering *************/
	// /***********************************************/
	// public void roundTripEngineering(String s) {
	// currentLogDir = new File(currentLogDir + "\\rte");
	// File rteLogFile = new File( currentLogDir + "\\rte_log.xml" ); //xml
	// output file for logs of this test
	// try {
	// currentLogDir.mkdirs();
	// rteLogFile.createNewFile();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// SingleOutputDocument rteLogDoc=
	// SingleOutputDocument.getInstance(SingleOutputDocument.RTE_LOG);
	// Node rteTestNode = rteLogDoc.setDOMElement(null,
	// SingleOutputDocument.TEST_EL);
	// rteLogDoc.setDOMAttribute(rteTestNode, SingleOutputDocument.PATH_ATT,
	// strRTERootDir);
	//		
	// rteRootDirectory = new File(strRTERootDir);
	// File[] aF = rteRootDirectory.listFiles();
	// if(aF != null) {
	// List lFiles = Arrays.asList(aF);
	// Iterator i = lFiles.iterator();
	// while( i.hasNext() ) {
	// Object o = i.next();
	// performRTETests(o, rteTestNode);
	// }
	// }
	// SingleOutputDocument.outputDocumentToFile(rteLogFile);
	// }

	/***************************************************************************
	 * GUI Robot Model Edit (RTE2)
	 * 
	 * @throws IOException
	 */
	public int robotModelEdit() throws IOException {

		if (Settings.getFlag(RME_TEST)) {

			LOGS_RME_DIR.mkdirs();
			LOGS_RME_FILE.createNewFile();

			rteRootDirectory = new File(strRMERootDir);
			File[] aF = rteRootDirectory.listFiles();
			for (File f : aF) {
				performRobotModelEditTests(f);
			}
			SingleOutputDocument.outputDocumentToFile(LOGS_RME_FILE);
			return 1;
		} else
			return 0;
	}

	/***************************************************************************
	 * Schema Import
	 * 
	 */
	public int xsd() {
		return setupXSDImport();
	}

	/***************************************************************************
	 * Code Generation
	 * 
	 */
	public int setupCodeGeneration() {
		int active = 0;
		try {

			if (!Settings.getFlag(COPY_TO_REF)) {
				if (getFlagsOr(CG_ANY))
					LOGS_CG_DIR.mkdirs();
			}

			active += setupJavaCodeGen();
			active += setupCSharpCodeGen();
			active += setupVBCodeGen();

			// setupNegativeCodeGeneration();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return active;
	}

	/***************************************************************************
	 * setup Binary Import
	 * 
	 * 
	 */
	public int setupBinaryImport() {
		int active = 0;
		try {
			if (getFlagsOr(BINARY_ANY))
				LOGS_BIN_DIR.mkdirs();
			active += setupJavaBinaryImport();
			active += setupCSharpBinaryImport();
			active += setupVBBinaryImport();
		} catch (IOException e) {
			throw new ScriptMistakeException("Cannot create log file:" + e.getStackTrace());
		}
		return active;
	}

	/**
	 * @param t
	 */
	public void timeTest(TestBase t) {
		String sTestName = t.getClass().getName();
		
		DateFormat df = DateFormat.getTimeInstance() ;
		
		Date dStart = new Date() ;
		String start =  df.format(dStart) ;
		
		System.out.println(t.testKey + "> start time: " + start);
		
		if (sTestName == TestCodeGen.class.getName()) {
			System.out.println("1");
			performCGTests((TestCodeGen) t);
		} else if (sTestName == TestBinaryImport.class.getName()) {
			System.out.println("2");
			performBinaryTests((TestBinaryImport) t);
		} else if (sTestName == TestXSDImport.class.getName()) {
			System.out.println("3");
			performXSDTests((TestXSDImport) t);
		} else if (sTestName == TestSyntaxChecker.class.getName()) {
			System.out.println("4");
			performSyntaxCheckerTests((TestSyntaxChecker) t);
		}
		System.out.println("5");
		Date dEnd = new Date() ;
		String end =  df.format( dEnd ) ;

		long duration = dEnd.getTime() - dStart.getTime() ;
		total = total + duration ;
		
		System.out.println(t.testKey + "> end time	: " + end);
		System.out.println(t.testKey + "> duration	: " + getDuration(duration)) ; 
		System.out.println(t.testKey + "> total 	: " + getDuration(total) ) ;	
	}
	
	private String getDuration(long duration) {

		long dur_seconds = Math.round(duration/1000) ;
		long dur_minutes = Math.round(dur_seconds/60) ;
		long dur_hours = Math.round(dur_minutes/60) ;
		
		return 	format(dur_hours) + ":" +  format(dur_minutes) + ":" +  format(dur_seconds) ;

	}
	private String format(long l) {
		if((l <= 9) && (l >= 0))
				return "0" + l ;
		else return String.valueOf(l) ;		
	}
 
	/***************************************************************************
	 * setup VB8 Code Generation
	 * 
	 * @throws IOException
	 */
	public int setupVBCodeGen() throws IOException {

		if (getFlagsOr(CG_VB_ANY)) {
			LOGS_CG_VB_FILE.createNewFile();

			SingleOutputDocument doc = getInstance(VB_CG_LOG);
			Node n = doc.logE(null, TEST_EL);
			doc.logA(n, PATH_ATT, strCGRootDir);

			if (getFlagsOr(CG_VB_9, CG_ALL, CG_VB_ALL)) {

				TestCodeGen vb8Keywords = new TestCodeGen(CG_VB_9, VB_9_0, SingleOutputDocument.VB_CG_LOG, n);
				timeTest(vb8Keywords);
			}
			if (getFlagsOr(CG_VB_8, CG_ALL, CG_VB_ALL, CG_VB_8_KEYWORDS)) {

				TestCodeGen vb8Keywords = new TestCodeGen(CG_VB_8_KEYWORDS, VB_8_0, SingleOutputDocument.VB_CG_LOG, n);
				timeTest(vb8Keywords);
			}
			if (getFlagsOr(CG_VB_8, CG_ALL, CG_VB_ALL, CG_VB_8_LANG_SPEC)) {

				TestCodeGen vb8LangSpec = new TestCodeGen(CG_VB_8_LANG_SPEC, VB_8_0, SingleOutputDocument.VB_CG_LOG, n);
				timeTest(vb8LangSpec);

			}
			if (getFlagsOr(CG_VB_8, CG_ALL, CG_VB_ALL, CG_VB_VBPROJ)) {

				TestCodeGen vb8proj = new TestCodeGen(CG_VB_VBPROJ, VB_8_0, SingleOutputDocument.VB_CG_LOG, n);
				timeTest(vb8proj);
			}
			SingleOutputDocument.outputDocumentToFile(LOGS_CG_VB_FILE);
			transform(LOGS_CG_VB_FILE, TestCodeGen.class);
			return 1;
		} else
			return 0;
	}

	/***************************************************************************
	 * setup Java Code Generation
	 * 
	 * @throws IOException
	 */
	public int setupJavaCodeGen() throws IOException {

		if (getFlagsOr(CG_JAVA_ANY)) {
			LOGS_CG_JAVA_FILE.createNewFile();

			SingleOutputDocument cgJavaLogDoc = getInstance(JAVA_CG_LOG);
			Node n = cgJavaLogDoc.logE(null, TEST_EL);
			cgJavaLogDoc.logA(n, PATH_ATT, strCGRootDir);
			
			//TODO CG_JAVA_8 tests
			
			if (getFlagsOr(CG_JAVA_7, CG_ALL, CG_JAVA_ALL)){
				
				TestCodeGen java7 = new TestCodeGen(CG_JAVA_7, JV_7_0, JAVA_CG_LOG, n);
				timeTest(java7);
				
			}
			
			if (getFlagsOr(CG_JAVA_8, CG_ALL, CG_JAVA_ALL)){
				
				TestCodeGen java8 = new TestCodeGen(CG_JAVA_8, JV_8_0, JAVA_CG_LOG, n);
				timeTest(java8);
				
			}

			if (getFlagsOr(CG_JAVA_5, CG_ALL, CG_JAVA_ALL)) {

				TestCodeGen java5 = new TestCodeGen(CG_JAVA_5, JV_5_0, JAVA_CG_LOG, n);
				timeTest(java5);

			}
			if (getFlagsOr(CG_JAVA_1_4, CG_ALL, CG_JAVA_ALL)) {

				TestCodeGen jdir = new TestCodeGen(CG_JAVA_1_4, JV_1_4, JAVA_CG_LOG, n);
				timeTest(jdir);
			}

			if (getFlagsOr(CG_JAVA_ECLIPSE, CG_ALL, CG_JAVA_ALL)) {

				TestCodeGen eclipse = new TestCodeGen(CG_JAVA_ECLIPSE, JV_5_0, JAVA_CG_LOG, n);
				timeTest(eclipse);
			}

			if (getFlagsOr(CG_JAVA_NETBEANS, CG_ALL, CG_JAVA_ALL)) {

				TestCodeGen netbeans = new TestCodeGen(CG_JAVA_NETBEANS, JV_5_0, JAVA_CG_LOG, n);
				timeTest(netbeans);
			}
			
			if (getFlagsOr(CG_JAVA_JBUILDER, CG_ALL, CG_JAVA_ALL)) {

				TestCodeGen jbuilder = new TestCodeGen(CG_JAVA_JBUILDER, JV_5_0, JAVA_CG_LOG, n);
				timeTest(jbuilder);
			}
			SingleOutputDocument.outputDocumentToFile(LOGS_CG_JAVA_FILE);
			transform(LOGS_CG_JAVA_FILE, TestCodeGen.class);
			return 1;
		} else
			return 0;

	}

	/***************************************************************************
	 * setup C# code generation
	 * 
	 * @throws IOException
	 */
	public int setupCSharpCodeGen() throws IOException {

		if (getFlagsOr(CG_CS_ANY)) {
			LOGS_CG_CS_FILE.createNewFile();

			SingleOutputDocument doc = getInstance(CSHARP_CG_LOG);
			Node n = doc.logE(null, TEST_EL);
			doc.logA(n, PATH_ATT, strCGRootDir);

			if (getFlagsOr(CG_CS_2_0, CG_ALL, CG_CS_ALL)) {

				TestCodeGen csdir = new TestCodeGen(CG_CS_2_0, CS_2_0, CSHARP_CG_LOG, n);
				timeTest(csdir);
			}

			if (getFlagsOr(CG_CS_3_0, CG_ALL, CG_CS_ALL)) {

				TestCodeGen csdir = new TestCodeGen(CG_CS_3_0, CS_3_0, CSHARP_CG_LOG, n);
				timeTest(csdir);
			}
			
			if (getFlagsOr(CG_CS_4_0, CG_ALL, CG_CS_ALL)) {

				TestCodeGen bdsproj = new TestCodeGen(CG_CS_4_0, CS_4_0, CSHARP_CG_LOG, n);
				timeTest(bdsproj);
			}

			if (getFlagsOr(CG_CS_PROJ, CG_ALL, CG_CS_ALL)) {

				TestCodeGen csproj = new TestCodeGen(CG_CS_PROJ, CS_2_0, CSHARP_CG_LOG, n);
				timeTest(csproj);
			}

			if (getFlagsOr(CG_CS_D_PROJ, CG_ALL, CG_CS_ALL)) {

				TestCodeGen csdroj = new TestCodeGen(CG_CS_D_PROJ, CS_2_0, CSHARP_CG_LOG, n);
				timeTest(csdroj);
			}

			if (getFlagsOr(CG_CS_SLN, CG_ALL, CG_CS_ALL)) {

				TestCodeGen cssln = new TestCodeGen(CG_CS_SLN, CS_2_0, CSHARP_CG_LOG, n);
				timeTest(cssln);
			}

			if (getFlagsOr(CG_CS_BDS_PROJ, CG_ALL, CG_CS_ALL)) {

				TestCodeGen bdsproj = new TestCodeGen(CG_CS_BDS_PROJ, CS_2_0, CSHARP_CG_LOG, n);
				timeTest(bdsproj);
			}
			
			SingleOutputDocument.outputDocumentToFile(LOGS_CG_CS_FILE);
			transform(LOGS_CG_CS_FILE, TestCodeGen.class);
			return 1;
		} else
			return 0;
	}

	/***************************************************************************
	 * setup XMI Unit-Tests
	 * 
	 * @throws IOException
	 */
	public int setupXMI() throws IOException {

		if (getFlagsOr(XMI_ANY)) {
			LOGS_XMI_DIR.mkdirs();
			LOGS_XMI_FILE.createNewFile();

			SingleOutputDocument xmiLogDoc = getInstance(XMI_LOG);
			Node xmiTest = xmiLogDoc.logE(null, TEST_EL);
			xmiLogDoc.logA(xmiTest, PATH_ATT, strXMIRootDir);

			if (getFlagsOr(UML_20, XMI_ALL)) {

				xmiRootDirectory = new File(strXMIRootDir, "uml20");
				TestXMI t20 = new TestXMI(UML_20, xmiRootDirectory);
				performXMITests(t20);
			}

			if (getFlagsOr(UML_21, XMI_ALL)) {

				xmiRootDirectory = new File(strXMIRootDir, "uml21");
				TestXMI t21 = new TestXMI(UML_21, xmiRootDirectory);
				performXMITests(t21);
			}
			if (getFlagsOr(UML_22, XMI_ALL)) {

				xmiRootDirectory = new File(strXMIRootDir, "uml22");
				TestXMI t22 = new TestXMI(UML_22, xmiRootDirectory);
				performXMITests(t22);
			}
			
			if (getFlagsOr(UML_23, XMI_ALL)){

				xmiRootDirectory = new File(strXMIRootDir, "uml23");
				TestXMI t23 = new TestXMI(UML_23, xmiRootDirectory);
				performXMITests(t23);
				
				
			}
			
			
			SingleOutputDocument.outputDocumentToFile(LOGS_XMI_FILE);
			transform(LOGS_XMI_FILE, TestXMI.class);
			return 1;
		} else
			return 0;
	}

	/***************************************************************************
	 * setup Merge Unit-Tests
	 * 
	 * @throws IOException
	 */
	public int setupMerge() throws IOException {

		if (getFlagsOr(MERGE_TEST)) {
			LOGS_MERGE_DIR.mkdirs();
			LOGS_MERGE_FILE.createNewFile();

			SingleOutputDocument mergeLogDoc = getInstance(MERGE_LOG);
			Node mergeTest = mergeLogDoc.logE(null, TEST_EL);
			mergeLogDoc.logA(mergeTest, PATH_ATT, strMergeRootDir);

			TestMerge t21 = new TestMerge(MERGE_TEST);
			performMergeTests(t21);

			SingleOutputDocument.outputDocumentToFile(LOGS_MERGE_FILE);
			transform(LOGS_MERGE_FILE, TestMerge.class);
			return 1;
		} else
			return 0;
	}

	/***************************************************************************
	 * setup Java Binary Import
	 * 
	 * @throws IOException
	 */
	public int setupJavaBinaryImport() throws IOException {

		if (getFlagsOr(BIN_JAVA_ANY)) {
			LOGS_BIN_JAVA_FILE.createNewFile();

			SingleOutputDocument binJavaLogDoc = getInstance(JAVA_BINARY_LOG);
			Node n = binJavaLogDoc.logE(null, TEST_EL);
			binJavaLogDoc.logA(n, PATH_ATT, strBINRootDir);

			if (getFlagsOr(BINARY_JAVA_5, BINARY_ALL, BINARY_JAVA_ALL)) {

				TestBinaryImport j5 = new TestBinaryImport(BINARY_JAVA_5, JV_5_0, JAVA_BINARY_LOG, n);
				timeTest(j5);
			}
			if (getFlagsOr(BINARY_JAVA_5_JAR, BINARY_ALL, BINARY_JAVA_ALL)) {

				TestBinaryImport jar = new TestBinaryImport(BINARY_JAVA_5_JAR, JV_5_0, JAVA_BINARY_LOG, n);
				timeTest(jar);
			}
			if (getFlagsOr(BINARY_JAVA_5_CLASSPATH, BINARY_ALL, BINARY_JAVA_ALL)) {
			}
			if (getFlagsOr(BINARY_JAVA_5_RUNTIME, BINARY_ALL, BINARY_JAVA_ALL)) {
			}
			//java 8
			if (getFlagsOr(BINARY_JAVA_8, BINARY_ALL, BINARY_JAVA_ALL)) {

				TestBinaryImport j8 = new TestBinaryImport(BINARY_JAVA_8, JV_8_0, JAVA_BINARY_LOG, n);
				timeTest(j8);
			}
			if (getFlagsOr(BINARY_JAVA_8_JAR, BINARY_ALL, BINARY_JAVA_ALL)) {

				TestBinaryImport jar = new TestBinaryImport(BINARY_JAVA_8_JAR, JV_8_0, JAVA_BINARY_LOG, n);
				timeTest(jar);
			}
			if (getFlagsOr(BINARY_JAVA_8_CLASSPATH, BINARY_ALL, BINARY_JAVA_ALL)) {
			}
			if (getFlagsOr(BINARY_JAVA_8_RUNTIME, BINARY_ALL, BINARY_JAVA_ALL)) {
			}
			//java 7
			if (getFlagsOr(BINARY_JAVA_7, BINARY_ALL, BINARY_JAVA_ALL)) {

				TestBinaryImport j7 = new TestBinaryImport(BINARY_JAVA_7, JV_7_0, JAVA_BINARY_LOG, n);
				timeTest(j7);
			}
			if (getFlagsOr(BINARY_JAVA_7_JAR, BINARY_ALL, BINARY_JAVA_ALL)) {

				TestBinaryImport jar = new TestBinaryImport(BINARY_JAVA_7_JAR, JV_7_0, JAVA_BINARY_LOG, n);
				timeTest(jar);
			}
			if (getFlagsOr(BINARY_JAVA_7_CLASSPATH, BINARY_ALL, BINARY_JAVA_ALL)) {
			}
			if (getFlagsOr(BINARY_JAVA_7_RUNTIME, BINARY_ALL, BINARY_JAVA_ALL)) {
			}

			outputDocumentToFile(LOGS_BIN_JAVA_FILE);
			transform(LOGS_BIN_JAVA_FILE, TestBinaryImport.class);
			return 1;
		} else
			return 0;
	}

	/***************************************************************************
	 * setup C# Binary Import
	 * 
	 * @throws IOException
	 */
	public int setupCSharpBinaryImport() throws IOException {

		if (getFlagsOr(BIN_CS_ANY)) {
			LOGS_BIN_CS_FILE.createNewFile();

			SingleOutputDocument doc = getInstance(CSHARP_BINARY_LOG);
			Node n = doc.logE(null, TEST_EL);
			doc.logA(n, PATH_ATT, strCGRootDir);

			if (getFlagsOr(BINARY_CS_2_0, BINARY_ALL, BINARY_CS_ALL)) {

				TestBinaryImport csdir = new TestBinaryImport(BINARY_CS_2_0, CS_2_0, CSHARP_BINARY_LOG, n);
				timeTest(csdir);
			}

			if (getFlagsOr(BINARY_CS_3_0, BINARY_ALL, BINARY_CS_ALL)) {

				TestBinaryImport csdir = new TestBinaryImport(BINARY_CS_3_0, CS_3_0, CSHARP_BINARY_LOG, n);
				timeTest(csdir);
			}
			
			if (getFlagsOr(BINARY_CS_4_0, BINARY_ALL, BINARY_CS_ALL)) {

				TestBinaryImport csdir = new TestBinaryImport(BINARY_CS_4_0, CS_4_0, CSHARP_BINARY_LOG, n);
				timeTest(csdir);
			}
			
			if (getFlagsOr(BINARY_CS_GAC, BINARY_ALL, BINARY_CS_ALL)) {

				TestBinaryImport gac = new TestBinaryImport(BINARY_CS_GAC, CS_2_0, CSHARP_BINARY_LOG, n);
				timeTest(gac);
			}

			if (getFlagsOr(BINARY_CS_MSVS, BINARY_ALL, BINARY_CS_ALL)) {

				TestBinaryImport msvs = new TestBinaryImport(BINARY_CS_MSVS, CS_2_0, CSHARP_BINARY_LOG, n);
				timeTest(msvs);
			}
			SingleOutputDocument.outputDocumentToFile(LOGS_BIN_CS_FILE);
			transform(LOGS_BIN_CS_FILE, TestBinaryImport.class);
			return 1;
		} else
			return 0;
	}

	/***************************************************************************
	 * setup Visual Basic Binary Import
	 * 
	 * @throws IOException
	 */
	public int setupVBBinaryImport() throws IOException {

		if (getFlagsOr(BIN_VB_ANY)) {
			LOGS_BIN_VB_FILE.createNewFile();

			SingleOutputDocument binVbLogDoc = getInstance(VB_BINARY_LOG);
			Node n = binVbLogDoc.logE(null, TEST_EL);
			binVbLogDoc.logA(n, PATH_ATT, strBINRootDir);

			if (getFlagsOr(BINARY_VB_71, BINARY_ALL, BINARY_VB_ALL)) {

				TestBinaryImport jar = new TestBinaryImport(BINARY_VB_71, VB_7_1, VB_BINARY_LOG, n);
				timeTest(jar);
			}
			if (getFlagsOr(BINARY_VB_8, BINARY_ALL, BINARY_VB_ALL,BINARY_VB_8_KEYWORDS)) {

				TestBinaryImport j5 = new TestBinaryImport(BINARY_VB_8_KEYWORDS, VB_8_0, SingleOutputDocument.VB_BINARY_LOG, n);
				timeTest(j5);
			}
			if (getFlagsOr(BINARY_VB_8, BINARY_ALL, BINARY_VB_ALL,BINARY_VB_8_LANG_SPEC)) {

				TestBinaryImport j5 = new TestBinaryImport(BINARY_VB_8_LANG_SPEC, VB_8_0, SingleOutputDocument.VB_BINARY_LOG, n);
				timeTest(j5);
			}			
			if (getFlagsOr(BINARY_VB_9, BINARY_ALL, BINARY_VB_ALL)) {

				TestBinaryImport jar = new TestBinaryImport(BINARY_VB_9, VB_9_0, VB_BINARY_LOG, n);
				timeTest(jar);
			}
			if (getFlagsOr(BINARY_VB_GAC, BINARY_ALL, BINARY_VB_ALL)) {
			}
			if (getFlagsOr(BINARY_VB_MSVS, BINARY_ALL, BINARY_VB_ALL)) {
			}

			outputDocumentToFile(LOGS_BIN_VB_FILE);
			transform(LOGS_BIN_VB_FILE, TestBinaryImport.class);
			return 1;
		} else
			return 0;
	}

	/***************************************************************************
	 * steup Schema Import
	 * 
	 * 
	 */
	public int setupXSDImport() {

		if (getFlagsOr(XSD_ALL, XSD_TEST, XSD_DIR_TEST, XSD_TEST_INVALID)) {
			if (!Settings.getFlag(COPY_TO_REF)) {
				try {
					LOGS_XSD_DIR.mkdirs();
					LOGS_XSD_FILE.createNewFile();
				} catch (Exception e) {
						e.printStackTrace();
				}
			}

			SingleOutputDocument doc = getInstance(XSD_LOG);
			Node n = doc.logE(null, TEST_EL);
			doc.logA(n, PATH_ATT, strXSDRootDir);

			if (getFlagsOr(XSD_TEST, XSD_ALL)) {
				TestXSDImport xsd = new TestXSDImport(XSD_TEST, XSD_LOG, n);
				timeTest(xsd);
			}
			if (getFlagsOr(XSD_DIR_TEST, XSD_ALL)) {
				TestXSDImport xsd = new TestXSDImport(XSD_DIR_TEST, XSD_LOG, n);
				timeTest(xsd);
			}
			if (getFlagsOr(XSD_TEST_INVALID, XSD_ALL)) {
				TestXSDImport xsd = new TestXSDImport(XSD_TEST_INVALID, XSD_LOG, n);
				timeTest(xsd);
			}			SingleOutputDocument.outputDocumentToFile(LOGS_XSD_FILE);
			transform(LOGS_XSD_FILE, TestXSDImport.class);
			return 1;
		} else
			return 0;
	}

	/***************************************************************************
	 * setup Negative code generation
	 * 
	 * @throws IOException
	 */
	// public void setupNegativeCodeGeneration() throws IOException {
	//	
	// if(getFlagsOr(CG_NEG_ANY)) {
	//			
	// LOGS_CG_NEG_FILE.createNewFile() ;
	//			
	// SingleOutputDocument ncgLogDoc= getInstance(NCG_LOG);
	// Node n = ncgLogDoc.logElement(null, TEST_EL);
	// ncgLogDoc.logAttribute(n, PATH_ATT, strNCGRootDir);
	//			
	// ncgResourceDirectory = new File(strNCGRootDir + "//rc");
	// ncgRootDirectory = new File(strNCGRootDir);
	//			
	// File[] aF = ncgResourceDirectory.listFiles();
	// if(aF != null) {
	// List lFiles = Arrays.asList(aF);
	// Iterator i = lFiles.iterator();
	// while( i.hasNext() ) {
	// Object o = i.next();
	// performNCGTests((File)o);
	// }
	// }
	// SingleOutputDocument.outputDocumentToFile(LOGS_CG_NEG_FILE);
	// transform(LOGS_CG_NEG_FILE, TestSyntaxChecker.class);
	// }
	// }
	public boolean checkEnvironment() {

		return getDependencies();

	}

	private boolean getDependencies() {
		Map <String, String> map = new HashMap <String, String> ();
		
		map.put("UModelBatch.exe", Settings.getUModelBatchExe()) ;
		map.put("DiffDogBatch.exe", Settings.getDiffDogBatchExe()) ;

		if (Settings.getAltovaXMLLocation() == null) {
			System.out.println("missing dependancy : AltovaXML" ) ;
			return false ;
		} else {
			File AltovaXMLJar= new File ( Settings.getAltovaXMLLocation(), "AltovaXML.jar" ) ;
			System.out.println("AltovaXMLJar: "+ AltovaXMLJar.getAbsolutePath() );
			map.put("AltovaXML.jar", AltovaXMLJar.getAbsolutePath());
		}
		
		if (Settings.getAltovaXMLLocation() == null){
			System.out.println("missing dependancy : XMLSpy" ) ;
			return false ;
		} else {
			File XMLSpyJar = new File ( Settings.getXMLSpyLocation(), "XMLSpyInterface.jar" ) ;
			map.put("XMLSpyInterface.jar", XMLSpyJar.getAbsolutePath());
		}

		map.put("other", getDepLocation().getAbsolutePath()) ;
		
		Iterator<String> mapIter = map.keySet().iterator() ;
		while(mapIter.hasNext()) {
			String k = mapIter.next() ;
			String v = map.get(k) ;
			if( !(new File (v).exists()) ) {
				System.out.println("missing dependancy : " + k) ;
				return false ;
			}
			else System.out.println("resolving c : " + k + " : " + v) ;
		}
		return true ;
	}

	public int setupSyntaxCheck() throws IOException {
		if (getFlagsOr(SYNTAX_TEST)) {
			LOGS_SYN_DIR.mkdirs();
			LOGS_SYNTAX_CHECK_FILE.createNewFile();

			SingleOutputDocument doc = getInstance(SYN_LOG);
			Node n = doc.logE(null, TEST_EL);
			doc.logA(n, PATH_ATT, strSyntaxRootDir);

			TestSyntaxChecker syn = new TestSyntaxChecker(SYNTAX_TEST, SYN_LOG, n);
			timeTest(syn);

			SingleOutputDocument.outputDocumentToFile(LOGS_SYNTAX_CHECK_FILE);
			transform(LOGS_SYNTAX_CHECK_FILE, TestSyntaxChecker.class);
			return 1;
		} else
			return 0;
	}

	private void performSyntaxCheckerTests(TestSyntaxChecker t) {
		System.out.println("starting syntax checker regression tests..." + getCurrentTime());

		RegexFileFilter ump = new RegexFileFilter(".*ump");
		List<File> umpFiles = FileFilterUtils.listfiles(t.getSourceDir(), ump, true);

		RegexFileFilter txt = new RegexFileFilter(".*txt");
		List<File> txtFiles = FileFilterUtils.listfiles(t.getSourceDir(), txt, true);

		for (File f : umpFiles) {
			
			if (Settings.getFlag(DEBUG_MODE)) System.out.println("************************************* test :" + f.getAbsolutePath());
			
			String name = f.getName().replaceFirst(".ump", ".txt");
			File txtRefFile = new File(f.getAbsolutePath().replace(f.getName(), name));
			if (txtFiles.contains(txtRefFile)) {

				t.setupTest(f, txtRefFile);
				if (Settings.getFlag(UPDATE_REF_UMP)) {
					try {
						t.updateSrcUmp(f);
					}catch (DoNotContinueException e) {
						System.err.println(e.getMessage());
						if (e.getType() == DoNotContinueException.FILE_NOT_FOUND)
							break;
						else
							continue;
						}
					}
				else {
					try {
						t.checkSyntax();
						t.compareSyntaxOutput();
					} catch (DoNotContinueException e) {
						System.err.println(e.getMessage());
							if (e.getType() == DoNotContinueException.EXE_NOT_FOUND)
								break;
							else
								continue;
						}
				}
			}
		}
		System.out.println("xmi regression tests finished...");
	}

	/***************************************************************************
	 * perform XMI
	 * 
	 * @param suiteNode
	 */
	private void performXMITests(TestXMI t) {
		System.out.println("starting xmi regression tests..." + getCurrentTime());

		RegexFileFilter ump = new RegexFileFilter(".*ump");
		List<File> files = FileFilterUtils.listfiles(xmiRootDirectory, ump, true);

		for (File f : files) {
			
			if (Settings.getFlag(DEBUG_MODE)) System.out.println("************************************* test :" + f.getAbsolutePath());
			
			t.setupTest(f);
			try {
				if (Settings.getFlag(UPDATE_REF_UMP)) {
					t.updateXmiUmp();
				}
				else 
					if (Settings.getFlag(COPY_TO_REF)) {
						t.copyXmiToRefDir(f);
					}
				else {
					t.xmiGeneration();
					//Removing following 2 steps because the schema always needs to be updated
					//to reflect changes made in our models
					//t.xmiTransformation();
					//t.xmlValidation();
					t.xmiImport();
					t.umpTransformation();
					t.xmlDiff();
					t.xmiTransDiff();				
				}
			} catch (DoNotContinueException e) {
				System.err.println(e.getMessage());
				if (e.getType() == DoNotContinueException.EXE_NOT_FOUND)
					break;
				else
					continue;
			}
		}
		System.out.println("xmi regression tests finished...");
	}
	/***************************************************************************
	 * perform Merge
	 * 
	 * Execute the test cases that test the merging of projects
	 */
	private void performMergeTests(TestMerge t) {
		System.out.println("starting merge regression tests..." + getCurrentTime());

		File f = null;
		File s = null;
		
		mergeTargetDirectory = new File(t.getSourceDir(), MERGE_TARGET);
		mergeSrcDirectory = new File (t.getSourceDir(),MERGE_SRC);
		RegexFileFilter ump = new RegexFileFilter(".*ump");
		List<File> source = FileFilterUtils.listfiles(mergeSrcDirectory, ump, true);
		List<File> target = FileFilterUtils.listfiles(mergeTargetDirectory, ump, true);
		Iterator<File> src = source.iterator(); 
		for (Iterator<File> tgt=target.iterator(); tgt.hasNext();) {
			f = tgt.next();
			s = src.next();
			if (Settings.getFlag(DEBUG_MODE)) System.out.println("************************************* test :" + f.getAbsolutePath());
			
			t.setupTest(f);
			try {
				if (Settings.getFlag(COPY_TO_REF)) {
					t.copyUmpToRefDir();
				}
				else 
				if (Settings.getFlag(UPDATE_REF_UMP)) {
					t.updateRefUmp();
				}
				else {
					t.mergeProjects(s);
					t.umpDiff();	
				}
			} catch (DoNotContinueException e) {
				System.err.println(e.getMessage());
				if (e.getType() == DoNotContinueException.EXE_NOT_FOUND)
					break;
				else
					continue;
			}
		}
		System.out.println("merge regression tests finished...");
	}
	/***************************************************************************
	 * perform code generation steps
	 * 
	 * @param t
	 * @param suiteNode
	 * @param log
	 */
	private void performCGTests(TestCodeGen t) {
		boolean status;
		List<File> files = Common.filterCVS(t.getSourceDir());
		for (File f : files) {

			if (Settings.getFlag(DEBUG_MODE)) System.out.println("************************************* testCG :" + f.getAbsolutePath());
			
			if (Common.filterFilesCVS(f, false).size() > 0) {
				// ideally this should be a whole/part association,
				// but im actually changing the object for every test case. :(
				t.setupTest(f);
				if (Settings.getFlag(COPY_TO_REF)) {
					try {
						status = t.copyUmpToRefDir();
					}catch (DoNotContinueException e) {
						System.err.println(e.getMessage());
						if (e.getType() == DoNotContinueException.EXE_NOT_FOUND)
							break;
						else
							continue;
						}
					}
				else 
					if (Settings.getFlag(UPDATE_REF_UMP)) {
					try {
						status = t.updateRefUmp();
					}catch (DoNotContinueException e) {
						System.err.println(e.getMessage());
						if (e.getType() == DoNotContinueException.FILE_NOT_FOUND)
							break;
						else
							continue;
						}
					}
				else {
					try {

						status = t.importSourceCode();
						if (status)
							status = t.generateCode();
						// if(status) status = t.compareCode();
						if (status)
							status = t.importGeneratedCode();
						if (status)
							status = t.umpDiffTests();

					} catch (DoNotContinueException e) {
						System.err.println(e.getMessage());
						if (e.getType() == DoNotContinueException.EXE_NOT_FOUND)
							break;
						else
							continue;

					}
				}
			}
		}
	}

	/***************************************************************************
	 * perform binary
	 * 
	 * @param t
	 * @param suiteNode
	 * @param log
	 */
	private void performBinaryTests(TestBinaryImport t) {


		boolean status;
		List<File> files = Common.filterCVS(t.getSourceDir());
		
		for (File f : files) {
			//if the length = 1, then the dir contains only a CVS folder, so skip it, its not valid...
			// if((f != null) && (f.listFiles().length > 1)) {
			if (Common.filterFilesCVS(f, false).size() > 0) {
				
				t.setupTest(f);
	
				if (Settings.getFlag(DEBUG_MODE)) System.out.println("************************************* test1 :" + f.getAbsolutePath());
				if (Settings.getFlag(COPY_TO_REF)) {
					try {
						status = t.copyUmpToRefDir();
					}catch (DoNotContinueException e) {
						System.err.println(e.getMessage());
						if (e.getType() == DoNotContinueException.EXE_NOT_FOUND)
							break;
						else
							continue;
						}
					}
				else if (Settings.getFlag(CREATE_DLL)) {
					try {
						status = t.createDll();
					}catch (DoNotContinueException e) {
						System.err.println(e.getMessage());
						if (e.getType() == DoNotContinueException.EXE_NOT_FOUND)
							break;
						else
							continue;
						}
					}
				else if (Settings.getFlag(CREATE_EXE)) {
					try {
						status = t.createExe();
					}catch (DoNotContinueException e) {
						System.err.println(e.getMessage());
						if (e.getType() == DoNotContinueException.EXE_NOT_FOUND)
							break;
						else
							continue;
						}
					}
					else 
					if (Settings.getFlag(UPDATE_REF_UMP)) {
					try {
						status = t.updateRefUmp();
					}catch (DoNotContinueException e) {
						System.err.println(e.getMessage());
						if (e.getType() == DoNotContinueException.FILE_NOT_FOUND)
							break;
						else
							continue;
						}
					}else{				
					// t.importSource( stepsNode );
					try {
						int stat = t.importBinary();
						if (stat == 0) 
							t.umpDiffTests();
	
					} catch (DoNotContinueException e) {
						System.err.println(e.getMessage());
						if (e.getType() == DoNotContinueException.EXE_NOT_FOUND)
							break;
						else
							continue;
					}	
				}
			}
		}
	}

	/***************************************************************************
	 * perform xsd
	 * 
	 * @param t
	 * @param suiteNode
	 * @param log
	 */
	private void performXSDTests(TestXSDImport t) {

		// DirectoryFileFilter dirs = new DirectoryFileFilter() ;
		// FilterAdapter fd2 = new FilterAdapter(new
		// RegexFilenameFilter("CVS"));
		// NegateFileFilter notcvs = new NegateFileFilter(fd2);
		// ExcludeListFileFilter elff = new ExcludeListFileFilter(instructions)
		// ;
		// AndFileFilter and = new AndFileFilter(dirs, elff, notcvs);
		// List<File> singleXSD = FileFilterUtils.listfiles(t.getSourceDir(),
		// and, true);

		if (t.getTestKey().equals(XSD_TEST)) {
			performPositiveXSDTests(t);
		} else if (t.getTestKey().equals(XSD_DIR_TEST)) {
			performDirXSDTests(t);
		} else if (t.getTestKey().equals(XSD_TEST_INVALID)) {
			performNegativeXSDTests(t);
		}
	}

	private void performPositiveXSDTests(TestXSDImport t) {

		List<File> xsdToImport = new ArrayList<File>();

		FilterAdapter fd2 = new FilterAdapter(new RegexFilenameFilter("CVS"));
		NegateFileFilter notcvs = new NegateFileFilter(fd2);

		FilterAdapter inst = new FilterAdapter(new RegexFilenameFilter(INSTRUCTIONS.getName()));
		List<File> instructions = FileFilterUtils.listfiles(t.getSourceDir(), inst, true);
		ExtensionFileFilter xsd = new ExtensionFileFilter("xsd");
		xsd.setIncludeDirectories(false);
		DirectoryContentFileFilter dir = new DirectoryContentFileFilter(xsd, 1);
		ParentDirectoryFileFilter parent = new ParentDirectoryFileFilter(dir);
		AndFileFilter filter = new AndFileFilter(xsd, parent, notcvs);
		List<File> singleXSD = FileFilterUtils.listfiles(t.getSourceDir(), filter, true);
		boolean status ;
		try {
			xsdToImport = new ArrayList<File>();
			xsdToImport.addAll(singleXSD);
			xsdToImport.addAll(findEnclosingXSD(instructions));
		} catch (IOException e) {
			throw new ScriptMistakeException("file error:" + e.getStackTrace());
		}

		Collections.sort(xsdToImport);

		for (File f : xsdToImport) {
			
			if (Settings.getFlag(DEBUG_MODE)) System.out.println("********************************** test :" + f.getAbsolutePath());
			
			try {
				t.setupTest(f);
				if (Settings.getFlag(COPY_TO_REF)) {
						status = t.copyUmpToRefDir();
				}
				else if (Settings.getFlag(UPDATE_REF_UMP)) {
					try {
						status = t.updateRefUmp();
					}catch (DoNotContinueException e) {
						System.err.println(e.getMessage());
						if (e.getType() == DoNotContinueException.FILE_NOT_FOUND)
							break;
						else
							continue;
						}
					}			
				else {	
					t.importXSD();
					t.exportXSD();
					t.importExportedXSD();
					t.compareUMPs();
				}
			} catch (DoNotContinueException e) {
				System.err.println(e.getMessage());
				if (e.getType() == DoNotContinueException.EXE_NOT_FOUND)
					break;
				else
					continue;
			}
		}
	}
	private void performDirXSDTests(TestXSDImport t) {

		boolean status ;
		List<File> files = Common.filterCVS(t.getSourceDir());
		for (File f : files) {
			
			if (Settings.getFlag(DEBUG_MODE)) System.out.println("********************************** test :" + f.getAbsolutePath());
			
			try {
				t.setupTest(f);
				if (Settings.getFlag(COPY_TO_REF)) {
					status = t.copyUmpToRefDir();
				}
				else if (Settings.getFlag(UPDATE_REF_UMP)) {
					try {
						status = t.updateRefUmp();
					}catch (DoNotContinueException e) {
						System.err.println(e.getMessage());
						if (e.getType() == DoNotContinueException.FILE_NOT_FOUND)
							break;
						else
							continue;
						}
					}			
				else {
					t.importXSD();
					t.exportXSD();
					t.importExportedXSD();
					t.compareUMPs();
				}
			} catch (DoNotContinueException e) {
				System.err.println(e.getMessage());
				if (e.getType() == DoNotContinueException.EXE_NOT_FOUND)
					break;
				else
					continue;
			}
		}
	}

	
	private void performNegativeXSDTests(TestXSDImport t) {
		List<File> xsdToImport = new ArrayList<File>();

		FilterAdapter fd2 = new FilterAdapter(new RegexFilenameFilter("CVS"));
		NegateFileFilter notcvs = new NegateFileFilter(fd2);

		ExtensionFileFilter xsd = new ExtensionFileFilter("xsd");
		AndFileFilter filter = new AndFileFilter(xsd, notcvs);
		xsdToImport = FileFilterUtils.listfiles(t.getSourceDir(), filter, true);

		Collections.sort(xsdToImport);

		for (File f : xsdToImport) {
			
			if (Settings.getFlag(DEBUG_MODE)) System.out.println("************************************* test :" + f.getAbsolutePath());
			
			if (f.isFile()) {
				try {
					File d = f.getParentFile();
					t.setupNegativeTest(d, f);
					t.importXSD();
					t.compareOutput();
					t.cleanup();
				} catch (DoNotContinueException e) {
					System.err.println(e.getMessage());
					if (e.getType() == DoNotContinueException.EXE_NOT_FOUND)
						break;
					else
						continue;
				} catch (IOException e) {
					System.err.println(e.getMessage());
					continue;
				}
			}
		}
	}

	// take Enclosing Filename from Instructions.txt and add to testcases
	private List<File> findEnclosingXSD(List<File> instructions) throws IOException {
		List<File> list = new ArrayList<File>();
		String line;

		for (File f : instructions) {
			File p = f.getParentFile();
			BufferedReader input = new BufferedReader(new FileReader(f));
			while ((line = input.readLine()) != null) {
				if (line.endsWith(".xsd")) {
					File out = new File(p, line);
					list.add(out);
				}
			}
		}
		return list;
	}

	/***************************************************************************
	 * perform negative code generation
	 * 
	 * @param oResourceFile
	 * @param ncgTestNode
	 */
	// private void performNCGTests(File oResourceFile) {
	// String codelang = "";
	// String testCaseDir = "";
	// String message = "";
	// TestSyntaxChecker t = null;
	// if(oResourceFile.getName().equals(Common.CSHARP_RES_NAME)) {
	// codelang = Common.CSHARP_LANG_SPEC;
	// testCaseDir = "csharp";
	// t = new TestSyntaxChecker(NCG_CS, codelang,
	// SingleOutputDocument.NCG_LOG);
	// }
	// else if (oResourceFile.getName().equals(Common.JAVA_RES_NAME)) {
	// codelang = Common.JAVA_5_0_LANG_SPEC;
	// testCaseDir = "java";
	// t = new TestSyntaxChecker(NCG_JAVA, codelang,
	// SingleOutputDocument.NCG_LOG);
	// } // tbd
	// else if (oResourceFile.getName().equals(Common.UMLCORE_RES_NAME)) {
	// codelang = Common.JAVA_5_0_LANG_SPEC;
	// testCaseDir = "umlcore";
	// t = new TestSyntaxChecker(NCG_JAVA, codelang,
	// SingleOutputDocument.NCG_LOG);
	// }
	// else if (oResourceFile.getName().equals(Common.UMLLANG_RES_NAME)) {
	// codelang = Common.JAVA_5_0_LANG_SPEC;
	// testCaseDir = "umllang";
	// t = new TestSyntaxChecker(NCG_JAVA, codelang,
	// SingleOutputDocument.NCG_LOG);
	// }
	// else if (oResourceFile.getName().equals(Common.TEST)) {
	// codelang = Common.JAVA_5_0_LANG_SPEC;
	// testCaseDir = "umllang";
	// t = new TestSyntaxChecker(NCG_JAVA, codelang,
	// SingleOutputDocument.NCG_LOG);
	// }
	// t.setupResourceDir( oResourceFile );
	// Map m = t.collectKeys(oResourceFile, codelang);
	//
	// Iterator i = m.keySet().iterator();
	// while(i.hasNext()) {
	// message = "";
	// String key = (String) i.next();
	// // k is the keyname of the testfile contained in the
	// // direstory ncg/test-cases/java or csharp or umllang or umlcore or test
	// File f = new File(ncgRootDirectory + "//" + testCaseDir + "//" + key);
	// t.setupTest(f);
	// String value = (String) m.get(key);
	// try {
	// message = t.importCode();
	// t.searchUModelMessageForRCString(value, message);
	// message = t.generateCode();
	// t.searchUModelMessageForRCString(value, message);
	// } catch (DoNotContinueException e) {
	// System.err.println(e.getMessage());
	// if(e.getType() == DoNotContinueException.EXE_NOT_FOUND) break;
	// else continue;
	// }
	// }
	// }
	/** ******************************************** */
	/** ******** perform robot ******************** */
	/** ******************************************** */
	private void performRobotModelEditTests(File test_level) {
		System.out.println("starting robot model edit regression tests...");

		SingleOutputDocument doc = getInstance(ROBOT_MODEL_EDIT_LOG);
		Node n = doc.logE(null, TEST_EL);
		doc.logA(n, PATH_ATT, strBINRootDir);

		int status;
		if (test_level != null && ((File) test_level).isDirectory() && ((File) test_level).exists() && (!((File) test_level).getName().equals("CVS"))) {
			try {

				TestGUIModelEdit t = new TestGUIModelEdit(test_level, JV_5_0, n);

				status = t.importSourceCode();
				if (status != 0)
					return;

				File[] ref_test_cases = t.getRefDir().listFiles();

				for (File f : ref_test_cases) {
					if (!f.getAbsolutePath().contains("CVS")) {
						t.setupTest(f);
						t.useGUIHandler();
						// if( t.updateSourceCode() != 0) continue;
						// code has been updated by UModel GUI Handler
						if (t.importUpdatedSourceCode() != 0)
							continue;
						if (t.umpDiffTest() != 0)
							continue;
						// TODO - import ref? code comparison between ref and
						// updated?
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
