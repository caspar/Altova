package com.altova.robots;

import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.VK_CONTROL;
import static java.awt.event.KeyEvent.VK_SHIFT;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_ALT;
import static java.lang.Math.signum;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.lang.reflect.Field;

import javax.swing.JFrame;

import com.altova.util.Settings;

/**
 * Convenience class wrapping the AWT Robot framework with any kind of mouse
 * robot behaviour in mind. It's adding left and right click methods for
 * specified positions, drag and drop gestures and simulating typing of strings
 * on the keyboard.
 * <p>
 * The class does not extend the java.awt.Robot class, but wraps its methods
 * instead, to avoid these to be public. The wrapper methods are intentionally
 * protected, so that their basic functionality is not use in test scripts.
 * Especially, it is not desirable to use the methods which take specific
 * coordinates directly. Instead new <i>find</i>-methods should be implemented
 * around the problem to be solved.
 * 
 * @author Havard Rast Blok
 * 
 * @see Robot
 */
public class GenericRobot{

	/**
	 * Multiplier used for all calls to the {@link GenericRobot#delay(int)}
	 * method. Default is 1.0. This parameter should be set by the available
	 * options in the {@link Settings} class.
	 */
	protected double delayMultiply = 1.0;  
	
	private int stopKey = KeyEvent.VK_CAPS_LOCK;

	private boolean lookKeyState;

	private Point previous = new Point();
	
	private Robot nativeRobot;

	/**
	 * Constructs a new GenericRobot instance, which wraps the functionality of
	 * the Java API {@link Robot}
	 */
	protected GenericRobot() {
		//create the AWT robot
		try {
			nativeRobot = new Robot();
		} catch (AWTException e) {
			throw new IllegalStateException("Could not create robot.", e);
		}
		
		delayMultiply = Settings.getDelayMultiply();
		
		//if the value of the env. variable is true,
		//show a JFrame which will catch the state of the
		//stop key (e.g. caps lock)
		//
		//Usage: java -Dframe=true   ....Test 
		String value = System.getProperty("frame");
		
		if (value != null && value.equalsIgnoreCase("true")) {
			// get the state of the stop key
			lookKeyState = Toolkit.getDefaultToolkit().getLockingKeyState(
					stopKey);
			JFrame frame = new JFrame();
			frame.setVisible(true);
			//tab back to previously active window, 
			//after creating the JFrame
			nativeRobot.keyPress(KeyEvent.VK_ALT);
			nativeRobot.keyPress(KeyEvent.VK_TAB);
			nativeRobot.keyRelease(KeyEvent.VK_TAB);
			nativeRobot.keyRelease(KeyEvent.VK_ALT);

			frame.addFocusListener(new MyFocuseListener());
		}
	}

	class MyFocuseListener extends FocusAdapter {

		@Override
		public void focusGained(FocusEvent e) {
			logger.finest("focus");
			//System.exit(0);
			checkStopKey();
		}

	}
	
	/**
	 * Sleeps for the specified time, multiplied by {@link #delayMultiply}, which defaults to 1.0.
	 * 
	 * @param ms time to sleep in milliseconds
	 */
	public void delay(int ms) {
		double tmp = ms;
		nativeRobot.delay( (int)(tmp * delayMultiply) );
	}
	
	/**
	 * Wrapper for the {@link Robot#waitForIdle()}.
	 */
	public void waitForIdle() {
		nativeRobot.waitForIdle();
	}
	
	/**
	 * Wrapper for the {@link Robot#setAutoDelay(int)}.
	 */
	private void setAutoDelay(int ms) {
		nativeRobot.setAutoDelay(ms);
	}
	
	/**
	 * Wrapper for the {@link Robot#getAutoDelay()}.
	 */
	protected int getAutoDelay() {
		return nativeRobot.getAutoDelay();
	}
	
	/**
	 * Wrapper for the {@link Robot#keyPress(int)}.
	 */
	public void keyPress(int keycode) {
		nativeRobot.keyPress(keycode);
	}
	
	/**
	 * Wrapper for the {@link Robot#keyRelease(int)}.
	 */
	protected void keyRelease(int keycode) {
		nativeRobot.keyRelease(keycode);
	}
	
	/**
	 * Wrapper for the {@link Robot#createScreenCapture(Rectangle)}.
	 */
	protected BufferedImage createScreenCapture(Rectangle screenRect) {
		return nativeRobot.createScreenCapture(screenRect);
	}

	protected void checkStopKey() {
		Toolkit.getDefaultToolkit().getLockingKeyState(stopKey);
		//compare the current state of the stop key to the initial
		//for some reason, this is not correct the first time it is
		//changed. The user will have to ALT+TAB between the JFrame and
		//some other window twice before this method gets the correct value
		boolean state = Toolkit.getDefaultToolkit().getLockingKeyState(stopKey);
		boolean stop = (state != lookKeyState);

		logger.finest("lookkey="+lookKeyState+", state="+state+", stop="+stop);

		if(stop) {
			logger.finest("Robot stopped by lock key: "+KeyEvent.getKeyText(stopKey));
			System.exit(0);
		}
	}

	/**
	 * Click the left mouse button at the current mouse position.
	 *
	 */
	public void leftClick() {
		//logger.finer.println("left_click");
		nativeRobot.mousePress(InputEvent.BUTTON1_MASK);
		nativeRobot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

	/**
	 * Click the right mouse button at the current mouse position.
	 *
	 */
	public void rightClick() {
		nativeRobot.mousePress(InputEvent.BUTTON3_MASK);
		nativeRobot.mouseRelease(InputEvent.BUTTON3_MASK);
	}
	
	/**
	 * Press and hold the left mouse button for the specified number of milli seconds
	 * @param ms milli seconds between the press and release action
	 */
	public void leftHold(int ms) {
		nativeRobot.mousePress(InputEvent.BUTTON1_MASK);
		delay(ms);
		nativeRobot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

	/**
	 * Move the mouse cursor to the specified position.
	 */
	public void mouseMove(int x, int y) {
		nativeRobot.mouseMove(x, y);
		this.previous.setLocation(x, y);
	}
	
	/**
	 * Click the left mouse button at the specified mouse position.
	 *
	 */
	public void leftClick(int x, int y) {
		mouseMove(x, y);
		leftClick();
	}
	
	/**
	 * Click the left mouse button at the specified mouse position.
	 *
	 */
	protected void rightClick(int x, int y) {
		mouseMove(x, y);
		rightClick();
	}

	/**
	 * Click the left mouse button in the middle of the specified Rectangle.
	 *
	 */
	public void leftClickMid(Rectangle rect) {
		if(rect == null) {
			logger.severe("leftClickMid - rect was null");
			ScriptMistakeException e = new ScriptMistakeException("leftClickMid - rect was null");
			e.printStackTrace();
			return;
		}

		moveMid(rect);
		leftClick();
	}
	
	public void doubleClickMid(Rectangle rect) {
		leftClickMid(rect);
		leftClick();
	}

	/**
	 * Click the left mouse button in the middle of the specified Rectangle.
	 *
	 */
	public void leftClickMidVar(Rectangle rect, int pixelRight) {
		if(rect == null) {
			logger.severe("leftClickMid - rect was null");
			ScriptMistakeException e = new ScriptMistakeException("leftClickMid - rect was null");
			e.printStackTrace();
			return;
		}
		Rectangle rec_tmp = rect;
		rec_tmp.x = rect.x + pixelRight;
		moveMid(rec_tmp);
		leftClick();
	}
	
	/**
	 * Click the right mouse button in the middle of the specified Rectangle.
	 *
	 */
	public void rightClickMidVar(Rectangle rect, int pixelRight) {
		if(rect == null) {
			logger.severe("leftClickMid - rect was null");
			ScriptMistakeException e = new ScriptMistakeException("leftClickMid - rect was null");
			e.printStackTrace();
			return;
		}
		Rectangle rec_tmp = rect;
		rec_tmp.x = rect.x + pixelRight;
		moveMid(rec_tmp);
		rightClick();
	}

	/**
	 * Click the right mouse button in the middle of the specified Rectangle.
	 *
	 */
	public void rightClickMid(Rectangle rect) {
		if(rect == null) {
			return;
		}

		moveMid(rect);
		rightClick();
	}

	/**
	 * Move the mouse cursor to the middle of the specified Rectangle.
	 * 
	 * @param rect rectangle with screen coordinates
	 */
	protected void moveMid(Rectangle rect) {
		Point p = ImageUtils.findMid(rect);
		mouseMove(p.x, p.y);
	}
	
	/**
	 * Returns the point in the middle of the specified rectangle.
	 * 
	 * @param rect rectangle with screen coordinates
	 * @return the coordinate in the middle of the rectangle 
	 */
	protected Point findMid(Rectangle rect) {
		return ImageUtils.findMid(rect);
	}

	/**
	 * Click the left mouse button at the specified mouse position.
	 *
	 */
	protected void leftClick(Point p) {
		leftClick(p.x, p.y);
	}
	
	/**
	 * Click the left mouse button at the specified mouse position.
	 *
	 */
	protected void rightClick(Point p) {
		rightClick(p.x, p.y);
	}

	/**
	 * This was an early attempt at making a "gliding" cursor (instead of
	 * jumping as it does with the click methods). However, currently it's not
	 * working, an is probably not required anymore...
	 * 
	 * @param p
	 */
	private void glide(Point p) {
		int sx = (int)signum(p.x - previous.x);
		int sy = (int)signum(p.y - previous.y);
		
		int x = previous.x;
		int y = previous.y;
		
		//logger.finer.println("prev: "+previous+", p: "+p);
		
		while(x != p.x || y != p.y) {
			x = (x!=p.x)?x+sx:x;
			y = (y!=p.y)?y+sy:y;
			
			//logger.finer.println("x="+x+", y="+y);
			mouseMove(x, y);
			delay(1);
			waitForIdle();
		}
		
	}
	
	/**
	 * Drag and drop using the left mouse button between the two specified points.
	 * @param p1 start point to drag from.
	 * @param p2 end point to drop at.
	 */
	protected void dragDrop(Point p1, Point p2 ) {
		dragDrop(p1.x, p1.y, p2.x, p2.y);
	}
	
	public void dragDropMid(Rectangle r1, Rectangle r2) {
		dragDrop(findMid(r1), findMid(r2));
	}

	/**
	 * Drag and drop using the left mouse button between the two specified points.
	 * There is a small issue with the timing of D&D, it seems. Thus some extra
	 * delay between each step is added.
	 *
	 * @param x1 start point to drag from.
	 * @param y1 start point to drag from.
	 * @param x2 end point to drop at.
	 * @param y2 end point to drop at.
	 */
	protected void dragDrop(int x1, int y1, int x2, int y2 ) {
		//Note that all the delays and waits seems to be
		//necessary to get the drag&drop working for UModel
		//If this is causing problems, further tweaking with
		//this method might be necessary.
		
		int delay = getAutoDelay();
		setAutoDelay(600);

		delay(650);
		waitForIdle();
		mouseMove(x1, y1);
		waitForIdle();
		nativeRobot.mousePress(InputEvent.BUTTON1_MASK);
		waitForIdle();
		mouseMove(x2, y2);
		waitForIdle();
		nativeRobot.mouseRelease(InputEvent.BUTTON1_MASK);

		setAutoDelay(delay);
	}

	/**
	 * Press and release the key with the given keycode (from KeyEvent)
	 * @param keycode
	 */
	public void keyType(int keycode) {
		keyPress(keycode);
		keyRelease(keycode);
	}
	
	/**
	 * Press and release CTRL + the key with the given keycode (from KeyEvent).
	 * The sequence of keys will thus be:
	 * <p>
	 * Press CTRL</br>
	 * Press <i>key</i></br>
	 * Release <i>key</i></br>
	 * Release CTRL</br>
	 * 
	 * @param keycode
	 *            CTRL + key to press
	 */
	public void keyTypeCtrl(int keycode) {
		keyPress(VK_CONTROL);
		keyType(keycode);
		keyRelease(VK_CONTROL);
	}

	public void keyTypeShift(int keycode) {
		keyPress(VK_SHIFT);
		keyType(keycode);
		keyRelease(VK_SHIFT);
	}
	
	public void keyTypeAlt(int keycode) {
		keyPress(VK_ALT);
		keyType(keycode);
		keyRelease(VK_ALT);
	}
	
	/**
	 * Type the specified keyboard character. For special characters, like
	 * slash, plus, minus, underscore, etc., use the typeString() method
	 * in stead.
	 * 
	 * @param key character to type, e.g. 'c'
	 * @throws NoSuchFieldException
	 */
	public void keyType(char key) throws NoSuchFieldException {
		keyType(key, false);
	}

	/**
	 * Type the specified keyboard character. For special characters, like
	 * slash, plus, minus, underscore, etc., use the typeString() method
	 * in stead.
	 * 
	 * This method should only be used to enforce typing of numbers using
	 * the numpad. Otherwise, the keyType(char) method should be used.
	 * 
	 * @param key character to type, e.g. '1'
	 * @param useNumpad if true, is the NumPad to type given numbers
	 * @throws NoSuchFieldException
	 */
	private void keyType(char key, boolean useNumpad) throws NoSuchFieldException {
		String numpad = "";
		if(useNumpad) {
			numpad = "NUMPAD";
		}

		Class klass = KeyEvent.class;
		Field field = klass.getField("VK_"+numpad+Character.toUpperCase(key));
		//logger.finer(""+field.getName()+": " );
		
		//check if we should type in upper case
		boolean upper = Character.isUpperCase(key);

		try {
			Object value = field.get(null);

			//we're expecting an Integer here. Verify this.
			if(value instanceof Integer) {

				if(upper) { 
					keyPress(KeyEvent.VK_SHIFT);
				}
				
				keyType((Integer)value);
				
				if(upper) { 
					keyRelease(KeyEvent.VK_SHIFT);
				}
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Type the specified string, using the Java Virtual Keyboard event
	 * codes in the java.awt.KeyEvent class. For some special character
	 * keys, the Windows specific ALT+xxx (where xxx are numbers typed
	 * in on the NumPad) is used.
	 * 
	 * Currently, this method does not pay attention to case, so whatever
	 * mode the keyboard is in when this method is called, will be used.
	 * 
	 * @param str sting to type out
	 */
	public void typeString(String str) {
		if(str == null) {
			throw new NullPointerException("String to type cannot be null.");
		}

		for(char c : str.toCharArray()) {
			try {
				switch(c) {
				case(' '): altKey(32); break;
				case('!'):altKey(33);break;
				case('"'):altKey(34);break;
				case('#'): altKey(35); break;
				
				case('$'): altKey(36); break;
				case('&'):altKey(38);break;
				case('\''): altKey(39); break;

				case('('): altKey(40); break;
				case(')'): altKey(41); break;
				case('*'): altKey(42); break;
				case('+'): altKey(43); break;
				case(','): altKey(44); break;
				case('-'): altKey(45); break;
				case('.'): altKey(46); break;
				case('/'): altKey(47); break;

				case(':'): altKey(58); break;
				
				case('<'):altKey(60);break;
				case('='): altKey(61); break;
				case('>'):altKey(62);break;
				case('?'):altKey(63);break;
				case('@'): altKey(64); break;
				
				case('['): altKey(91); break;
				case('\\'): altKey(92); break;
				case(']'): altKey(93); break;
				case('_'): altKey(95); break;
				case('|'):altKey(124);break;
				case(';'):altKey(59);break;
				
				case('é'):altKey(130);break;
				case('á'):altKey(160);break;
				case('í'):altKey(161);break;
				case('ó'):altKey(162);break;
				case('ú'):altKey(163);break;
				case('ñ'):altKey(164);break;
				
				case('ä'):altKey(132);break;
				case('ö'):altKey(148);break;
				case('ü'):altKey(129);break;
				case('ß'):altKey(225);break;
				case('Ä'):altKey(142);break;
				case('Ö'):altKey(153);break;
				case('Ü'):altKey(154);break;
				
				case('à'):altKey(133);break;
				case('ç'):altKey(135);break;
				case('ù'):altKey(151);break;
				case('è'):altKey(138);break;
				
				case('{'):altKey(123);break;
				case('}'):altKey(125);break;
				
				case('%'):altKey(37);break;
				
				default: keyType(c);
				}
			} catch (NoSuchFieldException e) {
				String msg = "The character '"+c+"' is most likely a special character, "+
				"and has to be defined explicitly in the method GenericRobot.typeString(String).";
				logger.severe(msg);
				throw new ScriptMistakeException(msg);
			}
			delay(50);
			waitForIdle();
		}
	}
	
	/**
	 * Types the specified String and presses ENTER. 
	 * 
	 * @param str the String to type (without any ENTER/newline character)
	 */
	public void typeStringEnter(String str) {
		typeString(str);
		delay(2000);
		keyType(VK_ENTER);
	}
	
	/**
	 * Types the specified String if it is not null, and presses ENTER regardless.  
	 * 
	 * @param str the String to type (without any ENTER/newline character)
	 */
	public void typeStringConditional(String str) {
		if(str != null) {
			typeString(str);
		}
		keyType(VK_ENTER);
	}


	/**
	 * Type the specified ASCII character using the Windows specific
	 * ALT+xxx (where xxx are numbers typed in on the NumPad).
	 * 
	 * @param asciiCode
	 * @throws NoSuchFieldException
	 */
	private void altKey(int asciiCode) throws NoSuchFieldException {
		keyPress(KeyEvent.VK_ALT);
		for(char c: (""+asciiCode).toCharArray()) {
			keyType(c, true);
		}
		keyRelease(KeyEvent.VK_ALT);
	}

	/**
	 * Returns the number each call to {@link #delay(int)} is multiplied with.
	 * @return the delay multiplier.
	 */
	public double getDelayMultiply() {
		return delayMultiply;
	}

	/**
	 * Sets the number each call to {@link #delay(int)} is multiplied with.
	 * @param delayMultiply the delay multiplier.
	 */
	public void setDelayMultiply(double delayMultiply) {
		this.delayMultiply = delayMultiply;
	}
}
