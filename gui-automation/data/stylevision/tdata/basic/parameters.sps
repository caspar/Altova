<?xml version="1.0" encoding="UTF-8"?>
<structure version="7" cssmode="strict" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" embed-images="1">
	<parameters>
		<parameter name="Color" default="#a0ffa0"/>
	</parameters>
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
							<text fixtext="Example: Parameters"/>
						</children>
					</paragraph>
					<paragraph paragraphtag="p">
						<properties class="info"/>
						<children>
							<text fixtext="Parameters are string variables that hold some common value. They are generally used in order to have a central place where to change a value that is used throughout the design, and/or to provide a default value that will be replaced on the command line during batch processing."/>
						</children>
					</paragraph>
					<paragraph paragraphtag="p">
						<properties class="explanation"/>
						<children>
							<text fixtext="For this example we store the background color for chapter and sub-chapter headings in a variable &apos;$Color&apos;. You can verify the parameter in the Design Overview window, and the color setting on the &apos;background-color&apos; CSS attribute on the &apos;h2&apos; and &apos;h3&apos; paragraphs of the chapter and sub-chapter headings, respectively."/>
						</children>
					</paragraph>
					<paragraph paragraphtag="p">
						<properties class="explanation"/>
						<children>
							<text fixtext="Note that the parameter cannot be reliably evaluated in the design view, so you will not actually see a background color until you switch into one of the previews!"/>
						</children>
					</paragraph>
					<template match="$XML" matchtype="schemasource">
						<editorproperties elementstodisplay="5"/>
						<children>
							<template match="book" matchtype="schemagraphitem">
								<editorproperties elementstodisplay="5"/>
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
										<styles _xbackground-color="$Color"/>
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
										<styles _xbackground-color="$Color"/>
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
