package com.altova.umodel;

import static com.altova.umodel.regression.gui.UModelRobot.MODEL_TREE;
import static com.altova.umodel.regression.gui.UModelRobot.STYLES;
import com.altova.umodel.regression.gui.UModelRobot;

public class TestScrollBar {

	UModelRobot robot;
	
	TestScrollBar() {
		robot = new UModelRobot();
		
		robot.scrollPane(MODEL_TREE, 1.0);
		robot.scrollPane(STYLES, 0.9);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestScrollBar();
	}

}
