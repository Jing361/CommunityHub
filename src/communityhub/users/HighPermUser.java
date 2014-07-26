package communityhub.users;

import communityhub.Announcement;
import communityhub.DB.Database;
import communityhub.Group;
import communityhub.gui.HighPermUserGUI;
import java.util.ArrayList;

public class HighPermUser extends BasicUser{
  public HighPermUser(String username, char[] password, ArrayList<Group> legal){
    super(username, password, legal);
  }

  public String newAnnouncement(String title, String body, Group grp){
    return Database.createAnnouncement(new Announcement(this.username, title, body, grp));
  }

  public boolean editAnnouncement(Announcement oldAnn, Announcement newAnn){
    return Database.editAnnouncement(oldAnn.postId, newAnn);
  }

  @Override
  public HighPermUserGUI SpawnGui(){
    return new HighPermUserGUI(this);
  }

  @Override
  public String toString(){
    return "admin";
  }
}
