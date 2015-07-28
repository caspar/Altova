package com.altova.semanticworks;

import static com.altova.robots.SnapshotArea.CommonArea.DIAGRAM_MAIN_WINDOW;
import static com.altova.semanticworks.SemanticWorksRobot.DETAILS;
import static com.altova.semanticworks.SemanticWorksRobot.ERRORS;
import static com.altova.semanticworks.SemanticWorksRobot.OVERVIEW;

import java.awt.Font;
import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

import com.altova.semanticworks.SemanticWorksRobot.OverviewTab;
import com.altova.semanticworks.SemanticWorksRobot.add;
import com.altova.semanticworks.SemanticWorksRobot.classes;
import com.altova.semanticworks.SemanticWorksRobot.common;
import com.altova.semanticworks.SemanticWorksRobot.owl;
import com.altova.semanticworks.SemanticWorksRobot.property;
import com.altova.semanticworks.SemanticWorksRobot.sublevel;

public class RDFOWLFunctionality extends AbstractSemanticWorks{

	@Before
	public void setUp() throws Exception {
		//super.setUp();
			robot.newFile();
	}

	Rectangle semanticWin = null;
	
	@Test
	public final void testNew_RDF_Resource_AddResource() {
		
		robot.RDF_Level();
		robot.addNewElement(OverviewTab.Resources, "Add resource");
		
		robot.addNewSubElement(common.Predicate);
		robot.addNewSubElementS("Property", sublevel.blank_node_object);
		robot.addNewSubElementS("blank node", common.Predicate);
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_RDFS_Classes_Class() {
		
		robot.RDFS_Level();
		robot.addNewElement(OverviewTab.Classes, "rdfs (Schema):Class");
		
		robot.addNewSubElement(classes.subClassOf, add.Add_annotation_property);
		robot.addNewSubElementS("AnnotationProperty", sublevel.blank_node_object);
		robot.addNewSubElementS("blank node", owl.Thing, common.Predicate);
		robot.addDefaultSubElementWP();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_RDFS_Properties_Property() {
		
		robot.RDFS_Level();
		robot.addNewElement(OverviewTab.Properties, "rdf:Property");
		
		robot.addNewSubElement(property.subPropertyOf, property.domain, property.range, add.Add_annotation_property);
		robot.addNewSubElementSPlain("domain", add.Add_Class);
		robot.addNewSubElementSPlain("range", add.Add_Class);
		robot.addNewSubElementS("AnnotationProperty", sublevel.literal_object);
		robot.addDefaultSubElementWP();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_RDFS_Instances_Addresource() {
		
		robot.RDFS_Level();
		robot.addNewElement(OverviewTab.Instances, "Add resource");
		
		robot.addNewSubElement(owl.Thing, common.Predicate);
		robot.addNewSubElementS("type", add.Add_Class, add.Add_anonymous_Class, add.Add_Restriction);
		robot.addNewSubElementS("Property", sublevel.blank_node_object);
		robot.addNewSubElementS("blank node", owl.Thing, common.Predicate);
		robot.addDefaultSubElementWP();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLLite_Classes_Class() {
		
		robot.OWLLite_Level();
		robot.addNewElement(OverviewTab.Classes, "owl:Class");
		
		robot.addNewSubElement(classes.subClassOf, classes.intersectionOf, classes.equivalentClass, add.Add_annotation_property);
		robot.addNewSubElementS("AnnotationProperty", sublevel.rdf);
		robot.addDefaultSubElementWP();

				
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLLite_Properties_ObjectProperty() {
		
		robot.OWLLite_Level();
		robot.addNewElement(OverviewTab.Properties, "owl:ObjectProperty");
		
		robot.addNewSubElement(property.subPropertyOf, property.domain, property.range, property.equivalentProperty, property.inverseOf, add.Add_annotation_property);
		robot.addNewSubElementSPlain("domain", add.Add_Class);
		robot.addNewSubElementSPlain("range", add.Add_Class);
		robot.addNewSubElementS("AnnotationProperty", sublevel.blank_node_object);
		robot.addNewSubElementS("blank node", common.Predicate, owl.Thing, owl.sameAs, owl.differentFrom, add.Add_annotation_property);
		
		robot.addDefaultSubElementWP();

				
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLLite_Properties_DatatypeProperty() {
		
		robot.OWLLite_Level();
		robot.addNewElement(OverviewTab.Properties, "owl:DatatypeProperty");
		
		robot.addNewSubElement(property.subPropertyOf, property.domain, property.range, property.equivalentProperty, add.Add_annotation_property);
		robot.addNewSubElementS("annotationProperty", sublevel.literal_object);
		robot.addNewSubElementSPlain("domain", add.Add_Class);
		robot.addNewSubElementSPlain("range", add.Add_XML_schema_datatype);
		robot.addDefaultSubElementWP();
				
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLLite_Properties_AnnotationProperty() {
		
		robot.OWLLite_Level();
		robot.addNewElement(OverviewTab.Properties, "owl:AnnotationProperty");
		
		robot.addNewSubElement(add.Add_annotation_property);
		robot.addNewSubElementS("annotationProperty", sublevel.resource_object);
		robot.addDefaultSubElementWP();
				
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLLite_Properties_OntologyProperty() {
		
		robot.OWLLite_Level();
		robot.addNewElement(OverviewTab.Properties, "owl:OntologyProperty");
				
		robot.addNewSubElement(add.Add_annotation_property);
		robot.addNewSubElementS("AnnotationProperty", sublevel.blank_node_object);
		robot.addNewSubElementS("blank node", common.Predicate, owl.Thing, owl.sameAs, owl.differentFrom, add.Add_annotation_property);
		robot.addDefaultSubElementWP();

		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLLite_Instances_Instance() {
		
		robot.OWLLite_Level();
		robot.addNewElement(OverviewTab.Instances, "Instance");
		
		robot.addNewSubElement(owl.sameAs, owl.differentFrom, add.Add_annotation_property);
		robot.addNewSubElementS("type", add.Add_Class, add.Add_anonymous_Class, add.Add_Restriction);
		robot.addNewSubElementS("annotationProperty", sublevel.resource_object); 
		robot.addDefaultSubElement();
				
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	//ttp 35414
	@Test
	public final void testNew_OWLLite_AllDifferent_AllDifferent() {
		
		robot.OWLLite_Level();
		robot.addNewElement(OverviewTab.allDifferent, "AllDifferent", "blank node");
		
		robot.addNewSubElement("distinctMembers",add.Add_Instance);
				
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLLite_Ontologies_Ontology() {
		
		robot.OWLLite_Level();
		robot.addNewElement(OverviewTab.Ontologies, "owl:Ontology");
		
		robot.addNewSubElement(owl.imports, owl.priorVersion, owl.versionInfo, owl.incompatibleWith, owl.ontology_property );
		robot.addNewSubElementS("imports", sublevel.ontology_object);
		robot.addNewSubElementS("versionInfo", sublevel.literal_object);
		robot.addNewSubElementS("incompatibleWith", sublevel.ontology_object);
		robot.addNewSubElementS("OntologyProperty", sublevel.ontology_object);
		robot.addDefaultSubElementWP();

				
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	
	@Test
	public final void testNew_OWLDL_Classes_Class() {
		
		robot.OWLDL_Level();
		robot.addNewElement(OverviewTab.Classes, "owl:Class");
		
		robot.addNewSubElement(classes.subClassOf, classes.intersectionOf, classes.equivalentClass, classes.unionOf, classes.complementOf, classes.oneOf, classes.disjointWith, add.Add_annotation_property);
		robot.addNewSubElementS("AnnotationProperty", sublevel.rdf);
		robot.addDefaultSubElementWP();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLDL_Properties_ObjectProperty() {
		
		robot.OWLDL_Level();
		robot.addNewElement(OverviewTab.Properties, "owl:ObjectProperty");
				
		robot.addNewSubElement(property.subPropertyOf, property.domain, property.range, property.equivalentProperty, property.inverseOf, add.Add_annotation_property);
		robot.addNewSubElementSPlain("domain", add.Add_Class);
		robot.addNewSubElementSPlain("domain", add.Add_Restriction);
		robot.addNewSubElementSPlain("range", add.Add_Class);
		robot.addNewSubElementSPlain("range", add.Add_Restriction);
		robot.addNewSubElementS("AnnotationProperty", sublevel.blank_node_object);
		robot.addNewSubElementS("blank node", common.Predicate, owl.Thing, owl.sameAs, owl.differentFrom, add.Add_annotation_property);	
		robot.addDefaultSubElementWP();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLDL_Properties_DatatypeProperty() {
		
		robot.OWLDL_Level();
		robot.addNewElement(OverviewTab.Properties, "owl:DatatypeProperty");
		
		robot.addNewSubElement(property.subPropertyOf, property.domain, property.range, property.equivalentProperty, add.Add_annotation_property );
		robot.addNewSubElementSPlain("domain", add.Add_Class);
		robot.addNewSubElementSPlain("domain", add.Add_Restriction);
		robot.addNewSubElementSPlain("range", add.Add_XML_schema_datatype);
		robot.addNewSubElementSPlain("range", add.Add_DataRange);
		robot.addNewSubElementS("annotationProperty", sublevel.literal_object);
		robot.addDefaultSubElementWP();
		
				
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLDL_Properties_AnnotationProperty() {
		
		robot.OWLDL_Level();
		robot.addNewElement(OverviewTab.Properties, "owl:AnnotationProperty");
		
		robot.addNewSubElement(add.Add_annotation_property);
		robot.addNewSubElementS("annotationProperty", sublevel.blank_node_object);
		robot.addNewSubElementS("blank node", owl.sameAs, owl.differentFrom, owl.Thing, common.Predicate, add.Add_annotation_property);
		robot.addNewSubElementS("ObjectProperty", sublevel.resource_object);
		robot.addDefaultSubElementWP();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLDL_Properties_OntologyProperty() {
		
		robot.OWLDL_Level();
		robot.addNewElement(OverviewTab.Properties, "owl:OntologyProperty");
		
		robot.addNewSubElement(add.Add_annotation_property);
		robot.addNewSubElementS("annotationProperty", sublevel.rdf);
		robot.addDefaultSubElementWP();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLDL_Instances_Instance() {
		
		robot.OWLDL_Level();
		robot.addNewElement(OverviewTab.Instances, "Instance");
		
		robot.addNewSubElement(owl.sameAs, owl.differentFrom, add.Add_annotation_property);
		robot.addNewSubElementS("type", add.Add_Class, add.Add_anonymous_Class, add.Add_Restriction);
		robot.addNewSubElementS("annotationProperty", sublevel.literal_object);
		robot.addNewSubElementS("blank node", classes.subClassOf, classes.intersectionOf, classes.equivalentClass); 
		robot.addDefaultSubElement();
				
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	//ttp 35414
	@Test
	public final void testNew_OWLDL_AllDifferent_AllDifferent() {
		
		robot.OWLDL_Level();
		robot.addNewElement(OverviewTab.allDifferent, "AllDifferent", "blank node");
		
		robot.addNewSubElement("distinctMembers",add.Add_Instance);
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLDL_Ontologies_Ontology() {
		
		robot.OWLDL_Level();
		robot.addNewElement(OverviewTab.Ontologies, "owl:Ontology");
		
		robot.addNewSubElement(owl.imports, owl.priorVersion, owl.versionInfo, owl.incompatibleWith, owl.ontology_property );
		robot.addNewSubElementS("imports", sublevel.ontology_object);
		robot.addNewSubElementS("versionInfo", sublevel.literal_object);
		robot.addNewSubElementS("incompatibleWith", sublevel.ontology_object);
		robot.addNewSubElementS("OntologyProperty", sublevel.ontology_object);
		robot.addDefaultSubElementWP();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLFull_Classes_Class() {
		
		robot.OWLFull_Level();
		robot.addNewElement(OverviewTab.Classes, "owl:Class");
				
		robot.addNewSubElement(classes.subClassOf, classes.intersectionOf, classes.equivalentClass, classes.unionOf, classes.complementOf, classes.oneOf, classes.disjointWith, owl.sameAs, owl.differentFrom);
		robot.addDefaultSubElement();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}

	@Test
	public final void testNew_OWLFull_Classes_rdfsClass() {
		
		robot.OWLFull_Level();
		robot.addNewElement(OverviewTab.Classes, "rdfs (Schema):Class");
		
		robot.addNewSubElement(classes.subClassOf, classes.intersectionOf, classes.equivalentClass, classes.unionOf, classes.complementOf, classes.oneOf, classes.disjointWith, owl.sameAs, owl.differentFrom);
		robot.addDefaultSubElement();
		//robot.addNewSubElementS("ObjectProperty", sublevel.resource_object);
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLFull_Properties_ObjectProperty() {
		
		robot.OWLFull_Level();
		robot.addNewElement(OverviewTab.Properties, "owl:ObjectProperty");
				
		robot.addNewSubElement(property.subPropertyOf, property.domain, property.range, property.equivalentProperty, property.inverseOf, owl.sameAs, owl.differentFrom );
		robot.addNewSubElementSPlain("domain", add.Add_Class);
		robot.addNewSubElementSPlain("domain", add.Add_Restriction);
		robot.addNewSubElementSPlain("range", add.Add_Class);
		robot.addNewSubElementSPlain("range", add.Add_Restriction);
		robot.addDefaultSubElement();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLFull_Properties_DatatypeProperty() {
		
		robot.OWLFull_Level();
		robot.addNewElement(OverviewTab.Properties, "owl:DatatypeProperty");
		
		robot.addNewSubElement(property.subPropertyOf, property.domain, property.range, property.equivalentProperty, owl.sameAs, owl.differentFrom );
		robot.addNewSubElementSPlain("domain", add.Add_Class);
		robot.addNewSubElementSPlain("domain", add.Add_Restriction);
		robot.addNewSubElementSPlain("range", add.Add_XML_schema_datatype);
		robot.addNewSubElementSPlain("range", add.Add_DataRange);
		robot.addDefaultSubElement();
				
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLFull_Properties_AnnotationProperty() {
		
		robot.OWLFull_Level();
		robot.addNewElement(OverviewTab.Properties, "owl:AnnotationProperty");

		robot.addNewSubElement(property.subPropertyOf, property.domain, property.range, property.equivalentProperty, property.inverseOf, owl.sameAs, owl.differentFrom );
		robot.addNewSubElementSPlain("domain", add.Add_Class);
		robot.addNewSubElementSPlain("domain", add.Add_Restriction);
		robot.addDefaultSubElement();

		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLFull_Properties_OntologyProperty() {
		
		robot.OWLFull_Level();
		robot.addNewElement(OverviewTab.Properties, "owl:OntologyProperty");
		
		robot.addNewSubElement(property.subPropertyOf, property.domain, property.range, property.equivalentProperty, property.inverseOf, owl.sameAs, owl.differentFrom );
		robot.addNewSubElementSPlain("domain", add.Add_Class);
		robot.addNewSubElementSPlain("domain", add.Add_Restriction);
		robot.addDefaultSubElement();
				
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}

	@Test
	public final void testNew_OWLFull_Properties_Property() {
		
		robot.OWLFull_Level();
		robot.addNewElement(OverviewTab.Properties, "rdf:Property");
		
		robot.addNewSubElement(property.subPropertyOf, property.domain, property.range, property.equivalentProperty, property.inverseOf, owl.sameAs, owl.differentFrom );
		robot.addNewSubElementSPlain("domain", add.Add_Class);
		robot.addNewSubElementSPlain("domain", add.Add_Restriction);
		robot.addDefaultSubElement();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLFull_Instances_Instance() {
		
		robot.OWLFull_Level();
		robot.addNewElement(OverviewTab.Instances, "Instance");
		
		robot.addNewSubElement(owl.sameAs, owl.differentFrom);
		robot.addNewSubElementS("type", add.Add_Class, add.Add_anonymous_Class, add.Add_Restriction);
		robot.addDefaultSubElement();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	//ttp 35414
	@Test
	public final void testNew_OWLFull_AllDifferent_AllDifferent() {
		
		robot.OWLFull_Level();
		robot.addNewElement(OverviewTab.allDifferent, "AllDifferent", "blank node");
		
		robot.addNewSubElement("distinctMembers",add.Add_Instance, add.Add_Class, add.Add_Property );			
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_OWLFull_Ontologies_Ontology() {
		
		robot.OWLFull_Level();
		robot.addNewElement(OverviewTab.Ontologies, "owl:Ontology");
		
		robot.addNewSubElement(owl.imports, owl.priorVersion, owl.versionInfo, owl.incompatibleWith );
		robot.addNewSubElementS("imports", sublevel.resource_object);
		robot.addNewSubElementS("versionInfo", sublevel.blank_node_object);
		robot.addNewSubElementS("incompatibleWith", sublevel.literal_object);
		//robot.addNewSubElementS("priorVersion", sublevel.rdf); not recognizable by robot
		robot.addDefaultSubElement();
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	@Test
	public final void testNew_Switch1_OWLFULLtoRDF() {
		
		robot.OWLFull_Level();
		robot.addNewElement(OverviewTab.Classes, "owl:Class");
		
		robot.RDF_Level();
		robot.openDiagram("Unnamed", OverviewTab.Resources);
		
		assertAreas(DIAGRAM_MAIN_WINDOW, ERRORS, DETAILS, OVERVIEW);
		
	}
	
	
}
