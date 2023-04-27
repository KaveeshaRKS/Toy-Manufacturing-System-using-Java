/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author VENUSHA
 */
public class DBSearch {
    ResultSet rs=null;
    Statement stmt;
    public ResultSet searchCustomers(){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            rs=stmt.executeQuery("SELECT c_id FROM customer");
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet searchMaterials(){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            rs=stmt.executeQuery("SELECT m_id FROM material");
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet searchMaterials2(String pid){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            rs=stmt.executeQuery("SELECT m_id FROM product_planning WHERE p_id='"+pid+"'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }
    public ResultSet searchPPlanQty(String pid, String mid){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            rs=stmt.executeQuery("SELECT required_quantity FROM product_planning WHERE p_id='"+pid+"' AND m_id='"+mid+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet searchOneCustomer(String id){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            rs=stmt.executeQuery("SELECT * FROM customer WHERE c_id='"+id+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet searchOneMaterial(String id){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            rs=stmt.executeQuery("SELECT * FROM material WHERE m_id='"+id+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet searchOneMaterialQuantityPerOrder(String oid, String mid){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            rs=stmt.executeQuery("SELECT SUM(P.required_quantity) AS sum FROM product_planning P, orders O WHERE O.order_id='"+oid+"' AND P.p_id=O.p_id AND P.m_id='"+mid+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
     public ResultSet searchProduct(){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            rs=stmt.executeQuery("SELECT p_id FROM product");
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet searchForecasting(String pid){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            rs=stmt.executeQuery("SELECT SUM(required_quantity) AS sum, EXTRACT(YEAR_MONTH FROM date) month FROM orders WHERE p_id='"+pid+"' GROUP BY month ORDER BY month DESC");
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet searchProductForForecasting(){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            rs=stmt.executeQuery("SELECT p_id FROM orders GROUP BY p_id");
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
     public ResultSet searchOneProduct(String id){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            rs=stmt.executeQuery("SELECT * FROM product WHERE p_id='"+id+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet searchOrders(){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            rs=stmt.executeQuery("SELECT order_id FROM orders GROUP BY order_id");
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet searchMaterialsPerOrder(String oid){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            rs=stmt.executeQuery("SELECT P.m_id FROM product_planning P, orders O WHERE O.order_id='"+oid+"' AND P.p_id=O.p_id GROUP BY P.m_id");
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet searchPProduct(){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            rs=stmt.executeQuery("SELECT p_id FROM orders GROUP BY p_id");
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet searchOneOrderBaseOnCustomer(String id){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            rs=stmt.executeQuery("SELECT c_id FROM orders WHERE order_id='"+id+"' GROUP BY order_id");
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet searchOneOrderBaseOnProduct(String id){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            rs=stmt.executeQuery("SELECT p_id FROM orders WHERE order_id='"+id+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet searchQtyPerOrder(String oid, String cid, String pid){
        
        try {
            stmt=DBConnection.getStatementConnection();
            
            rs=stmt.executeQuery("SELECT required_quantity, date FROM orders WHERE order_id='"+oid+"' AND c_id='"+cid+"' AND p_id='"+pid+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
