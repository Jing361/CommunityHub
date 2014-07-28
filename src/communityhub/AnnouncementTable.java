package communityhub;

import java.util.ArrayList;

public class AnnouncementTable extends javax.swing.JTable{
  public ArrayList<Announcement> announcements = null;

  public AnnouncementTable(ArrayList<Announcement> ann){
    super();
    this.announcements = ann;

    this.setModel(new javax.swing.table.AbstractTableModel(){
      @Override
      public int getRowCount(){
        return announcements.size();
      }

      @Override
      public int getColumnCount(){
        return 3;
      }

      @Override
      public Object getValueAt(int rowIndex, int columnIndex){
          String temp = null;
          switch (columnIndex)
          {
            case 0:
            temp = announcements.get(rowIndex).author;
            break;
            case 1:
            temp = announcements.get(rowIndex).title;
            break;
            case 2:
            temp = announcements.get(rowIndex).body;
            break;
          }
          return temp;
      }
      
      public void setValueAt(String val, int i, int j)
        {
          switch (j)
          {
            case 1:
            announcements.get(i).author = val;
            break;
            case 2:
            announcements.get(i).title = val;
            break;
            case 3:
            announcements.get(i).body = val;
            break;
          }
        }

    });
    
    this.getColumnModel().getColumn(0).setHeaderValue("Author");
    this.getColumnModel().getColumn(1).setHeaderValue("Title");
    this.getColumnModel().getColumn(2).setHeaderValue("Body");

    if(ann != null){
      for(int i = 0; i < ann.size(); i++){
        this.setValueAt(ann.get(i).author, i, 0);
        this.setValueAt(ann.get(i).title, i, 1);
        this.setValueAt(ann.get(i).body, i, 2);
      }
    }
  }
}
