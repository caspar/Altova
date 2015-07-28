<?xml version="1.0" encoding="UTF-8"?>
<structure version="12" htmlmode="strict" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="UTF-8" encodingpdf="UTF-8" useimportschema="1" embed-images="1" pastemode="xml" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="ipo" uri="http://www.altova.com/IPO"/>
			<nspair prefix="n1" uri="http://www.xmlspy.com/schemas/orgchart"/>
			<nspair prefix="ts" uri="http://www.xmlspy.com/schemas/textstate"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="OrgChart.xsd" workingxmlfile="OrgChart.xml"/>
		</schemasources>
	</schemasources>
	<modules>
		<module spsfile="TextState.sps"/>
	</modules>
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
		<Project version="1" app="AuthenticView">
			<Forms>
				<Form name="JumpTo">
					<Source>//Occurs when the component is double-clicked.
function JumpTo_ListBox_DoubleClick( objSender, e_EventArgs )
{
	lastform.DialogResult = CLR.Static( &apos;System.Windows.Forms.DialogResult&apos; ).OK;
	lastform.Close();
}
</Source>
					<FormData>&lt;Object type=&quot;System.Windows.Forms.Form, System.Windows.Forms, Version=2.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089&quot; name=&quot;JumpTo&quot; children=&quot;Controls&quot;&gt;&lt;Object type=&quot;System.Windows.Forms.Button, System.Windows.Forms, Version=2.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089&quot; name=&quot;btnCancel&quot; children=&quot;Controls&quot;&gt;&lt;Property name=&quot;TabIndex&quot;&gt;1&lt;/Property&gt;&lt;Property name=&quot;Name&quot;&gt;btnCancel&lt;/Property&gt;&lt;Property name=&quot;Size&quot;&gt;75, 23&lt;/Property&gt;&lt;Property name=&quot;UseVisualStyleBackColor&quot;&gt;True&lt;/Property&gt;&lt;Property name=&quot;Text&quot;&gt;Cancel&lt;/Property&gt;&lt;Property name=&quot;UseCompatibleTextRendering&quot;&gt;True&lt;/Property&gt;&lt;Property name=&quot;Location&quot;&gt;182, 152&lt;/Property&gt;&lt;Property name=&quot;DataBindings&quot;&gt;&lt;Property name=&quot;DefaultDataSourceUpdateMode&quot;&gt;OnValidation&lt;/Property&gt;&lt;/Property&gt;&lt;Property name=&quot;DialogResult&quot;&gt;Cancel&lt;/Property&gt;&lt;Event name=&quot;Click&quot;&gt;JumpTo_Button1_Click&lt;/Event&gt;&lt;/Object&gt;&lt;Object type=&quot;System.Windows.Forms.Button, System.Windows.Forms, Version=2.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089&quot; name=&quot;btnOK&quot; children=&quot;Controls&quot;&gt;&lt;Property name=&quot;TabIndex&quot;&gt;1&lt;/Property&gt;&lt;Property name=&quot;Name&quot;&gt;btnOK&lt;/Property&gt;&lt;Property name=&quot;Size&quot;&gt;75, 23&lt;/Property&gt;&lt;Property name=&quot;UseVisualStyleBackColor&quot;&gt;True&lt;/Property&gt;&lt;Property name=&quot;Text&quot;&gt;OK&lt;/Property&gt;&lt;Property name=&quot;UseCompatibleTextRendering&quot;&gt;True&lt;/Property&gt;&lt;Property name=&quot;Location&quot;&gt;89, 152&lt;/Property&gt;&lt;Property name=&quot;DataBindings&quot;&gt;&lt;Property name=&quot;DefaultDataSourceUpdateMode&quot;&gt;OnValidation&lt;/Property&gt;&lt;/Property&gt;&lt;Property name=&quot;DialogResult&quot;&gt;OK&lt;/Property&gt;&lt;Event name=&quot;Click&quot;&gt;JumpTo_Button1_Click&lt;/Event&gt;&lt;/Object&gt;&lt;Object type=&quot;System.Windows.Forms.ListBox, System.Windows.Forms, Version=2.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089&quot; name=&quot;ListBox&quot; children=&quot;Controls&quot;&gt;&lt;Property name=&quot;FormattingEnabled&quot;&gt;True&lt;/Property&gt;&lt;Property name=&quot;Size&quot;&gt;245, 121&lt;/Property&gt;&lt;Property name=&quot;DataBindings&quot;&gt;&lt;Property name=&quot;DefaultDataSourceUpdateMode&quot;&gt;OnValidation&lt;/Property&gt;&lt;/Property&gt;&lt;Property name=&quot;Name&quot;&gt;ListBox&lt;/Property&gt;&lt;Property name=&quot;Location&quot;&gt;12, 12&lt;/Property&gt;&lt;Property name=&quot;TabIndex&quot;&gt;0&lt;/Property&gt;&lt;Event name=&quot;DoubleClick&quot;&gt;JumpTo_ListBox_DoubleClick&lt;/Event&gt;&lt;/Object&gt;&lt;Property name=&quot;Text&quot;&gt;Jump to...&lt;/Property&gt;&lt;Property name=&quot;Name&quot;&gt;JumpTo&lt;/Property&gt;&lt;Property name=&quot;StartPosition&quot;&gt;CenterParent&lt;/Property&gt;&lt;Property name=&quot;DataBindings&quot;&gt;&lt;Property name=&quot;DefaultDataSourceUpdateMode&quot;&gt;OnValidation&lt;/Property&gt;&lt;/Property&gt;&lt;Property name=&quot;ClientSize&quot;&gt;284, 195&lt;/Property&gt;&lt;Property name=&quot;AcceptButton&quot;&gt;&lt;Reference name=&quot;btnOK&quot; /&gt;&lt;/Property&gt;&lt;/Object&gt;</FormData>
				</Form>
			</Forms>
			<Macros>
				<Macro name="JumpTo">
					<Source>dlgJumpTo = CreateForm( &apos;JumpTo&apos; );
dlgJumpTo.ListBox.Items.Add( &apos;Begin&apos; );

elemOrgChart = AuthenticView.XMLDataRoot.GetChildElement( &apos;OrgChart&apos;, 0 );
if ( elemOrgChart != null )
{
	nIndex = 0;
	while ( ( elemOffice = elemOrgChart.GetChildElement( &apos;Office&apos;, nIndex ) ) != null )
	{
		elemName = elemOffice.GetChildElement( &apos;Name&apos;, 0 );
		if ( elemName != null )
		{
			dlgJumpTo.ListBox.Items.Add( &apos;  &apos; + elemName.GetTextValueXMLDecoded() );
		}
		nIndex++;
	}
}

dlgJumpTo.ListBox.Items.Add( &apos;End&apos; );
dlgJumpTo.ListBox.SetSelected( 0, true );

if ( dlgJumpTo.ShowDialog() == CLR.Static( &apos;System.Windows.Forms.DialogResult&apos; ).OK )
{
	switch( dlgJumpTo.ListBox.Text ) {
	case &apos;Begin&apos; :	AuthenticView.DocumentBegin.Select();	break;
	case &apos;End&apos; :	AuthenticView.DocumentEnd.Select();		break;
	default:
		nIndex = 0;
		while ( ( elemOffice = elemOrgChart.GetChildElement( &apos;Office&apos;, nIndex ) ) != null )
		{
			elemName = elemOffice.GetChildElement( &apos;Name&apos;, 0 );
			if (
				elemName != null &amp;&amp;
				elemName.GetTextValueXMLDecoded() == dlgJumpTo.ListBox.Text.substr( 2 ) 
			)
			{
				txtName = elemName.GetFirstChild( spyXMLDataText );
				if ( txtName != null )
				{
					newSel = AuthenticView.Selection.Clone();
					newSel.FirstXMLData = txtName;
					newSel.LastXMLData = txtName;
					newSel.Select();
				}
				break;
			}
			nIndex++;
		}
	}
}
</Source>
				</Macro>
				<Macro name="ZoomIn">
					<Source>AuthenticView.EventContext.SetVariableValue(
	&apos;Zoom&apos;,
	parseInt( AuthenticView.EventContext.GetVariableValue( &apos;Zoom&apos; ) ) + 1
);
</Source>
				</Macro>
				<Macro name="ZoomOut">
					<Source>nZoom = parseInt( AuthenticView.EventContext.GetVariableValue( &apos;Zoom&apos; ) );
if ( nZoom &gt; 1 )
{
	AuthenticView.EventContext.SetVariableValue( &apos;Zoom&apos;, nZoom - 1 );
}
</Source>
				</Macro>
				<Macro name="TypeRoadmap">
					<Source>AuthenticView.EventContext.SetVariableValue( &apos;MapType&apos;, &apos;roadmap&apos; );</Source>
				</Macro>
				<Macro name="TypeSatellite">
					<Source>AuthenticView.EventContext.SetVariableValue( &apos;MapType&apos;, &apos;satellite&apos; );</Source>
				</Macro>
				<Macro name="TypeHybrid">
					<Source>AuthenticView.EventContext.SetVariableValue( &apos;MapType&apos;, &apos;hybrid&apos; );</Source>
				</Macro>
				<Macro name="MapBigger">
					<Source>AuthenticView.EventContext.SetVariableValue(
	&apos;MapWidth&apos;,
	parseInt( AuthenticView.EventContext.GetVariableValue( &apos;MapWidth&apos; ) ) + 100
);
</Source>
				</Macro>
				<Macro name="MapSmaller">
					<Source>nWidth = parseInt( AuthenticView.EventContext.GetVariableValue( &apos;MapWidth&apos; ) );
if ( nWidth &gt; 300 )
{
	AuthenticView.EventContext.SetVariableValue( &apos;MapWidth&apos;, nWidth - 100 );
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
				<children>
					<documentsection>
						<properties columncount="1" columngap="0.50in" headerfooterheight="variable" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="1" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.0in" papermarginheader="0.0in" papermarginleft="0.6in" papermarginright="0.6in" papermargintop="0.79in" paperwidth="8.5in"/>
					</documentsection>
					<template subtype="source" match="XML">
						<children>
							<template subtype="element" match="n1:OrgChart">
								<children>
									<template subtype="element" match="n1:CompanyLogo">
										<editorproperties autoaddname="1" editable="1" adding="mandatory" markupmode="hide"/>
										<children>
											<paragraph>
												<styles border-bottom-color="#0588BA" border-bottom-style="solid" border-bottom-width="medium" border-width="4pt" padding-bottom="10px" padding-left="10px"/>
												<children>
													<template subtype="attribute" match="href">
														<editorproperties autoaddname="1" editable="1" markupmode="hide"/>
														<children>
															<link>
																<children>
																	<image>
																		<properties border="0"/>
																		<styles height="76px" width="153px"/>
																		<target>
																			<xpath value="."/>
																		</target>
																		<imagesource>
																			<xpath value="."/>
																		</imagesource>
																	</image>
																</children>
																<action>
																	<none/>
																</action>
																<hyperlink>
																	<fixtext value="http://www.nanonull.com/"/>
																</hyperlink>
															</link>
														</children>
														<variables/>
													</template>
												</children>
											</paragraph>
										</children>
										<variables/>
									</template>
									<newline/>
									<tgrid>
										<properties border="0" cellpadding="0" cellspacing="0" width="100%"/>
										<children>
											<tgridbody-cols>
												<children>
													<tgridcol>
														<properties width="40%"/>
													</tgridcol>
													<tgridcol>
														<properties width="60%"/>
													</tgridcol>
												</children>
											</tgridbody-cols>
											<tgridbody-rows>
												<children>
													<tgridrow>
														<children>
															<tgridcell>
																<properties valign="top"/>
																<children>
																	<template subtype="element" match="n1:Name">
																		<children>
																			<content>
																				<styles color="#0588BA" font-family="Arial" font-size="20pt" font-weight="bold"/>
																				<format basic-type="xsd" datatype="string"/>
																			</content>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridcell>
															<tgridcell>
																<styles text-align="right"/>
																<children>
																	<chart>
																		<styles height="200px" width="400px"/>
																		<dataset/>
																		<dataseries-xny-rows for-each="distinct-values(n1:Office/n1:Department/n1:Name)" x-value="." auto-x-value="0">
																			<col y-value="for $i in . return count($XML//n1:Department[n1:Name=$i]/n1:Person)" y-name="&quot;Series 1&quot;"/>
																		</dataseries-xny-rows>
																		<wizard-data remove-empty-cat="1" remove-empty-ser="1">
																			<wizard-data-categories/>
																			<wizard-data-series/>
																		</wizard-data>
																		<chartsettings>
																			<General SettingsVersion="1" ChartKind="Pie3d" Title="Overall workforce split" ShowLegend="0"/>
																			<Pie AddPercentToLabels="1"/>
																		</chartsettings>
																		<chartsettings-xpath>
																			<main-properties/>
																			<color-properties/>
																			<colorrange-properties/>
																		</chartsettings-xpath>
																	</chart>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<properties valign="bottom"/>
																<children>
																	<newline/>
																	<text fixtext="Quick Finder">
																		<styles font-family="Arial" font-size="14pt" font-weight="bold"/>
																	</text>
																	<newline/>
																</children>
															</tgridcell>
															<tgridcell joinabove="1">
																<styles text-align="right"/>
															</tgridcell>
														</children>
													</tgridrow>
												</children>
											</tgridbody-rows>
										</children>
									</tgrid>
									<toc name="toc">
										<children>
											<reflevel>
												<children>
													<newline/>
													<ref name="toc" createhyperlink="1">
														<children>
															<field type="ref-entrytext">
																<styles font-family="Arial" font-size="12pt" font-weight="bold"/>
															</field>
														</children>
													</ref>
													<newline/>
													<tgrid>
														<properties cellspacing="0" width="100%"/>
														<styles margin-top="2pt"/>
														<children>
															<tgridbody-cols>
																<children>
																	<tgridcol>
																		<properties width="50%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="50%"/>
																	</tgridcol>
																</children>
															</tgridbody-cols>
															<tgridbody-rows>
																<children>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<children>
																					<text fixtext="Departments">
																						<styles font-size="10pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<children>
																					<text fixtext="Persons">
																						<styles font-size="10pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																</children>
															</tgridbody-rows>
														</children>
													</tgrid>
													<reflevel>
														<children>
															<tgrid>
																<properties cellspacing="0" width="100%"/>
																<styles line-height="12pt"/>
																<children>
																	<tgridbody-cols>
																		<children>
																			<tgridcol>
																				<properties width="50%"/>
																			</tgridcol>
																			<tgridcol>
																				<properties width="50%"/>
																			</tgridcol>
																		</children>
																	</tgridbody-cols>
																	<tgridbody-rows>
																		<children>
																			<tgridrow>
																				<properties _xbgcolor="if ( position() mod 2 ) then &quot;antiquewhite&quot; else &quot;navajowhite&quot;"/>
																				<children>
																					<tgridcell>
																						<properties valign="top"/>
																						<children>
																							<ref name="toc" createhyperlink="1">
																								<children>
																									<num-lvl format="A.1" omitlevels="1">
																										<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																									</num-lvl>
																									<text fixtext=". ">
																										<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																									</text>
																									<field type="ref-entrytext">
																										<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
																									</field>
																								</children>
																							</ref>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<properties valign="top"/>
																						<children>
																							<reflevel>
																								<children>
																									<tgrid>
																										<properties cellpadding="0" cellspacing="0"/>
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
																																<properties valign="top"/>
																																<children>
																																	<ref name="toc" createhyperlink="1">
																																		<children>
																																			<num-lvl format="A.1" omitlevels="1">
																																				<styles font-family="Arial" font-size="8pt"/>
																																			</num-lvl>
																																			<text fixtext=" ">
																																				<styles font-family="Arial" font-size="8pt"/>
																																			</text>
																																			<field type="ref-entrytext">
																																				<styles font-family="Arial" font-size="8pt"/>
																																			</field>
																																		</children>
																																	</ref>
																																</children>
																															</tgridcell>
																														</children>
																													</tgridrow>
																												</children>
																											</tgridbody-rows>
																										</children>
																									</tgrid>
																								</children>
																							</reflevel>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																		</children>
																	</tgridbody-rows>
																</children>
															</tgrid>
														</children>
													</reflevel>
												</children>
											</reflevel>
										</children>
									</toc>
									<template subtype="element" levelflag="1" match="n1:Office">
										<editorproperties adding="no"/>
										<children>
											<condition>
												<children>
													<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos;">
														<children>
															<paragraph>
																<styles border-top-color="#0588ba" border-top-style="solid" border-top-width="2pt"/>
																<children>
																	<newline/>
																	<marker xpath="." name="toc">
																		<children>
																			<template subtype="element" match="n1:Name">
																				<editorproperties adding="no"/>
																				<children>
																					<content>
																						<styles color="#707070" font-family="Arial" font-size="15pt" font-weight="bold"/>
																						<format basic-type="xsd" datatype="string"/>
																					</content>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</marker>
																	<newline/>
																	<newline/>
																	<text fixtext="Location: ">
																		<styles color="#808080" font-family="Arial" font-size="small" font-weight="bold"/>
																	</text>
																	<condition>
																		<children>
																			<conditionbranch xpath="not(n1:Address or  n1:Address_EU)">
																				<children>
																					<template subtype="element" match="n1:Location">
																						<editorproperties autoaddname="1" editable="1" adding="no" markupmode="hide"/>
																						<children>
																							<combobox>
																								<children>
																									<content>
																										<format basic-type="xsd" datatype="string"/>
																									</content>
																								</children>
																								<selectoption description="US" value="US"/>
																								<selectoption description="EU" value="EU"/>
																							</combobox>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</conditionbranch>
																			<conditionbranch>
																				<children>
																					<template subtype="element" match="n1:Location">
																						<editorproperties autoaddname="1" editable="0" adding="no" markupmode="hide"/>
																						<children>
																							<content>
																								<styles color="#808080" font-weight="bold"/>
																								<format basic-type="xsd" datatype="string"/>
																							</content>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																</children>
															</paragraph>
														</children>
													</conditionbranch>
													<conditionbranch xpath="$SV_OutputFormat = &apos;HTML&apos;">
														<children>
															<paragraph>
																<styles border-top-color="#0588ba" border-top-style="solid" border-top-width="2pt"/>
																<children>
																	<newline/>
																	<marker xpath="." name="toc">
																		<children>
																			<template subtype="element" match="n1:Name">
																				<editorproperties adding="no"/>
																				<children>
																					<content>
																						<styles color="#707070" font-family="Arial" font-size="15pt" font-weight="bold"/>
																						<format basic-type="xsd" datatype="string"/>
																					</content>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</marker>
																	<newline/>
																	<newline/>
																	<text fixtext="Location: ">
																		<styles color="#808080" font-family="Arial" font-size="small" font-weight="bold"/>
																	</text>
																	<condition>
																		<children>
																			<conditionbranch xpath="not(n1:Address or  n1:Address_EU)">
																				<children>
																					<template subtype="element" match="n1:Location">
																						<editorproperties autoaddname="1" editable="1" adding="no" markupmode="hide"/>
																						<children>
																							<combobox>
																								<children>
																									<content>
																										<format basic-type="xsd" datatype="string"/>
																									</content>
																								</children>
																								<selectoption description="US" value="US"/>
																								<selectoption description="EU" value="EU"/>
																							</combobox>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</conditionbranch>
																			<conditionbranch>
																				<children>
																					<template subtype="element" match="n1:Location">
																						<editorproperties autoaddname="1" editable="0" adding="no" markupmode="hide"/>
																						<children>
																							<content>
																								<styles color="#808080" font-weight="bold"/>
																								<format basic-type="xsd" datatype="string"/>
																							</content>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																</children>
															</paragraph>
														</children>
													</conditionbranch>
													<conditionbranch xpath="$SV_OutputFormat = &apos;RTF&apos; or $SV_OutputFormat = &apos;Word2007&apos;">
														<children>
															<newline break="page"/>
															<paragraph>
																<children>
																	<newline/>
																	<marker xpath="." name="toc">
																		<children>
																			<template subtype="element" match="n1:Name">
																				<editorproperties adding="no"/>
																				<children>
																					<content>
																						<styles color="#707070" font-family="Arial" font-size="15pt" font-weight="bold"/>
																						<format basic-type="xsd" datatype="string"/>
																					</content>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</marker>
																	<newline/>
																	<newline/>
																	<text fixtext="Location: ">
																		<styles color="#808080" font-family="Arial" font-size="small" font-weight="bold"/>
																	</text>
																	<condition>
																		<children>
																			<conditionbranch xpath="not(n1:Address or  n1:Address_EU)">
																				<children>
																					<template subtype="element" match="n1:Location">
																						<editorproperties autoaddname="1" editable="1" adding="no" markupmode="hide"/>
																						<children>
																							<combobox>
																								<children>
																									<content>
																										<format basic-type="xsd" datatype="string"/>
																									</content>
																								</children>
																								<selectoption description="US" value="US"/>
																								<selectoption description="EU" value="EU"/>
																							</combobox>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</conditionbranch>
																			<conditionbranch>
																				<children>
																					<template subtype="element" match="n1:Location">
																						<editorproperties autoaddname="1" editable="0" adding="no" markupmode="hide"/>
																						<children>
																							<content>
																								<styles color="#808080" font-weight="bold"/>
																								<format basic-type="xsd" datatype="string"/>
																							</content>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																</children>
															</paragraph>
														</children>
													</conditionbranch>
													<conditionbranch xpath="$SV_OutputFormat = &apos;PDF&apos;">
														<children>
															<paragraph>
																<children>
																	<newline/>
																	<marker xpath="." name="toc">
																		<children>
																			<template subtype="element" match="n1:Name">
																				<editorproperties adding="no"/>
																				<children>
																					<content>
																						<styles color="#707070" font-family="Arial" font-size="15pt" font-weight="bold"/>
																						<format basic-type="xsd" datatype="string"/>
																					</content>
																				</children>
																				<variables/>
																			</template>
																		</children>
																	</marker>
																	<newline/>
																	<newline/>
																	<text fixtext="Location: ">
																		<styles color="#808080" font-family="Arial" font-size="small" font-weight="bold"/>
																	</text>
																	<condition>
																		<children>
																			<conditionbranch xpath="not(n1:Address or  n1:Address_EU)">
																				<children>
																					<template subtype="element" match="n1:Location">
																						<editorproperties autoaddname="1" editable="1" adding="no" markupmode="hide"/>
																						<children>
																							<combobox>
																								<children>
																									<content>
																										<format basic-type="xsd" datatype="string"/>
																									</content>
																								</children>
																								<selectoption description="US" value="US"/>
																								<selectoption description="EU" value="EU"/>
																							</combobox>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</conditionbranch>
																			<conditionbranch>
																				<children>
																					<template subtype="element" match="n1:Location">
																						<editorproperties autoaddname="1" editable="0" adding="no" markupmode="hide"/>
																						<children>
																							<content>
																								<styles color="#808080" font-weight="bold"/>
																								<format basic-type="xsd" datatype="string"/>
																							</content>
																						</children>
																						<variables/>
																					</template>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																</children>
															</paragraph>
														</children>
													</conditionbranch>
												</children>
											</condition>
											<tgrid>
												<properties border="1" cellspacing="0"/>
												<styles width="100%"/>
												<children>
													<tgridbody-cols>
														<children>
															<tgridcol>
																<properties width="300px"/>
																<styles width="35%"/>
															</tgridcol>
															<tgridcol>
																<styles width="65%"/>
															</tgridcol>
														</children>
													</tgridbody-cols>
													<tgridbody-rows>
														<children>
															<tgridrow>
																<children>
																	<tgridcell>
																		<properties valign="middle"/>
																		<children>
																			<condition>
																				<children>
																					<conditionbranch xpath="n1:Location =&quot;US&quot;">
																						<children>
																							<template subtype="element" match="n1:Address">
																								<editorproperties adding="no"/>
																								<children>
																									<tgrid>
																										<properties border="0" cellspacing="4px" width="100%"/>
																										<styles width="100%"/>
																										<children>
																											<tgridbody-cols>
																												<children>
																													<tgridcol>
																														<properties width="30%"/>
																													</tgridcol>
																													<tgridcol>
																														<properties width="70%"/>
																													</tgridcol>
																												</children>
																											</tgridbody-cols>
																											<tgridbody-rows>
																												<children>
																													<tgridrow>
																														<children>
																															<tgridcell>
																																<children>
																																	<text fixtext="Street: ">
																																		<styles font-weight="bold"/>
																																	</text>
																																</children>
																															</tgridcell>
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="ipo:street">
																																		<editorproperties adding="no"/>
																																		<children>
																																			<content>
																																				<format basic-type="xsd" datatype="string"/>
																																			</content>
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
																																	<text fixtext="City:">
																																		<styles font-weight="bold"/>
																																	</text>
																																</children>
																															</tgridcell>
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="ipo:city">
																																		<editorproperties adding="no"/>
																																		<children>
																																			<content>
																																				<format basic-type="xsd" datatype="string"/>
																																			</content>
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
																																	<text fixtext="State &amp; Zip:">
																																		<styles font-weight="bold"/>
																																	</text>
																																</children>
																															</tgridcell>
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="ipo:state">
																																		<editorproperties adding="no"/>
																																		<children>
																																			<combobox enumeration="1">
																																				<children>
																																					<content>
																																						<format basic-type="xsd" datatype="string"/>
																																					</content>
																																				</children>
																																			</combobox>
																																		</children>
																																		<variables/>
																																	</template>
																																	<text fixtext=" "/>
																																	<template subtype="element" match="ipo:zip">
																																		<editorproperties adding="no"/>
																																		<children>
																																			<editfield>
																																				<styles width="0.70in"/>
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
																						</children>
																					</conditionbranch>
																					<conditionbranch xpath="n1:Location =&quot;EU&quot;">
																						<children>
																							<template subtype="element" match="n1:Address_EU">
																								<editorproperties adding="no"/>
																								<children>
																									<tgrid>
																										<properties border="0" cellspacing="4px" width="100%"/>
																										<styles width="100%"/>
																										<children>
																											<tgridbody-cols>
																												<children>
																													<tgridcol>
																														<properties width="30%"/>
																													</tgridcol>
																													<tgridcol>
																														<properties width="70%"/>
																													</tgridcol>
																												</children>
																											</tgridbody-cols>
																											<tgridbody-rows>
																												<children>
																													<tgridrow>
																														<children>
																															<tgridcell>
																																<children>
																																	<text fixtext="Street:">
																																		<styles font-weight="bold"/>
																																	</text>
																																</children>
																															</tgridcell>
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="ipo:street">
																																		<editorproperties adding="no"/>
																																		<children>
																																			<editfield>
																																				<styles width="1.50in"/>
																																				<children>
																																					<content>
																																						<format basic-type="xsd" datatype="string"/>
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
																													<tgridrow>
																														<children>
																															<tgridcell>
																																<children>
																																	<text fixtext="City:">
																																		<styles font-weight="bold"/>
																																	</text>
																																</children>
																															</tgridcell>
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="ipo:city">
																																		<editorproperties adding="no"/>
																																		<children>
																																			<editfield>
																																				<styles width="1.50in"/>
																																				<children>
																																					<content>
																																						<format basic-type="xsd" datatype="string"/>
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
																													<tgridrow>
																														<children>
																															<tgridcell>
																																<children>
																																	<text fixtext="Post Code:">
																																		<styles font-weight="bold"/>
																																	</text>
																																</children>
																															</tgridcell>
																															<tgridcell>
																																<children>
																																	<template subtype="element" match="ipo:postcode">
																																		<editorproperties adding="no"/>
																																		<children>
																																			<editfield>
																																				<styles width="1.50in"/>
																																				<children>
																																					<content>
																																						<format basic-type="xsd" datatype="string"/>
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
																						</children>
																					</conditionbranch>
																				</children>
																			</condition>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<properties valign="top"/>
																		<children>
																			<condition>
																				<children>
																					<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos;">
																						<children>
																							<tgrid>
																								<properties border="0" width="100%"/>
																								<styles width="100%"/>
																								<children>
																									<tgridbody-cols>
																										<children>
																											<tgridcol>
																												<properties width="100px"/>
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
																															<image imagealt="Google Maps">
																																<properties _xwidth="$MapWidth" height="300"/>
																																<target>
																																	<xpath value="iri-to-uri(for $full_addr in  if ( n1:Location =&quot;US&quot; )
then concat( n1:Address/ipo:street, &apos;,&apos;, n1:Address/ipo:city, &apos;,&apos; , n1:Address/ipo:state, &apos;,&apos;, n1:Address/ipo:zip )
else concat( n1:Address_EU/ipo:street, &apos;,&apos;, n1:Address_EU/ipo:city, &apos;,&apos; , n1:Address_EU/ipo:postcode )
return
  concat( &apos;http://maps.google.com/maps/api/staticmap?center=&apos;, $full_addr,
  &apos;&amp;zoom=&apos;, $Zoom, &apos;&amp;maptype=&apos;, $MapType,
  &apos;&amp;size=&apos;, $MapWidth, &apos;x300&amp;sensor=false&amp;markers=color:red|&apos;, $full_addr))"/>
																																</target>
																																<imagesource>
																																	<xpath value="iri-to-uri(for $full_addr in  if ( n1:Location =&quot;US&quot; )
then concat( n1:Address/ipo:street, &apos;,&apos;, n1:Address/ipo:city, &apos;,&apos; , n1:Address/ipo:state, &apos;,&apos;, n1:Address/ipo:zip )
else concat( n1:Address_EU/ipo:street, &apos;,&apos;, n1:Address_EU/ipo:city, &apos;,&apos; , n1:Address_EU/ipo:postcode )
return
  concat( &apos;http://maps.google.com/maps/api/staticmap?center=&apos;, $full_addr,
  &apos;&amp;zoom=&apos;, $Zoom, &apos;&amp;maptype=&apos;, $MapType,
  &apos;&amp;size=&apos;, $MapWidth, &apos;x300&amp;sensor=false&amp;markers=color:red|&apos;, $full_addr))"/>
																																</imagesource>
																															</image>
																														</children>
																													</tgridcell>
																													<tgridcell>
																														<properties valign="top"/>
																														<children>
																															<button>
																																<styles width="0.75in"/>
																																<children>
																																	<text fixtext="Zoom In">
																																		<styles font-size="smaller"/>
																																	</text>
																																</children>
																																<action>
																																	<none/>
																																</action>
																																<authentic-event-handlers OnClick="ZoomIn"/>
																															</button>
																															<newline/>
																															<button>
																																<styles width="0.75in"/>
																																<children>
																																	<text fixtext="Zoom Out">
																																		<styles font-size="smaller"/>
																																	</text>
																																</children>
																																<action>
																																	<none/>
																																</action>
																																<authentic-event-handlers OnClick="ZoomOut"/>
																															</button>
																															<newline/>
																															<newline/>
																															<button>
																																<styles width="0.75in"/>
																																<children>
																																	<text fixtext="Roadmap">
																																		<styles font-size="smaller"/>
																																	</text>
																																</children>
																																<action>
																																	<none/>
																																</action>
																																<authentic-event-handlers OnClick="TypeRoadmap"/>
																															</button>
																															<newline/>
																															<button>
																																<styles width="0.75in"/>
																																<children>
																																	<text fixtext="Satellite">
																																		<styles font-size="smaller"/>
																																	</text>
																																</children>
																																<action>
																																	<none/>
																																</action>
																																<authentic-event-handlers OnClick="TypeSatellite"/>
																															</button>
																															<newline/>
																															<button>
																																<styles width="0.75in"/>
																																<children>
																																	<text fixtext="Hybrid">
																																		<styles font-size="smaller"/>
																																	</text>
																																</children>
																																<action>
																																	<none/>
																																</action>
																																<authentic-event-handlers OnClick="TypeHybrid"/>
																															</button>
																															<newline/>
																															<newline/>
																															<button>
																																<styles width="0.75in"/>
																																<children>
																																	<text fixtext="Bigger =&gt;">
																																		<styles font-size="smaller"/>
																																	</text>
																																</children>
																																<action>
																																	<none/>
																																</action>
																																<authentic-event-handlers OnClick="MapBigger"/>
																															</button>
																															<newline/>
																															<button>
																																<styles width="0.75in"/>
																																<children>
																																	<text fixtext="Smaller &lt;=">
																																		<styles font-size="smaller"/>
																																	</text>
																																</children>
																																<action>
																																	<none/>
																																</action>
																																<authentic-event-handlers OnClick="MapSmaller"/>
																															</button>
																															<newline/>
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
																					<conditionbranch>
																						<children>
																							<image imagealt="Google Maps">
																								<properties _xwidth="if ($SV_OutputFormat eq &apos;RTF&apos; or $SV_OutputFormat eq &apos;Word2007&apos;) then 400 else 300" height="300"/>
																								<target>
																									<xpath value="iri-to-uri(for $full_addr in  if ( n1:Location =&quot;US&quot; )
then concat( n1:Address/ipo:street, &apos;,&apos;, n1:Address/ipo:city, &apos;,&apos; , n1:Address/ipo:state, &apos;,&apos;, n1:Address/ipo:zip )
else concat( n1:Address_EU/ipo:street, &apos;,&apos;, n1:Address_EU/ipo:city, &apos;,&apos; , n1:Address_EU/ipo:postcode )
return
  concat( &apos;http://maps.google.com/maps/api/staticmap?center=&apos;, $full_addr,
  &apos;&amp;zoom=&apos;, $Zoom, &apos;&amp;maptype=&apos;, $MapType,
  &apos;&amp;size=&apos;, if ($SV_OutputFormat eq &apos;RTF&apos; or $SV_OutputFormat eq &apos;Word2007&apos;) then &apos;400&apos; else &apos;300&apos;, &apos;x300&amp;sensor=false&amp;markers=color:red|&apos;, $full_addr))"/>
																								</target>
																								<imagesource>
																									<xpath value="iri-to-uri(for $full_addr in  if ( n1:Location =&quot;US&quot; )
then concat( n1:Address/ipo:street, &apos;,&apos;, n1:Address/ipo:city, &apos;,&apos; , n1:Address/ipo:state, &apos;,&apos;, n1:Address/ipo:zip )
else concat( n1:Address_EU/ipo:street, &apos;,&apos;, n1:Address_EU/ipo:city, &apos;,&apos; , n1:Address_EU/ipo:postcode )
return
  concat( &apos;http://maps.google.com/maps/api/staticmap?center=&apos;, $full_addr,
  &apos;&amp;zoom=&apos;, $Zoom, &apos;&amp;maptype=&apos;, $MapType,
  &apos;&amp;size=&apos;, if ($SV_OutputFormat eq &apos;RTF&apos; or $SV_OutputFormat eq &apos;Word2007&apos;) then &apos;400&apos; else &apos;300&apos;, &apos;x300&amp;sensor=false&amp;markers=color:red|&apos;, $full_addr))"/>
																								</imagesource>
																							</image>
																						</children>
																					</conditionbranch>
																				</children>
																			</condition>
																		</children>
																	</tgridcell>
																</children>
															</tgridrow>
															<tgridrow>
																<children>
																	<tgridcell>
																		<properties valign="middle"/>
																		<children>
																			<tgrid>
																				<properties border="0" cellspacing="4" width="100%"/>
																				<styles width="100%"/>
																				<children>
																					<tgridbody-cols>
																						<children>
																							<tgridcol>
																								<properties width="30%"/>
																							</tgridcol>
																							<tgridcol>
																								<properties width="70%"/>
																							</tgridcol>
																						</children>
																					</tgridbody-cols>
																					<tgridbody-rows>
																						<children>
																							<tgridrow>
																								<children>
																									<tgridcell>
																										<children>
																											<text fixtext="Phone:">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="n1:Phone">
																												<editorproperties adding="no"/>
																												<children>
																													<content>
																														<format basic-type="xsd" datatype="string"/>
																													</content>
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
																											<text fixtext="Fax:">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="n1:Fax">
																												<editorproperties autoaddname="1" editable="1" adding="no"/>
																												<children>
																													<content>
																														<editorproperties editable="1"/>
																														<format basic-type="xsd" datatype="string"/>
																													</content>
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
																											<text fixtext="E-mail:">
																												<styles font-weight="bold"/>
																											</text>
																										</children>
																									</tgridcell>
																									<tgridcell>
																										<children>
																											<template subtype="element" match="n1:EMail">
																												<editorproperties adding="no"/>
																												<children>
																													<link>
																														<children>
																															<content>
																																<format basic-type="xsd" datatype="string"/>
																															</content>
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
																									</tgridcell>
																								</children>
																							</tgridrow>
																						</children>
																					</tgridbody-rows>
																				</children>
																			</tgrid>
																		</children>
																	</tgridcell>
																	<tgridcell joinabove="1"/>
																</children>
															</tgridrow>
														</children>
													</tgridbody-rows>
												</children>
											</tgrid>
											<newline/>
											<condition>
												<children>
													<conditionbranch xpath="n1:Address">
														<children>
															<template subtype="element" match="n1:Address">
																<editorproperties adding="no"/>
																<children>
																	<template subtype="element" match="ipo:city">
																		<editorproperties autoaddname="1" editable="0" adding="no" markupmode="hide"/>
																		<children>
																			<content>
																				<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
																				<format basic-type="xsd" datatype="string"/>
																			</content>
																		</children>
																		<variables/>
																	</template>
																</children>
																<variables/>
															</template>
														</children>
													</conditionbranch>
													<conditionbranch xpath="n1:Address_EU">
														<children>
															<template subtype="element" match="n1:Address_EU">
																<editorproperties adding="no"/>
																<children>
																	<template subtype="element" match="ipo:city">
																		<editorproperties autoaddname="1" editable="0" adding="no" markupmode="hide"/>
																		<children>
																			<content>
																				<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
																				<format basic-type="xsd" datatype="string"/>
																			</content>
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
											<text fixtext=" Office Summary:">
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
											</text>
											<text fixtext="  "/>
											<autocalc xpath="count(n1:Department)">
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
											</autocalc>
											<text fixtext=" department">
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
											</text>
											<condition>
												<children>
													<conditionbranch xpath="count(n1:Department) != 1">
														<children>
															<text fixtext="s">
																<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
															</text>
														</children>
													</conditionbranch>
												</children>
											</condition>
											<text fixtext=", ">
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
											</text>
											<autocalc xpath="count(n1:Department/n1:Person)">
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
											</autocalc>
											<text fixtext=" employee">
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
											</text>
											<condition>
												<children>
													<conditionbranch xpath="count(n1:Department/n1:Person) != 1">
														<children>
															<text fixtext="s">
																<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
															</text>
														</children>
													</conditionbranch>
												</children>
											</condition>
											<text fixtext=".">
												<styles color="#004080" font-family="Arial" font-size="10pt" font-weight="bold"/>
											</text>
											<template subtype="element" match="n1:Desc">
												<editorproperties adding="no"/>
												<children>
													<template subtype="element" match="n1:para">
														<editorproperties adding="no"/>
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
												<variables/>
											</template>
											<template subtype="element" levelflag="1" match="n1:Department">
												<editorproperties adding="no"/>
												<children>
													<marker xpath="." name="toc">
														<children>
															<template subtype="element" match="n1:Name">
																<editorproperties adding="no"/>
																<children>
																	<content>
																		<styles color="#D39658" font-family="Arial" font-weight="bold"/>
																		<format basic-type="xsd" datatype="string"/>
																	</content>
																</children>
																<variables/>
															</template>
														</children>
													</marker>
													<text fixtext=" "/>
													<text fixtext="( ">
														<styles color="#D39658" font-family="Arial" font-weight="bold"/>
													</text>
													<autocalc xpath="count(n1:Person)">
														<styles color="#D39658" font-family="Arial" font-weight="bold"/>
													</autocalc>
													<text fixtext=" )">
														<styles color="#D39658" font-family="Arial" font-weight="bold"/>
													</text>
													<newline/>
													<tgrid>
														<properties border="1" cellpadding="3" cellspacing="0" width="100%"/>
														<children>
															<tgridbody-cols>
																<children>
																	<tgridcol>
																		<properties width="10%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="12%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="16%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="5%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="23%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="10%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="8%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="8%"/>
																	</tgridcol>
																	<tgridcol>
																		<properties width="8%"/>
																	</tgridcol>
																</children>
															</tgridbody-cols>
															<tgridheader-rows>
																<children>
																	<tgridrow>
																		<properties bgcolor="#D2C8AE"/>
																		<children>
																			<tgridcell>
																				<properties align="center" bgcolor="#D2C8AE"/>
																				<children>
																					<text fixtext="First">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="center" bgcolor="#D2C8AE"/>
																				<children>
																					<text fixtext="Last">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="center" bgcolor="#D2C8AE"/>
																				<children>
																					<text fixtext="Title">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																					<newline/>
																					<condition>
																						<children>
																							<conditionbranch xpath="$SV_OutputFormat = &apos;Authentic&apos;"/>
																							<conditionbranch xpath="$SV_OutputFormat = &apos;HTML&apos;">
																								<children>
																									<text fixtext="(sorted by)">
																										<styles color="#606060" font-family="Arial" font-size="x-small" font-weight="bold"/>
																									</text>
																								</children>
																							</conditionbranch>
																							<conditionbranch xpath="$SV_OutputFormat = &apos;RTF&apos; or $SV_OutputFormat = &apos;Word2007&apos;">
																								<children>
																									<text fixtext="(sorted by)">
																										<styles color="#606060" font-family="Arial" font-size="x-small" font-weight="bold"/>
																									</text>
																								</children>
																							</conditionbranch>
																							<conditionbranch xpath="$SV_OutputFormat = &apos;PDF&apos;">
																								<children>
																									<text fixtext="(sorted by)">
																										<styles color="#606060" font-family="Arial" font-size="x-small" font-weight="bold"/>
																									</text>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="center" bgcolor="#D2C8AE"/>
																				<children>
																					<text fixtext="Ext">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="center" bgcolor="#D2C8AE"/>
																				<children>
																					<text fixtext="EMail">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="center" bgcolor="#D2C8AE"/>
																				<children>
																					<text fixtext="Shares">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="center"/>
																				<children>
																					<text fixtext="Leave">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="center"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="center"/>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell joinabove="1">
																				<properties align="center" bgcolor="#D2C8AE"/>
																			</tgridcell>
																			<tgridcell joinabove="1">
																				<properties align="center" bgcolor="#D2C8AE"/>
																			</tgridcell>
																			<tgridcell joinabove="1">
																				<properties align="center" bgcolor="#D2C8AE"/>
																			</tgridcell>
																			<tgridcell joinabove="1">
																				<properties align="center" bgcolor="#D2C8AE"/>
																			</tgridcell>
																			<tgridcell joinabove="1">
																				<properties align="center" bgcolor="#D2C8AE"/>
																			</tgridcell>
																			<tgridcell joinabove="1">
																				<properties align="center" bgcolor="#D2C8AE"/>
																			</tgridcell>
																			<tgridcell>
																				<properties align="center" bgcolor="#D2C8AE"/>
																				<children>
																					<text fixtext="Total">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="center" bgcolor="#D2C8AE"/>
																				<children>
																					<text fixtext="Used">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<properties align="center" bgcolor="#D2C8AE"/>
																				<children>
																					<text fixtext="Left">
																						<styles color="#606060" font-family="Arial" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																</children>
															</tgridheader-rows>
															<tgridbody-rows>
																<children>
																	<template subtype="element" levelflag="1" match="n1:Person">
																		<sort>
																			<key match="n1:Title"/>
																		</sort>
																		<editorproperties adding="mandatory"/>
																		<children>
																			<tgridrow>
																				<properties _xbgcolor="if ( position() mod 2 ) then &quot;antiquewhite&quot; else &quot;navajowhite&quot;"/>
																				<children>
																					<tgridcell>
																						<children>
																							<marker xpath="concat(n1:Last,&apos; &apos;,n1:First)" name="toc" uses="xpath"/>
																							<template subtype="element" match="n1:First">
																								<editorproperties adding="mandatory"/>
																								<children>
																									<condition>
																										<children>
																											<conditionbranch xpath="../n1:Shares &gt; 0">
																												<children>
																													<content>
																														<styles font-size="10pt" font-weight="bold"/>
																													</content>
																												</children>
																											</conditionbranch>
																											<conditionbranch>
																												<children>
																													<content>
																														<styles font-size="10pt"/>
																													</content>
																												</children>
																											</conditionbranch>
																										</children>
																									</condition>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="n1:Last">
																								<editorproperties adding="mandatory"/>
																								<children>
																									<condition>
																										<children>
																											<conditionbranch xpath="../n1:Shares &gt; 0">
																												<children>
																													<content>
																														<styles font-size="10pt" font-weight="bold"/>
																														<format basic-type="xsd" datatype="string"/>
																													</content>
																												</children>
																											</conditionbranch>
																											<conditionbranch>
																												<children>
																													<content>
																														<styles font-size="10pt"/>
																														<format basic-type="xsd" datatype="string"/>
																													</content>
																												</children>
																											</conditionbranch>
																										</children>
																									</condition>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="n1:Title">
																								<editorproperties autoaddname="1" editable="1" adding="mandatory"/>
																								<children>
																									<content>
																										<styles font-size="10pt"/>
																										<format basic-type="xsd" datatype="string"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<properties align="center"/>
																						<children>
																							<template subtype="element" match="n1:PhoneExt">
																								<editorproperties adding="mandatory"/>
																								<children>
																									<content>
																										<editorproperties editable="1"/>
																										<styles font-size="10pt"/>
																										<addvalidations>
																											<addvalidation usermsg="Telephone extensions must be 3 digits long." xpath="string-length(string(.) ) = 3"/>
																										</addvalidations>
																										<format basic-type="xsd" datatype="int"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<children>
																							<template subtype="element" match="n1:EMail">
																								<editorproperties adding="mandatory"/>
																								<children>
																									<link>
																										<children>
																											<content>
																												<styles font-size="10pt"/>
																												<format basic-type="xsd" datatype="string"/>
																											</content>
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
																					</tgridcell>
																					<tgridcell>
																						<properties align="center"/>
																						<children>
																							<template subtype="element" match="n1:Shares">
																								<editorproperties adding="mandatory"/>
																								<children>
																									<content>
																										<styles font-size="10pt"/>
																										<format basic-type="xsd" datatype="integer"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<properties align="center"/>
																						<children>
																							<template subtype="element" match="n1:LeaveTotal">
																								<editorproperties adding="mandatory"/>
																								<children>
																									<content>
																										<styles font-size="10pt"/>
																										<format basic-type="xsd" datatype="decimal"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<properties align="center"/>
																						<children>
																							<template subtype="element" match="n1:LeaveUsed">
																								<editorproperties adding="mandatory"/>
																								<children>
																									<content>
																										<styles font-size="10pt"/>
																										<format basic-type="xsd" datatype="decimal"/>
																									</content>
																								</children>
																								<variables/>
																							</template>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<properties align="center"/>
																						<children>
																							<autocalc xpath="n1:LeaveTotal - n1:LeaveUsed" update="n1:LeaveLeft">
																								<styles font-size="10pt"/>
																							</autocalc>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																		</children>
																		<variables/>
																	</template>
																</children>
															</tgridbody-rows>
															<tgridfooter-rows>
																<children>
																	<tgridrow>
																		<properties bgcolor="#F2F0E6"/>
																		<children>
																			<tgridcell>
																				<properties align="left" valign="top"/>
																				<children>
																					<text fixtext="Employees:  ">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																					<autocalc xpath="count(  n1:Person  )">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</autocalc>
																					<text fixtext=" ">
																						<styles font-size="8pt"/>
																					</text>
																					<text fixtext="(">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																					<autocalc xpath="round ((count(  n1:Person  ) ) div ( count( ../n1:Department/ n1:Person  ) ) * 100)">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</autocalc>
																					<text fixtext="% of Office, ">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																					<autocalc xpath="round ((count(  n1:Person  ) ) div ( count( ../../n1:Office/n1:Department/ n1:Person  ) ) * 100)">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</autocalc>
																					<text fixtext="% of Company)">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left" valign="top"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left" valign="top"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left" valign="top"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left" valign="top"/>
																			</tgridcell>
																			<tgridcell>
																				<properties align="left"/>
																				<children>
																					<text fixtext="Shares: ">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																					<autocalc xpath="sum(  n1:Person/n1:Shares  )">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</autocalc>
																					<text fixtext=" ">
																						<styles font-size="8pt"/>
																					</text>
																					<text fixtext="(">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																					<autocalc xpath="round((sum(  n1:Person/n1:Shares  ) ) div (sum(../n1:Department/ n1:Person/n1:Shares ) ) * 100)">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</autocalc>
																					<text fixtext="% of Office, ">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																					<autocalc xpath="round((sum(  n1:Person/n1:Shares  ) ) div (sum(../../n1:Office/n1:Department/ n1:Person/n1:Shares  )) * 100)">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</autocalc>
																					<text fixtext="% of Company)">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<properties bgcolor="#F2F0E6"/>
																		<children>
																			<tgridcell>
																				<properties align="left"/>
																				<children>
																					<text fixtext="Non-Shareholders: ">
																						<styles color="#004080" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																					<text fixtext=" ">
																						<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																					<template subtype="element" match="n1:Person">
																						<editorproperties autoaddname="1" editable="0" adding="no"/>
																						<children>
																							<condition>
																								<children>
																									<conditionbranch xpath="n1:Shares &lt;= 0 or not (n1:Shares)">
																										<children>
																											<template subtype="element" match="n1:First">
																												<editorproperties adding="no"/>
																												<children>
																													<content>
																														<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																													</content>
																												</children>
																												<variables/>
																											</template>
																											<text fixtext=" ">
																												<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																											</text>
																											<template subtype="element" match="n1:Last">
																												<editorproperties adding="no"/>
																												<children>
																													<content>
																														<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																														<format basic-type="xsd" datatype="string"/>
																													</content>
																												</children>
																												<variables/>
																											</template>
																											<condition>
																												<children>
																													<conditionbranch xpath="following-sibling::n1:Person[n1:Shares&lt;=0 or not(n1:Shares)]">
																														<children>
																															<text fixtext=", ">
																																<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																															</text>
																														</children>
																													</conditionbranch>
																												</children>
																											</condition>
																										</children>
																									</conditionbranch>
																								</children>
																							</condition>
																						</children>
																						<variables/>
																					</template>
																					<condition>
																						<children>
																							<conditionbranch xpath="count(  n1:Person  ) = count(  n1:Person [n1:Shares&gt;0] )">
																								<children>
																									<text fixtext="None">
																										<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																									</text>
																								</children>
																							</conditionbranch>
																						</children>
																					</condition>
																					<text fixtext=".">
																						<styles color="#004040" font-family="Arial" font-size="8pt" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<properties align="left"/>
																			</tgridcell>
																		</children>
																	</tgridrow>
																</children>
															</tgridfooter-rows>
														</children>
													</tgrid>
													<newline/>
												</children>
												<variables/>
											</template>
											<chart>
												<styles height="150px" width="700px"/>
												<dataset/>
												<dataseries-xny-rows for-each="n1:Department/n1:Person[n1:Shares&gt;0]" x-value="concat(n1:First, codepoints-to-string( ( 13, 10 ) ), n1:Last)" auto-x-value="0">
													<col y-value="n1:Shares" y-name="&quot;Series 1&quot;"/>
												</dataseries-xny-rows>
												<wizard-data remove-empty-cat="1" remove-empty-ser="1">
													<wizard-data-categories/>
													<wizard-data-series/>
												</wizard-data>
												<chartsettings>
													<General SettingsVersion="1" Title="Overview of shares" ShowLegend="0"/>
													<XY>
														<XAxis/>
														<YAxis UseAutoTick="0" ManualTickInterval="500."/>
													</XY>
												</chartsettings>
												<chartsettings-xpath>
													<main-properties/>
													<color-properties/>
													<colorrange-properties/>
												</chartsettings-xpath>
											</chart>
										</children>
										<variables>
											<variable name="Zoom" value="16" valuetype="xs:integer" editable="1"/>
											<variable name="MapType" value="&apos;roadmap&apos;" valuetype="xs:string" editable="1"/>
										</variables>
									</template>
									<newline/>
								</children>
								<variables>
									<variable name="MapWidth" value="300" valuetype="xs:integer" editable="1"/>
								</variables>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts/>
	<pagelayout>
		<properties pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="1" paperheight="11in" papermarginbottom="0.79in" papermarginleft="0.6in" papermarginright="0.6in" papermargintop="0.79in" paperwidth="8.5in"/>
	</pagelayout>
	<designfragments/>
	<xmltables/>
	<authentic-custom-toolbar-buttons>
		<textstateicon match="ts:bold" iconfile="bold.bmp"/>
		<textstateicon match="ts:italic" iconfile="italic.bmp"/>
		<separator/>
		<scripted-button match="JumpTo" text="Jump To..." tooltip="Quick jump to one of the offices"/>
	</authentic-custom-toolbar-buttons>
</structure>
