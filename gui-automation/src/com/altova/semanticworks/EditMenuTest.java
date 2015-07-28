package com.altova.semanticworks;

import static com.altova.robots.SnapshotArea.CommonArea.SEMANTICWORKS_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.semanticworks.SemanticWorksRobot.DETAILS;
import static com.altova.semanticworks.SemanticWorksRobot.ERRORS;

import org.junit.Test;

import com.altova.semanticworks.SemanticWorksRobot.OverviewTab;
import com.altova.util.ClipboardUtils;

public class EditMenuTest extends AbstractSemanticWorks {

	
	

	@Test
	public final void testUndo() {

		robot.openFile(ALTOVAMYCLASS_RDF_FILE.getAbsolutePath());
		
		robot.textView();
		
		robot.find();
		robot.findWindowDialog("myClass3");
		
		robot.typeString("newMyClass4");
		delay(1000);
		robot.undo();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS);
		
	}
	
	@Test
	public final void testRedo() {

		robot.openFile(ALTOVAMYCLASS_RDF_FILE.getAbsolutePath());
		
		robot.textView();
		
		robot.find();
		robot.findWindowDialog("myClass3");
		
		robot.typeString("newMyClass4");
		delay(1000);
		robot.undo();
		robot.redo();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS);

	}
	
	@Test
	public final void testFind() {
		
		robot.openFile(ALTOVAMYCLASS_RDF_FILE.getAbsolutePath());
		
		robot.textView();
		
		robot.find();
		robot.findWindowDialog("myClass3");
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS);
		
	}
	
	@Test
	public final void testFindNext() {
		
		robot.openFile(ALTOVAMYCLASS_RDF_FILE.getAbsolutePath());
		
		robot.textView();
		
		robot.find();
		robot.findWindowDialog("myClass");
		robot.findNext();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS);
		
	}
	
	@Test
	public final void testReplace() {
		
		robot.openFile(ALTOVAMYCLASS_RDF_FILE.getAbsolutePath());
		
		robot.textView();
		robot.replace("myClass", "myNewReplacedClass");
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS);
	}
	
	@Test
	public final void testDelete() {
		
		robot.openFile(ALTOVAMYCLASS_RDF_FILE.getAbsolutePath());
		
		robot.openDiagram("myClass1", OverviewTab.Classes);
		robot.delete();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testCut() {
		
		robot.openFile(ALTOVAMYCLASS_RDF_FILE.getAbsolutePath());
		
		robot.textView();
		robot.find();
		robot.findWindowDialog("urn:myClass1");
		robot.cut();
		
		robot.find();
		robot.findWindowDialog("urn:myClass3");
		
		robot.paste();
		
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS);
	}
	
	@Test
	public final void testCopy() {
		
		String textToCopy = "urn:myClass2";
		
		robot.openFile(ALTOVAMYCLASS_RDF_FILE.getAbsolutePath());
		
		robot.textView();
		robot.find();
		robot.findWindowDialog(textToCopy);
		robot.copy();
		
		String clipboard = ClipboardUtils.getClipboardContents();
		assertEquals(textToCopy, clipboard);
		
	}

	@Test
	public final void testPaste() {
		
		robot.openFile(ALTOVAMYCLASS_RDF_FILE.getAbsolutePath());
		
		robot.textView();
		robot.find();
		robot.findWindowDialog("urn:myClass1");
		robot.copy();
		
		robot.find();
		robot.findWindowDialog("urn:myClass3");
		
		robot.paste();
		
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS);
	}

	
	
}
