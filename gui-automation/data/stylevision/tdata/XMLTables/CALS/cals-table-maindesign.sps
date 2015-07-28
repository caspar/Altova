<?xml version="1.0" encoding="UTF-8"?>
<structure version="12" htmlmode="strict" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" useimportschema="1" embed-images="1" enable-authentic-scripts="1" authentic-scripts-in-debug-mode-external="0" generated-file-location="DEFAULT">
	<parameters/>
	<schemasources>
		<namespaces/>
		<schemasources>
			<xsdschemasource name="XML" main="1" schemafile="http://www.altova.com/schemas/docbook/docbookx.dtd" workingxmlfile="cals-table-000.xml"/>
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
	<script-project>
		<Project version="1" app="AuthenticView"/>
	</script-project>
	<importedxslt/>
	<globalstyles/>
	<mainparts>
		<styles font-family="Arial Unicode MS"/>
		<children>
			<globaltemplate subtype="main" match="/">
				<children>
					<documentsection>
						<properties columncount="1" columngap="0.50in" headerfooterheight="fixed" pagemultiplepages="0" pagenumberingformat="1" pagenumberingstartat="auto" pagestart="next" paperheight="11in" papermarginbottom="0.79in" papermarginfooter="0.30in" papermarginheader="0.30in" papermarginleft="0.60in" papermarginright="0.60in" papermargintop="0.79in" paperwidth="8.50in"/>
					</documentsection>
					<template subtype="source" match="XML">
						<children>
							<content/>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</mainparts>
	<globalparts>
		<children>
			<globaltemplate subtype="element" match="articleinfo" schema-tree-path="articleinfo">
				<children>
					<template subtype="element" match="articleinfo">
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
														<children>
															<image>
																<target>
																	<fixtext value="http://www.altova.com/images/2008/logo.jpg"/>
																</target>
																<imagesource>
																	<fixtext value="http://www.altova.com/images/2008/logo.jpg"/>
																</imagesource>
															</image>
														</children>
													</tgridcell>
													<tgridcell/>
												</children>
											</tgridrow>
											<tgridrow>
												<children>
													<tgridcell>
														<children>
															<calltemplate subtype="element" match="title"/>
															<newline/>
														</children>
													</tgridcell>
													<tgridcell>
														<styles text-align="right"/>
														<children>
															<calltemplate subtype="element" match="releaseinfo"/>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
											<tgridrow>
												<children>
													<tgridcell>
														<children>
															<calltemplate subtype="element" match="subtitle"/>
														</children>
													</tgridcell>
													<tgridcell>
														<styles text-align="right"/>
														<children>
															<calltemplate subtype="element" match="author"/>
														</children>
													</tgridcell>
												</children>
											</tgridrow>
											<tgridrow>
												<children>
													<tgridcell/>
													<tgridcell/>
												</children>
											</tgridrow>
										</children>
									</tgridbody-rows>
								</children>
							</tgrid>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="title" schema-tree-path="articleinfo/title">
				<children>
					<template subtype="element" match="title">
						<children>
							<paragraph paragraphtag="h1">
								<children>
									<content/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="releaseinfo" schema-tree-path="releaseinfo">
				<children>
					<template subtype="element" match="releaseinfo">
						<children>
							<paragraph paragraphtag="h3">
								<children>
									<content/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="subtitle" schema-tree-path="subtitle">
				<children>
					<template subtype="element" match="subtitle">
						<children>
							<paragraph paragraphtag="h4">
								<children>
									<content/>
								</children>
							</paragraph>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
			<globaltemplate subtype="element" match="author" schema-tree-path="author">
				<children>
					<template subtype="element" match="author">
						<children>
							<template subtype="element" match="firstname">
								<children>
									<content/>
								</children>
								<variables/>
							</template>
							<text fixtext=" "/>
							<template subtype="element" match="surname">
								<children>
									<content/>
								</children>
								<variables/>
							</template>
							<newline/>
							<template subtype="element" match="affiliation">
								<children>
									<template subtype="element" match="address">
										<children>
											<template subtype="element" match="email">
												<children>
													<content/>
												</children>
												<variables/>
											</template>
										</children>
										<variables/>
									</template>
								</children>
								<variables/>
							</template>
						</children>
						<variables/>
					</template>
				</children>
			</globaltemplate>
		</children>
	</globalparts>
	<pagelayout>
		<properties paperheight="11.69in" paperwidth="8.27in"/>
		<styles font-family="Arial Unicode MS"/>
	</pagelayout>
	<designfragments/>
	<xmltables>
		<children>
			<xmltable>
				<children>
					<xmltable-tag tag-name="table">
						<styles background-color="#e1ffff"/>
					</xmltable-tag>
					<xmltable-tag tag-type="Caption" tag-name="title"/>
					<xmltable-tag tag-type="Group" tag-name="tgroup"/>
					<xmltable-tag tag-type="Header" tag-name="thead"/>
					<xmltable-tag tag-type="Footer" tag-name="tfoot">
						<styles font-weight="bold"/>
					</xmltable-tag>
					<xmltable-tag tag-type="Body" tag-name="tbody"/>
					<xmltable-tag tag-type="Row" tag-name="row"/>
					<xmltable-tag tag-type="Cell" tag-name="entry"/>
					<xmltable-tag tag-type="SubTable" tag-name="entrytbl"/>
					<xmltable-tag tag-type="ColSpec" tag-name="colspec"/>
					<xmltable-tag tag-type="SpanSpec" tag-name="spanspec"/>
				</children>
			</xmltable>
		</children>
	</xmltables>
	<authentic-custom-toolbar-buttons/>
</structure>
