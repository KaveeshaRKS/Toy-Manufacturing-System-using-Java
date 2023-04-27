/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author VENUSHA
 */
public class AddToDB {
    static Statement stmt;
    public static void addCustomerIntoDB(String id, String name, String address, String tel){
    
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.execute("INSERT INTO customer VALUES ('"+id+"', '"+name+"', '"+address+"', '"+tel+"')");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "This ID is already used!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public static void addMaterialIntoDB(String id, String name, String unit, String unitPrice, String avilQty){
    
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.execute("INSERT INTO material VALUES ('"+id+"', '"+name+"', '"+unit+"', '"+unitPrice+"', '"+avilQty+"')");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "This ID is already used!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public static void updateCustomer(String id, String name, String address, String tel){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.executeUpdate("UPDATE customer SET name='"+name+"', address='"+address+"', tel='"+tel+"' WHERE c_id='"+id+"'");
        } catch (SQLException ex) {
            Logger.getLogger(AddToDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void updateMaterial(String id, String name, String unit, String unitP, String qty){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.executeUpdate("UPDATE material SET available_quantity='"+qty+"', unit_price='"+unitP+"' WHERE m_id='"+id+"' AND material_description='"+name+"' AND unit='"+unit+"'");
        } catch (SQLException ex) {
            Logger.getLogger(AddToDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void deleteCustomer(String cus){
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.execute("DELETE FROM customer WHERE c_id='"+cus+"'");
            
            JOptionPane.showMessageDialog(null, "Successfully deleted!", "Alert", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(AddToDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void deleteMaterial(String id){
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.execute("DELETE FROM material WHERE m_id='"+id+"'");
            
            JOptionPane.showMessageDialog(null, "Successfully deleted!", "Alert", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(AddToDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static void addProductIntoDB(String id, String des){
    
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.execute("INSERT INTO product VALUES ('"+id+"', '"+des+"')");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "This ID is already used!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public static void addProductPlanIntoDB(String pid, String mid, int qty){
    
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.execute("INSERT INTO product_planning VALUES ('"+pid+"', '"+mid+"', '"+qty+"')");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "This record is already added!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public static void updateProduct(String id, String des){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.executeUpdate("UPDATE product SET description='"+des+"' WHERE p_id='"+id+"'");
        } catch (SQLException ex) {
            Logger.getLogger(AddToDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void updateProductPlan(String pid, String mid, int qty){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.executeUpdate("UPDATE product_planning SET required_quantity='"+qty+"' WHERE p_id='"+pid+"' AND m_id='"+mid+"'");
        } catch (SQLException ex) {
            Logger.getLogger(AddToDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void updateMaterials1(int x, String mid){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.executeUpdate("UPDATE material SET available_quantity='"+x+"' WHERE m_id='"+mid+"'");
        } catch (SQLException ex) {
            Logger.getLogger(AddToDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void updateMaterials2(int x, String mid){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.executeUpdate("UPDATE material SET available_quantity='"+x+"' WHERE m_id='"+mid+"'");
        } catch (SQLException ex) {
            Logger.getLogger(AddToDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static void deleteProduct(String p){
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.execute("DELETE FROM product WHERE p_id='"+p+"'");
            
            JOptionPane.showMessageDialog(null, "Successfully deleted!", "Alert", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(AddToDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void deleteProductPlan(String pid, String mid){
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.execute("DELETE FROM product_planning WHERE p_id='"+pid+"' AND m_id='"+mid+"'");
            
            JOptionPane.showMessageDialog(null, "Successfully deleted!", "Alert", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(AddToDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static void addOrderIntoDB(String oid, String cid, String pid, int qty, Date date){
    
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.execute("INSERT INTO orders VALUES ('"+oid+"', '"+cid+"', '"+pid+"', '"+qty+"', '"+date+"')");
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
    }
    public static void addMRPIntoDB(String oid, String mid, int qty){
    
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.execute("INSERT INTO mrp VALUES ('"+oid+"', '"+mid+"', '"+qty+"')");
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
    }
    public static void addBoMIntoDB(String oid, String mid, int qty, int price){
    
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.execute("INSERT INTO bom VALUES ('"+oid+"', '"+mid+"', '"+qty+"', '"+price+"')");
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
    }
    public static void updateQty(String oid, String cid, String pid, String q){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.executeUpdate("UPDATE orders SET required_quantity='"+q+"' WHERE order_id='"+oid+"' AND c_id='"+cid+"' AND p_id='"+pid+"'");
        } catch (SQLException ex) {
            Logger.getLogger(AddToDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void deleteOrder(String o){
        try {
            stmt=DBConnection.getStatementConnection();
            
            stmt.execute("DELETE FROM orders WHERE order_id='"+o+"'");
            
            JOptionPane.showMessageDialog(null, "Successfully deleted!", "Alert", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(AddToDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
