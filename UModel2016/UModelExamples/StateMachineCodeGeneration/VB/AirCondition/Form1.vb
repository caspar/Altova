Imports System

Public Class Form1
    Public m_STM As MySTM = New MySTM()
    Protected m_nEventCounter As Integer = 0

    ''' <summary>
    ''' derive from generated controller class to customize behavior, implement guard conditions,
    ''' entry/exit/do actions, forward transition effects, handle debug messages...
    ''' </summary>
    Public Class MySTM
        Inherits AirCondition.AirConditionController
        Public m_sDebugMessage As String = ""

        Public Overrides Sub OnDebugMessage(ByVal str As String)
            If (Not str.StartsWith("BEGIN_EVENT") AndAlso Not str.StartsWith("END_EVENT") AndAlso Not str.StartsWith("BEGIN_INITIALIZE") AndAlso Not str.StartsWith("END_INITIALIZE")) Then
                m_sDebugMessage += vbTab
            End If

            m_sDebugMessage += str + "\n"
        End Sub
    End Class

    ''' <summary>
    ''' STMEventSender is used to forward ToolStripItem 'Click' events by using the generated CallEventAction delegate
    ''' </summary>
    Public Class STMEventSender
        Dim m_Action As AirCondition.AirConditionController.CallEventAction
        Dim m_Form As Form1

        Public Sub New(ByVal f As Form1, ByVal a As AirCondition.AirConditionController.CallEventAction)
            m_Form = f
            m_Action = a
        End Sub

        Sub CallEvent(ByVal sender As Object, ByVal e As System.EventArgs)
            m_Action()
            m_Form.m_nEventCounter += 1
            m_Form.UpdateDisplay()
        End Sub

    End Class

    Private Sub Form2_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load

        m_ToolStrip.Items.Clear()
        ' add one ToolStripItem per possible call event:
        For Each a As AirCondition.AirConditionController.CallEventAction In m_STM.getCallEvents()
            Dim s As String = a.Method.ToString()
            s = s.Replace("Void ", "")
            s = s.Replace("Boolean ", "")
            s = s.Replace("()", "")
            m_ToolStrip.Items.Add(s, Nothing, AddressOf New STMEventSender(Me, a).CallEvent)
        Next
        m_STM.Initialize()
        UpdateDisplay()
    End Sub

    Private Sub UpdateDisplay()
        m_CurrentStateTree.BeginUpdate()
        m_CurrentStateTree.Nodes.Clear()
        Dim rootNode As TreeNode = m_CurrentStateTree.Nodes.Add(m_STM.getRootState().getName())
        UpdateCurrentStateTree(m_STM.getRootState(), rootNode)
        rootNode.ExpandAll()
        m_CurrentStateTree.EndUpdate()

        Dim str As String = ""
        str += "======= Event " + m_nEventCounter.ToString() + " =========\n"
        str += m_STM.m_sDebugMessage
        m_STM.m_sDebugMessage = ""
        m_DebugOutputTextBox.Text = str.Replace("\n", vbCrLf) + m_DebugOutputTextBox.Text
        m_DebugOutputTextBox.Select(0, 0)
        m_DebugOutputTextBox.Select()
    End Sub

    Private Sub UpdateCurrentStateTree(ByVal state As AirCondition.AirConditionController.IState, ByVal node As TreeNode)
        For Each r As AirCondition.AirConditionController.IRegion In state.getRegions()
            Dim childNode As TreeNode = node.Nodes.Add("Region " + r.getName() + " : " + r.getCurrentState().getName())
            UpdateCurrentStateTree(r.getCurrentState(), childNode)
        Next
    End Sub
End Class
