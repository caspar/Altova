package com.altova.semanticworks;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.semanticworks.SemanticWorksRobot.*;
import static com.altova.robots.SnapshotArea.CommonArea.SEMANTICWORKS_MAIN_WINDOW;

import java.awt.event.KeyEvent;

import org.junit.Ignore;
import org.junit.Test;

public class FileMenuTest extends AbstractSemanticWorks {

	
	
	@Test
	public final void testNewFile() {
		
		robot.newFile();
		assertAreas(SEMANTICWORKS_MAIN_WINDOW, ERRORS, DETAILS);	
	}
	
	
	
	@Test
	public final void testOpenFile() {
		
		assertAreas(SEMANTICWORKS_MAIN_WINDOW, ERRORS, DETAILS);
		
	}
	

	@Test
	public final void testSaveDiagramAsImage() {
		
		removeAndAssert(ALTOVAPRODUCTS_DIAGRAM_PNG_FILE);
		robot.openDiagram("XMLSpy", OverviewTab.Classes);
		
		robot.saveDiagramAsImage();
		
		assertFileExists(ALTOVAPRODUCTS_DIAGRAM_PNG_FILE);
		
	}

	
	@Test
	public final void testCloseAllFiles() {
	       
		robot.openFile(ALTOVADOCUMENTS_RDF_FILE.getAbsolutePath());
		robot.closeAll();
		
		assertNull(robot.getDiagramComponent());
	}
	
	@Test
	public final void testEncoding() {
		
		robot.encoding();
		robot.keyType(KeyEvent.VK_END);
		delay(2000);
		robot.keyType(KeyEvent.VK_ENTER);
		delay(2000);
		robot.textView();
		assertAreas(DIAGRAM_MAIN_WINDOW);

	}
	
	@Test
	public final void testSaveFile() {
		
		robot.saveFile();
		
		assertFileExists(ALTOVAPRODUCTS_RDF_FILE);
		
	}
	
	@Test
	public final void testSaveAsFile() {
		
		removeAndAssert(ALTOVAPRODUCTS_RDF_FILE_SAVED);
		robot.openFile(ALTOVAPRODUCTS_RDF_FILE);
		
		robot.saveFileAs(ALTOVAPRODUCTS_RDF_FILE_SAVED);
		assertFileExists(ALTOVAPRODUCTS_RDF_FILE_SAVED);
	
	}
	
	@Test
	public final void testExportTo_nt() {
		
		removeAndAssert(ALTOVAPRODUCTS_EXPORT_NT_FILE);
		
		robot.exportTo_nt(ALTOVAPRODUCTS_EXPORT_NT_FILE);
		assertFileExists(ALTOVAPRODUCTS_EXPORT_NT_FILE);
		
	}

	@Test
	public final void testExportTo_XML() {
		
		removeAndAssert(ALTOVAPRODUCTS_EXPORT_XML_FILE);
		
		robot.exportTo_XML(ALTOVAPRODUCTS_EXPORT_XML_FILE);
		assertFileExists(ALTOVAPRODUCTS_EXPORT_XML_FILE);
		
	}
	
}
