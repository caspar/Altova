(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
:)

(:
 Filename: xmpQ8.xq  
 Source:    http://www.w3.org/TR/xquery-use-cases/#xmp-queries-results-q8 
 Section:    1.1.9.8 Q8  
 Purpose:   Find books in which the name of some element ends with the string "or"  and the same element contains the string "Suciu" somewhere in its content.  For each such book, return the title and the qualifying element. 
 :)


for $b in doc("bib.xml")//book
let $e := $b/*[contains(string(.), "Suciu") 
               and ends-with(local-name(.), "or")]
where exists($e)
return
    <book>
        { $b/title }
        { $e }
    </book> 

