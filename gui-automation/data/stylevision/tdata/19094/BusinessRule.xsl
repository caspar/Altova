<?xml version="1.0" encoding="UTF-8"?>
<!-- edited with XMLSpy v2006 sp2 U (http://www.altova.com) by Carl Seghers (Association de frais Groupe AXA Belgium) -->
<?xml-stylesheet type="text/xsl" href="..\BusinessRule.xsl"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:xdt="http://www.w3.org/2005/xpath-datatypes">
	<xsl:variable name="bcmList" select="document('XML/BCM.xml')/bcmTable"/>
	<xsl:template match="/">
		<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="businessLogic">
		<html>
			<head>
				<xsl:if test="local-name(child::node()[1]) = 'businessRule'">
					<title>BR<xsl:value-of select="businessRule/@RuleID"/>
					</title>
				</xsl:if>
				<xsl:if test="local-name(child::node()[1]) = 'businessFunction'">
					<title>BF<xsl:value-of select="businessFunction/@FunctionID"/>
					</title>
				</xsl:if>
				<link href="..\BusinessRule.css" rel="stylesheet" type="text/css"/>
			</head>
			<body>
				<xsl:apply-templates select="businessRule | businessFunction"/>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="businessRule">
		<table class="fiche" border="1">
			<tr>
				<th class="fiche">Rule Id</th>
				<td>
					<xsl:value-of select="@RuleID"/>
				</td>
			</tr>
			<tr>
				<th class="fiche">Type</th>
				<td>
					Business Rule
				</td>
			</tr>
			<tr>
				<th class="fiche">Status</th>
				<td>
					<xsl:value-of select="@Status"/>
				</td>
			</tr>
			<tr>
				<th class="fiche">OwnerBSP</th>
				<td>
					<xsl:value-of select="@ownerBsp"/>
				</td>
			</tr>
			<tr>
				<th class="fiche">OwnerIT</th>
				<td>
					<xsl:value-of select="@ownerIT"/>
				</td>
			</tr>
			<tr>
				<th class="fiche">Category</th>
				<td>
					<xsl:value-of select="@Category"/>
				</td>
			</tr>
			<tr>
				<th class="fiche">Long Description</th>
				<td class="fiche">
					<table width="100%" border="1">
						<xsl:for-each select="textualDescription/longDescription">
							<tr>
								<td class="desc_context">
									<table class="ruleSets">
										<tr>
											<td width="20%">
												<xsl:value-of select="@language"/>
											</td>
										</tr>
										<tr>
											<xsl:if test="@usage">
												<td>
													<xsl:value-of select="@usage"/>
												</td>
											</xsl:if>
										</tr>
										<tr>
											<xsl:if test="@userProfile">
												<td>
													<xsl:value-of select="@userProfile"/>
												</td>
											</xsl:if>
										</tr>
									</table>
								</td>
								<td>
									<xsl:apply-templates select="."/>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</td>
			</tr>
			<tr>
				<th class="fiche">Short description</th>
				<td class="fiche">
					<table width="100%" border="1">
						<xsl:for-each select="textualDescription/shortDescription">
							<tr>
								<td class="desc_context">
									<table class="ruleSets" border="1">
										<tr>
											<td width="20%">
												<xsl:value-of select="@language"/>
											</td>
										</tr>
									</table>
								</td>
								<td>
									<xsl:apply-templates select="."/>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</td>
			</tr>
			<tr>
				<th class="fiche">Context &amp; Change Types</th>
				<td class="fiche">
					<table class="contexts_changetypes" border="1">
						<tr>
							<th class="contexts">Contexts</th>
							<th class="contexts">Change Types</th>
						</tr>
						<tr>
							<td class="contexts">
								<xsl:apply-templates select="contexts"/>
							</td>
							<td class="changeType">
								<xsl:apply-templates select="changeTypes"/>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<th class="fiche">Rule Sets</th>
				<td class="fiche">
					<table class="ruleSets" border="1">
						<xsl:for-each select="ruleSets/ruleSet">
							<tr>
								<td class="ruleSets">
									<xsl:apply-templates select="ruleSetName"/>
								</td>
								<xsl:if test="instances">
									<td class="instances">
										<table>
											<xsl:for-each select="instances/instance">
												<tr>
													<td>
														<xsl:choose>
															<xsl:when test="../../ruleSetName/text()='Coverage'">
																<xsl:choose>
																	<xsl:when test="text() = '001'">
																		<xsl:text>Responsabilité civile</xsl:text>
																	</xsl:when>
																	<xsl:when test="text() = '010'">
																		<xsl:text>Protection juridique circulation</xsl:text>
																	</xsl:when>
																	<xsl:when test="text() = '011'">
																		<xsl:text>Nature / Animaux</xsl:text>
																	</xsl:when>
																	<xsl:when test="text() = '012'">
																		<xsl:text>Incendie</xsl:text>
																	</xsl:when>
																	<xsl:when test="text() = '013'">
																		<xsl:text>Bris vitre</xsl:text>
																	</xsl:when>
																	<xsl:when test="text() = '014'">
																		<xsl:text>Vol</xsl:text>
																	</xsl:when>
																	<xsl:when test="text() = '015'">
																		<xsl:text>Accident / Vandalisme</xsl:text>
																	</xsl:when>
																	<xsl:when test="text() = '022'">
																		<xsl:text>OMNI Assistance personnes</xsl:text>
																	</xsl:when>
																	<xsl:when test="text() = '023'">
																		<xsl:text>OMNI Assistance véhicules</xsl:text>
																	</xsl:when>
																	<xsl:when test="text() = '026'">
																		<xsl:text>Protection des personnes indemnitées</xsl:text>
																	</xsl:when>
																	<xsl:when test="text() = '027'">
																		<xsl:text>Protection des personnes forfait</xsl:text>
																	</xsl:when>
																</xsl:choose>
															</xsl:when>
															<xsl:when test="../../ruleSetName/text()='Risk'">
																<xsl:choose>
																	<xsl:when test="text() = '1'">
																		<xsl:text>Risk 1</xsl:text>
																	</xsl:when>
																	<xsl:when test="text() = '2'">
																		<xsl:text>Risk 2</xsl:text>
																	</xsl:when>
																	<xsl:when test="text() = '3'">
																		<xsl:text>Risk 3</xsl:text>
																	</xsl:when>
																</xsl:choose>
															</xsl:when>
															<xsl:when test="../../ruleSetName/text()='Party'">
																<xsl:choose>
																	<xsl:when test="text() = '1'">
																		<xsl:text>Policy Holder</xsl:text>
																	</xsl:when>
																	<xsl:when test="text() = '2'">
																		<xsl:text>Main Driver</xsl:text>
																	</xsl:when>
																	<xsl:when test="text() = '3'">
																		<xsl:text>Secondary Driver 1</xsl:text>
																	</xsl:when>
																	<xsl:when test="text() = '4'">
																		<xsl:text>Secondary Driver 2</xsl:text>
																	</xsl:when>
																</xsl:choose>
															</xsl:when>
														</xsl:choose>
													</td>
												</tr>
											</xsl:for-each>
										</table>
									</td>
								</xsl:if>
							</tr>
						</xsl:for-each>
					</table>
				</td>
			</tr>
			<tr>
				<th class="fiche">Targets</th>
				<td class="fiche">
					<table class="target" border="1">
						<xsl:for-each select="targets/bcm">
							<tr>
								<td>
									<xsl:apply-templates select="."/>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</td>
			</tr>
			<tr>
				<th class="fiche">Rule Logic</th>
				<td class="fiche">
					<xsl:apply-templates select="ruleLogic"/>
				</td>
			</tr>
			<tr>
				<th class="fiche">Included</th>
				<td class="fiche">
					<table class="ruleSets" border="1">
						<xsl:for-each select="includes/include">
							<tr>
								<td>
									<xsl:value-of select="text()"/>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</td>
			</tr>
			<tr>
				<th class="fiche">Comment</th>
				<td class="fiche">
					<table width="100%" class="comment" border="1">
						<xsl:for-each select="comments/comment">
							<!--<xsl:apply-templates select="comment"/> -->
							<tr>
								<td>
									<xsl:value-of select="."/>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</td>
			</tr>
		</table>
	</xsl:template>
	<xsl:template match="businessFunction">
		<table class="fiche" border="1">
			<tr>
				<th>Function Id</th>
				<td>
					<xsl:value-of select="@FunctionID"/>
				</td>
			</tr>
			<tr>
				<th>Status</th>
				<td>
					<xsl:value-of select="@Status"/>
				</td>
			</tr>
			<tr>
				<th>Name</th>
				<td>
					<xsl:value-of select="@name"/>
				</td>
			</tr>
			<tr>
				<th>Long Description</th>
				<td>
					<table border="1">
						<xsl:for-each select="textualDescription/longDescription">
							<tr>
								<th>
									<table class="ruleSets" border="1">
										<tr>
											<td>
												<xsl:value-of select="@language"/>
											</td>
											<td>
												<xsl:value-of select="@usage"/>
											</td>
										</tr>
										<tr>
											<td/>
											<td>
												<xsl:value-of select="@userProfile"/>
											</td>
										</tr>
									</table>
								</th>
								<td>
									<xsl:apply-templates select="."/>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</td>
			</tr>
			<tr>
				<th>Short description</th>
				<td class="fiche">
					<table width="100%" border="1">
						<xsl:for-each select="textualDescription/shortDescription">
							<tr>
								<td>
									<table class="ruleSets" border="1">
										<tr>
											<td width="20%">
												<xsl:value-of select="@language"/>
											</td>
										</tr>
									</table>
								</td>
								<td>
									<xsl:apply-templates select="."/>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</td>
			</tr>
			<tr>
				<th>Parameters</th>
				<td>
					<table width="100%" border="1">
						<xsl:for-each select="params/param">
							<tr>
								<td>
									<xsl:apply-templates select="."/>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</td>
			</tr>
			<tr>
				<th>Result Type</th>
				<td>
					<xsl:apply-templates select="resultType"/>
				</td>
			</tr>
			<tr>
				<th>Body</th>
				<td>
					<pre>
						<xsl:apply-templates select="body"/>
					</pre>
				</td>
			</tr>
			<tr>
				<th>Included</th>
				<td class="fiche">
					<table class="classification" border="1">
						<xsl:for-each select="includes/include">
							<tr>
								<td>
									<xsl:value-of select="text()"/>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</td>
			</tr>
			<tr>
				<th>Comment</th>
				<td>
					<table class="comment" border="1">
						<xsl:for-each select="comment">
							<!--<xsl:apply-templates select="comment"/> -->
							<tr>
								<td>
									<xsl:value-of select="."/>
								</td>
							</tr>
						</xsl:for-each>
					</table>
				</td>
			</tr>
		</table>
	</xsl:template>
	<xsl:template match="ruleLogic">
		<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="contexts">
		<table class="contexts" border="1">
			<xsl:for-each select="context">
				<tr>
					<th>
						<xsl:value-of select="position()"/>
						<xsl:if test="@version">
							<br>version <i>
									<b>
										<xsl:value-of select="@version"/>
									</b>
								</i>
							</br>
						</xsl:if>
					</th>
					<td>
						<table class="context" border="1">
							<xsl:for-each select="*">
								<tr>
									<td width="70%">
										<xsl:value-of select="local-name()"/>
									</td>
									<td>
										<xsl:value-of select="text()"/>
									</td>
								</tr>
							</xsl:for-each>
						</table>
					</td>
				</tr>
			</xsl:for-each>
		</table>
	</xsl:template>
	<xsl:template match="changeTypes">
		<table class="changeType" border="1">
			<xsl:for-each select="changeType">
				<tr>
					<td>
						<xsl:value-of select="text()"/>
					</td>
				</tr>
			</xsl:for-each>
		</table>
	</xsl:template>
	<xsl:template match="if">
		<table class="rulelogic" border="1">
			<tr>
				<td class="header">IF</td>
				<td class="if">
					<xsl:apply-templates select="condition/*"/>
				</td>
			</tr>
			<tr>
				<td class="header" bgcolor="green">Y</td>
				<td class="then">
					<xsl:apply-templates select="then/*"/>
				</td>
			</tr>
		</table>
	</xsl:template>
	<xsl:template match="ifNot">
		<table class="rulelogic" border="1">
			<tr>
				<td class="header">IFNOT</td>
				<td class="if">
					<xsl:apply-templates select="condition/*"/>
				</td>
			</tr>
			<tr>
				<td class="header" bgcolor="green">Y</td>
				<td class="then">
					<xsl:apply-templates select="then/*"/>
				</td>
			</tr>
		</table>
	</xsl:template>
	<xsl:template match="not">
		NOT <xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="p">
		<p>
			<xsl:apply-templates/>
		</p>
	</xsl:template>
	<xsl:template match="placeHolder">
		<xsl:text>{</xsl:text>
		<xsl:value-of select="@type"/>
		<xsl:text> </xsl:text>
		<xsl:value-of select="text()"/>
		<xsl:if test="@name">
			<xsl:text> </xsl:text>
			<xsl:value-of select="@name"/>
		</xsl:if>
		<xsl:text>}</xsl:text>
	</xsl:template>
	<xsl:template match="placeHolderList">
		<xsl:text>{list </xsl:text>
		<xsl:value-of select="listRestricted/list/@name"/>
		<xsl:text>}</xsl:text>
	</xsl:template>
	<xsl:template match="placeHolderValue">
		<xsl:text>{value </xsl:text>
		<xsl:apply-templates/>
		<xsl:text>}</xsl:text>
	</xsl:template>
	<xsl:template match="list">
		<xsl:if test="@name">
			<xsl:value-of select="@name"/>
		</xsl:if>
		<xsl:if test="count(*/*) > 1">
			<xsl:if test="@name">
				<xsl:text> = </xsl:text>
			</xsl:if>
			<xsl:text>(</xsl:text>
			<xsl:for-each select="*/*">
				<xsl:if test="position() > 1">, </xsl:if>
				<xsl:apply-templates select="."/>
			</xsl:for-each>
			<xsl:text>)</xsl:text>
		</xsl:if>
	</xsl:template>
	<xsl:template match="equal">
		<xsl:apply-templates select="*[1]"/> =  <xsl:apply-templates select="*[last()]"/>
	</xsl:template>
	<xsl:template match="notEqual">
		<xsl:apply-templates select="*[1]"/> &lt;&gt; <xsl:apply-templates select="*[last()]"/>
	</xsl:template>
	<xsl:template match="less">
		<xsl:apply-templates select="*[1]"/> &lt;  <xsl:apply-templates select="*[last()]"/>
	</xsl:template>
	<xsl:template match="notLess">
		<xsl:apply-templates select="*[1]"/> &gt;=  <xsl:apply-templates select="*[last()]"/>
	</xsl:template>
	<xsl:template match="greater">
		<xsl:apply-templates select="*[1]"/> &gt;  <xsl:apply-templates select="*[last()]"/>
	</xsl:template>
	<xsl:template match="notGreater">
		<xsl:apply-templates select="*[1]"/> &lt;=  <xsl:apply-templates select="*[last()]"/>
	</xsl:template>
	<xsl:template match="in">
		<xsl:for-each select="child::*">
			<xsl:if test="position() = 2">
				<xsl:text> IN </xsl:text>
			</xsl:if>
			<xsl:if test="position() > 2">
				<xsl:text>, </xsl:text>
			</xsl:if>
			<xsl:apply-templates select="*"/>
		</xsl:for-each>
	</xsl:template>
	<xsl:template match="minus">
		<xsl:text>(</xsl:text>
		<xsl:for-each select="child::*">
			<xsl:if test="position() > 1"> - </xsl:if>
			<xsl:apply-templates select="."/>
		</xsl:for-each>
		<xsl:text>)</xsl:text>
	</xsl:template>
	<xsl:template match="add">
		<xsl:text>(</xsl:text>
		<xsl:for-each select="child::*">
			<xsl:if test="position() > 1"> + </xsl:if>
			<xsl:apply-templates select="."/>
		</xsl:for-each>
		<xsl:text>)</xsl:text>
	</xsl:template>
	<xsl:template match="multiply">
		<xsl:text>(</xsl:text>
		<xsl:for-each select="child::*">
			<xsl:if test="position() > 1"> * </xsl:if>
			<xsl:apply-templates select="."/>
		</xsl:for-each>
		<xsl:text>)</xsl:text>
	</xsl:template>
	<xsl:template match="divide">
		<xsl:text>(</xsl:text>
		<xsl:for-each select="child::*">
			<xsl:if test="position() > 1"> / </xsl:if>
			<xsl:apply-templates select="."/>
		</xsl:for-each>
		<xsl:text>)</xsl:text>
	</xsl:template>
	<xsl:template match="min">
		<xsl:text>MIN(</xsl:text>
		<xsl:for-each select="child::*">
			<xsl:if test="position() > 1">,</xsl:if>
			<xsl:apply-templates select="."/>
		</xsl:for-each>
		<xsl:text>)</xsl:text>
	</xsl:template>
	<xsl:template match="max">
		<xsl:text>MAX(</xsl:text>
		<xsl:for-each select="child::*">
			<xsl:if test="position() > 1">,</xsl:if>
			<xsl:apply-templates select="."/>
		</xsl:for-each>
		<xsl:text>)</xsl:text>
	</xsl:template>
	<xsl:template match="fmod">
		<xsl:for-each select="child::*">
			<xsl:if test="position() > 1"> MOD </xsl:if>
			<xsl:apply-templates select="."/>
		</xsl:for-each>
	</xsl:template>
	<xsl:template match="and">
		<table class="and">
			<xsl:for-each select="child::*">
				<xsl:if test="position() > 1">
					<tr>
						<td class="and">
							<b>AND</b>
						</td>
					</tr>
				</xsl:if>
				<tr>
					<td class="indent">
						<xsl:apply-templates select="."/>
					</td>
				</tr>
			</xsl:for-each>
		</table>
	</xsl:template>
	<xsl:template match="or">
		<table class="and">
			<xsl:for-each select="child::*">
				<xsl:if test="position() > 1">
					<tr>
						<td>
							<b>OR</b>
						</td>
					</tr>
				</xsl:if>
				<tr>
					<td class="indent">
						<xsl:apply-templates select="."/>
					</td>
				</tr>
			</xsl:for-each>
		</table>
	</xsl:template>
	<xsl:template match="function">
		<xsl:if test="@class">
			<xsl:value-of select="@class"/>.</xsl:if>
		<xsl:value-of select="@name"/>
		<xsl:text>(</xsl:text>
		<xsl:for-each select="child::*">
			<xsl:if test="position() > 1">, </xsl:if>
			<xsl:apply-templates select="."/>
		</xsl:for-each>
		<xsl:text>)</xsl:text>
	</xsl:template>
	<xsl:template match="action">
		<table class="action" border="1">
			<!-- première ligne : action -->
			<tr>
				<th width="10%">
					<xsl:value-of select="position()"/>.</th>
				<td width="80%">
					<xsl:choose>
						<xsl:when test="@type='refusal'">
							<xsl:text>Refuse with error</xsl:text>
						</xsl:when>
						<xsl:when test="@type='backOffice'">
							<xsl:text>Refer to back office with error</xsl:text>
						</xsl:when>
						<xsl:when test="@type='error'">
							<xsl:text>Return with error</xsl:text>
						</xsl:when>
						<xsl:when test="@type='warning'">
							<xsl:text>Return with warning</xsl:text>
						</xsl:when>
					</xsl:choose>
				</td>
				<td width="10%">
					<xsl:element name="a">
						<xsl:attribute name="href">C:\DATA\SOF\HTML\errorCodesTable.html#<xsl:value-of select="errorCode"/></xsl:attribute>
					</xsl:element>
					<xsl:value-of select="errorCode"/>
				</td>
			</tr>
			<!--  lignes : children = target, contexts  -->
			<xsl:for-each select="*">
				<xsl:if test="local-name()='target'">
					<tr>
						<th>target</th>
						<td>
							<xsl:value-of select="text()"/>
						</td>
						<td/>
					</tr>
				</xsl:if>
				<xsl:if test="local-name()='contexts'">
					<tr>
						<th>context</th>
						<td>
							<table class="contexts" border="1">
								<xsl:for-each select="*">
									<xsl:if test="local-name()='context'">
										<tr>
											<th>
												<xsl:value-of select="position()"/>
											</th>
											<td>
												<table class="context" border="1">
													<xsl:for-each select="*">
														<tr>
															<td width="70%">
																<xsl:value-of select="local-name()"/>
															</td>
															<td width="30%">
																<xsl:value-of select="text()"/>
															</td>
														</tr>
													</xsl:for-each>
												</table>
											</td>
										</tr>
									</xsl:if>
									<xsl:if test="local-name()='changeType'">
										<tr>
											<td> ===<xsl:value-of select="local-name()"/>
											</td>
											<td>
												<xsl:value-of select="text()"/>
											</td>
										</tr>
									</xsl:if>
								</xsl:for-each>
							</table>
						</td>
						<td/>
					</tr>
				</xsl:if>
			</xsl:for-each>
		</table>
	</xsl:template>
	<xsl:template match="bcm">
		<xsl:variable name="bcmid" select="number(node())"/>
		<xsl:variable name="entity" select="$bcmList/bcmDefinition[bcmId=$bcmid]/bcmEntity"/>
		<xsl:variable name="attribute" select="$bcmList/bcmDefinition[bcmId=$bcmid]/bcmAttribute"/>
		<xsl:value-of select="$entity"/>.<xsl:value-of select="$attribute"/>
		<xsl:if test="@index">
			<sub>
				<i>
					<b>
						<xsl:value-of select="@index"/>
					</b>
				</i>
			</sub>
		</xsl:if>
		<xsl:if test="@version">
			<sup>
				<i>
					<b>
						<xsl:value-of select="@version"/>
					</b>
				</i>
			</sup>
		</xsl:if>
	</xsl:template>
	<xsl:template match="code">
		<xsl:value-of select="text()"/>
		<!--
		<sup>
			<i>
				<xsl:value-of select="@source"/>
			</i>
		</sup>
		-->
		<xsl:if test="@name"> (<xsl:value-of select="@name"/>)</xsl:if>
	</xsl:template>
	<xsl:template match="parameter">
		<xsl:value-of select="text()"/>
		<sub>
			<i>
				<b>parameter</b>
			</i>
		</sub>
	</xsl:template>
	<xsl:template match="foreach">
		<table class="and">
			<tr>
				<td>
					<xsl:text>for each </xsl:text>
					<xsl:value-of select="@var"/>
					<xsl:text> until </xsl:text>
					<xsl:if test="@until">
						<xsl:value-of select="@until"/>
					</xsl:if>
				</td>
			</tr>
			<tr>
				<td class="indent">
					<xsl:apply-templates/>
				</td>
			</tr>
		</table>
	</xsl:template>
	<xsl:template match="expression">
		<xsl:apply-templates/>
	</xsl:template>
</xsl:stylesheet>
