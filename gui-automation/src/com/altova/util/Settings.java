package com.altova.util;

import static com.altova.util.LoggerUtils.logger;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import com.altova.robots.ScriptMistakeException;

/**
 * Central collection of methods for retrieving options and settings, like
 * environment variables (e.g. set DELAY=3), VM command line arguments (e.g.
 * -Dout=c:\temp), properties file values (e.g. DIFFDOG_DIR=DiffDog2223), or in
 * the last resort, a default value. The options currently available include
 * output, debug and expected directories for tests, various debugging
 * parameters, and application installation directories.
 * <p>
 * The default installation locations for the Altova applications are all
 * gathered in {@link AltovaApplication}.
 * <p>
 * Typical settings: -Dout=c:\temp\out -Dexpected=c:\temp\expected
 * -Ddebug=c:\temp\debug -Djava.util.logging.config.file=robotsLog.properties
 * <p>
 * For details about setting and using the options and Settings class, please
 * see TODO
 * <p>
 * TODO: For various reasons, some of the options included to keys for the same
 * value. Feel free to redesign this, since it is slightly redundant. This
 * should be a few of the methods in this class simpler, and some completely
 * unused.
 * 
 * @author Havard Rast Blok
 * 
 */
public class Settings {

	/**
	 * Prefix which can be added to environment variables: ROBOTS_ (although, it
	 * works without as well)
	 */
	private static final String ROBOTS_PREFIX = "ROBOTS_";

	/**
	 * Variable for output directory for teset sts. Mostly used for outputting
	 * pictures.
	 */
	private static final String[] OUT = { "OUT_DIR", "out" };

	/**
	 * Variable for debug directory. Typically, hundreds of pictures will end up
	 * here during a test.
	 */
	private static final String[] DEBUG = { "DEBUG_DIR", "debug" };

	/**
	 * Variable for directory which contains expected images for the tests.
	 * These images are then compared to the once in the output directory.
	 */
	private static final String[] EXPECTED = { "EXPECTED_DIR", "expected" };

	/**
	 * Multiplier used to extend the delay times throughout the test and robot
	 * classes. Default is 1. On virtual machines, you might use 2 or 3.
	 */
	private static final String[] DELAY_MULTIPLY = { "delayMultiply", "DELAY" };

	/**
	 * Variable for skipping the JUnit image assert. The pictures are still
	 * created in the output directory, but not compared against anything in the
	 * expected. Setting this to 'true' is a good way to generate the test
	 * pictures.
	 */
	private static final String JUNIT_DRYRUN = "JUnitDryRun";

	/**
	 * Variable for running VS2010.It is needed so that, for example, the application font is
	 * distinguished by the robot
	 */
	private static final String VS2010 = "VS2010";

	/**
	 * Variable for running 64bit applications.It is needed so that the robot understands that
	 *  a 64bit application is being run 
	 */
	private static final String X64 = "X64";
	
	/**
	 * Variable for turning on or off debug images of all sorts. Default is on.
	 */
	private static final String DEBUG_IMAGES = "debugImages";

	/**
	 * Variable for turning on or off debug images when doing an ImageDiff
	 * operation. Default is off.
	 */
	private static final String DEBUG_IMAGE_DIFF = "debugImageDiff";

	/**
	 * Variable for setting the file which contains values for the settings in
	 * this Settings class.
	 */
	public static final String[] AUTOMATION_CONFIG_FILE = { "automation.config.file" };

	private static final Map<String, String[]> explanations = new TreeMap<String, String[]>();

	private static Properties propsFromFile = null;

	private static File propertyFile = null;
	private static String previousMsg = null;

	private static String DIR = "_DIR";

	/**
	 * Variable for setting the Altova installation directory. Default is
	 * 'Altova'. The rest of the path is dynamically put together.
	 */
	private static String ALTOVA_DIR = "ALTOVA" + DIR;

	/**
	 * General interface for obtaining information about a predefined
	 * application.
	 * 
	 * @see Application
	 * @see AltovaApplication
	 */
	public static interface ApplicationSettings {
		/**
		 * 
		 * @return the default EXE file name, e.g. eclipse.exe or umodel.exe.
		 */
		public String getDefaultExe();

		/**
		 * 
		 * @return the default (or set by custom settings variables) location of
		 *         the application. E.g. "C:\Program
		 *         Files\Altova_2006test\DiffDog2015"
		 */
		public File getInstallLocation();
	}

	/**
	 * Enumeration which contains location of predefined applications like
	 * Eclipse and Visual Studio. These locations can be overridden by setting
	 * corresponding *_DIR variable. E.g. to set a different Eclipse
	 * installation folder, set the variable ECLIPSE_DIR to the full path where
	 * eclipse.exe can be found: ECLIPSE_DIR=d:\programs\eclipse The default
	 * locations are under the C:\Program Files (or equivalent localized
	 * folder). The variables can be set as an environment variable, VM setting
	 * or property file setting.
	 */
	public static enum Application implements ApplicationSettings {
		// ECLIPSE("Eclipse SDK", createProgramFilesPath("eclipse"),
		// "eclipse.exe"),
		ECLIPSE("Eclipse SDK", createProgramFilesPath("eclipse_4.3\\eclipse"),
				"eclipse.exe -nl en"),
		// ECLIPSE("Eclipse SDK",
		// createProgramFilesPath("Eclipse_3.4\\eclipse"), "eclipse.exe"),
		VSNET(
				"Microsoft Visual Studio",
				createProgramFilesPath("Microsoft Visual Studio 10.0\\Common7\\IDE"),
				"devenv.exe");

		String name;
		File location;
		String exe;

		Application(String name, File location, String exe) {
			this.name = name;
			this.location = location;
			this.exe = exe;
		}

		public String getName() {
			return name;
		}

		public String getDefaultExe() {
			return exe;
		}

		public File getInstallLocation() {
			
			return new File(getProperty(this.toString() + DIR, location
					.getAbsolutePath()));
		}
	}

	/**
	 * List of product identifiers used for the settings. Also includes the
	 * version names (e.g. 2008), and default EXE files.
	 * <p>
	 * To set an alternative location, set the corresponding _DIR variable. E.g.
	 * XMLSPY_DIR=XMLSpy2007r3. Note that this does NOT include the full path.
	 * Also note, that this will NOT affect the examples folder location, since
	 * this will (probably) not change for minor releases (while you might one
	 * separate installations for SPs).
	 * <p>
	 * So, to make the confusion complete, you can also set the installation
	 * version, by just using XMLSPY=XMLSpy2009 (without the _DIR) prefix. This
	 * will affect the {@link #getVersion()} method, the examples location. And
	 * if the _DIR variable is not set, also the installation location.
	 * <p>
	 * If this was a good idea to separate or not, remains to be seen, since the
	 * new examples locations went into the builds just a few weeks ago. If it's
	 * a mess, now is a good time to try to make it better.
	 * <p>
	 * The variables can be set as an environment variable, VM setting or
	 * property file setting.
	 * 
	 */
	public static enum AltovaApplication implements ApplicationSettings {

		ALTOVA_XML("AltovaXML2013", "AltovaXML.exe"), AUTHENTIC(
				"Authentic2015", "Authentic.exe"), DATABASESPY(
				"DatabaseSpy2016", "DatabaseSpy.exe"), DIFFDOG("DiffDog2015",
				"DiffDog.exe"), MAPFORCE("MapForce2016", "MapForce.exe"), SCHEMAAGENT(
				"SchemaAgentClient2015", "SchemaAgent.exe"), SEMANTICWORKS(
				"SemanticWorks2013", "SemanticWorks.exe"), XMLSPY("XmlSpy2015",
				"XMLSpy.exe"), STYLEVISION("StyleVision2015", "StyleVision.exe"), UMODEL(
				"UModel2016", "UModel.exe");


		String version;

		String defaultExe;

		AltovaApplication(String version, String defaultExe) {
			this.version = version;
			this.defaultExe = defaultExe;
		}

		/**
		 * 
		 * @return the default version name, e.g. UModel2008
		 */
		public String getVersion() {
			return version;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.altova.util.Settings.ApplicationSettings#getDefaultExe()
		 */
		public String getDefaultExe() {
			return defaultExe;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.altova.util.Settings.ApplicationSettings#getInstallLocation()
		 */
		public File getInstallLocation() {

			String productDir = getProperty(this.toString() + DIR,
					getVersionName(this));
			return new File(getAltovaDir(), productDir);
		}

		/**
		 * This returns the directory which contains the examples file for the
		 * application. It takes into account the user folder, as specified by
		 * the USERPROFILE environment variable in Windows, and also the
		 * application variable settings (e.g. XMLSPY=XMLSpy3043).
		 * <p>
		 * Special note about XMLSpy: For most applications, we seem to use the
		 * format [application name]Examples, however for XMLSpy it's just
		 * called Examples. If other applications behaves differently, this is
		 * the place to work around it.
		 * 
		 * @return the default examples file location. E.g.
		 *         C:\User\hab\Altova\My
		 *         Documents\Altova\UModel2009\UModelExaples
		 */
		public File getExamplesLocation() {
			File base = new File(getAltovaMyDocumentsPath(),
					getVersionName(this));

			String example = this.toString().toLowerCase() + "Examples";
			if (this.equals(XMLSPY)) {
				example = "Examples";
			}

			return new File(base, example);
		}

		public File getProgramFiles_x86() {
			if (isX64()) {
				return new File("C:\\Program Files (x86)");
			} else {
				return new File("C:\\Program Files");
			}
		}
		
	};

	static {
		putExplanation(OUT,
				"Output directory for generated files, pictures, etc.");
		putExplanation(DEBUG, "Output directory for image debugging files.");
		putExplanation(EXPECTED, "Input directory for expected image files.");
		putExplanation(DELAY_MULTIPLY,
				"Multiplier used for delay times in the scripts.");
		putExplanation(JUNIT_DRYRUN,
				"If =true, don't compare screen images in JUnit test (only run test).");
		putExplanation(DEBUG_IMAGES, "If =true, save debug screen images.");
		putExplanation(DEBUG_IMAGE_DIFF,
				"If =true, save compare screen images data.");
		putExplanation(AUTOMATION_CONFIG_FILE,
				"Config file automation (GUI, functional, etc).");
		putExplanation(new String[] { "java.util.logging.config.file" },
				"Config file for logger output.");

		printUsage();
	}

	// avoid construction
	// this should stay private, as all the methods in this class are static
	private Settings() {

	}

	private static void putExplanation(String[] keys, String text) {
		explanations.put(text, keys);
	}

	private static void putExplanation(String keys, String text) {
		explanations.put(text, new String[] { keys });
	}

	// Not sure if this thing was a very good idea... However, wont delete it
	// just in case
	// setting to deprecated
	@Deprecated
	public static void setPropertiesFile(String fileName) {
		if (fileName == null)
			throw new NullPointerException();
		File f = new File(fileName);
		if ((!f.exists()) || (!f.isFile())) {
			logger.warning("could not set properties file: "
					+ f.getAbsolutePath());
			throw new ScriptMistakeException("file not found: " + fileName);
		}
		logger.info("setting properties file as: " + f.getAbsolutePath());
		System.setProperty(AUTOMATION_CONFIG_FILE[0], f.getAbsolutePath());
	}

	private static boolean loadPropFile() {
		 //String fileName = System.getenv(AUTOMATION_CONFIG_FILE[0]);
		String fileName = System.getProperty(AUTOMATION_CONFIG_FILE[0]);
		if (fileName == null) {
			return false;
		}

		File file = new File(fileName);
		if (!file.exists()) {
			logger.warning("Property file " + file.getAbsolutePath()
					+ " does not exist");
			return false;
		}

		logger.info("Loading property file " + file.getAbsolutePath());

		InputStream in = null;
		Properties tmpProp = new Properties();
		try {
			in = new BufferedInputStream(new FileInputStream(file));
			tmpProp.load(in);
			in.close();
		} catch (IOException e) {
			tmpProp = null;
			logger.warning("An error occurred while reading the property file"
					+ file + "\n" + IOUtils.getStackTrace(e));
			if (in != null) {
				try {
					in.close();
				} catch (IOException e1) {
				} // ignore
			}
		}

		if (tmpProp != null) {
			propsFromFile = tmpProp;
			propertyFile = file;
			return true;
		}

		return false;
	}

	private static String getPropertyFromFile(String key) {
		if (propsFromFile == null) {
			if (!loadPropFile()) {
				return null;
			}
		}
		return propsFromFile.getProperty(key);
	}

	private static void logSetting(String msg) {
		if (msg == null) {
			return;
		}

		if (msg.equals(previousMsg)) {
			return;
		}

		logger.info(msg);
		previousMsg = msg;
	}

	/**
	 * Returns the value for the give variable/key. If this key is not specified
	 * anywhere, null is returned.
	 * 
	 * @param key
	 *            the variable name
	 * @return the value of the variable, from the environment variable,
	 *         properties file, VM variable, or source code.
	 */
	public static String getProperty(String key) {
		return getProperty(key, null);
	}

	/**
	 * Returns the value for the give variable/key. If this key is not specified
	 * anywhere, false is returned.
	 * 
	 * @param key
	 *            the variable name
	 * @return the value of the variable, from the environment variable,
	 *         properties file, VM variable, or source code.
	 */
	public static boolean getFlag(String key) {
		return Boolean.parseBoolean(getProperty(key, "false"));
	}

	private static String getProperty(String keys[], String def) {
		String ans = null;
		for (String k : keys) {
			ans = getProperty(k);
			if (ans != null) {
				break;
			}
		}

		// Finally, check if we can use the default value
		if (ans == null && def != null) {
			ans = def;
			logSetting("Setting " + printArray(keys) + " to '" + ans
					+ "' based on default value");
		}

		return ans;
	}

	public static int getProperty(String key, int def) {
		return Integer.parseInt(getProperty(key, "" + def));
	}

	/**
	 * Returns the value for the give variable/key. The process follows these
	 * steps to find the value. If a value is found, this is returned, but if
	 * not, the next step is checked.
	 * <p>
	 * <ol>
	 * <li>Check if there is a VM variable (-DmyKey=true) with the given name.
	 * This is case sensitive.</li>
	 * <li>Check the properties file specified by the variable
	 * automation.config.file. The key names are case sensitive</li>
	 * <li>Check if an environment variable with the key name prefixed by
	 * ROBOTS_ exists. Windows environment variables are not case sensitive.</li>
	 * <li>Check if an environment variable with the key name exists. Windows
	 * environment variables are not case sensitive.</li>
	 * <li>Check if the def argument was specified.</li>
	 * <li>If no value still has not been found, a logger warning messages is
	 * printed, and null is returned.</li>
	 * </ol>
	 * 
	 * @param key
	 *            the variable name
	 * @param def
	 *            the default value to return, if not set elsewhere
	 * @return the value of the variable, from the environment variable,
	 *         properties file, VM variable, or source code.
	 * 
	 */
	/**
	 * Returns the value for the give variable/key. The process follows these
	 * steps to find the value. If a value is found, this is returned, but if
	 * not, the next step is checked.
	 * <p>
	 * <ol>
	 * <li>Check if there is a VM variable (-DmyKey=true) with the given name.
	 * This is case sensitive.</li>
	 * <li>Check the properties file specified by the variable
	 * automation.config.file. The key names are case sensitive</li>
	 * <li>Check if an environment variable with the key name prefixed by
	 * ROBOTS_ exists. Windows environment variables are not case sensitive.</li>
	 * <li>Check if an environment variable with the key name exists. Windows
	 * environment variables are not case sensitive.</li>
	 * <li>Check if the def argument was specified.</li>
	 * <li>If no value still has not been found, a logger warning messages is
	 * printed, and null is returned.</li>
	 * </ol>
	 * 
	 * @param key
	 *            the variable name
	 * @param def
	 *            the default value to return, if not set elsewhere
	 * @return the value of the variable, from the environment variable,
	 *         properties file, VM variable, or source code.
	 * 
	 */
	public static String getProperty(String key, String def) {
		String source;
		String ans = null;

		// 1. Check any parsed command line (args[])
		// create this method to interface against any parsed args[] parameters
		// this is probably redundant now, I guess...
		// ans = getCommandLine(key);
		source = "command line";

		// 2. Then check VM system property
		if (ans == null) {
			ans = System.getProperty(key);
			source = "'-D" + key
					+ "' system property (values are CASE SENSITVE)";
		}

		// 3. Then check properties file
		if (ans == null) {
			ans = getPropertyFromFile(key);
			source = "property file " + propertyFile
					+ " (values are CASE SENSITVE)";
		}

		// 4. Then look if there is a ROBOTS_ variable
		if (ans == null) {
			ans = System.getenv(ROBOTS_PREFIX + key);
			source = "'" + ROBOTS_PREFIX + key
					+ "' environment variable (not case sensitive)";
		}

		// 5. Then look if there is a normal environment variable
		if (ans == null) {
			ans = System.getenv(key);
			source = "'" + key + "' environment variable (not case sensitive)";
		}

		// 6. Finally, check if we can use the default value
		if (ans == null) {
			ans = def;
			source = "default value given in your Java source code";
		}

		// 7. Now we'll have to give up
		if (ans == null) {
			logger
					.warning("Property '"
							+ key
							+ "' was not found. (Property file and -Dxxx variables are case sensitive).");
			source = "NOT FOUND";
		} else {
			logSetting("Setting '" + key + "' to '" + ans
					+ "' based on value in " + source);
		}

		return ans;
	}

	private static File getDir(String key[]) {
		String value = getProperty(key, System.getProperty("user.dir"));
		return new File(value);
	}

	/**
	 * @return the output directory for tests. Mostly used for outputting
	 *         pictures.
	 */
	public static File getOutputDir() {
		return getDir(OUT);
	}

	/**
	 * @return the debug directory. Typically, hundres of picturse will end up
	 *         here during a test.
	 */
	public static File getDebugDir() {
		return getDir(DEBUG);
	}

	/**
	 * @return the directory which contains expected images for the tests.
	 */
	public static File getExpectedDir() {
		return getDir(EXPECTED);
	}

	/**
	 * @return the multiplier used to extend the delay times throughout the test
	 *         and robot classes.
	 */
	public static double getDelayMultiply() {
		String value = getProperty(DELAY_MULTIPLY, "1");
		double ans = 1;
		try {
			ans = Double.parseDouble(value);
		} catch (NumberFormatException e) {
		} // do nothing

		return ans;
	}

	/**
	 * @return true if JUnit image asserts should be skipped.
	 */
	public static boolean isJUnitDryRun() {
		 return getFlag(JUNIT_DRYRUN);
	}

	/**
	 * @return true if VS2010 is being run
	 */
	public static boolean isVS2010() {
		return getFlag(VS2010);
	}
	
	/**
	 * @return true if a 64bit application is being run
	 */
	public static boolean isX64() {
		return getFlag(X64);
	}
	

	private static void printUsage() {
		if (Boolean.parseBoolean(getProperty("usage", "false"))) {
			System.out.println();
			System.out
					.println("All options below must be prefixed by the JVM option -D.");
			System.out.println("E.g. java -Dusage=true ...");
			System.out.println();
			for (Map.Entry<String, String[]> e : explanations.entrySet()) {
				System.out
						.println(printArray(e.getValue()) + "\t" + e.getKey());
			}
			System.out.println();
			System.out.println();
		} else {
			logger
					.info("To print command line usage options, use the option -Dusage=true.");
		}
	}

	private static String printArray(String keys[]) {
		String ans = "";
		for (int i = 0; i < keys.length; i++) {
			ans += keys[i];
			if (i < keys.length - 1) {
				ans += ", ";
			}
		}

		return ans;
	}

	/**
	 * @return true if debug images should be written.
	 */
	public static boolean debugImages() {
		return getProperty(DEBUG_IMAGES, "true").equalsIgnoreCase("true");
	}

	/**
	 * @return true if debug diff images should be written.
	 */
	public static boolean debugImageDiff() {
		return getFlag(DEBUG_IMAGE_DIFF);
	}

	
	public static boolean isX64OS() {
		
		String OSVersion = getProperty("PROCESSOR_ARCHITECTURE","x86"); //def for Win 32 bit OS
		//String OSVersion = System.getProperty("os.arch");
		if (OSVersion.equals("AMD64"))
			return true;
		else
			return false;
	}
	
	public static boolean isWinXP() {
		
		String OSVersion = getProperty("os.version","6.1"); //def for Win 7 /Server2012
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>><SO is XPPPPP?:" + System.getProperty("os.version"));
		if (OSVersion.equals("5.1"))
			return true;
		else
			return false;
	}
	
	/**
	 * Return the default Program Files directory. This will vary based on the
	 * language of the Windows installation. It uses the Windows environment
	 * variable "ProgramFiles" to get this.
	 * 
	 * @return the ProgramFiles location
	 */
	public static File getProgramFiles() {
		
		if (!isX64() && isX64OS())
			return new File(getProperty("ProgramFiles(x86)", "C:\\Program Files (x86)"));
		else
			return new File(getProperty("ProgramFiles", "C:\\Program Files"));
			
	}		 
		
	/**
	 * Append the specified path to the Program Files path.
	 * 
	 * @param path
	 *            the path to append.
	 * @return the specified path concatenated with the default Program Files
	 *         location
	 */
	public static File createProgramFilesPath(String path) {
		return new File(getProgramFiles(), path);
	}

	/**
	 * Returns the default 'My Documents' location. This is by default under the
	 * users User profile directory, as set by the Windows environment variable
	 * USERPROFILE. To this path, 'My Documents' is appended.
	 * 
	 * @return the default user 'My Documents' folder location. E.g.
	 *         C:\Documents and Settings\hab\My Documents, or on Vista:
	 *         C:\Users\hab\My Documents
	 */
	public static File getMyDocumentsPath() {
		return new File(getProperty("USERPROFILE"), "My Documents");
	}

	/**
	 * @return the default directory 'Altova' under 'My Documents'.
	 */
	public static File getAltovaMyDocumentsPath() {
		return new File(getMyDocumentsPath(), "Altova");
	}

	/**
	 * Returns the location of the Altova directory, normally under, C:\Program
	 * Files\Altova. The location can be customized by setting the variable
	 * ALTOVA_DIR, however only the name of sub directory should be specified,
	 * not the full path. E.g. ALTOVA_DIR=Altova_testing
	 * 
	 * @return the location of the Altova directory under Program Files
	 */
	public static File getAltovaDir() {
		
		if (!isX64OS() || (isX64OS() && isX64())){
			return new File(getProgramFiles(),
					getProperty(ALTOVA_DIR, "Altova"));
		}else{ 
			return new File("C:\\Program Files (x86)",
					getProperty(ALTOVA_DIR, "Altova"));
		}	

	}

	/**
	 * Returns the version name, e.g. UModel2008, as specified by the variable
	 * corresponding to the product (UMODEL), or the default in the
	 * {@link AltovaApplication} source code.
	 * 
	 * @param product
	 *            the product enumeration key
	 * @return the version name
	 */
	public static String getVersionName(AltovaApplication product) {
		return getProperty(product.toString(), product.getVersion());
	}

	/**
	 * Returns the default EXE file location for the specified product. This
	 * includes the full path and name for the exe file, e.g. "C:\Program
	 * Files\Altova\MapForce2008\MapForce.exe"
	 * 
	 * @param product
	 *            the product enumeration key
	 * @return location of the EXE file for the product
	 */
	public static File getDefaultExeLocation(AltovaApplication product) {
		return new File(product.getInstallLocation(), product.getDefaultExe());
	}

	/**
	 * @return the location of the UModel installation
	 */
	public static File getUModelLocation() {
		return AltovaApplication.UMODEL.getInstallLocation();
	}

	/**
	 * @return the location of the Altova XML installation
	 */
	public static File getAltovaXMLLocation() {
		return AltovaApplication.ALTOVA_XML.getInstallLocation();
	}

	/**
	 * @return the location of the XMLSpy installation
	 */
	public static File getXMLSpyLocation() {
		return AltovaApplication.XMLSPY.getInstallLocation();
	}

	/**
	 * @return the location of the DiffDog installation
	 */
	public static File getDiffDogLocation() {
		return AltovaApplication.DIFFDOG.getInstallLocation();
	}

	/**
	 * @return the location of the DiffDog.exe file
	 */
	public static String getDiffDogExe() {
		return getDefaultExeLocation(AltovaApplication.DIFFDOG)
				.getAbsolutePath();
	}

	/**
	 * @return the location of the DiffDogBatch.exe file
	 */
	public static String getDiffDogBatchExe() {
		return (new File(getDiffDogLocation(), "DiffDogBatch.exe"))
				.getAbsolutePath();
	}

	/**
	 * @return the location of the UModelBatch.exe file
	 */
	public static String getUModelBatchExe() {
		return (new File(getUModelLocation(), "UModelBatch.exe"))
				.getAbsolutePath();
	}

}
