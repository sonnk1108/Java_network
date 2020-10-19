package Model;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nxlam
 */
public class IO {
    public static Connection conn;
    
    public static void connect(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CheckApp", "root", "");
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    public static void close(){
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
