package communityhub.gui;

import communityhub.Announcement;
import communityhub.DB.Database;
import communityhub.Post;
import communityhub.users.BasicUser;
import communityhub.gui.AddPostGUI;
import communityhub.users.LowPermUser;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.table.AbstractTableModel;

public class LowPermUserGUI extends BasicGUI{
  ArrayList<Announcement> announcementData;

  public LowPermUserGUI(LowPermUser user){
    super(user);
    announcementData = Database.getRecentAnnouncements();
    this.LoggedInUser = user;

    initComponents();
    //This sets the table so user can view posts in a forum table by looping
    announcementTable.getColumnModel().getColumn(0).setHeaderValue("Author");
    announcementTable.getColumnModel().getColumn(1).setHeaderValue("Title");
    announcementTable.getColumnModel().getColumn(2).setHeaderValue("Body");

    for(int i = 0; i < announcementData.size(); i++){
      announcementTable.setValueAt(announcementData.get(i).author, i, 0);
      announcementTable.setValueAt(announcementData.get(i).title, i, 1);
      announcementTable.setValueAt(announcementData.get(i).body, i, 2);
    }

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
    jScrollPane1 = new javax.swing.JScrollPane();
    announcementTable = new javax.swing.JTable();
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

    announcementTable.setModel(new AbstractTableModel()
      {
        @Override
        public int getRowCount()
        {
          return announcementData.size();
        }

        @Override
        public int getColumnCount()
        {
          return 3;
        }

        @Override
        public String getValueAt(int i, int j)
        {
          String temp = null;
          switch (j)
          {
            case 0:
            temp = announcementData.get(i).author;
            break;
            case 1:
            temp = announcementData.get(i).title;
            break;
            case 2:
            temp = announcementData.get(i).body;
            break;
          }
          return temp;
        }

        public void setValueAt(String val, int i, int j)
        {
          switch (j)
          {
            case 1:
            announcementData.get(i).author = val;
            break;
            case 2:
            announcementData.get(i).title = val;
            break;
            case 3:
            announcementData.get(i).body = val;
            break;
          }
        }
      });
      jScrollPane1.setViewportView(announcementTable);

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
              .addGap(52, 52, 52)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(exitButton)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
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
      ArrayList<Post> forumPosts = Database.getRecentPosts(this.LoggedInUser);

      ForumGUI table = new ForumGUI(forumPosts, this.LoggedInUser);

      table.setVisible(true);
    }//GEN-LAST:event_viewForumButtonActionPerformed
  //This button press opens a new login screen and closes the student GUI
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
      new LoginGUI(new javax.swing.JFrame(), true);
      this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed
  //This button press opens a new window to view documents that have been uploaded
    private void viewUploadedDocumentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUploadedDocumentsButtonActionPerformed

    }//GEN-LAST:event_viewUploadedDocumentsButtonActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTable announcementTable;
  private javax.swing.JLabel announcementsLabel;
  private javax.swing.JButton exitButton;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel pageTitle;
  private javax.swing.JComboBox studentPostRole;
  private javax.swing.JButton submitQueryButton;
  private javax.swing.JButton uploadFormsButton;
  private javax.swing.JButton viewForumButton;
  private javax.swing.JButton viewUploadedDocumentsButton;
  // End of variables declaration//GEN-END:variables
}
