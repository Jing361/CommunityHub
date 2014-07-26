package communityhub.users;

import communityhub.DB.Database;
import communityhub.Group;
import communityhub.gui.LowPermUserGUI;
import java.util.ArrayList;

public class LowPermUser extends BasicUser{
  public LowPermUser(String username, char[] password, ArrayList<Group> legal){
    super(username, password, legal);
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
