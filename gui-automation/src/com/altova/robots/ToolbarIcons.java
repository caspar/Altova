package com.altova.robots;
import static com.altova.util.LoggerUtils.logger;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a container class for holding the meta data and image data for a toolbar
 * and its icons. Before the loadIcons(...) method is called, the bitmapFile and 
 * iconSize fields must be set.
 * 
 * @author Havard Rast Blok
 *
 */
 class ToolbarIcons {
	
	/**
	 * The unique name of the toolbar.
	 */
	private String id;
	
	/**
	 * The BMP file holding the images of the icons for the toolbar buttons.
	 */
	private URL bitmapFile;
	
	/**
	 * Map between button IDs and the icon images. 
	 */
	private Map<String, BufferedImage> icons = new HashMap<String, BufferedImage>();
	
	private List<String> iconIds = new ArrayList<String>();
	
	/**
	 * The size of each icon in pixels.
	 */
	private Dimension iconSize;
	
	/**
	 * Construct a ToolbarIcons object with the specified id.
	 * @param id
	 */
	 ToolbarIcons(String id) {
		this.id = id;
	}
	
	/**
	 * Reads the list of icon images from the bitmap file specified by bitmapFile.
	 * The list of strings passed to this method is assumed to be in the same order
	 * and of the same number as the icon images in the BMP file.
	 * 
	 * @param iconIds list of icon IDs from the .RC file
	 * @throws IOException if a reading error occurred.
	 * @throws IllegalStateException if the bitmapFile field was null.
	 */
	 void loadIcons(List<String> iconIds) throws IOException {
		if(bitmapFile == null) {
			throw new IllegalStateException("The bitmapFile field was null. Set bitmap filename before loading icons.");
		}
		
		if(iconSize == null) {
			throw new IllegalStateException("The iconSize field was null. Set iconSize before loading icons.");
		}
		
		//load the BMP with icons
		BufferedImage bitmap = ImageUtils.readIcon(bitmapFile);
		
		//check if we'll have to redraw the image, to use a 4 byte color space, including alpha
		bitmap = ImageUtils.enableTransperancy(bitmap);
		
		//for each given id in the list, cut out a section from the bitmap
		//and store it in the Map with the icon ID as key
		int x = 0;
		try {
			for(String id : iconIds) {
				//logger.info("Got here: "+id);
				BufferedImage icon = bitmap.getSubimage(x, 0, iconSize.width, iconSize.height);
				ImageUtils.setBackgroundTransperency(icon);
				icons.put(id, icon);
				x += iconSize.width;
			}
		} catch(RasterFormatException e) {
			throw new ScriptMistakeException("Error while reading "+bitmapFile+". x="+x, e);
		}
		
		
	}

	/**
	 * Returns the icon image associated with the specified ID string.
	 * The ID is the unique programmable variable used in the TOOLBAR definition list
	 * of the .RC file
	 * 
	 * @param id unique variable name ID for the icon
	 * @return image the image for the specified icon ID
	 */
	 BufferedImage getIcon(String id) {
		return icons.get(id);
	}

	/**
	 * 
	 * 
	 * @return
	 */
	 URL getBitmapFile() {
		return bitmapFile;
	}

	/**
	 * 
	 * @param bitmapFile
	 */
	 void setBitmapFile(URL bitmapFile) {
		this.bitmapFile = bitmapFile;
	}

	/**
	 * Returns the unique name of the toolbar held by this ToolbarIcons instance.
	 * @return name of the toolbar.
	 */
	 String getId() {
		return id;
	}

	/**
	 * Returns the size of each icon in pixels.
	 * @return size of each icon image.
	 */
	 Dimension getIconSize() {
		return iconSize;
	}

	/**
	 * Sets the size of one icon in pixels.
	 * @param iconSize Dimension of one image in pixels. 
	 */
	 void setIconSize(Dimension iconSize) {
		this.iconSize = iconSize;
	}

	/**
	 * 
	 * @return
	 */
	 List<String> getIconsIds() {
		return iconIds;
	}

	 void setIconIds(List<String> iconIds) {
		this.iconIds = iconIds;
	}

	
}
