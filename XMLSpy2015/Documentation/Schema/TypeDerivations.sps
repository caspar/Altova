<?xml version="1.0" encoding="UTF-8"?>
<structure version="14" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*XML" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="n1" uri="http://www.altova.com/documentation"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="SchemaDocumentation.xsd" workingxmlfile="SampleData\Sample.xml"/>
		</schemasources>
	</schemasources>
	<modules>
		<module spsfile="Modules\VerifySettings.sps"/>
	</modules>
	<flags>
		<scripts/>
		<globalparts/>
		<designfragments/>
		<pagelayouts/>
		<xpath-functions/>
	</flags>
	<scripts>
		<script language="javascript">function getAllDiv(kind)
{
	var arr=[];
	i = 0;
	div = null;
	var allDiv = document.getElementsByTagName(&apos;div&apos;);
	while (div = allDiv[i++])
	{
		if (div.id.indexOf(kind) == 0)
			arr.push(div);
	}
	return arr;
}

 function toggleAllDiv(kind,visible)
{
	allDiv = getAllDiv(kind);
	for (i = 0; i &lt; allDiv.length; i++)
	{
		toggleDiv(allDiv[i], visible);
	}
} 

function toggleDiv(div, visible)
{
	if (visible == undefined)
	{
		visible = false;
		if (div.style.display == &apos;none&apos;) visible = true;
	}

	if (visible)
	{
		div.style.display = &apos;block&apos;;
	}
	else
	{
		div.style.display = &apos;none&apos;;
	}
}
</script>
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
						<properties columncount="1" columngap="0.50in" headerfooterheight="fixed" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.30in" papermarginheader="0.30in" papermarginleft="0.60in" papermarginright="0.60in" papermargintop="0.79in" paperwidth="8.50in"/>
						<children>
							<globaltemplate subtype="pagelayout" match="footerall">
								<children>
									<calltemplate subtype="named" match="Footer">
										<parameters/>
									</calltemplate>
								</children>
							</globaltemplate>
							<globaltemplate subtype="pdf-bookmarktree" match="pdf-bookmarktree">
								<children>
									<template subtype="userdefined" match="sps:AllReportedKinds()">
										<children>
											<calltemplate subtype="named" match="PDF_Links">
												<parameters>
													<parameter name="What" value="."/>
												</parameters>
											</calltemplate>
										</children>
										<variables/>
									</template>
								</children>
							</globaltemplate>
						</children>
					</documentsection>
					<calltemplate subtype="named" match="EnsureAllIncludesAndDetails">
						<parameters/>
					</calltemplate>
					<paragraph paragraphtag="h3">
						<children>
							<text fixtext="This documentation lists simple and complex types with all types directly and indirectly derived from them."/>
						</children>
					</paragraph>
					<template subtype="userdefined" match="sps:AllReportedKinds()">
						<children>
							<calltemplate subtype="named" match="FirstSchemaItem">
								<parameters>
									<parameter name="What" value="."/>
								</parameters>
							</calltemplate>
						</children>
						<variables/>
					</template>
					<condition>
						<children>
							<conditionbranch xpath="$SV_OutputFormat = &apos;HTML&apos;">
								<children>
									<calltemplate subtype="named" match="Footer">
										<parameters/>
									</calltemplate>
								</children>
							</conditionbranch>
						</children>
					</condition>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts/>
	<designfragments>
		<children>
			<globaltemplate subtype="named" match="SchemaItem" schema-tree-path="n1:SimpleType">
				<parameters>
					<parameter name="Level" type="xs:integer" default-value="1"/>
					<parameter name="What" type="xs:string"/>
					<parameter name="ParentID" type="xs:string" default-value="&apos;&apos;"/>
					<parameter name="ParentName" type="xs:string" occurrence="none-or-one" default-value="&apos;&apos;"/>
					<parameter name="ParentWhat" type="xs:string" occurrence="none-or-one" default-value="&apos;&apos;"/>
				</parameters>
				<children>
					<template subtype="element" match="n1:UsedBy">
						<children>
							<template subtype="element" filter="@type=&apos;simpleType&apos; or @type=&apos;complexType&apos;" match="n1:By">
								<sort>
									<key match="@type" order="descending"/>
									<key match="upper-case(text())"/>
								</sort>
								<children>
									<template subtype="userdefined" match="for $ref in @ref return //n1:SchemaDocument//*[@id=$ref]">
										<children>
											<paragraph>
												<properties _xid="concat($What,&apos;_&apos;,$ParentID,&apos;_&apos;,generate-id())"/>
												<children>
													<autocalc xpath="$What">
														<styles color="white"/>
													</autocalc>
													<text fixtext=" "/>
													<template subtype="userdefined" match="1 to ($Level -1)">
														<children>
															<text fixtext="|"/>
															<text fixtext="---">
																<styles color="white"/>
															</text>
														</children>
														<variables/>
													</template>
													<text fixtext="|---"/>
													<link>
														<children>
															<template subtype="attribute" match="name">
																<children>
																	<content/>
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
													<template subtype="element" match="n1:Type">
														<children>
															<text fixtext=" "/>
															<template subtype="userdefined" match=".//n1:Reference[@ref=$ParentID]">
																<children>
																	<text fixtext="(">
																		<styles font-style="italic"/>
																	</text>
																	<autocalc xpath="$SwitchType">
																		<styles font-style="italic"/>
																	</autocalc>
																	<condition>
																		<children>
																			<conditionbranch xpath="$DerivationSteps">
																				<children>
																					<template subtype="uservariable" match="$DerivationSteps">
																						<children>
																							<autocalc xpath="concat( lower-case( local-name() ), &apos; of&apos; )">
																								<styles font-style="italic"/>
																							</autocalc>
																							<text fixtext=" ">
																								<styles font-style="italic"/>
																							</text>
																							<condition>
																								<children>
																									<conditionbranch xpath="position()!=last()">
																										<children>
																											<text fixtext="(">
																												<styles font-style="italic"/>
																											</text>
																										</children>
																									</conditionbranch>
																								</children>
																							</condition>
																						</children>
																						<variables/>
																					</template>
																					<template subtype="parameter" match="$ParentName">
																						<children>
																							<content>
																								<styles font-style="italic"/>
																							</content>
																						</children>
																						<variables/>
																					</template>
																					<template subtype="uservariable" match="$DerivationSteps">
																						<children>
																							<condition>
																								<children>
																									<conditionbranch xpath="position()!=last()">
																										<children>
																											<text fixtext=")">
																												<styles font-style="italic"/>
																											</text>
																										</children>
																									</conditionbranch>
																								</children>
																							</condition>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</conditionbranch>
																			<conditionbranch>
																				<children>
																					<template subtype="parameter" match="$ParentName">
																						<children>
																							<text fixtext="=">
																								<styles font-style="italic"/>
																							</text>
																							<content>
																								<styles font-style="italic"/>
																							</content>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																	<text fixtext=")">
																		<styles font-style="italic"/>
																	</text>
																</children>
																<variables>
																	<variable name="DerivationSteps" value="ancestor::* except $TypeAncestors" valuetype="&lt;auto&gt;"/>
																</variables>
															</template>
														</children>
														<variables>
															<variable name="TypeAncestors" value="ancestor-or-self::*" valuetype="&lt;auto&gt;"/>
														</variables>
													</template>
													<calltemplate subtype="named" match="SchemaItem">
														<parameters>
															<parameter name="Level" value="$Level + 1"/>
															<parameter name="What" value="$What"/>
															<parameter name="ParentID" value="@id"/>
															<parameter name="ParentName" value="@name"/>
															<parameter name="ParentWhat" value="local-name()"/>
														</parameters>
													</calltemplate>
												</children>
											</paragraph>
										</children>
										<variables>
											<variable name="SwitchType" value="if ( lower-case(local-name()) != lower-case($ParentWhat) )
then concat(lower-case(substring(local-name(),1,1)),substring(local-name(),2),&apos;, &apos;)
else &apos;&apos;" valuetype="&lt;auto&gt;"/>
										</variables>
									</template>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="FirstSchemaItem">
				<parameters>
					<parameter name="What" type="xs:string" default-value="&apos;&apos;"/>
				</parameters>
				<children>
					<bookmark>
						<children>
							<condition>
								<children>
									<conditionbranch xpath="$SV_OutputFormat = &apos;HTML&apos;">
										<children>
											<paragraph paragraphtag="p">
												<children>
													<link>
														<properties _xonclick="concat(&apos;toggleAllDiv(&quot;&apos;,$What,&apos;&quot;,true)&apos;)"/>
														<children>
															<text fixtext="Expand all "/>
															<autocalc xpath="$What"/>
															<text fixtext="s"/>
														</children>
														<action>
															<none/>
														</action>
														<hyperlink>
															<fixtext value="javascript:;"/>
														</hyperlink>
													</link>
													<text fixtext="   "/>
													<link>
														<properties _xonclick="concat(&apos;toggleAllDiv(&quot;&apos;,$What,&apos;&quot;,false)&apos;)"/>
														<children>
															<text fixtext="Collapse all "/>
															<autocalc xpath="$What"/>
															<text fixtext="s"/>
														</children>
														<action>
															<none/>
														</action>
														<hyperlink>
															<fixtext value="javascript:;"/>
														</hyperlink>
													</link>
												</children>
											</paragraph>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<action>
							<none/>
						</action>
						<bookmark>
							<xpath value="$What"/>
							<fixtext value="StartHere"/>
						</bookmark>
					</bookmark>
					<template subtype="userdefined" match="sps:AllChildItems($What)">
						<sort>
							<key match="upper-case(@name)"/>
						</sort>
						<children>
							<paragraph>
								<styles keep-together="always"/>
								<children>
									<bookmark>
										<action>
											<none/>
										</action>
										<bookmark>
											<xpath value="@id"/>
										</bookmark>
									</bookmark>
									<link conditional-processing="$SV_OutputFormat = &apos;HTML&apos;">
										<properties _xonclick="concat(&apos;toggleAllDiv(&quot;&apos;,$What,&apos;_&apos;,@id,&apos;_&apos;,&apos;&quot;)&apos;)"/>
										<styles color="black" text-decoration="none"/>
										<children>
											<autocalc xpath="$What"/>
											<text fixtext=" "/>
											<template subtype="attribute" match="name">
												<children>
													<content>
														<styles font-weight="bold"/>
													</content>
												</children>
												<variables/>
											</template>
										</children>
										<action>
											<none/>
										</action>
										<hyperlink>
											<fixtext value="javascript:;"/>
										</hyperlink>
									</link>
									<calltemplate subtype="named" match="SchemaItem">
										<parameters>
											<parameter name="Level"/>
											<parameter name="What" value="$What"/>
											<parameter name="ParentID" value="@id"/>
											<parameter name="ParentName" value="@name"/>
											<parameter name="ParentWhat" value="local-name()"/>
										</parameters>
									</calltemplate>
								</children>
							</paragraph>
							<paragraph>
								<properties _xid="concat($What,&apos;_&apos;,@id,&apos;_&apos;)"/>
								<children>
									<text fixtext=" "/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="named" match="Footer">
				<parameters/>
				<children>
					<paragraph paragraphtag="p">
						<properties class="schemaSubTitle"/>
						<styles font-size="smaller"/>
						<children>
							<text fixtext="XML Schema documentation generated by ">
								<styles color="gray"/>
							</text>
							<link>
								<children>
									<text fixtext="XMLSpy"/>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="http://www.altova.com/xmlspy"/>
								</hyperlink>
							</link>
							<text fixtext=" Schema Editor ">
								<styles color="gray"/>
							</text>
							<link>
								<properties class="schemaName"/>
								<children>
									<text fixtext="http://www.altova.com/xmlspy"/>
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
			<globaltemplate subtype="named" additional-mode="pdf-bookmarktree" match="PDF_Links">
				<parameters>
					<parameter name="What" type="xs:string" default-value="&apos;&apos;"/>
				</parameters>
				<children>
					<pdf-bookmark>
						<children>
							<link>
								<children>
									<autocalc xpath="$What"/>
									<text fixtext="s"/>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="#"/>
									<xpath value="$What"/>
									<fixtext value="StartHere"/>
								</hyperlink>
							</link>
							<template subtype="userdefined" match="sps:AllChildItems($What)">
								<sort>
									<key match="upper-case(@name)"/>
								</sort>
								<children>
									<pdf-bookmark>
										<children>
											<link>
												<children>
													<template subtype="attribute" match="name">
														<children>
															<content/>
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
								<variables/>
							</template>
						</children>
					</pdf-bookmark>
				</children>
			</globaltemplate>
		</children>
	</designfragments>
	<xmltables/>
	<authentic-custom-toolbar-buttons/>
	<xpath-functions>
		<xpath-function name="AllChildItems" value="if ( $What = &apos;simpleType&apos; )
then $XML//n1:SchemaDocument//n1:SimpleType
else if ( $What = &apos;complexType&apos; )
then $XML//n1:SchemaDocument//n1:ComplexType
else ()"/>
		<xpath-function-name>
			<variable name="What" valuetype="xs:string"/>
		</xpath-function-name>
	</xpath-functions>
	<xpath-functions>
		<xpath-function name="AllReportedKinds" value="&apos;simpleType&apos;,&apos;complexType&apos;"/>
		<xpath-function-name/>
	</xpath-functions>
</structure>
