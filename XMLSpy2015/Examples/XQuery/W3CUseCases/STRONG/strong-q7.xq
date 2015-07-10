import schema namespace ipo="http://www.example.com/IPO" at "ipo.xsd";

(:Write a function that returns the text of a comment. Call this function for each shipping comment found in an item shipped to Helen Zoe on the date 1999-12-01.:)


declare function local:comment-text($c as element(ipo:comment))
  as xs:string
{
    xs:string( $c )
};

for $p in doc("ipo.xml")//element(ipo:purchaseOrder),
    $t in local:comment-text( $p//ipo:comment )
where $p/shipTo/name="Helen Zoe"
    and $p/@orderDate = xs:date("1999-12-01")
return $t 