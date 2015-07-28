package com.altova.databasespy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static java.awt.event.KeyEvent.VK_D;
import static com.altova.databasespy.DatabaseSpyRobot.*;

import java.io.File;

import org.junit.*;

import com.altova.util.IOUtils;

public class SQLRefactoringMenuTest extends AbstractDatabaseSpyTest{

	private final static String QUERY_TMP_1 = "SELECT [First] FROM [Person]";
	private final static String QUERY_TMP_2 = "SELECT First FROM Person ;";
	
	
	@After
	public void setUpAfter() throws Exception {
		
		robot.closeAll();
		robot.escapeDialog("Save modified files", VK_D);
	}
	
	
	
	
	@Test
	public void testFormatSQL(){
		
		robot.openFile(ORGCHART_SQL_WRAP_FILE.getAbsolutePath());
		robot.formatSQL();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testAddSemicolons(){
		
		robot.newSQLEditor();
		
		robot.typeString(QUERY_TMP_1);
		delay(3000);
		
		robot.addSemicolons();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public void testRemoveSemicolons(){
		
		robot.newSQLEditor();
		
		robot.typeString(QUERY_TMP_2);
		delay(200);
		
		robot.removeSemicolons();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	
	@Test
	public void testAddQuotations(){
		
		robot.newSQLEditor();
		
		robot.typeString(QUERY_TMP_2);
		delay(200);
		
		robot.addQuotations();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public void testRemoveQuotations(){
		
		robot.newSQLEditor();
		
		robot.typeString(QUERY_TMP_1);
		delay(200);
		
		robot.removeQuotations();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	public void testCreateViewAs(){
		
		robot.openFile(ORGCHART_PQRJ_SAVED_FILE_TMP_2.getAbsolutePath());
		
		String viewName = robot.getViewName();
		
		robot.createViewAs(viewName);
		robot.execute();
		
		assertAreas(MESSAGE);
		
		robot.writeSelectOnView(viewName);
		assertAreas(RESULT);
		robot.writedDropView(viewName);
		
	}
	
	@Test
	public void testUppercaseKeywords(){
		
		robot.openFile(ORGCHART_PQRJ_SAVED_FILE_TMP.getAbsolutePath());
		
		robot.uppercaseKeywords();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public void testExpandColumnsForStarExpression(){
		
		robot.openFile(ORGCHART_PQRJ_SAVED_FILE_TMP.getAbsolutePath());
		robot.findSelection("*");
	
		robot.expandColumnsForStarExp();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testRemoveComments(){
		
		robot.openFile(ORGCHART_SQL_TMP_COMMENTED.getAbsolutePath());
		robot.removeComments();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	public void testRemoveCommentsAndFormatting(){
		
		robot.openFile(ORGCHART_SQL_TMP_COMMENTED.getAbsolutePath());
		robot.removeCommentsAndFormatting();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
}
