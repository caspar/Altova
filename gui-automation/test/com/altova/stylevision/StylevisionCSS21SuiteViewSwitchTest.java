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

import com.altova.stylevision.StyleVisionRobot.View;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;

import static com.altova.stylevision.Position.BEFORE;
import static com.altova.stylevision.Tag.PEACH;

import static com.altova.stylevision.TagType.START;

public class StylevisionCSS21SuiteViewSwitchTest extends AbstractJUnitTest {
	
	protected static StyleVisionRobot robot;
	private static final XMLFileReader myxml = new XMLFileReader("test\\com\\altova\\stylevision\\testsuite3.xml");
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
	
	@Test
public void test1(){
		
		for (int j = 0; j < xSpsfile.length; j++) {
		//for (int j = 0; j < 3; j++) {
			//load either SPS file or create new one 
			if (xSpsfile[j]!=""){
				robot.openFile(xTestdir[j]+xSpsfile[j]);
				assertiontest("openfile", j,TOP_WINDOW);
				//Press Escape to close possibly raised msg window
				robot.keyType(KeyEvent.VK_ESCAPE);delay(2000);
				robot.maximizeFileWindow();

			}
			else {
				robot.newSPS("empty");
				robot.delay(2000);
				robot.maximizeFileWindow();
				assertiontest("newemptyfile", j,TOP_WINDOW);
			}
			if (xSchemafile[j]!=""){
				robot.addSchema(xTestdir[j]+xSchemafile[j]);
				assertiontest("addschema", j,TOP_WINDOW);
			}
			if (xWorkingxml[j]!=""){
				robot.assigningWorkingXML(xTestdir[j]+xWorkingxml[j]);
				assertiontest("assignwxml", j,TOP_WINDOW);
			}
			if (xTemplatexml[j]!=""){
				robot.assigningTemplateXML(xTestdir[j]+xTemplatexml[j]);
				assertiontest("assigntxml", j,TOP_WINDOW);
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
				assertiontest("showLargeMarkups", j,DIAGRAM_MAIN_WINDOW);
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
			//Press Escape to close possibly raised msg window
			robot.keyType(KeyEvent.VK_ESCAPE);
			robot.setView(View.HTML);
			robot.delay(6000);
			assertiontest("htmlview", j,DIAGRAM_MAIN_WINDOW);
			
			//Press Escape to close possibly raised msg window
			robot.keyType(KeyEvent.VK_ESCAPE);
			robot.setView(View.PDF);
			robot.delay(12000);    //needs some time to display pdf
			assertiontest("pdfview", j,DIAGRAM_MAIN_WINDOW);
			
			//Press Escape to close possibly raised msg window
			robot.keyType(KeyEvent.VK_ESCAPE);
			robot.setView(View.RTF);
			robot.delay(20000);	//needs some time to display pdf
			assertiontest("rtfview", j,DIAGRAM_MAIN_WINDOW);

			//Press Escape to close possibly raised msg window
			robot.keyType(KeyEvent.VK_ESCAPE);
			robot.delay(5000);
			robot.setView(View.DESIGN);
			assertiontest("designview", j,DIAGRAM_MAIN_WINDOW);
			
			
			

			//close file 
			//robot.closeAll();     // Close all does not reset stylevision panes -> use close instead
			//robot.close();delay(2000);
			robot.closebyStrgF4();
		}
		
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