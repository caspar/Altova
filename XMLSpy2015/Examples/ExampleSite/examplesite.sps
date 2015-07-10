<?xml version="1.0" encoding="UTF-8"?>
<structure version="14" xsltversion="1" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="UTF-8" encodingpdf="UTF-8" useimportschema="1" embed-images="1" pastemode="xml" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces/>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="site.xsd" workingxmlfile="introduction.xml" templatexmlfile="introduction.xml"/>
		</schemasources>
	</schemasources>
	<modules/>
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
						<properties columncount="1" columngap="48px" headerfooterheight="variable" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="11.69in" papermarginbottom="0.79in" papermarginfooter="0.0in" papermarginheader="0.0in" papermarginleft="0.6in" papermarginright="0.6in" papermargintop="0.79in" paperwidth="8.27in"/>
					</documentsection>
					<template subtype="source" match="XML">
						<children>
							<template subtype="element" match="main">
								<children>
									<template subtype="element" match="pagetitle">
										<children>
											<tgrid>
												<properties width="100%"/>
												<children>
													<tgridbody-cols>
														<children>
															<tgridcol/>
														</children>
													</tgridbody-cols>
													<tgridbody-rows>
														<children>
															<tgridrow>
																<styles height="32px"/>
																<children>
																	<tgridcell>
																		<styles border-top-color="black" border-top-style="dashed" border-top-width="thin" font-family="@Arial Unicode MS" font-size="large" text-transform="capitalize"/>
																		<children>
																			<content>
																				<styles font-weight="bold"/>
																				<format basic-type="xsd" datatype="string"/>
																			</content>
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
									<newline/>
									<tgrid>
										<properties width="100%"/>
										<children>
											<tgridbody-cols>
												<children>
													<tgridcol>
														<properties width="146"/>
													</tgridcol>
													<tgridcol>
														<properties width="502"/>
													</tgridcol>
													<tgridcol/>
												</children>
											</tgridbody-cols>
											<tgridbody-rows>
												<children>
													<tgridrow>
														<children>
															<tgridcell>
																<properties bgColor="black"/>
																<styles color="white"/>
																<children>
																	<text fixtext="NAVIGATION">
																		<styles font-weight="bold"/>
																	</text>
																</children>
															</tgridcell>
															<tgridcell>
																<styles border-top-color="black" border-top-style="solid" border-top-width="thin"/>
																<children>
																	<text fixtext="CONTENT">
																		<styles font-weight="bold"/>
																	</text>
																</children>
															</tgridcell>
															<tgridcell>
																<styles border-right-color="black" border-right-style="solid" border-right-width="thin" border-top-color="black" border-top-style="solid" border-top-width="thin"/>
																<children>
																	<text fixtext="BANNERS">
																		<styles font-weight="bold"/>
																	</text>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<styles height="380px"/>
														<children>
															<tgridcell>
																<properties bgColor="black" valign="top"/>
																<children>
																	<template subtype="element" match="dictionaries">
																		<editorproperties autoaddname="1" editable="0" adding="mandatory"/>
																		<children>
																			<template subtype="element" match="navigation">
																				<children>
																					<template subtype="element" match="menu">
																						<children>
																							<template subtype="element" match="menu">
																								<children>
																									<template subtype="element" match="title">
																										<children>
																											<content>
																												<format basic-type="xsd" datatype="string"/>
																											</content>
																											<newline/>
																										</children>
																										<variables/>
																									</template>
																									<template subtype="element" match="menu">
																										<children>
																											<template subtype="element" match="title">
																												<children>
																													<text fixtext="  -  "/>
																													<content>
																														<format basic-type="xsd" datatype="string"/>
																													</content>
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
																						<variables/>
																					</template>
																				</children>
																				<variables/>
																			</template>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell>
																<properties valign="top"/>
																<styles border-bottom-color="black" border-bottom-style="solid" border-bottom-width="thin"/>
																<children>
																	<template subtype="element" match="dictionaries">
																		<editorproperties autoaddname="1" editable="0" adding="mandatory"/>
																		<children>
																			<template subtype="element" match="blocks">
																				<children>
																					<template subtype="element" match="block_instance">
																						<children>
																							<template subtype="element" match="pagefragment">
																								<children>
																									<content/>
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
																		<variables/>
																	</template>
																	<newline/>
																	<newline/>
																	<newline/>
																	<newline/>
																	<template subtype="element" match="content">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell>
																<styles border-bottom-color="black" border-bottom-style="solid" border-bottom-width="thin" border-right-color="black" border-right-style="solid" border-right-width="thin"/>
																<children>
																	<text fixtext=" "/>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
												</children>
											</tgridbody-rows>
										</children>
									</tgrid>
									<newline/>
									<newline/>
									<newline/>
									<newline/>
									<newline/>
									<newline/>
									<newline/>
									<newline/>
									<tgrid>
										<properties width="100%"/>
										<children>
											<tgridbody-cols>
												<children>
													<tgridcol/>
													<tgridcol>
														<properties width="361"/>
													</tgridcol>
													<tgridcol/>
												</children>
											</tgridbody-cols>
											<tgridbody-rows>
												<children>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<properties bgColor="silver"/>
																<styles border-top-color="black" border-top-style="dashed" border-top-width="thin"/>
																<children>
																	<text fixtext="idref:  "/>
																	<template subtype="element" match="idref">
																		<children>
																			<content>
																				<format basic-type="xsd" datatype="IDREF"/>
																			</content>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell>
																<properties bgColor="silver"/>
																<styles border-top-color="black" border-top-style="dashed" border-top-width="thin"/>
																<children>
																	<text fixtext="titlepage:  "/>
																	<template subtype="element" match="pagetitle">
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
																<properties bgColor="silver"/>
																<styles border-top-color="black" border-top-style="dashed" border-top-width="thin"/>
																<children>
																	<text fixtext="stylesheet:  Altova Build 2"/>
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
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts>
		<children>
			<globaltemplate subtype="element" match="br" schema-tree-path="br">
				<children>
					<template subtype="element" match="br">
						<children>
							<newline/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="img" schema-tree-path="img">
				<children>
					<template subtype="element" match="img">
						<children>
							<image>
								<properties border="0"/>
								<target>
									<xpath value="@src"/>
								</target>
							</image>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="links" schema-tree-path="links">
				<children>
					<template subtype="element" match="links">
						<children>
							<content/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="list" schema-tree-path="list">
				<children>
					<template subtype="element" match="list">
						<children>
							<list>
								<styles margin-bottom="0" margin-top="0"/>
								<children>
									<listrow>
										<children>
											<content/>
										</children>
									</listrow>
								</children>
							</list>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="menu" schema-tree-path="menu">
				<children>
					<template subtype="element" match="menu">
						<children>
							<tgrid>
								<properties border="1" width="50%"/>
								<children>
									<tgridbody-cols>
										<children>
											<tgridcol/>
											<tgridcol>
												<properties width="552"/>
											</tgridcol>
										</children>
									</tgridbody-cols>
									<tgridbody-rows>
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties align="left" valign="top"/>
														<styles width="243px" />
														<children>
															<tgrid>
																<properties bgcolor="silver" width="50%"/>
																<children>
																	<tgridbody-cols>
																		<children>
																			<tgridcol>
																				<properties width="224"/>
																			</tgridcol>
																			<tgridcol>
																				<properties width="288"/>
																			</tgridcol>
																			<tgridcol>
																				<properties width="159"/>
																			</tgridcol>
																		</children>
																	</tgridbody-cols>
																	<tgridbody-rows>
																		<children>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<properties align="center"/>
																						<styles border-bottom-color="black" border-bottom-style="double" border-bottom-width="thin" width="384px"/>
																						<children>
																							<text fixtext="MENU LINK"/>
																						</children>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<properties align="center"/>
																						<styles border-bottom-color="black" border-bottom-style="double" border-bottom-width="thin" width="384px"/>
																					</tgridcell>
																					<tgridcell/>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<styles white-space="pre"/>
																						<children>
																							<text fixtext="TITLE:"/>
																							<template subtype="element" match="title">
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
																							<text fixtext="URL:"/>
																							<template subtype="element" match="url">
																								<children>
																									<content>
																										<format basic-type="xsd" datatype="string"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell/>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<children>
																							<text fixtext="IDREF"/>
																							<template subtype="element" match="idref">
																								<children>
																									<content>
																										<format basic-type="xsd" datatype="IDREF"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell/>
																					<tgridcell/>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<properties align="center"/>
																						<children>
																							<text fixtext="TITLE2"/>
																							<template subtype="element" match="title">
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
																						<properties align="center"/>
																					</tgridcell>
																					<tgridcell>
																						<properties align="center"/>
																					</tgridcell>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<children>
																							<text fixtext="ID"/>
																							<template subtype="element" match="id">
																								<children>
																									<content>
																										<format basic-type="xsd" datatype="ID"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<text fixtext="LINKIDREF"/>
																							<template subtype="element" match="link_idref">
																								<children>
																									<content>
																										<format basic-type="xsd" datatype="IDREF"/>
																									</content>
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
													</tgridcell>
													<tgridcell>
														<properties align="left" valign="top"/>
														<styles vertical-Align="super"/>
														<children>
															<template subtype="element" match="menu">
																<children>
																	<list>
																		<styles margin-bottom="0" margin-top="0"/>
																		<children>
																			<listrow>
																				<styles vertical-Align="super"/>
																				<children>
																					<tgrid>
																						<properties border="1"/>
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
																												<styles vertical-Align="super"/>
																												<children>
																													<content/>
																												</children>
																											</tgridcell>
																										</children>
																									</tgridrow>
																								</children>
																							</tgridbody-rows>
																						</children>
																					</tgrid>
																				</children>
																			</listrow>
																		</children>
																	</list>
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
			</globaltemplate>
			<globaltemplate subtype="element" match="navigation" schema-tree-path="navigation">
				<children>
					<template subtype="element" match="navigation">
						<children>
							<content/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="para" schema-tree-path="para">
				<children>
					<template subtype="element" match="para">
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
			</globaltemplate>
		</children>
	</globalparts>
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
