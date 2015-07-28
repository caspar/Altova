package com.altova.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.hblok.gui.ColumnLayout;
import net.hblok.gui.FontChooser;
import net.hblok.gui.RowLayout;

import com.altova.nativegui.NativeGUI;
import com.altova.nativegui.TestSpy;
import com.altova.robots.AltovaApplicationRobot;
import com.altova.robots.ImageNotFoundException;
import com.altova.robots.ImageRecognitionRobot;
import com.altova.robots.ImageUtils;


public class RobotsCenter extends ImageRecognitionRobot implements ActionListener, Runnable {

	private JFrame frame;
	
	private JComboBox compareOpton;
	
	private JComboBox robots;
	
	private JTextField resourceId;
	
	private ButtonGroup findType;
	
	private List<RadioButtonPanel> radioPanels = new ArrayList<RadioButtonPanel>();
	
	private JTextField iconFile;
	
	private JButton browse;
	
	private JTextField string;
	
	private JButton chooseFont;
	
	private JButton loadFont;
	
	private JComboBox defaultFonts;
	
	private Font font = ImageRecognitionRobot.WINDOWS_DEFAULT_FONT;
	
	private JLabel fontLabel;
	
	private JButton bgColorButton;
	
	private JButton fgColorButton;
	
	private Color bgColor;
	
	private Color fgColor;
	
	private JLabel colorSample;
	
	private JButton find;
	
	private Object actionSource;
	
	private ImagePanel screenPanel;
	
	private ImagePanel iconPanel;
	
	private ImagePanel resultPanel;
	
	private ImagePanel deubgPanel;
	
	private JTextArea output;
	
	private final String RADIO_STRING = "String";
	
	private final String RADIO_IMAGE = "Image";
	
	private final String RADIO_RESOURCE = "Resource ID";
	
	public RobotsCenter() {
		frame = new JFrame("Robots Debugging Center and Stuff like that...");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		initGui();
		frame.setVisible(true);
		
		Thread t = new Thread(this);
		t.start();
	}
	
	private void initGui() {
		//the tabs
		JTabbedPane tabs = new JTabbedPane();
		tabs.add("Find", findTab());
		tabs.add("Info", new TestSpy());
		
		//image panels
		screenPanel = new ImagePanel(new Dimension(200, 200));
		iconPanel = new ImagePanel(new Dimension(200, 200));
		resultPanel = new ImagePanel(new Dimension(200, 200));
		deubgPanel = new ImagePanel(new Dimension(200, 200));
		screenPanel.cursor = true;
		screenPanel.bg = Color.GRAY;
		iconPanel.bg = Color.WHITE;
		resultPanel.bg = Color.GRAY;
		deubgPanel.bg = Color.BLACK;
		
		JPanel imageRow = new JPanel(new RowLayout());
		imageRow.add(screenPanel);
		imageRow.add(iconPanel);
		imageRow.add(resultPanel);
		imageRow.add(deubgPanel);

		//output area
		output = new JTextArea(20, 80);
		
		//main panel
		JPanel mainBox = new JPanel(new ColumnLayout());
		mainBox.add(tabs);
		mainBox.add(imageRow);
		mainBox.add(output);
		
		frame.add(mainBox);
	}
	
	private JPanel findTab() {
		findType = new ButtonGroup();
		
		//pixel compare type
		compareOpton = new JComboBox(PixelCompare.values());
		compareOpton.setSelectedItem(ImageRecognitionRobot.DEFAULT_PIXEL_COMPARE);
		
		//id search
		robots = new JComboBox(AltovaApplicationRobot.getKnownProducts().toArray());
		resourceId = new JTextField();
		Dimension size = resourceId.getMinimumSize();
		size.width = 200;
		resourceId.setPreferredSize(size);
		JPanel resourceBox = new RadioButtonPanel(RADIO_RESOURCE);
		resourceBox.add(robots);
		resourceBox.add(resourceId);
		resourceBox.setEnabled(false);
		
		//image search
		iconFile = new JTextField();
		iconFile.setPreferredSize(size);
		browse = new JButton("Browse...");
		browse.addActionListener(this);
		JPanel iconBox = new RadioButtonPanel(RADIO_IMAGE);
		iconBox.add(iconFile);
		iconBox.add(browse);
		iconBox.setEnabled(false);

		//string search
		
		//font row
		chooseFont = new JButton("Font...");
		loadFont = new JButton("Font file...");
		defaultFonts = new JComboBox();
		defaultFonts.addActionListener(this);
		defaultFonts.addItem(ImageRecognitionRobot.WINDOWS_DEFAULT_FONT);
		defaultFonts.addItem(ImageRecognitionRobot.DEFAULT_CONTENT_FONT);
		defaultFonts.addItem(ImageRecognitionRobot.MS_SHELL_DLG_FONT);
		fontLabel = new JLabel("Default Windows font: "+font);
		chooseFont.addActionListener(this);
		loadFont.addActionListener(this);
		JPanel fontCol = new RadioButtonPanel(RADIO_STRING);
		fontCol.setLayout(new ColumnLayout());
		JPanel fontRow = new JPanel(new RowLayout());
		string = new JTextField();
		string.setPreferredSize(size);
		fontRow.add(string);
		fontRow.add(chooseFont);
		fontRow.add(loadFont);
		fontRow.add(defaultFonts);
		
		//color row
		bgColor = ImageRecognitionRobot.TRANSPARENT;
		fgColor = Color.BLACK;
		bgColorButton = new JButton("Background color");
		fgColorButton = new JButton("Text color");
		bgColorButton.addActionListener(this);
		fgColorButton.addActionListener(this);
		colorSample = new JLabel("Sample");
		JPanel colorRow = new JPanel(new RowLayout());
		colorRow.add(bgColorButton);
		colorRow.add(fgColorButton);
		colorRow.add(colorSample);
		
		fontCol.add(fontRow);
		fontCol.add(colorRow);
		fontCol.add(fontLabel);
		
		JPanel findBox = new JPanel(new ColumnLayout());
		findBox.add(iconBox);
		findBox.add(fontCol);
		
		find = new JButton("Find");
		find.addActionListener(this);
		findBox.add(find);
		
		JPanel tab = new JPanel(new ColumnLayout());
		tab.add(compareOpton);
		tab.add(resourceBox);
		tab.add(findBox);

		return tab;
	}
	
	public void log(String str) {
		output.setText( output.getText() + "\n" + str);
	}

	public void actionPerformed(ActionEvent e) {
		actionSource = e.getSource();
	}

	public void run() {
		while (true) {

			if (actionSource != null) {
				doAction(actionSource);
				actionSource = null;
			}

			Point p = NativeGUI.getCursorPostion();
			Rectangle cursor = new Rectangle(p.x-25, p.y-25, 50, 50);
			BufferedImage screen = createScreenCapture(cursor);
			screenPanel.setImage(screen);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {} // ignore
		}

	}

	private void doAction(Object actionSource) {
		output.setText("");
		
		if (actionSource == browse) {
			JFileChooser chooser = new JFileChooser();
			if( chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION ) {
				File file = chooser.getSelectedFile();
				log("File: "+file);
				iconFile.setText(file.getAbsolutePath());
			}
			
		} else if (actionSource == chooseFont) {
			FontChooser chooser = new FontChooser(frame);
			font = chooser.showDialog();
		} else if (actionSource == loadFont) {
			font = loadFont();
		} else if (actionSource == defaultFonts) {
			font = (Font) defaultFonts.getSelectedItem();
		} else if (actionSource == bgColorButton) {
			bgColor = colorChooser("background", bgColor);
		} else if (actionSource == fgColorButton) {
			fgColor = colorChooser("text", fgColor);
		} else if (actionSource == find) {
			tryFind();
		}
		
		if (font != null) {
			fontLabel.setText(font.toString());
			colorSample.setForeground(fgColor);
			colorSample.setBackground(bgColor);
		}
	}

	private Font loadFont() {
		Font ans = font;
		
		File fontDir = new File(System.getenv("SystemRoot"), "Fonts");
		JFileChooser file = new JFileChooser(fontDir);
		if( file.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION ) {
			File fontFile = file.getSelectedFile();
			try {
				Font loaded = Font.createFont(Font.TRUETYPE_FONT, fontFile);
				int size = (font!=null)?font.getSize():12;
				ans = loaded.deriveFont(size);
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ans;
	}
	
	private Color colorChooser(String type, Color color) {
		return JColorChooser.showDialog(frame, "Select "+type+" color", color);
	}
	
	private void tryFind() {
		try {
			super.compareState = (PixelCompare) compareOpton.getSelectedItem();
			super.debugSuccess = true;
			iconPanel.setImageFile(null);
			
			String radioCommand = findType.getSelection().getActionCommand();
			log("radioCommand="+radioCommand);
			Rectangle r = null;
			if(radioCommand.equals(RADIO_RESOURCE)) {
				String robotName = (String) robots.getSelectedItem();
				AltovaApplicationRobot robot = AltovaApplicationRobot.getProductRobot(robotName);
				robot.compareState = (PixelCompare) compareOpton.getSelectedItem();
				robot.debugSuccess = true;
				r = robot.findIcon(resourceId.getText());
				debugImages = robot.debugImages;
			} else if(radioCommand.equals(RADIO_STRING)) {
				r = findString(string.getText(), font, bgColor, fgColor);
			} else if(radioCommand.equals(RADIO_IMAGE)) {
				r = findImage(iconFile.getText());
			}
			
			log("Result: "+r);
			Rectangle r2 = new Rectangle(r.x-5, r.y-5, r.width+10, r.height+10);
			BufferedImage img = createScreenCapture(r2);
			resultPanel.setImage( img );
		} catch(ImageNotFoundException e) {
			log("Image was not found on screen. \n"+e);
			resultPanel.setImageFile( e.getDebug() );
			e.printStackTrace();
		} catch (Exception e) {
			log(e.getMessage());
			e.printStackTrace();
		}
		
		if(debugImages != null) {
			iconPanel.setImageFile(debugImages[1]);
			deubgPanel.setImageFile(debugImages[2]);

			log("Files:");
			for(File f : debugImages) {
				log(""+f);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new RobotsCenter();

	}

	class RadioButtonPanel extends JPanel implements ActionListener {
		private static final long serialVersionUID = -4371602686857705005L;
		
		private JPanel internalPanel;
		
		RadioButtonPanel(String text) {
			radioPanels.add(this);
			
			internalPanel = new JPanel();
			internalPanel.setLayout(new RowLayout());
			
			this.setLayout(new ColumnLayout());
			JRadioButton button = new JRadioButton(text);
			button.addActionListener(this);
			button.setActionCommand(text);
			findType.add(button);
			button.setSelected(true);
			
			super.add(button);
			super.add(internalPanel);
		}

		public void actionPerformed(ActionEvent arg0) {
			//disable the others
			for(RadioButtonPanel p : radioPanels) {
				if(p != this) {
					p.setEnabled(false);
				}
			}
			
			setEnabled(true);
		}

		public void setEnabled(boolean enabled) {
			super.setEnabled(enabled);
			setEnabled(enabled, internalPanel);
		}
		
		private void setEnabled(boolean enabled, Component... cmps){
			for(Component c : cmps) {
				c.setEnabled(enabled);
				if(c instanceof JPanel) {
					Component subs[] = ((JPanel)c).getComponents();
					setEnabled(enabled, subs);
				}
			}
			
		}

		public Component add(Component comp, int index) {
			return internalPanel.add(comp, index);
		}

		public void add(Component comp, Object constraints, int index) {
			internalPanel.add(comp, constraints, index);
		}

		public void add(Component comp, Object constraints) {
			internalPanel.add(comp, constraints);
		}

		public Component add(Component comp) {
			return internalPanel.add(comp);
		}

		public Component add(String name, Component comp) {
			return internalPanel.add(name, comp);
		}

		@Override
		public void setLayout(LayoutManager mgr) {
			super.setLayout(mgr);
			if(internalPanel != null) {
				internalPanel.setLayout(mgr);
			}
		}
		
	}
	

	class ImagePanel extends JPanel {
		private static final long serialVersionUID = -1810044987822776855L;

		Dimension dim;
		
		Image img;
		
		Color bg;
		
		boolean cursor;
		
		float scaleFactor = 4.0f;
		
		BufferedImageOp scale = new RescaleOp(scaleFactor, 0, null);
		
		BufferedImageOp test = new AffineTransformOp(new AffineTransform(1f,0f,0f,1f,0,0), null);
		
		public ImagePanel(Dimension dim) {
			this.dim = dim;
		}
		
		@Override
		public Dimension getPreferredSize() {
			return dim;
		}
		
		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D)g;
			
			g2.setBackground(bg);
			g2.clearRect(0, 0, dim.width, dim.height);
			
			if(img != null) {
				g2.drawImage(img, 0, 0, this);
				
				if(cursor) {
					int x = dim.width / 2;
					int y = dim.height / 2;
					g.setColor(Color.RED);
					g2.drawRect(x - 1, y - 1, (int)(scaleFactor) + 1, (int)(scaleFactor) + 1);
				}
			}
		}
		
		public void setImageFile(File file) {
			if(file != null) {
				setImage( ImageUtils.readIcon(file.getAbsolutePath()) );
				
			} else {
				this.img = null;
				repaint();
			}
		}

		public void setImage(BufferedImage img) {
			this.img = img.getScaledInstance(img.getWidth()*4, img.getHeight()*4, 0);
			repaint();
		}

		
	}

}
