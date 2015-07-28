<?xml version="1.0" encoding="UTF-8"?>
<structure version="12" htmlmode="strict" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" authentic-scripts-in-debug-mode="0" authentic-scripts-process-events="1">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="def" uri="http://testing.es"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="html_variation.xsd" workingxmlfile="html_variation.xml"/>
		</schemasources>
	</schemasources>
	<modules/>
	<flags>
		<scripts/>
		<globalparts/>
		<designfragments/>
		<pagelayouts/>
	</flags>
	<scripts>
		<script language="javascript"/>
	</scripts>
	<script-project>
		<Project version="1" app="AuthenticView"/>
	</script-project>
	<importedxslt/>
	<globalstyles/>
	<mainparts>
		<children>
			<globaltemplate subtype="main" match="/">
				<children>
					<documentsection>
						<properties columncount="1" columngap="0.50in" headerfooterheight="fixed" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.30in" papermarginheader="0.30in" papermarginleft="0.60in" papermarginright="0.60in" papermargintop="0.79in" paperwidth="8.50in"/>
					</documentsection>
					<template subtype="source" match="XML">
						<children>
							<content/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts>
		<children>
			<globaltemplate subtype="element" match="TH" schema-tree-path="TH">
				<children>
					<template subtype="element" match="TH">
						<children>
							<content>
								<styles background-color="#c0a0ff"/>
							</content>
							<text fixtext="bladibla"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="TBODY" schema-tree-path="TBODY">
				<children>
					<template subtype="element" match="TBODY">
						<children>
							<content/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</globalparts>
	<pagelayout>
		<properties paperheight="11.69in" paperwidth="8.27in"/>
	</pagelayout>
	<designfragments/>
	<xmltables>
		<children>
			<xmltable type="HTML">
				<children>
					<xmltable-tag tag-name="TABLE"/>
					<xmltable-tag tag-type="Caption"/>
					<xmltable-tag tag-type="Header" tag-name="THEAD"/>
					<xmltable-tag tag-type="Footer"/>
					<xmltable-tag tag-type="Body" tag-name="TBODY"/>
					<xmltable-tag tag-type="Row" tag-name="TR"/>
					<xmltable-tag tag-type="Cell" tag-name="TD"/>
					<xmltable-tag tag-type="HeaderCell" tag-name="TH"/>
				</children>
			</xmltable>
		</children>
	</xmltables>
	<authentic-custom-toolbar-buttons/>
</structure>
