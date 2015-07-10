<?xml version="1.0" encoding="UTF-8"?>
<structure version="14" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*XML" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters>
		<parameter name="MaxLevels" default="5"/>
	</parameters>
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
							<text fixtext="This documentation provides a compact overview of all global elements and complex types with their structure up to configurable amount of levels (here "/>
							<autocalc xpath="$MaxLevels"/>
							<text fixtext=") deep."/>
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
	<globalparts>
		<children>
			<globaltemplate subtype="element" match="n1:List" schema-tree-path="n1:List">
				<children>
					<template subtype="element" match="n1:List">
						<children>
							<text fixtext="list of "/>
							<content/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="n1:Union" schema-tree-path="n1:Union">
				<children>
					<template subtype="element" match="n1:Union">
						<children>
							<text fixtext="union of "/>
							<content/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="n1:Restriction" schema-tree-path="n1:Restriction">
				<children>
					<template subtype="element" match="n1:Restriction">
						<children>
							<text fixtext="restriction of "/>
							<content/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="n1:Reference" schema-tree-path="n1:Reference">
				<children>
					<template subtype="element" match="n1:Reference">
						<children>
							<link conditional-processing="for $i in @ref return (//n1:SchemaDocument//n1:ComplexType)[@id=$i]">
								<children>
									<content/>
								</children>
								<action>
									<none/>
								</action>
								<hyperlink>
									<fixtext value="#"/>
									<xpath value="@ref"/>
								</hyperlink>
							</link>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="n1:Extension" schema-tree-path="n1:Element/n1:Type/n1:Extension">
				<children>
					<template subtype="element" match="n1:Extension">
						<children>
							<text fixtext="extension of "/>
							<content/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</globalparts>
	<designfragments>
		<children>
			<globaltemplate subtype="named" match="SchemaItem">
				<parameters>
					<parameter name="Level" type="xs:integer" default-value="1"/>
					<parameter name="What" type="xs:string"/>
					<parameter name="ParentID" type="xs:string" default-value="&apos;&apos;"/>
				</parameters>
				<children>
					<condition>
						<children>
							<conditionbranch xpath="$Level=1">
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
										<properties _xonclick="concat(&apos;toggleAllDiv(&quot;&apos;,$What,&apos;_&apos;,$ParentID,&apos;_&apos;,&apos;&quot;)&apos;)"/>
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
								</children>
							</conditionbranch>
							<conditionbranch xpath="local-name()=&apos;LocalAttribute&apos;">
								<children>
									<template subtype="attribute" match="name">
										<children>
											<text fixtext="@"/>
											<content/>
										</children>
										<variables/>
									</template>
								</children>
							</conditionbranch>
							<conditionbranch xpath="contains(@name,&apos;/&apos;)">
								<children>
									<autocalc xpath="tokenize(@name,&apos;/&apos;)[position()=last()]"/>
								</children>
							</conditionbranch>
							<conditionbranch>
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
							</conditionbranch>
						</children>
					</condition>
					<text fixtext="  "/>
					<template subtype="element" match="n1:Type">
						<children>
							<text fixtext="(">
								<styles font-style="italic"/>
							</text>
							<content>
								<styles font-style="italic"/>
							</content>
							<text fixtext=")">
								<styles font-style="italic"/>
							</text>
						</children>
						<variables/>
					</template>
					<condition>
						<children>
							<conditionbranch xpath="$Level&lt;xs:integer($MaxLevels)+1 and ($Level=1 or contains(@name,&apos;/&apos;))">
								<children>
									<template subtype="userdefined" match="(n1:LocalAttributes/n1:LocalAttribute),(for $ref in n1:Children/n1:Child/@ref return (//n1:SchemaDocument//n1:Element)[@id=$ref])">
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
													<calltemplate subtype="named" match="SchemaItem">
														<parameters>
															<parameter name="Level" value="$Level+1"/>
															<parameter name="What" value="$What"/>
															<parameter name="ParentID" value="$ParentID"/>
														</parameters>
													</calltemplate>
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
									<calltemplate subtype="named" match="SchemaItem">
										<parameters>
											<parameter name="Level"/>
											<parameter name="What" value="$What"/>
											<parameter name="ParentID" value="@id"/>
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
		<xpath-function name="AllChildItems" value="if ( $What = &apos;element&apos; )
then $XML//n1:SchemaDocument//n1:Element[not(contains(@name,&apos;/&apos;))]
else if ( $What = &apos;complexType&apos; )
then $XML//n1:SchemaDocument//n1:ComplexType
else ()"/>
		<xpath-function-name>
			<variable name="What" valuetype="xs:string"/>
		</xpath-function-name>
	</xpath-functions>
	<xpath-functions>
		<xpath-function name="AllReportedKinds" value="&apos;element&apos;,&apos;complexType&apos;"/>
		<xpath-function-name/>
	</xpath-functions>
</structure>
