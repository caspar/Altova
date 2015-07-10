(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 Filename: nsQ4.xq  Section: 1.7.4.4 Q4  List the target URI's of all XLinks in the document. :)


declare namespace xlink = "http://www.w3.org/1999/xlink";

<Q4 xmlns:xlink="http://www.w3.org/1999/xlink">
  {
    for $hr in doc("auction.xml")//@xlink:href
    return <ns>{ $hr }</ns>
  }
</Q4>























