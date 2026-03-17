
package admin;

import config.LogService;
import config.Session;
import config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;



public class Orderform extends javax.swing.JFrame {

private Order orderPanel;
private Integer orderId = null;

private int oldCustomerId;
private int oldServiceId;
private double oldWeight;
private String oldStatus;
private String PStatus;

public Orderform(Order ordersPanel, Integer orderId) {
    initComponents();
    this.orderPanel = ordersPanel;   
    this.orderId = orderId;
    this.PStatus = "Unpaid";

    loadCustomersTable();   
    loadServices();
    loadStatus();

    if (this.orderId != null) {
        loadOrderData();
    }
}

public void setSelectedCustomer(String customer) {
    txtCustomer.setText(customer);
}


private void loadServices() {
    try {
        config conf = new config();
        Connection conn = conf.connectDB();
        PreparedStatement pst = conn.prepareStatement("SELECT S_id, service_name FROM tbl_services");
        ResultSet rs = pst.executeQuery();

        sdata.removeAllItems();

        while (rs.next()) {
            sdata.addItem(rs.getInt("S_id") + " - " + rs.getString("service_name"));
        }

        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }
}

private void loadStatus() {
    stat.removeAllItems();
    stat.addItem("Pending");
    stat.addItem("In Progress");
    stat.addItem("Completed");
    stat.addItem("Picked Up");
    stat.addItem("Cancelled");
}

private void loadCustomersTable() {
    try {
        config conf = new config();
        Connection conn = conf.connectDB();

        String sql = "SELECT C_id, C_name, C_phone FROM tbl_customers";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        javax.swing.table.DefaultTableModel model =
            new javax.swing.table.DefaultTableModel(
                new Object[]{"ID", "Name", "Phone"}, 0
            );

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("C_id"),
                rs.getString("C_name"),
                rs.getString("C_phone")
            });
        }

        jTable1.setModel(model);

        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}

private void loadOrderData() {
    try {
        config conf = new config();
        Connection conn = conf.connectDB();

        PreparedStatement pst = conn.prepareStatement(
            "SELECT * FROM tbl_orders WHERE O_id=?"
        );
        pst.setInt(1, orderId);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            oldCustomerId = rs.getInt("C_id");
            oldServiceId = rs.getInt("S_id");
            oldWeight = rs.getDouble("weight_kg");
            oldStatus = rs.getString("O_status");

            PreparedStatement pstCust = conn.prepareStatement(
                "SELECT C_name FROM tbl_customers WHERE C_id=?"
            );
            pstCust.setInt(1, oldCustomerId);
            ResultSet rsCust = pstCust.executeQuery();

            if (rsCust.next()) {
                txtCustomer.setText(oldCustomerId + " - " + rsCust.getString("C_name"));
            }

            for (int i = 0; i < sdata.getItemCount(); i++) {
                if (sdata.getItemAt(i).startsWith(oldServiceId + " -")) {
                    sdata.setSelectedIndex(i);
                }
            }

            txtweight.setText(String.valueOf(oldWeight));
            stat.setSelectedItem(oldStatus);
        }

        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }
}
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cust = new javax.swing.JLabel();
        cphone = new javax.swing.JLabel();
        weight = new javax.swing.JLabel();
        saveb = new javax.swing.JButton();
        cancelb = new javax.swing.JButton();
        txtweight = new javax.swing.JTextField();
        ostat = new javax.swing.JLabel();
        stat = new javax.swing.JComboBox<>();
        sdata = new javax.swing.JComboBox<>();
        pbtn = new javax.swing.JLabel();
        txtCustomer = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText(" Order Form");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, 35));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 70));

        cust.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        cust.setText("Customer :");
        jPanel1.add(cust, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 440, 110, 50));

        cphone.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        cphone.setText("Service Type :");
        jPanel1.add(cphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 170, -1));

        weight.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        weight.setText("Weight (kg) :");
        jPanel1.add(weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 597, -1, 40));

        saveb.setBackground(new java.awt.Color(255, 255, 255));
        saveb.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        saveb.setText("Save");
        saveb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebActionPerformed(evt);
            }
        });
        jPanel1.add(saveb, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 770, 128, 56));

        cancelb.setBackground(new java.awt.Color(255, 255, 255));
        cancelb.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        cancelb.setText("Cancel");
        cancelb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbActionPerformed(evt);
            }
        });
        jPanel1.add(cancelb, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 770, 128, 56));

        txtweight.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtweight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtweightActionPerformed(evt);
            }
        });
        jPanel1.add(txtweight, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 600, 240, 40));

        ostat.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        ostat.setText("Order Status :");
        jPanel1.add(ostat, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 680, -1, -1));

        stat.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        stat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        stat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statActionPerformed(evt);
            }
        });
        jPanel1.add(stat, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 680, -1, -1));

        sdata.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        sdata.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        sdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdataActionPerformed(evt);
            }
        });
        jPanel1.add(sdata, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, -1, -1));

        pbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refreshbtn (1) (2).png"))); // NOI18N
        pbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pbtnMouseClicked(evt);
            }
        });
        jPanel1.add(pbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, 60));
        jPanel1.add(txtCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 240, 40));

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 540, 250));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 260, 40));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton1.setText("SEARCH");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void savebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebActionPerformed
        if (txtweight.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill all fields");
            return;
        }

        if (txtCustomer.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Select a customer");
        return;
        }

        int customerId = Integer.parseInt(txtCustomer.getText().split(" - ")[0]);
        int serviceId = Integer.parseInt(sdata.getSelectedItem().toString().split(" - ")[0]);
        double weight = Double.parseDouble(txtweight.getText());
        String status = stat.getSelectedItem().toString();

        if (orderId != null) {

            if (customerId == oldCustomerId && serviceId == oldServiceId
                && weight == oldWeight && status.equals(oldStatus)) {
                JOptionPane.showMessageDialog(this, "No changes detected");
                return;
            }
        }

        try {
            config conf = new config();
            Connection conn = conf.connectDB();

            PreparedStatement pstPrice = conn.prepareStatement(
                "SELECT service_price FROM tbl_services WHERE S_id=?"
            );
            pstPrice.setInt(1, serviceId);
            ResultSet rs = pstPrice.executeQuery();
            rs.next();
            double price = rs.getDouble(1);
            double total = price * weight;

            if (orderId == null) {

                PreparedStatement pst = conn.prepareStatement(
                    "INSERT INTO tbl_orders (C_id, S_id, weight_kg, total_amount, order_date, P_status, O_status) " +
                    "VALUES (?,?,?,?,?,?,?)"
                );
                pst.setInt(1, customerId);
                pst.setInt(2, serviceId);
                pst.setDouble(3, weight);
                pst.setDouble(4, total);
                pst.setString(5, LocalDate.now().toString());
                pst.setString(6, PStatus);
                pst.setString(7, status);
                pst.executeUpdate();

                LogService.logAction(Session.getInstance().getId(), "Added Order for Customer ID: " + customerId);

                JOptionPane.showMessageDialog(this, "Order Added Successfully");
            } else {
                PreparedStatement pst = conn.prepareStatement(
                "UPDATE tbl_orders " +"SET C_id=?, S_id=?, weight_kg=?, total_amount=?, P_status=?, O_status=? " + "WHERE O_id=?"
                );

                pst.setInt(1, customerId);
                pst.setInt(2, serviceId);
                pst.setDouble(3, weight);
                pst.setDouble(4, total);
                pst.setString(5, PStatus); 
                pst.setString(6, status);
                pst.setInt(7, orderId);

                pst.executeUpdate();

                LogService.logAction(Session.getInstance().getId(), "Updated Order ID: " + orderId);

                JOptionPane.showMessageDialog(this, "Order Updated Successfully");
            }

            conn.close();

            orderPanel.loadOrder();
            orderPanel.dashboard.setVisible(true);
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

    }//GEN-LAST:event_savebActionPerformed

    private void cancelbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbActionPerformed

        this.dispose();
        orderPanel.dashboard.setVisible(true);

    }//GEN-LAST:event_cancelbActionPerformed

    private void txtweightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtweightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtweightActionPerformed

    private void statActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statActionPerformed

    private void sdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sdataActionPerformed

    private void pbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pbtnMouseClicked
       loadOrderData();
    }//GEN-LAST:event_pbtnMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    int viewRow = jTable1.getSelectedRow();
    if (viewRow < 0) return;

    int row = jTable1.convertRowIndexToModel(viewRow);

    String customerId = jTable1.getModel().getValueAt(row, 0).toString();
    String customerName = jTable1.getModel().getValueAt(row, 1).toString();

    txtCustomer.setText(customerId + " - " + customerName);
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(Orderform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Orderform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Orderform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Orderform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelb;
    private javax.swing.JLabel cphone;
    private javax.swing.JLabel cust;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel ostat;
    private javax.swing.JLabel pbtn;
    private javax.swing.JButton saveb;
    private javax.swing.JComboBox<String> sdata;
    private javax.swing.JComboBox<String> stat;
    private javax.swing.JTextField txtCustomer;
    private javax.swing.JTextField txtweight;
    private javax.swing.JLabel weight;
    // End of variables declaration//GEN-END:variables
}
