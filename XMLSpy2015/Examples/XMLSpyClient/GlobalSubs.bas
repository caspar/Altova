Attribute VB_Name = "GlobalSubs"
Public nCurrentView As XMLSpyLib.SPYViewModes
Public nRet As Integer
Public objSpy As Application

Public Function GetNameOfKind(nKind As SPYXMLDataKind) As String
Select Case nKind
    Case spyXMLDataComment
        GetNameOfKind = "comment"
    Case spyXMLDataElement
        GetNameOfKind = "element"
    Case spyXMLDataAttr
        GetNameOfKind = "attribut"
    Case spyXMLDataCData
        GetNameOfKind = "CDATA"
    Case spyXMLDataDTDDocStruct
        GetNameOfKind = "DTD docstruct"
    Case Else
        GetNameOfKind = "other"
End Select
End Function

Public Sub CheckForError()
    If Err.Number <> 0 Then
        a = MsgBox("Error: " & (Err.Number - vbObjectError) & Chr(13) & "Description: " & Err.Description)
    End If
End Sub
