<?xml version="1.0" encoding="UTF-8"?>
<structure version="14" xsltversion="1" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="UTF-8" encodingpdf="UTF-8" useimportschema="1" embed-images="1" pastemode="xml" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces/>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="site.xsd" workingxmlfile="blocks.xml" templatexmlfile="blocks.xml"/>
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
								<children>
									<tgridbody-cols>
										<children>
											<tgridcol>
												<properties width="643"/>
											</tgridcol>
										</children>
									</tgridbody-cols>
									<tgridbody-rows>
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<styles border-bottom-color="black" border-bottom-style="solid" border-bottom-width="thin"/>
														<children>
															<text fixtext="These are the &quot;blocks&quot; of the website.  They contain the chucks of content that are to populate the sections of the website.  Each xml file representing a webpage have the option of inserting these preformated parts, for the ability to change data on a site without editing each page individually."/>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
										</children>
									</tgridbody-rows>
								</children>
							</tgrid>
							<template subtype="element" match="blocks">
								<children>
									<tgrid>
										<properties border="1"/>
										<children>
											<tgridbody-cols>
												<children>
													<tgridcol>
														<properties width="200"/>
													</tgridcol>
													<tgridcol>
														<properties width="354"/>
													</tgridcol>
												</children>
											</tgridbody-cols>
											<tgridheader-rows>
												<children>
													<tgridrow>
														<children>
															<tgridcell>
																<properties align="center"/>
																<children>
																	<text fixtext="ID">
																		<styles font-weight="bold"/>
																	</text>
																</children>
															</tgridcell>
															<tgridcell>
																<properties align="center"/>
																<children>
																	<text fixtext="Page Fragment">
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
													<template subtype="element" match="block_instance">
														<children>
															<tgridrow>
																<children>
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
																	<tgridcell>
																		<children>
																			<template subtype="element" match="pagefragment">
																				<children>
																					<content/>
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
							<newline/>
							<newline/>
							<newline/>
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
			<globaltemplate subtype="element" match="header" schema-tree-path="header">
				<children>
					<template subtype="element" match="header">
						<children>
							<content>
								<styles font-size="large" font-style="italic" font-weight="bold"/>
								<format basic-type="xsd" datatype="anyType"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="id" schema-tree-path="id">
				<children>
					<template subtype="element" match="id">
						<children>
							<content>
								<styles font-style="italic"/>
								<format basic-type="xsd" datatype="ID"/>
							</content>
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
			<globaltemplate subtype="element" match="list" schema-tree-path="list">
				<children>
					<template subtype="element" match="list">
						<children>
							<list>
								<styles margin-bottom="0" margin-top="0"/>
								<children>
									<template subtype="element" match="listitem">
										<children>
											<listrow>
												<children>
													<content/>
												</children>
											</listrow>
										</children>
										<variables/>
									</template>
								</children>
							</list>
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
			<globaltemplate subtype="element" match="url" schema-tree-path="url">
				<children>
					<template subtype="element" match="url">
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
									<xpath value="."/>
								</hyperlink>
							</link>
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
	<authentic-custom-toolbar-buttons>
		<textstateicon match="header" iconfile="header.bmp"/>
		<textstateicon match="para" iconfile="para.bmp"/>
	</authentic-custom-toolbar-buttons>
</structure>
