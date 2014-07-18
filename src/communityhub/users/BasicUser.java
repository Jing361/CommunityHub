package communityhub.users;

import communityhub.ROLE;

public class BasicUser {
  String username;
  private char[] password;
  ROLE role;
//  DB connection;

  public BasicUser(String username, char[] password, ROLE role){
    this.username = username;
    this.password = password;
    this.role = role;
  }
}
