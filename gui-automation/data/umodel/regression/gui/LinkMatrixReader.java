package com.altova.umodel.regression.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import static com.altova.util.LoggerUtils.logger;

/**
 * 
 * @author Havard Rast Blok
 *
 */
public class LinkMatrixReader {

	//private List <UMLLink> links = new ArrayList<UMLLink>();
	private String diagram;
	
	private Map<String, UMLElement> elements = new HashMap<String, UMLElement>();
	private Collection<String> uniqueElementNames = new TreeSet<String>();
	private Collection<String> uniqueLinkNames = new TreeSet<String>();
	
	private static final String STARTELEMENT = "StartElement";
	private static final String LINK = "Link";
	private static final String ENDELEMENT = "EndElement";
	private static final String NAME = "name";
	private static final String DIAGRAM = "diagram";
	
	public LinkMatrixReader(File file) throws IOException {
		if(file == null) {
			throw new NullPointerException("File argument cannot be null");
		}
		
		logger.fine("Reading file: "+file);
		readElements(new FileInputStream(file) );
	}

	public LinkMatrixReader(URL file) throws IOException {
		if(file == null) {
			throw new NullPointerException("File argument cannot be null");
		}
		
		logger.fine("Reading URL: "+file);
		readElements(file.openStream());
	}
	
	private void readElements(InputStream stream) throws IOException {
		Document doc = loadDocument(stream);
		Element domRoot = doc.getDocumentElement();
		
		//get all StartElements
		diagram = domRoot.getAttribute(DIAGRAM);
		NodeList startElements = domRoot.getElementsByTagName(STARTELEMENT);
		for(int i = 0; i < startElements.getLength(); i++ ) {
			Element start = (Element) startElements.item(i);
			String name = start.getAttribute(NAME);
			UMLElement ue = new UMLElement(name);
			ue.links = getLinks(start, ue);
			elements.put(name, ue);
			uniqueElementNames.add(name);
		}
			
	}
	
	private Map<String, UMLLink> getLinks(Element start, UMLElement ue) {
		Map<String, UMLLink> ans = new HashMap<String, UMLLink>(); 
		
		NodeList elements = start.getElementsByTagName(LINK);
		for(int i = 0; i < elements.getLength(); i++ ) {
			Element link = (Element) elements.item(i);
			String name = link.getAttribute(NAME);
			UMLLink ul = new UMLLink(name);
			ul.destinations = getDestinations(link);
			ul.from =  ue;
			ans.put(name, ul);
			uniqueLinkNames.add(name);
		}
		
		return ans;
	}
	
	private Map<String, UMLElement> getDestinations(Element link) {
		Map<String, UMLElement> ans = new HashMap<String, UMLElement>(); 
		
		NodeList elements = link.getElementsByTagName(ENDELEMENT);
		for(int i = 0; i < elements.getLength(); i++ ) {
			Element end = (Element) elements.item(i);
			String name = end.getAttribute(NAME);
			UMLElement ue = new UMLElement(name);
			ans.put(name, ue);
		}
		
		return ans;
	}

	public static Document loadDocument(InputStream stream) throws IOException {
		
		Document doc = null;
		
		try {
			doc = getBuilder().parse(stream);
		} catch (Exception e) {
			throw new IOException("Parser Config Error: "+e.getMessage());
		}

		return doc;
	}

	private static DocumentBuilder getBuilder() throws IOException {
		try {
			return DocumentBuilderFactory.newInstance()	.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new IOException("Parser Config: "+e.getMessage());
		}
	}

	public Collection<String> uniqueElementNames() {
		return uniqueElementNames;
	}
	
	public Collection<String> uniqueLinkNames() {
		return uniqueLinkNames;
	}

	public String getDiagram() {
		return diagram;
	}

	public UMLElement getStartElement(String start) {
		return elements.get(start);
	}

}
