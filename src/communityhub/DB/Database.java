package communityhub.DB;

import communityhub.Announcement;
import communityhub.Group;
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
import java.util.logging.Level;
import java.util.logging.Logger;

//Some parameters will be changed based on database implementation.
//Need to prevent intentional and accidental SQL injection, and those types of errors
public class Database{
  public static BasicUser lookUp(String username, char[] password){
    BasicUser ret = null;
    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://174.102.54.43/communityhub", "commhubuser", "foobar");
      String query = "SELECT password,role FROM user WHERE username='" + username + "';";
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);

      String pswd = new String(password);
      String role = rs.getString("role");
      ArrayList<Group> legal = new ArrayList<>();
      
      query = "SELECT comm FROM commuser WHERE member='" + username + "';";
      stmt = conn.createStatement();
      rs = stmt.executeQuery(query);
      while(rs.next()){
        legal.add(new Group(rs.getString("comm")));
      }
      
      if(rs.getString("password").equals(pswd)){
        switch(rs.getString("role")){
        case "admin":
          ret = new HighPermUser(username, password, legal);
        break;
        case "moderator":
          ret = new MidPermUser(username, password, legal);
        break;
        case "user":
          ret = new LowPermUser(username, password, legal);
        break;
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
      
      String query = "INSERT INTO post(author,title,body,UUID,type,community) VALUES('" + ann.author + "','" + ann.title + "','" + ann.body + "','" + ann.postId + "','announcement','public');";
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
      String query = "SELECT author,title,body,community,UUID FROM post WHERE type='announcement' and community='public';";
      Statement stmt = conn.createStatement();
      rs = stmt.executeQuery(query);

      while(rs.next()){
        ret.add(new Announcement(rs.getString("author"), rs.getString("title"), rs.getString("body"), new Group(rs.getString("community")), rs.getString("UUID")));
      }

      conn.close();
    } catch(SQLException ex) {
      System.out.print("ERROR:");
      System.out.println(ex.getMessage());
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }

    return ret;
  }
  
  public static ArrayList<Announcement> getRecentAnnouncements(BasicUser user){
    ArrayList<Announcement> ret = new ArrayList<>();
    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://174.102.54.43/communityhub", "commhubuser", "foobar");
      
      ResultSet rs = null;
      String query = "SELECT DISTINCT P.author,P.title,P.body,P.community,P.UUID "
                   + "FROM post P, commuser CU "
                   + "WHERE P.type='announcement AND P.community=CU.comm AND CU.member='" + user.username + "';";
      Statement stmt = conn.createStatement();
      rs = stmt.executeQuery(query);

      while(rs.next()){
        ret.add(new Announcement(rs.getString("author"), rs.getString("title"), rs.getString("body"), new Group(rs.getString("community")), rs.getString("UUID")));
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
      String query = "SELECT author,title,body,community,UUID FROM post WHERE UUID='" + annID + "';";
      Statement stmt = conn.createStatement();
      rs = stmt.executeQuery(query);
      
      while(rs.next()){
        ret = new Announcement(rs.getString("author"), rs.getString("title"), rs.getString("body"), new Group(rs.getString("community")), rs.getString("UUID"));
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
      
      String query = "INSERT INTO post(author,title,body,UUID,type) VALUES('" + p.author + "','" + p.title + "','" + p.body + "','" + p.postId + "','post');";
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
    ArrayList<Post> ret = new ArrayList<>();
    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://174.102.54.43/communityhub", "commhubuser", "foobar");
      
      ResultSet rs = null;
      String query = "SELECT author,title,body,community,UUID FROM post WHERE type='post';";
      Statement stmt = conn.createStatement();
      rs = stmt.executeQuery(query);

      while(rs.next()){
        ret.add(new Announcement(rs.getString("author"), rs.getString("title"), rs.getString("body"), new Group(rs.getString("community")), rs.getString("UUID")));
      }

      conn.close();
    } catch(SQLException ex) {
      System.out.print("ERROR:");
      System.out.println(ex.getMessage());
      Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
    }

    return ret;
  }

  public static Post getPost(String postID){
    Post ret = null;
    try {
      Connection conn = DriverManager.getConnection("jdbc:mysql://174.102.54.43/communityhub", "commhubuser", "foobar");
      
      ResultSet rs = null;
      String query = "SELECT author,title,body,community,UUID FROM post WHERE UUID='" + postID + "';";
      Statement stmt = conn.createStatement();
      rs = stmt.executeQuery(query);
      
      while(rs.next()){
        ret = new Announcement(rs.getString("author"), rs.getString("title"), rs.getString("body"), new Group(rs.getString("community")), rs.getString("UUID"));
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
