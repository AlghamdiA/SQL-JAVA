/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author NoWay
 */
public class UserAdvertisements {
    private String ID;
    private String Status;
    private String AdvTitle;
    private String AdvDetails;
    private String Price;
    private String AdvDateTime;
    private String user_id;
    public UserAdvertisements(String AdvTitle,String AdvDetails,String Price, String AdvDateTime){
        this.ID=ID;
        this.Status = Status;
        this.AdvTitle=AdvTitle;
        this.AdvDetails=AdvDetails;
        this.Price=Price;
        this.AdvDateTime=AdvDateTime;
        
    }
     
    public UserAdvertisements(String ID, String AdvTitle,String AdvDetails,String Price,String Status, String AdvDateTime){
        this.ID=ID;
        this.Status = Status;
        this.AdvTitle=AdvTitle;
        this.AdvDetails=AdvDetails;
        this.Price=Price;
        this.AdvDateTime=AdvDateTime;
        
    }
    
        
    
    
    public String getStatus(){
        return Status;
    }
    
    public String getID(){
        return ID;
    }
    
    public String getAdvTitle(){
        return AdvTitle;
    }
    
    public String getAdvDetails(){
        return AdvDetails;
    }
    
    public String getPrice(){
        return Price;
    }
    
    public String getAdvDateTime(){
        return AdvDateTime;
    }
    
    
    
    Object[] toArray(){
        return new Object[]{AdvTitle,AdvDetails,Price,AdvDateTime};
    }   
    
    Object[] MytoArray(){
        return new Object[]{ID,AdvTitle,AdvDetails,Price,Status,AdvDateTime};
    }   
    
    
}
