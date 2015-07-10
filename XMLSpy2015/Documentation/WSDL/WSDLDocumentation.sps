<?xml version="1.0" encoding="UTF-8"?>
<structure version="16" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*XML" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="n1" uri="http://www.altova.com/documentation"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="WSDLDocumentation.xsd" workingxmlfile="SampleData\TimeService.xml"/>
		</schemasources>
	</schemasources>
	<modules>
		<module spsfile="..\Schema\OverallDocumentation.sps"/>
	</modules>
	<flags>
		<scripts/>
		<mainparts>
			<mainpart match="/" spsfile="..\Schema\OverallDocumentation.sps" isactive="0"/>
		</mainparts>
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
		<rules selector=".wsdlSubTitle">
			<media>
				<media value="all"/>
			</media>
			<rule color="black" font-family="Tahoma" font-size="8pt" font-style="italic"/>
		</rules>
		<rules selector=".wsdlName">
			<media>
				<media value="all"/>
			</media>
			<rule color="#000000" font-family="Tahoma" font-size="10pt"/>
		</rules>
		<rules selector=".wsdlSubData">
			<media>
				<media value="all"/>
			</media>
			<rule color="#000000" font-family="Tahoma" font-size="8pt"/>
		</rules>
		<rules selector=".wsdlDocumentation">
			<media>
				<media value="all"/>
			</media>
			<rule color="#000000" font-family="Tahoma" font-size="8pt" font-style="italic"/>
		</rules>
		<rules selector=".td-space">
			<media>
				<media value="all"/>
			</media>
			<rule border-bottom-style="none" border-bottom-width="0px" border-left-style="none" border-left-width="0px" border-right-color="white" border-right-style="solid" border-right-width="2px" border-top-color="white" border-top-style="solid" border-top-width="2px"/>
		</rules>
	</globalstyles>
	<mainparts>
		<children>
			<globaltemplate subtype="main" match="/">
				<document-properties _xtitle="$XML/n1:WSDLDocumentation/n1:Document/@title"/>
				<children>
					<documentsection>
						<properties columncount="1" columngap="0.50in" headerfooterheight="fixed" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.30in" papermarginheader="0.30in" papermarginleft="0.60in" papermarginright="0.60in" papermargintop="0.79in" paperwidth="8.50in"/>
						<children>
							<globaltemplate subtype="pagelayout" match="footerall">
								<children>
									<calltemplate subtype="named" match="WSDLFooter">
										<parameters/>
									</calltemplate>
								</children>
							</globaltemplate>
							<globaltemplate subtype="pdf-bookmarktree" match="pdf-bookmarktree">
								<children>
									<template subtype="source" match="XML">
										<children>
											<template subtype="element" match="n1:WSDLDocumentation">
												<children>
													<pdf-bookmark>
														<children>
															<link>
																<children>
																	<text fixtext="Services"/>
																</children>
																<action>
																	<none/>
																</action>
																<hyperlink>
																	<fixtext value="#"/>
																	<fixtext value="toc"/>
																</hyperlink>
															</link>
															<template subtype="element" filter="@id" match="n1:Service">
																<children>
																	<calltemplate subtype="named" match="WSDLTreeItem">
																		<parameters/>
																	</calltemplate>
																</children>
																<variables/>
															</template>
														</children>
													</pdf-bookmark>
													<pdf-bookmark>
														<children>
															<link>
																<children>
																	<text fixtext="Bindings"/>
																</children>
																<action>
																	<none/>
																</action>
																<hyperlink>
																	<fixtext value="#"/>
																	<fixtext value="toc"/>
																</hyperlink>
															</link>
															<template subtype="element" filter="@id" match="n1:Binding">
																<children>
																	<calltemplate subtype="named" match="WSDLTreeItem">
																		<parameters/>
																	</calltemplate>
																</children>
																<variables/>
															</template>
														</children>
													</pdf-bookmark>
													<pdf-bookmark>
														<children>
															<link>
																<children>
																	<text fixtext="PortTypes"/>
																</children>
																<action>
																	<none/>
																</action>
																<hyperlink>
																	<fixtext value="#"/>
																	<fixtext value="toc"/>
																</hyperlink>
															</link>
															<template subtype="element" filter="@id" match="n1:PortType">
																<children>
																	<calltemplate subtype="named" match="WSDLTreeItem">
																		<parameters/>
																	</calltemplate>
																</children>
																<variables/>
															</template>
														</children>
													</pdf-bookmark>
													<pdf-bookmark>
														<children>
															<link>
																<children>
																	<text fixtext="Messages"/>
																</children>
																<action>
																	<none/>
																</action>
																<hyperlink>
																	<fixtext value="#"/>
																	<fixtext value="toc"/>
																</hyperlink>
															</link>
															<template subtype="element" filter="@id" match="n1:Message">
																<children>
																	<calltemplate subtype="named" match="WSDLTreeItem">
																		<parameters/>
																	</calltemplate>
																</children>
																<variables/>
															</template>
														</children>
													</pdf-bookmark>
													<pdf-bookmark>
														<children>
															<link>
																<children>
																	<text fixtext="Types"/>
																</children>
																<action>
																	<none/>
																</action>
																<hyperlink>
																	<fixtext value="#"/>
																	<fixtext value="toc"/>
																</hyperlink>
															</link>
															<template subtype="userdefined" match="(n1:Element|n1:ComplexType|n1:SimpleType)[@id]">
																<children>
																	<calltemplate subtype="named" match="WSDLTreeItem">
																		<parameters/>
																	</calltemplate>
																</children>
																<variables/>
															</template>
														</children>
													</pdf-bookmark>
												</children>
												<variables/>
											</template>
										</children>
										<variables/>
									</template>
								</children>
							</globaltemplate>
						</children>
						<watermark>
							<image transparency="50" fill-page="1" center-if-not-fill="1"/>
							<text transparency="50"/>
						</watermark>
					</documentsection>
					<template subtype="source" match="XML">
						<children>
							<template subtype="element" match="n1:WSDLDocumentation">
								<children>
									<template subtype="element" match="n1:Document">
										<children>
											<template subtype="attribute" match="title">
												<children>
													<paragraph>
														<children>
															<bookmark>
																<children>
																	<text fixtext="WSDL">
																		<properties class="elementHeader"/>
																	</text>
																	<text fixtext=" "/>
																	<content subtype="regular">
																		<properties class="elementHeader2"/>
																	</content>
																</children>
																<action>
																	<none/>
																</action>
																<bookmark>
																	<fixtext value="toc"/>
																</bookmark>
															</bookmark>
														</children>
													</paragraph>
												</children>
												<variables/>
											</template>
										</children>
										<variables/>
									</template>
									<newline/>
									<template subtype="element" match="n1:WSDLDocument">
										<children>
											<tgrid>
												<styles width="18cm"/>
												<children>
													<tgridbody-cols>
														<children>
															<tgridcol>
																<styles width="3cm"/>
															</tgridcol>
															<tgridcol>
																<styles width="15cm"/>
															</tgridcol>
														</children>
													</tgridbody-cols>
													<tgridbody-rows>
														<children>
															<tgridrow>
																<children>
																	<tgridcell>
																		<styles width="3cm"/>
																		<children>
																			<text fixtext="WSDL location:">
																				<properties class="wsdlSubTitle"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<styles width="15cm"/>
																		<children>
																			<link>
																				<properties class="wsdlName"/>
																				<children>
																					<template subtype="attribute" match="wsdlLocation">
																						<children>
																							<content subtype="regular">
																								<properties class="wsdlName"/>
																							</content>
																						</children>
																						<variables/>
																					</template>
																				</children>
																				<action>
																					<none/>
																				</action>
																				<hyperlink>
																					<xpath value="@href"/>
																				</hyperlink>
																			</link>
																		</children>
																	</tgridcell>
																</children>
															</tgridrow>
															<tgridrow>
																<children>
																	<tgridcell>
																		<styles width="3cm"/>
																		<children>
																			<text fixtext="targetnamespace:">
																				<properties class="wsdlSubTitle"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<styles width="15cm"/>
																		<children>
																			<template subtype="attribute" match="targetNamespace">
																				<children>
																					<content subtype="regular">
																						<properties class="wsdlName"/>
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
									<newline/>
									<tgrid hidecols="when-body-empty">
										<properties cellpadding="2" cellspacing="0" class="table-no-border"/>
										<children>
											<tgridbody-cols>
												<children>
													<tgridcol>
														<properties valign="top"/>
														<styles background-color="#E6E8F2"/>
													</tgridcol>
													<tgridcol>
														<properties valign="top"/>
														<styles background-color="#C9CDE0"/>
													</tgridcol>
													<tgridcol>
														<properties valign="top"/>
														<styles background-color="#BAC0E0"/>
													</tgridcol>
													<tgridcol>
														<properties valign="top"/>
														<styles background-color="#FFD9CC"/>
													</tgridcol>
													<tgridcol>
														<properties valign="top"/>
														<styles background-color="#F0F0F0"/>
													</tgridcol>
												</children>
											</tgridbody-cols>
											<tgridbody-rows>
												<children>
													<tgridrow>
														<children>
															<tgridcell>
																<children>
																	<text fixtext="services">
																		<properties class="wsdlSubTitle"/>
																	</text>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<text fixtext="bindings">
																		<properties class="wsdlSubTitle"/>
																	</text>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<text fixtext="porttypes">
																		<properties class="wsdlSubTitle"/>
																	</text>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<text fixtext="messages">
																		<properties class="wsdlSubTitle"/>
																	</text>
																</children>
															</tgridcell>
															<tgridcell>
																<children>
																	<text fixtext="types">
																		<properties class="wsdlSubTitle"/>
																	</text>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<properties valign="top"/>
																<children>
																	<template subtype="element" match="n1:Service">
																		<children>
																			<calltemplate subtype="named" match="WSDLBookmarkItem">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell>
																<properties valign="top"/>
																<children>
																	<template subtype="element" match="n1:Binding">
																		<children>
																			<calltemplate subtype="named" match="WSDLBookmarkItem">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell>
																<properties valign="top"/>
																<children>
																	<template subtype="element" match="n1:PortType">
																		<children>
																			<calltemplate subtype="named" match="WSDLBookmarkItem">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell>
																<properties valign="top"/>
																<children>
																	<template subtype="element" match="n1:Message">
																		<children>
																			<calltemplate subtype="named" match="WSDLBookmarkItem">
																				<parameters/>
																			</calltemplate>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell>
																<properties valign="top"/>
																<children>
																	<template subtype="element" match="n1:SchemaDocument">
																		<children>
																			<template subtype="userdefined" match="(n1:Element|n1:ComplexType|n1:SimpleType)[@wsdlType=true()]">
																				<children>
																					<calltemplate subtype="named" match="WSDLBookmarkItem">
																						<parameters/>
																					</calltemplate>
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
												</children>
											</tgridbody-rows>
										</children>
									</tgrid>
									<newline/>
									<calltemplate subtype="element" match="n1:SchemaDocument"/>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="n1:WSDLDocumentation">
								<children>
									<condition>
										<children>
											<conditionbranch xpath="n1:SchemaDocument[1]/@newFile">
												<children>
													<template subtype="userdefined" match="(n1:Service|n1:Binding|n1:PortType|n1:Message)[@id]">
														<children>
															<calltemplate subtype="userdefined" match="current()"/>
														</children>
														<variables/>
													</template>
													<resultdocument _xurl="n1:SchemaDocument[1]/@newFile">
														<children>
															<documentsection>
																<properties columncount="1" columngap="0.50in" headerfooterheight="fixed" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.30in" papermarginheader="0.30in" papermarginleft="0.60in" papermarginright="0.60in" papermargintop="0.79in" paperwidth="8.50in"/>
																<watermark>
																	<image transparency="50" fill-page="1" center-if-not-fill="1"/>
																	<text transparency="50"/>
																</watermark>
															</documentsection>
															<template subtype="element" match="n1:SchemaDocument">
																<children>
																	<template subtype="userdefined" match="element()[@id]">
																		<children>
																			<calltemplate subtype="userdefined" match="current()"/>
																		</children>
																		<variables/>
																	</template>
																</children>
																<variables/>
															</template>
															<paragraph>
																<children>
																	<link>
																		<properties class="schemaName"/>
																		<children>
																			<text fixtext="Back to TOC">
																				<properties class="schemaName"/>
																				<styles font-style="italic"/>
																			</text>
																		</children>
																		<action>
																			<none/>
																		</action>
																		<hyperlink>
																			<fixtext value="#toc"/>
																		</hyperlink>
																	</link>
																</children>
															</paragraph>
															<newline/>
															<condition>
																<children>
																	<conditionbranch xpath="$SV_OutputFormat = &apos;HTML&apos;">
																		<children>
																			<calltemplate subtype="named" match="WSDLFooter">
																				<parameters/>
																			</calltemplate>
																		</children>
																	</conditionbranch>
																</children>
															</condition>
															<newline/>
														</children>
														<document-properties _xtitle="concat($XML/n1:WSDLDocumentation/n1:Document/@title,&apos; - &apos;,@name)"/>
													</resultdocument>
												</children>
											</conditionbranch>
											<conditionbranch>
												<children>
													<template subtype="userdefined" match="(n1:Service|n1:Binding|n1:PortType|n1:Message|n1:SchemaDocument/element())[@id]">
														<children>
															<condition>
																<children>
																	<conditionbranch xpath="@newFile or ./parent::n1:SchemaDocument/@newFile">
																		<children>
																			<resultdocument _xurl="@newFile">
																				<children>
																					<documentsection>
																						<properties columncount="1" columngap="0.50in" headerfooterheight="fixed" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.30in" papermarginheader="0.30in" papermarginleft="0.60in" papermarginright="0.60in" papermargintop="0.79in" paperwidth="8.50in"/>
																						<watermark>
																							<image transparency="50" fill-page="1" center-if-not-fill="1"/>
																							<text transparency="50"/>
																						</watermark>
																					</documentsection>
																					<calltemplate subtype="userdefined" match="current()"/>
																					<paragraph>
																						<children>
																							<link>
																								<properties class="schemaName"/>
																								<children>
																									<text fixtext="Back to TOC">
																										<properties class="schemaName"/>
																										<styles font-style="italic"/>
																									</text>
																								</children>
																								<action>
																									<none/>
																								</action>
																								<hyperlink>
																									<fixtext value="#toc"/>
																								</hyperlink>
																							</link>
																						</children>
																					</paragraph>
																					<newline/>
																					<condition>
																						<children>
																							<conditionbranch xpath="$SV_OutputFormat = &apos;HTML&apos;">
																								<children>
																									<calltemplate subtype="named" match="WSDLFooter">
																										<parameters/>
																									</calltemplate>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																					<newline/>
																				</children>
																				<document-properties _xtitle="concat($XML/n1:WSDLDocumentation/n1:Document/@title,&apos; - &apos;,@name)"/>
																			</resultdocument>
																		</children>
																	</conditionbranch>
																	<conditionbranch>
																		<children>
																			<calltemplate subtype="userdefined" match="current()"/>
																		</children>
																	</conditionbranch>
																</children>
															</condition>
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
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;HTML&apos;">
										<children>
											<calltemplate subtype="named" match="WSDLFooter">
												<parameters/>
											</calltemplate>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts>
		<children>
			<globaltemplate subtype="element" match="n1:Service" schema-tree-path="$XML/n1:WSDLDocumentation/n1:Service">
				<children>
					<template subtype="element" match="n1:Service">
						<children>
							<calltemplate subtype="named" match="WSDLItem">
								<parameters>
									<parameter name="type" value="&apos;service&apos;"/>
									<parameter name="backgroundColor" value="&apos;#E6E8F2&apos;"/>
								</parameters>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="n1:Binding" schema-tree-path="$XML/n1:WSDLDocumentation/n1:Binding">
				<children>
					<template subtype="element" match="n1:Binding">
						<children>
							<calltemplate subtype="named" match="WSDLItem">
								<parameters>
									<parameter name="type" value="&apos;binding&apos;"/>
									<parameter name="backgroundColor" value="&apos;#C9CDE0&apos;"/>
								</parameters>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="n1:PortType" schema-tree-path="$XML/n1:WSDLDocumentation/n1:PortType">
				<children>
					<template subtype="element" match="n1:PortType">
						<children>
							<calltemplate subtype="named" match="WSDLItem">
								<parameters>
									<parameter name="type" value="&apos;porttype&apos;"/>
									<parameter name="backgroundColor" value="&apos;#BAC0E0&apos;"/>
								</parameters>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="n1:Message" schema-tree-path="$XML/n1:WSDLDocumentation/n1:Message">
				<children>
					<template subtype="element" match="n1:Message">
						<children>
							<calltemplate subtype="named" match="WSDLItem">
								<parameters>
									<parameter name="type" value="&apos;message&apos;"/>
									<parameter name="backgroundColor" value="&apos;#FFD9CC&apos;"/>
								</parameters>
							</calltemplate>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</globalparts>
	<designfragments>
		<children>
			<globaltemplate subtype="named" match="WSDLBookmarkItem">
				<parameters/>
				<children>
					<paragraph>
						<properties class="wsdlName"/>
						<children>
							<link conditional-processing="@id">
								<properties class="wsdlName"/>
								<children>
									<template subtype="attribute" match="name">
										<children>
											<autocalc xpath="if ($SV_OutputFormat = &apos;PDF&apos;)
 then replace(., &apos;([A-Z])&apos;, concat(codepoints-to-string(8203), &apos;$1&apos;))
 else .">
												<properties class="wsdlName"/>
											</autocalc>
										</children>
										<variables/>
									</template>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="#"/>
									<xpath value="@id"/>
								</hyperlink>
							</link>
						</children>
					</paragraph>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="WSDLItem">
				<parameters>
					<parameter name="type" type="xs:string" default-value="&apos;&apos;"/>
					<parameter name="backgroundColor" type="xs:string" default-value="&apos;#F0F0F0&apos;"/>
				</parameters>
				<children>
					<paragraph>
						<styles keep-with-next="always"/>
						<children>
							<bookmark>
								<children>
									<template subtype="parameter" match="$type">
										<children>
											<content subtype="regular">
												<properties class="elementHeader"/>
											</content>
										</children>
										<variables/>
									</template>
									<text fixtext=" ">
										<properties class="elementHeader"/>
									</text>
									<template subtype="attribute" match="name">
										<children>
											<content subtype="regular">
												<properties class="elementHeader2"/>
											</content>
										</children>
										<variables/>
									</template>
								</children>
								<action>
									<none/>
								</action>
								<bookmark>
									<xpath value="@id"/>
								</bookmark>
							</bookmark>
						</children>
					</paragraph>
					<condition>
						<children>
							<conditionbranch xpath="n1:Documentations">
								<children>
									<calltemplate subtype="named" match="WSDLDocumentation">
										<parameters/>
									</calltemplate>
								</children>
							</conditionbranch>
						</children>
					</condition>
					<calltemplate subtype="named" match="WSDLPropertyTable">
						<parameters>
							<parameter name="backgroundColor" value="$backgroundColor"/>
						</parameters>
					</calltemplate>
					<newline/>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="WSDLPropertyTable">
				<parameters>
					<parameter name="backgroundColor" type="xs:string" default-value="&apos;#F0F0F0&apos;"/>
				</parameters>
				<children>
					<tgrid>
						<properties _xbgcolor="$backgroundColor" border="1" cellpadding="5" cellspacing="0" width="100%"/>
						<children>
							<tgridbody-cols>
								<children>
									<tgridcol>
										<properties valign="top"/>
										<styles width="10%"/>
									</tgridcol>
									<tgridcol>
										<styles width="90%"/>
									</tgridcol>
								</children>
							</tgridbody-cols>
							<tgridbody-rows>
								<children>
									<template subtype="element" match="n1:Diagram">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties align="right" valign="top"/>
														<children>
															<text fixtext="diagram">
																<properties class="wsdlSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<properties align="left" bgcolor="white" valign="top"/>
														<children>
															<calltemplate subtype="named" match="WSDLDiagram">
																<parameters/>
															</calltemplate>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="n1:ImportedFrom">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties align="right" valign="top"/>
														<children>
															<text fixtext="imported from">
																<properties class="wsdlSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<properties align="left" valign="top"/>
														<children>
															<link>
																<properties class="wsdlName"/>
																<children>
																	<content subtype="regular">
																		<properties class="wsdlName"/>
																	</content>
																</children>
																<action>
																	<none/>
																</action>
																<hyperlink>
																	<fixtext value="@href"/>
																</hyperlink>
															</link>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="n1:Ports">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties valign="top"/>
														<styles text-align="right"/>
														<children>
															<text fixtext="ports">
																<properties class="wsdlSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<properties bgcolor="white"/>
														<children>
															<template subtype="element" match="n1:Port">
																<children>
																	<bookmark>
																		<action>
																			<none/>
																		</action>
																		<bookmark>
																			<xpath value="@id"/>
																		</bookmark>
																	</bookmark>
																	<template subtype="attribute" match="name">
																		<children>
																			<content subtype="regular">
																				<properties class="wsdlName"/>
																			</content>
																		</children>
																		<variables/>
																	</template>
																	<calltemplate subtype="named" match="WSDLDocumentation">
																		<parameters/>
																	</calltemplate>
																	<tgrid>
																		<properties _xbgcolor="$backgroundColor" cellpadding="2" cellspacing="0"/>
																		<styles width="100%"/>
																		<children>
																			<tgridbody-cols>
																				<children>
																					<tgridcol>
																						<properties width="15%"/>
																						<styles width="10%"/>
																					</tgridcol>
																					<tgridcol>
																						<properties width="85%"/>
																						<styles width="90%"/>
																					</tgridcol>
																				</children>
																			</tgridbody-cols>
																			<tgridbody-rows>
																				<children>
																					<tgridrow>
																						<children>
																							<tgridcell>
																								<properties class="td-space"/>
																								<styles text-align="right"/>
																								<children>
																									<text fixtext="binding">
																										<properties class="wsdlSubTitle"/>
																									</text>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<properties class="td-space"/>
																								<children>
																									<template subtype="element" match="n1:Binding">
																										<children>
																											<calltemplate subtype="named" match="WSDLRefContent">
																												<parameters/>
																											</calltemplate>
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
																								<properties class="td-space"/>
																								<styles text-align="right"/>
																								<children>
																									<text fixtext="extensibility">
																										<properties class="wsdlSubTitle"/>
																									</text>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<properties class="td-space"/>
																								<children>
																									<template subtype="element" match="n1:Extensibility">
																										<children>
																											<template subtype="userdefined" match="element()">
																												<children>
																													<calltemplate subtype="named" match="XMLSource">
																														<parameters>
																															<parameter name="InMixed"/>
																														</parameters>
																													</calltemplate>
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
																				</children>
																			</tgridbody-rows>
																		</children>
																	</tgrid>
																	<condition>
																		<children>
																			<conditionbranch xpath="following-sibling::n1:Port">
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
													</tgridcell>
												</children>
											</tgridrow>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="n1:Type">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties valign="top"/>
														<styles text-align="right"/>
														<children>
															<text fixtext="type">
																<properties class="wsdlSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<calltemplate subtype="named" match="WSDLRefContent">
																<parameters/>
															</calltemplate>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="n1:Extensibility">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties valign="top"/>
														<styles text-align="right"/>
														<children>
															<text fixtext="extensibility">
																<properties class="wsdlSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="userdefined" match="element()">
																<children>
																	<calltemplate subtype="named" match="XMLSource">
																		<parameters>
																			<parameter name="InMixed"/>
																		</parameters>
																	</calltemplate>
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
									<template subtype="element" match="n1:Operations">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties valign="top"/>
														<styles text-align="right"/>
														<children>
															<text fixtext="operations">
																<properties class="wsdlSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<properties bgcolor="white"/>
														<children>
															<template subtype="element" match="n1:Operation">
																<children>
																	<condition>
																		<children>
																			<conditionbranch xpath="parent::*/parent::n1:Binding">
																				<children>
																					<template subtype="attribute" match="name">
																						<children>
																							<content subtype="regular">
																								<properties class="wsdlName"/>
																							</content>
																						</children>
																						<variables/>
																					</template>
																					<calltemplate subtype="named" match="WSDLDocumentation">
																						<parameters/>
																					</calltemplate>
																					<tgrid>
																						<properties _xbgcolor="$backgroundColor" cellpadding="2" cellspacing="0"/>
																						<styles width="100%"/>
																						<children>
																							<tgridbody-cols>
																								<children>
																									<tgridcol>
																										<properties width="15%"/>
																										<styles width="10%"/>
																									</tgridcol>
																									<tgridcol>
																										<properties width="85%"/>
																										<styles width="90%"/>
																									</tgridcol>
																								</children>
																							</tgridbody-cols>
																							<tgridbody-rows>
																								<children>
																									<tgridrow>
																										<children>
																											<tgridcell>
																												<properties class="td-space" valign="top"/>
																												<styles text-align="right"/>
																												<children>
																													<text fixtext="extensibility">
																														<properties class="wsdlSubTitle"/>
																													</text>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<properties class="td-space"/>
																												<children>
																													<template subtype="element" match="n1:Extensibility">
																														<children>
																															<template subtype="userdefined" match="element()">
																																<children>
																																	<calltemplate subtype="named" match="XMLSource">
																																		<parameters>
																																			<parameter name="InMixed" value="true()"/>
																																		</parameters>
																																	</calltemplate>
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
																											<tgridcell>
																												<properties class="td-space" valign="top"/>
																												<styles text-align="right"/>
																												<children>
																													<text fixtext="input">
																														<properties class="wsdlSubTitle"/>
																													</text>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<properties class="td-space"/>
																												<children>
																													<template subtype="element" match="n1:Input">
																														<children>
																															<template subtype="userdefined" match="element()">
																																<children>
																																	<calltemplate subtype="named" match="XMLSource">
																																		<parameters>
																																			<parameter name="InMixed" value="true()"/>
																																		</parameters>
																																	</calltemplate>
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
																											<tgridcell>
																												<properties class="td-space" valign="top"/>
																												<styles text-align="right"/>
																												<children>
																													<text fixtext="output">
																														<properties class="wsdlSubTitle"/>
																													</text>
																												</children>
																											</tgridcell>
																											<tgridcell>
																												<properties class="td-space"/>
																												<children>
																													<template subtype="element" match="n1:Output">
																														<children>
																															<template subtype="userdefined" match="element()">
																																<children>
																																	<calltemplate subtype="named" match="XMLSource">
																																		<parameters>
																																			<parameter name="InMixed" value="true()"/>
																																		</parameters>
																																	</calltemplate>
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
																								</children>
																							</tgridbody-rows>
																						</children>
																					</tgrid>
																				</children>
																			</conditionbranch>
																			<conditionbranch xpath="parent::*/parent::n1:PortType">
																				<children>
																					<bookmark>
																						<action>
																							<none/>
																						</action>
																						<bookmark>
																							<xpath value="@id"/>
																						</bookmark>
																					</bookmark>
																					<template subtype="attribute" match="name">
																						<children>
																							<content subtype="regular">
																								<properties class="wsdlName"/>
																							</content>
																						</children>
																						<variables/>
																					</template>
																					<calltemplate subtype="named" match="WSDLDocumentation">
																						<parameters/>
																					</calltemplate>
																					<template subtype="element" match="n1:Messages">
																						<children>
																							<tgrid>
																								<properties _xbgcolor="$backgroundColor" cellpadding="2" cellspacing="0"/>
																								<styles width="100%"/>
																								<children>
																									<tgridbody-cols>
																										<children>
																											<tgridcol>
																												<properties valign="top" width="15%"/>
																												<styles width="10%"/>
																											</tgridcol>
																											<tgridcol>
																												<properties width="85%"/>
																												<styles width="90%"/>
																											</tgridcol>
																										</children>
																									</tgridbody-cols>
																									<tgridbody-rows>
																										<children>
																											<template subtype="element" match="n1:Message">
																												<children>
																													<tgridrow>
																														<children>
																															<tgridcell>
																																<properties class="td-space" valign="top"/>
																																<styles text-align="right"/>
																																<children>
																																	<template subtype="attribute" match="type">
																																		<children>
																																			<content subtype="regular">
																																				<properties class="wsdlSubTitle"/>
																																			</content>
																																		</children>
																																		<variables/>
																																	</template>
																																</children>
																															</tgridcell>
																															<tgridcell>
																																<properties class="td-space"/>
																																<children>
																																	<template subtype="attribute" match="name">
																																		<children>
																																			<calltemplate subtype="named" match="WSDLRefContent">
																																				<parameters/>
																																			</calltemplate>
																																		</children>
																																		<variables/>
																																	</template>
																																	<calltemplate subtype="named" match="WSDLDocumentation">
																																		<parameters/>
																																	</calltemplate>
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
																			</conditionbranch>
																		</children>
																	</condition>
																	<condition>
																		<children>
																			<conditionbranch xpath="following-sibling::n1:Operation">
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
													</tgridcell>
												</children>
											</tgridrow>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="n1:Parts">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties valign="top"/>
														<styles text-align="right"/>
														<children>
															<text fixtext="parts">
																<properties class="wsdlSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<properties bgcolor="white"/>
														<children>
															<template subtype="element" match="n1:Part">
																<children>
																	<template subtype="attribute" match="name">
																		<children>
																			<content subtype="regular">
																				<properties class="wsdlName"/>
																			</content>
																		</children>
																		<variables/>
																	</template>
																	<calltemplate subtype="named" match="WSDLDocumentation">
																		<parameters/>
																	</calltemplate>
																	<tgrid hiderows="when-body-empty">
																		<properties _xbgcolor="$backgroundColor" cellpadding="2" cellspacing="0"/>
																		<styles width="100%"/>
																		<children>
																			<tgridbody-cols>
																				<children>
																					<tgridcol>
																						<properties width="15%"/>
																						<styles width="10%"/>
																					</tgridcol>
																					<tgridcol>
																						<properties width="85%"/>
																						<styles width="90%"/>
																					</tgridcol>
																				</children>
																			</tgridbody-cols>
																			<tgridbody-rows>
																				<children>
																					<template subtype="element" match="n1:Element">
																						<children>
																							<tgridrow>
																								<children>
																									<tgridcell>
																										<properties class="td-space"/>
																										<styles text-align="right"/>
																										<children>
																											<text fixtext="element">
																												<properties class="wsdlSubTitle"/>
																											</text>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<properties class="td-space"/>
																										<children>
																											<calltemplate subtype="named" match="WSDLRefContent">
																												<parameters/>
																											</calltemplate>
																										</children>
																									</tgridcell>
																								</children>
																							</tgridrow>
																						</children>
																						<variables/>
																					</template>
																					<template subtype="element" match="n1:Type">
																						<children>
																							<tgridrow>
																								<children>
																									<tgridcell>
																										<properties class="td-space"/>
																										<styles text-align="right"/>
																										<children>
																											<text fixtext="type">
																												<properties class="wsdlSubTitle"/>
																											</text>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<properties class="td-space"/>
																										<children>
																											<calltemplate subtype="named" match="WSDLRefContent">
																												<parameters/>
																											</calltemplate>
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
													</tgridcell>
												</children>
											</tgridrow>
										</children>
										<variables/>
									</template>
									<template subtype="element" match="n1:UsedBy">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties valign="top"/>
														<styles text-align="right"/>
														<children>
															<text fixtext="used by">
																<properties class="wsdlSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<condition>
																<children>
																	<conditionbranch xpath="parent::n1:Binding">
																		<children>
																			<template subtype="element" match="n1:By">
																				<children>
																					<paragraph>
																						<properties class="wsdlName"/>
																						<children>
																							<text fixtext="Port ">
																								<properties class="wsdlSubTitle"/>
																							</text>
																							<template subtype="element" match="n1:Port">
																								<children>
																									<calltemplate subtype="named" match="WSDLRefContent">
																										<parameters/>
																									</calltemplate>
																								</children>
																								<variables/>
																							</template>
																							<text fixtext=" in Service ">
																								<properties class="wsdlSubTitle"/>
																							</text>
																							<template subtype="element" match="n1:Service">
																								<children>
																									<calltemplate subtype="named" match="WSDLRefContent">
																										<parameters/>
																									</calltemplate>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</paragraph>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</conditionbranch>
																	<conditionbranch xpath="parent::n1:PortType">
																		<children>
																			<paragraph>
																				<properties class="wsdlName"/>
																				<children>
																					<text fixtext="binding ">
																						<properties class="wsdlSubTitle"/>
																					</text>
																					<template subtype="element" match="n1:Binding">
																						<children>
																							<calltemplate subtype="named" match="WSDLRefContent">
																								<parameters/>
																							</calltemplate>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</paragraph>
																		</children>
																	</conditionbranch>
																	<conditionbranch xpath="parent::n1:Message">
																		<children>
																			<template subtype="element" match="n1:By">
																				<children>
																					<paragraph>
																						<properties class="wsdlName"/>
																						<children>
																							<text fixtext="Operation ">
																								<properties class="wsdlSubTitle"/>
																							</text>
																							<template subtype="element" match="n1:Operation">
																								<children>
																									<calltemplate subtype="named" match="WSDLRefContent">
																										<parameters/>
																									</calltemplate>
																								</children>
																								<variables/>
																							</template>
																							<text fixtext=" in PortType ">
																								<properties class="wsdlSubTitle"/>
																							</text>
																							<template subtype="element" match="n1:PortType">
																								<children>
																									<calltemplate subtype="named" match="WSDLRefContent">
																										<parameters/>
																									</calltemplate>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</paragraph>
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
										</children>
										<variables/>
									</template>
									<template subtype="element" match="n1:Source">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<properties align="right" valign="top"/>
														<children>
															<text fixtext="source">
																<properties class="wsdlSubTitle"/>
															</text>
														</children>
													</tgridcell>
													<tgridcell>
														<properties align="left" valign="top"/>
														<children>
															<template subtype="userdefined" match="element()">
																<children>
																	<calltemplate subtype="named" match="XMLSource">
																		<parameters>
																			<parameter name="InMixed"/>
																		</parameters>
																	</calltemplate>
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
			</globaltemplate>
			<globaltemplate subtype="named" match="WSDLDocumentation">
				<parameters/>
				<children>
					<template subtype="element" match="n1:Documentations">
						<children>
							<template subtype="element" match="n1:Documentation">
								<children>
									<paragraph>
										<styles keep-with-next="always"/>
										<children>
											<content subtype="regular">
												<properties class="wsdlDocumentation"/>
											</content>
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
			<globaltemplate subtype="named" match="WSDLFooter">
				<parameters/>
				<children>
					<paragraph>
						<children>
							<text fixtext="WSDL documentation generated by ">
								<properties class="wsdlSubTitle"/>
							</text>
							<link>
								<properties class="wsdlSubData"/>
								<children>
									<text fixtext="XMLSpy">
										<properties class="wsdlSubData"/>
									</text>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="http://www.altova.com/xmlspy"/>
								</hyperlink>
							</link>
							<text fixtext=" "/>
							<text fixtext="WSDL Editor ">
								<properties class="wsdlSubTitle"/>
							</text>
							<link>
								<properties class="wsdlSubData"/>
								<children>
									<text fixtext="http://www.altova.com/xmlspy">
										<properties class="wsdlSubData"/>
									</text>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="http://www.altova.com/xmlspy"/>
								</hyperlink>
							</link>
						</children>
					</paragraph>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="WSDLRefContent">
				<parameters/>
				<children>
					<link conditional-processing="if (self::attribute()) then ../@ref else @ref">
						<properties class="wsdlName"/>
						<children>
							<content subtype="regular">
								<properties class="wsdlName"/>
							</content>
						</children>
						<action>
							<none/>
						</action>
						<hyperlink>
							<fixtext value="#"/>
							<xpath value="if (self::attribute()) then ../@ref else @ref"/>
						</hyperlink>
					</link>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" additional-mode="pdf-bookmarktree" match="WSDLTreeItem">
				<parameters/>
				<children>
					<pdf-bookmark>
						<children>
							<link>
								<children>
									<template subtype="attribute" match="name">
										<children>
											<content subtype="regular"/>
										</children>
										<variables/>
									</template>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="#"/>
									<xpath value="@id"/>
								</hyperlink>
							</link>
						</children>
					</pdf-bookmark>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="WSDLDiagram">
				<parameters>
					<parameter name="maxheight" type="xs:integer" default-value="850"/>
					<parameter name="maxwidth" type="xs:integer" default-value="580"/>
				</parameters>
				<children>
					<image>
						<styles _xheight="if ($SV_OutputFormat = &apos;HTML&apos;)
  then concat(@height, &apos;px&apos;)
  else if (@width &gt; $maxwidth or @height &gt; $maxheight)
    then if ($maxwidth * 100 div @width &gt; $maxheight * 100 div @height)
	  then concat($maxheight, &apos;px&apos;)
      else concat(($maxwidth * 100 div @width) * @height div 100, &apos;px&apos;)
    else concat(@height, &apos;px&apos;)" _xwidth="if ($SV_OutputFormat = &apos;HTML&apos;)
  then concat(@width, &apos;px&apos;)
  else if (@width &gt; $maxwidth or @height &gt; $maxheight)
    then if ($maxwidth * 100 div @width &gt; $maxheight * 100 div @height)
      then concat(($maxheight * 100 div @height) * @width div 100, &apos;px&apos;)
	  else concat($maxwidth, &apos;px&apos;)
    else concat(@width, &apos;px&apos;)"/>
						<target>
							<xpath value="@src"/>
						</target>
					</image>
				</children>
			</globaltemplate>
		</children>
	</designfragments>
	<xmltables/>
	<authentic-custom-toolbar-buttons/>
</structure>
