(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 Filename: rQ16.xq :)

(: Section: 1.4.4.16 Q16  List all registered users in order by userid;  for each user, include the userid, name, and an indication  of whether the user is active (has at least one bid on record)  or inactive (has no bid on record). :)

(: testing FO 15.4.4 fn:doc  testing XQ 3.8.1 FOR   testing XQ 3.8.2 WHERE  testing XQ 3.8.3   Order by Return  testing XQ 3.2.4 Abbrev. Syntax  testing FO 15.1.7 fn:empty  testing XQ 3.10 IF  :)


<result>
  {
    for $u in doc("users.xml")//user_tuple
    let $b := doc("bids.xml")//bid_tuple[userid = $u/userid]
    order by $u/userid
    return
        <user>
            { $u/userid }
            { $u/name }
            {
                if (empty($b))
                  then <status>inactive</status>
                  else <status>active</status>
            }
        </user>
  }
</result>














