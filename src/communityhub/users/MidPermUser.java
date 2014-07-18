package communityhub.users;

import communityhub.gui.BasicGUI;
import communityhub.gui.MidPermUserGUI;

public class MidPermUser extends BasicUser{
  public MidPermUser(String username, char[] password){
    super(username, password);
  }
  
  @Override
  public MidPermUserGUI SpawnGui(){
    return new MidPermUserGUI(this);
  }
  
  public String toString(){
    return "Moderator";
  }
}
