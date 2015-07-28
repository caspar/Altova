package com.altova.nativegui;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Small test class for the NativeGUI interface. It mimics the Microsoft
 * Spy++ application, also implemented in WindowFinder by Lim Bio Liong:
 * http://www.codeproject.com/dialog/windowfinder.asp
 * 
 * The code used in this project, native interface or C++ implementation
 * uses no code or other resources from any of the projects mentioned above.
 * The only resemblance is the concept idea. All code was produce by 
 * author of this class.
 * 
 * 
 * @author Havard Rast Blok
 *
 */
public class TestSpy extends JPanel implements Runnable {

    static final long serialVersionUID = -2677994742644075610L;
	
	JTextArea text;
	
	Robot robot;
	
	public TestSpy() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace(); //this should never happen on a GUI display
		}
		
		text = new JTextArea();
		Dimension dim = new Dimension(400, 300);
		text.setPreferredSize(dim);
		add(text);
		Thread t = new Thread(this);
		t.start();
	}
	
	public void run() {
		while(true) {
			Point p = NativeGUI.getCursorPostion();
			ComponentInfo info = NativeGUI.getWindowInfo(p.x, p.y);
			ComponentInfo front = NativeGUI.getForegroundWindowInfo();
			
			String out;
			out  = p + "\n";
			out += "Color: "+ getPixelColor(p) + "\n";
			out += "Component under cursor: \n";
			out += "WindowText: "+info.getWindowText() + "\n";
			out += "ClassName: "+info.getClassName() + "\n";
			Rectangle l = info.getLocation();
			out += info.getLocation() + " - area="+ (l.height*l.width) +"\n";
			out += "bottom right: ["+(l.x+l.width)+", "+(l.y+l.height)+"]" + "\n";
			out += "\n";
			out += "Foreground Window:\n";
			out += "WindowText: "+front.getWindowText() + "\n";
			out += "ClassName: "+front.getClassName() + "\n";
			out += front.getLocation() + "\n";
			out += "\n";
			//out += "CursorId="+NativeGUI.getCursorId()+"\n";
			//out += "Diagram area: "+(new UModelRobot()).findDiagramArea();
						
			text.setText(out);
			
			
			try { Thread.sleep(100); }
			catch (Exception e) {}
		}
	}
	
	private Color getPixelColor(Point p) {
		Rectangle cursor = new Rectangle(p.x, p.y, 1, 1);
		BufferedImage screen = robot.createScreenCapture(cursor);
		int rgb = screen.getRGB(0, 0);
		return new Color(rgb, false);
	}
	
	public static void main(String args[]) {
		TestSpy ts = new TestSpy();
		JFrame frame = new JFrame();
		frame.add(ts);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(410, 400);
		frame.setVisible(true);
	}

}
