package communityhub.users;

import communityhub.gui.BasicGui;
import communityhub.DB.Database;
import communityhub.Post;
import java.util.UUID;

public class BasicUser {
  public String username;
  private char[] password;
//  DB connection;

  public BasicUser(String username, char[] password){
    this.username = username;
    this.password = password;
  }
  
  public void SpawnGui(){
    new BasicGui(this);
  }
  
  public UUID newPost(String title, String body){
    return Database.CreatePost(new Post(this.username, title, body));
  }
  
  public boolean editPost(Post oldP, Post newP){
    return Database.editPost(oldP.responseId, newP);
  }
}
