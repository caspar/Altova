package com.altova.robots;

/**
 * An option which can be applied to an options dialog using the specified
 * robot. Note that before the {@link #applyOption(ApplicationRobot)} method is
 * called, the dialog which contains the fields, check boxes, etc. must be
 * visible on the screen.
 * <p>
 * This can, and should, be used for any dialog which contains standard Windows
 * check boxes, radio buttons, text fields, drop downs or even the Altova
 * specific colour buttons. Using the classes implementing this interface
 * guarantees a consistent way to handle options dialogs and saves duplicate
 * implementations across the robot framework.
 * <p>
 * The following is an example of how the {@link RadioOption} can be used to set
 * the language code is XSD generated in XMLSpy. Notice that although the full
 * text on the radio button is not always required, it is generally advised for
 * the sake of clarity and to avoid any ambiguity.
 * <p>
 * <blockquote>
 * 
 * <pre>
 * RadioOption format = new RadioOption(&quot;C++ (based &quot;);
 * robot.generateCode(format, &quot;c:\\output&quot;);
 * </pre>
 * 
 * </blockquote>
 * <p>
 * If need to set more than one option, please use the {@link Options}
 * container, and refer to the detailed documentation there.
 * 
 * @see AbstractOption
 * @see CheckboxOption
 * @see ColorOption
 * @see DropDownOption
 * @see RadioOption
 * @see TextFieldOption
 * @see Options
 * 
 * @author Havard Rast Blok
 * 
 */
public interface Option {
	/**
	 * Applies this option to the options dialog already shown on screen.
	 * 
	 * @param robot
	 *            an application specific robot instance used for the automation
	 *            (usually, this method will be called from within a robot
	 *            class, and {@code this} can be passed in.) 
	 * 
	 */
	void applyOption(ApplicationRobot robot);
}
