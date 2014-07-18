package communityhub;

//This class is used to keep track of filenames and their read status
public class FileRec{
  public String filename = "";
  public boolean read = false;

  public FileRec(){
  }

  public FileRec(String filename, boolean read){
    this.filename = filename;
    this.read = read;
  }
/*
  public BasicDBObject toBasicDBObject(){
    BasicDBObject temp = new BasicDBObject();
    temp.put("filename", this.filename);
    temp.put("read", this.read);
    return temp;
  }
  */
}
