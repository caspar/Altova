import schema namespace ipo="http://www.example.com/IPO" at "ipo.xsd";
(:Write a query that returns purchase orders where the name in the shipping address does not match the name in the billing address.:)

(: insert-start :)

(: insert-end :)                    
declare function local:names-match( $s as element(shipTo), 
                                    $b as element(billTo) )
  as xs:boolean
{
     $s/name = $b/name
};
 
for $p in doc("ipo.xml")//element(ipo:purchaseOrder)
where not( local:names-match( $p/shipTo, $p/billTo ) )
return $p  