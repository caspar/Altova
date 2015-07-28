package com.altova.databasespy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.databasespy.DatabaseSpyRobot.*;
import static java.awt.event.KeyEvent.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SQLEditorMenuTest extends AbstractDatabaseSpyTest{

	@Before
	public void setUpBefore() throws Exception {
		
		robot.openFile(ORGCHART_PQRJ_SAVED_FILE_TMP.getAbsolutePath());
		
	}
	
	@After
	public void setUpAfter() throws Exception {
		
		robot.closeAll();
		robot.escapeDialog("Save modified files", VK_D);
	}
	
	
	
	
	@Test
	public final void testExecute() {
		
		robot.execute();
		
		assertAreas(RESULT);
	}
	
	
	@Test
	public final void testExecuteForDataEditing() {

		robot.executeForDataEditing();
		
		assertAreas(RESULT);

	}
	
	@Test
	public final void testNextStatement() {
		
		robot.openFile(ORGCHART_SQL_DEMO_INSERT_FILE.getAbsolutePath());
		
		robot.navigationFirstStatement();
		robot.navigationNextStatement();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testPreviousStatement() {
		
		robot.openFile(ORGCHART_SQL_DEMO_INSERT_FILE.getAbsolutePath());
		
		robot.navigationLastStatement();
		robot.navigationPreviousStatement();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testLastStatement() {
		
		robot.openFile(ORGCHART_SQL_DEMO_INSERT_FILE.getAbsolutePath());
		
		robot.navigationLastStatement();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	public final void testFirstStatement() {
		
		robot.openFile(ORGCHART_SQL_DEMO_INSERT_FILE.getAbsolutePath());
		
		robot.navigationFirstStatement();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
		
	}	
	
	@Test
	public final void testSelectEntireStatement() {
		
		robot.openFile(ORGCHART_SQL_DEMO_INSERT_FILE.getAbsolutePath());
		
		robot.findSelection("Calculus 101");
		robot.navigationSelectEntireStatement();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public final void testExecuteBlockComment_on() {
		
		robot.insertBlockComment();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);

	}

	@Test
	public final void testExecuteBlockComment_off() {

		robot.openFile(ORGCHART_SQL_TMP_BLOCK_COMMENT.getAbsolutePath());	
		robot.removeBlockComment();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);

	}

	
	@Test
	public final void testExecuteLineComment_on() {

		robot.insertLineComment();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);

	}
	
	@Test
	public final void testExecuteLineComment_off() {

		robot.openFile(ORGCHART_SQL_TMP_LINE_COMMENT.getAbsolutePath());
		robot.removeLineComment();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);

	}
	

	@Test
	public final void testInsertRegion() {

		robot.insertRegion();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);

	}

	
	@Test
	public final void testInsertTarget() {

		robot.insertTarget(TARGET.getName());
		
		robot.execute();
		
		assertAreas(TARGET);

	}
	
	
	@Test
	public final void testInsertBookmark() {	
		
		robot.openFile(ORGCHART_SQL_DEMO_INSERT_FILE.getAbsolutePath());
		
		robot.addBookmarksTest("MS Wong");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	

	@Test
	public final void testRemoveBookmark() {	

		robot.openFile(ORGCHART_SQL_DEMO_INSERT_FILE.getAbsolutePath());
		
		robot.addBookmarksTest("MS Wong");
		robot.insertRemoveBookmark();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);

	}
	
	@Test
	public final void testGoToNextBookmark() {	
		
		robot.openFile(ORGCHART_SQL_DEMO_INSERT_FILE.getAbsolutePath());
				
		robot.addBookmarksTest("Math", "Mr Harris", "Music 101");		
		//I go back to Art and I should find as next bookmark, Mrs Jones 
		robot.findSelection("Mr Smith");
		
		robot.goToNextBookmark();
		
		robot.navigationSelectEntireStatement();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	

	@Test
	public final void testGoToPreviousBookmark() {	
		
		robot.openFile(ORGCHART_SQL_DEMO_INSERT_FILE.getAbsolutePath());
		
		robot.addBookmarksTest("Science", "Chemistry 101");		
		//I go  to Calculus 101 and I should find as previous bookmark, Chemistry 101 
		robot.findSelection("Calculus 101");
		
		robot.goToPreviousBookmark();
		
		robot.navigationSelectEntireStatement();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testRemoveAllBookmarks() {	
		
		robot.openFile(ORGCHART_SQL_DEMO_INSERT_FILE.getAbsolutePath());
		
		robot.addBookmarksTest("Science", "Mr Patel", "Algebra 101", "Biology 102");
		
		robot.removeAllBookmarks();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	

	
	
	@Test
	public final void testMessageView() {
		
		robot.execute();
		
		robot.messageView();
		
		assertAreas(MESSAGE);

	}
	
	@Test
	public final void testResultView() {

		robot.execute();
		
		robot.resultView();
		
		assertAreas(RESULT);

	}
	
	@Test
	public final void testShowGroupingForExecution() {
		
		robot.openFile(ORGCHART_SQL_DEMO_INSERT_FILE.getAbsolutePath());
		
		robot.testShowGroupingForExecution();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
		//restore the old setting
		robot.testShowGroupingForExecution();
	}
	
	
}
