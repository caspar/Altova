<!--
Author: M. Seher Altova GmbH
Filename: JScript_surfaceArea.xsl
Input: sphere.xml
Created: 11.04.2008
Purpose: Demonstrate usage of embedded JScript code (calculate surface for a given radius).
-->
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:msxsl="urn:schemas-microsoft-com:xslt" xmlns:jscript="http://jscript.org">
<xsl:output method="xml" omit-xml-declaration="yes" indent="yes" exclude-result-prefixes="msxsl jscript"/>

<msxsl:script language="JavaScript" implements-prefix="jscript">
<![CDATA[
	public function surface(radius : double) : double
	{
		return 4 * Math.PI * Math.pow(radius, 2);
	}
]]>
</msxsl:script>

  <xsl:template match="data">  
  <root>
  <xsl:for-each select="sphere">
    <sphere>
    <xsl:copy-of select="node()"/>
       <surface>
          <xsl:value-of select="jscript:surface(radius)"/>
       </surface>
    </sphere>
  </xsl:for-each>
  </root>
  </xsl:template>
</xsl:stylesheet>
