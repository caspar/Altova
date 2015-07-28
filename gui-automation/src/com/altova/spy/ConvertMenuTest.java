package com.altova.spy;


import java.awt.event.KeyEvent;
import java.io.File;
import static com.altova.robots.SnapshotArea.CommonArea.*;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.IOUtils;
import com.altova.util.Settings;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;
import static com.altova.spy.SpyRobot.INFO;

//@TestRobot(VSnetSpyRobot.class)
//@TestRobot(EclipseSpyRobot.class)
public class ConvertMenuTest extends AbstractXmlSpyTest {

	private static final File DOC_FILE_TO_IMPORT =IOUtils.findFile("spy/examples/WordDocTest.doc");
	private static final File TEXTFILE_TO_IMPORT = IOUtils.findFile("spy/examples/TestImportTexFile.csv");
	private static final File ITEMS_XML = IOUtils.findFile("spy/examples/items.xml");
	
	protected static final File EXISTING_DB_FILE = IOUtils.findFile("spy/examples/existing_DB.mdb");
	protected static final File DIRECTORY_NEW_DB_File = new File("C:\\temp\\new_DB_file");
	protected static final File NEW_DB_FILE = new File(DIRECTORY_NEW_DB_File.getAbsolutePath()+"\\New_Access_file.mdb");
	private static final String BASE_OUT_DIR= Settings.getOutputDir().getAbsolutePath()+"\\"+AltovaJUnitRunner.getRunName(robot,"ConvertMenuTest");
	protected static final File EXPORT_TO_TEXT_SAVE = new File(BASE_OUT_DIR+"\\testExportToTextFilesSavedInFiles");
	protected static final File TEXT_FILE1 = new File(EXPORT_TO_TEXT_SAVE, "item_tuple.txt");
	protected static final File TEXT_FILE2 = new File(EXPORT_TO_TEXT_SAVE, "items.txt");
	
	protected static final File JSON_TO_XML_FILE_CONVERT = IOUtils.findFile("spy/examples/array-int-00.json");
	protected static final File XML_TO_JSON_FILE_CONVERT = IOUtils.findFile("spy/examples/array-int-00.xml");
	
	@Test
	@IgnoreRobots(EclipseSpyRobot.class)

	public final void testImportTextFile() {
		RadioOption format = new RadioOption("Convert CSV text file into XML",true);
		robot.importTextFile(format,TEXTFILE_TO_IMPORT.getAbsolutePath());
		robot.selectAll();
		robot.expandGridFully();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
    
	
	@Test
	@IgnoreRobots(EclipseSpyRobot.class)

	public final void testImportDBData() {
		robot.importDBData();
		assertWindowAndEscape();
	}

	@Test
	@IgnoreRobots(EclipseSpyRobot.class)
	public final void testImportWordDocument() {
		robot.importWordDocument(DOC_FILE_TO_IMPORT.getAbsolutePath());
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}
    

	@Test
	@IgnoreRobots(EclipseSpyRobot.class)

	public final void testCreateXSDfromDB() {
		robot.createXSDfromDB();
		assertWindowAndEscape();
	}


	@Test
	public final void testDBImportBasedOnXSD() {
		robot.openFile(ORGCHART_XSD_FILE);
		robot.DBImportBasedOnXSD();
		assertWindowAndEscape();
	}

	@Test
	public final void testCreateDBStructureFromXSD() {
		robot.openFile(ORGCHART_XSD_FILE);
		robot.createDBStructureFromXSD();
		assertWindowAndEscape();
	}


	@Test
	@IgnoreRobots(EclipseSpyRobot.class)
	public final void testExportToTextFilesShownInSpy() {
		robot.openFile(ITEMS_XML);
		RadioOption convertXML = new RadioOption("Convert XML into text files",true);
		robot.exportToTextFiles(convertXML,false,null);
		delay(4000);
		assertAreas("testExportToTextFilesShownInSpy_diagram1",DIAGRAM_MAIN_WINDOW);
		delay(6000);
		robot.showAllWindows();
		robot.keyType(KeyEvent.VK_UP);
		delay(500);
		robot.keyType(KeyEvent.VK_ENTER);
		delay(1000);
		assertAreas("testExportToTextFilesShownInSpy_diagram2",DIAGRAM_MAIN_WINDOW);	
		
	}

	
	@Test
	public final void testExportToTextFilesSavedInFiles() {
		
		IOUtils.deleteAll(EXPORT_TO_TEXT_SAVE);
		EXPORT_TO_TEXT_SAVE.mkdirs();
		robot.openFile(ITEMS_XML);
		RadioOption conXML = new RadioOption("Convert XML into text files",true);
		
		robot.exportToTextFiles(conXML,true,EXPORT_TO_TEXT_SAVE);
		
		assertFileExists(TEXT_FILE1);	
		assertFileExists(TEXT_FILE2);
		
	}

	
	//it does not work properly:debug after release
	public final void exportToDBgeneral(File FileDB,String dbName,String existingOrNew,String dbPath) {
		
		robot.openFile(ITEMS_XML);
		RadioOption conXML = new RadioOption("Convert XML into database data",true);
		RadioOption dbType = new RadioOption(dbName);
		RadioOption ifcreated = new RadioOption(existingOrNew);
		robot.exportToDB(dbPath,conXML,dbType,ifcreated);
		
	}
//	checking of contents exported in file must be done manually
	
	@Ignore
	@Test 
	public final void testExportToDBAccessExisting() {
		String dbName = "Microsoft Access";
		String existingOrNew="Use an existing MS Access database";
		exportToDBgeneral(EXISTING_DB_FILE,dbName,existingOrNew,EXISTING_DB_FILE.getAbsolutePath());
	}
	
//	checking of contents exported in created file must be done manually
	
	@Ignore
	@Test 
	public final void testExportToDBAccessNew() {
		IOUtils.deleteAll(DIRECTORY_NEW_DB_File);
		assertFileNotExists(NEW_DB_FILE);
		String dbName = "Microsoft Access";
		String existingOrNew="Create a new MS Access database";
		exportToDBgeneral(NEW_DB_FILE,dbName,existingOrNew,NEW_DB_FILE.getAbsolutePath());
		assertFileExists(NEW_DB_FILE);
	}
	
	@Test	
	public final void testConvertXMLtoJSON(){
		robot.openFile(XML_TO_JSON_FILE_CONVERT);
		robot.ConvertXMLtoFromXML();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, INFO);
		
	}
	
	@Test	
	public final void testConvertJSONtoXML(){
		robot.openFile(JSON_TO_XML_FILE_CONVERT);
		robot.ConvertXMLtoFromXML();
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
}
