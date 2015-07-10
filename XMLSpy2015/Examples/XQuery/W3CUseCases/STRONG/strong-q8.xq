import schema namespace ipo="http://www.example.com/IPO" at "ipo.xsd";
(: Find all comments found in an item shipped to Helen Zoe on the date 1999-12-01, including all elements in the substitution group for ipo:comment. :)




for $p in doc("ipo.xml")//element(ipo:purchaseOrder)
where $p/shipTo/name="Helen Zoe"
  and $p/@orderDate = xs:date("1999-12-01")
return $p//element(ipo:comment)