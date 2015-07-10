(:
XML Query Use Cases: http://www.w3.org/TR/xquery-use-cases/
Copyright ©2003 World Wide Web Consortium, (Massachusetts Institute of Technology, European Research Consortium for Informatics and Mathematics, Keio University). All Rights Reserved. This work is distributed under the W3C® Software License [1] in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
[1] http://www.w3.org/Consortium/Legal/2002/copyright-software-20021231
 Filename: stringQ5.xq :)

(: Section: 1.6.4.5 Q5  For each news item that is relevant to the Gorilla  Corporation, create an "item summary" element.  The content of the item summary is the content of the title,  date, and first paragraph of the news item, separated by periods.  A news item is relevant if the name of the company is mentioned  anywhere within the content of the news item. :)
<items>{
for $item in doc("string.xml")//news_item
where contains(string($item/content), "Gorilla Corporation")
return
    <item_summary>
        { $item/title/text() }
        { $item/date/text() }
        { string(($item//par)[1]) }
    </item_summary> 
 }
</items>



















