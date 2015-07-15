package com.altova.umodel.regression.functional;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
/**
 * UModel Regression Tests Documenting Framework 
 * 
 * @author Phelim McConigly
 *
 */
public class SingleOutputDocument {
	
	static final String STATUS_PASS = "pass" ;
	static final String STATUS_FAIL = 	"fail" ;
	static final String ROOT_EL		= "umodel-regression-test";
	static final String TEST_EL		= "test";
	static final String SUITE_EL	= "suite";
	static final String PROJECT_TYPE_EL = "project-type";
	static final String STEPS_EL	= "steps";
	static final String STEP_EL		= "step";
	static final String INPUT_EL 	= "input-file";
	static final String OUTPUT_EL 	= "output-file";
	static final String CMD_INPUT_EL = "cmd";
	static final String CMD_OUTPUT_EL = "output";
	static final String TEST_FILE_EL = "test-file";
	static final String ERROR_EL 	= "error";
	static final String XSLTFILE_EL = "xslt-file";
	static final String SCHEMAFILE_EL = "schema-file";
	static final String FILE_COMPARE_EL = "output";
	static final String MODIFIED_CODE_STEP_ATT = "modified-code";
	
	static final String SOURCE_EL = "source";
	static final String SOURCE_FILE_ATT= "source-file";
	
	static final String UML_VERSION = "uml-version";
	static final String UML_NAME = "uml-name";
	static final String PROJECT_TYPE_ATT = "project-type";
	static final String NAME_ATT 	= "name";
	static final String DATE_ATT 	= "date";
	static final String FILE_ATT 	= "file";
	static final String PATH_ATT 	= "path";
	static final String STATUS_ATT 	= "status";
		
	static final String STEP_ATT = "step";
	static final String XMI_STEP_ATT = "xmi";
	static final String XSL_STEP_ATT = "xmi-xsl";
	static final String VAL_STEP_ATT = "val";
	static final String IMP_STEP_ATT = "imp";
	static final String UMP_STEP_ATT = "ump-xsl";
	static final String DIF_STEP_ATT = "dif";
	static final String XMIDIF_STEP_ATT = "dif-xmi";

	static final String MERGE_STEP_ATT = "merge";
	
	//generic for code generation and rte (original and modified?)
	static final String IMPORT_STEP_ATT = "import-code";
	static final String UPDATE_STEP_ATT = "update-code";	
	static final String IMPORT_BINARY_STEP_ATT = "import-binary";
	static final String IMPORT_GENERATED_STEP_ATT = "import-generated-code";
	static final String IMPORT_MODIFIED_STEP_ATT = "import-modified-code";
	static final String GENERATE_STEP_ATT = "generate-code";
	static final String COMPARE_CODE_STEP_ATT = "compare-code";
	static final String COMPARE_UMP_STEP_ATT = "compare-ump";
	static final String DIFFDOG_COMMAND_ATT = "cmd";
	static final String ROBOT_GUI_HANDLER_STEP_ATT = "robot modified-code";
	static final String SYNTAX_CHECK_ATT = "syntax-checker-test" ;
	static final String SYNTAX_OUTPUT_COMPARE = "compare-output" ;
	
	static final String IMPORT_XSD_STEP_ATT = "import-xsd-to-ump" ;
	static final String EXPORT_UMP_TO_XSD_STEP_ATT = "export-ump-to-xsd" ;
	static final String IMPORT_XSD_GENERATED_STEP_ATT = "import-generated-xsd" ;	
		
	private static SingleOutputDocument xmiInstance = null;
	private static SingleOutputDocument javaCgInstance = null;
	private static SingleOutputDocument csharpCgInstance = null;
	private static SingleOutputDocument rteInstance = null;
	private static SingleOutputDocument ncgInstance = null;
	private static SingleOutputDocument javaBinaryInstance = null;
	private static SingleOutputDocument csharpBinaryInstance = null;
	private static SingleOutputDocument robotModelEditInstance = null;
	private static SingleOutputDocument vbCgInstance = null;
	private static SingleOutputDocument xsdInstance  = null;
	private static SingleOutputDocument synInstance  = null;
	private static SingleOutputDocument vbBinaryInstance  = null;
	private static SingleOutputDocument mergeInstance  = null;
	
	public static final int XMI_LOG = 0;
	public static final int JAVA_CG_LOG = 1;
	public static final int CSHARP_CG_LOG = 2;
	public static final int RTE_LOG = 3;
	public static final int NCG_LOG = 4;
	public static final int JAVA_BINARY_LOG = 5;
	public static final int CSHARP_BINARY_LOG = 6;
	public static final int ROBOT_MODEL_EDIT_LOG = 7;
	public static final int VB_CG_LOG = 8 ;
	public static final int XSD_LOG = 9 ;
	public static final int SYN_LOG = 10 ;
	public static final int VB_BINARY_LOG = 11 ;
	public static final int MERGE_LOG = 12 ;
	
	
	private static Document document = null;
	
	protected SingleOutputDocument () {
		// Exists only to defeat instantiation.
		createDOM();
	}
	public static SingleOutputDocument  getInstance(int i) {
		if (i == XMI_LOG) {
			if(xmiInstance == null) {
				xmiInstance = new SingleOutputDocument ();
			}		
			return xmiInstance;
		}		
		else if(i == JAVA_CG_LOG) { 
				if(javaCgInstance == null) {
					javaCgInstance = new SingleOutputDocument ();
				}			
				return javaCgInstance;
		}
		else if(i == CSHARP_CG_LOG) { 
			if(csharpCgInstance == null) {
				csharpCgInstance = new SingleOutputDocument ();
			}			
			return csharpCgInstance;
		}
		else if(i == RTE_LOG) {
			if(rteInstance == null) {
				rteInstance = new SingleOutputDocument ();				
			}
			return rteInstance; 
		}
		else if(i == NCG_LOG) {
			if(ncgInstance == null) {
				ncgInstance = new SingleOutputDocument ();				
			}
			return ncgInstance; 
		}
		else if (i == JAVA_BINARY_LOG) {
			if(javaBinaryInstance == null) {
				javaBinaryInstance = new SingleOutputDocument ();				
			}
			return javaBinaryInstance;			
		}
		else if (i == CSHARP_BINARY_LOG) {
			if(csharpBinaryInstance == null) {
				csharpBinaryInstance = new SingleOutputDocument ();				
			}
			return csharpBinaryInstance;			
		}
		else if (i == ROBOT_MODEL_EDIT_LOG) {
			if(robotModelEditInstance  == null) {
				robotModelEditInstance  = new SingleOutputDocument ();				
			}
			return robotModelEditInstance ;			
		}
		else if (i == VB_CG_LOG) {
			if(vbCgInstance  == null) {
				vbCgInstance  = new SingleOutputDocument ();				
			}
			return vbCgInstance ;	
		}		
		else if (i == XSD_LOG) {
			if(xsdInstance  == null) {
				xsdInstance  = new SingleOutputDocument ();				
			}
			return xsdInstance ;	
		}		
		else if (i == VB_BINARY_LOG) {
			if(vbBinaryInstance  == null) {
				vbBinaryInstance  = new SingleOutputDocument ();				
			}
			return vbBinaryInstance ;	
			
		}
		else if (i == SYN_LOG) {
			if(synInstance  == null) {
				synInstance  = new SingleOutputDocument ();				
			}
			return synInstance ;	
			
		}
		if (i == MERGE_LOG) {
			if(mergeInstance == null) {
				mergeInstance = new SingleOutputDocument ();
			}		
			return mergeInstance;
		}
		else return null;
	}
	
	public static Document createDOM() {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			builder.setErrorHandler(
					new org.xml.sax.ErrorHandler() {
						// ignore fatal errors (an exception is guaranteed)
						public void fatalError(SAXParseException exception)
						throws SAXException {
						}
						// treat validation errors as fatal
						public void error(SAXParseException e)
						throws SAXParseException
						{
							throw e;
						}						
						// dump warnings too
						public void warning(SAXParseException err)
						throws SAXParseException
						{
							System.out.println("** Warning"	+ ", line " + err.getLineNumber() + ", uri " + err.getSystemId());
							System.out.println("   " + err.getMessage());
						}
					}
			);
			// createing a new DOM-document...
			document = builder.newDocument();
			Element e = document.createElement(ROOT_EL);
			document.appendChild(e);

			return document;
			
		} catch (ParserConfigurationException ex) {
			// document-loader cannot be created which satisfies the configuration requested
			handleError(ex);
		}
		return null;
	}
	
	private Node setDOMElement(Node parentElement, String elementString) {	
		if(parentElement == null) {		//add to root
			parentElement = document.getFirstChild();
		}
		Element e = document.createElement(elementString);		
		return parentElement.appendChild(e);
	}
	
	private void setTextContent(Node parentElement, String content) {
		parentElement.setTextContent(content);
	}
		
	public Node logE(Node parentElement, String t) {
		return logE(parentElement, t, "") ;
	}
	public Node logE(Node parentElement, String t, String content) {
		Node e = setDOMElement(parentElement, t) ;
		setTextContent(e, content) ;
		return e ;
	}
	public void logA(Node parentElement, String key, String value) {
		((Element)parentElement).setAttribute(key, value);
	}
	
	
	
	
	private static final void handleError(Throwable ex) {
		// ... handle error here...
	}
	public static void outputDocumentToFile(File xmlOutputFile) {
		document.normalize();
		document.normalizeDocument();
		
//		 A transformer for output can only be used with xslt 1.0 engines.
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer;
		try {
	        FileOutputStream fos = new FileOutputStream(xmlOutputFile);
			transformer = tFactory.newTransformer();
			DOMSource source = new DOMSource(document);					
			Result resultOutFile = new StreamResult(fos);	
			System.out.println("writing DomDoc to xml file on disk...");
			transformer.transform(source, resultOutFile);
			((StreamResult)resultOutFile).getOutputStream().flush();
			fos.flush();
			fos.getChannel().close();	// releases the lock on the file, otherwise we can not transform it...

		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}