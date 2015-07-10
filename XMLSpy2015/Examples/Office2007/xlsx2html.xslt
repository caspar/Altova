<?xml version="1.0" encoding="UTF-8"?>
<!--
	This sample XSLT file demonstrates how data and styles can be directly extracted	out of Microsoft Excel 2007 XSLX files.
	The result of this sample transformation is a HTML file which resembles Excel sheets with some text styles.
-->
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fn="http://www.w3.org/2005/xpath-functions"
	xmlns:xlsx="http://schemas.openxmlformats.org/spreadsheetml/2006/main"
	xmlns:xlsxpkgrels="http://schemas.openxmlformats.org/package/2006/relationships"
	xmlns:xlsxdocrels="http://schemas.openxmlformats.org/officeDocument/2006/relationships">

	<xsl:output method="html" encoding="UTF-8" indent="yes"/>

	<xsl:variable name="column-names">ABCDEFGHIJKLMNOPQRSTUVWXYZ</xsl:variable>

	<!-- get the URI of the archive -->
	<xsl:variable name="xlsx-uri" select="substring-before(document-uri(.), '%7Czip')" />
	<xsl:variable name="xlsx-uri-zip" select="concat($xlsx-uri, '|zip\')"/>

	<!-- create necessary URI's for documents inside the xlsx (read them from the .rels files) -->
	<xsl:variable name="rels-uri" select="concat($xlsx-uri-zip, '_rels/.rels')" />
	<xsl:variable name="rels-doc" select="document($rels-uri)" />
	<xsl:variable name="workbook-uri" select="concat($xlsx-uri-zip, $rels-doc//xlsxpkgrels:Relationship[@Type = 'http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument']/@Target)" />
	<xsl:variable name="workbook-sub-uri" select="substring($workbook-uri, string-length($xlsx-uri-zip) + 1)"/>
	<xsl:variable name="workbook-sub-uri-seq" select="tokenize($workbook-sub-uri, '/')"/>
	<xsl:variable name="workbook-doc" select="document($workbook-uri)" />
	<xsl:variable name="workbook-dir" select="concat($xlsx-uri-zip, string-join(remove($workbook-sub-uri-seq, count($workbook-sub-uri-seq)), '/'), '/')" />
	<xsl:variable name="workbook-rels-uri" select="concat($workbook-dir, '_rels/', $workbook-sub-uri-seq[last()], '.rels')" />
	<xsl:variable name="workbook-rels-doc" select="document($workbook-rels-uri)" />
	<xsl:variable name="sharedstrings-uri" select="concat($workbook-dir, $workbook-rels-doc//xlsxpkgrels:Relationship[@Type = 'http://schemas.openxmlformats.org/officeDocument/2006/relationships/sharedStrings']/@Target)" />
	<xsl:variable name="sharedstrings-doc" select="document($sharedstrings-uri)" />
	<xsl:variable name="styles-uri" select="concat($workbook-dir, $workbook-rels-doc//xlsxpkgrels:Relationship[@Type = 'http://schemas.openxmlformats.org/officeDocument/2006/relationships/styles']/@Target)" />
	<xsl:variable name="styles-doc" select="document($styles-uri)" />

	<!-- root document -->
	<xsl:template match="/">
		<html>
			<head>
				<title />
			</head>
			<body>
				<!-- extract the file extension from the input document -->
				<xsl:variable name="document-uri-ext" select="lower-case(string(tokenize($xlsx-uri, '\.')[last()]))" />
				<xsl:choose>
					<xsl:when test="$document-uri-ext = 'xlsx'">
						<!-- iterate all the available sheets in the xlsx -->
						<xsl:for-each select="$workbook-rels-doc//xlsxpkgrels:Relationship[@Type = 'http://schemas.openxmlformats.org/officeDocument/2006/relationships/worksheet']">
							<xsl:sort select="@Id" />
							<!-- create URI for the current sheet -->
							<xsl:variable name="sheet-uri" select="concat($workbook-dir, @Target)" />
							<xsl:variable name="sheet-doc" select="document($sheet-uri)" />
							<xsl:variable name="sheet-id" select="@Id" />
							<!-- get the name of the current sheet -->
							<p>
								<span style="font-weight:bold;"><xsl:value-of select="$workbook-doc//xlsx:sheet[@xlsxdocrels:id = $sheet-id]/@name" /></span>
							</p>
							<table width="100%" cellspacing="0" cellpadding="5" border="1">
								<!-- get the number of rows and columns used in this sheet -->
								<xsl:variable name="max-rows" select="number(translate(substring-after($sheet-doc/xlsx:worksheet/xlsx:dimension/@ref, ':'), $column-names, '')) + 1" />
								<xsl:variable name="max-columns">
									<xsl:call-template name="column-count">
										<xsl:with-param name="column-name" select="translate(substring-after($sheet-doc/xlsx:worksheet/xlsx:dimension/@ref, ':'), '0123456789', '')"/>
										<xsl:with-param name="count" select="0"/>
										<xsl:with-param name="default" select="10"/>
									</xsl:call-template>
								</xsl:variable>
								<!-- create header row -->
								<xsl:if test="$max-rows &gt; 1">
									<xsl:call-template name="header-row">
										<xsl:with-param name="column" select="1"/>
										<xsl:with-param name="max-columns" select="$max-columns + 1"/>
									</xsl:call-template>
								</xsl:if>
								<!-- extract the first max-rows rows -->
								<xsl:call-template name="create-rows">
									<xsl:with-param name="row" select="1"/>
									<xsl:with-param name="row-nodes" select="$sheet-doc/xlsx:worksheet/xlsx:sheetData/xlsx:row[number(@r) &lt; $max-rows]"/>
									<xsl:with-param name="max-rows" select="$max-rows"/>
									<xsl:with-param name="max-columns" select="$max-columns + 1"/>
								</xsl:call-template>
							</table>
						</xsl:for-each>
					</xsl:when>
					<xsl:otherwise>
						<p><span style="font-weight:bold;">This transformation can only be applied to Microsoft Excel 2007 XLSX files!</span></p>
					</xsl:otherwise>
				</xsl:choose>
			</body>
		</html>
	</xsl:template>

	<!-- recursive creation of all rows -->
	<xsl:template name="create-rows">
		<xsl:param name="row" />
		<xsl:param name="row-nodes" />
		<xsl:param name="max-rows" />
		<xsl:param name="max-columns" />
		<!-- check if we reached the max -->
		<xsl:if test="$row &lt; $max-rows" >
			<xsl:choose>
				<!-- test if the row can be created or if there exist empty rows before -->
				<xsl:when test="$row = $row-nodes[1]/@r">
					<tr valign="top">
						<!-- row number -->
						<xsl:call-template name="row-number">
							<xsl:with-param name="row" select="$row"/>
						</xsl:call-template>
						<!-- create columns of that row -->
						<xsl:call-template name="create-columns">
							<xsl:with-param name="column" select="1"/>
							<xsl:with-param name="column-nodes" select="$row-nodes[1]/xlsx:c[position() &lt; $max-columns]"/>
							<xsl:with-param name="max-columns" select="$max-columns"/>
						</xsl:call-template>
					</tr>
					<!-- continue with the next row -->
					<xsl:call-template name="create-rows">
						<xsl:with-param name="row" select="$row + 1"/>
						<xsl:with-param name="row-nodes" select="$row-nodes[position() > 1]"/>
						<xsl:with-param name="max-rows" select="$max-rows"/>
						<xsl:with-param name="max-columns" select="$max-columns"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise>
					<!-- we need to insert an empty row, since it is missing in the xml -->
					<tr valign="top">
						<!-- row number -->
						<xsl:call-template name="row-number">
							<xsl:with-param name="row" select="$row"/>
						</xsl:call-template>
						<!-- insert all (empty) columns to this row -->
						<xsl:call-template name="create-columns">
							<xsl:with-param name="column" select="1"/>
							<xsl:with-param name="column-nodes" select="$row-nodes[0]"/>
							<xsl:with-param name="max-columns" select="$max-columns"/>
						</xsl:call-template>
					</tr>
					<!-- continue with the next row -->
					<xsl:call-template name="create-rows">
						<xsl:with-param name="row" select="$row + 1"/>
						<xsl:with-param name="row-nodes" select="$row-nodes"/>
						<xsl:with-param name="max-rows" select="$max-rows"/>
						<xsl:with-param name="max-columns" select="$max-columns"/>
					</xsl:call-template>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
	</xsl:template>

	<!-- recursive creation of all columns in a row -->
	<xsl:template name="create-columns">
		<xsl:param name="column"/>
		<xsl:param name="column-nodes"/>
		<xsl:param name="max-columns"/>
		<!-- test if we have to stop -->
		<xsl:if test="$column &lt; $max-columns">
			<xsl:variable name="current-column">
				<xsl:call-template name="column-count">
					<xsl:with-param name="column-name" select="translate($column-nodes[1]/@r, '0123456789', '')"/>
					<xsl:with-param name="count" select="0"/>
					<xsl:with-param name="default" select="-1"/>
				</xsl:call-template>
			</xsl:variable>
			<xsl:choose>
				<!-- test if the column can be created or if there exist empty columns before -->
				<xsl:when test="$current-column = $column">
					<td>
						<span>
							<!-- get the font styles of this cell (bold, italic, underline) -->
							<xsl:variable name="styleid" select="$column-nodes[1]/@s" />
							<xsl:if test="$styleid != ''">
								<xsl:attribute name="style">
									<xsl:variable name="font" select="$styles-doc//xlsx:cellXfs/xlsx:xf[number($styleid) + 1]" />
									<xsl:apply-templates select="$styles-doc//xlsx:fonts/xlsx:font[number($font/@fontId) + 1]" />
								</xsl:attribute>
							</xsl:if>
							<!-- extract the column content from the xlsx -->
							<xsl:choose>
								<xsl:when test="$column-nodes[1]/@t = 's'">
									<xsl:variable name="pos" select="$column-nodes[1]/xlsx:v" />
									<xsl:value-of select="$sharedstrings-doc/xlsx:sst/xlsx:si[number($pos) + 1]/xlsx:t"/>
								</xsl:when>
								<xsl:otherwise>
									<xsl:value-of select="$column-nodes[1]/xlsx:v"/>
								</xsl:otherwise>
							</xsl:choose>
						</span>
					</td>
					<!-- continue with next column -->
					<xsl:call-template name="create-columns">
						<xsl:with-param name="column" select="$column + 1"/>
						<xsl:with-param name="column-nodes" select="$column-nodes[position() > 1]"/>
						<xsl:with-param name="max-columns" select="$max-columns"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise>
					<!-- create an empty column -->
					<td>
						<xsl:attribute name="width"><xsl:value-of select="concat(100 div $max-columns, '%')"/></xsl:attribute>
						&#160;
					</td>
					<!-- continue with next column -->
					<xsl:call-template name="create-columns">
						<xsl:with-param name="column" select="$column + 1"/>
						<xsl:with-param name="column-nodes" select="$column-nodes"/>
						<xsl:with-param name="max-columns" select="$max-columns"/>
					</xsl:call-template>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
	</xsl:template>

	<!-- creates the header row for a table -->
	<xsl:template name="header-row">
		<xsl:param name="column"/>
		<xsl:param name="max-columns"/>
		<xsl:if test="$column &lt; $max-columns">
			<xsl:if test="$column = 1">
				<th width="4%" style="background-color:#F0F0F0;">&#160;</th>
			</xsl:if>
			<th style="background-color:#F0F0F0;">
				<xsl:attribute name="width"><xsl:value-of select="concat(100 div $max-columns, '%')"/></xsl:attribute>
				<span style="font-weight:bold;">
					<xsl:call-template name="translate-to-column-name">
						<xsl:with-param name="column" select="$column"/>
						<xsl:with-param name="column-name" select="''"/>
					</xsl:call-template>
				</span>
			</th>
			<xsl:call-template name="header-row">
				<xsl:with-param name="column" select="$column + 1"/>
				<xsl:with-param name="max-columns" select="$max-columns"/>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>

	<!-- creates first column of the row (contains the row number) -->
	<xsl:template name="row-number">
		<xsl:param name="row"/>
		<td width="4%" align="center" style="background-color:#F0F0F0;">
			<span style="font-weight:bold;">
				<xsl:value-of select="$row"/>
			</span>
		</td>
	</xsl:template>

	<!-- calculates the count of columns from the column name (eg: A: 1, AA: 27, AZ: 52) -->
	<xsl:template name="column-count">
		<xsl:param name="column-name"/>
		<xsl:param name="count"/>
		<xsl:param name="default"/>
		<xsl:choose>
			<xsl:when test="string-length($column-name) = 0">
				<!-- provide a default column width, when the sheet does not have any data -->
				<xsl:value-of select="$default" />
			</xsl:when>
			<xsl:when test="string-length($column-name) &gt; 1">
				<xsl:call-template name="column-count">
					<xsl:with-param name="column-name" select="substring($column-name, 2)"/>
					<xsl:with-param name="count" select="$count + ((number(string-to-codepoints($column-name)[1]) - 64) * 26 * (string-length($column-name) - 1))" />
					<xsl:with-param name="default" select="$default"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$count + (string-to-codepoints($column-name)[1] - 64)" />
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<!-- calculates from a number the column name (eg: 1: A, 2: B, 27: AA) -->
	<xsl:template name="translate-to-column-name">
		<xsl:param name="column"/>
		<xsl:param name="column-name"/>
		<xsl:choose>
			<xsl:when test="number($column) &lt; 27">
				<xsl:value-of select="concat($column-name, substring($column-names, $column, 1))"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:choose>
					<xsl:when test="((floor($column div 26)) &lt; 27) or ((floor($column div 26)) = 27 and ($column mod 26) = 0)">
						<xsl:choose>
							<xsl:when test="($column mod 26) != 0">
								<xsl:value-of select="concat($column-name, substring($column-names, floor($column div 26), 1), substring($column-names, $column mod 26, 1))"/>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="concat($column-name, substring($column-names, floor($column div 26) - 1, 1), substring($column-names, 26, 1))"/>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:when>
					<xsl:otherwise>
						<xsl:variable name="part">
							<xsl:call-template name="translate-to-column-name">
								<xsl:with-param name="column" select="floor($column div 26)"/>
								<xsl:with-param name="column-name" select="$column-name"/>
							</xsl:call-template>
						</xsl:variable>
						<xsl:choose>
							<xsl:when test="($column mod 26) != 0">
								<xsl:value-of select="concat($part, substring($column-names, $column mod 26, 1))"/>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="concat($part, substring($column-names, 26, 1))"/>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<!-- cell font styles -->
	<xsl:template match="xlsx:u">text-decoration:underline;</xsl:template>
	<xsl:template match="xlsx:b">font-weight:bold;</xsl:template>
	<xsl:template match="xlsx:i">font-style:italic;</xsl:template>

</xsl:stylesheet>
