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
    String query = "SELECT password,role FROM user WHERE username='" + username + "';";
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
      System.out.print("ERROR:");
      System.out.println(ex.getMessage());
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ret;
  }

  // given an announcement object, it creates it in the db
  public static String createAnnouncement(Announcement ann){
    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://174.102.54.43/communityhub", "commhubuser", "foobar");
      
      String query = "INSERT INTO post(author,title,body,UUID,type) VALUES('" + ann.author + "','" + ann.title + "','" + ann.body + "','" + ann.postId + "','announcement');";
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(query);
      
      conn.close();
    } catch(SQLException ex) {
      System.out.print("ERROR:");
      System.out.println(ex.getMessage());
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  public static boolean editAnnouncement(String oldID, Announcement newAnn){
    boolean ret = true;
    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://174.102.54.43/communityhub", "commhubuser", "foobar");
      
      String query = "UPDATE post SET body='" + newAnn.body + "' WHERE UUID='" + oldID + "';";
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(query);
      
      conn.close();
    } catch(SQLException ex) {
      System.out.print("ERROR:");
      System.out.println(ex.getMessage());
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
      //Assume failure
      ret = false;
    }
    return ret;
  }

  public static ArrayList<Announcement> getRecentAnnouncements(){
    ArrayList<Announcement> ret = new ArrayList<Announcement>();
    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://174.102.54.43/communityhub", "commhubuser", "foobar");
      
      ResultSet rs = null;
      String query = "SELECT author,title,body,UUID FROM post WHERE type='announcement';";
      Statement stmt = conn.createStatement();
      rs = stmt.executeQuery(query);

      while(rs.next()){
        ret.add(new Announcement(rs.getString("author"), rs.getString("title"), rs.getString("body"), rs.getString("UUID")));
      }

      conn.close();
    } catch(SQLException ex) {
      System.out.print("ERROR:");
      System.out.println(ex.getMessage());
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }

    return ret;
  }

  public static Announcement getAnnouncement(String annID){
    Announcement ret = null;
    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://174.102.54.43/communityhub", "commhubuser", "foobar");
      
      ResultSet rs = null;
      String query = "SELECT author,title,body,UUID FROM post WHERE UUID='" + annID + "';";
      Statement stmt = conn.createStatement();
      rs = stmt.executeQuery(query);
      
      while(rs.next()){
        ret = new Announcement(rs.getString("author"), rs.getString("title"), rs.getString("body"), rs.getString("UUID"));
      }
      
      conn.close();
    } catch(SQLException ex) {
      System.out.print("ERROR:");
      System.out.println(ex.getMessage());
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return ret;
  }

  public static boolean deleteAnnouncement(String annID){
    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://174.102.54.43/communityhub", "commhubuser", "foobar");
      
      String query = "DELETE FROM post WHERE UUID='" + annID + "';";
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(query);
      
      conn.close();
    } catch(SQLException ex) {
      System.out.print("ERROR:");
      System.out.println(ex.getMessage());
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return true;
  }

  public static String CreatePost(Post p){
    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://174.102.54.43/communityhub", "commhubuser", "foobar");
      
      String query = "INSERT INTO post(author,title,body,UUID,type) VALUES('" + p.author + "','" + p.title + "','" + p.body + "','" + p.postId + "'post');";
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(query);
      
      conn.close();
    } catch(SQLException ex) {
      System.out.print("ERROR:");
      System.out.println(ex.getMessage());
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  public static boolean editPost(String oldID, Post p){
    boolean ret = true;
    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://174.102.54.43/communityhub", "commhubuser", "foobar");
      
      String query = "UPDATE post SET body='" + p.body + "'WHERE UUID='" + oldID + "';";
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(query);
      
      conn.close();
    } catch(SQLException ex) {
      System.out.print("ERROR:");
      System.out.println(ex.getMessage());
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
      //Assume failure
      ret = false;
    }
    return ret;
  }

  public static ArrayList<Post> getRecentPosts(BasicUser jim){
    return null;
  }

  public static Post getPost(String postID){
    Post ret = null;
    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://174.102.54.43/communityhub", "commhubuser", "foobar");
      
      ResultSet rs = null;
      String query = "SELECT author,title,body,UUID FROM post WHERE UUID='" + postID + "';";
      Statement stmt = conn.createStatement();
      rs = stmt.executeQuery(query);
      
      while(rs.next()){
        ret = new Announcement(rs.getString("author"), rs.getString("title"), rs.getString("body"), rs.getString("UUID"));
      }
      
      conn.close();
    } catch(SQLException ex) {
      System.out.print("ERROR:");
      System.out.println(ex.getMessage());
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return ret;
  }

  public static boolean deletePost(String postID){
    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://174.102.54.43/communityhub", "commhubuser", "foobar");
      
      String query = "DELETE FROM post where UUID='" + postID + "';";
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(query);
      
      conn.close();
    } catch(SQLException ex) {
      System.out.print("ERROR:");
      System.out.println(ex.getMessage());
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }    
    return true;
  }

  public static boolean changeRole(String username, BasicUser New){
    boolean ret = true;
    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://174.102.54.43/communityhub", "commhubuser", "foobar");
      
      String query = "UPDATE user SET role='" + New.toString() + "' WHERE username='" + username + "';";
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(query);
      
      conn.close();
    } catch(SQLException ex) {
      System.out.print("ERROR:");
      System.out.println(ex.getMessage());
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
      //Assume failure
      ret = false;
    }
    return ret;
  }

  public static ArrayList<BasicUser> getPotentialUsers(){
    //Find list of low and mid perm users
    //Generally to be used for admins to upgrade users to or from mods
    return null;
  }
}
