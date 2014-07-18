package communityhub.users;

import communityhub.DB.Database;
import communityhub.Announcement;
import java.util.UUID;

public class HighPermUser extends BasicUser{
  public HighPermUser(String username, char[] password){
    super(username, password);
  }
  
  public UUID newAnnouncement(String title, String body){
    return Database.createAnnouncement(new Announcement(this.username, title, body));
  }
  
  public boolean editAnnouncement(Announcement oldAnn, Announcement newAnn){
    return Database.editAnnouncement(oldAnn.announceId, newAnn);
  }
}
