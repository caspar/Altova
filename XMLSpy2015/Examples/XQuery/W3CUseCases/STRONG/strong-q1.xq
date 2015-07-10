import schema namespace ipo = "http://www.example.com/IPO" at "address.xsd";

(: insert-start :)

(: insert-end :)


                        
count( 
  doc("ipo.xml")//shipTo[.  instance of element(*, ipo:UKAddress)]
)
