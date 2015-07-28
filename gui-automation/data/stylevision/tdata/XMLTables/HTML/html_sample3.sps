<?xml version="1.0" encoding="UTF-8"?>
<structure version="12" htmlmode="strict" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="def" uri="http://testing.es"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="html.xsd" workingxmlfile="html_sample3.xml"/>
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
				<document-properties/>
				<children>
					<documentsection>
						<properties columncount="1" columngap="0.50in" headerfooterheight="fixed" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.30in" papermarginheader="0.30in" papermarginleft="0.60in" papermarginright="0.60in" papermargintop="0.79in" paperwidth="8.50in"/>
					</documentsection>
					<template subtype="source" match="XML">
						<children>
							<template subtype="element" match="def:root">
								<children>
									<template subtype="element" match="def:child2">
										<children>
											<template subtype="element" match="def:TABLE" create-xml-table="1">
												<variables/>
											</template>
										</children>
										<variables/>
									</template>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts/>
	<designfragments/>
	<xmltables>
		<children>
			<xmltable type="HTML">
				<children>
					<xmltable-tag tag-name="def:TABLE"/>
					<xmltable-tag tag-type="Caption"/>
					<xmltable-tag tag-type="Header" tag-name="def:THEAD"/>
					<xmltable-tag tag-type="Footer" tag-name="def:TFOOD"/>
					<xmltable-tag tag-type="Body" tag-name="def:TBODY"/>
					<xmltable-tag tag-type="Row" tag-name="def:TR"/>
					<xmltable-tag tag-type="Cell" tag-name="def:TD"/>
					<xmltable-tag tag-type="HeaderCell" tag-name="def:TH"/>
				</children>
			</xmltable>
		</children>
	</xmltables>
	<authentic-custom-toolbar-buttons/>
</structure>
