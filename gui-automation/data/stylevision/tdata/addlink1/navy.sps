<?xml version="1.0" encoding="UTF-8"?>
<structure version="7" cssmode="strict" relativeto="*XML" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" embed-images="1">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="n1" uri="http://www.w3.org/1999/XSL/Format"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="$XML" main="1" schemafile="050512navy-etm-mod_wrycan.dtd" workingxmlfile="test.xml">
				<xmltablesupport standard="CALS">
					<usertags/>
				</xmltablesupport>
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
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts>
		<children>
			<globaltemplate match="appendix" matchtype="schemagraphitem">
				<children>
					<template match="appendix" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<paragraph>
								<properties align="center"/>
								<children>
									<text fixtext="APPENDIX">
										<styles font-weight="bold"/>
									</text>
									<text fixtext=" "/>
									<condition>
										<children>
											<conditionbranch xpath="@tocentry  = 1">
												<children>
													<autocalc xpath="position()">
														<styles font-weight="bold"/>
													</autocalc>
												</children>
											</conditionbranch>
										</children>
									</condition>
									<text fixtext=" - "/>
									<template match="title" matchtype="schemagraphitem">
										<editorproperties elementstodisplay="1" elementstofetch="all"/>
										<children>
											<content>
												<styles font-weight="bold" text-decoration="underline"/>
											</content>
										</children>
									</template>
								</children>
							</paragraph>
							<newline/>
							<newline/>
							<content restofcontents="1"/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="body" matchtype="schemagraphitem">
				<children>
					<template match="body" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="brk" matchtype="schemagraphitem">
				<children>
					<template match="brk" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<condition>
								<children>
									<conditionbranch xpath="@type = &apos;page&apos;">
										<children>
											<text fixtext="---------- PAGE BREAK ----------">
												<styles color="#008000"/>
											</text>
										</children>
									</conditionbranch>
									<conditionbranch>
										<children>
											<newline/>
											<content/>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="caution" matchtype="schemagraphitem">
				<children>
					<template match="caution" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<paragraph>
								<properties align="center"/>
								<children>
									<table>
										<properties border="1"/>
										<styles font-weight="bold"/>
										<children>
											<tablebody>
												<children>
													<tablerow>
														<children>
															<tablecell>
																<children>
																	<condition>
																		<children>
																			<conditionbranch xpath="@type = &apos;italic&apos;">
																				<children>
																					<text fixtext="CAUTION">
																						<styles font-style="italic" font-weight="bold"/>
																					</text>
																				</children>
																			</conditionbranch>
																			<conditionbranch>
																				<children>
																					<text fixtext="CAUTION">
																						<styles font-weight="bold"/>
																					</text>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																</children>
															</tablecell>
														</children>
													</tablerow>
												</children>
											</tablebody>
										</children>
									</table>
									<newline/>
									<table>
										<properties border="0" width="80%"/>
										<children>
											<tablebody>
												<children>
													<tablerow>
														<children>
															<tablecell>
																<properties align="left"/>
																<children>
																	<paragraph paragraphtag="center">
																		<children>
																			<content/>
																		</children>
																	</paragraph>
																</children>
															</tablecell>
														</children>
													</tablerow>
												</children>
											</tablebody>
										</children>
									</table>
								</children>
							</paragraph>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="change" matchtype="schemagraphitem">
				<children>
					<template match="change" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="chapter" matchtype="schemagraphitem">
				<children>
					<template match="chapter" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<paragraph>
								<properties align="center"/>
								<children>
									<condition>
										<children>
											<conditionbranch xpath="title/docno">
												<children>
													<template match="title" matchtype="schemagraphitem">
														<editorproperties elementstodisplay="1" elementstofetch="all"/>
														<children>
															<template match="docno" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<content>
																		<styles font-weight="bold"/>
																	</content>
																</children>
															</template>
														</children>
													</template>
													<newline/>
													<template match="title" matchtype="schemagraphitem">
														<editorproperties elementstodisplay="1" elementstofetch="all"/>
														<children>
															<template match="docno" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
															</template>
															<template match="change" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
															</template>
															<content restofcontents="1">
																<styles font-family="Arial" font-size="14pt" font-weight="bold"/>
															</content>
														</children>
													</template>
													<newline/>
													<template match="title" matchtype="schemagraphitem">
														<editorproperties elementstodisplay="1" elementstofetch="all"/>
														<children>
															<template match="change" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<content>
																		<styles font-weight="bold"/>
																	</content>
																</children>
															</template>
														</children>
													</template>
												</children>
											</conditionbranch>
											<conditionbranch xpath="not(title/docno)">
												<children>
													<text fixtext="CHAPTER ">
														<styles font-family="Arial" font-size="14pt" font-weight="bold"/>
													</text>
													<template match="title" matchtype="schemagraphitem">
														<editorproperties elementstodisplay="1" elementstofetch="all"/>
														<children>
															<content>
																<styles font-family="Arial" font-size="14pt" font-weight="bold" text-decoration="underline"/>
															</content>
														</children>
													</template>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
							</paragraph>
							<newline/>
							<newline/>
							<content restofcontents="1">
								<styles font-family="Times New Roman" font-size="10pt"/>
							</content>
							<newline/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="chart" matchtype="schemagraphitem">
				<children>
					<template match="chart" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="chgdate" matchtype="schemagraphitem">
				<children>
					<template match="chgdate" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="chgnum" matchtype="schemagraphitem">
				<children>
					<template match="chgnum" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="chgrec" matchtype="schemagraphitem">
				<children>
					<template match="chgrec" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<paragraph paragraphtag="center">
								<children>
									<text fixtext="RECORD OF CHANGES">
										<styles font-weight="bold"/>
									</text>
								</children>
							</paragraph>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="colspec" matchtype="schemagraphitem">
				<children>
					<template match="colspec" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="contents" matchtype="schemagraphitem">
				<children>
					<template match="contents" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<text fixtext="Table of Contents goes here ">
								<styles font-weight="bold"/>
							</text>
							<content/>
							<newline/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="contractno" matchtype="schemagraphitem">
				<children>
					<template match="contractno" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="danger" matchtype="schemagraphitem">
				<children>
					<template match="danger" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<paragraph paragraphtag="center">
								<children>
									<newline/>
									<condition>
										<children>
											<conditionbranch xpath="@type = &apos;italic&apos;">
												<children>
													<text fixtext="DANGER">
														<styles color="#FF0000" font-style="italic" font-weight="bold"/>
													</text>
												</children>
											</conditionbranch>
											<conditionbranch>
												<children>
													<text fixtext="DANGER">
														<styles color="#FF0000" font-weight="bold"/>
													</text>
												</children>
											</conditionbranch>
										</children>
									</condition>
								</children>
							</paragraph>
							<paragraph paragraphtag="center">
								<children>
									<content/>
								</children>
							</paragraph>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="doctype" matchtype="schemagraphitem">
				<children>
					<template match="doctype" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="emphasis" matchtype="schemagraphitem">
				<children>
					<template match="emphasis" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<condition>
								<children>
									<conditionbranch xpath="@emph = &apos;b&apos; or string-length(@emph) = 0">
										<children>
											<content>
												<styles font-weight="bold"/>
											</content>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@emph = &apos;i&apos;">
										<children>
											<content>
												<styles font-style="italic"/>
											</content>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@emph = &apos;u&apos;">
										<children>
											<content>
												<styles text-decoration="underline"/>
											</content>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@emph = &apos;q&apos;">
										<children>
											<text fixtext="&quot;"/>
											<content/>
											<text fixtext="&quot;"/>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@emph = &apos;s&apos;">
										<children>
											<content>
												<styles text-decoration="line-through"/>
											</content>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@emph = &apos;bo&apos;">
										<children>
											<content>
												<styles font-weight="bold" text-decoration="overline"/>
											</content>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@emph = &apos;bu&apos;">
										<children>
											<content>
												<styles font-weight="bold" text-decoration="underline"/>
											</content>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@emph = &apos;o&apos;">
										<children>
											<content>
												<styles text-decoration="overline"/>
											</content>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="entry" matchtype="schemagraphitem">
				<children>
					<template match="entry" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content>
								<styles font-family="Times New Roman" font-size="10pt"/>
							</content>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="entrytbl" matchtype="schemagraphitem">
				<children>
					<template match="entrytbl" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="eqpttype" matchtype="schemagraphitem">
				<children>
					<template match="eqpttype" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="extref" matchtype="schemagraphitem">
				<children>
					<template match="extref" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="figure" matchtype="schemagraphitem">
				<children>
					<template match="figure" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<table>
								<properties border="1" width="100%"/>
								<children>
									<tablebody>
										<children>
											<tablerow>
												<children>
													<tablecell>
														<children>
															<text fixtext="Figure ">
																<styles font-weight="bold"/>
															</text>
															<autocalc xpath="count(preceding::figure[title]) + 1">
																<styles font-weight="bold"/>
															</autocalc>
															<newline/>
															<text fixtext="Title:">
																<styles font-weight="bold"/>
															</text>
															<text fixtext=" "/>
															<template match="title" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<content/>
																</children>
															</template>
															<newline/>
															<text fixtext="Orientation:">
																<styles font-weight="bold"/>
															</text>
															<text fixtext=" "/>
															<template match="@orient" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<combobox>
																		<children>
																			<content>
																				<format datatype="Enumeration"/>
																			</content>
																		</children>
																		<selectoption description="landscape" value="land"/>
																		<selectoption description="portrait" value="port"/>
																	</combobox>
																</children>
															</template>
															<newline/>
															<text fixtext="Add to List of Figures?:">
																<styles font-weight="bold"/>
															</text>
															<text fixtext=" "/>
															<template match="@tocentry" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<combobox>
																		<children>
																			<content>
																				<format datatype="Enumeration"/>
																			</content>
																		</children>
																		<selectoption description="Yes" value="1"/>
																		<selectoption description="No" value="0"/>
																	</combobox>
																</children>
															</template>
															<newline/>
															<text fixtext="ID:">
																<styles font-weight="bold"/>
															</text>
															<text fixtext=" "/>
															<template match="@id" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<content>
																		<format datatype="ID"/>
																	</content>
																</children>
															</template>
															<newline/>
															<text fixtext="Label:">
																<styles font-weight="bold"/>
															</text>
															<text fixtext=" "/>
															<template match="@label" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<content>
																		<format datatype="CDATA"/>
																	</content>
																</children>
															</template>
															<newline/>
															<text fixtext="Change Level:">
																<styles font-weight="bold"/>
															</text>
															<text fixtext=" "/>
															<template match="@chglvl" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<content>
																		<format datatype="CDATA"/>
																	</content>
																</children>
															</template>
															<newline/>
															<text fixtext="Delete Change Level:">
																<styles font-weight="bold"/>
															</text>
															<text fixtext=" "/>
															<template match="@delchlvl" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<content>
																		<format datatype="CDATA"/>
																	</content>
																</children>
															</template>
															<newline/>
															<text fixtext="Insert Change Level:">
																<styles font-weight="bold"/>
															</text>
															<text fixtext=" "/>
															<template match="@inschlvl" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<content>
																		<format datatype="CDATA"/>
																	</content>
																</children>
															</template>
															<newline/>
															<text fixtext="Security:">
																<styles font-weight="bold"/>
															</text>
															<text fixtext=" "/>
															<template match="@security" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<combobox>
																		<children>
																			<content>
																				<format datatype="Enumeration"/>
																			</content>
																		</children>
																		<selectoption description="Unclassified" value="u"/>
																		<selectoption description="Confidential" value="c"/>
																		<selectoption description="Secret" value="s"/>
																		<selectoption description="Top Secret" value="ts"/>
																	</combobox>
																</children>
															</template>
															<newline/>
															<content match="graphic" matchtype="schemagraphitem"/>
															<newline/>
															<content match="subfig" matchtype="schemagraphitem"/>
															<newline/>
															<content match="subfoldout" matchtype="schemagraphitem"/>
															<newline/>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</tablebody>
								</children>
							</table>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="foldout" matchtype="schemagraphitem">
				<children>
					<template match="foldout" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="foreword" matchtype="schemagraphitem">
				<children>
					<template match="foreword" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<paragraph paragraphtag="center">
								<children>
									<text fixtext="FOREWORD">
										<styles font-weight="bold"/>
									</text>
								</children>
							</paragraph>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="fsection" matchtype="schemagraphitem">
				<children>
					<template match="fsection" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="glossary" matchtype="schemagraphitem">
				<children>
					<template match="glossary" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="graphic" matchtype="schemagraphitem">
				<children>
					<template match="graphic" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<table>
								<properties border="1" width="100%"/>
								<styles font-weight="bold"/>
								<children>
									<tablebody>
										<children>
											<tablerow>
												<children>
													<tablecell>
														<children>
															<text fixtext="Graphic">
																<styles font-weight="bold"/>
															</text>
															<newline/>
															<text fixtext="Name of Unparsed Entity (used to reference external graphic):">
																<styles font-weight="bold"/>
															</text>
															<text fixtext=" "/>
															<template match="@boardno" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<content>
																		<format datatype="ENTITY"/>
																	</content>
																</children>
															</template>
															<newline/>
															<text fixtext="Graphic Style: "/>
															<template match="@graphsty" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<combobox>
																		<children>
																			<content>
																				<format datatype="Enumeration"/>
																			</content>
																		</children>
																		<selectoption description="outline" value="outline"/>
																		<selectoption description="both" value="both"/>
																		<selectoption description="inline" value="inline"/>
																	</combobox>
																</children>
															</template>
															<newline/>
															<text fixtext="Reproduction Width: "/>
															<template match="@reprowid" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<content>
																		<format datatype="NMTOKEN"/>
																	</content>
																</children>
															</template>
															<text fixtext=" "/>
															<newline/>
															<text fixtext="Reproduction Depth: "/>
															<template match="@reprodep" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<content>
																		<format datatype="NMTOKEN"/>
																	</content>
																</children>
															</template>
															<newline/>
															<text fixtext="Scale To Fit?: "/>
															<template match="@scalefit" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<combobox>
																		<children>
																			<content>
																				<format datatype="Enumeration"/>
																			</content>
																		</children>
																		<selectoption description="Yes" value="1"/>
																		<selectoption description="No" value="0"/>
																	</combobox>
																</children>
															</template>
															<newline/>
															<newline/>
															<template match="@boardno" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<image>
																		<properties border="0"/>
																		<target>
																			<entity value="."/>
																		</target>
																		<imagesource>
																			<entity value="."/>
																		</imagesource>
																	</image>
																</children>
															</template>
															<newline/>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</tablebody>
								</children>
							</table>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="idinfo" matchtype="schemagraphitem">
				<children>
					<template match="idinfo" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<text fixtext="Publication Number: ">
								<styles font-weight="bold"/>
							</text>
							<content match="pubno" matchtype="schemagraphitem"/>
							<newline/>
							<text fixtext="NSN: ">
								<styles font-weight="bold"/>
							</text>
							<content match="nsn" matchtype="schemagraphitem"/>
							<newline/>
							<text fixtext="Change Number:">
								<styles font-weight="bold"/>
							</text>
							<text fixtext=" "/>
							<content match="chgnum" matchtype="schemagraphitem"/>
							<newline/>
							<text fixtext="Revision Number: ">
								<styles font-weight="bold"/>
							</text>
							<content match="revnum" matchtype="schemagraphitem"/>
							<newline/>
							<content match="titleblk" matchtype="schemagraphitem"/>
							<newline/>
							<text fixtext="Manufacturer:">
								<styles font-weight="bold"/>
							</text>
							<text fixtext=" "/>
							<content match="mfr" matchtype="schemagraphitem"/>
							<newline/>
							<text fixtext="Contract Number:">
								<styles font-weight="bold"/>
							</text>
							<text fixtext=" "/>
							<content match="contractno" matchtype="schemagraphitem"/>
							<newline/>
							<text fixtext="Notice:">
								<styles font-weight="bold"/>
							</text>
							<text fixtext=" "/>
							<content match="notice" matchtype="schemagraphitem"/>
							<newline/>
							<text fixtext="Publication Date:">
								<styles font-weight="bold"/>
							</text>
							<text fixtext=" "/>
							<content match="pubdate" matchtype="schemagraphitem"/>
							<newline/>
							<text fixtext="Change Date:">
								<styles font-weight="bold"/>
							</text>
							<text fixtext=" "/>
							<content match="chgdate" matchtype="schemagraphitem"/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="illuslist" matchtype="schemagraphitem">
				<children>
					<template match="illuslist" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<text fixtext="List Of Illustrations goes here">
								<styles font-weight="bold"/>
							</text>
							<newline/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="initials" matchtype="schemagraphitem">
				<children>
					<template match="initials" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<text fixtext="Initials: ______">
								<styles color="#008000"/>
							</text>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="intro" matchtype="schemagraphitem">
				<children>
					<template match="intro" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<paragraph paragraphtag="center">
								<children>
									<text fixtext="Introduction">
										<styles font-weight="bold"/>
									</text>
								</children>
							</paragraph>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="item" matchtype="schemagraphitem">
				<children>
					<template match="item" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="lep" matchtype="schemagraphitem">
				<children>
					<template match="lep" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<paragraph paragraphtag="center">
								<children>
									<text fixtext="LIST OF EFFECTIVE PAGES">
										<styles font-weight="bold"/>
									</text>
								</children>
							</paragraph>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="lepchange" matchtype="schemagraphitem">
				<children>
					<template match="lepchange" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="lepchanges" matchtype="schemagraphitem">
				<children>
					<template match="lepchanges" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<text fixtext="Changes:"/>
							<newline/>
							<table>
								<properties border="1"/>
								<children>
									<tableheader>
										<children>
											<tablerow>
												<children>
													<tablecell>
														<children>
															<text fixtext="Page Number"/>
														</children>
													</tablecell>
													<tablecell>
														<children>
															<text fixtext="Change Number"/>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</tableheader>
									<tablebody>
										<children>
											<template match="lepchange" matchtype="schemagraphitem">
												<editorproperties elementstodisplay="1" elementstofetch="all"/>
												<children>
													<tablerow>
														<children>
															<tablecell>
																<children>
																	<template match="leppagenumber" matchtype="schemagraphitem">
																		<editorproperties elementstodisplay="1" elementstofetch="all"/>
																		<children>
																			<content/>
																		</children>
																	</template>
																</children>
															</tablecell>
															<tablecell>
																<children>
																	<template match="lepchangenumber" matchtype="schemagraphitem">
																		<editorproperties elementstodisplay="1" elementstofetch="all"/>
																		<children>
																			<content/>
																		</children>
																	</template>
																</children>
															</tablecell>
														</children>
													</tablerow>
												</children>
											</template>
										</children>
									</tablebody>
								</children>
							</table>
							<newline/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="leprevisions" matchtype="schemagraphitem">
				<children>
					<template match="leprevisions" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<text fixtext="Revisions:"/>
							<newline/>
							<table>
								<properties border="1"/>
								<children>
									<tableheader>
										<children>
											<tablerow>
												<children>
													<tablecell headercell="1">
														<children>
															<text fixtext="Comment"/>
														</children>
													</tablecell>
													<tablecell headercell="1">
														<children>
															<text fixtext="Date"/>
														</children>
													</tablecell>
													<tablecell headercell="1">
														<children>
															<text fixtext="Title"/>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</tableheader>
									<tablebody>
										<children>
											<template match="leprevision" matchtype="schemagraphitem">
												<editorproperties elementstodisplay="1" elementstofetch="all"/>
												<children>
													<tablerow>
														<children>
															<tablecell>
																<children>
																	<template match="lepcomment" matchtype="schemagraphitem">
																		<editorproperties elementstodisplay="1" elementstofetch="all"/>
																		<children>
																			<content/>
																		</children>
																	</template>
																</children>
															</tablecell>
															<tablecell>
																<children>
																	<template match="lepdate" matchtype="schemagraphitem">
																		<editorproperties elementstodisplay="1" elementstofetch="all"/>
																		<children>
																			<content/>
																		</children>
																	</template>
																</children>
															</tablecell>
															<tablecell>
																<children>
																	<template match="leptitle" matchtype="schemagraphitem">
																		<editorproperties elementstodisplay="1" elementstofetch="all"/>
																		<children>
																			<content/>
																		</children>
																	</template>
																</children>
															</tablecell>
														</children>
													</tablerow>
												</children>
											</template>
										</children>
									</tablebody>
								</children>
							</table>
							<newline/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="maintlvl" matchtype="schemagraphitem">
				<children>
					<template match="maintlvl" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="mfr" matchtype="schemagraphitem">
				<children>
					<template match="mfr" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content>
								<styles text-decoration="underline"/>
							</content>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="modelno" matchtype="schemagraphitem">
				<children>
					<template match="modelno" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="note" matchtype="schemagraphitem">
				<children>
					<template match="note" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<paragraph>
								<properties align="center"/>
								<children>
									<condition>
										<children>
											<conditionbranch xpath="@type = &apos;italic&apos;">
												<children>
													<text fixtext="NOTE">
														<styles font-style="italic" font-weight="bold"/>
													</text>
												</children>
											</conditionbranch>
											<conditionbranch>
												<children>
													<text fixtext="NOTE">
														<styles font-weight="bold"/>
													</text>
												</children>
											</conditionbranch>
										</children>
									</condition>
									<newline/>
									<table>
										<properties width="80%"/>
										<children>
											<tablebody>
												<children>
													<tablerow>
														<children>
															<tablecell>
																<children>
																	<content/>
																</children>
															</tablecell>
														</children>
													</tablerow>
												</children>
											</tablebody>
										</children>
									</table>
									<newline/>
								</children>
							</paragraph>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="notice" matchtype="schemagraphitem">
				<children>
					<template match="notice" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="nsn" matchtype="schemagraphitem">
				<children>
					<template match="nsn" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="para" matchtype="schemagraphitem">
				<children>
					<template match="para" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<paragraph paragraphtag="p">
								<children>
									<content>
										<styles font-family="Times New Roman" font-size="10pt"/>
									</content>
								</children>
							</paragraph>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="para0" matchtype="schemagraphitem">
				<children>
					<template match="para0" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<condition>
								<children>
									<conditionbranch xpath="../../../title/docno">
										<children>
											<autocalc xpath="concat(count(ancestor::section/preceding-sibling::section) + 1,&apos;.&apos;,count(ancestor::subsection/preceding-sibling::subsection) + 1,&apos;.&apos;,position())">
												<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
											</autocalc>
											<text fixtext=" ">
												<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
											</text>
											<template match="title" matchtype="schemagraphitem">
												<editorproperties elementstodisplay="1" elementstofetch="all"/>
												<children>
													<content>
														<styles font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
													</content>
													<text fixtext=".">
														<styles font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
													</text>
												</children>
											</template>
										</children>
									</conditionbranch>
									<conditionbranch>
										<children>
											<text fixtext="Para0 ">
												<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
											</text>
											<autocalc xpath="concat(count(ancestor::section/preceding-sibling::section) + 1,&apos;.&apos;,count(ancestor::subsection/preceding-sibling::subsection) + 1,&apos;.&apos;,position())">
												<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
											</autocalc>
											<text fixtext=" ">
												<styles font-family="ari" font-weight="bold"/>
											</text>
											<template match="title" matchtype="schemagraphitem">
												<editorproperties elementstodisplay="1" elementstofetch="all"/>
												<children>
													<content>
														<styles font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
													</content>
													<text fixtext=".">
														<styles font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
													</text>
												</children>
											</template>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<newline/>
							<content restofcontents="1"/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="preface" matchtype="schemagraphitem">
				<children>
					<template match="preface" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<paragraph paragraphtag="center">
								<children>
									<text fixtext="PREFACE">
										<styles font-weight="bold"/>
									</text>
								</children>
							</paragraph>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="prtitle" matchtype="schemagraphitem">
				<children>
					<template match="prtitle" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="pubdate" matchtype="schemagraphitem">
				<children>
					<template match="pubdate" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="pubno" matchtype="schemagraphitem">
				<children>
					<template match="pubno" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="randlist" matchtype="schemagraphitem">
				<children>
					<template match="randlist" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<text fixtext="Prefix: "/>
							<template match="@prefix" matchtype="schemagraphitem">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<children>
									<content>
										<format datatype="CDATA"/>
									</content>
								</children>
							</template>
							<newline/>
							<text fixtext="Label: "/>
							<template match="@label" matchtype="schemagraphitem">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<children>
									<content>
										<format datatype="CDATA"/>
									</content>
								</children>
							</template>
							<newline/>
							<template match="title" matchtype="schemagraphitem">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<children>
									<content/>
								</children>
							</template>
							<newline/>
							<condition>
								<children>
									<conditionbranch xpath="string-length(@label) = 0">
										<children>
											<list>
												<properties start="1" type="disc"/>
												<styles margin-bottom="0" margin-top="0"/>
												<children>
													<template match="item" matchtype="schemagraphitem">
														<editorproperties elementstodisplay="1" elementstofetch="all"/>
														<children>
															<listrow>
																<children>
																	<content/>
																</children>
															</listrow>
														</children>
													</template>
												</children>
											</list>
										</children>
									</conditionbranch>
									<conditionbranch>
										<children>
											<list>
												<properties start="1"/>
												<styles margin-bottom="0" margin-top="0"/>
												<children>
													<template match="item" matchtype="schemagraphitem">
														<editorproperties elementstodisplay="1" elementstofetch="all"/>
														<children>
															<listrow>
																<children>
																	<content/>
																</children>
															</listrow>
														</children>
													</template>
												</children>
											</list>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<newline/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="revnum" matchtype="schemagraphitem">
				<children>
					<template match="revnum" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="safesum" matchtype="schemagraphitem">
				<children>
					<template match="safesum" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<paragraph paragraphtag="center">
								<children>
									<text fixtext="SAFETY SUMMARY">
										<styles font-weight="bold"/>
									</text>
									<newline/>
									<text fixtext="GENERAL SAFETY NOTICES">
										<styles font-weight="bold"/>
									</text>
								</children>
							</paragraph>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="seal" matchtype="schemagraphitem">
				<children>
					<template match="seal" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<paragraph paragraphtag="center">
								<children>
									<text fixtext="SEAL">
										<styles font-weight="bold"/>
									</text>
								</children>
							</paragraph>
							<newline/>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="section" matchtype="schemagraphitem">
				<children>
					<template match="section" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<condition>
								<children>
									<conditionbranch xpath="../title/docno">
										<children>
											<autocalc xpath="position()">
												<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
											</autocalc>
											<text fixtext=" - ">
												<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
											</text>
											<template match="title" matchtype="schemagraphitem">
												<editorproperties elementstodisplay="1" elementstofetch="all"/>
												<children>
													<content>
														<styles font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
													</content>
													<text fixtext=".">
														<styles font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
													</text>
												</children>
											</template>
										</children>
									</conditionbranch>
									<conditionbranch>
										<children>
											<text fixtext="Section ">
												<styles font-family="Arial" font-weight="bold"/>
											</text>
											<autocalc xpath="position()">
												<styles font-family="Arial" font-weight="bold"/>
											</autocalc>
											<text fixtext=" ">
												<styles font-family="Arial" font-weight="bold"/>
											</text>
											<template match="title" matchtype="schemagraphitem">
												<editorproperties elementstodisplay="1" elementstofetch="all"/>
												<children>
													<content>
														<styles font-family="Arial" font-weight="bold" text-decoration="underline"/>
													</content>
													<text fixtext=".">
														<styles font-family="Arial" font-weight="bold" text-decoration="underline"/>
													</text>
												</children>
											</template>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<newline/>
							<newline/>
							<content restofcontents="1"/>
							<newline/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="seqlist" matchtype="schemagraphitem">
				<children>
					<template match="seqlist" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<text fixtext="Prefix: "/>
							<template match="@prefix" matchtype="schemagraphitem">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<children>
									<content>
										<styles margin-bottom="0" margin-top="0"/>
										<format datatype="CDATA"/>
									</content>
								</children>
							</template>
							<newline/>
							<text fixtext="Number Style:"/>
							<template match="@numstyle" matchtype="schemagraphitem">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<children>
									<combobox>
										<styles margin-bottom="0" margin-top="0"/>
										<children>
											<content>
												<format datatype="Enumeration"/>
											</content>
										</children>
										<selectoption description="1" value="arabic"/>
										<selectoption description="A" value="alphauc"/>
										<selectoption description="a" value="alphalc"/>
										<selectoption description="i" value="romanlc"/>
										<selectoption description="I" value="romanuc"/>
									</combobox>
								</children>
							</template>
							<newline/>
							<text fixtext="Label: "/>
							<template match="@label" matchtype="schemagraphitem">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<children>
									<content>
										<format datatype="CDATA"/>
									</content>
								</children>
							</template>
							<newline/>
							<template match="title" matchtype="schemagraphitem">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<children>
									<content/>
								</children>
							</template>
							<newline/>
							<condition>
								<children>
									<conditionbranch xpath="@numstyle = &apos;alphalc&apos;">
										<children>
											<list ordered="1">
												<properties start="1" type="a"/>
												<styles margin-bottom="0" margin-top="0"/>
												<children>
													<template match="item" matchtype="schemagraphitem">
														<editorproperties elementstodisplay="1" elementstofetch="all"/>
														<children>
															<listrow>
																<styles margin-bottom="0" margin-top="0"/>
																<children>
																	<condition>
																		<children>
																			<conditionbranch xpath="@label = &apos;signature&apos;">
																				<children>
																					<text fixtext="____"/>
																				</children>
																			</conditionbranch>
																		</children>
																	</condition>
																	<content/>
																</children>
															</listrow>
														</children>
													</template>
												</children>
											</list>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@numstyle = &apos;alphauc&apos;">
										<children>
											<list ordered="1">
												<properties start="1" type="A"/>
												<styles margin-bottom="0" margin-top="0"/>
												<children>
													<template match="item" matchtype="schemagraphitem">
														<editorproperties elementstodisplay="1" elementstofetch="all"/>
														<children>
															<listrow>
																<styles margin-bottom="0" margin-top="0"/>
																<children>
																	<content/>
																</children>
															</listrow>
														</children>
													</template>
												</children>
											</list>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@numstyle = &apos;romanlc&apos;">
										<children>
											<list ordered="1">
												<properties start="1" type="i"/>
												<styles margin-bottom="0" margin-top="0"/>
												<children>
													<template match="item" matchtype="schemagraphitem">
														<editorproperties elementstodisplay="1" elementstofetch="all"/>
														<children>
															<listrow>
																<styles margin-bottom="0" margin-top="0"/>
																<children>
																	<content/>
																</children>
															</listrow>
														</children>
													</template>
												</children>
											</list>
										</children>
									</conditionbranch>
									<conditionbranch xpath="@numstyle = &apos;romanuc&apos;">
										<children>
											<list ordered="1">
												<properties start="1" type="I"/>
												<styles margin-bottom="0" margin-top="0"/>
												<children>
													<template match="item" matchtype="schemagraphitem">
														<editorproperties elementstodisplay="1" elementstofetch="all"/>
														<children>
															<listrow>
																<styles margin-bottom="0" margin-top="0"/>
																<children>
																	<content/>
																</children>
															</listrow>
														</children>
													</template>
												</children>
											</list>
										</children>
									</conditionbranch>
									<conditionbranch>
										<children>
											<list ordered="1">
												<properties start="1" type="1"/>
												<styles margin-bottom="0" margin-top="0"/>
												<children>
													<template match="item" matchtype="schemagraphitem">
														<editorproperties elementstodisplay="1" elementstofetch="all"/>
														<children>
															<listrow>
																<styles margin-bottom="0" margin-top="0"/>
																<children>
																	<content/>
																</children>
															</listrow>
														</children>
													</template>
												</children>
											</list>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<newline/>
							<newline/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="signature" matchtype="schemagraphitem">
				<children>
					<template match="signature" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<text fixtext="Signature: ____________________">
								<styles color="#008000"/>
							</text>
							<content>
								<styles line-height="0.5in"/>
							</content>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="soc" matchtype="schemagraphitem">
				<children>
					<template match="soc" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<paragraph>
								<properties align="center"/>
								<children>
									<condition>
										<children>
											<conditionbranch xpath="@type = &apos;italic&apos;">
												<children>
													<text fixtext="SOC">
														<styles font-style="italic" font-weight="bold"/>
													</text>
												</children>
											</conditionbranch>
											<conditionbranch>
												<children>
													<text fixtext="SOC">
														<styles font-weight="bold"/>
													</text>
												</children>
											</conditionbranch>
										</children>
									</condition>
									<newline/>
									<table>
										<properties width="80%"/>
										<children>
											<tablebody>
												<children>
													<tablerow>
														<children>
															<tablecell>
																<children>
																	<content/>
																</children>
															</tablecell>
														</children>
													</tablerow>
												</children>
											</tablebody>
										</children>
									</table>
									<newline/>
								</children>
							</paragraph>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="stitle" matchtype="schemagraphitem">
				<children>
					<template match="stitle" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="subfig" matchtype="schemagraphitem">
				<children>
					<template match="subfig" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<table>
								<properties border="1" width="100%"/>
								<children>
									<tablebody>
										<children>
											<tablerow>
												<children>
													<tablecell>
														<children>
															<text fixtext="Sub Figure ">
																<styles font-weight="bold"/>
															</text>
															<autocalc xpath="count(preceding::figure[title]) + 1">
																<styles font-weight="bold"/>
															</autocalc>
															<text fixtext="."/>
															<autocalc xpath="count(preceding-sibling::subfig) + 1">
																<styles font-weight="bold"/>
															</autocalc>
															<newline/>
															<text fixtext="ID: ">
																<styles font-weight="bold"/>
															</text>
															<template match="@id" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<content>
																		<format datatype="ID"/>
																	</content>
																</children>
															</template>
															<newline/>
															<content match="graphic" matchtype="schemagraphitem"/>
															<newline/>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</tablebody>
								</children>
							</table>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="subfoldout" matchtype="schemagraphitem">
				<children>
					<template match="subfoldout" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<table>
								<properties border="1" width="100%"/>
								<children>
									<tablebody>
										<children>
											<tablerow>
												<children>
													<tablecell>
														<children>
															<text fixtext="Sub Foldout Page Style:">
																<styles font-weight="bold"/>
															</text>
															<text fixtext=" "/>
															<template match="@pgstyle" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<content>
																		<format datatype="NMTOKEN"/>
																	</content>
																</children>
															</template>
															<newline/>
															<content match="subfig" matchtype="schemagraphitem"/>
															<newline/>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</tablebody>
								</children>
							</table>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="subpara1" matchtype="schemagraphitem">
				<children>
					<template match="subpara1" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<condition>
								<children>
									<conditionbranch xpath="../../../../title/docno">
										<children>
											<autocalc xpath="concat(count(ancestor::section/preceding-sibling::section) + 1,&apos;.&apos;,count(ancestor::subsection/preceding-sibling::subsection) + 1,&apos;.&apos;,count(ancestor::para0/preceding-sibling::para0) + 1,&apos;.&apos;,position())">
												<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
											</autocalc>
											<text fixtext=" ">
												<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
											</text>
											<template match="title" matchtype="schemagraphitem">
												<editorproperties elementstodisplay="1" elementstofetch="all"/>
												<children>
													<content>
														<styles font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
													</content>
													<text fixtext=".">
														<styles font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
													</text>
												</children>
											</template>
										</children>
									</conditionbranch>
									<conditionbranch>
										<children>
											<text fixtext="Subpara1 ">
												<styles font-family="Arial" font-weight="bold"/>
											</text>
											<autocalc xpath="concat(count(ancestor::section/preceding-sibling::section) + 1,&apos;.&apos;,count(ancestor::subsection/preceding-sibling::subsection) + 1,&apos;.&apos;,count(ancestor::para0/preceding-sibling::para0) + 1,&apos;.&apos;,position())">
												<styles font-family="Arial" font-weight="bold"/>
											</autocalc>
											<text fixtext=" ">
												<styles font-family="Arial" font-weight="bold"/>
											</text>
											<template match="title" matchtype="schemagraphitem">
												<editorproperties elementstodisplay="1" elementstofetch="all"/>
												<children>
													<content>
														<styles font-family="Arial" font-weight="bold" text-decoration="underline"/>
													</content>
													<text fixtext=".">
														<styles font-weight="bold" text-decoration="underline"/>
													</text>
												</children>
											</template>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<newline/>
							<content restofcontents="1"/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="subpara2" matchtype="schemagraphitem">
				<children>
					<template match="subpara2" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<condition>
								<children>
									<conditionbranch xpath="../../../../../title/docno">
										<children>
											<autocalc xpath="concat(count(ancestor::section/preceding-sibling::section) + 1,&apos;.&apos;,count(ancestor::subsection/preceding-sibling::subsection) + 1,&apos;.&apos;,count(ancestor::para0/preceding-sibling::para0) + 1,&apos;.&apos;,&apos;.&apos;,count(ancestor::subpara1/preceding-sibling::subpara1) + 1,position())">
												<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
											</autocalc>
											<text fixtext=" ">
												<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
											</text>
											<template match="title" matchtype="schemagraphitem">
												<editorproperties elementstodisplay="1" elementstofetch="all"/>
												<children>
													<content>
														<styles font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
													</content>
													<text fixtext=".">
														<styles font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
													</text>
												</children>
											</template>
										</children>
									</conditionbranch>
									<conditionbranch>
										<children>
											<text fixtext="Subpara2 ">
												<styles font-family="Arial" font-weight="bold"/>
											</text>
											<autocalc xpath="concat(count(ancestor::section/preceding-sibling::section) + 1,&apos;.&apos;,count(ancestor::subsection/preceding-sibling::subsection) + 1,&apos;.&apos;,count(ancestor::para0/preceding-sibling::para0) + 1,&apos;.&apos;,count(ancestor::subpara1/preceding-sibling::subpara1) + 1,&apos;.&apos;,position())">
												<styles font-family="Arial" font-weight="bold"/>
											</autocalc>
											<text fixtext=" ">
												<styles font-family="Arial" font-weight="bold"/>
											</text>
											<template match="title" matchtype="schemagraphitem">
												<editorproperties elementstodisplay="1" elementstofetch="all"/>
												<children>
													<content>
														<styles font-family="Arial" font-weight="bold" text-decoration="underline"/>
													</content>
													<text fixtext=".">
														<styles font-weight="bold" text-decoration="underline"/>
													</text>
												</children>
											</template>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<newline/>
							<content restofcontents="1"/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="subpara3" matchtype="schemagraphitem">
				<children>
					<template match="subpara3" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<condition>
								<children>
									<conditionbranch xpath="../../../../../../title/docno">
										<children>
											<autocalc xpath="concat(count(ancestor::section/preceding-sibling::section) + 1,&apos;.&apos;,count(ancestor::subsection/preceding-sibling::subsection) + 1,&apos;.&apos;,count(ancestor::para0/preceding-sibling::para0) + 1,&apos;.&apos;,count(ancestor::subpara1/preceding-sibling::subpara1) + 1,&apos;.&apos;,count(ancestor::subpara2/preceding-sibling::subpara2) + 1,&apos;.&apos;,position())">
												<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
											</autocalc>
											<text fixtext=" ">
												<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
											</text>
											<template match="title" matchtype="schemagraphitem">
												<editorproperties elementstodisplay="1" elementstofetch="all"/>
												<children>
													<content>
														<styles font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
													</content>
													<text fixtext=".">
														<styles font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
													</text>
												</children>
											</template>
										</children>
									</conditionbranch>
									<conditionbranch>
										<children>
											<text fixtext="Subpara3 ">
												<styles font-family="Arial" font-weight="bold"/>
											</text>
											<autocalc xpath="concat(count(ancestor::section/preceding-sibling::section) + 1,&apos;.&apos;,count(ancestor::subsection/preceding-sibling::subsection) + 1,&apos;.&apos;,count(ancestor::para0/preceding-sibling::para0) + 1,&apos;.&apos;,count(ancestor::subpara1/preceding-sibling::subpara1) + 1,&apos;.&apos;,count(ancestor::subpara2/preceding-sibling::subpara2) + 1,&apos;.&apos;,position())">
												<styles font-family="Arial" font-weight="bold"/>
											</autocalc>
											<text fixtext=" ">
												<styles font-family="Arial" font-weight="bold"/>
											</text>
											<template match="title" matchtype="schemagraphitem">
												<editorproperties elementstodisplay="1" elementstofetch="all"/>
												<children>
													<content>
														<styles font-family="Arial" font-weight="bold" text-decoration="underline"/>
													</content>
													<text fixtext=".">
														<styles font-weight="bold" text-decoration="underline"/>
													</text>
												</children>
											</template>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<newline/>
							<content restofcontents="1"/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="subpara4" matchtype="schemagraphitem">
				<children>
					<template match="subpara4" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<condition>
								<children>
									<conditionbranch xpath="../../../../../../../title/docno">
										<children>
											<autocalc xpath="concat(count(ancestor::section/preceding-sibling::section) + 1,&apos;.&apos;,count(ancestor::subsection/preceding-sibling::subsection) + 1,&apos;.&apos;,count(ancestor::para0/preceding-sibling::para0) + 1,&apos;.&apos;,count(ancestor::subpara1/preceding-sibling::subpara1) + 1,&apos;.&apos;,count(ancestor::subpara2/preceding-sibling::subpara2) + 1,&apos;.&apos;,count(ancestor::subpara3/preceding-sibling::subpara3) + 1,&apos;.&apos;,position())">
												<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
											</autocalc>
											<text fixtext=" ">
												<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
											</text>
											<template match="title" matchtype="schemagraphitem">
												<editorproperties elementstodisplay="1" elementstofetch="all"/>
												<children>
													<content>
														<styles font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
													</content>
													<text fixtext=".">
														<styles font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
													</text>
												</children>
											</template>
										</children>
									</conditionbranch>
									<conditionbranch>
										<children>
											<text fixtext="Subpara4 ">
												<styles font-family="Arial" font-weight="bold"/>
											</text>
											<autocalc xpath="concat(count(ancestor::section/preceding-sibling::section) + 1,&apos;.&apos;,count(ancestor::subsection/preceding-sibling::subsection) + 1,&apos;.&apos;,count(ancestor::para0/preceding-sibling::para0) + 1,&apos;.&apos;,count(ancestor::subpara1/preceding-sibling::subpara1) + 1,&apos;.&apos;,count(ancestor::subpara2/preceding-sibling::subpara2) + 1,&apos;.&apos;,count(ancestor::subpara3/preceding-sibling::subpara3) + 1,&apos;.&apos;,position())">
												<styles font-family="Arial" font-weight="bold"/>
											</autocalc>
											<text fixtext=" ">
												<styles font-family="Arial" font-weight="bold"/>
											</text>
											<template match="title" matchtype="schemagraphitem">
												<editorproperties elementstodisplay="1" elementstofetch="all"/>
												<children>
													<content>
														<styles font-family="Arial" font-weight="bold" text-decoration="underline"/>
													</content>
													<text fixtext=".">
														<styles font-weight="bold" text-decoration="underline"/>
													</text>
												</children>
											</template>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<newline/>
							<content restofcontents="1"/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="subscrpt" matchtype="schemagraphitem">
				<children>
					<template match="subscrpt" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content>
								<styles font-size="smaller" vertical-align="sub"/>
							</content>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="subsection" matchtype="schemagraphitem">
				<children>
					<template match="subsection" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<condition>
								<children>
									<conditionbranch xpath="../../title/docno">
										<children>
											<autocalc xpath="concat(count(ancestor::section/preceding-sibling::section) + 1,&apos;.&apos;,position())">
												<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
											</autocalc>
											<text fixtext=" ">
												<styles font-family="Arial" font-size="10pt" font-weight="bold"/>
											</text>
											<template match="title" matchtype="schemagraphitem">
												<editorproperties elementstodisplay="1" elementstofetch="all"/>
												<children>
													<content>
														<styles font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
													</content>
													<text fixtext=".">
														<styles font-family="Arial" font-size="10pt" font-weight="bold" text-decoration="underline"/>
													</text>
												</children>
											</template>
										</children>
									</conditionbranch>
									<conditionbranch>
										<children>
											<text fixtext="Subsection ">
												<styles font-family="Arial" font-weight="bold"/>
											</text>
											<autocalc xpath="concat(count(ancestor::section/preceding-sibling::section) + 1,&apos;.&apos;,position())">
												<styles font-family="Arial" font-weight="bold"/>
											</autocalc>
											<text fixtext=" ">
												<styles font-family="Arial" font-weight="bold"/>
											</text>
											<template match="title" matchtype="schemagraphitem">
												<editorproperties elementstodisplay="1" elementstofetch="all"/>
												<children>
													<content>
														<styles font-family="Arial" font-weight="bold" text-decoration="underline"/>
													</content>
													<text fixtext=".">
														<styles font-weight="bold" text-decoration="underline"/>
													</text>
												</children>
											</template>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<newline/>
							<content restofcontents="1"/>
							<newline/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="supscrpt" matchtype="schemagraphitem">
				<children>
					<template match="supscrpt" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content>
								<styles font-size="smaller" vertical-align="super"/>
							</content>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="symbol" matchtype="schemagraphitem">
				<children>
					<template match="symbol" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="tablelist" matchtype="schemagraphitem">
				<children>
					<template match="tablelist" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<text fixtext="List of Tables goes here">
								<styles font-weight="bold"/>
							</text>
							<text fixtext=" "/>
							<content/>
							<newline/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="title" matchtype="schemagraphitem">
				<children>
					<template match="title" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<newline/>
							<content>
								<styles font-weight="bold"/>
							</content>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="titleblk" matchtype="schemagraphitem">
				<children>
					<template match="titleblk" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<text fixtext="Volume Number: ">
								<styles font-weight="bold"/>
							</text>
							<content match="volnum" matchtype="schemagraphitem"/>
							<newline/>
							<text fixtext="Revision Number:">
								<styles font-weight="bold"/>
							</text>
							<text fixtext=" "/>
							<content match="revnum" matchtype="schemagraphitem"/>
							<newline/>
							<text fixtext="Doc Type:">
								<styles font-weight="bold"/>
							</text>
							<text fixtext=" "/>
							<content match="doctype" matchtype="schemagraphitem"/>
							<newline/>
							<text fixtext="Maintenance Level:">
								<styles font-weight="bold"/>
							</text>
							<text fixtext=" "/>
							<content match="maintlvl" matchtype="schemagraphitem"/>
							<newline/>
							<text fixtext="Primary Title:">
								<styles font-weight="bold"/>
							</text>
							<text fixtext=" "/>
							<content match="prtitle" matchtype="schemagraphitem"/>
							<newline/>
							<text fixtext="ETM Subtitle:">
								<styles font-weight="bold"/>
							</text>
							<text fixtext=" "/>
							<content match="stitle" matchtype="schemagraphitem"/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="volnum" matchtype="schemagraphitem">
				<children>
					<template match="volnum" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<content/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="warning" matchtype="schemagraphitem">
				<children>
					<template match="warning" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<paragraph>
								<properties align="center"/>
								<children>
									<paragraph>
										<properties align="center"/>
										<children>
											<table>
												<properties border="3" cellpadding="2" cellspacing="2"/>
												<children>
													<tablebody>
														<children>
															<tablerow>
																<children>
																	<tablecell>
																		<children>
																			<condition>
																				<children>
																					<conditionbranch xpath="@type = &apos;italic&apos;">
																						<children>
																							<text fixtext="WARNING">
																								<styles font-style="italic" font-weight="bold"/>
																							</text>
																						</children>
																					</conditionbranch>
																					<conditionbranch>
																						<children>
																							<text fixtext="WARNING">
																								<styles font-weight="bold"/>
																							</text>
																						</children>
																					</conditionbranch>
																				</children>
																			</condition>
																		</children>
																	</tablecell>
																</children>
															</tablerow>
														</children>
													</tablebody>
												</children>
											</table>
										</children>
									</paragraph>
									<table>
										<properties border="0" width="80%"/>
										<children>
											<tablebody>
												<children>
													<tablerow>
														<children>
															<tablecell>
																<properties height="22"/>
																<children>
																	<content/>
																</children>
															</tablecell>
														</children>
													</tablerow>
												</children>
											</tablebody>
										</children>
									</table>
								</children>
							</paragraph>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="xref" matchtype="schemagraphitem">
				<children>
					<template match="xref" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="1" elementstofetch="all"/>
						<children>
							<text fixtext="xref id: "/>
							<template match="@xrefid" matchtype="schemagraphitem">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<children>
									<content>
										<format datatype="CDATA"/>
									</content>
								</children>
							</template>
							<text fixtext=" xref type: "/>
							<template match="@xidtype" matchtype="schemagraphitem">
								<editorproperties elementstodisplay="1" elementstofetch="all"/>
								<children>
									<combobox>
										<children>
											<content>
												<format datatype="Enumeration"/>
											</content>
										</children>
										<selectoption description="table" value="table"/>
										<selectoption description="text" value="text"/>
										<selectoption description="note" value="note"/>
										<selectoption description="figure" value="figure"/>
									</combobox>
								</children>
							</template>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="leprevision" matchtype="schemagraphitem">
				<children>
					<table>
						<properties border="1"/>
						<children>
							<tablebody>
								<children>
									<template match="leprevision" matchtype="schemagraphitem">
										<editorproperties elementstodisplay="1" elementstofetch="all"/>
										<children>
											<tablerow>
												<children>
													<tablecell>
														<children>
															<template match="lepcomment" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<content/>
																</children>
															</template>
														</children>
													</tablecell>
													<tablecell>
														<children>
															<template match="lepdate" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<content/>
																</children>
															</template>
														</children>
													</tablecell>
													<tablecell>
														<children>
															<template match="leptitle" matchtype="schemagraphitem">
																<editorproperties elementstodisplay="1" elementstofetch="all"/>
																<children>
																	<content/>
																</children>
															</template>
														</children>
													</tablecell>
												</children>
											</tablerow>
										</children>
									</template>
								</children>
							</tablebody>
						</children>
					</table>
				</children>
			</globaltemplate>
		</children>
	</globalparts>
	<pagelayout>
		<properties pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="1" paperheight="11in" papermarginbottom="0.79in" papermarginleft="0.6in" papermarginright="0.6in" papermargintop="0.79in" paperwidth="8.5in"/>
	</pagelayout>
	<designfragments/>
</structure>
