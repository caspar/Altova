package com.altova.stylevision;

import java.awt.Point;
import java.awt.event.KeyEvent;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.robots.ScriptMistakeException;
import com.altova.robots.SnapshotArea;

import com.altova.util.XMLFileReader;
import static com.altova.stylevision.StyleVisionRobot.*;
import com.altova.stylevision.StyleVisionRobot.View;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import static com.altova.stylevision.Position.BEFORE;
import static com.altova.stylevision.Tag.PEACH;

import static com.altova.stylevision.TagType.START;
import static java.awt.event.KeyEvent.*;

public class StylevisionViewSwitchTest extends AbstractJUnitTest {
	
	protected static StyleVisionRobot robot;
	private static final XMLFileReader myxml = new XMLFileReader("test\\com\\altova\\stylevision\\testsuite1.xml");
	private static final String xSpsfile[]=myxml.getAllValueOfNode("tcase","spsfile");
	
	private static final String xName[]=myxml.getAllValueOfNode("tcase","name");
	
	private static final String xTestdir[]=myxml.getAllValueOfNode("tcase","testdir");
	private static final String xDesignflag[]=myxml.getAllValueOfNode("tcase","design");
	private static final String xAuthenticflag[]=myxml.getAllValueOfNode("tcase","authentic");
	
	private static final String xEditelement[]=myxml.getAllValueOfNode("tcase","editelement");
	private static final String xEditelementtext[]=myxml.getAllValueOfNode("tcase","editelementtext");

	private static final String xSchemafile[]=myxml.getAllValueOfNode("tcase","schemafile");
	private static final String xWorkingxml[]=myxml.getAllValueOfNode("tcase","workingxml");
	private static final String xTemplatexml[]=myxml.getAllValueOfNode("tcase","templatexml");
	
	String failure = null;
	String error= null;
	NodeList nodes ;
	
	Node l ;
	int testNumber ;
	/*
	public StylevisionCollectionTest( NodeList n, int j ) {
		testNumber = j;
		nodes = n;
	}
		*/	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new StyleVisionRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		
	}
	/*
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		try {
			robot.closeAll();
		} catch(ScriptMistakeException e) {
			logger.fine("Could not close files - probably none open: "+e);
		}
	}
	*/
	
	/*
	public StylevisionCollectionTest() {
		test1();
	}
	*/
	
	/*
	@Test
	public void test(){
		//for (int i = 0; i < xSpsfile.length; i++) {
		for (int i = 0; i < 1; i++) {
			testcase(i);
			
		}
	}
	*/
	
	@Test
	public void testid0(){
			testcase(0);
	}
	@Test
	public void testid1(){
			testcase(1);
	}
	@Test
	public void testid2(){
			testcase(2);
	}
	@Test
	public void testid3(){
			testcase(3);
	}
	@Test
	public void testid4(){
			testcase(4);
	}
	@Test
	public void testid5(){
			testcase(5);
	}
	@Test
	public void testid6(){
			testcase(6);
	}
	@Test
	public void testid7(){
			testcase(7);
	}
	@Test
	public void testid8(){
			testcase(8);
	}
	@Test
	public void testid9(){
			testcase(9);
	}
	@Test
	public void testid10(){
			testcase(10);
	}
	@Test
	public void testid11(){
			testcase(11);
	}
	@Test
	public void testid12(){
			testcase(12);
	}
	@Test
	public void testid13(){
			testcase(13);
	}
	@Test
	public void testid14(){
			testcase(14);
	}
	@Test
	public void testid15(){
			testcase(15);
	}
	@Test
	public void testid16(){
			testcase(16);
	}
	@Test
	public void testid17(){
			testcase(17);
	}
	@Test
	public void testid18(){
			testcase(18);
	}
	@Test
	public void testid19(){
			testcase(19);
	}
	@Test
	public void testid20(){
			testcase(20);
	}
	@Test
	public void testid21(){
			testcase(21);
	}
	@Test
	public void testid22(){
			testcase(22);
	}
	
	
	//@Test
	public void testcase(int j){
		
		//for (int j = 0; j < xSpsfile.length; j++) {
		//for (int j = 0; j < 1; j++) {
			//load either SPS file or create new one 
			if (xSpsfile[j]!=""){
				robot.openFile(xTestdir[j]+xSpsfile[j]);
				//assertiontest("openfile", j,DESIGNOVERVIEW);
				//Press Escape to close possibly raised msg window
				robot.keyType(KeyEvent.VK_ESCAPE);delay(2000);
				robot.maximizeFileWindow();

			}
			else {
				robot.newSPS("empty");
				robot.delay(2000);
				robot.maximizeFileWindow();
				//assertiontest("newemptyfile", j,DESIGNOVERVIEW);
			}
			if (xSchemafile[j]!=""){
				robot.addSchema(xTestdir[j]+xSchemafile[j]);
				//assertiontest("addschema", j,DESIGNOVERVIEW);
			}
			if (xWorkingxml[j]!=""){
				robot.assigningWorkingXML(xTestdir[j]+xWorkingxml[j]);
				//assertiontest("assignwxml", j,DESIGNOVERVIEW);
			}
			if (xTemplatexml[j]!=""){
				robot.assigningTemplateXML(xTestdir[j]+xTemplatexml[j]);
				//assertiontest("assigntxml", j,DESIGNOVERVIEW);
				}
			// Design View Test
			if (xDesignflag[j]!=""){
				Point to = new Point(300, 160);
				robot.insertElement(xDesignflag[j], to);
				robot.delay(500);
			}
			// Authentic View Edit test
			if (xAuthenticflag[j]!="") {
				robot.setView(View.AUTHENTIC);
				robot.delay(500);
				robot.showLargeMarkup();
				//assertiontest("showLargeMarkups", j,DIAGRAM_MAIN_WINDOW);
				Tag myTag = new Tag(xEditelement[j], PEACH, START);
				robot.insertText(xEditelementtext[j],myTag, BEFORE);
				assertiontest("authentic_insertText", j);
			}
			else {
				// Switch Views test
				robot.setView(View.AUTHENTIC);
				robot.delay(6000);
				assertiontest("authenticview", j,DIAGRAM_MAIN_WINDOW);
			}
			//HTML VIEW 
			robot.keyType(KeyEvent.VK_ESCAPE);
			robot.setView(View.HTML);
			robot.delay(2000);
			assertiontest("htmlview", j,DIAGRAM_MAIN_WINDOW);
			
			//PDF VIEW
			robot.keyType(KeyEvent.VK_ESCAPE);
			robot.setView(View.PDF);
			robot.delay(12000);    //needs some time to display pdf
			assertiontest("pdfview", j,DIAGRAM_MAIN_WINDOW);
			
			//RTF VIEW
			robot.keyType(KeyEvent.VK_ESCAPE);
			robot.setView(View.RTF);
			robot.delay(20000);	//needs some time to display pdf
			assertiontest("rtfview", j,DIAGRAM_MAIN_WINDOW);

			//Word2007 VIEW
			robot.keyType(KeyEvent.VK_ESCAPE);
			robot.setView(View.WML);
			robot.escapeDialog("Generating a Word 2007 document", VK_Y );
			robot.delay(20000);	//needs some time to display pdf
			assertiontest("wmlview", j,DIAGRAM_MAIN_WINDOW);
			
			//DESIGN View
			robot.keyType(KeyEvent.VK_ESCAPE);
			robot.delay(5000);
			robot.setView(View.DESIGN);
			assertiontest("designview", j,DIAGRAM_MAIN_WINDOW);
			
			//close file 
			//robot.closeAll();     // Close all does not reset stylevision panes -> use close instead
			//robot.close();delay(2000);
			robot.closebyStrgF4();
			robot.escapeDialog("Save changes", VK_N );   //don't save 
		//}
		getResult();
	}
	
	
	public void assertiontest(String testname, int test,SnapshotArea... screenarea) {
					
			
			try {
				
				assertAreas(xName[test]+"_"+testname+"_", screenarea);
			} catch (AssertionError e) {
				failure = (failure == null) ? "" : failure;
				failure += e.getMessage() + "\n";
			} catch (ScriptMistakeException e) {
				error = (error == null) ? "" : error;
				error += e.getMessage() + "\n";
			}
	}			
	
	public void getResult(){
	
			if (error != null) 
				throw new AssertionError(error);
			else if (failure != null) 
				throw new ScriptMistakeException(failure);
			else 
			    System.out.print("No Error. No Failure Test");	
			
	}
	
		

	/**
	 * @param args
	*	
	public static void main(String[] args) {
		new StylevisionCollectionTest();
	}
 */
}