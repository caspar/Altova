package com.altova.umodel.regression.functional;

import static com.altova.Depend.*;

import java.io.File;

import com.altova.engines.*;
//import com.altova.AltovaAPI.InstanceManager;
//import com.altova.AltovaAPI.RaptorXMLAPI;


public class ResultsXSLT {
	public static final String HTML = ".html";
	public static final String XML = ".xml";
	
//	static RaptorXMLAPI rap = null;
	
	String outputFormat = null;
	
	//log: log directory to which output should be saved: ".../_log_date_/.html"
	ResultsXSLT () { setOutputFormat(HTML); }
	
	ResultsXSLT (File log, String format) {	setOutputFormat(format); }

	public void setOutputFormat(String extention) { outputFormat = extention; }
	
	public void setXSLTInputFile(File f) { defaultXSLT = f;	}
	
	//returns a transform of xml in default format if not set (html)...
	public File transform(File xml) throws IllegalStateException, InstantiationException , IllegalAccessException{
		return transform(xml, defaultXSLT); 
	} 
	
	public File transform(File xml, Object type) throws IllegalStateException, InstantiationException, IllegalAccessException {
		
		if (type == TestXMI.class)
			return transform(xml, (File)xmiXSLT);
		if (type == TestRTE.class)
			return transform(xml, (File)rteXSLT);
		if (type == TestCodeGen.class)
			return transform(xml, (File)codeGenXSLT);
		if (type == TestBinaryImport.class)
			return transform(xml, (File)binaryXSLT);
		if (type == TestXSDImport.class)
			return transform(xml, (File)xsdXSLT);
		if(type == TestSyntaxChecker.class)
			return transform(xml, (File)syntaxCheckXSLT);
		if(type == TestMerge.class)
			return transform(xml, (File)mergeXSLT);
		else return transform(xml, (File)defaultXSLT);
		
		/*
		 * Use of RaptorXML for XSLT tranformation instead of AltovaXML
		 * 
		if (type == TestXMI.class)
			return transformRaptor(xml, (File)xmiXSLT);
		if (type == TestRTE.class)
			return transformRaptor(xml, (File)rteXSLT);
		if (type == TestCodeGen.class)
			return transformRaptor(xml, (File)codeGenXSLT);
		if (type == TestBinaryImport.class)
			return transformRaptor(xml, (File)binaryXSLT);
		if (type == TestXSDImport.class)
			transformRaptor(xml, (File)xsdXSLT);
		if(type == TestSyntaxChecker.class)
			return transformRaptor(xml, (File)syntaxCheckXSLT);
		if(type == TestMerge.class)
			return transformRaptor(xml, (File)mergeXSLT);
		else return transformRaptor(xml, (File)defaultXSLT);
		*/
		
		
		
	}	
	
    public File transform(File xml, File xslt) throws IllegalStateException, InstantiationException, IllegalAccessException {
		
    	if ( !xml.exists() ) throw new NullPointerException("xml null"); 
		if (xslt == null)throw new NullPointerException("xslt null");
		
		String filename = xml.getAbsolutePath() ;
		filename = filename.substring(filename.lastIndexOf("\\") +1 );		
		File html = new File(LOGS_HTML_DIR.getAbsolutePath() + "\\" + filename.replace(".xml", outputFormat));

		IAltovaXMLFactory objXmlApp = Common.getAltovaInstance() ; //AltovaXMLFactory.getInstance();
		if ( objXmlApp != null ) {
			IXSLT ixslt = objXmlApp.getXSLT2Instance();
			
			ixslt.setInputXMLFileName( xml.getAbsolutePath() );
			ixslt.setXSLTFileName(xslt.getAbsolutePath());
			System.out.println("transforming xml to html results...");
			if ( !ixslt.execute(html.getAbsolutePath())) throw new IllegalStateException(ixslt.getLastErrorMessage());
			ixslt.releaseInstance();
			objXmlApp.releaseInstance();
			ixslt.releaseInstance();
			return html;
		} else{
			throw new InstantiationException("Creating instance of IAltovaXMLFactory failed...");
		}
	}
    
    
    public void transformRaptor(File xml, File xslt){
    	/*
    	rap = InstanceManager.instanceAltovaRaptorXMLAPI();
    	
		String filename = xml.getAbsolutePath() ;
		filename = filename.substring(filename.lastIndexOf("\\") +1 );		
    	File html = new File(LOGS_HTML_DIR.getAbsolutePath() + "\\" + filename.replace(".xml", outputFormat));
    	
    	rap.validationAPI(xml.getAbsolutePath(), xslt.getAbsolutePath(), html.getAbsolutePath());
    	rap.xSLTTransformation(xml.getAbsolutePath(),  xslt.getAbsolutePath(), "3.0",  html.getAbsolutePath());
    	*/
    }
}
