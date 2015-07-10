VERSION 5.00
Begin VB.Form DlgWalkPrj 
   BorderStyle     =   3  'Fixed Dialog
   Caption         =   "Show Project Tree"
   ClientHeight    =   4125
   ClientLeft      =   2760
   ClientTop       =   3750
   ClientWidth     =   7920
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   4125
   ScaleWidth      =   7920
   ShowInTaskbar   =   0   'False
   Begin VB.CommandButton BtnRemove 
      Caption         =   "Remove item"
      Height          =   375
      Left            =   6600
      TabIndex        =   6
      Top             =   1920
      Width           =   1215
   End
   Begin VB.CommandButton BtnOpen 
      Caption         =   "Open item"
      Height          =   375
      Left            =   6600
      TabIndex        =   5
      Top             =   1440
      Width           =   1215
   End
   Begin VB.CommandButton BtnStepUp 
      Caption         =   "Step up"
      Height          =   375
      Left            =   6600
      TabIndex        =   4
      Top             =   840
      Width           =   1215
   End
   Begin VB.CommandButton BtnStepDown 
      Caption         =   "Step down"
      Height          =   375
      Left            =   6600
      TabIndex        =   3
      Top             =   360
      Width           =   1215
   End
   Begin VB.ListBox ListItems 
      BeginProperty Font 
         Name            =   "Courier New"
         Size            =   9
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   3660
      Left            =   120
      TabIndex        =   1
      Top             =   360
      Width           =   6255
   End
   Begin VB.CommandButton CancelButton 
      Caption         =   "Close"
      Height          =   375
      Left            =   6600
      TabIndex        =   0
      Top             =   3600
      Width           =   1215
   End
   Begin VB.Line Line1 
      X1              =   6600
      X2              =   7800
      Y1              =   1320
      Y2              =   1320
   End
   Begin VB.Label Label1 
      Caption         =   "Items of current project level:"
      Height          =   255
      Left            =   120
      TabIndex        =   2
      Top             =   120
      Width           =   4095
   End
End
Attribute VB_Name = "DlgWalkPrj"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Public objPrj As SpyProject
Private objPrjItems As SpyProjectItems
Option Explicit

Private Sub BtnOpen_Click()
    On Error Resume Next
    If ListItems.ListIndex >= 0 Then
        objPrjItems.Item(ListItems.ListIndex + 1).Open
        CheckForError
    End If
End Sub

Private Sub BtnRemove_Click()
    On Error Resume Next
    If ListItems.ListIndex >= 0 Then
        objPrjItems.RemoveItem objPrjItems.Item(ListItems.ListIndex + 1)
        CheckForError
        SetListItems
    End If
End Sub

Private Sub BtnStepDown_Click()
    If ListItems.ListIndex >= 0 Then
        Dim objTmpItem As SpyProjectItem
        Set objTmpItem = objPrjItems.Item(ListItems.ListIndex + 1)
        
        If objTmpItem.ItemType = spyFolderItem Then
            Set objPrjItems = objTmpItem.ChildItems
            SetListItems
        End If
    End If
End Sub

Private Sub BtnStepUp_Click()
    On Error Resume Next
    If ListItems.ListCount > 0 Then
        Dim objTmpItem As SpyProjectItem
        Set objTmpItem = objPrjItems.Item(0).ParentItem
        
        If Not (objTmpItem Is Nothing) Then
            Set objPrjItems = objTmpItem.ChildItems
            SetListItems
            Set objTmpItem = Nothing
        End If
    End If
End Sub

Private Sub CancelButton_Click()
    Hide
End Sub

Private Sub SetListItems()
    ListItems.Clear
    
    If Not (objPrjItems Is Nothing) Then
        Dim objPrjItem As SpyProjectItem
        
        For Each objPrjItem In objPrjItems
            Dim strLine As String
            strLine = objPrjItem.Name & String(48 - Len(objPrjItem.Name), " ")

            Select Case objPrjItem.ItemType
                Case spyFolderItem
                    strLine = strLine & " Folder"
                Case spyFileItem
                    strLine = strLine & " File"
                Case spyUnknownItem
                    strLine = strLine & " Unknown"
                Case spyURLItem
                    strLine = strLine & " URL"
            End Select
            
            ListItems.AddItem strLine
        Next
    End If
    EnDisBtns
End Sub

Private Sub EnDisBtns()
    If ListItems.ListIndex < 0 Then
        BtnStepDown.Enabled = False
        BtnOpen.Enabled = False
        BtnRemove.Enabled = False
    Else
        BtnStepDown.Enabled = True
        BtnOpen.Enabled = True
        BtnRemove.Enabled = True
    End If
    BtnStepUp.Enabled = False
    If ListItems.ListCount > 0 Then
        On Error Resume Next
        If Not (objPrjItems.Item(0).ParentItem Is Nothing) Then
            BtnStepUp.Enabled = True
        End If
    End If
End Sub

Private Sub Form_Activate()
    If Not (objPrj Is Nothing) Then
        Set objPrjItems = objPrj.RootItems
    End If
    
    SetListItems
End Sub

Private Sub ListItems_Click()
    EnDisBtns
End Sub
