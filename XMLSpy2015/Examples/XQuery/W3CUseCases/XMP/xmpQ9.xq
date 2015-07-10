(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
:)
(:
 Filename: xmpQ9.xq  
 Source:    http://www.w3.org/TR/xquery-use-cases/#xmp-queries-results-q9
 Section:   1.1.9.9 
 Purpose:   Q9  In the document "books.xml", find all section or Section titles that contain  the word "XML", regardless of the level of nesting. 
 :)


<results>
  {
    for $t in doc("books.xml")//(Section | section)/title
    where contains($t/text(), "XML")
    return $t
  }
</results> 

