package communityhub.users;

import communityhub.DB.Database;
import communityhub.Group;
import communityhub.Post;
import communityhub.gui.BasicGUI;
import java.util.ArrayList;

public class BasicUser {
  public String username;
  private char[] password;
  public ArrayList<Group> legalGroups;
  public Group activeGroup;

  public BasicUser(String username, char[] password, ArrayList<Group> legal){
    this.username = username;
    this.password = password;
    this.legalGroups = legal;
    this.activeGroup = legal.get(0);
  }
  
  public BasicGUI SpawnGui(){
    return new BasicGUI(this);
  }
  
  public String newPost(String title, String body){
    return Database.CreatePost(new Post(this.username, title, body, activeGroup));
  }
  
  public boolean editPost(Post oldP, Post newP){
    return Database.editPost(oldP.postId, newP);
  }
  
  public String toString(){
    return "BasicUser";
  }
}
