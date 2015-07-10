<?xml version="1.0" encoding="UTF-8"?>
<!--
Translator: B.Armbruster Altova GmbH
XSLT2 translation of the XQuery use case
Filename: treeQ6.xsl
Section:   1.2.4.6 Q6 
Purpose:  Make a nested list of the section elements in Book1,  preserving their original attributes and hierarchy. Inside each section element,  include the title of the section and an element that includes  the number of figures immediately contained in the section.
-->
<!--
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
-->

<xsl:stylesheet version="2.0" 
     xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
     xmlns:xs="http://www.w3.org/2001/XMLSchema" 
     xmlns:fn="http://www.w3.org/2005/xpath-functions" 
     exclude-result-prefixes="xs fn xsl">

<!--output format close to xquery-->
<xsl:output method="xml" encoding="utf-8" omit-xml-declaration="yes"/>

<xsl:template match="/">
<toc>
	<xsl:for-each select="//book">
	   <xsl:call-template name="section-summary"/>
	</xsl:for-each>
</toc>
</xsl:template>

<xsl:template name="section-summary">
	<xsl:for-each select="section" >
		<section>
			<xsl:if test="exists(attribute())">
				<xsl:attribute name="id" select="./@id"/>
				<xsl:attribute name="difficulty" select="./@difficulty"/>
			</xsl:if>
			<xsl:sequence select="./title"/>
			<figcount>
				<xsl:value-of select="fn:count(figure)"/>
			</figcount>
			<xsl:call-template name="section-summary"/>
			</section>
	</xsl:for-each><!--section-->
</xsl:template>


</xsl:stylesheet>

