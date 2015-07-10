<!--
Author: M. Seher Altova GmbH
Filename: string.xsl
Input: Any xml file
Created: 11.04.2008
Purpose: Demonstrate how to call instance functions from C# objects. Show how elements of an array can be accessed.
-->
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
<xsl:output method="xml" omit-xml-declaration="yes"  indent="yes" />

<xsl:template match="/">
	<root xmlns:string="clitype:System.String">
		<xsl:variable name="lstring" select="'Lower Case String'" />
		<string><xsl:value-of select="string:ToLower($lstring)" /></string>
		<string><xsl:value-of select="string:Substring('lower case string', 6, 4)" /></string>
		<string><xsl:value-of select="string:Replace(string:ToUpper($lstring), 'LOWER', 'UPPER')" /></string>
		<xsl:variable name="sarray" select="string:ToCharArray($lstring)" />
		<string><xsl:value-of select="$sarray[1]" /></string>
		<string><xsl:value-of select="$sarray[2]" /></string>
	</root>
</xsl:template>
</xsl:stylesheet>

