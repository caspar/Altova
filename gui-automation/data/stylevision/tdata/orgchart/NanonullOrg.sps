<?xml version="1.0" encoding="UTF-8"?>
<structure version="14" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="UTF-8" encodingpdf="UTF-8" useimportschema="1" embed-images="1" pastemode="xml" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="ipo" uri="http://www.altova.com/IPO"/>
			<nspair prefix="n1" uri="http://www.xmlspy.com/schemas/orgchart"/>
			<nspair prefix="ts" uri="http://www.xmlspy.com/schemas/textstate"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="NanonullOrg.xsd" workingxmlfile="NanonullOrg.xml"/>
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
						<properties columncount="1" columngap="48px" headerfooterheight="variable" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="1" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.0in" papermarginheader="0.0in" papermarginleft="0.6in" papermarginright="0.6in" papermargintop="0.79in" paperwidth="8.5in"/>
					</documentsection>
					<template subtype="source" match="XML">
						<children>
							<template subtype="element" match="n1:OrgChart">
								<children>
									<bookmark>
										<action>
											<none/>
										</action>
										<bookmark>
											<fixtext value="top_of_page"/>
										</bookmark>
									</bookmark>
									<template subtype="element" match="n1:CompanyLogo">
										<editorproperties autoaddname="1" editable="1" adding="mandatory" markupmode="hide"/>
										<children>
											<paragraph>
												<styles border-bottom-color="#0588BA" border-bottom-style="solid" border-bottom-width="medium" border-width="4pt" padding-bottom="10px" padding-left="10px"/>
												<children>
													<template subtype="attribute" match="href">
														<editorproperties autoaddname="1" editable="1" markupmode="hide"/>
														<children>
															<link>
																<children>
																	<image>
																		<properties border="0"/>
																		<styles height="76px" width="153px"/>
																		<target>
																			<xpath value="."/>
																		</target>
																	</image>
																</children>
																<action>
																	<none/>
																</action>
																<hyperlink>
																	<fixtext value="http://www.nanonull.com/"/>
																</hyperlink>
															</link>
														</children>
														<variables/>
													</template>
												</children>
											</paragraph>
										</children>
										<variables/>
									</template>
									<newline/>
									<template subtype="element" match="n1:Name">
										<children>
											<content>
												<styles color="#0588BA" font-family="Arial" font-size="20pt" font-weight="bold"/>
												<format basic-type="xsd" datatype="string"/>
											</content>
										</children>
										<variables/>
									</template>
									<newline/>
									<newline/>
									<text fixtext="Location of logo: ">
										<styles color="#808080" font-family="Arial" font-size="10pt" font-weight="bold"/>
									</text>
									<template subtype="element" match="n1:CompanyLogo">
										<children>
											<template subtype="attribute" match="href">
												<children>
													<editfield>
														<styles color="#808080" font-family="Arial" font-size="smaller" font-weight="bold"/>
														<children>
															<content>
																<format basic-type="xsd" datatype="anyURI"/>
															</content>
														</children>
													</editfield>
												</children>
												<variables/>
											</template>
										</children>
										<variables/>
									</template>
									<newline/>
									<newline/>
									<template subtype="element" match="n1:Office">
										<children>
											<newline/>
											<paragraph>
												<styles border-top-color="#0588ba" border-top-style="solid" border-top-width="2pt"/>
												<children>
													<newline/>
													<template subtype="element" match="n1:Name">
														<children>
															<content>
																<styles color="#707070" font-family="Arial" font-size="15pt" font-weight="bold"/>
																<format basic-type="xsd" datatype="string"/>
															</content>
														</children>
														<variables/>
													</template>
													<newline/>
													<newline/>
													<text fixtext="Location: ">
														<styles color="#808080" font-family="Arial" font-size="10pt" font-weight="bold"/>
													</text>
													<condition>
														<children>
															<conditionbranch xpath="not(n1:Address or  n1:Address_EU)">
																<children>
																	<template subtype="element" match="n1:Location">
																		<editorproperties autoaddname="1" editable="1" adding="mandatory" markupmode="hide"/>
																		<children>
																			<combobox>
																				<editorproperties editable="1"/>
																				<children>
																					<content>
																						<format basic-type="xsd" datatype="string"/>
																					</content>
																				</children>
																				<selectoption description="US" value="US"/>
																				<selectoption description="EU" value="EU"/>
																			</combobox>
																		</children>
																		<variables/>
																	</template>
																</children>
															</conditionbranch>
															<conditionbranch xpath="n1:Address">
																<children>
																	<template subtype="element" match="n1:Location">
																		<editorproperties autoaddname="1" editable="0" adding="mandatory" markupmode="hide"/>
																		<children>
																			<combobox>
																				<children>
																					<content>
																						<format basic-type="xsd" datatype="string"/>
																					</content>
																				</children>
																				<selectoption description="US" value="US"/>
																				<selectoption description="EU" value="EU"/>
																			</combobox>
																		</children>
																		<variables/>
																	</template>
																</children>
															</conditionbranch>
															<conditionbranch xpath="n1:Address_EU">
																<children>
																	<template subtype="element" match="n1:Location">
																		<editorproperties autoaddname="1" editable="0" adding="mandatory" markupmode="hide"/>
																		<children>
																			<combobox>
																				<children>
																					<content>
																						<format basic-type="xsd" datatype="string"/>
																					</content>
																				</children>
																				<selectoption description="US" value="US"/>
																				<selectoption description="EU" value="EU"/>
																			</combobox>
																		</children>
																		<variables/>
																	</template>
																</children>
															</conditionbranch>
														</children>
													</condition>
												</children>
											</paragraph>
											<tgrid>
												<properties border="1" cellspacing="0" width="100%"/>
												<children>
													<tgridbody-cols>
														<children>
															<tgridcol>
																<properties width="60%"/>
															</tgridcol>
															<tgridcol>
																<properties width="40%"/>
															</tgridcol>
														</children>
													</tgridbody-cols>
													<tgridbody-rows>
														<children>
															<tgridrow>
																<children>
																	<tgridcell>
																		<properties valign="top"/>
																		<children>
																			<condition>
																				<children>
																					<conditionbranch xpath="n1:Location =&quot;US&quot;">
																						<children>
																							<tgrid>
																								<properties border="0" cellspacing="4px" width="100%"/>
																								<children>
																									<tgridbody-cols>
																										<children>
																											<tgridcol>
																												<properties width="30%"/>
																											</tgridcol>
																											<template subtype="element" match="n1:Address">
																												<children>
																													<tgridcol>
																														<properties width="70%"/>
																													</tgridcol>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridbody-cols>
																									<tgridbody-rows>
																										<children>
																											<tgridrow>
																												<children>
																													<tgridcell>
																														<children>
																															<text fixtext="Street: ">
																																<styles font-weight="bold"/>
																															</text>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="ipo:street">
																																<children>
																																	<content>
																																		<format basic-type="xsd" datatype="string"/>
																																	</content>
																																</children>
																																<variables/>
																															</template>
																														</children>
																													</tgridcell>
																												</children>
																											</tgridrow>
																											<tgridrow>
																												<children>
																													<tgridcell>
																														<children>
																															<text fixtext="City:">
																																<styles font-weight="bold"/>
																															</text>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="ipo:city">
																																<children>
																																	<content>
																																		<format basic-type="xsd" datatype="string"/>
																																	</content>
																																</children>
																																<variables/>
																															</template>
																														</children>
																													</tgridcell>
																												</children>
																											</tgridrow>
																											<tgridrow>
																												<children>
																													<tgridcell>
																														<children>
																															<text fixtext="State &amp; Zip:">
																																<styles font-weight="bold"/>
																															</text>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="ipo:state">
																																<children>
																																	<combobox enumeration="1">
																																		<children>
																																			<content>
																																				<format basic-type="xsd" datatype="string"/>
																																			</content>
																																		</children>
																																	</combobox>
																																</children>
																																<variables/>
																															</template>
																															<text fixtext=" "/>
																															<template subtype="element" match="ipo:zip">
																																<children>
																																	<editfield>
																																		<children>
																																			<content>
																																				<format basic-type="xsd" datatype="positiveInteger"/>
																																			</content>
																																		</children>
																																	</editfield>
																																</children>
																																<variables/>
																															</template>
																														</children>
																													</tgridcell>
																												</children>
																											</tgridrow>
																										</children>
																									</tgridbody-rows>
																								</children>
																							</tgrid>
																						</children>
																					</conditionbranch>
																					<conditionbranch xpath="n1:Location =&quot;EU&quot;">
																						<children>
																							<tgrid>
																								<properties border="0" cellspacing="4px" width="100%"/>
																								<children>
																									<tgridbody-cols>
																										<children>
																											<tgridcol>
																												<properties width="30%"/>
																											</tgridcol>
																											<template subtype="element" match="n1:Address_EU">
																												<children>
																													<tgridcol>
																														<properties width="70%"/>
																													</tgridcol>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridbody-cols>
																									<tgridbody-rows>
																										<children>
																											<tgridrow>
																												<children>
																													<tgridcell>
																														<children>
																															<text fixtext="Street:">
																																<styles font-weight="bold"/>
																															</text>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="ipo:street">
																																<children>
																																	<editfield>
																																		<children>
																																			<content>
																																				<format basic-type="xsd" datatype="string"/>
																																			</content>
																																		</children>
																																	</editfield>
																																</children>
																																<variables/>
																															</template>
																														</children>
																													</tgridcell>
																												</children>
																											</tgridrow>
																											<tgridrow>
																												<children>
																													<tgridcell>
																														<children>
																															<text fixtext="City:">
																																<styles font-weight="bold"/>
																															</text>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="ipo:city">
																																<children>
																																	<editfield>
																																		<children>
																																			<content>
																																				<format basic-type="xsd" datatype="string"/>
																																			</content>
																																		</children>
																																	</editfield>
																																</children>
																																<variables/>
																															</template>
																														</children>
																													</tgridcell>
																												</children>
																											</tgridrow>
																											<tgridrow>
																												<children>
																													<tgridcell>
																														<children>
																															<text fixtext="Post Code:">
																																<styles font-weight="bold"/>
																															</text>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
																															<template subtype="element" match="ipo:postcode">
																																<children>
																																	<editfield>
																																		<children>
																																			<content>
																																				<format basic-type="xsd" datatype="string"/>
																																			</content>
																																		</children>
																																	</editfield>
																																</children>
																																<variables/>
																															</template>
																														</children>
																													</tgridcell>
																												</children>
																											</tgridrow>
																										</children>
																									</tgridbody-rows>
																								</children>
																							</tgrid>
																						</children>
																					</conditionbranch>
																				</children>
																			</condition>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<properties valign="top"/>
																		<children>
																			<tgrid>
																				<properties border="0" cellspacing="4" width="100%"/>
																				<children>
																					<tgridbody-cols>
																						<children>
																							<tgridcol>
																								<properties width="25%"/>
																							</tgridcol>
																							<tgridcol>
																								<properties width="75%"/>
																							</tgridcol>
																						</children>
																					</tgridbody-cols>
																					<tgridbody-rows>
																						<children>
																							<tgridrow>
																								<children>
																									<tgridcell>
																										<children>
																											<text fixtext="Phone:">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="n1:Phone">
																												<children>
																													<content>
																														<format basic-type="xsd" datatype="string"/>
																													</content>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																								</children>
																							</tgridrow>
																							<tgridrow>
																								<children>
																									<tgridcell>
																										<children>
																											<text fixtext="Fax:">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="n1:Fax">
																												<editorproperties autoaddname="1" editable="1" adding="mandatory"/>
																												<children>
																													<content>
																														<editorproperties editable="1"/>
																														<format basic-type="xsd" datatype="string"/>
																													</content>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																								</children>
																							</tgridrow>
																							<tgridrow>
																								<children>
																									<tgridcell>
																										<children>
																											<text fixtext="E-mail:">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="n1:EMail">
																												<children>
																													<link>
																														<children>
																															<content>
																																<format basic-type="xsd" datatype="string"/>
																															</content>
																														</children>
																														<action>
																															<none/>
																														</action>
																														<hyperlink>
																															<fixtext value="mailto:"/>
																															<xpath value="."/>
																														</hyperlink>
																													</link>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																								</children>
																							</tgridrow>
																						</children>
																					</tgridbody-rows>
																				</children>
																			</tgrid>
																		</children>
																	</tgridcell>
																</children>
															</tgridrow>
														</children>
													</tgridbody-rows>
												</children>
											</tgrid>
											<newline/>
											<condition>
												<children>
													<conditionbranch xpath="n1:Address">
														<children>
															<template subtype="element" match="n1:Address">
																<children>
																	<template subtype="element" match="ipo:city">
																		<children>
																			<content>
																				<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
																				<format basic-type="xsd" datatype="string"/>
																			</content>
																		</children>
																		<variables/>
																	</template>
																</children>
																<variables/>
															</template>
														</children>
													</conditionbranch>
													<conditionbranch xpath="n1:Address_EU">
														<children>
															<template subtype="element" match="n1:Address_EU">
																<children>
																	<template subtype="element" match="ipo:city">
																		<children>
																			<content>
																				<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
																				<format basic-type="xsd" datatype="string"/>
																			</content>
																		</children>
																		<variables/>
																	</template>
																</children>
																<variables/>
															</template>
														</children>
													</conditionbranch>
												</children>
											</condition>
											<text fixtext=" Office Summary:">
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
											</text>
											<text fixtext="  "/>
											<autocalc xpath="count(n1:Department)">
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
											</autocalc>
											<text fixtext=" department">
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
											</text>
											<condition>
												<children>
													<conditionbranch xpath="count(n1:Department) != 1">
														<children>
															<text fixtext="s">
																<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
															</text>
														</children>
													</conditionbranch>
												</children>
											</condition>
											<text fixtext=", ">
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
											</text>
											<autocalc xpath="count(n1:Department/n1:Person)">
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
											</autocalc>
											<text fixtext=" employee">
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
											</text>
											<condition>
												<children>
													<conditionbranch xpath="count(n1:Department/n1:Person) != 1">
														<children>
															<text fixtext="s">
																<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
															</text>
														</children>
													</conditionbranch>
												</children>
											</condition>
											<text fixtext=".">
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
											</text>
											<template subtype="element" match="n1:Desc">
												<children>
													<template subtype="element" match="n1:para">
														<children>
															<paragraph paragraphtag="p">
																<children>
																	<content/>
																</children>
															</paragraph>
														</children>
														<variables/>
													</template>
												</children>
												<variables/>
											</template>
											<template subtype="element" match="n1:Department">
												<children>
													<template subtype="element" match="n1:Name">
														<children>
															<content>
																<styles color="#D39658" font-family="Arial" font-weight="bold"/>
																<format basic-type="xsd" datatype="string"/>
															</content>
														</children>
														<variables/>
													</template>
													<text fixtext=" "/>
													<text fixtext="( ">
														<styles color="#D39658" font-family="Arial" font-weight="bold"/>
													</text>
													<autocalc xpath="count(n1:Person)">
														<styles color="#D39658" font-family="Arial" font-weight="bold"/>
													</autocalc>
													<text fixtext=" )">
														<styles color="#D39658" font-family="Arial" font-weight="bold"/>
													</text>
													<newline/>
													<tgrid>
														<properties border="1" cellpadding="3" cellspacing="0" width="100%"/>
														<children>
															<tgridbody-cols>
																<children>
																	<tgridcol>
																		<properties width="10%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="12%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="16%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="5%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="23%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="10%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="8%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="8%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="8%"/>
																	</tgridcol>
																</children>
															</tgridbody-cols>
															<tgridheader-rows>
																<children>
																	<tgridrow>
																		<properties bgcolor="#D2C8AE"/>
																		<children>
																			<tgridcell>
																				<properties align="center" bgcolor="#D2C8AE"/>
																				<children>
																					<text fixtext="First">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="center" bgcolor="#D2C8AE"/>
																				<children>
																					<text fixtext="Last">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="center" bgcolor="#D2C8AE"/>
																				<children>
																					<text fixtext="Title">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="center" bgcolor="#D2C8AE"/>
																				<children>
																					<text fixtext="Ext">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="center" bgcolor="#D2C8AE"/>
																				<children>
																					<text fixtext="EMail">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="center" bgcolor="#D2C8AE"/>
																				<children>
																					<text fixtext="Shares">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="center"/>
																				<children>
																					<text fixtext="Leave">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="center"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="center"/>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell joinabove="1">
																				<properties align="center" bgcolor="#D2C8AE"/>
																			</tgridcell>
																			<tgridcell joinabove="1">
																				<properties align="center" bgcolor="#D2C8AE"/>
																			</tgridcell>
																			<tgridcell joinabove="1">
																				<properties align="center" bgcolor="#D2C8AE"/>
																			</tgridcell>
																			<tgridcell joinabove="1">
																				<properties align="center" bgcolor="#D2C8AE"/>
																			</tgridcell>
																			<tgridcell joinabove="1">
																				<properties align="center" bgcolor="#D2C8AE"/>
																			</tgridcell>
																			<tgridcell joinabove="1">
																				<properties align="center" bgcolor="#D2C8AE"/>
																			</tgridcell>
																			<tgridcell>
																				<properties align="center" bgcolor="#D2C8AE"/>
																				<children>
																					<text fixtext="Total">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="center" bgcolor="#D2C8AE"/>
																				<children>
																					<text fixtext="Used">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="center" bgcolor="#D2C8AE"/>
																				<children>
																					<text fixtext="Left">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																</children>
															</tgridheader-rows>
															<tgridbody-rows>
																<children>
																	<template subtype="element" match="n1:Person">
																		<children>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="n1:First">
																								<children>
																									<condition>
																										<children>
																											<conditionbranch xpath="../n1:Shares &gt; 0">
																												<children>
																													<content>
																														<styles font-size="10pt" font-weight="bold"/>
																													</content>
																												</children>
																											</conditionbranch>
																											<conditionbranch>
																												<children>
																													<content>
																														<styles font-size="10pt"/>
																													</content>
																												</children>
																											</conditionbranch>
																										</children>
																									</condition>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="n1:Last">
																								<children>
																									<condition>
																										<children>
																											<conditionbranch xpath="../n1:Shares &gt; 0">
																												<children>
																													<content>
																														<styles font-size="10pt" font-weight="bold"/>
																														<format basic-type="xsd" datatype="string"/>
																													</content>
																												</children>
																											</conditionbranch>
																											<conditionbranch>
																												<children>
																													<content>
																														<styles font-size="10pt"/>
																														<format basic-type="xsd" datatype="string"/>
																													</content>
																												</children>
																											</conditionbranch>
																										</children>
																									</condition>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="n1:Title">
																								<editorproperties autoaddname="1" editable="1" adding="mandatory"/>
																								<children>
																									<content>
																										<styles font-size="10pt"/>
																										<format basic-type="xsd" datatype="string"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<properties align="center"/>
																						<children>
																							<template subtype="element" match="n1:PhoneExt">
																								<children>
																									<content>
																										<editorproperties editable="1"/>
																										<styles font-size="10pt"/>
																										<addvalidations>
																											<addvalidation usermsg="Telephone extensions must be 3 digits long." xpath="string-length(.) = 3"/>
																										</addvalidations>
																										<format basic-type="xsd" datatype="int"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="n1:EMail">
																								<children>
																									<link>
																										<children>
																											<content>
																												<styles font-size="10pt"/>
																												<format basic-type="xsd" datatype="string"/>
																											</content>
																										</children>
																										<action>
																											<none/>
																										</action>
																										<hyperlink>
																											<fixtext value="mailto:"/>
																											<xpath value="."/>
																										</hyperlink>
																									</link>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<properties align="center"/>
																						<children>
																							<template subtype="element" match="n1:Shares">
																								<children>
																									<content>
																										<styles font-size="10pt"/>
																										<format basic-type="xsd" datatype="integer"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<properties align="center"/>
																						<children>
																							<template subtype="element" match="n1:LeaveTotal">
																								<children>
																									<content>
																										<styles font-size="10pt"/>
																										<format basic-type="xsd" datatype="decimal"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<properties align="center"/>
																						<children>
																							<template subtype="element" match="n1:LeaveUsed">
																								<children>
																									<content>
																										<styles font-size="10pt"/>
																										<format basic-type="xsd" datatype="decimal"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<properties align="center"/>
																						<children>
																							<autocalc xpath="n1:LeaveTotal - n1:LeaveUsed" update="n1:LeaveLeft">
																								<styles font-size="10pt"/>
																							</autocalc>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridbody-rows>
															<tgridfooter-rows>
																<children>
																	<tgridrow>
																		<properties bgcolor="#F2F0E6"/>
																		<children>
																			<tgridcell>
																				<properties align="left" valign="top"/>
																				<children>
																					<text fixtext="Employees:  ">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																					<autocalc xpath="count(  n1:Person  )">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</autocalc>
																					<text fixtext=" ">
																						<styles font-size="8pt"/>
																					</text>
																					<text fixtext="(">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																					<autocalc xpath="round ((count(  n1:Person  ) ) div ( count( ../n1:Department/ n1:Person  ) ) * 100)">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</autocalc>
																					<text fixtext="% of Office, ">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																					<autocalc xpath="round ((count(  n1:Person  ) ) div ( count( ../../n1:Office/n1:Department/ n1:Person  ) ) * 100)">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</autocalc>
																					<text fixtext="% of Company)">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left" valign="top"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left" valign="top"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left" valign="top"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left" valign="top"/>
																			</tgridcell>
																			<tgridcell>
																				<properties align="left"/>
																				<children>
																					<text fixtext="Shares: ">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																					<autocalc xpath="sum(  n1:Person/n1:Shares  )">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</autocalc>
																					<text fixtext=" ">
																						<styles font-size="8pt"/>
																					</text>
																					<text fixtext="(">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																					<autocalc xpath="round((sum(  n1:Person/n1:Shares  ) ) div (sum(../n1:Department/ n1:Person/n1:Shares ) ) * 100)">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</autocalc>
																					<text fixtext="% of Office, ">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																					<autocalc xpath="round((sum(  n1:Person/n1:Shares  ) ) div (sum(../../n1:Office/n1:Department/ n1:Person/n1:Shares  )) * 100)">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</autocalc>
																					<text fixtext="% of Company)">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<properties bgcolor="#F2F0E6"/>
																		<children>
																			<tgridcell>
																				<properties align="left"/>
																				<children>
																					<text fixtext="Non-Shareholders: ">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																					<text fixtext=" ">
																						<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																					<template subtype="element" match="n1:Person">
																						<children>
																							<condition>
																								<children>
																									<conditionbranch xpath="n1:Shares &lt;= 0 or not (n1:Shares)">
																										<children>
																											<template subtype="element" match="n1:First">
																												<children>
																													<content>
																														<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																													</content>
																												</children>
																												<variables/>
																											</template>
																											<text fixtext=" ">
																												<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																											</text>
																											<template subtype="element" match="n1:Last">
																												<children>
																													<content>
																														<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																														<format basic-type="xsd" datatype="string"/>
																													</content>
																												</children>
																												<variables/>
																											</template>
																											<condition>
																												<children>
																													<conditionbranch xpath="following-sibling::n1:Person[n1:Shares&lt;=0 or not(n1:Shares)]">
																														<children>
																															<text fixtext=", ">
																																<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																															</text>
																														</children>
																													</conditionbranch>
																												</children>
																											</condition>
																										</children>
																									</conditionbranch>
																								</children>
																							</condition>
																						</children>
																						<variables/>
																					</template>
																					<condition>
																						<children>
																							<conditionbranch xpath="count(  n1:Person  ) = count(  n1:Person [n1:Shares&gt;0] )">
																								<children>
																									<text fixtext="None">
																										<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																									</text>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																					<text fixtext=".">
																						<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																		</children>
																	</tgridrow>
																</children>
															</tgridfooter-rows>
														</children>
													</tgrid>
													<newline/>
												</children>
												<variables/>
											</template>
										</children>
										<variables/>
									</template>
									<newline/>
									<line>
										<properties color="#004080" size="2"/>
									</line>
									<newline/>
									<link>
										<children>
											<text fixtext="Go to top">
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
											</text>
										</children>
										<action>
											<none/>
										</action>
										<hyperlink>
											<fixtext value="#top_of_page"/>
										</hyperlink>
									</link>
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
	<xmltables/>
	<authentic-custom-toolbar-buttons>
		<textstateicon match="ts:bold" iconfile="bold.bmp"/>
		<textstateicon match="ts:italic" iconfile="italic.bmp"/>
	</authentic-custom-toolbar-buttons>
</structure>
