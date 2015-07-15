package com.altova.umodel.regression.functional;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.altova.robots.ScriptMistakeException;

public class SyntaxKeySyncEntryPoint {
	public static void main(String[] args) {
		System.out.println("starting syntax check synchronization...");

		SyntaxKeySync syn = new SyntaxKeySync(UModelTestTypes.SYNTAX_CHECK_SYNC);

		try {
			File dir = getFileFromArg(args[0]);
			File f = getFileFromArg(args[1]);
			File notTestsList = getFileFromArg(args[2]);
			File uncertainTestsList = getFileFromArg(args[3]);			
			
//			Set<String> rcKeys = syn.collectKeysFromRC(f);			
			Set<String> negate = new TreeSet<String>() ;
			
			if( ! (notTestsList == null)) {		
				Set<String> notTestsKeys = syn.collectKeysFromFile(notTestsList) ;
				if( ! notTestsKeys.isEmpty())	negate.addAll(notTestsKeys) ;
			}
			
			if( ! (uncertainTestsList == null)) {
				Set<String> uncertainTestsKeys = syn.collectKeysFromFile(uncertainTestsList ) ;
				if( ! uncertainTestsKeys.isEmpty())	negate.addAll(uncertainTestsKeys) ;
			}
			if( ! (dir == null)) {
				Set<String> fileKeys = syn.collectKeysFromTestCaseDir(dir);
				if( ! fileKeys.isEmpty())	negate.addAll(fileKeys) ;
			}			
			
			Map<String, String> m = syn.getSyntaxTestsNotCovered(negate, f) ;
			Map<String, Map<String,String>> setNotCovered = syn.seperateKeys(m) ;
			
			printToScreen(setNotCovered) ;
			printToFile(setNotCovered) ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	private static void printToScreen(Map<String, Map<String, String>> set) {
		Map<String, String> which = new HashMap<String, String>() ;			
		Iterator<String> i = set.keySet().iterator() ;						
		while(i.hasNext()) {
			String s = i.next() ;
			
			if (s.equals(UModelTestTypes.SYNTAX_ERRORS)) which = set.get(s) ;				
			if (s.equals(UModelTestTypes.NOT_SYNTAX_ERRORS)) which = set.get(s) ;				
			if (s.equals(UModelTestTypes.UNCERTAIN_SYNTAX_ERRORS)) which = set.get(s) ;
			
			
			if(which.size() > 0) {
				Iterator<String> mapIter = which.keySet().iterator() ;
				System.out.println("*********************************************************") ;
				System.out.println("************	" + s + "	SIZE:	" + which.size());
				System.out.println("*********************************************************") ;
				while(mapIter.hasNext()) {
					String k = mapIter.next() ;
					String v = which.get(k) ;
					System.out.println("key : " + k ) ; 
					System.out.println("val : " + v + "\n") ;
				}					
			}
		}
		
	}
	private static void printToFile(Map<String, Map<String, String>> set) throws IOException {
	
		Map<String, String> which = new HashMap<String, String>() ;			
		Iterator<String> i = set.keySet().iterator() ;						

		File out = new File("../test-cases/syntax_check/SyntaxCheckTests-todo.txt");
		out.createNewFile() ;
		FileWriter fw = new FileWriter(out);
		
		while(i.hasNext()) {
			String s = i.next() ;
			
			if (s.equals(UModelTestTypes.SYNTAX_ERRORS)) which = set.get(s) ;				
			if (s.equals(UModelTestTypes.NOT_SYNTAX_ERRORS)) which = set.get(s) ;				
			if (s.equals(UModelTestTypes.UNCERTAIN_SYNTAX_ERRORS)) which = set.get(s) ;
			
			if(which.size() > 0) {			
				Iterator<String> mapIter = which.keySet().iterator() ;

				fw.write("*********************************************************\n") ;
				fw.write("************	" + s + "	SIZE:	" + which.size() + "\n");
				fw.write("*********************************************************\n") ;
				while(mapIter.hasNext()) {
					String k = mapIter.next() ;
					fw.write("key : " + k + "\n") ;
					fw.write("val : " + which.get(k) + "\n") ;
					fw.write("\n") ;				
				}
			}
		}
		fw.close() ;		
	}

	private static File getFileFromArg(String arg) {
		File f = new File(arg);
		if (f.exists()) return f ;
		else throw new ScriptMistakeException("path not properly specified in ant build.xml: " + arg) ;
	}

}
