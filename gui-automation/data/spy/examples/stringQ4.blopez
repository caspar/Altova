(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
:)
(:
Filename: stringQ4.xq 
Section: 1.6.4.4 Q4  
Purpose: Find news items where a company and one of its partners  is mentioned in the same news item and the news item is  not authored by the company itself. :)



declare function local:partners($company as xs:string) as element()*
{
    let $c := doc("company-data.xml")//company[name = $company]
    return $c//partner
};

<a>{
for $item in doc("string.xml")//news_item,
    $c in doc("company-data.xml")//company
let $partners := local:partners($c/name)
where contains(string($item), $c/name)
  and (some $p in $partners satisfies
    contains(string($item), $p) and $item/news_agent != $c/name)
return
    $item 
    }
</a>
















