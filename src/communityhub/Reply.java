package communityhub;

import java.util.ArrayList;
import java.util.UUID;

public class Reply extends Post{
  public String responseId = null;

  public Reply(String author, String title, String body, Group grp){
    super(author, title, body, grp, (ArrayList<Post>)null);
  }
  
  public Reply(String author, String title, String body, Group grp, ArrayList<Post> responseList){
    super(author, title, body, grp, UUID.randomUUID().toString(),responseList);
  }

  public Reply(String author, String title, String body, Group grp, String uuid){
    super(author, title, body, grp, uuid, null);
  }
  
  public Reply(String author, String title, String body, Group grp, String uuid, String replyTo, ArrayList<Post> responseList){
    super(author, title, body, grp, uuid, responseList);
    this.responseId = replyTo;
  }

  public Reply(String author, String title, String body, Group grp, String replyTo, ArrayList<Post> responseList){
    super(author, title, body, grp, responseList);
    this.responseId = replyTo;
  }

  public Reply(String author, String title, String body, Post replyTo, ArrayList<Post> responseList){
    super(author, title, body, replyTo.group, responseList);
    this.responseId = replyTo.postId;
  }
}
