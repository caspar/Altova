(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 Filename: seqQ2.xq :)

(: Section: 1.3.4.2 Q2  In the Procedure section of Report1, what are the first two Instruments to be used? :)

<instr>{
for $s in doc("report1.xml")//section[section.title = "Procedure"]
return ($s//instrument)[position()<=2]}
</instr>
