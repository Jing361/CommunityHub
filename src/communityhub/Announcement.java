package communityhub;

import java.util.ArrayList;
import java.util.UUID;

//Maybe should inherit from post?
/**
 *
 * @author Chris
 */
public class Announcement extends Post{
  public Announcement(String author, String title, String body){
    super(author, title, body, (ArrayList<Post>)null);
  }
  
  public Announcement(String author, String title, String body, ArrayList<Post> responseList){
    super(author, title, body, UUID.randomUUID().toString(), responseList);
  }

  public Announcement(String author, String title, String body, String uuid){
    super(author, title, body, uuid, null);
  }
  
  public Announcement(String author, String title, String body, String uuid, ArrayList<Post> responseList){
    super(author, title, body, uuid, responseList);
  }
}
