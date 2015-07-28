<?xml version="1.0" encoding="UTF-8"?>
<structure version="8" cssmode="quirks" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="aas" uri="http://dca.tufts.edu/aas"/>
			<nspair prefix="doc" uri="http://dca.tufts.edu/doc"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="electionRecord.xsd" workingxmlfile="schema_test_file.xml">
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
	<globalstyles>
		<rules selector="*">
			<media>
				<media value="all"/>
			</media>
			<rule/>
		</rules>
	</globalstyles>
	<mainparts>
		<children>
			<globaltemplate subtype="main" match="/">
				<children>
					<template subtype="source" match="XML">
						<children>
							<template subtype="element" match="aas:election_record">
								<children>
									<tgrid>
										<properties bgcolor="#d0d8df" border="0" width="100%"/>
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
																<properties bgcolor="#708392" valign="top"/>
																<styles background-color="#1f5999" border-bottom-color="white" border-bottom-style="solid"/>
																<children>
																	<template subtype="attribute" match="label">
																		<children>
																			<content>
																				<styles color="white" font-size="x-large"/>
																				<format datatype="string"/>
																			</content>
																		</children>
																	</template>
																</children>
															</tgridcell>
															<tgridcell joinleft="1">
																<properties bgcolor="#708392" valign="top"/>
																<styles background-color="#1f5999" border-bottom-color="white" border-bottom-style="solid"/>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles background-color="#87AAC8"/>
																<children>
																	<text fixtext="Date of election:">
																		<styles font-family="Garamond" font-size="medium" font-style="normal" font-weight="bold"/>
																	</text>
																</children>
															</tgridcell>
															<tgridcell>
																<styles background-color="#D0D8DF" border-color="#D0D8DF" border-style="solid"/>
																<children>
																	<template subtype="attribute" match="date">
																		<children>
																			<editfield>
																				<properties size="50"/>
																				<styles height="21px"/>
																				<children>
																					<content>
																						<format datatype="anySimpleType"/>
																					</content>
																				</children>
																			</editfield>
																		</children>
																	</template>
																</children>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles background-color="#87AAC8"/>
																<children>
																	<text fixtext="Type of election:">
																		<styles font-family="Garamond" font-size="medium" font-style="normal" font-weight="bold"/>
																	</text>
																</children>
															</tgridcell>
															<tgridcell>
																<styles background-color="#D0D8DF" border-color="#D0D8DF" border-style="solid"/>
																<children>
																	<template subtype="attribute" match="type">
																		<children>
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
																</children>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<properties height="28"/>
														<children>
															<tgridcell>
																<styles background-color="#87AAC8"/>
																<children>
																	<text fixtext="Iteration:">
																		<styles font-family="Garamond" font-size="medium" font-style="normal" font-weight="bold"/>
																	</text>
																</children>
															</tgridcell>
															<tgridcell>
																<properties height="28"/>
																<styles background-color="#D0D8DF" border-color="#D0D8DF" border-style="solid"/>
																<children>
																	<template subtype="attribute" match="iteration">
																		<children>
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
																</children>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles background-color="#87AAC8"/>
																<children>
																	<text fixtext="Unique identifier for this election:">
																		<styles font-family="Garamond" font-size="medium" font-style="normal" font-weight="bold"/>
																	</text>
																</children>
															</tgridcell>
															<tgridcell>
																<styles background-color="#D0D8DF" border-color="#D0D8DF" border-style="solid"/>
																<children>
																	<template subtype="attribute" match="election_id">
																		<children>
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
																</children>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles background-color="#D0D8DF"/>
															</tgridcell>
															<tgridcell joinleft="1">
																<styles background-color="#D0D8DF"/>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles background-color="#708392"/>
																<children>
																	<text fixtext="References: ">
																		<styles color="white" font-family="Verdana" font-size="larger" font-weight="bold"/>
																	</text>
																	<text fixtext=" for the overall election record (author, type, page image identifier)">
																		<styles color="white" font-family="Verdana" font-size="small" font-weight="bold"/>
																	</text>
																</children>
															</tgridcell>
															<tgridcell joinleft="1">
																<styles background-color="#708392"/>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles background-color="#D0D8DF"/>
																<children>
																	<calltemplate subtype="element" match="aas:reference"/>
																</children>
															</tgridcell>
															<tgridcell joinleft="1">
																<styles background-color="#D0D8DF"/>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<styles background-color="#708392" page-break-before="always"/>
																<children>
																	<text fixtext="Notes:  ">
																		<styles color="white" font-family="Verdana" font-size="medium" font-weight="bold"/>
																	</text>
																	<text fixtext="for the overall election record (author, note text)">
																		<styles color="white" font-family="Verdana" font-size="small" font-weight="bold"/>
																	</text>
																</children>
															</tgridcell>
															<tgridcell joinleft="1">
																<styles background-color="#708392" page-break-before="always"/>
															</tgridcell>
														</children>
													</tgridrow>
													<tgridrow>
														<children>
															<tgridcell>
																<children>
																	<calltemplate subtype="element" match="aas:note"/>
																</children>
															</tgridcell>
															<tgridcell joinleft="1"/>
														</children>
													</tgridrow>
												</children>
											</tgridbody-rows>
										</children>
									</tgrid>
									<line>
										<properties color="maroon" size="3"/>
										<styles margin-bottom="0" margin-top="0"/>
									</line>
									<newline/>
									<newline/>
									<template subtype="element" match="aas:office">
										<children>
											<tgrid>
												<properties border="1" cellspacing="0" width="100%"/>
												<styles font-size="x-large"/>
												<children>
													<tgridbody-cols>
														<styles font-size="x-large"/>
														<children>
															<tgridcol/>
														</children>
													</tgridbody-cols>
													<tgridbody-rows>
														<children>
															<tgridrow>
																<styles font-size="x-large"/>
																<children>
																	<tgridcell>
																		<styles background-color="#1f5999" border-color="#D0D8DF" border-style="solid" font-size="x-large"/>
																		<children>
																			<text fixtext="Election Office:">
																				<styles color="white" font-family="Verdana" font-size="large" font-weight="bold"/>
																			</text>
																			<text fixtext="  "/>
																			<template subtype="attribute" match="name">
																				<children>
																					<content>
																						<styles color="white"/>
																						<format datatype="string"/>
																					</content>
																				</children>
																			</template>
																		</children>
																	</tgridcell>
																</children>
															</tgridrow>
														</children>
													</tgridbody-rows>
												</children>
											</tgrid>
											<tgrid>
												<properties border="1" cellspacing="0" width="100%"/>
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
																		<styles background-color="#87AAC8"/>
																		<children>
																			<text fixtext="Unique identifier of this office:  ">
																				<styles font-family="Garamond" font-size="medium" font-weight="bold"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<styles background-color="#D0D8DF" border-color="#D0D8DF" border-style="solid" page-break-before="always"/>
																		<children>
																			<template subtype="attribute" match="office_id">
																				<children>
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
																		</children>
																	</tgridcell>
																</children>
															</tgridrow>
															<tgridrow>
																<children>
																	<tgridcell>
																		<styles background-color="#87AAC8" page-break-before="always"/>
																		<children>
																			<text fixtext="Scope of this office">
																				<styles font-family="Garamond" font-size="medium" font-weight="bold"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell>
																		<styles background-color="#D0D8DF" border-color="#D0D8DF" border-style="solid" page-break-before="always"/>
																		<children>
																			<template subtype="attribute" match="scope">
																				<children>
																					<editfield>
																						<properties size="50"/>
																						<children>
																							<content>
																								<format datatype="token"/>
																							</content>
																						</children>
																					</editfield>
																				</children>
																			</template>
																		</children>
																	</tgridcell>
																</children>
															</tgridrow>
															<tgridrow>
																<children>
																	<tgridcell>
																		<styles background-color="#D0D8DF"/>
																	</tgridcell>
																	<tgridcell joinleft="1">
																		<styles background-color="#D0D8DF"/>
																	</tgridcell>
																</children>
															</tgridrow>
															<tgridrow>
																<children>
																	<tgridcell>
																		<styles background-color="#708392"/>
																		<children>
																			<text fixtext="References: ">
																				<styles color="white" font-family="Verdana" font-size="larger" font-weight="bold"/>
																			</text>
																			<text fixtext=" for this office (author, type, page image identifier)">
																				<styles color="white" font-family="Verdana" font-size="small" font-weight="bold"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell joinleft="1">
																		<styles background-color="#708392"/>
																	</tgridcell>
																</children>
															</tgridrow>
															<tgridrow>
																<children>
																	<tgridcell>
																		<styles background-color="#D0D8DF"/>
																		<children>
																			<calltemplate subtype="element" match="aas:reference"/>
																		</children>
																	</tgridcell>
																	<tgridcell joinleft="1">
																		<styles background-color="#D0D8DF"/>
																	</tgridcell>
																</children>
															</tgridrow>
															<tgridrow>
																<children>
																	<tgridcell>
																		<styles background-color="#708392" page-break-before="always"/>
																		<children>
																			<text fixtext="Notes:  ">
																				<styles color="white" font-family="Verdana" font-size="medium" font-weight="bold"/>
																			</text>
																			<text fixtext="for this office (author, note text)">
																				<styles color="white" font-family="Verdana" font-size="small" font-weight="bold"/>
																			</text>
																		</children>
																	</tgridcell>
																	<tgridcell joinleft="1">
																		<styles background-color="#708392" page-break-before="always"/>
																	</tgridcell>
																</children>
															</tgridrow>
															<tgridrow>
																<children>
																	<tgridcell>
																		<styles background-color="#D0D8DF"/>
																		<children>
																			<calltemplate subtype="element" match="aas:note"/>
																		</children>
																	</tgridcell>
																	<tgridcell joinleft="1">
																		<styles background-color="#D0D8DF"/>
																	</tgridcell>
																</children>
															</tgridrow>
														</children>
													</tgridbody-rows>
												</children>
											</tgrid>
											<line>
												<properties color="maroon" size="3"/>
												<styles margin-bottom="0" margin-top="0"/>
											</line>
											<newline/>
											<newline/>
											<template subtype="element" match="aas:role">
												<children>
													<newline/>
													<tgrid>
														<properties border="1" cellspacing="0" width="100%"/>
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
																				<styles background-color="#1f5999" border-color="#D0D8DF" border-style="solid" page-break-before="always"/>
																				<children>
																					<text fixtext="Role of the elected official:">
																						<styles color="white" font-family="Verdana" font-size="large" font-weight="bold"/>
																					</text>
																					<text fixtext="  "/>
																					<template subtype="attribute" match="title">
																						<children>
																							<content>
																								<styles color="white" font-size="x-large"/>
																								<format datatype="string"/>
																							</content>
																						</children>
																					</template>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																</children>
															</tgridbody-rows>
														</children>
													</tgrid>
													<tgrid>
														<properties border="1" cellspacing="0" width="100%"/>
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
																				<styles background-color="#87AAC8" page-break-before="always"/>
																				<children>
																					<text fixtext="Scope of this role:">
																						<styles font-family="Garamond" font-size="medium" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell>
																				<styles background-color="#D0D8DF" border-color="#D0D8DF" border-style="solid" page-break-before="always"/>
																				<children>
																					<template subtype="attribute" match="scope">
																						<children>
																							<editfield>
																								<children>
																									<content>
																										<format datatype="token"/>
																									</content>
																								</children>
																							</editfield>
																						</children>
																					</template>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<styles background-color="#D0D8DF" page-break-before="always"/>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<styles background-color="#D0D8DF" page-break-before="always"/>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<styles background-color="#708392" page-break-before="always"/>
																				<children>
																					<text fixtext="References: ">
																						<styles color="white" font-family="Verdana" font-size="larger" font-weight="bold"/>
																					</text>
																					<text fixtext=" pertaining to this role (author, type, page image identifier)">
																						<styles color="white" font-family="Verdana" font-size="small" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<styles background-color="#708392" page-break-before="always"/>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<styles background-color="#D0D8DF" page-break-before="always"/>
																				<children>
																					<calltemplate subtype="element" match="aas:reference"/>
																				</children>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<styles background-color="#D0D8DF" page-break-before="always"/>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<styles background-color="#708392" page-break-before="always"/>
																				<children>
																					<text fixtext="Notes:  ">
																						<styles color="white" font-family="Verdana" font-size="medium" font-weight="bold"/>
																					</text>
																					<text fixtext="pertaining to this role (author, note text)">
																						<styles color="white" font-family="Verdana" font-size="small" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<styles background-color="#708392" page-break-before="always"/>
																			</tgridcell>
																		</children>
																	</tgridrow>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<styles background-color="#D0D8DF" page-break-before="always"/>
																				<children>
																					<calltemplate subtype="element" match="aas:note"/>
																				</children>
																			</tgridcell>
																			<tgridcell joinleft="1">
																				<styles background-color="#D0D8DF" page-break-before="always"/>
																			</tgridcell>
																		</children>
																	</tgridrow>
																</children>
															</tgridbody-rows>
														</children>
													</tgrid>
													<line>
														<properties color="maroon" size="3"/>
														<styles margin-bottom="0" margin-top="0"/>
													</line>
													<newline/>
													<newline/>
													<template subtype="element" match="aas:ballot">
														<children>
															<newline/>
															<tgrid>
																<properties border="0" width="100%"/>
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
																						<styles background-color="#1f5999" page-break-before="always"/>
																						<children>
																							<text fixtext="The Candidates on the Ballot:">
																								<styles color="white" font-family="Verdana" font-size="large" font-weight="bold"/>
																							</text>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																		</children>
																	</tgridbody-rows>
																</children>
															</tgrid>
															<tgrid>
																<properties bgcolor="#d0d8df" border="0" width="100%"/>
																<children>
																	<tgridbody-cols>
																		<children>
																			<tgridcol/>
																			<tgridcol/>
																			<tgridcol/>
																		</children>
																	</tgridbody-cols>
																	<tgridheader-rows>
																		<children>
																			<tgridrow>
																				<properties height="110"/>
																				<children>
																					<tgridcell>
																						<styles background-color="#87AAC8" page-break-before="always"/>
																						<children>
																							<text fixtext="Candidate ">
																								<styles color="black" font-family="Garamond" font-size="medium" font-weight="bold"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<styles background-color="#87AAC8" page-break-before="always"/>
																						<children>
																							<text fixtext="Party Affiliation:">
																								<styles color="black" font-family="Garamond" font-size="medium" font-weight="bold"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<styles background-color="#87AAC8" page-break-before="always"/>
																						<children>
																							<text fixtext="Note:">
																								<styles color="black" font-family="Garamond" font-size="medium" font-weight="bold"/>
																							</text>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																		</children>
																	</tgridheader-rows>
																	<tgridbody-rows>
																		<children>
																			<template subtype="element" match="aas:candidate">
																				<children>
																					<tgridrow>
																						<properties valign="top"/>
																						<children>
																							<tgridcell>
																								<properties valign="top"/>
																								<children>
																									<template subtype="attribute" match="candidate_num">
																										<children>
																											<content>
																												<format datatype="integer"/>
																											</content>
																										</children>
																									</template>
																									<text fixtext=".  "/>
																									<template subtype="attribute" match="name">
																										<children>
																											<content>
																												<format datatype="string"/>
																											</content>
																										</children>
																									</template>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<properties valign="top"/>
																								<children>
																									<template subtype="attribute" match="affiliation">
																										<children>
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
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<calltemplate subtype="element" match="aas:note"/>
																								</children>
																							</tgridcell>
																						</children>
																					</tgridrow>
																				</children>
																			</template>
																			<tgridrow>
																				<properties valign="top"/>
																				<children>
																					<tgridcell>
																						<properties valign="top"/>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<properties valign="top"/>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<properties valign="top"/>
																					</tgridcell>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<properties valign="top"/>
																				<children>
																					<tgridcell>
																						<styles background-color="#708392" page-break-before="always"/>
																						<children>
																							<text fixtext="References: ">
																								<styles color="white" font-family="Verdana" font-size="larger" font-weight="bold"/>
																							</text>
																							<text fixtext=" pertaining to this ballot (author, type, page image identifier)">
																								<styles color="white" font-family="Verdana" font-size="small" font-weight="bold"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<styles background-color="#708392" page-break-before="always"/>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<styles background-color="#708392" page-break-before="always"/>
																					</tgridcell>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<properties valign="top"/>
																				<children>
																					<tgridcell>
																						<styles background-color="#D0D8DF" page-break-before="always"/>
																						<children>
																							<calltemplate subtype="element" match="aas:reference"/>
																						</children>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<styles background-color="#D0D8DF" page-break-before="always"/>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<styles background-color="#D0D8DF" page-break-before="always"/>
																					</tgridcell>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<properties valign="top"/>
																				<children>
																					<tgridcell>
																						<styles background-color="#708392" page-break-before="always"/>
																						<children>
																							<text fixtext="Notes:  ">
																								<styles color="white" font-family="Verdana" font-size="medium" font-weight="bold"/>
																							</text>
																							<text fixtext="pertaining to this ballot (author, note text)">
																								<styles color="white" font-family="Verdana" font-size="small" font-weight="bold"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<styles background-color="#708392" page-break-before="always"/>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<styles background-color="#708392" page-break-before="always"/>
																					</tgridcell>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<properties valign="top"/>
																				<children>
																					<tgridcell>
																						<styles background-color="#D0D8DF" page-break-before="always"/>
																						<children>
																							<calltemplate subtype="element" match="aas:note"/>
																						</children>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<styles background-color="#D0D8DF" page-break-before="always"/>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<styles background-color="#D0D8DF" page-break-before="always"/>
																					</tgridcell>
																				</children>
																			</tgridrow>
																		</children>
																	</tgridbody-rows>
																</children>
															</tgrid>
															<line>
																<properties color="maroon" size="3"/>
																<styles margin-bottom="0" margin-top="0"/>
															</line>
														</children>
													</template>
													<template subtype="element" match="aas:overview">
														<editorproperties autoaddname="1" editable="1" adding="mandatory" markupmode="hide"/>
														<children>
															<newline/>
															<newline/>
															<newline/>
															<tgrid>
																<properties border="0" cellspacing="0" width="100%"/>
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
																						<styles background-color="#1f5999" page-break-before="always"/>
																						<children>
																							<text fixtext="Summary: the total overall votes in this election: ">
																								<styles color="white" font-family="Verdana" font-size="large" font-weight="bold"/>
																							</text>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																		</children>
																	</tgridbody-rows>
																</children>
															</tgrid>
															<tgrid>
																<properties bgcolor="#d0d8df" border="1" width="100%"/>
																<children>
																	<tgridbody-cols>
																		<children>
																			<tgridcol/>
																			<tgridcol/>
																		</children>
																	</tgridbody-cols>
																	<tgridheader-rows>
																		<children>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<styles background-color="#87AAC8" page-break-before="always"/>
																						<children>
																							<text fixtext="Status of Summary : ">
																								<styles font-family="Garamond" font-size="medium" font-weight="bold"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<styles background-color="#D0D8DF" page-break-before="always"/>
																						<children>
																							<template subtype="attribute" match="status">
																								<children>
																									<editfield>
																										<properties size="35"/>
																										<children>
																											<content>
																												<format datatype="string"/>
																											</content>
																										</children>
																									</editfield>
																								</children>
																							</template>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<styles background-color="#87AAC8" page-break-before="always"/>
																						<children>
																							<text fixtext="Date created/modified:">
																								<styles font-family="Garamond" font-size="medium" font-weight="bold"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<styles background-color="#D0D8DF" page-break-before="always"/>
																						<children>
																							<template subtype="attribute" match="modified">
																								<children>
																									<editfield>
																										<properties size="35"/>
																										<children>
																											<content>
																												<format datatype="date"/>
																											</content>
																										</children>
																									</editfield>
																								</children>
																							</template>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<properties bgcolor="#d0d8df"/>
																				<children>
																					<tgridcell>
																						<styles background-color="#D0D8DF" page-break-before="always"/>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<styles background-color="#D0D8DF" page-break-before="always"/>
																					</tgridcell>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<properties height="10%"/>
																				<children>
																					<tgridcell>
																						<styles background-color="#87AAC8" page-break-before="always"/>
																						<children>
																							<text fixtext="Candidate Number and Vote Total:">
																								<styles color="black" font-family="Garamond" font-size="medium" font-weight="bold"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<styles background-color="#87AAC8" page-break-before="always"/>
																						<children>
																							<text fixtext="Person Responsible for Data:  ">
																								<styles color="black" font-family="Garamond" font-size="medium" font-weight="bold"/>
																							</text>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																		</children>
																	</tgridheader-rows>
																	<tgridbody-rows>
																		<children>
																			<template subtype="element" match="aas:candidate_summary">
																				<children>
																					<tgridrow>
																						<children>
																							<tgridcell>
																								<children>
																									<template subtype="attribute" match="candidate_ref">
																										<children>
																											<content>
																												<format datatype="integer"/>
																											</content>
																										</children>
																									</template>
																									<text fixtext=" : "/>
																									<template subtype="attribute" match="vote_total">
																										<children>
																											<editfield>
																												<children>
																													<content>
																														<format datatype="integer"/>
																													</content>
																												</children>
																											</editfield>
																										</children>
																									</template>
																									<newline/>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<template subtype="attribute" match="resp">
																										<children>
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
																							</tgridcell>
																						</children>
																					</tgridrow>
																				</children>
																			</template>
																			<tgridrow>
																				<children>
																					<tgridcell/>
																					<tgridcell joinleft="1"/>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<styles background-color="#708392" page-break-before="always"/>
																						<children>
																							<text fixtext="References: ">
																								<styles color="white" font-family="Verdana" font-size="larger" font-weight="bold"/>
																							</text>
																							<text fixtext=" pertaining to this summary (author, type, page image identifier)">
																								<styles color="white" font-family="Verdana" font-size="small" font-weight="bold"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<styles background-color="#708392" page-break-before="always"/>
																					</tgridcell>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<styles background-color="#d0d8df" page-break-before="always"/>
																						<children>
																							<calltemplate subtype="element" match="aas:reference"/>
																						</children>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<styles background-color="#d0d8df" page-break-before="always"/>
																					</tgridcell>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<styles background-color="#708392" page-break-before="always"/>
																						<children>
																							<text fixtext="Notes:  ">
																								<styles color="white" font-family="Verdana" font-size="medium" font-weight="bold"/>
																							</text>
																							<text fixtext="pertaining to this summary (author, note text)">
																								<styles color="white" font-family="Verdana" font-size="small" font-weight="bold"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<styles background-color="#708392" page-break-before="always"/>
																					</tgridcell>
																				</children>
																			</tgridrow>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<styles background-color="#D0D8DF" page-break-before="always"/>
																						<children>
																							<calltemplate subtype="element" match="aas:note"/>
																						</children>
																					</tgridcell>
																					<tgridcell joinleft="1">
																						<styles background-color="#D0D8DF" page-break-before="always"/>
																					</tgridcell>
																				</children>
																			</tgridrow>
																		</children>
																	</tgridbody-rows>
																</children>
															</tgrid>
															<line>
																<properties color="maroon" size="3"/>
																<styles margin-bottom="0" margin-top="0"/>
															</line>
														</children>
													</template>
													<newline/>
													<newline/>
													<newline/>
													<tgrid>
														<properties border="0" width="100%"/>
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
																				<styles background-color="#1f5999" page-break-before="always"/>
																				<children>
																					<text fixtext="Details:  the distributed results of the vote: ">
																						<styles color="white" font-family="Verdana" font-size="large" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																</children>
															</tgridbody-rows>
														</children>
													</tgrid>
													<tgrid>
														<properties border="0" cellspacing="0" width="100%"/>
														<children>
															<tgridbody-cols>
																<children>
																	<tgridcol/>
																</children>
															</tgridbody-cols>
															<tgridheader-rows>
																<children>
																	<tgridrow>
																		<children>
																			<tgridcell>
																				<styles background-color="#708392" page-break-before="always"/>
																				<children>
																					<template subtype="element" match="aas:admin_unit">
																						<children>
																							<template subtype="attribute" match="name">
																								<children>
																									<content>
																										<styles color="white" font-size="large"/>
																										<format datatype="string"/>
																									</content>
																								</children>
																							</template>
																						</children>
																					</template>
																					<text fixtext=" -- ">
																						<styles color="white" font-family="Verdana" font-size="medium" font-weight="bold"/>
																					</text>
																					<template subtype="element" match="aas:admin_unit">
																						<children>
																							<template subtype="attribute" match="type">
																								<children>
																									<content>
																										<styles color="white" font-size="large"/>
																										<format datatype="token"/>
																									</content>
																								</children>
																							</template>
																						</children>
																					</template>
																					<text fixtext=" : ">
																						<styles color="white" font-family="Verdana" font-size="medium" font-weight="bold"/>
																					</text>
																				</children>
																			</tgridcell>
																		</children>
																	</tgridrow>
																</children>
															</tgridheader-rows>
															<tgridbody-rows>
																<children>
																	<template subtype="element" match="aas:admin_unit">
																		<children>
																			<tgridrow>
																				<children>
																					<tgridcell>
																						<styles background-color="#D0D8DF"/>
																						<children>
																							<tgrid>
																								<properties border="0" cellspacing="0" width="100%"/>
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
																														<children>
																															<tgrid>
																																<properties border="1"/>
																																<children>
																																	<tgridbody-cols>
																																		<children>
																																			<tgridcol/>
																																			<tgridcol/>
																																			<tgridcol/>
																																		</children>
																																	</tgridbody-cols>
																																	<tgridheader-rows>
																																		<children>
																																			<tgridrow>
																																				<properties height="10%"/>
																																				<children>
																																					<tgridcell>
																																						<styles background-color="#87AAC8" page-break-before="always"/>
																																						<children>
																																							<text fixtext="Candidate Number:">
																																								<styles color="black" font-family="Garamond" font-size="medium" font-weight="bold"/>
																																							</text>
																																						</children>
																																					</tgridcell>
																																					<tgridcell>
																																						<properties height="10%"/>
																																						<styles background-color="#87AAC8" page-break-before="always"/>
																																						<children>
																																							<text fixtext="Vote:">
																																								<styles color="black" font-family="Garamond" font-size="medium" font-weight="bold"/>
																																							</text>
																																						</children>
																																					</tgridcell>
																																					<tgridcell>
																																						<properties height="10%"/>
																																						<styles background-color="#87AAC8" page-break-before="always"/>
																																						<children>
																																							<text fixtext="Person Responsible for Data:">
																																								<styles color="black" font-family="Garamond" font-size="medium" font-weight="bold"/>
																																							</text>
																																						</children>
																																					</tgridcell>
																																				</children>
																																			</tgridrow>
																																		</children>
																																	</tgridheader-rows>
																																	<tgridbody-rows>
																																		<children>
																																			<template subtype="element" match="aas:result">
																																				<children>
																																					<tgridrow>
																																						<children>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="candidate_ref">
																																										<children>
																																											<content>
																																												<format datatype="integer"/>
																																											</content>
																																										</children>
																																									</template>
																																								</children>
																																							</tgridcell>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="vote">
																																										<children>
																																											<editfield>
																																												<children>
																																													<content>
																																														<format datatype="integer"/>
																																													</content>
																																												</children>
																																											</editfield>
																																										</children>
																																									</template>
																																								</children>
																																							</tgridcell>
																																							<tgridcell>
																																								<children>
																																									<template subtype="attribute" match="resp">
																																										<children>
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
																																							</tgridcell>
																																						</children>
																																					</tgridrow>
																																				</children>
																																			</template>
																																		</children>
																																	</tgridbody-rows>
																																</children>
																															</tgrid>
																														</children>
																													</tgridcell>
																												</children>
																											</tgridrow>
																											<tgridrow>
																												<children>
																													<tgridcell>
																														<styles padding-left="25px"/>
																														<children>
																															<text fixtext="   "/>
																															<calltemplate subtype="element" match="aas:sub_unit"/>
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
																					</tgridcell>
																				</children>
																			</tgridrow>
																		</children>
																	</template>
																</children>
															</tgridbody-rows>
														</children>
													</tgrid>
													<newline/>
												</children>
											</template>
											<newline/>
										</children>
									</template>
									<newline/>
								</children>
							</template>
							<newline/>
						</children>
					</template>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts>
		<children>
			<globaltemplate subtype="element" match="aas:sub_unit">
				<children>
					<template subtype="element" match="aas:sub_unit">
						<editorproperties autoaddname="1" editable="1" adding="all" markupmode="hide"/>
						<children>
							<newline/>
							<tgrid>
								<properties bgcolor="#d0d8df" border="1" width="100%"/>
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
														<styles background-color="#708392" border-color="#708392"/>
														<children>
															<template subtype="attribute" match="name">
																<children>
																	<content>
																		<styles color="white" font-size="large"/>
																		<format datatype="string"/>
																	</content>
																</children>
															</template>
															<text fixtext=" ">
																<styles color="white"/>
															</text>
															<text fixtext="--">
																<styles color="white" font-size="large"/>
															</text>
															<text fixtext=" "/>
															<template subtype="attribute" match="type">
																<children>
																	<content>
																		<styles color="white" font-size="large"/>
																		<format datatype="token"/>
																	</content>
																</children>
															</template>
															<text fixtext=" : ">
																<styles color="white" font-family="Verdana" font-size="small" font-weight="bold"/>
															</text>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
											<tgridrow>
												<children>
													<tgridcell>
														<children>
															<tgrid>
																<properties border="1" width="100%"/>
																<children>
																	<tgridbody-cols>
																		<children>
																			<tgridcol/>
																			<tgridcol/>
																		</children>
																	</tgridbody-cols>
																	<tgridheader-rows>
																		<children>
																			<tgridrow>
																				<properties height="10%"/>
																				<children>
																					<tgridcell>
																						<styles background-color="#87AAC8" page-break-before="always"/>
																						<children>
																							<text fixtext="Candidate Number and Vote Total:">
																								<styles color="black" font-family="Garamond" font-size="medium" font-weight="bold"/>
																							</text>
																						</children>
																					</tgridcell>
																					<tgridcell>
																						<properties height="10%"/>
																						<styles background-color="#87AAC8" page-break-before="always"/>
																						<children>
																							<text fixtext="Person Responsible for Data:">
																								<styles color="black" font-family="Garamond" font-size="medium" font-weight="bold"/>
																							</text>
																						</children>
																					</tgridcell>
																				</children>
																			</tgridrow>
																		</children>
																	</tgridheader-rows>
																	<tgridbody-rows>
																		<children>
																			<template subtype="element" match="aas:result">
																				<children>
																					<tgridrow>
																						<children>
																							<tgridcell>
																								<children>
																									<template subtype="attribute" match="candidate_ref">
																										<children>
																											<content>
																												<format datatype="integer"/>
																											</content>
																										</children>
																									</template>
																									<text fixtext=" : "/>
																									<template subtype="attribute" match="vote">
																										<children>
																											<editfield>
																												<children>
																													<content>
																														<format datatype="integer"/>
																													</content>
																												</children>
																											</editfield>
																										</children>
																									</template>
																								</children>
																							</tgridcell>
																							<tgridcell>
																								<children>
																									<template subtype="attribute" match="resp">
																										<children>
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
																							</tgridcell>
																						</children>
																					</tgridrow>
																				</children>
																			</template>
																		</children>
																	</tgridbody-rows>
																</children>
															</tgrid>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
											<tgridrow>
												<children>
													<tgridcell>
														<styles background-color="#708392" page-break-before="always"/>
														<children>
															<text fixtext="References for this data ">
																<styles color="white" font-family="Verdana" font-size="larger" font-weight="bold"/>
															</text>
															<text fixtext="(author, type, page image identifier):">
																<styles color="white" font-family="Verdana" font-size="small" font-weight="bold"/>
															</text>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
											<tgridrow>
												<children>
													<tgridcell>
														<children>
															<template subtype="source" match="XML">
																<children>
																	<template subtype="element" match="aas:election_record">
																		<children>
																			<template subtype="element" match="aas:office">
																				<children>
																					<template subtype="element" match="aas:role">
																						<children>
																							<template subtype="element" match="aas:admin_unit">
																								<children>
																									<template subtype="element" match="aas:sub_unit">
																										<children>
																											<calltemplate subtype="element" match="aas:reference"/>
																										</children>
																									</template>
																								</children>
																							</template>
																						</children>
																					</template>
																				</children>
																			</template>
																		</children>
																	</template>
																</children>
															</template>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
											<tgridrow>
												<children>
													<tgridcell>
														<styles background-color="#708392" page-break-before="always"/>
														<children>
															<text fixtext="Notes for this data ">
																<styles color="white" font-family="Verdana" font-size="medium" font-weight="bold"/>
															</text>
															<text fixtext="(author, note text)">
																<styles color="white" font-family="Verdana" font-size="small" font-weight="bold"/>
															</text>
															<text fixtext=":">
																<styles color="white" font-family="Verdana" font-size="medium" font-weight="bold"/>
															</text>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
											<tgridrow>
												<children>
													<tgridcell>
														<children>
															<template subtype="source" match="XML">
																<children>
																	<template subtype="element" match="aas:election_record">
																		<children>
																			<template subtype="element" match="aas:office">
																				<children>
																					<template subtype="element" match="aas:role">
																						<children>
																							<template subtype="element" match="aas:admin_unit">
																								<children>
																									<template subtype="element" match="aas:sub_unit">
																										<children>
																											<calltemplate subtype="element" match="aas:note"/>
																										</children>
																									</template>
																								</children>
																							</template>
																						</children>
																					</template>
																				</children>
																			</template>
																		</children>
																	</template>
																</children>
															</template>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
										</children>
									</tgridbody-rows>
								</children>
							</tgrid>
							<template subtype="source" match="XML">
								<children>
									<template subtype="element" match="aas:election_record">
										<children>
											<template subtype="element" match="aas:office">
												<children>
													<template subtype="element" match="aas:role">
														<children>
															<template subtype="element" match="aas:admin_unit">
																<children>
																	<calltemplate subtype="element" match="aas:sub_unit"/>
																</children>
															</template>
														</children>
													</template>
												</children>
											</template>
										</children>
									</template>
								</children>
							</template>
							<newline/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="aas:reference">
				<children>
					<tgrid>
						<properties bgcolor="#d0d8df" border="0" width="100%"/>
						<children>
							<tgridbody-cols>
								<children>
									<tgridcol/>
									<tgridcol/>
									<tgridcol/>
								</children>
							</tgridbody-cols>
							<tgridbody-rows>
								<children>
									<template subtype="element" match="aas:reference">
										<children>
											<tgridrow>
												<children>
													<tgridcell>
														<children>
															<template subtype="attribute" match="resp">
																<children>
																	<editfield>
																		<properties size="35"/>
																		<children>
																			<content>
																				<format datatype="string"/>
																			</content>
																		</children>
																	</editfield>
																</children>
															</template>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="attribute" match="type">
																<children>
																	<editfield>
																		<properties size="35"/>
																		<children>
																			<content>
																				<format datatype="string"/>
																			</content>
																		</children>
																	</editfield>
																</children>
															</template>
														</children>
													</tgridcell>
													<tgridcell>
														<children>
															<template subtype="attribute" match="urn">
																<children>
																	<editfield>
																		<properties size="35"/>
																		<children>
																			<content>
																				<format datatype="string"/>
																			</content>
																		</children>
																	</editfield>
																</children>
															</template>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
										</children>
									</template>
								</children>
							</tgridbody-rows>
						</children>
					</tgrid>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="aas:note">
				<children>
					<tgrid>
						<properties border="0" width="100%"/>
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
												<properties bgcolor="#d0d8df" valign="top"/>
												<children>
													<template subtype="element" match="aas:note">
														<children>
															<template subtype="attribute" match="resp">
																<children>
																	<editfield>
																		<properties size="35"/>
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
												</children>
											</tgridcell>
											<tgridcell>
												<properties bgcolor="#d0d8df"/>
												<children>
													<template subtype="element" match="aas:note">
														<children>
															<multilinefield>
																<properties cols="35" rows="3"/>
																<children>
																	<content/>
																</children>
															</multilinefield>
														</children>
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
			</globaltemplate>
		</children>
	</globalparts>
	<pagelayout>
		<properties pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="1" paperheight="11in" papermarginbottom="0.79in" papermarginleft="0.6in" papermarginright="0.6in" papermargintop="0.79in" paperwidth="8.5in"/>
	</pagelayout>
	<designfragments/>
</structure>
