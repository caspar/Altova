/**
 * 
 */
package com.altova.spy.schema;


import static com.altova.spy.SpyRobot.*;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;

import static com.altova.util.LoggerUtils.logger;
import org.junit.Test;
import org.junit.Ignore;

import com.altova.robots.CheckboxOption;
import com.altova.robots.ImageNotFoundException;
import com.altova.robots.Options;
import com.altova.robots.RadioOption;
import com.altova.spy.AbstractXmlSpyTest;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

/**
 * @author B.Lopez
 *
 */
public class SampleValuesTest extends AbstractXmlSpyTest {

	static String testDir = "S:/QA/Internal/Test-Cases/XMLSpy/SchemaView/Sample_values/";
	private static final File ADDSAMPLES_XSD_FILE = new File(testDir+"AddSamples.xsd");
	private static final File ELEM_COMPLEXCONTENT_XSD_FILE=new File(testDir+"Element_complexContent.xsd");
	private static final File ATTRIBUTES_XSD_FILE = new File(testDir+"attribute_small2.xsd");
	private static final File COMPLEXTYPE_INHERIT_XSD_FILE = new File(testDir+"ComplexTypeInheritanceNoEnumer.xsd");
	private static final File ORGCHARTMINI_XSD_FILE = new File(testDir+"miniOrgChart.xsd");
	private static final File COMPLEXTYPES1_XSD_FILE = new File(testDir+"ComplexTypes_try.xsd");
	private static final File COMPLEXTYPES2_XSD_FILE = new File(testDir+"ComplexTypes_try2.xsd");
	private static final File INCLUDEIMPORT_XSD_FILE = new File(testDir+"IncludeImport_ex.xsd");
	private static final File INCLUDEME_XSD_FILE =new File(testDir+"IncludeMe.xsd");
	private static final File SIMPLETYPE_XSD_FILE = new File(testDir+"SimpleTypeInheritance.xsd");
	private static final File COMPLEXTYPEINHERITANCE_XSD_FILE=new File(testDir+"ComplexTypeInheritance.xsd");
	private static final File DERIVEDBYUNION_XSD_FILE = new File(testDir+"derivedByUnion.xsd");
	private static final File INHERITED_ATTS_XSD_FILE = new File(testDir+"inherited_attributes.xsd");
	private static final File ELEMENT_XSD_FILE = new File(testDir+"Element.xsd");
	private static final File NOTVALIDVALUES_XSD_FILE = new File(testDir+"NotValidValues.xsd");
	private static final File TTP34479_REDEFINING_XSD_FILE = new File(testDir+"Redefining_TTP34479.xsd");
	
	
	@Test
	public void testSchemaView_SampleValuesGUI_1a(){
		
		robot.openFile(ADDSAMPLES_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:simpleType[@name='ColorType']");
		robot.insertInSchemaViewPane(FACETS_SAMPLES,"grey");
		robot.appendInSchemaViewPane(FACETS_SAMPLES,"verde");
		robot.appendInSchemaViewPane(FACETS_ENUMERATIONS,"grey");
		robot.validate();
		robot.xpathHighlight("/xs:schema/xs:element[@type='ColorType']");
		assertAreas(FACETS_SAMPLES);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_1b(){
		
		robot.openFile(ADDSAMPLES_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:simpleType[@name='ColorType']");
		robot.appendInSchemaViewPane(FACETS_SAMPLES,"grey");
		robot.insertInSchemaViewPane(FACETS_SAMPLES,"verde");
		robot.validate();
		assertAreas(VALIDATION,FACETS_SAMPLES);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_1c(){
		
		robot.openFile(ADDSAMPLES_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:simpleType[@name='ColorType']");
		robot.textView();
		robot.validate();
		assertAreas(VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_1d(){
		
		robot.openFile(ADDSAMPLES_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:simpleType[@name='ColorType']");
		robot.editSampleValue("green",true,"red");
		robot.xpathHighlight("/xs:schema/xs:element[@type='ColorType']");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "negro");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "blue");
		robot.validate();
		assertAreas(FACETS_SAMPLES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_2a(){
		robot.openFile(ELEM_COMPLEXCONTENT_XSD_FILE);
		robot.insertInSchemaViewPane(FACETS_SAMPLES, " ");
		Options options=new Options();
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Use first"));
		robot.generateSampleXML(options);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
		
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_2b(){
		robot.openFile(ELEM_COMPLEXCONTENT_XSD_FILE);
		robot.setPaneValue(DETAILS_DETAILS, "type", "xs:int");
		if (robot.escapeDialog("Base Type Modification", KeyEvent.VK_R))
		{
			robot.leftClickMid(robot.findComponent("Yes", "Button", null));
			robot.leftClickMid(robot.findComponent("OK", "Button", null));
		}
		robot.setPaneValue(DETAILS_DETAILS, "content", "complex");
		robot.validate();
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "hi");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "hola");
		Options options=new Options();
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Randomize"));
		robot.generateSampleXML(options);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
		
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_3a(){
		robot.openFile(ATTRIBUTES_XSD_FILE);
		robot.xpathHighlight("/xsd:schema/xsd:attribute[@name='AttributeWithPattern']");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "BCI2");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "tzu");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "BEA");
		Options options=new Options();
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Cycle through"));
		robot.generateSampleXML(options);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
		
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_3b(){
		robot.openFile(ATTRIBUTES_XSD_FILE);
		robot.xpathHighlight("/xsd:schema/xsd:attribute[@name='AttributeWithPattern']");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "BCI2");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "tzu");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "BEA");
		robot.validate();
		assertAreas(VALIDATION,FACETS_SAMPLES);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_4a(){
		robot.openFile(COMPLEXTYPE_INHERIT_XSD_FILE);
		Options options=new Options();
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Use first"));
		robot.generateSampleXML(options);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
		
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_4b(){
		robot.openFile(COMPLEXTYPE_INHERIT_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:complexType/xs:sequence/xs:element[@name='el1']");
		robot.setPaneValue(FACETS_FACETS, "minLen", "3");
		Options options=new Options();
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Use first"));
		robot.generateSampleXML(options);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
		robot.closeFile();
		robot.validate();
		assertAreas(getTestName()+"_validation_2",VALIDATION);
		
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_4c(){
		robot.openFile(COMPLEXTYPE_INHERIT_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:simpleType");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "it");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "nolang");
		robot.validate();
		robot.xpathHighlight("/xs:schema/xs:complexType/xs:sequence/xs:element[@name='test']");
		assertAreas(FACETS_SAMPLES,VALIDATION);
		
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_5(){
		robot.openFile(ORGCHARTMINI_XSD_FILE);
		robot.xpathHighlight("/xsd:schema/xsd:complexType[@name='OfficeType']/xsd:sequence/xsd:choice/xsd:element");
		delay(500);
		robot.keyType(KeyEvent.VK_PLUS);
		delay(500);
		robot.keyType(KeyEvent.VK_RIGHT);
		delay(500);
		robot.keyType(KeyEvent.VK_RIGHT);
		delay(500);
		//We attempt to add a sample within an imported element.An error message should come up
		Rectangle pane=robot.activatePane(FACETS_SAMPLES);
		robot.leftClick("IDC_ROW_INSERT", pane,false);
		
		assertWindowAndEscape();
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_6a(){
		robot.openFile(ORGCHARTMINI_XSD_FILE);
		Options options=new Options();
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Generate non-mandatory attributes",true));
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Cycle through"));
		robot.generateSampleXML(options);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_6b(){
		robot.openFile(ORGCHARTMINI_XSD_FILE);
		delay(800); //added delay to prevent empty validation Message (seems that Raptor needs a bit of time to validate the file 
		assertAreas(VALIDATION,FACETS_SAMPLES,DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_7(){
		robot.openFile(COMPLEXTYPES1_XSD_FILE);
		Options options=new Options();
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Cycle through"));
		robot.generateSampleXML(options);
		assertAreas(VALIDATION,DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_8a(){
		robot.openFile(COMPLEXTYPES2_XSD_FILE);
		assertAreas(VALIDATION,FACETS_SAMPLES,DIAGRAM_MAIN_WINDOW);
		
	}	
	
	@Test
	public void testSchemaView_SampleValuesGUI_8b(){
		robot.openFile(COMPLEXTYPES2_XSD_FILE);
		Options options=new Options();
		options.add(new RadioOption("Branch of choice with the smallest"));
		//options.add(new RadioOption("Minimize number of elements"));
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Use first"));
		robot.generateSampleXML(options);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);	
	}	
	
	@Test
	public void testSchemaView_SampleValuesGUI_8c(){
		robot.openFile(COMPLEXTYPES2_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:complexType[@name='complexTypeRest3']");
		robot.deleteSampleValue("7",true);
		robot.deleteSampleValue("6",false);
		robot.deleteSampleValue("89",true);
		robot.xpathHighlight("/xs:schema/xs:complexType[@name='complexTypInt1']");
		robot.deleteSampleValue("78",false);
		robot.deleteSampleValue("6",false);
		robot.deleteSampleValue("90",false);
		Options options=new Options();
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Randomize"));
		robot.generateSampleXML(options);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);	
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_9a(){
		robot.openFile(INCLUDEIMPORT_XSD_FILE);
		robot.setPaneSize(VALIDATION, -1, 350);
		try {
			assertAreas(VALIDATION, FACETS_SAMPLES);
		} finally {
			robot.setPaneSize(VALIDATION, -1, 200);
		}
	}	
	
	@Test
	public void testSchemaView_SampleValuesGUI_9b(){
		robot.openFile(INCLUDEME_XSD_FILE);
		robot.setPaneSize(VALIDATION, -1, 350);
		try {
			assertAreas(VALIDATION, FACETS_SAMPLES);
		} finally {
			robot.setPaneSize(VALIDATION, -1, 200);
		}
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_9c(){
		robot.openFile(INCLUDEIMPORT_XSD_FILE);
		robot.leftClickMenuItem("Window", INCLUDEIMPORT_XSD_FILE.getName());//focus on it with Window opened file list
		Options options=new Options();
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Use first"));
		robot.generateSampleXML(options,"ElementInherit");
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);	
	}	
	
	@Test
	public void testSchemaView_SampleValuesGUI_9d(){
		robot.openFile(INCLUDEIMPORT_XSD_FILE);
		robot.leftClickMenuItem("Window", INCLUDEIMPORT_XSD_FILE.getName());//focus on it with Window opened file list
		Options options=new Options();
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Cycle through"));
		robot.generateSampleXML(options,"AttributeInherit");
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);	
	}	
	
	@Test
	public void testSchemaView_SampleValuesGUI_9e(){
		robot.openFile(INCLUDEIMPORT_XSD_FILE);
		robot.leftClickMenuItem("Window", INCLUDEIMPORT_XSD_FILE.getName());//focus on it with Window opened file list
		Options options=new Options();
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Use first"));
		robot.generateSampleXML(options,"SimpT");
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);	
	}	
	
	@Test
	public void testSchemaView_SampleValuesGUI_9f(){
		robot.openFile(INCLUDEIMPORT_XSD_FILE);
		robot.leftClickMenuItem("Window", INCLUDEIMPORT_XSD_FILE.getName());//focus on it with Window opened file list
		Options options=new Options();
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Cycle through"));
		robot.generateSampleXML(options);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);	
	}	
	
	@Test
	public void testSchemaView_SampleValuesGUI_10a(){
		robot.openFile(SIMPLETYPE_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:simpleType[@name='Child']");
		robot.setPaneValue(FACETS_FACETS, "totalDig", "1");
		robot.setPaneValue(FACETS_FACETS, "maxIncl", "2");
		assertAreas(FACETS_SAMPLES);	
	}	
	
	@Test
	public void testSchemaView_SampleValuesGUI_10b(){
		robot.openFile(SIMPLETYPE_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:simpleType[@name='Child']");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS, "1");
		robot.appendInSchemaViewPane(FACETS_ENUMERATIONS, "2");
		assertAreas(FACETS_SAMPLES);	
	}	
	
	
	@Test
	public void testSchemaView_SampleValuesGUI_10c(){
	  	robot.openFile(SIMPLETYPE_XSD_FILE);
	  	robot.xpathHighlight("/xs:schema/xs:simpleType[@name='Child']");
	  	robot.insertInSchemaViewPane(FACETS_PATTERNS, "[0-9][1-9]");
	  	assertAreas(FACETS_SAMPLES);	
  	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_11a(){
	  	robot.openFile(SIMPLETYPE_XSD_FILE);
	  	robot.xpathHighlight("/xs:schema/xs:simpleType[@name='Father']");
	  	robot.appendInSchemaViewPane(FACETS_ENUMERATIONS, "6");
	  	robot.validate();
	  	robot.xpathHighlight("/xs:schema/xs:simpleType[@name='Child']");
	  	assertAreas(FACETS_SAMPLES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_11b(){
	  	robot.openFile(SIMPLETYPE_XSD_FILE);
	  	robot.xpathHighlight("/xs:schema/xs:simpleType[@name='Father']");
	  	robot.appendInSchemaViewPane(FACETS_ENUMERATIONS, "8");
	  	robot.insertInSchemaViewPane(FACETS_ENUMERATIONS, "3");
	  	robot.appendInSchemaViewPane(FACETS_ENUMERATIONS, "1");
	  	robot.validate();
	  	robot.xpathHighlight("/xs:schema/xs:simpleType[@name='Child']");
	  	assertAreas(FACETS_SAMPLES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_12a(){
		robot.openFile(SIMPLETYPE_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:element[@name='ChildElement']");
		robot.setPaneValue(FACETS_FACETS, "minIncl", "2");
		robot.validate();
		assertAreas(FACETS_SAMPLES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_12b(){
		robot.openFile(SIMPLETYPE_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:element[@name='ChildElement']");
		robot.setPaneValue(FACETS_FACETS, "minIncl", "2");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "1");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "2");
		robot.validate();
		assertAreas(FACETS_SAMPLES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_12c(){
		robot.openFile(SIMPLETYPE_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:element[@name='ChildElement']");
		robot.setPaneValue(FACETS_FACETS, "minIncl", "2");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "1");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "2");
		Options options=new Options();
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Randomize"));
		robot.generateSampleXML(options, "ChildElement");
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test 
	public void testSchemaView_SampleValuesGUI_13a(){
		robot.openFile(SIMPLETYPE_XSD_FILE);
		Options options=new Options();
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Use first"));
		options.add(new CheckboxOption("Generate non-mandatory attributes",true));
		robot.generateSampleXML(options);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_13b(){
		robot.openFile(SIMPLETYPE_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:attribute[@name='ChildAttributeRequired']");
		delay(500);
		robot.setPaneValue(FACETS_FACETS, "totalDig", "1");
		robot.validate();
		assertAreas(VALIDATION,FACETS_SAMPLES);
	}	
	
	@Test
	public void testSchemaView_SampleValuesGUI_13c(){
		robot.openFile(SIMPLETYPE_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:attribute[@name='ChildAttributeRequired']");
		robot.setPaneValue(FACETS_FACETS, "totalDig", "1");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "80");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "90");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "3");
		robot.validate();
		assertAreas(FACETS_SAMPLES,VALIDATION);
	}	
	
	@Test
	public void testSchemaView_SampleValuesGUI_13d(){
		robot.openFile(SIMPLETYPE_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:attribute[@name='ChildAttributeRequired']");
		robot.setPaneValue(FACETS_FACETS, "totalDig", "1");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "80");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "9");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "3");
		robot.appendInSchemaViewPane(FACETS_ENUMERATIONS,"9");
		robot.appendInSchemaViewPane(FACETS_ENUMERATIONS,"80");
		robot.validate();
		assertAreas(FACETS_SAMPLES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_14a(){
		robot.openFile(ATTRIBUTES_XSD_FILE);
		robot.xpathHighlight("/xsd:schema/xsd:attribute[@name='AttributeWithPattern']");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "kui");
		robot.undo();
		robot.undo();
		robot.redo();
		robot.redo();
		robot.validate();
		assertAreas(FACETS_SAMPLES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_14b(){
		robot.openFile(ATTRIBUTES_XSD_FILE);
		robot.xpathHighlight("/xsd:schema/xsd:attribute[@name='AttributeWithPattern']");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "kui");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "ABC");
		robot.insertInSchemaViewPane(FACETS_PATTERNS, "[A-Z][A-Z][A-Z]|[a-z][a-z][a-z]");
		robot.validate();
		assertAreas(FACETS_SAMPLES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_14c(){
		robot.openFile(ATTRIBUTES_XSD_FILE);
		robot.xpathHighlight("/xsd:schema/xsd:attribute[@name='AttributeWithPattern']");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "ABC");
		robot.setPaneValue(FACETS_FACETS, "length", "2");
		robot.validate();
		assertAreas(FACETS_SAMPLES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_14d(){
		robot.openFile(ATTRIBUTES_XSD_FILE);
		robot.xpathHighlight("/xsd:schema/xsd:attribute[@name='AttributeWithPattern']");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "ABC");
		robot.setPaneValue(FACETS_FACETS, "length", "2");
		Options options=new Options();
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));		
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Cycle through"));
		options.add(new CheckboxOption("Generate non-mandatory attributes",true));
		robot.generateSampleXML(options);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_15a(){
		robot.openFile(COMPLEXTYPEINHERITANCE_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:complexType[@name='ct1']");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "it");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "de-AT");
		assertAreas(FACETS_SAMPLES);
		
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_15b(){
		robot.openFile(COMPLEXTYPEINHERITANCE_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:complexType[@name='ct1']");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "it");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "de-AT");
		robot.xpathHighlight("/xs:schema/xs:element[@name='ComplexTypeChild']");
		assertAreas(FACETS_SAMPLES);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_15c(){
		robot.openFile(COMPLEXTYPEINHERITANCE_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:complexType[@name='ct1']");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "it");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "de-AT");
		Options options=new Options();
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Randomize"));
		robot.generateSampleXML(options,"ComplexT");
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_16a(){
		robot.openFile(COMPLEXTYPES1_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:complexType[@name='complexTypegDay4']");
		robot.setPaneValue(FACETS_FACETS,"maxIncl","789"); //this should do nothing
		assertAreas(FACETS_FACETS,VALIDATION);
		}
	
	@Test
	public void testSchemaView_SampleValuesGUI_16b(){
		robot.openFile(COMPLEXTYPES1_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:complexType[@name='complexTypInt1']");
		try{
			robot.insertInSchemaViewPane(FACETS_ENUMERATIONS, "nothing gets inserted"); //this should do nothing
		}catch	(ImageNotFoundException e){
			logger.info("The exception has to be thrown");
		}
		assertAreas(FACETS_ENUMERATIONS);
		}
	
	@Test
	public void testSchemaView_SampleValuesGUI_16c(){
		robot.openFile(COMPLEXTYPES1_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:complexType[@name='complexTypInt1']");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "st");
		robot.validate();
		assertAreas(FACETS_SAMPLES,VALIDATION);
		
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_16d(){
		robot.openFile(COMPLEXTYPES1_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:complexType[@name='complexTypWithAttrib2']");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "---31");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "---15");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "st2");
		robot.validate();
		assertAreas(FACETS_SAMPLES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_16e(){
		robot.openFile(COMPLEXTYPES1_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:complexType[@name='complexTypWithAttrib2']");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "---31");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "---15");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS, "---01");
		robot.appendInSchemaViewPane(FACETS_ENUMERATIONS, "---31");
		robot.validate();
		assertAreas(FACETS_SAMPLES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_16f(){
		robot.openFile(COMPLEXTYPES1_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:complexType[@name='complexTypWithAttrib2']");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "---31");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "---15");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS, "---01");
		robot.appendInSchemaViewPane(FACETS_ENUMERATIONS, "---31");
		robot.setPaneValue(FACETS_FACETS, "maxExcl", "---01");
		robot.validate();
		assertAreas(FACETS_SAMPLES,VALIDATION);
	}
	
	@Ignore
	@Test
	public void testSchemaView_SampleValuesGUI_16g(){
		robot.openFile(COMPLEXTYPES1_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:complexType[@name='complexTypegDay4/xs:entension/xs:attribute']");
		robot.setPaneValue(DETAILS_DETAILS, "type", "xs:boolean");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "5");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "1");
		robot.validate();
		assertAreas(FACETS_SAMPLES,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_17a(){
		robot.openFile(DERIVEDBYUNION_XSD_FILE);
		assertAreas(VALIDATION,FACETS_ENUMERATIONS);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_17b(){
		robot.openFile(DERIVEDBYUNION_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:element/xs:simpleType/xs:union/xs:simpleType/xs:restriction");
		robot.deleteEnumeration("-5",true);
		Options options=new Options();
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Randomize"));
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Generate non-mandatory attributes",true));
		robot.generateSampleXML(options);
		delay(400);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_17c(){
		robot.openFile(DERIVEDBYUNION_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:element/xs:simpleType/xs:union/xs:simpleType/xs:restriction");
		robot.deleteEnumeration("-5",true);
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "77");
		robot.setPaneValue(FACETS_FACETS, "totalDig", "1");
		Options options=new Options();
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Use first"));
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Generate non-mandatory attributes",true));
		robot.generateSampleXML(options);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_17d(){
		robot.openFile(DERIVEDBYUNION_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "77");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "3");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "897");
		assertAreas(FACETS_SAMPLES);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_17e(){
		robot.openFile(DERIVEDBYUNION_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:element/xs:simpleType/xs:union/xs:simpleType/xs:restriction");
		robot.editSampleValue("87", true, "77");
		robot.editSampleValue("3", false, "38");
		robot.xpathHighlight("/xs:schema/xs:element");
		assertAreas(getTestName()+"_facets_element",FACETS_SAMPLES);
		robot.xpathHighlight("/xs:schema/xs:element/xs:simpleType/xs:union");
		assertAreas(getTestName()+"_facets_union",FACETS_SAMPLES);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_17f(){
		robot.openFile(DERIVEDBYUNION_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:element/xs:simpleType/xs:union/xs:simpleType/xs:restriction");
		robot.deleteSampleValue("87", true);
		robot.deleteSampleValue("3", false);
		robot.xpathHighlight("/xs:schema/xs:element/xs:simpleType/xs:union/xs:simpleType/xs:restriction");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "87");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "3");
		robot.xpathHighlight("/xs:schema/xs:element");
		assertAreas(getTestName()+"_facets_element",FACETS_SAMPLES);
		robot.xpathHighlight("/xs:schema/xs:element/xs:simpleType/xs:union");
		assertAreas(getTestName()+"_facets_union",FACETS_SAMPLES);
	}
	
	@Test  
	public void testSchemaView_SampleValuesGUI_17g(){
		robot.openFile(DERIVEDBYUNION_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:element/xs:simpleType/xs:union/xs:simpleType/xs:restriction");
		robot.deleteEnumeration("-5", true);
		robot.deleteEnumeration("3", false);
		robot.deleteEnumeration("77", false);
		robot.textView();
		robot.schemaView();
		robot.xpathHighlight("/xs:schema/xs:element");
		assertAreas(FACETS_SAMPLES);
	}
	
	
	@Test 
	public void testSchemaView_SampleValuesGUI_17h(){
		robot.openFile(DERIVEDBYUNION_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:element/xs:simpleType/xs:union/xs:simpleType/xs:restriction");
		robot.deleteEnumeration("-5", true);
		robot.deleteEnumeration("3", false);
		robot.deleteEnumeration("77", false);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "wrong");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "alsowrong");
		Options options=new Options();
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Randomize"));
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Generate non-mandatory attributes",true));
		robot.generateSampleXML(options);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	
	@Test
	public void testSchemaView_SampleValuesGUI_18a(){
		robot.openFile(INHERITED_ATTS_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:complexType[@name='ct']/xs:attribute");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "d");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "haha");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS,"d");
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.keyType(KeyEvent.VK_RIGHT);delay(500);
		robot.keyType(KeyEvent.VK_PLUS);delay(500);
		robot.keyType(KeyEvent.VK_DOWN);delay(500);
		assertAreas("testSchemaView_SampleValuesGUI_18a_facets_samples",FACETS_SAMPLES);
		assertAreas("testSchemaView_SampleValuesGUI_18a_enumerations",FACETS_ENUMERATIONS);
	}
	
	
	@Test
	public void testSchemaView_SampleValuesGUI_18b(){
		robot.openFile(INHERITED_ATTS_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:complexType[@name='ct']/xs:attribute");
		delay(1000);
		robot.setPaneValue(DETAILS_DETAILS, "type", "xs:nonPositiveInteger", KeyEvent.VK_N);
		robot.setPaneValue(DETAILS_DETAILS,"derivedBy","restriction");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "3");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "+1");
		robot.xpathHighlight("/xs:schema/xs:complexType[@name='ct']/xs:attribute/xs:simpleType/xs:restriction");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "-30");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "-10");
		Options options=new Options();
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Use first"));
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Generate non-mandatory attributes",true));
		robot.generateSampleXML(options);
	
		
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);		
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_19a(){
		robot.openFile(ELEMENT_XSD_FILE);
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "3");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "6");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "7");
		robot.setPaneValue(FACETS_FACETS, "minIncl","6");
		assertAreas(FACETS_SAMPLES);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_19b(){
		robot.openFile(ELEMENT_XSD_FILE);
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "3");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "6");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS, "6");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS, "7");
		assertAreas(FACETS_SAMPLES);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_19c(){
		robot.openFile(ELEMENT_XSD_FILE);
		robot.setPaneValue(FACETS_FACETS, "minIncl","7");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS, "6");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS, "7");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS, "8");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "8");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "6");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "9");
		robot.validate();
		assertAreas(FACETS_SAMPLES,VALIDATION);
	}
	
	@Test 
	public void testSchemaView_SampleValuesGUI_19d(){
		robot.openFile(ELEMENT_XSD_FILE);
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS, "+6");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS, "-0");
		robot.insertInSchemaViewPane(FACETS_ENUMERATIONS, "8");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "+8");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "6");
		robot.appendInSchemaViewPane(FACETS_SAMPLES, "+0");
		robot.setPaneValue(DETAILS_DETAILS, "default", "0");
		robot.validate();
		assertAreas(VALIDATION,FACETS_SAMPLES,DETAILS_DETAILS);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_19e(){
		robot.openFile(ELEMENT_XSD_FILE);
		robot.setPaneValue(DETAILS_DETAILS, "derivedBy", "list");
		robot.xpathHighlight("/xs:schema/xs:element/xs:simpleType");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "s");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "3");
		robot.xpathHighlight("/xs:schema/xs:element");
		assertAreas(FACETS_SAMPLES);
		Options options=new Options();
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Randomize"));
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Generate non-mandatory attributes",true));
		robot.generateSampleXML(options);
		delay(500);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
		
	}	
	
	@Test
	public void testSchemaView_SampleValuesGUI_19f(){
		robot.openFile(ELEMENT_XSD_FILE);
		robot.setPaneValue(DETAILS_DETAILS, "derivedBy", "list");
		robot.xpathHighlight("/xs:schema/xs:element/xs:simpleType");
		//delay(1000);
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "s");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "3");
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "t");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "u");
		assertAreas(FACETS_SAMPLES);
		Options options=new Options();
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Randomize"));
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Generate non-mandatory attributes",true));
		robot.generateSampleXML(options);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_20a(){
		robot.openFile(INCLUDEIMPORT_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "5.3");
		robot.editSampleValue("9.7", false, "7.9");
		robot.deleteSampleValue("10.6", true);
		robot.openFile(INCLUDEME_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:element");
		robot.editSampleValue("1.78", true, "9.78");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "10.5");
		robot.deleteSampleValue("7.9", false);
		robot.window(INCLUDEIMPORT_XSD_FILE.getName());
		robot.validate(); //reparsing is needed here
		robot.window(INCLUDEIMPORT_XSD_FILE.getName());
		robot.xpathHighlight("/xs:schema/xs:element[@name='ElementInherit']/xs:complexType/xs:sequence/xs:element[@ref='ns1:elem1WithSamples']");//imported elem
		assertAreas("testSchemaView_SampleValuesGUI_20a_facets_imported",FACETS_SAMPLES);
		robot.xpathHighlight("/xs:schema/xs:element[@name='ElementInherit']/xs:complexType/xs:sequence/xs:element[@ref='ns2:elem1WithSamples']");//included elem
		assertAreas("testSchemaView_SampleValuesGUI_20a_facets_included",FACETS_SAMPLES);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_20b(){
		robot.openFile(INCLUDEIMPORT_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:attribute");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "tia");
		robot.editSampleValue("hija", true, "papa");
		robot.deleteSampleValue("mama", false);
		robot.openFile(INCLUDEME_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:attribute");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "hermanito");
		robot.editSampleValue("hermana", true, "tata");
		robot.deleteSampleValue("mama", true);
		robot.window(INCLUDEIMPORT_XSD_FILE.getName());
		robot.validate(); //reparsing is needed here
		robot.window(INCLUDEIMPORT_XSD_FILE.getName());
		robot.xpathHighlight("/xs:schema/xs:element[@name='AttributeInherit']/xs:complexType/xs:attribute[@ref='ns1:att1WithSamples']");//imported elem
		assertAreas("testSchemaView_SampleValuesGUI_20b_facets_imported",FACETS_SAMPLES);
		robot.xpathHighlight("/xs:schema/xs:element[@name='AttributeInherit']/xs:complexType/xs:attribute[@ref='ns2:att1WithSamples']");//included elem
		assertAreas("testSchemaView_SampleValuesGUI_20b_facets_included",FACETS_SAMPLES);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_20c(){
		robot.openFile(INCLUDEIMPORT_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:simpleType");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "55");
		robot.editSampleValue("9", false, "0");
		robot.deleteSampleValue("67", false);
		robot.openFile(INCLUDEME_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:simpleType");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "3");
		robot.editSampleValue("6", true, "10");
		robot.deleteSampleValue("90", false);
		robot.window(INCLUDEIMPORT_XSD_FILE.getName());
		robot.validate(); //reparsing is needed here
		robot.window(INCLUDEIMPORT_XSD_FILE.getName());
		robot.xpathHighlight("/xs:schema/xs:element[@name='SimpTypInherit']/xs:complexType/xs:sequence/xs:element[@type='ns1:simTyp1WithSamples']");//imported elem
		assertAreas("testSchemaView_SampleValuesGUI_20c_facets_imported",FACETS_SAMPLES);
		robot.xpathHighlight("/xs:schema/xs:element[@name='SimpTypInherit']/xs:complexType/xs:sequence/xs:element[@type='ns2:simTyp1WithSamples']");//included elem
		assertAreas("testSchemaView_SampleValuesGUI_20c_facets_included",FACETS_SAMPLES);
	}
	
	@Test
	public void testSchemaView_SampleValuesGUI_20d(){
		robot.openFile(INCLUDEIMPORT_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "it");
		robot.editSampleValue("0", true, "ru");
		robot.deleteSampleValue("de-", false); //Robot can't find de-AT string
		robot.openFile(INCLUDEME_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:complexType");
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "pt");
		robot.editSampleValue("de", false, "de-DE");
		robot.deleteSampleValue("78", true);
		robot.window(INCLUDEIMPORT_XSD_FILE.getName());
		robot.validate(); //reparsing is needed here
		robot.window(INCLUDEIMPORT_XSD_FILE.getName());
		robot.xpathHighlight("/xs:schema/xs:element[@name='CompTypInherit']/xs:complexType/xs:sequence/xs:element[@type='ns1:compTyp1WithSamples']");//imported elem
		assertAreas("testSchemaView_SampleValuesGUI_20d_facets_imported",FACETS_SAMPLES);
		robot.xpathHighlight("/xs:schema/xs:element[@name='CompTypInherit']/xs:complexType/xs:sequence/xs:element[@type='ns2:compTyp1WithSamples']");//included elem
		assertAreas("testSchemaView_SampleValuesGUI_20d_facets_included",FACETS_SAMPLES);
	}
	@Ignore
	@Test
	public void testSchemaView_SampleValuesGUI_21a(){
		robot.openFile(NOTVALIDVALUES_XSD_FILE);
		Options options=new Options();
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Use first"));
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Generate non-mandatory attributes",true));
		robot.generateSampleXML(options);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	@Ignore
	@Test
	public void testSchemaView_SampleValuesGUI_21b(){
		robot.openFile(NOTVALIDVALUES_XSD_FILE);
		//we do not need to select the element as it gets selected since validation error
		robot.insertInSchemaViewPane(FACETS_SAMPLES, "ABCDEFGH");
		Options options=new Options();
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Use first"));
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Generate non-mandatory attributes",true));
		robot.generateSampleXML(options);
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	@Ignore
	@Test
	public void testSchemaView_SampleValuesGUI_21c(){
		robot.openFile(NOTVALIDVALUES_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:simpleType[@name='option']");
		robot.editSampleValue("test:c", false, "c");
		robot.validate(); //c is not valid value (see ttp 34509) for Raptor and Saxon
		robot.xpathHighlight("/xs:schema/xs:simpleType[@name='option']");
		assertAreas(VALIDATION,FACETS_SAMPLES);
	}
	@Ignore
	@Test //file is invalid - cannot be generated the sample 
	public void testSchemaView_SampleValuesGUI_21d(){
		robot.openFile(NOTVALIDVALUES_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:simpleType[@name='option']");
		robot.editSampleValue("test:c", false, "c");
		Options options=new Options();
		options.add(new CheckboxOption("Use manually added sample values",true));
		options.add(new RadioOption("Use first"));
		options.add(new RadioOption("All branches of choice"));
		//options.add(new RadioOption("Generate all elements"));
		options.add(new CheckboxOption("Generate non-mandatory attributes",true));
		robot.generateSampleXML(options); //"c" should be taken for "Test"
		assertAreas(DIAGRAM_MAIN_WINDOW,VALIDATION);
	}
	
	@Test
	public void testSchemaView_ttp34479(){
		robot.openFile(TTP34479_REDEFINING_XSD_FILE);
		robot.xpathHighlight("/xs:schema/xs:redefine/xs:attributeGroup/xs:attribute");
		assertAreas(FACETS_SAMPLES,VALIDATION); //samples should contain the sample values and warning should be triggered
	}
	
}


