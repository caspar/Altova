(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 Filename: smglQ6.xq :)

(: Section: 1.5.4.6 Q6  List the short titles of all sections  (the values of the "shorttitle" attributes of all  "section" elements, expressing each short title as the  value of a new element.) :)

<result>
  {
    for $s in doc("sgml.xml")//section/@shorttitle
    return <stitle>{ $s }</stitle>
  }
</result> 




















