package com.altova.robots;

import static com.altova.util.LoggerUtils.logger;
import static java.lang.Math.max;
import static java.lang.Math.min;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.altova.util.IOUtils;
import com.altova.util.Settings;

/**
 * Abstract class for general methods to compare a bitmap image, either as a
 * {@link BufferedImage} directly from screen, or loaded from file.
 * 
 * @author Havard Rast Blok
 * 
 * @see ImageFileDiff
 * @see ScreenDiff
 */
public abstract class BitmapDiff {

	/**
	 * Compare the before and after images stored in this ScreenDiff and creates
	 * a new image highlighting the differences.
	 * 
	 * @return an image with red pixels where the two images differ, on a white
	 *         background.
	 * @throws IllegalStateException
	 *             if the before or after image is null
	 */
	protected BufferedImage diffMarks(BufferedImage before, BufferedImage after) {
		if (before == null || after == null) {
			throw new IllegalStateException(
					"Neither arguments (before, after) can be null.");
		}

		// int width = max(before.getWidth(), after.getWidth());
		// int height = max(before.getHeight(), after.getHeight());
		int width = min(before.getWidth(), after.getWidth());
		int height = min(before.getHeight(), after.getHeight());
		BufferedImage diffImg = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int b = before.getRGB(x, y);
				int a = after.getRGB(x, y);

				if (b != a) {
					diffImg.setRGB(x, y, ImageRecognitionRobot.RED);
				} else {
					diffImg.setRGB(x, y, ImageRecognitionRobot.WHITE);
				}
			}
		}

		return diffImg;
	}

	public abstract BufferedImage diffMarks();

	protected File writeDebugDiff(BufferedImage img, String diffName,
			boolean debug) {
		if (Settings.debugImageDiff()) {
			try {
				return ImageUtils.saveImage(img, diffName, debug);
			} catch (IOException e) {
				logger.severe("Could not write diff image: " + e);
			}
		}
		
		return null;
	}

	/**
	 * Returns a Rectangle marking the outer bounds of the differences between
	 * the two images. The bounds are absolute in the captured images, and not
	 * the screen.
	 * 
	 * @return bounds of differences between the before and after image buffers
	 */
	public Rectangle diffBounds() {
		BufferedImage diff = diffMarks();

		int width = diff.getWidth();
		int height = diff.getHeight();

		int minX = width;
		int maxX = 0;
		int minY = height;
		int maxY = 0;

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int c = diff.getRGB(x, y);
				if (c != -1) {
					minX = min(minX, x);
					maxX = max(maxX, x);
					minY = min(minY, y);
					maxY = max(maxY, y);
				}
			}
		}

		Rectangle bounds = new Rectangle(minX, minY, maxX - minX, maxY - minY);

		if (bounds.height < 0 && bounds.width < 0) {
			logger.fine("No differences found");
			return null;
		}

		String id = IOUtils.getFileId();
		writeDebugDiff(diff, "robotdebug_diff_" + id, true);

		return bounds;
	}

	public Rectangle diffBoundsSelection() {
		BufferedImage difference = diffMarks();
		int width = difference.getWidth();
		int height = difference.getHeight();

		/*
		 * Comment: if the arrays pixcoordX and pixcoordY were objects from the
		 * Integer class, '=='would not be able to be used for element
		 * comparison
		 */

		int pixcoordX[] = new int[(width * height) / 3];
		int pixcoordY[] = new int[(height * width) / 3];
		int i = 0;
		int j = 0;
		int miniX = width;
		int maxiX = 0;
		int miniY = height;
		int maxiY = 0;

		/*
		 * All x coordinates in which the red pixels are present are stored
		 * pixcoordX. Considering, W=white pixel and R=red pixel and taking into
		 * account my data is {WWWWWW;WWRWWW;WRWWWW;RRRRWW;RRRRWW;WWWWWW} my
		 * pixcoordX will look like this: {1,2,3,3,3,3,4,4,4,4}
		 */

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int c = difference.getRGB(x, y);
				if (c != -1) {
					pixcoordX[i] = x;
					i++;

				}

			}
		}

		/*
		 * All y coordinates in which the red pixels are present are stored
		 * pixcoordY. Considering, W=white pixel and R=red pixel and taking into
		 * account my data is {WWWWWW;WWRWWW;WRWWWW;RRRRWW;RRRRWW;WWWWWW} my
		 * pixcoordY will look like this: {0,0,1,1,1,2,2,2,3,3}
		 */

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int d = difference.getRGB(x, y);
				if (d != -1) {
					pixcoordY[j] = y;
					j++;
				}

			}
		}

		/*
		 * The intervals should be changed depending on the amount of pixels
		 * which I can personally consider a selection
		 */

		int intervalX = 15; // i/8000;
		int intervalY = 20; // j/7800;

		/*
		 * Checking of equality between my first and last element will "filter"
		 * the pixels contained in the selection and ignore the noise
		 */

		for (int s = 0; s < (i - intervalX - 1); s++) {
			if ((s + intervalX) > i) {
				if (pixcoordX[s] == pixcoordX[i]) {

					miniX = min(miniX, pixcoordX[s]);
					maxiX = max(maxiX, pixcoordX[i]);
				}
			} else if (pixcoordX[s] == pixcoordX[s + intervalX]) {
				miniX = min(miniX, pixcoordX[s]);
				maxiX = max(maxiX, pixcoordX[s + intervalX]);
			}
		}

		for (int r = 0; r < (j - intervalY - 1); r++) {
			if ((r + intervalY) > j) {
				if (pixcoordY[r] == pixcoordY[j]) {
					miniY = min(miniY, pixcoordY[r]);
					maxiY = max(maxiY, pixcoordY[j]);
				}
			} else if (pixcoordY[r] == pixcoordY[r + intervalY]) {
				miniY = min(miniY, pixcoordY[r]);
				maxiY = max(maxiY, pixcoordY[r + intervalY]);

			}
		}
		Rectangle bounds = new Rectangle(miniX, miniY, maxiX - miniX, maxiY
				- miniY);

		if (bounds.height < 0 && bounds.width < 0) {
			logger.fine("No differences found");
			return null;
		}

		return bounds;

	}
}