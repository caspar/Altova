VERSION 5.00
Begin VB.Form WalkXMLDlg 
   BorderStyle     =   3  'Fixed Dialog
   Caption         =   "Walk XML tree"
   ClientHeight    =   5595
   ClientLeft      =   8490
   ClientTop       =   675
   ClientWidth     =   7740
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   5595
   ScaleWidth      =   7740
   ShowInTaskbar   =   0   'False
   Begin VB.CommandButton BtnSetFocus 
      Caption         =   "set focus"
      Height          =   375
      Left            =   3840
      TabIndex        =   27
      Top             =   4200
      Width           =   1095
   End
   Begin VB.CommandButton BtnEnd 
      Caption         =   "end changes"
      Height          =   375
      Left            =   5160
      TabIndex        =   24
      Top             =   720
      Width           =   1095
   End
   Begin VB.CommandButton BtnStart 
      Caption         =   "start changes"
      Height          =   375
      Left            =   5160
      TabIndex        =   23
      Top             =   240
      Width           =   1095
   End
   Begin VB.CommandButton BtnEraseAll 
      Caption         =   "erase all"
      Height          =   375
      Left            =   5160
      TabIndex        =   13
      Top             =   2880
      Width           =   1095
   End
   Begin VB.CommandButton BtnErase 
      Caption         =   "erase current"
      Height          =   375
      Left            =   5160
      TabIndex        =   12
      Top             =   2400
      Width           =   1095
   End
   Begin VB.CommandButton BtnAppend 
      Caption         =   "append child"
      Height          =   375
      Left            =   3840
      TabIndex        =   11
      Top             =   2880
      Width           =   1095
   End
   Begin VB.CommandButton BtnInsert 
      Caption         =   "insert child"
      Height          =   375
      Left            =   3840
      TabIndex        =   10
      Top             =   2400
      Width           =   1095
   End
   Begin VB.TextBox EditKindChild 
      Enabled         =   0   'False
      Height          =   285
      Left            =   1050
      Locked          =   -1  'True
      TabIndex        =   4
      Text            =   "Text1"
      Top             =   2040
      Width           =   2295
   End
   Begin VB.TextBox EditNameChild 
      Height          =   285
      Left            =   1050
      TabIndex        =   5
      Text            =   "Text1"
      Top             =   2400
      Width           =   2295
   End
   Begin VB.TextBox EditValueChild 
      Height          =   285
      Left            =   1050
      TabIndex        =   6
      Text            =   "Text1"
      Top             =   2760
      Width           =   2295
   End
   Begin VB.CommandButton BtnParent 
      Caption         =   "go to parent"
      Height          =   375
      Left            =   3840
      TabIndex        =   9
      Top             =   1680
      Width           =   1095
   End
   Begin VB.CommandButton BtnStepDown 
      Caption         =   "step down"
      Height          =   375
      Left            =   3840
      TabIndex        =   8
      Top             =   1200
      Width           =   1095
   End
   Begin VB.CommandButton BtnNextChild 
      Caption         =   "next child"
      Height          =   375
      Left            =   3840
      TabIndex        =   7
      Top             =   240
      Width           =   1095
   End
   Begin VB.TextBox EditValue 
      Height          =   285
      Left            =   1050
      Locked          =   -1  'True
      TabIndex        =   3
      Text            =   "Text1"
      Top             =   1335
      Width           =   2295
   End
   Begin VB.TextBox EditName 
      Height          =   285
      Left            =   1050
      Locked          =   -1  'True
      TabIndex        =   2
      Text            =   "Text1"
      Top             =   975
      Width           =   2295
   End
   Begin VB.TextBox EditKind 
      Enabled         =   0   'False
      Height          =   285
      Left            =   1050
      Locked          =   -1  'True
      TabIndex        =   1
      Text            =   "Text1"
      Top             =   615
      Width           =   2295
   End
   Begin VB.CommandButton OKButton 
      Caption         =   "OK"
      Height          =   375
      Left            =   6480
      TabIndex        =   0
      Top             =   5040
      Width           =   1095
   End
   Begin VB.Frame Frame1 
      Caption         =   "XMLData"
      Height          =   4425
      Left            =   120
      TabIndex        =   14
      Top             =   135
      Width           =   3435
      Begin VB.TextBox EditFocusValue 
         Height          =   285
         Left            =   960
         TabIndex        =   30
         Text            =   "Text3"
         Top             =   3960
         Width           =   2295
      End
      Begin VB.TextBox EditFocusName 
         Height          =   285
         Left            =   960
         Locked          =   -1  'True
         TabIndex        =   29
         Text            =   "Text2"
         Top             =   3600
         Width           =   2295
      End
      Begin VB.TextBox EditFocusKind 
         Enabled         =   0   'False
         Height          =   285
         Left            =   960
         TabIndex        =   28
         Text            =   "Text1"
         Top             =   3240
         Width           =   2295
      End
      Begin VB.Label Label12 
         Caption         =   "current focus in grid"
         BeginProperty Font 
            Name            =   "MS Sans Serif"
            Size            =   8.25
            Charset         =   0
            Weight          =   700
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Left            =   180
         TabIndex        =   34
         Top             =   2985
         Width           =   1815
      End
      Begin VB.Label Label11 
         Caption         =   "Value:"
         Height          =   255
         Left            =   180
         TabIndex        =   33
         Top             =   3960
         Width           =   720
      End
      Begin VB.Label Label10 
         Caption         =   "Name:"
         Height          =   255
         Left            =   180
         TabIndex        =   32
         Top             =   3600
         Width           =   720
      End
      Begin VB.Label Label9 
         Caption         =   "Kind:"
         Height          =   255
         Left            =   180
         TabIndex        =   31
         Top             =   3255
         Width           =   720
      End
      Begin VB.Label TxtMayChildren 
         Caption         =   "children"
         Height          =   240
         Left            =   1335
         TabIndex        =   26
         Top             =   1620
         Width           =   1755
      End
      Begin VB.Label Label8 
         Caption         =   "current child"
         BeginProperty Font 
            Name            =   "MS Sans Serif"
            Size            =   8.25
            Charset         =   0
            Weight          =   700
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Left            =   165
         TabIndex        =   22
         Top             =   1620
         Width           =   1455
      End
      Begin VB.Label Label7 
         Caption         =   "Kind:"
         Height          =   255
         Left            =   165
         TabIndex        =   21
         Top             =   1935
         Width           =   720
      End
      Begin VB.Label Label6 
         Caption         =   "Name:"
         Height          =   255
         Left            =   165
         TabIndex        =   20
         Top             =   2280
         Width           =   720
      End
      Begin VB.Label Label5 
         Caption         =   "Value:"
         Height          =   255
         Left            =   165
         TabIndex        =   19
         Top             =   2640
         Width           =   720
      End
      Begin VB.Label Label4 
         Caption         =   "parent"
         BeginProperty Font 
            Name            =   "MS Sans Serif"
            Size            =   8.25
            Charset         =   0
            Weight          =   700
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   255
         Left            =   195
         TabIndex        =   18
         Top             =   225
         Width           =   735
      End
      Begin VB.Label Label3 
         Caption         =   "Value:"
         Height          =   255
         Left            =   195
         TabIndex        =   17
         Top             =   1245
         Width           =   720
      End
      Begin VB.Label Label2 
         Caption         =   "Name:"
         Height          =   255
         Left            =   195
         TabIndex        =   16
         Top             =   885
         Width           =   720
      End
      Begin VB.Label Label1 
         Caption         =   "Kind:"
         Height          =   255
         Left            =   195
         TabIndex        =   15
         Top             =   510
         Width           =   720
      End
   End
   Begin VB.Label TxtUpdate 
      Caption         =   "updates"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H000000FF&
      Height          =   375
      Left            =   6480
      TabIndex        =   25
      Top             =   240
      Width           =   975
   End
   Begin VB.Line Line1 
      X1              =   120
      X2              =   7680
      Y1              =   4800
      Y2              =   4800
   End
End
Attribute VB_Name = "WalkXMLDlg"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Public objWalkDoc As Document
Dim objCurrentParent As XMLData
Dim objCurrentChild As XMLData
Dim nRet As Integer
Dim WithEvents objGrid As GridView
Attribute objGrid.VB_VarHelpID = -1
Option Explicit


Private Sub BtnAppend_Click()
    On Error Resume Next
    Dim objNewChild As XMLData
    Set objNewChild = objWalkDoc.CreateChild(spyXMLDataElement)
    objCurrentParent.AppendChild objNewChild
    CheckForError
    Set objNewChild = Nothing
End Sub

Private Sub BtnEnd_Click()
    objWalkDoc.EndChanges
    TxtUpdate.Caption = "updates"
End Sub

Private Sub BtnErase_Click()
    'EraseCurrentChild steps to next child
    'nRet = objWalkDoc.GridView.Deselect(objCurrentChild)
    On Error Resume Next
    objCurrentParent.EraseCurrentChild
    CheckForError
    objCurrentChild = objCurrentParent.GetCurrentChild
    CheckForError
End Sub

Private Sub BtnEraseAll_Click()
    'erase all children
    On Error Resume Next
    
    If objWalkDoc.CurrentViewMode = spyViewGrid Then
        objWalkDoc.GridView.Deselect objCurrentChild
        CheckForError
    End If
    
    objCurrentParent.EraseAllChildren
    CheckForError
    'set new parent and child
    Set objCurrentParent = objCurrentParent.Parent
    On Error GoTo ErrorHandler
    Set objCurrentChild = objCurrentParent.GetFirstChild(-1)
    UpdateEdits
    EnableBtnStepDown
    
    If objWalkDoc.CurrentViewMode = spyViewGrid Then
        objWalkDoc.GridView.Select objCurrentChild
    End If
    
    Exit Sub
    
ErrorHandler:
    Set objCurrentParent = objWalkDoc.RootElement
    Set objCurrentChild = objCurrentParent.GetFirstChild(-1)
    UpdateEdits
    EnableBtnStepDown
End Sub

Private Sub BtnInsert_Click()
    Dim objNewChild As XMLData
    Set objNewChild = objWalkDoc.CreateChild(spyXMLDataElement)
    On Error Resume Next
    objCurrentParent.InsertChild objNewChild
    CheckForError
    Set objNewChild = Nothing
End Sub

Private Sub BtnNextChild_Click()
    On Error GoTo ErrorHandler
    
    If objWalkDoc.CurrentViewMode = spyViewGrid Then
        objWalkDoc.GridView.Deselect objCurrentChild
    End If
    
    Set objCurrentChild = objCurrentParent.GetNextChild
    UpdateEdits
    
    If objWalkDoc.CurrentViewMode = spyViewGrid Then
        objWalkDoc.GridView.Select objCurrentChild
    End If
    
    EnableBtnStepDown
    Exit Sub
    
ErrorHandler:
    CheckForError
End Sub

Private Sub BtnParent_Click()
    Set objCurrentParent = objCurrentParent.Parent
    On Error GoTo ErrorHandler
    
    If objWalkDoc.CurrentViewMode = spyViewGrid Then
        objWalkDoc.GridView.Deselect objCurrentChild
    End If
    
    Set objCurrentChild = objCurrentParent.GetFirstChild(-1)
    UpdateEdits
    EnableBtnStepDown
    
    If objWalkDoc.CurrentViewMode = spyViewGrid Then
        objWalkDoc.GridView.Select objCurrentChild
    End If
    
    Exit Sub
    
ErrorHandler:
    CheckForError
    Set objCurrentParent = objWalkDoc.RootElement
    Set objCurrentChild = objCurrentParent.GetFirstChild(-1)
    UpdateEdits
    EnableBtnStepDown
End Sub

Private Sub BtnSetFocus_Click()
    objWalkDoc.GridView.SetFocus objCurrentChild
    UpdateEdits
End Sub

Private Sub BtnStart_Click()
    objWalkDoc.StartChanges
    TxtUpdate.Caption = "no" & Chr(13) & "updates"
End Sub

Private Sub BtnStepDown_Click()
    If objCurrentChild.HasChildren Then
        objWalkDoc.GridView.Deselect objCurrentChild
        Set objCurrentParent = objCurrentChild
        Set objCurrentChild = objCurrentParent.GetFirstChild(-1)
        UpdateEdits
        objWalkDoc.GridView.Select objCurrentChild
    End If
    EnableBtnStepDown
End Sub

Private Sub EditNameChild_Change()
    On Error Resume Next
    objCurrentChild.Name = EditNameChild.Text
    objWalkDoc.UpdateViews
End Sub

Private Sub EditValueChild_Change()
    On Error Resume Next
    objCurrentChild.TextValue = EditValueChild.Text
    objWalkDoc.UpdateViews
End Sub

Private Sub Form_Activate()
    On Error GoTo ErrorHandler
    Set objCurrentParent = objWalkDoc.RootElement
    Set objCurrentChild = objCurrentParent.GetFirstChild(-1)
    UpdateEdits
    EnableBtnStepDown
    
    If objWalkDoc.CurrentViewMode = spyViewGrid Then
        objWalkDoc.GridView.Select objCurrentChild
        Set objGrid = objWalkDoc.GridView
    Else
        BtnSetFocus.Enabled = False
    End If
    
    Exit Sub

ErrorHandler:
    Dim a As Integer
    a = MsgBox("Error on opening the XMLData dialog. Maybe there is no document open!")
    Unload Me
End Sub

Private Sub EnableBtnStepDown()
    BtnStepDown.Enabled = False
    On Error GoTo ErrorHandler
    If objCurrentChild.HasChildren Then
        BtnStepDown.Enabled = True
    End If
    Exit Sub
    
ErrorHandler:
End Sub

Private Sub UpdateEdits()
    On Error GoTo ErrorHandler
    EditKindChild.Text = GetNameOfKind(objCurrentChild.Kind)
    EditNameChild.Text = objCurrentChild.Name
    EditValueChild.Text = objCurrentChild.TextValue
    
    EditKind.Text = GetNameOfKind(objCurrentParent.Kind)
    EditName.Text = objCurrentParent.Name
    EditValue.Text = objCurrentParent.TextValue
    
    EditFocusKind.Text = GetNameOfKind(objWalkDoc.GridView.CurrentFocus.Kind)
    
    If objWalkDoc.CurrentViewMode = spyViewGrid Then
        EditFocusName.Text = objWalkDoc.GridView.CurrentFocus.Name
        EditFocusValue.Text = objWalkDoc.GridView.CurrentFocus.TextValue
    End If
    
    TxtMayChildren.Caption = "may have children"
    If (objCurrentChild.MayHaveChildren = False) Then
        TxtMayChildren.Caption = "can't have children"
    End If
    Exit Sub
    
ErrorHandler:
End Sub


Private Sub objGrid_OnFocusChanged(ByVal pXMLData As XMLData, ByVal bFocusSet As Boolean, ByVal bName As Boolean)
    If bFocusSet Then
        UpdateEdits
    End If
End Sub

Private Sub OKButton_Click()
    Unload Me
End Sub
