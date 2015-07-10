(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 Filename: smglQ3.xq :)

(: Section: 1.5.4.3 Q3  Locate all paragraphs in the introduction of a section  that is 
in a Section that has no introduction 
(all "para"  elements 
        directly contained within an "intro" element 
               directly  contained in a "section" element 
                     directly contained in a "Section" element.  
The "Section" element must not directly contain an "intro" element). :)

<result>
  {
    for $c in doc("sgml.xml")//chapter
    where empty($c/intro)
    return $c/section/intro/para
  }
</result> 
















