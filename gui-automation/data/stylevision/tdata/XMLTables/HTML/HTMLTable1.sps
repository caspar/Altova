<?xml version="1.0" encoding="UTF-8"?>
<structure version="12" htmlmode="strict" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces/>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="HTMLTable1.xsd" workingxmlfile="HTMLTable1.xml"/>
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
							<template subtype="element" match="SmartGrid">
								<children>
									<text fixtext="Smart Grid Electrical Consumption Report">
										<styles font-size="larger" font-style="inherit" font-variant="small-caps"/>
									</text>
									<newline/>
									<newline/>
									<text fixtext="For:"/>
									<newline/>
									<newline/>
									<template subtype="element" match="Customer">
										<children>
											<template subtype="element" match="Name">
												<children>
													<content/>
												</children>
												<variables/>
											</template>
											<newline/>
											<template subtype="element" match="Street">
												<children>
													<content/>
												</children>
												<variables/>
											</template>
											<newline/>
											<template subtype="element" match="City">
												<children>
													<content/>
												</children>
												<variables/>
											</template>
											<text fixtext=", "/>
											<template subtype="element" match="State">
												<children>
													<content/>
												</children>
												<variables/>
											</template>
											<text fixtext=" "/>
											<template subtype="element" match="ZIP">
												<children>
													<content>
														<format basic-type="xsd" datatype="short"/>
													</content>
												</children>
												<variables/>
											</template>
										</children>
										<variables/>
									</template>
									<newline/>
									<newline/>
									<newline/>
									<template subtype="element" match="ElectricalConsumption">
										<children>
											<newline/>
											<text fixtext="Consumption for MeterID: "/>
											<template subtype="element" match="MeterID">
												<children>
													<content>
														<format basic-type="xsd" datatype="int"/>
													</content>
												</children>
												<variables/>
											</template>
											<newline/>
											<newline/>
											<template subtype="element" match="TableData" create-xml-table="1">
												<variables/>
											</template>
										</children>
										<variables/>
									</template>
								</children>
								<variables/>
							</template>
							<newline/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts/>
	<pagelayout>
		<properties paperheight="11.69in" paperwidth="8.27in"/>
	</pagelayout>
	<designfragments/>
	<xmltables>
		<children>
			<xmltable type="HTML">
				<children>
					<xmltable-tag tag-name="TableData"/>
					<xmltable-tag tag-type="Caption"/>
					<xmltable-tag tag-type="Header" tag-name="Header"/>
					<xmltable-tag tag-type="Footer"/>
					<xmltable-tag tag-type="Body" tag-name="Body"/>
					<xmltable-tag tag-type="Row" tag-name="Row"/>
					<xmltable-tag tag-type="Cell" tag-name="Element">
						<styles text-align="right"/>
					</xmltable-tag>
					<xmltable-tag tag-type="HeaderCell" tag-name="Heading">
						<styles border-bottom-color="navy" border-bottom-style="solid" border-bottom-width="thin" font-style="italic"/>
					</xmltable-tag>
				</children>
			</xmltable>
		</children>
	</xmltables>
	<authentic-custom-toolbar-buttons/>
</structure>
