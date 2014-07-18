package communityhub;

import java.util.UUID;

//Maybe should inherit from post?
public class Announcement{
  public String author;
  public String title;
  public String body;
  public UUID announceId;

  public Announcement(String author, String title, String body){
    this.author = author;
    this.title = title;
    this.body = body;
    this.announceId = UUID.randomUUID();
  }

  public Announcement(String author, String title, String body, UUID announceId){
    this.author = author;
    this.title = title;
    this.body = body;
    this.announceId = announceId;
  }
/*  
  // easily converts an announcement object to db object to store
  public BasicDBObject toBasicDBOBject(){
    BasicDBObject result = new BasicDBObject();

    result.put("author", this.author);
    result.put("title", this.title);
    result.put("body", this.body);
    result.put("announceId", this.announceId);

    return result;
  }
*/
/*
  // converts a db object into an announcement
  public static Announcement fromDBObject(DBObject a){
    String author = a.get("author").toString();
    String title = a.get("title").toString();
    String body = a.get("body").toString();
    String announceId = a.get("announceId").toString();

    Announcement announcement = new Announcement(author, title, body, announceId);

    return announcement;
  }
 */
}
