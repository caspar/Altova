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
            this.StartUModel = new System.Windows.Forms.Button();
            this.openBank_MultiLanguage = new System.Windows.Forms.Button();
            this.openAllDiagrams = new System.Windows.Forms.Button();
            this.shutdownUModel = new System.Windows.Forms.Button();
            this.generateDocumentation = new System.Windows.Forms.Button();
            this.checkBoxEventOnOff = new System.Windows.Forms.CheckBox();
            this.listBoxMessages = new System.Windows.Forms.ListBox();
            this.SuspendLayout();
            // 
            // StartUModel
            // 
            this.StartUModel.Location = new System.Drawing.Point(26, 24);
            this.StartUModel.Name = "StartUModel";
            this.StartUModel.Size = new System.Drawing.Size(120, 29);
            this.StartUModel.TabIndex = 0;
            this.StartUModel.Text = "Start UModel";
            this.StartUModel.UseVisualStyleBackColor = true;
            this.StartUModel.Click += new System.EventHandler(this.StartUModel_Click);
            // 
            // openBank_MultiLanguage
            // 
            this.openBank_MultiLanguage.Location = new System.Drawing.Point(60, 59);
            this.openBank_MultiLanguage.Name = "openBank_MultiLanguage";
            this.openBank_MultiLanguage.Size = new System.Drawing.Size(185, 29);
            this.openBank_MultiLanguage.TabIndex = 1;
            this.openBank_MultiLanguage.Text = "Open Bank_MultiLanguage";
            this.openBank_MultiLanguage.UseVisualStyleBackColor = true;
            this.openBank_MultiLanguage.Click += new System.EventHandler(this.openBank_MultiLanguage_Click);
            // 
            // openAllDiagrams
            // 
            this.openAllDiagrams.Location = new System.Drawing.Point(60, 94);
            this.openAllDiagrams.Name = "openAllDiagrams";
            this.openAllDiagrams.Size = new System.Drawing.Size(185, 29);
            this.openAllDiagrams.TabIndex = 2;
            this.openAllDiagrams.Text = "Open all diagrams";
            this.openAllDiagrams.UseVisualStyleBackColor = true;
            this.openAllDiagrams.Click += new System.EventHandler(this.openAllDiagrams_Click);
            // 
            // shutdownUModel
            // 
            this.shutdownUModel.Location = new System.Drawing.Point(26, 215);
            this.shutdownUModel.Name = "shutdownUModel";
            this.shutdownUModel.Size = new System.Drawing.Size(120, 29);
            this.shutdownUModel.TabIndex = 4;
            this.shutdownUModel.Text = "Shutdown UModel";
            this.shutdownUModel.UseVisualStyleBackColor = true;
            this.shutdownUModel.Click += new System.EventHandler(this.shutdownUModel_Click);
            // 
            // generateDocumentation
            // 
            this.generateDocumentation.Location = new System.Drawing.Point(60, 129);
            this.generateDocumentation.Name = "generateDocumentation";
            this.generateDocumentation.Size = new System.Drawing.Size(185, 29);
            this.generateDocumentation.TabIndex = 5;
            this.generateDocumentation.Text = " Generate documentation";
            this.generateDocumentation.UseVisualStyleBackColor = true;
            this.generateDocumentation.Click += new System.EventHandler(this.generateDocumentation_Click);
            // 
            // checkBoxEventOnOff
            // 
            this.checkBoxEventOnOff.AutoSize = true;
            this.checkBoxEventOnOff.Location = new System.Drawing.Point(60, 176);
            this.checkBoxEventOnOff.Name = "checkBoxEventOnOff";
            this.checkBoxEventOnOff.Size = new System.Drawing.Size(194, 17);
            this.checkBoxEventOnOff.TabIndex = 7;
            this.checkBoxEventOnOff.Text = "OnDocumentOpened Event On/Off";
            this.checkBoxEventOnOff.TextImageRelation = System.Windows.Forms.TextImageRelation.TextAboveImage;
            this.checkBoxEventOnOff.UseVisualStyleBackColor = true;
            this.checkBoxEventOnOff.CheckedChanged += new System.EventHandler(this.checkBoxEventOnOff_CheckedChanged);
            // 
            // listBoxMessages
            // 
            this.listBoxMessages.FormattingEnabled = true;
            this.listBoxMessages.HorizontalScrollbar = true;
            this.listBoxMessages.Location = new System.Drawing.Point(271, 24);
            this.listBoxMessages.Name = "listBoxMessages";
            this.listBoxMessages.Size = new System.Drawing.Size(405, 225);
            this.listBoxMessages.TabIndex = 8;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(699, 270);
            this.Controls.Add(this.listBoxMessages);
            this.Controls.Add(this.checkBoxEventOnOff);
            this.Controls.Add(this.generateDocumentation);
            this.Controls.Add(this.shutdownUModel);
            this.Controls.Add(this.openAllDiagrams);
            this.Controls.Add(this.openBank_MultiLanguage);
            this.Controls.Add(this.StartUModel);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button StartUModel;
        private System.Windows.Forms.Button openBank_MultiLanguage;
        private System.Windows.Forms.Button openAllDiagrams;
        private System.Windows.Forms.Button shutdownUModel;
        private System.Windows.Forms.Button generateDocumentation;
        private System.Windows.Forms.CheckBox checkBoxEventOnOff;
        private System.Windows.Forms.ListBox listBoxMessages;
    }
}

