package com.altova.schemaagent;

import java.awt.Color;
import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.util.IOUtils;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.schemaagent.SchemaAgentRobot.*;
import static com.altova.util.LoggerUtils.logger;


public class AdvancedGUITest extends AbstractSchemaAgentTest{
	
	protected static final File ASSERT_VERSION_ICON = IOUtils.findFile("schemaagent/pic/Assert-Version_xsd.png");
	
	
	
	@Test
	public void xsd11Sample_ExpandAll() {
		
		robot.deleteAndCreateSearchPath("C:\\Work\\gui-automation\\data\\schemaagent\\testfiles\\XSD11", true, true, false, null, null, null, null);
		robot.openFile(XSD11SAMPLES);
	
		robot.findObjectInDiagramExpandAll(ASSERT_VERSION_ICON);
		
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

}
