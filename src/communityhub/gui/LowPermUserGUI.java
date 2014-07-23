package communityhub.gui;

import communityhub.Announcement;
import communityhub.DB.Database;
import communityhub.Post;
import communityhub.users.BasicUser;
import communityhub.gui.AddPostGUI;
import communityhub.users.LowPermUser;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.AbstractTableModel;

public class LowPermUserGUI extends BasicGUI{
  public LowPermUserGUI(LowPermUser user){
    super(user);
    initComponents();
    //This sets the table so user can view posts in a forum table by looping
    this.setVisible(true);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    studentPostRole = new javax.swing.JComboBox();
    submitQueryButton = new javax.swing.JButton();
    pageTitle = new javax.swing.JLabel();
    uploadFormsButton = new javax.swing.JButton();
    announcementsLabel = new javax.swing.JLabel();
    viewForumButton = new javax.swing.JButton();
    exitButton = new javax.swing.JButton();
    viewUploadedDocumentsButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    studentPostRole.setMaximumRowCount(2);
    studentPostRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Submit to Graduate Office", "Submit to All" }));
    studentPostRole.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        studentPostRoleActionPerformed(evt);
      }
    });

    submitQueryButton.setText("Submit Query");
    submitQueryButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitQueryButtonActionPerformed(evt);
      }
    });

    pageTitle.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
    pageTitle.setText("Student Page");

    uploadFormsButton.setText("Upload Forms");
    uploadFormsButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        uploadFormsButtonActionPerformed(evt);
      }
    });

    announcementsLabel.setText("Announcements");

    viewForumButton.setText("View Forum");
    viewForumButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        viewForumButtonActionPerformed(evt);
      }
    });

    exitButton.setText("Exit");
    exitButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        exitButtonActionPerformed(evt);
      }
    });

    viewUploadedDocumentsButton.setText("View Uploaded Documents");
    viewUploadedDocumentsButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        viewUploadedDocumentsButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(426, 426, 426)
            .addComponent(exitButton))
          .addGroup(layout.createSequentialGroup()
            .addGap(195, 195, 195)
            .addComponent(pageTitle))
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
            .addGroup(layout.createSequentialGroup()
              .addGap(234, 234, 234)
              .addComponent(announcementsLabel)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(viewUploadedDocumentsButton))
            .addGroup(layout.createSequentialGroup()
              .addContainerGap()
              .addComponent(studentPostRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGap(24, 24, 24)
              .addComponent(submitQueryButton)
              .addGap(18, 18, 18)
              .addComponent(uploadFormsButton)
              .addGap(18, 18, 18)
              .addComponent(viewForumButton))))
        .addContainerGap(19, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(pageTitle)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(uploadFormsButton)
          .addComponent(studentPostRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(submitQueryButton)
          .addComponent(viewForumButton))
        .addGap(23, 23, 23)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(announcementsLabel)
          .addComponent(viewUploadedDocumentsButton))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
        .addComponent(exitButton)
        .addGap(22, 22, 22))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void studentPostRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentPostRoleActionPerformed
    }//GEN-LAST:event_studentPostRoleActionPerformed

    private void submitQueryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitQueryButtonActionPerformed
      new AddPostGUI(this.LoggedInUser);
      this.dispose();
    }//GEN-LAST:event_submitQueryButtonActionPerformed
  //This button press opens a directory viewer for students to upload forms
  //where only PDF files are viewable, and saves the file directory to the database
    private void uploadFormsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadFormsButtonActionPerformed
    }//GEN-LAST:event_uploadFormsButtonActionPerformed
  //This button press action opens the forum and 
  //displays the database list of posts in a table view
    private void viewForumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewForumButtonActionPerformed
      ArrayList<Post> forumPosts = this.LoggedInUser.connection.getRecentPosts(this.LoggedInUser);

      ForumGUI table = new ForumGUI(forumPosts, this.LoggedInUser);

      table.setVisible(true);
    }//GEN-LAST:event_viewForumButtonActionPerformed
  //This button press opens a new login screen and closes the student GUI
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
      try {
        new LoginGUI(new javax.swing.JFrame(), true);
      } catch(Exception ex) {
        Logger.getLogger(LowPermUserGUI.class.getName()).log(Level.SEVERE, null, ex);
      }
      this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed
  //This button press opens a new window to view documents that have been uploaded
    private void viewUploadedDocumentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUploadedDocumentsButtonActionPerformed
    }//GEN-LAST:event_viewUploadedDocumentsButtonActionPerformed
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel announcementsLabel;
  private javax.swing.JButton exitButton;
  private javax.swing.JLabel pageTitle;
  private javax.swing.JComboBox studentPostRole;
  private javax.swing.JButton submitQueryButton;
  private javax.swing.JButton uploadFormsButton;
  private javax.swing.JButton viewForumButton;
  private javax.swing.JButton viewUploadedDocumentsButton;
  // End of variables declaration//GEN-END:variables
}
