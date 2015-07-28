package com.altova.robots;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Date;

/**
 * A utility class for finding differences in screen capture images.
 * It has to be instantiated with a Robot object, and the methods must be used
 * in the following order: snapBefore(), snapAfter(), and diffMarks() or diffBounds().
 * 
 * @author Havard Rast Blok
 *
 */
public class ScreenDiff extends BitmapDiff {
	
	protected BufferedImage before;
	
	protected BufferedImage after;
	
	protected Rectangle rect;
	
	protected GenericRobot robot;
	
	protected long beforeTime;
	
	/**
	 * Minimum amount of time in milliseconds to wait between the
	 * before and after snapshots. 
	 */
	public static long snapshotDelay = 500; 
	
	public ScreenDiff(GenericRobot robot) {
		this.robot = robot;
	}
	
	/**
	 * Grabs the specified section of the screen and stores in this ScreenDiff object
	 * for later use. Calling this method will remove any previous images stored
	 * in both the before and after image buffers.
	 * 
	 * @param r the section of the screen to grab
	 * @throws IllegalArgumentException if r is null
	 */
	public void snapBefore(Rectangle r) { 
		if(r == null) {
			throw new IllegalArgumentException("Rectangle r cannot be null.");
		}
		
		before = robot.createScreenCapture(r);
		after = null;
		this.rect = r;
		this.beforeTime = (new Date()).getTime();
	}

	public void snapBefore() {
		snapBefore( ImageUtils.getDefaultScreenDimension() );
	}
	
	/**
	 * Grabs the specified section of the screen and stores in this ScreenDiff object
	 * for later use. The snapBefore() method must be called prior this this.
	 * 
	 * @param r the section of the screen to grab
	 * @throws IllegalArgumentException if r is null
	 * @throws IllegalStateException if the before buffer is null
	 */
	public void snapAfter(Rectangle r) {
		if(r == null) {
			throw new IllegalArgumentException("Rectangle r cannot be null.");
		}
		
		if(before == null) {
			throw new IllegalStateException("before is null. Must call snapBefore() first.");
		}
		
		//make sure we there is some delay between the snapshots
		long delay = (new Date()).getTime() - this.beforeTime;
		if(delay < snapshotDelay) {
			robot.delay((int) (snapshotDelay - delay));
		}
		
		after = robot.createScreenCapture(r);
	}
	
	/**
	 * Grabs the section of the screen specified in the previous call to snapBefore() 
	 * and stores in this ScreenDiff object for later use. 
	 * The snapBefore() method must be called prior to this.
	 * 
	 * @throws IllegalStateException if the before buffer is null or snapBefore() as never called
	 */
	public void snapAfter() {
		if(rect == null) {
			throw new IllegalStateException("rect is null. snapAfter() must called after snapBefore()");
		}
			
		snapAfter(rect);
	}
	
	/**
	 * Compare the before and after images stored in this ScreenDiff and creates
	 * a new image highlighting the differences.
	 * 
	 * @return an image with red pixels where the two images differ, on a white background.
	 * @throws IllegalStateException if the before or after image is null
	 */
	public BufferedImage diffMarks() {
		if(before == null || after == null) {
			throw new IllegalStateException("Both method snapBefore() and snapAfter() must be called before diffMarks().");
		}
		
		return super.diffMarks(before, after);
	}
	
	public Rectangle diffBounds() {
		Rectangle ans = super.diffBounds(); 
		
		if(ans != null) {
			ans.translate(rect.x, rect.y);
		}
		
		return ans;
	}
	
	public Rectangle diffBoundsSelection(){
       Rectangle ans = super.diffBoundsSelection(); 
		
		if(ans != null) {
			ans.translate(rect.x, rect.y);
		}
		
		return ans;
			
	}
	
}
