package com.altova.spy;

import java.awt.Rectangle;

import java.io.File;
import java.util.concurrent.Delayed;

import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.RadioOption;
import com.altova.util.IOUtils;
import com.altova.util.AltovaJUnitRunner.IgnoreRobots;
import com.altova.util.AltovaJUnitRunner.TestRobot;

import static com.altova.robots.SnapshotArea.CommonArea.*;
import static java.awt.event.KeyEvent.*;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;
import static com.altova.robots.ImageRecognitionRobot.WINDOWS_DEFAULT_FONT;


//@TestRobot(VSnetSpyRobot.class)

public class DigitalSignatureDialog extends AbstractXmlSpyTest{
	
	
public final static SpyPane VALIDATION = new SpyPane("Messages", "Output windows");
protected java.awt.Font currentFont= WINDOWS_DEFAULT_FONT;
protected final String issued_PNG = IOUtils.findFile("res/issued.PNG").getAbsolutePath();
	

	@Test
	public void xmlFileEnvelopedAppend(){
		robot.openFile(CONDITIONAL_XML_FILE);
		robot.textView();
		robot.leftClickMenuItem("XML", "Create XML Signature...");
		robot.setCheckOptions(new CheckboxOption(" Strip whitespaces between XML elements",true,null,null,null,null,currentFont),
						 new RadioOption("None",null,null,null,null,currentFont),
						 new RadioOption("Enveloped",null,null,null,null,currentFont),
						 new CheckboxOption("Append KeyInfo",true,null,null,null,null,currentFont));
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
		
		
	}
			
	@Test
	public void xmlFileEnvelopedNoAppend(){
		robot.openFile(CONDITIONAL_XML_FILE);
		robot.textView();
		robot.leftClickMenuItem("XML", "Create XML Signature...");
		robot.clickButton("Select");
		delay(1500);
		robot.clickButton("OK");
		delay(1500);
		robot.clickButton("OK");
		robot.setCheckOptions(new CheckboxOption(" Strip whitespaces between XML elements",true,null,null,null,null,currentFont),
						 new RadioOption("Canonical XML 1.0 with comments",null,null,null,null,currentFont),
						 new RadioOption(" Enveloping",null,null,null,null,currentFont),
						 new CheckboxOption(" Append KeyInfo",false,null,null,null,null,currentFont));
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}

	@Test	public void xmlFileDetechedTextView(){
		robot.openFile(CONDITIONAL_XML_FILE);
		robot.textView();
		robot.leftClickMenuItem("XML", "Create XML Signature...");
		robot.clickButton("Select");
		delay(1500);
		robot.clickButton("OK");
		delay(1500);
		robot.clickButton("OK");
		robot.setCheckOptions(new CheckboxOption(" Strip whitespaces between XML elements",true,null,null,null,null,currentFont),
						 new RadioOption("Canonical XML 1.1 with comments",null,null,null,null,currentFont),
						 new RadioOption(" Detached",null,null,null,null,currentFont),
						 new CheckboxOption("Append KeyInfo",true,null,null,null,null,currentFont));
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	
	@Test
	public void xmlFileDetechedInvalidFileExtention(){
		robot.openFile(CONDITIONAL_XML_FILE);
		robot.textView();
		robot.leftClickMenuItem("XML", "Create XML Signature...");
		robot.clickButton("Select");
		delay(1500);
		robot.clickButton("OK");
		delay(1500);
		robot.clickButton("OK");
		robot.setCheckOptions(new CheckboxOption(" Strip whitespaces between XML elements",true,null,null,null,null,currentFont),
						 new RadioOption("Detached",null,null,null,null,currentFont),
						 new CheckboxOption("Append KeyInfo",true,null,null,null,null,currentFont));
		robot.keyType(VK_TAB);
		delay(500);
		robot.typeString(".testSig");
		robot.setCheckOptions(new RadioOption("1.1 with comments",null,null,null,null,currentFont),
				new RadioOption("Replace existing file extension",null,null,null,null,currentFont));
		
		robot.clickButton("OK");
		robot.leftClickMenuItem("XML", "Create XML Signature...");
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}


	@Test
	public void xmlFileDetechedRelativeFilePathFalse(){
		robot.openFile(CONDITIONAL_XML_FILE);
		robot.textView();
		robot.leftClickMenuItem("XML", "Create XML Signature...");
		robot.clickButton("Select");
		delay(1500);
		robot.clickButton("OK");
		delay(1500);
		robot.clickButton("OK");
		robot.setCheckOptions(new CheckboxOption(" Strip whitespaces between XML elements",false,null,null,null,null,currentFont),
						 new RadioOption("Detached",null,null,null,null,currentFont),
						 new CheckboxOption("Append KeyInfo",false,null,null,null,null,currentFont));
		robot.keyType(VK_TAB);
		delay(500);
		robot.typeString(".xSig");
		robot.setCheckOptions(new RadioOption("1.1 with comments",null,null,null,null,currentFont),
				new RadioOption("Replace existing file extension",null,null,null,null,currentFont),
				new CheckboxOption("Use relative file path to the signed file",false,null,null,null,null,currentFont));
		
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	@Test
	public void xmlFileDetechedPasswordCanonical1_0(){
		robot.openFile(CONDITIONAL_XML_FILE);
		robot.textView();
		robot.leftClickMenuItem("XML", "Create XML Signature...");
		robot.setCheckOptions(new CheckboxOption("Password",true,null,null,null,null,currentFont));
		robot.keyType(VK_TAB);
		delay(500);
		robot.typeString("12345");
		
				
		robot.setCheckOptions(new CheckboxOption(" Strip whitespaces between XML elements",true,null,null,null,null,currentFont),
						 new RadioOption("Detached",null,null,null,null,currentFont));
		robot.keyType(VK_TAB);
		delay(500);
		robot.typeString(".xSig");
		robot.setCheckOptions(new RadioOption("Canonical XML 1.0",null,null,null,null,currentFont),
				new CheckboxOption("Use relative file path to the signed file",false,null,null,null,null,currentFont));
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	
	
	@Test
	public void xmlFileDetechedBase64Pasword(){
		robot.openFile(Base64_IMG_XML_FILE);
		robot.textView();
		robot.leftClickMenuItem("XML", "Create XML Signature...");
		robot.setCheckOptions(new CheckboxOption("Password",true,null,null,null,null,currentFont));
		robot.keyType(VK_TAB);
		delay(500);
		robot.typeString("Thisisatest");
				
		robot.setCheckOptions(new CheckboxOption(" Strip whitespaces between XML elements",true,null,null,null,null,currentFont),
						 new RadioOption("Detached",null,null,null,null,currentFont));
		robot.keyType(VK_TAB);
		delay(500);
		robot.typeString(".xSig");
		robot.setCheckOptions(new RadioOption("Base64",null,null,null,null,currentFont),
				new CheckboxOption("Use relative file path to the signed file",true,null,null,null,null,currentFont),
				new RadioOption("Replace existing file extension",null,null,null,null,currentFont));
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	
	@Test
	public void passwordToLong(){
		robot.openFile(CONDITIONAL_XML_FILE);
		robot.textView();
		robot.leftClickMenuItem("XML", "Create XML Signature...");
		robot.setCheckOptions(new CheckboxOption("Password",true,null,null,null,null,currentFont));
		robot.keyType(VK_TAB);
		delay(500);
		robot.typeString("ThisPasswordIstooLong");
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
		
	}
	

	@Test
	public void createBase64WithNodAdequateXML(){
		robot.openFile(CONDITIONAL_XML_FILE);
		robot.textView();
		robot.leftClickMenuItem("XML", "Create XML Signature...");
		robot.setCheckOptions(new CheckboxOption("Password",true,null,null,null,null,currentFont));
		robot.keyType(VK_TAB);
		delay(500);
		robot.typeString("12345");
		robot.setCheckOptions(new CheckboxOption(" Strip whitespaces between XML elements",true,null,null,null,null,currentFont),
						 new RadioOption("Detached",null,null,null,null,currentFont));
		robot.keyType(VK_TAB);
		delay(500);
		robot.typeString(".xSig");
		robot.setCheckOptions(new RadioOption("Base64",null,null,null,null,currentFont),
				new CheckboxOption("Use relative file path to the signed file",true,null,null,null,null,currentFont),
				new RadioOption("Replace existing file extension",null,null,null,null,currentFont));
		robot.clickButton("OK");
		delay(1000);
		assertAreas(TOP_WINDOW);
		robot.clickButton("OK");
	}
	

	@Test
	public void checkIfSignatureWindowIsAvailableInXSD(){
		robot.openFile(ADDRESS_XSD_FILE);
		robot.leftClickMenuItem("XML", "Create XML Signature...");
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	@Test
	public void checkIfSignatureWindowIsAvailableInWSDL(){
		robot.openFile(TIMESERVICE2_WSDL_FILE);
		robot.leftClickMenuItem("XML", "Create XML Signature...");
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	@Test
	public void checkIfSignatureWindowIsAvailableInWSDL2(){
		robot.openFile(TIMESERVICE20_WSDL_FILE);
		robot.leftClickMenuItem("XML", "Create XML Signature...");
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	
	@Test
	public void checkIfSignatureWindowIsAvailableInXBRL(){
		robot.openFile(NANONUL_XML_FILE);
		delay(15000);
		delay(15000);
		robot.leftClickMenuItem("XML", "Create XML Signature...");
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	
	@Test
	public void checkIfSignatureWindowIsAvailableInGridView(){
		robot.openFile(JAPANESE_XML_FILE);
		robot.gridView();
		robot.leftClickMenuItem("XML", "Create XML Signature...");
		assertAreas(TOP_WINDOW);
		robot.clickButton("Cancel");
	}
	
	@IgnoreRobots({EclipseSpyRobot.class, VSnetSpyRobot.class})
	@Test
	public void verifySignatureUsingPasswordPositive(){
		robot.openFile(TC_1_12_XSIG_FILE);
		delay(15000);
		delay(15000);
		robot.leftClickMenuItem("XML", "Verify XML Signature...");
		delay(500);
		robot.typeStringEnter("1234567");
		assertAreas(VALIDATION);
	}
	
	@IgnoreRobots({EclipseSpyRobot.class, VSnetSpyRobot.class})
	@Test
	public void verifySignatureUsingPasswordNegative(){
		robot.openFile(TC_1_12_XSIG_FILE);
		robot.leftClickMenuItem("XML", "Verify XML Signature...");
		delay(500);
		robot.typeStringEnter("12345");
		assertAreas(VALIDATION);
	}


	@Test
	@IgnoreRobots({EclipseSpyRobot.class, VSnetSpyRobot.class})
	public void verifySignatureUsingCretificateKeyinfoAppended(){
		robot.openFile(TC_1_10_HELLO_FILE);
		delay(15000);
		delay(15000);
		robot.leftClickMenuItem("XML", "Verify XML Signature...");
		delay(500);
		assertAreas(VALIDATION);
	}

	@Test
	public void verifySignatureUsingCretificateKeyinfoNoAppended(){
		robot.openFile(CONDITIONAL_XML_FILE);
		robot.textView();
		robot.leftClickMenuItem("XML", "Create XML Signature...");
		robot.setCheckOptions(new CheckboxOption("Password",true,null,null,null,null,currentFont));
		robot.setCheckOptions(new CheckboxOption("Certificate",true,null,null,null,null,currentFont));
		robot.clickButton("Select");
		delay(1500);
		robot.clickButton("OK");
		delay(1500);
		robot.clickButton("OK");
		robot.setCheckOptions(new CheckboxOption(" Strip whitespaces between XML elements",true,null,null,null,null,currentFont),
						 new RadioOption("Canonical XML 1.0 with comments",null,null,null,null,currentFont),
						 new RadioOption(" Enveloping",null,null,null,null,currentFont),
						 new CheckboxOption(" Append KeyInfo",false,null,null,null,null,currentFont));
		robot.clickButton("OK");
		robot.leftClickMenuItem("XML", "Verify XML Signature...");
		delay(500);
		robot.clickButton("OK");
		delay(500);
		robot.clickButton("OK");
		assertAreas(VALIDATION);
	}
	
	@Test
	public void handlingSPSFileSignedWithCertificateAndDetachedSignatureFile(){
		robot.openFile(NANONULLORG_SIGNEDWITHCERT_XML);
		//robot.leftClickMenuItem("Authentic", "XML Signature...");
		robot.authenticMenu("XML Signature...");
		robot.clickButton("Select own Certificate...");
		delay(500);
		robot.clickButton("OK");
		delay(500);
		robot.doubleClickOnIcon(issued_PNG);
		delay(500);
		robot.leftClickOnString("DSA",currentFont);
		robot.clickButton("OK");
		delay(500);
		robot.clickButton("Sign Document");
		delay(500);
		robot.clickButton("OK");
		robot.reloadFile();
		robot.clickButton("OK");
		delay(2000);
		assertAreas(TOP_WINDOW);
		robot.clickButton("OK");
		
	}
	
	@Test
	public void modifyDataAndCheckSignature(){
		robot.openFile(NANONULLORG_SIGNEDWITHCERT_XML);
		robot.find("29213");
		robot.clickButton("Cancel");
		robot.typeString("31546");
		delay(500);
		robot.keyTypeShift(VK_TAB);
		delay(500);
		robot.keyTypeShift(VK_TAB);
		robot.typeString("A");
		//robot.leftClickMenuItem("Authentic", "XML Signature...");
		robot.authenticMenu("XML Signature...");
		delay(500);
		robot.clickButton("Sign Document");
		delay(500);
		robot.clickButton("OK");
		robot.reloadFile();
		robot.clickButton("OK");
		delay(2000);
		//robot.leftClickMenuItem("Authentic", "XML Signature...");
		robot.authenticMenu("XML Signature...");
		robot.clickButton("Select own Certificate...");
		delay(500);
		robot.clickButton("OK");
		delay(500);
		robot.doubleClickOnIcon(issued_PNG);
		delay(500);
		robot.leftClickOnString("DSA",currentFont);
		robot.keyType(VK_UP);
		robot.clickButton("OK");
		delay(500);
		robot.clickButton("Sign Document");
		delay(500);
		assertAreas(TOP_WINDOW);
		robot.clickButton("OK");
	}
	
	@Test
	public void removeDetachedSignature(){
		robot.openFile(NANONULLORG_SIGNEDWITHCERT_XML);
		robot.authenticMenu("XML Signature...");
		//robot.leftClickMenuItem("Authentic", "XML Signature...");
		delay(500);
		robot.clickButton("Remove Signature");
		delay(500);
		robot.clickButton("OK");
		robot.reloadFile();
		delay(2000);
		robot.clickButton("OK");
		//robot.leftClickMenuItem("Authentic", "XML Signature...");
		robot.authenticMenu("XML Signature...");
		robot.clickButton("Select own Certificate...");
		delay(500);
		robot.clickButton("OK");
		delay(500);
		robot.doubleClickOnIcon(issued_PNG);
		delay(500);
		robot.leftClickOnString("DSA",currentFont);
		robot.keyType(VK_UP);
		robot.clickButton("OK");
		delay(500);
		robot.clickButton("Sign Document");
		delay(500);
		assertAreas(TOP_WINDOW);
		robot.clickButton("OK");
	}
	
	
	@Test
	public void checkSignatureWithPasswordFalse(){
		robot.openFile(NANONULLORG_SIGNEDWITHPW_XML);
		//robot.leftClickMenuItem("Authentic", "XML Signature...");
		robot.authenticMenu("XML Signature...");
		delay(500);
		robot.typeString("123456");
		robot.clickButton("OK");
		delay(500);
		assertAreas(TOP_WINDOW);
		robot.clickButton("OK");
	}
	
	@Test
	public void checkSignatureWithPasswordTrue(){
		robot.openFile(NANONULLORG_SIGNEDWITHPW_XML);
		//robot.leftClickMenuItem("Authentic", "XML Signature...");
		robot.authenticMenu("XML Signature...");
		delay(500);
		robot.typeString("12345");
		robot.clickButton("OK");
		delay(500);
		assertAreas(TOP_WINDOW);
		robot.clickButton("OK");
	}

	@Test
	public void selectOwnPasswordUsingPassword(){
		robot.openFile(NANONULLORG_SIGNEDWITHPW_XML);
		//robot.leftClickMenuItem("Authentic", "XML Signature...");
		robot.authenticMenu("XML Signature...");
		delay(500);
		robot.typeString("12345");
		robot.clickButton("OK");
		delay(500);
		robot.clickButton("Select own Password...");
		delay(500);
		robot.typeString("123456");
		robot.clickButton("OK");
		assertAreas(TOP_WINDOW);
		robot.clickButton("OK");
	}
	
	@Test
	public void checkSignatureHandlingOfPXFFile(){
		robot.openFile(NANONULLORG_SIGNEDWITHPW_PXF);
		//robot.leftClickMenuItem("Authentic", "XML Signature...");
		robot.authenticMenu("XML Signature...");
		delay(500);
		robot.typeString("12345");
		robot.clickButton("OK");
		delay(500);
		robot.clickButton("Sign Document");
		delay(500);
		assertAreas(TOP_WINDOW);
		robot.clickButton("OK");
	}
	

	
}
