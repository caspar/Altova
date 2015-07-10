VERSION 5.00
Begin VB.Form ClientWnd 
   BorderStyle     =   3  'Fixed Dialog
   Caption         =   "XMLSpy Client"
   ClientHeight    =   3780
   ClientLeft      =   210
   ClientTop       =   780
   ClientWidth     =   6015
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   3780
   ScaleWidth      =   6015
   Begin VB.PictureBox CtrlPic 
      Appearance      =   0  'Flat
      AutoSize        =   -1  'True
      BackColor       =   &H80000005&
      ForeColor       =   &H80000008&
      Height          =   3780
      Left            =   0
      Picture         =   "ClientWnd.frx":0000
      ScaleHeight     =   3750
      ScaleWidth      =   6000
      TabIndex        =   0
      Top             =   0
      Width           =   6030
   End
   Begin VB.Menu MApp 
      Caption         =   "Application"
      Begin VB.Menu MIStartSpy 
         Caption         =   "Start XMLSpy"
      End
      Begin VB.Menu MISupport 
         Caption         =   "Support..."
         Visible         =   0   'False
      End
      Begin VB.Menu MIS100 
         Caption         =   "-"
      End
      Begin VB.Menu MIShowApp 
         Caption         =   "Show Application"
      End
      Begin VB.Menu MIS 
         Caption         =   "-"
      End
      Begin VB.Menu MIWalkDocs 
         Caption         =   "Show Documents ..."
      End
      Begin VB.Menu MIS12 
         Caption         =   "-"
      End
      Begin VB.Menu MIQuit 
         Caption         =   "Quit"
      End
   End
   Begin VB.Menu MProject 
      Caption         =   "Project"
      Begin VB.Menu MINewProj 
         Caption         =   "New Project"
      End
      Begin VB.Menu MIOpenProj 
         Caption         =   "Open Project"
      End
      Begin VB.Menu MIS7 
         Caption         =   "-"
      End
      Begin VB.Menu MISaveProj 
         Caption         =   "Save Project"
      End
      Begin VB.Menu MIPrjSaveAs 
         Caption         =   "Save Project As ..."
      End
      Begin VB.Menu MIS8 
         Caption         =   "-"
      End
      Begin VB.Menu MICloseProj 
         Caption         =   "Close Project"
      End
      Begin VB.Menu MIS9 
         Caption         =   "-"
      End
      Begin VB.Menu MIWalkProjTree 
         Caption         =   "Walk Project tree ..."
      End
   End
   Begin VB.Menu MDoc 
      Caption         =   "Document"
      Begin VB.Menu MIOpenDoc 
         Caption         =   "Open File ..."
      End
      Begin VB.Menu MIOpenURL 
         Caption         =   "Open URL..."
      End
      Begin VB.Menu MIS101 
         Caption         =   "-"
      End
      Begin VB.Menu MISave 
         Caption         =   "Save"
      End
      Begin VB.Menu MIS3 
         Caption         =   "-"
      End
      Begin VB.Menu MIDocClose 
         Caption         =   "Close active document"
      End
      Begin VB.Menu MIS20 
         Caption         =   "-"
      End
      Begin VB.Menu MISetEncoding 
         Caption         =   "Set Encoding ..."
      End
      Begin VB.Menu MIS1 
         Caption         =   "-"
      End
      Begin VB.Menu MIStepXML 
         Caption         =   "Step through XML ..."
      End
      Begin VB.Menu MISaveStr 
         Caption         =   "Save in string"
      End
      Begin VB.Menu MIS6 
         Caption         =   "-"
      End
      Begin VB.Menu MIWellFormed 
         Caption         =   "Well Formed?"
      End
      Begin VB.Menu MIValid 
         Caption         =   "Valid?"
      End
      Begin VB.Menu MIS4 
         Caption         =   "-"
      End
      Begin VB.Menu MIAssignDTD 
         Caption         =   "Assign DTD..."
      End
      Begin VB.Menu MIAssignSchema 
         Caption         =   "Assign Schema..."
      End
      Begin VB.Menu MIGenDTD 
         Caption         =   "Generate DTD/Schema"
      End
      Begin VB.Menu MIS21 
         Caption         =   "-"
      End
      Begin VB.Menu MIAssignXSL 
         Caption         =   "Assign XSL"
      End
      Begin VB.Menu MITransXSL 
         Caption         =   "Transform XSL"
      End
   End
   Begin VB.Menu MView 
      Caption         =   "View"
      Begin VB.Menu MIText 
         Caption         =   "Text view"
      End
      Begin VB.Menu MIGrid 
         Caption         =   "Grid view"
      End
      Begin VB.Menu MISchema 
         Caption         =   "Schema view"
      End
      Begin VB.Menu MIAuthentic 
         Caption         =   "AUTHENTIC view"
      End
      Begin VB.Menu MIBrowser 
         Caption         =   "Browser view"
      End
   End
   Begin VB.Menu MConvert 
      Caption         =   "Convert"
      Begin VB.Menu MIImpDB 
         Caption         =   "Import from database ..."
      End
      Begin VB.Menu MIImpText 
         Caption         =   "Import from text..."
      End
      Begin VB.Menu MIImpWord 
         Caption         =   "Import from MSWord ..."
      End
      Begin VB.Menu MIS14 
         Caption         =   "-"
      End
      Begin VB.Menu MIExportTo 
         Caption         =   "Export to ..."
      End
   End
End
Attribute VB_Name = "ClientWnd"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Private Sub Btn_SpyClose_Click()
    On Error Resume Next
    objSpy.CurrentProject.CloseProject False, True, False
    CheckForError
End Sub

Public Sub ModifyChild(objChild As XMLData)
    Dim dlgMod As ModXMLDataDlg
    Set dlgMod = New ModXMLDataDlg
    dlgMod.nKind = objChild.Kind
    dlgMod.NameEdit = objChild.Name
    dlgMod.ValueEdit = objChild.TextValue
    dlgMod.bOK = False
    dlgMod.Show vbModal
    If dlgMod.bOK = True Then
        objChild.Name = dlgMod.NameEdit
        objChild.TextValue = dlgMod.ValueEdit
    End If
End Sub

Public Sub WalkTree(objColl As SpyProjectItems)
    Dim nRet As Integer
    Dim objProjItem As SpyProjectItem
    Dim objChild As XMLData
    On Error Resume Next
    
    For Each objProjItem In objColl
        If objProjItem.ItemType = spyFileItem Then
            Dim objTmpChild As Document
            a = MsgBox("Name: " & objProjItem.Name & ", Typ: File")
            objTmpChild = objProjItem.Open
            CheckForError
        End If
        If objProjItem.ItemType = spyFolderItem Then
            a = MsgBox("Name: " & objProjItem.Name & ", Typ: Folder, Extensions: " & objProjItem.FileExtensions & ", stepping into" & Chr(13) & "File einfügen?", vbYesNo)
            If a = vbYes Then
                Dim objDlg
                Set objDlg = CreateObject("MSComDlg.CommonDialog")
                objDlg.DialogTitle = "Choose a file"
                objDlg.ShowOpen
                
                If Len(objDlg.FileName) > 0 Then
                    objProjItem.ChildItems.AddFile (objDlg.FileName)
                End If
                Exit Sub
            End If
              
            WalkTree objProjItem.ChildItems
        End If
        If objProjItem.ItemType = spyURLItem Then
            a = MsgBox("Name: " & objProjItem.Name & ", Typ: URL")
        End If
    Next
End Sub

Private Sub Btn_SpySave_Click()
    On Error Resume Next
    objSpy.CurrentProject.SaveProject
    CheckForError
End Sub

Private Sub objSpy_OnOpenDocument()
    a = MsgBox("SpyCOMApp fired OnOpenDocument()")
End Sub

Private Sub Form_Initialize()
    nCurrentView = spyViewGrid
End Sub

Private Sub MIAssignDTD_Click()
    On Error GoTo ErrorHandler
    Dim objDlg
    Set objDlg = CreateObject("MSComDlg.CommonDialog")
    objDlg.DialogTitle = "Choose DTD"
    objDlg.ShowOpen
    
    If Len(objDlg.FileName) > 0 Then
        objSpy.ActiveDocument.AssignDTD objDlg.FileName, False
        objSpy.ActiveDocument.UpdateViews
    End If
    Exit Sub
    
ErrorHandler:
    CheckForError
End Sub

Private Sub MIAssignSchema_Click()
    On Error GoTo ErrorHandler
    Dim objDlg
    Set objDlg = CreateObject("MSComDlg.CommonDialog")
    objDlg.DialogTitle = "Choose schema file"
    objDlg.ShowOpen
    
    If Len(objDlg.FileName) > 0 Then
        objSpy.ActiveDocument.AssignSchema objDlg.FileName, False
        objSpy.ActiveDocument.UpdateViews
    End If
    Exit Sub
    
ErrorHandler:
    CheckForError
End Sub

Private Sub MIAssignXSL_Click()
    If Not (objSpy.ActiveDocument Is Nothing) Then
        On Error GoTo ErrorHandler
        Dim objDlg
        Set objDlg = CreateObject("MSComDlg.CommonDialog")
        objDlg.DialogTitle = "Choose XSL"
        objDlg.ShowOpen
        
        If Len(objDlg.FileName) > 0 Then
            objSpy.ActiveDocument.AssignXSL objDlg.FileName, False
            objSpy.ActiveDocument.UpdateViews
        End If
    End If
    Exit Sub
    
ErrorHandler:
        CheckForError
End Sub

Private Sub MIAuthentic_Click()
    If Not (objSpy Is Nothing) Then
        If Not (objSpy.ActiveDocument Is Nothing) Then
            objSpy.ActiveDocument.SwitchViewMode spyViewContent
        End If
    End If
    UpdateViewMenu
End Sub

Private Sub MIBrowser_Click()
    If Not (objSpy Is Nothing) Then
        If Not (objSpy.ActiveDocument Is Nothing) Then
            objSpy.ActiveDocument.SwitchViewMode spyViewBrowser
        End If
    End If
    UpdateViewMenu
End Sub

Private Sub MICloseProj_Click()
    On Error Resume Next
    objSpy.CurrentProject.CloseProject True, True, True
    CheckForError
End Sub

Private Sub MIDocClose_Click()
    If Not (objSpy.ActiveDocument Is Nothing) Then
        objSpy.ActiveDocument.Close True
        If Not (objSpy.ActiveDocument Is Nothing) Then
            Me.Caption = "XMLSpy Client - " & objSpy.ActiveDocument.GetPathName
        Else
            Me.Caption = "XMLSpy Client"
        End If
    End If
End Sub

Private Sub MIExportTo_Click()
    If Not (objSpy.ActiveDocument Is Nothing) Then
        Dim objExport As ExportSettings
        Set objExport = objSpy.GetExportSettings
        Dim dlgExp As DlgExport
        Set dlgExp = New DlgExport
        Set dlgExp.objExpSettings = objExport
        Set dlgExp.objDoc = objSpy.ActiveDocument
        objExport.ExportAllElements = True
        
        dlgExp.Show vbModal
        
        Unload dlgExp
    End If
End Sub

Private Sub MIGenDTD_Click()
    On Error Resume Next
    Dim dlgGen As DlgGenDTD
    Set dlgGen = New DlgGenDTD
    dlgGen.Show vbModal
    
    If dlgGen.bOK And dlgGen.ComboType.ListIndex >= 0 And dlgGen.ComboDetec.ListIndex >= 0 Then
        nType = dlgGen.ComboType.ItemData(dlgGen.ComboType.ListIndex)
        nDetec = dlgGen.ComboDetec.ItemData(dlgGen.ComboDetec.ListIndex)
        objSpy.ActiveDocument.GenerateDTDOrSchema nType, 0, nDetec, spyGlobalComplexType
        CheckForError
    End If
End Sub

Private Sub MIGrid_Click()
    If Not (objSpy Is Nothing) Then
        If Not (objSpy.ActiveDocument Is Nothing) Then
            objSpy.ActiveDocument.SwitchViewMode spyViewGrid
        End If
    End If
    UpdateViewMenu
End Sub

Private Sub MIImpDB_Click()
    Dim dlgImp As DlgImportDB
    Set dlgImp = New DlgImportDB
    dlgImp.Show vbModal
    
    If dlgImp.bOK = True Then
        Dim objImpSettings As DatabaseConnection
        Set objImpSettings = objSpy.GetDatabaseSettings
        
        If dlgImp.OptADO = True Then
            objImpSettings.ADOConnection = dlgImp.TxtADO.Text
        End If
        
        If dlgImp.OptODBC = True Then
            objImpSettings.ODBCConnection = dlgImp.TxtODBC.Text
        End If
        
        If dlgImp.OptAccessFile = True Then
            objImpSettings.File = dlgImp.TxtFile.Text
        End If
        
        objImpSettings.ExcludeKeys = dlgImp.CheckKeys.Value
        objImpSettings.IncludeEmptyElements = dlgImp.CheckEmpty.Value
        
        objImpSettings.SQLSelect = dlgImp.TxtSelect.Text
        
        MousePointer = vbHourglass
        Refresh
        Dim objImpDoc As Document
        On Error Resume Next
        Set objImpDoc = objSpy.ImportFromDatabase(objImpSettings, objSpy.GetDatabaseImportElementList(objImpSettings))
        CheckForError
    End If
End Sub

Private Sub MIImpText_Click()
    Dim objDlg
    Set objDlg = CreateObject("MSComDlg.CommonDialog")
    objDlg.DialogTitle = "Select a text file to import"
    objDlg.ShowOpen
    
    If Len(objDlg.FileName) > 0 Then
        Dim objImpSettings As TextImportExportSettings
        Set objImpSettings = objSpy.GetTextImportExportSettings
        objImpSettings.ImportFile = objDlg.FileName
        objImpSettings.HeaderRow = False
        Dim objImpDoc As Document
        On Error Resume Next
        Set objImpDoc = objSpy.ImportFromText(objImpSettings, objSpy.GetTextImportElementList(objImpSettings))
        CheckForError
    End If
End Sub

Private Sub MIImpWord_Click()
    Dim objDlg
    Set objDlg = CreateObject("MSComDlg.CommonDialog")
    objDlg.DialogTitle = "Select a MSWord file"
    objDlg.ShowOpen
    
    If Len(objDlg.FileName) > 0 Then
        Dim objImpDoc As Document
        On Error Resume Next
        Set objImpDoc = objSpy.ImportFromWord(objDlg.FileName)
        CheckForError
        Set objImpDoc = Nothing
    End If
End Sub

Private Sub MINewProj_Click()
    On Error Resume Next
    objSpy.NewProject "", True
    CheckForError
End Sub

Private Sub MIOpenDoc_Click()
    On Error Resume Next
    Dim objDlg
    Set objDlg = CreateObject("MSComDlg.CommonDialog")
    objDlg.DialogTitle = "Select a file"
    objDlg.ShowOpen
    
    If Len(objDlg.FileName) > 0 Then
        Dim objDoc As Document
        Set objDoc = objSpy.Documents.OpenFile(objDlg.FileName, False)
        CheckForError
        Set objGrid = objDoc.GridView
    End If
    Me.Caption = "XMLSpy Client - " & objSpy.ActiveDocument.GetPathName
    UpdateViewMenu
End Sub

Private Sub MIOpenProj_Click()
    Dim objDlg
    Set objDlg = CreateObject("MSComDlg.CommonDialog")
    'objDlg.DefaultExt = "*.spp"
    'objDlg.Filter = "*.spp"
    'objDlg.FilterIndex = 0
    objDlg.ShowOpen
    
    If Len(objDlg.FileName) > 0 Then
        On Error Resume Next
        objSpy.OpenProject objDlg.FileName, True, False
        CheckForError
    End If
End Sub

Private Sub MIOpenURL_Click()
    If Not (objSpy Is Nothing) Then
        Dim objDoc As Document
        Set objDoc = objSpy.Documents.OpenURLDialog("", spyURLTypeXML, spyReload, "", "")
        Set objDoc = Nothing
    End If
    UpdateViewMenu
End Sub

Private Sub MIPrjSaveAs_Click()
    If Not (objSpy.CurrentProject Is Nothing) Then
        objSpy.CurrentProject.SaveProjectAs "", True
    End If
End Sub

Private Sub MIQuit_Click()
    If Not (objSpy Is Nothing) Then
        objSpy.Quit
        Set objSpy = Nothing
        Unload Me
    End If
End Sub

Private Sub MISave_Click()
    On Error Resume Next
    objSpy.ActiveDocument.Save
    If Err.Number <> 0 Then
        a = MsgBox("Error: " & (Err.Number - vbObjectError) & Chr(13) & "Description: " & Err.Description)
    End If
End Sub

Private Sub MISaveProj_Click()
    On Error Resume Next
    objSpy.CurrentProject.SaveProject
    CheckForError
End Sub

Private Sub MISaveStr_Click()
    Dim strOut As String
    On Error GoTo ErrorHandler
    strOut = objSpy.ActiveDocument.SaveInString(objSpy.ActiveDocument.RootElement, False)
    nRet = MsgBox(strOut, , "XMLSpy Client")
    Exit Sub
    
ErrorHandler:
    a = MsgBox("Error: " & (Err.Number - vbObjectError) & Chr(13) & "Description: " & Err.Description)
End Sub

Private Sub MISchema_Click()
    If Not (objSpy Is Nothing) Then
        If Not (objSpy.ActiveDocument Is Nothing) Then
            objSpy.ActiveDocument.SwitchViewMode spyViewSchema
        End If
    End If
    UpdateViewMenu
End Sub

Private Sub UpdateViewMenu()
    MIGrid.Checked = False
    MIText.Checked = False
    MISchema.Checked = False
    MIBrowser.Checked = False
    MIAuthentic.Checked = False
    
    If Not (objSpy Is Nothing) Then
        If Not (objSpy.ActiveDocument Is Nothing) Then
            Select Case objSpy.ActiveDocument.CurrentViewMode
                Case spyViewText
                    MIText.Checked = True
                Case spyViewGrid
                    MIGrid.Checked = True
                Case spyViewSchema
                    MISchema.Checked = True
                Case spyViewContent
                    MIAuthentic.Checked = True
                Case spyViewBrowser
                    MIBrowser.Checked = True
            End Select
        End If
    End If
End Sub

Private Sub MISetEncoding_Click()
    On Error Resume Next
    Dim dlgStr As DlgInputStr
    Set dlgStr = New DlgInputStr
    dlgStr.Caption = "XMLSpy"
    dlgStr.TxtLabel.Caption = "Name of encoding:"
    dlgStr.Show (vbModal)
    
    If dlgStr.bOK Then
        objSpy.ActiveDocument.SetEncoding (dlgStr.EditString)
        CheckForError
    End If
    Unload dlgStr
End Sub

Private Sub MIShowApp_Click()
    If Not (objSpy Is Nothing) Then
        objSpy.ShowApplication True
    End If
End Sub

Private Sub MIStartSpy_Click()
    Set objSpy = CreateObject("XMLSpy.Application")
End Sub

Private Sub MIStepXML_Click()
    Dim dlgWalk As WalkXMLDlg
    Set dlgWalk = New WalkXMLDlg
    Set dlgWalk.objWalkDoc = objSpy.ActiveDocument
    dlgWalk.Show vbModal
End Sub

Private Sub MIText_Click()
    If Not (objSpy Is Nothing) Then
        If Not (objSpy.ActiveDocument Is Nothing) Then
            objSpy.ActiveDocument.SwitchViewMode spyViewText
        End If
    End If
    UpdateViewMenu
End Sub

Private Sub MITransXSL_Click()
    If Not (objSpy Is Nothing) Then
        If Not (objSpy.ActiveDocument Is Nothing) Then
            On Error Resume Next
            objSpy.ActiveDocument.TransformXSL
            CheckForError
        End If
    End If
End Sub

Private Sub MIValid_Click()
    Dim bValid As Boolean
    Dim strMsg As Variant
    Dim nPos As Variant
    Dim objBadXMLData As Variant
    objSpy.ActiveDocument.UpdateViews
    On Error Resume Next
    bValid = objSpy.ActiveDocument.IsValid(strMsg, nPos, objBadXMLData)
    CheckForError
    If bValid = False Then
        a = MsgBox("The document is not valid:" & Chr(13) & strMsg & Chr(13) & "position: " & nPos & Chr(13) & "XMLData value: " & objBadXMLData.TextValue, , "XMLSpy Client")
    Else
        a = MsgBox("The document is valid" & Chr(13) & strMsg, , "XMLSpy Client")
    End If
    Set objBadXMLData = Nothing
End Sub

Private Sub MIWalkDocs_Click()
    Dim dlgDocs As DlgWalkDocs
    Set dlgDocs = New DlgWalkDocs
    dlgDocs.Show vbModal
    Unload dlgDocs
End Sub

Private Sub MIWalkProjTree_Click()
    If Not (objSpy.CurrentProject Is Nothing) Then
        Dim DlgPrj As DlgWalkPrj
        Set DlgPrj = New DlgWalkPrj
        Set DlgPrj.objPrj = objSpy.CurrentProject
        DlgPrj.Show vbModal
        Set DlgPrj.objPrj = Nothing
    End If
    
    'On Error Resume Next
    'WalkTree objSpy.CurrentProject.RootItems
End Sub

Private Sub MIWellFormed_Click()
    Dim bWell As Boolean
    Dim strMsg As Variant
    Dim nPos As Variant
    Dim objBadXMLData As Variant
    objSpy.ActiveDocument.UpdateViews
    On Error Resume Next
    bWell = objSpy.ActiveDocument.IsWellFormed(objSpy.ActiveDocument.RootElement, True, strMsg, nPos, objBadXMLData)
    CheckForError
    If bWell = False Then
        a = MsgBox("The document is not well formed:" & Chr(13) & strMsg & Chr(13) & "position: " & nPos, , "XMLSpy Client")
    Else
        a = MsgBox("The document is well formed" & Chr(13) & strMsg, , "XMLSpy Client")
    End If
End Sub
