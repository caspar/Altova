<?xml version="1.0" encoding="UTF-8"?>
<structure version="16" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces/>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="ScriptingSamples.xsd" workingxmlfile="OnClick.xml"/>
		</schemasources>
	</schemasources>
	<modules/>
	<flags>
		<scripts/>
		<mainparts/>
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
			<Macros>
				<Macro name="OnResetAll">
					<Source>if ( confirm( &apos;Are you sure to empty all fields? &apos; ) )
{
	elemUS = AuthenticView.XMLDataRoot.
		GetChildElement( &apos;ScriptingSamples&apos;, 0 ).
		GetChildElement( &apos;Address&apos;, 0 ).
		GetChildElement( &apos;US&apos;, 0 );
	
	elemUS.GetChildElement( &apos;Street&apos;,  0 ).TextValue = &apos;&apos;;
	elemUS.GetChildElement( &apos;City&apos;,    0 ).TextValue = &apos;&apos;;
	elemUS.GetChildElement( &apos;State&apos;,   0 ).TextValue = &apos;&apos;;
	elemUS.GetChildElement( &apos;ZIPCode&apos;, 0 ).TextValue = &apos;&apos;;
}
</Source>
				</Macro>
				<Macro name="OnAltovaAddress">
					<Source>if ( confirm( &apos;Are you sure to replace all fields with Altova address? &apos; ) )
{
	elemUS = AuthenticView.XMLDataRoot.
		GetChildElement( &apos;ScriptingSamples&apos;, 0 ).
		GetChildElement( &apos;Address&apos;, 0 ).
		GetChildElement( &apos;US&apos;, 0 );
	
	elemUS.GetChildElement( &apos;Street&apos;,  0 ).TextValue = &apos;900 Cummings Center&apos;;
	elemUS.GetChildElement( &apos;City&apos;,    0 ).TextValue = &apos;Beverly&apos;;
	elemUS.GetChildElement( &apos;State&apos;,   0 ).TextValue = &apos;MA&apos;;
	elemUS.GetChildElement( &apos;ZIPCode&apos;, 0 ).TextValue = &apos;01915&apos;;
}
</Source>
				</Macro>
				<Macro name="OnGoogleMaps">
					<Source>if ( !confirm( &apos;This will open a browser window with Google Maps. Do you want to proceed?&apos; ) )
	AuthenticView.DoNotPerformStandardAction();</Source>
				</Macro>
				<Macro name="OnZoomIn">
					<Source>AuthenticView.EventContext.SetVariableValue(
	&apos;Zoom&apos;,
	parseInt( AuthenticView.EventContext.GetVariableValue( &apos;Zoom&apos; ) ) + 1
);
</Source>
				</Macro>
				<Macro name="OnZoomOut">
					<Source>nZoom = parseInt( AuthenticView.EventContext.GetVariableValue( &apos;Zoom&apos; ) );
if ( nZoom &gt; 1 )
{
	AuthenticView.EventContext.SetVariableValue( &apos;Zoom&apos;, nZoom - 1 );
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
						<watermark>
							<image transparency="50" fill-page="1" center-if-not-fill="1"/>
							<text transparency="50"/>
						</watermark>
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
													<text fixtext="This example demonstrates usage of OnClick and OnBeforeLinkClick events. OnClick can be used with buttons and images - here it is used to manipulate form data. OnBeforeLinkClick event is available for links - it allows to add own functionality before link click will be executed or prevent it completely."/>
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
													<newline/>
													<tgrid>
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
																					<text fixtext="Click on this button to reset all fields to an empty state:  ">
																						<styles font-style="italic"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<styles text-align="center"/>
																				<children>
																					<button>
																						<children>
																							<text fixtext="Reset All"/>
																						</children>
																						<action>
																							<none/>
																						</action>
																						<authentic-event-handlers OnClick="OnResetAll"/>
																					</button>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<text fixtext="Click on Altova image to fill fields with Altova address: ">
																						<styles font-style="italic"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<styles text-align="center"/>
																				<children>
																					<image>
																						<target>
																							<fixtext value="Altova.jpg"/>
																						</target>
																						<authentic-event-handlers OnClick="OnAltovaAddress"/>
																					</image>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell/>
																			<tgridcell joinleft="1"/>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<text fixtext="Click the link below to open Google Maps in browser:">
																						<styles font-style="italic"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell joinleft="1"/>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<link>
																						<children>
																							<autocalc xpath="concat( Street, &apos;, &apos;, City, &apos;, &apos; , State, &apos;, &apos;, ZIPCode )"/>
																						</children>
																						<action>
																							<none/>
																						</action>
																						<authentic-event-handlers OnBeforeLinkClick="OnGoogleMaps"/>
																						<hyperlink>
																							<fixtext value="http://maps.google.com?q="/>
																							<xpath value="replace( concat( Street, &apos;,&apos;, City, &apos;,&apos; , State, &apos;,&apos;, ZIPCode ), &apos; &apos;, &apos;%20&apos; )"/>
																						</hyperlink>
																					</link>
																				</children>
																			</tgridcell>
																			<tgridcell joinleft="1"/>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<image imagealt="Google Maps">
																						<properties height="400" width="400"/>
																						<target>
																							<xpath value="iri-to-uri(concat( &apos;http://maps.google.com/maps/api/staticmap?center=&apos;,
concat( Street, &apos;,&apos;, City, &apos;,&apos; , State, &apos;,&apos;, ZIPCode ),
&apos;&amp;zoom=&apos;,$Zoom,&apos;&amp;size=400x400&amp;sensor=false&amp;markers=color:red|&apos;,
concat( Street, &apos;,&apos;, City, &apos;,&apos; , State, &apos;,&apos;, ZIPCode )))"/>
																						</target>
																					</image>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties valign="top"/>
																				<styles text-align="center"/>
																				<children>
																					<button>
																						<styles width="0.93in"/>
																						<children>
																							<text fixtext="Zoom In"/>
																						</children>
																						<action>
																							<none/>
																						</action>
																						<authentic-event-handlers OnClick="OnZoomIn"/>
																					</button>
																					<newline/>
																					<button>
																						<styles width="0.93in"/>
																						<children>
																							<text fixtext="Zoom Out"/>
																						</children>
																						<action>
																							<none/>
																						</action>
																						<authentic-event-handlers OnClick="OnZoomOut"/>
																					</button>
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
						<variables>
							<variable name="Zoom" value="16" valuetype="xs:integer" editable="1"/>
						</variables>
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
