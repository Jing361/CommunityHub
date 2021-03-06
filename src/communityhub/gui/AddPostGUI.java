package communityhub.gui;

import communityhub.DB.Database;
import communityhub.Group;
import communityhub.Post;
import communityhub.users.BasicUser;
import java.util.ArrayList;

public class AddPostGUI extends javax.swing.JFrame{
  // user that is posting the post
  BasicUser user;
  Group postAs;
  Post replyTo = null;

  public AddPostGUI(BasicUser user){
    initComponents();
    this.user = user;
  }

  public AddPostGUI(Post replyTo, BasicUser user){
    this(user);
    this.replyTo = replyTo;
  }

  /*
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    titleText = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    bodyText = new javax.swing.JTextArea();
    submit = new javax.swing.JButton();
    cancelButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setText("Title");

    jLabel3.setText("Body");

    bodyText.setColumns(20);
    bodyText.setRows(5);
    jScrollPane1.setViewportView(bodyText);

    submit.setText("Submit");
    submit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitActionPerformed(evt);
      }
    });

    cancelButton.setText("Cancel");
    cancelButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(53, 53, 53)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabel3)
          .addComponent(jLabel1))
        .addGap(43, 43, 43)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(submit)
            .addGap(18, 18, 18)
            .addComponent(cancelButton))
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(114, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(25, 25, 25)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(42, 42, 42)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel3)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(46, 46, 46)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(submit)
          .addComponent(cancelButton))
        .addContainerGap(48, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  // creates a post and brings the user back to the forum
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
      String title = titleText.getText();
      String body = bodyText.getText();
      ArrayList<String> p = null;

      // if it is a parent, initialize the array list
      if(this.replyTo == null){
        p = new ArrayList();
      }
      // else leave it as null

      Database.CreatePost(new Post(user.username, title, body, this.postAs));
      new ForumGUI(Database.getRecentPosts(user), user).setVisible(true);
      this.dispose();
    }//GEN-LAST:event_submitActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
      this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextArea bodyText;
  private javax.swing.JButton cancelButton;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JButton submit;
  private javax.swing.JTextField titleText;
  // End of variables declaration//GEN-END:variables
}
