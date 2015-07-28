<?xml version="1.0" encoding="UTF-8"?>
<structure version="14" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="UTF-8" encodingpdf="UTF-8" useimportschema="1" embed-images="1" pastemode="xml" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="ts" uri="http://www.xmlspy.com/schemas/textstate"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="ExpReport.xsd" workingxmlfile="ExpReport.xml"/>
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
							<template subtype="element" match="expense-report">
								<children>
									<newline/>
									<tgrid>
										<properties border="0" cellpadding="0" cellspacing="0" width="100%"/>
										<styles border-collapse="collapse"/>
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
																<styles border-bottom-color="#0588BA" border-bottom-style="solid" border-bottom-width="medium"/>
																<children>
																	<image>
																		<properties border="0"/>
																		<styles height="76px" width="153px"/>
																		<target>
																			<fixtext value="http://www.nanonull.com/nanonull.gif"/>
																		</target>
																	</image>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
												</children>
											</tgridbody-rows>
										</children>
									</tgrid>
									<tgrid>
										<properties border="0" width="100%"/>
										<children>
											<tgridbody-cols>
												<children>
													<tgridcol>
														<properties width="50%"/>
													</tgridcol>
													<tgridcol>
														<properties width="35%"/>
													</tgridcol>
													<tgridcol>
														<properties width="15%"/>
													</tgridcol>
												</children>
											</tgridbody-cols>
											<tgridbody-rows>
												<children>
													<tgridrow>
														<children>
															<tgridcell>
																<properties align="left" valign="top"/>
																<children>
																	<text fixtext="Business Expense Report">
																		<styles font-size="20pt" font-weight="bold" margin-top="3pt"/>
																	</text>
																</children>
															</tgridcell>
															<tgridcell>
																<properties bgcolor="#D2FFFF"/>
																<children>
																	<template subtype="attribute" match="currency">
																		<children>
																			<radiobutton checkedvalue="USD">
																				<styles font-family="Tahoma" font-size="10pt"/>
																				<children>
																					<content>
																						<format basic-type="xsd" datatype="string"/>
																					</content>
																				</children>
																			</radiobutton>
																			<text fixtext="Dollars">
																				<styles font-family="Tahoma" font-size="10pt"/>
																			</text>
																		</children>
																		<variables/>
																	</template>
																	<text fixtext=" ">
																		<styles font-family="Tahoma" font-size="10pt"/>
																	</text>
																	<template subtype="attribute" match="currency">
																		<children>
																			<radiobutton checkedvalue="Euro">
																				<styles font-family="Tahoma" font-size="10pt"/>
																				<children>
																					<content>
																						<format basic-type="xsd" datatype="string"/>
																					</content>
																				</children>
																			</radiobutton>
																			<text fixtext="Euros">
																				<styles font-family="Tahoma" font-size="10pt"/>
																			</text>
																		</children>
																		<variables/>
																	</template>
																	<text fixtext=" ">
																		<styles font-family="Tahoma" font-size="10pt"/>
																	</text>
																	<template subtype="attribute" match="currency">
																		<children>
																			<radiobutton checkedvalue="JPY">
																				<styles font-family="Tahoma" font-size="10pt"/>
																				<children>
																					<content>
																						<format basic-type="xsd" datatype="string"/>
																					</content>
																				</children>
																			</radiobutton>
																			<text fixtext="Yen">
																				<styles font-family="Tahoma" font-size="10pt"/>
																			</text>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell>
																<properties bgcolor="#D2FFFF"/>
																<children>
																	<text fixtext="Total:  ">
																		<styles font-family="Tahoma" font-size="10pt" font-weight="bold"/>
																	</text>
																	<template subtype="attribute" match="total-sum">
																		<editorproperties autoaddname="1" editable="0"/>
																		<children>
																			<content>
																				<styles font-family="Tahoma" font-size="10pt"/>
																				<format basic-type="xsd" string="###,##0.00" datatype="decimal"/>
																			</content>
																		</children>
																		<variables/>
																	</template>
																	<condition>
																		<children>
																			<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																				<children>
																					<text fixtext="$">
																						<styles font-size="10pt"/>
																					</text>
																				</children>
																			</conditionbranch>
																			<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																				<children>
																					<text fixtext="€">
																						<styles font-size="x-small"/>
																					</text>
																				</children>
																			</conditionbranch>
																			<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																				<children>
																					<text fixtext="¥">
																						<styles font-size="x-small"/>
																					</text>
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
															<tgridcell joinabove="1">
																<properties bgcolor="#D2FFFF"/>
															</tgridcell>
															<tgridcell>
																<properties bgcolor="#D2FFFF"/>
																<children>
																	<template subtype="attribute" match="detailed">
																		<children>
																			<checkbox checkedvalue="1" checkedvalue1="true">
																				<styles font-size="10pt"/>
																				<children>
																					<content>
																						<format basic-type="xsd" datatype="boolean"/>
																					</content>
																				</children>
																			</checkbox>
																		</children>
																		<variables/>
																	</template>
																	<text fixtext="Detailed report   ">
																		<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																	</text>
																	<template subtype="uservariable" match="$ShowExpenseSplit">
																		<children>
																			<checkbox checkedvalue="1" checkedvalue1="true">
																				<styles font-size="10pt"/>
																				<children>
																					<content>
																						<format basic-type="xsd" datatype="boolean"/>
																					</content>
																				</children>
																			</checkbox>
																		</children>
																		<variables/>
																	</template>
																	<text fixtext="Expense split">
																		<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																	</text>
																</children>
															</tgridcell>
															<tgridcell joinleft="1">
																<properties bgcolor="#D2FFFF"/>
															</tgridcell>
														</children>
													</tgridrow>
												</children>
											</tgridbody-rows>
										</children>
									</tgrid>
									<tgrid>
										<properties border="0" cellpadding="0" cellspacing="0" width="100%"/>
										<styles border-collapse="collapse" table-layout="fixed"/>
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
																<properties bgcolor="#D2FFFF"/>
																<styles border-bottom-color="black" border-bottom-style="solid" border-bottom-width="1pt"/>
																<children>
																	<text fixtext="Employee Information">
																		<styles font-family="Verdana" font-size="14pt"/>
																	</text>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
												</children>
											</tgridbody-rows>
										</children>
									</tgrid>
									<template subtype="element" match="Person">
										<children>
											<tgrid>
												<properties border="0" cellpadding="0" cellspacing="0" width="100%"/>
												<styles border-collapse="collapse"/>
												<children>
													<tgridbody-cols>
														<children>
															<tgridcol>
																<properties width="2%"/>
															</tgridcol>
															<tgridcol>
																<properties width="48%"/>
															</tgridcol>
															<tgridcol>
																<properties width="48%"/>
															</tgridcol>
															<tgridcol>
																<properties width="2%"/>
															</tgridcol>
														</children>
													</tgridbody-cols>
													<tgridbody-rows>
														<children>
															<tgridrow>
																<children>
																	<tgridcell/>
																	<tgridcell>
																		<children>
																			<tgrid>
																				<properties border="0" width="100%"/>
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
																								<children>
																									<tgridcell>
																										<properties bgcolor="#F3F3F3"/>
																										<styles border-color="#D3D3D3" border-style="solid" border-width="1pt"/>
																										<children>
																											<template subtype="element" match="First">
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
																										<properties bgcolor="#F3F3F3"/>
																										<styles border-color="#D3D3D3" border-style="solid" border-width="1pt"/>
																										<children>
																											<template subtype="element" match="Last">
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
																											<condition>
																												<children>
																													<conditionbranch xpath="string-length( First ) &gt; 0">
																														<children>
																															<text fixtext="First Name">
																																<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																															</text>
																														</children>
																													</conditionbranch>
																													<conditionbranch>
																														<children>
																															<text fixtext="First Name is required">
																																<styles color="#FF0000" font-family="Arial" font-size="10pt" font-weight="bold"/>
																															</text>
																														</children>
																													</conditionbranch>
																												</children>
																											</condition>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<condition>
																												<children>
																													<conditionbranch xpath="string-length( Last ) &gt; 0">
																														<children>
																															<text fixtext="Last Name">
																																<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																															</text>
																														</children>
																													</conditionbranch>
																													<conditionbranch>
																														<children>
																															<text fixtext="Last Name is required">
																																<styles color="#FF0000" font-family="Arial" font-size="10pt" font-weight="bold"/>
																															</text>
																														</children>
																													</conditionbranch>
																												</children>
																											</condition>
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
																										<properties bgcolor="#F3F3F3"/>
																										<styles border-color="#D3D3D3" border-style="solid" border-width="1pt"/>
																										<children>
																											<template subtype="element" match="Title">
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
																											<text fixtext="Title">
																												<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																											</text>
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
																	<tgridcell/>
																</children>
															</tgridrow>
															<tgridrow>
																<children>
																	<tgridcell/>
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
																										<properties bgcolor="#F3F3F3"/>
																										<styles border-color="#D3D3D3" border-style="solid" border-width="1pt"/>
																										<children>
																											<template subtype="element" match="Email">
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
																											<condition>
																												<children>
																													<conditionbranch xpath="string-length( Email ) &gt; 0">
																														<children>
																															<text fixtext="E-Mail">
																																<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																															</text>
																														</children>
																													</conditionbranch>
																													<conditionbranch>
																														<children>
																															<text fixtext="E-Mail is required">
																																<styles color="#FF0000" font-family="Arial" font-size="10pt" font-weight="bold"/>
																															</text>
																														</children>
																													</conditionbranch>
																												</children>
																											</condition>
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
																										<properties bgcolor="#F3F3F3"/>
																										<styles border-color="#D3D3D3" border-style="solid" border-width="1pt"/>
																										<children>
																											<template subtype="element" match="Phone">
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
																											<text fixtext="Phone">
																												<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																											</text>
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
																	<tgridcell/>
																</children>
															</tgridrow>
														</children>
													</tgridbody-rows>
												</children>
											</tgrid>
										</children>
										<variables/>
									</template>
									<newline/>
									<tgrid>
										<properties border="0" cellpadding="0" cellspacing="0" width="100%"/>
										<styles border-collapse="collapse" table-layout="fixed"/>
										<children>
											<tgridbody-cols>
												<children>
													<tgridcol/>
												</children>
											</tgridbody-cols>
											<tgridbody-rows>
												<children>
													<tgridrow>
														<styles height="24px"/>
														<children>
															<tgridcell>
																<properties bgcolor="#D2FFFF"/>
																<styles border-bottom-color="black" border-bottom-style="solid" border-bottom-width="1pt"/>
																<children>
																	<text fixtext="Expense List">
																		<styles font-family="Verdana" font-size="14pt"/>
																	</text>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
												</children>
											</tgridbody-rows>
										</children>
									</tgrid>
									<condition>
										<children>
											<conditionbranch xpath="(contains(string(@detailed), &quot;true&quot;)) or (contains(string(@detailed), &quot;1&quot;))">
												<children>
													<tgrid>
														<properties border="0" width="100%"/>
														<children>
															<tgridbody-cols>
																<children>
																	<tgridcol>
																		<properties width="16%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="16%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="16%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="12%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="18%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="22%"/>
																	</tgridcol>
																</children>
															</tgridbody-cols>
															<tgridheader-rows>
																<children>
																	<tgridrow>
																		<properties bgcolor="#C0C0C0"/>
																		<children>
																			<tgridcell>
																				<properties align="left"/>
																				<children>
																					<text fixtext="Type">
																						<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="left"/>
																				<children>
																					<text fixtext="Expense To">
																						<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="left"/>
																				<children>
																					<text fixtext="Date">
																						<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																					</text>
																					<text fixtext=" (">
																						<styles font-family="Arial" font-size="9pt" font-weight="bold"/>
																					</text>
																					<text fixtext="mm/dd/yyyy">
																						<styles font-family="Arial" font-size="9pt" font-style="italic" font-weight="bold"/>
																					</text>
																					<text fixtext=")">
																						<styles font-family="Arial" font-size="9pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="left"/>
																				<children>
																					<text fixtext="Expense">
																						<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="left"/>
																				<children>
																					<text fixtext="Details">
																						<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="left"/>
																				<children>
																					<text fixtext="Description">
																						<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																</children>
															</tgridheader-rows>
															<tgridbody-rows>
																<children>
																	<template subtype="element" match="expense-item">
																		<children>
																			<tgridrow>
																				<properties bgcolor="#E0E0E0"/>
																				<children>
																					<tgridcell>
																						<children>
																							<template subtype="attribute" match="type">
																								<children>
																									<combobox>
																										<children>
																											<content>
																												<format basic-type="xsd" datatype="string"/>
																											</content>
																										</children>
																										<selectoption description="Meal" value="Meal"/>
																										<selectoption description="Lodging" value="Lodging"/>
																										<selectoption description="Travel" value="Travel"/>
																										<selectoption description="Parking" value="Parking"/>
																										<selectoption description="Entertainment" value="Entertainment"/>
																										<selectoption description="Misc" value="Misc"/>
																									</combobox>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="attribute" match="expto">
																								<children>
																									<combobox>
																										<children>
																											<content>
																												<format basic-type="xsd" datatype="string"/>
																											</content>
																										</children>
																										<selectoption description="Development" value="Development"/>
																										<selectoption description="Marketing" value="Marketing"/>
																										<selectoption description="Accounting" value="Accounting"/>
																										<selectoption description="Sales" value="Sales"/>
																										<selectoption description="Operations" value="Operations"/>
																										<selectoption description="Support" value="Support"/>
																										<selectoption description="IT" value="IT"/>
																									</combobox>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<properties align="center"/>
																						<children>
																							<template subtype="element" match="Date">
																								<children>
																									<content>
																										<styles white-space="nowrap"/>
																										<format basic-type="xsd" string="MM/DD/YYYY" datatype="date"/>
																									</content>
																									<text fixtext=" "/>
																									<button>
																										<action>
																											<datepicker/>
																										</action>
																									</button>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<properties align="right"/>
																						<children>
																							<template subtype="element" match="expense">
																								<children>
																									<content>
																										<format basic-type="xsd" string="###,##0.00" datatype="decimal"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																							<text fixtext=" "/>
																							<condition>
																								<children>
																									<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																										<children>
																											<text fixtext="$">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath=" /expense-report/@currency  = &quot;UKP&quot;">
																										<children>
																											<text fixtext="£">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																										<children>
																											<text fixtext="€">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																										<children>
																											<text fixtext="¥">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath=" /expense-report/@currency = &quot;AUD&quot;">
																										<children>
																											<text fixtext="AU$">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</conditionbranch>
																								</children>
																							</condition>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<condition>
																								<children>
																									<conditionbranch xpath=" @type  = &quot;Meal&quot;">
																										<children>
																											<template subtype="element" match="Meal">
																												<children>
																													<template subtype="attribute" match="mealtype">
																														<children>
																															<text fixtext="Meal Type: ">
																																<styles font-family="Arial" font-size="11pt"/>
																															</text>
																															<combobox>
																																<styles font-family="Arial" font-size="11pt"/>
																																<children>
																																	<content>
																																		<format basic-type="xsd" datatype="string"/>
																																	</content>
																																</children>
																																<selectoption description="dinner" value="dinner"/>
																																<selectoption description="breakfast" value="breakfast"/>
																																<selectoption description="lunch" value="lunch"/>
																																<selectoption description="other" value="other"/>
																															</combobox>
																															<newline/>
																														</children>
																														<variables/>
																													</template>
																													<template subtype="element" match="Location">
																														<children>
																															<text fixtext="Location: ">
																																<styles font-family="Arial" font-size="11pt"/>
																															</text>
																															<editfield>
																																<styles font-family="Arial" font-size="11pt"/>
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
																												<variables/>
																											</template>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath=" @type  = &quot;Lodging&quot;">
																										<children>
																											<template subtype="element" match="Lodging">
																												<children>
																													<template subtype="element" match="Name">
																														<children>
																															<text fixtext="Lodging Name: ">
																																<styles font-family="Arial" font-size="11pt"/>
																															</text>
																															<editfield>
																																<styles font-family="Arial" font-size="11pt"/>
																																<children>
																																	<content>
																																		<format basic-type="xsd" datatype="string"/>
																																	</content>
																																</children>
																															</editfield>
																															<newline/>
																														</children>
																														<variables/>
																													</template>
																													<template subtype="element" match="Location">
																														<children>
																															<text fixtext="Location: ">
																																<styles font-family="Arial" font-size="11pt"/>
																															</text>
																															<editfield>
																																<styles font-family="Arial" font-size="11pt"/>
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
																												<variables/>
																											</template>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath=" @type  = &quot;Travel&quot;">
																										<children>
																											<template subtype="element" match="Travel">
																												<children>
																													<template subtype="attribute" match="means">
																														<children>
																															<text fixtext="Means: ">
																																<styles font-family="Arial" font-size="11pt"/>
																															</text>
																															<combobox>
																																<styles font-family="Arial" font-size="11pt"/>
																																<children>
																																	<content>
																																		<format basic-type="xsd" datatype="string"/>
																																	</content>
																																</children>
																																<selectoption description="Taxi" value="Taxi"/>
																																<selectoption description="CharterAir" value="CharterAir"/>
																																<selectoption description="Airline" value="Airline"/>
																																<selectoption description="Limo" value="Limo"/>
																																<selectoption description="CharterSea" value="CharterSea"/>
																																<selectoption description="Rail" value="Rail"/>
																																<selectoption description="CharterLand" value="CharterLand"/>
																																<selectoption description="Bus" value="Bus"/>
																															</combobox>
																															<newline/>
																														</children>
																														<variables/>
																													</template>
																													<template subtype="element" match="Destination">
																														<children>
																															<text fixtext="Destination: ">
																																<styles font-family="Arial" font-size="11pt"/>
																															</text>
																															<editfield>
																																<styles font-family="Arial" font-size="11pt"/>
																																<children>
																																	<content>
																																		<format basic-type="xsd" datatype="string"/>
																																	</content>
																																</children>
																															</editfield>
																															<newline/>
																														</children>
																														<variables/>
																													</template>
																													<condition>
																														<children>
																															<conditionbranch xpath=" @means = &quot;Taxi&quot;">
																																<children>
																																	<template subtype="element" match="Mileage">
																																		<children>
																																			<text fixtext="Mileage: ">
																																				<styles font-family="Arial" font-size="11pt"/>
																																			</text>
																																			<editfield>
																																				<styles font-family="Arial" font-size="11pt"/>
																																				<children>
																																					<content>
																																						<format basic-type="xsd" datatype="decimal"/>
																																					</content>
																																				</children>
																																			</editfield>
																																		</children>
																																		<variables/>
																																	</template>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" @means  = &quot;Limo&quot;">
																																<children>
																																	<template subtype="element" match="Mileage">
																																		<children>
																																			<editfield>
																																				<styles font-family="Arial" font-size="11pt"/>
																																				<children>
																																					<content>
																																						<format basic-type="xsd" datatype="decimal"/>
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
																												<variables/>
																											</template>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath=" @type  = &quot;Parking&quot;">
																										<children>
																											<template subtype="element" match="Parking">
																												<children>
																													<template subtype="element" match="Location">
																														<children>
																															<text fixtext="Location: ">
																																<styles font-family="Arial" font-size="11pt"/>
																															</text>
																															<editfield>
																																<styles font-family="Arial" font-size="11pt"/>
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
																												<variables/>
																											</template>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath=" @type = &quot;Entertainment&quot;">
																										<children>
																											<tgrid>
																												<properties border="0"/>
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
																																		<properties align="center"/>
																																		<styles border-bottom-color="black" border-bottom-style="solid" border-bottom-width="thin"/>
																																		<children>
																																			<text fixtext="Client-name">
																																				<styles font-family="Arial" font-size="11pt"/>
																																			</text>
																																		</children>
																																	</tgridcell>
																																</children>
																															</tgridrow>
																															<template subtype="element" match="Entertainment">
																																<children>
																																	<tgridrow>
																																		<children>
																																			<tgridcell>
																																				<properties bgcolor="#F3F3F3"/>
																																				<children>
																																					<template subtype="element" match="Client-name">
																																						<children>
																																							<content>
																																								<styles font-family="Arial" font-size="11pt"/>
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
																									</conditionbranch>
																									<conditionbranch xpath="@type = &quot;Misc&quot;">
																										<children>
																											<template subtype="element" match="Misc">
																												<children>
																													<template subtype="attribute" match="misctype">
																														<children>
																															<text fixtext="Misc. Type: ">
																																<styles font-family="Arial" font-size="11pt"/>
																															</text>
																															<combobox>
																																<styles font-family="Arial" font-size="11pt"/>
																																<children>
																																	<content>
																																		<format basic-type="xsd" datatype="string"/>
																																	</content>
																																</children>
																																<selectoption description="TeamBuilding" value="TeamBuilding"/>
																																<selectoption description="Tips" value="Tips"/>
																																<selectoption description="Fines" value="Fines"/>
																																<selectoption description="Rental" value="Rental"/>
																																<selectoption description="EverythingElse" value="EverythingElse"/>
																																<selectoption description="Tolls" value="Tolls"/>
																																<selectoption description="Telephone" value="Telephone"/>
																															</combobox>
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
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="description">
																								<children>
																									<paragraph>
																										<children>
																											<content>
																												<styles font-family="Arial" font-size="11pt"/>
																											</content>
																										</children>
																									</paragraph>
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
																						<properties bgcolor="#BBBBBB"/>
																						<styles font-family="Arial Narrow" font-size="10pt"/>
																						<children>
																							<text fixtext=" General Guidelines:"/>
																							<condition>
																								<children>
																									<conditionbranch xpath="@type = &apos;Meal&apos;">
																										<children>
																											<newline/>
																											<list>
																												<styles margin-bottom="0" margin-top="0"/>
																												<children>
																													<listrow>
																														<styles font-family="Arial Narrow" font-size="10pt"/>
																														<children>
																															<text fixtext="Meals should not be expensed to Development, IT, or Support"/>
																														</children>
																													</listrow>
																													<listrow>
																														<styles font-family="Arial Narrow" font-size="10pt"/>
																														<children>
																															<text fixtext="Meals expensed to Accounting require a Detailed report"/>
																														</children>
																													</listrow>
																												</children>
																											</list>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath="@type  = &apos;Lodging&apos;">
																										<children>
																											<list>
																												<styles margin-bottom="0" margin-top="0"/>
																												<children>
																													<listrow>
																														<styles font-size="10pt"/>
																														<children>
																															<text fixtext="Lodging should be expensed to Marketing and Sales only"/>
																														</children>
																													</listrow>
																												</children>
																											</list>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath="@type = &apos;Travel&apos;">
																										<children>
																											<list>
																												<styles margin-bottom="0" margin-top="0"/>
																												<children>
																													<listrow>
																														<styles font-size="10pt"/>
																														<children>
																															<text fixtext="Travel should be expensed to Marketing and Sales only"/>
																														</children>
																													</listrow>
																												</children>
																											</list>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath="@type = &apos;Parking&apos;">
																										<children>
																											<list>
																												<styles margin-bottom="0" margin-top="0"/>
																												<children>
																													<listrow>
																														<styles font-size="10pt"/>
																														<children>
																															<text fixtext="Parking should be expensed to the department of the vehicle&apos;s owner"/>
																														</children>
																													</listrow>
																												</children>
																											</list>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath="@type = &apos;Entertainment&apos;">
																										<children>
																											<list>
																												<styles margin-bottom="0" margin-top="0"/>
																												<children>
																													<listrow>
																														<styles font-size="10pt"/>
																														<children>
																															<text fixtext="Entertainment should not be expensed to Development "/>
																														</children>
																													</listrow>
																												</children>
																											</list>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath="@type = &apos;Misc&apos;">
																										<children>
																											<list>
																												<styles margin-bottom="0" margin-top="0"/>
																												<children>
																													<listrow>
																														<styles font-size="10pt"/>
																														<children>
																															<text fixtext="All Miscellaneous expenses require a detailed report"/>
																														</children>
																													</listrow>
																												</children>
																											</list>
																										</children>
																									</conditionbranch>
																									<conditionbranch/>
																								</children>
																							</condition>
																						</children>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<properties bgcolor="#BBBBBB"/>
																						<styles font-family="Arial Narrow" font-size="10pt"/>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<properties bgcolor="#BBBBBB"/>
																						<styles font-family="Arial Narrow" font-size="10pt"/>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<properties bgcolor="#BBBBBB"/>
																						<styles font-family="Arial Narrow" font-size="10pt"/>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<properties bgcolor="#BBBBBB"/>
																						<styles font-family="Arial Narrow" font-size="10pt"/>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<properties bgcolor="#BBBBBB"/>
																						<styles font-family="Arial Narrow" font-size="10pt"/>
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
											<conditionbranch>
												<children>
													<tgrid>
														<properties border="0" width="100%"/>
														<children>
															<tgridbody-cols>
																<children>
																	<tgridcol>
																		<properties width="16%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="16%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="16%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="12%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="40%"/>
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
																					<text fixtext="Type">
																						<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<text fixtext="Expense To">
																						<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<text fixtext="Date">
																						<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																					</text>
																					<text fixtext=" (">
																						<styles font-family="Arial" font-size="9pt" font-weight="bold"/>
																					</text>
																					<text fixtext="mm/dd/yyyy)">
																						<styles font-family="Arial" font-size="9pt" font-style="italic" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<text fixtext="Expense">
																						<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell/>
																		</children>
																	</tgridrow>
																</children>
															</tgridheader-rows>
															<tgridbody-rows>
																<children>
																	<template subtype="element" match="expense-item">
																		<children>
																			<tgridrow>
																				<properties bgcolor="#E0E0E0"/>
																				<children>
																					<tgridcell>
																						<children>
																							<template subtype="attribute" match="type">
																								<children>
																									<combobox>
																										<children>
																											<content>
																												<format basic-type="xsd" datatype="string"/>
																											</content>
																										</children>
																										<selectoption description="Meal" value="Meal"/>
																										<selectoption description="Lodging" value="Lodging"/>
																										<selectoption description="Travel" value="Travel"/>
																										<selectoption description="Parking" value="Parking"/>
																										<selectoption description="Entertainment" value="Entertainment"/>
																										<selectoption description="Misc" value="Misc"/>
																									</combobox>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="attribute" match="expto">
																								<children>
																									<combobox>
																										<children>
																											<content>
																												<format basic-type="xsd" datatype="string"/>
																											</content>
																										</children>
																										<selectoption description="Development" value="Development"/>
																										<selectoption description="Marketing" value="Marketing"/>
																										<selectoption description="Accounting" value="Accounting"/>
																										<selectoption description="Sales" value="Sales"/>
																										<selectoption description="Operations" value="Operations"/>
																										<selectoption description="Support" value="Support"/>
																										<selectoption description="IT" value="IT"/>
																									</combobox>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<properties align="center"/>
																						<children>
																							<template subtype="element" match="Date">
																								<children>
																									<content>
																										<styles white-space="nowrap"/>
																										<format basic-type="xsd" string="MM/DD/YYYY" datatype="date"/>
																									</content>
																									<text fixtext=" "/>
																									<button>
																										<action>
																											<datepicker/>
																										</action>
																									</button>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<properties align="right"/>
																						<children>
																							<template subtype="element" match="expense">
																								<children>
																									<content>
																										<format basic-type="xsd" string="###,##0.00" datatype="decimal"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																							<text fixtext=" "/>
																							<condition>
																								<children>
																									<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																										<children>
																											<text fixtext="$">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath=" /expense-report/@currency  = &quot;UKP&quot;">
																										<children>
																											<text fixtext="£">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																										<children>
																											<text fixtext="€">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																										<children>
																											<text fixtext="¥">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath=" /expense-report/@currency = &quot;AUD&quot;">
																										<children>
																											<text fixtext="AU$">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</conditionbranch>
																								</children>
																							</condition>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<properties align="left"/>
																						<styles font-family="Arial Narrow" font-size="x-small" white-space="nowrap"/>
																						<children>
																							<condition>
																								<children>
																									<conditionbranch xpath="@type = &apos;Misc&apos;">
																										<children>
																											<list>
																												<styles margin-bottom="0" margin-top="0"/>
																												<children>
																													<listrow>
																														<styles font-family="Arial Narrow" font-size="x-small"/>
																														<children>
																															<text fixtext="All Miscellaneous must be documented by a detailed report">
																																<styles color="red" font-family="Arial Narrow" font-size="x-small"/>
																															</text>
																														</children>
																													</listrow>
																												</children>
																											</list>
																										</children>
																									</conditionbranch>
																								</children>
																							</condition>
																							<condition>
																								<children>
																									<conditionbranch xpath="@type  = &apos;Meal&apos;  and  expense &gt; 500">
																										<children>
																											<list>
																												<styles margin-bottom="0" margin-top="0"/>
																												<children>
																													<listrow>
																														<styles font-family="Arial Narrow" font-size="x-small"/>
																														<children>
																															<text fixtext="All Meals expensed greater than 500 ">
																																<styles color="red" font-family="Arial Narrow" font-size="x-small"/>
																															</text>
																															<condition>
																																<children>
																																	<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																																		<children>
																																			<text fixtext="$">
																																				<styles color="red" font-family="Arial Narrow" font-size="x-small"/>
																																			</text>
																																		</children>
																																	</conditionbranch>
																																	<conditionbranch xpath=" /expense-report/@currency  = &quot;UKP&quot;">
																																		<children>
																																			<text fixtext="£">
																																				<styles color="red" font-family="Arial Narrow" font-size="x-small" font-weight="bold"/>
																																			</text>
																																		</children>
																																	</conditionbranch>
																																	<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																																		<children>
																																			<text fixtext="€">
																																				<styles color="red" font-family="Arial Narrow" font-size="x-small" font-weight="bold"/>
																																			</text>
																																		</children>
																																	</conditionbranch>
																																	<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																																		<children>
																																			<text fixtext="¥">
																																				<styles color="red" font-family="Arial Narrow" font-size="x-small" font-weight="bold"/>
																																			</text>
																																		</children>
																																	</conditionbranch>
																																	<conditionbranch xpath=" /expense-report/@currency = &quot;AUD&quot;">
																																		<children>
																																			<text fixtext="AU">
																																				<styles font-family="Verdana" font-size="x-small" font-weight="bold"/>
																																			</text>
																																			<text fixtext="$">
																																				<styles font-family="Verdana" font-weight="bold"/>
																																			</text>
																																		</children>
																																	</conditionbranch>
																																</children>
																															</condition>
																															<text fixtext=" "/>
																															<text fixtext="requires a detailed report">
																																<styles color="red" font-family="Arial Narrow" font-size="x-small"/>
																															</text>
																														</children>
																													</listrow>
																												</children>
																											</list>
																										</children>
																									</conditionbranch>
																								</children>
																							</condition>
																							<condition>
																								<children>
																									<conditionbranch xpath="@type = &apos;Meal&apos; and  @expto = &apos;Development&apos;">
																										<children>
																											<list>
																												<styles margin-bottom="0" margin-top="0"/>
																												<children>
																													<listrow>
																														<styles font-family="Arial Narrow" font-size="x-small"/>
																														<children>
																															<text fixtext="Meals expensed to developers requires a detailed report">
																																<styles color="red" font-family="Arial Narrow" font-size="x-small"/>
																															</text>
																														</children>
																													</listrow>
																												</children>
																											</list>
																										</children>
																									</conditionbranch>
																								</children>
																							</condition>
																							<condition>
																								<children>
																									<conditionbranch xpath="expense &gt; 999">
																										<children>
																											<list>
																												<styles margin-bottom="0" margin-top="0"/>
																												<children>
																													<listrow>
																														<styles font-family="Arial Narrow" font-size="x-small"/>
																														<children>
																															<text fixtext="One expense can not exceed one thousand ">
																																<styles color="red" font-family="Arial Narrow" font-size="x-small"/>
																															</text>
																															<condition>
																																<children>
																																	<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																																		<children>
																																			<text fixtext="$">
																																				<styles color="red" font-family="Arial Narrow" font-size="x-small"/>
																																			</text>
																																		</children>
																																	</conditionbranch>
																																	<conditionbranch xpath=" /expense-report/@currency  = &quot;UKP&quot;">
																																		<children>
																																			<text fixtext="£">
																																				<styles color="red" font-family="Arial Narrow" font-size="x-small" font-weight="bold"/>
																																			</text>
																																		</children>
																																	</conditionbranch>
																																	<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																																		<children>
																																			<text fixtext="€">
																																				<styles color="red" font-family="Arial Narrow" font-size="x-small" font-weight="bold"/>
																																			</text>
																																		</children>
																																	</conditionbranch>
																																	<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																																		<children>
																																			<text fixtext="¥">
																																				<styles color="red" font-family="Arial Narrow" font-size="x-small" font-weight="bold"/>
																																			</text>
																																		</children>
																																	</conditionbranch>
																																	<conditionbranch xpath=" /expense-report/@currency = &quot;AUD&quot;">
																																		<children>
																																			<text fixtext="AU">
																																				<styles font-family="Verdana" font-size="x-small" font-weight="bold"/>
																																			</text>
																																			<text fixtext="$">
																																				<styles font-family="Verdana" font-weight="bold"/>
																																			</text>
																																		</children>
																																	</conditionbranch>
																																</children>
																															</condition>
																														</children>
																													</listrow>
																												</children>
																											</list>
																										</children>
																									</conditionbranch>
																								</children>
																							</condition>
																							<condition>
																								<children>
																									<conditionbranch xpath="@expto = &apos;Accounting&apos;">
																										<children>
																											<list>
																												<styles margin-bottom="0" margin-top="0"/>
																												<children>
																													<listrow>
																														<styles font-family="Arial Narrow" font-size="x-small"/>
																														<children>
																															<text fixtext="All accounting expenses must have a detailed report">
																																<styles color="red" font-family="Arial Narrow" font-size="x-small"/>
																															</text>
																														</children>
																													</listrow>
																												</children>
																											</list>
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
																					<tgridcell>
																						<properties bgcolor="#BBBBBB"/>
																						<styles font-family="Arial Narrow" font-size="10pt"/>
																						<children>
																							<text fixtext=" General Guidelines:"/>
																							<condition>
																								<children>
																									<conditionbranch xpath="@type = &apos;Meal&apos;">
																										<children>
																											<newline/>
																											<list>
																												<styles margin-bottom="0" margin-top="0"/>
																												<children>
																													<listrow>
																														<styles font-family="Arial Narrow" font-size="10pt"/>
																														<children>
																															<text fixtext="Meals should not be expensed to Development, IT, or Support"/>
																														</children>
																													</listrow>
																													<listrow>
																														<styles font-family="Arial Narrow" font-size="10pt"/>
																														<children>
																															<text fixtext="Meals expensed to Accounting require a Detailed report"/>
																														</children>
																													</listrow>
																												</children>
																											</list>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath="@type  = &apos;Lodging&apos;">
																										<children>
																											<list>
																												<styles margin-bottom="0" margin-top="0"/>
																												<children>
																													<listrow>
																														<styles font-family="Arial Narrow" font-size="10pt"/>
																														<children>
																															<text fixtext="Lodging should be expensed to Marketing and Sales only"/>
																														</children>
																													</listrow>
																												</children>
																											</list>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath="@type = &apos;Travel&apos;">
																										<children>
																											<list>
																												<styles margin-bottom="0" margin-top="0"/>
																												<children>
																													<listrow>
																														<styles font-family="Arial Narrow" font-size="10pt"/>
																														<children>
																															<text fixtext="Travel should be expensed to Marketing and Sales only"/>
																														</children>
																													</listrow>
																												</children>
																											</list>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath="@type = &apos;Parking&apos;">
																										<children>
																											<list>
																												<styles margin-bottom="0" margin-top="0"/>
																												<children>
																													<listrow>
																														<styles font-family="Arial Narrow" font-size="10pt"/>
																														<children>
																															<text fixtext="Parking should be expensed to the department of the vehicle&apos;s owner"/>
																														</children>
																													</listrow>
																												</children>
																											</list>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath="@type = &apos;Entertainment&apos;">
																										<children>
																											<list>
																												<styles margin-bottom="0" margin-top="0"/>
																												<children>
																													<listrow>
																														<styles font-family="Arial Narrow" font-size="10pt"/>
																														<children>
																															<text fixtext="Entertainment should not be expensed to Development "/>
																														</children>
																													</listrow>
																												</children>
																											</list>
																										</children>
																									</conditionbranch>
																									<conditionbranch xpath="@type = &apos;Misc&apos;">
																										<children>
																											<list>
																												<styles margin-bottom="0" margin-top="0"/>
																												<children>
																													<listrow>
																														<styles font-family="Arial Narrow" font-size="10pt"/>
																														<children>
																															<text fixtext="All Miscellaneous expenses require a detailed report"/>
																														</children>
																													</listrow>
																												</children>
																											</list>
																										</children>
																									</conditionbranch>
																									<conditionbranch/>
																								</children>
																							</condition>
																						</children>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<properties bgcolor="#BBBBBB"/>
																						<styles font-family="Arial Narrow" font-size="10pt"/>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<properties bgcolor="#BBBBBB"/>
																						<styles font-family="Arial Narrow" font-size="10pt"/>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<properties bgcolor="#BBBBBB"/>
																						<styles font-family="Arial Narrow" font-size="10pt"/>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<properties bgcolor="#BBBBBB"/>
																						<styles font-family="Arial Narrow" font-size="10pt"/>
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
									<condition>
										<children>
											<conditionbranch xpath="$ShowExpenseSplit">
												<children>
													<tgrid>
														<properties border="0" cellpadding="0" cellspacing="0" width="100%"/>
														<styles border-collapse="collapse" table-layout="fixed"/>
														<children>
															<tgridbody-cols>
																<children>
																	<tgridcol/>
																</children>
															</tgridbody-cols>
															<tgridbody-rows>
																<children>
																	<tgridrow>
																		<styles height="24px"/>
																		<children>
																			<tgridcell>
																				<properties bgcolor="#D2FFFF"/>
																				<styles border-bottom-color="black" border-bottom-style="solid" border-bottom-width="1pt"/>
																				<children>
																					<text fixtext="Expense Split">
																						<styles font-family="Verdana" font-size="14pt"/>
																					</text>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																</children>
															</tgridbody-rows>
														</children>
													</tgrid>
													<tgrid>
														<properties width="100%"/>
														<children>
															<tgridbody-cols>
																<children>
																	<tgridcol>
																		<styles width="1.50in"/>
																	</tgridcol>
																	<tgridcol>
																		<styles width="6in"/>
																	</tgridcol>
																</children>
															</tgridbody-cols>
															<tgridbody-rows>
																<children>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<template subtype="uservariable" match="$ExpenseSplitBy">
																						<children>
																							<radiobutton checkedvalue="type">
																								<children>
																									<content/>
																								</children>
																							</radiobutton>
																							<text fixtext="Type"/>
																						</children>
																						<variables/>
																					</template>
																					<newline/>
																					<template subtype="uservariable" match="$ExpenseSplitBy">
																						<children>
																							<radiobutton checkedvalue="department">
																								<children>
																									<content/>
																								</children>
																							</radiobutton>
																							<text fixtext="Department"/>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<styles text-align="left"/>
																				<children>
																					<chart>
																						<styles height="100px" width="400px"/>
																						<layer>
																							<dataset/>
																							<dataseries-xny-rows for-each="distinct-values(expense-item/( if ($ExpenseSplitBy = &apos;type&apos;) then @type else @expto ) )" x-value="concat( . , &apos; (&apos;, for $i in . return sum($XML//expense-item[( if ($ExpenseSplitBy = &apos;type&apos;) then @type else @expto )=$i]/expense), &apos;)&apos; )" auto-x-value="0">
																								<col y-value="for $i in . return sum($XML//expense-item[( if ($ExpenseSplitBy = &apos;type&apos;) then @type else @expto )=$i]/expense)" y-name="&quot;Series 1&quot;"/>
																							</dataseries-xny-rows>
																							<wizard-data remove-empty-cat="1" remove-empty-ser="1">
																								<wizard-data-categories/>
																								<wizard-data-series/>
																							</wizard-data>
																							<chartsettings>
																								<General SettingsVersion="2" ChartKind="Pie" ShowLegend="0"/>
																								<Pie StartAngle="270."/>
																							</chartsettings>
																							<chartsettings-xpath>
																								<main-properties/>
																								<color-properties/>
																								<colorrange-properties/>
																							</chartsettings-xpath>
																						</layer>
																					</chart>
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
											</conditionbranch>
										</children>
									</condition>
									<tgrid>
										<properties border="0" cellpadding="0" cellspacing="0" width="100%"/>
										<styles border-collapse="collapse" table-layout="fixed"/>
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
																<properties bgcolor="#D2FFFF"/>
																<styles border-bottom-color="black" border-bottom-style="solid" border-bottom-width="1pt"/>
																<children>
																	<text fixtext="Expense Summary">
																		<styles font-family="Verdana" font-size="14pt"/>
																	</text>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
												</children>
											</tgridbody-rows>
										</children>
									</tgrid>
									<tgrid>
										<properties border="0" width="100%"/>
										<styles table-layout="fixed"/>
										<children>
											<tgridbody-cols>
												<children>
													<tgridcol>
														<properties width="100%"/>
													</tgridcol>
												</children>
											</tgridbody-cols>
											<tgridbody-rows>
												<children>
													<tgridrow>
														<children>
															<tgridcell>
																<styles border-color="black" border-style="solid" border-width="1pt"/>
																<children>
																	<condition>
																		<children>
																			<conditionbranch xpath="expense-item/@type = &apos;Parking&apos;">
																				<children>
																					<tgrid>
																						<properties border="0" width="100%"/>
																						<children>
																							<tgridbody-cols>
																								<children>
																									<tgridcol>
																										<properties width="47%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="52%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="1%"/>
																									</tgridcol>
																								</children>
																							</tgridbody-cols>
																							<tgridbody-rows>
																								<children>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt"/>
																												<children>
																													<text fixtext="Total Parking Expenses">
																														<styles font-family="Verdana"/>
																													</text>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<properties align="right"/>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<autocalc xpath="sum(expense-item[@type=&apos;Parking&apos;]/expense)">
																														<styles font-family="Verdana"/>
																														<format basic-type="xsd" string="###,##0.00" datatype="decimal"/>
																													</autocalc>
																													<condition>
																														<children>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																																<children>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;UKP&quot;">
																																<children>
																																	<text fixtext="£">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																																<children>
																																	<text fixtext="€">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																																<children>
																																	<text fixtext="¥">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;AUD&quot;">
																																<children>
																																	<text fixtext="AU">
																																		<styles font-family="Verdana" font-size="x-small" font-weight="bold"/>
																																	</text>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																														</children>
																													</condition>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<styles white-space="nowrap"/>
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
																	<condition>
																		<children>
																			<conditionbranch xpath="expense-item/@type = &apos;Meal&apos;">
																				<children>
																					<tgrid>
																						<properties border="0" width="100%"/>
																						<children>
																							<tgridbody-cols>
																								<children>
																									<tgridcol>
																										<properties width="47%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="52%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="1%"/>
																									</tgridcol>
																								</children>
																							</tgridbody-cols>
																							<tgridbody-rows>
																								<children>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<text fixtext="Total Meal Expenses">
																														<styles font-family="Verdana"/>
																													</text>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<properties align="right"/>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<autocalc xpath="sum(expense-item[@type=&apos;Meal&apos;]/expense)">
																														<styles font-family="Verdana"/>
																														<format basic-type="xsd" string="###,##0.00" datatype="decimal"/>
																													</autocalc>
																													<condition>
																														<children>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																																<children>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;UKP&quot;">
																																<children>
																																	<text fixtext="£">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																																<children>
																																	<text fixtext="€">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																																<children>
																																	<text fixtext="¥">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;AUD&quot;">
																																<children>
																																	<text fixtext="AU">
																																		<styles font-family="Verdana" font-size="x-small" font-weight="bold"/>
																																	</text>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																														</children>
																													</condition>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<styles white-space="nowrap"/>
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
																	<condition>
																		<children>
																			<conditionbranch xpath="expense-item/@type = &apos;Travel&apos;">
																				<children>
																					<tgrid>
																						<properties border="0" width="100%"/>
																						<children>
																							<tgridbody-cols>
																								<children>
																									<tgridcol>
																										<properties width="47%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="52%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="1%"/>
																									</tgridcol>
																								</children>
																							</tgridbody-cols>
																							<tgridbody-rows>
																								<children>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<text fixtext="Total Travel Expenses">
																														<styles font-family="Verdana"/>
																													</text>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<properties align="right"/>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<autocalc xpath="sum(expense-item[@type=&apos;Travel&apos;]/expense)">
																														<styles font-family="Verdana"/>
																														<format basic-type="xsd" string="###,##0.00" datatype="decimal"/>
																													</autocalc>
																													<condition>
																														<children>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																																<children>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;UKP&quot;">
																																<children>
																																	<text fixtext="£">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																																<children>
																																	<text fixtext="€">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																																<children>
																																	<text fixtext="¥">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;AUD&quot;">
																																<children>
																																	<text fixtext="AU">
																																		<styles font-family="Verdana" font-size="x-small" font-weight="bold"/>
																																	</text>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																														</children>
																													</condition>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<styles white-space="nowrap"/>
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
																	<condition>
																		<children>
																			<conditionbranch xpath="expense-item/@type = &apos;Lodging&apos;">
																				<children>
																					<tgrid>
																						<properties border="0" width="100%"/>
																						<children>
																							<tgridbody-cols>
																								<children>
																									<tgridcol>
																										<properties width="47%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="52%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="1%"/>
																									</tgridcol>
																								</children>
																							</tgridbody-cols>
																							<tgridbody-rows>
																								<children>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<text fixtext="Total Lodging Expenses">
																														<styles font-family="Verdana"/>
																													</text>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<properties align="right"/>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<autocalc xpath="sum(expense-item[@type=&apos;Lodging&apos;]/expense)">
																														<styles font-family="Verdana"/>
																														<format basic-type="xsd" string="###,##0.00" datatype="decimal"/>
																													</autocalc>
																													<condition>
																														<children>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																																<children>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;UKP&quot;">
																																<children>
																																	<text fixtext="£">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																																<children>
																																	<text fixtext="€">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																																<children>
																																	<text fixtext="¥">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;AUD&quot;">
																																<children>
																																	<text fixtext="AU">
																																		<styles font-family="Verdana" font-size="x-small" font-weight="bold"/>
																																	</text>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																														</children>
																													</condition>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<styles white-space="nowrap"/>
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
																	<condition>
																		<children>
																			<conditionbranch xpath="expense-item/@type = &apos;Entertainment&apos;">
																				<children>
																					<tgrid>
																						<properties border="0" width="100%"/>
																						<children>
																							<tgridbody-cols>
																								<children>
																									<tgridcol>
																										<properties width="47%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="52%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="1%"/>
																									</tgridcol>
																								</children>
																							</tgridbody-cols>
																							<tgridbody-rows>
																								<children>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<text fixtext="Total Entertainment Expenses">
																														<styles font-family="Verdana"/>
																													</text>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<properties align="right"/>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<autocalc xpath="sum(expense-item[@type=&apos;Entertainment&apos;]/expense)">
																														<styles font-family="Verdana"/>
																														<format basic-type="xsd" string="###,##0.00" datatype="decimal"/>
																													</autocalc>
																													<condition>
																														<children>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																																<children>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;UKP&quot;">
																																<children>
																																	<text fixtext="£">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																																<children>
																																	<text fixtext="€">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																																<children>
																																	<text fixtext="¥">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;AUD&quot;">
																																<children>
																																	<text fixtext="AU">
																																		<styles font-family="Verdana" font-size="x-small" font-weight="bold"/>
																																	</text>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																														</children>
																													</condition>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<styles white-space="nowrap"/>
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
																	<condition>
																		<children>
																			<conditionbranch xpath="expense-item/@type = &apos;Misc&apos;">
																				<children>
																					<tgrid>
																						<properties border="0" width="100%"/>
																						<children>
																							<tgridbody-cols>
																								<children>
																									<tgridcol>
																										<properties width="47%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="52%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="1%"/>
																									</tgridcol>
																								</children>
																							</tgridbody-cols>
																							<tgridbody-rows>
																								<children>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<text fixtext="Total Miscellaneous Expenses">
																														<styles font-family="Verdana"/>
																													</text>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<properties align="right"/>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<autocalc xpath="sum(expense-item[@type=&apos;Misc&apos;]/expense)">
																														<styles font-family="Verdana"/>
																														<format basic-type="xsd" string="###,##0.00" datatype="decimal"/>
																													</autocalc>
																													<condition>
																														<children>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																																<children>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;UKP&quot;">
																																<children>
																																	<text fixtext="£">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																																<children>
																																	<text fixtext="€">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																																<children>
																																	<text fixtext="¥">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;AUD&quot;">
																																<children>
																																	<text fixtext="AU">
																																		<styles font-family="Verdana" font-size="x-small" font-weight="bold"/>
																																	</text>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																														</children>
																													</condition>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<styles white-space="nowrap"/>
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
														</children>
													</tgridrow>
												</children>
											</tgridbody-rows>
										</children>
									</tgrid>
									<tgrid>
										<properties border="0" width="100%"/>
										<styles table-layout="fixed"/>
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
																<styles border-color="black" border-style="solid" border-width="1pt" white-space="nowrap"/>
																<children>
																	<condition>
																		<children>
																			<conditionbranch xpath="expense-item/@expto = &apos;Marketing&apos;">
																				<children>
																					<tgrid>
																						<properties border="0" width="100%"/>
																						<children>
																							<tgridbody-cols>
																								<children>
																									<tgridcol>
																										<properties width="47%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="52%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="1%"/>
																									</tgridcol>
																								</children>
																							</tgridbody-cols>
																							<tgridbody-rows>
																								<children>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<text fixtext="Total Marketing Expenses">
																														<styles font-family="Verdana"/>
																													</text>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<properties align="right"/>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<autocalc xpath="sum(expense-item[@expto=&apos;Marketing&apos;]/expense)">
																														<styles font-family="Verdana"/>
																														<format basic-type="xsd" string="###,##0.00" datatype="decimal"/>
																													</autocalc>
																													<condition>
																														<children>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																																<children>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;UKP&quot;">
																																<children>
																																	<text fixtext="£">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																																<children>
																																	<text fixtext="€">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																																<children>
																																	<text fixtext="¥">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;AUD&quot;">
																																<children>
																																	<text fixtext="AU">
																																		<styles font-family="Verdana" font-size="x-small" font-weight="bold"/>
																																	</text>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																														</children>
																													</condition>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<styles white-space="nowrap"/>
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
																	<condition>
																		<children>
																			<conditionbranch xpath="expense-item/@expto = &apos;Development&apos;">
																				<children>
																					<tgrid>
																						<properties border="0" width="100%"/>
																						<children>
																							<tgridbody-cols>
																								<children>
																									<tgridcol>
																										<properties width="47%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="52%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="1%"/>
																									</tgridcol>
																								</children>
																							</tgridbody-cols>
																							<tgridbody-rows>
																								<children>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<text fixtext="Total Development Expenses">
																														<styles font-family="Verdana"/>
																													</text>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<properties align="right"/>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<autocalc xpath="sum(expense-item[@expto=&apos;Development&apos;]/expense)">
																														<styles font-family="Verdana"/>
																														<format basic-type="xsd" string="###,##0.00" datatype="decimal"/>
																													</autocalc>
																													<condition>
																														<children>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																																<children>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;UKP&quot;">
																																<children>
																																	<text fixtext="£">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																																<children>
																																	<text fixtext="€">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																																<children>
																																	<text fixtext="¥">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;AUD&quot;">
																																<children>
																																	<text fixtext="AU">
																																		<styles font-family="Verdana" font-size="x-small" font-weight="bold"/>
																																	</text>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																														</children>
																													</condition>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<styles white-space="nowrap"/>
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
																	<condition>
																		<children>
																			<conditionbranch xpath="expense-item/@expto = &apos;Accounting&apos;">
																				<children>
																					<tgrid>
																						<properties border="0" width="100%"/>
																						<children>
																							<tgridbody-cols>
																								<children>
																									<tgridcol>
																										<properties width="47%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="52%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="1%"/>
																									</tgridcol>
																								</children>
																							</tgridbody-cols>
																							<tgridbody-rows>
																								<children>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<text fixtext="Total Accounting Expenses">
																														<styles font-family="Verdana"/>
																													</text>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<properties align="right"/>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<autocalc xpath="sum(expense-item[@expto=&apos;Accounting&apos;]/expense)">
																														<styles font-family="Verdana"/>
																														<format basic-type="xsd" string="###,##0.00" datatype="decimal"/>
																													</autocalc>
																													<condition>
																														<children>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																																<children>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;UKP&quot;">
																																<children>
																																	<text fixtext="£">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																																<children>
																																	<text fixtext="€">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																																<children>
																																	<text fixtext="¥">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;AUD&quot;">
																																<children>
																																	<text fixtext="AU">
																																		<styles font-family="Verdana" font-size="x-small" font-weight="bold"/>
																																	</text>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																														</children>
																													</condition>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<styles white-space="nowrap"/>
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
																	<condition>
																		<children>
																			<conditionbranch xpath="expense-item/@expto = &apos;Sales&apos;">
																				<children>
																					<tgrid>
																						<properties border="0" width="100%"/>
																						<children>
																							<tgridbody-cols>
																								<children>
																									<tgridcol>
																										<properties width="47%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="52%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="1%"/>
																									</tgridcol>
																								</children>
																							</tgridbody-cols>
																							<tgridbody-rows>
																								<children>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<text fixtext="Total Sales Expenses">
																														<styles font-family="Verdana"/>
																													</text>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<properties align="right"/>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<autocalc xpath="sum(expense-item[@expto=&apos;Sales&apos;]/expense)">
																														<styles font-family="Verdana"/>
																														<format basic-type="xsd" string="###,##0.00" datatype="decimal"/>
																													</autocalc>
																													<condition>
																														<children>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																																<children>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;UKP&quot;">
																																<children>
																																	<text fixtext="£">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																																<children>
																																	<text fixtext="€">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																																<children>
																																	<text fixtext="¥">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;AUD&quot;">
																																<children>
																																	<text fixtext="AU">
																																		<styles font-family="Verdana" font-size="x-small" font-weight="bold"/>
																																	</text>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																														</children>
																													</condition>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<styles white-space="nowrap"/>
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
																	<condition>
																		<children>
																			<conditionbranch xpath="expense-item/@expto = &apos;Operations&apos;">
																				<children>
																					<tgrid>
																						<properties border="0" width="100%"/>
																						<children>
																							<tgridbody-cols>
																								<children>
																									<tgridcol>
																										<properties width="47%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="52%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="1%"/>
																									</tgridcol>
																								</children>
																							</tgridbody-cols>
																							<tgridbody-rows>
																								<children>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<text fixtext="Total Operations Expenses">
																														<styles font-family="Verdana"/>
																													</text>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<properties align="right"/>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<autocalc xpath="sum(expense-item[@expto=&apos;Operations&apos;]/expense)">
																														<styles font-family="Verdana"/>
																														<format basic-type="xsd" string="###,##0.00" datatype="decimal"/>
																													</autocalc>
																													<condition>
																														<children>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																																<children>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;UKP&quot;">
																																<children>
																																	<text fixtext="£">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																																<children>
																																	<text fixtext="€">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																																<children>
																																	<text fixtext="¥">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;AUD&quot;">
																																<children>
																																	<text fixtext="AU">
																																		<styles font-family="Verdana" font-size="x-small" font-weight="bold"/>
																																	</text>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																														</children>
																													</condition>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<styles white-space="nowrap"/>
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
																	<condition>
																		<children>
																			<conditionbranch xpath="expense-item/@expto = &apos;Support&apos;">
																				<children>
																					<tgrid>
																						<properties border="0" width="100%"/>
																						<children>
																							<tgridbody-cols>
																								<children>
																									<tgridcol>
																										<properties width="47%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="52%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="1%"/>
																									</tgridcol>
																								</children>
																							</tgridbody-cols>
																							<tgridbody-rows>
																								<children>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<text fixtext="Total Support Expenses">
																														<styles font-family="Verdana"/>
																													</text>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<properties align="right"/>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<autocalc xpath="sum(expense-item[@expto=&apos;Support&apos;]/expense)">
																														<styles font-family="Verdana"/>
																														<format basic-type="xsd" string="###,##0.00" datatype="decimal"/>
																													</autocalc>
																													<condition>
																														<children>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																																<children>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;UKP&quot;">
																																<children>
																																	<text fixtext="£">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																																<children>
																																	<text fixtext="€">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																																<children>
																																	<text fixtext="¥">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;AUD&quot;">
																																<children>
																																	<text fixtext="AU">
																																		<styles font-family="Verdana" font-size="x-small" font-weight="bold"/>
																																	</text>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																														</children>
																													</condition>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<styles white-space="nowrap"/>
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
																	<condition>
																		<children>
																			<conditionbranch xpath="expense-item/@expto = &apos;IT&apos;">
																				<children>
																					<tgrid>
																						<properties border="0" width="100%"/>
																						<children>
																							<tgridbody-cols>
																								<children>
																									<tgridcol>
																										<properties width="47%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="52%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="1%"/>
																									</tgridcol>
																								</children>
																							</tgridbody-cols>
																							<tgridbody-rows>
																								<children>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<text fixtext="Total Information Technology Expenses">
																														<styles font-family="Verdana"/>
																													</text>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<properties align="right"/>
																												<styles border-bottom-color="silver" border-bottom-style="solid" border-bottom-width="1pt" white-space="nowrap"/>
																												<children>
																													<autocalc xpath="sum(expense-item[@expto=&apos;IT&apos;]/expense)">
																														<styles font-family="Verdana"/>
																														<format basic-type="xsd" string="###,##0.00" datatype="decimal"/>
																													</autocalc>
																													<condition>
																														<children>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																																<children>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;UKP&quot;">
																																<children>
																																	<text fixtext="£">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																																<children>
																																	<text fixtext="€">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																																<children>
																																	<text fixtext="¥">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																															<conditionbranch xpath=" /expense-report/@currency = &quot;AUD&quot;">
																																<children>
																																	<text fixtext="AU">
																																		<styles font-family="Verdana" font-size="x-small" font-weight="bold"/>
																																	</text>
																																	<text fixtext="$">
																																		<styles font-family="Verdana" font-weight="bold"/>
																																	</text>
																																</children>
																															</conditionbranch>
																														</children>
																													</condition>
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
																		</children>
																	</condition>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
												</children>
											</tgridbody-rows>
										</children>
									</tgrid>
									<tgrid>
										<properties border="0" width="100%"/>
										<styles table-layout="fixed"/>
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
														<children>
															<tgridcell>
																<children>
																	<text fixtext="TOTAL EXPENSES">
																		<styles font-family="Verdana" font-size="medium"/>
																	</text>
																</children>
															</tgridcell>
															<tgridcell>
																<properties align="right"/>
																<children>
																	<autocalc xpath="sum( expense-item/expense  )" update="@total-sum">
																		<styles font-family="Verdana" font-size="medium"/>
																		<format basic-type="xsd" string="###,##0.00" datatype="decimal"/>
																	</autocalc>
																	<condition>
																		<children>
																			<conditionbranch xpath=" /expense-report/@currency  = &quot;USD&quot;">
																				<children>
																					<text fixtext="$">
																						<styles font-family="Verdana" font-weight="bold"/>
																					</text>
																				</children>
																			</conditionbranch>
																			<conditionbranch xpath=" /expense-report/@currency  = &quot;UKP&quot;">
																				<children>
																					<text fixtext="£">
																						<styles font-family="Verdana" font-weight="bold"/>
																					</text>
																				</children>
																			</conditionbranch>
																			<conditionbranch xpath=" /expense-report/@currency  = &quot;Euro&quot;">
																				<children>
																					<text fixtext="€">
																						<styles font-family="Verdana" font-weight="bold"/>
																					</text>
																				</children>
																			</conditionbranch>
																			<conditionbranch xpath=" /expense-report/@currency = &quot;JPY&quot;">
																				<children>
																					<text fixtext="¥">
																						<styles font-family="Verdana" font-weight="bold"/>
																					</text>
																				</children>
																			</conditionbranch>
																			<conditionbranch xpath=" /expense-report/@currency = &quot;AUD&quot;">
																				<children>
																					<text fixtext="AU">
																						<styles font-family="Verdana" font-size="x-small" font-weight="bold"/>
																					</text>
																					<text fixtext="$">
																						<styles font-family="Verdana" font-weight="bold"/>
																					</text>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
												</children>
											</tgridbody-rows>
										</children>
									</tgrid>
									<condition>
										<children>
											<conditionbranch xpath="sum(/expense-report/expense-item/expense)&gt;100">
												<children>
													<tgrid>
														<properties border="0" width="100%"/>
														<styles table-layout="fixed"/>
														<children>
															<tgridbody-cols>
																<children>
																	<tgridcol>
																		<properties width="15%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="85%"/>
																	</tgridcol>
																</children>
															</tgridbody-cols>
															<tgridbody-rows>
																<children>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<properties align="left"/>
																				<children>
																					<text fixtext="This expense report has exceeded ">
																						<styles font-size="10pt"/>
																					</text>
																					<text fixtext="100">
																						<styles font-size="10pt" font-weight="bold"/>
																					</text>
																					<text fixtext=" ">
																						<styles font-size="10pt"/>
																					</text>
																					<template subtype="attribute" match="currency">
																						<editorproperties autoaddname="0" editable="0"/>
																						<children>
																							<content>
																								<styles font-size="10pt"/>
																								<format basic-type="xsd" datatype="string"/>
																							</content>
																						</children>
																						<variables/>
																					</template>
																					<text fixtext=" which under corporate policy requires approval of your direct superior.  All forms must be presented in triplicate and be submitted to the human resources department server in its current XML form.">
																						<styles font-size="10pt"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<styles height="101px"/>
																		<children>
																			<tgridcell>
																				<properties valign="bottom"/>
																				<styles border-color="#D3D3D3" border-style="solid" border-width="1pt"/>
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
																											<tgridcell/>
																										</children>
																									</tgridrow>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<children>
																													<text fixtext="Date"/>
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
																			<tgridcell>
																				<properties valign="bottom"/>
																				<styles border-color="#D3D3D3" border-style="solid" border-width="1pt"/>
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
																											<tgridcell/>
																										</children>
																									</tgridrow>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<children>
																													<text fixtext="Signature"/>
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
											</conditionbranch>
											<conditionbranch/>
										</children>
									</condition>
									<newline/>
								</children>
								<variables/>
							</template>
						</children>
						<variables>
							<variable name="ShowExpenseSplit" value="true()" valuetype="xs:boolean" editable="1"/>
							<variable name="ExpenseSplitBy" value="&apos;type&apos;" valuetype="xs:string" editable="1"/>
						</variables>
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
