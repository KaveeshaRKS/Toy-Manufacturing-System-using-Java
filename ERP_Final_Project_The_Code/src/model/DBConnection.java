/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VENUSHA
 */
public class DBConnection {
    static Connection conn;
    static Statement stat=null;
    
    public static Statement getStatementConnection(){
        try {
            String url="jdbc:mysql://localhost:3306/erp_final_project";
            conn=(Connection) DriverManager.getConnection(url, "root", "");
            stat=(Statement) conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         return stat;
    }
    public static void closeConn() throws SQLException{
        conn.close();
    }
}
