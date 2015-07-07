import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.tree.*;

@SuppressWarnings("serial")
public class STMTester extends javax.swing.JFrame {
  	private MySTM m_STM = new MySTM();
        private int m_nEventCounter = 0;
        
        /**
         * derive from generated controller class to customize behavior, implement guard conditions,
         * entry/exit/do actions, forward transition effects, handle debug messages...
         */
        protected class MySTM extends Complex.ComplexController
        {
            public String m_sDebugMessage = "";

            @Override
            public  void OnDebugMessage(String str)
            {
                if (!str.startsWith("BEGIN_EVENT") && !str.startsWith("END_EVENT") && !str.startsWith("BEGIN_INITIALIZE") && !str.startsWith("END_INITIALIZE"))
                    m_sDebugMessage += "\t";

                m_sDebugMessage += str + "\n";
            }

            // guard methods:
            @Override
            public boolean CanGoS5() {
              return  JOptionPane.showConfirmDialog(null, "CanGoS5", "",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            }

            @Override
            public boolean CanGoS2() {
              return  JOptionPane.showConfirmDialog(null, "CanGoS2", "",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            }
        }

	public STMTester() {
		initComponents();

                // add one ToolBarButton per possible call event:
                for( final Action a : m_STM.getCallEvents() ) {
                    m_ToolBar.add( new AbstractAction((String)a.getValue("Name")) {
                        public void actionPerformed(ActionEvent e) {
                                a.actionPerformed(e);
                                m_nEventCounter += 1;
                                UpdateDisplay();
                            }
                        }
                    );
                }
                m_STM.Initialize();
                UpdateDisplay();
	}
        
        private void UpdateDisplay()
        {
          DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(m_STM.getRootState().getName());
          UpdateCurrentStateTree(m_STM.getRootState(), rootNode);
          m_CurrentStateTree.setModel( new DefaultTreeModel(rootNode) );
          for ( int row = 0; row < m_CurrentStateTree.getRowCount(); ++row)
            m_CurrentStateTree.expandRow(row);

          String str = "";
          str += "======= Event " + m_nEventCounter + " =========\n";
          str += m_STM.m_sDebugMessage; m_STM.m_sDebugMessage = "";
          m_DebugOutputTextBox.setText(str + m_DebugOutputTextBox.getText());
          m_DebugOutputTextBox.select(0, 0);
        }

        private void UpdateCurrentStateTree(Complex.ComplexController.IState state, DefaultMutableTreeNode node )
        {
            for( Complex.ComplexController.IRegion r : state.getRegions())
            {
              DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(r.getName() + " : " + r.getCurrentState().getName());
              node.add(childNode);
              UpdateCurrentStateTree(r.getCurrentState(), childNode);
            }          
        }

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    m_ToolBar = new javax.swing.JToolBar();
    jSplitPane1 = new javax.swing.JSplitPane();
    jScrollPane2 = new javax.swing.JScrollPane();
    m_CurrentStateTree = new javax.swing.JTree();
    DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
    renderer.setOpenIcon(null);
    renderer.setClosedIcon(null);
    renderer.setLeafIcon(null);
    m_CurrentStateTree.setCellRenderer(renderer);
    jScrollPane1 = new javax.swing.JScrollPane();
    m_DebugOutputTextBox = new javax.swing.JTextArea();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Test State Machine Code generated by Altova UModel");

    m_ToolBar.setFloatable(false);
    m_ToolBar.setRollover(true);

    jSplitPane1.setBorder(null);
    jSplitPane1.setDividerLocation(150);
    jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

    jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(), "Current state(s):", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11))); // NOI18N

    m_CurrentStateTree.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    jScrollPane2.setViewportView(m_CurrentStateTree);

    jSplitPane1.setTopComponent(jScrollPane2);

    jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createCompoundBorder(), "Debug output messages:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11))); // NOI18N

    m_DebugOutputTextBox.setColumns(20);
    m_DebugOutputTextBox.setFont(new java.awt.Font("Tahoma", 0, 11));
    m_DebugOutputTextBox.setRows(5);
    m_DebugOutputTextBox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    jScrollPane1.setViewportView(m_DebugOutputTextBox);

    jSplitPane1.setRightComponent(jScrollPane1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(m_ToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
      .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(m_ToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new STMTester().setVisible(true);
			}
		});
	}

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JSplitPane jSplitPane1;
  private javax.swing.JTree m_CurrentStateTree;
  private javax.swing.JTextArea m_DebugOutputTextBox;
  private javax.swing.JToolBar m_ToolBar;
  // End of variables declaration//GEN-END:variables

}