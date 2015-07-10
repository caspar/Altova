<?xml version="1.0" encoding="UTF-8"?>
<structure version="14" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces/>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="ScriptingSamples.xsd" workingxmlfile="OnChange.xml"/>
		</schemasources>
	</schemasources>
	<modules>
		<module spsfile="XMLTreeDump.sps"/>
	</modules>
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
		<Project version="2" app="AuthenticView" UseHigherDotNetFramework="1">
			<GlobalDeclarations>
				<Source>function StartChangingAddress( sTo )
{
	elemAddress =
		AuthenticView.XMLDataRoot.
		GetChildElement( &quot;ScriptingSamples&quot;, 0 ).
		GetChildElement( &quot;Address&quot;, 0 );
	
	// first, delete all existing children of the Address element
	elemAddress.EraseAllChildren();
	
	// append the new attribute value
	attrUSorEU = AuthenticView.CreateXMLNode( spyXMLDataAttr );
	attrUSorEU.Name = &apos;USorEU&apos;;
	attrUSorEU.TextValue = sTo;
	elemAddress.AppendChild( attrUSorEU );
	
	// append the EU or US element which will contain address details
	elemParent = AuthenticView.CreateXMLNode( spyXMLDataElement );
	elemParent.Name = sTo;
	elemAddress.AppendChild( elemParent );
	
	return elemParent;
}
</Source>
			</GlobalDeclarations>
			<Macros>
				<Macro name="BeforeChangeToUS">
					<Source>if ( !confirm( &quot;Are you sure to change address data to USA?\nAll existing address data will be deleted!&quot;) )
	AuthenticView.DoNotPerformStandardAction();</Source>
				</Macro>
				<Macro name="AfterChangeToEU">
					<Source>elemParent = StartChangingAddress( &apos;EU&apos; );

// and now append all address elements in EU
elemChild = AuthenticView.CreateXMLNode( spyXMLDataElement );
elemChild.Name = &apos;Street&apos;;
elemParent.AppendChild( elemChild );

elemChild = AuthenticView.CreateXMLNode( spyXMLDataElement );
elemChild.Name = &apos;City&apos;;
elemParent.AppendChild( elemChild );

elemChild = AuthenticView.CreateXMLNode( spyXMLDataElement );
elemChild.Name = &apos;Country&apos;;
elemParent.AppendChild( elemChild );
</Source>
				</Macro>
				<Macro name="AfterChangeToUS">
					<Source>elemParent = StartChangingAddress( &apos;US&apos; );

// and now append all address elements in US
elemChild = AuthenticView.CreateXMLNode( spyXMLDataElement );
elemChild.Name = &apos;Street&apos;;
elemParent.AppendChild( elemChild );

elemChild = AuthenticView.CreateXMLNode( spyXMLDataElement );
elemChild.Name = &apos;City&apos;;
elemParent.AppendChild( elemChild );

elemChild = AuthenticView.CreateXMLNode( spyXMLDataElement );
elemChild.Name = &apos;State&apos;;
elemParent.AppendChild( elemChild );

elemChild = AuthenticView.CreateXMLNode( spyXMLDataElement );
elemChild.Name = &apos;ZIPCode&apos;;
elemParent.AppendChild( elemChild );
</Source>
				</Macro>
				<Macro name="BeforeChangeToEU">
					<Source>if ( !confirm( &quot;Are you sure to change address data to EU?\nAll existing address data will be deleted!&quot;) )
	AuthenticView.DoNotPerformStandardAction();</Source>
				</Macro>
			</Macros>
		</Project>
	</script-project>
	<importedxslt/>
	<globalstyles>
		<rule url="ScriptingSamples.css">
			<media>
				<media value="all"/>
			</media>
		</rule>
	</globalstyles>
	<mainparts>
		<children>
			<globaltemplate subtype="main" match="/">
				<document-properties/>
				<children>
					<documentsection>
						<properties columncount="1" columngap="0.50in" headerfooterheight="fixed" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.30in" papermarginheader="0.30in" papermarginleft="0.60in" papermarginright="0.60in" papermargintop="0.79in" paperwidth="8.50in"/>
					</documentsection>
					<template subtype="source" match="XML">
						<children>
							<condition>
								<children>
									<conditionbranch xpath="false()">
										<children>
											<paragraph paragraphtag="p">
												<properties class="info"/>
												<children>
													<text fixtext="This example demonstrates how to use OnBeforeChange and OnAfterChange events which can be assigned to editable objects in Authentic. In this particular example both radio-buttons use OnBeforeChange event to ask user whether he is sure to peform the change, and OnAfterChange in order to provide required changes to XML structure."/>
												</children>
											</paragraph>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<template subtype="element" match="ScriptingSamples">
								<children>
									<template subtype="element" match="Address">
										<children>
											<newline/>
											<text fixtext="First, please select on what continent your customer lives:"/>
											<newline/>
											<newline/>
											<text fixtext="  "/>
											<template subtype="attribute" match="USorEU">
												<children>
													<radiobutton checkedvalue="US">
														<children>
															<content/>
														</children>
														<authentic-event-handlers OnAfterChange="AfterChangeToUS" OnBeforeChange="BeforeChangeToUS"/>
													</radiobutton>
													<text fixtext="USA"/>
												</children>
												<variables/>
											</template>
											<text fixtext=" "/>
											<template subtype="attribute" match="USorEU">
												<children>
													<radiobutton checkedvalue="EU">
														<children>
															<content/>
														</children>
														<authentic-event-handlers OnAfterChange="AfterChangeToEU" OnBeforeChange="BeforeChangeToEU"/>
													</radiobutton>
													<text fixtext="EU"/>
												</children>
												<variables/>
											</template>
											<newline/>
											<newline/>
											<text fixtext="and then fill out his complete address:"/>
											<newline/>
											<newline/>
											<template subtype="element" match="US">
												<editorproperties autoaddname="0"/>
												<children>
													<tgrid>
														<children>
															<tgridbody-cols>
																<children>
																	<tgridcol>
																		<styles width="0.85in"/>
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
																					<text fixtext="  Street:"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="Street">
																						<children>
																							<editfield>
																								<styles width="3in"/>
																								<children>
																									<content/>
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
																					<text fixtext="  City:"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="City">
																						<children>
																							<editfield>
																								<styles width="3in"/>
																								<children>
																									<content/>
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
																					<text fixtext="  State:"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="State">
																						<children>
																							<editfield>
																								<styles width="3in"/>
																								<children>
																									<content/>
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
																					<text fixtext="  ZIP Code:"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="ZIPCode">
																						<children>
																							<editfield>
																								<styles width="3in"/>
																								<children>
																									<content>
																										<format basic-type="xsd" datatype="positiveInteger"/>
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
											<template subtype="element" match="EU">
												<editorproperties autoaddname="0"/>
												<children>
													<tgrid>
														<children>
															<tgridbody-cols>
																<children>
																	<tgridcol>
																		<styles width="0.85in"/>
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
																					<text fixtext="  Street:"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="Street">
																						<children>
																							<editfield>
																								<styles width="3in"/>
																								<children>
																									<content/>
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
																					<text fixtext="  City:"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="City">
																						<children>
																							<editfield>
																								<styles width="3in"/>
																								<children>
																									<content/>
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
																					<text fixtext="  Country"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="Country">
																						<children>
																							<editfield>
																								<styles width="3in"/>
																								<children>
																									<content/>
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
									<calltemplate subtype="named" match="XMLTreeDump">
										<parameters/>
									</calltemplate>
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
