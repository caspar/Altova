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
	<modules>
		<module spsfile="module - fragments.sps"/>
		<module spsfile="module - templates.sps"/>
	</modules>
	<flags>
		<scripts/>
		<globalparts>
			<globalpart match="chapter" spsfile="module - templates.sps" isactive="1"/>
			<globalpart match="p" spsfile="module - templates.sps" isactive="1"/>
			<globalpart match="subchapter" spsfile="module - templates.sps" isactive="1"/>
		</globalparts>
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
							<text fixtext="Example: Modules"/>
						</children>
					</paragraph>
					<paragraph paragraphtag="p">
						<properties class="info"/>
						<children>
							<text fixtext="This example creates the same design as the table-of-contents example. However, here we placed all common elements into separate files, so called &quot;modules&quot;."/>
						</children>
					</paragraph>
					<paragraph paragraphtag="p">
						<properties class="explanation"/>
						<children>
							<text fixtext="All parts of the design are defined in the included modules (see the Design Overview window). The table-of-contents, the foreword and the appendix are just references to the design fragments (signified by the grey markups), while the global templates for &apos;chapter&apos;, &apos;sub-chapter&apos; and &apos;p&apos; are used directly, i.e., there is no need to further copy or reference them in the main design."/>
						</children>
					</paragraph>
					<template match="$XML" matchtype="schemasource">
						<editorproperties elementstodisplay="5"/>
						<children>
							<content match="TOC" matchtype="named"/>
							<newline/>
							<newline break="page"/>
							<content match="Foreword" matchtype="named"/>
							<newline/>
							<newline break="page"/>
							<paragraph paragraphtag="p">
								<properties class="explanation"/>
								<children>
									<text fixtext="The main matter of the book - the only part of the design that is not re-used in this example."/>
								</children>
							</paragraph>
							<template match="book" matchtype="schemagraphitem">
								<editorproperties elementstodisplay="5"/>
								<children>
									<content/>
								</children>
							</template>
							<newline break="page"/>
							<content match="Appendix" matchtype="named"/>
						</children>
					</template>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts/>
	<pagelayout/>
	<designfragments/>
</structure>
