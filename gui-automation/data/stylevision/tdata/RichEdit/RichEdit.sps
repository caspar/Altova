<?xml version="1.0" encoding="UTF-8"?>
<structure version="16" html-doctype="HTML4 Transitional" compatibility-view="IE9" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT" richedit-attr="css" richedit-elem="Style">
	<parameters/>
	<schemasources>
		<namespaces/>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="Book with RichEdit.xsd" workingxmlfile="Book with RichEdit.xml"/>
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
		<Project version="2" app="AuthenticView"/>
	</script-project>
	<importedxslt/>
	<globalstyles/>
	<mainparts>
		<children>
			<globaltemplate subtype="main" match="/">
				<document-properties/>
				<children>
					<documentsection>
						<properties columncount="1" columngap="1.27cm" headerfooterheight="fixed" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="27.94cm" papermarginbottom="2.01cm" papermarginfooter="0.76cm" papermarginheader="0.76cm" papermarginleft="1.52cm" papermarginright="1.52cm" papermargintop="2.01cm" paperwidth="21.59cm"/>
					</documentsection>
					<template subtype="source" match="XML">
						<children>
							<paragraph paragraphtag="h2">
								<styles border-bottom="2px solid navy" color="navy"/>
								<children>
									<text fixtext="Example: RichEdit"/>
								</children>
							</paragraph>
							<paragraph paragraphtag="p">
								<styles background-color="#f6f6ff" border="1px solid navy" color="navy" font-weight="bold"/>
								<children>
									<text fixtext="This example demonstrates how styles can be applied to the contents of an XML file when editing in Authentic view, as opposed to being predefined by the stylesheet."/>
								</children>
							</paragraph>
							<condition>
								<children>
									<conditionbranch xpath="false()">
										<children>
											<paragraph>
												<styles color="blue" font-style="italic"/>
												<children>
													<text fixtext="For content, this example uses an excerpt of an outdated StyleVision manual, shown below the horizontal line. The focus here is on the styling rather than on the content itself. Note that the styling (application of color, font size, bold/italic text, etc.) is governed by the XML file. Often, styling is defined by the stylesheet, i.e. the SPS file. Sometimes, however, one wishes to apply styling as part of the content editing process. This implies storing the style information in the XML file."/>
													<newline/>
													<newline/>
													<text fixtext="This SPS design employs three StyleVision features in order to store style information in the XML file:"/>
													<newline/>
													<list ordered="1">
														<properties type="a"/>
														<children>
															<listrow>
																<children>
																	<text fixtext="The composite-style property"/>
																</children>
															</listrow>
															<listrow>
																<children>
																	<text fixtext="The RichEdit design element"/>
																</children>
															</listrow>
															<listrow>
																<children>
																	<text fixtext="Text state icons"/>
																</children>
															</listrow>
														</children>
													</list>
													<text fixtext="To apply styling with the composite-style property or the RichEdit design element, use the RichEdit toolbar that is displayed in Authentic View."/>
													<newline/>
													<text fixtext="To apply styling with text state icons, use the text state icons that are displayed in Authentic View."/>
													<newline/>
													<newline/>
													<text fixtext="a. The composite-style property">
														<styles text-decoration="underline"/>
													</text>
													<newline/>
													<newline/>
													<text fixtext="In the SPS design, the global template that matches &lt;heading&gt; XML elements contains a paragraph design element whose composite-style attribute refers to a schema attribute. This means that when a RichEdit command is applied, the style information will be stored in this attribute."/>
													<newline/>
													<newline/>
													<text fixtext="The style information stored in such an attribute naturally pertains to the entire element. To see this, click inside a &lt;heading&gt; element (colored brown or blue) and apply a RichEdit command; for example, click &quot;italic&quot;. Note that the entire heading becomes italic. The advantage of this approach is that the required schema modifications are limited to adding the attribute to those elements that use the composite-styles property."/>
													<newline/>
													<newline/>
													<text fixtext="b. The RichEdit design element">
														<styles text-decoration="underline"/>
													</text>
													<newline/>
													<newline/>
													<text fixtext="The RichEdit design element offers a more fine-grained approach, allowing text spans inside a given element to be styled individually."/>
													<newline/>
													<newline/>
													<text fixtext="In the SPS design, the global template that matches the &lt;p&gt; XML element contains a RichEdit design element instead of a Content element. A RichEdit element renders its contents just like a Contents element does. Additionally, in Authentic View, commands in the RichEdit toolbar are enabled (as appropriate) when the cursor is inside content rendered by a RichEdit element."/>
													<newline/>
													<newline/>
													<text fixtext="To see this, select text in one of the chapters (colored black) and apply a RichEdit command; for example, change the font size. Note that only the selected text changes, not the entire element. In this case, applying a RichEdit command inserts an intermediate element that holds the style information in an attribute. Here, the element is named &quot;Style&quot; and the attribute is named &quot;css&quot;. These names are configured per design via any RichEdit design element."/>
													<newline/>
													<newline/>
													<text fixtext="c. Text state icons">
														<styles text-decoration="underline"/>
													</text>
													<newline/>
													<newline/>
													<text fixtext="A text state icon inserts an XML element. Styling is applied by a global template for the element, defined in the stylesheet."/>
													<newline/>
													<newline/>
													<text fixtext="To see this, select a &lt;heading&gt; element (colored brown or blue). Be sure to select the entire text, then click on one of the text state buttons. Each text state button inserts a different element, and the stylesheet provides different styling for each of these elements."/>
													<newline/>
												</children>
											</paragraph>
											<line/>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<template subtype="element" match="book">
								<children>
									<template subtype="element" match="overview">
										<variables/>
									</template>
									<content subtype="regular" restofcontents="1"/>
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
	<globalparts>
		<children>
			<globaltemplate subtype="element" match="p" schema-tree-path="$XML/book/chapter/p">
				<children>
					<template subtype="element" match="p">
						<children>
							<paragraph paragraphtag="p">
								<children>
									<content subtype="richedit" type="block"/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="heading" schema-tree-path="$XML/book/chapter/subchapter/heading">
				<children>
					<template subtype="element" match="heading">
						<children>
							<paragraph richedit="@heading-style" paragraphtag="p">
								<children>
									<content subtype="regular"/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="HeadingStyleA" schema-tree-path="$XML/book/chapter/heading/HeadingStyleA">
				<children>
					<template subtype="element" match="HeadingStyleA">
						<children>
							<content subtype="regular">
								<styles border-bottom="2px dotted olive" font-style="italic"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="HeadingStyleB" schema-tree-path="$XML/book/chapter/heading/HeadingStyleB">
				<children>
					<template subtype="element" match="HeadingStyleB">
						<children>
							<content subtype="regular">
								<styles border-bottom="2px dashed olive" font-style="italic"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="HeadingStyleC" schema-tree-path="$XML/book/chapter/heading/HeadingStyleC">
				<children>
					<template subtype="element" match="HeadingStyleC">
						<children>
							<content subtype="regular">
								<styles border-bottom="2px solid olive" font-style="italic"/>
							</content>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="Style">
				<children>
					<template subtype="element" match="Style">
						<children>
							<condition>
								<children>
									<conditionbranch xpath="not(contains(@css, &apos;text-align&apos; ))">
										<children>
											<content subtype="regular" richedit="@css"/>
										</children>
									</conditionbranch>
									<conditionbranch>
										<children>
											<paragraph>
												<styles _xtext-align="translate(for $i in (substring-after(@css, &apos;text-align&apos;)) return if (contains($i, &apos;;&apos;)) then substring-before($i, &apos;;&apos;) else $i, &apos;: &apos;, &apos;&apos;)"/>
												<children>
													<content subtype="regular" richedit="@css"/>
												</children>
											</paragraph>
										</children>
									</conditionbranch>
								</children>
							</condition>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</globalparts>
	<designfragments/>
	<xmltables/>
	<authentic-custom-toolbar-buttons>
		<textstateicon match="HeadingStyleA" iconfile="heading-a.bmp" text="Heading A" tooltip="Heading (dotted underline)"/>
		<textstateicon match="HeadingStyleB" iconfile="heading-b.bmp" text="Heading B" tooltip="Heading (dashed underline)"/>
		<textstateicon match="HeadingStyleC" iconfile="heading-c.bmp" text="Heading C" tooltip="Heading (solid underline)"/>
	</authentic-custom-toolbar-buttons>
</structure>
