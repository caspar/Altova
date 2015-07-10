<?xml version="1.0" encoding="UTF-8"?>
<structure version="14" xsltversion="1" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="UTF-8" encodingpdf="UTF-8" useimportschema="1" embed-images="1" pastemode="xml" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces/>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="site.xsd" workingxmlfile="navigation.xml" templatexmlfile="navigation.xml"/>
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
							<tgrid>
								<properties width="90%"/>
								<children>
									<tgridbody-cols>
										<children>
											<tgridcol/>
											<tgridcol/>
										</children>
									</tgridbody-cols>
									<tgridbody-rows>
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<children>
															<content/>
														</children>
													</tgridcell>
													<tgridcell>
														<properties valign="top"/>
														<children>
															<tgrid>
																<properties border="1" width="100%"/>
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
																						<properties valign="top"/>
																						<children>
																							<text fixtext="This is a graphical layout of the navigation of the the site. This is not to be an editable file, rather an guide to create valid documents.  The &quot;top&quot; elements are strictly the root elements that contains the structure of each branch.  They represent the menu items that contain the links to each page.  Each page is reprensented with an html icon, for visual reference."/>
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
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts>
		<children>
			<globaltemplate subtype="element" match="menu" schema-tree-path="menu">
				<children>
					<template subtype="element" match="menu">
						<editorproperties autoaddname="1" editable="0" adding="mandatory" markupmode="hide"/>
						<children>
							<tgrid>
								<properties width="75%"/>
								<children>
									<tgridbody-cols>
										<children>
											<tgridcol>
												<properties width="201"/>
											</tgridcol>
											<tgridcol>
												<properties width="176"/>
											</tgridcol>
										</children>
									</tgridbody-cols>
									<tgridbody-rows>
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties align="left"/>
														<styles border-bottom-color="black" border-bottom-style="solid" border-bottom-width="thin"/>
														<children>
															<tgrid>
																<properties width="100%"/>
																<children>
																	<tgridbody-cols>
																		<children>
																			<tgridcol/>
																			<tgridcol>
																				<properties width="176"/>
																			</tgridcol>
																		</children>
																	</tgridbody-cols>
																	<tgridbody-rows>
																		<children>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<properties align="center" valign="top"/>
																						<children>
																							<template subtype="element" match="url">
																								<children>
																									<image>
																										<properties border="0"/>
																										<target>
																											<fixtext value="html_icon.bmp"/>
																										</target>
																									</image>
																								</children>
																								<variables/>
																							</template>
																							<newline/>
																							<template subtype="element" match="url">
																								<children>
																									<content>
																										<format basic-type="xsd" datatype="string"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																							<newline/>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<properties align="right"/>
																						<children>
																							<tgrid>
																								<properties width="100%"/>
																								<children>
																									<tgridbody-cols>
																										<children>
																											<tgridcol>
																												<properties width="51"/>
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
																															<text fixtext="Title"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
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
																												</children>
																											</tgridrow>
																											<tgridrow>
																												<children>
																													<tgridcell>
																														<children>
																															<text fixtext="ID"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
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
																												</children>
																											</tgridrow>
																											<tgridrow>
																												<children>
																													<tgridcell>
																														<children>
																															<text fixtext="URL"/>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<children>
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
													</tgridcell>
													<tgridcell joinleft="1">
														<properties align="left"/>
														<styles border-bottom-color="black" border-bottom-style="solid" border-bottom-width="thin"/>
													</tgridcell>
												</children>
											</tgridrow>
											<tgridrow>
												<children>
													<tgridcell/>
													<tgridcell>
														<children>
															<content restofcontents="1"/>
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
		</children>
	</globalparts>
	<designfragments/>
	<xmltables/>
	<authentic-custom-toolbar-buttons/>
</structure>
