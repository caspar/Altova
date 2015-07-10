(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 Filename: nsQ5.xq  Section: 1.7.4.5 Q5  Select all records that have a remark in German. :)

declare namespace music = "http://www.example.org/music/records";

<Q5 xmlns:music="http://www.example.org/music/records">
  {
     doc("auction.xml")//music:record[music:remark/@xml:lang = "de"]
  }
</Q5> 
























