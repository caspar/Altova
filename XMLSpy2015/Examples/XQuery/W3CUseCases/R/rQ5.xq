(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 Filename: rQ5.xq :)

(: Section: 1.4.4.5 Q5  For bicycle(s) offered by Tom Jones that have received a bid,  list the item number, description, highest bid, and name of  the highest bidder, ordered by item number. :)

(: The query does several joins, and requires the results  in a particular order. If there were no order by clause, results  would be reported in document order. If you do not care about the order,  you can use the unordered function to inform the query processor that  the order of the lists in the for clause is not significant,  which means that the tuples can be generated in any order.  This can enable better optimization.:)

<result>
  {
    for $seller in doc("users.xml")//user_tuple,
        $buyer in  doc("users.xml")//user_tuple,
        $item in  doc("items.xml")//item_tuple,
        $highbid in  doc("bids.xml")//bid_tuple
    where $seller/name = "Tom Jones"
      and $seller/userid  = $item/offered_by
      and contains($item/description , "Bicycle")
      and $item/itemno  = $highbid/itemno
      and $highbid/userid  = $buyer/userid
      and $highbid/bid = max(
                              doc("bids.xml")//bid_tuple
                                [itemno = $item/itemno]/bid
                         )
    order by ($item/itemno)
    return
        <jones_bike>
            { $item/itemno }
            { $item/description }
            <high_bid>{ $highbid/bid }</high_bid>
            <high_bidder>{ $buyer/name }</high_bidder>
        </jones_bike>
  }
</result> 




