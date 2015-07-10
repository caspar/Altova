VERSION 5.00
Begin VB.Form DlgInputStr 
   BorderStyle     =   3  'Fixed Dialog
   Caption         =   "Dialog Caption"
   ClientHeight    =   1425
   ClientLeft      =   2760
   ClientTop       =   3750
   ClientWidth     =   5400
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   1425
   ScaleWidth      =   5400
   ShowInTaskbar   =   0   'False
   Begin VB.TextBox EditString 
      Height          =   285
      Left            =   135
      TabIndex        =   3
      Text            =   "EditString"
      Top             =   390
      Width           =   5175
   End
   Begin VB.CommandButton CancelButton 
      Caption         =   "Cancel"
      Height          =   375
      Left            =   2640
      TabIndex        =   1
      Top             =   960
      Width           =   1215
   End
   Begin VB.CommandButton OKButton 
      Caption         =   "OK"
      Height          =   375
      Left            =   4080
      TabIndex        =   0
      Top             =   960
      Width           =   1215
   End
   Begin VB.Label TxtLabel 
      Caption         =   "Label"
      Height          =   255
      Left            =   135
      TabIndex        =   2
      Top             =   90
      Width           =   5175
   End
End
Attribute VB_Name = "DlgInputStr"
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
