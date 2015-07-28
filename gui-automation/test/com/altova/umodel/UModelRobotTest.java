package com.altova.umodel;

import static com.altova.umodel.regression.gui.UModelRobot.*;
import static com.altova.umodel.regression.gui.UModelRobot.STYLES;
import static com.altova.umodel.regression.gui.UModelRobot.PROPERTIES;
import static com.altova.umodel.regression.gui.UModelRobot.DOCUMENTATION;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.EnumSet;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.ScriptMistakeException;
import com.altova.robots.Pane.PaneSize;
import com.altova.umodel.regression.gui.EclipseUModelRobot;
import com.altova.umodel.regression.gui.LayoutOperation;
import com.altova.umodel.regression.gui.UModelRobot;
import com.altova.umodel.regression.gui.VSnetUModelRobot;
import com.altova.umodel.regression.testcases.AbstractUmodelTest;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;
import com.altova.util.Settings.AltovaApplication;


/**
 * Internal test suite for most of the public methods in {@link UModelRobot}.
 * It does not test UModel, but instead check that none of the method in the
 * automation framework for UModel fails (and therefore there are no asserts
 * against expected images, etc).   
 * 
 * @author Havard Rast Blok
 *
 */
//@TestRobot(VSnetUModelRobot.class)
//@TestRobot(EclipseUModelRobot.class)
public class UModelRobotTest extends AbstractUmodelTest {

	@Test
	public final void testPutElementStringIntInt() {
		robot.openDiagram(COMPONENT_DIAGRAM);
		robot.putElement("Artifact", 800, 300);
	}
	
	
	@Test
	public final void testPutElementStringStringIntInt() {
		robot.openDiagram(COMPONENT_DIAGRAM);
		robot.putElement("Artifact", "test", 800, 300);
	}

	@Test
	public final void testGetElementLocation() {
		robot.getElementLocation(DEPLOYMENT_DIAGRAM_ARTIFACT);
	}

	@Test
	public final void testLeftClickElement() {
		robot.leftClickElement(DEPLOYMENT_DIAGRAM_ARTIFACT);
	}

	@Test
	@Ignore public final void testLinkElementsStringString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	@Ignore public final void testLinkElementsStringStringString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testNewRootElement() {
		robot.newRootElement("Class", "test");
	}

	@Test
	@Ignore public final void testNewElement() {
		fail("Not yet implemented"); // TODO
		robot.newElement("element", "parent", "name");
	}

	@Test
	public final void testNewDiagramString() {
		robot.newDiagram("Object");
	}

	@Test
	public final void testNewDiagramStringStringString() {
		robot.newDiagram("Deployment", "Deployment View", "test");
	}

	@Test
	public final void testOpenDiagram() {
		robot.openDiagram("Overview Account Balance");
	}
	
	@Test
	public final void testOpenDiagramDeployment() {
		robot.openDiagram(COMPONENT_DIAGRAM);
	}

	@Test
	public final void testCloseDiagram() {
		robot.openDiagram("Overview Account Balance");
		robot.delay(1000);
		robot.closeDiagram();
	}

	@Test
	public final void testSetActiveDiagram() {
		robot.newDiagram("Class");
		robot.closeDiagram();
		robot.setActiveDiagram("Class");
	}

	@Test
	public final void testNewPrj() {
		robot.newPrj();
	}

	@Test
	@IgnoreRobots(EclipseUModelRobot.class)
	public final void testSaveReplacePrj() {
		robot.saveReplacePrj("c:\\temp\\test\\myprj.ump");
	}

	@Test
	public final void testLoadPrj() {
		robot.newPrj();
		robot.openPrj(BANK_UMP);
	}

	@Test
	@IgnoreRobots({VSnetUModelRobot.class, EclipseUModelRobot.class})
	public final void testReloadProject() {
		robot.newDiagram("Class");
		robot.reloadProject();
	}

	@Test
	public final void testZoom() {
		robot.openDiagram(COMPONENT_DIAGRAM);
		robot.zoom(15);
	}

	@Test
	public final void testClickModelTreeItem() {
		robot.findModelTreeElement(DEPLOYMENT_DIAGRAM_ARTIFACT,true);
		robot.clickModelTreeItem("Home PC");
	}

	@Test
	public final void testExpandModelTreeNode() {
		robot.expandModelTreeNode("Deployment View");
	}

	@Test
	public final void testSetGridSize() {
		robot.setGridSize(20);
	}
	
	@Test
	public final void testSetModelTreeSizeNormal() {
	robot.setModelTreeSize(PaneSize.NORMAL);
	}
	

	@Test
	public final void testSetModelTreeSizeWide() {
	robot.setModelTreeSize(PaneSize.LARGE);
	}
	
	@Test
	public final void testSetModelTreeSizeSmall() {
	robot.setModelTreeSize(PaneSize.SMALL);
	}
	
	
	@Test
	public final void testSetModelTreeSize() {
		robot.setModelTreeSize("Tools");
	}

	@Test
	public final void testSetPaneSizePaneIntInt() {
		robot.setPaneSize(STYLES, 250, 250);
		
		robot.setPaneSize(MESSAGES, -1, 100);
		
		robot.setPaneSize(MESSAGES, -1, 300);
	}
	
	@Test
	public final void testSetModelTreeSizePaneSize() {
		robot.setModelTreeSize(PaneSize.WIDE);
	}
	
	@Test
	public final void testDialog() {
		robot.findDialog("Home PC");
	}

	@Test
	@IgnoreRobots({VSnetUModelRobot.class, EclipseUModelRobot.class})   //not relevant
	public final void testRemoveString() {
		robot.removeFindString();
	}

	@Test
	public final void testSnapShot() throws IOException {
		File out = robot.snapShot(MODEL_TREE, "model_tree");
		assertTrue(out.exists());
	}

	@Test
	public final void testAddProperty() {
		robot.addProperty(CLASS_DIAGRAM_CLASS, "test:String");
	}

	@Test
	public final void testAddOperation() {
		robot.addOperation(CLASS_DIAGRAM_CLASS, "getTest():String");
	}

	@Test
	public final void testAddClass() {
		robot.addClass(CLASS_DIAGRAM_CLASS, "TestClass");
	}

	@Test
	public final void testAddInternalElement() {
		robot.addInternalElement(CLASS_DIAGRAM_CLASS, "DataType", "myType");
	}

	@Test
	@Ignore public final void testAddOperationReturnValue() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testChangeMemberFieldProperty() {
		robot.changeMemberField(CLASS_DIAGRAM_CLASS, "IPaddress:String", "ip:int");
	}
	
	@Test
	public final void testChangeMemberFieldOperation() {
		robot.changeMemberField(CLASS_DIAGRAM_CLASS, "getBankName():String", "getMoney():int");
	}

	@Test
	public final void testDeleteMemberField() {
		robot.deleteMemberField(CLASS_DIAGRAM_CLASS, "getBankName():String");
	}

	@Test
	public final void testDeleteElement() {
		robot.deleteElement(CLASS_DIAGRAM_CLASS);
	}

	@Test
	@Ignore public final void testRenameClass() {
		fail("Not yet implemented"); // TODO
		robot.renameClass(CLASS_DIAGRAM_CLASS, "Bankers");
	}

	@Test
	public final void testRenameElement() {
		robot.renameElement(CLASS_DIAGRAM_CLASS, "Bankers");
	}

	@Test
	public final void testSetModifier() {
		robot.setModifier(CLASS_DIAGRAM_CLASS, "abstract", "true");
	}

	@Test
	public final void testSelect() {
		robot.select(CLASS_DIAGRAM_CLASS);
	}

	@Test
	public final void testDeselectAll() {
		robot.select(CLASS_DIAGRAM_CLASS);
		robot.deselectAll();
	}

	@Test
	public final void testSelectModelTreeElement() {
		robot.findModelTreeElement(CLASS_DIAGRAM_CLASS,true);
	}

	@Test
	public final void testFindDiagramElement() {
		robot.findDiagramElement(CLASS_DIAGRAM_CLASS,true);
	}
	
	@Test
	public final void testFindModelTreeElement() {
		robot.findModelTreeElement("Design View::BankView::com::altova::bankview::BankView",true);
		assertNotNull( robot.getPaneValueImage(PROPERTIES, "abstract") );
	}
	
	@Test
	//@IgnoreRobots(VSnetUModelRobot.class)//deleting a diagram is currently crashing in VS.net //should be fixed now 
	public final void testDropElementOnDiagram() {
		Rectangle r = robot.findModelTreeElement("Hierarchy of Account",false);
		robot.leftClickMid(r);
		robot.delete();
		robot.openDiagram("BankView Main");
		robot.dropElementOnDiagram("Design View::BankView::com::altova::bankview::Account", new Point(500, 500));
	}

	@Test
	public final void testScrollPaneRowSplitter() {
		robot.scrollPaneRowSplitter(STYLES, 0.6);
	}

	@Test
	public final void testSyntaxCheck() {
		robot.syntaxCheck();
	}

	@Test
	public final void testLeftClickStringRectangle() {
		robot.leftClick("ID_FILE_NEW", new Rectangle(0, 0, 800, 50),true);
	}
	
	@Test
	public final void testGetIconResource() {
		assertNotNull( robot.getIconResource("ID_FILE_OPEN") );
	}
	
	@Test
	public final void testGetIconResource1() {
		robot.leftClick("IDC_BPMN_START_EVENT");
		
	}
	
	@Test
	@IgnoreRobots(EclipseUModelRobot.class)
	public final void testFindComponentName() {
		robot.activatePane(UModelRobot.OVERVIEW);
		assertNotNull( robot.findComponentName("Overview") );
	}

	@Test
	@IgnoreRobots(EclipseUModelRobot.class)
	public final void testFindComponentClass() {
		assertNotNull( robot.findComponentClass("BCGSlider") );
	}

	@Test(expected=ScriptMistakeException.class)
	@Ignore
	public final void testFindComponentClassBCGControlBar() {
		robot.findComponentClass("BCGControlBar");
	}
	
	@Test
	@IgnoreRobots({VSnetUModelRobot.class, EclipseUModelRobot.class}) //not relevant
	public final void testFindComponentStringStringNull() {
		robot.activatePane(DIAGRAM_TREE);

		assertNotNull( "Trying to find text+class name, without hint/constraint",
						robot.findComponent("Diagram Tree", "BCGControlBar", null));
		
		assertNull( "Should not find text with wrong class name, without hint/constraint", 
					robot.findComponent("Diagram Tree", "aaaaaaaaaa", null));
		
		assertNull( "Should not find wrong text with class name, without hint/constraint", 
					robot.findComponent("cccccccccccc", "BCGControlBar", null));
	}
	
	@Test
	@IgnoreRobots({VSnetUModelRobot.class, EclipseUModelRobot.class}) //not relevant
	public final void testFindComponentStringStringRectangle() {
		robot.activatePane(DIAGRAM_TREE);
		
		assertNotNull( "Trying to find text+class name, with hint/constraint",
						robot.findComponent("Diagram Tree", "BCGControlBar", new Rectangle(0, 0, 500, 800)));
		
		assertNull(	"Should not find text with wrong class name, with hint/constraint", 
					robot.findComponent("Diagram Tree", "bbbbbbbbbbb", new Rectangle(0, 0, 500, 800)));
	}

	@Test
	@IgnoreRobots({VSnetUModelRobot.class, EclipseUModelRobot.class})   //not relevant
	public final void testFindComponents() {
		robot.activatePane(DIAGRAM_TREE);
		
		List<Rectangle> l = robot.findComponents("Diagram Tree", "BCGControlBar", new Rectangle(0, 0, 500, 800));
		assertTrue( "Trying to find text+class name, with hint/constraint", l.size() > 0);
	}

	@Test
	public final void testLeftClickMenuItem() {
		robot.leftClickMenuItem("File", "Reload");
		
		robot.leftClickMenuItem("View", "Favorites & Model Tree", "Sort", "no sort");
	}

	@Test
	public final void testSetPaneValue() {
		robot.setPaneValue(STYLES, "AutoSize" , "false");
	}
	
	@Test
	public final void testSetPaneValue2() {
		//from tutorial test
		robot.openPrj(new File(AltovaApplication.UMODEL.getExamplesLocation(), "Tutorial/BankView-start.ump").getAbsolutePath());
		//include/exclude components from code generation
		robot.findModelTreeElement("Component View::Banking access::Bank API client",false);
		robot.setPaneValue(PROPERTIES, "use for code engineering", " " );
	}


	@Test
	public final void testGetPaneValueImage() {
		assertNotNull( robot.getPaneValueImage(STYLES, "SC Type") );
	}

	@Test
	public final void testActivatePane() {
		robot.delay(2000);
		robot.activatePane(MODEL_TREE);
		robot.activatePane(DIAGRAM_TREE);
		robot.activatePane(FAVORITES);
		robot.activatePane(PROPERTIES);
		robot.activatePane(STYLES);
		robot.activatePane(OVERVIEW);
		robot.activatePane(MESSAGES);
	}

	@Test
	public final void testScrollPane() {
		robot.scrollPane(STYLES, 0.1);
		robot.scrollPane(STYLES, 0.5);
		robot.scrollPane(STYLES, 0.1);
	}

	@Test
	public final void testMaximizeWindow() {
		robot.maximizeWindow();
	}

	@Test
	@IgnoreRobots({VSnetUModelRobot.class, EclipseUModelRobot.class})   //not relevant
	public final void testGetAppName() {
		assertEquals("Altova UModel", robot.getAppName());
	}
	
	@Test
	public final void testLayoutWidth() {
		robot.openDiagram("BankView Main");
		robot.selectAll();
		robot.layout(LayoutOperation.SAME_SIZE_WIDTH);
	}
	
	@Test
	public final void testLayout() {
		robot.openDiagram("BankView Main");
		robot.selectAll();
		for(LayoutOperation op : EnumSet.allOf(LayoutOperation.class)) {
			robot.layout(op);
		}
	}
	
	@Test
	public final void testActivatePaneDocumentation() {
		robot.activatePane(DOCUMENTATION);
	}

	@Test
	public final void testCheckMessageWindow() {
		robot.listIncludedPackages();
		robot.checkMessageWindow();
		
		robot.clearMessages();
		robot.checkMessageWindow();
	}	

	@Test
	@Ignore
	public final void testUnzipOrgChart() {
		robot.unzipOrgChart();
	}
	
	@Test
	public final void testExitApplication(){
		robot.exitWithuotSave();
	}
	
}
