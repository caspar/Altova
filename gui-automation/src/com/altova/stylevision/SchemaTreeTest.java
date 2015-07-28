package com.altova.stylevision;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;
import static com.altova.stylevision.StyleVisionRobot.*;
import static com.altova.util.LoggerUtils.logger;


import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.altova.robots.CheckboxOption;
import com.altova.stylevision.StyleVisionRobot.View;
import com.altova.util.IOUtils;
import com.altova.util.XMLFileReader;


public class SchemaTreeTest extends AbstractStyleVisionTest {
	private static final XMLFileReader myxml = new XMLFileReader("data\\stylevision\\guiautomation_catalog.xml");
	private static final String xInputfile[]=myxml.getAllValueOfNode("test:test-case","test:input-file");
	private static final String xdescription[]=myxml.getAllValueOfNode("test:test-case","test:description");
	private static final String xTestdir[]=myxml.getAllValueOfNode("test:test-case","test:basefile");
	private static final String xfurtherfiles[]=myxml.getAllValueOfNode("test:test-case","test:furtherfiles");
		
	//protected static final File MY_OrgchartSPS=IOUtils.findFile(MY_Orgchart_Path+"Orgchart.sps");
	//protected static final String MY_OrgchartSPS_FILE=MY_OrgchartSPS.getAbsolutePath();
	
	/**
	 * Schematree
	 * Catalog: guiautomation_catalog.xml
	 * 
	 * special cases to check schema load and schematree building 
	 * catalog file index i=51 to 59
	 * 
	 */
	@BeforeClass
	public static void doBeforeClass(){
		robot.activatePane(SCHEMATREE);
		robot.setPaneSize(SCHEMATREE, 400, 700);
		CheckboxOption option = new CheckboxOption("Sort attributes", false,
				"Schema tree options", null, null, "Schema",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		option = new CheckboxOption("Sort elements", false,
				"Schema tree options", null, null, "Schema",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		option = new CheckboxOption("Sort types", false,
				"Schema tree options", null, null, "Schema",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
	}
	
	@AfterClass
	public static void doAfterClass(){
		robot.setPaneSize(SCHEMATREE, 200, 372);
		CheckboxOption option = new CheckboxOption("Sort attributes", true,
				"Schema tree options", null, null, "Schema",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		option = new CheckboxOption("Sort elements", false,
				"Schema tree options", null, null, "Schema",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		option = new CheckboxOption("Sort types", true,
				"Schema tree options", null, null, "Schema",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
	}
	
	//int i=48;   check schematree of i=48
	@Test
	public void test17261_schematree(){
		int i=48;
		//String filename=xTestdir[i]+xInputfile[i];
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(filename);delay(2000);
		robot.maximizeFileWindow();
		robot.expandElement("Sources", "Expand All");delay(500);
		assertAreas(SCHEMATREE);
	}
	
	@Test
	public void  test_51(){
		int i=51;
		//String filename=xTestdir[i]+xInputfile[i];
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.newSPS("New from XML Schema");
		robot.typeStringEnter(filename);delay(500);
		robot.keyType(KeyEvent.VK_S);delay(500);   //Skip - don't assign a Working XML
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.keyType(KeyEvent.VK_ESCAPE);delay(2000);   //don't select root element
		robot.maximizeFileWindow();
		robot.expandElement("Sources", "Expand All");delay(500);
		assertAreas(SCHEMATREE);
	}
	
	@Test
	public void  test_52_attribute(){
		int i=52;
		//String filename=xTestdir[i]+xInputfile[i];
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.newSPS("New from XML Schema");
		robot.typeStringEnter(filename);delay(500);
		robot.keyType(KeyEvent.VK_S);delay(500);   //Skip - don't assign a Working XML
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.keyType(KeyEvent.VK_ESCAPE);delay(2000);   //don't select root element
		robot.maximizeFileWindow();
		robot.expandElement("Sources", "Expand All");delay(500);
		assertAreas(SCHEMATREE);
	}
	
	@Test
	public void  test_53_attributeGroup(){
		int i=53;
		//String filename=xTestdir[i]+xInputfile[i];
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.newSPS("New from XML Schema");
		robot.typeStringEnter(filename);delay(500);
		robot.keyType(KeyEvent.VK_S);delay(500);   //Skip - don't assign a Working XML
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.keyType(KeyEvent.VK_ESCAPE);delay(2000);   //don't select root element
		robot.maximizeFileWindow();
		robot.expandElement("Sources", "Expand All");delay(500);
		assertAreas(SCHEMATREE);
	}
	
	@Test
	public void  test_54_CalsTable(){
		int i=54;
		//String filename=xTestdir[i]+xInputfile[i];
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		//String instancefname=xTestdir[i]+xfurtherfiles[i];
		MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xfurtherfiles[i]);
		String instancefname=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.newSPS("New from XML Schema");
		robot.typeStringEnter(filename);delay(500);
		robot.keyType(KeyEvent.VK_B);delay(500);   //Browse - assign a Working XML
		robot.typeStringEnter(instancefname);delay(500);
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.maximizeFileWindow();
		robot.expandElement("Sources", "Expand All");delay(500);
		assertAreas(SCHEMATREE);
	}
	
	@Test
	public void  test_55_Choice(){
		int i=55;
		//String filename=xTestdir[i]+xInputfile[i];
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		//String instancefname=xTestdir[i]+xfurtherfiles[i];
		MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xfurtherfiles[i]);
		String instancefname=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.newSPS("New from XML Schema");
		robot.typeStringEnter(filename);delay(500);
		robot.keyType(KeyEvent.VK_B);delay(500);   //Browse - assign a Working XML
		robot.typeStringEnter(instancefname);delay(500);
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.maximizeFileWindow();
		robot.expandElement("Sources", "Expand All");delay(500);
		assertAreas(SCHEMATREE);
	}
	
	@Test
	public void  test_56_complexType(){
		int i=56;
		//String filename=xTestdir[i]+xInputfile[i];
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.newSPS("New from XML Schema");
		robot.typeStringEnter(filename);delay(500);
		robot.keyType(KeyEvent.VK_S);delay(500);   //Skip - don't assign a Working XML
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.keyType(KeyEvent.VK_ESCAPE);delay(2000);   //don't select root element
		robot.maximizeFileWindow();
		robot.expandElement("Sources", "Expand All");delay(500);
		assertAreas(SCHEMATREE);
	}
	
	@Test
	public void  test_57_Contstraints(){
		int i=57;
		//String filename=xTestdir[i]+xInputfile[i];
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.newSPS("New from XML Schema");
		robot.typeStringEnter(filename);delay(500);
		robot.keyType(KeyEvent.VK_S);delay(500);   //Skip - don't assign a Working XML
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.keyType(KeyEvent.VK_ESCAPE);delay(2000);   //don't select root element
		robot.maximizeFileWindow();
		robot.expandElement("Sources", "Expand All");delay(500);
		assertAreas(SCHEMATREE);
	}
	
	@Test
	public void  test_58_dtd(){
		int i=58;
		//String filename=xTestdir[i]+xInputfile[i];
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		//String instancefname=xTestdir[i]+xfurtherfiles[i];
		MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xfurtherfiles[i]);
		String instancefname=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.newSPS("New from XML Schema");
		robot.typeStringEnter(filename);delay(500);
		robot.keyType(KeyEvent.VK_B);delay(500);   //Browse - assign a Working XML
		robot.typeStringEnter(instancefname);delay(500);
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.maximizeFileWindow();
		robot.expandElement("Sources", "Expand All");delay(500);
		assertAreas(SCHEMATREE);
	}
	
	@Test
	public void  test_59_encoding(){
		int i=59;
		//String filename=xTestdir[i]+xInputfile[i];
		File MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xInputfile[i]);
		String filename=MY_TestCase_File.getAbsolutePath();
		//String instancefname=xTestdir[i]+xfurtherfiles[i];
		MY_TestCase_File=IOUtils.findFile(xTestdir[i]+xfurtherfiles[i]);
		String instancefname=MY_TestCase_File.getAbsolutePath();
		logger.fine("TCASE: "+xdescription[i]);
		robot.newSPS("New from XML Schema");
		robot.typeStringEnter(filename);delay(500);
		robot.keyType(KeyEvent.VK_B);delay(500);   //Browse - assign a Working XML
		robot.typeStringEnter(instancefname);delay(500);
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.maximizeFileWindow();
		robot.expandElement("Sources", "Expand All");delay(500);
		assertAreas(SCHEMATREE);
	}
}