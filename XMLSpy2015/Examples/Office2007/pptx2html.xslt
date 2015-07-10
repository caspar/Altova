<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:fn="http://www.w3.org/2005/xpath-functions"
	xmlns:pr="http://schemas.openxmlformats.org/package/2006/relationships"
	xmlns:dr="http://schemas.openxmlformats.org/officeDocument/2006/relationships"
	xmlns:p="http://schemas.openxmlformats.org/presentationml/2006/main"
	xmlns:a="http://schemas.openxmlformats.org/drawingml/2006/main">

	<xsl:output method="html" encoding="UTF-8" indent="yes" name="Overview.html"/>

	<!-- the path of the input document eg: doc.pptx -->
	<xsl:variable name="pptx-uri" select="substring-before(document-uri(.), '%7Czip')"/>
	
	<!-- the path of the input document with an appended |zip\ eg: doc.pptx|zip\ -->
	<xsl:variable name="pptx-uri-zip" select="concat($pptx-uri, '|zip\')"/>

	<!-- the path to the .rels file in the input document eg: doc.pptx|zip\_rels\.rels -->
	<xsl:variable name="rels-uri" select="concat($pptx-uri-zip, '_rels/.rels')"/>

	<!-- the document of the .rels file -->
	<xsl:variable name="rels-doc" select="document($rels-uri)"/>

	<!-- the path to the presentation.xml eg: doc.pptx|zip\ppt/presentation.xml -->
	<xsl:variable name="presentation-uri" select="concat($pptx-uri-zip, $rels-doc//pr:Relationship[@Type = 'http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument']/@Target)" />

	<!-- the path inside the powerpoint presentation to the presentation.xml -->
	<xsl:variable name="presentation-sub-uri" select="substring($presentation-uri, string-length($pptx-uri-zip) + 1)"/>
	<xsl:variable name="presentation-sub-uri-seq" select="tokenize($presentation-sub-uri, '/')"/>

	<!-- the presentation document -->
	<xsl:variable name="presentation-doc" select="document($presentation-uri)" />

	<!-- the directory where the presentation.xml is stored eg: doc.pptx|zip\ppt/ -->
	<xsl:variable name="presentation-dir" select="concat($pptx-uri-zip, string-join(remove($presentation-sub-uri-seq, count($presentation-sub-uri-seq)), '/'), '/')" />

	<!-- the path to the presentation.xml.rels file eg: doc.pptx|zip\ppt/_rels/presentation.xml.rels -->
	<xsl:variable name="presentation-rels-uri" select="concat($presentation-dir, '_rels/', subsequence($presentation-sub-uri-seq, count($presentation-sub-uri-seq)), '.rels')" />

	<!-- the presentation.xml.rels document -->
	<xsl:variable name="presentation-rels-doc" select="document($presentation-rels-uri)" />

	<!-- get the theme xml eg: doc.pptx|zip\theme/theme1.xml -->
	<xsl:variable name="theme-uri" select="concat($presentation-dir, $presentation-rels-doc//pr:Relationship[@Type = 'http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme']/@Target[position() = 1])"/>

	<!-- the theme document -->
	<xsl:variable name="theme-doc" select="document($theme-uri)"/>

	<!-- root document -->
	<xsl:template match="/">
		<html>
			<head>
				<title />
			</head>
			<body>
				<!-- extract the file extension from the input document -->
				<xsl:variable name="document-uri-ext" select="lower-case(string(tokenize($pptx-uri, '\.')[last()]))"/>
				<xsl:choose>
					<!-- test if we can use the input document for this transformation -->
					<xsl:when test="$document-uri-ext = 'pptx' or $document-uri-ext = 'pptm'">
						<p><span style="font-weight:bold;">PowerPoint Presentation Slide Overview</span></p>
						
						<!-- get the id's of the slides in the correct order -->
						<xsl:variable name="slide-ids" select="$presentation-doc/p:presentation/p:sldIdLst/p:sldId"/>
						
						<!-- apply our Relationship template to each Relationship element in the correct order -->
						<xsl:for-each select="$slide-ids">
							<xsl:variable name="slide-id" select="@dr:id"/>
							<xsl:variable name="relationship-element" select="$presentation-rels-doc//pr:Relationship[@Id = $slide-id]"/>
							<xsl:apply-templates select="$relationship-element">
								<xsl:with-param name="slide-ids" select="$slide-ids"/>
								<xsl:with-param name="current-slide-id" select="$slide-id"/>
							</xsl:apply-templates>
						</xsl:for-each>
					</xsl:when>
					<xsl:otherwise>
						<p><span style="font-weight:bold;">This transformation can only be applied to Microsoft PowerPoint 2007 PPTX files!</span></p>
					</xsl:otherwise>
				</xsl:choose>
			</body>
		</html>
	</xsl:template>

	<!-- handles each slide -->
	<xsl:template match="pr:Relationship">
		<xsl:param name="slide-ids"/>
		<xsl:param name="current-slide-id"/>
		
		<xsl:variable name="slide-uri" select="concat($presentation-dir, @Target)"/>
		<xsl:variable name="slide-uri-sub-seq" select="tokenize(@Target, '/')"/>
		<xsl:variable name="slide-doc" select="document($slide-uri)"/>
		
		<xsl:variable name="slide-dir" select="concat($presentation-dir, string-join(remove($slide-uri-sub-seq, count($slide-uri-sub-seq)), '/'), '/')" />
		<xsl:variable name="slide-rels-dir" select="concat($slide-dir, '_rels/')"/>
		<xsl:variable name="slide-rels-uri" select="concat($slide-rels-dir, subsequence($slide-uri-sub-seq, count($slide-uri-sub-seq)), '.rels')"/>
		<xsl:variable name="slide-rels-doc" select="document($slide-rels-uri)"/>
		
		<!-- resolve the slide layout xml uri -->
		<xsl:variable name="slide-layout-uri">
			<xsl:call-template name="resolve-directory">
				<xsl:with-param name="dir" select="$slide-dir"/>
				<xsl:with-param name="relative-dir" select="$slide-rels-doc//pr:Relationship[@Type = 'http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideLayout']/@Target"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:variable name="slide-layout-doc" select="document($slide-layout-uri)"/>
		
		<xsl:variable name="slide-layout-file">
			<xsl:call-template name="extract-file">
				<xsl:with-param name="file-name" select="$slide-layout-uri"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:variable name="slide-layout-dir">
			<xsl:call-template name="extract-directory">
				<xsl:with-param name="file-name" select="$slide-layout-uri"/>
			</xsl:call-template>
		</xsl:variable>
		
		<!-- get the master slide from the relationship information of the current slide layout -->
		<xsl:variable name="slide-layout-rels-dir" select="concat($slide-layout-dir, '_rels/')"/>
		<xsl:variable name="slide-layout-rels-uri" select="concat($slide-layout-rels-dir, $slide-layout-file, '.rels')"/>
		<xsl:variable name="slide-layout-rels-doc" select="document($slide-layout-rels-uri)"/>
		
		<xsl:variable name="master-slide-uri">
			<xsl:call-template name="resolve-directory">
				<xsl:with-param name="dir" select="$slide-dir"/>
				<xsl:with-param name="relative-dir" select="$slide-layout-rels-doc//pr:Relationship[@Type = 'http://schemas.openxmlformats.org/officeDocument/2006/relationships/slideMaster']/@Target"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:variable name="master-slide-doc" select="document($master-slide-uri)"/>
		
		<xsl:variable name="slide-name" select="substring-before(substring-after(@Target, '/'), '.')"/>
		<xsl:variable name="slide-output-uri" select="concat(substring($pptx-uri, 1, string-length($pptx-uri) - 5), '_', $slide-name, '.html')"/>
		
		<!-- add a link in the main document to the new generated slide -->
		<p><a><xsl:attribute name="href" select="$slide-output-uri"/><xsl:value-of select="$slide-name"/></a></p>
		
		<!-- generate the slide html file -->
		<xsl:result-document href="{$slide-output-uri}" method="html" encoding="UTF-8" indent="yes">
			<html>
				<head>
					<title />
				</head>
				<body>
					<xsl:variable name="sp-elements" select="$slide-doc/p:sld/p:cSld/p:spTree/p:sp"/>
					
					<xsl:apply-templates select="$sp-elements">
						<xsl:with-param name="slide-layout-doc" select="$slide-layout-doc"/>
						<xsl:with-param name="master-slide-doc" select="$master-slide-doc"/>
					</xsl:apply-templates>
					<!-- generate links to previous and next document -->
					<p>
						<xsl:if test="$current-slide-id != $slide-ids[1]/@dr:id">
							<!-- get the correct previous slide -->
							<xsl:variable name="previous-slide-id-index" select="index-of($slide-ids/@dr:id, $current-slide-id) - 1"/>
							<xsl:variable name="previous-slide-id" select="$slide-ids[$previous-slide-id-index]/@dr:id"/>
							<xsl:variable name="previous-target" select="$presentation-rels-doc//pr:Relationship[@Id = $previous-slide-id]/@Target"/>
							<xsl:variable name="previous-file-name" select="tokenize($pptx-uri, '/')[last()]"/>
							<a><xsl:attribute name="href" select="concat(substring($previous-file-name, 1, string-length($previous-file-name) - 5), '_', substring-before(substring-after($previous-target, '/'), '.'), '.html')"/>Previous</a>
							<xsl:text>   </xsl:text>
						</xsl:if>
						<xsl:if test="$current-slide-id != $slide-ids[last()]/@dr:id">
							<!-- get the correct next slide -->
							<xsl:variable name="next-slide-id-index" select="index-of($slide-ids/@dr:id, $current-slide-id) + 1"/>
							<xsl:variable name="next-slide-id" select="$slide-ids[$next-slide-id-index]/@dr:id"/>
							<xsl:variable name="next-target" select="$presentation-rels-doc//pr:Relationship[@Id = $next-slide-id]/@Target"/>
							<xsl:variable name="next-file-name" select="tokenize($pptx-uri, '/')[last()]"/>
							<a><xsl:attribute name="href" select="concat(substring($next-file-name, 1, string-length($next-file-name) - 5), '_', substring-before(substring-after($next-target, '/'), '.'), '.html')"/>Next</a>
						</xsl:if>
					</p>
				</body>
			</html>
		</xsl:result-document>
	</xsl:template>

	<!-- extracts text from each shape node -->
	<xsl:template match="p:sp">
		<xsl:param name="slide-layout-doc"/>
		<xsl:param name="master-slide-doc"/>
		
		<!-- get the shape type we are looking for -->
		<xsl:variable name="type" select="./p:nvSpPr/p:nvPr/p:ph/@type"/>
		
		<xsl:variable name="layout-ph-element" select="$slide-layout-doc//p:ph[@type = $type]"/>
		<xsl:variable name="master-ph-element" select="$master-slide-doc//p:ph[@type = $type]"/>
		
		<xsl:variable name="xfrm">
			<xsl:call-template name="get-xfrm">
				<xsl:with-param name="type" select="$type"/>
				<xsl:with-param name="layout-ph-element" select="$layout-ph-element"/>
				<xsl:with-param name="master-ph-element" select="$master-ph-element"/>
			</xsl:call-template>
		</xsl:variable>
		
		<xsl:variable name="font-size">
			<xsl:call-template name="get-font-size">
				<xsl:with-param name="type" select="$type"/>
				<xsl:with-param name="layout-ph-element" select="$layout-ph-element"/>
				<xsl:with-param name="master-ph-element" select="$master-ph-element"/>
			</xsl:call-template>
		</xsl:variable>
		
		<xsl:variable name="font">
			<xsl:call-template name="get-font">
				<xsl:with-param name="type" select="$type"/>
			</xsl:call-template>
		</xsl:variable>
		
		<!-- extract the position info (in EMU) and convert it to pixels -->
		<!-- leave enough space for the Previous/Next links -->
		<xsl:variable name="top" select="number($xfrm//a:off/@y) div 12700 + 30"/>
		<xsl:variable name="left" select="number($xfrm//a:off/@x) div 12700"/>
		<xsl:variable name="width" select="number($xfrm//a:ext/@cx) div 12700"/>
		<xsl:variable name="height" select="number($xfrm//a:ext/@cy) div 12700"/>
		
		<xsl:comment select="$type"/>
		<!-- output the text on the specified position with the specified font -->
		<div>
			<xsl:attribute name="style" select="concat('font-size:', $font-size, ';font-family:', $font, ';position:absolute; top:', $top, 'px; left:', $left, 'px;', 'width:', $width, 'px; height:', $height, 'px;')"/>
			<xsl:choose>
				<!-- in case of body output the text with bullets -->
				<xsl:when test="$type = 'body'">
					<ul>
						<xsl:for-each select=".//a:p">
							<xsl:choose>
								<xsl:when test="count(.//a:buNone) = 0">
									<li>
										<xsl:for-each select="./a:r">
											<span>
												<xsl:attribute name="style">
													<xsl:apply-templates select="./a:rPr"/>
												</xsl:attribute>
												<xsl:for-each select="./a:t">
													<xsl:value-of select="."/>
												</xsl:for-each>
											</span>
										</xsl:for-each>
									</li>
								</xsl:when>
								<xsl:otherwise>
									<xsl:for-each select="./a:r">
										<span>
											<xsl:attribute name="style">
												<xsl:apply-templates select="./a:rPr"/>
											</xsl:attribute>
											<xsl:for-each select="./a:t">
												<xsl:value-of select="."/>
											</xsl:for-each>
										</span>
									</xsl:for-each>
								</xsl:otherwise>
							</xsl:choose>
						</xsl:for-each>
					</ul>
				</xsl:when>
				<xsl:otherwise>
					<!-- output each text element of all paragraphs -->
					<xsl:for-each select=".//a:p">
						<p>
							<xsl:for-each select="./child::*">
								<xsl:if test="./a:t">
									<span>
										<xsl:attribute name="style">
											<xsl:apply-templates select="./a:rPr"/>
										</xsl:attribute>
										<xsl:for-each select="./a:t">
											<xsl:value-of select="."/>
										</xsl:for-each>
									</span>
								</xsl:if>
							</xsl:for-each>
						</p>
					</xsl:for-each>
				</xsl:otherwise>
			</xsl:choose>
		</div>

	</xsl:template>

	<!-- returns the xfrm node either from the layout or the master xml -->
	<xsl:template name="get-xfrm">
		<xsl:param name="type"/>
		<xsl:param name="layout-ph-element"/>
		<xsl:param name="master-ph-element"/>
		
		<xsl:variable name="slide-xfrm" select="./p:spPr/a:xfrm"/>
		<xsl:variable name="layout-xfrm" select="$layout-ph-element/../../../p:spPr/a:xfrm"/>
		<xsl:variable name="master-xfrm" select="$master-ph-element/../../../p:spPr/a:xfrm"/>
		
		<xsl:choose>
			<!-- prefer the information from the slide layout -->
			<xsl:when test="count($slide-xfrm) > 0">
				<xsl:copy-of select="$slide-xfrm"/>
			</xsl:when>
			<xsl:when test="count($layout-xfrm) > 0">
				<xsl:copy-of select="$layout-xfrm"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:copy-of select="$master-xfrm"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<!-- returns the font size read either from the slide, slide layout or the master slide xml -->
	<xsl:template name="get-font-size">
		<xsl:param name="type"/>
		<xsl:param name="layout-ph-element"/>
		<xsl:param name="master-ph-element"/>
		
		<xsl:variable name="layout-pr" select="$layout-ph-element/../../../p:txBody/a:lstStyle//a:defRPr[@sz]"/>
		<xsl:variable name="master-pr" select="$master-ph-element/../../../p:txBody/a:lstStyle//a:defRPr[@sz]"/>
		
		<xsl:variable name="font-size">
			<xsl:choose>
				<xsl:when test="count($layout-pr) > 0">
					<xsl:value-of select="$layout-pr/@sz"/>
				</xsl:when>
				<xsl:when test="count($master-pr) > 0">
					<xsl:value-of select="$master-pr/@sz"/>
				</xsl:when>
				<xsl:when test="$type = 'title' or $type = 'ctrTitle'">
					<xsl:variable name="size" select="root($master-ph-element)//p:titleStyle/child::*[1]/a:defRPr"/>
					<xsl:value-of select="$size/@sz"/>
				</xsl:when>
				<xsl:when test="$type = 'body' or $type = 'subtitle'">
					<xsl:variable name="size" select="root($master-ph-element)//p:bodyStyle/child::*[1]/a:defRPr"/>
					<xsl:value-of select="$size/@sz"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:variable name="size" select="root($master-ph-element)//p:otherStyle/child::*[1]/a:defRPr"/>
					<xsl:value-of select="$size/@sz"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:value-of select="string(number($font-size) div 100)"/>
	</xsl:template>

	<!-- returns the major or minor font, depending on the type -->
	<xsl:template name="get-font">
		<xsl:param name="type"/>
		
		<xsl:choose>
			<xsl:when test="$type = 'title' or $type = 'ctrTitle'">
				<xsl:value-of select="$theme-doc//a:majorFont/a:latin/@typeface"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$theme-doc//a:minorFont/a:latin/@typeface"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<!-- resolves relative directories with given path -->
	<xsl:template name="resolve-directory">
		<xsl:param name="dir"/>
		<xsl:param name="relative-dir"/>
		
		<xsl:choose>
			<xsl:when test="starts-with($relative-dir, '..')">
				<xsl:variable name="dir-tok" select="tokenize($dir, '/')"/>
				<xsl:variable name="resolved-dir">
					<xsl:call-template name="resolve-directory">
						<xsl:with-param name="dir" select="string-join(subsequence($dir-tok, 1, count($dir-tok) - 2), '/')"/>
						<xsl:with-param name="relative-dir" select="substring($relative-dir, 4)"/>
					</xsl:call-template>
				</xsl:variable>
				<xsl:value-of select="$resolved-dir"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="concat($dir, '/', $relative-dir)"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	
	<!-- extracts the directory -->
	<xsl:template name="extract-directory">
		<xsl:param name="file-name"/>
		
		<xsl:variable name="tokens" select="tokenize($file-name, '/')"/>
		<xsl:variable name="dir" select="string-join(subsequence($tokens, 1, count($tokens) - 1), '/')"/>
		<xsl:value-of select="concat($dir, '/')"/>
	</xsl:template>

	<!-- extracts the file name -->
	<xsl:template name="extract-file">
		<xsl:param name="file-name"/>
		<xsl:variable name="tokens" select="tokenize($file-name, '/')"/>
		<xsl:variable name="file" select="$tokens[last()]"/>
		<xsl:value-of select="$file"/>
	</xsl:template>

	<!-- extract text styles from each paragraph (when set) -->
	<xsl:template match="a:rPr">
		<xsl:if test="./a:latin">font-family:<xsl:value-of select="./a:latin/@typeface"/>;</xsl:if>
		<xsl:if test="@sz">font-size:<xsl:value-of select="string(number(@sz) div 100)"/>;</xsl:if>
		<xsl:if test="@u = '1'">text-decoration:underline;</xsl:if>
		<xsl:if test="@b = '1'">font-weight:bold;</xsl:if>
		<xsl:if test="@i = '1'">font-style:italic;</xsl:if>
	</xsl:template>

</xsl:stylesheet>
