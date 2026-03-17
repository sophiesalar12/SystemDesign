
package staff;

import config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PaymentPanel extends javax.swing.JPanel {

private DefaultTableModel model;


public PaymentPanel() {
    initComponents();

    model = new DefaultTableModel(
        null,
        new String[]{"Payment ID", "Order ID", "Customer", "Amount Paid", "Payment Date"}
    );

    jTable1.setModel(model);

    loadPayments();
}

public void loadPayments() {
    try {
        config conf = new config();
        Connection conn = conf.connectDB();

        PreparedStatement pst = conn.prepareStatement(
        "SELECT p.P_id, p.O_id, c.C_name, p.amount_paid," +
        "strftime('%Y-%m-%d', p.payment_date) AS payment_date " +
        "FROM tbl_payment p " +
        "JOIN tbl_orders o ON p.O_id = o.O_id " +
        "JOIN tbl_customers c ON o.C_id = c.C_id"
        );
        ResultSet rs = pst.executeQuery();

        model.setRowCount(0);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("P_id"),
                rs.getInt("O_id"),
                rs.getString("C_name"),
                rs.getInt("amount_paid"),
                rs.getString("payment_date")
            });
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
        Padd = new javax.swing.JButton();
        Pupdate = new javax.swing.JButton();
        pbtn = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Psearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Padd.setBackground(new java.awt.Color(102, 153, 255));
        Padd.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Padd.setText("ADD");
        Padd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaddActionPerformed(evt);
            }
        });
        jPanel1.add(Padd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 100, 40));

        Pupdate.setBackground(new java.awt.Color(102, 153, 255));
        Pupdate.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Pupdate.setText("UPDATE");
        Pupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PupdateActionPerformed(evt);
            }
        });
        jPanel1.add(Pupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 100, 40));

        pbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refreshbtn (1) (2).png"))); // NOI18N
        pbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pbtnMouseClicked(evt);
            }
        });
        jPanel1.add(pbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, 60));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 240, 41));

        Psearch.setBackground(new java.awt.Color(102, 153, 255));
        Psearch.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Psearch.setText("SEARCH");
        Psearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PsearchActionPerformed(evt);
            }
        });
        jPanel1.add(Psearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, -1, 41));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 657, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pbtnMouseClicked
     loadPayments();
        
    }//GEN-LAST:event_pbtnMouseClicked

    private void PupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PupdateActionPerformed
        
    int row = jTable1.getSelectedRow();

    if (row < 0) {
        JOptionPane.showMessageDialog(this, "Select payment to update!");
        return;
    }

    int paymentId = (int) model.getValueAt(row, 0);

    StaffDashboard dash = (StaffDashboard) javax.swing.SwingUtilities.getWindowAncestor(this);

    dash.setVisible(false);

    Payments form = new Payments("UPDATE", paymentId, dash);
    form.setVisible(true);
    
    }//GEN-LAST:event_PupdateActionPerformed

    private void PaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaddActionPerformed
    StaffDashboard dash = (StaffDashboard) javax.swing.SwingUtilities.getWindowAncestor(this);

    dash.setVisible(false);

    Payments form = new Payments("ADD", -1, dash);
    form.setVisible(true);
    }//GEN-LAST:event_PaddActionPerformed

    private void PsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PsearchActionPerformed

    String keyword = jTextField1.getText();

    try {
        config conf = new config();
        Connection conn = conf.connectDB();

        PreparedStatement pst = conn.prepareStatement(
        "SELECT p.P_id, p.O_id, c.C_name, p.amount_paid, " + 
        "strftime('%Y-%m-%d', p.payment_date) AS payment_date " +        
        "FROM tbl_payment p " +
        "JOIN tbl_orders o ON p.O_id = o.O_id " +
        "JOIN tbl_customers c ON o.C_id = c.C_id " +
        "WHERE CAST(p.O_id AS TEXT) LIKE ? " +
        "OR c.C_name LIKE ? " +
        "OR CAST(p.amount_paid AS TEXT) LIKE ? " +
        "OR strftime('%Y-%m-%d', p.payment_date) LIKE ?"
        );

        String like = "%" + keyword + "%";
        for (int i = 1; i <= 4; i++) {
            pst.setString(i, like);
        }

        ResultSet rs = pst.executeQuery();

        model.setRowCount(0);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("P_id"),
                rs.getInt("O_id"),
                rs.getString("C_name"),
                rs.getInt("amount_paid"),
                rs.getString("payment_date")
            });
        }

        conn.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }
    }//GEN-LAST:event_PsearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Padd;
    private javax.swing.JButton Psearch;
    private javax.swing.JButton Pupdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel pbtn;
    // End of variables declaration//GEN-END:variables
}
