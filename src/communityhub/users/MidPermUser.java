package communityhub.users;

import communityhub.ROLE;

public class MidPermUser extends BasicUser{
  public MidPermUser(String username, char[] password, ROLE role){
    super(username, password, role);
  }
}
