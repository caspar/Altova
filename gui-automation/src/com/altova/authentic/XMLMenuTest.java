/**
 * 
 */
package com.altova.authentic;

import static com.altova.spy.SpyRobot.VALIDATION;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW; 

import org.junit.Test;

/**S
 * @author b.lopez
 *
 */
public class XMLMenuTest extends AbstractAuthenticTest {

	@Test
	public void testCheckWellFormedness(){
		robot.openFileWithoutKnownSPS(EXPREPORT_NOTWELLFORMED_FILE);
		robot.XMLCheckWellFormedness();
		assertAreas(VALIDATION);
	}
	
	@Test
	public void testCheckValidation_invalid(){
		robot.openFile(CONDITIONAL_NOTVALID_FILE);
		robot.validate();
		assertWindowAndEscape();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testCheckValidation_valid(){
		robot.openFile(CONDITIONAL_XML_FILE);
		robot.validate();
		assertWindowAndEscape();
	}
}
