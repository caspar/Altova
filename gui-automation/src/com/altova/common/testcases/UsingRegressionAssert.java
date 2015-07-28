package com.altova.common.testcases;

import static com.altova.util.LoggerUtils.logger;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.altova.robots.AltovaApplicationRobot;
import com.altova.robots.TestImageRecognition;
import com.altova.spy.SpyRobot;
import com.altova.util.AltovaJUnitRunner;
import com.altova.util.AltovaJUnitRunner.TestRobot;
import static com.altova.robots.SnapshotArea.CommonArea.TOP_WINDOW;

@TestRobot(SpyRobot.class)

@RunWith(AltovaJUnitRunner.class)

public class UsingRegressionAssert extends AbstractJUnitTest{
//	private static AltovaApplicationRobot robot = new SpyRobot();

	private static SpyRobot robot;
	
	public static void setRobot(SpyRobot robot){
		UsingRegressionAssert.robot=robot;
		
	}
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		AbstractJUnitTest.setUpBeforeClass(robot);
	}
	@Test
	public void testWhatIGet()  {
		
		logger.info(getRunName(robot));
		logger.info(getTestName());
		assertAreas(TOP_WINDOW);
		
		
	}

}
	
	

