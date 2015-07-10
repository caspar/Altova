VERSION 5.00
Begin VB.Form DlgGenDTD 
   BorderStyle     =   3  'Fixed Dialog
   Caption         =   "Generate DTD/Schema"
   ClientHeight    =   1515
   ClientLeft      =   2760
   ClientTop       =   3750
   ClientWidth     =   4230
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   1515
   ScaleWidth      =   4230
   ShowInTaskbar   =   0   'False
   Begin VB.ComboBox ComboDetec 
      Height          =   315
      ItemData        =   "DlgGenDTD.frx":0000
      Left            =   120
      List            =   "DlgGenDTD.frx":000D
      Style           =   2  'Dropdown List
      TabIndex        =   4
      Top             =   1095
      Width           =   2295
   End
   Begin VB.ComboBox ComboType 
      Height          =   315
      ItemData        =   "DlgGenDTD.frx":003C
      Left            =   120
      List            =   "DlgGenDTD.frx":004F
      Style           =   2  'Dropdown List
      TabIndex        =   2
      Top             =   375
      Width           =   2295
   End
   Begin VB.CommandButton CancelButton 
      Caption         =   "Cancel"
      Height          =   375
      Left            =   2880
      TabIndex        =   1
      Top             =   600
      Width           =   1215
   End
   Begin VB.CommandButton OKButton 
      Caption         =   "OK"
      Height          =   375
      Left            =   2880
      TabIndex        =   0
      Top             =   120
      Width           =   1215
   End
   Begin VB.Label Label2 
      Caption         =   "Type detection:"
      Height          =   255
      Left            =   120
      TabIndex        =   5
      Top             =   840
      Width           =   2295
   End
   Begin VB.Label Label1 
      Caption         =   "Type of DTD/Schema:"
      Height          =   255
      Left            =   120
      TabIndex        =   3
      Top             =   120
      Width           =   2295
   End
End
Attribute VB_Name = "DlgGenDTD"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Public bOK As Boolean
Option Explicit

Private Sub CancelButton_Click()
    Hide
End Sub

Private Sub Form_Initialize()
    bOK = False
End Sub

Private Sub OKButton_Click()
    bOK = True
    Hide
End Sub
