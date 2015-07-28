package com.altova.umodel.regression.gui;

import java.util.HashMap;
import java.util.Map;

public class UMLElement {
	public String name;
	
	public Map<String, UMLLink> links = new HashMap<String, UMLLink>();
	
	public String diagram;
	
	public UMLElement(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}

	public UMLLink getLinkType(String linkType) {
		return links.get(linkType);
	}
	
}
