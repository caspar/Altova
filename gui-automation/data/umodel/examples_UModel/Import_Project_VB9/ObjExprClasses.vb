' name:     ObjExprClasses.vb
' project:  LINQ_To_XML_15.vbproj
' type:     Class
' Namespace:Root
' author:   baa
' date:     2008-01-22
' spec:     11.24 XML Member Access Expressions
' desc:     An XML member access expression accesses the members of an XML value. 
'           There are three types of XML member access expressions.
'           test aspect: Attribute access, in which a Visual Basic identifier
'           follows a dot and an at sign, or an XML name follows a dot and an at sign.
' changes: 


Class test

    ' simple XElement
    Dim customer As XElement = _
            <customer age="30"><name>Bob Marley</name></customer>

    ' attribute access using @
    Dim customerName = customer.@age

    Sub NameOut()
        Console.WriteLine(customerName)
        Console.ReadLine()

        
    End Sub
End Class




