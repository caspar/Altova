<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:n1="http://www.xmlspy.com/schemas/orgchart" xmlns:ipo="http://www.altova.com/IPO" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <xsl:variable name="fo:layout-master-set">
        <fo:layout-master-set>
            <fo:simple-page-master master-name="default-page" page-height="11in" page-width="8.5in" margin-left="0.6in" margin-right="0.6in">
                <fo:region-body margin-top="0.79in" margin-bottom="0.79in" />
            </fo:simple-page-master>
        </fo:layout-master-set>
    </xsl:variable>
    <xsl:template match="/">
        <fo:root>
            <xsl:copy-of select="$fo:layout-master-set" />
            <fo:page-sequence master-reference="default-page" initial-page-number="1" format="1">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block>
                        <xsl:for-each select="n1:OrgChart">
                            <xsl:for-each select="n1:CompanyLogo">
                                <fo:block space-before.optimum="1pt" space-after.optimum="2pt">
                                    <fo:block border-after-color="#0588BA" border-after-style="solid" border-after-width="medium" border-before-width="4pt" border-end-width="4pt" border-start-width="4pt" padding-after="10px" padding-start="10px">
                                        <xsl:for-each select="@href">
                                            <fo:basic-link text-decoration="underline" color="blue">
                                                <xsl:attribute name="external-destination"><xsl:text disable-output-escaping="yes">http://www.nanonull.com/</xsl:text></xsl:attribute>
                                                <fo:inline>
                                                    <fo:external-graphic space-before.optimum="4pt" space-after.optimum="4pt">
                                                        <xsl:attribute name="src">url('<xsl:value-of select="." />')</xsl:attribute>
                                                    </fo:external-graphic>
                                                </fo:inline>
                                            </fo:basic-link>
                                        </xsl:for-each>
                                    </fo:block>
                                </fo:block>
                            </xsl:for-each>
                            <fo:block>
                                <fo:leader leader-pattern="space" />
                            </fo:block>
                            <xsl:for-each select="n1:Name">
                                <fo:inline color="#0588BA" font-size="20pt" font-weight="bold">
                                    <xsl:apply-templates />
                                </fo:inline>
                            </xsl:for-each>
                            <fo:block>
                                <fo:leader leader-pattern="space" />
                            </fo:block>
                            <fo:block>
                                <fo:leader leader-pattern="space" />
                            </fo:block>
                            <xsl:for-each select="n1:Office">
                                <fo:block>
                                    <xsl:text>&#xA;</xsl:text>
                                </fo:block>
                                <fo:block space-before.optimum="1pt" space-after.optimum="2pt">
                                    <fo:block border-before-color="#0588ba" border-before-style="solid" border-before-width="2pt">
                                        <fo:block>
                                            <fo:leader leader-pattern="space" />
                                        </fo:block>
                                        <xsl:for-each select="n1:Name">
                                            <fo:inline color="#707070" font-size="15pt" font-weight="bold">
                                                <xsl:apply-templates />
                                            </fo:inline>
                                        </xsl:for-each>
                                        <fo:block>
                                            <fo:leader leader-pattern="space" />
                                        </fo:block>
                                        <fo:block>
                                            <fo:leader leader-pattern="space" />
                                        </fo:block>
                                        <fo:inline color="#808080" font-size="inherited-property-value(&apos;font-size&apos;) - 2pt" font-weight="bold">Location: </fo:inline>
                                        <xsl:choose>
                                            <xsl:when test="not(n1:Address or  n1:Address_EU)">
                                                <xsl:for-each select="n1:Location">
                                                    <fo:inline>
                                                        <fo:inline padding-start="2pt" padding-end="2pt" padding-before="2pt" padding-after="2pt" line-height="16pt" text-decoration="underline" color="black">
                                                            <xsl:choose>
                                                                <xsl:when test=".='US'">
                                                                    <fo:inline>US</fo:inline>
                                                                </xsl:when>
                                                                <xsl:when test=".='EU'">
                                                                    <fo:inline>EU</fo:inline>
                                                                </xsl:when>
                                                                <xsl:otherwise>
                                                                    <fo:inline>US</fo:inline>
                                                                </xsl:otherwise>
                                                            </xsl:choose>
                                                        </fo:inline>
                                                    </fo:inline>
                                                </xsl:for-each>
                                            </xsl:when>
                                            <xsl:otherwise>
                                                <xsl:for-each select="n1:Location">
                                                    <fo:inline color="#808080" font-weight="bold">
                                                        <xsl:apply-templates />
                                                    </fo:inline>
                                                </xsl:for-each>
                                            </xsl:otherwise>
                                        </xsl:choose>
                                    </fo:block>
                                </fo:block>
                                <fo:table width="100%" space-before.optimum="1pt" space-after.optimum="2pt">
                                    <fo:table-column column-width="proportional-column-width(60)" />
                                    <fo:table-column column-width="proportional-column-width(40)" />
                                    <fo:table-body>
                                        <fo:table-row>
                                            <fo:table-cell display-align="before" width="60%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" text-align="start" border-style="solid" border-width="1pt" border-color="black">
                                                <fo:block>
                                                    <xsl:choose>
                                                        <xsl:when test="n1:Location =&quot;US&quot;">
                                                            <fo:table width="100%" space-before.optimum="1pt" space-after.optimum="2pt">
                                                                <fo:table-column column-width="proportional-column-width(30)" />
                                                                <xsl:for-each select="n1:Address">
                                                                    <fo:table-column column-width="proportional-column-width(70)" />
                                                                </xsl:for-each>
                                                                <fo:table-body>
                                                                    <fo:table-row>
                                                                        <fo:table-cell width="30%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="white">
                                                                            <fo:block>
                                                                                <fo:inline font-weight="bold">Street: </fo:inline>
                                                                            </fo:block>
                                                                        </fo:table-cell>
                                                                        <xsl:for-each select="n1:Address">
                                                                            <fo:table-cell width="70%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="white">
                                                                                <fo:block>
                                                                                    <xsl:for-each select="ipo:street">
                                                                                        <xsl:apply-templates />
                                                                                    </xsl:for-each>
                                                                                </fo:block>
                                                                            </fo:table-cell>
                                                                        </xsl:for-each>
                                                                    </fo:table-row>
                                                                    <fo:table-row>
                                                                        <fo:table-cell width="30%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="white">
                                                                            <fo:block>
                                                                                <fo:inline font-weight="bold">City:</fo:inline>
                                                                            </fo:block>
                                                                        </fo:table-cell>
                                                                        <xsl:for-each select="n1:Address">
                                                                            <fo:table-cell width="70%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="white">
                                                                                <fo:block>
                                                                                    <xsl:for-each select="ipo:city">
                                                                                        <xsl:apply-templates />
                                                                                    </xsl:for-each>
                                                                                </fo:block>
                                                                            </fo:table-cell>
                                                                        </xsl:for-each>
                                                                    </fo:table-row>
                                                                    <fo:table-row>
                                                                        <fo:table-cell width="30%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="white">
                                                                            <fo:block>
                                                                                <fo:inline font-weight="bold">State &amp; Zip:</fo:inline>
                                                                            </fo:block>
                                                                        </fo:table-cell>
                                                                        <xsl:for-each select="n1:Address">
                                                                            <fo:table-cell width="70%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="white">
                                                                                <fo:block>
                                                                                    <xsl:for-each select="ipo:state">
                                                                                        <fo:inline>
                                                                                            <fo:inline padding-start="2pt" padding-end="2pt" padding-before="2pt" padding-after="2pt" line-height="16pt" text-decoration="underline" color="black">
                                                                                                <xsl:choose>
                                                                                                    <xsl:when test=".='AK'">
                                                                                                        <fo:inline>AK</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='AL'">
                                                                                                        <fo:inline>AL</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='AR'">
                                                                                                        <fo:inline>AR</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='AZ'">
                                                                                                        <fo:inline>AZ</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='CA'">
                                                                                                        <fo:inline>CA</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='CO'">
                                                                                                        <fo:inline>CO</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='CT'">
                                                                                                        <fo:inline>CT</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='DC'">
                                                                                                        <fo:inline>DC</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='DE'">
                                                                                                        <fo:inline>DE</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='FL'">
                                                                                                        <fo:inline>FL</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='GA'">
                                                                                                        <fo:inline>GA</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='GU'">
                                                                                                        <fo:inline>GU</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='HI'">
                                                                                                        <fo:inline>HI</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='IA'">
                                                                                                        <fo:inline>IA</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='ID'">
                                                                                                        <fo:inline>ID</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='IL'">
                                                                                                        <fo:inline>IL</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='IN'">
                                                                                                        <fo:inline>IN</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='KS'">
                                                                                                        <fo:inline>KS</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='KY'">
                                                                                                        <fo:inline>KY</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='LA'">
                                                                                                        <fo:inline>LA</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='MA'">
                                                                                                        <fo:inline>MA</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='MD'">
                                                                                                        <fo:inline>MD</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='ME'">
                                                                                                        <fo:inline>ME</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='MI'">
                                                                                                        <fo:inline>MI</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='MN'">
                                                                                                        <fo:inline>MN</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='MO'">
                                                                                                        <fo:inline>MO</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='MS'">
                                                                                                        <fo:inline>MS</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='MT'">
                                                                                                        <fo:inline>MT</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='NC'">
                                                                                                        <fo:inline>NC</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='ND'">
                                                                                                        <fo:inline>ND</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='NE'">
                                                                                                        <fo:inline>NE</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='NH'">
                                                                                                        <fo:inline>NH</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='NJ'">
                                                                                                        <fo:inline>NJ</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='NM'">
                                                                                                        <fo:inline>NM</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='NV'">
                                                                                                        <fo:inline>NV</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='NY'">
                                                                                                        <fo:inline>NY</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='OH'">
                                                                                                        <fo:inline>OH</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='OK'">
                                                                                                        <fo:inline>OK</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='OR'">
                                                                                                        <fo:inline>OR</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='PA'">
                                                                                                        <fo:inline>PA</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='PR'">
                                                                                                        <fo:inline>PR</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='RI'">
                                                                                                        <fo:inline>RI</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='SC'">
                                                                                                        <fo:inline>SC</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='SD'">
                                                                                                        <fo:inline>SD</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='TN'">
                                                                                                        <fo:inline>TN</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='TX'">
                                                                                                        <fo:inline>TX</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='UT'">
                                                                                                        <fo:inline>UT</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='VA'">
                                                                                                        <fo:inline>VA</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='VI'">
                                                                                                        <fo:inline>VI</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='VT'">
                                                                                                        <fo:inline>VT</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='WA'">
                                                                                                        <fo:inline>WA</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='WI'">
                                                                                                        <fo:inline>WI</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='WV'">
                                                                                                        <fo:inline>WV</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:when test=".='WY'">
                                                                                                        <fo:inline>WY</fo:inline>
                                                                                                    </xsl:when>
                                                                                                    <xsl:otherwise>
                                                                                                        <fo:inline>AK</fo:inline>
                                                                                                    </xsl:otherwise>
                                                                                                </xsl:choose>
                                                                                            </fo:inline>
                                                                                        </fo:inline>
                                                                                    </xsl:for-each>&#160;<xsl:for-each select="ipo:zip">
                                                                                        <fo:inline padding-start="2pt" padding-end="2pt" padding-before="2pt" padding-after="2pt" line-height="18pt" text-decoration="underline" color="black">
                                                                                            <fo:inline><xsl:value-of select="substring(.,1,26)" /></fo:inline>
                                                                                        </fo:inline>
                                                                                    </xsl:for-each>
                                                                                </fo:block>
                                                                            </fo:table-cell>
                                                                        </xsl:for-each>
                                                                    </fo:table-row>
                                                                </fo:table-body>
                                                            </fo:table>
                                                        </xsl:when>
                                                        <xsl:when test="n1:Location =&quot;EU&quot;">
                                                            <fo:table width="100%" space-before.optimum="1pt" space-after.optimum="2pt">
                                                                <fo:table-column column-width="proportional-column-width(30)" />
                                                                <xsl:for-each select="n1:Address_EU">
                                                                    <fo:table-column column-width="proportional-column-width(70)" />
                                                                </xsl:for-each>
                                                                <fo:table-body>
                                                                    <fo:table-row>
                                                                        <fo:table-cell width="30%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="white">
                                                                            <fo:block>
                                                                                <fo:inline font-weight="bold">Street:</fo:inline>
                                                                            </fo:block>
                                                                        </fo:table-cell>
                                                                        <xsl:for-each select="n1:Address_EU">
                                                                            <fo:table-cell width="70%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="white">
                                                                                <fo:block>
                                                                                    <xsl:for-each select="ipo:street">
                                                                                        <fo:inline padding-start="2pt" padding-end="2pt" padding-before="2pt" padding-after="2pt" line-height="18pt" text-decoration="underline" color="black">
                                                                                            <fo:inline><xsl:value-of select="substring(.,1,26)" /></fo:inline>
                                                                                        </fo:inline>
                                                                                    </xsl:for-each>
                                                                                </fo:block>
                                                                            </fo:table-cell>
                                                                        </xsl:for-each>
                                                                    </fo:table-row>
                                                                    <fo:table-row>
                                                                        <fo:table-cell width="30%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="white">
                                                                            <fo:block>
                                                                                <fo:inline font-weight="bold">City:</fo:inline>
                                                                            </fo:block>
                                                                        </fo:table-cell>
                                                                        <xsl:for-each select="n1:Address_EU">
                                                                            <fo:table-cell width="70%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="white">
                                                                                <fo:block>
                                                                                    <xsl:for-each select="ipo:city">
                                                                                        <fo:inline padding-start="2pt" padding-end="2pt" padding-before="2pt" padding-after="2pt" line-height="18pt" text-decoration="underline" color="black">
                                                                                            <fo:inline><xsl:value-of select="substring(.,1,26)" /></fo:inline>
                                                                                        </fo:inline>
                                                                                    </xsl:for-each>
                                                                                </fo:block>
                                                                            </fo:table-cell>
                                                                        </xsl:for-each>
                                                                    </fo:table-row>
                                                                    <fo:table-row>
                                                                        <fo:table-cell width="30%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="white">
                                                                            <fo:block>
                                                                                <fo:inline font-weight="bold">Post Code:</fo:inline>
                                                                            </fo:block>
                                                                        </fo:table-cell>
                                                                        <xsl:for-each select="n1:Address_EU">
                                                                            <fo:table-cell width="70%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="white">
                                                                                <fo:block>
                                                                                    <xsl:for-each select="ipo:postcode">
                                                                                        <fo:inline padding-start="2pt" padding-end="2pt" padding-before="2pt" padding-after="2pt" line-height="18pt" text-decoration="underline" color="black">
                                                                                            <fo:inline><xsl:value-of select="substring(.,1,26)" /></fo:inline>
                                                                                        </fo:inline>
                                                                                    </xsl:for-each>
                                                                                </fo:block>
                                                                            </fo:table-cell>
                                                                        </xsl:for-each>
                                                                    </fo:table-row>
                                                                </fo:table-body>
                                                            </fo:table>
                                                        </xsl:when>
                                                    </xsl:choose>
                                                </fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell display-align="before" width="40%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" text-align="start" border-style="solid" border-width="1pt" border-color="black">
                                                <fo:block>
                                                    <fo:table width="100%" space-before.optimum="1pt" space-after.optimum="2pt">
                                                        <fo:table-column column-width="proportional-column-width(25)" />
                                                        <fo:table-column column-width="proportional-column-width(75)" />
                                                        <fo:table-body>
                                                            <fo:table-row>
                                                                <fo:table-cell width="25%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="white">
                                                                    <fo:block>
                                                                        <fo:inline font-weight="bold">Phone:</fo:inline>
                                                                    </fo:block>
                                                                </fo:table-cell>
                                                                <fo:table-cell width="75%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="white">
                                                                    <fo:block>
                                                                        <xsl:for-each select="n1:Phone">
                                                                            <xsl:apply-templates />
                                                                        </xsl:for-each>
                                                                    </fo:block>
                                                                </fo:table-cell>
                                                            </fo:table-row>
                                                            <fo:table-row>
                                                                <fo:table-cell width="25%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="white">
                                                                    <fo:block>
                                                                        <fo:inline font-weight="bold">Fax:</fo:inline>
                                                                    </fo:block>
                                                                </fo:table-cell>
                                                                <fo:table-cell width="75%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="white">
                                                                    <fo:block>
                                                                        <xsl:for-each select="n1:Fax">
                                                                            <xsl:apply-templates />
                                                                        </xsl:for-each>
                                                                    </fo:block>
                                                                </fo:table-cell>
                                                            </fo:table-row>
                                                            <fo:table-row>
                                                                <fo:table-cell width="25%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="white">
                                                                    <fo:block>
                                                                        <fo:inline font-weight="bold">E-mail:</fo:inline>
                                                                    </fo:block>
                                                                </fo:table-cell>
                                                                <fo:table-cell width="75%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="white">
                                                                    <fo:block>
                                                                        <xsl:for-each select="n1:EMail">
                                                                            <fo:basic-link text-decoration="underline" color="blue">
                                                                                <xsl:attribute name="external-destination"><xsl:text disable-output-escaping="yes">mailto:</xsl:text><xsl:value-of select="." /></xsl:attribute>
                                                                                <fo:inline>
                                                                                    <xsl:apply-templates />
                                                                                </fo:inline>
                                                                            </fo:basic-link>
                                                                        </xsl:for-each>
                                                                    </fo:block>
                                                                </fo:table-cell>
                                                            </fo:table-row>
                                                        </fo:table-body>
                                                    </fo:table>
                                                </fo:block>
                                            </fo:table-cell>
                                        </fo:table-row>
                                    </fo:table-body>
                                </fo:table>
                                <fo:block>
                                    <fo:leader leader-pattern="space" />
                                </fo:block>
                                <xsl:choose>
                                    <xsl:when test="n1:Address">
                                        <xsl:for-each select="n1:Address">
                                            <fo:inline color="#004080" font-size="10pt" font-weight="bold">
                                                <xsl:for-each select="ipo:city">
                                                    <fo:inline color="#004080" font-size="10pt" font-weight="bold" text-decoration="underline">
                                                        <xsl:apply-templates />
                                                    </fo:inline>
                                                </xsl:for-each>
                                            </fo:inline>
                                        </xsl:for-each>
                                    </xsl:when>
                                    <xsl:when test="n1:Address_EU">
                                        <xsl:for-each select="n1:Address_EU">
                                            <xsl:for-each select="ipo:city">
                                                <fo:inline color="#004080" font-size="10pt" font-weight="bold" text-decoration="underline">
                                                    <xsl:apply-templates />
                                                </fo:inline>
                                            </xsl:for-each>
                                        </xsl:for-each>
                                    </xsl:when>
                                </xsl:choose>
                                <fo:inline color="#004080" font-size="10pt" font-weight="bold" text-decoration="underline"> Office Summary:</fo:inline>&#160; <fo:inline color="#004080" font-size="10pt" font-weight="bold">
                                    <xsl:value-of select="count(n1:Department)" />
                                </fo:inline>
                                <fo:inline color="#004080" font-size="10pt" font-weight="bold"> department</fo:inline>
                                <xsl:if test="count(n1:Department) != 1">
                                    <fo:inline color="#004080" font-size="10pt" font-weight="bold">s</fo:inline>
                                </xsl:if>
                                <fo:inline color="#004080" font-size="10pt" font-weight="bold">, </fo:inline>
                                <fo:inline color="#004080" font-size="10pt" font-weight="bold">
                                    <xsl:value-of select="count(n1:Department/n1:Person)" />
                                </fo:inline>
                                <fo:inline color="#004080" font-size="10pt" font-weight="bold"> employee</fo:inline>
                                <xsl:if test="count(n1:Department/n1:Person) != 1">
                                    <fo:inline color="#004080" font-size="10pt" font-weight="bold">s</fo:inline>
                                </xsl:if>
                                <fo:inline color="#004080" font-size="10pt" font-weight="bold">.</fo:inline>
                                <xsl:for-each select="n1:Desc">
                                    <xsl:for-each select="n1:para">
                                        <fo:block space-before.optimum="1pt" space-after.optimum="2pt">
                                            <fo:block>
                                                <xsl:apply-templates />
                                            </fo:block>
                                        </fo:block>
                                    </xsl:for-each>
                                </xsl:for-each>
                                <xsl:for-each select="n1:Department">
                                    <fo:block>
                                        <fo:leader leader-pattern="space" />
                                    </fo:block>
                                    <xsl:for-each select="n1:Name">
                                        <fo:inline color="#D39658" font-weight="bold">
                                            <xsl:apply-templates />
                                        </fo:inline>
                                    </xsl:for-each>&#160; <fo:inline color="#D39658"></fo:inline>
                                    <fo:inline color="#D39658" font-weight="bold">( </fo:inline>
                                    <fo:inline color="#D39658" font-weight="bold">
                                        <xsl:value-of select="count(n1:Person)" />
                                    </fo:inline>
                                    <fo:inline color="#D39658" font-weight="bold"> )</fo:inline>
                                    <fo:block>
                                        <fo:leader leader-pattern="space" />
                                    </fo:block>
                                    <fo:table padding="3" width="100%" space-before.optimum="1pt" space-after.optimum="2pt">
                                        <fo:table-column column-width="proportional-column-width(10)" />
                                        <fo:table-column column-width="proportional-column-width(12)" />
                                        <fo:table-column column-width="proportional-column-width(16)" />
                                        <fo:table-column column-width="proportional-column-width(5)" />
                                        <fo:table-column column-width="proportional-column-width(23)" />
                                        <fo:table-column column-width="proportional-column-width(10)" />
                                        <fo:table-column column-width="proportional-column-width(8)" />
                                        <fo:table-column column-width="proportional-column-width(8)" />
                                        <fo:table-column column-width="proportional-column-width(8)" />
                                        <fo:table-header>
                                            <fo:table-row background-color="#D2C8AE">
                                                <fo:table-cell background-color="#D2C8AE" number-rows-spanned="2" text-align="center" width="10%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" border-style="solid" border-width="1pt" border-color="black">
                                                    <fo:block>
                                                        <fo:inline color="#606060" font-weight="bold">First</fo:inline>
                                                    </fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell background-color="#D2C8AE" number-rows-spanned="2" text-align="center" width="12%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" border-style="solid" border-width="1pt" border-color="black">
                                                    <fo:block>
                                                        <fo:inline color="#606060" font-weight="bold">Last</fo:inline>
                                                    </fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell background-color="#D2C8AE" number-rows-spanned="2" text-align="center" width="16%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" border-style="solid" border-width="1pt" border-color="black">
                                                    <fo:block>
                                                        <fo:inline color="#606060" font-weight="bold">Title</fo:inline>
                                                    </fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell background-color="#D2C8AE" number-rows-spanned="2" text-align="center" width="5%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" border-style="solid" border-width="1pt" border-color="black">
                                                    <fo:block>
                                                        <fo:inline color="#606060" font-weight="bold">Ext</fo:inline>
                                                    </fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell background-color="#D2C8AE" number-rows-spanned="2" text-align="center" width="23%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" border-style="solid" border-width="1pt" border-color="black">
                                                    <fo:block>
                                                        <fo:inline color="#606060" font-weight="bold">EMail</fo:inline>
                                                    </fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell background-color="#D2C8AE" number-rows-spanned="2" text-align="center" width="10%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" border-style="solid" border-width="1pt" border-color="black">
                                                    <fo:block>
                                                        <fo:inline color="#606060" font-weight="bold">Shares</fo:inline>
                                                    </fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell number-columns-spanned="3" text-align="center" width="8%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" border-style="solid" border-width="1pt" border-color="black">
                                                    <fo:block>
                                                        <fo:inline color="#606060" font-weight="bold">Leave</fo:inline>
                                                    </fo:block>
                                                </fo:table-cell>
                                            </fo:table-row>
                                            <fo:table-row>
                                                <fo:table-cell background-color="#D2C8AE" text-align="center" width="8%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" border-style="solid" border-width="1pt" border-color="black">
                                                    <fo:block>
                                                        <fo:inline color="#606060" font-weight="bold">Total</fo:inline>
                                                    </fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell background-color="#D2C8AE" text-align="center" width="8%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" border-style="solid" border-width="1pt" border-color="black">
                                                    <fo:block>
                                                        <fo:inline color="#606060" font-weight="bold">Used</fo:inline>
                                                    </fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell background-color="#D2C8AE" text-align="center" width="8%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" border-style="solid" border-width="1pt" border-color="black">
                                                    <fo:block>
                                                        <fo:inline color="#606060" font-weight="bold">Left</fo:inline>
                                                    </fo:block>
                                                </fo:table-cell>
                                            </fo:table-row>
                                        </fo:table-header>
                                        <fo:table-footer>
                                            <fo:table-row background-color="#F2F0E6">
                                                <fo:table-cell display-align="before" number-columns-spanned="5" text-align="left" width="23%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" border-style="solid" border-width="1pt" border-color="black">
                                                    <fo:block>
                                                        <fo:inline color="#004080" font-size="8pt" font-weight="bold">Employees:&#160; </fo:inline>
                                                        <fo:inline color="#004080" font-size="8pt" font-weight="bold">
                                                            <xsl:value-of select="count(  n1:Person  )" />
                                                        </fo:inline>
                                                        <fo:inline font-size="8pt">&#160;</fo:inline>
                                                        <fo:inline color="#004080" font-size="8pt" font-weight="bold">(</fo:inline>
                                                        <fo:inline color="#004080" font-size="8pt" font-weight="bold">
                                                            <xsl:value-of select="round ((count(  n1:Person  ) ) div ( count( ../n1:Department/ n1:Person  ) ) * 100)" />
                                                        </fo:inline>
                                                        <fo:inline color="#004080" font-size="8pt" font-weight="bold">% of Office, </fo:inline>
                                                        <fo:inline color="#004080" font-size="8pt" font-weight="bold">
                                                            <xsl:value-of select="round ((count(  n1:Person  ) ) div ( count( ../../n1:Office/n1:Department/ n1:Person  ) ) * 100)" />
                                                        </fo:inline>
                                                        <fo:inline color="#004080" font-size="8pt" font-weight="bold">% of Company)</fo:inline>
                                                    </fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell number-columns-spanned="4" text-align="left" width="10%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" border-style="solid" border-width="1pt" border-color="black">
                                                    <fo:block>
                                                        <fo:inline color="#004080" font-size="8pt" font-weight="bold">Shares: </fo:inline>
                                                        <fo:inline color="#004080" font-size="8pt" font-weight="bold">
                                                            <xsl:value-of select="sum(  n1:Person/n1:Shares  )" />
                                                        </fo:inline>
                                                        <fo:inline font-size="8pt">&#160;</fo:inline>
                                                        <fo:inline color="#004080" font-size="8pt" font-weight="bold">(</fo:inline>
                                                        <fo:inline color="#004080" font-size="8pt" font-weight="bold">
                                                            <xsl:value-of select="round((sum(  n1:Person/n1:Shares  ) ) div (sum(../n1:Department/ n1:Person/n1:Shares ) ) * 100)" />
                                                        </fo:inline>
                                                        <fo:inline color="#004080" font-size="8pt" font-weight="bold">% of Office, </fo:inline>
                                                        <fo:inline color="#004080" font-size="8pt" font-weight="bold">
                                                            <xsl:value-of select="round((sum(  n1:Person/n1:Shares  ) ) div (sum(../../n1:Office/n1:Department/ n1:Person/n1:Shares  )) * 100)" />
                                                        </fo:inline>
                                                        <fo:inline color="#004080" font-size="8pt" font-weight="bold">% of Company)</fo:inline>
                                                    </fo:block>
                                                </fo:table-cell>
                                            </fo:table-row>
                                            <fo:table-row background-color="#F2F0E6">
                                                <fo:table-cell number-columns-spanned="9" text-align="left" width="23%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" border-style="solid" border-width="1pt" border-color="black">
                                                    <fo:block>
                                                        <fo:inline color="#004080" font-size="8pt" font-weight="bold">Non-Shareholders: </fo:inline>
                                                        <fo:inline color="#004040" font-size="8pt" font-weight="bold">&#160;</fo:inline>
                                                        <xsl:for-each select="n1:Person">
                                                            <xsl:if test="n1:Shares &lt;= 0 or not (n1:Shares)">
                                                                <xsl:for-each select="n1:First">
                                                                    <fo:inline color="#004040" font-size="8pt" font-weight="bold">
                                                                        <xsl:apply-templates />
                                                                    </fo:inline>
                                                                </xsl:for-each>
                                                                <fo:inline color="#004040" font-size="8pt" font-weight="bold">&#160;</fo:inline>
                                                                <xsl:for-each select="n1:Last">
                                                                    <fo:inline color="#004040" font-size="8pt" font-weight="bold">
                                                                        <xsl:apply-templates />
                                                                    </fo:inline>
                                                                </xsl:for-each>
                                                                <xsl:if test="following-sibling::n1:Person[n1:Shares&lt;=0 or not(n1:Shares)]">
                                                                    <fo:inline color="#004040" font-size="8pt" font-weight="bold">, </fo:inline>
                                                                </xsl:if>
                                                            </xsl:if>
                                                        </xsl:for-each>
                                                        <xsl:if test="count(  n1:Person  ) = count(  n1:Person [n1:Shares&gt;0] )">
                                                            <fo:inline color="#004040" font-size="8pt" font-weight="bold">None</fo:inline>
                                                        </xsl:if>
                                                        <fo:inline color="#004040" font-size="8pt" font-weight="bold">.</fo:inline>
                                                    </fo:block>
                                                </fo:table-cell>
                                            </fo:table-row>
                                        </fo:table-footer>
                                        <fo:table-body>
                                            <xsl:for-each select="n1:Person">
                                                <fo:table-row>
                                                    <fo:table-cell width="10%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="black">
                                                        <fo:block>
                                                            <xsl:for-each select="n1:First">
                                                                <xsl:choose>
                                                                    <xsl:when test="../n1:Shares &gt; 0">
                                                                        <fo:inline font-size="10pt" font-weight="bold">
                                                                            <xsl:apply-templates />
                                                                        </fo:inline>
                                                                    </xsl:when>
                                                                    <xsl:otherwise>
                                                                        <fo:inline font-size="10pt">
                                                                            <xsl:apply-templates />
                                                                        </fo:inline>
                                                                    </xsl:otherwise>
                                                                </xsl:choose>
                                                            </xsl:for-each>
                                                        </fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell width="12%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="black">
                                                        <fo:block>
                                                            <xsl:for-each select="n1:Last">
                                                                <xsl:choose>
                                                                    <xsl:when test="../n1:Shares &gt; 0">
                                                                        <fo:inline font-size="10pt" font-weight="bold">
                                                                            <xsl:apply-templates />
                                                                        </fo:inline>
                                                                    </xsl:when>
                                                                    <xsl:otherwise>
                                                                        <fo:inline font-size="10pt">
                                                                            <xsl:apply-templates />
                                                                        </fo:inline>
                                                                    </xsl:otherwise>
                                                                </xsl:choose>
                                                            </xsl:for-each>
                                                        </fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell width="16%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="black">
                                                        <fo:block>
                                                            <xsl:for-each select="n1:Title">
                                                                <fo:inline font-size="10pt">
                                                                    <xsl:apply-templates />
                                                                </fo:inline>
                                                            </xsl:for-each>
                                                        </fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell text-align="center" width="5%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" border-style="solid" border-width="1pt" border-color="black">
                                                        <fo:block>
                                                            <xsl:for-each select="n1:PhoneExt">
                                                                <fo:inline font-size="10pt">
                                                                    <xsl:apply-templates />
                                                                </fo:inline>
                                                            </xsl:for-each>
                                                        </fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell width="23%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" text-align="start" border-style="solid" border-width="1pt" border-color="black">
                                                        <fo:block>
                                                            <xsl:for-each select="n1:EMail">
                                                                <fo:basic-link text-decoration="underline" color="blue">
                                                                    <xsl:attribute name="external-destination"><xsl:text disable-output-escaping="yes">mailto:</xsl:text><xsl:value-of select="." /></xsl:attribute>
                                                                    <fo:inline>
                                                                        <fo:inline font-size="10pt">
                                                                            <xsl:apply-templates />
                                                                        </fo:inline>
                                                                    </fo:inline>
                                                                </fo:basic-link>
                                                            </xsl:for-each>
                                                        </fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell text-align="center" width="10%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" border-style="solid" border-width="1pt" border-color="black">
                                                        <fo:block>
                                                            <xsl:for-each select="n1:Shares">
                                                                <fo:inline font-size="10pt">
                                                                    <xsl:apply-templates />
                                                                </fo:inline>
                                                            </xsl:for-each>
                                                        </fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell text-align="center" width="8%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" border-style="solid" border-width="1pt" border-color="black">
                                                        <fo:block>
                                                            <xsl:for-each select="n1:LeaveTotal">
                                                                <fo:inline font-size="10pt">
                                                                    <xsl:apply-templates />
                                                                </fo:inline>
                                                            </xsl:for-each>
                                                        </fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell text-align="center" width="8%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" border-style="solid" border-width="1pt" border-color="black">
                                                        <fo:block>
                                                            <xsl:for-each select="n1:LeaveUsed">
                                                                <fo:inline font-size="10pt">
                                                                    <xsl:apply-templates />
                                                                </fo:inline>
                                                            </xsl:for-each>
                                                        </fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell text-align="center" width="8%" padding-start="3pt" padding-end="3pt" padding-before="3pt" padding-after="3pt" display-align="center" border-style="solid" border-width="1pt" border-color="black">
                                                        <fo:block>
                                                            <fo:inline font-size="10pt">
                                                                <xsl:value-of select="n1:LeaveTotal - n1:LeaveUsed" />
                                                            </fo:inline>
                                                        </fo:block>
                                                    </fo:table-cell>
                                                </fo:table-row>
                                            </xsl:for-each>
                                        </fo:table-body>
                                    </fo:table>
                                    <fo:block>
                                        <fo:leader leader-pattern="space" />
                                    </fo:block>
                                </xsl:for-each>
                            </xsl:for-each>
                            <fo:block>
                                <xsl:text>&#xA;</xsl:text>
                            </fo:block>
                        </xsl:for-each>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
    <xsl:template match="n1:bold">
        <fo:inline font-weight="bold">
            <xsl:apply-templates />
        </fo:inline>
    </xsl:template>
    <xsl:template match="n1:italic">
        <fo:inline font-style="italic">
            <xsl:apply-templates />
        </fo:inline>
    </xsl:template>
</xsl:stylesheet>
