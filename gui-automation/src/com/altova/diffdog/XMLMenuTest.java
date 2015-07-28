package com.altova.diffdog;

import org.junit.Test;
import java.io.File;
import com.altova.util.IOUtils;
//import static com.altova.robots.SnapshotArea.CommonArea.*;
import static java.awt.event.KeyEvent.*;


public class XMLMenuTest extends AbstractDiffDogTest{
	
	private static final File GNUMERIC1=IOUtils.findFileDiffDog("examples/LeftSide/","gnumeric1.xml");
	private static final File GNUMERIC2=IOUtils.findFileDiffDog("examples/RightSide/","gnumeric2.xml");
	
	@Test	
	public void testCheckedWellFormated(){
		robot.compareFiles(GNUMERIC1, GNUMERIC2);
		robot.showGridView();
		robot.leftClickMenuItem("XML","Check Well-Formedness");
		if(!robot.escapeDialog("File is well-formed!", VK_ESCAPE))
			fail("File is well-formed window doesn't appear");
	}
}
