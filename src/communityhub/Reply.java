package communityhub;

import java.util.ArrayList;
import java.util.UUID;

public class Reply extends Post{
  public String responseId = null;

  public Reply(String author, String title, String body){
    super(author, title, body);
  }

  public Reply(String author, String title, String body, String replyTo, ArrayList<Post> responseList){
    super(author, title, body, responseList);
    this.responseId = replyTo;
  }

  
  public Reply(String author, String title, String body, Post replyTo, ArrayList<Post> responseList){
    super(author, title, body, responseList);
    this.responseId = replyTo.postId;
  }
}
