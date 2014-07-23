package communityhub.users;

import communityhub.DB.Database;
import communityhub.gui.BasicGUI;
import communityhub.gui.MidPermUserGUI;

public class MidPermUser extends BasicUser{
  public MidPermUser(String username, char[] password, Database conn){
    super(username, password, conn);
  }
  
  @Override
  public MidPermUserGUI SpawnGui(){
    return new MidPermUserGUI(this);
  }
  
  public String toString(){
    return "Moderator";
  }
}
