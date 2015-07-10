import schema namespace ipo="http://www.example.com/IPO" at "ipo.xsd";

(: Write a function that returns all comments found on an element, whether an item element or some other element that may have a comment. :)



declare function local:comments-for-element( $e as element() )
  as element(ipo:comment)*
{
  $e/element(ipo:comment)
};

for $p in doc("ipo.xml")//element(ipo:purchaseOrder)
where $p/shipTo/name="Helen Zoe"
  and $p/@orderDate = xs:date("1999-12-01")
return 
  <comments name="{$p/shipTo/name}" date="{$p/@orderDate}">
   {
     local:comments-for-element( $p )
   }
   {
     for $i in $p//item
     return local:comments-for-element( $i )
   }
  </comments> 