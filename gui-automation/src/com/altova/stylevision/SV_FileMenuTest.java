package com.altova.stylevision;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Test;

import com.altova.stylevision.StyleVisionRobot.View;
import com.altova.util.IOUtils;


public class SV_FileMenuTest extends AbstractStyleVisionTest {
	private static final String My_TestDir="data/stylevision/tdata";
	
	private File MY_TestCase_File1=IOUtils.findFile(My_TestDir+"/orgchart/orgchart.sps");
	private String MY_ORGCHART_SPS_FILE=MY_TestCase_File1.getAbsolutePath();

	private File MY_TestCase_File2=IOUtils.findFile(My_TestDir+"/expreport/ExpReport.sps");
	private String MY_EXPREPORT_SPS_FILE=MY_TestCase_File2.getAbsolutePath();
	
	private File MY_TestCase_File3=IOUtils.findFile(My_TestDir+"/db/DBSample.sps");
	private String MY_DBSAMPLE_SPS_FILE=MY_TestCase_File3.getAbsolutePath();
	
//	protected static final String MY_ORGCHART_SPS_FILE = AltovaApplication.STYLEVISION.getExamplesLocation().getAbsolutePath()+"\\orgchart.pxf";
//	protected static final String MY_ORGCHART_SPS_FILENAME ="orgchart.pxf";
//	protected static final String MY_EXPREPORT_SPS_FILE = AltovaApplication.STYLEVISION.getExamplesLocation().getAbsolutePath()+"\\ExpReport.sps";
//	protected static final String MY_EXPREPORT_SPS_FILENAME ="ExpReport.sps";
//	protected static final String MY_DBSAMPLE_SPS_FILE = AltovaApplication.STYLEVISION.getExamplesLocation().getAbsolutePath()+"\\DBSample.sps";
//	protected static final String MY_DBSAMPLE_SPS_FILENAME ="DBSample.sps";


	@Test
	public void FileNew_Schema() {
		robot.newSPS("Schema");
		assertForegroundWindow("Open XML Schema / DTD / XML file...");
		robot.keyType(KeyEvent.VK_ESCAPE);  //exit the dialog
	}
	
	@Test
	public void FileNew_DB() {
		robot.newSPS("New from DB...");
		assertForegroundWindow("Open Database");
		robot.keyType(KeyEvent.VK_ESCAPE);  //exit the dialog
	}

	@Test
	public void FileNew_XMLDB() {
		robot.newSPS("XML column");
		assertForegroundWindow("Open Database");
		robot.keyType(KeyEvent.VK_ESCAPE);  //exit the dialog
	}

	@Test
	public void FileNew_XBRL() {
		robot.newSPS("XBRL");
		assertForegroundWindow("Open XBRL Taxonomy");
		robot.keyType(KeyEvent.VK_ESCAPE);  //exit the dialog
	}

	@Test
	public void FileNew_HTML() {
		robot.newSPS("HTML");
		assertForegroundWindow("Open HTML source file");
		robot.keyType(KeyEvent.VK_ESCAPE);  //exit the dialog
	}

	@Test
	public void FileNew_XSLT() {
		robot.newSPS("XSLT");
		assertForegroundWindow("Open");
		robot.keyType(KeyEvent.VK_ESCAPE);  //exit the dialog
	}

	@Test
	public void FileNew_emtpy() {
		robot.newSPS("empty");
		assertForegroundWindow("Create New Design");
		robot.keyType(KeyEvent.VK_ESCAPE);  //exit the dialog
	}

	@Test
	public void FileOpen() {
		robot.leftClickMenuItem("File", "Open");
		assertForegroundWindow("Open");
		robot.keyType(KeyEvent.VK_ESCAPE);  //exit the dialog
	}
	
	@Test
	public void FileReload() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File", "Reload");
		assertForegroundWindow("StyleVision");
		robot.keyType(KeyEvent.VK_Y);  //reload and exit the dialog
		robot.closebyStrgF4();
	}
	
	@Test
	public void FileClose() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File", "Close");
		assertForegroundWindow("Altova StyleVision");
	}
	
	@Test
	public void FileCloseAll() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.openFile(MY_EXPREPORT_SPS_FILE);
		robot.leftClickMenuItem("File", "Close All");
		assertForegroundWindow("StyleVision");
	}
	
	@Test
	public void FileSaveAs() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File", "Save As");
		assertForegroundWindow("Save Design");
		robot.keyType(KeyEvent.VK_ESCAPE);  //don't save exit the dialog
	}
/*	function removed in V2012
	@Test
	public void FileSaveCompatibleTo() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File", "Save Compatible To","StyleVision Version 2010r3");
		assertForegroundWindow("Save orgchart.pxf as");
		robot.keyType(KeyEvent.VK_ESCAPE);  //don't save exit the dialog
	}
	*/
	@Test
	public void FileSaveAuthenticXMLData() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.setView(View.AUTHENTIC);delay(1000);
		robot.leftClickMenuItem("File", "Save Authentic XML Data as");
		assertForegroundWindow("Save Authentic XML Data File As");
		robot.keyType(KeyEvent.VK_ESCAPE);  //don't save exit the dialog
	}

	@Test
	public void FileSaveGeneratedFilesHTMLXSLT() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File", "Save Generated Files","Save Generated XSLT-HTML");
		assertForegroundWindow("Save Generated XSLT-HTML File As");
		robot.keyType(KeyEvent.VK_ESCAPE);  //don't save exit the dialog
	}
	@Test
	public void FileSaveGeneratedFilesHTML() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File", "Save Generated Files","Save Generated HTML");
		assertForegroundWindow("Save Generated HTML File As");
		robot.keyType(KeyEvent.VK_ESCAPE);  //don't save exit the dialog
	}
	@Test
	public void FileSaveGeneratedFilesRTFXSLT() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File", "Save Generated Files","Save Generated XSLT-RTF");
		assertForegroundWindow("Save Generated XSLT-RTF File As");
		robot.keyType(KeyEvent.VK_ESCAPE);  //don't save exit the dialog
	}
	@Test
	public void FileSaveGeneratedFilesRTF() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File", "Save Generated Files","Save Generated RTF");
		delay(3000);
		assertForegroundWindow("Save Generated RTF File As");
		robot.keyType(KeyEvent.VK_ESCAPE);  //don't save exit the dialog
	}
	@Test
	public void FileSaveGeneratedFilesFOXSLT() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File", "Save Generated Files","Save Generated XSLT-FO");
		assertForegroundWindow("Save Generated XSLT-FO File As");
		robot.keyType(KeyEvent.VK_ESCAPE);  //don't save exit the dialog
	}
	@Test
	public void FileSaveGeneratedFilesFO() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File", "Save Generated Files","Save Generated FO");
		assertForegroundWindow("Save Generated FO File As");
		robot.keyType(KeyEvent.VK_ESCAPE);  //don't save exit the dialog
	}
	@Test
	public void FileSaveGeneratedFilesPDF() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File", "Save Generated Files","Save Generated PDF");
		delay(3000);
		assertForegroundWindow("Save Generated PDF File As");
		robot.keyType(KeyEvent.VK_ESCAPE);  //don't save exit the dialog
	}
	@Test
	public void FileSaveGeneratedFilesWordXSLT() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File", "Save Generated Files","Save Generated XSLT-Word");
		assertForegroundWindow("Save Generated XSLT-Word 2007+ File As");
		robot.keyType(KeyEvent.VK_ESCAPE);  //don't save exit the dialog
	}
	@Test
	public void FileSaveGeneratedFilesWord() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File", "Save Generated Files","Save Generated Word");
		delay(3000);
		assertForegroundWindow("Save Generated Word 2007+ File As");
		robot.keyType(KeyEvent.VK_ESCAPE);  //don't save exit the dialog
	}
	@Test
	public void FileSaveGeneratedFilesDBSchema() {
		robot.openFile(MY_DBSAMPLE_SPS_FILE);
		robot.leftClickMenuItem("File", "Save Generated Files","Save Generated DB Schema");
		assertForegroundWindow("Save Generated DB XML Schema File As");
		robot.keyType(KeyEvent.VK_ESCAPE);  //don't save exit the dialog
	}
	@Test
	public void FileSaveGeneratedFilesDBXMLData() {
		robot.openFile(MY_DBSAMPLE_SPS_FILE);
		robot.leftClickMenuItem("File", "Save Generated Files","Save Generated DB XML Data");
		assertForegroundWindow("Save Generated DB XML Data File As");
		robot.keyType(KeyEvent.VK_ESCAPE);  //don't save exit the dialog
	}
	/* removed vom GUI in V2011r2
	@Test
	public void FileAssignWorkingXML() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File", "Assign Working XML File");
		assertForegroundWindow("Assign Working XML file to Schema Source 'XML'...");
		robot.keyType(KeyEvent.VK_ESCAPE);  //don't save exit the dialog
	}
	@Test
	public void FileUnAssignWorkingXML() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File", "Unassign Working XML File");
		assertAreas(DESIGNOVERVIEW);
	}
	@Test
	public void FileAssignTemplateXML() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File", "Assign Template XML File");
		assertForegroundWindow("Assign Template XML file to Schema Source 'XML'...");
		robot.keyType(KeyEvent.VK_ESCAPE);  //don't save exit the dialog
	}
	@Test
	public void FileUnAssignTemplateXML() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File", "Unassign Template XML File");
		assertAreas(DESIGNOVERVIEW);
	}
	*/
	@Test
	public void FileProperties() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File","Properties");
		assertForegroundWindow("Properties");
		robot.keyType(KeyEvent.VK_ESCAPE);  //don't save exit the dialog
	}
	@Test
	public void FilePrintPreview() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File","Print Preview");
		delay(15000);
		assertForegroundWindow("Print Preview");
		robot.keyType(KeyEvent.VK_ESCAPE);  //exit the dialog
	}
	@Test
	public void FilePrint() {
		robot.openFile(MY_ORGCHART_SPS_FILE);
		robot.leftClickMenuItem("File","Print");
		delay(15000);
		assertForegroundWindow("Print");
		robot.keyType(KeyEvent.VK_ESCAPE);  //exit the dialog
	}
}
