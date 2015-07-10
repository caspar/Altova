(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
:)
(:
Filename: treeQ6.xq 
Section:   1.2.4.6 Q6 
Purpose:  Make a nested list of the section elements in Book1,  preserving their original attributes and hierarchy. Inside each section element,  include the title of the section and an element that includes  the number of figures immediately contained in the section. :)

(: This solution was provided by Michael Wenger,  a student at the University of W�g. :)
(: B.Biro Altova GmbH - the parameter of the function might be a seq with length != 1, so * added :)


declare function local:section-summary($book-or-section as element()*)
  as element()*
{
  for $section in $book-or-section
  return
    <section>
       { $section/@* }
       { $section/title }       
       <figcount>         
         { count($section/figure) }
       </figcount>                
       { local:section-summary($section/section) }                      
    </section>
};

<toc>
  {
    for $s in doc("book.xml")/book/section
    return local:section-summary($s)
  }
</toc> 


