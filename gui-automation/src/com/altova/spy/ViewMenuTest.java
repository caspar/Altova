package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.spy.SpyRobot.*;

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.Options;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;
import com.altova.util.IOUtils;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;


//@TestRobot(VSnetSpyRobot.class)
//@TestRobot(EclipseSpyRobot.class)
public class ViewMenuTest extends AbstractXmlSpyTest {

	
	private static final String OrgchartPath = "/OrgChart";
	private static final String Orgchart = "<OrgChart xmlns=";
	private static final String CompanyLogoPath = "/OrgChart/CompanyLogo";
	private static final String FiletoFind ="OrgChart.sps";
	private static final File ORGCHART_SPS_FILE= IOUtils.findFile("spy/examples/"+FiletoFind);
	private static final File TAXONOMY_XSD_FILE=IOUtils.findFile("spy/examples/XBRL_Taxonomy.xsd");
	
	@Test
	public final void testTextView() {
		robot.textView();
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
		
	}

	@Test
	public final void testGridView() {
		robot.gridView();
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES);
	}

	@Test
	public final void testSchemaView() {
		robot.openFile(ORGCHART_XSD_FILE);
		robot.textView();
		robot.schemaView();
		assertAreas(DIAGRAM_MAIN_WINDOW, COMPONENTS, DETAILS, FACETS);
	}
	
	@Test
	public final void testWSDLView() {
		robot.openFile(TIMESERVICE_WSDL_FILE);
		robot.textView();
		robot.wsdlView();
		assertAreas(DIAGRAM_MAIN_WINDOW,OVERVIEW, DETAILS);
	}

	@Test
	public final void testXBRLView() {
		robot.openFile(TAXONOMY_XSD_FILE); 
		robot.textView();
		robot.xbrlView();
		assertAreas(DIAGRAM_MAIN_WINDOW, OVERVIEW, GLOBAL_ELEMENTS, DETAILS);
	}
	
	@Test	
	public final void testAuthenticView() {
		robot.textView();
		robot.authenticView();
		assertAreas(DIAGRAM_MAIN_WINDOW, ELEMENTS, ATTRIBUTES, ENTITIES);
	}

	@Test	
	public final void testBrowserView() {
		robot.browserView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testExpandGrid() {
		robot.gridView();
		robot.xpathHighlight(OrgchartPath);
		robot.expandGrid();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testCollapseGrid() {
		robot.gridView();
		robot.gotoLine(6,1);
		robot.collapseGrid();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testExpandGridFully() {
		robot.gridView();
		robot.xpathHighlight(OrgchartPath);
		robot.expandGridFully();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testExpandTextViewFully() {
		robot.textView();
		robot.collapseText(Orgchart);	
		robot.expandGridFully();
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
		

	@Test
	public final void testCollapseGridUnselected() {
		robot.gridView();
		robot.xpathHighlight(OrgchartPath);
		robot.expandGridFully();
		robot.xpathHighlight(CompanyLogoPath);
		robot.collapseGridUnselected();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testOptimalGridWidths() {
		robot.gridView();
		robot.optimalGridWidths();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public final void testWordWrap() {
		robot.textView();
		robot.wordWrap();
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
		finally {
			robot.wordWrap();
		}
		
	}

	@Test
	public final void testGotoLineTextView() {
		robot.textView();
		robot.gotoLine(10, 10);
		robot.typeString("I am here");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testGotoLineGridView() {
		robot.gridView();
		robot.gotoLine(10, 10);
		robot.typeString("I am here");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

//	@Test
//	public final void testGotoLineIncorrectValues() {
//		robot.textView();
//		robot.gotoLineBoundaryValues(-1, 1);	
//	}
	
	@Test
	public final void testGotoLineBoundaryValues() {
		robot.textView();
		robot.gotoLine(10000, 256);	
		robot.typeString("I am here");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testGotoFileFileNotOpenedTextView() {
		
		robot.textView();
		robot.find(FiletoFind);
		
		Options opt = new Options();
		opt.add(new RadioOption("Edit SPS file directly in XMLSpy"));
		robot.gotoFile(true, opt);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	@IgnoreRobots(EclipseSpyRobot.class) //eclipse cannot open sps files directly
	public final void testGotoFileFileOpenedTextView() {
		
		
		Options opt = new Options();
		opt.add(new RadioOption("Edit SPS file directly in XMLSpy"));
		
		robot.openFile(ORGCHART_SPS_FILE, true, opt);
		robot.openFile(ORGCHART_XML_FILE);
		
		robot.textView();
		robot.find(FiletoFind);
		robot.gotoFile(true, opt);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
		
		
	}
	
	@Test
	public final void testGotoFileFileNotOpenedGridView() {
		
		Options opt = new Options();
		opt.add(new RadioOption("Edit SPS file directly in XMLSpy"));
		
		robot.gridView();
		robot.find(FiletoFind);
		robot.gotoFile(true, opt);
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	public final void testGotoFileFileOpenedGridView() {
		
		Options opt = new Options();
		opt.add(new RadioOption("Edit SPS file directly in XMLSpy"));
		
		robot.openFile(ORGCHART_XML_FILE);
		robot.gridView();
		robot.find(FiletoFind);
		robot.gotoFile(true, opt);//now, sps is opened in editor
		robot.openFile(ORGCHART_XML_FILE);
		robot.gotoFile(true, opt);
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	
	@Test
	public final void testLineNumbersMarginOff() {
		robot.textView();
		Options optionsf=new Options();
		Options optionst=new Options();
		optionsf.add(new CheckboxOption("Line number margin",false));
		optionst.add(new CheckboxOption("Line number margin",true));
		robot.textViewSettings(optionsf);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
		finally {
			robot.textViewSettings(optionst);
		}
	}
	
	@Test
	public final void testLineNumbersMarginOn() {
		robot.textView();
		Options optionst=new Options();
		optionst.add(new CheckboxOption("Line number margin",true));
		robot.textViewSettings(optionst);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	
	@Test 
	public final void testBookmarksMarginOff() {
		robot.textView();
		Options optionsf=new Options();
		Options optionst=new Options();
		optionsf.add(new CheckboxOption("Bookmark margin",false));
		optionst.add(new CheckboxOption("Bookmark margin",true));
		robot.textViewSettings(optionsf);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
		finally {
			robot.textViewSettings(optionst);
		}
	}

	@Test 
	public final void testBookmarksMarginOn() {
		robot.textView();
		Options optionst=new Options();
		optionst.add(new CheckboxOption("Bookmark margin",true));
		robot.textViewSettings(optionst);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public final void testSourceFoldingMarginOff() {
		robot.textView();
		Options optionsf=new Options();
		Options optionst=new Options();
		optionsf.add(new CheckboxOption("Folding margin",false));
		optionst.add(new CheckboxOption("Folding margin",true));
		robot.textViewSettings(optionsf);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
		finally {
			robot.textViewSettings(optionst);
		}
		
	}
	
	@Test
	public final void testSourceFoldingMarginOn() {
		robot.textView();
		Options optionst=new Options();
		optionst.add(new CheckboxOption("Folding margin",true));
		robot.textViewSettings(optionst);
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testTabSize() {
		robot.textView();
		Options options_a=new Options();
		Options options_b=new Options();
		options_a.add(new TextFieldOption("Tab size:","9"));
		options_b.add(new TextFieldOption("Tab size:","4"));
		robot.textViewSettings(options_a);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		} finally {
			robot.textViewSettings(options_b);
		}
	}
	
	@Test
	public final void testInsertTabs(){
		robot.textView();
		Options options_a=new Options();
		Options options_b=new Options();
		options_a.add(new CheckboxOption("Whitespace markers",true));
		options_a.add(new RadioOption("Insert tabs"));
		options_b.add(new CheckboxOption("Whitespace markers",false));
		robot.textViewSettings(options_a);
		robot.prettyPrint_icon();
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		} finally {
			robot.textViewSettings(options_b);
		}
	}
	
	@Test
	public final void testInsertSpaces(){
		robot.textView();
		Options options_a=new Options();
		Options options_b=new Options();
		options_a.add(new CheckboxOption("Whitespace markers",true));
		options_a.add(new RadioOption("Insert spaces"));
		options_b.add(new CheckboxOption("Whitespace markers",false));
		options_b.add(new RadioOption("Insert tabs"));
		robot.textViewSettings(options_a);
		robot.prettyPrint_icon();
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		} finally {
			robot.textViewSettings(options_b);
		}
	}
	
	@Test
	public final void testIndentationGuidesOff() {
		robot.textView();
		Options optionsf=new Options();
		Options optionst=new Options();
		optionsf.add(new CheckboxOption("Indentation guides",false));
		optionst.add(new CheckboxOption("Indentation guides",true));
		robot.textViewSettings(optionsf);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
		finally {
			robot.textViewSettings(optionst);
		}
		
	}

	@Test
	public final void testIndentationGuidesOn() {
		robot.textView();
		Options optionst=new Options();
		optionst.add(new CheckboxOption("Indentation guides",true));
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public final void testEndOfLineMarkersOff() {
		robot.textView();
		Options optionsf=new Options();
		optionsf.add(new CheckboxOption("End of line markers",false));
		assertAreas(DIAGRAM_MAIN_WINDOW);
		robot.textViewSettings(optionsf);
	}

	@Test
	public final void testEndOfLineMarkersOn() {
		robot.textView();
		Options optionst=new Options();
		Options optionsf=new Options();
		optionst.add(new CheckboxOption("End of line markers",true));
		optionsf.add(new CheckboxOption("End of line markers",false));
		robot.textViewSettings(optionst);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
		finally {
			robot.textViewSettings(optionsf);
		}
		
	}
	
	@Test
	public final void testWhitespaceMarkersOff() {
		robot.textView();
		Options optionsf=new Options();
		optionsf.add(new CheckboxOption("Whitespace markers",false));
		robot.textViewSettings(optionsf);
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
		
	}

	@Test
	public final void testWhitespaceMarkersOn() {
		robot.textView();
		Options optionst=new Options();
		Options optionsf=new Options();
		optionst.add(new CheckboxOption("Whitespace markers",true));
		optionsf.add(new CheckboxOption("Whitespace markers",false));
		robot.textViewSettings(optionst);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
		finally {
			robot.textViewSettings(optionsf);
		}
	}
	
}
