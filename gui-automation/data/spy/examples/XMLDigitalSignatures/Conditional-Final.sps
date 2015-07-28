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
			<xsdschemasource name="XML" main="1" schemafile="Conditional.xsd" workingxmlfile="Conditional.xml"/>
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
									<template subtype="element" match="n1:CompanyLogo">
										<children>
											<image>
												<properties border="0"/>
												<styles height="76px" width="153px"/>
												<target>
													<xpath value="@href"/>
												</target>
											</image>
										</children>
										<variables/>
									</template>
									<newline/>
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
									<template subtype="element" match="n1:Office">
										<children>
											<template subtype="element" match="n1:Name">
												<children>
													<paragraph>
														<children>
															<content>
																<styles color="red" font-family="Arial" font-size="15pt" font-weight="bold"/>
																<format basic-type="xsd" datatype="string"/>
															</content>
														</children>
													</paragraph>
												</children>
												<variables/>
											</template>
											<tgrid>
												<properties border="1" width="100%"/>
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
																		<children>
																			<template subtype="element" match="n1:Address">
																				<children>
																					<text fixtext="Address in: ">
																						<styles font-weight="bold"/>
																					</text>
																					<template subtype="attribute" match="AddressKind">
																						<editorproperties autoaddname="1" editable="1"/>
																						<children>
																							<radiobutton checkedvalue="US">
																								<children>
																									<content>
																										<format basic-type="xsd" datatype="string"/>
																									</content>
																								</children>
																							</radiobutton>
																							<text fixtext="USA"/>
																						</children>
																						<variables/>
																					</template>
																					<text fixtext=" "/>
																					<template subtype="attribute" match="AddressKind">
																						<editorproperties autoaddname="1" editable="1"/>
																						<children>
																							<radiobutton checkedvalue="Japan">
																								<children>
																									<content>
																										<format basic-type="xsd" datatype="string"/>
																									</content>
																								</children>
																							</radiobutton>
																							<text fixtext="Japan"/>
																						</children>
																						<variables/>
																					</template>
																					<text fixtext=" "/>
																					<template subtype="attribute" match="AddressKind">
																						<children>
																							<radiobutton checkedvalue="European">
																								<children>
																									<content>
																										<format basic-type="xsd" datatype="string"/>
																									</content>
																								</children>
																							</radiobutton>
																						</children>
																						<variables/>
																					</template>
																					<text fixtext=" European"/>
																					<line>
																						<properties color="black" size="1"/>
																					</line>
																					<condition>
																						<children>
																							<conditionbranch xpath="@AddressKind=&quot;Japan&quot;">
																								<children>
																									<tgrid>
																										<properties border="0" width="100%"/>
																										<children>
																											<tgridbody-cols>
																												<children>
																													<tgridcol>
																														<properties width="30%"/>
																													</tgridcol>
																													<tgridcol/>
																												</children>
																											</tgridbody-cols>
																											<tgridbody-rows>
																												<children>
																													<tgridrow>
																														<children>
																															<tgridcell>
																																<children>
																																	<text fixtext="City/ZIP:">
																																		<styles font-weight="bold"/>
																																	</text>
																																</children>
																															</tgridcell>
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="ipo:city">
																																		<children>
																																			<editfield>
																																				<properties size="19"/>
																																				<children>
																																					<content>
																																						<format basic-type="xsd" datatype="string"/>
																																					</content>
																																				</children>
																																			</editfield>
																																		</children>
																																		<variables/>
																																	</template>
																																	<template subtype="element" match="ipo:zip">
																																		<children>
																																			<editfield>
																																				<properties size="3"/>
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
																																				<properties size="28"/>
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
																							<conditionbranch xpath="@AddressKind=&quot;US&quot;">
																								<children>
																									<tgrid>
																										<properties border="0" width="100%"/>
																										<children>
																											<tgridbody-cols>
																												<children>
																													<tgridcol>
																														<properties width="30%"/>
																													</tgridcol>
																													<tgridcol>
																														<properties width="70%"/>
																													</tgridcol>
																													<tgridcol/>
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
																																				<properties size="32"/>
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
																															<tgridcell joinleft="1"/>
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
																																				<properties size="32"/>
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
																															<tgridcell joinleft="1"/>
																														</children>
																													</tgridrow>
																													<tgridrow>
																														<children>
																															<tgridcell>
																																<children>
																																	<text fixtext="State/ZIP:">
																																		<styles font-weight="bold"/>
																																	</text>
																																</children>
																															</tgridcell>
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="ipo:state">
																																		<children>
																																			<combobox>
																																				<children>
																																					<content>
																																						<format basic-type="xsd" datatype="string"/>
																																					</content>
																																				</children>
																																				<selectoption description="AK" value="AK"/>
																																				<selectoption description="AL" value="AL"/>
																																				<selectoption description="AR" value="AR"/>
																																				<selectoption description="AZ" value="AZ"/>
																																				<selectoption description="CA" value="CA"/>
																																				<selectoption description="CO" value="CO"/>
																																				<selectoption description="CT" value="CT"/>
																																				<selectoption description="DC" value="DC"/>
																																				<selectoption description="DE" value="DE"/>
																																				<selectoption description="FL" value="FL"/>
																																				<selectoption description="GA" value="GA"/>
																																				<selectoption description="GU" value="GU"/>
																																				<selectoption description="HI" value="HI"/>
																																				<selectoption description="IA" value="IA"/>
																																				<selectoption description="ID" value="ID"/>
																																				<selectoption description="IL" value="IL"/>
																																				<selectoption description="IN" value="IN"/>
																																				<selectoption description="KS" value="KS"/>
																																				<selectoption description="KY" value="KY"/>
																																				<selectoption description="LA" value="LA"/>
																																				<selectoption description="MA" value="MA"/>
																																				<selectoption description="MD" value="MD"/>
																																				<selectoption description="ME" value="ME"/>
																																				<selectoption description="MI" value="MI"/>
																																				<selectoption description="MN" value="MN"/>
																																				<selectoption description="MO" value="MO"/>
																																				<selectoption description="MS" value="MS"/>
																																				<selectoption description="MT" value="MT"/>
																																				<selectoption description="NC" value="NC"/>
																																				<selectoption description="ND" value="ND"/>
																																				<selectoption description="NE" value="NE"/>
																																				<selectoption description="NH" value="NH"/>
																																				<selectoption description="NJ" value="NJ"/>
																																				<selectoption description="NM" value="NM"/>
																																				<selectoption description="NV" value="NV"/>
																																				<selectoption description="NY" value="NY"/>
																																				<selectoption description="OH" value="OH"/>
																																				<selectoption description="OK" value="OK"/>
																																				<selectoption description="OR" value="OR"/>
																																				<selectoption description="PA" value="PA"/>
																																				<selectoption description="PR" value="PR"/>
																																				<selectoption description="RI" value="RI"/>
																																				<selectoption description="SC" value="SC"/>
																																				<selectoption description="SD" value="SD"/>
																																				<selectoption description="TN" value="TN"/>
																																				<selectoption description="TX" value="TX"/>
																																				<selectoption description="UT" value="UT"/>
																																				<selectoption description="VA" value="VA"/>
																																				<selectoption description="VI" value="VI"/>
																																				<selectoption description="VT" value="VT"/>
																																				<selectoption description="WA" value="WA"/>
																																				<selectoption description="WI" value="WI"/>
																																				<selectoption description="WV" value="WV"/>
																																				<selectoption description="WY" value="WY"/>
																																			</combobox>
																																		</children>
																																		<variables/>
																																	</template>
																																	<template subtype="element" match="ipo:zip">
																																		<children>
																																			<editfield>
																																				<properties size="14"/>
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
																															<tgridcell/>
																														</children>
																													</tgridrow>
																												</children>
																											</tgridbody-rows>
																										</children>
																									</tgrid>
																								</children>
																							</conditionbranch>
																							<conditionbranch>
																								<children>
																									<tgrid>
																										<properties border="0" width="100%"/>
																										<children>
																											<tgridbody-cols>
																												<children>
																													<tgridcol>
																														<properties width="30%"/>
																													</tgridcol>
																													<tgridcol/>
																												</children>
																											</tgridbody-cols>
																											<tgridbody-rows>
																												<children>
																													<tgridrow>
																														<children>
																															<tgridcell>
																																<children>
																																	<text fixtext="City/Postcode:">
																																		<styles font-weight="bold"/>
																																	</text>
																																</children>
																															</tgridcell>
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="ipo:city">
																																		<children>
																																			<editfield>
																																				<properties size="19"/>
																																				<children>
																																					<content>
																																						<format basic-type="xsd" datatype="string"/>
																																					</content>
																																				</children>
																																			</editfield>
																																		</children>
																																		<variables/>
																																	</template>
																																	<template subtype="element" match="ipo:zip">
																																		<children>
																																			<editfield>
																																				<properties size="3"/>
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
																																				<properties size="28"/>
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
																					<newline/>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<children>
																			<tgrid>
																				<properties border="0" width="100%"/>
																				<children>
																					<tgridbody-cols>
																						<children>
																							<tgridcol/>
																						</children>
																					</tgridbody-cols>
																					<tgridbody-rows>
																						<children>
																							<tgridrow>
																								<children>
																									<tgridcell>
																										<children>
																											<text fixtext="Customer ">
																												<styles font-weight="bold"/>
																											</text>
																											<newline/>
																											<text fixtext="support ">
																												<styles font-weight="bold"/>
																											</text>
																											<template subtype="element" match="n1:CustomerSupport">
																												<children>
																													<checkbox checkedvalue="1" checkedvalue1="true">
																														<children>
																															<content>
																																<format basic-type="xsd" datatype="boolean"/>
																															</content>
																														</children>
																													</checkbox>
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
																											<line>
																												<properties color="black" size="1"/>
																											</line>
																										</children>
																									</tgridcell>
																								</children>
																							</tgridrow>
																							<tgridrow>
																								<children>
																									<tgridcell>
																										<properties align="right"/>
																										<children>
																											<condition>
																												<children>
																													<conditionbranch xpath="(contains(string(n1:CustomerSupport),&quot;true&quot;)) or (contains(string(n1:CustomerSupport),&quot;1&quot;))">
																														<children>
																															<text fixtext="Telephone "/>
																															<template subtype="element" match="n1:StandardSupport">
																																<editorproperties autoaddname="1" editable="1" adding="mandatory"/>
																																<children>
																																	<editfield>
																																		<properties size="5"/>
																																		<children>
																																			<content>
																																				<format basic-type="xsd" datatype="string"/>
																																			</content>
																																		</children>
																																	</editfield>
																																</children>
																																<variables/>
																															</template>
																															<newline/>
																															<text fixtext="On-site "/>
																															<template subtype="element" match="n1:PaidSupport">
																																<editorproperties autoaddname="1" editable="1" adding="mandatory"/>
																																<children>
																																	<editfield>
																																		<properties size="5"/>
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
																													</conditionbranch>
																												</children>
																											</condition>
																										</children>
																									</tgridcell>
																								</children>
																							</tgridrow>
																							<tgridrow>
																								<children>
																									<tgridcell/>
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
											<template subtype="element" match="n1:Department">
												<children>
													<template subtype="element" match="n1:Name">
														<children>
															<content>
																<styles font-weight="bold"/>
																<format basic-type="xsd" datatype="string"/>
															</content>
														</children>
														<variables/>
													</template>
													<text fixtext=" - Internet connection "/>
													<template subtype="attribute" match="InternetConnection">
														<children>
															<checkbox checkedvalue="1" checkedvalue1="true">
																<children>
																	<content>
																		<format basic-type="xsd" datatype="boolean"/>
																	</content>
																</children>
															</checkbox>
														</children>
														<variables/>
													</template>
													<text fixtext=" "/>
													<newline/>
													<condition>
														<children>
															<conditionbranch xpath="(contains(string(@InternetConnection),&quot;true&quot;)) or (contains(string(@InternetConnection),&quot;1&quot;))">
																<children>
																	<tgrid>
																		<properties border="0" width="100%"/>
																		<children>
																			<tgridbody-cols>
																				<children>
																					<tgridcol>
																						<properties width="17%"/>
																					</tgridcol>
																					<tgridcol>
																						<properties width="17%"/>
																					</tgridcol>
																					<tgridcol>
																						<properties width="30%"/>
																					</tgridcol>
																					<tgridcol>
																						<properties width="5%"/>
																					</tgridcol>
																					<tgridcol>
																						<properties width="31%"/>
																					</tgridcol>
																				</children>
																			</tgridbody-cols>
																			<tgridheader-rows>
																				<children>
																					<tgridrow>
																						<properties bgcolor="#C0C0C0"/>
																						<children>
																							<tgridcell>
																								<children>
																									<text fixtext="First">
																										<styles font-weight="bold"/>
																									</text>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<text fixtext="Last">
																										<styles font-weight="bold"/>
																									</text>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<text fixtext="Title">
																										<styles font-weight="bold"/>
																									</text>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<text fixtext="Ext">
																										<styles font-weight="bold"/>
																									</text>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<text fixtext="EMail">
																										<styles font-weight="bold"/>
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
																								<properties bgcolor="#E0E0E0"/>
																								<children>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="n1:First">
																												<children>
																													<condition>
																														<children>
																															<conditionbranch xpath="contains(../n1:Title,&quot;Manager&quot;)">
																																<children>
																																	<content>
																																		<styles color="navy" font-weight="bold"/>
																																		<format basic-type="xsd" datatype="string"/>
																																	</content>
																																</children>
																															</conditionbranch>
																															<conditionbranch>
																																<children>
																																	<content>
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
																											<template subtype="element" match="n1:Last">
																												<children>
																													<condition>
																														<children>
																															<conditionbranch xpath="contains(../n1:Title,&quot;Manager&quot;)">
																																<children>
																																	<content>
																																		<styles color="navy" font-weight="bold"/>
																																		<format basic-type="xsd" datatype="string"/>
																																	</content>
																																</children>
																															</conditionbranch>
																															<conditionbranch>
																																<children>
																																	<content>
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
																												<children>
																													<content>
																														<format basic-type="xsd" datatype="string"/>
																													</content>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="n1:PhoneExt">
																												<children>
																													<content>
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
																												<editorproperties editable="1"/>
																												<children>
																													<condition>
																														<children>
																															<conditionbranch xpath="contains(../n1:Title,&quot;Manager&quot;)">
																																<children>
																																	<content>
																																		<styles color="navy" font-weight="bold"/>
																																		<format basic-type="xsd" datatype="string"/>
																																	</content>
																																</children>
																															</conditionbranch>
																															<conditionbranch>
																																<children>
																																	<content>
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
																								</children>
																							</tgridrow>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</tgridbody-rows>
																		</children>
																	</tgrid>
																</children>
															</conditionbranch>
															<conditionbranch xpath="contains(string(@InternetConnection),&quot;false&quot;)">
																<children>
																	<tgrid>
																		<properties border="0" width="100%"/>
																		<children>
																			<tgridbody-cols>
																				<children>
																					<tgridcol>
																						<properties width="24%"/>
																					</tgridcol>
																					<tgridcol>
																						<properties width="24%"/>
																					</tgridcol>
																					<tgridcol>
																						<properties width="40%"/>
																					</tgridcol>
																					<tgridcol>
																						<properties width="12%"/>
																					</tgridcol>
																				</children>
																			</tgridbody-cols>
																			<tgridheader-rows>
																				<children>
																					<tgridrow>
																						<properties bgcolor="#C0C0C0"/>
																						<children>
																							<tgridcell>
																								<children>
																									<text fixtext="First">
																										<styles font-weight="bold"/>
																									</text>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<text fixtext="Last">
																										<styles font-weight="bold"/>
																									</text>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<text fixtext="Title">
																										<styles font-weight="bold"/>
																									</text>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<text fixtext="Ext">
																										<styles font-weight="bold"/>
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
																								<properties bgcolor="#E0E0E0"/>
																								<children>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="n1:First">
																												<children>
																													<condition>
																														<children>
																															<conditionbranch xpath="contains(../n1:Title,&apos;Manager&apos;)">
																																<children>
																																	<content>
																																		<styles color="navy" font-weight="bold"/>
																																		<format basic-type="xsd" datatype="string"/>
																																	</content>
																																</children>
																															</conditionbranch>
																															<conditionbranch>
																																<children>
																																	<content>
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
																											<template subtype="element" match="n1:Last">
																												<children>
																													<condition>
																														<children>
																															<conditionbranch xpath="contains(../n1:Title,&apos;Manager&apos;)">
																																<children>
																																	<content>
																																		<styles color="navy" font-weight="bold"/>
																																		<format basic-type="xsd" datatype="string"/>
																																	</content>
																																</children>
																															</conditionbranch>
																															<conditionbranch>
																																<children>
																																	<content>
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
																												<children>
																													<content>
																														<format basic-type="xsd" datatype="string"/>
																													</content>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="n1:PhoneExt">
																												<children>
																													<content>
																														<format basic-type="xsd" datatype="int"/>
																													</content>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																								</children>
																							</tgridrow>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</tgridbody-rows>
																		</children>
																	</tgrid>
																</children>
															</conditionbranch>
														</children>
													</condition>
													<newline/>
												</children>
												<variables/>
											</template>
											<newline/>
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
	<xmltables/>
	<authentic-custom-toolbar-buttons/>
</structure>
