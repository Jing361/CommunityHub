package communityhub.gui;

import communityhub.DB.Database;
import communityhub.users.BasicUser;
import communityhub.users.HighPermUser;
import java.util.ArrayList;

public class HighPermUserGUI extends BasicGUI{
  public HighPermUserGUI(HighPermUser user){
    super(user);
    this.initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    graduateCoordinatorTitle = new javax.swing.JLabel();
    promoteUserButton = new javax.swing.JButton();
    postAnnouncementsButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    graduateCoordinatorTitle.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
    graduateCoordinatorTitle.setText("Admin Page");

    promoteUserButton.setText("Promote/Demote User");
    promoteUserButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        promoteUserButtonActionPerformed(evt);
      }
    });

    postAnnouncementsButton.setText("Post Announcement");
    postAnnouncementsButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        postAnnouncementsButtonActionPerformed(evt);
      }
    });

    org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(layout.createSequentialGroup()
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
          .add(layout.createSequentialGroup()
            .add(61, 61, 61)
            .add(postAnnouncementsButton)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
            .add(promoteUserButton))
          .add(layout.createSequentialGroup()
            .add(222, 222, 222)
            .add(graduateCoordinatorTitle)))
        .addContainerGap(260, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(layout.createSequentialGroup()
        .add(22, 22, 22)
        .add(graduateCoordinatorTitle)
        .add(18, 18, 18)
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(postAnnouncementsButton)
          .add(promoteUserButton))
        .add(355, 355, 355))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents
  //This button adds a student user
    private void promoteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_promoteUserButtonActionPerformed
      ArrayList<BasicUser> users = Database.getPotentialUsers();
      //Keep user display up
      new ViewUsersGUI(users).setVisible(true);
    }//GEN-LAST:event_promoteUserButtonActionPerformed

 //This button adds a new announcement to the announcement table
    private void postAnnouncementsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postAnnouncementsButtonActionPerformed
      new AddAnouncementGUI(LoggedInUser).setVisible(true);
      //Keep user display up
    }//GEN-LAST:event_postAnnouncementsButtonActionPerformed

 //This creates the announcement table by looping through the database and adding new announcements
  //to the announcement table retrieve from MongoDB

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel graduateCoordinatorTitle;
  private javax.swing.JButton postAnnouncementsButton;
  private javax.swing.JButton promoteUserButton;
  // End of variables declaration//GEN-END:variables
}
