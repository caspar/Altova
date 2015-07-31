package com.altova.umodel.regression.testcases;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import com.altova.umodel.regression.gui.LinkMatrixReader;
import com.altova.util.IOUtils;

public abstract class AbstractDiagramTest extends AbstractUmodelTest {

	public static Collection linkMatrixFiles() {
		Collection<Object> ans = new ArrayList<Object>();
		ans.add(new Object[]{"activity_element_link_matrix.xml"});
		ans.add(new Object[]{"interaction_overview_element_link_matrix.xml"});
		ans.add(new Object[]{"class_element_link_matrix.xml"});
		ans.add(new Object[]{"component_element_link_matrix.xml"});
		ans.add(new Object[]{"deployment_element_link_matrix.xml"});
		ans.add(new Object[]{"usecase_element_link_matrix.xml"});
		ans.add(new Object[]{"protocolstatemachine_element_link_matrix.xml"});
		ans.add((new Object[]{"businessprocess_element_link_matrix.xml"}));
		
		return ans;
	}
	
	protected abstract void createTests(Collection<String> elements, Collection<String> links, LinkMatrixReader matrix) throws IOException;
	
	protected  void diagramTest(String testFile) throws IOException {
		URL file = IOUtils.findResource(testFile);
		LinkMatrixReader matrix = new LinkMatrixReader(file);
		diagramTest(matrix);
	}
	
	protected  void diagramTest(File testFile) throws IOException {
		LinkMatrixReader matrix = new LinkMatrixReader(testFile);
		diagramTest(matrix);
	}
	
	protected  void diagramTest(LinkMatrixReader matrix) throws IOException {
		Collection<String> elements = matrix.uniqueElementNames();
		Collection<String> links = matrix.uniqueLinkNames();
		
		createTests(elements, links, matrix);
	}

}
