package com.altova.mapforce;


import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

import com.altova.nativegui.NativeGUI;
import com.altova.robots.CheckboxOption;
import com.altova.robots.DropDownOption;

import com.altova.robots.Options;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;
import com.altova.util.IOUtils;
import static com.altova.robots.ImageRecognitionRobot.*;

import static com.altova.robots.SnapshotArea.CommonArea.MF_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.PRJ_WINDOW_MAPFORCE;
import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;
import static com.altova.mapforce.MapForceRobot.MESSAGES;

public class ProjectMenuTest extends AbstractMapForceTest{
	
	private static final File WEBSERVICE_MFD =new File(FILE_OUTPUT_PATH.getAbsolutePath()+"\\testCreateMappingForOperation.mfd");
	private static final File POSSIBLE_VALUES_MFD = IOUtils.findFile("examples/PossibleValues.mfd");
	private static final File CODE_GEN_JAVACSHARP_PRJ=IOUtils.findFile("examples/testGenerateCodeInPrj.mfp");
	private static final File XSLT_CODE_GEN_PRJ=IOUtils.findFile("examples/testGenerateCodeXSLT.mfp");
	
	public void createNewProject()  {
		
		robot.newMFFile("Project File");
		delay(1000);
		robot.escapeDialog("The current project has been modified. Would you like to save it before closing?", KeyEvent.VK_N);
		delay(2000);
		robot.keyType(KeyEvent.VK_RIGHT);
		robot.typeStringEnter(PROJECT_SAVED_MFP.getAbsolutePath());
		delay(2000);
		robot.escapeDialog("Do you want to replace it?", KeyEvent.VK_Y);
	}
	
	
	@Test
	public void testAddFilesToProject(){
		createNewProject();
		robot.addFilesToProject(UPSRATES_WSDL_FILE.getAbsolutePath());
		delay(1000);
		robot.keyType(KeyEvent.VK_RIGHT);
		delay(200);
		robot.keyType(KeyEvent.VK_RIGHT);
		delay(200);
		robot.keyType(KeyEvent.VK_RIGHT);
		assertAreas(PRJ_WINDOW_MAPFORCE);
	}
	
	
	@Test
	public void testAddActiveFileToProject(){
		createNewProject();
		robot.openFile(EDI_ORDER_REVERSE_MFD);
		robot.addActiveFileToProject();
		delay(1000);
		robot.keyType(KeyEvent.VK_RIGHT);
		delay(200);
		robot.keyType(KeyEvent.VK_RIGHT);
		delay(200);
		robot.keyType(KeyEvent.VK_RIGHT);
		delay(200);
		robot.mouseMove(50, 50);
		assertAreas(PRJ_WINDOW_MAPFORCE);
	}
	
	@Test
	public void testAddFolderToProject_defaultSettings(){
		createNewProject();
		RadioOption a=new RadioOption("Use default project settings",null,null,null,null,WINDOWS_DEFAULT_FONT);
		robot.createFolderInProject("test_folder",a);
		delay(1000);
		robot.keyType(KeyEvent.VK_RIGHT);
		delay(200);
		assertAreas(PRJ_WINDOW_MAPFORCE);
	}
	
	@Test
	public void testOpenMapping(){
		createNewProject();
		robot.addFilesToProject(EDI_ORDER_REVERSE_MFD.getAbsolutePath());
		//we have to expand all the project in case it is not and get to the mapping
		for(int i=1;i<7;i++) {
			robot.keyType(KeyEvent.VK_PLUS);
			delay(500);
		}
		robot.openMapping();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testCreateMappingForOperation(){
		if(WEBSERVICE_MFD.exists()){
			WEBSERVICE_MFD.delete();
		}
		if(WEBSERVICE_PROJECT_MFP.exists()){
			WEBSERVICE_PROJECT_MFP.delete();
		}
		robot.newMFFile("Web Service");
		CheckboxOption opt = new CheckboxOption("Automatically generate mapping",false,null,null,null,null,WINDOWS_DEFAULT_FONT);
		robot.insertWebServiceDialog(UPSRATES_WSDL_FILE, opt);
		assertEquals("Save Project As",NativeGUI.getForegroundWindowInfo().getWindowText());
		robot.typeStringEnter(WEBSERVICE_PROJECT_MFP.getAbsolutePath());
		delay(1000);
		//We select the file name in the project window and then select the last operation
		robot.leftClickMid(robot.findInProjectWindow(UPSRATES_WSDL_FILE.getName()));
		robot.keyType(KeyEvent.VK_END);
		robot.createMappingForOperation(WEBSERVICE_MFD);
		assertFileExists(WEBSERVICE_MFD);
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testAddMappingFileForOperation(){
		if(WEBSERVICE_PROJECT_MFP.exists()){
			WEBSERVICE_PROJECT_MFP.delete();
		}
		robot.newMFFile("Web Service");
		CheckboxOption opt = new CheckboxOption("Automatically generate mapping",false,null,null,null,null,WINDOWS_DEFAULT_FONT);
		robot.insertWebServiceDialog(UPSRATES_WSDL_FILE, opt);
		assertEquals("Save Project As",NativeGUI.getForegroundWindowInfo().getWindowText());
		robot.typeStringEnter(WEBSERVICE_PROJECT_MFP.getAbsolutePath());
		delay(1000);
		//We select the file name in the project window and then select the last operation
		robot.leftClickMid(robot.findInProjectWindow(UPSRATES_WSDL_FILE.getName()));
		robot.keyType(KeyEvent.VK_END);
		robot.addMappingFileForOperation(POSSIBLE_VALUES_MFD);
		delay(2000);
		robot.leftClickMid(robot.findInProjectWindow("UPSRatesSoap"));
		delay(500);
		robot.keyType(KeyEvent.VK_END);
		delay(500);
		robot.keyType(KeyEvent.VK_PLUS);
		assertAreas(PRJ_WINDOW_MAPFORCE);
	}
	
	@Ignore //This item is not existing anymore in the project 
	@Test
	public void testRemoveProjectItem(){
		createNewProject();
		robot.addFilesToProject(EDI_ORDER_REVERSE_MFD.getAbsolutePath());
		//we have to expand all the project in case it is not and get to the mapping
		for(int i=1;i<7;i++) {
			robot.keyType(KeyEvent.VK_PLUS);
			delay(500);
		}
		robot.removeProjectItem();
		delay(500);
		assertAreas(PRJ_WINDOW_MAPFORCE);
	}
	
	
	@Test
	public void testInsertWebService(){
		createNewProject();
		DropDownOption lng=new DropDownOption("Code generation language", false, "C#", null, null, null,null,WINDOWS_DEFAULT_FONT);
		lng.setX1(30);
		robot.insertWebService(UPSRATES_WSDL_FILE, lng);
		assertAreas(PRJ_WINDOW_MAPFORCE);
	}
	
	@Test
	public void testGenerateCodeForEntireProject(){
		File outCode=new File(FILE_OUTPUT_PATH, "EntireProject");
		
		if(outCode.exists()){
		IOUtils.deleteAll(outCode);
		assertFileNotExists(outCode);
		}
		robot.openFile(CODE_GEN_JAVACSHARP_PRJ);
//		DropDownOption lng=new DropDownOption("Code generation language","C#");
//		lng.setX1(30);
//		robot.insertWebService(UPSRATES_WSDL_FILE, lng);
		robot.generateCodeForEntireProject();
		delay(4000);
		assertFileExists(new File(outCode,"build.xml"));
		assertFileExists(new File(outCode,".project"));
		assertFileExists(new File(outCode,"testGenerateCodeInPrj.jpx"));
		assertFileExists(new File(outCode,"META-INF\\UPSRates.wsdl"));
		assertFileExists(new File(outCode,"com\\mapforce\\MappingMapToUPSRates_wsdl.java"));//changed
		assertFileExists(new File(outCode,"com\\mapforce\\UPSRatesWebService.java"));
		assertFileExists(new File(outCode,"com\\mapforce\\MappingMapToUPSRates_wsdl2.java"));
		assertFileExists(new File(outCode,"com\\altova\\mapforce\\IMFNode.java"));
		assertMapForceMessageWindow(robot);
	}
	
	@Test
	public void testGenerateCodeInJava(){
		File outCode=new File(FILE_OUTPUT_PATH, "JavaCodeGen");
		
		if(outCode.exists()){
		IOUtils.deleteAll(outCode);
		assertFileNotExists(outCode);
		}
		robot.openFile(CODE_GEN_JAVACSHARP_PRJ);
		Options options=new Options();
		TextFieldOption outName=new TextFieldOption("  Output Name:",false,"testGenerateCodeInJava","Output Settings",null,null,null,WINDOWS_DEFAULT_FONT);
		outName.setX2(50);
		options.add(outName);
		TextFieldOption outDir=new TextFieldOption(" Output Directory:",false,outCode.getAbsolutePath(),"Output Settings",null,null,null,WINDOWS_DEFAULT_FONT);
		outDir.setX2(40);
		options.add(outDir);
		
		options.add(new TextFieldOption("Base package name:",false,"com.test",null,null,null,null,WINDOWS_DEFAULT_FONT));
		robot.projectProperties(options);
		robot.generateCodeForProjectIn("Java");
		delay(4000);
		assertFileExists(new File(outCode,"build.xml"));
		assertFileExists(new File(outCode,".project"));
		assertFileExists(new File(outCode,"testGenerateCodeInJava.jpx"));
		assertFileExists(new File(outCode,"META-INF\\UPSRates.wsdl"));
		assertFileExists(new File(outCode,"com\\test\\UPSRatesWebService.java"));
		assertFileExists(new File(outCode,"com\\test\\MappingMapToPossibleValues.java"));
		assertFileExists(new File(outCode,"com\\test\\MappingMapToGetShippingRate.java"));
		assertFileExists(new File(outCode,"com\\altova\\mapforce\\IMFNode.java"));
		assertMapForceMessageWindow(robot);
	}
	
	@Test
	public void testGenerateCodeInCSharp(){
		File outCode=new File(FILE_OUTPUT_PATH, "CSharpCodeGen");
		
		if(outCode.exists()){
		IOUtils.deleteAll(outCode);
		assertFileNotExists(outCode);
		}
		robot.openFile(CODE_GEN_JAVACSHARP_PRJ);
		Options options=new Options();
		TextFieldOption outName=new TextFieldOption("Output Name:",false,"testGenerateCodeInCSharp",null,null,null,null,WINDOWS_DEFAULT_FONT);
		outName.setX2(50);
		options.add(outName);
		TextFieldOption outDir=new TextFieldOption("Output Directory:",false,outCode.getAbsolutePath(),null,null,null,null,WINDOWS_DEFAULT_FONT);
		outDir.setX2(40);
		options.add(outDir);
		robot.projectProperties(options);
		robot.generateCodeForProjectIn("C#");
		delay(4000);
		assertFileExists(new File(outCode,"Altova\\Altova.csproj"));
		assertFileExists(new File(outCode,"AltovaFunctions\\AltovaFunctions.csproj"));
		assertFileExists(new File(outCode,"AltovaXML\\AltovaXML.csproj"));
		assertFileExists(new File(outCode,"testGenerateCodeInCSharp\\UPSRates.wsdl"));
		assertFileExists(new File(outCode,"testGenerateCodeInCSharp\\testGenerateCodeInCSharp_webservice.sln"));
		assertFileExists(new File(outCode,"testGenerateCodeInCSharp\\App_Code\\MappingMapToGetShippingRate.cs"));
		assertFileExists(new File(outCode,"testGenerateCodeInCSharp\\App_Code\\MappingMapToPossibleValues.cs"));
		assertMapForceMessageWindow(robot);
	}
	
	@Test
	public void testGenerateCodeInXSLT1(){
		File outCode=new File(FILE_OUTPUT_PATH, "XSLT1CodeGen");
		
		if(outCode.exists()){
		IOUtils.deleteAll(outCode);
		assertFileNotExists(outCode);
		}
		robot.openFile(XSLT_CODE_GEN_PRJ);
		robot.projectProperties(null);
		robot.generateCodeForProjectIn("XSLT 1.0");
		delay(4000);
		assertFileExists(new File(outCode,"DoTransform.bat"));
		assertFileExists(new File(outCode,"testGenerateCodeXSLT1MapToShortInfo.xslt"));
		assertMapForceMessageWindow(robot);
	}
	
	@Test
	public void testGenerateCodeInXSLT2(){
		File outCode=new File(FILE_OUTPUT_PATH, "XSLT2CodeGen");
		
		if(outCode.exists()){
		IOUtils.deleteAll(outCode);
		assertFileNotExists(outCode);
		}
		robot.openFile(XSLT_CODE_GEN_PRJ);
		Options options=new Options();
		TextFieldOption outName=new TextFieldOption("Output Name:",false,"testGenerateCodeXSLT2","Output Settings",null,null,null,WINDOWS_DEFAULT_FONT);
		outName.setX2(50);
		options.add(outName);
		TextFieldOption outDir=new TextFieldOption("Output Directory:",false,outCode.getAbsolutePath(),"Output Settings",null,null,null,WINDOWS_DEFAULT_FONT);
		outDir.setX2(40);
		options.add(outDir);
		robot.projectProperties(options);
		robot.generateCodeForProjectIn("XSLT 2.0");
		delay(4000);
		assertFileExists(new File(outCode,"DoTransform.bat"));
		assertFileExists(new File(outCode,"testGenerateCodeXSLT2MapToShortInfo.xslt"));
		assertMapForceMessageWindow(robot);
	}
	
	@Test
	public void testGenerateCodeInXQuery(){
		File outCode=new File(FILE_OUTPUT_PATH, "XQueryCodeGen");
		
		if(outCode.exists()){
		IOUtils.deleteAll(outCode);
		assertFileNotExists(outCode);
		}
		robot.openFile(XSLT_CODE_GEN_PRJ);
		Options options=new Options();
		TextFieldOption outName=new TextFieldOption("Output Name:",false,"testGenerateCodeXQuery","Output Settings",null,null,null,WINDOWS_DEFAULT_FONT);
		outName.setX2(50);
		options.add(outName);
		TextFieldOption outDir=new TextFieldOption("Output Directory:",false,outCode.getAbsolutePath(),"Output Settings",null,null,null,WINDOWS_DEFAULT_FONT);
		outDir.setX2(40);
		options.add(outDir);
		robot.projectProperties(options);
		robot.generateCodeForProjectIn("XQuery");
		delay(4000);
		assertFileExists(new File(outCode,"DoTransform.bat"));
		assertFileExists(new File(outCode,"testGenerateCodeXQueryMapToShortInfo.xq"));
		assertMapForceMessageWindow(robot);
	}
	
	@Test
	public void testGenerateCodeInCplus(){
		File outCode=new File(FILE_OUTPUT_PATH, "C++CodeGen");
		
		if(outCode.exists()){
		IOUtils.deleteAll(outCode);
		assertFileNotExists(outCode);
		}
		robot.openFile(XSLT_CODE_GEN_PRJ);
		Options options=new Options();
		TextFieldOption outName=new TextFieldOption("Output Name:",false,"testGenerateCodeCplus","Output Settings",null,null,null,WINDOWS_DEFAULT_FONT);
		outName.setX2(50);
		options.add(outName);
		TextFieldOption outDir=new TextFieldOption("Output Directory:",false,outCode.getAbsolutePath(),"Output Settings",null,null,null,WINDOWS_DEFAULT_FONT);
		outDir.setX2(40);
		options.add(outDir);
		robot.projectProperties(options);
		robot.generateCodeForProjectIn("C++");
		delay(4000);
		assertFileExists(new File(outCode,"Altova\\Altova.vcproj"));
		assertFileExists(new File(outCode,"AltovaFunctions\\AltovaFunctions.vcproj"));
		assertFileExists(new File(outCode,"AltovaXML\\AltovaXML.vcproj"));
		assertFileExists(new File(outCode,"testGenerateCodeCplus\\testGenerateCodeCplus.vcproj"));
		assertFileExists(new File(outCode,"testGenerateCodeCplus\\testGenerateCodeCplus.sln"));
		assertFileExists(new File(outCode,"testGenerateCodeCplus\\testGenerateCodeCplus.cpp"));
		assertFileExists(new File(outCode,"testGenerateCodeCplus\\MappingMapToShortInfo.cpp"));
		assertMapForceMessageWindow(robot);
	}
	
	@Test
	public void testReloadProject(){
		createNewProject();
		delay(1000);
		robot.addActiveFileToProject();
		robot.reloadProject();
		robot.escapeDialog("Would you like to reload it and lose your modifications", KeyEvent.VK_Y);
		assertAreas(PRJ_WINDOW_MAPFORCE);
	}
	
	@Test
	public void testProjectProperties(){
		File outCode=new File(FILE_OUTPUT_PATH, "NegativeTest");
		
		robot.openFile(CODE_GEN_JAVACSHARP_PRJ);
		Options options =new Options();
		TextFieldOption outName=new TextFieldOption("Output Name:",false,"NegativeTest","Output Settings",null,null,null,WINDOWS_DEFAULT_FONT);
		outName.setX2(50);
		options.add(outName);
		TextFieldOption outDir=new TextFieldOption("Output Directory:",false,outCode.getAbsolutePath(),"Output Settings",null,null,null,WINDOWS_DEFAULT_FONT);
		outDir.setX2(40);
		options.add(outDir);
		DropDownOption lang=new DropDownOption("Language",false,"C++",null,null,null,null,WINDOWS_DEFAULT_FONT);
		lang.setX1(60);
		options.add(lang);
		robot.projectProperties(options);
		robot.generateCodeForEntireProject();
		assertFileNotExists(outCode);
		assertAreas(MESSAGES);
	}
	
}
