package com.altova.util;

import java.io.File;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 

public class XMLFileReader {

	DocumentBuilderFactory docBuilderFactory = null; 
	DocumentBuilder docBuilder = null;
	Document doc = null;
	
	public XMLFileReader(String XMLfileToRead){
		
	  try {	
        docBuilderFactory = DocumentBuilderFactory.newInstance();
        docBuilder = docBuilderFactory.newDocumentBuilder();
        doc = docBuilder.parse (new File(XMLfileToRead));

        doc.getDocumentElement ().normalize ();
        System.out.println ("XMLFileReader: Root element of the doc is " + 
        doc.getDocumentElement().getNodeName());

      
      }catch (SAXParseException err) {
        
    	  System.out.println ("** Parsing error" + ", line " 
                 + err.getLineNumber () + ", uri " + err.getSystemId ());
          System.out.println(" " + err.getMessage ());

       }catch (SAXException e) {
            Exception x = e.getException ();
            ((x == null) ? e : x).printStackTrace ();

       }catch (Throwable t) {
            t.printStackTrace ();

       }
        
	}
	
	
	public int getNodeLength(String nodeName){
		
		int totalTest = 0;
		
		try {
		
          NodeList listOfTest = doc.getElementsByTagName(nodeName);
          totalTest = listOfTest.getLength();
        
	      }catch (Exception err) {
	          
	    	  System.out.println ("** getNodeLength error:" + err.toString());
	          System.out.println(" " + err.getMessage ());

	       }catch (Throwable t) {
	            t.printStackTrace ();
	       }  
          
		return totalTest; 
		
	}
	
	public NodeList getNodeList(String nodeName){
	
		NodeList listOfRes = null;
		
		try {
		  
			listOfRes = doc.getElementsByTagName(nodeName);
		  
	    }catch (Exception err) {
	          
	    	  System.out.println ("** getNodeList error:" + err.toString());
	          System.out.println(" " + err.getMessage ());
	          

	    }catch (Throwable t) {
	            t.printStackTrace ();
	    }  
		  
		  return listOfRes;
	}
	
	public String getValueOfNode(String NodeName, String TagName, int index){
		
        Node firstTestNode = getNodeList(NodeName).item(index);
        
        if(firstTestNode.getNodeType() == Node.ELEMENT_NODE){


            Element firstPersonElement = (Element)firstTestNode;
            NodeList firstNameList = firstPersonElement.getElementsByTagName(TagName);
            Element firstNameElement = (Element)firstNameList.item(0);
            if (firstNameElement!=null){ 
            	NodeList textFNList = firstNameElement.getChildNodes();
            	if ((Node)textFNList.item(0)!=null){return ((Node)textFNList.item(0)).getNodeValue().trim();
            	}
            	else return "";
            }
            else return "";
        }else{
        	
        	return null;
        	
        }   
	}
	
	public String getValueOfNode(String NodeName, String TagName) {
    	
    	return getValueOfNode(NodeName, TagName, 0);
    }
	
	public String getRoot(){
		if (doc != null)
		  return doc.getDocumentElement().getNodeName();	
		else 
		  return null;	  
	}
	
	public String [] getAllValueOfNode (String NodeName, String TagName){
		
		int lengthValueNode = getNodeLength(NodeName);
		String [] arrayValueofNode = new String [lengthValueNode];
		
		for (int i = 0; i < lengthValueNode; i++) {
		
			arrayValueofNode[i] = getValueOfNode(NodeName, TagName, i); 
			
		}
		
		return arrayValueofNode;
		
	}
	
	
}
