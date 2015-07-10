<?xml version="1.0" encoding="UTF-8"?>
<?altova_samplexml YearlySales.xml?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:altovaext="http://www.altova.com/xslt-extensions" xmlns:altova="http://www.altova.com">
	<xsl:output version="4.0" method="html" indent="yes" encoding="UTF-8" doctype-public="-//W3C//DTD HTML 4.01 Transitional//EN" doctype-system="http://www.w3.org/TR/html4/loose.dtd"/>

	<!-- This example illustrates how to use the chart functionality from whithin XSLT. -->
	<xsl:template match="/">
		<xsl:variable name="chartFileName" select="concat(altovaext:get-temp-folder(), 'yearlysales.png')"/>
		<!-- This just creates an img element in the result HTML to display the resulting chart image. -->
		<html>
			<head>
				<title>Example Chart HTML - generated with Altova XSLT Engine</title>
			</head>
			<body>
				<img>
					<xsl:attribute name="alt" select="'chart'"/>
					<xsl:attribute name="src">
						<xsl:value-of select="altova:YearlySalesChart(., $chartFileName, 1000, 300), $chartFileName"/>
					</xsl:attribute>
				</img>
			</body>
		</html>
	</xsl:template>

	<xsl:function name="altova:YearlySalesChart" as="xs:string" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:altovaext="http://www.altova.com/xslt-extensions" xmlns:altova="http://www.altova.com">
		<!-- The document element from where to read the XML data for the Charts -->
		<xsl:param name="documentRoot"/>
		<!-- Specify the file name of the generated Chart image -->
		<xsl:param name="chartFileName" as="xs:string"/>
		<!-- Specify the width and height of the generated Chart image -->
		<xsl:param name="chartWidthPx" as="xs:integer"/>
		<xsl:param name="chartHeightPx" as="xs:integer"/>
	
		<!-- These here are the serialized chart settings. You can use the 'Change Appearance' dialog to obtain these settings by saving them to an XML file. -->
		<!-- Please note that this is done automatically if you use the the Export XSLT/XQ functionality in the Charts dialog bar. -->
		<xsl:variable name="chartSettings">
			<chart-config>
				<General SettingsVersion="1">
					<TitleFont/>
					<LegendFont/>
					<AxisLabelFont/>
				</General>
			</chart-config>
		</xsl:variable>
		<!-- Load the above chart settings to memory so they can be used to generate the chart later on. -->
		<xsl:variable name="chartConfig" select="altovaext:create-chart-config-from-xml( $chartSettings )"/>
	
		<!-- Get all the data that is needed to create your chart. -->
		<xsl:variable name="regions" as="item()*" select="$documentRoot/Data/Region"/>

		<!-- We are interested in displaying the sales of each year for each region. For this we create a row for each region consisting of the year (X axis) and its sales (Y axis) for each year. -->
		<xsl:variable name="year2005" as="item()*" select="altovaext:create-chart-data-series-from-rows( '2005', for $i in $regions return altovaext:create-chart-data-row($i/@id, $i/Year[1]) )"/>
		<xsl:variable name="year2006" as="item()*" select="altovaext:create-chart-data-series-from-rows( '2006', for $i in $regions return altovaext:create-chart-data-row($i/@id, $i/Year[2]) )"/>
		<xsl:variable name="year2007" as="item()*" select="altovaext:create-chart-data-series-from-rows( '2007', for $i in $regions return altovaext:create-chart-data-row($i/@id, $i/Year[3]) )"/>
		<xsl:variable name="year2008" as="item()*" select="altovaext:create-chart-data-series-from-rows( '2008', for $i in $regions return altovaext:create-chart-data-row($i/@id, $i/Year[4]) )"/>
		<xsl:variable name="year2009" as="item()*" select="altovaext:create-chart-data-series-from-rows( '2009', for $i in $regions return altovaext:create-chart-data-row($i/@id, $i/Year[5]) )"/>
		<xsl:variable name="year2010" as="item()*" select="altovaext:create-chart-data-series-from-rows( '2010', for $i in $regions return altovaext:create-chart-data-row($i/@id, $i/Year[6]) )"/>
	
		<!-- Finally create the actual chart with its loaded config and all the created series' -->
		<xsl:variable name="chart" select="altovaext:create-chart( $chartConfig, ( $year2005, $year2006, $year2007, $year2008, $year2009, $year2010 ) )"/>

		<!-- The resulting image needs only to be written to disk. For this we need the file name and the image width/height. -->
		<xsl:value-of select="altovaext:save-chart-image( $chart, $chartFileName, $chartWidthPx, $chartHeightPx )"/>

		<!-- The chart image was saved and can now be referenced in the result HTML. -->

	</xsl:function>

</xsl:stylesheet>
