<?xml version="1.0" encoding="UTF-8"?>
<structure version="15" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="UTF-8" encodingpdf="UTF-8" useimportschema="1" embed-images="1" pastemode="xml" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces/>
		<schemasources>
			<dbschemasource name="DB" main="1">
				<database_connection database_kind="MS Access" import_kind="ADO" version="04.00.0000" name="altova" active="1" use_driver_for_retrieval="1" allow_background_retrieval="0">
					<properties>
						<property name="Database Kind" value="MS Access"/>
						<property name="Import Kind" value="ADO"/>
						<property name="Root Object" value="altova"/>
						<property name="Data Source" value="Import\altova.mdb"/>
						<property name="Provider" value="Microsoft.Jet.OLEDB.4.0"/>
						<property name="User ID"/>
						<property name="Password"/>
						<property name="Persist Security Info"/>
						<property name="Jet OLEDB:System Database"/>
						<property name="Jet OLEDB:Sandbox Mode"/>
						<property name="Jet OLEDB:Exclusive Async Delay"/>
						<property name="Jet OLEDB:Flush Transaction Timeout"/>
						<property name="Jet OLEDB:Implicit Commit Sync"/>
						<property name="Jet OLEDB:Lock Delay"/>
						<property name="Jet OLEDB:Lock Retry"/>
						<property name="Jet OLEDB:Max Buffer Size"/>
						<property name="Jet OLEDB:Max Locks Per File"/>
						<property name="Jet OLEDB:Page Locks to Table Lock"/>
						<property name="Jet OLEDB:Page Timeout"/>
						<property name="Jet OLEDB:Recycle Long-Valued Pages"/>
						<property name="Jet OLEDB:Shared Async Delay"/>
						<property name="Jet OLEDB:User Commit Sync"/>
						<property name="Jet OLEDB:Compact Without Replica Repair"/>
						<property name="Jet OLEDB:Create System Database"/>
						<property name="Jet OLEDB:Database Locking Mode"/>
						<property name="Jet OLEDB:Database Password"/>
						<property name="Jet OLEDB:New Database Password"/>
						<property name="Jet OLEDB:Registry Path"/>
					</properties>
					<LocalViewStorage/>
					<LocalRelationsStorage/>
				</database_connection>
				<dbselectedtablesandviews>
					<dbobject>
						<PathElement Name="altova" Kind="DataSource"/>
						<PathElement Name="altova" Kind="Database"/>
						<PathElement Name="Address" Kind="Table"/>
					</dbobject>
					<dbobject>
						<PathElement Name="altova" Kind="DataSource"/>
						<PathElement Name="altova" Kind="Database"/>
						<PathElement Name="Altova" Kind="Table"/>
					</dbobject>
					<dbobject>
						<PathElement Name="altova" Kind="DataSource"/>
						<PathElement Name="altova" Kind="Database"/>
						<PathElement Name="Department" Kind="Table"/>
					</dbobject>
					<dbobject>
						<PathElement Name="altova" Kind="DataSource"/>
						<PathElement Name="altova" Kind="Database"/>
						<PathElement Name="Office" Kind="Table"/>
					</dbobject>
					<dbobject>
						<PathElement Name="altova" Kind="DataSource"/>
						<PathElement Name="altova" Kind="Database"/>
						<PathElement Name="Person" Kind="Table"/>
					</dbobject>
				</dbselectedtablesandviews>
				<FilterCollection>
					<FilterCollectionElement>
						<FilterPathPair>
							<PathInfo>
								<Path>
									<PathElement Name="altova" Kind="DataSource"/>
									<PathElement Name="altova" Kind="Database"/>
									<PathElement Name="Address" Kind="Table"/>
								</Path>
							</PathInfo>
							<Filter/>
						</FilterPathPair>
					</FilterCollectionElement>
					<FilterCollectionElement>
						<FilterPathPair>
							<PathInfo>
								<Path>
									<PathElement Name="altova" Kind="DataSource"/>
									<PathElement Name="altova" Kind="Database"/>
									<PathElement Name="Department" Kind="Table"/>
								</Path>
							</PathInfo>
							<Filter/>
						</FilterPathPair>
					</FilterCollectionElement>
					<FilterCollectionElement>
						<FilterPathPair>
							<PathInfo>
								<Path>
									<PathElement Name="altova" Kind="DataSource"/>
									<PathElement Name="altova" Kind="Database"/>
									<PathElement Name="Office" Kind="Table"/>
								</Path>
							</PathInfo>
							<Filter/>
						</FilterPathPair>
					</FilterCollectionElement>
					<FilterCollectionElement>
						<FilterPathPair>
							<PathInfo>
								<Path>
									<PathElement Name="altova" Kind="DataSource"/>
									<PathElement Name="altova" Kind="Database"/>
									<PathElement Name="Person" Kind="Table"/>
								</Path>
							</PathInfo>
							<Filter/>
						</FilterPathPair>
					</FilterCollectionElement>
				</FilterCollection>
			</dbschemasource>
		</schemasources>
	</schemasources>
	<modules/>
	<flags>
		<scripts/>
		<mainparts/>
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
						<properties columncount="1" columngap="0.50in" headerfooterheight="variable" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="1" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.3in" papermarginheader="0.3in" papermarginleft="0.6in" papermarginright="0.6in" papermargintop="0.79in" paperwidth="8.5in"/>
					</documentsection>
					<template subtype="source" match="DB">
						<children>
							<template subtype="db" match="DB">
								<children>
									<template subtype="dbtable" match="Office">
										<editorproperties autoaddname="1" editable="1" adding="mandatory" elementstodisplay="1" markupmode="hide"/>
										<children>
											<button>
												<action>
													<dbcontrol dbcontroltype="first"/>
												</action>
											</button>
											<button>
												<action>
													<dbcontrol dbcontroltype="prev"/>
												</action>
											</button>
											<button>
												<action>
													<dbcontrol/>
												</action>
											</button>
											<button>
												<action>
													<dbcontrol dbcontroltype="last"/>
												</action>
											</button>
											<text fixtext=" "/>
											<button>
												<action>
													<dbcontrol dbcontroltype="qry"/>
												</action>
											</button>
											<newline/>
											<template subtype="dbrow" match="Row">
												<editorproperties autoaddname="1" editable="1" adding="mandatory" markupmode="hide"/>
												<children>
													<template subtype="dbfield" match="Name">
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
													<template subtype="dbtable" match="Address">
														<editorproperties elementstodisplay="1"/>
														<children>
															<template subtype="dbrow" match="Row">
																<editorproperties autoaddname="1" editable="1" adding="mandatory" markupmode="hide"/>
																<children>
																	<tgrid>
																		<properties border="0"/>
																		<styles width="100%"/>
																		<children>
																			<tgridbody-cols>
																				<children>
																					<tgridcol>
																						<styles width="20%"/>
																					</tgridcol>
																					<tgridcol>
																						<styles width="80%"/>
																					</tgridcol>
																				</children>
																			</tgridbody-cols>
																			<tgridbody-rows>
																				<children>
																					<tgridrow>
																						<children>
																							<tgridcell>
																								<children>
																									<text fixtext="City:"/>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<template subtype="dbfield" match="city">
																										<children>
																											<editfield>
																												<properties size="40"/>
																												<styles font-weight="bold"/>
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
																									<text fixtext="State:"/>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<template subtype="dbfield" match="state">
																										<children>
																											<editfield>
																												<properties size="40"/>
																												<styles font-weight="bold"/>
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
																									<text fixtext="Street:"/>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<template subtype="dbfield" match="street">
																										<children>
																											<editfield>
																												<properties size="40"/>
																												<styles font-weight="bold"/>
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
																									<text fixtext="Zip Code:"/>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<template subtype="dbfield" match="zip">
																										<children>
																											<editfield>
																												<properties size="40"/>
																												<styles font-weight="bold"/>
																												<children>
																													<content>
																														<format basic-type="xsd" datatype="int"/>
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
																<variables/>
															</template>
														</children>
														<variables/>
													</template>
													<newline/>
													<newline/>
													<template subtype="dbtable" match="Department">
														<editorproperties autoaddname="1" editable="1" adding="mandatory" markupmode="hide"/>
														<children>
															<template subtype="dbrow" match="Row">
																<editorproperties autoaddname="1" editable="1" adding="mandatory" markupmode="hide"/>
																<children>
																	<template subtype="dbfield" match="Name">
																		<children>
																			<content>
																				<styles color="#D39658" font-family="Arial" font-weight="bold"/>
																				<format basic-type="xsd" datatype="string"/>
																			</content>
																		</children>
																		<variables/>
																	</template>
																	<text fixtext=" "/>
																	<template subtype="dbtable" match="Person">
																		<editorproperties autoaddname="1" editable="1" adding="mandatory" elementstodisplay="2" markupmode="hide"/>
																		<children>
																			<button>
																				<action>
																					<dbcontrol dbcontroltype="first"/>
																				</action>
																			</button>
																			<button>
																				<action>
																					<dbcontrol dbcontroltype="prev"/>
																				</action>
																			</button>
																			<button>
																				<action>
																					<dbcontrol dbcontroltype="goto"/>
																				</action>
																			</button>
																			<button>
																				<action>
																					<dbcontrol/>
																				</action>
																			</button>
																			<button>
																				<action>
																					<dbcontrol dbcontroltype="last"/>
																				</action>
																			</button>
																			<tgrid>
																				<properties border="1" width="100%"/>
																				<children>
																					<tgridbody-cols>
																						<children>
																							<tgridcol>
																								<styles width="10%"/>
																							</tgridcol>
																							<tgridcol>
																								<styles width="15%"/>
																							</tgridcol>
																							<tgridcol>
																								<styles width="15%"/>
																							</tgridcol>
																							<tgridcol>
																								<styles width="25%"/>
																							</tgridcol>
																							<tgridcol>
																								<styles width="10%"/>
																							</tgridcol>
																							<tgridcol>
																								<styles width="25%"/>
																							</tgridcol>
																						</children>
																					</tgridbody-cols>
																					<tgridheader-rows>
																						<children>
																							<tgridrow>
																								<properties bgcolor="#D2C8AE"/>
																								<styles height="0.28in"/>
																								<children>
																									<tgridcell>
																										<properties align="center"/>
																										<children>
																											<text fixtext="PK">
																												<styles color="#606060" font-family="Arial" font-weight="bold"/>
																											</text>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<properties align="center"/>
																										<children>
																											<text fixtext="First">
																												<styles color="#606060" font-family="Arial" font-weight="bold"/>
																											</text>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<properties align="center"/>
																										<children>
																											<text fixtext="Last">
																												<styles color="#606060" font-family="Arial" font-weight="bold"/>
																											</text>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<properties align="center"/>
																										<children>
																											<text fixtext="Title">
																												<styles color="#606060" font-family="Arial" font-weight="bold"/>
																											</text>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<properties align="center"/>
																										<children>
																											<text fixtext="Ext">
																												<styles color="#606060" font-family="Arial" font-weight="bold"/>
																											</text>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<properties align="center"/>
																										<children>
																											<text fixtext="EMail">
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
																							<template subtype="dbrow" match="Row">
																								<editorproperties autoaddname="1" editable="1" adding="mandatory"/>
																								<children>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<children>
																													<template subtype="dbfield" match="PrimaryKey">
																														<children>
																															<content>
																																<styles font-size="10pt"/>
																																<format basic-type="xsd" datatype="int"/>
																															</content>
																														</children>
																														<variables/>
																													</template>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<children>
																													<template subtype="dbfield" match="First">
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
																												<children>
																													<template subtype="dbfield" match="Last">
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
																												<children>
																													<template subtype="dbfield" match="Title">
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
																												<children>
																													<template subtype="dbfield" match="PhoneExt">
																														<children>
																															<content>
																																<styles font-size="10pt"/>
																																<format basic-type="xsd" datatype="int"/>
																															</content>
																														</children>
																														<variables/>
																													</template>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<children>
																													<template subtype="dbfield" match="EMail">
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
																	<condition>
																		<children>
																			<conditionbranch xpath="position() != last()">
																				<children>
																					<newline/>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																</children>
																<variables/>
															</template>
														</children>
														<variables/>
													</template>
													<newline/>
													<condition>
														<children>
															<conditionbranch xpath="position() != last()">
																<children>
																	<newline break="page"/>
																</children>
															</conditionbranch>
														</children>
													</condition>
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
	<designfragments/>
	<xmltables/>
	<authentic-custom-toolbar-buttons/>
</structure>
