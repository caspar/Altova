/**
 * 
 */
package com.altova.authentic;


import org.junit.Test;

/**
 * @author B.Lopez
 *
 */
public class ToolsMenuTest extends AbstractAuthenticTest {

	@Test
	public void testSpelling() {
		robot.spelling();
		assertWindowAndEscape();
	}

	@Test
	public void testSpellingOptions() {
		robot.spellingOptions();
		assertWindowAndEscape();
	}
	
	@Test
	public void testCustomize(){
		robot.customize();
		assertWindowAndEscape();
	}
}
