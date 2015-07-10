(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 Filename: partsQ1.xq :)

(: Section: 1.8.4.1 Q1  Convert the sample document from "partlist" format to "parttree" format (see DTD section for definitions).  In the result document, part containment is represented by containment of one <part> element inside another.  Each part that is not part of any other part should appear as a separate top-level element in the output document. :)

declare function local:one_level($p as element()) as element()
{
    <part partid="{ $p/@partid }"
          name="{ $p/@name }" >
        {
            for $s in doc("partlist.xml")//part
            where $s/@partof = $p/@partid
            return local:one_level($s)
        }
    </part>
};

<parttree>
  {
    for $p in doc("partlist.xml")//part[empty(@partof)]
    return local:one_level($p)
  }
</parttree>





























