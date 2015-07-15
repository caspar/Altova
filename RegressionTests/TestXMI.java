package com.altova.umodel.regression.functional;
import static com.altova.umodel.regression.functional.SingleOutputDocument.*;
import static com.altova.umodel.regression.functional.UModelTestTypes.*;
import static com.altova.util.Settings.*;
import static com.altova.Depend.*;

import java.io.*;
import org.w3c.dom.Node;

import com.altova.Depend.DependancyApplication;
import com.altova.engines.*;

class TestXMI extends TestBase
{
	public String type;
	private static File rootDirectory = null;
	static IAltovaXMLFactory objXmlApp ;

	
//	public static final int UML20 = 0;
//	public static final int UML21 = 1;
//	static String version = null;
	static final String NO_ERRORS_STRING = "0 error";
	static final String NO_WARNING_STRING = "0 warning";
	
	String stepExtension = null;	//this changes according to step & version
	File testFile = null;
	String tfName = null;
//	File testLogDir = null;
	
	// constructor
	public TestXMI(String key, File rootDir) {
		setTestKey(key);
//		setSuite(testSuite);
		setRootDir(rootDir);
		sod = Common.getSingleOutputDocument(SingleOutputDocument.XMI_LOG);
		
		projectNode = sod.logE(null, SUITE_EL);
		sod.logA(projectNode, UML_VERSION, testKey);  //testKey or version?
		
		if (objXmlApp == null) {		
			try { 
				objXmlApp = Common.getAltovaInstance() ;
			}
			catch (IllegalAccessException e) { e.printStackTrace();	}
		}
	}
	// constructor
	public TestXMI(String importType, File rootDir, String key) {
		type = importType;
//		setSuite(testSuite);
		setTestKey(key);
		setRootDir(rootDir);
		sod = Common.getSingleOutputDocument(SingleOutputDocument.XMI_LOG);
		if (objXmlApp == null) {
			try { 
				objXmlApp = Common.getAltovaInstance() ;
			}
			catch (IllegalAccessException e) { e.printStackTrace();	}
		}
	}
	
//	private void setSuite(int testSuite) {
//		if(testSuite == UML20) version = "2.0";
//		else if (testSuite == UML21) version = "2.1";		
//	}
	
	private static void setRootDir(File rootDir) { rootDirectory = rootDir; }
	public File getRootDir() { return rootDirectory; }
	
	public void setupTest(File tf ) {
		testFile = tf;
		tfName = testFile.getName();
		tfName = tfName.substring(0, tfName.lastIndexOf("."));	//remove the extension and save as String		
		testLogDir = getLogDir(tf);

		
		if(!getFlag(COPY_TO_REF)) {
			try {
				testLogDir.mkdirs();
				copyFileToTestDir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		set_ui_settings();		

//		String path = testFile.getAbsolutePath();
//		path = path.substring(0, path.lastIndexOf("\\"));
//		path = path.substring(path.lastIndexOf("\\"), path.length());
//		path = path +"\\" + testFile.getName();
		
		testNode = sod.logE(projectNode, SingleOutputDocument.TEST_FILE_EL);
		sod.logA(testNode, SingleOutputDocument.NAME_ATT, testFile.getName());
		sod.logE(testNode, SingleOutputDocument.STEPS_EL);

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
	
	public void xmiGeneration() throws DoNotContinueException	{
		
		if(getFlag(DEBUG_MODE) == true) System.out.println(">>>>>xmiGeneration") ;
		
		int status = -1;
		String result = null;
		stepExtension = ".ump." + getTestKey() + ".xmi";
		
		Node n = sod.logE(testNode, STEP_EL);
		sod.logA(n, SingleOutputDocument.STEP_ATT, XMI_STEP_ATT);
		
		String outputXMIFileName = testLogDir.getAbsolutePath() + "\\" + tfName + stepExtension;
		sod.logE(n, OUTPUT_EL, outputXMIFileName);

		String cmd= "\"" + getUModelBatchExe() + "\" \"" + testFile.getAbsolutePath() + "\" /exex=1 /exuv=" + getProperty(EXUV, LATEST_UML_VERSION) + " /exf=\"" + outputXMIFileName + "\"";
					
		status = Common.executeCommand( cmd , false , DependancyApplication.UMODEL );
		result += Common.getLastOutputMessage();
		if(result.equals("")) result = Common.getLastErrorMessage();

		sod.logE(n, CMD_INPUT_EL, cmd);
		sod.logE(n, CMD_OUTPUT_EL, result);
		sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));
	}
	
	public void xmiTransformation()	{
		
		if(getFlag(DEBUG_MODE) == true) System.out.println("xmiTransformation") ;
		
		boolean status = false;
		
		String outputXSLFileName = testLogDir.getAbsolutePath() + "\\" + tfName + stepExtension + ".xml";
		Node n = sod.logE(testNode, STEP_EL);		
		sod.logA(n, STEP_ATT, XSL_STEP_ATT);
		
		String result = null;
		
		File xsltFileName = (getTestKey().equals(UML_21))? XMI_21_XSLT : XMI_20_XSLT ;
		
		sod.logE(n, SingleOutputDocument.XSLTFILE_EL, xsltFileName.getName());
		
		if(getFlag(DEBUG_MODE) == true) System.out.println("xsltTransformation") ;

		if ( objXmlApp != null ) {
			if(getFlag(DEBUG_MODE) == true) System.out.println("XmlApp != true") ;

			IXSLT xslt = objXmlApp.getXSLT2Instance();
			stepExtension = ".ump." + getTestKey()  + ".xmi";
			File xmiFile = new File(testLogDir.getAbsolutePath() + "//" + tfName + stepExtension);
			if(xmiFile.exists()) {

				sod.logE(n, INPUT_EL, xmiFile.getName());
				
				xslt.setInputXMLFileName(xmiFile.getAbsolutePath());
				xslt.setXSLTFileName(xsltFileName.getAbsolutePath());				
				if ( !xslt.execute(outputXSLFileName) ) {
					if(getFlag(DEBUG_MODE) == true) System.out.println("Xslt Error") ;

					result = xslt.getLastErrorMessage();
					if(getFlag(DEBUG_MODE) == true) System.out.println(result) ;

				}
				else {
					status = true;
					sod.logE(n , OUTPUT_EL, outputXSLFileName);					
				}
				xslt.releaseInstance();
			} else result = "file not found: " + xmiFile.getAbsolutePath();			
		} else result = "Creating instance of IAltovaXMLFactory failed. Please make sure AltovaXML.exe is correctly registered!";
		if(getFlag(DEBUG_MODE) == true && (result!=null) ) System.out.println(result) ;


		sod.logE(n, ERROR_EL, result);
		sod.logA(n, STATUS_ATT, ((status == true) ? STATUS_PASS : STATUS_FAIL ));
	}	
	
	public void xmlValidation() throws DoNotContinueException {
		
		if(getFlag(DEBUG_MODE) == true) System.out.println("xmiValidation") ;
		
		boolean status = false;
		int sts = -1;
		String result = null;
		String cmd = null;
		Node n = sod.logE(testNode, STEP_EL);
		sod.logA(n, STEP_ATT, VAL_STEP_ATT);
		
		File xmlSchema = (getTestKey().equals(UML_21))? UML_21_XMI_21_XSD : UML_20_XMI_21_XSD ;
		
		sod.logE(n, SCHEMAFILE_EL, xmlSchema.getName());
		

		if ( objXmlApp != null ) {
			IXMLValidator xmlVal = objXmlApp.getXMLValidatorInstance();		
			stepExtension = ".ump." + getTestKey() + ".xmi.xml";
			File xmlFile = new File(testLogDir.getAbsolutePath() + "//" + tfName + stepExtension);
			if(xmlFile.exists()) {
				cmd = "\"" + DOSSR + "\" \"" + xmlFile.getAbsolutePath() + "\" \"http://schema.omg.org/spec/UML/2.1.2\""  + " \"http://schema.omg.org/spec/UML/2.1\"";
			
				sts = Common.executeCommand( cmd , false , DependancyApplication.DOSSR);
				result += Common.getLastOutputMessage();
				Common.resetOutputMessage();
				
				sod.logE(n, SingleOutputDocument.INPUT_EL, xmlFile.getName());
				
				xmlVal.setInputXMLFileName(xmlFile.getAbsolutePath());
				xmlVal.setSchemaFileName(xmlSchema.getAbsolutePath());							
				if ( !xmlVal.isValidWithExternalSchemaOrDTD() )	result = xmlVal.getLastErrorMessage();
				else status = true;
			} else result = "file not found: " + xmlFile.getAbsolutePath();
			xmlVal.releaseInstance();
		} else result = "Creating instance of IAltovaXMLFactory failed. Please make sure AltovaXML.exe is correctly registered!";		

		sod.logE(n, ERROR_EL, result);
		sod.logA(n, STATUS_ATT, ((status == true) ? STATUS_PASS : STATUS_FAIL ));
	}
	
	
	public void xmiImport() throws DoNotContinueException	{	
		
		if(getFlag(DEBUG_MODE) == true) System.out.println(">>>>>xmiImport") ;
		
		int status = -1;
		String result = null;
		String outputIMPFileName = testLogDir.getAbsolutePath() + "\\" + tfName + "_gen.ump";//stepExtension;
		
		Node n = sod.logE(testNode, STEP_EL);
		sod.logA(n, STEP_ATT, IMP_STEP_ATT);
		
		stepExtension = ".ump." + getTestKey() + ".xmi";
		File xmiFile = new File(testLogDir.getAbsolutePath() + "//" + tfName + stepExtension);
		if(xmiFile.exists()) {
				
			String cmd = "\"" + getUModelBatchExe() + "\" /new=\"" + outputIMPFileName+ "\" /ixf=\"" + testLogDir + "\\" + xmiFile.getName()  + "\"";

			sod.logE(n, SingleOutputDocument.INPUT_EL, xmiFile.getName());
			sod.logE(n , CMD_INPUT_EL, cmd);
						
			status = Common.executeCommand( cmd , false , DependancyApplication.UMODEL);
			result += Common.getLastOutputMessage();
			if(result.equals("")) result = Common.getLastErrorMessage();

		} else result = "file not found: " + xmiFile.getAbsolutePath();

		sod.logE(n, CMD_OUTPUT_EL, result);
		sod.logA(n, STATUS_ATT, ((status == 0) ? STATUS_PASS : STATUS_FAIL ));
	}
	
	public void umpTransformation()	{
		
		if(getFlag(DEBUG_MODE) == true) System.out.println(">>>>>umpTransformation") ;
		
		boolean status = false;
		String result = "";
		File inputTRAFile = null;
		String outputTRAFileName = null;
		
		Node n = sod.logE(testNode, STEP_EL);
		sod.logA(n, STEP_ATT, UMP_STEP_ATT);
		
		//System.out.println("[umpTransformation] objXmlApp IS NOT NULL?" + objXmlApp) ;
		if ( objXmlApp != null ){
			IXSLT xslt = objXmlApp.getXSLT2Instance();
			stepExtension = ".ump";
			inputTRAFile= new File(testLogDir.getAbsolutePath() + "\\" + tfName + stepExtension);
			
			stepExtension = ".ump.sort.xml";
			outputTRAFileName = testLogDir.getAbsolutePath() + "\\" + tfName + stepExtension;
			
			sod.logE(n, INPUT_EL, inputTRAFile.getName());	
			sod.logE(n, OUTPUT_EL, tfName + stepExtension);
			
			//System.out.println("[umpTransformation] inputTRAFile exist?" + inputTRAFile.exists()) ;
			if(inputTRAFile.exists()) {
				xslt.setInputXMLFileName( inputTRAFile.getAbsolutePath() );
//				For UML 2.0 use a XSLT stylesheet that strips away diagrams.
				if (getTestKey().equals(UML_20)) {
					xslt.setXSLTFileName( STRIP_SORT_20.getAbsolutePath() );						
				}
				else {
					xslt.setXSLTFileName( STRIP_SORT_21.getAbsolutePath() );										
				}
				if ( !xslt.execute( outputTRAFileName )) {
					result += xslt.getLastErrorMessage();
					sod.logE(n, ERROR_EL, result);
				}
				else status = true;
			} else result += "file not found: " + inputTRAFile.getAbsolutePath();
			
			stepExtension = "_gen.ump";
			inputTRAFile = new File(testLogDir.getAbsolutePath() + "\\" + tfName + stepExtension);
			stepExtension = ".ump." + getTestKey() + ".xmi.ump.sort.xml";
			outputTRAFileName = testLogDir.getAbsolutePath() + "\\" + tfName + stepExtension;

			sod.logE(n, INPUT_EL, inputTRAFile.getName());
			sod.logE(n, OUTPUT_EL, tfName + stepExtension);
				
			if(inputTRAFile.exists()) {
				xslt.setInputXMLFileName(inputTRAFile.getAbsolutePath());
//				For UML 2.0 use a XSLT stylesheet that strips away diagrams.
				if (getTestKey().equals(UML_20)) {
					xslt.setXSLTFileName( STRIP_SORT_20.getAbsolutePath() );						
				}
				else {
					xslt.setXSLTFileName( STRIP_SORT_21.getAbsolutePath() );										
				}
				if ( !xslt.execute(outputTRAFileName) ) {
					result += xslt.getLastErrorMessage();
					sod.logE(n, ERROR_EL, result);
				}
				else status = true;
			} else result += "file not found: " + inputTRAFile.getAbsolutePath();	
			xslt.releaseInstance();
		} else result += "Creating instance of IAltovaXMLFactory failed. Please make sure AltovaXML.exe is correctly registered!";
		
		sod.logE(n, ERROR_EL, result);
		sod.logA(n, STATUS_ATT, ((status == true) ? STATUS_PASS : STATUS_FAIL ));
	}

	public void xmiTransDiff()throws DoNotContinueException	{
		
		if(getFlag(DEBUG_MODE) == true) System.out.println(">>>>>xmi transform and diff") ;
		
		boolean status = false;
		String result = "";
		File inputTRAFile = null;
		String outputTRAFileName1, outputTRAFileName2 = null;
		String outExtension = ".sort.xmi";
		
		Node n = sod.logE(testNode, STEP_EL);
		sod.logA(n, STEP_ATT, XSL_STEP_ATT);
		
		stepExtension = ".ump." + getTestKey() + ".xmi";

		if ( objXmlApp != null ){
			IXSLT xslt = objXmlApp.getXSLT2Instance();
			inputTRAFile = new File(testLogDir.getAbsolutePath() + "\\" + tfName + stepExtension);			

			outputTRAFileName1 = testLogDir.getAbsolutePath() + "\\" + tfName + "-log" + outExtension;
			
			sod.logE(n, INPUT_EL, inputTRAFile.getName());	
			sod.logE(n, OUTPUT_EL, outputTRAFileName1);
				
			if(inputTRAFile.exists()) {
				xslt.setInputXMLFileName( inputTRAFile.getAbsolutePath() );
//				For UML 2.0 use a XSLT stylesheet that strips away diagrams.
				if (getTestKey().equals(UML_20)) {
					xslt.setXSLTFileName( XMI_STRIP_SORT_20.getAbsolutePath() );						
				}
				else {
					xslt.setXSLTFileName( XMI_STRIP_SORT_21.getAbsolutePath() );										
				}
				if ( !xslt.execute( outputTRAFileName1 )) {
					result += xslt.getLastErrorMessage();
					sod.logE(n, ERROR_EL, result);
				}
				// else status = true;
			} else {
				result += "file not found: " + inputTRAFile.getAbsolutePath();
				System.out.println("4:" + result);
			}
			
			inputTRAFile = new File(testFile.getParentFile() + "\\" + tfName + stepExtension);
			outputTRAFileName2 = testLogDir.getAbsolutePath() + "\\" + tfName + "-ref" + outExtension;

			sod.logE(n, INPUT_EL, inputTRAFile.getName());
			sod.logE(n, OUTPUT_EL, outputTRAFileName2);
				
			if(inputTRAFile.exists()) {
				xslt.setInputXMLFileName(inputTRAFile.getAbsolutePath());
//				For UML 2.0 use a XSLT stylesheet that strips away diagrams.
				if (getTestKey().equals(UML_20)) {
					xslt.setXSLTFileName( XMI_STRIP_SORT_20.getAbsolutePath() );						
				}
				else {
					xslt.setXSLTFileName( XMI_STRIP_SORT_21.getAbsolutePath() );										
				}
				if ( !xslt.execute(outputTRAFileName2) ) {
					result += xslt.getLastErrorMessage();
					sod.logE(n, ERROR_EL, result);
				}
				else {
					n = sod.logE(testNode, STEP_EL);
					sod.logA(n, STEP_ATT, XMIDIF_STEP_ATT);					
					String strCmd = getDiffDogBatchExe() + " /cF \"" + outputTRAFileName1 + "\" \"" +  outputTRAFileName2 + "\" " + "/q /mX /iB /iNT C /iOA /iOC /wN /wS /f ignore-component-dir";

					int sts = Common.executeCommand( strCmd , false , DependancyApplication.DIFFDOG);
					result += Common.getLastOutputMessage();
					if (sts == DIFFDOG_STS_EQUAL)
						status = true;
					else
						if(sts == DIFFDOG_STS_ERROR)
							result = Common.getLastErrorMessage();
				}
			} else {
				result += "file not found: " + inputTRAFile.getAbsolutePath();
				System.out.println("5:" + result);
			}
			xslt.releaseInstance();
		} else {
			result += "Creating instance of IAltovaXMLFactory failed. Please make sure AltovaXML.exe is correctly registered!";
			System.out.println("6:" + result);
		}
		
		sod.logE(n, ERROR_EL, result);
		sod.logA(n, STATUS_ATT, ((status == true) ? STATUS_PASS : STATUS_FAIL ));
	}

	public void xmlDiff() throws DoNotContinueException {
		
		if(getFlag(DEBUG_MODE) == true) System.out.println(">>>>>xmlDiff") ;
		
		int status = -1;
		String result = "";
		Node n = sod.logE(testNode, STEP_EL);
		sod.logA(n, STEP_ATT, DIF_STEP_ATT);
		
		stepExtension = ".ump.sort.xml";
		File diffFile1 = new File(testLogDir.getAbsolutePath() + "\\" + tfName + stepExtension);
			
		sod.logE(n, INPUT_EL, diffFile1.getName());

		stepExtension = ".ump." + getTestKey() + ".xmi.ump.sort.xml";
		File diffFile2 = new File(testLogDir.getAbsolutePath() + "\\" + tfName + stepExtension);

		sod.logE(n, INPUT_EL, diffFile2.getName());

		if(diffFile1.exists() && diffFile2.exists()) {
			String strCmd = getDiffDogBatchExe() + " /cF \"" + diffFile1 + "\" \"" +  diffFile2 + "\" /q /mX /dD /dL";	
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
	public void xmiDiff() throws DoNotContinueException {
	
	if(getFlag(DEBUG_MODE) == true) System.out.println("xmlDiff") ;
	
	int status = -1;
	String result = "";
	Node n = sod.logE(testNode, STEP_EL);
	sod.logA(n, STEP_ATT, XMIDIF_STEP_ATT);
	
	stepExtension = ".ump." + getTestKey() + ".xmi";
	File diffFile1 = new File(testLogDir.getAbsolutePath() + "\\" + tfName + stepExtension);
		
	sod.logE(n, INPUT_EL, diffFile1.getName());

	File diffFile2 = new File(testFile.getParentFile() + "\\" + tfName + stepExtension);

	sod.logE(n, INPUT_EL, diffFile2.getName());

	if(diffFile1.exists() && diffFile2.exists()) {

		String strCmd = getDiffDogBatchExe() + " /cF \"" + diffFile1 + "\" \"" +  diffFile2 + "\" /q /mX /dD /dL /iB /iNT C /iOA /iOC /wN /wS";	
//		String strCmd = "diff.exe -i -w \"" + diffFile1 + "\" \"" +  diffFile2 + "\"";
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
