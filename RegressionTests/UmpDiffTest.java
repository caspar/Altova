package com.altova.umodel.regression.functional;
import static com.altova.util.Settings.*;

import static com.altova.util.LoggerUtils.logger;
import static com.altova.Depend.*;

import org.w3c.dom.*;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXException; 
import org.xml.sax.SAXParseException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException; 
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.ParserConfigurationException; 
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.altova.Depend.DependancyApplication;
import com.altova.engines.*;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.ls.DOMImplementationLS;
import static com.altova.umodel.regression.functional.UModelTestTypes.*;

public class UmpDiffTest {
	static Document documentVar1;
	static Document documentVar2;
	File inputFile1 = null;
	File inputFile2 = null;
	static String result = "";
	static File testLogDir = null;
	static String DD_COMPARE_XML_OPTION = "mX";
	static String DD_COMPARE_FILES_OPTION = "cF";
	
	//define some ump node elements here...
	private final String umpHLGE = "hyperlinkedGuiElement" ;
	private final String umpPROAPP = "Profile Application" ;
	private final String umpUUID = "uuid" ;	
	private final String umpUMODEL = "UModel" ;
	private final String umpMODEL = "Model" ;
	private final String umpMODHIS = "ModelHistory" ;
	private final String umpDIAG = "Diagrams" ;
	private final String umpSETT = "Settings" ;
		
	
	static Map<String, String> hm = new HashMap<String, String>();
	static File currentDir = new File("");
	
	//change main from constructor...
	public UmpDiffTest() {}
	
	/**
	 * Use UmpDiffTest as a CLI tool.
	 * Usage:
	 * set classpath=...\qacvs\\umodel\regression-tests\source\bin;
	 * 				 ...\qacvs\\umodel\regression-tests\source\xercesImpl.jar;
	 * 				 C:\Program Files\Altova\AltovaXML2007\AltovaXML.jar
	 * java com.altova.umodel.regression.functional.UmpDiffTest <file1.ump> <file2.ump>
	 * 
	 * @param args array of the two files to compare
	 */
	public static void main(String args[]) {
		if(args == null || args.length != 2) {
			System.err.println("Usage: UmpDiffTest <file1.ump> <file2.ump>");
			System.exit(1);
		}
		
		try {
			if(UmpDiffTest.diff(args[0], args[1])) {
				System.out.println("Files are different");
				System.exit(1);
			}
			else {
				System.exit(0);
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (DoNotContinueException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		
	}
	
	/**
	 * Verifies that the specified filename exists and is a file,
	 * then create a File object and returns it. 
	 * 
	 * @param filename path and name of file to check
	 * @return a File object of the specified filename
	 * @throws IOException if the file could not be found 
	 */
	public File verifyFile(String filename) throws IOException {
		if(!checkFile(filename)) {
			throw new FileNotFoundException("Could not find or open file '"+filename+"'.");
		}
		
		return new File(filename);
	}

	/**
	 * Checks that the specified filename exists and is a file.  
	 * 
	 * @param filename path and name of file to check
	 * @return true if the file exists and is a file, false otherwise
	 */
	public boolean checkFile(String filename) {
		File file = new File(filename);
		return file.isFile();
	}
	
	public void setTestLogDir(File f) {
		if(f == null) {
			throw new NullPointerException("f cannot be null");
		}
		
		if(!f.isDirectory()) {
			throw new IllegalArgumentException("'"+f.toString()+"' is not a directory");
		}
		
		testLogDir = f;
	}
	
	public String setupUmpDiffTest(File file1, File file2) throws DoNotContinueException{
		result = "";
		if (!(file1.isFile() || file2.isFile()) ) {
			result += "file not found: " + file1.getAbsolutePath();
		}
		else {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();			
			try {			
				DocumentBuilder builder = factory.newDocumentBuilder();				
				builder.setErrorHandler(
						new org.xml.sax.ErrorHandler() {
							// ignore fatal errors (an exception is guaranteed)
							public void fatalError(SAXParseException exception)
							throws SAXException {}
							// treat validation errors as fatal
							public void error(SAXParseException e)
							throws SAXParseException { throw e; }							
							// dump warnings too
							public void warning(SAXParseException err)
							throws SAXParseException   
							{
								result += "** Warning"	+ ", line " + err.getLineNumber() + ", uri " + err.getSystemId();
								result += err.getMessage();
							}
						}
				);
				inputFile1 = file1;
				inputFile2 = file2;				
				documentVar1 = builder.parse( inputFile1 );
				documentVar2 = builder.parse( inputFile2 );
				return result;
			
			} catch (SAXParseException spe) {
				System.out.println("\n** Parsing error" + ", line " + spe.getLineNumber() + ", uri " + spe.getSystemId());
				System.out.println("   " + spe.getMessage() );				
				throw new DoNotContinueException(DoNotContinueException.SAX_PARSER, spe);
			} catch (SAXException sxe) {
				throw new DoNotContinueException(DoNotContinueException.SAX_EXCEPTION, sxe);				
			} catch (ParserConfigurationException pce) {
				throw new DoNotContinueException(DoNotContinueException.SAX_PARSER_CONFIG, pce);
			} catch (IOException ioe) {
				throw new DoNotContinueException(DoNotContinueException.IO, ioe);
			} catch (ClassCastException e) {
				throw new DoNotContinueException(DoNotContinueException.CLASS_CAST, e);
			}
		}
		return result;
	}
	
	public String[] parseDocuments() throws ClassCastException, ClassNotFoundException, IllegalAccessException, DoNotContinueException {
		String[] result = new String[3];
		
		//create a list of nodes from document
		final NodeList nodeListDoc1;
		final NodeList nodeListDoc2;
		
		nodeListDoc1 = documentVar1.getChildNodes();
		nodeListDoc2 = documentVar2.getChildNodes();
		
		createUuidNamespaceMap(nodeListDoc1);
		createUuidNamespaceMap(nodeListDoc2);
		
		try {		
			if((documentVar1 != null) && (documentVar2 != null)){
				replaceReferencesToUuid(documentVar1);
				replaceReferencesToUuid(documentVar2);
				File f1 = transformDoc(documentVar1, 1);
				File f2 = transformDoc(documentVar2, 2);
			
				if((f1 == null) || (f2 == null)) 
					throw new DoNotContinueException(DoNotContinueException.DIFF_RESULT_NO_OUTPUT);
				
				else {
					
					result[0] = "command";
					// Call DiffDogBatch using filter and output differences to a xml file
					result[1] = "\"" + getDiffDogBatchExe() + "\"" + " /cF \"" + 
						f1.getAbsolutePath() + "\" \"" + 
						f2.getAbsolutePath() + "\" " + 
						"/q /mX /iB /iNT C /iOA /iOC /wN /wS /f ignore-component-dir";			
					result[2] = result[1] + " /rX "; //add filename here...
					return result;					
				}
			}
			else throw new DoNotContinueException(DoNotContinueException.DOC_TYPE_EMPTY);		
		} catch (NullPointerException e) {
			throw new DoNotContinueException(DoNotContinueException.DIFF_NULL_POINTER, e.getMessage());
		} catch (TransformerException e) {
			throw new DoNotContinueException(DoNotContinueException.DOM_REPLACE_FAILED, e.getMessage());
		} catch (IOException e) {
			throw new DoNotContinueException(DoNotContinueException.DOM_REPLACE_FAILED, e.getMessage());			
		}
	}
	
	/**
	 * Compare the two specified UMP files
	 * Returns true if they are different, and false otherwise.
	 * 
	 * @param file1 file to compare
	 * @param file2 file to compare
	 * @return true if the two UMP files are different
	 * @throws IOException if "something" went wrong with the reading/parsing of the two files
	 */
	public static boolean diff(String filename1, String filename2) throws IOException, DoNotContinueException {
		//check the files and setup diff
		UmpDiffTest diff = new UmpDiffTest();
		File file1 = diff.verifyFile(filename1);
		File file2 = diff.verifyFile(filename2);
		
		//set the log directory to umpdifflog under the default temp directory
		File logDir = new File( System.getProperty("java.io.tmpdir"), "umpdifflog" );
		
		if(!logDir.isDirectory()) logDir.mkdirs();
		
		diff.setTestLogDir(logDir);
		
		String ret = diff.setupUmpDiffTest(file1, file2);
		if(ret.length() > 0) throw new IOException("Something wrong happened. Ask Phelim. \n"+ret);
			
		//do the actual diff
		return diff.diff();
	}
	
	/**
	 * Compare the two UMP files initialized in this {@link UmpDiffTest}.
	 * Returns true if they are different, and false otherwise.
	 * 
	 * @return true if the two UMP files are different
	 * @throws IOException if "something" went wrong with the reading/parsing of the two files
	 */
	public boolean diff() throws IOException, DoNotContinueException {
		String strCmd[];
		
		try {
			strCmd = parseDocuments();
		} catch (Exception e) {
			throw new IOException("Something wrong happened while reading/parsing one of the files. Ask Phelim or Havard.", e);
		}
			
		if(strCmd[0].equals("error")) {
			throw new IOException("Something wrong happened while reading/parsing one of the files. Ask Phelim or Havard.");
		}
		else {
			Common.executeCommand( strCmd[1] , false , DependancyApplication.DIFFDOG);
			String output = Common.getLastOutputMessage();
			if(output.length() == 0) {
				output = Common.getLastErrorMessage();				
			}
			
			if(output.endsWith("different")) {
				return true;
			}
		}
		
		return false;
	}
	
	//Creates a map with all uuids and the qualifying namespace
	private void createUuidNamespaceMap(NodeList nodeList) {
		Set<Node> modelNodesList = findModelNodeList(nodeList);
		Node modelNode = null;
		if(modelNodesList == null) {
			System.out.println("No Model found on ump file...");
		}
		else {
			for(Iterator iter = modelNodesList.iterator(); iter.hasNext();)
			{				
				modelNode = (Node) iter.next();
				if(modelNode.getNodeType() == Node.ELEMENT_NODE) {
					NodeList modelNodeList = ((Element)modelNode).getChildNodes();
					traverseTreeAndFillUUIDMap(modelNodeList);
					
				}
			}
		}		
	}	
	
	private void traverseTreeAndFillUUIDMap(NodeList nodes) {
		String uuid = "";
		String namespace = "";
		Node node = null;		
		for(int i=0; i<=nodes.getLength(); i++) {
			node = nodes.item(i);
			if((node != null) && (node.getNodeType() == Node.ELEMENT_NODE)) {
				uuid = findAttributeByName(node, umpUUID);
				if(uuid != "") {
					namespace = createNamespaceForNode(node);
					//uuid found, namespace could still be empty due to abscence of name on element.
					if(namespace == "") {
						createNameSpaceForSpecialCase(node);
					}
					hm.put(uuid, namespace);				
				}
				if(findAttributeByName(node, umpHLGE) != "") ((Element)node).removeAttribute(umpHLGE);
			}
			if((node != null) && (node.getChildNodes() != null)) {
				traverseTreeAndFillUUIDMap(node.getChildNodes());
			}
		}		
	}	
	
	private String createNameSpaceForSpecialCase(Node n) {
		if(n.getNodeType() == Node.ELEMENT_NODE) {
			
			String elementName = ((Element)n).getNodeName();
			if(elementName == umpPROAPP) {}
			else if(elementName == "") {}
		}		
		return "";		
	}
	
	private Set<Node> findModelNodeList(NodeList nodeList) {
		Set<Node> nodesToSearch = new HashSet<Node>();
		Node umodelNode = null;		
		Node diagramsNode = null;
		Node settingsNode = null;		
		if(nodeList.getLength() != 0) {
			for(int i=0; i<=nodeList.getLength(); i++) {
			//for(int i=1; i<=nodeList.getLength()-1; i++) { //skip first comment
				if (!(nodeList.item(i) == null)) {
				//System.out.println("nodeList(i):"  + i + nodeList.item(i));
				if (!(nodeList.item(i).getNodeType() == Node.COMMENT_NODE)) {
					Element elem = (Element) nodeList.item(i);
					if (elem != null) {
						if((elem.getNodeName() != null) && (elem.getNodeName() == umpUMODEL)) {
							NodeList umodelNodes = ((Node)elem).getChildNodes();
							for(int j = 0; j <= umodelNodes.getLength(); j++) {
								umodelNode = umodelNodes.item(j);
								if((umodelNode != null) && (umodelNode.getNodeType() == Node.ELEMENT_NODE)) {
									if(((Element)umodelNode).getNodeName() == umpMODEL) {
										nodesToSearch.add(umodelNode);
									}
									else if(((Element)umodelNode).getNodeName() == umpMODHIS) {
										nodesToSearch.add(umodelNode);
									}
									else if(((Element)umodelNode).getNodeName() == umpDIAG) {
										diagramsNode = umodelNode;
									}
									else if(((Element)umodelNode).getNodeName() == umpSETT) {
										settingsNode = umodelNode;
									}
								}
							}
							if(diagramsNode != null) { elem.removeChild(diagramsNode); }
							if(settingsNode != null) { elem.removeChild(settingsNode); }						
						}
					}
				}
				}
			}
		}
		return nodesToSearch;
	}
	
	private static String createNamespaceForNode(Node node) {		
		String namespace = "";
		Element current = (Element) node;			
		do {
			NamedNodeMap nnm = current.getAttributes();
			for(int i = 0; i<= nnm.getLength(); i++) {
				Attr item = (Attr) nnm.item(i);
				if(item != null) {
					if(namespace == "") {
						if(item.getName() == "name") {
							namespace = item.getValue();
						}
//						//special cases for round trip engineering...
//						else if(item.getName() == "general") {
//						//Class generalises to other class...
//						namespace = item.getValue();
//						}
//						else if(item.getName() == "implementingClassifier") {
//						//Class generalises to package...
//						//replaceReferenceWithNameSpace();
//						namespace = item.getValue();
//						
//						}
//						else if(item.getName() == "contract") {
//						//Class generalises to interface...
//						namespace = item.getValue();
//						}
//						else if(item.getName() == "contract") {
//						//Class generalises to interface...
//						namespace = item.getValue();
//						}										
//						namespace = item.getValue().concat(namespace);
					}
					else {
						if(item.getName() == "name") {
							namespace = item.getValue().concat(".").concat(namespace);
						}
					}
				}
			}
			if((current.getParentNode() != null) && (current.getParentNode().getNodeType() == Node.ELEMENT_NODE)) {
				current = (Element) current.getParentNode();
			}			
		} while (current.getNodeName() != "UModel" && (current.getNodeType() == Node.ELEMENT_NODE));
		return namespace;
	}
	
	private void replaceReferencesToUuid(Document document) throws DoNotContinueException {
		try {
			traverseTree(document);
		}
		catch (Exception e) {
			throw new DoNotContinueException(DoNotContinueException.DOM_REPLACE_FAILED, e.getMessage());			
		}		
	}
	
	private String findAttributeByName(Node n, String att) {		
		Attr attr = null;
		int limit = 0;
		Node childNode = null;		
		NamedNodeMap children = n.getAttributes();		
		if (children != null) {
			limit = children.getLength();			
			for(int i=0; i<=limit; i++) {
				childNode = children.item(i);
				if((childNode != null) && (childNode.getNodeType() == Node.ATTRIBUTE_NODE)) {
					attr = (Attr) childNode;	
					if(attr.getName() == att) 
						return attr.getValue();	
				}
			}
		}
		return "";
	}
	
	private void traverseTree(Node node) throws Exception {
		if(node == null) return;
		int type = node.getNodeType();		
		switch (type) {
			// handle document nodes
			case Node.DOCUMENT_NODE: {
				traverseTree(((Document)node).getDocumentElement());
				break;
			}
			// handle element nodes
			case Node.ELEMENT_NODE: {
				//String elementName = node.getNodeName();
				
				NodeList childNodes = node.getChildNodes();      
				if(childNodes != null) {
					int length = childNodes.getLength();
					for (int i = 0; i<=length ; i++)
					{
						Node n = childNodes.item(i);
						if((n != null) && (n.getNodeType() == Node.ELEMENT_NODE)) {
							replaceReferenceWithNameSpace(n);
	//						if(replaceReferenceWithNameSpace(n))
	//						System.out.println("hit: " + n.getNodeName());
						}
						traverseTree(childNodes.item(i));					
					}
				}
				break;
			}
		}
	}
	
	private void replaceReferenceWithNameSpace(Node n) {
		NamedNodeMap nnm = n.getAttributes();
		for(int i=0; i<=nnm.getLength(); i++) {
			if(nnm.item(i) != null) {
				Attr a = (Attr)nnm.item(i);
				String key = a.getValue();
				if(hm.containsKey(key)) {
					String value = hm.get(key);
					a.setValue(value);
				}
			}
		}		
	}	
	
	private File transformDoc(Document dsrc, int i) throws ClassCastException, ClassNotFoundException, IllegalAccessException, DoNotContinueException, TransformerException , IOException{
//		try {
			dsrc.normalize();
			dsrc.normalizeDocument();			
			
			File in = (i == 1 ? inputFile1 : inputFile2);
			File out = new File(testLogDir + "\\" + i + in.getName());
			File outOO = new File(testLogDir + "\\final" + i + in.getName());			
			if(testLogDir == null) throw new IllegalStateException("method setTestLogDir(File) has to be called with a valid directory first");

			//Serialize the DOM tree so we can use it with the Altove xslt 2.0 interface			
//			System.setProperty(DOMImplementationRegistry.PROPERTY, DOM_IMPL_REG);
//			DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();			
//			DOMImplementationLS impl = (DOMImplementationLS)registry.getDOMImplementation("LS");			
//			LSSerializer writer = impl.createLSSerializer();
//			String strDomDoc = writer.writeToString(dsrc);		
			
			
			File fDsrc = new File(testLogDir, "dsrc.xml") ;
			fDsrc.createNewFile() ;
	        FileOutputStream fos = new FileOutputStream(fDsrc);			
	        TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            DOMSource source = new DOMSource(dsrc);
            StreamResult result = new StreamResult(fos);
            transformer.transform(source, result);
            ((StreamResult)result).getOutputStream().flush();
			fos.flush();
			fos.getChannel().close();	// releases the lock on the file, otherwise we can not transform it...
			
//			if(getFlag(DEBUG_MODE) == true) {
//				System.out.println("\n");
//				System.out.println("dom : " + strDomDoc);
//				System.out.println("\n");
//			}
			
			IAltovaXMLFactory objXmlApp = Common.getAltovaInstance() ;
			
			if ( objXmlApp != null ) {
				//get interface for the XQuery engine
				IXSLT xslt = objXmlApp.getXSLT2Instance();
				IXMLValidator objXmlVal = objXmlApp.getXMLValidatorInstance();
//				objXmlVal.setInputXMLFromText(strDomDoc);
				objXmlVal.setInputXMLFileName(fDsrc.getAbsolutePath()) ;
				
//				xslt.setInputXMLFromText(strDomDoc);
				xslt.setInputXMLFileName(fDsrc.getAbsolutePath()) ;
				xslt.setXSLTFileName(UMP_SORT.getAbsolutePath());
				
				if(getFlag(DEBUG_MODE) == true) System.out.println("outputfile : " + out.getAbsolutePath());
				
				if ( !xslt.execute(out.getAbsolutePath()) ) {
					objXmlApp.releaseInstance();
					xslt.releaseInstance();
					objXmlVal.releaseInstance();
					throw new DoNotContinueException(DoNotContinueException.XSLT_FAILED, xslt.getLastErrorMessage());					
				}
					
				
				xslt.setInputXMLFileName(out.getAbsolutePath());
				xslt.setXSLTFileName(OO_SORT.getAbsolutePath());
				
				if(getFlag(DEBUG_MODE) == true) System.out.println("outputOOfile : " + outOO.getAbsolutePath());
				
				if ( !xslt.execute(outOO.getAbsolutePath()) ) {
					objXmlApp.releaseInstance();
					xslt.releaseInstance();
					objXmlVal.releaseInstance();
					throw new DoNotContinueException(DoNotContinueException.OO_SORT_FAILED, xslt.getLastErrorMessage());
				}
				
				xslt.releaseInstance();
				//release Application object connection to the COM server object.
				//After this the COM server object will shut down automatically.
				objXmlApp.releaseInstance();
				xslt.releaseInstance();
				objXmlVal.releaseInstance();
				return outOO;
			} else{
				objXmlApp.releaseInstance();				
				throw new DoNotContinueException(DoNotContinueException.IALTOVAXMLFACTORY);
			}
//		} catch (InstantiationException e) {
//			throw new DoNotContinueException(DoNotContinueException.ALTOVA_XML_NOT_FOUND, e.getMessage());
//		}
	}
}
