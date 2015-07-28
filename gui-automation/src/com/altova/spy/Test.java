package com.altova.spy;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		System.out.println(System.getProperty("os.version"));
		
		String subname = "Value_Line_Chart";
		 if ((subname.toString().equals("Value_Line_Chart") || subname.toString().equals("Stacked_Area_Chart")) && !isWinXP()){
			System.out.println("OK");
		 }else{ 
			System.out.println("kooooo");
		 }	
	}

	
	public static boolean isWinXP(){
		
		if (System.getProperty("os.version").equals("5.1"))
			return true;
		else
			return false; 	
	}
}
