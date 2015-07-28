package com.altova.diffdog;

import static com.altova.robots.SnapshotArea.CommonArea.MF_MAIN_WINDOW;
import static java.awt.event.KeyEvent.VK_ESCAPE;

import java.io.File;

import org.junit.Test;

import com.altova.util.IOUtils;



public class DirectoryComparisonTest extends AbstractDiffDogTest{
	private static final String DIRDIFF1 = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\LeftSide\\DirDiff";
	private static final String DIRDIFF2 = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\RightSide\\DirDiff";
	
	private static final String DIRDIFF_A1 = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\LeftSide\\DirDiff_1";
	private static final String DIRDIFF_A2 = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\RightSide\\DirDiff_1";
	
	private static final String DIRDIFF_B1 = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\LeftSide\\DirDiff_2";
	private static final String DIRDIFF_B2 = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\RightSide\\DirDiff_2";
	
	private static final String DIRDIFF_ZIP1 = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\LeftSide\\DirDiff_ZIP";
	private static final String DIRDIFF_ZIP2 = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\RightSide\\DirDiff_ZIP";
	
	private static final String DIRDIFF_FOLDERICONS1 = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\LeftSide\\DirDiff_FolderIcons";
	private static final String DIRDIFF_FOLDERICONS2 = System.getProperty("user.dir") + "\\data\\diffdog\\examples\\RightSide\\DirDiff_FolderIcons";
	
	private static final File FIRST_DIFFERENCE=IOUtils.findFileDiffDog("tags_list/","FirstDifference.png");
	
	@Test
	public void testDirectoryComparisonAsTXT(){
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		delay(2000);
		robot.setToogle(false,robot.QUICK_COMP_ON , robot.QUICK_COMP_OFF);
		robot.setCompareAsTXT();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testDirectoryComparisonAsXML(){
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		delay(2000);
		robot.setCompareAsXML();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testDirectoryAsBinary(){
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		delay(2000);
		robot.setCompareAsBinary();
		assertAreas(MF_MAIN_WINDOW);
	}
	
	@Test
	public void testDirectoryComparisonAccordingToFileExtensionSettings(){
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		delay(2000);
		robot.setCompareAccordingToFileExtensionSettings();
		assertAreas(MF_MAIN_WINDOW);
	}
	@Test
	public void testShowFilesInZipArchives(){
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		delay(5000);
		robot.setShowFilesInZip();
		if(!robot.escapeDialog("Extension-based Comparison...", VK_ESCAPE))
			fail("Extension-based Comparison Windows doesn't show up");
		robot.setShowFilesInZip();
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteSettingsRegistryKeys();
		robot.deleteRegistry();
	}
	
	@Test
	public void testIncludeSubDirectories1(){
		/**
		 * step1:Include Subdirectories = toggled on
		 * step2: Include Subdirectories = toggled off
		 * step3: Show files in ZIP archives = toggled on
		 * Include Subdirectories = toggled off
		 * step4: Show files in ZIP archives = toggled on
		 * Include Subdirectories = toggled on
		 * 
		 */
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		delay(5000);
		robot.setQuickComparison(true);
		robot.setDirectoryComparPanel(2,2,2,2,2,2,1);
		delay(2000);
		robot.startComparison();
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.startComparison();
		delay(2000);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test
	public void testIncludeSubDirectories2(){
		/**
		 * step1:Include Subdirectories = toggled on
		 * step2: Include Subdirectories = toggled off
		 * step3: Show files in ZIP archives = toggled on
		 * Include Subdirectories = toggled off
		 * step4: Show files in ZIP archives = toggled on
		 * Include Subdirectories = toggled on
		 * 
		 */
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		delay(5000);
		robot.setDirectoryComparPanel(2,2,2,2,2,2,0);
		delay(2000);
		robot.startComparison();
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.startComparison();
		delay(2000);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test
	public void testIncludeSubDirectories3(){
		/**
		 * step1:Include Subdirectories = toggled on
		 * step2: Include Subdirectories = toggled off
		 * step3: Show files in ZIP archives = toggled on
		 * Include Subdirectories = toggled off
		 * step4: Show files in ZIP archives = toggled on
		 * Include Subdirectories = toggled on
		 * 
		 */
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		delay(5000);
		robot.setDirectoryComparPanel(2,2,2,2,2,2,0);
		robot.setShowFilesInZip(true);
		delay(2000);
		robot.startComparison();
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.startComparison();
		delay(2000);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test
	public void testIncludeSubDirectories4(){
		/**
		 * step1:Include Subdirectories = toggled on
		 * step2: Include Subdirectories = toggled off
		 * step3: Show files in ZIP archives = toggled on
		 * Include Subdirectories = toggled off
		 * step4: Show files in ZIP archives = toggled on
		 * Include Subdirectories = toggled on
		 */
		
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		delay(5000);
		robot.setDirectoryComparPanel(2,2,2,2,2,2,1);
		robot.escapeDialog("Extension-based Comparison...", VK_ESCAPE);
		robot.setShowFilesInZip(true);
		delay(5000);
		robot.escapeDialog("Extension-based Comparison...", VK_ESCAPE);
		robot.startComparison();
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.startComparison();
		delay(2000);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test
	public void testShowHideNotComparable(){
		/**
		 * Include Subdirectories = toggled on
		 * step1:  Show/Hide equal = OFF
		 * step2:  XML comparison
		 *         Show/Hide equal = on
		 *         Show/Hide not comparable = OFF
		 * step3:  XML comparison
		 *         Show/Hide equal = on
		 *         Show/Hide not comparable = ON"
		 */
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		delay(5000);
		robot.setDirectoryComparPanel(0,2,2,2,2,2,1);
		robot.startComparison();
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.startComparison();
		delay(2000);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test
	public void testShowHideNotComparable2(){
		/**
		 * Include Subdirectories = toggled on
		 * step1:  Show/Hide equal = OFF
		 * step2:  XML comparison
		 *         Show/Hide equal = on
		 *         Show/Hide not comparable = OFF
		 * step3:  XML comparison
		 *         Show/Hide equal = on
		 *         Show/Hide not comparable = ON"
		 */
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		delay(5000);
		robot.setDirectoryComparPanel(1,2,2,2,2,0,1);
		robot.startComparison();
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.startComparison();
		delay(2000);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test
	public void testShowHideNotComparable3(){
		/**
		 * Include Subdirectories = toggled on
		 * step1:  Show/Hide equal = OFF
		 * step2:  XML comparison
		 *         Show/Hide equal = on
		 *         Show/Hide not comparable = OFF
		 * step3:  XML comparison
		 *         Show/Hide equal = on
		 *         Show/Hide not comparable = ON"
		 */
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		delay(5000);
		robot.setDirectoryComparPanel(1,2,2,2,2,1,1);
		robot.startComparison();
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.startComparison();
		delay(2000);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test
	public void testShowHideLeftRightOnly1(){
		/**
		 * Show/Hide - left only, right only
		 * step1:  show/hide left only = off
		 * step2:  show/hide left only = on
		 *         show/hide right only = off
		 * step3:  show/hide left only=off
		 *         show/hide right only = off
		 */
		robot.compare2Directories(DIRDIFF_A1, DIRDIFF_A2);
		delay(5000);
		robot.setDirectoryComparPanel(2,2,2,0,1,2,2);
		robot.startComparison();
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.startComparison();
		delay(2000);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test
	public void testShowHideLeftRightOnly2(){
		/**
		 * Show/Hide - left only, right only
		 * step1:  show/hide left only = off
		 * step2:  show/hide left only = on
		 *         show/hide right only = off
		 * step3:  show/hide left only=off
		 *         show/hide right only = off
		 */
		robot.compare2Directories(DIRDIFF_A1, DIRDIFF_A2);
		delay(5000);
		robot.setDirectoryComparPanel(2,2,2,1,0,2,2);
		robot.startComparison();
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.startComparison();
		delay(2000);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test
	public void testShowHideLeftRightOnly3(){
		/**
		 * Show/Hide - left only, right only
		 * step1:  show/hide left only = off
		 * step2:  show/hide left only = on
		 *         show/hide right only = off
		 * step3:  show/hide left only=off
		 *         show/hide right only = off
		 */
		robot.compare2Directories(DIRDIFF_A1, DIRDIFF_A2);
		delay(5000);
		robot.setDirectoryComparPanel(2,2,2,0,0,2,2);
		robot.startComparison();
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.startComparison();
		delay(2000);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test
	public void testShowHideLeftRightNewer1(){
		/**
		 *  step1:  show/hide left newer = off
		 *  step2:  show/hide left newer = on
		 *  		show/hide right newer = off
		 *  step3:  show/hide left newer=off
		 *          show/hide right newer = off
		 */
		robot.compare2Directories(DIRDIFF_B1, DIRDIFF_B2);
		delay(5000);
		robot.setDirectoryComparPanel(2,0,1,2,2,2,2);
		robot.startComparison();
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.startComparison();
		delay(2000);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test
	public void testShowHideLeftRightNewer2(){
		/**
		 *  step1:  show/hide left newer = off
		 *  step2:  show/hide left newer = on
		 *  		show/hide right newer = off
		 *  step3:  show/hide left newer=off
		 *          show/hide right newer = off
		 */
		robot.compare2Directories(DIRDIFF_B1, DIRDIFF_B2);
		delay(5000);
		robot.setDirectoryComparPanel(2,1,0,2,2,2,2);
		robot.startComparison();
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.startComparison();
		delay(2000);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test
	public void testShowHideLeftRightNewer3(){
		/**
		 *  step1:  show/hide left newer = off
		 *  step2:  show/hide left newer = on
		 *  		show/hide right newer = off
		 *  step3:  show/hide left newer=off
		 *          show/hide right newer = off
		 */
		robot.compare2Directories(DIRDIFF_B1, DIRDIFF_B2);
		delay(5000);
		robot.setDirectoryComparPanel(2,0,0,2,2,2,2);
		robot.startComparison();
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.startComparison();
		delay(2000);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test
	public void testNextDifference(){
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		delay(5000);
		robot.setShowFilesInZip(true);
		delay(5000);
		robot.startComparison();
		delay(500);
		robot.nextDifference();
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test
	public void testFirstDifference(){
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		delay(5000);
		robot.setShowFilesInZip(true);
		delay(5000);
		robot.startComparison();
		delay(500);
		robot.firstDifference();
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test
	public void testLastDifference(){
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		delay(5000);
		robot.setShowFilesInZip(true);
		delay(5000);
		robot.startComparison();
		delay(500);
		robot.lastDifference();
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	@Test
	public void testOpenNotEqualFilePair(){
		robot.compare2Directories(DIRDIFF1, DIRDIFF2);
		delay(5000);
		robot.startComparison();
		delay(500);
		robot.firstDifference();
		delay(500);
		robot.doubleClickOnIcon(FIRST_DIFFERENCE.getAbsolutePath());
		delay(500);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	
// "Tools | Options File types > .docx = ZIP conformant is needed to run these tests


	@Test
	public void testCheckZipAndOOXMLIcons1(){
		/**
		 * step1: include subdirectories = on
		 * step2: include subdirectories = off
		 */
		robot.compare2Directories(DIRDIFF_ZIP1, DIRDIFF_ZIP2);
		delay(5000);
		robot.setDirectoryComparPanel(2, 2, 2, 2, 2, 2, 1);
		robot.setShowFilesInZip(true);
		robot.startComparison();
		delay(500);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test
	public void testCheckZipAndOOXMLIcons2(){
		/**
		 * step1: include subdirectories = on
		 * step2: include subdirectories = off
		 */
		robot.compare2Directories(DIRDIFF_ZIP1, DIRDIFF_ZIP2);
		delay(5000);
		robot.setDirectoryComparPanel(2, 2, 2, 2, 2, 2, 0);
		robot.setShowFilesInZip(true);
		robot.startComparison();
		delay(500);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	
	@Test
	public void testCheckFoldersIconsSubdirectoriesOn(){
		robot.compare2Directories(DIRDIFF_FOLDERICONS1, DIRDIFF_FOLDERICONS2);
		delay(5000);
		robot.setDirectoryComparPanel(2,2,2,2,2,2,1);
		robot.startComparison();
		robot.setCursorAtBeginning(RIGHT_SIDE);
		robot.startComparison();
		delay(2000);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
	
	@Test
	public void testCheckFoldersIconsSubdirectoriesOff(){
		robot.compare2Directories(DIRDIFF_FOLDERICONS1, DIRDIFF_FOLDERICONS2);
		delay(5000);
		robot.setDirectoryComparPanel(2,2,2,2,2,2,0);
		robot.startComparison();
		robot.escapeDialog("No differences found!",VK_ESCAPE);
		assertAreas(MF_MAIN_WINDOW);
		robot.deleteRegistry();
	}
}
