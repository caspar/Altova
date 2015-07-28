package com.altova.nativegui;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.altova.robots.ImageRecognitionRobot;
import com.altova.robots.ImageUtils;


/**
 * Small test class for the NativeGUI interface. It will produce an
 * image showing which Windows components was found on screen.
 * 
 * @author Havard Rast Blok
 *
 */
public class ComponentObserver {

	ImageRecognitionRobot robot;
	
	
	public ComponentObserver() {
		robot = new ImageRecognitionRobot();
		
		start();
	}
	
	
	protected void start() {
		Map<Rectangle, String> map = locateComponets();
		
		for(Rectangle r : map.keySet()) {
			String id = map.get(r);
			System.out.println(""+id+": "+r);
		}
		
		draw(map);
		
	}
	
	private void draw(Map<Rectangle, String> map) {
		//TODO: find dim from map instead
		Rectangle dim = ImageUtils.getDefaultScreenDimension();
		BufferedImage img = new BufferedImage(dim.width, dim.height-4, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g = (Graphics2D) img.getGraphics();
		
		for(Rectangle r : map.keySet()) {
			g.draw(r);
		}
		
		try {
			ImageUtils.saveImage(img, new File("compobv.jpg"), "jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected Map<Rectangle, String> locateComponets() {
		Map<Rectangle, String> map = new HashMap<Rectangle, String>();
		List<ComponentInfo> cmps = NativeGUI.getAllComponents();
		for(ComponentInfo info : cmps) {
			map.put(info.getLocation(), info.getClassName() + " - " + info.getWindowText());
		}
		
		return map;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ComponentObserver();

	}

}
