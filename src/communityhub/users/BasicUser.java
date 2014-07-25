package communityhub.users;

import communityhub.gui.BasicGUI;
import communityhub.DB.Database;
import communityhub.Post;
import java.util.UUID;

public class BasicUser {
  public String username;
  private char[] password;

  public BasicUser(String username, char[] password){
    this.username = username;
    this.password = password;
  }
  
  public BasicGUI SpawnGui(){
    return new BasicGUI(this);
  }
  
  public String newPost(String title, String body){
    return Database.CreatePost(new Post(this.username, title, body));
  }
  
  public boolean editPost(Post oldP, Post newP){
    return Database.editPost(oldP.postId, newP);
  }
  
  public String toString(){
    return "BasicUser";
  }
}
