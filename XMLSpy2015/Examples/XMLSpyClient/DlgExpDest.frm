VERSION 5.00
Begin VB.Form DlgExpDest 
   BorderStyle     =   3  'Fixed Dialog
   Caption         =   "Export destination"
   ClientHeight    =   4605
   ClientLeft      =   4440
   ClientTop       =   2700
   ClientWidth     =   7200
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   4605
   ScaleWidth      =   7200
   ShowInTaskbar   =   0   'False
   Begin VB.OptionButton OptionDB 
      Caption         =   "Do export to database"
      Height          =   255
      Left            =   3360
      TabIndex        =   12
      Top             =   120
      Width           =   3135
   End
   Begin VB.OptionButton OptionText 
      Caption         =   "Do export to text"
      Height          =   255
      Left            =   120
      TabIndex        =   11
      Top             =   120
      Width           =   3015
   End
   Begin VB.Frame Frame2 
      Caption         =   "Export to database settings"
      Height          =   3375
      Left            =   3360
      TabIndex        =   3
      Top             =   480
      Width           =   3735
      Begin VB.CommandButton BtnBuildODBC 
         Caption         =   "Build"
         Height          =   255
         Left            =   2880
         TabIndex        =   24
         Top             =   2400
         Width           =   735
      End
      Begin VB.CommandButton BtnBuildADO 
         Caption         =   "Build"
         Height          =   255
         Left            =   2880
         TabIndex        =   23
         Top             =   1680
         Width           =   735
      End
      Begin VB.TextBox TxtODBC 
         Height          =   285
         Left            =   480
         TabIndex        =   22
         Top             =   2400
         Width           =   2295
      End
      Begin VB.OptionButton OptODBC 
         Caption         =   "Use ODBC connection"
         Height          =   255
         Left            =   240
         TabIndex        =   21
         Top             =   2160
         Width           =   2895
      End
      Begin VB.TextBox TxtADO 
         Height          =   285
         Left            =   480
         TabIndex        =   20
         Top             =   1680
         Width           =   2295
      End
      Begin VB.OptionButton OptADO 
         Caption         =   "Use ADO connection"
         Height          =   255
         Left            =   240
         TabIndex        =   19
         Top             =   1440
         Width           =   2775
      End
      Begin VB.CheckBox CheckTables 
         Caption         =   "Create missing tables (text field length is 255 characters)"
         Height          =   375
         Left            =   240
         TabIndex        =   18
         Top             =   2880
         Width           =   3015
      End
      Begin VB.CommandButton BtnBrowseDB 
         Caption         =   "Browse"
         Height          =   255
         Left            =   2880
         TabIndex        =   17
         Top             =   960
         Width           =   735
      End
      Begin VB.TextBox DBFileEdit 
         Height          =   285
         Left            =   720
         TabIndex        =   15
         Text            =   "file"
         Top             =   960
         Width           =   2055
      End
      Begin VB.OptionButton OptionExistingDB 
         Caption         =   "Use existing MS Access database"
         Height          =   255
         Left            =   240
         TabIndex        =   14
         Top             =   720
         Width           =   3015
      End
      Begin VB.OptionButton OptionNewDB 
         Caption         =   "Create new MS Access database"
         Height          =   255
         Left            =   240
         TabIndex        =   13
         Top             =   360
         Width           =   2775
      End
      Begin VB.Label Label5 
         Caption         =   "File:"
         Height          =   255
         Left            =   300
         TabIndex        =   16
         Top             =   1020
         Width           =   375
      End
   End
   Begin VB.Frame Frame1 
      Caption         =   "Export to text settings"
      Height          =   2055
      Left            =   120
      TabIndex        =   2
      Top             =   480
      Width           =   3015
      Begin VB.CommandButton BtnBrowse 
         Caption         =   "Browse"
         Height          =   255
         Left            =   2160
         TabIndex        =   10
         Top             =   480
         Width           =   735
      End
      Begin VB.TextBox FolderEdit 
         Height          =   285
         Left            =   240
         TabIndex        =   8
         Text            =   "folder"
         Top             =   480
         Width           =   1815
      End
      Begin VB.CheckBox CheckHeader 
         Caption         =   "Create header row"
         Height          =   255
         Left            =   240
         TabIndex        =   4
         Top             =   840
         Width           =   2535
      End
      Begin VB.Label Label4 
         Caption         =   "Destination folder:"
         Height          =   255
         Left            =   240
         TabIndex        =   9
         Top             =   240
         Width           =   1695
      End
      Begin VB.Label Label3 
         Caption         =   "There is no enclosing character"
         Height          =   255
         Left            =   240
         TabIndex        =   7
         Top             =   1200
         Width           =   2535
      End
      Begin VB.Label Label2 
         Caption         =   "Field delimiter is 0x09"
         Height          =   255
         Left            =   240
         TabIndex        =   6
         Top             =   1440
         Width           =   2535
      End
      Begin VB.Label Label1 
         Caption         =   "File extension is .txt"
         Height          =   255
         Left            =   240
         TabIndex        =   5
         Top             =   1680
         Width           =   2535
      End
   End
   Begin VB.CommandButton CancelButton 
      Caption         =   "Cancel"
      Height          =   375
      Left            =   4080
      TabIndex        =   1
      Top             =   4080
      Width           =   1215
   End
   Begin VB.CommandButton OKButton 
      Caption         =   "Export"
      Height          =   375
      Left            =   5760
      TabIndex        =   0
      Top             =   4080
      Width           =   1215
   End
End
Attribute VB_Name = "DlgExpDest"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Public bOK As Boolean
Option Explicit

Private Sub BtnBrowse_Click()
    Dim pos As Long
    Dim objDlg
    Set objDlg = CreateObject("MSComDlg.CommonDialog")
    objDlg.DialogTitle = "Please locate a file in the destination folder"
    objDlg.ShowOpen
    
    If Len(objDlg.FileName) > 0 Then
        pos = InStrRev(objDlg.FileName, "\")
        If pos > 3 Then
            FolderEdit.Text = Left(objDlg.FileName, pos)
        Else
            FolderEdit.Text = objDlg.FileName
        End If
    End If
End Sub

Private Sub BtnBrowseDB_Click()
    Dim pos As Long
    Dim objDlg
    Set objDlg = CreateObject("MSComDlg.CommonDialog")
    objDlg.DialogTitle = "Locate a file in the destination folder"
    If OptionExistingDB.Value = True Then
        objDlg.DialogTitle = "Locate the MS Access file"
    End If
    objDlg.ShowOpen
    
    DBFileEdit.Text = objDlg.FileName
    If OptionNewDB.Value = True Then
        If Len(objDlg.FileName) > 0 Then
            pos = InStrRev(objDlg.FileName, "\")
            If pos > 3 Then
                DBFileEdit.Text = Left(objDlg.FileName, pos)
            End If
        End If
    End If
End Sub

Private Sub BtnBuildADO_Click()
    Dim objADO As DataLinks
    Set objADO = CreateObject("DataLinks")
    If Not (objADO Is Nothing) Then
        Dim objConn As Connection
        Set objConn = objADO.PromptNew
        TxtADO.Text = objConn.ConnectionString
    End If
End Sub

Private Sub BtnBuildODBC_Click()
    Dim objDB As DBEngine
    Set objDB = CreateObject("DAO.DBEngine.36")
    
    If Not (objDB Is Nothing) Then
        Dim objWS As DAO.Workspace
        Set objWS = objDB.CreateWorkspace("", "Build", "", DAO.WorkspaceTypeEnum.dbUseODBC)
        
        Dim objConnection As DAO.Connection
        Dim strName As String
        strName = ""
        
        On Error Resume Next
        Set objConnection = objWS.OpenConnection(strName, dbDriverPrompt)
        
        If Not (objConnection Is Nothing) Then
            TxtODBC = objConnection.Connect
        End If
    End If
End Sub

Private Sub CancelButton_Click()
    Hide
End Sub

Private Sub Form_Activate()
    bOK = False
    OptionText.Value = True
    OptionNewDB.Value = True
End Sub

Private Sub OKButton_Click()
    bOK = True
    Hide
End Sub

Private Sub OptionDB_Click()
    Frame2.Enabled = True
    Frame1.Enabled = False
End Sub

Private Sub OptionText_Click()
    Frame2.Enabled = False
    Frame1.Enabled = True
End Sub
