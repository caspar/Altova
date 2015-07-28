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
							<text fixtext="Example: Module"/>
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
