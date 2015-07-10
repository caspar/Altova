xquery version "1.0";

declare namespace altova="http://www.altova.com";
declare namespace altovaext="http://www.altova.com/xslt-extensions";

(: Note: This example generates HTML output. Please change the 'Serialization Method' to html in the XSLT/XQuery Settings dialog. :)

declare function altova:YearlySalesChart( $documentRoot, $chartFileName as xs:string , $chartWidthPx as xs:integer, $chartHeightPx as xs:integer )
{
	let
		(: These here are the serialized chart settings. You can use the 'Change Appearance' dialog to obtain these settings by saving them to an XML file. :)
		(: Please note that this is done automatically if you use the the Export XSLT/XQ functionality in the Charts dialog bar. :)
		$chartSettings as node() :=
		<chart-config>
			<General SettingsVersion="1">
				<TitleFont/>
				<LegendFont/>
				<AxisLabelFont/>
			</General>
		</chart-config>,
		(: Load the above chart settings to memory so they can be used to generate the chart later on. :)
		$chartConfig as item()* := altovaext:create-chart-config-from-xml( $chartSettings ),

		(: Get all the data that is needed to create your chart. :)
		$regions as item()* := $documentRoot/Data/Region,

		(: We are interested in displaying the sales of each year for each region. For this we create a row for each region consisting of the year (X axis) and its sales (Y axis) for each year. :)
		$year2005 as item()* := altovaext:create-chart-data-series-from-rows( '2005', for $i in $regions return altovaext:create-chart-data-row($i/@id, $i/Year[1]) ),
		$year2006 as item()* := altovaext:create-chart-data-series-from-rows( '2006', for $i in $regions return altovaext:create-chart-data-row($i/@id, $i/Year[2]) ),
		$year2007 as item()* := altovaext:create-chart-data-series-from-rows( '2007', for $i in $regions return altovaext:create-chart-data-row($i/@id, $i/Year[3]) ),
		$year2008 as item()* := altovaext:create-chart-data-series-from-rows( '2008', for $i in $regions return altovaext:create-chart-data-row($i/@id, $i/Year[4]) ),
		$year2009 as item()* := altovaext:create-chart-data-series-from-rows( '2009', for $i in $regions return altovaext:create-chart-data-row($i/@id, $i/Year[5]) ),
		$year2010 as item()* := altovaext:create-chart-data-series-from-rows( '2010', for $i in $regions return altovaext:create-chart-data-row($i/@id, $i/Year[6]) ),

		(: Finally create the actual chart with its loaded config and all the created series' :)
		$chart := altovaext:create-chart( $chartConfig, ( $year2005, $year2006, $year2007, $year2008, $year2009, $year2010 ) )

	(: The resulting image needs only to be written to disk. For this we need the file name and the image width/height. :)
	return altovaext:save-chart-image( $chart, $chartFileName, $chartWidthPx, $chartHeightPx )
};

(: This example illustrates how to use the chart functionality from whithin XQ. :)
declare variable $altova:sChartFileName :=  concat(altovaext:get-temp-folder(), 'yearlysales.png');
<html>
	<head>
		<title>Example Chart HTML - generated with Altova XQuery Engine</title>
	</head>
	<body>
		<img>
			{
					attribute {"src"}
					{
						$altova:sChartFileName,
						altova:YearlySalesChart(., $altova:sChartFileName, 1000, 300)
					}
			}
		</img>
	</body>
</html>
