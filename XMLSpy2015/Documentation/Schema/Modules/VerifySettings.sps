<?xml version="1.0" encoding="UTF-8"?>
<structure version="14" enforce-relative-filepaths="1" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="n1" uri="http://www.altova.com/documentation"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="..\SchemaDocumentation.xsd" workingxmlfile="..\SampleData\OrgChart.xml"/>
		</schemasources>
	</schemasources>
	<modules/>
	<flags>
		<scripts/>
		<globalparts/>
		<designfragments/>
		<pagelayouts/>
		<xpath-functions/>
	</flags>
	<scripts>
		<script language="javascript"/>
	</scripts>
	<script-project>
		<Project version="2" app="AuthenticView"/>
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
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts/>
	<designfragments>
		<children>
			<globaltemplate subtype="named" match="EnsureAllIncludesAndDetails">
				<parameters/>
				<children>
					<template subtype="source" match="XML">
						<children>
							<condition>
								<children>
									<conditionbranch xpath="every $setting in n1:SchemaDocumentation/n1:DocumentationSettings/(n1:Includes, n1:Details)/@* satisfies xs:boolean($setting)"/>
									<conditionbranch>
										<children>
											<paragraph paragraphtag="p">
												<children>
													<text fixtext="IMPORTANT! This documentation requires all Include and Details check-boxes to be checked, otherwise it might be incorrect or incomplete. Please click Check All button for both of them and re-generate documentation.">
														<styles color="red"/>
													</text>
												</children>
											</paragraph>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</designfragments>
	<xmltables/>
	<authentic-custom-toolbar-buttons/>
</structure>
