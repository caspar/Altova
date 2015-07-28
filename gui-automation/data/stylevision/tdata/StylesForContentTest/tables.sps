<?xml version="1.0" encoding="UTF-8"?>
<structure version="14" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" pastemode="xml" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces/>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="Data.xsd" workingxmlfile="Data.xml"/>
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
	<globalstyles>
		<rules selector=".info">
			<media>
				<media value="all"/>
			</media>
			<rule background-color="#f6f6ff" border="1px solid navy" color="navy" font-weight="bold" margin-bottom="12px" margin-top="12px" padding="2px"/>
		</rules>
		<rules selector=".explanation">
			<media>
				<media value="all"/>
			</media>
			<rule color="blue" font-style="italic" margin-bottom="12px"/>
		</rules>
	</globalstyles>
	<mainparts>
		<children>
			<globaltemplate subtype="main" match="/">
				<document-properties/>
				<children>
					<documentsection>
						<properties columncount="1" columngap="0.50in" headerfooterheight="variable" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="11.69in" papermarginbottom="0.79in" papermarginfooter="0.0in" papermarginheader="0.0in" papermarginleft="0.6in" papermarginright="0.6in" papermargintop="0.79in" paperwidth="8.27in"/>
					</documentsection>
					<paragraph paragraphtag="h2">
						<styles border-bottom="2px solid navy" color="navy"/>
						<children>
							<text fixtext="Example: Tables"/>
						</children>
					</paragraph>
					<paragraph paragraphtag="p">
						<properties class="info"/>
						<children>
							<text fixtext="Tables in StyleVision can be both "/>
							<text fixtext="static">
								<styles font-style="italic"/>
							</text>
							<text fixtext=" and "/>
							<text fixtext="dynamic">
								<styles font-style="italic"/>
							</text>
							<text fixtext=". Static tables are fixed in size, while dynamic tables grow with the number of elements contained in the XML file."/>
						</children>
					</paragraph>
					<template subtype="source" match="XML">
						<children>
							<paragraph paragraphtag="p">
								<properties class="explanation"/>
								<children>
									<text fixtext="A static table (insert either via the context menu, or using the &quot;Table&quot; menu or toolbar)"/>
								</children>
							</paragraph>
							<tgrid>
								<properties border="1" width="100%"/>
								<children>
									<tgridbody-cols>
										<children>
											<tgridcol/>
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
															<text fixtext="1"/>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<text fixtext="2"/>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<text fixtext="3"/>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
											<tgridrow>
												<children>
													<tgridcell>
														<children>
															<text fixtext="4"/>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<text fixtext="5"/>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<text fixtext="6"/>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
										</children>
									</tgridbody-rows>
								</children>
							</tgrid>
							<paragraph paragraphtag="p">
								<properties class="explanation"/>
								<children>
									<text fixtext="Dynamic tables are created by dragging the element (or elements) for which to create table rows (the &apos;number&apos; element in the examples here) from the schema tree into the design and choosing &quot;Create Table...&quot; from the menu. In the examples below, all templates up to &apos;numbers&apos; were already existing, so the newly created tables will iterate over the &apos;number&apos; elements only, which is also evident by the template markup placement."/>
								</children>
							</paragraph>
							<paragraph paragraphtag="p">
								<properties class="explanation"/>
								<children>
									<text fixtext="A dynamic table that grows vertically:"/>
								</children>
							</paragraph>
							<template subtype="element" match="data">
								<children>
									<template subtype="element" match="numbers">
										<children>
											<tgrid>
												<properties border="1"/>
												<styles width="100%"/>
												<children>
													<tgridbody-cols>
														<children>
															<tgridcol/>
															<tgridcol/>
														</children>
													</tgridbody-cols>
													<tgridheader-rows>
														<children>
															<tgridrow>
																<styles font-weight="bold"/>
																<children>
																	<tgridcell>
																		<styles background-color="#e9ffe9" text-align="left"/>
																		<children>
																			<text fixtext="Text"/>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<properties align="right"/>
																		<styles background-color="#e9ffe9" text-align="right"/>
																		<children>
																			<text fixtext="Value"/>
																		</children>
																	</tgridcell>
																</children>
															</tgridrow>
														</children>
													</tgridheader-rows>
													<tgridbody-rows>
														<children>
															<template subtype="element" match="number">
																<children>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<styles text-align="left"/>
																				<children>
																					<text fixtext="contents of the @value attribute:"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<styles text-align="right"/>
																				<children>
																					<template subtype="attribute" match="value">
																						<children>
																							<content>
																								<format basic-type="xsd" datatype="decimal"/>
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
													<tgridfooter-rows>
														<children>
															<tgridrow>
																<styles font-weight="bold"/>
																<children>
																	<tgridcell>
																		<properties align="center"/>
																		<styles background-color="#e9ffe9" text-align="left"/>
																		<children>
																			<text fixtext="Total:"/>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<styles background-color="#e9ffe9" text-align="right"/>
																		<children>
																			<autocalc xpath="sum(number/@value)"/>
																		</children>
																	</tgridcell>
																</children>
															</tgridrow>
														</children>
													</tgridfooter-rows>
												</children>
											</tgrid>
										</children>
										<variables/>
									</template>
								</children>
								<variables/>
							</template>
							<paragraph paragraphtag="p">
								<properties class="explanation"/>
								<children>
									<text fixtext="A dynamic table that grows horizontally:"/>
								</children>
							</paragraph>
							<template subtype="element" match="data">
								<children>
									<template subtype="element" match="numbers">
										<children>
											<tgrid>
												<properties border="1"/>
												<styles text-align="right" width="100%"/>
												<children>
													<tgridbody-cols>
														<children>
															<tgridcol/>
															<template subtype="element" match="number">
																<children>
																	<tgridcol/>
																</children>
																<variables/>
															</template>
															<tgridcol/>
														</children>
													</tgridbody-cols>
													<tgridbody-rows>
														<children>
															<tgridrow>
																<children>
																	<tgridcell>
																		<styles background-color="#e9ffe9"/>
																		<children>
																			<text fixtext="Values:"/>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<children>
																			<template subtype="attribute" match="value">
																				<children>
																					<content>
																						<format basic-type="xsd" datatype="decimal"/>
																					</content>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<styles background-color="#e9ffe9" font-weight="bold"/>
																		<children>
																			<autocalc xpath="sum(number/@value)"/>
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
