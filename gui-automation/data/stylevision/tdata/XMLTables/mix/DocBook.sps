<?xml version="1.0" encoding="UTF-8"?>
<structure version="12" htmlmode="strict" relativeto="*XML" encodinghtml="UTF-8" encodingrtf="UTF-8" encodingpdf="UTF-8" useimportschema="1" embed-images="1" pastemode="xml" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters>
		<parameter name="show-info" default="true"/>
	</parameters>
	<schemasources>
		<namespaces/>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="http://www.altova.com/schemas/docbook/docbookx.dtd"/>
		</schemasources>
	</schemasources>
	<modules/>
	<flags>
		<scripts/>
		<globalparts/>
		<designfragments/>
		<pagelayouts/>
	</flags>
	<scripts>
		<script language="javascript"/>
	</scripts>
	<script-project>
		<Project version="1" app="AuthenticView"/>
	</script-project>
	<importedxslt/>
	<globalstyles>
		<rules selector=".info">
			<media>
				<media value="all"/>
			</media>
			<rule background-color="#f6f6ff" border="1px solid navy" color="navy" margin-bottom="12px" margin-top="12px" padding="2px"/>
		</rules>
		<rules selector=".inlineinfo">
			<media>
				<media value="all"/>
			</media>
			<rule background-color="#f6f6ff" border="1px solid navy" color="navy" display="inline"/>
		</rules>
	</globalstyles>
	<mainparts>
		<children>
			<globaltemplate subtype="main" match="/">
				<children>
					<documentsection>
						<properties columncount="1" columngap="0.50in" headerfooterheight="variable" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="1" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.0in" papermarginheader="0.0in" papermarginleft="0.6in" papermarginright="0.6in" papermargintop="0.79in" paperwidth="8.5in"/>
						<children>
							<globaltemplate subtype="pagelayout" match="footerall">
								<children>
									<paragraph>
										<styles border-top="1px solid black" text-align="center"/>
										<children>
											<text fixtext="-">
												<styles font-size="10pt"/>
											</text>
											<field>
												<styles font-size="10pt"/>
											</field>
											<text fixtext="-">
												<styles font-size="10pt"/>
											</text>
										</children>
									</paragraph>
								</children>
							</globaltemplate>
							<globaltemplate subtype="pagelayout" match="footerfirst"/>
						</children>
					</documentsection>
					<template subtype="source" match="XML">
						<children>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos;">
										<children>
											<template subtype="uservariable" match="$show-info">
												<children>
													<paragraph>
														<properties class="info"/>
														<children>
															<checkbox checkedvalue="true">
																<children>
																	<content/>
																</children>
															</checkbox>
															<text fixtext="Show additional meta-information"/>
														</children>
													</paragraph>
												</children>
												<variables/>
											</template>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<content/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts>
		<children>
			<globaltemplate subtype="element" match="abbrev" schema-tree-path="abbrev">
				<children>
					<template subtype="element" match="abbrev">
						<children>
							<text fixtext="["/>
							<content/>
							<text fixtext="]"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="abstract" schema-tree-path="abstract">
				<children>
					<template subtype="element" match="abstract">
						<children>
							<paragraph>
								<styles font-family="@Arial Unicode MS" font-style="italic"/>
								<children>
									<content>
										<styles font-family="@Arial Unicode MS" font-style="italic"/>
									</content>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="accel" schema-tree-path="accel">
				<children>
					<template subtype="element" match="accel">
						<children>
							<content>
								<styles font-style="italic" text-decoration="underline"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="ackno" schema-tree-path="ackno">
				<children>
					<template subtype="element" match="ackno">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="acronym" schema-tree-path="acronym">
				<children>
					<template subtype="element" match="acronym">
						<children>
							<content>
								<styles text-transform="uppercase"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="address" schema-tree-path="address">
				<children>
					<template subtype="element" match="address">
						<children>
							<template subtype="element" match="affiliation">
								<children>
									<template subtype="element" match="shortaffil">
										<children>
											<content/>
										</children>
										<variables/>
									</template>
									<newline/>
									<template subtype="element" match="orgdiv">
										<children>
											<content/>
										</children>
										<variables/>
									</template>
									<newline/>
									<template subtype="element" match="orgname">
										<children>
											<content/>
										</children>
										<variables/>
									</template>
								</children>
								<variables/>
							</template>
							<tgrid>
								<properties border="0"/>
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
															<template subtype="element" match="street">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell joinleft="1"/>
													<tgridcell>
														<children>
															<template subtype="element" match="pob">
																<children>
																	<content/>
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
															<template subtype="element" match="city">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="state">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="postcode">
																<children>
																	<content/>
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
															<template subtype="element" match="country">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell joinleft="1"/>
													<tgridcell joinleft="1"/>
												</children>
											</tgridrow>
											<tgridrow>
												<children>
													<tgridcell>
														<children>
															<template subtype="element" match="affiliation">
																<children>
																	<template subtype="element" match="address">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell joinleft="1"/>
													<tgridcell joinleft="1"/>
												</children>
											</tgridrow>
										</children>
									</tgridbody-rows>
								</children>
							</tgrid>
							<tgrid>
								<properties border="0"/>
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
															<text fixtext="Phone"/>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="phone">
																<children>
																	<content/>
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
															<text fixtext="Fax"/>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="fax">
																<children>
																	<content/>
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
															<text fixtext="E-mail"/>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="email">
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
									</tgridbody-rows>
								</children>
							</tgrid>
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="affiliation" schema-tree-path="affiliation">
				<children>
					<template subtype="element" match="affiliation">
						<children>
							<tgrid>
								<properties border="0"/>
								<children>
									<tgridbody-cols>
										<children>
											<tgridcol>
												<properties width="205"/>
											</tgridcol>
										</children>
									</tgridbody-cols>
									<tgridbody-rows>
										<children>
											<tgridrow>
												<styles height="121px"/>
												<children>
													<tgridcell>
														<properties valign="top"/>
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
																						<children>
																							<template subtype="element" match="jobtitle">
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
																	</tgridbody-rows>
																</children>
															</tgrid>
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
																							<template subtype="element" match="orgdiv">
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
																	</tgridbody-rows>
																</children>
															</tgrid>
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
																							<template subtype="element" match="orgname">
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
																	</tgridbody-rows>
																</children>
															</tgrid>
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
																							<template subtype="element" match="shortaffil">
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
																	</tgridbody-rows>
																</children>
															</tgrid>
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
																							<template subtype="element" match="address">
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
			<globaltemplate subtype="element" match="anchor" schema-tree-path="anchor">
				<children>
					<template subtype="element" match="anchor">
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="answer" schema-tree-path="answer">
				<children>
					<template subtype="element" match="answer">
						<children>
							<template subtype="element" match="label">
								<children>
									<content/>
									<text fixtext=": "/>
								</children>
								<variables/>
							</template>
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="appendix" schema-tree-path="appendix">
				<children>
					<template subtype="element" levelflag="1" match="appendix">
						<editorproperties autoaddname="1" editable="1" adding="all" markupmode="hide"/>
						<children>
							<newline/>
							<newline break="page"/>
							<paragraph paragraphtag="h2">
								<children>
									<marker name="xref" _xid="@id">
										<children>
											<text fixtext="Appendix "/>
											<marker xpath="." name="appendix">
												<children>
													<num-seq format="A"/>
													<text fixtext="."/>
													<template subtype="element" match="title">
														<children>
															<text fixtext=" "/>
															<content/>
														</children>
														<variables/>
													</template>
												</children>
											</marker>
										</children>
									</marker>
								</children>
							</paragraph>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="appendixinfo"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<content restofcontents="1"/>
							<calltemplate subtype="named" match="footnotes">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="appendixinfo" schema-tree-path="appendixinfo">
				<children>
					<template subtype="element" match="appendixinfo">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="article" schema-tree-path="article">
				<children>
					<template subtype="element" levelflag="1" match="article">
						<editorproperties editable="1" adding="mandatory" markupmode="large"/>
						<children>
							<marker xpath="if ( @xreflabel ) then string( @xreflabel ) else string( title )" name="xref" _xid="@id" uses="xpath"/>
							<condition>
								<children>
									<conditionbranch xpath="title">
										<children>
											<template subtype="element" match="title">
												<children>
													<paragraph paragraphtag="h1">
														<children>
															<content/>
														</children>
													</paragraph>
												</children>
												<variables/>
											</template>
										</children>
									</conditionbranch>
									<conditionbranch xpath="articleinfo/title">
										<children>
											<template subtype="element" match="articleinfo">
												<children>
													<template subtype="element" match="title">
														<children>
															<paragraph paragraphtag="h1">
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
										</children>
									</conditionbranch>
								</children>
							</condition>
							<condition>
								<children>
									<conditionbranch xpath="subtitle">
										<children>
											<template subtype="element" match="subtitle">
												<children>
													<paragraph paragraphtag="h2">
														<children>
															<content/>
														</children>
													</paragraph>
												</children>
												<variables/>
											</template>
										</children>
									</conditionbranch>
									<conditionbranch xpath="articleinfo/subtitle">
										<children>
											<template subtype="element" match="articleinfo">
												<children>
													<template subtype="element" match="subtitle">
														<children>
															<paragraph paragraphtag="h2">
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
										</children>
									</conditionbranch>
								</children>
							</condition>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="articleinfo"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="articleinfo" schema-tree-path="articleinfo">
				<children>
					<template subtype="element" match="articleinfo">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="attribution" schema-tree-path="attribution">
				<children>
					<template subtype="element" match="attribution">
						<children>
							<text fixtext=" -- "/>
							<content/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="audiodata" schema-tree-path="audiodata">
				<children>
					<template subtype="element" match="audiodata">
						<children>
							<template subtype="attribute" match="fileref">
								<children>
									<text fixtext="(">
										<styles font-style="italic"/>
									</text>
									<content>
										<styles font-style="italic"/>
										<format basic-type="xsd" datatype="CDATA"/>
									</content>
									<text fixtext=")">
										<styles font-style="italic"/>
									</text>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="audioobject" schema-tree-path="audioobject">
				<children>
					<template subtype="element" match="audioobject">
						<children>
							<newline/>
							<template subtype="element" match="objectinfo">
								<children>
									<content/>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="audiodata">
								<children>
									<content/>
								</children>
								<variables/>
							</template>
							<newline/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="author" schema-tree-path="author">
				<children>
					<template subtype="element" match="author">
						<children>
							<newline/>
							<tgrid>
								<properties width="100%"/>
								<children>
									<tgridbody-cols>
										<children>
											<tgridcol>
												<properties width="792"/>
											</tgridcol>
											<tgridcol/>
										</children>
									</tgridbody-cols>
									<tgridbody-rows>
										<children>
											<tgridrow>
												<styles height="58px"/>
												<children>
													<tgridcell>
														<properties valign="top"/>
														<children>
															<template subtype="element" match="personname">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
															<newline/>
															<template subtype="element" match="honorific">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
															<template subtype="element" match="firstname">
																<children>
																	<text fixtext=" "/>
																	<content/>
																</children>
																<variables/>
															</template>
															<template subtype="element" match="surname">
																<children>
																	<text fixtext=" "/>
																	<content/>
																</children>
																<variables/>
															</template>
															<template subtype="element" match="lineage">
																<children>
																	<text fixtext=" "/>
																	<content/>
																</children>
																<variables/>
															</template>
															<newline/>
															<template subtype="element" match="othername">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
															<newline/>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="affiliation">
																<children>
																	<template subtype="element" match="shortaffil">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
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
																									<template subtype="element" match="jobtitle">
																										<children>
																											<content/>
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
																									<template subtype="element" match="orgdiv">
																										<children>
																											<content/>
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
																									<template subtype="element" match="orgname">
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
																			</tgridbody-rows>
																		</children>
																	</tgrid>
																	<template subtype="element" match="address">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
											<tgridrow>
												<styles height="24px"/>
												<children>
													<tgridcell>
														<properties align="left"/>
														<children>
															<template subtype="element" match="email">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell joinleft="1">
														<properties align="left"/>
													</tgridcell>
												</children>
											</tgridrow>
											<tgridrow>
												<styles height="24px"/>
												<children>
													<tgridcell>
														<properties align="center"/>
														<children>
															<template subtype="element" match="authorblurb">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell joinleft="1">
														<properties align="center"/>
													</tgridcell>
												</children>
											</tgridrow>
										</children>
									</tgridbody-rows>
								</children>
							</tgrid>
							<template subtype="element" match="contrib">
								<children>
									<content/>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="personblurb">
								<children>
									<content/>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="address">
								<children>
									<template subtype="element" match="street">
										<children>
											<content/>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="pob">
										<children>
											<content/>
										</children>
										<variables/>
									</template>
									<newline/>
									<content restofcontents="1"/>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="authorblurb" schema-tree-path="authorblurb">
				<children>
					<template subtype="element" match="authorblurb">
						<children>
							<paragraph>
								<styles text-indent="3mm"/>
								<children>
									<content>
										<styles text-indent="3mm"/>
									</content>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="authorgroup" schema-tree-path="authorgroup">
				<children>
					<template subtype="element" match="authorgroup">
						<children>
							<tgrid>
								<properties border="0" width="100%"/>
								<children>
									<tgridbody-cols>
										<children>
											<tgridcol>
												<properties width="143"/>
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
															<text fixtext="Author"/>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="author">
																<children>
																	<content/>
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
															<text fixtext="Editor"/>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="editor">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
											<tgridrow>
												<styles height="1px"/>
												<children>
													<tgridcell>
														<children>
															<text fixtext="Collaborator"/>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="collab">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
											<tgridrow>
												<styles height="24px"/>
												<children>
													<tgridcell>
														<children>
															<text fixtext="Corperate Author"/>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="corpauthor">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
											<tgridrow>
												<styles height="35px"/>
												<children>
													<tgridcell>
														<children>
															<text fixtext="Other Credit"/>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="othercredit">
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
									</tgridbody-rows>
								</children>
							</tgrid>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="beginpage" schema-tree-path="beginpage">
				<children>
					<template subtype="element" match="beginpage">
						<children>
							<template subtype="attribute" match="pagenum">
								<children>
									<text fixtext="(">
										<styles font-style="italic"/>
									</text>
									<content>
										<styles font-style="italic"/>
										<format basic-type="xsd" datatype="CDATA"/>
									</content>
									<text fixtext=")">
										<styles font-style="italic"/>
									</text>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="bibliodiv" schema-tree-path="bibliodiv">
				<children>
					<template subtype="element" match="bibliodiv">
						<children>
							<template subtype="element" match="title">
								<children>
									<content>
										<styles font-size="medium" font-weight="bold"/>
									</content>
								</children>
								<variables/>
							</template>
							<newline/>
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="biblioentry" schema-tree-path="biblioentry">
				<children>
					<template subtype="element" match="biblioentry">
						<children>
							<template subtype="element" match="abbrev">
								<children>
									<content/>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="title">
								<children>
									<content/>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="subtitle">
								<children>
									<content/>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="pubdate">
								<children>
									<content/>
								</children>
								<variables/>
							</template>
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="bibliography" schema-tree-path="bibliography">
				<children>
					<template subtype="element" levelflag="1" match="bibliography">
						<children>
							<newline break="page"/>
							<paragraph paragraphtag="h2">
								<children>
									<marker name="xref" _xid="@id">
										<children>
											<marker xpath="." name="bibliography">
												<children>
													<text fixtext="Bibliography"/>
													<template subtype="element" match="title">
														<children>
															<text fixtext=" "/>
															<content/>
														</children>
														<variables/>
													</template>
												</children>
											</marker>
										</children>
									</marker>
								</children>
							</paragraph>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="bibliographyinfo"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<content restofcontents="1"/>
							<calltemplate subtype="named" match="footnotes">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="bibliographyinfo" schema-tree-path="bibliographyinfo">
				<children>
					<template subtype="element" match="bibliographyinfo">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="blockinfo" schema-tree-path="blockinfo">
				<children>
					<template subtype="element" match="blockinfo">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="blockquote" schema-tree-path="blockquote">
				<children>
					<template subtype="element" match="blockquote">
						<children>
							<paragraph paragraphtag="blockquote">
								<children>
									<content restofcontents="1"/>
								</children>
							</paragraph>
							<template subtype="element" match="attribution">
								<children>
									<paragraph>
										<styles text-align="right"/>
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
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="book" schema-tree-path="book">
				<children>
					<template subtype="element" levelflag="1" match="book">
						<editorproperties editable="1" adding="mandatory" markupmode="large"/>
						<children>
							<marker xpath="if ( @xreflabel ) then string( @xreflabel ) else string( title )" name="xref" _xid="@id" uses="xpath"/>
							<condition>
								<children>
									<conditionbranch xpath="title">
										<children>
											<template subtype="element" match="title">
												<children>
													<paragraph paragraphtag="h1">
														<children>
															<content/>
														</children>
													</paragraph>
												</children>
												<variables/>
											</template>
										</children>
									</conditionbranch>
									<conditionbranch xpath="bookinfo/title">
										<children>
											<template subtype="element" match="bookinfo">
												<children>
													<template subtype="element" match="title">
														<children>
															<paragraph paragraphtag="h1">
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
										</children>
									</conditionbranch>
								</children>
							</condition>
							<condition>
								<children>
									<conditionbranch xpath="subtitle">
										<children>
											<template subtype="element" match="subtitle">
												<children>
													<paragraph paragraphtag="h2">
														<children>
															<content/>
														</children>
													</paragraph>
												</children>
												<variables/>
											</template>
										</children>
									</conditionbranch>
									<conditionbranch xpath="bookinfo/subtitle">
										<children>
											<template subtype="element" match="bookinfo">
												<children>
													<template subtype="element" match="subtitle">
														<children>
															<paragraph paragraphtag="h2">
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
										</children>
									</conditionbranch>
								</children>
							</condition>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="bookinfo"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<template subtype="element" match="bookinfo">
								<children>
									<calltemplate subtype="element" match="copyright"/>
									<calltemplate subtype="element" match="legalnotice"/>
								</children>
								<variables/>
							</template>
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="bookinfo" schema-tree-path="bookinfo">
				<children>
					<template subtype="element" match="bookinfo">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="bridgehead" schema-tree-path="bridgehead">
				<children>
					<template subtype="element" match="bridgehead">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="caption" schema-tree-path="caption">
				<children>
					<template subtype="element" match="caption">
						<children>
							<content>
								<styles font-size="small" vertical-Align="super"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="caution" schema-tree-path="caution">
				<children>
					<template subtype="element" match="caution">
						<children>
							<newline/>
							<text fixtext="CAUTION: ">
								<styles font-family="@Arial Unicode MS" font-weight="bold" margin-left="1.5cm" margin-right="1.5cm"/>
							</text>
							<template subtype="element" match="title">
								<children>
									<content>
										<styles font-family="@Arial Unicode MS" font-weight="bold" margin-left="1.5cm" margin-right="1.5cm"/>
									</content>
								</children>
								<variables/>
							</template>
							<newline/>
							<paragraph>
								<styles font-family="@Arial Unicode MS" font-weight="bold" margin-left="1.5cm" margin-right="1.5cm"/>
								<children>
									<content restofcontents="1">
										<styles font-family="@Arial Unicode MS" font-weight="bold" margin-left="1.5cm" margin-right="1.5cm"/>
									</content>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="chapter" schema-tree-path="chapter">
				<children>
					<template subtype="element" levelflag="1" match="chapter">
						<children>
							<newline/>
							<newline break="page"/>
							<paragraph paragraphtag="h2">
								<children>
									<marker name="xref" _xid="@id">
										<children>
											<text fixtext="Chapter "/>
											<marker name="chapter">
												<children>
													<num-seq format="1"/>
													<text fixtext="."/>
													<template subtype="element" match="title">
														<children>
															<text fixtext=" "/>
															<content/>
														</children>
														<variables/>
													</template>
												</children>
											</marker>
										</children>
									</marker>
								</children>
							</paragraph>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="chapterinfo"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<content restofcontents="1"/>
							<calltemplate subtype="named" match="footnotes">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="chapterinfo" schema-tree-path="chapterinfo">
				<children>
					<template subtype="element" match="chapterinfo">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="citation" schema-tree-path="citation">
				<children>
					<template subtype="element" match="citation">
						<children>
							<text fixtext="["/>
							<content/>
							<text fixtext="]"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="citetitle" schema-tree-path="citetitle">
				<children>
					<template subtype="element" match="citetitle">
						<children>
							<content>
								<styles font-style="oblique"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="classname" schema-tree-path="classname">
				<children>
					<template subtype="element" match="classname">
						<children>
							<content>
								<styles font-family="Courier New"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="classsynopsis" schema-tree-path="classsynopsis">
				<children>
					<template subtype="element" match="classsynopsis">
						<children>
							<newline/>
							<template subtype="element" match="ooclass">
								<children>
									<calltemplate subtype="element" match="modifier">
										<styles font-family="Courier New" margin-left="1cm"/>
									</calltemplate>
									<template subtype="element" match="classname">
										<children>
											<content>
												<styles font-family="Courier New"/>
											</content>
										</children>
										<variables/>
									</template>
								</children>
								<variables/>
							</template>
							<text fixtext=" ">
								<styles font-family="Courier New"/>
							</text>
							<template subtype="element" match="oointerface">
								<children>
									<text fixtext="implements ">
										<styles font-family="Courier New"/>
									</text>
									<calltemplate subtype="element" match="modifier">
										<styles font-family="Courier New"/>
									</calltemplate>
									<template subtype="element" match="interfacename">
										<children>
											<content>
												<styles font-family="Courier New"/>
											</content>
										</children>
										<variables/>
									</template>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="ooexception">
								<children>
									<text fixtext="throws ">
										<styles font-family="Courier New" margin-left="2.5cm"/>
									</text>
									<calltemplate subtype="element" match="modifier">
										<styles font-family="Courier New"/>
									</calltemplate>
									<template subtype="element" match="exceptionname">
										<children>
											<content>
												<styles font-family="Courier New"/>
											</content>
										</children>
										<variables/>
									</template>
								</children>
								<variables/>
							</template>
							<text fixtext="{">
								<styles font-family="Courier New"/>
							</text>
							<newline/>
							<calltemplate subtype="element" match="fieldsynopsis">
								<styles font-family="Courier New" margin-left="2cm"/>
							</calltemplate>
							<newline/>
							<calltemplate subtype="element" match="constructorsynopsis">
								<styles font-family="Courier New" margin-left="2cm"/>
							</calltemplate>
							<newline/>
							<template subtype="element" match="destructorsynopsis">
								<children>
									<content>
										<styles font-family="Courier New"/>
									</content>
								</children>
								<variables/>
							</template>
							<newline/>
							<calltemplate subtype="element" match="methodsynopsis">
								<styles font-family="Courier New" margin-left="2cm"/>
							</calltemplate>
							<newline/>
							<calltemplate subtype="element" match="classsynopsisinfo">
								<styles font-family="Courier New"/>
							</calltemplate>
							<text fixtext="}">
								<styles font-family="Courier New"/>
							</text>
							<newline/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="classsynopsisinfo" schema-tree-path="classsynopsisinfo">
				<children>
					<template subtype="element" match="classsynopsisinfo">
						<children>
							<content/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="cmdsynopsis" schema-tree-path="cmdsynopsis">
				<children>
					<template subtype="element" match="cmdsynopsis">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="colophon" schema-tree-path="colophon">
				<children>
					<template subtype="element" match="colophon">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="command" schema-tree-path="command">
				<children>
					<template subtype="element" match="command">
						<children>
							<content>
								<styles font-family="Courier New" font-weight="bold"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="computeroutput" schema-tree-path="computeroutput">
				<children>
					<template subtype="element" match="computeroutput">
						<children>
							<content>
								<styles font-family="Courier New"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="conftitle" schema-tree-path="conftitle">
				<children>
					<template subtype="element" match="conftitle">
						<children>
							<text fixtext="&quot;">
								<styles font-weight="bold"/>
							</text>
							<content>
								<styles font-weight="bold"/>
							</content>
							<text fixtext="&quot;">
								<styles font-weight="bold"/>
							</text>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="constant" schema-tree-path="constant">
				<children>
					<template subtype="element" match="constant">
						<children>
							<content>
								<styles font-family="Courier New"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="constructorsynopsis" schema-tree-path="constructorsynopsis">
				<children>
					<template subtype="element" match="constructorsynopsis">
						<children>
							<calltemplate subtype="element" match="modifier"/>
							<calltemplate subtype="element" match="methodname"/>
							<text fixtext="("/>
							<calltemplate subtype="element" match="methodparam"/>
							<text fixtext=")"/>
							<calltemplate subtype="element" match="void"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="copyright" schema-tree-path="copyright">
				<children>
					<template subtype="element" match="copyright">
						<children>
							<text fixtext="Copyright © "/>
							<template subtype="element" match="year">
								<children>
									<content/>
									<condition>
										<children>
											<conditionbranch xpath="following-sibling::year">
												<children>
													<text fixtext=", "/>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<variables/>
							</template>
							<text fixtext=" "/>
							<template subtype="element" match="holder">
								<children>
									<content/>
									<condition>
										<children>
											<conditionbranch xpath="following-sibling::holder">
												<children>
													<text fixtext=", "/>
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
			</globaltemplate>
			<globaltemplate subtype="element" match="dedication" schema-tree-path="dedication">
				<children>
					<template subtype="element" match="dedication">
						<children>
							<paragraph>
								<children>
									<template subtype="element" match="title">
										<children>
											<content>
												<styles font-size="large" font-weight="bold"/>
											</content>
										</children>
										<variables/>
									</template>
									<newline/>
									<content restofcontents="1"/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="editor" schema-tree-path="editor">
				<children>
					<template subtype="element" match="editor">
						<children>
							<tgrid>
								<properties border="0" width="100%"/>
								<children>
									<tgridbody-cols>
										<children>
											<tgridcol>
												<properties width="831"/>
											</tgridcol>
											<tgridcol/>
										</children>
									</tgridbody-cols>
									<tgridbody-rows>
										<children>
											<tgridrow>
												<styles height="79px"/>
												<children>
													<tgridcell>
														<children>
															<template subtype="element" match="personname">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
															<newline/>
															<template subtype="element" match="honorific">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
															<template subtype="element" match="firstname">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
															<template subtype="element" match="surname">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
															<template subtype="element" match="lineage">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
															<newline/>
															<template subtype="element" match="othername">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="affiliation">
																<children>
																	<template subtype="element" match="shortaffil">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
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
																									<template subtype="element" match="jobtitle">
																										<children>
																											<content/>
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
																									<template subtype="element" match="orgdiv">
																										<children>
																											<content/>
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
																									<template subtype="element" match="orgname">
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
																			</tgridbody-rows>
																		</children>
																	</tgrid>
																	<template subtype="element" match="address">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
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
														<properties align="left"/>
														<children>
															<template subtype="element" match="email">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell joinleft="1">
														<properties align="left"/>
													</tgridcell>
												</children>
											</tgridrow>
											<tgridrow>
												<styles height="26px"/>
												<children>
													<tgridcell>
														<properties align="center"/>
														<children>
															<template subtype="element" match="authorblurb">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell joinleft="1">
														<properties align="center"/>
													</tgridcell>
												</children>
											</tgridrow>
										</children>
									</tgridbody-rows>
								</children>
							</tgrid>
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="email" schema-tree-path="email">
				<children>
					<template subtype="element" match="email">
						<children>
							<link>
								<children>
									<text fixtext="&lt;">
										<styles font-family="Arial" font-size="small"/>
									</text>
									<content>
										<styles font-family="Arial" font-size="small"/>
									</content>
									<text fixtext="&gt;">
										<styles font-family="Arial" font-size="small"/>
									</text>
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
			</globaltemplate>
			<globaltemplate subtype="element" match="emphasis" schema-tree-path="emphasis">
				<children>
					<template subtype="element" match="emphasis">
						<children>
							<condition>
								<children>
									<conditionbranch xpath="@role  = &quot;bold&quot;">
										<children>
											<content>
												<styles font-weight="bold"/>
											</content>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@role  = &quot;strong&quot;">
										<children>
											<content>
												<styles font-weight="bold"/>
											</content>
										</children>
									</conditionbranch>
									<conditionbranch>
										<children>
											<content>
												<styles font-style="italic"/>
											</content>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="envar" schema-tree-path="envar">
				<children>
					<template subtype="element" match="envar">
						<children>
							<content>
								<styles font-family="Courier New"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="epigraph" schema-tree-path="epigraph">
				<children>
					<template subtype="element" match="epigraph">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="equation" schema-tree-path="equation">
				<children>
					<template subtype="element" match="equation">
						<children>
							<paragraph>
								<children>
									<template subtype="element" match="title">
										<children>
											<content/>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="titleabbrev">
										<children>
											<content/>
										</children>
										<variables/>
									</template>
									<newline/>
									<template subtype="element" match="mediaobject">
										<children>
											<content/>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="graphic">
										<children>
											<content/>
										</children>
										<variables/>
									</template>
									<newline/>
									<template subtype="element" match="alt">
										<children>
											<content/>
										</children>
										<variables/>
									</template>
								</children>
							</paragraph>
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="errortext" schema-tree-path="errortext">
				<children>
					<template subtype="element" match="errortext">
						<children>
							<paragraph>
								<styles font-family="Courier New" white-space="pre"/>
								<children>
									<content>
										<styles font-family="Courier New" white-space="pre"/>
									</content>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="example" schema-tree-path="example">
				<children>
					<template subtype="element" match="example">
						<children>
							<newline/>
							<paragraph>
								<children>
									<marker name="xref" _xid="@id">
										<children>
											<marker name="example">
												<children>
													<text fixtext="Example ">
														<styles font-family="Times New Roman" font-style="italic"/>
													</text>
													<num-seq format="1">
														<styles font-family="Times New Roman" font-style="italic"/>
													</num-seq>
													<template subtype="element" match="title">
														<children>
															<text fixtext=": ">
																<styles font-family="Times New Roman" font-style="italic"/>
															</text>
															<content>
																<styles font-family="Times New Roman" font-style="italic"/>
															</content>
														</children>
														<variables/>
													</template>
												</children>
											</marker>
										</children>
									</marker>
									<content restofcontents="1"/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="fieldsynopsis" schema-tree-path="fieldsynopsis">
				<children>
					<template subtype="element" match="fieldsynopsis">
						<children>
							<calltemplate subtype="element" match="modifier"/>
							<template subtype="element" match="type">
								<children>
									<content/>
								</children>
								<variables/>
							</template>
							<calltemplate subtype="element" match="varname"/>
							<text fixtext=" = "/>
							<calltemplate subtype="element" match="initializer"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="figure" schema-tree-path="figure">
				<children>
					<template subtype="element" match="figure">
						<children>
							<paragraph>
								<children>
									<calltemplate subtype="element" match="graphic"/>
									<calltemplate subtype="element" match="mediaobject"/>
									<newline/>
									<marker name="xref" _xid="@id">
										<children>
											<marker name="figure">
												<children>
													<text fixtext="Figure ">
														<styles font-size="x-small" font-weight="bold"/>
													</text>
													<num-seq format="1">
														<styles font-size="x-small" font-weight="bold"/>
													</num-seq>
													<template subtype="element" match="title">
														<children>
															<text fixtext=": ">
																<styles font-size="x-small" font-weight="bold"/>
															</text>
															<content>
																<styles font-size="x-small" font-weight="bold"/>
															</content>
														</children>
														<variables/>
													</template>
												</children>
											</marker>
										</children>
									</marker>
									<content restofcontents="1"/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="filename" schema-tree-path="filename">
				<children>
					<template subtype="element" match="filename">
						<children>
							<content>
								<styles font-family="Arial Narrow" font-style="oblique"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="firstterm" schema-tree-path="firstterm">
				<children>
					<template subtype="element" match="firstterm">
						<children>
							<content>
								<styles font-style="italic"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="footnote" schema-tree-path="footnote">
				<children>
					<template subtype="element" match="footnote">
						<children>
							<ref name="footnote" _xid="count(preceding::footnote)" scope="global" createhyperlink="1">
								<children>
									<text fixtext="[">
										<styles vertical-align="super"/>
									</text>
									<num-seq format="1">
										<styles vertical-align="super"/>
									</num-seq>
									<text fixtext="]">
										<styles vertical-align="super"/>
									</text>
								</children>
							</ref>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<paragraph>
												<properties class="info"/>
												<children>
													<text fixtext="Footnote: "/>
													<content/>
												</children>
											</paragraph>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="foreignphrase" schema-tree-path="foreignphrase">
				<children>
					<template subtype="element" match="foreignphrase">
						<children>
							<content>
								<styles font-style="italic"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="formalpara" schema-tree-path="formalpara">
				<children>
					<template subtype="element" match="formalpara">
						<children>
							<paragraph>
								<children>
									<template subtype="element" match="title">
										<children>
											<content>
												<styles font-size="larger" font-weight="bold"/>
											</content>
										</children>
										<variables/>
									</template>
									<content restofcontents="1"/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="funcparams" schema-tree-path="funcparams">
				<children>
					<template subtype="element" match="funcparams">
						<children>
							<text fixtext="("/>
							<content/>
							<text fixtext=")"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="function" schema-tree-path="function">
				<children>
					<template subtype="element" match="function">
						<children>
							<content>
								<styles font-weight="bold"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="glossaryinfo" schema-tree-path="glossaryinfo">
				<children>
					<template subtype="element" match="glossaryinfo">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="glossdef" schema-tree-path="glossdef">
				<children>
					<template subtype="element" match="glossdef">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="glossdiv" schema-tree-path="glossdiv">
				<children>
					<template subtype="element" match="glossdiv">
						<children>
							<paragraph>
								<children>
									<template subtype="element" match="title">
										<children>
											<content>
												<styles font-size="large" font-weight="bold"/>
											</content>
										</children>
										<variables/>
									</template>
									<newline/>
									<content restofcontents="1"/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="glossentry" schema-tree-path="glossentry">
				<children>
					<template subtype="element" match="glossentry">
						<children>
							<paragraph>
								<children>
									<tgrid>
										<properties width="100%"/>
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
																	<template subtype="element" match="glossterm">
																		<children>
																			<content/>
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
															<tgridcell/>
															<tgridcell/>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<template subtype="element" match="glossdef">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																</children>
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
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="glosslist" schema-tree-path="glosslist">
				<children>
					<template subtype="element" match="glosslist">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="glossterm" schema-tree-path="glossterm">
				<children>
					<template subtype="element" match="glossterm">
						<children>
							<content>
								<styles font-size="large"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="graphic" schema-tree-path="graphic">
				<children>
					<template subtype="element" match="graphic">
						<children>
							<paragraph>
								<children>
									<condition>
										<children>
											<conditionbranch xpath="@width and @depth">
												<children>
													<image>
														<properties border="0"/>
														<styles _xheight="@depth" _xwidth="@width"/>
														<target>
															<xpath value="@fileref"/>
														</target>
														<imagesource>
															<xpath value="@fileref"/>
														</imagesource>
													</image>
												</children>
											</conditionbranch>
											<conditionbranch>
												<children>
													<image>
														<properties border="0"/>
														<target>
															<xpath value="@fileref"/>
														</target>
														<imagesource>
															<xpath value="@fileref"/>
														</imagesource>
													</image>
												</children>
											</conditionbranch>
										</children>
									</condition>
									<condition>
										<children>
											<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
												<children>
													<paragraph>
														<properties class="info"/>
														<styles display="inline"/>
														<children>
															<text fixtext="Image URL: "/>
															<template subtype="attribute" match="fileref">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</paragraph>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="group" schema-tree-path="group">
				<children>
					<template subtype="element" match="group">
						<children>
							<text fixtext="["/>
							<content/>
							<text fixtext="]"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="guibutton" schema-tree-path="guibutton">
				<children>
					<template subtype="element" match="guibutton">
						<children>
							<content>
								<styles font-style="italic" font-weight="bold"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="guilabel" schema-tree-path="guilabel">
				<children>
					<template subtype="element" match="guilabel">
						<children>
							<content>
								<styles font-style="italic" font-weight="bold"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="guimenu" schema-tree-path="guimenu">
				<children>
					<template subtype="element" match="guimenu">
						<children>
							<content>
								<styles font-style="italic" font-weight="bold"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="guimenuitem" schema-tree-path="guimenuitem">
				<children>
					<template subtype="element" match="guimenuitem">
						<children>
							<content>
								<styles font-style="italic"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="guisubmenu" schema-tree-path="guisubmenu">
				<children>
					<template subtype="element" match="guisubmenu">
						<children>
							<content>
								<styles font-style="italic"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="highlights" schema-tree-path="highlights">
				<children>
					<template subtype="element" match="highlights">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="imagedata" schema-tree-path="imagedata">
				<children>
					<template subtype="element" match="imagedata">
						<children>
							<condition>
								<children>
									<conditionbranch xpath="@width and @depth">
										<children>
											<image>
												<properties border="0"/>
												<styles _xheight="@depth" _xwidth="@width"/>
												<target>
													<xpath value="@fileref"/>
												</target>
												<imagesource>
													<xpath value="@fileref"/>
												</imagesource>
											</image>
										</children>
									</conditionbranch>
									<conditionbranch>
										<children>
											<image>
												<properties border="0"/>
												<target>
													<xpath value="@fileref"/>
												</target>
												<imagesource>
													<xpath value="@fileref"/>
												</imagesource>
											</image>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<text fixtext="  "/>
											<paragraph>
												<properties class="inlineinfo"/>
												<styles display="inline"/>
												<children>
													<text fixtext="Image URL: "/>
													<template subtype="attribute" match="fileref">
														<children>
															<content/>
														</children>
														<variables/>
													</template>
												</children>
											</paragraph>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="important" schema-tree-path="important">
				<children>
					<template subtype="element" match="important">
						<children>
							<paragraph>
								<children>
									<text fixtext="IMPORTANT: ">
										<styles font-family="Arial" font-weight="bold"/>
									</text>
									<template subtype="element" match="title">
										<children>
											<content>
												<styles font-weight="bold" text-transform="uppercase"/>
											</content>
										</children>
										<variables/>
									</template>
									<newline/>
								</children>
							</paragraph>
							<content restofcontents="1">
								<styles margin-left="1.5cm" margin-right="1.5cm"/>
							</content>
							<newline/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="index" schema-tree-path="index">
				<children>
					<template subtype="element" levelflag="1" match="index">
						<children>
							<newline break="page"/>
							<paragraph paragraphtag="h2">
								<children>
									<marker xpath="." name="xref" _xid="@id">
										<children>
											<marker name="index">
												<children>
													<text fixtext="Index"/>
													<template subtype="element" match="title">
														<children>
															<text fixtext=" "/>
															<content/>
														</children>
														<variables/>
													</template>
												</children>
											</marker>
										</children>
									</marker>
								</children>
							</paragraph>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="indexinfo"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<ref name="indexterm" scope="global" createhyperlink="1">
								<children>
									<paragraph>
										<styles margin-left="0.5cm"/>
										<children>
											<field type="ref-entrytext"/>
											<condition>
												<children>
													<conditionbranch xpath="$SV_OutputFormat = &apos;RTF&apos;">
														<children>
															<text fixtext=", "/>
															<field type="ref-pageref"/>
														</children>
													</conditionbranch>
													<conditionbranch xpath="$SV_OutputFormat = &apos;PDF&apos;">
														<children>
															<text fixtext=", "/>
															<field type="ref-pageref"/>
														</children>
													</conditionbranch>
													<conditionbranch xpath="$SV_OutputFormat = &apos;Word2007&apos;">
														<children>
															<text fixtext=", "/>
															<field type="ref-pageref"/>
														</children>
													</conditionbranch>
												</children>
											</condition>
										</children>
									</paragraph>
								</children>
							</ref>
							<content restofcontents="1"/>
							<calltemplate subtype="named" match="footnotes">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="indexdiv" schema-tree-path="indexdiv">
				<children>
					<template subtype="element" match="indexdiv">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="indexentry" schema-tree-path="indexentry">
				<children>
					<template subtype="element" match="indexentry">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="indexinfo" schema-tree-path="indexinfo">
				<children>
					<template subtype="element" match="indexinfo">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="indexterm" schema-tree-path="indexterm">
				<children>
					<template subtype="element" match="indexterm">
						<children>
							<marker xpath="if ( tertiary ) then concat( string( primary ), &apos;, &apos;, string( secondary ), &apos;, &apos;, string( tertiary ) ) else if ( secondary ) then concat( string( primary ), &apos;, &apos;, string( secondary ) ) else string( primary )" name="xref" _xid="@id" uses="xpath"/>
							<marker xpath="if ( tertiary ) then concat( string( primary ), &apos;, &apos;, string( secondary ), &apos;, &apos;, string( tertiary ) ) else if ( secondary ) then concat( string( primary ), &apos;, &apos;, string( secondary ) ) else string( primary )" name="indexterm" uses="xpath"/>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<paragraph>
												<children>
													<content/>
												</children>
											</paragraph>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="informalequation" schema-tree-path="informalequation">
				<children>
					<template subtype="element" match="informalequation">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="informalexample" schema-tree-path="informalexample">
				<children>
					<template subtype="element" match="informalexample">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="informalfigure" schema-tree-path="informalfigure">
				<children>
					<template subtype="element" match="informalfigure">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="initializer" schema-tree-path="initializer">
				<children>
					<template subtype="element" match="initializer">
						<children>
							<content/>
							<text fixtext=";"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="inlineequation" schema-tree-path="inlineequation">
				<children>
					<template subtype="element" match="inlineequation">
						<children>
							<template subtype="element" match="alt">
								<children>
									<content/>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="graphic">
								<children>
									<content/>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="inlinemediaobject">
								<children>
									<content/>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="inlinegraphic" schema-tree-path="inlinegraphic">
				<children>
					<template subtype="element" match="inlinegraphic">
						<children>
							<condition>
								<children>
									<conditionbranch xpath="@width and @depth">
										<children>
											<image>
												<properties border="0"/>
												<styles _xheight="@depth" _xwidth="@width"/>
												<target>
													<xpath value="@fileref"/>
												</target>
												<imagesource>
													<xpath value="@fileref"/>
												</imagesource>
											</image>
										</children>
									</conditionbranch>
									<conditionbranch>
										<children>
											<image>
												<properties border="0"/>
												<target>
													<xpath value="@fileref"/>
												</target>
												<imagesource>
													<xpath value="@fileref"/>
												</imagesource>
											</image>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<text fixtext="  "/>
											<paragraph>
												<properties class="inlineinfo"/>
												<styles display="inline"/>
												<children>
													<text fixtext="Image URL: "/>
													<template subtype="attribute" match="fileref">
														<children>
															<content/>
														</children>
														<variables/>
													</template>
												</children>
											</paragraph>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="itemizedlist" schema-tree-path="itemizedlist">
				<children>
					<template subtype="element" match="itemizedlist">
						<children>
							<template subtype="element" match="title">
								<children>
									<paragraph>
										<styles font-size="medium" font-weight="bold"/>
										<children>
											<content>
												<styles font-size="medium" font-weight="bold"/>
											</content>
										</children>
									</paragraph>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="titleabbrev">
								<children>
									<paragraph>
										<styles font-weight="bold"/>
										<children>
											<content>
												<styles font-weight="bold"/>
											</content>
										</children>
									</paragraph>
								</children>
								<variables/>
							</template>
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
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="itermset" schema-tree-path="itermset">
				<children>
					<template subtype="element" match="itermset">
						<children>
							<text fixtext="&lt;"/>
							<content/>
							<text fixtext="&gt;"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="keycap" schema-tree-path="keycap">
				<children>
					<template subtype="element" match="keycap">
						<children>
							<content>
								<styles font-weight="bold" text-transform="capitalize"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="keycombo" schema-tree-path="keycombo">
				<children>
					<template subtype="element" match="keycombo">
						<children>
							<content>
								<styles font-family="@Arial Unicode MS"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="legalnotice" schema-tree-path="legalnotice">
				<children>
					<template subtype="element" match="legalnotice">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="lineannotation" schema-tree-path="lineannotation">
				<children>
					<template subtype="element" match="lineannotation">
						<children>
							<content>
								<styles font-family="Arial Black" font-size="small" font-style="italic"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="link" schema-tree-path="link">
				<children>
					<template subtype="element" match="link">
						<children>
							<link>
								<children>
									<content/>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<xpath value="@linkend"/>
								</hyperlink>
							</link>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="literal" schema-tree-path="literal">
				<children>
					<template subtype="element" match="literal">
						<children>
							<content>
								<styles color="gray" font-family="Courier New" font-size="small"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="literallayout" schema-tree-path="literallayout">
				<children>
					<template subtype="element" match="literallayout">
						<children>
							<content>
								<styles white-space="pre"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="lot" schema-tree-path="lot">
				<children>
					<template subtype="element" match="lot">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="lotentry" schema-tree-path="lotentry">
				<children>
					<template subtype="element" match="lotentry">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="manvolnum" schema-tree-path="manvolnum">
				<children>
					<template subtype="element" match="manvolnum">
						<children>
							<content/>
							<text fixtext=")"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="medialabel" schema-tree-path="medialabel">
				<children>
					<template subtype="element" match="medialabel">
						<children>
							<content>
								<styles font-style="italic"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="mediaobject" schema-tree-path="mediaobject">
				<children>
					<template subtype="element" match="mediaobject">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="menuchoice" schema-tree-path="menuchoice">
				<children>
					<template subtype="element" match="menuchoice">
						<children>
							<template subtype="element" match="guimenu">
								<children>
									<content>
										<styles font-style="italic" font-weight="bold"/>
									</content>
									<text fixtext=" - ">
										<styles font-style="italic" font-weight="bold"/>
									</text>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="guisubmenu">
								<children>
									<content>
										<styles font-style="italic" font-weight="bold"/>
									</content>
									<text fixtext=" - ">
										<styles font-style="italic" font-weight="bold"/>
									</text>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="guimenuitem">
								<children>
									<content>
										<styles font-style="italic" font-weight="bold"/>
									</content>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="shortcut">
								<children>
									<text fixtext="("/>
									<content/>
									<text fixtext=")"/>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="methodname" schema-tree-path="methodname">
				<children>
					<template subtype="element" match="methodname">
						<children>
							<content>
								<styles font-family="Courier New" font-weight="bold"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="methodparam" schema-tree-path="methodparam">
				<children>
					<template subtype="element" match="methodparam">
						<children>
							<template subtype="element" match="type">
								<children>
									<content/>
									<text fixtext=" "/>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="parameter">
								<children>
									<content/>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="methodsynopsis" schema-tree-path="methodsynopsis">
				<children>
					<template subtype="element" match="methodsynopsis">
						<children>
							<template subtype="element" match="modifier">
								<children>
									<content>
										<styles font-family="Courier New"/>
									</content>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="void">
								<children>
									<condition>
										<children>
											<conditionbranch xpath="position()  =  last()"/>
											<conditionbranch>
												<children>
													<text fixtext="void"/>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="type">
								<children>
									<content>
										<styles font-family="Courier New"/>
									</content>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="methodname">
								<children>
									<content>
										<styles font-family="Courier New"/>
									</content>
								</children>
								<variables/>
							</template>
							<text fixtext="("/>
							<calltemplate subtype="element" match="methodparam"/>
							<text fixtext=")"/>
							<template subtype="element" match="void">
								<children>
									<condition>
										<children>
											<conditionbranch xpath="position()=1">
												<children>
													<text fixtext="();"/>
												</children>
											</conditionbranch>
											<conditionbranch/>
										</children>
									</condition>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="exceptionname">
								<children>
									<content>
										<styles font-family="Courier New"/>
									</content>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="modifier" schema-tree-path="modifier">
				<children>
					<template subtype="element" match="modifier">
						<children>
							<content>
								<styles font-family="Courier New"/>
							</content>
							<text fixtext=" ">
								<styles font-family="Courier New"/>
							</text>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="msg" schema-tree-path="msg">
				<children>
					<template subtype="element" match="msg">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="msgentry" schema-tree-path="msgentry">
				<children>
					<template subtype="element" match="msgentry">
						<children>
							<paragraph>
								<children>
									<template subtype="element" match="msg">
										<children>
											<paragraph>
												<children>
													<content/>
												</children>
											</paragraph>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="msginfo">
										<children>
											<content/>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="msgexplan">
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
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="msginfo" schema-tree-path="msginfo">
				<children>
					<template subtype="element" match="msginfo">
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
														<children>
															<text fixtext="LEVEL:"/>
															<template subtype="element" match="msglevel">
																<children>
																	<content/>
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
															<text fixtext="ORIGIN: "/>
															<template subtype="element" match="msgorig">
																<children>
																	<content/>
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
															<text fixtext="AUDIENCE: "/>
															<template subtype="element" match="msgaud">
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
									</tgridbody-rows>
								</children>
							</tgrid>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="msgset" schema-tree-path="msgset">
				<children>
					<template subtype="element" match="msgset">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="note" schema-tree-path="note">
				<children>
					<template subtype="element" match="note">
						<children>
							<paragraph>
								<styles background-color="#FCF6DC" border="1px solid black" margin="0.5cm 1cm" padding="2px"/>
								<children>
									<paragraph paragraphtag="center">
										<children>
											<text fixtext="NOTE"/>
										</children>
									</paragraph>
									<content/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="objectinfo" schema-tree-path="objectinfo">
				<children>
					<template subtype="element" match="objectinfo">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="option" schema-tree-path="option">
				<children>
					<template subtype="element" match="option">
						<children>
							<content>
								<styles font-family="Courier New"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="optional" schema-tree-path="optional">
				<children>
					<template subtype="element" match="optional">
						<children>
							<text fixtext="["/>
							<content/>
							<text fixtext="]"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="orderedlist" schema-tree-path="orderedlist">
				<children>
					<template subtype="element" match="orderedlist">
						<children>
							<template subtype="element" match="title">
								<children>
									<paragraph>
										<styles font-size="medium" font-weight="bold"/>
										<children>
											<content>
												<styles font-size="medium" font-weight="bold"/>
											</content>
										</children>
									</paragraph>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="titleabbrev">
								<children>
									<paragraph>
										<styles font-weight="bold"/>
										<children>
											<content>
												<styles font-weight="bold"/>
											</content>
										</children>
									</paragraph>
								</children>
								<variables/>
							</template>
							<condition>
								<children>
									<conditionbranch xpath="parent::listitem/../parent::listitem/../parent::listitem/../parent::listitem">
										<children>
											<condition>
												<children>
													<conditionbranch xpath="@numeration = &apos;loweralpha&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="a"/>
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
													</conditionbranch>
													<conditionbranch xpath="@numeration = &apos;upperalpha&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="A"/>
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
													</conditionbranch>
													<conditionbranch xpath="@numeration = &apos;upperroman&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="I"/>
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
													</conditionbranch>
													<conditionbranch xpath="@numeration = &apos;arabic&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="1"/>
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
													</conditionbranch>
													<conditionbranch>
														<children>
															<list ordered="1">
																<properties start="1" type="i"/>
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
													</conditionbranch>
												</children>
											</condition>
										</children>
									</conditionbranch>
									<conditionbranch xpath="parent::listitem/../parent::listitem/../parent::listitem">
										<children>
											<condition>
												<children>
													<conditionbranch xpath="@numeration = &apos;upperalpha&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="A"/>
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
													</conditionbranch>
													<conditionbranch xpath="@numeration = &apos;lowerroman&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="i"/>
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
													</conditionbranch>
													<conditionbranch xpath="@numeration = &apos;upperroman&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="I"/>
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
													</conditionbranch>
													<conditionbranch xpath="@numeration = &apos;arabic&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="1"/>
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
													</conditionbranch>
													<conditionbranch>
														<children>
															<list ordered="1">
																<properties start="1" type="a"/>
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
													</conditionbranch>
												</children>
											</condition>
										</children>
									</conditionbranch>
									<conditionbranch xpath="parent::listitem/../parent::listitem">
										<children>
											<condition>
												<children>
													<conditionbranch xpath="@numeration = &apos;loweralpha&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="a"/>
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
													</conditionbranch>
													<conditionbranch xpath="@numeration = &apos;upperalpha&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="A"/>
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
													</conditionbranch>
													<conditionbranch xpath="@numeration = &apos;lowerroman&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="i"/>
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
													</conditionbranch>
													<conditionbranch xpath="@numeration = &apos;arabic&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="1"/>
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
													</conditionbranch>
													<conditionbranch>
														<children>
															<list ordered="1">
																<properties start="1" type="I"/>
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
													</conditionbranch>
												</children>
											</condition>
										</children>
									</conditionbranch>
									<conditionbranch xpath="parent::listitem">
										<children>
											<condition>
												<children>
													<conditionbranch xpath="@numeration = &apos;loweralpha&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="a"/>
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
													</conditionbranch>
													<conditionbranch xpath="@numeration = &apos;lowerroman&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="i"/>
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
													</conditionbranch>
													<conditionbranch xpath="@numeration = &apos;upperroman&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="I"/>
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
													</conditionbranch>
													<conditionbranch xpath="@numeration = &apos;arabic&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="1"/>
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
													</conditionbranch>
													<conditionbranch>
														<children>
															<list ordered="1">
																<properties start="1" type="A"/>
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
													</conditionbranch>
												</children>
											</condition>
										</children>
									</conditionbranch>
									<conditionbranch>
										<children>
											<condition>
												<children>
													<conditionbranch xpath="@numeration = &apos;loweralpha&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="a"/>
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
													</conditionbranch>
													<conditionbranch xpath="@numeration = &apos;upperalpha&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="A"/>
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
													</conditionbranch>
													<conditionbranch xpath="@numeration = &apos;lowerroman&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="i"/>
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
													</conditionbranch>
													<conditionbranch xpath="@numeration = &apos;upperroman&apos;">
														<children>
															<list ordered="1">
																<properties start="1" type="I"/>
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
													</conditionbranch>
													<conditionbranch>
														<children>
															<list ordered="1">
																<properties start="1" type="1"/>
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
													</conditionbranch>
												</children>
											</condition>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="othercredit" schema-tree-path="othercredit">
				<children>
					<template subtype="element" match="othercredit">
						<children>
							<tgrid>
								<properties border="0" width="100%"/>
								<children>
									<tgridbody-cols>
										<children>
											<tgridcol>
												<properties width="869"/>
											</tgridcol>
											<tgridcol/>
										</children>
									</tgridbody-cols>
									<tgridbody-rows>
										<children>
											<tgridrow>
												<styles height="146px"/>
												<children>
													<tgridcell>
														<children>
															<template subtype="element" match="personname">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
															<newline/>
															<template subtype="element" match="honorific">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
															<template subtype="element" match="firstname">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
															<template subtype="element" match="surname">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
															<template subtype="element" match="lineage">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
															<newline/>
															<template subtype="element" match="othername">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="affiliation">
																<children>
																	<template subtype="element" match="shortaffil">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
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
																								<children>
																									<template subtype="element" match="jobtitle">
																										<children>
																											<content/>
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
																									<template subtype="element" match="orgname">
																										<children>
																											<content/>
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
																									<template subtype="element" match="orgdiv">
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
																			</tgridbody-rows>
																		</children>
																	</tgrid>
																	<content restofcontents="1"/>
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
														<properties align="center"/>
														<children>
															<template subtype="element" match="authorblurb">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell joinleft="1">
														<properties align="center"/>
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
			<globaltemplate subtype="element" match="parameter" schema-tree-path="parameter">
				<children>
					<template subtype="element" match="parameter">
						<children>
							<content>
								<styles font-family="Courier New" font-style="italic" font-weight="bold"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="part" schema-tree-path="part">
				<children>
					<template subtype="element" levelflag="1" match="part">
						<children>
							<newline break="page"/>
							<paragraph paragraphtag="h2">
								<children>
									<marker name="xref" _xid="@id">
										<children>
											<text fixtext="Part "/>
											<marker name="part">
												<children>
													<num-seq format="1"/>
													<text fixtext="."/>
													<template subtype="element" match="title">
														<children>
															<text fixtext=" "/>
															<content/>
														</children>
														<variables/>
													</template>
												</children>
											</marker>
										</children>
									</marker>
								</children>
							</paragraph>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="partinfo"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="partinfo" schema-tree-path="partinfo">
				<children>
					<template subtype="element" match="partinfo">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="partintro" schema-tree-path="partintro">
				<children>
					<template subtype="element" match="partintro">
						<children>
							<paragraph>
								<children>
									<template subtype="element" match="title">
										<children>
											<content>
												<styles font-size="large" font-weight="bold"/>
											</content>
										</children>
										<variables/>
									</template>
									<newline/>
									<content restofcontents="1"/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="preface" schema-tree-path="preface">
				<children>
					<template subtype="element" levelflag="1" match="preface">
						<children>
							<newline break="page"/>
							<paragraph paragraphtag="h2">
								<children>
									<marker name="xref" _xid="@id">
										<children>
											<marker name="preface">
												<children>
													<template subtype="element" match="title">
														<children>
															<content/>
														</children>
														<variables/>
													</template>
												</children>
											</marker>
										</children>
									</marker>
								</children>
							</paragraph>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="prefaceinfo"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<content restofcontents="1"/>
							<template subtype="element" match="prefaceinfo">
								<children>
									<template subtype="element" match="author">
										<children>
											<paragraph>
												<styles font-style="italic" text-align="right"/>
												<children>
													<template subtype="element" match="honorific">
														<children>
															<content/>
															<text fixtext=" "/>
														</children>
														<variables/>
													</template>
													<template subtype="element" match="lineage">
														<children>
															<content/>
															<text fixtext=" "/>
														</children>
														<variables/>
													</template>
													<template subtype="element" match="firstname">
														<children>
															<content/>
														</children>
														<variables/>
													</template>
													<text fixtext=" "/>
													<template subtype="element" match="surname">
														<children>
															<content/>
														</children>
														<variables/>
													</template>
												</children>
											</paragraph>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="pubdate">
										<children>
											<paragraph>
												<styles font-style="italic" text-align="right"/>
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
							<calltemplate subtype="named" match="footnotes">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="prefaceinfo" schema-tree-path="prefaceinfo">
				<children>
					<template subtype="element" match="prefaceinfo">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="primary" schema-tree-path="primary">
				<children>
					<template subtype="element" match="primary">
						<children>
							<text fixtext="&lt;"/>
							<content/>
							<text fixtext="&gt;"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="printhistory" schema-tree-path="printhistory">
				<children>
					<template subtype="element" match="printhistory">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="procedure" schema-tree-path="procedure">
				<children>
					<template subtype="element" match="procedure">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="programlisting" schema-tree-path="programlisting">
				<children>
					<template subtype="element" match="programlisting">
						<children>
							<paragraph paragraphtag="pre">
								<styles font-family="Courier New" font-size="x-small" white-space="pre"/>
								<children>
									<content>
										<styles font-family="Courier New" font-size="x-small" white-space="pre"/>
									</content>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="prompt" schema-tree-path="prompt">
				<children>
					<template subtype="element" match="prompt">
						<children>
							<content>
								<styles font-family="Courier New"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="qandadiv" schema-tree-path="qandadiv">
				<children>
					<template subtype="element" match="qandadiv">
						<children>
							<paragraph>
								<children>
									<template subtype="element" match="title">
										<children>
											<content>
												<styles font-size="medium" font-weight="bold"/>
											</content>
										</children>
										<variables/>
									</template>
									<newline/>
									<content restofcontents="1"/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="question" schema-tree-path="question">
				<children>
					<template subtype="element" match="question">
						<children>
							<text fixtext="Q: ">
								<styles font-size="medium" font-weight="bold"/>
							</text>
							<content/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="quote" schema-tree-path="quote">
				<children>
					<template subtype="element" match="quote">
						<children>
							<text fixtext="“"/>
							<content/>
							<text fixtext="”"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="refentry" schema-tree-path="refentry">
				<children>
					<template subtype="element" match="refentry">
						<children>
							<newline/>
							<text fixtext="NAME">
								<styles font-size="large" font-weight="bold"/>
							</text>
							<newline/>
							<newline/>
							<paragraph>
								<children>
									<template subtype="element" match="refnamediv">
										<children>
											<marker xpath="refnamediv/refname" name="xref" _xid="../@id">
												<children>
													<template subtype="element" match="refname">
														<children>
															<content/>
															<condition>
																<children>
																	<conditionbranch xpath="count( ../refname ) &gt; 1  and  count( ../refname ) != position()">
																		<children>
																			<text fixtext=","/>
																		</children>
																	</conditionbranch>
																</children>
															</condition>
														</children>
														<variables/>
													</template>
												</children>
											</marker>
											<text fixtext="- "/>
											<template subtype="element" match="refpurpose">
												<children>
													<content/>
												</children>
												<variables/>
											</template>
											<newline/>
											<content restofcontents="1"/>
										</children>
										<variables/>
									</template>
									<newline/>
									<template subtype="element" match="refsynopsisdiv">
										<children>
											<paragraph>
												<children>
													<content/>
												</children>
											</paragraph>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="refsect1">
										<children>
											<template subtype="element" match="title">
												<children>
													<content>
														<styles font-size="large" font-weight="bold"/>
													</content>
												</children>
												<variables/>
											</template>
											<paragraph>
												<children>
													<content restofcontents="1"/>
												</children>
											</paragraph>
										</children>
										<variables/>
									</template>
									<newline/>
									<template subtype="element" match="refsection">
										<children>
											<template subtype="element" match="title">
												<children>
													<content>
														<styles font-size="large" font-weight="bold"/>
													</content>
												</children>
												<variables/>
											</template>
											<newline/>
											<content restofcontents="1"/>
										</children>
										<variables/>
									</template>
									<newline/>
								</children>
							</paragraph>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="refentryinfo"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="refentryinfo" schema-tree-path="refentryinfo">
				<children>
					<template subtype="element" match="refentryinfo">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="refentrytitle" schema-tree-path="refentrytitle">
				<children>
					<template subtype="element" match="refentrytitle">
						<children>
							<content>
								<styles font-size="large" font-weight="bold"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="reference" schema-tree-path="reference">
				<children>
					<template subtype="element" levelflag="1" match="reference">
						<children>
							<newline break="page"/>
							<paragraph paragraphtag="h2">
								<children>
									<marker name="xref" _xid="@id">
										<children>
											<marker name="reference">
												<children>
													<text fixtext="Reference"/>
													<template subtype="element" match="title">
														<children>
															<text fixtext=" "/>
															<content/>
														</children>
														<variables/>
													</template>
												</children>
											</marker>
										</children>
									</marker>
								</children>
							</paragraph>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="referenceinfo"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<content restofcontents="1"/>
							<calltemplate subtype="named" match="footnotes">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="referenceinfo" schema-tree-path="referenceinfo">
				<children>
					<template subtype="element" match="referenceinfo">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="refmeta" schema-tree-path="refmeta">
				<children>
					<template subtype="element" match="refmeta">
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="refname" schema-tree-path="refname">
				<children>
					<template subtype="element" match="refname">
						<children>
							<content>
								<styles font-weight="bold"/>
							</content>
							<condition>
								<children>
									<conditionbranch xpath="position() =1">
										<children>
											<text fixtext="1">
												<styles font-weight="bold"/>
											</text>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="refnamediv" schema-tree-path="refnamediv">
				<children>
					<template subtype="element" match="refnamediv">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="refpurpose" schema-tree-path="refpurpose">
				<children>
					<template subtype="element" match="refpurpose">
						<children>
							<text fixtext=" "/>
							<content/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="refsect1info" schema-tree-path="refsect1info">
				<children>
					<template subtype="element" match="refsect1info">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="refsect2info" schema-tree-path="refsect2info">
				<children>
					<template subtype="element" match="refsect2info">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="refsect3info" schema-tree-path="refsect3info">
				<children>
					<template subtype="element" match="refsect3info">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="refsection" schema-tree-path="refsection">
				<children>
					<template subtype="element" match="refsection">
						<children>
							<newline/>
							<template subtype="element" match="title">
								<children>
									<content>
										<styles font-size="large" font-weight="bold"/>
									</content>
								</children>
								<variables/>
							</template>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="refsectioninfo"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<paragraph>
								<children>
									<content restofcontents="1"/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="refsectioninfo" schema-tree-path="refsectioninfo">
				<children>
					<template subtype="element" match="refsectioninfo">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="refsynopsisdiv" schema-tree-path="refsynopsisdiv">
				<children>
					<template subtype="element" match="refsynopsisdiv">
						<children>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="refsynopsisdivinfo"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<paragraph>
								<children>
									<content restofcontents="1"/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="refsynopsisdivinfo" schema-tree-path="refsynopsisdivinfo">
				<children>
					<template subtype="element" match="refsynopsisdivinfo">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="remark" schema-tree-path="remark">
				<children>
					<template subtype="element" match="remark">
						<children>
							<content>
								<styles font-style="italic"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="replaceable" schema-tree-path="replaceable">
				<children>
					<template subtype="element" match="replaceable">
						<children>
							<content>
								<styles font-family="Courier New" font-size="small" font-style="oblique"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="revdescription" schema-tree-path="revdescription">
				<children>
					<template subtype="element" match="revdescription">
						<children>
							<content>
								<styles font-style="italic"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="revhistory" schema-tree-path="revhistory">
				<children>
					<template subtype="element" match="revhistory">
						<children>
							<paragraph>
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
																	<text fixtext="Revision History">
																		<styles font-weight="bold"/>
																	</text>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<children>
																	<template subtype="element" match="revision">
																		<children>
																			<tgrid>
																				<properties border="0" width="100%"/>
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
																											<template subtype="element" match="revnumber">
																												<children>
																													<content/>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="date">
																												<children>
																													<content/>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="authorinitials">
																												<children>
																													<content/>
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
																											<template subtype="element" match="revremark">
																												<children>
																													<content/>
																												</children>
																												<variables/>
																											</template>
																										</children>
																									</tgridcell>
																									<tgridcell joinleft="1"/>
																									<tgridcell joinleft="1"/>
																								</children>
																							</tgridrow>
																						</children>
																					</tgridbody-rows>
																				</children>
																			</tgrid>
																		</children>
																		<variables/>
																	</template>
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
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="revision" schema-tree-path="revision">
				<children>
					<template subtype="element" match="revision">
						<children>
							<tgrid>
								<properties border="0" width="100%"/>
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
															<template subtype="element" match="revnumber">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="date">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="authorinitials">
																<children>
																	<content/>
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
															<template subtype="element" match="revremark">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell joinleft="1"/>
													<tgridcell joinleft="1"/>
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
			<globaltemplate subtype="element" match="revnumber" schema-tree-path="revnumber">
				<children>
					<template subtype="element" match="revnumber">
						<children>
							<text fixtext="Revision  "/>
							<content/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="sbr" schema-tree-path="sbr">
				<children>
					<template subtype="element" match="sbr">
						<children>
							<newline/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="screen" schema-tree-path="screen">
				<children>
					<template subtype="element" match="screen">
						<children>
							<paragraph paragraphtag="pre">
								<styles background-color="#F0F0F0" border-bottom="2px solid black" border-left="1px dotted black" border-right="2px solid black" border-top="1px dotted black" margin="0.5cm 1cm" padding="2px"/>
								<children>
									<content/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="screeninfo" schema-tree-path="screeninfo">
				<children>
					<template subtype="element" match="screeninfo">
						<children>
							<content/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="sect1" schema-tree-path="sect1">
				<children>
					<template subtype="element" levelflag="1" match="sect1">
						<children>
							<marker xpath="string( title )" name="xref" _xid="@id" uses="xpath"/>
							<template subtype="element" match="title">
								<children>
									<marker name="sect1">
										<children>
											<paragraph paragraphtag="h3">
												<children>
													<content/>
												</children>
											</paragraph>
										</children>
									</marker>
								</children>
								<variables/>
							</template>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="sect1info"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="sect1info" schema-tree-path="sect1info">
				<children>
					<template subtype="element" match="sect1info">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="sect2" schema-tree-path="sect2">
				<children>
					<template subtype="element" levelflag="1" match="sect2">
						<children>
							<marker xpath="string( title )" name="xref" _xid="@id" uses="xpath"/>
							<template subtype="element" match="title">
								<children>
									<marker name="sect2">
										<children>
											<paragraph paragraphtag="h4">
												<children>
													<content/>
												</children>
											</paragraph>
										</children>
									</marker>
								</children>
								<variables/>
							</template>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="sect2info"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="sect2info" schema-tree-path="sect2info">
				<children>
					<template subtype="element" match="sect2info">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="sect3" schema-tree-path="sect3">
				<children>
					<template subtype="element" levelflag="1" match="sect3">
						<children>
							<marker xpath="string( title )" name="xref" _xid="@id" uses="xpath"/>
							<template subtype="element" match="title">
								<children>
									<marker name="sect3">
										<children>
											<paragraph paragraphtag="h5">
												<children>
													<content/>
												</children>
											</paragraph>
										</children>
									</marker>
								</children>
								<variables/>
							</template>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="sect3info"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="sect3info" schema-tree-path="sect3info">
				<children>
					<template subtype="element" match="sect3info">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="sect4" schema-tree-path="sect4">
				<children>
					<template subtype="element" levelflag="1" match="sect4">
						<children>
							<marker xpath="string( title )" name="xref" _xid="@id" uses="xpath"/>
							<template subtype="element" match="title">
								<children>
									<marker name="sect4">
										<children>
											<paragraph paragraphtag="h6">
												<children>
													<content/>
												</children>
											</paragraph>
										</children>
									</marker>
								</children>
								<variables/>
							</template>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="sect4info"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="sect4info" schema-tree-path="sect4info">
				<children>
					<template subtype="element" match="sect4info">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="sect5" schema-tree-path="sect5">
				<children>
					<template subtype="element" levelflag="1" match="sect5">
						<children>
							<marker xpath="string( title )" name="xref" _xid="@id" uses="xpath"/>
							<template subtype="element" match="title">
								<children>
									<marker name="sect5">
										<children>
											<paragraph paragraphtag="h6">
												<children>
													<content/>
												</children>
											</paragraph>
										</children>
									</marker>
								</children>
								<variables/>
							</template>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="sect5info"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="sect5info" schema-tree-path="sect5info">
				<children>
					<template subtype="element" match="sect5info">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="section" schema-tree-path="section">
				<children>
					<template subtype="element" levelflag="1" match="section">
						<children>
							<condition>
								<children>
									<conditionbranch xpath="../../../../../../section">
										<children>
											<template subtype="element" match="title">
												<children>
													<paragraph paragraphtag="h6">
														<children>
															<content/>
														</children>
													</paragraph>
												</children>
												<variables/>
											</template>
										</children>
									</conditionbranch>
									<conditionbranch xpath="../../../../section">
										<children>
											<template subtype="element" match="title">
												<children>
													<paragraph paragraphtag="h5">
														<children>
															<content/>
														</children>
													</paragraph>
												</children>
												<variables/>
											</template>
										</children>
									</conditionbranch>
									<conditionbranch xpath="../../../section">
										<children>
											<template subtype="element" match="title">
												<children>
													<paragraph paragraphtag="h4">
														<children>
															<content/>
														</children>
													</paragraph>
												</children>
												<variables/>
											</template>
										</children>
									</conditionbranch>
									<conditionbranch xpath="../../section">
										<children>
											<template subtype="element" match="title">
												<children>
													<paragraph paragraphtag="h3">
														<children>
															<content/>
														</children>
													</paragraph>
												</children>
												<variables/>
											</template>
										</children>
									</conditionbranch>
									<conditionbranch xpath="../section">
										<children>
											<template subtype="element" match="title">
												<children>
													<paragraph paragraphtag="h2">
														<children>
															<content/>
														</children>
													</paragraph>
												</children>
												<variables/>
											</template>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="sectioninfo"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="sectioninfo" schema-tree-path="sectioninfo">
				<children>
					<template subtype="element" match="sectioninfo">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="seeie" schema-tree-path="seeie">
				<children>
					<template subtype="element" match="seeie">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="seglistitem" schema-tree-path="seglistitem">
				<children>
					<template subtype="element" match="seglistitem">
						<children>
							<newline/>
							<tgrid>
								<properties border="0"/>
								<children>
									<tgridbody-cols>
										<children>
											<template subtype="element" match="seg">
												<children>
													<tgridcol>
														<properties width="100"/>
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
														<properties align="center"/>
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
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="segmentedlist" schema-tree-path="segmentedlist">
				<children>
					<template subtype="element" match="segmentedlist">
						<children>
							<paragraph>
								<children>
									<template subtype="element" match="title">
										<children>
											<content>
												<styles font-size="large" font-weight="bold"/>
											</content>
										</children>
										<variables/>
									</template>
									<newline/>
									<template subtype="element" match="titleabbrev">
										<children>
											<content>
												<styles font-weight="bold"/>
											</content>
										</children>
										<variables/>
									</template>
									<newline/>
									<tgrid>
										<properties border="0"/>
										<children>
											<tgridbody-cols>
												<children>
													<template subtype="element" match="segtitle">
														<children>
															<tgridcol>
																<properties width="99"/>
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
																<properties align="center"/>
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
							</paragraph>
							<content restofcontents="1"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="segtitle" schema-tree-path="segtitle">
				<children>
					<template subtype="element" match="segtitle">
						<children>
							<content>
								<styles font-weight="bold"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="setindexinfo" schema-tree-path="setindexinfo">
				<children>
					<template subtype="element" match="setindexinfo">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="setinfo" schema-tree-path="setinfo">
				<children>
					<template subtype="element" match="setinfo">
						<children>
							<calltemplate subtype="named" match="info">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="sgmltag" schema-tree-path="sgmltag">
				<children>
					<template subtype="element" match="sgmltag">
						<children>
							<text fixtext="&lt;">
								<styles font-family="Arial Narrow" font-weight="bold"/>
							</text>
							<content>
								<styles font-family="Arial Narrow" font-weight="bold"/>
							</content>
							<text fixtext="&gt;">
								<styles font-family="Arial Narrow" font-weight="bold"/>
							</text>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="shortcut" schema-tree-path="shortcut">
				<children>
					<template subtype="element" match="shortcut">
						<children>
							<text fixtext="(">
								<styles font-weight="bold"/>
							</text>
							<content>
								<styles font-weight="bold"/>
							</content>
							<text fixtext=")">
								<styles font-weight="bold"/>
							</text>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="sidebar" schema-tree-path="sidebar">
				<children>
					<template subtype="element" match="sidebar">
						<children>
							<paragraph>
								<styles background-color="#F0DCAA" border="1px solid black" margin-bottom="10px" margin-top="10px" padding="2px"/>
								<children>
									<template subtype="element" match="title">
										<children>
											<paragraph paragraphtag="h2">
												<styles text-align="center"/>
												<children>
													<content/>
												</children>
											</paragraph>
										</children>
										<variables/>
									</template>
									<content restofcontents="1"/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="simpara" schema-tree-path="simpara">
				<children>
					<template subtype="element" match="simpara">
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
			<globaltemplate subtype="element" match="simplelist" schema-tree-path="simplelist">
				<children>
					<template subtype="element" match="simplelist">
						<children>
							<newline/>
							<list>
								<styles margin-bottom="0" margin-top="0"/>
								<children>
									<template subtype="element" match="member">
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
							<newline/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="simplemsgentry" schema-tree-path="simplemsgentry">
				<children>
					<template subtype="element" match="simplemsgentry">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="simplesect" schema-tree-path="simplesect">
				<children>
					<template subtype="element" match="simplesect">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="step" schema-tree-path="step">
				<children>
					<list>
						<styles margin-bottom="0" margin-top="0"/>
						<children>
							<template subtype="element" match="step">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="structfield" schema-tree-path="structfield">
				<children>
					<template subtype="element" match="structfield">
						<children>
							<content>
								<styles font-style="italic"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="subscript" schema-tree-path="subscript">
				<children>
					<template subtype="element" match="subscript">
						<children>
							<content>
								<styles font-size="xx-small" vertical-Align="sub"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="substeps" schema-tree-path="substeps">
				<children>
					<template subtype="element" match="substeps">
						<children>
							<content>
								<styles text-indent="2cm"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="subtitle" schema-tree-path="subtitle">
				<children>
					<template subtype="element" match="subtitle">
						<children>
							<paragraph>
								<styles font-size="medium" font-style="italic" font-weight="bold"/>
								<children>
									<content>
										<styles font-size="medium" font-style="italic" font-weight="bold"/>
									</content>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="superscript" schema-tree-path="superscript">
				<children>
					<template subtype="element" match="superscript">
						<children>
							<content>
								<styles font-size="xx-small" vertical-Align="super"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="synopfragment" schema-tree-path="synopfragment">
				<children>
					<template subtype="element" match="synopfragment">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="term" schema-tree-path="term">
				<children>
					<template subtype="element" match="term">
						<children>
							<content/>
							<condition>
								<children>
									<conditionbranch xpath="count( ../term ) &gt;1  and  count( ../term ) !=  position()">
										<children>
											<text fixtext=", "/>
										</children>
									</conditionbranch>
									<conditionbranch/>
								</children>
							</condition>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="textdata" schema-tree-path="textdata">
				<children>
					<template subtype="element" match="textdata">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="tip" schema-tree-path="tip">
				<children>
					<template subtype="element" match="tip">
						<children>
							<paragraph>
								<styles background-color="#E0F4FF" border="1px solid black" margin="0.5cm 1cm" padding="2px"/>
								<children>
									<paragraph paragraphtag="center">
										<children>
											<text fixtext="TIP"/>
										</children>
									</paragraph>
									<content/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="title" schema-tree-path="title">
				<children>
					<template subtype="element" match="title">
						<children>
							<paragraph paragraphtag="h2">
								<children>
									<content/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="titleabbrev" schema-tree-path="titleabbrev">
				<children>
					<template subtype="element" match="titleabbrev">
						<children>
							<text fixtext="["/>
							<content/>
							<text fixtext="]"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="tocback" schema-tree-path="tocback">
				<children>
					<template subtype="element" match="tocback">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="tocchap" schema-tree-path="tocchap">
				<children>
					<template subtype="element" match="tocchap">
						<children>
							<newline/>
							<template subtype="element" match="tocentry">
								<children>
									<content/>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="toclevel1">
								<children>
									<newline/>
									<template subtype="element" match="tocentry">
										<children>
											<content>
												<styles margin-left=".5cm"/>
											</content>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="toclevel2">
										<children>
											<newline/>
											<template subtype="element" match="tocentry">
												<children>
													<content>
														<styles margin-left="1cm"/>
													</content>
												</children>
												<variables/>
											</template>
											<template subtype="element" match="toclevel3">
												<children>
													<newline/>
													<template subtype="element" match="tocentry">
														<children>
															<content>
																<styles margin-left="1.5cm"/>
															</content>
														</children>
														<variables/>
													</template>
													<template subtype="element" match="toclevel4">
														<children>
															<newline/>
															<template subtype="element" match="tocentry">
																<children>
																	<content>
																		<styles margin-left="2.0cm"/>
																	</content>
																</children>
																<variables/>
															</template>
															<template subtype="element" match="toclevel5">
																<children>
																	<newline/>
																	<template subtype="element" match="tocentry">
																		<children>
																			<content>
																				<styles margin-left="2.5cm"/>
																			</content>
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
			<globaltemplate subtype="element" match="tocentry" schema-tree-path="tocentry">
				<children>
					<template subtype="element" match="tocentry">
						<children>
							<newline/>
							<content/>
							<newline/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="tocfront" schema-tree-path="tocfront">
				<children>
					<template subtype="element" match="tocfront">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="toclevel1" schema-tree-path="toclevel1">
				<children>
					<template subtype="element" match="toclevel1">
						<children>
							<template subtype="element" match="tocentry">
								<children>
									<content>
										<styles margin-left=".5cm"/>
									</content>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="toclevel2">
								<children>
									<content>
										<styles margin-left=".5cm"/>
									</content>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="toclevel2" schema-tree-path="toclevel2">
				<children>
					<template subtype="element" match="toclevel2">
						<children>
							<template subtype="element" match="tocentry">
								<children>
									<content>
										<styles margin-left="1cm"/>
									</content>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="toclevel3">
								<children>
									<content>
										<styles margin-left="1cm"/>
									</content>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="toclevel3" schema-tree-path="toclevel3">
				<children>
					<template subtype="element" match="toclevel3">
						<children>
							<template subtype="element" match="tocentry">
								<children>
									<content>
										<styles margin-left="1cm"/>
									</content>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="toclevel4">
								<children>
									<content/>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="toclevel4" schema-tree-path="toclevel4">
				<children>
					<template subtype="element" match="toclevel4">
						<children>
							<template subtype="element" match="tocentry">
								<children>
									<content>
										<styles margin-left="2.5cm"/>
									</content>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="toclevel5">
								<children>
									<newline/>
									<content>
										<styles margin-left="2.5cm"/>
									</content>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="toclevel5" schema-tree-path="toclevel5">
				<children>
					<template subtype="element" match="toclevel5">
						<children>
							<content>
								<styles text-indent="4cm"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="tocpart" schema-tree-path="tocpart">
				<children>
					<template subtype="element" match="tocpart">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="token" schema-tree-path="token">
				<children>
					<template subtype="element" match="token">
						<children>
							<content>
								<styles font-size="medium"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="ulink" schema-tree-path="ulink">
				<children>
					<template subtype="element" match="ulink">
						<children>
							<link>
								<children>
									<content/>
									<condition>
										<children>
											<conditionbranch xpath="not(text()|node())">
												<children>
													<template subtype="attribute" match="url">
														<children>
															<content/>
														</children>
														<variables/>
													</template>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<xpath value="@url"/>
								</hyperlink>
							</link>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<text fixtext="  "/>
											<paragraph>
												<properties class="inlineinfo"/>
												<styles display="inline"/>
												<children>
													<text fixtext="link to "/>
													<template subtype="attribute" match="url">
														<children>
															<content/>
														</children>
														<variables/>
													</template>
												</children>
											</paragraph>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="userinput" schema-tree-path="userinput">
				<children>
					<template subtype="element" match="userinput">
						<children>
							<content>
								<styles font-family="Courier New" font-weight="bold"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="variablelist" schema-tree-path="variablelist">
				<children>
					<template subtype="element" match="variablelist">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="varlistentry" schema-tree-path="varlistentry">
				<children>
					<template subtype="element" match="varlistentry">
						<children>
							<calltemplate subtype="element" match="term"/>
							<template subtype="element" match="listitem">
								<children>
									<paragraph paragraphtag="blockquote">
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
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="varname" schema-tree-path="varname">
				<children>
					<template subtype="element" match="varname">
						<children>
							<content>
								<styles font-family="Courier New"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="videodata" schema-tree-path="videodata">
				<children>
					<template subtype="element" match="videodata">
						<children>
							<template subtype="attribute" match="fileref">
								<children>
									<text fixtext="(">
										<styles font-style="italic"/>
									</text>
									<content>
										<styles font-style="italic"/>
										<format basic-type="xsd" datatype="CDATA"/>
									</content>
									<text fixtext=")">
										<styles font-style="italic"/>
									</text>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="void" schema-tree-path="void">
				<children>
					<template subtype="element" match="void">
						<children>
							<condition>
								<children>
									<conditionbranch xpath="position() = last()  and  not( ../methodparam )">
										<children>
											<text fixtext="(">
												<styles font-family="Courier New"/>
											</text>
											<content>
												<styles font-family="Courier New"/>
											</content>
											<text fixtext=");">
												<styles font-family="Courier New"/>
											</text>
										</children>
									</conditionbranch>
									<conditionbranch xpath="position() != last()  or   not( ../type )">
										<children>
											<text fixtext="void">
												<styles font-family="Courier New"/>
											</text>
										</children>
									</conditionbranch>
									<conditionbranch xpath="position()  =  last() and  boolean( ../methodparam )">
										<children>
											<text fixtext="invalid state of XML">
												<styles color="red" font-family="Courier New" font-weight="bold"/>
											</text>
										</children>
									</conditionbranch>
									<conditionbranch>
										<children>
											<text fixtext="void">
												<styles font-family="Courier New"/>
											</text>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="warning" schema-tree-path="warning">
				<children>
					<template subtype="element" match="warning">
						<children>
							<paragraph>
								<styles background-color="#FFD2D2" border="1px solid black" margin="0.5cm 1cm" padding="2px"/>
								<children>
									<paragraph paragraphtag="center">
										<children>
											<text fixtext="WARNING">
												<styles font-weight="bold"/>
											</text>
										</children>
									</paragraph>
									<content/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="wordasword" schema-tree-path="wordasword">
				<children>
					<template subtype="element" match="wordasword">
						<children>
							<content>
								<styles font-style="italic"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="xref" schema-tree-path="xref">
				<children>
					<template subtype="element" match="xref">
						<editorproperties editable="1" adding="mandatory" markupmode="large"/>
						<children>
							<ref name="xref" _xid="@linkend" scope="global" createhyperlink="1">
								<children>
									<field type="ref-entrytext"/>
								</children>
							</ref>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<text fixtext=" "/>
											<paragraph>
												<properties class="inlineinfo"/>
												<styles display="inline"/>
												<children>
													<text fixtext="xref to "/>
													<template subtype="attribute" match="linkend">
														<children>
															<content>
																<format basic-type="xsd" datatype="IDREF"/>
															</content>
														</children>
														<variables/>
													</template>
												</children>
											</paragraph>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="year" schema-tree-path="year">
				<children>
					<template subtype="element" match="year">
						<children>
							<text fixtext=" "/>
							<content/>
							<text fixtext=" "/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="toc" schema-tree-path="toc">
				<children>
					<template subtype="element" match="toc">
						<children>
							<newline break="page"/>
							<paragraph paragraphtag="h2">
								<children>
									<marker name="xref" _xid="@id">
										<children>
											<marker name="toc">
												<children>
													<text fixtext="Table of Contents"/>
													<template subtype="element" match="title">
														<children>
															<text fixtext=" "/>
															<content/>
														</children>
														<variables/>
													</template>
												</children>
											</marker>
										</children>
									</marker>
								</children>
							</paragraph>
							<content restofcontents="1"/>
							<toc name="toc">
								<children>
									<reflevel>
										<children>
											<paragraph>
												<styles margin-left="0.5cm"/>
												<children>
													<ref name="preface" createhyperlink="1">
														<children>
															<field type="ref-entrytext"/>
															<condition>
																<children>
																	<conditionbranch xpath="$SV_OutputFormat = &apos;RTF&apos;">
																		<children>
																			<field type="ref-leader"/>
																			<field type="ref-pageref"/>
																		</children>
																	</conditionbranch>
																	<conditionbranch xpath="$SV_OutputFormat = &apos;PDF&apos;">
																		<children>
																			<field type="ref-leader"/>
																			<field type="ref-pageref"/>
																		</children>
																	</conditionbranch>
																	<conditionbranch xpath="$SV_OutputFormat = &apos;Word2007&apos;">
																		<children>
																			<field type="ref-leader"/>
																			<field type="ref-pageref"/>
																		</children>
																	</conditionbranch>
																</children>
															</condition>
														</children>
													</ref>
													<ref name="chapter" createhyperlink="1">
														<children>
															<field type="ref-entrytext"/>
															<condition>
																<children>
																	<conditionbranch xpath="$SV_OutputFormat = &apos;RTF&apos;">
																		<children>
																			<field type="ref-leader"/>
																			<field type="ref-pageref"/>
																		</children>
																	</conditionbranch>
																	<conditionbranch xpath="$SV_OutputFormat = &apos;PDF&apos;">
																		<children>
																			<field type="ref-leader"/>
																			<field type="ref-pageref"/>
																		</children>
																	</conditionbranch>
																	<conditionbranch xpath="$SV_OutputFormat = &apos;Word2007&apos;">
																		<children>
																			<field type="ref-leader"/>
																			<field type="ref-pageref"/>
																		</children>
																	</conditionbranch>
																</children>
															</condition>
														</children>
													</ref>
													<ref name="appendix" createhyperlink="1">
														<children>
															<field type="ref-entrytext"/>
															<condition>
																<children>
																	<conditionbranch xpath="$SV_OutputFormat = &apos;RTF&apos;">
																		<children>
																			<field type="ref-leader"/>
																			<field type="ref-pageref"/>
																		</children>
																	</conditionbranch>
																	<conditionbranch xpath="$SV_OutputFormat = &apos;PDF&apos;">
																		<children>
																			<field type="ref-leader"/>
																			<field type="ref-pageref"/>
																		</children>
																	</conditionbranch>
																	<conditionbranch xpath="$SV_OutputFormat = &apos;Word2007&apos;">
																		<children>
																			<field type="ref-leader"/>
																			<field type="ref-pageref"/>
																		</children>
																	</conditionbranch>
																</children>
															</condition>
														</children>
													</ref>
													<ref name="index" createhyperlink="1">
														<children>
															<field type="ref-entrytext"/>
															<condition>
																<children>
																	<conditionbranch xpath="$SV_OutputFormat = &apos;RTF&apos;">
																		<children>
																			<field type="ref-leader"/>
																			<field type="ref-pageref"/>
																		</children>
																	</conditionbranch>
																	<conditionbranch xpath="$SV_OutputFormat = &apos;PDF&apos;">
																		<children>
																			<field type="ref-leader"/>
																			<field type="ref-pageref"/>
																		</children>
																	</conditionbranch>
																	<conditionbranch xpath="$SV_OutputFormat = &apos;Word2007&apos;">
																		<children>
																			<field type="ref-leader"/>
																			<field type="ref-pageref"/>
																		</children>
																	</conditionbranch>
																</children>
															</condition>
														</children>
													</ref>
												</children>
											</paragraph>
											<reflevel>
												<children>
													<paragraph>
														<styles margin-left="1cm"/>
														<children>
															<ref name="sect1" createhyperlink="1">
																<children>
																	<field type="ref-entrytext"/>
																	<condition>
																		<children>
																			<conditionbranch xpath="$SV_OutputFormat = &apos;RTF&apos;">
																				<children>
																					<field type="ref-leader"/>
																					<field type="ref-pageref"/>
																				</children>
																			</conditionbranch>
																			<conditionbranch xpath="$SV_OutputFormat = &apos;PDF&apos;">
																				<children>
																					<field type="ref-leader"/>
																					<field type="ref-pageref"/>
																				</children>
																			</conditionbranch>
																			<conditionbranch xpath="$SV_OutputFormat = &apos;Word2007&apos;">
																				<children>
																					<field type="ref-leader"/>
																					<field type="ref-pageref"/>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																</children>
															</ref>
														</children>
													</paragraph>
													<reflevel>
														<children>
															<paragraph>
																<styles margin-left="1.5cm"/>
																<children>
																	<ref name="sect2" createhyperlink="1">
																		<children>
																			<field type="ref-entrytext"/>
																			<condition>
																				<children>
																					<conditionbranch xpath="$SV_OutputFormat = &apos;RTF&apos;">
																						<children>
																							<field type="ref-leader"/>
																							<field type="ref-pageref"/>
																						</children>
																					</conditionbranch>
																					<conditionbranch xpath="$SV_OutputFormat = &apos;PDF&apos;">
																						<children>
																							<field type="ref-leader"/>
																							<field type="ref-pageref"/>
																						</children>
																					</conditionbranch>
																					<conditionbranch xpath="$SV_OutputFormat = &apos;Word2007&apos;">
																						<children>
																							<field type="ref-leader"/>
																							<field type="ref-pageref"/>
																						</children>
																					</conditionbranch>
																				</children>
																			</condition>
																		</children>
																	</ref>
																</children>
															</paragraph>
														</children>
													</reflevel>
												</children>
											</reflevel>
										</children>
									</reflevel>
								</children>
							</toc>
							<newline break="page"/>
							<paragraph paragraphtag="h2">
								<children>
									<text fixtext="List of Figures"/>
								</children>
							</paragraph>
							<toc name="toc">
								<children>
									<ref name="figure" scope="global" createhyperlink="1">
										<children>
											<paragraph>
												<styles margin-left="0.5cm"/>
												<children>
													<field type="ref-entrytext"/>
													<condition>
														<children>
															<conditionbranch xpath="$SV_OutputFormat = &apos;RTF&apos;">
																<children>
																	<field type="ref-leader"/>
																	<field type="ref-pageref"/>
																</children>
															</conditionbranch>
															<conditionbranch xpath="$SV_OutputFormat = &apos;PDF&apos;">
																<children>
																	<field type="ref-leader"/>
																	<field type="ref-pageref"/>
																</children>
															</conditionbranch>
															<conditionbranch xpath="$SV_OutputFormat = &apos;Word2007&apos;">
																<children>
																	<field type="ref-leader"/>
																	<field type="ref-pageref"/>
																</children>
															</conditionbranch>
														</children>
													</condition>
												</children>
											</paragraph>
										</children>
									</ref>
								</children>
							</toc>
							<newline break="page"/>
							<paragraph paragraphtag="h2">
								<children>
									<text fixtext="List of Examples"/>
								</children>
							</paragraph>
							<toc name="toc">
								<children>
									<ref name="example" scope="global" createhyperlink="1">
										<children>
											<paragraph>
												<styles margin-left="0.5cm"/>
												<children>
													<field type="ref-entrytext"/>
													<condition>
														<children>
															<conditionbranch xpath="$SV_OutputFormat = &apos;RTF&apos;">
																<children>
																	<field type="ref-leader"/>
																	<field type="ref-pageref"/>
																</children>
															</conditionbranch>
															<conditionbranch xpath="$SV_OutputFormat = &apos;PDF&apos;">
																<children>
																	<field type="ref-leader"/>
																	<field type="ref-pageref"/>
																</children>
															</conditionbranch>
															<conditionbranch xpath="$SV_OutputFormat = &apos;Word2007&apos;">
																<children>
																	<field type="ref-leader"/>
																	<field type="ref-pageref"/>
																</children>
															</conditionbranch>
														</children>
													</condition>
												</children>
											</paragraph>
										</children>
									</ref>
								</children>
							</toc>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="glossary" schema-tree-path="glossary">
				<children>
					<template subtype="element" match="glossary">
						<children>
							<newline break="page"/>
							<paragraph paragraphtag="h2">
								<children>
									<marker xpath="." name="xref" _xid="@id">
										<children>
											<marker name="glossary">
												<children>
													<text fixtext="Glossary"/>
													<template subtype="element" match="title">
														<children>
															<text fixtext=" "/>
															<content/>
														</children>
														<variables/>
													</template>
												</children>
											</marker>
										</children>
									</marker>
								</children>
							</paragraph>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos; and $show-info = &apos;true&apos;">
										<children>
											<calltemplate subtype="element" match="glossaryinfo"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<content restofcontents="1"/>
							<calltemplate subtype="named" match="footnotes">
								<parameters/>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</globalparts>
	<pagelayout>
		<properties pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="1" paperheight="11in" papermarginbottom="0.79in" papermarginleft="0.6in" papermarginright="0.6in" papermargintop="0.79in" paperwidth="8.5in"/>
	</pagelayout>
	<designfragments>
		<children>
			<globaltemplate subtype="named" match="info">
				<parameters/>
				<children>
					<paragraph>
						<properties class="info"/>
						<children>
							<tgrid>
								<properties width="100%"/>
								<children>
									<tgridbody-cols>
										<children>
											<tgridcol/>
										</children>
									</tgridbody-cols>
									<tgridheader-rows>
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<children>
															<autocalc xpath="substring-before(local-name(),&apos;info&apos;)"/>
															<text fixtext=" meta-information"/>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
										</children>
									</tgridheader-rows>
									<tgridbody-rows>
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties align="right"/>
														<children>
															<template subtype="element" match="graphic">
																<children>
																	<image>
																		<properties border="0"/>
																		<target>
																			<xpath value="@fileref"/>
																		</target>
																		<imagesource>
																			<xpath value="@fileref"/>
																		</imagesource>
																	</image>
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
							<template subtype="element" match="title">
								<children>
									<content>
										<styles font-size="large" font-weight="bold"/>
									</content>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="subtitle">
								<children>
									<content>
										<styles font-style="italic"/>
									</content>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="author">
								<children>
									<tgrid>
										<properties border="0" width="100%"/>
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
																	<text fixtext="Author"/>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<template subtype="element" match="personname">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																	<newline/>
																	<template subtype="element" match="honorific">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																	<template subtype="element" match="firstname">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																	<template subtype="element" match="surname">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																	<template subtype="element" match="lineage">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																	<newline/>
																	<template subtype="element" match="othername">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<template subtype="element" match="affiliation">
																		<children>
																			<template subtype="element" match="shortaffil">
																				<children>
																					<content/>
																				</children>
																				<variables/>
																			</template>
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
																											<template subtype="element" match="jobtitle">
																												<children>
																													<content/>
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
																											<template subtype="element" match="orgdiv">
																												<children>
																													<content/>
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
																											<template subtype="element" match="orgname">
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
																					</tgridbody-rows>
																				</children>
																			</tgrid>
																			<template subtype="element" match="address">
																				<children>
																					<content/>
																				</children>
																				<variables/>
																			</template>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<template subtype="element" match="email">
																		<children>
																			<content/>
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
															<tgridcell/>
															<tgridcell>
																<properties align="center"/>
																<children>
																	<template subtype="element" match="authorblurb">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell joinleft="1">
																<properties align="center"/>
															</tgridcell>
														</children>
													</tgridrow>
												</children>
											</tgridbody-rows>
										</children>
									</tgrid>
									<content restofcontents="1"/>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="authorgroup">
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
																	<template subtype="element" match="author">
																		<children>
																			<content/>
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
																	<template subtype="element" match="editor">
																		<children>
																			<content/>
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
																	<template subtype="element" match="collab">
																		<children>
																			<content/>
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
																	<template subtype="element" match="corpauthor">
																		<children>
																			<content/>
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
																	<template subtype="element" match="othercredit">
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
											</tgridbody-rows>
										</children>
									</tgrid>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="editor">
								<children>
									<tgrid>
										<properties border="0" width="100%"/>
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
																	<text fixtext="editor"/>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<template subtype="element" match="personname">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																	<newline/>
																	<template subtype="element" match="honorific">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																	<template subtype="element" match="firstname">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																	<template subtype="element" match="surname">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																	<template subtype="element" match="lineage">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																	<newline/>
																	<template subtype="element" match="othername">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<template subtype="element" match="affiliation">
																		<children>
																			<template subtype="element" match="shortaffil">
																				<children>
																					<content/>
																				</children>
																				<variables/>
																			</template>
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
																											<template subtype="element" match="jobtitle">
																												<children>
																													<content/>
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
																											<template subtype="element" match="orgdiv">
																												<children>
																													<content/>
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
																											<template subtype="element" match="orgname">
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
																					</tgridbody-rows>
																				</children>
																			</tgrid>
																			<template subtype="element" match="address">
																				<children>
																					<content/>
																				</children>
																				<variables/>
																			</template>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell/>
															<tgridcell>
																<children>
																	<template subtype="element" match="email">
																		<children>
																			<content/>
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
															<tgridcell/>
															<tgridcell>
																<properties align="center"/>
																<children>
																	<template subtype="element" match="authorblurb">
																		<children>
																			<content/>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell joinleft="1">
																<properties align="center"/>
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
							<newline/>
							<tgrid>
								<properties border="0" width="100%"/>
								<children>
									<tgridbody-cols>
										<children>
											<tgridcol>
												<properties width="203"/>
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
															<template subtype="element" match="isbn">
																<children>
																	<text fixtext="ISBN #:"/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="isbn">
																<children>
																	<content/>
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
															<template subtype="element" match="issn">
																<children>
																	<text fixtext="ISSN #:"/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="issn">
																<children>
																	<content/>
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
															<template subtype="element" match="copyright">
																<children>
																	<text fixtext="Copyright:"/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="copyright">
																<children>
																	<content/>
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
															<template subtype="element" match="publisher">
																<children>
																	<text fixtext="Publisher:"/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="publisher">
																<children>
																	<content/>
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
															<template subtype="element" match="publishername">
																<children>
																	<text fixtext="Publisher Name:"/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="publishername">
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
									</tgridbody-rows>
								</children>
							</tgrid>
							<newline/>
							<newline/>
							<template subtype="element" match="abstract">
								<children>
									<paragraph>
										<children>
											<content/>
										</children>
									</paragraph>
								</children>
								<variables/>
							</template>
							<newline/>
							<tgrid>
								<properties border="0" width="100%"/>
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
															<template subtype="element" match="keywordset">
																<children>
																	<text fixtext="Keywords: "/>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="subjectset">
																<children>
																	<content/>
																</children>
																<variables/>
															</template>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="element" match="biblioset">
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
									</tgridbody-rows>
								</children>
							</tgrid>
							<newline/>
							<template subtype="element" match="legalnotice">
								<children>
									<paragraph>
										<children>
											<content/>
										</children>
									</paragraph>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="revhistory">
								<children>
									<content/>
								</children>
								<variables/>
							</template>
							<newline/>
							<content restofcontents="1"/>
						</children>
					</paragraph>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="footnotes">
				<parameters/>
				<children>
					<template subtype="userdefined" match=".//footnote">
						<children>
							<paragraph>
								<children>
									<marker xpath="." name="footnote" _xid="count(preceding::footnote)">
										<children>
											<tgrid>
												<properties width="100%"/>
												<children>
													<tgridbody-cols>
														<children>
															<tgridcol>
																<styles width="5%"/>
															</tgridcol>
															<tgridcol>
																<styles width="95%"/>
															</tgridcol>
														</children>
													</tgridbody-cols>
													<tgridbody-rows>
														<children>
															<tgridrow>
																<children>
																	<tgridcell>
																		<styles vertical-align="top"/>
																		<children>
																			<text fixtext="[">
																				<styles vertical-align="super"/>
																			</text>
																			<num-seq format="1">
																				<styles vertical-align="super"/>
																			</num-seq>
																			<text fixtext="]">
																				<styles vertical-align="super"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell>
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
									</marker>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</designfragments>
	<xmltables>
		<children>
			<xmltable>
				<children>
					<xmltable-tag tag-name="table">
						<styles border="1px solid black"/>
					</xmltable-tag>
					<xmltable-tag tag-type="Caption" tag-name="title"/>
					<xmltable-tag tag-type="Group" tag-name="tgroup"/>
					<xmltable-tag tag-type="Header" tag-name="thead">
						<styles font-weight="bold"/>
					</xmltable-tag>
					<xmltable-tag tag-type="Footer" tag-name="tfoot">
						<styles font-weight="bold"/>
					</xmltable-tag>
					<xmltable-tag tag-type="Body" tag-name="tbody"/>
					<xmltable-tag tag-type="Row" tag-name="row"/>
					<xmltable-tag tag-type="Cell" tag-name="entry">
						<styles border="1px solid black"/>
					</xmltable-tag>
					<xmltable-tag tag-type="SubTable" tag-name="entrytbl"/>
					<xmltable-tag tag-type="ColSpec" tag-name="colspec"/>
					<xmltable-tag tag-type="SpanSpec" tag-name="spanspec"/>
				</children>
			</xmltable>
			<xmltable>
				<children>
					<xmltable-tag tag-name="informaltable">
						<styles border="1px solid black"/>
					</xmltable-tag>
					<xmltable-tag tag-type="Caption"/>
					<xmltable-tag tag-type="Group" tag-name="tgroup"/>
					<xmltable-tag tag-type="Header" tag-name="thead">
						<styles font-weight="bold"/>
					</xmltable-tag>
					<xmltable-tag tag-type="Footer" tag-name="tfoot">
						<styles font-weight="bold"/>
					</xmltable-tag>
					<xmltable-tag tag-type="Body" tag-name="tbody"/>
					<xmltable-tag tag-type="Row" tag-name="row"/>
					<xmltable-tag tag-type="Cell" tag-name="entry">
						<styles border="1px solid black"/>
					</xmltable-tag>
					<xmltable-tag tag-type="SubTable" tag-name="entrytbl"/>
					<xmltable-tag tag-type="ColSpec" tag-name="colspec"/>
					<xmltable-tag tag-type="SpanSpec" tag-name="spanspec"/>
				</children>
			</xmltable>
			<xmltable type="HTML">
				<children>
					<xmltable-tag tag-name="table"/>
					<xmltable-tag tag-type="Caption" tag-name="caption"/>
					<xmltable-tag tag-type="Header" tag-name="thead">
						<styles font-weight="bold"/>
					</xmltable-tag>
					<xmltable-tag tag-type="Footer" tag-name="tfoot">
						<styles font-weight="bold"/>
					</xmltable-tag>
					<xmltable-tag tag-type="Body" tag-name="tbody"/>
					<xmltable-tag tag-type="Row" tag-name="tr"/>
					<xmltable-tag tag-type="Cell" tag-name="td"/>
					<xmltable-tag tag-type="HeaderCell" tag-name="th"/>
				</children>
			</xmltable>
			<xmltable type="HTML">
				<children>
					<xmltable-tag tag-name="informaltable"/>
					<xmltable-tag tag-type="Caption"/>
					<xmltable-tag tag-type="Header" tag-name="thead">
						<styles font-weight="bold"/>
					</xmltable-tag>
					<xmltable-tag tag-type="Footer" tag-name="tfoot">
						<styles font-weight="bold"/>
					</xmltable-tag>
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
