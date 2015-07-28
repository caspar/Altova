package com.altova.robots;

import static com.altova.util.LoggerUtils.logger;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import com.altova.util.IOUtils;
import com.altova.util.Settings;

/**
 * This class contains various static utility methods for handling images
 * operations, including reading icons and images; making and writing screen
 * shoots; and handling some image transparency issues.
 * 
 * @author Havard Rast Blok
 * 
 */
public class ImageUtils {
	
	private static final int BG_IDX = 192;
	
	private final static int TRANSPARENT_COLOR = (0 << 24) + (BG_IDX << 16) + (BG_IDX << 8) + BG_IDX;
	
	private final static int ICON_BACKGROUND_COLOR = (255 << 24) + TRANSPARENT_COLOR;

	//avoid construction
	private ImageUtils() {
	}
	
	/**
	 * Returns the dimension of the default screen device with it's default
	 * configuration.
	 * 
	 * @return dimension of the screen.
	 */
	public static Rectangle getDefaultScreenDimension() {
		GraphicsEnvironment env = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		GraphicsDevice device = env.getDefaultScreenDevice();
		GraphicsConfiguration config = device.getDefaultConfiguration();
		return config.getBounds();
	}
	
	/**
	 * Return the URL of the specified resource. If the resource exists as
	 * a file on the file system, a URL using the 'file:' protocol format is returned.
	 * Otherwise the default ClassLoader is queried for the resource. If this does
	 * not return a URL, a FileNotFoundException is thrown.
	 * 
	 * @param iconFile resource path file to find 
	 * @return a URL where the file can be found
	 * @throws ScriptMistakeException if there was an error creating the URL or 
	 *  the resource was not found on the file system or
	 *         in the classpath.
	 */
	protected static URL getIconURL(String iconFile) {
		return IOUtils.findResource(iconFile);
	}
	
	protected static URL getIconURL_old(String iconFile) {
		try {
			// first try to file on the file system
			File file = new File(iconFile);
			if (file.exists()) {
				return new URL("file:" + file);
			}

			// if not on the file system, try to find it in the current JAR
			URL resource = ImageUtils.class.getClassLoader().getResource(iconFile);
			if (resource != null) {
				return resource;
			}

			// if the file could not be found, throw exception
			throw new FileNotFoundException("Icon file " + iconFile
					+ " could not be found");
		} catch (IOException e) {
			throw new ScriptMistakeException("Could not get icon.", e);
		}
	}
	
	/**
	 * Returns a BufferedImage of the specified image or icon file. If the specified
	 * file cannot be decoded as an image, null is returned.
	 * 
	 * @param iconFile file to read from
	 * @return a BufferedImage containing the decoded contents of the input, or null.
	 * @throws ScriptMistakeException if there was an error reading the file
	 */
	public static BufferedImage readIcon(String iconFile) {
		URL url = getIconURL(iconFile);
		if(url == null) {
			String msg = "File not found: "+iconFile;
			logger.severe(msg);
			throw new ScriptMistakeException(msg);
		}
		
		return readIcon(url);
	}
	
	/**
	 * Returns a BufferedImage of the specified URL. If the specified
	 * URL cannot be decoded as an image, null is returned.
	 * 
	 * @param iconFile file to read from
	 * @return a BufferedImage containing the decoded contents of the input, or null.
	 * @throws ScriptMistakeException if there was an error reading the file
	 */
	public static BufferedImage readIcon(URL iconFile) {
		BufferedImage img;
		try {
			img = ImageIO.read(iconFile);
			
			if(img == null) {
				throw new IOException("Failed to read file. No registered ImageReader claims to be able to read the resulting stream, it seems.");
			}
		} catch (IOException e) {
			//wrap this exception, since the error does not indicate which file fails
			IOException e2 = new IOException("Reading file failed: "+iconFile);
			e2.initCause(e);
			throw new ScriptMistakeException("Could not read icon. ", e2);
		}
		
		return img;
	}
	
	/**
	 * Saves the specified image to file using the specified file type.
	 * 
	 * @param img
	 *            image to save
	 * @param file
	 *            file and path name of new image
	 * @param type
	 *            file format supported by the Java ImageIO framework. See the
	 *            javax.imageio package for details.
	 * @throws IOException
	 *             if writing the image failed
	 */
	public static void saveImage(BufferedImage img, File file, String type) throws IOException {
		//set the image file format to use for frame saving
		Iterator ite = ImageIO.getImageWritersByFormatName( type );
		ImageWriter imgWriter = (ImageWriter) ite.next();
		
		try {
			//try to create parent directories
			File parent = file.getParentFile();
			if(parent != null) {
				parent.mkdirs();
			}
			
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(file));
			ImageOutputStream ios = ImageIO.createImageOutputStream(bout);

			imgWriter.setOutput(ios);
			imgWriter.write(img);

			ios.close();
			bout.close();
		} catch (IOException e) {
			IOException e2 = new IOException("Error writing image "+file);
			e2.initCause(e);
			throw e2;
		}
		
		logger.finer( "Written image to "+file.getAbsolutePath() );
	}
	
	/**
	 * Saves the specified image with the given file name to either predefined
	 * output or debug directory. See the {@link Settings} class for details
	 * about these directory settings.
	 * 
	 * @param img
	 *            image to save
	 * @param file
	 *            file name (and possible relative path) of new file
	 * @param debug
	 *            true if file should be located in the debug folder, otherwise
	 *            the output folder is used
	 * @return the exact location of the image file
	 * @throws IOException
	 *             if writing the image failed
	 */
	public static File saveImage( BufferedImage img, String file, boolean debug ) throws IOException {
		File base = debug ? Settings.getDebugDir() : Settings.getOutputDir();
		String fileExt = debug ? "png" : "png";
		if(!file.toLowerCase().endsWith(fileExt)) {
			file = file+="."+fileExt;
		}
		
		if(fileExt.equals("bmp")) {
			img = convert(img);
		}
		
		File dest = new File(base, file);
		saveImage(img, dest, fileExt);
		return dest;
	
	}

	/**
	 * Converts specified image to an indexed 256 color model. 
	 * 
	 * @param img the image to convert
	 * @return a new image object with an index color model
	 */
	private static BufferedImage convert(BufferedImage img) {
		BufferedImage newImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_INDEXED);
		Graphics g = newImg.getGraphics();
		g.drawImage(img, 0, 0, null);
		
		return newImg;
	}


	/**
	 * Returns the point in the middle of the specified rectangle.
	 * 
	 * @param rect rectangle with screen coordinates
	 * @return the coordinate in the middle of the rectangle 
	 */
	public static Point findMid(Rectangle rect) {
		int x = rect.x+(rect.width/2);
		int y = rect.y+(rect.height/2);
	
		return new Point(x, y);
	}
	
	/**
	 * Checks whether the specified image support the alpha transparency channel,
	 * and if it does not, converts it to a BufferedImage which does. 
	 * 
	 * If the input image already support transparency, nothing is done, and the
	 * same object is returned. 
	 * 
	 * @param img input image
	 * @return the same image if the input already support transparency, 
	 * 	or a new image which is a copy of the input.
	 */
	public static BufferedImage enableTransperancy(BufferedImage img) {
		//check if we'll have to redraw the image, to use a 4 byte color space, including alpha
		if( img.getTransparency() != Transparency.OPAQUE) {
			return img;
		}
		
		BufferedImage ans = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = ans.getGraphics();
		g.drawImage(img, 0, 0, null);
		
		return ans;
	}
	
	/**
	 * Converts any pixels of the specified image which has the transparency
	 * color index into a pixel with full transparency on the alfa chanel
	 * instead. This is later used when comparing the image to a screen shoot,
	 * and ignoring the transparent pixels. However, since the comparison
	 * algorithm is working with the alpha chanel rather than the transparency
	 * index, this conversion is done when loading the image.
	 * <p>
	 * Just to clarify this. When we talk about a transparency index, that is
	 * one particular colour which is dedicated as being transparent. Typically,
	 * in the images here at Altova, it is a gray colour with all RGB values set
	 * to the value of {@link ImageUtils#BG_IDX}.
	 * 
	 * When we talk about alpha channel, we are talking a bout a fourth color
	 * channel, in aditon to Red, Green, Blue.
	 * 
	 * @param icon
	 *            the image to convert
	 *            
	 * @see ImageRecognitionRobot#comparePixels
	 */
	public static void setBackgroundTransperency(BufferedImage icon) {
		int w = icon.getWidth();
		int h = icon.getHeight();

		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				int pixel = icon.getRGB(x, y);
				if (pixel == ICON_BACKGROUND_COLOR) {
					icon.setRGB(x, y, TRANSPARENT_COLOR);
				}

			}
		}

	}

	/**
	 * Separates a 32-bit colour value into its 8 bit components. 
	 * The array contains the colors in the following order:
	 * [0] = alpha<br/>
	 * [1] = red<br/>
	 * [2] = green<br/>
	 * [3] = blue<br/>
	 * 
	 * @param rgba a 32-bit RGBA value
	 * @return a four element array with these elements: { blue, green, red, alpha }
	 */
	public static int[] getChannels(int rgba) {
		int alpha = (rgba >>> 24) & 0xFF;
		int red = (rgba >>> 16) & 0xFF;
		int green = (rgba >>> 8) & 0xFF;
		int blue = rgba & 0xFF;

		return new int[] { blue, green, red, alpha };
	}
}
