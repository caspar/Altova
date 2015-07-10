(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 Filename: rQ18.xq :)

(: Section: 1.4.4.18 Q18  List all users in alphabetic order by name.  For each user, include descriptions of all the items (if any)  that were bid on by that user, in alphabetic order. :)

(: testing FO 15.4.4 fn:doc  testing XQ 3.8.1 FOR   testing XQ 3.8.2 WHERE  testing XQ 3.8.3   Order by Return  testing FO 15.9.1 distinct-values  testing XQ 3.8.1  LET  :)


<result>
  {
    for $u in doc("users.xml")//user_tuple
    order by $u/name
    return
        <user>
            { $u/name }
            {
                for $b in distinct-values(doc("bids.xml")//bid_tuple
                                             [userid = $u/userid]/itemno)
                for $i in doc("items.xml")//item_tuple[itemno = $b]
                let $descr := $i/description/text()
                order by $descr
                return
                    <bid_on_item>{ $descr }</bid_on_item>
            }
        </user>
  }
</result>













