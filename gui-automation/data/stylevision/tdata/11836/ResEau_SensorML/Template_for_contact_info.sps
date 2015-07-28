<?xml version="1.0" encoding="UTF-8"?>
<structure version="7" cssmode="strict" relativeto="*SPS" encodinghtml="ISO-8859-1" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" embed-images="1">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="sml" uri="http://www.opengis.net/sensorML"/>
			<nspair prefix="swe" uri="http://www.opengis.net/swe"/>
			<nspair prefix="xlink" uri="http://www.w3.org/1999/xlink"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="$XML" main="1" schemafile="sensorML\1.0.30\base\base.xsd" workingxmlfile="Template_for_contact_info.xml" templatexmlfile="Template_for_contact_info_Blank.xml">
				<xmltablesupport/>
				<textstateicons/>
			</xsdschemasource>
		</schemasources>
	</schemasources>
	<modules/>
	<flags>
		<scripts/>
		<globalparts/>
		<designfragments/>
		<pagelayouts/>
	</flags>
	<scripts>
		<script language="javascript"/>
	</scripts>
	<globalstyles/>
	<mainparts>
		<children>
			<globaltemplate match="/" matchtype="named" parttype="main">
				<children>
					<template match="$XML" matchtype="schemasource">
						<children>
							<template match="sml:ResponsibleParty" matchtype="schemagraphitem">
								<editorproperties editable="1" markupmode="hide" adding="all" autoaddname="1"/>
								<children>
									<template match="sml:organizationName" matchtype="schemagraphitem">
										<children>
											<paragraph paragraphtag="h3">
												<children>
													<text fixtext="RésEau Partner Organization Contact Information">
														<styles font-weight="bold"/>
													</text>
												</children>
											</paragraph>
											<newline/>
											<newline/>
											<text fixtext="Organization name:"/>
											<newline/>
											<editfield>
												<editorproperties userinfo="Name of organization" editable="1"/>
												<properties size="50"/>
												<children>
													<content>
														<format datatype="string"/>
													</content>
												</children>
											</editfield>
										</children>
									</template>
									<template match="sml:contactInfo" matchtype="schemagraphitem">
										<editorproperties editable="1" markupmode="hide" adding="all" autoaddname="1"/>
										<children>
											<template match="sml:phone" matchtype="schemagraphitem">
												<children>
													<template match="sml:voice" matchtype="schemagraphitem">
														<children>
															<newline/>
															<text fixtext="Phone:"/>
															<newline/>
															<editfield>
																<children>
																	<content>
																		<format datatype="string"/>
																	</content>
																</children>
															</editfield>
														</children>
													</template>
													<template match="sml:facsimile" matchtype="schemagraphitem">
														<children>
															<newline/>
															<text fixtext="Facsimile:"/>
															<newline/>
															<editfield>
																<children>
																	<content>
																		<format datatype="string"/>
																	</content>
																</children>
															</editfield>
														</children>
													</template>
												</children>
											</template>
											<newline/>
											<text fixtext="Address:"/>
											<newline/>
											<template match="sml:address" matchtype="schemagraphitem">
												<children>
													<template match="sml:deliveryPoint" matchtype="schemagraphitem">
														<children>
															<multilinefield>
																<properties cols="50" rows="2"/>
																<children>
																	<content>
																		<format datatype="anyType"/>
																	</content>
																</children>
															</multilinefield>
														</children>
													</template>
													<newline/>
													<template match="sml:city" matchtype="schemagraphitem">
														<children>
															<text fixtext="City:"/>
															<newline/>
															<editfield>
																<properties size="50"/>
																<children>
																	<content>
																		<format datatype="anyType"/>
																	</content>
																</children>
															</editfield>
														</children>
													</template>
													<newline/>
													<template match="sml:administrativeArea" matchtype="schemagraphitem">
														<children>
															<text fixtext="Province:"/>
															<newline/>
															<combobox>
																<children>
																	<content>
																		<format datatype="anyType"/>
																	</content>
																</children>
																<selectoption description="AB" value="AB"/>
																<selectoption description="BC" value="BC"/>
																<selectoption description="MB" value="MB"/>
																<selectoption description="NB" value="NB"/>
																<selectoption description="NL" value="NL"/>
																<selectoption description="NS" value="NS"/>
																<selectoption description="NT" value="NT"/>
																<selectoption description="NU" value="NU"/>
																<selectoption description="ON" value="ON"/>
																<selectoption description="PE" value="PE"/>
																<selectoption description="QC" value="QC"/>
																<selectoption description="SK" value="SK"/>
																<selectoption description="YT" value="YT"/>
															</combobox>
														</children>
													</template>
													<newline/>
													<template match="sml:postalCode" matchtype="schemagraphitem">
														<children>
															<text fixtext="Postal Code:"/>
															<newline/>
															<editfield>
																<properties size="7"/>
																<children>
																	<content>
																		<format datatype="anyType"/>
																	</content>
																</children>
															</editfield>
														</children>
													</template>
													<newline/>
													<text fixtext="Country:"/>
													<template match="sml:country" matchtype="schemagraphitem">
														<editorproperties editable="0" markupmode="hide" adding="mandatory" autoaddname="1"/>
														<children>
															<content>
																<format datatype="anyType"/>
															</content>
														</children>
													</template>
													<newline/>
													<template match="sml:electronicMailAddress" matchtype="schemagraphitem">
														<children>
															<text fixtext="e-mail:"/>
															<newline/>
															<editfield>
																<properties size="50"/>
																<children>
																	<content>
																		<format datatype="anyType"/>
																	</content>
																</children>
															</editfield>
														</children>
													</template>
												</children>
											</template>
											<newline/>
											<text fixtext="Organization web site:"/>
											<newline/>
											<template match="sml:onlineResource" matchtype="schemagraphitem">
												<children>
													<template match="@xlink:href" matchtype="schemagraphitem">
														<children>
															<editfield>
																<children>
																	<content>
																		<format datatype="anyURI"/>
																	</content>
																</children>
															</editfield>
														</children>
													</template>
												</children>
											</template>
											<newline/>
											<template match="sml:hoursOfService" matchtype="schemagraphitem">
												<children>
													<newline/>
													<text fixtext="Hours of service:"/>
													<newline/>
													<editfield>
														<properties size="50"/>
														<children>
															<content>
																<format datatype="string"/>
															</content>
														</children>
													</editfield>
												</children>
											</template>
											<template match="sml:contactInstructions" matchtype="schemagraphitem">
												<children>
													<newline/>
													<text fixtext="Other contact instructions:"/>
													<newline/>
													<multilinefield>
														<properties cols="50" rows="3"/>
														<children>
															<content>
																<format datatype="string"/>
															</content>
														</children>
													</multilinefield>
												</children>
											</template>
										</children>
									</template>
								</children>
							</template>
						</children>
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
</structure>
