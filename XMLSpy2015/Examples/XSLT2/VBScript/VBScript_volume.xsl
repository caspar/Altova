<!--
Author: M. Seher Altova GmbH
Filename: VBScript_volume.xsl
Input: sphere.xml
Created: 11.04.2008
Purpose: Demonstrate usage of embedded Visual Basic code (calculate volume for a given radius).
-->
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:msxsl="urn:schemas-microsoft-com:xslt" xmlns:vb="http://vb.org">
<xsl:output method="xml" omit-xml-declaration="yes" indent="yes" exclude-result-prefixes="msxsl vb"/>

<msxsl:script language="vbScript" implements-prefix="vb">
<![CDATA[
	Public Function volume(radius As Double) As Double
		return 4 / 3 * Math.PI * Math.Pow(radius, 3)
	End Function
]]>
</msxsl:script>

  <xsl:template match="data">  
  <root>
  <xsl:for-each select="sphere">
    <sphere>
    <xsl:copy-of select="node()"/>
       <volume>
          <xsl:value-of select="vb:volume(radius)"/>        
       </volume>
    </sphere>
  </xsl:for-each>
  </root>
  </xsl:template>
</xsl:stylesheet>
