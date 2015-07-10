VERSION 5.00
Begin VB.Form ModXMLDataDlg 
   BorderStyle     =   3  'Fixed Dialog
   Caption         =   "Modify XMLData"
   ClientHeight    =   1380
   ClientLeft      =   2760
   ClientTop       =   3750
   ClientWidth     =   5415
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   1380
   ScaleWidth      =   5415
   ShowInTaskbar   =   0   'False
   Begin VB.TextBox KindEdit 
      Enabled         =   0   'False
      Height          =   285
      Left            =   840
      Locked          =   -1  'True
      TabIndex        =   7
      Text            =   "<kind>"
      Top             =   240
      Width           =   2895
   End
   Begin VB.TextBox ValueEdit 
      Height          =   285
      Left            =   840
      TabIndex        =   6
      Text            =   "<value>"
      Top             =   960
      Width           =   2895
   End
   Begin VB.TextBox NameEdit 
      Height          =   285
      Left            =   840
      TabIndex        =   3
      Text            =   "<name>"
      Top             =   600
      Width           =   2895
   End
   Begin VB.CommandButton CancelButton 
      Caption         =   "Cancel"
      Height          =   375
      Left            =   4080
      TabIndex        =   1
      Top             =   600
      Width           =   1215
   End
   Begin VB.CommandButton OKButton 
      Caption         =   "OK"
      Height          =   375
      Left            =   4080
      TabIndex        =   0
      Top             =   120
      Width           =   1215
   End
   Begin VB.Label Label3 
      Caption         =   "Value"
      Height          =   255
      Left            =   120
      TabIndex        =   5
      Top             =   1080
      Width           =   615
   End
   Begin VB.Label Label2 
      Caption         =   "Name"
      Height          =   255
      Left            =   120
      TabIndex        =   4
      Top             =   720
      Width           =   615
   End
   Begin VB.Label Label1 
      Caption         =   "Kind:"
      Height          =   255
      Left            =   120
      TabIndex        =   2
      Top             =   360
      Width           =   615
   End
End
Attribute VB_Name = "ModXMLDataDlg"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Public bOK As Boolean
Public nKind As SPYXMLDataKind
Option Explicit

Private Sub CancelButton_Click()
    Hide
End Sub

Private Sub Form_Activate()
Select Case nKind
    Case spyXMLDataComment
        KindEdit.Text = "comment"
    Case spyXMLDataElement
        KindEdit.Text = "element"
End Select
End Sub

Private Sub OKButton_Click()
    bOK = True
    Hide
End Sub
