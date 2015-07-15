package com.altova.umodel.regression.functional;

import org.xml.sax.SAXParseException;

public class DoNotContinueException extends Exception {

	public static final int BUG = 1;
	public static final int FILE_NOT_FOUND = 10 ;
	public static final int EXE_NOT_FOUND = 11 ;
	public static final int XSLT_FAILED = 12 ;
	public static final int OO_SORT_FAILED = 13 ;
	public static final int IALTOVAXMLFACTORY = 14;
	public static final int ALTOVA_XML_NOT_FOUND = 15;
	public static final int DIFF_NULL_POINTER = 16;
	public static final int DOC_TYPE_EMPTY = 17;
	public static final int DIFF_RESULT_NO_OUTPUT = 18;
	public static final int DOM_REPLACE_FAILED = 19;
	
	public static final int SAX_PARSER = 20;
	public static final int SAX_EXCEPTION = 21;
	public static final int SAX_PARSER_CONFIG = 22;	
	public static final int CLASS_CAST = 23;
	public static final int IO = 24;
	public static final int OBSOLETE_TEST = 25 ;
	
	private final String bug = "possible bug : " ;
	private final String file = "file not found : ";
	private final String exe = "exe not found : ";
	private final String xslt = "xslt transform failed : ";
	private final String oo = "operator overloader transform failed : ";
	private final String AltovaXmlFactory = "Register AltovaXML_COM.exe /n Creating instance of IAltovaXMLFactory failed./n";
	private final String AltovaXMLExe = "AltovaXML2007 not found...";
	private final String diffNullPointer = "Exception handling needed in Diff Algorithm";
	private final String docTypeEmpty = "document type empty";
	private final String diffResultEmpty = "No output files generated by UmpDiffTest";
	private final String domReplaceFailure = "Dom replace uuids failed";
	private final String obsolete = "This test is obsolete...";
	private String message;
	private int type;

	private static final long serialVersionUID = 1L;
	
	public DoNotContinueException(String m) {
		setMessage(0, m);
	}	
	public DoNotContinueException(int type, String m) {
		setMessage(type, m);
	}
	public DoNotContinueException(int type, String m, Exception e) {
		setMessage(type, m + e.getMessage());
	}
	public DoNotContinueException(int type, Exception e) {
		//use contained exception if exists...
		if(e.getClass()== SAXParseException.class)
			e = (((SAXParseException) e).getException() != null ? e : ((SAXParseException) e).getException());		
		setMessage(type, e.getMessage());		
	}
	public DoNotContinueException(String m, Exception e) {
		//use contained exception if exists...
		if(e.getClass()== SAXParseException.class)
			e = (((SAXParseException) e).getException() != null ? e : ((SAXParseException) e).getException());		
		setMessage(m + e.getMessage());		
	}	

	public DoNotContinueException(int type) {
		setMessage(type);
	} 
	
	private void setMessage(String m) {	message = m; }	
	private void setMessage(int type) {	setMessage(type, ""); }	
	private void setMessage(int type, String m) {
		setType(type);
		switch (type) {
			
			case BUG : 						setMessage( bug + m ) ; break; 
			case OBSOLETE_TEST: 			setMessage(obsolete + m); break;
			case FILE_NOT_FOUND: 			setMessage(file + m); break;
			case EXE_NOT_FOUND: 			setMessage(exe + m); break;
			case XSLT_FAILED: 				setMessage(xslt + m); break;
			case OO_SORT_FAILED: 			setMessage(oo + m); break;
			case IALTOVAXMLFACTORY: 		setMessage(AltovaXmlFactory + m); break;
			case ALTOVA_XML_NOT_FOUND: 		setMessage(AltovaXMLExe + m); break;
			case DIFF_NULL_POINTER: 		setMessage(diffNullPointer + m); break;
			case DOC_TYPE_EMPTY: 			setMessage(docTypeEmpty + m); break;
			case DIFF_RESULT_NO_OUTPUT: 	setMessage(diffResultEmpty + m); break;
			case DOM_REPLACE_FAILED: 		setMessage(domReplaceFailure+ m); break;
			case CLASS_CAST: 				setMessage(m); break;
			case IO: setMessage(m); break;
			 
			default : setMessage("undefined error" + m); break;
		}
	}
	
	public String getMessage() { return message; }
	private void setType(int t) { type = t;	}
	public int getType() { return type; }	
}
