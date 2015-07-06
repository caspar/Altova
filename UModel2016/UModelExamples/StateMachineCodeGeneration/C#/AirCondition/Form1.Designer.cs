namespace TestSTM
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.m_ToolStrip = new System.Windows.Forms.ToolStrip();
            this.m_ToolStripButton = new System.Windows.Forms.ToolStripButton();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.m_CurrentStateTree = new System.Windows.Forms.TreeView();
            this.m_DebugOutputTextBox = new System.Windows.Forms.TextBox();
            this.splitContainer1 = new System.Windows.Forms.SplitContainer();
            this.m_ToolStrip.SuspendLayout();
            this.splitContainer1.Panel1.SuspendLayout();
            this.splitContainer1.Panel2.SuspendLayout();
            this.splitContainer1.SuspendLayout();
            this.SuspendLayout();
            // 
            // m_ToolStrip
            // 
            this.m_ToolStrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.m_ToolStripButton});
            this.m_ToolStrip.Location = new System.Drawing.Point(0, 0);
            this.m_ToolStrip.Name = "m_ToolStrip";
            this.m_ToolStrip.Size = new System.Drawing.Size(574, 25);
            this.m_ToolStrip.TabIndex = 3;
            this.m_ToolStrip.Text = "ToolStrip";
            // 
            // m_ToolStripButton
            // 
            this.m_ToolStripButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.m_ToolStripButton.Image = ((System.Drawing.Image)(resources.GetObject("m_ToolStripButton.Image")));
            this.m_ToolStripButton.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.m_ToolStripButton.Name = "m_ToolStripButton";
            this.m_ToolStripButton.Size = new System.Drawing.Size(95, 22);
            this.m_ToolStripButton.Text = "ToolStripButton";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(125, 13);
            this.label2.TabIndex = 0;
            this.label2.Text = "Debug output messages:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(81, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Current state(s):";
            // 
            // m_CurrentStateTree
            // 
            this.m_CurrentStateTree.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.m_CurrentStateTree.Location = new System.Drawing.Point(12, 14);
            this.m_CurrentStateTree.Name = "m_CurrentStateTree";
            this.m_CurrentStateTree.ShowRootLines = false;
            this.m_CurrentStateTree.Size = new System.Drawing.Size(550, 120);
            this.m_CurrentStateTree.TabIndex = 1;
            // 
            // m_DebugOutputTextBox
            // 
            this.m_DebugOutputTextBox.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.m_DebugOutputTextBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.m_DebugOutputTextBox.Location = new System.Drawing.Point(12, 16);
            this.m_DebugOutputTextBox.Multiline = true;
            this.m_DebugOutputTextBox.Name = "m_DebugOutputTextBox";
            this.m_DebugOutputTextBox.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.m_DebugOutputTextBox.Size = new System.Drawing.Size(550, 238);
            this.m_DebugOutputTextBox.TabIndex = 1;
            // 
            // splitContainer1
            // 
            this.splitContainer1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.splitContainer1.Location = new System.Drawing.Point(0, 28);
            this.splitContainer1.Name = "splitContainer1";
            this.splitContainer1.Orientation = System.Windows.Forms.Orientation.Horizontal;
            // 
            // splitContainer1.Panel1
            // 
            this.splitContainer1.Panel1.Controls.Add(this.label1);
            this.splitContainer1.Panel1.Controls.Add(this.m_CurrentStateTree);
            // 
            // splitContainer1.Panel2
            // 
            this.splitContainer1.Panel2.Controls.Add(this.label2);
            this.splitContainer1.Panel2.Controls.Add(this.m_DebugOutputTextBox);
            this.splitContainer1.Size = new System.Drawing.Size(574, 406);
            this.splitContainer1.SplitterDistance = 137;
            this.splitContainer1.TabIndex = 2;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(574, 435);
            this.Controls.Add(this.m_ToolStrip);
            this.Controls.Add(this.splitContainer1);
            this.Name = "Form1";
            this.Text = "Test State Machine Code generated by Altova UModel";
            this.m_ToolStrip.ResumeLayout(false);
            this.m_ToolStrip.PerformLayout();
            this.splitContainer1.Panel1.ResumeLayout(false);
            this.splitContainer1.Panel1.PerformLayout();
            this.splitContainer1.Panel2.ResumeLayout(false);
            this.splitContainer1.Panel2.PerformLayout();
            this.splitContainer1.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ToolStrip m_ToolStrip;
        private System.Windows.Forms.ToolStripButton m_ToolStripButton;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TreeView m_CurrentStateTree;
        private System.Windows.Forms.TextBox m_DebugOutputTextBox;
        private System.Windows.Forms.SplitContainer splitContainer1;

    }
}

