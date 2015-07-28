package com.altova.schemaagent;

import static com.altova.util.LoggerUtils.logger;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.schemaagent.SchemaAgentRobot.OVERVIEW;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.ScriptMistakeException;

public class LayoutMenuTest extends AbstractSchemaAgentTest {
	
	
	
	@Before 
	public void startUp(){
		
		robot.openFile(DB_COMPLETEPO_FILE);
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
	public void testShowGrid() {
		
		robot.showGrid();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
		
		
	}
	
	@Test
	public void testAlignOnGrid() {
		
		robot.findElementOnDiagram("DB_CompletePO.mfd");
		
		robot.alignOnGrid();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	public void testZoom() {
		
		robot.zoom(35);
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
		
	}
	
	@Test
	public void testZoomToFit() {
		
		robot.zoomToFit();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
	}
	
	@Test
	public void testZoomToSelection() {
		
		robot.findElementOnDiagram("Request.wsdl");
		
		robot.zoomToSelection();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
	}

	
	
	@Test
	public void testZoom50() {
		
		robot.zoom(50);
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
		
	}
	
	@Test
	public void testZoom75() {
		
		robot.zoom(75);
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
		
	}

	@Test
	public void testZoom100() {
		
		robot.zoom(100);
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
		
	}

	@Test
	public void testZoom150() {
		
		robot.zoom(150);
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
		
	}

	@Test
	public void testZoom200() {
		
		robot.zoom(200);
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
		
	}

	@Test
	public void testForceDirected() {
		
		robot.findElementOnDiagram("Article.xsd", "Customer"); //doesnt recognize anymore Customer.xsd
		robot.forceDirected();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
	}

	@Test
	public void testHierarchical() {
		
		robot.findElementOnDiagram("Complete.xsl", "ShortPO.xsd");
		robot.hierarchical();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);	
	}

	@Test
	public void testAlignEdges_Left() {
		
		robot.findElementOnDiagram("DB_CompletePO.mfd", "CompletePO.xsd", "Customer", "Article.xsd");
		robot.alignEdges("Left");
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);	
	}

	@Test
	public void testAlignEdges_Right() {

		robot.findElementOnDiagram("DB_CompletePO.mfd", "CompletePO.xsd", "Request.wsdl", "Article.xsd");
		robot.alignEdges("Right");
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);	
	}
	
	@Test
	public void testAlignEdges_Top() {

		robot.findElementOnDiagram("DB_CompletePO.mfd", "CompletePO.xsd", "Request.wsdl", "Article.xsd");
		robot.alignEdges("Top");
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);	
	}

	@Test
	public void testAlignEdges_Bottom() {

		robot.findElementOnDiagram("DB_CompletePO.mfd", "CompletePO.xsd", "Request.wsdl", "Article.xsd");
		robot.alignEdges("Bottom");
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);	
	}
	
	@Test
	public void testAlignEdges_CenterlVertical() {
		
		robot.findElementOnDiagram("DB_CompletePO.mfd", "CompletePO.xsd", "Request.wsdl", "Article.xsd");
		robot.alignEdges("Center Vertical");
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);	
	}
	
	@Test
	public void testAlignEdges_CenterHorizontal() {
		
		robot.findElementOnDiagram("DB_CompletePO.mfd", "CompletePO.xsd", "Request.wsdl", "Article.xsd");
		robot.alignEdges("Center Horizontal");
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);	
	}
	
	@Test
	public void testLineUp_Vertically() {
		
		robot.findElementOnDiagram("Complete.xsl", "ShortPO.xml");
		robot.lineUp("Vertically");
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
	}
	
	@Test
	public void testLineUp_Horizontally() {
		
		robot.findElementOnDiagram("Complete.xsl", "ShortPO.xml");
		robot.lineUp("Horizontally");
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
	}
	
	@Ignore
	@Test
	public void testOrder_BringToTop() {
		fail("no sense to implement");
		
	}

	@Test
	public void testOrder_BringToBottom() {
		
		robot.openFile(DB_COMPLETEPO_ALIGNED_FILE);
		
		robot.findElementOnDiagram("ShortPO.xml");
		robot.bringToBottom();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
	}
	
	
	@Test
	public void testResize_MakeSameWidth() {
		
		robot.openFile(DB_COMPLETEPO_MIX_FILE);
		
		robot.selectAll();
		robot.makeSameWidth();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
		
	}
	
	@Test
	public void testResize_MakeSameHeight() {
		
		robot.openFile(DB_COMPLETEPO_MIX_FILE);
		
		robot.selectAll();
		robot.makeSameHeight();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
		
	}
	
	@Test
	public void testResize_MakeSameSize() {
		
		robot.openFile(DB_COMPLETEPO_MIX_FILE);
		
		robot.selectAll();
		robot.makeSameSize();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
		
	}
	
	@Test
	public void testSpaceEvenly_Vertically() {
		
		robot.openFile(DB_COMPLETEPO_MIX_FILE);
		
		robot.selectAll();
		robot.spaceEvenly("Vertically");
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
		
	}

	
	@Test
	public void testSpaceEvenly_Horizontally() {
		
		robot.openFile(DB_COMPLETEPO_MIX_FILE);
		
		robot.selectAll();
		robot.spaceEvenly("Horizontally");
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
		
	}
	
	@Test
	public void testSortByName_Ascending() {
		
		robot.openFile(DB_COMPLETEPO_MIX_FILE);
		
		robot.selectAll();
		robot.sortAscending("By Name");
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
		
	}

	@Test
	public void testSortByName_Descending() {
		
		robot.openFile(DB_COMPLETEPO_MIX_FILE);
		
		robot.selectAll();
		robot.sortDescending("By Name");
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
		
	}
	
	@Test
	public void testSortByWidth_Ascending() {
		
		robot.openFile(DB_COMPLETEPO_MIX_FILE);
		
		robot.selectAll();
		robot.sortAscending("By Width");
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
		
	}

	@Test
	public void testSortByWidth_Descending() {
		
		robot.openFile(DB_COMPLETEPO_MIX_FILE);
		
		robot.selectAll();
		robot.sortDescending("By Width");
		
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW);
		
	}
	
}
