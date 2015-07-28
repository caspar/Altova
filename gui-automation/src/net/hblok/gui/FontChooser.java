/*
    Blok Utils - Various utility classes in the hblok.net domain.  
    Copyright (C) 2005  Havard Rast Blok
    http://hblok.sourceforge.net
    
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.
    
    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.
    
    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

package net.hblok.gui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This class implements a GUI for a font chooser. This includes the familiar
 * controls seen in most office applications, where the user can select
 * font name, type, size and other attributes.
 * 
 * This class was made by Svein Ivar Kristiansen.
 * Thanks a lot!
 * 
 * @author Svein Ivar Kristiansen
 * @author Havard Rast Blok
 */
public class FontChooser extends JDialog implements ActionListener {

  private static final long serialVersionUID = -5731028184250696825L;

  Container c;
  static Font selectedFont;
  String selectedfontname;
  int selectedfontstyle;
  int fontstyleindex;
  int selectedfontsize = 12;
  
  GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
  String envfonts[] = gEnv.getAvailableFontFamilyNames();
  Integer sizes[] = { 5,6,7,8,9,10,11,12,13,14,15,16,17,18,20,22,24,26,28,30,34,38,46,54,72 };
  int fontSize;
  String styles[] = {"Regular", "Italic", "Bold", "Bold Italic" };
  int javaformattedstyles[] = { Font.PLAIN, Font.ITALIC, Font.BOLD, Font.BOLD + Font.ITALIC } ;
    
  JLabel lfont = new JLabel("Font: ");
  JLabel lfontstyle = new JLabel("Font Style: ");
  JLabel lsize = new JLabel("Size: ");
  JLabel preview = new JLabel("Font preview: ");

  JTextField tfont = new JTextField(20);
  JTextField tfontstyle = new JTextField(20);
  JTextField tsize = new JTextField(20);

  
  JList listfont = new JList(envfonts);
  JList listfontstyle = new JList(styles);
  JList listsize = new JList(sizes);
  
  JButton bok = new JButton("Ok");
  JButton bcancel = new JButton("Cancel");
  
  int hsb = JScrollPane.HORIZONTAL_SCROLLBAR_NEVER;
  int vsb = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED;

  JScrollPane scrollFont = new JScrollPane(listfont, vsb, hsb);
  JScrollPane scrollSize = new JScrollPane(listsize);
  
  DrawFont tegne = new DrawFont();

  public FontChooser( Frame parent )
  {
    this( parent, "Font" );
  }
  
  public FontChooser( Frame parent, String title ) {
          super( parent, title, true );
          setSize( 430, 400);
          
          setupGui();
        }

  public Font showDialog()
  {
    //System.out.println("FontChooser.showDialog - start");
    setVisible(true);
    //System.out.println("FontChooser.showDialog - after show");
    return selectedFont;
  }
  
  public void setupGui() {
    c = getContentPane();
    c.setLayout(null);
    
    lfont.setBounds(20,20,100,20);
    lfontstyle.setBounds(150,20,100,20);
    lsize.setBounds(250,20,50,20);
        
    tfont.setBounds(20,40,120,20);
    tfontstyle.setBounds(150,40,80,20);
    tsize.setBounds(250,40,50,20);
    
    TextHandler th = new TextHandler();
    tfont.addActionListener(th);
    tfontstyle.addActionListener(th);
    tsize.addActionListener(th);
    tfont.addKeyListener(th);
    tfontstyle.addKeyListener(th);
    tsize.addKeyListener(th);

    
    bok.setBounds(320,40,80,20);
    bcancel.setBounds(320,70,80,20);
    
    scrollFont.setBounds(20,65, 120, 150);
    listfontstyle.setBounds(150, 65, 80, 150);
    scrollSize.setBounds(250, 65,50,150);
    
    listfont.addListSelectionListener(new ListHandler() );
    listfontstyle.addListSelectionListener(new ListHandler() );
    listsize.addListSelectionListener(new ListHandler() );
    
    
    tegne.setBounds(20, 270, 300, 75);
    preview.setBounds(20, 245, 80, 10);
    
    c.add(bok); //ok-knapp
    c.add(bcancel); //cancel-knapp
    c.add(lfont);
    c.add(lfontstyle);
    c.add(lsize);
    c.add(tfont);
    c.add(tfontstyle);
    c.add(tsize);
  
    c.add(scrollFont);//listeboks med scroller
    c.add(scrollSize);//listeboks med scroller
    c.add(listfontstyle);//listeboks uten scroller
    c.add(tegne);
    c.add(preview);
    
    bok.addActionListener( this );
    bcancel.addActionListener( this );
  }
  
  
  public void updateFont() {
    selectedFont = new Font(selectedfontname, selectedfontstyle, selectedfontsize); 
    tegne.repaint();
  }

  public void actionPerformed( ActionEvent e )
  {
    String cmd;
    
    cmd = e.getActionCommand();
    
    System.out.println("FontChooser.actionPerformed - cmd:"+cmd);
    
    if (cmd.compareToIgnoreCase("OK") == 0) {
    	setVisible(false);
	} else if (cmd.compareToIgnoreCase("Cancel") == 0) {
		selectedFont = null;
		setVisible(false);
	}

  }
  
  class TextHandler extends KeyAdapter implements ActionListener {
    public void actionPerformed(ActionEvent e) {
    	changeList(e.getSource());
    }
    
    @Override
	public void keyReleased(KeyEvent e) {
		changeList(e.getSource());
	}

	private void changeList(Object src) {
      String text;
    if(src == tfont) {
      text = tfont.getText();
      
      for(int i = 0; i < envfonts.length; i++) {
        if(text.equalsIgnoreCase(envfonts[i]) ) {
        	listfont.setSelectedIndex(i);      //sett listeIndex i valgt...
        }
      }
    } else if(src == tfontstyle) {
      text = tfontstyle.getText();
      
      for (int i = 0; i < styles.length; i++) {
        if(text.equalsIgnoreCase(styles[i]) ) {
        	listfontstyle.setSelectedIndex(i);	//setter valg style...
        }
      }
    } else if(src == tsize) {
    	try {
			fontSize = Integer.parseInt(tsize.getText());
		
			for (int i = 0; i < sizes.length; i++) {
				if (fontSize == sizes[i]) {
					listsize.setSelectedIndex(i);
				}
			}
		} catch (NumberFormatException e) {} // do nothing
        
        // hvis inntastet tall finnes i lista, settes denne selected
		// automatisk...
      }
      selectedfontsize = fontSize;
      updateFont();		
    }
  
  }
  
  class ListHandler implements ListSelectionListener {
    public void valueChanged(ListSelectionEvent e) {
      if(e.getSource() == listfont) {
        selectedfontname = (String)(listfont.getSelectedValue());		
        tfont.setText( (String)(listfont.getSelectedValue() ) );
        if (fontstyleindex < 0)fontstyleindex = 0; 
      } else
      if (e.getSource() == listsize) {
    	  Integer value = (Integer)listsize.getSelectedValue();
    	  selectedfontsize = value;
    	  tsize.setText( value.toString() );
    	  selectedfontsize = (selectedfontsize < 0)?0:selectedfontsize; //dersom ingen size valgt
      }else
      if (e.getSource() == listfontstyle) {
        fontstyleindex = (int)(listfontstyle.getSelectedIndex());
        //dersom ingenting valgt
      
        tfontstyle.setText( (String)(listfontstyle.getSelectedValue() ) );
        selectedfontstyle = (int)javaformattedstyles[fontstyleindex ];
        //selectedfontsize =  (int)(Integer.parseInt(listsize.getSelectedValue() 	
      }
      
          
      updateFont();
    }			
  }
  
  class DrawFont extends JPanel {
	private static final long serialVersionUID = 8507213328250855731L;
	
	Font currentFont;
    int ymax;
    
    
    public void paintComponent( Graphics g ) {
      setBackground( Color.white );
      setForeground( Color.black );
            
      super.paintComponent( g ); //arves fra JPanel 
      
      ymax = getHeight();
      
      currentFont = FontChooser.selectedFont;
      g.setFont(currentFont);
      
      g.drawRect(0,0, getWidth(), getHeight() );
      g.drawString( "Testing font" , 10, ymax-10);//tegner teksten...
    }
  }

}
