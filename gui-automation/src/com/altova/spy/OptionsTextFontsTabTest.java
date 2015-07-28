package com.altova.spy;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import static com.altova.robots.ImageRecognitionRobot.MS_SHELL_DLG_FONT;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.TextFontOption;
import com.altova.robots.FontOption.FontSettings;
import com.altova.util.IOUtils;


public class OptionsTextFontsTabTest extends AbstractSpyOptionsDialogTest{

	//set all of them to ignore till ttp 23812 gets fixed
	
	@Test
	public void testElementNamesXML(){
		Font deffont =new Font("Arial",Font.PLAIN,10);
		Color brown=new Color(128,0,0);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,brown);
		Font fontnew =new Font("Times New Roman",Font.BOLD,12);
		FontSettings fontnewset =new FontSettings(fontnew,false,Color.YELLOW,Color.BLACK);
		TextFontOption t=new TextFontOption("Element names","XML generic",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.textView();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testAttNamesXML(){
		Font deffont =new Font("Times New Roman",Font.PLAIN,12);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,Color.RED);
		Font fontnew =new Font("Courier New",Font.BOLD+Font.ITALIC,8);
		FontSettings fontnewset =new FontSettings(fontnew,false,Color.PINK,Color.YELLOW);
		TextFontOption t=new TextFontOption("Attribute names","XML generic",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.textViewKey();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testContentsXML(){
		Font deffont =new Font("Courier New",Font.PLAIN,8);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,Color.BLACK);
		Font fontnew =new Font("Rockwell",Font.BOLD+Font.ITALIC,10);
		FontSettings fontnewset =new FontSettings(fontnew,true,Color.RED,Color.WHITE);
		TextFontOption t=new TextFontOption("Contents","XML generic",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.textViewKey();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testOperatorXML(){
		Font deffont =new Font("Rockwell",Font.PLAIN,10);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,Color.BLUE);
		Font fontnew =new Font("Batang",Font.ITALIC,12);
		FontSettings fontnewset =new FontSettings(fontnew,true,Color.GREEN,Color.BLACK);
		TextFontOption t=new TextFontOption("Operator","XML generic",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.textViewKey();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testCommentsXML(){
		Font deffont =new Font("Batang",Font.PLAIN,12);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,Color.GRAY);
		Font fontnew =new Font("Arial",Font.ITALIC,14);
		FontSettings fontnewset =new FontSettings(fontnew,false,Color.ORANGE,Color.YELLOW);
		TextFontOption t=new TextFontOption("Comments","XML generic",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.textViewKey();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testCdataXML(){
		Font deffont =new Font("Batang",Font.PLAIN,14);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,Color.BLACK);
		Font fontnew =new Font("Arial",Font.PLAIN,10);
		FontSettings fontnewset =new FontSettings(fontnew,false,Color.ORANGE,Color.YELLOW);
		TextFontOption t=new TextFontOption("CData","XML generic",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.gridViewKey();
		robot.xpathHighlight("/OrgChart/Name");
		robot.XMLInsertCData("See if it has the right color");
		robot.textViewKey();
		robot.keyType(KeyEvent.VK_RIGHT);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testProcInsXML(){
		Font deffont =new Font("Arial",Font.PLAIN,10);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,Color.GREEN);
		Font fontnew =new Font("Courier New",Font.PLAIN,8);
		FontSettings fontnewset =new FontSettings(fontnew,true,Color.CYAN,Color.GRAY);
		TextFontOption t=new TextFontOption("Processing instructions","XML generic",deffontset,fontnewset,Color.YELLOW,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.textViewKey();
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testDoctypeXML(){
		Font deffont =new Font("Courier New",Font.PLAIN,8);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,new Color(0,0,128));
		Font fontnew =new Font("Times New Roman",Font.BOLD,16);
		FontSettings fontnewset =new FontSettings(fontnew,false,Color.YELLOW,Color.BLUE);
		TextFontOption t=new TextFontOption("DOCTYPE","XML generic",deffontset,fontnewset,Color.PINK,true,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(ITEMS_XML_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testASPJSPXML(){
		Font deffont =new Font("Times New Roman",Font.PLAIN,16);
		FontSettings deffontset =new FontSettings(deffont,false,Color.YELLOW,Color.BLACK);
		Font fontnew =new Font("Papyrus",Font.BOLD+Font.ITALIC,10);
		FontSettings fontnewset =new FontSettings(fontnew,true,Color.YELLOW,Color.BLUE);
		TextFontOption t=new TextFontOption("JSP code","XML generic",deffontset,fontnewset,Color.WHITE,true,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.newFile("Active Server Page");
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testKeywordsXQuery(){
		Font deffont =new Font("Arial",Font.PLAIN,10);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,Color.BLUE);
		Font fontnew =new Font("Times New Roman",Font.BOLD,12);
		FontSettings fontnewset =new FontSettings(fontnew,false,Color.YELLOW,Color.BLACK);
		TextFontOption t=new TextFontOption("Keywords","XQuery",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(STRINGQ4_XQ_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testCommentsXQuery(){
		Font deffont =new Font("Times New Roman",Font.PLAIN,12);
		Color lightGREEN=new Color(0,128,0);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,lightGREEN);
		Font fontnew =new Font("Courier New",Font.BOLD+Font.ITALIC,8);
		FontSettings fontnewset =new FontSettings(fontnew,false,Color.PINK,Color.YELLOW);
		TextFontOption t=new TextFontOption("Comments","XQuery",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(STRINGQ4_XQ_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testVariablesXQuery(){
		Font deffont =new Font("Courier New",Font.PLAIN,8);
		Color purple =new Color(160,0,160);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,purple);
		Font fontnew =new Font("Rockwell",Font.BOLD+Font.ITALIC,10);
		FontSettings fontnewset =new FontSettings(fontnew,true,Color.RED,Color.WHITE);
		TextFontOption t=new TextFontOption("Variables","XQuery",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(STRINGQ4_XQ_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testStringsXQuery(){
		Font deffont =new Font("Rockwell",Font.PLAIN,10);
		Color maroon=new Color(204,102,0);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,maroon);
		Font fontnew =new Font("Batang",Font.ITALIC,12);
		FontSettings fontnewset =new FontSettings(fontnew,true,Color.GREEN,Color.BLACK);
		TextFontOption t=new TextFontOption("Strings","XQuery",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(STRINGQ4_XQ_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testContentsXQuery(){
		Font deffont =new Font("Batang",Font.PLAIN,12);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,Color.BLACK);
		Font fontnew =new Font("Arial",Font.ITALIC,14);
		FontSettings fontnewset =new FontSettings(fontnew,false,Color.ORANGE,Color.YELLOW);
		TextFontOption t=new TextFontOption("Contents","XQuery",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(STRINGQ4_XQ_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testOperatorsXQuery(){
		Font deffont =new Font("Arial",Font.PLAIN,10);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,Color.BLACK);
		Font fontnew =new Font("Courier New",Font.PLAIN,8);
		FontSettings fontnewset =new FontSettings(fontnew,true,Color.CYAN,Color.GRAY);
		TextFontOption t=new TextFontOption("Operators","XQuery",deffontset,fontnewset,Color.YELLOW,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(STRINGQ4_XQ_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testFunctionsXQuery(){
		Font deffont =new Font("Courier New",Font.PLAIN,8);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,new Color(102,102,0));
		Font fontnew =new Font("Times New Roman",Font.BOLD,16);
		FontSettings fontnewset =new FontSettings(fontnew,false,Color.YELLOW,Color.BLUE);
		TextFontOption t=new TextFontOption("Functions","XQuery",deffontset,fontnewset,Color.PINK,true,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(STRINGQ4_XQ_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testPragmaXQuery(){
		Font deffont =new Font("Times New Roman",Font.PLAIN,16);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,new Color(0,128,0));
		Font fontnew =new Font("Papyrus",Font.BOLD+Font.ITALIC,10);
		FontSettings fontnewset =new FontSettings(fontnew,true,Color.YELLOW,Color.BLUE);
		TextFontOption t=new TextFontOption("Pragma","XQuery",deffontset,fontnewset,Color.WHITE,true,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(IOUtils.findFile("examples/pragma_xq.xq"));
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testElementCSS(){
		Font deffont =new Font("Arial",Font.PLAIN,10);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,new Color(128,0,0));
		Font fontnew =new Font("Times New Roman",Font.BOLD,12);
		FontSettings fontnewset =new FontSettings(fontnew,false,Color.YELLOW,Color.BLACK);
		TextFontOption t=new TextFontOption("Element","CSS",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(CSS_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testClassCSS(){
		Font deffont =new Font("Times New Roman",Font.PLAIN,12);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,new Color(128,0,0));
		Font fontnew =new Font("Courier New",Font.BOLD+Font.ITALIC,8);
		FontSettings fontnewset =new FontSettings(fontnew,false,Color.PINK,Color.YELLOW);
		TextFontOption t=new TextFontOption("Class","CSS",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(CSS_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testIDCSS(){
		Font deffont =new Font("Courier New",Font.PLAIN,8);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,new Color(128,0,0));
		Font fontnew =new Font("Rockwell",Font.BOLD+Font.ITALIC,10);
		FontSettings fontnewset =new FontSettings(fontnew,true,Color.RED,Color.WHITE);
		TextFontOption t=new TextFontOption("ID","CSS",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(CSS_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testAttributeCSS(){
		Font deffont =new Font("Rockwell",Font.PLAIN,10);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,new Color(128,0,0));
		Font fontnew =new Font("Batang",Font.ITALIC,12);
		FontSettings fontnewset =new FontSettings(fontnew,true,Color.GREEN,Color.BLACK);
		TextFontOption t=new TextFontOption("Attribute","CSS",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(CSS_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testPseudoClassCSS(){
		Font deffont =new Font("Batang",Font.PLAIN,12);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,new Color(128,0,0));
		Font fontnew =new Font("Arial",Font.ITALIC,14);
		FontSettings fontnewset =new FontSettings(fontnew,false,Color.ORANGE,Color.YELLOW);
		TextFontOption t=new TextFontOption("Pseudo Class","CSS",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(CSS_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testUnknownPseudoClassCSS(){
		Font deffont =new Font("Arial",Font.PLAIN,10);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,new Color(128,0,0));
		Font fontnew =new Font("Courier New",Font.PLAIN,8);
		FontSettings fontnewset =new FontSettings(fontnew,true,Color.CYAN,Color.GRAY);
		TextFontOption t=new TextFontOption("Unknown Pseudo Class","CSS",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(CSS_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testOperatorCSS(){
		Font deffont =new Font("Courier New",Font.PLAIN,8);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,Color.BLUE);
		Font fontnew =new Font("Times New Roman",Font.BOLD,16);
		FontSettings fontnewset =new FontSettings(fontnew,false,Color.YELLOW,Color.BLUE);
		TextFontOption t=new TextFontOption("Operator","CSS",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(CSS_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testPropertyCSS(){
		Font deffont =new Font("Times New Roman",Font.PLAIN,16);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,Color.RED);
		Font fontnew =new Font("Papyrus",Font.BOLD+Font.ITALIC,10);
		FontSettings fontnewset =new FontSettings(fontnew,true,Color.YELLOW,Color.BLUE);
		TextFontOption t=new TextFontOption("Property","CSS",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(CSS_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testUnknownPropertyCSS(){
		Font deffont =new Font("Papyrus",Font.PLAIN,10);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,Color.RED);
		Font fontnew =new Font("Times New Roman",Font.BOLD,12);
		FontSettings fontnewset =new FontSettings(fontnew,false,Color.YELLOW,Color.BLACK);
		TextFontOption t=new TextFontOption("Unknown Property","CSS",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(CSS_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}

	@Test
	public void testValueCSS(){
		Font deffont =new Font("Times New Roman",Font.PLAIN,12);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,Color.BLACK);
		Font fontnew =new Font("Courier New",Font.BOLD+Font.ITALIC,8);
		FontSettings fontnewset =new FontSettings(fontnew,false,Color.PINK,Color.YELLOW);
		TextFontOption t=new TextFontOption("Value","CSS",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(CSS_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testCommentCSS(){
		Font deffont =new Font("Courier New",Font.PLAIN,8);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,Color.GRAY);
		Font fontnew =new Font("Rockwell",Font.BOLD+Font.ITALIC,10);
		FontSettings fontnewset =new FontSettings(fontnew,true,Color.RED,Color.WHITE);
		TextFontOption t=new TextFontOption("Comment","CSS",deffontset,fontnewset,null,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(CSS_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testImportantCSS(){
		Font deffont =new Font("Rockwell",Font.PLAIN,10);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,Color.RED);
		Font fontnew =new Font("Batang",Font.ITALIC,8);
		FontSettings fontnewset =new FontSettings(fontnew,true,Color.GREEN,Color.BLACK);
		TextFontOption t=new TextFontOption("Important","CSS",deffontset,fontnewset,Color.YELLOW,false,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(CSS_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testDirectiveCSS(){
		Font deffont =new Font("Batang",Font.PLAIN,8);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,new Color(128,0,0));
		Font fontnew =new Font("Arial",Font.ITALIC,7);
		FontSettings fontnewset =new FontSettings(fontnew,false,Color.ORANGE,Color.YELLOW);
		TextFontOption t=new TextFontOption("Directive","CSS",deffontset,fontnewset,Color.PINK,true,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(CSS_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
	
	@Test
	public void testStringCSS(){
		Font deffont =new Font("Batang",Font.PLAIN,7);
		FontSettings deffontset =new FontSettings(deffont,false,Color.WHITE,Color.BLACK);
		Font fontnew =new Font("Arial",Font.ITALIC,12);
		FontSettings fontnewset =new FontSettings(fontnew,false,Color.ORANGE,Color.YELLOW);
		TextFontOption t=new TextFontOption("String","CSS",deffontset,fontnewset,Color.WHITE,true,"Text fonts",MS_SHELL_DLG_FONT);
		robot.applyOptionsEnter("Options",t);
		robot.openFile(CSS_FILE);
		assertAreas(DIAGRAM_MAIN_WINDOW);
	}
}
