<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
<xsl:output method="xml" version="1.0" encoding="UTF-8" omit-xml-declaration="no" doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN" doctype-system="xhtml1-transitional.dtd" indent="no" media-type="text/html"/>

<xsl:variable name="navigation_document" select="'navigation.xml'"/>
<xsl:variable name="blocks_document" select="'blocks2.xml'"/>
<xsl:variable name="currentsection" select="/main/idref"/>

<!--*************************************************-->
<!--************************main**********************-->
<!--*************************************************-->
      <xsl:template match="main">
         <html>
             <xsl:call-template name="site_header"/>
             <xsl:call-template name="display_site"/>
       </html>
      </xsl:template>
<!--*************************************************-->
	  
<!--*************************************************-->
<!--************************site_header************-->
<!--*************************************************-->
      <xsl:template name="site_header">
          <head>
		     <xsl:call-template name="page_title"/>
                  <xsl:call-template name="css_insert"/>
	    </head>
      </xsl:template>
<!--*************************************************-->
  
<!--*************************************************-->
<!--************************page_title************-->
<!--*************************************************-->
     <xsl:template name="page_title">
   		<title>
   		     <xsl:value-of select="/main/pagetitle"/>
   		</title>
     </xsl:template>
<!--*************************************************-->
  
<!--*************************************************-->
<!--************************css_insert************-->
<!--*************************************************-->
     <xsl:template name="css_insert">
		 <link rel="stylesheet" type="text/css" media="screen" href="examplesite1.css"/>	  
     </xsl:template>
<!--*************************************************-->
  
  
  
<!--*************************************************-->
<!--************************display_site************-->
<!--*************************************************-->
	<xsl:template name="display_site">
		<body>
			<table class="formatter" cellspacing="0" cellpadding="0" border="0">
				<tr>
					<td class="banner">
					    <xsl:call-template name="banner"/>
					</td>
				</tr>
				<tr>
					<td class="horizontaltoolbar">
  					   <xsl:call-template name="horizontaltoolbar"/>
					</td>
				</tr>
				<tr>
					<td>
						<table class="formatter" cellspacing="0" cellpadding="0" border="0">
							<tr>
								<td class="verticaltoolbar">
									<xsl:call-template name="verticaltoolbar"/>
								</td>
								<td class="maincontent">
                                            <xsl:call-template name="maincontent"/>
								</td>
								<td class="flagbar">
								    <xsl:call-template name="flagbar"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="footer">
   					     <xsl:call-template name="footer"/>
					</td>
				</tr>
			</table>
		</body>
	</xsl:template>
<!--*************************************************-->
  
<!--*************************************************-->
<!--************************flagbar******************-->
<!--*************************************************-->
	<xsl:template name="flagbar">
		<div class="flagbar">
             </div>
	</xsl:template>
<!--*************************************************-->
  
<!--*************************************************-->
<!--************************banner*****************-->
<!--*************************************************-->
	<xsl:template name="banner">
		<div class="banner">
		    <xsl:call-template name="handlepagefragment">
		       <xsl:with-param name="blockid">sample</xsl:with-param>
		    </xsl:call-template>
             </div>
	</xsl:template>
<!--*************************************************-->
  
<!--*************************************************-->
<!--************************horizontaltoolbar******-->
<!--*************************************************-->
	<xsl:template name="horizontaltoolbar">
		<div class="horizontaltoolbar">
		     <xsl:for-each select="document($navigation_document)">
		          <table cellpadding="0" cellspacing="0">
		          <tr>
                        <xsl:for-each select="navigation/menu/menu">
                             <xsl:call-template name="htbitem"/>                        
                        </xsl:for-each>
                        </tr>
                        </table>
		     </xsl:for-each>
             </div>
	</xsl:template>
<!--*************************************************-->
  
  
<!--*************************************************-->
<!--************************htbitem*****************-->
<!--*************************************************-->
	<xsl:template name="htbitem">
	     <td > 
	       <xsl:call-template name="htbclass"/>
	        <a>
      	           <xsl:call-template name="htbclass"/>
	           <xsl:call-template name="menuurl"/>
	           <xsl:value-of select="title"/>
	        </a>
	     </td>
	</xsl:template>
<!--*************************************************-->

<xsl:template name="htbclass">
   <xsl:attribute name="class">
        <xsl:choose>
		<xsl:when test="descendant-or-self::*[id=$currentsection]">
		    selectedhtbitem
		</xsl:when>
		<xsl:otherwise>
		    htbitem
		</xsl:otherwise>
	</xsl:choose>
   </xsl:attribute>
</xsl:template>

<!--*************************************************-->
<!--************************menuurl******-->
<!--*************************************************-->
	<xsl:template name="menuurl">
	    <xsl:attribute name="href">
	    <xsl:choose>
	           <xsl:when test="count(idref)>0">
	                <xsl:call-template name="lookupmenu">
	                    <xsl:with-param name="menuid">
	                       <xsl:value-of select="idref"/>
	                    </xsl:with-param>
	                </xsl:call-template>
	           </xsl:when>
	           <xsl:when test="url">
 	               <xsl:value-of select="url"/>
	           </xsl:when>
	           <xsl:when test="count(menu)>0">
                  <xsl:for-each select="menu">
	                     <xsl:if test="position()=1">
  	                         <xsl:call-template name="url"/>                 
	                     </xsl:if>
                     </xsl:for-each>
 	           </xsl:when>
	       </xsl:choose>
	    </xsl:attribute>
	</xsl:template>
<!--*************************************************-->


<!--*************************************************-->
<!--************************lookupmenu******-->
<!--*************************************************-->
	<xsl:template name="lookupmenu">
	    <xsl:param name="menuid"/>lookup
           <xsl:for-each select="document($navigation_document)//menu">
                 <xsl:if test="id=$menuid">
                        <xsl:call-template name="url"/>                 
                 </xsl:if>
		</xsl:for-each>
	</xsl:template>
<!--*************************************************-->



<!--*************************************************-->
<!--************************url******-->
<!--*************************************************-->
	<xsl:template name="url">
	   <xsl:choose>
		<xsl:when test="url">
		    <xsl:value-of select="url"/>
		</xsl:when>
             <xsl:otherwise>
	               <xsl:for-each select="menu">
	                     <xsl:if test="position()=1">
  	                         <xsl:call-template name="url"/>                 
	                     </xsl:if>
                       </xsl:for-each>
             </xsl:otherwise>		
   	  </xsl:choose>
	</xsl:template>
<!--*************************************************-->

  
<!--*************************************************-->
<!--************************maincontent*****************-->
<!--*************************************************-->
	<xsl:template name="maincontent">
		<div class="maincontent">
		   <xsl:apply-templates select="/main/content"/>
             </div>
	</xsl:template>
<!--*************************************************-->
  
<!--*************************************************-->
<!--************************verticaltoolbar************-->
<!--*************************************************-->
	<xsl:template name="verticaltoolbar">
		     <xsl:for-each select="document($navigation_document)">
                        <xsl:for-each select="navigation/menu/menu">
                            <xsl:choose>
		                    <xsl:when test="descendant-or-self::*[id=$currentsection]">
                                         <xsl:call-template name="rendervtb"/>		       
		                    </xsl:when>
                    	</xsl:choose>
                        </xsl:for-each>
		     </xsl:for-each>
	</xsl:template>
<!--*************************************************-->
  
<!--*************************************************-->
<!--************************rendervtb************-->
<!--*************************************************-->
	<xsl:template name="rendervtb">
	    <div class="verticaltoolbar">
		   <table cellpadding="0"	cellspacing="0">
		          <xsl:for-each select="menu">
		          <tr>
 		            <td > 
 	                      <xsl:call-template name="vtbclass"/>
	                       <a>
      	                           <xsl:call-template name="vtbclass"/>
	                           <xsl:call-template name="menuurl"/>
	                           <xsl:value-of select="title"/>
	                         </a>
	                       </td>
		             </tr>
		          </xsl:for-each>
		   </table>
           </div>
       </xsl:template>
<!--*************************************************-->
  
  <xsl:template name="vtbclass">
   <xsl:attribute name="class">
        <xsl:choose>
		<xsl:when test="descendant-or-self::*[id=$currentsection]">
		    selectedvtbitem
		</xsl:when>
		<xsl:otherwise>
		    vtbitem
		</xsl:otherwise>
	</xsl:choose>
   </xsl:attribute>
</xsl:template>


  
  
<!--*************************************************-->
<!--************************footer************-->
<!--*************************************************-->
	<xsl:template name="footer">
		<div class="footer">
             </div>
	</xsl:template>
<!--*************************************************-->

<!--*************************************************-->
<!--************************pagefragment************-->
<!--*************************************************-->
       <xsl:template match="pagefragment">
       <xsl:choose>
	       <xsl:when test="count(@idref)>0">
	             <xsl:call-template name="handlepagefragment">
 	                  <xsl:with-param name="blockid" select="@idref"/>
	             </xsl:call-template>
	       </xsl:when>
	       <xsl:otherwise>
                   <div style="fragment">
                         <xsl:apply-templates select="*"/>
                   </div> 
	       </xsl:otherwise>
	</xsl:choose>
       </xsl:template>
<!--*************************************************-->

<!--*************************************************-->
<!--************************handlepagefragment************-->
<!--*************************************************-->
       <xsl:template name="handlepagefragment">
       <xsl:param name="blockid"/>
           <xsl:for-each select="document('blocks.xml')">
                 <xsl:for-each select="//block_instance">
                     <xsl:choose>
                         <xsl:when test="id=$blockid">
                              <xsl:apply-templates select="pagefragment"/>
                         </xsl:when>
                     </xsl:choose>
                 </xsl:for-each> 
           </xsl:for-each>
       </xsl:template>
<!--*************************************************-->
  
  
<!--*************************************************-->
<!--************************table************-->
<!--*************************************************-->
      <xsl:template match="table">
          <table border="0" style="width:100%;" cellspacing="0" cellpadding="0">
               <xsl:for-each select="tr">
                     <tr>
                         <xsl:for-each select="td">
                            <td>
                                <xsl:if test="count(@style)>0"><xsl:attribute name="style"><xsl:value-of select="@style"/></xsl:attribute></xsl:if>
                                 <xsl:apply-templates/>
                           </td>
                         </xsl:for-each>                     
                     </tr>               
               </xsl:for-each>
          </table>
          <br/>
      </xsl:template>
<!--*************************************************-->
  
<!--*************************************************-->
<!--************************list************-->
<!--*************************************************-->
      <xsl:template match="list">
          <br/>
          <table border="0" style="width:100%;" cellspacing="0" cellpadding="0">
               <xsl:for-each select="listitem">
                     <tr>
                            <td>
                                 	<xsl:apply-templates/>
                           </td>
                     </tr>               
                     <tr>
                       <td class="listseperator"> 
                            <img src="images/blank.gif" alt="." class="listseperator"/>
                       </td> 
                       </tr>
               </xsl:for-each>
          </table>
      </xsl:template>
<!--*************************************************-->
  
<!--*************************************************-->
<!--************************header************-->
<!--*************************************************-->
    <xsl:template match="header">
        <span class="pageheader">  
             <xsl:apply-templates/>
         </span>
    </xsl:template>
<!--*************************************************-->
  
<!--*************************************************-->
<!--************************img************-->
<!--*************************************************-->
    <xsl:template match="img">
       <img alt="">
          <xsl:attribute name="src">
                  <xsl:value-of select="if (starts-with(@src, 'output/')) then substring-after(@src, 'output/') else @src"/>
          </xsl:attribute>
       </img>
    </xsl:template>
<!--*************************************************-->

<!--*************************************************-->
<!--************************para************-->
<!--*************************************************-->
    <xsl:template match="para">
       <p>
         <xsl:apply-templates/>
       </p>
    </xsl:template>
<!--*************************************************-->

<!--*************************************************-->
<!--************************br************-->
<!--*************************************************-->
    <xsl:template match="br">
      <br/>
    </xsl:template>
<!--*************************************************-->

<!--*************************************************-->
<!--************************strong************-->
<!--*************************************************-->
    <xsl:template match="bold">
      <b>
         <xsl:apply-templates/>
      </b>
    </xsl:template>
<!--*************************************************-->

<!--*************************************************-->
<!--************************link************-->
<!--*************************************************-->
    <xsl:template match="link">
      <a>
         <xsl:choose>
            <xsl:when test="idref">
                <xsl:call-template name="link_url">
                  <xsl:with-param name="linkid"><xsl:value-of select="idref"/></xsl:with-param>
                </xsl:call-template>
            </xsl:when>
           <xsl:otherwise>
             <xsl:attribute name="href"><xsl:value-of select="url"/></xsl:attribute>
           </xsl:otherwise>
         </xsl:choose>
         <xsl:if test="count(@target)>0">
            <xsl:attribute name="target">
              <xsl:value-of select="@target"/>
              </xsl:attribute>
          </xsl:if>
         <xsl:apply-templates select="bold | br | img | span| text() "/>
      </a>
    </xsl:template>
<!--*************************************************-->


<xsl:template name="link_url">
   <xsl:param name="linkid"/>
   <xsl:for-each select="document($navigation_document)//menu">
      <xsl:if test="$linkid=id">
        <xsl:attribute name="href">
        <xsl:call-template name="menu_url"/>
        </xsl:attribute>
      </xsl:if>
   </xsl:for-each>
</xsl:template>

<xsl:template name="menu_url">
		<xsl:choose>
			<xsl:when test="count(idref)>0">
				<xsl:call-template name="menu_ref_url">
					<xsl:with-param name="menu_id">
						<xsl:value-of select="idref"/>
					</xsl:with-param>
				</xsl:call-template>
			</xsl:when>
			<xsl:otherwise>
				<xsl:choose>
					<xsl:when test="url">
						<xsl:value-of select="url"/>
					</xsl:when>
					<xsl:when test="menu[1]/url">
						<xsl:value-of select="menu[1]/url"/>
					</xsl:when>
					<xsl:when test="menu[1]/menu[1]/url">
						<xsl:value-of select="menu[1]/menu[1]/url"/>
					</xsl:when>
					<xsl:when test="menu[1]/menu[1]/menu[1]/url">
						<xsl:value-of select="menu[1]/menu[1]/menu[1]/url"/>
					</xsl:when>
					<xsl:when test="menu[1]/menu[1]/menu[1]/menu[1]/url">
						<xsl:value-of select="menu[1]/menu[1]/menu[1]/menu[1]/url"/>
					</xsl:when>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>




<xsl:template name="menu_ref_url">
		<xsl:param name="menu_id"/>
		<xsl:for-each select="document($navigation_document)//menu">
			<xsl:if test="id=$menu_id">
				<xsl:choose>
					<xsl:when test="idref">
						<xsl:call-template name="menu_ref_url">
							<xsl:with-param name="menu_id">
								<xsl:value-of select="idref"/>
							</xsl:with-param>
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="idref">
						<xsl:call-template name="menu_ref_url">
							<xsl:with-param name="menu_id">
								<xsl:value-of select="idref"/>
							</xsl:with-param>
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="url">
						<xsl:value-of select="url"/>
					</xsl:when>
					<xsl:when test="menu[1]/url">
						<xsl:value-of select="menu[1]/url"/>
					</xsl:when>
					<xsl:when test="menu[1]/menu[1]/url">
						<xsl:value-of select="menu[1]/menu[1]/url"/>
					</xsl:when>
					<xsl:when test="menu[1]/menu[1]/menu[1]/url">
						<xsl:value-of select="menu[1]/menu[1]/menu[1]/url"/>
					</xsl:when>
					<xsl:when test="menu[1]/menu[1]/menu[1]/menu[1]/url">
						<xsl:value-of select="menu[1]/menu[1]/menu[1]/menu[1]/url"/>
					</xsl:when>
				</xsl:choose>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>



</xsl:stylesheet>
