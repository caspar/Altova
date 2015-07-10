import schema namespace ipo="http://www.example.com/IPO" at "ipo.xsd";

(: Write a function that determines whether the person listed in a billTo element is known to be a deadbeat, using a US database.
:)


declare function local:deadbeat( $b as element(billTo, ipo:Address) )
  as xs:boolean
{
  (: $b/name = doc("MY WEB ADDRESS .... deadbeats.xml")/deadbeats/row/name:)
    $b/name = doc("deadbeats.xml")/deadbeats/row/name
}; 

for $p in doc("ipo_3.xml")//element(ipo:purchaseOrder)
where $p/@orderDate = xs:date("1999-12-01")
  and local:deadbeat( $p/element(billTo) )
return <warning>{ $p/billTo/name, " is a known deadbeat!" }</warning>