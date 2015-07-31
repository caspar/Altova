package com.altova.umodel.regression.testcases;
import java.io.IOException;

import com.altova.robots.Pane.PaneSize;
import com.altova.umodel.regression.gui.UModelRobot;

import static com.altova.util.LoggerUtils.logger;

/**
 * This class creates separate unit tests UModel files for each UML element.
 * 
 * @author Havard Rast Blok
 *
 */
public class CreateUnitTests {

	private UModelRobot robot;
	
	public CreateUnitTests() throws IOException {
		robot = new UModelRobot();
		
		robot.setModelTreeSize(PaneSize.NORMAL);
		
		//activity diagram elements
		String activityElements[] = {
			"ID_ADD_CALL_BEHAVIOR_ACTION",
			"ID_ADD_CALL_OPERATION_ACTION",
			"ID_ADD_ACCEPT_EVENT_ACTION",
			"ID_ADD_ACCEPT_EVENT_TIME_ACTION",
			"ID_ADD_SEND_SIGNAL_ACTION",
			"ID_ADD_DECISION_NODE",
			"ID_ADD_MERGE_NODE",
			"ID_ADD_INITIAL_NODE",
			"ID_ADD_ACTIVITY_FINAL_NODE",
			"ID_ADD_FLOW_FINAL_NODE",
			"ID_ADD_FORK_NODE",
			"ID_ADD_JOIN_NODE",
			"ID_ADD_FORK_NODE_HORIZONTAL",
			"ID_ADD_JOIN_NODE_HORIZONTAL",
			//"ID_ADD_INPUT_PIN",
			//"ID_ADD_OUTPUT_PIN",
			//"ID_ADD_ACTION_INPUT_PIN",
			//"ID_ADD_VALUE_PIN",
			//"ID_ADD_OBJECT_NODE",
			"ID_ADD_CENTRAL_BUFFER_NODE",
			"ID_ADD_DATA_STORE_NODE",
			"ID_ADD_ACTIVITY_PARAMETER_NODE",
			"ID_ADD_ACTIVITY_PARTITION",
			"ID_ADD_ACTIVITY_PARTITION_VERTICAL",
			//"ID_ADD_CONTROL_FLOW",
			//"ID_ADD_OBJECT_FLOW",
			//"ID_ADD_EXCEPTION_HANDLER",
			"ID_ADD_ACTIVITY_PARTITION2D",
			"ID_ADD_ACTIVITY",
			"ID_ADD_INTERRUPTABLE_ACTIVITY_REGION",
			"ID_ADD_STRUCTURED_ACTIVITY_NODE",
			"ID_ADD_EXPANSION_REGION",
			"ID_ADD_EXPANSION_NODE"
			
		};
		
		createTests("Activity", activityElements);
		
		
		//State machine elements
		String stateElements[] = {
			"ID_ADD_STATE",
			"ID_ADD_PSEUDOSTATE_INITIAL",
			"ID_ADD_FINAL_STATE",
			"ID_ADD_PSEUDOSTATE_ENTRYPOINT",
			"ID_ADD_PSEUDOSTATE_EXITPOINT",
			"ID_ADD_PSEUDOSTATE_JUNCTION",
			"ID_ADD_PSEUDOSTATE_TERMINATE",
			"ID_ADD_PSEUDOSTATE_DEEPHISTORY",
			"ID_ADD_PSEUDOSTATE_SHALLOWHISTORY",
			"ID_ADD_PSEUDOSTATE_JOIN",
			"ID_ADD_PSEUDOSTATE_JOIN_HORIZONTAL",
			"ID_ADD_PSEUDOSTATE_FORK",
			"ID_ADD_PSEUDOSTATE_FORK_HORIZONTAL",
			"ID_ADD_PSEUDOSTATE_CHOICE",
			//"ID_ADD_TRANSITION",
			"ID_ADD_STATE_SUBMACHINE",
			"ID_ADD_STATE_COMPOSITE",
			"ID_ADD_STATE_ORTHOGONAL",
			"ID_ADD_CONNECTION_POINT_REFERENCE"
		};
		
		createTests("State Machine", stateElements);
		
		//Composite structure diagram
		String compElements[] = {
				"ID_ADD_COLLABORATION",
				"ID_ADD_CLASS"
		};
		
		createTests("Composite Structure", compElements);
		
		//Interaction Overview diagram
		String intOverElements[] = {
				"ID_ADD_INTERACTION_CALLBEHAVIORACTION",
				"ID_ADD_INTERACTIONUSE_CALLBEHAVIORACTION",
				"ID_ADD_DURATION_CONSTRAINT",
		};
		
		createTests("Interaction Overview", intOverElements);
		
		//Timing diagram
		String intTimingElements[] = {
				"ID_ADD_LIFELINE_STATE_CONDITION",
				"ID_ADD_LIFELINE_GENERAL_VALUE",
				//"ID_ADD_STATE_CONDITION", //is this there?
				"ID_ADD_TIME_CONSTRAINT"
		};
		
		createTests("Timing", intTimingElements);
		
		//XSD diagram
		String intXsdElements[] = {
				"ID_ADD_XSD_TARGETNAMESPACE",
				"ID_ADD_XSD_SCHEMA",
				"ID_ADD_XSD_ELEMENT",
				"ID_ADD_XSD_GROUP",
				"ID_ADD_XSD_COMPLEXTYPE",
				"ID_ADD_XSD_COMPLEXTYPE_SIMPLE_CONTENT",
				"ID_ADD_XSD_SIMPLETYPE",
				"ID_ADD_XSD_LIST",
				"ID_ADD_XSD_UNION",
				"ID_ADD_XSD_ENUMERATION",
				"ID_ADD_XSD_ATTRIBUTE",
				"ID_ADD_XSD_ATTRIBUTE_GROUP",
				"ID_ADD_XSD_NOTATION",
				"ID_ADD_XSD_CHOICE",
				"ID_ADD_XSD_SEQUENCE",
				"ID_ADD_XSD_ALL",
				//"ID_ADD_XSD_RESTRICTION",
				//"ID_ADD_XSD_EXTENSION",
				//"ID_ADD_XSD_SUBSTITUTION",
				//"ID_ADD_XSD_IMPORT",
				//"ID_ADD_XSD_INCLUDE",
				//"ID_ADD_XSD_REDEFINE",
		};
		
		createTests("XML Schema", intXsdElements);
	}
	
	public void createTests(String diagram, String elements[]) throws IOException {
		for(String id : elements) {
			newTest(diagram, id);
		}
	}
	
	public void newTest(String diagram, String elementId) throws IOException {
		robot.newPrj();
		robot.delay(1000);
		robot.newDiagram(diagram);
		robot.delay(1000);
		newElement(elementId);
		robot.delay(1000);  //missing icons without this one...
		
		String fileName = elementId.replaceAll("ID_ADD_", "").toLowerCase() + ".ump";
		String path = "c:\\temp\\unit_tests\\"+diagram.replace(' ','_')+"\\"+fileName;
		logger.info("Saving diagram to "+path);
		robot.saveReplacePrj(path);
	}
	
	public void newElement(String elementId) {
		robot.putElement(elementId, 500, 200);
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new CreateUnitTests();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
