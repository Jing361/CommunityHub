package communityhub.gui;

import communityhub.DB.Database;
import communityhub.Post;
import communityhub.users.BasicUser;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewThreadGUI extends javax.swing.JFrame{
  BasicUser user;
  Post parent;

  public ViewThreadGUI(Post parentIn, BasicUser userIn){
    //creates the thread gui so that it is aware of the current user and the parent query for this thread
    user = userIn; //sets the attributes
    parent = parentIn;

    initComponents();

    //places data from the parent in the text box
    ParentLabel.setText(parent.author);
    parentTextArea.setText(parent.body);

    for(int i = 0; i < parent.responses.size(); i++){
      //creates tabs for each reply to the parent, populating the tab with the reply contents
      String postID = parent.responses.get(i);
      this.user.connection.getPost(postID);
      Post replyPost = Post.toPost();
      JComponent temp = makeTextPanel(replyPost.body);

      replyTabbedPane.addTab(replyPost.author + ": " + replyPost.title, null, temp, "Show Reply #" + (i + 1));
    }
    replyTabbedPane.setSelectedIndex(0);//initial
    setVisible(true);
  }

  private ViewThreadGUI(){
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

    ParentLabel = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    parentTextArea = new javax.swing.JTextArea();
    ReplyLabel = new javax.swing.JLabel();
    replyTabbedPane = new javax.swing.JTabbedPane();
    cancelButton = new javax.swing.JButton();
    replyButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    ParentLabel.setText("Parent");

    parentTextArea.setColumns(20);
    parentTextArea.setRows(5);
    jScrollPane1.setViewportView(parentTextArea);

    ReplyLabel.setText("Replies");

    cancelButton.setText("Cancel");
    cancelButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelButtonActionPerformed(evt);
      }
    });

    replyButton.setText("Reply to Parent");
    replyButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        replyButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(replyButton)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(cancelButton))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(replyTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(ParentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(ReplyLabel)))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(ParentLabel)
        .addGap(18, 18, 18)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(ReplyLabel)
        .addGap(18, 18, 18)
        .addComponent(replyTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cancelButton)
          .addComponent(replyButton))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
      this.dispose();//closes the current thread view
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void replyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replyButtonActionPerformed
      //creates prompt to create a reply to the currently viewed parent query
      AddPostGUI replyGUI = new AddPostGUI(parent, user);//creates a new postGUI to create a new post that will be replying to the parent
      replyGUI.setVisible(true);
    }//GEN-LAST:event_replyButtonActionPerformed

  protected JComponent makeTextPanel(String text){
    //creates and returns a text panel to be placed in the reply tabs
    JPanel panel = new JPanel(false);
    JLabel filler = new JLabel(text);

    filler.setHorizontalAlignment(JLabel.LEFT);
    filler.setVerticalAlignment(JLabel.TOP);
    panel.setLayout(new GridLayout(1, 1));
    panel.add(filler);

    return panel;
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel ParentLabel;
  private javax.swing.JLabel ReplyLabel;
  private javax.swing.JButton cancelButton;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea parentTextArea;
  private javax.swing.JButton replyButton;
  private javax.swing.JTabbedPane replyTabbedPane;
  // End of variables declaration//GEN-END:variables
}