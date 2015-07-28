package com.altova.robots;

import static com.altova.umodel.regression.gui.UModelRobot.STYLES;
import java.awt.Rectangle;
import java.io.File;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.umodel.regression.gui.UModelRobot;
import com.altova.util.Settings;
import com.altova.util.Settings.AltovaApplication;

public class TestPaneRowSplitter extends AltovaApplicationRobot {
private static final String BASEPATH = "umodel/";
	
	private final static String[] toolbarIds = { "IDR_MAINFRAME",
			"IDR_TLB_ADD_ELEMENTS", "IDR_TLB_LAYOUT", "IDR_TLB_ZOOM", "IDR_TLB_ADD_XSD_ELEMENTS" };
	static UModelRobot robot;
	
	public TestPaneRowSplitter() {
		super("Altova UModel", AltovaApplication.UMODEL,"UModel", BASEPATH+"UModel.rc", toolbarIds);
		 
	}
	
	@BeforeClass
	public static void oneTimeSetUp() {
		robot = new UModelRobot();
		robot.activateApplication();
		robot.maximizeWindow();
	}

	@Test
	public void testFindPaneRowSplitter() {
		Rectangle r = activatePane(STYLES);
		Rectangle splitter = findPaneRowSplitter(r);
		robot.mouseMove(splitter.x, splitter.y);
		Assert.assertNotNull(splitter);
	}
	
	@Test
	public void testScrollPaneRowSpitter() {
		robot.scrollPaneRowSplitter(STYLES, 0.2);
		robot.delay(1000);
		robot.scrollPaneRowSplitter(STYLES, 0.7);
	}
	

	@Override
	public void exitApplication() {
		// TODO Auto-generated method stub
		
	}

}
