package com.altova.stylevision;

import static com.altova.stylevision.StyleVisionRobot.*;
import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.util.IOUtils;


public class SV_SortOptionsTest extends AbstractStyleVisionTest {

	protected static final String MY_TCase_Path="data/stylevision/tdata/SortOptionsTest/";
	protected static final String MY_Orgchart_Path="data/stylevision/tdata/orgchart/";
	
	protected static final File MY_OrgchartSPS=IOUtils.findFile(MY_Orgchart_Path+"Orgchart.sps");
	protected static final String MY_OrgchartSPS_FILE=MY_OrgchartSPS.getAbsolutePath();
	
	protected static final File MY_ExpReportSPS=IOUtils.findFile(MY_TCase_Path+"ExpReport.sps");
	protected static final String MY_ExpReportSPS_FILE=MY_ExpReportSPS.getAbsolutePath();
	
	protected static final File MY_NanonullSPS=IOUtils.findFile(MY_TCase_Path+"NanonullOrg.sps");
	protected static final String MY_NanonullSPS_FILE=MY_NanonullSPS.getAbsolutePath();
		
	@BeforeClass
	public static void doBeforeClass(){
		robot.activatePane(SCHEMATREE);
		robot.setPaneSize(SCHEMATREE, 400, 700);
		CheckboxOption option = new CheckboxOption("Sort attributes", false,
				"Schema tree options", null, null, "Schema",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		option = new CheckboxOption("Sort elements", false,
				"Schema tree options", null, null, "Schema",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		option = new CheckboxOption("Sort types", false,
				"Schema tree options", null, null, "Schema",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
	}
	
	@AfterClass
	public static void doAfterClass(){
		/*robot.setPaneSize(SCHEMATREE, 200, 372);
		CheckboxOption option = new CheckboxOption("Sort attributes", true,
				"Schema tree options", null, null, "Schema",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		option = new CheckboxOption("Sort elements", false,
				"Schema tree options", null, null, "Schema",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		option = new CheckboxOption("Sort types", true,
				"Schema tree options", null, null, "Schema",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		*/
		robot.RestoreToolbars();
	}
	
	@Test
	public final void testSortAttributesOption() {
		CheckboxOption option = new CheckboxOption("Sort attributes", true,
				"Schema tree options", null, null, "Schema",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		robot.openFile(MY_ExpReportSPS_FILE);
		robot.activatePane(SCHEMATREE);
		robot.expandElement("Root Element");
		assertAreas(SCHEMATREE);
	}
	
	@Test
	public final void testUnSortAttributesOption() {
		CheckboxOption option = new CheckboxOption("Sort attributes", false,
				"Schema tree options", null, null, "Schema",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		robot.openFile(MY_ExpReportSPS_FILE);
		robot.activatePane(SCHEMATREE);
		robot.expandElement("Root Element");
		assertAreas(SCHEMATREE);
	}
	
	@Test
	public final void testSortElementsOption() {
		CheckboxOption option = new CheckboxOption("Sort elements", true,
				"Schema tree options", null, null, "Schema",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		robot.openFile(MY_ExpReportSPS_FILE);
		robot.activatePane(SCHEMATREE);
		robot.expandElement("Root Element");
		assertAreas(SCHEMATREE);
	}
	
	@Test
	public final void testUnSortElementsOption() {
		CheckboxOption option = new CheckboxOption("Sort elements", false,
				"Schema tree options", null, null, "Schema",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		robot.openFile(MY_ExpReportSPS_FILE);
		robot.activatePane(SCHEMATREE);
		robot.expandElement("Root Element");
		assertAreas(SCHEMATREE);
	}
	
	@Test
	public final void testSortTypesOption() {
		CheckboxOption option = new CheckboxOption("Sort types", true,
				"Schema tree options", null, null, "Schema",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		robot.openFile(ORGCHART_SPS_FILE);
		robot.activatePane(SCHEMATREE);
		robot.expandOneLevelElement("Global Types");
		assertAreas(SCHEMATREE);
	}
	@Test
	public final void testUnSortTypesOption() {
		CheckboxOption option = new CheckboxOption("Sort types", false,
				"Schema tree options", null, null, "Schema",MS_SHELL_DLG_FONT);
		robot.setOptions(option);
		robot.openFile(ORGCHART_SPS_FILE);
		robot.activatePane(SCHEMATREE);
		robot.expandOneLevelElement("Global Types");
		assertAreas(SCHEMATREE);
	}

}
