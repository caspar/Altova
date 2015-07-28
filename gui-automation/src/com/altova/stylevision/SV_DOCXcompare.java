package com.altova.stylevision;

import static com.altova.robots.SnapshotArea.CommonArea.*;
import static com.altova.util.LoggerUtils.logger;


import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.Test;
import org.junit.Ignore;

import com.altova.robots.ScriptMistakeException;
import com.altova.util.XMLFileReader;

public class SV_DOCXcompare extends AbstractMSWordTest {
	private static final XMLFileReader myxml = new XMLFileReader("data\\stylevision\\sv_docxcompare_catalog.xml");
	private static final String xInputfile[]=myxml.getAllValueOfNode("test:test-case","test:input-file");
	private static final String xbasefile[]=myxml.getAllValueOfNode("test:test-case","test:basefile");
	private static final String xdescription[]=myxml.getAllValueOfNode("test:test-case","test:description");
	private static final String xfurtherfiles[]=myxml.getAllValueOfNode("test:test-case","test:furtherfiles");

	/**
	 * PDF Compare of Stylevision generated PDF output
	 * Catalog: sv_pdfcompare_catalog.xml
	 * 
	 * open PDF files from CLI Test Output Folder and compare with expected output
	 * i=7 to 396
	 */
	
	@After
	public void CleanUp() {
		try {
		//	robot.escapeDialog("date", KeyEvent.VK_ESCAPE);
			Rectangle r=robot.getMainWindow();
			robot.leftClick(r.x+5, r.y+5);
			robot.closeStrgF4();
			robot.keyType(KeyEvent.VK_ESCAPE);    //Press Escape to close any open msg window
		} catch(ScriptMistakeException e) {
			logger.fine("Could close window - probably already closed: "+e);
		}
	}
/*
	@Test
	public void  test1(){
		int i=0;
		String testfile=xbasefile[i]+xInputfile[i];
		logger.fine("TCASE: "+xdescription[i]);
		robot.openFile(testfile);robot.delay(5000);
		assertAreas(TOP_WINDOW);
	}
	*/

	@Test
	public void test_TC9() {
	int i=7;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC10() {
	int i=8;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC11() {
	int i=9;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC12() {
	int i=10;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC13() {
	int i=11;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC14() {
	int i=12;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC15() {
	int i=13;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }


	@Test
	public void test_TC148() {
	int i=144;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC149() {
	int i=145;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC150() {
	int i=146;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC151() {
	int i=147;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC152() {
	int i=148;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC153() {
	int i=149;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC154() {
	int i=150;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC155() {
	int i=151;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC156() {
	int i=152;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC157() {
	int i=153;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC158() {
	int i=154;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC159() {
	int i=155;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC160() {
	int i=156;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC161() {
	int i=157;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC162() {
	int i=158;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC163() {
	int i=159;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC164() {
	int i=160;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC165() {
	int i=161;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC166() {
	int i=162;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC167() {
	int i=163;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC168() {
	int i=164;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC169() {
	int i=165;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC170() {
	int i=166;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC171() {
	int i=167;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC172() {
	int i=168;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC173() {
	int i=169;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC174() {
	int i=170;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC175() {
	int i=171;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC176() {
	int i=172;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC177() {
	int i=173;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC178() {
	int i=174;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC179() {
	int i=175;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC180() {
	int i=176;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC181() {
	int i=177;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC182() {
	int i=178;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC183() {
	int i=179;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC184() {
	int i=180;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC185() {
	int i=181;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC186() {
	int i=182;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC187() {
	int i=183;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC188() {
	int i=184;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC189() {
	int i=185;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC190() {
	int i=186;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC191() {
	int i=187;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC192() {
	int i=188;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC193() {
	int i=189;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC194() {
	int i=190;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC195() {
	int i=191;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC196() {
	int i=192;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC197() {
	int i=193;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC198() {
	int i=194;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC199() {
	int i=195;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC200() {
	int i=196;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC201() {
	int i=197;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC202() {
	int i=198;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC203() {
	int i=199;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC204() {
	int i=200;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC205() {
	int i=201;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC206() {
	int i=202;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC207() {
	int i=203;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC208() {
	int i=204;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC209() {
	int i=205;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC210() {
	int i=206;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC211() {
	int i=207;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC212() {
	int i=208;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC213() {
	int i=209;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC214() {
	int i=210;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC215() {
	int i=211;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC216() {
	int i=212;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC217() {
	int i=213;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC218() {
	int i=214;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC219() {
	int i=215;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC220() {
	int i=216;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC221() {
	int i=217;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC222() {
	int i=218;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC223() {
	int i=219;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC224() {
	int i=220;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC225() {
	int i=221;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC226() {
	int i=222;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC227() {
	int i=223;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC228() {
	int i=224;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC229() {
	int i=225;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC230() {
	int i=226;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC231() {
	int i=227;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC232() {
	int i=228;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC233() {
	int i=229;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC234() {
	int i=230;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC235() {
	int i=231;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC236() {
	int i=232;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC237() {
	int i=233;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC238() {
	int i=234;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC239() {
	int i=235;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC240() {
	int i=236;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC241() {
	int i=237;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC242() {
	int i=238;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC243() {
	int i=239;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC244() {
	int i=240;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC245() {
	int i=241;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC246() {
	int i=242;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC247() {
	int i=243;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC248() {
	int i=244;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC249() {
	int i=245;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC250() {
	int i=246;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC251() {
	int i=247;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC252() {
	int i=248;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC253() {
	int i=249;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC254() {
	int i=250;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC255() {
	int i=251;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC256() {
	int i=252;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC257() {
	int i=253;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC258() {
	int i=254;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC259() {
	int i=255;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC260() {
	int i=256;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC261() {
	int i=257;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC262() {
	int i=258;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC263() {
	int i=259;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC264() {
	int i=260;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC265() {
	int i=261;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC266() {
	int i=262;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC267() {
	int i=263;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC268() {
	int i=264;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC269() {
	int i=265;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC270() {
	int i=266;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC271() {
	int i=267;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC272() {
	int i=268;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC273() {
	int i=269;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC274() {
	int i=270;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC275() {
	int i=271;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC276() {
	int i=272;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC277() {
	int i=273;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }

	@Test
	public void test_TC279() {
	int i=274;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC280() {
	int i=275;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC281() {
	int i=276;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC282() {
	int i=277;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC283() {
	int i=278;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC284() {
	int i=279;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC285() {
	int i=280;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC286() {
	int i=281;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC287() {
	int i=282;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC288() {
	int i=283;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC289() {
	int i=284;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC290() {
	int i=285;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC291() {
	int i=286;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC292() {
	int i=287;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC293() {
	int i=288;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC294() {
	int i=289;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC295() {
	int i=290;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC296() {
	int i=291;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC297() {
	int i=292;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC298() {
	int i=293;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC299() {
	int i=294;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC300() {
	int i=295;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC301() {
	int i=296;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC302() {
	int i=297;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC303() {
	int i=298;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC304() {
	int i=299;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC305() {
	int i=300;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC306() {
	int i=301;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC307() {
	int i=302;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC308() {
	int i=303;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC309() {
	int i=304;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC310() {
	int i=305;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC311() {
	int i=306;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC312() {
	int i=307;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC313() {
	int i=308;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC314() {
	int i=309;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC315() {
	int i=310;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC316() {
	int i=311;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC317() {
	int i=312;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC318() {
	int i=313;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC319() {
	int i=314;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC320() {
	int i=315;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC321() {
	int i=316;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC322() {
	int i=317;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC323() {
	int i=318;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC324() {
	int i=319;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC325() {
	int i=320;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC326() {
	int i=321;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC327() {
	int i=322;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC328() {
	int i=323;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC329() {
	int i=324;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC330() {
	int i=325;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC331() {
	int i=326;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC332() {
	int i=327;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC333() {
	int i=328;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC334() {
	int i=329;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC335() {
	int i=330;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC336() {
	int i=331;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC337() {
	int i=332;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC338() {
	int i=333;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC339() {
	int i=334;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC340() {
	int i=335;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC341() {
	int i=336;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC342() {
	int i=337;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC343() {
	int i=338;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC344() {
	int i=339;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC345() {
	int i=340;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC346() {
	int i=341;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC347() {
	int i=342;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC348() {
	int i=343;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC349() {
	int i=344;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC350() {
	int i=345;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC351() {
	int i=346;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC352() {
	int i=347;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC354() {
	int i=348;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC355() {
	int i=349;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	public void test_TC356() {
	int i=350;
	  String testfile=xbasefile[i]+xInputfile[i];
	  logger.fine("TCASE: "+xdescription[i]);
	  robot.openFile(testfile);robot.delay(5000);
	  assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC358() {
	 int i=351;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC359() {
	 int i=352;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC360() {
	 int i=353;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC361() {
	 int i=354;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC362() {
	 int i=355;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC363() {
	 int i=356;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC364() {
	 int i=357;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC365() {
	 int i=358;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC366() {
	 int i=359;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC367() {
	 int i=360;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC368() {
	 int i=361;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC369() {
	 int i=362;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC370() {
	 int i=363;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC371() {
	 int i=364;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC372() {
	 int i=365;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC373() {
	 int i=366;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC374() {
	 int i=367;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC375() {
	 int i=368;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC376() {
	 int i=369;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC377() {
	 int i=370;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC378() {
	 int i=371;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC379() {
	 int i=372;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC380() {
	 int i=373;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC381() {
	 int i=374;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC382() {
	 int i=375;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC383() {
	 int i=376;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC384() {
	 int i=377;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC385() {
	 int i=378;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC386() {
	 int i=379;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC387() {
	 int i=380;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC388() {
	 int i=381;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC389() {
	 int i=382;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC390() {
	 int i=383;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC391() {
	 int i=384;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC392() {
	 int i=385;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC393() {
	 int i=386;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC394() {
	 int i=387;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC395() {
	 int i=388;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC396() {
	 int i=389;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC397() {
	 int i=390;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC398() {
	 int i=391;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC399() {
	 int i=392;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC400() {
	 int i=393;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC401() {
	 int i=394;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC402() {
	 int i=395;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }
	@Test
	  public void test_TC403() {
	 int i=396;
	   String testfile=xbasefile[i]+xInputfile[i];
	   logger.fine("TCASE: "+xdescription[i]);
	   robot.openFile(testfile);robot.delay(5000);
	   assertAreas(DIAGRAM_MAIN_WINDOW);
	 }


}