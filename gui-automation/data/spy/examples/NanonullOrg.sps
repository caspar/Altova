<?xml version="1.0" encoding="UTF-8"?>
<structure version="4" xsltversion="1">
	<schemasources>
		<namespaces>
			<nspair prefix="ipo" uri="http://www.altova.com/IPO"/>
			<nspair prefix="n1" uri="http://www.xmlspy.com/schemas/orgchart"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="$XML" main="1" schemafile="NanonullOrg.xsd" workingxmlfile="NanonullOrg.xml" templatexmlfile="NanonullOrg.xml">
				<xmltablesupport/>
				<textstateicons>
					<textstateicon match="bold" iconfile="bold.bmp"/>
					<textstateicon match="italic" iconfile="italic.bmp"/>
				</textstateicons>
			</xsdschemasource>
		</schemasources>
	</schemasources>
	<parameters/>
	<scripts>
		<javascript name="javascript"/>
	</scripts>
	<globalstyles/>
	<parts>
		<editorproperties/>
		<properties/>
		<styles/>
		<children>
			<globaltemplate match="/">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="$XML">
						<editorproperties elementstodisplay="1"/>
						<properties/>
						<styles/>
						<children>
							<template match="n1:OrgChart">
								<editorproperties elementstodisplay="1"/>
								<properties/>
								<styles/>
								<children>
									<link>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
										<target/>
										<action>
											<none/>
										</action>
										<bookmark name="top_of_page"/>
										<hyperlink/>
									</link>
									<template match="n1:CompanyLogo">
										<editorproperties editable="1" markupmode="hide" adding="mandatory" autoaddname="1"/>
										<properties/>
										<styles/>
										<children>
											<paragraph>
												<editorproperties/>
												<properties/>
												<styles border-bottom-color="#0588BA" border-bottom-style="solid" border-bottom-width="medium" border-width="4pt" padding-bottom="10px" padding-left="10px"/>
												<children>
													<template match="@href">
														<editorproperties editable="1" markupmode="hide" adding="mandatory" autoaddname="1"/>
														<properties/>
														<styles/>
														<children>
															<link>
																<editorproperties/>
																<properties/>
																<styles/>
																<children>
																	<image>
																		<editorproperties/>
																		<properties border="0"/>
																		<styles/>
																		<children/>
																		<target>
																			<xpath value="."/>
																		</target>
																		<imagesource>
																			<xpath value="."/>
																		</imagesource>
																		<imagealt/>
																	</image>
																</children>
																<target>
																	<fixtext value="http://www.nanonull.com/"/>
																</target>
																<action>
																	<none/>
																</action>
																<bookmark/>
																<hyperlink>
																	<fixtext value="http://www.nanonull.com/"/>
																</hyperlink>
															</link>
														</children>
														<addvalidations/>
													</template>
												</children>
											</paragraph>
										</children>
										<addvalidations/>
									</template>
									<newline>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</newline>
									<template match="n1:Name">
										<editorproperties elementstodisplay="1"/>
										<properties/>
										<styles/>
										<children>
											<content>
												<editorproperties/>
												<properties/>
												<styles color="#0588BA" font-family="Arial" font-size="20pt" font-weight="bold"/>
												<children/>
												<addvalidations/>
												<format datatype="string"/>
											</content>
										</children>
										<addvalidations/>
									</template>
									<newline>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</newline>
									<newline>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</newline>
									<text fixtext="Location of logo: ">
										<editorproperties/>
										<properties/>
										<styles color="#808080" font-family="Arial" font-size="smaller" font-weight="bold"/>
										<children/>
									</text>
									<template match="n1:CompanyLogo">
										<editorproperties elementstodisplay="1"/>
										<properties/>
										<styles/>
										<children>
											<template match="@href">
												<editorproperties elementstodisplay="1"/>
												<properties/>
												<styles/>
												<children>
													<editfield>
														<editorproperties/>
														<properties/>
														<styles color="#808080" font-family="Arial" font-size="smaller" font-weight="bold"/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles/>
																<children/>
																<addvalidations/>
																<format datatype="anyURI"/>
															</content>
														</children>
														<addvalidations/>
													</editfield>
												</children>
												<addvalidations/>
											</template>
										</children>
										<addvalidations/>
									</template>
									<newline>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</newline>
									<newline>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</newline>
									<template match="n1:Office">
										<editorproperties elementstodisplay="1"/>
										<properties/>
										<styles/>
										<children>
											<newline>
												<editorproperties/>
												<properties/>
												<styles/>
												<children/>
											</newline>
											<paragraph>
												<editorproperties/>
												<properties/>
												<styles border-top-color="#0588ba" border-top-style="solid" border-top-width="2pt"/>
												<children>
													<newline>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
													</newline>
													<template match="n1:Name">
														<editorproperties elementstodisplay="1"/>
														<properties/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles color="#707070" font-family="Arial" font-size="15pt" font-weight="bold"/>
																<children/>
																<addvalidations/>
																<format datatype="string"/>
															</content>
														</children>
														<addvalidations/>
													</template>
													<newline>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
													</newline>
													<newline>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
													</newline>
													<text fixtext="Location: ">
														<editorproperties/>
														<properties/>
														<styles color="#808080" font-family="Arial" font-size="smaller" font-weight="bold"/>
														<children/>
													</text>
													<condition>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<conditionbranch xpath="not(n1:Address or  n1:Address_EU)">
																<editorproperties/>
																<properties/>
																<styles/>
																<children>
																	<template match="n1:Location">
																		<editorproperties editable="1" markupmode="hide" adding="mandatory" autoaddname="1"/>
																		<properties/>
																		<styles/>
																		<children>
																			<combobox>
																				<editorproperties editable="1"/>
																				<properties size="0"/>
																				<styles/>
																				<children>
																					<content>
																						<editorproperties/>
																						<properties/>
																						<styles/>
																						<children/>
																						<addvalidations/>
																						<format datatype="string"/>
																					</content>
																				</children>
																				<addvalidations/>
																				<selectoption description="US" value="US"/>
																				<selectoption description="EU" value="EU"/>
																			</combobox>
																		</children>
																		<addvalidations/>
																	</template>
																</children>
															</conditionbranch>
															<conditionbranch xpath="n1:Address">
																<editorproperties/>
																<properties/>
																<styles/>
																<children>
																	<template match="n1:Location">
																		<editorproperties editable="0" markupmode="hide" adding="mandatory" autoaddname="1"/>
																		<properties/>
																		<styles/>
																		<children>
																			<combobox>
																				<editorproperties/>
																				<properties size="0"/>
																				<styles/>
																				<children>
																					<content>
																						<editorproperties/>
																						<properties/>
																						<styles/>
																						<children/>
																						<addvalidations/>
																						<format datatype="string"/>
																					</content>
																				</children>
																				<addvalidations/>
																				<selectoption description="US" value="US"/>
																				<selectoption description="EU" value="EU"/>
																			</combobox>
																		</children>
																		<addvalidations/>
																	</template>
																</children>
															</conditionbranch>
															<conditionbranch xpath="n1:Address_EU">
																<editorproperties/>
																<properties/>
																<styles/>
																<children>
																	<template match="n1:Location">
																		<editorproperties editable="0" markupmode="hide" adding="mandatory" autoaddname="1"/>
																		<properties/>
																		<styles/>
																		<children>
																			<combobox>
																				<editorproperties/>
																				<properties size="0"/>
																				<styles/>
																				<children>
																					<content>
																						<editorproperties/>
																						<properties/>
																						<styles/>
																						<children/>
																						<addvalidations/>
																						<format datatype="string"/>
																					</content>
																				</children>
																				<addvalidations/>
																				<selectoption description="US" value="US"/>
																				<selectoption description="EU" value="EU"/>
																			</combobox>
																		</children>
																		<addvalidations/>
																	</template>
																</children>
															</conditionbranch>
														</children>
													</condition>
												</children>
											</paragraph>
											<newline>
												<editorproperties/>
												<properties/>
												<styles/>
												<children/>
											</newline>
											<newline>
												<editorproperties/>
												<properties/>
												<styles/>
												<children/>
											</newline>
											<table>
												<editorproperties/>
												<properties border="1" cellspacing="0" width="100%"/>
												<styles/>
												<children>
													<tablebody>
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<tablerow>
																<editorproperties/>
																<properties/>
																<styles/>
																<children>
																	<tablecell>
																		<editorproperties/>
																		<properties valign="top" width="60%"/>
																		<styles/>
																		<children>
																			<condition>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children>
																					<conditionbranch xpath="n1:Location =&quot;US&quot;">
																						<editorproperties/>
																						<properties/>
																						<styles/>
																						<children>
																							<table>
																								<editorproperties/>
																								<properties border="0" cellspacing="4px" width="100%"/>
																								<styles/>
																								<children>
																									<tablebody>
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children>
																											<tablerow>
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children>
																													<tablecell>
																														<editorproperties/>
																														<properties width="30%"/>
																														<styles/>
																														<children>
																															<text fixtext="Street: ">
																																<editorproperties/>
																																<properties/>
																																<styles font-weight="bold"/>
																																<children/>
																															</text>
																														</children>
																													</tablecell>
																													<template match="n1:Address">
																														<editorproperties elementstodisplay="1"/>
																														<properties/>
																														<styles/>
																														<children>
																															<tablecell>
																																<editorproperties/>
																																<properties width="70%"/>
																																<styles/>
																																<children>
																																	<template match="ipo:street">
																																		<editorproperties elementstodisplay="1"/>
																																		<properties/>
																																		<styles/>
																																		<children>
																																			<content>
																																				<editorproperties/>
																																				<properties/>
																																				<styles/>
																																				<children/>
																																				<addvalidations/>
																																				<format datatype="string"/>
																																			</content>
																																		</children>
																																		<addvalidations/>
																																	</template>
																																</children>
																															</tablecell>
																														</children>
																														<addvalidations/>
																													</template>
																												</children>
																											</tablerow>
																											<tablerow>
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children>
																													<tablecell>
																														<editorproperties/>
																														<properties width="30%"/>
																														<styles/>
																														<children>
																															<text fixtext="City:">
																																<editorproperties/>
																																<properties/>
																																<styles font-weight="bold"/>
																																<children/>
																															</text>
																														</children>
																													</tablecell>
																													<template match="n1:Address">
																														<editorproperties elementstodisplay="1"/>
																														<properties/>
																														<styles/>
																														<children>
																															<tablecell>
																																<editorproperties/>
																																<properties width="70%"/>
																																<styles/>
																																<children>
																																	<template match="ipo:city">
																																		<editorproperties elementstodisplay="1"/>
																																		<properties/>
																																		<styles/>
																																		<children>
																																			<content>
																																				<editorproperties/>
																																				<properties/>
																																				<styles/>
																																				<children/>
																																				<addvalidations/>
																																				<format datatype="string"/>
																																			</content>
																																		</children>
																																		<addvalidations/>
																																	</template>
																																</children>
																															</tablecell>
																														</children>
																														<addvalidations/>
																													</template>
																												</children>
																											</tablerow>
																											<tablerow>
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children>
																													<tablecell>
																														<editorproperties/>
																														<properties width="30%"/>
																														<styles/>
																														<children>
																															<text fixtext="State &amp; Zip:">
																																<editorproperties/>
																																<properties/>
																																<styles font-weight="bold"/>
																																<children/>
																															</text>
																														</children>
																													</tablecell>
																													<template match="n1:Address">
																														<editorproperties elementstodisplay="1"/>
																														<properties/>
																														<styles/>
																														<children>
																															<tablecell>
																																<editorproperties/>
																																<properties width="70%"/>
																																<styles/>
																																<children>
																																	<template match="ipo:state">
																																		<editorproperties elementstodisplay="1"/>
																																		<properties/>
																																		<styles/>
																																		<children>
																																			<combobox enumeration="1">
																																				<editorproperties/>
																																				<properties size="0"/>
																																				<styles/>
																																				<children>
																																					<content>
																																						<editorproperties/>
																																						<properties/>
																																						<styles/>
																																						<children/>
																																						<addvalidations/>
																																						<format datatype="string"/>
																																					</content>
																																				</children>
																																				<addvalidations/>
																																			</combobox>
																																		</children>
																																		<addvalidations/>
																																	</template>
																																	<text fixtext=" ">
																																		<editorproperties/>
																																		<properties/>
																																		<styles/>
																																		<children/>
																																	</text>
																																	<template match="ipo:zip">
																																		<editorproperties elementstodisplay="1"/>
																																		<properties/>
																																		<styles/>
																																		<children>
																																			<editfield>
																																				<editorproperties/>
																																				<properties/>
																																				<styles/>
																																				<children>
																																					<content>
																																						<editorproperties/>
																																						<properties/>
																																						<styles/>
																																						<children/>
																																						<addvalidations/>
																																						<format datatype="positiveInteger"/>
																																					</content>
																																				</children>
																																				<addvalidations/>
																																			</editfield>
																																		</children>
																																		<addvalidations/>
																																	</template>
																																</children>
																															</tablecell>
																														</children>
																														<addvalidations/>
																													</template>
																												</children>
																											</tablerow>
																										</children>
																									</tablebody>
																								</children>
																							</table>
																						</children>
																					</conditionbranch>
																					<conditionbranch xpath="n1:Location =&quot;EU&quot;">
																						<editorproperties/>
																						<properties/>
																						<styles/>
																						<children>
																							<table>
																								<editorproperties/>
																								<properties border="0" cellspacing="4px" width="100%"/>
																								<styles/>
																								<children>
																									<tablebody>
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children>
																											<tablerow>
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children>
																													<tablecell>
																														<editorproperties/>
																														<properties width="30%"/>
																														<styles/>
																														<children>
																															<text fixtext="Street:">
																																<editorproperties/>
																																<properties/>
																																<styles font-weight="bold"/>
																																<children/>
																															</text>
																														</children>
																													</tablecell>
																													<template match="n1:Address_EU">
																														<editorproperties elementstodisplay="1"/>
																														<properties/>
																														<styles/>
																														<children>
																															<tablecell>
																																<editorproperties/>
																																<properties width="70%"/>
																																<styles/>
																																<children>
																																	<template match="ipo:street">
																																		<editorproperties elementstodisplay="1"/>
																																		<properties/>
																																		<styles/>
																																		<children>
																																			<editfield>
																																				<editorproperties/>
																																				<properties/>
																																				<styles/>
																																				<children>
																																					<content>
																																						<editorproperties/>
																																						<properties/>
																																						<styles/>
																																						<children/>
																																						<addvalidations/>
																																						<format datatype="string"/>
																																					</content>
																																				</children>
																																				<addvalidations/>
																																			</editfield>
																																		</children>
																																		<addvalidations/>
																																	</template>
																																</children>
																															</tablecell>
																														</children>
																														<addvalidations/>
																													</template>
																												</children>
																											</tablerow>
																											<tablerow>
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children>
																													<tablecell>
																														<editorproperties/>
																														<properties width="30%"/>
																														<styles/>
																														<children>
																															<text fixtext="City:">
																																<editorproperties/>
																																<properties/>
																																<styles font-weight="bold"/>
																																<children/>
																															</text>
																														</children>
																													</tablecell>
																													<template match="n1:Address_EU">
																														<editorproperties elementstodisplay="1"/>
																														<properties/>
																														<styles/>
																														<children>
																															<tablecell>
																																<editorproperties/>
																																<properties width="70%"/>
																																<styles/>
																																<children>
																																	<template match="ipo:city">
																																		<editorproperties elementstodisplay="1"/>
																																		<properties/>
																																		<styles/>
																																		<children>
																																			<editfield>
																																				<editorproperties/>
																																				<properties/>
																																				<styles/>
																																				<children>
																																					<content>
																																						<editorproperties/>
																																						<properties/>
																																						<styles/>
																																						<children/>
																																						<addvalidations/>
																																						<format datatype="string"/>
																																					</content>
																																				</children>
																																				<addvalidations/>
																																			</editfield>
																																		</children>
																																		<addvalidations/>
																																	</template>
																																</children>
																															</tablecell>
																														</children>
																														<addvalidations/>
																													</template>
																												</children>
																											</tablerow>
																											<tablerow>
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children>
																													<tablecell>
																														<editorproperties/>
																														<properties width="30%"/>
																														<styles/>
																														<children>
																															<text fixtext="Post Code:">
																																<editorproperties/>
																																<properties/>
																																<styles font-weight="bold"/>
																																<children/>
																															</text>
																														</children>
																													</tablecell>
																													<template match="n1:Address_EU">
																														<editorproperties elementstodisplay="1"/>
																														<properties/>
																														<styles/>
																														<children>
																															<tablecell>
																																<editorproperties/>
																																<properties width="70%"/>
																																<styles/>
																																<children>
																																	<template match="ipo:postcode">
																																		<editorproperties elementstodisplay="1"/>
																																		<properties/>
																																		<styles/>
																																		<children>
																																			<editfield>
																																				<editorproperties/>
																																				<properties/>
																																				<styles/>
																																				<children>
																																					<content>
																																						<editorproperties/>
																																						<properties/>
																																						<styles/>
																																						<children/>
																																						<addvalidations/>
																																						<format datatype="string"/>
																																					</content>
																																				</children>
																																				<addvalidations/>
																																			</editfield>
																																		</children>
																																		<addvalidations/>
																																	</template>
																																</children>
																															</tablecell>
																														</children>
																														<addvalidations/>
																													</template>
																												</children>
																											</tablerow>
																										</children>
																									</tablebody>
																								</children>
																							</table>
																						</children>
																					</conditionbranch>
																				</children>
																			</condition>
																		</children>
																	</tablecell>
																	<tablecell>
																		<editorproperties/>
																		<properties valign="top" width="40%"/>
																		<styles/>
																		<children>
																			<table>
																				<editorproperties/>
																				<properties border="0" cellspacing="4" width="100%"/>
																				<styles/>
																				<children>
																					<tablebody>
																						<editorproperties/>
																						<properties/>
																						<styles/>
																						<children>
																							<tablerow>
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children>
																									<tablecell>
																										<editorproperties/>
																										<properties width="25%"/>
																										<styles/>
																										<children>
																											<text fixtext="Phone:">
																												<editorproperties/>
																												<properties/>
																												<styles font-weight="bold"/>
																												<children/>
																											</text>
																										</children>
																									</tablecell>
																									<tablecell>
																										<editorproperties/>
																										<properties width="75%"/>
																										<styles/>
																										<children>
																											<template match="n1:Phone">
																												<editorproperties elementstodisplay="1"/>
																												<properties/>
																												<styles/>
																												<children>
																													<content>
																														<editorproperties/>
																														<properties/>
																														<styles/>
																														<children/>
																														<addvalidations/>
																														<format datatype="string"/>
																													</content>
																												</children>
																												<addvalidations/>
																											</template>
																										</children>
																									</tablecell>
																								</children>
																							</tablerow>
																							<tablerow>
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children>
																									<tablecell>
																										<editorproperties/>
																										<properties width="25%"/>
																										<styles/>
																										<children>
																											<text fixtext="Fax:">
																												<editorproperties/>
																												<properties/>
																												<styles font-weight="bold"/>
																												<children/>
																											</text>
																										</children>
																									</tablecell>
																									<tablecell>
																										<editorproperties/>
																										<properties width="75%"/>
																										<styles/>
																										<children>
																											<template match="n1:Fax">
																												<editorproperties editable="1" markupmode="hide" adding="mandatory" autoaddname="1"/>
																												<properties/>
																												<styles/>
																												<children>
																													<content>
																														<editorproperties editable="1"/>
																														<properties/>
																														<styles/>
																														<children/>
																														<addvalidations/>
																														<format datatype="string"/>
																													</content>
																												</children>
																												<addvalidations/>
																											</template>
																										</children>
																									</tablecell>
																								</children>
																							</tablerow>
																							<tablerow>
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children>
																									<tablecell>
																										<editorproperties/>
																										<properties width="25%"/>
																										<styles/>
																										<children>
																											<text fixtext="E-mail:">
																												<editorproperties/>
																												<properties/>
																												<styles font-weight="bold"/>
																												<children/>
																											</text>
																										</children>
																									</tablecell>
																									<tablecell>
																										<editorproperties/>
																										<properties width="75%"/>
																										<styles/>
																										<children>
																											<template match="n1:EMail">
																												<editorproperties elementstodisplay="1"/>
																												<properties/>
																												<styles/>
																												<children>
																													<link>
																														<editorproperties/>
																														<properties/>
																														<styles/>
																														<children>
																															<content>
																																<editorproperties/>
																																<properties/>
																																<styles/>
																																<children/>
																																<addvalidations/>
																																<format datatype="string"/>
																															</content>
																														</children>
																														<target>
																															<fixtext value="mailto:"/>
																															<xpath value="."/>
																														</target>
																														<action>
																															<none/>
																														</action>
																														<bookmark/>
																														<hyperlink>
																															<fixtext value="mailto:"/>
																															<xpath value="."/>
																														</hyperlink>
																													</link>
																												</children>
																												<addvalidations/>
																											</template>
																										</children>
																									</tablecell>
																								</children>
																							</tablerow>
																						</children>
																					</tablebody>
																				</children>
																			</table>
																		</children>
																	</tablecell>
																</children>
															</tablerow>
														</children>
													</tablebody>
												</children>
											</table>
											<newline>
												<editorproperties/>
												<properties/>
												<styles/>
												<children/>
											</newline>
											<condition>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<conditionbranch xpath="n1:Address">
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="n1:Address">
																<editorproperties elementstodisplay="1"/>
																<properties/>
																<styles/>
																<children>
																	<template match="ipo:city">
																		<editorproperties elementstodisplay="1"/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</template>
																</children>
																<addvalidations/>
															</template>
														</children>
													</conditionbranch>
													<conditionbranch xpath="n1:Address_EU">
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<template match="n1:Address_EU">
																<editorproperties elementstodisplay="1"/>
																<properties/>
																<styles/>
																<children>
																	<template match="ipo:city">
																		<editorproperties elementstodisplay="1"/>
																		<properties/>
																		<styles/>
																		<children>
																			<content>
																				<editorproperties/>
																				<properties/>
																				<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
																				<children/>
																				<addvalidations/>
																				<format datatype="string"/>
																			</content>
																		</children>
																		<addvalidations/>
																	</template>
																</children>
																<addvalidations/>
															</template>
														</children>
													</conditionbranch>
												</children>
											</condition>
											<text fixtext=" Office Summary:">
												<editorproperties/>
												<properties/>
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
												<children/>
											</text>
											<text fixtext="  ">
												<editorproperties/>
												<properties/>
												<styles/>
												<children/>
											</text>
											<autocalc xpath="count(n1:Department)">
												<editorproperties/>
												<properties/>
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
												<children/>
												<addvalidations/>
												<format/>
											</autocalc>
											<text fixtext=" department">
												<editorproperties/>
												<properties/>
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
												<children/>
											</text>
											<condition>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<conditionbranch xpath="count(n1:Department) != 1">
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<text fixtext="s">
																<editorproperties/>
																<properties/>
																<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
																<children/>
															</text>
														</children>
													</conditionbranch>
												</children>
											</condition>
											<text fixtext=", ">
												<editorproperties/>
												<properties/>
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
												<children/>
											</text>
											<autocalc xpath="count(n1:Department/n1:Person)">
												<editorproperties/>
												<properties/>
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
												<children/>
												<addvalidations/>
												<format/>
											</autocalc>
											<text fixtext=" employee">
												<editorproperties/>
												<properties/>
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
												<children/>
											</text>
											<condition>
												<editorproperties/>
												<properties/>
												<styles/>
												<children>
													<conditionbranch xpath="count(n1:Department/n1:Person) != 1">
														<editorproperties/>
														<properties/>
														<styles/>
														<children>
															<text fixtext="s">
																<editorproperties/>
																<properties/>
																<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
																<children/>
															</text>
														</children>
													</conditionbranch>
												</children>
											</condition>
											<text fixtext=".">
												<editorproperties/>
												<properties/>
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
												<children/>
											</text>
											<template match="n1:Desc">
												<editorproperties elementstodisplay="1"/>
												<properties/>
												<styles/>
												<children>
													<template match="n1:para">
														<editorproperties elementstodisplay="1"/>
														<properties/>
														<styles/>
														<children>
															<paragraph paragraphtag="p">
																<editorproperties/>
																<properties/>
																<styles/>
																<children>
																	<content>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children/>
																		<addvalidations/>
																		<format/>
																	</content>
																</children>
															</paragraph>
														</children>
														<addvalidations/>
													</template>
												</children>
												<addvalidations/>
											</template>
											<template match="n1:Department">
												<editorproperties elementstodisplay="1"/>
												<properties/>
												<styles/>
												<children>
													<newline>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
													</newline>
													<template match="n1:Name">
														<editorproperties elementstodisplay="1"/>
														<properties/>
														<styles/>
														<children>
															<content>
																<editorproperties/>
																<properties/>
																<styles color="#D39658" font-family="Arial" font-weight="bold"/>
																<children/>
																<addvalidations/>
																<format datatype="string"/>
															</content>
														</children>
														<addvalidations/>
													</template>
													<text fixtext="  ">
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
													</text>
													<text fixtext="( ">
														<editorproperties/>
														<properties/>
														<styles color="#D39658" font-family="Arial" font-weight="bold"/>
														<children/>
													</text>
													<autocalc xpath="count(n1:Person)">
														<editorproperties/>
														<properties/>
														<styles color="#D39658" font-family="Arial" font-weight="bold"/>
														<children/>
														<addvalidations/>
														<format/>
													</autocalc>
													<text fixtext=" )">
														<editorproperties/>
														<properties/>
														<styles color="#D39658" font-family="Arial" font-weight="bold"/>
														<children/>
													</text>
													<newline>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
													</newline>
													<table>
														<editorproperties/>
														<properties border="1" cellpadding="3" cellspacing="0" width="100%"/>
														<styles/>
														<children>
															<tableheader>
																<editorproperties/>
																<properties/>
																<styles/>
																<children>
																	<tablerow>
																		<editorproperties/>
																		<properties bgcolor="#D2C8AE"/>
																		<styles/>
																		<children>
																			<tablecell>
																				<editorproperties/>
																				<properties align="center" bgcolor="#D2C8AE" rowspan="2" width="10%"/>
																				<styles/>
																				<children>
																					<text fixtext="First">
																						<editorproperties/>
																						<properties/>
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																						<children/>
																					</text>
																				</children>
																			</tablecell>
																			<tablecell>
																				<editorproperties/>
																				<properties align="center" bgcolor="#D2C8AE" rowspan="2" width="12%"/>
																				<styles/>
																				<children>
																					<text fixtext="Last">
																						<editorproperties/>
																						<properties/>
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																						<children/>
																					</text>
																				</children>
																			</tablecell>
																			<tablecell>
																				<editorproperties/>
																				<properties align="center" bgcolor="#D2C8AE" rowspan="2" width="16%"/>
																				<styles/>
																				<children>
																					<text fixtext="Title">
																						<editorproperties/>
																						<properties/>
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																						<children/>
																					</text>
																				</children>
																			</tablecell>
																			<tablecell>
																				<editorproperties/>
																				<properties align="center" bgcolor="#D2C8AE" rowspan="2" width="5%"/>
																				<styles/>
																				<children>
																					<text fixtext="Ext">
																						<editorproperties/>
																						<properties/>
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																						<children/>
																					</text>
																				</children>
																			</tablecell>
																			<tablecell>
																				<editorproperties/>
																				<properties align="center" bgcolor="#D2C8AE" rowspan="2" width="23%"/>
																				<styles/>
																				<children>
																					<text fixtext="EMail">
																						<editorproperties/>
																						<properties/>
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																						<children/>
																					</text>
																				</children>
																			</tablecell>
																			<tablecell>
																				<editorproperties/>
																				<properties align="center" bgcolor="#D2C8AE" rowspan="2" width="10%"/>
																				<styles/>
																				<children>
																					<text fixtext="Shares">
																						<editorproperties/>
																						<properties/>
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																						<children/>
																					</text>
																				</children>
																			</tablecell>
																			<tablecell>
																				<editorproperties/>
																				<properties align="center" colspan="3" width="8%"/>
																				<styles/>
																				<children>
																					<text fixtext="Leave">
																						<editorproperties/>
																						<properties/>
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																						<children/>
																					</text>
																				</children>
																			</tablecell>
																		</children>
																	</tablerow>
																	<tablerow>
																		<editorproperties/>
																		<properties/>
																		<styles/>
																		<children>
																			<tablecell>
																				<editorproperties/>
																				<properties align="center" bgcolor="#D2C8AE" width="8%"/>
																				<styles/>
																				<children>
																					<text fixtext="Total">
																						<editorproperties/>
																						<properties/>
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																						<children/>
																					</text>
																				</children>
																			</tablecell>
																			<tablecell>
																				<editorproperties/>
																				<properties align="center" bgcolor="#D2C8AE" width="8%"/>
																				<styles/>
																				<children>
																					<text fixtext="Used">
																						<editorproperties/>
																						<properties/>
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																						<children/>
																					</text>
																				</children>
																			</tablecell>
																			<tablecell>
																				<editorproperties/>
																				<properties align="center" bgcolor="#D2C8AE" width="8%"/>
																				<styles/>
																				<children>
																					<text fixtext="Left">
																						<editorproperties/>
																						<properties/>
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																						<children/>
																					</text>
																				</children>
																			</tablecell>
																		</children>
																	</tablerow>
																</children>
															</tableheader>
															<tablefooter>
																<editorproperties/>
																<properties/>
																<styles/>
																<children>
																	<tablerow>
																		<editorproperties/>
																		<properties bgcolor="#F2F0E6"/>
																		<styles/>
																		<children>
																			<tablecell>
																				<editorproperties/>
																				<properties align="left" colspan="5" valign="top" width="23%"/>
																				<styles/>
																				<children>
																					<text fixtext="Employees:  ">
																						<editorproperties/>
																						<properties/>
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																						<children/>
																					</text>
																					<autocalc xpath="count(  n1:Person  )">
																						<editorproperties/>
																						<properties/>
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																						<children/>
																						<addvalidations/>
																						<format/>
																					</autocalc>
																					<text fixtext=" ">
																						<editorproperties/>
																						<properties/>
																						<styles font-size="8pt"/>
																						<children/>
																					</text>
																					<text fixtext="(">
																						<editorproperties/>
																						<properties/>
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																						<children/>
																					</text>
																					<autocalc xpath="round ((count(  n1:Person  ) ) div ( count( ../n1:Department/ n1:Person  ) ) * 100)">
																						<editorproperties/>
																						<properties/>
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																						<children/>
																						<addvalidations/>
																						<format/>
																					</autocalc>
																					<text fixtext="% of Office, ">
																						<editorproperties/>
																						<properties/>
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																						<children/>
																					</text>
																					<autocalc xpath="round ((count(  n1:Person  ) ) div ( count( ../../n1:Office/n1:Department/ n1:Person  ) ) * 100)">
																						<editorproperties/>
																						<properties/>
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																						<children/>
																						<addvalidations/>
																						<format/>
																					</autocalc>
																					<text fixtext="% of Company)">
																						<editorproperties/>
																						<properties/>
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																						<children/>
																					</text>
																				</children>
																			</tablecell>
																			<tablecell>
																				<editorproperties/>
																				<properties align="left" colspan="4" width="10%"/>
																				<styles/>
																				<children>
																					<text fixtext="Shares: ">
																						<editorproperties/>
																						<properties/>
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																						<children/>
																					</text>
																					<autocalc xpath="sum(  n1:Person/n1:Shares  )">
																						<editorproperties/>
																						<properties/>
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																						<children/>
																						<addvalidations/>
																						<format/>
																					</autocalc>
																					<text fixtext=" ">
																						<editorproperties/>
																						<properties/>
																						<styles font-size="8pt"/>
																						<children/>
																					</text>
																					<text fixtext="(">
																						<editorproperties/>
																						<properties/>
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																						<children/>
																					</text>
																					<autocalc xpath="round((sum(  n1:Person/n1:Shares  ) ) div (sum(../n1:Department/ n1:Person/n1:Shares ) ) * 100)">
																						<editorproperties/>
																						<properties/>
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																						<children/>
																						<addvalidations/>
																						<format/>
																					</autocalc>
																					<text fixtext="% of Office, ">
																						<editorproperties/>
																						<properties/>
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																						<children/>
																					</text>
																					<autocalc xpath="round((sum(  n1:Person/n1:Shares  ) ) div (sum(../../n1:Office/n1:Department/ n1:Person/n1:Shares  )) * 100)">
																						<editorproperties/>
																						<properties/>
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																						<children/>
																						<addvalidations/>
																						<format/>
																					</autocalc>
																					<text fixtext="% of Company)">
																						<editorproperties/>
																						<properties/>
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																						<children/>
																					</text>
																				</children>
																			</tablecell>
																		</children>
																	</tablerow>
																	<tablerow>
																		<editorproperties/>
																		<properties bgcolor="#F2F0E6"/>
																		<styles/>
																		<children>
																			<tablecell>
																				<editorproperties/>
																				<properties align="left" colspan="9" width="23%"/>
																				<styles/>
																				<children>
																					<text fixtext="Non-Shareholders: ">
																						<editorproperties/>
																						<properties/>
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																						<children/>
																					</text>
																					<text fixtext=" ">
																						<editorproperties/>
																						<properties/>
																						<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																						<children/>
																					</text>
																					<template match="n1:Person">
																						<editorproperties elementstodisplay="1"/>
																						<properties/>
																						<styles/>
																						<children>
																							<condition>
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children>
																									<conditionbranch xpath="n1:Shares &lt;= 0 or not (n1:Shares)">
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children>
																											<template match="n1:First">
																												<editorproperties elementstodisplay="1"/>
																												<properties/>
																												<styles/>
																												<children>
																													<content>
																														<editorproperties/>
																														<properties/>
																														<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																														<children/>
																														<addvalidations/>
																														<format/>
																													</content>
																												</children>
																												<addvalidations/>
																											</template>
																											<text fixtext=" ">
																												<editorproperties/>
																												<properties/>
																												<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																												<children/>
																											</text>
																											<template match="n1:Last">
																												<editorproperties elementstodisplay="1"/>
																												<properties/>
																												<styles/>
																												<children>
																													<content>
																														<editorproperties/>
																														<properties/>
																														<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																														<children/>
																														<addvalidations/>
																														<format datatype="string"/>
																													</content>
																												</children>
																												<addvalidations/>
																											</template>
																											<condition>
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children>
																													<conditionbranch xpath="following-sibling::n1:Person[n1:Shares&lt;=0 or not(n1:Shares)]">
																														<editorproperties/>
																														<properties/>
																														<styles/>
																														<children>
																															<text fixtext=", ">
																																<editorproperties/>
																																<properties/>
																																<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																																<children/>
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
																						<addvalidations/>
																					</template>
																					<condition>
																						<editorproperties/>
																						<properties/>
																						<styles/>
																						<children>
																							<conditionbranch xpath="count(  n1:Person  ) = count(  n1:Person [n1:Shares&gt;0] )">
																								<editorproperties/>
																								<properties/>
																								<styles/>
																								<children>
																									<text fixtext="None">
																										<editorproperties/>
																										<properties/>
																										<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																										<children/>
																									</text>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																					<text fixtext=".">
																						<editorproperties/>
																						<properties/>
																						<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																						<children/>
																					</text>
																				</children>
																			</tablecell>
																		</children>
																	</tablerow>
																</children>
															</tablefooter>
															<tablebody>
																<editorproperties/>
																<properties/>
																<styles/>
																<children>
																	<template match="n1:Person">
																		<editorproperties elementstodisplay="1"/>
																		<properties/>
																		<styles/>
																		<children>
																			<tablerow>
																				<editorproperties/>
																				<properties/>
																				<styles/>
																				<children>
																					<tablecell>
																						<editorproperties/>
																						<properties width="10%"/>
																						<styles/>
																						<children>
																							<template match="n1:First">
																								<editorproperties elementstodisplay="1"/>
																								<properties/>
																								<styles/>
																								<children>
																									<condition>
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children>
																											<conditionbranch xpath="../n1:Shares &gt; 0">
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children>
																													<content>
																														<editorproperties/>
																														<properties/>
																														<styles font-size="10pt" font-weight="bold"/>
																														<children/>
																														<addvalidations/>
																														<format/>
																													</content>
																												</children>
																											</conditionbranch>
																											<conditionbranch>
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children>
																													<content>
																														<editorproperties/>
																														<properties/>
																														<styles font-size="10pt"/>
																														<children/>
																														<addvalidations/>
																														<format/>
																													</content>
																												</children>
																											</conditionbranch>
																										</children>
																									</condition>
																								</children>
																								<addvalidations/>
																							</template>
																						</children>
																					</tablecell>
																					<tablecell>
																						<editorproperties/>
																						<properties width="12%"/>
																						<styles/>
																						<children>
																							<template match="n1:Last">
																								<editorproperties elementstodisplay="1"/>
																								<properties/>
																								<styles/>
																								<children>
																									<condition>
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children>
																											<conditionbranch xpath="../n1:Shares &gt; 0">
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children>
																													<content>
																														<editorproperties/>
																														<properties/>
																														<styles font-size="10pt" font-weight="bold"/>
																														<children/>
																														<addvalidations/>
																														<format datatype="string"/>
																													</content>
																												</children>
																											</conditionbranch>
																											<conditionbranch>
																												<editorproperties/>
																												<properties/>
																												<styles/>
																												<children>
																													<content>
																														<editorproperties/>
																														<properties/>
																														<styles font-size="10pt"/>
																														<children/>
																														<addvalidations/>
																														<format datatype="string"/>
																													</content>
																												</children>
																											</conditionbranch>
																										</children>
																									</condition>
																								</children>
																								<addvalidations/>
																							</template>
																						</children>
																					</tablecell>
																					<tablecell>
																						<editorproperties/>
																						<properties width="16%"/>
																						<styles/>
																						<children>
																							<template match="n1:Title">
																								<editorproperties editable="1" markupmode="hide" adding="mandatory" autoaddname="1"/>
																								<properties/>
																								<styles/>
																								<children>
																									<content>
																										<editorproperties/>
																										<properties/>
																										<styles font-size="10pt"/>
																										<children/>
																										<addvalidations/>
																										<format datatype="string"/>
																									</content>
																								</children>
																								<addvalidations/>
																							</template>
																						</children>
																					</tablecell>
																					<tablecell>
																						<editorproperties/>
																						<properties align="center" width="5%"/>
																						<styles/>
																						<children>
																							<template match="n1:PhoneExt">
																								<editorproperties elementstodisplay="1"/>
																								<properties/>
																								<styles/>
																								<children>
																									<content>
																										<editorproperties editable="1"/>
																										<properties/>
																										<styles font-size="10pt"/>
																										<children/>
																										<addvalidations>
																											<addvalidation usermsg="Telephone extensions must be 3 digits long." xpath="string-length(.) = 3"/>
																										</addvalidations>
																										<format datatype="int"/>
																									</content>
																								</children>
																								<addvalidations/>
																							</template>
																						</children>
																					</tablecell>
																					<tablecell>
																						<editorproperties/>
																						<properties width="23%"/>
																						<styles/>
																						<children>
																							<template match="n1:EMail">
																								<editorproperties elementstodisplay="1"/>
																								<properties/>
																								<styles/>
																								<children>
																									<link>
																										<editorproperties/>
																										<properties/>
																										<styles/>
																										<children>
																											<content>
																												<editorproperties/>
																												<properties/>
																												<styles font-size="10pt"/>
																												<children/>
																												<addvalidations/>
																												<format datatype="string"/>
																											</content>
																										</children>
																										<target>
																											<fixtext value="mailto:"/>
																											<xpath value="."/>
																										</target>
																										<action>
																											<none/>
																										</action>
																										<bookmark/>
																										<hyperlink>
																											<fixtext value="mailto:"/>
																											<xpath value="."/>
																										</hyperlink>
																									</link>
																								</children>
																								<addvalidations/>
																							</template>
																						</children>
																					</tablecell>
																					<tablecell>
																						<editorproperties/>
																						<properties align="center" width="10%"/>
																						<styles/>
																						<children>
																							<template match="n1:Shares">
																								<editorproperties elementstodisplay="1"/>
																								<properties/>
																								<styles/>
																								<children>
																									<content>
																										<editorproperties/>
																										<properties/>
																										<styles font-size="10pt"/>
																										<children/>
																										<addvalidations/>
																										<format datatype="integer"/>
																									</content>
																								</children>
																								<addvalidations/>
																							</template>
																						</children>
																					</tablecell>
																					<tablecell>
																						<editorproperties/>
																						<properties align="center" width="8%"/>
																						<styles/>
																						<children>
																							<template match="n1:LeaveTotal">
																								<editorproperties elementstodisplay="1"/>
																								<properties/>
																								<styles/>
																								<children>
																									<content>
																										<editorproperties/>
																										<properties/>
																										<styles font-size="10pt"/>
																										<children/>
																										<addvalidations/>
																										<format datatype="decimal"/>
																									</content>
																								</children>
																								<addvalidations/>
																							</template>
																						</children>
																					</tablecell>
																					<tablecell>
																						<editorproperties/>
																						<properties align="center" width="8%"/>
																						<styles/>
																						<children>
																							<template match="n1:LeaveUsed">
																								<editorproperties elementstodisplay="1"/>
																								<properties/>
																								<styles/>
																								<children>
																									<content>
																										<editorproperties/>
																										<properties/>
																										<styles font-size="10pt"/>
																										<children/>
																										<addvalidations/>
																										<format datatype="decimal"/>
																									</content>
																								</children>
																								<addvalidations/>
																							</template>
																						</children>
																					</tablecell>
																					<tablecell>
																						<editorproperties/>
																						<properties align="center" width="8%"/>
																						<styles/>
																						<children>
																							<autocalc xpath="n1:LeaveTotal - n1:LeaveUsed" update="n1:LeaveLeft">
																								<editorproperties/>
																								<properties/>
																								<styles font-size="10pt"/>
																								<children/>
																								<addvalidations/>
																								<format/>
																							</autocalc>
																						</children>
																					</tablecell>
																				</children>
																			</tablerow>
																		</children>
																		<addvalidations/>
																	</template>
																</children>
															</tablebody>
														</children>
													</table>
													<newline>
														<editorproperties/>
														<properties/>
														<styles/>
														<children/>
													</newline>
												</children>
												<addvalidations/>
											</template>
										</children>
										<addvalidations/>
									</template>
									<newline>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</newline>
									<line>
										<editorproperties/>
										<properties color="#004080" size="2"/>
										<styles/>
										<children/>
									</line>
									<newline>
										<editorproperties/>
										<properties/>
										<styles/>
										<children/>
									</newline>
									<link>
										<editorproperties/>
										<properties/>
										<styles/>
										<children>
											<text fixtext="Go to top">
												<editorproperties/>
												<properties/>
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
												<children/>
											</text>
										</children>
										<target>
											<fixtext value="#top_of_page"/>
										</target>
										<action>
											<none/>
										</action>
										<bookmark/>
										<hyperlink>
											<fixtext value="#top_of_page"/>
										</hyperlink>
									</link>
								</children>
								<addvalidations/>
							</template>
						</children>
						<addvalidations/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="n1:bold">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="n1:bold">
						<editorproperties elementstodisplay="1"/>
						<properties/>
						<styles/>
						<children>
							<content>
								<editorproperties/>
								<properties/>
								<styles font-weight="bold"/>
								<children/>
								<addvalidations/>
								<format/>
							</content>
						</children>
						<addvalidations/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="n1:italic">
				<editorproperties/>
				<properties/>
				<styles/>
				<children>
					<template match="n1:italic">
						<editorproperties elementstodisplay="1"/>
						<properties/>
						<styles/>
						<children>
							<content>
								<editorproperties/>
								<properties/>
								<styles font-style="italic"/>
								<children/>
								<addvalidations/>
								<format/>
							</content>
						</children>
						<addvalidations/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</parts>
	<pagelayout>
		<editorproperties/>
		<properties pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="1" paperheight="11in" papermarginbottom="0.79in" papermarginleft="0.6in" papermarginright="0.6in" papermargintop="0.79in" paperwidth="8.5in"/>
		<styles/>
		<children/>
	</pagelayout>
</structure>
