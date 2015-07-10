<?xml version="1.0" encoding="UTF-8"?>
<structure version="17" html-doctype="HTML4 Transitional" compatibility-view="IE9" html-outputextent="Complete" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces/>
		<schemasources/>
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
		<Project version="3" app="AuthenticView"/>
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
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts/>
	<designfragments>
		<children>
			<globaltemplate subtype="named" match="XMLTreeDump">
				<parameters>
					<parameter name="InParentTree" type="xs:boolean" occurrence="none-or-one" default-value="false()"/>
					<parameter name="InMixed" type="xs:boolean" occurrence="none-or-one" default-value="false()"/>
				</parameters>
				<children>
					<condition>
						<children>
							<conditionbranch xpath="not($InParentTree)">
								<children>
									<text fixtext="Below you can see the underlying XML tree dump for better understanding">
										<styles font-size="smaller" font-weight="bold" text-decoration="underline"/>
									</text>
									<text fixtext=":"/>
									<newline/>
								</children>
							</conditionbranch>
						</children>
					</condition>
					<text fixtext="&lt;">
						<styles color="blue" font-size="smaller"/>
					</text>
					<autocalc xpath="name()">
						<styles color="maroon" font-size="smaller"/>
					</autocalc>
					<template subtype="userdefined" match="@*">
						<children>
							<condition>
								<children>
									<conditionbranch xpath="not(starts-with(name(),&apos;xsi:&apos;))">
										<children>
											<text fixtext=" ">
												<styles font-size="smaller"/>
											</text>
											<autocalc xpath="./name()">
												<styles color="red" font-size="smaller"/>
											</autocalc>
											<text fixtext="=&quot;"/>
											<content subtype="regular">
												<styles font-size="smaller"/>
											</content>
											<text fixtext="&quot;"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<variables/>
					</template>
					<text fixtext="&gt;">
						<styles color="blue" font-size="smaller"/>
					</text>
					<condition>
						<children>
							<conditionbranch xpath="(exists(*) and exists(text()[translate(normalize-space(.), &apos; &apos;, &apos;&apos;) ne &apos;&apos;])) or $InMixed">
								<children>
									<template subtype="userdefined" match="* | text()">
										<children>
											<condition>
												<children>
													<conditionbranch xpath=".instance of element()">
														<children>
															<calltemplate subtype="named" match="XMLTreeDump">
																<parameters>
																	<parameter name="InParentTree" value="true()"/>
																	<parameter name="InMixed" value="true()"/>
																</parameters>
															</calltemplate>
														</children>
													</conditionbranch>
													<conditionbranch>
														<children>
															<content subtype="regular">
																<styles font-size="smaller"/>
															</content>
														</children>
													</conditionbranch>
												</children>
											</condition>
										</children>
										<variables/>
									</template>
								</children>
							</conditionbranch>
							<conditionbranch xpath="exists(*)">
								<children>
									<template subtype="userdefined" match="*">
										<children>
											<tgrid>
												<properties cellpadding="0" cellspacing="0" width="100%"/>
												<children>
													<tgridbody-cols>
														<children>
															<tgridcol>
																<styles width="0.20in"/>
															</tgridcol>
															<tgridcol/>
														</children>
													</tgridbody-cols>
													<tgridbody-rows>
														<children>
															<tgridrow>
																<children>
																	<tgridcell/>
																	<tgridcell>
																		<children>
																			<calltemplate subtype="named" match="XMLTreeDump">
																				<parameters>
																					<parameter name="InParentTree" value="true()"/>
																				</parameters>
																			</calltemplate>
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
							<conditionbranch>
								<children>
									<content subtype="regular">
										<styles font-size="smaller"/>
									</content>
								</children>
							</conditionbranch>
						</children>
					</condition>
					<text fixtext="&lt;">
						<styles color="blue" font-size="smaller"/>
					</text>
					<text fixtext="/"/>
					<autocalc xpath="./name()">
						<styles color="maroon" font-size="smaller"/>
					</autocalc>
					<text fixtext="&gt;">
						<styles color="blue" font-size="smaller"/>
					</text>
				</children>
			</globaltemplate>
		</children>
	</designfragments>
	<xmltables/>
	<authentic-custom-toolbar-buttons/>
</structure>
