package com.altova.schemaagent;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.util.LoggerUtils.logger;
import static com.altova.schemaagent.SchemaAgentRobot.EXPLORER;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import com.altova.robots.ScriptMistakeException;

public class EditMenuTest extends AbstractSchemaAgentTest  {

	
	@Before 
	public void startUp(){
		
		robot.openFile(DB_COMPLETEPO_FILE);
	}
	
	
	@After
	public void CleanUp() {
		try {
			robot.closeWithoutSave();
		} catch(ScriptMistakeException e) {
			logger.fine("Could not Design window - probably already closed: "+e);
		}
	}
	
	@Test
	public void testCut() {
		
		robot.openFile(DB_COMPLETEPO_MAPFORCE_FILE);
		robot.selectAll();
		
		robot.cut();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Test
	public void testPaste() {
		
		robot.openFile(DB_COMPLETEPO_MAPFORCE_FILE);
		robot.selectAll();
		
		robot.newDesign();
		robot.paste();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
	
	@Ignore
	@Test
	public void testCopy() {
		
		fail("Not implemented"); // TODO
		
	}
	
	@Test
	public void testDelete() {
		
		robot.openFile(DB_COMPLETEPO_MAPFORCE_FILE);
		robot.selectAll();
		
		robot.delete();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, EXPLORER);
		
	}
	
	@Test
	public void testRecreate_GUI() {
		
		removeAndAssert(RECREATE_XSD_FILE);
		
		robot.openFile(RECREATE_SAD_FILE);
		robot.selectAll();
		
		robot.reloadSearchPaths();
		robot.delayServerBusyAlert();
		
		robot.recreate();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, EXPLORER);
	
	}
	
	@Test
	public void testRecreate_file() {
		
		removeAndAssert(RECREATE_XSD_FILE);
		
		robot.openFile(RECREATE_SAD_FILE);
		robot.selectAll();
		
		robot.reloadSearchPaths();
		robot.delayServerBusyAlert();
		
		robot.recreate();
		
		assertFileExists(RECREATE_XSD_FILE);
	
		
	}
	
	
	
	
	
	
	@Test
	public void testSelectFiles_All(){
		
		robot.leftClickMenuShortcut("Edit", "S", "S", "A");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		//All files in diagam
	}

	@Test
	public void testSelectFiles_SchemaFiles(){
		
		robot.leftClickMenuShortcut("Edit", "S", "S", "S");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
        //All schema in diagam
	}

	@Test
	public void testSelectFiles_XMLFiles(){
		
		robot.leftClickMenuShortcut("Edit", "S", "S", "X");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		//All XML in diagam
	}

	@Test
	public void testSelectFiles_XSLFiles(){
		
		robot.leftClickMenuShortcut("Edit", "S", "S", "L");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		//All XSL in diagam
	}
	
	@Test
	public void testSelectFiles_WSDLFiles(){
		
		robot.leftClickMenuShortcut("Edit", "S", "S", "W");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		//All WSDL in diagam
	}
	
	@Test
	public void testSelectFiles_MapforceDesigns(){
		
		robot.leftClickMenuShortcut("Edit", "S", "S", "M");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		//All Mapforce design in diagam
	}

	@Test
	public void testSelectAllDirectlyReferenced_Files(){
		
		robot.findElementOnDiagram("ShortPO.xml");
		robot.leftClickMenuShortcut("Edit", "S", "D", "F");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
		//result: complete.xsl ShortPO.xsd
	}
	
	@Test
	public void testSelectAllDirectlyReferenced_SchemaFiles(){
		
		robot.findElementOnDiagram("DB_CompletePO.mfd");
		robot.leftClickMenuShortcut("Edit", "S", "D", "S");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//DB_CompletePO.xsd and ShortPO.xsd
	}

	@Test
	public void testSelectAllDirectlyReferenced_XMLFiles(){
		
		robot.findElementOnDiagram("DB_CompletePO.mfd");
		robot.leftClickMenuShortcut("Edit", "S", "D", "X");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//ShortPO.xml 
	}
	
	@Test
	public void testSelectAllDirectlyReferenced_XSLFiles(){
		
		robot.findElementOnDiagram("ShortPO.xml");
		robot.leftClickMenuShortcut("Edit", "S", "D", "L");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//Complete.xsl 
	}
	
	@Test
	public void testSelectAllDirectlyReferenced_WSDLFiles(){
		
		robot.findElementOnDiagram("Request.wsdl");
		robot.leftClickMenuShortcut("Edit", "S", "D", "W");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//Imported.wsdl 
	}
	
	@Ignore
	@Test
	public void testSelectAllDirectlyReferenced_MapForceFiles(){
		
		robot.findElementOnDiagram("CompletedPO.xsd");
		robot.leftClickMenuShortcut("Edit", "S", "D", "M");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//DB_CompletePO.mfd 
	}
	
	@Test
	public void testSelectAllDirectlyReferencing_Files(){
		
		robot.findElementOnDiagram("ShortPO.xsd");
		robot.leftClickMenuShortcut("Edit", "S", "I", "F");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//ShortPO.xml, DB_CompletePO.mfd and Request.wsdl
	}

	@Test
	public void testSelectAllDirectlyReferencing_SchemaFiles(){
		
		robot.findElementOnDiagram("Customer"); //doesnt find anymore Customer.xsd
		robot.leftClickMenuShortcut("Edit", "S", "I", "S");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//DB_CompletePO.xsd
	}

	@Test
	public void testSelectAllDirectlyReferencing_XMLFiles(){
		
		robot.findElementOnDiagram("Complete.xsl");
		robot.leftClickMenuShortcut("Edit", "S", "I", "X");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//ShortPO.xml
	}
	
	@Ignore
	@Test
	public void testSelectAllDirectlyReferencing_XSLFiles(){
		
		robot.findElementOnDiagram("");
		robot.leftClickMenuShortcut("Edit", "S", "I", "L");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//
	}
	
	@Test
	public void testSelectAllDirectlyReferencing_WSDLFiles(){
		
		robot.findElementOnDiagram("Imported.wsdl");
		robot.leftClickMenuShortcut("Edit", "S", "I", "W");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//Request.wsdl
	}	
	
	@Test
	public void testSelectAllDirectlyReferencing_MapForceFiles(){
		
		robot.findElementOnDiagram("ShortPO.xml");
		robot.leftClickMenuShortcut("Edit", "S", "I", "M");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//DB_CompletePO.mfd
	}
	
	@Test
	public void testSelectAllDirectlyRelated_Files(){
		
		robot.findElementOnDiagram("ShortPO.xml");
		robot.leftClickMenuShortcut("Edit", "S", "R", "F");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//Complete.xsl,DB_CompletePO.mfd and ShortPo.xsd
	}
	
	@Test
	public void testSelectAllDirectlyRelated_XSDFiles(){
		
		robot.findElementOnDiagram("CompletePO.xsd");
		robot.leftClickMenuShortcut("Edit", "S", "R", "S");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//Article.xsd and Customer.xsd
	}
	
	@Test
	public void testSelectAllDirectlyRelated_XMLFiles(){
		
		robot.findElementOnDiagram("ShortPO.xsd");
		robot.leftClickMenuShortcut("Edit", "S", "R", "X");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//ShortPO.xml
	}
	
	@Test
	public void testSelectAllDirectlyRelated_XSLFiles(){
		
		robot.findElementOnDiagram("ShortPO.xml");
		robot.leftClickMenuShortcut("Edit", "S", "R", "L");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//Complete.xsl
	}
	
	@Test
	public void testSelectAllDirectlyRelated_WSDLFiles(){
		
		robot.findElementOnDiagram("ShortPO.xsd");
		robot.leftClickMenuShortcut("Edit", "S", "R", "W");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//Request.wsdl
	}
	
	@Test
	public void testSelectAllDirectlyRelated_MapForceFiles(){
		
		robot.findElementOnDiagram("ShortPO.xsd");
		robot.leftClickMenuShortcut("Edit", "S", "R", "M");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//DB_CompletePO.mfd
	}

	@Test
	public void testSelectAllReferenced_Files(){
		
		robot.findElementOnDiagram("ShortPO.xml");
		robot.leftClickMenuShortcut("Edit", "S", "E", "F");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//Complete.xsl and ShortPO.xsd
	}

	@Test
	public void testSelectAllReferenced_XSDFiles(){
		
		robot.findElementOnDiagram("CompletePO.xsd");
		robot.leftClickMenuShortcut("Edit", "S", "E", "S");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//Article.xsd and Customer.xsd
	}
	
	@Test
	public void testSelectAllReferenced_XMLFiles(){
		
		robot.findElementOnDiagram("DB_CompletePO.mfd");
		robot.leftClickMenuShortcut("Edit", "S", "E", "X");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//ShortPO.xml
	}
	
	@Test
	public void testSelectAllReferenced_XSLFiles(){
		
		robot.findElementOnDiagram("ShortPO.xml");
		robot.leftClickMenuShortcut("Edit", "S", "E", "L");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//Complete.xsl
	}
	
	@Test
	public void testSelectAllReferenced_WSDLFiles(){
		
		robot.findElementOnDiagram("Request.wsdl");
		robot.leftClickMenuShortcut("Edit", "S", "E", "W");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//Imported.wsdl
	}
	
	@Ignore
	@Test
	public void testSelectAllReferenced_MapForceFiles(){
		
		robot.findElementOnDiagram("CompletePO.xsd");
		robot.leftClickMenuShortcut("Edit", "S", "E", "M");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//No file can reference a Mapforce file (by design)
	}
	
	@Test
	public void testSelectAllReferencing_Files(){
		
		robot.findElementOnDiagram("Complete.xsl");
		robot.leftClickMenuShortcut("Edit", "S", "F", "F");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//ShortPO.xml
	}
	
	@Test
	public void testSelectAllReferencing_XSDFiles(){ //doesnt find anymore Customer.xsd
		
		robot.findElementOnDiagram("Customer");
		robot.leftClickMenuShortcut("Edit", "S", "F", "S");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//CompletePO.xsd
	}
	
	@Test
	public void testSelectAllReferencing_XMLFiles(){
		
		robot.findElementOnDiagram("Complete.xsl");
		robot.leftClickMenuShortcut("Edit", "S", "F", "X");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//ShortPO.xml
	}
	
	@Ignore
	@Test
	public void testSelectAllReferencing_XSLFiles(){
		
		robot.findElementOnDiagram("");
		robot.leftClickMenuShortcut("Edit", "S", "F", "L");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		
	}
	
	@Test
	public void testSelectAllReferencing_WSDLFiles(){
		
		robot.findElementOnDiagram("ShortPO.xsd");
		robot.leftClickMenuShortcut("Edit", "S", "F", "W");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//Request.wsdl
	}
	
	@Test
	public void testSelectAllReferencing_MapForceFiles(){
		
		robot.findElementOnDiagram("Complete.xsl");
		robot.leftClickMenuShortcut("Edit", "S", "F", "M");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//DB_CompletePO.mfd
	}
	
	@Test
	public void testSelectAllRelated_Files(){
		
		robot.findElementOnDiagram("ShortPO.xml");
		robot.leftClickMenuShortcut("Edit", "S", "A", "F");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//Complete.xsl, ShortPO.xsd and DB_CompletePO.mfd
	}
	
	@Test
	public void testSelectAllRelated_XSDFiles(){
		
		robot.findElementOnDiagram("DB_CompletePO.mfd");
		robot.leftClickMenuShortcut("Edit", "S", "A", "S");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//Article.xsd, Customer.xsd, ShortPO.xsd and CompletePO.xsd
	}
	
	@Test
	public void testSelectAllRelated_XMLFiles(){
		
		robot.findElementOnDiagram("DB_CompletePO.mfd");
		robot.leftClickMenuShortcut("Edit", "S", "A", "X");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//ShortPO.xml 
	}

	@Test
	public void testSelectAllRelated_XSLFiles(){
		
		robot.findElementOnDiagram("DB_CompletePO.mfd");
		robot.leftClickMenuShortcut("Edit", "S", "A", "L");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//Complete.xsl
	}

	@Test
	public void testSelectAllRelated_WSDLFiles(){
		
		robot.findElementOnDiagram("ShortPO.xsd");
		robot.leftClickMenuShortcut("Edit", "S", "A", "W");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
//		Request.wsdl
	}
	@Test
	public void testSelectAllRelated_MapForceFiles(){
		
		robot.findElementOnDiagram("Complete.xsl");
		robot.leftClickMenuShortcut("Edit", "S", "A", "M");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//DB_CompletePO.mfd
	}
	
	@Test
	public void testSelectAllLinked_Files(){
		
		robot.findElementOnDiagram("Complete.xsl");
		robot.leftClickMenuShortcut("Edit", "S", "K", "F");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//All files but not the unlinked.* 
	}
	
	@Test
	public void testSelectAllLinked_XSDFiles(){
		
		robot.findElementOnDiagram("Imported.wsdl");
		robot.leftClickMenuShortcut("Edit", "S", "K", "S");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//All the xsd file but not the unlinked.*
	}
	
	@Test
	public void testSelectAllLinked_XMLFiles(){
		
		robot.findElementOnDiagram("Request.wsdl");
		robot.leftClickMenuShortcut("Edit", "S", "K", "X");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//All the xml file but not the unlinked.*
	}
	
	@Test
	public void testSelectAllLinked_XSLFiles(){
		
		robot.findElementOnDiagram("Request.wsdl");
		robot.leftClickMenuShortcut("Edit", "S", "K", "L");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//All the xsl file but not the unlinked.*
	}
	
	@Test
	public void testSelectAllLinked_WSDLFiles(){
		
		robot.findElementOnDiagram("Article.xsd");
		robot.leftClickMenuShortcut("Edit", "S", "K", "W");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//All the wsdl file but not the unlinked.*
	}
	
	@Test
	public void testSelectAllLinked_MapForceFiles(){
		
		robot.findElementOnDiagram("Request.wsdl");
		robot.leftClickMenuShortcut("Edit", "S", "K", "M");
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	
		//All the mapforce file but not the unlinked.*
	}

}
