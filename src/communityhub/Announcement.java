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
      super(author, title, body);
  }
  
  public Announcement(String author, String title, String body, ArrayList<Post> responseList){
    super(author, title, body, responseList);
  }

}
