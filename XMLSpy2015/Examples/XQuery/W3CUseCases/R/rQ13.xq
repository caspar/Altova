(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 Filename: rQ13.xq :)

(: Section: 1.4.4.13 Q13  For each user who has placed a bid, give the
 userid,  name, number of bids, and average bid, in order by userid. :)


<result>
 {
    for $uid in distinct-values(doc("bids.xml")//userid),
        $u in doc("users.xml")//user_tuple[userid = $uid]
    let $b := doc("bids.xml")//bid_tuple[userid = $uid]
    order by $u/userid
    return
        <bidder>
            { $u/userid }
            { $u/name }
            <bidcount>{ count($b) }</bidcount>
            <avgbid>{ avg($b/bid) }</avgbid>
        </bidder>
  }
</result> 











