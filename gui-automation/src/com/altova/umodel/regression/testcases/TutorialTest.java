package com.altova.umodel.regression.testcases;

import static com.altova.umodel.regression.gui.UModelRobot.PROPERTIES;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.altova.robots.DropDownOption;
import com.altova.robots.Options;
import com.altova.robots.TextFieldOption;
import com.altova.robots.Pane.PaneSize;
import com.altova.umodel.regression.gui.UModelRobot;
import com.altova.util.Settings.AltovaApplication;

/**
 * The UModel tutorial as a set of JUnit tests. This might be stretching the
 * use of unit tests a bit, especially since each test method will be dependent
 * on the previous method in the order they occur. However, it makes for a nice
 * fit into the rest of the testing framework, and further assertions can easily
 * be added. 
 * 
 * @author Havard Rast Blok
 *
 */
public class TutorialTest extends AbstractUmodelTest {
	
	//protected final String BANKVIEW = "Design-phase::BankView::com::altova::bankview";
	private final String BANKVIEW = "bankview";
	
	private final String SAVINGSACCOUNT = "SavingsAccount";
	
	private final String BANKVIEW_ACCOUNT = BANKVIEW+"::Account";
	
	//private final String CMP_BANKVIEW = "Component View::BankView::BankView";
	private final String CMP_BANKVIEW = "BankView::BankView";
	
	//private final String CMP_BANKVIEW_GUI = "Component View::BankView::BankView GUI";
	private final String CMP_BANKVIEW_GUI = "BankView::BankView GUI";

	private static final File BANK_START_FILE = new File(AltovaApplication.UMODEL.getExamplesLocation(), "Tutorial\\BankView-start.ump");

	private static String previousProject = BANK_START_FILE.toString();
	//private static String previousProject = "C:\\temp\\umodel_tutorial_bank_testComponentDiagram.ump";
	
	private String currentProject;
	
	private final String BANK_BASENAME = "C:\\temp\\umodel_tutorial_bank_";

	private final String ROUNDTRIP_PATH = "c:\\temp\\umodel_tutorial_roundtrip";

	@Before
	public void setUp() throws Exception {
		//super.setUp();
		currentProject = BANK_BASENAME+getTestName()+".ump";
		robot.newPrj();
		if(currentProject != null) {
			removeAndAssert(new File(currentProject));
		}
		robot.openPrj(previousProject);
		previousProject = null;
	}
	
	@After
	public void tearDown() {
		previousProject = currentProject;
		robot.removeAllElementKeys();
	}
	
	private void saveAndAssert() {
		robot.saveReplacePrj(currentProject);
		assertFileExists(new File(currentProject));
		//TODO: NEED UMP DIFF ASSERT HERE
	}
	
	/**
	 * Page: UModel tutorial/Use cases
	 *
	 */
	@Test
	public void testUseCases() {
		
		//robot.openPrj(BANK_START_FILE.toString());
		
		//add a new package to a project
		robot.newRootElement("Package", "Use Case View");
		
		//Adding a diagram to a package
		robot.newDiagram("UseCase", "Use Case View", "Overview Account Balance");
		robot.turnOffDiagramJunk();
		
		//Adding Use case elements to the Use Case diagram
		robot.setModelTreeSize(PaneSize.NORMAL);
		robot.putElement("Actor", "Standard User", 400, 300);
		robot.putElement("UseCase", "get account balance", 600, 150);
		robot.linkElements("Association", "Actor1", "UseCase1");
		
		//Finishing up the use case diagram
		robot.putElement("UseCase", "get account balance sum", 600, 300);
		robot.linkElements("Association", "Actor1", "UseCase2");
		robot.putElement("UseCase", "generate monthly revenue report", 600, 450);
		robot.linkElements("Include", "UseCase2", "UseCase1");
		
		//Inserting user-defined actors
		robot.putElement("Actor", "Bank", 900, 450);
		robot.setPaneValue(PROPERTIES, "icon file name", "Bank-PC.bmp");
		robot.linkElements("Association", "Actor2", "UseCase3");
		
		//Aligning and adjusting the size of elements:
		robot.select("UseCase1", "UseCase2", "UseCase3");
		robot.leftClick("ID_MAKE_SAME_SIZE");
		robot.leftClick("ID_CENTER_HORIZ");
		
		saveAndAssert();
	}
	
	/**
	 * Page: UModel tutorial/Class Diagrams
	 *
	 */
	@Test
	public void testClassDiagrams1() {
		//removeAndAssert(new File(BANK_CLASS1));
		//robot.openPrj(BANK_USECASES);
		
		robot.setModelTreeSize(PaneSize.WIDE);
		
		//open a different diagram in UModel
		robot.openDiagram("BankView Main");
		robot.turnOffDiagramJunk();
		
		//add a new class and define it as abstract
		robot.putElement("Class", "Account", 400, 400);
		//TODO: need to make special case for check boxes 
		robot.setPaneValue(PROPERTIES, "abstract", " ");
		robot.keyType(KeyEvent.VK_SPACE);
		robot.setPaneValue(PROPERTIES, "code file name", "Account.java");
		
		//add properties to a class
		robot.addProperty("Class1", "balance:float=0");
		robot.addProperty("Class1", "Id:String");
		
		//add operations to a class
		robot.addOperation("Class1", "Account()");
		robot.addOperation("Class1", "getBalance():float");
		robot.addOperation("Class1", "getId():String");
		robot.addOperation("Class1", "collectAccountInfo(bankAPI:IBankAPI):boolean");
		
		//SPLIT THE METHOD HERE. Need different name instead of "Class1"
		
		//Deleting (finding) class properties and options from the Model Tree
		robot.addOperation("Class1", "");
		robot.clickModelTreeItem("Operation1");
		robot.keyType(KeyEvent.VK_DELETE);
		
		//Creating a composition association between the Bank and Account classes
		String bank ="Design-phase::BankView::com::altova::bankview::Bank";
		robot.findDiagramElement(bank,true);
		robot.linkElements("Composition", bank, "Class1" );
		robot.leftClickElement(bank);
		robot.findModelTreeElement("Property1",true);
		robot.setPaneValue(PROPERTIES, "name", "account");
		robot.setPaneValue(PROPERTIES, "multiplicity", "*");
		
		saveAndAssert();
	}

	/**
	 * Page: UModel tutorial/Class Diagrams/Creating derived classes
	 *
	 */
	@Test
	public void testDerivedClass() {
		//removeAndAssert(new File(BANK_CLASS1));
		//robot.openPrj(BANK_CLASS1);
		
		//create a new Class Diagram
		robot.newDiagram("Class", BANKVIEW, "Account Hierarchy");
		robot.zoom(80);
		robot.turnOffDiagramJunk();
		
		//Inserting existing classes into a diagram
		final String BANKVIEW_CheckingAccount = BANKVIEW+"::CheckingAccount";
		final String BANKVIEW_CreditCardAccount = BANKVIEW+"::CreditCardAccount";
		
		robot.dropElementOnDiagram(BANKVIEW_ACCOUNT, new Point(600, 140));
		robot.dropElementOnDiagram(BANKVIEW_CheckingAccount, new Point(400, 350));
		robot.dropElementOnDiagram(BANKVIEW_CreditCardAccount, new Point(700, 350));
		
		//Adding a new class
		robot.deselectAll();
		robot.putElement("Class", SAVINGSACCOUNT, 950, 350);
		robot.addProperty(SAVINGSACCOUNT, "interestRate:float");
		robot.addOperation(SAVINGSACCOUNT, SAVINGSACCOUNT+"()");
		robot.addOperation(SAVINGSACCOUNT, "getMinimumBalance():float");
		robot.leftClickElement(SAVINGSACCOUNT);
		robot.setPaneValue(PROPERTIES, "code file name", SAVINGSACCOUNT+".java");
		
		//Reusing/copying existing Properties/Operations
		final String BANKVIEW_SAVINGSACCOUNT = BANKVIEW +"::"+ SAVINGSACCOUNT;
		robot.leftClickModelTreeElement(BANKVIEW_ACCOUNT+"::collectAccountInfo",false);
		robot.copy();
		robot.leftClickModelTreeElement(BANKVIEW_SAVINGSACCOUNT,false);
		robot.paste();
		
		//Creating derived classes - Generalization/Specialization
		robot.activateDiagram();
		robot.linkElements("Generalization", BANKVIEW_SAVINGSACCOUNT, BANKVIEW_ACCOUNT);
		robot.linkElements("Generalization", BANKVIEW_CreditCardAccount, BANKVIEW_ACCOUNT);
		robot.linkElements("Generalization", BANKVIEW_CheckingAccount, BANKVIEW_ACCOUNT);
		
		saveAndAssert();
	}
	
	/**
	 * Page: UModel tutorial/Object Diagrams
	 *
	 */
	@Test
	public void testObjectDiagram() {
		//open the Object diagram
		robot.openDiagram(BANKVIEW+"::Sample Accounts");
		robot.turnOffDiagramJunk();
		robot.dropElementOnDiagram(BANKVIEW_ACCOUNT, new Point(800, 140));
		
		//add a new object/instance by selecting its type
		final String CREDIT = "John's Credit";
		final String SAVING = "John's Saving";
		final String instanceSpecification = "InstanceSpecification";
		robot.putElement(instanceSpecification, CREDIT, 800, 310);
		robot.setPaneValue(PROPERTIES, "classifier", "CreditCardAccount");
		
		//add a new object in the Model Tree view (then insert it into a diagram)
		robot.putElement(instanceSpecification, SAVING, 970, 450);
		robot.setPaneValue(PROPERTIES, "classifier", "SavingsAccount");
		
		//Creating "links" between objects
		//TODO: no combo box available, see TTP #19454
		final String ALTOVABANK = "AltovaBank";
		robot.linkElements(instanceSpecification, CREDIT, ALTOVABANK);
		robot.linkElements(instanceSpecification, SAVING, ALTOVABANK);
		
		//Formatting association/link lines in a diagram
		//1. Click the lowest link in the diagram, if not active, and drag the corner connector to the left.
		
			//Cannot do this. It is virtually impossible to hit this points, even manually.
		
		//Entering sample data into objects
			//not entering values.
		
		saveAndAssert();
	}
	
	/**
	 * Page: UModel tutorial/Component Diagrams
	 *
	 */
	@Test
	public void testComponentDiagram() {
		//open the component diagram
		robot.openDiagram("BankView realization");
		robot.turnOffDiagramJunk();
		
		//insert (existing) classes into a component diagram
		robot.dropElementOnDiagram(BANKVIEW_ACCOUNT, new Point(850, 140));
		robot.dropElementOnDiagram(BANKVIEW + "::" + SAVINGSACCOUNT, new Point(850, 350));
		
		//create Realization dependencies between a class and component
		robot.linkElements("ComponentRealization", BANKVIEW_ACCOUNT, CMP_BANKVIEW);
		robot.linkElements("ComponentRealization", BANKVIEW + "::" + SAVINGSACCOUNT, CMP_BANKVIEW);
		
		//Changing (Realization) line characteristics
			//not doing this. tested elsewhere
		
		//Inserting components and creating usage dependencies
		robot.openDiagram("Overview");
		robot.turnOffDiagramJunk();
		
		robot.dropElementOnDiagram(CMP_BANKVIEW, new Point(400, 200));
		robot.dropElementOnDiagram(CMP_BANKVIEW_GUI, new Point(400, 300));
		
		//create a usage dependency between interfaces and components
		final String IBankAPI = "Design-phase::Banking access::IBankAPI";
		robot.linkElements("Usage", CMP_BANKVIEW_GUI, CMP_BANKVIEW);
		robot.linkElements("Usage", CMP_BANKVIEW_GUI, IBankAPI);
		
		saveAndAssert();
	}
	
	/**
	 * Page: UModel tutorial/Deployment Diagrams
	 *
	 */
	@Test
	public void testDeploymentDiagram() {
		//open the Deployment (Artifacts) diagram
		//don't do this..
		//robot.openDiagram("Artifacts");
		//robot.turnOffDiagramJunk();
		
		//open the Deployment diagram
		robot.openDiagram("Deployment View::Deployment");
		robot.turnOffDiagramJunk();
		
		//add a Node to a Deployment diagram
		robot.putElement("Node", "Bank", 700, 200);
		
		//create a dependency between two nodes
		robot.linkElements("Dependency", "Home PC", "Bank");
		
		//Adding artifacts to a node and creating dependencies between them
		final String BANKADDRESSES = "BankAddresses.ini";
		final String BANKAPI = "BankAPI.jar";
		final String BANKVIEW_JAR = "BankView.jar";
		
		robot.dropElementOnDiagram(BANKADDRESSES, 400, 400);
		robot.dropElementOnDiagram(BANKAPI, 400, 550);
		robot.dropElementOnDiagram(BANKVIEW_JAR, 400, 700);
		robot.moveElement(BANKADDRESSES, 430, 230);
		robot.moveElement(BANKAPI, 430, 300);
		robot.moveElement(BANKVIEW_JAR, 550, 300);
		
		//delete an artifact from a node and the project
		robot.select(BANKADDRESSES);
		robot.delete();
		robot.undo();
		
		//remove an artifact from a node and its diagram
		robot.select(BANKAPI);
		robot.deleteFromDiagramOnly();
		robot.undo();
		
		saveAndAssert();
	}
	
	/**
	 * Page: UModel tutorial/Round-trip engineering (model - code - model)
	 *
	 */
	@Test
	public void testRoundTrip1() {
		//define a code generation target directory
		robot.findModelTreeElement(CMP_BANKVIEW,true);
		robot.setPaneValue(PROPERTIES, "directory", ROUNDTRIP_PATH );
		
		//include/exclude components from code generation
		robot.findModelTreeElement("Bank API client",false);
		robot.setPaneValue(PROPERTIES, "use for code engineering", " " );
		
		//Checking project syntax prior to code generation
		robot.syntaxCheck();
		robot.checkMessageWindow();
		
		//generate project code
		//twice
		robot.modelToCode(null);
		robot.modelToCode(null);
		
		//Synchronizing the UModel model having updated Java code externally
		//TODO: should we make some changes to the file?? copy it in from somewhere else, maybe??
		//twice
		robot.codeToModel(null);
		robot.codeToModel(null);
		
		saveAndAssert();
	}
	
	/**
	 * Page: UModel tutorial/Round-trip engineering (code - model - code)
	 *
	 */
	@Test
	@Ignore("Ignored since unzip is not a universal Windows application.")
	public void testRoundTrip2() {
		//unzip OrgChart.zip
		robot.newPrj();
		File dir = robot.unzipOrgChart();
		
		//Reverse engineer/import existing code from a directory
		Options options = new Options();
		options.add(new DropDownOption("Language", "Java5"));
		options.add(new TextFieldOption("Directory", dir.getAbsolutePath()));
		//TODO: add options to generate diagram, etc. Need the page stuff in options then..
		robot.codeToModel(options);
		
		//Adding a new class to the OrgChart diagram
		robot.openDiagram("OrgChart::com::OrgChart::Content of OrgChart");
		robot.turnOffDiagramJunk();
		
		final String companyType = "CompanyType";
		robot.putElement("Class", companyType, 500, 400);
		robot.addOperation(companyType, companyType+"()");
		robot.addOperation(companyType, "getCompanyType():String");
		robot.addOperation(companyType, "setCompanyType():String");
		
		//Making the new class available for code generation
		robot.setPaneValue(PROPERTIES, "code file name", companyType+".java");
		
		//Merging program code from a pac
		
		saveAndAssert();
	}


}
