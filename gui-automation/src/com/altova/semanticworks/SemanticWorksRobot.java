package com.altova.semanticworks;

import static com.altova.util.LoggerUtils.logger;
import static java.awt.event.KeyEvent.VK_ENTER;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_N;
import static java.awt.event.KeyEvent.VK_TAB;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.File;

import com.altova.robots.AltovaApplicationRobot;
import com.altova.robots.Pane;
import com.altova.robots.ScriptMistakeException;
import com.altova.util.IOUtils;
import com.altova.util.Settings.AltovaApplication;

/**
 * Robot class specifically for SemanticWorks.
 * 
 * @author Davide Bugnone
 *
 */
public class SemanticWorksRobot extends AltovaApplicationRobot {

	private static final String BASEPATH = "semanticworks/";
	
	
	protected static final File ALTOVAPRODUCTS_DIAGRAM_PNG_FILE  = IOUtils.findFile("semanticworks/examples/XMLSpyEditionsDiagram.png");
	protected static final File DIAGRAM_ICON_FILE                = IOUtils.findFile("semanticworks/RDFViewDiagramIcon.png");
	protected static final File NEW_ELEMENT_ICON_FILE            = IOUtils.findFile("semanticworks/NewRDFNewElementIcon.png");
	protected static final File PALETTE_ICON                     = IOUtils.findFile("semanticworks/palette_icon.png");
	
	public final static Font DEFAULT_SEMANTICWORKS_CONTENT_FONT = new Font("Arial", Font.BOLD, 11);
	
	public final static Pane OVERVIEW = new Pane("Overview", "View", "Overview");
	public final static Pane ERRORS = new Pane("Errors", "View", "Errors");
	public final static Pane DETAILS = new Pane("Details", "View", "Details");
	
	public final static String CLASSES = "Classes";
	public final static String PROPERTIES = "PROPERTIES";
	public final static String INSTANCIES = "Instancies";
	public final static String ALLDIFFERENT = "allDifferent";
	public final static String ONTOLOGIES = "Ontologies";
	
	private final static String[] toolbarIds = { };

	enum OverviewTab {Classes, Properties, Instances, allDifferent, Ontologies, Resources }

	enum owl      {imports, priorVersion, versionInfo, incompatibleWith, sameAs, differentFrom, ontology_property, Thing}
	enum common   {Predicate, Comment, Label}
	enum sublevel {resource_object, blank_node_object, literal_object, rdf, ontology_object}
	enum add      {Add_Instance, Add_Class, Add_Property, Add_anonymous_Class, Add_Restriction, Add_annotation_property, Add_XML_schema_datatype, Add_DataRange}
	enum property {subPropertyOf, domain, range, equivalentProperty, inverseOf }
	enum classes  {subClassOf, intersectionOf, equivalentClass, unionOf, complementOf, oneOf, disjointWith /*, new_instance*/ }
	
	public SemanticWorksRobot() {
		super("Altova SemanticWorks", AltovaApplication.SEMANTICWORKS, "SemanticWorks", "", toolbarIds);
		logger.fine("Created robot "+getClass().getName());
	}

	@Override
	public void exitApplication() {
		exitWithuotSave();
	}
	
	public void exitWithuotSave() {
		logger.fine("Exit without save");
		leftClickMenuItem("File", "Exit  ");delay(1000);

		//TODO: NEED TO ESCAPE SAVE DIALOGS HERE
		
		delay(5000);
	}
	
	private void genericWindowDialog(String window, File absoluteFileName){
		
		delay(2000);
		assertWindow(window);
		
		typeStringEnter(absoluteFileName.getAbsolutePath());
		delay(500);
		addEscapeDialogAction("Save changes", VK_N);
		keyPress(VK_ESCAPE);
		
	}
	
	public void textView(){
		
		Rectangle mWdw=getMainWindow();
		Rectangle r = findString("Text", MS_SHELL_DLG_FONT, mWdw, true);
		
		if (r != null){
			
			leftClickMid(r);
		}
		
	}
	
	
	public void closeAll(){
		
		leftClickMenuItem("File", "Close All");
		addEscapeDialogAction("Save changes", VK_N);
		waitAndEsacpe("");
	}
	
	public void saveFile() {
		leftClickMenuItem("File", "Save");
	}
	
	public void saveFileAs(File newFileName) {
		
		leftClickMenuItem("File", "Save As...");		
		genericWindowDialog("Save As", newFileName);
	}

	public void exportTo_nt(File altovadocumentsExportNtFile) {
		
		leftClickMenuItem("File", "Export to", ".nt ...");		
		genericWindowDialog("Export To", altovadocumentsExportNtFile);		
	}

	public void exportTo_XML(File altovadocumentsExportXMLFile) {
		
		leftClickMenuItem("File", "Export to", "XML...");
		genericWindowDialog("Export To", altovadocumentsExportXMLFile);
	}

	
	public void findWindowDialog(String word){
		
		typeStringEnter(word);
		
		
		boolean notFound = false;
		notFound |= escapeDialog("Finished searching the document", VK_ENTER );
		notFound |= escapeDialog("Reached the end of file", VK_ENTER);
		notFound |= escapeDialog("Cannot find the string", VK_ENTER);
		
		if(notFound) {
			logger.warning("The string "+word+" was not found.");
		}
		
		//if the Find dialog remains on screen, close it
		escapeDialog("Find Next", VK_ESCAPE);
		
	}

	public void replace(String oldText, String newText){
			
			leftClickMenuItem("Edit", "Replace");
			assertWindow("Find & Replace");
			
			typeString(oldText);
			delay(1000);
			keyType(VK_TAB);
			typeString(newText);
			
			try{
				leftClickMid(findComponent("Replace", "Button", null));
				delay(1000);
				leftClickMid(findComponent("Replace", "Button", null));
				
			}catch(ScriptMistakeException e){
				keyType(VK_ENTER);
				delay(2000);
				keyType(VK_ENTER);
			}
			
			escapeDialog("Reached the end of the file.", VK_ENTER);		
			escapeDialog("Cannot find the string", VK_ENTER);
					
			keyType(VK_ESCAPE);
			keyType(VK_ESCAPE);
			
		
	}

	
	/*private Rectangle getOverViewArea(){

		// Find the container of whole RDF/OWL View
		//function below always return null
		Rectangle temp = findComponentClass("MDIClient"); 
		return findComponentClass("MDIClient");
		//return getMainWindow();
	}*/
	
	public void selectOverViewTab(OverviewTab tab){
		
		//left click on selected tab name
		//leftClickString(tab.toString(), MS_SHELL_DLG_FONT, Color.BLACK, getOverViewArea());
		leftClickString(tab.toString(), MS_SHELL_DLG_FONT, Color.BLACK, findComponentClass("SysTabControl32"));
		
	}
	
	
	private void clickDiagramIcon(String name){
		
		Rectangle stringElement = findString(name, DEFAULT_SEMANTICWORKS_CONTENT_FONT, getMainWindow(), false);
		//logger.fine("elem element is OK at>>>" + stringElement);			
		if (stringElement != null){
			
			//I search the diagram icon to click
			Rectangle iconArea = new Rectangle(0, stringElement.y-5, 35, 20);
			//logger.fine("New diagram element is OK at>>>" + iconArea);	
			Rectangle icon = findImage(DIAGRAM_ICON_FILE.getAbsolutePath(), iconArea, false);
			//logger.fine("RECT TO CLICK>>>" + icon);
			
			if (icon !=null) rightClickMid(icon);
			
		}

		
	}
	
	public void openDiagram(String name, OverviewTab tab){
		
		selectOverViewTab(tab);
		delay(1000);
		clickDiagramIcon(name);
		
	}
	
	public void addNewElement(OverviewTab tab, String element) {
		
		String defaultElementName = "unnamed";		
		addNewElement(tab, element, defaultElementName);

	}
	
	
	public void addNewElement(OverviewTab tab, String element, String name) {
				
		selectOverViewTab(tab);
		delay(500);
		clickNewElementIcon(element, name);
		clickDiagramIcon(name);
		
	}
	
	public void addNewElementWitoutDiagram (OverviewTab tab, String element, String name) {
		
		selectOverViewTab(tab);
		delay(500);
		clickNewElementIcon(element, name);
	}
	
	private void clickNewElementIcon(String element, String name) {
		
		Rectangle icon = findImage(NEW_ELEMENT_ICON_FILE.getAbsolutePath(), getMainWindow(), false);
		if (icon !=null) leftClickMid(icon);
		
		Rectangle textName = new Rectangle(icon.x, icon.y, 400, 700);
		leftClickMid(findString(element, textName, false));
		delay(200);
		
		if (!name.contains("unnamed")) typeString(name);
		
		keyPress(VK_ENTER);
		delay(500);
		
	}
	

	public void addNewSubElement(Object... subElem) {

		String defaultElementName = "unnamed";		
		addNewSubElementS(defaultElementName, subElem);
		
	}

	
	public void addNewSubElementS(String defaultElementName, Object... subElem) {		
				
		for (Object object : subElem) {

			//rightClickMid(findString(defaultElementName, DEFAULT_SEMANTICWORKS_CONTENT_FONT, getOverViewArea(), false));
			rightClickMid(findString(defaultElementName, DEFAULT_SEMANTICWORKS_CONTENT_FONT, getMainWindow(), false));
			
			//leftClickMid(findString(object.toString().replace('_', ' '), getOverViewArea(), false));
			leftClickMid(findString(object.toString().replace('_', ' '), getMainWindow(), false));
			delay(200);
			keyPress(VK_ENTER);

		}
		
	}
	
	public void addNewSubElementSPlain(String string, Object... subElem) {

		for (Object object : subElem) {

			//rightClickMid(findString(string, DEFAULT_CONTENT_FONT, getOverViewArea(), false));
			rightClickMid(findString(string, DEFAULT_CONTENT_FONT, getMainWindow(), false));
			
			//leftClickMid(findString(object.toString().replace('_', ' '), getOverViewArea(), false));
			leftClickMid(findString(object.toString().replace('_', ' '), getMainWindow(), false));
			delay(200);
			keyPress(VK_ENTER);

		}
	}
	
	
	
	
	public void addDefaultSubElement() {
		
		addNewSubElementS("unnamed", common.Predicate, common.Comment, common.Label);
		syntaxCheck();
	}
	
	public void addDefaultSubElementWP() {
		
		addNewSubElementS("unnamed", common.Comment, common.Label);
		syntaxCheck();
	}


	//--------------------------------------------------------------------
	//--------------------------------------------------------------------
	
	public void RDF_Level() {
		
		leftClickMenuItem("RDF/OWL", "RDF/OWL Level", "RDF");
	}

	public void RDFS_Level() {
		
		leftClickMenuItem("RDF/OWL", "RDF/OWL Level", "RDFS");
	}

	public void OWLLite_Level() {
		
		leftClickMenuItem("RDF/OWL", "RDF/OWL Level", "OWL Lite");
	}

	public void OWLDL_Level() {
		
		leftClickMenuItem("RDF/OWL", "RDF/OWL Level", "OWL DL");
		
	}

	public void OWLFull_Level() {
		
		leftClickMenuItem("RDF/OWL", "RDF/OWL Level", "OWL Full");
		
	}

	public void syntaxCheck() {
		
		leftClickMenuItem("RDF/OWL", "Syntax Check");
	}

	public void semanticsCheck() {
		
		leftClickMenuItem("RDF/OWL", "Semantics Check");
	}

	public void reloadAllImports() {
		
		leftClickMenuItem("RDF/OWL", "Reload all Imports");
	}

	public void cascade() {
		
		leftClickMenuItem("Window", "Cascade");
		
	}

	public void tile() {
		
		leftClickMenuItem("Window", "Tile");
		
	}

	public void newFile() {
		
		leftClickMenuItem("File", "New");
	}

	public void saveDiagramAsImage() {
		
		leftClickMenuItem("File", "Save Diagram As Image...");
		
		genericWindowDialog("Save As", ALTOVAPRODUCTS_DIAGRAM_PNG_FILE);
	}

	public void encoding() {
		
		leftClickMenuItem("File", "Encoding");
		assertWindow("Encoding");
		
	}

	public void namespaceColorAssignment(String operation, String altovaUriNamespace, File COLOR) {
		
		leftClickMenuItem("Tools", "Namespace color assignments...");
		delay(250);
		assertWindow("Namespace Color Assignments");
		
		
		Rectangle namespaceColorWindow = findComponentName("Namespace Color Assignments");
		
		if (operation.equals("Add")){
			
			//click button "Add" and type the new nemaspace
			leftClickString("Add", MS_SHELL_DLG_FONT, Color.BLACK, namespaceColorWindow);
			delay(500);
			typeString(altovaUriNamespace);
			keyPress(VK_ENTER);
			
			//Search where is the palette icon and click on it
			altovaUriNamespace = altovaUriNamespace.substring(altovaUriNamespace.indexOf("http://www.")+11,altovaUriNamespace.indexOf(".com"));
			Rectangle newURI = findString(altovaUriNamespace, DEFAULT_CONTENT_FONT, namespaceColorWindow, false);
			//logger.fine("value of: newURI" + newURI);
			Rectangle paletteIconArea = new Rectangle(newURI.x, newURI.y-3, 600, 30);
			//logger.fine("value of: paletteIconArea" + paletteIconArea);
			Rectangle icon = findImage(PALETTE_ICON.getAbsolutePath(), paletteIconArea, false);
			
			leftClickMid(icon);
			delay(250);
			assertWindow("Colors");
			
			//In Colors, I search the user color  
			Rectangle colorWindow = findComponentName("Colors");
			leftClickString("Standard", MS_SHELL_DLG_FONT, Color.BLACK, colorWindow);
			
			Rectangle colorIcon = findImage(COLOR.getAbsolutePath(), findComponentName("Hex"), false);
			leftClickMid(colorIcon);
			delay(1000);
			keyPress(VK_ENTER);
			
			
		}else if (operation.equals("Delete")){
			
			altovaUriNamespace = altovaUriNamespace.substring(altovaUriNamespace.indexOf("http://www.")+11,altovaUriNamespace.indexOf(".com"));
			leftClickMid(findString(altovaUriNamespace, DEFAULT_CONTENT_FONT, namespaceColorWindow, false));
			delay(600);
			leftClickString("Delete", MS_SHELL_DLG_FONT, Color.BLACK, namespaceColorWindow);
			
			
		}else{
			
			logger.finest("Error searching the namespace: " + altovaUriNamespace + "in op.: " + operation);
			
		}
		
		delay(500);
		leftClickString("OK", MS_SHELL_DLG_FONT, Color.BLACK, namespaceColorWindow);
		
		
		
	}

	public void URIrefPrefixes(String operation, String prefix, String URI) {
		
		leftClickMenuItem("Tools", "URIref Prefixes...");
		delay(250);
		assertWindow("URIref Prefixes");
		
		Rectangle URIrefPrefixesWindow = findComponentName("URIref Prefixes");
		
		if (operation.equals("Add")){
			
			leftClickString("Add", MS_SHELL_DLG_FONT, Color.BLACK, URIrefPrefixesWindow);
			delay(1000);
			typeString(prefix);
			delay(500);
			keyPress(VK_TAB);
			delay(500);
			typeString(URI);
			keyPress(VK_ENTER);

			
		}else if (operation.equals("Delete")){
			
			//URI = URI.substring(altovaUriNamespace.indexOf("http://www.")+11,altovaUriNamespace.indexOf(".com"));
			leftClickMid(findString(prefix, DEFAULT_CONTENT_FONT, URIrefPrefixesWindow, false));
			delay(600);
			leftClickString("Delete", MS_SHELL_DLG_FONT, Color.BLACK, URIrefPrefixesWindow);

			
		}else{
			
			logger.finest("Error searching the URI: " + URI + "in op.: " + operation);
			
		}

		delay(500);
		leftClickString("OK", MS_SHELL_DLG_FONT, Color.BLACK, URIrefPrefixesWindow);

		
	}

	public void baseURI(String baseURI) {
	
		leftClickMenuItem("Tools", "Base URI...");
		delay(250);
		assertWindow("Base URI");
		
		Rectangle baseURIWindow = findComponentName("Base URI");
		
		typeString(baseURI);
		leftClickString("OK", MS_SHELL_DLG_FONT, Color.BLACK, baseURIWindow);
		
		
	}

	public void namespaceImportsForRDF(String operation, String namespace, File dcontologyRdfFile) {
		
		leftClickMenuItem("Tools", "Namespace Imports for RDF...");
		delay(250);
		assertWindow("Namespace Imports");
		
		Rectangle namespaceImportsForRDFWindow = findComponentName("Namespace Imports");
		
		if (operation.equals("Add")){
			
			leftClickString("Add", MS_SHELL_DLG_FONT, Color.BLACK, namespaceImportsForRDFWindow);
			delay(1000);
			typeString(namespace);
			delay(500);
			keyPress(VK_TAB);
			delay(500);
			typeString(dcontologyRdfFile.getAbsolutePath());
			keyPress(VK_ENTER);

			
		}else if (operation.equals("Delete")){
			
			//Impossible to detect string with slash or back-slash: I just delete the selected by default namespace 
			//leftClickMid(findString(dcontologyRdfFile.getAbsolutePath(), DEFAULT_CONTENT_FONT, namespaceImportsForRDFWindow, false));
			delay(600);
			leftClickString("Delete", MS_SHELL_DLG_FONT, Color.BLACK, namespaceImportsForRDFWindow);

			
		}else{
			
			logger.finest("Error searching the namespace: " + namespace + "in op.: " + operation);
			
		}
		
		delay(500);
		leftClickString("OK", MS_SHELL_DLG_FONT, Color.BLACK, namespaceImportsForRDFWindow);

	}

		
	
}
