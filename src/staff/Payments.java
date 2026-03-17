
package staff;

import config.LogService;
import config.Session;
import config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;



public class Payments extends javax.swing.JFrame {
    
private String mode; 
private int paymentId = -1;
private StaffDashboard dashboard;
private double originalAmount = 0;


public Payments(String mode, int paymentId, StaffDashboard dashboard) {
    initComponents();
    this.mode = mode;
    this.paymentId = paymentId;
    this.dashboard = dashboard;

    setupTable();
    loadOrders();

    if (mode.equals("UPDATE")) {
        loadPaymentData();
    }
    
    setLocationRelativeTo(null);
}

    private void setupTable() {

    javax.swing.table.DefaultTableModel model =
            new javax.swing.table.DefaultTableModel();

    model.setColumnIdentifiers(new String[]{
        "Order ID", "Customer", "Total Amount", "Payment Status"
    });

    jTable1.setModel(model);
}
    
private void loadOrders() {
    try {
        Connection conn = new config().connectDB();

        String sql =
            "SELECT o.O_id, c.C_name, o.total_amount, o.P_status " +
            "FROM tbl_orders o " +
            "JOIN tbl_customers c ON o.C_id = c.C_id";

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("O_id"),
                rs.getString("C_name"),
                rs.getDouble("total_amount"),
                rs.getString("P_status")
            });
        }

        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}

 private void loadPaymentData() {
    try {
        Connection conn = new config().connectDB();

        PreparedStatement pst = conn.prepareStatement(
            "SELECT p.O_id, p.amount_paid, c.C_name " +
            "FROM tbl_payment p " +
            "JOIN tbl_orders o ON p.O_id = o.O_id " +
            "JOIN tbl_customers c ON o.C_id = c.C_id " +
            "WHERE p.P_id=?"
        );

        pst.setInt(1, paymentId);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            jTextField2.setText(rs.getString("O_id"));
            jTextField3.setText(rs.getString("C_name"));
            jTextField5.setText(rs.getString("amount_paid"));

            originalAmount = rs.getDouble("amount_paid");
        }

        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}
 

 
  private void showReceiptPreview(
        int orderId,
        String customer,
        double total,
        double paid,
        double changeAmount
) {

    String receiptText =
        "------------------------------\n" +
        "        PAYMENT RECEIPT\n" +
        "------------------------------\n" +
        "Order ID: " + orderId + "\n" +
        "Customer: " + customer + "\n" +
        "Date: " + java.time.LocalDate.now() + "\n\n" +
        "Total Amount : ₱" + String.format("%.2f", total) + "\n" +
        "Amount Paid  : ₱" + String.format("%.2f", paid) + "\n" +
        "Change       : ₱" + String.format("%.2f", changeAmount) + "\n\n" +
        "Status: PAID\n" +
        "------------------------------\n" +
        "Thank you for your purchase!\n";

    receipt r = new receipt(
        receiptText,
        () -> {
            JOptionPane.showMessageDialog(this, "Payment Added Successfully!");
            this.dispose();
            dashboard.setVisible(true);
        }
    );

    r.setVisible(true);
}
  
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        psbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SAVE = new javax.swing.JButton();
        CANCEL = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        pbtn = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        change = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Payment Form");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 724, -1));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 249, 40));

        psbtn.setBackground(new java.awt.Color(255, 255, 255));
        psbtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        psbtn.setText("SEARCH");
        psbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psbtnActionPerformed(evt);
            }
        });
        jPanel1.add(psbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 101, 40));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 162, 553, 160));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("Selected Order ID :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 349, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setText("Customer :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 389, -1, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("Total Amount :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 429, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setText("Amount Paid :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, 50));

        SAVE.setBackground(new java.awt.Color(255, 255, 255));
        SAVE.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        SAVE.setText("SAVE");
        SAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAVEActionPerformed(evt);
            }
        });
        jPanel1.add(SAVE, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 580, 110, 40));

        CANCEL.setBackground(new java.awt.Color(255, 255, 255));
        CANCEL.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        CANCEL.setText("CANCEL");
        CANCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CANCELActionPerformed(evt);
            }
        });
        jPanel1.add(CANCEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 580, 110, 40));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 150, 30));

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 392, 150, 30));

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 432, 150, 30));

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 472, 150, 30));

        pbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refreshbtn (1) (2).png"))); // NOI18N
        pbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pbtnMouseClicked(evt);
            }
        });
        jPanel1.add(pbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 60));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel6.setText("Change :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        change.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });
        jPanel1.add(change, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CANCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CANCELActionPerformed
    this.dispose();
    dashboard.setVisible(true);
    }//GEN-LAST:event_CANCELActionPerformed

    private void SAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAVEActionPerformed
        if (jTextField2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select an order first!");
            return;
        }

        double newAmount;
        double totalAmount;

        try {
            newAmount = Double.parseDouble(jTextField5.getText());
            totalAmount = Double.parseDouble(jTextField4.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid amount!");
            return;
        }

        if (newAmount < totalAmount) {
            JOptionPane.showMessageDialog(
                this,
                "Insufficient amount paid!\nTotal Amount: " + totalAmount,
                "Payment Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        try {
            config conf = new config();
            Connection conn = conf.connectDB();

            if (mode.equals("UPDATE")) {

                if (newAmount == originalAmount) {
                    JOptionPane.showMessageDialog(this, "No changes detected!");
                    return;
                }

                PreparedStatement pst = conn.prepareStatement(
                    "UPDATE tbl_payment SET amount_paid=? WHERE P_id=?"
                );
                pst.setDouble(1, newAmount);
                pst.setInt(2, paymentId);
                pst.executeUpdate();

                PreparedStatement pstOrder = conn.prepareStatement(
                "UPDATE tbl_orders SET P_status='Paid' WHERE O_id=?"
                );
                pstOrder.setInt(1, Integer.parseInt(jTextField2.getText()));
                pstOrder.executeUpdate();

                JOptionPane.showMessageDialog(this, "Payment Updated Successfully!");
        
        }
            
        else if (mode.equals("ADD")) {

        int orderId = Integer.parseInt(jTextField2.getText());
        double paidAmount = Double.parseDouble(jTextField5.getText());
        double changeAmount = paidAmount - totalAmount;

        PreparedStatement pst = conn.prepareStatement(
        "INSERT INTO tbl_payment (O_id, amount_paid, payment_date) " +
        "VALUES (?, ?, datetime('now', 'localtime'))"
         );
        
        pst.setInt(1, orderId);
        pst.setDouble(2, paidAmount);
        pst.executeUpdate();

        PreparedStatement pstOrder = conn.prepareStatement(
        "UPDATE tbl_orders SET P_status='Paid' WHERE O_id=?"
        );
        pstOrder.setInt(1, orderId);
        pstOrder.executeUpdate();

        showReceiptPreview(
         orderId,
         jTextField3.getText(),
         totalAmount,
         paidAmount,
         changeAmount
       );
       }
        conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_SAVEActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void psbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psbtnActionPerformed
    String search = jTextField1.getText().trim();

    try {
        Connection conn = new config().connectDB();

        PreparedStatement pst = conn.prepareStatement(
            "SELECT o.O_id, c.C_name, o.total_amount, o.P_status " +
            "FROM tbl_orders o " +
            "JOIN tbl_customers c ON o.C_id = c.C_id " +
            "WHERE CAST(o.O_id AS TEXT) LIKE ? " +
            "OR c.C_name LIKE ? " +
            "OR CAST(o.total_amount AS TEXT) LIKE ? " +
            "OR o.P_status LIKE ?"
        );

        String keyword = "%" + search + "%";
        pst.setString(1, keyword);
        pst.setString(2, keyword);
        pst.setString(3, keyword);
        pst.setString(4, keyword);

        ResultSet rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("O_id"),
                rs.getString("C_name"),
                rs.getDouble("total_amount"),
                rs.getString("P_status")
            });
        }

        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }//GEN-LAST:event_psbtnActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        try {
        double total = Double.parseDouble(jTextField4.getText());
        double paid = Double.parseDouble(jTextField5.getText());

        double changeAmount = paid - total;

        if (changeAmount < 0) {
            change.setText("0.00");
        } else {
            change.setText(String.format("%.2f", changeAmount));
        }

    } catch (Exception e) {
        change.setText("");
    }
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    int row = jTable1.getSelectedRow();

    String status = jTable1.getValueAt(row, 3).toString();


    if (status.equalsIgnoreCase("Paid")) {
        JOptionPane.showMessageDialog(
            this,
            "This order is already PAID.\nYou cannot add another payment.",
            "Payment Not Allowed",
            JOptionPane.WARNING_MESSAGE
        );


        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        change.setText("");

        return;
    }


    jTextField2.setText(jTable1.getValueAt(row, 0).toString());
    jTextField3.setText(jTable1.getValueAt(row, 1).toString());
    jTextField4.setText(jTable1.getValueAt(row, 2).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void pbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pbtnMouseClicked
        loadOrders();

    }//GEN-LAST:event_pbtnMouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeActionPerformed

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
            java.util.logging.Logger.getLogger(Payments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CANCEL;
    private javax.swing.JButton SAVE;
    private javax.swing.JTextField change;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel pbtn;
    private javax.swing.JButton psbtn;
    // End of variables declaration//GEN-END:variables
}
