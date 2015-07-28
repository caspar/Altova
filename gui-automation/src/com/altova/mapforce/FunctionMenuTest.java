/**
 * 
 */
package com.altova.mapforce;

import java.awt.Rectangle;
import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.DropDownOption;
import com.altova.robots.Options;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;
import com.altova.util.IOUtils;
import com.altova.util.AltovaJUnitRunner.TestRobot;
import static com.altova.util.LoggerUtils.logger;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.mapforce.MapForceRobot.LIBRARIES;
import static com.altova.mapforce.MapForceRobot.MESSAGES;
import static com.altova.robots.ImageRecognitionRobot.WINDOWS_DEFAULT_FONT;

/**
 * @author b.lopez
 *
 */
//@TestRobot(VSnetMapForceRobot.class)
//@TestRobot(EclipseMapForceRobot.class)
public class FunctionMenuTest extends AbstractMapForceTest {

	private final String ORDER_XSD_FILENAME = IOUtils.findFile("examples/Order.xsd").getAbsolutePath();
	private final String TEST_COMPONENT=IOUtils.findFile("tags_list/TEST_TAG.png").getAbsolutePath();
	private final String SECTIONED_PAGE_XSD=IOUtils.findFile("examples/SectionedPage.xsd").getAbsolutePath();
	private final File QUOTATIONSDOC_MFD=IOUtils.findFile("examples/QuotationsDoc.mfd");
	private final String QUOTATIONSDOC_MFT=IOUtils.findFile("examples/QuotationsDoc.mft").getAbsolutePath();
	
	@Test
	public void testCreateUserDefinedFunction_standard(){
		Options options=new Options();
		options.add(new TextFieldOption("Function name",false,"testUserStdFcn",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new TextFieldOption("Library name",false,"aTest",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new TextFieldOption("Syntax",false,"out=f(x)",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Inlined use",false,null,null,null,null,WINDOWS_DEFAULT_FONT)); //detail field cannot be tested
		robot.createUserDefinedFcn(options);
		
		Rectangle hint = robot.activatePane(LIBRARIES);
		robot.leftClickMid(robot.findComponent(null, "Edit", hint));
		robot.deleteString();
		robot.typeString("testUserStdFcn");		
		
		robot.assertLibrariesAndDiagram();
	}
	
	@Test
	public void testCreateUserDefinedFunction_inline(){
		Options options=new Options();
		options.add(new TextFieldOption("Function name",false,"testUserInlineFcn",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new TextFieldOption("Library name",false,"A1Test",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new TextFieldOption("Syntax",false,"res=f(x)",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Inlined use",true,null,null,null,null,WINDOWS_DEFAULT_FONT)); //detail field cannot be tested
		robot.createUserDefinedFcn(options);
		Rectangle hint = robot.activatePane(LIBRARIES);
		robot.leftClickMid(robot.findComponent(null, "Edit", hint));
		robot.deleteString();
		robot.typeString("testUserInlineFcn");
		robot.assertLibrariesAndDiagram();
	}
	
	@Test
	public void testCreateUserDefinedFunctionFromSelection_Standard(){
		robot.selectComponentFromImage(ALTOVADB_COMPONENT);
		Options options=new Options();
		options.add(new TextFieldOption("Function name",false,"testFromSelection",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new TextFieldOption("Library name",false,"AMyLibrary",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new TextFieldOption("Syntax",false,"sel=f(x)",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Inlined use",false,null,null,null,null,WINDOWS_DEFAULT_FONT)); //detail field cannot be tested
		robot.createUserDefinedFcnFromSelection(options);
		Rectangle hint = robot.activatePane(LIBRARIES);
		robot.leftClickMid(robot.findComponent(null, "Edit", hint));
		robot.deleteString();
		robot.typeString("testFromSelection");		
		robot.assertLibrariesAndDiagram();
	}
	
	@Test
	public void testCreateUserDefinedFunctionFromSelection_Inline(){
		robot.selectComponentFromImage(ALTOVADB_COMPONENT);
		Options options=new Options();
		options.add(new TextFieldOption("Function name",false,"testFromSelection_inline",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new TextFieldOption("Library name",false,"ALibraryTest",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new TextFieldOption("Syntax",false,"sel=f(x)",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Inlined use",true,null,null,null,null,WINDOWS_DEFAULT_FONT)); //detail field cannot be tested
		robot.createUserDefinedFcnFromSelection(options);
		Rectangle hint = robot.activatePane(LIBRARIES);
		robot.leftClickMid(robot.findComponent(null, "Edit", hint));
		robot.deleteString();
		robot.typeString("testFromSelection_inline");		
		robot.assertLibrariesAndDiagram();
	}
	
	@Test
	public void testFunctionSettings(){
		Options options1=new Options();
		options1.add(new TextFieldOption("Function name",false,"myTest",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.createUserDefinedFcn(options1);
		Options options=new Options();
		options.add(new TextFieldOption("Function name",false,"hello",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new TextFieldOption("Library name",false,"aLib",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new TextFieldOption("Syntax",false,"x=f(x)",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Inlined use",true,null,null,null,null,WINDOWS_DEFAULT_FONT)); //detail field cannot be tested
		robot.functionSettings(options);
		Rectangle hint = robot.activatePane(LIBRARIES);
		robot.leftClickMid(robot.findComponent(null, "Edit", hint));
		robot.deleteString();
		robot.typeString("hello");	
		robot.assertLibrariesAndDiagram();
	}
	
	@Test
	public void testRemoveFunction(){
		Options options=new Options();
		options.add(new TextFieldOption("Function name",false,"myTest",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.createUserDefinedFcn(options);
		robot.removeFunction();
		robot.assertLibrariesAndDiagram();
	}
	
	
	
	
	@Test
	public void testInsertInputInMapping_ConnectionReq_Fullconn(){
		robot.openFile(CONNECTION_TEST3_MFD);
		Options options=new Options();
		options.add(new TextFieldOption("Datatype",false,"int",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Input is required",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Specify value",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new TextFieldOption("Value:",false,"1981",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.insertInputInMapping("test",options);
		
		Rectangle alt_comp=robot.selectComponentFromImage(TEST_COMPONENT);
		Rectangle r1=new Rectangle(alt_comp.x+alt_comp.width, alt_comp.y+alt_comp.height+5,10,10);
		logger.fine("r1 is: " + r1);
		//robot.leftClickMid(r1);
		Rectangle custTarg_comp=robot.selectComponentFromImage(MIXATTSANDELEMSOUT_COMPONENT);
		Rectangle r2=new Rectangle(custTarg_comp.x+(int)(0.5*custTarg_comp.width),custTarg_comp.y+2*custTarg_comp.height+5,10,40);
		logger.fine("r2 is: " + r2);
		//robot.leftClickMid(r2);
		
		robot.dragDropMid(r1, r2);
		Rectangle in_comp=robot.selectComponentFromImage(MIXATTSANDELEMS3_COMPONENT);
		Rectangle r3=new Rectangle(in_comp.x+15, in_comp.y+in_comp.height+5,10,40);
		Rectangle r4=new Rectangle(alt_comp.x, alt_comp.y+alt_comp.height+5,5,10);
		robot.dragDropMid(r4, r3);
		
		robot.showOutput();
		assertAreas(MESSAGES,DIAGRAM_MAIN_WINDOW);
	}

	
	@Test
	public void testInsertInputInMapping_ConnectionReq_Halfconn(){
		robot.openFile(INSERTINPUTTEST_MFD);
		Options options=new Options();
		options.add(new TextFieldOption("Datatype",false,"integer",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Input is required",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Specify value",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.insertInputInMapping("test",options);
		Rectangle alt_comp=robot.selectComponentFromImage(TEST_COMPONENT);
		Rectangle r1=new Rectangle(alt_comp.x+alt_comp.width, alt_comp.y+alt_comp.height+5,10,10);
		Rectangle custTarg_comp=robot.selectComponentFromImage(MIXATTSANDELEMSOUT_COMPONENT);
		Rectangle r2=new Rectangle(custTarg_comp.x+(int)(0.5*custTarg_comp.width),custTarg_comp.y+2*custTarg_comp.height+5,10,40);
		robot.dragDropMid(r1, r2);
		robot.showOutput();
		assertAreas(MESSAGES,DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertInputInMapping_ConnectionNotReq_Halfconn(){
		robot.openFile(INSERTINPUTTEST_MFD);
		Options options=new Options();
		options.add(new TextFieldOption("Datatype",false,"string",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Input is required",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Specify value",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new TextFieldOption("Value:",false,"13hi90",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.insertInputInMapping("test",options);
		Rectangle alt_comp=robot.selectComponentFromImage(TEST_COMPONENT);
		Rectangle r1=new Rectangle(alt_comp.x+alt_comp.width, alt_comp.y+alt_comp.height+5,10,10);
		Rectangle custTarg_comp=robot.selectComponentFromImage(MIXATTSANDELEMSOUT_COMPONENT);
		Rectangle r2=new Rectangle(custTarg_comp.x+(int)(0.5*custTarg_comp.width),custTarg_comp.y+2*custTarg_comp.height+5,10,40);
		robot.dragDropMid(r1, r2);
		robot.showOutput();
		assertAreas(MESSAGES,DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public void testInsertInputInMapping_ConnectionNotReq_Fullconn(){
		robot.openFile(CONNECTION_TEST3_MFD);
		Options options=new Options();
		options.add(new TextFieldOption("Datatype",false,"gYear",null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Input is required",false,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new CheckboxOption("Specify value",true,null,null,null,null,WINDOWS_DEFAULT_FONT));
		options.add(new TextFieldOption("Value:",false,"1981",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.insertInputInMapping("test",options);
		Rectangle func_comp=robot.selectComponentFromImage(TEST_COMPONENT);
		Rectangle r1=new Rectangle(func_comp.x+func_comp.width, func_comp.y+func_comp.height+5,10,10);
		Rectangle out_comp=robot.selectComponentFromImage(MIXATTSANDELEMSOUT_COMPONENT);
		Rectangle r2=new Rectangle(out_comp.x+(int)(0.5*out_comp.width),out_comp.y+2*out_comp.height+5,10,40);
		robot.dragDropMid(r1, r2);
		Rectangle in_comp=robot.selectComponentFromImage(MIXATTSANDELEMS3_COMPONENT);
		Rectangle r3=new Rectangle(in_comp.x+15, in_comp.y+in_comp.height+5,10,40);
		Rectangle r4=new Rectangle(func_comp.x, func_comp.y+func_comp.height+5,5,10);
		robot.dragDropMid(r4, r3);
		robot.showOutput();
		assertAreas(MESSAGES,DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertInputInUserDefinedFcn_simple(){
		Options options1=new Options();
		options1.add(new TextFieldOption("Function name",false,"UDFTest1",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.createUserDefinedFcn(options1);
		 Options options=new Options();
		 options.add(new TextFieldOption("Name",false,"Input1",null,null,null,null,WINDOWS_DEFAULT_FONT));
		 options.add(new DropDownOption("Datatype",false,"language",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.insertInputInUserDefFcn(options,false,null,null,null);
		robot.validateMapping();
		assertAreas(DIAGRAM_MAIN_WINDOW,MESSAGES);
	}
	
	@Test
	public void testInsertInputInUserDefinedFcn_existingComp(){
		
		Options options1=new Options();
		options1.add(new TextFieldOption("Function name",false,"UDFTest2",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.createUserDefinedFcn(options1);
		 Options options=new Options();
		 options.add(new TextFieldOption("Name",false,"Input2",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.insertInputInUserDefFcn(options,true,"Customers.xsd",null,"Customers");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertInputInUserDefinedFcn_newXSDComp(){
		
		Options options1=new Options();
		options1.add(new TextFieldOption("Function name",false,"UDFTest3",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.createUserDefinedFcn(options1);
		 Options options=new Options();
		 options.add(new TextFieldOption("Name",false,"Input3",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.insertInputInUserDefFcn(options,true,"XML Schema Structure",ORDER_XSD_FILENAME,"Order");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertInputInUserDefinedFcn_newFlexTextComp(){
		Options options1=new Options();
		options1.add(new TextFieldOption("Function name",false,"UDFTest4",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.createUserDefinedFcn(options1);
		 Options options=new Options();
		 options.add(new TextFieldOption("Name",false,"Input4",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.insertInputInUserDefFcn(options,true,"Flex",INSPECTIONREPORT_MFT.getAbsolutePath(),"Report");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	
	public void testInsertOutputInUserDefinedFcn_simple(){
		Options options1=new Options();
		options1.add(new TextFieldOption("Function name",false,"MyUDF1",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.createUserDefinedFcn(options1);
		 Options options=new Options();
		 options.add(new TextFieldOption("Name",false,"Output1",null,null,null,null,WINDOWS_DEFAULT_FONT));
		 options.add(new DropDownOption("Datatype",false,"positiveInteger",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.insertOutputInUserDefFcn(options,false,null,null,null);
		robot.validateMapping();
		assertAreas(DIAGRAM_MAIN_WINDOW,MESSAGES);
	}
	
	@Test
	public void testInsertOutputInUserDefinedFcn_existingComp(){
		robot.openFile(QUOTATIONSDOC_MFD);
		Options options1=new Options();
		options1.add(new TextFieldOption("Function name",false,"MyUDF2",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.createUserDefinedFcn(options1);
		 Options options=new Options();
		 options.add(new TextFieldOption("Name",false,"Output2",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.insertOutputInUserDefFcn(options,true,"QuotationsDoc.mft",null,"Document");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testInsertOutputInUserDefinedFcn_newXSDComp(){
		Options options1=new Options();
		options1.add(new TextFieldOption("Function name",false,"MyUDF3",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.createUserDefinedFcn(options1);
		 Options options=new Options();
		 options.add(new TextFieldOption("Name",false,"Output3",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.insertOutputInUserDefFcn(options,true,"XML Schema Structure",SECTIONED_PAGE_XSD,"SectionType");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	
	public void testInsertOutputInUserDefinedFcn_newFlexTextComp(){
		Options options1=new Options();
		options1.add(new TextFieldOption("Function name",false,"MyUDF4",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.createUserDefinedFcn(options1);
		Options options=new Options();
		options.add(new TextFieldOption("Name",false,"Output4",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.insertOutputInUserDefFcn(options,true,"Flex",QUOTATIONSDOC_MFT,"Document");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
}
