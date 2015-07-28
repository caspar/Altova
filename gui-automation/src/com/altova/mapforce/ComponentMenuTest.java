/**
 * 
 */
package com.altova.mapforce;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import org.junit.Test;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.robots.CheckboxOption;
import com.altova.robots.Options;
import com.altova.robots.Pane;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;
import com.altova.util.IOUtils;
import com.altova.util.AltovaJUnitRunner.TestRobot;
import static com.altova.robots.ImageRecognitionRobot.WINDOWS_DEFAULT_FONT;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.MF_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;


/**
 * @author b.lopez
 *
 */

//@TestRobot(VSnetMapForceRobot.class)
//@TestRobot(EclipseMapForceRobot.class)
public class ComponentMenuTest extends AbstractMapForceTest {
	private final String CUSTOMERS_COMPONENT = IOUtils.findFile("tags_list/CUSTOMERS_XSD_TAG.PNG").getAbsolutePath();
	
	
	@Test
	public void testAlignTreeRight(){
		robot.openFile(EDI_ORDER_REVERSE_MFD);
		robot.selectComponentFromImage(ORDERS_COMPONENT);
		robot.alignTreeRight();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testAlignTreeLeft(){
		robot.openFile(EDI_ORDER_REVERSE_MFD);
		robot.selectComponentFromImage(ORDERS_COMPONENT);
		robot.alignTreeLeft();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testChangeRootElement(){
		robot.openFile(COMPLETE_PO_MFD);
		robot.selectComponentFromImage(CUSTOMERS_COMPONENT);
		robot.changeRootElement("Customer");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testAddRemoveTables(){
		robot.selectComponentFromImage(ALTOVADB_COMPONENT);
		robot.addRemoveTables();
		assertWindowAndEscape();
	}
	
	@Test
	public void testRefreshDB(){
		robot.selectComponentFromImage(ALTOVADB_COMPONENT);
		robot.refreshDB();
		delay(3000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testDuplicateInput(){
		Rectangle alt_comp=robot.selectComponentFromImage(ALTOVADB_COMPONENT);
		robot.leftClick(alt_comp.x+alt_comp.width, alt_comp.y+alt_comp.height+10);
		robot.duplicateInput();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testRemoveDuplicate(){
		Rectangle alt_comp=robot.selectComponentFromImage(ALTOVADB_COMPONENT);
		robot.leftClick(alt_comp.x+alt_comp.width, alt_comp.y+alt_comp.height+10);
		robot.duplicateInput();
		robot.removeDuplicate();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testDatabaseTableActions_insertAction(){
		
		if (AbstractJUnitTest.getRobot() instanceof EclipseMapForceRobot){
			Rectangle alt_comp=robot.selectComponentFromImage(CUSTOMERS_ADDRESSES);
			robot.leftClick(alt_comp.x+alt_comp.width, alt_comp.y+alt_comp.height+10);	
		}
		else
			robot.findElementInMapping("Addresses", null);
		robot.DBTableActions_insertAction("Number");
		assertAreas(TOP_WINDOW);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testDatabaseTableActions_appendAction(){
		
		
		if (AbstractJUnitTest.getRobot() instanceof EclipseMapForceRobot){
			Rectangle alt_comp=robot.selectComponentFromImage(CUSTOMERS_ADDRESSES);
			robot.leftClick(alt_comp.x+alt_comp.width, alt_comp.y+alt_comp.height+10);	
		}
		else
			robot.findElementInMapping("Addresses", null);
		
		
		robot.DBTableActions_appendAction("Street");
		
		assertAreas(TOP_WINDOW);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testDatabaseTableActions_deleteAction(){

		robot.findElementInMapping("Customers (2)", null);
		robot.DBTableActions_deleteAction("Number");
		
		assertAreas(TOP_WINDOW);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testDatabaseKeySettings_None(){
		
		robot.findElementInMapping("Customers (2)", null);
		
		Options options = new Options();
		options.add(new RadioOption("None", "SQL statement to execute before first record", null, null, null, WINDOWS_DEFAULT_FONT));
		
		robot.DBKeySettings(options);
		
		assertAreas(TOP_WINDOW);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testDatabaseKeySettings_deleteAllRecords(){

		robot.findElementInMapping("Customers (2)", null);
		
		Options options = new Options();
		options.add(new RadioOption("DELETE all records", "SQL statement to execute before first record", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("also delete all records in all child tables", true, "SQL statement to execute before first record", null, null, null, WINDOWS_DEFAULT_FONT));
		
		robot.DBKeySettings(options);
		
		assertAreas(TOP_WINDOW);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testDatabaseKeySettings_CustomSQL(){

		robot.findElementInMapping("Customers (2)", null);
		
		Options options = new Options();
		options.add(new RadioOption("Custom SQL", "SQL statement to execute before first record", null, null, null, WINDOWS_DEFAULT_FONT));
		options.add(new TextFieldOption("Custom SQL:         ", false, "Select Number from Customers (2) where Number > 5", "SQL statement to execute before first record", null, null, null, WINDOWS_DEFAULT_FONT ));
		
		robot.DBKeySettings(options);
		
		assertAreas(TOP_WINDOW);
		robot.leftClickMid(robot.findComponent("OK", "Button", null));
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testQueryDB(){
		Rectangle alt_comp=robot.selectComponentFromImage(ALTOVADB_COMPONENT);
		robot.leftClick(alt_comp.x+alt_comp.width, alt_comp.y+alt_comp.height+10);
		robot.queryDB();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testComponentProperties_noprettyprint_noXSDref(){
		robot.openFile(COMPLETE_PO_MFD);
		robot.selectComponentFromImage(COMPLETEPO_COMPONENT);
		Options options=new Options();
		options.add(new CheckboxOption("Add schema/DTD reference",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Pretty print output",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.componentProperties(options);
		robot.showOutput();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testComponentProperties_withprettyprint_withXSDref(){
		robot.openFile(COMPLETE_PO_MFD);
		robot.selectComponentFromImage(COMPLETEPO_COMPONENT);
		Options options=new Options();
		options.add(new CheckboxOption("Add schema/DTD reference",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Pretty print output",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.componentProperties(options);
		robot.showOutput();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
}
