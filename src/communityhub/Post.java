package communityhub;

import java.util.ArrayList;
import java.util.UUID;

public class Post{
  public String author = "";
  public String title = "";
  public String body = "";
  public UUID postId;// = UUID.randomUUID().toString();
  //post responding to
  //should be type post?
  public UUID responseId = null;
  //Should be list of posts?
  public ArrayList<String> responses = null;

  public Post(){
  }

  public Post(String author, String title, String body, UUID postId, UUID responseId, ArrayList<String> responseList){
    this.author = author;
    this.title = title;
    this.body = body;
    this.responses = responseList;
    if(postId != null){
      this.postId = postId;
    } else {
      this.postId = UUID.randomUUID();
    }
    this.responseId = responseId;
  }

  public Post(String author, String title, String body){
    this.author = author;
    this.title = title;
    this.body = body;
    this.responses = null;
    this.postId = UUID.randomUUID();
    this.responseId = responseId;
  }

  
/*
  public BasicDBObject toBasicDBObject(){
    BasicDBObject mappedObj = new BasicDBObject();
    mappedObj.append("author", author);
    mappedObj.append("title", title);
    mappedObj.append("body", body);
    mappedObj.append("postId", postId);
    mappedObj.append("responseId", responseId);
    mappedObj.append("roleIndex", roleIndex);
    ArrayList<UUID> responses = new ArrayList<>();
    mappedObj.append("responses", responses);

    return mappedObj;
  }
*/
/*
  public static Post toPost(DBObject obj){
    return new Post(obj.get("author").toString(), obj.get("title").toString(), obj.get("body").toString(), obj.get("postId").toString(), obj.get("responseId").toString(), (ArrayList<String>) obj.get("responses"), (int) obj.get("roleIndex"));
  }
*/
}
