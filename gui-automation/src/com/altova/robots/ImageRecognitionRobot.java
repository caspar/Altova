package com.altova.robots;
import static com.altova.util.LoggerUtils.logger;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;

import com.altova.util.IOUtils;
import com.altova.util.Settings;


/**
 * Convenience class for applications with buttons in mind.  
 * 
 * @author Havard Rast Blok
 *
 */
public class ImageRecognitionRobot extends GenericRobot {
	
	//private final static int BLACK = 0;

	private final static int HALF = (128 << 16)+(128 << 8)+128;
	
	final static int WHITE = (255 << 16)+(255 << 8)+255;
	
	//private final static int RED_HALF = (255/2 << 16);
	final static int RED = (255 << 16);
	
	private final static int BLUE_HALF = 255/2;
	
	/**
	 * Default font used for menus, menu items, etc.
	 */
	public final static Font WINDOWS_DEFAULT_FONT = new Font("Tahoma", Font.PLAIN, 11);
	
	/**
	 * Font used for Altova content, like the Model Tree, Entry helpers, etc. 
	 */
	public final static Font DEFAULT_CONTENT_FONT = new Font("Arial", Font.PLAIN, 11);

	/**
	 * Font for dialog boxes, Option windows, etc.
	 * Including small options boxes, like Find, etc.
	 */
	public final static Font MS_SHELL_DLG_FONT = new Font("Microsoft Sans Serif", Font.PLAIN, 11);
	
	public final static Color TRANSPARENT = new Color(255, 255, 255, 0);
	
	protected final static Color BLUE_SELECTED = new Color(10, 36, 106, 0);
	
	protected final static Color GREY_SELECTED = new Color(212, 208, 200, 0);
	
	protected static Color GRAY_IN_VS2010_MENU=new Color (27,41,62);
	/**
	 * Pixel color compare methods. 
	 * BLACK_WHITE is a 2 bits comparison.
	 * FULL_COLOR is 24 bits full color
	 */
	protected enum PixelCompare { BLACK_WHITE, FULL_COLOR, INTERVAL };

	protected static final PixelCompare DEFAULT_PIXEL_COMPARE = PixelCompare.INTERVAL;
	
	/**
	 * The current compare method for images. Default is color interval.
	 * 
	 * TODO: SHOULD BE PROTECTED. HACK FOR ROBOTSCENTER
	 */
	public PixelCompare compareState = DEFAULT_PIXEL_COMPARE;

	
	/**
	 * Number of pixels to ignore when comparing an image to any segment of
	 * the screen. In some cases further pixels will be ignored, e.g. for
	 * certain letters.
	 */
	protected int ignorePixels = 0;
	
	/**
	 * Indicate whether images for debugging the image compared should
	 * be saved when the search fails.
	 */
	protected boolean outputDebugImages = Settings.debugImages();
	
	//TODO: SHOULD BE PROTECTED. HACK FOR ROBOTSCENTER
	public boolean debugSuccess = false;
	
	//TODO: SHOULD BE PROTECTED. HACK FOR ROBOTSCENTER
	public File debugImages[] = null;
	
	private BufferedImage debugImage;
	
	private boolean debugImageModified;
	
	public ImageRecognitionRobot() {
	}
	
	/**
	 * Left-click in the middle of the portion on screen which contains the 
	 * specified string using the default Windows font and size for menus.
	 * 
	 * @param str the string to search for
	 * @throws ImageNotFoundException if the image was not found
	 */
	protected void leftClickString(String str) {
		leftClickString(str, WINDOWS_DEFAULT_FONT);
	}

	/**
	 * Left-click in the middle of the portion on screen which contains the 
	 * specified string using the specified font on a black on white background.
	 * 
	 * @param str the string to search for
	 * @param font the font used for the string
	 * @throws ImageNotFoundException if the image was not found
	 */
	protected void leftClickString(String str, Font font) {
		leftClickMid( findString(str, font ) );
	}

	/**
	 * Left-click in the middle of the portion on screen which contains the 
	 * specified string using the specified font and color, and optional hint area.
	 * 
	 * @param str the string that was used in the createImage method
	 * @param font the font used for the string
	 * @param text the color of the string
	 * @param hint the area on screen where the image is thought to be (or was found last time).
	 *        if null, search the full.
	 * @throws ImageNotFoundException if the image was not found 
	 */
	protected void leftClickString(String str, Font font, Color text, Rectangle hint) {
		leftClickMid( findString(str, font, TRANSPARENT, text, hint, false) );
	}
	
	/**
	 * Right-click in the middle of the portion on screen which contains the 
	 * specified string using the default Windows font and size for menus.
	 * 
	 * @param str the string to search for
	 * @throws ImageNotFoundException if the image was not found
	 */
	protected void rightClickString(String str) {
		rightClickString(str, WINDOWS_DEFAULT_FONT);
	}

	/**
	 * Right-click in the middle of the portion on screen which contains the 
	 * specified string using the specified font on a black on white background.
	 * 
	 * @param str the string to search for
	 * @param font the font used for the string
	 * @throws ImageNotFoundException if the image was not found
	 */
	protected void rightClickString(String str, Font font) {
		rightClickMid( findString(str, font ) );
	}
	
	/**
	 * Searches for the portion on screen which contains the 
	 * specified string using the default Windows font and size for menus.
	 * 
	 * @param string the string to search for
	 * @return a Rectangle the size of the specified string, and X,Y in the upper left corner
	 * of the area on screen where the image was found.
	 * @throws ImageNotFoundException if the image was not found
	 */
	protected Rectangle findString(String string) {
		return findString(string, WINDOWS_DEFAULT_FONT);
		
	}
	
	/**
	 * Searches for the portion on screen which contains the 
	 * specified string using the specified font on a black on transparent background
	 * (which means it is ignored).
	 * 
	 * @param string the string to search for
	 * @param font the font used for the string
	 * @return a Rectangle the size of the specified string, and X,Y in the upper left corner
	 * of the area on screen where the image was found.
	 * @throws ImageNotFoundException if the image was not found
	 */
	protected Rectangle findString(String string, Font font) {
		return findString(string, font, TRANSPARENT, Color.BLACK, null, true); 
	}

	/**
	 * Searches for the portion on screen which contains the 
	 * specified string using the specified font and color.
	 * 
	 * @param string the string to search for
	 * @param font the font used for the string
	 * @param back the background color of the string
	 * @param text the color of the string
	 * @return a Rectangle the size of the specified string, and X,Y in the upper left corner
	 * of the area on screen where the image was found.
	 * @throws ImageNotFoundException if the image was not found
	 */
	protected Rectangle findString(String string, Font font, Color back, Color text) {
		return findString(string, font, back, text, null, true);
	}
	
	/**
	 * Searches for the portion on screen which contains the 
	 * specified string using the specified font and text color, and transparent background.
	 * 
	 * @param string the string to search for
	 * @param font the font used for the string
	 * @param text the color of the string
	 * @return a Rectangle the size of the specified string, and X,Y in the upper left corner
	 * of the area on screen where the image was found.
	 * @throws ImageNotFoundException if the image was not found
	 */
	protected Rectangle findString(String string, Font font, Color text) {
		return findString(string, font, TRANSPARENT, text, null, true);
	}
	
	/**
	 * Searches for the portion on screen which contains the 
	 * specified string using the the default Windows font and size, black text color,
	 * and transparent background.
	 * 
	 * @param string the string to search for
	 * @param hint the area on screen where the image is thought to be (or was found last time).
	 *        if null, search the full screen.
	 * @param searchWholeScreen continue searching the full screen if the area of hint 
	 *        did not containing the image
	 * @return a Rectangle the size of the specified string, and X,Y in the upper left corner
	 * of the area on screen where the image was found.
	 * @throws ImageNotFoundException if the image was not found
	 */
	protected Rectangle findString(String string, Rectangle hint, boolean searchWholeScreen) {
		return findString(string, WINDOWS_DEFAULT_FONT, TRANSPARENT, Color.BLACK, hint, searchWholeScreen);
	}
	protected Rectangle findString(String string, Font font, Rectangle hint, boolean searchWholeScreen) {
		return findString(string, font, TRANSPARENT, Color.BLACK, hint, searchWholeScreen);
	}
	/**
	 * Left click the screen area looking like the specified image.
	 * @param iconFile
	 * @throws ScriptMistakeException
	 */
	public void leftClickImage(String iconFile) {
		leftClickMid( findImage(iconFile) );
		
	}
	public void leftClickImage(String iconFile, Rectangle hint, boolean searchWholeScreen){
		leftClickMid( findImage(iconFile, hint, searchWholeScreen));
	}
	
	/**
	 * Left click the screen area looking like the specified image.
	 * @param iconFile
	 * @throws ScriptMistakeException
	 */
	public void rightClickImage(String iconFile) {
		rightClickMid( findImage(iconFile) );
	}
	
	/**
	 * Left click the screen area looking like the specified image.
	 * @param icon
	 * @throws ScriptMistakeException
	 */
	protected void leftClickImage(BufferedImage icon) {
		leftClickMid( find(icon) );
	}
	
	/**
	 * Find the area on screen equal to the specified image file.
	 * Return the coordinates of the area, or null if not found.
	 * 
	 * @param iconFile the path of the file containing an image to search for
	 * @return A Rectangle the size of the specified button, and X,Y in the upper left corner
	 * of the area on screen where the button was found.
	 * @throws ScriptMistakeException if the specified path was invalid
	 */
	protected Rectangle findImage(String iconFile) {
		return find(ImageUtils.readIcon(iconFile));
	}
	
	
	/**
	 * Find the area on screen matching the specified image file.
	 * Return the coordinates of the area, or null if not found.
	 * 
	 * @param iconFile the path of the file containing an image to search for
	 * @return A Rectangle the size of the specified button, and X,Y in the upper left corner
	 * of the area on screen where the button was found.
	 * @throws ScriptMistakeException if there was an error reading the file
	 * @throws ImageNotFoundException if the image was not found
	 */
	protected Rectangle findImage(URL iconFile) {
		return find(ImageUtils.readIcon(iconFile));
	}
	
	protected Rectangle findImage(String iconFile, Rectangle hint, boolean searchWholeScreen) {
		return find(ImageUtils.readIcon(iconFile), hint, searchWholeScreen);
	}
	
	/**
	 * Returns a BufferedImage of the specified image or icon file. If the specified
	 * file cannot be decoded as an image, null is returned.
	 * 
	 * @param iconFile file to read from
	 * @return a BufferedImage containing the decoded contents of the input, or null.
	 * @throws ScriptMistakeException if there was an error reading the file
	 */
	protected BufferedImage readIcon(String iconFile) {
		return ImageUtils.readIcon(iconFile);
	}
	
	/**
	 * Searches for the portion on screen which contains the 
	 * specified string using the specified font and color, and optional hint area.
	 * 
	 * It is also taking into account the actual letters searched for. This issues is
	 * that even when the correct font is selected to create an image from the string,
	 * some letters will not match what's on screen. For example, the 'n' will have two
	 * pixels differ. Therefore, more mismatching pixels are ignored when this letters
	 * are present in the string.   
	 * 
	 * @param string the string that was used in the createImage method
	 * @param font the font used for the string
	 * @param background the background color of the string
	 * @param text the color of the string
	 * @param hint the area on screen where the image is thought to be (or was found last time).
	 *        if null, search the full screen.
	 * @param searchWholeScreen continue searching the full screen if the area of hint 
	 *        did not containing the image
	 * @return a Rectangle the size of the specified image, and X,Y in the upper left corner
	 * of the area on screen where the image was found.

	 * @throws ImageNotFoundException if the image was not found 
	 */
	protected Rectangle findString(String string, Font font, Color background, Color text, Rectangle hint, boolean searchWholeScreen) {
		int oldIgnoreCount = this.ignorePixels;
		
		//text search can be a bit tricky - let's start with ignoring 3 pixels..
		ignorePixels = 3;
		
		//let's ignore more pixels for specific letters.
		for(char c : string.toCharArray()) {
			//BE AWARE, these are case sensitive
			switch(c) {
				case('m'): ignorePixels+=3; break;
				case('M'): ignorePixels+=7; break;
				case('n'): ignorePixels+=2; break;
				case('s'): ignorePixels+=4; break;
				case('v'): ignorePixels+=2; break;
				case('V'): ignorePixels+=2; break;
				case('X'): ignorePixels+=4; break;
			}
		}
		
		Rectangle ans = null;
		try {
			BufferedImage img = createImage(string, font, background, text);
			ans = find(img, hint, searchWholeScreen);
		} finally {
			this.ignorePixels =  oldIgnoreCount;
		}
		
		return ans;		
	}
	
	/**
	 * Find the area within the area of the specified hint rectangle, or 
	 * somewhere else on the screen, matching the specified image.
	 * Returns the coordinates of the area, or throws an ImageNotFoundException if not found.
	 * 
	 * This method can be used to provide a hint to the search algorithm as to where to find
	 * the matching position on screen, and thus speeding up the method. If the specified
	 * icon is not found at the position of hint, the full screen is searched.
	 * 
	 * @param icon an image to search for
	 * @param hint the area on screen where the image is thought to be (or was found last time).
	 *        if null, search the full screen.
	 * @return a Rectangle the size of the specified image, and X,Y in the upper left corner
	 * of the area on screen where the image was found.
	 * @throws ImageNotFoundException if the image was not found
	 */
	protected Rectangle find(BufferedImage icon, Rectangle hint) {
		return find(icon, hint, true);
	}

	/**
	 * Find the area on screen matching the specified image.
	 * Returns the coordinates of the area, or throws an ImageNotFoundException if not found.
	 * This method includes the algorithm to search for a the same image multiple times,
	 * if not found at once. It this is done to prevent failures due to lagging GUI features.
	 * Currently, the default retry count is 3.
	 * 
	 * @param icon an image to search for
	 * @return a Rectangle the size of the specified image, and X,Y in the upper left corner
	 * of the area on screen where the image was found.
	 * @throws ImageNotFoundException if the image was not found
	 */
	protected Rectangle find(BufferedImage icon) {
		//capture the full screen of the primary monitor
		Rectangle screen = ImageUtils.getDefaultScreenDimension();
		return find(icon, screen, false);
	}
	
	/**
	 * Find the area within the area of the specified hint rectangle, or 
	 * somewhere else on the screen, matching the specified image if searchWholeScreen is true.
	 * Returns the coordinates of the area, or throws an ImageNotFoundException if not found.
	 * 
	 * This method can be used to provide a hint to the search algorithm as to where to find
	 * the matching position on screen, and thus speeding up the method. If the specified
	 * icon is not found at the position of hint and searchWholeScreen is true,
	 * the full screen is searched.
	 * 
	 * @param icon an image to search for
	 * @param hint the area on screen where the image is thought to be (or was found last time).
	 *        if null, search the full screen.
	 * @param searchWholeScreen continue searching the full screen if the area of hint 
	 *        did not containing the image
	 * @return a Rectangle the size of the specified image, and X,Y in the upper left corner
	 * of the area on screen where the image was found.
	 * @throws ImageNotFoundException if the image was not found
	 */
	protected Rectangle find(BufferedImage icon, Rectangle hint, boolean searchWholeScreen) {
		//wait till no more robot moves are pending
		waitForIdle();
		
		//search whole screen
		if(hint == null) {
			return find(icon);
		}
		
		//try a few times
		int attempt = 0;
		int maxAttempts = 3;
		
		BufferedImage screen = null;
		while (attempt < maxAttempts) {

			screen = createScreenCapture(hint);

			if(outputDebugImages) {
				debugImage = createScreenCapture(hint);
				debugImageModified = false;
			}
			
			//search within the hint area
			Rectangle r = find(icon, screen);
			if(r != null ) {
				r.translate(hint.x, hint.y);
				if(debugSuccess) {
					logger.fine("Image found. Logging success. r="+r);
					debugImages = writeDebugImages(screen, icon);
				}
				return r;
			}

			attempt++;
			logger.fine("Waiting a bit and retrying. Attempt="+attempt);
			delay(500);
		}
		
		debugImages = null;
		if(outputDebugImages) {
			logger.fine("Could not find icon.");
			debugImages = writeDebugImages(screen, icon);
		}
		
		if(searchWholeScreen) {
			if(hint != null) {
				logger.fine("Searching whole screen as well.");
			}
			return find(icon);
		}
		
		if(debugImages != null) {
			throw new ImageNotFoundException("Icon not found on screen.", compareState, ignorePixels, debugImages[0], debugImages[1], debugImages[2]);
		}
		else {
			throw new ImageNotFoundException("Icon not found on screen.", compareState, ignorePixels);
		}
		
		
	}
	
	private File[] writeDebugImages(BufferedImage screen, BufferedImage icon) {
		File ans[] = new File[4];
		
		try {
			String id = IOUtils.getFileId();
			logger.fine("Debug image id: "+id+ ". Mode used="+compareState.name()+ ". ignorePixels="+ignorePixels);
			ans[0] = ImageUtils.saveImage(screen, "robotdebug_"+id+"_screen", true);
			ans[1] = ImageUtils.saveImage(icon, "robotdebug_"+id+"_icon", true);
			if(debugImageModified) {
				ans[2] = ImageUtils.saveImage(debugImage, "robotdebug_"+id+"_screen-debug", true);
			}
			BufferedImage fullScreenImage = createScreenCapture(ImageUtils.getDefaultScreenDimension());
			ans[3] = ImageUtils.saveImage(fullScreenImage, "robotdebug_"+id+"_fullscreen", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ans;
	}

	/**
	 * Find the area on screen equal to the specified image.
	 * Return the coordinates of the area, or null if not found.
	 * 
	 * @param icon an image to search for
	 * @param screen the image to search in (most often a screen shoot)
	 * @return a Rectangle the size of the specified image, and X,Y in the upper left corner
	 * of the area on screen where the image was found. Or null if the images was not found.
	 */
	protected Rectangle find(BufferedImage icon, BufferedImage screen) {
		if(icon == null) {
			throw new NullPointerException("Icon to search for cannot be null");
		}
		
		//look at the upper left pixel of the image to search for
		int firstPixel = icon.getRGB(0, 0);
		
		int width = screen.getWidth();
		int height = screen.getHeight();

		// loop through, starting in the upper left corner of the screen
		// capture, and search for the first pixel of the image
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int c = screen.getRGB(x, y);
				// if found, do a more detailed comparison
				if (comparePixels(c, firstPixel)) {
					if (compare(x, y, screen, icon)) {
						return new Rectangle(x, y, icon.getWidth(), icon
								.getHeight());
					}
				}
			}
		}

		return null;
	}
	
	/**
	 * Compare the specified image in the specified screen capture, at the given screen location.
	 * That is, the (xStart,yStart) coordinate of the screen capture is compared to (0,0) of the image.
	 * If the image matched that area of the screen, true is returned, otherwise false.
	 * 
	 * The pixel comparison is determined by the method comparePixels(int, int) below.  
	 * 
	 * @param xStart screen capture coordinate to start comparison on
	 * @param yStart screen capture coordinate to start comparison on
	 * @param screen an image containing a full screen capture
	 * @param img the image to compare
	 * @return true if the image equals the given area on screen
	 */
	private boolean compare(int xStart, int yStart, BufferedImage screen, BufferedImage img ) {
		int width = img.getWidth();
		int height = img.getHeight();
		int screenWidth = screen.getWidth();
		int screenHeight = screen.getHeight();
		
		int wrongPixels = 0;
		int i = 0;
		
		//loop through the area on screen similar to the size of the image
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int scrX = x+xStart;
				int scrY = y+yStart;
				if(scrX >= screenWidth || scrY >= screenHeight) {
					return false;
				}
				
				int scrC = screen.getRGB(scrX, scrY);
				int imgC = img.getRGB(x, y);
				i++;

				//compare each pixel
				//stop at first pixel differing
				if( !comparePixels(scrC, imgC) ) {
					wrongPixels++;

					if(wrongPixels > ignorePixels) {
						if(outputDebugImages && y > 1 && debugImage != null) {
							debugImage.setRGB(scrX, scrY, RED);
							debugImageModified = true;
						}
						
						return false;
					}
				}
				else if(outputDebugImages  && y > 1 && debugImage != null) {
					debugImage.setRGB(scrX, scrY, scrC+BLUE_HALF);
					debugImageModified = true;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Compare to pixel values, using the current compare method as set by the field compareState.
	 * 
	 * The problem with full color comparison is that a straight forward integer comparison might be difficult.
	 * The image will often contain an almost black/white version, while the toolbar on screen
	 * might use fancy shadings etc. (So therefore, gray in the image will not equal gray on screen).
	 * To solve this, a rather crude black/white comparison is done. Either both pixels are dark,
	 * or they are light, in which case this method return true. Otherwise, the two pixels are assumed
	 * to be not equal.
	 * 
	 * @param pixel1 RGB color value of first pixel
	 * @param pixel2 RGB color value of second pixel
	 * @return true if they are the same according to the current compare method
	 */
	private boolean comparePixels(int pixel1, int pixel2) {

		if (compareState == PixelCompare.FULL_COLOR) {
			return pixel1 == pixel2;
		}
		else if( compareState == PixelCompare.BLACK_WHITE) {
			int p1 = -pixel1;
			int p2 = -pixel2;

			return p1 < HALF && p2 < HALF || p1 > HALF && p2 > HALF;
		}

		int alpha1_val = (pixel1 >>> 24) & 0xFF;
		int alpha2_val = (pixel2 >>> 24) & 0xFF;
		
		if(alpha1_val == 0 || alpha2_val == 0) {
			return true;
		}
		
		int channels1[] = ImageUtils.getChannels(pixel1);
		int red1_val = channels1[2];
		int green1_val = channels1[1];
		int blue1_val = channels1[0];
		//int black_white1 = (red1_val + green1_val + blue1_val) / 3;
		
		int channels2[] = ImageUtils.getChannels(pixel2);
		int red2_val = channels2[2];
		int green2_val = channels2[1];
		int blue2_val = channels2[0];
		//int black_white2 = (red2_val + green2_val + blue2_val) / 3;

		
		int diffred = Math.abs(red1_val - red2_val);
		int diffgreen = Math.abs(green1_val - green2_val);
		int diffblue = Math.abs(blue1_val - blue2_val);
		//int diffblack_white = Math.abs(black_white1 - black_white2);

		//not using the diffblack_white average anymore
		//this caused some problems when searching for the grey fonts
		//in the Styles and Properties windows (in UModel)
		
		if (((diffred <= 10) && (diffgreen <= 10) && (diffblue <= 10))
				//|| (diffblack_white <= 30)
				) {

			return true;
		}

		return false;

	}
	
	
	/**
	 * Creates an image containing the specified string using the specified
	 * colors and font. The bottom of the image will be cut by four pixels, to
	 * avoid conflicts when searching for underlined text, e.g. in menu and menu
	 * items.
	 * 
	 * @param str
	 *            the string to be drawn
	 * @param font
	 *            the font to be used
	 * @param backGround
	 *            background color in the return image
	 * @param text
	 *            color of the text
	 * @return a 32-bits (8-bits for each of RGBA) image of the string
	 */
	protected BufferedImage createImage(String str, Font font, Color backGround, Color text) {
		logger.log(Level.FINE, "createImage("+str+", font: " + font + ", bkgClr:" + backGround + ", color: " + text);
		if(backGround==null||text==null){
			throw new IllegalArgumentException("A background and text color must be specified");
		}
		// create a temporary image context to calculate the size of the string
		BufferedImage imgTmp = new BufferedImage(30, 15, BufferedImage.TYPE_BYTE_BINARY);
		Graphics gTmp = imgTmp.getGraphics();

		// get the string size details
		FontMetrics met = gTmp.getFontMetrics(font);
		Rectangle2D rTmp = met.getStringBounds(str, gTmp);
		Rectangle size = new Rectangle((int)rTmp.getWidth(), (int)rTmp.getHeight());
		int ascent = met.getAscent();
		
		// create the actual image
		// NOTE THAT THE HEIGHT IS CUT BY 4
		// THIS IS TO AVOID GETTING ANY CONFLICTS WITH UNDERLINED TEXT
		// TYPICALLY USED IN MENUITEMS ETC. This might have to be improved upon.
		BufferedImage img = new BufferedImage(size.width, size.height-4, BufferedImage.TYPE_4BYTE_ABGR);
		// BufferedImage img = new BufferedImage(size.width, size.height-4,
		// BufferedImage.TYPE_BYTE_BINARY);
		Graphics g = img.getGraphics();
		
		// draw the string on the specified background with specified color and
		// font
		g.setColor(backGround);
		g.fillRect(0,0, size.width, size.height);
		g.setColor(text);
		g.setFont(font);
		g.drawString(str, 0, ascent-3);
		logger.finest("End createImage for: " + str);
		
		return img;
	}
	

	/**
	 * Takes a snapshoot of the specified screen area and saves it to the given
	 * file name in the predefined output directory. See the
	 * {@link Settings} class for details about this directory setting.
	 * 
	 * @param area
	 *            coordinates to make a screen shoot of
	 * @param file
	 *            file name (and possible relative path) of new file
	 * @return the exact location of the image file
	 * @throws IOException
	 *             if writing the image failed
	 */
	public File saveScreen( Rectangle area, String file ) throws IOException {
		return saveScreen(area, file, false);
	}

	/**
	 * Takes a snapshoot of the specified screen area and saves it to the given
	 * file name to either the predefined output or debug directory. See the
	 * {@link Settings} class for details about these directory settings.
	 * 
	 * @param area
	 *            coordinates to make a screen shoot of
	 * @param file
	 *            file name (and possible relative path) of new file
	 * @param debug
	 *            true if file should be located in the debug folder, otherwise
	 *            the output folder is used
	 * @return the exact location of the image file
	 * @throws IOException
	 *             if writing the image failed
	 */
	public File saveScreen( Rectangle area, String file, boolean debug ) throws IOException {
		BufferedImage img = createScreenCapture(area);
		return ImageUtils.saveImage(img, file, debug);
	}
	
	/**
	 * Takes a full screen snapshoot and saves it to the given
	 * file name in the predefined output directory. See the
	 * {@link Settings} class for details about this directory setting.
	 * 
	 * @param file
	 *            file name (and possible relative path) of new file
	 * @return the exact location of the image file
	 * @throws IOException
	 *             if writing the image failed
	 */
	public File saveFullScreenDebug( String file ) {
		try {
			return saveScreen(ImageUtils.getDefaultScreenDimension(), file, true);
		} catch (IOException e) {
			logger.severe("Could not save debug image: "+e);
		}
		
		return null;
	}
}
