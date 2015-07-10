<?xml version="1.0" encoding="UTF-8"?>
<structure version="15" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="n1" uri="http://www.altova.com/documentation"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="SchemaDocumentation.xsd" workingxmlfile="SampleData\Sample.xml"/>
		</schemasources>
	</schemasources>
	<modules>
		<module spsfile="Modules\VerifySettings.sps"/>
	</modules>
	<flags>
		<scripts/>
		<mainparts>
			<mainpart match="/" spsfile="Modules\VerifySettings.sps" isactive="0"/>
		</mainparts>
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
	<globalstyles>
		<rules selector=".SchemaHeading">
			<media>
				<media value="all"/>
			</media>
			<rule font-size="larger" font-weight="bold"/>
		</rules>
	</globalstyles>
	<mainparts>
		<children>
			<globaltemplate subtype="main" match="/">
				<document-properties/>
				<children>
					<documentsection>
						<properties columncount="1" columngap="0.50in" headerfooterheight="fixed" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.30in" papermarginheader="0.30in" papermarginleft="0.60in" papermarginright="0.60in" papermargintop="0.79in" paperwidth="8.50in"/>
						<children>
							<globaltemplate subtype="pagelayout" match="footerall">
								<children>
									<calltemplate subtype="named" match="Footer">
										<parameters/>
									</calltemplate>
								</children>
							</globaltemplate>
							<globaltemplate subtype="pdf-bookmarktree" match="pdf-bookmarktree">
								<children>
									<pdf-bookmark>
										<children>
											<link>
												<children>
													<text fixtext="Overall"/>
												</children>
												<action>
													<none/>
												</action>
												<hyperlink>
													<fixtext value="#Overall"/>
												</hyperlink>
											</link>
										</children>
									</pdf-bookmark>
									<template subtype="source" match="XML">
										<children>
											<template subtype="element" match="n1:SchemaDocumentation">
												<children>
													<template subtype="element" match="n1:SchemaDocument">
														<children>
															<template subtype="attribute" match="schemaLocation">
																<children>
																	<pdf-bookmark>
																		<children>
																			<link>
																				<children>
																					<content/>
																				</children>
																				<action>
																					<none/>
																				</action>
																				<hyperlink>
																					<fixtext value="#"/>
																					<xpath value="generate-id()"/>
																				</hyperlink>
																			</link>
																		</children>
																	</pdf-bookmark>
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
					</documentsection>
					<calltemplate subtype="named" match="EnsureAllIncludesAndDetails">
						<parameters/>
					</calltemplate>
					<template subtype="source" match="XML">
						<children>
							<template subtype="element" match="n1:SchemaDocumentation">
								<children>
									<paragraph>
										<styles keep-together="always"/>
										<children>
											<bookmark>
												<action>
													<none/>
												</action>
												<bookmark>
													<fixtext value="Overall"/>
												</bookmark>
											</bookmark>
											<text fixtext="The overall schema consists of:">
												<properties class="SchemaHeading"/>
											</text>
											<calltemplate subtype="named" match="Stats">
												<parameters>
													<parameter name="StatsFor" value="n1:SchemaDocument"/>
													<parameter name="ReportFiles" value="true()"/>
												</parameters>
											</calltemplate>
										</children>
									</paragraph>
									<template subtype="element" match="n1:SchemaDocument">
										<sort>
											<key match="upper-case(@schemaLocation)"/>
										</sort>
										<children>
											<paragraph>
												<children>
													<text fixtext=" "/>
												</children>
											</paragraph>
											<paragraph>
												<styles keep-together="always"/>
												<children>
													<template subtype="attribute" match="schemaLocation">
														<children>
															<bookmark>
																<action>
																	<none/>
																</action>
																<bookmark>
																	<xpath value="generate-id()"/>
																</bookmark>
															</bookmark>
															<content>
																<properties class="SchemaHeading"/>
															</content>
															<text fixtext=" defines:">
																<properties class="SchemaHeading"/>
															</text>
														</children>
														<variables/>
													</template>
													<calltemplate subtype="named" match="Stats">
														<parameters>
															<parameter name="StatsFor" value="."/>
														</parameters>
													</calltemplate>
												</children>
											</paragraph>
										</children>
										<variables/>
									</template>
								</children>
								<variables/>
							</template>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;HTML&apos;">
										<children>
											<calltemplate subtype="named" match="Footer">
												<parameters/>
											</calltemplate>
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
	</mainparts>
	<globalparts/>
	<designfragments>
		<children>
			<globaltemplate subtype="named" match="Stats">
				<parameters>
					<parameter name="StatsFor"/>
					<parameter name="ReportFiles" type="xs:boolean" default-value="false()"/>
				</parameters>
				<children>
					<tgrid>
						<properties border="0"/>
						<children>
							<tgridbody-cols>
								<children>
									<tgridcol>
										<properties align="right"/>
										<styles width="0.50in"/>
									</tgridcol>
									<tgridcol>
										<styles width="3in"/>
									</tgridcol>
								</children>
							</tgridbody-cols>
							<tgridbody-rows>
								<children>
									<template subtype="userdefined" match="if ($ReportFiles) then 1 else ()">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<children>
															<autocalc xpath="count($XML//n1:SchemaDocument)"/>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<text fixtext="Files"/>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
										</children>
										<variables/>
									</template>
									<tgridrow>
										<children>
											<tgridcell>
												<children>
													<autocalc xpath="count($StatsFor/n1:Element)"/>
												</children>
											</tgridcell>
											<tgridcell>
												<children>
													<text fixtext="Global Elements"/>
												</children>
											</tgridcell>
										</children>
									</tgridrow>
									<tgridrow>
										<children>
											<tgridcell>
												<children>
													<autocalc xpath="count($StatsFor/*//n1:Element)"/>
												</children>
											</tgridcell>
											<tgridcell>
												<children>
													<text fixtext="Local Elements"/>
												</children>
											</tgridcell>
										</children>
									</tgridrow>
									<tgridrow>
										<children>
											<tgridcell>
												<children>
													<autocalc xpath="count($StatsFor/n1:Group)"/>
												</children>
											</tgridcell>
											<tgridcell>
												<children>
													<text fixtext="Groups"/>
												</children>
											</tgridcell>
										</children>
									</tgridrow>
									<tgridrow>
										<children>
											<tgridcell>
												<children>
													<autocalc xpath="count($StatsFor/n1:ComplexType)"/>
												</children>
											</tgridcell>
											<tgridcell>
												<children>
													<text fixtext="Complex Types"/>
												</children>
											</tgridcell>
										</children>
									</tgridrow>
									<tgridrow>
										<children>
											<tgridcell>
												<children>
													<autocalc xpath="count($StatsFor/n1:SimpleType)"/>
												</children>
											</tgridcell>
											<tgridcell>
												<children>
													<text fixtext="Simple Types"/>
												</children>
											</tgridcell>
										</children>
									</tgridrow>
									<tgridrow>
										<children>
											<tgridcell>
												<children>
													<autocalc xpath="count($StatsFor/n1:Attribute)"/>
												</children>
											</tgridcell>
											<tgridcell>
												<children>
													<text fixtext="Global Attributes"/>
												</children>
											</tgridcell>
										</children>
									</tgridrow>
									<tgridrow>
										<children>
											<tgridcell>
												<children>
													<autocalc xpath="count($StatsFor/*//n1:Attribute)"/>
												</children>
											</tgridcell>
											<tgridcell>
												<children>
													<text fixtext="Local Attributes"/>
												</children>
											</tgridcell>
										</children>
									</tgridrow>
									<tgridrow>
										<children>
											<tgridcell>
												<children>
													<autocalc xpath="count($StatsFor/n1:AttributeGroup)"/>
												</children>
											</tgridcell>
											<tgridcell>
												<children>
													<text fixtext="Attribute Groups"/>
												</children>
											</tgridcell>
										</children>
									</tgridrow>
									<tgridrow>
										<children>
											<tgridcell>
												<children>
													<autocalc xpath="count($StatsFor/n1:Notation)"/>
												</children>
											</tgridcell>
											<tgridcell>
												<children>
													<text fixtext="Notations"/>
												</children>
											</tgridcell>
										</children>
									</tgridrow>
								</children>
							</tgridbody-rows>
						</children>
					</tgrid>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="Footer">
				<parameters/>
				<children>
					<paragraph paragraphtag="p">
						<properties class="schemaSubTitle"/>
						<styles font-size="smaller"/>
						<children>
							<text fixtext="XML Schema documentation generated by ">
								<styles color="gray"/>
							</text>
							<link>
								<children>
									<text fixtext="XMLSpy"/>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="http://www.altova.com/xmlspy"/>
								</hyperlink>
							</link>
							<text fixtext=" Schema Editor ">
								<styles color="gray"/>
							</text>
							<link>
								<properties class="schemaName"/>
								<children>
									<text fixtext="http://www.altova.com/xmlspy"/>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="http://www.altova.com/xmlspy"/>
								</hyperlink>
							</link>
						</children>
					</paragraph>
				</children>
			</globaltemplate>
		</children>
	</designfragments>
	<xmltables/>
	<authentic-custom-toolbar-buttons/>
</structure>
