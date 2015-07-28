package com.altova.util;

public class testxml {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		XMLFileReader myxml = new XMLFileReader("test\\com\\altova\\stylevision\\properties.xml");
		System.out.println("XMLReader initialized");
		
		String [] totalFile = myxml.getAllValueOfNode("test","filename");
		String [] totalPath = myxml.getAllValueOfNode("test","directory");
		
		System.out.println("Total of test to do: " + myxml.getNodeLength("test"));
		
		for (int i = 0; i < totalFile.length; i++) {
			
			System.out.println("File: " + totalFile[i] + " and path:" + totalPath[i]);
			
		}
		
		String value = myxml.getValueOfNode("test","directory") + "\\" + myxml.getValueOfNode("test","filename");
		System.out.println("1st test is available in: "  + value);
		
	}

}
