package com.altova.umodel.regression.testcases;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.umodel.regression.gui.UModelRobot.MODEL_TREE;
import static com.altova.umodel.regression.gui.UModelRobot.PROPERTIES;
import static java.awt.event.KeyEvent.VK_ESCAPE;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;
import static com.altova.umodel.regression.gui.UModelRobot.DOCUMENTATION;

import com.altova.nativegui.NativeGUI;
import com.altova.robots.PluginRobot;
import com.altova.robots.ScriptMistakeException;
import com.altova.spy.VSnetSpyRobot;

import com.altova.umodel.regression.gui.EclipseUModelRobot;
import com.altova.umodel.regression.gui.VSnetUModelRobot;
import com.altova.util.Settings;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;

//@TestRobot(VSnetUModelRobot.class)
//@TestRobot(EclipseUModelRobot.class)
public class EditMenuTest extends AbstractUmodelTest {

	//-----------------------------               EDIT MENU  -----------------------------

	
	@Test
	public final void testUndo() {
		robot.newRootElement("Class", "test");
		robot.undo();
		robot.undo();
		assertAreas(MODEL_TREE);
	}

	@Test
	public final void testRedo() {
		robot.newRootElement("Class", "test");
		robot.undo();
		robot.redo();
		assertAreas(MODEL_TREE);
	}

	@Test
	public final void testCut() {
		robot.leftClickModelTreeElement(DEPLOYMENT_DIAGRAM_ARTIFACT,true);
		robot.cut();
		assertAreas(MODEL_TREE);
	}
	
	@Test	
	public final void testCutInDiagram() {
		if(Settings.isVS2010()){
			robot.openDiagram(HIERARCHY_DIAGRAM_VS2010);
		}else{
			robot.openDiagram(HIERARCHY_DIAGRAM);
		}
		robot.findDiagramElement(CLASS_DIAGRAM_SAVINGSACCOUNT,true);
		robot.cut();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testCopyPaste() {
		robot.leftClickModelTreeElement(DEPLOYMENT_DIAGRAM_ARTIFACT,true);
		robot.copy();
		robot.paste();
		assertAreas(MODEL_TREE);
	}

	@Test
	public final void testCopyPasteInDiagram() {
		if(Settings.isVS2010()){
			robot.openDiagram(HIERARCHY_DIAGRAM_VS2010);
		}else{
			robot.openDiagram(HIERARCHY_DIAGRAM);
		}
		robot.findDiagramElement(CLASS_DIAGRAM_SAVINGSACCOUNT,true);
		robot.copy();
		robot.paste();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testPasteInDiagramOnly() {
		robot.leftClickElement(DEPLOYMENT_DIAGRAM_ARTIFACT);
		robot.copy(); 
		robot.pasteInDiagramOnly();
		assertAreas(MODEL_TREE,DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testDeleteInModelTree() {
		robot.leftClickModelTreeElement(DEPLOYMENT_DIAGRAM_ARTIFACT,true);
		robot.delete();
		assertAreas(MODEL_TREE);
	}

	
	@Test
	public final void testDeleteOnlyInDiagram() {
		if(Settings.isVS2010()){
			robot.openDiagram(HIERARCHY_DIAGRAM_VS2010);
		}else{
			robot.openDiagram(HIERARCHY_DIAGRAM);
		}
		Rectangle elemLocation=robot.findDiagramElement(CLASS_DIAGRAM_SAVINGSACCOUNT,true);
		robot.clickOnElement(elemLocation);
		robot.delete(true);
		assertAreas(DIAGRAM_MAIN_WINDOW,MODEL_TREE);
	}
	
	@Test
	public final void testDeleteAllFromDiagram() {
		if(Settings.isVS2010()){
			robot.openDiagram(HIERARCHY_DIAGRAM_VS2010);
		}else{
			robot.openDiagram(HIERARCHY_DIAGRAM);
		}
		robot.findDiagramElement(CLASS_DIAGRAM_SAVINGSACCOUNT,true);
		robot.delete(false);
		assertAreas(DIAGRAM_MAIN_WINDOW,MODEL_TREE);
	}
	
	@Test
	public final void testDeleteFromDiagramDlg() {
		if(Settings.isVS2010()){
			robot.findDiagramElement(DEPLOYMENT_DIAGRAM_ARTIFACT,true);
		}else{
			robot.leftClickElement(DEPLOYMENT_DIAGRAM_ARTIFACT);
		}
		
		robot.deleteFromDiagramOnly();
		assertAreas(DIAGRAM_MAIN_WINDOW,MODEL_TREE);
	}

	@Test
	public final void testSelectAll() {
		robot.openDiagram(CLASS_DIAGRAM);
		robot.selectAll();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testFindInDiagram_MWW_MC() {
		robot.openDiagram(CLASS_DIAGRAM);
		robot.findDialog(WORD_TO_FIND,false,true,true,false);
		robot.findNext();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
		
	@Test
	public final void testFindInDiagram() {
		robot.openDiagram(CLASS_DIAGRAM);
		robot.findDialog("bank",false,false,false,false);
		robot.findNext();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testFindInDiagram_MWW() {
		robot.openDiagram(CLASS_DIAGRAM);
		robot.findDialog("bankview",false,true,false,false);
		robot.findNext();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public final void testFindInDiagram_MC() {
		robot.openDiagram(CLASS_DIAGRAM);
		robot.findDialog("Bank",false,false,true,false);
		robot.findNext();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public final void testFind_negativeTC() {
		robot.openDiagram(CLASS_DIAGRAM);
		robot.findDialog("bankview", false, false, true, true);
		boolean ifescaped=robot.escapeDialog("Cannot find the string", VK_ESCAPE);delay(500);
		robot.escapeDialog("Find", KeyEvent.VK_ESCAPE);
		if (!ifescaped){
			throw new ScriptMistakeException("Expected 'String was not found' dialog did not appear");
		}
	}
	
	
	@Test
	public final void testFindInModelTree() {
		robot.findModelTreeElement(DEPLOYMENT_DIAGRAM_ARTIFACT,true);
		assertAreas(MODEL_TREE);
	}
	
	

	@Test
	public final void testFindPrevious() {
		robot.selectModelTreeRoot();
		robot.findDialog(WORD_TO_FIND,false,true,true,false);
		robot.findNext();
		robot.findNext();
		robot.findPrevious();
		assertAreas(MODEL_TREE);
	}

	@Test 
	public void testReplaceFromModelTree(){
		robot.selectModelTreeRoot();
		robot.replace("com","TEST", false,true,true,false);
		robot.escapeDialog("Cannot find replaceable string", KeyEvent.VK_ENTER);
		robot.escapeDialog("Find & Replace", VK_ESCAPE);
		assertAreas(MODEL_TREE);
	}
	
	@Test
	public void testReplaceAllFromDiagram(){
		if(Settings.isVS2010()){
			robot.openDiagram(HIERARCHY_DIAGRAM_VS2010);
		}else{
			robot.openDiagram(HIERARCHY_DIAGRAM);
		}
		robot.replace("Account","STRING_CHANGED",true,false,true,false);
		delay(2000);
		for (int i = 1; i <= 4; i++) {
			robot.escapeDialog("Also change the code file name", KeyEvent.VK_ENTER);
			delay(2000);
		}
		robot.escapeDialog("Replaced",KeyEvent.VK_ESCAPE);
		delay(1000);
		robot.escapeDialog("Find & Replace",KeyEvent.VK_ESCAPE);
		assertAreas(DIAGRAM_MAIN_WINDOW,MODEL_TREE);
	}
	
	@Test
	public void testReplaceFromDiagramInSelectionOnly(){
		if(Settings.isVS2010()){
			robot.openDiagram(HIERARCHY_DIAGRAM_VS2010);
		}else{
			robot.openDiagram(HIERARCHY_DIAGRAM);
		}
		robot.findDialog("SavingsAccount");
		robot.replace("interestRate", "CHANGED", true, false,false, true);
		robot.escapeDialog("Replaced", KeyEvent.VK_ENTER);
		delay(1000);
		robot.escapeDialog("Find & Replace",KeyEvent.VK_ESCAPE);
		assertAreas(DIAGRAM_MAIN_WINDOW,MODEL_TREE);
		
	}
	
	@Test
	public void testReplaceInDocumentationWnd(){
		robot.openDiagram(CLASS_DIAGRAM);
		Rectangle docwnd=robot.activatePane(DOCUMENTATION);
		robot.leftClickMid(docwnd); //this positions the cursor in the documentation wnd 
		robot.typeString("This is a test for the documentation window");
		robot.replace("test","string was changed  ", false,true,true,false);
		robot.escapeDialog("Cannot find replaceable string", KeyEvent.VK_ENTER);
		robot.escapeDialog("Find & Replace",KeyEvent.VK_ESCAPE);
		assertAreas(DOCUMENTATION);
	}
	
	@Test
	public final void testCopyAsBitmap() {
		robot.openDiagram(CLASS_DIAGRAM);
		if(Settings.isVS2010()){
		robot.viewOnOffDocumentation(); //this removes the recently used documentation window from the UI
		}
		robot.copyAsBitmap();
	}

	
	@Test
	public final void testCopySelectionAsBitmap() {
		if(Settings.isVS2010()){
			robot.findDiagramElement(DEPLOYMENT_DIAGRAM_ARTIFACT,true);
		}else{
			robot.select(DEPLOYMENT_DIAGRAM_ARTIFACT); 
		}
		
		robot.copySelectionAsBitmap();
	}
}
