package communityhub.gui;

import communityhub.Announcement;
import communityhub.DB.Database;
import communityhub.Post;
import communityhub.users.*;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.AbstractTableModel;

public class MidPermUserGUI extends BasicGUI{
  ArrayList<Announcement> announcementData;

  public MidPermUserGUI(MidPermUser user){
    super(user);
    //gets announcement data and fills the table by using a for loop
    LoggedInUser = user;
    announcementData = this.LoggedInUser.connection.getRecentAnnouncements();

    initComponents();

    System.out.println(announcementTable);
    announcementTable.getColumnModel().getColumn(0).setHeaderValue("Author");
    announcementTable.getColumnModel().getColumn(1).setHeaderValue("Title");
    announcementTable.getColumnModel().getColumn(2).setHeaderValue("Body");

    for(int i = 0; i < announcementData.size(); i++){
      announcementTable.setValueAt(announcementData.get(i).author, i, 0);
      announcementTable.setValueAt(announcementData.get(i).title, i, 1);
      announcementTable.setValueAt(announcementData.get(i).body, i, 2);
    }

    setVisible(true);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    graduateAssistantLoginTitle = new javax.swing.JLabel();
    postAnnouncementButton = new javax.swing.JButton();
    viewStudentQueriesButton = new javax.swing.JButton();
    viewDocumentsButton = new javax.swing.JButton();
    submitScheduleButton = new javax.swing.JButton();
    exitButton = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    announcementTable = new javax.swing.JTable();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    graduateAssistantLoginTitle.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
    graduateAssistantLoginTitle.setText("Graduate Assistant Page");

    postAnnouncementButton.setText("Post Announcement");
    postAnnouncementButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        postAnnouncementButtonActionPerformed(evt);
      }
    });

    viewStudentQueriesButton.setText("View Queries");
    viewStudentQueriesButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        viewStudentQueriesButtonActionPerformed(evt);
      }
    });

    viewDocumentsButton.setText("View Uploaded Documents");
    viewDocumentsButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        viewDocumentsButtonActionPerformed(evt);
      }
    });

    submitScheduleButton.setText("Submit Availability Schedule");
    submitScheduleButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        submitScheduleButtonActionPerformed(evt);
      }
    });

    exitButton.setText("Exit");
    exitButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        exitButtonActionPerformed(evt);
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

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(layout.createSequentialGroup()
          .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
              .addContainerGap()
              .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                .add(exitButton)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 574, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(layout.createSequentialGroup()
                  .add(postAnnouncementButton)
                  .add(18, 18, 18)
                  .add(viewStudentQueriesButton)
                  .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                  .add(submitScheduleButton)
                  .add(18, 18, 18)
                  .add(viewDocumentsButton))))
            .add(layout.createSequentialGroup()
              .add(202, 202, 202)
              .add(graduateAssistantLoginTitle)))
          .addContainerGap(25, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(layout.createSequentialGroup()
          .add(20, 20, 20)
          .add(graduateAssistantLoginTitle)
          .add(18, 18, 18)
          .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
            .add(postAnnouncementButton)
            .add(viewStudentQueriesButton)
            .add(viewDocumentsButton)
            .add(submitScheduleButton))
          .add(39, 39, 39)
          .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 235, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 35, Short.MAX_VALUE)
          .add(exitButton)
          .add(29, 29, 29))
      );

      pack();
    }// </editor-fold>//GEN-END:initComponents
  //This button exits the GraduateAssistantGUI and opens a login form
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
      try {
        new LoginGUI(new javax.swing.JFrame(), true);
      } catch(Exception ex) {
        Logger.getLogger(MidPermUserGUI.class.getName()).log(Level.SEVERE, null, ex);
      }
      this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed
  //This button opens a page to add a new announcement
    private void postAnnouncementButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_postAnnouncementButtonActionPerformed
    {//GEN-HEADEREND:event_postAnnouncementButtonActionPerformed
      AddAnouncementGUI announce = new AddAnouncementGUI(LoggedInUser);
      this.dispose();
    }//GEN-LAST:event_postAnnouncementButtonActionPerformed
  //This button views the forum with student queries
    private void viewStudentQueriesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStudentQueriesButtonActionPerformed
      ArrayList<Post> forumPosts = this.LoggedInUser.connection.getRecentPosts(LoggedInUser);

      ForumGUI table = new ForumGUI(forumPosts, LoggedInUser);

      table.setVisible(true);
    }//GEN-LAST:event_viewStudentQueriesButtonActionPerformed
  //This button opens a page to view uploaded documents
    private void viewDocumentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDocumentsButtonActionPerformed
    }//GEN-LAST:event_viewDocumentsButtonActionPerformed
  //This button opens a directory viewer to upload a pdf version of a schedule
    private void submitScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitScheduleButtonActionPerformed
    }//GEN-LAST:event_submitScheduleButtonActionPerformed
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTable announcementTable;
  private javax.swing.JButton exitButton;
  private javax.swing.JLabel graduateAssistantLoginTitle;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JButton postAnnouncementButton;
  private javax.swing.JButton submitScheduleButton;
  private javax.swing.JButton viewDocumentsButton;
  private javax.swing.JButton viewStudentQueriesButton;
  // End of variables declaration//GEN-END:variables
}
