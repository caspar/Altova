(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
:)

(:
 Filename:  xmpQ6.xq  
 Source:     http://www.w3.org/TR/xquery-use-cases/#xmp-queries-results-q6 
 Section:    1.1.9.6 Q6  
 Purpose:   For each book that has at least one author, list the title and first two authors,  and an empty "et-al" element if the book has additional authors. 
 :)



<bib>
  {
    for $b in doc("bib.xml")//book
    where count($b/author) > 0
    return
        <book>
            { $b/title }
            {
                for $a in $b/author[position()<=2]  
                return $a
            }
            {
                if (count($b/author) > 2)
                 then <et-al/>
                 else ()
            }
        </book>
  }
</bib>

