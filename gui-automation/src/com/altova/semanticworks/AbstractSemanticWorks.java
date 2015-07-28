package com.altova.semanticworks;

import static com.altova.util.LoggerUtils.logger;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.robots.ScriptMistakeException;
import com.altova.semanticworks.SemanticWorksRobot;
import com.altova.util.IOUtils;

public class AbstractSemanticWorks extends AbstractJUnitTest{
	
	
	protected static SemanticWorksRobot robot;
	
	protected static final File ALTOVAPRODUCTS_RDF_FILE       = IOUtils.findFile("semanticworks/examples/AltovaProducts.rdf");
	protected static final File ALTOVAPRODUCTS_RDF_FILE_SAVED = IOUtils.findFile("semanticworks/examples/AltovaProducts_saved.rdf");
	protected static final File ALTOVADOCUMENTS_RDF_FILE      = IOUtils.findFile("semanticworks/examples/AltovaDocuments.rdf");
	protected static final File ALTOVAMYCLASS_RDF_FILE        = IOUtils.findFile("semanticworks/examples/MyClass.rdf");
	protected static final File PREFIXNAMESPACE_RDF_FILE      = IOUtils.findFile("semanticworks/examples/PrefixNamespaceAdd.rdf");
	protected static final File NAMESPACEIMPORTSFOR_RDF_FILE  = IOUtils.findFile("semanticworks/examples/NamespaceImportsForRDF.rdf");
	protected static final File DCONTOLOGY_RDF_FILE           = IOUtils.findFile("semanticworks/examples/DCOntology.rdf");
	
	protected static final File ALTOVAPRODUCTS_EXPORT_NT_FILE      = IOUtils.findFile("semanticworks/examples/export/AltovaProducts.nt");
	protected static final File ALTOVAPRODUCTS_EXPORT_XML_FILE     = IOUtils.findFile("semanticworks/examples/export/AltovaProducts.rdf");

	
	protected static final String ALTOVA_URI_NAMESPACE     = "http://www.altova.com/test#";
	protected static final String NANONULL_URI_NAMESPACE   = "http://www.nanonull.com/test#";
	protected static final String PURLORG_URI_NAMESPACE   = "http//purl.org/dc/elements/1.1/";
	protected static final File   ICONCOLOR_255_0_0        = IOUtils.findFile("semanticworks/icon_255_0_0.png");
	
	static final File BASEURI_FILE_PATH     = IOUtils.findFile("semanticworks/examples/baseURI.rdf"); 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(robot == null) {
			robot = new SemanticWorksRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
		//robot.setPaneSize(SemanticWorksRobot.EXPLORER, 250, 500);
		
		
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
		robot.openFile(ALTOVAPRODUCTS_RDF_FILE.getAbsolutePath());
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		try {
			robot.closeAll();
		} catch(ScriptMistakeException e) {
			logger.fine("Could not close files - probably none open: "+e);
		}
	}
	
	public static void setRobot(SemanticWorksRobot robot) {
		AbstractSemanticWorks.robot = robot;
	}

	
	
}
