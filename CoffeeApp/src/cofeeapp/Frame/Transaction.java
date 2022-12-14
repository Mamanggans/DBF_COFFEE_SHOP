/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cofeeapp.Frame;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import cofeeapp.Controller.MainController;
import coffeapp.Connection.Koneksi;
import coffeapp.Helper.Helper;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author M DANI SETIAWAN
 */
public class Transaction extends javax.swing.JFrame {
    private final MainController controller;
    private String transaction_id;
    

    /**
     * Creates new form AlpikasiInventori
     */
    public Transaction() {
        initComponents();
        MainController mainController = new MainController();
        controller = mainController;
        loadTable();
        clearForm();
        combo_pelanggan();
        combo_coffee();
        
    }
    
    public void loadTable(){
        String sql = "select * from tbTransaction";
        controller.get(tb_productx, sql);
        System.out.println("Worked!");
    }
    
    private void clearForm(){
        tf_qty.setText(null);
        dp_dateofpurchase.setDate(null);
        btn_update.setEnabled(false);
        btn_delete.setEnabled(false);
        tf_totalprice.setText(null);
    }
   
    
    public void cari_kopi()
    {
        try {
        Connection con = Koneksi.open();
        String sql = "select Price from tbCoffee where Name='"+cb_coffee.getSelectedItem()+"'"; 
        Statement st = Koneksi.open().createStatement();
        ResultSet rs = st.executeQuery(sql);                              // yang anda ingin kan
        
        while(rs.next()){
        this.tf_hargacoffee.setText(rs.getString("Price"));
        }
        rs.close(); st.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }     
    }
    public void combo_coffee()
    {
        try {
        Connection con = Koneksi.open();
        Statement st = con.createStatement();
        String sql = "select Price,Name from tbCoffee order by Price asc";
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()){
            String nama = rs.getString("Name");
            cb_coffee.addItem(nama);
        }
        rs.close(); st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    public void cari_nama()
    {
        try {
        Connection con = Koneksi.open();
        String sql = "select ID_Customer from tbCustomer where Customer_Name='"+cb_customername.getSelectedItem()+"'"; 
        Statement st = Koneksi.open().createStatement();
        ResultSet rs = st.executeQuery(sql);                              // yang anda ingin kan
        
        while(rs.next()){
        this.tf_customerid.setText(rs.getString("ID_Customer"));
        }
        rs.close(); st.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }     
    }
    
    public void combo_pelanggan()
    {
        try {
        Connection con = Koneksi.open();
        Statement st = con.createStatement();
        String sql = "select ID_Customer,Customer_Name from tbCustomer order by ID_Customer asc";
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()){
            String nama = rs.getString("Customer_Name");
            cb_customername.addItem(nama);
        }
        rs.close(); st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void AutoSum() {     
        int a, b, c;
        a = Integer.parseInt(tf_hargacoffee.getText());
        b = Integer.parseInt(tf_qty.getText());
        c = a*b;
        tf_totalprice.setText(""+c);
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_productx = new javax.swing.JTable();
        dp_dateofpurchase = new org.jdesktop.swingx.JXDatePicker();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_submit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cb_customername = new javax.swing.JComboBox();
        tf_hargacoffee = new javax.swing.JTextField();
        tf_totalprice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cb_coffee = new javax.swing.JComboBox();
        tf_customerid = new javax.swing.JTextField();
        tf_qty = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tf_pencarian = new javax.swing.JTextField();
        btn_carinama = new javax.swing.JButton();
        btn_cariid = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(233, 160, 107));
        jPanel1.setPreferredSize(new java.awt.Dimension(740, 430));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Customer Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Qty");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, -1, 10));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Coffee Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Date Of Purchase");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 30));

        tb_productx.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_productx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_productxMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_productx);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1000, 240));

        dp_dateofpurchase.setForeground(new java.awt.Color(0, 0, 0));
        dp_dateofpurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dp_dateofpurchaseActionPerformed(evt);
            }
        });
        jPanel1.add(dp_dateofpurchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 210, 30));

        jPanel2.setBackground(new java.awt.Color(210, 105, 30));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Monotype Corsiva", 1, 48)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coffeapp/image/text-file-2-64(1)_1.png"))); // NOI18N
        jLabel9.setText("Transaction");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jButton6.setBackground(new java.awt.Color(210, 105, 30));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coffeapp/image/arrow-91-32.png"))); // NOI18N
        jButton6.setText("Back");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, 80, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 100));

        jPanel3.setBackground(new java.awt.Color(210, 105, 30));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_submit.setBackground(new java.awt.Color(0, 255, 0));
        btn_submit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_submit.setForeground(new java.awt.Color(255, 255, 255));
        btn_submit.setText("Submit");
        btn_submit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(210, 105, 30)));
        btn_submit.setFocusPainted(false);
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });
        jPanel3.add(btn_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 100, 30));

        btn_delete.setBackground(new java.awt.Color(255, 0, 0));
        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Delete");
        btn_delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(210, 105, 30)));
        btn_delete.setFocusPainted(false);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel3.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 100, 30));

        btn_update.setBackground(new java.awt.Color(0, 0, 255));
        btn_update.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Update");
        btn_update.setFocusPainted(false);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel3.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 100, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("D.B.F ?? 2019 Powered By Net Beans");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 230, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 1000, 50));

        cb_customername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_customernameActionPerformed(evt);
            }
        });
        jPanel1.add(cb_customername, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 210, 30));

        tf_hargacoffee.setEditable(false);
        tf_hargacoffee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_hargacoffeeActionPerformed(evt);
            }
        });
        jPanel1.add(tf_hargacoffee, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 110, 30));

        tf_totalprice.setEditable(false);
        tf_totalprice.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        tf_totalprice.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        tf_totalprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_totalpriceActionPerformed(evt);
            }
        });
        tf_totalprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_totalpriceKeyPressed(evt);
            }
        });
        jPanel1.add(tf_totalprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 430, 80));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Total Price");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, -1, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Coffee Price");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

        cb_coffee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_coffeeActionPerformed(evt);
            }
        });
        jPanel1.add(cb_coffee, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 210, 30));

        tf_customerid.setEditable(false);
        jPanel1.add(tf_customerid, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 110, 30));

        tf_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_qtyKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_qtyKeyTyped(evt);
            }
        });
        jPanel1.add(tf_qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 100, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("ID Customer");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, 20));
        jPanel1.add(tf_pencarian, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, 170, 30));

        btn_carinama.setBackground(new java.awt.Color(255, 255, 255));
        btn_carinama.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_carinama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coffeapp/image/search-2-24.png"))); // NOI18N
        btn_carinama.setText("Name");
        btn_carinama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(210, 105, 30)));
        btn_carinama.setFocusPainted(false);
        btn_carinama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_carinamaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_carinama, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, 80, 30));

        btn_cariid.setBackground(new java.awt.Color(255, 255, 255));
        btn_cariid.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_cariid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coffeapp/image/search-2-24.png"))); // NOI18N
        btn_cariid.setText("ID");
        btn_cariid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(210, 105, 30)));
        btn_cariid.setFocusPainted(false);
        btn_cariid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariidActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cariid, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 220, 80, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Search");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        try{    
            Helper helper = new Helper();
            String expired = helper.parseDatatoDatabase(dp_dateofpurchase);
            
            String sql = "DELETE FROM tbTransaction WHERE ID_Transaction = ?";
            
            Map<Integer, Object> map = new HashMap<>();
            map.put(1, this.transaction_id);
            
            if(controller.preparedStatement(map, sql)){
                clearForm();
                loadTable();
                JOptionPane.showMessageDialog(null, "Berhasil Menghapus Data");
            }
            else{
                JOptionPane.showMessageDialog(null, "Gagal Menghapus Data");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
         try {
            // TODO add your handling code here:
           
            String customername = cb_customername.getSelectedItem().toString();
            String customerid = tf_customerid.getText();
            String coffeename = cb_coffee.getSelectedItem().toString();
            String coffeeprice = tf_hargacoffee.getText();
            String qty = tf_qty.getText();
            String totalharga = tf_totalprice.getText();
            
            Helper helper = new Helper();
            String datepurchase = helper.parseDatatoDatabase(dp_dateofpurchase);
            
            String sql = "INSERT INTO tbTransaction (Customer_Name,ID_Customer, Coffee_Name, "
                    + "Coffee_Price,Qty,Total_Price, Date_Of_Purchase) values (?,?,?,?,?,?,?)";
            
            Map<Integer, Object> map = new HashMap<>();
            map.put(1, customername);
            map.put(2, customerid);
            map.put(3, coffeename);
            map.put(4, coffeeprice);
            map.put(5, qty);
            map.put(6, totalharga);
            map.put(7, datepurchase);
            
            if(!controller.preparedStatement(map, sql)){
                JOptionPane.showMessageDialog(null, "Gagal Menambahkan Data");
            }
            clearForm();
            loadTable();
            JOptionPane.showMessageDialog(null, "Berhasil Menambahkan Data");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
    } 
         
    }//GEN-LAST:event_btn_submitActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try {    
        
            String customername = cb_customername.getSelectedItem().toString();
            String customerid = tf_customerid.getText();
            String coffeename = cb_coffee.getSelectedItem().toString();
            String coffeeprice = tf_hargacoffee.getText();
            String qty = tf_qty.getText();
            String totalharga = tf_totalprice.getText();
            
            Helper helper = new Helper();
            String datepurchase = helper.parseDatatoDatabase(dp_dateofpurchase);
            

            
            String sql = "UPDATE tbTransaction SET Customer_Name = ?, ID_Customer = ?, "
                    + "Coffee_Name = ?, Coffee_Price = ?, Qty = ?,Total_Price = ?,Date_Of_Purchase = ? WHERE ID_Transaction = ?";
            
            Map<Integer, Object> map = new HashMap<>();
            map.put(1, customername);
            map.put(2, customerid);
            map.put(3, coffeename);
            map.put(4, coffeeprice);
            map.put(5, qty);
            map.put(6, totalharga);
            map.put(7, datepurchase);
            map.put(8, this.transaction_id);
            
            if(controller.preparedStatement(map, sql)){
                clearForm();
                loadTable();
                JOptionPane.showMessageDialog(null, "Berhasil Merubah Data");
            }
            else{
                JOptionPane.showMessageDialog(null, "Gagal Merubah Data");
            }
            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
    }//GEN-LAST:event_btn_updateActionPerformed
    }
    private void btn_carinamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_carinamaActionPerformed
        // TODO add your handling code here:
        String search = tf_pencarian.getText();
        String sql = "SELECT * FROM tbTransaction WHERE Customer_Name LIKE '%"+ search +"%';";
        controller.get(tb_productx, sql);
    }//GEN-LAST:event_btn_carinamaActionPerformed

    private void btn_cariidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariidActionPerformed
        // TODO add your handling code here:
        String search = tf_pencarian.getText();
        String sql = "SELECT * FROM tbTransaction WHERE ID_Transaction = ?";
        Map<Integer, Object> map = new HashMap<>();
            map.put(1, search);
            
        controller.getWithParameter(tb_productx, map, sql);
    }//GEN-LAST:event_btn_cariidActionPerformed

    private void tb_productxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_productxMouseClicked
        try {                                        
            // TODO add your handling code here:
            Helper helper = new Helper();
            String id = helper.getValueRows(tb_productx, 0);
            String customerid = helper.getValueRows(tb_productx, 1);
            String customername = helper.getValueRows(tb_productx, 2);
            String coffeename = helper.getValueRows(tb_productx, 3);
            String coffeeprice = helper.getValueRows(tb_productx, 4);
            String qty = helper.getValueRows(tb_productx, 5);
            String totalharga = helper.getValueRows(tb_productx, 6);
            String dateofpurchase = helper.getValueRows(tb_productx, 7);
            
            btn_update.setEnabled(true);
            btn_delete.setEnabled(true);
            
            this.transaction_id = id;
            tf_customerid.setText(customerid);
            cb_customername.setSelectedItem(customername);
            cb_coffee.setSelectedItem(coffeename);
            tf_hargacoffee.setText(coffeeprice);
            tf_qty.setText(qty);
            tf_totalprice.setText(totalharga);
            dp_dateofpurchase.setDate(new Date(helper.getParsedDate(dateofpurchase)));
        } catch (ParseException ex) {
            Logger.getLogger(CoffeeDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tb_productxMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void dp_dateofpurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dp_dateofpurchaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dp_dateofpurchaseActionPerformed

    private void cb_customernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_customernameActionPerformed
        // TODO add your handling code here:
        cari_nama();
    }//GEN-LAST:event_cb_customernameActionPerformed

    private void tf_hargacoffeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_hargacoffeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_hargacoffeeActionPerformed

    private void tf_totalpriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_totalpriceKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_totalpriceKeyPressed

    private void tf_totalpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_totalpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_totalpriceActionPerformed

    private void cb_coffeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_coffeeActionPerformed
        // TODO add your handling code here:
        cari_kopi();
    }//GEN-LAST:event_cb_coffeeActionPerformed

    private void tf_qtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_qtyKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {  
        AutoSum();
        }
    }//GEN-LAST:event_tf_qtyKeyPressed

    private void tf_qtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_qtyKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_qtyKeyTyped
    
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
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cariid;
    private javax.swing.JButton btn_carinama;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_submit;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox cb_coffee;
    private javax.swing.JComboBox cb_customername;
    private org.jdesktop.swingx.JXDatePicker dp_dateofpurchase;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_productx;
    private javax.swing.JTextField tf_customerid;
    private javax.swing.JTextField tf_hargacoffee;
    private javax.swing.JTextField tf_pencarian;
    private javax.swing.JTextField tf_qty;
    private javax.swing.JTextField tf_totalprice;
    // End of variables declaration//GEN-END:variables
}
