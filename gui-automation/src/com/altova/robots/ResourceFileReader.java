package com.altova.robots;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.altova.util.LoggerUtils.logger;

/**
 * This class parses a .RC resource file used in C++. Specifically, the definitions for
 * toolbar buttons is extracted, an associated with its images using the bitmap files
 * defined in the resource file. This means that all these files have to be available
 * to this class in the same structure as they appear in the source code (and CVS).
 * 
 * @author Havard Rast Blok
 *
 */
class ResourceFileReader {

	private static final String BITMAP = "BITMAP";

	private static final String TOOLBAR = " TOOLBAR";
	
	private static final String BEGIN = "BEGIN";
	
	private static final String END = "END";
	
	private static final String BUTTON = "BUTTON";
	
	private static final String STRINGTABLE = "STRINGTABLE DISCARDABLE";

	private List<ToolbarIcons> toolbars = new ArrayList<ToolbarIcons>();
	
	private Map<String, String> stringTables = new HashMap<String, String>();

	private String parentPath;
	
	private boolean singleImages;
	
	private ResourceFileReader(String toolbarIds[], boolean singleImages){
		this.singleImages = singleImages;
		
		// create the objects to hold each toolbar
		for (String id : toolbarIds) {
			toolbars.add(new ToolbarIcons(id));
		}
	}

	/**
	 * Parse the specified resource file and store the extracted information
	 * in the newly constructed ResourceFileReader object.
	 * 
	 * @param file the file to read
	 * @throws ScriptMistakeException if an error occurred while reading the file.
	 */
	ResourceFileReader(File file, String toolbarIds[], boolean singleImages) {
		this(toolbarIds, singleImages);

		parentPath = "file://"+file.getParent()+"/";
		
		try {
			parse(new BufferedReader(new FileReader(file)));
		} catch (IOException e) {
			throw new ScriptMistakeException("Could not read resource file. ", e);
		}
	}

	/**
	 * Parse the specified resource and store the extracted information
	 * in the newly constructed ResourceFileReader object.
	 * 
	 * @param file the file to read
	 * @throws ScriptMistakeException if an error occurred while reading the file.
	 */
	ResourceFileReader(URL resource, String toolbarIds[], boolean singleImages) {
		this(toolbarIds, singleImages);
		
		String protocol = resource.getProtocol();

		if(protocol.equals("jar")) {
			parentPath = "jar:"+getParent(resource)+'/';
		}
		else if(protocol.equals("file")) {
			parentPath = "file://"+getParent(resource)+'/';
		}
		else {
			throw new IllegalArgumentException("Resource protocol not supported: "+protocol);
		}
		
		logger.finest("parent path: "+parentPath);
		try {
			parse( new BufferedReader( new InputStreamReader (resource.openStream())) );
		} catch (IOException e) {
			throw new ScriptMistakeException("Could not read resource file. ", e);
		}
	}
	
	private String getParent(URL url) {
		String tmp = url.getPath();
		int lastSlash = tmp.lastIndexOf('/');
		return tmp.substring(0, lastSlash);
	}
	
	/**
	 * Parse the resource file
	 * 
	 * @param file
	 * @throws IOException
	 */
	private void parse(BufferedReader in) throws IOException {

		String line;
		while ((line = in.readLine()) != null) {

			// search for the toolbar names
			for (ToolbarIcons toolbar : toolbars) {
				if (line.indexOf(toolbar.getId()) != -1) {

					// search for the file paths to the BMP contains the icons
					// These are defined by the name of the toolbar followed by
					// the word BITMAP
					if (line.indexOf(BITMAP) != -1) {
						//get the relative path from inside the resource file,
						//and add the base path from location of the rc file itself
						String path = parentPath+parsePath(line);
						String fixedPath = fixPath(path);
						//logger.info("fixed path: "+fixedPath);
						toolbar.setBitmapFile(new URL(fixedPath));
						
						//if the image contains a single icon
						if(singleImages) {
							toolbar.setIconIds(Collections.singletonList(toolbar.getId()));
							//need to load the images to set its size... hmm...
							BufferedImage img = ImageUtils.readIcon( toolbar.getBitmapFile() );
							toolbar.setIconSize(new Dimension(img.getWidth(), img.getHeight()));
						}
					}
					
					// search for the toolbar definitions
					// These are defined by the name of the toolbar followed by
					// the word TOOLBAR. The following lines lists the names of
					// the icons, one per line, enclosed by BEGIN and END words.
					// it is assumed that these definitions follow the BITMAP
					// path definitions
					if (line.indexOf(TOOLBAR) != -1) {
						//get the icon size
						Dimension dim = parseSize(line);
						toolbar.setIconSize(dim);
						List<String> iconIds = parseToolbar(in);
						toolbar.setIconIds(iconIds);
						//System.out.println("List of toolbars: "+iconIds);
					}
				}
			}
			
			//search for STRINGTABLEs of user readable strings for the button IDs
			
			if (line.indexOf(STRINGTABLE) != -1) {
				//System.out.println("Am I getting here?");
				parseStringTable(in);
			}
			
		}
		
		//now that we've read the whole file, loop through the toolbar and read in the icons
		for (ToolbarIcons toolbar : toolbars) {
			if (toolbar.getBitmapFile() != null && toolbar.getIconsIds().size() > 0) {
				toolbar.loadIcons(toolbar.getIconsIds());
			}
		}
	}

	/**
	 * Parse the line containing the path of the bitmap with the icons. The path
	 * is assumed to be contained in double quotes (")
	 * 
	 * @param line the icon definition line in the .RC file
	 * @return the path of the BMP files containing the icon images
	 */
	private String parsePath(String line) {
		if (line == null) {
			return null;
		}

		int start = line.indexOf('"');
		int end = line.indexOf("\"", start+1);

		// check if we have something in double quotes
		if (start < 0 || end < 0 && end <= start) {
			return null;
		}

		String file = line.substring(start+1, end);
		String url = file.replace('\\', '/').replace("//", "/");
		
		//logger.info("url: "+url);
		return url;
		
	}
	
	/**
	 * Remove .. from path
	 * 
	 * @param path
	 * @return
	 */
	private String fixPath(String path) {
		List<String> parts = new ArrayList<String>();
		Collections.addAll(parts, path.split("/") );
		
		for (int i = 0; i < parts.size(); i++) {
			boolean last = i+1 >= parts.size();
			String next = (!last)?parts.get(i+1):"";
			if(next.equals("..")) {
				parts.remove(i+1);
				parts.remove(i);
				i -= 2;
			}
		}

		String ans = "";
		for (int i = 0; i < parts.size(); i++) {
			boolean last = i+1 >= parts.size();
			ans += parts.get(i);
			if(!last) {
				ans += "/";
			}
		}
		
		return ans;
	}

	/**
	 * Return the size of the icons stored in the BMP file, as defined
	 * in the .RC TOOLBAR line.
	 * 
	 * @param line the initial line of the TOOLBAR list of icon IDs
	 * @return the size of a single icon in the file
	 * @throws IllegalArgumentException if the line did not contain two 
	 * 			comma-delimited numbers 
	 */
	private Dimension parseSize(String line) {
		//remove all letters, underscores and spaces
		String dim = line.replaceAll("[A-Z_ ]", "");
		
		int comma = dim.indexOf(',');
		
		if(comma < 1 || comma > dim.length()) {
			throw new IllegalArgumentException("Could not parse size: "+dim);
		}
		
		int width = Integer.parseInt( dim.substring(0, comma) );
		int height = Integer.parseInt( dim.substring(comma+1) );
		
		return new Dimension(width, height);
	}
	
	/**
	 * Parse a TOOLBAR section of the RC file and return the list
	 * of unique button IDs in the order they appear.
	 * 
	 * @param in the reader for the RC file 
	 * @return a list containing the button IDs
	 * @throws IOException if a reading error occurred
	 */
	private List<String> parseToolbar(BufferedReader in) throws IOException {
		List<String> ids = new ArrayList<String>();
		
		//if the next line is not BEGIN, return empty list
		String line = in.readLine();
		if(line.indexOf(BEGIN) == -1) {
			return ids;
		}
		
		while( (line = in.readLine()) != null) {
			//check if we have reached the end of this toolbar 
			if(line.indexOf(END) == 0) {
				return ids;
			}
			
			//check if we have a button line
			if(line.indexOf(BUTTON) != -1) {
				//remove the word BUTTON and any spaces
				String tmp = line.replace(BUTTON, "").replace(" ", "");
				ids.add(tmp);
				//System.out.println("<<<<<<button:"+tmp);
			}
		}
		
		//should really not get here
		return ids;
	}
	
	/**
	 * Parse the STRINGTABLE sections of the RC file.
	 * The user keys of these tables are extracted and used as keys for the
	 * stringTable map, to lookup the button IDs used in the TOOLBAR tables. 
	 * 
	 * @param in the reader for the RC file 
	 * @throws IOException if a reading error occurred
	 */
	private void parseStringTable(BufferedReader in) throws IOException {
		//if the next line is not BEGIN, return empty list
		String line = in.readLine();
		if(line.indexOf(BEGIN) == -1) {
			//System.out.println("<<<<<<test1");
			return;
		}
		
		while( (line = in.readLine()) != null) {
			//check if we have reached the end of this toolbar 
			if(line.indexOf(END) == 0) {
				return;
			}
			
			//a line defining the user strings is defined by its ID and string,
			//e.g. like this:
			//    ID_ADD_STATE            "State\nState"
			//however, sometimes, the user string is on a separate line, like this:
			//    ID_ADD_ACTIVITY_PARTITION2D 
			//		"ActivityPartition (2 dimensions)\nActivityPartition (2 dimensions)"
			
			//we'll use this strategy:
			//if double quotes are found on the line, separate by them,
			//and assume the first section is the ID (with spaces removed),
			//while the second is the user string, Using only the bit before the \n
			//
			//However, if no double quotes are found, read another line, 
			//combine and apply the same method. 
		
			
			
			//read another line if there is no user string on the current one
			if(line.indexOf('"') == -1) {
				//System.out.println("<<<<<<test2");
				line += in.readLine();
			}
			
			//cut by first double quote
			//remove spaces from id
			int idx1 = line.indexOf('"');
			String id = line.substring(0,idx1).replace(" ", "");
			//System.out.println("<<<<<<test3_id"+id);
			
			//check if we have this id amongst the buttons
			//if not, ignore
			if(!hasId(id)) {
				//System.out.println("<<<<<<test4");
				continue;
			}
			
			//now find the new line marker: \n
			int idx2 = line.indexOf("\\n");
			//System.out.println("<<<<<<test5: "+idx2);
			//System.out.println("<<<<<<test6: "+idx1);
			//check if we're not out of bounds
			if(idx1 < 0 || idx2 < 0) {
				return; 
			}

			//cut out the user readable string
			String userStr = line.substring(idx1+1, idx2);
			//System.out.println("<<<<<<"+userStr);
			
			//add to the Map, with the user string as key
			stringTables.put(userStr, id);
			
		}
	}
	
	/**
	 * Returned the icon image associated with the specified id.
	 * This can be the unique ID as defined in the TOOLBAR list, or the
	 * user string shown in the tool-tip of the application.
	 * If there is no image with this ID, null is returned
	 * 
	 * @param iconString the programmable ID or the user string for the icon
	 * @return the icon as a BufferedImage, or null.
	 */
	BufferedImage getIcon(String iconString) {
		String id = iconString;
		//check if the given id was a user string
		if(stringTables.containsKey(iconString)) {
			id = stringTables.get(iconString);
		}
		
		for(ToolbarIcons toolbar : toolbars) {
			BufferedImage img = toolbar.getIcon(id);
			
			if(img != null) {
				return img;
			}
		}
		
		return null;
	}
	
	protected boolean hasId(String id) {
			for (ToolbarIcons toolbar : toolbars) {
				//System.out.println("getIconsIds" + (toolbar.getIconsIds()));
				if (toolbar.getIconsIds().contains(id)) {
					return true;
				}
			}
		
		return false;
	}

	/**
	 * Returns a list of ToolbarIcons objects held by this ResourceFileReader.
	 * 
	 * @return the ToolbarIcons containing the icons of the specified RC file
	 */
	List<ToolbarIcons> getToolbarIcons() {
		return toolbars;
	}
}
