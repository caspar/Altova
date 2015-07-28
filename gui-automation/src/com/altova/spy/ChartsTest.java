package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;
import static com.altova.spy.SpyRobot.CHARTS;
import com.altova.robots.AltovaApplicationRobot;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;
import static java.awt.event.KeyEvent.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.Ignore;

import com.altova.common.testcases.AbstractJUnitTest;
import com.altova.spy.SpyRobot.CANDLESTICK;
import com.altova.spy.SpyRobot.CHART;
import com.altova.spy.SpyRobot.PIE;
import com.altova.spy.SpyRobot.AREA;
import com.altova.spy.SpyRobot.BAR;
import com.altova.spy.SpyRobot.GAUGE;
import com.altova.spy.SpyRobot.LINE;

import static com.altova.util.LoggerUtils.logger;

public class ChartsTest extends AbstractXmlSpyTest{

	
	public static class Sizes{
	
		public Sizes(String name, String value, String dim){
			
			this.name=name;
			this.value=value;
			this.dim=dim;
		}
		
		String name;
		String value;
		String dim; 
	}

	
	private String sourceDepth = "/Accounts/Transfers-Out";


	@BeforeClass
	public static void setResizeChartPane() throws Exception {
		if(robot == null) {
			robot = new SpyRobot();
		}
		AbstractJUnitTest.setUpBeforeClass(robot);
		
		logger.fine("*** Resize CHART pane ***");
		robot.setChartSize(0, 330);
		
	}
	
	@Before
	public void setUp() throws Exception {}
	

	@AfterClass
	public static void dropDownClassChart() throws Exception {
		
		robot.setChartSize(0, 180);
		
	}
	
	
	@Test
	public final void testDefaultNewChartWindow(){
	
		robot.openFile(ORGCHART_XML_FILE);
		
		robot.gridView();
		robot.newChart_setSourceXPath("");
		
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	
	@Test
	public final void testInvalidXPath(){
		
		String source = "test";
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath(source);
		robot.clickButton("Update Column");
		
		//assertAreas(DIAGRAM_MAIN_WINDOW);
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 	
		
	}
	

	@Test
	public final void testInvalidXPathModified(){
		
		String newSource = " test";
		String oldSource = "/Import/Row[1]";
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		robot.gridView();
		robot.xpathHighlight(oldSource);
	
		robot.newChart_setSourceXPath(oldSource + newSource);
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("Cancel");
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 	
		
	}

	@Test
	public final void testColumnSearchDepth1(){
		
		robot.openFile(INOUTVARIUSDEPTHS_XML_FILE);
		
		robot.newChart_setSourceXPath(sourceDepth);
		robot.updateColumns();
		robot.newChart_firstColumn("Auto Enumerated");
		robot.newChart_setColumnSearchDepth(1);
		robot.markAll();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("Cancel");
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 	
		
	}

	@Test
	public final void testColumnSearchDepth2(){
		
		robot.openFile(INOUTVARIUSDEPTHS_XML_FILE);
		
		robot.newChart_setSourceXPath(sourceDepth);
		robot.updateColumns();
		robot.newChart_firstColumn("Auto Enumerated");
		robot.newChart_setColumnSearchDepth(2);
		robot.markAll();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("Cancel");
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 	

		
	}
	
	@Test
	public final void testColumnSearchDepth3(){
		
		robot.openFile(INOUTVARIUSDEPTHS_XML_FILE);
		
		robot.newChart_setSourceXPath(sourceDepth);
		robot.updateColumns();
		robot.newChart_firstColumn("Auto Enumerated");
		robot.newChart_setColumnSearchDepth(3);
		robot.markAll();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("Cancel");
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 	

		
	}
	
	@Test
	public final void testColumnSearchDepth4(){
		
		robot.openFile(INOUTVARIUSDEPTHS_XML_FILE);
		
		robot.newChart_setSourceXPath(sourceDepth);
		robot.updateColumns();
		robot.newChart_firstColumn("Auto Enumerated");
		robot.newChart_setColumnSearchDepth(4);
		robot.markAll();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 	

		
	}
	
	@Test
	public final void testColumnSearchDepth5(){
		
		robot.openFile(INOUTVARIUSDEPTHS_XML_FILE);
		
		robot.newChart_setSourceXPath(sourceDepth);
		robot.updateColumns();
		robot.newChart_firstColumn("Auto Enumerated");
		robot.newChart_setColumnSearchDepth(5);
		robot.markAll();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 	

		
	}
	
	@Test
	public final void testFirstColumn(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row[1]");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.updateColumns();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
		//assertAreas(CHARTS);
		
	}
	
	
	@Test
	public final void testClearAll(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
	
		robot.newChart_setSourceXPath("/Import/Row[1]");
		robot.updateColumns();
		robot.newChart_firstColumn("Auto Enumerated");
		
		robot.clickButton("Clear All");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 

		//assertAreas(CHARTS);
		
		
		
	}
	
	@Test
	public final void testMarkupAll(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row[1]");
		robot.updateColumns();
		robot.newChart_firstColumn("Auto Enumerated");
		
		robot.clickButton("Mark All");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");

		//assertAreas(CHARTS);
		
		
	}

	@Test
	public final void testInsertXPath_Invalid(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row[1]");
		robot.updateColumns();
		robot.newChart_firstColumn("Auto Enumerated");
		robot.newChart_insertXPath("Import/Row invalid");
		
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 

		
		
	}

	@Test
	public final void testInsertXPath_Valid(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row[1]");
		robot.updateColumns();
		robot.newChart_firstColumn("Auto Enumerated");
		robot.clickButton("Clear All");
		robot.newChart_insertXPath("/Import/Row/Min*10");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
	}
	
	@Test
	public final void testDeleteXPath_disabled(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row[1]");
		robot.updateColumns();
		robot.newChart_firstColumn("Auto Enumerated");
		robot.newChart_insertXPath("xpath");
		
		robot.newChart_findSeriesColumn("Month");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 

		
	}
	
	@Test
	public final void testDeleteXPath(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row[1]");
		robot.updateColumns();
		robot.newChart_firstColumn("Auto Enumerated");
		robot.newChart_insertXPath("Mindy");
		
		robot.newChart_findSeriesColumn("Mindy");
		robot.clickButton("Delete XPath");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			//robot.keyType(VK_ESCAPE);
			robot.clickButton("Cancel");
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
		
	}
	
	// Change Type Window Tests
	
	@Test
	public final void testPieWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	
	@Test
	public final void testBarWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testLineWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testAreaWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Area, AREA.Area_Chart);
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testCandlestickWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009CS_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Candlestick, CANDLESTICK.Candlestick_Chart);
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testGaugeWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Gauge, GAUGE.Round_Gauge);
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	//Appearance Window Tests
	@Test
	public final void testPie2DAppearenceWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");
		robot.changeAppearance("General");
		robot.setToDefault();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testPie3DAppearenceWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_3d);
		robot.clickButton("OK");
		robot.changeAppearance("General");
		robot.setToDefault();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}

	@Test
	public final void testBarAppearenceWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");
		robot.changeAppearance("General");
		robot.setToDefault();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testStackedBarAppearenceWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Bar, BAR.Stacked_Bar_Chart);
		robot.clickButton("OK");
		robot.changeAppearance("General");
		robot.setToDefault();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testBar3DAppearenceWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d);
		robot.clickButton("OK");
		robot.changeAppearance("General");
		robot.setToDefault();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testBar3DGroupedAppearenceWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d_Grouped);
		robot.clickButton("OK");
		robot.changeAppearance("General");
		robot.setToDefault();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testLineAppearenceWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		robot.changeAppearance("General");
		robot.setToDefault();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testValueLineAppearenceWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");
		robot.changeAppearance("General");
		robot.setToDefault();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testAreaAppearenceWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Area, AREA.Area_Chart);
		robot.clickButton("OK");
		robot.changeAppearance("General");
		robot.setToDefault();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testStockedAreaAppearenceWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Area, AREA.Stacked_Area_Chart);
		robot.clickButton("OK");
		robot.changeAppearance("General");
		robot.setToDefault();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testCandlestickAppearenceWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009CS_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Candlestick, CANDLESTICK.Candlestick_Chart);
		robot.clickButton("OK");
		robot.changeAppearance("General");
		robot.setToDefault();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testRoundGaugeAppearenceWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Gauge, GAUGE.Round_Gauge);
		robot.clickButton("OK");
		robot.changeAppearance("General");
		robot.setToDefault();
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testBarGaugeAppearenceWindow(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
			
		robot.changeTypeChart(CHART.Gauge, GAUGE.Bar_Gauge);
		robot.clickButton("OK");
		robot.changeAppearance("General");
		robot.setToDefault();
						
		try {
			assertAreas(TOP_WINDOW);

		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
				
		}
		assertTrue(robot.isApplicationFront()); 
			
	}

	
	// Change Type element tests
	@Test
	public final void testPieChart2D(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");
		
		robot.changeAppearance("General");
		robot.setToDefault();
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testPieChart3D(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_3d);
		robot.clickButton("OK");
		
		robot.changeAppearance("General");
		robot.setToDefault();
		robot.clickButton("OK");

		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");
		
		robot.changeAppearance("General");
		robot.setToDefault();
		robot.clickButton("OK");

		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testStackedBarChart(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Stacked_Bar_Chart);
		robot.clickButton("OK");
		
		robot.changeAppearance("General");
		robot.setToDefault();
		robot.clickButton("OK");

		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart3D(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d);
		robot.clickButton("OK");
		
		robot.changeAppearance("General");
		robot.setToDefault();
		robot.clickButton("OK");

		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart3DGrouped(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d_Grouped);
		robot.clickButton("OK");
		
		robot.changeAppearance("General");
		robot.setToDefault();
		robot.clickButton("OK");

		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testLineChart(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.changeAppearance("General");
		robot.setToDefault();
		robot.clickButton("OK");

		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testValueLineChart(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");
		
		robot.changeAppearance("General");
		robot.setToDefault();
		robot.clickButton("OK");

		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testAreaChart(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Area_Chart);
		robot.clickButton("OK");
		
		robot.changeAppearance("General");
		robot.setToDefault();
		robot.clickButton("OK");

		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testStackedAreaChart(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Stacked_Area_Chart);
		robot.clickButton("OK");
		
		robot.changeAppearance("General");
		robot.setToDefault();
		robot.clickButton("OK");

		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testCandlestickChart(){
		
		robot.openFile(MINMAXTEMPERATURE2009CS_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Candlestick, CANDLESTICK.Candlestick_Chart);
		robot.clickButton("OK");
		
		robot.changeAppearance("General");
		robot.setToDefault();
		robot.clickButton("OK");

		assertAreas(CHARTS);
		
	}
	
	
	@Test
	public final void testRoundGaugeChart(){
		
		robot.openFile(ITEMS_XML_FILE);
		
		robot.newChart_setSourceXPath("/items/item_tuple");
		robot.updateColumns();
		robot.newChart_firstColumn("reserve_price");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Gauge, GAUGE.Round_Gauge);
		robot.clickButton("OK");
		
		robot.changeAppearance("General");
		robot.setToDefault();
		robot.clickButton("OK");

		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarGaugeChart(){
		
		robot.openFile(ITEMS_XML_FILE);
		
		robot.newChart_setSourceXPath("/items/item_tuple");
		robot.updateColumns();
		robot.newChart_firstColumn("reserve_price");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Gauge, GAUGE.Bar_Gauge);
		robot.clickButton("OK");
		
		robot.changeAppearance("General");
		robot.setToDefault();
		robot.clickButton("OK");

		assertAreas(CHARTS);
		
	}
	
	//Appearance Modified Tests
	@Test
	public final void testPieChart2D_setGeneral(){		
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 2D Pie Chart", RED_COLOR_PALETTE_ICON, false, null, null, null, null);
		robot.changeAppearance_General_Plot(null, null, GREEN_COLOR_PALETTE_ICON, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testPieChart2D_setGeneral_background(){		
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 2D Pie Chart using background effect", null, null, "Vertical Gradient", LIGHTBLUE_COLOR_PALETTE_ICON, NANONULL_GIF_LOGO, "ZoomToFit");
		robot.changeAppearance_General_Plot(null, null, null, "Horizontal Gradient", YELLOW_COLOR_PALETTE_ICON, NANONULL_GIF_LOGO, "Stretched");
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testPieChart3D_setGeneral(){
		
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in 3D Pie Chart", GREEN_COLOR_PALETTE_ICON, false, null, null, null, null);
		robot.changeAppearance_General_Plot(null, null, RED_COLOR_PALETTE_ICON, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testPieChart3D_setGeneral_background(){
		
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in 3D Pie Chart", null, null, "Horizontal Gradient", LIGHTGREY_COLOR_PALETTE_ICON, NANONULL_GIF_LOGO, "Stretched");
		robot.changeAppearance_General_Plot(null, null, null, "Vertical Gradient", RED_COLOR_PALETTE_ICON, NANONULL_GIF_LOGO, "ZoomToFit");
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart_setGeneral(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in Bar Chart", GREEN_COLOR_PALETTE_ICON, false, null, null, null, null);
		robot.changeAppearance_General_Plot(false, null, YELLOW_COLOR_PALETTE_ICON, null, null, null, null);
		robot.changeAppearance_General_Orientation(true);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart_setGeneral_background(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in Bar Chart using background", null, null, "Solid", null, NANONULL_GIF_LOGO, "Center");
		robot.changeAppearance_General_Plot(null, null, null, "Transparent", null, NANONULL_GIF_LOGO, "Center");
		robot.changeAppearance_General_Orientation(true);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	
	@Test
	public final void testStackedBarChart_setGeneral(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Stacked_Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in Stacked Bar Chart", YELLOW_COLOR_PALETTE_ICON, false, null, null, null, null);
		robot.changeAppearance_General_Plot(false, null, LIGHTGREY_COLOR_PALETTE_ICON, null, null, null, null);
		robot.changeAppearance_General_Orientation(true);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	
	@Test
	public final void testStackedBarChart_setGeneral_background(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Stacked_Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in Stacked Bar Chart using background", null, null, "Vertical Gradient", LIGHTGREY_COLOR_PALETTE_ICON, NANONULL_GIF_LOGO, "Tiled");
		robot.changeAppearance_General_Plot(null, null, null, "Transparent", null, NANONULL_GIF_LOGO, "Stretched");
		robot.changeAppearance_General_Orientation(null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart3D_setGeneral(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in 3D Bar Chart", LIGHTGREY_COLOR_PALETTE_ICON, false, null, null, null, null);
		robot.changeAppearance_General_Plot(null, null, YELLOW_COLOR_PALETTE_ICON, null, null, null, null);
		robot.clickButton("OK");

		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart3D_setGeneral_background(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in 3D Bar Chart uning BG color & pictures", LIGHTGREY_COLOR_PALETTE_ICON, false, null, null, null, null);
		robot.changeAppearance_General_Plot(null, null, YELLOW_COLOR_PALETTE_ICON, null, null, null, null);
		robot.clickButton("OK");

		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart3DGrouped_setGeneral(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d_Grouped);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in 3D Bar Chart", GREEN_COLOR_PALETTE_ICON, false, null, null, null, null);
		robot.changeAppearance_General_Plot(null, null, LIGHTGREY_COLOR_PALETTE_ICON, null, null, null, null);
		robot.clickButton("OK");

		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart3DGrouped_setGeneral_background(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d_Grouped);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in 3D Grouped Grouped Bar Chart background", null, false, null, null, null, "Tiled");
		robot.changeAppearance_General_Plot(null, null, null, "Transparent", null, NANONULL_GIF_LOGO, "Center");
		robot.clickButton("OK");

		
		assertAreas(CHARTS);
		
	}

	@Test
	public final void testLineChart_setGeneral(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in Line Chart", LIGHTBLUE_COLOR_PALETTE_ICON, false, null, null, null, null);
		robot.changeAppearance_General_Plot(false, null, RED_COLOR_PALETTE_ICON, null, null, null, null);
		robot.changeAppearance_General_Orientation(true);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	
	@Test
	public final void testLineChart_setGeneral_background(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in Line Chart - picture background", null, null, null, null, NANONULL_GIF_LOGO, "Tiled");
		robot.changeAppearance_General_Plot(null, null, null, null, null, null, null);
		robot.changeAppearance_General_Orientation(true);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testValueLineChart_setGeneral(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in Value Line Chart", YELLOW_COLOR_PALETTE_ICON, false, null, null, null, null);
		robot.changeAppearance_General_Plot(false, null, GREEN_COLOR_PALETTE_ICON, null, null, null, null);
		robot.changeAppearance_General_Orientation(true);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	
	@Test
	public final void testValueLineChart_setGeneral_background(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in Value Line Chart -> Background", null, null, "Horizontal Gradient", LIGHTBLUE_COLOR_PALETTE_ICON, null, null);
		robot.changeAppearance_General_Plot(null, null, null, null, null, NANONULL_GIF_LOGO, "Stretched");
		robot.changeAppearance_General_Orientation(null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testAreaChart_setGeneral(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Area_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in Area Chart", GREEN_COLOR_PALETTE_ICON, false, null, null, null, null);
		robot.changeAppearance_General_Plot(false, null, LIGHTBLUE_COLOR_PALETTE_ICON, null, null, null, null);
		robot.changeAppearance_General_Orientation(true);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	
	@Test
	public final void testAreaChart_setGeneral_background(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Area_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in Area Chart -> background mode", null, null, "Horizontal Gradient", LIGHTBLUE_COLOR_PALETTE_ICON, NANONULL_GIF_LOGO, "Tiled");
		robot.changeAppearance_General_Plot(null, null, null, "Vertical Gradient", LIGHTGREY_COLOR_PALETTE_ICON, NANONULL_GIF_LOGO, "ZoomToFit");
		robot.changeAppearance_General_Orientation(null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	
	@Test
	public final void testStackedAreaChart_setGeneral(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Stacked_Area_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in Area Chart", YELLOW_COLOR_PALETTE_ICON, false, null, null, null, null);
		robot.changeAppearance_General_Plot(false, null, LIGHTGREY_COLOR_PALETTE_ICON, null, null, null, null);
		robot.changeAppearance_General_Orientation(true);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testStackedAreaChart_setGeneral_background(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Stacked_Area_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in Area Chart", null, null, null, null, NANONULL_GIF_LOGO, "Stretched");
		robot.changeAppearance_General_Plot(null, null, null, "Transparent", null, null, null);
		robot.changeAppearance_General_Orientation(true);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testCandlestickChart_setGeneral(){
		
		robot.openFile(MICROSOFTSTOCKQUOTE_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Auto Enumerated");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Candlestick, CANDLESTICK.Candlestick_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Microsoft stock quote chart", YELLOW_COLOR_PALETTE_ICON, true, null, null, null, null);
		robot.changeAppearance_General_Plot(false, null, LIGHTBLUE_COLOR_PALETTE_ICON, null, null, null, null);
		robot.changeAppearance_General_Orientation(true);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testCandlestickChart_setGeneral_background(){
		
		robot.openFile(MICROSOFTSTOCKQUOTE_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Auto Enumerated");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Candlestick, CANDLESTICK.Candlestick_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Microsoft stock quote chart", null, null, "Vertical Gradient", LIGHTBLUE_COLOR_PALETTE_ICON, null, null);
		robot.changeAppearance_General_Plot(null, null, null, null, null, null, null);
		robot.changeAppearance_General_Orientation(true);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testRoundGaugeChart_setGeneral(){
		
		robot.openFile(ITEMS_XML_FILE);
		
		robot.newChart_setSourceXPath("/items/item_tuple");
		robot.updateColumns();
		robot.newChart_firstColumn("reserve_price");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Gauge, GAUGE.Round_Gauge);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in Round Gauge Chart", LIGHTGREY_COLOR_PALETTE_ICON, null, null, null, null, null);
		robot.changeAppearance_General_Plot(null, null, YELLOW_COLOR_PALETTE_ICON, null, null, null, null);
		robot.clickButton("OK");
				
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testRoundGaugeChart_setGeneral_background(){
		
		robot.openFile(ITEMS_XML_FILE);
		
		robot.newChart_setSourceXPath("/items/item_tuple");
		robot.updateColumns();
		robot.newChart_firstColumn("reserve_price");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Gauge, GAUGE.Round_Gauge);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in Round Gauge Chart >>> Background", LIGHTGREY_COLOR_PALETTE_ICON, null, null, null, NANONULL_GIF_LOGO, "Stretched");
		robot.changeAppearance_General_Plot(null, null, null, "Transparent", null, null, null);
		robot.clickButton("OK");
				
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarGaugeChart_setGeneral(){
		
		robot.openFile(ITEMS_XML_FILE);
		
		robot.newChart_setSourceXPath("/items/item_tuple");
		robot.updateColumns();
		robot.newChart_firstColumn("reserve_price");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Gauge, GAUGE.Bar_Gauge);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in Bar Gauge Chart", LIGHTGREY_COLOR_PALETTE_ICON, null, null, null, null, null);
		robot.changeAppearance_General_Plot(null, null, LIGHTBLUE_COLOR_PALETTE_ICON, null, null, null, null);
		robot.clickButton("OK");

		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarGaugeChart_setGeneral_background(){
		
		robot.openFile(ITEMS_XML_FILE);
		
		robot.newChart_setSourceXPath("/items/item_tuple");
		robot.updateColumns();
		robot.newChart_firstColumn("reserve_price");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Gauge, GAUGE.Bar_Gauge);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in BAR Gauge Chart >>> Background", null, null, "Vertical Gradient", null, null, null);
		robot.changeAppearance_General_Plot(null, null, null, "Horizontal Gradient", null, null, null);
		robot.clickButton("OK");

		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testPieChart2D_setPieType(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Pie("90", false, null, false, false, null, null, null, null);	
		robot.changeAppearance_Pie_Label(false, true, true, 2);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testPieChart3D_setPieType(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Pie("90", false, null, false, null, true, YELLOW_COLOR_PALETTE_ICON, "100", "20");	
		robot.changeAppearance_Pie_Label(false, true, true, 2);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testPieChart2D_invalidStartAngle1(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Pie("360", null, null, null, null, null, null, null, null);
		robot.clickButton("OK");
		
		robot.changeAppearance("Pie");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		} 
		
		
	}
	
	@Test
	public final void testPieChart2D_invalidStartAngle2(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Pie("-1", null, null, null, null, null, null, null, null);
		robot.clickButton("OK");
		
		robot.changeAppearance("Pie");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		} 
 
		
	}
	
	@Test
	public final void testPieChart2D_invalidStartAngle3(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Pie("Hello" , null, null, null, null, null, null, null, null);
		robot.clickButton("OK");
		
		robot.changeAppearance("Pie");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		} ;

		
	}
	
	@Test
	public final void testPieChart3D_invalidTransparencyValue1(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Pie(null, null, null, null, null, null, null, "256", null);
		robot.clickButton("OK");
		
		robot.changeAppearance("Pie");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		} 

		
		
	}
	
	@Test
	public final void testPieChart3D_invalidTransparencyValue2(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Pie(null, null, null, null, null, null, null, "-1", null);
		robot.clickButton("OK");
		
		robot.changeAppearance("Pie");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		} 
 
		
	}
	
	@Test
	public final void testPieChart3D_invalidTransparencyValue3(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Pie(null , null, null, null, null, null, null, "Hallo", null);
		robot.clickButton("OK");
		
		robot.changeAppearance("Pie");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}  
		
	}

	@Test
	public final void testPieChart3D_invalidTiltValue1(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Pie(null, null, null, null, null, null, null, null, "91");
		robot.clickButton("OK");
		
		robot.changeAppearance("Pie");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		} 
		
		
	}
	
	@Test
	public final void testPieChart3D_invalidTiltValue2(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Pie(null, null, null, null, null, null, null, null, "9");
		robot.clickButton("OK");
		
		robot.changeAppearance("Pie");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}  
		
	}
	
	@Test
	public final void testPieChart3D_invalidTiltValue3(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Pie(null , null, null, null, null, null, null, null, "Hullo");
		robot.clickButton("OK");
		
		robot.changeAppearance("Pie");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		} 
		
	}
	
	@Test
	public final void testBarChart_setBarType1(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Bar(false, BLUE_COLOR_PALETTE_ICON, false, BLUE_COLOR_PALETTE_ICON, "Vertical Gradient");
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart_setBarType2(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Bar(false, BLUE_COLOR_PALETTE_ICON, false, BLUE_COLOR_PALETTE_ICON, "Solid");
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testStackedBarChart_setBarType(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Stacked_Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Bar(false, BLUE_COLOR_PALETTE_ICON, false, BLUE_COLOR_PALETTE_ICON, null);
		robot.clickButton("OK");

		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart3D_setBarType(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Bar(false, BLUE_COLOR_PALETTE_ICON, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart3DGrouped_setBarType(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d_Grouped);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Bar(false, BLUE_COLOR_PALETTE_ICON, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testLineChart_setLineType_outlined(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Line(false, true, false, false);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testLineChart_setLineType_slashed(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Line(false, false, true, false);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testLineChart_setLineType_backslashed(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Line(false, false, false, true);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testValueLineChart_setLineType_outlined(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Line(false, true, false, false);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testValueLineChart_setLineType_slashed(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Line(false, false, true, false);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testValueLineChart_setLineType_backslashed(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Line(false, false, false, true);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testAreaChart_setAreaType(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Area_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Area("100", false, BLUE_COLOR_PALETTE_ICON);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testStackedAreaChart_setAreaType(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Stacked_Area_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.changeAppearance_Area("100", false, BLUE_COLOR_PALETTE_ICON);
		robot.clickButton("OK");

		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testAreaChart_invalidTransparencyValue1(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Area_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Area("256", null, null);
		robot.clickButton("OK");
		
		robot.changeAppearance("Area");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
	}
	
	@Test
	public final void testAreaChart_invalidTransparencyValue2(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Area_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Area("-1", null, null);
		robot.clickButton("OK");
		
		robot.changeAppearance("Area");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
	}
	
	@Test
	public final void testAreaChart_invalidTransparencyValue3(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Area_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Area("HALLO", null, null);
		robot.clickButton("OK");
		
		robot.changeAppearance("Area");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
	}
	
	
	@Test
	public final void testCandlestickChart_setCandlestickType(){
		
		robot.openFile(MICROSOFTSTOCKQUOTE_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Auto Enumerated");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Candlestick, CANDLESTICK.Candlestick_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Candlestick(false, BLUE_COLOR_PALETTE_ICON, null, null); 
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testCandlestickChart_setCandlestickType2(){
		
		robot.openFile(MICROSOFTSTOCKQUOTE_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Auto Enumerated");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Candlestick, CANDLESTICK.Candlestick_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Candlestick(null, null, false, YELLOW_COLOR_PALETTE_ICON); 
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	
	@Test
	public final void testRoundGaugeChart_setGaugeType(){
		
		robot.openFile(ITEMS_XML_FILE);
		
		robot.newChart_setSourceXPath("/items/item_tuple");
		robot.updateColumns();
		robot.newChart_firstColumn("reserve_price");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Gauge, GAUGE.Round_Gauge);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Gauge("-200", "300", "-50", "250", "20", BLUE_COLOR_PALETTE_ICON, "10", RED_COLOR_PALETTE_ICON, YELLOW_COLOR_PALETTE_ICON, BLUE_COLOR_PALETTE_ICON, LIGHTGREY_COLOR_PALETTE_ICON, LIGHTBLUE_COLOR_PALETTE_ICON); 
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarGaugeChart_setGaugeType(){
		
		robot.openFile(ITEMS_XML_FILE);
		
		robot.newChart_setSourceXPath("/items/item_tuple");
		robot.updateColumns();
		robot.newChart_firstColumn("reserve_price");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Gauge, GAUGE.Bar_Gauge);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Gauge(null, null, "-60", "150", "50", BLUE_COLOR_PALETTE_ICON, "5", LIGHTGREY_COLOR_PALETTE_ICON, YELLOW_COLOR_PALETTE_ICON, BLUE_COLOR_PALETTE_ICON, RED_COLOR_PALETTE_ICON, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}

	
	@Test
	public final void testColorSchemaWindow(){

		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");
		robot.changeAppearance("Color Schema");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());

		
	}
	
	
	@Test
	public final void testColorSchema_Delete(){
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.colorSchema("Colorful", "Delete", BLUE_COLOR_PALETTE_ICON);
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
	}

	@Test
	public final void testColorSchema_Add(){
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.colorSchema("Default", "Add", YELLOW_COLOR_PALETTE_ICON);
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	
	@Test
	public final void testColorSchema_Overlays(){
		
		//1st Chart: the main
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Auto Enumerated");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Append");
		
		//2nd Chart: Overlayed
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Auto Enumerated");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.changeAppearance("Color Schema");
				
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
		robot.overlaysChart("Delete Current");
		
	}
	
	//"Sizes" Test cases
	
	@Test
	public final void testPieChart2D_setSizes(){
		
		
		Sizes[] setElements = { new Sizes("Outside margin","10","%"), 
					 			new Sizes("Legend to Plot","20","px"),
					 			new Sizes("Plot to Label","50","px")};
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Sizes(setElements);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testPieChart2D_invalidSizes(){
		
		
		Sizes[] setElements = { new Sizes("Outside margin","Hello","%"), 
					 			new Sizes("Plot to Label","50","cm")};
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Sizes(setElements);
		robot.clickButton("OK");
		
		robot.changeAppearance("Sizes");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		} 
		
	}
	
	@Test
	public final void testPieChart3D_setSizes(){
		
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Sizes");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
	}
	
	@Test
	public final void testBarChart_setSizes(){
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Sizes");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testStackedBarChart_setSizes(){
		
		robot.changeTypeChart(CHART.Bar, BAR.Stacked_Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Sizes");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testBar3DChart_setSizes(){
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Sizes");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testBar3DGroupedChart_setSizes(){
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d_Grouped);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Sizes");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testLineChart_setSizes(){
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Sizes");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}

	
	@Test
	public final void testLineChart_setSizes_XAxisToPlot(){
		
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.newChart_findSeriesColumn("Min");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		Sizes[] setElements = { new Sizes("X-Axis to Plot","15","%")};

		robot.changeAppearance_Sizes(setElements);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);

	}
	
	@Test
	public final void testLineChart_setSizes_YAxisToPlot(){
		
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.newChart_findSeriesColumn("Min");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		Sizes[] setElements = { new Sizes("Y-Axis to Plot","15","%")};

		robot.changeAppearance_Sizes(setElements);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);

	}

	@Test
	public final void testLineChart_setSizes_InvalidXAxisToPlot(){
		
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.newChart_findSeriesColumn("Min");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		Sizes[] setElements = { new Sizes("X-Axis to Plot","-15","%")};

		robot.changeAppearance_Sizes(setElements);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);

	}
	
	@Test
	public final void testLineChart_setSizes_InvalidYAxisToPlot(){
		
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.newChart_findSeriesColumn("Min");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		Sizes[] setElements = { new Sizes("Y-Axis to Plot","-15","%")};

		robot.changeAppearance_Sizes(setElements);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);

	}

	
	
	@Test
	public final void testValueLineChart_setSizes(){
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Sizes");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testAreaChart_setSizes(){
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Area_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Sizes");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
		//assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testStackedAreaChart_setSizes(){
			
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Stacked_Area_Chart);
		robot.clickButton("OK");
				
		robot.setToDefault();
		robot.changeAppearance("Sizes");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	
	@Test
	public final void testCandlestickChart_setSizes(){
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Candlestick, CANDLESTICK.Candlestick_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Sizes");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
		
	}
	
	@Test
	public final void testRoundGaugeChart_setSizes(){
		
		robot.changeTypeChart(CHART.Gauge, GAUGE.Round_Gauge);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Sizes");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
		
	}
	
	@Test
	public final void testBarGaugeChart_setSizes(){
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Gauge, GAUGE.Bar_Gauge);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Sizes");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
		
	
	//"Fonts" test cases
	
	@Test
	public final void testPieChart2D_setFonts(){
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Fonts");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		} 
		
	}
	
	@Test
	public final void testPieChart3D_setFonts(){
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Fonts");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
	}

	@Test
	public final void testBarChart_setFonts(){
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Fonts");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testStackedBarChart_setFonts(){
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Stacked_Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Fonts");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testBar3DChart_setFonts(){
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Fonts");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testBar3DGroupedChart_setFonts(){
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d_Grouped);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Fonts");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}

	@Test
	public final void testLineChart_setFonts(){
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Fonts");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testValueLineChart_setFonts(){
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Fonts");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront()); 
		
	}
	
	@Test
	public final void testAreaChart_setFonts(){
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Area_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Fonts");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testStackedAreaChart_setFonts(){
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
				
		robot.changeTypeChart(CHART.Area, AREA.Stacked_Area_Chart);
		robot.clickButton("OK");
				
		robot.setToDefault();
		robot.changeAppearance("Fonts");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testCandlestickChart_setFonts(){
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Candlestick, CANDLESTICK.Candlestick_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Fonts");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testRoundGaugeChart_setFonts(){
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Gauge, GAUGE.Round_Gauge);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Fonts");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testBarGaugeChart_setFonts(){
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Gauge, GAUGE.Bar_Gauge);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Fonts");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}

	@Test
	public final void testBarChart_setX_rightTop(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, "Right/Top", null, null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart_setX_leftBottom(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, "Left/Bottom", null, null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart_setX_onPosition(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, "At Value / On Category", "45", null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testStackedBarChart_setX_rightTop(){

		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Bar, BAR.Stacked_Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, "Right/Top", null, null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testStackedBarChart_setX_leftBottom(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Stacked_Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, "Left/Bottom", null, null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testStackedBarChart_setX_onPosition(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Stacked_Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, "At Value / On Category", "60", null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testStackedBarChart3D_setX(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, null, null, null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testStackedBarChart3DGrouped_setX(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d_Grouped);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, null, null, null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testLineChart_setX(){
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("X ( Category");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
		
	}
	
	@Test
	public final void testLineChart_setX_leftBottom(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, "Left/Bottom", null, null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testLineChart_setX_onPosition(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, "At Value", "45", null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testLineChart_setX_rightTop(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, "Right/Top", null, null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}

	

	@Test
	public final void testValueLineChart_setX(){

		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.changeAppearance("X Axis");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	//ttp (update all to X-Axis appearance title)
	@Ignore
	@Test
	public final void testValueLineChart_setX_leftBottom(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, "Left/Bottom", null, "Manual", null, "-0.5", "0.5", "Manual", "0.1");
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	//ttp (update all to X-Axis appearance title)
	  
	@Ignore
	@Test
	public final void testValueLineChart_setX_onPosition(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, "On Position", "45", "Manual", null, "-0.5", "0.5", "Manual", "0.1");
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testAreaChart_setX(){
		
		robot.changeTypeChart(CHART.Area, AREA.Area_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("X ( Category");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	
 	@Ignore
 	@Test
	public final void testAreaChart_setX_leftBottom(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Area_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, "Left/Bottom", null, null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Ignore
	@Test
	public final void testAreaChart_setX_onPosition(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Area_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, "On Position", "45", null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testStackedAreaChart_setX(){
		
		robot.changeTypeChart(CHART.Area, AREA.Stacked_Area_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("X ( Category");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Ignore
	@Test
	public final void testStackedAreaChart_setX_leftBottom(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Stacked_Area_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, "Left/Bottom", null, null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Ignore
	@Test
	public final void testStackedAreaChart_setX_onPosition(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Stacked_Area_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, "On Position", "60", null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	
	@Test
	public final void testCandlestick_setX(){
		
		robot.changeTypeChart(CHART.Candlestick, CANDLESTICK.Candlestick_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("X ( Category");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	
	@Test
	public final void testCandlestick_setX_atValue(){
		
		robot.openFile(MINMAXTEMPERATURE2009CS_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Auto Enumerated");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Candlestick, CANDLESTICK.Candlestick_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", LIGHTBLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, true, true, "At Value", "60", null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
			
	@Test
	public final void testCandlestick_setX_rightTop(){
		
		robot.openFile(MINMAXTEMPERATURE2009CS_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Candlestick, CANDLESTICK.Candlestick_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Xaxis("Altova XMLSpy 2011", null, false, null, true, true, "Right/Top", null, null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}		
			
	
	@Test
	public final void testBarChart_setY_rightTop(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Yaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, "Right/Top", null, "Manual", null, "-0.5", "0.5", "Manual", "0.1");
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart_setY_leftBottom(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Yaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, false, null, false, false, "Left/Bottom", null, "Manual", null, "-0.5", "0.5", "Manual", "0.1");
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart_setY_onPosition(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Yaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, "At Value / On Category", "45", "Auto", false, null, null, "Auto", null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}

	@Test
	public final void testStackedBarChart_setY_rightTop(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Stacked_Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Yaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, true, true, "Right/Top", null, "Auto", true, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testStackedBarChart_setY_leftBottom(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Stacked_Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Yaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, true, true, "Left/Bottom", null, "Manual", null, "-0.5", "0.5", "Auto", null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testStackedBarChart_setY_onPosition(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Stacked_Bar_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Yaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, false, null, true, true, "At Value / On Category", "45", "Manual", null, "-0.5", "0.5", "Manual", "0.1");
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart3D_setY(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Yaxis("Altova XMLSpy 2011", BLUE_COLOR_PALETTE_ICON, true, RED_COLOR_PALETTE_ICON, false, false, null, null, null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testStackedBarChart3DGrouped_setY(){
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d_Grouped);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Y ( Value )");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}

	@Test
	public final void testLineChart_setY(){
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Y ( Value )");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
		
	}
	
	//ttp (update all to X-Axis appearance title)
	@Test
	public final void testValueLineChart_setY(){

		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.changeAppearance("Y Axis");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testAreaChart_setY(){
		
		robot.changeTypeChart(CHART.Area, AREA.Area_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Y ( Value )");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testStackedAreaChart_setY(){
		
		robot.changeTypeChart(CHART.Area, AREA.Stacked_Area_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Y ( Value )");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testCandlestickChart_setY(){
		
		robot.changeTypeChart(CHART.Candlestick, CANDLESTICK.Candlestick_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Y ( Value )");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testLineChart_invalidY1(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Yaxis(null, null, null, null, null, null, null, null, "Manual", null, "500", "2", null, null);
		robot.clickButton("OK");
		
		robot.changeAppearance("Y ( Value )");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
	
	}
	
	@Test
	public final void testLineChart_invalidY2(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Yaxis(null, null, null, null, null, null, null, null, "Manual", null, "Hello", "Again", null, null);
		robot.clickButton("OK");
		
		robot.changeAppearance("Y ( Value )");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());

		
	}
	
	@Test
	public final void testLineChart_invalidY3(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Yaxis(null, null, null, null, null, null, null, null, "Manual", null, "5", "-5", null, null);
		robot.clickButton("OK");
		
		robot.changeAppearance("Y ( Value )");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());

		
	}
	
	@Test
	public final void testLineChart_invalidY4(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Yaxis(null, null, null, null, null, null, null, null, null, null, null, null, "Manual", "-5");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());

		
	}
	
	@Test
	public final void testLineChart_invalidY5(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Yaxis(null, null, null, null, null, null, null, null, null, null, null, null, "Manual", "Hallo");
		robot.clickButton("OK");
		
		robot.changeAppearance("Y ( Value )");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());

		
	}

	
	@Test
	public final void testBarChart3D_setZ(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Zaxis("Altova XMLSpy 2011", RED_COLOR_PALETTE_ICON, false, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	
	@Test
	public final void testBarChart3D_setZ_2(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Zaxis("Default setting test", null, true, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart3DGrouped_setZ(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d_Grouped);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Zaxis("Altova XMLSpy 2011", RED_COLOR_PALETTE_ICON, false, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart3DGrouped_setZ_2(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d_Grouped);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Zaxis("Default setting test", null, true, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart3D_set3DAngles(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_3DAngles("90", "25", "75", true);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart3D_set3DAngles2(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_3DAngles("90", "25", "75", false);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart3DGrouped_set3DAngles(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d_Grouped);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_3DAngles("90", "25", "75", false);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart3D_invalid3DAngles1(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_3DAngles("-5", null, null, null);
		robot.clickButton("OK");
		
		robot.changeAppearance("3d Angles");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
		
	}
	
	@Test
	public final void testBarChart3D_invalid3DAngles2(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_3DAngles(null, "hullo", "again", null);
		robot.clickButton("OK");
		
		robot.changeAppearance("3d Angles");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
		
	}
	
	@Test
	public final void testLoadFromFile_General(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.loadFromFile(SETTINGTOLOAD_XML_FILE);
		robot.clickButton("OK");
		
		robot.changeAppearance("General");
		
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testLoadFromFile_Schema(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.loadFromFile(SETTINGTOLOAD_XML_FILE);
		robot.clickButton("OK");
		
		robot.changeAppearance("Schema");
		
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testSaveToFile(){
		
		removeAndAssert(SETTINGTOSAVE_XML_FILE);
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");
		
		robot.saveToFile(SETTINGTOSAVE_XML_FILE);
		robot.clickButton("OK");
		
		assertFileExists(SETTINGTOSAVE_XML_FILE);
		
	}
	
	@Test
	public final void testSetToDefault_General(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.clickButton("OK");
		
		robot.changeAppearance("General");
		
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testSetToDefault_Schema(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.clickButton("OK");
		
		robot.changeAppearance("Schema");
		
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testPieChart_SelectData1(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");

		robot.selectDataPie("A", "C");
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
		robot.chartMenu("Select Data", "Select Data");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testPieChart_SelectData2(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");

		robot.selectDataPie("A", "B1:B5");
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
		robot.chartMenu("Select Data", "Select Data");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}

	@Test
	public final void testPieChart_SelectData3(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");

		robot.selectDataPie("A1:A5", "B");
		robot.clickButton("OK");
		
		//assertAreas(CHARTS);
		
		robot.chartMenu("Select Data", "Select Data");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testPieChart_invalidSelectData1(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");

		robot.selectDataPie("A", "hallo ");
		
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());	
		
		assertAreas(CHARTS);
	}

	@Test
	public final void testPieChart_invalidSelectData2(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");

		robot.selectDataPie("A1:", "B");
		
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());	
		
		assertAreas(CHARTS);
	}
	
	
	@Test
	public final void testPieChart_invalidSelectData3(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");

		robot.selectDataPie("A600", "B");
		
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());	
		
		assertAreas(CHARTS);
	}
	
	@Test
	public final void testPieChart_invalidSelectData4(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");

		robot.selectDataPie("abdcedfhijklmnopqrstuvwxyz", "abdcedfhijklmnopqrstuvwxyz");
		
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());	
		
		assertAreas(CHARTS);
	}
	
	@Test
	public final void testPieChart_invalidSelectData5(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");

		robot.selectDataPie("hallo ", "hallo ");
		robot.clickButton("OK");
		
		robot.chartMenu("Select Data", "Select Data");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
	}
	
	@Test
	public final void testPieChart_invalidSelectData6(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_2d);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");

		robot.selectDataPie("", "B");
		robot.clickButton("OK");

		robot.chartMenu("Select Data", "Select Data");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
	}
	
	@Test
	public final void testPieChart3D_SelectData(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Pie, PIE.Pie_Chart_3d);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		
		robot.chartMenu("Select Data", "Select Data");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}

	@Test
	public final void testBarChart_SelectData1(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		
		robot.chartMenu("Select Data", "Select Data");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testBarChart_SelectData2(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		
		robot.selectData("Min", null, null, null, "C");
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart_SelectData3(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		
		robot.selectData("Min", null, "Min", null, null);
		robot.selectData("Max", null, "Max", null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart_SelectData4(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		
		robot.selectData("Min", null, "Min", null, null);
		robot.selectData("Max", null, "Max", null, null);
		robot.selectData(null,  null, null, "", null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	@Test
	public final void testBarChart_SelectData5(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		

		robot.selectData(null, "this is a longer seriesname for testing", null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
	}
	
	
	
	
	@Test
	public final void testBarChart_InvalidSelectData1(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		

		//robot.selectData(null, "this is a longer seriesname for testing", null, null, null);
		robot.renameSeries("Min", "");
		robot.clickButton("OK");
		
		robot.chartMenu("Select Data", "Select Data");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testBarChart_InvalidSelectData2(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		

		//robot.selectData(null, "this is a longer seriesname for testing", null, null, null);
		robot.selectData(null, null, null, "", null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
	}
	
	
	
	@Test
	public final void testStackedBarChart_SelectData(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Stacked_Bar_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		

		robot.chartMenu("Select Data", "Select Data");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testStackedBarChart3D_SelectData(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		

		robot.chartMenu("Select Data", "Select Data");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}

	@Test
	public final void testBarChart3DGrouped_SelectData(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart_3d_Grouped);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		

		robot.chartMenu("Select Data", "Select Data");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testLineChart_SelectData(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		

		robot.chartMenu("Select Data", "Select Data");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testValueLineChart_SelectData1(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		

		robot.chartMenu("Select Data", "Select Data");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());

		
	}
	
	@Test
	public final void testValueLineChart_SelectData2(){
		
		robot.openFile(SINCOSATAN_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Value");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		
		robot.selectData("atan", null, null, null, "B", "B");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
		assertAreas(CHARTS);

		
	}
	
	@Test
	public final void testValueLineChart_SelectData3(){
		
		robot.openFile(SINCOSATAN_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Value");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		
		robot.selectData("atan", null, null, null, "B", "C1:C5");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
		assertAreas(CHARTS);

		
	}
	
	@Test
	public final void testValueLineChart_SelectData4(){
		
		robot.openFile(SINCOSATAN_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Value");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		
		robot.selectData("atan", null, null, null, "B", "A5:A50");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
		assertAreas(CHARTS);

		
	}
	
	
	@Test
	public final void testValueLineChart_SelectData5(){
		
		robot.openFile(SINCOSATAN_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Value");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		
		robot.selectData("atan", null, null, null, "B", "2");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
		assertAreas(CHARTS);

		
	}
	
	@Test
	public final void testValueLineChart_invalidSelectData1(){
		
		robot.openFile(SINCOSATAN_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Value");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		
		robot.selectData("atan", null, null, null, null, "A500");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
		assertAreas(CHARTS);

	}
	
	@Test
	public final void testValueLineChart_invalidSelectData2(){
		
		robot.openFile(SINCOSATAN_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Value");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		
		robot.selectData("atan", null, null, null, null, "reference");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
		assertAreas(CHARTS);

	}
	
	@Test
	public final void testValueLineChart_invalidSelectData3(){
		
		robot.openFile(SINCOSATAN_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Value");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Value_Line_Chart);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		
		robot.selectData("atan", null, null, null, null, "\"A\"");
		robot.clickButton("OK");
		
		assertAreas(CHARTS);

		robot.chartMenu("Select Data", "Select Data");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
	}
	
	@Test
	public final void testAreaChart_SelectData(){
		
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public final void testStackedAreaChart_SelectData(){
		
		fail("Not yet implemented"); // TODO
	}
		
	@Test
	public final void testCandlestickChart_SelectData(){
		
		robot.openFile(MICROSOFTSTOCKQUOTE_XML_FILE);
		
		robot.newChart_setSourceXPath(" /Import/Row[position() >= 1 and position() <= 8]");
		robot.updateColumns();
		robot.newChart_firstColumn("Date");
		robot.newChart_findSeriesColumn("olume", "Adj_x0020_Close");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Candlestick, CANDLESTICK.Candlestick_Chart);
		robot.clickButton("OK");
		
		robot.chartMenu("Select Data", "Select Data");
	
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
		assertTrue(robot.isApplicationFront());
	}
	
	
	@Test
	public final void testRoundGaugeChart_SelectData1(){
		
		robot.openFile(BIKEANDCARSMPH_XML_FILE);
		
		robot.newChart_setSourceXPath("/BikesAndCars/Bike");
		robot.updateColumns();
		robot.newChart_firstColumn("@name");
		//robot.newChart_findSeriesColumn("@year", "quarter_Mile_mph");
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Gauge, GAUGE.Round_Gauge);
		robot.clickButton("OK");

		robot.setToDefault(); 
		robot.clickButton("OK");
		
		robot.selectData("C1");

		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
		assertAreas(CHARTS);

	}

	
	@Test
	public final void testRoundGaugeChart_SelectData2(){
		
		robot.openFile(BIKEANDCARSMPH_XML_FILE);
		
		robot.newChart_setSourceXPath("/BikesAndCars/Bike");
		robot.updateColumns();
		robot.newChart_firstColumn("@name");
		//robot.newChart_findSeriesColumn("@year", "quarter_Mile_mph");
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Gauge, GAUGE.Round_Gauge);
		robot.clickButton("OK");

		robot.setToDefault(); 
		robot.clickButton("OK");
		
		robot.selectData("B:C");

		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
		assertAreas(CHARTS);

	}

	@Test
	public final void testRoundGaugeChart_SelectData3(){
		
		robot.openFile(BIKEANDCARSMPH_XML_FILE);
		
		robot.newChart_setSourceXPath("/BikesAndCars/Bike");
		robot.updateColumns();
		robot.newChart_firstColumn("@name");
		//robot.newChart_findSeriesColumn("@year", "quarter_Mile_mph");
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Gauge, GAUGE.Round_Gauge);
		robot.clickButton("OK");

		robot.setToDefault(); 
		robot.clickButton("OK");
		
		robot.selectData("4");

		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
		assertAreas(CHARTS);

	}

	@Test
	public final void testRoundGaugeChart_SelectData5(){
		
		robot.openFile(BIKEANDCARSMPH_XML_FILE);
		
		robot.newChart_setSourceXPath("/BikesAndCars/Bike");
		robot.updateColumns();
		robot.newChart_firstColumn("@name");
		//robot.newChart_findSeriesColumn("@year", "quarter_Mile_mph");
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Gauge, GAUGE.Round_Gauge);
		robot.clickButton("OK");

		robot.setToDefault(); 
		robot.clickButton("OK");
		
		robot.selectData("Hello");
		robot.clickButton("OK");
		
		assertAreas(CHARTS);

		robot.chartMenu("Select Data", "Select Data");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
	}
	
	@Test
	public final void testRoundGaugeChart_invalidSelectData1(){
		
		robot.openFile(BIKEANDCARSMPH_XML_FILE);
		
		robot.newChart_setSourceXPath("/BikesAndCars/Bike");
		robot.updateColumns();
		robot.newChart_firstColumn("@name");
		//robot.newChart_findSeriesColumn("@year", "quarter_Mile_mph");
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Gauge, GAUGE.Round_Gauge);
		robot.clickButton("OK");

		robot.setToDefault(); 
		robot.clickButton("OK");
		
		robot.selectData("reference");
		robot.clickButton("OK");
		
		assertAreas(CHARTS);

		robot.chartMenu("Select Data", "Select Data");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
	}
	
	@Test
	public final void testRoundGaugeChart_invalidSelectData2(){
		
		robot.openFile(BIKEANDCARSMPH_XML_FILE);
		
		robot.newChart_setSourceXPath("/BikesAndCars/Bike");
		robot.updateColumns();
		robot.newChart_firstColumn("@name");
		//robot.newChart_findSeriesColumn("@year", "quarter_Mile_mph");
		robot.clickButton("OK");

		robot.changeTypeChart(CHART.Gauge, GAUGE.Round_Gauge);
		robot.clickButton("OK");

		robot.setToDefault(); 
		robot.clickButton("OK");
		
		robot.selectData("A400");
		robot.clickButton("OK");
		
		//assertAreas(CHARTS);

		robot.chartMenu("Select Data", "Select Data");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
	}
	
	@Test
	public final void testBarGaugeChart_SelectData(){
		
		robot.openFile(BIKEANDCARSMPH_XML_FILE);
		
		robot.newChart_setSourceXPath("/BikesAndCars/Bike");
		robot.updateColumns();
		robot.clickButton("OK");
	
		robot.changeTypeChart(CHART.Gauge, GAUGE.Bar_Gauge);
		robot.clickButton("OK");

		robot.setToDefault();
		robot.clickButton("OK");		
		

		robot.chartMenu("Select Data", "Select Data");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}

	
	@Test
	public final void testSaveChartInFile(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.saveChartInFile(null, null, null);
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
		robot.clickButton("Cancel");
	}	
	
	@Test
	public final void testSaveChartInFileWithName(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.saveChartInFile("1000", "400", MINMAXTEMPERATUREEXPORT);
		assertFileExists(MINMAXTEMPERATUREEXPORT);
		
		robot.saveChartInFile(null, null, null);
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.keyType(VK_ESCAPE);
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
	}
	
	@Test
	public final void testOverlayTwoLinesWithSameBase(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Append");
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		
		robot.overlaysChart("Layer 2");
		robot.renameSeries("Min", "Min(2010)");
		robot.renameSeries("Max", "Max(2010)");
		robot.clickButton("OK");
		
		
		assertAreas(CHARTS);
		
		robot.overlaysChart("Layer 2");
		robot.overlaysChart("Delete Current");
	}
		

	@Test
	public final void testOverlayTwoLinesWithSameBaseRemoveOverlay(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Append");
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		
		robot.overlaysChart("Layer 2");
		robot.renameSeries("Min", "Min(2010)");
		robot.renameSeries("Max", "Max(2010)");
		robot.clickButton("OK");
		
		robot.overlaysChart("Layer 2");
		robot.overlaysChart("Delete Current");
		
		assertAreas(CHARTS);
	}

	@Test
	public final void testOverlayWithBarChart(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Append");
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Bar, BAR.Bar_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Layer 2");
		robot.renameSeries("Min", "Min(2010)");
		robot.renameSeries("Max", "Max(2010)");
		robot.clickButton("OK");

		assertAreas(CHARTS);
		
		robot.overlaysChart("Layer 2");
		robot.overlaysChart("Delete Current");

	}
	
	@Test
	public final void testOverlayTwoChartsDifferentColorSchema(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Append");
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");

		robot.overlaysChart("Layer 2");
		robot.setToDefault();
		robot.colorSchema("Schema", "astel", null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
		robot.overlaysChart("Layer 2");
		robot.overlaysChart("Delete Current");
		
	}

	
	@Test
	public final void testOverlaySwitchOff_ShowTicks(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Append");
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Layer 2");
		robot.renameSeries("Min", "Min(2010)");
		robot.renameSeries("Max", "Max(2010)");
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Yaxis(null, null, null, null, false, null, null, null, null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
		robot.overlaysChart("Layer 2");
		robot.overlaysChart("Delete Current");

	}
	
	@Test
	public final void testOverlaySwitchOff_ShowValues(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Append");
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Layer 2");
		robot.renameSeries("Min", "Min(2010)");
		robot.renameSeries("Max", "Max(2010)");
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Yaxis(null, null, null, null, null, false, null, null, null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
		robot.overlaysChart("Layer 2");
		robot.overlaysChart("Delete Current");

	}
	
	@Test
	public final void testOverlay_setToDefault(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Append");
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Layer 2");
		robot.renameSeries("Min", "Min(2010)");
		robot.renameSeries("Max", "Max(2010)");
		robot.clickButton("OK");
		
		robot.changeAppearance_Yaxis(null, null, null, null, null, null, "Left/Bottom", null, null, null, null, null, null, null);
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance("Y ( Value )");
		
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		assertTrue(robot.isApplicationFront());
		
		
		assertAreas(CHARTS);
		
		robot.overlaysChart("Layer 2");
		robot.overlaysChart("Delete Current");
		
	}

	@Test
	public final void testOverlay_AtValueCategoryNumber(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Append");
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Layer 2");
		robot.renameSeries("Min", "Min(2010)");
		robot.renameSeries("Max", "Max(2010)");
		robot.clickButton("OK");
		
		robot.setToDefault();
		robot.changeAppearance_Yaxis(null, null, null, null, null, null, "At Value", "60", null, null, null, null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
		robot.overlaysChart("Layer 2");
		robot.overlaysChart("Delete Current");
	}
	
	@Test
	public final void testOverlay_AreaChartWithTransparency(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Append");
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Area_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Layer 2");
		robot.renameSeries("Min", "Min(2010)");
		robot.renameSeries("Max", "Max(2010)");
		robot.clickButton("OK");

		robot.setToDefault();
		robot.changeAppearance_Area("220", null, null);
		robot.changeAppearance_Yaxis("Temp 2010", null, null, null, null, null, null, null, null, null, null, null, null, null);
		
		Sizes[] setElements = { new Sizes(" Y-Axis to Axis Label","15","%")};
		robot.changeAppearance_Sizes(setElements);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
		robot.overlaysChart("Layer 2");
		robot.overlaysChart("Delete Current");
	}
	
	@Test
	public final void testOverlay_TreeLayers(){
		
		//first layer
		robot.openFile(MINMAXTEMPERATURE2008_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		robot.colorSchema("Default", null, null);
		robot.changeAppearance_Line(true, false, false, false);
		robot.clickButton("OK");
		
		robot.overlaysChart("Append");
		//second layer
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		robot.colorSchema("Schema", "efault", null, null);
		robot.changeAppearance_Line(false, true, false, false);
		robot.clickButton("OK");
		
		robot.overlaysChart("Append");
		//3rd layer
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		robot.changeAppearance_Line(false, false, true, false);
		robot.clickButton("OK");
		
		robot.overlaysChart("Append");
		//4th layer
		robot.openFile(MINMAXTEMPERATURE2007_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		robot.changeAppearance_Line(false, false, false, true);
		robot.clickButton("OK");

		assertAreas(CHARTS);
		
		for (int i = 0; i < 3; i++) {
			
			robot.overlaysChart("Layer 2");
			robot.overlaysChart("Delete Current");
		}
	}


	@Test
	public final void testOverlay_changeLayerChargeToStackedAreaChart(){
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Append");
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Stacked_Area_Chart);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
		robot.overlaysChart("Layer 2");
		robot.overlaysChart("Delete Current");
	}

	@Test
	public final void testOverlay_changeAppereance_Main(){
		
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Area_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Append");
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Main");
		
		robot.setToDefault();
		robot.changeAppearance_General_Chart("Min/Max Temperature 2009 in Line Chart - picture background", null, null, null, null, NANONULL_GIF_LOGO, "Stretched");
		robot.changeAppearance_General_Plot(null, null, null, "Transparent", null, null, null);
		robot.clickButton("OK");
		
		assertAreas(CHARTS);
		
		robot.overlaysChart("Layer 2");
		robot.overlaysChart("Delete Current");
	}
	
	@Test
	public final void testOverlay_changeAppereance_Layer(){
		
		robot.openFile(MINMAXTEMPERATURE2009_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Area, AREA.Area_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Append");
		
		robot.openFile(MINMAXTEMPERATURE2010_XML_FILE);
		
		robot.newChart_setSourceXPath("/Import/Row");
		robot.updateColumns();
		robot.newChart_firstColumn("Month");
		robot.clickButton("OK");
		
		robot.changeTypeChart(CHART.Line, LINE.Line_Chart);
		robot.clickButton("OK");
		
		robot.overlaysChart("Layer 2");
		
		robot.changeAppearance("Line");
	
		try {
			assertAreas(TOP_WINDOW);
		} finally {
			robot.clickButton("OK");
			delay(1000);
		}
		
		robot.overlaysChart("Layer 2");
		robot.overlaysChart("Delete Current");
	}

}
