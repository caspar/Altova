<?xml version="1.0" encoding="UTF-8"?>
<structure version="8" cssmode="strict" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="UTF-8" encodingpdf="UTF-8" useimportschema="1" embed-images="1">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="ipo" uri="http://www.altova.com/IPO"/>
			<nspair prefix="n1" uri="http://www.xmlspy.com/schemas/orgchart"/>
			<nspair prefix="ts" uri="http://www.xmlspy.com/schemas/textstate"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="OrgChart_small.xsd" workingxmlfile="OrgChart_small.xml">
				<xmltablesupport/>
				<textstateicons>
					<textstateicon match="ts:bold" iconfile="bold.bmp"/>
					<textstateicon match="ts:italic" iconfile="italic.bmp"/>
				</textstateicons>
			</xsdschemasource>
		</schemasources>
	</schemasources>
	<modules>
		<module spsfile="TextState.sps"/>
	</modules>
	<flags>
		<scripts/>
		<globalparts/>
		<designfragments/>
		<pagelayouts/>
	</flags>
	<scripts>
		<script language="javascript"/>
	</scripts>
	<globalstyles/>
	<mainparts>
		<children>
			<globaltemplate subtype="main" match="/">
				<children>
					<template subtype="source" match="XML">
						<children>
							<template subtype="element" match="n1:OrgChart">
								<children>
									<template subtype="element" match="n1:Name">
										<children>
											<content>
												<format datatype="string"/>
											</content>
										</children>
									</template>
									<newline/>
									<newline/>
									<template subtype="element" match="n1:Office">
										<children>
											<calltemplate subtype="element" match="n1:Department"/>
										</children>
									</template>
									<newline/>
									<newline/>
								</children>
							</template>
						</children>
					</template>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts>
		<children>
			<globaltemplate subtype="element" match="n1:Department">
				<children>
					<template subtype="element" match="n1:Department">
						<children>
							<text fixtext="this contains Department DATA"/>
						</children>
					</template>
				</children>
			</globaltemplate>
		</children>
	</globalparts>
	<pagelayout>
		<properties pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="1" paperheight="11in" papermarginbottom="0.79in" papermarginleft="0.6in" papermarginright="0.6in" papermargintop="0.79in" paperwidth="8.5in"/>
	</pagelayout>
	<designfragments/>
</structure>
