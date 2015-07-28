<?xml version="1.0" encoding="UTF-8"?>
<structure version="10" htmlmode="strict" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="ipo" uri="http://www.altova.com/IPO"/>
			<nspair prefix="n1" uri="http://www.xmlspy.com/schemas/orgchart"/>
			<nspair prefix="ts" uri="http://www.xmlspy.com/schemas/textstate"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="OrgChart.xsd" workingxmlfile="OrgChart.xml">
				<xmltablesupport/>
				<textstateicons/>
			</xsdschemasource>
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
							<template subtype="userdefined" match="1">
								<children>
									<template subtype="element" match="n1:OrgChart">
										<children>
											<template subtype="element" match="n1:Office">
												<children>
													<template subtype="element" match="n1:Department">
														<children>
															<template subtype="element" match="n1:Name">
																<children>
																	<content/>
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
	<pagelayout>
		<properties paperheight="11.69in" paperwidth="8.27in"/>
	</pagelayout>
	<designfragments/>
</structure>
