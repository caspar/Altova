using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace TestSTM
{
    public partial class Form1 : Form
    {
        MySTM m_STM = new MySTM();
        int m_nEventCounter = 0;

        /// <summary>
        /// derive from generated controller class to customize behavior, implement guard conditions,
        /// entry/exit/do actions, forward transition effects, handle debug messages...
        /// </summary>
        public class MySTM : AirCondition.AirConditionController
        {
            public String m_sDebugMessage = "";

            public override void OnDebugMessage(string str)
            {
                if (!str.StartsWith("BEGIN_EVENT") && !str.StartsWith("END_EVENT") && !str.StartsWith("BEGIN_INITIALIZE") && !str.StartsWith("END_INITIALIZE"))
                    m_sDebugMessage += "\t";

                m_sDebugMessage += str + "\n";
            }
        }

        /// <summary>
        /// STMEventSender is used to forward ToolStripItem 'Click' events by using the generated CallEventAction delegate
        /// </summary>
         public class STMEventSender
        {
            AirCondition.AirConditionController.CallEventAction m_Action;
            Form1 m_Form;
            public STMEventSender(Form1 f, AirCondition.AirConditionController.CallEventAction a)
            {
                m_Form = f;
                m_Action = a;
            }
            public void CallEvent(object sender, EventArgs e)
            {
                m_Action();
                m_Form.m_nEventCounter++;
                m_Form.UpdateDisplay();
            }
        }

        public Form1()
        {
            InitializeComponent();
            m_ToolStrip.Items.Clear();
            // add one ToolStripItem per possible call event:
            foreach (AirCondition.AirConditionController.CallEventAction a in m_STM.getCallEvents())
            {
                string s = a.Method.ToString();
                s = s.Replace("Void ", "");
                s = s.Replace("Boolean ", "");
                s = s.Replace("()", "");
                m_ToolStrip.Items.Add(s, null, new STMEventSender(this, a).CallEvent);
            }
            m_STM.Initialize();
            UpdateDisplay();
        }

        private void UpdateDisplay()
        {
            m_CurrentStateTree.BeginUpdate();
            m_CurrentStateTree.Nodes.Clear();
            TreeNode rootNode = m_CurrentStateTree.Nodes.Add(m_STM.getRootState().getName());
            UpdateCurrentStateTree(m_STM.getRootState(), rootNode);
            rootNode.ExpandAll();
            m_CurrentStateTree.EndUpdate();

            String str = "";
            str += "======= Event " + m_nEventCounter + " =========\n";
            str += m_STM.m_sDebugMessage; m_STM.m_sDebugMessage = "";
            m_DebugOutputTextBox.Text = str.Replace("\n", "\r\n") + m_DebugOutputTextBox.Text;
            m_DebugOutputTextBox.Select(0, 0);
            m_DebugOutputTextBox.Select();
        }

        private void UpdateCurrentStateTree(AirCondition.AirConditionController.IState state, TreeNode node)
        {
            foreach (AirCondition.AirConditionController.IRegion r in state.getRegions())
            {
                TreeNode childNode = node.Nodes.Add(r.getName() + " : " + r.getCurrentState().getName());
                UpdateCurrentStateTree(r.getCurrentState(), childNode);
            }
        }
    }
}
