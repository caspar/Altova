package com.altova.stylevision;


import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.stylevision.Position.AFTER;
import static com.altova.stylevision.StyleVisionRobot.*;

import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Test;

import com.altova.stylevision.StyleVisionRobot.View;
import com.altova.util.IOUtils;
import com.altova.util.Settings.AltovaApplication;
import static com.altova.stylevision.Tag.*;
import static com.altova.stylevision.TagType.START;

public class SV_XBRLTest extends AbstractStyleVisionTest {


	@Test
	public void XBRLTableWizard() {    
		File MY_TestCase_File=IOUtils.findFile("data/stylevision/tdata/XBRL/nanonull.xbrl");
		String MY_NANONULL_XBRL=MY_TestCase_File.getAbsolutePath();

		
		robot.newSPS("New from XBRL");
		robot.typeStringEnter(MY_NANONULL_XBRL);delay(3000);
		assertForegroundWindow("Create New Design");
		robot.leftClickButton("OK");delay(60000);
		robot.maximizeFileWindow();
		robot.activatePane(SCHEMATREE);
		robot.insertTaxonomy(robot.findTag("104",BW), robot.findTag("XBRL",GREENGREEN),1);
		assertForegroundWindow("XBRL Table Wizard");
		robot.leftClickButton("OK");delay(10000);
		robot.setView(View.HTML);delay(10000);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
}
