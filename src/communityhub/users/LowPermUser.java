package communityhub.users;

import communityhub.DB.Database;
import communityhub.gui.LowPermUserGUI;

public class LowPermUser extends BasicUser{
  public LowPermUser(String username, char[] password, Database conn){
    super(username, password, conn);
  }

  @Override
  public LowPermUserGUI SpawnGui(){
    return new LowPermUserGUI(this);
  }
}
