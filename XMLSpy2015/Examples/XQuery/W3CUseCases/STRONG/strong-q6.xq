import schema namespace ipo="http://www.example.com/IPO" at "ipo.xsd";

(:Find purchase orders where the billing address is not a USAddress, but at least one price is a USPrice.:)
(:- Note a altered input file is used to deliver some sort of result:)

for $p in doc("ipo_2.xml")//element(ipo:purchaseOrder),
    $b in $p/billTo
where not( $b instance of element(*, ipo:USAddress))
  and exists( $p//USPrice )
return $p 