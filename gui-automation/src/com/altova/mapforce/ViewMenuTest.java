/**
 * 
 */
package com.altova.mapforce;

import org.junit.Test;

import com.altova.nativegui.NativeGUI;
import com.altova.robots.ScriptMistakeException;
import com.altova.util.IOUtils;
import com.altova.util.Settings;
import com.altova.util.AltovaJUnitRunner.TestRobot;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
/**
 * @author b.lopez
 *
 */
//@TestRobot(VSnetMapForceRobot.class)
//@TestRobot(EclipseMapForceRobot.class)
public class ViewMenuTest extends AbstractMapForceTest {

	
	@Test
	public void testShowAnnotationsOff(){
		robot.enableDisableAnnotations();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	//We rely on the fact that this is the default value
	@Test
	public void testShowAnnotationsOn(){
		robot.enableDisableAnnotations();
		robot.enableDisableAnnotations();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testShowTypesOn(){
		robot.enableDisableShowTypes();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	//We rely on the fact that this is the default value
	@Test
	public void testShowTypesOff(){
		robot.enableDisableShowTypes();
		robot.enableDisableShowTypes();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public void testShowLibraryInFunctionHeaderOn(){
		robot.openFile(COMPLETE_PO_MFD);
		robot.showHideLibraryInFunctionHeader();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	//We rely on the fact that this is the default value
	@Test
	public void testShowLibraryInFunctionHeaderOff(){
		robot.openFile(COMPLETE_PO_MFD);
		robot.showHideLibraryInFunctionHeader();
		robot.showHideLibraryInFunctionHeader();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testXBRLDisplayOptions(){
		robot.XBRLDisplayOptions();
		assertWindowAndEscape();
	}
	
	@Test
	public void testShowSelectedComponentConnectors_on(){ 
		robot.openFile(COMPLETE_PO_MFD);
		robot.selectComponentFromImage(COMPLETEPO_COMPONENT);
		robot.showSelectedComponentConnectors();
		try{
		robot.leftClick(robot.getMainWindow().x+5, robot.getMainWindow().y+5); // we unselect any component to check the result
		assertAreas(DIAGRAM_MAIN_WINDOW);
		}finally{
			robot.showSelectedComponentConnectors();
		}
	}
	
//	We rely on the fact that this is the default value
	@Test
	public void testShowSelectedComponentConnectors_off(){ 
		robot.openFile(COMPLETE_PO_MFD);
		robot.selectComponentFromImage(COMPLETEPO_COMPONENT);
		robot.showSelectedComponentConnectors();
		robot.showSelectedComponentConnectors();
		robot.leftClick(robot.getMainWindow().x+5, robot.getMainWindow().y+5); // we unselect any component to check the result
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testShowConnectorsFromSourceToTarget_off(){
		robot.openFile(COMPLETE_PO_MFD);
		robot.selectComponentFromImage(COMPLETEPO_COMPONENT);
		robot.showSelectedComponentConnectors();
		
		try{
			robot.showConnectorsFromSourceToTarget();
			
		}catch(ScriptMistakeException e){
			robot.showSelectedComponentConnectors();
			robot.showConnectorsFromSourceToTarget();
		}
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testShowConnectorsFromSourceToTarget_on(){
		robot.openFile(COMPLETE_PO_MFD);
		robot.selectComponentFromImage(COMPLETEPO_COMPONENT);
		robot.showSelectedComponentConnectors();
		
		try{
			robot.showConnectorsFromSourceToTarget();
			
		}catch(ScriptMistakeException e){
			if (Settings.isVS2010()) {
				robot.leftClick(20, 3); // we click somewhere to solve small
										// problems with preselections in View
										// menu in VS2010
			}
			robot.showSelectedComponentConnectors();
			
			robot.showConnectorsFromSourceToTarget();
		}
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testZoom(){
		robot.zoom("40");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
}
