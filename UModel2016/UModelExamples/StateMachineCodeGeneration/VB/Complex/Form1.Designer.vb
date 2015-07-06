<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        If disposing AndAlso components IsNot Nothing Then
            components.Dispose()
        End If
        MyBase.Dispose(disposing)
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Form1))
        Me.m_ToolStrip = New System.Windows.Forms.ToolStrip
        Me.m_ToolStripButton = New System.Windows.Forms.ToolStripButton
        Me.label2 = New System.Windows.Forms.Label
        Me.label1 = New System.Windows.Forms.Label
        Me.m_DebugOutputTextBox = New System.Windows.Forms.TextBox
        Me.SplitContainer1 = New System.Windows.Forms.SplitContainer
        Me.m_CurrentStateTree = New System.Windows.Forms.TreeView
        Me.m_ToolStrip.SuspendLayout()
        Me.SplitContainer1.Panel1.SuspendLayout()
        Me.SplitContainer1.Panel2.SuspendLayout()
        Me.SplitContainer1.SuspendLayout()
        Me.SuspendLayout()
        '
        'm_ToolStrip
        '
        Me.m_ToolStrip.Items.AddRange(New System.Windows.Forms.ToolStripItem() {Me.m_ToolStripButton})
        Me.m_ToolStrip.Location = New System.Drawing.Point(0, 0)
        Me.m_ToolStrip.Name = "m_ToolStrip"
        Me.m_ToolStrip.Size = New System.Drawing.Size(574, 25)
        Me.m_ToolStrip.TabIndex = 8
        Me.m_ToolStrip.Text = "ToolStrip1"
        '
        'm_ToolStripButton
        '
        Me.m_ToolStripButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image
        Me.m_ToolStripButton.Image = CType(resources.GetObject("m_ToolStripButton.Image"), System.Drawing.Image)
        Me.m_ToolStripButton.ImageTransparentColor = System.Drawing.Color.Magenta
        Me.m_ToolStripButton.Name = "m_ToolStripButton"
        Me.m_ToolStripButton.Size = New System.Drawing.Size(23, 22)
        Me.m_ToolStripButton.Text = "ToolStripButton1"
        '
        'label2
        '
        Me.label2.AutoSize = True
        Me.label2.Location = New System.Drawing.Point(12, 0)
        Me.label2.Name = "label2"
        Me.label2.Size = New System.Drawing.Size(125, 13)
        Me.label2.TabIndex = 4
        Me.label2.Text = "Debug output messages:"
        '
        'label1
        '
        Me.label1.AutoSize = True
        Me.label1.Location = New System.Drawing.Point(12, 0)
        Me.label1.Name = "label1"
        Me.label1.Size = New System.Drawing.Size(81, 13)
        Me.label1.TabIndex = 5
        Me.label1.Text = "Current state(s):"
        '
        'm_DebugOutputTextBox
        '
        Me.m_DebugOutputTextBox.Anchor = CType((((System.Windows.Forms.AnchorStyles.Top Or System.Windows.Forms.AnchorStyles.Bottom) _
                    Or System.Windows.Forms.AnchorStyles.Left) _
                    Or System.Windows.Forms.AnchorStyles.Right), System.Windows.Forms.AnchorStyles)
        Me.m_DebugOutputTextBox.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.m_DebugOutputTextBox.Location = New System.Drawing.Point(12, 16)
        Me.m_DebugOutputTextBox.Multiline = True
        Me.m_DebugOutputTextBox.Name = "m_DebugOutputTextBox"
        Me.m_DebugOutputTextBox.ScrollBars = System.Windows.Forms.ScrollBars.Vertical
        Me.m_DebugOutputTextBox.Size = New System.Drawing.Size(550, 238)
        Me.m_DebugOutputTextBox.TabIndex = 3
        '
        'SplitContainer1
        '
        Me.SplitContainer1.Anchor = CType((((System.Windows.Forms.AnchorStyles.Top Or System.Windows.Forms.AnchorStyles.Bottom) _
                    Or System.Windows.Forms.AnchorStyles.Left) _
                    Or System.Windows.Forms.AnchorStyles.Right), System.Windows.Forms.AnchorStyles)
        Me.SplitContainer1.Location = New System.Drawing.Point(0, 29)
        Me.SplitContainer1.Name = "SplitContainer1"
        Me.SplitContainer1.Orientation = System.Windows.Forms.Orientation.Horizontal
        '
        'SplitContainer1.Panel1
        '
        Me.SplitContainer1.Panel1.Controls.Add(Me.label1)
        Me.SplitContainer1.Panel1.Controls.Add(Me.m_CurrentStateTree)
        '
        'SplitContainer1.Panel2
        '
        Me.SplitContainer1.Panel2.Controls.Add(Me.label2)
        Me.SplitContainer1.Panel2.Controls.Add(Me.m_DebugOutputTextBox)
        Me.SplitContainer1.Size = New System.Drawing.Size(574, 407)
        Me.SplitContainer1.SplitterDistance = 137
        Me.SplitContainer1.TabIndex = 9
        '
        'm_CurrentStateTree
        '
        Me.m_CurrentStateTree.Anchor = CType((((System.Windows.Forms.AnchorStyles.Top Or System.Windows.Forms.AnchorStyles.Bottom) _
                    Or System.Windows.Forms.AnchorStyles.Left) _
                    Or System.Windows.Forms.AnchorStyles.Right), System.Windows.Forms.AnchorStyles)
        Me.m_CurrentStateTree.Location = New System.Drawing.Point(12, 16)
        Me.m_CurrentStateTree.Name = "m_CurrentStateTree"
        Me.m_CurrentStateTree.ShowRootLines = False
        Me.m_CurrentStateTree.Size = New System.Drawing.Size(550, 118)
        Me.m_CurrentStateTree.TabIndex = 6
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(574, 437)
        Me.Controls.Add(Me.SplitContainer1)
        Me.Controls.Add(Me.m_ToolStrip)
        Me.Name = "Form1"
        Me.Text = "Form1"
        Me.m_ToolStrip.ResumeLayout(False)
        Me.m_ToolStrip.PerformLayout()
        Me.SplitContainer1.Panel1.ResumeLayout(False)
        Me.SplitContainer1.Panel1.PerformLayout()
        Me.SplitContainer1.Panel2.ResumeLayout(False)
        Me.SplitContainer1.Panel2.PerformLayout()
        Me.SplitContainer1.ResumeLayout(False)
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents m_ToolStrip As System.Windows.Forms.ToolStrip
    Friend WithEvents m_ToolStripButton As System.Windows.Forms.ToolStripButton
    Private WithEvents label2 As System.Windows.Forms.Label
    Private WithEvents label1 As System.Windows.Forms.Label
    Private WithEvents m_DebugOutputTextBox As System.Windows.Forms.TextBox
    Friend WithEvents SplitContainer1 As System.Windows.Forms.SplitContainer
    Private WithEvents m_CurrentStateTree As System.Windows.Forms.TreeView
End Class
