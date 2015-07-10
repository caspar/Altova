<!--
Author: M. Seher Altova GmbH
Filename: sinus.xsl
Input: sinus.xml
Created: 11.04.2008
Purpose: Example of C# extension usage. This file draws a sinus curve for every sinus element in the input xml file. It uses the 'ampl', 'freq' and 'res'
attributes to specify the sinus curve (amplitude, frequency and resolution). The result can be viewed as an svg file.
-->
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:math="clitype:System.Math">
<xsl:output method="xml" omit-xml-declaration="no" />

	<xsl:template match="/">
		<svg xmlns="http://www.w3.org/2000/svg" width="100%" height="100%">
			<xsl:text>&#10;</xsl:text>
			<line x1="10" y1="10" x2="10" y2="610" style="stroke:rgb(0,0,0);stroke-width:2" />
			<xsl:text>&#10;</xsl:text>
			<line x1="0" y1="310" x2="100%" y2="310" style="stroke:rgb(0,0,0);stroke-width:2" />
			<xsl:text>&#10;</xsl:text>
			<xsl:apply-templates select="//sinus" />
		</svg>
	</xsl:template>

	<xsl:template match="sinus">		
			<xsl:variable name="ampl" select="./@ampl" as="xs:double"/>
			<xsl:variable name="freq" select="./@freq" as="xs:double"/>			
			<xsl:variable name="numOfValues" select="./@res"/>
			
			<xsl:variable name="realInterval" select="math:PI() * 2 div $numOfValues" />
			<xsl:variable name="screenInterval" select="1000 div $numOfValues" />
			<xsl:text disable-output-escaping="yes"><![CDATA[<path d="M10 310]]></xsl:text>
			<xsl:for-each select="1 to $numOfValues">
				<xsl:value-of select="fn:concat( ' L', xs:string(10 + position()*$screenInterval), ' ', xs:string(310-100*$ampl*math:Sin($realInterval * position() div $freq )) )" />
				<xsl:text>&#10;</xsl:text>
			</xsl:for-each>
			<xsl:text disable-output-escaping="yes"><![CDATA[" style="stroke:rgb(0,0,255);stroke-width:3;fill-opacity:0" />]]></xsl:text>
			<xsl:text>&#10;</xsl:text>
	</xsl:template>
</xsl:stylesheet>
