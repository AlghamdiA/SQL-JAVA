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
public class ModerAdvertisments {
    private String ID;
    private String Status;
    private String AdvTitle;
    private String AdvDetails;
    private String Price;
    private String AdvDateTime;
    private String Username;
    
    
    public ModerAdvertisments(String ID, String AdvTitle,String AdvDetails,String Price, String AdvDateTime, String Username){
        this.ID=ID;
        this.Username = Username;
        this.AdvTitle=AdvTitle;
        this.AdvDetails=AdvDetails;
        this.Price=Price;
        this.AdvDateTime=AdvDateTime;
    }
    
    
    
    public ModerAdvertisments(String ID, String AdvTitle,String AdvDetails,String Price,String Status, String AdvDateTime, String Username){
        this.ID=ID;
        this.Status=Status;
        this.Username = Username;
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
    
    public String getUsername(){
        return Username;
    }
    
    Object[] UnclaimToArray(){
        return new Object[]{ID,AdvTitle,AdvDetails,Price,AdvDateTime,Username};
    }   
    
    Object[] MytoArray(){
        return new Object[]{ID,AdvTitle,AdvDetails,Price,Status,AdvDateTime,Username};
    }   
    
    
    
    
}
