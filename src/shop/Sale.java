/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author User
 */
public class Sale extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;

    /**
     * Creates new form Sale
     */
    public Sale() {
        initComponents();
        conn = DatabaseConnection.java_db();
        combo();
        randomNumber();
        showDate();
        refreshTable();
        comboReciver();
    }

    //SHOW SALE AVAIBLE PRODUCT
    public void refreshTable() {
        try {
            String query = "select * from purchase";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    //get product for combobox
    public void combo() {

        try {
            String query = "select p_name  from purchase";
            PreparedStatement pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                producrCombo.addItem(rs.getString("p_name"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //RANDOM VALUE FOR SLNO

    public void randomNumber() {
        Random ran = new Random();
        int num = ran.nextInt(100000) + 1;
        String val = String.valueOf(num);
        sLo.setText(val);
    }

    //CREATE DATE
    public Date showDate() {
        Date da = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        cu_date.setText(formatter.format(da));
        return da;

    }

    public void getSum() {
        double sum = 0.0;

        for (int i = 0; i < saleTable.getRowCount(); i++) {
            sum = sum + Double.parseDouble(saleTable.getValueAt(i, 3).toString());
        }
        total_amount.setText(Double.toString(sum));
        //System.out.println(sum);
        double p_discount = 0;
        if (sum >= 1000) {
            p_discount = sum * .05;
            sum = sum - p_discount;
            discount.setText(Double.toString(p_discount));
        } else if (sum >= 100000) {
            p_discount = sum * .05;
            sum = sum - p_discount;
            discount.setText(Double.toString(p_discount));
        } else if (sum > 20000) {
            p_discount = sum * .05;
            sum = sum - p_discount;
            discount.setText(Double.toString(p_discount));
        } else {
            discount.setText(Double.toString(p_discount));

        }
        payment.setText(Double.toString(sum));

    }

    //get employe for reciver
    public void comboReciver() {
        try {
            String query = "select name from  employeeinfo where post='cashier'";
            PreparedStatement pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                reciver.addItem(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void btnDonevalidation() {
        if (cName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter custommer name.");
        } else if (producrCombo.getSelectedItem() == "SELECT ONE") {
            JOptionPane.showMessageDialog(null, "Select product name");
        } else if (qty.getText().isEmpty() || Integer.parseInt(qty.getText()) > Integer.parseInt(ava_qty.getText())) {
            JOptionPane.showMessageDialog(null, "Plase enter product qty");
        } else if (pay.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please baki chahi Lozza diven na");
        } else if (reciver.getSelectedItem() == "SELECT ONE") {
            JOptionPane.showMessageDialog(null, "Select Reciver Name");
        }

    }

    public void btnSalevalidation() {
        if (producrCombo.getSelectedItem() == "SELECT ONE") {
            JOptionPane.showMessageDialog(null, "Select product name");
            //return true;
        } else if (qty.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Plase enter product qty");
            //return true;
        } else if (Integer.parseInt(qty.getText()) > Integer.parseInt(ava_qty.getText())) {
            JOptionPane.showMessageDialog(null, "Product is not avabilable ");
            //return true;
        }
        //return true;
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
        sLo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cu_date = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        producrCombo = new javax.swing.JComboBox<>();
        pPrice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        saleTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        total_amount = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        discount = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pay = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        payment = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        change = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        reciver = new javax.swing.JComboBox<>();
        removeSale = new javax.swing.JButton();
        saleButton = new javax.swing.JButton();
        doneSale = new javax.swing.JButton();
        invoice = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        ava_qty = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MA SUPER SHOP");

        jPanel1.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SL.NO");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 380, 50, 30);
        jPanel1.add(sLo);
        sLo.setBounds(90, 380, 130, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DATE");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(230, 380, 70, 40);

        cu_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cu_dateActionPerformed(evt);
            }
        });
        jPanel1.add(cu_date);
        cu_date.setBounds(320, 380, 130, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("C_NAME");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 450, 60, 30);
        jPanel1.add(cName);
        cName.setBounds(90, 440, 130, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 500, 60, 30);
        jPanel1.add(pid);
        pid.setBounds(90, 490, 130, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("P_NAME");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(240, 440, 70, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PRICE");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(240, 490, 60, 30);

        producrCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT ONE" }));
        producrCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                producrComboActionPerformed(evt);
            }
        });
        jPanel1.add(producrCombo);
        producrCombo.setBounds(320, 440, 130, 40);
        jPanel1.add(pPrice);
        pPrice.setBounds(320, 490, 130, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 440, 270);

        saleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "P_NAME", "QTY", "PRICE"
            }
        ));
        saleTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saleTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(saleTable);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(460, 100, 410, 270);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(890, 100, 420, 420);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TOTAL");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(470, 390, 60, 30);
        jPanel1.add(total_amount);
        total_amount.setBounds(560, 390, 110, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DISCOUNT");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(680, 390, 70, 30);
        jPanel1.add(discount);
        discount.setBounds(770, 390, 110, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("PAY");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(690, 440, 60, 30);
        jPanel1.add(pay);
        pay.setBounds(770, 440, 110, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("PAYMENT");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(470, 440, 70, 40);
        jPanel1.add(payment);
        payment.setBounds(560, 440, 110, 40);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("CHANGE");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(470, 490, 60, 30);
        jPanel1.add(change);
        change.setBounds(560, 490, 110, 40);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("RECIVER");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(690, 490, 60, 30);

        reciver.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT ONE" }));
        jPanel1.add(reciver);
        reciver.setBounds(770, 490, 110, 30);

        removeSale.setText("REVOVE");
        removeSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSaleActionPerformed(evt);
            }
        });
        jPanel1.add(removeSale);
        removeSale.setBounds(110, 610, 100, 40);

        saleButton.setText("SALE");
        saleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saleButton);
        saleButton.setBounds(340, 610, 110, 40);

        doneSale.setText("DONE");
        doneSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneSaleActionPerformed(evt);
            }
        });
        jPanel1.add(doneSale);
        doneSale.setBounds(560, 550, 110, 40);

        invoice.setText("INVOICE");
        invoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceActionPerformed(evt);
            }
        });
        jPanel1.add(invoice);
        invoice.setBounds(770, 550, 90, 40);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("AVAI_QTY");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(10, 540, 70, 30);
        jPanel1.add(ava_qty);
        ava_qty.setBounds(90, 540, 130, 40);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("QTY");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(240, 550, 50, 30);
        jPanel1.add(qty);
        qty.setBounds(320, 540, 120, 40);

        jButton1.setText("CLEAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(680, 630, 80, 40);

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 182, 194));
        jLabel16.setText("SALE ZONE");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(522, 0, 280, 50);

        jLabel17.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(249, 134, 200));
        jLabel17.setText("SHOW AVAILABLE PRODUCT FOR SALE");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(10, 34, 360, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel18.setText("SALE DETAILS");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(620, 74, 130, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shop/high-definition-animated-background-loop-of-red-sale-tags-falling-randomly_71oxov-v__F0000.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1320, 710);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1318, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cu_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cu_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cu_dateActionPerformed

    private void invoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceActionPerformed

        if (change.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Sale  product ");
            return;
        }

        jTextArea1.append("\t\b\b\b \b \b \b \b  MA SUPER SHOP\n\n\n" + "INVOICE NUMBER: " + sLo.getText() + "\t\t" + "DATE: " + cu_date.getText() + "\n\nCUSTOMAR NAME " + cName.getText() + "\n\nPRODECT\t\t" + "QTY\t\t" + "PRICE" + "\n=====================================================================================\n");

        for (int i = 0; i < saleTable.getRowCount(); i++) {
            Double.parseDouble(saleTable.getValueAt(i, 3).toString());
            jTextArea1.append(saleTable.getValueAt(i, 1).toString() + "\t\t" + saleTable.getValueAt(i, 2).toString() + "\t\t" + saleTable.getValueAt(i, 3).toString() + "\n");
        }
        jTextArea1.append("========================================================================================\n");
        jTextArea1.append("\t\t\t\b\tTOTAL     =" + total_amount.getText());
        jTextArea1.append("\n\t\t\t\b\tDISCOUNT=" + discount.getText());
        jTextArea1.append("\n\t\t\t\b\tPAYMENT =" + payment.getText());
        jTextArea1.append("\n\t\t\t\b\tPAY     =" + pay.getText());
        jTextArea1.append("\n\t\t\t\b\tCHANGE  =" + change.getText());
        jTextArea1.append("\n\t\t\t\b\tRECIVER =" + reciver.getSelectedItem());
        jTextArea1.append("\n\n\t\b\b\b \b \b \b \bDONET BLOOD SAVE LIFE");
    }//GEN-LAST:event_invoiceActionPerformed

    private void producrComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_producrComboActionPerformed
        try {
            String sql = " select * from purchase where p_name=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, (String) producrCombo.getSelectedItem());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pid.setText(rs.getString("id"));
                pPrice.setText(rs.getString("p_price"));
                ava_qty.setText(rs.getString("qty"));

            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_producrComboActionPerformed

    private void saleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleButtonActionPerformed
        if (producrCombo.getSelectedItem() == "SELECT ONE") {
            JOptionPane.showMessageDialog(null, "Select product name");
            return;
        } else if (qty.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Plase enter product qty");
            return;
        } else if (Integer.parseInt(qty.getText()) > Integer.parseInt(ava_qty.getText())) {
            JOptionPane.showMessageDialog(null, "Product is not avabilable ");
            return;
        }
        //else
        try {
            DefaultTableModel model = (DefaultTableModel) saleTable.getModel();
            int price = Integer.parseInt(pPrice.getText());//price
            int p_qty = Integer.parseInt(qty.getText());//quenty
            int sa_price = price * p_qty;
            String total_price = String.valueOf(sa_price);
            model.addRow(new Object[]{
                pid.getText(), producrCombo.getSelectedItem(), qty.getText(), total_price

            });
            getSum();
            String sql = "Update purchase set qty=qty - " + p_qty + " where id='" + pid.getText() + "' ";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            pst.close();
            getSum();
            //field value cleare
            refreshTable();
            producrCombo.setSelectedIndex(0);
            pid.setText("");
            pPrice.setText("");
            ava_qty.setText("");
            qty.setText("");

        } catch (SQLException ex) {
            Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_saleButtonActionPerformed

    private void removeSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSaleActionPerformed
        int OK = saleTable.getSelectedRow();
        if (!saleTable.isRowSelected(OK)) {
            JOptionPane.showMessageDialog(null, "Plase Select Product details\n which are processing to sale ");
            return;
        }
        try {
            DefaultTableModel model = (DefaultTableModel) saleTable.getModel();
            model.removeRow(saleTable.getSelectedRow());
            int se_qty = Integer.parseInt(qty.getText());
            String sql = "Update purchase set qty=qty +" + se_qty + " where id='" + pid.getText() + "' ";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            pst.close();
            getSum();
            refreshTable();
            //producrCombo.setSelectedIndex(0);
            pid.setText("");
            //pPrice.setText("");
            //ava_qty.setText("");
            qty.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_removeSaleActionPerformed

    private void saleTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saleTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) saleTable.getModel();
        pid.setText(model.getValueAt(saleTable.getSelectedRow(), 0).toString());
        producrCombo.setSelectedItem(model.getValueAt(saleTable.getSelectedRow(), 1).toString());
        qty.setText(model.getValueAt(saleTable.getSelectedRow(), 2).toString());// TODO add your handling code here:
    }//GEN-LAST:event_saleTableMouseClicked

    private void doneSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneSaleActionPerformed
        if (cName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter custommer name.");
            return;
        } else if (total_amount.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Select product Sale");
            return;
        } else if (pay.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please pay payment");
            return;
        } else if (Double.parseDouble(payment.getText()) > Double.parseDouble(pay.getText())) {
            JOptionPane.showMessageDialog(null, "please paid full payment");
            return;
        } else if (reciver.getSelectedItem() == "SELECT ONE") {
            JOptionPane.showMessageDialog(null, "Select Reciver Name");
            return;
        }
        double cChange = 0.0;
        double total_pay = Double.parseDouble(payment.getText());
        double c_pay = Double.parseDouble(pay.getText());
        cChange = c_pay - total_pay;
        change.setText(String.valueOf(cChange));
        try {
            String query = "insert into bill_tabele (C_Name,Ricevier,Date,S_price,Discount,Payment) values (?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, cName.getText());
            pst.setString(2, reciver.getSelectedItem().toString());
            java.util.Date uDate = new java.util.Date();
            java.sql.Date sDate = convertUtilToSql(uDate);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String dat = sdf.format(sDate);
            pst.setString(3, dat);
            pst.setString(4, total_amount.getText());
            pst.setString(5, discount.getText());
            //pst.setString(6, discount1.getText());
            pst.setString(6, payment.getText());

            pst.execute();
            pst.close();

            JOptionPane.showMessageDialog(null, "Data Saved");

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_doneSaleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        sLo.setText("");
        cName.setText("");
        cu_date.setText("");
        reciver.setSelectedIndex(0);
        total_amount.setText("");
        discount.setText("");
        payment.setText("");
        pay.setText("");
        change.setText("");
        saleTable.setModel(new DefaultTableModel(null, new String[]{"ID", "p_name", "QTY", "PRICE"}));
        jTextArea1.setText("");
        randomNumber();
        showDate();

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ava_qty;
    private javax.swing.JTextField cName;
    private javax.swing.JTextField change;
    private javax.swing.JTextField cu_date;
    private javax.swing.JTextField discount;
    private javax.swing.JButton doneSale;
    private javax.swing.JButton invoice;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField pPrice;
    private javax.swing.JTextField pay;
    private javax.swing.JTextField payment;
    private javax.swing.JTextField pid;
    private javax.swing.JComboBox<String> producrCombo;
    private javax.swing.JTextField qty;
    private javax.swing.JComboBox<String> reciver;
    private javax.swing.JButton removeSale;
    private javax.swing.JTextField sLo;
    private javax.swing.JButton saleButton;
    private javax.swing.JTable saleTable;
    private javax.swing.JTextField total_amount;
    // End of variables declaration//GEN-END:variables
 private java.sql.Date convertUtilToSql(Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate; //To change body of generated methods, choose Tools | Templates.
    }
}
