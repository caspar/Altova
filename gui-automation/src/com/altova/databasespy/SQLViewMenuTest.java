package com.altova.databasespy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static java.awt.event.KeyEvent.VK_D;

import org.junit.After;
import org.junit.Test;

public class SQLViewMenuTest extends AbstractDatabaseSpyTest{

	
	@After
	public void setUpAfter() throws Exception {
		
		robot.closeAll();
		robot.escapeDialog("Save modified files", VK_D);
	}
	
	
	@Test
	public final void testWordWrap_off() {
		
		robot.openFile(ORGCHART_SQL_WRAP_FILE.getAbsolutePath());
		robot.wordWrap();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testWordWrap_on() {
		
		robot.openFile(ORGCHART_SQL_WRAP_FILE.getAbsolutePath());
		robot.wordWrap();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
		

	/*@Test
	public final void testToogleAllFolds_off() {
		
		robot.openFile(ORGCHART_SQL_DEMO_INSERT_FILE.getAbsolutePath());
		robot.toogleAllFolds();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}*/
	
	/*@Test
	public final void testToogleAllFolds_on() {
		
		robot.openFile(ORGCHART_SQL_DEMO_INSERT_FILE.getAbsolutePath());
		robot.toogleAllFolds();
		delay(500);
		robot.toogleAllFolds();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}*/
}
