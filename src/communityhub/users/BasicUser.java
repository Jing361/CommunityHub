package communityhub.users;

import communityhub.gui.BasicGui;

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
}
