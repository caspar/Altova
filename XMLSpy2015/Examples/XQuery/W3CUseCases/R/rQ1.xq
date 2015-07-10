(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 Filename: rQ1.xq :)

(: Section: 1.4.4.1 Q1  List the item number and description of all bicycles that currently  have an auction in progress, ordered by item number. :)

(: NOTE: This solution assumes that the current date is 1999-01-31.  
The query returns an element named item_tuple, but its definition  does not match the
 definition of item_tuple in the DTD. :)

declare variable $current-date:= xs:date('1999-01-31'); 

<result>
  {
    for $i in doc("items.xml")//item_tuple
    where $i/start_date <= (:current-date():) $current-date
      and $i/end_date >= (:current-date():) $current-date
      and contains($i/description, "Bicycle")
    order by $i/itemno
    return
        <item_tuple>
            { $i/itemno }
            { $i/description }
        </item_tuple>
  }
</result>

