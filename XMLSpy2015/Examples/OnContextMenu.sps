<?xml version="1.0" encoding="UTF-8"?>
<structure version="14" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces/>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="ScriptingSamples.xsd" workingxmlfile="OnContextMenu.xml"/>
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
		<Project version="2" app="AuthenticView" UseHigherDotNetFramework="1">
			<GlobalDeclarations>
				<Source>function GetCurrentEditFieldXMLNode()
{
	if ( AuthenticView.EventContext.IsAvailable() )
	{
		nodeContext = AuthenticView.EventContext.GetXMLNode();
		if ( nodeContext != null )
		{
			if ( nodeContext.Kind == spyXMLDataText ) return nodeContext.Parent;
			if ( nodeContext.Kind == spyXMLDataXML  ) return nodeContext;
		}
	}

	return null;
}

function GetCurrentEditFieldName()
{
	nodeCurrent = GetCurrentEditFieldXMLNode();
	if ( nodeCurrent != null )
		return nodeCurrent.Name;

	return &apos;&apos;;
}
</Source>
			</GlobalDeclarations>
			<Events>
				<Event name="On_AuthenticContextMenuActivated">
					<Source>function On_AuthenticContextMenuActivated(  )
{
	objContextMenu = AuthenticView.ContextMenu;

	// First, we do not want user to be able to remove any elements
	// and therefore we are searching for the &quot;Remove&quot; menu and delete it
	nItem = 0;
	while ( nItem &lt; objContextMenu.CountItems() )
	{
		if ( objContextMenu.GetItemText( nItem ).indexOf( &apos;Remove&apos; ) &gt;= 0 )
			objContextMenu.DeleteItem( nItem );
		else
			nItem++;
	}

	// Now we also want to add our own menu entries depending on location
	sFieldName = GetCurrentEditFieldName();
	if ( sFieldName != &apos;&apos; )
	{
		objContextMenu.InsertItem( 0, &apos;Erase &apos; + sFieldName, &apos;OnEraseEditField&apos; );
		objContextMenu.InsertItem( 1, &apos;Set &apos; + sFieldName + &apos; to default&apos;, &apos;OnSetEditFieldToDefault&apos; );
	}
}
</Source>
				</Event>
				<Event name="On_AuthenticLoad">
					<Source>function On_AuthenticLoad(  )
{
	// We are disabling all entry helpers in order to prevent user from manipulating XML tree
	AuthenticView.DisableElementEntryHelper();
	AuthenticView.DisableAttributeEntryHelper();
	
	// We are also disabling the markup buttons for the same purpose
	AuthenticView.SetToolbarButtonState( &apos;AuthenticMarkupSmall&apos;, authenticToolbarButtonDisabled );
	AuthenticView.SetToolbarButtonState( &apos;AuthenticMarkupLarge&apos;, authenticToolbarButtonDisabled );
	AuthenticView.SetToolbarButtonState( &apos;AuthenticMarkupMixed&apos;, authenticToolbarButtonDisabled );
}
</Source>
				</Event>
			</Events>
			<Macros>
				<Macro name="OnEraseEditField">
					<Source>nodeCurrent = GetCurrentEditFieldXMLNode();
if ( nodeCurrent != null )
{
	nodeCurrent.TextValue = &apos;&apos;;
}
</Source>
				</Macro>
				<Macro name="OnSetEditFieldToDefault">
					<Source>switch ( GetCurrentEditFieldName() ) {
case &apos;Street&apos;  : GetCurrentEditFieldXMLNode().TextValue = &apos;900 Cummings Center&apos;; break;
case &apos;City&apos;    : GetCurrentEditFieldXMLNode().TextValue = &apos;Beverly&apos;;             break;
case &apos;State&apos;   : GetCurrentEditFieldXMLNode().TextValue = &apos;MA&apos;;                  break;
case &apos;ZIPCode&apos; : GetCurrentEditFieldXMLNode().TextValue = &apos;01915&apos;;               break;
}
</Source>
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
													<text fixtext="This example shows how to limit or modify default Authentic behavior in order to fully control what user can do. On_AuthenticLoad event is used to switch off entry-helpers, so that user cannot change XML structure, and to disable critical toolbar buttons. On_AuthenticContextMenuActivated allows to remove some of the context menu entries, again so that user cannot changed XML structure, and adds few own commands to improve editing experience."/>
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
											<template subtype="element" match="US">
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
																								<styles width="0.32in"/>
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
																								<styles width="0.48in"/>
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
													<newline/>
													<text fixtext="NOTICE: you can use context menu if necessary to empty edit field or to set it to a default value or to paste data from an external application"/>
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
		</children>
	</mainparts>
	<globalparts/>
	<designfragments/>
	<xmltables/>
	<authentic-custom-toolbar-buttons/>
</structure>
