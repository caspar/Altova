<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" 
xmlns:local="www.altova.com/xslt2Example" 
exclude-result-prefixes="xs xsi fn">

<!--
Author: M.Grün-Kerr Altova GmbH
Filename: stringQ4.xsl
Section: Write the Xquery use-case in XSLT2  
Purpose: Find news items where a company and one of its partners  is mentioned in the same news item and the news item is  not authored by the company itself. 

NOTE: The output is not a valid XML file 
-->
<!--
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
-->

<xsl:output method="xml" encoding="UTF-8" omit-xml-declaration="yes" />
<xsl:param name="company-dataInstance" select="'company-data.xml'"/>
	
<xsl:function name="local:partners" as="element()*">
<xsl:param name="company" as="xs:string"/>
<xsl:sequence select = "(fn:doc($company-dataInstance)//company[name = $company])//partner"/>
</xsl:function>
	
	
	
	
	
<xsl:template match="news_item">
		
			<xsl:variable name="company_document" select="fn:doc( $company-dataInstance)"/>
			<xsl:variable name="item" select="." />
			<xsl:variable name="c" select="$company_document//company"/>
			<xsl:for-each select="$c">
			     <xsl:variable name="company_name" select="($c)/name"/>
			     <xsl:variable name="partners" select="local:partners($company_name)" />
			     <xsl:if test="contains(string($item), $c/name)
  and (some $p in $partners satisfies
    contains(string($item), $p) and $item/news_agent != $c/name)">
                      <xsl:sequence select="$item"/>
                </xsl:if>
		    </xsl:for-each> <!--company-->
	</xsl:template>
</xsl:stylesheet>
