package communityhub.users;

import communityhub.Announcement;
import communityhub.DB.Database;
import communityhub.gui.HighPermUserGUI;
import java.util.UUID;

public class HighPermUser extends BasicUser{
  public HighPermUser(String username, char[] password, Database conn){
    super(username, password, conn);
  }

  public UUID newAnnouncement(String title, String body){
    return this.connection.createAnnouncement(new Announcement(this.username, title, body));
  }

  public boolean editAnnouncement(Announcement oldAnn, Announcement newAnn){
    return this.connection.editAnnouncement(oldAnn.announceId, newAnn);
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
