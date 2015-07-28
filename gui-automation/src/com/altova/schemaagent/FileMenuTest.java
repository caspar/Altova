package com.altova.schemaagent;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.schemaagent.SchemaAgentRobot.*;
import static com.altova.util.LoggerUtils.logger;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;

import com.altova.robots.ScriptMistakeException;


public class FileMenuTest extends AbstractSchemaAgentTest {


	
	@Before 
	public void startUp(){
		
		robot.newDesign();
	}
	
	
	@After
	public void CleanUp() {
		try {
			robot.closeWithoutSave();
		} catch(ScriptMistakeException e) {
			logger.fine("Could not Design window - probably already closed: "+e);
		}
	}
	
	
	@Test
	public void testFileNew() {
		
		robot.newDesign();
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	public void testOpenFile() {
		
		robot.openFile(ORGCHART_SAD_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testCloseFile() {
		
		robot.openFile(DB_COMPLETEPO_MAPFORCE_FILE);
		
		robot.closeWithoutSave();
		assertNull(robot.getDiagramComponent());
	}
	
	@Test
	public final void testCloseAllFiles() {
			robot.openFile(ORGCHART_SAD_FILE);
			robot.closeAll();
			
			assertNull(robot.getDiagramComponent());
	}
	
	@Test
	public final void testSaveFile() {
		
		robot.openFile(ORGCHART_SAD_FILE_SAVED);
		
		robot.saveFile();
		assertFileExists(ORGCHART_SAD_FILE_SAVED);
		
	}
	
	@Test
	public final void testSaveAsFile() {
		
		removeAndAssert(ORGCHART_SAD_FILE_SAVED);
		robot.openFile(ORGCHART_SAD_FILE);
		
		robot.saveFileAs(ORGCHART_SAD_FILE_SAVED);
		assertFileExists(ORGCHART_SAD_FILE_SAVED);

		
	
		
	}
	
	@Test
	public void testExportToImage(){
		
		removeAndAssert(EXPORT_IMAGE_ORGCHART_FILE);
		robot.openFile(ORGCHART_SAD_FILE);
		
		robot.exportToImage(EXPORT_IMAGE_ORGCHART_FILE);
		
		assertFileExists(EXPORT_IMAGE_ORGCHART_FILE);
	}
	
	
	

}
