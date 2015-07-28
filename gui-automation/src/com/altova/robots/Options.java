package com.altova.robots;

import java.util.*;

/**
 * A container for {@link Option} elements so multiple Options can be applied at
 * once. Below is an example of how this can be used to set several encoding
 * settings in the StyleVision Properties dialog:
 * <p>
 * <blockquote><pre>
 * Options options = new Options();
 * options.add(new DropDownOption(&quot;HTML:&quot;, encoding));
 * options.add(new DropDownOption(&quot;RTF:&quot;, encoding, &quot;Select Output Encoding for&quot;,&quot;HTML&quot;));
 * options.add(new DropDownOption(&quot;PDF:&quot;, encoding));
 * options.add(new RadioOption(&quot;Compatibility&quot;));
 * options.applyOption(robot);
 * </pre></blockquote>
 * <p>
 * 
 * If you need to set only a single button or drop-down, etc., please refer to
 * the {@link Option}, and related classes.
 * 
 * @see AbstractOption
 * @see CheckboxOption
 * @see ColorOption
 * @see DropDownOption
 * @see RadioOption
 * @see TextFieldOption
 * @see Option
 * 
 * @author Havard Rast Blok
 * 
 */
public class Options extends TreeSet<Option> implements Option {
	/**
	 * Eclipse generated ID.
	 */
	private static final long serialVersionUID = 6088027849351241601L;

	public void applyOption(ApplicationRobot robot) {
		for (Option o : this) {
			o.applyOption(robot);
			robot.delay(500);
		}
	}
}
