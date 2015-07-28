package com.altova.umodel;

import static java.awt.event.KeyEvent.*;

import java.awt.Rectangle;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.umodel.regression.gui.EclipseUModelRobot;
import com.altova.umodel.regression.testcases.AbstractUmodelTest;
import com.altova.util.AltovaJUnitRunner.TestRobot;

@TestRobot(EclipseUModelRobot.class)
public class PluginStressTest extends AbstractUmodelTest {

	public void setUp() throws Exception {
		// do nothing
	}

	public void tearDown() throws Exception {
		// do nothing
	}

	@Test
	@Ignore
	public void testChangeMethodNames() {
		Rectangle m1 = robot.findSourceCode("tearDo");
		Rectangle m2 = robot.findSourceCode("setUp");
		robot.doubleClickMid(m1);
		robot.typeString("asdf");

		robot.doubleClickMid(m2);
		robot.typeString("asdf");

		robot.undoKey();
		robot.undoKey();
		
		robot.delay(2000);
		robot.undoKey();
		robot.undoKey();
	}
	
	@Test
	public void testMoveMethod() {
		Rectangle start1 = robot.findSourceCodeLineNumber(16);
		Rectangle end1 = robot.findSourceCodeLineNumber(19);
		Rectangle paste = robot.findSourceCodeLineNumber(21);
		
		robot.dragDropMid(start1, end1);
		robot.keyTypeCtrl(VK_X);
		
		robot.leftClickMid(paste);
		robot.keyTypeCtrl(VK_V);
		
		robot.delay(2000);
		robot.undoKey();
		robot.undoKey();

	}


}
