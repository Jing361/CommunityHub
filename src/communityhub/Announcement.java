package communityhub;

import java.util.ArrayList;
import java.util.UUID;

public class Announcement extends Post{
  public Announcement(String author, String title, String body, Group grp){
    super(author, title, body, grp, (ArrayList<Post>)null);
  }
  
  public Announcement(String author, String title, String body, Group grp, ArrayList<Post> responseList){
    super(author, title, body, grp, UUID.randomUUID().toString(),responseList);
  }

  public Announcement(String author, String title, String body, Group grp, String uuid){
    super(author, title, body, grp, uuid, null);
  }
  
  public Announcement(String author, String title, String body, Group grp, String uuid, ArrayList<Post> responseList){
    super(author, title, body, grp, uuid, responseList);
  }
}
