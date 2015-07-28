<?xml version="1.0" encoding="UTF-8"?>
<structure version="6" cssmode="strict" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="UTF-8" encodingpdf="UTF-8">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="ipo" uri="http://www.altova.com/IPO"/>
			<nspair prefix="n1" uri="http://www.xmlspy.com/schemas/orgchart"/>
			<nspair prefix="ts" uri="http://www.xmlspy.com/schemas/textstate"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="$XML" main="1" schemafile="OrgChart.xsd" workingxmlfile="OrgChart.xml" templatexmlfile="OrgChart.xml">
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
			<globaltemplate match="/" matchtype="named" parttype="main">
				<children>
					<template match="$XML" matchtype="schemasource">
						<editorproperties elementstodisplay="1"/>
						<children>
							<template match="n1:OrgChart" matchtype="schemagraphitem">
								<editorproperties elementstodisplay="1"/>
								<children>
									<template match="n1:CompanyLogo" matchtype="schemagraphitem">
										<editorproperties editable="1" markupmode="hide" adding="mandatory" autoaddname="1"/>
										<children>
											<paragraph>
												<styles border-bottom-color="#0588BA" border-bottom-style="solid" border-bottom-width="medium" border-width="4pt" padding-bottom="10px" padding-left="10px"/>
												<children>
													<template match="@href" matchtype="schemagraphitem">
														<editorproperties editable="1" markupmode="hide" adding="mandatory" autoaddname="1"/>
														<children>
															<link>
																<children>
																	<image>
																		<properties border="0"/>
																		<styles height="76px" width="153px"/>
																		<target>
																			<xpath value="."/>
																		</target>
																		<imagesource>
																			<xpath value="."/>
																		</imagesource>
																	</image>
																</children>
																<action>
																	<none/>
																</action>
																<bookmark/>
																<hyperlink>
																	<fixtext value="http://www.nanonull.com/"/>
																</hyperlink>
															</link>
														</children>
													</template>
												</children>
											</paragraph>
										</children>
									</template>
									<newline/>
									<template match="n1:Name" matchtype="schemagraphitem">
										<editorproperties elementstodisplay="1"/>
										<children>
											<content>
												<styles color="#0588BA" font-family="Arial" font-size="20pt" font-weight="bold"/>
												<format datatype="string"/>
											</content>
										</children>
									</template>
									<newline/>
									<newline/>
									<toc name="toc">
										<children>
											<text fixtext="Quick Finder">
												<styles font-family="Arial" font-size="14pt" font-weight="bold"/>
											</text>
											<newline/>
											<reflevel>
												<children>
													<newline/>
													<ref name="toc" createhyperlink="1">
														<children>
															<field type="ref-entrytext">
																<styles font-family="Arial" font-size="12pt" font-weight="bold"/>
															</field>
														</children>
													</ref>
													<newline/>
													<table>
														<properties cellspacing="0" width="100%"/>
														<styles margin-top="2pt"/>
														<children>
															<tablebody>
																<children>
																	<tablerow>
																		<children>
																			<tablecell>
																				<properties width="50%"/>
																				<children>
																					<text fixtext="Departments">
																						<styles font-size="10pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tablecell>
																			<tablecell>
																				<properties width="50%"/>
																				<children>
																					<text fixtext="Persons">
																						<styles font-size="10pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tablecell>
																		</children>
																	</tablerow>
																</children>
															</tablebody>
														</children>
													</table>
													<reflevel>
														<children>
															<table>
																<properties cellspacing="0" width="100%"/>
																<styles line-height="12pt"/>
																<children>
																	<tablebody>
																		<children>
																			<tablerow>
																				<properties _xbgcolor="if ( position() mod 2 ) then &quot;antiquewhite&quot; else &quot;navajowhite&quot;"/>
																				<children>
																					<tablecell>
																						<properties valign="top" width="50%"/>
																						<children>
																							<ref name="toc" createhyperlink="1">
																								<children>
																									<num-lvl format="A.1" omitlevels="1">
																										<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																									</num-lvl>
																									<text fixtext=". ">
																										<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																									</text>
																									<field type="ref-entrytext">
																										<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																									</field>
																								</children>
																							</ref>
																						</children>
																					</tablecell>
																					<tablecell>
																						<properties valign="top" width="50%"/>
																						<children>
																							<reflevel>
																								<children>
																									<table>
																										<properties cellpadding="0" cellspacing="0"/>
																										<children>
																											<tablebody>
																												<children>
																													<tablerow>
																														<children>
																															<tablecell>
																																<properties valign="top"/>
																																<children>
																																	<ref name="toc" createhyperlink="1">
																																		<children>
																																			<num-lvl format="A.1" omitlevels="1">
																																				<styles font-family="Arial" font-size="8pt"/>
																																			</num-lvl>
																																			<text fixtext=" ">
																																				<styles font-family="Arial" font-size="8pt"/>
																																			</text>
																																			<field type="ref-entrytext">
																																				<styles font-family="Arial" font-size="8pt"/>
																																			</field>
																																		</children>
																																	</ref>
																																</children>
																															</tablecell>
																														</children>
																													</tablerow>
																												</children>
																											</tablebody>
																										</children>
																									</table>
																								</children>
																							</reflevel>
																						</children>
																					</tablecell>
																				</children>
																			</tablerow>
																		</children>
																	</tablebody>
																</children>
															</table>
														</children>
													</reflevel>
												</children>
											</reflevel>
										</children>
									</toc>
									<newline/>
									<template match="n1:Office" matchtype="schemagraphitem" levelflag="1">
										<editorproperties adding="no" elementstodisplay="1"/>
										<children>
											<condition>
												<children>
													<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos;">
														<children>
															<paragraph>
																<styles border-top-color="#0588ba" border-top-style="solid" border-top-width="2pt"/>
																<children>
																	<newline/>
																	<marker xpath="." name="toc">
																		<children>
																			<template match="n1:Name" matchtype="schemagraphitem">
																				<editorproperties adding="no" elementstodisplay="1"/>
																				<children>
																					<content>
																						<styles color="#707070" font-family="Arial" font-size="15pt" font-weight="bold"/>
																						<format datatype="string"/>
																					</content>
																				</children>
																			</template>
																		</children>
																	</marker>
																	<newline/>
																	<newline/>
																	<text fixtext="Location: ">
																		<styles color="#808080" font-family="Arial" font-size="small" font-weight="bold"/>
																	</text>
																	<condition>
																		<children>
																			<conditionbranch xpath="not(n1:Address or  n1:Address_EU)">
																				<children>
																					<template match="n1:Location" matchtype="schemagraphitem">
																						<editorproperties editable="1" markupmode="hide" adding="no" autoaddname="1"/>
																						<children>
																							<combobox>
																								<children>
																									<content>
																										<format datatype="string"/>
																									</content>
																								</children>
																								<selectoption description="US" value="US"/>
																								<selectoption description="EU" value="EU"/>
																							</combobox>
																						</children>
																					</template>
																				</children>
																			</conditionbranch>
																			<conditionbranch>
																				<children>
																					<template match="n1:Location" matchtype="schemagraphitem">
																						<editorproperties editable="0" markupmode="hide" adding="no" autoaddname="1"/>
																						<children>
																							<content>
																								<styles color="#808080" font-weight="bold"/>
																								<format datatype="string"/>
																							</content>
																						</children>
																					</template>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																</children>
															</paragraph>
														</children>
													</conditionbranch>
													<conditionbranch xpath="$SV_OutputFormat = &apos;HTML&apos;">
														<children>
															<paragraph>
																<styles border-top-color="#0588ba" border-top-style="solid" border-top-width="2pt"/>
																<children>
																	<newline/>
																	<marker xpath="." name="toc">
																		<children>
																			<template match="n1:Name" matchtype="schemagraphitem">
																				<editorproperties adding="no" elementstodisplay="1"/>
																				<children>
																					<content>
																						<styles color="#707070" font-family="Arial" font-size="15pt" font-weight="bold"/>
																						<format datatype="string"/>
																					</content>
																				</children>
																			</template>
																		</children>
																	</marker>
																	<newline/>
																	<newline/>
																	<text fixtext="Location: ">
																		<styles color="#808080" font-family="Arial" font-size="small" font-weight="bold"/>
																	</text>
																	<condition>
																		<children>
																			<conditionbranch xpath="not(n1:Address or  n1:Address_EU)">
																				<children>
																					<template match="n1:Location" matchtype="schemagraphitem">
																						<editorproperties editable="1" markupmode="hide" adding="no" autoaddname="1"/>
																						<children>
																							<combobox>
																								<children>
																									<content>
																										<format datatype="string"/>
																									</content>
																								</children>
																								<selectoption description="US" value="US"/>
																								<selectoption description="EU" value="EU"/>
																							</combobox>
																						</children>
																					</template>
																				</children>
																			</conditionbranch>
																			<conditionbranch>
																				<children>
																					<template match="n1:Location" matchtype="schemagraphitem">
																						<editorproperties editable="0" markupmode="hide" adding="no" autoaddname="1"/>
																						<children>
																							<content>
																								<styles color="#808080" font-weight="bold"/>
																								<format datatype="string"/>
																							</content>
																						</children>
																					</template>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																</children>
															</paragraph>
														</children>
													</conditionbranch>
													<conditionbranch xpath="$SV_OutputFormat = &apos;RTF&apos; or $SV_OutputFormat = &apos;Word2007&apos;">
														<children>
															<newline break="page"/>
															<paragraph>
																<children>
																	<newline/>
																	<marker xpath="." name="toc">
																		<children>
																			<template match="n1:Name" matchtype="schemagraphitem">
																				<editorproperties adding="no" elementstodisplay="1"/>
																				<children>
																					<content>
																						<styles color="#707070" font-family="Arial" font-size="15pt" font-weight="bold"/>
																						<format datatype="string"/>
																					</content>
																				</children>
																			</template>
																		</children>
																	</marker>
																	<newline/>
																	<newline/>
																	<text fixtext="Location: ">
																		<styles color="#808080" font-family="Arial" font-size="small" font-weight="bold"/>
																	</text>
																	<condition>
																		<children>
																			<conditionbranch xpath="not(n1:Address or  n1:Address_EU)">
																				<children>
																					<template match="n1:Location" matchtype="schemagraphitem">
																						<editorproperties editable="1" markupmode="hide" adding="no" autoaddname="1"/>
																						<children>
																							<combobox>
																								<children>
																									<content>
																										<format datatype="string"/>
																									</content>
																								</children>
																								<selectoption description="US" value="US"/>
																								<selectoption description="EU" value="EU"/>
																							</combobox>
																						</children>
																					</template>
																				</children>
																			</conditionbranch>
																			<conditionbranch>
																				<children>
																					<template match="n1:Location" matchtype="schemagraphitem">
																						<editorproperties editable="0" markupmode="hide" adding="no" autoaddname="1"/>
																						<children>
																							<content>
																								<styles color="#808080" font-weight="bold"/>
																								<format datatype="string"/>
																							</content>
																						</children>
																					</template>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																</children>
															</paragraph>
														</children>
													</conditionbranch>
													<conditionbranch xpath="$SV_OutputFormat = &apos;PDF&apos;">
														<children>
															<paragraph>
																<children>
																	<newline/>
																	<marker xpath="." name="toc">
																		<children>
																			<template match="n1:Name" matchtype="schemagraphitem">
																				<editorproperties adding="no" elementstodisplay="1"/>
																				<children>
																					<content>
																						<styles color="#707070" font-family="Arial" font-size="15pt" font-weight="bold"/>
																						<format datatype="string"/>
																					</content>
																				</children>
																			</template>
																		</children>
																	</marker>
																	<newline/>
																	<newline/>
																	<text fixtext="Location: ">
																		<styles color="#808080" font-family="Arial" font-size="small" font-weight="bold"/>
																	</text>
																	<condition>
																		<children>
																			<conditionbranch xpath="not(n1:Address or  n1:Address_EU)">
																				<children>
																					<template match="n1:Location" matchtype="schemagraphitem">
																						<editorproperties editable="1" markupmode="hide" adding="no" autoaddname="1"/>
																						<children>
																							<combobox>
																								<children>
																									<content>
																										<format datatype="string"/>
																									</content>
																								</children>
																								<selectoption description="US" value="US"/>
																								<selectoption description="EU" value="EU"/>
																							</combobox>
																						</children>
																					</template>
																				</children>
																			</conditionbranch>
																			<conditionbranch>
																				<children>
																					<template match="n1:Location" matchtype="schemagraphitem">
																						<editorproperties editable="0" markupmode="hide" adding="no" autoaddname="1"/>
																						<children>
																							<content>
																								<styles color="#808080" font-weight="bold"/>
																								<format datatype="string"/>
																							</content>
																						</children>
																					</template>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																</children>
															</paragraph>
														</children>
													</conditionbranch>
												</children>
											</condition>
											<table>
												<properties border="1" cellspacing="0" width="100%"/>
												<children>
													<tablebody>
														<children>
															<tablerow>
																<children>
																	<tablecell>
																		<properties valign="top" width="60%"/>
																		<children>
																			<condition>
																				<children>
																					<conditionbranch xpath="n1:Location =&quot;US&quot;">
																						<children>
																							<template match="n1:Address" matchtype="schemagraphitem">
																								<editorproperties adding="no" elementstodisplay="1"/>
																								<children>
																									<table>
																										<properties border="0" cellspacing="4px" width="100%"/>
																										<children>
																											<tablebody>
																												<children>
																													<tablerow>
																														<children>
																															<tablecell>
																																<properties width="30%"/>
																																<children>
																																	<text fixtext="Street: ">
																																		<styles font-weight="bold"/>
																																	</text>
																																</children>
																															</tablecell>
																															<tablecell>
																																<properties width="70%"/>
																																<children>
																																	<template match="ipo:street" matchtype="schemagraphitem">
																																		<editorproperties adding="no" elementstodisplay="1"/>
																																		<children>
																																			<content>
																																				<format datatype="string"/>
																																			</content>
																																		</children>
																																	</template>
																																</children>
																															</tablecell>
																														</children>
																													</tablerow>
																													<tablerow>
																														<children>
																															<tablecell>
																																<properties width="30%"/>
																																<children>
																																	<text fixtext="City:">
																																		<styles font-weight="bold"/>
																																	</text>
																																</children>
																															</tablecell>
																															<tablecell>
																																<properties width="70%"/>
																																<children>
																																	<template match="ipo:city" matchtype="schemagraphitem">
																																		<editorproperties adding="no" elementstodisplay="1"/>
																																		<children>
																																			<content>
																																				<format datatype="string"/>
																																			</content>
																																		</children>
																																	</template>
																																</children>
																															</tablecell>
																														</children>
																													</tablerow>
																													<tablerow>
																														<children>
																															<tablecell>
																																<properties width="30%"/>
																																<children>
																																	<text fixtext="State &amp; Zip:">
																																		<styles font-weight="bold"/>
																																	</text>
																																</children>
																															</tablecell>
																															<tablecell>
																																<properties width="70%"/>
																																<children>
																																	<template match="ipo:state" matchtype="schemagraphitem">
																																		<editorproperties adding="no" elementstodisplay="1"/>
																																		<children>
																																			<combobox enumeration="1">
																																				<children>
																																					<content>
																																						<format datatype="string"/>
																																					</content>
																																				</children>
																																			</combobox>
																																		</children>
																																	</template>
																																	<text fixtext=" "/>
																																	<template match="ipo:zip" matchtype="schemagraphitem">
																																		<editorproperties adding="no" elementstodisplay="1"/>
																																		<children>
																																			<editfield>
																																				<children>
																																					<content>
																																						<format datatype="positiveInteger"/>
																																					</content>
																																				</children>
																																			</editfield>
																																		</children>
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
																							</template>
																						</children>
																					</conditionbranch>
																					<conditionbranch xpath="n1:Location =&quot;EU&quot;">
																						<children>
																							<template match="n1:Address_EU" matchtype="schemagraphitem">
																								<editorproperties adding="no" elementstodisplay="1"/>
																								<children>
																									<table>
																										<properties border="0" cellspacing="4px" width="100%"/>
																										<children>
																											<tablebody>
																												<children>
																													<tablerow>
																														<children>
																															<tablecell>
																																<properties width="30%"/>
																																<children>
																																	<text fixtext="Street:">
																																		<styles font-weight="bold"/>
																																	</text>
																																</children>
																															</tablecell>
																															<tablecell>
																																<properties width="70%"/>
																																<children>
																																	<template match="ipo:street" matchtype="schemagraphitem">
																																		<editorproperties adding="no" elementstodisplay="1"/>
																																		<children>
																																			<editfield>
																																				<children>
																																					<content>
																																						<format datatype="string"/>
																																					</content>
																																				</children>
																																			</editfield>
																																		</children>
																																	</template>
																																</children>
																															</tablecell>
																														</children>
																													</tablerow>
																													<tablerow>
																														<children>
																															<tablecell>
																																<properties width="30%"/>
																																<children>
																																	<text fixtext="City:">
																																		<styles font-weight="bold"/>
																																	</text>
																																</children>
																															</tablecell>
																															<tablecell>
																																<properties width="70%"/>
																																<children>
																																	<template match="ipo:city" matchtype="schemagraphitem">
																																		<editorproperties adding="no" elementstodisplay="1"/>
																																		<children>
																																			<editfield>
																																				<children>
																																					<content>
																																						<format datatype="string"/>
																																					</content>
																																				</children>
																																			</editfield>
																																		</children>
																																	</template>
																																</children>
																															</tablecell>
																														</children>
																													</tablerow>
																													<tablerow>
																														<children>
																															<tablecell>
																																<properties width="30%"/>
																																<children>
																																	<text fixtext="Post Code:">
																																		<styles font-weight="bold"/>
																																	</text>
																																</children>
																															</tablecell>
																															<tablecell>
																																<properties width="70%"/>
																																<children>
																																	<template match="ipo:postcode" matchtype="schemagraphitem">
																																		<editorproperties adding="no" elementstodisplay="1"/>
																																		<children>
																																			<editfield>
																																				<children>
																																					<content>
																																						<format datatype="string"/>
																																					</content>
																																				</children>
																																			</editfield>
																																		</children>
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
																							</template>
																						</children>
																					</conditionbranch>
																				</children>
																			</condition>
																		</children>
																	</tablecell>
																	<tablecell>
																		<properties valign="top" width="40%"/>
																		<children>
																			<table>
																				<properties border="0" cellspacing="4" width="100%"/>
																				<children>
																					<tablebody>
																						<children>
																							<tablerow>
																								<children>
																									<tablecell>
																										<properties width="25%"/>
																										<children>
																											<text fixtext="Phone:">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</tablecell>
																									<tablecell>
																										<properties width="75%"/>
																										<children>
																											<template match="n1:Phone" matchtype="schemagraphitem">
																												<editorproperties adding="no" elementstodisplay="1"/>
																												<children>
																													<content>
																														<format datatype="string"/>
																													</content>
																												</children>
																											</template>
																										</children>
																									</tablecell>
																								</children>
																							</tablerow>
																							<tablerow>
																								<children>
																									<tablecell>
																										<properties width="25%"/>
																										<children>
																											<text fixtext="Fax:">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</tablecell>
																									<tablecell>
																										<properties width="75%"/>
																										<children>
																											<template match="n1:Fax" matchtype="schemagraphitem">
																												<editorproperties editable="1" markupmode="hide" adding="no" autoaddname="1"/>
																												<children>
																													<content>
																														<editorproperties editable="1"/>
																														<format datatype="string"/>
																													</content>
																												</children>
																											</template>
																										</children>
																									</tablecell>
																								</children>
																							</tablerow>
																							<tablerow>
																								<children>
																									<tablecell>
																										<properties width="25%"/>
																										<children>
																											<text fixtext="E-mail:">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</tablecell>
																									<tablecell>
																										<properties width="75%"/>
																										<children>
																											<template match="n1:EMail" matchtype="schemagraphitem">
																												<editorproperties adding="no" elementstodisplay="1"/>
																												<children>
																													<link>
																														<children>
																															<content>
																																<format datatype="string"/>
																															</content>
																														</children>
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
											<newline/>
											<condition>
												<children>
													<conditionbranch xpath="n1:Address">
														<children>
															<template match="n1:Address" matchtype="schemagraphitem">
																<editorproperties adding="no" elementstodisplay="1"/>
																<children>
																	<template match="ipo:city" matchtype="schemagraphitem">
																		<editorproperties editable="0" markupmode="hide" adding="no" autoaddname="1"/>
																		<children>
																			<content>
																				<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
																				<format datatype="string"/>
																			</content>
																		</children>
																	</template>
																</children>
															</template>
														</children>
													</conditionbranch>
													<conditionbranch xpath="n1:Address_EU">
														<children>
															<template match="n1:Address_EU" matchtype="schemagraphitem">
																<editorproperties adding="no" elementstodisplay="1"/>
																<children>
																	<template match="ipo:city" matchtype="schemagraphitem">
																		<editorproperties editable="0" markupmode="hide" adding="no" autoaddname="1"/>
																		<children>
																			<content>
																				<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
																				<format datatype="string"/>
																			</content>
																		</children>
																	</template>
																</children>
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
											<template match="n1:Desc" matchtype="schemagraphitem">
												<editorproperties adding="no" elementstodisplay="1"/>
												<children>
													<template match="n1:para" matchtype="schemagraphitem">
														<editorproperties adding="no" elementstodisplay="1"/>
														<children>
															<paragraph paragraphtag="p">
																<children>
																	<content/>
																</children>
															</paragraph>
														</children>
													</template>
												</children>
											</template>
											<template match="n1:Department" matchtype="schemagraphitem" levelflag="1">
												<editorproperties adding="no" elementstodisplay="1"/>
												<children>
													<marker xpath="." name="toc">
														<children>
															<template match="n1:Name" matchtype="schemagraphitem">
																<editorproperties adding="no" elementstodisplay="1"/>
																<children>
																	<content>
																		<styles color="#D39658" font-family="Arial" font-weight="bold"/>
																		<format datatype="string"/>
																	</content>
																</children>
															</template>
														</children>
													</marker>
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
													<table>
														<properties border="1" cellpadding="3" cellspacing="0" width="100%"/>
														<children>
															<tableheader>
																<children>
																	<tablerow>
																		<properties bgcolor="#D2C8AE"/>
																		<children>
																			<tablecell>
																				<properties align="center" bgcolor="#D2C8AE" rowspan="2" width="10%"/>
																				<children>
																					<text fixtext="First">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tablecell>
																			<tablecell>
																				<properties align="center" bgcolor="#D2C8AE" rowspan="2" width="12%"/>
																				<children>
																					<text fixtext="Last">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tablecell>
																			<tablecell>
																				<properties align="center" bgcolor="#D2C8AE" rowspan="2" width="16%"/>
																				<children>
																					<text fixtext="Title">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																					<newline/>
																					<condition>
																						<children>
																							<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos;"/>
																							<conditionbranch xpath="$SV_OutputFormat = &apos;HTML&apos;">
																								<children>
																									<text fixtext="(sorted by)">
																										<styles color="#606060" font-family="Arial" font-size="x-small" font-weight="bold"/>
																									</text>
																								</children>
																							</conditionbranch>
																							<conditionbranch xpath="$SV_OutputFormat = &apos;RTF&apos; or $SV_OutputFormat = &apos;Word2007&apos;">
																								<children>
																									<text fixtext="(sorted by)">
																										<styles color="#606060" font-family="Arial" font-size="x-small" font-weight="bold"/>
																									</text>
																								</children>
																							</conditionbranch>
																							<conditionbranch xpath="$SV_OutputFormat = &apos;PDF&apos;">
																								<children>
																									<text fixtext="(sorted by)">
																										<styles color="#606060" font-family="Arial" font-size="x-small" font-weight="bold"/>
																									</text>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																				</children>
																			</tablecell>
																			<tablecell>
																				<properties align="center" bgcolor="#D2C8AE" rowspan="2" width="5%"/>
																				<children>
																					<text fixtext="Ext">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tablecell>
																			<tablecell>
																				<properties align="center" bgcolor="#D2C8AE" rowspan="2" width="23%"/>
																				<children>
																					<text fixtext="EMail">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tablecell>
																			<tablecell>
																				<properties align="center" bgcolor="#D2C8AE" rowspan="2" width="10%"/>
																				<children>
																					<text fixtext="Shares">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tablecell>
																			<tablecell>
																				<properties align="center" colspan="3" width="8%"/>
																				<children>
																					<text fixtext="Leave">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tablecell>
																		</children>
																	</tablerow>
																	<tablerow>
																		<children>
																			<tablecell>
																				<properties align="center" bgcolor="#D2C8AE" width="8%"/>
																				<children>
																					<text fixtext="Total">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tablecell>
																			<tablecell>
																				<properties align="center" bgcolor="#D2C8AE" width="8%"/>
																				<children>
																					<text fixtext="Used">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tablecell>
																			<tablecell>
																				<properties align="center" bgcolor="#D2C8AE" width="8%"/>
																				<children>
																					<text fixtext="Left">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tablecell>
																		</children>
																	</tablerow>
																</children>
															</tableheader>
															<tablebody>
																<children>
																	<template match="n1:Person" matchtype="schemagraphitem" levelflag="1">
																		<editorproperties adding="mandatory" elementstodisplay="1"/>
																		<children>
																			<tablerow>
																				<properties _xbgcolor="if ( position() mod 2 ) then &quot;antiquewhite&quot; else &quot;navajowhite&quot;"/>
																				<children>
																					<tablecell>
																						<properties width="10%"/>
																						<children>
																							<marker xpath="concat(n1:Last,&apos; &apos;,n1:First)" name="toc" uses="xpath"/>
																							<template match="n1:First" matchtype="schemagraphitem">
																								<editorproperties adding="mandatory" elementstodisplay="1"/>
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
																							</template>
																						</children>
																					</tablecell>
																					<tablecell>
																						<properties width="12%"/>
																						<children>
																							<template match="n1:Last" matchtype="schemagraphitem">
																								<editorproperties adding="mandatory" elementstodisplay="1"/>
																								<children>
																									<condition>
																										<children>
																											<conditionbranch xpath="../n1:Shares &gt; 0">
																												<children>
																													<content>
																														<styles font-size="10pt" font-weight="bold"/>
																														<format datatype="string"/>
																													</content>
																												</children>
																											</conditionbranch>
																											<conditionbranch>
																												<children>
																													<content>
																														<styles font-size="10pt"/>
																														<format datatype="string"/>
																													</content>
																												</children>
																											</conditionbranch>
																										</children>
																									</condition>
																								</children>
																							</template>
																						</children>
																					</tablecell>
																					<tablecell>
																						<properties width="16%"/>
																						<children>
																							<template match="n1:Title" matchtype="schemagraphitem">
																								<editorproperties editable="1" markupmode="hide" adding="mandatory" autoaddname="1"/>
																								<children>
																									<content>
																										<styles font-size="10pt"/>
																										<format datatype="string"/>
																									</content>
																								</children>
																							</template>
																						</children>
																					</tablecell>
																					<tablecell>
																						<properties align="center" width="5%"/>
																						<children>
																							<template match="n1:PhoneExt" matchtype="schemagraphitem">
																								<editorproperties adding="mandatory" elementstodisplay="1"/>
																								<children>
																									<content>
																										<editorproperties editable="1"/>
																										<styles font-size="10pt"/>
																										<addvalidations>
																											<addvalidation usermsg="Telephone extensions must be 3 digits long." xpath="string-length(string(.) ) = 3"/>
																										</addvalidations>
																										<format datatype="int"/>
																									</content>
																								</children>
																							</template>
																						</children>
																					</tablecell>
																					<tablecell>
																						<properties width="23%"/>
																						<children>
																							<template match="n1:EMail" matchtype="schemagraphitem">
																								<editorproperties adding="mandatory" elementstodisplay="1"/>
																								<children>
																									<link>
																										<children>
																											<content>
																												<styles font-size="10pt"/>
																												<format datatype="string"/>
																											</content>
																										</children>
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
																							</template>
																						</children>
																					</tablecell>
																					<tablecell>
																						<properties align="center" width="10%"/>
																						<children>
																							<template match="n1:Shares" matchtype="schemagraphitem">
																								<editorproperties adding="mandatory" elementstodisplay="1"/>
																								<children>
																									<content>
																										<styles font-size="10pt"/>
																										<format datatype="integer"/>
																									</content>
																								</children>
																							</template>
																						</children>
																					</tablecell>
																					<tablecell>
																						<properties align="center" width="8%"/>
																						<children>
																							<template match="n1:LeaveTotal" matchtype="schemagraphitem">
																								<editorproperties adding="mandatory" elementstodisplay="1"/>
																								<children>
																									<content>
																										<styles font-size="10pt"/>
																										<format datatype="decimal"/>
																									</content>
																								</children>
																							</template>
																						</children>
																					</tablecell>
																					<tablecell>
																						<properties align="center" width="8%"/>
																						<children>
																							<template match="n1:LeaveUsed" matchtype="schemagraphitem">
																								<editorproperties adding="mandatory" elementstodisplay="1"/>
																								<children>
																									<content>
																										<styles font-size="10pt"/>
																										<format datatype="decimal"/>
																									</content>
																								</children>
																							</template>
																						</children>
																					</tablecell>
																					<tablecell>
																						<properties align="center" width="8%"/>
																						<children>
																							<autocalc xpath="n1:LeaveTotal - n1:LeaveUsed" update="n1:LeaveLeft">
																								<styles font-size="10pt"/>
																							</autocalc>
																						</children>
																					</tablecell>
																				</children>
																			</tablerow>
																		</children>
																		<sort>
																			<key match="n1:Title"/>
																		</sort>
																	</template>
																</children>
															</tablebody>
															<tablefooter>
																<children>
																	<tablerow>
																		<properties bgcolor="#F2F0E6"/>
																		<children>
																			<tablecell>
																				<properties align="left" colspan="5" valign="top" width="23%"/>
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
																			</tablecell>
																			<tablecell>
																				<properties align="left" colspan="4" width="10%"/>
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
																			</tablecell>
																		</children>
																	</tablerow>
																	<tablerow>
																		<properties bgcolor="#F2F0E6"/>
																		<children>
																			<tablecell>
																				<properties align="left" colspan="9" width="23%"/>
																				<children>
																					<text fixtext="Non-Shareholders: ">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																					<text fixtext=" ">
																						<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																					<template match="n1:Person" matchtype="schemagraphitem">
																						<editorproperties editable="0" markupmode="hide" adding="no" autoaddname="1"/>
																						<children>
																							<condition>
																								<children>
																									<conditionbranch xpath="n1:Shares &lt;= 0 or not (n1:Shares)">
																										<children>
																											<template match="n1:First" matchtype="schemagraphitem">
																												<editorproperties adding="no" elementstodisplay="1"/>
																												<children>
																													<content>
																														<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																													</content>
																												</children>
																											</template>
																											<text fixtext=" ">
																												<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																											</text>
																											<template match="n1:Last" matchtype="schemagraphitem">
																												<editorproperties adding="no" elementstodisplay="1"/>
																												<children>
																													<content>
																														<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																														<format datatype="string"/>
																													</content>
																												</children>
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
																			</tablecell>
																		</children>
																	</tablerow>
																</children>
															</tablefooter>
														</children>
													</table>
													<newline/>
												</children>
											</template>
										</children>
									</template>
									<newline/>
								</children>
							</template>
						</children>
					</template>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts/>
	<pagelayout>
		<properties pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="1" paperheight="11in" papermarginbottom="0.79in" papermarginleft="0.6in" papermarginright="0.6in" papermargintop="0.79in" paperwidth="8.5in"/>
	</pagelayout>
	<designfragments/>
</structure>
