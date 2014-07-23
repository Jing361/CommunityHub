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
  Connection conn = null;

  public Database() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    this.conn = DriverManager.getConnection("jdbc:mysql://174.102.54.43/communityhub", "commhubuser", "foobar");
/*
    String query = "SELECT * from user;";
    Statement stmt = this.conn.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    while(rs.next()){
      System.out.print(rs.getString("username"));
      System.out.print("\t");
      System.out.print(rs.getString("password"));
      System.out.print("\t");
      System.out.print(rs.getString("role"));
      System.out.print("\n");
    }
*/
  }
  
  public void close() throws SQLException{
    this.conn.close();
  }
  
  public BasicUser lookUp(String username, char[] password){
    String query = "SELECT password,role FROM user WHERE username = '" + username + "';";
    Statement stmt = null;
    ResultSet rs = null;
    BasicUser ret = null;

    try {
      stmt = this.conn.createStatement();
      rs = stmt.executeQuery(query);
      String p = new String(password);

      while(rs.next()){
        if(rs.getString("password").equals(p)){
          switch(rs.getString("role")){
          case "admin":
            ret = new HighPermUser(username, password, this);
          break;
          case "moderator":
            ret = new MidPermUser(username, password, this);
          break;
          case "user":
            ret = new LowPermUser(username, password, this);
          break;
          }
        }
      }
    } catch(SQLException ex) {
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ret;
  }

  // given an announcement object, it creates it in the db
  public UUID createAnnouncement(Announcement ann){
    return null;
  }

  public boolean editAnnouncement(UUID oldID, Announcement newAnn){
    return false;
  }

  public ArrayList<Announcement> getRecentAnnouncements(){
    return null;
  }

  public Announcement getAnnouncement(String annID){
    return null;
  }

  public boolean deleteAnnouncement(String annID){
    return false;
  }

  public UUID CreatePost(Post p){
    return null;
  }

  public boolean editPost(UUID oldID, Post p){
    return false;
  }

  public ArrayList<Post> getRecentPosts(BasicUser jim){
    return null;
  }

  public Post getPost(String postID){
    return null;
  }

  public boolean deletePost(UUID postID){
    return false;
  }

  public boolean changeRole(String username, BasicUser New){
    return false;
  }

  public ArrayList<BasicUser> getPotentialUsers(){
    //Find list of low and mid perm users
    //Generally to be used for admins to upgrade users to or from mods
    return null;
  }
}
