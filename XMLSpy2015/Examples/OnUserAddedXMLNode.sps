<?xml version="1.0" encoding="UTF-8"?>
<structure version="16" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces/>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="ScriptingSamples.xsd" workingxmlfile="OnUserAddedXMLNode.xml"/>
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
			<Forms>
				<Form name="USorEU">
					<Source>//Occurs whenever the user loads the form.
function USorEU_Load( objSender, e_EventArgs )
{
	objSender.btnUS.Checked = true;
}
</Source>
					<FormData>&lt;Object type=&quot;System.Windows.Forms.Form, System.Windows.Forms, Version=2.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089&quot; name=&quot;USorEU&quot; children=&quot;Controls&quot;&gt;&lt;Object type=&quot;System.Windows.Forms.Button, System.Windows.Forms, Version=2.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089&quot; name=&quot;ButtonOK&quot; children=&quot;Controls&quot;&gt;&lt;Property name=&quot;TabIndex&quot;&gt;1&lt;/Property&gt;&lt;Property name=&quot;Name&quot;&gt;ButtonOK&lt;/Property&gt;&lt;Property name=&quot;Size&quot;&gt;75, 23&lt;/Property&gt;&lt;Property name=&quot;UseVisualStyleBackColor&quot;&gt;True&lt;/Property&gt;&lt;Property name=&quot;Text&quot;&gt;OK&lt;/Property&gt;&lt;Property name=&quot;UseCompatibleTextRendering&quot;&gt;True&lt;/Property&gt;&lt;Property name=&quot;Location&quot;&gt;35, 96&lt;/Property&gt;&lt;Property name=&quot;DataBindings&quot;&gt;&lt;Property name=&quot;DefaultDataSourceUpdateMode&quot;&gt;OnValidation&lt;/Property&gt;&lt;/Property&gt;&lt;Property name=&quot;DialogResult&quot;&gt;OK&lt;/Property&gt;&lt;/Object&gt;&lt;Object type=&quot;System.Windows.Forms.RadioButton, System.Windows.Forms, Version=2.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089&quot; name=&quot;btnEU&quot; children=&quot;Controls&quot;&gt;&lt;Property name=&quot;TabIndex&quot;&gt;0&lt;/Property&gt;&lt;Property name=&quot;Name&quot;&gt;btnEU&lt;/Property&gt;&lt;Property name=&quot;Size&quot;&gt;61, 24&lt;/Property&gt;&lt;Property name=&quot;UseVisualStyleBackColor&quot;&gt;True&lt;/Property&gt;&lt;Property name=&quot;Text&quot;&gt;EU&lt;/Property&gt;&lt;Property name=&quot;UseCompatibleTextRendering&quot;&gt;True&lt;/Property&gt;&lt;Property name=&quot;Location&quot;&gt;49, 52&lt;/Property&gt;&lt;Property name=&quot;DataBindings&quot;&gt;&lt;Property name=&quot;DefaultDataSourceUpdateMode&quot;&gt;OnValidation&lt;/Property&gt;&lt;/Property&gt;&lt;Property name=&quot;TabStop&quot;&gt;True&lt;/Property&gt;&lt;/Object&gt;&lt;Object type=&quot;System.Windows.Forms.RadioButton, System.Windows.Forms, Version=2.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089&quot; name=&quot;btnUS&quot; children=&quot;Controls&quot;&gt;&lt;Property name=&quot;TabIndex&quot;&gt;0&lt;/Property&gt;&lt;Property name=&quot;Name&quot;&gt;btnUS&lt;/Property&gt;&lt;Property name=&quot;Size&quot;&gt;61, 24&lt;/Property&gt;&lt;Property name=&quot;UseVisualStyleBackColor&quot;&gt;True&lt;/Property&gt;&lt;Property name=&quot;Text&quot;&gt;USA&lt;/Property&gt;&lt;Property name=&quot;UseCompatibleTextRendering&quot;&gt;True&lt;/Property&gt;&lt;Property name=&quot;Location&quot;&gt;49, 22&lt;/Property&gt;&lt;Property name=&quot;DataBindings&quot;&gt;&lt;Property name=&quot;DefaultDataSourceUpdateMode&quot;&gt;OnValidation&lt;/Property&gt;&lt;/Property&gt;&lt;Property name=&quot;TabStop&quot;&gt;True&lt;/Property&gt;&lt;/Object&gt;&lt;Property name=&quot;Text&quot;&gt;Please select location&lt;/Property&gt;&lt;Property name=&quot;Name&quot;&gt;USorEU&lt;/Property&gt;&lt;Property name=&quot;ControlBox&quot;&gt;False&lt;/Property&gt;&lt;Property name=&quot;StartPosition&quot;&gt;CenterParent&lt;/Property&gt;&lt;Property name=&quot;DataBindings&quot;&gt;&lt;Property name=&quot;DefaultDataSourceUpdateMode&quot;&gt;OnValidation&lt;/Property&gt;&lt;/Property&gt;&lt;Property name=&quot;ClientSize&quot;&gt;155, 131&lt;/Property&gt;&lt;Property name=&quot;AcceptButton&quot;&gt;&lt;Reference name=&quot;ButtonOK&quot; /&gt;&lt;/Property&gt;&lt;Event name=&quot;Load&quot;&gt;USorEU_Load&lt;/Event&gt;&lt;/Object&gt;</FormData>
				</Form>
			</Forms>
			<Events>
				<Event name="On_AuthenticUserAddedXMLNode">
					<Source>//event fired after user added a new XML node in Authentic
function On_AuthenticUserAddedXMLNode( objXMLData )
{
	if ( objXMLData != null &amp;&amp; objXMLData.Kind == spyXMLDataElement &amp;&amp; objXMLData.Name == &apos;Address&apos; )
	{
		objForm = CreateForm( &apos;USorEU&apos; );
		objForm.ShowDialog();
		if ( objForm.btnUS.Checked )
			sUSorEU = &apos;US&apos;;
		else
			sUSorEU = &apos;EU&apos;;
			
		elemAddress =
			AuthenticView.XMLDataRoot.
			GetChildElement( &quot;ScriptingSamples&quot;, 0 ).
			GetChildElement( &quot;Address&quot;, 0 );
			
		// append the new attribute value
		attrUSorEU = AuthenticView.CreateXMLNode( spyXMLDataAttr );
		attrUSorEU.Name = &apos;USorEU&apos;;
		attrUSorEU.TextValue = sUSorEU;
		elemAddress.AppendChild( attrUSorEU );
		
		// append the EU or US element which will contain address details
		elemParent = AuthenticView.CreateXMLNode( spyXMLDataElement );
		elemParent.Name = sUSorEU;
		elemAddress.AppendChild( elemParent );
	
		switch ( sUSorEU ) {
		case &apos;US&apos;:
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
			
			break;
			
		case &apos;EU&apos;:
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
			
			break;
		}
	}
}
</Source>
				</Event>
			</Events>
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
													<text fixtext="This example shows how to modify the default Authentic behavior when adding XML nodes. When starting, Authentic shows the &quot;add Address&quot; link automatically, but when user clicks on it after creating Address node Authentic cannot know what subnode to create US or EU, because this depends on what user wants it to do. To make this process smooth in On_AuthenticUserAddedXMLNode event we ask user to choose between US and EU and then create corresponding XML structure so that user only needs to populate data fields then."/>
												</children>
											</paragraph>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<template subtype="element" match="ScriptingSamples">
								<children>
									<template subtype="element" match="Address">
										<editorproperties adding="no"/>
										<children>
											<newline/>
											<condition>
												<children>
													<conditionbranch xpath="exists(*)">
														<children>
															<text fixtext="Please fill out the complete "/>
															<condition>
																<children>
																	<conditionbranch xpath="@USorEU = &apos;US&apos;">
																		<children>
																			<text fixtext="USA">
																				<styles font-weight="bold"/>
																			</text>
																		</children>
																	</conditionbranch>
																	<conditionbranch xpath="@USorEU = &apos;EU&apos;">
																		<children>
																			<text fixtext="EU">
																				<styles font-weight="bold"/>
																			</text>
																		</children>
																	</conditionbranch>
																</children>
															</condition>
															<text fixtext=" address form:"/>
														</children>
													</conditionbranch>
												</children>
											</condition>
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
												</children>
												<variables/>
											</template>
										</children>
										<variables/>
									</template>
									<newline/>
									<newline/>
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
