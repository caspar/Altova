<?xml version="1.0" encoding="UTF-8"?><structure version="7" cssmode="strict" relativeto="*SPS" encodinghtml="UTF-8" encodingrtf="ISO-8859-1" encodingpdf="UTF-8" embed-images="1">	<parameters/>	<schemasources>		<namespaces/>		<schemasources>			<xsdschemasource name="$XML" main="1" schemafile="Data.xsd" workingxmlfile="Data.xml">				<xmltablesupport/>				<textstateicons/>			</xsdschemasource>		</schemasources>	</schemasources>	<modules/>	<flags>		<scripts/>		<globalparts/>		<designfragments/>		<pagelayouts/>	</flags>	<scripts>		<script language="javascript"/>	</scripts>	<globalstyles>		<rules selector=".info">			<media>				<media value="all"/>			</media>			<rule background-color="#f6f6ff" border="1px solid navy" color="navy" font-weight="bold" margin-bottom="12px" margin-top="12px" padding="2px"/>		</rules>		<rules selector=".explanation">			<media>				<media value="all"/>			</media>			<rule color="blue" font-style="italic" margin-bottom="12px"/>		</rules>	</globalstyles>	<mainparts>		<children>			<globaltemplate match="/" matchtype="named" parttype="main">				<children>					<paragraph paragraphtag="h2">						<styles border-bottom="2px solid navy" color="navy"/>						<children>							<text fixtext="Example: Templates - grouping"/>						</children>					</paragraph>					<paragraph paragraphtag="p">						<properties class="info"/>						<children>							<text fixtext="This example demonstrates how you can have StyleVision generate XSLT code to group the entries that are iterated over with a template, according to some criterion. Note that grouping only works in XSLT 2.0, and is not applied in Authentic."/>						</children>					</paragraph>					<template match="$XML" matchtype="schemasource">						<children>							<template match="data" matchtype="schemagraphitem">								<children>									<template match="strings" matchtype="schemagraphitem">										<children>											<table>												<properties border="1" width="100%"/>												<children>													<tablebody>														<children>															<tablerow>																<children>																	<tablecell>																		<children>																			<paragraph paragraphtag="p">																				<properties class="explanation"/>																				<children>																					<text fixtext="1.) &quot;group-by&quot; example: group event and odd entries, respectively"/>																				</children>																			</paragraph>																			<template match="string" matchtype="schemagraphitem" groupingtype="group-by" groupingmatch="position() mod 2">																				<children>																					<template match="current-group()" matchtype="pseudo">																						<children>																							<content>																								<format datatype="string"/>																							</content>																							<newline/>																						</children>																					</template>																					<newline/>																				</children>																			</template>																		</children>																	</tablecell>																	<tablecell>																		<children>																			<paragraph paragraphtag="p">																				<properties class="explanation"/>																				<children>																					<text fixtext="1.) &quot;group-starting-with&quot; example: start a new group with the 2nd entry (note that with this option the XPath expression must be a "/>																					<text fixtext="pattern">																						<styles font-weight="bold"/>																					</text>																					<text fixtext=". A new group is started if the examined node matches that pattern.)"/>																				</children>																			</paragraph>																			<template match="string" matchtype="schemagraphitem" groupingtype="group-starting-with" groupingmatch="string[2]">																				<children>																					<template match="current-group()" matchtype="pseudo">																						<children>																							<content>																								<format datatype="string"/>																							</content>																							<newline/>																						</children>																					</template>																					<newline/>																				</children>																			</template>																		</children>																	</tablecell>																</children>															</tablerow>															<tablerow>																<children>																	<tablecell>																		<children>																			<paragraph paragraphtag="p">																				<properties class="explanation"/>																				<children>																					<text fixtext="1.) &quot;group-starting-with&quot; example: start a new group with the 2nd entry (note that with this option the XPath expression must be a "/>																					<text fixtext="pattern">																						<styles font-weight="bold"/>																					</text>																					<text fixtext=". A new group is started if the examined node matches that pattern.)"/>																				</children>																			</paragraph>																			<template match="string" matchtype="schemagraphitem" groupingtype="group-starting-with" groupingmatch="string[2]">																				<children>																					<template match="current-group()" matchtype="pseudo">																						<children>																							<content>																								<format datatype="string"/>																							</content>																							<newline/>																						</children>																					</template>																					<newline/>																				</children>																			</template>																		</children>																	</tablecell>																	<tablecell>																		<children>																			<paragraph paragraphtag="p">																				<properties class="explanation"/>																				<children>																					<text fixtext="1.) &quot;group-ending-with&quot; example: end a group with the 3rd entry (note that with this option the XPath expression must be a "/>																					<text fixtext="pattern">																						<styles font-weight="bold"/>																					</text>																					<text fixtext=". The current group is ended if the examined node matches that pattern.)"/>																				</children>																			</paragraph>																			<template match="string" matchtype="schemagraphitem" groupingtype="group-ending-with" groupingmatch="string[3]">																				<children>																					<template match="current-group()" matchtype="pseudo">																						<children>																							<content>																								<format datatype="string"/>																							</content>																							<newline/>																						</children>																					</template>																					<newline/>																				</children>																			</template>																		</children>																	</tablecell>																</children>															</tablerow>															<tablerow>																<children>																	<tablecell>																		<properties colspan="2"/>																		<children>																			<paragraph paragraphtag="p">																				<properties class="explanation"/>																				<children>																					<text fixtext="We modify the 2nd example to sort the groups according to the number of entries, and sort the entries of every group alphabetically."/>																				</children>																			</paragraph>																			<template match="string" matchtype="schemagraphitem" groupingtype="group-adjacent" groupingmatch="substring( . , 1, 1 )">																				<children>																					<template match="current-group()" matchtype="pseudo">																						<children>																							<content>																								<format datatype="string"/>																							</content>																							<newline/>																						</children>																						<sort>																							<key match="."/>																						</sort>																					</template>																					<newline/>																				</children>																				<sort>																					<key match="count(  current-group() )"/>																				</sort>																			</template>																		</children>																	</tablecell>																</children>															</tablerow>														</children>													</tablebody>												</children>											</table>											<paragraph paragraphtag="p">												<properties class="explanation"/>												<children>													<text fixtext="For reference, all entries of the &apos;string&apos; element, as they appear in the XML:"/>												</children>											</paragraph>											<template match="string" matchtype="schemagraphitem">												<children>													<content>														<format datatype="string"/>													</content>													<newline/>												</children>											</template>											<newline/>											<paragraph paragraphtag="p">												<properties class="explanation"/>												<children>													<text fixtext="Below we list the same strings, but grouped in various ways. To see how the grouping is defined, right click on the template markup and choose &quot;Group by...&quot; from the context menu."/>												</children>											</paragraph>											<paragraph paragraphtag="p">												<properties class="explanation"/>												<children>													<text fixtext="When defining a grouping, you use 2 templates: The outer template that defines the grouping iterates over all resulting "/>													<text fixtext="groups">														<styles font-weight="bold"/>													</text>													<text fixtext=". Furthermore, you (normally) use a nested &apos;current-group()&apos; template that iterates over all "/>													<text fixtext="entries">														<styles font-weight="bold"/>													</text>													<text fixtext=" in a given group (per definition every group has at least 1 entry)."/>												</children>											</paragraph>											<paragraph paragraphtag="p">												<properties class="explanation"/>												<children>													<text fixtext="1.) &quot;group-by&quot; example: group event and odd entries, respectively"/>												</children>											</paragraph>											<template match="string" matchtype="schemagraphitem" groupingtype="group-by" groupingmatch="position() mod 2">												<children>													<template match="current-group()" matchtype="pseudo">														<children>															<content>																<format datatype="string"/>															</content>															<newline/>														</children>													</template>													<newline/>												</children>											</template>											<paragraph paragraphtag="p">												<properties class="explanation"/>												<children>													<text fixtext="2.) &quot;group-adjacent&quot; example: group according to starting character"/>												</children>											</paragraph>											<template match="string" matchtype="schemagraphitem" groupingtype="group-adjacent" groupingmatch="substring( . , 1, 1 )">												<children>													<template match="current-group()" matchtype="pseudo">														<children>															<content>																<format datatype="string"/>															</content>															<newline/>														</children>													</template>													<newline/>												</children>											</template>											<paragraph paragraphtag="p">												<properties class="explanation"/>												<children>													<text fixtext="1.) &quot;group-starting-with&quot; example: start a new group with the 2nd entry (note that with this option the XPath expression must be a "/>													<text fixtext="pattern">														<styles font-weight="bold"/>													</text>													<text fixtext=". A new group is started if the examined node matches that pattern.)"/>												</children>											</paragraph>											<template match="string" matchtype="schemagraphitem" groupingtype="group-starting-with" groupingmatch="string[2]">												<children>													<template match="current-group()" matchtype="pseudo">														<children>															<content>																<format datatype="string"/>															</content>															<newline/>														</children>													</template>													<newline/>												</children>											</template>											<paragraph paragraphtag="p">												<properties class="explanation"/>												<children>													<text fixtext="1.) &quot;group-ending-with&quot; example: end a group with the 3rd entry (note that with this option the XPath expression must be a "/>													<text fixtext="pattern">														<styles font-weight="bold"/>													</text>													<text fixtext=". The current group is ended if the examined node matches that pattern.)"/>												</children>											</paragraph>											<template match="string" matchtype="schemagraphitem" groupingtype="group-ending-with" groupingmatch="string[3]">												<children>													<template match="current-group()" matchtype="pseudo">														<children>															<content>																<format datatype="string"/>															</content>															<newline/>														</children>													</template>													<newline/>												</children>											</template>											<newline/>											<paragraph paragraphtag="p">												<properties class="explanation"/>												<children>													<text fixtext="Finally, you can apply sorting to both the grouping template and the &apos;curernt-group()&apos; template individually, to sort in which order the groups are being generated and/or in which order the entries in every group are generated. For this (and other purposes), XSLT defines the context item of a group as the first entry in that group."/>												</children>											</paragraph>											<paragraph paragraphtag="p">												<properties class="explanation"/>												<children>													<text fixtext="We modify the 2nd example to sort the groups according to the number of entries, and sort the entries of every group alphabetically."/>												</children>											</paragraph>											<template match="string" matchtype="schemagraphitem" groupingtype="group-adjacent" groupingmatch="substring( . , 1, 1 )">												<children>													<template match="current-group()" matchtype="pseudo">														<children>															<content>																<format datatype="string"/>															</content>															<newline/>														</children>														<sort>															<key match="."/>														</sort>													</template>													<newline/>												</children>												<sort>													<key match="count(  current-group() )"/>												</sort>											</template>											<line/>										</children>									</template>								</children>							</template>						</children>					</template>				</children>			</globaltemplate>		</children>	</mainparts>	<globalparts/>	<pagelayout>		<properties paperheight="11.69in" paperwidth="8.27in" size="A4"/>	</pagelayout>	<designfragments/></structure>