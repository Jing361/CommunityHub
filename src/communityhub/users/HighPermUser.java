package communityhub.users;

import communityhub.Announcement;
import communityhub.DB.Database;
import communityhub.gui.HighPermUserGUI;
import java.util.UUID;

public class HighPermUser extends BasicUser{
  public HighPermUser(String username, char[] password){
    super(username, password);
  }

  public String newAnnouncement(String title, String body){
    return Database.createAnnouncement(new Announcement(this.username, title, body));
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
    return "Admin";
  }
}
