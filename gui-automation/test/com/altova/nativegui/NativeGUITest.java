package com.altova.nativegui;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

/**
 * This is an internal test class for the {@link NativeGUI} class. It is not
 * related to the JUnit tests of UModel, XMLSpy or other applications. It is
 * only testing the native calls.
 * 
 * @author hab
 * 
 */
public class NativeGUITest {

	@Test
	public void testGetCursorPostion() {

	}

	@Test
	public void testSwitchToWindow() {

	}

	@Test
	public void testGetApplicationList() {
		// calling getApplicationList right after each other, should get the
		// same number of open applications
		List<ComponentInfo> first = NativeGUI.getApplicationList();
		List<ComponentInfo> second = NativeGUI.getApplicationList();
		assertSame(first.size(), second.size());
	}

	@Test
	public void testGetForegroundWindowInfo() {

	}

	@Test
	public void testGetWindowInfo() {

	}

	@Test
	public void testGetAllComponents() {

	}

}
