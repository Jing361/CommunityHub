package communityhub.users;

import communityhub.gui.BasicGUI;
import communityhub.DB.Database;
import communityhub.Post;
import java.util.UUID;

public class BasicUser {
  public String username;
  private char[] password;
  public Database connection = null;

  public BasicUser(String username, char[] password, Database conn){
    this.username = username;
    this.password = password;
    this.connection = conn;
  }
  
  public BasicGUI SpawnGui(){
    return new BasicGUI(this);
  }
  
  public UUID newPost(String title, String body){
    return this.connection.CreatePost(new Post(this.username, title, body));
  }
  
  public boolean editPost(Post oldP, Post newP){
    return this.connection.editPost(oldP.postId, newP);
  }
  
  public String toString(){
    return "BasicUser";
  }
}
