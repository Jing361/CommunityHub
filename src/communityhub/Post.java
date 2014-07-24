package communityhub;

import java.util.ArrayList;
import java.util.UUID;

public class Post{
  public String author = "";
  public String title = "";
  public String body = "";
  public String postId;// = UUID.randomUUID().toString();
  //post responding to
  //Should be list of posts?
  public ArrayList<Post> responses = null;

  public Post(String author, String title, String body){
    this(author, title, body, null);
  }
  
  public Post(String author, String title, String body, ArrayList<Post> responseList){
    this.author = author;
    this.title = title;
    this.body = body;
    this.responses = responseList;
    this.postId = UUID.randomUUID().toString();
  }
}
