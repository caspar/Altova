<?xml version="1.0" encoding="UTF-8"?>
<structure version="14" xsltversion="1" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="UTF-8" encodingpdf="UTF-8" useimportschema="1" embed-images="1" pastemode="xml" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="ipo" uri="http://www.altova.com/IPO"/>
			<nspair prefix="ns1" uri="http://www.altova.com/schemas/orgchart"/>
			<nspair prefix="ts" uri="http://www.xmlspy.com/schemas/textstate"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="HTML-OrgChart.xsd" workingxmlfile="Html-OrgChart.xml"/>
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
						<properties columncount="1" columngap="0.50in" headerfooterheight="variable" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="1" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.0in" papermarginheader="0.0in" papermarginleft="0.6in" papermarginright="0.6in" papermargintop="0.79in" paperwidth="8.5in"/>
					</documentsection>
					<template subtype="source" match="XML">
						<children>
							<template subtype="element" match="ns1:OrgChart">
								<children>
									<template subtype="element" match="ns1:Name">
										<children>
											<content>
												<styles font-size="large" font-weight="bold"/>
												<format basic-type="xsd" datatype="string"/>
											</content>
										</children>
										<variables/>
									</template>
									<newline/>
									<template subtype="element" match="ns1:Office">
										<children>
											<template subtype="element" match="ns1:Name">
												<children>
													<paragraph>
														<children>
															<content>
																<styles color="red" font-size="medium"/>
																<format basic-type="xsd" datatype="string"/>
															</content>
														</children>
													</paragraph>
												</children>
												<variables/>
											</template>
											<tgrid>
												<properties width="85%"/>
												<children>
													<tgridbody-cols>
														<children>
															<tgridcol>
																<properties width="50%"/>
															</tgridcol>
															<tgridcol>
																<properties width="50%"/>
															</tgridcol>
														</children>
													</tgridbody-cols>
													<tgridbody-rows>
														<children>
															<tgridrow>
																<properties valign="top"/>
																<children>
																	<tgridcell>
																		<children>
																			<tgrid>
																				<properties border="1" cellspacing="0" width="100%"/>
																				<children>
																					<tgridbody-cols>
																						<children>
																							<tgridcol>
																								<properties width="25%"/>
																							</tgridcol>
																							<template subtype="element" match="ns1:Address">
																								<children>
																									<tgridcol>
																										<properties width="75%"/>
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
																											<text fixtext="street"/>
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
																								<styles height="26px"/>
																								<children>
																									<tgridcell>
																										<children>
																											<text fixtext="city"/>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="ipo:city">
																												<children>
																													<combobox>
																														<children>
																															<content>
																																<format basic-type="xsd" datatype="string"/>
																															</content>
																														</children>
																														<selectoption description="Athens" value="1"/>
																														<selectoption description="Paris" value="2"/>
																													</combobox>
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
																											<text fixtext="state/zip"/>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="ipo:state">
																												<children>
																													<content>
																														<format basic-type="xsd" datatype="string"/>
																													</content>
																												</children>
																												<variables/>
																											</template>
																											<text fixtext="/"/>
																											<template subtype="element" match="ipo:zip">
																												<children>
																													<content>
																														<format basic-type="xsd" datatype="positiveInteger"/>
																													</content>
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
																			<newline/>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<properties valign="top"/>
																		<children>
																			<tgrid>
																				<properties border="1" cellspacing="0" width="100%"/>
																				<children>
																					<tgridbody-cols>
																						<children>
																							<tgridcol>
																								<properties width="35%"/>
																							</tgridcol>
																							<tgridcol>
																								<properties width="65%"/>
																							</tgridcol>
																						</children>
																					</tgridbody-cols>
																					<tgridbody-rows>
																						<children>
																							<tgridrow>
																								<children>
																									<tgridcell>
																										<children>
																											<text fixtext="Phone"/>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="ns1:Phone">
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
																								<styles height="26px"/>
																								<children>
																									<tgridcell>
																										<children>
																											<text fixtext="Fax"/>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="ns1:Fax">
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
																											<text fixtext="Email"/>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="ns1:EMail">
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
										</children>
										<variables/>
									</template>
									<template subtype="element" match="ns1:Office">
										<children>
											<newline/>
											<template subtype="element" match="ns1:Desc">
												<children>
													<template subtype="element" match="ns1:para">
														<children>
															<paragraph>
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
											<newline/>
											<template subtype="element" match="ns1:Department">
												<children>
													<newline/>
													<template subtype="element" match="ns1:Name">
														<children>
															<paragraph>
																<children>
																	<content>
																		<styles font-weight="bold"/>
																		<format basic-type="xsd" datatype="string"/>
																	</content>
																</children>
															</paragraph>
														</children>
														<variables/>
													</template>
													<tgrid>
														<properties bgcolor="white" width="85%"/>
														<children>
															<tgridbody-cols>
																<children>
																	<tgridcol>
																		<properties width="12%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="18%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="28%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="10%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="32%"/>
																	</tgridcol>
																</children>
															</tgridbody-cols>
															<tgridheader-rows>
																<children>
																	<tgridrow>
																		<properties bgcolor="silver"/>
																		<children>
																			<tgridcell>
																				<children>
																					<text fixtext="First"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<text fixtext="Last"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<text fixtext="Title"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<text fixtext="PhoneExt"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<text fixtext="EMail"/>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																</children>
															</tgridheader-rows>
															<tgridbody-rows>
																<children>
																	<template subtype="element" match="ns1:Person">
																		<children>
																			<tgridrow>
																				<properties bgcolor="yellow"/>
																				<children>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="ns1:First">
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
																							<template subtype="element" match="ns1:Last">
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
																							<template subtype="element" match="ns1:Title">
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
																							<template subtype="element" match="ns1:PhoneExt">
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
																							<template subtype="element" match="ns1:EMail">
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
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridbody-rows>
														</children>
													</tgrid>
												</children>
												<variables/>
											</template>
										</children>
										<variables/>
									</template>
									<newline/>
									<newline/>
									<newline/>
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
					<xmltable-tag tag-name="table"/>
					<xmltable-tag tag-type="Caption" tag-name="caption"/>
					<xmltable-tag tag-type="Header" tag-name="thead"/>
					<xmltable-tag tag-type="Footer" tag-name="tfoot"/>
					<xmltable-tag tag-type="Body" tag-name="tbody"/>
					<xmltable-tag tag-type="Row" tag-name="tr"/>
					<xmltable-tag tag-type="Cell" tag-name="td"/>
					<xmltable-tag tag-type="HeaderCell" tag-name="th"/>
				</children>
			</xmltable>
		</children>
	</xmltables>
	<authentic-custom-toolbar-buttons/>
</structure>
