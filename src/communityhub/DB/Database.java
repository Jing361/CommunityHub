/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package communityhub.DB;

import communityhub.Announcement;
import communityhub.Post;
import communityhub.users.BasicUser;
import java.util.ArrayList;
import java.util.UUID;

//Some parameters will be changed based on database implementation.
public class Database{
  public static BasicUser lookUp(String username, char[] password){
    return null;
  }
  // given an announcement object, it creates it in the db

  public static UUID createAnnouncement(Announcement ann){
    return null;
  }

  public static boolean editAnnouncement(UUID oldID, Announcement newAnn){
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

  public static UUID CreatePost(Post p){
    return null;
  }

  public static boolean editPost(UUID oldID, Post p){
    return false;
  }

  public static ArrayList<Post> getRecentPosts(){
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
