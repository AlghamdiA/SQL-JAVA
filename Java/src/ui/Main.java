/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import db.*;
import javax.swing.JFrame;

/**
 *
 * @author kuhail
 */
public class Main {
    
    
    public static void main(String[] args){
        DBManager DB=new DBManager();
        try{
            
            DB.connect("amav22_1","4Ma3dMq8bsmSUaLd7q4M","kc-sce-appdb01","3306","amav22_1");
            JFrame LoginFrame=new LoginFrame(DB);
            LoginFrame.setVisible(true);
        }
        catch(Exception e){
            
        }
    }
}
/*


Username: 
amav22_1
 
DB name:
amav22_1
 
Password:
4Ma3dMq8bsmSUaLd7q4M 

 Host: kc-sce-appdb01
 
 


*/
