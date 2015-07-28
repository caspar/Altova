package com.altova.umodel.regression.gui;

import java.util.HashMap;
import java.util.Map;

public class UMLLink {
	public String name;
	
	public UMLElement from;
	
	public Map<String, UMLElement> destinations = new HashMap<String, UMLElement>();
	
	public boolean valid = true;
	
	public UMLLink(String name) {
		this.name = name;
	}
	
}
