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
		<rules selector=".explanation">
			<media>
				<media value="all"/>
			</media>
			<rule color="blue"/>
		</rules>
	</globalstyles>
	<mainparts>
		<children>
			<globaltemplate match="/" matchtype="named" parttype="main">
				<children>
					<paragraph paragraphtag="h2">
						<styles border-bottom="2px solid navy" color="navy"/>
						<children>
							<text fixtext="Example: page breaks"/>
						</children>
					</paragraph>
					<paragraph paragraphtag="p">
						<properties class="explanation"/>
						<children>
							<text fixtext="Note that in this example no paragraph is split at a page break. For this we set the &apos;page-break-inside&apos; CSS attribute (&apos;paged-media&apos; group) on the paragraph ("/>
							<text fixtext="p">
								<styles font-weight="bold"/>
							</text>
							<text fixtext=" global template) to &quot;avoid&quot;."/>
						</children>
					</paragraph>
					<paragraph paragraphtag="p">
						<properties class="explanation"/>
						<children>
							<text fixtext="For PDF you could also set the XSL-FO attribute &apos;keep-together&apos; to &quot;always&quot;."/>
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
											<paragraph paragraphtag="p">
												<properties class="explanation"/>
												<children>
													<text fixtext="The above is a hard page break that will be inserted for all chapters except the first (hence the condition)."/>
												</children>
											</paragraph>
										</children>
									</conditionbranch>
								</children>
							</condition>
							<template match="heading" matchtype="schemagraphitem">
								<editorproperties elementstodisplay="5"/>
								<children>
									<paragraph paragraphtag="h2">
										<styles keep-with-next="always"/>
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
										<styles keep-with-next="always" page-break-after="avoid"/>
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
								<styles page-break-inside="avoid"/>
								<children>
									<text fixtext="[paragraph start &gt; ">
										<styles color="blue"/>
									</text>
									<content/>
									<text fixtext=" &lt; paragraph end]">
										<styles color="blue"/>
									</text>
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
