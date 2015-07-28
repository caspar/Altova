<?xml version="1.0" encoding="UTF-8"?>
<structure version="7" cssmode="strict" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" embed-images="1">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="f" uri="http://www.xmlspy.com/schemas/formatting"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="$XML" main="1" schemafile="Book.xsd" workingxmlfile="Book.xml">
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
		<rules selector=".info">
			<media>
				<media value="all"/>
			</media>
			<rule background-color="#f6f6ff" border="1px solid navy" color="navy" font-weight="bold" margin-bottom="12px" margin-top="12px" padding="2px"/>
		</rules>
		<rules selector=".explanation">
			<media>
				<media value="all"/>
			</media>
			<rule color="blue" font-style="italic" margin-bottom="6px"/>
		</rules>
	</globalstyles>
	<mainparts>
		<children>
			<globaltemplate match="/" matchtype="named" parttype="main">
				<children>
					<paragraph paragraphtag="h2">
						<styles border-bottom="2px solid navy" color="navy"/>
						<children>
							<text fixtext="Example: Table-of-Contents"/>
						</children>
					</paragraph>
					<paragraph paragraphtag="p">
						<properties class="info"/>
						<children>
							<text fixtext="This example highlights the use of document levels in conjunction with table-of-contents and text references."/>
						</children>
					</paragraph>
					<template match="$XML" matchtype="schemasource">
						<editorproperties elementstodisplay="5"/>
						<children>
							<toc name="toc">
								<children>
									<paragraph paragraphtag="h2">
										<children>
											<text fixtext="Table of Contents"/>
										</children>
									</paragraph>
									<reflevel>
										<children>
											<ref name="toc" createhyperlink="1">
												<children>
													<paragraph>
														<children>
															<field type="ref-entrytext">
																<styles font-size="14pt" font-weight="bold"/>
															</field>
															<field type="ref-leader">
																<styles font-size="14pt" font-weight="bold"/>
															</field>
															<field type="ref-pageref">
																<styles font-size="14pt" font-weight="bold"/>
															</field>
														</children>
													</paragraph>
												</children>
											</ref>
											<reflevel>
												<children>
													<ref name="toc" createhyperlink="1">
														<children>
															<paragraph>
																<styles margin-left="1cm"/>
																<children>
																	<field type="ref-entrytext"/>
																	<field type="ref-leader"/>
																	<field type="ref-pageref"/>
																</children>
															</paragraph>
														</children>
													</ref>
												</children>
											</reflevel>
										</children>
									</reflevel>
								</children>
							</toc>
							<newline/>
							<newline break="page"/>
							<level>
								<children>
									<paragraph paragraphtag="h2">
										<children>
											<marker name="toc">
												<children>
													<num-lvl format="1.1.1"/>
													<text fixtext=" Foreword"/>
												</children>
											</marker>
										</children>
									</paragraph>
									<paragraph paragraphtag="p">
										<properties class="explanation"/>
										<children>
											<text fixtext="Note that the foreword here is statically defined by the design, i.e., not dependent on the XML. From the document structure, the foreword is at the same level as a chapter, so we wrap everything with a Level indicator (yellow markups). "/>
										</children>
									</paragraph>
									<paragraph paragraphtag="p">
										<properties class="explanation"/>
										<children>
											<text fixtext="The heading of the foreword should also become part of the table-of-contents and be properly numbered, so its text is contained within a marker."/>
										</children>
									</paragraph>
								</children>
							</level>
							<newline/>
							<newline break="page"/>
							<paragraph paragraphtag="p">
								<properties class="explanation"/>
								<children>
									<text fixtext="Here the main matter of the document is generated from the provided XML file."/>
								</children>
							</paragraph>
							<template match="book" matchtype="schemagraphitem">
								<editorproperties elementstodisplay="5"/>
								<children>
									<content/>
								</children>
							</template>
							<newline break="page"/>
							<level>
								<children>
									<paragraph paragraphtag="h2">
										<children>
											<marker xpath="." name="toc">
												<children>
													<num-lvl format="1.1.1"/>
													<text fixtext=" Appendix"/>
												</children>
											</marker>
										</children>
									</paragraph>
									<paragraph paragraphtag="p">
										<properties class="explanation"/>
										<children>
											<text fixtext="As with the foreword, the appendix here again is a static text that is written verbatim into every generated output document. as with the foreword, we wrap the appendix into a static level objects, and mark the header text for inclusion into the table-of-contents."/>
										</children>
									</paragraph>
								</children>
							</level>
						</children>
					</template>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts>
		<children>
			<globaltemplate match="chapter" matchtype="schemagraphitem">
				<children>
					<template match="chapter" matchtype="schemagraphitem" levelflag="1">
						<editorproperties elementstodisplay="5"/>
						<children>
							<condition>
								<children>
									<conditionbranch xpath="preceding::chapter">
										<children>
											<newline break="page"/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<template match="heading" matchtype="schemagraphitem">
								<editorproperties elementstodisplay="5"/>
								<children>
									<paragraph paragraphtag="h2">
										<children>
											<marker xpath="." name="toc">
												<children>
													<num-lvl format="1.1.1"/>
													<text fixtext=" "/>
													<content/>
												</children>
											</marker>
										</children>
									</paragraph>
								</children>
							</template>
							<content restofcontents="1"/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="subchapter" matchtype="schemagraphitem">
				<children>
					<template match="subchapter" matchtype="schemagraphitem" levelflag="1">
						<editorproperties elementstodisplay="5"/>
						<children>
							<template match="heading" matchtype="schemagraphitem">
								<editorproperties elementstodisplay="5"/>
								<children>
									<paragraph paragraphtag="h3">
										<children>
											<marker xpath="." name="toc">
												<children>
													<num-lvl format="1.1.1"/>
													<text fixtext=" "/>
													<content/>
												</children>
											</marker>
										</children>
									</paragraph>
								</children>
							</template>
							<content restofcontents="1"/>
						</children>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate match="p" matchtype="schemagraphitem">
				<children>
					<template match="p" matchtype="schemagraphitem">
						<editorproperties elementstodisplay="5"/>
						<children>
							<paragraph paragraphtag="p">
								<children>
									<content/>
								</children>
							</paragraph>
						</children>
					</template>
				</children>
			</globaltemplate>
		</children>
	</globalparts>
	<pagelayout/>
	<designfragments/>
</structure>
