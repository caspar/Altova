VERSION 5.00
Begin VB.Form DlgImportDB 
   BorderStyle     =   3  'Fixed Dialog
   Caption         =   "Import from database"
   ClientHeight    =   4650
   ClientLeft      =   2760
   ClientTop       =   3750
   ClientWidth     =   6030
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   4650
   ScaleWidth      =   6030
   ShowInTaskbar   =   0   'False
   Begin VB.CheckBox CheckEmpty 
      Caption         =   "Include empty elements"
      Height          =   255
      Left            =   2040
      TabIndex        =   18
      Top             =   2400
      Width           =   2055
   End
   Begin VB.CheckBox CheckKeys 
      Caption         =   "Exclude keys"
      Height          =   255
      Left            =   120
      TabIndex        =   17
      Top             =   2400
      Width           =   1695
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Get tables"
      Height          =   255
      Left            =   120
      TabIndex        =   10
      Top             =   4200
      Width           =   1215
   End
   Begin VB.TextBox TxtSelect 
      Height          =   495
      Left            =   2640
      TabIndex        =   9
      Text            =   "SELECT * FROM []"
      Top             =   3120
      Width           =   3255
   End
   Begin VB.ListBox ListTables 
      Height          =   1035
      Left            =   120
      TabIndex        =   6
      Top             =   3120
      Width           =   2295
   End
   Begin VB.Frame Frame1 
      Caption         =   "Source"
      Height          =   2175
      Left            =   120
      TabIndex        =   2
      Top             =   120
      Width           =   3855
      Begin VB.TextBox TxtODBC 
         Height          =   285
         Left            =   480
         TabIndex        =   16
         Text            =   "Text1"
         Top             =   1680
         Width           =   2295
      End
      Begin VB.TextBox TxtADO 
         Height          =   285
         Left            =   480
         TabIndex        =   15
         Text            =   "Text1"
         Top             =   1080
         Width           =   2295
      End
      Begin VB.OptionButton OptODBC 
         Caption         =   "from ODBC connection string"
         Height          =   255
         Left            =   240
         TabIndex        =   14
         Top             =   1440
         Width           =   2535
      End
      Begin VB.OptionButton OptADO 
         Caption         =   "from ADO connection string"
         Height          =   255
         Left            =   240
         TabIndex        =   13
         Top             =   840
         Width           =   2535
      End
      Begin VB.CommandButton BtnBuildODBC 
         Caption         =   "Build"
         Height          =   255
         Left            =   2880
         TabIndex        =   12
         Top             =   1680
         Width           =   855
      End
      Begin VB.CommandButton BtnBuild 
         Caption         =   "Build"
         Height          =   255
         Left            =   2880
         TabIndex        =   11
         Top             =   1080
         Width           =   855
      End
      Begin VB.CommandButton BtnBrowse 
         Caption         =   "Browse"
         Height          =   255
         Left            =   2880
         TabIndex        =   5
         Top             =   480
         Width           =   855
      End
      Begin VB.TextBox TxtFile 
         Height          =   285
         Left            =   480
         TabIndex        =   4
         Top             =   480
         Width           =   2295
      End
      Begin VB.OptionButton OptAccessFile 
         Caption         =   "from MSAccess file"
         Height          =   255
         Left            =   240
         TabIndex        =   3
         Top             =   240
         Width           =   2535
      End
   End
   Begin VB.CommandButton CancelButton 
      Caption         =   "Cancel"
      Height          =   375
      Left            =   4680
      TabIndex        =   1
      Top             =   600
      Width           =   1215
   End
   Begin VB.CommandButton OKButton 
      Caption         =   "Import"
      Height          =   375
      Left            =   4680
      TabIndex        =   0
      Top             =   120
      Width           =   1215
   End
   Begin VB.Label Label2 
      Caption         =   "Query statement"
      Height          =   255
      Left            =   2640
      TabIndex        =   8
      Top             =   2880
      Width           =   2055
   End
   Begin VB.Label Label1 
      Caption         =   "Tables in database"
      Height          =   255
      Left            =   120
      TabIndex        =   7
      Top             =   2880
      Width           =   2295
   End
End
Attribute VB_Name = "DlgImportDB"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Public bOK As Boolean
Option Explicit

Private Sub BtnBrowse_Click()
    Dim objDlg
    Set objDlg = CreateObject("MSComDlg.CommonDialog")
    objDlg.ShowOpen
    
    If Len(objDlg.FileName) > 0 Then
        TxtFile.Text = objDlg.FileName
    End If
End Sub

Private Sub BtnBuild_Click()
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

Private Sub Command1_Click()
    Dim objImpSettings As DatabaseConnection
    Set objImpSettings = objSpy.GetDatabaseSettings
    
    'set DatabaseConnection properties to dialog controls
    If OptAccessFile.Value = True Then
        objImpSettings.File = TxtFile.Text
    End If
    
    If OptADO.Value = True Then
        objImpSettings.ADOConnection = TxtADO.Text
    End If
    
    If OptODBC.Value = True Then
        objImpSettings.ODBCConnection = TxtODBC.Text
    End If
    
    'objImpSettings.ExcludeKeys = CheckKeys.Value
    'objImpSettings.IncludeEmptyElements = CheckEmpty.Value
    
    ListTables.Clear
    
    Dim objList As ElementList
    Dim objItem As ElementListItem
    On Error GoTo ErrorHandler
    Set objList = objSpy.GetDatabaseTables(objImpSettings)

    For Each objItem In objList
        ListTables.AddItem objItem.Name
    Next
    Exit Sub
    
ErrorHandler:
    CheckForError
End Sub

Private Sub Form_Activate()
    OptAccessFile.Value = True
    UpdateSourceGrp
    bOK = False
End Sub

Private Sub OKButton_Click()
    bOK = True
    Hide
End Sub

Private Sub OptADO_Click()
    UpdateSourceGrp
End Sub

Private Sub OptAccessFile_Click()
    UpdateSourceGrp
End Sub

Private Sub UpdateSourceGrp()
    TxtFile.Enabled = False
    BtnBrowse.Enabled = False
    TxtADO.Enabled = False
    BtnBuild.Enabled = False
    TxtODBC.Enabled = False
    BtnBuildODBC.Enabled = False
    
    If OptAccessFile.Value = True Then
        TxtFile.Enabled = True
        BtnBrowse.Enabled = True
    End If
    
    If OptADO.Value = True Then
        TxtADO.Enabled = True
        BtnBuild.Enabled = True
    End If
    
    If OptODBC.Value = True Then
        TxtODBC.Enabled = True
        BtnBuildODBC.Enabled = True
    End If
End Sub

Private Sub OptODBC_Click()
    UpdateSourceGrp
End Sub
