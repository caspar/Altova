(:This report, which lists products sold by zip code, is based on US purchase orders, not on the international purchase report used in previous queries. In the XML Schema Primer, these US purchase orders are defined without a namespace.:)



import schema namespace ipo = "http://www.example.com/IPO" at "ipo.xsd";
import schema namespace rpt = "http://www.example.com/Report" at "report.xsd";

let $orders := doc("strong-q12.xml")/ipo:purchaseOrder
                 [@orderDate ge xs:date("1999-09-01")
                  and @orderDate le xs:date("1999-12-31")] 
let $items := $orders/items/item
let $zips := distinct-values($orders/billTo/zip)
let $parts := distinct-values($items/@partNum)
return
 <rpt:purchaseReport>
  <rpt:regions>
    {
     for $zip in $zips
     order by $zip
     return
      <rpt:zip code="{$zip}">
       {
        for $part in $parts
        let $hits := $orders[ billTo/zip = $zip and items/item/@partNum = $part]
        let $quantity := sum($hits//item[@partNum=$part]/quantity)
        where count($hits) > 0
        order by $part
        return
         <rpt:part number="{$part}" quantity="{$quantity}"/>
       }
      </rpt:zip>
    }
  </rpt:regions>
  <rpt:parts>
   {
     for $part in $parts
     return
      <rpt:part number="{$part}">
       {
         string($items[@partNum = $part]/productName)
       }
      </rpt:part>   
   }
  </rpt:parts>
</rpt:purchaseReport>