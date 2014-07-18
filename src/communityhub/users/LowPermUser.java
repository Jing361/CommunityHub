package communityhub.users;

import communityhub.ROLE;

public class LowPermUser extends BasicUser{
  public LowPermUser(String username, char[] password, ROLE role){
    super(username, password, role);
  }
}
