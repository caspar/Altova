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
							<text fixtext="Example: Design Fragments"/>
						</children>
					</paragraph>
					<paragraph paragraphtag="p">
						<properties class="info"/>
						<children>
							<text fixtext="This file is included into another example file. Note that, being a module, the contents of the main template here (including this note) are normally disregarded."/>
						</children>
					</paragraph>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts/>
	<pagelayout/>
	<designfragments>
		<children>
			<globaltemplate match="TOC" matchtype="named" parttype="named">
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
											<field type="ref-entrytext"/>
											<field type="ref-leader"/>
											<field type="ref-pageref"/>
											<newline/>
										</children>
									</ref>
									<reflevel>
										<children>
											<ref name="toc" createhyperlink="1">
												<children>
													<field type="ref-entrytext"/>
													<field type="ref-leader"/>
													<field type="ref-pageref"/>
													<newline/>
												</children>
											</ref>
										</children>
									</reflevel>
								</children>
							</reflevel>
						</children>
					</toc>
				</children>
			</globaltemplate>
			<globaltemplate match="Foreword" matchtype="named" parttype="named">
				<children>
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
									<text fixtext="Note that the foreword here is statically defined by the design, i.e., not dependent on the XML. From the document structure, the foreword is at the same level as a chapter, so we wrap everything with a Level indicator (yellow markups)."/>
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
				</children>
			</globaltemplate>
			<globaltemplate match="Appendix" matchtype="named" parttype="named">
				<children>
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
			</globaltemplate>
		</children>
	</designfragments>
</structure>
