package com.altova.diffdog;
import org.junit.Test;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOError;
import java.util.concurrent.ExecutionException;

import static java.awt.event.KeyEvent.*;

import com.altova.robots.ImageUtils;
import com.altova.util.IOUtils;
import static com.altova.robots.SnapshotArea.CommonArea.*;


public class URLSupportTest extends AbstractDiffDogTest{

	String http = "http://qa-w2k3/webdav/krb/diffdog/";
	String http_auth ="http://qa-w2k3/test_auth/krb/diffdog/"; // (u:test, p:test)
	String http_auth_pass = "http://test:test@qa-w2k3/test_auth/krb/diffdog/";
	String https = "https://qa-w2k3/webdav/krb/diffdog/";
	String https_auth = "https://qa-w2k3/test_auth/";
	//String	share point server	https://vietspstest/Docs/Documents/krb/diffdog
	//Share point need user and possword from domain
	String	ftp = "ftp://qa-w2k3/krb/diffdog/";
	String	ftp_auth = "ftp://qa-w2k3/krb/";
	String	ftp_auth_pass = "ftp://test:test@qa-w2k3/krb/";
	String url =http;
	
	
	/********************************************************************************
	 * 																				*
	 * ******************************  HTTP  ***************************************
	 * 																				*
	 ********************************************************************************/

	@Test
	public void testCompareXMLFiles_HTTP(){
		robot.compareFiles(url + "LeftSide/attr1.xml",url + "RightSide/attr2.xml" );
		assertAreas(MF_MAIN_WINDOW);	
	}
	
	@Test
	public void testCompareDirecories_HTTP(){
		robot.compare2Directories(url + "LeftSide/DirDiff_2",url + "RightSide/DirDiff_2");
		assertAreas(MF_MAIN_WINDOW);	
	}
	@Test
	public void testOpenSchemaComparisonFile_HTTP(){
		robot.openComparisonFileURL(url + "LeftSide/ComparisonFiles/XMLSchemaComparison_valid_1.xsdif","","");
		assertAreas(MF_MAIN_WINDOW);	
	}


	@Test
	public void testOpenDataBaseDataComparisonFile(){
		robot.openComparisonFile(http + "LeftSide/ComparisonFiles/LocalDatabase.dbdif");
		assertAreas(MF_MAIN_WINDOW);	
	}
	
	@Test
	public void testOpenDataBaseSchemaComparisonFile(){
		robot.openComparisonFile(http + "LeftSide/ComparisonFiles/DatabaseSchemaComparison_Local.dbsdif");
		assertAreas(MF_MAIN_WINDOW);	
	}
	
	@Test
	public void testDirectoryComparisonAllComparisonMode_HTTP(){
		robot.compare2Directories(url + "LeftSide/DirDiff",http + "RightSide/DirDiff");
		robot.setQuickComparison(false);
		delay(500);
		robot.setCompareAsTXT();
		assertAreas(getTestName() + "_TXT" , DIFF_DOG_UP_WINDOW);
		robot.setCompareAsXML();
		assertAreas(getTestName() + "_XML" , DIFF_DOG_UP_WINDOW);
		robot.setCompareAsBinary();
		assertAreas(getTestName() + "_BINARY" , DIFF_DOG_UP_WINDOW);
		robot.setCompareAccordingToFileExtensionSettings();
		assertAreas(getTestName() + "_EXT" , DIFF_DOG_UP_WINDOW);
		robot.setQuickComparison(true);
		assertAreas(getTestName() + "_QUICK" , DIFF_DOG_UP_WINDOW);
	}

	@Test
	public void testShowFilesInZipOFF_HTTP(){
		robot.compare2Directories(url + "LeftSide/DirDiff",url + "RightSide/DirDiff");
		robot.setShowFilesInZip(false);
		assertAreas(DIFF_DOG_UP_WINDOW);
	}
	
	@Test
	public void testShowFilesInZipON_HTTP(){
		robot.compare2Directories(url + "LeftSide/DirDiff_ZIP",url + "RightSide/DirDiff_ZIP");
		robot.setShowFilesInZip(true);
		delay(50000);
		assertAreas(DIFF_DOG_UP_WINDOW);
	}
	
	@Test
	public void testIncludeSubdirectoriesOFF_HTTP(){
		robot.compare2Directories(url + "LeftSide/DirDiff_ZIP",url + "RightSide/DirDiff_ZIP");
		robot.setDirectoryComparPanel(2,2,2,2,2,2,0);
		delay(5000);
		assertAreas(DIFF_DOG_UP_WINDOW);
	}
	
	@Test
	public void testIncludeSubdirectoriesON_HTTP(){
		robot.compare2Directories(url + "LeftSide/DirDiff_ZIP",url + "RightSide/DirDiff_ZIP");
		robot.setDirectoryComparPanel(2,2,2,2,2,2,1);
		delay(5000);
		assertAreas(DIFF_DOG_UP_WINDOW);
	}
	
	@Test
	public void testOpenXMLSchemas_HTTP(){
		robot.compareXMLSchemass(url +"LeftSide/ComparisonFiles/DB2schema.xsd" , "Altova", url +"RightSide/ComparisonFiles/DB2schema.xsd", "Altova");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testSaveAsXMLSchemas_HTTP(){
		robot.compareXMLSchemass(url +"LeftSide/ComparisonFiles/DB2schema.xsd" , "Altova", url +"RightSide/ComparisonFiles/DB2schema.xsd", "Altova");
		robot.saveAs("c:\\temp\\debug\\file.xsdif");
		robot.closeAll();
		robot.openComparisonFile("c:\\temp\\debug\\file.xsdif");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testCompare2DocxFiles_HTTP(){
		robot.compareWordDocuments(url +"LeftSide/WordComparison/Bewerbung_Nationalteam_2010_1.docx",
				url +"RightSide/WordComparison/Text_Whitespace.doc");
		try{
			//2 lines after, because there are some problems with office activation
			delay(15000); 
			robot.escapeDialog("Microsoft Office Activation Wizard", VK_C);
		}catch (Exception e){}	
		
		assertAreas(MF_MAIN_WINDOW);
	}

	@Test
	public void testExportDifferencesToXML_HTTP(){
		robot.compareFiles(url + "LeftSide/attr1.xml",url + "RightSide/attr2.xml" );
		try{
			File file = new File("c:\\temp\\debug\\diff1.xml");
			if (file.exists())
				file.delete();
			robot.exportDifferences("c:\\temp\\debug\\diff1.xml");
			assertFileExists(new File("c:\\temp\\debug\\diff1.xml"));
		}catch (IOError e){}
		

	}
	
	@Test
	public void testExportDifferencesToTXT_HTTP(){
		robot.compareFiles(url + "LeftSide/EdgarAllanPoe.txt",url + "RightSide/EdgarAllanPoe.txt" );
		try{
			File file = new File("c:\\temp\\debug\\diff1.xml");
			if (file.exists())
				file.delete();
			robot.exportDifferences("c:\\temp\\debug\\diff1.xml");
			assertFileExists(new File("c:\\temp\\debug\\diff1.xml"));
		}catch (IOError e){}

	}
	
	/********************************************************************************
	 * 																				*
	 * ******************************  http_auth  ***********************************
	 * 																				*
	 ********************************************************************************/
	

	@Test
	public void testCompareXMLFiles_http_auth(){
		robot.compareURLFiles(http_auth + "LeftSide/attr1.xml","test", "test",http_auth + "RightSide/attr2.xml","test","test" );
		assertAreas(MF_MAIN_WINDOW);	
	}
	
	@Test
	public void testCompareDirecories_http_auth(){
		robot.compareURLDirecotries(http_auth + "LeftSide/DirDiff","test","test",http_auth + "RightSide/DirDiff","test","test");
		assertAreas(MF_MAIN_WINDOW);	
	}
	
	@Test
	public void testOpenSchemaComparisonFile_http_auth(){
		robot.openComparisonFile(http_auth_pass + "LeftSide/ComparisonFiles/XMLSchemaComparison_valid_1.xsdif");
		assertAreas(MF_MAIN_WINDOW);	
	}


	//Save and Save as to URL doesn't work
	
	@Test
	public void testDirectoryComparisonAllComparisonMode_http_auth(){
		robot.compareURLDirecotries(http_auth + "LeftSide/DirDiff","test","test",http_auth + "RightSide/DirDiff","test","test");
		robot.setShowFilesInZip(false);
		robot.setQuickComparison(false);
		delay(2000);
		robot.setCompareAsTXT();
		assertAreas(getTestName() + "_TXT" , MF_MAIN_WINDOW);
		robot.setCompareAsXML();
		assertAreas(getTestName() + "_XML" , MF_MAIN_WINDOW);
		robot.setCompareAsBinary();
		assertAreas(getTestName() + "_BINARY" , MF_MAIN_WINDOW);
		robot.setCompareAccordingToFileExtensionSettings();
		assertAreas(getTestName() + "_EXT" , MF_MAIN_WINDOW);
		robot.setQuickComparison(true);
		assertAreas(getTestName() + "_QUICK" , MF_MAIN_WINDOW);
	}
	
	@Test
	public void testShowFilesInZipOFF_http_auth(){
		robot.compareURLDirecotries(http_auth + "LeftSide/DirDiff","test","test",http_auth + "RightSide/DirDiff","test","test");
		robot.setQuickComparison(true);
		robot.setShowFilesInZip(false);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testShowFilesInZipON_http_auth(){
		robot.compareURLDirecotries(http_auth + "LeftSide/DirDiff","test","test",http_auth + "RightSide/DirDiff","test","test");
		robot.setShowFilesInZip(true);
		delay(5000);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testIncludeSubdirectoriesOFF_http_auth(){
		robot.compareURLDirecotries(http_auth + "LeftSide/DirDiff_ZIP","test","test",http_auth + "RightSide/DirDiff_ZIP","test","test");
		robot.setDirectoryComparPanel(2,2,2,2,2,2,0);
		delay(5000);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testIncludeSubdirectoriesON_http_auth(){
		robot.compareURLDirecotries(http_auth + "LeftSide/DirDiff_ZIP","test","test",http_auth + "RightSide/DirDiff_ZIP","test","test");
		robot.setDirectoryComparPanel(2,2,2,2,2,2,1);
		delay(5000);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testOpenXMLSchemas_http_auth(){
		robot.compareXMLSchemassURL(http_auth_pass +"LeftSide/ComparisonFiles/DB2schema.xsd" , "Altova", http_auth +"RightSide/ComparisonFiles/DB2schema.xsd", "Altova");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testSaveAsXMLSchemas_http_auth(){
		robot.compareXMLSchemass(http_auth_pass +"LeftSide/ComparisonFiles/DB2schema.xsd" , "Altova", http_auth_pass +"RightSide/ComparisonFiles/DB2schema.xsd", "Altova");
		robot.saveAs("c:\\temp\\debug\\file.xsdif");
		robot.closeAll();
		robot.openComparisonFile("c:\\temp\\debug\\file.xsdif");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testCompare2DocxFiles_http_auth(){
		try {
			robot.openWordComparison();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.compareURLFiles(http_auth +"LeftSide/WordComparison/Chart.docx", "test", "test", http_auth +"RightSide/WordComparison/Chart.docx", "test","test");
		robot.startComparison();
		robot.copyFromLeft();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testExportDifferencesToXML_http_auth(){
		robot.compareFiles(http_auth_pass + "LeftSide/attr1.xml",http_auth_pass + "RightSide/attr2.xml" );
		robot.exportDifferences("c:\\temp\\debug\\diff1.xml");
		assertFileExists(new File("c:\\temp\\debug\\diff1.xml"));

	}
	
	@Test
	public void testExportDifferencesToTXT_http_auth(){
		robot.compareFiles(http_auth_pass + "LeftSide/EdgarAllanPoe.txt",http_auth_pass + "RightSide/EdgarAllanPoe.txt" );
		robot.exportDifferences("c:\\temp\\debug\\diff1.xml");
		assertFileExists(new File("c:\\temp\\debug\\diff1.xml"));
	}
	
	/********************************************************************************
	 * 																				*
	 * ******************************  FTP  ***************************************
	 * 																				*
	 ********************************************************************************/
	
	@Test
	public void testCompareXMLFiles_FTP(){
		robot.compareFiles(ftp + "LeftSide/attr1.xml",ftp + "RightSide/attr2.xml" );
		assertAreas(MF_MAIN_WINDOW);	
	}
	
	@Test
	public void testCompareDirecories_FTP(){
		robot.compare2Directories(ftp + "LeftSide/DirDiff",ftp + "RightSide/DirDiff");
		assertAreas(MF_MAIN_WINDOW);	
	}
	
	@Test
	public void testOpenSchemaComparisonFile_FTP(){
		robot.openComparisonFileURL(ftp + "LeftSide/ComparisonFiles/XMLSchemaComparison_valid_1.xsdif","","");
		assertAreas(MF_MAIN_WINDOW);	
	}


	@Test
	public void testDirectoryComparisonAllComparisonMode_FTP(){
		robot.compare2Directories(ftp + "LeftSide/DirDiff",ftp + "RightSide/DirDiff");
		robot.setQuickComparison(false);
		robot.setCompareAsTXT();
		assertAreas(getTestName() + "_TXT" , MF_MAIN_WINDOW);
		robot.setCompareAsXML();
		assertAreas(getTestName() + "_XML" , MF_MAIN_WINDOW);
		robot.setCompareAsBinary();
		assertAreas(getTestName() + "_BINARY" , MF_MAIN_WINDOW);
		robot.setCompareAccordingToFileExtensionSettings();
		assertAreas(getTestName() + "_EXT" , MF_MAIN_WINDOW);
		robot.setQuickComparison(true);
		assertAreas(getTestName() + "_QUICK" , MF_MAIN_WINDOW);
	}
	
	@Test
	public void testShowFilesInZipOFF_FTP(){
		robot.compare2Directories(ftp + "LeftSide/DirDiff",ftp + "RightSide/DirDiff");
		robot.setShowFilesInZip(false);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testShowFilesInZipON_FTP(){
		robot.compare2Directories(ftp + "LeftSide/DirDiff",ftp + "RightSide/DirDiff");
		robot.setShowFilesInZip(true);
		delay(5000);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testIncludeSubdirectoriesOFF_FTP(){
		robot.compare2Directories(ftp + "LeftSide/DirDiff_ZIP",ftp + "RightSide/DirDiff_ZIP");
		robot.setDirectoryComparPanel(2,2,2,2,2,2,0);
		delay(5000);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testIncludeSubdirectoriesON_FTP(){
		robot.compare2Directories(ftp + "LeftSide/DirDiff_ZIP",ftp + "RightSide/DirDiff_ZIP");
		robot.setDirectoryComparPanel(2,2,2,2,2,2,1);
		delay(5000);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testOpenXMLSchemas_FTP(){
		robot.compareXMLSchemassURL(ftp +"LeftSide/ComparisonFiles/DB2schema.xsd" , "Altova", ftp +"RightSide/ComparisonFiles/DB2schema.xsd", "Altova");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testSaveAsXMLSchemas_FTP(){
		robot.compareXMLSchemassURL(ftp +"LeftSide/ComparisonFiles/DB2schema.xsd" , "Altova", ftp +"RightSide/ComparisonFiles/DB2schema.xsd", "Altova");
		robot.saveAs("c:\\temp\\debug\\file.xsdif");
		robot.closeAll();
		robot.openComparisonFile("c:\\temp\\debug\\file.xsdif");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testCompare2DocxFiles_FTP(){
		robot.compareWordDocuments(ftp +"LeftSide/WordComparison/Chart.docx",ftp +"RightSide/WordComparison/Chart.docx");
		robot.startComparison();
		robot.copyFromLeft();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testExportDifferencesToXML_FTP(){
		robot.compareFiles(ftp + "LeftSide/attr1.xml",ftp + "RightSide/attr2.xml" );
		robot.exportDifferences("c:\\temp\\debug\\diff1.xml");
		assertFileExists(new File("c:\\temp\\debug\\diff1.xml"));

	}
	
	@Test
	public void testExportDifferencesToTXT_FTP(){
		robot.compareFiles(ftp + "LeftSide/EdgarAllanPoe.txt",ftp + "RightSide/EdgarAllanPoe.txt" );
		robot.exportDifferences("c:\\temp\\debug\\diff1.xml");
		assertFileExists(new File("c:\\temp\\debug\\diff1.xml"));

	}
	
	/********************************************************************************
	 * 																				*
	 * ******************************  ftp_auth  ***********************************
	 * 																				*
	 ********************************************************************************/
	

	@Test
	public void testCompareXMLFiles_ftp_auth(){
		robot.compareURLFiles(ftp_auth + "LeftSide/attr1.xml","test", "test",ftp_auth + "RightSide/attr2.xml","test","test" );
		assertAreas(MF_MAIN_WINDOW);	
	}
	
	@Test
	public void testCompareDirecories_ftp_auth(){
		robot.compareURLDirecotries(ftp_auth + "LeftSide/DirDiff","test","test",ftp_auth + "RightSide/DirDiff","test","test");
		assertAreas(MF_MAIN_WINDOW);	
	}
	
	@Test
	public void testOpenSchemaComparisonFile_ftp_auth(){
		robot.openComparisonFileURL(ftp_auth_pass + "LeftSide/ComparisonFiles/XMLSchemaComparison_valid_1.xsdif","","");
		assertAreas(MF_MAIN_WINDOW);	
	}
	
	@Test
	public void testDirectoryComparisonAllComparisonMode_ftp_auth(){
		robot.compareURLDirecotries(ftp_auth + "LeftSide/DirDiff","test","test",ftp_auth + "RightSide/DirDiff","test","test");
		robot.setQuickComparison(false);
		delay(2000);
		robot.setCompareAsTXT();
		assertAreas(getTestName() + "_TXT" , MF_MAIN_WINDOW);
		robot.setCompareAsXML();
		assertAreas(getTestName() + "_XML" , MF_MAIN_WINDOW);
		robot.setCompareAsBinary();
		assertAreas(getTestName() + "_BINARY" , MF_MAIN_WINDOW);
		robot.setCompareAccordingToFileExtensionSettings();
		assertAreas(getTestName() + "_EXT" , MF_MAIN_WINDOW);
		robot.setQuickComparison(true);
		assertAreas(getTestName() + "_QUICK" , MF_MAIN_WINDOW);
	}
	
	@Test
	public void testShowFilesInZipOFF_ftp_auth(){
		robot.compareURLDirecotries(ftp_auth + "LeftSide/DirDiff","test","test",ftp_auth + "RightSide/DirDiff","test","test");
		robot.setShowFilesInZip(false);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testShowFilesInZipON_ftp_auth(){
		robot.compareURLDirecotries(ftp_auth + "LeftSide/DirDiff","test","test",ftp_auth + "RightSide/DirDiff","test","test");
		robot.setShowFilesInZip(true);
		delay(5000);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testIncludeSubdirectoriesOFF_ftp_auth(){
		robot.compareURLDirecotries(ftp_auth + "LeftSide/DirDiff_ZIP","test","test",ftp_auth + "RightSide/DirDiff_ZIP","test","test");
		robot.setDirectoryComparPanel(2,2,2,2,2,2,0);
		delay(5000);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testIncludeSubdirectoriesON_ftp_auth(){
		robot.compareURLDirecotries(ftp_auth + "LeftSide/DirDiff_ZIP","test","test",ftp_auth + "RightSide/DirDiff_ZIP","test","test");
		robot.setDirectoryComparPanel(2,2,2,2,2,2,1);
		delay(5000);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testOpenXMLSchemas_ftp_auth(){
		robot.compareXMLSchemassURL(ftp_auth_pass +"LeftSide/ComparisonFiles/DB2schema.xsd" , "Altova", ftp_auth_pass +"RightSide/ComparisonFiles/DB2schema.xsd", "Altova");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testSaveAsXMLSchemas_ftp_auth(){
		robot.compareXMLSchemassURL(ftp_auth_pass +"LeftSide/ComparisonFiles/DB2schema.xsd" , "Altova", ftp_auth_pass +"RightSide/ComparisonFiles/DB2schema.xsd", "Altova");
		robot.saveAs("c:\\temp\\debug\\file.xsdif");
		robot.closeAll();
		robot.openComparisonFile("c:\\temp\\debug\\file.xsdif");
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testCompare2DocxFiles_ftp_auth(){
		try {
			robot.openWordComparison();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.compareURLFiles(ftp_auth +"LeftSide/WordComparison/Chart.docx", "test", "test", ftp_auth +"RightSide/WordComparison/Chart.docx", "test","test");
		robot.startComparison();
		robot.copyFromLeft();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testExportDifferencesToXML_ftp_auth(){
		robot.compareFiles(ftp_auth_pass + "LeftSide/attr1.xml",ftp_auth_pass + "RightSide/attr2.xml" );
		robot.exportDifferences("c:\\temp\\debug\\diff1.xml");
		assertFileExists(new File("c:\\temp\\debug\\diff1.xml"));

	}
	
	@Test
	public void testExportDifferencesToTXT_ftp_auth(){
		robot.compareFiles(ftp_auth_pass + "LeftSide/EdgarAllanPoe.txt",ftp_auth_pass + "RightSide/EdgarAllanPoe.txt" );
		robot.exportDifferences("c:\\temp\\debug\\diff1.xml");
		assertFileExists(new File("c:\\temp\\debug\\diff1.xml"));
	}
	
}
