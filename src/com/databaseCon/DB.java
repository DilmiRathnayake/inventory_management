/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.databaseCon;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;

/**
 *
 * @author WEBSHOP LANKA
 */
public class DB {
    
    public static Connection con = null;
    
    public static void loadConnection(){
        String url = "jdbc:mysql://localhost:3306/storage_management";
        String root = "root";
        String pass = "";
        
        try{
            con = DriverManager.getConnection(url, root , pass);
            
            if(con != null){
              //JOptionPane.showMessageDialog(null, "Database connected");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "error  in database " + e);
        }
    }
}
