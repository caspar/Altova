<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>

	<xsl:template match="testsuite">
		<xsl:copy>
			<xsl:attribute name="name"><xsl:value-of select="@name"/>_<xsl:value-of select='translate( @timestamp, ":", "-")'/></xsl:attribute>
			<xsl:attribute name="hostname"><xsl:value-of select="@hostname"/> (<xsl:value-of select='properties/property[@name="os.name"]/@value'/>)</xsl:attribute>
			<xsl:apply-templates select="@*[local-name() != 'name' and local-name() != 'hostname']"/>
			<xsl:apply-templates select="node()"/>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="node()|@*">
		<xsl:copy>
			<xsl:apply-templates select="@*|node()"/>
		</xsl:copy>
	</xsl:template>
	
</xsl:stylesheet>
