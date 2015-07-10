(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 Filename: rQ6.xq :)

(: Section: 1.4.4.6 Q6  For each item whose highest bid is more than twice its reserve  
price, list the item number, description, reserve price, and highest bid. :)



<result>
  {
    for $item in doc("items.xml")//item_tuple
    let $b := doc("bids.xml")//bid_tuple[itemno = $item/itemno]
    let $z := max($b/bid)
    where $item/reserve_price * 2 < $z
    return
        <successful_item>
            { $item/itemno }
            { $item/description }
            { $item/reserve_price }
            <high_bid>{$z }</high_bid>
         </successful_item>
  }
</result> 




