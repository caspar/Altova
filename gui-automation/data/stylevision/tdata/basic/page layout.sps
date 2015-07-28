<?xml version="1.0" encoding="UTF-8"?>
<structure version="8" cssmode="strict" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1">
	<parameters/>
	<schemasources>
		<namespaces>
			<nspair prefix="f" uri="http://www.xmlspy.com/schemas/formatting"/>
		</namespaces>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="Book.xsd" workingxmlfile="Book.xml">
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
			<globaltemplate subtype="main" match="/">
				<children>
					<paragraph paragraphtag="h2">
						<styles border-bottom="2px solid navy" color="navy" text-align="center"/>
						<children>
							<text fixtext="Example: Page Layout"/>
						</children>
					</paragraph>
					<paragraph paragraphtag="p">
						<properties class="info"/>
						<children>
							<text fixtext="In order to generate nice-looking documents, StyleVision allows you to add a header, footer and cover page to your document. These are defined in special page layout templates."/>
						</children>
					</paragraph>
					<paragraph paragraphtag="p">
						<properties class="explanation"/>
						<children>
							<text fixtext="In order to add a header, footer or cover page, right click on the design tree and choose the appropriate option from the context menu. StyleVision also automatically provides you with some default design for those templates."/>
						</children>
					</paragraph>
					<paragraph paragraphtag="p">
						<properties class="explanation"/>
						<children>
							<text fixtext="For headers and footers you can choose to use the same one for every page, or to alternate between 2 different headers/footers for even and odd pages."/>
						</children>
					</paragraph>
					<paragraph paragraphtag="p">
						<properties class="explanation"/>
						<children>
							<text fixtext="It may be necessary to scroll down to find the page layout templates after the other global templates for chapters, sub-chapters and paragraphs."/>
						</children>
					</paragraph>
					<template subtype="source" match="XML">
						<children>
							<template subtype="element" match="book">
								<children>
									<content/>
								</children>
							</template>
						</children>
					</template>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts>
		<children>
			<globaltemplate subtype="element" match="chapter">
				<children>
					<template subtype="element" levelflag="1" match="chapter">
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
							<template subtype="element" match="heading">
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
			<globaltemplate subtype="element" match="subchapter">
				<children>
					<template subtype="element" levelflag="1" match="subchapter">
						<children>
							<template subtype="element" match="heading">
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
			<globaltemplate subtype="element" match="p">
				<children>
					<template subtype="element" match="p">
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
	<pagelayout>
		<properties paperheight="11.69in" paperwidth="8.27in" size="A4"/>
		<children>
			<globaltemplate subtype="pagelayout" match="headerall">
				<children>
					<paragraph>
						<styles text-align="center"/>
						<children>
							<text fixtext="Page Layout Example">
								<styles border-bottom="1px solid black" font-weight="bold"/>
							</text>
						</children>
					</paragraph>
				</children>
			</globaltemplate>
			<globaltemplate subtype="pagelayout" match="footerodd">
				<children>
					<tgrid>
						<properties width="100%"/>
						<styles width="100%"/>
						<children>
							<tgridbody-cols>
								<children>
									<tgridcol/>
									<tgridcol>
										<properties width="150"/>
									</tgridcol>
								</children>
							</tgridbody-cols>
							<tgridbody-rows>
								<children>
									<tgridrow>
										<properties height="30"/>
										<children>
											<tgridcell>
												<styles padding="0"/>
											</tgridcell>
											<tgridcell joinleft="1">
												<properties height="30"/>
												<styles padding="0"/>
											</tgridcell>
										</children>
									</tgridrow>
									<tgridrow>
										<children>
											<tgridcell>
												<styles padding="0"/>
												<children>
													<line>
														<properties color="black" size="1"/>
														<styles top="-37pt"/>
													</line>
												</children>
											</tgridcell>
											<tgridcell joinleft="1">
												<styles padding="0"/>
											</tgridcell>
										</children>
									</tgridrow>
									<tgridrow>
										<children>
											<tgridcell>
												<styles font-size="10pt" padding="0" width="50%"/>
												<children>
													<text fixtext="Page: ">
														<styles font-weight="bold"/>
													</text>
													<field>
														<styles font-weight="bold"/>
													</field>
												</children>
											</tgridcell>
											<tgridcell>
												<properties align="right"/>
												<styles font-size="10pt" padding="0" width="50%"/>
												<children>
													<text fixtext="Document: page layout.sps">
														<styles font-weight="bold"/>
													</text>
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
			<globaltemplate subtype="pagelayout" match="footereven">
				<children>
					<tgrid>
						<properties width="100%"/>
						<styles width="100%"/>
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
										<properties height="30"/>
										<children>
											<tgridcell>
												<styles padding="0"/>
											</tgridcell>
											<tgridcell joinleft="1">
												<properties height="30"/>
												<styles padding="0"/>
											</tgridcell>
										</children>
									</tgridrow>
									<tgridrow>
										<children>
											<tgridcell>
												<styles padding="0"/>
												<children>
													<line>
														<properties color="black" size="1"/>
														<styles top="-37pt"/>
													</line>
												</children>
											</tgridcell>
											<tgridcell joinleft="1">
												<styles padding="0"/>
											</tgridcell>
										</children>
									</tgridrow>
									<tgridrow>
										<children>
											<tgridcell>
												<properties align="left"/>
												<styles font-size="10pt" padding="0" width="50%"/>
												<children>
													<text fixtext="Document: page layout.sps">
														<styles font-weight="bold"/>
													</text>
												</children>
											</tgridcell>
											<tgridcell>
												<properties align="right"/>
												<styles font-size="10pt" padding="0" width="50%"/>
												<children>
													<text fixtext="Page: ">
														<styles font-weight="bold"/>
													</text>
													<field>
														<styles font-weight="bold"/>
													</field>
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
			<globaltemplate subtype="pagelayout" match="coverpage">
				<children>
					<tgrid>
						<properties align="center" width="80%"/>
						<children>
							<tgridbody-cols>
								<children>
									<tgridcol>
										<properties width="20"/>
									</tgridcol>
									<tgridcol/>
								</children>
							</tgridbody-cols>
							<tgridbody-rows>
								<children>
									<tgridrow>
										<properties height="50"/>
										<children>
											<tgridcell/>
											<tgridcell/>
										</children>
									</tgridrow>
									<tgridrow>
										<children>
											<tgridcell joinabove="1">
												<styles padding="2pt"/>
											</tgridcell>
											<tgridcell>
												<styles padding="2pt"/>
												<children>
													<paragraph paragraphtag="fieldset">
														<children>
															<paragraph paragraphtag="center">
																<children>
																	<paragraph paragraphtag="h1">
																		<children>
																			<newline/>
																			<text fixtext="Example: Page Layout"/>
																			<newline/>
																		</children>
																	</paragraph>
																	<paragraph paragraphtag="h2">
																		<children>
																			<text fixtext="An Overview"/>
																		</children>
																	</paragraph>
																	<newline/>
																	<newline/>
																	<newline/>
																	<newline/>
																	<newline/>
																	<paragraph paragraphtag="h3">
																		<children>
																			<text fixtext="Headers, Footers and Cover Pages"/>
																		</children>
																	</paragraph>
																</children>
															</paragraph>
														</children>
													</paragraph>
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
	</pagelayout>
	<designfragments/>
</structure>
