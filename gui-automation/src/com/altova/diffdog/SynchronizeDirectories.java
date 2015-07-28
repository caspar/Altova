package com.altova.diffdog;

import java.awt.Rectangle;
import java.io.File;

import org.junit.Test;

import static com.altova.robots.SnapshotArea.CommonArea.*;
import static java.awt.event.KeyEvent.*;

import com.altova.robots.CheckboxOption;
import com.altova.robots.ImageUtils;
import com.altova.robots.Pane;
import com.altova.robots.RadioOption;
import com.altova.util.IOUtils;


public class SynchronizeDirectories extends AbstractDiffDogTest{

	private static final String DIRDIFF_LEFT = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\LeftSide\\DirDiff_1";
	private static final String DIRDIFF_RIGHT = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\RightSide\\DirDiff";
	
	protected final String _copy_tag = IOUtils.findFileDiffDog("tags_list\\DirectorySynchronization\\","_copy.PNG").getAbsolutePath();
	protected final String attr1_tag = IOUtils.findFileDiffDog("tags_list\\DirectorySynchronization\\","attr1.PNG").getAbsolutePath();
	protected final String delete_tag = IOUtils.findFileDiffDog("tags_list\\DirectorySynchronization\\","delete.PNG").getAbsolutePath();
	protected final String doc1_tag = IOUtils.findFileDiffDog("tags_list\\DirectorySynchronization\\","doc1.PNG").getAbsolutePath();
	protected final String doc1_delete_tag = IOUtils.findFileDiffDog("tags_list\\DirectorySynchronization\\","doc1_delete.PNG").getAbsolutePath();
	protected final String copyMissing_tag = IOUtils.findFileDiffDog("tags_list\\DirectorySynchronization\\","copyMissing.PNG").getAbsolutePath();
	protected final String moveDeletedFiles_tag = IOUtils.findFileDiffDog("tags_list\\DirectorySynchronization\\","moveDeletedFiles.PNG").getAbsolutePath();
	protected final String _delete_tag = IOUtils.findFileDiffDog("tags_list\\DirectorySynchronization\\","_delete.PNG").getAbsolutePath();
	protected final String bewerbung_tag = IOUtils.findFileDiffDog("tags_list\\DirectorySynchronization\\","bewerbung.PNG").getAbsolutePath();
	protected final String copyOfXML_tag = IOUtils.findFileDiffDog("tags_list\\DirectorySynchronization\\","copyOfXML.PNG").getAbsolutePath();
	protected final String delete__tag = IOUtils.findFileDiffDog("tags_list\\DirectorySynchronization\\","delete_.PNG").getAbsolutePath();
	protected final String doc1_2 = IOUtils.findFileDiffDog("tags_list\\DirectorySynchronization\\","doc1_2.PNG").getAbsolutePath();
	
	
	
	
	@Test
	public void testOpenSynchronizeDirectoriesDialog(){
		robot.compare2Directories(DIRDIFF_LEFT, DIRDIFF_RIGHT);
		robot.leftClickMenuItem("Diff and Merge", "Synchronize directories");
		delay(1000);
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	@Test
	public void testFullySynchronizeChangeSynchDirection(){
		robot.compare2Directories(DIRDIFF_LEFT, DIRDIFF_RIGHT);
		robot.leftClickMenuItem("Diff and Merge", "Synchronize directories");
		delay(1000);
		robot.setDiffDogOptions(new RadioOption("Right to left"));
		delay(1000);
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}

	@Test
	public void testFullySynchronizeUseDetailedSettings(){
		robot.compare2Directories(DIRDIFF_LEFT, DIRDIFF_RIGHT);
		robot.leftClickMenuItem("Diff and Merge", "Synchronize directories");
		delay(1000);
		robot.setDiffDogOptions(new RadioOption("Use detailed settings below for Different and Missing files"));
		delay(1000);
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	@Test
	public void testFullySynchronizeEnableManualOverride(){
		robot.compare2Directories(DIRDIFF_LEFT, DIRDIFF_RIGHT);
		robot.leftClickMenuItem("Diff and Merge", "Synchronize directories");
		delay(1000);
		robot.setDiffDogOptions(new RadioOption("Enable manual override of synchronization actions"));
		delay(1000);
		robot.scrollPane(new Pane("Preview"), 1.0);
		robot.leftClickOnIcon(attr1_tag, null);
		delay(500);
		robot.leftClickOnIcon(_copy_tag, null);
		delay(1500);
		robot.okButton();
		delay(500);
		robot.leftClickOnIcon(doc1_tag, null);
		delay(500);
		robot.leftClickOnIcon(delete_tag, null);
		delay(500);
		robot.setDiffDogOptions(new RadioOption("Right to left"));
		delay(1000);
		robot.leftClickOnIcon(doc1_delete_tag, null);		
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
		delay(500);
		robot.okButton();
	}
	
	@Test
	public void testUseDetailedEettingsChangeDifferentFilesSettingsSt1(){
		robot.compare2Directories(DIRDIFF_LEFT, DIRDIFF_RIGHT);
		robot.leftClickMenuItem("Diff and Merge", "Synchronize directories");
		delay(1000);
		robot.setDiffDogOptions(new RadioOption(" Use detailed setting", false), new CheckboxOption("Right to left", false));
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	@Test
	public void testUseDetailedEettingsChangeDifferentFilesSettingsSt2(){
		robot.compare2Directories(DIRDIFF_LEFT, DIRDIFF_RIGHT);
		robot.leftClickMenuItem("Diff and Merge", "Synchronize directories");
		delay(1000);
		robot.setDiffDogOptions(new RadioOption(" Use detailed setting", false),new CheckboxOption("Left to right", false));
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	@Test
	public void testUseDetailedEettingsChangeDifferentFilesSettingsSt3(){
		robot.compare2Directories(DIRDIFF_LEFT, DIRDIFF_RIGHT);
		robot.leftClickMenuItem("Diff and Merge", "Synchronize directories");
		delay(1000);
		robot.setDiffDogOptions(new RadioOption(" Use detailed setting", false),new CheckboxOption("Create backup files", false));
		delay(1000);
		robot.keyTypeShift(VK_TAB);
		delay(1000);
		robot.keyType(VK_UP);
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	//od tad sprawdzane!!
	@Test
	public void testUseDetailedSettingsChangeMissingFilesDirectoriesSt1(){
		robot.compare2Directories(DIRDIFF_LEFT, DIRDIFF_RIGHT);
		robot.leftClickMenuItem("Diff and Merge", "Synchronize directories");
		delay(1000);
		robot.setDiffDogOptions(new RadioOption(" Use detailed setting", false));
		robot.leftClickOnIcon(copyMissing_tag, null);
		delay(1000);
		robot.keyType(VK_DOWN);
		delay(1000);
		robot.keyType(VK_ENTER);
		robot.setDiffDogOptions(new CheckboxOption("Right only", false));
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	@Test
	public void testUseDetailedSettingsChangeMissingFilesDirectoriesSt2(){
		robot.compare2Directories(DIRDIFF_LEFT, DIRDIFF_RIGHT);
		robot.leftClickMenuItem("Diff and Merge", "Synchronize directories");
		delay(1000);
		robot.setDiffDogOptions(new RadioOption(" Use detailed setting"));
		robot.leftClickOnIcon(copyMissing_tag, null);
		delay(1000);
		robot.keyType(VK_DOWN);
		delay(1000);
		robot.keyType(VK_ENTER);
		delay(500);
		robot.keyType(VK_TAB);
		delay(500);
		robot.keyType(VK_DOWN);
		delay(500);
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	

	@Test
	public void testUseDetailedSettingsChangeMissingFilesDirectoriesSt3(){
		robot.compare2Directories(DIRDIFF_LEFT, DIRDIFF_RIGHT);
		robot.leftClickMenuItem("Diff and Merge", "Synchronize directories");
		delay(1000);
		robot.setDiffDogOptions(new RadioOption(" Use detailed setting"));
		robot.leftClickOnIcon(copyMissing_tag, null);
		delay(1000);
		robot.keyType(VK_UP);
		delay(1000);
		robot.keyType(VK_ENTER);
		delay(500);
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	
	@Test
	public void testUseDetailedSettingsPermanentlyDelete(){
		robot.compare2Directories(DIRDIFF_LEFT, DIRDIFF_RIGHT);
		robot.leftClickMenuItem("Diff and Merge", "Synchronize directories");
		delay(1000);
		robot.setDiffDogOptions(new RadioOption(" Use detailed setting"));
		robot.leftClickOnIcon(moveDeletedFiles_tag, null);
		delay(1000);
		robot.keyType(VK_DOWN);
		delay(1000);
		robot.keyType(VK_ENTER);
		delay(500);
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
	}
	@Test
	public void testUseDetailedSettingsEnableManualOverrideReset_All(){
		robot.compare2Directories(DIRDIFF_LEFT, DIRDIFF_RIGHT);
		robot.leftClickMenuItem("Diff and Merge", "Synchronize directories");
		delay(1000);
		robot.setDiffDogOptions(new RadioOption(" Use detailed setting", false));
		delay(1000);
		robot.setDiffDogOptions(new RadioOption("Enable manual override of synchronization actions"));
		delay(1000);
		
		robot.scrollPane(new Pane("Preview"), 1.0);
		robot.leftClickOnIcon(bewerbung_tag, null);
		delay(500);
		robot.leftClickOnIcon(delete__tag, null);
		delay(1500);
		robot.okButton();
		delay(500);
		robot.leftClickOnIcon(copyOfXML_tag, null);
		delay(500);
		robot.leftClickOnIcon(delete_tag, null);
		delay(500);
		robot.leftClickOnIcon(doc1_2, null);
		delay(500);
		robot.leftClickOnIcon(delete_tag, null);
		delay(500);
		
		assertAreas(TOP_WINDOW);
		robot.cancelButton();
		delay(500);
		robot.okButton();
	}
}
