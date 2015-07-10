<!--
Author: M. Seher Altova GmbH
Filename: CSharp_circumference.xsl
Input: sphere.xml
Created: 11.04.2008
Purpose: Demonstrate usage of embedded C# code (calculate circumference for a given radius).
-->
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:msxsl="urn:schemas-microsoft-com:xslt" xmlns:csharp="http://csharp.org">
<xsl:output method="xml" omit-xml-declaration="yes" indent="yes" exclude-result-prefixes="msxsl csharp"/>

<msxsl:script language="CSharp" implements-prefix="csharp">
<![CDATA[
	public double circumference(double radius)
	{
		return 2 * Math.PI * radius;
	}
]]>
</msxsl:script>

  <xsl:template match="data">  
  <root>
  <xsl:for-each select="sphere">
    <sphere>
    <xsl:copy-of select="node()"/>
       <circumference>
          <xsl:value-of select="csharp:circumference(radius)"/>        
       </circumference>
    </sphere>
  </xsl:for-each>
  </root>
  </xsl:template>
</xsl:stylesheet>
