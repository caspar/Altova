<?xml version="1.0" encoding="UTF-8"?>
<structure version="16" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces/>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="ToolbarButtons.xsd" workingxmlfile="ToolbarButtons.xml"/>
		</schemasources>
	</schemasources>
	<modules>
		<module spsfile="XMLTreeDump.sps"/>
	</modules>
	<flags>
		<scripts/>
		<mainparts>
			<mainpart match="/" spsfile="XMLTreeDump.sps" isactive="0"/>
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
		<Project version="2" app="AuthenticView" UseHigherDotNetFramework="1">
			<GlobalDeclarations>
				<Source>function UpdateOwnToolbarButtonStates()
{
	try
	{
		attrUSorEU = AuthenticView.XMLDataRoot.
			GetChildElement( &apos;ScriptingSamples&apos;, 0 ).
			GetChildElement( &apos;Address&apos;, 0 ).
			GetChildAttribute( &apos;USorEU&apos; );
			
		if ( attrUSorEU.TextValue == &apos;US&apos; )
			AuthenticView.SetToolbarButtonState( &apos;Address_US&apos;, authenticToolbarButtonDisabled );
		else
			AuthenticView.SetToolbarButtonState( &apos;Address_US&apos;, authenticToolbarButtonEnabled );
	
		if ( attrUSorEU.TextValue == &apos;EU&apos; )
			AuthenticView.SetToolbarButtonState( &apos;Address_EU&apos;, authenticToolbarButtonDisabled );
		else
			AuthenticView.SetToolbarButtonState( &apos;Address_EU&apos;, authenticToolbarButtonEnabled );
	}
	catch( error )
	{
		AuthenticView.SetToolbarButtonState( &apos;Address_US&apos;, authenticToolbarButtonDisabled );
		AuthenticView.SetToolbarButtonState( &apos;Address_EU&apos;, authenticToolbarButtonDisabled );
		AuthenticView.SetToolbarButtonState( &apos;Clear_All&apos;, authenticToolbarButtonDisabled );
	}
}

function StartChangingAddress( sTo )
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
			<Events>
				<Event name="On_AuthenticLoad">
					<Source>function On_AuthenticLoad(  )
{
	UpdateOwnToolbarButtonStates();
}
</Source>
				</Event>
				<Event name="On_AuthenticToolbarButtonExecuted">
					<Source>//event fired when a toolbar button action was executed
function On_AuthenticToolbarButtonExecuted( varBtnIdentifier )
{
	// After whatever command user has executed - make sure to update toolbar button states
	UpdateOwnToolbarButtonStates();
}
</Source>
				</Event>
			</Events>
			<Macros>
				<Macro name="ChangeAddressToUS">
					<Source>if ( confirm( &quot;Are you sure to change address data to USA?\nAll existing address data will be deleted!&quot;) )
{
	elemParent = StartChangingAddress( &apos;US&apos; );

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

	elemChild = AuthenticView.CreateXMLNode( spyXMLDataElement );
	elemChild.Name = &apos;LocationDescription&apos;;
	elemParent.AppendChild( elemChild );
}
</Source>
				</Macro>
				<Macro name="ChangeAddressToEU">
					<Source>if ( confirm( &quot;Are you sure to change address data to EU?\nAll existing address data will be deleted!&quot;) )
{
	elemParent = StartChangingAddress( &apos;EU&apos; );

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

	elemChild = AuthenticView.CreateXMLNode( spyXMLDataElement );
	elemChild.Name = &apos;LocationDescription&apos;;
	elemParent.AppendChild( elemChild );
}
</Source>
				</Macro>
				<Macro name="ClearAll">
					<Source>if ( confirm( &apos;Are you sure to clear all fields?&apos; ) )
{
	nodeParent = AuthenticView.XMLDataRoot.
					GetChildElement( &apos;ScriptingSamples&apos;, 0 ).
					GetChildElement( &apos;Address&apos;, 0 ).
					GetChildKind( 0, spyXMLDataElement );

	if ( nodeParent != null )
	{
		nSubElements = nodeParent.CountChildrenKind( spyXMLDataElement ); 
		for ( i = 0; i &lt; nSubElements; i++ )
			nodeParent.GetChildKind( i, spyXMLDataElement ).EraseAllChildren();
	}
}
</Source>
				</Macro>
			</Macros>
		</Project>
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
						<watermark>
							<image transparency="50" fill-page="1" center-if-not-fill="1"/>
							<text transparency="50"/>
						</watermark>
					</documentsection>
					<template subtype="source" match="XML">
						<children>
							<template subtype="element" match="ScriptingSamples">
								<children>
									<template subtype="element" match="Address">
										<children>
											<template subtype="element" match="US">
												<editorproperties autoaddname="0"/>
												<children>
													<text fixtext="Customer is located in USA "/>
													<text fixtext="(click toolbar button EU to switch)">
														<styles font-style="italic"/>
													</text>
													<newline/>
													<newline/>
													<tgrid>
														<children>
															<tgridbody-cols>
																<children>
																	<tgridcol>
																		<styles width="0.74in"/>
																	</tgridcol>
																	<tgridcol/>
																</children>
															</tgridbody-cols>
															<tgridbody-rows>
																<children>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<styles color="#3c3c3c"/>
																				<children>
																					<text fixtext="Street:"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="Street">
																						<children>
																							<editfield>
																								<styles width="3in"/>
																								<children>
																									<content subtype="regular"/>
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
																				<styles color="#3c3c3c"/>
																				<children>
																					<text fixtext="City:"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="City">
																						<children>
																							<editfield>
																								<styles width="3in"/>
																								<children>
																									<content subtype="regular"/>
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
																				<styles color="#3c3c3c"/>
																				<children>
																					<text fixtext="State:"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="State">
																						<children>
																							<editfield>
																								<styles width="3in"/>
																								<children>
																									<content subtype="regular"/>
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
																				<styles color="#3c3c3c"/>
																				<children>
																					<text fixtext="ZIP Code:"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="ZIPCode">
																						<children>
																							<editfield>
																								<styles width="3in"/>
																								<children>
																									<content subtype="regular">
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
													<calltemplate subtype="element" match="LocationDescription"/>
												</children>
												<variables/>
											</template>
											<template subtype="element" match="EU">
												<editorproperties autoaddname="0"/>
												<children>
													<text fixtext="Customer is located in EU "/>
													<text fixtext="(click toolbar button US to switch)">
														<styles font-style="italic"/>
													</text>
													<newline/>
													<newline/>
													<tgrid>
														<children>
															<tgridbody-cols>
																<children>
																	<tgridcol>
																		<styles width="0.74in"/>
																	</tgridcol>
																	<tgridcol/>
																</children>
															</tgridbody-cols>
															<tgridbody-rows>
																<children>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<styles color="#3c3c3c"/>
																				<children>
																					<text fixtext="Street:"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="Street">
																						<children>
																							<editfield>
																								<styles width="3in"/>
																								<children>
																									<content subtype="regular"/>
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
																				<styles color="#3c3c3c"/>
																				<children>
																					<text fixtext="City:"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="City">
																						<children>
																							<editfield>
																								<styles width="3in"/>
																								<children>
																									<content subtype="regular"/>
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
																				<styles color="#3c3c3c"/>
																				<children>
																					<text fixtext="Country"/>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<template subtype="element" match="Country">
																						<children>
																							<editfield>
																								<styles width="3in"/>
																								<children>
																									<content subtype="regular"/>
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
													<calltemplate subtype="element" match="LocationDescription"/>
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
	<globalparts>
		<children>
			<globaltemplate subtype="element" match="LocationDescription" schema-tree-path="$XML/ScriptingSamples/Address/US/LocationDescription">
				<children>
					<template subtype="element" match="LocationDescription">
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
												<children>
													<tgridcell/>
												</children>
											</tgridrow>
											<tgridrow>
												<children>
													<tgridcell>
														<styles color="#3c3c3c"/>
														<children>
															<text fixtext="Please add a few words about the location:"/>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
											<tgridrow>
												<children>
													<tgridcell>
														<styles border-color="black" border-style="dotted" border-width="1px"/>
														<children>
															<content subtype="regular"/>
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
			<globaltemplate subtype="element" match="bold" schema-tree-path="bold">
				<children>
					<template subtype="element" match="bold">
						<children>
							<content subtype="regular">
								<styles font-weight="bold"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="italic" schema-tree-path="italic">
				<children>
					<template subtype="element" match="italic">
						<children>
							<content subtype="regular">
								<styles font-style="italic"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</globalparts>
	<designfragments/>
	<xmltables/>
	<authentic-custom-toolbar-buttons>
		<scripted-button match="ChangeAddressToUS" iconfile="US.bmp" tooltip="Change address to USA" id="Address_US"/>
		<scripted-button match="ChangeAddressToEU" iconfile="EU.bmp" tooltip="Change address to EU" id="Address_EU"/>
		<separator/>
		<scripted-button match="ClearAll" text="Clear All" tooltip="Clear all fields" id="Clear_All"/>
		<separator/>
		<textstateicon match="bold" iconfile="bold.bmp"/>
		<textstateicon match="italic" iconfile="italic.bmp"/>
	</authentic-custom-toolbar-buttons>
</structure>
