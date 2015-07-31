/**
 * 
 */
package com.altova.mapforce;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import static com.altova.util.LoggerUtils.logger;
import static com.altova.robots.SnapshotArea.CommonArea.MF_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;
import static com.altova.robots.ImageRecognitionRobot.WINDOWS_DEFAULT_FONT;


import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.Options;
import com.altova.robots.RadioOption;
import com.altova.util.IOUtils;

/**
 * @author b.lopez
 *
 */

//@TestRobot(VSnetMapForceRobot.class)
public class ConnectionMenuTest extends AbstractMapForceTest {

	private final String CUSTOMERSTARGET1_COMPONENT = IOUtils.findFile("tags_list/CUSTOMERSTARGET1_XSD_TAG.PNG").getAbsolutePath();
	private final File CONNECTION_TEST1_MFD=IOUtils.findFile("examples/ConnectionTests1.mfd");
	private final File CONNECTION_TEST2_MFD=IOUtils.findFile("examples/ConnectionTests2.mfd");
	
	private final String INSPECTIONREPORT_COMPONENT=IOUtils.findFile("tags_list/INSPECTIONREPORT_TAG.PNG").getAbsolutePath();
	private final String MIXATTSANDELEMS_COMPONENT=IOUtils.findFile("tags_list/MIXATTSANDELEMS_TAG.PNG").getAbsolutePath();
	private final String ALTOVADB1_COMPONENT=IOUtils.findFile("tags_list/ALTOVA1_DB_TAG.PNG").getAbsolutePath();
	
	
	@Test
	public void testAutoConnectMatchingChildren_Off(){
		robot.openFile(CONNECTION_TEST1_MFD);
		robot.autoconnectMatchingChildren();
		Rectangle alt_comp=robot.selectComponentFromImage(ALTOVADB1_COMPONENT);
		Rectangle r1=new Rectangle(alt_comp.x+alt_comp.width, alt_comp.y+alt_comp.height+5,10,10);
		Rectangle custTarg_comp=robot.selectComponentFromImage(CUSTOMERSTARGET1_COMPONENT);
		Rectangle r2=new Rectangle(custTarg_comp.x+(int)(0.5*custTarg_comp.width),custTarg_comp.y+custTarg_comp.height+5,10,10);
		robot.dragDropMid(r1, r2);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testAutoConnectMatchingChildren_On(){
		robot.openFile(CONNECTION_TEST1_MFD);
		robot.autoconnectMatchingChildren();
		Rectangle alt_comp=robot.selectComponentFromImage(ALTOVADB1_COMPONENT);
		Rectangle r1=new Rectangle(alt_comp.x+alt_comp.width, alt_comp.y+alt_comp.height+5,10,10);
		Rectangle custTarg_comp=robot.selectComponentFromImage(CUSTOMERSTARGET1_COMPONENT);
		Rectangle r2=new Rectangle(custTarg_comp.x+(int)(0.5*custTarg_comp.width),custTarg_comp.y+custTarg_comp.height+5,10,10);
		robot.dragDropMid(r1, r2);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testAutoConnectSettings_IgnoreCaseOn_Overwrite(){
		robot.openFile(CONNECTION_TEST1_MFD);
		Options options=new Options();
		options.add(new CheckboxOption("Ignore Case",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new RadioOption("Overwrite",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.autoConnectSettings(options);
		Rectangle alt_comp=robot.selectComponentFromImage(ALTOVADB1_COMPONENT);
		Rectangle r1=new Rectangle(alt_comp.x+alt_comp.width, alt_comp.y+alt_comp.height+5,10,10);
		Rectangle custTarg_comp=robot.selectComponentFromImage(CUSTOMERSTARGET1_COMPONENT);
		Rectangle r2=new Rectangle(custTarg_comp.x+(int)(0.5*custTarg_comp.width),custTarg_comp.y+custTarg_comp.height+5,10,10);
		robot.dragDropMid(r1, r2);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testAutoConnectSettings_DeleteAll_MixAttsElemOff(){
		robot.openFile(CONNECTION_TEST2_MFD);
		Options options=new Options();
		options.add(new RadioOption("Delete all existing",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Mix Attributes and Elements",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.autoConnectSettings(options);
		Rectangle alt_comp=robot.selectComponentFromImage(INSPECTIONREPORT_COMPONENT);
		Rectangle r1=new Rectangle(alt_comp.x+10, alt_comp.y+alt_comp.height+5,10,10);
		Rectangle custTarg_comp=robot.selectComponentFromImage(MIXATTSANDELEMS_COMPONENT);
		Rectangle r2=new Rectangle(custTarg_comp.x+10,custTarg_comp.y+custTarg_comp.height+5,10,10);
		robot.dragDropMid(r1, r2);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testAutoConnectSettings_MixAttsElemOn_IgnoreNamespacesOff(){
		robot.openFile(CONNECTION_TEST2_MFD);
		Options options=new Options();
		options.add(new CheckboxOption("Ignore Namespaces",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Mix Attributes and Elements",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.autoConnectSettings(options);
		Rectangle alt_comp=robot.selectComponentFromImage(INSPECTIONREPORT_COMPONENT);
		Rectangle r1=new Rectangle(alt_comp.x+10, alt_comp.y+alt_comp.height+5,10,10);
		Rectangle custTarg_comp=robot.selectComponentFromImage(MIXATTSANDELEMS_COMPONENT);
		Rectangle r2=new Rectangle(custTarg_comp.x+(int)(0.5*custTarg_comp.width),custTarg_comp.y+custTarg_comp.height+5,10,10);
		robot.dragDropMid(r1, r2);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testAutoConnectSettings_IgnoreNamespacesOn_IgnoreOutputsOff(){
		robot.openFile(CONNECTION_TEST2_MFD);
		Options options=new Options();
		options.add(new CheckboxOption("Ignore Namespaces",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Ignore existing output connections",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.autoConnectSettings(options);
		Rectangle alt_comp=robot.selectComponentFromImage(INSPECTIONREPORT_COMPONENT);
		Rectangle r1=new Rectangle(alt_comp.x+10, alt_comp.y+alt_comp.height+5,10,10);
		Rectangle custTarg_comp=robot.selectComponentFromImage(MIXATTSANDELEMS_COMPONENT);
		Rectangle r2=new Rectangle(custTarg_comp.x+(int)(0.5*custTarg_comp.width),custTarg_comp.y+custTarg_comp.height+5,10,10);
		robot.dragDropMid(r1, r2);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testAutoConnectSettings_IgnoreOutputsOn_RecursiveOn(){
		robot.openFile(CONNECTION_TEST3_MFD);
		Options options=new Options();
		options.add(new CheckboxOption("Recursive",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Ignore existing output connections",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.autoConnectSettings(options);
		Rectangle alt_comp=robot.selectComponentFromImage(MIXATTSANDELEMS3_COMPONENT);
		Rectangle r1=new Rectangle(alt_comp.x+20, alt_comp.y+2*alt_comp.height+5,10,10);
		Rectangle custTarg_comp=robot.selectComponentFromImage(MIXATTSANDELEMSOUT_COMPONENT);
		Rectangle r2=new Rectangle(custTarg_comp.x+(int)(0.5*custTarg_comp.width),custTarg_comp.y+2*custTarg_comp.height+5,10,10);
		robot.dragDropMid(r1, r2);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public void testAutoConnectSettings_RecursiveOff(){
		robot.openFile(CONNECTION_TEST3_MFD);
		Options options=new Options();
		options.add(new CheckboxOption("Recursive",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.autoConnectSettings(options);
		Rectangle alt_comp=robot.selectComponentFromImage(MIXATTSANDELEMS3_COMPONENT);
		Rectangle r1=new Rectangle(alt_comp.x+20, alt_comp.y+2*alt_comp.height+5,10,10);
		Rectangle custTarg_comp=robot.selectComponentFromImage(MIXATTSANDELEMSOUT_COMPONENT);
		Rectangle r2=new Rectangle(custTarg_comp.x+(int)(0.5*custTarg_comp.width),custTarg_comp.y+2*custTarg_comp.height+5,10,10);
		robot.dragDropMid(r1, r2);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
}
