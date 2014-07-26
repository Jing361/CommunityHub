package communityhub.users;

import communityhub.DB.Database;
import communityhub.Group;
import communityhub.gui.MidPermUserGUI;
import java.util.ArrayList;

public class MidPermUser extends BasicUser{
  public MidPermUser(String username, char[] password, ArrayList<Group> legal){
    super(username, password, legal);
  }
  
  @Override
  public MidPermUserGUI SpawnGui(){
    return new MidPermUserGUI(this);
  }
  
  public String toString(){
    return "moderator";
  }
}
