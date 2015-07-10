(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 Filename: nsQ3.xq  Section: 1.7.4.3 Q3  Select all elements that have an attribute whose  name is in the XML Schema namespace. :)

declare namespace dt = "http://www.w3.org/2001/XMLSchema";

<Q3>
  {
    doc("auction.xml")//*[@dt:*]
  }
</Q3> 






















