package communityhub;

import java.util.ArrayList;
import java.util.UUID;

public class Post{
  public String author = "";
  public String title = "";
  public String body = "";
  public String postId;// = UUID.randomUUID().toString();
  public Group group;
  //post responding to
  //Should be list of posts?
  public ArrayList<Post> responses = null;

  public Post(String author, String title, String body, Group grp){
    this(author, title, body, grp, (ArrayList<Post>)null);
  }
  
  public Post(String author, String title, String body, Group grp, ArrayList<Post> responseList){
    this(author, title, body, grp, UUID.randomUUID().toString(),responseList);
  }

  public Post(String author, String title, String body, Group grp, String uuid){
    this(author, title, body, grp, uuid, null);
  }
  
  public Post(String author, String title, String body, Group grp, String uuid, ArrayList<Post> responseList){
    this.author = author;
    this.title = title;
    this.body = body;
    this.group = grp;
    this.responses = responseList;
    this.postId = UUID.randomUUID().toString();
  }
}
