VERSION 5.00
Begin VB.Form DlgWalkDocs 
   BorderStyle     =   3  'Fixed Dialog
   Caption         =   "List of open documents"
   ClientHeight    =   3030
   ClientLeft      =   2760
   ClientTop       =   3750
   ClientWidth     =   5025
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   3030
   ScaleWidth      =   5025
   ShowInTaskbar   =   0   'False
   Begin VB.CommandButton BtnCloseDoc 
      Caption         =   "Close document"
      Height          =   375
      Left            =   3600
      TabIndex        =   4
      Top             =   840
      Width           =   1335
   End
   Begin VB.CommandButton BtnSetActive 
      Caption         =   "Set as Active"
      Height          =   375
      Left            =   3600
      TabIndex        =   3
      Top             =   360
      Width           =   1335
   End
   Begin VB.ListBox ListDocs 
      Height          =   2595
      Left            =   120
      TabIndex        =   1
      Top             =   360
      Width           =   3255
   End
   Begin VB.CommandButton OKButton 
      Caption         =   "Close"
      Height          =   375
      Left            =   3600
      TabIndex        =   0
      Top             =   2520
      Width           =   1335
   End
   Begin VB.Label Label1 
      Caption         =   "Documents:"
      Height          =   255
      Left            =   120
      TabIndex        =   2
      Top             =   120
      Width           =   3255
   End
End
Attribute VB_Name = "DlgWalkDocs"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Option Explicit

Private Sub BtnCloseDoc_Click()
    Dim objDoc As Document
    Set objDoc = FindSelectedDoc
    
    If Not (objDoc Is Nothing) Then
        objDoc.Close True
        SetListBox
    End If
End Sub

Private Sub BtnSetActive_Click()
    Dim objDoc As Document
    Set objDoc = FindSelectedDoc
    
    If Not (objDoc Is Nothing) Then
        objDoc.SetActiveDocument
    End If
End Sub

Private Sub Form_Activate()
    SetListBox
End Sub

Private Sub ListDocs_Click()
    EnDisBtns
End Sub

Private Sub OKButton_Click()
    Hide
End Sub

Private Sub SetListBox()
    ListDocs.Clear
    
    If Not (objSpy Is Nothing) Then
        Dim objDocs As Documents
        Dim objDoc As Document
        
        Set objDocs = objSpy.Documents
        
        For Each objDoc In objDocs
            ListDocs.AddItem objDoc.Title
        Next
    End If
    
    EnDisBtns
End Sub

Private Sub EnDisBtns()
    If ListDocs.ListIndex < 0 Then
        BtnCloseDoc.Enabled = False
        BtnSetActive.Enabled = False
    Else
        BtnCloseDoc.Enabled = True
        BtnSetActive.Enabled = True
    End If
End Sub

Private Function FindSelectedDoc() As Document
    Dim objDocs As Documents
    Dim objDoc As Document
    
    Set objDocs = objSpy.Documents
    
    For Each objDoc In objDocs
        If objDoc.Title = ListDocs.List(ListDocs.ListIndex) Then
            Set FindSelectedDoc = objDoc
            Exit Function
        End If
    Next
    Set FindSelectedDoc = Nothing
End Function
