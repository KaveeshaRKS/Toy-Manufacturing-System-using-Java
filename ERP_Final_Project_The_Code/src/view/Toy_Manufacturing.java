/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.DatePicker;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.AddToDB;
import model.DBSearch;

/**
 *
 * @author VENUSHA
 */
public class Toy_Manufacturing extends javax.swing.JFrame {
    int x=0;
    /**
     * Creates new form Toy_Manufacturing
     */
    public Toy_Manufacturing() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        c_idCBLoader();
        p_idCBLoader();
        o_idCBLoader();
        m_idCBLoader();
        pP_idCBLoader();
        p_idCBLoaderForForecasting();
        
        customerIDCB2.removeAllItems();
        productIDCB2.removeAllItems();
        
        jpCustomers.setVisible(false);
        jpProducts.setVisible(false);
        jpOrderPlacing.setVisible(false);
        jpRowMaterials.setVisible(false);
        jpProductPlanning.setVisible(false);
        jpMRP.setVisible(false);
        jpBoM.setVisible(false);
        jpIssues.setVisible(false);
        jpReceives.setVisible(false);
        jpMovingAvg.setVisible(false);
        jpWeightedMovingAvg.setVisible(false);
        
        jpLogin.setVisible(true);
        
        customersBtn.setBackground(Color.DARK_GRAY);
        loginBtn.setBackground(Color.white);
        productsBtn.setBackground(Color.DARK_GRAY);
        orderPlacingBtn.setBackground(Color.DARK_GRAY);
        rowMaterialsBtn.setBackground(Color.DARK_GRAY);
        productPlanningBtn.setBackground(Color.DARK_GRAY);
        mrpBtn.setBackground(Color.DARK_GRAY);
        bomBtn.setBackground(Color.DARK_GRAY);
        issuesBtn.setBackground(Color.DARK_GRAY);
        receivesBtn.setBackground(Color.DARK_GRAY);
        movingAvgBtn.setBackground(Color.DARK_GRAY);
        weightedMovingAvgBtn.setBackground(Color.DARK_GRAY);
        
        
        customersBtn.setForeground(Color.white);
        loginBtn.setForeground(Color.BLACK);
        productsBtn.setForeground(Color.white);
        orderPlacingBtn.setForeground(Color.white);
        rowMaterialsBtn.setForeground(Color.white);
        productPlanningBtn.setForeground(Color.white);
        mrpBtn.setForeground(Color.white);
        bomBtn.setForeground(Color.white);
        issuesBtn.setForeground(Color.white);
        receivesBtn.setForeground(Color.white);
        movingAvgBtn.setForeground(Color.white);
        weightedMovingAvgBtn.setForeground(Color.white);
      
        
        customersBtn.setEnabled(false);
        loginBtn.setEnabled(true);
        productsBtn.setEnabled(false);
        orderPlacingBtn.setEnabled(false);
        rowMaterialsBtn.setEnabled(false);
        productPlanningBtn.setEnabled(false);
        mrpBtn.setEnabled(false);
        bomBtn.setEnabled(false);
        issuesBtn.setEnabled(false);
        receivesBtn.setEnabled(false);
        movingAvgBtn.setEnabled(false);
        weightedMovingAvgBtn.setEnabled(false);
      
    }
    public void c_idCBLoader(){
        
        try {
            ResultSet rs=new DBSearch().searchCustomers();
            
            while(rs.next()){
                
                customerIDCB.addItem(Integer.toString(rs.getInt("c_id")));
            }
            clearFields();
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void m_idCBLoader(){
        
        try {
            ResultSet rs=new DBSearch().searchMaterials();
            
            while(rs.next()){
                
                midCB.addItem(Integer.toString(rs.getInt("m_id")));
                receivesMIDCB.addItem(Integer.toString(rs.getInt("m_id")));
                
            }
            clearFields();
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void c_idCB2Loader(){
        customerIDCB2.removeAllItems();
        try {
            ResultSet rs=new DBSearch().searchCustomers();
            
            while(rs.next()){
                
                customerIDCB2.addItem(Integer.toString(rs.getInt("c_id")));
            }
            clearFields();
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void p_idCBLoader(){
        
        try {
            ResultSet rs=new DBSearch().searchProduct();
            
            while(rs.next()){
              
                productIDCB.addItem(Integer.toString(rs.getInt("p_id")));
            }
            clearFields();
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void p_idCBLoaderForForecasting(){
        
        try {
            ResultSet rs=new DBSearch().searchProductForForecasting();
            
            while(rs.next()){
              
                avgPIDCB.addItem(Integer.toString(rs.getInt("p_id")));
                avgPIDCB1.addItem(Integer.toString(rs.getInt("p_id")));
            }
            clearFields();
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void p_idCB2Loader(){
        productIDCB2.removeAllItems();
        try {
            ResultSet rs=new DBSearch().searchProduct();
            
            while(rs.next()){
              
                productIDCB2.addItem(Integer.toString(rs.getInt("p_id")));
            }
            clearFields();
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void o_idCBLoader(){
        
        try {
            ResultSet rs=new DBSearch().searchOrders();
            
            while(rs.next()){
              
                orderIDCB.addItem(Integer.toString(rs.getInt("order_id")));
                mrpOrderIDCB.addItem(Integer.toString(rs.getInt("order_id")));
                bomOrderIDCB1.addItem(Integer.toString(rs.getInt("order_id")));
                issuesOrderIDCB1.addItem(Integer.toString(rs.getInt("order_id")));
            }
            clearFields();
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void pP_idCBLoader(){
        
        try {
            ResultSet rs=new DBSearch().searchPProduct();
            
            while(rs.next()){
              
                pProductIDCB.addItem(Integer.toString(rs.getInt("p_id")));
            }
            clearFields();
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void o_idCBLoader2(){
        orderIDCB.removeAllItems();
        try {
            ResultSet rs=new DBSearch().searchOrders();
            
            while(rs.next()){
              
                orderIDCB.addItem(Integer.toString(rs.getInt("order_id")));
            }
            clearFields();
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void clearFields(){
        usernameTF.setText("");
        passwordPF.setText("");
        nameTF.setText("");
        addressTF.setText("");
        telTF.setText("");
        descriptionTF.setText("");
        nameLbl.setText("");
        addressLbl.setText("");
        telLbl.setText("");
        descriptionLbl.setText("");
        requiredQtyTF.setText("");
        mDescTF.setText("");
        unitPriceTF.setText("");
        availQtyTF.setText("");
        pProductDescLbl.setText("");
        pMaterialNameLbl.setText("");
        pMaterialUnitLbl.setText("");
        pMaterialUPriceLbl.setText("");
        pMaterialAvailQtyLbl.setText("");
        pRequiredQtyTF.setText("");
        mMIDNameLbl.setText("");
        mrpMIDUnitLbl.setText("");
        mrpMUnitPriceLbl.setText("");
        mrpMAvailQtyLbl.setText("");
        mrpRequiredQtyTF.setText("");
        bomMIDNameLbl1.setText("");
        bomMIDUnitLbl1.setText("");
        bomMUnitPriceLbl1.setText("");
        bomMAvailQtyLbl1.setText("");
        bomRequiredQtyTF1.setText("");
        bomTotalPriceTF.setText("");
        issuesMIDNameLbl1.setText("");
        issuesMIDUnitLbl1.setText("");
        issuesMUnitPriceLbl1.setText("");
        issuesMAvailQtyLbl1.setText("");
        issuesRequiredQtyTF1.setText("");
        receivesQtyTF.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        loginBtn = new javax.swing.JButton();
        productsBtn = new javax.swing.JButton();
        orderPlacingBtn = new javax.swing.JButton();
        rowMaterialsBtn = new javax.swing.JButton();
        mrpBtn = new javax.swing.JButton();
        bomBtn = new javax.swing.JButton();
        issuesBtn = new javax.swing.JButton();
        receivesBtn = new javax.swing.JButton();
        movingAvgBtn = new javax.swing.JButton();
        weightedMovingAvgBtn = new javax.swing.JButton();
        productPlanningBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        customersBtn = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jpCustomers = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        addressTF = new javax.swing.JTextField();
        telTF = new javax.swing.JTextField();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        customerIDCB = new javax.swing.JComboBox<>();
        jpProducts = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        productIDCB = new javax.swing.JComboBox<>();
        descriptionTF = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        update2Btn = new javax.swing.JButton();
        delete2Btn = new javax.swing.JButton();
        jpOrderPlacing = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        orderIDCB = new javax.swing.JComboBox<>();
        customerIDCB2 = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        productIDCB2 = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        descriptionLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        addressLbl = new javax.swing.JLabel();
        telLbl = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        requiredQtyTF = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        addBtn3 = new javax.swing.JButton();
        deleteBtn3 = new javax.swing.JButton();
        updateBtn3 = new javax.swing.JButton();
        newBtn = new javax.swing.JButton();
        dateDP = new com.toedter.calendar.JDateChooser();
        existingBtn = new javax.swing.JButton();
        jpRowMaterials = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        midCB = new javax.swing.JComboBox<>();
        mDescTF = new javax.swing.JTextField();
        unitCB = new javax.swing.JComboBox<>();
        unitPriceTF = new javax.swing.JTextField();
        availQtyTF = new javax.swing.JTextField();
        mAddBtn = new javax.swing.JButton();
        mUpdateBtn = new javax.swing.JButton();
        mDeleteBtn = new javax.swing.JButton();
        jpProductPlanning = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        pProductDescLbl = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        pMaterialNameLbl = new javax.swing.JLabel();
        pMaterialUnitLbl = new javax.swing.JLabel();
        pMaterialUPriceLbl = new javax.swing.JLabel();
        pMaterialAvailQtyLbl = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        pProductIDCB = new javax.swing.JComboBox<>();
        pMaterialIDCB = new javax.swing.JComboBox<>();
        pRequiredQtyTF = new javax.swing.JTextField();
        pAddBtn = new javax.swing.JButton();
        pUpdateBtn = new javax.swing.JButton();
        pDeleteBtn = new javax.swing.JButton();
        ppNewBtn = new javax.swing.JButton();
        ppExistingBtn = new javax.swing.JButton();
        jpMRP = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        mrpOrderIDCB = new javax.swing.JComboBox<>();
        mrpMIDCB = new javax.swing.JComboBox<>();
        mMIDNameLbl = new javax.swing.JLabel();
        mrpMIDUnitLbl = new javax.swing.JLabel();
        mrpMUnitPriceLbl = new javax.swing.JLabel();
        mrpMAvailQtyLbl = new javax.swing.JLabel();
        mrpRequiredQtyTF = new javax.swing.JTextField();
        mrpSaveBtn = new javax.swing.JButton();
        jpReceives = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        receivesMIDCB = new javax.swing.JComboBox<>();
        receivesQtyTF = new javax.swing.JTextField();
        receivesSaveBtn = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        receivesMIDQtyLbl = new javax.swing.JLabel();
        jpMovingAvg = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        avgPIDCB = new javax.swing.JComboBox<>();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        month1Lbl = new javax.swing.JLabel();
        month2Lbl = new javax.swing.JLabel();
        month3Lbl = new javax.swing.JLabel();
        qty1Lbl = new javax.swing.JLabel();
        qty2Lbl = new javax.swing.JLabel();
        qty3Lbl = new javax.swing.JLabel();
        forecastBtn = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        nextMonthLbl = new javax.swing.JLabel();
        jpLogin = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        usernameTF = new javax.swing.JTextField();
        passwordPF = new javax.swing.JPasswordField();
        departmentCB = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        jpBoM = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        bomOrderIDCB1 = new javax.swing.JComboBox<>();
        bomMIDCB1 = new javax.swing.JComboBox<>();
        bomMIDNameLbl1 = new javax.swing.JLabel();
        bomMIDUnitLbl1 = new javax.swing.JLabel();
        bomMUnitPriceLbl1 = new javax.swing.JLabel();
        bomMAvailQtyLbl1 = new javax.swing.JLabel();
        bomRequiredQtyTF1 = new javax.swing.JTextField();
        bomSaveBtn1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        bomTotalPriceTF = new javax.swing.JTextField();
        jpIssues = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        issuesOrderIDCB1 = new javax.swing.JComboBox<>();
        issuesMIDCB1 = new javax.swing.JComboBox<>();
        issuesMIDNameLbl1 = new javax.swing.JLabel();
        issuesMIDUnitLbl1 = new javax.swing.JLabel();
        issuesMUnitPriceLbl1 = new javax.swing.JLabel();
        issuesMAvailQtyLbl1 = new javax.swing.JLabel();
        issuesRequiredQtyTF1 = new javax.swing.JTextField();
        issueBtn1 = new javax.swing.JButton();
        jpWeightedMovingAvg = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        avgPIDCB1 = new javax.swing.JComboBox<>();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        month1Lbl1 = new javax.swing.JLabel();
        month2Lbl1 = new javax.swing.JLabel();
        month3Lbl1 = new javax.swing.JLabel();
        qty1Lbl1 = new javax.swing.JLabel();
        qty2Lbl1 = new javax.swing.JLabel();
        qty3Lbl1 = new javax.swing.JLabel();
        forecastBtn1 = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        nextMonthLbl1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        weight1TF = new javax.swing.JTextField();
        weight2TF = new javax.swing.JTextField();
        weight3TF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        loginBtn.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        productsBtn.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        productsBtn.setText("Products");
        productsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsBtnActionPerformed(evt);
            }
        });

        orderPlacingBtn.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        orderPlacingBtn.setText("Order Placing");
        orderPlacingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderPlacingBtnActionPerformed(evt);
            }
        });

        rowMaterialsBtn.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        rowMaterialsBtn.setText("Row Materials");
        rowMaterialsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rowMaterialsBtnActionPerformed(evt);
            }
        });

        mrpBtn.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        mrpBtn.setText("MRP");
        mrpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mrpBtnActionPerformed(evt);
            }
        });

        bomBtn.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        bomBtn.setText("BoM");
        bomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bomBtnActionPerformed(evt);
            }
        });

        issuesBtn.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        issuesBtn.setText("Issues");
        issuesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuesBtnActionPerformed(evt);
            }
        });

        receivesBtn.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        receivesBtn.setText("Receives");
        receivesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receivesBtnActionPerformed(evt);
            }
        });

        movingAvgBtn.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        movingAvgBtn.setText("Moving Average");
        movingAvgBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movingAvgBtnActionPerformed(evt);
            }
        });

        weightedMovingAvgBtn.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        weightedMovingAvgBtn.setText("Weighted Moving Average");
        weightedMovingAvgBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weightedMovingAvgBtnActionPerformed(evt);
            }
        });

        productPlanningBtn.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        productPlanningBtn.setText("Product Planning");
        productPlanningBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productPlanningBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 34)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 102));
        jLabel1.setText("Toys");

        customersBtn.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        customersBtn.setText("Customers");
        customersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rowMaterialsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mrpBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bomBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(issuesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(receivesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(movingAvgBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(weightedMovingAvgBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
            .addComponent(productsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(customersBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(productPlanningBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(orderPlacingBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orderPlacingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rowMaterialsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productPlanningBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mrpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(issuesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(receivesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movingAvgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(weightedMovingAvgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpCustomers.setPreferredSize(new java.awt.Dimension(312, 680));
        jpCustomers.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 0));
        jLabel2.setText("CUSTOMERS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(46, 0, 0, 0);
        jpCustomers.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel3.setText("Customer ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(53, 21, 0, 0);
        jpCustomers.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel4.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 21, 0, 0);
        jpCustomers.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel5.setText("Address");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 21, 0, 0);
        jpCustomers.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel6.setText("Tel.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 21, 0, 0);
        jpCustomers.add(jLabel6, gridBagConstraints);

        nameTF.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        nameTF.setPreferredSize(new java.awt.Dimension(141, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 21;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 135;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 42, 0, 0);
        jpCustomers.add(nameTF, gridBagConstraints);

        addressTF.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        addressTF.setPreferredSize(new java.awt.Dimension(141, 40));
        addressTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 21;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 135;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 42, 0, 0);
        jpCustomers.add(addressTF, gridBagConstraints);

        telTF.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        telTF.setPreferredSize(new java.awt.Dimension(141, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 21;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 135;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 42, 0, 0);
        jpCustomers.add(telTF, gridBagConstraints);

        updateBtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        updateBtn.setText("UPDATE");
        updateBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        updateBtn.setMaximumSize(new java.awt.Dimension(96, 35));
        updateBtn.setMinimumSize(new java.awt.Dimension(96, 35));
        updateBtn.setPreferredSize(new java.awt.Dimension(96, 35));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(56, 18, 257, 0);
        jpCustomers.add(updateBtn, gridBagConstraints);

        deleteBtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        deleteBtn.setMaximumSize(new java.awt.Dimension(96, 35));
        deleteBtn.setMinimumSize(new java.awt.Dimension(96, 35));
        deleteBtn.setPreferredSize(new java.awt.Dimension(96, 35));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(56, 18, 257, 1);
        jpCustomers.add(deleteBtn, gridBagConstraints);

        saveBtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        saveBtn.setText("SAVE");
        saveBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        saveBtn.setMaximumSize(new java.awt.Dimension(96, 35));
        saveBtn.setMinimumSize(new java.awt.Dimension(96, 35));
        saveBtn.setPreferredSize(new java.awt.Dimension(96, 35));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = -13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(56, 0, 257, 0);
        jpCustomers.add(saveBtn, gridBagConstraints);

        customerIDCB.setEditable(true);
        customerIDCB.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        customerIDCB.setPreferredSize(new java.awt.Dimension(141, 40));
        customerIDCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                customerIDCBItemStateChanged(evt);
            }
        });
        customerIDCB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                customerIDCBFocusGained(evt);
            }
        });
        customerIDCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerIDCBMouseClicked(evt);
            }
        });
        customerIDCB.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                customerIDCBInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        customerIDCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIDCBActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 21;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(46, 42, 0, 0);
        jpCustomers.add(customerIDCB, gridBagConstraints);

        jpProducts.setPreferredSize(new java.awt.Dimension(312, 680));
        jpProducts.setLayout(new java.awt.GridBagLayout());

        jLabel7.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 0));
        jLabel7.setText("PRODUCTS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(47, 2, 0, 0);
        jpProducts.add(jLabel7, gridBagConstraints);

        jLabel22.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel22.setText("Product ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(45, 54, 0, 0);
        jpProducts.add(jLabel22, gridBagConstraints);

        jLabel23.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel23.setText("Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(81, 54, 0, 0);
        jpProducts.add(jLabel23, gridBagConstraints);

        productIDCB.setEditable(true);
        productIDCB.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        productIDCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productIDCBActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 18, 0, 0);
        jpProducts.add(productIDCB, gridBagConstraints);

        descriptionTF.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        descriptionTF.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 145;
        gridBagConstraints.ipady = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(47, 18, 0, 0);
        jpProducts.add(descriptionTF, gridBagConstraints);

        addBtn.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        addBtn.setText("ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(92, 26, 256, 0);
        jpProducts.add(addBtn, gridBagConstraints);

        update2Btn.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        update2Btn.setText("UPDATE");
        update2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update2BtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(92, 8, 256, 0);
        jpProducts.add(update2Btn, gridBagConstraints);

        delete2Btn.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        delete2Btn.setText("DELETE");
        delete2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete2BtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(92, 18, 256, 10);
        jpProducts.add(delete2Btn, gridBagConstraints);

        jpOrderPlacing.setPreferredSize(new java.awt.Dimension(312, 680));
        jpOrderPlacing.setLayout(new java.awt.GridBagLayout());

        jLabel8.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 0));
        jLabel8.setText("ORDER PLACING");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(56, 3, 0, 0);
        jpOrderPlacing.add(jLabel8, gridBagConstraints);

        jLabel24.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel24.setText("OrderID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(39, 159, 0, 0);
        jpOrderPlacing.add(jLabel24, gridBagConstraints);

        jLabel25.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel25.setText("Customer ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 159, 0, 0);
        jpOrderPlacing.add(jLabel25, gridBagConstraints);

        orderIDCB.setEditable(true);
        orderIDCB.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        orderIDCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderIDCBActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 1, 0, 0);
        jpOrderPlacing.add(orderIDCB, gridBagConstraints);

        customerIDCB2.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        customerIDCB2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerIDCB2MouseClicked(evt);
            }
        });
        customerIDCB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIDCB2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 23;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 1, 0, 0);
        jpOrderPlacing.add(customerIDCB2, gridBagConstraints);

        jLabel26.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel26.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jpOrderPlacing.add(jLabel26, gridBagConstraints);

        jLabel27.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel27.setText("Address");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 5, 0, 0);
        jpOrderPlacing.add(jLabel27, gridBagConstraints);

        jLabel28.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel28.setText("Tel.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 0, 0);
        jpOrderPlacing.add(jLabel28, gridBagConstraints);

        jLabel32.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel32.setText("Product ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 159, 0, 0);
        jpOrderPlacing.add(jLabel32, gridBagConstraints);

        productIDCB2.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        productIDCB2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productIDCB2MouseClicked(evt);
            }
        });
        productIDCB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productIDCB2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 23;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 1, 0, 0);
        jpOrderPlacing.add(productIDCB2, gridBagConstraints);

        jLabel33.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel33.setText("Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 4, 0, 0);
        jpOrderPlacing.add(jLabel33, gridBagConstraints);

        descriptionLbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        descriptionLbl.setText("jLabel34");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 1, 0, 0);
        jpOrderPlacing.add(descriptionLbl, gridBagConstraints);

        nameLbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        nameLbl.setText("jLabel35");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 1, 0, 0);
        jpOrderPlacing.add(nameLbl, gridBagConstraints);

        addressLbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        addressLbl.setText("jLabel35");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 1, 0, 0);
        jpOrderPlacing.add(addressLbl, gridBagConstraints);

        telLbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        telLbl.setText("jLabel35");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 1, 0, 0);
        jpOrderPlacing.add(telLbl, gridBagConstraints);

        jLabel38.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel38.setText("Required Quantity");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 159, 0, 0);
        jpOrderPlacing.add(jLabel38, gridBagConstraints);

        requiredQtyTF.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        requiredQtyTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requiredQtyTFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 113;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jpOrderPlacing.add(requiredQtyTF, gridBagConstraints);

        jLabel39.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel39.setText("Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 159, 0, 0);
        jpOrderPlacing.add(jLabel39, gridBagConstraints);

        addBtn3.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        addBtn3.setText("ADD");
        addBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 130, 147, 0);
        jpOrderPlacing.add(addBtn3, gridBagConstraints);

        deleteBtn3.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        deleteBtn3.setText("DELETE");
        deleteBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtn3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 10, 147, 0);
        jpOrderPlacing.add(deleteBtn3, gridBagConstraints);

        updateBtn3.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        updateBtn3.setText("UPDATE");
        updateBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtn3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 3, 147, 0);
        jpOrderPlacing.add(updateBtn3, gridBagConstraints);

        newBtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        newBtn.setText("New");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 45;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 6, 0, 0);
        jpOrderPlacing.add(newBtn, gridBagConstraints);

        dateDP.setDateFormatString("yyyy-MM-dd");
        dateDP.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 21;
        gridBagConstraints.ipadx = 63;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 5, 0, 0);
        jpOrderPlacing.add(dateDP, gridBagConstraints);

        existingBtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        existingBtn.setText("Existing");
        existingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                existingBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 46;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 2, 0, 0);
        jpOrderPlacing.add(existingBtn, gridBagConstraints);

        jpRowMaterials.setPreferredSize(new java.awt.Dimension(312, 680));
        jpRowMaterials.setLayout(new java.awt.GridBagLayout());

        jLabel9.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 0));
        jLabel9.setText("ROW MATERIALS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(65, 15, 0, 0);
        jpRowMaterials.add(jLabel9, gridBagConstraints);

        jLabel29.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel29.setText("Row Material ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(39, 9, 0, 0);
        jpRowMaterials.add(jLabel29, gridBagConstraints);

        jLabel30.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel30.setText("Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 9, 0, 0);
        jpRowMaterials.add(jLabel30, gridBagConstraints);

        jLabel31.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel31.setText("Unit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 9, 0, 0);
        jpRowMaterials.add(jLabel31, gridBagConstraints);

        jLabel34.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel34.setText("Unit Price");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 9, 0, 0);
        jpRowMaterials.add(jLabel34, gridBagConstraints);

        jLabel35.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel35.setText("Available Qty");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 9, 0, 0);
        jpRowMaterials.add(jLabel35, gridBagConstraints);

        midCB.setEditable(true);
        midCB.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        midCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midCBActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -23;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 14, 0, 15);
        jpRowMaterials.add(midCB, gridBagConstraints);

        mDescTF.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 95;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 0, 0);
        jpRowMaterials.add(mDescTF, gridBagConstraints);

        unitCB.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        unitCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kg", "l", "m" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 14, 0, 0);
        jpRowMaterials.add(unitCB, gridBagConstraints);

        unitPriceTF.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 95;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 14, 0, 0);
        jpRowMaterials.add(unitPriceTF, gridBagConstraints);

        availQtyTF.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 95;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 14, 0, 0);
        jpRowMaterials.add(availQtyTF, gridBagConstraints);

        mAddBtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        mAddBtn.setText("ADD");
        mAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAddBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(43, 0, 235, 0);
        jpRowMaterials.add(mAddBtn, gridBagConstraints);

        mUpdateBtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        mUpdateBtn.setText("UPDATE");
        mUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mUpdateBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(43, 5, 235, 0);
        jpRowMaterials.add(mUpdateBtn, gridBagConstraints);

        mDeleteBtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        mDeleteBtn.setText("DELETE");
        mDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mDeleteBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(43, 6, 235, 0);
        jpRowMaterials.add(mDeleteBtn, gridBagConstraints);

        jpProductPlanning.setPreferredSize(new java.awt.Dimension(312, 680));
        jpProductPlanning.setLayout(new java.awt.GridBagLayout());

        jLabel10.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 0));
        jLabel10.setText("PRODUCT PLANNING");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(47, 122, 0, 0);
        jpProductPlanning.add(jLabel10, gridBagConstraints);

        jLabel36.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel36.setText("Product ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 55, 0, 0);
        jpProductPlanning.add(jLabel36, gridBagConstraints);

        jLabel37.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel37.setText("Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 100, 0, 0);
        jpProductPlanning.add(jLabel37, gridBagConstraints);

        pProductDescLbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        pProductDescLbl.setText("jLabel40");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 79;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 10, 0, 0);
        jpProductPlanning.add(pProductDescLbl, gridBagConstraints);

        jLabel41.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel41.setText("Material ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 55, 0, 0);
        jpProductPlanning.add(jLabel41, gridBagConstraints);

        jLabel42.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel42.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 98, 0, 0);
        jpProductPlanning.add(jLabel42, gridBagConstraints);

        jLabel43.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel43.setText("Unit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 98, 0, 0);
        jpProductPlanning.add(jLabel43, gridBagConstraints);

        jLabel44.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel44.setText("Unit Price");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 98, 0, 0);
        jpProductPlanning.add(jLabel44, gridBagConstraints);

        jLabel45.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel45.setText("Avail. Qty");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 98, 0, 0);
        jpProductPlanning.add(jLabel45, gridBagConstraints);

        pMaterialNameLbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        pMaterialNameLbl.setText("jLabel46");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 79;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        jpProductPlanning.add(pMaterialNameLbl, gridBagConstraints);

        pMaterialUnitLbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        pMaterialUnitLbl.setText("jLabel47");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 79;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        jpProductPlanning.add(pMaterialUnitLbl, gridBagConstraints);

        pMaterialUPriceLbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        pMaterialUPriceLbl.setText("jLabel48");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 79;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        jpProductPlanning.add(pMaterialUPriceLbl, gridBagConstraints);

        pMaterialAvailQtyLbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        pMaterialAvailQtyLbl.setText("jLabel49");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 79;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        jpProductPlanning.add(pMaterialAvailQtyLbl, gridBagConstraints);

        jLabel50.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel50.setText("Required Qty.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 55, 0, 0);
        jpProductPlanning.add(jLabel50, gridBagConstraints);

        pProductIDCB.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        pProductIDCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pProductIDCBActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 10, 0, 0);
        jpProductPlanning.add(pProductIDCB, gridBagConstraints);

        pMaterialIDCB.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        pMaterialIDCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pMaterialIDCBMouseClicked(evt);
            }
        });
        pMaterialIDCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pMaterialIDCBActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 98;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        jpProductPlanning.add(pMaterialIDCB, gridBagConstraints);

        pRequiredQtyTF.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 123;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        jpProductPlanning.add(pRequiredQtyTF, gridBagConstraints);

        pAddBtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        pAddBtn.setText("ADD");
        pAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pAddBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 84, 225, 0);
        jpProductPlanning.add(pAddBtn, gridBagConstraints);

        pUpdateBtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        pUpdateBtn.setText("UPDATE");
        pUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pUpdateBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 10, 225, 0);
        jpProductPlanning.add(pUpdateBtn, gridBagConstraints);

        pDeleteBtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        pDeleteBtn.setText("DELETE");
        pDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pDeleteBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 18, 225, 0);
        jpProductPlanning.add(pDeleteBtn, gridBagConstraints);

        ppNewBtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        ppNewBtn.setText("New");
        ppNewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppNewBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 6, 0, 0);
        jpProductPlanning.add(ppNewBtn, gridBagConstraints);

        ppExistingBtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        ppExistingBtn.setText("Existing");
        ppExistingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppExistingBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 6, 0, 27);
        jpProductPlanning.add(ppExistingBtn, gridBagConstraints);

        jpMRP.setPreferredSize(new java.awt.Dimension(312, 680));
        jpMRP.setLayout(new java.awt.GridBagLayout());

        jLabel11.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 0));
        jLabel11.setText("MRP");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 0, 0, 0);
        jpMRP.add(jLabel11, gridBagConstraints);

        jLabel40.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel40.setText("Order ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 31, 0, 0);
        jpMRP.add(jLabel40, gridBagConstraints);

        jLabel46.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel46.setText("Material ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(42, 31, 0, 0);
        jpMRP.add(jLabel46, gridBagConstraints);

        jLabel47.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel47.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 83, 0, 0);
        jpMRP.add(jLabel47, gridBagConstraints);

        jLabel48.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel48.setText("Unit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 83, 0, 0);
        jpMRP.add(jLabel48, gridBagConstraints);

        jLabel49.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel49.setText("Unit Price");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 83, 0, 0);
        jpMRP.add(jLabel49, gridBagConstraints);

        jLabel51.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel51.setText("Avail. Qty");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 83, 0, 0);
        jpMRP.add(jLabel51, gridBagConstraints);

        jLabel52.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel52.setText("Required Qty");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 31, 0, 0);
        jpMRP.add(jLabel52, gridBagConstraints);

        mrpOrderIDCB.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        mrpOrderIDCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mrpOrderIDCBActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 14, 0, 23);
        jpMRP.add(mrpOrderIDCB, gridBagConstraints);

        mrpMIDCB.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        mrpMIDCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mrpMIDCBMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 14, 0, 23);
        jpMRP.add(mrpMIDCB, gridBagConstraints);

        mMIDNameLbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        mMIDNameLbl.setText("jLabel53");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 81;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 0, 23);
        jpMRP.add(mMIDNameLbl, gridBagConstraints);

        mrpMIDUnitLbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        mrpMIDUnitLbl.setText("jLabel54");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 81;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 0, 23);
        jpMRP.add(mrpMIDUnitLbl, gridBagConstraints);

        mrpMUnitPriceLbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        mrpMUnitPriceLbl.setText("jLabel55");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 23);
        jpMRP.add(mrpMUnitPriceLbl, gridBagConstraints);

        mrpMAvailQtyLbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        mrpMAvailQtyLbl.setText("jLabel56");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 23);
        jpMRP.add(mrpMAvailQtyLbl, gridBagConstraints);

        mrpRequiredQtyTF.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 125;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 14, 0, 23);
        jpMRP.add(mrpRequiredQtyTF, gridBagConstraints);

        mrpSaveBtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        mrpSaveBtn.setText("SAVE");
        mrpSaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mrpSaveBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(49, 12, 230, 0);
        jpMRP.add(mrpSaveBtn, gridBagConstraints);

        jpReceives.setPreferredSize(new java.awt.Dimension(312, 680));
        jpReceives.setLayout(new java.awt.GridBagLayout());

        jLabel14.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 0));
        jLabel14.setText("RECEIVES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(64, 106, 0, 0);
        jpReceives.add(jLabel14, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel13.setText("Material ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 53, 0, 0);
        jpReceives.add(jLabel13, gridBagConstraints);

        jLabel69.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel69.setText("Quantity");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 53, 0, 0);
        jpReceives.add(jLabel69, gridBagConstraints);

        receivesMIDCB.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        receivesMIDCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receivesMIDCBActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 93;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 28, 0, 23);
        jpReceives.add(receivesMIDCB, gridBagConstraints);

        receivesQtyTF.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 118;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 28, 0, 23);
        jpReceives.add(receivesQtyTF, gridBagConstraints);

        receivesSaveBtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        receivesSaveBtn.setText("ADD");
        receivesSaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receivesSaveBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(47, 106, 353, 0);
        jpReceives.add(receivesSaveBtn, gridBagConstraints);

        jLabel17.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel17.setText("Avail. Qty");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 81, 0, 0);
        jpReceives.add(jLabel17, gridBagConstraints);

        receivesMIDQtyLbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        receivesMIDQtyLbl.setText("jLabel70");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 74;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 28, 0, 23);
        jpReceives.add(receivesMIDQtyLbl, gridBagConstraints);

        jpMovingAvg.setPreferredSize(new java.awt.Dimension(312, 680));
        jpMovingAvg.setLayout(new java.awt.GridBagLayout());

        jLabel15.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 0));
        jLabel15.setText("MOVING AVERAGE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(78, 400, 0, 0);
        jpMovingAvg.add(jLabel15, gridBagConstraints);

        jLabel70.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel70.setText("Product ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 384, 0, 0);
        jpMovingAvg.add(jLabel70, gridBagConstraints);

        avgPIDCB.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        avgPIDCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avgPIDCBActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 124;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 27, 0, 0);
        jpMovingAvg.add(avgPIDCB, gridBagConstraints);

        jLabel71.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        jLabel71.setText("Y/M");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 429, 0, 0);
        jpMovingAvg.add(jLabel71, gridBagConstraints);

        jLabel72.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        jLabel72.setText("Quantity");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 68, 0, 0);
        jpMovingAvg.add(jLabel72, gridBagConstraints);

        month1Lbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        month1Lbl.setText("jLabel73");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 416, 0, 0);
        jpMovingAvg.add(month1Lbl, gridBagConstraints);

        month2Lbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        month2Lbl.setText("jLabel73");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 416, 0, 0);
        jpMovingAvg.add(month2Lbl, gridBagConstraints);

        month3Lbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        month3Lbl.setText("jLabel73");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 416, 0, 0);
        jpMovingAvg.add(month3Lbl, gridBagConstraints);

        qty1Lbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        qty1Lbl.setText("jLabel76");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 68, 0, 0);
        jpMovingAvg.add(qty1Lbl, gridBagConstraints);

        qty2Lbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        qty2Lbl.setText("jLabel76");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 68, 0, 0);
        jpMovingAvg.add(qty2Lbl, gridBagConstraints);

        qty3Lbl.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        qty3Lbl.setText("jLabel76");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 68, 0, 0);
        jpMovingAvg.add(qty3Lbl, gridBagConstraints);

        forecastBtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        forecastBtn.setText("FORECAST");
        forecastBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forecastBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(45, 374, 494, 0);
        jpMovingAvg.add(forecastBtn, gridBagConstraints);

        jLabel79.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel79.setText("Next Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(45, 27, 0, 0);
        jpMovingAvg.add(jLabel79, gridBagConstraints);

        nextMonthLbl.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(45, 5, 0, 805);
        jpMovingAvg.add(nextMonthLbl, gridBagConstraints);

        jpLogin.setPreferredSize(new java.awt.Dimension(312, 680));
        jpLogin.setLayout(new java.awt.GridBagLayout());

        jLabel18.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 0));
        jLabel18.setText("LOGIN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(79, 2, 0, 0);
        jpLogin.add(jLabel18, gridBagConstraints);

        jLabel19.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel19.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = -4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 33, 0, 0);
        jpLogin.add(jLabel19, gridBagConstraints);

        jLabel20.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel20.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 33, 0, 0);
        jpLogin.add(jLabel20, gridBagConstraints);

        jLabel21.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel21.setText("Department");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(46, 33, 0, 0);
        jpLogin.add(jLabel21, gridBagConstraints);

        usernameTF.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 114;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(44, 27, 0, 41);
        jpLogin.add(usernameTF, gridBagConstraints);

        passwordPF.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 114;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 27, 0, 41);
        jpLogin.add(passwordPF, gridBagConstraints);

        departmentCB.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        departmentCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Marcketing", "Sales", "Finance", "Warehouse", "Production" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 27, 0, 41);
        jpLogin.add(departmentCB, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(71, 24, 252, 0);
        jpLogin.add(jButton1, gridBagConstraints);

        logoutBtn.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        logoutBtn.setText("LOGOUT");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(71, 39, 252, 0);
        jpLogin.add(logoutBtn, gridBagConstraints);

        jpBoM.setPreferredSize(new java.awt.Dimension(312, 680));
        jpBoM.setLayout(new java.awt.GridBagLayout());

        jLabel53.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(51, 51, 0));
        jLabel53.setText("BoM");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        jpBoM.add(jLabel53, gridBagConstraints);

        jLabel54.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel54.setText("Order ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 44, 0, 0);
        jpBoM.add(jLabel54, gridBagConstraints);

        jLabel55.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel55.setText("Material ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(42, 44, 0, 0);
        jpBoM.add(jLabel55, gridBagConstraints);

        jLabel56.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel56.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 96, 0, 0);
        jpBoM.add(jLabel56, gridBagConstraints);

        jLabel57.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel57.setText("Unit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 96, 0, 0);
        jpBoM.add(jLabel57, gridBagConstraints);

        jLabel58.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel58.setText("Unit Price");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 96, 0, 0);
        jpBoM.add(jLabel58, gridBagConstraints);

        jLabel59.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel59.setText("Avail. Qty");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 96, 0, 0);
        jpBoM.add(jLabel59, gridBagConstraints);

        jLabel60.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel60.setText("Required Qty");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 44, 0, 0);
        jpBoM.add(jLabel60, gridBagConstraints);

        bomOrderIDCB1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        bomOrderIDCB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bomOrderIDCB1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 33;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 14, 0, 10);
        jpBoM.add(bomOrderIDCB1, gridBagConstraints);

        bomMIDCB1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        bomMIDCB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bomMIDCB1MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 33;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 14, 0, 10);
        jpBoM.add(bomMIDCB1, gridBagConstraints);

        bomMIDNameLbl1.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        bomMIDNameLbl1.setText("jLabel53");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 33;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 81;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 0, 10);
        jpBoM.add(bomMIDNameLbl1, gridBagConstraints);

        bomMIDUnitLbl1.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        bomMIDUnitLbl1.setText("jLabel54");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 33;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 81;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 0, 10);
        jpBoM.add(bomMIDUnitLbl1, gridBagConstraints);

        bomMUnitPriceLbl1.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        bomMUnitPriceLbl1.setText("jLabel55");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 33;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 10);
        jpBoM.add(bomMUnitPriceLbl1, gridBagConstraints);

        bomMAvailQtyLbl1.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        bomMAvailQtyLbl1.setText("jLabel56");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 33;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 10);
        jpBoM.add(bomMAvailQtyLbl1, gridBagConstraints);

        bomRequiredQtyTF1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 33;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 125;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 14, 0, 10);
        jpBoM.add(bomRequiredQtyTF1, gridBagConstraints);

        bomSaveBtn1.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        bomSaveBtn1.setText("SAVE");
        bomSaveBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bomSaveBtn1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 10, 163, 0);
        jpBoM.add(bomSaveBtn1, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel12.setText("Total Price");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 44, 0, 0);
        jpBoM.add(jLabel12, gridBagConstraints);

        bomTotalPriceTF.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 33;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 125;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 14, 0, 10);
        jpBoM.add(bomTotalPriceTF, gridBagConstraints);

        jpIssues.setLayout(new java.awt.GridBagLayout());

        jLabel61.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(51, 51, 0));
        jLabel61.setText("ISSUES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 0, 0, 0);
        jpIssues.add(jLabel61, gridBagConstraints);

        jLabel62.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel62.setText("Order ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 213, 0, 0);
        jpIssues.add(jLabel62, gridBagConstraints);

        jLabel63.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel63.setText("Material ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(42, 213, 0, 0);
        jpIssues.add(jLabel63, gridBagConstraints);

        jLabel64.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel64.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 265, 0, 0);
        jpIssues.add(jLabel64, gridBagConstraints);

        jLabel65.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel65.setText("Unit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 265, 0, 0);
        jpIssues.add(jLabel65, gridBagConstraints);

        jLabel66.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel66.setText("Unit Price");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 265, 0, 0);
        jpIssues.add(jLabel66, gridBagConstraints);

        jLabel67.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        jLabel67.setText("Avail. Qty");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 265, 0, 0);
        jpIssues.add(jLabel67, gridBagConstraints);

        jLabel68.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel68.setText("Required Qty");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 213, 0, 0);
        jpIssues.add(jLabel68, gridBagConstraints);

        issuesOrderIDCB1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        issuesOrderIDCB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuesOrderIDCB1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 14, 0, 155);
        jpIssues.add(issuesOrderIDCB1, gridBagConstraints);

        issuesMIDCB1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        issuesMIDCB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issuesMIDCB1MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 14, 0, 155);
        jpIssues.add(issuesMIDCB1, gridBagConstraints);

        issuesMIDNameLbl1.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        issuesMIDNameLbl1.setText("jLabel53");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 81;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 0, 155);
        jpIssues.add(issuesMIDNameLbl1, gridBagConstraints);

        issuesMIDUnitLbl1.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        issuesMIDUnitLbl1.setText("jLabel54");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 81;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 0, 155);
        jpIssues.add(issuesMIDUnitLbl1, gridBagConstraints);

        issuesMUnitPriceLbl1.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        issuesMUnitPriceLbl1.setText("jLabel55");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 155);
        jpIssues.add(issuesMUnitPriceLbl1, gridBagConstraints);

        issuesMAvailQtyLbl1.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        issuesMAvailQtyLbl1.setText("jLabel56");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 155);
        jpIssues.add(issuesMAvailQtyLbl1, gridBagConstraints);

        issuesRequiredQtyTF1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 125;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 14, 0, 155);
        jpIssues.add(issuesRequiredQtyTF1, gridBagConstraints);

        issueBtn1.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        issueBtn1.setText("ISSUE");
        issueBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueBtn1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(49, 12, 0, 0);
        jpIssues.add(issueBtn1, gridBagConstraints);

        jpWeightedMovingAvg.setPreferredSize(new java.awt.Dimension(312, 680));
        jpWeightedMovingAvg.setLayout(new java.awt.GridBagLayout());

        jLabel73.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(51, 51, 0));
        jLabel73.setText("WEIGHTED MOVING AVERAGE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(68, 363, 0, 0);
        jpWeightedMovingAvg.add(jLabel73, gridBagConstraints);

        jLabel74.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel74.setText("Product ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(44, 417, 0, 0);
        jpWeightedMovingAvg.add(jLabel74, gridBagConstraints);

        avgPIDCB1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        avgPIDCB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avgPIDCB1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 124;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(41, 27, 0, 0);
        jpWeightedMovingAvg.add(avgPIDCB1, gridBagConstraints);

        jLabel75.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        jLabel75.setText("Y/M");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 462, 0, 0);
        jpWeightedMovingAvg.add(jLabel75, gridBagConstraints);

        jLabel76.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        jLabel76.setText("Quantity");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 68, 0, 0);
        jpWeightedMovingAvg.add(jLabel76, gridBagConstraints);

        month1Lbl1.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        month1Lbl1.setText("jLabel73");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 449, 0, 0);
        jpWeightedMovingAvg.add(month1Lbl1, gridBagConstraints);

        month2Lbl1.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        month2Lbl1.setText("jLabel73");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 449, 0, 0);
        jpWeightedMovingAvg.add(month2Lbl1, gridBagConstraints);

        month3Lbl1.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        month3Lbl1.setText("jLabel73");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 449, 0, 0);
        jpWeightedMovingAvg.add(month3Lbl1, gridBagConstraints);

        qty1Lbl1.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        qty1Lbl1.setText("jLabel76");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 68, 0, 0);
        jpWeightedMovingAvg.add(qty1Lbl1, gridBagConstraints);

        qty2Lbl1.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        qty2Lbl1.setText("jLabel76");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 68, 0, 0);
        jpWeightedMovingAvg.add(qty2Lbl1, gridBagConstraints);

        qty3Lbl1.setFont(new java.awt.Font("Bodoni MT", 2, 14)); // NOI18N
        qty3Lbl1.setText("jLabel76");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 68, 0, 0);
        jpWeightedMovingAvg.add(qty3Lbl1, gridBagConstraints);

        forecastBtn1.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        forecastBtn1.setText("FORECAST");
        forecastBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forecastBtn1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 407, 288, 0);
        jpWeightedMovingAvg.add(forecastBtn1, gridBagConstraints);

        jLabel80.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel80.setText("Next Month");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 27, 0, 0);
        jpWeightedMovingAvg.add(jLabel80, gridBagConstraints);

        nextMonthLbl1.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 14;
        gridBagConstraints.ipadx = 74;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 28, 0, 150);
        jpWeightedMovingAvg.add(nextMonthLbl1, gridBagConstraints);

        jLabel16.setText("Weight");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 49, 0, 0);
        jpWeightedMovingAvg.add(jLabel16, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 40, 0, 0);
        jpWeightedMovingAvg.add(weight1TF, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 40, 0, 0);
        jpWeightedMovingAvg.add(weight2TF, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 40, 0, 0);
        jpWeightedMovingAvg.add(weight3TF, gridBagConstraints);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCustomers, javax.swing.GroupLayout.DEFAULT_SIZE, 1820, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 1476, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpOrderPlacing, javax.swing.GroupLayout.DEFAULT_SIZE, 1476, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpRowMaterials, javax.swing.GroupLayout.DEFAULT_SIZE, 1476, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpProductPlanning, javax.swing.GroupLayout.DEFAULT_SIZE, 1476, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpMRP, javax.swing.GroupLayout.DEFAULT_SIZE, 1476, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpReceives, javax.swing.GroupLayout.DEFAULT_SIZE, 1476, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpMovingAvg, javax.swing.GroupLayout.DEFAULT_SIZE, 1476, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addComponent(jpLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 1486, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpBoM, javax.swing.GroupLayout.DEFAULT_SIZE, 1104, Short.MAX_VALUE)
                    .addGap(382, 382, 382)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpIssues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(754, 754, 754)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpWeightedMovingAvg, javax.swing.GroupLayout.DEFAULT_SIZE, 1476, Short.MAX_VALUE)
                    .addGap(334, 334, 334)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCustomers, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jpProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpOrderPlacing, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                    .addGap(21, 21, 21)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jpRowMaterials, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpProductPlanning, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                    .addGap(21, 21, 21)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jpMRP, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpReceives, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                    .addGap(21, 21, 21)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jpMovingAvg, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpBoM, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                    .addGap(74, 74, 74)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpIssues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(127, 127, 127)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpWeightedMovingAvg, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                    .addGap(22, 22, 22)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
        jpCustomers.setVisible(false);
        jpProducts.setVisible(false);
        jpOrderPlacing.setVisible(false);
        jpRowMaterials.setVisible(false);
        jpProductPlanning.setVisible(false);
        jpMRP.setVisible(false);
        jpBoM.setVisible(false);
        jpIssues.setVisible(false);
        jpReceives.setVisible(false);
        jpMovingAvg.setVisible(false);
        jpWeightedMovingAvg.setVisible(false);
       
        jpLogin.setVisible(true);
        
        customersBtn.setBackground(Color.DARK_GRAY);
        loginBtn.setBackground(Color.white);
        productsBtn.setBackground(Color.DARK_GRAY);
        orderPlacingBtn.setBackground(Color.DARK_GRAY);
        rowMaterialsBtn.setBackground(Color.DARK_GRAY);
        productPlanningBtn.setBackground(Color.DARK_GRAY);
        mrpBtn.setBackground(Color.DARK_GRAY);
        bomBtn.setBackground(Color.DARK_GRAY);
        issuesBtn.setBackground(Color.DARK_GRAY);
        receivesBtn.setBackground(Color.DARK_GRAY);
        movingAvgBtn.setBackground(Color.DARK_GRAY);
        weightedMovingAvgBtn.setBackground(Color.DARK_GRAY);
      
        
        customersBtn.setForeground(Color.white);
        loginBtn.setForeground(Color.BLACK);
        productsBtn.setForeground(Color.white);
        orderPlacingBtn.setForeground(Color.white);
        rowMaterialsBtn.setForeground(Color.white);
        productPlanningBtn.setForeground(Color.white);
        mrpBtn.setForeground(Color.white);
        bomBtn.setForeground(Color.white);
        issuesBtn.setForeground(Color.white);
        receivesBtn.setForeground(Color.white);
        movingAvgBtn.setForeground(Color.white);
        weightedMovingAvgBtn.setForeground(Color.white);
     
    }//GEN-LAST:event_loginBtnActionPerformed

    private void productsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsBtnActionPerformed
        // TODO add your handling code here:
        jpCustomers.setVisible(false);
        jpProducts.setVisible(true);
        jpOrderPlacing.setVisible(false);
        jpRowMaterials.setVisible(false);
        jpProductPlanning.setVisible(false);
        jpMRP.setVisible(false);
        jpBoM.setVisible(false);
        jpIssues.setVisible(false);
        jpReceives.setVisible(false);
        jpMovingAvg.setVisible(false);
        jpWeightedMovingAvg.setVisible(false);
    
        jpLogin.setVisible(false);
        
        customersBtn.setBackground(Color.DARK_GRAY);
        loginBtn.setBackground(Color.DARK_GRAY);
        productsBtn.setBackground(Color.white);
        orderPlacingBtn.setBackground(Color.DARK_GRAY);
        rowMaterialsBtn.setBackground(Color.DARK_GRAY);
        productPlanningBtn.setBackground(Color.DARK_GRAY);
        mrpBtn.setBackground(Color.DARK_GRAY);
        bomBtn.setBackground(Color.DARK_GRAY);
        issuesBtn.setBackground(Color.DARK_GRAY);
        receivesBtn.setBackground(Color.DARK_GRAY);
        movingAvgBtn.setBackground(Color.DARK_GRAY);
        weightedMovingAvgBtn.setBackground(Color.DARK_GRAY);
       
        
        customersBtn.setForeground(Color.white);
        loginBtn.setForeground(Color.white);
        productsBtn.setForeground(Color.BLACK);
        orderPlacingBtn.setForeground(Color.white);
        rowMaterialsBtn.setForeground(Color.white);
        productPlanningBtn.setForeground(Color.white);
        mrpBtn.setForeground(Color.white);
        bomBtn.setForeground(Color.white);
        issuesBtn.setForeground(Color.white);
        receivesBtn.setForeground(Color.white);
        movingAvgBtn.setForeground(Color.white);
        weightedMovingAvgBtn.setForeground(Color.white);
        
    }//GEN-LAST:event_productsBtnActionPerformed

    private void orderPlacingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderPlacingBtnActionPerformed
        // TODO add your handling code here:
        jpCustomers.setVisible(false);
        jpProducts.setVisible(false);
        jpOrderPlacing.setVisible(true);
        jpRowMaterials.setVisible(false);
        jpProductPlanning.setVisible(false);
        jpMRP.setVisible(false);
        jpBoM.setVisible(false);
        jpIssues.setVisible(false);
        jpReceives.setVisible(false);
        jpMovingAvg.setVisible(false);
        jpWeightedMovingAvg.setVisible(false);
   
        jpLogin.setVisible(false);
        
        customersBtn.setBackground(Color.DARK_GRAY);
        loginBtn.setBackground(Color.DARK_GRAY);
        productsBtn.setBackground(Color.DARK_GRAY);
        orderPlacingBtn.setBackground(Color.white);
        rowMaterialsBtn.setBackground(Color.DARK_GRAY);
        productPlanningBtn.setBackground(Color.DARK_GRAY);
        mrpBtn.setBackground(Color.DARK_GRAY);
        bomBtn.setBackground(Color.DARK_GRAY);
        issuesBtn.setBackground(Color.DARK_GRAY);
        receivesBtn.setBackground(Color.DARK_GRAY);
        movingAvgBtn.setBackground(Color.DARK_GRAY);
        weightedMovingAvgBtn.setBackground(Color.DARK_GRAY);
        
        
        customersBtn.setForeground(Color.white);
        loginBtn.setForeground(Color.white);
        productsBtn.setForeground(Color.white);
        orderPlacingBtn.setForeground(Color.BLACK);
        rowMaterialsBtn.setForeground(Color.white);
        productPlanningBtn.setForeground(Color.white);
        mrpBtn.setForeground(Color.white);
        bomBtn.setForeground(Color.white);
        issuesBtn.setForeground(Color.white);
        receivesBtn.setForeground(Color.white);
        movingAvgBtn.setForeground(Color.white);
        weightedMovingAvgBtn.setForeground(Color.white);
        
    }//GEN-LAST:event_orderPlacingBtnActionPerformed

    private void rowMaterialsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rowMaterialsBtnActionPerformed
        // TODO add your handling code here:
        jpCustomers.setVisible(false);
        jpProducts.setVisible(false);
        jpOrderPlacing.setVisible(false);
        jpRowMaterials.setVisible(true);
        jpProductPlanning.setVisible(false);
        jpMRP.setVisible(false);
        jpBoM.setVisible(false);
        jpIssues.setVisible(false);
        jpReceives.setVisible(false);
        jpMovingAvg.setVisible(false);
        jpWeightedMovingAvg.setVisible(false);

        jpLogin.setVisible(false);
        
        customersBtn.setBackground(Color.DARK_GRAY);
        loginBtn.setBackground(Color.DARK_GRAY);
        productsBtn.setBackground(Color.DARK_GRAY);
        orderPlacingBtn.setBackground(Color.DARK_GRAY);
        rowMaterialsBtn.setBackground(Color.white);
        productPlanningBtn.setBackground(Color.DARK_GRAY);
        mrpBtn.setBackground(Color.DARK_GRAY);
        bomBtn.setBackground(Color.DARK_GRAY);
        issuesBtn.setBackground(Color.DARK_GRAY);
        receivesBtn.setBackground(Color.DARK_GRAY);
        movingAvgBtn.setBackground(Color.DARK_GRAY);
        weightedMovingAvgBtn.setBackground(Color.DARK_GRAY);
        
        
        customersBtn.setForeground(Color.white);
        loginBtn.setForeground(Color.white);
        productsBtn.setForeground(Color.white);
        orderPlacingBtn.setForeground(Color.white);
        rowMaterialsBtn.setForeground(Color.BLACK);
        productPlanningBtn.setForeground(Color.white);
        mrpBtn.setForeground(Color.white);
        bomBtn.setForeground(Color.white);
        issuesBtn.setForeground(Color.white);
        receivesBtn.setForeground(Color.white);
        movingAvgBtn.setForeground(Color.white);
        weightedMovingAvgBtn.setForeground(Color.white);
   
    }//GEN-LAST:event_rowMaterialsBtnActionPerformed

    private void productPlanningBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productPlanningBtnActionPerformed
        // TODO add your handling code here:
        jpCustomers.setVisible(false);
        jpProducts.setVisible(false);
        jpOrderPlacing.setVisible(false);
        jpRowMaterials.setVisible(false);
        jpProductPlanning.setVisible(true);
        jpMRP.setVisible(false);
        jpBoM.setVisible(false);
        jpIssues.setVisible(false);
        jpReceives.setVisible(false);
        jpMovingAvg.setVisible(false);
        jpWeightedMovingAvg.setVisible(false);
      
        jpLogin.setVisible(false);
        
        customersBtn.setBackground(Color.DARK_GRAY);
        loginBtn.setBackground(Color.DARK_GRAY);
        productsBtn.setBackground(Color.DARK_GRAY);
        orderPlacingBtn.setBackground(Color.DARK_GRAY);
        rowMaterialsBtn.setBackground(Color.DARK_GRAY);
        productPlanningBtn.setBackground(Color.white);
        mrpBtn.setBackground(Color.DARK_GRAY);
        bomBtn.setBackground(Color.DARK_GRAY);
        issuesBtn.setBackground(Color.DARK_GRAY);
        receivesBtn.setBackground(Color.DARK_GRAY);
        movingAvgBtn.setBackground(Color.DARK_GRAY);
        weightedMovingAvgBtn.setBackground(Color.DARK_GRAY);
      
        
        customersBtn.setForeground(Color.white);
        loginBtn.setForeground(Color.white);
        productsBtn.setForeground(Color.white);
        orderPlacingBtn.setForeground(Color.white);
        rowMaterialsBtn.setForeground(Color.white);
        productPlanningBtn.setForeground(Color.BLACK);
        mrpBtn.setForeground(Color.white);
        bomBtn.setForeground(Color.white);
        issuesBtn.setForeground(Color.white);
        receivesBtn.setForeground(Color.white);
        movingAvgBtn.setForeground(Color.white);
        weightedMovingAvgBtn.setForeground(Color.white);
     
    }//GEN-LAST:event_productPlanningBtnActionPerformed

    private void mrpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mrpBtnActionPerformed
        // TODO add your handling code here:
        jpCustomers.setVisible(false);
        jpProducts.setVisible(false);
        jpOrderPlacing.setVisible(false);
        jpRowMaterials.setVisible(false);
        jpProductPlanning.setVisible(false);
        jpMRP.setVisible(true);
        jpBoM.setVisible(false);
        jpIssues.setVisible(false);
        jpReceives.setVisible(false);
        jpMovingAvg.setVisible(false);
        jpWeightedMovingAvg.setVisible(false);
        
        jpLogin.setVisible(false);
        
        customersBtn.setBackground(Color.DARK_GRAY);
        loginBtn.setBackground(Color.DARK_GRAY);
        productsBtn.setBackground(Color.DARK_GRAY);
        orderPlacingBtn.setBackground(Color.DARK_GRAY);
        rowMaterialsBtn.setBackground(Color.DARK_GRAY);
        productPlanningBtn.setBackground(Color.DARK_GRAY);
        mrpBtn.setBackground(Color.white);
        bomBtn.setBackground(Color.DARK_GRAY);
        issuesBtn.setBackground(Color.DARK_GRAY);
        receivesBtn.setBackground(Color.DARK_GRAY);
        movingAvgBtn.setBackground(Color.DARK_GRAY);
        weightedMovingAvgBtn.setBackground(Color.DARK_GRAY);

        
        customersBtn.setForeground(Color.white);
        loginBtn.setForeground(Color.white);
        productsBtn.setForeground(Color.white);
        orderPlacingBtn.setForeground(Color.white);
        rowMaterialsBtn.setForeground(Color.white);
        productPlanningBtn.setForeground(Color.white);
        mrpBtn.setForeground(Color.BLACK);
        bomBtn.setForeground(Color.white);
        issuesBtn.setForeground(Color.white);
        receivesBtn.setForeground(Color.white);
        movingAvgBtn.setForeground(Color.white);
        weightedMovingAvgBtn.setForeground(Color.white);
     
    }//GEN-LAST:event_mrpBtnActionPerformed

    private void bomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bomBtnActionPerformed
        // TODO add your handling code here:
        jpCustomers.setVisible(false);
        jpProducts.setVisible(false);
        jpOrderPlacing.setVisible(false);
        jpRowMaterials.setVisible(false);
        jpProductPlanning.setVisible(false);
        jpMRP.setVisible(false);
        jpBoM.setVisible(true);
        jpIssues.setVisible(false);
        jpReceives.setVisible(false);
        jpMovingAvg.setVisible(false);
        jpWeightedMovingAvg.setVisible(false);
    
        jpLogin.setVisible(false);
        
        customersBtn.setBackground(Color.DARK_GRAY);
        loginBtn.setBackground(Color.DARK_GRAY);
        productsBtn.setBackground(Color.DARK_GRAY);
        orderPlacingBtn.setBackground(Color.DARK_GRAY);
        rowMaterialsBtn.setBackground(Color.DARK_GRAY);
        productPlanningBtn.setBackground(Color.DARK_GRAY);
        mrpBtn.setBackground(Color.DARK_GRAY);
        bomBtn.setBackground(Color.white);
        issuesBtn.setBackground(Color.DARK_GRAY);
        receivesBtn.setBackground(Color.DARK_GRAY);
        movingAvgBtn.setBackground(Color.DARK_GRAY);
        weightedMovingAvgBtn.setBackground(Color.DARK_GRAY);

        
        customersBtn.setForeground(Color.white);
        loginBtn.setForeground(Color.white);
        productsBtn.setForeground(Color.white);
        orderPlacingBtn.setForeground(Color.white);
        rowMaterialsBtn.setForeground(Color.white);
        productPlanningBtn.setForeground(Color.white);
        mrpBtn.setForeground(Color.white);
        bomBtn.setForeground(Color.BLACK);
        issuesBtn.setForeground(Color.white);
        receivesBtn.setForeground(Color.white);
        movingAvgBtn.setForeground(Color.white);
        weightedMovingAvgBtn.setForeground(Color.white);
     
    }//GEN-LAST:event_bomBtnActionPerformed

    private void issuesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuesBtnActionPerformed
        // TODO add your handling code here:
        jpCustomers.setVisible(false);
        jpProducts.setVisible(false);
        jpOrderPlacing.setVisible(false);
        jpRowMaterials.setVisible(false);
        jpProductPlanning.setVisible(false);
        jpMRP.setVisible(false);
        jpBoM.setVisible(false);
        jpIssues.setVisible(true);
        jpReceives.setVisible(false);
        jpMovingAvg.setVisible(false);
        jpWeightedMovingAvg.setVisible(false);
      
        jpLogin.setVisible(false);
        
        customersBtn.setBackground(Color.DARK_GRAY);
        loginBtn.setBackground(Color.DARK_GRAY);
        productsBtn.setBackground(Color.DARK_GRAY);
        orderPlacingBtn.setBackground(Color.DARK_GRAY);
        rowMaterialsBtn.setBackground(Color.DARK_GRAY);
        productPlanningBtn.setBackground(Color.DARK_GRAY);
        mrpBtn.setBackground(Color.DARK_GRAY);
        bomBtn.setBackground(Color.DARK_GRAY);
        issuesBtn.setBackground(Color.white);
        receivesBtn.setBackground(Color.DARK_GRAY);
        movingAvgBtn.setBackground(Color.DARK_GRAY);
        weightedMovingAvgBtn.setBackground(Color.DARK_GRAY);
      
        
        customersBtn.setForeground(Color.white);
        loginBtn.setForeground(Color.white);
        productsBtn.setForeground(Color.white);
        orderPlacingBtn.setForeground(Color.white);
        rowMaterialsBtn.setForeground(Color.white);
        productPlanningBtn.setForeground(Color.white);
        mrpBtn.setForeground(Color.white);
        bomBtn.setForeground(Color.white);
        issuesBtn.setForeground(Color.BLACK);
        receivesBtn.setForeground(Color.white);
        movingAvgBtn.setForeground(Color.white);
        weightedMovingAvgBtn.setForeground(Color.white);
       
    }//GEN-LAST:event_issuesBtnActionPerformed

    private void receivesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receivesBtnActionPerformed
        // TODO add your handling code here:
        jpCustomers.setVisible(false);
        jpProducts.setVisible(false);
        jpOrderPlacing.setVisible(false);
        jpRowMaterials.setVisible(false);
        jpProductPlanning.setVisible(false);
        jpMRP.setVisible(false);
        jpBoM.setVisible(false);
        jpIssues.setVisible(false);
        jpReceives.setVisible(true);
        jpMovingAvg.setVisible(false);
        jpWeightedMovingAvg.setVisible(false);
      
        jpLogin.setVisible(false);
        
        customersBtn.setBackground(Color.DARK_GRAY);
        loginBtn.setBackground(Color.DARK_GRAY);
        productsBtn.setBackground(Color.DARK_GRAY);
        orderPlacingBtn.setBackground(Color.DARK_GRAY);
        rowMaterialsBtn.setBackground(Color.DARK_GRAY);
        productPlanningBtn.setBackground(Color.DARK_GRAY);
        mrpBtn.setBackground(Color.DARK_GRAY);
        bomBtn.setBackground(Color.DARK_GRAY);
        issuesBtn.setBackground(Color.DARK_GRAY);
        receivesBtn.setBackground(Color.white);
        movingAvgBtn.setBackground(Color.DARK_GRAY);
        weightedMovingAvgBtn.setBackground(Color.DARK_GRAY);
     
        
        customersBtn.setForeground(Color.white);
        loginBtn.setForeground(Color.white);
        productsBtn.setForeground(Color.white);
        orderPlacingBtn.setForeground(Color.white);
        rowMaterialsBtn.setForeground(Color.white);
        productPlanningBtn.setForeground(Color.white);
        mrpBtn.setForeground(Color.white);
        bomBtn.setForeground(Color.white);
        issuesBtn.setForeground(Color.white);
        receivesBtn.setForeground(Color.BLACK);
        movingAvgBtn.setForeground(Color.white);
        weightedMovingAvgBtn.setForeground(Color.white);
        
    }//GEN-LAST:event_receivesBtnActionPerformed

    private void movingAvgBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movingAvgBtnActionPerformed
        // TODO add your handling code here:
        jpCustomers.setVisible(false);
        jpProducts.setVisible(false);
        jpOrderPlacing.setVisible(false);
        jpRowMaterials.setVisible(false);
        jpProductPlanning.setVisible(false);
        jpMRP.setVisible(false);
        jpBoM.setVisible(false);
        jpIssues.setVisible(false);
        jpReceives.setVisible(false);
        jpMovingAvg.setVisible(true);
        jpWeightedMovingAvg.setVisible(false);

        jpLogin.setVisible(false);
        
        customersBtn.setBackground(Color.DARK_GRAY);
        loginBtn.setBackground(Color.DARK_GRAY);
        productsBtn.setBackground(Color.DARK_GRAY);
        orderPlacingBtn.setBackground(Color.DARK_GRAY);
        rowMaterialsBtn.setBackground(Color.DARK_GRAY);
        productPlanningBtn.setBackground(Color.DARK_GRAY);
        mrpBtn.setBackground(Color.DARK_GRAY);
        bomBtn.setBackground(Color.DARK_GRAY);
        issuesBtn.setBackground(Color.DARK_GRAY);
        receivesBtn.setBackground(Color.DARK_GRAY);
        movingAvgBtn.setBackground(Color.white);
        weightedMovingAvgBtn.setBackground(Color.DARK_GRAY);
       
        
        customersBtn.setForeground(Color.white);
        loginBtn.setForeground(Color.white);
        productsBtn.setForeground(Color.white);
        orderPlacingBtn.setForeground(Color.white);
        rowMaterialsBtn.setForeground(Color.white);
        productPlanningBtn.setForeground(Color.white);
        mrpBtn.setForeground(Color.white);
        bomBtn.setForeground(Color.white);
        issuesBtn.setForeground(Color.white);
        receivesBtn.setForeground(Color.white);
        movingAvgBtn.setForeground(Color.BLACK);
        weightedMovingAvgBtn.setForeground(Color.white);
  
    }//GEN-LAST:event_movingAvgBtnActionPerformed

    private void weightedMovingAvgBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weightedMovingAvgBtnActionPerformed
        // TODO add your handling code here:
        jpCustomers.setVisible(false);
        jpProducts.setVisible(false);
        jpOrderPlacing.setVisible(false);
        jpRowMaterials.setVisible(false);
        jpProductPlanning.setVisible(false);
        jpMRP.setVisible(false);
        jpBoM.setVisible(false);
        jpIssues.setVisible(false);
        jpReceives.setVisible(false);
        jpMovingAvg.setVisible(false);
        jpWeightedMovingAvg.setVisible(true);
     
        jpLogin.setVisible(false);
        
        customersBtn.setBackground(Color.DARK_GRAY);
        loginBtn.setBackground(Color.DARK_GRAY);
        productsBtn.setBackground(Color.DARK_GRAY);
        orderPlacingBtn.setBackground(Color.DARK_GRAY);
        rowMaterialsBtn.setBackground(Color.DARK_GRAY);
        productPlanningBtn.setBackground(Color.DARK_GRAY);
        mrpBtn.setBackground(Color.DARK_GRAY);
        bomBtn.setBackground(Color.DARK_GRAY);
        issuesBtn.setBackground(Color.DARK_GRAY);
        receivesBtn.setBackground(Color.DARK_GRAY);
        movingAvgBtn.setBackground(Color.DARK_GRAY);
        weightedMovingAvgBtn.setBackground(Color.white);
        
        
        customersBtn.setForeground(Color.white);
        loginBtn.setForeground(Color.white);
        productsBtn.setForeground(Color.white);
        orderPlacingBtn.setForeground(Color.white);
        rowMaterialsBtn.setForeground(Color.white);
        productPlanningBtn.setForeground(Color.white);
        mrpBtn.setForeground(Color.white);
        bomBtn.setForeground(Color.white);
        issuesBtn.setForeground(Color.white);
        receivesBtn.setForeground(Color.white);
        movingAvgBtn.setForeground(Color.white);
        weightedMovingAvgBtn.setForeground(Color.BLACK);
 
    }//GEN-LAST:event_weightedMovingAvgBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        String c_id=customerIDCB.getSelectedItem().toString();
        String name=nameTF.getText();
        String address=addressTF.getText();
        String tel=telTF.getText();
        AddToDB.updateCustomer(c_id, name, address, tel);
        clearFields();
         
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        String c_id=customerIDCB.getSelectedItem().toString();
        AddToDB.deleteCustomer(c_id);
        clearFields();
    }//GEN-LAST:event_deleteBtnActionPerformed
    
    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        String c_id=customerIDCB.getSelectedItem().toString();
        String name=nameTF.getText();
        String address=addressTF.getText();
        String tel=telTF.getText();
        AddToDB.addCustomerIntoDB(c_id, name, address, tel);
        clearFields();
        
    }//GEN-LAST:event_saveBtnActionPerformed

    private void customersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersBtnActionPerformed
        // TODO add your handling code here:
        jpCustomers.setVisible(true);
        jpProducts.setVisible(false);
        jpOrderPlacing.setVisible(false);
        jpRowMaterials.setVisible(false);
        jpProductPlanning.setVisible(false);
        jpMRP.setVisible(false);
        jpBoM.setVisible(false);
        jpIssues.setVisible(false);
        jpReceives.setVisible(false);
        jpMovingAvg.setVisible(false);
        jpWeightedMovingAvg.setVisible(false);
      
        jpLogin.setVisible(false);
        
        customersBtn.setBackground(Color.white);
        loginBtn.setBackground(Color.DARK_GRAY);
        productsBtn.setBackground(Color.DARK_GRAY);
        orderPlacingBtn.setBackground(Color.DARK_GRAY);
        rowMaterialsBtn.setBackground(Color.DARK_GRAY);
        productPlanningBtn.setBackground(Color.DARK_GRAY);
        mrpBtn.setBackground(Color.DARK_GRAY);
        bomBtn.setBackground(Color.DARK_GRAY);
        issuesBtn.setBackground(Color.DARK_GRAY);
        receivesBtn.setBackground(Color.DARK_GRAY);
        movingAvgBtn.setBackground(Color.DARK_GRAY);
        weightedMovingAvgBtn.setBackground(Color.DARK_GRAY);
      
        
        customersBtn.setForeground(Color.BLACK);
        loginBtn.setForeground(Color.white);
        productsBtn.setForeground(Color.white);
        orderPlacingBtn.setForeground(Color.white);
        rowMaterialsBtn.setForeground(Color.white);
        productPlanningBtn.setForeground(Color.white);
        mrpBtn.setForeground(Color.white);
        bomBtn.setForeground(Color.white);
        issuesBtn.setForeground(Color.white);
        receivesBtn.setForeground(Color.white);
        movingAvgBtn.setForeground(Color.white);
        weightedMovingAvgBtn.setForeground(Color.white);
       
    }//GEN-LAST:event_customersBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String username=usernameTF.getText();
        String password=passwordPF.getText();
        String dept=departmentCB.getSelectedItem().toString();
//        UserLoginController.userLogin(username, password, dept);
        if(username.equals("Marcketing") && password.equals("123") && dept.equals("Marcketing")){
            movingAvgBtn.setEnabled(true);
            weightedMovingAvgBtn.setEnabled(true);
        }else if(username.equals("Sales") && password.equals("456") && dept.equals("Sales")){
            customersBtn.setEnabled(true);
            orderPlacingBtn.setEnabled(true);
          
        }else if(username.equals("Finance") && password.equals("789") && dept.equals("Finance")){
            bomBtn.setEnabled(true);
        }else if(username.equals("Warehouse") && password.equals("234") && dept.equals("Warehouse")){
            rowMaterialsBtn.setEnabled(true);
            issuesBtn.setEnabled(true);
            receivesBtn.setEnabled(true);
        }else if(username.equals("Production") && password.equals("567") && dept.equals("Production")){
            productsBtn.setEnabled(true);
            productPlanningBtn.setEnabled(true);
            mrpBtn.setEnabled(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        customersBtn.setEnabled(false);
        loginBtn.setEnabled(true);
        productsBtn.setEnabled(false);
        orderPlacingBtn.setEnabled(false);
        rowMaterialsBtn.setEnabled(false);
        productPlanningBtn.setEnabled(false);
        mrpBtn.setEnabled(false);
        bomBtn.setEnabled(false);
        issuesBtn.setEnabled(false);
        receivesBtn.setEnabled(false);
        movingAvgBtn.setEnabled(false);
        weightedMovingAvgBtn.setEnabled(false);
        
        clearFields();
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void addressTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTFActionPerformed

    private void customerIDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIDCBActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String id=customerIDCB.getSelectedItem().toString();
            
            ResultSet rs=new DBSearch().searchOneCustomer(id);
            
            while(rs.next()){
                nameTF.setText(rs.getString("name"));
                addressTF.setText(rs.getString("address"));
                telTF.setText(rs.getString("tel"));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_customerIDCBActionPerformed

    private void customerIDCBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerIDCBMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_customerIDCBMouseClicked

    private void customerIDCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_customerIDCBItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_customerIDCBItemStateChanged

    private void customerIDCBFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerIDCBFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_customerIDCBFocusGained

    private void customerIDCBInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_customerIDCBInputMethodTextChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_customerIDCBInputMethodTextChanged

    private void productIDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIDCBActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            String id=productIDCB.getSelectedItem().toString();
            
            ResultSet rs=new DBSearch().searchOneProduct(id);
            
            while(rs.next()){
                descriptionTF.setText(rs.getString("description"));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_productIDCBActionPerformed

    private void delete2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete2BtnActionPerformed
        // TODO add your handling code here:
        String pid=productIDCB.getSelectedItem().toString();
        AddToDB.deleteProduct(pid);
        clearFields();
    }//GEN-LAST:event_delete2BtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        String id=productIDCB.getSelectedItem().toString();
        String des=descriptionTF.getText();
        AddToDB.addProductIntoDB(id, des);
        clearFields();
    }//GEN-LAST:event_addBtnActionPerformed

    private void update2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update2BtnActionPerformed
        // TODO add your handling code here:
        String id=productIDCB.getSelectedItem().toString();
        String des=descriptionTF.getText();
        AddToDB.updateProduct(id, des);
        clearFields();
    }//GEN-LAST:event_update2BtnActionPerformed

    private void requiredQtyTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requiredQtyTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requiredQtyTFActionPerformed

    private void customerIDCB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIDCB2ActionPerformed
        
    }//GEN-LAST:event_customerIDCB2ActionPerformed

    private void productIDCB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIDCB2ActionPerformed
        
    }//GEN-LAST:event_productIDCB2ActionPerformed

    private void addBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn3ActionPerformed
        // TODO add your handling code here:
        String oid=orderIDCB.getSelectedItem().toString();
        String cid=customerIDCB2.getSelectedItem().toString();
        String pid=productIDCB2.getSelectedItem().toString();
        int qty=Integer.parseInt(requiredQtyTF.getText());
        java.sql.Date date = new java.sql.Date(dateDP.getDate().getTime());
        
        AddToDB.addOrderIntoDB(oid, cid, pid, qty, date);
        clearFields();
        o_idCBLoader2();
    }//GEN-LAST:event_addBtn3ActionPerformed

    private void updateBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtn3ActionPerformed
        // TODO add your handling code here:
        
        String oid=orderIDCB.getSelectedItem().toString();
        String pid=productIDCB2.getSelectedItem().toString();
        String cid=customerIDCB2.getSelectedItem().toString();
        String qty=requiredQtyTF.getText();
        
        AddToDB.updateQty(oid, cid, pid, qty);
        clearFields();
    }//GEN-LAST:event_updateBtn3ActionPerformed
   
    private void orderIDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderIDCBActionPerformed
        clearFields();
    }//GEN-LAST:event_orderIDCBActionPerformed

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        // TODO add your handling code here:
        c_idCB2Loader();
        p_idCB2Loader();
    }//GEN-LAST:event_newBtnActionPerformed

    private void existingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_existingBtnActionPerformed
        // TODO add your handling code here:
        customerIDCB2.removeAllItems();
        productIDCB2.removeAllItems();
        try {
          
            
            String oid=orderIDCB.getSelectedItem().toString();

            ResultSet rs=new DBSearch().searchOneOrderBaseOnCustomer(oid);
            ResultSet rs1=new DBSearch().searchOneOrderBaseOnProduct(oid);
            

            while(rs.next()){
           
                customerIDCB2.addItem(Integer.toString(rs.getInt("c_id")));
            }
            while(rs1.next()){
        
                productIDCB2.addItem(Integer.toString(rs1.getInt("p_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_existingBtnActionPerformed

    private void deleteBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtn3ActionPerformed
        // TODO add your handling code here:
        String oid=orderIDCB.getSelectedItem().toString();
        
        AddToDB.deleteOrder(oid);
        o_idCBLoader2();
        clearFields();
    }//GEN-LAST:event_deleteBtn3ActionPerformed

    private void customerIDCB2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerIDCB2MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String cid=customerIDCB2.getSelectedItem().toString();
            
            ResultSet rs=new DBSearch().searchOneCustomer(cid);
            
            while(rs.next()){
                nameLbl.setText(rs.getString("name"));
                addressLbl.setText(rs.getString("address"));
                telLbl.setText(rs.getString("tel"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_customerIDCB2MouseClicked

    private void productIDCB2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productIDCB2MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String oid=orderIDCB.getSelectedItem().toString();
            String cid=customerIDCB2.getSelectedItem().toString();
            String pid=productIDCB2.getSelectedItem().toString();
            
            ResultSet rs=new DBSearch().searchQtyPerOrder(oid, cid, pid);
            ResultSet rs2=new DBSearch().searchOneProduct(pid);
            
            while(rs.next()){
                requiredQtyTF.setText(Integer.toString(rs.getInt("required_quantity")));
                String date=rs.getDate("date").toString();
                ((JTextField)dateDP.getDateEditor().getUiComponent()).setText(date);
            }
            while(rs2.next()){
                descriptionLbl.setText(rs2.getString("description"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_productIDCB2MouseClicked

    private void mDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mDeleteBtnActionPerformed
        // TODO add your handling code here:
        String id=midCB.getSelectedItem().toString();
        AddToDB.deleteMaterial(id);
        clearFields();
    }//GEN-LAST:event_mDeleteBtnActionPerformed

    private void mAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAddBtnActionPerformed
        // TODO add your handling code here:
        String id=midCB.getSelectedItem().toString();
        String desc=mDescTF.getText();
        String unit=unitCB.getSelectedItem().toString();
        String unitPrice=unitPriceTF.getText();
        String availQty=availQtyTF.getText();
        
        AddToDB.addMaterialIntoDB(id, desc, unit, unitPrice, availQty);
        clearFields();
      
    }//GEN-LAST:event_mAddBtnActionPerformed

    private void midCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midCBActionPerformed
        try {
            // TODO add your handling code here:
            String id=midCB.getSelectedItem().toString();
            
            ResultSet rs=new DBSearch().searchOneMaterial(id);
            
            while(rs.next()){
                mDescTF.setText(rs.getString("material_description"));
                unitCB.setSelectedItem(rs.getString("unit"));
                availQtyTF.setText(rs.getString("available_quantity"));
                unitPriceTF.setText(rs.getString("unit_price"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_midCBActionPerformed

    private void mUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mUpdateBtnActionPerformed
        // TODO add your handling code here:
        String id=midCB.getSelectedItem().toString();
        String desc=mDescTF.getText();
        String unit=unitCB.getSelectedItem().toString();
        String unitPrice=unitPriceTF.getText();
        String availQty=availQtyTF.getText();
        
        AddToDB.updateMaterial(id, desc, unit, unitPrice, availQty);
        clearFields();
    }//GEN-LAST:event_mUpdateBtnActionPerformed

    private void pDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pDeleteBtnActionPerformed
        // TODO add your handling code here:
        String pid=pProductIDCB.getSelectedItem().toString();
        String mid=pMaterialIDCB.getSelectedItem().toString();
       
        AddToDB.deleteProductPlan(pid, mid);
        clearFields();
    }//GEN-LAST:event_pDeleteBtnActionPerformed

    private void pProductIDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pProductIDCBActionPerformed
        try {
            // TODO add your handling code here:
            String pid=pProductIDCB.getSelectedItem().toString();
            
            ResultSet rs=new DBSearch().searchOneProduct(pid);
            
            while(rs.next()){
                pProductDescLbl.setText(rs.getString("description"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pProductIDCBActionPerformed

    private void pMaterialIDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pMaterialIDCBActionPerformed
        
    }//GEN-LAST:event_pMaterialIDCBActionPerformed

    private void pAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pAddBtnActionPerformed
        // TODO add your handling code here:
        int availQty=Integer.parseInt(pMaterialAvailQtyLbl.getText());
        int requiredQty=Integer.parseInt(pRequiredQtyTF.getText());
        String pid=pProductIDCB.getSelectedItem().toString();
        String mid=pMaterialIDCB.getSelectedItem().toString();
        
        if(requiredQty>availQty){
            JOptionPane.showMessageDialog(null, "Available quantity is less than required quantity!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
            AddToDB.addProductPlanIntoDB(pid, mid, requiredQty);
        }
        clearFields();
    }//GEN-LAST:event_pAddBtnActionPerformed

    private void pUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pUpdateBtnActionPerformed
        // TODO add your handling code here:
        String pid=pProductIDCB.getSelectedItem().toString();
        String mid=pMaterialIDCB.getSelectedItem().toString();
        int requiredQty=Integer.parseInt(pRequiredQtyTF.getText());
        
        AddToDB.updateProductPlan(pid, mid, requiredQty);
        
        clearFields();
    }//GEN-LAST:event_pUpdateBtnActionPerformed

    private void ppNewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppNewBtnActionPerformed
        // TODO add your handling code here:
        pMaterialIDCB.removeAllItems();
        try {
            ResultSet rs=new DBSearch().searchMaterials();
            
            while(rs.next()){
                
                pMaterialIDCB.addItem(Integer.toString(rs.getInt("m_id")));
                
            }
            clearFields();
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ppNewBtnActionPerformed

    private void pMaterialIDCBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMaterialIDCBMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String mid=pMaterialIDCB.getSelectedItem().toString();
            String pid=pProductIDCB.getSelectedItem().toString();
            
            ResultSet rs=new DBSearch().searchOneMaterial(mid);
            ResultSet rs1=new DBSearch().searchPPlanQty(pid, mid);
            
            while(rs.next()){
                pMaterialNameLbl.setText(rs.getString("material_description"));
                pMaterialUnitLbl.setText(rs.getString("unit"));
                pMaterialUPriceLbl.setText(Integer.toString(rs.getInt("unit_price")));
                pMaterialAvailQtyLbl.setText(Integer.toString(rs.getInt("available_quantity")));
            }
            if(rs1!=null){
                while(rs1.next()){
                    pRequiredQtyTF.setText(Integer.toString(rs1.getInt("required_quantity")));
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No product plan has been set for this product!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pMaterialIDCBMouseClicked

    private void ppExistingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppExistingBtnActionPerformed
        // TODO add your handling code here
        x++;
        pMaterialIDCB.removeAllItems();
        try {
            String pid=pProductIDCB.getSelectedItem().toString();
            ResultSet rs=new DBSearch().searchMaterials2(pid);
            
            while(rs.next()){
                
                pMaterialIDCB.addItem(Integer.toString(rs.getInt("m_id")));
                
            }
            clearFields();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_ppExistingBtnActionPerformed

    private void mrpOrderIDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mrpOrderIDCBActionPerformed
        try {
            mrpMIDCB.removeAllItems();
            String oid=mrpOrderIDCB.getSelectedItem().toString();
            
            ResultSet rs=new DBSearch().searchMaterialsPerOrder(oid);
            
            while(rs.next()){
                mrpMIDCB.addItem(Integer.toString(rs.getInt("m_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mrpOrderIDCBActionPerformed

    private void mrpMIDCBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mrpMIDCBMouseClicked
        try {
            // TODO add your handling code here:
            String mid=mrpMIDCB.getSelectedItem().toString();
            String oid=mrpOrderIDCB.getSelectedItem().toString();
            
            ResultSet rs=new DBSearch().searchOneMaterial(mid);
            ResultSet rs1=new DBSearch().searchOneMaterialQuantityPerOrder(oid, mid);
            
            while(rs.next()){
                mMIDNameLbl.setText(rs.getString("material_description"));
                mrpMIDUnitLbl.setText(rs.getString("unit"));
                mrpMUnitPriceLbl.setText(Integer.toString(rs.getInt("unit_price")));
                mrpMAvailQtyLbl.setText(Integer.toString(rs.getInt("available_quantity")));
            }
            while(rs1.next()){
                mrpRequiredQtyTF.setText(rs1.getString("sum"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_mrpMIDCBMouseClicked

    private void mrpSaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mrpSaveBtnActionPerformed
        // TODO add your handling code here
        String oid=mrpOrderIDCB.getSelectedItem().toString();
        String mid=mrpMIDCB.getSelectedItem().toString();
        int qty=Integer.parseInt(mrpRequiredQtyTF.getText());
        
        AddToDB.addMRPIntoDB(oid, mid, qty);
        clearFields();
    }//GEN-LAST:event_mrpSaveBtnActionPerformed

    private void bomOrderIDCB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bomOrderIDCB1ActionPerformed
        // TODO add your handling code here:
        try {
            bomMIDCB1.removeAllItems();
            String oid=bomOrderIDCB1.getSelectedItem().toString();
            
            ResultSet rs=new DBSearch().searchMaterialsPerOrder(oid);
            
            while(rs.next()){
                bomMIDCB1.addItem(Integer.toString(rs.getInt("m_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bomOrderIDCB1ActionPerformed

    private void bomMIDCB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bomMIDCB1MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String mid=bomMIDCB1.getSelectedItem().toString();
            String oid=bomOrderIDCB1.getSelectedItem().toString();
            
            ResultSet rs=new DBSearch().searchOneMaterial(mid);
            ResultSet rs1=new DBSearch().searchOneMaterialQuantityPerOrder(oid, mid);
            
            int unitPrice=0;
            int qty=0;
            int totalPrice;
            
            while(rs.next()){
                unitPrice=rs.getInt("unit_price");
                bomMIDNameLbl1.setText(rs.getString("material_description"));
                bomMIDUnitLbl1.setText(rs.getString("unit"));
                bomMUnitPriceLbl1.setText(Integer.toString(rs.getInt("unit_price")));
                bomMAvailQtyLbl1.setText(Integer.toString(rs.getInt("available_quantity")));
            }
            while(rs1.next()){
                qty=Integer.parseInt(rs1.getString("sum"));
                bomRequiredQtyTF1.setText(rs1.getString("sum"));
            }
            totalPrice=unitPrice*qty;
            bomTotalPriceTF.setText(Integer.toString(totalPrice));
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bomMIDCB1MouseClicked

    private void bomSaveBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bomSaveBtn1ActionPerformed
        // TODO add your handling code here:
        String oid=bomOrderIDCB1.getSelectedItem().toString();
        String mid=bomMIDCB1.getSelectedItem().toString();
        int qty=Integer.parseInt(bomRequiredQtyTF1.getText());
        int price=Integer.parseInt(bomTotalPriceTF.getText());
        
        AddToDB.addBoMIntoDB(oid, mid, qty, price);
        clearFields();
    }//GEN-LAST:event_bomSaveBtn1ActionPerformed

    private void issuesOrderIDCB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuesOrderIDCB1ActionPerformed
        // TODO add your handling code here:
        try {
            issuesMIDCB1.removeAllItems();
            String oid=issuesOrderIDCB1.getSelectedItem().toString();
            
            ResultSet rs=new DBSearch().searchMaterialsPerOrder(oid);
            
            while(rs.next()){
                issuesMIDCB1.addItem(Integer.toString(rs.getInt("m_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_issuesOrderIDCB1ActionPerformed

    private void issuesMIDCB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issuesMIDCB1MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String mid=issuesMIDCB1.getSelectedItem().toString();
            String oid=issuesOrderIDCB1.getSelectedItem().toString();
            
            ResultSet rs=new DBSearch().searchOneMaterial(mid);
            ResultSet rs1=new DBSearch().searchOneMaterialQuantityPerOrder(oid, mid);
            
            while(rs.next()){
                issuesMIDNameLbl1.setText(rs.getString("material_description"));
                issuesMIDUnitLbl1.setText(rs.getString("unit"));
                issuesMUnitPriceLbl1.setText(Integer.toString(rs.getInt("unit_price")));
                issuesMAvailQtyLbl1.setText(Integer.toString(rs.getInt("available_quantity")));
            }
            while(rs1.next()){
                issuesRequiredQtyTF1.setText(rs1.getString("sum"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_issuesMIDCB1MouseClicked

    private void issueBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueBtn1ActionPerformed
        // TODO add your handling code here:
        int availQty=Integer.parseInt(issuesMAvailQtyLbl1.getText());
        int reqQty=Integer.parseInt(issuesRequiredQtyTF1.getText());
        String mid=issuesMIDCB1.getSelectedItem().toString();
        
        if(availQty<reqQty){
            JOptionPane.showMessageDialog(null, "Still we cannot issue this order untill we got receives!", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }else{
            int x=availQty-reqQty;
            AddToDB.updateMaterials1(x, mid);
        }
        clearFields();
    }//GEN-LAST:event_issueBtn1ActionPerformed

    private void receivesSaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receivesSaveBtnActionPerformed
        // TODO add your handling code here:
        String mid=receivesMIDCB.getSelectedItem().toString();
        int newQty=Integer.parseInt(receivesQtyTF.getText());
        int availQty=Integer.parseInt(receivesMIDQtyLbl.getText());

        int y=availQty+newQty;

        AddToDB.updateMaterials2(y, mid);

        clearFields();
    }//GEN-LAST:event_receivesSaveBtnActionPerformed

    private void receivesMIDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receivesMIDCBActionPerformed
        try {
            
            String mid=receivesMIDCB.getSelectedItem().toString();
            
            
            ResultSet rs=new DBSearch().searchOneMaterial(mid);
            
            while(rs.next()){
                receivesMIDQtyLbl.setText(Integer.toString(rs.getInt("available_quantity")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_receivesMIDCBActionPerformed

    private void avgPIDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avgPIDCBActionPerformed
        try {
            // TODO add your handling code here:
            String pid=avgPIDCB.getSelectedItem().toString();
            
            ResultSet rs=new DBSearch().searchForecasting(pid);
            int i=0;
            while(rs.next()){
                i++;
                if(i==1){
                    month1Lbl.setText(rs.getString("month"));
                    qty1Lbl.setText(rs.getString("sum"));
                }else if(i==2){
                    month2Lbl.setText(rs.getString("month"));
                    qty2Lbl.setText(rs.getString("sum"));
                }else if(i==3){
                    month3Lbl.setText(rs.getString("month"));
                    qty3Lbl.setText(rs.getString("sum"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_avgPIDCBActionPerformed

    private void forecastBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forecastBtnActionPerformed
        // TODO add your handling code here:
        int qty1=Integer.parseInt(qty1Lbl.getText());
        int qty2=Integer.parseInt(qty2Lbl.getText());
        int qty3=Integer.parseInt(qty3Lbl.getText());
        
        int x=(qty1+qty2+qty3)/3;
        
        nextMonthLbl.setText(Integer.toString(x));
    }//GEN-LAST:event_forecastBtnActionPerformed

    private void avgPIDCB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avgPIDCB1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String pid=avgPIDCB1.getSelectedItem().toString();
            
            ResultSet rs=new DBSearch().searchForecasting(pid);
            int i=0;
            while(rs.next()){
                i++;
                if(i==1){
                    month1Lbl1.setText(rs.getString("month"));
                    qty1Lbl1.setText(rs.getString("sum"));
                }else if(i==2){
                    month2Lbl1.setText(rs.getString("month"));
                    qty2Lbl1.setText(rs.getString("sum"));
                }else if(i==3){
                    month3Lbl1.setText(rs.getString("month"));
                    qty3Lbl1.setText(rs.getString("sum"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Toy_Manufacturing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_avgPIDCB1ActionPerformed

    private void forecastBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forecastBtn1ActionPerformed
        // TODO add your handling code here:
        int qty1=Integer.parseInt(qty1Lbl1.getText());
        int qty2=Integer.parseInt(qty2Lbl1.getText());
        int qty3=Integer.parseInt(qty3Lbl1.getText());
        
        int weight1=Integer.parseInt(weight1TF.getText());
        int weight2=Integer.parseInt(weight2TF.getText());
        int weight3=Integer.parseInt(weight3TF.getText());
        
        int y=weight1+weight2+weight3;
        if(y>100){
            JOptionPane.showMessageDialog(null, "The sum of the weight must be 100%", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        int x=((qty1*weight1/100)+(qty2*weight2/100)+(qty3*weight3/100));
        
        nextMonthLbl1.setText(Integer.toString(x));
    }//GEN-LAST:event_forecastBtn1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Toy_Manufacturing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Toy_Manufacturing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Toy_Manufacturing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Toy_Manufacturing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Toy_Manufacturing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton addBtn3;
    private javax.swing.JLabel addressLbl;
    private javax.swing.JTextField addressTF;
    private javax.swing.JTextField availQtyTF;
    private javax.swing.JComboBox<String> avgPIDCB;
    private javax.swing.JComboBox<String> avgPIDCB1;
    private javax.swing.JButton bomBtn;
    private javax.swing.JLabel bomMAvailQtyLbl1;
    private javax.swing.JComboBox<String> bomMIDCB1;
    private javax.swing.JLabel bomMIDNameLbl1;
    private javax.swing.JLabel bomMIDUnitLbl1;
    private javax.swing.JLabel bomMUnitPriceLbl1;
    private javax.swing.JComboBox<String> bomOrderIDCB1;
    private javax.swing.JTextField bomRequiredQtyTF1;
    private javax.swing.JButton bomSaveBtn1;
    private javax.swing.JTextField bomTotalPriceTF;
    private javax.swing.JComboBox<String> customerIDCB;
    private javax.swing.JComboBox<String> customerIDCB2;
    private javax.swing.JButton customersBtn;
    private com.toedter.calendar.JDateChooser dateDP;
    private javax.swing.JButton delete2Btn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton deleteBtn3;
    private javax.swing.JComboBox<String> departmentCB;
    private javax.swing.JLabel descriptionLbl;
    private javax.swing.JTextField descriptionTF;
    private javax.swing.JButton existingBtn;
    private javax.swing.JButton forecastBtn;
    private javax.swing.JButton forecastBtn1;
    private javax.swing.JButton issueBtn1;
    private javax.swing.JButton issuesBtn;
    private javax.swing.JLabel issuesMAvailQtyLbl1;
    private javax.swing.JComboBox<String> issuesMIDCB1;
    private javax.swing.JLabel issuesMIDNameLbl1;
    private javax.swing.JLabel issuesMIDUnitLbl1;
    private javax.swing.JLabel issuesMUnitPriceLbl1;
    private javax.swing.JComboBox<String> issuesOrderIDCB1;
    private javax.swing.JTextField issuesRequiredQtyTF1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jpBoM;
    private javax.swing.JPanel jpCustomers;
    private javax.swing.JPanel jpIssues;
    private javax.swing.JPanel jpLogin;
    private javax.swing.JPanel jpMRP;
    private javax.swing.JPanel jpMovingAvg;
    private javax.swing.JPanel jpOrderPlacing;
    private javax.swing.JPanel jpProductPlanning;
    private javax.swing.JPanel jpProducts;
    private javax.swing.JPanel jpReceives;
    private javax.swing.JPanel jpRowMaterials;
    private javax.swing.JPanel jpWeightedMovingAvg;
    private javax.swing.JButton loginBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton mAddBtn;
    private javax.swing.JButton mDeleteBtn;
    private javax.swing.JTextField mDescTF;
    private javax.swing.JLabel mMIDNameLbl;
    private javax.swing.JButton mUpdateBtn;
    private javax.swing.JComboBox<String> midCB;
    private javax.swing.JLabel month1Lbl;
    private javax.swing.JLabel month1Lbl1;
    private javax.swing.JLabel month2Lbl;
    private javax.swing.JLabel month2Lbl1;
    private javax.swing.JLabel month3Lbl;
    private javax.swing.JLabel month3Lbl1;
    private javax.swing.JButton movingAvgBtn;
    private javax.swing.JButton mrpBtn;
    private javax.swing.JLabel mrpMAvailQtyLbl;
    private javax.swing.JComboBox<String> mrpMIDCB;
    private javax.swing.JLabel mrpMIDUnitLbl;
    private javax.swing.JLabel mrpMUnitPriceLbl;
    private javax.swing.JComboBox<String> mrpOrderIDCB;
    private javax.swing.JTextField mrpRequiredQtyTF;
    private javax.swing.JButton mrpSaveBtn;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTF;
    private javax.swing.JButton newBtn;
    private javax.swing.JLabel nextMonthLbl;
    private javax.swing.JLabel nextMonthLbl1;
    private javax.swing.JComboBox<String> orderIDCB;
    private javax.swing.JButton orderPlacingBtn;
    private javax.swing.JButton pAddBtn;
    private javax.swing.JButton pDeleteBtn;
    private javax.swing.JLabel pMaterialAvailQtyLbl;
    private javax.swing.JComboBox<String> pMaterialIDCB;
    private javax.swing.JLabel pMaterialNameLbl;
    private javax.swing.JLabel pMaterialUPriceLbl;
    private javax.swing.JLabel pMaterialUnitLbl;
    private javax.swing.JLabel pProductDescLbl;
    private javax.swing.JComboBox<String> pProductIDCB;
    private javax.swing.JTextField pRequiredQtyTF;
    private javax.swing.JButton pUpdateBtn;
    private javax.swing.JPasswordField passwordPF;
    private javax.swing.JButton ppExistingBtn;
    private javax.swing.JButton ppNewBtn;
    private javax.swing.JComboBox<String> productIDCB;
    private javax.swing.JComboBox<String> productIDCB2;
    private javax.swing.JButton productPlanningBtn;
    private javax.swing.JButton productsBtn;
    private javax.swing.JLabel qty1Lbl;
    private javax.swing.JLabel qty1Lbl1;
    private javax.swing.JLabel qty2Lbl;
    private javax.swing.JLabel qty2Lbl1;
    private javax.swing.JLabel qty3Lbl;
    private javax.swing.JLabel qty3Lbl1;
    private javax.swing.JButton receivesBtn;
    private javax.swing.JComboBox<String> receivesMIDCB;
    private javax.swing.JLabel receivesMIDQtyLbl;
    private javax.swing.JTextField receivesQtyTF;
    private javax.swing.JButton receivesSaveBtn;
    private javax.swing.JTextField requiredQtyTF;
    private javax.swing.JButton rowMaterialsBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel telLbl;
    private javax.swing.JTextField telTF;
    private javax.swing.JComboBox<String> unitCB;
    private javax.swing.JTextField unitPriceTF;
    private javax.swing.JButton update2Btn;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton updateBtn3;
    private javax.swing.JTextField usernameTF;
    private javax.swing.JTextField weight1TF;
    private javax.swing.JTextField weight2TF;
    private javax.swing.JTextField weight3TF;
    private javax.swing.JButton weightedMovingAvgBtn;
    // End of variables declaration//GEN-END:variables
}
