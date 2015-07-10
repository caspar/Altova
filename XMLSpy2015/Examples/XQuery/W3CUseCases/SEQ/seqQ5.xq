(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 Filename: seqQ5.xq :)

(: Section: 1.3.4.5 Q5 In Report1, what happened between the first Incision and the second Incision? :)



declare function local:precedes($a as node(), $b as node()) as xs:boolean 
{
    $a << $b
      and
    empty($a//node() intersect $b)
};


declare function local:follows($a as node(), $b as node()) as xs:boolean 
{
    $a >> $b
      and
    empty($b//node() intersect $a)
};

<critical_sequence>
 {
  let $proc := doc("report1.xml")//section[section.title="Procedure"][1]
  for $n in $proc//node()
  where local:follows($n, ($proc//incision)[1])
    and local:precedes($n, ($proc//incision)[2])
  return $n
 }
</critical_sequence> 



