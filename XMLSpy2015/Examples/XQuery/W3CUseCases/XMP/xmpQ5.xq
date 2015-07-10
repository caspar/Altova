(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
:)

(:
 Filename: xmpQ5.xq  
 Source:    http://www.w3.org/TR/xquery-use-cases/#xmp-queries-results-q4 
 Section:   1.1.9.5 Q5  
 Purpose:  For each book found at both bstore1.example.com and bstore2.example.com,  list the title of the book and its price from each source. 
 :)


<books-with-prices>
  {
    for $b in doc("bib.xml")//book,
        $a in doc("reviews.xml")//entry
    where $b/title = $a/title
    return
        <book-with-prices>
            { $b/title }
            <price-bstore2>{ $a/price/text() }</price-bstore2>
            <price-bstore1>{ $b/price/text() }</price-bstore1>
        </book-with-prices>
  }
</books-with-prices>

