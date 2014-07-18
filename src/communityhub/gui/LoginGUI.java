package communityhub.gui;

import communityhub.users.BasicUser;

public class LoginGUI extends javax.swing.JDialog{
  public LoginGUI(java.awt.Frame parent, boolean modal){
    super(parent, modal);
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    passwordField = new javax.swing.JPasswordField();
    usernameLabel = new javax.swing.JLabel();
    resetButton = new javax.swing.JButton();
    submitButton = new javax.swing.JButton();
    usernameField = new javax.swing.JTextField();
    passwordLabel = new javax.swing.JLabel();
    exitButton = new javax.swing.JButton();
    titleLabel = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    passwordField.setText("student");

    usernameLabel.setText("Username");

    resetButton.setText("Reset");
    resetButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        resetButtonActionPerformed(evt);
      }
    });

    submitButton.setText("Submit");
    submitButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitButtonActionPerformed(evt);
      }
    });

    usernameField.setText("Insert your username here!");
    usernameField.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        usernameFieldActionPerformed(evt);
      }
    });

    passwordLabel.setText("Password");

    exitButton.setText("Exit");
    exitButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        exitButtonActionPerformed(evt);
      }
    });

    titleLabel.setText("Hub Log-in");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(145, 145, 145)
        .addComponent(titleLabel)
        .addContainerGap())
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(60, 60, 60)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(passwordLabel)
          .addComponent(submitButton)
          .addComponent(usernameLabel))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(resetButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
            .addComponent(exitButton)
            .addGap(50, 50, 50))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(24, Short.MAX_VALUE)
        .addComponent(titleLabel)
        .addGap(40, 40, 40)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(usernameLabel)
          .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(31, 31, 31)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(passwordLabel))
        .addGap(50, 50, 50)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(submitButton)
          .addComponent(resetButton)
          .addComponent(exitButton))
        .addGap(55, 55, 55))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
    usernameField.setText("");//Text Field for Username
    passwordField.setText("");//Text Field for Password
  }//GEN-LAST:event_resetButtonActionPerformed

  private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
    String username;
    char[] password;
    BasicUser result;

    username = usernameField.getText(); //get username from text box
    password = passwordField.getPassword(); //get password from password box
    result = MongoDB.lookUp(username, password);

    if(result != null){
      this.dispose();
      result.SpawnGui();
    } else {
      System.out.println("No user found");
    }
  }//GEN-LAST:event_submitButtonActionPerformed

  private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
  }//GEN-LAST:event_usernameFieldActionPerformed

  private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
    System.exit(0);
  }//GEN-LAST:event_exitButtonActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]){
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
        if("Nimbus".equals(info.getName())){
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch(ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch(InstantiationException ex) {
      java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch(IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch(javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the dialog */
    java.awt.EventQueue.invokeLater(new Runnable(){
      public void run(){
        LoginGUI dialog = new LoginGUI(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter(){
          @Override
          public void windowClosing(java.awt.event.WindowEvent e){
            System.exit(0);
          }
        });
        dialog.setVisible(true);
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton exitButton;
  private javax.swing.JPasswordField passwordField;
  private javax.swing.JLabel passwordLabel;
  private javax.swing.JButton resetButton;
  private javax.swing.JButton submitButton;
  private javax.swing.JLabel titleLabel;
  private javax.swing.JTextField usernameField;
  private javax.swing.JLabel usernameLabel;
  // End of variables declaration//GEN-END:variables
}