package com.altova.examples.java;

public class ClassExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Double"+getName(new Double(3.4)));
		System.out.println("Integer"+getName(new Integer(3)));
		System.out.println("Float"+getName(new Float(3.4)));
		System.out.println("String"+getName(String.class));
	}

	public static String getName(Object o) {
		Class klass = o.getClass();
		return getName(klass) + "value: "+o.toString();
	}
	public static String getName(Class c){
	return c.getName();
	}
}
