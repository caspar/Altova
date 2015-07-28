package com.altova.diffdog;
import org.junit.Test;

//import java.awt.Point;
import java.awt.Rectangle;
//import java.awt.event.KeyEvent;
import java.io.File;
//import java.util.logging.Logger;
import static java.awt.event.KeyEvent.*;

import com.altova.robots.ImageUtils;
//import com.altova.robots.ScriptMistakeException;
import com.altova.util.IOUtils;
//import com.altova.util.Settings;
//import com.altova.util.AltovaJUnitRunner.TestRobot;
//import com.sun.imageio.plugins.common.ImageUtil;
//import com.sun.jmx.mbeanserver.OpenConverter;

import static com.altova.robots.SnapshotArea.CommonArea.*;
//import static com.altova.util.LoggerUtils.logger;

public class ContextMenuTest extends AbstractDiffDogTest{
	
	private static final File XSDL1 = IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","DB2schema.xsd");
	private static final File XSDL2 = IOUtils.findFileDiffDog("examples/RightSide/ComparisonFiles/","DB2schema.xsd");
	private static final File XSDIF_Unmaped = IOUtils.findFileDiffDog("examples/","XMLSchemaComparisonUnmaped.xsdif");
	private static final File XSDIF_Inlayout = IOUtils.findFileDiffDog("examples/","XMLSchemaComparisonInlayout.xsdif");
	private static final File XSDIF_SCHEMA_COMPA_VALID = IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","XMLSchemaComparison_valid_1.xsdif");
	
	
	private static final File DATABASE_Schema_ZOO=IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","Zoo.dbsdif");
	private static final File DATABASE_ZOO=IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","Zoo.dbdif");
	private static final File KEEPERS = IOUtils.findFileDiffDog("tags_list/","Keepers.png");
	private static final File ANIMALS = IOUtils.findFileDiffDog("tags_list/","Animals.png");
	private static final File SPECIES = IOUtils.findFileDiffDog("tags_list/","Species.png");
	private static final File ANIMALS_LEFT = IOUtils.findFileDiffDog("tags_list/","Animals_Left.png");
	private static final File ANIMALS_RIGHT_SELECTED = IOUtils.findFileDiffDog("tags_list/","Animals_Right_Selected.png");
	private static final File KEEPERS_NOT_SELECTED = IOUtils.findFileDiffDog("tags_list/","Keepers_Not_Selected.png");
	private static final File DIFF_ICO=IOUtils.findFileDiffDog("res/","DIFF_ICO.png");
	private static final File DEPARTAMENT = IOUtils.findFileDiffDog("tags_list/","Departament.png");
	private static final String DEPARTAMENT_LEFT = IOUtils.findFileDiffDog("tags_list/","Department_Left.png").getAbsolutePath();
	private static final String DEPARTAMENT_RIGHT = IOUtils.findFileDiffDog("tags_list/","Deparment_Right.png").getAbsolutePath();
	private static final File DEPARTAMENT_SUB_ELE = IOUtils.findFileDiffDog("tags_list/","Departament_SubEle.png");
	private static final File ZOO = IOUtils.findFileDiffDog("examples/LeftSide/ComparisonFiles/","Zoo.dbdif");
	private static final File OPEN_LEFT_SCHEMA_ICON = IOUtils.findFileDiffDog("res/","OPEN_LEFT_SCHEMA_ICO.png");
	
	//XML Schema
	@Test
	public void testXMLSchemaExpandItems(){
		robot.compareXMLSchemass(XSDL1,"Altova", XSDL2,"Altova");
		robot.contextMenu("Expand items");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testXMLSchemaUnmapItems(){
		robot.compareXMLSchemass(XSDL1,"Altova", XSDL2,"Altova");
		robot.contextMenu("Unmap items");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testXMLSchemaStartXMLMapping(){
		robot.openComparisonFile(XSDIF_Unmaped);
		robot.contextMenu("Start XML Schema mapping");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testXMLSchemaCollapseItems(){
		robot.compareXMLSchemass(XSDL1,"Altova", XSDL2,"Altova");
		robot.contextMenu("Collapse items");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testXMLSchemaExpandItemsAndAutolayout(){
		robot.openComparisonFile(XSDIF_Inlayout);
		robot.contextMenu("Autolayout");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	//Word
	
	
	@Test
	public void testCloseModifiedComparisonWordDocuments(){
		robot.leftClickMenuItem("File", "Compare MS-Word files");
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.delay(500);
		robot.typeString("World");
		robot.startComparison();
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.typeString("Hello ");
		delay(1500);
		robot.tabsContextMenu("Close", TAB_WORD);
		robot.escapeDialog("Save changes", VK_N);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	//DatabaseSchema
	
	@Test
	public void testSaveMerge(){
		robot.openComparisonFile(DATABASE_Schema_FILE);
		robot.startComparison();
		robot.contextMenu("Save merge script: Left to Right...");
		if(!robot.escapeDialog("Save SQL Changescript", VK_ESCAPE))
			fail("Save as dialog doesn't appear");
		robot.contextMenu("Save merge script: Right to Left...");
		if(!robot.escapeDialog("Save SQL Changescript", VK_ESCAPE))
			fail("Save as dialog doesn't appear");
	}
	@Test
	public void testOpenSchemaCompariosnInNewDataComparion(){
		robot.openComparisonFile(DATABASE_Schema_FILE);
		robot.startComparison();
		robot.contextMenu("Open in new Data Comparison");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testOpenSelectedInNewDataComparison(){
		robot.openComparisonFile(DATABASE_Schema_ZOO);
		robot.startComparison();
		Rectangle rect = robot.findTagsImage(KEEPERS);
		robot.contextMenu("Open selected in new Data Comparison",ImageUtils.findMid(rect));
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testOpenSelected2ItemsInNewDataComparison(){
		robot.openComparisonFile(DATABASE_Schema_ZOO);
		robot.startComparison();
		Rectangle first = robot.findTagsImage(ANIMALS);
		Rectangle second = robot.findTagsImage(SPECIES);
		robot.select2Rectangles(first, second);
		robot.contextMenu("Open selected in new Data Comparison",ImageUtils.findMid(second));
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testMapItemsDBSchema(){
		robot.openComparisonFile(DATABASE_Schema_ZOO);
		robot.startComparison();
		robot.contextMenu("Map items");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testUnmapItemsDBSchema(){
		robot.openComparisonFile(DATABASE_Schema_ZOO);
		robot.startComparison();
		robot.contextMenu("Unmap items");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testCollapseAll(){
		robot.openComparisonFile(DATABASE_Schema_ZOO);
		robot.startComparison();
		robot.contextMenu("Collapse items");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testExpandAll(){
		robot.openComparisonFile(DATABASE_Schema_ZOO);
		robot.startComparison();
		robot.contextMenu("Collapse items");
		delay(1000);
		robot.contextMenu("Expand items");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testSortTablesDescending(){
		robot.openComparisonFile(DATABASE_Schema_ZOO);
		robot.startComparison();
		robot.contextMenu("Sort items","Descending");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testSortTablesAscending(){
		robot.openComparisonFile(DATABASE_Schema_ZOO);
		robot.startComparison();
		robot.contextMenu("Sort items","Ascending");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testSortTablesDescendingMapppedFirst(){
		robot.openComparisonFile(DATABASE_Schema_ZOO);
		robot.startComparison();
		robot.contextMenu("Sort items","Descending mapped first");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testSortTablesAscendingMapppedFirst(){
		robot.openComparisonFile(DATABASE_Schema_ZOO);
		robot.startComparison();
		robot.contextMenu("Sort items","Ascending mapped first");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	//DatabaseData
	
	@Test
	public void testSortTablesDescendingDBdata(){
		robot.openComparisonFile(DATABASE_ZOO);
		robot.startComparison();
		robot.contextMenu("Sort tables","Descending");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testSortTablesAscendingDBdata(){
		robot.openComparisonFile(DATABASE_ZOO);
		robot.startComparison();
		robot.contextMenu("Sort tables","Ascending");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testSortTablesDescendingMapppedFirstDBdata(){
		robot.openComparisonFile(DATABASE_ZOO);
		robot.startComparison();
		robot.contextMenu("Sort tables","Descending mapped first");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testSortTablesAscendingMapppedFirstDBdata(){
		robot.openComparisonFile(DATABASE_ZOO);
		robot.startComparison();
		robot.contextMenu("Sort tables","Ascending mapped first");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testCollapseAllDBdata(){
		robot.openComparisonFile(DATABASE_ZOO);
		robot.startComparison();
		robot.contextMenu("Collapse tables");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testExpandAllDBdata(){
		robot.openComparisonFile(DATABASE_ZOO);
		robot.startComparison();
		robot.contextMenu("Collapse tables");
		delay(1000);
		robot.contextMenu("Expand tables");
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testShowReultDBdata(){
		robot.openComparisonFile(DATABASE_ZOO);
		robot.contextMenu("Compare tables");
		delay(1000);
		robot.contextMenu("Show results");
		robot.escapeDialog("Data is equal,", VK_N);
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testMapItemsDBdata(){
		robot.openComparisonFile(DATABASE_ZOO);
		robot.startComparison();
		robot.contextMenu("Unmap items");
		assertAreas(MF_MAIN_WINDOW);
		robot.contextMenu("Map items");
		assertAreas(getTestName() + "2", MF_MAIN_WINDOW);
	}
	
	@Test
	public void testUnmapSelctedDBData(){
		robot.openComparisonFile(DATABASE_ZOO);
		robot.startComparison();
		Rectangle rect = robot.findTagsImage(ANIMALS_LEFT);
		robot.contextMenu("Unmap selected",ImageUtils.findMid(rect));
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testCompareSelectedTables(){
		robot.openComparisonFile(DATABASE_ZOO);
		Rectangle rect = robot.findTagsImage(ANIMALS_LEFT);
		robot.contextMenu("Compare selected tables",ImageUtils.findMid(rect));
		rect = robot.findTagsImage(DIFF_ICO);
		robot.contextMenu("Compare tables",ImageUtils.findMid(rect));
		
		Rectangle rect2 = robot.findTagsImage(KEEPERS_NOT_SELECTED);
		robot.contextMenu("Open selected in new Schema Comparison",ImageUtils.findMid(rect2));
		assertAreas(MF_MAIN_WINDOW);
	}
	//XML Schemas
	@Test
	public void testUnmapSelctedXMLSchema(){
		robot.openComparisonFile(XSDIF_SCHEMA_COMPA_VALID);
		robot.startComparison();
		delay(4000);
		Rectangle rect = robot.findTagsImage(DEPARTAMENT);
		robot.contextMenu("Unmap selected",ImageUtils.findMid(rect));
		delay(100);
		robot.undo();
		delay(100);
		robot.redo();
		delay(100);
		robot.contextMenu("Set as active root element",ImageUtils.findMid(rect));
		delay(100);
		assertAreas(MF_MAIN_WINDOW);
		
	}
	@Test
	public void testApplyMappingFromGlobalItem(){
		robot.openComparisonFile(XSDIF_SCHEMA_COMPA_VALID);
		robot.startComparison();
		robot.contextMenu("Unmap items");
		delay(4000);
		robot.dragDropSchema(DEPARTAMENT_LEFT, DEPARTAMENT_RIGHT);
		robot.contextMenu("Collapse items");
		robot.contextMenu("Expand items");
		robot.contextMenu("Autolayout");
		Rectangle rect = robot.findTagsImage(DEPARTAMENT_SUB_ELE);
		robot.contextMenu("Apply mapping from global item",ImageUtils.findMid(rect));
		assertAreas(MF_MAIN_WINDOW);
	}
	
	//DatabaseData
	@Test
	public void testCheckContextMenuMain(){
		robot.openComparisonFile(ZOO);
		robot.contextMenu("");
		delay(200);
		assertAreas(DIFF_DOG_UP_WINDOW);
	}
	@Test
	public void testCheckContextMenuEle(){
		robot.openComparisonFile(ZOO);
		Rectangle rect = robot.findTagsImage(OPEN_LEFT_SCHEMA_ICON);
		robot.contextMenu("",ImageUtils.findMid(rect));
		delay(200);
		assertAreas(DIFF_DOG_UP_WINDOW);
	}
	
}
