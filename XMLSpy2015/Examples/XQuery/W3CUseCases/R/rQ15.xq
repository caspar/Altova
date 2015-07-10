(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 Filename: rQ15.xq :)

(: Section: 1.4.4.15 Q15  List names of users who have placed multiple bids of at least $100 each. :)

(: testing XQ 3.8.1 FOR where  testing XQ 3.8.1 LET        testing XQ 3.8.3 Return  testing XQ 3.6 AND testing XQ 2.5.2 Comparison  testing XQ 3.2.1.7 text()  testing FO 15.3.1 fn:count():)


<result>
  {
    for $u in doc("users.xml")//user_tuple
    let $b := doc("bids.xml")//bid_tuple[userid=$u/userid and bid>=100]
    where count($b) > 1
    return
        <big_spender>{ $u/name/text() }</big_spender>
  }
</result>












