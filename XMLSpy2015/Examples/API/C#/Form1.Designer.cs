namespace WindowsFormsApplication2
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
            this.StartXMLSpy = new System.Windows.Forms.Button();
            this.openOrgChart = new System.Windows.Forms.Button();
            this.openExpReport = new System.Windows.Forms.Button();
            this.toggleView = new System.Windows.Forms.Button();
            this.shutdownXMLSpy = new System.Windows.Forms.Button();
            this.validate = new System.Windows.Forms.Button();
            this.checkBoxEventOnOff = new System.Windows.Forms.CheckBox();
            this.listBoxMessages = new System.Windows.Forms.ListBox();
            this.SuspendLayout();
            // 
            // StartXMLSpy
            // 
            this.StartXMLSpy.Location = new System.Drawing.Point(26, 24);
            this.StartXMLSpy.Name = "StartXMLSpy";
            this.StartXMLSpy.Size = new System.Drawing.Size(111, 29);
            this.StartXMLSpy.TabIndex = 0;
            this.StartXMLSpy.Text = "Start XMLSpy";
            this.StartXMLSpy.UseVisualStyleBackColor = true;
            this.StartXMLSpy.Click += new System.EventHandler(this.StartXMLSpy_Click);
            // 
            // openOrgChart
            // 
            this.openOrgChart.Location = new System.Drawing.Point(60, 59);
            this.openOrgChart.Name = "openOrgChart";
            this.openOrgChart.Size = new System.Drawing.Size(185, 29);
            this.openOrgChart.TabIndex = 1;
            this.openOrgChart.Text = "Open OrgChart.pxf";
            this.openOrgChart.UseVisualStyleBackColor = true;
            this.openOrgChart.Click += new System.EventHandler(this.openOrgChart_Click);
            // 
            // openExpReport
            // 
            this.openExpReport.Location = new System.Drawing.Point(60, 94);
            this.openExpReport.Name = "openExpReport";
            this.openExpReport.Size = new System.Drawing.Size(185, 29);
            this.openExpReport.TabIndex = 2;
            this.openExpReport.Text = "Open ExpReport.xml";
            this.openExpReport.UseVisualStyleBackColor = true;
            this.openExpReport.Click += new System.EventHandler(this.openExpReport_Click);
            // 
            // toggleView
            // 
            this.toggleView.Location = new System.Drawing.Point(60, 129);
            this.toggleView.Name = "toggleView";
            this.toggleView.Size = new System.Drawing.Size(185, 29);
            this.toggleView.TabIndex = 3;
            this.toggleView.Text = "Toggle View Mode";
            this.toggleView.UseVisualStyleBackColor = true;
            this.toggleView.Click += new System.EventHandler(this.toggleView_Click);
            // 
            // shutdownXMLSpy
            // 
            this.shutdownXMLSpy.Location = new System.Drawing.Point(26, 234);
            this.shutdownXMLSpy.Name = "shutdownXMLSpy";
            this.shutdownXMLSpy.Size = new System.Drawing.Size(111, 29);
            this.shutdownXMLSpy.TabIndex = 4;
            this.shutdownXMLSpy.Text = "Shutdown XMLSpy";
            this.shutdownXMLSpy.UseVisualStyleBackColor = true;
            this.shutdownXMLSpy.Click += new System.EventHandler(this.shutdownXMLSpy_Click);
            // 
            // validate
            // 
            this.validate.Location = new System.Drawing.Point(60, 164);
            this.validate.Name = "validate";
            this.validate.Size = new System.Drawing.Size(185, 29);
            this.validate.TabIndex = 5;
            this.validate.Text = "Validate";
            this.validate.UseVisualStyleBackColor = true;
            this.validate.Click += new System.EventHandler(this.validate_Click);
            // 
            // checkBoxEventOnOff
            // 
            this.checkBoxEventOnOff.AutoSize = true;
            this.checkBoxEventOnOff.Location = new System.Drawing.Point(60, 200);
            this.checkBoxEventOnOff.Name = "checkBoxEventOnOff";
            this.checkBoxEventOnOff.Size = new System.Drawing.Size(194, 17);
            this.checkBoxEventOnOff.TabIndex = 6;
            this.checkBoxEventOnOff.Text = "OnDocumentOpened Event On/Off";
            this.checkBoxEventOnOff.UseVisualStyleBackColor = true;
            this.checkBoxEventOnOff.CheckedChanged += new System.EventHandler(this.checkBoxEventOnOff_CheckedChanged);
            // 
            // listBoxMessages
            // 
            this.listBoxMessages.FormattingEnabled = true;
            this.listBoxMessages.HorizontalScrollbar = true;
            this.listBoxMessages.Location = new System.Drawing.Point(270, 24);
            this.listBoxMessages.Name = "listBoxMessages";
            this.listBoxMessages.Size = new System.Drawing.Size(402, 225);
            this.listBoxMessages.TabIndex = 7;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(698, 277);
            this.Controls.Add(this.listBoxMessages);
            this.Controls.Add(this.checkBoxEventOnOff);
            this.Controls.Add(this.validate);
            this.Controls.Add(this.shutdownXMLSpy);
            this.Controls.Add(this.toggleView);
            this.Controls.Add(this.openExpReport);
            this.Controls.Add(this.openOrgChart);
            this.Controls.Add(this.StartXMLSpy);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button StartXMLSpy;
        private System.Windows.Forms.Button openOrgChart;
        private System.Windows.Forms.Button openExpReport;
        private System.Windows.Forms.Button toggleView;
        private System.Windows.Forms.Button shutdownXMLSpy;
        private System.Windows.Forms.Button validate;
        private System.Windows.Forms.CheckBox checkBoxEventOnOff;
        private System.Windows.Forms.ListBox listBoxMessages;
    }
}

