package com.altova.robots;

import java.io.File;

import com.altova.robots.ImageRecognitionRobot.PixelCompare;

/**
 * Exception thrown if the specified image could not be found on the captured
 * screen image. It will contain some information about the compare algorithm
 * used and possibly also debugging information about the image recognition.
 * 
 * @author Havard Rast Blok
 * 
 */
public class ImageNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2790439167198881923L;

	private PixelCompare compareState;

	private int ignoredPixels;

	private File screen;

	private File icon;

	private File debug;

	public ImageNotFoundException() {
		super();
	}

	public ImageNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ImageNotFoundException(String s) {
		super(s);
	}

	public ImageNotFoundException(Throwable cause) {
		super(cause);
	}

	public ImageNotFoundException(String string, PixelCompare compareState,
			int ignorePixels) {
		this(string, compareState, ignorePixels, null, null, null);
	}

	public ImageNotFoundException(String string, PixelCompare compareState,
			int ignoredPixels, File screen, File icon, File debug) {
		this(string);
		this.compareState = compareState;
		this.ignoredPixels = ignoredPixels;
		this.screen = screen;
		this.icon = icon;
		this.debug = debug;
	}

	public PixelCompare getCompareState() {
		return compareState;
	}

	public File getDebug() {
		return debug;
	}

	public File getIcon() {
		return icon;
	}

	public int getIgnoredPixels() {
		return ignoredPixels;
	}

	public File getScreen() {
		return screen;
	}

	private String getImageLink(File file, String description) {
		if(file == null) {
			return "No "+description+" image.</br>\n";
		}
		
		return "<a href=\"file://"+file+"\">"+description+" image</a></br>\n";
	}
	
	@Override
	public String getMessage() {
		String msg = super.getMessage();
		msg += "Compare algorithm used: "+((compareState==null)?"No compareState":compareState.name())+". ";
		msg += "Maximum ignored non-matching pixels: "+ignoredPixels+".\n";
		if (screen != null || icon != null || debug != null) {
			msg += "Debug images (order: screen capture, icon search for, debugging image):\n";
			msg += getImageLink(screen, "screen");
			msg += getImageLink(icon, "icon");
			msg += getImageLink(debug, "debug");
		}
		
		return msg;
	}
	
	public String toString() {
		return getMessage();
	}
}
