<!-- 
Author: M. Seher Altova GmbH
Filename: readfile.xsl
Input: Any xml file
Created: 11.04.2008
Purpose: Demonstrate usage of msxsl:using element.
-->
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:msxsl="urn:schemas-microsoft-com:xslt" xmlns:csharp="http://csharp.org" xmlns:fn="http://www.w3.org/2005/xpath-functions">
<xsl:output method="text" omit-xml-declaration="yes" />

<msxsl:script language="C#" implements-prefix="csharp">
<msxsl:using namespace="System.Text" />
<msxsl:using namespace="System.IO" />
<![CDATA[
	public string GetSomeText(string file)
	{
		try
		{
			Uri uri = new Uri(file);
			using (StreamReader sr = new StreamReader(uri.LocalPath + uri.Fragment))
			{
				return sr.ReadToEnd();
			}
		}
		catch (Exception ex)
		{
			return ex.Message;
		}
	}
]]>
</msxsl:script>
<xsl:template match="/">
<xsl:text> this is a text copy of the source document
</xsl:text>
<xsl:value-of select="csharp:GetSomeText(document-uri(.))" />
</xsl:template>
</xsl:stylesheet>
