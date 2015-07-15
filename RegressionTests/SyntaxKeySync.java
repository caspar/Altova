package com.altova.umodel.regression.functional;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Vector;

//import net.hblok.io.AndFileFilter;
//import net.hblok.io.DirectoryFileFilter;
import net.hblok.io.FileFilterUtils;
import net.hblok.io.FilterAdapter;
import net.hblok.io.NegateFileFilter;
import net.hblok.io.RegexFilenameFilter;

import com.altova.robots.ScriptMistakeException;

public class SyntaxKeySync {

	private static final String STRINGABLE = "STRINGTABLE DISCARDABLE";
	private static final String STRING_BEGIN = "BEGIN";
	private static final String STRING_END = "END";
	
	public SyntaxKeySync(String key) { }
	
	public Set<String> collectKeysFromTestCaseDir(File fInput) {
				
		Set<String> set = new TreeSet<String>();
		
		List<File> files = filterCVS(fInput, false) ;
		for(File f : files) {
			if(!f.getName().endsWith(".txt")) {
				//	prefix
//				set.add(f.getName().replaceFirst("[0-9]{3}_", "").replaceFirst(".ump", ""));
				
				//	suffix, language specified				
				set.add(f.getName().replaceFirst(".ump", "").replaceFirst("_[0-9]{3}?(_(JAVA|CSHARP|VB))?", ""));
				
			}
		}			
		return set ;
	}
	
	public Set <String> collectKeysFromRC(File f) throws IOException {
		Set <String> set = new TreeSet<String> ();

		boolean collect = false ;
		 
		FileInputStream fis = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader in = new BufferedReader(isr);

		try {			
			while(in.ready()) {
				String l = in.readLine() ;
				if((!l.equals("")) && l.contains(STRINGABLE)) {
					
					String k = in.readLine() ; 
					if(k.equals(STRING_BEGIN)) collect = true; 	// notify collection flag						
					
					
					while(collect) {
						k = in.readLine().trim() ;
						if(k.equals(STRING_END)) collect = false; // stop collecting keys
		
						else {													
							if(!k.startsWith("\""))	{								
								if(k.contains(" ")) k = k.substring(0, k.indexOf(" ")) ;								 
			
								set.add(k) ; //key tokens only (first)
							}
						}
					}
				}
			}
		}
		finally {
			if(in != null) {
				in.close();
				isr.close();
				fis.close();
			}
		}
		return set;		
	}
	
	private List<File> filterCVS(File src, boolean recurse) {
//		DirectoryFileFilter dirs = new DirectoryFileFilter();
		RegexFilenameFilter cvs = new RegexFilenameFilter("CVS");
		FilterAdapter fd = new FilterAdapter(cvs);
		NegateFileFilter notcvs = new NegateFileFilter(fd);
//		AndFileFilter and = new AndFileFilter(dirs, notcvs);
		return FileFilterUtils.listfiles(src, notcvs, recurse);		
	}	
	
	public Map<String, String> getSyntaxTestsNotCovered(Set<String> keys, File f_rc) throws IOException {
		Map <String, String> map = new HashMap <String, String> ();
		String k = "";
		String v = "";
		boolean collect = false ;

		FileInputStream fis = new FileInputStream(f_rc);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader in = new BufferedReader(isr);

		try {			
			while(in.ready()) {
				String l = in.readLine() ;
				if((!l.equals("")) && l.contains(STRINGABLE)) {
					
					String line = in.readLine().trim() ;
					if(line.equals(STRING_BEGIN)) collect = true; 	// notify collection flag					
					
					while(collect) {
						line = in.readLine().trim() ;
						if(line.equals(STRING_END)) collect = false; // stop collecting keys
		
						else {
							if(!line.startsWith("\""))	{ //key first, then value, perhaps.
								
								StringTokenizer tok = new StringTokenizer(line);
								
								if( tok.countTokens() > 0 ) {
									k = tok.nextToken(" ");
									// value = line - key
									v = line.substring( k.length() , line.length() ).trim() ;
									
									//if this line contains only key, next contains only value
									if(v.equals("")) v=in.readLine().trim() ;
								}
							}
							else {
								v = line; //only value present, take whole line as v.
							}
							if(k.equals("") || v.equals("") ) { 
								throw new ScriptMistakeException("key value pairs not properly ordered or parsed from rc file...") ; 
							}
							if(!keys.contains(k)) {
								map.put(k, v) ;
							}
						}
					}
				}
			}
		}		
		finally {
			if(in != null) {
				in.close();
				isr.close();
				fis.close();
			}
		}
		return map;
	}
	
	public Map<String, Map<String, String>> seperateKeys(Map<String, String> map) {
		
		Map<String, Map<String, String>> result = new HashMap<String, Map<String, String>>();
		
		Map<String, String> map_SyntaxTestCases= new HashMap<String, String>();
		Map<String, String> map_NOT_SyntaxTestCases = new HashMap<String, String>();
		Map<String, String> map_UNCERTAIN_SyntaxTestCases = new HashMap<String, String>();
		
		Iterator<String> i = map.keySet().iterator() ;
		
		while(i.hasNext()) {
			String key = i.next();
			if ( 
					(key.contains("INVALID") 
					|| key.contains("AMBIGUOUS") 
					|| key.contains("MISSING") 
					|| key.contains("ILLEGAL")
					|| key.contains("ERROR")
					|| key.contains("UNUSED"))
				)	{				
				map_SyntaxTestCases.put(key, map.get(key)) ;
			}
			else if (key.contains("KIND")) {
				
				map_NOT_SyntaxTestCases.put(key, map.get(key)) ;
			}
			else {
				map_UNCERTAIN_SyntaxTestCases.put(key, map.get(key)) ;
			}			
		}

		result.put(UModelTestTypes.SYNTAX_ERRORS, map_SyntaxTestCases) ;
		result.put(UModelTestTypes.NOT_SYNTAX_ERRORS, map_NOT_SyntaxTestCases) ;
		result.put(UModelTestTypes.UNCERTAIN_SYNTAX_ERRORS, map_UNCERTAIN_SyntaxTestCases) ;
		
		return result ;
	}

	public Set<String> collectKeysFromFile(File f) throws IOException {
		Set <String> set = new TreeSet<String> ();
		 
		FileInputStream fis = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader in = new BufferedReader(isr);

		try {			
			while(in.ready()) {
				String l = in.readLine() ;
					set.add(l) ; //key tokens only 
			}
		}
		finally {
			if(in != null) {
				in.close();
				isr.close();
				fis.close();
			}
		}
		return set;		
	}
	
}
