package communityhub.DB;

import communityhub.Announcement;
import communityhub.Post;
import communityhub.users.BasicUser;
import communityhub.users.HighPermUser;
import communityhub.users.LowPermUser;
import communityhub.users.MidPermUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

//Some parameters will be changed based on database implementation.
public class Database{
  public static BasicUser lookUp(String username, char[] password){
    String query = "SELECT password,role FROM user WHERE username = '" + username + "';";
    Statement stmt = null;
    ResultSet rs = null;
    BasicUser ret = null;
    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://174.102.54.43/communityhub", "commhubuser", "foobar");
      stmt = conn.createStatement();
      rs = stmt.executeQuery(query);
      String p = new String(password);

      while(rs.next()){
        if(rs.getString("password").equals(p)){
          switch(rs.getString("role")){
          case "admin":
            ret = new HighPermUser(username, password);
          break;
          case "moderator":
            ret = new MidPermUser(username, password);
          break;
          case "user":
            ret = new LowPermUser(username, password);
          break;
          }
        }
      }
      conn.close();
    } catch(Exception ex) {
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ret;
  }

  // given an announcement object, it creates it in the db
  public static String createAnnouncement(Announcement ann){
    return null;
  }

  public static boolean editAnnouncement(String oldID, Announcement newAnn){
    return false;
  }

  public static ArrayList<Announcement> getRecentAnnouncements(){
    return null;
  }

  public static Announcement getAnnouncement(String annID){
    return null;
  }

  public static boolean deleteAnnouncement(String annID){
    return false;
  }

  public static String CreatePost(Post p){
    return null;
  }

  public static boolean editPost(String oldID, Post p){
    return false;
  }

  public static ArrayList<Post> getRecentPosts(BasicUser jim){
    return null;
  }

  public static Post getPost(String postID){
    return null;
  }

  public static boolean deletePost(String postID){
    return false;
  }

  public static boolean changeRole(String username, BasicUser New){
    return false;
  }

  public static ArrayList<BasicUser> getPotentialUsers(){
    //Find list of low and mid perm users
    //Generally to be used for admins to upgrade users to or from mods
    return null;
  }
}
