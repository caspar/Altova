package com.altova.nativegui;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import static com.altova.util.LoggerUtils.logger;
import com.altova.robots.ImageUtils;
import com.altova.robots.ScriptMistakeException;
import com.altova.util.Settings;


/**
 * Java side of the native C++ interface; it presents the static Java
 * methods to access native GUI information.
 * <p>
 * The native methods themselves are all private, the public methods return
 * either a coordinate or the {@link ComponentInfo} class.
 * <p>
 * For this to work, the nativegui.dll has to be on the system PATH. Not
 * the java CLASSPATH, but the Windows PATH. 
 * 
 * @author Havard Rast Blok
 *
 */
public abstract class NativeGUI {

	/**
	 * Whenever the C++ code in NativeGui.h or NativeGui.cpp is updated or
	 * changed, this version number should be increased.
	 */
	private static final int CURRENT_VERSION = 7;

	private static Rectangle screenSize = ImageUtils.getDefaultScreenDimension();
	
	static {
		//always load the dll
		if(Settings.isX64OS()){
			System.loadLibrary("NativeGUI_x64");	
		}else{
			System.loadLibrary("NativeGUI");
		}
		
		String msg = "\n\n\n\n\nYOU HAVE THE WRONG NativeGUI.DLL INSTALLED. \n"+ 
					 "Please get the latest from CVS, and add the directory where it is located to the system environment variable PATH.\n"+
					 "(In Eclipse, you can set the 'Native library location' under Project Properties -> Java Build Path -> Source.\n\n\n\n\n";
		
		try {			
			if( NativeGUI.getVersion() != CURRENT_VERSION ) {
				logger.severe(msg);
				throw new ScriptMistakeException( msg );
			}
		}
		catch( UnsatisfiedLinkError e ) {
			logger.severe(msg);
			throw new ScriptMistakeException( msg, e );
		}
	}
	
	//the native calls, all kept private
	private static native String[] getWindowRect(int x, int y);

	private static native String[] getForegroundWindow();

	private static native String[] getCursorPos();
	
	private static native int getVersion();

	private static native String[][] getWindowInfo();
	
	private static native void showWindow(long hwnd);
	
	/**
	 * Returns the current mouse cursor position, where 0,0 is
	 * the upper, left corner of the primary monitor.  
	 * 
	 * @return current position of the mouse cursor.
	 */
	public static Point getCursorPostion() {
		String pos[] = getCursorPos();
		int x = Integer.parseInt(pos[0]);
		int y = Integer.parseInt(pos[1]);

		return new Point(x, y);
	}

	/**
	 * Switch to the window of the specified {@link ComponentInfo} 
	 * 
	 * @param ci a ComponentInfo for a Windows native window/application 
	 */
	public static void switchToWindow(ComponentInfo ci) {
		showWindow(ci.getHwnd());
	}
	
	/**
	 * Gets a list of running applications, as seen in the Applications tab in the Windows
	 * Task Manager.
	 * 
	 * WARNING: This will NOT tell if an application is still resident in memory or not.
	 * 
	 * @return a list containing at least the windows in the Application list, but possibly
	 * some other processes as well.
	 */
	public static List<ComponentInfo> getApplicationList() {
		List<ComponentInfo> ans = new ArrayList<ComponentInfo>();
		
		String apps[][] = getWindowInfo();
		for(String a[] : apps) {
			ans.add(getInfo(a));
		}
		
		return ans;
	}
	
	/**
	 * Parses the info array coming back from the native methods
	 * and returns a {@link ComponentInfo} object.
	 * 
	 * @param info array corresponding to fields in the C++ code. 
	 * @return {@link ComponentInfo} containing the same info
	 */
	private static ComponentInfo getInfo(String info[]) {
		String windowText = info[0];
		String className = info[1];
		int left = Integer.parseInt(info[2]);
		int top = Integer.parseInt(info[3]);
		int right = Integer.parseInt(info[4]);
		int bottom = Integer.parseInt(info[5]);
		long hwnd = Integer.parseInt(info[6]);
		
		Rectangle location = new Rectangle(left, top, right - left, bottom - top);
		ComponentInfo ans = new ComponentInfo(windowText, className, location, hwnd);
		
		return ans;
	}

	private static void checkMaximized(ComponentInfo ci) {
		Rectangle cur = ci.getLocation();
		if(	cur.x < 0 || cur.y < 0 ||
			cur.width > screenSize.width || cur.height > screenSize.height) {
			//logger.finest("checkMaximized - adjusting ComponentInfo size: "+ci);
			
			Point mid = ImageUtils.findMid(cur);
			
			int x = cur.x; for( ;!insideComponent(x, mid.y, ci) && x<mid.x; x++);
			int y = cur.y; for( ;!insideComponent(mid.x, y, ci) && y<mid.y; y++);
			int width = cur.x+cur.width; for( ;!insideComponent(width, mid.y, ci) && width > mid.x; width--);
			int height = cur.y+cur.height; for( ;!insideComponent(mid.x, height, ci) && height > mid.y; height--);
			
			Rectangle newSize = new Rectangle(x, y, width, height);
			if(newSize.height < cur.height/2 || newSize.width < cur.width/2) {
				//logger.finest("Something went wrong, leaving size as it is after all...");
			}
			else {
				ci.setLocation(newSize);
				//logger.finest("checkMaximized - new size: "+ci.getLocation());
			}
		}
	}
	
	private static boolean insideComponent(int x, int y, ComponentInfo ci) {
		ComponentInfo other = getWindowInfo(x, y);
		if(other.equals(ci)) {
			return true;
		}
		
		Rectangle l = other.getLocation();
		boolean contains = ci.getLocation().contains(l);
		return contains;
	}

	/**
	 * Returns info about the native Windows window which currently
	 * has focus. If this is a modal dialog of an application, this
	 * dialog is usually seen as the foreground window.
	 * 
	 * @return info about the foreground native window.
	 */
	public static ComponentInfo getForegroundWindowInfo() {
		ComponentInfo ans = getInfo(getForegroundWindow());
		
		//If a window is in maximized mode, the reported boundaries might be wrong.
		//usually, the window will be reported as being outside the screen,
		//or technically, I guess the resize bars are outside
		//here we'll check and adjust for that
		checkMaximized(ans);
		return ans;
	}

	/**
	 * Returns info about the native Windows component at the specified
	 * location. This can return a lot of different components, depending
	 * on where you hit. You might get the full window, if you hit the
	 * title bar, or you might get a scroll bar. However, not all applications
	 * present their scroll bar as a separate component, so then you'll just
	 * get a generic edit component instead.
	 * 
	 * Regardless of what you get back though, UNDER NO CIRCOMSTANCES RELY ON
	 * ANY OF THE NUMBERS IN THE TEXT YOU GET BACK. THIS WILL MOST CERTAINLY
	 * CHANGE. THIS WAS THE DOWNFALL OF Test Complete.  
	 * 
	 * @param x screen coordinate of component - top is 0
	 * @param y screen coordinate of component - left on primary monitor is 0
	 * @return {@link ComponentInfo} about the component at specified location
	 */
	public static ComponentInfo getWindowInfo(int x, int y) {
		return getInfo(getWindowRect(x, y));
	}

	public static List<ComponentInfo> getAllComponents() {
		Rectangle dim = ImageUtils.getDefaultScreenDimension();
		return getAllComponents(dim);
	}
	
	public static List<ComponentInfo> getAllComponents(Rectangle r) {
		int step = 5;
		
		List<ComponentInfo> ans = new ArrayList<ComponentInfo>();
		
		logger.finest("getAllComponents( "+r+" )");
		for (int y = r.y; y < r.y+r.height; y+=step) {
			for (int x = r.x; x < r.x+r.width; x+=step) {
				ComponentInfo info = NativeGUI.getWindowInfo(x, y);
				if(!ans.contains(info)) {
					//logger.finest("Found: "+info);
					ans.add(info);
				}
			}
		}
		//logger.finest("Finished searching for components.");
		return ans;
	}
	
	public static int getCursorId() {
		throw new ScriptMistakeException("This method is not finished");
		//return getCursor();
	}
	
	/**
	 * Main method for testing.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		if (args.length != 2) {
			args = new String[2];
			args[0] = "2";
			args[1] = "2";
		}

		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		
		String info1[] = getWindowRect(x, y);
		for (String i : info1) {
			System.out.println(i);
		}

		String info[] = getForegroundWindow();
		for (String i : info) {
			System.out.println(i);
		}

		//while (true) {

			String pos[] = getCursorPos();
			x = Integer.parseInt(pos[0]);
			y = Integer.parseInt(pos[1]);
			System.out.print("" + x + ", " + y + " - ");

			info1 = getWindowRect(x, y);
			for (String i : info1) {
				System.out.print(i + ", ");
			}
			System.out.println();

			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}

		//}
		
		String a [][] = NativeGUI.getWindowInfo();		
		System.out.println("here..." + a.toString());
		for(int i = 0; i < a.length; i++) {			
			for(int j = 0; j < a[i].length; j++) {
				System.out.println("i,j : " + i + "," + j + " : " + a[i][j]);
			}
		}
		switchToWindow(getInfo(a[5]));
		
	}
}
