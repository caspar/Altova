package com.altova.nativegui;

import java.awt.Rectangle;

/**
 * Contains info about a native component or window. Objects of this type is
 * only create by the {@link NativeGUI} class when it retrieves information from
 * the native C++ calls.
 * 
 * @author Havard Rast Blok
 * 
 */
public class ComponentInfo {
	private Rectangle location;
	private String className;
	private String windowText;
	private long hwnd;
	
	/**
	 * Package constructor, to avoid others (than NativeGUI) from creating this object.
	 * 
	 */
	ComponentInfo() {
		//This should not be public; only NativeGUI should create ComponentInfo objects,
		//based on the information retrieved from the native calls. 
	}

	//This should not be public; only NativeGUI should create ComponentInfo objects,
	//based on the information retrieved from the native calls. 
	ComponentInfo(String windowText, String className, Rectangle location, long hwnd) {
		this.windowText = windowText;
		this.className = className;
		this.location = location;
		this.hwnd = hwnd;
	}

	/**
	 * Returns the name of the Windows specific (or BCG) class use for this component.
	 * @return the class name of the component.
	 */
	public String getClassName() {
		return className;
	}
	
	/**
	 * Returns the outer bounds of this component.
	 * @return the location of the component in absolute screen coordinates.
	 */
	public Rectangle getLocation() {
		return location;
	}
	
	/**
	 * Returns the text or description for this component.
	 * 
	 * NOTE: this is known to have some issues, especially, the string is in some
	 * rare cases truncated at the end, for unknown reasons.
	 * 
	 * @return the window text or other description this component contains. 
	 */
	public String getWindowText() {
		return windowText;
	}

	long getHwnd() {
		return hwnd;
	}
	
	void setLocation(Rectangle location) {
		this.location = location;
	}

	public String toString() {
		return "ComponentInfo [text: "+windowText+", class: "+className+", location="+location+"]";
	}
	  
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		ComponentInfo other = (ComponentInfo) obj;

		return 	compare(this.location, other.location) &&
				compare(this.className, other.className) &&
				compare(this.windowText, other.windowText);
	}
	
	private boolean compare(Object thiz, Object other) {
		return thiz == other || (thiz != null && thiz.equals(other));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (location == null ? 0 : location.hashCode());
		hash = 31 * hash + (className == null ? 0 : className.hashCode());
		hash = 31 * hash + (windowText == null ? 0 : windowText.hashCode());

		return hash;
	}

}
