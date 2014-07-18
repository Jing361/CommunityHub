package communityhub.users;

import communityhub.ROLE;

public class HighPermUser extends BasicUser{
  public HighPermUser(String username, char[] password, ROLE role){
    super(username, password, role);
  }
}
