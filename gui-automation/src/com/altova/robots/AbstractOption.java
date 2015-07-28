package com.altova.robots;

import static com.altova.util.LoggerUtils.logger;
import static com.altova.robots.ImageRecognitionRobot.*;

import static java.awt.Color.BLACK;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import com.altova.nativegui.ComponentInfo;
import com.altova.nativegui.NativeGUI;

/**
 * Abstract properties option which contains common concepts for the various GUI
 * elements. In particular, this class contains names uniquely identifying the
 * option, including which tab, page, section, and subsection it is located on,
 * as well as the name or description text field for the option itself.
 * Furthermore, this class includes basic methods to find the screen coordinates
 * of this option.
 * 
 * @author Havard Rast Blok
 * 
 */
public abstract class AbstractOption implements Option, Comparable<AbstractOption> {
	/**
	 * The "page" in sequence of back/next "pages" where the option can be found.
	 * The string should contain the unique name of the page as shown in the dialog title.
	 * If the dialog does not get a unique title for a particular "next" sequence, 
	 * you have a problem. 
	 * <p>
	 * Example: UModel: "Import Source Directory" -> "Content Diagram Generation" -> usw. 
	 */
	protected String page;

	/**
	 * The tab where the option can be found. The string is the name of the tab as seen in the GUI.
	 */
	protected String tab;

	/**
	 * The section (usually, but not always) within a tab where the option can be found.
	 * The string contains the name of the section as seen in the GUI.
	 * <p>
	 * Example: UModel: "Import Source Directory". Section: "Java Project Settings"
	 */
	protected String section;

	/**
	 * The sub section where the option can be found. Is is only used in some cases.
	 * <p> 
	 * Example: Spy: Tools -> Options. Tab: "File". Section: "Save File". Sub section: "Line breaks"
	 */
	protected String subSection;

	/**
	 * The name of the option. This will vary slightly between different types
	 * of options. Please refer to the concrete sub classes of this class for
	 * the specifics.
	 * 
	 * @see CheckboxOption
	 * @see ColorOption
	 * @see DropDownOption
	 * @see RadioOption
	 * @see TextFieldOption
	 * 
	 */
	protected String name;
	
	/*
	 * Used internally.
	 */
	protected Rectangle optionBoundary;
	
	/**
	 * Indicates whether the option name/text itself is in bold. An example of
	 * this is the XMLSpy Convert menu dialogs, e.g. "Import Text File", where
	 * both options are in bold.
	 * 
	 * (This is of course a way to work around GUI design flaws in the
	 * applications under test. This might or might not be a good idea.)
	 */
	protected boolean boldOption = false;

	/**
	 * Constructs an Option with the specified name.
	 * 
	 * @param name
	 *            name of option
	 * @see AbstractOption#name
	 */
	protected AbstractOption(String name) {
		this(name, null);
	}

	/**
	 * Constructs an Option with the specified name, which is located within the
	 * specified section.
	 * 
	 * @param name
	 *            name of option
	 * @param section
	 *            name of section
	 * @see AbstractOption#name
	 * @see AbstractOption#section
	 */
	protected AbstractOption(String name, String section) {
		this(name, section, null, null, null);
	}

	/**
	 * Constructs an Option with the specified name, which is located within the
	 * specified section and sub section.
	 * 
	 * @param name
	 *            name of option
	 * @param section
	 *            name of section
	 * @param subSection
	 *            name of sub section within the section
	 * @see AbstractOption#name
	 * @see AbstractOption#section
	 * @see AbstractOption#subSection
	 */
	protected AbstractOption(String name, String section, String subSection) {
		this(name, section, subSection, null, null);
	}
	
	/**
	 * Constructs an Option with the specified name, which is located within the
	 * specified section and sub section.
	 * 
	 * @param name
	 *            name of option
	 * @param section
	 *            name of section
	 * @param subSection
	 *            name of sub section within the section
	 * @see AbstractOption#name
	 * @see AbstractOption#section
	 * @see AbstractOption#subSection
	 */
	protected AbstractOption(String name, String section, String subSection, String page, String tab) {
		// we'll allow name to be null, since cases like the ColorOption can have the color button
		// inside a section, without any specific name
		//if(name == null) {
		//	throw new NullPointerException("Name of option cannot be null");
		//}
		
		this.page = page;
		this.tab = tab;
		this.section = section;
		this.subSection = subSection;
		this.name = name;
	}
	
	/**
	 * Searches the foreground window/dialog for the specified string, within the specified hint area. 
	 * 
	 * @param string the string on screen to locate
	 * @param hint the area to constrain the search within. If null, the top window is the boundary.
	 * @param robot the Robot object for the application under test
	 * @return the boundaries of the string as seen in the GUI, in screen coordinates.
	 */
	protected Rectangle searchForgroundWinow(String string, Rectangle hint, ApplicationRobot robot,Font fontname) {
		Rectangle tmpHint = (hint==null)?NativeGUI.getForegroundWindowInfo().getLocation():hint;
		
		if(string == null) {
			return tmpHint;
		}
		
		try {
			robot.compareState = ImageRecognitionRobot.PixelCompare.BLACK_WHITE;		
			Font font = fontname;
			
			if(boldOption) {
				//this is a special case for the option dialogs under the Convert menu in XMLSpy
				font = fontname.deriveFont(Font.BOLD);
			}
			
			return robot.findString(string, font, Color.WHITE, BLACK, tmpHint, false);
			
		}
		finally {
			robot.compareState = ImageRecognitionRobot.DEFAULT_PIXEL_COMPARE;
		}
	}

	/**
	 * Finds and returns the location of the section or sub section. If the
	 * string parameter is null, the location of the top window/dialog is
	 * returned. If hint parameter is null, the top window/dialog is used as the
	 * boundary of the search.
	 * 
	 * @param string
	 *            name of the section
	 * @param hint
	 *            constraint to search within
	 * @param robot
	 *            the Robot object for the application under test
	 * @return the boundaries of the section as seen in the GUI, in screen
	 *         coordinates.
	 */
	protected Rectangle findSection(String string, Rectangle hint, ApplicationRobot robot,Font fontname) {
		robot.delay(5000);
		Rectangle area = searchForgroundWinow(string, hint, robot,fontname);
		
		
		if(string == null) {
			return area;
		}
		
		//see if the component name at this location matches the string we're after
		ComponentInfo ci = NativeGUI.getWindowInfo(area.x, area.y);
		if(ci != null && ci.getWindowText().toLowerCase().indexOf(string.toLowerCase()) > -1) {
			
			return ci.getLocation();
		}
		
		
		
		//section to consider (wrong assumption made ) 
		hint = (hint==null)?area:hint;
		
		
		//if not, return the section which is below the string we found
		Rectangle section = new Rectangle(area.x, area.y+area.height, 
							hint.x+hint.width-area.x, hint.y+hint.height-area.y);
		
		
		
		return section;
	}

	/**
	 * TODO: not implemented yet
	 * @param robot
	 */
	protected void activatePage(ApplicationRobot robot) {
		if(page == null) {
			logger.finest("Found tab "+page);
			return;
		}
		
		throw new ScriptMistakeException("not implemented yet"); 
	}

	/**
	 * Clicks the tab with the {@link AbstractOption#tab} string in this Option.
	 * @param robot the Robot object for the application under test 
	 */
	protected void activateTab(ApplicationRobot robot,Font fontname) {
		if(tab == null) {
			return;
		}
		
		Rectangle tabIcon = searchForgroundWinow(tab, null, robot,fontname);
		logger.finest("Found tab "+tab+" at "+tabIcon);
		robot.leftClickMid(tabIcon); robot.delay(500);
	}

	/**
	 * Finds and returns the location of name string in screen coordinates. This
	 * will go through the following steps:
	 * <p>
	 * <ol>
	 * <li>Activate the page where the option is located.</li>
	 * <li>Activate the tab where the option is located.</li>
	 * <li>Find the location of the section.</li>
	 * <li>Find the location of the sub section (within the section).</li>
	 * <li>Find the location of the option (within the sub section).</li>
	 * </ol>
	 * <p>
	 * If any of the sections, page, tab, etc. is not specified in this Option,
	 * the starting point will be the active window or dialog, or the previous
	 * constraining location. E.g. If only tab and section is specified, the
	 * section will first be located within the tab, and then the name of the
	 * option is located within the section.
	 * 
	 * @param robot the Robot object for the application under test 
	 * @return the boundaries of the option name as seen in the GUI, in screen coordinates. 
	 */
	protected Rectangle findOptionName(ApplicationRobot robot,Font fontname) {
		
		return findOptionName(robot, fontname, fontname);
	}
	/*
	 * This method is was implemented after:
	 * 	protected Rectangle findOptionName(ApplicationRobot robot,Font fontname)
	 * that was the original ones because some GUI object, use "sectionIcon" with a font that is different
	 * than the "nameIcon" font
	 */
	protected Rectangle findOptionName(ApplicationRobot robot,Font fontname, Font fontname2) {

		activatePage(robot);
		activateTab(robot,fontname);
		
		Rectangle sectionIcon = findSection(section, null, robot,fontname);
		logger.finest("Found section '"+section+"' at "+sectionIcon);
		Rectangle subSectionIcon = findSection(subSection, sectionIcon, robot,fontname);
		optionBoundary = subSectionIcon;
		//logger.finest("Found sub section '"+subSection+"' at "+subSectionIcon);
		Rectangle nameIcon = searchForgroundWinow(name, subSectionIcon, robot, fontname2);
		logger.finest("Found option name '"+name+"' at "+nameIcon);
		
		return nameIcon;
	}

	/**
	 * Compare this Option to another to determine sorting order. (The main
	 * intention behind this is to set options which are located on the same
	 * page or tab right after each other, to avoid unnecessary switching between
	 * tabs.)
	 */
	public int compareTo(AbstractOption o) {
		if(o == null) {
			throw new NullPointerException("Compare object cannot be null");
		}
		
		if(this.equals(o)) {
			return 0;
		}
		
		StringBuffer thisBuf = new StringBuffer();
		StringBuffer otherBuf = new StringBuffer();
		
		if(page != null && o.page != null) {
			thisBuf.append(page);
			otherBuf.append(o.page);
		}
		
		if(tab != null && o.tab != null ) {
			thisBuf.append(tab);
			otherBuf.append(o.tab);			
		}
		
		if(section != null && o.section != null ) {
			thisBuf.append(section);
			otherBuf.append(o.section);			
		}
		
		if(subSection != null && o.subSection != null ) {
			thisBuf.append(subSection);
			otherBuf.append(o.subSection);			
		}
		
		thisBuf.append(name);
		otherBuf.append(o.name);

		thisBuf.append(this.hashCode());
		otherBuf.append(o.hashCode());
		
		return thisBuf.toString().compareTo(otherBuf.toString());
	}


	/**
	 * Returns the name of this Option.
	 * @see AbstractOption#name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of this Option.
	 * @see AbstractOption#name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the name of the "page"
	 * @see AbstractOption#page
	 */
	public String getPage() {
		return page;
	}

	/**
	 * Sets the name of the "page"
	 * @see AbstractOption#page
	 */
	public void setPage(String page) {
		this.page = page;
	}

	/**
	 * Returns the name of the section
	 * @see AbstractOption#section
	 */
	public String getSection() {
		return section;
	}

	/**
	 * Sets the name of the section
	 * @see AbstractOption#section
	 */
	public void setSection(String section) {
		this.section = section;
	}

	/**
	 * Returns the name of the sub section
	 * @see AbstractOption#subSection
	 */
	public String getSubSection() {
		return subSection;
	}

	/**
	 * Sets the name of the sub section
	 * @see AbstractOption#subSection
	 */
	public void setSubSection(String subSection) {
		this.subSection = subSection;
	}

	/**
	 * Returns the name of the tab
	 * @see AbstractOption#tab
	 */
	public String getTab() {
		return tab;
	}

	/**
	 * Sets the name of the tab
	 * @see AbstractOption#tab
	 */
	public void setTab(String tab) {
		this.tab = tab;
	}

	/*
	 * Auto generated by Eclipse
	 */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
		result = PRIME * result + ((page == null) ? 0 : page.hashCode());
		result = PRIME * result + ((section == null) ? 0 : section.hashCode());
		result = PRIME * result + ((subSection == null) ? 0 : subSection.hashCode());
		result = PRIME * result + ((tab == null) ? 0 : tab.hashCode());
		return result;
	}

	/*
	 * Auto generated by Eclipse
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final AbstractOption other = (AbstractOption) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		if (subSection == null) {
			if (other.subSection != null)
				return false;
		} else if (!subSection.equals(other.subSection))
			return false;
		if (tab == null) {
			if (other.tab != null)
				return false;
		} else if (!tab.equals(other.tab))
			return false;
		return true;
	}
	
	
}
