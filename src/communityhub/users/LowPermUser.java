package communityhub.users;

import communityhub.DB.Database;
import communityhub.gui.LowPermUserGUI;

public class LowPermUser extends BasicUser{
  public LowPermUser(String username, char[] password){
    super(username, password);
  }

  @Override
  public LowPermUserGUI SpawnGui(){
    return new LowPermUserGUI(this);
  }

  @Override
  public String toString(){
    return "user";
  }

}
