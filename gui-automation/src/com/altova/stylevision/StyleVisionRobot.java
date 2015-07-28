package com.altova.stylevision;

import static com.altova.stylevision.Position.AFTER;
import static com.altova.stylevision.Tag.*;
import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.VK_ADD;
//import static java.awt.event.KeyEvent.VK_CONTROL;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_N;
import static java.awt.event.KeyEvent.VK_SHIFT;
import static java.awt.event.KeyEvent.VK_TAB;
import static java.awt.event.KeyEvent.VK_Y;
import static java.awt.event.KeyEvent.VK_SPACE;
import static java.awt.event.KeyEvent.VK_RIGHT;
//import static java.awt.event.KeyEvent.VK_DOWN;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import java.awt.image.BufferedImage;
//import com.altova.util.RegressionAssert;


import com.altova.nativegui.NativeGUI;
import com.altova.robots.AltovaApplicationRobot;
//import com.altova.robots.CheckboxOption;
import com.altova.robots.DropDownOption;
import com.altova.robots.ImageNotFoundException;
import com.altova.robots.ImageRecognitionRobot;
import com.altova.robots.ImageUtils;
import com.altova.robots.Option;
import com.altova.robots.Options;
import com.altova.robots.Pane;
import com.altova.robots.RadioOption;
import com.altova.robots.ScriptMistakeException;
import com.altova.util.Settings.AltovaApplication;

/**
 * Robot specialized for StyleVision. It can put tags into the Design
 * View, and manipulate layout and design.
 * 
 * @author Havard Rast Blok
 *
 */
public class StyleVisionRobot extends AltovaApplicationRobot {

	static final String BASEPATH = "stylevision/";
	
	private final static String[] mainToolbarIds = { 
		"IDR_POPUP_TOOLBAR",
		"IDR_AUTHENTIC",
		"IDR_FORMAT",
		"IDR_HYPERLINK",
		"IDR_MAINFRAME",
		"IDR_TABLE",
		"IDT_ABOUT",
		"IDT_HELP",
		"IDT_IMAGES_ONLY",
	};
	
	private final static String[] guiToolbarIds = {
		"IDR_DESIGNTREE",
		"IDR_STYLEREPOSITORY",
		"IDR_LOCALSTYLE",
		"IDR_SCHEMASOURCES",
		"IDR_PROPERTIES",
		"IDR_SCHEMASOURCE_NEW",
	};
	
	/**
	 * Default font BOLD (e.g $XML(main) )
	 */
	public final static Font WINDOWS_DEFAULT_FONT_BOLD = new Font("Tahoma", Font.BOLD, 11);
	public static final Color SilverOliveGreen_BACK = new Color(212,208, 200);
	public static final TagColor BSOG = new TagColor(SilverOliveGreen_BACK,Color.BLACK );	
	
	public static Pane PROJECT = new StyleVisionPane("Project", "Project");
	public static Pane STYLEREPOSITORY = new StyleVisionPane("Style Repository", "Style Repository");
	public static Pane SCHEMATREE = new StyleVisionPane("Schema Tree", "Schema Tree");
	public static Pane DESIGNTREE = new StyleVisionPane("Design Tree", "Design Tree");
	public static Pane DESIGNOVERVIEW = new StyleVisionPane("Design Overview", "Design Overview");
	public static Pane STYLES = new StyleVisionPane("Styles", "Context Styles");
	public static Pane PROPERTIES = new StyleVisionPane("Properties", "Context Properties");
	
	
	
	public StyleVisionRobot() {
		super("Altova StyleVision", AltovaApplication.STYLEVISION, "StyleVision", BASEPATH+"StyleVision.rc", mainToolbarIds);
		addReader(BASEPATH+"StyleVisionGUI.rc", guiToolbarIds );
		
		addSettingsRegistryKey(	"LastStates", "Recent File List", "Recent Project List", "Settings","URL","TextFonts","UI_SVE2012_English" );
	}
	
	public void openFile(String filename){
		checkFile(filename);		
		leftClickMenuItem("File","Open");delay(1000);
		typeFileName(filename); delay(2000);
		keyType(KeyEvent.VK_ESCAPE);delay(1000);
		maximizeFileWindow(true);
	}
	
	public void openFileStrgo(String filename){
		checkFile(filename);
		
		//leftClickMenuItem("File","Open");delay(1000);
		keyTypeCtrl(KeyEvent.VK_O);delay(1000);
		typeFileName(filename); delay(2000);
		maximizeFileWindow();
	}
	
	protected void typeFileName(String name) {
		typeStringEnter(name); delay(2000);
		escapeDialog("Warning:",VK_ENTER);
		escapeDialog("Stylevision has detected",VK_N);
		
		//escapeGeneralDialogs("Waiting while escaping file dialogs"); must be implemented
	}
	public void leftClickButton(String button){
		Rectangle ButtonLocation = findComponentName(button);
		logger.finest("Found Button '"+button+"' at "+ButtonLocation);
		leftClickMid(ButtonLocation);
		delay(1000);
	}
	/**
	 * Create a new SPS of the specified type
	 * 
	 * @param type type of SPS to create (based on New sub menu).
	 */
	public void newSPS(String type) {
		leftClickMenuItem("File", "New", type);
		//addEscapeDialogAction("Please select the initial layout", VK_ENTER);
		delay(500);
		//maximizeFileWindow();
	}
	
	
	/**
	 * Opens the specified SPS design into StyleVision.
	 * 
	 * @param name full path and file name.
	 */
	public void loadDesign(String name) {
		checkFile(name);
		
		leftClick("ID_FILE_OPEN");
		leftClick();
		delay(500);
		//typeString(name);
		//keyType(KeyEvent.VK_ENTER);
		typeFileName(name);
		delay(4000);
		maximizeFileWindow();
	}
	
	/**
	 * Saves the active SPS design to the specified path.
	 * If the file already exists, it is overwritten.
	 * TODO: if the file exists and is open, we have a problem...
	 * 
	 * @param name full path and file name.
	 */
	public void saveReplaceDesign(String name) {
		checkDir(name);
		
		leftClick("ID_FILE_SAVE");
		leftClick();
		delay(500);
		logger.fine("Saved project as "+name);
		typeString(name);
		keyType(KeyEvent.VK_ENTER);
		
		try {
			findString("Do you want to replace");
			delay(800);
			typeString("Y");
		} catch(ImageNotFoundException e) {} //ignore
		

	}
	
	/**
	 * Save Generated Files to the specified path.
	 * String type defines the export type
	 * If the file already exists, it is overwritten.
	 * TODO: if the file exists and is open, we have a problem...
	 * 
	 * @param name full path and file name.
	 */
	public void saveGeneratedFiles(String name,String type) {
		checkDir(name);
		
		leftClickMenuItem("File", "Save Generated Files",type); delay(1000);
		leftClick();
		delay(500);
		logger.fine("Saved "+type+" as "+name);
		typeString(name);
		keyType(KeyEvent.VK_ENTER);
		
		try {
			findString("Do you want to replace");
			delay(800);
			typeString("Y");
		} catch(ImageNotFoundException e) {} //ignore
	}
	
	/**
	 * Closes all files opened in the editor. 
	 */
	
	public void closeAll (){
		leftClickMenuItem("File", "Close All");
		//escape dialogs
		addEscapeDialogAction("Save changes to", VK_N);
		addEscapeDialogAction("Save changes in Authentic to ", VK_N);
		waitAndEsacpe("");
	}
	
	/**
	 * Close file opened in the editor. 
	 */
	public void close (){
		leftClickMenuItem("File", "Close              ");
		//escape dialogs
		addEscapeDialogAction("Save changes to", VK_N);
		addEscapeDialogAction("Save changes in Authentic to ", VK_N);
		waitAndEsacpe("");
	}
	public void closebyStrgF4 (){
		keyTypeCtrl(KeyEvent.VK_F4);
		//escape dialogs
		addEscapeDialogAction("Save changes to", VK_N);
		addEscapeDialogAction("Save changes in Authentic to ", VK_N);
		waitAndEsacpe("");
	}
	public void closebyStrgF4 (int key){
		keyTypeCtrl(KeyEvent.VK_F4);
		//escape dialogs
		addEscapeDialogAction("Save changes to", key);
		addEscapeDialogAction("The original design is from an older version", key);
		addEscapeDialogAction("Save changes in Authentic to ", VK_N);
		waitAndEsacpe("");
	}
	
	/**
	 * Adds a schema to the active design. Using the Schema Sources pane
	 * 
	 * @param name full path and file name.
	 */
	public void addSchema(String name) {
		checkFile(name);
		Rectangle myTag = findTagwithFont("add new Source",MW,WINDOWS_DEFAULT_FONT);   //new GUI in V2008
		leftClick(myTag.x,myTag.y);delay(500);
		//leftClick("IDR_SCHEMASOURCES_ADD_SCHEMA");
		leftClickString("DTD/XML..."); 
		delay(500);
		typeString(name);
		keyType(KeyEvent.VK_ENTER);
		delay(500);
		keyType(KeyEvent.VK_S); //select SKIP - do no assign working XML here
		delay(500);
	}
	
	/**
	 * Adds a CSS to the active design. Using the Stye Repository pane
	 * 
	 * @param name full path and file name.
	 */
	public void addCSS(String name) {
		throw new ScriptMistakeException("Not implemented yet");
	}
	
	/**
	 * Adds a working XML to the active design. Using the Schema Sources pane
	 * 
	 * @param name full path and file name.
	 */

	public void assigningWorkingXML(String name) {
		checkFile(name);
		Rectangle working = findTagwithFont("Working", BLG,WINDOWS_DEFAULT_FONT);
		leftClick(working.x-18, working.y);
		delay(2000);
		typeStringEnter(name);delay(5000);
		escapeDialog("Warning:",KeyEvent.VK_ENTER);
	}
	
	public void assigningTemplateXML(String name) {
		checkFile(name);
		Rectangle position = findTagwithFont("Working", BLG,WINDOWS_DEFAULT_FONT);
		rightClick(position.x-18, position.y);
		leftClickString("Template XML File...");
		delay(500);
		typeStringEnter(name);
	}
	/**
	 * TODO: hard coded stuff. need to change this
	 * @param encoding
	 */
	public void setEncoding(String encoding) {
		leftClickMenuItem("File", "Properties"); delay(1000);
		assertWindow("Properties");
		
		Options options = new Options();
		options.add(new DropDownOption("HTML:", encoding));
		options.add(new DropDownOption("RTF:", encoding, "Select Output Encoding for", "HTML"));
		options.add(new DropDownOption("PDF:", encoding));
		options.add(new RadioOption("Compatibility"));
		options.applyOption(this);
		
		keyType(KeyEvent.VK_ENTER);
	}
	
	/**
	 * Find the schema element from Schema Sources pane, based on the 
	 * specified path, deliminated by slashes. The end element is selected and the
	 * keyboard key "+" is pressed to expand it. The location on the screen where
	 * the text is found is then returned.
	 * 
	 *  E.g "newsitem/dateline/date" will navigate to the element date, which is a
	 *  subelement of dateline. 
	 * 
	 * TODO: make sure sub-elements are indeed below their parent
	 * 
	 * @param path an "xpath" of element, deliminated by "/"
	 * @return the area take up by the string of the last element
	 */
	public Rectangle navigateTo(String path) {
		String elements[] = path.split("/");
		
		//TODO: make sure Schema Sources pane is active
		
		Rectangle ans = null;
		for (String e : elements) {
			//make sure we get the right element; not one only containing the element word
			ans = findTag(e+" ", BW);
			leftClickMid( ans );
			mouseMove(ans.x+180,ans.y);   //move mouse to remove tooltip
			delay(100);
			typeString("+");   //press + to expand one level
			//leftClick(ans.x-22, ans.y);   //  click the "+" icon 
			
		}
		
		return ans;
	}
	
	/**
	 * Finds the specified Tag in the Design view.
	 * This find the first tag of the specified kind in the Design View. The returned
	 * Rectangle includes the outer edge of the tag and its arrow tip.
	 * 
	 * @param tag
	 * @return the outer bounds of the tag, including the arrow tip and the "tail".
	 */
	public Rectangle findTag(Tag tag) {
		int x = 0;
		int y = 0;
		Rectangle screen = ImageUtils.getDefaultScreenDimension();
		
		Rectangle hint = screen;
		while (x < screen.width + 20 && y < screen.height + 20) {
			//search full width of screen
			super.compareState = ImageRecognitionRobot.PixelCompare.FULL_COLOR;
			Rectangle text = findString(tag.name, DEFAULT_CONTENT_FONT, tag.color.back, tag.color.text, hint, false);
			logger.fine("findTag: "+tag.name+", color: "+tag.color.toString()+", text: "+text);
			compareState = DEFAULT_PIXEL_COMPARE;
			
			Rectangle fullTag = checkTag(tag, text);
			if (fullTag != null) {
				logger.finest("findTag: return="+fullTag);
				return fullTag;
			}
			
			//now narrow search down to the same line, if we found a tag, but it had wrong direction
			if(text != null) {
				hint = new Rectangle(text.x+text.width, text.y-2, screen.width-text.x, text.height+12);
				Rectangle text2 = null;
				while(hint.x < screen.width) {
					try {
						super.compareState = ImageRecognitionRobot.PixelCompare.FULL_COLOR;
						text2 = findString(tag.name, DEFAULT_CONTENT_FONT, tag.color.back, tag.color.text, hint, false);
						logger.fine("findTag: "+tag.name+", color: "+tag.color.toString()+", text2: "+text2);
						compareState = DEFAULT_PIXEL_COMPARE;
						
						Rectangle fullTag2 = checkTag(tag, text2);
						if (fullTag2 != null) {
							logger.finest("findTag: return="+fullTag2);
							return fullTag2;
						}
	
					} catch(ImageNotFoundException e){
						break;
					}
					compareState = DEFAULT_PIXEL_COMPARE;
					
					//so, we found something on that line, but not the right tag
					//it might be a tag containing a similar word to what we're looking for
					//we'll try to move on
					if(text2 != null) {
						hint = new Rectangle(text2.x+text2.width, text2.y-2, screen.width-text2.x, text2.height+12);
					}
					else {
						break;
					}
				}
			}
			
			//so, this didn't work either, let's look further down the screen
			hint = new Rectangle(0, text.y+text.height, screen.width, screen.height-text.y);
		}
		
		logger.finest("findTag: return null");
		return null;
	}
	
	protected Rectangle checkTag(Tag tag, Rectangle text) {
		BufferedImage arrow = null;
		BufferedImage back = null;
		
		Rectangle hintArrow = null;
		Rectangle hintBack = null;
		
		Dimension tagArrow = new Dimension(12, 19);
		Dimension tagBack = new Dimension(8, 19);
		
		logger.fine("checkTag: "+tag.name+", type: "+tag.type);
		
		if ((tag.type == TagType.START)|| (tag.type == TagType.AUTHSTART)){
			arrow = readIcon(BASEPATH + "tag_start_alpha.png");
			hintArrow = new Rectangle(new Point(text.x+text.width+2, text.y-4), tagArrow);
			back = readIcon(BASEPATH + "tag_start_left_alpah.png");
			if (tag.type == TagType.AUTHSTART){
				hintBack = new Rectangle(new Point(text.x-tagBack.width, text.y-4), tagBack);
			}
			else {
				hintBack = new Rectangle(new Point(text.x-tagBack.width-12, text.y-4), tagBack); //Tags changed in V2009
			}
		} else if ((tag.type == TagType.END)||(tag.type == TagType.AUTHEND)) {
			arrow = readIcon(BASEPATH + "tag_end_alpha.png");
			if (tag.type == TagType.AUTHEND){
				hintArrow = new Rectangle(new Point(text.x-tagArrow.width, text.y-4), tagArrow);
			} 
			else {
				hintArrow = new Rectangle(new Point(text.x-tagArrow.width-12, text.y-4), tagArrow); // Tags changed in V2009
			}
			back = readIcon(BASEPATH + "tag_end_right_alpha.png");
			hintBack = new Rectangle(new Point(text.x+text.width, text.y-4), tagBack);
		}
		
		Rectangle backPosition = null;
		try {
			backPosition = find(back, hintBack, false);
			
			if((tag.type == TagType.END)||(tag.type == TagType.AUTHEND)) {
				backPosition.x += 2;
			}
		} catch(ImageNotFoundException e){
			return null;
		}
		
		//see if we find it, or else return null
		Rectangle arrowPosition = null;
		try {
			arrowPosition = find(arrow, hintArrow, false);
		} catch(ImageNotFoundException e) {
			return null;
		}
		
		if((tag.type == TagType.START)||(tag.type == TagType.AUTHSTART)) {
			arrowPosition.x += 7;
		}
		
		int left = Math.min(arrowPosition.x, backPosition.x);
		int right = Math.max(arrowPosition.x, backPosition.x);
		
		return new Rectangle(left, backPosition.y, right-left, backPosition.height); 
	}
	
	public Rectangle findTag(String string, TagColor color) {
		return findTag(string, color.back, color.text);
	}
	
	/**
	 * 
	 * TODO: should be renamed/re-factored?
	 * 
	 * @param string
	 * @param back
	 * @param text
	 * @return n/a
	 */
	public Rectangle findTag(String string, Color back, Color text) {
		super.compareState = ImageRecognitionRobot.PixelCompare.FULL_COLOR;
		try {
			return findString(string, DEFAULT_CONTENT_FONT, back, text);
		}
		finally {
			compareState = DEFAULT_PIXEL_COMPARE;
		}
	}

	public Rectangle findTagwithFont(String string, TagColor color,Font myfont) {
		return findTagwithFont(string, color.back, color.text,myfont);
	}
	/*
	 * findTagwithFont
	 * 
	 * @param string
	 * @param back
	 * @param text
	 * @param myfont
	 */
	
	public Rectangle findTagwithFont(String string, Color back, Color text,Font myfont) {
		super.compareState = ImageRecognitionRobot.PixelCompare.FULL_COLOR;
		try {
			return findString(string, myfont, back, text);
		}
		finally {
			compareState = DEFAULT_PIXEL_COMPARE;
		}
	}
	
	/**
	 * Move the specified tag to the specified location. The given {@link Tag} will
	 * be dragged from its current location to the destination tag location,
	 * either before or after, depending on the specified {@link Position}.
	 * 
	 * @param tag the Tag to move
	 * @param dest the Tag at destination
	 * @param position the position in relation to the destination tag location
	 */
	public void moveTag(Tag tag, Tag dest, Position position) {
		Rectangle from = findTag(tag);
		Point to = besideTagPosition(dest, position);
		
		dragDrop(from.getLocation().x+10,from.getLocation().y+10, to.x,to.y);
	}

	/**
	 * Insert the specified Schema Source element at the given position in the
	 * Design View.
	 * 
	 * @param element see navigateTo(String)
	 * @param dest the Tag at destination
	 * @param position the position in relation to the destination tag location
	 */
	public void insertElement(String element, Tag dest, Position position) {
		Point to = besideTagPosition(dest, position);
		insertElement(element, to);
	}
	
	public void insertTaxonomy(Rectangle source,Rectangle target,int contextmenu){
		logger.fine("drag from "+source+" to " +target);
		dragDropMid(source, target);delay(1000);
		for (int j=0;j<contextmenu;j++) {
			keyType(KeyEvent.VK_DOWN);delay(500);
		}
		keyType(KeyEvent.VK_ENTER);delay(1000);
		//leftClickString(contextmenu);
	}
	/**
	 * Returns the position which is beside the specified tag, before or after,
	 * as specified by {@link Position}. 
	 * 
	 * @param dest the Tag to find
	 * @param position before or after the specified tag
	 * @return a Point in absolute screen coordinates which should work as
	 *  a destination for design elements 
	 */
	private Point besideTagPosition(Tag dest, Position position ) {
		Rectangle toTag = findTag(dest);
		
		//TODO: make this a bit nicer...
		if(position ==  AFTER) {
			return new Point(toTag.x+toTag.width+2, toTag.y+toTag.height/2);
		}
		else {
			return new Point(toTag.x-1, toTag.y+toTag.height/2);
		}		
	}
	
	/**
	 * Insert the specified Schema Source element at the given position in the
	 * Design View.
	 * 
	 * @param element see navigateTo(String)
	 * @param to absolute screen coordinate
	 */
	public void insertElement(String element, Point to) {
		//TODO: check that Design View is active
		expandElement("Sources");
		Rectangle from = navigateTo(element);
		dragDrop(from.getLocation(), to);
		delay(500);
		leftClickString("Create Contents");
	}
	
	/**
	 *  create Schema from HTML import - drag selected Element Tag $TagName to $InsertAt
	 *  and insert as $InsertAs ("Elements" or "Attributes")
	 */
	public void createSchemafromHTML(Tag TagName,String InsertAt,String InsertAs){
		Rectangle to = navigateTo(InsertAt);
		Rectangle from = findTag(TagName);
		Point fromMid = new Point(from.x+10,from.y+5);
		dragDrop(fromMid.getLocation(), to.getLocation());
		delay(500);
		leftClickString(InsertAs);
	}
	
	public void newcondition(String MyCondition){
		leftClickMenuItem("Insert", "Insert Condition...");
		typeString(MyCondition);delay(500);
		leftClickButton("OK");delay(500); //confirm XPath window
	}
	
	/**
	 * Inserts a line break before or after the specified tag.
	 * 
	 * @param tag
	 * @param position
	 */
	public void insertLineBreak(Tag tag, Position position) {
		setCursorPosition(tag, position);
		keyType(KeyEvent.VK_ENTER);
	}

	/**
	 * Sets the editing cursor before or after the specified tag.
	 * 
	 * @param tag
	 * @param position
	 */
	public void setCursorPosition(Tag tag, Position position) {
		delay(500);
		
		Rectangle r = findTag(tag);
		leftClickMid(r);
		delay(600);
		
		if(tag.type == TagType.START && position == Position.BEFORE) {
			keyType(KeyEvent.VK_LEFT);
		}
		else if(tag.type == TagType.AUTHSTART && position == Position.BEFORE) {
			keyType(KeyEvent.VK_LEFT);
		}
		else if(tag.type == TagType.START && position == Position.AFTER) {
			keyType(KeyEvent.VK_LEFT);
			keyType(KeyEvent.VK_RIGHT);
		}
		else if(tag.type == TagType.AUTHSTART && position == Position.AFTER) {
			keyType(KeyEvent.VK_LEFT);
			keyType(KeyEvent.VK_RIGHT);
		}
		else if(tag.type == TagType.END && position == Position.BEFORE) {
			keyType(KeyEvent.VK_RIGHT);
			keyType(KeyEvent.VK_LEFT);
		}
		else if(tag.type == TagType.AUTHEND && position == Position.BEFORE) {
			keyType(KeyEvent.VK_RIGHT);
			keyType(KeyEvent.VK_LEFT);
		}
		else if(tag.type == TagType.END && position == Position.AFTER) {
			keyType(KeyEvent.VK_RIGHT);
		}
		else if(tag.type == TagType.AUTHEND && position == Position.AFTER) {
			keyType(KeyEvent.VK_RIGHT);
		}
	}
	
	/**
	 * Sets the active View
	 * 
	 * @param view
	 */
	public void setView(View view) {
		leftClickImage(view.file);
	}

	public enum View {
		DESIGN(BASEPATH+"view_design.bmp"), 
		DESIGNBOLD(BASEPATH+"view_designbold.bmp"),
		HTML(BASEPATH+"view_html.bmp"),
		HTMLBOLD(BASEPATH+"view_htmlbold.bmp"),
		AUTHENTIC(BASEPATH+"view_authentic.bmp"),
		RTF(BASEPATH+"view_rtf.bmp"),
		PDF(BASEPATH+"view_pdf.bmp"),
		WML(BASEPATH+"view_wml.bmp"),
		JSCRIPT(BASEPATH+"view_jscript.bmp"),
		DB_ICON_FW(BASEPATH+"db_icon_fw.bmp"),
		ICON_APPEND(BASEPATH+"icon_append_param.bmp"),
		MAIN_TEMPLATE(BASEPATH+"initial document section.bmp"),		
		BRUNCH1(BASEPATH+"brunch1.bmp"),
		OPTION_CHECKBOX(BASEPATH+"option_checkbox.bmp");
		
		String file;
		
		View(String file) {
			this.file = file;
		}
	}
	
	public void selectJavascript(){
		leftClickString("JavaScript");
	}
	
	public void selectXSLTHTML(){
		leftClickString("XSLT-HTML");
	}
	
	public void selectContextMenuItem(String myString) {
		rightClick();
		leftClickString(myString);
	}
	
	public void leftClickIcon(String myIconFile) {
		leftClickImage(myIconFile);
	}
	
	public void insertText(String text, Tag tag, Position position) {
		delay(500);
		setCursorPosition(tag, position);
		typeString(text);
		
		//throw new ScriptMistakeException("Not implemented yet");
	}
	
	public void authentic_insertElement(String element, Tag dest, Position position) {
		delay(500);
		setCursorPosition(dest, position);
		delay(500);
		rightClick();
		leftClickString("Insert before");
		leftClickString(element);
		leftClickString(element);
	}
	
	public void authentic_insertElement(String[] insert_at, Tag dest, Position position) {
		delay(500);
		setCursorPosition(dest, position);
		Point to = besideTagPosition(dest, position);
		delay(500);
		rightClick(to);
		for (int i=0;i<insert_at.length;i++){
			leftClickString(insert_at[i]);delay(500);
		}
	}
	
	public void auth_insertElementAtActualPosition(String[] insert_at) {
		delay(500);
		keyType(KeyEvent.VK_CONTEXT_MENU);
		//rightClick(to);
		for (int i=0;i<insert_at.length;i++){
			leftClickString(insert_at[i]);delay(500);
		}
	}
	
	public void maximizeFileWindow() {
		Rectangle r = getMainWindow();

		for (int i = 10; i <= 25; i += 15) {
			Point p = new Point(r.x, r.y - i);
			Rectangle window = NativeGUI.getWindowInfo(p.x, p.y).getLocation();
			if (window.contains(r)) {
				logger
						.finest("Found outer bounds of file window and try to maximize: "
								+ window);
				clickMaximize(p, window);
			} else {
				logger
						.finest("Did not find outer bounds of file window. Inner window: "
								+ r + ", left top corner: " + window);
			}
		}
	}
	
	public void maximizeFileWindow(boolean usekeyboard ){
		keyTypeAlt(VK_SPACE);
		keyType(VK_RIGHT);
		try {
			leftClickMid(findString("Maximize"));
			logger.info("looking for the maximize string");
		} catch(ImageNotFoundException e) {
			keyType(VK_ESCAPE);
		}
	}
	public void showLargeMarkup() {
		leftClickMenuItem("Authentic","View Markup" ,"Show Large markup");
	}
	
	public void showSmallMarkup() {
		leftClickMenuItem("Authentic","View Markup" , "Show Small markup");
	}
	public void AppendRow() {
		leftClickMenuItem("Authentic", "Append Row");
	}
	public void InsertRow() {
		leftClickMenuItem("Authentic", "Insert Row");
	}
	public void DuplicateRow() {
		leftClickMenuItem("Authentic", "Duplicate Row");
	}
	public void MoveRowUp() {
		leftClickMenuItem("Authentic", "Move Row Up");
	}
	public void MoveRowDown() {
		leftClickMenuItem("Authentic", "Move Row Down");
	}
	public void DeleteRow() {
		leftClickMenuItem("Authentic", "Delete Row");
	}
	public void insertImage(String file, Tag tag, Position position) {
		throw new ScriptMistakeException("Not implemented yet");
	}
	
	public void insertHorizontalLine(Tag tag, Position position) {
		throw new ScriptMistakeException("Not implemented yet");
	}
	
	public void setPaneValue(String pane, String context, String group, String attribute, String value) {
		throw new ScriptMistakeException("Not implemented yet");
	}
	
	public void formatTag(Tag tag, String format) {
		throw new ScriptMistakeException("Not implemented yet");
	}
	
	public void insertAutoCalculation(String expression, Tag tag, Position position) {
		throw new ScriptMistakeException("Not implemented yet");
	}
	
	public void insertCondition(String expression, Tag tag, Position position) {
		throw new ScriptMistakeException("Not implemented yet");
	}
	
	public void addConditionBranch(String expression, Tag tag, Position position) {
		throw new ScriptMistakeException("Not implemented yet");
	}
	
	public void exitApplication() {
		exitWithoutSave();
	}
	
	public void exitWithoutSave() {
		int ignoreOld = ignorePixels;
		ignorePixels = 0;
		leftClickMenuItem("File", "Exit  "); delay(1000);
		ignorePixels = ignoreOld;

		//TODO: NEED TO ESCAPE SAVE DIALOGS HERE
		
		delay(5000);
	}
	
	//---------------------------------------------------------------------------------------
	//-----------------------------               PROJECT MENU  -----------------------------
	//---------------------------------------------------------------------------------------

	protected void escapeProjectDialogs() {
		escapeDialog("Do you want to save the changes to the project", VK_N );
		escapeDialog("Do you want to reload the project", VK_N );
		escapeDialog("Do you wish to automatically close all open documents that belong to this project", VK_N);
		escapeDialog("These files already exist in destination folders of project:", VK_ENTER);


	}
	
	/**
	 * Creates a new Spy Project; escapes dialogs.
	 *
	 */
	public void newProject() {
		leftClickMenuItem("Project", "New Project");
		escapeProjectDialogs();
	}
	
	/**
	 * Opens the specified Spy project; escapes dialogs.
	 * @param name the path/name of the project file.
	 */
	public void openProject(String name) {
		leftClickMenuItem("Project", "Open Project");
		typeFileName(name);
		escapeProjectDialogs();
	}
	
	protected void openProject(String name, String... menuitems) {
		checkFile(name);
		leftClickMenuItem("File", menuitems); delay(1000);
		typeFileName(name); 
		escapeProjectDialogs();
	}
	
	/**
	 * Reloads the active Spy project, discarding any changes.
	 *
	 */
	public void reloadProjectDiscard() {
		leftClickMenuItem("Project", "Reload Project");
		escapeProjectDialogs();
	}
	
	public void reloadProject(int keyPress) {
		leftClickMenuItem("Project", "Reload Project");
		escapeDialog("Do you want to reload the project", keyPress );
	}
	
	/**
	 * Closes the active project, but not the open files.
	 *
	 */
	public void closeProjectOnly() {
		leftClickMenuItem("Project", "Close Project");
		escapeProjectDialogs();
	}
	
	/**
	 * Clicks "Save Project"; nothing else.
	 *
	 */
	public void saveProject() {
		leftClickMenuItem("Project", "Save Project");
	}
	
	/**
	 * Saves the a new Spy project to the specified name; escapes dialogs.
	 * @param name path/name of new project file.
	 */
	public void saveProject(String name) {
		saveProject();
		typeFileName(name);
		escapeDialog("already exists", VK_Y);
		escapeDialog("Confirm Save As", VK_Y);
	}
	
	/**
	 * Ads the specified file to the active project. 
	 * @param name path/name of file to add to project.
	 */
	public void addFilesToProject(String name) {
		leftClickMenuItem("Project", "Add Files to Project");
		assertWindow("Open");
		typeFileName(name);
	}
	
	/**
	 * Ads the specified URL to the active project.
	 * @param url URL to add.
	 */
	public void addUrlToProject(String url) {
		leftClickMenuItem("Project", "Add URL to Project");
		assertWindow("Add URL to project");
		typeFileName(url);
	}
	
	/**
	 * Clicks "Add Active File to Project"; nothing else.
	 */
	public void addActiveFileToProject() {
		leftClickMenuItem("Project", "Add Active File to Project");
	}
	
	/**
	 * Clicks "Add Active and Related Files to Project"; nothing else.
	 */
	public void addActiveAndRelatedFileToProject() {
		leftClickMenuItem("Project", "Add Active and Related Files to Project");
	}
	
	/**
	 * Adds a new folder to the active project.
	 * @param name virtual name of folder 
	 */
	public void addProjectFolderToProject(String name) {
		leftClickMenuItem("Project", "Add Project Folder to Project");
		assertWindow("Properties");
		typeFileName(name);
	}

	/**
	 * not implemented yet
	 * @param name
	 */
	public void addExternalFolderToProject(String name) {
		leftClickMenuItem("Project","Add External Folder to Project");
		assertWindow("Browse For Folder"); //horrible window where no typing is possible :(
	}
	
	/**
	 * Adds the specified URL to the active spy project.
	 * @param url the URL to add
	 */
	public void addExternalWebFolderToProject(String url) {
		leftClickMenuItem("Project", "Add External Web Folder to Project");
		assertWindow("Add Web Folder to Project");

		//tab three times to get to the Server URL field
		keyType(VK_TAB); delay(500);
		keyType(VK_TAB); delay(500);
		keyType(VK_TAB); delay(500);
		
		//then type in the URL, tab to the Browse button and press enter
		//wait for quite a while, since the web can be slooow...
		typeString(url); keyType(VK_TAB); keyType(VK_ENTER); delay(15000);
		
		//then, click in the middle of the "Available files" section
		//this will select the top level of the url, 
		//and enable the OK button of the dialog
		Rectangle r = findComponentName("Available files");
		logger.finest("Available files: "+r);
		leftClickMid(r); delay(500);
		
		keyType(VK_ENTER);
	}
	
	/**
	 * Applies the specified options to the Project Properties, and closes the dialog.
	 * @param options {@link Option} or {@link Options} to apply, or null for nothing.
	 */
	public void projectProperties(Option options) {
		leftClickMenuItem("Project", "Properties");
		assertWindow("Properties");
		applyOptionsEnter("Properties", options);
	}
	
	/**
	 *   expand all Elements (from Root) in SchemaSource window
	 */
	public void expandElement(String name){
		Rectangle myElement = findTag(name, BW);
		rightClick(myElement.x,myElement.y);
		delay(500);
		leftClickString("Expand All");
	}
	
	public void expandElement(String name,String value){
		Rectangle myElement = findTag(name, BW);
		rightClick(myElement.x,myElement.y);
		delay(500);
		leftClickString(value);
	}
	
	public void findElement(String name,TagColor Color){
		Rectangle myElement = findTag(name, Color);
		leftClick(myElement.x,myElement.y);
		delay(500);
	}	
	
	public void expandOneLevelElement(String name){
		Rectangle myElement = findTag(name, BW);
		leftClick(myElement.x,myElement.y);
		delay(500);
		keyType(VK_ADD);
	}
	
	/**
	 * 
	 * Project action via Context Menu
	 * 
	 */
	
	
	public void insertImagefromProjectContextMenu(String imagename,Tag dest, Position position ){
		setCursorPosition(dest, position);
		Rectangle myImageFolder = findTag("Image Files", BW);
		leftClick(myImageFolder.x,myImageFolder.y);delay(500);  //Select Image Folder
		keyType(VK_ADD);										//expand Folder
		Rectangle working = findTag(imagename, BW);
		leftClick(working.x, working.y);   						//select the first item
		delay(500);
		rightClick();
		delay(500);
		leftClickString("Insert Image to Design");
	}
	
	public void insertImagefromProject(String imagename,Tag dest, Position position ){
		Rectangle myImageFolder = findTag("Image Files", BW);
		leftClick(myImageFolder.x,myImageFolder.y);delay(500);  //Select Image Folder
		keyType(VK_ADD);										//expand Folder
		Rectangle working = findTag(imagename, BW);
		leftClick(working.x, working.y);   						//select the first item
		delay(500);
		Point to = besideTagPosition(dest, position);
		dragDrop(working.getLocation(), to);
		delay(500);
		leftClickString("Insert as Image");
	}
	
	public void insertatPosition(String menuitem,Tag dest, Position  position) {
		setCursorPosition(dest,position);delay(500);
		Rectangle Cpos=findTag(dest);
		mouseMove(Cpos.x+Cpos.width,Cpos.y+Cpos.height/2);
		rightClick();delay(500);
		leftClickString(menuitem);
	}
	
	/*
	 * dragTagfromProject  - drag a Tag(FileName) from ProjectFolder (Folder) to Destination dest
	 */
	
	public void dragTagfromProject(String Folder,String FileName,Rectangle dest){
		Rectangle myImageFolder = findTag(Folder, BW);
		leftClick(myImageFolder.x,myImageFolder.y);delay(500);  //Select Image Folder
		keyType(VK_ADD);										//expand Folder
		Rectangle working = findTag(FileName, BW);
		leftClick(working.x, working.y);   						//select the first item
		delay(500);
		Point to = new Point(dest.x,dest.y);
		dragDrop(working.getLocation(), to);
		delay(500);
	}
	public void ContextSPSFilefromProjectAction(String filename,int action) {
		Rectangle myImageFolder = findTag("SPS/PXF Files", BW);
		leftClick(myImageFolder.x,myImageFolder.y);delay(500);  //Select SPS Files Folder
		keyType(VK_ADD);										//expand Folder
		Rectangle working = findTag(filename, BW);
		leftClick(working.x, working.y);   						//select the first item
		delay(500);
		rightClick();
		delay(500);
		switch (action) {
			case 1: leftClickString("Open Design");break;
			case 2: leftClickString("Import as Module");break;
		}
		
	}
	
	
	public void ContextXMLFilefromProjectAction(String filename,int action) {
		Rectangle myImageFolder = findTag("XML Files", BW);
		leftClick(myImageFolder.x,myImageFolder.y);delay(500);  //Select SPS Files Folder
		keyType(VK_ADD);										//expand Folder
		Rectangle working = findTag(filename, BW);
		leftClick(working.x, working.y);   						//select the first item
		delay(500);
		rightClick();
		delay(500);
		switch (action) {
			case 1: leftClickString("Create new Design");break;
			case 2: leftClickString("Add as new Schema Source");break;
			case 3: leftClickString("Assign as Working XML File");break;
			case 4: leftClickString("Assign as Template XML File");break;
		}
	}
	
	public void ContextSCHEMAFilefromProjectAction(String filename,int action) {
		Rectangle myImageFolder = findTag("XML Schema/DTD Files", BW);
		leftClick(myImageFolder.x,myImageFolder.y);delay(500);  //Select SPS Files Folder
		keyType(VK_ADD);										//expand Folder
		Rectangle working = findTag(filename, BW);
		leftClick(working.x, working.y);   						//select the first item
		delay(500);
		rightClick();
		delay(500);
		switch (action) {
			case 1: leftClickString("Create new Design");break;
			case 2: leftClickString("Add as new Schema Source");break;
			case 3: leftClickString("Assign as Schema File");break;
		}
	}
	
	public void SelectFilefromProject(String foldername,String filename){
		Rectangle myProjectFolder = findTag(foldername, BW);
		leftClick(myProjectFolder.x,myProjectFolder.y);delay(500);  //Select ProjectFolder 
		keyType(VK_ADD);										//expand Folder
		Rectangle working = findTag(filename, BW);
		leftClick(working.x, working.y);   						//select the first item
		delay(500);
	}
	
	public void ContextCSSFilefromProjectAction(String filename,int action) {
		Rectangle myImageFolder = findTag("CSS Files", BW);
		leftClick(myImageFolder.x,myImageFolder.y);delay(500);  //Select SPS Files Folder
		keyType(VK_ADD);										//expand Folder
		Rectangle working = findTag(filename, BW);
		leftClick(working.x, working.y);   						//select the first item
		delay(500);
		rightClick();
		delay(500);
		switch (action) {
			case 1: leftClickString("Import into Style Repository");break;
		
		}
	}
	
	public void ContextHTMLFilefromProjectAction(String filename,int action) {
		Rectangle myImageFolder = findTag("HTML Files", BW);
		leftClick(myImageFolder.x,myImageFolder.y);delay(500);  //Select SPS Files Folder
		keyType(VK_ADD);										//expand Folder
		Rectangle working = findTag(filename, BW);
		leftClick(working.x, working.y);   						//select the first item
		delay(500);
		rightClick();
		delay(500);
		switch (action) {
			case 1: 
				leftClickString("Create new Design");delay(1000);
				escapeDialog("The imported HTML file", VK_Y);
				maximizeFileWindow(true);
				break;
		
		}
		
		
	}
	
	/**
	 * select Design tree and expand section e.g. Modules
	 * @param section
	 */
	public void DesignTree_expand_Section(String section){
		Rectangle myImageFolder = findTag(section, BW);
		leftClick(myImageFolder.x,myImageFolder.y);delay(500);  //Select section
		keyType(VK_ADD);										//expand section
	}
	
	/**
	 * select Folder named @string and expand e.g. External in Style Repository
	 * @param string
	 */
	public void expand_Folder(String string){
		Rectangle myImageFolder = findTag(string, BW);
		leftClick(myImageFolder.x,myImageFolder.y);delay(500);  //Select section
		keyType(VK_ADD);										//expand section
	}
	/**
	 * find_strg_f - calls find and searches for string
	 * get new cursor location  
	 * @param string
	 */
	public void find_strg_f(String string){
		keyTypeCtrl(KeyEvent.VK_F);delay(500);
		//keyTypeShift(KeyEvent.VK_HOME);delay(500);
		keyTypeAlt(KeyEvent.VK_N);delay(500);
		typeStringEnter(string);delay(500);
		keyType(KeyEvent.VK_ESCAPE);
	}
	/**
	 * addSylesheetParamter in DesignView
	 * @param name
	 * @param value
	 */
	public void addStylesheetParameter(String name,String value){
		leftClickMenuItem("Edit", "Stylesheet Parameters...");
		setView(View.ICON_APPEND);
		typeString(name);keyType(KeyEvent.VK_TAB);
		typeString(value);
		leftClickButton("OK");delay(1000);
	}
	/**
	 * addAutoCalc expression
	 * @param value
	 */
	public void addAutoCalc(String value){
		leftClickMenuItem("Insert", "Insert Auto-Calculation","Value");
		typeString(value);
		leftClickButton("OK");delay(1000);
	}
	public void addFilter(String name,String value,String button){
		leftClickMenuItem("Database", "Edit DB Filter");  
		leftClickButton(button);
		typeString(name);
		keyType(KeyEvent.VK_TAB);keyType(KeyEvent.VK_TAB); //2x TAB to select Edit field
		typeString(value);delay(500);
		leftClickButton("OK");delay(1000);
	}
	public void clearDBFilter(){
		leftClickMenuItem("Database", "Clear DB Filter");  
		addEscapeDialogAction("Do you really want to delete the filters", VK_ENTER);
		waitAndEsacpe("");
	}
	public void setProperty(RadioOption options){
		leftClickMenuItem("File","Properties...");
		delay(2000);
		assertWindow("Properties");
		if(options!=null){
		options.applyOption(this);
		leftClickButton("OK");delay(1000);
		}
	}
	
	public void RestoreToolbars() {
		leftClickMenuItem("Tools","Restore Toolbars");
		leftClickButton("OK");delay(1000);
		delay(20000);
	}
	
	public void pasteAs(String string) {
		leftClickString(string);
	}
	
	public void SetRichEdit(String myStyle) {
		leftClickMenuItem("Authentic","RichEdit" ,myStyle);
	}
	/*
	 * SelectLine -  does not work as expected  ....multiple line selection in authentic does not work with
	 */
	public void SelectLine(int number) {
		//leftClickMenuItem("Authentic","RichEdit" ,myStyle);
		keyPress(VK_SHIFT);
		for (int i = 0;i<number;i++){
			keyType(KeyEvent.VK_DOWN);delay(1000);
		}
		keyRelease(VK_SHIFT);
		
	}
	
}

