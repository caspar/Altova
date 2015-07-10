xquery version "1.0";
(: edited with XML Spy v2007r3i build May 18, 2007 (http://www.xmlspy.com) by mag (Altova) :)
(: This transform retrieves the contents of the users table from multiple spreadsheets in a Microsoft Excel 2007 XLSX file
    "ExcelDemo.xlsx" is the input instance:)

declare default element namespace "http://schemas.openxmlformats.org/spreadsheetml/2006/main";
import schema default element namespace "http://schemas.openxmlformats.org/spreadsheetml/2006/main" at "users.xsd";
declare namespace r  = "http://schemas.openxmlformats.org/package/2006/relationships"; 
(:===========variables:)
declare variable $officeDocmentURI 	:=	"http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument";
declare variable $sharedStringsURI	:=	"http://schemas.openxmlformats.org/officeDocument/2006/relationships/sharedStrings";
declare variable $xlsx-uri :=document-uri(.);
declare variable $rels-doc :=  doc(concat($xlsx-uri, '\_rels\.rels'));

declare variable $documentFileUri :=  concat($xlsx-uri, '\', $rels-doc/r:Relationships/r:Relationship[@Type=$officeDocmentURI]/@Target);
declare variable $rels-documentFileUri :=  concat ($xlsx-uri, '\xl\_rels\workbook.xml.rels');
declare variable $sharedStrings-FileUri :=  concat($xlsx-uri, '\xl\',local:getRelationship( $rels-documentFileUri ,$sharedStringsURI)/@Target);
declare variable $sharedStrings-doc := doc($sharedStrings-FileUri);

(:===========Functions:)
declare function local:getDocforSheetName( $sheetName as xs:string ) 
{ doc(concat ( $xlsx-uri, '\xl\worksheets\sheet', doc($documentFileUri)/workbook/sheets/sheet[@name=$sheetName]/@sheetId,'.xml'))};

(:finds a relationship in the archive .rel file the which is then used to create a file name:)
declare function local:getRelationship( $relFileUri as xs:string, $relURI as xs:string ) as element (r:Relationship) 
{  doc($relFileUri)/r:Relationships/r:Relationship[@Type=$relURI] };

(:get cell value:)
declare function local:getCellValue( $sheet,  $i) as xs:string
{if ($i/@t="s") then
   ($sharedStrings-doc//t)[$i/v + 1]
else     $i/v};
(:===========Main:)
validate{<users>{
let $usersSheet := local:getDocforSheetName("Users")
return  
for    $row in ($usersSheet/worksheet/sheetData/row[position()>1])
        return   
        <user_tuple>{  
		for  $colName at $j in ($usersSheet/worksheet/sheetData/row[1]/c)  let $cell  :=  $row/c[$j]	
			   return     
			   element   { QName("http://schemas.openxmlformats.org/spreadsheetml/2006/main", local:getCellValue($usersSheet, $colName))}  {local:getCellValue($usersSheet, $cell)} 
	   }</user_tuple>        
}</users>}
          
