import schema namespace ipo="http://www.example.com/IPO" at "ipo.xsd";
import module namespace calc = "http://www.example.com/calc" at "calc.xq";

(: Write a function that computes the total price for a sequence of item elements.:)

for $p in doc("ipo.xml")//element(ipo:purchaseOrder)
where $p/shipTo/name="Helen Zoe"
   and $p/@orderDate = xs:date("1999-12-01")
return calc:total-price($p//item) 