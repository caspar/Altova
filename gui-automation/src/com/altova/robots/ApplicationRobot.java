package com.altova.robots;

import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.VK_ALT;
import static java.awt.event.KeyEvent.VK_DELETE;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_F4;
import static java.awt.event.KeyEvent.VK_HOME;
import static java.awt.event.KeyEvent.VK_N;
import static java.awt.event.KeyEvent.VK_END;
import static java.awt.event.KeyEvent.VK_BACK_SPACE;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.altova.nativegui.ComponentInfo;
import com.altova.nativegui.NativeGUI;
import com.altova.spy.VSnetSpyRobot;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.IOUtils;
import com.altova.util.LoggerUtils;
import com.altova.util.ProcessStreamReader;
import com.altova.util.RegressionAssert;
import com.altova.util.Settings;

/**
 * Robot specialised for general Windows applications.
 * It contains auxiliary and GUI methods common to all the specific application robots.
 * 
 * @author Havard Rast Blok
 *
 */
public class ApplicationRobot extends ImageRecognitionRobot {

	private String appName;
	
	protected File appPath;
	
	protected String appExe;
	
	protected Map<String, Integer[]> escapeDialogActions = new HashMap<String, Integer[]>();
	
	//images used for scrolling the scrollbar
	private final String BAR_TOP_IMG = "bar_top.png";
	private final String BAR_BOTTOM_IMG = "bar_bottom.png";
	protected final String BAR_ENABLED_UP = "bar_enabled_up.png";
	protected final String BAR_ENABLED_DOWN = "bar_enabled_down.png";
	
	
	/**
	 * Constructs an {@code ApplicationRobot} for a specific application.
	 * 
	 * @param appName the name of the application, as shown in the taskbar 
	 * 				 (for Altova applications, do not include 'Altova' in this string).  
	 * @param appPath the installation path of the application, where the {@code appExe} is found.
	 * @param appExe the name of the EXE file to start the application (not the full path)
	 */
	public ApplicationRobot( String appName, File appPath, String appExe) {
		this.appName = appName;
		this.appPath = appPath;
		this.appExe = appExe;
		
		logger.config("Constructed robot for "+appName+" ("+getClass().getName()+"). \n"+
					"Expected application path: "+appPath+File.separator+appExe+"\n"+
					"Environment: \n"+
					"Java version:\t"+System.getProperty("java.version")+"\n"+
					"Java Classpath:\t"+System.getProperty("java.class.path")+"\n"+
					"System path:\t"+System.getProperty("java.library.path")+"\n"+
					"OS name:\t"+System.getProperty("os.name")+"\n"+
					"OS architecture:\t"+System.getProperty("os.arch")+"\n"+
					"OS version:\t"+System.getProperty("os.version")+"\n"
					);
	}
	
	
	/**
	 * Search the foreground window for a component with the specified text, and
	 * return its location. Examples of text on components include the windows
	 * names, e.g. Project, Validation, XPath. But also some GUI objects like
	 * text fields and buttons (but not always). If multiple occurrences are
	 * found, the first is returned.
	 * 
	 * @param windowText
	 *            the text of the component to find.
	 * @return the location of the first component with the given text, or null
	 *         if not found.
	 */
	public Rectangle findComponentName(String windowText) {
		return findComponent(windowText, null, null);
	}

	/**
	 * Search the foreground window for a component with the specified class
	 * name, and return its location. Examples of class names on components
	 * include the MenuBar, BCGToolbar, e.g. If multiple occurrences are found,
	 * the first is returned.
	 * <p>
	 * <b>WARNING</b>
	 * <p>
	 * EXTREME CARE SHOULD BE TAKEN WHEN USING THIS METHOD. THE DOWNFALL OF Test
	 * Complete WAS RELYING ON SPECIFIC CLASS NAMES, INCLUDING OBSCURE OBJECT
	 * IDs. As a general rule, there should be no numbers included in the string
	 * passed to this method.
	 * 
	 * @param className
	 *            the class name of the component to find.
	 * @return the location of the first component with the given text, or null
	 *         if not found.
	 */
	public Rectangle findComponentClass(String className) {
		return findComponent(null, className, null);
	}
	
	/**
	 * Search the foreground window for a component with the specified text and
	 * class name, and return its location. If multiple occurrences are found,
	 * the first is returned.
	 * 
	 * <p>
	 * <b>WARNING</b>
	 * <p>
	 * EXTREME CARE SHOULD BE TAKEN WHEN USING THIS METHOD. THE DOWNFALL OF Test
	 * Complete WAS RELAYING ON SPECIFIC CLASS NAMES, INCLUDING OBSCURE OBJECT
	 * IDs. As a general rule, there should be no numbers included in the class
	 * name string passed to this method.
	 * 
	 * @param windowText
	 *            the text of the component to find.
	 * @param className
	 *            the class name of the component to find.
	 * @param hint
	 *            the area on screen to search in
	 * @return the location of the first component with the given text and class
	 *         name, within the given area, or null if not found.
	 */
	public Rectangle findComponent(String windowText, String className, Rectangle hint) {
		List<Rectangle> list = findComponents(windowText, className, hint);
		
		if (this instanceof VSnetSpyRobot && className != null && className.equals("XMLSpy_scintilla") && 
			list != null & list.size() > 1){
			/*
			 * Special case to manage the Scintilla field (XPath): bug introduced with VS2010 implementation
			 * not by me 
			 */
			return list.get(1);
			
		}else if(list != null & list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * Search the foreground window for all components with the specified text and
	 * class name, and return their locations. 
	 * 
	 * <p>
	 * <b>WARNING</b>
	 * <p>
	 * EXTREME CARE SHOULD BE TAKEN WHEN USING THIS METHOD. THE DOWNFALL OF Test
	 * Complete WAS RELAYING ON SPECIFIC CLASS NAMES, INCLUDING OBSCURE OBJECT
	 * IDs. As a general rule, there should be no numbers included in the class
	 * name string passed to this method.
	 * 
	 * @param windowText
	 *            the text of the components to find.
	 * @param className
	 *            the class name of the components to find.
	 * @param hint
	 *            the area on screen to search in
	 * @return the location of all the components with the given text and class
	 *         name, within the given area, or null if not found.
	 */
	public List<Rectangle> findComponents(String windowText, String className, Rectangle hint) {
		logger.finer("findComponent( "+windowText+", "+className+", "+hint+" )");
		if(windowText == null && className == null) {
			throw new ScriptMistakeException("Both windowText and className cannot be null");
		}
		
		if(className != null && className.toLowerCase().indexOf("BCGControlBar".toLowerCase()) > -1) {
			//but now they're suddenly the same again... why???
			//throw new ScriptMistakeException("Please do not relay on the BCGControlBar as a class name. "+
			//								 "On the Virtual Machines, this class will be called something else...");
			logger.warning("Using BCGControlBar class name. Is might cause issues on the Virtual Machines...");
		}
		
		Rectangle search = null;
		if(hint != null) {
			search = hint;
			
			if(hint.x < -5 || hint.y < -5) {
				logger.warning("The hint to findComponents is negative: "+hint+
						"\n"+IOUtils.getStackTrace(new RuntimeException()));
			}
		}
		else {
			delay(1500);
			search = NativeGUI.getForegroundWindowInfo().getLocation();
			logger.finest("Foreground window location: "+search);
		}
		List<ComponentInfo> cmps = NativeGUI.getAllComponents(search);
		List<ComponentInfo> filtered = filterComponents(cmps, windowText, className);
		List<Rectangle> ans = new ArrayList<Rectangle>();
		
		for(ComponentInfo info : filtered) {
			ans.add(info.getLocation());
		}
		return ans;
	}
	
	private List<ComponentInfo> filterComponents(List<ComponentInfo> cmps, String windowText, String className) {
		List<ComponentInfo> ans = new ArrayList<ComponentInfo>();
		
		for(ComponentInfo info : cmps) {
			if(windowText == null || className == null ) {
				if(windowText == null && info.getClassName().indexOf(className) > -1 ) {
					
					ans.add( info );
					
				}else if (Settings.isVS2010() && info.getClassName().contains("HwndWrapper[DefaultDomain;;") && windowText == null && info.getLocation().x > 0 && info.getLocation().y > 0){
					//}else if (Settings.isVS2010() && info.getClassName().startsWith("ComponentInfo [text: , class: HwndWrapper[DefaultDomain;;") && windowText == null){
						//logger.fine("!!!!!ONLY added to info list x VS2010<" + info + "> windowText<" + windowText + ">" + "getLocation:" + info.getLocation().x);
						ans.add( info );
				}
				else if (className == null && info.getWindowText().indexOf(windowText) > -1 ) {
					ans.add( info );
					//logger.fine("other added to info list:" + info + ":");
				}
			}
			else if (info.getClassName().indexOf(className) > -1 && 
					info.getWindowText().indexOf(windowText) > -1) {
				//logger.fine("other2 added to info list:" + info + ":");
				ans.add( info );
			}
		}
			
		return ans;

	}
	
	public Rectangle findMenuBar(String menu) {
		Rectangle ans = findComponentName("Menu Bar");

//		the following just happens for the eclipse integrations
		
		if (ans == null) {
			logger.finer("Could not find menu bar");
			Rectangle fileMenu=null;
			if(Settings.isVS2010()){
				fileMenu = findString(menu,WINDOWS_DEFAULT_FONT,GRAY_IN_VS2010_MENU);
			}else{
				fileMenu = findString(menu);
			}
			//we need to calculate the application's width and we use the file menu's height
			ComponentInfo ci = NativeGUI.getForegroundWindowInfo();
			Rectangle appLocation = ci.getLocation();
			ans = new Rectangle(fileMenu.x, fileMenu.y,appLocation.width,fileMenu.height);
		}

		return ans;
	}
	//This method is needed to test VS2010, as other colors are used in the User Interface 
	public Rectangle findMenuBar(Color fontcolor,String menu) {
		Rectangle ans = findComponentName("Menu Bar");

//		the following just happens for the eclipse integrations
		
		if (ans == null) {
			logger.finer("Could not find menu bar");
			Rectangle fileMenu = findString(menu,WINDOWS_DEFAULT_FONT, TRANSPARENT, fontcolor);
			//we need to calculate the application's width and we use the file menu's height
			ComponentInfo ci = NativeGUI.getForegroundWindowInfo();
			Rectangle appLocation = ci.getLocation();
			ans = new Rectangle(fileMenu.x, fileMenu.y,appLocation.width,fileMenu.height);
		}

		return ans;
	}
	
	/**
	 * Returns the location of the main window of the application under test.
	 * This might vary between applications, so different strategies are
	 * required to find it. In general though, it is the window/component which
	 * is the biggest one within the application, and covers the area pretty
	 * much in the center of the application window. In some cases, it is
	 * possible to determine if an actual "work area" is present, or just the
	 * gray and empty multiple documents background.
	 * 
	 * @return The boundaries of the main window area in the application under test.
	 */
	public Rectangle getMainWindow() {
		ComponentInfo big = getDiagramComponent();
		if (big == null) {

			throw new ScriptMistakeException("There is no file or diagram open");
		}
		return big.getLocation();
	}
	
	/**
	 * Clicks the specified menu item with the left mouse button.
	 * You can drill down into sub menus by specifying a list of menu items which leads to the last one.
	 * 
	 * Examples:
	 * leftClickMenuItem( "File", "Open" );
	 * leftClickMenuItem( "Layout", "Align", "Left" );
	 * leftClickMenuItem( "View", "Favorites & Mode Tree", "Sort", "Operations", "by Name" );
	 * 
	 * @param menu the name of the menu on the top menubar
	 * @param items the name of the menu items or sub menus
	 */
	public void leftClickMenuItem(String menu, String... items) {
		leftClickMenuItem(Color.BLACK, menu, items);
	}
	
	//This method is needed for testing VS2010
	public void leftClickMenuItem(Color fontcolor,String menu, String... items) {
		String menu1=menu;
		if(menu==null){
			 menu1=items[0];
		}
		//first try to find the menu bar
		Rectangle menubar = findMenuBar(fontcolor,menu1);
		Rectangle menuLocation = null;
		
		//click the menu at the menubar
		menuLocation = findString(menu1, WINDOWS_DEFAULT_FONT, TRANSPARENT, fontcolor, menubar, false);
			
		logger.finest("Found menu '"+menu1+"' at "+menuLocation);
		leftClickMid(menuLocation);
		delay(1000);
		
		
		//now see what came up at the location just below the menu name
		ComponentInfo info = NativeGUI.getWindowInfo( menuLocation.x, menuLocation.y+menuLocation.height+10 );
		//logger.fine("SETTING menuClass " + info.getClassName());
		String menuClass = info.getClassName();
		//logger.fine("SETTING mainMenu " + info.getLocation());
		Rectangle mainMenu = info.getLocation();
		//logger.finest("Menu class name: "+menuClass+ ", location: "+mainMenu);
		Rectangle mainMenuRegion=new Rectangle(mainMenu.x,mainMenu.y,mainMenu.width,mainMenu.height);
		
		//click the other menu items
		Rectangle belowMenuBar = new Rectangle(	menubar.x, mainMenuRegion.y+5,
												menubar.width, mainMenuRegion.height);
		
		logger.finest("Searching for sub menus at "+belowMenuBar);
		boolean found = false;
		String path = menu1;
		
		for(int i=0;i<items.length;i++) {
				if((menu==null)&&(i==0)){
					i++;
				}
				
			/**Here, we skip null items for plugin's help menu testcases
			*refer to help methods in AltovaApplicationRobot, getExtraHelpMenuItems();
			*/
				if(items[i]=="" || items[i]==null){
				continue;
			}
			path += " - "+items[i];
			
			//find menu objects on the screen
			List<Rectangle> menuObjs = findComponents(null, menuClass, belowMenuBar);
			logger.finest("Number of objects found:"+menuObjs.size());
			Collections.reverse(menuObjs);
			found = false;
			for(Rectangle menuRec : menuObjs) {
				logger.finest("Searching for "+items[i]+" in "+menuRec);
				try {
					//click the first item found and break the inner loop
					Rectangle mLocation=null;
					if (Settings.isVS2010()&& this instanceof VSnetSpyRobot) { // This needs to be added to
												// solve problem with WSDL
												// submenu that comes up on the
												// left side in VS2010
						mLocation = findString(items[i], WINDOWS_DEFAULT_FONT,
								TRANSPARENT, fontcolor, menuRec, true);
					} else {
						mLocation = findString(items[i], WINDOWS_DEFAULT_FONT,
								TRANSPARENT, fontcolor, menuRec, false);
					}
					logger.finest("Found menuitem "+items[i]+" at "+mLocation);
					leftClickMid(mLocation);
					delay(800);
					found = true;
					logger.finest("Found flag=" + found + " searching: " + items[i]);
					break;
				} catch(ImageNotFoundException e) {
					logger.finest("did not find '"+items[i]+"' in menu at "+menuRec);
				}
			}
		}

		if(!found) {
			
			
			//close any menus that might be open
			for (int i = 0; i < items.length; i++) {
				keyType(VK_ESCAPE);
			}
			throw new ScriptMistakeException("Could not find menu item "+path);
		}
		
		delay(2000);
	}
	
	/**
	 * Clicks the specified main menu item with the left mouse button.
	 * It can just be used if the menu to access has a specified shortcut 
	 * ( underlined character in its name ) 
	 * 
	 * Examples:
	 * leftClickMenuItem( "File", "O" );
	 * leftClickMenuItem( "Tools", "O");
	
	 * @param menu the name of the menu on the top menubar
	 * @param shortcut item accelerator
	 */
	public void leftClickMenuShortcut(String menu,String... shortcut) {
		String menu1=menu;
		//first try to find the menu bar
		Rectangle menubar = findMenuBar(menu1);

		//click the menu at the menubar
		Rectangle menuLocation = findString(menu1, menubar, true);
		logger.finest("Found menu '"+menu1+"' at "+menuLocation);
		leftClickMid(menuLocation);
		delay(3000);
		//now, type the shortcut key -normally a letter-
		for (String string : shortcut) {
			typeString(string);
			delay(500);
		}	
		
	}
	
/*	//It did not work: TO be investigated in the future
	
	public void leftClickMenuItem(String menu,int from_y1,int to_y2, String... items ) {
		String menu1=menu;
		if(menu==null){
			 menu1=items[0];
		}
		//first try to find the menu bar
		Rectangle menubar = findMenuBar(menu1);

		//click the menu at the menubar
		Rectangle menuLocation = findString(menu1, menubar, true);
		logger.finest("Found menu '"+menu1+"' at "+menuLocation);
		leftClickMid(menuLocation);
		delay(1000);
		
		
		//now see what came up at the location just below the menu name
		ComponentInfo info = NativeGUI.getWindowInfo( menuLocation.x, menuLocation.y+menuLocation.height+10 );
		String menuClass = info.getClassName();
		Rectangle mainMenu = info.getLocation();
		logger.finest("Menu class name: "+menuClass+ ", location: "+mainMenu);
		Rectangle mainMenuRegion=new Rectangle(mainMenu.x,mainMenu.y+from_y1,mainMenu.width,mainMenu.height-from_y1-to_y2);
		
		//click the other menu items
		Rectangle belowMenuBar = new Rectangle(	menubar.x, mainMenuRegion.y+5,
												menubar.width, mainMenuRegion.height);
		
		logger.finest("Searching for sub menus at "+belowMenuBar);
		boolean found = false;
		String path = menu1;
		
		for(int i=0;i<items.length;i++) {
				if((menu==null)&&(i==0)){
					i++;
				}
				
			/**Here, we skip null items for plugin's help menu testcases
			*refer to help methods in AltovaApplicationRobot, getExtraHelpMenuItems();
			*//*
			if(items[i]==null){
				continue;
			}
			path += " - "+items[i];
			
			//find menu objects on the screen
			List<Rectangle> menuObjs = findComponents(null, menuClass, belowMenuBar);
			Collections.reverse(menuObjs);
			found = false;
			for(Rectangle menuRec : menuObjs) {
				logger.finest("Searching for "+items[i]+" in "+menuRec);
				try {
					//click the first item found and break the inner loop
					Rectangle mLocation = findString(items[i], menuRec, false);
					logger.finest("Found menuitem "+items[i]+" at "+mLocation);
					leftClickMid(mLocation);
					delay(800);
					found = true;
					logger.finest("Found flag=" + found + " searching: " + items[i]);
					break;
				} catch(ImageNotFoundException e) {
					logger.finest("did not find '"+items[i]+"' in menu at "+menuRec);
				}
			}
		}

		if(!found) {
			
			
			//close any menus that might be open
			for (int i = 0; i < items.length; i++) {
				keyType(VK_ESCAPE);
			}
			throw new ScriptMistakeException("Could not find menu item "+path);
		}
		
		delay(2000);
	}*/

	private Rectangle findScrollBar(Rectangle clip) {
		if( ImageUtils.getIconURL(BAR_ENABLED_UP) == null ||
				ImageUtils.getIconURL(BAR_ENABLED_DOWN) == null ) {
			String msg = "Could not find files "+BAR_ENABLED_UP+" and/or "+BAR_ENABLED_DOWN +
						"Please run 'ant scrollbar' to create these images. (Excel is required)";
			logger.severe(msg);
			throw new ScriptMistakeException(msg);
		}
		
		try {
			Rectangle up = find(readIcon(BAR_ENABLED_UP), clip, false);
			Rectangle tmp = new Rectangle(up.x, up.y+up.height, up.width, clip.height-up.height);
			logger.finest("tmp: "+tmp);
			Rectangle down = find(readIcon(BAR_ENABLED_DOWN), tmp, false);

			logger.finest("up: " + up);
			logger.finest("down: " + down);

			Rectangle bar = new Rectangle(up.x - 3, up.y + up.height,
					up.width + 6, down.y - up.y - down.height);
			logger.finest("Bar: " + bar);

			return bar;

		} catch (ImageNotFoundException e) {
			logger.warning("Could not find scroll bar icon(s)");
		}

		return null;
	}
	
	protected void scroll(Rectangle clip, double position ) {
		logger.finest("scroll: clip="+clip);
		Rectangle bar = findScrollBar(clip);

		if(bar == null) {
			logger.fine("Did not find any scrollbar in this area: "+clip);
			return;
		}
		
		//we know here the scroll bar including the arrow 
		//now let's find the slider
		try {
			findScrollSlider(bar);
			delay(1000);
		} catch (IOException e) {
			throw new ScriptMistakeException("Couldn't save new scroll bar images", e);
		}
		
		compareState = PixelCompare.FULL_COLOR;
		Rectangle top = find(readIcon(BAR_TOP_IMG), bar, false);
		Rectangle bottom = find(readIcon(BAR_BOTTOM_IMG), bar, false);
		compareState = DEFAULT_PIXEL_COMPARE;
		
		int sliderHeight = bottom.y+bottom.height-top.y;
		int pos = (int) (((double)(bar.height - sliderHeight - 5))*position + bar.y);
		

		Point from = new Point( top.x+bar.width/2, top.y+6);
		Point to = new Point( bar.x+bar.width/2, pos+7 );
		dragDrop(from, to);
	}
	
	void findScrollSlider(Rectangle bar) throws IOException {

		
		//first check if we already can find the slider with the images we got
		try {
			compareState = PixelCompare.FULL_COLOR;
			Rectangle top = find(readIcon(BAR_TOP_IMG), bar, false);
			Rectangle bottom = find(readIcon(BAR_BOTTOM_IMG), bar, false);
			return;
		}
		catch(Exception e) {
			//ignore
			logger.finest("Could not find slider top or bottom. Moving on to discovery phase.");
		} 
		finally {
			compareState = DEFAULT_PIXEL_COMPARE;
		}
		
		File oldOut = Settings.getOutputDir();
		System.setProperty("out", System.getProperty("user.dir"));
		
		//first get the scroll bar to the top
		//holding the top button for a few seconds should do it
		mouseMove(bar.x+7, bar.y-3);
		leftHold(4000);
		
		//scroll the bar to catch the end points
		ScreenDiff diff = new ScreenDiff(this);
		Rectangle hint = new Rectangle(bar.x, bar.y+15, bar.width-1, bar.height);
		
		//move and get bottom
		diff.snapBefore(hint);
		Point from = new Point(bar.x+5, bar.y+25);
		Point to = new Point(bar.x+5, bar.y+bar.height-25);
		dragDrop(from, to);
		delay(2000);
		diff.snapAfter();
		Rectangle barDiff = diff.diffBounds();
		Rectangle bottom = new Rectangle(bar.x+2, barDiff.y+barDiff.height-4, bar.width-3, 5);
		saveScreen(bottom, BAR_BOTTOM_IMG);
		
		//move and get top
		diff.snapBefore(hint);
		dragDrop(to, from);
		delay(2000);
		diff.snapAfter();
		barDiff = diff.diffBounds();
		Rectangle top = new Rectangle(bar.x+2, barDiff.y, bar.width-3, 4);
		saveScreen(top, BAR_TOP_IMG);
		
		System.setProperty("out", oldOut.getAbsolutePath());
	}
	
	/**
	 * Asserts that the active window has the specified window text, and applies
	 * the specified options, and finally exits the options dialog by pressing enter. 
	 * 
	 * @param window the expected windows text of the options dialog
	 * @param options the {@link Option} or {@link Options} to apply, or null.
	 */
	public void applyOptionsEnter(String window, Option options) {
		assertWindow(window);
		
		if(options != null) {
			options.applyOption(this);
		}
		try{
			leftClickMid(findComponent("OK", "Button", null));
		}catch(ScriptMistakeException e){
			keyType(VK_ENTER);
		}
		delay(1000);
	}
	
	/**
	 * Removes the text in a input text field. This is done by moving to it's first position
	 * (with the HOME key), and the pressing the DELETE key a number of times.
	 * 
	 * Should some text still be left, increase the number...
	 *
	 */
	public void removeTextfieldText() {
		
		removeTextfieldText(VK_HOME);
	}
	
	public void removeTextfieldTextEsc() {
		
		removeTextfieldText(VK_ESCAPE);
	}
	
	public void removeTextfieldText(int keyValue) {
		
		//remove any previous text first
		//keyType(VK_END);
		keyType(VK_HOME);
		keyType(keyValue);
		for (int i = 0; i < 200; i++) {
			//keyType(VK_BACK_SPACE);
			keyType(VK_DELETE);
		}

		waitForIdle();
		delay(1000);
	}
	
	
	/**
	 * Tries to escape a dialog containing the specified text,
	 * by pressing the specified KeyEvent constant.
	 * If the application under test is in front, nothing happens and the method return false.
	 * 
	 * @param containsString the text or class name to search for in the dialog
	 * @param keyPress a VK_ key constant from {@link KeyEvent} 
	 * @return true if the string was found and the keypress attempted, false otherwise
	 */
	public boolean escapeDialog(String containsString, Integer...keyPress ){
		delay(1000);
		
		if( isApplicationFront() ) {
			return false;
		}
		
		ComponentInfo info = NativeGUI.getForegroundWindowInfo();
		logger.finest("Front dialog: "+info);
		List<ComponentInfo> list = NativeGUI.getAllComponents(info.getLocation());
		
		if (searchList(list, containsString)) {
			logger.fine("Front dialog: '" + containsString + "'. Escaping.");
			for (int i : keyPress) {
				keyType(i);
				delay(500);
			}
			delay(500);
			return true;
		}
		
		delay(1000);
		return false;
	}
	
	
	protected void addEscapeDialogAction(String containsString, int... keyPress) {
		Integer[] k = new Integer[keyPress.length];
		for (int i = 0; i < keyPress.length; i++) {
			k[i] = keyPress[i];
		}
		
		escapeDialogActions.put(containsString, k);

	}
	
	
	protected boolean checkEscapeDialogActions() {
		boolean escaped = false;
		for(Map.Entry<String, Integer[]> e : escapeDialogActions.entrySet()) {
			escaped |= escapeDialog(e.getKey(), e.getValue());
		}
		return escaped;
	}
	
	protected void waitAndEsacpe(String message) {
		int i = 0;
		int trys = 3;
		while( isApplicationRunning() && !isApplicationFront() && i < trys ){
			logger.finest(message);
			delay(10000);
			checkEscapeDialogActions();
			i++;
		}
		
		//remove all escape actions
		escapeDialogActions.clear();
	}
	
	protected boolean searchList(List<ComponentInfo> cmps, String str) {
		//TODO: need to stream line this a bit
		
		for(ComponentInfo  info : cmps) {
			String text = info.getWindowText();
			String clazz = info.getClassName();
			if(text.indexOf(str) > -1 ) { //|| clazz.indexOf(str) > -1) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 
	 * @param name
	 */
	protected void assertWindow(String name) {
		logger.finest("Asserting window on top: "+name);
		if( !RegressionAssert.isWindowOnTop(name) ) {
			String msg = "Expected window or dialog was not found in front: "+name+
						". Found window: "+NativeGUI.getForegroundWindowInfo().getWindowText() + ".";
			logger.finest(msg);
			throw new ScriptMistakeException(msg);
		}
		logger.fine("Asserted correct window on top: "+name);
	}
	
	protected boolean isAssertWindow(String name) {
		logger.finest("Asserting window on top: "+name);
		if( !RegressionAssert.isWindowOnTop(name) ) {
			String msg = "Expected window or dialog was not found in front: "+name+
						". Found window: "+NativeGUI.getForegroundWindowInfo().getWindowText() + ".";
			logger.finest(msg);
			return false;
		}else{
			logger.fine("Asserted correct window on top: "+name);
			return true;
		}
		
	}
	
	/**
	 * Attempts to set the application under test to the active foreground window,
	 * or start the application if it is not already running. This might fail
	 * for a number of reasons: the application might not be running,
	 * the application might have a modal window open, it might be running
	 * but not on the primary monitor, or the application EXE dose not exist.
	 * 
	 * @return true if the application was found to be the front window
	 */
	public boolean activateApplication() {
		if( setVisible() ) {
			return true;
		}
		
		//The application was not made visible, but maybe there is a modal dialog
		//let's try to click ESC a few times
		logger.warning("activateApplication(): Trying to escape from modal dialog");
		keyType(VK_ESCAPE);
		delay(500);
		keyType(VK_ESCAPE);
		delay(500);

		if( setVisible() ) {
			return true;
		}
		
		//the application might not be running, let's try to start it
		startApplication();
		
		return isApplicationFront();
	}
	
	/**
	 * Attempts to set the application under test to the active foreground window.
	 * This might fail for a number of reasons: the application might not be running,
	 * the application might have a modal window open, or it might be running
	 * but not on the primary monitor. 
	 * 
	 * @return true if the application was found to be the front window
	 *
	 */
	public boolean setVisible() {
		//first check if it's already active
		if( isApplicationFront() ) {
			return true;
		}
		
		ComponentInfo app = getApplicationWindow();
		if(app == null) {
			return false;
		}
		
		NativeGUI.switchToWindow(app);
		delay(1500);
		
		//if false here, something else must have failed
		return isApplicationFront();
	}
	
	protected ComponentInfo getApplicationWindow() {
		List<ComponentInfo> apps = NativeGUI.getApplicationList();
		List<ComponentInfo> filtered = filterComponents(apps, getAppName(), null);
		
		if(filtered.size() == 0) {
			logger.fine("Did not find application with name "+getAppName()+" amongst open applications.");
			return null;
		}
		
		if(filtered.size() > 1) {
			logger.fine("Found more than one application with name "+getAppName()+" amongst open applications. "
						+ "Using the first one.");
			for(ComponentInfo info : filtered) {
				logger.fine("Found: "+info);
			}
		}
		
		return filtered.get(0);
	}
	
	/**
	 * Start the application specified by appPath and appExe.
	 *
	 */
	public void startApplication() {
		if(appPath == null || appExe == null) {
			throw new ScriptMistakeException( "appPath or appExe was null" );
		}
		
		String cmd = appPath + File.separator + appExe;
		File app = new File(cmd);
		if(!(this instanceof PluginRobot)){
			
		if(!app.isFile()) {
			String msg = "The program "+app+" could not be found";
			logger.severe(msg);
			throw new ScriptMistakeException(msg);
		}
		}
		
		ProcessStreamReader ps = runCommand(cmd);
		delay(10000);
		
		//Try to start the application. A few things can happen:
		//- The launch fails - we will handle this elsewhere
		//- An Altova app needs to be re-install registry settings, and wait
		//- An Altova app needs to be re-install registry settings, ask for system restart
		//- An Altova app ask for user registering
		
		addEscapeDialogAction("You must restart", VK_N);
		addEscapeDialogAction("Static", VK_ESCAPE); //this is due to the faulty registering window on the VM
		addEscapeDialogAction("Remind me later", VK_ESCAPE);

		int i = 0;
		int trys = 3;
		while(!ps.hasTerminated() && !isApplicationFront() && i < trys) {
			logger.finest("Waiting for application to start up");
			delay(10000);
			
			if( findComponentName("Please wait") != null) {
				continue;
			}
			checkEscapeDialogActions();
			i++;
		}
		
		//remove all escape actions
		escapeDialogActions.clear();
		
		delay(10000);
		
		//check for wrong license
		String errorMsg = null;
		if(escapeDialog("The existing key-code cannot be used", VK_ESCAPE)) {
			errorMsg = "The wrong key-code was found, and ";
		}
		
		//check if we get the License window
		ComponentInfo ci = NativeGUI.getForegroundWindowInfo();
		String text = ci.getWindowText();
		if( text != null & text.indexOf("Software Activation") > -1) {
			errorMsg += "The Software Activation window was detected. The application "+getAppName()+" did not start.";
			logger.warning(errorMsg);
			keyType(VK_ESCAPE); delay(500);
			keyType(VK_ESCAPE); delay(500);
			throw new ApplicationErrorException(errorMsg);
		}
	}
	
	public void maximizeWindow() {
		maximizeWindow(Color.BLACK);
	}
	
	public void maximizeWindow(Color fontcolor) {

		
		ComponentInfo app = getApplicationWindow();
		if(app == null) {
			logger.warning("Did not find application window. Could not maximize it.");
			return;
		}
		
		Rectangle l = app.getLocation();
		Point upperLeft = new Point(l.x+10, l.y+10);
		leftClickMid(findString("File",WINDOWS_DEFAULT_FONT,TRANSPARENT,fontcolor, l, false)); delay(2000);
		clickMaximize(upperLeft,l);
	}
	
	protected void clickMaximize(Point upperLeft, Rectangle window){
		
		leftClick(upperLeft); delay(500); 
		keyType(VK_ESCAPE); delay(500);
		leftClick(upperLeft); delay(500);
		try {
			leftClickMid(findString("Maximize", window, false));
			logger.info("looking for the maximize string");
		} catch(ImageNotFoundException e) {
			keyType(VK_ESCAPE);
		}
		
		delay(2000);
	}
	
	protected ProcessStreamReader runCommand(String command) {
		logger.info("Running command: "+command);
		Runtime rt = Runtime.getRuntime();
		
		try {
			Process ps = rt.exec( command );
			return new ProcessStreamReader(ps);
			
		} catch (IOException e) {
			String msg = "The application failed to start. command: "+command + e.toString();
			logger.severe(msg);
			throw new ApplicationCrashedException(msg, e);
		}
	}
	
	public boolean checkNotResponding() {
		ComponentInfo ci = NativeGUI.getForegroundWindowInfo();
		String window = ci.getWindowText().toLowerCase();
		
		//check if we have the application in front
		if( window.indexOf( appName.toLowerCase() ) == -1 ) {
			return false;
		}
		
		if( window.indexOf( "not resp" ) > -1) {
			logger.warning("Application "+appName+" not responding");
			saveFullScreenDebug("robotdebug_not_responding"+IOUtils.getFileId());
			return true;
		}
		
		return false;
	}
	
	/**
	 * Check if the application under test has crashed, and try escape it before throwing an exception.
	 * Logging images should appear in the debug directory, if this is turned on.
	 * 
	 * @throws ApplicationCrashedException if a crash is detected.
	 *
	 */
	public void checkCrash()  {
		addEscapeDialogAction("Application Error", VK_ESCAPE);
		addEscapeDialogAction("referenced memory", VK_ESCAPE);
		addEscapeDialogAction("OK to terminate the program", VK_ESCAPE);
		addEscapeDialogAction("Just-In-Time Debugging", VK_ESCAPE);
		addEscapeDialogAction("An exception", VK_ESCAPE);
		addEscapeDialogAction("abnormal program termination", VK_ESCAPE);
		
		
		//eclipse crashes
		addEscapeDialogAction("JVM terminated", VK_ESCAPE);
		addEscapeDialogAction("javaw.exe", VK_ESCAPE);
		
		// if we're running eclipse, see if we need to activate the crash window
		// which is hiding behind everything. It's called just Eclipse
		List<ComponentInfo> apps = NativeGUI.getApplicationList();
		List<ComponentInfo> filtered = filterComponents(apps, "Eclipse", null);
		if(filtered.size() == 1 && filtered.get(0).getWindowText().startsWith("Eclipse")) {
			NativeGUI.switchToWindow(filtered.get(0));
			delay(1000);
		}
	
		boolean crashed = false;
		for (int i = 0; i < 5; i++) {
			//first check for and escape a few crash messages
			crashed |= checkEscapeDialogActions();
			
			//check some images
			crashed |= escapeCrashImage("vs_crash_msg_restart.png");
			crashed |= escapeCrashImage("crash_msg.bmp");
			crashed |= escapeCrashImage("crash_cross.png");
			crashed |= escapeCrashImage("vs_crash_msg.png");
			crashed |= escapeCrashImage("crash_vista.png");
			
			
			if(!crashed) {
				break;
			}
		}
		
		//remove all escape actions
		escapeDialogActions.clear();
		
		//check for Not responding app.
		//and wait a bit if we see it
		for (int i = 0; i < 3; i++) {
			if(!checkNotResponding()) {
				break;
			}
			delay(5000);
		}
		
		//Assume crash if it it still not responding 
		if(checkNotResponding()) {
			crashed = true;
		}
		
		if(!crashed) {
			return;
		}
		
		logger.severe("The application under test crashed.");
		String id = IOUtils.getFileId();
		saveFullScreenDebug("robotdebug_application_crashed_"+id);
		throw new ApplicationCrashedException("The application under test crashed.");
	}

	private boolean escapeCrashImage(String img) {
		
		//then check for the "send Microsoft a message" image
		try {
			Rectangle r = findImage(img);
			logger.severe("Detected crash dialog: "+img);
			leftClickMid(r);
			delay(500);
			keyType(VK_ESCAPE);
			delay(1000);
		} catch (ImageNotFoundException e) {
			return false;
		} catch (ScriptMistakeException e) {
			LoggerUtils.logger.warning("Could not open crash image: " +e);
			e.printStackTrace();
			return true;
		}
		
		return true;
	}
	
	/**
	 * Checks if the application name specified by appName is the front window.
	 * 
	 * @return true if application under test is the active front window.
	 */
	public boolean isApplicationFront() {
		if(appName == null) {
			throw new ScriptMistakeException( "appName was null" );
		}
		
		ComponentInfo ci = NativeGUI.getForegroundWindowInfo();
		Rectangle appLocation = ci.getLocation();
		int windowArea = appLocation.height*appLocation.width;
		String window = ci.getWindowText().toLowerCase();
		final int min_area = 150000;
		
		//check name window and size
		//if the size is about that of a dialog,
		//let's assume that it's not the application window we're expecting
		boolean inFront = ( window.indexOf( appName.toLowerCase() ) > -1  && windowArea > min_area);
		logger.info("Are we running VS2010? "+Settings.isVS2010());
		if(!Settings.isVS2010()){	
			if(inFront) {
				//see if the application maybe has the "Not Responding" tag
				if( checkNotResponding() ) {
					logger.warning("Application not responding");
					return false;
				}
				
				//if we think we have the application window in front, let's look for the File menu, to be sure
				try {
					findString("File", appLocation, false);
				} catch (ImageNotFoundException e) {
					logger
							.fine("Did not find File menu text within application window: "
									+ appLocation);
					inFront = false;
				}
				//fix for VS2010
			}else{
				
					try {
						logger.info("Running VS2010 tests");
					
						findString("File", WINDOWS_DEFAULT_FONT, TRANSPARENT, GRAY_IN_VS2010_MENU,
								appLocation, false);
						inFront = true;
					} catch (ImageNotFoundException e) {
						logger
								.fine("Did not find VS2010 File menu text within application window: "
										+ appLocation);
						inFront = false;
					}
				}	
			}

		
		logger.finer("Expected application "+((inFront)?"":"not")+" in front: "+appName.toLowerCase() +" (area: "+min_area+
					") -  ForegroundWindow: "+window+"( area: "+windowArea+")");
		
		if(!inFront && outputDebugImages) {
			String id = IOUtils.getFileId();
			saveFullScreenDebug("robotdebug_not_on_top_"+id);
		}
		
		return inFront;
	}
	
	/**
	 * From the list running applications (as seen in the Applications tab in the Windows
	 * Task Manager), see if the application under test can be found.
	 * 
	 * WARNING: This will NOT tell if the application is still resident in memory or not.
	 * 
	 * @return true if the application under test has a visible window.
	 */
	public boolean isApplicationRunning() {
		ComponentInfo app = getApplicationWindow();
		return app != null;
	}
	
	public void closeAltF4() {
		keyPress(VK_ALT);
		keyPress(VK_F4);
		keyRelease(VK_F4);
		keyRelease(VK_ALT);
		
		delay(2000);
	}
	
	/**
	 * Check if the specified string is a existing file. 
	 * 
	 * @param name full path and file name
	 * @throws ScriptMistakeException if the file does not exist or it is not a file
	 */
	protected void checkFile(String name) {
		File file = new File(name);
		
		if(file.isFile()) {
			return;
		}
		
		String msg = "The file "+name+" cannot be found.";
		logger.severe(msg);
		throw new ScriptMistakeException(msg);
	}

	/**
	 * Check that directories in the given path exits, or create them if they don't.  
	 * 
	 * @param name full path of directory or file
	 */
	protected void checkDir(String name) {
		File file = new File(name);
		File parent = file.getParentFile();
		
		if(!parent.isDirectory()) {
			parent.mkdirs();
		}
	}
	
	/**
	 * Returns the application name as seen in the window title. If it is an
	 * Altova application, this string should include the 'Altova' part.
	 * 
	 * @return the name of the application
	 * @see ApplicationRobot#ApplicationRobot(String, File, String)
	 */
	public String getAppName() {
		return this.appName;
	}

	/**
	 * Returns the install path of the application under test. This should be
	 * the path where the application EXE was launched from (and not the
	 * "default" install path).
	 * 
	 * @return the path of EXE which was used to launch the application under
	 *         test.
	 */
	public File getAppPath() {
		return this.appPath;
	}

	/**
	 * Find the biggest, measured in pixel area (width*height) graphical
	 * component on screen, which is not the main application window itself.
	 * Typically, this is a good way to find where the main view/editor/diagram
	 * component is located, since it tends to be the one occupying most screen
	 * space.
	 * 
	 * @return info about the biggest component inside the application under
	 *         test
	 */
	public ComponentInfo getDiagramComponent() {
		List<ComponentInfo> list = NativeGUI.getAllComponents();
		double max = 0;
		ComponentInfo diagram = null;
		
		
		//find the component with the largest area. Assume this is the diagram...
		for(ComponentInfo info : list) {
			Rectangle r = info.getLocation();
			double area = r.getHeight() * r.getWidth();
			// check that we don't get the application window component
			// TODO: we might have to make this more robust
			//DEBUG
//			logger.fine(">>>>>getAppName :" + getAppName());
//			logger.fine(">>>>>recta :" + r);
//			logger.fine(">>>>>recta area:" + area);
//			logger.fine(">>>>>actual max:" + max);
//			logger.fine(">>>>>recta name:" + info.getWindowText());
//			logger.fine(">>>>>usable?:" + info.getWindowText().indexOf( getAppName() ));
//			logger.fine(">>>>>------ende------");
			if(area > max && info.getWindowText().indexOf( getAppName() ) == -1) {
				max = area;
				diagram = info;
				//logger.fine(">>>>>new max is:" + info.getWindowText() + " with " + area);
			}
			
						
		}
		Point middiag=findMid(diagram.getLocation());
		ComponentInfo middiagc= NativeGUI.getWindowInfo(middiag.x,middiag.y);
		if(middiagc.getClassName().equalsIgnoreCase(getDiagramClass())){
			return null;	
		}

		return middiagc;
	}

	
	protected String getDiagramClass() {
		//for the Altova application, but also VS .Net, the empty gray area is of the class
		//MDIClient. If there is an open file, it is something else.
		//In Eclipse, this is different, and thus it overrides this methods and returns the
		//name of a different class
		return "MDIClient";
	}
}
