<?xml version="1.0" encoding="UTF-8"?>
<structure version="16" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces/>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="ScriptingSamples.xsd" workingxmlfile="OnFocus.xml"/>
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
				<Macro name="OnSetFocusStreet">
					<Source>AuthenticView.EventContext.SetVariableValue( &apos;Explanation&apos;,
&apos;Provide a complete street address starting with house number.&apos; )</Source>
				</Macro>
				<Macro name="OnKillFocus">
					<Source>AuthenticView.EventContext.SetVariableValue( &apos;Explanation&apos;, &apos;&apos; );</Source>
				</Macro>
				<Macro name="OnSetFocusState">
					<Source>AuthenticView.EventContext.SetVariableValue( &apos;Explanation&apos;,
&apos;Use a 2-letter state code like:\n\n&apos; +
&apos;  AL for Alabama,\n&apos; +
&apos;  AK for Alaska,\n&apos; +
&apos;  AZ for Arizona...&apos; )</Source>
				</Macro>
				<Macro name="OnSetFocusZIP">
					<Source>AuthenticView.EventContext.SetVariableValue( &apos;Explanation&apos;,
&apos;A 5-digit ZIP Code is required&apos; )</Source>
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
													<text fixtext="This example uses OnSetFocus and OnKillFocus events in order to show user context sensitive editing help in an extra field below. This field uses contents of a variable Explanation which is set in OnSetFocus events and cleared in OnKillFocus. There is a default text &quot;Please navigate...&quot; which is shown when variable is empty. Please note that variable is defined as not Undoable (see $XML node), so that changes to that variable do not interfere with real changes made by user."/>
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
																		<styles width="0.71in"/>
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
																								<authentic-event-handlers OnKillFocus="OnKillFocus" OnSetFocus="OnSetFocusStreet"/>
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
																				<children>
																					<text fixtext="State:"/>
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
																								<authentic-event-handlers OnKillFocus="OnKillFocus" OnSetFocus="OnSetFocusState"/>
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
																					<text fixtext="ZIP Code:"/>
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
																								<authentic-event-handlers OnKillFocus="OnKillFocus" OnSetFocus="OnSetFocusZIP"/>
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
																	<tgridcol>
																		<styles width="3.79in"/>
																	</tgridcol>
																</children>
															</tgridbody-cols>
															<tgridbody-rows>
																<children>
																	<tgridrow>
																		<styles height="1.05in"/>
																		<children>
																			<tgridcell>
																				<properties valign="top"/>
																				<styles border-color="black" border-style="dashed" border-width="1px"/>
																				<children>
																					<condition>
																						<children>
																							<conditionbranch xpath="string-length( $Explanation ) = 0">
																								<children>
																									<text fixtext="Please navigate with mouse or keyboard from field to field to see editing tips.">
																										<styles font-style="italic"/>
																									</text>
																								</children>
																							</conditionbranch>
																							<conditionbranch>
																								<children>
																									<template subtype="uservariable" match="$Explanation">
																										<children>
																											<paragraph paragraphtag="pre-wrap">
																												<children>
																													<content subtype="regular">
																														<editorproperties editable="0"/>
																														<styles color="blue"/>
																													</content>
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
							<variable name="Explanation" value="&apos;&apos;" valuetype="xs:string" editable="1" enable-undo="0"/>
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
