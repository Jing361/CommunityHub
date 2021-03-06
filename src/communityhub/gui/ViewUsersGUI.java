package communityhub.gui;
import communityhub.DB.Database;
import communityhub.users.BasicUser;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ViewUsersGUI extends javax.swing.JFrame{
  ArrayList<BasicUser> data;

  public ViewUsersGUI(ArrayList<BasicUser> userList){
    this.data = userList;
    initComponents();
    //this views the users and their roles and displays them in a table
    docTable.getColumnModel().getColumn(0).setHeaderValue("User");
    docTable.getColumnModel().getColumn(1).setHeaderValue("Role");

    BasicUser temp;

    for(int i = 0; i < data.size(); i++){
      temp = data.get(i);
      docTable.setValueAt(temp.username, i, 0);
      docTable.setValueAt(temp.toString(), i, 1);
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    docTable = new javax.swing.JTable();
    promoteButton = new javax.swing.JButton();
    cancelButton = new javax.swing.JButton();
    demoteButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
    jLabel1.setText("Current Users");

    docTable.setModel(new AbstractTableModel()
      {
        @Override
        public int getRowCount()
        {
          return data.size();
        }

        @Override
        public int getColumnCount()
        {
          return 2;
        }

        @Override
        public String getValueAt(int i, int j)
        {
          if (j == 0)
          {
            return data.get(i).username;
          }
          else
          {
            return data.get(i).toString();
          }
        }

        public void setValueAt(String val, int i, int j)
        {
          BasicUser jim = data.get(i);
          data.set(i, jim);
        }
      });
      jScrollPane1.setViewportView(docTable);

      promoteButton.setText("Promote");
      promoteButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          promoteButtonActionPerformed(evt);
        }
      });

      cancelButton.setText("Cancel");
      cancelButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          cancelButtonActionPerformed(evt);
        }
      });

      demoteButton.setText("Demote");
      demoteButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          demoteButtonActionPerformed(evt);
        }
      });

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(layout.createSequentialGroup()
          .addContainerGap()
          .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
              .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 243, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(layout.createSequentialGroup()
                  .add(38, 38, 38)
                  .add(jLabel1)))
              .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
              .add(0, 0, Short.MAX_VALUE)
              .add(promoteButton)
              .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
              .add(demoteButton)
              .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
              .add(cancelButton)
              .add(14, 14, 14))))
      );
      layout.setVerticalGroup(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(layout.createSequentialGroup()
          .addContainerGap()
          .add(jLabel1)
          .add(18, 18, 18)
          .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
          .add(18, 18, 18)
          .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
            .add(promoteButton)
            .add(cancelButton)
            .add(demoteButton))
          .addContainerGap(21, Short.MAX_VALUE))
      );

      pack();
    }// </editor-fold>//GEN-END:initComponents
  //This button promotes the selected user to the next higher role
    private void promoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_promoteButtonActionPerformed
      if(docTable.getSelectedRow() >= 0){
        //Second param should not be null
        Database.changeRole(data.get(docTable.getSelectedRow()).username, null);
        new ViewUsersGUI(Database.getPotentialUsers()).setVisible(true);
        this.dispose();
      }
    }//GEN-LAST:event_promoteButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
      this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed
  //This button demotes the selected user to the next lowest role
    private void demoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demoteButtonActionPerformed
      if(docTable.getSelectedRow() >= 0){
        //Second param should not be null
        Database.changeRole(data.get(docTable.getSelectedRow()).username, null);
        new ViewUsersGUI(Database.getPotentialUsers()).setVisible(true);
        this.dispose();
      }
    }//GEN-LAST:event_demoteButtonActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton cancelButton;
  private javax.swing.JButton demoteButton;
  private javax.swing.JTable docTable;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JButton promoteButton;
  // End of variables declaration//GEN-END:variables
}
