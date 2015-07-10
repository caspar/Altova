<?xml version="1.0" encoding="UTF-8"?>
<structure version="14" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="UTF-8" encodingpdf="UTF-8" useimportschema="1" embed-images="1" pastemode="xml" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces/>
		<schemasources>
			<xsdschemasource name="XML1" main="1" schemafile="http://www.altova.com/schemas/xmlspec/xmlspec.dtd" workingxmlfile="xml.xml" templatexmlfile="xml.xml"/>
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
					<template subtype="source" match="XML1">
						<children>
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
			<globaltemplate subtype="element" match="abstract" schema-tree-path="abstract">
				<children>
					<template subtype="element" match="abstract">
						<children>
							<paragraph paragraphtag="h2">
								<children>
									<text fixtext="Abstract"/>
								</children>
							</paragraph>
							<content/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="body" schema-tree-path="body">
				<children>
					<template subtype="element" match="body">
						<children>
							<newline/>
							<paragraph paragraphtag="h2">
								<children>
									<text fixtext="Table of Contents"/>
								</children>
							</paragraph>
							<paragraph paragraphtag="h3">
								<children>
									<text fixtext="Appendi"/>
									<condition>
										<children>
											<conditionbranch xpath="count( ../back/div1 | ../back/inform-div1 ) &gt; 1">
												<children>
													<text fixtext="ces"/>
												</children>
											</conditionbranch>
											<conditionbranch>
												<children>
													<text fixtext="x"/>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
							</paragraph>
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
			<globaltemplate subtype="element" match="h1" schema-tree-path="h1">
				<children>
					<template subtype="element" match="h1">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="h2" schema-tree-path="h2">
				<children>
					<template subtype="element" match="h2">
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
			<globaltemplate subtype="element" match="h3" schema-tree-path="h3">
				<children>
					<template subtype="element" match="h3">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="h4" schema-tree-path="h4">
				<children>
					<template subtype="element" match="h4">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="h5" schema-tree-path="h5">
				<children>
					<template subtype="element" match="h5">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="h6" schema-tree-path="h6">
				<children>
					<template subtype="element" match="h6">
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
			</globaltemplate>
			<globaltemplate subtype="element" match="p" schema-tree-path="p">
				<children>
					<template subtype="element" match="p">
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
			<globaltemplate subtype="element" match="pre" schema-tree-path="pre">
				<children>
					<template subtype="element" match="pre">
						<children>
							<paragraph paragraphtag="pre">
								<children>
									<content/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="code" schema-tree-path="code">
				<children>
					<template subtype="element" match="code">
						<children>
							<content>
								<styles font-family="Courier New"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="eg" schema-tree-path="eg">
				<children>
					<template subtype="element" match="eg">
						<children>
							<paragraph paragraphtag="p">
								<children>
									<tgrid>
										<properties bgcolor="#99ffff" border="1" width="90%"/>
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
																	<paragraph paragraphtag="pre">
																		<children>
																			<content/>
																		</children>
																	</paragraph>
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
			<globaltemplate subtype="element" match="note" schema-tree-path="note">
				<children>
					<template subtype="element" match="note">
						<children>
							<text fixtext="NOTE:">
								<styles font-family="Arial" font-weight="bold"/>
							</text>
							<newline/>
							<paragraph>
								<styles margin-left="1cm"/>
								<children>
									<content/>
								</children>
							</paragraph>
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
			<globaltemplate subtype="element" match="att" schema-tree-path="att">
				<children>
					<template subtype="element" match="att">
						<children>
							<content>
								<styles font-family="Courier New"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="header" schema-tree-path="header">
				<children>
					<template subtype="element" match="header">
						<children>
							<link>
								<children>
									<image>
										<properties border="0" height="48" width="72"/>
										<styles font-family="Arial"/>
										<target>
											<fixtext value="http://www.w3.org/Icons/w3c_home.png"/>
										</target>
									</image>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="http://www.w3.org"/>
								</hyperlink>
							</link>
							<newline/>
							<newline/>
							<newline/>
							<newline/>
							<template subtype="element" match="title">
								<children>
									<content>
										<styles color="#005A9C" font-family="Arial" font-size="x-large"/>
									</content>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="subtitle">
								<children>
									<content>
										<styles color="#005A9C" font-family="Arial" font-size="x-large"/>
									</content>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="version">
								<children>
									<content>
										<styles color="#005A9C" font-family="Arial" font-size="x-large"/>
									</content>
								</children>
								<variables/>
							</template>
							<newline/>
							<newline/>
							<template subtype="element" match="w3c-doctype">
								<children>
									<content>
										<styles color="#005A9C" font-family="Arial" font-size="large"/>
									</content>
								</children>
								<variables/>
							</template>
							<template subtype="element" match="pubdate">
								<children>
									<template subtype="element" match="day">
										<children>
											<text fixtext=" "/>
											<content>
												<styles color="#005A9C" font-family="Arial" font-size="large"/>
											</content>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="month">
										<children>
											<text fixtext=" "/>
											<content>
												<styles color="#005A9C" font-family="Arial" font-size="large"/>
											</content>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="year">
										<children>
											<text fixtext=" "/>
											<content>
												<styles color="#005A9C" font-family="Arial" font-size="large"/>
											</content>
										</children>
										<variables/>
									</template>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="publoc">
								<children>
									<text fixtext="This version">
										<styles font-family="Arial" font-weight="bold"/>
									</text>
									<text fixtext=":">
										<styles font-family="Arial"/>
									</text>
									<newline/>
									<paragraph>
										<styles margin-left="1cm"/>
										<children>
											<content>
												<styles font-family="Arial"/>
											</content>
										</children>
									</paragraph>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="latestloc">
								<children>
									<text fixtext="Latest version:">
										<styles font-family="Arial" font-weight="bold"/>
									</text>
									<newline/>
									<paragraph>
										<styles margin-left="1cm"/>
										<children>
											<content>
												<styles font-family="Arial"/>
											</content>
										</children>
									</paragraph>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="prevlocs">
								<children>
									<text fixtext="Previous versions:">
										<styles font-family="Arial" font-weight="bold"/>
									</text>
									<newline/>
									<paragraph>
										<styles margin-left="1cm"/>
										<children>
											<content>
												<styles font-family="Arial"/>
											</content>
										</children>
									</paragraph>
								</children>
								<variables/>
							</template>
							<newline/>
							<calltemplate subtype="element" match="authlist"/>
							<template subtype="element" match="altlocs">
								<children>
									<text fixtext="This document is also available in these non-normative formats: "/>
									<paragraph>
										<styles margin-left="1cm"/>
										<children>
											<content/>
										</children>
									</paragraph>
								</children>
								<variables/>
							</template>
							<newline/>
							<link>
								<children>
									<text fixtext="Copyright"/>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="http://www.w3.org/Consortium/Legal/ipr-notice-20000612#Copyright"/>
								</hyperlink>
							</link>
							<text fixtext=" @2002 "/>
							<link>
								<children>
									<text fixtext="W3C"/>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="http://www.w3.org"/>
								</hyperlink>
							</link>
							<text fixtext="® ("/>
							<link>
								<children>
									<text fixtext="MIT"/>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="http://www.lcs.mit.edu"/>
								</hyperlink>
							</link>
							<text fixtext=", "/>
							<link>
								<children>
									<text fixtext="INRIA"/>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="http://www.inria.fr"/>
								</hyperlink>
							</link>
							<text fixtext=", "/>
							<link>
								<children>
									<text fixtext="Keio"/>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="http://www.keio.ac.jp/"/>
								</hyperlink>
							</link>
							<text fixtext="), All Rights Reserved.  W3C "/>
							<link>
								<children>
									<text fixtext="liability"/>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="http://www.w3.org/Consortium/Legal/ipr-notice-20000612#Legal_Disclaimer"/>
								</hyperlink>
							</link>
							<text fixtext=", "/>
							<link>
								<children>
									<text fixtext="trademark"/>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="http://www.w3.org/Consortium/Legal/ipr-notice-20000612#W3C_Trademarks"/>
								</hyperlink>
							</link>
							<text fixtext=", "/>
							<link>
								<children>
									<text fixtext="document use"/>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="http://www.w3.org/Consortium/Legal/copyright-documents-19990405"/>
								</hyperlink>
							</link>
							<text fixtext=" and "/>
							<link>
								<children>
									<text fixtext="software licensing"/>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="http://www.w3.org/Consortium/Legal/copyright-software-19980720"/>
								</hyperlink>
							</link>
							<text fixtext=" rules apply."/>
							<newline/>
							<newline/>
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
												<children>
													<tgridcell>
														<styles border-bottom-color="black" border-bottom-style="solid" border-bottom-width="thin"/>
														<children>
															<text fixtext=" ">
																<styles font-family="Arial"/>
															</text>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
										</children>
									</tgridbody-rows>
								</children>
							</tgrid>
							<newline/>
							<template subtype="element" match="notice">
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
							<template subtype="element" match="abstract">
								<children>
									<text fixtext="Abstract">
										<styles color="#005A9C" font-family="Arial" font-size="large"/>
									</text>
									<paragraph paragraphtag="p">
										<children>
											<content>
												<styles font-family="Arial"/>
											</content>
										</children>
									</paragraph>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="status">
								<children>
									<text fixtext="Status of this Document">
										<styles color="#005A9C" font-family="Arial" font-size="large"/>
									</text>
									<paragraph paragraphtag="p">
										<children>
											<content>
												<styles font-family="Arial"/>
											</content>
										</children>
									</paragraph>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="copyright">
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
												<children>
													<tgridcell>
														<styles border-bottom-color="black" border-bottom-style="solid" border-bottom-width="thin"/>
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
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="affiliation" schema-tree-path="affiliation">
				<children>
					<template subtype="element" match="affiliation">
						<children>
							<text fixtext=", "/>
							<content/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="arg" schema-tree-path="arg">
				<children>
					<template subtype="element" match="arg">
						<children>
							<condition>
								<children>
									<conditionbranch xpath="preceding-sibling::arg">
										<children>
											<text fixtext=", "/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<template subtype="attribute" match="type">
								<children>
									<content>
										<styles font-style="italic"/>
										<format basic-type="xsd" datatype="Enumeration"/>
									</content>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="attval" schema-tree-path="attval">
				<children>
					<template subtype="element" match="attval">
						<children>
							<text fixtext="&apos;">
								<styles font-family="Courier"/>
							</text>
							<content>
								<styles font-family="Courier"/>
							</content>
							<text fixtext="&apos;">
								<styles font-family="Courier"/>
							</text>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="authlist" schema-tree-path="authlist">
				<children>
					<template subtype="element" match="authlist">
						<children>
							<text fixtext="Editor"/>
							<condition>
								<children>
									<conditionbranch xpath="count( author )&gt;1">
										<children>
											<text fixtext="s"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<text fixtext=":"/>
							<newline/>
							<paragraph>
								<styles margin-left="1cm"/>
								<children>
									<content/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="author" schema-tree-path="author">
				<children>
					<template subtype="element" match="author">
						<children>
							<content/>
							<condition>
								<children>
									<conditionbranch xpath="@role = &apos;2e&apos;">
										<children>
											<text fixtext=" - Second Edition"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<newline/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="bibl" schema-tree-path="bibl">
				<children>
					<template subtype="element" match="bibl">
						<children>
							<condition>
								<children>
									<conditionbranch xpath="@key">
										<children>
											<template subtype="attribute" match="key">
												<children>
													<content>
														<format basic-type="xsd" datatype="CDATA"/>
													</content>
												</children>
												<variables/>
											</template>
										</children>
									</conditionbranch>
									<conditionbranch>
										<children>
											<template subtype="attribute" match="id">
												<children>
													<content>
														<format basic-type="xsd" datatype="ID"/>
													</content>
												</children>
												<variables/>
											</template>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<paragraph>
								<styles margin-left="1cm"/>
								<children>
									<condition>
										<children>
											<conditionbranch xpath="@href">
												<children>
													<link>
														<children>
															<content/>
														</children>
														<action>
															<none/>
														</action>
														<hyperlink>
															<xpath value="@href"/>
														</hyperlink>
													</link>
													<text fixtext="  (See "/>
													<template subtype="attribute" match="href">
														<children>
															<content>
																<format basic-type="xsd" datatype="CDATA"/>
															</content>
														</children>
														<variables/>
													</template>
													<text fixtext=".)"/>
												</children>
											</conditionbranch>
											<conditionbranch>
												<children>
													<content/>
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
			<globaltemplate subtype="element" match="bibref" schema-tree-path="bibref">
				<children>
					<template subtype="element" match="bibref">
						<children>
							<text fixtext="["/>
							<text fixtext="ref:">
								<styles color="fuchsia" font-family="Verdana" font-size="x-small" font-weight="bold"/>
							</text>
							<template subtype="attribute" match="ref">
								<children>
									<content>
										<format basic-type="xsd" datatype="IDREF"/>
									</content>
								</children>
								<variables/>
							</template>
							<text fixtext="]"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="bnf" schema-tree-path="bnf">
				<children>
					<template subtype="element" match="bnf">
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
			<globaltemplate subtype="element" match="com" schema-tree-path="com">
				<children>
					<template subtype="element" match="com">
						<children>
							<condition>
								<children>
									<conditionbranch xpath="name(../.) = &apos;rhs&apos;">
										<children>
											<text fixtext="/*">
												<styles font-style="italic"/>
											</text>
											<content>
												<styles font-style="italic"/>
											</content>
											<text fixtext="*/">
												<styles font-style="italic"/>
											</text>
										</children>
									</conditionbranch>
									<conditionbranch>
										<children>
											<content/>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="prod" schema-tree-path="prod">
				<children>
					<template subtype="element" match="prod">
						<children>
							<tgrid>
								<properties width="90%"/>
								<children>
									<tgridbody-cols>
										<children>
											<tgridcol>
												<properties width="200"/>
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
															<tgrid>
																<properties width="175"/>
																<children>
																	<tgridbody-cols>
																		<children>
																			<tgridcol/>
																			<tgridcol>
																				<properties width="50"/>
																			</tgridcol>
																		</children>
																	</tgridbody-cols>
																	<tgridbody-rows>
																		<children>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="lhs">
																								<children>
																									<content>
																										<styles font-family="Courier"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<text fixtext="::=">
																								<styles font-family="Courier"/>
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
													<tgridcell>
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
																							<content restofcontents="1">
																								<styles font-family="Courier"/>
																							</content>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="com">
																								<children>
																									<content>
																										<styles font-family="Courier" font-style="italic"/>
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
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="constraintnote" schema-tree-path="constraintnote">
				<children>
					<template subtype="element" match="constraintnote">
						<children>
							<newline/>
							<text fixtext="Constraint:  ">
								<styles font-family="Arial" font-weight="bold" padding-left="1cm"/>
							</text>
							<template subtype="element" match="head">
								<children>
									<content>
										<styles font-family="Arial" font-weight="bold"/>
									</content>
								</children>
								<variables/>
							</template>
							<newline/>
							<paragraph>
								<styles margin-left="1cm"/>
								<children>
									<content restofcontents="1"/>
								</children>
							</paragraph>
							<newline/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="div1" schema-tree-path="div1">
				<children>
					<template subtype="element" match="div1">
						<children>
							<template subtype="element" match="head">
								<children>
									<newline/>
									<content>
										<styles background-color="white" color="#005A9C" font-family="Arial" font-size="large"/>
									</content>
									<newline/>
								</children>
								<variables/>
							</template>
							<newline/>
							<newline/>
							<content restofcontents="1">
								<styles font-family="Arial"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="div2" schema-tree-path="div2">
				<children>
					<template subtype="element" match="div2">
						<children>
							<template subtype="element" match="head">
								<children>
									<newline/>
									<content>
										<styles color="#005A9C" font-family="Arial" font-size="medium"/>
									</content>
									<newline/>
								</children>
								<variables/>
							</template>
							<newline/>
							<newline/>
							<content restofcontents="1">
								<styles font-family="Arial"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="div3" schema-tree-path="div3">
				<children>
					<template subtype="element" match="div3">
						<children>
							<template subtype="element" match="head">
								<children>
									<newline/>
									<content>
										<styles font-family="Arial" font-weight="bold"/>
									</content>
									<newline/>
								</children>
								<variables/>
							</template>
							<newline/>
							<content restofcontents="1">
								<styles font-family="Arial"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="div4" schema-tree-path="div4">
				<children>
					<template subtype="element" match="div4">
						<children>
							<template subtype="element" match="head">
								<children>
									<newline/>
									<content>
										<styles font-family="Arial" font-style="italic"/>
									</content>
									<newline/>
								</children>
								<variables/>
							</template>
							<newline/>
							<content restofcontents="1">
								<styles font-family="Arial"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="div5" schema-tree-path="div5">
				<children>
					<template subtype="element" match="div5">
						<children>
							<template subtype="element" match="head">
								<children>
									<newline/>
									<content>
										<styles font-family="Arial" text-transform="uppercase"/>
									</content>
									<newline/>
								</children>
								<variables/>
							</template>
							<newline/>
							<content restofcontents="1">
								<styles font-family="Arial"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="el" schema-tree-path="el">
				<children>
					<template subtype="element" match="el">
						<children>
							<content>
								<styles font-family="Courier"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="em" schema-tree-path="em">
				<children>
					<template subtype="element" match="em">
						<children>
							<content>
								<styles font-style="italic"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="emph" schema-tree-path="emph">
				<children>
					<template subtype="element" match="emph">
						<children>
							<content>
								<styles font-style="italic"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="example" schema-tree-path="example">
				<children>
					<template subtype="element" match="example">
						<children>
							<text fixtext="Example:  ">
								<styles font-style="italic"/>
							</text>
							<template subtype="element" match="head">
								<children>
									<content>
										<styles font-style="italic"/>
									</content>
								</children>
								<variables/>
							</template>
							<paragraph paragraphtag="p">
								<children>
									<content restofcontents="1"/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="footnote" schema-tree-path="footnote">
				<children>
					<template subtype="element" match="footnote">
						<children>
							<tgrid>
								<properties bgcolor="silver"/>
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
			<globaltemplate subtype="element" match="function" schema-tree-path="function">
				<children>
					<template subtype="element" match="function">
						<children>
							<content>
								<styles font-family="Courier"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="glist" schema-tree-path="glist">
				<children>
					<template subtype="element" match="glist">
						<children>
							<template subtype="element" match="gitem">
								<children>
									<tgrid>
										<children>
											<tgridbody-cols>
												<children>
													<tgridcol>
														<properties width="100"/>
													</tgridcol>
													<tgridcol/>
												</children>
											</tgridbody-cols>
											<tgridbody-rows>
												<children>
													<tgridrow>
														<styles height="30px"/>
														<children>
															<tgridcell>
																<properties valign="bottom"/>
																<children>
																	<template subtype="element" match="label">
																		<children>
																			<content>
																				<styles font-family="Arial" font-weight="bold"/>
																			</content>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell joinleft="1">
																<properties valign="bottom"/>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<styles height="36px"/>
														<children>
															<tgridcell/>
															<tgridcell>
																<properties valign="top"/>
																<children>
																	<template subtype="element" match="def">
																		<children>
																			<content>
																				<styles font-family="Arial"/>
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
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="graphic" schema-tree-path="graphic">
				<children>
					<template subtype="element" match="graphic">
						<children>
							<image>
								<properties border="0"/>
								<target>
									<xpath value="@source"/>
								</target>
							</image>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="head" schema-tree-path="head">
				<children>
					<template subtype="element" match="head">
						<children>
							<content>
								<styles color="#005A9C" font-family="Arial" font-size="large"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="kw" schema-tree-path="kw">
				<children>
					<template subtype="element" match="kw">
						<children>
							<content>
								<styles font-family="Arial Unicode MS" font-weight="bold"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="loc" schema-tree-path="loc">
				<children>
					<template subtype="element" match="loc">
						<children>
							<link>
								<children>
									<content/>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<xpath value="@href"/>
								</hyperlink>
							</link>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="member" schema-tree-path="member">
				<children>
					<template subtype="element" match="member">
						<children>
							<list>
								<properties start="0"/>
								<children>
									<listrow>
										<children>
											<template subtype="element" match="name">
												<children>
													<content>
														<styles font-family="Arial"/>
													</content>
												</children>
												<variables/>
											</template>
											<text fixtext=" ">
												<styles font-family="Arial"/>
											</text>
											<template subtype="element" match="affiliation">
												<children>
													<content>
														<styles font-family="Arial"/>
													</content>
												</children>
												<variables/>
											</template>
											<text fixtext=" ">
												<styles font-family="Arial"/>
											</text>
											<template subtype="element" match="role">
												<children>
													<text fixtext="(">
														<styles font-family="Arial" font-style="italic"/>
													</text>
													<content>
														<styles font-family="Arial" font-style="italic"/>
													</content>
													<text fixtext=")">
														<styles font-family="Arial" font-style="italic"/>
													</text>
												</children>
												<variables/>
											</template>
										</children>
									</listrow>
								</children>
							</list>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="nt" schema-tree-path="nt">
				<children>
					<template subtype="element" match="nt">
						<children>
							<link>
								<children>
									<content>
										<styles font-family="Arial Unicode MS"/>
									</content>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="#"/>
									<xpath value="@def"/>
								</hyperlink>
							</link>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="olist" schema-tree-path="olist">
				<children>
					<template subtype="element" match="olist">
						<children>
							<list ordered="1">
								<properties start="1"/>
								<children>
									<listrow>
										<children>
											<template subtype="element" match="item">
												<children>
													<content/>
												</children>
												<variables/>
											</template>
										</children>
									</listrow>
								</children>
							</list>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="orglist" schema-tree-path="orglist">
				<children>
					<template subtype="element" match="orglist">
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
			<globaltemplate subtype="element" match="prodgroup" schema-tree-path="prodgroup">
				<children>
					<template subtype="element" match="prodgroup">
						<children>
							<template subtype="element" match="prod">
								<children>
									<tgrid>
										<properties width="90%"/>
										<children>
											<tgridbody-cols>
												<children>
													<tgridcol>
														<properties width="200"/>
													</tgridcol>
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
																	<tgrid>
																		<properties width="175"/>
																		<children>
																			<tgridbody-cols>
																				<children>
																					<tgridcol/>
																					<tgridcol>
																						<properties width="53"/>
																					</tgridcol>
																				</children>
																			</tgridbody-cols>
																			<tgridbody-rows>
																				<children>
																					<tgridrow>
																						<children>
																							<tgridcell>
																								<children>
																									<template subtype="element" match="lhs">
																										<children>
																											<content/>
																										</children>
																										<variables/>
																									</template>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<text fixtext="::="/>
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
																<properties align="left" valign="top"/>
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
																									<content restofcontents="1"/>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<template subtype="element" match="com">
																										<children>
																											<content>
																												<styles font-style="italic"/>
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
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="quote" schema-tree-path="quote">
				<children>
					<template subtype="element" match="quote">
						<children>
							<text fixtext="&quot;"/>
							<content/>
							<text fixtext="&quot;"/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="revisiondesc" schema-tree-path="revisiondesc">
				<children>
					<template subtype="element" match="revisiondesc">
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="rfc2119" schema-tree-path="rfc2119">
				<children>
					<template subtype="element" match="rfc2119">
						<children>
							<content>
								<styles font-weight="bolder"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="sitem" schema-tree-path="sitem">
				<children>
					<template subtype="element" match="sitem">
						<children>
							<list>
								<properties start="0"/>
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
			<globaltemplate subtype="element" match="specref" schema-tree-path="specref">
				<children>
					<template subtype="element" match="specref">
						<children>
							<template subtype="attribute" match="ref">
								<children>
									<link>
										<children>
											<content>
												<styles font-family="Arial" font-weight="bold"/>
												<format basic-type="xsd" datatype="IDREF"/>
											</content>
										</children>
										<action>
											<none/>
										</action>
										<hyperlink>
											<fixtext value="#"/>
											<xpath value="."/>
										</hyperlink>
									</link>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="sub" schema-tree-path="sub">
				<children>
					<template subtype="element" match="sub">
						<children>
							<content>
								<styles vertical-align="sub"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="sup" schema-tree-path="sup">
				<children>
					<template subtype="element" match="sup">
						<children>
							<content>
								<styles vertical-align="super"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="term" schema-tree-path="term">
				<children>
					<template subtype="element" match="term">
						<children>
							<content>
								<styles font-style="italic"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="termdef" schema-tree-path="termdef">
				<children>
					<template subtype="element" match="termdef">
						<children>
							<text fixtext="[Definition: ">
								<styles font-family="Arial"/>
							</text>
							<content>
								<styles font-family="Arial"/>
							</content>
							<text fixtext="]">
								<styles font-family="Arial"/>
							</text>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="termref" schema-tree-path="termref">
				<children>
					<template subtype="element" match="termref">
						<children>
							<link>
								<children>
									<content/>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="#"/>
									<xpath value="@def"/>
								</hyperlink>
							</link>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="titleref" schema-tree-path="titleref">
				<children>
					<template subtype="element" match="titleref">
						<children>
							<link>
								<children>
									<content>
										<styles font-style="italic"/>
									</content>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<xpath value="@href"/>
								</hyperlink>
							</link>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="ulist" schema-tree-path="ulist">
				<children>
					<template subtype="element" match="ulist">
						<children>
							<list>
								<properties start="0" type="disc"/>
								<children>
									<listrow>
										<children>
											<template subtype="element" match="item">
												<children>
													<content/>
												</children>
												<variables/>
											</template>
										</children>
									</listrow>
								</children>
							</list>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="var" schema-tree-path="var">
				<children>
					<template subtype="element" match="var">
						<children>
							<content>
								<styles font-style="italic"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="vcnote" schema-tree-path="vcnote">
				<children>
					<template subtype="element" match="vcnote">
						<children>
							<newline/>
							<text fixtext="Validity Constraint: ">
								<styles font-family="Arial" font-weight="bold" padding-left="1cm"/>
							</text>
							<template subtype="element" match="head">
								<children>
									<content>
										<styles font-family="Arial" font-weight="bold"/>
									</content>
								</children>
								<variables/>
							</template>
							<newline/>
							<paragraph>
								<styles margin-left="1cm"/>
								<children>
									<content restofcontents="1"/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="wfcnote" schema-tree-path="wfcnote">
				<children>
					<template subtype="element" match="wfcnote">
						<children>
							<newline/>
							<text fixtext="Well-Formedness Constraint: ">
								<styles font-family="Arial" font-weight="bold" margin-left="1cm"/>
							</text>
							<template subtype="element" match="head">
								<children>
									<content>
										<styles font-family="Arial" font-weight="bold"/>
									</content>
								</children>
								<variables/>
							</template>
							<newline/>
							<paragraph>
								<styles margin-left="1cm"/>
								<children>
									<content restofcontents="1"/>
								</children>
							</paragraph>
							<newline/>
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
