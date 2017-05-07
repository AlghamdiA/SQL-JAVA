/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

/**
 *
 * @author kuhail
 */
public class DBManager {
    Connection connection;
    
        public class Record{
        public String ID;
        public String Name;
        //////Alghamdi
        public Record(String ID,String Name){
            this.ID=ID;
            this.Name=Name;
        }
        
        public String toString(){
            return Name;
        }
    }
// To get all categories from database    
 public LinkedList<Record> getCategoryTypes(){
     LinkedList<Record> records=new LinkedList();
         PreparedStatement stmt = null;
        
        String query = "select * FROM categories";

        try {
            stmt=connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            String cat_type_id = rs.getString("Category_ID");
            String CatName = rs.getString("CatName");
            Record record=new Record(cat_type_id,CatName);
            records.add(record);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return records;
        }
        return records;
 }
 
 public void connect(String userName, String password, String serverName, String portNumber, String dbName) throws SQLException, InstantiationException, IllegalAccessException {
        System.out.println("Loading driver...");

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", userName);
        connectionProps.put("password", password);

        conn = DriverManager.getConnection(
                "jdbc:mysql://"
                + serverName
                + ":" + portNumber + "/" + dbName,
                connectionProps);

        System.out.println("Connected to database");
        this.connection=conn;
    }
 
///////////////// Moderator functions /////////////////////////// 
// To get all advertisments of a moderator
 public Object[][] getModraSerchAdvertisements(String text) {
        PreparedStatement stmt = null;
        Object[][] result=new Object[][]{};
        
        String query = "SELECT Advertisement_ID, AdvTitle ,AdvDetails , Price, AdvDateTime, User_ID FROM Advertisements WHERE Moderator_ID IS NULL AND (AdvTitle LIKE ? OR AdvDetails LIKE ?)";

        try {
            stmt=connection.prepareStatement(query);
             //binding the parameter with the given string
            stmt.setString(1,"%"+text+"%");    
            stmt.setString(2,"%"+text+"%");
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            result=getUncliamAdvData(count,rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return result;
        }
        return result;
    
    
    }
 // To check username of users login
  public boolean checkModerator(String Moderator_ID) {
        PreparedStatement stmt = null;
        
        String query = "select * FROM Moderators WHERE Moderator_ID=?";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,Moderator_ID); //binding the parameter with the given string
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            if (count == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }
    
    
 public Object[][] getAdvertisements(String text) {
        PreparedStatement stmt = null;
        Object[][] result=new Object[][]{};
        
        String query = "SELECT AdvTitle ,AdvDetails , Price, AdvDateTime FROM Advertisements WHERE Status_ID = 'AC' AND (AdvTitle LIKE ? OR AdvDetails LIKE ?)";

        try {
            stmt=connection.prepareStatement(query);
             //binding the parameter with the given string
            stmt.setString(1,"%"+text+"%");    
            stmt.setString(2,"%"+text+"%");
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            result=getAlladvData(count,rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return result;
        }
        return result;
    }   
    
 public Object[][] getMyAdvertisements(String user_id) {
        PreparedStatement stmt = null;
        Object[][] result=new Object[][]{};
        
        String query = "SELECT Advertisement_ID, AdvTitle, AdvDetails, Price, Status_Name, AdvDateTime FROM Advertisements A inner join Statuses S on A.Status_ID = S.Status_ID WHERE User_ID = ?";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,user_id); //binding the parameter with the given string
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            result=getMyAdvData(count,rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return result;
        }
        return result;
    }
  // For moderators to add an advertisment under their names 
 public boolean ClaimAdvertisement(String advertisement_id, String user_id) {
        PreparedStatement stmt = null;
        
        String query = "UPDATE Advertisements SET Moderator_ID =? WHERE Advertisement_ID =?";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,user_id);
            stmt.setString(2,advertisement_id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }    
  // To diapprove an Advertisement that user added
 public boolean DisapprovAdvertisement(String advertisement_id) {
        PreparedStatement stmt = null;
        
        String query = "UPDATE Advertisements A SET Status_ID='DI' WHERE Advertisement_ID = ?";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,advertisement_id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }  
  // To approve an Advertisement that user added
 public boolean ApprovAdvertisement(String advertisement_id) {
        PreparedStatement stmt = null;
        
        String query = "UPDATE Advertisements A SET Status_ID='AC' WHERE Advertisement_ID = ?";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,advertisement_id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }    
 // To get Advertisements of the user
  public Object[][] getMyAdvertisements_Moder(String user_id) {
        PreparedStatement stmt = null;
        Object[][] result=new Object[][]{};
        
        
        
        
        String query = "SELECT Advertisement_ID, AdvTitle, AdvDetails, Price, Status_Name, AdvDateTime, User_ID FROM Advertisements A inner join Statuses S on A.Status_ID = S.Status_ID WHERE Moderator_ID = ?";
          


        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,user_id); //binding the parameter with the given string
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            result=getMyModerAdvData(count,rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return result;
        }
        return result;
    }
   // To get unclaim Advertisements of the users
 public Object[][] getUnclaimAdvertisements_Moder() {
        PreparedStatement stmt = null;
        Object[][] result=new Object[][]{};
        
        String query = "SELECT Advertisement_ID, AdvTitle, AdvDetails, Price, AdvDateTime, User_ID FROM Advertisements WHERE Moderator_ID IS NULL";
               

        try {
            stmt=connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            result=getUncliamAdvData(count,rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return result;
        }
        return result;
    }
   
 private Object[][] getUncliamAdvData(int count,ResultSet rs) throws SQLException {
        Object[][] result=new Object[count][6];
        int index=0;
       do {
            String advID = rs.getString("Advertisement_ID");
            String advTitle = rs.getString("AdvTitle");
            String user_id = rs.getString("User_ID");
            String advDetail = rs.getString("AdvDetails");
            String advPrice = rs.getString("Price");
            String advDate = rs.getString("AdvDateTime");
            
            ModerAdvertisments advertisement = new ModerAdvertisments(advID,advTitle,advDetail,advPrice,advDate,user_id);
            result[index++]=advertisement.UnclaimToArray();
        }
       while(rs.next());
        return result;
    }   
 
 ///////////////// user functions ///////////////////////////
 public Object[][] getAllAdvertisements() {
        PreparedStatement stmt = null;
        Object[][] result=new Object[][]{};
        
        

        String query = "SELECT AdvTitle, AdvDetails, Price, AdvDateTime FROM Advertisements where Status_ID = 'AC'";

        try {
            stmt=connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            result=getAlladvData(count,rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return result;
        }
        return result;
    }
   
 private Object[][] getMyAdvData(int count,ResultSet rs) throws SQLException {
        Object[][] result=new Object[count][6];
        int index=0;
       do {
            String advID = rs.getString("Advertisement_ID");
            String advTitle = rs.getString("AdvTitle");
            String advStatus = rs.getString("Status_Name");
            String advDetail = rs.getString("AdvDetails");
            String advPrice = rs.getString("Price");
            String advDate = rs.getString("AdvDateTime");
            
            UserAdvertisements advertisement = new UserAdvertisements(advID, advTitle,advDetail,advPrice,advStatus, advDate);
            result[index++]=advertisement.MytoArray();
        }
       while(rs.next());
        return result;
    } 
   
 private Object[][] getAlladvData(int count,ResultSet rs) throws SQLException {
        Object[][] result=new Object[count][4];
        int index=0;
       do {
            String advTitle = rs.getString("AdvTitle");
            String advDetail = rs.getString("AdvDetails");
            String advPrice = rs.getString("Price");
            String advDate = rs.getString("AdvDateTime");
            
            UserAdvertisements advertisement = new UserAdvertisements(advTitle,advDetail,advPrice,advDate);
            result[index++]=advertisement.toArray();
        }
       while(rs.next());
        return result;
    } 
    // To check username of users login
 public boolean checkUser(String user_id) {
        PreparedStatement stmt = null;
        
        String query = "select * FROM users WHERE user_id=?";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,user_id); //binding the parameter with the given string
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            if (count == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }
  // For a users to delete thier an Advertisements 
 public boolean deleteadvertisement(String advertisement_id, String user_id) {
        PreparedStatement stmt = null;
        
        String query = "DELETE FROM Advertisements WHERE Advertisement_ID = ? AND User_ID =?";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,advertisement_id);
            stmt.setString(2,user_id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    } 
   // For a user to add an Advertisement under his/her account
 public boolean addAdvertisement(String title,String detail,String price,String type_id,String user_id) {
        PreparedStatement stmt = null;   
              
        String query = "insert into Advertisements (AdvTitle, AdvDetails, Price, User_ID, Category_ID) values (?, ?, ?, ?,?)";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,title); //binding the parameter with the given string
            stmt.setString(2,detail);
            stmt.setString(3,price);
            stmt.setString(4,user_id);
            stmt.setString(5,type_id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }  
   // For users to sign up
 public boolean addNewUser(String Fname,String Lname,String Usename) {
        PreparedStatement stmt = null;
     
        
        
        String query = "insert into Users (User_ID,UsrFirst_Name,UsrLast_Name) values (?, ?, ?)";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1,Usename);
            stmt.setString(2,Fname); //binding the parameter with the given string
            stmt.setString(3,Lname);
            
           
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
   
 private int getResultSetSize(ResultSet rs) {
        int count = 0;
        try {
            while (rs.next()) {
                count++;
            }
            rs.first();
        } catch (SQLException e) {

        }
        return count;
    }

   
 private Object[][] getMyModerAdvData(int count,ResultSet rs) throws SQLException {
        Object[][] result=new Object[count][7];

        
        int index=0;
       do {
            String advID = rs.getString("Advertisement_ID");
            String advTitle = rs.getString("AdvTitle");
            String advDetail = rs.getString("AdvDetails");
            String advPrice = rs.getString("Price");
            String advStatus = rs.getString("Status_Name");            
            String advDate = rs.getString("AdvDateTime");
            String username = rs.getString("User_ID");
            
            
            ModerAdvertisments advertisement = new ModerAdvertisments(advID,advTitle,advDetail,advPrice,advStatus,advDate,username);
            result[index++]=advertisement.MytoArray();
        }
       while(rs.next());
        return result;
    } 
}