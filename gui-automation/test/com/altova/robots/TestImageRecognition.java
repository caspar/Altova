package com.altova.robots;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class TestImageRecognition extends ImageRecognitionRobot {

	public TestImageRecognition() {
		
	}
	
	void testColors1() {
		BufferedImage img = ImageUtils.readIcon("img_01.bmp");
		BufferedImage icon = ImageUtils.readIcon("img_icon_01.bmp");
		
		BufferedImage icon2 = createImage("Diag. Show Grid", WINDOWS_DEFAULT_FONT, Color.WHITE, Color.BLACK);
		int imgT = img.getTransparency();
		int iconT = icon.getTransparency();
		int icon2T = icon2.getTransparency();
		System.out.println("imgT="+imgT+", iconT="+iconT+", icon2T="+icon2T);
		
		System.out.println("Expected: java.awt.Rectangle[x=10,y=597,width=79,height=8]");
		
		Rectangle res1 = find(icon2, img);
		System.out.println("Result  : "+res1);
	
//		compareState = PixelCompare.FULL_COLOR;
//		Rectangle res2 = find(icon, img);
//		System.out.println("Result  : "+res2);

	}
	
	void testColors2() {
		BufferedImage img = ImageUtils.readIcon("img_02.bmp");
		BufferedImage icon = ImageUtils.readIcon("img_icon_02.bmp");
		
		//System.out.println("Expected: java.awt.Rectangle[x=10,y=597,width=79,height=8]");
		
		Rectangle res1 = find(icon, img);
		System.out.println("Result  : "+res1);
		
		compareState = PixelCompare.FULL_COLOR;
		Rectangle res2 = find(icon, img);
		System.out.println("Result  : "+res2);
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestImageRecognition test = new TestImageRecognition();
		test.testColors1();
		//test.testColors2();
	}

}
