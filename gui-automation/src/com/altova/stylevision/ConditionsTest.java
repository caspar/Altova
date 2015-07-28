package com.altova.stylevision;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.util.LoggerUtils.logger;
import static com.altova.stylevision.Tag.*;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Test;

import com.altova.stylevision.StyleVisionRobot.View;
import com.altova.util.IOUtils;
import com.altova.util.XMLFileReader;


public class ConditionsTest extends AbstractStyleVisionTest {
//	private static final XMLFileReader myxml = new XMLFileReader("data\\stylevision\\guiautomation_catalog.xml");
//	private static final String xInputfile[]=myxml.getAllValueOfNode("test:test-case","test:input-file");
//	private static final String xbasefile[]=myxml.getAllValueOfNode("test:test-case","test:basefile");
//	private static final String xdescription[]=myxml.getAllValueOfNode("test:test-case","test:description");
//	private static final String keystring="@!&/()=?ביüצה";
	
	private static final File MY_TestCase_File=IOUtils.findFile("data/stylevision/tdata/orgchart/orgchart.sps");
	private static final String My_sps_file=MY_TestCase_File.getAbsolutePath();

	private static final File MY_TestCase_File2=IOUtils.findFile("data/stylevision/tdata/orgchart/orgchart.xml");
	private static final String My_xml_file=MY_TestCase_File2.getAbsolutePath();
	private static final String condition1="n1:OrgChart/n1:Office/n1:Location='US'";
	private static final String condition2="n1:OrgChart/n1:Office/n1:Location='EU'";

	
	@Test
	public void createnewcondition(){
		logger.fine("TCASE: createnewcondition");
		robot.newSPS("New from XML Schema");
		robot.typeFileName(My_xml_file);
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.maximizeFileWindow(true);
		robot.newcondition(condition1);
		robot.keyType(KeyEvent.VK_RIGHT);robot.keyType(KeyEvent.VK_LEFT);delay(500); //put cursor inside condition
		robot.typeString(condition1);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void createnewconditionnewbrunch(){
		logger.fine("TCASE: createnewconditionnewbrunch");
		robot.newSPS("New from XML Schema");
		robot.typeFileName(My_xml_file);
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.maximizeFileWindow();
		robot.newcondition(condition1);
		robot.keyType(KeyEvent.VK_RIGHT);robot.keyType(KeyEvent.VK_LEFT);delay(500); //put cursor inside condition
		robot.typeString(condition1);
		robot.setView(View.BRUNCH1);  //select brunch1 Icon
		robot.selectContextMenuItem("Add New Branch");
		robot.typeString(condition2);delay(500);
		robot.leftClickButton("OK");delay(500); //confirm XPath window
		robot.keyType(KeyEvent.VK_RIGHT);delay(500); //put cursor inside condition
		robot.typeString(condition2);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void createnewconditionnewbrunchotherwise(){
		logger.fine("TCASE: createnewconditionnewbrunchotherwise");
		robot.newSPS("New from XML Schema");
		robot.typeFileName(My_xml_file);
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.maximizeFileWindow();
		robot.newcondition(condition1);
		robot.keyType(KeyEvent.VK_RIGHT);robot.keyType(KeyEvent.VK_LEFT);delay(500); //put cursor inside condition
		robot.typeString(condition1);
		robot.setView(View.BRUNCH1);  //select brunch1 Icon
		robot.selectContextMenuItem("Add New Branch");
		robot.setView(View.OPTION_CHECKBOX);
		//robot.typeString(condition2);delay(500);
		robot.leftClickButton("OK");delay(500); //confirm XPath window
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void createnewconditioncopybrunch(){
		logger.fine("TCASE: createnewconditioncopybrunch");
		robot.newSPS("New from XML Schema");
		robot.typeFileName(My_xml_file);
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.maximizeFileWindow();
		robot.newcondition(condition1);
		robot.keyType(KeyEvent.VK_RIGHT);robot.keyType(KeyEvent.VK_LEFT);delay(500); //put cursor inside condition
		robot.typeString(condition1);
		robot.setView(View.BRUNCH1);  //select brunch1 Icon
		robot.selectContextMenuItem("Copy Branch");
		robot.leftClickButton("OK");delay(500); //confirm XPath window
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void createnewconditiondeletebrunch(){
		logger.fine("TCASE: createnewconditiondeletebrunch");
		robot.newSPS("New from XML Schema");
		robot.typeFileName(My_xml_file);
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.maximizeFileWindow();
		robot.newcondition(condition1);
		robot.keyType(KeyEvent.VK_RIGHT);robot.keyType(KeyEvent.VK_LEFT);delay(500); //put cursor inside condition
		robot.typeString(condition1);
		robot.setView(View.BRUNCH1);  //select brunch1 Icon
		robot.selectContextMenuItem("Add New Branch");
		robot.typeString(condition2);delay(500);
		robot.leftClickButton("OK");delay(500); //confirm XPath window
		robot.keyType(KeyEvent.VK_RIGHT);delay(500); //put cursor inside condition
		robot.typeString(condition2);
		robot.findElement("1",DBLB);//select brunch1 Icon
		robot.selectContextMenuItem("Delete Branch");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void showallBranches(){
		logger.fine("TCASE: showallbanches");
		robot.newSPS("New from XML Schema");
		robot.typeFileName(My_xml_file);
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.maximizeFileWindow();
		robot.newcondition(condition1);
		robot.keyType(KeyEvent.VK_RIGHT);robot.keyType(KeyEvent.VK_LEFT);delay(500); //put cursor inside condition
		robot.typeString(condition1);
		robot.setView(View.BRUNCH1);  //select brunch1 Icon
		robot.selectContextMenuItem("Add New Branch");
		robot.typeString(condition2);delay(500);
		robot.leftClickButton("OK");delay(500); //confirm XPath window
		robot.keyType(KeyEvent.VK_RIGHT);delay(500); //put cursor inside condition
		robot.typeString(condition2);
		robot.findElement("1",DBLB);//select brunch1 Icon
		robot.selectContextMenuItem("Copy Branch");
		robot.leftClickButton("OK");delay(500); //confirm XPath window
		robot.findElement("1",DBLB);//select brunch1 Icon
		robot.selectContextMenuItem("Display All Branches");delay(500);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void moveBranchup(){
		logger.fine("TCASE: moveBranchup");
		robot.newSPS("New from XML Schema");
		robot.typeFileName(My_xml_file);
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.maximizeFileWindow();
		robot.newcondition(condition1);
		robot.keyType(KeyEvent.VK_RIGHT);robot.keyType(KeyEvent.VK_LEFT);delay(500); //put cursor inside condition
		robot.typeString(condition1);
		robot.setView(View.BRUNCH1);  //select brunch1 Icon
		robot.selectContextMenuItem("Add New Branch");
		robot.typeString(condition2);delay(500);
		robot.leftClickButton("OK");delay(500); //confirm XPath window
		robot.keyType(KeyEvent.VK_RIGHT);delay(500); //put cursor inside condition
		robot.typeString(condition2);
		robot.findElement("1",DBLB);//select brunch1 Icon
		robot.findElement("2",DBLB);//select brunch2 Icon
		robot.selectContextMenuItem("Move Branch Up");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	@Test
	public void moveBranchdown(){
		logger.fine("TCASE: moveBranchdown");
		robot.newSPS("New from XML Schema");
		robot.typeFileName(My_xml_file);
		robot.leftClickButton("OK");delay(500);//press Ok for new empty design
		robot.maximizeFileWindow();
		robot.newcondition(condition1);
		robot.keyType(KeyEvent.VK_RIGHT);robot.keyType(KeyEvent.VK_LEFT);delay(500); //put cursor inside condition
		robot.typeString(condition1);
		robot.setView(View.BRUNCH1);  //select brunch1 Icon
		robot.selectContextMenuItem("Add New Branch");
		robot.typeString(condition2);delay(500);
		robot.leftClickButton("OK");delay(500); //confirm XPath window
		robot.keyType(KeyEvent.VK_RIGHT);delay(500); //put cursor inside condition
		robot.typeString(condition2);
		robot.findElement("1",DBLB);//select brunch1 Icon
		robot.selectContextMenuItem("Move Branch Down");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

}