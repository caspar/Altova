<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:xsi ="http://www.w3.org/2000/10/XMLSchema-instance"
xmlns:my="http://my-company.com/namespace">

<xsl:template match="/">
	<html>
		<head>	<title>Your company</title></head>
			<body>
				<h1><center>Your Company</center></h1>
				<xsl:apply-templates select="//my:Address"/>
					<table border="1" bgcolor="lime">
						<thead align="center">
							<td><strong>First</strong></td>
							<td><strong>Last</strong></td>
							<td><strong>Ext.</strong></td>
							<td><strong>E-Mail</strong></td>
							<td><strong>Manager</strong></td>
							<td><strong>Degree</strong></td>
							<td><strong>Programmer</strong></td>
						</thead>
						<xsl:apply-templates select="//my:Person"/>
					</table>
			</body>
	</html>
</xsl:template>

<xsl:template match="my:Address">
	<strong>Name: </strong><xsl:value-of select="my:Name"/><br/>
	<strong>Street: </strong><xsl:value-of select="my:Street"/><br/>
	<strong>City: </strong><xsl:value-of select="my:City"/><br/>
	<strong>State: </strong><xsl:value-of select="my:State"/><br/>
	<strong>Zip: </strong><xsl:value-of select="my:Zip"/><br/>
	<br></br>
</xsl:template>

<xsl:template match="my:Person">
	<tr>
		<xsl:for-each select="*">
			<td><xsl:value-of select="."/></td>
		</xsl:for-each>
		
		<xsl:for-each select="@*">
			<td><xsl:value-of select="."/></td>
		</xsl:for-each>
	</tr>
</xsl:template>
</xsl:stylesheet>
