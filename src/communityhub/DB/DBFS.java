package communityhub.DB;

import communityhub.FileRec;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DBFS{
  // path to download the files to
  private static String path = System.getenv("APPDATA") + "\\HelpDesk\\";

  public static String upperCase(String str){
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }

  // this function assumes the filepath looks like C:\Users\Download\...\file.pdf
  public static String generateNewFileName(String filePath, String username){
    String[] dirPath = filePath.split("\\\\");
    String[] file;

    // Ex: file.pdf
    // nameNoType = file
    // ext = pdf
    // newName = StevenFilePdf
    String nameNoType = "";
    String ext = "";
    String newName = "";

    file = dirPath[dirPath.length - 1].split("\\.");
    nameNoType = upperCase(file[0]);
    ext = upperCase(file[1]);
    newName = username + upperCase(nameNoType) + upperCase(ext);

    return newName;
  }

  // This function saves a file record with the attributes as listed in the parameters
  public static boolean saveFileRecord(String filename, boolean readStatus, String collect){
    boolean success = false;
    return success;
  }
  /*
  // Retrieves a file record given the file name and what collection to look in
  public static BasicDBObject retrieveFileRecord(String filename, String collection){
    return null;
  }
  */
  // this function finds the db object with the given filename, and changes 
  // the read status to true

  public static boolean updateFileRecord(String filename, String collection){
    boolean success = false;
    return success;
  }
  // stores a file in mongo given the filepath and the username of the user
  // who submitted it

  public static String saveFile(File fileObj, String username, String collection){
    return null;
  }
  // this function retrives and opens a given file

  public static boolean retrieveFile(String newFileName, String collection){
    boolean success = false;
    return success;
  }

  // retrives all documents in the db given a collection and db connection
  public static ArrayList<FileRec> retrieveAllDocs(String collect){
    ArrayList<FileRec> fileRecs = new ArrayList();
    return fileRecs;
  }
}
