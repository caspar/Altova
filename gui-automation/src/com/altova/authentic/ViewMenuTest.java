package com.altova.authentic;

import org.junit.Test;

import com.altova.robots.CheckboxOption;
import com.altova.robots.Options;
import com.altova.robots.RadioOption;
import com.altova.robots.TextFieldOption;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

public class ViewMenuTest extends AbstractAuthenticTest {

	@Test
	public void testViewAuthenticView(){
		robot.browserView();
		robot.authenticView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testViewBrowserView(){
		robot.browserView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	
	@Test
	public final void testTabSize() {
		robot.openFileWithoutKnownSPS(EXPREPORT_NOTWELLFORMED_FILE);
		Options options_a=new Options();
		Options options_b=new Options();
		options_a.add(new TextFieldOption("Tab size:","9"));
		options_b.add(new TextFieldOption("Tab size:","4"));
		robot.textViewSettings(options_a);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		} finally {
			robot.textViewSettings(options_b);
		}
	}
	
	@Test
	public final void testInsertTabs(){
		robot.openFileWithoutKnownSPS(EXPREPORT_NOTWELLFORMED_FILE);
		Options options_a=new Options();
		Options options_b=new Options();
		options_a.add(new CheckboxOption("Whitespace markers",true));
		options_a.add(new RadioOption("Insert tabs"));
		options_b.add(new CheckboxOption("Whitespace markers",false));
		robot.textViewSettings(options_a);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		} finally {
			robot.textViewSettings(options_b);
		}
	}
	
	@Test
	public final void testInsertSpaces(){
		robot.openFileWithoutKnownSPS(EXPREPORT_NOTWELLFORMED_FILE);
		Options options_a=new Options();
		Options options_b=new Options();
		options_a.add(new CheckboxOption("Whitespace markers",true));
		options_a.add(new RadioOption("Insert spaces"));
		options_b.add(new CheckboxOption("Whitespace markers",false));
		options_b.add(new RadioOption("Insert tabs"));
		robot.textViewSettings(options_a);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		} finally {
			robot.textViewSettings(options_b);
		}
	}
	
	
	@Test
	public final void testEndOfLineMarkersOff() {
		robot.openFileWithoutKnownSPS(EXPREPORT_NOTWELLFORMED_FILE);
		Options optionsf=new Options();
		optionsf.add(new CheckboxOption("End of line markers",false));
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	public final void testEndOfLineMarkersOn() {
		robot.openFileWithoutKnownSPS(EXPREPORT_NOTWELLFORMED_FILE);
		Options optionst=new Options();
		Options optionsf=new Options();
		optionst.add(new CheckboxOption("End of line markers",true));
		optionsf.add(new CheckboxOption("End of line markers",false));
		robot.textViewSettings(optionst);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
		finally {
			robot.textViewSettings(optionsf);
		}
	}
	
	@Test
	public final void testWhitespaceMarkersOff() {
		robot.openFileWithoutKnownSPS(EXPREPORT_NOTWELLFORMED_FILE);
		Options optionsf=new Options();
		optionsf.add(new CheckboxOption("Whitespace markers",false));
		robot.textViewSettings(optionsf);
		assertAreas(DIAGRAM_MAIN_WINDOW);
		
	}

	@Test
	public final void testWhitespaceMarkersOn() {
		robot.openFileWithoutKnownSPS(EXPREPORT_NOTWELLFORMED_FILE);
		Options optionst=new Options();
		Options optionsf=new Options();
		optionst.add(new CheckboxOption("Whitespace markers",true));
		optionsf.add(new CheckboxOption("Whitespace markers",false));
		robot.textViewSettings(optionst);
		try {
			assertAreas(DIAGRAM_MAIN_WINDOW);
		}
		finally {
			robot.textViewSettings(optionsf);
		}
	}
	
}
