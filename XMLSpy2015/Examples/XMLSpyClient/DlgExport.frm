VERSION 5.00
Begin VB.Form DlgExport 
   BorderStyle     =   3  'Fixed Dialog
   Caption         =   "Export settings"
   ClientHeight    =   6000
   ClientLeft      =   2760
   ClientTop       =   3750
   ClientWidth     =   6480
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   6000
   ScaleWidth      =   6480
   ShowInTaskbar   =   0   'False
   Begin VB.Frame Frame4 
      Caption         =   "Namespace options"
      Height          =   615
      Left            =   120
      TabIndex        =   20
      Top             =   2400
      Width           =   6255
      Begin VB.OptionButton OptReplaceColon 
         Caption         =   "Replace colons with underscores"
         Height          =   255
         Left            =   3240
         TabIndex        =   22
         Top             =   240
         Width           =   2775
      End
      Begin VB.OptionButton OptNoNS 
         Caption         =   "No Namespaces"
         Height          =   255
         Left            =   240
         TabIndex        =   21
         Top             =   240
         Width           =   2655
      End
   End
   Begin VB.CommandButton BtnRemove 
      Caption         =   "Remove element"
      Height          =   255
      Left            =   120
      TabIndex        =   19
      Top             =   5400
      Width           =   1455
   End
   Begin VB.Frame Frame3 
      Caption         =   "Automatic fields"
      Height          =   1095
      Left            =   3240
      TabIndex        =   13
      Top             =   1200
      Width           =   3135
      Begin VB.CheckBox CheckIndep 
         Caption         =   "Independent primary key counter for every element"
         Height          =   375
         Left            =   240
         TabIndex        =   15
         Top             =   600
         Width           =   2655
      End
      Begin VB.CheckBox CheckPrimary 
         Caption         =   "Create primary/foreign keys"
         Height          =   255
         Left            =   240
         TabIndex        =   14
         Top             =   240
         Width           =   2655
      End
   End
   Begin VB.Frame Frame2 
      Caption         =   "Export fields"
      Height          =   2175
      Left            =   120
      TabIndex        =   8
      Top             =   120
      Width           =   3015
      Begin VB.CheckBox CheckEnt2Text 
         Caption         =   "Convert entities to text"
         Height          =   255
         Left            =   240
         TabIndex        =   12
         Top             =   1320
         Width           =   2655
      End
      Begin VB.CheckBox CheckText 
         Caption         =   "Create from text values"
         Height          =   255
         Left            =   240
         TabIndex        =   11
         Top             =   960
         Width           =   2655
      End
      Begin VB.CheckBox CheckSingle 
         Caption         =   "Create from single sub-elements"
         Height          =   255
         Left            =   240
         TabIndex        =   10
         Top             =   600
         Width           =   2535
      End
      Begin VB.CheckBox CheckAttr 
         Caption         =   "Create from attributes"
         Height          =   255
         Left            =   240
         TabIndex        =   9
         Top             =   240
         Width           =   2055
      End
   End
   Begin VB.Frame Frame1 
      Caption         =   "Export depth"
      Height          =   975
      Left            =   3240
      TabIndex        =   3
      Top             =   120
      Width           =   3135
      Begin VB.TextBox EditSubLevels 
         Height          =   285
         Left            =   1320
         TabIndex        =   6
         Text            =   "1"
         Top             =   570
         Width           =   495
      End
      Begin VB.OptionButton CheckNSubs 
         Caption         =   "Limited to"
         Height          =   255
         Left            =   240
         TabIndex        =   5
         Top             =   600
         Width           =   1095
      End
      Begin VB.OptionButton CheckAllSub 
         Caption         =   "Export all sub-levels"
         Height          =   255
         Left            =   240
         TabIndex        =   4
         Top             =   240
         Width           =   1935
      End
      Begin VB.Label Label1 
         Caption         =   "sub-levels"
         Height          =   255
         Left            =   1920
         TabIndex        =   7
         Top             =   600
         Width           =   975
      End
   End
   Begin VB.ListBox ElementList 
      BeginProperty Font 
         Name            =   "Courier"
         Size            =   9.75
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   2010
      Left            =   120
      TabIndex        =   2
      Top             =   3360
      Width           =   6255
   End
   Begin VB.CommandButton CancelButton 
      Caption         =   "Cancel"
      Height          =   375
      Left            =   3600
      TabIndex        =   1
      Top             =   5520
      Width           =   1215
   End
   Begin VB.CommandButton OKButton 
      Caption         =   "Continue"
      Height          =   375
      Left            =   5160
      TabIndex        =   0
      Top             =   5520
      Width           =   1215
   End
   Begin VB.Label Label4 
      Caption         =   "Field count"
      Height          =   255
      Left            =   4800
      TabIndex        =   18
      Top             =   3120
      Width           =   1335
   End
   Begin VB.Label Label3 
      Caption         =   "Record count"
      Height          =   255
      Left            =   3360
      TabIndex        =   17
      Top             =   3120
      Width           =   1215
   End
   Begin VB.Label Label2 
      Caption         =   "Element name"
      Height          =   255
      Left            =   120
      TabIndex        =   16
      Top             =   3120
      Width           =   2895
   End
End
Attribute VB_Name = "DlgExport"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Public bOK As Boolean
Private bRefresh As Boolean
Private a As Integer
Private objList As ElementList
Public objExpSettings As ExportSettings
Public objDoc As Document
Option Explicit

Private Sub BtnRemove_Click()
    If ElementList.ListIndex >= 0 Then
        objList.RemoveElement ElementList.ListIndex
        ElementList.RemoveItem ElementList.ListIndex
        ElementList.Refresh
    End If
End Sub

Private Sub CancelButton_Click()
    Hide
End Sub

Private Sub CheckAllSub_Click()
    objExpSettings.ExportAllElements = CheckAllSub.Value
    UpdateControls
End Sub

Private Sub CheckAttr_Click()
    objExpSettings.FromAttributes = CheckAttr.Value
    UpdateControls
End Sub

Private Sub CheckEnt2Text_Click()
    objExpSettings.EntitiesToText = CheckEnt2Text.Value
    UpdateControls
End Sub

Private Sub CheckIndep_Click()
    objExpSettings.IndependentPrimaryKey = CheckIndep.Value
    UpdateControls
End Sub

Private Sub CheckNSubs_Click()
    objExpSettings.ExportAllElements = CheckAllSub.Value
    objExpSettings.SubLevelLimit = CInt(Val(EditSubLevels.Text)) + 1
    UpdateControls
End Sub

Private Sub CheckPrimary_Click()
    CheckIndep.Enabled = True
    If CheckPrimary.Value = 0 Then
        CheckIndep.Enabled = False
    End If
    CheckIndep.Refresh
    objExpSettings.CreateKeys = CheckPrimary.Value
    UpdateControls
End Sub

Private Sub CheckSingle_Click()
    objExpSettings.FromSingleSubElements = CheckSingle.Value
    UpdateControls
End Sub

Private Sub CheckText_Click()
    objExpSettings.FromTextValues = CheckText.Value
    UpdateControls
End Sub

Private Sub EditSubLevels_LostFocus()
    objExpSettings.SubLevelLimit = CInt(Val(EditSubLevels.Text)) + 1
    UpdateControls
End Sub

Private Sub Form_Activate()
    bRefresh = False
    CheckAllSub.Value = True
    If objExpSettings.FromAttributes Then
        CheckAttr.Value = 1
    End If
    If objExpSettings.FromSingleSubElements Then
        CheckSingle.Value = 1
    End If
    If objExpSettings.FromTextValues Then
        CheckText.Value = 1
    End If
    If objExpSettings.EntitiesToText Then
        CheckEnt2Text.Value = 1
    End If
    If objExpSettings.CreateKeys Then
        CheckPrimary.Value = 1
    End If
    If objExpSettings.IndependentPrimaryKey Then
        CheckIndep.Value = 1
    End If
    
    If objExpSettings.ExportAllElements = False Then
        CheckAllSub.Value = False
        CheckNSubs.Value = True
    End If
    
    bOK = False
    bRefresh = True
    UpdateControls
End Sub

Private Sub OKButton_Click()
    bOK = True
    Hide
    
    If OptNoNS.Value = True Then
        objExpSettings.Namespace = spyNoNamespace
    Else
        objExpSettings.Namespace = spyReplaceColonWithUnderscore
    End If
    
    Dim dlgDest As DlgExpDest
    Set dlgDest = New DlgExpDest
    dlgDest.Show vbModal
    
    If dlgDest.bOK Then
        Dim objDB As DatabaseConnection
        Set objDB = objSpy.GetDatabaseSettings
        
        ClientWnd.MousePointer = vbHourglass
        On Error Resume Next
        objExpSettings.ElementList = objList
        If dlgDest.OptionText Then
            Dim objTextExp As XMLSpyLib.TextImportExportSettings
            Set objTextExp = objSpy.GetTextImportExportSettings
            objTextExp.HeaderRow = dlgDest.CheckHeader
            objTextExp.DestinationFolder = dlgDest.FolderEdit.Text
            objDoc.ExportToText objDoc.RootElement, objExpSettings, objTextExp
            If Err.Number <> 0 Then
                a = MsgBox("Error: " & (Err.Number - vbObjectError) & Chr(13) & "Description: " & Err.Description)
            End If
        End If
        
        If dlgDest.OptionExistingDB Or dlgDest.OptionNewDB Then
            objDB.CreateMissingTables = dlgDest.CheckTables.Value
            objDB.CreateNew = dlgDest.OptionNewDB.Value
            objDB.File = dlgDest.DBFileEdit
            objDoc.ExportToDatabase objDoc.RootElement, objExpSettings, objDB
            If Err.Number <> 0 Then
                a = MsgBox("Error: " & (Err.Number - vbObjectError) & Chr(13) & "Description: " & Err.Description)
            End If
        End If
        
        If dlgDest.OptADO Then
            objDB.CreateMissingTables = dlgDest.CheckTables.Value
            objDB.ADOConnection = dlgDest.TxtADO
            objDoc.ExportToDatabase objDoc.RootElement, objExpSettings, objDB
            If Err.Number <> 0 Then
                a = MsgBox("Error: " & (Err.Number - vbObjectError) & Chr(13) & "Description: " & Err.Description)
            End If
        End If
        
        If dlgDest.OptODBC Then
            objDB.CreateMissingTables = dlgDest.CheckTables.Value
            objDB.ODBCConnection = dlgDest.TxtODBC
            objDoc.ExportToDatabase objDoc.RootElement, objExpSettings, objDB
            If Err.Number <> 0 Then
                a = MsgBox("Error: " & (Err.Number - vbObjectError) & Chr(13) & "Description: " & Err.Description)
            End If
       End If
        
        ClientWnd.MousePointer = 0
    End If
    
    Unload dlgDest
End Sub

Private Sub UpdateControls()
    If bRefresh Then
        ElementList.Clear
        Dim objItem As ElementListItem
        Set objList = objDoc.GetExportElementList(objDoc.RootElement, objExpSettings)
        For Each objItem In objList
            Dim strTabs As String
            strTabs = String(32 - Len(objItem.Name), " ")
            ElementList.AddItem objItem.Name & strTabs & objItem.RecordCount & Chr(9) & objItem.FieldCount
        Next
        ElementList.Refresh
    End If
End Sub
