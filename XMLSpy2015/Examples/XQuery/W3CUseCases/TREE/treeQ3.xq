(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 Filename: treeQ3.xq :)

(: Section: 1.2.4.3 Q3  How many sections are in Book1, and how many figures? :)

<count>
<section_count>{ count(doc("book.xml")//section) }</section_count>
<figure_count>{ count(doc("book.xml")//figure) }</figure_count> 
</count>
