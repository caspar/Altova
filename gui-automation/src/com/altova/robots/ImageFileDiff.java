package com.altova.robots;

import static com.altova.util.LoggerUtils.logger;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;

import com.altova.util.Settings;

/**
 * 
 * @author Havard Rast Blok
 *
 */
public class ImageFileDiff extends BitmapDiff {

	protected String file1;
	
	protected String file2;
	
	protected BufferedImage buf1;
	protected BufferedImage buf2;
	
	protected BufferedImage previousResult;
	
	public static int pixelDifferenceThreshold = 0;
	
	private File diffImg;
	
	public ImageFileDiff( String file1, String file2 ) {
		this.file1 = file1;
		this.file2 = file2;
	}
	
	public ImageFileDiff(File file1, File file2) {
		this( file1.getAbsolutePath(), file2.getAbsolutePath() );
	}

	public BufferedImage diffMarks() {
		previousResult = super.diffMarks(file1Image(), file2Image());
		
		if(pixelDifferenceThreshold > 0) {
			previousResult = checkThreshold(previousResult);
		}
		
		return previousResult;
	}
	
	public BufferedImage file1Image() {
		if(buf1 == null) {
			buf1 = ImageUtils.readIcon(file1);
		}
		
		return buf1;
	}
	
	public BufferedImage file2Image() {
		if(buf2 == null) {
			buf2 = ImageUtils.readIcon(file2);
		}
		
		return buf2;		
	}
	
	public Dimension file1Dimension() {
		return getDimension(file1Image());
	}
	
	public Dimension file2Dimension() {
		return getDimension(file2Image());
	}
	
	protected Dimension getDimension(BufferedImage img) {
		return new Dimension(img.getWidth(), img.getHeight());
	}

	public boolean sameSize() {

		return 	file1Image().getWidth() == file2Image().getWidth() && 
				file1Image().getHeight() == file2Image().getHeight();
	}
	
	private BufferedImage checkThreshold(BufferedImage img) {
		//first, count the number of different pixels
		int width = img.getWidth();
		int height = img.getHeight();
		
		int count = 0;
		for (int y = 0; y < height && count < pixelDifferenceThreshold; y++) {
			for (int x = 0; x < width; x++) {
				int c = img.getRGB(x,y);
				if(c != -1) {
					count++;
				}
			}
		}
		
		if(count >= pixelDifferenceThreshold) {
			return img;
		}
		logger.info(count+" pixels were different, but below threshold of "+pixelDifferenceThreshold);

		//if the picture is ok, just return a 1x1 white image (which would pass as equal)
		//TODO: could mark out the ignored pixels here instead..
		BufferedImage ans = new BufferedImage(1, 1, img.getType());
		ans.setRGB(0, 0, ImageRecognitionRobot.WHITE);
		return ans;
	}

	public boolean diff() {
		logger.finer("Diffing: "+this);
		
		boolean diff = diffBounds() != null;
		
		if(diff) {
			File name = new File(file2);
			String diffName = name.getName().replaceFirst("\\..*", "") + "_diff"; 
			diffImg = writeDebugDiff(previousResult, diffName, false);
			
		}
		
		return diff;
	}
	
	public static ImageFileDiff expectedDiffFactory( File current ) {
		String path = current.getAbsolutePath();
		String out = Settings.getOutputDir().getAbsolutePath();
		int idx = path.indexOf(out);
		String base = path.substring(idx+out.length());
		File expected = new File( Settings.getExpectedDir(), base );
		
		return new ImageFileDiff( current, expected );
	}
	
	public String toString() {
		return "'"+file1+"' -- '"+file2+"'";
	}
	
	private String getImageLink(String file, String description) {
		if(file == null) {
			return "No "+description+" image.</br>\n";
		}
		
		return "<a href=\"file://"+file+"\">"+description+" image</a></br>\n";
	}

	
	public String toStringLinks() {
		String ans = getImageLink(file1, "file1")+getImageLink(file2, "file2");
		ans += (diffImg!=null)?getImageLink(diffImg.getAbsolutePath(), "pixel difference"):"";
		return ans;
	}
	
	public static void main(String args[]) {
//		String fileout="S:\\QA\\Internal\\hrb\\temp\\win2003\\out\\spy\\BrowserMenuTest\\testBrowserBack_diagram.png";
//		String fileexpected="S:\\QA\\Internal\\hrb\\temp\\win2003\\expected\\spy\\BrowserMenuTest\\testBrowserBack_diagram.png";
		if(args.length != 2) {
			System.out.println("Usage: java ImageFileDiff <file1> <file2>");
			System.exit(1);
		}
		
		//make sure we get a diff image
		System.setProperty("debugImageDiff", "true");
		ImageFileDiff diff = new ImageFileDiff(args[0], args[1]);
		boolean difference = diff.diff();
		if(difference) {
			System.out.println("The two pictures are different.");
			System.out.println("Pixel difference picture saved at: "+diff.diffImg);
			System.exit(1);
		} else {
			System.out.println("The two pictures are equal.");
			System.exit(0);
		}
	}
}
